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

package com.twobuffers.common.appinitializers

import android.app.Application
import com.twobuffers.base.di.TWOBUFFERS_DEBUG
import com.twobuffers.base.utils.AppInitializer
import com.twobuffers.base.utils.LoggerImpl
import javax.inject.Inject
import javax.inject.Named

class TimberInitializer @Inject constructor(
    @Named(TWOBUFFERS_DEBUG) private val isDebug: Boolean,
    private val logger: LoggerImpl
) : AppInitializer(priority = 1) {
    // Timber is independent component, and it is used everywhere.
    // If some other initializer is executed earlier, logging there will
    // be lost. That's why gets 1 as a priority.

    override fun init(application: Application) = logger.setup(isDebug)
}
