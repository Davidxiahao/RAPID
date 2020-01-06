/**
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


package android.hardware.fingerprint;

import android.hardware.biometrics.BiometricPrompt;
import android.content.pm.PackageManager;
import java.util.concurrent.Executor;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Bundle;
import javax.crypto.Mac;
import java.security.Signature;
import javax.crypto.Cipher;

/**
 * A class that coordinates access to the fingerprint hardware.
 * Requires the {@link android.content.pm.PackageManager#FEATURE_FINGERPRINT PackageManager#FEATURE_FINGERPRINT} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @deprecated See {@link BiometricPrompt} which shows a system-provided dialog upon starting
 * authentication. In a world where devices may have different types of biometric authentication,
 * it's much more realistic to have a system-provided authentication dialog since the method may
 * vary by vendor/device.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public class FingerprintManager {

FingerprintManager() { throw new RuntimeException("Stub!"); }

/**
 * Request authentication of a crypto object. This call warms up the fingerprint hardware
 * and starts scanning for a fingerprint. It terminates when
 * {@link AuthenticationCallback#onAuthenticationError(int, CharSequence)} or
 * {@link AuthenticationCallback#onAuthenticationSucceeded(AuthenticationResult)} is called, at
 * which point the object is no longer valid. The operation can be canceled by using the
 * provided cancel object.
 *
 * Requires {@link android.Manifest.permission#USE_BIOMETRIC} or {@link android.Manifest.permission#USE_FINGERPRINT}
 * @param crypto object associated with the call or null if none required.
 * This value may be {@code null}.
 * @param cancel an object that can be used to cancel authentication
 * This value may be {@code null}.
 * @param flags optional flags; should be 0
 * @param callback an object to receive authentication events
 * This value must never be {@code null}.
 * @param handler an optional handler to handle callback events
 *
 * This value may be {@code null}.
 * @throws IllegalArgumentException if the crypto operation is not supported or is not backed
 *         by <a href="{@docRoot}training/articles/keystore.html">Android Keystore
 *         facility</a>.
 * @throws IllegalStateException if the crypto primitive is not initialized.
 * @deprecated See {@link BiometricPrompt#authenticate(CancellationSignal, Executor,
 * BiometricPrompt.AuthenticationCallback)} and {@link BiometricPrompt#authenticate(
 * BiometricPrompt.CryptoObject, CancellationSignal, Executor,
 * BiometricPrompt.AuthenticationCallback)}
 */

