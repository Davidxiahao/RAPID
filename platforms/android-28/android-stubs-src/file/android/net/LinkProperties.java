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

import java.util.List;
import java.net.InetAddress;
import java.util.Collection;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Describes the properties of a network link.
 *
 * A link represents a connection to a network.
 * It may have multiple addresses and multiple gateways,
 * multiple dns servers but only one http proxy and one
 * network interface.
 *
 * Note that this is just a holder of data.  Modifying it
 * does not affect live networks.
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class LinkProperties implements android.os.Parcelable {

/**
 * @hide
 */

LinkProperties() { throw new RuntimeException("Stub!"); }

/**
 * Gets the interface name for this link.  May be {@code null} if not set.
 *
 * @return The interface name set for this link or {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getInterfaceName() { throw new RuntimeException("Stub!"); }

/**
 * Returns all the {@link LinkAddress} on this link.  Typically a link will have
 * one IPv4 address and one or more IPv6 addresses.
 *
 * @return An unmodifiable {@link List} of {@link LinkAddress} for this link.
 */

public java.util.List<android.net.LinkAddress> getLinkAddresses() { throw new RuntimeException("Stub!"); }

/**
 * Returns all the {@link InetAddress} for DNS servers on this link.
 *
 * @return An umodifiable {@link List} of {@link InetAddress} for DNS servers on
 *         this link.
 */

public java.util.List<java.net.InetAddress> getDnsServers() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether private DNS is currently in use on this network. When
 * private DNS is in use, applications must not send unencrypted DNS
 * queries as doing so could reveal private user information. Furthermore,
 * if private DNS is in use and {@link #getPrivateDnsServerName} is not
 * {@code null}, DNS queries must be sent to the specified DNS server.
 *
 * @return {@code true} if private DNS is in use, {@code false} otherwise.
 */

public boolean isPrivateDnsActive() { throw new RuntimeException("Stub!"); }

/**
 * Returns the private DNS server name that is in use. If not {@code null},
 * private DNS is in strict mode. In this mode, applications should ensure
 * that all DNS queries are encrypted and sent to this hostname and that
 * queries are only sent if the hostname's certificate is valid. If
 * {@code null} and {@link #isPrivateDnsActive} is {@code true}, private
 * DNS is in opportunistic mode, and applications should ensure that DNS
 * queries are encrypted and sent to a DNS server returned by
 * {@link #getDnsServers}. System DNS will handle each of these cases
 * correctly, but applications implementing their own DNS lookups must make
 * sure to follow these requirements.
 *
 * @return The private DNS server name.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getPrivateDnsServerName() { throw new RuntimeException("Stub!"); }

/**
 * Get the DNS domains search path set for this link.
 *
 * @return A {@link String} containing the comma separated domains to search when resolving
 *         host names on this link.
 */

public java.lang.String getDomains() { throw new RuntimeException("Stub!"); }

/**
 * Returns all the {@link RouteInfo} set on this link.
 *
 * @return An unmodifiable {@link List} of {@link RouteInfo} for this link.
 */

public java.util.List<android.net.RouteInfo> getRoutes() { throw new RuntimeException("Stub!"); }

/**
 * Gets the recommended {@link ProxyInfo} (or {@code null}) set on this link.
 *
 * @return The {@link ProxyInfo} set on this link
 */

public android.net.ProxyInfo getHttpProxy() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface.
 */

public static final android.os.Parcelable.Creator<android.net.LinkProperties> CREATOR;
static { CREATOR = null; }
}

