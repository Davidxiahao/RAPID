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


package android.net.wifi;

import android.net.NetworkInfo.DetailedState;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Describes the state of any Wifi connection that is active or
 * is in the process of being set up.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiInfo implements android.os.Parcelable {

/** @hide */

WifiInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the service set identifier (SSID) of the current 802.11 network.
 * If the SSID can be decoded as UTF-8, it will be returned surrounded by double
 * quotation marks. Otherwise, it is returned as a string of hex digits. The
 * SSID may be &lt;unknown ssid&gt; if there is no network currently connected,
 * or if the caller has insufficient permissions to access the SSID.
 *
 * Prior to {@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR1}, this method
 * always returned the SSID with no quotes around it.
 * @return the SSID
 */

public java.lang.String getSSID() { throw new RuntimeException("Stub!"); }

/**
 * Return the basic service set identifier (BSSID) of the current access point.
 * The BSSID may be {@code null} if there is no network currently connected.
 * @return the BSSID, in the form of a six-byte MAC address: {@code XX:XX:XX:XX:XX:XX}
 */

public java.lang.String getBSSID() { throw new RuntimeException("Stub!"); }

/**
 * Returns the received signal strength indicator of the current 802.11
 * network, in dBm.
 *
 * <p>Use {@link android.net.wifi.WifiManager#calculateSignalLevel} to convert this number into
 * an absolute signal level which can be displayed to a user.
 *
 * @return the RSSI.
 */

public int getRssi() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current link speed in {@link #LINK_SPEED_UNITS}.
 * @return the link speed.
 * @see #LINK_SPEED_UNITS
 */

public int getLinkSpeed() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current frequency in {@link #FREQUENCY_UNITS}.
 * @return the frequency.
 * @see #FREQUENCY_UNITS
 */

public int getFrequency() { throw new RuntimeException("Stub!"); }

public java.lang.String getMacAddress() { throw new RuntimeException("Stub!"); }

/**
 * Each configured network has a unique small integer ID, used to identify
 * the network when performing operations on the supplicant. This method
 * returns the ID for the currently connected network.
 * @return the network ID, or -1 if there is no currently connected network
 */

public int getNetworkId() { throw new RuntimeException("Stub!"); }

/**
 * Return the detailed state of the supplicant's negotiation with an
 * access point, in the form of a {@link SupplicantState SupplicantState} object.
 * @return the current {@link SupplicantState SupplicantState}
 */

public android.net.wifi.SupplicantState getSupplicantState() { throw new RuntimeException("Stub!"); }

public int getIpAddress() { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if this network does not broadcast its SSID, so an
 * SSID-specific probe request must be used for scans.
 */

public boolean getHiddenSSID() { throw new RuntimeException("Stub!"); }

/**
 * Map a supplicant state into a fine-grained network connectivity state.
 * @param suppState the supplicant state
 * @return the corresponding {@link DetailedState}
 */

public static android.net.NetworkInfo.DetailedState getDetailedStateOf(android.net.wifi.SupplicantState suppState) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Frequency in MHz
 */

public static final java.lang.String FREQUENCY_UNITS = "MHz";

/**
 * Link speed in Mbps
 */

public static final java.lang.String LINK_SPEED_UNITS = "Mbps";
}

