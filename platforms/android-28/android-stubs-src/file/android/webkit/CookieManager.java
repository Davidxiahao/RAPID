/*
 * Copyright (C) 2006 The Android Open Source Project
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


/**
 * Manages the cookies used by an application's {@link WebView} instances.
 * Cookies are manipulated according to RFC2109.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CookieManager {

public CookieManager() { throw new RuntimeException("Stub!"); }

protected java.lang.Object clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Gets the singleton CookieManager instance.
 *
 * @return the singleton CookieManager instance
 */

public static android.webkit.CookieManager getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the application's {@link WebView} instances should send and
 * accept cookies.
 * By default this is set to {@code true} and the WebView accepts cookies.
 * <p>
 * When this is {@code true}
 * {@link CookieManager#setAcceptThirdPartyCookies setAcceptThirdPartyCookies} and
 * {@link CookieManager#setAcceptFileSchemeCookies setAcceptFileSchemeCookies}
 * can be used to control the policy for those specific types of cookie.
 *
 * @param accept whether {@link WebView} instances should send and accept
 *               cookies
 */

public abstract void setAcceptCookie(boolean accept);

/**
 * Gets whether the application's {@link WebView} instances send and accept
 * cookies.
 *
 * @return {@code true} if {@link WebView} instances send and accept cookies
 */

public abstract boolean acceptCookie();

/**
 * Sets whether the {@link WebView} should allow third party cookies to be set.
 * Allowing third party cookies is a per WebView policy and can be set
 * differently on different WebView instances.
 * <p>
 * Apps that target {@link android.os.Build.VERSION_CODES#KITKAT} or below
 * default to allowing third party cookies. Apps targeting
 * {@link android.os.Build.VERSION_CODES#LOLLIPOP} or later default to disallowing
 * third party cookies.
 *
 * @param webview the {@link WebView} instance to set the cookie policy on
 * @param accept whether the {@link WebView} instance should accept
 *               third party cookies
 */

public abstract void setAcceptThirdPartyCookies(android.webkit.WebView webview, boolean accept);

/**
 * Gets whether the {@link WebView} should allow third party cookies to be set.
 *
 * @param webview the {@link WebView} instance to get the cookie policy for
 * @return {@code true} if the {@link WebView} accepts third party cookies
 */

public abstract boolean acceptThirdPartyCookies(android.webkit.WebView webview);

/**
 * Sets a cookie for the given URL. Any existing cookie with the same host,
 * path and name will be replaced with the new cookie. The cookie being set
 * will be ignored if it is expired.
 *
 * @param url the URL for which the cookie is to be set
 * @param value the cookie as a string, using the format of the 'Set-Cookie'
 *              HTTP response header
 */

public abstract void setCookie(java.lang.String url, java.lang.String value);

/**
 * Sets a cookie for the given URL. Any existing cookie with the same host,
 * path and name will be replaced with the new cookie. The cookie being set
 * will be ignored if it is expired.
 * <p>
 * This method is asynchronous.
 * If a {@link ValueCallback} is provided,
 * {@link ValueCallback#onReceiveValue(T) onReceiveValue()} will be called on the current
 * thread's {@link android.os.Looper} once the operation is complete.
 * The value provided to the callback indicates whether the cookie was set successfully.
 * You can pass {@code null} as the callback if you don't need to know when the operation
 * completes or whether it succeeded, and in this case it is safe to call the method from a
 * thread without a Looper.
 *
 * @param url the URL for which the cookie is to be set
 * @param value the cookie as a string, using the format of the 'Set-Cookie'
 *              HTTP response header
 * @param callback a callback to be executed when the cookie has been set

 * This value may be {@code null}.
 */

public abstract void setCookie(java.lang.String url, java.lang.String value, @androidx.annotation.RecentlyNullable android.webkit.ValueCallback<java.lang.Boolean> callback);

/**
 * Gets the cookies for the given URL.
 *
 * @param url the URL for which the cookies are requested
 * @return value the cookies as a string, using the format of the 'Cookie'
 *               HTTP request header
 */

public abstract java.lang.String getCookie(java.lang.String url);

/**
 * Removes all session cookies, which are cookies without an expiration
 * date.
 * @deprecated use {@link #removeSessionCookies(ValueCallback)} instead.
 */

@Deprecated public abstract void removeSessionCookie();

/**
 * Removes all session cookies, which are cookies without an expiration
 * date.
 * <p>
 * This method is asynchronous.
 * If a {@link ValueCallback} is provided,
 * {@link ValueCallback#onReceiveValue(T) onReceiveValue()} will be called on the current
 * thread's {@link android.os.Looper} once the operation is complete.
 * The value provided to the callback indicates whether any cookies were removed.
 * You can pass {@code null} as the callback if you don't need to know when the operation
 * completes or whether any cookie were removed, and in this case it is safe to call the
 * method from a thread without a Looper.
 * @param callback a callback which is executed when the session cookies have been removed

 * This value may be {@code null}.
 */

public abstract void removeSessionCookies(@androidx.annotation.RecentlyNullable android.webkit.ValueCallback<java.lang.Boolean> callback);

/**
 * Removes all cookies.
 * @deprecated Use {@link #removeAllCookies(ValueCallback)} instead.
 */

@Deprecated public abstract void removeAllCookie();

/**
 * Removes all cookies.
 * <p>
 * This method is asynchronous.
 * If a {@link ValueCallback} is provided,
 * {@link ValueCallback#onReceiveValue(T) onReceiveValue()} will be called on the current
 * thread's {@link android.os.Looper} once the operation is complete.
 * The value provided to the callback indicates whether any cookies were removed.
 * You can pass {@code null} as the callback if you don't need to know when the operation
 * completes or whether any cookies were removed, and in this case it is safe to call the
 * method from a thread without a Looper.
 * @param callback a callback which is executed when the cookies have been removed

 * This value may be {@code null}.
 */

public abstract void removeAllCookies(@androidx.annotation.RecentlyNullable android.webkit.ValueCallback<java.lang.Boolean> callback);

/**
 * Gets whether there are stored cookies.
 *
 * @return {@code true} if there are stored cookies
 */

public abstract boolean hasCookies();

/**
 * Removes all expired cookies.
 * @deprecated The WebView handles removing expired cookies automatically.
 */

@Deprecated public abstract void removeExpiredCookie();

/**
 * Ensures all cookies currently accessible through the getCookie API are
 * written to persistent storage.
 * This call will block the caller until it is done and may perform I/O.
 */

public abstract void flush();

/**
 * Gets whether the application's {@link WebView} instances send and accept
 * cookies for file scheme URLs.
 *
 * @return {@code true} if {@link WebView} instances send and accept cookies for
 *         file scheme URLs
 */

public static boolean allowFileSchemeCookies() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the application's {@link WebView} instances should send and
 * accept cookies for file scheme URLs.
 * Use of cookies with file scheme URLs is potentially insecure and turned
 * off by default.
 * Do not use this feature unless you can be sure that no unintentional
 * sharing of cookie data can take place.
 * <p>
 * Note that calls to this method will have no effect if made after a
 * {@link WebView} or CookieManager instance has been created.
 */

public static void setAcceptFileSchemeCookies(boolean accept) { throw new RuntimeException("Stub!"); }
}

