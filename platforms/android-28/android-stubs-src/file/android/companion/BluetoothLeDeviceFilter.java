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

import android.bluetooth.le.ScanFilter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;

/**
 * A filter for Bluetooth LE devices
 *
 * @see ScanFilter
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothLeDeviceFilter implements android.companion.DeviceFilter<android.bluetooth.le.ScanResult> {

BluetoothLeDeviceFilter(java.util.regex.Pattern namePattern, android.bluetooth.le.ScanFilter scanFilter, byte[] rawDataFilter, byte[] rawDataFilterMask, java.lang.String renamePrefix, java.lang.String renameSuffix, int renameBytesFrom, int renameBytesLength, int renameNameFrom, int renameNameLength, boolean renameBytesReverseOrder) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static int getRenamePrefixLengthLimit() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.companion.BluetoothLeDeviceFilter> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link BluetoothLeDeviceFilter}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * @param regex if set, only devices with {@link BluetoothDevice#getName name} matching the
 *              given regular expression will be shown
 * This value may be {@code null}.
 * @return self for chaining
 */

public android.companion.BluetoothLeDeviceFilter.Builder setNamePattern(@androidx.annotation.RecentlyNullable java.util.regex.Pattern regex) { throw new RuntimeException("Stub!"); }

/**
 * @param scanFilter a {@link ScanFilter} to filter devices by
 *
 * This value may be {@code null}.
 * @return self for chaining
 * This value will never be {@code null}.
 * @see ScanFilter for specific details on its various fields
 */

@androidx.annotation.RecentlyNonNull public android.companion.BluetoothLeDeviceFilter.Builder setScanFilter(@androidx.annotation.RecentlyNullable android.bluetooth.le.ScanFilter scanFilter) { throw new RuntimeException("Stub!"); }

/**
 * Filter devices by raw advertisement data, as obtained by {@link ScanRecord#getBytes}
 *
 * @param rawDataFilter bit values that have to match against advertized data
 * This value must never be {@code null}.
 * @param rawDataFilterMask bits that have to be matched
 * This value may be {@code null}.
 * @return self for chaining
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.companion.BluetoothLeDeviceFilter.Builder setRawDataFilter(@androidx.annotation.RecentlyNonNull byte[] rawDataFilter, @androidx.annotation.RecentlyNullable byte[] rawDataFilterMask) { throw new RuntimeException("Stub!"); }

/**
 * Rename the devices shown in the list, using specific bytes from the raw advertisement
 * data ({@link ScanRecord#getBytes}) in hexadecimal format, as well as a custom
 * prefix/suffix around them
 *
 * Note that the prefix length is limited to {@link #getRenamePrefixLengthLimit} characters
 * to ensure that there's enough space to display the byte data
 *
 * The range of bytes to be displayed cannot be empty
 *
 * @param prefix to be displayed before the byte data
 * This value must never be {@code null}.
 * @param suffix to be displayed after the byte data
 * This value must never be {@code null}.
 * @param bytesFrom the start byte index to be displayed (inclusive)
 * @param bytesLength the number of bytes to be displayed from the given index
 * @param byteOrder whether the given range of bytes is big endian (will be displayed
 *                   in same order) or little endian (will be flipped before displaying)
 * @return self for chaining
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.companion.BluetoothLeDeviceFilter.Builder setRenameFromBytes(@androidx.annotation.RecentlyNonNull java.lang.String prefix, @androidx.annotation.RecentlyNonNull java.lang.String suffix, int bytesFrom, int bytesLength, java.nio.ByteOrder byteOrder) { throw new RuntimeException("Stub!"); }

/**
 * Rename the devices shown in the list, using specific characters from the advertised name,
 * as well as a custom prefix/suffix around them
 *
 * Note that the prefix length is limited to {@link #getRenamePrefixLengthLimit} characters
 * to ensure that there's enough space to display the byte data
 *
 * The range of name characters to be displayed cannot be empty
 *
 * @param prefix to be displayed before the byte data
 * This value must never be {@code null}.
 * @param suffix to be displayed after the byte data
 * This value must never be {@code null}.
 * @param nameFrom the start name character index to be displayed (inclusive)
 * @param nameLength the number of characters to be displayed from the given index
 * @return self for chaining
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.companion.BluetoothLeDeviceFilter.Builder setRenameFromName(@androidx.annotation.RecentlyNonNull java.lang.String prefix, @androidx.annotation.RecentlyNonNull java.lang.String suffix, int nameFrom, int nameLength) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.companion.BluetoothLeDeviceFilter build() { throw new RuntimeException("Stub!"); }

protected void markUsed() { throw new RuntimeException("Stub!"); }

protected void checkNotUsed() { throw new RuntimeException("Stub!"); }
}

}

