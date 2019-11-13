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

package com.twobuffers.crashlyticsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.crashlytics.android.Crashlytics
import kotlinx.android.synthetic.main.activity_main.build_flavour_txt
import kotlinx.android.synthetic.main.activity_main.default_crash_btn
import kotlinx.android.synthetic.main.activity_main.flavour_crash_btn
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupCrashButtons()
    }

    private fun setupCrashButtons() {
        val flavour = BuildConfig.FLAVOR.capitalize()
        build_flavour_txt.text = "$flavour app"
        default_crash_btn.setOnClickListener {
            Crashlytics.getInstance().crash() // Force a crash
        }
        flavour_crash_btn.text = "$flavour crash!"
        flavour_crash_btn.setOnClickListener {
            throw RuntimeException("$flavour exception happened.")
        }
    }
}
