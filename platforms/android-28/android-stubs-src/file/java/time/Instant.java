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
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalQuery;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.io.InvalidObjectException;

/**
 * An instantaneous point on the time-line.
 * <p>
 * This class models a single instantaneous point on the time-line.
 * This might be used to record event time-stamps in the application.
 * <p>
 * The range of an instant requires the storage of a number larger than a {@code long}.
 * To achieve this, the class stores a {@code long} representing epoch-seconds and an
 * {@code int} representing nanosecond-of-second, which will always be between 0 and 999,999,999.
 * The epoch-seconds are measured from the standard Java epoch of {@code 1970-01-01T00:00:00Z}
 * where instants after the epoch have positive values, and earlier instants have negative values.
 * For both the epoch-second and nanosecond parts, a larger value is always later on the time-line
 * than a smaller value.
 *
 * <h3>Time-scale</h3>
 * <p>
 * The length of the solar day is the standard way that humans measure time.
 * This has traditionally been subdivided into 24 hours of 60 minutes of 60 seconds,
 * forming a 86400 second day.
 * <p>
 * Modern timekeeping is based on atomic clocks which precisely define an SI second
 * relative to the transitions of a Caesium atom. The length of an SI second was defined
 * to be very close to the 86400th fraction of a day.
 * <p>
 * Unfortunately, as the Earth rotates the length of the day varies.
 * In addition, over time the average length of the day is getting longer as the Earth slows.
 * As a result, the length of a solar day in 2012 is slightly longer than 86400 SI seconds.
 * The actual length of any given day and the amount by which the Earth is slowing
 * are not predictable and can only be determined by measurement.
 * The UT1 time-scale captures the accurate length of day, but is only available some
 * time after the day has completed.
 * <p>
 * The UTC time-scale is a standard approach to bundle up all the additional fractions
 * of a second from UT1 into whole seconds, known as <i>leap-seconds</i>.
 * A leap-second may be added or removed depending on the Earth's rotational changes.
 * As such, UTC permits a day to have 86399 SI seconds or 86401 SI seconds where
 * necessary in order to keep the day aligned with the Sun.
 * <p>
 * The modern UTC time-scale was introduced in 1972, introducing the concept of whole leap-seconds.
 * Between 1958 and 1972, the definition of UTC was complex, with minor sub-second leaps and
 * alterations to the length of the notional second. As of 2012, discussions are underway
 * to change the definition of UTC again, with the potential to remove leap seconds or
 * introduce other changes.
 * <p>
 * Given the complexity of accurate timekeeping described above, this Java API defines
 * its own time-scale, the <i>Java Time-Scale</i>.
 * <p>
 * The Java Time-Scale divides each calendar day into exactly 86400
 * subdivisions, known as seconds.  These seconds may differ from the
 * SI second.  It closely matches the de facto international civil time
 * scale, the definition of which changes from time to time.
 * <p>
 * The Java Time-Scale has slightly different definitions for different
 * segments of the time-line, each based on the consensus international
 * time scale that is used as the basis for civil time. Whenever the
 * internationally-agreed time scale is modified or replaced, a new
 * segment of the Java Time-Scale must be defined for it.  Each segment
 * must meet these requirements:
 * <ul>
 * <li>the Java Time-Scale shall closely match the underlying international
 *  civil time scale;</li>
 * <li>the Java Time-Scale shall exactly match the international civil
 *  time scale at noon each day;</li>
 * <li>the Java Time-Scale shall have a precisely-defined relationship to
 *  the international civil time scale.</li>
 * </ul>
 * There are currently, as of 2013, two segments in the Java time-scale.
 * <p>
 * For the segment from 1972-11-03 (exact boundary discussed below) until
 * further notice, the consensus international time scale is UTC (with
 * leap seconds).  In this segment, the Java Time-Scale is identical to
 * <a href="http://www.cl.cam.ac.uk/~mgk25/time/utc-sls/">UTC-SLS</a>.
 * This is identical to UTC on days that do not have a leap second.
 * On days that do have a leap second, the leap second is spread equally
 * over the last 1000 seconds of the day, maintaining the appearance of
 * exactly 86400 seconds per day.
 * <p>
 * For the segment prior to 1972-11-03, extending back arbitrarily far,
 * the consensus international time scale is defined to be UT1, applied
 * proleptically, which is equivalent to the (mean) solar time on the
 * prime meridian (Greenwich). In this segment, the Java Time-Scale is
 * identical to the consensus international time scale. The exact
 * boundary between the two segments is the instant where UT1 = UTC
 * between 1972-11-03T00:00 and 1972-11-04T12:00.
 * <p>
 * Implementations of the Java time-scale using the JSR-310 API are not
 * required to provide any clock that is sub-second accurate, or that
 * progresses monotonically or smoothly. Implementations are therefore
 * not required to actually perform the UTC-SLS slew or to otherwise be
 * aware of leap seconds. JSR-310 does, however, require that
 * implementations must document the approach they use when defining a
 * clock representing the current instant.
 * See {@link Clock} for details on the available clocks.
 * <p>
 * The Java time-scale is used for all date-time classes.
 * This includes {@code Instant}, {@code LocalDate}, {@code LocalTime}, {@code OffsetDateTime},
 * {@code ZonedDateTime} and {@code Duration}.
 *
 * @implSpec
 * This class is immutable and thread-safe.
 *
 * @since 1.8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Instant implements java.time.temporal.Temporal, java.time.temporal.TemporalAdjuster, java.lang.Comparable<java.time.Instant>, java.io.Serializable {

/**
 * Constructs an instance of {@code Instant} using seconds from the epoch of
 * 1970-01-01T00:00:00Z and nanosecond fraction of second.
 *
 * @param epochSecond  the number of seconds from 1970-01-01T00:00:00Z
 * @param nanos  the nanoseconds within the second, must be positive
 */

