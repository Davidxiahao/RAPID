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

/**
 * Shared/external storage statistics for a {@link UserHandle} on a single
 * storage volume.
 *
 * @see StorageStatsManager
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ExternalStorageStats implements android.os.Parcelable {

/** {@hide} */

ExternalStorageStats() { throw new RuntimeException("Stub!"); }

/**
 * Return the total bytes used by all files in the shared/external storage
 * hosted on this volume.
 * <p>
 * This value only includes data which is isolated for each user on a
 * multiuser device. Any OBB data shared between users is not accounted in
 * this value.
 
 * Value is a non-negative number of bytes.

 * @return Value is a non-negative number of bytes.
 */

public long getTotalBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the total bytes used by all audio files in the shared/external
 * storage hosted on this volume.
 * <p>
 * This value only includes data which is isolated for each user on a
 * multiuser device. This value does not include any app files which are all
 * accounted under {@link #getAppBytes()}.
 
 * Value is a non-negative number of bytes.

 * @return Value is a non-negative number of bytes.
 */

public long getAudioBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the total bytes used by all video files in the shared/external
 * storage hosted on this volume.
 * <p>
 * This value only includes data which is isolated for each user on a
 * multiuser device. This value does not include any app files which are all
 * accounted under {@link #getAppBytes()}.
 
 * Value is a non-negative number of bytes.

 * @return Value is a non-negative number of bytes.
 */

public long getVideoBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the total bytes used by all image files in the shared/external
 * storage hosted on this volume.
 * <p>
 * This value only includes data which is isolated for each user on a
 * multiuser device. This value does not include any app files which are all
 * accounted under {@link #getAppBytes()}.
 
 * Value is a non-negative number of bytes.

 * @return Value is a non-negative number of bytes.
 */

public long getImageBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the total bytes used by app files in the shared/external storage
 * hosted on this volume.
 * <p>
 * This data is already accounted against individual apps as returned
 * through {@link StorageStats}.
 * <p>
 * This value only includes data which is isolated for each user on a
 * multiuser device.
 
 * Value is a non-negative number of bytes.

 * @return Value is a non-negative number of bytes.
 */

public long getAppBytes() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.usage.ExternalStorageStats> CREATOR;
static { CREATOR = null; }
}

