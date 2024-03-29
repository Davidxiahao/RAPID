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

import android.widget.Switch;
import android.content.Context;

/**
 * A {@link Preference} that provides a two-state toggleable option.
 * <p>
 * This preference will store a boolean into the SharedPreferences.
 *
 * @attr ref android.R.styleable#SwitchPreference_summaryOff
 * @attr ref android.R.styleable#SwitchPreference_summaryOn
 * @attr ref android.R.styleable#SwitchPreference_switchTextOff
 * @attr ref android.R.styleable#SwitchPreference_switchTextOn
 * @attr ref android.R.styleable#SwitchPreference_disableDependentsState
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SwitchPreference extends android.preference.TwoStatePreference {

/**
 * Construct a new SwitchPreference with the given style options.
 *
 * @param context The Context that will style this preference
 * @param attrs Style attributes that differ from the default
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 * @param defStyleRes A resource identifier of a style resource that
 *        supplies default values for the view, used only if
 *        defStyleAttr is 0 or can not be found in the theme. Can be 0
 *        to not look for defaults.
 */

public SwitchPreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Construct a new SwitchPreference with the given style options.
 *
 * @param context The Context that will style this preference
 * @param attrs Style attributes that differ from the default
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 */

public SwitchPreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Construct a new SwitchPreference with the given style options.
 *
 * @param context The Context that will style this preference
 * @param attrs Style attributes that differ from the default
 */

public SwitchPreference(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Construct a new SwitchPreference with default style options.
 *
 * @param context The Context that will style this preference
 */

public SwitchPreference(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

protected void onBindView(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Set the text displayed on the switch widget in the on state.
 * This should be a very short string; one word if possible.
 *
 * @param onText Text to display in the on state
 */

public void setSwitchTextOn(java.lang.CharSequence onText) { throw new RuntimeException("Stub!"); }

/**
 * Set the text displayed on the switch widget in the off state.
 * This should be a very short string; one word if possible.
 *
 * @param offText Text to display in the off state
 */

public void setSwitchTextOff(java.lang.CharSequence offText) { throw new RuntimeException("Stub!"); }

/**
 * Set the text displayed on the switch widget in the on state.
 * This should be a very short string; one word if possible.
 *
 * @param resId The text as a string resource ID
 */

public void setSwitchTextOn(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set the text displayed on the switch widget in the off state.
 * This should be a very short string; one word if possible.
 *
 * @param resId The text as a string resource ID
 */

public void setSwitchTextOff(int resId) { throw new RuntimeException("Stub!"); }

/**
 * @return The text that will be displayed on the switch widget in the on state
 */

public java.lang.CharSequence getSwitchTextOn() { throw new RuntimeException("Stub!"); }

/**
 * @return The text that will be displayed on the switch widget in the off state
 */

public java.lang.CharSequence getSwitchTextOff() { throw new RuntimeException("Stub!"); }
}

