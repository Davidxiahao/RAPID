/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2010, Oracle and/or its affiliates. All rights reserved.
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


package java.sql;


/**
 * <P>A thin wrapper around a millisecond value that allows
 * JDBC to identify this as an SQL <code>DATE</code> value.  A
 * milliseconds value represents the number of milliseconds that
 * have passed since January 1, 1970 00:00:00.000 GMT.
 * <p>
 * To conform with the definition of SQL <code>DATE</code>, the
 * millisecond values wrapped by a <code>java.sql.Date</code> instance
 * must be 'normalized' by setting the
 * hours, minutes, seconds, and milliseconds to zero in the particular
 * time zone with which the instance is associated.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Date extends java.util.Date {

/**
 * Constructs a <code>Date</code> object initialized with the given
 * year, month, and day.
 * <P>
 * The result is undefined if a given argument is out of bounds.
 *
 * @param year the year minus 1900; must be 0 to 8099. (Note that
 *        8099 is 9999 minus 1900.)
 * @param month 0 to 11
 * @param day 1 to 31
 * @deprecated instead use the constructor <code>Date(long date)</code>
 */

@Deprecated public Date(int year, int month, int day) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a <code>Date</code> object using the given milliseconds
 * time value.  If the given milliseconds value contains time
 * information, the driver will set the time components to the
 * time in the default time zone (the time zone of the Java virtual
 * machine running the application) that corresponds to zero GMT.
 *
 * @param date milliseconds since January 1, 1970, 00:00:00 GMT not
 *        to exceed the milliseconds representation for the year 8099.
 *        A negative number indicates the number of milliseconds
 *        before January 1, 1970, 00:00:00 GMT.
 */

public Date(long date) { throw new RuntimeException("Stub!"); }

/**
 * Sets an existing <code>Date</code> object
 * using the given milliseconds time value.
 * If the given milliseconds value contains time information,
 * the driver will set the time components to the
 * time in the default time zone (the time zone of the Java virtual
 * machine running the application) that corresponds to zero GMT.
 *
 * @param date milliseconds since January 1, 1970, 00:00:00 GMT not
 *        to exceed the milliseconds representation for the year 8099.
 *        A negative number indicates the number of milliseconds
 *        before January 1, 1970, 00:00:00 GMT.
 */

public void setTime(long date) { throw new RuntimeException("Stub!"); }

/**
 * Converts a string in JDBC date escape format to
 * a <code>Date</code> value.
 *
 * @param s a <code>String</code> object representing a date in
 *        in the format "yyyy-[m]m-[d]d". The leading zero for <code>mm</code>
 * and <code>dd</code> may also be omitted.
 * @return a <code>java.sql.Date</code> object representing the
 *         given date
 * @throws IllegalArgumentException if the date given is not in the
 *         JDBC date escape format (yyyy-[m]m-[d]d)
 */

public static java.sql.Date valueOf(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Formats a date in the date escape format yyyy-mm-dd.
 * <P>
 * @return a String in yyyy-mm-dd format
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL Date
 * values do not have a time component.
 *
 * @exception java.lang.IllegalArgumentException if this method is invoked
 * @see #setHours
 */

@Deprecated public int getHours() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL Date
 * values do not have a time component.
 *
 * @exception java.lang.IllegalArgumentException if this method is invoked
 * @see #setMinutes
 */

@Deprecated public int getMinutes() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL Date
 * values do not have a time component.
 *
 * @exception java.lang.IllegalArgumentException if this method is invoked
 * @see #setSeconds
 */

@Deprecated public int getSeconds() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL Date
 * values do not have a time component.
 *
 * @exception java.lang.IllegalArgumentException if this method is invoked
 * @see #getHours
 */

@Deprecated public void setHours(int i) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL Date
 * values do not have a time component.
 *
 * @exception java.lang.IllegalArgumentException if this method is invoked
 * @see #getMinutes
 */

@Deprecated public void setMinutes(int i) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is deprecated and should not be used because SQL Date
 * values do not have a time component.
 *
 * @exception java.lang.IllegalArgumentException if this method is invoked
 * @see #getSeconds
 */

@Deprecated public void setSeconds(int i) { throw new RuntimeException("Stub!"); }
}

