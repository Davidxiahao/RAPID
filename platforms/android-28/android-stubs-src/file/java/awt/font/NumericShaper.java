/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.awt.font;

import java.util.Set;
import java.util.EnumSet;
import java.io.IOException;

/**
 * The <code>NumericShaper</code> class is used to convert Latin-1 (European)
 * digits to other Unicode decimal digits.  Users of this class will
 * primarily be people who wish to present data using
 * national digit shapes, but find it more convenient to represent the
 * data internally using Latin-1 (European) digits.  This does not
 * interpret the deprecated numeric shape selector character (U+206E).
 * <p>
 * Instances of <code>NumericShaper</code> are typically applied
 * as attributes to text with the
 * {@link TextAttribute#NUMERIC_SHAPING NUMERIC_SHAPING} attribute
 * of the <code>TextAttribute</code> class.
 * For example, this code snippet causes a <code>TextLayout</code> to
 * shape European digits to Arabic in an Arabic context:<br>
 * <blockquote><pre>
 * Map map = new HashMap();
 * map.put(TextAttribute.NUMERIC_SHAPING,
 *     NumericShaper.getContextualShaper(NumericShaper.ARABIC));
 * FontRenderContext frc = ...;
 * TextLayout layout = new TextLayout(text, map, frc);
 * layout.draw(g2d, x, y);
 * </pre></blockquote>
 * <br>
 * It is also possible to perform numeric shaping explicitly using instances
 * of <code>NumericShaper</code>, as this code snippet demonstrates:<br>
 * <blockquote><pre>
 * char[] text = ...;
 * // shape all EUROPEAN digits (except zero) to ARABIC digits
 * NumericShaper shaper = NumericShaper.getShaper(NumericShaper.ARABIC);
 * shaper.shape(text, start, count);
 *
 * // shape European digits to ARABIC digits if preceding text is Arabic, or
 * // shape European digits to TAMIL digits if preceding text is Tamil, or
 * // leave European digits alone if there is no preceding text, or
 * // preceding text is neither Arabic nor Tamil
 * NumericShaper shaper =
 *     NumericShaper.getContextualShaper(NumericShaper.ARABIC |
 *                                         NumericShaper.TAMIL,
 *                                       NumericShaper.EUROPEAN);
 * shaper.shape(text, start, count);
 * </pre></blockquote>
 *
 * <p><b>Bit mask- and enum-based Unicode ranges</b></p>
 *
 * <p>This class supports two different programming interfaces to
 * represent Unicode ranges for script-specific digits: bit
 * mask-based ones, such as {@link #ARABIC NumericShaper.ARABIC}, and
 * enum-based ones, such as {@link NumericShaper.Range#ARABIC}.
 * Multiple ranges can be specified by ORing bit mask-based constants,
 * such as:
 * <blockquote><pre>
 * NumericShaper.ARABIC | NumericShaper.TAMIL
 * </pre></blockquote>
 * or creating a {@code Set} with the {@link NumericShaper.Range}
 * constants, such as:
 * <blockquote><pre>
 * EnumSet.of(NumericShaper.Scirpt.ARABIC, NumericShaper.Range.TAMIL)
 * </pre></blockquote>
 * The enum-based ranges are a super set of the bit mask-based ones.
 *
 * <p>If the two interfaces are mixed (including serialization),
 * Unicode range values are mapped to their counterparts where such
 * mapping is possible, such as {@code NumericShaper.Range.ARABIC}
 * from/to {@code NumericShaper.ARABIC}.  If any unmappable range
 * values are specified, such as {@code NumericShaper.Range.BALINESE},
 * those ranges are ignored.
 *
 * <p><b>Decimal Digits Precedence</b></p>
 *
 * <p>A Unicode range may have more than one set of decimal digits. If
 * multiple decimal digits sets are specified for the same Unicode
 * range, one of the sets will take precedence as follows.
 *
 * <table border=1 cellspacing=3 cellpadding=0 summary="NumericShaper constants precedence.">
 *    <tr>
 *       <th class="TableHeadingColor">Unicode Range</th>
 *       <th class="TableHeadingColor"><code>NumericShaper</code> Constants</th>
 *       <th class="TableHeadingColor">Precedence</th>
 *    </tr>
 *    <tr>
 *       <td rowspan="2">Arabic</td>
 *       <td>{@link NumericShaper#ARABIC NumericShaper.ARABIC}<br>
 *           {@link NumericShaper#EASTERN_ARABIC NumericShaper.EASTERN_ARABIC}</td>
 *       <td>{@link NumericShaper#EASTERN_ARABIC NumericShaper.EASTERN_ARABIC}</td>
 *    </tr>
 *    <tr>
 *       <td>{@link NumericShaper.Range#ARABIC}<br>
 *           {@link NumericShaper.Range#EASTERN_ARABIC}</td>
 *       <td>{@link NumericShaper.Range#EASTERN_ARABIC}</td>
 *    </tr>
 *    <tr>
 *       <td>Tai Tham</td>
 *       <td>{@link NumericShaper.Range#TAI_THAM_HORA}<br>
 *           {@link NumericShaper.Range#TAI_THAM_THAM}</td>
 *       <td>{@link NumericShaper.Range#TAI_THAM_THAM}</td>
 *    </tr>
 * </table>
 *
 * @since 1.4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NumericShaper implements java.io.Serializable {

/**
 * Private constructor.
 */

