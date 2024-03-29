/*
 * Copyright (C) 2010 The Android Open Source Project
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

import java.io.StringBufferInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * Encapsulates a resource response. Applications can return an instance of this
 * class from {@link WebViewClient#shouldInterceptRequest} to provide a custom
 * response when the WebView requests a particular resource.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WebResourceResponse {

/**
 * Constructs a resource response with the given MIME type, encoding, and
 * input stream. Callers must implement
 * {@link InputStream#read(byte[]) InputStream.read(byte[])} for the input
 * stream.
 *
 * @param mimeType the resource response's MIME type, for example text/html
 * @param encoding the resource response's encoding
 * @param data the input stream that provides the resource response's data. Must not be a
 *             StringBufferInputStream.
 */

public WebResourceResponse(java.lang.String mimeType, java.lang.String encoding, java.io.InputStream data) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a resource response with the given parameters. Callers must
 * implement {@link InputStream#read(byte[]) InputStream.read(byte[])} for
 * the input stream.
 *
 * @param mimeType the resource response's MIME type, for example text/html
 * @param encoding the resource response's encoding
 * @param statusCode the status code needs to be in the ranges [100, 299], [400, 599].
 *                   Causing a redirect by specifying a 3xx code is not supported.
 * @param reasonPhrase the phrase describing the status code, for example "OK". Must be
 *                     non-empty.
 * This value must never be {@code null}.
 * @param responseHeaders the resource response's headers represented as a mapping of header
 *                        name -> header value.
 * @param data the input stream that provides the resource response's data. Must not be a
 *             StringBufferInputStream.
 */

public WebResourceResponse(java.lang.String mimeType, java.lang.String encoding, int statusCode, @androidx.annotation.RecentlyNonNull java.lang.String reasonPhrase, java.util.Map<java.lang.String, java.lang.String> responseHeaders, java.io.InputStream data) { throw new RuntimeException("Stub!"); }

/**
 * Sets the resource response's MIME type, for example &quot;text/html&quot;.
 *
 * @param mimeType The resource response's MIME type
 */

public void setMimeType(java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource response's MIME type.
 *
 * @return The resource response's MIME type
 */

public java.lang.String getMimeType() { throw new RuntimeException("Stub!"); }

/**
 * Sets the resource response's encoding, for example &quot;UTF-8&quot;. This is used
 * to decode the data from the input stream.
 *
 * @param encoding The resource response's encoding
 */

public void setEncoding(java.lang.String encoding) { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource response's encoding.
 *
 * @return The resource response's encoding
 */

public java.lang.String getEncoding() { throw new RuntimeException("Stub!"); }

/**
 * Sets the resource response's status code and reason phrase.
 *
 * @param statusCode the status code needs to be in the ranges [100, 299], [400, 599].
 *                   Causing a redirect by specifying a 3xx code is not supported.
 * @param reasonPhrase the phrase describing the status code, for example "OK". Must be
 *                     non-empty.

 * This value must never be {@code null}.
 */

public void setStatusCodeAndReasonPhrase(int statusCode, @androidx.annotation.RecentlyNonNull java.lang.String reasonPhrase) { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource response's status code.
 *
 * @return The resource response's status code.
 */

public int getStatusCode() { throw new RuntimeException("Stub!"); }

/**
 * Gets the description of the resource response's status code.
 *
 * @return The description of the resource response's status code.
 */

public java.lang.String getReasonPhrase() { throw new RuntimeException("Stub!"); }

/**
 * Sets the headers for the resource response.
 *
 * @param headers Mapping of header name -> header value.
 */

public void setResponseHeaders(java.util.Map<java.lang.String, java.lang.String> headers) { throw new RuntimeException("Stub!"); }

/**
 * Gets the headers for the resource response.
 *
 * @return The headers for the resource response.
 */

public java.util.Map<java.lang.String, java.lang.String> getResponseHeaders() { throw new RuntimeException("Stub!"); }

/**
 * Sets the input stream that provides the resource response's data. Callers
 * must implement {@link InputStream#read(byte[]) InputStream.read(byte[])}.
 *
 * @param data the input stream that provides the resource response's data. Must not be a
 *             StringBufferInputStream.
 */

public void setData(java.io.InputStream data) { throw new RuntimeException("Stub!"); }

/**
 * Gets the input stream that provides the resource response's data.
 *
 * @return The input stream that provides the resource response's data
 */

public java.io.InputStream getData() { throw new RuntimeException("Stub!"); }
}

