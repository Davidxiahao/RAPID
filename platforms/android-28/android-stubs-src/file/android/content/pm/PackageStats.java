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


package android.content.pm;

import android.app.usage.StorageStatsManager;

/**
 * implementation of PackageStats associated with a application package.
 *
 * @deprecated this class is an orphan that could never be obtained from a valid
 *             public API. If you need package storage statistics use the new
 *             {@link StorageStatsManager} APIs.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public class PackageStats implements android.os.Parcelable {

public PackageStats(java.lang.String pkgName) { throw new RuntimeException("Stub!"); }

public PackageStats(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

public PackageStats(android.content.pm.PackageStats pStats) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.PackageStats> CREATOR;
static { CREATOR = null; }

/** Size of cache used by the application. (e.g., /data/data/<app>/cache) */

public long cacheSize;

/** Size of the code (e.g., APK) */

public long codeSize;

/**
 * Size of the internal data size for the application. (e.g.,
 * /data/data/<app>)
 */

public long dataSize;

/**
 * Size of the external cache used by the application (i.e., on the SD
 * card). If this is a subdirectory of the data directory, this size will be
 * subtracted out of the external data size.
 */

public long externalCacheSize;

/**
 * Size of the secure container on external storage holding the
 * application's code.
 */

public long externalCodeSize;

/**
 * Size of the external data used by the application (e.g.,
 * <sdcard>/Android/data/<app>)
 */

public long externalDataSize;

/** Size of the external media size used by the application. */

public long externalMediaSize;

/** Size of the package's OBBs placed on external media. */

public long externalObbSize;

/** Name of the package to which this stats applies. */

public java.lang.String packageName;
}

