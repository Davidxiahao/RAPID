/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.content.pm.ResolveInfo;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.content.ComponentName;
import android.os.PersistableBundle;

/**
 * This class is used to specify meta information of a device administrator
 * component.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DeviceAdminInfo implements android.os.Parcelable {

/**
 * Constructor.
 *
 * @param context The Context in which we are parsing the device admin.
 * @param resolveInfo The ResolveInfo returned from the package manager about
 * this device admin's component.
 */

public DeviceAdminInfo(android.content.Context context, android.content.pm.ResolveInfo resolveInfo) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Return the .apk package that implements this device admin.
 */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Return the class name of the receiver component that implements
 * this device admin.
 */

public java.lang.String getReceiverName() { throw new RuntimeException("Stub!"); }

/**
 * Return the raw information about the receiver implementing this
 * device admin.  Do not modify the returned object.
 */

public android.content.pm.ActivityInfo getActivityInfo() { throw new RuntimeException("Stub!"); }

/**
 * Return the component of the receiver that implements this device admin.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.ComponentName getComponent() { throw new RuntimeException("Stub!"); }

/**
 * Load the user-displayed label for this device admin.
 *
 * @param pm Supply a PackageManager used to load the device admin's
 * resources.
 */

public java.lang.CharSequence loadLabel(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Load user-visible description associated with this device admin.
 *
 * @param pm Supply a PackageManager used to load the device admin's
 * resources.
 */

public java.lang.CharSequence loadDescription(android.content.pm.PackageManager pm) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Load the user-displayed icon for this device admin.
 *
 * @param pm Supply a PackageManager used to load the device admin's
 * resources.
 */

public android.graphics.drawable.Drawable loadIcon(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this device admin would like to be visible to the
 * user, even when it is not enabled.
 */

public boolean isVisible() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the device admin has requested that it be able to use
 * the given policy control.  The possible policy identifier inputs are:
 * {@link #USES_POLICY_LIMIT_PASSWORD}, {@link #USES_POLICY_WATCH_LOGIN},
 * {@link #USES_POLICY_RESET_PASSWORD}, {@link #USES_POLICY_FORCE_LOCK},
 * {@link #USES_POLICY_WIPE_DATA},
 * {@link #USES_POLICY_EXPIRE_PASSWORD}, {@link #USES_ENCRYPTED_STORAGE},
 * {@link #USES_POLICY_DISABLE_CAMERA}.
 */

public boolean usesPolicy(int policyIdent) { throw new RuntimeException("Stub!"); }

/**
 * Return the XML tag name for the given policy identifier.  Valid identifiers
 * are as per {@link #usesPolicy(int)}.  If the given identifier is not
 * known, null is returned.
 */

public java.lang.String getTagForPolicy(int policyIdent) { throw new RuntimeException("Stub!"); }

/**
 * Return true if this administrator can be a target in an ownership transfer.
 */

public boolean supportsTransferOwnership() { throw new RuntimeException("Stub!"); }

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link Parcel}.
 *
 * @param dest The {@link Parcel} to be written.
 * @param flags The flags used for parceling.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 */

public static final android.os.Parcelable.Creator<android.app.admin.DeviceAdminInfo> CREATOR;
static { CREATOR = null; }

/**
 * A type of policy that this device admin can use: require encryption of stored data.
 *
 * <p>To control this policy, the device admin must have a "encrypted-storage"
 * tag in the "uses-policies" section of its meta-data.
 */

public static final int USES_ENCRYPTED_STORAGE = 7; // 0x7

/**
 * A type of policy that this device admin can use: disables use of all device cameras.
 *
 * <p>To control this policy, the device admin must have a "disable-camera"
 * tag in the "uses-policies" section of its meta-data.
 *
 * <p>This policy is deprecated for use by a device admin.  In future releases, it will
 * only be possible for a device owner or profile owner to disable use of the camera.
 */

public static final int USES_POLICY_DISABLE_CAMERA = 8; // 0x8

/**
 * A type of policy that this device admin can use: disables use of keyguard features.
 *
 * <p>To control this policy, the device admin must have a "disable-keyguard-features"
 * tag in the "uses-policies" section of its meta-data.
 *
 * <p>This policy is deprecated for use by a device admin.  In future releases, it will
 * only be possible for a device owner or profile owner to disable use of keyguard
 * features.
 */

public static final int USES_POLICY_DISABLE_KEYGUARD_FEATURES = 9; // 0x9

/**
 * A type of policy that this device admin can use: force the user to
 * change their password after an administrator-defined time limit.
 *
 * <p>To control this policy, the device admin must have an "expire-password"
 * tag in the "uses-policies" section of its meta-data.
 *
 * <p>This policy is deprecated for use by a device admin.  In future releases, it will
 * only be possible for a device owner or profile owner to enforce password expiry.
 */

public static final int USES_POLICY_EXPIRE_PASSWORD = 6; // 0x6

/**
 * A type of policy that this device admin can use: able to force the device
 * to lock via{@link DevicePolicyManager#lockNow} or limit the
 * maximum lock timeout for the device via
 * {@link DevicePolicyManager#setMaximumTimeToLock}.
 *
 * <p>To control this policy, the device admin must have a "force-lock"
 * tag in the "uses-policies" section of its meta-data.
 */

public static final int USES_POLICY_FORCE_LOCK = 3; // 0x3

/**
 * A type of policy that this device admin can use: limit the passwords
 * that the user can select, via {@link DevicePolicyManager#setPasswordQuality}
 * and {@link DevicePolicyManager#setPasswordMinimumLength}.
 *
 * <p>To control this policy, the device admin must have a "limit-password"
 * tag in the "uses-policies" section of its meta-data.
 *
 * <p>This policy is deprecated for use by a device admin.  In future releases, it will
 * only be possible for a device owner or profile owner to enforce constraints on user
 * passwords.
 */

public static final int USES_POLICY_LIMIT_PASSWORD = 0; // 0x0

/**
 * A type of policy that this device admin can use: able to reset the
 * user's password via
 * {@link DevicePolicyManager#resetPassword}.
 *
 * <p>To control this policy, the device admin must have a "reset-password"
 * tag in the "uses-policies" section of its meta-data.
 */

public static final int USES_POLICY_RESET_PASSWORD = 2; // 0x2

/**
 * A type of policy that this device admin can use: able to watch login
 * attempts from the user, via {@link DeviceAdminReceiver#ACTION_PASSWORD_FAILED},
 * {@link DeviceAdminReceiver#ACTION_PASSWORD_SUCCEEDED}, and
 * {@link DevicePolicyManager#getCurrentFailedPasswordAttempts}.
 *
 * <p>To control this policy, the device admin must have a "watch-login"
 * tag in the "uses-policies" section of its meta-data.
 */

public static final int USES_POLICY_WATCH_LOGIN = 1; // 0x1

/**
 * A type of policy that this device admin can use: able to factory
 * reset the device, erasing all of the user's data, via
 * {@link DevicePolicyManager#wipeData}.
 *
 * <p>To control this policy, the device admin must have a "wipe-data"
 * tag in the "uses-policies" section of its meta-data.
 */

public static final int USES_POLICY_WIPE_DATA = 4; // 0x4
}

