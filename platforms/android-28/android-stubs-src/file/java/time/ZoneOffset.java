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
 * This file is available under and governed by the GNU General Public
 * License version 2 only, as published by the Free Software Foundation.
 * However, the following notice accompanied the original version of this
 * file:
 *
 * Copyright (c) 2007-2012, Stephen Colebourne & Michael Nascimento Santos
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

package java.time;

import java.time.temporal.TemporalAccessor;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalQueries;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.TemporalAdjuster;
import java.io.InvalidObjectException;

/**
 * A time-zone offset from Greenwich/UTC, such as {@code +02:00}.
 * <p>
 * A time-zone offset is the amount of time that a time-zone differs from Greenwich/UTC.
 * This is usually a fixed number of hours and minutes.
 * <p>
 * Different parts of the world have different time-zone offsets.
 * The rules for how offsets vary by place and time of year are captured in the
 * {@link ZoneId} class.
 * <p>
 * For example, Paris is one hour ahead of Greenwich/UTC in winter and two hours
 * ahead in summer. The {@code ZoneId} instance for Paris will reference two
 * {@code ZoneOffset} instances - a {@code +01:00} instance for winter,
 * and a {@code +02:00} instance for summer.
 * <p>
 * In 2008, time-zone offsets around the world extended from -12:00 to +14:00.
 * To prevent any problems with that range being extended, yet still provide
 * validation, the range of offsets is restricted to -18:00 to 18:00 inclusive.
 * <p>
 * This class is designed for use with the ISO calendar system.
 * The fields of hours, minutes and seconds make assumptions that are valid for the
 * standard ISO definitions of those fields. This class may be used with other
 * calendar systems providing the definition of the time fields matches those
 * of the ISO calendar system.
 * <p>
 * Instances of {@code ZoneOffset} must be compared using {@link #equals}.
 * Implementations may choose to cache certain common offsets, however
 * applications must not rely on such caching.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ZoneOffset extends java.time.ZoneId implements java.time.temporal.TemporalAccessor, java.time.temporal.TemporalAdjuster, java.lang.Comparable<java.time.ZoneOffset>, java.io.Serializable {

/**
 * Constructor.
 *
 * @param totalSeconds  the total time-zone offset in seconds, from -64800 to +64800
 */

ZoneOffset(int totalSeconds) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code ZoneOffset} using the ID.
 * <p>
 * This method parses the string ID of a {@code ZoneOffset} to
 * return an instance. The parsing accepts all the formats generated by
 * {@link #getId()}, plus some additional formats:
 * <ul>
 * <li>{@code Z} - for UTC
 * <li>{@code +h}
 * <li>{@code +hh}
 * <li>{@code +hh:mm}
 * <li>{@code -hh:mm}
 * <li>{@code +hhmm}
 * <li>{@code -hhmm}
 * <li>{@code +hh:mm:ss}
 * <li>{@code -hh:mm:ss}
 * <li>{@code +hhmmss}
 * <li>{@code -hhmmss}
 * </ul>
 * Note that &plusmn; means either the plus or minus symbol.
 * <p>
 * The ID of the returned offset will be normalized to one of the formats
 * described by {@link #getId()}.
 * <p>
 * The maximum supported range is from +18:00 to -18:00 inclusive.
 *
 * @param offsetId  the offset ID, not null
 * @return the zone-offset, not null
 * @throws DateTimeException if the offset ID is invalid
 */

public static java.time.ZoneOffset of(java.lang.String offsetId) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code ZoneOffset} using an offset in hours.
 *
 * @param hours  the time-zone offset in hours, from -18 to +18
 * @return the zone-offset, not null
 * @throws DateTimeException if the offset is not in the required range
 */

public static java.time.ZoneOffset ofHours(int hours) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code ZoneOffset} using an offset in
 * hours and minutes.
 * <p>
 * The sign of the hours and minutes components must match.
 * Thus, if the hours is negative, the minutes must be negative or zero.
 * If the hours is zero, the minutes may be positive, negative or zero.
 *
 * @param hours  the time-zone offset in hours, from -18 to +18
 * @param minutes  the time-zone offset in minutes, from 0 to &plusmn;59, sign matches hours
 * @return the zone-offset, not null
 * @throws DateTimeException if the offset is not in the required range
 */

