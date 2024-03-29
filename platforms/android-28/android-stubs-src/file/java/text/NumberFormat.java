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

import java.util.Locale;
import java.util.Currency;
import java.math.RoundingMode;
import java.math.BigInteger;
import java.io.InvalidObjectException;

/**
 * <code>NumberFormat</code> is the abstract base class for all number
 * formats. This class provides the interface for formatting and parsing
 * numbers. <code>NumberFormat</code> also provides methods for determining
 * which locales have number formats, and what their names are.
 *
 * <p>
 * <code>NumberFormat</code> helps you to format and parse numbers for any locale.
 * Your code can be completely independent of the locale conventions for
 * decimal points, thousands-separators, or even the particular decimal
 * digits used, or whether the number format is even decimal.
 *
 * <p>
 * To format a number for the current Locale, use one of the factory
 * class methods:
 * <blockquote>
 * <pre>{@code
 * myString = NumberFormat.getInstance().format(myNumber);
 * }</pre>
 * </blockquote>
 * If you are formatting multiple numbers, it is
 * more efficient to get the format and use it multiple times so that
 * the system doesn't have to fetch the information about the local
 * language and country conventions multiple times.
 * <blockquote>
 * <pre>{@code
 * NumberFormat nf = NumberFormat.getInstance();
 * for (int i = 0; i < myNumber.length; ++i) {
 *     output.println(nf.format(myNumber[i]) + "; ");
 * }
 * }</pre>
 * </blockquote>
 * To format a number for a different Locale, specify it in the
 * call to <code>getInstance</code>.
 * <blockquote>
 * <pre>{@code
 * NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
 * }</pre>
 * </blockquote>
 * You can also use a <code>NumberFormat</code> to parse numbers:
 * <blockquote>
 * <pre>{@code
 * myNumber = nf.parse(myString);
 * }</pre>
 * </blockquote>
 * Use <code>getInstance</code> or <code>getNumberInstance</code> to get the
 * normal number format. Use <code>getIntegerInstance</code> to get an
 * integer number format. Use <code>getCurrencyInstance</code> to get the
 * currency number format. And use <code>getPercentInstance</code> to get a
 * format for displaying percentages. With this format, a fraction like
 * 0.53 is displayed as 53%.
 *
 * <p>
 * You can also control the display of numbers with such methods as
 * <code>setMinimumFractionDigits</code>.
 * If you want even more control over the format or parsing,
 * or want to give your users more control,
 * you can try casting the <code>NumberFormat</code> you get from the factory methods
 * to a <code>DecimalFormat</code>. This will work for the vast majority
 * of locales; just remember to put it in a <code>try</code> block in case you
 * encounter an unusual one.
 *
 * <p>
 * NumberFormat and DecimalFormat are designed such that some controls
 * work for formatting and others work for parsing.  The following is
 * the detailed description for each these control methods,
 * <p>
 * setParseIntegerOnly : only affects parsing, e.g.
 * if true,  "3456.78" &rarr; 3456 (and leaves the parse position just after index 6)
 * if false, "3456.78" &rarr; 3456.78 (and leaves the parse position just after index 8)
 * This is independent of formatting.  If you want to not show a decimal point
 * where there might be no digits after the decimal point, use
 * setDecimalSeparatorAlwaysShown.
 * <p>
 * setDecimalSeparatorAlwaysShown : only affects formatting, and only where
 * there might be no digits after the decimal point, such as with a pattern
 * like "#,##0.##", e.g.,
 * if true,  3456.00 &rarr; "3,456."
 * if false, 3456.00 &rarr; "3456"
 * This is independent of parsing.  If you want parsing to stop at the decimal
 * point, use setParseIntegerOnly.
 *
 * <p>
 * You can also use forms of the <code>parse</code> and <code>format</code>
 * methods with <code>ParsePosition</code> and <code>FieldPosition</code> to
 * allow you to:
 * <ul>
 * <li> progressively parse through pieces of a string
 * <li> align the decimal point and other areas
 * </ul>
 * For example, you can align numbers in two ways:
 * <ol>
 * <li> If you are using a monospaced font with spacing for alignment,
 *      you can pass the <code>FieldPosition</code> in your format call, with
 *      <code>field</code> = <code>INTEGER_FIELD</code>. On output,
 *      <code>getEndIndex</code> will be set to the offset between the
 *      last character of the integer and the decimal. Add
 *      (desiredSpaceCount - getEndIndex) spaces at the front of the string.
 *
 * <li> If you are using proportional fonts,
 *      instead of padding with spaces, measure the width
 *      of the string in pixels from the start to <code>getEndIndex</code>.
 *      Then move the pen by
 *      (desiredPixelWidth - widthToAlignmentPoint) before drawing the text.
 *      It also works where there is no decimal, but possibly additional
 *      characters at the end, e.g., with parentheses in negative
 *      numbers: "(12)" for -12.
 * </ol>
 *
 * <h3><a name="synchronization">Synchronization</a></h3>
 *
 * <p>
 * Number formats are generally not synchronized.
 * It is recommended to create separate format instances for each thread.
 * If multiple threads access a format concurrently, it must be synchronized
 * externally.
 *
 * @see          DecimalFormat
 * @see          ChoiceFormat
 * @author       Mark Davis
 * @author       Helena Shih
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class NumberFormat extends java.text.Format {

/**
 * Sole constructor.  (For invocation by subclass constructors, typically
 * implicit.)
 */

