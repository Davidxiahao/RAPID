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


package javax.crypto.spec;


/**
 * This class specifies the parameters used with the
 * <a href="http://www.ietf.org/rfc/rfc2040.txt"><i>RC5</i></a>
 * algorithm.
 *
 * <p> The parameters consist of a version number, a rounds count, a word
 * size, and optionally an initialization vector (IV) (only in feedback mode).
 *
 * <p> This class can be used to initialize a <code>Cipher</code> object that
 * implements the <i>RC5</i> algorithm as supplied by
 * <a href="http://www.rsasecurity.com">RSA Security Inc.</a>,
 * or any parties authorized by RSA Security.
 *
 * @author Jan Luehe
 *
 * @since 1.4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RC5ParameterSpec implements java.security.spec.AlgorithmParameterSpec {

/**
 * Constructs a parameter set for RC5 from the given version, number of
 * rounds and word size (in bits).
 *
 * @param version the version.
 * @param rounds the number of rounds.
 * @param wordSize the word size in bits.
 */

public RC5ParameterSpec(int version, int rounds, int wordSize) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a parameter set for RC5 from the given version, number of
 * rounds, word size (in bits), and IV.
 *
 * <p> Note that the size of the IV (block size) must be twice the word
 * size. The bytes that constitute the IV are those between
 * <code>iv[0]</code> and <code>iv[2*(wordSize/8)-1]</code> inclusive.
 *
 * @param version the version.
 * @param rounds the number of rounds.
 * @param wordSize the word size in bits.
 * @param iv the buffer with the IV. The first <code>2*(wordSize/8)
 * </code> bytes of the buffer are copied to protect against subsequent
 * modification.
 * @exception IllegalArgumentException if <code>iv</code> is
 * <code>null</code> or {@code (iv.length < 2 * (wordSize / 8))}
 */

public RC5ParameterSpec(int version, int rounds, int wordSize, byte[] iv) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a parameter set for RC5 from the given version, number of
 * rounds, word size (in bits), and IV.
 *
 * <p> The IV is taken from <code>iv</code>, starting at
 * <code>offset</code> inclusive.
 * Note that the size of the IV (block size), starting at
 * <code>offset</code> inclusive, must be twice the word size.
 * The bytes that constitute the IV are those between
 * <code>iv[offset]</code> and <code>iv[offset+2*(wordSize/8)-1]</code>
 * inclusive.
 *
 * @param version the version.
 * @param rounds the number of rounds.
 * @param wordSize the word size in bits.
 * @param iv the buffer with the IV. The first <code>2*(wordSize/8)
 * </code> bytes of the buffer beginning at <code>offset</code>
 * inclusive are copied to protect against subsequent modification.
 * @param offset the offset in <code>iv</code> where the IV starts.
 * @exception IllegalArgumentException if <code>iv</code> is
 * <code>null</code> or
 * {@code (iv.length - offset < 2 * (wordSize / 8))}
 */

public RC5ParameterSpec(int version, int rounds, int wordSize, byte[] iv, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Returns the version.
 *
 * @return the version.
 */

public int getVersion() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of rounds.
 *
 * @return the number of rounds.
 */

public int getRounds() { throw new RuntimeException("Stub!"); }

/**
 * Returns the word size in bits.
 *
 * @return the word size in bits.
 */

public int getWordSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the IV or null if this parameter set does not contain an IV.
 *
 * @return the IV or null if this parameter set does not contain an IV.
 * Returns a new array each time this method is called.
 */

public byte[] getIV() { throw new RuntimeException("Stub!"); }

/**
 * Tests for equality between the specified object and this
 * object. Two RC5ParameterSpec objects are considered equal if their
 * version numbers, number of rounds, word sizes, and IVs are equal.
 * (Two IV references are considered equal if both are <tt>null</tt>.)
 *
 * @param obj the object to test for equality with this object.
 *
 * @return true if the objects are considered equal, false if
 * <code>obj</code> is null or otherwise.
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Calculates a hash code value for the object.
 * Objects that are equal will also have the same hashcode.
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

