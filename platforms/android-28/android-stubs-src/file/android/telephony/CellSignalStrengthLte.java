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
 * LTE signal strength related information.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellSignalStrengthLte extends android.telephony.CellSignalStrength implements android.os.Parcelable {

/** @hide */

CellSignalStrengthLte() { throw new RuntimeException("Stub!"); }

/**
 * Get signal level as an int from 0..4
 */

public int getLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get reference signal received quality
 */

public int getRsrq() { throw new RuntimeException("Stub!"); }

/**
 * Get reference signal signal-to-noise ratio
 */

public int getRssnr() { throw new RuntimeException("Stub!"); }

/**
 * Get reference signal received power
 */

public int getRsrp() { throw new RuntimeException("Stub!"); }

/**
 * Get channel quality indicator
 */

public int getCqi() { throw new RuntimeException("Stub!"); }

/**
 * Get signal strength as dBm
 */

public int getDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the LTE signal level as an asu value between 0..97, 99 is unknown
 * Asu is calculated based on 3GPP RSRP. Refer to 3GPP 27.007 (Ver 10.3.0) Sec 8.69
 */

public int getAsuLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the timing advance value for LTE, as a value in range of 0..1282.
 * Integer.MAX_VALUE is reported when there is no active RRC
 * connection. Refer to 3GPP 36.213 Sec 4.2.3
 * @return the LTE timing advance, if available.
 */

public int getTimingAdvance() { throw new RuntimeException("Stub!"); }

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

public static final android.os.Parcelable.Creator<android.telephony.CellSignalStrengthLte> CREATOR;
static { CREATOR = null; }
}

