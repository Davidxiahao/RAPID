/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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


package javax.crypto;


/**
 * This class provides the functionality of a key agreement (or key
 * exchange) protocol.
 * <p>
 * The keys involved in establishing a shared secret are created by one of the
 * key generators (<code>KeyPairGenerator</code> or
 * <code>KeyGenerator</code>), a <code>KeyFactory</code>, or as a result from
 * an intermediate phase of the key agreement protocol.
 *
 * <p> For each of the correspondents in the key exchange, <code>doPhase</code>
 * needs to be called. For example, if this key exchange is with one other
 * party, <code>doPhase</code> needs to be called once, with the
 * <code>lastPhase</code> flag set to <code>true</code>.
 * If this key exchange is
 * with two other parties, <code>doPhase</code> needs to be called twice,
 * the first time setting the <code>lastPhase</code> flag to
 * <code>false</code>, and the second time setting it to <code>true</code>.
 * There may be any number of parties involved in a key exchange.
 *
 * <p> Android provides the following <code>KeyAgreement</code> algorithms:
 * <table>
 *   <thead>
 *     <tr>
 *       <th>Algorithm</th>
 *       <th>Supported API Levels</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>DH</td>
 *       <td>1+</td>
 *     </tr>
 *     <tr>
 *       <td>ECDH</td>
 *       <td>11+</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * This algorithm is described in the <a href=
 * "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/StandardNames.html#KeyAgreement">
 * KeyAgreement section</a> of the
 * Java Cryptography Architecture Standard Algorithm Name Documentation.
 *
 * @author Jan Luehe
 *
 * @see KeyGenerator
 * @see SecretKey
 * @since 1.4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class KeyAgreement {

/**
 * Creates a KeyAgreement object.
 *
 * @param keyAgreeSpi the delegate
 * @param provider the provider
 * @param algorithm the algorithm
 */

