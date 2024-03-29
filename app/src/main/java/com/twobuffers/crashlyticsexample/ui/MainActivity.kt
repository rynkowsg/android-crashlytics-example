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

package com.twobuffers.crashlyticsexample.ui

import android.os.Bundle
import com.crashlytics.android.Crashlytics
import com.twobuffers.base.utils.Logger
import com.twobuffers.crashlyticsexample.BuildConfig
import com.twobuffers.crashlyticsexample.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.build_flavour_txt
import kotlinx.android.synthetic.main.activity_main.default_crash_btn
import kotlinx.android.synthetic.main.activity_main.flavour_crash_btn

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var logger: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCrashButtons()
    }

    private fun setupCrashButtons() {
        val flavour = BuildConfig.FLAVOR.capitalize()
        build_flavour_txt.text = "$flavour app"
        default_crash_btn.setOnClickListener {
            logger.i("default_crash_btn clicked!")
            Crashlytics.getInstance().crash() // Force a crash
        }
        flavour_crash_btn.text = "$flavour crash!"
        flavour_crash_btn.setOnClickListener {
            logger.i("flavour_crash_btn clicked!")
            throw RuntimeException("$flavour exception happened.")
        }
        logger.i("Testing buttons ready.")
    }
}
