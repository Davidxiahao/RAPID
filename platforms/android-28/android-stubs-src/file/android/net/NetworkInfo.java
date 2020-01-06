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


package android.net;


/**
 * Describes the status of a network interface.
 * <p>Use {@link ConnectivityManager#getActiveNetworkInfo()} to get an instance that represents
 * the current network connection.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NetworkInfo implements android.os.Parcelable {

/** {@hide} */

NetworkInfo(android.net.NetworkInfo source) { throw new RuntimeException("Stub!"); }

/**
 * Reports the type of network to which the
 * info in this {@code NetworkInfo} pertains.
 * @return one of {@link ConnectivityManager#TYPE_MOBILE}, {@link
 * ConnectivityManager#TYPE_WIFI}, {@link ConnectivityManager#TYPE_WIMAX}, {@link
 * ConnectivityManager#TYPE_ETHERNET},  {@link ConnectivityManager#TYPE_BLUETOOTH}, or other
 * types defined by {@link ConnectivityManager}.
 * @deprecated Callers should switch to checking {@link NetworkCapabilities#hasTransport}
 *             instead with one of the NetworkCapabilities#TRANSPORT_* constants :
 *             {@link #getType} and {@link #getTypeName} cannot account for networks using
 *             multiple transports. Note that generally apps should not care about transport;
 *             {@link NetworkCapabilities#NET_CAPABILITY_NOT_METERED} and
 *             {@link NetworkCapabilities#getLinkDownstreamBandwidthKbps} are calls that
 *             apps concerned with meteredness or bandwidth should be looking at, as they
 *             offer this information with much better accuracy.
 */

@Deprecated public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Return a network-type-specific integer describing the subtype
 * of the network.
 * @return the network subtype
 */

public int getSubtype() { throw new RuntimeException("Stub!"); }

/**
 * Return a human-readable name describe the type of the network,
 * for example "WIFI" or "MOBILE".
 * @return the name of the network type
 * @deprecated Callers should switch to checking {@link NetworkCapabilities#hasTransport}
 *             instead with one of the NetworkCapabilities#TRANSPORT_* constants :
 *             {@link #getType} and {@link #getTypeName} cannot account for networks using
 *             multiple transports. Note that generally apps should not care about transport;
 *             {@link NetworkCapabilities#NET_CAPABILITY_NOT_METERED} and
 *             {@link NetworkCapabilities#getLinkDownstreamBandwidthKbps} are calls that
 *             apps concerned with meteredness or bandwidth should be looking at, as they
 *             offer this information with much better accuracy.
 */

@Deprecated public java.lang.String getTypeName() { throw new RuntimeException("Stub!"); }

/**
 * Return a human-readable name describing the subtype of the network.
 * @return the name of the network subtype
 */

