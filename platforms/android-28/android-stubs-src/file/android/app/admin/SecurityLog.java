/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.app.admin;

import android.util.EventLog.Event;
import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Definitions for working with security logs.
 *
 * <p>Device owner apps can control the logging with
 * {@link DevicePolicyManager#setSecurityLoggingEnabled}. When security logs are enabled, device
 * owner apps receive periodic callbacks from {@link DeviceAdminReceiver#onSecurityLogsAvailable},
 * at which time new batch of logs can be collected via
 * {@link DevicePolicyManager#retrieveSecurityLogs}. {@link SecurityEvent} describes the type and
 * format of security logs being collected.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SecurityLog {

public SecurityLog() { throw new RuntimeException("Stub!"); }

/**
 * Event severity level indicating that the event requires urgent admin action.
 */

public static final int LEVEL_ERROR = 3; // 0x3

/**
 * Event severity level indicating that the event corresponds to normal workflow.
 */

public static final int LEVEL_INFO = 1; // 0x1

/**
 * Event severity level indicating that the event may require admin attention.
 */

public static final int LEVEL_WARNING = 2; // 0x2

/**
 * Indicates that a shell command was issued over ADB via {@code adb shell <command>}
 * The log entry contains a {@code String} payload containing the shell command, accessible
 * via {@link SecurityEvent#getData()}.
 */

public static final int TAG_ADB_SHELL_CMD = 210002; // 0x33452

/**
 * Indicates that an ADB interactive shell was opened via "adb shell".
 * There is no extra payload in the log event.
 */

public static final int TAG_ADB_SHELL_INTERACTIVE = 210001; // 0x33451

/**
 * Indicates that an app process was started. The log entry contains the following
 * information about the process encapsulated in an {@link Object} array, accessible via
 * {@link SecurityEvent#getData()}:
 * <li> [0] process name ({@code String})
 * <li> [1] exact start time in milliseconds according to {@code System.currentTimeMillis()}
 *      ({@code Long})
 * <li> [2] app uid ({@code Integer})
 * <li> [3] app pid ({@code Integer})
 * <li> [4] seinfo tag ({@code String})
 * <li> [5] SHA-256 hash of the base APK in hexadecimal ({@code String})
 */

public static final int TAG_APP_PROCESS_START = 210005; // 0x33455

/**
 * Indicates that a new root certificate has been installed into system's trusted credential
 * storage. The log entry contains the following information about the event, encapsulated in an
 * {@link Object} array and accessible via {@link SecurityEvent#getData()}:
 * <li> [0] result ({@code Integer}, 0 if operation failed, 1 if succeeded)
 * <li> [1] subject of the certificate ({@code String}).
 */

public static final int TAG_CERT_AUTHORITY_INSTALLED = 210029; // 0x3346d

/**
 * Indicates that a new root certificate has been removed from system's trusted credential
 * storage. The log entry contains the following information about the event, encapsulated in an
 * {@link Object} array and accessible via {@link SecurityEvent#getData()}:
 * <li> [0] result ({@code Integer}, 0 if operation failed, 1 if succeeded)
 * <li> [1] subject of the certificate ({@code String}).
 */

public static final int TAG_CERT_AUTHORITY_REMOVED = 210030; // 0x3346e

/**
 * Indicates a failure to validate X.509v3 certificate. The log entry contains a {@code String}
 * payload indicating the failure reason, accessible via {@link SecurityEvent#getData()}.
 */

public static final int TAG_CERT_VALIDATION_FAILURE = 210033; // 0x33471

/**
 * Indicates that cryptographic functionality self test has completed. The log entry contains an
 * {@code Integer} payload, indicating the result of the test (0 if the test failed, 1 if
 * succeeded) and accessible via {@link SecurityEvent#getData()}.
 */

public static final int TAG_CRYPTO_SELF_TEST_COMPLETED = 210031; // 0x3346f

/**
 * Indicates that an admin has set disabled keyguard features. The log entry contains the
 * following information about the event encapsulated in an {@link Object} array, accessible via
 * {@link SecurityEvent#getData()}:
 * <li> [0] admin package name ({@code String})
 * <li> [1] admin user ID ({@code Integer})
 * <li> [2] target user ID ({@code Integer})
 * <li> [3] disabled keyguard feature mask ({@code Integer}).
 * @see DevicePolicyManager#setKeyguardDisabledFeatures(ComponentName, int)
 */

public static final int TAG_KEYGUARD_DISABLED_FEATURES_SET = 210021; // 0x33465

/**
 * Indicates that keyguard has been dismissed.
 * There is no extra payload in the log event.
 */

public static final int TAG_KEYGUARD_DISMISSED = 210006; // 0x33456

/**
 * Indicates that there has been an authentication attempt to dismiss the keyguard. The log
 * entry contains the following information about the attempt encapsulated in an {@link Object}
 * array, accessible via {@link SecurityEvent#getData()}:
 * <li> [0] attempt result ({@code Integer}, 1 for successful, 0 for unsuccessful)
 * <li> [1] strength of authentication method ({@code Integer}, 1 if strong authentication
 *      method was used, 0 otherwise)
 */

public static final int TAG_KEYGUARD_DISMISS_AUTH_ATTEMPT = 210007; // 0x33457

/**
 * Indicates that the device has been locked, either by the user or by a timeout. There is no
 * extra payload in the log event.
 */

public static final int TAG_KEYGUARD_SECURED = 210008; // 0x33458

/**
 * Indicates that a cryptographic key was destroyed. The log entry contains the following
 * information about the event, encapsulated in an {@link Object} array and accessible via
 * {@link SecurityEvent#getData()}:
 * <li> [0] result ({@code Integer}, 0 if operation failed, 1 if succeeded)
 * <li> [1] alias of the key ({@code String})
 * <li> [2] requesting process uid ({@code Integer}).
 */

public static final int TAG_KEY_DESTRUCTION = 210026; // 0x3346a

/**
 * Indicates that an authentication key was generated. The log entry contains the following
 * information about the event, encapsulated in an {@link Object} array and accessible via
 * {@link SecurityEvent#getData()}:
 * <li> [0] result ({@code Integer}, 0 if operation failed, 1 if succeeded)
 * <li> [1] alias of the key ({@code String})
 * <li> [2] requesting process uid ({@code Integer}).
 */

public static final int TAG_KEY_GENERATED = 210024; // 0x33468

/**
 * Indicates that a cryptographic key was imported. The log entry contains the following
 * information about the event, encapsulated in an {@link Object} array and accessible via
 * {@link SecurityEvent#getData()}:
 * <li> [0] result ({@code Integer}, 0 if operation failed, 1 if succeeded)
 * <li> [1] alias of the key ({@code String})
 * <li> [2] requesting process uid ({@code Integer}).
 */

public static final int TAG_KEY_IMPORT = 210025; // 0x33469

/**
 * Indicates a failed cryptographic key integrity check. The log entry contains the following
 * information about the event, encapsulated in an {@link Object} array and accessible via
 * {@link SecurityEvent#getData()}:
 * <li> [0] alias of the key ({@code String})
 * <li> [1] owner application uid ({@code Integer}).
 */

public static final int TAG_KEY_INTEGRITY_VIOLATION = 210032; // 0x33470

/**
 * Indicates start-up of audit logging. There is no extra payload in the log event.
 */

public static final int TAG_LOGGING_STARTED = 210011; // 0x3345b

/**
 * Indicates shutdown of audit logging. There is no extra payload in the log event.
 */

public static final int TAG_LOGGING_STOPPED = 210012; // 0x3345c

/**
 * Indicates that the audit log buffer has reached 90% of its capacity. There is no extra
 * payload in the log event.
 */

public static final int TAG_LOG_BUFFER_SIZE_CRITICAL = 210015; // 0x3345f

/**
 * Indicates that an admin has set a maximum number of failed password attempts before wiping
 * data. The log entry contains the following information about the event encapsulated in an
 * {@link Object} array, accessible via {@link SecurityEvent#getData()}:
 * <li> [0] admin package name ({@code String})
 * <li> [1] admin user ID ({@code Integer})
 * <li> [2] target user ID ({@code Integer})
 * <li> [3] new maximum number of failed password attempts ({@code Integer})
 * @see DevicePolicyManager#setMaximumFailedPasswordsForWipe(ComponentName, int)
 */

public static final int TAG_MAX_PASSWORD_ATTEMPTS_SET = 210020; // 0x33464

/**
 * Indicates that an admin has set a maximum screen lock timeout. The log entry contains the
 * following information about the event encapsulated in an {@link Object} array, accessible
 * via {@link SecurityEvent#getData()}:
 * <li> [0] admin package name ({@code String})
 * <li> [1] admin user ID ({@code Integer})
 * <li> [2] target user ID ({@code Integer})
 * <li> [3] new screen lock timeout in milliseconds ({@code Long})
 * @see DevicePolicyManager#setMaximumTimeToLock(ComponentName, long)
 */

public static final int TAG_MAX_SCREEN_LOCK_TIMEOUT_SET = 210019; // 0x33463

/**
 * Indicates that removable media has been mounted on the device. The log entry contains the
 * following information about the event, encapsulated in an {@link Object} array and
 * accessible via {@link SecurityEvent#getData()}:
 * <li> [0] mount point ({@code String})
 * <li> [1] volume label ({@code String}).
 */

public static final int TAG_MEDIA_MOUNT = 210013; // 0x3345d

/**
 * Indicates that removable media was unmounted from the device. The log entry contains the
 * following information about the event, encapsulated in an {@link Object} array and
 * accessible via {@link SecurityEvent#getData()}:
 * <li> [0] mount point ({@code String})
 * <li> [1] volume label ({@code String}).
 */

public static final int TAG_MEDIA_UNMOUNT = 210014; // 0x3345e

/**
 * Indicates that the Android OS has shutdown. There is no extra payload in the log event.
 */

public static final int TAG_OS_SHUTDOWN = 210010; // 0x3345a

/**
 * Indicates that the Android OS has started. The log entry contains the following information
 * about the startup time software integrity check encapsulated in an {@link Object} array,
 * accessible via {@link SecurityEvent#getData()}:
 * <li> [0] Verified Boot state ({@code String})
 * <li> [1] dm-verity mode ({@code String}).
 * <p>Verified Boot state can be one of the following:
 * <li> {@code green} indicates that there is a full chain of trust extending from the
 * bootloader to verified partitions including the bootloader, boot partition, and all verified
 * partitions.
 * <li> {@code yellow} indicates that the boot partition has been verified using the embedded
 * certificate and the signature is valid.
 * <li> {@code orange} indicates that the device may be freely modified. Device integrity is
 * left to the user to verify out-of-band.
 * <p>dm-verity mode can be one of the following:
 * <li> {@code enforcing} indicates that the device will be restarted when corruption is
 * detected.
 * <li> {@code eio} indicates that an I/O error will be returned for an attempt to read
 * corrupted data blocks.
 * For details see Verified Boot documentation.
 */

public static final int TAG_OS_STARTUP = 210009; // 0x33459

/**
 * Indicates that an admin has set a requirement for password complexity. The log entry contains
 * the following information about the event, encapsulated in an {@link Object} array and
 * accessible via {@link SecurityEvent#getData()}:
 * <li> [0] admin package name ({@code String})
 * <li> [1] admin user ID ({@code Integer})
 * <li> [2] target user ID ({@code Integer})
 * <li> [3] minimum password length ({@code Integer})
 * <li> [4] password quality constraint ({@code Integer})
 * <li> [5] minimum number of letters ({@code Integer})
 * <li> [6] minimum number of non-letters ({@code Integer})
 * <li> [7] minimum number of digits ({@code Integer})
 * <li> [8] minimum number of uppercase letters ({@code Integer})
 * <li> [9] minimum number of lowercase letters ({@code Integer})
 * <li> [10] minimum number of symbols ({@code Integer})
 *
 * @see DevicePolicyManager#setPasswordMinimumLength(ComponentName, int)
 * @see DevicePolicyManager#setPasswordQuality(ComponentName, int)
 * @see DevicePolicyManager#setPasswordMinimumLetters(ComponentName, int)
 * @see DevicePolicyManager#setPasswordMinimumNonLetter(ComponentName, int)
 * @see DevicePolicyManager#setPasswordMinimumLowerCase(ComponentName, int)
 * @see DevicePolicyManager#setPasswordMinimumUpperCase(ComponentName, int)
 * @see DevicePolicyManager#setPasswordMinimumNumeric(ComponentName, int)
 * @see DevicePolicyManager#setPasswordMinimumSymbols(ComponentName, int)
 */

public static final int TAG_PASSWORD_COMPLEXITY_SET = 210017; // 0x33461

/**
 * Indicates that an admin has set a password expiration timeout. The log entry contains the
 * following information about the event, encapsulated in an {@link Object} array and accessible
 * via {@link SecurityEvent#getData()}:
 * <li> [0] admin package name ({@code String})
 * <li> [1] admin user ID ({@code Integer})
 * <li> [2] target user ID ({@code Integer})
 * <li> [3] new password expiration timeout in milliseconds ({@code Long}).
 * @see DevicePolicyManager#setPasswordExpirationTimeout(ComponentName, long)
 */

public static final int TAG_PASSWORD_EXPIRATION_SET = 210016; // 0x33460

/**
 * Indicates that an admin has set a password history length. The log entry contains the
 * following information about the event encapsulated in an {@link Object} array, accessible
 * via {@link SecurityEvent#getData()}:
 * <li> [0] admin package name ({@code String})
 * <li> [1] admin user ID ({@code Integer})
 * <li> [2] target user ID ({@code Integer})
 * <li> [3] new password history length value ({@code Integer})
 * @see DevicePolicyManager#setPasswordHistoryLength(ComponentName, int)
 */

public static final int TAG_PASSWORD_HISTORY_LENGTH_SET = 210018; // 0x33462

/**
 * Indicates that an admin remotely locked the device or profile. The log entry contains the
 * following information about the event encapsulated in an {@link Object} array, accessible via
 * {@link SecurityEvent#getData()}:
 * <li> [0] admin package name ({@code String}),
 * <li> [1] admin user ID ({@code Integer}).
 * <li> [2] target user ID ({@code Integer})
 */

public static final int TAG_REMOTE_LOCK = 210022; // 0x33466

/**
 * Indicates that a file was pulled from the device via the adb daemon, for example via
 * {@code adb pull}. The log entry contains a {@code String} payload containing the path of the
 * pulled file on the device, accessible via {@link SecurityEvent#getData()}.
 */

public static final int TAG_SYNC_RECV_FILE = 210003; // 0x33453

/**
 * Indicates that a file was pushed to the device via the adb daemon, for example via
 * {@code adb push}. The log entry contains a {@code String} payload containing the destination
 * path of the pushed file, accessible via {@link SecurityEvent#getData()}.
 */

public static final int TAG_SYNC_SEND_FILE = 210004; // 0x33454

/**
 * Indicates that an admin has set a user restriction. The log entry contains the following
 * information about the event, encapsulated in an {@link Object} array and accessible via
 * {@link SecurityEvent#getData()}:
 * <li> [0] admin package name ({@code String})
 * <li> [1] admin user ID ({@code Integer})
 * <li> [2] user restriction ({@code String})
 * @see DevicePolicyManager#addUserRestriction(ComponentName, String)
 */

public static final int TAG_USER_RESTRICTION_ADDED = 210027; // 0x3346b

/**
 * Indicates that an admin has removed a user restriction. The log entry contains the following
 * information about the event, encapsulated in an {@link Object} array and accessible via
 * {@link SecurityEvent#getData()}:
 * <li> [0] admin package name ({@code String})
 * <li> [1] admin user ID ({@code Integer})
 * <li> [2] user restriction ({@code String})
 * @see DevicePolicyManager#clearUserRestriction(ComponentName, String)
 */

public static final int TAG_USER_RESTRICTION_REMOVED = 210028; // 0x3346c

/**
 * Indicates a failure to wipe device or user data. There is no extra payload in the log event.
 */

public static final int TAG_WIPE_FAILURE = 210023; // 0x33467
/**
 * A class representing a security event log entry.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SecurityEvent implements android.os.Parcelable {

/**
 * Constructor used by native classes to generate SecurityEvent instances.
 * @hide
 */

SecurityEvent(byte[] data) { throw new RuntimeException("Stub!"); }

/**
 * Returns the timestamp in nano seconds when this event was logged.
 */

public long getTimeNanos() { throw new RuntimeException("Stub!"); }

/**
 * Returns the tag of this log entry, which specifies entry's semantics.

 * @return Value is {@link android.app.admin.SecurityLog#TAG_ADB_SHELL_INTERACTIVE}, {@link android.app.admin.SecurityLog#TAG_ADB_SHELL_CMD}, {@link android.app.admin.SecurityLog#TAG_SYNC_RECV_FILE}, {@link android.app.admin.SecurityLog#TAG_SYNC_SEND_FILE}, {@link android.app.admin.SecurityLog#TAG_APP_PROCESS_START}, {@link android.app.admin.SecurityLog#TAG_KEYGUARD_DISMISSED}, {@link android.app.admin.SecurityLog#TAG_KEYGUARD_DISMISS_AUTH_ATTEMPT}, {@link android.app.admin.SecurityLog#TAG_KEYGUARD_SECURED}, {@link android.app.admin.SecurityLog#TAG_OS_STARTUP}, {@link android.app.admin.SecurityLog#TAG_OS_SHUTDOWN}, {@link android.app.admin.SecurityLog#TAG_LOGGING_STARTED}, {@link android.app.admin.SecurityLog#TAG_LOGGING_STOPPED}, {@link android.app.admin.SecurityLog#TAG_MEDIA_MOUNT}, {@link android.app.admin.SecurityLog#TAG_MEDIA_UNMOUNT}, {@link android.app.admin.SecurityLog#TAG_LOG_BUFFER_SIZE_CRITICAL}, {@link android.app.admin.SecurityLog#TAG_PASSWORD_EXPIRATION_SET}, {@link android.app.admin.SecurityLog#TAG_PASSWORD_COMPLEXITY_SET}, {@link android.app.admin.SecurityLog#TAG_PASSWORD_HISTORY_LENGTH_SET}, {@link android.app.admin.SecurityLog#TAG_MAX_SCREEN_LOCK_TIMEOUT_SET}, {@link android.app.admin.SecurityLog#TAG_MAX_PASSWORD_ATTEMPTS_SET}, {@link android.app.admin.SecurityLog#TAG_KEYGUARD_DISABLED_FEATURES_SET}, {@link android.app.admin.SecurityLog#TAG_REMOTE_LOCK}, {@link android.app.admin.SecurityLog#TAG_USER_RESTRICTION_ADDED}, {@link android.app.admin.SecurityLog#TAG_USER_RESTRICTION_REMOVED}, {@link android.app.admin.SecurityLog#TAG_WIPE_FAILURE}, {@link android.app.admin.SecurityLog#TAG_KEY_GENERATED}, {@link android.app.admin.SecurityLog#TAG_KEY_IMPORT}, {@link android.app.admin.SecurityLog#TAG_KEY_DESTRUCTION}, {@link android.app.admin.SecurityLog#TAG_CERT_AUTHORITY_INSTALLED}, {@link android.app.admin.SecurityLog#TAG_CERT_AUTHORITY_REMOVED}, {@link android.app.admin.SecurityLog#TAG_CRYPTO_SELF_TEST_COMPLETED}, {@link android.app.admin.SecurityLog#TAG_KEY_INTEGRITY_VIOLATION}, or {@link android.app.admin.SecurityLog#TAG_CERT_VALIDATION_FAILURE}
 */

public int getTag() { throw new RuntimeException("Stub!"); }

/**
 * Returns the payload contained in this log entry or {@code null} if there is no payload.
 */

public java.lang.Object getData() { throw new RuntimeException("Stub!"); }

/**
 * Returns the id of the event, where the id monotonically increases for each event. The id
 * is reset when the device reboots, and when security logging is enabled.
 */

public long getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns severity level for the event.

 * @return Value is {@link android.app.admin.SecurityLog#LEVEL_INFO}, {@link android.app.admin.SecurityLog#LEVEL_WARNING}, or {@link android.app.admin.SecurityLog#LEVEL_ERROR}
 */

public int getLogLevel() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * @hide
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.admin.SecurityLog.SecurityEvent> CREATOR;
static { CREATOR = null; }
}

}

