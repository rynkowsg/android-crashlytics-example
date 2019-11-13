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

package com.twobuffers.base.utils

import javax.inject.Inject
import timber.log.Timber

class LoggerImpl @Inject constructor() : Logger {
    fun setup(debugMode: Boolean) {
        if (debugMode) {
            Timber.plant(TimberDebugTreeWithThreadName())
        }
    }

    override fun plant(tree: SimplifiedTree) {
        Timber.plant(object : Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                tree.log(priority, tag, message, t)
            }
        })
    }

    override fun v(message: String, vararg args: Any?) {
        Timber.v(message, *args)
    }

    override fun v(t: Throwable, message: String, vararg args: Any?) {
        Timber.v(t, message, *args)
    }

    override fun v(t: Throwable) {
        Timber.v(t)
    }

    override fun d(message: String, vararg args: Any?) {
        Timber.d(message, *args)
    }

    override fun d(t: Throwable, message: String, vararg args: Any?) {
        Timber.d(t, message, *args)
    }

    override fun d(t: Throwable) {
        Timber.d(t)
    }

    override fun i(message: String, vararg args: Any?) {
        Timber.i(message, *args)
    }

    override fun i(t: Throwable, message: String, vararg args: Any?) {
        Timber.i(t, message, *args)
    }

    override fun i(t: Throwable) {
        Timber.i(t)
    }

    override fun w(message: String, vararg args: Any?) {
        Timber.w(message, *args)
    }

    override fun w(t: Throwable, message: String, vararg args: Any?) {
        Timber.w(t, message, *args)
    }

    override fun w(t: Throwable) {
        Timber.w(t)
    }

    override fun e(message: String, vararg args: Any?) {
        Timber.e(message, *args)
    }

    override fun e(t: Throwable, message: String, vararg args: Any?) {
        Timber.e(t, message, *args)
    }

    override fun e(t: Throwable) {
        Timber.e(t)
    }

    override fun wtf(message: String, vararg args: Any?) {
        Timber.wtf(message, *args)
    }

    override fun wtf(t: Throwable, message: String, vararg args: Any?) {
        Timber.wtf(t, message, *args)
    }

    override fun wtf(t: Throwable) {
        Timber.wtf(t)
    }
}

/**
 * Special version of [Timber.DebugTree] which is tailored for Timber being wrapped
 * within another class.
 */
private open class WrappedTimberDebugTree : Timber.DebugTree() {
    // Since Tree.getTag is package-private I can't override it.
    // But I can override the `log()` method and use my own `getTag()`.
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, getTag(), message, t)
    }

    /**
     * Provides the tag for the log.
     *
     * The crucial difference compare to Timber.DebugTree.getTag is CALL_STACK_INDEX
     * In original implementation is set to 5, here to 7.
     */
    private fun getTag(): String? {
        val stackTrace = Throwable().stackTrace
        if (stackTrace.size <= CALL_STACK_INDEX) {
            val msg = "Synthetic stacktrace didn't have enough elements: are you using proguard?"
            throw IllegalStateException(msg)
        }
        return createStackElementTag(stackTrace[CALL_STACK_INDEX])
    }

    companion object {
        private const val CALL_STACK_INDEX = 7
    }
}

/**
 * Special version of [Timber.DebugTree] which is tailored for Timber being wrapped
 * within another class.
 */
private class TimberDebugTreeWithThreadName : WrappedTimberDebugTree() {
    override fun createStackElementTag(e: StackTraceElement) =
        String.format(
            "%s [%s]",
            super.createStackElementTag(e),
            Thread.currentThread().name
        )
}
// https://stackoverflow.com/questions/38689399/log-method-name-and-line-number-in-timber/49216400#49216400
// https://stackoverflow.com/questions/38689399/log-method-name-and-line-number-in-timber/38689400#38689400
