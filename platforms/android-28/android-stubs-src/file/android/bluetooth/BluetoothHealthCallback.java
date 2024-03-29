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



package android.bluetooth;


/**
 * This abstract class is used to implement {@link BluetoothHealth} callbacks.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class BluetoothHealthCallback {

public BluetoothHealthCallback() { throw new RuntimeException("Stub!"); }

/**
 * Callback to inform change in registration state of the health
 * application.
 * <p> This callback is called on the binder thread (not on the UI thread)
 *
 * @param config Bluetooth Health app configuration
 * @param status Success or failure of the registration or unregistration calls. Can be one of
 * {@link BluetoothHealth#APP_CONFIG_REGISTRATION_SUCCESS} or {@link
 * BluetoothHealth#APP_CONFIG_REGISTRATION_FAILURE} or
 * {@link BluetoothHealth#APP_CONFIG_UNREGISTRATION_SUCCESS}
 * or {@link BluetoothHealth#APP_CONFIG_UNREGISTRATION_FAILURE}
 */

public void onHealthAppConfigurationStatusChange(android.bluetooth.BluetoothHealthAppConfiguration config, int status) { throw new RuntimeException("Stub!"); }

/**
 * Callback to inform change in channel state.
 * <p> Its the responsibility of the implementor of this callback to close the
 * parcel file descriptor when done. This callback is called on the Binder
 * thread (not the UI thread)
 *
 * @param config The Health app configutation
 * @param device The Bluetooth Device
 * @param prevState The previous state of the channel
 * @param newState The new state of the channel.
 * @param fd The Parcel File Descriptor when the channel state is connected.
 * @param channelId The id associated with the channel. This id will be used in future calls
 * like when disconnecting the channel.
 */

public void onHealthChannelStateChange(android.bluetooth.BluetoothHealthAppConfiguration config, android.bluetooth.BluetoothDevice device, int prevState, int newState, android.os.ParcelFileDescriptor fd, int channelId) { throw new RuntimeException("Stub!"); }
}

