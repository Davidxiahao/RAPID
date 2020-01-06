/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.os;

import java.util.UUID;

/**
 * This class is a Parcelable wrapper around {@link UUID} which is an
 * immutable representation of a 128-bit universally unique
 * identifier.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ParcelUuid implements android.os.Parcelable {

/**
 * Constructor creates a ParcelUuid instance from the
 * given {@link UUID}.
 *
 * @param uuid UUID
 */

public ParcelUuid(java.util.UUID uuid) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new ParcelUuid from a string representation of {@link UUID}.
 *
 * @param uuid
 *            the UUID string to parse.
 * @return a ParcelUuid instance.
 * @throws NullPointerException
 *             if {@code uuid} is {@code null}.
 * @throws IllegalArgumentException
 *             if {@code uuid} is not formatted correctly.
 */

public static android.os.ParcelUuid fromString(java.lang.String uuid) { throw new RuntimeException("Stub!"); }

/**
 * Get the {@link UUID} represented by the ParcelUuid.
 *
 * @return UUID contained in the ParcelUuid.
 */

public java.util.UUID getUuid() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the ParcelUuid
 * For example: 0000110B-0000-1000-8000-00805F9B34FB will be the return value.
 *
 * @return a String instance.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Compares this ParcelUuid to another object for equality. If {@code object}
 * is not {@code null}, is a ParcelUuid instance, and all bits are equal, then
 * {@code true} is returned.
 *
 * @param object
 *            the {@code Object} to compare to.
 * @return {@code true} if this ParcelUuid is equal to {@code object}
 *         or {@code false} if not.
 */

public boolean equals(java.lang.Object object) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.os.ParcelUuid> CREATOR;
static { CREATOR = null; }
}

