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

package android.content.pm;

import android.os.Bundle;
import android.content.Intent;
import android.os.PersistableBundle;
import android.content.res.Resources;
import android.graphics.Bitmap;
import java.util.Set;
import android.os.UserHandle;
import android.graphics.drawable.Icon;
import android.content.pm.LauncherApps.ShortcutQuery;
import java.util.List;
import android.content.Context;
import android.app.TaskStackBuilder;

/**
 * Represents a shortcut that can be published via {@link ShortcutManager}.
 *
 * @see ShortcutManager
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ShortcutInfo implements android.os.Parcelable {

ShortcutInfo(android.content.pm.ShortcutInfo.Builder b) { throw new RuntimeException("Stub!"); }

/**
 * Returns the ID of a shortcut.
 *
 * <p>Shortcut IDs are unique within each publisher app and must be stable across
 * devices so that shortcuts will still be valid when restored on a different device.
 * See {@link ShortcutManager} for details.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Return the package name of the publisher app.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getPackage() { throw new RuntimeException("Stub!"); }

/**
 * Return the target activity.
 *
 * <p>This has nothing to do with the activity that this shortcut will launch.
 * Launcher apps should show the launcher icon for the returned activity alongside
 * this shortcut.
 *
 * @see Builder#setActivity

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.content.ComponentName getActivity() { throw new RuntimeException("Stub!"); }

/**
 * Return the short description of a shortcut.
 *
 * @see Builder#setShortLabel(CharSequence)

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getShortLabel() { throw new RuntimeException("Stub!"); }

/**
 * Return the long description of a shortcut.
 *
 * @see Builder#setLongLabel(CharSequence)

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getLongLabel() { throw new RuntimeException("Stub!"); }

/**
 * Return the message that should be shown when the user attempts to start a shortcut
 * that is disabled.
 *
 * @see Builder#setDisabledMessage(CharSequence)

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getDisabledMessage() { throw new RuntimeException("Stub!"); }

/**
 * Returns why a shortcut has been disabled.

 * @return Value is {@link android.content.pm.ShortcutInfo#DISABLED_REASON_NOT_DISABLED}, {@link android.content.pm.ShortcutInfo#DISABLED_REASON_BY_APP}, {@link android.content.pm.ShortcutInfo#DISABLED_REASON_APP_CHANGED}, {@link android.content.pm.ShortcutInfo#DISABLED_REASON_UNKNOWN}, {@link android.content.pm.ShortcutInfo#DISABLED_REASON_VERSION_LOWER}, {@link android.content.pm.ShortcutInfo#DISABLED_REASON_BACKUP_NOT_SUPPORTED}, {@link android.content.pm.ShortcutInfo#DISABLED_REASON_SIGNATURE_MISMATCH}, or {@link android.content.pm.ShortcutInfo#DISABLED_REASON_OTHER_RESTORE_ISSUE}
 */

public int getDisabledReason() { throw new RuntimeException("Stub!"); }

/**
 * Return the shortcut's categories.
 *
 * @see Builder#setCategories(Set)

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.util.Set<java.lang.String> getCategories() { throw new RuntimeException("Stub!"); }

/**
 * Returns the intent that is executed when the user selects this shortcut.
 * If setIntents() was used, then return the last intent in the array.
 *
 * <p>Launcher apps <b>cannot</b> see the intent.  If a {@link ShortcutInfo} is
 * obtained via {@link LauncherApps}, then this method will always return null.
 * Launchers can only start a shortcut intent with {@link LauncherApps#startShortcut}.
 *
 * @see Builder#setIntent(Intent)
 */

@androidx.annotation.RecentlyNullable public android.content.Intent getIntent() { throw new RuntimeException("Stub!"); }

/**
 * Return the intent set with {@link Builder#setIntents(Intent[])}.
 *
 * <p>Launcher apps <b>cannot</b> see the intents.  If a {@link ShortcutInfo} is
 * obtained via {@link LauncherApps}, then this method will always return null.
 * Launchers can only start a shortcut intent with {@link LauncherApps#startShortcut}.
 *
 * @see Builder#setIntents(Intent[])
 */

