/**
 * Copyright (c) 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.service.carrier;

import android.os.Parcel;

/**
 * Used to pass info to CarrierConfigService implementations so they can decide what values to
 * return.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CarrierIdentifier implements android.os.Parcelable {

/**
 * @param spn This value may be {@code null}.

 * @param imsi This value may be {@code null}.
 
 * @param gid1 This value may be {@code null}.

 * @param gid2 This value may be {@code null}.
 */

public CarrierIdentifier(java.lang.String mcc, java.lang.String mnc, @androidx.annotation.RecentlyNullable java.lang.String spn, @androidx.annotation.RecentlyNullable java.lang.String imsi, @androidx.annotation.RecentlyNullable java.lang.String gid1, @androidx.annotation.RecentlyNullable java.lang.String gid2) { throw new RuntimeException("Stub!"); }

/**
 * Creates a carrier identifier instance.
 *
 * @param mccMnc A 3-byte array as defined by 3GPP TS 24.008.
 * @param gid1 The group identifier level 1.
 * This value may be {@code null}.
 * @param gid2 The group identifier level 2.
 * This value may be {@code null}.
 * @throws IllegalArgumentException If the length of {@code mccMnc} is not 3.
 */

public CarrierIdentifier(byte[] mccMnc, @androidx.annotation.RecentlyNullable java.lang.String gid1, @androidx.annotation.RecentlyNullable java.lang.String gid2) { throw new RuntimeException("Stub!"); }

/** Get the mobile country code. */

public java.lang.String getMcc() { throw new RuntimeException("Stub!"); }

/** Get the mobile network code. */

public java.lang.String getMnc() { throw new RuntimeException("Stub!"); }

/**
 * Get the service provider name.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getSpn() { throw new RuntimeException("Stub!"); }

/**
 * Get the international mobile subscriber identity.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getImsi() { throw new RuntimeException("Stub!"); }

/**
 * Get the group identifier level 1.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getGid1() { throw new RuntimeException("Stub!"); }

/**
 * Get the group identifier level 2.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getGid2() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Used to create a {@link CarrierIdentifier} from a {@link Parcel}. */

public static final android.os.Parcelable.Creator<android.service.carrier.CarrierIdentifier> CREATOR;
static { CREATOR = null; }
}

