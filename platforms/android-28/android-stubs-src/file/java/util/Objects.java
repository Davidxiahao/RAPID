/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.util;

import java.util.function.Supplier;

/**
 * This class consists of {@code static} utility methods for operating
 * on objects.  These utilities include {@code null}-safe or {@code
 * null}-tolerant methods for computing the hash code of an object,
 * returning a string for an object, and comparing two objects.
 *
 * @since 1.7
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Objects {

Objects() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the arguments are equal to each other
 * and {@code false} otherwise.
 * Consequently, if both arguments are {@code null}, {@code true}
 * is returned and if exactly one argument is {@code null}, {@code
 * false} is returned.  Otherwise, equality is determined by using
 * the {@link Object#equals equals} method of the first
 * argument.
 *
 * @param a an object
 * @param b an object to be compared with {@code a} for equality
 * @return {@code true} if the arguments are equal to each other
 * and {@code false} otherwise
 * @see Object#equals(Object)
 */

public static boolean equals(java.lang.Object a, java.lang.Object b) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the arguments are deeply equal to each other
 * and {@code false} otherwise.
 *
 * Two {@code null} values are deeply equal.  If both arguments are
 * arrays, the algorithm in {@link Arrays#deepEquals(Object[],
 * Object[]) Arrays.deepEquals} is used to determine equality.
 * Otherwise, equality is determined by using the {@link
 * Object#equals equals} method of the first argument.
 *
 * @param a an object
 * @param b an object to be compared with {@code a} for deep equality
 * @return {@code true} if the arguments are deeply equal to each other
 * and {@code false} otherwise
 * @see Arrays#deepEquals(Object[], Object[])
 * @see Objects#equals(Object, Object)
 */

public static boolean deepEquals(java.lang.Object a, java.lang.Object b) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code of a non-{@code null} argument and 0 for
 * a {@code null} argument.
 *
 * @param o an object
 * @return the hash code of a non-{@code null} argument and 0 for
 * a {@code null} argument
 * @see Object#hashCode
 */

public static int hashCode(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Generates a hash code for a sequence of input values. The hash
 * code is generated as if all the input values were placed into an
 * array, and that array were hashed by calling {@link
 * Arrays#hashCode(Object[])}.
 *
 * <p>This method is useful for implementing {@link
 * Object#hashCode()} on objects containing multiple fields. For
 * example, if an object that has three fields, {@code x}, {@code
 * y}, and {@code z}, one could write:
 *
 * <blockquote><pre>
 * &#064;Override public int hashCode() {
 *     return Objects.hash(x, y, z);
 * }
 * </pre></blockquote>
 *
 * <b>Warning: When a single object reference is supplied, the returned
 * value does not equal the hash code of that object reference.</b> This
 * value can be computed by calling {@link #hashCode(Object)}.
 *
 * @param values the values to be hashed
 * @return a hash value of the sequence of input values
 * @see Arrays#hashCode(Object[])
 * @see List#hashCode
 */

public static int hash(java.lang.Object... values) { throw new RuntimeException("Stub!"); }

/**
 * Returns the result of calling {@code toString} for a non-{@code
 * null} argument and {@code "null"} for a {@code null} argument.
 *
 * @param o an object
 * @return the result of calling {@code toString} for a non-{@code
 * null} argument and {@code "null"} for a {@code null} argument
 * @see Object#toString
 * @see String#valueOf(Object)
 */

public static java.lang.String toString(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns the result of calling {@code toString} on the first
 * argument if the first argument is not {@code null} and returns
 * the second argument otherwise.
 *
 * @param o an object
 * @param nullDefault string to return if the first argument is
 *        {@code null}
 * @return the result of calling {@code toString} on the first
 * argument if it is not {@code null} and the second argument
 * otherwise.
 * @see Objects#toString(Object)
 */

public static java.lang.String toString(java.lang.Object o, java.lang.String nullDefault) { throw new RuntimeException("Stub!"); }

/**
 * Returns 0 if the arguments are identical and {@code
 * c.compare(a, b)} otherwise.
 * Consequently, if both arguments are {@code null} 0
 * is returned.
 *
 * <p>Note that if one of the arguments is {@code null}, a {@code
 * NullPointerException} may or may not be thrown depending on
 * what ordering policy, if any, the {@link Comparator Comparator}
 * chooses to have for {@code null} values.
 *
 * @param <T> the type of the objects being compared
 * @param a an object
 * @param b an object to be compared with {@code a}
 * @param c the {@code Comparator} to compare the first two arguments
 * @return 0 if the arguments are identical and {@code
 * c.compare(a, b)} otherwise.
 * @see Comparable
 * @see Comparator
 */

public static <T> int compare(T a, T b, java.util.Comparator<? super T> c) { throw new RuntimeException("Stub!"); }

/**
 * Checks that the specified object reference is not {@code null}. This
 * method is designed primarily for doing parameter validation in methods
 * and constructors, as demonstrated below:
 * <blockquote><pre>
 * public Foo(Bar bar) {
 *     this.bar = Objects.requireNonNull(bar);
 * }
 * </pre></blockquote>
 *
 * @param obj the object reference to check for nullity
 * @param <T> the type of the reference
 * @return {@code obj} if not {@code null}
 * @throws NullPointerException if {@code obj} is {@code null}
 */

public static <T> T requireNonNull(T obj) { throw new RuntimeException("Stub!"); }

/**
 * Checks that the specified object reference is not {@code null} and
 * throws a customized {@link NullPointerException} if it is. This method
 * is designed primarily for doing parameter validation in methods and
 * constructors with multiple parameters, as demonstrated below:
 * <blockquote><pre>
 * public Foo(Bar bar, Baz baz) {
 *     this.bar = Objects.requireNonNull(bar, "bar must not be null");
 *     this.baz = Objects.requireNonNull(baz, "baz must not be null");
 * }
 * </pre></blockquote>
 *
 * @param obj     the object reference to check for nullity
 * @param message detail message to be used in the event that a {@code
 *                NullPointerException} is thrown
 * @param <T> the type of the reference
 * @return {@code obj} if not {@code null}
 * @throws NullPointerException if {@code obj} is {@code null}
 */

public static <T> T requireNonNull(T obj, java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the provided reference is {@code null} otherwise
 * returns {@code false}.
 *
 * @apiNote This method exists to be used as a
 * {@link java.util.function.Predicate}, {@code filter(Objects::isNull)}
 *
 * @param obj a reference to be checked against {@code null}
 * @return {@code true} if the provided reference is {@code null} otherwise
 * {@code false}
 *
 * @see java.util.function.Predicate
 * @since 1.8
 */

public static boolean isNull(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the provided reference is non-{@code null}
 * otherwise returns {@code false}.
 *
 * @apiNote This method exists to be used as a
 * {@link java.util.function.Predicate}, {@code filter(Objects::nonNull)}
 *
 * @param obj a reference to be checked against {@code null}
 * @return {@code true} if the provided reference is non-{@code null}
 * otherwise {@code false}
 *
 * @see java.util.function.Predicate
 * @since 1.8
 */

public static boolean nonNull(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Checks that the specified object reference is not {@code null} and
 * throws a customized {@link NullPointerException} if it is.
 *
 * <p>Unlike the method {@link #requireNonNull(Object, String)},
 * this method allows creation of the message to be deferred until
 * after the null check is made. While this may confer a
 * performance advantage in the non-null case, when deciding to
 * call this method care should be taken that the costs of
 * creating the message supplier are less than the cost of just
 * creating the string message directly.
 *
 * @param obj     the object reference to check for nullity
 * @param messageSupplier supplier of the detail message to be
 * used in the event that a {@code NullPointerException} is thrown
 * @param <T> the type of the reference
 * @return {@code obj} if not {@code null}
 * @throws NullPointerException if {@code obj} is {@code null}
 * @since 1.8
 */

public static <T> T requireNonNull(T obj, java.util.function.Supplier<java.lang.String> messageSupplier) { throw new RuntimeException("Stub!"); }
}

