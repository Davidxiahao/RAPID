/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

package java.time.chrono;

import java.util.Locale;
import java.time.DateTimeException;
import java.io.InvalidObjectException;

/**
 * The Minguo calendar system.
 * <p>
 * This chronology defines the rules of the Minguo calendar system.
 * This calendar system is primarily used in the Republic of China, often known as Taiwan.
 * Dates are aligned such that {@code 0001-01-01 (Minguo)} is {@code 1912-01-01 (ISO)}.
 * <p>
 * The fields are defined as follows:
 * <ul>
 * <li>era - There are two eras, the current 'Republic' (ERA_ROC) and the previous era (ERA_BEFORE_ROC).
 * <li>year-of-era - The year-of-era for the current era increases uniformly from the epoch at year one.
 *  For the previous era the year increases from one as time goes backwards.
 *  The value for the current era is equal to the ISO proleptic-year minus 1911.
 * <li>proleptic-year - The proleptic year is the same as the year-of-era for the
 *  current era. For the previous era, years have zero, then negative values.
 *  The value is equal to the ISO proleptic-year minus 1911.
 * <li>month-of-year - The Minguo month-of-year exactly matches ISO.
 * <li>day-of-month - The Minguo day-of-month exactly matches ISO.
 * <li>day-of-year - The Minguo day-of-year exactly matches ISO.
 * <li>leap-year - The Minguo leap-year pattern exactly matches ISO, such that the two calendars
 *  are never out of step.
 * </ul>
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MinguoChronology extends java.time.chrono.AbstractChronology implements java.io.Serializable {

/**
 * Restricted constructor.
 */

MinguoChronology() { throw new RuntimeException("Stub!"); }

/**
 * Gets the ID of the chronology - 'Minguo'.
 * <p>
 * The ID uniquely identifies the {@code Chronology}.
 * It can be used to lookup the {@code Chronology} using {@link Chronology#of(String)}.
 *
 * @return the chronology ID - 'Minguo'
 * @see #getCalendarType()
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the calendar type of the underlying calendar system - 'roc'.
 * <p>
 * The calendar type is an identifier defined by the
 * <em>Unicode Locale Data Markup Language (LDML)</em> specification.
 * It can be used to lookup the {@code Chronology} using {@link Chronology#of(String)}.
 * It can also be used as part of a locale, accessible via
 * {@link Locale#getUnicodeLocaleType(String)} with the key 'ca'.
 *
 * @return the calendar system type - 'roc'
 * @see #getId()
 */

public java.lang.String getCalendarType() { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in Minguo calendar system from the
 * era, year-of-era, month-of-year and day-of-month fields.
 *
 * @param era  the Minguo era, not null
 * @param yearOfEra  the year-of-era
 * @param month  the month-of-year
 * @param dayOfMonth  the day-of-month
 * @return the Minguo local date, not null
 * @throws DateTimeException if unable to create the date
 * @throws ClassCastException if the {@code era} is not a {@code MinguoEra}
 */

public java.time.chrono.MinguoDate date(java.time.chrono.Era era, int yearOfEra, int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in Minguo calendar system from the
 * proleptic-year, month-of-year and day-of-month fields.
 *
 * @param prolepticYear  the proleptic-year
 * @param month  the month-of-year
 * @param dayOfMonth  the day-of-month
 * @return the Minguo local date, not null
 * @throws DateTimeException if unable to create the date
 */

public java.time.chrono.MinguoDate date(int prolepticYear, int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in Minguo calendar system from the
 * era, year-of-era and day-of-year fields.
 *
 * @param era  the Minguo era, not null
 * @param yearOfEra  the year-of-era
 * @param dayOfYear  the day-of-year
 * @return the Minguo local date, not null
 * @throws DateTimeException if unable to create the date
 * @throws ClassCastException if the {@code era} is not a {@code MinguoEra}
 */

public java.time.chrono.MinguoDate dateYearDay(java.time.chrono.Era era, int yearOfEra, int dayOfYear) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in Minguo calendar system from the
 * proleptic-year and day-of-year fields.
 *
 * @param prolepticYear  the proleptic-year
 * @param dayOfYear  the day-of-year
 * @return the Minguo local date, not null
 * @throws DateTimeException if unable to create the date
 */

public java.time.chrono.MinguoDate dateYearDay(int prolepticYear, int dayOfYear) { throw new RuntimeException("Stub!"); }

/**
 * Obtains a local date in the Minguo calendar system from the epoch-day.
 *
 * @param epochDay  the epoch day
 * @return the Minguo local date, not null
 * @throws DateTimeException if unable to create the date
 */

public java.time.chrono.MinguoDate dateEpochDay(long epochDay) { throw new RuntimeException("Stub!"); }

public java.time.chrono.MinguoDate dateNow() { throw new RuntimeException("Stub!"); }

public java.time.chrono.MinguoDate dateNow(java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

public java.time.chrono.MinguoDate dateNow(java.time.Clock clock) { throw new RuntimeException("Stub!"); }

public java.time.chrono.MinguoDate date(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

public java.time.chrono.ChronoLocalDateTime<java.time.chrono.MinguoDate> localDateTime(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

public java.time.chrono.ChronoZonedDateTime<java.time.chrono.MinguoDate> zonedDateTime(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

public java.time.chrono.ChronoZonedDateTime<java.time.chrono.MinguoDate> zonedDateTime(java.time.Instant instant, java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified year is a leap year.
 * <p>
 * Minguo leap years occur exactly in line with ISO leap years.
 * This method does not validate the year passed in, and only has a
 * well-defined result for years in the supported range.
 *
 * @param prolepticYear  the proleptic-year to check, not validated for range
 * @return true if the year is a leap year
 */

public boolean isLeapYear(long prolepticYear) { throw new RuntimeException("Stub!"); }

public int prolepticYear(java.time.chrono.Era era, int yearOfEra) { throw new RuntimeException("Stub!"); }

public java.time.chrono.MinguoEra eraOf(int eraValue) { throw new RuntimeException("Stub!"); }

public java.util.List<java.time.chrono.Era> eras() { throw new RuntimeException("Stub!"); }

public java.time.temporal.ValueRange range(java.time.temporal.ChronoField field) { throw new RuntimeException("Stub!"); }

public java.time.chrono.MinguoDate resolveDate(java.util.Map<java.time.temporal.TemporalField, java.lang.Long> fieldValues, java.time.format.ResolverStyle resolverStyle) { throw new RuntimeException("Stub!"); }

/**
 * Singleton instance for the Minguo chronology.
 */

public static final java.time.chrono.MinguoChronology INSTANCE;
static { INSTANCE = null; }
}

