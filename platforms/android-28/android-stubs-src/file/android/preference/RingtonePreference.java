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

import android.provider.Settings.System;
import android.media.RingtoneManager;
import android.content.Intent;
import android.net.Uri;

/**
 * A {@link Preference} that allows the user to choose a ringtone from those on the device.
 * The chosen ringtone's URI will be persisted as a string.
 * <p>
 * If the user chooses the "Default" item, the saved string will be one of
 * {@link System#DEFAULT_RINGTONE_URI},
 * {@link System#DEFAULT_NOTIFICATION_URI}, or
 * {@link System#DEFAULT_ALARM_ALERT_URI}. If the user chooses the "Silent"
 * item, the saved string will be an empty string.
 *
 * @attr ref android.R.styleable#RingtonePreference_ringtoneType
 * @attr ref android.R.styleable#RingtonePreference_showDefault
 * @attr ref android.R.styleable#RingtonePreference_showSilent
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RingtonePreference extends android.preference.Preference implements android.preference.PreferenceManager.OnActivityResultListener {

public RingtonePreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public RingtonePreference(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public RingtonePreference(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public RingtonePreference(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Returns the sound type(s) that are shown in the picker.
 *
 * @return The sound type(s) that are shown in the picker.
 * @see #setRingtoneType(int)
 */

public int getRingtoneType() { throw new RuntimeException("Stub!"); }

/**
 * Sets the sound type(s) that are shown in the picker.
 *
 * @param type The sound type(s) that are shown in the picker.
 * @see RingtoneManager#EXTRA_RINGTONE_TYPE
 */

public void setRingtoneType(int type) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether to a show an item for the default sound/ringtone.
 *
 * @return Whether to show an item for the default sound/ringtone.
 */

public boolean getShowDefault() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether to show an item for the default sound/ringtone. The default
 * to use will be deduced from the sound type(s) being shown.
 *
 * @param showDefault Whether to show the default or not.
 * @see RingtoneManager#EXTRA_RINGTONE_SHOW_DEFAULT
 */

public void setShowDefault(boolean showDefault) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether to a show an item for 'Silent'.
 *
 * @return Whether to show an item for 'Silent'.
 */

public boolean getShowSilent() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether to show an item for 'Silent'.
 *
 * @param showSilent Whether to show 'Silent'.
 * @see RingtoneManager#EXTRA_RINGTONE_SHOW_SILENT
 */

public void setShowSilent(boolean showSilent) { throw new RuntimeException("Stub!"); }

protected void onClick() { throw new RuntimeException("Stub!"); }

/**
 * Prepares the intent to launch the ringtone picker. This can be modified
 * to adjust the parameters of the ringtone picker.
 *
 * @param ringtonePickerIntent The ringtone picker intent that can be
 *            modified by putting extras.
 */

protected void onPrepareRingtonePickerIntent(android.content.Intent ringtonePickerIntent) { throw new RuntimeException("Stub!"); }

/**
 * Called when a ringtone is chosen.
 * <p>
 * By default, this saves the ringtone URI to the persistent storage as a
 * string.
 *
 * @param ringtoneUri The chosen ringtone's {@link Uri}. Can be null.
 */

protected void onSaveRingtone(android.net.Uri ringtoneUri) { throw new RuntimeException("Stub!"); }

/**
 * Called when the chooser is about to be shown and the current ringtone
 * should be marked. Can return null to not mark any ringtone.
 * <p>
 * By default, this restores the previous ringtone URI from the persistent
 * storage.
 *
 * @return The ringtone to be marked as the current ringtone.
 */

protected android.net.Uri onRestoreRingtone() { throw new RuntimeException("Stub!"); }

protected java.lang.Object onGetDefaultValue(android.content.res.TypedArray a, int index) { throw new RuntimeException("Stub!"); }

protected void onSetInitialValue(boolean restorePersistedValue, java.lang.Object defaultValueObj) { throw new RuntimeException("Stub!"); }

protected void onAttachedToHierarchy(android.preference.PreferenceManager preferenceManager) { throw new RuntimeException("Stub!"); }

public boolean onActivityResult(int requestCode, int resultCode, android.content.Intent data) { throw new RuntimeException("Stub!"); }
}

