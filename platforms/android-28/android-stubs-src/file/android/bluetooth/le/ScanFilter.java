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

import java.util.UUID;
import android.os.Parcel;
import android.os.Parcelable;
import android.bluetooth.BluetoothAdapter;

/**
 * Criteria for filtering result from Bluetooth LE scans. A {@link ScanFilter} allows clients to
 * restrict scan results to only those that are of interest to them.
 * <p>
 * Current filtering on the following fields are supported:
 * <li>Service UUIDs which identify the bluetooth gatt services running on the device.
 * <li>Name of remote Bluetooth LE device.
 * <li>Mac address of the remote device.
 * <li>Service data which is the data associated with a service.
 * <li>Manufacturer specific data which is the data associated with a particular manufacturer.
 *
 * @see ScanResult
 * @see BluetoothLeScanner
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScanFilter implements android.os.Parcelable {

ScanFilter(java.lang.String name, java.lang.String deviceAddress, android.os.ParcelUuid uuid, android.os.ParcelUuid uuidMask, android.os.ParcelUuid serviceDataUuid, byte[] serviceData, byte[] serviceDataMask, int manufacturerId, byte[] manufacturerData, byte[] manufacturerDataMask) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the filter set the device name field of Bluetooth advertisement data.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getDeviceName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the filter set on the service uuid.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.ParcelUuid getServiceUuid() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.ParcelUuid getServiceUuidMask() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getDeviceAddress() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public byte[] getServiceData() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public byte[] getServiceDataMask() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.ParcelUuid getServiceDataUuid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the manufacturer id. -1 if the manufacturer filter is not set.
 */

public int getManufacturerId() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public byte[] getManufacturerData() { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public byte[] getManufacturerDataMask() { throw new RuntimeException("Stub!"); }

/**
 * Check if the scan filter matches a {@code scanResult}. A scan result is considered as a match
 * if it matches all the field filters.
 */

public boolean matches(android.bluetooth.le.ScanResult scanResult) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * A {@link android.os.Parcelable.Creator} to create {@link ScanFilter} from parcel.
 */

public static final android.os.Parcelable.Creator<android.bluetooth.le.ScanFilter> CREATOR;
static { CREATOR = null; }
/**
 * Builder class for {@link ScanFilter}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Set filter on device name.
 */

public android.bluetooth.le.ScanFilter.Builder setDeviceName(java.lang.String deviceName) { throw new RuntimeException("Stub!"); }

/**
 * Set filter on device address.
 *
 * @param deviceAddress The device Bluetooth address for the filter. It needs to be in the
 * format of "01:02:03:AB:CD:EF". The device address can be validated using {@link
 * BluetoothAdapter#checkBluetoothAddress}.
 * @throws IllegalArgumentException If the {@code deviceAddress} is invalid.
 */

public android.bluetooth.le.ScanFilter.Builder setDeviceAddress(java.lang.String deviceAddress) { throw new RuntimeException("Stub!"); }

/**
 * Set filter on service uuid.
 */

public android.bluetooth.le.ScanFilter.Builder setServiceUuid(android.os.ParcelUuid serviceUuid) { throw new RuntimeException("Stub!"); }

/**
 * Set filter on partial service uuid. The {@code uuidMask} is the bit mask for the
 * {@code serviceUuid}. Set any bit in the mask to 1 to indicate a match is needed for the
 * bit in {@code serviceUuid}, and 0 to ignore that bit.
 *
 * @throws IllegalArgumentException If {@code serviceUuid} is {@code null} but {@code
 * uuidMask} is not {@code null}.
 */

public android.bluetooth.le.ScanFilter.Builder setServiceUuid(android.os.ParcelUuid serviceUuid, android.os.ParcelUuid uuidMask) { throw new RuntimeException("Stub!"); }

/**
 * Set filtering on service data.
 *
 * @throws IllegalArgumentException If {@code serviceDataUuid} is null.
 */

public android.bluetooth.le.ScanFilter.Builder setServiceData(android.os.ParcelUuid serviceDataUuid, byte[] serviceData) { throw new RuntimeException("Stub!"); }

/**
 * Set partial filter on service data. For any bit in the mask, set it to 1 if it needs to
 * match the one in service data, otherwise set it to 0 to ignore that bit.
 * <p>
 * The {@code serviceDataMask} must have the same length of the {@code serviceData}.
 *
 * @throws IllegalArgumentException If {@code serviceDataUuid} is null or {@code
 * serviceDataMask} is {@code null} while {@code serviceData} is not or {@code
 * serviceDataMask} and {@code serviceData} has different length.
 */

public android.bluetooth.le.ScanFilter.Builder setServiceData(android.os.ParcelUuid serviceDataUuid, byte[] serviceData, byte[] serviceDataMask) { throw new RuntimeException("Stub!"); }

/**
 * Set filter on on manufacturerData. A negative manufacturerId is considered as invalid id.
 * <p>
 * Note the first two bytes of the {@code manufacturerData} is the manufacturerId.
 *
 * @throws IllegalArgumentException If the {@code manufacturerId} is invalid.
 */

public android.bluetooth.le.ScanFilter.Builder setManufacturerData(int manufacturerId, byte[] manufacturerData) { throw new RuntimeException("Stub!"); }

/**
 * Set filter on partial manufacture data. For any bit in the mask, set it the 1 if it needs
 * to match the one in manufacturer data, otherwise set it to 0.
 * <p>
 * The {@code manufacturerDataMask} must have the same length of {@code manufacturerData}.
 *
 * @throws IllegalArgumentException If the {@code manufacturerId} is invalid, or {@code
 * manufacturerData} is null while {@code manufacturerDataMask} is not, or {@code
 * manufacturerData} and {@code manufacturerDataMask} have different length.
 */

public android.bluetooth.le.ScanFilter.Builder setManufacturerData(int manufacturerId, byte[] manufacturerData, byte[] manufacturerDataMask) { throw new RuntimeException("Stub!"); }

/**
 * Build {@link ScanFilter}.
 *
 * @throws IllegalArgumentException If the filter cannot be built.
 */

public android.bluetooth.le.ScanFilter build() { throw new RuntimeException("Stub!"); }
}

}