@Deprecated public void authenticate(@androidx.annotation.RecentlyNullable android.hardware.fingerprint.FingerprintManager.CryptoObject crypto, @androidx.annotation.RecentlyNullable android.os.CancellationSignal cancel, int flags, @androidx.annotation.RecentlyNonNull android.hardware.fingerprint.FingerprintManager.AuthenticationCallback callback, @androidx.annotation.RecentlyNullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Determine if there is at least one fingerprint enrolled.
 *
 * Requires {@link android.Manifest.permission#USE_FINGERPRINT}
 * @return true if at least one fingerprint is enrolled, false otherwise
 * @deprecated See {@link BiometricPrompt} and
 * {@link FingerprintManager#FINGERPRINT_ERROR_NO_FINGERPRINTS}
 */

@Deprecated public boolean hasEnrolledFingerprints() { throw new RuntimeException("Stub!"); }

/**
 * Determine if fingerprint hardware is present and functional.
 *
 * Requires {@link android.Manifest.permission#USE_FINGERPRINT}
 * @return true if hardware is present and functional, false otherwise.
 * @deprecated See {@link BiometricPrompt} and
 * {@link FingerprintManager#FINGERPRINT_ERROR_HW_UNAVAILABLE}
 */

@Deprecated public boolean isHardwareDetected() { throw new RuntimeException("Stub!"); }

/**
 * The image acquired was good.
 */

public static final int FINGERPRINT_ACQUIRED_GOOD = 0; // 0x0

/**
 * The fingerprint image was too noisy due to suspected or detected dirt on the sensor.
 * For example, it's reasonable return this after multiple
 * {@link #FINGERPRINT_ACQUIRED_INSUFFICIENT} or actual detection of dirt on the sensor
 * (stuck pixels, swaths, etc.). The user is expected to take action to clean the sensor
 * when this is returned.
 */

public static final int FINGERPRINT_ACQUIRED_IMAGER_DIRTY = 3; // 0x3

/**
 * The fingerprint image was too noisy to process due to a detected condition (i.e. dry skin) or
 * a possibly dirty sensor (See {@link #FINGERPRINT_ACQUIRED_IMAGER_DIRTY}).
 */

public static final int FINGERPRINT_ACQUIRED_INSUFFICIENT = 2; // 0x2

/**
 * Only a partial fingerprint image was detected. During enrollment, the user should be
 * informed on what needs to happen to resolve this problem, e.g. "press firmly on sensor."
 */

public static final int FINGERPRINT_ACQUIRED_PARTIAL = 1; // 0x1

/**
 * The fingerprint image was incomplete due to quick motion. While mostly appropriate for
 * linear array sensors,  this could also happen if the finger was moved during acquisition.
 * The user should be asked to move the finger slower (linear) or leave the finger on the sensor
 * longer.
 */

public static final int FINGERPRINT_ACQUIRED_TOO_FAST = 5; // 0x5

/**
 * The fingerprint image was unreadable due to lack of motion. This is most appropriate for
 * linear array sensors that require a swipe motion.
 */

public static final int FINGERPRINT_ACQUIRED_TOO_SLOW = 4; // 0x4

/**
 * The operation was canceled because the fingerprint sensor is unavailable. For example,
 * this may happen when the user is switched, the device is locked or another pending operation
 * prevents or disables it.
 */

public static final int FINGERPRINT_ERROR_CANCELED = 5; // 0x5

/**
 * The device does not have a fingerprint sensor.
 */

public static final int FINGERPRINT_ERROR_HW_NOT_PRESENT = 12; // 0xc

/**
 * The hardware is unavailable. Try again later.
 */

public static final int FINGERPRINT_ERROR_HW_UNAVAILABLE = 1; // 0x1

/**
 * The operation was canceled because the API is locked out due to too many attempts.
 * This occurs after 5 failed attempts, and lasts for 30 seconds.
 */

public static final int FINGERPRINT_ERROR_LOCKOUT = 7; // 0x7

/**
 * The operation was canceled because FINGERPRINT_ERROR_LOCKOUT occurred too many times.
 * Fingerprint authentication is disabled until the user unlocks with strong authentication
 * (PIN/Pattern/Password)
 */

public static final int FINGERPRINT_ERROR_LOCKOUT_PERMANENT = 9; // 0x9

/**
 * The user does not have any fingerprints enrolled.
 */

public static final int FINGERPRINT_ERROR_NO_FINGERPRINTS = 11; // 0xb

/**
 * Error state returned for operations like enrollment; the operation cannot be completed
 * because there's not enough storage remaining to complete the operation.
 */

public static final int FINGERPRINT_ERROR_NO_SPACE = 4; // 0x4

/**
 * Error state returned when the current request has been running too long. This is intended to
 * prevent programs from waiting for the fingerprint sensor indefinitely. The timeout is
 * platform and sensor-specific, but is generally on the order of 30 seconds.
 */

public static final int FINGERPRINT_ERROR_TIMEOUT = 3; // 0x3

/**
 * Error state returned when the sensor was unable to process the current image.
 */

public static final int FINGERPRINT_ERROR_UNABLE_TO_PROCESS = 2; // 0x2

/**
 * The user canceled the operation. Upon receiving this, applications should use alternate
 * authentication (e.g. a password). The application should also provide the means to return
 * to fingerprint authentication, such as a "use fingerprint" button.
 */

public static final int FINGERPRINT_ERROR_USER_CANCELED = 10; // 0xa

/**
 * Hardware vendors may extend this list if there are conditions that do not fall under one of
 * the above categories. Vendors are responsible for providing error strings for these errors.
 * These messages are typically reserved for internal operations such as enrollment, but may be
 * used to express vendor errors not covered by the ones in fingerprint.h. Applications are
 * expected to show the error message string if they happen, but are advised not to rely on the
 * message id since they will be device and vendor-specific
 */

public static final int FINGERPRINT_ERROR_VENDOR = 8; // 0x8
/**
 * Callback structure provided to {@link FingerprintManager#authenticate(CryptoObject,
 * CancellationSignal, int, AuthenticationCallback, Handler)}. Users of {@link
 * FingerprintManager#authenticate(CryptoObject, CancellationSignal,
 * int, AuthenticationCallback, Handler) } must provide an implementation of this for listening to
 * fingerprint events.
 * @deprecated See {@link android.hardware.biometrics.BiometricPrompt.AuthenticationCallback}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public abstract static class AuthenticationCallback {

public AuthenticationCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when an unrecoverable error has been encountered and the operation is complete.
 * No further callbacks will be made on this object.
 * @param errorCode An integer identifying the error message
 * @param errString A human-readable error string that can be shown in UI
 */

public void onAuthenticationError(int errorCode, java.lang.CharSequence errString) { throw new RuntimeException("Stub!"); }

/**
 * Called when a recoverable error has been encountered during authentication. The help
 * string is provided to give the user guidance for what went wrong, such as
 * "Sensor dirty, please clean it."
 * @param helpCode An integer identifying the error message
 * @param helpString A human-readable string that can be shown in UI
 */

public void onAuthenticationHelp(int helpCode, java.lang.CharSequence helpString) { throw new RuntimeException("Stub!"); }

/**
 * Called when a fingerprint is recognized.
 * @param result An object containing authentication-related data
 */

public void onAuthenticationSucceeded(android.hardware.fingerprint.FingerprintManager.AuthenticationResult result) { throw new RuntimeException("Stub!"); }

/**
 * Called when a fingerprint is valid but not recognized.
 */

public void onAuthenticationFailed() { throw new RuntimeException("Stub!"); }
}

/**
 * Container for callback data from {@link FingerprintManager#authenticate(CryptoObject,
 *     CancellationSignal, int, AuthenticationCallback, Handler)}.
 * @deprecated See {@link android.hardware.biometrics.BiometricPrompt.AuthenticationResult}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public static class AuthenticationResult {

AuthenticationResult() { throw new RuntimeException("Stub!"); }

/**
 * Obtain the crypto object associated with this transaction
 * @return crypto object provided to {@link FingerprintManager#authenticate(CryptoObject,
 *     CancellationSignal, int, AuthenticationCallback, Handler)}.
 */

public android.hardware.fingerprint.FingerprintManager.CryptoObject getCryptoObject() { throw new RuntimeException("Stub!"); }
}

/**
 * A wrapper class for the crypto objects supported by FingerprintManager. Currently the
 * framework supports {@link Signature}, {@link Cipher} and {@link Mac} objects.
 * @deprecated See {@link android.hardware.biometrics.BiometricPrompt.CryptoObject}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public static final class CryptoObject {

/**
 * @param signature This value must never be {@code null}.
 */

public CryptoObject(@androidx.annotation.RecentlyNonNull java.security.Signature signature) { throw new RuntimeException("Stub!"); }

/**
 * @param cipher This value must never be {@code null}.
 */

public CryptoObject(@androidx.annotation.RecentlyNonNull javax.crypto.Cipher cipher) { throw new RuntimeException("Stub!"); }

/**
 * @param mac This value must never be {@code null}.
 */

public CryptoObject(@androidx.annotation.RecentlyNonNull javax.crypto.Mac mac) { throw new RuntimeException("Stub!"); }

/**
 * Get {@link Signature} object.
 * @return {@link Signature} object or null if this doesn't contain one.
 */

public java.security.Signature getSignature() { throw new RuntimeException("Stub!"); }

/**
 * Get {@link Cipher} object.
 * @return {@link Cipher} object or null if this doesn't contain one.
 */

public javax.crypto.Cipher getCipher() { throw new RuntimeException("Stub!"); }

/**
 * Get {@link Mac} object.
 * @return {@link Mac} object or null if this doesn't contain one.
 */

public javax.crypto.Mac getMac() { throw new RuntimeException("Stub!"); }
}

}

