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


package android.widget;

import android.icu.util.Calendar;
import android.view.View;
import android.icu.util.TimeZone;

/**
 * Provides a widget for selecting a date.
 * <p>
 * When the {@link android.R.styleable#DatePicker_datePickerMode} attribute is
 * set to {@code spinner}, the date can be selected using year, month, and day
 * spinners or a {@link CalendarView}. The set of spinners and the calendar
 * view are automatically synchronized. The client can customize whether only
 * the spinners, or only the calendar view, or both to be displayed.
 * </p>
 * <p>
 * When the {@link android.R.styleable#DatePicker_datePickerMode} attribute is
 * set to {@code calendar}, the month and day can be selected using a
 * calendar-style view while the year can be selected separately using a list.
 * </p>
 * <p>
 * See the <a href="{@docRoot}guide/topics/ui/controls/pickers.html">Pickers</a>
 * guide.
 * </p>
 * <p>
 * For a dialog using this view, see {@link android.app.DatePickerDialog}.
 * </p>
 *
 * @attr ref android.R.styleable#DatePicker_startYear
 * @attr ref android.R.styleable#DatePicker_endYear
 * @attr ref android.R.styleable#DatePicker_maxDate
 * @attr ref android.R.styleable#DatePicker_minDate
 * @attr ref android.R.styleable#DatePicker_spinnersShown
 * @attr ref android.R.styleable#DatePicker_calendarViewShown
 * @attr ref android.R.styleable#DatePicker_dayOfWeekBackground
 * @attr ref android.R.styleable#DatePicker_dayOfWeekTextAppearance
 * @attr ref android.R.styleable#DatePicker_headerBackground
 * @attr ref android.R.styleable#DatePicker_headerMonthTextAppearance
 * @attr ref android.R.styleable#DatePicker_headerDayOfMonthTextAppearance
 * @attr ref android.R.styleable#DatePicker_headerYearTextAppearance
 * @attr ref android.R.styleable#DatePicker_yearListItemTextAppearance
 * @attr ref android.R.styleable#DatePicker_yearListSelectorColor
 * @attr ref android.R.styleable#DatePicker_calendarTextColor
 * @attr ref android.R.styleable#DatePicker_datePickerMode
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DatePicker extends android.widget.FrameLayout {

public DatePicker(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public DatePicker(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public DatePicker(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public DatePicker(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Initialize the state. If the provided values designate an inconsistent
 * date the values are normalized before updating the spinners.
 *
 * @param year The initial year.
 * @param monthOfYear The initial month <strong>starting from zero</strong>.
 * @param dayOfMonth The initial day of the month.
 * @param onDateChangedListener How user is notified date is changed by
 *            user, can be null.
 */

public void init(int year, int monthOfYear, int dayOfMonth, android.widget.DatePicker.OnDateChangedListener onDateChangedListener) { throw new RuntimeException("Stub!"); }

/**
 * Set the callback that indicates the date has been adjusted by the user.
 *
 * @param onDateChangedListener How user is notified date is changed by
 *            user, can be null.
 */

public void setOnDateChangedListener(android.widget.DatePicker.OnDateChangedListener onDateChangedListener) { throw new RuntimeException("Stub!"); }

/**
 * Update the current date.
 *
 * @param year The year.
 * @param month The month which is <strong>starting from zero</strong>.
 * @param dayOfMonth The day of the month.
 */