NumericShaper(int key, int mask) { throw new RuntimeException("Stub!"); }

/**
 * Returns a shaper for the provided unicode range.  All
 * Latin-1 (EUROPEAN) digits are converted
 * to the corresponding decimal unicode digits.
 * @param singleRange the specified Unicode range
 * @return a non-contextual numeric shaper
 * @throws IllegalArgumentException if the range is not a single range
 */

public static java.awt.font.NumericShaper getShaper(int singleRange) { throw new RuntimeException("Stub!"); }

/**
 * Returns a shaper for the provided Unicode
 * range. All Latin-1 (EUROPEAN) digits are converted to the
 * corresponding decimal digits of the specified Unicode range.
 *
 * @param singleRange the Unicode range given by a {@link
 *                    NumericShaper.Range} constant.
 * @return a non-contextual {@code NumericShaper}.
 * @throws NullPointerException if {@code singleRange} is {@code null}
 * @since 1.7
 */

public static java.awt.font.NumericShaper getShaper(java.awt.font.NumericShaper.Range singleRange) { throw new RuntimeException("Stub!"); }

/**
 * Returns a contextual shaper for the provided unicode range(s).
 * Latin-1 (EUROPEAN) digits are converted to the decimal digits
 * corresponding to the range of the preceding text, if the
 * range is one of the provided ranges.  Multiple ranges are
 * represented by or-ing the values together, such as,
 * <code>NumericShaper.ARABIC | NumericShaper.THAI</code>.  The
 * shaper assumes EUROPEAN as the starting context, that is, if
 * EUROPEAN digits are encountered before any strong directional
 * text in the string, the context is presumed to be EUROPEAN, and
 * so the digits will not shape.
 * @param ranges the specified Unicode ranges
 * @return a shaper for the specified ranges
 */

public static java.awt.font.NumericShaper getContextualShaper(int ranges) { throw new RuntimeException("Stub!"); }

/**
 * Returns a contextual shaper for the provided Unicode
 * range(s). The Latin-1 (EUROPEAN) digits are converted to the
 * decimal digits corresponding to the range of the preceding
 * text, if the range is one of the provided ranges.
 *
 * <p>The shaper assumes EUROPEAN as the starting context, that
 * is, if EUROPEAN digits are encountered before any strong
 * directional text in the string, the context is presumed to be
 * EUROPEAN, and so the digits will not shape.
 *
 * @param ranges the specified Unicode ranges
 * @return a contextual shaper for the specified ranges
 * @throws NullPointerException if {@code ranges} is {@code null}.
 * @since 1.7
 */

public static java.awt.font.NumericShaper getContextualShaper(java.util.Set<java.awt.font.NumericShaper.Range> ranges) { throw new RuntimeException("Stub!"); }

/**
 * Returns a contextual shaper for the provided unicode range(s).
 * Latin-1 (EUROPEAN) digits will be converted to the decimal digits
 * corresponding to the range of the preceding text, if the
 * range is one of the provided ranges.  Multiple ranges are
 * represented by or-ing the values together, for example,
 * <code>NumericShaper.ARABIC | NumericShaper.THAI</code>.  The
 * shaper uses defaultContext as the starting context.
 * @param ranges the specified Unicode ranges
 * @param defaultContext the starting context, such as
 * <code>NumericShaper.EUROPEAN</code>
 * @return a shaper for the specified Unicode ranges.
 * @throws IllegalArgumentException if the specified
 * <code>defaultContext</code> is not a single valid range.
 */

public static java.awt.font.NumericShaper getContextualShaper(int ranges, int defaultContext) { throw new RuntimeException("Stub!"); }

