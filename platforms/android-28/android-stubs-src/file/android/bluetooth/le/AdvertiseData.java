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


/**
 * Advertise data packet container for Bluetooth LE advertising. This represents the data to be
 * advertised as well as the scan response data for active scans.
 * <p>
 * Use {@link AdvertiseData.Builder} to create an instance of {@link AdvertiseData} to be
 * advertised.
 *
 * @see BluetoothLeAdvertiser
 * @see ScanRecord
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AdvertiseData implements android.os.Parcelable {

AdvertiseData(java.util.List<android.os.ParcelUuid> serviceUuids, android.util.SparseArray<byte[]> manufacturerData, java.util.Map<android.os.ParcelUuid,byte[]> serviceData, boolean includeTxPowerLevel, boolean includeDeviceName) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of service UUIDs within the advertisement that are used to identify the
 * Bluetooth GATT services.
 */

public java.util.List<android.os.ParcelUuid> getServiceUuids() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of manufacturer Id and the corresponding manufacturer specific data. The
 * manufacturer id is a non-negative number assigned by Bluetooth SIG.
 */

public android.util.SparseArray<byte[]> getManufacturerSpecificData() { throw new RuntimeException("Stub!"); }

/**
 * Returns a map of 16-bit UUID and its corresponding service data.
 */

public java.util.Map<android.os.ParcelUuid, byte[]> getServiceData() { throw new RuntimeException("Stub!"); }

/**
 * Whether the transmission power level will be included in the advertisement packet.
 */

public boolean getIncludeTxPowerLevel() { throw new RuntimeException("Stub!"); }

/**
 * Whether the device name will be included in the advertisement packet.
 */

public boolean getIncludeDeviceName() { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.bluetooth.le.AdvertiseData> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link AdvertiseData}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Add a service UUID to advertise data.
 *
 * @param serviceUuid A service UUID to be advertised.
 * @throws IllegalArgumentException If the {@code serviceUuids} are null.
 */

public android.bluetooth.le.AdvertiseData.Builder addServiceUuid(android.os.ParcelUuid serviceUuid) { throw new RuntimeException("Stub!"); }

/**
 * Add service data to advertise data.
 *
 * @param serviceDataUuid 16-bit UUID of the service the data is associated with
 * @param serviceData Service data
 * @throws IllegalArgumentException If the {@code serviceDataUuid} or {@code serviceData} is
 * empty.
 */

public android.bluetooth.le.AdvertiseData.Builder addServiceData(android.os.ParcelUuid serviceDataUuid, byte[] serviceData) { throw new RuntimeException("Stub!"); }

/**
 * Add manufacturer specific data.
 * <p>
 * Please refer to the Bluetooth Assigned Numbers document provided by the <a
 * href="https://www.bluetooth.org">Bluetooth SIG</a> for a list of existing company
 * identifiers.
 *
 * @param manufacturerId Manufacturer ID assigned by Bluetooth SIG.
 * @param manufacturerSpecificData Manufacturer specific data
 * @throws IllegalArgumentException If the {@code manufacturerId} is negative or {@code
 * manufacturerSpecificData} is null.
 */

public android.bluetooth.le.AdvertiseData.Builder addManufacturerData(int manufacturerId, byte[] manufacturerSpecificData) { throw new RuntimeException("Stub!"); }

/**
 * Whether the transmission power level should be included in the advertise packet. Tx power
 * level field takes 3 bytes in advertise packet.
 */

public android.bluetooth.le.AdvertiseData.Builder setIncludeTxPowerLevel(boolean includeTxPowerLevel) { throw new RuntimeException("Stub!"); }

/**
 * Set whether the device name should be included in advertise packet.
 */

public android.bluetooth.le.AdvertiseData.Builder setIncludeDeviceName(boolean includeDeviceName) { throw new RuntimeException("Stub!"); }

/**
 * Build the {@link AdvertiseData}.
 */

public android.bluetooth.le.AdvertiseData build() { throw new RuntimeException("Stub!"); }
}

}

