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


package android.companion;

import android.content.Context;
import android.os.Handler;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.content.ComponentName;
import java.util.List;
import android.service.notification.NotificationListenerService;

/**
 * System level service for managing companion devices
 *
 * <p>To obtain an instance call {@link Context#getSystemService}({@link
 * Context#COMPANION_DEVICE_SERVICE}) Then, call {@link #associate(AssociationRequest,
 * Callback, Handler)} to initiate the flow of associating current package with a
 * device selected by user.</p>
 *
 * @see AssociationRequest
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CompanionDeviceManager {

CompanionDeviceManager() { throw new RuntimeException("Stub!"); }

/**
 * Associate this app with a companion device, selected by user
 *
 * <p>Once at least one appropriate device is found, {@code callback} will be called with a
 * {@link PendingIntent} that can be used to show the list of available devices for the user
 * to select.
 * It should be started for result (i.e. using
 * {@link android.app.Activity#startIntentSenderForResult}), as the resulting
 * {@link android.content.Intent} will contain extra {@link #EXTRA_DEVICE}, with the selected
 * device. (e.g. {@link android.bluetooth.BluetoothDevice})</p>
 *
 * <p>If your app needs to be excluded from battery optimizations (run in the background)
 * or to have unrestricted data access (use data in the background) you can declare that
 * you use the {@link android.Manifest.permission#REQUEST_COMPANION_RUN_IN_BACKGROUND} and {@link
 * android.Manifest.permission#REQUEST_COMPANION_USE_DATA_IN_BACKGROUND} respectively. Note that these
 * special capabilities have a negative effect on the device's battery and user's data
 * usage, therefore you should requested them when absolutely necessary.</p>
 *
 * <p>You can call {@link #getAssociations} to get the list of currently associated
 * devices, and {@link #disassociate} to remove an association. Consider doing so when the
 * association is no longer relevant to avoid unnecessary battery and/or data drain resulting
 * from special privileges that the association provides</p>
 *
 * <p>Calling this API requires a uses-feature
 * {@link PackageManager#FEATURE_COMPANION_DEVICE_SETUP} declaration in the manifest</p>
 *
 * @param request specific details about this request
 * This value must never be {@code null}.
 * @param callback will be called once there's at least one device found for user to choose from
 * This value must never be {@code null}.
 * @param handler A handler to control which thread the callback will be delivered on, or null,
 *                to deliver it on main thread
 *
 * This value may be {@code null}.
 * @see AssociationRequest
 */

public void associate(@androidx.annotation.RecentlyNonNull android.companion.AssociationRequest request, @androidx.annotation.RecentlyNonNull android.companion.CompanionDeviceManager.Callback callback, @androidx.annotation.RecentlyNullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * <p>Calling this API requires a uses-feature
 * {@link PackageManager#FEATURE_COMPANION_DEVICE_SETUP} declaration in the manifest</p>
 *
 * @return a list of MAC addresses of devices that have been previously associated with the
 * current app. You can use these with {@link #disassociate}

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<java.lang.String> getAssociations() { throw new RuntimeException("Stub!"); }

/**
 * Remove the association between this app and the device with the given mac address.
 *
 * <p>Any privileges provided via being associated with a given device will be revoked</p>
 *
 * <p>Consider doing so when the
 * association is no longer relevant to avoid unnecessary battery and/or data drain resulting
 * from special privileges that the association provides</p>
 *
 * <p>Calling this API requires a uses-feature
 * {@link PackageManager#FEATURE_COMPANION_DEVICE_SETUP} declaration in the manifest</p>
 *
 * @param deviceMacAddress the MAC address of device to disassociate from this app

 * This value must never be {@code null}.
 */

public void disassociate(@androidx.annotation.RecentlyNonNull java.lang.String deviceMacAddress) { throw new RuntimeException("Stub!"); }

/**
 * Request notification access for the given component.
 *
 * The given component must follow the protocol specified in {@link NotificationListenerService}
 *
 * Only components from the same {@link ComponentName#getPackageName package} as the calling app
 * are allowed.
 *
 * Your app must have an association with a device before calling this API
 *
 * <p>Calling this API requires a uses-feature
 * {@link PackageManager#FEATURE_COMPANION_DEVICE_SETUP} declaration in the manifest</p>
 */

public void requestNotificationAccess(android.content.ComponentName component) { throw new RuntimeException("Stub!"); }

/**
 * Check whether the given component can access the notifications via a
 * {@link NotificationListenerService}
 *
 * Your app must have an association with a device before calling this API
 *
 * <p>Calling this API requires a uses-feature
 * {@link PackageManager#FEATURE_COMPANION_DEVICE_SETUP} declaration in the manifest</p>
 *
 * @param component the name of the component
 * @return whether the given component has the notification listener permission
 */

public boolean hasNotificationAccess(android.content.ComponentName component) { throw new RuntimeException("Stub!"); }

/**
 * A device, returned in the activity result of the {@link IntentSender} received in
 * {@link Callback#onDeviceFound}
 */

public static final java.lang.String EXTRA_DEVICE = "android.companion.extra.DEVICE";
/**
 * A callback to receive once at least one suitable device is found, or the search failed
 * (e.g.&nbsp;timed out)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Called once at least one suitable device is found
 *
 * @param chooserLauncher a {@link IntentSender} to launch the UI for user to select a
 *                        device
 */

public abstract void onDeviceFound(android.content.IntentSender chooserLauncher);

/**
 * Called if there was an error looking for device(s)
 *
 * @param error the cause of the error
 */

public abstract void onFailure(java.lang.CharSequence error);
}

}

