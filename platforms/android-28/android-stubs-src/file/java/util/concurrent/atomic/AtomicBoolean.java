/*
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

/*
 * This file is available under and governed by the GNU General Public
 * License version 2 only, as published by the Free Software Foundation.
 * However, the following notice accompanied the original version of this
 * file:
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */


package java.util.concurrent.atomic;


/**
 * A {@code boolean} value that may be updated atomically. See the
 * {@link java.util.concurrent.atomic} package specification for
 * description of the properties of atomic variables. An
 * {@code AtomicBoolean} is used in applications such as atomically
 * updated flags, and cannot be used as a replacement for a
 * {@link java.lang.Boolean}.
 *
 * @since 1.5
 * @author Doug Lea
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AtomicBoolean implements java.io.Serializable {

/**
 * Creates a new {@code AtomicBoolean} with the given initial value.
 *
 * @param initialValue the initial value
 */

public AtomicBoolean(boolean initialValue) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code AtomicBoolean} with initial value {@code false}.
 */

public AtomicBoolean() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current value.
 *
 * @return the current value
 */

public final boolean get() { throw new RuntimeException("Stub!"); }

/**
 * Atomically sets the value to the given updated value
 * if the current value {@code ==} the expected value.
 *
 * @param expect the expected value
 * @param update the new value
 * @return {@code true} if successful. False return indicates that
 * the actual value was not equal to the expected value.
 */

public final boolean compareAndSet(boolean expect, boolean update) { throw new RuntimeException("Stub!"); }

/**
 * Atomically sets the value to the given updated value
 * if the current value {@code ==} the expected value.
 *
 * <p><a href="package-summary.html#weakCompareAndSet">May fail
 * spuriously and does not provide ordering guarantees</a>, so is
 * only rarely an appropriate alternative to {@code compareAndSet}.
 *
 * @param expect the expected value
 * @param update the new value
 * @return {@code true} if successful
 */

public boolean weakCompareAndSet(boolean expect, boolean update) { throw new RuntimeException("Stub!"); }

/**
 * Unconditionally sets to the given value.
 *
 * @param newValue the new value
 */

public final void set(boolean newValue) { throw new RuntimeException("Stub!"); }

/**
 * Eventually sets to the given value.
 *
 * @param newValue the new value
 * @since 1.6
 */

public final void lazySet(boolean newValue) { throw new RuntimeException("Stub!"); }

/**
 * Atomically sets to the given value and returns the previous value.
 *
 * @param newValue the new value
 * @return the previous value
 */

public final boolean getAndSet(boolean newValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the String representation of the current value.
 * @return the String representation of the current value
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

