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
import android.os.Parcelable;

/**
 * CellIdentity represents the identity of a unique cell. This is the base class for
 * CellIdentityXxx which represents cell identity for specific network access technology.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CellIdentity implements android.os.Parcelable {

/**
 * Construct from Parcel
 * @hide
 */

CellIdentity(java.lang.String tag, int type, android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @return The long alpha tag associated with the current scan result (may be the operator
 * name string or extended operator name string). May be null if unknown.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getOperatorAlphaLong() { throw new RuntimeException("Stub!"); }

/**
 * @return The short alpha tag associated with the current scan result (may be the operator
 * name string or extended operator name string).  May be null if unknown.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getOperatorAlphaShort() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Used by child classes for parceling.
 *
 * @hide
 */

public void writeToParcel(android.os.Parcel dest, int type) { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public static final android.os.Parcelable.Creator<android.telephony.CellIdentity> CREATOR;
static { CREATOR = null; }
}

