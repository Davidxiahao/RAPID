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

import android.os.UserHandle;
import android.content.ComponentName;
import android.os.UserManager;
import android.util.DisplayMetrics;

/**
 * A representation of an activity that can belong to this user or a managed
 * profile associated with this user. It can be used to query the label, icon
 * and badged icon for the activity.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LauncherActivityInfo {

LauncherActivityInfo(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns the component name of this activity.
 *
 * @return ComponentName of the activity
 */

public android.content.ComponentName getComponentName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the user handle of the user profile that this activity belongs to. In order to
 * persist the identity of the profile, do not store the UserHandle. Instead retrieve its
 * serial number from UserManager. You can convert the serial number back to a UserHandle
 * for later use.
 *
 * @see UserManager#getSerialNumberForUser(UserHandle)
 * @see UserManager#getUserForSerialNumber(long)
 *
 * @return The UserHandle of the profile.
 */

public android.os.UserHandle getUser() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the label for the activity.
 *
 * @return The label for the activity.
 */

public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Returns the icon for this activity, without any badging for the profile.
 * @param density The preferred density of the icon, zero for default density. Use
 * density DPI values from {@link DisplayMetrics}.
 * @see #getBadgedIcon(int)
 * @see DisplayMetrics
 * @return The drawable associated with the activity.
 */

public android.graphics.drawable.Drawable getIcon(int density) { throw new RuntimeException("Stub!"); }

/**
 * Returns the application info for the appliction this activity belongs to.
 * @return
 */

public android.content.pm.ApplicationInfo getApplicationInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time at which the package was first installed.
 *
 * @return The time of installation of the package, in milliseconds.
 */

public long getFirstInstallTime() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name for the acitivty from  android:name in the manifest.
 * @return the name from android:name for the acitivity.
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the activity icon with badging appropriate for the profile.
 * @param density Optional density for the icon, or 0 to use the default density. Use
 * {@link DisplayMetrics} for DPI values.
 * @see DisplayMetrics
 * @return A badged icon for the activity.
 */

public android.graphics.drawable.Drawable getBadgedIcon(int density) { throw new RuntimeException("Stub!"); }
}

