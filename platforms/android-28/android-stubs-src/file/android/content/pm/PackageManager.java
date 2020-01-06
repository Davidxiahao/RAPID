/*
 * Copyright (C) 2006 The Android Open Source Project
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

import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import java.util.List;
import android.Manifest;
import android.content.ComponentName;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.graphics.Rect;
import android.content.res.Resources;
import java.io.File;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.app.usage.StorageStatsManager;
import java.util.Locale;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.app.ActivityManager;
import android.net.wifi.WifiManager;
import android.app.admin.DevicePolicyManager;

/**
 * Class for retrieving various kinds of information related to the application
 * packages that are currently installed on the device.
 *
 * You can find this class through {@link Context#getPackageManager}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class PackageManager {

public PackageManager() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve overall information about an application package that is
 * installed on the system.
 *
 * @param packageName The full name (i.e. com.google.apps.contacts) of the
 *            desired package.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A PackageInfo object containing information about the package. If
 *         flag {@code MATCH_UNINSTALLED_PACKAGES} is set and if the package
 *         is not found in the list of installed applications, the package
 *         information is retrieved from the list of uninstalled
 *         applications (which includes installed applications as well as
 *         applications with data directory i.e. applications which had been
 *         deleted with {@code DONT_DELETE_DATA} flag set).
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract android.content.pm.PackageInfo getPackageInfo(java.lang.String packageName, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve overall information about an application package that is
 * installed on the system. This method can be used for retrieving
 * information about packages for which multiple versions can be installed
 * at the time. Currently only packages hosting static shared libraries can
 * have multiple installed versions. The method can also be used to get info
 * for a package that has a single version installed by passing
 * {@link #VERSION_CODE_HIGHEST} in the {@link VersionedPackage}
 * constructor.
 *
 * @param versionedPackage The versioned package for which to query.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A PackageInfo object containing information about the package. If
 *         flag {@code MATCH_UNINSTALLED_PACKAGES} is set and if the package
 *         is not found in the list of installed applications, the package
 *         information is retrieved from the list of uninstalled
 *         applications (which includes installed applications as well as
 *         applications with data directory i.e. applications which had been
 *         deleted with {@code DONT_DELETE_DATA} flag set).
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract android.content.pm.PackageInfo getPackageInfo(android.content.pm.VersionedPackage versionedPackage, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Map from the current package names in use on the device to whatever
 * the current canonical name of that package is.
 * @param names Array of current names to be mapped.
 * @return Returns an array of the same size as the original, containing
 * the canonical name for each package.
 */

public abstract java.lang.String[] currentToCanonicalPackageNames(java.lang.String[] names);

/**
 * Map from a packages canonical name to the current name in use on the device.
 * @param names Array of new names to be mapped.
 * @return Returns an array of the same size as the original, containing
 * the current name for each package.
 */

public abstract java.lang.String[] canonicalToCurrentPackageNames(java.lang.String[] names);

/**
 * Returns a "good" intent to launch a front-door activity in a package.
 * This is used, for example, to implement an "open" button when browsing
 * through packages.  The current implementation looks first for a main
 * activity in the category {@link Intent#CATEGORY_INFO}, and next for a
 * main activity in the category {@link Intent#CATEGORY_LAUNCHER}. Returns
 * <code>null</code> if neither are found.
 *
 * @param packageName The name of the package to inspect.
 *
 * This value must never be {@code null}.
 * @return A fully-qualified {@link Intent} that can be used to launch the
 * main activity in the package. Returns <code>null</code> if the package
 * does not contain such an activity, or if <em>packageName</em> is not
 * recognized.
 */

@androidx.annotation.RecentlyNullable public abstract android.content.Intent getLaunchIntentForPackage(@androidx.annotation.RecentlyNonNull java.lang.String packageName);

/**
 * Return a "good" intent to launch a front-door Leanback activity in a
 * package, for use for example to implement an "open" button when browsing
 * through packages. The current implementation will look for a main
 * activity in the category {@link Intent#CATEGORY_LEANBACK_LAUNCHER}, or
 * return null if no main leanback activities are found.
 *
 * @param packageName The name of the package to inspect.
 * This value must never be {@code null}.
 * @return Returns either a fully-qualified Intent that can be used to launch
 *         the main Leanback activity in the package, or null if the package
 *         does not contain such an activity.
 */

@androidx.annotation.RecentlyNullable public abstract android.content.Intent getLeanbackLaunchIntentForPackage(@androidx.annotation.RecentlyNonNull java.lang.String packageName);

/**
 * Return an array of all of the POSIX secondary group IDs that have been
 * assigned to the given package.
 * <p>
 * Note that the same package may have different GIDs under different
 * {@link UserHandle} on the same device.
 *
 * @param packageName The full name (i.e. com.google.apps.contacts) of the
 *            desired package.
 * This value must never be {@code null}.
 * @return Returns an int array of the assigned GIDs, or null if there are
 *         none.
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract int[] getPackageGids(@androidx.annotation.RecentlyNonNull java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Return an array of all of the POSIX secondary group IDs that have been
 * assigned to the given package.
 * <p>
 * Note that the same package may have different GIDs under different
 * {@link UserHandle} on the same device.
 *
 * @param packageName The full name (i.e. com.google.apps.contacts) of the
 *            desired package.
 * @param flags Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return Returns an int array of the assigned gids, or null if there are
 *         none.
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract int[] getPackageGids(java.lang.String packageName, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Return the UID associated with the given package name.
 * <p>
 * Note that the same package will have different UIDs under different
 * {@link UserHandle} on the same device.
 *
 * @param packageName The full name (i.e. com.google.apps.contacts) of the
 *            desired package.
 * @param flags Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return Returns an integer UID who owns the given package name.
 * @throws NameNotFoundException if a package with the given name can not be
 *             found on the system.
 */

