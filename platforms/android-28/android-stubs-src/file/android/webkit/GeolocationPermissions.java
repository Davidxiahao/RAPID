/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.webkit;

import java.util.Set;

/**
 * This class is used to manage permissions for the WebView's Geolocation
 * JavaScript API.
 *
 * Geolocation permissions are applied to an origin, which consists of the
 * host, scheme and port of a URI. In order for web content to use the
 * Geolocation API, permission must be granted for that content's origin.
 *
 * This class stores Geolocation permissions. An origin's permission state can
 * be either allowed or denied. This class uses Strings to represent
 * an origin.
 *
 * When an origin attempts to use the Geolocation API, but no permission state
 * is currently set for that origin,
 * {@link WebChromeClient#onGeolocationPermissionsShowPrompt(String,GeolocationPermissions.Callback) WebChromeClient.onGeolocationPermissionsShowPrompt()}
 * is called. This allows the permission state to be set for that origin.
 *
 * The methods of this class can be used to modify and interrogate the stored
 * Geolocation permissions at any time.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class GeolocationPermissions {

/**
 * This class should not be instantiated directly, applications must only use
 * {@link #getInstance()} to obtain the instance.
 * Note this constructor was erroneously public and published in SDK levels prior to 16, but
 * applications using it would receive a non-functional instance of this class (there was no
 * way to call createHandler() and createUIHandler(), so it would not work).
 * @hide Only for use by WebViewProvider implementations
 */

GeolocationPermissions() { throw new RuntimeException("Stub!"); }

/**
 * Gets the singleton instance of this class. This method cannot be
 * called before the application instantiates a {@link WebView} instance.
 *
 * @return the singleton {@link GeolocationPermissions} instance
 */

public static android.webkit.GeolocationPermissions getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Gets the set of origins for which Geolocation permissions are stored.
 *
 * @param callback a {@link ValueCallback} to receive the result of this
 *                 request. This object's
 *                 {@link ValueCallback#onReceiveValue(T) onReceiveValue()}
 *                 method will be invoked asynchronously with a set of
 *                 Strings containing the origins for which Geolocation
 *                 permissions are stored.
 */

public void getOrigins(android.webkit.ValueCallback<java.util.Set<java.lang.String>> callback) { throw new RuntimeException("Stub!"); }

/**
 * Gets the Geolocation permission state for the specified origin.
 *
 * @param origin the origin for which Geolocation permission is requested
 * @param callback a {@link ValueCallback} to receive the result of this
 *                 request. This object's
 *                 {@link ValueCallback#onReceiveValue(T) onReceiveValue()}
 *                 method will be invoked asynchronously with a boolean
 *                 indicating whether or not the origin can use the
 *                 Geolocation API.
 */

public void getAllowed(java.lang.String origin, android.webkit.ValueCallback<java.lang.Boolean> callback) { throw new RuntimeException("Stub!"); }

/**
 * Clears the Geolocation permission state for the specified origin.
 *
 * @param origin the origin for which Geolocation permissions are cleared
 */

public void clear(java.lang.String origin) { throw new RuntimeException("Stub!"); }

/**
 * Allows the specified origin to use the Geolocation API.
 *
 * @param origin the origin for which Geolocation API use is allowed
 */

public void allow(java.lang.String origin) { throw new RuntimeException("Stub!"); }

/**
 * Clears the Geolocation permission state for all origins.
 */

public void clearAll() { throw new RuntimeException("Stub!"); }
/**
 * A callback interface used by the host application to set the Geolocation
 * permission state for an origin.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Callback {

/**
 * Sets the Geolocation permission state for the supplied origin.
 *
 * @param origin the origin for which permissions are set
 * @param allow whether or not the origin should be allowed to use the
 *              Geolocation API
 * @param retain whether the permission should be retained beyond the
 *               lifetime of a page currently being displayed by a
 *               WebView
 */

public void invoke(java.lang.String origin, boolean allow, boolean retain);
}

}

