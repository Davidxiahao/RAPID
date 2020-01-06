/*
 * Copyright (C) 2016 The Android Open Source Project
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

import android.content.Intent;
import android.content.Context;

/**
 * A representation of settings that apply to a collection of similarly themed notifications.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NotificationChannel implements android.os.Parcelable {

/**
 * Creates a notification channel.
 *
 * @param id The id of the channel. Must be unique per package. The value may be truncated if
 *           it is too long.
 * @param name The user visible name of the channel. You can rename this channel when the system
 *             locale changes by listening for the {@link Intent#ACTION_LOCALE_CHANGED}
 *             broadcast. The recommended maximum length is 40 characters; the value may be
 *             truncated if it is too long.
 * @param importance The importance of the channel. This controls how interruptive notifications
 *                   posted to this channel are.

 * Value is {@link android.app.NotificationManager#IMPORTANCE_UNSPECIFIED}, {@link android.app.NotificationManager#IMPORTANCE_NONE}, {@link android.app.NotificationManager#IMPORTANCE_MIN}, {@link android.app.NotificationManager#IMPORTANCE_LOW}, {@link android.app.NotificationManager#IMPORTANCE_DEFAULT}, or {@link android.app.NotificationManager#IMPORTANCE_HIGH}
 */

public NotificationChannel(java.lang.String id, java.lang.CharSequence name, int importance) { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Sets the user visible name of this channel.
 *
 * <p>The recommended maximum length is 40 characters; the value may be truncated if it is too
 * long.
 */

public void setName(java.lang.CharSequence name) { throw new RuntimeException("Stub!"); }

/**
 * Sets the user visible description of this channel.
 *
 * <p>The recommended maximum length is 300 characters; the value may be truncated if it is too
 * long.
 */

public void setDescription(java.lang.String description) { throw new RuntimeException("Stub!"); }

/**
 * Sets what group this channel belongs to.
 *
 * Group information is only used for presentation, not for behavior.
 *
 * Only modifiable before the channel is submitted to
 * {@link NotificationManager#createNotificationChannel(NotificationChannel)}, unless the
 * channel is not currently part of a group.
 *
 * @param groupId the id of a group created by
 * {@link NotificationManager#createNotificationChannelGroup(NotificationChannelGroup)}.
 */

public void setGroup(java.lang.String groupId) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether notifications posted to this channel can appear as application icon badges
 * in a Launcher.
 *
 * Only modifiable before the channel is submitted to
 * {@link NotificationManager#createNotificationChannel(NotificationChannel)}.
 *
 * @param showBadge true if badges should be allowed to be shown.
 */

public void setShowBadge(boolean showBadge) { throw new RuntimeException("Stub!"); }

/**
 * Sets the sound that should be played for notifications posted to this channel and its
 * audio attributes. Notification channels with an {@link #getImportance() importance} of at
 * least {@link NotificationManager#IMPORTANCE_DEFAULT} should have a sound.
 *
 * Only modifiable before the channel is submitted to
 * {@link NotificationManager#createNotificationChannel(NotificationChannel)}.
 */

public void setSound(android.net.Uri sound, android.media.AudioAttributes audioAttributes) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether notifications posted to this channel should display notification lights,
 * on devices that support that feature.
 *
 * Only modifiable before the channel is submitted to
 * {@link NotificationManager#createNotificationChannel(NotificationChannel)}.
 */

public void enableLights(boolean lights) { throw new RuntimeException("Stub!"); }

/**
 * Sets the notification light color for notifications posted to this channel, if lights are
 * {@link #enableLights(boolean) enabled} on this channel and the device supports that feature.
 *
 * Only modifiable before the channel is submitted to
 * {@link NotificationManager#createNotificationChannel(NotificationChannel)}.
 */

public void setLightColor(int argb) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether notification posted to this channel should vibrate. The vibration pattern can
 * be set with {@link #setVibrationPattern(long[])}.
 *
 * Only modifiable before the channel is submitted to
 * {@link NotificationManager#createNotificationChannel(NotificationChannel)}.
 */

public void enableVibration(boolean vibration) { throw new RuntimeException("Stub!"); }

/**
 * Sets the vibration pattern for notifications posted to this channel. If the provided
 * pattern is valid (non-null, non-empty), will {@link #enableVibration(boolean)} enable
 * vibration} as well. Otherwise, vibration will be disabled.
 *
 * Only modifiable before the channel is submitted to
 * {@link NotificationManager#createNotificationChannel(NotificationChannel)}.
 */

public void setVibrationPattern(long[] vibrationPattern) { throw new RuntimeException("Stub!"); }

/**
 * Sets the level of interruption of this notification channel.
 *
 * Only modifiable before the channel is submitted to
 * {@link NotificationManager#createNotificationChannel(NotificationChannel)}.
 *
 * @param importance the amount the user should be interrupted by
 *            notifications from this channel.

 * Value is {@link android.app.NotificationManager#IMPORTANCE_UNSPECIFIED}, {@link android.app.NotificationManager#IMPORTANCE_NONE}, {@link android.app.NotificationManager#IMPORTANCE_MIN}, {@link android.app.NotificationManager#IMPORTANCE_LOW}, {@link android.app.NotificationManager#IMPORTANCE_DEFAULT}, or {@link android.app.NotificationManager#IMPORTANCE_HIGH}
 */

public void setImportance(int importance) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether or not notifications posted to this channel can interrupt the user in
 * {@link android.app.NotificationManager.Policy#INTERRUPTION_FILTER_PRIORITY} mode.
 *
 * Only modifiable by the system and notification ranker.
 */

public void setBypassDnd(boolean bypassDnd) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether notifications posted to this channel appear on the lockscreen or not, and if so,
 * whether they appear in a redacted form. See e.g. {@link Notification#VISIBILITY_SECRET}.
 *
 * Only modifiable by the system and notification ranker.
 */

public void setLockscreenVisibility(int lockscreenVisibility) { throw new RuntimeException("Stub!"); }

/**
 * Returns the id of this channel.
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the user visible name of this channel.
 */

public java.lang.CharSequence getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the user visible description of this channel.
 */

public java.lang.String getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns the user specified importance e.g.&nbsp;{@link NotificationManager#IMPORTANCE_LOW} for
 * notifications posted to this channel. Note: This value might be >
 * {@link NotificationManager#IMPORTANCE_NONE}, but notifications posted to this channel will
 * not be shown to the user if the parent {@link NotificationChannelGroup} or app is blocked.
 * See {@link NotificationChannelGroup#isBlocked()} and
 * {@link NotificationManager#areNotificationsEnabled()}.
 */

public int getImportance() { throw new RuntimeException("Stub!"); }

/**
 * Whether or not notifications posted to this channel can bypass the Do Not Disturb
 * {@link NotificationManager#INTERRUPTION_FILTER_PRIORITY} mode.
 */

public boolean canBypassDnd() { throw new RuntimeException("Stub!"); }

/**
 * Returns the notification sound for this channel.
 */

public android.net.Uri getSound() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio attributes for sound played by notifications posted to this channel.
 */

public android.media.AudioAttributes getAudioAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether notifications posted to this channel trigger notification lights.
 */

public boolean shouldShowLights() { throw new RuntimeException("Stub!"); }

/**
 * Returns the notification light color for notifications posted to this channel. Irrelevant
 * unless {@link #shouldShowLights()}.
 */

public int getLightColor() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether notifications posted to this channel always vibrate.
 */

public boolean shouldVibrate() { throw new RuntimeException("Stub!"); }

/**
 * Returns the vibration pattern for notifications posted to this channel. Will be ignored if
 * vibration is not enabled ({@link #shouldVibrate()}.
 */

public long[] getVibrationPattern() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not notifications posted to this channel are shown on the lockscreen in
 * full or redacted form.
 */

public int getLockscreenVisibility() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether notifications posted to this channel can appear as badges in a Launcher
 * application.
 *
 * Note that badging may be disabled for other reasons.
 */

public boolean canShowBadge() { throw new RuntimeException("Stub!"); }

/**
 * Returns what group this channel belongs to.
 *
 * This is used only for visually grouping channels in the UI.
 */

public java.lang.String getGroup() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.NotificationChannel> CREATOR;
static { CREATOR = null; }

/**
 * The id of the default channel for an app. This id is reserved by the system. All
 * notifications posted from apps targeting {@link android.os.Build.VERSION_CODES#N_MR1} or
 * earlier without a notification channel specified are posted to this channel.
 */

public static final java.lang.String DEFAULT_CHANNEL_ID = "miscellaneous";
}

