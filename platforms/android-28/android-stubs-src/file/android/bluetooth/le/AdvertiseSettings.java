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
 * The {@link AdvertiseSettings} provide a way to adjust advertising preferences for each
 * Bluetooth LE advertisement instance. Use {@link AdvertiseSettings.Builder} to create an
 * instance of this class.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AdvertiseSettings implements android.os.Parcelable {

AdvertiseSettings(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Returns the advertise mode.
 */

public int getMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the TX power level for advertising.
 */

public int getTxPowerLevel() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the advertisement will indicate connectable.
 */

public boolean isConnectable() { throw new RuntimeException("Stub!"); }

/**
 * Returns the advertising time limit in milliseconds.
 */

public int getTimeout() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Perform Bluetooth LE advertising in balanced power mode. This is balanced between advertising
 * frequency and power consumption.
 */

public static final int ADVERTISE_MODE_BALANCED = 1; // 0x1

/**
 * Perform Bluetooth LE advertising in low latency, high power mode. This has the highest power
 * consumption and should not be used for continuous background advertising.
 */

public static final int ADVERTISE_MODE_LOW_LATENCY = 2; // 0x2

/**
 * Perform Bluetooth LE advertising in low power mode. This is the default and preferred
 * advertising mode as it consumes the least power.
 */

public static final int ADVERTISE_MODE_LOW_POWER = 0; // 0x0

/**
 * Advertise using high TX power level. This corresponds to largest visibility range of the
 * advertising packet.
 */

public static final int ADVERTISE_TX_POWER_HIGH = 3; // 0x3

/**
 * Advertise using low TX power level.
 */

public static final int ADVERTISE_TX_POWER_LOW = 1; // 0x1

/**
 * Advertise using medium TX power level.
 */

public static final int ADVERTISE_TX_POWER_MEDIUM = 2; // 0x2

/**
 * Advertise using the lowest transmission (TX) power level. Low transmission power can be used
 * to restrict the visibility range of advertising packets.
 */

public static final int ADVERTISE_TX_POWER_ULTRA_LOW = 0; // 0x0

public static final android.os.Parcelable.Creator<android.bluetooth.le.AdvertiseSettings> CREATOR;
static { CREATOR = null; }
/**
 * Builder class for {@link AdvertiseSettings}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Set advertise mode to control the advertising power and latency.
 *
 * @param advertiseMode Bluetooth LE Advertising mode, can only be one of {@link
 * AdvertiseSettings#ADVERTISE_MODE_LOW_POWER},
 * {@link AdvertiseSettings#ADVERTISE_MODE_BALANCED},
 * or {@link AdvertiseSettings#ADVERTISE_MODE_LOW_LATENCY}.
 * @throws IllegalArgumentException If the advertiseMode is invalid.
 */

public android.bluetooth.le.AdvertiseSettings.Builder setAdvertiseMode(int advertiseMode) { throw new RuntimeException("Stub!"); }

/**
 * Set advertise TX power level to control the transmission power level for the advertising.
 *
 * @param txPowerLevel Transmission power of Bluetooth LE Advertising, can only be one of
 * {@link AdvertiseSettings#ADVERTISE_TX_POWER_ULTRA_LOW}, {@link
 * AdvertiseSettings#ADVERTISE_TX_POWER_LOW},
 * {@link AdvertiseSettings#ADVERTISE_TX_POWER_MEDIUM}
 * or {@link AdvertiseSettings#ADVERTISE_TX_POWER_HIGH}.
 * @throws IllegalArgumentException If the {@code txPowerLevel} is invalid.
 */

public android.bluetooth.le.AdvertiseSettings.Builder setTxPowerLevel(int txPowerLevel) { throw new RuntimeException("Stub!"); }

/**
 * Set whether the advertisement type should be connectable or non-connectable.
 *
 * @param connectable Controls whether the advertisment type will be connectable (true) or
 * non-connectable (false).
 */

public android.bluetooth.le.AdvertiseSettings.Builder setConnectable(boolean connectable) { throw new RuntimeException("Stub!"); }

/**
 * Limit advertising to a given amount of time.
 *
 * @param timeoutMillis Advertising time limit. May not exceed 180000 milliseconds. A value
 * of 0 will disable the time limit.
 * @throws IllegalArgumentException If the provided timeout is over 180000 ms.
 */

public android.bluetooth.le.AdvertiseSettings.Builder setTimeout(int timeoutMillis) { throw new RuntimeException("Stub!"); }

/**
 * Build the {@link AdvertiseSettings} object.
 */

public android.bluetooth.le.AdvertiseSettings build() { throw new RuntimeException("Stub!"); }
}

}

