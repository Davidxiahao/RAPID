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


package android.media;

import android.app.Activity;
import android.database.Cursor;
import android.Manifest;
import android.net.Uri;
import android.content.Context;
import android.provider.MediaStore;
import java.io.File;
import android.provider.Settings.System;
import android.provider.Settings;
import android.content.ContentResolver;
import java.io.IOException;
import android.os.Environment;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * RingtoneManager provides access to ringtones, notification, and other types
 * of sounds. It manages querying the different media providers and combines the
 * results into a single cursor. It also provides a {@link Ringtone} for each
 * ringtone. We generically call these sounds ringtones, however the
 * {@link #TYPE_RINGTONE} refers to the type of sounds that are suitable for the
 * phone ringer.
 * <p>
 * To show a ringtone picker to the user, use the
 * {@link #ACTION_RINGTONE_PICKER} intent to launch the picker as a subactivity.
 *
 * @see Ringtone
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RingtoneManager {

/**
 * Constructs a RingtoneManager. This constructor is recommended as its
 * constructed instance manages cursor(s).
 *
 * @param activity The activity used to get a managed cursor.
 */

public RingtoneManager(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a RingtoneManager. The instance constructed by this
 * constructor will not manage the cursor(s), so the client should handle
 * this itself.
 *
 * @param context The context to used to get a cursor.
 */

public RingtoneManager(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Sets which type(s) of ringtones will be listed by this.
 *
 * @param type The type(s), one or more of {@link #TYPE_RINGTONE},
 *            {@link #TYPE_NOTIFICATION}, {@link #TYPE_ALARM},
 *            {@link #TYPE_ALL}.
 * @see #EXTRA_RINGTONE_TYPE
 */

public void setType(int type) { throw new RuntimeException("Stub!"); }

/**
 * Infers the volume stream type based on what type of ringtones this
 * manager is returning.
 *
 * @return The stream type.
 */

public int inferStreamType() { throw new RuntimeException("Stub!"); }

/**
 * Whether retrieving another {@link Ringtone} will stop playing the
 * previously retrieved {@link Ringtone}.
 * <p>
 * If this is false, make sure to {@link Ringtone#stop()} any previous
 * ringtones to free resources.
 *
 * @param stopPreviousRingtone If true, the previously retrieved
 *            {@link Ringtone} will be stopped.
 */

public void setStopPreviousRingtone(boolean stopPreviousRingtone) { throw new RuntimeException("Stub!"); }

/**
 * @see #setStopPreviousRingtone(boolean)
 */

public boolean getStopPreviousRingtone() { throw new RuntimeException("Stub!"); }

/**
 * Stops playing the last {@link Ringtone} retrieved from this.
 */

public void stopPreviousRingtone() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether DRM ringtones will be included.
 *
 * @return Whether DRM ringtones will be included.
 * @see #setIncludeDrm(boolean)
 * Obsolete - always returns false
 * @deprecated DRM ringtones are no longer supported
 */

@Deprecated public boolean getIncludeDrm() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether to include DRM ringtones.
 *
 * @param includeDrm Whether to include DRM ringtones.
 * Obsolete - no longer has any effect
 * @deprecated DRM ringtones are no longer supported
 */

@Deprecated public void setIncludeDrm(boolean includeDrm) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Cursor} of all the ringtones available. The returned
 * cursor will be the same cursor returned each time this method is called,
 * so do not {@link Cursor#close()} the cursor. The cursor can be
 * {@link Cursor#deactivate()} safely.
 * <p>
 * If {@link RingtoneManager#RingtoneManager(Activity)} was not used, the
 * caller should manage the returned cursor through its activity's life
 * cycle to prevent leaking the cursor.
 * <p>
 * Note that the list of ringtones available will differ depending on whether the caller
 * has the {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} permission.
 *
 * @return A {@link Cursor} of all the ringtones available.
 * @see #ID_COLUMN_INDEX
 * @see #TITLE_COLUMN_INDEX
 * @see #URI_COLUMN_INDEX
 */

public android.database.Cursor getCursor() { throw new RuntimeException("Stub!"); }

/**
 * Gets a {@link Ringtone} for the ringtone at the given position in the
 * {@link Cursor}.
 *
 * @param position The position (in the {@link Cursor}) of the ringtone.
 * @return A {@link Ringtone} pointing to the ringtone.
 */

public android.media.Ringtone getRingtone(int position) { throw new RuntimeException("Stub!"); }

/**
 * Gets a {@link Uri} for the ringtone at the given position in the {@link Cursor}.
 *
 * @param position The position (in the {@link Cursor}) of the ringtone.
 * @return A {@link Uri} pointing to the ringtone.
 */

public android.net.Uri getRingtoneUri(int position) { throw new RuntimeException("Stub!"); }

/**
 * Gets the position of a {@link Uri} within this {@link RingtoneManager}.
 *
 * @param ringtoneUri The {@link Uri} to retreive the position of.
 * @return The position of the {@link Uri}, or -1 if it cannot be found.
 */

public int getRingtonePosition(android.net.Uri ringtoneUri) { throw new RuntimeException("Stub!"); }

/**
 * Returns a valid ringtone URI. No guarantees on which it returns. If it
 * cannot find one, returns null. If it can only find one on external storage and the caller
 * doesn't have the {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} permission,
 * returns null.
 *
 * @param context The context to use for querying.
 * @return A ringtone URI, or null if one cannot be found.
 */

public static android.net.Uri getValidRingtoneUri(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Ringtone} for a given sound URI.
 * <p>
 * If the given URI cannot be opened for any reason, this method will
 * attempt to fallback on another sound. If it cannot find any, it will
 * return null.
 *
 * @param context A context used to query.
 * @param ringtoneUri The {@link Uri} of a sound or ringtone.
 * @return A {@link Ringtone} for the given URI, or null.
 */

public static android.media.Ringtone getRingtone(android.content.Context context, android.net.Uri ringtoneUri) { throw new RuntimeException("Stub!"); }

/**
 * Gets the current default sound's {@link Uri}. This will give the actual
 * sound {@link Uri}, instead of using this, most clients can use
 * {@link System#DEFAULT_RINGTONE_URI}.
 *
 * @param context A context used for querying.
 * @param type The type whose default sound should be returned. One of
 *            {@link #TYPE_RINGTONE}, {@link #TYPE_NOTIFICATION}, or
 *            {@link #TYPE_ALARM}.
 * @return A {@link Uri} pointing to the default sound for the sound type.
 * @see #setActualDefaultRingtoneUri(Context, int, Uri)
 */

public static android.net.Uri getActualDefaultRingtoneUri(android.content.Context context, int type) { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link Uri} of the default sound for a given sound type.
 *
 * @param context A context used for querying.
 * @param type The type whose default sound should be set. One of
 *            {@link #TYPE_RINGTONE}, {@link #TYPE_NOTIFICATION}, or
 *            {@link #TYPE_ALARM}.
 * @param ringtoneUri A {@link Uri} pointing to the default sound to set.
 * @see #getActualDefaultRingtoneUri(Context, int)
 */

public static void setActualDefaultRingtoneUri(android.content.Context context, int type, android.net.Uri ringtoneUri) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the given {@link Uri} is one of the default ringtones.
 *
 * @param ringtoneUri The ringtone {@link Uri} to be checked.
 * @return Whether the {@link Uri} is a default.
 */

public static boolean isDefault(android.net.Uri ringtoneUri) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of a default {@link Uri}.
 *
 * @param defaultRingtoneUri The default {@link Uri}. For example,
 *            {@link System#DEFAULT_RINGTONE_URI},
 *            {@link System#DEFAULT_NOTIFICATION_URI}, or
 *            {@link System#DEFAULT_ALARM_ALERT_URI}.
 * @return The type of the defaultRingtoneUri, or -1.
 */

public static int getDefaultType(android.net.Uri defaultRingtoneUri) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link Uri} for the default ringtone of a particular type.
 * Rather than returning the actual ringtone's sound {@link Uri}, this will
 * return the symbolic {@link Uri} which will resolved to the actual sound
 * when played.
 *
 * @param type The ringtone type whose default should be returned.
 * @return The {@link Uri} of the default ringtone for the given type.
 */

public static android.net.Uri getDefaultUri(int type) { throw new RuntimeException("Stub!"); }

/**
 * Activity Action: Shows a ringtone picker.
 * <p>
 * Input: {@link #EXTRA_RINGTONE_EXISTING_URI},
 * {@link #EXTRA_RINGTONE_SHOW_DEFAULT},
 * {@link #EXTRA_RINGTONE_SHOW_SILENT}, {@link #EXTRA_RINGTONE_TYPE},
 * {@link #EXTRA_RINGTONE_DEFAULT_URI}, {@link #EXTRA_RINGTONE_TITLE},
 * <p>
 * Output: {@link #EXTRA_RINGTONE_PICKED_URI}.
 */

public static final java.lang.String ACTION_RINGTONE_PICKER = "android.intent.action.RINGTONE_PICKER";

/**
 * Given to the ringtone picker as a {@link Uri}. The {@link Uri} of the
 * ringtone to play when the user attempts to preview the "Default"
 * ringtone. This can be one of {@link System#DEFAULT_RINGTONE_URI},
 * {@link System#DEFAULT_NOTIFICATION_URI}, or
 * {@link System#DEFAULT_ALARM_ALERT_URI} to have the "Default" point to
 * the current sound for the given default sound type. If you are showing a
 * ringtone picker for some other type of sound, you are free to provide any
 * {@link Uri} here.
 */

public static final java.lang.String EXTRA_RINGTONE_DEFAULT_URI = "android.intent.extra.ringtone.DEFAULT_URI";

/**
 * Given to the ringtone picker as a {@link Uri}. The {@link Uri} of the
 * current ringtone, which will be used to show a checkmark next to the item
 * for this {@link Uri}. If showing an item for "Default" (@see
 * {@link #EXTRA_RINGTONE_SHOW_DEFAULT}), this can also be one of
 * {@link System#DEFAULT_RINGTONE_URI},
 * {@link System#DEFAULT_NOTIFICATION_URI}, or
 * {@link System#DEFAULT_ALARM_ALERT_URI} to have the "Default" item
 * checked.
 *
 * @see #ACTION_RINGTONE_PICKER
 */

public static final java.lang.String EXTRA_RINGTONE_EXISTING_URI = "android.intent.extra.ringtone.EXISTING_URI";

/**
 * Given to the ringtone picker as a boolean. Whether to include DRM ringtones.
 * @deprecated DRM ringtones are no longer supported
 */

@Deprecated public static final java.lang.String EXTRA_RINGTONE_INCLUDE_DRM = "android.intent.extra.ringtone.INCLUDE_DRM";

/**
 * Returned from the ringtone picker as a {@link Uri}.
 * <p>
 * It will be one of:
 * <li> the picked ringtone,
 * <li> a {@link Uri} that equals {@link System#DEFAULT_RINGTONE_URI},
 * {@link System#DEFAULT_NOTIFICATION_URI}, or
 * {@link System#DEFAULT_ALARM_ALERT_URI} if the default was chosen,
 * <li> null if the "Silent" item was picked.
 *
 * @see #ACTION_RINGTONE_PICKER
 */

public static final java.lang.String EXTRA_RINGTONE_PICKED_URI = "android.intent.extra.ringtone.PICKED_URI";

/**
 * Given to the ringtone picker as a boolean. Whether to show an item for
 * "Default".
 *
 * @see #ACTION_RINGTONE_PICKER
 */

public static final java.lang.String EXTRA_RINGTONE_SHOW_DEFAULT = "android.intent.extra.ringtone.SHOW_DEFAULT";

/**
 * Given to the ringtone picker as a boolean. Whether to show an item for
 * "Silent". If the "Silent" item is picked,
 * {@link #EXTRA_RINGTONE_PICKED_URI} will be null.
 *
 * @see #ACTION_RINGTONE_PICKER
 */

public static final java.lang.String EXTRA_RINGTONE_SHOW_SILENT = "android.intent.extra.ringtone.SHOW_SILENT";

/**
 * Given to the ringtone picker as a {@link CharSequence}. The title to
 * show for the ringtone picker. This has a default value that is suitable
 * in most cases.
 */

public static final java.lang.String EXTRA_RINGTONE_TITLE = "android.intent.extra.ringtone.TITLE";

/**
 * Given to the ringtone picker as an int. Specifies which ringtone type(s) should be
 * shown in the picker. One or more of {@link #TYPE_RINGTONE},
 * {@link #TYPE_NOTIFICATION}, {@link #TYPE_ALARM}, or {@link #TYPE_ALL}
 * (bitwise-ored together).
 */

public static final java.lang.String EXTRA_RINGTONE_TYPE = "android.intent.extra.ringtone.TYPE";

/**
 * The column index (in the cursor returned by {@link #getCursor()} for the
 * row ID.
 */

public static final int ID_COLUMN_INDEX = 0; // 0x0

/**
 * The column index (in the cursor returned by {@link #getCursor()} for the
 * title.
 */

public static final int TITLE_COLUMN_INDEX = 1; // 0x1

/**
 * Type that refers to sounds that are used for the alarm.
 */

public static final int TYPE_ALARM = 4; // 0x4

/**
 * All types of sounds.
 */

public static final int TYPE_ALL = 7; // 0x7

/**
 * Type that refers to sounds that are used for notifications.
 */

public static final int TYPE_NOTIFICATION = 2; // 0x2

/**
 * Type that refers to sounds that are used for the phone ringer.
 */

public static final int TYPE_RINGTONE = 1; // 0x1

/**
 * The column index (in the cursor returned by {@link #getCursor()} for the
 * media provider's URI.
 */

public static final int URI_COLUMN_INDEX = 2; // 0x2
}

