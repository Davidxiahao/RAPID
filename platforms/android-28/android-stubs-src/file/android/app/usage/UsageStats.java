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


/**
 * Contains usage statistics for an app package for a specific
 * time range.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UsageStats implements android.os.Parcelable {

public UsageStats(android.app.usage.UsageStats stats) { throw new RuntimeException("Stub!"); }

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Get the beginning of the time range this {@link android.app.usage.UsageStats} represents,
 * measured in milliseconds since the epoch.
 * <p/>
 * See {@link System#currentTimeMillis()}.
 */

public long getFirstTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * Get the end of the time range this {@link android.app.usage.UsageStats} represents,
 * measured in milliseconds since the epoch.
 * <p/>
 * See {@link System#currentTimeMillis()}.
 */

public long getLastTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * Get the last time this package was used, measured in milliseconds since the epoch.
 * <p/>
 * See {@link System#currentTimeMillis()}.
 */

public long getLastTimeUsed() { throw new RuntimeException("Stub!"); }

/**
 * Get the total time this package spent in the foreground, measured in milliseconds.
 */

public long getTotalTimeInForeground() { throw new RuntimeException("Stub!"); }

/**
 * Add the statistics from the right {@link UsageStats} to the left. The package name for
 * both {@link UsageStats} objects must be the same.
 * @param right The {@link UsageStats} object to merge into this one.
 * @throws java.lang.IllegalArgumentException if the package names of the two
 *         {@link UsageStats} objects are different.
 */

public void add(android.app.usage.UsageStats right) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.usage.UsageStats> CREATOR;
static { CREATOR = null; }
}

