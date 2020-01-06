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

import java.util.UUID;
import android.os.Handler;
import java.util.List;

/**
 * Public API for the Bluetooth GATT Profile.
 *
 * <p>This class provides Bluetooth GATT functionality to enable communication
 * with Bluetooth Smart or Smart Ready devices.
 *
 * <p>To connect to a remote peripheral device, create a {@link BluetoothGattCallback}
 * and call {@link BluetoothDevice#connectGatt} to get a instance of this class.
 * GATT capable devices can be discovered using the Bluetooth device discovery or BLE
 * scan process.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothGatt implements android.bluetooth.BluetoothProfile {

BluetoothGatt() { throw new RuntimeException("Stub!"); }

/**
 * Close this Bluetooth GATT client.
 *
 * Application should call this method as early as possible after it is done with
 * this GATT client.
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Disconnects an established connection, or cancels a connection attempt
 * currently in progress.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 */

public void disconnect() { throw new RuntimeException("Stub!"); }

/**
 * Connect back to remote device.
 *
 * <p>This method is used to re-connect to a remote device after the
 * connection has been dropped. If the device is not in range, the
 * re-connection will be triggered once the device is back in range.
 *
 * @return true, if the connection attempt was initiated successfully
 */

public boolean connect() { throw new RuntimeException("Stub!"); }

/**
 * Set the preferred connection PHY for this app. Please note that this is just a
 * recommendation, whether the PHY change will happen depends on other applications preferences,
 * local and remote controller capabilities. Controller can override these settings.
 * <p>
 * {@link BluetoothGattCallback#onPhyUpdate} will be triggered as a result of this call, even
 * if no PHY change happens. It is also triggered when remote device updates the PHY.
 *
 * @param txPhy preferred transmitter PHY. Bitwise OR of any of {@link
 * BluetoothDevice#PHY_LE_1M_MASK}, {@link BluetoothDevice#PHY_LE_2M_MASK}, and {@link
 * BluetoothDevice#PHY_LE_CODED_MASK}.
 * @param rxPhy preferred receiver PHY. Bitwise OR of any of {@link
 * BluetoothDevice#PHY_LE_1M_MASK}, {@link BluetoothDevice#PHY_LE_2M_MASK}, and {@link
 * BluetoothDevice#PHY_LE_CODED_MASK}.
 * @param phyOptions preferred coding to use when transmitting on the LE Coded PHY. Can be one
 * of {@link BluetoothDevice#PHY_OPTION_NO_PREFERRED}, {@link BluetoothDevice#PHY_OPTION_S2} or
 * {@link BluetoothDevice#PHY_OPTION_S8}
 */

public void setPreferredPhy(int txPhy, int rxPhy, int phyOptions) { throw new RuntimeException("Stub!"); }

/**
 * Read the current transmitter PHY and receiver PHY of the connection. The values are returned
 * in {@link BluetoothGattCallback#onPhyRead}
 */

public void readPhy() { throw new RuntimeException("Stub!"); }

/**
 * Return the remote bluetooth device this GATT client targets to
 *
 * @return remote bluetooth device
 */

public android.bluetooth.BluetoothDevice getDevice() { throw new RuntimeException("Stub!"); }

/**
 * Discovers services offered by a remote device as well as their
 * characteristics and descriptors.
 *
 * <p>This is an asynchronous operation. Once service discovery is completed,
 * the {@link BluetoothGattCallback#onServicesDiscovered} callback is
 * triggered. If the discovery was successful, the remote services can be
 * retrieved using the {@link #getServices} function.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @return true, if the remote service discovery has been started
 */

public boolean discoverServices() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of GATT services offered by the remote device.
 *
 * <p>This function requires that service discovery has been completed
 * for the given device.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @return List of services on the remote device. Returns an empty list if service discovery has
 * not yet been performed.
 */

public java.util.List<android.bluetooth.BluetoothGattService> getServices() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link BluetoothGattService}, if the requested UUID is
 * supported by the remote device.
 *
 * <p>This function requires that service discovery has been completed
 * for the given device.
 *
 * <p>If multiple instances of the same service (as identified by UUID)
 * exist, the first instance of the service is returned.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param uuid UUID of the requested service
 * @return BluetoothGattService if supported, or null if the requested service is not offered by
 * the remote device.
 */

public android.bluetooth.BluetoothGattService getService(java.util.UUID uuid) { throw new RuntimeException("Stub!"); }

