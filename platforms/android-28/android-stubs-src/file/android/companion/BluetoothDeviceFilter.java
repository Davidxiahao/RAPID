/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.companion;

import android.bluetooth.BluetoothDevice;

/**
 * A filter for Bluetooth(non-LE) devices
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothDeviceFilter implements android.companion.DeviceFilter<android.bluetooth.BluetoothDevice> {

BluetoothDeviceFilter(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.companion.BluetoothDeviceFilter> CREATOR;
static { CREATOR = null; }
/**
 * A builder for {@link BluetoothDeviceFilter}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * @param regex if set, only devices with {@link BluetoothDevice#getName name} matching the
 *              given regular expression will be shown

 * This value may be {@code null}.
 */

public android.companion.BluetoothDeviceFilter.Builder setNamePattern(@androidx.annotation.RecentlyNullable java.util.regex.Pattern regex) { throw new RuntimeException("Stub!"); }

/**
 * @param address if set, only devices with MAC address exactly matching the given one will
 *                pass the filter
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.companion.BluetoothDeviceFilter.Builder setAddress(@androidx.annotation.RecentlyNullable java.lang.String address) { throw new RuntimeException("Stub!"); }

/**
 * Add filtering by certain bits of {@link BluetoothDevice#getUuids()}
 *
 * A device with any uuid matching the given bits is considered passing
 *
 * @param serviceUuid the values for the bits to match
 * This value may be {@code null}.
 * @param serviceUuidMask if provided, only those bits would have to match.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.companion.BluetoothDeviceFilter.Builder addServiceUuid(@androidx.annotation.RecentlyNullable android.os.ParcelUuid serviceUuid, @androidx.annotation.RecentlyNullable android.os.ParcelUuid serviceUuidMask) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.companion.BluetoothDeviceFilter build() { throw new RuntimeException("Stub!"); }

protected void markUsed() { throw new RuntimeException("Stub!"); }

protected void checkNotUsed() { throw new RuntimeException("Stub!"); }
}

}

