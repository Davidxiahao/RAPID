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


package android.content.pm;

import java.io.IOException;
import android.app.ActivityManager;
import android.Manifest;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.content.IntentSender;
import java.io.OutputStream;
import android.os.Message;
import java.security.MessageDigest;
import android.net.Uri;

/**
 * Offers the ability to install, upgrade, and remove applications on the
 * device. This includes support for apps packaged either as a single
 * "monolithic" APK, or apps packaged as multiple "split" APKs.
 * <p>
 * An app is delivered for installation through a
 * {@link PackageInstaller.Session}, which any app can create. Once the session
 * is created, the installer can stream one or more APKs into place until it
 * decides to either commit or destroy the session. Committing may require user
 * intervention to complete the installation.
 * <p>
 * Sessions can install brand new apps, upgrade existing apps, or add new splits
 * into an existing app.
 * <p>
 * Apps packaged as multiple split APKs always consist of a single "base" APK
 * (with a {@code null} split name) and zero or more "split" APKs (with unique
 * split names). Any subset of these APKs can be installed together, as long as
 * the following constraints are met:
 * <ul>
 * <li>All APKs must have the exact same package name, version code, and signing
 * certificates.
 * <li>All APKs must have unique split names.
 * <li>All installations must contain a single base APK.
 * </ul>
 * <p>
 * The ApiDemos project contains examples of using this API:
 * <code>ApiDemos/src/com/example/android/apis/content/InstallApk*.java</code>.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PackageInstaller {

PackageInstaller() { throw new RuntimeException("Stub!"); }

/**
 * Create a new session using the given parameters, returning a unique ID
 * that represents the session. Once created, the session can be opened
 * multiple times across multiple device boots.
 * <p>
 * The system may automatically destroy sessions that have not been
 * finalized (either committed or abandoned) within a reasonable period of
 * time, typically on the order of a day.
 *
 * @throws IOException if parameters were unsatisfiable, such as lack of
 *             disk space or unavailable media.
 * @throws SecurityException when installation services are unavailable,
 *             such as when called from a restricted user.
 * @throws IllegalArgumentException when {@link SessionParams} is invalid.
 * @param params This value must never be {@code null}.
 * @return positive, non-zero unique ID that represents the created session.
 *         This ID remains consistent across device reboots until the
 *         session is finalized. IDs are not reused during a given boot.
 */

