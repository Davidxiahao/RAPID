/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.os.storage;

import android.os.Environment;
import android.content.Intent;
import android.content.Context;
import android.provider.DocumentsContract;
import android.net.Uri;
import java.io.File;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Information about a shared/external storage volume for a specific user.
 *
 * <p>
 * A device always has one (and one only) primary storage volume, but it could have extra volumes,
 * like SD cards and USB drives. This object represents the logical view of a storage
 * volume for a specific user: different users might have different views for the same physical
 * volume (for example, if the volume is a built-in emulated storage).
 *
 * <p>
 * The storage volume is not necessarily mounted, applications should use {@link #getState()} to
 * verify its state.
 *
 * <p>
 * Applications willing to read or write to this storage volume needs to get a permission from the
 * user first, which can be achieved in the following ways:
 *
 * <ul>
 * <li>To get access to standard directories (like the {@link Environment#DIRECTORY_PICTURES}), they
 * can use the {@link #createAccessIntent(String)}. This is the recommend way, since it provides a
 * simpler API and narrows the access to the given directory (and its descendants).
 * <li>To get access to any directory (and its descendants), they can use the Storage Acess
 * Framework APIs (such as {@link Intent#ACTION_OPEN_DOCUMENT} and
 * {@link Intent#ACTION_OPEN_DOCUMENT_TREE}, although these APIs do not guarantee the user will
 * select this specific volume.
 * <li>To get read and write access to the primary storage volume, applications can declare the
 * {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} and
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} permissions respectively, with the
 * latter including the former. This approach is discouraged, since users may be hesitant to grant
 * broad access to all files contained on a storage device.
 * </ul>
 *
 * <p>It can be obtained through {@link StorageManager#getStorageVolumes()} and
 * {@link StorageManager#getPrimaryStorageVolume()} and also as an extra in some broadcasts
 * (see {@link #EXTRA_STORAGE_VOLUME}).
 *
 * <p>
 * See {@link Environment#getExternalStorageDirectory()} for more info about shared/external
 * storage semantics.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StorageVolume implements android.os.Parcelable {

StorageVolume(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Returns a user-visible description of the volume.
 *
 * @return the volume description
 */

public java.lang.String getDescription(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the volume is the primary shared/external storage, which is the volume
 * backed by {@link Environment#getExternalStorageDirectory()}.
 */

public boolean isPrimary() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the volume is removable.
 *
 * @return is removable
 */

public boolean isRemovable() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the volume is emulated.
 *
 * @return is removable
 */

public boolean isEmulated() { throw new RuntimeException("Stub!"); }

/**
 * Gets the volume UUID, if any.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getUuid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current state of the volume.
 *
 * @return one of {@link Environment#MEDIA_UNKNOWN}, {@link Environment#MEDIA_REMOVED},
 *         {@link Environment#MEDIA_UNMOUNTED}, {@link Environment#MEDIA_CHECKING},
 *         {@link Environment#MEDIA_NOFS}, {@link Environment#MEDIA_MOUNTED},
 *         {@link Environment#MEDIA_MOUNTED_READ_ONLY}, {@link Environment#MEDIA_SHARED},
 *         {@link Environment#MEDIA_BAD_REMOVAL}, or {@link Environment#MEDIA_UNMOUNTABLE}.
 */

public java.lang.String getState() { throw new RuntimeException("Stub!"); }

/**
 * Builds an intent to give access to a standard storage directory or entire volume after
 * obtaining the user's approval.
 * <p>
 * When invoked, the system will ask the user to grant access to the requested directory (and
 * its descendants). The result of the request will be returned to the activity through the
 * {@code onActivityResult} method.
 * <p>
 * To gain access to descendants (child, grandchild, etc) documents, use
 * {@link DocumentsContract#buildDocumentUriUsingTree(Uri, String)}, or
 * {@link DocumentsContract#buildChildDocumentsUriUsingTree(Uri, String)} with the returned URI.
 * <p>
 * If your application only needs to store internal data, consider using
 * {@link Context#getExternalFilesDirs(String) Context.getExternalFilesDirs},
 * {@link Context#getExternalCacheDirs()}, or {@link Context#getExternalMediaDirs()}, which
 * require no permissions to read or write.
 * <p>
 * Access to the entire volume is only available for non-primary volumes (for the primary
 * volume, apps can use the {@link android.Manifest.permission#READ_EXTERNAL_STORAGE} and
 * {@link android.Manifest.permission#WRITE_EXTERNAL_STORAGE} permissions) and should be used
 * with caution, since users are more likely to deny access when asked for entire volume access
 * rather than specific directories.
 *
 * @param directoryName must be one of {@link Environment#DIRECTORY_MUSIC},
 *            {@link Environment#DIRECTORY_PODCASTS}, {@link Environment#DIRECTORY_RINGTONES},
 *            {@link Environment#DIRECTORY_ALARMS}, {@link Environment#DIRECTORY_NOTIFICATIONS},
 *            {@link Environment#DIRECTORY_PICTURES}, {@link Environment#DIRECTORY_MOVIES},
 *            {@link Environment#DIRECTORY_DOWNLOADS}, {@link Environment#DIRECTORY_DCIM}, or
 *            {@link Environment#DIRECTORY_DOCUMENTS}, or {@code null} to request access to the
 *            entire volume.
 * @return intent to request access, or {@code null} if the requested directory is invalid for
 *         that volume.
 * @see DocumentsContract
 */

@androidx.annotation.RecentlyNullable public android.content.Intent createAccessIntent(java.lang.String directoryName) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.os.storage.StorageVolume> CREATOR;
static { CREATOR = null; }

/**
 * Name of the {@link Parcelable} extra in the {@link Intent#ACTION_MEDIA_REMOVED},
 * {@link Intent#ACTION_MEDIA_UNMOUNTED}, {@link Intent#ACTION_MEDIA_CHECKING},
 * {@link Intent#ACTION_MEDIA_NOFS}, {@link Intent#ACTION_MEDIA_MOUNTED},
 * {@link Intent#ACTION_MEDIA_SHARED}, {@link Intent#ACTION_MEDIA_BAD_REMOVAL},
 * {@link Intent#ACTION_MEDIA_UNMOUNTABLE}, and {@link Intent#ACTION_MEDIA_EJECT} broadcast that
 * contains a {@link StorageVolume}.
 */

public static final java.lang.String EXTRA_STORAGE_VOLUME = "android.os.storage.extra.STORAGE_VOLUME";
}

