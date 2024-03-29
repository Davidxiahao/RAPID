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


package java.security;


/**
 * <p> SignedObject is a class for the purpose of creating authentic
 * runtime objects whose integrity cannot be compromised without being
 * detected.
 *
 * <p> More specifically, a SignedObject contains another Serializable
 * object, the (to-be-)signed object and its signature.
 *
 * <p> The signed object is a "deep copy" (in serialized form) of an
 * original object.  Once the copy is made, further manipulation of
 * the original object has no side effect on the copy.
 *
 * <p> The underlying signing algorithm is designated by the Signature
 * object passed to the constructor and the {@code verify} method.
 * A typical usage for signing is the following:
 *
 * <pre>{@code
 * Signature signingEngine = Signature.getInstance(algorithm,
 *                                                 provider);
 * SignedObject so = new SignedObject(myobject, signingKey,
 *                                    signingEngine);
 * }</pre>
 *
 * <p> A typical usage for verification is the following (having
 * received SignedObject {@code so}):
 *
 * <pre>{@code
 * Signature verificationEngine =
 *     Signature.getInstance(algorithm, provider);
 * if (so.verify(publickey, verificationEngine))
 *     try {
 *         Object myobj = so.getObject();
 *     } catch (java.lang.ClassNotFoundException e) {};
 * }</pre>
 *
 * <p> Several points are worth noting.  First, there is no need to
 * initialize the signing or verification engine, as it will be
 * re-initialized inside the constructor and the {@code verify}
 * method. Secondly, for verification to succeed, the specified
 * public key must be the public key corresponding to the private key
 * used to generate the SignedObject.
 *
 * <p> More importantly, for flexibility reasons, the
 * constructor and {@code verify} method allow for
 * customized signature engines, which can implement signature
 * algorithms that are not installed formally as part of a crypto
 * provider.  However, it is crucial that the programmer writing the
 * verifier code be aware what {@code Signature} engine is being
 * used, as its own implementation of the {@code verify} method
 * is invoked to verify a signature.  In other words, a malicious
 * {@code Signature} may choose to always return true on
 * verification in an attempt to bypass a security check.
 *
 * <p> The signature algorithm can be, among others, the NIST standard
 * DSA, using DSA and SHA-1.  The algorithm is specified using the
 * same convention as that for signatures. The DSA algorithm using the
 * SHA-1 message digest algorithm can be specified, for example, as
 * "SHA/DSA" or "SHA-1/DSA" (they are equivalent).  In the case of
 * RSA, there are multiple choices for the message digest algorithm,
 * so the signing algorithm could be specified as, for example,
 * "MD2/RSA", "MD5/RSA" or "SHA-1/RSA".  The algorithm name must be
 * specified, as there is no default.
 *
 * <p> The name of the Cryptography Package Provider is designated
 * also by the Signature parameter to the constructor and the
 * {@code verify} method.  If the provider is not
 * specified, the default provider is used.  Each installation can
 * be configured to use a particular provider as default.
 *
 * <p> Potential applications of SignedObject include:
 * <ul>
 * <li> It can be used
 * internally to any Java runtime as an unforgeable authorization
 * token -- one that can be passed around without the fear that the
 * token can be maliciously modified without being detected.
 * <li> It
 * can be used to sign and serialize data/object for storage outside
 * the Java runtime (e.g., storing critical access control data on
 * disk).
 * <li> Nested SignedObjects can be used to construct a logical
 * sequence of signatures, resembling a chain of authorization and
 * delegation.
 * </ul>
 *
 * @see Signature
 *
 * @author Li Gong
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SignedObject implements java.io.Serializable {

/**
 * Constructs a SignedObject from any Serializable object.
 * The given object is signed with the given signing key, using the
 * designated signature engine.
 *
 * @param object the object to be signed.
 * @param signingKey the private key for signing.
 * @param signingEngine the signature signing engine.
 *
 * @exception IOException if an error occurs during serialization
 * @exception InvalidKeyException if the key is invalid.
 * @exception SignatureException if signing fails.
 */

public SignedObject(java.io.Serializable object, java.security.PrivateKey signingKey, java.security.Signature signingEngine) throws java.io.IOException, java.security.InvalidKeyException, java.security.SignatureException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the encapsulated object.
 * The encapsulated object is de-serialized before it is returned.
 *
 * @return the encapsulated object.
 *
 * @exception IOException if an error occurs during de-serialization
 * @exception ClassNotFoundException if an error occurs during
 * de-serialization
 */

public java.lang.Object getObject() throws java.lang.ClassNotFoundException, java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the signature on the signed object, in the form of a
 * byte array.
 *
 * @return the signature. Returns a new array each time this
 * method is called.
 */

public byte[] getSignature() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the name of the signature algorithm.
 *
 * @return the signature algorithm name.
 */

public java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Verifies that the signature in this SignedObject is the valid
 * signature for the object stored inside, with the given
 * verification key, using the designated verification engine.
 *
 * @param verificationKey the public key for verification.
 * @param verificationEngine the signature verification engine.
 *
 * @exception SignatureException if signature verification failed.
 * @exception InvalidKeyException if the verification key is invalid.
 *
 * @return {@code true} if the signature
 * is valid, {@code false} otherwise
 */

public boolean verify(java.security.PublicKey verificationKey, java.security.Signature verificationEngine) throws java.security.InvalidKeyException, java.security.SignatureException { throw new RuntimeException("Stub!"); }
}

