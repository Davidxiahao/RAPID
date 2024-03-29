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


package android.bluetooth;

import android.Manifest;
import android.content.Intent;

/**
 * This class provides the public APIs to control the Bluetooth A2DP
 * profile.
 *
 * <p>BluetoothA2dp is a proxy object for controlling the Bluetooth A2DP
 * Service via IPC. Use {@link BluetoothAdapter#getProfileProxy} to get
 * the BluetoothA2dp proxy object.
 *
 * <p> Android only supports one connected Bluetooth A2dp device at a time.
 * Each method is protected with its appropriate permission.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothA2dp implements android.bluetooth.BluetoothProfile {

/**
 * Create a BluetoothA2dp proxy object for interacting with the local
 * Bluetooth A2DP service.
 */

BluetoothA2dp(android.content.Context context, android.bluetooth.BluetoothProfile.ServiceListener l) { throw new RuntimeException("Stub!"); }

public void finalize() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public java.util.List<android.bluetooth.BluetoothDevice> getConnectedDevices() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public java.util.List<android.bluetooth.BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public int getConnectionState(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Check if A2DP profile is streaming music.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param device BluetoothDevice device
 */

public boolean isA2dpPlaying(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Intent used to broadcast the change in connection state of the A2DP
 * profile.
 *
 * <p>This intent will have 3 extras:
 * <ul>
 * <li> {@link #EXTRA_STATE} - The current state of the profile. </li>
 * <li> {@link #EXTRA_PREVIOUS_STATE}- The previous state of the profile.</li>
 * <li> {@link BluetoothDevice#EXTRA_DEVICE} - The remote device. </li>
 * </ul>
 *
 * <p>{@link #EXTRA_STATE} or {@link #EXTRA_PREVIOUS_STATE} can be any of
 * {@link #STATE_DISCONNECTED}, {@link #STATE_CONNECTING},
 * {@link #STATE_CONNECTED}, {@link #STATE_DISCONNECTING}.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission to
 * receive.
 */

public static final java.lang.String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED";

/**
 * Intent used to broadcast the change in the Playing state of the A2DP
 * profile.
 *
 * <p>This intent will have 3 extras:
 * <ul>
 * <li> {@link #EXTRA_STATE} - The current state of the profile. </li>
 * <li> {@link #EXTRA_PREVIOUS_STATE}- The previous state of the profile. </li>
 * <li> {@link BluetoothDevice#EXTRA_DEVICE} - The remote device. </li>
 * </ul>
 *
 * <p>{@link #EXTRA_STATE} or {@link #EXTRA_PREVIOUS_STATE} can be any of
 * {@link #STATE_PLAYING}, {@link #STATE_NOT_PLAYING},
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission to
 * receive.
 */

public static final java.lang.String ACTION_PLAYING_STATE_CHANGED = "android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED";

/**
 * A2DP sink device is NOT streaming music. This state can be one of
 * {@link #EXTRA_STATE} or {@link #EXTRA_PREVIOUS_STATE} of
 * {@link #ACTION_PLAYING_STATE_CHANGED} intent.
 */

public static final int STATE_NOT_PLAYING = 11; // 0xb

/**
 * A2DP sink device is streaming music. This state can be one of
 * {@link #EXTRA_STATE} or {@link #EXTRA_PREVIOUS_STATE} of
 * {@link #ACTION_PLAYING_STATE_CHANGED} intent.
 */

public static final int STATE_PLAYING = 10; // 0xa
}