/**
 * Returns a contextual shaper for the provided Unicode range(s).
 * The Latin-1 (EUROPEAN) digits will be converted to the decimal
 * digits corresponding to the range of the preceding text, if the
 * range is one of the provided ranges. The shaper uses {@code
 * defaultContext} as the starting context.
 *
 * @param ranges the specified Unicode ranges
 * @param defaultContext the starting context, such as
 *                       {@code NumericShaper.Range.EUROPEAN}
 * @return a contextual shaper for the specified Unicode ranges.
 * @throws NullPointerException
 *         if {@code ranges} or {@code defaultContext} is {@code null}
 * @since 1.7
 */

public static java.awt.font.NumericShaper getContextualShaper(java.util.Set<java.awt.font.NumericShaper.Range> ranges, java.awt.font.NumericShaper.Range defaultContext) { throw new RuntimeException("Stub!"); }

/**
 * Converts the digits in the text that occur between start and
 * start + count.
 * @param text an array of characters to convert
 * @param start the index into <code>text</code> to start
 *        converting
 * @param count the number of characters in <code>text</code>
 *        to convert
 * @throws IndexOutOfBoundsException if start or start + count is
 *        out of bounds
 * @throws NullPointerException if text is null
 */

public void shape(char[] text, int start, int count) { throw new RuntimeException("Stub!"); }

/**
 * Converts the digits in the text that occur between start and
 * start + count, using the provided context.
 * Context is ignored if the shaper is not a contextual shaper.
 * @param text an array of characters
 * @param start the index into <code>text</code> to start
 *        converting
 * @param count the number of characters in <code>text</code>
 *        to convert
 * @param context the context to which to convert the
 *        characters, such as <code>NumericShaper.EUROPEAN</code>
 * @throws IndexOutOfBoundsException if start or start + count is
 *        out of bounds
 * @throws NullPointerException if text is null
 * @throws IllegalArgumentException if this is a contextual shaper
 * and the specified <code>context</code> is not a single valid
 * range.
 */

public void shape(char[] text, int start, int count, int context) { throw new RuntimeException("Stub!"); }

/**
 * Converts the digits in the text that occur between {@code
 * start} and {@code start + count}, using the provided {@code
 * context}. {@code Context} is ignored if the shaper is not a
 * contextual shaper.
 *
 * @param text  a {@code char} array
 * @param start the index into {@code text} to start converting
 * @param count the number of {@code char}s in {@code text}
 *              to convert
 * @param context the context to which to convert the characters,
 *                such as {@code NumericShaper.Range.EUROPEAN}
 * @throws IndexOutOfBoundsException
 *         if {@code start} or {@code start + count} is out of bounds
 * @throws NullPointerException
 *         if {@code text} or {@code context} is null
 * @since 1.7
 */

public void shape(char[] text, int start, int count, java.awt.font.NumericShaper.Range context) { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>boolean</code> indicating whether or not
 * this shaper shapes contextually.
 * @return <code>true</code> if this shaper is contextual;
 *         <code>false</code> otherwise.
 */

public boolean isContextual() { throw new RuntimeException("Stub!"); }

/**
 * Returns an <code>int</code> that ORs together the values for
 * all the ranges that will be shaped.
 * <p>
 * For example, to check if a shaper shapes to Arabic, you would use the
 * following:
 * <blockquote>
 *   {@code if ((shaper.getRanges() & shaper.ARABIC) != 0) &#123; ... }
 * </blockquote>
 *
 * <p>Note that this method supports only the bit mask-based
 * ranges. Call {@link #getRangeSet()} for the enum-based ranges.
 *
 * @return the values for all the ranges to be shaped.
 */

public int getRanges() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Set} representing all the Unicode ranges in
 * this {@code NumericShaper} that will be shaped.
 *
 * @return all the Unicode ranges to be shaped.
 * @since 1.7
 */

