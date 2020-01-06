/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.telephony;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Contains phone signal strength related information.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SignalStrength implements android.os.Parcelable {

/**
 * Empty constructor
 *
 * @hide
 */

SignalStrength() { throw new RuntimeException("Stub!"); }

/**
 * {@link Parcelable#writeToParcel}
 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@link Parcelable#describeContents}
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Get the GSM Signal Strength, valid values are (0-31, 99) as defined in TS
 * 27.007 8.5
 */

public int getGsmSignalStrength() { throw new RuntimeException("Stub!"); }

/**
 * Get the GSM bit error rate (0-7, 99) as defined in TS 27.007 8.5
 */

public int getGsmBitErrorRate() { throw new RuntimeException("Stub!"); }

/**
 * Get the CDMA RSSI value in dBm
 */

public int getCdmaDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the CDMA Ec/Io value in dB*10
 */

public int getCdmaEcio() { throw new RuntimeException("Stub!"); }

/**
 * Get the EVDO RSSI value in dBm
 */

public int getEvdoDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the EVDO Ec/Io value in dB*10
 */

public int getEvdoEcio() { throw new RuntimeException("Stub!"); }

/**
 * Get the signal to noise ratio. Valid values are 0-8. 8 is the highest.
 */

public int getEvdoSnr() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve an abstract level value for the overall signal strength.
 *
 * @return a single integer from 0 to 4 representing the general signal quality.
 *     This may take into account many different radio technology inputs.
 *     0 represents very poor signal strength
 *     while 4 represents a very strong signal strength.
 */

public int getLevel() { throw new RuntimeException("Stub!"); }

/**
 * @return true if this is for GSM
 */

public boolean isGsm() { throw new RuntimeException("Stub!"); }

/**
 * @return hash code
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * @return true if the signal strengths are the same
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * @return string representation.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

