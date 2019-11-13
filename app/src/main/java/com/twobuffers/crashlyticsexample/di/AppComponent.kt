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

package com.twobuffers.crashlyticsexample.di

import com.twobuffers.base.di.ApplicationScoped
import com.twobuffers.common.di.AppCommonModule
import com.twobuffers.crashlyticsexample.App
import com.twobuffers.crashlyticsexample.ui.MainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@ApplicationScoped
@Component(modules = [
    AppModule::class,
    AppCommonModule::class,
    MainModule::class,
    AndroidInjectionModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: App): AppComponent
    }
}

fun App.createComponent() = DaggerAppComponent.factory().create(this)
