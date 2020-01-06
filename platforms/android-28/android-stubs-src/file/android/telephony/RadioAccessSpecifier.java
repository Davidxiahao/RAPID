/*
 * Copyright (C) 2017 The Android Open Source Project
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
 * Describes a particular radio access network to be scanned.
 *
 * The scan can be performed on either bands or channels for a specific radio access network type.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RadioAccessSpecifier implements android.os.Parcelable {

/**
 * Creates a new RadioAccessSpecifier with radio network, bands and channels
 *
 * The user must specify the radio network type, and at least specify either of frequency
 * bands or channels.
 *
 * @param ran The type of the radio access network
 * @param bands the frequency bands to be scanned
 * @param channels the frequency bands to be scanned
 */

public RadioAccessSpecifier(int ran, int[] bands, int[] channels) { throw new RuntimeException("Stub!"); }

/**
 * Returns the radio access network that needs to be scanned.
 *
 * The returned value is define in {@link AccessNetworkConstants.AccessNetworkType};
 */

public int getRadioAccessNetwork() { throw new RuntimeException("Stub!"); }

/**
 * Returns the frequency bands that need to be scanned.
 *
 * The returned value is defined in either of {@link AccessNetworkConstants.GeranBand},
 * {@link AccessNetworkConstants.UtranBand} and {@link AccessNetworkConstants.EutranBand}, and
 * it depends on the returned value of {@link #getRadioAccessNetwork()}.
 */

public int[] getBands() { throw new RuntimeException("Stub!"); }

/** Returns the frequency channels that need to be scanned. */

public int[] getChannels() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.telephony.RadioAccessSpecifier> CREATOR;
static { CREATOR = null; }
}

