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

package java.time.temporal;

import android.icu.text.DateTimePatternGenerator;
import java.time.chrono.Chronology;
import java.time.DayOfWeek;
import java.time.chrono.ChronoLocalDate;
import java.time.Instant;
import java.time.ZoneOffset;

/**
 * A standard set of fields.
 * <p>
 * This set of fields provide field-based access to manipulate a date, time or date-time.
 * The standard set of fields can be extended by implementing {@link TemporalField}.
 * <p>
 * These fields are intended to be applicable in multiple calendar systems.
 * For example, most non-ISO calendar systems define dates as a year, month and day,
 * just with slightly different rules.
 * The documentation of each field explains how it operates.
 *
 * @implSpec
 * This is a final, immutable and thread-safe enum.
 *
 * @since 1.8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum ChronoField implements java.time.temporal.TemporalField {
NANO_OF_SECOND, NANO_OF_DAY, MICRO_OF_SECOND, MICRO_OF_DAY, MILLI_OF_SECOND, MILLI_OF_DAY, SECOND_OF_MINUTE, SECOND_OF_DAY, MINUTE_OF_HOUR, MINUTE_OF_DAY, HOUR_OF_AMPM, CLOCK_HOUR_OF_AMPM, HOUR_OF_DAY, CLOCK_HOUR_OF_DAY, AMPM_OF_DAY, DAY_OF_WEEK, ALIGNED_DAY_OF_WEEK_IN_MONTH, ALIGNED_DAY_OF_WEEK_IN_YEAR, DAY_OF_MONTH, DAY_OF_YEAR, EPOCH_DAY, ALIGNED_WEEK_OF_MONTH, ALIGNED_WEEK_OF_YEAR, MONTH_OF_YEAR, PROLEPTIC_MONTH, YEAR_OF_ERA, YEAR, ERA, INSTANT_SECONDS, OFFSET_SECONDS;

public java.lang.String getDisplayName(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

public java.time.temporal.TemporalUnit getBaseUnit() { throw new RuntimeException("Stub!"); }

public java.time.temporal.TemporalUnit getRangeUnit() { throw new RuntimeException("Stub!"); }

/**
 * Gets the range of valid values for the field.
 * <p>
 * All fields can be expressed as a {@code long} integer.
 * This method returns an object that describes the valid range for that value.
 * <p>
 * This method returns the range of the field in the ISO-8601 calendar system.
 * This range may be incorrect for other calendar systems.
 * Use {@link Chronology#range(ChronoField)} to access the correct range
 * for a different calendar system.
 * <p>
 * Note that the result only describes the minimum and maximum valid values
 * and it is important not to read too much into them. For example, there
 * could be values within the range that are invalid for the field.
 *
 * @return the range of valid values for the field, not null
 */

public java.time.temporal.ValueRange range() { throw new RuntimeException("Stub!"); }

/**
 * Checks if this field represents a component of a date.
 * <p>
 * Fields from day-of-week to era are date-based.
 *
 * @return true if it is a component of a date
 */

public boolean isDateBased() { throw new RuntimeException("Stub!"); }

/**
 * Checks if this field represents a component of a time.
 * <p>
 * Fields from nano-of-second to am-pm-of-day are time-based.
 *
 * @return true if it is a component of a time
 */

public boolean isTimeBased() { throw new RuntimeException("Stub!"); }

/**
 * Checks that the specified value is valid for this field.
 * <p>
 * This validates that the value is within the outer range of valid values
 * returned by {@link #range()}.
 * <p>
 * This method checks against the range of the field in the ISO-8601 calendar system.
 * This range may be incorrect for other calendar systems.
 * Use {@link Chronology#range(ChronoField)} to access the correct range
 * for a different calendar system.
 *
 * @param value  the value to check
 * @return the value that was passed in
 */

public long checkValidValue(long value) { throw new RuntimeException("Stub!"); }

/**
 * Checks that the specified value is valid and fits in an {@code int}.
 * <p>
 * This validates that the value is within the outer range of valid values
 * returned by {@link #range()}.
 * It also checks that all valid values are within the bounds of an {@code int}.
 * <p>
 * This method checks against the range of the field in the ISO-8601 calendar system.
 * This range may be incorrect for other calendar systems.
 * Use {@link Chronology#range(ChronoField)} to access the correct range
 * for a different calendar system.
 *
 * @param value  the value to check
 * @return the value that was passed in
 */

public int checkValidIntValue(long value) { throw new RuntimeException("Stub!"); }

public boolean isSupportedBy(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

public java.time.temporal.ValueRange rangeRefinedBy(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

public long getFrom(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

public <R extends java.time.temporal.Temporal> R adjustInto(R temporal, long newValue) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

