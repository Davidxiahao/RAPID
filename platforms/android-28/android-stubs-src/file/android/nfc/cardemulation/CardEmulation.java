/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.nfc.cardemulation;

import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.content.ComponentName;
import android.app.Activity;
import java.util.List;

/**
 * This class can be used to query the state of
 * NFC card emulation services.
 *
 * For a general introduction into NFC card emulation,
 * please read the <a href="{@docRoot}guide/topics/connectivity/nfc/hce.html">
 * NFC card emulation developer guide</a>.</p>
 *
 * <p class="note">Use of this class requires the
 * {@link PackageManager#FEATURE_NFC_HOST_CARD_EMULATION} to be present
 * on the device.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CardEmulation {

CardEmulation() { throw new RuntimeException("Stub!"); }

/**
 * Helper to get an instance of this class.
 *
 * @param adapter A reference to an NfcAdapter object.
 * @return
 */

public static synchronized android.nfc.cardemulation.CardEmulation getInstance(android.nfc.NfcAdapter adapter) { throw new RuntimeException("Stub!"); }

/**
 * Allows an application to query whether a service is currently
 * the default service to handle a card emulation category.
 *
 * <p>Note that if {@link #getSelectionModeForCategory(String)}
 * returns {@link #SELECTION_MODE_ALWAYS_ASK} or {@link #SELECTION_MODE_ASK_IF_CONFLICT},
 * this method will always return false. That is because in these
 * selection modes a default can't be set at the category level. For categories where
 * the selection mode is {@link #SELECTION_MODE_ALWAYS_ASK} or
 * {@link #SELECTION_MODE_ASK_IF_CONFLICT}, use
 * {@link #isDefaultServiceForAid(ComponentName, String)} to determine whether a service
 * is the default for a specific AID.
 *
 * @param service The ComponentName of the service
 * @param category The category
 * @return whether service is currently the default service for the category.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 */

public boolean isDefaultServiceForCategory(android.content.ComponentName service, java.lang.String category) { throw new RuntimeException("Stub!"); }

/**
 *
 * Allows an application to query whether a service is currently
 * the default handler for a specified ISO7816-4 Application ID.
 *
 * @param service The ComponentName of the service
 * @param aid The ISO7816-4 Application ID
 * @return whether the service is the default handler for the specified AID
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 */

