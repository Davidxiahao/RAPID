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

import android.net.ConnectivityManager.NetworkCallback;
import java.util.Set;

/**
 * Representation of the capabilities of an active network. Instances are
 * typically obtained through
 * {@link NetworkCallback#onCapabilitiesChanged(Network, NetworkCapabilities)}
 * or {@link ConnectivityManager#getNetworkCapabilities(Network)}.
 * <p>
 * This replaces the old {@link ConnectivityManager#TYPE_MOBILE} method of
 * network selection. Rather than indicate a need for Wi-Fi because an
 * application needs high bandwidth and risk obsolescence when a new, fast
 * network appears (like LTE), the application should specify it needs high
 * bandwidth. Similarly if an application needs an unmetered network for a bulk
 * transfer it can specify that rather than assuming all cellular based
 * connections are metered and all Wi-Fi based connections are not.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NetworkCapabilities implements android.os.Parcelable {

public NetworkCapabilities(android.net.NetworkCapabilities nc) { throw new RuntimeException("Stub!"); }

/**
 * Tests for the presence of a capability on this instance.
 *
 * @param capability the capabilities to be tested for.
 * Value is {@link android.net.NetworkCapabilities#NET_CAPABILITY_MMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_SUPL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_DUN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOTA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CBS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_WIFI_P2P}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_RCS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_XCAP}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_EIMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_METERED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_INTERNET}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_RESTRICTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_TRUSTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_VPN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_VALIDATED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_ROAMING}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOREGROUND}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_CONGESTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_SUSPENDED}, or android.net.NetworkCapabilities.NET_CAPABILITY_OEM_PAID
 * @return {@code true} if set on this instance.
 */

public boolean hasCapability(int capability) { throw new RuntimeException("Stub!"); }

/**
 * Tests for the presence of a transport on this instance.
 *
 * @param transportType the transport type to be tested for.
 * Value is {@link android.net.NetworkCapabilities#TRANSPORT_CELLULAR}, {@link android.net.NetworkCapabilities#TRANSPORT_WIFI}, {@link android.net.NetworkCapabilities#TRANSPORT_BLUETOOTH}, {@link android.net.NetworkCapabilities#TRANSPORT_ETHERNET}, {@link android.net.NetworkCapabilities#TRANSPORT_VPN}, {@link android.net.NetworkCapabilities#TRANSPORT_WIFI_AWARE}, or {@link android.net.NetworkCapabilities#TRANSPORT_LOWPAN}
 * @return {@code true} if set on this instance.
 */

public boolean hasTransport(int transportType) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the upstream bandwidth for this network in Kbps.  This always only refers to
 * the estimated first hop transport bandwidth.
 *
 * @return The estimated first hop upstream (device to network) bandwidth.
 */

public int getLinkUpstreamBandwidthKbps() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the downstream bandwidth for this network in Kbps.  This always only refers to
 * the estimated first hop transport bandwidth.
 *
 * @return The estimated first hop downstream (network to device) bandwidth.
 */

public int getLinkDownstreamBandwidthKbps() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.net.NetworkCapabilities> CREATOR;
static { CREATOR = null; }

/**
 * Indicates that this network was found to have a captive portal in place last time it was
 * probed.
 */

public static final int NET_CAPABILITY_CAPTIVE_PORTAL = 17; // 0x11

/**
 * Indicates this is a network that has the ability to reach the carrier's
 * CBS servers, used for carrier specific services.
 */

public static final int NET_CAPABILITY_CBS = 5; // 0x5

/**
 * Indicates this is a network that has the ability to reach the carrier's
 * DUN or tethering gateway.
 */

public static final int NET_CAPABILITY_DUN = 2; // 0x2

/**
 * Indicates this is a network that has the ability to reach a carrier's
 * Emergency IMS servers or other services, used for network signaling
 * during emergency calls.
 */

public static final int NET_CAPABILITY_EIMS = 10; // 0xa

/**
 * Indicates that this network is available for use by apps, and not a network that is being
 * kept up in the background to facilitate fast network switching.
 */

public static final int NET_CAPABILITY_FOREGROUND = 19; // 0x13

/**
 * Indicates this is a network that has the ability to reach the carrier's
 * FOTA portal, used for over the air updates.
 */

public static final int NET_CAPABILITY_FOTA = 3; // 0x3

/**
 * Indicates this is a network that has the ability to reach a carrier's
 * Initial Attach servers.
 */

public static final int NET_CAPABILITY_IA = 7; // 0x7

