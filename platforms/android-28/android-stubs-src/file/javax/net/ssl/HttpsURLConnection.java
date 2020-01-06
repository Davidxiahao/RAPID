/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1999, 2012, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */


package javax.net.ssl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;

/**
 * <code>HttpsURLConnection</code> extends <code>HttpURLConnection</code>
 * with support for https-specific features.
 * <P>
 * See <A HREF="http://www.w3.org/pub/WWW/Protocols/">
 * http://www.w3.org/pub/WWW/Protocols/</A> and
 * <A HREF="http://www.ietf.org/"> RFC 2818 </A>
 * for more details on the
 * https specification.
 * <P>
 * This class uses <code>HostnameVerifier</code> and
 * <code>SSLSocketFactory</code>.
 * There are default implementations defined for both classes.
 * However, the implementations can be replaced on a per-class (static) or
 * per-instance basis.  All new <code>HttpsURLConnection</code>s instances
 * will be assigned
 * the "default" static values at instance creation, but they can be overriden
 * by calling the appropriate per-instance set method(s) before
 * <code>connect</code>ing.
 *
 * @since 1.4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class HttpsURLConnection extends java.net.HttpURLConnection {

/**
 * Creates an <code>HttpsURLConnection</code> using the
 * URL specified.
 *
 * @param url the URL
 */

protected HttpsURLConnection(java.net.URL url) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns the cipher suite in use on this connection.
 *
 * @return the cipher suite
 * @throws IllegalStateException if this method is called before
 *          the connection has been established.
 */

public abstract java.lang.String getCipherSuite();

/**
 * Returns the certificate(s) that were sent to the server during
 * handshaking.
 * <P>
 * Note: This method is useful only when using certificate-based
 * cipher suites.
 * <P>
 * When multiple certificates are available for use in a
 * handshake, the implementation chooses what it considers the
 * "best" certificate chain available, and transmits that to
 * the other side.  This method allows the caller to know
 * which certificate chain was actually sent.
 *
 * @return an ordered array of certificates,
 *          with the client's own certificate first followed by any
 *          certificate authorities.  If no certificates were sent,
 *          then null is returned.
 * @throws IllegalStateException if this method is called before
 *          the connection has been established.
 * @see #getLocalPrincipal()
 */

public abstract java.security.cert.Certificate[] getLocalCertificates();

/**
 * Returns the server's certificate chain which was established
 * as part of defining the session.
 * <P>
 * Note: This method can be used only when using certificate-based
 * cipher suites; using it with non-certificate-based cipher suites,
 * such as Kerberos, will throw an SSLPeerUnverifiedException.
 *
 * @return an ordered array of server certificates,
 *          with the peer's own certificate first followed by
 *          any certificate authorities.
 * @throws SSLPeerUnverifiedException if the peer is not verified.
 * @throws IllegalStateException if this method is called before
 *          the connection has been established.
 * @see #getPeerPrincipal()
 */

public abstract java.security.cert.Certificate[] getServerCertificates() throws javax.net.ssl.SSLPeerUnverifiedException;

/**
 * Returns the server's principal which was established as part of
 * defining the session.
 * <P>
 * Note: Subclasses should override this method. If not overridden, it
 * will default to returning the X500Principal of the server's end-entity
 * certificate for certificate-based ciphersuites, or throw an
 * SSLPeerUnverifiedException for non-certificate based ciphersuites,
 * such as Kerberos.
 *
 * @return the server's principal. Returns an X500Principal of the
 * end-entity certiticate for X509-based cipher suites, and
 * KerberosPrincipal for Kerberos cipher suites.
 *
 * @throws SSLPeerUnverifiedException if the peer was not verified
 * @throws IllegalStateException if this method is called before
 *          the connection has been established.
 *
 * @see #getServerCertificates()
 * @see #getLocalPrincipal()
 *
 * @since 1.5
 */

public java.security.Principal getPeerPrincipal() throws javax.net.ssl.SSLPeerUnverifiedException { throw new RuntimeException("Stub!"); }

/**
 * Returns the principal that was sent to the server during handshaking.
 * <P>
 * Note: Subclasses should override this method. If not overridden, it
 * will default to returning the X500Principal of the end-entity certificate
 * that was sent to the server for certificate-based ciphersuites or,
 * return null for non-certificate based ciphersuites, such as Kerberos.
 *
 * @return the principal sent to the server. Returns an X500Principal
 * of the end-entity certificate for X509-based cipher suites, and
 * KerberosPrincipal for Kerberos cipher suites. If no principal was
 * sent, then null is returned.
 *
 * @throws IllegalStateException if this method is called before
 *          the connection has been established.
 *
 * @see #getLocalCertificates()
 * @see #getPeerPrincipal()
 *
 * @since 1.5
 */