@androidx.annotation.RecentlyNullable public android.content.Intent[] getIntents() { throw new RuntimeException("Stub!"); }

/**
 * "Rank" of a shortcut, which is a non-negative, sequential value that's unique for each
 * {@link #getActivity} for each of the two types of shortcuts (static and dynamic).
 *
 * <p>Because static shortcuts and dynamic shortcuts have overlapping ranks,
 * when a launcher app shows shortcuts for an activity, it should first show
 * the static shortcuts, followed by the dynamic shortcuts.  Within each of those categories,
 * shortcuts should be sorted by rank in ascending order.
 *
 * <p><em>Floating shortcuts</em>, or shortcuts that are neither static nor dynamic, will all
 * have rank 0, because they aren't sorted.
 *
 * See the {@link ShortcutManager}'s class javadoc for details.
 *
 * @see Builder#setRank(int)
 */

public int getRank() { throw new RuntimeException("Stub!"); }

/**
 * Extras that the app can set for any purpose.
 *
 * @see Builder#setExtras(PersistableBundle)

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.PersistableBundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * {@link UserHandle} on which the publisher created this shortcut.
 */

public android.os.UserHandle getUserHandle() { throw new RuntimeException("Stub!"); }

/**
 * Last time when any of the fields was updated.
 */

public long getLastChangedTimestamp() { throw new RuntimeException("Stub!"); }

/** Return whether a shortcut is dynamic. */

public boolean isDynamic() { throw new RuntimeException("Stub!"); }

/** Return whether a shortcut is pinned. */

public boolean isPinned() { throw new RuntimeException("Stub!"); }

/**
 * Return whether a shortcut is static; that is, whether a shortcut is
 * published from AndroidManifest.xml.  If {@code true}, the shortcut is
 * also {@link #isImmutable()}.
 *
 * <p>When an app is upgraded and a shortcut is no longer published from AndroidManifest.xml,
 * this will be set to {@code false}.  If the shortcut is not pinned, then it'll disappear.
 * However, if it's pinned, it will still be visible, {@link #isEnabled()} will be
 * {@code false} and {@link #isImmutable()} will be {@code true}.
 */

public boolean isDeclaredInManifest() { throw new RuntimeException("Stub!"); }

/**
 * Return if a shortcut is immutable, in which case it cannot be modified with any of
 * {@link ShortcutManager} APIs.
 *
 * <p>All static shortcuts are immutable.  When a static shortcut is pinned and is then
 * disabled because it doesn't appear in AndroidManifest.xml for a newer version of the
 * app, {@link #isDeclaredInManifest()} returns {@code false}, but the shortcut
 * is still immutable.
 *
 * <p>All shortcuts originally published via the {@link ShortcutManager} APIs
 * are all mutable.
 */

