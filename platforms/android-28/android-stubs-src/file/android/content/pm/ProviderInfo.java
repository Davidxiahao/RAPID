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


/**
 * Holds information about a specific
 * {@link android.content.ContentProvider content provider}. This is returned by
 * {@link android.content.pm.PackageManager#resolveContentProvider(java.lang.String, int)
 * PackageManager.resolveContentProvider()}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ProviderInfo extends android.content.pm.ComponentInfo implements android.os.Parcelable {

public ProviderInfo() { throw new RuntimeException("Stub!"); }

public ProviderInfo(android.content.pm.ProviderInfo orig) { throw new RuntimeException("Stub!"); }

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int parcelableFlags) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.ProviderInfo> CREATOR;
static { CREATOR = null; }

/**
 * Bit in {@link #flags}: If set, a single instance of the provider will
 * run for all users on the device.  Set from the
 * {@link android.R.attr#singleUser} attribute.
 */

public static final int FLAG_SINGLE_USER = 1073741824; // 0x40000000

/** The name provider is published under content:// */

public java.lang.String authority;

/**
 * Options that have been set in the provider declaration in the
 * manifest.
 * These include: {@link #FLAG_SINGLE_USER}.
 */

public int flags = 0; // 0x0

/** If true, additional permissions to specific Uris in this content
 * provider can be granted, as per the
 * {@link android.R.styleable#AndroidManifestProvider_grantUriPermissions
 * grantUriPermissions} attribute.
 */

public boolean grantUriPermissions = false;

/** Used to control initialization order of single-process providers
 *  running in the same process.  Higher goes first. */

public int initOrder = 0; // 0x0

/**
 * Whether or not this provider is syncable.
 * @deprecated This flag is now being ignored. The current way to make a provider
 * syncable is to provide a SyncAdapter service for a given provider/account type.
 */

@Deprecated public boolean isSyncable = false;

/** If true, this content provider allows multiple instances of itself
 *  to run in different process.  If false, a single instances is always
 *  run in {@link #processName}. */

public boolean multiprocess = false;

/**
 * If non-null, these are path-specific permissions that are allowed for
 * accessing the provider.  Any permissions listed here will allow a
 * holding client to access the provider, and the provider will check
 * the URI it provides when making calls against the patterns here.
 */

public android.content.pm.PathPermission[] pathPermissions;

/** Optional permission required for read-only access this content
 * provider. */

public java.lang.String readPermission;

/**
 * If non-null, these are the patterns that are allowed for granting URI
 * permissions.  Any URI that does not match one of these patterns will not
 * allowed to be granted.  If null, all URIs are allowed.  The
 * {@link PackageManager#GET_URI_PERMISSION_PATTERNS
 * PackageManager.GET_URI_PERMISSION_PATTERNS} flag must be specified for
 * this field to be filled in.
 */

public android.os.PatternMatcher[] uriPermissionPatterns;

/** Optional permission required for read/write access this content
 * provider. */

public java.lang.String writePermission;
}