public void updateDate(int year, int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * @return The selected year.
 */

public int getYear() { throw new RuntimeException("Stub!"); }

/**
 * @return The selected month.
 */

public int getMonth() { throw new RuntimeException("Stub!"); }

/**
 * @return The selected day of month.
 */

public int getDayOfMonth() { throw new RuntimeException("Stub!"); }

/**
 * Gets the minimal date supported by this {@link DatePicker} in
 * milliseconds since January 1, 1970 00:00:00 in
 * {@link TimeZone#getDefault()} time zone.
 * <p>
 * Note: The default minimal date is 01/01/1900.
 * <p>
 *
 * @return The minimal supported date.
 */

public long getMinDate() { throw new RuntimeException("Stub!"); }

/**
 * Sets the minimal date supported by this {@link NumberPicker} in
 * milliseconds since January 1, 1970 00:00:00 in
 * {@link TimeZone#getDefault()} time zone.
 *
 * @param minDate The minimal supported date.
 */

public void setMinDate(long minDate) { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximal date supported by this {@link DatePicker} in
 * milliseconds since January 1, 1970 00:00:00 in
 * {@link TimeZone#getDefault()} time zone.
 * <p>
 * Note: The default maximal date is 12/31/2100.
 * <p>
 *
 * @return The maximal supported date.
 */

public long getMaxDate() { throw new RuntimeException("Stub!"); }

/**
 * Sets the maximal date supported by this {@link DatePicker} in
 * milliseconds since January 1, 1970 00:00:00 in
 * {@link TimeZone#getDefault()} time zone.
 *
 * @param maxDate The maximal supported date.
 */

public void setMaxDate(long maxDate) { throw new RuntimeException("Stub!"); }

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

protected void onConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Sets the first day of week.
 *
 * @param firstDayOfWeek The first day of the week conforming to the
 *            {@link CalendarView} APIs.
 * @see Calendar#SUNDAY
 * @see Calendar#MONDAY
 * @see Calendar#TUESDAY
 * @see Calendar#WEDNESDAY
 * @see Calendar#THURSDAY
 * @see Calendar#FRIDAY
 * @see Calendar#SATURDAY
 *
 * @attr ref android.R.styleable#DatePicker_firstDayOfWeek
 */

public void setFirstDayOfWeek(int firstDayOfWeek) { throw new RuntimeException("Stub!"); }

/**
 * Gets the first day of week.
 *
 * @return The first day of the week conforming to the {@link CalendarView}
 *         APIs.
 * @see Calendar#SUNDAY
 * @see Calendar#MONDAY
 * @see Calendar#TUESDAY
 * @see Calendar#WEDNESDAY
 * @see Calendar#THURSDAY
 * @see Calendar#FRIDAY
 * @see Calendar#SATURDAY
 *
 * @attr ref android.R.styleable#DatePicker_firstDayOfWeek
 */

public int getFirstDayOfWeek() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the {@link CalendarView} is shown.
 * <p>
 * <strong>Note:</strong> This method returns {@code false} when the
 * {@link android.R.styleable#DatePicker_datePickerMode} attribute is set
 * to {@code calendar}.
 *
 * @return {@code true} if the calendar view is shown
 * @see #getCalendarView()
 * @deprecated Not supported by Material-style {@code calendar} mode
 */

@Deprecated public boolean getCalendarViewShown() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link CalendarView} used by this picker.
 * <p>
 * <strong>Note:</strong> This method throws an
 * {@link UnsupportedOperationException} when the
 * {@link android.R.styleable#DatePicker_datePickerMode} attribute is set
 * to {@code calendar}.
 *
 * @return the calendar view
 * @see #getCalendarViewShown()
 * @deprecated Not supported by Material-style {@code calendar} mode
 * @throws UnsupportedOperationException if called when the picker is
 *         displayed in {@code calendar} mode
 */

@Deprecated public android.widget.CalendarView getCalendarView() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the {@link CalendarView} is shown.
 * <p>
 * <strong>Note:</strong> Calling this method has no effect when the
 * {@link android.R.styleable#DatePicker_datePickerMode} attribute is set
 * to {@code calendar}.
 *
 * @param shown {@code true} to show the calendar view, {@code false} to
 *              hide it
 * @deprecated Not supported by Material-style {@code calendar} mode
 */

@Deprecated public void setCalendarViewShown(boolean shown) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the spinners are shown.
 * <p>
 * <strong>Note:</strong> his method returns {@code false} when the
 * {@link android.R.styleable#DatePicker_datePickerMode} attribute is set
 * to {@code calendar}.
 *
 * @return {@code true} if the spinners are shown
 * @deprecated Not supported by Material-style {@code calendar} mode
 */

@Deprecated public boolean getSpinnersShown() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the spinners are shown.
 * <p>
 * Calling this method has no effect when the
 * {@link android.R.styleable#DatePicker_datePickerMode} attribute is set
 * to {@code calendar}.
 *
 * @param shown {@code true} to show the spinners, {@code false} to hide
 *              them
 * @deprecated Not supported by Material-style {@code calendar} mode
 */

@Deprecated public void setSpinnersShown(boolean shown) { throw new RuntimeException("Stub!"); }

protected void dispatchRestoreInstanceState(android.util.SparseArray<android.os.Parcelable> container) { throw new RuntimeException("Stub!"); }

protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

public void dispatchProvideAutofillStructure(android.view.ViewStructure structure, int flags) { throw new RuntimeException("Stub!"); }

public void autofill(android.view.autofill.AutofillValue value) { throw new RuntimeException("Stub!"); }

/**
 * @return Value is {@link android.view.View#AUTOFILL_TYPE_NONE}, {@link android.view.View#AUTOFILL_TYPE_TEXT}, {@link android.view.View#AUTOFILL_TYPE_TOGGLE}, {@link android.view.View#AUTOFILL_TYPE_LIST}, or {@link android.view.View#AUTOFILL_TYPE_DATE}
 */

public int getAutofillType() { throw new RuntimeException("Stub!"); }

public android.view.autofill.AutofillValue getAutofillValue() { throw new RuntimeException("Stub!"); }
/**
 * The callback used to indicate the user changed the date.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDateChangedListener {

/**
 * Called upon a date change.
 *
 * @param view The view associated with this listener.
 * @param year The year that was set.
 * @param monthOfYear The month that was set (0-11) for compatibility
 *            with {@link java.util.Calendar}.
 * @param dayOfMonth The day of the month that was set.
 */

public void onDateChanged(android.widget.DatePicker view, int year, int monthOfYear, int dayOfMonth);
}

}

