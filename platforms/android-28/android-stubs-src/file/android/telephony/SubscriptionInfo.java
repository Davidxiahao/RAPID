/*
 * Copyright (C) 2014 The Android Open Source Project
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
import android.content.Context;
import android.util.DisplayMetrics;
import android.graphics.Bitmap;

/**
 * A Parcelable class for Subscription Information.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SubscriptionInfo implements android.os.Parcelable {

/**
 * @hide
 */

SubscriptionInfo(int id, java.lang.String iccId, int simSlotIndex, java.lang.CharSequence displayName, java.lang.CharSequence carrierName, int nameSource, int iconTint, java.lang.String number, int roaming, android.graphics.Bitmap icon, int mcc, int mnc, java.lang.String countryIso) { throw new RuntimeException("Stub!"); }

/**
 * @return the subscription ID.
 */

public int getSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * @return the ICC ID.
 */

public java.lang.String getIccId() { throw new RuntimeException("Stub!"); }

/**
 * @return the slot index of this Subscription's SIM card.
 */

public int getSimSlotIndex() { throw new RuntimeException("Stub!"); }

/**
 * @return the name displayed to the user that identifies this subscription
 */

public java.lang.CharSequence getDisplayName() { throw new RuntimeException("Stub!"); }

/**
 * @return the name displayed to the user that identifies Subscription provider name
 */

public java.lang.CharSequence getCarrierName() { throw new RuntimeException("Stub!"); }

/**
 * Creates and returns an icon {@code Bitmap} to represent this {@code SubscriptionInfo} in a user
 * interface.
 *
 * @param context A {@code Context} to get the {@code DisplayMetrics}s from.
 *
 * @return A bitmap icon for this {@code SubscriptionInfo}.
 */

public android.graphics.Bitmap createIconBitmap(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * A highlight color to use in displaying information about this {@code PhoneAccount}.
 *
 * @return A hexadecimal color value.
 */

public int getIconTint() { throw new RuntimeException("Stub!"); }

/**
 * @return the number of this subscription.
 */

public java.lang.String getNumber() { throw new RuntimeException("Stub!"); }

/**
 * @return the data roaming state for this subscription, either
 * {@link SubscriptionManager#DATA_ROAMING_ENABLE} or {@link SubscriptionManager#DATA_ROAMING_DISABLE}.
 */

public int getDataRoaming() { throw new RuntimeException("Stub!"); }

/**
 * @return the MCC.
 */

public int getMcc() { throw new RuntimeException("Stub!"); }

/**
 * @return the MNC.
 */

public int getMnc() { throw new RuntimeException("Stub!"); }

/**
 * @return the ISO country code
 */

public java.lang.String getCountryIso() { throw new RuntimeException("Stub!"); }

/** @return whether the subscription is an eUICC one. */

public boolean isEmbedded() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.telephony.SubscriptionInfo> CREATOR;
static { CREATOR = null; }
}

