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

package java.time.chrono;

import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.time.temporal.Temporal;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.DateTimeException;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.zone.ZoneRules;
import java.time.Instant;

/**
 * A date-time without a time-zone in an arbitrary chronology, intended
 * for advanced globalization use cases.
 * <p>
 * <b>Most applications should declare method signatures, fields and variables
 * as {@link LocalDateTime}, not this interface.</b>
 * <p>
 * A {@code ChronoLocalDateTime} is the abstract representation of a local date-time
 * where the {@code Chronology chronology}, or calendar system, is pluggable.
 * The date-time is defined in terms of fields expressed by {@link TemporalField},
 * where most common implementations are defined in {@link ChronoField}.
 * The chronology defines how the calendar system operates and the meaning of
 * the standard fields.
 *
 * <h3>When to use this interface</h3>
 * The design of the API encourages the use of {@code LocalDateTime} rather than this
 * interface, even in the case where the application needs to deal with multiple
 * calendar systems. The rationale for this is explored in detail in {@link ChronoLocalDate}.
 * <p>
 * Ensure that the discussion in {@code ChronoLocalDate} has been read and understood
 * before using this interface.
 *
 * @implSpec
 * This interface must be implemented with care to ensure other classes operate correctly.
 * All implementations that can be instantiated must be final, immutable and thread-safe.
 * Subclasses should be Serializable wherever possible.
 *
 * @param <D> the concrete type for the date of this date-time
 * @since 1.8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface ChronoLocalDateTime<D extends java.time.chrono.ChronoLocalDate> extends java.time.temporal.Temporal,  java.time.temporal.TemporalAdjuster, java.lang.Comparable<java.time.chrono.ChronoLocalDateTime<?>> {

/**
 * Gets a comparator that compares {@code ChronoLocalDateTime} in
 * time-line order ignoring the chronology.
 * <p>
 * This comparator differs from the comparison in {@link #compareTo} in that it
 * only compares the underlying date-time and not the chronology.
 * This allows dates in different calendar systems to be compared based
 * on the position of the date-time on the local time-line.
 * The underlying comparison is equivalent to comparing the epoch-day and nano-of-day.
 *
 * @return a comparator that compares in time-line order ignoring the chronology
 * @see #isAfter
 * @see #isBefore
 * @see #isEqual
 */

