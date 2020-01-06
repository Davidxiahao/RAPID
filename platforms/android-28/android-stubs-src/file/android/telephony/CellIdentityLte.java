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

/**
 * CellIdentity is to represent a unique LTE cell
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellIdentityLte extends android.telephony.CellIdentity {

/**
 * @hide
 */

CellIdentityLte() { super(null, 0, null); throw new RuntimeException("Stub!"); }

/**
 * @return 3-digit Mobile Country Code, 0..999, Integer.MAX_VALUE if unknown
 * @deprecated Use {@link #getMccString} instead.
 */

@Deprecated public int getMcc() { throw new RuntimeException("Stub!"); }

/**
 * @return 2 or 3-digit Mobile Network Code, 0..999, Integer.MAX_VALUE if unknown
 * @deprecated Use {@link #getMncString} instead.
 */

@Deprecated public int getMnc() { throw new RuntimeException("Stub!"); }

/**
 * @return 28-bit Cell Identity, Integer.MAX_VALUE if unknown
 */

public int getCi() { throw new RuntimeException("Stub!"); }

/**
 * @return Physical Cell Id 0..503, Integer.MAX_VALUE if unknown
 */

public int getPci() { throw new RuntimeException("Stub!"); }

/**
 * @return 16-bit Tracking Area Code, Integer.MAX_VALUE if unknown
 */

public int getTac() { throw new RuntimeException("Stub!"); }

/**
 * @return 18-bit Absolute RF Channel Number, Integer.MAX_VALUE if unknown
 */

public int getEarfcn() { throw new RuntimeException("Stub!"); }

/**
 * @return Cell bandwidth in kHz, Integer.MAX_VALUE if unknown
 */

public int getBandwidth() { throw new RuntimeException("Stub!"); }

/**
 * @return Mobile Country Code in string format, null if unknown
 */

public java.lang.String getMccString() { throw new RuntimeException("Stub!"); }

/**
 * @return Mobile Network Code in string format, null if unknown
 */

public java.lang.String getMncString() { throw new RuntimeException("Stub!"); }

/**
 * @return a 5 or 6 character string (MCC+MNC), null if any field is unknown
 */

public java.lang.String getMobileNetworkOperator() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public static final android.os.Parcelable.Creator<android.telephony.CellIdentityLte> CREATOR;
static { CREATOR = null; }
}

