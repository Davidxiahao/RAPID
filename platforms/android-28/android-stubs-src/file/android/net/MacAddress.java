/*
 * Copyright 2017 The Android Open Source Project
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


package android.net;

import java.util.Random;

/**
 * Representation of a MAC address.
 *
 * This class only supports 48 bits long addresses and does not support 64 bits long addresses.
 * Instances of this class are immutable.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MacAddress implements android.os.Parcelable {

MacAddress(long addr) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of this address.
 *
 * @return the int constant representing the MAC address type of this MacAddress.

 * Value is android.net.MacAddress.TYPE_UNKNOWN, {@link android.net.MacAddress#TYPE_UNICAST}, {@link android.net.MacAddress#TYPE_MULTICAST}, or {@link android.net.MacAddress#TYPE_BROADCAST}
 */

public int getAddressType() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this MacAddress is a locally assigned address.
 */

public boolean isLocallyAssigned() { throw new RuntimeException("Stub!"); }

/**
 * @return a byte array representation of this MacAddress.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public byte[] toByteArray() { throw new RuntimeException("Stub!"); }

/**
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * @return a String representation of the OUI part of this MacAddress made of 3 hexadecimal
 * numbers in [0,ff] joined by ':' characters.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String toOuiString() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Creates a MacAddress from the given String representation. A valid String representation
 * for a MacAddress is a series of 6 values in the range [0,ff] printed in hexadecimal
 * and joined by ':' characters.
 *
 * @param addr a String representation of a MAC address.
 * This value must never be {@code null}.
 * @return the MacAddress corresponding to the given String representation.
 * This value will never be {@code null}.
 * @throws IllegalArgumentException if the given String is not a valid representation.
 */

@androidx.annotation.RecentlyNonNull public static android.net.MacAddress fromString(@androidx.annotation.RecentlyNonNull java.lang.String addr) { throw new RuntimeException("Stub!"); }

/**
 * Creates a MacAddress from the given byte array representation.
 * A valid byte array representation for a MacAddress is a non-null array of length 6.
 *
 * @param addr a byte array representation of a MAC address.
 * This value must never be {@code null}.
 * @return the MacAddress corresponding to the given byte array representation.
 * @throws IllegalArgumentException if the given byte array is not a valid representation.
 */

@androidx.annotation.RecentlyNonNull public static android.net.MacAddress fromBytes(@androidx.annotation.RecentlyNonNull byte[] addr) { throw new RuntimeException("Stub!"); }

/**
 * The MacAddress representing the unique broadcast MAC address.
 */

public static final android.net.MacAddress BROADCAST_ADDRESS;
static { BROADCAST_ADDRESS = null; }

public static final android.os.Parcelable.Creator<android.net.MacAddress> CREATOR;
static { CREATOR = null; }

/** Indicates a MAC address is the broadcast address. */

public static final int TYPE_BROADCAST = 3; // 0x3

/** Indicates a MAC address is a multicast address. */

public static final int TYPE_MULTICAST = 2; // 0x2

/** Indicates a MAC address is a unicast address. */

public static final int TYPE_UNICAST = 1; // 0x1
}

