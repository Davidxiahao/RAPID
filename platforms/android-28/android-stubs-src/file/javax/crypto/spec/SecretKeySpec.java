/*
 * Copyright (c) 1998, 2015, Oracle and/or its affiliates. All rights reserved.
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

import javax.crypto.SecretKey;
import java.security.spec.KeySpec;

/**
 * This class specifies a secret key in a provider-independent fashion.
 *
 * <p>It can be used to construct a <code>SecretKey</code> from a byte array,
 * without having to go through a (provider-based)
 * <code>SecretKeyFactory</code>.
 *
 * <p>This class is only useful for raw secret keys that can be represented as
 * a byte array and have no key parameters associated with them, e.g., DES or
 * Triple DES keys.
 *
 * @author Jan Luehe
 *
 * @see javax.crypto.SecretKey
 * @see javax.crypto.SecretKeyFactory
 * @since 1.4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SecretKeySpec implements java.security.spec.KeySpec, javax.crypto.SecretKey {

/**
 * Constructs a secret key from the given byte array.
 *
 * <p>This constructor does not check if the given bytes indeed specify a
 * secret key of the specified algorithm. For example, if the algorithm is
 * DES, this constructor does not check if <code>key</code> is 8 bytes
 * long, and also does not check for weak or semi-weak keys.
 * In order for those checks to be performed, an algorithm-specific
 * <i>key specification</i> class (in this case:
 * {@link DESKeySpec DESKeySpec})
 * should be used.
 *
 * @param key the key material of the secret key. The contents of
 * the array are copied to protect against subsequent modification.
 * @param algorithm the name of the secret-key algorithm to be associated
 * with the given key material.
 * See Appendix A in the <a href=
 *   "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/crypto/CryptoSpec.html#AppA">
 * Java Cryptography Architecture Reference Guide</a>
 * for information about standard algorithm names.
 * @exception IllegalArgumentException if <code>algorithm</code>
 * is null or <code>key</code> is null or empty.
 */

public SecretKeySpec(byte[] key, java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a secret key from the given byte array, using the first
 * <code>len</code> bytes of <code>key</code>, starting at
 * <code>offset</code> inclusive.
 *
 * <p> The bytes that constitute the secret key are
 * those between <code>key[offset]</code> and
 * <code>key[offset+len-1]</code> inclusive.
 *
 * <p>This constructor does not check if the given bytes indeed specify a
 * secret key of the specified algorithm. For example, if the algorithm is
 * DES, this constructor does not check if <code>key</code> is 8 bytes
 * long, and also does not check for weak or semi-weak keys.
 * In order for those checks to be performed, an algorithm-specific key
 * specification class (in this case:
 * {@link DESKeySpec DESKeySpec})
 * must be used.
 *
 * @param key the key material of the secret key. The first
 * <code>len</code> bytes of the array beginning at
 * <code>offset</code> inclusive are copied to protect
 * against subsequent modification.
 * @param offset the offset in <code>key</code> where the key material
 * starts.
 * @param len the length of the key material.
 * @param algorithm the name of the secret-key algorithm to be associated
 * with the given key material.
 * See Appendix A in the <a href=
 *   "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/crypto/CryptoSpec.html#AppA">
 * Java Cryptography Architecture Reference Guide</a>
 * for information about standard algorithm names.
 * @exception IllegalArgumentException if <code>algorithm</code>
 * is null or <code>key</code> is null, empty, or too short,
 * i.e. {@code key.length-offset<len}.
 * @exception ArrayIndexOutOfBoundsException is thrown if
 * <code>offset</code> or <code>len</code> index bytes outside the
 * <code>key</code>.
 */

public SecretKeySpec(byte[] key, int offset, int len, java.lang.String algorithm) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the algorithm associated with this secret key.
 *
 * @return the secret key algorithm.
 */

public java.lang.String getAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the encoding format for this secret key.
 *
 * @return the string "RAW".
 */

public java.lang.String getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the key material of this secret key.
 *
 * @return the key material. Returns a new array
 * each time this method is called.
 */

public byte[] getEncoded() { throw new RuntimeException("Stub!"); }

/**
 * Calculates a hash code value for the object.
 * Objects that are equal will also have the same hashcode.
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Tests for equality between the specified object and this
 * object. Two SecretKeySpec objects are considered equal if
 * they are both SecretKey instances which have the
 * same case-insensitive algorithm name and key encoding.
 *
 * @param obj the object to test for equality with this object.
 *
 * @return true if the objects are considered equal, false if
 * <code>obj</code> is null or otherwise.
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }
}

