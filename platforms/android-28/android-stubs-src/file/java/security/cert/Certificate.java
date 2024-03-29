/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.security.cert;

import java.security.PublicKey;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.NoSuchProviderException;
import java.security.InvalidKeyException;
import java.security.Provider;

/**
 * <p>Abstract class for managing a variety of identity certificates.
 * An identity certificate is a binding of a principal to a public key which
 * is vouched for by another principal.  (A principal represents
 * an entity such as an individual user, a group, or a corporation.)
 *<p>
 * This class is an abstraction for certificates that have different
 * formats but important common uses.  For example, different types of
 * certificates, such as X.509 and PGP, share general certificate
 * functionality (like encoding and verifying) and
 * some types of information (like a public key).
 * <p>
 * X.509, PGP, and SDSI certificates can all be implemented by
 * subclassing the Certificate class, even though they contain different
 * sets of information, and they store and retrieve the information in
 * different ways.
 *
 * @see X509Certificate
 * @see CertificateFactory
 *
 * @author Hemma Prafullchandra
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Certificate implements java.io.Serializable {

/**
 * Creates a certificate of the specified type.
 *
 * @param type the standard name of the certificate type.
 * See the CertificateFactory section in the <a href=
 * "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/StandardNames.html#CertificateFactory">
 * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
 * for information about standard certificate types.
 */

protected Certificate(java.lang.String type) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of this certificate.
 *
 * @return the type of this certificate.
 */

public final java.lang.String getType() { throw new RuntimeException("Stub!"); }

/**
 * Compares this certificate for equality with the specified
 * object. If the {@code other} object is an
 * {@code instanceof} {@code Certificate}, then
 * its encoded form is retrieved and compared with the
 * encoded form of this certificate.
 *
 * @param other the object to test for equality with this certificate.
 * @return true iff the encoded forms of the two certificates
 * match, false otherwise.
 */

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hashcode value for this certificate from its
 * encoded form.
 *
 * @return the hashcode value.
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the encoded form of this certificate. It is
 * assumed that each certificate type would have only a single
 * form of encoding; for example, X.509 certificates would
 * be encoded as ASN.1 DER.
 *
 * @return the encoded form of this certificate
 *
 * @exception CertificateEncodingException if an encoding error occurs.
 */

public abstract byte[] getEncoded() throws java.security.cert.CertificateEncodingException;

/**
 * Verifies that this certificate was signed using the
 * private key that corresponds to the specified public key.
 *
 * @param key the PublicKey used to carry out the verification.
 *
 * @exception NoSuchAlgorithmException on unsupported signature
 * algorithms.
 * @exception InvalidKeyException on incorrect key.
 * @exception NoSuchProviderException if there's no default provider.
 * @exception SignatureException on signature errors.
 * @exception CertificateException on encoding errors.
 */

public abstract void verify(java.security.PublicKey key) throws java.security.cert.CertificateException, java.security.InvalidKeyException, java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, java.security.SignatureException;

/**
 * Verifies that this certificate was signed using the
 * private key that corresponds to the specified public key.
 * This method uses the signature verification engine
 * supplied by the specified provider.
 *
 * @param key the PublicKey used to carry out the verification.
 * @param sigProvider the name of the signature provider.
 *
 * @exception NoSuchAlgorithmException on unsupported signature
 * algorithms.
 * @exception InvalidKeyException on incorrect key.
 * @exception NoSuchProviderException on incorrect provider.
 * @exception SignatureException on signature errors.
 * @exception CertificateException on encoding errors.
 */

public abstract void verify(java.security.PublicKey key, java.lang.String sigProvider) throws java.security.cert.CertificateException, java.security.InvalidKeyException, java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, java.security.SignatureException;

/**
 * Verifies that this certificate was signed using the
 * private key that corresponds to the specified public key.
 * This method uses the signature verification engine
 * supplied by the specified provider. Note that the specified
 * Provider object does not have to be registered in the provider list.
 *
 * <p> This method was added to version 1.8 of the Java Platform
 * Standard Edition. In order to maintain backwards compatibility with
 * existing service providers, this method cannot be {@code abstract}
 * and by default throws an {@code UnsupportedOperationException}.
 *
 * @param key the PublicKey used to carry out the verification.
 * @param sigProvider the signature provider.
 *
 * @exception NoSuchAlgorithmException on unsupported signature
 * algorithms.
 * @exception InvalidKeyException on incorrect key.
 * @exception SignatureException on signature errors.
 * @exception CertificateException on encoding errors.
 * @exception UnsupportedOperationException if the method is not supported
 * @since 1.8
 */

public void verify(java.security.PublicKey key, java.security.Provider sigProvider) throws java.security.cert.CertificateException, java.security.InvalidKeyException, java.security.NoSuchAlgorithmException, java.security.SignatureException { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this certificate.
 *
 * @return a string representation of this certificate.
 */

public abstract java.lang.String toString();

/**
 * Gets the public key from this certificate.
 *
 * @return the public key.
 */

public abstract java.security.PublicKey getPublicKey();

/**
 * Replace the Certificate to be serialized.
 *
 * @return the alternate Certificate object to be serialized
 *
 * @throws java.io.ObjectStreamException if a new object representing
 * this Certificate could not be created
 * @since 1.3
 */

protected java.lang.Object writeReplace() throws java.io.ObjectStreamException { throw new RuntimeException("Stub!"); }
/**
 * Alternate Certificate class for serialization.
 * @since 1.3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static class CertificateRep implements java.io.Serializable {

/**
 * Construct the alternate Certificate class with the Certificate
 * type and Certificate encoding bytes.
 *
 * <p>
 *
 * @param type the standard name of the Certificate type. <p>
 *
 * @param data the Certificate data.
 */

protected CertificateRep(java.lang.String type, byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Resolve the Certificate Object.
 *
 * <p>
 *
 * @return the resolved Certificate Object
 *
 * @throws java.io.ObjectStreamException if the Certificate
 *      could not be resolved
 */

protected java.lang.Object readResolve() throws java.io.ObjectStreamException { throw new RuntimeException("Stub!"); }
}

}

