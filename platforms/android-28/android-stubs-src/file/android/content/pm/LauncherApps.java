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

import android.content.Intent;
import android.os.UserManager;
import android.os.UserHandle;
import java.util.List;
import android.content.ComponentName;
import android.graphics.Rect;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.content.ActivityNotFoundException;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.app.PendingIntent;

/**
 * Class for retrieving a list of launchable activities for the current user and any associated
 * managed profiles that are visible to the current user, which can be retrieved with
 * {@link #getProfiles}. This is mainly for use by launchers.
 *
 * Apps can be queried for each user profile.
 * Since the PackageManager will not deliver package broadcasts for other profiles, you can register
 * for package changes here.
 * <p>
 * To watch for managed profiles being added or removed, register for the following broadcasts:
 * {@link Intent#ACTION_MANAGED_PROFILE_ADDED} and {@link Intent#ACTION_MANAGED_PROFILE_REMOVED}.
 * <p>
 * Note as of Android O, apps on a managed profile are no longer allowed to access apps on the
 * main profile.  Apps can only access profiles returned by {@link #getProfiles()}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LauncherApps {

/** @hide */

LauncherApps(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Return a list of profiles that the caller can access via the {@link LauncherApps} APIs.
 *
 * <p>If the caller is running on a managed profile, it'll return only the current profile.
 * Otherwise it'll return the same list as {@link UserManager#getUserProfiles()} would.
 */

public java.util.List<android.os.UserHandle> getProfiles() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves a list of launchable activities that match {@link Intent#ACTION_MAIN} and
 * {@link Intent#CATEGORY_LAUNCHER}, for a specified user.
 *
 * @param packageName The specific package to query. If null, it checks all installed packages
 *            in the profile.
 * @param user The UserHandle of the profile.
 * @return List of launchable activities. Can be an empty list but will not be null.
 */

public java.util.List<android.content.pm.LauncherActivityInfo> getActivityList(java.lang.String packageName, android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Returns the activity info for a given intent and user handle, if it resolves. Otherwise it
 * returns null.
 *
 * @param intent The intent to find a match for.
 * @param user The profile to look in for a match.
 * @return An activity info object if there is a match.
 */

public android.content.pm.LauncherActivityInfo resolveActivity(android.content.Intent intent, android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Starts a Main activity in the specified profile.
 *
 * @param component The ComponentName of the activity to launch
 * @param user The UserHandle of the profile
 * @param sourceBounds The Rect containing the source bounds of the clicked icon
 * @param opts Options to pass to startActivity
 */

public void startMainActivity(android.content.ComponentName component, android.os.UserHandle user, android.graphics.Rect sourceBounds, android.os.Bundle opts) { throw new RuntimeException("Stub!"); }

/**
 * Starts the settings activity to show the application details for a
 * package in the specified profile.
 *
 * @param component The ComponentName of the package to launch settings for.
 * @param user The UserHandle of the profile
 * @param sourceBounds The Rect containing the source bounds of the clicked icon
 * @param opts Options to pass to startActivity
 */

public void startAppDetailsActivity(android.content.ComponentName component, android.os.UserHandle user, android.graphics.Rect sourceBounds, android.os.Bundle opts) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves a list of config activities for creating {@link ShortcutInfo}.
 *
 * @param packageName The specific package to query. If null, it checks all installed packages
 *            in the profile.
 * This value may be {@code null}.
 * @param user The UserHandle of the profile.
 * This value must never be {@code null}.
 * @return List of config activities. Can be an empty list but will not be null.
 *
 * @see Intent#ACTION_CREATE_SHORTCUT
 * @see #getShortcutConfigActivityIntent(LauncherActivityInfo)
 */

public java.util.List<android.content.pm.LauncherActivityInfo> getShortcutConfigActivityList(@androidx.annotation.RecentlyNullable java.lang.String packageName, @androidx.annotation.RecentlyNonNull android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Returns an intent sender which can be used to start the configure activity for creating
 * custom shortcuts. Use this method if the provider is in another profile as you are not
 * allowed to start an activity in another profile.
 *
 * <p>The caller should receive {@link PinItemRequest} in onActivityResult on
 * {@link android.app.Activity#RESULT_OK}.
 *
 * <p>Callers must be allowed to access the shortcut information, as defined in {@link
 * #hasShortcutHostPermission()}.
 *
 * @param info a configuration activity returned by {@link #getShortcutConfigActivityList}
 *
 * This value must never be {@code null}.
 * @throws IllegalStateException when the user is locked or not running.
 * @throws SecurityException if {@link #hasShortcutHostPermission()} is false.
 *
 * @see #getPinItemRequest(Intent)
 * @see Intent#ACTION_CREATE_SHORTCUT
 * @see android.app.Activity#startIntentSenderForResult
 
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.content.IntentSender getShortcutConfigActivityIntent(@androidx.annotation.RecentlyNonNull android.content.pm.LauncherActivityInfo info) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the package is installed and enabled for a profile.
 *
 * @param packageName The package to check.
 * @param user The UserHandle of the profile.
 *
 * @return true if the package exists and is enabled.
 */

public boolean isPackageEnabled(java.lang.String packageName, android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Gets the launcher extras supplied to the system when the given package was suspended via
 * {@code PackageManager#setPackagesSuspended(String[], boolean, PersistableBundle,
 * PersistableBundle, String)}.
 *
 * <p>The contents of this {@link Bundle} are supposed to be a contract between the suspending
 * app and the launcher.
 *
 * <p>Note: This just returns whatever extras were provided to the system, <em>which might
 * even be {@code null}.</em>
 *
 * @param packageName The package for which to fetch the launcher extras.
 * @param user The {@link UserHandle} of the profile.
 * @return A {@link Bundle} of launcher extras. Or {@code null} if the package is not currently
 *         suspended.
 *
 * @see Callback#onPackagesSuspended(String[], UserHandle, Bundle)
 * @see PackageManager#isPackageSuspended()
 */

@androidx.annotation.RecentlyNullable public android.os.Bundle getSuspendedPackageLauncherExtras(java.lang.String packageName, android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@link ApplicationInfo} about an application installed for a specific user profile.
 *
 * @param packageName The package name of the application
 * This value must never be {@code null}.
 * @param flags Additional option flags {@link PackageManager#getApplicationInfo}
 * Value is either <code>0</code> or a combination of {@link android.content.pm.PackageManager#GET_META_DATA}, {@link android.content.pm.PackageManager#GET_SHARED_LIBRARY_FILES}, {@link android.content.pm.PackageManager#MATCH_UNINSTALLED_PACKAGES}, {@link android.content.pm.PackageManager#MATCH_SYSTEM_ONLY}, android.content.pm.PackageManager.MATCH_DEBUG_TRIAGED_MISSING, {@link android.content.pm.PackageManager#MATCH_DISABLED_COMPONENTS}, {@link android.content.pm.PackageManager#MATCH_DISABLED_UNTIL_USED_COMPONENTS}, android.content.pm.PackageManager.MATCH_INSTANT, android.content.pm.PackageManager.MATCH_STATIC_SHARED_LIBRARIES, {@link android.content.pm.PackageManager#GET_DISABLED_UNTIL_USED_COMPONENTS}, {@link android.content.pm.PackageManager#GET_UNINSTALLED_PACKAGES}, and android.content.pm.PackageManager.MATCH_HIDDEN_UNTIL_INSTALLED_COMPONENTS
 * @param user The UserHandle of the profile.
 *
 * This value must never be {@code null}.
 * @return {@link ApplicationInfo} containing information about the package. Returns
 *         {@code null} if the package isn't installed for the given profile, or the profile
 *         isn't enabled.
 */

public android.content.pm.ApplicationInfo getApplicationInfo(@androidx.annotation.RecentlyNonNull java.lang.String packageName, int flags, @androidx.annotation.RecentlyNonNull android.os.UserHandle user) throws android.content.pm.PackageManager.NameNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Checks if the activity exists and it enabled for a profile.
 *
 * @param component The activity to check.
 * @param user The UserHandle of the profile.
 *
 * @return true if the activity exists and is enabled.
 */

public boolean isActivityEnabled(android.content.ComponentName component, android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the caller can access the shortcut information.  Access is currently
 * available to:
 *
 * <ul>
 *     <li>The current launcher (or default launcher if there is no set current launcher).</li>
 *     <li>The currently active voice interaction service.</li>
 * </ul>
 *
 * <p>Note when this method returns {@code false}, it may be a temporary situation because
 * the user is trying a new launcher application.  The user may decide to change the default
 * launcher back to the calling application again, so even if a launcher application loses
 * this permission, it does <b>not</b> have to purge pinned shortcut information.
 * If the calling launcher application contains pinned shortcuts, they will still work,
 * even though the caller no longer has the shortcut host permission.
 *
 * @throws IllegalStateException when the user is locked.
 *
 * @see ShortcutManager
 */

public boolean hasShortcutHostPermission() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@link ShortcutInfo}s that match {@code query}.
 *
 * <p>Callers must be allowed to access the shortcut information, as defined in {@link
 * #hasShortcutHostPermission()}.
 *
 * @param query result includes shortcuts matching this query.
 * This value must never be {@code null}.
 * @param user The UserHandle of the profile.
 *
 * This value must never be {@code null}.
 * @return the IDs of {@link ShortcutInfo}s that match the query.
 * This value may be {@code null}.
 * @throws IllegalStateException when the user is locked, or when the {@code user} user
 * is locked or not running.
 *
 * @see ShortcutManager
 */

@androidx.annotation.RecentlyNullable public java.util.List<android.content.pm.ShortcutInfo> getShortcuts(@androidx.annotation.RecentlyNonNull android.content.pm.LauncherApps.ShortcutQuery query, @androidx.annotation.RecentlyNonNull android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Pin shortcuts on a package.
 *
 * <p>This API is <b>NOT</b> cumulative; this will replace all pinned shortcuts for the package.
 * However, different launchers may have different set of pinned shortcuts.
 *
 * <p>The calling launcher application must be allowed to access the shortcut information,
 * as defined in {@link #hasShortcutHostPermission()}.
 *
 * @param packageName The target package name.
 * This value must never be {@code null}.
 * @param shortcutIds The IDs of the shortcut to be pinned.
 * This value must never be {@code null}.
 * @param user The UserHandle of the profile.
 * This value must never be {@code null}.
 * @throws IllegalStateException when the user is locked, or when the {@code user} user
 * is locked or not running.
 *
 * @see ShortcutManager
 */

public void pinShortcuts(@androidx.annotation.RecentlyNonNull java.lang.String packageName, @androidx.annotation.RecentlyNonNull java.util.List<java.lang.String> shortcutIds, @androidx.annotation.RecentlyNonNull android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Returns the icon for this shortcut, without any badging for the profile.
 *
 * <p>The calling launcher application must be allowed to access the shortcut information,
 * as defined in {@link #hasShortcutHostPermission()}.
 *
 * @param density The preferred density of the icon, zero for default density. Use
 * density DPI values from {@link DisplayMetrics}.
 *
 * @param shortcut This value must never be {@code null}.
 * @return The drawable associated with the shortcut.
 * @throws IllegalStateException when the user is locked, or when the {@code user} user
 * is locked or not running.
 *
 * @see ShortcutManager
 * @see #getShortcutBadgedIconDrawable(ShortcutInfo, int)
 * @see DisplayMetrics
 */

public android.graphics.drawable.Drawable getShortcutIconDrawable(@androidx.annotation.RecentlyNonNull android.content.pm.ShortcutInfo shortcut, int density) { throw new RuntimeException("Stub!"); }

/**
 * Returns the shortcut icon with badging appropriate for the profile.
 *
 * <p>The calling launcher application must be allowed to access the shortcut information,
 * as defined in {@link #hasShortcutHostPermission()}.
 *
 * @param density Optional density for the icon, or 0 to use the default density. Use
 * @return A badged icon for the shortcut.
 * @throws IllegalStateException when the user is locked, or when the {@code user} user
 * is locked or not running.
 *
 * @see ShortcutManager
 * @see #getShortcutIconDrawable(ShortcutInfo, int)
 * @see DisplayMetrics
 */

public android.graphics.drawable.Drawable getShortcutBadgedIconDrawable(android.content.pm.ShortcutInfo shortcut, int density) { throw new RuntimeException("Stub!"); }

/**
 * Starts a shortcut.
 *
 * <p>The calling launcher application must be allowed to access the shortcut information,
 * as defined in {@link #hasShortcutHostPermission()}.
 *
 * @param packageName The target shortcut package name.
 * This value must never be {@code null}.
 * @param shortcutId The target shortcut ID.
 * This value must never be {@code null}.
 * @param sourceBounds The Rect containing the source bounds of the clicked icon.
 * This value may be {@code null}.
 * @param startActivityOptions Options to pass to startActivity.
 * This value may be {@code null}.
 * @param user The UserHandle of the profile.
 * This value must never be {@code null}.
 * @throws IllegalStateException when the user is locked, or when the {@code user} user
 * is locked or not running.
 *
 * @throws android.content.ActivityNotFoundException failed to start shortcut. (e.g.
 * the shortcut no longer exists, is disabled, the intent receiver activity doesn't exist, etc)
 */

public void startShortcut(@androidx.annotation.RecentlyNonNull java.lang.String packageName, @androidx.annotation.RecentlyNonNull java.lang.String shortcutId, @androidx.annotation.RecentlyNullable android.graphics.Rect sourceBounds, @androidx.annotation.RecentlyNullable android.os.Bundle startActivityOptions, @androidx.annotation.RecentlyNonNull android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Launches a shortcut.
 *
 * <p>The calling launcher application must be allowed to access the shortcut information,
 * as defined in {@link #hasShortcutHostPermission()}.
 *
 * @param shortcut The target shortcut.
 * This value must never be {@code null}.
 * @param sourceBounds The Rect containing the source bounds of the clicked icon.
 * This value may be {@code null}.
 * @param startActivityOptions Options to pass to startActivity.
 * This value may be {@code null}.
 * @throws IllegalStateException when the user is locked, or when the {@code user} user
 * is locked or not running.
 *
 * @throws android.content.ActivityNotFoundException failed to start shortcut. (e.g.
 * the shortcut no longer exists, is disabled, the intent receiver activity doesn't exist, etc)
 */

public void startShortcut(@androidx.annotation.RecentlyNonNull android.content.pm.ShortcutInfo shortcut, @androidx.annotation.RecentlyNullable android.graphics.Rect sourceBounds, @androidx.annotation.RecentlyNullable android.os.Bundle startActivityOptions) { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback for changes to packages in current and managed profiles.
 *
 * @param callback The callback to register.
 */

public void registerCallback(android.content.pm.LauncherApps.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback for changes to packages in current and managed profiles.
 *
 * @param callback The callback to register.
 * @param handler that should be used to post callbacks on, may be null.
 */

public void registerCallback(android.content.pm.LauncherApps.Callback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a callback that was previously registered.
 *
 * @param callback The callback to unregister.
 * @see #registerCallback(Callback)
 */

public void unregisterCallback(android.content.pm.LauncherApps.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * A helper method to extract a {@link PinItemRequest} set to
 * the {@link #EXTRA_PIN_ITEM_REQUEST} extra.
 */

public android.content.pm.LauncherApps.PinItemRequest getPinItemRequest(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Activity Action: For the default launcher to show the confirmation dialog to create
 * a pinned app widget.
 *
 * <p>See the {@link android.appwidget.AppWidgetManager#requestPinAppWidget} javadoc for
 * details.
 *
 * <p>
 * Use {@link #getPinItemRequest(Intent)} to get a {@link PinItemRequest} object,
 * and call {@link PinItemRequest#accept(Bundle)}
 * if the user accepts.  If the user doesn't accept, no further action is required.
 *
 * @see #EXTRA_PIN_ITEM_REQUEST
 */

public static final java.lang.String ACTION_CONFIRM_PIN_APPWIDGET = "android.content.pm.action.CONFIRM_PIN_APPWIDGET";

/**
 * Activity Action: For the default launcher to show the confirmation dialog to create
 * a pinned shortcut.
 *
 * <p>See the {@link ShortcutManager} javadoc for details.
 *
 * <p>
 * Use {@link #getPinItemRequest(Intent)} to get a {@link PinItemRequest} object,
 * and call {@link PinItemRequest#accept(Bundle)}
 * if the user accepts.  If the user doesn't accept, no further action is required.
 *
 * @see #EXTRA_PIN_ITEM_REQUEST
 */

public static final java.lang.String ACTION_CONFIRM_PIN_SHORTCUT = "android.content.pm.action.CONFIRM_PIN_SHORTCUT";

/**
 * An extra for {@link #ACTION_CONFIRM_PIN_SHORTCUT} &amp; {@link #ACTION_CONFIRM_PIN_APPWIDGET}
 * containing a {@link PinItemRequest} of appropriate type asked to pin.
 *
 * <p>A helper function {@link #getPinItemRequest(Intent)} can be used
 * instead of using this constant directly.
 *
 * @see #ACTION_CONFIRM_PIN_SHORTCUT
 * @see #ACTION_CONFIRM_PIN_APPWIDGET
 */

public static final java.lang.String EXTRA_PIN_ITEM_REQUEST = "android.content.pm.extra.PIN_ITEM_REQUEST";
/**
 * Callbacks for package changes to this and related managed profiles.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Indicates that a package was removed from the specified profile.
 *
 * If a package is removed while being updated onPackageChanged will be
 * called instead.
 *
 * @param packageName The name of the package that was removed.
 * @param user The UserHandle of the profile that generated the change.
 */

public abstract void onPackageRemoved(java.lang.String packageName, android.os.UserHandle user);

/**
 * Indicates that a package was added to the specified profile.
 *
 * If a package is added while being updated then onPackageChanged will be
 * called instead.
 *
 * @param packageName The name of the package that was added.
 * @param user The UserHandle of the profile that generated the change.
 */

public abstract void onPackageAdded(java.lang.String packageName, android.os.UserHandle user);

/**
 * Indicates that a package was modified in the specified profile.
 * This can happen, for example, when the package is updated or when
 * one or more components are enabled or disabled.
 *
 * @param packageName The name of the package that has changed.
 * @param user The UserHandle of the profile that generated the change.
 */

public abstract void onPackageChanged(java.lang.String packageName, android.os.UserHandle user);

/**
 * Indicates that one or more packages have become available. For
 * example, this can happen when a removable storage card has
 * reappeared.
 *
 * @param packageNames The names of the packages that have become
 *            available.
 * @param user The UserHandle of the profile that generated the change.
 * @param replacing Indicates whether these packages are replacing
 *            existing ones.
 */

public abstract void onPackagesAvailable(java.lang.String[] packageNames, android.os.UserHandle user, boolean replacing);

/**
 * Indicates that one or more packages have become unavailable. For
 * example, this can happen when a removable storage card has been
 * removed.
 *
 * @param packageNames The names of the packages that have become
 *            unavailable.
 * @param user The UserHandle of the profile that generated the change.
 * @param replacing Indicates whether the packages are about to be
 *            replaced with new versions.
 */

public abstract void onPackagesUnavailable(java.lang.String[] packageNames, android.os.UserHandle user, boolean replacing);

/**
 * Indicates that one or more packages have been suspended. For
 * example, this can happen when a Device Administrator suspends
 * an applicaton.
 *
 * <p>Note: On devices running {@link android.os.Build.VERSION_CODES#P Android P} or higher,
 * any apps that override {@link #onPackagesSuspended(String[], UserHandle, Bundle)} will
 * not receive this callback.
 *
 * @param packageNames The names of the packages that have just been
 *            suspended.
 * @param user The UserHandle of the profile that generated the change.
 */

public void onPackagesSuspended(java.lang.String[] packageNames, android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that one or more packages have been suspended. A device administrator or an app
 * with {@code android.permission.SUSPEND_APPS} can do this.
 *
 * <p>A suspending app with the permission {@code android.permission.SUSPEND_APPS} can
 * optionally provide a {@link Bundle} of extra information that it deems helpful for the
 * launcher to handle the suspended state of these packages. The contents of this
 * {@link Bundle} are supposed to be a contract between the suspending app and the launcher.
 *
 * @param packageNames The names of the packages that have just been suspended.
 * @param user the user for which the given packages were suspended.
 * @param launcherExtras A {@link Bundle} of extras for the launcher, if provided to the
 *                      system, {@code null} otherwise.
 * This value may be {@code null}.
 * @see PackageManager#isPackageSuspended()
 * @see #getSuspendedPackageLauncherExtras(String, UserHandle)
 */

public void onPackagesSuspended(java.lang.String[] packageNames, android.os.UserHandle user, @androidx.annotation.RecentlyNullable android.os.Bundle launcherExtras) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that one or more packages have been unsuspended. For
 * example, this can happen when a Device Administrator unsuspends
 * an applicaton.
 *
 * @param packageNames The names of the packages that have just been
 *            unsuspended.
 * @param user The UserHandle of the profile that generated the change.
 */

public void onPackagesUnsuspended(java.lang.String[] packageNames, android.os.UserHandle user) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that one or more shortcuts of any kind (dynamic, pinned, or manifest)
 * have been added, updated or removed.
 *
 * <p>Only the applications that are allowed to access the shortcut information,
 * as defined in {@link #hasShortcutHostPermission()}, will receive it.
 *
 * @param packageName The name of the package that has the shortcuts.
 * This value must never be {@code null}.
 * @param shortcuts All shortcuts from the package (dynamic, manifest and/or pinned).
 *    Only "key" information will be provided, as defined in
 *    {@link ShortcutInfo#hasKeyFieldsOnly()}.
 * This value must never be {@code null}.
 * @param user The UserHandle of the profile that generated the change.
 *
 * This value must never be {@code null}.
 * @see ShortcutManager
 */

public void onShortcutsChanged(@androidx.annotation.RecentlyNonNull java.lang.String packageName, @androidx.annotation.RecentlyNonNull java.util.List<android.content.pm.ShortcutInfo> shortcuts, @androidx.annotation.RecentlyNonNull android.os.UserHandle user) { throw new RuntimeException("Stub!"); }
}

/**
 * Represents a "pin shortcut" or a "pin appwidget" request made by an app, which is sent with
 * an {@link #ACTION_CONFIRM_PIN_SHORTCUT} or {@link #ACTION_CONFIRM_PIN_APPWIDGET} intent
 * respectively to the default launcher app.
 *
 * <h3>Request of the {@link #REQUEST_TYPE_SHORTCUT} type.
 *
 * <p>A {@link #REQUEST_TYPE_SHORTCUT} request represents a request to pin a
 * {@link ShortcutInfo}.  If the launcher accepts a request, call {@link #accept()},
 * or {@link #accept(Bundle)} with a null or empty Bundle.  No options are defined for
 * pin-shortcuts requests.
 *
 * <p>{@link #getShortcutInfo()} always returns a non-null {@link ShortcutInfo} for this type.
 *
 * <p>The launcher may receive a request with a {@link ShortcutInfo} that is already pinned, in
 * which case {@link ShortcutInfo#isPinned()} returns true.  This means the user wants to create
 * another pinned shortcut for a shortcut that's already pinned.  If the launcher accepts it,
 * {@link #accept()} must still be called even though the shortcut is already pinned, and
 * create a new pinned shortcut icon for it.
 *
 * <p>See also {@link ShortcutManager} for more details.
 *
 * <h3>Request of the {@link #REQUEST_TYPE_APPWIDGET} type.
 *
 * <p>A {@link #REQUEST_TYPE_SHORTCUT} request represents a request to pin a
 * an AppWidget.  If the launcher accepts a request, call {@link #accept(Bundle)} with
 * the appwidget integer ID set to the
 * {@link android.appwidget.AppWidgetManager#EXTRA_APPWIDGET_ID} extra.
 *
 * <p>{@link #getAppWidgetProviderInfo(Context)} always returns a non-null
 * {@link AppWidgetProviderInfo} for this type.
 *
 * <p>See also {@link AppWidgetManager} for more details.
 *
 * @see #EXTRA_PIN_ITEM_REQUEST
 * @see #getPinItemRequest(Intent)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class PinItemRequest implements android.os.Parcelable {

PinItemRequest(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/**
 * Represents the type of a request, which is one of the {@code REQUEST_TYPE_} constants.
 *
 * @return one of the {@code REQUEST_TYPE_} constants.

 * Value is {@link android.content.pm.LauncherApps.PinItemRequest#REQUEST_TYPE_SHORTCUT}, or {@link android.content.pm.LauncherApps.PinItemRequest#REQUEST_TYPE_APPWIDGET}
 */

public int getRequestType() { throw new RuntimeException("Stub!"); }

/**
 * {@link ShortcutInfo} sent by the requesting app.
 * Always non-null for a {@link #REQUEST_TYPE_SHORTCUT} request, and always null for a
 * different request type.
 *
 * @return requested {@link ShortcutInfo} when a request is of the
 * {@link #REQUEST_TYPE_SHORTCUT} type.  Null otherwise.
 */

@androidx.annotation.RecentlyNullable public android.content.pm.ShortcutInfo getShortcutInfo() { throw new RuntimeException("Stub!"); }

/**
 * {@link AppWidgetProviderInfo} sent by the requesting app.
 * Always non-null for a {@link #REQUEST_TYPE_APPWIDGET} request, and always null for a
 * different request type.
 *
 * <p>Launcher should not show any configuration activity associated with the provider, and
 * assume that the widget is already fully configured. Upon accepting the widget, it should
 * pass the widgetId in {@link #accept(Bundle)}.
 *
 * @return requested {@link AppWidgetProviderInfo} when a request is of the
 * {@link #REQUEST_TYPE_APPWIDGET} type.  Null otherwise.
 */

@androidx.annotation.RecentlyNullable public android.appwidget.AppWidgetProviderInfo getAppWidgetProviderInfo(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Any extras sent by the requesting app.
 *
 * @return For a shortcut request, this method always return null.  For an AppWidget
 * request, this method returns the extras passed to the
 * {@link android.appwidget.AppWidgetManager#requestPinAppWidget(
 * ComponentName, Bundle, PendingIntent)} API.  See {@link AppWidgetManager} for details.
 */

@androidx.annotation.RecentlyNullable public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Return whether a request is still valid.
 *
 * @return {@code TRUE} if a request is valid and {@link #accept(Bundle)} may be called.
 */

public boolean isValid() { throw new RuntimeException("Stub!"); }

/**
 * Called by the receiving launcher app when the user accepts the request.
 *
 * @param options must be set for a {@link #REQUEST_TYPE_APPWIDGET} request.
 *
 * This value may be {@code null}.
 * @return {@code TRUE} if the shortcut or the AppWidget has actually been pinned.
 * {@code FALSE} if the item hasn't been pinned, for example, because the request had
 * already been canceled, in which case the launcher must not pin the requested item.
 */

public boolean accept(@androidx.annotation.RecentlyNullable android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Called by the receiving launcher app when the user accepts the request, with no options.
 *
 * @return {@code TRUE} if the shortcut or the AppWidget has actually been pinned.
 * {@code FALSE} if the item hasn't been pinned, for example, because the request had
 * already been canceled, in which case the launcher must not pin the requested item.
 */

public boolean accept() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.LauncherApps.PinItemRequest> CREATOR;
static { CREATOR = null; }

/** This is a request to pin app widget. */

public static final int REQUEST_TYPE_APPWIDGET = 2; // 0x2

/** This is a request to pin shortcut. */

public static final int REQUEST_TYPE_SHORTCUT = 1; // 0x1
}

/**
 * Represents a query passed to {@link #getShortcuts(ShortcutQuery, UserHandle)}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ShortcutQuery {

public ShortcutQuery() { throw new RuntimeException("Stub!"); }

/**
 * If non-zero, returns only shortcuts that have been added or updated
 * since the given timestamp, expressed in milliseconds since the Epoch&mdash;see
 * {@link System#currentTimeMillis()}.
 */

public android.content.pm.LauncherApps.ShortcutQuery setChangedSince(long changedSince) { throw new RuntimeException("Stub!"); }

/**
 * If non-null, returns only shortcuts from the package.

 * @param packageName This value may be {@code null}.
 */

public android.content.pm.LauncherApps.ShortcutQuery setPackage(@androidx.annotation.RecentlyNullable java.lang.String packageName) { throw new RuntimeException("Stub!"); }

/**
 * If non-null, return only the specified shortcuts by ID.  When setting this field,
 * a package name must also be set with {@link #setPackage}.

 * @param shortcutIds This value may be {@code null}.
 */

public android.content.pm.LauncherApps.ShortcutQuery setShortcutIds(@androidx.annotation.RecentlyNullable java.util.List<java.lang.String> shortcutIds) { throw new RuntimeException("Stub!"); }

/**
 * If non-null, returns only shortcuts associated with the activity; i.e.
 * {@link ShortcutInfo}s whose {@link ShortcutInfo#getActivity()} are equal
 * to {@code activity}.

 * @param activity This value may be {@code null}.
 */

public android.content.pm.LauncherApps.ShortcutQuery setActivity(@androidx.annotation.RecentlyNullable android.content.ComponentName activity) { throw new RuntimeException("Stub!"); }

/**
 * Set query options.  At least one of the {@code MATCH} flags should be set.  Otherwise,
 * no shortcuts will be returned.
 *
 * <ul>
 *     <li>{@link #FLAG_MATCH_DYNAMIC}
 *     <li>{@link #FLAG_MATCH_PINNED}
 *     <li>{@link #FLAG_MATCH_MANIFEST}
 *     <li>{@link #FLAG_GET_KEY_FIELDS_ONLY}
 * </ul>

 * @param queryFlags Value is either <code>0</code> or a combination of {@link android.content.pm.LauncherApps.ShortcutQuery#FLAG_MATCH_DYNAMIC}, {@link android.content.pm.LauncherApps.ShortcutQuery#FLAG_MATCH_PINNED}, {@link android.content.pm.LauncherApps.ShortcutQuery#FLAG_MATCH_MANIFEST}, {@link android.content.pm.LauncherApps.ShortcutQuery#FLAG_GET_KEY_FIELDS_ONLY}, and {@link android.content.pm.LauncherApps.ShortcutQuery#FLAG_MATCH_MANIFEST}
 */

public android.content.pm.LauncherApps.ShortcutQuery setQueryFlags(int queryFlags) { throw new RuntimeException("Stub!"); }

/**
 * Requests "key" fields only.  See {@link ShortcutInfo#hasKeyFieldsOnly()}'s javadoc to
 * see which fields fields "key".
 * This allows quicker access to shortcut information in order to
 * determine whether the caller's in-memory cache needs to be updated.
 *
 * <p>Typically, launcher applications cache all or most shortcut information
 * in memory in order to show shortcuts without a delay.
 *
 * When a given launcher application wants to update its cache, such as when its process
 * restarts, it can fetch shortcut information with this flag.
 * The application can then check {@link ShortcutInfo#getLastChangedTimestamp()} for each
 * shortcut, fetching a shortcut's non-key information only if that shortcut has been
 * updated.
 *
 * @see ShortcutManager
 */

public static final int FLAG_GET_KEY_FIELDS_ONLY = 4; // 0x4

/**
 * Include dynamic shortcuts in the result.
 */

public static final int FLAG_MATCH_DYNAMIC = 1; // 0x1

/**
 * Include manifest shortcuts in the result.
 */

public static final int FLAG_MATCH_MANIFEST = 8; // 0x8

/**
 * Include pinned shortcuts in the result.
 *
 * <p>If you are the selected assistant app, and wishes to fetch all shortcuts that the
 * user owns on the launcher (or by other launchers, in case the user has multiple), use
 * {@link #FLAG_MATCH_PINNED_BY_ANY_LAUNCHER} instead.
 *
 * <p>If you're a regular launcher app, there's no way to get shortcuts pinned by other
 * launchers, and {@link #FLAG_MATCH_PINNED_BY_ANY_LAUNCHER} will be ignored. So use this
 * flag to get own pinned shortcuts.
 */

public static final int FLAG_MATCH_PINNED = 2; // 0x2

/**
 * Include all pinned shortcuts by any launchers, not just by the caller,
 * in the result.
 *
 * <p>The caller must be the selected assistant app to use this flag, or have the system
 * {@code ACCESS_SHORTCUTS} permission.
 *
 * <p>If you are the selected assistant app, and wishes to fetch all shortcuts that the
 * user owns on the launcher (or by other launchers, in case the user has multiple), use
 * {@link #FLAG_MATCH_PINNED_BY_ANY_LAUNCHER} instead.
 *
 * <p>If you're a regular launcher app (or any app that's not the selected assistant app)
 * then this flag will be ignored.
 */

public static final int FLAG_MATCH_PINNED_BY_ANY_LAUNCHER = 1024; // 0x400
}

}

