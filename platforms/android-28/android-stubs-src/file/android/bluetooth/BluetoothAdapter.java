/*
 * Copyright 2009-2016 The Android Open Source Project
 * Copyright 2015 Samsung LSI
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

import android.bluetooth.le.ScanCallback;
import java.util.UUID;
import android.Manifest;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.bluetooth.le.BluetoothLeScanner;
import java.util.Set;
import android.os.ResultReceiver;
import java.io.IOException;
import android.util.Pair;
import java.util.List;
import android.content.Context;
import android.bluetooth.le.ScanSettings;

/**
 * Represents the local device Bluetooth adapter. The {@link BluetoothAdapter}
 * lets you perform fundamental Bluetooth tasks, such as initiate
 * device discovery, query a list of bonded (paired) devices,
 * instantiate a {@link BluetoothDevice} using a known MAC address, and create
 * a {@link BluetoothServerSocket} to listen for connection requests from other
 * devices, and start a scan for Bluetooth LE devices.
 *
 * <p>To get a {@link BluetoothAdapter} representing the local Bluetooth
 * adapter, call the {@link BluetoothManager#getAdapter} function on {@link BluetoothManager}.
 * On JELLY_BEAN_MR1 and below you will need to use the static {@link #getDefaultAdapter}
 * method instead.
 * </p><p>
 * Fundamentally, this is your starting point for all
 * Bluetooth actions. Once you have the local adapter, you can get a set of
 * {@link BluetoothDevice} objects representing all paired devices with
 * {@link #getBondedDevices()}; start device discovery with
 * {@link #startDiscovery()}; or create a {@link BluetoothServerSocket} to
 * listen for incoming RFComm connection requests with {@link
 * #listenUsingRfcommWithServiceRecord(String, UUID)}; or start a scan for
 * Bluetooth LE devices with {@link #startLeScan(LeScanCallback callback)}.
 * </p>
 * <p>This class is thread safe.</p>
 * <p class="note"><strong>Note:</strong>
 * Most methods require the {@link android.Manifest.permission#BLUETOOTH}
 * permission and some also require the
 * {@link android.Manifest.permission#BLUETOOTH_ADMIN} permission.
 * </p>
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>
 * For more information about using Bluetooth, read the <a href=
 * "{@docRoot}guide/topics/connectivity/bluetooth.html">Bluetooth</a> developer
 * guide.
 * </p>
 * </div>
 *
 * {@see BluetoothDevice}
 * {@see BluetoothServerSocket}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothAdapter {

BluetoothAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Get a handle to the default local Bluetooth adapter.
 * <p>Currently Android only supports one Bluetooth adapter, but the API
 * could be extended to support more. This will always return the default
 * adapter.
 * </p>
 *
 * @return the default local adapter, or null if Bluetooth is not supported on this hardware
 * platform
 */

public static synchronized android.bluetooth.BluetoothAdapter getDefaultAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Get a {@link BluetoothDevice} object for the given Bluetooth hardware
 * address.
 * <p>Valid Bluetooth hardware addresses must be upper case, in a format
 * such as "00:11:22:33:AA:BB". The helper {@link #checkBluetoothAddress} is
 * available to validate a Bluetooth address.
 * <p>A {@link BluetoothDevice} will always be returned for a valid
 * hardware address, even if this adapter has never seen that device.
 *
 * @param address valid Bluetooth MAC address
 * @throws IllegalArgumentException if address is invalid
 */

public android.bluetooth.BluetoothDevice getRemoteDevice(java.lang.String address) { throw new RuntimeException("Stub!"); }

/**
 * Get a {@link BluetoothDevice} object for the given Bluetooth hardware
 * address.
 * <p>Valid Bluetooth hardware addresses must be 6 bytes. This method
 * expects the address in network byte order (MSB first).
 * <p>A {@link BluetoothDevice} will always be returned for a valid
 * hardware address, even if this adapter has never seen that device.
 *
 * @param address Bluetooth MAC address (6 bytes)
 * @throws IllegalArgumentException if address is invalid
 */

public android.bluetooth.BluetoothDevice getRemoteDevice(byte[] address) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link BluetoothLeAdvertiser} object for Bluetooth LE Advertising operations.
 * Will return null if Bluetooth is turned off or if Bluetooth LE Advertising is not
 * supported on this device.
 * <p>
 * Use {@link #isMultipleAdvertisementSupported()} to check whether LE Advertising is supported
 * on this device before calling this method.
 */

public android.bluetooth.le.BluetoothLeAdvertiser getBluetoothLeAdvertiser() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link BluetoothLeScanner} object for Bluetooth LE scan operations.
 */