public abstract int getPackageUid(java.lang.String packageName, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the information we know about a particular permission.
 *
 * @param name The fully qualified name (i.e. com.google.permission.LOGIN)
 *            of the permission you are interested in.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#GET_META_DATA}
 * @return Returns a {@link PermissionInfo} containing information about the
 *         permission.
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract android.content.pm.PermissionInfo getPermissionInfo(java.lang.String name, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Query for all of the permissions associated with a particular group.
 *
 * @param group The fully qualified name (i.e. com.google.permission.LOGIN)
 *            of the permission group you are interested in. Use null to
 *            find all of the permissions not associated with a group.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#GET_META_DATA}
 * @return Returns a list of {@link PermissionInfo} containing information
 *         about all of the permissions in the given group.
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract java.util.List<android.content.pm.PermissionInfo> queryPermissionsByGroup(java.lang.String group, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the information we know about a particular group of
 * permissions.
 *
 * @param name The fully qualified name (i.e.
 *            com.google.permission_group.APPS) of the permission you are
 *            interested in.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#GET_META_DATA}
 * @return Returns a {@link PermissionGroupInfo} containing information
 *         about the permission.
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract android.content.pm.PermissionGroupInfo getPermissionGroupInfo(java.lang.String name, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the known permission groups in the system.
 *
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#GET_META_DATA}
 * @return Returns a list of {@link PermissionGroupInfo} containing
 *         information about all of the known permission groups.
 */

public abstract java.util.List<android.content.pm.PermissionGroupInfo> getAllPermissionGroups(int flags);

/**
 * Retrieve all of the information we know about a particular
 * package/application.
 *
 * @param packageName The full name (i.e. com.google.apps.contacts) of an
 *            application.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return An {@link ApplicationInfo} containing information about the
 *         package. If flag {@code MATCH_UNINSTALLED_PACKAGES} is set and if
 *         the package is not found in the list of installed applications,
 *         the application information is retrieved from the list of
 *         uninstalled applications (which includes installed applications
 *         as well as applications with data directory i.e. applications
 *         which had been deleted with {@code DONT_DELETE_DATA} flag set).
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract android.content.pm.ApplicationInfo getApplicationInfo(java.lang.String packageName, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the information we know about a particular activity
 * class.
 *
 * @param component The full component name (i.e.
 *            com.google.apps.contacts/com.google.apps.contacts.
 *            ContactsList) of an Activity class.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return An {@link ActivityInfo} containing information about the
 *         activity.
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract android.content.pm.ActivityInfo getActivityInfo(android.content.ComponentName component, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the information we know about a particular receiver
 * class.
 *
 * @param component The full component name (i.e.
 *            com.google.apps.calendar/com.google.apps.calendar.
 *            CalendarAlarm) of a Receiver class.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return An {@link ActivityInfo} containing information about the
 *         receiver.
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract android.content.pm.ActivityInfo getReceiverInfo(android.content.ComponentName component, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the information we know about a particular service class.
 *
 * @param component The full component name (i.e.
 *            com.google.apps.media/com.google.apps.media.
 *            BackgroundPlayback) of a Service class.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return A {@link ServiceInfo} object containing information about the
 *         service.
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract android.content.pm.ServiceInfo getServiceInfo(android.content.ComponentName component, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve all of the information we know about a particular content
 * provider class.
 *
 * @param component The full component name (i.e.
 *            com.google.providers.media/com.google.providers.media.
 *            MediaProvider) of a ContentProvider class.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return A {@link ProviderInfo} object containing information about the
 *         provider.
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract android.content.pm.ProviderInfo getProviderInfo(android.content.ComponentName component, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Return a List of all packages that are installed for the current user.
 *
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A List of PackageInfo objects, one for each installed package,
 *         containing information about the package. In the unlikely case
 *         there are no installed packages, an empty list is returned. If
 *         flag {@code MATCH_UNINSTALLED_PACKAGES} is set, the package
 *         information is retrieved from the list of uninstalled
 *         applications (which includes installed applications as well as
 *         applications with data directory i.e. applications which had been
 *         deleted with {@code DONT_DELETE_DATA} flag set).
 */

public abstract java.util.List<android.content.pm.PackageInfo> getInstalledPackages(int flags);

/**
 * Return a List of all installed packages that are currently holding any of
 * the given permissions.
 *
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A List of PackageInfo objects, one for each installed package
 *         that holds any of the permissions that were provided, containing
 *         information about the package. If no installed packages hold any
 *         of the permissions, an empty list is returned. If flag
 *         {@code MATCH_UNINSTALLED_PACKAGES} is set, the package
 *         information is retrieved from the list of uninstalled
 *         applications (which includes installed applications as well as
 *         applications with data directory i.e. applications which had been
 *         deleted with {@code DONT_DELETE_DATA} flag set).
 */

public abstract java.util.List<android.content.pm.PackageInfo> getPackagesHoldingPermissions(java.lang.String[] permissions, int flags);

/**
 * Check whether a particular package has been granted a particular
 * permission.
 *
 * @param permName The name of the permission you are checking for.
 * @param pkgName The name of the package you are checking against.
 *
 * @return If the package has the permission, PERMISSION_GRANTED is
 * returned.  If it does not have the permission, PERMISSION_DENIED
 * is returned.
 *
 * Value is {@link android.content.pm.PackageManager#PERMISSION_GRANTED}, or {@link android.content.pm.PackageManager#PERMISSION_DENIED}
 * @see #PERMISSION_GRANTED
 * @see #PERMISSION_DENIED
 */

public abstract int checkPermission(java.lang.String permName, java.lang.String pkgName);

/**
 * Checks whether a particular permissions has been revoked for a
 * package by policy. Typically the device owner or the profile owner
 * may apply such a policy. The user cannot grant policy revoked
 * permissions, hence the only way for an app to get such a permission
 * is by a policy change.
 *
 * @param permName The name of the permission you are checking for.
 * This value must never be {@code null}.
 * @param pkgName The name of the package you are checking against.
 *
 * This value must never be {@code null}.
 * @return Whether the permission is restricted by policy.
 */

public abstract boolean isPermissionRevokedByPolicy(@androidx.annotation.RecentlyNonNull java.lang.String permName, @androidx.annotation.RecentlyNonNull java.lang.String pkgName);

/**
 * Add a new dynamic permission to the system.  For this to work, your
 * package must have defined a permission tree through the
 * {@link android.R.styleable#AndroidManifestPermissionTree
 * &lt;permission-tree&gt;} tag in its manifest.  A package can only add
 * permissions to trees that were defined by either its own package or
 * another with the same user id; a permission is in a tree if it
 * matches the name of the permission tree + ".": for example,
 * "com.foo.bar" is a member of the permission tree "com.foo".
 *
 * <p>It is good to make your permission tree name descriptive, because you
 * are taking possession of that entire set of permission names.  Thus, it
 * must be under a domain you control, with a suffix that will not match
 * any normal permissions that may be declared in any applications that
 * are part of that domain.
 *
 * <p>New permissions must be added before
 * any .apks are installed that use those permissions.  Permissions you
 * add through this method are remembered across reboots of the device.
 * If the given permission already exists, the info you supply here
 * will be used to update it.
 *
 * @param info Description of the permission to be added.
 *
 * @return Returns true if a new permission was created, false if an
 * existing one was updated.
 *
 * @throws SecurityException if you are not allowed to add the
 * given permission name.
 *
 * @see #removePermission(String)
 */

public abstract boolean addPermission(android.content.pm.PermissionInfo info);

/**
 * Like {@link #addPermission(PermissionInfo)} but asynchronously
 * persists the package manager state after returning from the call,
 * allowing it to return quicker and batch a series of adds at the
 * expense of no guarantee the added permission will be retained if
 * the device is rebooted before it is written.
 */

public abstract boolean addPermissionAsync(android.content.pm.PermissionInfo info);

/**
 * Removes a permission that was previously added with
 * {@link #addPermission(PermissionInfo)}.  The same ownership rules apply
 * -- you are only allowed to remove permissions that you are allowed
 * to add.
 *
 * @param name The name of the permission to remove.
 *
 * @throws SecurityException if you are not allowed to remove the
 * given permission name.
 *
 * @see #addPermission(PermissionInfo)
 */

public abstract void removePermission(java.lang.String name);

/**
 * Compare the signatures of two packages to determine if the same
 * signature appears in both of them.  If they do contain the same
 * signature, then they are allowed special privileges when working
 * with each other: they can share the same user-id, run instrumentation
 * against each other, etc.
 *
 * @param pkg1 First package name whose signature will be compared.
 * @param pkg2 Second package name whose signature will be compared.
 *
 * @return Returns an integer indicating whether all signatures on the
 * two packages match. The value is >= 0 ({@link #SIGNATURE_MATCH}) if
 * all signatures match or < 0 if there is not a match ({@link
 * #SIGNATURE_NO_MATCH} or {@link #SIGNATURE_UNKNOWN_PACKAGE}).
 *
 * Value is {@link android.content.pm.PackageManager#SIGNATURE_MATCH}, {@link android.content.pm.PackageManager#SIGNATURE_NEITHER_SIGNED}, {@link android.content.pm.PackageManager#SIGNATURE_FIRST_NOT_SIGNED}, {@link android.content.pm.PackageManager#SIGNATURE_SECOND_NOT_SIGNED}, {@link android.content.pm.PackageManager#SIGNATURE_NO_MATCH}, or {@link android.content.pm.PackageManager#SIGNATURE_UNKNOWN_PACKAGE}
 * @see #checkSignatures(int, int)
 */

public abstract int checkSignatures(java.lang.String pkg1, java.lang.String pkg2);

/**
 * Like {@link #checkSignatures(String, String)}, but takes UIDs of
 * the two packages to be checked.  This can be useful, for example,
 * when doing the check in an IPC, where the UID is the only identity
 * available.  It is functionally identical to determining the package
 * associated with the UIDs and checking their signatures.
 *
 * @param uid1 First UID whose signature will be compared.
 * @param uid2 Second UID whose signature will be compared.
 *
 * @return Returns an integer indicating whether all signatures on the
 * two packages match. The value is >= 0 ({@link #SIGNATURE_MATCH}) if
 * all signatures match or < 0 if there is not a match ({@link
 * #SIGNATURE_NO_MATCH} or {@link #SIGNATURE_UNKNOWN_PACKAGE}).
 *
 * Value is {@link android.content.pm.PackageManager#SIGNATURE_MATCH}, {@link android.content.pm.PackageManager#SIGNATURE_NEITHER_SIGNED}, {@link android.content.pm.PackageManager#SIGNATURE_FIRST_NOT_SIGNED}, {@link android.content.pm.PackageManager#SIGNATURE_SECOND_NOT_SIGNED}, {@link android.content.pm.PackageManager#SIGNATURE_NO_MATCH}, or {@link android.content.pm.PackageManager#SIGNATURE_UNKNOWN_PACKAGE}
 * @see #checkSignatures(String, String)
 */

public abstract int checkSignatures(int uid1, int uid2);

/**
 * Retrieve the names of all packages that are associated with a particular
 * user id.  In most cases, this will be a single package name, the package
 * that has been assigned that user id.  Where there are multiple packages
 * sharing the same user id through the "sharedUserId" mechanism, all
 * packages with that id will be returned.
 *
 * @param uid The user id for which you would like to retrieve the
 * associated packages.
 *
 * @return Returns an array of one or more packages assigned to the user
 * id, or null if there are no known packages with the given id.
 */

@androidx.annotation.RecentlyNullable public abstract java.lang.String[] getPackagesForUid(int uid);

/**
 * Retrieve the official name associated with a uid. This name is
 * guaranteed to never change, though it is possible for the underlying
 * uid to be changed.  That is, if you are storing information about
 * uids in persistent storage, you should use the string returned
 * by this function instead of the raw uid.
 *
 * @param uid The uid for which you would like to retrieve a name.
 * @return Returns a unique name for the given uid, or null if the
 * uid is not currently assigned.
 */

@androidx.annotation.RecentlyNullable public abstract java.lang.String getNameForUid(int uid);

/**
 * Return a List of all application packages that are installed for the
 * current user. If flag GET_UNINSTALLED_PACKAGES has been set, a list of all
 * applications including those deleted with {@code DONT_DELETE_DATA}
 * (partially installed apps with data directory) will be returned.
 *
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A List of ApplicationInfo objects, one for each installed
 *         application. In the unlikely case there are no installed
 *         packages, an empty list is returned. If flag
 *         {@code MATCH_UNINSTALLED_PACKAGES} is set, the application
 *         information is retrieved from the list of uninstalled
 *         applications (which includes installed applications as well as
 *         applications with data directory i.e. applications which had been
 *         deleted with {@code DONT_DELETE_DATA} flag set).
 */

public abstract java.util.List<android.content.pm.ApplicationInfo> getInstalledApplications(int flags);

/**
 * Gets whether this application is an instant app.
 *
 * @return Whether caller is an instant app.
 *
 * @see #isInstantApp(String)
 * @see #updateInstantAppCookie(byte[])
 * @see #getInstantAppCookie()
 * @see #getInstantAppCookieMaxBytes()
 */

public abstract boolean isInstantApp();

/**
 * Gets whether the given package is an instant app.
 *
 * @param packageName The package to check
 * @return Whether the given package is an instant app.
 *
 * @see #isInstantApp()
 * @see #updateInstantAppCookie(byte[])
 * @see #getInstantAppCookie()
 * @see #getInstantAppCookieMaxBytes()
 * @see #clearInstantAppCookie()
 */

public abstract boolean isInstantApp(java.lang.String packageName);

/**
 * Gets the maximum size in bytes of the cookie data an instant app
 * can store on the device.
 *
 * @return The max cookie size in bytes.
 *
 * @see #isInstantApp()
 * @see #isInstantApp(String)
 * @see #updateInstantAppCookie(byte[])
 * @see #getInstantAppCookie()
 * @see #clearInstantAppCookie()
 */

public abstract int getInstantAppCookieMaxBytes();

/**
 * Gets the instant application cookie for this app. Non
 * instant apps and apps that were instant but were upgraded
 * to normal apps can still access this API. For instant apps
 * this cookie is cached for some time after uninstall while for
 * normal apps the cookie is deleted after the app is uninstalled.
 * The cookie is always present while the app is installed.
 *
 * @return The cookie.
 *
 * This value will never be {@code null}.
 * @see #isInstantApp()
 * @see #isInstantApp(String)
 * @see #updateInstantAppCookie(byte[])
 * @see #getInstantAppCookieMaxBytes()
 * @see #clearInstantAppCookie()
 */

@androidx.annotation.RecentlyNonNull public abstract byte[] getInstantAppCookie();

/**
 * Clears the instant application cookie for the calling app.
 *
 * @see #isInstantApp()
 * @see #isInstantApp(String)
 * @see #getInstantAppCookieMaxBytes()
 * @see #getInstantAppCookie()
 * @see #clearInstantAppCookie()
 */

public abstract void clearInstantAppCookie();

/**
 * Updates the instant application cookie for the calling app. Non
 * instant apps and apps that were instant but were upgraded
 * to normal apps can still access this API. For instant apps
 * this cookie is cached for some time after uninstall while for
 * normal apps the cookie is deleted after the app is uninstalled.
 * The cookie is always present while the app is installed. The
 * cookie size is limited by {@link #getInstantAppCookieMaxBytes()}.
 * Passing <code>null</code> or an empty array clears the cookie.
 * </p>
 *
 * @param cookie The cookie data.
 *
 * This value may be {@code null}.
 * @see #isInstantApp()
 * @see #isInstantApp(String)
 * @see #getInstantAppCookieMaxBytes()
 * @see #getInstantAppCookie()
 * @see #clearInstantAppCookie()
 *
 * @throws IllegalArgumentException if the array exceeds max cookie size.
 */

public abstract void updateInstantAppCookie(@androidx.annotation.RecentlyNullable byte[] cookie);

/**
 * Get a list of shared libraries that are available on the
 * system.
 *
 * @return An array of shared library names that are
 * available on the system, or null if none are installed.
 *
 */

public abstract java.lang.String[] getSystemSharedLibraryNames();

/**
 * Get a list of shared libraries on the device.
 *
 * @param flags To filter the libraries to return.
 * Value is either <code>0</code> or a combination of android.content.pm.PackageManager.INSTALL_FORWARD_LOCK, android.content.pm.PackageManager.INSTALL_REPLACE_EXISTING, android.content.pm.PackageManager.INSTALL_ALLOW_TEST, android.content.pm.PackageManager.INSTALL_EXTERNAL, android.content.pm.PackageManager.INSTALL_INTERNAL, android.content.pm.PackageManager.INSTALL_FROM_ADB, android.content.pm.PackageManager.INSTALL_ALL_USERS, android.content.pm.PackageManager.INSTALL_ALLOW_DOWNGRADE, android.content.pm.PackageManager.INSTALL_GRANT_RUNTIME_PERMISSIONS, android.content.pm.PackageManager.INSTALL_FORCE_VOLUME_UUID, android.content.pm.PackageManager.INSTALL_FORCE_PERMISSION_PROMPT, android.content.pm.PackageManager.INSTALL_INSTANT_APP, android.content.pm.PackageManager.INSTALL_DONT_KILL_APP, android.content.pm.PackageManager.INSTALL_FORCE_SDK, android.content.pm.PackageManager.INSTALL_FULL_APP, and android.content.pm.PackageManager.INSTALL_ALLOCATE_AGGRESSIVE
 * @return The shared library list.
 *
 * This value will never be {@code null}.
 * @see #MATCH_UNINSTALLED_PACKAGES
 */

@androidx.annotation.RecentlyNonNull public abstract java.util.List<android.content.pm.SharedLibraryInfo> getSharedLibraries(int flags);

/**
 * Returns the names of the packages that have been changed
 * [eg. added, removed or updated] since the given sequence
 * number.
 * <p>If no packages have been changed, returns <code>null</code>.
 * <p>The sequence number starts at <code>0</code> and is
 * reset every boot.
 * @param sequenceNumber The first sequence number for which to retrieve package changes.
 * Value is 0 or greater
 * @see Settings.Global#BOOT_COUNT
 */

@androidx.annotation.RecentlyNullable public abstract android.content.pm.ChangedPackages getChangedPackages(int sequenceNumber);

/**
 * Get a list of features that are available on the
 * system.
 *
 * @return An array of FeatureInfo classes describing the features
 * that are available on the system, or null if there are none(!!).
 */

public abstract android.content.pm.FeatureInfo[] getSystemAvailableFeatures();

/**
 * Check whether the given feature name is one of the available features as
 * returned by {@link #getSystemAvailableFeatures()}. This tests for the
 * presence of <em>any</em> version of the given feature name; use
 * {@link #hasSystemFeature(String, int)} to check for a minimum version.
 *
 * @return Returns true if the devices supports the feature, else false.
 */

public abstract boolean hasSystemFeature(java.lang.String name);

/**
 * Check whether the given feature name and version is one of the available
 * features as returned by {@link #getSystemAvailableFeatures()}. Since
 * features are defined to always be backwards compatible, this returns true
 * if the available feature version is greater than or equal to the
 * requested version.
 *
 * @return Returns true if the devices supports the feature, else false.
 */

public abstract boolean hasSystemFeature(java.lang.String name, int version);

/**
 * Determine the best action to perform for a given Intent. This is how
 * {@link Intent#resolveActivity} finds an activity if a class has not been
 * explicitly specified.
 * <p>
 * <em>Note:</em> if using an implicit Intent (without an explicit
 * ComponentName specified), be sure to consider whether to set the
 * {@link #MATCH_DEFAULT_ONLY} only flag. You need to do so to resolve the
 * activity in the same way that
 * {@link android.content.Context#startActivity(Intent)} and
 * {@link android.content.Intent#resolveActivity(PackageManager)
 * Intent.resolveActivity(PackageManager)} do.
 * </p>
 *
 * @param intent An intent containing all of the desired specification
 *            (action, data, type, category, and/or component).
 * @param flags Additional option flags to modify the data returned. The
 *            most important is {@link #MATCH_DEFAULT_ONLY}, to limit the
 *            resolution to only those activities that support the
 *            {@link android.content.Intent#CATEGORY_DEFAULT}.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a ResolveInfo object containing the final activity intent
 *         that was determined to be the best action. Returns null if no
 *         matching activity was found. If multiple matching activities are
 *         found and there is no default set, returns a ResolveInfo object
 *         containing something else, such as the activity resolver.
 */

public abstract android.content.pm.ResolveInfo resolveActivity(android.content.Intent intent, int flags);

/**
 * Retrieve all activities that can be performed for the given intent.
 *
 * @param intent The desired intent as per resolveActivity().
 * @param flags Additional option flags to modify the data returned. The
 *            most important is {@link #MATCH_DEFAULT_ONLY}, to limit the
 *            resolution to only those activities that support the
 *            {@link android.content.Intent#CATEGORY_DEFAULT}. Or, set
 *            {@link #MATCH_ALL} to prevent any filtering of the results.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a List of ResolveInfo objects containing one entry for
 *         each matching activity, ordered from best to worst. In other
 *         words, the first item is what would be returned by
 *         {@link #resolveActivity}. If there are no matching activities, an
 *         empty list is returned.
 */

public abstract java.util.List<android.content.pm.ResolveInfo> queryIntentActivities(android.content.Intent intent, int flags);

/**
 * Retrieve a set of activities that should be presented to the user as
 * similar options. This is like {@link #queryIntentActivities}, except it
 * also allows you to supply a list of more explicit Intents that you would
 * like to resolve to particular options, and takes care of returning the
 * final ResolveInfo list in a reasonable order, with no duplicates, based
 * on those inputs.
 *
 * @param caller The class name of the activity that is making the request.
 *            This activity will never appear in the output list. Can be
 *            null.
 * This value may be {@code null}.
 * @param specifics An array of Intents that should be resolved to the first
 *            specific results. Can be null.
 * This value may be {@code null}.
 * @param intent The desired intent as per resolveActivity().
 * @param flags Additional option flags to modify the data returned. The
 *            most important is {@link #MATCH_DEFAULT_ONLY}, to limit the
 *            resolution to only those activities that support the
 *            {@link android.content.Intent#CATEGORY_DEFAULT}.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a List of ResolveInfo objects containing one entry for
 *         each matching activity. The list is ordered first by all of the
 *         intents resolved in <var>specifics</var> and then any additional
 *         activities that can handle <var>intent</var> but did not get
 *         included by one of the <var>specifics</var> intents. If there are
 *         no matching activities, an empty list is returned.
 */

public abstract java.util.List<android.content.pm.ResolveInfo> queryIntentActivityOptions(@androidx.annotation.RecentlyNullable android.content.ComponentName caller, @androidx.annotation.RecentlyNullable android.content.Intent[] specifics, android.content.Intent intent, int flags);

/**
 * Retrieve all receivers that can handle a broadcast of the given intent.
 *
 * @param intent The desired intent as per resolveActivity().
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a List of ResolveInfo objects containing one entry for
 *         each matching receiver, ordered from best to worst. If there are
 *         no matching receivers, an empty list or null is returned.
 */

public abstract java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers(android.content.Intent intent, int flags);

/**
 * Determine the best service to handle for a given Intent.
 *
 * @param intent An intent containing all of the desired specification
 *            (action, data, type, category, and/or component).
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a ResolveInfo object containing the final service intent
 *         that was determined to be the best action. Returns null if no
 *         matching service was found.
 */

public abstract android.content.pm.ResolveInfo resolveService(android.content.Intent intent, int flags);

/**
 * Retrieve all services that can match the given intent.
 *
 * @param intent The desired intent as per resolveService().
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a List of ResolveInfo objects containing one entry for
 *         each matching service, ordered from best to worst. In other
 *         words, the first item is what would be returned by
 *         {@link #resolveService}. If there are no matching services, an
 *         empty list or null is returned.
 */

public abstract java.util.List<android.content.pm.ResolveInfo> queryIntentServices(android.content.Intent intent, int flags);

/**
 * Retrieve all providers that can match the given intent.
 *
 * @param intent An intent containing all of the desired specification
 *            (action, data, type, category, and/or component).
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_RESOLVED_FILTER}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return Returns a List of ResolveInfo objects containing one entry for
 *         each matching provider, ordered from best to worst. If there are
 *         no matching services, an empty list or null is returned.
 */

public abstract java.util.List<android.content.pm.ResolveInfo> queryIntentContentProviders(android.content.Intent intent, int flags);

/**
 * Find a single content provider by its base path name.
 *
 * @param name The name of the provider to find.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return A {@link ProviderInfo} object containing information about the
 *         provider. If a provider was not found, returns null.
 */

public abstract android.content.pm.ProviderInfo resolveContentProvider(java.lang.String name, int flags);

/**
 * Retrieve content provider information.
 * <p>
 * <em>Note: unlike most other methods, an empty result set is indicated
 * by a null return instead of an empty list.</em>
 *
 * @param processName If non-null, limits the returned providers to only
 *            those that are hosted by the given process. If null, all
 *            content providers are returned.
 * @param uid If <var>processName</var> is non-null, this is the required
 *            uid owning the requested content providers.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_ALL}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DEFAULT_ONLY}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_AWARE}, {@link android.content.pm.PackageManager#MATCH_DIRECT_BOOT_UNAWARE}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, and {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}
 * @return A list of {@link ProviderInfo} objects containing one entry for
 *         each provider either matching <var>processName</var> or, if
 *         <var>processName</var> is null, all known content providers.
 *         <em>If there are no matching providers, null is returned.</em>
 */

public abstract java.util.List<android.content.pm.ProviderInfo> queryContentProviders(java.lang.String processName, int uid, int flags);

/**
 * Retrieve all of the information we know about a particular
 * instrumentation class.
 *
 * @param className The full name (i.e.
 *            com.google.apps.contacts.InstrumentList) of an Instrumentation
 *            class.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#GET_META_DATA}
 * @return An {@link InstrumentationInfo} object containing information
 *         about the instrumentation.
 * @throws NameNotFoundException if a package with the given name cannot be
 *             found on the system.
 */

public abstract android.content.pm.InstrumentationInfo getInstrumentationInfo(android.content.ComponentName className, int flags) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve information about available instrumentation code. May be used to
 * retrieve either all instrumentation code, or only the code targeting a
 * particular package.
 *
 * @param targetPackage If null, all instrumentation is returned; only the
 *            instrumentation targeting this package name is returned.
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#GET_META_DATA}
 * @return A list of {@link InstrumentationInfo} objects containing one
 *         entry for each matching instrumentation. If there are no
 *         instrumentation available, returns an empty list.
 */

public abstract java.util.List<android.content.pm.InstrumentationInfo> queryInstrumentation(java.lang.String targetPackage, int flags);

/**
 * Retrieve an image from a package.  This is a low-level API used by
 * the various package manager info structures (such as
 * {@link ComponentInfo} to implement retrieval of their associated
 * icon.
 *
 * @param packageName The name of the package that this icon is coming from.
 * Cannot be null.
 * @param resid The resource identifier of the desired image.  Cannot be 0.
 * @param appInfo Overall information about <var>packageName</var>.  This
 * may be null, in which case the application information will be retrieved
 * for you if needed; if you already have this information around, it can
 * be much more efficient to supply it here.
 *
 * @return Returns a Drawable holding the requested image.  Returns null if
 * an image could not be found for any reason.
 */

public abstract android.graphics.drawable.Drawable getDrawable(java.lang.String packageName, int resid, android.content.pm.ApplicationInfo appInfo);

/**
 * Retrieve the icon associated with an activity.  Given the full name of
 * an activity, retrieves the information about it and calls
 * {@link ComponentInfo#loadIcon ComponentInfo.loadIcon()} to return its icon.
 * If the activity cannot be found, NameNotFoundException is thrown.
 *
 * @param activityName Name of the activity whose icon is to be retrieved.
 *
 * @return Returns the image of the icon, or the default activity icon if
 * it could not be found.  Does not return null.
 * @throws NameNotFoundException Thrown if the resources for the given
 * activity could not be loaded.
 *
 * @see #getActivityIcon(Intent)
 */

public abstract android.graphics.drawable.Drawable getActivityIcon(android.content.ComponentName activityName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the icon associated with an Intent.  If intent.getClassName() is
 * set, this simply returns the result of
 * getActivityIcon(intent.getClassName()).  Otherwise it resolves the intent's
 * component and returns the icon associated with the resolved component.
 * If intent.getClassName() cannot be found or the Intent cannot be resolved
 * to a component, NameNotFoundException is thrown.
 *
 * @param intent The intent for which you would like to retrieve an icon.
 *
 * @return Returns the image of the icon, or the default activity icon if
 * it could not be found.  Does not return null.
 * @throws NameNotFoundException Thrown if the resources for application
 * matching the given intent could not be loaded.
 *
 * @see #getActivityIcon(ComponentName)
 */

public abstract android.graphics.drawable.Drawable getActivityIcon(android.content.Intent intent) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the banner associated with an activity. Given the full name of
 * an activity, retrieves the information about it and calls
 * {@link ComponentInfo#loadIcon ComponentInfo.loadIcon()} to return its
 * banner. If the activity cannot be found, NameNotFoundException is thrown.
 *
 * @param activityName Name of the activity whose banner is to be retrieved.
 * @return Returns the image of the banner, or null if the activity has no
 *         banner specified.
 * @throws NameNotFoundException Thrown if the resources for the given
 *             activity could not be loaded.
 * @see #getActivityBanner(Intent)
 */

public abstract android.graphics.drawable.Drawable getActivityBanner(android.content.ComponentName activityName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the banner associated with an Intent. If intent.getClassName()
 * is set, this simply returns the result of
 * getActivityBanner(intent.getClassName()). Otherwise it resolves the
 * intent's component and returns the banner associated with the resolved
 * component. If intent.getClassName() cannot be found or the Intent cannot
 * be resolved to a component, NameNotFoundException is thrown.
 *
 * @param intent The intent for which you would like to retrieve a banner.
 * @return Returns the image of the banner, or null if the activity has no
 *         banner specified.
 * @throws NameNotFoundException Thrown if the resources for application
 *             matching the given intent could not be loaded.
 * @see #getActivityBanner(ComponentName)
 */

public abstract android.graphics.drawable.Drawable getActivityBanner(android.content.Intent intent) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Return the generic icon for an activity that is used when no specific
 * icon is defined.
 *
 * @return Drawable Image of the icon.
 */

public abstract android.graphics.drawable.Drawable getDefaultActivityIcon();

/**
 * Retrieve the icon associated with an application.  If it has not defined
 * an icon, the default app icon is returned.  Does not return null.
 *
 * @param info Information about application being queried.
 *
 * @return Returns the image of the icon, or the default application icon
 * if it could not be found.
 *
 * @see #getApplicationIcon(String)
 */

public abstract android.graphics.drawable.Drawable getApplicationIcon(android.content.pm.ApplicationInfo info);

/**
 * Retrieve the icon associated with an application.  Given the name of the
 * application's package, retrieves the information about it and calls
 * getApplicationIcon() to return its icon. If the application cannot be
 * found, NameNotFoundException is thrown.
 *
 * @param packageName Name of the package whose application icon is to be
 *                    retrieved.
 *
 * @return Returns the image of the icon, or the default application icon
 * if it could not be found.  Does not return null.
 * @throws NameNotFoundException Thrown if the resources for the given
 * application could not be loaded.
 *
 * @see #getApplicationIcon(ApplicationInfo)
 */

public abstract android.graphics.drawable.Drawable getApplicationIcon(java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the banner associated with an application.
 *
 * @param info Information about application being queried.
 * @return Returns the image of the banner or null if the application has no
 *         banner specified.
 * @see #getApplicationBanner(String)
 */

public abstract android.graphics.drawable.Drawable getApplicationBanner(android.content.pm.ApplicationInfo info);

/**
 * Retrieve the banner associated with an application. Given the name of the
 * application's package, retrieves the information about it and calls
 * getApplicationIcon() to return its banner. If the application cannot be
 * found, NameNotFoundException is thrown.
 *
 * @param packageName Name of the package whose application banner is to be
 *            retrieved.
 * @return Returns the image of the banner or null if the application has no
 *         banner specified.
 * @throws NameNotFoundException Thrown if the resources for the given
 *             application could not be loaded.
 * @see #getApplicationBanner(ApplicationInfo)
 */

public abstract android.graphics.drawable.Drawable getApplicationBanner(java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the logo associated with an activity. Given the full name of an
 * activity, retrieves the information about it and calls
 * {@link ComponentInfo#loadLogo ComponentInfo.loadLogo()} to return its
 * logo. If the activity cannot be found, NameNotFoundException is thrown.
 *
 * @param activityName Name of the activity whose logo is to be retrieved.
 * @return Returns the image of the logo or null if the activity has no logo
 *         specified.
 * @throws NameNotFoundException Thrown if the resources for the given
 *             activity could not be loaded.
 * @see #getActivityLogo(Intent)
 */

public abstract android.graphics.drawable.Drawable getActivityLogo(android.content.ComponentName activityName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the logo associated with an Intent.  If intent.getClassName() is
 * set, this simply returns the result of
 * getActivityLogo(intent.getClassName()).  Otherwise it resolves the intent's
 * component and returns the logo associated with the resolved component.
 * If intent.getClassName() cannot be found or the Intent cannot be resolved
 * to a component, NameNotFoundException is thrown.
 *
 * @param intent The intent for which you would like to retrieve a logo.
 *
 * @return Returns the image of the logo, or null if the activity has no
 * logo specified.
 *
 * @throws NameNotFoundException Thrown if the resources for application
 * matching the given intent could not be loaded.
 *
 * @see #getActivityLogo(ComponentName)
 */

public abstract android.graphics.drawable.Drawable getActivityLogo(android.content.Intent intent) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the logo associated with an application.  If it has not specified
 * a logo, this method returns null.
 *
 * @param info Information about application being queried.
 *
 * @return Returns the image of the logo, or null if no logo is specified
 * by the application.
 *
 * @see #getApplicationLogo(String)
 */

public abstract android.graphics.drawable.Drawable getApplicationLogo(android.content.pm.ApplicationInfo info);

/**
 * Retrieve the logo associated with an application.  Given the name of the
 * application's package, retrieves the information about it and calls
 * getApplicationLogo() to return its logo. If the application cannot be
 * found, NameNotFoundException is thrown.
 *
 * @param packageName Name of the package whose application logo is to be
 *                    retrieved.
 *
 * @return Returns the image of the logo, or null if no application logo
 * has been specified.
 *
 * @throws NameNotFoundException Thrown if the resources for the given
 * application could not be loaded.
 *
 * @see #getApplicationLogo(ApplicationInfo)
 */

public abstract android.graphics.drawable.Drawable getApplicationLogo(java.lang.String packageName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * If the target user is a managed profile, then this returns a badged copy of the given icon
 * to be able to distinguish it from the original icon. For badging an arbitrary drawable use
 * {@link #getUserBadgedDrawableForDensity(
 * android.graphics.drawable.Drawable, UserHandle, android.graphics.Rect, int)}.
 * <p>
 * If the original drawable is a BitmapDrawable and the backing bitmap is
 * mutable as per {@link android.graphics.Bitmap#isMutable()}, the badging
 * is performed in place and the original drawable is returned.
 * </p>
 *
 * @param icon The icon to badge.
 * @param user The target user.
 * @return A drawable that combines the original icon and a badge as
 *         determined by the system.
 */

public abstract android.graphics.drawable.Drawable getUserBadgedIcon(android.graphics.drawable.Drawable icon, android.os.UserHandle user);

/**
 * If the target user is a managed profile of the calling user or the caller
 * is itself a managed profile, then this returns a badged copy of the given
 * drawable allowing the user to distinguish it from the original drawable.
 * The caller can specify the location in the bounds of the drawable to be
 * badged where the badge should be applied as well as the density of the
 * badge to be used.
 * <p>
 * If the original drawable is a BitmapDrawable and the backing bitmap is
 * mutable as per {@link android.graphics.Bitmap#isMutable()}, the badging
 * is performed in place and the original drawable is returned.
 * </p>
 *
 * @param drawable The drawable to badge.
 * @param user The target user.
 * @param badgeLocation Where in the bounds of the badged drawable to place
 *         the badge. If it's {@code null}, the badge is applied on top of the entire
 *         drawable being badged.
 * @param badgeDensity The optional desired density for the badge as per
 *         {@link android.util.DisplayMetrics#densityDpi}. If it's not positive,
 *         the density of the display is used.
 * @return A drawable that combines the original drawable and a badge as
 *         determined by the system.
 */

public abstract android.graphics.drawable.Drawable getUserBadgedDrawableForDensity(android.graphics.drawable.Drawable drawable, android.os.UserHandle user, android.graphics.Rect badgeLocation, int badgeDensity);

/**
 * If the target user is a managed profile of the calling user or the caller
 * is itself a managed profile, then this returns a copy of the label with
 * badging for accessibility services like talkback. E.g. passing in "Email"
 * and it might return "Work Email" for Email in the work profile.
 *
 * @param label The label to change.
 * @param user The target user.
 * @return A label that combines the original label and a badge as
 *         determined by the system.
 */

public abstract java.lang.CharSequence getUserBadgedLabel(java.lang.CharSequence label, android.os.UserHandle user);

/**
 * Retrieve text from a package.  This is a low-level API used by
 * the various package manager info structures (such as
 * {@link ComponentInfo} to implement retrieval of their associated
 * labels and other text.
 *
 * @param packageName The name of the package that this text is coming from.
 * Cannot be null.
 * @param resid The resource identifier of the desired text.  Cannot be 0.
 * @param appInfo Overall information about <var>packageName</var>.  This
 * may be null, in which case the application information will be retrieved
 * for you if needed; if you already have this information around, it can
 * be much more efficient to supply it here.
 *
 * @return Returns a CharSequence holding the requested text.  Returns null
 * if the text could not be found for any reason.
 */

public abstract java.lang.CharSequence getText(java.lang.String packageName, int resid, android.content.pm.ApplicationInfo appInfo);

/**
 * Retrieve an XML file from a package.  This is a low-level API used to
 * retrieve XML meta data.
 *
 * @param packageName The name of the package that this xml is coming from.
 * Cannot be null.
 * @param resid The resource identifier of the desired xml.  Cannot be 0.
 * @param appInfo Overall information about <var>packageName</var>.  This
 * may be null, in which case the application information will be retrieved
 * for you if needed; if you already have this information around, it can
 * be much more efficient to supply it here.
 *
 * @return Returns an XmlPullParser allowing you to parse out the XML
 * data.  Returns null if the xml resource could not be found for any
 * reason.
 */

public abstract android.content.res.XmlResourceParser getXml(java.lang.String packageName, int resid, android.content.pm.ApplicationInfo appInfo);

/**
 * Return the label to use for this application.
 *
 * @return Returns the label associated with this application, or null if
 * it could not be found for any reason.
 * @param info The application to get the label of.
 */

public abstract java.lang.CharSequence getApplicationLabel(android.content.pm.ApplicationInfo info);

/**
 * Retrieve the resources associated with an activity.  Given the full
 * name of an activity, retrieves the information about it and calls
 * getResources() to return its application's resources.  If the activity
 * cannot be found, NameNotFoundException is thrown.
 *
 * @param activityName Name of the activity whose resources are to be
 *                     retrieved.
 *
 * @return Returns the application's Resources.
 * @throws NameNotFoundException Thrown if the resources for the given
 * application could not be loaded.
 *
 * @see #getResourcesForApplication(ApplicationInfo)
 */

public abstract android.content.res.Resources getResourcesForActivity(android.content.ComponentName activityName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the resources for an application.  Throws NameNotFoundException
 * if the package is no longer installed.
 *
 * @param app Information about the desired application.
 *
 * @return Returns the application's Resources.
 * @throws NameNotFoundException Thrown if the resources for the given
 * application could not be loaded (most likely because it was uninstalled).
 */

public abstract android.content.res.Resources getResourcesForApplication(android.content.pm.ApplicationInfo app) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve the resources associated with an application.  Given the full
 * package name of an application, retrieves the information about it and
 * calls getResources() to return its application's resources.  If the
 * appPackageName cannot be found, NameNotFoundException is thrown.
 *
 * @param appPackageName Package name of the application whose resources
 *                       are to be retrieved.
 *
 * @return Returns the application's Resources.
 * @throws NameNotFoundException Thrown if the resources for the given
 * application could not be loaded.
 *
 * @see #getResourcesForApplication(ApplicationInfo)
 */

public abstract android.content.res.Resources getResourcesForApplication(java.lang.String appPackageName) throws android.content.pm.PackageManager.NameNotFoundException;

/**
 * Retrieve overall information about an application package defined in a
 * package archive file
 *
 * @param archiveFilePath The path to the archive file
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A PackageInfo object containing information about the package
 *         archive. If the package could not be parsed, returns null.
 */

public android.content.pm.PackageInfo getPackageArchiveInfo(java.lang.String archiveFilePath, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Allows a package listening to the
 * {@link Intent#ACTION_PACKAGE_NEEDS_VERIFICATION package verification
 * broadcast} to respond to the package manager. The response must include
 * the {@code verificationCode} which is one of
 * {@link PackageManager#VERIFICATION_ALLOW} or
 * {@link PackageManager#VERIFICATION_REJECT}.
 *
 * @param id pending package identifier as passed via the
 *            {@link PackageManager#EXTRA_VERIFICATION_ID} Intent extra.
 * @param verificationCode either {@link PackageManager#VERIFICATION_ALLOW}
 *            or {@link PackageManager#VERIFICATION_REJECT}.
 * @throws SecurityException if the caller does not have the
 *            PACKAGE_VERIFICATION_AGENT permission.
 */

public abstract void verifyPendingInstall(int id, int verificationCode);

/**
 * Allows a package listening to the
 * {@link Intent#ACTION_PACKAGE_NEEDS_VERIFICATION package verification
 * broadcast} to extend the default timeout for a response and declare what
 * action to perform after the timeout occurs. The response must include
 * the {@code verificationCodeAtTimeout} which is one of
 * {@link PackageManager#VERIFICATION_ALLOW} or
 * {@link PackageManager#VERIFICATION_REJECT}.
 *
 * This method may only be called once per package id. Additional calls
 * will have no effect.
 *
 * @param id pending package identifier as passed via the
 *            {@link PackageManager#EXTRA_VERIFICATION_ID} Intent extra.
 * @param verificationCodeAtTimeout either
 *            {@link PackageManager#VERIFICATION_ALLOW} or
 *            {@link PackageManager#VERIFICATION_REJECT}. If
 *            {@code verificationCodeAtTimeout} is neither
 *            {@link PackageManager#VERIFICATION_ALLOW} or
 *            {@link PackageManager#VERIFICATION_REJECT}, then
 *            {@code verificationCodeAtTimeout} will default to
 *            {@link PackageManager#VERIFICATION_REJECT}.
 * @param millisecondsToDelay the amount of time requested for the timeout.
 *            Must be positive and less than
 *            {@link PackageManager#MAXIMUM_VERIFICATION_TIMEOUT}. If
 *            {@code millisecondsToDelay} is out of bounds,
 *            {@code millisecondsToDelay} will be set to the closest in
 *            bounds value; namely, 0 or
 *            {@link PackageManager#MAXIMUM_VERIFICATION_TIMEOUT}.
 * @throws SecurityException if the caller does not have the
 *            PACKAGE_VERIFICATION_AGENT permission.
 */

public abstract void extendVerificationTimeout(int id, int verificationCodeAtTimeout, long millisecondsToDelay);

/**
 * Change the installer associated with a given package.  There are limitations
 * on how the installer package can be changed; in particular:
 * <ul>
 * <li> A SecurityException will be thrown if <var>installerPackageName</var>
 * is not signed with the same certificate as the calling application.
 * <li> A SecurityException will be thrown if <var>targetPackage</var> already
 * has an installer package, and that installer package is not signed with
 * the same certificate as the calling application.
 * </ul>
 *
 * @param targetPackage The installed package whose installer will be changed.
 * @param installerPackageName The package name of the new installer.  May be
 * null to clear the association.
 */

public abstract void setInstallerPackageName(java.lang.String targetPackage, java.lang.String installerPackageName);

/**
 * Retrieve the package name of the application that installed a package. This identifies
 * which market the package came from.
 *
 * @param packageName The name of the package to query
 * @throws IllegalArgumentException if the given package name is not installed
 */

public abstract java.lang.String getInstallerPackageName(java.lang.String packageName);

/**
 * @deprecated This function no longer does anything; it was an old
 * approach to managing preferred activities, which has been superseded
 * by (and conflicts with) the modern activity-based preferences.
 */

@Deprecated public abstract void addPackageToPreferred(java.lang.String packageName);

/**
 * @deprecated This function no longer does anything; it was an old
 * approach to managing preferred activities, which has been superseded
 * by (and conflicts with) the modern activity-based preferences.
 */

@Deprecated public abstract void removePackageFromPreferred(java.lang.String packageName);

/**
 * Retrieve the list of all currently configured preferred packages. The
 * first package on the list is the most preferred, the last is the least
 * preferred.
 *
 * @param flags Additional option flags to modify the data returned.
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_ACTIVITIES}, {@link android.content.pm.PackageManager#GET_CONFIGURATIONS}, {@link android.content.pm.PackageManager#GET_GIDS}, {@link android.content.pm.PackageManager#GET_INSTRUMENTATION}, {@link android.content.pm.PackageManager#GET_INTENT_FILTERS}, {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_PERMISSIONS}, {@link android.content.pm.PackageManager#GET_PROVIDERS}, {@link android.content.pm.PackageManager#GET_RECEIVERS}, {@link android.content.pm.PackageManager#GET_SERVICES}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#GET_SIGNATURES}, {@link android.content.pm.PackageManager#GET_SIGNING_CERTIFICATES}, {@link android.content.pm.PackageManager#GET_URI_PERMISSION_PATTERNS}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_FACTORY_ONLY, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, android.content.pm.PackageManager.MATCH_INSTANT, {@link android.content.pm.PackageManager#GET_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @return A List of PackageInfo objects, one for each preferred
 *         application, in order of preference.
 */

public abstract java.util.List<android.content.pm.PackageInfo> getPreferredPackages(int flags);

/**
 * @deprecated This is a protected API that should not have been available
 * to third party applications.  It is the platform's responsibility for
 * assigning preferred activities and this cannot be directly modified.
 *
 * Add a new preferred activity mapping to the system.  This will be used
 * to automatically select the given activity component when
 * {@link Context#startActivity(Intent) Context.startActivity()} finds
 * multiple matching activities and also matches the given filter.
 *
 * @param filter The set of intents under which this activity will be
 * made preferred.
 * @param match The IntentFilter match category that this preference
 * applies to.
 * @param set The set of activities that the user was picking from when
 * this preference was made.
 * @param activity The component name of the activity that is to be
 * preferred.
 */

@Deprecated public abstract void addPreferredActivity(android.content.IntentFilter filter, int match, android.content.ComponentName[] set, android.content.ComponentName activity);

/**
 * Remove all preferred activity mappings, previously added with
 * {@link #addPreferredActivity}, from the
 * system whose activities are implemented in the given package name.
 * An application can only clear its own package(s).
 *
 * @param packageName The name of the package whose preferred activity
 * mappings are to be removed.
 */

public abstract void clearPackagePreferredActivities(java.lang.String packageName);

/**
 * Retrieve all preferred activities, previously added with
 * {@link #addPreferredActivity}, that are
 * currently registered with the system.
 *
 * @param outFilters A required list in which to place the filters of all of the
 * preferred activities.
 * This value must never be {@code null}.
 * @param outActivities A required list in which to place the component names of
 * all of the preferred activities.
 * This value must never be {@code null}.
 * @param packageName An optional package in which you would like to limit
 * the list.  If null, all activities will be returned; if non-null, only
 * those activities in the given package are returned.
 *
 * @return Returns the total number of registered preferred activities
 * (the number of distinct IntentFilter records, not the number of unique
 * activity components) that were found.
 */

public abstract int getPreferredActivities(@androidx.annotation.RecentlyNonNull java.util.List<android.content.IntentFilter> outFilters, @androidx.annotation.RecentlyNonNull java.util.List<android.content.ComponentName> outActivities, java.lang.String packageName);

/**
 * Set the enabled setting for a package component (activity, receiver, service, provider).
 * This setting will override any enabled state which may have been set by the component in its
 * manifest.
 *
 * @param componentName The component to enable
 * @param newState The new enabled state for the component.
 * Value is {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DEFAULT}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_ENABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_USER}, or {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED}
 * @param flags Optional behavior flags.

 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#DONT_KILL_APP}
 */

public abstract void setComponentEnabledSetting(@androidx.annotation.RecentlyNonNull android.content.ComponentName componentName, int newState, int flags);

/**
 * Return the enabled setting for a package component (activity,
 * receiver, service, provider).  This returns the last value set by
 * {@link #setComponentEnabledSetting(ComponentName, int, int)}; in most
 * cases this value will be {@link #COMPONENT_ENABLED_STATE_DEFAULT} since
 * the value originally specified in the manifest has not been modified.
 *
 * @param componentName The component to retrieve.
 * @return Returns the current enabled state for the component.

 * Value is {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DEFAULT}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_ENABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_USER}, or {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED}
 */

public abstract int getComponentEnabledSetting(android.content.ComponentName componentName);

/**
 * Set the enabled setting for an application
 * This setting will override any enabled state which may have been set by the application in
 * its manifest.  It also overrides the enabled state set in the manifest for any of the
 * application's components.  It does not override any enabled state set by
 * {@link #setComponentEnabledSetting} for any of the application's components.
 *
 * @param packageName The package name of the application to enable
 * @param newState The new enabled state for the application.
 * Value is {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DEFAULT}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_ENABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_USER}, or {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED}
 * @param flags Optional behavior flags.

 * Value is either <code>0</code> or {@link android.content.pm.PackageManager#DONT_KILL_APP}
 */

public abstract void setApplicationEnabledSetting(@androidx.annotation.RecentlyNonNull java.lang.String packageName, int newState, int flags);

/**
 * Return the enabled setting for an application. This returns
 * the last value set by
 * {@link #setApplicationEnabledSetting(String, int, int)}; in most
 * cases this value will be {@link #COMPONENT_ENABLED_STATE_DEFAULT} since
 * the value originally specified in the manifest has not been modified.
 *
 * @param packageName The package name of the application to retrieve.
 * @return Returns the current enabled state for the application.
 * Value is {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DEFAULT}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_ENABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED}, {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_USER}, or {@link android.content.pm.PackageManager#COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED}
 * @throws IllegalArgumentException if the named package does not exist.
 */

public abstract int getApplicationEnabledSetting(java.lang.String packageName);

/**
 * Return whether the device has been booted into safe mode.
 */

public abstract boolean isSafeMode();

/**
 * Apps can query this to know if they have been suspended. A system app with the permission
 * {@code android.permission.SUSPEND_APPS} can put any app on the device into a suspended state.
 *
 * <p>While in this state, the application's notifications will be hidden, any of its started
 * activities will be stopped and it will not be able to show toasts or dialogs or ring the
 * device. When the user tries to launch a suspended app, the system will, instead, show a
 * dialog to the user informing them that they cannot use this app while it is suspended.
 *
 * <p>When an app is put into this state, the broadcast action
 * {@link Intent#ACTION_MY_PACKAGE_SUSPENDED} will be delivered to any of its broadcast
 * receivers that included this action in their intent-filters, <em>including manifest
 * receivers.</em> Similarly, a broadcast action {@link Intent#ACTION_MY_PACKAGE_UNSUSPENDED}
 * is delivered when a previously suspended app is taken out of this state.
 * </p>
 *
 * @return {@code true} if the calling package has been suspended, {@code false} otherwise.
 *
 * @see #getSuspendedPackageAppExtras()
 * @see Intent#ACTION_MY_PACKAGE_SUSPENDED
 * @see Intent#ACTION_MY_PACKAGE_UNSUSPENDED
 */

public boolean isPackageSuspended() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Bundle} of extras that was meant to be sent to the calling app when it was
 * suspended. An app with the permission {@code android.permission.SUSPEND_APPS} can supply this
 * to the system at the time of suspending an app.
 *
 * <p>This is the same {@link Bundle} that is sent along with the broadcast
 * {@link Intent#ACTION_MY_PACKAGE_SUSPENDED}, whenever the app is suspended. The contents of
 * this {@link Bundle} are a contract between the suspended app and the suspending app.
 *
 * <p>Note: These extras are optional, so if no extras were supplied to the system, this method
 * will return {@code null}, even when the calling app has been suspended.
 *
 * @return A {@link Bundle} containing the extras for the app, or {@code null} if the
 * package is not currently suspended.
 *
 * @see #isPackageSuspended()
 * @see Intent#ACTION_MY_PACKAGE_UNSUSPENDED
 * @see Intent#ACTION_MY_PACKAGE_SUSPENDED
 * @see Intent#EXTRA_SUSPENDED_PACKAGE_EXTRAS
 */

@androidx.annotation.RecentlyNullable public android.os.Bundle getSuspendedPackageAppExtras() { throw new RuntimeException("Stub!"); }

/**
 * Provide a hint of what the {@link ApplicationInfo#category} value should
 * be for the given package.
 * <p>
 * This hint can only be set by the app which installed this package, as
 * determined by {@link #getInstallerPackageName(String)}.
 *
 * @param packageName the package to change the category hint for.
 * This value must never be {@code null}.
 * @param categoryHint the category hint to set.

 * Value is {@link android.content.pm.ApplicationInfo#CATEGORY_UNDEFINED}, {@link android.content.pm.ApplicationInfo#CATEGORY_GAME}, {@link android.content.pm.ApplicationInfo#CATEGORY_AUDIO}, {@link android.content.pm.ApplicationInfo#CATEGORY_VIDEO}, {@link android.content.pm.ApplicationInfo#CATEGORY_IMAGE}, {@link android.content.pm.ApplicationInfo#CATEGORY_SOCIAL}, {@link android.content.pm.ApplicationInfo#CATEGORY_NEWS}, {@link android.content.pm.ApplicationInfo#CATEGORY_MAPS}, or {@link android.content.pm.ApplicationInfo#CATEGORY_PRODUCTIVITY}
 */

public abstract void setApplicationCategoryHint(@androidx.annotation.RecentlyNonNull java.lang.String packageName, int categoryHint);

/**
 * Return interface that offers the ability to install, upgrade, and remove
 * applications on the device.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public abstract android.content.pm.PackageInstaller getPackageInstaller();

/**
 * Checks whether the calling package is allowed to request package installs through package
 * installer. Apps are encouraged to call this API before launching the package installer via
 * intent {@link android.content.Intent#ACTION_INSTALL_PACKAGE}. Starting from Android O, the
 * user can explicitly choose what external sources they trust to install apps on the device.
 * If this API returns false, the install request will be blocked by the package installer and
 * a dialog will be shown to the user with an option to launch settings to change their
 * preference. An application must target Android O or higher and declare permission
 * {@link android.Manifest.permission#REQUEST_INSTALL_PACKAGES} in order to use this API.
 *
 * @return true if the calling package is trusted by the user to request install packages on
 * the device, false otherwise.
 * @see android.content.Intent#ACTION_INSTALL_PACKAGE
 * @see android.provider.Settings#ACTION_MANAGE_UNKNOWN_APP_SOURCES
 */

public abstract boolean canRequestPackageInstalls();

/**
 * Searches the set of signing certificates by which the given package has proven to have been
 * signed.  This should be used instead of {@code getPackageInfo} with {@code GET_SIGNATURES}
 * since it takes into account the possibility of signing certificate rotation, except in the
 * case of packages that are signed by multiple certificates, for which signing certificate
 * rotation is not supported.  This method is analogous to using {@code getPackageInfo} with
 * {@code GET_SIGNING_CERTIFICATES} and then searching through the resulting {@code
 * signingInfo} field to see if the desired certificate is present.
 *
 * @param packageName package whose signing certificates to check
 * @param certificate signing certificate for which to search
 * @param type representation of the {@code certificate}
 * Value is {@link android.content.pm.PackageManager#CERT_INPUT_RAW_X509}, or {@link android.content.pm.PackageManager#CERT_INPUT_SHA256}
 * @return true if this package was or is signed by exactly the certificate {@code certificate}
 */

public boolean hasSigningCertificate(java.lang.String packageName, byte[] certificate, int type) { throw new RuntimeException("Stub!"); }

/**
 * Searches the set of signing certificates by which the package(s) for the given uid has proven
 * to have been signed.  For multiple packages sharing the same uid, this will return the
 * signing certificates found in the signing history of the "newest" package, where "newest"
 * indicates the package with the newest signing certificate in the shared uid group.  This
 * method should be used instead of {@code getPackageInfo} with {@code GET_SIGNATURES}
 * since it takes into account the possibility of signing certificate rotation, except in the
 * case of packages that are signed by multiple certificates, for which signing certificate
 * rotation is not supported. This method is analogous to using {@code getPackagesForUid}
 * followed by {@code getPackageInfo} with {@code GET_SIGNING_CERTIFICATES}, selecting the
 * {@code PackageInfo} of the newest-signed bpackage , and finally searching through the
 * resulting {@code signingInfo} field to see if the desired certificate is there.
 *
 * @param uid uid whose signing certificates to check
 * @param certificate signing certificate for which to search
 * @param type representation of the {@code certificate}
 * Value is {@link android.content.pm.PackageManager#CERT_INPUT_RAW_X509}, or {@link android.content.pm.PackageManager#CERT_INPUT_SHA256}
 * @return true if this package was or is signed by exactly the certificate {@code certificate}
 */

public boolean hasSigningCertificate(int uid, byte[] certificate, int type) { throw new RuntimeException("Stub!"); }

/**
 * Certificate input bytes: the input bytes represent an encoded X.509 Certificate which could
 * be generated using an {@code CertificateFactory}
 */

public static final int CERT_INPUT_RAW_X509 = 0; // 0x0

/**
 * Certificate input bytes: the input bytes represent the SHA256 output of an encoded X.509
 * Certificate.
 */

public static final int CERT_INPUT_SHA256 = 1; // 0x1

/**
 * Flag for {@link #setApplicationEnabledSetting(String, int, int)} and
 * {@link #setComponentEnabledSetting(ComponentName, int, int)}: This
 * component or application is in its default enabled state (as specified in
 * its manifest).
 * <p>
 * Explicitly setting the component state to this value restores it's
 * enabled state to whatever is set in the manifest.
 */

public static final int COMPONENT_ENABLED_STATE_DEFAULT = 0; // 0x0

/**
 * Flag for {@link #setApplicationEnabledSetting(String, int, int)}
 * and {@link #setComponentEnabledSetting(ComponentName, int, int)}: This
 * component or application has been explicitly disabled, regardless of
 * what it has specified in its manifest.
 */

public static final int COMPONENT_ENABLED_STATE_DISABLED = 2; // 0x2

/**
 * Flag for {@link #setApplicationEnabledSetting(String, int, int)} only: This
 * application should be considered, until the point where the user actually
 * wants to use it.  This means that it will not normally show up to the user
 * (such as in the launcher), but various parts of the user interface can
 * use {@link #GET_DISABLED_UNTIL_USED_COMPONENTS} to still see it and allow
 * the user to select it (as for example an IME, device admin, etc).  Such code,
 * once the user has selected the app, should at that point also make it enabled.
 * This option currently <strong>can not</strong> be used with
 * {@link #setComponentEnabledSetting(ComponentName, int, int)}.
 */

public static final int COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED = 4; // 0x4

/**
 * Flag for {@link #setApplicationEnabledSetting(String, int, int)} only: The
 * user has explicitly disabled the application, regardless of what it has
 * specified in its manifest.  Because this is due to the user's request,
 * they may re-enable it if desired through the appropriate system UI.  This
 * option currently <strong>cannot</strong> be used with
 * {@link #setComponentEnabledSetting(ComponentName, int, int)}.
 */

public static final int COMPONENT_ENABLED_STATE_DISABLED_USER = 3; // 0x3

/**
 * Flag for {@link #setApplicationEnabledSetting(String, int, int)}
 * and {@link #setComponentEnabledSetting(ComponentName, int, int)}: This
 * component or application has been explictily enabled, regardless of
 * what it has specified in its manifest.
 */

public static final int COMPONENT_ENABLED_STATE_ENABLED = 1; // 0x1

/**
 * Flag parameter for
 * {@link #setComponentEnabledSetting(android.content.ComponentName, int, int)} to indicate
 * that you don't want to kill the app containing the component.  Be careful when you set this
 * since changing component states can make the containing application's behavior unpredictable.
 */

public static final int DONT_KILL_APP = 1; // 0x1

/**
 * Extra field name for the ID of a package pending verification. Passed to
 * a package verifier and is used to call back to
 * {@link PackageManager#verifyPendingInstall(int, int)}
 */

public static final java.lang.String EXTRA_VERIFICATION_ID = "android.content.pm.extra.VERIFICATION_ID";

/**
 * Extra field name for the result of a verification, either
 * {@link #VERIFICATION_ALLOW}, or {@link #VERIFICATION_REJECT}.
 * Passed to package verifiers after a package is verified.
 */

public static final java.lang.String EXTRA_VERIFICATION_RESULT = "android.content.pm.extra.VERIFICATION_RESULT";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports running activities on secondary displays.
 */

public static final java.lang.String FEATURE_ACTIVITIES_ON_SECONDARY_DISPLAYS = "android.software.activities_on_secondary_displays";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports app widgets.
 */

public static final java.lang.String FEATURE_APP_WIDGETS = "android.software.app_widgets";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: The device's
 * audio pipeline is low-latency, more suitable for audio applications sensitive to delays or
 * lag in sound input or output.
 */

public static final java.lang.String FEATURE_AUDIO_LOW_LATENCY = "android.hardware.audio.low_latency";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes at least one form of audio
 * output, as defined in the Android Compatibility Definition Document (CDD)
 * <a href="https://source.android.com/compatibility/android-cdd#7_8_audio">section 7.8 Audio</a>.
 */

public static final java.lang.String FEATURE_AUDIO_OUTPUT = "android.hardware.audio.output";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device has professional audio level of functionality and performance.
 */

public static final java.lang.String FEATURE_AUDIO_PRO = "android.hardware.audio.pro";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports autofill of user credentials, addresses, credit cards, etc
 * via integration with {@link android.service.autofill.AutofillService autofill
 * providers}.
 */

public static final java.lang.String FEATURE_AUTOFILL = "android.software.autofill";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: This is a device dedicated to showing UI
 * on a vehicle headunit. A headunit here is defined to be inside a
 * vehicle that may or may not be moving. A headunit uses either a
 * primary display in the center console and/or additional displays in
 * the instrument cluster or elsewhere in the vehicle. Headunit display(s)
 * have limited size and resolution. The user will likely be focused on
 * driving so limiting driver distraction is a primary concern. User input
 * can be a variety of hard buttons, touch, rotary controllers and even mouse-
 * like interfaces.
 */

public static final java.lang.String FEATURE_AUTOMOTIVE = "android.hardware.type.automotive";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device can perform backup and restore operations on installed applications.
 */

public static final java.lang.String FEATURE_BACKUP = "android.software.backup";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device is capable of communicating with
 * other devices via Bluetooth.
 */

public static final java.lang.String FEATURE_BLUETOOTH = "android.hardware.bluetooth";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device is capable of communicating with
 * other devices via Bluetooth Low Energy radio.
 */

public static final java.lang.String FEATURE_BLUETOOTH_LE = "android.hardware.bluetooth_le";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a camera facing away
 * from the screen.
 */

public static final java.lang.String FEATURE_CAMERA = "android.hardware.camera";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has at least one camera pointing in
 * some direction, or can support an external camera being connected to it.
 */

public static final java.lang.String FEATURE_CAMERA_ANY = "android.hardware.camera.any";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: At least one
 * of the cameras on the device supports the
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_MOTION_TRACKING
 * MOTION_TRACKING} capability level.
 */

public static final java.lang.String FEATURE_CAMERA_AR = "android.hardware.camera.ar";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's camera supports auto-focus.
 */

public static final java.lang.String FEATURE_CAMERA_AUTOFOCUS = "android.hardware.camera.autofocus";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: At least one
 * of the cameras on the device supports the
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_MANUAL_POST_PROCESSING manual post-processing}
 * capability level.
 */

public static final java.lang.String FEATURE_CAMERA_CAPABILITY_MANUAL_POST_PROCESSING = "android.hardware.camera.capability.manual_post_processing";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: At least one
 * of the cameras on the device supports the
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_MANUAL_SENSOR manual sensor}
 * capability level.
 */

public static final java.lang.String FEATURE_CAMERA_CAPABILITY_MANUAL_SENSOR = "android.hardware.camera.capability.manual_sensor";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: At least one
 * of the cameras on the device supports the
 * {@link android.hardware.camera2.CameraMetadata#REQUEST_AVAILABLE_CAPABILITIES_RAW RAW}
 * capability level.
 */

public static final java.lang.String FEATURE_CAMERA_CAPABILITY_RAW = "android.hardware.camera.capability.raw";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device can support having an external camera connected to it.
 * The external camera may not always be connected or available to applications to use.
 */

public static final java.lang.String FEATURE_CAMERA_EXTERNAL = "android.hardware.camera.external";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's camera supports flash.
 */

public static final java.lang.String FEATURE_CAMERA_FLASH = "android.hardware.camera.flash";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a front facing camera.
 */

public static final java.lang.String FEATURE_CAMERA_FRONT = "android.hardware.camera.front";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: At least one
 * of the cameras on the device supports the
 * {@link android.hardware.camera2.CameraCharacteristics#INFO_SUPPORTED_HARDWARE_LEVEL full hardware}
 * capability level.
 */

public static final java.lang.String FEATURE_CAMERA_LEVEL_FULL = "android.hardware.camera.level.full";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports the
 * {@link android.R.attr#cantSaveState} API.
 */

public static final java.lang.String FEATURE_CANT_SAVE_STATE = "android.software.cant_save_state";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports {@link android.companion.CompanionDeviceManager#associate associating}
 * with devices via {@link android.companion.CompanionDeviceManager}.
 */

public static final java.lang.String FEATURE_COMPANION_DEVICE_SETUP = "android.software.companion_device_setup";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The Connection Service API is enabled on the device.
 */

public static final java.lang.String FEATURE_CONNECTION_SERVICE = "android.software.connectionservice";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device is capable of communicating with
 * consumer IR devices.
 */

public static final java.lang.String FEATURE_CONSUMER_IR = "android.hardware.consumerir";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports device policy enforcement via device admins.
 */

public static final java.lang.String FEATURE_DEVICE_ADMIN = "android.software.device_admin";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: This is a device for IoT and may not have an UI. An embedded
 * device is defined as a full stack Android device with or without a display and no
 * user-installable apps.
 */

public static final java.lang.String FEATURE_EMBEDDED = "android.hardware.type.embedded";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: This device supports ethernet.
 */

public static final java.lang.String FEATURE_ETHERNET = "android.hardware.ethernet";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device does not have a touch screen, but
 * does support touch emulation for basic events. For instance, the
 * device might use a mouse or remote control to drive a cursor, and
 * emulate basic touch pointer events like down, up, drag, etc. All
 * devices that support android.hardware.touchscreen or a sub-feature are
 * presumed to also support faketouch.
 */

public static final java.lang.String FEATURE_FAKETOUCH = "android.hardware.faketouch";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device does not have a touch screen, but
 * does support touch emulation for basic events that supports distinct
 * tracking of two or more fingers.  This is an extension of
 * {@link #FEATURE_FAKETOUCH} for input devices with this capability.  Note
 * that unlike a distinct multitouch screen as defined by
 * {@link #FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT}, these kinds of input
 * devices will not actually provide full two-finger gestures since the
 * input is being transformed to cursor movement on the screen.  That is,
 * single finger gestures will move a cursor; two-finger swipes will
 * result in single-finger touch events; other two-finger gestures will
 * result in the corresponding two-finger touch event.
 */

public static final java.lang.String FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT = "android.hardware.faketouch.multitouch.distinct";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device does not have a touch screen, but
 * does support touch emulation for basic events that supports tracking
 * a hand of fingers (5 or more fingers) fully independently.
 * This is an extension of
 * {@link #FEATURE_FAKETOUCH} for input devices with this capability.  Note
 * that unlike a multitouch screen as defined by
 * {@link #FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND}, not all two finger
 * gestures can be detected due to the limitations described for
 * {@link #FEATURE_FAKETOUCH_MULTITOUCH_DISTINCT}.
 */

public static final java.lang.String FEATURE_FAKETOUCH_MULTITOUCH_JAZZHAND = "android.hardware.faketouch.multitouch.jazzhand";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has biometric hardware to detect a fingerprint.
 */

public static final java.lang.String FEATURE_FINGERPRINT = "android.hardware.fingerprint";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports freeform window management.
 * Windows have title bars and can be moved and resized.
 */

public static final java.lang.String FEATURE_FREEFORM_WINDOW_MANAGEMENT = "android.software.freeform_window_management";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device has all of the inputs necessary to be considered a compatible game controller, or
 * includes a compatible game controller in the box.
 */

public static final java.lang.String FEATURE_GAMEPAD = "android.hardware.gamepad";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports high fidelity sensor processing
 * capabilities.
 */

public static final java.lang.String FEATURE_HIFI_SENSORS = "android.hardware.sensor.hifi_sensors";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports a home screen that is replaceable
 * by third party applications.
 */

public static final java.lang.String FEATURE_HOME_SCREEN = "android.software.home_screen";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports adding new input methods implemented
 * with the {@link android.inputmethodservice.InputMethodService} API.
 */

public static final java.lang.String FEATURE_INPUT_METHODS = "android.software.input_methods";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports leanback UI. This is
 * typically used in a living room television experience, but is a software
 * feature unlike {@link #FEATURE_TELEVISION}. Devices running with this
 * feature will use resources associated with the "television" UI mode.
 */

public static final java.lang.String FEATURE_LEANBACK = "android.software.leanback";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports only leanback UI. Only
 * applications designed for this experience should be run, though this is
 * not enforced by the system.
 */

public static final java.lang.String FEATURE_LEANBACK_ONLY = "android.software.leanback_only";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports live TV and can display
 * contents from TV inputs implemented with the
 * {@link android.media.tv.TvInputService} API.
 */

public static final java.lang.String FEATURE_LIVE_TV = "android.software.live_tv";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports live wallpapers.
 */

public static final java.lang.String FEATURE_LIVE_WALLPAPER = "android.software.live_wallpaper";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports one or more methods of
 * reporting current location.
 */

public static final java.lang.String FEATURE_LOCATION = "android.hardware.location";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a Global Positioning System
 * receiver and can report precise location.
 */

public static final java.lang.String FEATURE_LOCATION_GPS = "android.hardware.location.gps";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device can report location with coarse
 * accuracy using a network-based geolocation system.
 */

public static final java.lang.String FEATURE_LOCATION_NETWORK = "android.hardware.location.network";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports creating secondary users and managed profiles via
 * {@link DevicePolicyManager}.
 */

public static final java.lang.String FEATURE_MANAGED_USERS = "android.software.managed_users";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device can record audio via a
 * microphone.
 */

public static final java.lang.String FEATURE_MICROPHONE = "android.hardware.microphone";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device has a full implementation of the android.media.midi.* APIs.
 */

public static final java.lang.String FEATURE_MIDI = "android.software.midi";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device can communicate using Near-Field
 * Communications (NFC).
 */

public static final java.lang.String FEATURE_NFC = "android.hardware.nfc";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports host-
 * based NFC card emulation.
 */

public static final java.lang.String FEATURE_NFC_HOST_CARD_EMULATION = "android.hardware.nfc.hce";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports host-
 * based NFC-F card emulation.
 */

public static final java.lang.String FEATURE_NFC_HOST_CARD_EMULATION_NFCF = "android.hardware.nfc.hcef";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports the OpenGL ES
 * <a href="http://www.khronos.org/registry/gles/extensions/ANDROID/ANDROID_extension_pack_es31a.txt">
 * Android Extension Pack</a>.
 */

public static final java.lang.String FEATURE_OPENGLES_EXTENSION_PACK = "android.hardware.opengles.aep";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: This is a device dedicated to be primarily used
 * with keyboard, mouse or touchpad. This includes traditional desktop
 * computers, laptops and variants such as convertibles or detachables.
 * Due to the larger screen, the device will most likely use the
 * {@link #FEATURE_FREEFORM_WINDOW_MANAGEMENT} feature as well.
 */

public static final java.lang.String FEATURE_PC = "android.hardware.type.pc";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports picture-in-picture multi-window mode.
 */

public static final java.lang.String FEATURE_PICTURE_IN_PICTURE = "android.software.picture_in_picture";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports printing.
 */

public static final java.lang.String FEATURE_PRINTING = "android.software.print";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's
 * {@link ActivityManager#isLowRamDevice() ActivityManager.isLowRamDevice()} method returns
 * true.
 */

public static final java.lang.String FEATURE_RAM_LOW = "android.hardware.ram.low";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's
 * {@link ActivityManager#isLowRamDevice() ActivityManager.isLowRamDevice()} method returns
 * false.
 */

public static final java.lang.String FEATURE_RAM_NORMAL = "android.hardware.ram.normal";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports landscape orientation
 * screens.  For backwards compatibility, you can assume that if neither
 * this nor {@link #FEATURE_SCREEN_PORTRAIT} is set then the device supports
 * both portrait and landscape.
 */

public static final java.lang.String FEATURE_SCREEN_LANDSCAPE = "android.hardware.screen.landscape";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports portrait orientation
 * screens.  For backwards compatibility, you can assume that if neither
 * this nor {@link #FEATURE_SCREEN_LANDSCAPE} is set then the device supports
 * both portrait and landscape.
 */

public static final java.lang.String FEATURE_SCREEN_PORTRAIT = "android.hardware.screen.portrait";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports secure removal of users. When a user is deleted the data associated
 * with that user is securely deleted and no longer available.
 */

public static final java.lang.String FEATURE_SECURELY_REMOVES_USERS = "android.software.securely_removes_users";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes an accelerometer.
 */

public static final java.lang.String FEATURE_SENSOR_ACCELEROMETER = "android.hardware.sensor.accelerometer";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes an ambient temperature sensor.
 */

public static final java.lang.String FEATURE_SENSOR_AMBIENT_TEMPERATURE = "android.hardware.sensor.ambient_temperature";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a barometer (air
 * pressure sensor.)
 */

public static final java.lang.String FEATURE_SENSOR_BAROMETER = "android.hardware.sensor.barometer";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a magnetometer (compass).
 */

public static final java.lang.String FEATURE_SENSOR_COMPASS = "android.hardware.sensor.compass";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a gyroscope.
 */

public static final java.lang.String FEATURE_SENSOR_GYROSCOPE = "android.hardware.sensor.gyroscope";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a heart rate monitor.
 */

public static final java.lang.String FEATURE_SENSOR_HEART_RATE = "android.hardware.sensor.heartrate";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The heart rate sensor on this device is an Electrocardiogram.
 */

public static final java.lang.String FEATURE_SENSOR_HEART_RATE_ECG = "android.hardware.sensor.heartrate.ecg";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a light sensor.
 */

public static final java.lang.String FEATURE_SENSOR_LIGHT = "android.hardware.sensor.light";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a proximity sensor.
 */

public static final java.lang.String FEATURE_SENSOR_PROXIMITY = "android.hardware.sensor.proximity";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a relative humidity sensor.
 */

public static final java.lang.String FEATURE_SENSOR_RELATIVE_HUMIDITY = "android.hardware.sensor.relative_humidity";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a hardware step counter.
 */

public static final java.lang.String FEATURE_SENSOR_STEP_COUNTER = "android.hardware.sensor.stepcounter";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device includes a hardware step detector.
 */

public static final java.lang.String FEATURE_SENSOR_STEP_DETECTOR = "android.hardware.sensor.stepdetector";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The SIP API is enabled on the device.
 */

public static final java.lang.String FEATURE_SIP = "android.software.sip";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports SIP-based VOIP.
 */

public static final java.lang.String FEATURE_SIP_VOIP = "android.software.sip.voip";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device has a StrongBox hardware-backed Keystore.
 */

public static final java.lang.String FEATURE_STRONGBOX_KEYSTORE = "android.hardware.strongbox_keystore";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a telephony radio with data
 * communication support.
 */

public static final java.lang.String FEATURE_TELEPHONY = "android.hardware.telephony";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a CDMA telephony stack.
 */

public static final java.lang.String FEATURE_TELEPHONY_CDMA = "android.hardware.telephony.cdma";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: The device
 * supports embedded subscriptions on eUICCs.
 */

public static final java.lang.String FEATURE_TELEPHONY_EUICC = "android.hardware.telephony.euicc";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device has a GSM telephony stack.
 */

public static final java.lang.String FEATURE_TELEPHONY_GSM = "android.hardware.telephony.gsm";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}: The device
 * supports cell-broadcast reception using the MBMS APIs.
 */

public static final java.lang.String FEATURE_TELEPHONY_MBMS = "android.hardware.telephony.mbms";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: This is a device dedicated to showing UI
 * on a television.  Television here is defined to be a typical living
 * room television experience: displayed on a big screen, where the user
 * is sitting far away from it, and the dominant form of input will be
 * something like a DPAD, not through touch or mouse.
 * @deprecated use {@link #FEATURE_LEANBACK} instead.
 */

@Deprecated public static final java.lang.String FEATURE_TELEVISION = "android.hardware.type.television";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's display has a touch screen.
 */

public static final java.lang.String FEATURE_TOUCHSCREEN = "android.hardware.touchscreen";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's touch screen supports
 * multitouch sufficient for basic two-finger gesture detection.
 */

public static final java.lang.String FEATURE_TOUCHSCREEN_MULTITOUCH = "android.hardware.touchscreen.multitouch";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's touch screen is capable of
 * tracking two or more fingers fully independently.
 */

public static final java.lang.String FEATURE_TOUCHSCREEN_MULTITOUCH_DISTINCT = "android.hardware.touchscreen.multitouch.distinct";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device's touch screen is capable of
 * tracking a full hand of fingers fully independently -- that is, 5 or
 * more simultaneous independent pointers.
 */

public static final java.lang.String FEATURE_TOUCHSCREEN_MULTITOUCH_JAZZHAND = "android.hardware.touchscreen.multitouch.jazzhand";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports connecting to USB accessories.
 */

public static final java.lang.String FEATURE_USB_ACCESSORY = "android.hardware.usb.accessory";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports connecting to USB devices
 * as the USB host.
 */

public static final java.lang.String FEATURE_USB_HOST = "android.hardware.usb.host";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device supports verified boot.
 */

public static final java.lang.String FEATURE_VERIFIED_BOOT = "android.software.verified_boot";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device implements headtracking suitable for a VR device.
 */

public static final java.lang.String FEATURE_VR_HEADTRACKING = "android.hardware.vr.headtracking";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device implements an optimized mode for virtual reality (VR) applications that handles
 * stereoscopic rendering of notifications, and disables most monocular system UI components
 * while a VR application has user focus.
 * Devices declaring this feature must include an application implementing a
 * {@link android.service.vr.VrListenerService} that can be targeted by VR applications via
 * {@link android.app.Activity#setVrModeEnabled}.
 * @deprecated use {@link #FEATURE_VR_MODE_HIGH_PERFORMANCE} instead.
 */

@Deprecated public static final java.lang.String FEATURE_VR_MODE = "android.software.vr.mode";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device implements an optimized mode for virtual reality (VR) applications that handles
 * stereoscopic rendering of notifications, disables most monocular system UI components
 * while a VR application has user focus and meets extra CDD requirements to provide a
 * high-quality VR experience.
 * Devices declaring this feature must include an application implementing a
 * {@link android.service.vr.VrListenerService} that can be targeted by VR applications via
 * {@link android.app.Activity#setVrModeEnabled}.
 * and must meet CDD requirements to provide a high-quality VR experience.
 */

public static final java.lang.String FEATURE_VR_MODE_HIGH_PERFORMANCE = "android.hardware.vr.high_performance";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature(String, int)}: If this feature is supported, the Vulkan native API
 * will enumerate at least one {@code VkPhysicalDevice}, and the feature version will indicate
 * what level of optional compute features that device supports beyond the Vulkan 1.0
 * requirements.
 * <p>
 * Compute level 0 indicates:
 * <ul>
 * <li>The {@code VK_KHR_variable_pointers} extension and
 *     {@code VkPhysicalDeviceVariablePointerFeaturesKHR::variablePointers} feature are
      supported.</li>
 * <li>{@code VkPhysicalDeviceLimits::maxPerStageDescriptorStorageBuffers} is at least 16.</li>
 * </ul>
 */

public static final java.lang.String FEATURE_VULKAN_HARDWARE_COMPUTE = "android.hardware.vulkan.compute";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature(String, int)}: If this feature is supported, the Vulkan native API
 * will enumerate at least one {@code VkPhysicalDevice}, and the feature version will indicate
 * what level of optional hardware features limits it supports.
 * <p>
 * Level 0 includes the base Vulkan requirements as well as:
 * <ul><li>{@code VkPhysicalDeviceFeatures::textureCompressionETC2}</li></ul>
 * <p>
 * Level 1 additionally includes:
 * <ul>
 * <li>{@code VkPhysicalDeviceFeatures::fullDrawIndexUint32}</li>
 * <li>{@code VkPhysicalDeviceFeatures::imageCubeArray}</li>
 * <li>{@code VkPhysicalDeviceFeatures::independentBlend}</li>
 * <li>{@code VkPhysicalDeviceFeatures::geometryShader}</li>
 * <li>{@code VkPhysicalDeviceFeatures::tessellationShader}</li>
 * <li>{@code VkPhysicalDeviceFeatures::sampleRateShading}</li>
 * <li>{@code VkPhysicalDeviceFeatures::textureCompressionASTC_LDR}</li>
 * <li>{@code VkPhysicalDeviceFeatures::fragmentStoresAndAtomics}</li>
 * <li>{@code VkPhysicalDeviceFeatures::shaderImageGatherExtended}</li>
 * <li>{@code VkPhysicalDeviceFeatures::shaderUniformBufferArrayDynamicIndexing}</li>
 * <li>{@code VkPhysicalDeviceFeatures::shaderSampledImageArrayDynamicIndexing}</li>
 * </ul>
 */

public static final java.lang.String FEATURE_VULKAN_HARDWARE_LEVEL = "android.hardware.vulkan.level";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature(String, int)}: The version of this feature indicates the highest
 * {@code VkPhysicalDeviceProperties::apiVersion} supported by the physical devices that support
 * the hardware level indicated by {@link #FEATURE_VULKAN_HARDWARE_LEVEL}. The feature version
 * uses the same encoding as Vulkan version numbers:
 * <ul>
 * <li>Major version number in bits 31-22</li>
 * <li>Minor version number in bits 21-12</li>
 * <li>Patch version number in bits 11-0</li>
 * </ul>
 * A version of 1.1.0 or higher also indicates:
 * <ul>
 * <li>{@code SYNC_FD} external semaphore and fence handles are supported.</li>
 * <li>{@code VkPhysicalDeviceSamplerYcbcrConversionFeatures::samplerYcbcrConversion} is
 *     supported.</li>
 * </ul>
 */

public static final java.lang.String FEATURE_VULKAN_HARDWARE_VERSION = "android.hardware.vulkan.version";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: This is a device dedicated to showing UI
 * on a watch. A watch here is defined to be a device worn on the body, perhaps on
 * the wrist. The user is very close when interacting with the device.
 */

public static final java.lang.String FEATURE_WATCH = "android.hardware.type.watch";

/**
 * Feature for {@link #getSystemAvailableFeatures} and {@link #hasSystemFeature}:
 * The device has a full implementation of the android.webkit.* APIs. Devices
 * lacking this feature will not have a functioning WebView implementation.
 */

public static final java.lang.String FEATURE_WEBVIEW = "android.software.webview";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports WiFi (802.11) networking.
 */

public static final java.lang.String FEATURE_WIFI = "android.hardware.wifi";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports Wi-Fi Aware.
 */

public static final java.lang.String FEATURE_WIFI_AWARE = "android.hardware.wifi.aware";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports Wi-Fi Direct networking.
 */

public static final java.lang.String FEATURE_WIFI_DIRECT = "android.hardware.wifi.direct";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports Wi-Fi Passpoint and all
 * Passpoint related APIs in {@link WifiManager} are supported. Refer to
 * {@link WifiManager#addOrUpdatePasspointConfiguration} for more info.
 */

public static final java.lang.String FEATURE_WIFI_PASSPOINT = "android.hardware.wifi.passpoint";

/**
 * Feature for {@link #getSystemAvailableFeatures} and
 * {@link #hasSystemFeature}: The device supports Wi-Fi RTT (IEEE 802.11mc).
 */

public static final java.lang.String FEATURE_WIFI_RTT = "android.hardware.wifi.rtt";

/**
 * {@link PackageInfo} flag: return information about
 * activities in the package in {@link PackageInfo#activities}.
 */

public static final int GET_ACTIVITIES = 1; // 0x1

/**
 * {@link PackageInfo} flag: return information about
 * hardware preferences in
 * {@link PackageInfo#configPreferences PackageInfo.configPreferences},
 * and requested features in {@link PackageInfo#reqFeatures} and
 * {@link PackageInfo#featureGroups}.
 */

public static final int GET_CONFIGURATIONS = 16384; // 0x4000

/**
 * @deprecated replaced with {@link #MATCH_DISABLED_COMPONENTS}
 */

@Deprecated public static final int GET_DISABLED_COMPONENTS = 512; // 0x200

/**
 * @deprecated replaced with {@link #MATCH_DISABLED_UNTIL_USED_COMPONENTS}.
 */

@Deprecated public static final int GET_DISABLED_UNTIL_USED_COMPONENTS = 32768; // 0x8000

/**
 * {@link PackageInfo} flag: return the
 * {@link PackageInfo#gids group ids} that are associated with an
 * application.
 * This applies for any API returning a PackageInfo class, either
 * directly or nested inside of another.
 */

public static final int GET_GIDS = 256; // 0x100

/**
 * {@link PackageInfo} flag: return information about
 * instrumentation in the package in
 * {@link PackageInfo#instrumentation}.
 */

public static final int GET_INSTRUMENTATION = 16; // 0x10

/**
 * {@link PackageInfo} flag: return information about the
 * intent filters supported by the activity.
 */

public static final int GET_INTENT_FILTERS = 32; // 0x20

/**
 * {@link ComponentInfo} flag: return the {@link ComponentInfo#metaData}
 * data {@link android.os.Bundle}s that are associated with a component.
 * This applies for any API returning a ComponentInfo subclass.
 */

public static final int GET_META_DATA = 128; // 0x80

/**
 * {@link PackageInfo} flag: return information about
 * permissions in the package in
 * {@link PackageInfo#permissions}.
 */

public static final int GET_PERMISSIONS = 4096; // 0x1000

/**
 * {@link PackageInfo} flag: return information about
 * content providers in the package in
 * {@link PackageInfo#providers}.
 */

public static final int GET_PROVIDERS = 8; // 0x8

/**
 * {@link PackageInfo} flag: return information about
 * intent receivers in the package in
 * {@link PackageInfo#receivers}.
 */

public static final int GET_RECEIVERS = 2; // 0x2

/**
 * {@link ResolveInfo} flag: return the IntentFilter that
 * was matched for a particular ResolveInfo in
 * {@link ResolveInfo#filter}.
 */

public static final int GET_RESOLVED_FILTER = 64; // 0x40

/**
 * {@link PackageInfo} flag: return information about
 * services in the package in {@link PackageInfo#services}.
 */

public static final int GET_SERVICES = 4; // 0x4

/**
 * {@link ApplicationInfo} flag: return the
 * {@link ApplicationInfo#sharedLibraryFiles paths to the shared libraries}
 * that are associated with an application.
 * This applies for any API returning an ApplicationInfo class, either
 * directly or nested inside of another.
 */

public static final int GET_SHARED_LIBRARY_FILES = 1024; // 0x400

/**
 * {@link PackageInfo} flag: return information about the
 * signatures included in the package.
 *
 * @deprecated use {@code GET_SIGNING_CERTIFICATES} instead
 */

@Deprecated public static final int GET_SIGNATURES = 64; // 0x40

/**
 * {@link PackageInfo} flag: return the signing certificates associated with
 * this package.  Each entry is a signing certificate that the package
 * has proven it is authorized to use, usually a past signing certificate from
 * which it has rotated.
 */

public static final int GET_SIGNING_CERTIFICATES = 134217728; // 0x8000000

/**
 * @deprecated replaced with {@link #MATCH_UNINSTALLED_PACKAGES}
 */

@Deprecated public static final int GET_UNINSTALLED_PACKAGES = 8192; // 0x2000

/**
 * {@link ProviderInfo} flag: return the
 * {@link ProviderInfo#uriPermissionPatterns URI permission patterns}
 * that are associated with a content provider.
 * This applies for any API returning a ProviderInfo class, either
 * directly or nested inside of another.
 */

public static final int GET_URI_PERMISSION_PATTERNS = 2048; // 0x800

/**
 * Code indicating that this package was installed as part of restoring from another device.
 */

public static final int INSTALL_REASON_DEVICE_RESTORE = 2; // 0x2

/**
 * Code indicating that this package was installed as part of device setup.
 */

public static final int INSTALL_REASON_DEVICE_SETUP = 3; // 0x3

/**
 * Code indicating that this package was installed due to enterprise policy.
 */

public static final int INSTALL_REASON_POLICY = 1; // 0x1

/**
 * Code indicating that the reason for installing this package is unknown.
 */

public static final int INSTALL_REASON_UNKNOWN = 0; // 0x0

/**
 * Code indicating that the package installation was initiated by the user.
 */

public static final int INSTALL_REASON_USER = 4; // 0x4

/**
 * Querying flag: if set and if the platform is doing any filtering of the
 * results, then the filtering will not happen. This is a synonym for saying
 * that all results should be returned.
 * <p>
 * <em>This flag should be used with extreme care.</em>
 */

public static final int MATCH_ALL = 131072; // 0x20000

/**
 * Resolution and querying flag: if set, only filters that support the
 * {@link android.content.Intent#CATEGORY_DEFAULT} will be considered for
 * matching.  This is a synonym for including the CATEGORY_DEFAULT in your
 * supplied Intent.
 */

public static final int MATCH_DEFAULT_ONLY = 65536; // 0x10000

/**
 * Querying flag: match components which are direct boot <em>aware</em> in
 * the returned info, regardless of the current user state.
 * <p>
 * When neither {@link #MATCH_DIRECT_BOOT_AWARE} nor
 * {@link #MATCH_DIRECT_BOOT_UNAWARE} are specified, the default behavior is
 * to match only runnable components based on the user state. For example,
 * when a user is started but credentials have not been presented yet, the
 * user is running "locked" and only {@link #MATCH_DIRECT_BOOT_AWARE}
 * components are returned. Once the user credentials have been presented,
 * the user is running "unlocked" and both {@link #MATCH_DIRECT_BOOT_AWARE}
 * and {@link #MATCH_DIRECT_BOOT_UNAWARE} components are returned.
 *
 * @see UserManager#isUserUnlocked()
 */

public static final int MATCH_DIRECT_BOOT_AWARE = 524288; // 0x80000

/**
 * Querying flag: match components which are direct boot <em>unaware</em> in
 * the returned info, regardless of the current user state.
 * <p>
 * When neither {@link #MATCH_DIRECT_BOOT_AWARE} nor
 * {@link #MATCH_DIRECT_BOOT_UNAWARE} are specified, the default behavior is
 * to match only runnable components based on the user state. For example,
 * when a user is started but credentials have not been presented yet, the
 * user is running "locked" and only {@link #MATCH_DIRECT_BOOT_AWARE}
 * components are returned. Once the user credentials have been presented,
 * the user is running "unlocked" and both {@link #MATCH_DIRECT_BOOT_AWARE}
 * and {@link #MATCH_DIRECT_BOOT_UNAWARE} components are returned.
 *
 * @see UserManager#isUserUnlocked()
 */

public static final int MATCH_DIRECT_BOOT_UNAWARE = 262144; // 0x40000

/**
 * {@link PackageInfo} flag: include disabled components in the returned info.
 */

public static final int MATCH_DISABLED_COMPONENTS = 512; // 0x200

/**
 * {@link PackageInfo} flag: include disabled components which are in
 * that state only because of {@link #COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED}
 * in the returned info.  Note that if you set this flag, applications
 * that are in this disabled state will be reported as enabled.
 */

public static final int MATCH_DISABLED_UNTIL_USED_COMPONENTS = 32768; // 0x8000

/**
 * Querying flag: include only components from applications that are marked
 * with {@link ApplicationInfo#FLAG_SYSTEM}.
 */

public static final int MATCH_SYSTEM_ONLY = 1048576; // 0x100000

/**
 * Flag parameter to retrieve some information about all applications (even
 * uninstalled ones) which have data directories. This state could have
 * resulted if applications have been deleted with flag
 * {@code DONT_DELETE_DATA} with a possibility of being replaced or
 * reinstalled in future.
 * <p>
 * Note: this flag may cause less information about currently installed
 * applications to be returned.
 */

public static final int MATCH_UNINSTALLED_PACKAGES = 8192; // 0x2000

/**
 * Can be used as the {@code millisecondsToDelay} argument for
 * {@link PackageManager#extendVerificationTimeout}. This is the
 * maximum time {@code PackageManager} waits for the verification
 * agent to return (in milliseconds).
 */

public static final long MAXIMUM_VERIFICATION_TIMEOUT = 3600000L; // 0x36ee80L

/**
 * Permission check result: this is returned by {@link #checkPermission}
 * if the permission has not been granted to the given package.
 */

public static final int PERMISSION_DENIED = -1; // 0xffffffff

/**
 * Permission check result: this is returned by {@link #checkPermission}
 * if the permission has been granted to the given package.
 */

public static final int PERMISSION_GRANTED = 0; // 0x0

/**
 * Signature check result: this is returned by {@link #checkSignatures}
 * if the first package is not signed but the second is.
 */

public static final int SIGNATURE_FIRST_NOT_SIGNED = -1; // 0xffffffff

/**
 * Signature check result: this is returned by {@link #checkSignatures}
 * if all signatures on the two packages match.
 */

public static final int SIGNATURE_MATCH = 0; // 0x0

/**
 * Signature check result: this is returned by {@link #checkSignatures}
 * if neither of the two packages is signed.
 */

public static final int SIGNATURE_NEITHER_SIGNED = 1; // 0x1

/**
 * Signature check result: this is returned by {@link #checkSignatures}
 * if not all signatures on both packages match.
 */

public static final int SIGNATURE_NO_MATCH = -3; // 0xfffffffd

/**
 * Signature check result: this is returned by {@link #checkSignatures}
 * if the second package is not signed but the first is.
 */

public static final int SIGNATURE_SECOND_NOT_SIGNED = -2; // 0xfffffffe

/**
 * Signature check result: this is returned by {@link #checkSignatures}
 * if either of the packages are not valid.
 */

public static final int SIGNATURE_UNKNOWN_PACKAGE = -4; // 0xfffffffc

/**
 * Used as the {@code verificationCode} argument for
 * {@link PackageManager#verifyPendingInstall} to indicate that the calling
 * package verifier allows the installation to proceed.
 */

public static final int VERIFICATION_ALLOW = 1; // 0x1

/**
 * Used as the {@code verificationCode} argument for
 * {@link PackageManager#verifyPendingInstall} to indicate the calling
 * package verifier does not vote to allow the installation to proceed.
 */

public static final int VERIFICATION_REJECT = -1; // 0xffffffff

/**
 * Constant for specifying the highest installed package version code.
 */

public static final int VERSION_CODE_HIGHEST = -1; // 0xffffffff
/**
 * This exception is thrown when a given package, application, or component
 * name cannot be found.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class NameNotFoundException extends android.util.AndroidException {

public NameNotFoundException() { throw new RuntimeException("Stub!"); }

public NameNotFoundException(java.lang.String name) { throw new RuntimeException("Stub!"); }
}

}

