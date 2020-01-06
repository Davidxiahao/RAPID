/*
 * Copyright (C) 2010-2016 The Android Open Source Project
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



package android.bluetooth;

import java.util.List;
import android.Manifest;

/**
 * Public APIs for the Bluetooth Profiles.
 *
 * <p> Clients should call {@link BluetoothAdapter#getProfileProxy},
 * to get the Profile Proxy. Each public profile implements this
 * interface.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface BluetoothProfile {

/**
 * Get connected devices for this specific profile.
 *
 * <p> Return the set of devices which are in state {@link #STATE_CONNECTED}
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return List of devices. The list will be empty on error.
 */

public java.util.List<android.bluetooth.BluetoothDevice> getConnectedDevices();

/**
 * Get a list of devices that match any of the given connection
 * states.
 *
 * <p> If none of the devices match any of the given states,
 * an empty list will be returned.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @param states Array of states. States can be one of {@link #STATE_CONNECTED}, {@link
 * #STATE_CONNECTING}, {@link #STATE_DISCONNECTED}, {@link #STATE_DISCONNECTING},
 * @return List of devices. The list will be empty on error.
 */

public java.util.List<android.bluetooth.BluetoothDevice> getDevicesMatchingConnectionStates(int[] states);

/**
 * Get the current connection state of the profile
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @param device Remote bluetooth device.
 * @return State of the profile connection. One of {@link #STATE_CONNECTED}, {@link
 * #STATE_CONNECTING}, {@link #STATE_DISCONNECTED}, {@link #STATE_DISCONNECTING}
 */

public int getConnectionState(android.bluetooth.BluetoothDevice device);

/**
 * A2DP profile.
 */

public static final int A2DP = 2; // 0x2

/**
 * Extra for the connection state intents of the individual profiles.
 *
 * This extra represents the previous connection state of the profile of the
 * Bluetooth device.
 */

public static final java.lang.String EXTRA_PREVIOUS_STATE = "android.bluetooth.profile.extra.PREVIOUS_STATE";

/**
 * Extra for the connection state intents of the individual profiles.
 *
 * This extra represents the current connection state of the profile of the
 * Bluetooth device.
 */

public static final java.lang.String EXTRA_STATE = "android.bluetooth.profile.extra.STATE";

/**
 * GATT
 */

public static final int GATT = 7; // 0x7

/**
 * GATT_SERVER
 */

public static final int GATT_SERVER = 8; // 0x8

/**
 * Headset and Handsfree profile
 */

public static final int HEADSET = 1; // 0x1

/**
 * Health Profile
 */

public static final int HEALTH = 3; // 0x3

/**
 * HID Device
 */

public static final int HID_DEVICE = 19; // 0x13

public static final int SAP = 10; // 0xa

/** The profile is in connected state */

public static final int STATE_CONNECTED = 2; // 0x2

/** The profile is in connecting state */

public static final int STATE_CONNECTING = 1; // 0x1

/** The profile is in disconnected state */

public static final int STATE_DISCONNECTED = 0; // 0x0

/** The profile is in disconnecting state */

public static final int STATE_DISCONNECTING = 3; // 0x3
/**
 * An interface for notifying BluetoothProfile IPC clients when they have
 * been connected or disconnected to the service.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ServiceListener {

/**
 * Called to notify the client when the proxy object has been
 * connected to the service.
 *
 * @param profile - One of {@link #HEALTH}, {@link #HEADSET} or {@link #A2DP}
 * @param proxy - One of {@link BluetoothHealth}, {@link BluetoothHeadset} or {@link
 * BluetoothA2dp}
 */

public void onServiceConnected(int profile, android.bluetooth.BluetoothProfile proxy);

/**
 * Called to notify the client that this proxy object has been
 * disconnected from the service.
 *
 * @param profile - One of {@link #HEALTH}, {@link #HEADSET} or {@link #A2DP}
 */

public void onServiceDisconnected(int profile);
}

}

