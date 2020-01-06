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

import java.security.Security;

/**
 * This class acts as a factory for key managers based on a
 * source of key material. Each key manager manages a specific
 * type of key material for use by secure sockets. The key
 * material is based on a KeyStore and/or provider specific sources.
 *
 * <p> Android provides the following <code>KeyManagerFactory</code> algorithms:
 * <table>
 *   <thead>
 *     <tr>
 *       <th>Algorithm</th>
 *       <th>Supported API Levels</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>PKIX</td>
 *       <td>1+</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * @since 1.4
 * @see KeyManager
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class KeyManagerFactory {

/**
 * Creates a KeyManagerFactory object.
 *
 * @param factorySpi the delegate
 * @param provider the provider
 * @param algorithm the algorithm
 */

protected KeyManagerFactory(javax.net.ssl.KeyManagerFactorySpi factorySpi, java.security.Provider provider, java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the default KeyManagerFactory algorithm name.
 *
 * <p>The default algorithm can be changed at runtime by setting
 * the value of the {@code ssl.KeyManagerFactory.algorithm}
 * security property to the desired algorithm name.
 *
 * @see java.security.Security security properties
 * @return the default algorithm name as specified by the
 *          {@code ssl.KeyManagerFactory.algorithm} security property, or an
 *          implementation-specific default if no such property exists.
 */

public static final java.lang.String getDefaultAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns the algorithm name of this <code>KeyManagerFactory</code> object.
 *
 * <p>This is the same name that was specified in one of the
 * <code>getInstance</code> calls that created this
 * <code>KeyManagerFactory</code> object.
 *
 * @return the algorithm name of this <code>KeyManagerFactory</code> object.
 */

public final java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>KeyManagerFactory</code> object that acts as a
 * factory for key managers.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new KeyManagerFactory object encapsulating the
 * KeyManagerFactorySpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link Security#getProviders() Security.getProviders()} method.
 *
 * @param algorithm the standard name of the requested algorithm.
 *          See the <a href=
 *  "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/jsse/JSSERefGuide.html">
 *          Java Secure Socket Extension Reference Guide </a>
 *          for information about standard algorithm names.
 *
 * @return the new <code>KeyManagerFactory</code> object.
 *
 * @exception NoSuchAlgorithmException if no Provider supports a
 *          KeyManagerFactorySpi implementation for the
 *          specified algorithm.
 * @exception NullPointerException if <code>algorithm</code> is null.
 *
 * @see java.security.Provider
 */

public static final javax.net.ssl.KeyManagerFactory getInstance(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>KeyManagerFactory</code> object that acts as a
 * factory for key managers.
 *
 * <p> A new KeyManagerFactory object encapsulating the
 * KeyManagerFactorySpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link Security#getProviders() Security.getProviders()} method.
 
 * @param algorithm the standard name of the requested algorithm.
 *          See the <a href=
 *  "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/jsse/JSSERefGuide.html">
 *          Java Secure Socket Extension Reference Guide </a>
 *          for information about standard algorithm names.
 *
 * @param provider the name of the provider.
 *
 * @return the new <code>KeyManagerFactory</code> object.
 *
 * @throws NoSuchAlgorithmException if a KeyManagerFactorySpi
 *          implementation for the specified algorithm is not
 *          available from the specified provider.
 *
 * @throws NoSuchProviderException if the specified provider is not
 *          registered in the security provider list.
 *
 * @throws IllegalArgumentException if the provider name is null or empty.
 * @throws NullPointerException if <code>algorithm</code> is null.
 *
 * @see java.security.Provider
 */

public static final javax.net.ssl.KeyManagerFactory getInstance(java.lang.String algorithm, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>KeyManagerFactory</code> object that acts as a
 * factory for key managers.
 *
 * <p> A new KeyManagerFactory object encapsulating the
 * KeyManagerFactorySpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param algorithm the standard name of the requested algorithm.
 *          See the <a href=
 *  "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/jsse/JSSERefGuide.html">
 *          Java Secure Socket Extension Reference Guide </a>
 *          for information about standard algorithm names.
 *
 * @param provider an instance of the provider.
 *
 * @return the new <code>KeyManagerFactory</code> object.
 *
 * @throws NoSuchAlgorithmException if a KeyManagerFactorySpi
 *          implementation for the specified algorithm is not available
 *          from the specified Provider object.
 *
 * @throws IllegalArgumentException if provider is null.
 * @throws NullPointerException if <code>algorithm</code> is null.
 *
 * @see java.security.Provider
 */

public static final javax.net.ssl.KeyManagerFactory getInstance(java.lang.String algorithm, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this <code>KeyManagerFactory</code> object.
 *
 * @return the provider of this <code>KeyManagerFactory</code> object
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Initializes this factory with a source of key material.
 * <P>
 * The provider typically uses a KeyStore for obtaining
 * key material for use during secure socket negotiations.
 * The KeyStore is generally password-protected.
 * <P>
 * For more flexible initialization, please see
 * {@link #init(ManagerFactoryParameters)}.
 * <P>
 *
 * @param ks the key store or null
 * @param password the password for recovering keys in the KeyStore
 * @throws KeyStoreException if this operation fails
 * @throws NoSuchAlgorithmException if the specified algorithm is not
 *          available from the specified provider.
 * @throws UnrecoverableKeyException if the key cannot be recovered
 *          (e.g. the given password is wrong).
 */

public final void init(java.security.KeyStore ks, char[] password) throws java.security.KeyStoreException, java.security.NoSuchAlgorithmException, java.security.UnrecoverableKeyException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this factory with a source of provider-specific
 * key material.
 * <P>
 * In some cases, initialization parameters other than a keystore
 * and password may be needed by a provider.  Users of that
 * particular provider are expected to pass an implementation of
 * the appropriate <CODE>ManagerFactoryParameters</CODE> as
 * defined by the provider.  The provider can then call the
 * specified methods in the <CODE>ManagerFactoryParameters</CODE>
 * implementation to obtain the needed information.
 *
 * @param spec an implementation of a provider-specific parameter
 *          specification
 * @throws InvalidAlgorithmParameterException if an error is encountered
 */

public final void init(javax.net.ssl.ManagerFactoryParameters spec) throws java.security.InvalidAlgorithmParameterException { throw new RuntimeException("Stub!"); }

/**
 * Returns one key manager for each type of key material.
 *
 * @return the key managers
 * @throws IllegalStateException if the KeyManagerFactory is not initialized
 */

public final javax.net.ssl.KeyManager[] getKeyManagers() { throw new RuntimeException("Stub!"); }
}

