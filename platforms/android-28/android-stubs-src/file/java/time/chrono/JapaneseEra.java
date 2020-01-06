/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Copyright (c) 2012, Stephen Colebourne & Michael Nascimento Santos
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of JSR-310 nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package java.time.chrono;

import java.time.DateTimeException;
import java.time.temporal.TemporalField;
import java.time.temporal.ChronoField;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.io.InvalidObjectException;

/**
 * An era in the Japanese Imperial calendar system.
 * <p>
 * This class defines the valid eras for the Japanese chronology.
 * Japan introduced the Gregorian calendar starting with Meiji 6.
 * Only Meiji and later eras are supported;
 * dates before Meiji 6, January 1 are not supported.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class JapaneseEra implements java.time.chrono.Era, java.io.Serializable {

/**
 * Creates an instance.
 *
 * @param eraValue  the era value, validated
 * @param since  the date representing the first date of the era, validated not null
 */

JapaneseEra(int eraValue, java.time.LocalDate since) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code JapaneseEra} from an {@code int} value.
 * <p>
 * The {@link #SHOWA} era that contains 1970-01-01 (ISO calendar system) has the value 1
 * Later era is numbered 2 ({@link #HEISEI}). Earlier eras are numbered 0 ({@link #TAISHO}),
 * -1 ({@link #MEIJI}), only Meiji and later eras are supported.
 *
 * @param japaneseEra  the era to represent
 * @return the {@code JapaneseEra} singleton, not null
 * @throws DateTimeException if the value is invalid
 */

public static java.time.chrono.JapaneseEra of(int japaneseEra) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code JapaneseEra} with the name.
 * <p>
 * The string must match exactly the name of the era.
 * (Extraneous whitespace characters are not permitted.)
 *
 * @param japaneseEra  the japaneseEra name; non-null
 * @return the {@code JapaneseEra} singleton, never null
 * @throws IllegalArgumentException if there is not JapaneseEra with the specified name
 */

public static java.time.chrono.JapaneseEra valueOf(java.lang.String japaneseEra) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of JapaneseEras.
 * <p>
 * This method may be used to iterate over the JapaneseEras as follows:
 * <pre>
 * for (JapaneseEra c : JapaneseEra.values())
 *     System.out.println(c);
 * </pre>
 *
 * @return an array of JapaneseEras
 */

public static java.time.chrono.JapaneseEra[] values() { throw new RuntimeException("Stub!"); }

/**
 * Gets the numeric era {@code int} value.
 * <p>
 * The {@link #SHOWA} era that contains 1970-01-01 (ISO calendar system) has the value 1.
 * Later eras are numbered from 2 ({@link #HEISEI}).
 * Earlier eras are numbered 0 ({@link #TAISHO}), -1 ({@link #MEIJI})).
 *
 * @return the era value
 */

public int getValue() { throw new RuntimeException("Stub!"); }

/**
 * Gets the range of valid values for the specified field.
 * <p>
 * The range object expresses the minimum and maximum valid values for a field.
 * This era is used to enhance the accuracy of the returned range.
 * If it is not possible to return the range, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link ChronoField} then the query is implemented here.
 * The {@code ERA} field returns the range.
 * All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}
 * passing {@code this} as the argument.
 * Whether the range can be obtained is determined by the field.
 * <p>
 * The range of valid Japanese eras can change over time due to the nature
 * of the Japanese calendar system.
 *
 * @param field  the field to query the range for, not null
 * @return the range of valid values for the field, not null
 * @throws DateTimeException if the range for the field cannot be obtained
 * @throws UnsupportedTemporalTypeException if the unit is not supported
 */

public java.time.temporal.ValueRange range(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The singleton instance for the 'Heisei' era (1989-01-08 - current)
 * which has the value 2.
 */

public static final java.time.chrono.JapaneseEra HEISEI;
static { HEISEI = null; }

/**
 * The singleton instance for the 'Meiji' era (1868-01-01 - 1912-07-29)
 * which has the value -1.
 */

public static final java.time.chrono.JapaneseEra MEIJI;
static { MEIJI = null; }

/**
 * The singleton instance for the 'Showa' era (1926-12-25 - 1989-01-07)
 * which has the value 1.
 */

public static final java.time.chrono.JapaneseEra SHOWA;
static { SHOWA = null; }

/**
 * The singleton instance for the 'Taisho' era (1912-07-30 - 1926-12-24)
 * which has the value 0.
 */

public static final java.time.chrono.JapaneseEra TAISHO;
static { TAISHO = null; }
}

