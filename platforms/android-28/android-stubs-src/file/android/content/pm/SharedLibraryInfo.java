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
 * This class provides information for a shared library. There are
 * three types of shared libraries: builtin - non-updatable part of
 * the OS; dynamic - updatable backwards-compatible dynamically linked;
 * static - updatable non backwards-compatible emulating static linking.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SharedLibraryInfo implements android.os.Parcelable {

SharedLibraryInfo(android.os.Parcel parcel) { throw new RuntimeException("Stub!"); }

/**
 * Gets the type of this library.
 *
 * @return The library type.

 * Value is either <code>0</code> or a combination of {@link android.content.pm.SharedLibraryInfo#TYPE_BUILTIN}, {@link android.content.pm.SharedLibraryInfo#TYPE_DYNAMIC}, and {@link android.content.pm.SharedLibraryInfo#TYPE_STATIC}
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the library name an app defines in its manifest
 * to depend on the library.
 *
 * @return The name.
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getLongVersion()} instead.

 * @return Value is -1 or greater
 */

@Deprecated public int getVersion() { throw new RuntimeException("Stub!"); }

/**
 * Gets the version of the library. For {@link #TYPE_STATIC static} libraries
 * this is the declared version and for {@link #TYPE_DYNAMIC dynamic} and
 * {@link #TYPE_BUILTIN builtin} it is {@link #VERSION_UNDEFINED} as these
 * are not versioned.
 *
 * @return The version.

 * Value is -1 or greater
 */

public long getLongVersion() { throw new RuntimeException("Stub!"); }

/**
 * Gets the package that declares the library.
 *
 * @return The package declaring the library.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.VersionedPackage getDeclaringPackage() { throw new RuntimeException("Stub!"); }

/**
 * Gets the packages that depend on the library.
 *
 * @return The dependent packages.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<android.content.pm.VersionedPackage> getDependentPackages() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.SharedLibraryInfo> CREATOR;
static { CREATOR = null; }

/**
 * Shared library type: this library is a part of the OS
 * and cannot be updated or uninstalled.
 */

public static final int TYPE_BUILTIN = 0; // 0x0

/**
 * Shared library type: this library is backwards-compatible, can
 * be updated, and updates can be uninstalled. Clients link against
 * the latest version of the library.
 */

public static final int TYPE_DYNAMIC = 1; // 0x1

/**
 * Shared library type: this library is <strong>not</strong> backwards
 * -compatible, can be updated and updates can be uninstalled. Clients
 * link against a specific version of the library.
 */

public static final int TYPE_STATIC = 2; // 0x2

/**
 * Constant for referring to an undefined version.
 */

public static final int VERSION_UNDEFINED = -1; // 0xffffffff
}