public java.security.Principal getLocalPrincipal() { throw new RuntimeException("Stub!"); }

/**
 * Sets the default <code>HostnameVerifier</code> inherited by a
 * new instance of this class.
 * <P>
 * If this method is not called, the default
 * <code>HostnameVerifier</code> assumes the connection should not
 * be permitted.
 *
 * @param v the default host name verifier
 * @throws IllegalArgumentException if the <code>HostnameVerifier</code>
 *          parameter is null.
 * @throws SecurityException if a security manager exists and its
 *         <code>checkPermission</code> method does not allow
 *         <code>SSLPermission("setHostnameVerifier")</code>
 * @see #getDefaultHostnameVerifier()
 */

public static void setDefaultHostnameVerifier(javax.net.ssl.HostnameVerifier v) { throw new RuntimeException("Stub!"); }

/**
 * Gets the default <code>HostnameVerifier</code> that is inherited
 * by new instances of this class.
 *
 * @return the default host name verifier
 * @see #setDefaultHostnameVerifier(HostnameVerifier)
 */

public static javax.net.ssl.HostnameVerifier getDefaultHostnameVerifier() { throw new RuntimeException("Stub!"); }

/**
 * Sets the <code>HostnameVerifier</code> for this instance.
 * <P>
 * New instances of this class inherit the default static hostname
 * verifier set by {@link #setDefaultHostnameVerifier(HostnameVerifier)
 * setDefaultHostnameVerifier}.  Calls to this method replace
 * this object's <code>HostnameVerifier</code>.
 *
 * @param v the host name verifier
 * @throws IllegalArgumentException if the <code>HostnameVerifier</code>
 *  parameter is null.
 * @see #getHostnameVerifier()
 * @see #setDefaultHostnameVerifier(HostnameVerifier)
 */

public void setHostnameVerifier(javax.net.ssl.HostnameVerifier v) { throw new RuntimeException("Stub!"); }

/**
 * Gets the <code>HostnameVerifier</code> in place on this instance.
 *
 * @return the host name verifier
 * @see #setHostnameVerifier(HostnameVerifier)
 * @see #setDefaultHostnameVerifier(HostnameVerifier)
 */

public javax.net.ssl.HostnameVerifier getHostnameVerifier() { throw new RuntimeException("Stub!"); }

/**
 * Sets the default <code>SSLSocketFactory</code> inherited by new
 * instances of this class.
 * <P>
 * The socket factories are used when creating sockets for secure
 * https URL connections.
 *
 * @param sf the default SSL socket factory
 * @throws IllegalArgumentException if the SSLSocketFactory
 *          parameter is null.
 * @throws SecurityException if a security manager exists and its
 *         <code>checkSetFactory</code> method does not allow
 *         a socket factory to be specified.
 * @see #getDefaultSSLSocketFactory()
 */

public static void setDefaultSSLSocketFactory(javax.net.ssl.SSLSocketFactory sf) { throw new RuntimeException("Stub!"); }

/**
 * Gets the default static <code>SSLSocketFactory</code> that is
 * inherited by new instances of this class.
 * <P>
 * The socket factories are used when creating sockets for secure
 * https URL connections.
 *
 * @return the default <code>SSLSocketFactory</code>
 * @see #setDefaultSSLSocketFactory(SSLSocketFactory)
 */

public static javax.net.ssl.SSLSocketFactory getDefaultSSLSocketFactory() { throw new RuntimeException("Stub!"); }

/**
 * Sets the <code>SSLSocketFactory</code> to be used when this instance
 * creates sockets for secure https URL connections.
 * <P>
 * New instances of this class inherit the default static
 * <code>SSLSocketFactory</code> set by
 * {@link #setDefaultSSLSocketFactory(SSLSocketFactory)
 * setDefaultSSLSocketFactory}.  Calls to this method replace
 * this object's <code>SSLSocketFactory</code>.
 *
 * @param sf the SSL socket factory
 * @throws IllegalArgumentException if the <code>SSLSocketFactory</code>
 *          parameter is null.
 * @see #getSSLSocketFactory()
 */

public void setSSLSocketFactory(javax.net.ssl.SSLSocketFactory sf) { throw new RuntimeException("Stub!"); }

/**
 * Gets the SSL socket factory to be used when creating sockets
 * for secure https URL connections.
 *
 * @return the <code>SSLSocketFactory</code>
 * @see #setSSLSocketFactory(SSLSocketFactory)
 */

public javax.net.ssl.SSLSocketFactory getSSLSocketFactory() { throw new RuntimeException("Stub!"); }

/**
 * The <code>hostnameVerifier</code> for this object.
 */

protected javax.net.ssl.HostnameVerifier hostnameVerifier;
}

