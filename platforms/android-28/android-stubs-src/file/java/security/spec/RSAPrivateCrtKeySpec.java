/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.security.spec;


/**
 * This class specifies an RSA private key, as defined in the PKCS#1
 * standard, using the Chinese Remainder Theorem (CRT) information values for
 * efficiency.
 *
 * @author Jan Luehe
 *
 *
 * @see java.security.Key
 * @see java.security.KeyFactory
 * @see KeySpec
 * @see PKCS8EncodedKeySpec
 * @see RSAPrivateKeySpec
 * @see RSAPublicKeySpec
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RSAPrivateCrtKeySpec extends java.security.spec.RSAPrivateKeySpec {

/**
 * Creates a new {@code RSAPrivateCrtKeySpec}
 * given the modulus, publicExponent, privateExponent,
 * primeP, primeQ, primeExponentP, primeExponentQ, and
 * crtCoefficient as defined in PKCS#1.
 *
 * @param modulus the modulus n
 * @param publicExponent the public exponent e
 * @param privateExponent the private exponent d
 * @param primeP the prime factor p of n
 * @param primeQ the prime factor q of n
 * @param primeExponentP this is d mod (p-1)
 * @param primeExponentQ this is d mod (q-1)
 * @param crtCoefficient the Chinese Remainder Theorem
 * coefficient q-1 mod p
 */

public RSAPrivateCrtKeySpec(java.math.BigInteger modulus, java.math.BigInteger publicExponent, java.math.BigInteger privateExponent, java.math.BigInteger primeP, java.math.BigInteger primeQ, java.math.BigInteger primeExponentP, java.math.BigInteger primeExponentQ, java.math.BigInteger crtCoefficient) { super(null, null); throw new RuntimeException("Stub!"); }

/**
 * Returns the public exponent.
 *
 * @return the public exponent
 */

public java.math.BigInteger getPublicExponent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the primeP.
 
 * @return the primeP
 */

public java.math.BigInteger getPrimeP() { throw new RuntimeException("Stub!"); }

/**
 * Returns the primeQ.
 *
 * @return the primeQ
 */

public java.math.BigInteger getPrimeQ() { throw new RuntimeException("Stub!"); }

/**
 * Returns the primeExponentP.
 *
 * @return the primeExponentP
 */

public java.math.BigInteger getPrimeExponentP() { throw new RuntimeException("Stub!"); }

/**
 * Returns the primeExponentQ.
 *
 * @return the primeExponentQ
 */

public java.math.BigInteger getPrimeExponentQ() { throw new RuntimeException("Stub!"); }

/**
 * Returns the crtCoefficient.
 *
 * @return the crtCoefficient
 */

public java.math.BigInteger getCrtCoefficient() { throw new RuntimeException("Stub!"); }
}