public int createSession(@androidx.annotation.RecentlyNonNull android.content.pm.PackageInstaller.SessionParams params) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Open an existing session to actively perform work. To succeed, the caller
 * must be the owner of the install session.
 *
 * @throws IOException if parameters were unsatisfiable, such as lack of
 *             disk space or unavailable media.
 * @throws SecurityException when the caller does not own the session, or
 *             the session is invalid.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.PackageInstaller.Session openSession(int sessionId) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Update the icon representing the app being installed in a specific
 * session. This should be roughly
 * {@link ActivityManager#getLauncherLargeIconSize()} in both dimensions.
 *
 * @throws SecurityException when the caller does not own the session, or
 *             the session is invalid.

 * @param appIcon This value may be {@code null}.
 */

public void updateSessionAppIcon(int sessionId, @androidx.annotation.RecentlyNullable android.graphics.Bitmap appIcon) { throw new RuntimeException("Stub!"); }

/**
 * Update the label representing the app being installed in a specific
 * session.
 *
 * @throws SecurityException when the caller does not own the session, or
 *             the session is invalid.

 * @param appLabel This value may be {@code null}.
 */

public void updateSessionAppLabel(int sessionId, @androidx.annotation.RecentlyNullable java.lang.CharSequence appLabel) { throw new RuntimeException("Stub!"); }

/**
 * Completely abandon the given session, destroying all staged data and
 * rendering it invalid. Abandoned sessions will be reported to
 * {@link SessionCallback} listeners as failures. This is equivalent to
 * opening the session and calling {@link Session#abandon()}.
 *
 * @throws SecurityException when the caller does not own the session, or
 *             the session is invalid.
 */

public void abandonSession(int sessionId) { throw new RuntimeException("Stub!"); }

/**
 * Return details for a specific session. No special permissions are
 * required to retrieve these details.
 *
 * @return details for the requested session, or {@code null} if the session
 *         does not exist.
 */

@androidx.annotation.RecentlyNullable public android.content.pm.PackageInstaller.SessionInfo getSessionInfo(int sessionId) { throw new RuntimeException("Stub!"); }

/**
 * Return list of all known install sessions, regardless of the installer.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<android.content.pm.PackageInstaller.SessionInfo> getAllSessions() { throw new RuntimeException("Stub!"); }

/**
 * Return list of all known install sessions owned by the calling app.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<android.content.pm.PackageInstaller.SessionInfo> getMySessions() { throw new RuntimeException("Stub!"); }

/**
 * Uninstall the given package, removing it completely from the device. This
 * method is available to:
 * <ul>
 * <li>the current "installer of record" for the package
 * <li>the device owner
 * <li>the affiliated profile owner
 * </ul>
 *
 * Requires {@link android.Manifest.permission#DELETE_PACKAGES} or {@link android.Manifest.permission#REQUEST_DELETE_PACKAGES}
 * @param packageName The package to uninstall.
 * This value must never be {@code null}.
 * @param statusReceiver Where to deliver the result.
 *
 * This value must never be {@code null}.
 * @see android.app.admin.DevicePolicyManager
 */

public void uninstall(@androidx.annotation.RecentlyNonNull java.lang.String packageName, @androidx.annotation.RecentlyNonNull android.content.IntentSender statusReceiver) { throw new RuntimeException("Stub!"); }

/**
 * Uninstall the given package with a specific version code, removing it
 * completely from the device. If the version code of the package
 * does not match the one passed in the versioned package argument this
 * method is a no-op. Use {@link PackageManager#VERSION_CODE_HIGHEST} to
 * uninstall the latest version of the package.
 * <p>
 * This method is available to:
 * <ul>
 * <li>the current "installer of record" for the package
 * <li>the device owner
 * <li>the affiliated profile owner
 * </ul>
 *
 * Requires {@link android.Manifest.permission#DELETE_PACKAGES} or {@link android.Manifest.permission#REQUEST_DELETE_PACKAGES}
 * @param versionedPackage The versioned package to uninstall.
 * This value must never be {@code null}.
 * @param statusReceiver Where to deliver the result.
 *
 * This value must never be {@code null}.
 * @see android.app.admin.DevicePolicyManager
 */

public void uninstall(@androidx.annotation.RecentlyNonNull android.content.pm.VersionedPackage versionedPackage, @androidx.annotation.RecentlyNonNull android.content.IntentSender statusReceiver) { throw new RuntimeException("Stub!"); }

/**
 * Register to watch for session lifecycle events. No special permissions
 * are required to watch for these events.

 * @param callback This value must never be {@code null}.
 */

public void registerSessionCallback(@androidx.annotation.RecentlyNonNull android.content.pm.PackageInstaller.SessionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Register to watch for session lifecycle events. No special permissions
 * are required to watch for these events.
 *
 * @param handler to dispatch callback events through, otherwise uses
 *            calling thread.
 
 * This value must never be {@code null}.
 * @param callback This value must never be {@code null}.
 */

public void registerSessionCallback(@androidx.annotation.RecentlyNonNull android.content.pm.PackageInstaller.SessionCallback callback, @androidx.annotation.RecentlyNonNull android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregister a previously registered callback.

 * @param callback This value must never be {@code null}.
 */

public void unregisterSessionCallback(@androidx.annotation.RecentlyNonNull android.content.pm.PackageInstaller.SessionCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: Explicit broadcast sent to the last known default launcher when a session
 * for a new install is committed. For managed profile, this is sent to the default launcher
 * of the primary profile.
 * <p>
 * The associated session is defined in {@link #EXTRA_SESSION} and the user for which this
 * session was created in {@link Intent#EXTRA_USER}.
 */

public static final java.lang.String ACTION_SESSION_COMMITTED = "android.content.pm.action.SESSION_COMMITTED";

/**
 * Activity Action: Show details about a particular install session. This
 * may surface actions such as pause, resume, or cancel.
 * <p>
 * This should always be scoped to the installer package that owns the
 * session. Clients should use {@link SessionInfo#createDetailsIntent()} to
 * build this intent correctly.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you safeguard
 * against this.
 * <p>
 * The session to show details for is defined in {@link #EXTRA_SESSION_ID}.
 */

public static final java.lang.String ACTION_SESSION_DETAILS = "android.content.pm.action.SESSION_DETAILS";

/**
 * Another package name relevant to a status. This is typically the package
 * responsible for causing an operation failure.
 *
 * @see Intent#getStringExtra(String)
 */

public static final java.lang.String EXTRA_OTHER_PACKAGE_NAME = "android.content.pm.extra.OTHER_PACKAGE_NAME";

/**
 * Package name that an operation is working with.
 *
 * @see Intent#getStringExtra(String)
 */

public static final java.lang.String EXTRA_PACKAGE_NAME = "android.content.pm.extra.PACKAGE_NAME";

/**
 * {@link SessionInfo} that an operation is working with.
 *
 * @see Intent#getParcelableExtra(String)
 */

public static final java.lang.String EXTRA_SESSION = "android.content.pm.extra.SESSION";

/**
 * An integer session ID that an operation is working with.
 *
 * @see Intent#getIntExtra(String, int)
 */

public static final java.lang.String EXTRA_SESSION_ID = "android.content.pm.extra.SESSION_ID";

/**
 * Current status of an operation. Will be one of
 * {@link #STATUS_PENDING_USER_ACTION}, {@link #STATUS_SUCCESS},
 * {@link #STATUS_FAILURE}, {@link #STATUS_FAILURE_ABORTED},
 * {@link #STATUS_FAILURE_BLOCKED}, {@link #STATUS_FAILURE_CONFLICT},
 * {@link #STATUS_FAILURE_INCOMPATIBLE}, {@link #STATUS_FAILURE_INVALID}, or
 * {@link #STATUS_FAILURE_STORAGE}.
 * <p>
 * More information about a status may be available through additional
 * extras; see the individual status documentation for details.
 *
 * @see Intent#getIntExtra(String, int)
 */

public static final java.lang.String EXTRA_STATUS = "android.content.pm.extra.STATUS";

/**
 * Detailed string representation of the status, including raw details that
 * are useful for debugging.
 *
 * @see Intent#getStringExtra(String)
 */

public static final java.lang.String EXTRA_STATUS_MESSAGE = "android.content.pm.extra.STATUS_MESSAGE";

/**
 * Storage path relevant to a status.
 *
 * @see Intent#getStringExtra(String)
 */

public static final java.lang.String EXTRA_STORAGE_PATH = "android.content.pm.extra.STORAGE_PATH";

/**
 * The operation failed in a generic way. The system will always try to
 * provide a more specific failure reason, but in some rare cases this may
 * be delivered.
 *
 * @see #EXTRA_STATUS_MESSAGE
 */

public static final int STATUS_FAILURE = 1; // 0x1

/**
 * The operation failed because it was actively aborted. For example, the
 * user actively declined requested permissions, or the session was
 * abandoned.
 *
 * @see #EXTRA_STATUS_MESSAGE
 */

public static final int STATUS_FAILURE_ABORTED = 3; // 0x3

/**
 * The operation failed because it was blocked. For example, a device policy
 * may be blocking the operation, a package verifier may have blocked the
 * operation, or the app may be required for core system operation.
 * <p>
 * The result may also contain {@link #EXTRA_OTHER_PACKAGE_NAME} with the
 * specific package blocking the install.
 *
 * @see #EXTRA_STATUS_MESSAGE
 * @see #EXTRA_OTHER_PACKAGE_NAME
 */

public static final int STATUS_FAILURE_BLOCKED = 2; // 0x2

/**
 * The operation failed because it conflicts (or is inconsistent with) with
 * another package already installed on the device. For example, an existing
 * permission, incompatible certificates, etc. The user may be able to
 * uninstall another app to fix the issue.
 * <p>
 * The result may also contain {@link #EXTRA_OTHER_PACKAGE_NAME} with the
 * specific package identified as the cause of the conflict.
 *
 * @see #EXTRA_STATUS_MESSAGE
 * @see #EXTRA_OTHER_PACKAGE_NAME
 */

public static final int STATUS_FAILURE_CONFLICT = 5; // 0x5

/**
 * The operation failed because it is fundamentally incompatible with this
 * device. For example, the app may require a hardware feature that doesn't
 * exist, it may be missing native code for the ABIs supported by the
 * device, or it requires a newer SDK version, etc.
 *
 * @see #EXTRA_STATUS_MESSAGE
 */

public static final int STATUS_FAILURE_INCOMPATIBLE = 7; // 0x7

/**
 * The operation failed because one or more of the APKs was invalid. For
 * example, they might be malformed, corrupt, incorrectly signed,
 * mismatched, etc.
 *
 * @see #EXTRA_STATUS_MESSAGE
 */

public static final int STATUS_FAILURE_INVALID = 4; // 0x4

/**
 * The operation failed because of storage issues. For example, the device
 * may be running low on space, or external media may be unavailable. The
 * user may be able to help free space or insert different external media.
 * <p>
 * The result may also contain {@link #EXTRA_STORAGE_PATH} with the path to
 * the storage device that caused the failure.
 *
 * @see #EXTRA_STATUS_MESSAGE
 * @see #EXTRA_STORAGE_PATH
 */

public static final int STATUS_FAILURE_STORAGE = 6; // 0x6

/**
 * User action is currently required to proceed. You can launch the intent
 * activity described by {@link Intent#EXTRA_INTENT} to involve the user and
 * continue.
 * <p>
 * You may choose to immediately launch the intent if the user is actively
 * using your app. Otherwise, you should use a notification to guide the
 * user back into your app before launching.
 *
 * @see Intent#getParcelableExtra(String)
 */

public static final int STATUS_PENDING_USER_ACTION = -1; // 0xffffffff

/**
 * The operation succeeded.
 */

public static final int STATUS_SUCCESS = 0; // 0x0
/**
 * An installation that is being actively staged. For an install to succeed,
 * all existing and new packages must have identical package names, version
 * codes, and signing certificates.
 * <p>
 * A session may contain any number of split packages. If the application
 * does not yet exist, this session must include a base package.
 * <p>
 * If an APK included in this session is already defined by the existing
 * installation (for example, the same split name), the APK in this session
 * will replace the existing APK.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Session implements java.io.Closeable {

Session() { throw new RuntimeException("Stub!"); }

/**
 * Set current progress of staging this session. Valid values are
 * anywhere between 0 and 1.
 * <p>
 * Note that this progress may not directly correspond to the value
 * reported by {@link SessionCallback#onProgressChanged(int, float)}, as
 * the system may carve out a portion of the overall progress to
 * represent its own internal installation work.
 */

public void setStagingProgress(float progress) { throw new RuntimeException("Stub!"); }

/**
 * Open a stream to write an APK file into the session.
 * <p>
 * The returned stream will start writing data at the requested offset
 * in the underlying file, which can be used to resume a partially
 * written file. If a valid file length is specified, the system will
 * preallocate the underlying disk space to optimize placement on disk.
 * It's strongly recommended to provide a valid file length when known.
 * <p>
 * You can write data into the returned stream, optionally call
 * {@link #fsync(OutputStream)} as needed to ensure bytes have been
 * persisted to disk, and then close when finished. All streams must be
 * closed before calling {@link #commit(IntentSender)}.
 *
 * @param name arbitrary, unique name of your choosing to identify the
 *            APK being written. You can open a file again for
 *            additional writes (such as after a reboot) by using the
 *            same name. This name is only meaningful within the context
 *            of a single install session.
 * This value must never be {@code null}.
 * @param offsetBytes offset into the file to begin writing at, or 0 to
 *            start at the beginning of the file.
 * @param lengthBytes total size of the file being written, used to
 *            preallocate the underlying disk space, or -1 if unknown.
 *            The system may clear various caches as needed to allocate
 *            this space.
 * @throws IOException if trouble opening the file for writing, such as
 *             lack of disk space or unavailable media.
 * @throws SecurityException if called after the session has been
 *             sealed or abandoned
 
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.io.OutputStream openWrite(@androidx.annotation.RecentlyNonNull java.lang.String name, long offsetBytes, long lengthBytes) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Ensure that any outstanding data for given stream has been committed
 * to disk. This is only valid for streams returned from
 * {@link #openWrite(String, long, long)}.

 * @param out This value must never be {@code null}.
 */

public void fsync(@androidx.annotation.RecentlyNonNull java.io.OutputStream out) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return all APK names contained in this session.
 * <p>
 * This returns all names which have been previously written through
 * {@link #openWrite(String, long, long)} as part of this session.
 *
 * @throws SecurityException if called after the session has been
 *             committed or abandoned.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String[] getNames() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Open a stream to read an APK file from the session.
 * <p>
 * This is only valid for names which have been previously written
 * through {@link #openWrite(String, long, long)} as part of this
 * session. For example, this stream may be used to calculate a
 * {@link MessageDigest} of a written APK before committing.
 *
 * @throws SecurityException if called after the session has been
 *             committed or abandoned.
 
 * @param name This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.io.InputStream openRead(@androidx.annotation.RecentlyNonNull java.lang.String name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Removes a split.
 * <p>
 * Split removals occur prior to adding new APKs. If upgrading a feature
 * split, it is not expected nor desirable to remove the split prior to
 * upgrading.
 * <p>
 * When split removal is bundled with new APKs, the packageName must be
 * identical.

 * @param splitName This value must never be {@code null}.
 */

public void removeSplit(@androidx.annotation.RecentlyNonNull java.lang.String splitName) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Attempt to commit everything staged in this session. This may require
 * user intervention, and so it may not happen immediately. The final
 * result of the commit will be reported through the given callback.
 * <p>
 * Once this method is called, the session is sealed and no additional
 * mutations may be performed on the session. If the device reboots
 * before the session has been finalized, you may commit the session again.
 * <p>
 * If the installer is the device owner or the affiliated profile owner, there will be no
 * user intervention.
 *
 * @throws SecurityException if streams opened through
 *             {@link #openWrite(String, long, long)} are still open.
 *
 * @see android.app.admin.DevicePolicyManager

 * @param statusReceiver This value must never be {@code null}.
 */

public void commit(@androidx.annotation.RecentlyNonNull android.content.IntentSender statusReceiver) { throw new RuntimeException("Stub!"); }

/**
 * Transfer the session to a new owner.
 * <p>
 * Only sessions that update the installing app can be transferred.
 * <p>
 * After the transfer to a package with a different uid all method calls on the session
 * will cause {@link SecurityException}s.
 * <p>
 * Once this method is called, the session is sealed and no additional mutations beside
 * committing it may be performed on the session.
 *
 * @param packageName The package of the new owner. Needs to hold the INSTALL_PACKAGES
 *                    permission.
 *
 * This value must never be {@code null}.
 * @throws PackageManager.NameNotFoundException if the new owner could not be found.
 * @throws SecurityException if called after the session has been committed or abandoned.
 * @throws SecurityException if the session does not update the original installer
 * @throws SecurityException if streams opened through
 *                           {@link #openWrite(String, long, long) are still open.
 */

public void transfer(@androidx.annotation.RecentlyNonNull java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Release this session object. You can open the session again if it
 * hasn't been finalized.
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Completely abandon this session, destroying all staged data and
 * rendering it invalid. Abandoned sessions will be reported to
 * {@link SessionCallback} listeners as failures. This is equivalent to
 * opening the session and calling {@link Session#abandon()}.
 */

public void abandon() { throw new RuntimeException("Stub!"); }
}

/**
 * Events for observing session lifecycle.
 * <p>
 * A typical session lifecycle looks like this:
 * <ul>
 * <li>An installer creates a session to indicate pending app delivery. All
 * install details are available at this point.
 * <li>The installer opens the session to deliver APK data. Note that a
 * session may be opened and closed multiple times as network connectivity
 * changes. The installer may deliver periodic progress updates.
 * <li>The installer commits or abandons the session, resulting in the
 * session being finished.
 * </ul>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class SessionCallback {

public SessionCallback() { throw new RuntimeException("Stub!"); }

/**
 * New session has been created. Details about the session can be
 * obtained from {@link PackageInstaller#getSessionInfo(int)}.
 */

public abstract void onCreated(int sessionId);

/**
 * Badging details for an existing session has changed. For example, the
 * app icon or label has been updated.
 */

public abstract void onBadgingChanged(int sessionId);

/**
 * Active state for session has been changed.
 * <p>
 * A session is considered active whenever there is ongoing forward
 * progress being made, such as the installer holding an open
 * {@link Session} instance while streaming data into place, or the
 * system optimizing code as the result of
 * {@link Session#commit(IntentSender)}.
 * <p>
 * If the installer closes the {@link Session} without committing, the
 * session is considered inactive until the installer opens the session
 * again.
 */

public abstract void onActiveChanged(int sessionId, boolean active);

/**
 * Progress for given session has been updated.
 * <p>
 * Note that this progress may not directly correspond to the value
 * reported by
 * {@link PackageInstaller.Session#setStagingProgress(float)}, as the
 * system may carve out a portion of the overall progress to represent
 * its own internal installation work.
 */

public abstract void onProgressChanged(int sessionId, float progress);

/**
 * Session has completely finished, either with success or failure.
 */

public abstract void onFinished(int sessionId, boolean success);
}

/**
 * Details for an active install session.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class SessionInfo implements android.os.Parcelable {

/** {@hide} */

SessionInfo() { throw new RuntimeException("Stub!"); }

/**
 * Return the ID for this session.
 */

public int getSessionId() { throw new RuntimeException("Stub!"); }

/**
 * Return the package name of the app that owns this session.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getInstallerPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Return current overall progress of this session, between 0 and 1.
 * <p>
 * Note that this progress may not directly correspond to the value
 * reported by
 * {@link PackageInstaller.Session#setStagingProgress(float)}, as the
 * system may carve out a portion of the overall progress to represent
 * its own internal installation work.
 */

public float getProgress() { throw new RuntimeException("Stub!"); }

/**
 * Return if this session is currently active.
 * <p>
 * A session is considered active whenever there is ongoing forward
 * progress being made, such as the installer holding an open
 * {@link Session} instance while streaming data into place, or the
 * system optimizing code as the result of
 * {@link Session#commit(IntentSender)}.
 * <p>
 * If the installer closes the {@link Session} without committing, the
 * session is considered inactive until the installer opens the session
 * again.
 */

public boolean isActive() { throw new RuntimeException("Stub!"); }

/**
 * Return if this session is sealed.
 * <p>
 * Once sealed, no further changes may be made to the session. A session
 * is sealed the moment {@link Session#commit(IntentSender)} is called.
 */

public boolean isSealed() { throw new RuntimeException("Stub!"); }

/**
 * Return the reason for installing this package.
 *
 * @return The install reason.

 * Value is {@link android.content.pm.PackageManager#INSTALL_REASON_UNKNOWN}, {@link android.content.pm.PackageManager#INSTALL_REASON_POLICY}, {@link android.content.pm.PackageManager#INSTALL_REASON_DEVICE_RESTORE}, {@link android.content.pm.PackageManager#INSTALL_REASON_DEVICE_SETUP}, or {@link android.content.pm.PackageManager#INSTALL_REASON_USER}
 */

public int getInstallReason() { throw new RuntimeException("Stub!"); }

/**
 * Return the package name this session is working with. May be {@code null}
 * if unknown.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getAppPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Return an icon representing the app being installed. May be {@code null}
 * if unavailable.
 */

@androidx.annotation.RecentlyNullable public android.graphics.Bitmap getAppIcon() { throw new RuntimeException("Stub!"); }

/**
 * Return a label representing the app being installed. May be {@code null}
 * if unavailable.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getAppLabel() { throw new RuntimeException("Stub!"); }

/**
 * Return an Intent that can be started to view details about this install
 * session. This may surface actions such as pause, resume, or cancel.
 * <p>
 * In some cases, a matching Activity may not exist, so ensure you safeguard
 * against this.
 *
 * @see PackageInstaller#ACTION_SESSION_DETAILS

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.content.Intent createDetailsIntent() { throw new RuntimeException("Stub!"); }

/**
 * Get the mode of the session as set in the constructor of the {@link SessionParams}.
 *
 * @return One of {@link SessionParams#MODE_FULL_INSTALL}
 *         or {@link SessionParams#MODE_INHERIT_EXISTING}
 */

public int getMode() { throw new RuntimeException("Stub!"); }

/**
 * Get the value set in {@link SessionParams#setInstallLocation(int)}.
 */

public int getInstallLocation() { throw new RuntimeException("Stub!"); }

/**
 * Get the value as set in {@link SessionParams#setSize(long)}.
 *
 * <p>The value is a hint and does not have to match the actual size.
 */

public long getSize() { throw new RuntimeException("Stub!"); }

/**
 * Get the value set in {@link SessionParams#setOriginatingUri(Uri)}.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.net.Uri getOriginatingUri() { throw new RuntimeException("Stub!"); }

/**
 * Get the value set in {@link SessionParams#setOriginatingUid(int)}.
 */

public int getOriginatingUid() { throw new RuntimeException("Stub!"); }

/**
 * Get the value set in {@link SessionParams#setReferrerUri(Uri)}

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.net.Uri getReferrerUri() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.PackageInstaller.SessionInfo> CREATOR;
static { CREATOR = null; }
}

/**
 * Parameters for creating a new {@link PackageInstaller.Session}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class SessionParams implements android.os.Parcelable {

/**
 * Construct parameters for a new package install session.
 *
 * @param mode one of {@link #MODE_FULL_INSTALL} or
 *            {@link #MODE_INHERIT_EXISTING} describing how the session
 *            should interact with an existing app.
 */

public SessionParams(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Provide value of {@link PackageInfo#installLocation}, which may be used
 * to determine where the app will be staged. Defaults to
 * {@link PackageInfo#INSTALL_LOCATION_INTERNAL_ONLY}.
 */

public void setInstallLocation(int installLocation) { throw new RuntimeException("Stub!"); }

/**
 * Optionally indicate the total size (in bytes) of all APKs that will be
 * delivered in this session. The system may use this to ensure enough disk
 * space exists before proceeding, or to estimate container size for
 * installations living on external storage.
 *
 * @see PackageInfo#INSTALL_LOCATION_AUTO
 * @see PackageInfo#INSTALL_LOCATION_PREFER_EXTERNAL
 */

public void setSize(long sizeBytes) { throw new RuntimeException("Stub!"); }

/**
 * Optionally set the package name of the app being installed. It's strongly
 * recommended that you provide this value when known, so that observers can
 * communicate installing apps to users.
 * <p>
 * If the APKs staged in the session aren't consistent with this package
 * name, the install will fail. Regardless of this value, all APKs in the
 * app must have the same package name.

 * @param appPackageName This value may be {@code null}.
 */

public void setAppPackageName(@androidx.annotation.RecentlyNullable java.lang.String appPackageName) { throw new RuntimeException("Stub!"); }

/**
 * Optionally set an icon representing the app being installed. This should
 * be roughly {@link ActivityManager#getLauncherLargeIconSize()} in both
 * dimensions.

 * @param appIcon This value may be {@code null}.
 */

public void setAppIcon(@androidx.annotation.RecentlyNullable android.graphics.Bitmap appIcon) { throw new RuntimeException("Stub!"); }

/**
 * Optionally set a label representing the app being installed.

 * @param appLabel This value may be {@code null}.
 */

public void setAppLabel(@androidx.annotation.RecentlyNullable java.lang.CharSequence appLabel) { throw new RuntimeException("Stub!"); }

/**
 * Optionally set the URI where this package was downloaded from. This is
 * informational and may be used as a signal for anti-malware purposes.
 *
 * @see Intent#EXTRA_ORIGINATING_URI

 * @param originatingUri This value may be {@code null}.
 */

public void setOriginatingUri(@androidx.annotation.RecentlyNullable android.net.Uri originatingUri) { throw new RuntimeException("Stub!"); }

/**
 * Sets the UID that initiated the package installation. This is informational
 * and may be used as a signal for anti-malware purposes.
 *
 * @see Intent#EXTRA_ORIGINATING_UID
 */

public void setOriginatingUid(int originatingUid) { throw new RuntimeException("Stub!"); }

/**
 * Optionally set the URI that referred you to install this package. This is
 * informational and may be used as a signal for anti-malware purposes.
 *
 * @see Intent#EXTRA_REFERRER

 * @param referrerUri This value may be {@code null}.
 */

public void setReferrerUri(@androidx.annotation.RecentlyNullable android.net.Uri referrerUri) { throw new RuntimeException("Stub!"); }

/**
 * Set the reason for installing this package.

 * @param installReason Value is {@link android.content.pm.PackageManager#INSTALL_REASON_UNKNOWN}, {@link android.content.pm.PackageManager#INSTALL_REASON_POLICY}, {@link android.content.pm.PackageManager#INSTALL_REASON_DEVICE_RESTORE}, {@link android.content.pm.PackageManager#INSTALL_REASON_DEVICE_SETUP}, or {@link android.content.pm.PackageManager#INSTALL_REASON_USER}
 */

public void setInstallReason(int installReason) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.PackageInstaller.SessionParams> CREATOR;
static { CREATOR = null; }

/**
 * Mode for an install session whose staged APKs should fully replace any
 * existing APKs for the target app.
 */

public static final int MODE_FULL_INSTALL = 1; // 0x1

/**
 * Mode for an install session that should inherit any existing APKs for the
 * target app, unless they have been explicitly overridden (based on split
 * name) by the session. For example, this can be used to add one or more
 * split APKs to an existing installation.
 * <p>
 * If there are no existing APKs for the target app, this behaves like
 * {@link #MODE_FULL_INSTALL}.
 */

public static final int MODE_INHERIT_EXISTING = 2; // 0x2
}

}