Instant(long epochSecond, int nanos) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current instant from the system clock.
 * <p>
 * This will query the {@link Clock#systemUTC() system UTC clock} to
 * obtain the current instant.
 * <p>
 * Using this method will prevent the ability to use an alternate time-source for
 * testing because the clock is effectively hard-coded.
 *
 * @return the current instant using the system clock, not null
 */

public static java.time.Instant now() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the current instant from the specified clock.
 * <p>
 * This will query the specified clock to obtain the current time.
 * <p>
 * Using this method allows the use of an alternate clock for testing.
 * The alternate clock may be introduced using {@link Clock dependency injection}.
 *
 * @param clock  the clock to use, not null
 * @return the current instant, not null
 */

public static java.time.Instant now(java.time.Clock clock) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code Instant} using seconds from the
 * epoch of 1970-01-01T00:00:00Z.
 * <p>
 * The nanosecond field is set to zero.
 *
 * @param epochSecond  the number of seconds from 1970-01-01T00:00:00Z
 * @return an instant, not null
 * @throws DateTimeException if the instant exceeds the maximum or minimum instant
 */

public static java.time.Instant ofEpochSecond(long epochSecond) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code Instant} using seconds from the
 * epoch of 1970-01-01T00:00:00Z and nanosecond fraction of second.
 * <p>
 * This method allows an arbitrary number of nanoseconds to be passed in.
 * The factory will alter the values of the second and nanosecond in order
 * to ensure that the stored nanosecond is in the range 0 to 999,999,999.
 * For example, the following will result in the exactly the same instant:
 * <pre>
 *  Instant.ofEpochSecond(3, 1);
 *  Instant.ofEpochSecond(4, -999_999_999);
 *  Instant.ofEpochSecond(2, 1000_000_001);
 * </pre>
 *
 * @param epochSecond  the number of seconds from 1970-01-01T00:00:00Z
 * @param nanoAdjustment  the nanosecond adjustment to the number of seconds, positive or negative
 * @return an instant, not null
 * @throws DateTimeException if the instant exceeds the maximum or minimum instant
 * @throws ArithmeticException if numeric overflow occurs
 */