protected KeyAgreement(javax.crypto.KeyAgreementSpi keyAgreeSpi, java.security.Provider provider, java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Returns the algorithm name of this <code>KeyAgreement</code> object.
 *
 * <p>This is the same name that was specified in one of the
 * <code>getInstance</code> calls that created this
 * <code>KeyAgreement</code> object.
 *
 * @return the algorithm name of this <code>KeyAgreement</code> object.
 */

public final java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>KeyAgreement</code> object that implements the
 * specified key agreement algorithm.
 *
 * <p> This method traverses the list of registered security Providers,
 * starting with the most preferred Provider.
 * A new KeyAgreement object encapsulating the
 * KeyAgreementSpi implementation from the first
 * Provider that supports the specified algorithm is returned.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link Security#getProviders() Security.getProviders()} method.
 *
 * @param algorithm the standard name of the requested key agreement
 * algorithm.
 * See the KeyAgreement section in the <a href=
 * "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/StandardNames.html#KeyAgreement">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @return the new <code>KeyAgreement</code> object.
 *
 * @exception NullPointerException if the specified algorithm
 *          is null.
 *
 * @exception NoSuchAlgorithmException if no Provider supports a
 *          KeyAgreementSpi implementation for the
 *          specified algorithm.
 *
 * @see java.security.Provider
 */

public static final javax.crypto.KeyAgreement getInstance(java.lang.String algorithm) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>KeyAgreement</code> object that implements the
 * specified key agreement algorithm.
 *
 * <p> A new KeyAgreement object encapsulating the
 * KeyAgreementSpi implementation from the specified provider
 * is returned.  The specified provider must be registered
 * in the security provider list.
 *
 * <p> Note that the list of registered providers may be retrieved via
 * the {@link Security#getProviders() Security.getProviders()} method.
 *
 * @param algorithm the standard name of the requested key agreement
 * algorithm.
 * See the KeyAgreement section in the <a href=
 * "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/StandardNames.html#KeyAgreement">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the name of the provider.
 *
 * @return the new <code>KeyAgreement</code> object.
 *
 * @exception NullPointerException if the specified algorithm
 *          is null.
 *
 * @exception NoSuchAlgorithmException if a KeyAgreementSpi
 *          implementation for the specified algorithm is not
 *          available from the specified provider.
 *
 * @exception NoSuchProviderException if the specified provider is not
 *          registered in the security provider list.
 *
 * @exception IllegalArgumentException if the <code>provider</code>
 *          is null or empty.
 *
 * @see java.security.Provider
 */

public static final javax.crypto.KeyAgreement getInstance(java.lang.String algorithm, java.lang.String provider) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>KeyAgreement</code> object that implements the
 * specified key agreement algorithm.
 *
 * <p> A new KeyAgreement object encapsulating the
 * KeyAgreementSpi implementation from the specified Provider
 * object is returned.  Note that the specified Provider object
 * does not have to be registered in the provider list.
 *
 * @param algorithm the standard name of the requested key agreement
 * algorithm.
 * See the KeyAgreement section in the <a href=
 * "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/StandardNames.html#KeyAgreement">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard algorithm names.
 *
 * @param provider the provider.
 *
 * @return the new <code>KeyAgreement</code> object.
 *
 * @exception NullPointerException if the specified algorithm
 *          is null.
 *
 * @exception NoSuchAlgorithmException if a KeyAgreementSpi
 *          implementation for the specified algorithm is not available
 *          from the specified Provider object.
 *
 * @exception IllegalArgumentException if the <code>provider</code>
 *          is null.
 *
 * @see java.security.Provider
 */

public static final javax.crypto.KeyAgreement getInstance(java.lang.String algorithm, java.security.Provider provider) throws java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Returns the provider of this <code>KeyAgreement</code> object.
 *
 * @return the provider of this <code>KeyAgreement</code> object
 */

public final java.security.Provider getProvider() { throw new RuntimeException("Stub!"); }

/**
 * Initializes this key agreement with the given key, which is required to
 * contain all the algorithm parameters required for this key agreement.
 *
 * <p> If this key agreement requires any random bytes, it will get
 * them using the
 * {@link java.security.SecureRandom}
 * implementation of the highest-priority
 * installed provider as the source of randomness.
 * (If none of the installed providers supply an implementation of
 * SecureRandom, a system-provided source of randomness will be used.)
 *
 * @param key the party's private information. For example, in the case
 * of the Diffie-Hellman key agreement, this would be the party's own
 * Diffie-Hellman private key.
 *
 * @exception InvalidKeyException if the given key is
 * inappropriate for this key agreement, e.g., is of the wrong type or
 * has an incompatible algorithm type.
 */

public final void init(java.security.Key key) throws java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this key agreement with the given key and source of
 * randomness. The given key is required to contain all the algorithm
 * parameters required for this key agreement.
 *
 * <p> If the key agreement algorithm requires random bytes, it gets them
 * from the given source of randomness, <code>random</code>.
 * However, if the underlying
 * algorithm implementation does not require any random bytes,
 * <code>random</code> is ignored.
 *
 * @param key the party's private information. For example, in the case
 * of the Diffie-Hellman key agreement, this would be the party's own
 * Diffie-Hellman private key.
 * @param random the source of randomness
 *
 * @exception InvalidKeyException if the given key is
 * inappropriate for this key agreement, e.g., is of the wrong type or
 * has an incompatible algorithm type.
 */

public final void init(java.security.Key key, java.security.SecureRandom random) throws java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this key agreement with the given key and set of
 * algorithm parameters.
 *
 * <p> If this key agreement requires any random bytes, it will get
 * them using the
 * {@link java.security.SecureRandom}
 * implementation of the highest-priority
 * installed provider as the source of randomness.
 * (If none of the installed providers supply an implementation of
 * SecureRandom, a system-provided source of randomness will be used.)
 *
 * @param key the party's private information. For example, in the case
 * of the Diffie-Hellman key agreement, this would be the party's own
 * Diffie-Hellman private key.
 * @param params the key agreement parameters
 *
 * @exception InvalidKeyException if the given key is
 * inappropriate for this key agreement, e.g., is of the wrong type or
 * has an incompatible algorithm type.
 * @exception InvalidAlgorithmParameterException if the given parameters
 * are inappropriate for this key agreement.
 */

public final void init(java.security.Key key, java.security.spec.AlgorithmParameterSpec params) throws java.security.InvalidAlgorithmParameterException, java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Initializes this key agreement with the given key, set of
 * algorithm parameters, and source of randomness.
 *
 * @param key the party's private information. For example, in the case
 * of the Diffie-Hellman key agreement, this would be the party's own
 * Diffie-Hellman private key.
 * @param params the key agreement parameters
 * @param random the source of randomness
 *
 * @exception InvalidKeyException if the given key is
 * inappropriate for this key agreement, e.g., is of the wrong type or
 * has an incompatible algorithm type.
 * @exception InvalidAlgorithmParameterException if the given parameters
 * are inappropriate for this key agreement.
 */

public final void init(java.security.Key key, java.security.spec.AlgorithmParameterSpec params, java.security.SecureRandom random) throws java.security.InvalidAlgorithmParameterException, java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Executes the next phase of this key agreement with the given
 * key that was received from one of the other parties involved in this key
 * agreement.
 *
 * @param key the key for this phase. For example, in the case of
 * Diffie-Hellman between 2 parties, this would be the other party's
 * Diffie-Hellman public key.
 * @param lastPhase flag which indicates whether or not this is the last
 * phase of this key agreement.
 *
 * @return the (intermediate) key resulting from this phase, or null
 * if this phase does not yield a key
 *
 * @exception InvalidKeyException if the given key is inappropriate for
 * this phase.
 * @exception IllegalStateException if this key agreement has not been
 * initialized.
 */

public final java.security.Key doPhase(java.security.Key key, boolean lastPhase) throws java.lang.IllegalStateException, java.security.InvalidKeyException { throw new RuntimeException("Stub!"); }

/**
 * Generates the shared secret and returns it in a new buffer.
 *
 * <p>This method resets this <code>KeyAgreement</code> object, so that it
 * can be reused for further key agreements. Unless this key agreement is
 * reinitialized with one of the <code>init</code> methods, the same
 * private information and algorithm parameters will be used for
 * subsequent key agreements.
 *
 * @return the new buffer with the shared secret
 *
 * @exception IllegalStateException if this key agreement has not been
 * completed yet
 */

public final byte[] generateSecret() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Generates the shared secret, and places it into the buffer
 * <code>sharedSecret</code>, beginning at <code>offset</code> inclusive.
 *
 * <p>If the <code>sharedSecret</code> buffer is too small to hold the
 * result, a <code>ShortBufferException</code> is thrown.
 * In this case, this call should be repeated with a larger output buffer.
 *
 * <p>This method resets this <code>KeyAgreement</code> object, so that it
 * can be reused for further key agreements. Unless this key agreement is
 * reinitialized with one of the <code>init</code> methods, the same
 * private information and algorithm parameters will be used for
 * subsequent key agreements.
 *
 * @param sharedSecret the buffer for the shared secret
 * @param offset the offset in <code>sharedSecret</code> where the
 * shared secret will be stored
 *
 * @return the number of bytes placed into <code>sharedSecret</code>
 *
 * @exception IllegalStateException if this key agreement has not been
 * completed yet
 * @exception ShortBufferException if the given output buffer is too small
 * to hold the secret
 */

public final int generateSecret(byte[] sharedSecret, int offset) throws java.lang.IllegalStateException, javax.crypto.ShortBufferException { throw new RuntimeException("Stub!"); }

/**
 * Creates the shared secret and returns it as a <code>SecretKey</code>
 * object of the specified algorithm.
 *
 * <p>This method resets this <code>KeyAgreement</code> object, so that it
 * can be reused for further key agreements. Unless this key agreement is
 * reinitialized with one of the <code>init</code> methods, the same
 * private information and algorithm parameters will be used for
 * subsequent key agreements.
 *
 * @param algorithm the requested secret-key algorithm
 *
 * @return the shared secret key
 *
 * @exception IllegalStateException if this key agreement has not been
 * completed yet
 * @exception NoSuchAlgorithmException if the specified secret-key
 * algorithm is not available
 * @exception InvalidKeyException if the shared secret-key material cannot
 * be used to generate a secret key of the specified algorithm (e.g.,
 * the key material is too short)
 */

public final javax.crypto.SecretKey generateSecret(java.lang.String algorithm) throws java.lang.IllegalStateException, java.security.InvalidKeyException, java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }
}