public static java.time.ZoneOffset ofHoursMinutes(int hours, int minutes) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code ZoneOffset} using an offset in
 * hours, minutes and seconds.
 * <p>
 * The sign of the hours, minutes and seconds components must match.
 * Thus, if the hours is negative, the minutes and seconds must be negative or zero.
 *
 * @param hours  the time-zone offset in hours, from -18 to +18
 * @param minutes  the time-zone offset in minutes, from 0 to &plusmn;59, sign matches hours and seconds
 * @param seconds  the time-zone offset in seconds, from 0 to &plusmn;59, sign matches hours and minutes
 * @return the zone-offset, not null
 * @throws DateTimeException if the offset is not in the required range
 */

public static java.time.ZoneOffset ofHoursMinutesSeconds(int hours, int minutes, int seconds) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code ZoneOffset} from a temporal object.
 * <p>
 * This obtains an offset based on the specified temporal.
 * A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 * which this factory converts to an instance of {@code ZoneOffset}.
 * <p>
 * A {@code TemporalAccessor} represents some form of date and time information.
 * This factory converts the arbitrary temporal object to an instance of {@code ZoneOffset}.
 * <p>
 * The conversion uses the {@link TemporalQueries#offset()} query, which relies
 * on extracting the {@link ChronoField#OFFSET_SECONDS OFFSET_SECONDS} field.
 * <p>
 * This method matches the signature of the functional interface {@link TemporalQuery}
 * allowing it to be used as a query via method reference, {@code ZoneOffset::from}.
 *
 * @param temporal  the temporal object to convert, not null
 * @return the zone-offset, not null
 * @throws DateTimeException if unable to convert to an {@code ZoneOffset}
 */

public static java.time.ZoneOffset from(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code ZoneOffset} specifying the total offset in seconds
 * <p>
 * The offset must be in the range {@code -18:00} to {@code +18:00}, which corresponds to -64800 to +64800.
 *
 * @param totalSeconds  the total time-zone offset in seconds, from -64800 to +64800
 * @return the ZoneOffset, not null
 * @throws DateTimeException if the offset is not in the required range
 */

public static java.time.ZoneOffset ofTotalSeconds(int totalSeconds) { throw new RuntimeException("Stub!"); }

/**
 * Gets the total zone offset in seconds.
 * <p>
 * This is the primary way to access the offset amount.
 * It returns the total of the hours, minutes and seconds fields as a
 * single offset that can be added to a time.
 *
 * @return the total zone offset amount in seconds
 */

public int getTotalSeconds() { throw new RuntimeException("Stub!"); }

/**
 * Gets the normalized zone offset ID.
 * <p>
 * The ID is minor variation to the standard ISO-8601 formatted string
 * for the offset. There are three formats:
 * <ul>
 * <li>{@code Z} - for UTC (ISO-8601)
 * <li>{@code +hh:mm} or {@code -hh:mm} - if the seconds are zero (ISO-8601)
 * <li>{@code +hh:mm:ss} or {@code -hh:mm:ss} - if the seconds are non-zero (not ISO-8601)
 * </ul>
 *
 * @return the zone offset ID, not null
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the associated time-zone rules.
 * <p>
 * The rules will always return this offset when queried.
 * The implementation class is immutable, thread-safe and serializable.
 *
 * @return the rules, not null
 */

public java.time.zone.ZoneRules getRules() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified field is supported.
 * <p>
 * This checks if this offset can be queried for the specified field.
 * If false, then calling the {@link #range(TemporalField) range} and
 * {@link #get(TemporalField) get} methods will throw an exception.
 * <p>
 * If the field is a {@link ChronoField} then the query is implemented here.
 * The {@code OFFSET_SECONDS} field returns true.
 * All other {@code ChronoField} instances will return false.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}
 * passing {@code this} as the argument.
 * Whether the field is supported is determined by the field.
 *
 * @param field  the field to check, null returns false
 * @return true if the field is supported on this offset, false if not
 */

public boolean isSupported(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Gets the range of valid values for the specified field.
 * <p>
 * The range object expresses the minimum and maximum valid values for a field.
 * This offset is used to enhance the accuracy of the returned range.
 * If it is not possible to return the range, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link ChronoField} then the query is implemented here.
 * The {@link #isSupported(TemporalField) supported fields} will return
 * appropriate range instances.
 * All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)}
 * passing {@code this} as the argument.
 * Whether the range can be obtained is determined by the field.
 *
 * @param field  the field to query the range for, not null
 * @return the range of valid values for the field, not null
 * @throws DateTimeException if the range for the field cannot be obtained
 * @throws UnsupportedTemporalTypeException if the field is not supported
 */

public java.time.temporal.ValueRange range(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the specified field from this offset as an {@code int}.
 * <p>
 * This queries this offset for the value of the specified field.
 * The returned value will always be within the valid range of values for the field.
 * If it is not possible to return the value, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link ChronoField} then the query is implemented here.
 * The {@code OFFSET_SECONDS} field returns the value of the offset.
 * All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}
 * passing {@code this} as the argument. Whether the value can be obtained,
 * and what the value represents, is determined by the field.
 *
 * @param field  the field to get, not null
 * @return the value for the field
 * @throws DateTimeException if a value for the field cannot be obtained or
 *         the value is outside the range of valid values for the field
 * @throws UnsupportedTemporalTypeException if the field is not supported or
 *         the range of values exceeds an {@code int}
 * @throws ArithmeticException if numeric overflow occurs
 */

public int get(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of the specified field from this offset as a {@code long}.
 * <p>
 * This queries this offset for the value of the specified field.
 * If it is not possible to return the value, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link ChronoField} then the query is implemented here.
 * The {@code OFFSET_SECONDS} field returns the value of the offset.
 * All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.getFrom(TemporalAccessor)}
 * passing {@code this} as the argument. Whether the value can be obtained,
 * and what the value represents, is determined by the field.
 *
 * @param field  the field to get, not null
 * @return the value for the field
 * @throws DateTimeException if a value for the field cannot be obtained
 * @throws UnsupportedTemporalTypeException if the field is not supported
 * @throws ArithmeticException if numeric overflow occurs
 */

