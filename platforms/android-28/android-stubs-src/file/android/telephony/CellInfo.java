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
 * Immutable cell information from a point in time.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CellInfo implements android.os.Parcelable {

/** @hide */

CellInfo() { throw new RuntimeException("Stub!"); }

/** True if this cell is registered to the mobile network */

public boolean isRegistered() { throw new RuntimeException("Stub!"); }

/** Approximate time of this cell information in nanos since boot */

public long getTimeStamp() { throw new RuntimeException("Stub!"); }

/**
 * Gets the connection status of this cell.
 *
 * @see #CONNECTION_NONE
 * @see #CONNECTION_PRIMARY_SERVING
 * @see #CONNECTION_SECONDARY_SERVING
 * @see #CONNECTION_UNKNOWN
 *
 * @return The connection status of the cell.

 * Value is {@link android.telephony.CellInfo#CONNECTION_NONE}, {@link android.telephony.CellInfo#CONNECTION_PRIMARY_SERVING}, {@link android.telephony.CellInfo#CONNECTION_SECONDARY_SERVING}, or {@link android.telephony.CellInfo#CONNECTION_UNKNOWN}
 */

public int getCellConnectionStatus() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Implement the Parcelable interface
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface */

public abstract void writeToParcel(android.os.Parcel dest, int flags);

/**
 * Cell is not a serving cell.
 *
 * <p>The cell has been measured but is neither a camped nor serving cell (3GPP 36.304).
 */

public static final int CONNECTION_NONE = 0; // 0x0

/** UE is connected to cell for signalling and possibly data (3GPP 36.331, 25.331). */

public static final int CONNECTION_PRIMARY_SERVING = 1; // 0x1

/** UE is connected to cell for data (3GPP 36.331, 25.331). */

public static final int CONNECTION_SECONDARY_SERVING = 2; // 0x2

/** Connection status is unknown. */

public static final int CONNECTION_UNKNOWN = 2147483647; // 0x7fffffff

/** Implement the Parcelable interface */

public static final android.os.Parcelable.Creator<android.telephony.CellInfo> CREATOR;
static { CREATOR = null; }
}

