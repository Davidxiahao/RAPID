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

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Signal strength related information.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellSignalStrengthCdma extends android.telephony.CellSignalStrength implements android.os.Parcelable {

/** @hide */

CellSignalStrengthCdma() { throw new RuntimeException("Stub!"); }

/**
 * Get signal level as an int from 0..4
 */

public int getLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the signal level as an asu value between 0..97, 99 is unknown
 */

public int getAsuLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get cdma as level 0..4
 */

public int getCdmaLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get Evdo as level 0..4
 */

public int getEvdoLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the signal strength as dBm
 */

public int getDbm() { throw new RuntimeException("Stub!"); }

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

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * @return string representation.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public static final android.os.Parcelable.Creator<android.telephony.CellSignalStrengthCdma> CREATOR;
static { CREATOR = null; }
}

