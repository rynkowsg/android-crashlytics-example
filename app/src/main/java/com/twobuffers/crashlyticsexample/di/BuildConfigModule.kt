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

package com.twobuffers.crashlyticsexample.di

import com.twobuffers.base.di.TWOBUFFERS_DEBUG
import com.twobuffers.crashlyticsexample.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class BuildConfigModule {
    @Provides
    @Named(TWOBUFFERS_DEBUG)
    fun provideIsDebug(): Boolean = BuildConfig.DEBUG
}
