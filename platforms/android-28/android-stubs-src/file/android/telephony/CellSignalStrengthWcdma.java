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
 * Wcdma signal strength related information.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellSignalStrengthWcdma extends android.telephony.CellSignalStrength implements android.os.Parcelable {

/** @hide */

CellSignalStrengthWcdma() { throw new RuntimeException("Stub!"); }

/**
 * Get signal level as an int from 0..4
 */

public int getLevel() { throw new RuntimeException("Stub!"); }

/**
 * Get the signal strength as dBm
 */

public int getDbm() { throw new RuntimeException("Stub!"); }

/**
 * Get the signal level as an asu value between 0..31, 99 is unknown
 * Asu is calculated based on 3GPP RSRP. Refer to 3GPP 27.007 (Ver 10.3.0) Sec 8.69
 */

public int getAsuLevel() { throw new RuntimeException("Stub!"); }

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

public static final android.os.Parcelable.Creator<android.telephony.CellSignalStrengthWcdma> CREATOR;
static { CREATOR = null; }
}

