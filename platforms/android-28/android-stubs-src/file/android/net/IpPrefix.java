/*
 * Copyright (C) 2014 The Android Open Source Project
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

import java.net.InetAddress;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class represents an IP prefix, i.e., a contiguous block of IP addresses aligned on a
 * power of two boundary (also known as an "IP subnet"). A prefix is specified by two pieces of
 * information:
 *
 * <ul>
 * <li>A starting IP address (IPv4 or IPv6). This is the first IP address of the prefix.
 * <li>A prefix length. This specifies the length of the prefix by specifing the number of bits
 *     in the IP address, starting from the most significant bit in network byte order, that
 *     are constant for all addresses in the prefix.
 * </ul>
 *
 * For example, the prefix <code>192.0.2.0/24</code> covers the 256 IPv4 addresses from
 * <code>192.0.2.0</code> to <code>192.0.2.255</code>, inclusive, and the prefix
 * <code>2001:db8:1:2</code>  covers the 2^64 IPv6 addresses from <code>2001:db8:1:2::</code> to
 * <code>2001:db8:1:2:ffff:ffff:ffff:ffff</code>, inclusive.
 *
 * Objects of this class are immutable.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class IpPrefix implements android.os.Parcelable {

/**
 * Constructs a new IpPrefix from a string such as "192.0.2.1/24" or "2001:db8::1/64".
 * Silently truncates the address to the prefix length, so for example {@code 192.0.2.1/24}
 * is silently converted to {@code 192.0.2.0/24}.
 *
 * @param prefix the prefix to parse
 *
 * @hide
 */

IpPrefix(java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/**
 * Compares this {@code IpPrefix} object against the specified object in {@code obj}. Two
 * objects are equal if they have the same startAddress and prefixLength.
 *
 * @param obj the object to be tested for equality.
 * @return {@code true} if both objects are equal, {@code false} otherwise.
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Gets the hashcode of the represented IP prefix.
 *
 * @return the appropriate hashcode value.
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the first IP address in the prefix. Modifying the returned object does not
 * change this object's contents.
 *
 * @return the address in the form of a byte array.
 */

public java.net.InetAddress getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the IP address bytes in network order (the highest order byte is the zeroth
 * element). Modifying the returned array does not change this object's contents.
 *
 * @return the address in the form of a byte array.
 */

public byte[] getRawAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the prefix length of this {@code IpPrefix}.
 *
 * @return the prefix length.
 */

public int getPrefixLength() { throw new RuntimeException("Stub!"); }

/**
 * Determines whether the prefix contains the specified address.
 *
 * @param address An {@link InetAddress} to test.
 * @return {@code true} if the prefix covers the given address.
 */

public boolean contains(java.net.InetAddress address) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this {@code IpPrefix}.
 *
 * @return a string such as {@code "192.0.2.0/24"} or {@code "2001:db8:1:2::/64"}.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface.
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface.
 */

public static final android.os.Parcelable.Creator<android.net.IpPrefix> CREATOR;
static { CREATOR = null; }
}

