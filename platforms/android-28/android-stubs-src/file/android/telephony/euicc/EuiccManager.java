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

package android.telephony.euicc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.Manifest;
import android.content.Intent;
import android.app.PendingIntent;
import android.app.Activity;
import android.content.IntentSender;

/**
 * EuiccManager is the application interface to eUICCs, or eSIMs/embedded SIMs.
 *
 * <p>You do not instantiate this class directly; instead, you retrieve an instance through
 * {@link Context#getSystemService(String)} and {@link Context#EUICC_SERVICE}.
 *
 * <p>See {@link #isEnabled} before attempting to use these APIs.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EuiccManager {

/** @hide */

EuiccManager(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Whether embedded subscriptions are currently enabled.
 *
 * <p>Even on devices with the {@link PackageManager#FEATURE_TELEPHONY_EUICC} feature, embedded
 * subscriptions may be turned off, e.g. because of a carrier restriction from an inserted
 * physical SIM. Therefore, this runtime check should be used before accessing embedded
 * subscription APIs.
 *
 * @return true if embedded subscriptions are currently enabled.
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns the EID identifying the eUICC hardware.
 *
 * <p>Requires that the calling app has carrier privileges on the active subscription on the
 * eUICC.
 *
 * @return the EID. May be null if {@link #isEnabled()} is false or the eUICC is not ready.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getEid() { throw new RuntimeException("Stub!"); }

/**
 * Attempt to download the given {@link DownloadableSubscription}.
 *
 * <p>Requires the {@code android.Manifest.permission#WRITE_EMBEDDED_SUBSCRIPTIONS} permission,
 * or the calling app must be authorized to manage both the currently-active subscription and
 * the subscription to be downloaded according to the subscription metadata. Without the former,
 * an {@link #EMBEDDED_SUBSCRIPTION_RESULT_RESOLVABLE_ERROR} will be returned in the callback
 * intent to prompt the user to accept the download.
 *
 * Requires {@link android.Manifest.permission#WRITE_EMBEDDED_SUBSCRIPTIONS}
 * @param subscription the subscription to download.
 * @param switchAfterDownload if true, the profile will be activated upon successful download.
 * @param callbackIntent a PendingIntent to launch when the operation completes.
 */

public void downloadSubscription(android.telephony.euicc.DownloadableSubscription subscription, boolean switchAfterDownload, android.app.PendingIntent callbackIntent) { throw new RuntimeException("Stub!"); }

/**
 * Start an activity to resolve a user-resolvable error.
 *
 * <p>If an operation returns {@link #EMBEDDED_SUBSCRIPTION_RESULT_RESOLVABLE_ERROR}, this
 * method may be called to prompt the user to resolve the issue.
 *
 * <p>This method may only be called once for a particular error.
 *
 * @param activity the calling activity (which should be in the foreground).
 * @param requestCode an application-specific request code which will be provided to
 *     {@link Activity#onActivityResult} upon completion. Note that the operation may still be
 *     in progress when the resolution activity completes; it is not fully finished until the
 *     callback intent is triggered.
 * @param resultIntent the Intent provided to the initial callback intent which failed with
 *     {@link #EMBEDDED_SUBSCRIPTION_RESULT_RESOLVABLE_ERROR}.
 * @param callbackIntent a PendingIntent to launch when the operation completes. This is
 *     trigered upon completion of the original operation that required user resolution.
 * @throws android.content.IntentSender.SendIntentException if called more than once.
 */

public void startResolutionActivity(android.app.Activity activity, int requestCode, android.content.Intent resultIntent, android.app.PendingIntent callbackIntent) throws android.content.IntentSender.SendIntentException { throw new RuntimeException("Stub!"); }

/**
 * Returns information about the eUICC chip/device.
 *
 * @return the {@link EuiccInfo}. May be null if {@link #isEnabled()} is false or the eUICC is
 *     not ready.
 */

@androidx.annotation.RecentlyNullable public android.telephony.euicc.EuiccInfo getEuiccInfo() { throw new RuntimeException("Stub!"); }

/**
 * Deletes the given subscription.
 *
 * <p>If this subscription is currently active, the device will first switch away from it onto
 * an "empty" subscription.
 *
 * <p>Requires that the calling app has carrier privileges according to the metadata of the
 * profile to be deleted, or the
 * {@code android.Manifest.permission#WRITE_EMBEDDED_SUBSCRIPTIONS} permission.
 *
 * Requires {@link android.Manifest.permission#WRITE_EMBEDDED_SUBSCRIPTIONS}
 * @param subscriptionId the ID of the subscription to delete.
 * @param callbackIntent a PendingIntent to launch when the operation completes.
 */

public void deleteSubscription(int subscriptionId, android.app.PendingIntent callbackIntent) { throw new RuntimeException("Stub!"); }

/**
 * Switch to (enable) the given subscription.
 *
 * <p>Requires the {@code android.Manifest.permission#WRITE_EMBEDDED_SUBSCRIPTIONS} permission,
 * or the calling app must be authorized to manage both the currently-active subscription and
 * the subscription to be enabled according to the subscription metadata. Without the former,
 * an {@link #EMBEDDED_SUBSCRIPTION_RESULT_RESOLVABLE_ERROR} will be returned in the callback
 * intent to prompt the user to accept the download.
 *
 * Requires {@link android.Manifest.permission#WRITE_EMBEDDED_SUBSCRIPTIONS}
 * @param subscriptionId the ID of the subscription to enable. May be
 *     {@link android.telephony.SubscriptionManager#INVALID_SUBSCRIPTION_ID} to deactivate the
 *     current profile without activating another profile to replace it.
 * @param callbackIntent a PendingIntent to launch when the operation completes.
 */

public void switchToSubscription(int subscriptionId, android.app.PendingIntent callbackIntent) { throw new RuntimeException("Stub!"); }

/**
 * Intent action to launch the embedded SIM (eUICC) management settings screen.
 *
 * <p>This screen shows a list of embedded profiles and offers the user the ability to switch
 * between them, download new profiles, and delete unused profiles.
 *
 * <p>The activity will immediately finish with {@link android.app.Activity#RESULT_CANCELED} if
 * {@link #isEnabled} is false.
 *
 * This is ued by non-LPA app to bring up LUI.
 */

public static final java.lang.String ACTION_MANAGE_EMBEDDED_SUBSCRIPTIONS = "android.telephony.euicc.action.MANAGE_EMBEDDED_SUBSCRIPTIONS";

/**
 * Broadcast Action: The action sent to carrier app so it knows the carrier setup is not
 * completed.
 */

public static final java.lang.String ACTION_NOTIFY_CARRIER_SETUP_INCOMPLETE = "android.telephony.euicc.action.NOTIFY_CARRIER_SETUP_INCOMPLETE";

/**
 * Result code for an operation indicating that an unresolvable error occurred.
 *
 * {@link #EXTRA_EMBEDDED_SUBSCRIPTION_DETAILED_CODE} will be populated with a detailed error
 * code for logging/debugging purposes only.
 */

public static final int EMBEDDED_SUBSCRIPTION_RESULT_ERROR = 2; // 0x2

/**
 * Result code for an operation indicating that the operation succeeded.
 */

public static final int EMBEDDED_SUBSCRIPTION_RESULT_OK = 0; // 0x0

/**
 * Result code for an operation indicating that the user must take some action before the
 * operation can continue.
 *
 * @see #startResolutionActivity
 */

public static final int EMBEDDED_SUBSCRIPTION_RESULT_RESOLVABLE_ERROR = 1; // 0x1

/**
 * Key for an extra set on {@link PendingIntent} result callbacks providing a detailed result
 * code.
 *
 * <p>This code is an implementation detail of the embedded subscription manager and is only
 * intended for logging or debugging purposes.
 */

public static final java.lang.String EXTRA_EMBEDDED_SUBSCRIPTION_DETAILED_CODE = "android.telephony.euicc.extra.EMBEDDED_SUBSCRIPTION_DETAILED_CODE";

/**
 * Key for an extra set on {@code #getDownloadableSubscriptionMetadata} PendingIntent result
 * callbacks providing the downloadable subscription metadata.
 */

public static final java.lang.String EXTRA_EMBEDDED_SUBSCRIPTION_DOWNLOADABLE_SUBSCRIPTION = "android.telephony.euicc.extra.EMBEDDED_SUBSCRIPTION_DOWNLOADABLE_SUBSCRIPTION";

/**
 * Optional meta-data attribute for a carrier app providing an icon to use to represent the
 * carrier. If not provided, the app's launcher icon will be used as a fallback.
 */

public static final java.lang.String META_DATA_CARRIER_ICON = "android.telephony.euicc.carriericon";
}

