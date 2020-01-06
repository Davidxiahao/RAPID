/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.view.autofill;

import android.view.View;

/**
 * Abstracts how a {@link View} can be autofilled by an
 * {@link android.service.autofill.AutofillService}.
 *
 * <p>Each {@link AutofillValue} is associated with a {@code type}, as defined by
 * {@link View#getAutofillType()}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AutofillValue implements android.os.Parcelable {

AutofillValue(android.os.Parcel parcel) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value to autofill a text field.
 *
 * <p>See {@link View#AUTOFILL_TYPE_TEXT} for more info.</p>
 *
 * @throws IllegalStateException if the value is not a text value

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.CharSequence getTextValue() { throw new RuntimeException("Stub!"); }

/**
 * Checks is this is a text value.
 *
 * <p>See {@link View#AUTOFILL_TYPE_TEXT} for more info.</p>
 */

public boolean isText() { throw new RuntimeException("Stub!"); }

/**
 * Gets the value to autofill a toggable field.
 *
 * <p>See {@link View#AUTOFILL_TYPE_TOGGLE} for more info.</p>
 *
 * @throws IllegalStateException if the value is not a toggle value
 */

public boolean getToggleValue() { throw new RuntimeException("Stub!"); }

/**
 * Checks is this is a toggle value.
 *
 * <p>See {@link View#AUTOFILL_TYPE_TOGGLE} for more info.</p>
 */

public boolean isToggle() { throw new RuntimeException("Stub!"); }

/**
 * Gets the value to autofill a selection list field.
 *
 * <p>See {@link View#AUTOFILL_TYPE_LIST} for more info.</p>
 *
 * @throws IllegalStateException if the value is not a list value
 */

public int getListValue() { throw new RuntimeException("Stub!"); }

/**
 * Checks is this is a list value.
 *
 * <p>See {@link View#AUTOFILL_TYPE_LIST} for more info.</p>
 */

public boolean isList() { throw new RuntimeException("Stub!"); }

/**
 * Gets the value to autofill a date field.
 *
 * <p>See {@link View#AUTOFILL_TYPE_DATE} for more info.</p>
 *
 * @throws IllegalStateException if the value is not a date value
 */

public long getDateValue() { throw new RuntimeException("Stub!"); }

/**
 * Checks is this is a date value.
 *
 * <p>See {@link View#AUTOFILL_TYPE_DATE} for more info.</p>
 */

public boolean isDate() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link AutofillValue} to autofill a {@link View} representing a text field.
 *
 * <p>See {@link View#AUTOFILL_TYPE_TEXT} for more info.

 * @param value This value may be {@code null}.
 */

public static android.view.autofill.AutofillValue forText(@androidx.annotation.RecentlyNullable java.lang.CharSequence value) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link AutofillValue} to autofill a {@link View} representing a toggable
 * field.
 *
 * <p>See {@link View#AUTOFILL_TYPE_TOGGLE} for more info.
 */

public static android.view.autofill.AutofillValue forToggle(boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link AutofillValue} to autofill a {@link View} representing a selection
 * list.
 *
 * <p>See {@link View#AUTOFILL_TYPE_LIST} for more info.
 */

public static android.view.autofill.AutofillValue forList(int value) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link AutofillValue} to autofill a {@link View} representing a date.
 *
 * <p>See {@link View#AUTOFILL_TYPE_DATE} for more info.
 */

public static android.view.autofill.AutofillValue forDate(long value) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.view.autofill.AutofillValue> CREATOR;
static { CREATOR = null; }
}

