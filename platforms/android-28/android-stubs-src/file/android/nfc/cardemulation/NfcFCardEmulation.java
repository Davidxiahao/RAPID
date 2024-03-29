/*
 * Copyright (C) 2015 The Android Open Source Project
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

/**
 * This class can be used to query the state of
 * NFC-F card emulation services.
 *
 * For a general introduction into NFC card emulation,
 * please read the <a href="{@docRoot}guide/topics/connectivity/nfc/hce.html">
 * NFC card emulation developer guide</a>.</p>
 *
 * <p class="note">Use of this class requires the
 * {@link PackageManager#FEATURE_NFC_HOST_CARD_EMULATION_NFCF}
 * to be present on the device.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NfcFCardEmulation {

NfcFCardEmulation() { throw new RuntimeException("Stub!"); }

/**
 * Helper to get an instance of this class.
 *
 * @param adapter A reference to an NfcAdapter object.
 * @return
 */

public static synchronized android.nfc.cardemulation.NfcFCardEmulation getInstance(android.nfc.NfcAdapter adapter) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the current System Code for the specified service.
 *
 * <p>Before calling {@link #registerSystemCodeForService(ComponentName, String)},
 * the System Code contained in the Manifest file is returned. After calling
 * {@link #registerSystemCodeForService(ComponentName, String)}, the System Code
 * registered there is returned. After calling
 * {@link #unregisterSystemCodeForService(ComponentName)}, "null" is returned.
 *
 * @param service The component name of the service
 * @return the current System Code
 */

public java.lang.String getSystemCodeForService(android.content.ComponentName service) throws java.lang.RuntimeException { throw new RuntimeException("Stub!"); }

/**
 * Registers a System Code for the specified service.
 *
 * <p>The System Code must be in range from "4000" to "4FFF" (excluding "4*FF").
 *
 * <p>If a System Code was previously registered for this service
 * (either statically through the manifest, or dynamically by using this API),
 * it will be replaced with this one.
 *
 * <p>Even if the same System Code is already registered for another service,
 * this method succeeds in registering the System Code.
 *
 * <p>Note that you can only register a System Code for a service that
 * is running under the same UID as the caller of this API. Typically
 * this means you need to call this from the same
 * package as the service itself, though UIDs can also
 * be shared between packages using shared UIDs.
 *
 * @param service The component name of the service
 * @param systemCode The System Code to be registered
 * @return whether the registration was successful.
 */

public boolean registerSystemCodeForService(android.content.ComponentName service, java.lang.String systemCode) throws java.lang.RuntimeException { throw new RuntimeException("Stub!"); }

/**
 * Removes a registered System Code for the specified service.
 *
 * @param service The component name of the service
 * @return whether the System Code was successfully removed.
 */

public boolean unregisterSystemCodeForService(android.content.ComponentName service) throws java.lang.RuntimeException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the current NFCID2 for the specified service.
 *
 * <p>Before calling {@link #setNfcid2ForService(ComponentName, String)},
 * the NFCID2 contained in the Manifest file is returned. If "random" is specified
 * in the Manifest file, a random number assigned by the system at installation time
 * is returned. After setting an NFCID2
 * with {@link #setNfcid2ForService(ComponentName, String)}, this NFCID2 is returned.
 *
 * @param service The component name of the service
 * @return the current NFCID2
 */

public java.lang.String getNfcid2ForService(android.content.ComponentName service) throws java.lang.RuntimeException { throw new RuntimeException("Stub!"); }

/**
 * Set a NFCID2 for the specified service.
 *
 * <p>The NFCID2 must be in range from "02FE000000000000" to "02FEFFFFFFFFFFFF".
 *
 * <p>If a NFCID2 was previously set for this service
 * (either statically through the manifest, or dynamically by using this API),
 * it will be replaced.
 *
 * <p>Note that you can only set the NFCID2 for a service that
 * is running under the same UID as the caller of this API. Typically
 * this means you need to call this from the same
 * package as the service itself, though UIDs can also
 * be shared between packages using shared UIDs.
 *
 * @param service The component name of the service
 * @param nfcid2 The NFCID2 to be registered
 * @return whether the setting was successful.
 */

public boolean setNfcid2ForService(android.content.ComponentName service, java.lang.String nfcid2) throws java.lang.RuntimeException { throw new RuntimeException("Stub!"); }

/**
 * Allows a foreground application to specify which card emulation service
 * should be enabled while a specific Activity is in the foreground.
 *
 * <p>The specified HCE-F service is only enabled when the corresponding application is
 * in the foreground and this method has been called. When the application is moved to
 * the background, {@link #disableService(Activity)} is called, or
 * NFCID2 or System Code is replaced, the HCE-F service is disabled.
 *
 * <p>The specified Activity must currently be in resumed state. A good
 * paradigm is to call this method in your {@link Activity#onResume}, and to call
 * {@link #disableService(Activity)} in your {@link Activity#onPause}.
 *
 * <p>Note that this preference is not persisted by the OS, and hence must be
 * called every time the Activity is resumed.
 *
 * @param activity The activity which prefers this service to be invoked
 * @param service The service to be preferred while this activity is in the foreground
 * @return whether the registration was successful
 */

public boolean enableService(android.app.Activity activity, android.content.ComponentName service) throws java.lang.RuntimeException { throw new RuntimeException("Stub!"); }

/**
 * Disables the service for the specified Activity.
 *
 * <p>Note that the specified Activity must still be in resumed
 * state at the time of this call. A good place to call this method
 * is in your {@link Activity#onPause} implementation.
 *
 * @param activity The activity which the service was registered for
 * @return true when successful
 */

public boolean disableService(android.app.Activity activity) throws java.lang.RuntimeException { throw new RuntimeException("Stub!"); }
}

