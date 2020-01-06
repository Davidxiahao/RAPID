/*
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


/**
 * Instances of this class represent a secure socket protocol
 * implementation which acts as a factory for secure socket
 * factories or <code>SSLEngine</code>s. This class is initialized
 * with an optional set of key and trust managers and source of
 * secure random bytes.
 *
 * <p> Android provides the following <code>SSLContext</code> protocols:
 * <table>
 *   <thead>
 *     <tr>
 *       <th>Algorithm</th>
 *       <th>Supported API Levels</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>Default</td>
 *       <td>10+</td>
 *     </tr>
 *     <tr>
 *       <td>SSL</td>
 *       <td>10+</td>
 *     </tr>
 *     <tr class="deprecated">
 *       <td>SSLv3</td>
 *       <td>10-25</td>
 *     </tr>
 *     <tr>
 *       <td>TLS</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>TLSv1</td>
 *       <td>10+</td>
 *     </tr>
 *     <tr>
 *       <td>TLSv1.1</td>
 *       <td>16+</td>
 *     </tr>
 *     <tr>
 *       <td>TLSv1.2</td>
 *       <td>16+</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * This protocol is described in the <a href=
 * "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/StandardNames.html#SSLContext">
 * SSLContext section</a> of the
 * Java Cryptography Architecture Standard Algorithm Name Documentation.
 *
 * @since 1.4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SSLContext {

/**
 * Creates an SSLContext object.
 *
 * @param contextSpi the delegate
 * @param provider the provider
 * @param protocol the protocol
 */

protected SSLContext(javax.net.ssl.SSLContextSpi contextSpi, java.security.Provider provider, java.lang.String protocol) { throw new RuntimeException("Stub!"); }

/**
 * Returns the default SSL context.
 *
 * <p>If a default context was set using the {@link #setDefault
 * SSLContext.setDefault()} method, it is returned. Otherwise, the first
 * call of this method triggers the call
 * <code>SSLContext.getInstance("Default")</code>.
 * If successful, that object is made the default SSL context and returned.
 *
 * <p>The default context is immediately
 * usable and does not require {@linkplain #init initialization}.
 *
 * @return the default SSL context
 * @throws NoSuchAlgorithmException if the
 *   {@link SSLContext#getInstance SSLContext.getInstance()} call fails
 * @since 1.6
 */

