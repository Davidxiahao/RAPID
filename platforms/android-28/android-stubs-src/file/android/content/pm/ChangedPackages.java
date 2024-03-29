/**
 * Copyright (c) 2017, The Android Open Source Project
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

package android.content.pm;


/**
 * Packages that have been changed since the last time they
 * were requested.
 * @see PackageManager#getChangedPackages(int)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ChangedPackages implements android.os.Parcelable {

/**
 * @param packageNames This value must never be {@code null}.
 */

public ChangedPackages(int sequenceNumber, @androidx.annotation.RecentlyNonNull java.util.List<java.lang.String> packageNames) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the last known sequence number for these changes.
 */

public int getSequenceNumber() { throw new RuntimeException("Stub!"); }

/**
 * Returns the names of the packages that have changed.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<java.lang.String> getPackageNames() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.ChangedPackages> CREATOR;
static { CREATOR = null; }
}

