/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.net.wifi.p2p.nsd;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * A class for storing service information that is advertised
 * over a Wi-Fi peer-to-peer setup
 *
 * @see WifiP2pUpnpServiceInfo
 * @see WifiP2pDnsSdServiceInfo
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pServiceInfo implements android.os.Parcelable {

/**
 * This is only used in subclass.
 *
 * @param queryList query string for wpa_supplicant
 * @hide
 */

WifiP2pServiceInfo(java.util.List<java.lang.String> queryList) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * All service protocol types.
 */

public static final int SERVICE_TYPE_ALL = 0; // 0x0

/**
 * DNS based service discovery protocol.
 */

public static final int SERVICE_TYPE_BONJOUR = 1; // 0x1

/**
 * UPnP protocol.
 */

public static final int SERVICE_TYPE_UPNP = 2; // 0x2

/**
 * Vendor Specific protocol
 */

public static final int SERVICE_TYPE_VENDOR_SPECIFIC = 255; // 0xff
}