public boolean isImmutable() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code false} if a shortcut is disabled with
 * {@link ShortcutManager#disableShortcuts}.
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Return whether a shortcut only contains "key" information only or not.  If true, only the
 * following fields are available.
 * <ul>
 *     <li>{@link #getId()}
 *     <li>{@link #getPackage()}
 *     <li>{@link #getActivity()}
 *     <li>{@link #getLastChangedTimestamp()}
 *     <li>{@link #isDynamic()}
 *     <li>{@link #isPinned()}
 *     <li>{@link #isDeclaredInManifest()}
 *     <li>{@link #isImmutable()}
 *     <li>{@link #isEnabled()}
 *     <li>{@link #getUserHandle()}
 * </ul>
 *
 * <p>For performance reasons, shortcuts passed to
 * {@link LauncherApps.Callback#onShortcutsChanged(String, List, UserHandle)} as well as those
 * returned from {@link LauncherApps#getShortcuts(ShortcutQuery, UserHandle)}
 * while using the {@link ShortcutQuery#FLAG_GET_KEY_FIELDS_ONLY} option contain only key
 * information.
 */

public boolean hasKeyFieldsOnly() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Return a string representation, intended for logging.  Some fields will be retracted.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.ShortcutInfo> CREATOR;
static { CREATOR = null; }

/**
 * Shortcut has been disabled due to changes to the publisher app. (e.g. a manifest shortcut
 * no longer exists.)
 */

public static final int DISABLED_REASON_APP_CHANGED = 2; // 0x2

/**
 * Shortcut has not been restored because the publisher app does not support backup and restore.
 */

public static final int DISABLED_REASON_BACKUP_NOT_SUPPORTED = 101; // 0x65

/**
 * Shortcut has been disabled by the publisher app with the
 * {@link ShortcutManager#disableShortcuts(List)} API.
 */

public static final int DISABLED_REASON_BY_APP = 1; // 0x1

/**
 * Shortcut is not disabled.
 */

public static final int DISABLED_REASON_NOT_DISABLED = 0; // 0x0

/**
 * Shortcut has not been restored for unknown reason.
 */

public static final int DISABLED_REASON_OTHER_RESTORE_ISSUE = 103; // 0x67

/**
 * Shortcut has not been restored because the publisher app's signature has changed.
 */

public static final int DISABLED_REASON_SIGNATURE_MISMATCH = 102; // 0x66

/**
 * Shortcut is disabled for an unknown reason.
 */

public static final int DISABLED_REASON_UNKNOWN = 3; // 0x3

/**
 * Shortcut has been restored from the previous device, but the publisher app on the current
 * device is of a lower version. The shortcut will not be usable until the app is upgraded to
 * the same version or higher.
 */

public static final int DISABLED_REASON_VERSION_LOWER = 100; // 0x64

/**
 * Shortcut category for messaging related actions, such as chat.
 */

public static final java.lang.String SHORTCUT_CATEGORY_CONVERSATION = "android.shortcut.conversation";
/**
 * Builder class for {@link ShortcutInfo} objects.
 *
 * @see ShortcutManager
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Constructor.
 *
 * @param context Client context.
 * @param id ID of the shortcut.
 */

public Builder(android.content.Context context, java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Sets the target activity.  A shortcut will be shown along with this activity's icon
 * on the launcher.
 *
 * When selecting a target activity, keep the following in mind:
 * <ul>
 * <li>All dynamic shortcuts must have a target activity.  When a shortcut with no target
 * activity is published using
 * {@link ShortcutManager#addDynamicShortcuts(List)} or
 * {@link ShortcutManager#setDynamicShortcuts(List)},
 * the first main activity defined in the app's <code>AndroidManifest.xml</code>
 * file is used.
 *
 * <li>Only "main" activities&mdash;ones that define the {@link Intent#ACTION_MAIN}
 * and {@link Intent#CATEGORY_LAUNCHER} intent filters&mdash;can be target
 * activities.
 *
 * <li>By default, the first main activity defined in the app's manifest is
 * the target activity.
 *
 * <li>A target activity must belong to the publisher app.
 * </ul>
 *
 * @see ShortcutInfo#getActivity()
 
 * @param activity This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.ShortcutInfo.Builder setActivity(@androidx.annotation.RecentlyNonNull android.content.ComponentName activity) { throw new RuntimeException("Stub!"); }

/**
 * Sets an icon of a shortcut.
 *
 * <p>Icons are not available on {@link ShortcutInfo} instances
 * returned by {@link ShortcutManager} or {@link LauncherApps}.  The default launcher
 * app can use {@link LauncherApps#getShortcutIconDrawable(ShortcutInfo, int)}
 * or {@link LauncherApps#getShortcutBadgedIconDrawable(ShortcutInfo, int)} to fetch
 * shortcut icons.
 *
 * <p>Tints set with {@link Icon#setTint} or {@link Icon#setTintList} are not supported
 * and will be ignored.
 *
 * <p>Only icons created with {@link Icon#createWithBitmap(Bitmap)},
 * {@link Icon#createWithAdaptiveBitmap(Bitmap)}
 * and {@link Icon#createWithResource} are supported.
 * Other types, such as URI-based icons, are not supported.
 *
 * @see LauncherApps#getShortcutIconDrawable(ShortcutInfo, int)
 * @see LauncherApps#getShortcutBadgedIconDrawable(ShortcutInfo, int)

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.ShortcutInfo.Builder setIcon(android.graphics.drawable.Icon icon) { throw new RuntimeException("Stub!"); }

/**
 * Sets the short title of a shortcut.
 *
 * <p>This is a mandatory field when publishing a new shortcut with
 * {@link ShortcutManager#addDynamicShortcuts(List)} or
 * {@link ShortcutManager#setDynamicShortcuts(List)}.
 *
 * <p>This field is intended to be a concise description of a shortcut.
 *
 * <p>The recommended maximum length is 10 characters.
 *
 * @see ShortcutInfo#getShortLabel()
 
 * @param shortLabel This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.ShortcutInfo.Builder setShortLabel(@androidx.annotation.RecentlyNonNull java.lang.CharSequence shortLabel) { throw new RuntimeException("Stub!"); }

/**
 * Sets the text of a shortcut.
 *
 * <p>This field is intended to be more descriptive than the shortcut title.  The launcher
 * shows this instead of the short title when it has enough space.
 *
 * <p>The recommend maximum length is 25 characters.
 *
 * @see ShortcutInfo#getLongLabel()
 
 * @param longLabel This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.ShortcutInfo.Builder setLongLabel(@androidx.annotation.RecentlyNonNull java.lang.CharSequence longLabel) { throw new RuntimeException("Stub!"); }

/**
 * Sets the message that should be shown when the user attempts to start a shortcut that
 * is disabled.
 *
 * @see ShortcutInfo#getDisabledMessage()
 
 * @param disabledMessage This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.ShortcutInfo.Builder setDisabledMessage(@androidx.annotation.RecentlyNonNull java.lang.CharSequence disabledMessage) { throw new RuntimeException("Stub!"); }

/**
 * Sets categories for a shortcut.  Launcher apps may use this information to
 * categorize shortcuts.
 *
 * @see #SHORTCUT_CATEGORY_CONVERSATION
 * @see ShortcutInfo#getCategories()

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.ShortcutInfo.Builder setCategories(java.util.Set<java.lang.String> categories) { throw new RuntimeException("Stub!"); }

/**
 * Sets the intent of a shortcut.  Alternatively, {@link #setIntents(Intent[])} can be used
 * to launch an activity with other activities in the back stack.
 *
 * <p>This is a mandatory field when publishing a new shortcut with
 * {@link ShortcutManager#addDynamicShortcuts(List)} or
 * {@link ShortcutManager#setDynamicShortcuts(List)}.
 *
 * <p>A shortcut can launch any intent that the publisher app has permission to
 * launch.  For example, a shortcut can launch an unexported activity within the publisher
 * app.  A shortcut intent doesn't have to point at the target activity.
 *
 * <p>The given {@code intent} can contain extras, but these extras must contain values
 * of primitive types in order for the system to persist these values.
 *
 * @see ShortcutInfo#getIntent()
 * @see #setIntents(Intent[])
 
 * @param intent This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.ShortcutInfo.Builder setIntent(@androidx.annotation.RecentlyNonNull android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Sets multiple intents instead of a single intent, in order to launch an activity with
 * other activities in back stack.  Use {@link TaskStackBuilder} to build intents. The
 * last element in the list represents the only intent that doesn't place an activity on
 * the back stack.
 * See the {@link ShortcutManager} javadoc for details.
 *
 * @see Builder#setIntent(Intent)
 * @see ShortcutInfo#getIntents()
 * @see Context#startActivities(Intent[])
 * @see TaskStackBuilder
 
 * @param intents This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.ShortcutInfo.Builder setIntents(@androidx.annotation.RecentlyNonNull android.content.Intent[] intents) { throw new RuntimeException("Stub!"); }

/**
 * "Rank" of a shortcut, which is a non-negative value that's used by the launcher app
 * to sort shortcuts.
 *
 * See {@link ShortcutInfo#getRank()} for details.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.ShortcutInfo.Builder setRank(int rank) { throw new RuntimeException("Stub!"); }

/**
 * Extras that the app can set for any purpose.
 *
 * <p>Apps can store arbitrary shortcut metadata in extras and retrieve the
 * metadata later using {@link ShortcutInfo#getExtras()}.
 
 * @param extras This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.ShortcutInfo.Builder setExtras(@androidx.annotation.RecentlyNonNull android.os.PersistableBundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link ShortcutInfo} instance.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.pm.ShortcutInfo build() { throw new RuntimeException("Stub!"); }
}

}