public java.util.Set<java.awt.font.NumericShaper.Range> getRangeSet() { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code for this shaper.
 * @return this shaper's hash code.
 * @see java.lang.Object#hashCode
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the specified object is an instance of
 * <code>NumericShaper</code> and shapes identically to this one,
 * regardless of the range representations, the bit mask or the
 * enum. For example, the following code produces {@code "true"}.
 * <blockquote><pre>
 * NumericShaper ns1 = NumericShaper.getShaper(NumericShaper.ARABIC);
 * NumericShaper ns2 = NumericShaper.getShaper(NumericShaper.Range.ARABIC);
 * System.out.println(ns1.equals(ns2));
 * </pre></blockquote>
 *
 * @param o the specified object to compare to this
 *          <code>NumericShaper</code>
 * @return <code>true</code> if <code>o</code> is an instance
 *         of <code>NumericShaper</code> and shapes in the same way;
 *         <code>false</code> otherwise.
 * @see java.lang.Object#equals(java.lang.Object)
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>String</code> that describes this shaper. This method
 * is used for debugging purposes only.
 * @return a <code>String</code> describing this shaper.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Identifies all ranges, for full contextual shaping.
 *
 * <p>This constant specifies all of the bit mask-based
 * ranges. Use {@code EmunSet.allOf(NumericShaper.Range.class)} to
 * specify all of the enum-based ranges.
 */

public static final int ALL_RANGES = 524287; // 0x7ffff

/** Identifies the ARABIC range and decimal base. */

public static final int ARABIC = 2; // 0x2

/** Identifies the BENGALI range and decimal base. */

public static final int BENGALI = 16; // 0x10

/** Identifies the DEVANAGARI range and decimal base. */

public static final int DEVANAGARI = 8; // 0x8

/** Identifies the ARABIC range and ARABIC_EXTENDED decimal base. */

public static final int EASTERN_ARABIC = 4; // 0x4

/** Identifies the ETHIOPIC range and decimal base. */

public static final int ETHIOPIC = 65536; // 0x10000

/** Identifies the Latin-1 (European) and extended range, and
 *  Latin-1 (European) decimal base.
 */

public static final int EUROPEAN = 1; // 0x1

/** Identifies the GUJARATI range and decimal base. */

public static final int GUJARATI = 64; // 0x40

/** Identifies the GURMUKHI range and decimal base. */

public static final int GURMUKHI = 32; // 0x20

/** Identifies the KANNADA range and decimal base. */

public static final int KANNADA = 1024; // 0x400

/** Identifies the KHMER range and decimal base. */

public static final int KHMER = 131072; // 0x20000

/** Identifies the LAO range and decimal base. */

public static final int LAO = 8192; // 0x2000

/** Identifies the MALAYALAM range and decimal base. */

public static final int MALAYALAM = 2048; // 0x800

/** Identifies the MONGOLIAN range and decimal base. */

public static final int MONGOLIAN = 262144; // 0x40000

/** Identifies the MYANMAR range and decimal base. */

public static final int MYANMAR = 32768; // 0x8000

/** Identifies the ORIYA range and decimal base. */

public static final int ORIYA = 128; // 0x80

/** Identifies the TAMIL range and decimal base. */

public static final int TAMIL = 256; // 0x100

/** Identifies the TELUGU range and decimal base. */

public static final int TELUGU = 512; // 0x200

/** Identifies the THAI range and decimal base. */

public static final int THAI = 4096; // 0x1000

/** Identifies the TIBETAN range and decimal base. */

public static final int TIBETAN = 16384; // 0x4000
/**
 * A {@code NumericShaper.Range} represents a Unicode range of a
 * script having its own decimal digits. For example, the {@link
 * NumericShaper.Range#THAI} range has the Thai digits, THAI DIGIT
 * ZERO (U+0E50) to THAI DIGIT NINE (U+0E59).
 *
 * <p>The <code>Range</code> enum replaces the traditional bit
 * mask-based values (e.g., {@link NumericShaper#ARABIC}), and
 * supports more Unicode ranges than the bit mask-based ones. For
 * example, the following code using the bit mask:
 * <blockquote><pre>
 * NumericShaper.getContextualShaper(NumericShaper.ARABIC |
 *                                     NumericShaper.TAMIL,
 *                                   NumericShaper.EUROPEAN);
 * </pre></blockquote>
 * can be written using this enum as:
 * <blockquote><pre>
 * NumericShaper.getContextualShaper(EnumSet.of(
 *                                     NumericShaper.Range.ARABIC,
 *                                     NumericShaper.Range.TAMIL),
 *                                   NumericShaper.Range.EUROPEAN);
 * </pre></blockquote>
 *
 * @since 1.7
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Range {
EUROPEAN, ARABIC, EASTERN_ARABIC, DEVANAGARI, BENGALI, GURMUKHI, GUJARATI, ORIYA, TAMIL, TELUGU, KANNADA, MALAYALAM, THAI, LAO, TIBETAN, MYANMAR, ETHIOPIC, KHMER, MONGOLIAN, NKO, MYANMAR_SHAN, LIMBU, NEW_TAI_LUE, BALINESE, SUNDANESE, LEPCHA, OL_CHIKI, VAI, SAURASHTRA, KAYAH_LI, CHAM, TAI_THAM_HORA, TAI_THAM_THAM, JAVANESE, MEETEI_MAYEK;
}

}

