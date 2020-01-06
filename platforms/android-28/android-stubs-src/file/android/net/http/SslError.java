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


package android.net.http;

import java.security.cert.X509Certificate;

/**
 * This class represents a set of one or more SSL errors and the associated SSL
 * certificate.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SslError {

/**
 * Creates a new SslError object using the supplied error and certificate.
 * The URL will be set to the empty string.
 * @param error The SSL error
 * @param certificate The associated SSL certificate
 * @deprecated Use {@link #SslError(int, SslCertificate, String)}
 */

@Deprecated public SslError(int error, android.net.http.SslCertificate certificate) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new SslError object using the supplied error and certificate.
 * The URL will be set to the empty string.
 * @param error The SSL error
 * @param certificate The associated SSL certificate
 * @deprecated Use {@link #SslError(int, X509Certificate, String)}
 */

@Deprecated public SslError(int error, java.security.cert.X509Certificate certificate) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new SslError object using the supplied error, certificate and
 * URL.
 * @param error The SSL error
 * @param certificate The associated SSL certificate
 * @param url The associated URL
 */

public SslError(int error, android.net.http.SslCertificate certificate, java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new SslError object using the supplied error, certificate and
 * URL.
 * @param error The SSL error
 * @param certificate The associated SSL certificate
 * @param url The associated URL
 */

public SslError(int error, java.security.cert.X509Certificate certificate, java.lang.String url) { throw new RuntimeException("Stub!"); }

/**
 * Gets the SSL certificate associated with this object.
 * @return The SSL certificate, non-null.
 */

public android.net.http.SslCertificate getCertificate() { throw new RuntimeException("Stub!"); }

/**
 * Gets the URL associated with this object.
 * @return The URL, non-null.
 */

public java.lang.String getUrl() { throw new RuntimeException("Stub!"); }

/**
 * Adds the supplied SSL error to the set.
 * @param error The SSL error to add
 * @return True if the error being added is a known SSL error, otherwise
 *         false.
 */

public boolean addError(int error) { throw new RuntimeException("Stub!"); }

/**
 * Determines whether this object includes the supplied error.
 * @param error The SSL error to check for
 * @return True if this object includes the error, otherwise false.
 */

public boolean hasError(int error) { throw new RuntimeException("Stub!"); }

/**
 * Gets the most severe SSL error in this object's set of errors.
 * Returns -1 if the set is empty.
 * @return The most severe SSL error, or -1 if the set is empty.
 */

public int getPrimaryError() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this object.
 * @return A String representation of this object.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The date of the certificate is invalid
 */

public static final int SSL_DATE_INVALID = 4; // 0x4

/**
 * The certificate has expired
 */

public static final int SSL_EXPIRED = 1; // 0x1

/**
 * Hostname mismatch
 */

public static final int SSL_IDMISMATCH = 2; // 0x2

/**
 * A generic error occurred
 */

public static final int SSL_INVALID = 5; // 0x5

/**
 * The number of different SSL errors.
 * @deprecated This constant is not necessary for using the SslError API and
 *             can change from release to release.
 */

@Deprecated public static final int SSL_MAX_ERROR = 6; // 0x6

/**
 * The certificate is not yet valid
 */

public static final int SSL_NOTYETVALID = 0; // 0x0

/**
 * The certificate authority is not trusted
 */

public static final int SSL_UNTRUSTED = 3; // 0x3
}

