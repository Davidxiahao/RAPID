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
 * CellIdentity is to represent a unique CDMA cell
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellIdentityCdma extends android.telephony.CellIdentity {

/**
 * @hide
 */

CellIdentityCdma() { super(null, 0, null); throw new RuntimeException("Stub!"); }

/**
 * @return Network Id 0..65535, Integer.MAX_VALUE if unknown
 */

public int getNetworkId() { throw new RuntimeException("Stub!"); }

/**
 * @return System Id 0..32767, Integer.MAX_VALUE if unknown
 */

public int getSystemId() { throw new RuntimeException("Stub!"); }

/**
 * @return Base Station Id 0..65535, Integer.MAX_VALUE if unknown
 */

public int getBasestationId() { throw new RuntimeException("Stub!"); }

/**
 * @return Base station longitude, which is a decimal number as
 * specified in 3GPP2 C.S0005-A v6.0. It is represented in units
 * of 0.25 seconds and ranges from -2592000 to 2592000, both
 * values inclusive (corresponding to a range of -180
 * to +180 degrees). Integer.MAX_VALUE if unknown.
 */

public int getLongitude() { throw new RuntimeException("Stub!"); }

/**
 * @return Base station latitude, which is a decimal number as
 * specified in 3GPP2 C.S0005-A v6.0. It is represented in units
 * of 0.25 seconds and ranges from -1296000 to 1296000, both
 * values inclusive (corresponding to a range of -90
 * to +90 degrees). Integer.MAX_VALUE if unknown.
 */

public int getLatitude() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public static final android.os.Parcelable.Creator<android.telephony.CellIdentityCdma> CREATOR;
static { CREATOR = null; }
}

