/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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


/**
 * {@code StringJoiner} is used to construct a sequence of characters separated
 * by a delimiter and optionally starting with a supplied prefix
 * and ending with a supplied suffix.
 * <p>
 * Prior to adding something to the {@code StringJoiner}, its
 * {@code sj.toString()} method will, by default, return {@code prefix + suffix}.
 * However, if the {@code setEmptyValue} method is called, the {@code emptyValue}
 * supplied will be returned instead. This can be used, for example, when
 * creating a string using set notation to indicate an empty set, i.e.
 * <code>"{}"</code>, where the {@code prefix} is <code>"{"</code>, the
 * {@code suffix} is <code>"}"</code> and nothing has been added to the
 * {@code StringJoiner}.
 *
 * @apiNote
 * <p>The String {@code "[George:Sally:Fred]"} may be constructed as follows:
 *
 * <pre> {@code
 * StringJoiner sj = new StringJoiner(":", "[", "]");
 * sj.add("George").add("Sally").add("Fred");
 * String desiredString = sj.toString();
 * }</pre>
 * <p>
 * A {@code StringJoiner} may be employed to create formatted output from a
 * {@link java.util.stream.Stream} using
 * {@link java.util.stream.Collectors#joining(CharSequence)}. For example:
 *
 * <pre> {@code
 * List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
 * String commaSeparatedNumbers = numbers.stream()
 *     .map(i -> i.toString())
 *     .collect(Collectors.joining(", "));
 * }</pre>
 *
 * @see java.util.stream.Collectors#joining(CharSequence)
 * @see java.util.stream.Collectors#joining(CharSequence, CharSequence, CharSequence)
 * @since  1.8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StringJoiner {

/**
 * Constructs a {@code StringJoiner} with no characters in it, with no
 * {@code prefix} or {@code suffix}, and a copy of the supplied
 * {@code delimiter}.
 * If no characters are added to the {@code StringJoiner} and methods
 * accessing the value of it are invoked, it will not return a
 * {@code prefix} or {@code suffix} (or properties thereof) in the result,
 * unless {@code setEmptyValue} has first been called.
 *
 * @param  delimiter the sequence of characters to be used between each
 *         element added to the {@code StringJoiner} value
 * @throws NullPointerException if {@code delimiter} is {@code null}
 */

public StringJoiner(java.lang.CharSequence delimiter) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@code StringJoiner} with no characters in it using copies
 * of the supplied {@code prefix}, {@code delimiter} and {@code suffix}.
 * If no characters are added to the {@code StringJoiner} and methods
 * accessing the string value of it are invoked, it will return the
 * {@code prefix + suffix} (or properties thereof) in the result, unless
 * {@code setEmptyValue} has first been called.
 *
 * @param  delimiter the sequence of characters to be used between each
 *         element added to the {@code StringJoiner}
 * @param  prefix the sequence of characters to be used at the beginning
 * @param  suffix the sequence of characters to be used at the end
 * @throws NullPointerException if {@code prefix}, {@code delimiter}, or
 *         {@code suffix} is {@code null}
 */

public StringJoiner(java.lang.CharSequence delimiter, java.lang.CharSequence prefix, java.lang.CharSequence suffix) { throw new RuntimeException("Stub!"); }

/**
 * Sets the sequence of characters to be used when determining the string
 * representation of this {@code StringJoiner} and no elements have been
 * added yet, that is, when it is empty.  A copy of the {@code emptyValue}
 * parameter is made for this purpose. Note that once an add method has been
 * called, the {@code StringJoiner} is no longer considered empty, even if
 * the element(s) added correspond to the empty {@code String}.
 *
 * @param  emptyValue the characters to return as the value of an empty
 *         {@code StringJoiner}
 * @return this {@code StringJoiner} itself so the calls may be chained
 * @throws NullPointerException when the {@code emptyValue} parameter is
 *         {@code null}
 */

public java.util.StringJoiner setEmptyValue(java.lang.CharSequence emptyValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current value, consisting of the {@code prefix}, the values
 * added so far separated by the {@code delimiter}, and the {@code suffix},
 * unless no elements have been added in which case, the
 * {@code prefix + suffix} or the {@code emptyValue} characters are returned
 *
 * @return the string representation of this {@code StringJoiner}
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Adds a copy of the given {@code CharSequence} value as the next
 * element of the {@code StringJoiner} value. If {@code newElement} is
 * {@code null}, then {@code "null"} is added.
 *
 * @param  newElement The element to add
 * @return a reference to this {@code StringJoiner}
 */

public java.util.StringJoiner add(java.lang.CharSequence newElement) { throw new RuntimeException("Stub!"); }

/**
 * Adds the contents of the given {@code StringJoiner} without prefix and
 * suffix as the next element if it is non-empty. If the given {@code
 * StringJoiner} is empty, the call has no effect.
 *
 * <p>A {@code StringJoiner} is empty if {@link #add(CharSequence) add()}
 * has never been called, and if {@code merge()} has never been called
 * with a non-empty {@code StringJoiner} argument.
 *
 * <p>If the other {@code StringJoiner} is using a different delimiter,
 * then elements from the other {@code StringJoiner} are concatenated with
 * that delimiter and the result is appended to this {@code StringJoiner}
 * as a single element.
 *
 * @param other The {@code StringJoiner} whose contents should be merged
 *              into this one
 * @throws NullPointerException if the other {@code StringJoiner} is null
 * @return This {@code StringJoiner}
 */

public java.util.StringJoiner merge(java.util.StringJoiner other) { throw new RuntimeException("Stub!"); }

/**
 * Returns the length of the {@code String} representation
 * of this {@code StringJoiner}. Note that if
 * no add methods have been called, then the length of the {@code String}
 * representation (either {@code prefix + suffix} or {@code emptyValue})
 * will be returned. The value should be equivalent to
 * {@code toString().length()}.
 *
 * @return the length of the current value of {@code StringJoiner}
 */

public int length() { throw new RuntimeException("Stub!"); }
}

