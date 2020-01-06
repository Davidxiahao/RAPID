/**
 * Copyright (c) 2016, The Android Open Source Project
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


package android.net.wifi.hotspot2.pps;

import android.os.Parcel;

/**
 * Class representing HomeSP subtree in PerProviderSubscription (PPS)
 * Management Object (MO) tree.
 *
 * For more info, refer to Hotspot 2.0 PPS MO defined in section 9.1 of the Hotspot 2.0
 * Release 2 Technical Specification.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class HomeSp implements android.os.Parcelable {

/**
 * Constructor for creating HomeSp with default values.
 */

public HomeSp() { throw new RuntimeException("Stub!"); }

/**
 * Copy constructor.
 *
 * @param source The source to copy from
 */

public HomeSp(android.net.wifi.hotspot2.pps.HomeSp source) { throw new RuntimeException("Stub!"); }

/**
 * Set the FQDN (Fully Qualified Domain Name) associated with this home service provider.
 *
 * @param fqdn The FQDN to set to
 */

public void setFqdn(java.lang.String fqdn) { throw new RuntimeException("Stub!"); }

/**
 * Get the FQDN (Fully Qualified Domain Name) associated with this home service provider.
 *
 * @return the FQDN associated with this home service provider
 */

public java.lang.String getFqdn() { throw new RuntimeException("Stub!"); }

/**
 * Set the friendly name associated with this home service provider.
 *
 * @param friendlyName The friendly name to set to
 */

public void setFriendlyName(java.lang.String friendlyName) { throw new RuntimeException("Stub!"); }

/**
 * Get the friendly name associated with this home service provider.
 *
 * @return the friendly name associated with this home service provider
 */

public java.lang.String getFriendlyName() { throw new RuntimeException("Stub!"); }

/**
 * Set the Organization Identifiers (OIs) identifying a roaming consortium of which this
 * provider is a member.
 *
 * @param roamingConsortiumOis Array of roaming consortium OIs
 */

public void setRoamingConsortiumOis(long[] roamingConsortiumOis) { throw new RuntimeException("Stub!"); }

/**
 * Get the Organization Identifiers (OIs) identifying a roaming consortium of which this
 * provider is a member.
 *
 * @return array of roaming consortium OIs
 */

public long[] getRoamingConsortiumOis() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object thatObject) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.net.wifi.hotspot2.pps.HomeSp> CREATOR;
static { CREATOR = null; }
}

