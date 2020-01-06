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


package android.app;

import android.widget.DatePicker;
import java.util.Calendar;

/**
 * A simple dialog containing an {@link android.widget.DatePicker}.
 * <p>
 * See the <a href="{@docRoot}guide/topics/ui/controls/pickers.html">Pickers</a>
 * guide.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DatePickerDialog extends android.app.AlertDialog implements android.content.DialogInterface.OnClickListener, android.widget.DatePicker.OnDateChangedListener {

/**
 * Creates a new date picker dialog for the current date using the parent
 * context's default date picker dialog theme.
 *
 * @param context the parent context

 * This value must never be {@code null}.
 */

public DatePickerDialog(@androidx.annotation.RecentlyNonNull android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new date picker dialog for the current date.
 *
 * @param context the parent context
 * This value must never be {@code null}.
 * @param themeResId the resource ID of the theme against which to inflate
 *                   this dialog, or {@code 0} to use the parent
 *                   {@code context}'s default alert dialog theme
 */

public DatePickerDialog(@androidx.annotation.RecentlyNonNull android.content.Context context, int themeResId) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new date picker dialog for the specified date using the parent
 * context's default date picker dialog theme.
 *
 * @param context the parent context
 * This value must never be {@code null}.
 * @param listener the listener to call when the user sets the date
 * This value may be {@code null}.
 * @param year the initially selected year
 * @param month the initially selected month (0-11 for compatibility with
 *              {@link Calendar#MONTH})
 * @param dayOfMonth the initially selected day of month (1-31, depending
 *                   on month)
 */

public DatePickerDialog(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNullable android.app.DatePickerDialog.OnDateSetListener listener, int year, int month, int dayOfMonth) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new date picker dialog for the specified date.
 *
 * @param context the parent context
 * This value must never be {@code null}.
 * @param themeResId the resource ID of the theme against which to inflate
 *                   this dialog, or {@code 0} to use the parent
 *                   {@code context}'s default alert dialog theme
 * @param listener the listener to call when the user sets the date
 * This value may be {@code null}.
 * @param year the initially selected year
 * @param monthOfYear the initially selected month of the year (0-11 for
 *                    compatibility with {@link Calendar#MONTH})
 * @param dayOfMonth the initially selected day of month (1-31, depending
 *                   on month)
 */

public DatePickerDialog(@androidx.annotation.RecentlyNonNull android.content.Context context, int themeResId, @androidx.annotation.RecentlyNullable android.app.DatePickerDialog.OnDateSetListener listener, int year, int monthOfYear, int dayOfMonth) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @param view This value must never be {@code null}.
 */

public void onDateChanged(@androidx.annotation.RecentlyNonNull android.widget.DatePicker view, int year, int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to call when the user sets the date.
 *
 * @param listener the listener to call when the user sets the date

 * This value may be {@code null}.
 */

public void setOnDateSetListener(@androidx.annotation.RecentlyNullable android.app.DatePickerDialog.OnDateSetListener listener) { throw new RuntimeException("Stub!"); }

/**
 * @param dialog This value must never be {@code null}.
 */

public void onClick(@androidx.annotation.RecentlyNonNull android.content.DialogInterface dialog, int which) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link DatePicker} contained in this dialog.
 *
 * @return the date picker

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.widget.DatePicker getDatePicker() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current date.
 *
 * @param year the year
 * @param month the month (0-11 for compatibility with
 *              {@link Calendar#MONTH})
 * @param dayOfMonth the day of month (1-31, depending on month)
 */

public void updateDate(int year, int month, int dayOfMonth) { throw new RuntimeException("Stub!"); }

public android.os.Bundle onSaveInstanceState() { throw new RuntimeException("Stub!"); }

public void onRestoreInstanceState(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }
/**
 * The listener used to indicate the user has finished selecting a date.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDateSetListener {

/**
 * @param view the picker associated with the dialog
 * @param year the selected year
 * @param month the selected month (0-11 for compatibility with
 *              {@link Calendar#MONTH})
 * @param dayOfMonth th selected day of the month (1-31, depending on
 *                   month)
 */

public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth);
}

}

