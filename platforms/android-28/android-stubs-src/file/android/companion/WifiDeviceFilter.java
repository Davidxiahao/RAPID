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

/**
 * A filter for Wifi devices
 *
 * @see ScanFilter
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class WifiDeviceFilter implements android.companion.DeviceFilter<android.net.wifi.ScanResult> {

WifiDeviceFilter(java.util.regex.Pattern namePattern) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.companion.WifiDeviceFilter> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link WifiDeviceFilter}
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

public android.companion.WifiDeviceFilter.Builder setNamePattern(@androidx.annotation.RecentlyNullable java.util.regex.Pattern regex) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.companion.WifiDeviceFilter build() { throw new RuntimeException("Stub!"); }

protected void markUsed() { throw new RuntimeException("Stub!"); }

protected void checkNotUsed() { throw new RuntimeException("Stub!"); }
}

}

