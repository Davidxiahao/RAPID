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

import android.content.Context;
import java.util.List;
import android.content.res.Resources;
import android.net.NetworkCapabilities;
import android.content.Intent;

/**
 * SubscriptionManager is the application interface to SubscriptionController
 * and provides information about the current Telephony Subscriptions.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SubscriptionManager {

/** @hide */

SubscriptionManager(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated developers should always obtain references directly from
 *             {@link Context#getSystemService(Class)}.
 */

@Deprecated public static android.telephony.SubscriptionManager from(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Register for changes to the list of active {@link SubscriptionInfo} records or to the
 * individual records themselves. When a change occurs the onSubscriptionsChanged method of
 * the listener will be invoked immediately if there has been a notification.
 *
 * @param listener an instance of {@link OnSubscriptionsChangedListener} with
 *                 onSubscriptionsChanged overridden.
 */

public void addOnSubscriptionsChangedListener(android.telephony.SubscriptionManager.OnSubscriptionsChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Unregister the {@link OnSubscriptionsChangedListener}. This is not strictly necessary
 * as the listener will automatically be unregistered if an attempt to invoke the listener
 * fails.
 *
 * @param listener that is to be unregistered.
 */

public void removeOnSubscriptionsChangedListener(android.telephony.SubscriptionManager.OnSubscriptionsChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Get the active SubscriptionInfo with the input subId.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see
 * {@link TelephonyManager#hasCarrierPrivileges}).
 *
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param subId The unique SubscriptionInfo key in database.
 * @return SubscriptionInfo, maybe null if its not active.
 */

public android.telephony.SubscriptionInfo getActiveSubscriptionInfo(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Get the active SubscriptionInfo associated with the slotIndex
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see
 * {@link TelephonyManager#hasCarrierPrivileges}).
 *
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param slotIndex the slot which the subscription is inserted
 * @return SubscriptionInfo, maybe null if its not active
 */

public android.telephony.SubscriptionInfo getActiveSubscriptionInfoForSimSlotIndex(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Get the SubscriptionInfo(s) of the currently inserted SIM(s). The records will be sorted
 * by {@link SubscriptionInfo#getSimSlotIndex} then by {@link SubscriptionInfo#getSubscriptionId}.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see
 * {@link TelephonyManager#hasCarrierPrivileges}). In the latter case, only records accessible
 * to the calling app are returned.
 *
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return Sorted list of the currently {@link SubscriptionInfo} records available on the device.
 * <ul>
 * <li>
 * If null is returned the current state is unknown but if a {@link OnSubscriptionsChangedListener}
 * has been registered {@link OnSubscriptionsChangedListener#onSubscriptionsChanged} will be
 * invoked in the future.
 * </li>
 * <li>
 * If the list is empty then there are no {@link SubscriptionInfo} records currently available.
 * </li>
 * <li>
 * if the list is non-empty the list is sorted by {@link SubscriptionInfo#getSimSlotIndex}
 * then by {@link SubscriptionInfo#getSubscriptionId}.
 * </li>
 * </ul>
 */

public java.util.List<android.telephony.SubscriptionInfo> getActiveSubscriptionInfoList() { throw new RuntimeException("Stub!"); }

/**
 * Gets the SubscriptionInfo(s) of all embedded subscriptions accessible to the calling app, if
 * any.
 *
 * <p>Only those subscriptions for which the calling app has carrier privileges per the
 * subscription metadata, if any, will be included in the returned list.
 *
 * <p>The records will be sorted by {@link SubscriptionInfo#getSimSlotIndex} then by
 * {@link SubscriptionInfo#getSubscriptionId}.
 *
 * @return Sorted list of the current embedded {@link SubscriptionInfo} records available on the
 * device which are accessible to the caller.
 * <ul>
 * <li>
 * If null is returned the current state is unknown but if a
 * {@link OnSubscriptionsChangedListener} has been registered
 * {@link OnSubscriptionsChangedListener#onSubscriptionsChanged} will be invoked in the future.
 * <li>
 * If the list is empty then there are no {@link SubscriptionInfo} records currently available.
 * <li>
 * if the list is non-empty the list is sorted by {@link SubscriptionInfo#getSimSlotIndex}
 * then by {@link SubscriptionInfo#getSubscriptionId}.
 * </ul>
 */

public java.util.List<android.telephony.SubscriptionInfo> getAccessibleSubscriptionInfoList() { throw new RuntimeException("Stub!"); }

/**
 *
 * Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see
 * {@link TelephonyManager#hasCarrierPrivileges}). In the latter case, the count will include
 * only those subscriptions accessible to the caller.
 *
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return the current number of active subscriptions. There is no guarantee the value
 * returned by this method will be the same as the length of the list returned by
 * {@link #getActiveSubscriptionInfoList}.
 */

public int getActiveSubscriptionInfoCount() { throw new RuntimeException("Stub!"); }

/**
 * @return the maximum number of active subscriptions that will be returned by
 * {@link #getActiveSubscriptionInfoList} and the value returned by
 * {@link #getActiveSubscriptionInfoCount}.
 */

public int getActiveSubscriptionInfoCountMax() { throw new RuntimeException("Stub!"); }

/**
 * Returns the system's default subscription id.
 *
 * For a voice capable device, it will return getDefaultVoiceSubscriptionId.
 * For a data only device, it will return the getDefaultDataSubscriptionId.
 * May return an INVALID_SUBSCRIPTION_ID on error.
 *
 * @return the "system" default subscription id.
 */

public static int getDefaultSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the system's default voice subscription id.
 *
 * On a data only device or on error, will return INVALID_SUBSCRIPTION_ID.
 *
 * @return the default voice subscription Id.
 */

public static int getDefaultVoiceSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the system's default SMS subscription id.
 *
 * On a data only device or on error, will return INVALID_SUBSCRIPTION_ID.
 *
 * @return the default SMS subscription Id.
 */

public static int getDefaultSmsSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the system's default data subscription id.
 *
 * On a voice only device or on error, will return INVALID_SUBSCRIPTION_ID.
 *
 * @return the default data subscription Id.
 */

public static int getDefaultDataSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the device is considered roaming on the current
 * network for a subscription.
 * <p>
 * Availability: Only when user registered to a network.
 *
 * @param subId The subscription ID
 * @return true if the network for the subscription is roaming, false otherwise
 */

public boolean isNetworkRoaming(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Get the description of the billing relationship plan between a carrier
 * and a specific subscriber.
 * <p>
 * This method is only accessible to the following narrow set of apps:
 * <ul>
 * <li>The carrier app for this subscriberId, as determined by
 * {@link TelephonyManager#hasCarrierPrivileges()}.
 * <li>The carrier app explicitly delegated access through
 * {@link CarrierConfigManager#KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING}.
 * </ul>
 *
 * @param subId the subscriber this relationship applies to
 * @throws SecurityException if the caller doesn't meet the requirements
 *             outlined above.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<android.telephony.SubscriptionPlan> getSubscriptionPlans(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Set the description of the billing relationship plan between a carrier
 * and a specific subscriber.
 * <p>
 * This method is only accessible to the following narrow set of apps:
 * <ul>
 * <li>The carrier app for this subscriberId, as determined by
 * {@link TelephonyManager#hasCarrierPrivileges()}.
 * <li>The carrier app explicitly delegated access through
 * {@link CarrierConfigManager#KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING}.
 * </ul>
 *
 * @param subId the subscriber this relationship applies to. An empty list
 *            may be sent to clear any existing plans.
 * @param plans the list of plans. The first plan is always the primary and
 *            most important plan. Any additional plans are secondary and
 *            may not be displayed or used by decision making logic.
 * This value must never be {@code null}.
 * @throws SecurityException if the caller doesn't meet the requirements
 *             outlined above.
 */

public void setSubscriptionPlans(int subId, @androidx.annotation.RecentlyNonNull java.util.List<android.telephony.SubscriptionPlan> plans) { throw new RuntimeException("Stub!"); }

/**
 * Temporarily override the billing relationship plan between a carrier and
 * a specific subscriber to be considered unmetered. This will be reflected
 * to apps via {@link NetworkCapabilities#NET_CAPABILITY_NOT_METERED}.
 * <p>
 * This method is only accessible to the following narrow set of apps:
 * <ul>
 * <li>The carrier app for this subscriberId, as determined by
 * {@link TelephonyManager#hasCarrierPrivileges()}.
 * <li>The carrier app explicitly delegated access through
 * {@link CarrierConfigManager#KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING}.
 * </ul>
 *
 * @param subId the subscriber this override applies to.
 * @param overrideUnmetered set if the billing relationship should be
 *            considered unmetered.
 * @param timeoutMillis the timeout after which the requested override will
 *            be automatically cleared, or {@code 0} to leave in the
 *            requested state until explicitly cleared, or the next reboot,
 *            whichever happens first.
 * Value is a non-negative duration in milliseconds.
 * @throws SecurityException if the caller doesn't meet the requirements
 *             outlined above.
 */

public void setSubscriptionOverrideUnmetered(int subId, boolean overrideUnmetered, long timeoutMillis) { throw new RuntimeException("Stub!"); }

/**
 * Temporarily override the billing relationship plan between a carrier and
 * a specific subscriber to be considered congested. This will cause the
 * device to delay certain network requests when possible, such as developer
 * jobs that are willing to run in a flexible time window.
 * <p>
 * This method is only accessible to the following narrow set of apps:
 * <ul>
 * <li>The carrier app for this subscriberId, as determined by
 * {@link TelephonyManager#hasCarrierPrivileges()}.
 * <li>The carrier app explicitly delegated access through
 * {@link CarrierConfigManager#KEY_CONFIG_PLANS_PACKAGE_OVERRIDE_STRING}.
 * </ul>
 *
 * @param subId the subscriber this override applies to.
 * @param overrideCongested set if the subscription should be considered
 *            congested.
 * @param timeoutMillis the timeout after which the requested override will
 *            be automatically cleared, or {@code 0} to leave in the
 *            requested state until explicitly cleared, or the next reboot,
 *            whichever happens first.
 * Value is a non-negative duration in milliseconds.
 * @throws SecurityException if the caller doesn't meet the requirements
 *             outlined above.
 */

public void setSubscriptionOverrideCongested(int subId, boolean overrideCongested, long timeoutMillis) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the app with the given context is authorized to manage the given subscription
 * according to its metadata. Only supported for embedded subscriptions (if
 * {@code SubscriptionInfo#isEmbedded} returns true).
 *
 * @param info The subscription to check.
 * @return whether the app is authorized to manage this subscription per its metadata.
 * @throws IllegalArgumentException if this subscription is not embedded.
 */

public boolean canManageSubscription(android.telephony.SubscriptionInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: The default sms subscription has changed.  This has the following
 * extra values:</p>
 * {@link #EXTRA_SUBSCRIPTION_INDEX} extra indicates the current default sms
 * subscription index
 */

public static final java.lang.String ACTION_DEFAULT_SMS_SUBSCRIPTION_CHANGED = "android.telephony.action.DEFAULT_SMS_SUBSCRIPTION_CHANGED";

/**
 * Broadcast Action: The default subscription has changed.  This has the following
 * extra values:</p>
 * The {@link #EXTRA_SUBSCRIPTION_INDEX} extra indicates the current default subscription index
 */

public static final java.lang.String ACTION_DEFAULT_SUBSCRIPTION_CHANGED = "android.telephony.action.DEFAULT_SUBSCRIPTION_CHANGED";

/**
 * Activity Action: Display UI for managing the billing relationship plans
 * between a carrier and a specific subscriber.
 * <p>
 * Carrier apps are encouraged to implement this activity, and the OS will
 * provide an affordance to quickly enter this activity, typically via
 * Settings. This affordance will only be shown when the carrier app is
 * actively providing subscription plan information via
 * {@link #setSubscriptionPlans(int, List)}.
 * <p>
 * Contains {@link #EXTRA_SUBSCRIPTION_INDEX} to indicate which subscription
 * the user is interested in.
 */

public static final java.lang.String ACTION_MANAGE_SUBSCRIPTION_PLANS = "android.telephony.action.MANAGE_SUBSCRIPTION_PLANS";

/**
 * Broadcast Action: Request a refresh of the billing relationship plans
 * between a carrier and a specific subscriber.
 * <p>
 * Carrier apps are encouraged to implement this receiver, and the OS will
 * provide an affordance to request a refresh. This affordance will only be
 * shown when the carrier app is actively providing subscription plan
 * information via {@link #setSubscriptionPlans(int, List)}.
 * <p>
 * Contains {@link #EXTRA_SUBSCRIPTION_INDEX} to indicate which subscription
 * the user is interested in.
 * <p>
 * Receivers should protect themselves by checking that the sender holds the
 * {@code android.permission.MANAGE_SUBSCRIPTION_PLANS} permission.
 */

public static final java.lang.String ACTION_REFRESH_SUBSCRIPTION_PLANS = "android.telephony.action.REFRESH_SUBSCRIPTION_PLANS";

/** Indicates that data roaming is disabled for a subscription */

public static final int DATA_ROAMING_DISABLE = 0; // 0x0

/** Indicates that data roaming is enabled for a subscription */

public static final int DATA_ROAMING_ENABLE = 1; // 0x1

/**
 * Integer extra used with {@link #ACTION_DEFAULT_SUBSCRIPTION_CHANGED} and
 * {@link #ACTION_DEFAULT_SMS_SUBSCRIPTION_CHANGED} to indicate the subscription
 * which has changed.
 */

public static final java.lang.String EXTRA_SUBSCRIPTION_INDEX = "android.telephony.extra.SUBSCRIPTION_INDEX";

/** An invalid subscription identifier */

public static final int INVALID_SUBSCRIPTION_ID = -1; // 0xffffffff
/**
 * A listener class for monitoring changes to {@link SubscriptionInfo} records.
 * <p>
 * Override the onSubscriptionsChanged method in the object that extends this
 * class and pass it to {@link #addOnSubscriptionsChangedListener(OnSubscriptionsChangedListener)}
 * to register your listener and to unregister invoke
 * {@link #removeOnSubscriptionsChangedListener(OnSubscriptionsChangedListener)}
 * <p>
 * Permissions android.Manifest.permission.READ_PHONE_STATE is required
 * for #onSubscriptionsChanged to be invoked.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class OnSubscriptionsChangedListener {

public OnSubscriptionsChangedListener() { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when there is any change to any SubscriptionInfo. Typically
 * this method would invoke {@link #getActiveSubscriptionInfoList}
 */

public void onSubscriptionsChanged() { throw new RuntimeException("Stub!"); }
}

}

