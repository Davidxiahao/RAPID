/*
 * Copyright (C) 2006 The Android Open Source Project
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


/**
 * Represents the neighboring cell information, including
 * Received Signal Strength and Cell ID location.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NeighboringCellInfo implements android.os.Parcelable {

/**
 * Empty constructor.  Initializes the RSSI and CID.
 *
 * NeighboringCellInfo is one time shot for the neighboring cells based on
 * the radio network type at that moment. Its constructor needs radio network
 * type.
 *
 * @deprecated by {@link #NeighboringCellInfo(int, String, int)}
 */

@Deprecated public NeighboringCellInfo() { throw new RuntimeException("Stub!"); }

/**
 * Initialize the object from rssi and cid.
 *
 * NeighboringCellInfo is one time shot for the neighboring cells based on
 * the radio network type at that moment. Its constructor needs radio network
 * type.
 *
 * @deprecated by {@link #NeighboringCellInfo(int, String, int)}
 */

@Deprecated public NeighboringCellInfo(int rssi, int cid) { throw new RuntimeException("Stub!"); }

/**
 * Initialize the object from rssi, location string, and radioType
 * radioType is one of following
 * {@link TelephonyManager#NETWORK_TYPE_GPRS TelephonyManager.NETWORK_TYPE_GPRS},
 * {@link TelephonyManager#NETWORK_TYPE_EDGE TelephonyManager.NETWORK_TYPE_EDGE},
 * {@link TelephonyManager#NETWORK_TYPE_UMTS TelephonyManager.NETWORK_TYPE_UMTS},
 * {@link TelephonyManager#NETWORK_TYPE_HSDPA TelephonyManager.NETWORK_TYPE_HSDPA},
 * {@link TelephonyManager#NETWORK_TYPE_HSUPA TelephonyManager.NETWORK_TYPE_HSUPA},
 * and {@link TelephonyManager#NETWORK_TYPE_HSPA TelephonyManager.NETWORK_TYPE_HSPA}.
 */

public NeighboringCellInfo(int rssi, java.lang.String location, int radioType) { throw new RuntimeException("Stub!"); }

/**
 * Initialize the object from a parcel.
 */

public NeighboringCellInfo(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * @return received signal strength or UNKNOWN_RSSI if unknown
 *
 * For GSM, it is in "asu" ranging from 0 to 31 (dBm = -113 + 2*asu)
 * 0 means "-113 dBm or less" and 31 means "-51 dBm or greater"
 * For UMTS, it is the Level index of CPICH RSCP defined in TS 25.125
 */

public int getRssi() { throw new RuntimeException("Stub!"); }

/**
 * @return LAC in GSM, 0xffff max legal value
 *  UNKNOWN_CID if in UMTS or CMDA or unknown
 */

public int getLac() { throw new RuntimeException("Stub!"); }

/**
 * @return cell id in GSM, 0xffff max legal value
 *  UNKNOWN_CID if in UMTS or CDMA or unknown
 */

public int getCid() { throw new RuntimeException("Stub!"); }

/**
 * @return Primary Scrambling Code in 9 bits format in UMTS, 0x1ff max value
 *  UNKNOWN_CID if in GSM or CMDA or unknown
 */

public int getPsc() { throw new RuntimeException("Stub!"); }

/**
 * @return Radio network type while neighboring cell location is stored.
 *
 * Return {@link TelephonyManager#NETWORK_TYPE_UNKNOWN TelephonyManager.NETWORK_TYPE_UNKNOWN}
 * means that the location information is unavailable.
 *
 * Return {@link TelephonyManager#NETWORK_TYPE_GPRS TelephonyManager.NETWORK_TYPE_GPRS} or
 * {@link TelephonyManager#NETWORK_TYPE_EDGE TelephonyManager.NETWORK_TYPE_EDGE}
 * means that Neighboring Cell information is stored for GSM network, in
 * which {@link NeighboringCellInfo#getLac NeighboringCellInfo.getLac} and
 * {@link NeighboringCellInfo#getCid NeighboringCellInfo.getCid} should be
 * called to access location.
 *
 * Return {@link TelephonyManager#NETWORK_TYPE_UMTS TelephonyManager.NETWORK_TYPE_UMTS},
 * {@link TelephonyManager#NETWORK_TYPE_HSDPA TelephonyManager.NETWORK_TYPE_HSDPA},
 * {@link TelephonyManager#NETWORK_TYPE_HSUPA TelephonyManager.NETWORK_TYPE_HSUPA},
 * or {@link TelephonyManager#NETWORK_TYPE_HSPA TelephonyManager.NETWORK_TYPE_HSPA}
 * means that Neighboring Cell information is stored for UMTS network, in
 * which {@link NeighboringCellInfo#getPsc NeighboringCellInfo.getPsc}
 * should be called to access location.
 */

public int getNetworkType() { throw new RuntimeException("Stub!"); }

/**
 * Set the cell id.
 *
 * NeighboringCellInfo is a one time shot for the neighboring cells based on
 * the radio network type at that moment. It shouldn't be changed after
 * creation.
 *
 * @deprecated cid value passed as in location parameter passed to constructor
 *              {@link #NeighboringCellInfo(int, String, int)}
 */

@Deprecated public void setCid(int cid) { throw new RuntimeException("Stub!"); }

/**
 * Set the signal strength of the cell.
 *
 * NeighboringCellInfo is a one time shot for the neighboring cells based on
 * the radio network type at that moment. It shouldn't be changed after
 * creation.
 *
 * @deprecated initial rssi value passed as parameter to constructor
 *              {@link #NeighboringCellInfo(int, String, int)}
 */

@Deprecated public void setRssi(int rssi) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.telephony.NeighboringCellInfo> CREATOR;
static { CREATOR = null; }

/**
 * Cell location is not available
 */

public static final int UNKNOWN_CID = -1; // 0xffffffff

/**
 * Signal strength is not available
 */

public static final int UNKNOWN_RSSI = 99; // 0x63
}