protected NumberFormat() { throw new RuntimeException("Stub!"); }

/**
 * Formats a number and appends the resulting text to the given string
 * buffer.
 * The number can be of any subclass of {@link java.lang.Number}.
 * <p>
 * This implementation extracts the number's value using
 * {@link java.lang.Number#longValue()} for all integral type values that
 * can be converted to <code>long</code> without loss of information,
 * including <code>BigInteger</code> values with a
 * {@link java.math.BigInteger#bitLength() bit length} of less than 64,
 * and {@link java.lang.Number#doubleValue()} for all other types. It
 * then calls
 * {@link #format(long,java.lang.StringBuffer,java.text.FieldPosition)}
 * or {@link #format(double,java.lang.StringBuffer,java.text.FieldPosition)}.
 * This may result in loss of magnitude information and precision for
 * <code>BigInteger</code> and <code>BigDecimal</code> values.
 * @param number     the number to format
 * @param toAppendTo the <code>StringBuffer</code> to which the formatted
 *                   text is to be appended
 * @param pos        On input: an alignment field, if desired.
 *                   On output: the offsets of the alignment field.
 * @return           the value passed in as <code>toAppendTo</code>
 * @exception        IllegalArgumentException if <code>number</code> is
 *                   null or not an instance of <code>Number</code>.
 * @exception        NullPointerException if <code>toAppendTo</code> or
 *                   <code>pos</code> is null
 * @exception        ArithmeticException if rounding is needed with rounding
 *                   mode being set to RoundingMode.UNNECESSARY
 * @see              java.text.FieldPosition
 */

public java.lang.StringBuffer format(java.lang.Object number, java.lang.StringBuffer toAppendTo, java.text.FieldPosition pos) { throw new RuntimeException("Stub!"); }

/**
 * Parses text from a string to produce a <code>Number</code>.
 * <p>
 * The method attempts to parse text starting at the index given by
 * <code>pos</code>.
 * If parsing succeeds, then the index of <code>pos</code> is updated
 * to the index after the last character used (parsing does not necessarily
 * use all characters up to the end of the string), and the parsed
 * number is returned. The updated <code>pos</code> can be used to
 * indicate the starting point for the next call to this method.
 * If an error occurs, then the index of <code>pos</code> is not
 * changed, the error index of <code>pos</code> is set to the index of
 * the character where the error occurred, and null is returned.
 * <p>
 * See the {@link #parse(String, ParsePosition)} method for more information
 * on number parsing.
 *
 * @param source A <code>String</code>, part of which should be parsed.
 * @param pos A <code>ParsePosition</code> object with index and error
 *            index information as described above.
 * @return A <code>Number</code> parsed from the string. In case of
 *         error, returns null.
 * @exception NullPointerException if <code>pos</code> is null.
 */

public final java.lang.Object parseObject(java.lang.String source, java.text.ParsePosition pos) { throw new RuntimeException("Stub!"); }

/**
 * Specialization of format.
 *
 * @param number the double number to format
 * @return the formatted String
 * @exception        ArithmeticException if rounding is needed with rounding
 *                   mode being set to RoundingMode.UNNECESSARY
 * @see java.text.Format#format
 */

