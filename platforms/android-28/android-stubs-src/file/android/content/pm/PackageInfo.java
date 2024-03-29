/*
 * Copyright (C) 2007 The Android Open Source Project
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


/**
 * Overall information about the contents of a package.  This corresponds
 * to all of the information collected from AndroidManifest.xml.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PackageInfo implements android.os.Parcelable {

public PackageInfo() { throw new RuntimeException("Stub!"); }

/**
 * Return {@link android.R.styleable#AndroidManifest_versionCode versionCode} and
 * {@link android.R.styleable#AndroidManifest_versionCodeMajor versionCodeMajor} combined
 * together as a single long value.  The
 * {@link android.R.styleable#AndroidManifest_versionCodeMajor versionCodeMajor} is placed in
 * the upper 32 bits.
 */

public long getLongVersionCode() { throw new RuntimeException("Stub!"); }

/**
 * Set the full version code in this PackageInfo, updating {@link #versionCode}
 * with the lower bits.
 * @see #getLongVersionCode()
 */

public void setLongVersionCode(long longVersionCode) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.PackageInfo> CREATOR;
static { CREATOR = null; }

/**
 * Constant corresponding to <code>auto</code> in the
 * {@link android.R.attr#installLocation} attribute.
 */

public static final int INSTALL_LOCATION_AUTO = 0; // 0x0

/**
 * Constant corresponding to <code>internalOnly</code> in the
 * {@link android.R.attr#installLocation} attribute.
 */

public static final int INSTALL_LOCATION_INTERNAL_ONLY = 1; // 0x1

/**
 * Constant corresponding to <code>preferExternal</code> in the
 * {@link android.R.attr#installLocation} attribute.
 */

public static final int INSTALL_LOCATION_PREFER_EXTERNAL = 2; // 0x2

/**
 * Flag for {@link #requestedPermissionsFlags}: the requested permission
 * is currently granted to the application.
 */

public static final int REQUESTED_PERMISSION_GRANTED = 2; // 0x2

/**
 * Array of all {@link android.R.styleable#AndroidManifestActivity
 * &lt;activity&gt;} tags included under &lt;application&gt;,
 * or null if there were none.  This is only filled in if the flag
 * {@link PackageManager#GET_ACTIVITIES} was set.
 */

public android.content.pm.ActivityInfo[] activities;

/**
 * Information collected from the &lt;application&gt; tag, or null if
 * there was none.
 */

public android.content.pm.ApplicationInfo applicationInfo;

/**
 * The revision number of the base APK for this package, as specified by the
 * &lt;manifest&gt; tag's
 * {@link android.R.styleable#AndroidManifest_revisionCode revisionCode}
 * attribute.
 */

public int baseRevisionCode;

/**
 * Application specified preferred configuration
 * {@link android.R.styleable#AndroidManifestUsesConfiguration
 * &lt;uses-configuration&gt;} tags included under &lt;manifest&gt;,
 * or null if there were none. This is only filled in if the flag
 * {@link PackageManager#GET_CONFIGURATIONS} was set.
 */

public android.content.pm.ConfigurationInfo[] configPreferences;

/**
 * Groups of features that this application has requested.
 * Each group contains a set of features that are required.
 * A device must match the features listed in {@link #reqFeatures} and one
 * or more FeatureGroups in order to have satisfied the feature requirement.
 *
 * @see FeatureInfo#FLAG_REQUIRED
 */

public android.content.pm.FeatureGroupInfo[] featureGroups;

/**
 * The time at which the app was first installed.  Units are as
 * per {@link System#currentTimeMillis()}.
 */

public long firstInstallTime;

/**
 * All kernel group-IDs that have been assigned to this package.
 * This is only filled in if the flag {@link PackageManager#GET_GIDS} was set.
 */

public int[] gids;

/**
 * The install location requested by the package. From the
 * {@link android.R.attr#installLocation} attribute, one of
 * {@link #INSTALL_LOCATION_AUTO}, {@link #INSTALL_LOCATION_INTERNAL_ONLY},
 * {@link #INSTALL_LOCATION_PREFER_EXTERNAL}
 */

public int installLocation = 1; // 0x1

/**
 * Array of all {@link android.R.styleable#AndroidManifestInstrumentation
 * &lt;instrumentation&gt;} tags included under &lt;manifest&gt;,
 * or null if there were none.  This is only filled in if the flag
 * {@link PackageManager#GET_INSTRUMENTATION} was set.
 */

public android.content.pm.InstrumentationInfo[] instrumentation;

/**
 * The time at which the app was last updated.  Units are as
 * per {@link System#currentTimeMillis()}.
 */

public long lastUpdateTime;

/**
 * The name of this package.  From the &lt;manifest&gt; tag's "name"
 * attribute.
 */

public java.lang.String packageName;

/**
 * Array of all {@link android.R.styleable#AndroidManifestPermission
 * &lt;permission&gt;} tags included under &lt;manifest&gt;,
 * or null if there were none.  This is only filled in if the flag
 * {@link PackageManager#GET_PERMISSIONS} was set.
 */

public android.content.pm.PermissionInfo[] permissions;

