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


package java.security.interfaces;


/**
 * The interface to an RSA private key, as defined in the PKCS#1 standard,
 * using the <i>Chinese Remainder Theorem</i> (CRT) information values.
 *
 * @author Jan Luehe
 *
 *
 * @see RSAPrivateKey
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface RSAPrivateCrtKey extends java.security.interfaces.RSAPrivateKey {

/**
 * Returns the public exponent.
 *
 * @return the public exponent
 */

public java.math.BigInteger getPublicExponent();

/**
 * Returns the primeP.
 
 * @return the primeP
 */

public java.math.BigInteger getPrimeP();

/**
 * Returns the primeQ.
 *
 * @return the primeQ
 */

public java.math.BigInteger getPrimeQ();

/**
 * Returns the primeExponentP.
 *
 * @return the primeExponentP
 */

public java.math.BigInteger getPrimeExponentP();

/**
 * Returns the primeExponentQ.
 *
 * @return the primeExponentQ
 */

public java.math.BigInteger getPrimeExponentQ();

/**
 * Returns the crtCoefficient.
 *
 * @return the crtCoefficient
 */

public java.math.BigInteger getCrtCoefficient();

/**
 * The type fingerprint that is set to indicate
 * serialization compatibility with a previous
 * version of the type.
 */

public static final long serialVersionUID = -5682214253527700368L; // 0xb124b83df8d1ec70L
}

