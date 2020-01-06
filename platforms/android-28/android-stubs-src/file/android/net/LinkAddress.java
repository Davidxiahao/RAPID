/*
 * Copyright (C) 2010 The Android Open Source Project
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
import java.net.InterfaceAddress;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Identifies an IP address on a network link.
 *
 * A {@code LinkAddress} consists of:
 * <ul>
 * <li>An IP address and prefix length (e.g., {@code 2001:db8::1/64} or {@code 192.0.2.1/24}).
 * The address must be unicast, as multicast addresses cannot be assigned to interfaces.
 * <li>Address flags: A bitmask of {@code OsConstants.IFA_F_*} values representing properties
 * of the address (e.g., {@code android.system.OsConstants.IFA_F_OPTIMISTIC}).
 * <li>Address scope: One of the {@code OsConstants.IFA_F_*} values; defines the scope in which
 * the address is unique (e.g.,
 * {@code android.system.OsConstants.RT_SCOPE_LINK} or
 * {@code android.system.OsConstants.RT_SCOPE_UNIVERSE}).
 * </ul>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LinkAddress implements android.os.Parcelable {

/**
 * Constructs a new {@code LinkAddress} from an {@code InterfaceAddress}.
 * The flags are set to zero and the scope is determined from the address.
 * @param interfaceAddress The interface address.
 * @hide
 */

LinkAddress(java.net.InterfaceAddress interfaceAddress) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this address, such as "192.0.2.1/24" or "2001:db8::1/64".
 * The string representation does not contain the flags and scope, just the address and prefix
 * length.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Compares this {@code LinkAddress} instance against {@code obj}. Two addresses are equal if
 * their address, prefix length, flags and scope are equal. Thus, for example, two addresses
 * that have the same address and prefix length are not equal if one of them is deprecated and
 * the other is not.
 *
 * @param obj the object to be tested for equality.
 * @return {@code true} if both objects are equal, {@code false} otherwise.
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hashcode for this address.
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link InetAddress} of this {@code LinkAddress}.
 */

public java.net.InetAddress getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the prefix length of this {@code LinkAddress}.
 */

public int getPrefixLength() { throw new RuntimeException("Stub!"); }

/**
 * Returns the flags of this {@code LinkAddress}.
 */

public int getFlags() { throw new RuntimeException("Stub!"); }

/**
 * Returns the scope of this {@code LinkAddress}.
 */

public int getScope() { throw new RuntimeException("Stub!"); }

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

public static final android.os.Parcelable.Creator<android.net.LinkAddress> CREATOR;
static { CREATOR = null; }
}

