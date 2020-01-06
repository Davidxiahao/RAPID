/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.service.notification;

import android.app.Notification;
import android.os.UserHandle;

/**
 * Class encapsulating a Notification. Sent by the NotificationManagerService to clients including
 * the status bar and any {@link android.service.notification.NotificationListenerService}s.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StatusBarNotification implements android.os.Parcelable {

/**
 * @deprecated Non-system apps should not need to create StatusBarNotifications.
 */

@Deprecated public StatusBarNotification(java.lang.String pkg, java.lang.String opPkg, int id, java.lang.String tag, int uid, int initialPid, int score, android.app.Notification notification, android.os.UserHandle user, long postTime) { throw new RuntimeException("Stub!"); }

public StatusBarNotification(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this notification is part of a group.
 */

public boolean isGroup() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public android.service.notification.StatusBarNotification clone() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Convenience method to check the notification's flags for
 * {@link Notification#FLAG_ONGOING_EVENT}.
 */

public boolean isOngoing() { throw new RuntimeException("Stub!"); }

/** Convenience method to check the notification's flags for
 * either {@link Notification#FLAG_ONGOING_EVENT} or
 * {@link Notification#FLAG_NO_CLEAR}.
 */

public boolean isClearable() { throw new RuntimeException("Stub!"); }

/**
 * Returns a userid for whom this notification is intended.
 *
 * @deprecated Use {@link #getUser()} instead.
 */

@Deprecated public int getUserId() { throw new RuntimeException("Stub!"); }

/** The package of the app that posted the notification. */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/** The id supplied to {@link android.app.NotificationManager#notify(int,Notification)}. */

public int getId() { throw new RuntimeException("Stub!"); }

/** The tag supplied to {@link android.app.NotificationManager#notify(int,Notification)},
 * or null if no tag was specified. */

public java.lang.String getTag() { throw new RuntimeException("Stub!"); }

/** The {@link android.app.Notification} supplied to
 * {@link android.app.NotificationManager#notify(int,Notification)}. */

public android.app.Notification getNotification() { throw new RuntimeException("Stub!"); }

/**
 * The {@link android.os.UserHandle} for whom this notification is intended.
 */

public android.os.UserHandle getUser() { throw new RuntimeException("Stub!"); }

/** The time (in {@link System#currentTimeMillis} time) the notification was posted,
 * which may be different than {@link android.app.Notification#when}.
 */

public long getPostTime() { throw new RuntimeException("Stub!"); }

/**
 * A unique instance key for this notification record.
 */

public java.lang.String getKey() { throw new RuntimeException("Stub!"); }

/**
 * A key that indicates the group with which this message ranks.
 */

public java.lang.String getGroupKey() { throw new RuntimeException("Stub!"); }

/**
 * Sets the override group key.
 */

public void setOverrideGroupKey(java.lang.String overrideGroupKey) { throw new RuntimeException("Stub!"); }

/**
 * Returns the override group key.
 */

public java.lang.String getOverrideGroupKey() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.service.notification.StatusBarNotification> CREATOR;
static { CREATOR = null; }
}

