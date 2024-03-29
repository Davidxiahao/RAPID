/*
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

/*
 * (C) Copyright Taligent, Inc. 1996, 1997 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996 - 1998 - All Rights Reserved
 *
 *   The original version of this source code and documentation is copyrighted
 * and owned by Taligent, Inc., a wholly-owned subsidiary of IBM. These
 * materials are provided under terms of a License Agreement between Taligent
 * and Sun. This technology is protected by multiple US and International
 * patents. This notice and attribution to Taligent may not be removed.
 *   Taligent is a registered trademark of Taligent, Inc.
 *
 */


package java.text;

import java.io.InvalidObjectException;

/**
 * A <code>ChoiceFormat</code> allows you to attach a format to a range of numbers.
 * It is generally used in a <code>MessageFormat</code> for handling plurals.
 * The choice is specified with an ascending list of doubles, where each item
 * specifies a half-open interval up to the next item:
 * <blockquote>
 * <pre>
 * X matches j if and only if limit[j] &le; X &lt; limit[j+1]
 * </pre>
 * </blockquote>
 * If there is no match, then either the first or last index is used, depending
 * on whether the number (X) is too low or too high.  If the limit array is not
 * in ascending order, the results of formatting will be incorrect.  ChoiceFormat
 * also accepts <code>&#92;u221E</code> as equivalent to infinity(INF).
 *
 * <p>
 * <strong>Note:</strong>
 * <code>ChoiceFormat</code> differs from the other <code>Format</code>
 * classes in that you create a <code>ChoiceFormat</code> object with a
 * constructor (not with a <code>getInstance</code> style factory
 * method). The factory methods aren't necessary because <code>ChoiceFormat</code>
 * doesn't require any complex setup for a given locale. In fact,
 * <code>ChoiceFormat</code> doesn't implement any locale specific behavior.
 *
 * <p>
 * When creating a <code>ChoiceFormat</code>, you must specify an array of formats
 * and an array of limits. The length of these arrays must be the same.
 * For example,
 * <ul>
 * <li>
 *     <em>limits</em> = {1,2,3,4,5,6,7}<br>
 *     <em>formats</em> = {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"}
 * <li>
 *     <em>limits</em> = {0, 1, ChoiceFormat.nextDouble(1)}<br>
 *     <em>formats</em> = {"no files", "one file", "many files"}<br>
 *     (<code>nextDouble</code> can be used to get the next higher double, to
 *     make the half-open interval.)
 * </ul>
 *
 * <p>
 * Here is a simple example that shows formatting and parsing:
 * <blockquote>
 * <pre>{@code
 * double[] limits = {1,2,3,4,5,6,7};
 * String[] dayOfWeekNames = {"Sun","Mon","Tue","Wed","Thur","Fri","Sat"};
 * ChoiceFormat form = new ChoiceFormat(limits, dayOfWeekNames);
 * ParsePosition status = new ParsePosition(0);
 * for (double i = 0.0; i <= 8.0; ++i) {
 *     status.setIndex(0);
 *     System.out.println(i + " -> " + form.format(i) + " -> "
 *                              + form.parse(form.format(i),status));
 * }
 * }</pre>
 * </blockquote>
 * Here is a more complex example, with a pattern format:
 * <blockquote>
 * <pre>{@code
 * double[] filelimits = {0,1,2};
 * String[] filepart = {"are no files","is one file","are {2} files"};
 * ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
 * Format[] testFormats = {fileform, null, NumberFormat.getInstance()};
 * MessageFormat pattform = new MessageFormat("There {0} on {1}");
 * pattform.setFormats(testFormats);
 * Object[] testArgs = {null, "ADisk", null};
 * for (int i = 0; i < 4; ++i) {
 *     testArgs[0] = new Integer(i);
 *     testArgs[2] = testArgs[0];
 *     System.out.println(pattform.format(testArgs));
 * }
 * }</pre>
 * </blockquote>
 * <p>
 * Specifying a pattern for ChoiceFormat objects is fairly straightforward.
 * For example:
 * <blockquote>
 * <pre>{@code
 * ChoiceFormat fmt = new ChoiceFormat(
 *      "-1#is negative| 0#is zero or fraction | 1#is one |1.0<is 1+ |2#is two |2<is more than 2.");
 * System.out.println("Formatter Pattern : " + fmt.toPattern());
 *
 * System.out.println("Format with -INF : " + fmt.format(Double.NEGATIVE_INFINITY));
 * System.out.println("Format with -1.0 : " + fmt.format(-1.0));
 * System.out.println("Format with 0 : " + fmt.format(0));
 * System.out.println("Format with 0.9 : " + fmt.format(0.9));
 * System.out.println("Format with 1.0 : " + fmt.format(1));
 * System.out.println("Format with 1.5 : " + fmt.format(1.5));
 * System.out.println("Format with 2 : " + fmt.format(2));
 * System.out.println("Format with 2.1 : " + fmt.format(2.1));
 * System.out.println("Format with NaN : " + fmt.format(Double.NaN));
 * System.out.println("Format with +INF : " + fmt.format(Double.POSITIVE_INFINITY));
 * }</pre>
 * </blockquote>
 * And the output result would be like the following:
 * <blockquote>
 * <pre>{@code
 * Format with -INF : is negative
 * Format with -1.0 : is negative
 * Format with 0 : is zero or fraction
 * Format with 0.9 : is zero or fraction
 * Format with 1.0 : is one
 * Format with 1.5 : is 1+
 * Format with 2 : is two
 * Format with 2.1 : is more than 2.
 * Format with NaN : is negative
 * Format with +INF : is more than 2.
 * }</pre>
 * </blockquote>
 *
 * <h3><a name="synchronization">Synchronization</a></h3>
 *
 * <p>
 * Choice formats are not synchronized.
 * It is recommended to create separate format instances for each thread.
 * If multiple threads access a format concurrently, it must be synchronized
 * externally.
 *
 *
 * @see          DecimalFormat
 * @see          MessageFormat
 * @author       Mark Davis
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ChoiceFormat extends java.text.NumberFormat {

/**
 * Constructs with limits and corresponding formats based on the pattern.
 *
 * @param newPattern the new pattern string
 * @see #applyPattern
 */