public static synchronized javax.net.ssl.SSLContext getDefault() throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Sets the default SSL context. It will be returned by subsequent calls
 * to {@link #getDefault}. The default context must be immediately usable
 * and not require {@linkplain #init initialization}.
 *
 * @param context the SSLContext
 * @throws  NullPointerException if context is null
 * @throws  SecurityException if a security manager exists and its
 *          <code>checkPermission</code> method does not allow
 *          <code>SSLPermission("setDefaultSSLContext")</code>
 * @since 1.6
 */

public static synchronized void setDefault(javax.net.ssl.SSLContext context) { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>SSLContext</code> object that implements the
 * specified secure socket protocol.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new SSLContext object encapsulating the
 * SSLContextSpi implementation from the first
 * Provider that supports the specified protocol is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link Security#getProviders() Security.getProviders()} method.
 *
 * @param protocol the standard name of the requested protocol.
 *          See the SSLContext section in the <a href=
 * "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/StandardNames.html#SSLContext">
 *          Java Cryptography Architecture Standard Algorithm Name
 *          Documentation</a>
 *          for information about standard protocol names.
 *
 * @return the new <code>SSLContext</code> object.
 *
 * @exception NoSuchAlgorithmException if no Provider supports a
 *          SSLContextSpi implementation for the
 *          specified protocol.
 * @exception NullPointerException if protocol is null.
 *
 * @see java.security.Provider
 */

public static javax.net.ssl.SSLContext getInstance(java.lang.String protocol) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>SSLContext</code> object that implements the
 * specified secure socket protocol.
 *
 * <p> A new SSLContext object encapsulating the
 * SSLContextSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link Security#getProviders() Security.getProviders()} method.
 *
 * @param protocol the standard name of the requested protocol.
 *          See the SSLContext section in the <a href=
 * "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/StandardNames.html#SSLContext">
 *          Java Cryptography Architecture Standard Algorithm Name
 *          Documentation</a>
 *          for information about standard protocol names.
 *
 * @param provider the name of the provider.
 *
 * @return the new <code>SSLContext</code> object.
 *
 * @throws NoSuchAlgorithmException if a SSLContextSpi
 *          implementation for the specified protocol is not
 *          available from the specified provider.
 *
 * @throws NoSuchProviderException if the specified provider is not
 *          registered in the security provider list.
 *
 * @throws IllegalArgumentException if the provider name is null or empty.
 * @throws NullPointerException if protocol is null.
 *
 * @see java.security.Provider
 */

public static javax.net.ssl.SSLContext getInstance(java.lang.String protocol, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>SSLContext</code> object that implements the
 * specified secure socket protocol.
 *
 * <p> A new SSLContext object encapsulating the
 * SSLContextSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param protocol the standard name of the requested protocol.
 *          See the SSLContext section in the <a href=
 * "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/StandardNames.html#SSLContext">
 *          Java Cryptography Architecture Standard Algorithm Name
 *          Documentation</a>
 *          for information about standard protocol names.
 *
 * @param provider an instance of the provider.
 *
 * @return the new <code>SSLContext</code> object.
 *
 * @throws NoSuchAlgorithmException if a SSLContextSpi
 *          implementation for the specified protocol is not available
 *          from the specified Provider object.
 *
 * @throws IllegalArgumentException if the provider is null.
 * @throws NullPointerException if protocol is null.
 *
 * @see java.security.Provider
 */

public static javax.net.ssl.SSLContext getInstance(java.lang.String protocol, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the protocol name of this <code>SSLContext</code> object.
 *
 * <p>This is the same name that was specified in one of the
 * <code>getInstance</code> calls that created this
 * <code>SSLContext</code> object.
 *
 * @return the protocol name of this <code>SSLContext</code> object.
 */

public final java.lang.String getProtocol() { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this <code>SSLContext</code> object.
 *
 * @return the provider of this <code>SSLContext</code> object
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Initializes this context. Either of the first two parameters
 * may be null in which case the installed security providers will
 * be searched for the highest priority implementation of the
 * appropriate factory. Likewise, the secure random parameter may
 * be null in which case the default implementation will be used.
 * <P>
 * Only the first instance of a particular key and/or trust manager
 * implementation type in the array is used.  (For example, only
 * the first javax.net.ssl.X509KeyManager in the array will be used.)
 *
 * @param km the sources of authentication keys or null
 * @param tm the sources of peer authentication trust decisions or null
 * @param random the source of randomness for this generator or null
 * @throws KeyManagementException if this operation fails
 */

public final void init(javax.net.ssl.KeyManager[] km, javax.net.ssl.TrustManager[] tm, java.security.SecureRandom random) throws java.security.KeyManagementException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>SocketFactory</code> object for this
 * context.
 *
 * @return the <code>SocketFactory</code> object
 * @throws IllegalStateException if the SSLContextImpl requires
 *          initialization and the <code>init()</code> has not been called
 */

public final javax.net.ssl.SSLSocketFactory getSocketFactory() { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>ServerSocketFactory</code> object for
 * this context.
 *
 * @return the <code>ServerSocketFactory</code> object
 * @throws IllegalStateException if the SSLContextImpl requires
 *          initialization and the <code>init()</code> has not been called
 */

public final javax.net.ssl.SSLServerSocketFactory getServerSocketFactory() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>SSLEngine</code> using this context.
 * <P>
 * Applications using this factory method are providing no hints
 * for an internal session reuse strategy. If hints are desired,
 * {@link #createSSLEngine(String, int)} should be used
 * instead.
 * <P>
 * Some cipher suites (such as Kerberos) require remote hostname
 * information, in which case this factory method should not be used.
 *
 * @return  the <code>SSLEngine</code> object
 * @throws  UnsupportedOperationException if the underlying provider
 *          does not implement the operation.
 * @throws  IllegalStateException if the SSLContextImpl requires
 *          initialization and the <code>init()</code> has not been called
 * @since   1.5
 */

public final javax.net.ssl.SSLEngine createSSLEngine() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new <code>SSLEngine</code> using this context using
 * advisory peer information.
 * <P>
 * Applications using this factory method are providing hints
 * for an internal session reuse strategy.
 * <P>
 * Some cipher suites (such as Kerberos) require remote hostname
 * information, in which case peerHost needs to be specified.
 *
 * @param   peerHost the non-authoritative name of the host
 * @param   peerPort the non-authoritative port
 * @return  the new <code>SSLEngine</code> object
 * @throws  UnsupportedOperationException if the underlying provider
 *          does not implement the operation.
 * @throws  IllegalStateException if the SSLContextImpl requires
 *          initialization and the <code>init()</code> has not been called
 * @since   1.5
 */

public final javax.net.ssl.SSLEngine createSSLEngine(java.lang.String peerHost, int peerPort) { throw new RuntimeException("Stub!"); }

/**
 * Returns the server session context, which represents the set of
 * SSL sessions available for use during the handshake phase of
 * server-side SSL sockets.
 * <P>
 * This context may be unavailable in some environments, in which
 * case this method returns null. For example, when the underlying
 * SSL provider does not provide an implementation of SSLSessionContext
 * interface, this method returns null. A non-null session context
 * is returned otherwise.
 *
 * @return server session context bound to this SSL context
 */

public final javax.net.ssl.SSLSessionContext getServerSessionContext() { throw new RuntimeException("Stub!"); }

/**
 * Returns the client session context, which represents the set of
 * SSL sessions available for use during the handshake phase of
 * client-side SSL sockets.
 * <P>
 * This context may be unavailable in some environments, in which
 * case this method returns null. For example, when the underlying
 * SSL provider does not provide an implementation of SSLSessionContext
 * interface, this method returns null. A non-null session context
 * is returned otherwise.
 *
 * @return client session context bound to this SSL context
 */

public final javax.net.ssl.SSLSessionContext getClientSessionContext() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the SSLParameters indicating the default
 * settings for this SSL context.
 *
 * <p>The parameters will always have the ciphersuites and protocols
 * arrays set to non-null values.
 *
 * @return a copy of the SSLParameters object with the default settings
 * @throws UnsupportedOperationException if the default SSL parameters
 *   could not be obtained.
 * @since 1.6
 */

public final javax.net.ssl.SSLParameters getDefaultSSLParameters() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the SSLParameters indicating the supported
 * settings for this SSL context.
 *
 * <p>The parameters will always have the ciphersuites and protocols
 * arrays set to non-null values.
 *
 * @return a copy of the SSLParameters object with the supported
 *   settings
 * @throws UnsupportedOperationException if the supported SSL parameters
 *   could not be obtained.
 * @since 1.6
 */

public final javax.net.ssl.SSLParameters getSupportedSSLParameters() { throw new RuntimeException("Stub!"); }
}

