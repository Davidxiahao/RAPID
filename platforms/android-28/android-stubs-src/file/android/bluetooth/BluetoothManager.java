/*
 * Copyright (C) 2013 The Android Open Source Project
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

import android.content.Context;
import android.content.pm.PackageManager;
import android.Manifest;
import java.util.List;

/**
 * High level manager used to obtain an instance of an {@link BluetoothAdapter}
 * and to conduct overall Bluetooth Management.
 * <p>
 * Use {@link android.content.Context#getSystemService(java.lang.String)}
 * with {@link Context#BLUETOOTH_SERVICE} to create an {@link BluetoothManager},
 * then call {@link #getAdapter} to obtain the {@link BluetoothAdapter}.
 * </p>
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>
 * For more information about using BLUETOOTH, read the <a href=
 * "{@docRoot}guide/topics/connectivity/bluetooth.html">Bluetooth</a> developer
 * guide.
 * </p>
 * </div>
 *
 * Requires the {@link android.content.pm.PackageManager#FEATURE_BLUETOOTH PackageManager#FEATURE_BLUETOOTH} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @see Context#getSystemService
 * @see BluetoothAdapter#getDefaultAdapter()
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothManager {

/**
 * @hide
 */

BluetoothManager(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Get the default BLUETOOTH Adapter for this device.
 *
 * @return the default BLUETOOTH Adapter
 */

public android.bluetooth.BluetoothAdapter getAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Get the current connection state of the profile to the remote device.
 *
 * <p>This is not specific to any application configuration but represents
 * the connection state of the local Bluetooth adapter for certain profile.
 * This can be used by applications like status bar which would just like
 * to know the state of Bluetooth.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @param device Remote bluetooth device.
 * @param profile GATT or GATT_SERVER
 * @return State of the profile connection. One of {@link BluetoothProfile#STATE_CONNECTED},
 * {@link BluetoothProfile#STATE_CONNECTING}, {@link BluetoothProfile#STATE_DISCONNECTED},
 * {@link BluetoothProfile#STATE_DISCONNECTING}
 */

public int getConnectionState(android.bluetooth.BluetoothDevice device, int profile) { throw new RuntimeException("Stub!"); }

/**
 * Get connected devices for the specified profile.
 *
 * <p> Return the set of devices which are in state {@link BluetoothProfile#STATE_CONNECTED}
 *
 * <p>This is not specific to any application configuration but represents
 * the connection state of Bluetooth for this profile.
 * This can be used by applications like status bar which would just like
 * to know the state of Bluetooth.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @param profile GATT or GATT_SERVER
 * @return List of devices. The list will be empty on error.
 */

public java.util.List<android.bluetooth.BluetoothDevice> getConnectedDevices(int profile) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of devices that match any of the given connection
 * states.
 *
 * <p> If none of the devices match any of the given states,
 * an empty list will be returned.
 *
 * <p>This is not specific to any application configuration but represents
 * the connection state of the local Bluetooth adapter for this profile.
 * This can be used by applications like status bar which would just like
 * to know the state of the local adapter.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @param profile GATT or GATT_SERVER
 * @param states Array of states. States can be one of {@link BluetoothProfile#STATE_CONNECTED},
 * {@link BluetoothProfile#STATE_CONNECTING}, {@link BluetoothProfile#STATE_DISCONNECTED},
 * {@link BluetoothProfile#STATE_DISCONNECTING},
 * @return List of devices. The list will be empty on error.
 */

public java.util.List<android.bluetooth.BluetoothDevice> getDevicesMatchingConnectionStates(int profile, int[] states) { throw new RuntimeException("Stub!"); }

/**
 * Open a GATT Server
 * The callback is used to deliver results to Caller, such as connection status as well
 * as the results of any other GATT server operations.
 * The method returns a BluetoothGattServer instance. You can use BluetoothGattServer
 * to conduct GATT server operations.
 *
 * @param context App context
 * @param callback GATT server callback handler that will receive asynchronous callbacks.
 * @return BluetoothGattServer instance
 */

public android.bluetooth.BluetoothGattServer openGattServer(android.content.Context context, android.bluetooth.BluetoothGattServerCallback callback) { throw new RuntimeException("Stub!"); }
}