public ChoiceFormat(java.lang.String newPattern) { throw new RuntimeException("Stub!"); }

/**
 * Constructs with the limits and the corresponding formats.
 *
 * @param limits limits in ascending order
 * @param formats corresponding format strings
 * @see #setChoices
 */

public ChoiceFormat(double[] limits, java.lang.String[] formats) { throw new RuntimeException("Stub!"); }

/**
 * Sets the pattern.
 * @param newPattern See the class description.
 */

public void applyPattern(java.lang.String newPattern) { throw new RuntimeException("Stub!"); }

/**
 * Gets the pattern.
 *
 * @return the pattern string
 */

public java.lang.String toPattern() { throw new RuntimeException("Stub!"); }

/**
 * Set the choices to be used in formatting.
 * @param limits contains the top value that you want
 * parsed with that format, and should be in ascending sorted order. When
 * formatting X, the choice will be the i, where
 * limit[i] &le; X {@literal <} limit[i+1].
 * If the limit array is not in ascending order, the results of formatting
 * will be incorrect.
 * @param formats are the formats you want to use for each limit.
 * They can be either Format objects or Strings.
 * When formatting with object Y,
 * if the object is a NumberFormat, then ((NumberFormat) Y).format(X)
 * is called. Otherwise Y.toString() is called.
 */

public void setChoices(double[] limits, java.lang.String[] formats) { throw new RuntimeException("Stub!"); }

/**
 * @return a copy of the {@code double[]} array supplied to the constructor or the most recent
 * call to {@link #setChoices(double[], String[])}.
 */

public double[] getLimits() { throw new RuntimeException("Stub!"); }

/**
 * @return a copy of the {@code String[]} array supplied to the constructor or the most recent
 * call to {@link #setChoices(double[], String[])}.
 */

public java.lang.Object[] getFormats() { throw new RuntimeException("Stub!"); }

/**
 * Specialization of format. This method really calls
 * <code>format(double, StringBuffer, FieldPosition)</code>
 * thus the range of longs that are supported is only equal to
 * the range that can be stored by double. This will never be
 * a practical limitation.
 */

public java.lang.StringBuffer format(long number, java.lang.StringBuffer toAppendTo, java.text.FieldPosition status) { throw new RuntimeException("Stub!"); }

/**
 * Returns pattern with formatted double.
 * @param number number to be formatted and substituted.
 * @param toAppendTo where text is appended.
 * @param status ignore no useful status is returned.
 */

public java.lang.StringBuffer format(double number, java.lang.StringBuffer toAppendTo, java.text.FieldPosition status) { throw new RuntimeException("Stub!"); }

/**
 * Parses a Number from the input text.
 * @param text the source text.
 * @param status an input-output parameter.  On input, the
 * status.index field indicates the first character of the
 * source text that should be parsed.  On exit, if no error
 * occurred, status.index is set to the first unparsed character
 * in the source text.  On exit, if an error did occur,
 * status.index is unchanged and status.errorIndex is set to the
 * first index of the character that caused the parse to fail.
 * @return A Number representing the value of the number parsed.
 */

public java.lang.Number parse(java.lang.String text, java.text.ParsePosition status) { throw new RuntimeException("Stub!"); }

/**
 * Finds the least double greater than {@code d}.
 * If {@code NaN}, returns same value.
 * <p>Used to make half-open intervals.
 *
 * @param d the reference value
 * @return the least double value greather than {@code d}
 * @see #previousDouble
 */

public static final double nextDouble(double d) { throw new RuntimeException("Stub!"); }

/**
 * Finds the greatest double less than {@code d}.
 * If {@code NaN}, returns same value.
 *
 * @param d the reference value
 * @return the greatest double value less than {@code d}
 * @see #nextDouble
 */

public static final double previousDouble(double d) { throw new RuntimeException("Stub!"); }

/**
 * Overrides Cloneable
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Generates a hash code for the message format object.
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Equality comparision between two
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Finds the least double greater than {@code d} (if {@code positive} is
 * {@code true}), or the greatest double less than {@code d} (if
 * {@code positive} is {@code false}).
 * If {@code NaN}, returns same value.
 *
 * Does not affect floating-point flags,
 * provided these member functions do not:
 *          Double.longBitsToDouble(long)
 *          Double.doubleToLongBits(double)
 *          Double.isNaN(double)
 *
 * @param d        the reference value
 * @param positive {@code true} if the least double is desired;
 *                 {@code false} otherwise
 * @return the least or greater double value
 */

public static double nextDouble(double d, boolean positive) { throw new RuntimeException("Stub!"); }
}

