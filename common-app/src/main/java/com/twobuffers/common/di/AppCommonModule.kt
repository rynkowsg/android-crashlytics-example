/*
 * Copyright 2019 Two Buffers Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("unused")

package com.twobuffers.common.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.coroutineScope
import com.twobuffers.base.di.ApplicationScoped
import com.twobuffers.base.di.ProcessLifetime
import com.twobuffers.base.utils.AppCoroutineDispatchers
import com.twobuffers.base.utils.AppRxSchedulers
import com.twobuffers.base.utils.Logger
import com.twobuffers.base.utils.LoggerImpl
import com.twobuffers.common.appinitializers.AppInitializers
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import javax.inject.Named
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.asCoroutineDispatcher
import org.apache.commons.lang3.concurrent.BasicThreadFactory

@Module(includes = [
    AppInitializers.DiModule::class,
    AppCommonModule.BindingModule::class
])
class AppCommonModule {
    @Provides
    @ApplicationScoped
    fun provideRxSchedulers(): AppRxSchedulers =
        AppRxSchedulers(
            io = Schedulers.io(),
            computation = Schedulers.computation(),
            main = AndroidSchedulers.mainThread(),
            newThread = Schedulers.newThread()
        )

    @Provides
    @ApplicationScoped
    fun provideCoroutineDispatchers() = AppCoroutineDispatchers(
        io = Dispatchers.IO,
        computation = Dispatchers.Default,
        main = Dispatchers.Main
    )

    // https://stackoverflow.com/questions/6113746/naming-threads-and-thread-pools-of-executorservice/6126320#6126320
    @Provides
    @ApplicationScoped
    @Named("SINGLE_THREAD")
    fun provideSingleThreadFactory(): ThreadFactory =
        BasicThreadFactory.Builder()
            .namingPattern("single-%d")
            .daemon(true)
            .priority(Thread.MAX_PRIORITY)
            .build()

    /** Every time a new dispatcher
     *
     * It is is very important to keep it unscoped and never linked to activity,
     * application or anything else.
     */
    @Provides
    @Named("SINGLE_THREAD")
    fun provideSingleThreadCoroutineDispatcher(
        @Named("SINGLE_THREAD") threadFactory: ThreadFactory
    ): CoroutineDispatcher =
        Executors.newSingleThreadExecutor(threadFactory).asCoroutineDispatcher()

    @Provides
    @Named("GLOBAL")
    fun provideGlobalScope(): CoroutineScope = GlobalScope

    @Provides
    @ProcessLifetime
    fun provideProcessLifetimeScope(): CoroutineScope =
        ProcessLifecycleOwner.get().lifecycle.coroutineScope

    @Provides
    @ApplicationScoped
    fun provideGlobalCompositeDisposable() = CompositeDisposable()

    @Module
    abstract class BindingModule {

        /** Exposes [Application] as an injectable [Context].
         *
         * One of the advantages of Dagger.Android is that your Application and
         * Activities are provided into the dependency graph. It means that it
         * is possible to bind [Application] object as a [Context] in the
         * application scope. From that point [Context] is available in all
         * Dagger components. */
        @Binds
        @ApplicationScoped
        abstract fun bindContext(application: Application): Context

        @Binds
        @ApplicationScoped
        abstract fun provideLogger(bind: LoggerImpl): Logger
    }
}