public long getLong(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Queries this offset using the specified query.
 * <p>
 * This queries this offset using the specified query strategy object.
 * The {@code TemporalQuery} object defines the logic to be used to
 * obtain the result. Read the documentation of the query to understand
 * what the result of this method will be.
 * <p>
 * The result of this method is obtained by invoking the
 * {@link TemporalQuery#queryFrom(TemporalAccessor)} method on the
 * specified query passing {@code this} as the argument.
 *
 * @param <R> the type of the result
 * @param query  the query to invoke, not null
 * @return the query result, null may be returned (defined by the query)
 * @throws DateTimeException if unable to query (defined by the query)
 * @throws ArithmeticException if numeric overflow occurs (defined by the query)
 */

public <R> R query(java.time.temporal.TemporalQuery<R> query) { throw new RuntimeException("Stub!"); }

/**
 * Adjusts the specified temporal object to have the same offset as this object.
 * <p>
 * This returns a temporal object of the same observable type as the input
 * with the offset changed to be the same as this.
 * <p>
 * The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}
 * passing {@link ChronoField#OFFSET_SECONDS} as the field.
 * <p>
 * In most cases, it is clearer to reverse the calling pattern by using
 * {@link Temporal#with(TemporalAdjuster)}:
 * <pre>
 *   // these two lines are equivalent, but the second approach is recommended
 *   temporal = thisOffset.adjustInto(temporal);
 *   temporal = temporal.with(thisOffset);
 * </pre>
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param temporal  the target object to be adjusted, not null
 * @return the adjusted object, not null
 * @throws DateTimeException if unable to make the adjustment
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.temporal.Temporal adjustInto(java.time.temporal.Temporal temporal) { throw new RuntimeException("Stub!"); }

/**
 * Compares this offset to another offset in descending order.
 * <p>
 * The offsets are compared in the order that they occur for the same time
 * of day around the world. Thus, an offset of {@code +10:00} comes before an
 * offset of {@code +09:00} and so on down to {@code -18:00}.
 * <p>
 * The comparison is "consistent with equals", as defined by {@link Comparable}.
 *
 * @param other  the other date to compare to, not null
 * @return the comparator value, negative if less, postive if greater
 * @throws NullPointerException if {@code other} is null
 */

public int compareTo(java.time.ZoneOffset other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this offset is equal to another offset.
 * <p>
 * The comparison is based on the amount of the offset in seconds.
 * This is equivalent to a comparison by ID.
 *
 * @param obj  the object to check, null returns false
 * @return true if this is equal to the other offset
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * A hash code for this offset.
 *
 * @return a suitable hash code
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Outputs this offset as a {@code String}, using the normalized ID.
 *
 * @return a string representation of this offset, not null
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Constant for the maximum supported offset.
 */

public static final java.time.ZoneOffset MAX;
static { MAX = null; }

/**
 * Constant for the maximum supported offset.
 */

public static final java.time.ZoneOffset MIN;
static { MIN = null; }

/**
 * The time-zone offset for UTC, with an ID of 'Z'.
 */

public static final java.time.ZoneOffset UTC;
static { UTC = null; }
}