public java.lang.String getSubtypeName() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether network connectivity exists or is in the process
 * of being established. This is good for applications that need to
 * do anything related to the network other than read or write data.
 * For the latter, call {@link #isConnected()} instead, which guarantees
 * that the network is fully usable.
 * @return {@code true} if network connectivity exists or is in the process
 * of being established, {@code false} otherwise.
 * @deprecated Apps should instead use the
 *             {@link android.net.ConnectivityManager.NetworkCallback} API to
 *             learn about connectivity changes.
 *             {@link ConnectivityManager#registerDefaultNetworkCallback} and
 *             {@link ConnectivityManager#registerNetworkCallback}. These will
 *             give a more accurate picture of the connectivity state of
 *             the device and let apps react more easily and quickly to changes.
 */

@Deprecated public boolean isConnectedOrConnecting() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether network connectivity exists and it is possible to establish
 * connections and pass data.
 * <p>Always call this before attempting to perform data transactions.
 * @return {@code true} if network connectivity exists, {@code false} otherwise.
 */

public boolean isConnected() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether network connectivity is possible. A network is unavailable
 * when a persistent or semi-persistent condition prevents the possibility
 * of connecting to that network. Examples include
 * <ul>
 * <li>The device is out of the coverage area for any network of this type.</li>
 * <li>The device is on a network other than the home network (i.e., roaming), and
 * data roaming has been disabled.</li>
 * <li>The device's radio is turned off, e.g., because airplane mode is enabled.</li>
 * </ul>
 * Since Android L, this always returns {@code true}, because the system only
 * returns info for available networks.
 * @return {@code true} if the network is available, {@code false} otherwise
 * @deprecated Apps should instead use the
 *             {@link android.net.ConnectivityManager.NetworkCallback} API to
 *             learn about connectivity changes.
 *             {@link ConnectivityManager#registerDefaultNetworkCallback} and
 *             {@link ConnectivityManager#registerNetworkCallback}. These will
 *             give a more accurate picture of the connectivity state of
 *             the device and let apps react more easily and quickly to changes.
 */

@Deprecated public boolean isAvailable() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the current attempt to connect to the network
 * resulted from the ConnectivityManager trying to fail over to this
 * network following a disconnect from another network.
 * @return {@code true} if this is a failover attempt, {@code false}
 * otherwise.
 * @deprecated This field is not populated in recent Android releases,
 *             and does not make a lot of sense in a multi-network world.
 */

@Deprecated public boolean isFailover() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the device is currently roaming on this network. When
 * {@code true}, it suggests that use of data on this network may incur
 * extra costs.
 *
 * @return {@code true} if roaming is in effect, {@code false} otherwise.
 * @deprecated Callers should switch to checking
 *             {@link NetworkCapabilities#NET_CAPABILITY_NOT_ROAMING}
 *             instead, since that handles more complex situations, such as
 *             VPNs.
 */

@Deprecated public boolean isRoaming() { throw new RuntimeException("Stub!"); }

/**
 * Reports the current coarse-grained state of the network.
 * @return the coarse-grained state
 * @deprecated Apps should instead use the
 *             {@link android.net.ConnectivityManager.NetworkCallback} API to
 *             learn about connectivity changes.
 *             {@link ConnectivityManager#registerDefaultNetworkCallback} and
 *             {@link ConnectivityManager#registerNetworkCallback}. These will
 *             give a more accurate picture of the connectivity state of
 *             the device and let apps react more easily and quickly to changes.
 */

@Deprecated public android.net.NetworkInfo.State getState() { throw new RuntimeException("Stub!"); }

/**
 * Reports the current fine-grained state of the network.
 * @return the fine-grained state
 */

public android.net.NetworkInfo.DetailedState getDetailedState() { throw new RuntimeException("Stub!"); }

/**
 * Report the reason an attempt to establish connectivity failed,
 * if one is available.
 * @return the reason for failure, or null if not available
 * @deprecated This method does not have a consistent contract that could make it useful
 *             to callers.
 */

@Deprecated public java.lang.String getReason() { throw new RuntimeException("Stub!"); }

/**
 * Report the extra information about the network state, if any was
 * provided by the lower networking layers.
 * @return the extra information, or null if not available
 */

public java.lang.String getExtraInfo() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.net.NetworkInfo> CREATOR;
static { CREATOR = null; }
/**
 * The fine-grained state of a network connection. This level of detail
 * is probably of interest to few applications. Most should use
 * {@link android.net.NetworkInfo.State State} instead.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum DetailedState {
IDLE, SCANNING, CONNECTING, AUTHENTICATING, OBTAINING_IPADDR, CONNECTED, SUSPENDED, DISCONNECTING, DISCONNECTED, FAILED, BLOCKED, VERIFYING_POOR_LINK, CAPTIVE_PORTAL_CHECK;
}

/**
 * Coarse-grained network state. This is probably what most applications should
 * use, rather than {@link android.net.NetworkInfo.DetailedState DetailedState}.
 * The mapping between the two is as follows:
 * <br/><br/>
 * <table>
 * <tr><td><b>Detailed state</b></td><td><b>Coarse-grained state</b></td></tr>
 * <tr><td><code>IDLE</code></td><td><code>DISCONNECTED</code></td></tr>
 * <tr><td><code>SCANNING</code></td><td><code>DISCONNECTED</code></td></tr>
 * <tr><td><code>CONNECTING</code></td><td><code>CONNECTING</code></td></tr>
 * <tr><td><code>AUTHENTICATING</code></td><td><code>CONNECTING</code></td></tr>
 * <tr><td><code>OBTAINING_IPADDR</code></td><td><code>CONNECTING</code></td></tr>
 * <tr><td><code>VERIFYING_POOR_LINK</code></td><td><code>CONNECTING</code></td></tr>
 * <tr><td><code>CAPTIVE_PORTAL_CHECK</code></td><td><code>CONNECTING</code></td></tr>
 * <tr><td><code>CONNECTED</code></td><td><code>CONNECTED</code></td></tr>
 * <tr><td><code>SUSPENDED</code></td><td><code>SUSPENDED</code></td></tr>
 * <tr><td><code>DISCONNECTING</code></td><td><code>DISCONNECTING</code></td></tr>
 * <tr><td><code>DISCONNECTED</code></td><td><code>DISCONNECTED</code></td></tr>
 * <tr><td><code>FAILED</code></td><td><code>DISCONNECTED</code></td></tr>
 * <tr><td><code>BLOCKED</code></td><td><code>DISCONNECTED</code></td></tr>
 * </table>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum State {
CONNECTING, CONNECTED, SUSPENDED, DISCONNECTING, DISCONNECTED, UNKNOWN;
}

}

