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


package android.app.usage;

import android.os.UserHandle;
import android.content.Context;

/**
 * Storage statistics for a UID, package, or {@link UserHandle} on a single
 * storage volume.
 *
 * @see StorageStatsManager
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StorageStats implements android.os.Parcelable {

/** {@hide} */

StorageStats() { throw new RuntimeException("Stub!"); }

/**
 * Return the size of app. This includes {@code APK} files, optimized
 * compiler output, and unpacked native libraries.
 * <p>
 * If the primary external/shared storage is hosted on this storage device,
 * then this includes files stored under {@link Context#getObbDir()}.
 * <p>
 * Code is shared between all users on a multiuser device.
 
 * Value is a non-negative number of bytes.

 * @return Value is a non-negative number of bytes.
 */

public long getAppBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the size of all data. This includes files stored under
 * {@link Context#getDataDir()}, {@link Context#getCacheDir()},
 * {@link Context#getCodeCacheDir()}.
 * <p>
 * If the primary external/shared storage is hosted on this storage device,
 * then this includes files stored under
 * {@link Context#getExternalFilesDir(String)},
 * {@link Context#getExternalCacheDir()}, and
 * {@link Context#getExternalMediaDirs()}.
 * <p>
 * Data is isolated for each user on a multiuser device.
 
 * Value is a non-negative number of bytes.

 * @return Value is a non-negative number of bytes.
 */

public long getDataBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the size of all cached data. This includes files stored under
 * {@link Context#getCacheDir()} and {@link Context#getCodeCacheDir()}.
 * <p>
 * If the primary external/shared storage is hosted on this storage device,
 * then this includes files stored under
 * {@link Context#getExternalCacheDir()}.
 * <p>
 * Cached data is isolated for each user on a multiuser device.
 
 * Value is a non-negative number of bytes.

 * @return Value is a non-negative number of bytes.
 */

public long getCacheBytes() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.usage.StorageStats> CREATOR;
static { CREATOR = null; }
}

