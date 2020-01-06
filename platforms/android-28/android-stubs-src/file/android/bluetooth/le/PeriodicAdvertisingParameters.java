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


package android.bluetooth.le;


/**
 * The {@link PeriodicAdvertisingParameters} provide a way to adjust periodic
 * advertising preferences for each Bluetooth LE advertising set. Use {@link
 * AdvertisingSetParameters.Builder} to create an instance of this class.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PeriodicAdvertisingParameters implements android.os.Parcelable {

PeriodicAdvertisingParameters(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the TX Power will be included.
 */

public boolean getIncludeTxPower() { throw new RuntimeException("Stub!"); }

/**
 * Returns the periodic advertising interval, in 1.25ms unit.
 * Valid values are from 80 (100ms) to 65519 (81.89875s).
 */

public int getInterval() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.bluetooth.le.PeriodicAdvertisingParameters> CREATOR;
static { CREATOR = null; }
@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Whether the transmission power level should be included in the periodic
 * packet.
 */

public android.bluetooth.le.PeriodicAdvertisingParameters.Builder setIncludeTxPower(boolean includeTxPower) { throw new RuntimeException("Stub!"); }

/**
 * Set advertising interval for periodic advertising, in 1.25ms unit.
 * Valid values are from 80 (100ms) to 65519 (81.89875s).
 * Value from range [interval, interval+20ms] will be picked as the actual value.
 *
 * @throws IllegalArgumentException If the interval is invalid.
 */

public android.bluetooth.le.PeriodicAdvertisingParameters.Builder setInterval(int interval) { throw new RuntimeException("Stub!"); }

/**
 * Build the {@link AdvertisingSetParameters} object.
 */

public android.bluetooth.le.PeriodicAdvertisingParameters build() { throw new RuntimeException("Stub!"); }
}

}

