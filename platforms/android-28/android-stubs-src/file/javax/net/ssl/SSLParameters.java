/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.security.AlgorithmConstraints;
import java.util.List;
import java.util.Collection;

/**
 * Encapsulates parameters for an SSL/TLS connection. The parameters
 * are the list of ciphersuites to be accepted in an SSL/TLS handshake,
 * the list of protocols to be allowed, the endpoint identification
 * algorithm during SSL/TLS handshaking, the Server Name Indication (SNI),
 * the algorithm constraints and whether SSL/TLS servers should request
 * or require client authentication, etc.
 * <p>
 * SSLParameters can be created via the constructors in this class.
 * Objects can also be obtained using the <code>getSSLParameters()</code>
 * methods in
 * {@link SSLSocket#getSSLParameters SSLSocket} and
 * {@link SSLServerSocket#getSSLParameters SSLServerSocket} and
 * {@link SSLEngine#getSSLParameters SSLEngine} or the
 * {@link SSLContext#getDefaultSSLParameters getDefaultSSLParameters()} and
 * {@link SSLContext#getSupportedSSLParameters getSupportedSSLParameters()}
 * methods in <code>SSLContext</code>.
 * <p>
 * SSLParameters can be applied to a connection via the methods
 * {@link SSLSocket#setSSLParameters SSLSocket.setSSLParameters()} and
 * {@link SSLServerSocket#setSSLParameters SSLServerSocket.setSSLParameters()}
 * and {@link SSLEngine#setSSLParameters SSLEngine.setSSLParameters()}.
 *
 * @see SSLSocket
 * @see SSLEngine
 * @see SSLContext
 *
 * @since 1.6
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SSLParameters {

/**
 * Constructs SSLParameters.
 * <p>
 * The values of cipherSuites, protocols, cryptographic algorithm
 * constraints, endpoint identification algorithm, server names and
 * server name matchers are set to <code>null</code>, useCipherSuitesOrder,
 * wantClientAuth and needClientAuth are set to <code>false</code>.
 */

public SSLParameters() { throw new RuntimeException("Stub!"); }

/**
 * Constructs SSLParameters from the specified array of ciphersuites.
 * <p>
 * Calling this constructor is equivalent to calling the no-args
 * constructor followed by
 * <code>setCipherSuites(cipherSuites);</code>.
 *
 * @param cipherSuites the array of ciphersuites (or null)
 */

public SSLParameters(java.lang.String[] cipherSuites) { throw new RuntimeException("Stub!"); }

/**
 * Constructs SSLParameters from the specified array of ciphersuites
 * and protocols.
 * <p>
 * Calling this constructor is equivalent to calling the no-args
 * constructor followed by
 * <code>setCipherSuites(cipherSuites); setProtocols(protocols);</code>.
 *
 * @param cipherSuites the array of ciphersuites (or null)
 * @param protocols the array of protocols (or null)
 */

public SSLParameters(java.lang.String[] cipherSuites, java.lang.String[] protocols) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the array of ciphersuites or null if none
 * have been set.
 *
 * @return a copy of the array of ciphersuites or null if none
 * have been set.
 */

public java.lang.String[] getCipherSuites() { throw new RuntimeException("Stub!"); }

/**
 * Sets the array of ciphersuites.
 *
 * @param cipherSuites the array of ciphersuites (or null)
 */

public void setCipherSuites(java.lang.String[] cipherSuites) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the array of protocols or null if none
 * have been set.
 *
 * @return a copy of the array of protocols or null if none
 * have been set.
 */

public java.lang.String[] getProtocols() { throw new RuntimeException("Stub!"); }

/**
 * Sets the array of protocols.
 *
 * @param protocols the array of protocols (or null)
 */

public void setProtocols(java.lang.String[] protocols) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether client authentication should be requested.
 *
 * @return whether client authentication should be requested.
 */

public boolean getWantClientAuth() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether client authentication should be requested. Calling
 * this method clears the <code>needClientAuth</code> flag.
 *
 * @param wantClientAuth whether client authentication should be requested
 */

public void setWantClientAuth(boolean wantClientAuth) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether client authentication should be required.
 *
 * @return whether client authentication should be required.
 */

public boolean getNeedClientAuth() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether client authentication should be required. Calling
 * this method clears the <code>wantClientAuth</code> flag.
 *
 * @param needClientAuth whether client authentication should be required
 */

public void setNeedClientAuth(boolean needClientAuth) { throw new RuntimeException("Stub!"); }

/**
 * Returns the cryptographic algorithm constraints.
 *
 * @return the cryptographic algorithm constraints, or null if the
 *     constraints have not been set
 *
 * @see #setAlgorithmConstraints(AlgorithmConstraints)
 *
 * @since 1.7
 */

public java.security.AlgorithmConstraints getAlgorithmConstraints() { throw new RuntimeException("Stub!"); }

/**
 * Sets the cryptographic algorithm constraints, which will be used
 * in addition to any configured by the runtime environment.
 * <p>
 * If the <code>constraints</code> parameter is non-null, every
 * cryptographic algorithm, key and algorithm parameters used in the
 * SSL/TLS handshake must be permitted by the constraints.
 *
 * @param constraints the algorithm constraints (or null)
 *
 * @since 1.7
 */

public void setAlgorithmConstraints(java.security.AlgorithmConstraints constraints) { throw new RuntimeException("Stub!"); }