public final java.lang.String format(double number) { throw new RuntimeException("Stub!"); }

/**
 * Specialization of format.
 *
 * @param number the long number to format
 * @return the formatted String
 * @exception        ArithmeticException if rounding is needed with rounding
 *                   mode being set to RoundingMode.UNNECESSARY
 * @see java.text.Format#format
 */

public final java.lang.String format(long number) { throw new RuntimeException("Stub!"); }

/**
 * Specialization of format.
 *
 * @param number     the double number to format
 * @param toAppendTo the StringBuffer to which the formatted text is to be
 *                   appended
 * @param pos        the field position
 * @return the formatted StringBuffer
 * @exception        ArithmeticException if rounding is needed with rounding
 *                   mode being set to RoundingMode.UNNECESSARY
 * @see java.text.Format#format
 */

public abstract java.lang.StringBuffer format(double number, java.lang.StringBuffer toAppendTo, java.text.FieldPosition pos);

/**
 * Specialization of format.
 *
 * @param number     the long number to format
 * @param toAppendTo the StringBuffer to which the formatted text is to be
 *                   appended
 * @param pos        the field position
 * @return the formatted StringBuffer
 * @exception        ArithmeticException if rounding is needed with rounding
 *                   mode being set to RoundingMode.UNNECESSARY
 * @see java.text.Format#format
 */

public abstract java.lang.StringBuffer format(long number, java.lang.StringBuffer toAppendTo, java.text.FieldPosition pos);

/**
 * Returns a Long if possible (e.g., within the range [Long.MIN_VALUE,
 * Long.MAX_VALUE] and with no decimals), otherwise a Double.
 * If IntegerOnly is set, will stop at a decimal
 * point (or equivalent; e.g., for rational numbers "1 2/3", will stop
 * after the 1).
 * Does not throw an exception; if no object can be parsed, index is
 * unchanged!
 *
 * @param source the String to parse
 * @param parsePosition the parse position
 * @return the parsed value
 * @see java.text.NumberFormat#isParseIntegerOnly
 * @see java.text.Format#parseObject
 */

public abstract java.lang.Number parse(java.lang.String source, java.text.ParsePosition parsePosition);

/**
 * Parses text from the beginning of the given string to produce a number.
 * The method may not use the entire text of the given string.
 * <p>
 * See the {@link #parse(String, ParsePosition)} method for more information
 * on number parsing.
 *
 * @param source A <code>String</code> whose beginning should be parsed.
 * @return A <code>Number</code> parsed from the string.
 * @exception ParseException if the beginning of the specified string
 *            cannot be parsed.
 */

