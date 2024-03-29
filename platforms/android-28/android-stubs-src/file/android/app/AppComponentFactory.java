/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.app;

import android.content.Intent;
import android.content.ContentProvider;

/**
 * Interface used to control the instantiation of manifest elements.
 *
 * @see #instantiateApplication
 * @see #instantiateActivity
 * @see #instantiateService
 * @see #instantiateReceiver
 * @see #instantiateProvider
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AppComponentFactory {

public AppComponentFactory() { throw new RuntimeException("Stub!"); }

/**
 * Allows application to override the creation of the application object. This can be used to
 * perform things such as dependency injection or class loader changes to these
 * classes.
 * <p>
 * This method is only intended to provide a hook for instantiation. It does not provide
 * earlier access to the Application object. The returned object will not be initialized
 * as a Context yet and should not be used to interact with other android APIs.
 *
 * @param cl        The default classloader to use for instantiation.
 * This value must never be {@code null}.
 * @param className The class to be instantiated.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.app.Application instantiateApplication(@androidx.annotation.RecentlyNonNull java.lang.ClassLoader cl, @androidx.annotation.RecentlyNonNull java.lang.String className) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Allows application to override the creation of activities. This can be used to
 * perform things such as dependency injection or class loader changes to these
 * classes.
 * <p>
 * This method is only intended to provide a hook for instantiation. It does not provide
 * earlier access to the Activity object. The returned object will not be initialized
 * as a Context yet and should not be used to interact with other android APIs.
 *
 * @param cl        The default classloader to use for instantiation.
 * This value must never be {@code null}.
 * @param className The class to be instantiated.
 * This value must never be {@code null}.
 * @param intent    Intent creating the class.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.app.Activity instantiateActivity(@androidx.annotation.RecentlyNonNull java.lang.ClassLoader cl, @androidx.annotation.RecentlyNonNull java.lang.String className, @androidx.annotation.RecentlyNullable android.content.Intent intent) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Allows application to override the creation of receivers. This can be used to
 * perform things such as dependency injection or class loader changes to these
 * classes.
 *
 * @param cl        The default classloader to use for instantiation.
 * This value must never be {@code null}.
 * @param className The class to be instantiated.
 * This value must never be {@code null}.
 * @param intent    Intent creating the class.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.BroadcastReceiver instantiateReceiver(@androidx.annotation.RecentlyNonNull java.lang.ClassLoader cl, @androidx.annotation.RecentlyNonNull java.lang.String className, @androidx.annotation.RecentlyNullable android.content.Intent intent) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Allows application to override the creation of services. This can be used to
 * perform things such as dependency injection or class loader changes to these
 * classes.
 * <p>
 * This method is only intended to provide a hook for instantiation. It does not provide
 * earlier access to the Service object. The returned object will not be initialized
 * as a Context yet and should not be used to interact with other android APIs.
 *
 * @param cl        The default classloader to use for instantiation.
 * This value must never be {@code null}.
 * @param className The class to be instantiated.
 * This value must never be {@code null}.
 * @param intent    Intent creating the class.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.app.Service instantiateService(@androidx.annotation.RecentlyNonNull java.lang.ClassLoader cl, @androidx.annotation.RecentlyNonNull java.lang.String className, @androidx.annotation.RecentlyNullable android.content.Intent intent) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Allows application to override the creation of providers. This can be used to
 * perform things such as dependency injection or class loader changes to these
 * classes.
 * <p>
 * This method is only intended to provide a hook for instantiation. It does not provide
 * earlier access to the ContentProvider object. The returned object will not be initialized
 * with a Context yet and should not be used to interact with other android APIs.
 *
 * @param cl        The default classloader to use for instantiation.
 * This value must never be {@code null}.
 * @param className The class to be instantiated.
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.ContentProvider instantiateProvider(@androidx.annotation.RecentlyNonNull java.lang.ClassLoader cl, @androidx.annotation.RecentlyNonNull java.lang.String className) throws java.lang.ClassNotFoundException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }
}

