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


package java.security.spec;


/**
 * This class specifies a DSA private key with its associated parameters.
 *
 * @author Jan Luehe
 *
 *
 * @see java.security.Key
 * @see java.security.KeyFactory
 * @see KeySpec
 * @see DSAPublicKeySpec
 * @see PKCS8EncodedKeySpec
 *
 * @since 1.2
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DSAPrivateKeySpec implements java.security.spec.KeySpec {

/**
 * Creates a new DSAPrivateKeySpec with the specified parameter values.
 *
 * @param x the private key.
 *
 * @param p the prime.
 *
 * @param q the sub-prime.
 *
 * @param g the base.
 */

public DSAPrivateKeySpec(java.math.BigInteger x, java.math.BigInteger p, java.math.BigInteger q, java.math.BigInteger g) { throw new RuntimeException("Stub!"); }

/**
 * Returns the private key {@code x}.
 *
 * @return the private key {@code x}.
 */

public java.math.BigInteger getX() { throw new RuntimeException("Stub!"); }

/**
 * Returns the prime {@code p}.
 *
 * @return the prime {@code p}.
 */

public java.math.BigInteger getP() { throw new RuntimeException("Stub!"); }

/**
 * Returns the sub-prime {@code q}.
 *
 * @return the sub-prime {@code q}.
 */

public java.math.BigInteger getQ() { throw new RuntimeException("Stub!"); }

/**
 * Returns the base {@code g}.
 *
 * @return the base {@code g}.
 */

public java.math.BigInteger getG() { throw new RuntimeException("Stub!"); }
}