public java.lang.Number parse(java.lang.String source) throws java.text.ParseException { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this format will parse numbers as integers only.
 * For example in the English locale, with ParseIntegerOnly true, the
 * string "1234." would be parsed as the integer value 1234 and parsing
 * would stop at the "." character.  Of course, the exact format accepted
 * by the parse operation is locale dependant and determined by sub-classes
 * of NumberFormat.
 *
 * @return {@code true} if numbers should be parsed as integers only;
 *         {@code false} otherwise
 */

public boolean isParseIntegerOnly() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether or not numbers should be parsed as integers only.
 *
 * @param value {@code true} if numbers should be parsed as integers only;
 *              {@code false} otherwise
 * @see #isParseIntegerOnly
 */

public void setParseIntegerOnly(boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Returns a general-purpose number format for the current default
 * {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * This is the same as calling
 * {@link #getNumberInstance() getNumberInstance()}.
 *
 * @return the {@code NumberFormat} instance for general-purpose number
 * formatting
 */

public static final java.text.NumberFormat getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns a general-purpose number format for the specified locale.
 * This is the same as calling
 * {@link #getNumberInstance(java.util.Locale) getNumberInstance(inLocale)}.
 *
 * @param inLocale the desired locale
 * @return the {@code NumberFormat} instance for general-purpose number
 * formatting
 */

public static java.text.NumberFormat getInstance(java.util.Locale inLocale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a general-purpose number format for the current default
 * {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * <p>This is equivalent to calling
 * {@link #getNumberInstance(Locale)
 *     getNumberInstance(Locale.getDefault(Locale.Category.FORMAT))}.
 *
 * @return the {@code NumberFormat} instance for general-purpose number
 * formatting
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 */

public static final java.text.NumberFormat getNumberInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns a general-purpose number format for the specified locale.
 *
 * @param inLocale the desired locale
 * @return the {@code NumberFormat} instance for general-purpose number
 * formatting
 */

public static java.text.NumberFormat getNumberInstance(java.util.Locale inLocale) { throw new RuntimeException("Stub!"); }

/**
 * Returns an integer number format for the current default
 * {@link java.util.Locale.Category#FORMAT FORMAT} locale. The
 * returned number format is configured to round floating point numbers
 * to the nearest integer using half-even rounding (see {@link
 * java.math.RoundingMode#HALF_EVEN RoundingMode.HALF_EVEN}) for formatting,
 * and to parse only the integer part of an input string (see {@link
 * #isParseIntegerOnly isParseIntegerOnly}).
 * <p>This is equivalent to calling
 * {@link #getIntegerInstance(Locale)
 *     getIntegerInstance(Locale.getDefault(Locale.Category.FORMAT))}.
 *
 * @see #getRoundingMode()
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 * @return a number format for integer values
 * @since 1.4
 */

public static final java.text.NumberFormat getIntegerInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns an integer number format for the specified locale. The
 * returned number format is configured to round floating point numbers
 * to the nearest integer using half-even rounding (see {@link
 * java.math.RoundingMode#HALF_EVEN RoundingMode.HALF_EVEN}) for formatting,
 * and to parse only the integer part of an input string (see {@link
 * #isParseIntegerOnly isParseIntegerOnly}).
 *
 * @param inLocale the desired locale
 * @see #getRoundingMode()
 * @return a number format for integer values
 * @since 1.4
 */

public static java.text.NumberFormat getIntegerInstance(java.util.Locale inLocale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a currency format for the current default
 * {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * <p>This is equivalent to calling
 * {@link #getCurrencyInstance(Locale)
 *     getCurrencyInstance(Locale.getDefault(Locale.Category.FORMAT))}.
 *
 * @return the {@code NumberFormat} instance for currency formatting
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 */

public static final java.text.NumberFormat getCurrencyInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns a currency format for the specified locale.
 *
 * @param inLocale the desired locale
 * @return the {@code NumberFormat} instance for currency formatting
 */

public static java.text.NumberFormat getCurrencyInstance(java.util.Locale inLocale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a percentage format for the current default
 * {@link java.util.Locale.Category#FORMAT FORMAT} locale.
 * <p>This is equivalent to calling
 * {@link #getPercentInstance(Locale)
 *     getPercentInstance(Locale.getDefault(Locale.Category.FORMAT))}.
 *
 * @return the {@code NumberFormat} instance for percentage formatting
 * @see java.util.Locale#getDefault(java.util.Locale.Category)
 * @see java.util.Locale.Category#FORMAT
 */

public static final java.text.NumberFormat getPercentInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns a percentage format for the specified locale.
 *
 * @param inLocale the desired locale
 * @return the {@code NumberFormat} instance for percentage formatting
 */

public static java.text.NumberFormat getPercentInstance(java.util.Locale inLocale) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of all locales for which the
 * <code>get*Instance</code> methods of this class can return
 * localized instances.
 *
 * @return An array of locales for which localized
 *         <code>NumberFormat</code> instances are available.
 */

public static java.util.Locale[] getAvailableLocales() { throw new RuntimeException("Stub!"); }

/**
 * Overrides hashCode.
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Overrides equals.
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Overrides Cloneable.
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if grouping is used in this format. For example, in the
 * English locale, with grouping on, the number 1234567 might be formatted
 * as "1,234,567". The grouping separator as well as the size of each group
 * is locale dependant and is determined by sub-classes of NumberFormat.
 *
 * @return {@code true} if grouping is used;
 *         {@code false} otherwise
 * @see #setGroupingUsed
 */

public boolean isGroupingUsed() { throw new RuntimeException("Stub!"); }

/**
 * Set whether or not grouping will be used in this format.
 *
 * @param newValue {@code true} if grouping is used;
 *                 {@code false} otherwise
 * @see #isGroupingUsed
 */

public void setGroupingUsed(boolean newValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum number of digits allowed in the integer portion of a
 * number.
 *
 * @return the maximum number of digits
 * @see #setMaximumIntegerDigits
 */

public int getMaximumIntegerDigits() { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximum number of digits allowed in the integer portion of a
 * number. maximumIntegerDigits must be &ge; minimumIntegerDigits.  If the
 * new value for maximumIntegerDigits is less than the current value
 * of minimumIntegerDigits, then minimumIntegerDigits will also be set to
 * the new value.
 *
 * @param newValue the maximum number of integer digits to be shown; if
 * less than zero, then zero is used. The concrete subclass may enforce an
 * upper limit to this value appropriate to the numeric type being formatted.
 * @see #getMaximumIntegerDigits
 */

public void setMaximumIntegerDigits(int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum number of digits allowed in the integer portion of a
 * number.
 *
 * @return the minimum number of digits
 * @see #setMinimumIntegerDigits
 */

public int getMinimumIntegerDigits() { throw new RuntimeException("Stub!"); }

/**
 * Sets the minimum number of digits allowed in the integer portion of a
 * number. minimumIntegerDigits must be &le; maximumIntegerDigits.  If the
 * new value for minimumIntegerDigits exceeds the current value
 * of maximumIntegerDigits, then maximumIntegerDigits will also be set to
 * the new value
 *
 * @param newValue the minimum number of integer digits to be shown; if
 * less than zero, then zero is used. The concrete subclass may enforce an
 * upper limit to this value appropriate to the numeric type being formatted.
 * @see #getMinimumIntegerDigits
 */

public void setMinimumIntegerDigits(int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum number of digits allowed in the fraction portion of a
 * number.
 *
 * @return the maximum number of digits.
 * @see #setMaximumFractionDigits
 */

public int getMaximumFractionDigits() { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximum number of digits allowed in the fraction portion of a
 * number. maximumFractionDigits must be &ge; minimumFractionDigits.  If the
 * new value for maximumFractionDigits is less than the current value
 * of minimumFractionDigits, then minimumFractionDigits will also be set to
 * the new value.
 *
 * @param newValue the maximum number of fraction digits to be shown; if
 * less than zero, then zero is used. The concrete subclass may enforce an
 * upper limit to this value appropriate to the numeric type being formatted.
 * @see #getMaximumFractionDigits
 */

public void setMaximumFractionDigits(int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum number of digits allowed in the fraction portion of a
 * number.
 *
 * @return the minimum number of digits
 * @see #setMinimumFractionDigits
 */

public int getMinimumFractionDigits() { throw new RuntimeException("Stub!"); }

/**
 * Sets the minimum number of digits allowed in the fraction portion of a
 * number. minimumFractionDigits must be &le; maximumFractionDigits.  If the
 * new value for minimumFractionDigits exceeds the current value
 * of maximumFractionDigits, then maximumIntegerDigits will also be set to
 * the new value
 *
 * @param newValue the minimum number of fraction digits to be shown; if
 * less than zero, then zero is used. The concrete subclass may enforce an
 * upper limit to this value appropriate to the numeric type being formatted.
 * @see #getMinimumFractionDigits
 */

public void setMinimumFractionDigits(int newValue) { throw new RuntimeException("Stub!"); }

/**
 * Gets the currency used by this number format when formatting
 * currency values. The initial value is derived in a locale dependent
 * way. The returned value may be null if no valid
 * currency could be determined and no currency has been set using
 * {@link #setCurrency(java.util.Currency) setCurrency}.
 * <p>
 * The default implementation throws
 * <code>UnsupportedOperationException</code>.
 *
 * @return the currency used by this number format, or <code>null</code>
 * @exception UnsupportedOperationException if the number format class
 * doesn't implement currency formatting
 * @since 1.4
 */

public java.util.Currency getCurrency() { throw new RuntimeException("Stub!"); }

/**
 * Sets the currency used by this number format when formatting
 * currency values. This does not update the minimum or maximum
 * number of fraction digits used by the number format.
 * <p>
 * The default implementation throws
 * <code>UnsupportedOperationException</code>.
 *
 * @param currency the new currency to be used by this number format
 * @exception UnsupportedOperationException if the number format class
 * doesn't implement currency formatting
 * @exception NullPointerException if <code>currency</code> is null
 * @since 1.4
 */

public void setCurrency(java.util.Currency currency) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link java.math.RoundingMode} used in this NumberFormat.
 * The default implementation of this method in NumberFormat
 * always throws {@link java.lang.UnsupportedOperationException}.
 * Subclasses which handle different rounding modes should override
 * this method.
 *
 * @exception UnsupportedOperationException The default implementation
 *     always throws this exception
 * @return The <code>RoundingMode</code> used for this NumberFormat.
 * @see #setRoundingMode(RoundingMode)
 * @since 1.6
 */

public java.math.RoundingMode getRoundingMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link java.math.RoundingMode} used in this NumberFormat.
 * The default implementation of this method in NumberFormat always
 * throws {@link java.lang.UnsupportedOperationException}.
 * Subclasses which handle different rounding modes should override
 * this method.
 *
 * @exception UnsupportedOperationException The default implementation
 *     always throws this exception
 * @exception NullPointerException if <code>roundingMode</code> is null
 * @param roundingMode The <code>RoundingMode</code> to be used
 * @see #getRoundingMode()
 * @since 1.6
 */

public void setRoundingMode(java.math.RoundingMode roundingMode) { throw new RuntimeException("Stub!"); }

/**
 * Field constant used to construct a FieldPosition object. Signifies that
 * the position of the fraction part of a formatted number should be returned.
 * @see java.text.FieldPosition
 */

public static final int FRACTION_FIELD = 1; // 0x1

/**
 * Field constant used to construct a FieldPosition object. Signifies that
 * the position of the integer part of a formatted number should be returned.
 * @see java.text.FieldPosition
 */

public static final int INTEGER_FIELD = 0; // 0x0
/**
 * Defines constants that are used as attribute keys in the
 * <code>AttributedCharacterIterator</code> returned
 * from <code>NumberFormat.formatToCharacterIterator</code> and as
 * field identifiers in <code>FieldPosition</code>.
 *
 * @since 1.4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Field extends java.text.Format.Field {

/**
 * Creates a Field instance with the specified
 * name.
 *
 * @param name Name of the attribute
 */

protected Field(java.lang.String name) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Resolves instances being deserialized to the predefined constants.
 *
 * @throws InvalidObjectException if the constant could not be resolved.
 * @return resolved NumberFormat.Field constant
 */

protected java.lang.Object readResolve() throws java.io.InvalidObjectException { throw new RuntimeException("Stub!"); }

/**
 * Constant identifying the currency field.
 */

public static final java.text.NumberFormat.Field CURRENCY;
static { CURRENCY = null; }

/**
 * Constant identifying the decimal separator field.
 */

public static final java.text.NumberFormat.Field DECIMAL_SEPARATOR;
static { DECIMAL_SEPARATOR = null; }

/**
 * Constant identifying the exponent field.
 */

public static final java.text.NumberFormat.Field EXPONENT;
static { EXPONENT = null; }

/**
 * Constant identifying the exponent sign field.
 */

public static final java.text.NumberFormat.Field EXPONENT_SIGN;
static { EXPONENT_SIGN = null; }

/**
 * Constant identifying the exponent symbol field.
 */

public static final java.text.NumberFormat.Field EXPONENT_SYMBOL;
static { EXPONENT_SYMBOL = null; }

/**
 * Constant identifying the fraction field.
 */

public static final java.text.NumberFormat.Field FRACTION;
static { FRACTION = null; }

/**
 * Constant identifying the grouping separator field.
 */

public static final java.text.NumberFormat.Field GROUPING_SEPARATOR;
static { GROUPING_SEPARATOR = null; }

/**
 * Constant identifying the integer field.
 */

public static final java.text.NumberFormat.Field INTEGER;
static { INTEGER = null; }

/**
 * Constant identifying the percent field.
 */

public static final java.text.NumberFormat.Field PERCENT;
static { PERCENT = null; }

/**
 * Constant identifying the permille field.
 */

public static final java.text.NumberFormat.Field PERMILLE;
static { PERMILLE = null; }

/**
 * Constant identifying the sign field.
 */

public static final java.text.NumberFormat.Field SIGN;
static { SIGN = null; }
}

}

