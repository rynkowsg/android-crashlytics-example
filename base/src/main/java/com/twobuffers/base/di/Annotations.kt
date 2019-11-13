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

package com.twobuffers.base.di

import javax.inject.Qualifier
import javax.inject.Scope

/**
 * Annotation for [Application] scoped objects.
 *
 * In Dagger, an unscoped component cannot depend on a scoped component. As
 * [AppComponent] is a scoped component (`@Singleton`, we create a custom scope
 * to be used by all activity components. Additionally, a component with
 * a specific scope cannot have a sub component with the same scope.
 */
@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScoped

// TODO: Consider moving ActivityScoped & FragmentScoped.
// Do we really need those in every layer? Maybe not. If so, move it.

/**
 * Annotation for [Activity] scoped objects.
 */
@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScoped

/**
 * Annotation for [Fragment] scoped objects.
 */
@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScoped

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class ProcessLifetime