/**
 * Indicates this is a network that has the ability to reach the carrier's
 * IMS servers, used for network registration and signaling.
 */

public static final int NET_CAPABILITY_IMS = 4; // 0x4

/**
 * Indicates that this network should be able to reach the internet.
 */

public static final int NET_CAPABILITY_INTERNET = 12; // 0xc

/**
 * Indicates this is a network that has the ability to reach the
 * carrier's MMSC for sending and receiving MMS messages.
 */

public static final int NET_CAPABILITY_MMS = 0; // 0x0

/**
 * Indicates that this network is not congested.
 * <p>
 * When a network is congested, applications should defer network traffic
 * that can be done at a later time, such as uploading analytics.
 */

public static final int NET_CAPABILITY_NOT_CONGESTED = 20; // 0x14

/**
 * Indicates that this network is unmetered.
 */

public static final int NET_CAPABILITY_NOT_METERED = 11; // 0xb

/**
 * Indicates that this network is available for general use.  If this is not set
 * applications should not attempt to communicate on this network.  Note that this
 * is simply informative and not enforcement - enforcement is handled via other means.
 * Set by default.
 */

public static final int NET_CAPABILITY_NOT_RESTRICTED = 13; // 0xd

/**
 * Indicates that this network is not roaming.
 */

public static final int NET_CAPABILITY_NOT_ROAMING = 18; // 0x12

/**
 * Indicates that this network is not currently suspended.
 * <p>
 * When a network is suspended, the network's IP addresses and any connections
 * established on the network remain valid, but the network is temporarily unable
 * to transfer data. This can happen, for example, if a cellular network experiences
 * a temporary loss of signal, such as when driving through a tunnel, etc.
 * A network with this capability is not suspended, so is expected to be able to
 * transfer data.
 */

public static final int NET_CAPABILITY_NOT_SUSPENDED = 21; // 0x15

/**
 * Indicates that this network is not a VPN.  This capability is set by default and should be
 * explicitly cleared for VPN networks.
 */

public static final int NET_CAPABILITY_NOT_VPN = 15; // 0xf

/**
 * Indicates this is a network that has the ability to reach a carrier's
 * RCS servers, used for Rich Communication Services.
 */

public static final int NET_CAPABILITY_RCS = 8; // 0x8

/**
 * Indicates this is a network that has the ability to reach the carrier's
 * SUPL server, used to retrieve GPS information.
 */

public static final int NET_CAPABILITY_SUPL = 1; // 0x1

/**
 * Indicates that the user has indicated implicit trust of this network.  This
 * generally means it's a sim-selected carrier, a plugged in ethernet, a paired
 * BT device or a wifi the user asked to connect to.  Untrusted networks
 * are probably limited to unknown wifi AP.  Set by default.
 */

public static final int NET_CAPABILITY_TRUSTED = 14; // 0xe

/**
 * Indicates that connectivity on this network was successfully validated. For example, for a
 * network with NET_CAPABILITY_INTERNET, it means that Internet connectivity was successfully
 * detected.
 */

public static final int NET_CAPABILITY_VALIDATED = 16; // 0x10

/**
 * Indicates this is a network that has the ability to reach a Wi-Fi direct
 * peer.
 */

public static final int NET_CAPABILITY_WIFI_P2P = 6; // 0x6

/**
 * Indicates this is a network that has the ability to reach a carrier's
 * XCAP servers, used for configuration and control.
 */

public static final int NET_CAPABILITY_XCAP = 9; // 0x9

/**
 * Indicates this network uses a Bluetooth transport.
 */

public static final int TRANSPORT_BLUETOOTH = 2; // 0x2

/**
 * Indicates this network uses a Cellular transport.
 */

public static final int TRANSPORT_CELLULAR = 0; // 0x0

/**
 * Indicates this network uses an Ethernet transport.
 */

public static final int TRANSPORT_ETHERNET = 3; // 0x3

/**
 * Indicates this network uses a LoWPAN transport.
 */

public static final int TRANSPORT_LOWPAN = 6; // 0x6

/**
 * Indicates this network uses a VPN transport.
 */

public static final int TRANSPORT_VPN = 4; // 0x4

/**
 * Indicates this network uses a Wi-Fi transport.
 */

public static final int TRANSPORT_WIFI = 1; // 0x1

/**
 * Indicates this network uses a Wi-Fi Aware transport.
 */

public static final int TRANSPORT_WIFI_AWARE = 5; // 0x5
}

