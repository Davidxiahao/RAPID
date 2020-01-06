/**
 * Copyright (c) 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.app;

import android.content.ComponentName;

/**
 * Rule instance information for zen mode.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AutomaticZenRule implements android.os.Parcelable {

/**
 * Creates an automatic zen rule.
 *
 * @param name The name of the rule.
 * @param owner The Condition Provider service that owns this rule.
 * @param conditionId A representation of the state that should cause the Condition Provider
 *                    service to apply the given interruption filter.
 * @param interruptionFilter The interruption filter defines which notifications are allowed to
 *                           interrupt the user (e.g. via sound &amp; vibration) while this rule
 *                           is active.
 * @param enabled Whether the rule is enabled.
 */

public AutomaticZenRule(java.lang.String name, android.content.ComponentName owner, android.net.Uri conditionId, int interruptionFilter, boolean enabled) { throw new RuntimeException("Stub!"); }

public AutomaticZenRule(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link ComponentName} of the condition provider service that owns this rule.
 */

public android.content.ComponentName getOwner() { throw new RuntimeException("Stub!"); }

/**
 * Returns the representation of the state that causes this rule to become active.
 */

public android.net.Uri getConditionId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the interruption filter that is applied when this rule is active.
 */

public int getInterruptionFilter() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of this rule.
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this rule is enabled.
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time this rule was created, represented as milliseconds since the epoch.
 */

public long getCreationTime() { throw new RuntimeException("Stub!"); }

/**
 * Sets the representation of the state that causes this rule to become active.
 */

public void setConditionId(android.net.Uri conditionId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the interruption filter that is applied when this rule is active.
 * @param interruptionFilter The do not disturb mode to enter when this rule is active.

 * Value is {@link android.app.NotificationManager#INTERRUPTION_FILTER_NONE}, {@link android.app.NotificationManager#INTERRUPTION_FILTER_PRIORITY}, {@link android.app.NotificationManager#INTERRUPTION_FILTER_ALARMS}, {@link android.app.NotificationManager#INTERRUPTION_FILTER_ALL}, or {@link android.app.NotificationManager#INTERRUPTION_FILTER_UNKNOWN}
 */

public void setInterruptionFilter(int interruptionFilter) { throw new RuntimeException("Stub!"); }

/**
 * Sets the name of this rule.
 */

public void setName(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Enables this rule.
 */

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.AutomaticZenRule> CREATOR;
static { CREATOR = null; }
}