public android.bluetooth.le.BluetoothLeScanner getBluetoothLeScanner() { throw new RuntimeException("Stub!"); }

/**
 * Return true if Bluetooth is currently enabled and ready for use.
 * <p>Equivalent to:
 * <code>getBluetoothState() == STATE_ON</code>
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return true if the local adapter is turned on
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Get the current state of the local Bluetooth adapter.
 * <p>Possible return values are
 * {@link #STATE_OFF},
 * {@link #STATE_TURNING_ON},
 * {@link #STATE_ON},
 * {@link #STATE_TURNING_OFF}.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return current state of Bluetooth adapter

 * Value is {@link android.bluetooth.BluetoothAdapter#STATE_OFF}, {@link android.bluetooth.BluetoothAdapter#STATE_TURNING_ON}, {@link android.bluetooth.BluetoothAdapter#STATE_ON}, {@link android.bluetooth.BluetoothAdapter#STATE_TURNING_OFF}, android.bluetooth.BluetoothAdapter.STATE_BLE_TURNING_ON, android.bluetooth.BluetoothAdapter.STATE_BLE_ON, or android.bluetooth.BluetoothAdapter.STATE_BLE_TURNING_OFF
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Turn on the local Bluetooth adapter&mdash;do not use without explicit
 * user action to turn on Bluetooth.
 * <p>This powers on the underlying Bluetooth hardware, and starts all
 * Bluetooth system services.
 * <p class="caution"><strong>Bluetooth should never be enabled without
 * direct user consent</strong>. If you want to turn on Bluetooth in order
 * to create a wireless connection, you should use the {@link
 * #ACTION_REQUEST_ENABLE} Intent, which will raise a dialog that requests
 * user permission to turn on Bluetooth. The {@link #enable()} method is
 * provided only for applications that include a user interface for changing
 * system settings, such as a "power manager" app.</p>
 * <p>This is an asynchronous call: it will return immediately, and
 * clients should listen for {@link #ACTION_STATE_CHANGED}
 * to be notified of subsequent adapter state changes. If this call returns
 * true, then the adapter state will immediately transition from {@link
 * #STATE_OFF} to {@link #STATE_TURNING_ON}, and some time
 * later transition to either {@link #STATE_OFF} or {@link
 * #STATE_ON}. If this call returns false then there was an
 * immediate problem that will prevent the adapter from being turned on -
 * such as Airplane mode, or the adapter is already turned on.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @return true to indicate adapter startup has begun, or false on immediate error
 */

public boolean enable() { throw new RuntimeException("Stub!"); }

/**
 * Turn off the local Bluetooth adapter&mdash;do not use without explicit
 * user action to turn off Bluetooth.
 * <p>This gracefully shuts down all Bluetooth connections, stops Bluetooth
 * system services, and powers down the underlying Bluetooth hardware.
 * <p class="caution"><strong>Bluetooth should never be disabled without
 * direct user consent</strong>. The {@link #disable()} method is
 * provided only for applications that include a user interface for changing
 * system settings, such as a "power manager" app.</p>
 * <p>This is an asynchronous call: it will return immediately, and
 * clients should listen for {@link #ACTION_STATE_CHANGED}
 * to be notified of subsequent adapter state changes. If this call returns
 * true, then the adapter state will immediately transition from {@link
 * #STATE_ON} to {@link #STATE_TURNING_OFF}, and some time
 * later transition to either {@link #STATE_OFF} or {@link
 * #STATE_ON}. If this call returns false then there was an
 * immediate problem that will prevent the adapter from being turned off -
 * such as the adapter already being turned off.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @return true to indicate adapter shutdown has begun, or false on immediate error
 */

public boolean disable() { throw new RuntimeException("Stub!"); }

/**
 * Returns the hardware address of the local Bluetooth adapter.
 * <p>For example, "00:11:22:AA:BB:CC".
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return Bluetooth hardware address as string
 */

