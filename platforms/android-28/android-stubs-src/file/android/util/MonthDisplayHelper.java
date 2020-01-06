/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.util;

import java.util.Calendar;

/**
 * Helps answer common questions that come up when displaying a month in a
 * 6 row calendar grid format.
 *
 * Not thread safe.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MonthDisplayHelper {

/**
 * @param year The year.
 * @param month The month.
 * @param weekStartDay What day of the week the week should start.
 */

public MonthDisplayHelper(int year, int month, int weekStartDay) { throw new RuntimeException("Stub!"); }

public MonthDisplayHelper(int year, int month) { throw new RuntimeException("Stub!"); }

public int getYear() { throw new RuntimeException("Stub!"); }

public int getMonth() { throw new RuntimeException("Stub!"); }

public int getWeekStartDay() { throw new RuntimeException("Stub!"); }

/**
 * @return The first day of the month using a constants such as
 *   {@link java.util.Calendar#SUNDAY}.
 */

public int getFirstDayOfMonth() { throw new RuntimeException("Stub!"); }

/**
 * @return The number of days in the month.
 */

public int getNumberOfDaysInMonth() { throw new RuntimeException("Stub!"); }

/**
 * @return The offset from displaying everything starting on the very first
 *   box.  For example, if the calendar is set to display the first day of
 *   the week as Sunday, and the month starts on a Wednesday, the offset is 3.
 */

public int getOffset() { throw new RuntimeException("Stub!"); }

/**
 * @param row Which row (0-5).
 * @return the digits of the month to display in one
 * of the 6 rows of a calendar month display.
 */

public int[] getDigitsForRow(int row) { throw new RuntimeException("Stub!"); }

/**
 * @param row The row, 0-5, starting from the top.
 * @param column The column, 0-6, starting from the left.
 * @return The day at a particular row, column
 */

public int getDayAt(int row, int column) { throw new RuntimeException("Stub!"); }

/**
 * @return Which row day is in.
 */

public int getRowOf(int day) { throw new RuntimeException("Stub!"); }

/**
 * @return Which column day is in.
 */

public int getColumnOf(int day) { throw new RuntimeException("Stub!"); }

/**
 * Decrement the month.
 */

public void previousMonth() { throw new RuntimeException("Stub!"); }

/**
 * Increment the month.
 */

public void nextMonth() { throw new RuntimeException("Stub!"); }

/**
 * @return Whether the row and column fall within the month.
 */

public boolean isWithinCurrentMonth(int row, int column) { throw new RuntimeException("Stub!"); }
}

