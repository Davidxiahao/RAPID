/*
 * Copyright (c) 1997, 2007, Oracle and/or its affiliates. All rights reserved.
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


package javax.crypto.spec;


/**
 * This class specifies a Diffie-Hellman private key with its associated
 * parameters.
 *
 * <p>Note that this class does not perform any validation on specified
 * parameters. Thus, the specified values are returned directly even
 * if they are null.
 *
 * @author Jan Luehe
 *
 * @see DHPublicKeySpec
 * @since 1.4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DHPrivateKeySpec implements java.security.spec.KeySpec {

/**
 * Constructor that takes a private value <code>x</code>, a prime
 * modulus <code>p</code>, and a base generator <code>g</code>.
 * @param x private value x
 * @param p prime modulus p
 * @param g base generator g
 */

public DHPrivateKeySpec(java.math.BigInteger x, java.math.BigInteger p, java.math.BigInteger g) { throw new RuntimeException("Stub!"); }

/**
 * Returns the private value <code>x</code>.
 *
 * @return the private value <code>x</code>
 */

public java.math.BigInteger getX() { throw new RuntimeException("Stub!"); }

/**
 * Returns the prime modulus <code>p</code>.
 *
 * @return the prime modulus <code>p</code>
 */

public java.math.BigInteger getP() { throw new RuntimeException("Stub!"); }

/**
 * Returns the base generator <code>g</code>.
 *
 * @return the base generator <code>g</code>
 */

public java.math.BigInteger getG() { throw new RuntimeException("Stub!"); }
}