/**
 * Array of all {@link android.R.styleable#AndroidManifestProvider
 * &lt;provider&gt;} tags included under &lt;application&gt;,
 * or null if there were none.  This is only filled in if the flag
 * {@link PackageManager#GET_PROVIDERS} was set.
 */

public android.content.pm.ProviderInfo[] providers;

/**
 * Array of all {@link android.R.styleable#AndroidManifestReceiver
 * &lt;receiver&gt;} tags included under &lt;application&gt;,
 * or null if there were none.  This is only filled in if the flag
 * {@link PackageManager#GET_RECEIVERS} was set.
 */

public android.content.pm.ActivityInfo[] receivers;

/**
 * Features that this application has requested.
 *
 * @see FeatureInfo#FLAG_REQUIRED
 */

public android.content.pm.FeatureInfo[] reqFeatures;

/**
 * Array of all {@link android.R.styleable#AndroidManifestUsesPermission
 * &lt;uses-permission&gt;} tags included under &lt;manifest&gt;,
 * or null if there were none.  This is only filled in if the flag
 * {@link PackageManager#GET_PERMISSIONS} was set.  This list includes
 * all permissions requested, even those that were not granted or known
 * by the system at install time.
 */

public java.lang.String[] requestedPermissions;

/**
 * Array of flags of all {@link android.R.styleable#AndroidManifestUsesPermission
 * &lt;uses-permission&gt;} tags included under &lt;manifest&gt;,
 * or null if there were none.  This is only filled in if the flag
 * {@link PackageManager#GET_PERMISSIONS} was set.  Each value matches
 * the corresponding entry in {@link #requestedPermissions}, and will have
 * the flag {@link #REQUESTED_PERMISSION_GRANTED} set as appropriate.
 */

public int[] requestedPermissionsFlags;

/**
 * Array of all {@link android.R.styleable#AndroidManifestService
 * &lt;service&gt;} tags included under &lt;application&gt;,
 * or null if there were none.  This is only filled in if the flag
 * {@link PackageManager#GET_SERVICES} was set.
 */

public android.content.pm.ServiceInfo[] services;

/**
 * The shared user ID name of this package, as specified by the &lt;manifest&gt;
 * tag's {@link android.R.styleable#AndroidManifest_sharedUserId sharedUserId}
 * attribute.
 */

public java.lang.String sharedUserId;

/**
 * The shared user ID label of this package, as specified by the &lt;manifest&gt;
 * tag's {@link android.R.styleable#AndroidManifest_sharedUserLabel sharedUserLabel}
 * attribute.
 */

public int sharedUserLabel;

/**
 * Array of all signatures read from the package file. This is only filled
 * in if the flag {@link PackageManager#GET_SIGNATURES} was set. A package
 * must be singed with at least one certificate which is at position zero.
 * The package can be signed with additional certificates which appear as
 * subsequent entries.
 *
 * <strong>Note:</strong> Signature ordering is not guaranteed to be
 * stable which means that a package signed with certificates A and B is
 * equivalent to being signed with certificates B and A. This means that
 * in case multiple signatures are reported you cannot assume the one at
 * the first position to be the same across updates.
 *
 * <strong>Deprecated</strong> This has been replaced by the
 * {@link PackageInfo#signingInfo} field, which takes into
 * account signing certificate rotation.  For backwards compatibility in
 * the event of signing certificate rotation, this will return the oldest
 * reported signing certificate, so that an application will appear to
 * callers as though no rotation occurred.
 *
 * @deprecated use {@code signingInfo} instead
 */

@Deprecated public android.content.pm.Signature[] signatures;

/**
 * Signing information read from the package file, potentially
 * including past signing certificates no longer used after signing
 * certificate rotation.  This is only filled in if
 * the flag {@link PackageManager#GET_SIGNING_CERTIFICATES} was set.
 *
 * Use this field instead of the deprecated {@code signatures} field.
 * See {@link SigningInfo} for more information on its contents.
 */

public android.content.pm.SigningInfo signingInfo;

/**
 * The names of any installed split APKs for this package.
 */

public java.lang.String[] splitNames;

/**
 * The revision number of any split APKs for this package, as specified by
 * the &lt;manifest&gt; tag's
 * {@link android.R.styleable#AndroidManifest_revisionCode revisionCode}
 * attribute. Indexes are a 1:1 mapping against {@link #splitNames}.
 */

public int[] splitRevisionCodes;

/**
 * @deprecated Use {@link #getLongVersionCode()} instead, which includes both
 * this and the additional
 * {@link android.R.styleable#AndroidManifest_versionCodeMajor versionCodeMajor} attribute.
 * The version number of this package, as specified by the &lt;manifest&gt;
 * tag's {@link android.R.styleable#AndroidManifest_versionCode versionCode}
 * attribute.
 * @see #getLongVersionCode()
 */

@Deprecated public int versionCode;

/**
 * The version name of this package, as specified by the &lt;manifest&gt;
 * tag's {@link android.R.styleable#AndroidManifest_versionName versionName}
 * attribute.
 */

public java.lang.String versionName;
}

