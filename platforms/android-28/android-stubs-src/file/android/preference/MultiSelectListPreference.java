/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.preference;

import java.util.Set;

/**
 * A {@link Preference} that displays a list of entries as
 * a dialog.
 * <p>
 * This preference will store a set of strings into the SharedPreferences.
 * This set will contain one or more values from the
 * {@link #setEntryValues(CharSequence[])} array.
 *
 * @attr ref android.R.styleable#MultiSelectListPreference_entries
 * @attr ref android.R.styleable#MultiSelectListPreference_entryValues
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MultiSelectListPreference extends android.preference.DialogPreference {

public MultiSelectListPreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public MultiSelectListPreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public MultiSelectListPreference(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public MultiSelectListPreference(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the human-readable entries to be shown in the list. This will be
 * shown in subsequent dialogs.
 * <p>
 * Each entry must have a corresponding index in
 * {@link #setEntryValues(CharSequence[])}.
 *
 * @param entries The entries.
 * @see #setEntryValues(CharSequence[])
 */

public void setEntries(java.lang.CharSequence[] entries) { throw new RuntimeException("Stub!"); }

/**
 * @see #setEntries(CharSequence[])
 * @param entriesResId The entries array as a resource.
 */

public void setEntries(int entriesResId) { throw new RuntimeException("Stub!"); }

/**
 * The list of entries to be shown in the list in subsequent dialogs.
 *
 * @return The list as an array.
 */

public java.lang.CharSequence[] getEntries() { throw new RuntimeException("Stub!"); }

/**
 * The array to find the value to save for a preference when an entry from
 * entries is selected. If a user clicks on the second item in entries, the
 * second item in this array will be saved to the preference.
 *
 * @param entryValues The array to be used as values to save for the preference.
 */

public void setEntryValues(java.lang.CharSequence[] entryValues) { throw new RuntimeException("Stub!"); }

/**
 * @see #setEntryValues(CharSequence[])
 * @param entryValuesResId The entry values array as a resource.
 */

public void setEntryValues(int entryValuesResId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the array of values to be saved for the preference.
 *
 * @return The array of values.
 */

public java.lang.CharSequence[] getEntryValues() { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of the key. This should contain entries in
 * {@link #getEntryValues()}.
 *
 * @param values The values to set for the key.
 */

public void setValues(java.util.Set<java.lang.String> values) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the current value of the key.
 */

public java.util.Set<java.lang.String> getValues() { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of the given value (in the entry values array).
 *
 * @param value The value whose index should be returned.
 * @return The index of the value, or -1 if not found.
 */

public int findIndexOfValue(java.lang.String value) { throw new RuntimeException("Stub!"); }

protected void onPrepareDialogBuilder(android.app.AlertDialog.Builder builder) { throw new RuntimeException("Stub!"); }

protected void onDialogClosed(boolean positiveResult) { throw new RuntimeException("Stub!"); }

protected java.lang.Object onGetDefaultValue(android.content.res.TypedArray a, int index) { throw new RuntimeException("Stub!"); }

protected void onSetInitialValue(boolean restoreValue, java.lang.Object defaultValue) { throw new RuntimeException("Stub!"); }

protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }
}

