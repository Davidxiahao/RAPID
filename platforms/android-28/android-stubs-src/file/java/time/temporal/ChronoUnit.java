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

import java.time.Duration;

/**
 * A standard set of date periods units.
 * <p>
 * This set of units provide unit-based access to manipulate a date, time or date-time.
 * The standard set of units can be extended by implementing {@link TemporalUnit}.
 * <p>
 * These units are intended to be applicable in multiple calendar systems.
 * For example, most non-ISO calendar systems define units of years, months and days,
 * just with slightly different rules.
 * The documentation of each unit explains how it operates.
 *
 * @implSpec
 * This is a final, immutable and thread-safe enum.
 *
 * @since 1.8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum ChronoUnit implements java.time.temporal.TemporalUnit {
NANOS, MICROS, MILLIS, SECONDS, MINUTES, HOURS, HALF_DAYS, DAYS, WEEKS, MONTHS, YEARS, DECADES, CENTURIES, MILLENNIA, ERAS, FOREVER;

/**
 * Gets the estimated duration of this unit in the ISO calendar system.
 * <p>
 * All of the units in this class have an estimated duration.
 * Days vary due to daylight saving time, while months have different lengths.
 *
 * @return the estimated duration of this unit, not null
 */

public java.time.Duration getDuration() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the duration of the unit is an estimate.
 * <p>
 * All time units in this class are considered to be accurate, while all date
 * units in this class are considered to be estimated.
 * <p>
 * This definition ignores leap seconds, but considers that Days vary due to
 * daylight saving time and months have different lengths.
 *
 * @return true if the duration is estimated, false if accurate
 */

public boolean isDurationEstimated() { throw new RuntimeException("Stub!"); }

/**
 * Checks if this unit is a date unit.
 * <p>
 * All units from days to eras inclusive are date-based.
 * Time-based units and {@code FOREVER} return false.
 *
 * @return true if a date unit, false if a time unit
 */

public boolean isDateBased() { throw new RuntimeException("Stub!"); }

/**
 * Checks if this unit is a time unit.
 * <p>
 * All units from nanos to half-days inclusive are time-based.
 * Date-based units and {@code FOREVER} return false.
 *
 * @return true if a time unit, false if a date unit
 */

public boolean isTimeBased() { throw new RuntimeException("Stub!"); }

public boolean isSupportedBy(java.time.temporal.Temporal temporal) { throw new RuntimeException("Stub!"); }

public <R extends java.time.temporal.Temporal> R addTo(R temporal, long amount) { throw new RuntimeException("Stub!"); }

public long between(java.time.temporal.Temporal temporal1Inclusive, java.time.temporal.Temporal temporal2Exclusive) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