public static java.util.Comparator<java.time.chrono.ChronoLocalDateTime<?>> timeLineOrder() { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code ChronoLocalDateTime} from a temporal object.
 * <p>
 * This obtains a local date-time based on the specified temporal.
 * A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 * which this factory converts to an instance of {@code ChronoLocalDateTime}.
 * <p>
 * The conversion extracts and combines the chronology and the date-time
 * from the temporal object. The behavior is equivalent to using
 * {@link Chronology#localDateTime(TemporalAccessor)} with the extracted chronology.
 * Implementations are permitted to perform optimizations such as accessing
 * those fields that are equivalent to the relevant objects.
 * <p>
 * This method matches the signature of the functional interface {@link TemporalQuery}
 * allowing it to be used as a query via method reference, {@code ChronoLocalDateTime::from}.
 *
 * @param temporal  the temporal object to convert, not null
 * @return the date-time, not null
 * @throws DateTimeException if unable to convert to a {@code ChronoLocalDateTime}
 * @see Chronology#localDateTime(TemporalAccessor)
 */

public static java.time.chrono.ChronoLocalDateTime<?> from(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/**
 * Gets the chronology of this date-time.
 * <p>
 * The {@code Chronology} represents the calendar system in use.
 * The era and other fields in {@link ChronoField} are defined by the chronology.
 *
 * @return the chronology, not null
 */

public default java.time.chrono.Chronology getChronology() { throw new RuntimeException("Stub!"); }

/**
 * Gets the local date part of this date-time.
 * <p>
 * This returns a local date with the same year, month and day
 * as this date-time.
 *
 * @return the date part of this date-time, not null
 */

public D toLocalDate();

/**
 * Gets the local time part of this date-time.
 * <p>
 * This returns a local time with the same hour, minute, second and
 * nanosecond as this date-time.
 *
 * @return the time part of this date-time, not null
 */

public java.time.LocalTime toLocalTime();

/**
 * Checks if the specified field is supported.
 * <p>
 * This checks if the specified field can be queried on this date-time.
 * If false, then calling the {@link #range(TemporalField) range},
 * {@link #get(TemporalField) get} and {@link #with(TemporalField, long)}
 * methods will throw an exception.
 * <p>
 * The set of supported fields is defined by the chronology and normally includes
 * all {@code ChronoField} date and time fields.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}
 * passing {@code this} as the argument.
 * Whether the field is supported is determined by the field.
 *
 * @param field  the field to check, null returns false
 * @return true if the field can be queried, false if not
 */

public boolean isSupported(java.time.temporal.TemporalField field);

/**
 * Checks if the specified unit is supported.
 * <p>
 * This checks if the specified unit can be added to or subtracted from this date-time.
 * If false, then calling the {@link #plus(long, TemporalUnit)} and
 * {@link #minus(long, TemporalUnit) minus} methods will throw an exception.
 * <p>
 * The set of supported units is defined by the chronology and normally includes
 * all {@code ChronoUnit} units except {@code FOREVER}.
 * <p>
 * If the unit is not a {@code ChronoUnit}, then the result of this method
 * is obtained by invoking {@code TemporalUnit.isSupportedBy(Temporal)}
 * passing {@code this} as the argument.
 * Whether the unit is supported is determined by the unit.
 *
 * @param unit  the unit to check, null returns false
 * @return true if the unit can be added/subtracted, false if not
 */

public default boolean isSupported(java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws DateTimeException {@inheritDoc}
 * @throws ArithmeticException {@inheritDoc}
 */

public default java.time.chrono.ChronoLocalDateTime<D> with(java.time.temporal.TemporalAdjuster adjuster) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws DateTimeException {@inheritDoc}
 * @throws ArithmeticException {@inheritDoc}
 */

public java.time.chrono.ChronoLocalDateTime<D> with(java.time.temporal.TemporalField field, long newValue);

/**
 * {@inheritDoc}
 * @throws DateTimeException {@inheritDoc}
 * @throws ArithmeticException {@inheritDoc}
 */

public default java.time.chrono.ChronoLocalDateTime<D> plus(java.time.temporal.TemporalAmount amount) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws DateTimeException {@inheritDoc}
 * @throws ArithmeticException {@inheritDoc}
 */

public java.time.chrono.ChronoLocalDateTime<D> plus(long amountToAdd, java.time.temporal.TemporalUnit unit);

/**
 * {@inheritDoc}
 * @throws DateTimeException {@inheritDoc}
 * @throws ArithmeticException {@inheritDoc}
 */

public default java.time.chrono.ChronoLocalDateTime<D> minus(java.time.temporal.TemporalAmount amount) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws DateTimeException {@inheritDoc}
 * @throws ArithmeticException {@inheritDoc}
 */

public default java.time.chrono.ChronoLocalDateTime<D> minus(long amountToSubtract, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Queries this date-time using the specified query.
 * <p>
 * This queries this date-time using the specified query strategy object.
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

public default <R> R query(java.time.temporal.TemporalQuery<R> query) { throw new RuntimeException("Stub!"); }

/**
 * Adjusts the specified temporal object to have the same date and time as this object.
 * <p>
 * This returns a temporal object of the same observable type as the input
 * with the date and time changed to be the same as this.
 * <p>
 * The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}
 * twice, passing {@link ChronoField#EPOCH_DAY} and
 * {@link ChronoField#NANO_OF_DAY} as the fields.
 * <p>
 * In most cases, it is clearer to reverse the calling pattern by using
 * {@link Temporal#with(TemporalAdjuster)}:
 * <pre>
 *   // these two lines are equivalent, but the second approach is recommended
 *   temporal = thisLocalDateTime.adjustInto(temporal);
 *   temporal = temporal.with(thisLocalDateTime);
 * </pre>
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param temporal  the target object to be adjusted, not null
 * @return the adjusted object, not null
 * @throws DateTimeException if unable to make the adjustment
 * @throws ArithmeticException if numeric overflow occurs
 */

public default java.time.temporal.Temporal adjustInto(java.time.temporal.Temporal temporal) { throw new RuntimeException("Stub!"); }

/**
 * Formats this date-time using the specified formatter.
 * <p>
 * This date-time will be passed to the formatter to produce a string.
 * <p>
 * The default implementation must behave as follows:
 * <pre>
 *  return formatter.format(this);
 * </pre>
 *
 * @param formatter  the formatter to use, not null
 * @return the formatted date-time string, not null
 * @throws DateTimeException if an error occurs during printing
 */

public default java.lang.String format(java.time.format.DateTimeFormatter formatter) { throw new RuntimeException("Stub!"); }

/**
 * Combines this time with a time-zone to create a {@code ChronoZonedDateTime}.
 * <p>
 * This returns a {@code ChronoZonedDateTime} formed from this date-time at the
 * specified time-zone. The result will match this date-time as closely as possible.
 * Time-zone rules, such as daylight savings, mean that not every local date-time
 * is valid for the specified zone, thus the local date-time may be adjusted.
 * <p>
 * The local date-time is resolved to a single instant on the time-line.
 * This is achieved by finding a valid offset from UTC/Greenwich for the local
 * date-time as defined by the {@link ZoneRules rules} of the zone ID.
 *<p>
 * In most cases, there is only one valid offset for a local date-time.
 * In the case of an overlap, where clocks are set back, there are two valid offsets.
 * This method uses the earlier offset typically corresponding to "summer".
 * <p>
 * In the case of a gap, where clocks jump forward, there is no valid offset.
 * Instead, the local date-time is adjusted to be later by the length of the gap.
 * For a typical one hour daylight savings change, the local date-time will be
 * moved one hour later into the offset typically corresponding to "summer".
 * <p>
 * To obtain the later offset during an overlap, call
 * {@link ChronoZonedDateTime#withLaterOffsetAtOverlap()} on the result of this method.
 *
 * @param zone  the time-zone to use, not null
 * @return the zoned date-time formed from this date-time, not null
 */

public java.time.chrono.ChronoZonedDateTime<D> atZone(java.time.ZoneId zone);

/**
 * Converts this date-time to an {@code Instant}.
 * <p>
 * This combines this local date-time and the specified offset to form
 * an {@code Instant}.
 * <p>
 * This default implementation calculates from the epoch-day of the date and the
 * second-of-day of the time.
 *
 * @param offset  the offset to use for the conversion, not null
 * @return an {@code Instant} representing the same instant, not null
 */

public default java.time.Instant toInstant(java.time.ZoneOffset offset) { throw new RuntimeException("Stub!"); }

/**
 * Converts this date-time to the number of seconds from the epoch
 * of 1970-01-01T00:00:00Z.
 * <p>
 * This combines this local date-time and the specified offset to calculate the
 * epoch-second value, which is the number of elapsed seconds from 1970-01-01T00:00:00Z.
 * Instants on the time-line after the epoch are positive, earlier are negative.
 * <p>
 * This default implementation calculates from the epoch-day of the date and the
 * second-of-day of the time.
 *
 * @param offset  the offset to use for the conversion, not null
 * @return the number of seconds from the epoch of 1970-01-01T00:00:00Z
 */

public default long toEpochSecond(java.time.ZoneOffset offset) { throw new RuntimeException("Stub!"); }

/**
 * Compares this date-time to another date-time, including the chronology.
 * <p>
 * The comparison is based first on the underlying time-line date-time, then
 * on the chronology.
 * It is "consistent with equals", as defined by {@link Comparable}.
 * <p>
 * For example, the following is the comparator order:
 * <ol>
 * <li>{@code 2012-12-03T12:00 (ISO)}</li>
 * <li>{@code 2012-12-04T12:00 (ISO)}</li>
 * <li>{@code 2555-12-04T12:00 (ThaiBuddhist)}</li>
 * <li>{@code 2012-12-05T12:00 (ISO)}</li>
 * </ol>
 * Values #2 and #3 represent the same date-time on the time-line.
 * When two values represent the same date-time, the chronology ID is compared to distinguish them.
 * This step is needed to make the ordering "consistent with equals".
 * <p>
 * If all the date-time objects being compared are in the same chronology, then the
 * additional chronology stage is not required and only the local date-time is used.
 * <p>
 * This default implementation performs the comparison defined above.
 *
 * @param other  the other date-time to compare to, not null
 * @return the comparator value, negative if less, positive if greater
 */

public default int compareTo(java.time.chrono.ChronoLocalDateTime<?> other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this date-time is after the specified date-time ignoring the chronology.
 * <p>
 * This method differs from the comparison in {@link #compareTo} in that it
 * only compares the underlying date-time and not the chronology.
 * This allows dates in different calendar systems to be compared based
 * on the time-line position.
 * <p>
 * This default implementation performs the comparison based on the epoch-day
 * and nano-of-day.
 *
 * @param other  the other date-time to compare to, not null
 * @return true if this is after the specified date-time
 */

public default boolean isAfter(java.time.chrono.ChronoLocalDateTime<?> other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this date-time is before the specified date-time ignoring the chronology.
 * <p>
 * This method differs from the comparison in {@link #compareTo} in that it
 * only compares the underlying date-time and not the chronology.
 * This allows dates in different calendar systems to be compared based
 * on the time-line position.
 * <p>
 * This default implementation performs the comparison based on the epoch-day
 * and nano-of-day.
 *
 * @param other  the other date-time to compare to, not null
 * @return true if this is before the specified date-time
 */

public default boolean isBefore(java.time.chrono.ChronoLocalDateTime<?> other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this date-time is equal to the specified date-time ignoring the chronology.
 * <p>
 * This method differs from the comparison in {@link #compareTo} in that it
 * only compares the underlying date and time and not the chronology.
 * This allows date-times in different calendar systems to be compared based
 * on the time-line position.
 * <p>
 * This default implementation performs the comparison based on the epoch-day
 * and nano-of-day.
 *
 * @param other  the other date-time to compare to, not null
 * @return true if the underlying date-time is equal to the specified date-time on the timeline
 */

public default boolean isEqual(java.time.chrono.ChronoLocalDateTime<?> other) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this date-time is equal to another date-time, including the chronology.
 * <p>
 * Compares this date-time with another ensuring that the date-time and chronology are the same.
 *
 * @param obj  the object to check, null returns false
 * @return true if this is equal to the other date
 */

public boolean equals(java.lang.Object obj);

/**
 * A hash code for this date-time.
 *
 * @return a suitable hash code
 */

public int hashCode();

/**
 * Outputs this date-time as a {@code String}.
 * <p>
 * The output will include the full local date-time.
 *
 * @return a string representation of this date-time, not null
 */

public java.lang.String toString();
}