public boolean isDefaultServiceForAid(android.content.ComponentName service, java.lang.String aid) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the user has allowed AIDs registered in the
 * specified category to be handled by a service that is preferred
 * by the foreground application, instead of by a pre-configured default.
 *
 * Foreground applications can set such preferences using the
 * {@link #setPreferredService(Activity, ComponentName)} method.
 *
 * @param category The category, e.g. {@link #CATEGORY_PAYMENT}
 * @return whether AIDs in the category can be handled by a service
 *         specified by the foreground app.
 */

public boolean categoryAllowsForegroundPreference(java.lang.String category) { throw new RuntimeException("Stub!"); }

/**
 * Returns the service selection mode for the passed in category.
 * Valid return values are:
 * <p>{@link #SELECTION_MODE_PREFER_DEFAULT} the user has requested a default
 *    service for this category, which will be preferred.
 * <p>{@link #SELECTION_MODE_ALWAYS_ASK} the user has requested to be asked
 *    every time what service he would like to use in this category.
 * <p>{@link #SELECTION_MODE_ASK_IF_CONFLICT} the user will only be asked
 *    to pick a service if there is a conflict.
 * @param category The category, for example {@link #CATEGORY_PAYMENT}
 * @return the selection mode for the passed in category
 */

public int getSelectionModeForCategory(java.lang.String category) { throw new RuntimeException("Stub!"); }

/**
 * Registers a list of AIDs for a specific category for the
 * specified service.
 *
 * <p>If a list of AIDs for that category was previously
 * registered for this service (either statically
 * through the manifest, or dynamically by using this API),
 * that list of AIDs will be replaced with this one.
 *
 * <p>Note that you can only register AIDs for a service that
 * is running under the same UID as the caller of this API. Typically
 * this means you need to call this from the same
 * package as the service itself, though UIDs can also
 * be shared between packages using shared UIDs.
 *
 * @param service The component name of the service
 * @param category The category of AIDs to be registered
 * @param aids A list containing the AIDs to be registered
 * @return whether the registration was successful.
 */

public boolean registerAidsForService(android.content.ComponentName service, java.lang.String category, java.util.List<java.lang.String> aids) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the currently registered AIDs for the specified
 * category for a service.
 *
 * <p>Note that this will only return AIDs that were dynamically
 * registered using {@link #registerAidsForService(ComponentName, String, List)}
 * method. It will *not* return AIDs that were statically registered
 * in the manifest.
 *
 * @param service The component name of the service
 * @param category The category for which the AIDs were registered,
 *                 e.g. {@link #CATEGORY_PAYMENT}
 * @return The list of AIDs registered for this category, or null if it couldn't be found.
 */

public java.util.List<java.lang.String> getAidsForService(android.content.ComponentName service, java.lang.String category) { throw new RuntimeException("Stub!"); }

/**
 * Removes a previously registered list of AIDs for the specified category for the
 * service provided.
 *
 * <p>Note that this will only remove AIDs that were dynamically
 * registered using the {@link #registerAidsForService(ComponentName, String, List)}
 * method. It will *not* remove AIDs that were statically registered in
 * the manifest. If dynamically registered AIDs are removed using
 * this method, and a statically registered AID group for the same category
 * exists in the manifest, the static AID group will become active again.
 *
 * @param service The component name of the service
 * @param category The category of the AIDs to be removed, e.g. {@link #CATEGORY_PAYMENT}
 * @return whether the group was successfully removed.
 */

public boolean removeAidsForService(android.content.ComponentName service, java.lang.String category) { throw new RuntimeException("Stub!"); }

/**
 * Allows a foreground application to specify which card emulation service
 * should be preferred while a specific Activity is in the foreground.
 *
 * <p>The specified Activity must currently be in resumed state. A good
 * paradigm is to call this method in your {@link Activity#onResume}, and to call
 * {@link #unsetPreferredService(Activity)} in your {@link Activity#onPause}.
 *
 * <p>This method call will fail in two specific scenarios:
 * <ul>
 * <li> If the service registers one or more AIDs in the {@link #CATEGORY_PAYMENT}
 * category, but the user has indicated that foreground apps are not allowed
 * to override the default payment service.
 * <li> If the service registers one or more AIDs in the {@link #CATEGORY_OTHER}
 * category that are also handled by the default payment service, and the
 * user has indicated that foreground apps are not allowed to override the
 * default payment service.
 * </ul>
 *
 * <p> Use {@link #categoryAllowsForegroundPreference(String)} to determine
 * whether foreground apps can override the default payment service.
 *
 * <p>Note that this preference is not persisted by the OS, and hence must be
 * called every time the Activity is resumed.
 *
 * @param activity The activity which prefers this service to be invoked
 * @param service The service to be preferred while this activity is in the foreground
 * @return whether the registration was successful
 */

public boolean setPreferredService(android.app.Activity activity, android.content.ComponentName service) { throw new RuntimeException("Stub!"); }

/**
 * Unsets the preferred service for the specified Activity.
 *
 * <p>Note that the specified Activity must still be in resumed
 * state at the time of this call. A good place to call this method
 * is in your {@link Activity#onPause} implementation.
 *
 * @param activity The activity which the service was registered for
 * @return true when successful
 */

public boolean unsetPreferredService(android.app.Activity activity) { throw new RuntimeException("Stub!"); }

/**
 * Some devices may allow an application to register all
 * AIDs that starts with a certain prefix, e.g.
 * "A000000004*" to register all MasterCard AIDs.
 *
 * Use this method to determine whether this device
 * supports registering AID prefixes.
 *
 * @return whether AID prefix registering is supported on this device.
 */

public boolean supportsAidPrefixRegistration() { throw new RuntimeException("Stub!"); }

/**
 * Activity action: ask the user to change the default
 * card emulation service for a certain category. This will
 * show a dialog that asks the user whether he wants to
 * replace the current default service with the service
 * identified with the ComponentName specified in
 * {@link #EXTRA_SERVICE_COMPONENT}, for the category
 * specified in {@link #EXTRA_CATEGORY}
 */

public static final java.lang.String ACTION_CHANGE_DEFAULT = "android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT";

/**
 * Category that can be used for all other card emulation
 * services.
 */

public static final java.lang.String CATEGORY_OTHER = "other";

/**
 * Category used for NFC payment services.
 */

public static final java.lang.String CATEGORY_PAYMENT = "payment";

/**
 * The category extra for {@link #ACTION_CHANGE_DEFAULT}.
 *
 * @see #ACTION_CHANGE_DEFAULT
 */

public static final java.lang.String EXTRA_CATEGORY = "category";

/**
 * The service {@link ComponentName} object passed in as an
 * extra for {@link #ACTION_CHANGE_DEFAULT}.
 *
 * @see #ACTION_CHANGE_DEFAULT
 */

public static final java.lang.String EXTRA_SERVICE_COMPONENT = "component";

/**
 * Return value for {@link #getSelectionModeForCategory(String)}.
 *
 * <p>In this mode, when using ISO-DEP card emulation with {@link HostApduService}
 *    or {@link OffHostApduService}, whenever an Application ID (AID) of this category
 *    is selected, the user is asked which service he wants to use to handle
 *    the transaction, even if there is only one matching service.
 */

public static final int SELECTION_MODE_ALWAYS_ASK = 1; // 0x1

/**
 * Return value for {@link #getSelectionModeForCategory(String)}.
 *
 * <p>In this mode, when using ISO-DEP card emulation with {@link HostApduService}
 *    or {@link OffHostApduService}, the user will only be asked to select a service
 *    if the Application ID (AID) selected by the reader has been registered by multiple
 *    services. If there is only one service that has registered for the AID,
 *    that service will be invoked directly.
 */

public static final int SELECTION_MODE_ASK_IF_CONFLICT = 2; // 0x2

/**
 * Return value for {@link #getSelectionModeForCategory(String)}.
 *
 * <p>In this mode, the user has set a default service for this
 *    category.
 *
 * <p>When using ISO-DEP card emulation with {@link HostApduService}
 *    or {@link OffHostApduService}, if a remote NFC device selects
 *    any of the Application IDs (AIDs)
 *    that the default service has registered in this category,
 *    that service will automatically be bound to to handle
 *    the transaction.
 */

public static final int SELECTION_MODE_PREFER_DEFAULT = 0; // 0x0
}