/**
 * Reads the requested characteristic from the associated remote device.
 *
 * <p>This is an asynchronous operation. The result of the read operation
 * is reported by the {@link BluetoothGattCallback#onCharacteristicRead}
 * callback.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param characteristic Characteristic to read from the remote device
 * @return true, if the read operation was initiated successfully
 */

public boolean readCharacteristic(android.bluetooth.BluetoothGattCharacteristic characteristic) { throw new RuntimeException("Stub!"); }

/**
 * Writes a given characteristic and its values to the associated remote device.
 *
 * <p>Once the write operation has been completed, the
 * {@link BluetoothGattCallback#onCharacteristicWrite} callback is invoked,
 * reporting the result of the operation.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param characteristic Characteristic to write on the remote device
 * @return true, if the write operation was initiated successfully
 */

public boolean writeCharacteristic(android.bluetooth.BluetoothGattCharacteristic characteristic) { throw new RuntimeException("Stub!"); }

/**
 * Reads the value for a given descriptor from the associated remote device.
 *
 * <p>Once the read operation has been completed, the
 * {@link BluetoothGattCallback#onDescriptorRead} callback is
 * triggered, signaling the result of the operation.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param descriptor Descriptor value to read from the remote device
 * @return true, if the read operation was initiated successfully
 */

public boolean readDescriptor(android.bluetooth.BluetoothGattDescriptor descriptor) { throw new RuntimeException("Stub!"); }

/**
 * Write the value of a given descriptor to the associated remote device.
 *
 * <p>A {@link BluetoothGattCallback#onDescriptorWrite} callback is
 * triggered to report the result of the write operation.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param descriptor Descriptor to write to the associated remote device
 * @return true, if the write operation was initiated successfully
 */

public boolean writeDescriptor(android.bluetooth.BluetoothGattDescriptor descriptor) { throw new RuntimeException("Stub!"); }

/**
 * Initiates a reliable write transaction for a given remote device.
 *
 * <p>Once a reliable write transaction has been initiated, all calls
 * to {@link #writeCharacteristic} are sent to the remote device for
 * verification and queued up for atomic execution. The application will
 * receive an {@link BluetoothGattCallback#onCharacteristicWrite} callback
 * in response to every {@link #writeCharacteristic} call and is responsible
 * for verifying if the value has been transmitted accurately.
 *
 * <p>After all characteristics have been queued up and verified,
 * {@link #executeReliableWrite} will execute all writes. If a characteristic
 * was not written correctly, calling {@link #abortReliableWrite} will
 * cancel the current transaction without commiting any values on the
 * remote device.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @return true, if the reliable write transaction has been initiated
 */

public boolean beginReliableWrite() { throw new RuntimeException("Stub!"); }

/**
 * Executes a reliable write transaction for a given remote device.
 *
 * <p>This function will commit all queued up characteristic write
 * operations for a given remote device.
 *
 * <p>A {@link BluetoothGattCallback#onReliableWriteCompleted} callback is
 * invoked to indicate whether the transaction has been executed correctly.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @return true, if the request to execute the transaction has been sent
 */

public boolean executeReliableWrite() { throw new RuntimeException("Stub!"); }

/**
 * Cancels a reliable write transaction for a given device.
 *
 * <p>Calling this function will discard all queued characteristic write
 * operations for a given remote device.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 */

public void abortReliableWrite() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #abortReliableWrite()}
 */

@Deprecated public void abortReliableWrite(android.bluetooth.BluetoothDevice mDevice) { throw new RuntimeException("Stub!"); }

/**
 * Enable or disable notifications/indications for a given characteristic.
 *
 * <p>Once notifications are enabled for a characteristic, a
 * {@link BluetoothGattCallback#onCharacteristicChanged} callback will be
 * triggered if the remote device indicates that the given characteristic
 * has changed.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @param characteristic The characteristic for which to enable notifications
 * @param enable Set to true to enable notifications/indications
 * @return true, if the requested notification status was set successfully
 */

