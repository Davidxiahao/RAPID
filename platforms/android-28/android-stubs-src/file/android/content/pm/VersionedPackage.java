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

package android.content.pm;


/**
 * Encapsulates a package and its version code.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class VersionedPackage implements android.os.Parcelable {

/**
 * Creates a new instance. Use {@link PackageManager#VERSION_CODE_HIGHEST}
 * to refer to the highest version code of this package.
 * @param packageName The package name.
 * This value must never be {@code null}.
 * @param versionCode The version code.

 * Value is PackageManager.VERSION_CODE_HIGHEST or greater
 */

public VersionedPackage(@androidx.annotation.RecentlyNonNull java.lang.String packageName, int versionCode) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new instance. Use {@link PackageManager#VERSION_CODE_HIGHEST}
 * to refer to the highest version code of this package.
 * @param packageName The package name.
 * This value must never be {@code null}.
 * @param versionCode The version code.

 * Value is PackageManager.VERSION_CODE_HIGHEST or greater
 */

public VersionedPackage(@androidx.annotation.RecentlyNonNull java.lang.String packageName, long versionCode) { throw new RuntimeException("Stub!"); }

/**
 * Gets the package name.
 *
 * @return The package name.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@link #getLongVersionCode()} instead.

 * @return Value is PackageManager.VERSION_CODE_HIGHEST or greater
 */

@Deprecated public int getVersionCode() { throw new RuntimeException("Stub!"); }

/**
 * Gets the version code.
 *
 * @return The version code.

 * Value is PackageManager.VERSION_CODE_HIGHEST or greater
 */

public long getLongVersionCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.VersionedPackage> CREATOR;
static { CREATOR = null; }
}

