/*
 * Copyright (C) 2013 The Android Open Source Project
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
 * CellIdentity to represent a unique UMTS cell
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellIdentityWcdma extends android.telephony.CellIdentity {

/**
 * @hide
 */

CellIdentityWcdma() { super(null, 0, null); throw new RuntimeException("Stub!"); }

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
 * @return 16-bit Location Area Code, 0..65535, Integer.MAX_VALUE if unknown
 */

public int getLac() { throw new RuntimeException("Stub!"); }

/**
 * @return CID
 * 28-bit UMTS Cell Identity described in TS 25.331, 0..268435455, Integer.MAX_VALUE if unknown
 */

public int getCid() { throw new RuntimeException("Stub!"); }

/**
 * @return 9-bit UMTS Primary Scrambling Code described in TS 25.331, 0..511, Integer.MAX_VALUE
 * if unknown
 */

public int getPsc() { throw new RuntimeException("Stub!"); }

/**
 * @return Mobile Country Code in string version, null if unknown
 */

public java.lang.String getMccString() { throw new RuntimeException("Stub!"); }

/**
 * @return Mobile Network Code in string version, null if unknown
 */

public java.lang.String getMncString() { throw new RuntimeException("Stub!"); }

/**
 * @return a 5 or 6 character string (MCC+MNC), null if any field is unknown
 */

public java.lang.String getMobileNetworkOperator() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * @return 16-bit UMTS Absolute RF Channel Number, Integer.MAX_VALUE if unknown
 */

public int getUarfcn() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public static final android.os.Parcelable.Creator<android.telephony.CellIdentityWcdma> CREATOR;
static { CREATOR = null; }
}