/**
 * Gets the endpoint identification algorithm.
 *
 * @return the endpoint identification algorithm, or null if none
 * has been set.
 *
 * @see X509ExtendedTrustManager
 * @see #setEndpointIdentificationAlgorithm(String)
 *
 * @since 1.7
 */

public java.lang.String getEndpointIdentificationAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Sets the endpoint identification algorithm.
 * <p>
 * If the <code>algorithm</code> parameter is non-null or non-empty, the
 * endpoint identification/verification procedures must be handled during
 * SSL/TLS handshaking.  This is to prevent man-in-the-middle attacks.
 *
 * @param algorithm The standard string name of the endpoint
 *     identification algorithm (or null).  See Appendix A in the <a href=
 *   "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/crypto/CryptoSpec.html#AppA">
 *     Java Cryptography Architecture API Specification &amp; Reference </a>
 *     for information about standard algorithm names.
 *
 * @see X509ExtendedTrustManager
 *
 * @since 1.7
 */

public void setEndpointIdentificationAlgorithm(java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Sets the desired {@link SNIServerName}s of the Server Name
 * Indication (SNI) parameter.
 * <P>
 * This method is only useful to {@link SSLSocket}s or {@link SSLEngine}s
 * operating in client mode.
 * <P>
 * Note that the {@code serverNames} list is cloned
 * to protect against subsequent modification.
 *
 * @param  serverNames
 *         the list of desired {@link SNIServerName}s (or null)
 *
 * @throws NullPointerException if the {@code serverNames}
 *         contains {@code null} element
 * @throws IllegalArgumentException if the {@code serverNames}
 *         contains more than one name of the same name type
 *
 * @see SNIServerName
 * @see #getServerNames()
 *
 * @since 1.8
 */

public final void setServerNames(java.util.List<javax.net.ssl.SNIServerName> serverNames) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link List} containing all {@link SNIServerName}s of the
 * Server Name Indication (SNI) parameter, or null if none has been set.
 * <P>
 * This method is only useful to {@link SSLSocket}s or {@link SSLEngine}s
 * operating in client mode.
 * <P>
 * For SSL/TLS connections, the underlying SSL/TLS provider
 * may specify a default value for a certain server name type.  In
 * client mode, it is recommended that, by default, providers should
 * include the server name indication whenever the server can be located
 * by a supported server name type.
 * <P>
 * It is recommended that providers initialize default Server Name
 * Indications when creating {@code SSLSocket}/{@code SSLEngine}s.
 * In the following examples, the server name could be represented by an
 * instance of {@link SNIHostName} which has been initialized with the
 * hostname "www.example.com" and type
 * {@link StandardConstants#SNI_HOST_NAME}.
 *
 * <pre>
 *     Socket socket =
 *         sslSocketFactory.createSocket("www.example.com", 443);
 * </pre>
 * or
 * <pre>
 *     SSLEngine engine =
 *         sslContext.createSSLEngine("www.example.com", 443);
 * </pre>
 * <P>
 *
 * @return null or an immutable list of non-null {@link SNIServerName}s
 *
 * @see List
 * @see #setServerNames(List)
 *
 * @since 1.8
 */

public final java.util.List<javax.net.ssl.SNIServerName> getServerNames() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link SNIMatcher}s of the Server Name Indication (SNI)
 * parameter.
 * <P>
 * This method is only useful to {@link SSLSocket}s or {@link SSLEngine}s
 * operating in server mode.
 * <P>
 * Note that the {@code matchers} collection is cloned to protect
 * against subsequent modification.
 *
 * @param  matchers
 *         the collection of {@link SNIMatcher}s (or null)
 *
 * @throws NullPointerException if the {@code matchers}
 *         contains {@code null} element
 * @throws IllegalArgumentException if the {@code matchers}
 *         contains more than one name of the same name type
 *
 * @see Collection
 * @see SNIMatcher
 * @see #getSNIMatchers()
 *
 * @since 1.8
 */

public final void setSNIMatchers(java.util.Collection<javax.net.ssl.SNIMatcher> matchers) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Collection} containing all {@link SNIMatcher}s of the
 * Server Name Indication (SNI) parameter, or null if none has been set.
 * <P>
 * This method is only useful to {@link SSLSocket}s or {@link SSLEngine}s
 * operating in server mode.
 * <P>
 * For better interoperability, providers generally will not define
 * default matchers so that by default servers will ignore the SNI
 * extension and continue the handshake.
 *
 * @return null or an immutable collection of non-null {@link SNIMatcher}s
 *
 * @see SNIMatcher
 * @see #setSNIMatchers(Collection)
 *
 * @since 1.8
 */

public final java.util.Collection<javax.net.ssl.SNIMatcher> getSNIMatchers() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the local cipher suites preference should be honored.
 *
 * @param honorOrder whether local cipher suites order in
 *        {@code #getCipherSuites} should be honored during
 *        SSL/TLS handshaking.
 *
 * @see #getUseCipherSuitesOrder()
 *
 * @since 1.8
 */

public final void setUseCipherSuitesOrder(boolean honorOrder) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the local cipher suites preference should be honored.
 *
 * @return whether local cipher suites order in {@code #getCipherSuites}
 *         should be honored during SSL/TLS handshaking.
 *
 * @see #setUseCipherSuitesOrder(boolean)
 *
 * @since 1.8
 */

public final boolean getUseCipherSuitesOrder() { throw new RuntimeException("Stub!"); }
}

