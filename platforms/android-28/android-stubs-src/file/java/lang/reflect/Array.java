/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.lang.reflect;


/**
 * The {@code Array} class provides static methods to dynamically create and
 * access Java arrays.
 *
 * <p>{@code Array} permits widening conversions to occur during a get or set
 * operation, but throws an {@code IllegalArgumentException} if a narrowing
 * conversion would occur.
 *
 * @author Nakul Saraiya
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Array {

/**
 * Constructor.  Class Array is not instantiable.
 */

Array() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new array with the specified component type and
 * length.
 * Invoking this method is equivalent to creating an array
 * as follows:
 * <blockquote>
 * <pre>
 * int[] x = {length};
 * Array.newInstance(componentType, x);
 * </pre>
 * </blockquote>
 *
 * <p>The number of dimensions of the new array must not
 * exceed 255.
 *
 * @param componentType the {@code Class} object representing the
 * component type of the new array
 * @param length the length of the new array
 * @return the new array
 * @exception NullPointerException if the specified
 * {@code componentType} parameter is null
 * @exception IllegalArgumentException if componentType is {@link
 * Void#TYPE} or if the number of dimensions of the requested array
 * instance exceed 255.
 * @exception NegativeArraySizeException if the specified {@code length}
 * is negative
 */

@androidx.annotation.RecentlyNonNull public static java.lang.Object newInstance(java.lang.Class<?> componentType, int length) throws java.lang.NegativeArraySizeException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new array
 * with the specified component type and dimensions.
 * If {@code componentType}
 * represents a non-array class or interface, the new array
 * has {@code dimensions.length} dimensions and
 * {@code componentType} as its component type. If
 * {@code componentType} represents an array class, the
 * number of dimensions of the new array is equal to the sum
 * of {@code dimensions.length} and the number of
 * dimensions of {@code componentType}. In this case, the
 * component type of the new array is the component type of
 * {@code componentType}.
 *
 * <p>The number of dimensions of the new array must not
 * exceed 255.
 *
 * @param componentType the {@code Class} object representing the component
 * type of the new array
 * @param dimensions an array of {@code int} representing the dimensions of
 * the new array
 * @return the new array
 * @exception NullPointerException if the specified
 * {@code componentType} argument is null
 * @exception IllegalArgumentException if the specified {@code dimensions}
 * argument is a zero-dimensional array, if componentType is {@link
 * Void#TYPE}, or if the number of dimensions of the requested array
 * instance exceed 255.
 * @exception NegativeArraySizeException if any of the components in
 * the specified {@code dimensions} argument is negative.
 */

@androidx.annotation.RecentlyNonNull public static java.lang.Object newInstance(java.lang.Class<?> componentType, int... dimensions) throws java.lang.IllegalArgumentException, java.lang.NegativeArraySizeException { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the specified array object, as an {@code int}.
 *
 * @param array the array
 * @return the length of the array
 * @exception IllegalArgumentException if the object argument is not
 * an array
 */

public static int getLength(java.lang.Object array) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the indexed component in the specified
 * array object.  The value is automatically wrapped in an object
 * if it has a primitive type.
 *
 * @param array the array
 * @param index the index
 * @return the (possibly wrapped) value of the indexed component in
 * the specified array
 * @exception NullPointerException If the specified object is null
 * @exception IllegalArgumentException If the specified object is not
 * an array
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to the
 * length of the specified array
 */

public static java.lang.Object get(java.lang.Object array, int index) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the indexed component in the specified
 * array object, as a {@code boolean}.
 *
 * @param array the array
 * @param index the index
 * @return the value of the indexed component in the specified array
 * @exception NullPointerException If the specified object is null
 * @exception IllegalArgumentException If the specified object is not
 * an array, or if the indexed element cannot be converted to the
 * return type by an identity or widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to the
 * length of the specified array
 * @see Array#get
 */

public static boolean getBoolean(java.lang.Object array, int index) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the indexed component in the specified
 * array object, as a {@code byte}.
 *
 * @param array the array
 * @param index the index
 * @return the value of the indexed component in the specified array
 * @exception NullPointerException If the specified object is null
 * @exception IllegalArgumentException If the specified object is not
 * an array, or if the indexed element cannot be converted to the
 * return type by an identity or widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to the
 * length of the specified array
 * @see Array#get
 */

public static byte getByte(java.lang.Object array, int index) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the indexed component in the specified
 * array object, as a {@code char}.
 *
 * @param array the array
 * @param index the index
 * @return the value of the indexed component in the specified array
 * @exception NullPointerException If the specified object is null
 * @exception IllegalArgumentException If the specified object is not
 * an array, or if the indexed element cannot be converted to the
 * return type by an identity or widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to the
 * length of the specified array
 * @see Array#get
 */

public static char getChar(java.lang.Object array, int index) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the indexed component in the specified
 * array object, as a {@code short}.
 *
 * @param array the array
 * @param index the index
 * @return the value of the indexed component in the specified array
 * @exception NullPointerException If the specified object is null
 * @exception IllegalArgumentException If the specified object is not
 * an array, or if the indexed element cannot be converted to the
 * return type by an identity or widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to the
 * length of the specified array
 * @see Array#get
 */

public static short getShort(java.lang.Object array, int index) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the indexed component in the specified
 * array object, as an {@code int}.
 *
 * @param array the array
 * @param index the index
 * @return the value of the indexed component in the specified array
 * @exception NullPointerException If the specified object is null
 * @exception IllegalArgumentException If the specified object is not
 * an array, or if the indexed element cannot be converted to the
 * return type by an identity or widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to the
 * length of the specified array
 * @see Array#get
 */

public static int getInt(java.lang.Object array, int index) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the indexed component in the specified
 * array object, as a {@code long}.
 *
 * @param array the array
 * @param index the index
 * @return the value of the indexed component in the specified array
 * @exception NullPointerException If the specified object is null
 * @exception IllegalArgumentException If the specified object is not
 * an array, or if the indexed element cannot be converted to the
 * return type by an identity or widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to the
 * length of the specified array
 * @see Array#get
 */

public static long getLong(java.lang.Object array, int index) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the indexed component in the specified
 * array object, as a {@code float}.
 *
 * @param array the array
 * @param index the index
 * @return the value of the indexed component in the specified array
 * @exception NullPointerException If the specified object is null
 * @exception IllegalArgumentException If the specified object is not
 * an array, or if the indexed element cannot be converted to the
 * return type by an identity or widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to the
 * length of the specified array
 * @see Array#get
 */

public static float getFloat(java.lang.Object array, int index) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the indexed component in the specified
 * array object, as a {@code double}.
 *
 * @param array the array
 * @param index the index
 * @return the value of the indexed component in the specified array
 * @exception NullPointerException If the specified object is null
 * @exception IllegalArgumentException If the specified object is not
 * an array, or if the indexed element cannot be converted to the
 * return type by an identity or widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to the
 * length of the specified array
 * @see Array#get
 */

public static double getDouble(java.lang.Object array, int index) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of the indexed component of the specified array
 * object to the specified new value.  The new value is first
 * automatically unwrapped if the array has a primitive component
 * type.
 * @param array the array
 * @param index the index into the array
 * @param value the new value of the indexed component
 * @exception NullPointerException If the specified object argument
 * is null
 * @exception IllegalArgumentException If the specified object argument
 * is not an array, or if the array component type is primitive and
 * an unwrapping conversion fails
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to
 * the length of the specified array
 */

public static void set(java.lang.Object array, int index, java.lang.Object value) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of the indexed component of the specified array
 * object to the specified {@code boolean} value.
 * @param array the array
 * @param index the index into the array
 * @param z the new value of the indexed component
 * @exception NullPointerException If the specified object argument
 * is null
 * @exception IllegalArgumentException If the specified object argument
 * is not an array, or if the specified value cannot be converted
 * to the underlying array's component type by an identity or a
 * primitive widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to
 * the length of the specified array
 * @see Array#set
 */

public static void setBoolean(java.lang.Object array, int index, boolean z) { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of the indexed component of the specified array
 * object to the specified {@code byte} value.
 * @param array the array
 * @param index the index into the array
 * @param b the new value of the indexed component
 * @exception NullPointerException If the specified object argument
 * is null
 * @exception IllegalArgumentException If the specified object argument
 * is not an array, or if the specified value cannot be converted
 * to the underlying array's component type by an identity or a
 * primitive widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to
 * the length of the specified array
 * @see Array#set
 */

public static void setByte(java.lang.Object array, int index, byte b) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of the indexed component of the specified array
 * object to the specified {@code char} value.
 * @param array the array
 * @param index the index into the array
 * @param c the new value of the indexed component
 * @exception NullPointerException If the specified object argument
 * is null
 * @exception IllegalArgumentException If the specified object argument
 * is not an array, or if the specified value cannot be converted
 * to the underlying array's component type by an identity or a
 * primitive widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to
 * the length of the specified array
 * @see Array#set
 */

public static void setChar(java.lang.Object array, int index, char c) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of the indexed component of the specified array
 * object to the specified {@code short} value.
 * @param array the array
 * @param index the index into the array
 * @param s the new value of the indexed component
 * @exception NullPointerException If the specified object argument
 * is null
 * @exception IllegalArgumentException If the specified object argument
 * is not an array, or if the specified value cannot be converted
 * to the underlying array's component type by an identity or a
 * primitive widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to
 * the length of the specified array
 * @see Array#set
 */

public static void setShort(java.lang.Object array, int index, short s) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of the indexed component of the specified array
 * object to the specified {@code int} value.
 * @param array the array
 * @param index the index into the array
 * @param i the new value of the indexed component
 * @exception NullPointerException If the specified object argument
 * is null
 * @exception IllegalArgumentException If the specified object argument
 * is not an array, or if the specified value cannot be converted
 * to the underlying array's component type by an identity or a
 * primitive widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to
 * the length of the specified array
 * @see Array#set
 */

public static void setInt(java.lang.Object array, int index, int i) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of the indexed component of the specified array
 * object to the specified {@code long} value.
 * @param array the array
 * @param index the index into the array
 * @param l the new value of the indexed component
 * @exception NullPointerException If the specified object argument
 * is null
 * @exception IllegalArgumentException If the specified object argument
 * is not an array, or if the specified value cannot be converted
 * to the underlying array's component type by an identity or a
 * primitive widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to
 * the length of the specified array
 * @see Array#set
 */

public static void setLong(java.lang.Object array, int index, long l) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of the indexed component of the specified array
 * object to the specified {@code float} value.
 * @param array the array
 * @param index the index into the array
 * @param f the new value of the indexed component
 * @exception NullPointerException If the specified object argument
 * is null
 * @exception IllegalArgumentException If the specified object argument
 * is not an array, or if the specified value cannot be converted
 * to the underlying array's component type by an identity or a
 * primitive widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to
 * the length of the specified array
 * @see Array#set
 */

public static void setFloat(java.lang.Object array, int index, float f) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of the indexed component of the specified array
 * object to the specified {@code double} value.
 * @param array the array
 * @param index the index into the array
 * @param d the new value of the indexed component
 * @exception NullPointerException If the specified object argument
 * is null
 * @exception IllegalArgumentException If the specified object argument
 * is not an array, or if the specified value cannot be converted
 * to the underlying array's component type by an identity or a
 * primitive widening conversion
 * @exception ArrayIndexOutOfBoundsException If the specified {@code index}
 * argument is negative, or if it is greater than or equal to
 * the length of the specified array
 * @see Array#set
 */

public static void setDouble(java.lang.Object array, int index, double d) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }
}

