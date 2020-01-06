/*
 * Copyright 2017 The Android Open Source Project
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
 * CellIdentity is to represent a unique TD-SCDMA cell
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CellIdentityTdscdma extends android.telephony.CellIdentity {

/**
 * @hide
 */

CellIdentityTdscdma() { super(null, 0, null); throw new RuntimeException("Stub!"); }

/**
 * Get Mobile Country Code in string format
 * @return Mobile Country Code in string format, null if unknown
 */

public java.lang.String getMccString() { throw new RuntimeException("Stub!"); }

/**
 * Get Mobile Network Code in string format
 * @return Mobile Network Code in string format, null if unknown
 */

public java.lang.String getMncString() { throw new RuntimeException("Stub!"); }

/**
 * @return 16-bit Location Area Code, 0..65535, INT_MAX if unknown
 */

public int getLac() { throw new RuntimeException("Stub!"); }

/**
 * @return 28-bit UMTS Cell Identity described in TS 25.331, 0..268435455, INT_MAX if unknown
 */

public int getCid() { throw new RuntimeException("Stub!"); }

/**
 * @return 8-bit Cell Parameters ID described in TS 25.331, 0..127, INT_MAX if unknown
 */

public int getCpid() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public static final android.os.Parcelable.Creator<android.telephony.CellIdentityTdscdma> CREATOR;
static { CREATOR = null; }
}

