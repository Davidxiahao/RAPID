/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.net.wifi.p2p;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A class representing a Wi-Fi P2p configuration for setting up a connection
 *
 * {@see WifiP2pManager}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiP2pConfig implements android.os.Parcelable {

public WifiP2pConfig() { throw new RuntimeException("Stub!"); }

/** copy constructor */

public WifiP2pConfig(android.net.wifi.p2p.WifiP2pConfig source) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public static final android.os.Parcelable.Creator<android.net.wifi.p2p.WifiP2pConfig> CREATOR;
static { CREATOR = null; }

/**
 * The device MAC address uniquely identifies a Wi-Fi p2p device
 */

public java.lang.String deviceAddress = "";

/**
 * This is an integer value between 0 and 15 where 0 indicates the least
 * inclination to be a group owner and 15 indicates the highest inclination
 * to be a group owner.
 *
 * A value of -1 indicates the system can choose an appropriate value.
 */

public int groupOwnerIntent = -1; // 0xffffffff

/**
 * Wi-Fi Protected Setup information
 */

public android.net.wifi.WpsInfo wps;
}

