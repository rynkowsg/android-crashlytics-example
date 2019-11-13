// ktlint-disable max-line-length

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

package com.twobuffers.buildsrc

import org.gradle.api.JavaVersion

object Versions {
    const val JAVA_VERSION_STR = "1.8"
    val JAVA_VERSION = JavaVersion.VERSION_1_8

    const val spotless = "3.25.0"
    const val ktlint = "0.31.0"
    const val versions = "0.27.0"
}

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:3.5.0"
    const val dexcountGradlePlugin = "com.getkeepsafe.dexcount:dexcount-gradle-plugin:1.0.0"
    const val playPublisherPlugin = "com.github.triplet.gradle:play-publisher:2.3.0"
    // https://plugins.gradle.org/plugin/com.diffplug.gradle.spotless
    const val spotlessGradlePlugin = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.spotless}"

    // 4.3.3 doesn't work with Crashlytics - for some reason I couldn't integrate Crashlytics when I was using 4.3.3
    const val googlePlayServicesPlugin = "com.google.gms:google-services:4.3.2"

    const val threeTenBp = "org.threeten:threetenbp:1.4.0"
    const val threeTenBpNoTzdb = "$threeTenBp:no-tzdb"
    const val threeTenAbp = "com.jakewharton.threetenabp:threetenabp:1.2.1"

    const val timber = "com.jakewharton.timber:timber:4.7.1"

    const val junit = "junit:junit:4.12"
    const val robolectric = "org.robolectric:robolectric:4.3"

    object Google {
        const val material = "com.google.android.material:material:1.0.0" // latest: 1.1.0-alpha09, stable: 1.0.0

        object Gps {
            const val adsIdentifier = "com.google.android.gms:play-services-ads-identifier:17.0.0"
        }
    }

    object Kotlin {
        private const val version = "1.3.50"
        const val stdlib7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        const val stdlib8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val stdlib = stdlib8
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
        const val testJunit = "org.jetbrains.kotlin:kotlin-test-junit:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    // List of libraries providing immutable collections: https://www.jishuwen.com/d/28FX
    const val kotlinCollectionsImmutable = "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3"
    const val kotlinCollectionsImmutableJvm = "org.jetbrains.kotlinx:kotlinx-collections-immutable-jvm:0.3"
    const val paguro = "org.organicdesign:Paguro:3.1.2"

    object Coroutines {
        private const val version = "1.3.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val rx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        const val debug = "org.jetbrains.kotlinx:kotlinx-coroutines-debug:$version"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.1.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0-beta05" // stable: 1.0.0
        const val cardview = "androidx.cardview:cardview:1.0.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta2"
        const val legacySupportV4 = "androidx.legacy:legacy-support-v4:1.0.0"
        const val coreKtx = "androidx.core:core-ktx:1.1.0" // stable: 1.2.0-alpha04
        const val annotation = "androidx.annotation:annotation:1.1.0"

        object Navigation {
            private const val version = "2.2.0-rc02" //  latest: 2.2.0-rc02, stable: 2.1.0
            const val fragment = "androidx.navigation:navigation-fragment:$version"
            const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgsGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Activity {
            private const val version = "1.1.0-rc02" // latest: 1.1.0-rc02, stable: 1.0.0
            const val activity = "androidx.activity:activity:$version"
            const val activityKtx = "androidx.activity:activity-ktx:$version"
        }

        object Fragment {
            private const val version = "1.2.0-rc01" // latest: 1.2.0-rc01, stable: 1.1.0
            const val fragment = "androidx.fragment:fragment:$version"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
        }

        object Lifecycle {
            private const val version = "2.2.0-rc02" // latest: 2.2.0-rc02, stable: 2.1.0
            // ViewModel and LiveData
            const val extensions = "androidx.lifecycle:lifecycle-extensions:$version"
            const val process = "androidx.lifecycle:lifecycle-process:$version"
            // alternatively - just ViewModel
            const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel:$version"
            // alternatively - just ViewModel (for Kotlin)
            const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            // alternatively - just LiveData
            const val livedata = "androidx.lifecycle:lifecycle-livedata:$version"
            // alternatively - Lifecycles only (no ViewModel or LiveData). Some UI
            //     AndroidX libraries use this lightweight import for Lifecycle
            const val runtime = "androidx.lifecycle:lifecycle-runtime:$version"
            const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            // Annotations compiler (when to use: https://stackoverflow.com/a/58286301/3023806)
            const val compiler = "androidx.lifecycle:lifecycle-compiler:$version"
            // alternately - if using Java8, use the following instead of lifecycle-compiler
            const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"
            // optional - ReactiveStreams support for LiveData
            const val reactivestreams = "androidx.lifecycle:lifecycle-reactivestreams:$version"
            // optional - ReactiveStreams support for LiveData (for Kotlin)
            const val reactivestreamsKtx = "androidx.lifecycle:lifecycle-reactivestreams-ktx:$version"
            // optional - Test helpers for LiveData
            const val coreTesting = "androidx.arch.core:core-testing:$version"
        }

        object Test {
            private const val version = "1.2.0" // latest: 1.3.0-alpha02
            const val core = "androidx.test:core:$version"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"
            const val truth = "androidx.test.ext:truth:$version"

            object Espresso {
                private const val version = "3.2.0" // latest: 3.3.0-alpha02
                const val core = "androidx.test.espresso:espresso-core:$version"
                const val contrib = "androidx.test.espresso:espresso-contrib:$version"
                const val idlingResource = "androidx.test.espresso:espresso-idling-resource:$version"
            }

            const val junit = "androidx.test.ext:junit:1.1.1"
        }
    }

    object RxJava {
        const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.13"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
        const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
    }

    object Dagger {
        private const val version = "2.25.2"
        const val dagger = "com.google.dagger:dagger:$version"
        const val android = "com.google.dagger:dagger-android:$version"
        const val androidSupport = "com.google.dagger:dagger-android-support:$version"
        const val compiler = "com.google.dagger:dagger-compiler:$version"
        const val androidProcessor = "com.google.dagger:dagger-android-processor:$version"
    }

    const val jsr250Api = "javax.annotation:jsr250-api:1.0" // for Dagger

    object Anko {
        private const val version = "0.10.8"
        const val common = "org.jetbrains.anko:anko-common:$version"
        const val coroutines = "org.jetbrains.anko:anko-coroutines:$version"
    }

    // On version bump up, keep in mind about updating `MyBaseMvRxFragment`.
    const val mvrx = "com.airbnb.android:mvrx:1.3.0"

    object Epoxy {
        private const val version = "3.7.0"
        const val epoxy = "com.airbnb.android:epoxy:$version"
        const val paging = "com.airbnb.android:epoxy-paging:$version"
        const val dataBinding = "com.airbnb.android:epoxy-databinding:$version"
        const val processor = "com.airbnb.android:epoxy-processor:$version"
    }

    object AssistedInject {
        private const val version = "0.5.1"
        const val annotationDagger2 = "com.squareup.inject:assisted-inject-annotations-dagger2:$version"
        const val processorDagger2 = "com.squareup.inject:assisted-inject-processor-dagger2:$version"
        const val assistedInjectAnnotations = "com.squareup.inject:assisted-inject-annotations:$version"
        const val assistedInjectProcessor = "com.squareup.inject:assisted-inject-processor:$version"
        const val inflationInject = "com.squareup.inject:inflation-inject:$version"
        const val inflationInjectProcessor = "com.squareup.inject:inflation-inject-processor:$version"
    }

    object Aws {
        private const val version = "2.16.0" // latest: 2.16.1 (crashes)
        const val core = "com.amazonaws:aws-android-sdk-core:$version"
        const val iot = "com.amazonaws:aws-android-sdk-iot:$version"
        const val mobileClient = "com.amazonaws:aws-android-sdk-mobile-client:$version"
    }

    object Moshi {
        private const val version = "1.9.1"
        const val moshi = "com.squareup.moshi:moshi:$version"
        const val moshiAdapters = "com.squareup.moshi:moshi-adapters:$version"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:$version"
        const val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    }

    object Apache {
        const val commonsLang3 = "org.apache.commons:commons-lang3:3.9"
        const val commonsCollections4 = "org.apache.commons:commons-collections4:4.4"
    }

    object Guava {
        private const val versionJre = "28.1-jre"
        private const val versionAndroid = "28.1-android"
        const val guava = "com.google.guava:guava:$versionAndroid"
        const val guavaTestlib = "com.google.guava:guava-testlib:$versionAndroid"
    }

    const val zxingCore = "com.google.zxing:core:3.3.2"
    const val zxingAndroidEmbedded = "com.journeyapps:zxing-android-embedded:3.6.0" // latest: 4.0.2 (but minSdk required is 24)

    object Glide {
        private const val version = "4.10.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val glideCompiler = "com.github.bumptech.glide:compiler:$version"
    }

    object Coil {
        private const val version = "0.8.0"
        const val coil = "io.coil-kt:coil:$version"
    }

    const val rxPermissions = "com.github.tbruyelle:rxpermissions:0.10.2"

    // rxpermission uses rxpermissions, but provides a bit simplified API
    const val rxPermission = "com.vanniktech:rxpermission:0.7.0"

    object Crashlytics {
        const val gradlePlugin = "io.fabric.tools:gradle:1.31.2"
        const val crashlytics = "com.crashlytics.sdk.android:crashlytics:2.10.1"
        const val crashlyticsNdk = "com.crashlytics.sdk.android:crashlytics-ndk:2.1.1"
    }

    object Firebase {
        const val analytics = "com.google.firebase:firebase-analytics:17.2.1"
        const val auth = "com.google.firebase:firebase-auth:19.1.0"
        const val firestore = "com.google.firebase:firebase-firestore:21.3.0"
    }
}
