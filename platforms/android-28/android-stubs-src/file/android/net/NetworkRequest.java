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

import java.util.Set;

/**
 * Defines a request for a network, made through {@link NetworkRequest.Builder} and used
 * to request a network via {@link ConnectivityManager#requestNetwork} or listen for changes
 * via {@link ConnectivityManager#registerNetworkCallback}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NetworkRequest implements android.os.Parcelable {

/**
 * @hide
 */

NetworkRequest(android.net.NetworkRequest that) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @see Builder#addCapability(int)

 * @param capability Value is {@link android.net.NetworkCapabilities#NET_CAPABILITY_MMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_SUPL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_DUN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOTA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CBS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_WIFI_P2P}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_RCS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_XCAP}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_EIMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_METERED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_INTERNET}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_RESTRICTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_TRUSTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_VPN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_VALIDATED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_ROAMING}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOREGROUND}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_CONGESTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_SUSPENDED}, or android.net.NetworkCapabilities.NET_CAPABILITY_OEM_PAID
 */

public boolean hasCapability(int capability) { throw new RuntimeException("Stub!"); }

/**
 * @see Builder#addTransportType(int)

 * @param transportType Value is {@link android.net.NetworkCapabilities#TRANSPORT_CELLULAR}, {@link android.net.NetworkCapabilities#TRANSPORT_WIFI}, {@link android.net.NetworkCapabilities#TRANSPORT_BLUETOOTH}, {@link android.net.NetworkCapabilities#TRANSPORT_ETHERNET}, {@link android.net.NetworkCapabilities#TRANSPORT_VPN}, {@link android.net.NetworkCapabilities#TRANSPORT_WIFI_AWARE}, or {@link android.net.NetworkCapabilities#TRANSPORT_LOWPAN}
 */

public boolean hasTransport(int transportType) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.net.NetworkRequest> CREATOR;
static { CREATOR = null; }
/**
 * Builder used to create {@link NetworkRequest} objects.  Specify the Network features
 * needed in terms of {@link NetworkCapabilities} features
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Default constructor for Builder.
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Build {@link NetworkRequest} give the current set of capabilities.
 */

public android.net.NetworkRequest build() { throw new RuntimeException("Stub!"); }

/**
 * Add the given capability requirement to this builder.  These represent
 * the requested network's required capabilities.  Note that when searching
 * for a network to satisfy a request, all capabilities requested must be
 * satisfied.
 *
 * @param capability The capability to add.
 * Value is {@link android.net.NetworkCapabilities#NET_CAPABILITY_MMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_SUPL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_DUN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOTA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CBS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_WIFI_P2P}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_RCS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_XCAP}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_EIMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_METERED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_INTERNET}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_RESTRICTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_TRUSTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_VPN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_VALIDATED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_ROAMING}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOREGROUND}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_CONGESTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_SUSPENDED}, or android.net.NetworkCapabilities.NET_CAPABILITY_OEM_PAID
 * @return The builder to facilitate chaining
 *         {@code builder.addCapability(...).addCapability();}.
 */

public android.net.NetworkRequest.Builder addCapability(int capability) { throw new RuntimeException("Stub!"); }

/**
 * Removes (if found) the given capability from this builder instance.
 *
 * @param capability The capability to remove.
 * Value is {@link android.net.NetworkCapabilities#NET_CAPABILITY_MMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_SUPL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_DUN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOTA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CBS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_WIFI_P2P}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_IA}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_RCS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_XCAP}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_EIMS}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_METERED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_INTERNET}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_RESTRICTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_TRUSTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_VPN}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_VALIDATED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_ROAMING}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_FOREGROUND}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_CONGESTED}, {@link android.net.NetworkCapabilities#NET_CAPABILITY_NOT_SUSPENDED}, or android.net.NetworkCapabilities.NET_CAPABILITY_OEM_PAID
 * @return The builder to facilitate chaining.
 */

public android.net.NetworkRequest.Builder removeCapability(int capability) { throw new RuntimeException("Stub!"); }

/**
 * Adds the given transport requirement to this builder.  These represent
 * the set of allowed transports for the request.  Only networks using one
 * of these transports will satisfy the request.  If no particular transports
 * are required, none should be specified here.
 *
 * @param transportType The transport type to add.
 * Value is {@link android.net.NetworkCapabilities#TRANSPORT_CELLULAR}, {@link android.net.NetworkCapabilities#TRANSPORT_WIFI}, {@link android.net.NetworkCapabilities#TRANSPORT_BLUETOOTH}, {@link android.net.NetworkCapabilities#TRANSPORT_ETHERNET}, {@link android.net.NetworkCapabilities#TRANSPORT_VPN}, {@link android.net.NetworkCapabilities#TRANSPORT_WIFI_AWARE}, or {@link android.net.NetworkCapabilities#TRANSPORT_LOWPAN}
 * @return The builder to facilitate chaining.
 */

public android.net.NetworkRequest.Builder addTransportType(int transportType) { throw new RuntimeException("Stub!"); }

/**
 * Removes (if found) the given transport from this builder instance.
 *
 * @param transportType The transport type to remove.
 * Value is {@link android.net.NetworkCapabilities#TRANSPORT_CELLULAR}, {@link android.net.NetworkCapabilities#TRANSPORT_WIFI}, {@link android.net.NetworkCapabilities#TRANSPORT_BLUETOOTH}, {@link android.net.NetworkCapabilities#TRANSPORT_ETHERNET}, {@link android.net.NetworkCapabilities#TRANSPORT_VPN}, {@link android.net.NetworkCapabilities#TRANSPORT_WIFI_AWARE}, or {@link android.net.NetworkCapabilities#TRANSPORT_LOWPAN}
 * @return The builder to facilitate chaining.
 */

public android.net.NetworkRequest.Builder removeTransportType(int transportType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the optional bearer specific network specifier.
 * This has no meaning if a single transport is also not specified, so calling
 * this without a single transport set will generate an exception, as will
 * subsequently adding or removing transports after this is set.
 * </p>
 * The interpretation of this {@code String} is bearer specific and bearers that use
 * it should document their particulars.  For example, Bluetooth may use some sort of
 * device id while WiFi could used ssid and/or bssid.  Cellular may use carrier spn.
 *
 * @param networkSpecifier An {@code String} of opaque format used to specify the bearer
 *                         specific network specifier where the bearer has a choice of
 *                         networks.
 */

public android.net.NetworkRequest.Builder setNetworkSpecifier(java.lang.String networkSpecifier) { throw new RuntimeException("Stub!"); }

/**
 * Sets the optional bearer specific network specifier.
 * This has no meaning if a single transport is also not specified, so calling
 * this without a single transport set will generate an exception, as will
 * subsequently adding or removing transports after this is set.
 * </p>
 *
 * @param networkSpecifier A concrete, parcelable framework class that extends
 *                         NetworkSpecifier.
 */

public android.net.NetworkRequest.Builder setNetworkSpecifier(android.net.NetworkSpecifier networkSpecifier) { throw new RuntimeException("Stub!"); }
}

}

