/*
 * Copyright (c) 1999, 2008, Oracle and/or its affiliates. All rights reserved.
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
 * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
 * for the <code>TrustManagerFactory</code> class.
 *
 * <p> All the abstract methods in this class must be implemented by each
 * cryptographic service provider who wishes to supply the implementation
 * of a particular trust manager factory.
 *
 * @since 1.4
 * @see TrustManagerFactory
 * @see TrustManager
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class TrustManagerFactorySpi {

public TrustManagerFactorySpi() { throw new RuntimeException("Stub!"); }

/**
 * Initializes this factory with a source of certificate
 * authorities and related trust material.
 *
 * @param ks the key store or null
 * @throws KeyStoreException if this operation fails
 * @see TrustManagerFactory#init(KeyStore)
 */

protected abstract void engineInit(java.security.KeyStore ks) throws java.security.KeyStoreException;

/**
 * Initializes this factory with a source of provider-specific
 * key material.
 * <P>
 * In some cases, initialization parameters other than a keystore
 * may be needed by a provider.  Users of that
 * particular provider are expected to pass an implementation of
 * the appropriate <CODE>ManagerFactoryParameters</CODE> as
 * defined by the provider.  The provider can then call the
 * specified methods in the <CODE>ManagerFactoryParameters</CODE>
 * implementation to obtain the needed information.
 *
 * @param spec an implementation of a provider-specific parameter
 *          specification
 * @throws InvalidAlgorithmParameterException if there is problem
 *          with the parameters
 * @see TrustManagerFactory#init(ManagerFactoryParameters spec)
 */

protected abstract void engineInit(javax.net.ssl.ManagerFactoryParameters spec) throws java.security.InvalidAlgorithmParameterException;

/**
 * Returns one trust manager for each type of trust material.
 *
 * @throws IllegalStateException if the factory is not initialized.
 *
 * @return the trust managers
 */

protected abstract javax.net.ssl.TrustManager[] engineGetTrustManagers();
}