public java.lang.String getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Get the friendly Bluetooth name of the local Bluetooth adapter.
 * <p>This name is visible to remote Bluetooth devices.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH}
 *
 * @return the Bluetooth name, or null on error
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Set the friendly Bluetooth name of the local Bluetooth adapter.
 * <p>This name is visible to remote Bluetooth devices.
 * <p>Valid Bluetooth names are a maximum of 248 bytes using UTF-8
 * encoding, although many remote devices can only display the first
 * 40 characters, and some may be limited to just 20.
 * <p>If Bluetooth state is not {@link #STATE_ON}, this API
 * will return false. After turning on Bluetooth,
 * wait for {@link #ACTION_STATE_CHANGED} with {@link #STATE_ON}
 * to get the updated value.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @param name a valid Bluetooth name
 * @return true if the name was set, false otherwise
 */

public boolean setName(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Get the current Bluetooth scan mode of the local Bluetooth adapter.
 * <p>The Bluetooth scan mode determines if the local adapter is
 * connectable and/or discoverable from remote Bluetooth devices.
 * <p>Possible values are:
 * {@link #SCAN_MODE_NONE},
 * {@link #SCAN_MODE_CONNECTABLE},
 * {@link #SCAN_MODE_CONNECTABLE_DISCOVERABLE}.
 * <p>If Bluetooth state is not {@link #STATE_ON}, this API
 * will return {@link #SCAN_MODE_NONE}. After turning on Bluetooth,
 * wait for {@link #ACTION_STATE_CHANGED} with {@link #STATE_ON}
 * to get the updated value.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return scan mode

 * Value is {@link android.bluetooth.BluetoothAdapter#SCAN_MODE_NONE}, {@link android.bluetooth.BluetoothAdapter#SCAN_MODE_CONNECTABLE}, or {@link android.bluetooth.BluetoothAdapter#SCAN_MODE_CONNECTABLE_DISCOVERABLE}
 */

public int getScanMode() { throw new RuntimeException("Stub!"); }

/**
 * Start the remote device discovery process.
 * <p>The discovery process usually involves an inquiry scan of about 12
 * seconds, followed by a page scan of each new device to retrieve its
 * Bluetooth name.
 * <p>This is an asynchronous call, it will return immediately. Register
 * for {@link #ACTION_DISCOVERY_STARTED} and {@link
 * #ACTION_DISCOVERY_FINISHED} intents to determine exactly when the
 * discovery starts and completes. Register for {@link
 * BluetoothDevice#ACTION_FOUND} to be notified as remote Bluetooth devices
 * are found.
 * <p>Device discovery is a heavyweight procedure. New connections to
 * remote Bluetooth devices should not be attempted while discovery is in
 * progress, and existing connections will experience limited bandwidth
 * and high latency. Use {@link #cancelDiscovery()} to cancel an ongoing
 * discovery. Discovery is not managed by the Activity,
 * but is run as a system service, so an application should always call
 * {@link BluetoothAdapter#cancelDiscovery()} even if it
 * did not directly request a discovery, just to be sure.
 * <p>Device discovery will only find remote devices that are currently
 * <i>discoverable</i> (inquiry scan enabled). Many Bluetooth devices are
 * not discoverable by default, and need to be entered into a special mode.
 * <p>If Bluetooth state is not {@link #STATE_ON}, this API
 * will return false. After turning on Bluetooth,
 * wait for {@link #ACTION_STATE_CHANGED} with {@link #STATE_ON}
 * to get the updated value.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @return true on success, false on error
 */

public boolean startDiscovery() { throw new RuntimeException("Stub!"); }

/**
 * Cancel the current device discovery process.
 * <p>Because discovery is a heavyweight procedure for the Bluetooth
 * adapter, this method should always be called before attempting to connect
 * to a remote device with {@link
 * android.bluetooth.BluetoothSocket#connect()}. Discovery is not managed by
 * the  Activity, but is run as a system service, so an application should
 * always call cancel discovery even if it did not directly request a
 * discovery, just to be sure.
 * <p>If Bluetooth state is not {@link #STATE_ON}, this API
 * will return false. After turning on Bluetooth,
 * wait for {@link #ACTION_STATE_CHANGED} with {@link #STATE_ON}
 * to get the updated value.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @return true on success, false on error
 */

public boolean cancelDiscovery() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the local Bluetooth adapter is currently in the device
 * discovery process.
 * <p>Device discovery is a heavyweight procedure. New connections to
 * remote Bluetooth devices should not be attempted while discovery is in
 * progress, and existing connections will experience limited bandwidth
 * and high latency. Use {@link #cancelDiscovery()} to cancel an ongoing
 * discovery.
 * <p>Applications can also register for {@link #ACTION_DISCOVERY_STARTED}
 * or {@link #ACTION_DISCOVERY_FINISHED} to be notified when discovery
 * starts or completes.
 * <p>If Bluetooth state is not {@link #STATE_ON}, this API
 * will return false. After turning on Bluetooth,
 * wait for {@link #ACTION_STATE_CHANGED} with {@link #STATE_ON}
 * to get the updated value.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return true if discovering
 */

public boolean isDiscovering() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the multi advertisement is supported by the chipset
 *
 * @return true if Multiple Advertisement feature is supported
 */

public boolean isMultipleAdvertisementSupported() { throw new RuntimeException("Stub!"); }

/**
 * Return true if offloaded filters are supported
 *
 * @return true if chipset supports on-chip filtering
 */

public boolean isOffloadedFilteringSupported() { throw new RuntimeException("Stub!"); }

/**
 * Return true if offloaded scan batching is supported
 *
 * @return true if chipset supports on-chip scan batching
 */

public boolean isOffloadedScanBatchingSupported() { throw new RuntimeException("Stub!"); }

/**
 * Return true if LE 2M PHY feature is supported.
 *
 * @return true if chipset supports LE 2M PHY feature
 */

public boolean isLe2MPhySupported() { throw new RuntimeException("Stub!"); }

/**
 * Return true if LE Coded PHY feature is supported.
 *
 * @return true if chipset supports LE Coded PHY feature
 */

public boolean isLeCodedPhySupported() { throw new RuntimeException("Stub!"); }

/**
 * Return true if LE Extended Advertising feature is supported.
 *
 * @return true if chipset supports LE Extended Advertising feature
 */

public boolean isLeExtendedAdvertisingSupported() { throw new RuntimeException("Stub!"); }

/**
 * Return true if LE Periodic Advertising feature is supported.
 *
 * @return true if chipset supports LE Periodic Advertising feature
 */

public boolean isLePeriodicAdvertisingSupported() { throw new RuntimeException("Stub!"); }

/**
 * Return the maximum LE advertising data length in bytes,
 * if LE Extended Advertising feature is supported, 0 otherwise.
 *
 * @return the maximum LE advertising data length.
 */

public int getLeMaximumAdvertisingDataLength() { throw new RuntimeException("Stub!"); }

/**
 * Return the set of {@link BluetoothDevice} objects that are bonded
 * (paired) to the local adapter.
 * <p>If Bluetooth state is not {@link #STATE_ON}, this API
 * will return an empty set. After turning on Bluetooth,
 * wait for {@link #ACTION_STATE_CHANGED} with {@link #STATE_ON}
 * to get the updated value.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @return unmodifiable set of {@link BluetoothDevice}, or null on error
 */

public java.util.Set<android.bluetooth.BluetoothDevice> getBondedDevices() { throw new RuntimeException("Stub!"); }

/**
 * Get the current connection state of a profile.
 * This function can be used to check whether the local Bluetooth adapter
 * is connected to any remote device for a specific profile.
 * Profile can be one of {@link BluetoothProfile#HEALTH}, {@link BluetoothProfile#HEADSET},
 * {@link BluetoothProfile#A2DP}.
 *
 * <p> Return value can be one of
 * {@link BluetoothProfile#STATE_DISCONNECTED},
 * {@link BluetoothProfile#STATE_CONNECTING},
 * {@link BluetoothProfile#STATE_CONNECTED},
 * {@link BluetoothProfile#STATE_DISCONNECTING}

 * Requires {@link android.Manifest.permission#BLUETOOTH}
 */

public int getProfileConnectionState(int profile) { throw new RuntimeException("Stub!"); }

/**
 * Create a listening, secure RFCOMM Bluetooth socket with Service Record.
 * <p>A remote device connecting to this socket will be authenticated and
 * communication on this socket will be encrypted.
 * <p>Use {@link BluetoothServerSocket#accept} to retrieve incoming
 * connections from a listening {@link BluetoothServerSocket}.
 * <p>The system will assign an unused RFCOMM channel to listen on.
 * <p>The system will also register a Service Discovery
 * Protocol (SDP) record with the local SDP server containing the specified
 * UUID, service name, and auto-assigned channel. Remote Bluetooth devices
 * can use the same UUID to query our SDP server and discover which channel
 * to connect to. This SDP record will be removed when this socket is
 * closed, or if this application closes unexpectedly.
 * <p>Use {@link BluetoothDevice#createRfcommSocketToServiceRecord} to
 * connect to this socket from another device using the same {@link UUID}.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @param name service name for SDP record
 * @param uuid uuid for SDP record
 * @return a listening RFCOMM BluetoothServerSocket
 * @throws IOException on error, for example Bluetooth not available, or insufficient
 * permissions, or channel in use.
 */

public android.bluetooth.BluetoothServerSocket listenUsingRfcommWithServiceRecord(java.lang.String name, java.util.UUID uuid) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a listening, insecure RFCOMM Bluetooth socket with Service Record.
 * <p>The link key is not required to be authenticated, i.e the communication may be
 * vulnerable to Man In the Middle attacks. For Bluetooth 2.1 devices,
 * the link will be encrypted, as encryption is mandartory.
 * For legacy devices (pre Bluetooth 2.1 devices) the link will not
 * be encrypted. Use {@link #listenUsingRfcommWithServiceRecord}, if an
 * encrypted and authenticated communication channel is desired.
 * <p>Use {@link BluetoothServerSocket#accept} to retrieve incoming
 * connections from a listening {@link BluetoothServerSocket}.
 * <p>The system will assign an unused RFCOMM channel to listen on.
 * <p>The system will also register a Service Discovery
 * Protocol (SDP) record with the local SDP server containing the specified
 * UUID, service name, and auto-assigned channel. Remote Bluetooth devices
 * can use the same UUID to query our SDP server and discover which channel
 * to connect to. This SDP record will be removed when this socket is
 * closed, or if this application closes unexpectedly.
 * <p>Use {@link BluetoothDevice#createRfcommSocketToServiceRecord} to
 * connect to this socket from another device using the same {@link UUID}.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH}
 * @param name service name for SDP record
 * @param uuid uuid for SDP record
 * @return a listening RFCOMM BluetoothServerSocket
 * @throws IOException on error, for example Bluetooth not available, or insufficient
 * permissions, or channel in use.
 */

public android.bluetooth.BluetoothServerSocket listenUsingInsecureRfcommWithServiceRecord(java.lang.String name, java.util.UUID uuid) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Get the profile proxy object associated with the profile.
 *
 * <p>Profile can be one of {@link BluetoothProfile#HEALTH}, {@link BluetoothProfile#HEADSET},
 * {@link BluetoothProfile#A2DP}, {@link BluetoothProfile#GATT}, or
 * {@link BluetoothProfile#GATT_SERVER}. Clients must implement
 * {@link BluetoothProfile.ServiceListener} to get notified of
 * the connection status and to get the proxy object.
 *
 * @param context Context of the application
 * @param listener The service Listener for connection callbacks.
 * @param profile The Bluetooth profile; either {@link BluetoothProfile#HEALTH}, {@link
 * BluetoothProfile#HEADSET}, {@link BluetoothProfile#A2DP}. {@link BluetoothProfile#GATT} or
 * {@link BluetoothProfile#GATT_SERVER}.
 * @return true on success, false on error
 */

public boolean getProfileProxy(android.content.Context context, android.bluetooth.BluetoothProfile.ServiceListener listener, int profile) { throw new RuntimeException("Stub!"); }

/**
 * Close the connection of the profile proxy to the Service.
 *
 * <p> Clients should call this when they are no longer using
 * the proxy obtained from {@link #getProfileProxy}.
 * Profile can be one of  {@link BluetoothProfile#HEALTH}, {@link BluetoothProfile#HEADSET} or
 * {@link BluetoothProfile#A2DP}
 *
 * @param profile
 * @param proxy Profile proxy object
 */

public void closeProfileProxy(int profile, android.bluetooth.BluetoothProfile proxy) { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Validate a String Bluetooth address, such as "00:43:A8:23:10:F0"
 * <p>Alphabetic characters must be uppercase to be valid.
 *
 * @param address Bluetooth address as string
 * @return true if the address is valid, false otherwise
 */

public static boolean checkBluetoothAddress(java.lang.String address) { throw new RuntimeException("Stub!"); }

/**
 * Starts a scan for Bluetooth LE devices.
 *
 * <p>Results of the scan are reported using the
 * {@link LeScanCallback#onLeScan} callback.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @param callback the callback LE scan results are delivered
 * @return true, if the scan was started successfully
 * @deprecated use {@link BluetoothLeScanner#startScan(List, ScanSettings, ScanCallback)}
 * instead.
 */

@Deprecated public boolean startLeScan(android.bluetooth.BluetoothAdapter.LeScanCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Starts a scan for Bluetooth LE devices, looking for devices that
 * advertise given services.
 *
 * <p>Devices which advertise all specified services are reported using the
 * {@link LeScanCallback#onLeScan} callback.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @param serviceUuids Array of services to look for
 * @param callback the callback LE scan results are delivered
 * @return true, if the scan was started successfully
 * @deprecated use {@link BluetoothLeScanner#startScan(List, ScanSettings, ScanCallback)}
 * instead.
 */

@Deprecated public boolean startLeScan(java.util.UUID[] serviceUuids, android.bluetooth.BluetoothAdapter.LeScanCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Stops an ongoing Bluetooth LE device scan.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @param callback used to identify which scan to stop must be the same handle used to start the
 * scan
 * @deprecated Use {@link BluetoothLeScanner#stopScan(ScanCallback)} instead.
 */

@Deprecated public void stopLeScan(android.bluetooth.BluetoothAdapter.LeScanCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Intent used to broadcast the change in connection state of the local
 * Bluetooth adapter to a profile of the remote device. When the adapter is
 * not connected to any profiles of any remote devices and it attempts a
 * connection to a profile this intent will be sent. Once connected, this intent
 * will not be sent for any more connection attempts to any profiles of any
 * remote device. When the adapter disconnects from the last profile its
 * connected to of any remote device, this intent will be sent.
 *
 * <p> This intent is useful for applications that are only concerned about
 * whether the local adapter is connected to any profile of any device and
 * are not really concerned about which profile. For example, an application
 * which displays an icon to display whether Bluetooth is connected or not
 * can use this intent.
 *
 * <p>This intent will have 3 extras:
 * {@link #EXTRA_CONNECTION_STATE} - The current connection state.
 * {@link #EXTRA_PREVIOUS_CONNECTION_STATE}- The previous connection state.
 * {@link BluetoothDevice#EXTRA_DEVICE} - The remote device.
 *
 * {@link #EXTRA_CONNECTION_STATE} or {@link #EXTRA_PREVIOUS_CONNECTION_STATE}
 * can be any of {@link #STATE_DISCONNECTED}, {@link #STATE_CONNECTING},
 * {@link #STATE_CONNECTED}, {@link #STATE_DISCONNECTING}.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} to receive.
 */

public static final java.lang.String ACTION_CONNECTION_STATE_CHANGED = "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED";

/**
 * Broadcast Action: The local Bluetooth adapter has finished the device
 * discovery process.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} to receive.
 */

public static final java.lang.String ACTION_DISCOVERY_FINISHED = "android.bluetooth.adapter.action.DISCOVERY_FINISHED";

/**
 * Broadcast Action: The local Bluetooth adapter has started the remote
 * device discovery process.
 * <p>This usually involves an inquiry scan of about 12 seconds, followed
 * by a page scan of each new device to retrieve its Bluetooth name.
 * <p>Register for {@link BluetoothDevice#ACTION_FOUND} to be notified as
 * remote Bluetooth devices are found.
 * <p>Device discovery is a heavyweight procedure. New connections to
 * remote Bluetooth devices should not be attempted while discovery is in
 * progress, and existing connections will experience limited bandwidth
 * and high latency. Use {@link #cancelDiscovery()} to cancel an ongoing
 * discovery.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} to receive.
 */

public static final java.lang.String ACTION_DISCOVERY_STARTED = "android.bluetooth.adapter.action.DISCOVERY_STARTED";

/**
 * Broadcast Action: The local Bluetooth adapter has changed its friendly
 * Bluetooth name.
 * <p>This name is visible to remote Bluetooth devices.
 * <p>Always contains the extra field {@link #EXTRA_LOCAL_NAME} containing
 * the name.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} to receive.
 */

public static final java.lang.String ACTION_LOCAL_NAME_CHANGED = "android.bluetooth.adapter.action.LOCAL_NAME_CHANGED";

/**
 * Activity Action: Show a system activity that requests discoverable mode.
 * This activity will also request the user to turn on Bluetooth if it
 * is not currently enabled.
 * <p>Discoverable mode is equivalent to {@link
 * #SCAN_MODE_CONNECTABLE_DISCOVERABLE}. It allows remote devices to see
 * this Bluetooth adapter when they perform a discovery.
 * <p>For privacy, Android is not discoverable by default.
 * <p>The sender of this Intent can optionally use extra field {@link
 * #EXTRA_DISCOVERABLE_DURATION} to request the duration of
 * discoverability. Currently the default duration is 120 seconds, and
 * maximum duration is capped at 300 seconds for each request.
 * <p>Notification of the result of this activity is posted using the
 * {@link android.app.Activity#onActivityResult} callback. The
 * <code>resultCode</code>
 * will be the duration (in seconds) of discoverability or
 * {@link android.app.Activity#RESULT_CANCELED} if the user rejected
 * discoverability or an error has occurred.
 * <p>Applications can also listen for {@link #ACTION_SCAN_MODE_CHANGED}
 * for global notification whenever the scan mode changes. For example, an
 * application can be notified when the device has ended discoverability.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH}
 */

public static final java.lang.String ACTION_REQUEST_DISCOVERABLE = "android.bluetooth.adapter.action.REQUEST_DISCOVERABLE";

/**
 * Activity Action: Show a system activity that allows the user to turn on
 * Bluetooth.
 * <p>This system activity will return once Bluetooth has completed turning
 * on, or the user has decided not to turn Bluetooth on.
 * <p>Notification of the result of this activity is posted using the
 * {@link android.app.Activity#onActivityResult} callback. The
 * <code>resultCode</code>
 * will be {@link android.app.Activity#RESULT_OK} if Bluetooth has been
 * turned on or {@link android.app.Activity#RESULT_CANCELED} if the user
 * has rejected the request or an error has occurred.
 * <p>Applications can also listen for {@link #ACTION_STATE_CHANGED}
 * for global notification whenever Bluetooth is turned on or off.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH}
 */

public static final java.lang.String ACTION_REQUEST_ENABLE = "android.bluetooth.adapter.action.REQUEST_ENABLE";

/**
 * Broadcast Action: Indicates the Bluetooth scan mode of the local Adapter
 * has changed.
 * <p>Always contains the extra fields {@link #EXTRA_SCAN_MODE} and {@link
 * #EXTRA_PREVIOUS_SCAN_MODE} containing the new and old scan modes
 * respectively.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH}
 */

public static final java.lang.String ACTION_SCAN_MODE_CHANGED = "android.bluetooth.adapter.action.SCAN_MODE_CHANGED";

/**
 * Broadcast Action: The state of the local Bluetooth adapter has been
 * changed.
 * <p>For example, Bluetooth has been turned on or off.
 * <p>Always contains the extra fields {@link #EXTRA_STATE} and {@link
 * #EXTRA_PREVIOUS_STATE} containing the new and old states
 * respectively.
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} to receive.
 */

public static final java.lang.String ACTION_STATE_CHANGED = "android.bluetooth.adapter.action.STATE_CHANGED";

/**
 * Sentinel error value for this class. Guaranteed to not equal any other
 * integer constant in this class. Provided as a convenience for functions
 * that require a sentinel error value, for example:
 * <p><code>Intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,
 * BluetoothAdapter.ERROR)</code>
 */

public static final int ERROR = -2147483648; // 0x80000000

/**
 * Extra used by {@link #ACTION_CONNECTION_STATE_CHANGED}
 *
 * This extra represents the current connection state.
 */

public static final java.lang.String EXTRA_CONNECTION_STATE = "android.bluetooth.adapter.extra.CONNECTION_STATE";

/**
 * Used as an optional int extra field in {@link
 * #ACTION_REQUEST_DISCOVERABLE} intents to request a specific duration
 * for discoverability in seconds. The current default is 120 seconds, and
 * requests over 300 seconds will be capped. These values could change.
 */

public static final java.lang.String EXTRA_DISCOVERABLE_DURATION = "android.bluetooth.adapter.extra.DISCOVERABLE_DURATION";

/**
 * Used as a String extra field in {@link #ACTION_LOCAL_NAME_CHANGED}
 * intents to request the local Bluetooth name.
 */

public static final java.lang.String EXTRA_LOCAL_NAME = "android.bluetooth.adapter.extra.LOCAL_NAME";

/**
 * Extra used by {@link #ACTION_CONNECTION_STATE_CHANGED}
 *
 * This extra represents the previous connection state.
 */

public static final java.lang.String EXTRA_PREVIOUS_CONNECTION_STATE = "android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE";

/**
 * Used as an int extra field in {@link #ACTION_SCAN_MODE_CHANGED}
 * intents to request the previous scan mode. Possible values are:
 * {@link #SCAN_MODE_NONE},
 * {@link #SCAN_MODE_CONNECTABLE},
 * {@link #SCAN_MODE_CONNECTABLE_DISCOVERABLE},
 */

public static final java.lang.String EXTRA_PREVIOUS_SCAN_MODE = "android.bluetooth.adapter.extra.PREVIOUS_SCAN_MODE";

/**
 * Used as an int extra field in {@link #ACTION_STATE_CHANGED}
 * intents to request the previous power state. Possible values are:
 * {@link #STATE_OFF},
 * {@link #STATE_TURNING_ON},
 * {@link #STATE_ON},
 * {@link #STATE_TURNING_OFF}
 */

public static final java.lang.String EXTRA_PREVIOUS_STATE = "android.bluetooth.adapter.extra.PREVIOUS_STATE";

/**
 * Used as an int extra field in {@link #ACTION_SCAN_MODE_CHANGED}
 * intents to request the current scan mode. Possible values are:
 * {@link #SCAN_MODE_NONE},
 * {@link #SCAN_MODE_CONNECTABLE},
 * {@link #SCAN_MODE_CONNECTABLE_DISCOVERABLE},
 */

public static final java.lang.String EXTRA_SCAN_MODE = "android.bluetooth.adapter.extra.SCAN_MODE";

/**
 * Used as an int extra field in {@link #ACTION_STATE_CHANGED}
 * intents to request the current power state. Possible values are:
 * {@link #STATE_OFF},
 * {@link #STATE_TURNING_ON},
 * {@link #STATE_ON},
 * {@link #STATE_TURNING_OFF},
 */

public static final java.lang.String EXTRA_STATE = "android.bluetooth.adapter.extra.STATE";

/**
 * Indicates that inquiry scan is disabled, but page scan is enabled on the
 * local Bluetooth adapter. Therefore this device is not discoverable from
 * remote Bluetooth devices, but is connectable from remote devices that
 * have previously discovered this device.
 */

public static final int SCAN_MODE_CONNECTABLE = 21; // 0x15

/**
 * Indicates that both inquiry scan and page scan are enabled on the local
 * Bluetooth adapter. Therefore this device is both discoverable and
 * connectable from remote Bluetooth devices.
 */

public static final int SCAN_MODE_CONNECTABLE_DISCOVERABLE = 23; // 0x17

/**
 * Indicates that both inquiry scan and page scan are disabled on the local
 * Bluetooth adapter. Therefore this device is neither discoverable
 * nor connectable from remote Bluetooth devices.
 */

public static final int SCAN_MODE_NONE = 20; // 0x14

/** The profile is in connected state */

public static final int STATE_CONNECTED = 2; // 0x2

/** The profile is in connecting state */

public static final int STATE_CONNECTING = 1; // 0x1

/** The profile is in disconnected state */

public static final int STATE_DISCONNECTED = 0; // 0x0

/** The profile is in disconnecting state */

public static final int STATE_DISCONNECTING = 3; // 0x3

/**
 * Indicates the local Bluetooth adapter is off.
 */

public static final int STATE_OFF = 10; // 0xa

/**
 * Indicates the local Bluetooth adapter is on, and ready for use.
 */

public static final int STATE_ON = 12; // 0xc

/**
 * Indicates the local Bluetooth adapter is turning off. Local clients
 * should immediately attempt graceful disconnection of any remote links.
 */

public static final int STATE_TURNING_OFF = 13; // 0xd

/**
 * Indicates the local Bluetooth adapter is turning on. However local
 * clients should wait for {@link #STATE_ON} before attempting to
 * use the adapter.
 */

public static final int STATE_TURNING_ON = 11; // 0xb
/**
 * Callback interface used to deliver LE scan results.
 *
 * @see #startLeScan(LeScanCallback)
 * @see #startLeScan(UUID[], LeScanCallback)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface LeScanCallback {

/**
 * Callback reporting an LE device found during a device scan initiated
 * by the {@link BluetoothAdapter#startLeScan} function.
 *
 * @param device Identifies the remote device
 * @param rssi The RSSI value for the remote device as reported by the Bluetooth hardware. 0
 * if no RSSI value is available.
 * @param scanRecord The content of the advertisement record offered by the remote device.
 */

public void onLeScan(android.bluetooth.BluetoothDevice device, int rssi, byte[] scanRecord);
}

}

