/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * From <code>defs.h</code> in <code>wpa_supplicant</code>.
 * <p/>
 * These enumeration values are used to indicate the current wpa_supplicant
 * state. This is more fine-grained than most users will be interested in.
 * In general, it is better to use
 * {@link android.net.NetworkInfo.State NetworkInfo.State}.
 * <p/>
 * Note, the order of these enum constants must match the numerical values of the
 * state constants in <code>defs.h</code> in <code>wpa_supplicant</code>.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum SupplicantState implements android.os.Parcelable {
DISCONNECTED, INTERFACE_DISABLED, INACTIVE, SCANNING, AUTHENTICATING, ASSOCIATING, ASSOCIATED, FOUR_WAY_HANDSHAKE, GROUP_HANDSHAKE, COMPLETED, DORMANT, UNINITIALIZED, INVALID;

/**
 * Returns {@code true} if the supplicant state is valid and {@code false}
 * otherwise.
 * @param state The supplicant state
 * @return {@code true} if the supplicant state is valid and {@code false}
 * otherwise.
 */

public static boolean isValidState(android.net.wifi.SupplicantState state) { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Implement the Parcelable interface {@hide} */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }
}

