/**
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package android.app.usage;

import android.content.res.Configuration;

/**
 * A result returned from {@link android.app.usage.UsageStatsManager#queryEvents(long, long)}
 * from which to read {@link android.app.usage.UsageEvents.Event} objects.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UsageEvents implements android.os.Parcelable {

/**
 * Create an empty iterator.
 * {@hide}
 */

UsageEvents() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not there are more events to read using
 * {@link #getNextEvent(android.app.usage.UsageEvents.Event)}.
 *
 * @return true if there are more events, false otherwise.
 */

public boolean hasNextEvent() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the next {@link android.app.usage.UsageEvents.Event} from the collection and put the
 * resulting data into {@code eventOut}.
 *
 * @param eventOut The {@link android.app.usage.UsageEvents.Event} object that will receive the
 *                 next event data.
 * @return true if an event was available, false if there are no more events.
 */

public boolean getNextEvent(android.app.usage.UsageEvents.Event eventOut) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.usage.UsageEvents> CREATOR;
static { CREATOR = null; }
/**
 * An event representing a state change for a component.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Event {

public Event() { throw new RuntimeException("Stub!"); }

/**
 * The package name of the source of this event.
 */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * The class name of the source of this event. This may be null for
 * certain events.
 */

public java.lang.String getClassName() { throw new RuntimeException("Stub!"); }

/**
 * The time at which this event occurred, measured in milliseconds since the epoch.
 * <p/>
 * See {@link System#currentTimeMillis()}.
 */

public long getTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * The event type.
 *
 * @see #MOVE_TO_BACKGROUND
 * @see #MOVE_TO_FOREGROUND
 * @see #CONFIGURATION_CHANGE
 * @see #USER_INTERACTION
 * @see #STANDBY_BUCKET_CHANGED
 */

public int getEventType() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Configuration} for this event if the event is of type
 * {@link #CONFIGURATION_CHANGE}, otherwise it returns null.
 */

public android.content.res.Configuration getConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ID of a {@link android.content.pm.ShortcutInfo} for this event
 * if the event is of type {@link #SHORTCUT_INVOCATION}, otherwise it returns null.
 *
 * @see android.content.pm.ShortcutManager#reportShortcutUsed(String)
 */

public java.lang.String getShortcutId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the standby bucket of the app, if the event is of type
 * {@link #STANDBY_BUCKET_CHANGED}, otherwise returns 0.
 * @return the standby bucket associated with the event.
 *
 */

public int getAppStandbyBucket() { throw new RuntimeException("Stub!"); }

/**
 * An event type denoting that the device configuration has changed.
 */

public static final int CONFIGURATION_CHANGE = 5; // 0x5

/**
 * An event type denoting that the screen's keyguard has been hidden.  This typically
 * happens when the user unlocks their phone after turning it on.
 */

public static final int KEYGUARD_HIDDEN = 18; // 0x12

/**
 * An event type denoting that the screen's keyguard has been shown, whether or not
 * the screen is off.
 */

public static final int KEYGUARD_SHOWN = 17; // 0x11

/**
 * An event type denoting that a component moved to the background.
 */

public static final int MOVE_TO_BACKGROUND = 2; // 0x2

/**
 * An event type denoting that a component moved to the foreground.
 */

public static final int MOVE_TO_FOREGROUND = 1; // 0x1

/**
 * No event type.
 */

public static final int NONE = 0; // 0x0

/**
 * An event type denoting that the screen has gone in to an interactive state (turned
 * on for full user interaction, not ambient display or other non-interactive state).
 */

public static final int SCREEN_INTERACTIVE = 15; // 0xf

/**
 * An event type denoting that the screen has gone in to a non-interactive state
 * (completely turned off or turned on only in a non-interactive state like ambient
 * display).
 */

public static final int SCREEN_NON_INTERACTIVE = 16; // 0x10

/**
 * An event type denoting that an action equivalent to a ShortcutInfo is taken by the user.
 *
 * @see android.content.pm.ShortcutManager#reportShortcutUsed(String)
 */

public static final int SHORTCUT_INVOCATION = 8; // 0x8

/**
 * An event type denoting a change in App Standby Bucket. The new bucket can be
 * retrieved by calling {@link #getAppStandbyBucket()}.
 *
 * @see UsageStatsManager#getAppStandbyBucket()
 */

public static final int STANDBY_BUCKET_CHANGED = 11; // 0xb

/**
 * An event type denoting that a package was interacted with in some way by the user.
 */

public static final int USER_INTERACTION = 7; // 0x7
}

}

