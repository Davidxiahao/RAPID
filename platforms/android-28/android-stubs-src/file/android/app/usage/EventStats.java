/**
 * Copyright (C) 2018 The Android Open Source Project
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


/**
 * Contains usage statistics for an event type for a specific
 * time range.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class EventStats implements android.os.Parcelable {

public EventStats(android.app.usage.EventStats stats) { throw new RuntimeException("Stub!"); }

/**
 * Return the type of event this is usage for.  May be one of the event
 * constants in {@link UsageEvents.Event}.
 */

public int getEventType() { throw new RuntimeException("Stub!"); }

/**
 * Get the beginning of the time range this {@link android.app.usage.EventStats} represents,
 * measured in milliseconds since the epoch.
 * <p/>
 * See {@link System#currentTimeMillis()}.
 */

public long getFirstTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * Get the end of the time range this {@link android.app.usage.EventStats} represents,
 * measured in milliseconds since the epoch.
 * <p/>
 * See {@link System#currentTimeMillis()}.
 */

public long getLastTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * Get the last time this event triggered, measured in milliseconds since the epoch.
 * <p/>
 * See {@link System#currentTimeMillis()}.
 */

public long getLastEventTime() { throw new RuntimeException("Stub!"); }

/**
 * Return the number of times that this event occurred over the interval.
 */

public int getCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the total time this event was active, measured in milliseconds.
 */

public long getTotalTime() { throw new RuntimeException("Stub!"); }

/**
 * Add the statistics from the right {@link EventStats} to the left. The event type for
 * both {@link UsageStats} objects must be the same.
 * @param right The {@link EventStats} object to merge into this one.
 * @throws java.lang.IllegalArgumentException if the event types of the two
 *         {@link UsageStats} objects are different.
 */

public void add(android.app.usage.EventStats right) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.usage.EventStats> CREATOR;
static { CREATOR = null; }
}