public boolean setCharacteristicNotification(android.bluetooth.BluetoothGattCharacteristic characteristic, boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * Read the RSSI for a connected remote device.
 *
 * <p>The {@link BluetoothGattCallback#onReadRemoteRssi} callback will be
 * invoked when the RSSI value has been read.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @return true, if the RSSI value has been requested successfully
 */

public boolean readRemoteRssi() { throw new RuntimeException("Stub!"); }

/**
 * Request an MTU size used for a given connection.
 *
 * <p>When performing a write request operation (write without response),
 * the data sent is truncated to the MTU size. This function may be used
 * to request a larger MTU size to be able to send more data at once.
 *
 * <p>A {@link BluetoothGattCallback#onMtuChanged} callback will indicate
 * whether this operation was successful.
 *
 * <p>Requires {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * @return true, if the new MTU value has been requested successfully
 */

public boolean requestMtu(int mtu) { throw new RuntimeException("Stub!"); }

/**
 * Request a connection parameter update.
 *
 * <p>This function will send a connection parameter update request to the
 * remote device.
 *
 * @param connectionPriority Request a specific connection priority. Must be one of {@link
 * BluetoothGatt#CONNECTION_PRIORITY_BALANCED}, {@link BluetoothGatt#CONNECTION_PRIORITY_HIGH}
 * or {@link BluetoothGatt#CONNECTION_PRIORITY_LOW_POWER}.
 * @throws IllegalArgumentException If the parameters are outside of their specified range.
 */

public boolean requestConnectionPriority(int connectionPriority) { throw new RuntimeException("Stub!"); }

/**
 * Not supported - please use {@link BluetoothManager#getConnectedDevices(int)}
 * with {@link BluetoothProfile#GATT} as argument
 *
 * @throws UnsupportedOperationException
 */

public int getConnectionState(android.bluetooth.BluetoothDevice device) { throw new RuntimeException("Stub!"); }

/**
 * Not supported - please use {@link BluetoothManager#getConnectedDevices(int)}
 * with {@link BluetoothProfile#GATT} as argument
 *
 * @throws UnsupportedOperationException
 */

public java.util.List<android.bluetooth.BluetoothDevice> getConnectedDevices() { throw new RuntimeException("Stub!"); }

/**
 * Not supported - please use
 * {@link BluetoothManager#getDevicesMatchingConnectionStates(int, int[])}
 * with {@link BluetoothProfile#GATT} as first argument
 *
 * @throws UnsupportedOperationException
 */

public java.util.List<android.bluetooth.BluetoothDevice> getDevicesMatchingConnectionStates(int[] states) { throw new RuntimeException("Stub!"); }

/**
 * Connection parameter update - Use the connection parameters recommended by the
 * Bluetooth SIG. This is the default value if no connection parameter update
 * is requested.
 */

public static final int CONNECTION_PRIORITY_BALANCED = 0; // 0x0

/**
 * Connection parameter update - Request a high priority, low latency connection.
 * An application should only request high priority connection parameters to transfer large
 * amounts of data over LE quickly. Once the transfer is complete, the application should
 * request {@link BluetoothGatt#CONNECTION_PRIORITY_BALANCED} connection parameters to reduce
 * energy use.
 */

public static final int CONNECTION_PRIORITY_HIGH = 1; // 0x1

/** Connection parameter update - Request low power, reduced data rate connection parameters. */

public static final int CONNECTION_PRIORITY_LOW_POWER = 2; // 0x2

/** A remote device connection is congested. */

public static final int GATT_CONNECTION_CONGESTED = 143; // 0x8f

/** A GATT operation failed, errors other than the above */

public static final int GATT_FAILURE = 257; // 0x101

/** Insufficient authentication for a given operation */

public static final int GATT_INSUFFICIENT_AUTHENTICATION = 5; // 0x5

/** Insufficient encryption for a given operation */

public static final int GATT_INSUFFICIENT_ENCRYPTION = 15; // 0xf

/** A write operation exceeds the maximum length of the attribute */

public static final int GATT_INVALID_ATTRIBUTE_LENGTH = 13; // 0xd

/** A read or write operation was requested with an invalid offset */

public static final int GATT_INVALID_OFFSET = 7; // 0x7

/** GATT read operation is not permitted */

public static final int GATT_READ_NOT_PERMITTED = 2; // 0x2

/** The given request is not supported */

public static final int GATT_REQUEST_NOT_SUPPORTED = 6; // 0x6

/** A GATT operation completed successfully */

public static final int GATT_SUCCESS = 0; // 0x0

/** GATT write operation is not permitted */

public static final int GATT_WRITE_NOT_PERMITTED = 3; // 0x3
}

