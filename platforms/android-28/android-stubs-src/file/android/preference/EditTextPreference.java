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


package android.preference;

import android.widget.EditText;
import android.content.SharedPreferences;
import android.view.View;

/**
 * A {@link Preference} that allows for string
 * input.
 * <p>
 * It is a subclass of {@link DialogPreference} and shows the {@link EditText}
 * in a dialog. This {@link EditText} can be modified either programmatically
 * via {@link #getEditText()}, or through XML by setting any EditText
 * attributes on the EditTextPreference.
 * <p>
 * This preference will store a string into the SharedPreferences.
 * <p>
 * See {@link android.R.styleable#EditText EditText Attributes}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EditTextPreference extends android.preference.DialogPreference {

public EditTextPreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public EditTextPreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public EditTextPreference(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public EditTextPreference(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Saves the text to the {@link SharedPreferences}.
 *
 * @param text The text to save
 */

public void setText(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Gets the text from the {@link SharedPreferences}.
 *
 * @return The current preference value.
 */

public java.lang.String getText() { throw new RuntimeException("Stub!"); }

protected void onBindDialogView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Adds the EditText widget of this preference to the dialog's view.
 *
 * @param dialogView The dialog view.
 */

protected void onAddEditTextToDialogView(android.view.View dialogView, android.widget.EditText editText) { throw new RuntimeException("Stub!"); }

protected void onDialogClosed(boolean positiveResult) { throw new RuntimeException("Stub!"); }

protected java.lang.Object onGetDefaultValue(android.content.res.TypedArray a, int index) { throw new RuntimeException("Stub!"); }

protected void onSetInitialValue(boolean restoreValue, java.lang.Object defaultValue) { throw new RuntimeException("Stub!"); }

public boolean shouldDisableDependents() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link EditText} widget that will be shown in the dialog.
 *
 * @return The {@link EditText} widget that will be shown in the dialog.
 */

public android.widget.EditText getEditText() { throw new RuntimeException("Stub!"); }

protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }
}

