/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.telephony;

import java.time.ZonedDateTime;

/**
 * Description of a billing relationship plan between a carrier and a specific
 * subscriber. This information is used to present more useful UI to users, such
 * as explaining how much mobile data they have remaining, and what will happen
 * when they run out.
 *
 * @see SubscriptionManager#setSubscriptionPlans(int, java.util.List)
 * @see SubscriptionManager#getSubscriptionPlans(int)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SubscriptionPlan implements android.os.Parcelable {

SubscriptionPlan(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Return the short title of this plan.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getTitle() { throw new RuntimeException("Stub!"); }

/**
 * Return the short summary of this plan.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getSummary() { throw new RuntimeException("Stub!"); }

/**
 * Return the usage threshold at which data access changes according to
 * {@link #getDataLimitBehavior()}.
 
 * Value is a non-negative number of bytes.

 * @return Value is a non-negative number of bytes.
 */

public long getDataLimitBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the behavior of data access when usage reaches
 * {@link #getDataLimitBytes()}.

 * @return Value is {@link android.telephony.SubscriptionPlan#LIMIT_BEHAVIOR_UNKNOWN}, {@link android.telephony.SubscriptionPlan#LIMIT_BEHAVIOR_DISABLED}, {@link android.telephony.SubscriptionPlan#LIMIT_BEHAVIOR_BILLED}, or {@link android.telephony.SubscriptionPlan#LIMIT_BEHAVIOR_THROTTLED}
 */

public int getDataLimitBehavior() { throw new RuntimeException("Stub!"); }

/**
 * Return a snapshot of currently known mobile data usage at
 * {@link #getDataUsageTime()}.
 
 * Value is a non-negative number of bytes.

 * @return Value is a non-negative number of bytes.
 */

public long getDataUsageBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the time at which {@link #getDataUsageBytes()} was valid.
 
 * Value is a non-negative timestamp in the
 *  *            {@link System#currentTimeMillis()} time base.

 * @return Value is a non-negative timestamp in the
 *  *            {@link System#currentTimeMillis()} time base.
 */

public long getDataUsageTime() { throw new RuntimeException("Stub!"); }

/**
 * Return an iterator that will return all valid data usage cycles based on
 * any recurrence rules. The iterator starts from the currently active cycle
 * and walks backwards through time.
 */

public java.util.Iterator<android.util.Range<java.time.ZonedDateTime>> cycleIterator() { throw new RuntimeException("Stub!"); }

/** Value indicating a number of bytes is unknown. */

public static final long BYTES_UNKNOWN = -1L; // 0xffffffffffffffffL

/** Value indicating a number of bytes is unlimited. */

public static final long BYTES_UNLIMITED = 9223372036854775807L; // 0x7fffffffffffffffL

public static final android.os.Parcelable.Creator<android.telephony.SubscriptionPlan> CREATOR;
static { CREATOR = null; }

/** When a resource limit is hit, the user is billed automatically. */

public static final int LIMIT_BEHAVIOR_BILLED = 1; // 0x1

/** When a resource limit is hit, access is disabled. */

public static final int LIMIT_BEHAVIOR_DISABLED = 0; // 0x0

/** When a resource limit is hit, access is throttled to a slower rate. */

public static final int LIMIT_BEHAVIOR_THROTTLED = 2; // 0x2

/** When a resource limit is hit, the behavior is unknown. */

public static final int LIMIT_BEHAVIOR_UNKNOWN = -1; // 0xffffffff

/** Value indicating a timestamp is unknown. */

public static final long TIME_UNKNOWN = -1L; // 0xffffffffffffffffL
/**
 * Builder for a {@link SubscriptionPlan}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/** {@hide} */

Builder(java.time.ZonedDateTime start, java.time.ZonedDateTime end, java.time.Period period) { throw new RuntimeException("Stub!"); }

/**
 * Start defining a {@link SubscriptionPlan} that covers a very specific
 * window of time, and never automatically recurs.
 *
 * @param start The exact time at which the plan starts.
 * @param end The exact time at which the plan ends.
 */

public static android.telephony.SubscriptionPlan.Builder createNonrecurring(java.time.ZonedDateTime start, java.time.ZonedDateTime end) { throw new RuntimeException("Stub!"); }

/**
 * Start defining a {@link SubscriptionPlan} that starts at a specific
 * time, and automatically recurs after each specific period of time,
 * repeating indefinitely.
 * <p>
 * When the given period is set to exactly one month, the plan will
 * always recur on the day of the month defined by
 * {@link ZonedDateTime#getDayOfMonth()}. When a particular month ends
 * before this day, the plan will recur on the last possible instant of
 * that month.
 *
 * @param start The exact time at which the plan starts.
 * @param period The period after which the plan automatically recurs.
 */

public static android.telephony.SubscriptionPlan.Builder createRecurring(java.time.ZonedDateTime start, java.time.Period period) { throw new RuntimeException("Stub!"); }

public android.telephony.SubscriptionPlan build() { throw new RuntimeException("Stub!"); }

/**
 * Set the short title of this plan.
 * @param title This value may be {@code null}.
 */

public android.telephony.SubscriptionPlan.Builder setTitle(@androidx.annotation.RecentlyNullable java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Set the short summary of this plan.
 * @param summary This value may be {@code null}.
 */

public android.telephony.SubscriptionPlan.Builder setSummary(@androidx.annotation.RecentlyNullable java.lang.CharSequence summary) { throw new RuntimeException("Stub!"); }

/**
 * Set the usage threshold at which data access changes.
 *
 * @param dataLimitBytes the usage threshold at which data access
 *            changes
 * Value is a non-negative number of bytes.
 * @param dataLimitBehavior the behavior of data access when usage
 *            reaches the threshold

 * Value is {@link android.telephony.SubscriptionPlan#LIMIT_BEHAVIOR_UNKNOWN}, {@link android.telephony.SubscriptionPlan#LIMIT_BEHAVIOR_DISABLED}, {@link android.telephony.SubscriptionPlan#LIMIT_BEHAVIOR_BILLED}, or {@link android.telephony.SubscriptionPlan#LIMIT_BEHAVIOR_THROTTLED}
 */

public android.telephony.SubscriptionPlan.Builder setDataLimit(long dataLimitBytes, int dataLimitBehavior) { throw new RuntimeException("Stub!"); }

/**
 * Set a snapshot of currently known mobile data usage.
 *
 * @param dataUsageBytes the currently known mobile data usage
 * Value is a non-negative number of bytes.
 * @param dataUsageTime the time at which this snapshot was valid

 * Value is a non-negative timestamp in the
 *  *           {@link System#currentTimeMillis()} time base.
 */

public android.telephony.SubscriptionPlan.Builder setDataUsage(long dataUsageBytes, long dataUsageTime) { throw new RuntimeException("Stub!"); }
}

}