public static java.time.Instant ofEpochSecond(long epochSecond, long nanoAdjustment) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code Instant} using milliseconds from the
 * epoch of 1970-01-01T00:00:00Z.
 * <p>
 * The seconds and nanoseconds are extracted from the specified milliseconds.
 *
 * @param epochMilli  the number of milliseconds from 1970-01-01T00:00:00Z
 * @return an instant, not null
 * @throws DateTimeException if the instant exceeds the maximum or minimum instant
 */

public static java.time.Instant ofEpochMilli(long epochMilli) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code Instant} from a temporal object.
 * <p>
 * This obtains an instant based on the specified temporal.
 * A {@code TemporalAccessor} represents an arbitrary set of date and time information,
 * which this factory converts to an instance of {@code Instant}.
 * <p>
 * The conversion extracts the {@link ChronoField#INSTANT_SECONDS INSTANT_SECONDS}
 * and {@link ChronoField#NANO_OF_SECOND NANO_OF_SECOND} fields.
 * <p>
 * This method matches the signature of the functional interface {@link TemporalQuery}
 * allowing it to be used as a query via method reference, {@code Instant::from}.
 *
 * @param temporal  the temporal object to convert, not null
 * @return the instant, not null
 * @throws DateTimeException if unable to convert to an {@code Instant}
 */

public static java.time.Instant from(java.time.temporal.TemporalAccessor temporal) { throw new RuntimeException("Stub!"); }

/**
 * Obtains an instance of {@code Instant} from a text string such as
 * {@code 2007-12-03T10:15:30.00Z}.
 * <p>
 * The string must represent a valid instant in UTC and is parsed using
 * {@link DateTimeFormatter#ISO_INSTANT}.
 *
 * @param text  the text to parse, not null
 * @return the parsed instant, not null
 * @throws DateTimeParseException if the text cannot be parsed
 */

public static java.time.Instant parse(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified field is supported.
 * <p>
 * This checks if this instant can be queried for the specified field.
 * If false, then calling the {@link #range(TemporalField) range},
 * {@link #get(TemporalField) get} and {@link #with(TemporalField, long)}
 * methods will throw an exception.
 * <p>
 * If the field is a {@link ChronoField} then the query is implemented here.
 * The supported fields are:
 * <ul>
 * <li>{@code NANO_OF_SECOND}
 * <li>{@code MICRO_OF_SECOND}
 * <li>{@code MILLI_OF_SECOND}
 * <li>{@code INSTANT_SECONDS}
 * </ul>
 * All other {@code ChronoField} instances will return false.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.isSupportedBy(TemporalAccessor)}
 * passing {@code this} as the argument.
 * Whether the field is supported is determined by the field.
 *
 * @param field  the field to check, null returns false
 * @return true if the field is supported on this instant, false if not
 */

public boolean isSupported(java.time.temporal.TemporalField field) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the specified unit is supported.
 * <p>
 * This checks if the specified unit can be added to, or subtracted from, this date-time.
 * If false, then calling the {@link #plus(long, TemporalUnit)} and
 * {@link #minus(long, TemporalUnit) minus} methods will throw an exception.
 * <p>
 * If the unit is a {@link ChronoUnit} then the query is implemented here.
 * The supported units are:
 * <ul>
 * <li>{@code NANOS}
 * <li>{@code MICROS}
 * <li>{@code MILLIS}
 * <li>{@code SECONDS}
 * <li>{@code MINUTES}
 * <li>{@code HOURS}
 * <li>{@code HALF_DAYS}
 * <li>{@code DAYS}
 * </ul>
 * All other {@code ChronoUnit} instances will return false.
 * <p>
 * If the unit is not a {@code ChronoUnit}, then the result of this method
 * is obtained by invoking {@code TemporalUnit.isSupportedBy(Temporal)}
 * passing {@code this} as the argument.
 * Whether the unit is supported is determined by the unit.
 *
 * @param unit  the unit to check, null returns false
 * @return true if the unit can be added/subtracted, false if not
 */

public boolean isSupported(java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Gets the range of valid values for the specified field.
 * <p>
 * The range object expresses the minimum and maximum valid values for a field.
 * This instant is used to enhance the accuracy of the returned range.
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
 * Gets the value of the specified field from this instant as an {@code int}.
 * <p>
 * This queries this instant for the value of the specified field.
 * The returned value will always be within the valid range of values for the field.
 * If it is not possible to return the value, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link ChronoField} then the query is implemented here.
 * The {@link #isSupported(TemporalField) supported fields} will return valid
 * values based on this date-time, except {@code INSTANT_SECONDS} which is too
 * large to fit in an {@code int} and throws a {@code DateTimeException}.
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
 * Gets the value of the specified field from this instant as a {@code long}.
 * <p>
 * This queries this instant for the value of the specified field.
 * If it is not possible to return the value, because the field is not supported
 * or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link ChronoField} then the query is implemented here.
 * The {@link #isSupported(TemporalField) supported fields} will return valid
 * values based on this date-time.
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
 * Gets the number of seconds from the Java epoch of 1970-01-01T00:00:00Z.
 * <p>
 * The epoch second count is a simple incrementing count of seconds where
 * second 0 is 1970-01-01T00:00:00Z.
 * The nanosecond part of the day is returned by {@code getNanosOfSecond}.
 *
 * @return the seconds from the epoch of 1970-01-01T00:00:00Z
 */

public long getEpochSecond() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of nanoseconds, later along the time-line, from the start
 * of the second.
 * <p>
 * The nanosecond-of-second value measures the total number of nanoseconds from
 * the second returned by {@code getEpochSecond}.
 *
 * @return the nanoseconds within the second, always positive, never exceeds 999,999,999
 */

public int getNano() { throw new RuntimeException("Stub!"); }

/**
 * Returns an adjusted copy of this instant.
 * <p>
 * This returns an {@code Instant}, based on this one, with the instant adjusted.
 * The adjustment takes place using the specified adjuster strategy object.
 * Read the documentation of the adjuster to understand what adjustment will be made.
 * <p>
 * The result of this method is obtained by invoking the
 * {@link TemporalAdjuster#adjustInto(Temporal)} method on the
 * specified adjuster passing {@code this} as the argument.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param adjuster the adjuster to use, not null
 * @return an {@code Instant} based on {@code this} with the adjustment made, not null
 * @throws DateTimeException if the adjustment cannot be made
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.Instant with(java.time.temporal.TemporalAdjuster adjuster) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this instant with the specified field set to a new value.
 * <p>
 * This returns an {@code Instant}, based on this one, with the value
 * for the specified field changed.
 * If it is not possible to set the value, because the field is not supported or for
 * some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link ChronoField} then the adjustment is implemented here.
 * The supported fields behave as follows:
 * <ul>
 * <li>{@code NANO_OF_SECOND} -
 *  Returns an {@code Instant} with the specified nano-of-second.
 *  The epoch-second will be unchanged.
 * <li>{@code MICRO_OF_SECOND} -
 *  Returns an {@code Instant} with the nano-of-second replaced by the specified
 *  micro-of-second multiplied by 1,000. The epoch-second will be unchanged.
 * <li>{@code MILLI_OF_SECOND} -
 *  Returns an {@code Instant} with the nano-of-second replaced by the specified
 *  milli-of-second multiplied by 1,000,000. The epoch-second will be unchanged.
 * <li>{@code INSTANT_SECONDS} -
 *  Returns an {@code Instant} with the specified epoch-second.
 *  The nano-of-second will be unchanged.
 * </ul>
 * <p>
 * In all cases, if the new value is outside the valid range of values for the field
 * then a {@code DateTimeException} will be thrown.
 * <p>
 * All other {@code ChronoField} instances will throw an {@code UnsupportedTemporalTypeException}.
 * <p>
 * If the field is not a {@code ChronoField}, then the result of this method
 * is obtained by invoking {@code TemporalField.adjustInto(Temporal, long)}
 * passing {@code this} as the argument. In this case, the field determines
 * whether and how to adjust the instant.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param field  the field to set in the result, not null
 * @param newValue  the new value of the field in the result
 * @return an {@code Instant} based on {@code this} with the specified field set, not null
 * @throws DateTimeException if the field cannot be set
 * @throws UnsupportedTemporalTypeException if the field is not supported
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.Instant with(java.time.temporal.TemporalField field, long newValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this {@code Instant} truncated to the specified unit.
 * <p>
 * Truncating the instant returns a copy of the original with fields
 * smaller than the specified unit set to zero.
 * The fields are calculated on the basis of using a UTC offset as seen
 * in {@code toString}.
 * For example, truncating with the {@link ChronoUnit#MINUTES MINUTES} unit will
 * round down to the nearest minute, setting the seconds and nanoseconds to zero.
 * <p>
 * The unit must have a {@linkplain TemporalUnit#getDuration() duration}
 * that divides into the length of a standard day without remainder.
 * This includes all supplied time units on {@link ChronoUnit} and
 * {@link ChronoUnit#DAYS DAYS}. Other units throw an exception.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param unit  the unit to truncate to, not null
 * @return an {@code Instant} based on this instant with the time truncated, not null
 * @throws DateTimeException if the unit is invalid for truncation
 * @throws UnsupportedTemporalTypeException if the unit is not supported
 */

public java.time.Instant truncatedTo(java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this instant with the specified amount added.
 * <p>
 * This returns an {@code Instant}, based on this one, with the specified amount added.
 * The amount is typically {@link Duration} but may be any other type implementing
 * the {@link TemporalAmount} interface.
 * <p>
 * The calculation is delegated to the amount object by calling
 * {@link TemporalAmount#addTo(Temporal)}. The amount implementation is free
 * to implement the addition in any way it wishes, however it typically
 * calls back to {@link #plus(long, TemporalUnit)}. Consult the documentation
 * of the amount implementation to determine if it can be successfully added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param amountToAdd  the amount to add, not null
 * @return an {@code Instant} based on this instant with the addition made, not null
 * @throws DateTimeException if the addition cannot be made
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.Instant plus(java.time.temporal.TemporalAmount amountToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this instant with the specified amount added.
 * <p>
 * This returns an {@code Instant}, based on this one, with the amount
 * in terms of the unit added. If it is not possible to add the amount, because the
 * unit is not supported or for some other reason, an exception is thrown.
 * <p>
 * If the field is a {@link ChronoUnit} then the addition is implemented here.
 * The supported fields behave as follows:
 * <ul>
 * <li>{@code NANOS} -
 *  Returns a {@code Instant} with the specified number of nanoseconds added.
 *  This is equivalent to {@link #plusNanos(long)}.
 * <li>{@code MICROS} -
 *  Returns a {@code Instant} with the specified number of microseconds added.
 *  This is equivalent to {@link #plusNanos(long)} with the amount
 *  multiplied by 1,000.
 * <li>{@code MILLIS} -
 *  Returns a {@code Instant} with the specified number of milliseconds added.
 *  This is equivalent to {@link #plusNanos(long)} with the amount
 *  multiplied by 1,000,000.
 * <li>{@code SECONDS} -
 *  Returns a {@code Instant} with the specified number of seconds added.
 *  This is equivalent to {@link #plusSeconds(long)}.
 * <li>{@code MINUTES} -
 *  Returns a {@code Instant} with the specified number of minutes added.
 *  This is equivalent to {@link #plusSeconds(long)} with the amount
 *  multiplied by 60.
 * <li>{@code HOURS} -
 *  Returns a {@code Instant} with the specified number of hours added.
 *  This is equivalent to {@link #plusSeconds(long)} with the amount
 *  multiplied by 3,600.
 * <li>{@code HALF_DAYS} -
 *  Returns a {@code Instant} with the specified number of half-days added.
 *  This is equivalent to {@link #plusSeconds(long)} with the amount
 *  multiplied by 43,200 (12 hours).
 * <li>{@code DAYS} -
 *  Returns a {@code Instant} with the specified number of days added.
 *  This is equivalent to {@link #plusSeconds(long)} with the amount
 *  multiplied by 86,400 (24 hours).
 * </ul>
 * <p>
 * All other {@code ChronoUnit} instances will throw an {@code UnsupportedTemporalTypeException}.
 * <p>
 * If the field is not a {@code ChronoUnit}, then the result of this method
 * is obtained by invoking {@code TemporalUnit.addTo(Temporal, long)}
 * passing {@code this} as the argument. In this case, the unit determines
 * whether and how to perform the addition.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param amountToAdd  the amount of the unit to add to the result, may be negative
 * @param unit  the unit of the amount to add, not null
 * @return an {@code Instant} based on this instant with the specified amount added, not null
 * @throws DateTimeException if the addition cannot be made
 * @throws UnsupportedTemporalTypeException if the unit is not supported
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.Instant plus(long amountToAdd, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this instant with the specified duration in seconds added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param secondsToAdd  the seconds to add, positive or negative
 * @return an {@code Instant} based on this instant with the specified seconds added, not null
 * @throws DateTimeException if the result exceeds the maximum or minimum instant
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.Instant plusSeconds(long secondsToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this instant with the specified duration in milliseconds added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param millisToAdd  the milliseconds to add, positive or negative
 * @return an {@code Instant} based on this instant with the specified milliseconds added, not null
 * @throws DateTimeException if the result exceeds the maximum or minimum instant
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.Instant plusMillis(long millisToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this instant with the specified duration in nanoseconds added.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param nanosToAdd  the nanoseconds to add, positive or negative
 * @return an {@code Instant} based on this instant with the specified nanoseconds added, not null
 * @throws DateTimeException if the result exceeds the maximum or minimum instant
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.Instant plusNanos(long nanosToAdd) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this instant with the specified amount subtracted.
 * <p>
 * This returns an {@code Instant}, based on this one, with the specified amount subtracted.
 * The amount is typically {@link Duration} but may be any other type implementing
 * the {@link TemporalAmount} interface.
 * <p>
 * The calculation is delegated to the amount object by calling
 * {@link TemporalAmount#subtractFrom(Temporal)}. The amount implementation is free
 * to implement the subtraction in any way it wishes, however it typically
 * calls back to {@link #minus(long, TemporalUnit)}. Consult the documentation
 * of the amount implementation to determine if it can be successfully subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param amountToSubtract  the amount to subtract, not null
 * @return an {@code Instant} based on this instant with the subtraction made, not null
 * @throws DateTimeException if the subtraction cannot be made
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.Instant minus(java.time.temporal.TemporalAmount amountToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this instant with the specified amount subtracted.
 * <p>
 * This returns a {@code Instant}, based on this one, with the amount
 * in terms of the unit subtracted. If it is not possible to subtract the amount,
 * because the unit is not supported or for some other reason, an exception is thrown.
 * <p>
 * This method is equivalent to {@link #plus(long, TemporalUnit)} with the amount negated.
 * See that method for a full description of how addition, and thus subtraction, works.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param amountToSubtract  the amount of the unit to subtract from the result, may be negative
 * @param unit  the unit of the amount to subtract, not null
 * @return an {@code Instant} based on this instant with the specified amount subtracted, not null
 * @throws DateTimeException if the subtraction cannot be made
 * @throws UnsupportedTemporalTypeException if the unit is not supported
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.Instant minus(long amountToSubtract, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this instant with the specified duration in seconds subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param secondsToSubtract  the seconds to subtract, positive or negative
 * @return an {@code Instant} based on this instant with the specified seconds subtracted, not null
 * @throws DateTimeException if the result exceeds the maximum or minimum instant
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.Instant minusSeconds(long secondsToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this instant with the specified duration in milliseconds subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param millisToSubtract  the milliseconds to subtract, positive or negative
 * @return an {@code Instant} based on this instant with the specified milliseconds subtracted, not null
 * @throws DateTimeException if the result exceeds the maximum or minimum instant
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.Instant minusMillis(long millisToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this instant with the specified duration in nanoseconds subtracted.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param nanosToSubtract  the nanoseconds to subtract, positive or negative
 * @return an {@code Instant} based on this instant with the specified nanoseconds subtracted, not null
 * @throws DateTimeException if the result exceeds the maximum or minimum instant
 * @throws ArithmeticException if numeric overflow occurs
 */

public java.time.Instant minusNanos(long nanosToSubtract) { throw new RuntimeException("Stub!"); }

/**
 * Queries this instant using the specified query.
 * <p>
 * This queries this instant using the specified query strategy object.
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
 * Adjusts the specified temporal object to have this instant.
 * <p>
 * This returns a temporal object of the same observable type as the input
 * with the instant changed to be the same as this.
 * <p>
 * The adjustment is equivalent to using {@link Temporal#with(TemporalField, long)}
 * twice, passing {@link ChronoField#INSTANT_SECONDS} and
 * {@link ChronoField#NANO_OF_SECOND} as the fields.
 * <p>
 * In most cases, it is clearer to reverse the calling pattern by using
 * {@link Temporal#with(TemporalAdjuster)}:
 * <pre>
 *   // these two lines are equivalent, but the second approach is recommended
 *   temporal = thisInstant.adjustInto(temporal);
 *   temporal = temporal.with(thisInstant);
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
 * Calculates the amount of time until another instant in terms of the specified unit.
 * <p>
 * This calculates the amount of time between two {@code Instant}
 * objects in terms of a single {@code TemporalUnit}.
 * The start and end points are {@code this} and the specified instant.
 * The result will be negative if the end is before the start.
 * The calculation returns a whole number, representing the number of
 * complete units between the two instants.
 * The {@code Temporal} passed to this method is converted to a
 * {@code Instant} using {@link #from(TemporalAccessor)}.
 * For example, the amount in days between two dates can be calculated
 * using {@code startInstant.until(endInstant, SECONDS)}.
 * <p>
 * There are two equivalent ways of using this method.
 * The first is to invoke this method.
 * The second is to use {@link TemporalUnit#between(Temporal, Temporal)}:
 * <pre>
 *   // these two lines are equivalent
 *   amount = start.until(end, SECONDS);
 *   amount = SECONDS.between(start, end);
 * </pre>
 * The choice should be made based on which makes the code more readable.
 * <p>
 * The calculation is implemented in this method for {@link ChronoUnit}.
 * The units {@code NANOS}, {@code MICROS}, {@code MILLIS}, {@code SECONDS},
 * {@code MINUTES}, {@code HOURS}, {@code HALF_DAYS} and {@code DAYS}
 * are supported. Other {@code ChronoUnit} values will throw an exception.
 * <p>
 * If the unit is not a {@code ChronoUnit}, then the result of this method
 * is obtained by invoking {@code TemporalUnit.between(Temporal, Temporal)}
 * passing {@code this} as the first argument and the converted input temporal
 * as the second argument.
 * <p>
 * This instance is immutable and unaffected by this method call.
 *
 * @param endExclusive  the end date, exclusive, which is converted to an {@code Instant}, not null
 * @param unit  the unit to measure the amount in, not null
 * @return the amount of time between this instant and the end instant
 * @throws DateTimeException if the amount cannot be calculated, or the end
 *  temporal cannot be converted to an {@code Instant}
 * @throws UnsupportedTemporalTypeException if the unit is not supported
 * @throws ArithmeticException if numeric overflow occurs
 */

public long until(java.time.temporal.Temporal endExclusive, java.time.temporal.TemporalUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Combines this instant with an offset to create an {@code OffsetDateTime}.
 * <p>
 * This returns an {@code OffsetDateTime} formed from this instant at the
 * specified offset from UTC/Greenwich. An exception will be thrown if the
 * instant is too large to fit into an offset date-time.
 * <p>
 * This method is equivalent to
 * {@link OffsetDateTime#ofInstant(Instant, ZoneId) OffsetDateTime.ofInstant(this, offset)}.
 *
 * @param offset  the offset to combine with, not null
 * @return the offset date-time formed from this instant and the specified offset, not null
 * @throws DateTimeException if the result exceeds the supported range
 */

public java.time.OffsetDateTime atOffset(java.time.ZoneOffset offset) { throw new RuntimeException("Stub!"); }

/**
 * Combines this instant with a time-zone to create a {@code ZonedDateTime}.
 * <p>
 * This returns an {@code ZonedDateTime} formed from this instant at the
 * specified time-zone. An exception will be thrown if the instant is too
 * large to fit into a zoned date-time.
 * <p>
 * This method is equivalent to
 * {@link ZonedDateTime#ofInstant(Instant, ZoneId) ZonedDateTime.ofInstant(this, zone)}.
 *
 * @param zone  the zone to combine with, not null
 * @return the zoned date-time formed from this instant and the specified zone, not null
 * @throws DateTimeException if the result exceeds the supported range
 */

public java.time.ZonedDateTime atZone(java.time.ZoneId zone) { throw new RuntimeException("Stub!"); }

/**
 * Converts this instant to the number of milliseconds from the epoch
 * of 1970-01-01T00:00:00Z.
 * <p>
 * If this instant represents a point on the time-line too far in the future
 * or past to fit in a {@code long} milliseconds, then an exception is thrown.
 * <p>
 * If this instant has greater than millisecond precision, then the conversion
 * will drop any excess precision information as though the amount in nanoseconds
 * was subject to integer division by one million.
 *
 * @return the number of milliseconds since the epoch of 1970-01-01T00:00:00Z
 * @throws ArithmeticException if numeric overflow occurs
 */

public long toEpochMilli() { throw new RuntimeException("Stub!"); }

/**
 * Compares this instant to the specified instant.
 * <p>
 * The comparison is based on the time-line position of the instants.
 * It is "consistent with equals", as defined by {@link Comparable}.
 *
 * @param otherInstant  the other instant to compare to, not null
 * @return the comparator value, negative if less, positive if greater
 * @throws NullPointerException if otherInstant is null
 */

public int compareTo(java.time.Instant otherInstant) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this instant is after the specified instant.
 * <p>
 * The comparison is based on the time-line position of the instants.
 *
 * @param otherInstant  the other instant to compare to, not null
 * @return true if this instant is after the specified instant
 * @throws NullPointerException if otherInstant is null
 */

public boolean isAfter(java.time.Instant otherInstant) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this instant is before the specified instant.
 * <p>
 * The comparison is based on the time-line position of the instants.
 *
 * @param otherInstant  the other instant to compare to, not null
 * @return true if this instant is before the specified instant
 * @throws NullPointerException if otherInstant is null
 */

public boolean isBefore(java.time.Instant otherInstant) { throw new RuntimeException("Stub!"); }

/**
 * Checks if this instant is equal to the specified instant.
 * <p>
 * The comparison is based on the time-line position of the instants.
 *
 * @param otherInstant  the other instant, null returns false
 * @return true if the other instant is equal to this one
 */

public boolean equals(java.lang.Object otherInstant) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code for this instant.
 *
 * @return a suitable hash code
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * A string representation of this instant using ISO-8601 representation.
 * <p>
 * The format used is the same as {@link DateTimeFormatter#ISO_INSTANT}.
 *
 * @return an ISO-8601 representation of this instant, not null
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Constant for the 1970-01-01T00:00:00Z epoch instant.
 */

public static final java.time.Instant EPOCH;
static { EPOCH = null; }

/**
 * The maximum supported {@code Instant}, '1000000000-12-31T23:59:59.999999999Z'.
 * This could be used by an application as a "far future" instant.
 * <p>
 * This is one year later than the maximum {@code LocalDateTime}.
 * This provides sufficient values to handle the range of {@code ZoneOffset}
 * which affect the instant in addition to the local date-time.
 * The value is also chosen such that the value of the year fits in
 * an {@code int}.
 */

public static final java.time.Instant MAX;
static { MAX = null; }

/**
 * The minimum supported {@code Instant}, '-1000000000-01-01T00:00Z'.
 * This could be used by an application as a "far past" instant.
 * <p>
 * This is one year earlier than the minimum {@code LocalDateTime}.
 * This provides sufficient values to handle the range of {@code ZoneOffset}
 * which affect the instant in addition to the local date-time.
 * The value is also chosen such that the value of the year fits in
 * an {@code int}.
 */

public static final java.time.Instant MIN;
static { MIN = null; }
}

