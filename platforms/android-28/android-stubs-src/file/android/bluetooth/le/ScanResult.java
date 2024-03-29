/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.bluetooth.le;

import android.bluetooth.BluetoothDevice;

/**
 * ScanResult for Bluetooth LE scan.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScanResult implements android.os.Parcelable {

/**
 * Constructs a new ScanResult.
 *
 * @param device Remote Bluetooth device found.
 * @param scanRecord Scan record including both advertising data and scan response data.
 * @param rssi Received signal strength.
 * @param timestampNanos Timestamp at which the scan result was observed.
 * @deprecated use {@link #ScanResult(BluetoothDevice, int, int, int, int, int, int, int,
 * ScanRecord, long)}
 */

@Deprecated public ScanResult(android.bluetooth.BluetoothDevice device, android.bluetooth.le.ScanRecord scanRecord, int rssi, long timestampNanos) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new ScanResult.
 *
 * @param device Remote Bluetooth device found.
 * @param eventType Event type.
 * @param primaryPhy Primary advertising phy.
 * @param secondaryPhy Secondary advertising phy.
 * @param advertisingSid Advertising set ID.
 * @param txPower Transmit power.
 * @param rssi Received signal strength.
 * @param periodicAdvertisingInterval Periodic advertising interval.
 * @param scanRecord Scan record including both advertising data and scan response data.
 * @param timestampNanos Timestamp at which the scan result was observed.
 */

public ScanResult(android.bluetooth.BluetoothDevice device, int eventType, int primaryPhy, int secondaryPhy, int advertisingSid, int txPower, int rssi, int periodicAdvertisingInterval, android.bluetooth.le.ScanRecord scanRecord, long timestampNanos) { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Returns the remote Bluetooth device identified by the Bluetooth device address.
 */

public android.bluetooth.BluetoothDevice getDevice() { throw new RuntimeException("Stub!"); }

/**
 * Returns the scan record, which is a combination of advertisement and scan response.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.bluetooth.le.ScanRecord getScanRecord() { throw new RuntimeException("Stub!"); }

/**
 * Returns the received signal strength in dBm. The valid range is [-127, 126].
 */

public int getRssi() { throw new RuntimeException("Stub!"); }

/**
 * Returns timestamp since boot when the scan record was observed.
 */

public long getTimestampNanos() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this object represents legacy scan result.
 * Legacy scan results do not contain advanced advertising information
 * as specified in the Bluetooth Core Specification v5.
 */

public boolean isLegacy() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this object represents connectable scan result.
 */

public boolean isConnectable() { throw new RuntimeException("Stub!"); }

/**
 * Returns the data status.
 * Can be one of {@link ScanResult#DATA_COMPLETE} or
 * {@link ScanResult#DATA_TRUNCATED}.
 */

public int getDataStatus() { throw new RuntimeException("Stub!"); }

/**
 * Returns the primary Physical Layer
 * on which this advertisment was received.
 * Can be one of {@link BluetoothDevice#PHY_LE_1M} or
 * {@link BluetoothDevice#PHY_LE_CODED}.
 */

public int getPrimaryPhy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the secondary Physical Layer
 * on which this advertisment was received.
 * Can be one of {@link BluetoothDevice#PHY_LE_1M},
 * {@link BluetoothDevice#PHY_LE_2M}, {@link BluetoothDevice#PHY_LE_CODED}
 * or {@link ScanResult#PHY_UNUSED} - if the advertisement
 * was not received on a secondary physical channel.
 */

public int getSecondaryPhy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the advertising set id.
 * May return {@link ScanResult#SID_NOT_PRESENT} if
 * no set id was is present.
 */

public int getAdvertisingSid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the transmit power in dBm.
 * Valid range is [-127, 126]. A value of {@link ScanResult#TX_POWER_NOT_PRESENT}
 * indicates that the TX power is not present.
 */

public int getTxPower() { throw new RuntimeException("Stub!"); }

/**
 * Returns the periodic advertising interval in units of 1.25ms.
 * Valid range is 6 (7.5ms) to 65536 (81918.75ms). A value of
 * {@link ScanResult#PERIODIC_INTERVAL_NOT_PRESENT} means periodic
 * advertising interval is not present.
 */

public int getPeriodicAdvertisingInterval() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.bluetooth.le.ScanResult> CREATOR;
static { CREATOR = null; }

/**
 * For chained advertisements, inidcates tha the data contained in this
 * scan result is complete.
 */

public static final int DATA_COMPLETE = 0; // 0x0

/**
 * For chained advertisements, indicates that the controller was
 * unable to receive all chained packets and the scan result contains
 * incomplete truncated data.
 */

public static final int DATA_TRUNCATED = 2; // 0x2

/**
 * Periodic advertising interval is not present in the packet.
 */

public static final int PERIODIC_INTERVAL_NOT_PRESENT = 0; // 0x0

/**
 * Indicates that the secondary physical layer was not used.
 */

public static final int PHY_UNUSED = 0; // 0x0

/**
 * Advertising Set ID is not present in the packet.
 */

public static final int SID_NOT_PRESENT = 255; // 0xff

/**
 * TX power is not present in the packet.
 */

public static final int TX_POWER_NOT_PRESENT = 127; // 0x7f
}

