/*
 * Copyright (C) 2008 The Android Open Source Project
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

import android.content.Context;
import android.os.Looper;
import java.util.List;
import java.util.UUID;
import java.io.IOException;
import android.os.Environment;
import java.io.FileDescriptor;
import java.io.File;
import android.content.pm.PackageManager;
import android.content.Intent;
import android.content.ContentResolver;
import android.os.Handler;
import android.os.ProxyFileDescriptorCallback;
import android.os.ParcelFileDescriptor;
import android.content.pm.ApplicationInfo;
import android.app.Activity;
import android.os.Binder;

/**
 * StorageManager is the interface to the systems storage service. The storage
 * manager handles storage-related items such as Opaque Binary Blobs (OBBs).
 * <p>
 * OBBs contain a filesystem that maybe be encrypted on disk and mounted
 * on-demand from an application. OBBs are a good way of providing large amounts
 * of binary assets without packaging them into APKs as they may be multiple
 * gigabytes in size. However, due to their size, they're most likely stored in
 * a shared storage pool accessible from all programs. The system does not
 * guarantee the security of the OBB file itself: if any program modifies the
 * OBB, there is no guarantee that a read from that OBB will produce the
 * expected output.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StorageManager {

StorageManager() { throw new RuntimeException("Stub!"); }

/**
 * Mount an Opaque Binary Blob (OBB) file. If a <code>key</code> is
 * specified, it is supplied to the mounting process to be used in any
 * encryption used in the OBB.
 * <p>
 * The OBB will remain mounted for as long as the StorageManager reference
 * is held by the application. As soon as this reference is lost, the OBBs
 * in use will be unmounted. The {@link OnObbStateChangeListener} registered
 * with this call will receive the success or failure of this operation.
 * <p>
 * <em>Note:</em> you can only mount OBB files for which the OBB tag on the
 * file matches a package ID that is owned by the calling program's UID.
 * That is, shared UID applications can attempt to mount any other
 * application's OBB that shares its UID.
 *
 * @param rawPath the path to the OBB file
 * @param key secret used to encrypt the OBB; may be <code>null</code> if no
 *            encryption was used on the OBB.
 * @param listener will receive the success or failure of the operation
 * @return whether the mount call was successfully queued or not
 */

public boolean mountObb(java.lang.String rawPath, java.lang.String key, android.os.storage.OnObbStateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Unmount an Opaque Binary Blob (OBB) file asynchronously. If the
 * <code>force</code> flag is true, it will kill any application needed to
 * unmount the given OBB (even the calling application).
 * <p>
 * The {@link OnObbStateChangeListener} registered with this call will
 * receive the success or failure of this operation.
 * <p>
 * <em>Note:</em> you can only mount OBB files for which the OBB tag on the
 * file matches a package ID that is owned by the calling program's UID.
 * That is, shared UID applications can obtain access to any other
 * application's OBB that shares its UID.
 * <p>
 *
 * @param rawPath path to the OBB file
 * @param force whether to kill any programs using this in order to unmount
 *            it
 * @param listener will receive the success or failure of the operation
 * @return whether the unmount call was successfully queued or not
 */

public boolean unmountObb(java.lang.String rawPath, boolean force, android.os.storage.OnObbStateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Check whether an Opaque Binary Blob (OBB) is mounted or not.
 *
 * @param rawPath path to OBB image
 * @return true if OBB is mounted; false if not mounted or on error
 */

public boolean isObbMounted(java.lang.String rawPath) { throw new RuntimeException("Stub!"); }

/**
 * Check the mounted path of an Opaque Binary Blob (OBB) file. This will
 * give you the path to where you can obtain access to the internals of the
 * OBB.
 *
 * @param rawPath path to OBB image
 * @return absolute path to mounted OBB image data or <code>null</code> if
 *         not mounted or exception encountered trying to read status
 */

public java.lang.String getMountedObbPath(java.lang.String rawPath) { throw new RuntimeException("Stub!"); }

/**
 * Return a UUID identifying the storage volume that hosts the given
 * filesystem path.
 * <p>
 * If this path is hosted by the default internal storage of the device at
 * {@link Environment#getDataDirectory()}, the returned value will be
 * {@link #UUID_DEFAULT}.
 *
 * @throws IOException when the storage device hosting the given path isn't
 *             present, or when it doesn't have a valid UUID.
 
 * @param path This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.UUID getUuidForPath(@androidx.annotation.RecentlyNonNull java.io.File path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Test if the given file descriptor supports allocation of disk space using
 * {@link #allocateBytes(FileDescriptor, long)}.

 * @param fd This value must never be {@code null}.
 */

public boolean isAllocationSupported(@androidx.annotation.RecentlyNonNull java.io.FileDescriptor fd) { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link StorageVolume} that contains the given file, or {@code null} if none.
 */

@androidx.annotation.RecentlyNullable public android.os.storage.StorageVolume getStorageVolume(java.io.File file) { throw new RuntimeException("Stub!"); }

/**
 * Return the list of shared/external storage volumes available to the
 * current user. This includes both the primary shared storage device and
 * any attached external volumes including SD cards and USB drives.
 *
 * @see Environment#getExternalStorageDirectory()
 * @see StorageVolume#createAccessIntent(String)

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<android.os.storage.StorageVolume> getStorageVolumes() { throw new RuntimeException("Stub!"); }

/**
 * Return the primary shared/external storage volume available to the
 * current user. This volume is the same storage device returned by
 * {@link Environment#getExternalStorageDirectory()} and
 * {@link Context#getExternalFilesDir(String)}.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.os.storage.StorageVolume getPrimaryStorageVolume() { throw new RuntimeException("Stub!"); }

/**
 * Return if data stored at or under the given path will be encrypted while
 * at rest. This can help apps avoid the overhead of double-encrypting data.
 */

public boolean isEncrypted(java.io.File file) { throw new RuntimeException("Stub!"); }

/**
 * Opens a seekable {@link ParcelFileDescriptor} that proxies all low-level
 * I/O requests back to the given {@link ProxyFileDescriptorCallback}.
 * <p>
 * This can be useful when you want to provide quick access to a large file
 * that isn't backed by a real file on disk, such as a file on a network
 * share, cloud storage service, etc. As an example, you could respond to a
 * {@link ContentResolver#openFileDescriptor(android.net.Uri, String)}
 * request by returning a {@link ParcelFileDescriptor} created with this
 * method, and then stream the content on-demand as requested.
 * <p>
 * Another useful example might be where you have an encrypted file that
 * you're willing to decrypt on-demand, but where you want to avoid
 * persisting the cleartext version.
 *
 * @param mode The desired access mode, must be one of
 *            {@link ParcelFileDescriptor#MODE_READ_ONLY},
 *            {@link ParcelFileDescriptor#MODE_WRITE_ONLY}, or
 *            {@link ParcelFileDescriptor#MODE_READ_WRITE}
 * @param callback Callback to process file operation requests issued on
 *            returned file descriptor.
 * @param handler Handler that invokes callback methods.
 * @return Seekable ParcelFileDescriptor.
 * This value will never be {@code null}.
 * @throws IOException
 */

@androidx.annotation.RecentlyNonNull public android.os.ParcelFileDescriptor openProxyFileDescriptor(int mode, android.os.ProxyFileDescriptorCallback callback, android.os.Handler handler) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return quota size in bytes for all cached data belonging to the calling
 * app on the given storage volume.
 * <p>
 * If your app goes above this quota, your cached files will be some of the
 * first to be deleted when additional disk space is needed. Conversely, if
 * your app stays under this quota, your cached files will be some of the
 * last to be deleted when additional disk space is needed.
 * <p>
 * This quota will change over time depending on how frequently the user
 * interacts with your app, and depending on how much system-wide disk space
 * is used.
 * <p class="note">
 * Note: if your app uses the {@code android:sharedUserId} manifest feature,
 * then cached data for all packages in your shared UID is tracked together
 * as a single unit.
 * </p>
 *
 * This method may take several seconds to complete, so it should
 *  *            only be called from a worker thread.
 * Value is a non-negative number of bytes.
 * @param storageUuid the UUID of the storage volume that you're interested
 *            in. The UUID for a specific path can be obtained using
 *            {@link #getUuidForPath(File)}.
 * This value must never be {@code null}.
 * @throws IOException when the storage device isn't present, or when it
 *             doesn't support cache quotas.
 * @see #getCacheSizeBytes(UUID)
 
 * @return Value is a non-negative number of bytes.
 */

public long getCacheQuotaBytes(@androidx.annotation.RecentlyNonNull java.util.UUID storageUuid) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return total size in bytes of all cached data belonging to the calling
 * app on the given storage volume.
 * <p>
 * Cached data tracked by this method always includes
 * {@link Context#getCacheDir()} and {@link Context#getCodeCacheDir()}, and
 * it also includes {@link Context#getExternalCacheDir()} if the primary
 * shared/external storage is hosted on the same storage device as your
 * private data.
 * <p class="note">
 * Note: if your app uses the {@code android:sharedUserId} manifest feature,
 * then cached data for all packages in your shared UID is tracked together
 * as a single unit.
 * </p>
 *
 * This method may take several seconds to complete, so it should
 *  *            only be called from a worker thread.
 * Value is a non-negative number of bytes.
 * @param storageUuid the UUID of the storage volume that you're interested
 *            in. The UUID for a specific path can be obtained using
 *            {@link #getUuidForPath(File)}.
 * This value must never be {@code null}.
 * @throws IOException when the storage device isn't present, or when it
 *             doesn't support cache quotas.
 * @see #getCacheQuotaBytes(UUID)
 
 * @return Value is a non-negative number of bytes.
 */

public long getCacheSizeBytes(@androidx.annotation.RecentlyNonNull java.util.UUID storageUuid) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return the maximum number of new bytes that your app can allocate for
 * itself on the given storage volume. This value is typically larger than
 * {@link File#getUsableSpace()}, since the system may be willing to delete
 * cached files to satisfy an allocation request. You can then allocate
 * space for yourself using {@link #allocateBytes(UUID, long)} or
 * {@link #allocateBytes(FileDescriptor, long)}.
 * <p>
 * This method is best used as a pre-flight check, such as deciding if there
 * is enough space to store an entire music album before you allocate space
 * for each audio file in the album. Attempts to allocate disk space beyond
 * the returned value will fail.
 * <p>
 * If the returned value is not large enough for the data you'd like to
 * persist, you can launch {@link #ACTION_MANAGE_STORAGE} with the
 * {@link #EXTRA_UUID} and {@link #EXTRA_REQUESTED_BYTES} options to help
 * involve the user in freeing up disk space.
 * <p>
 * If you're progressively allocating an unbounded amount of storage space
 * (such as when recording a video) you should avoid calling this method
 * more than once every 30 seconds.
 * <p class="note">
 * Note: if your app uses the {@code android:sharedUserId} manifest feature,
 * then allocatable space for all packages in your shared UID is tracked
 * together as a single unit.
 * </p>
 *
 * This method may take several seconds to complete, so it should
 *  *            only be called from a worker thread.
 * Value is a non-negative number of bytes.
 * @param storageUuid the UUID of the storage volume where you're
 *            considering allocating disk space, since allocatable space can
 *            vary widely depending on the underlying storage device. The
 *            UUID for a specific path can be obtained using
 *            {@link #getUuidForPath(File)}.
 * This value must never be {@code null}.
 * @return the maximum number of new bytes that the calling app can allocate
 *         using {@link #allocateBytes(UUID, long)} or
 *         {@link #allocateBytes(FileDescriptor, long)}.
 * Value is a non-negative number of bytes.
 * @throws IOException when the storage device isn't present, or when it
 *             doesn't support allocating space.
 */

public long getAllocatableBytes(@androidx.annotation.RecentlyNonNull java.util.UUID storageUuid) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Allocate the requested number of bytes for your application to use on the
 * given storage volume. This will cause the system to delete any cached
 * files necessary to satisfy your request.
 * <p>
 * Attempts to allocate disk space beyond the value returned by
 * {@link #getAllocatableBytes(UUID)} will fail.
 * <p>
 * Since multiple apps can be running simultaneously, this method may be
 * subject to race conditions. If possible, consider using
 * {@link #allocateBytes(FileDescriptor, long)} which will guarantee
 * that bytes are allocated to an opened file.
 * <p>
 * If you're progressively allocating an unbounded amount of storage space
 * (such as when recording a video) you should avoid calling this method
 * more than once every 60 seconds.
 *
 * This method may take several seconds to complete, so it should
 *  *            only be called from a worker thread.
 * @param storageUuid the UUID of the storage volume where you'd like to
 *            allocate disk space. The UUID for a specific path can be
 *            obtained using {@link #getUuidForPath(File)}.
 * This value must never be {@code null}.
 * @param bytes the number of bytes to allocate.
 * Value is a non-negative number of bytes.
 * @throws IOException when the storage device isn't present, or when it
 *             doesn't support allocating space, or if the device had
 *             trouble allocating the requested space.
 * @see #getAllocatableBytes(UUID)
 */

public void allocateBytes(@androidx.annotation.RecentlyNonNull java.util.UUID storageUuid, long bytes) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Allocate the requested number of bytes for your application to use in the
 * given open file. This will cause the system to delete any cached files
 * necessary to satisfy your request.
 * <p>
 * Attempts to allocate disk space beyond the value returned by
 * {@link #getAllocatableBytes(UUID)} will fail.
 * <p>
 * This method guarantees that bytes have been allocated to the opened file,
 * otherwise it will throw if fast allocation is not possible. Fast
 * allocation is typically only supported in private app data directories,
 * and on shared/external storage devices which are emulated.
 * <p>
 * If you're progressively allocating an unbounded amount of storage space
 * (such as when recording a video) you should avoid calling this method
 * more than once every 60 seconds.
 *
 * This method may take several seconds to complete, so it should
 *  *            only be called from a worker thread.
 * @param fd the open file that you'd like to allocate disk space for.
 * @param bytes the number of bytes to allocate. This is the desired final
 *            size of the open file. If the open file is smaller than this
 *            requested size, it will be extended without modifying any
 *            existing contents. If the open file is larger than this
 *            requested size, it will be truncated.
 * Value is a non-negative number of bytes.
 * @throws IOException when the storage device isn't present, or when it
 *             doesn't support allocating space, or if the device had
 *             trouble allocating the requested space.
 * @see #getAllocatableBytes(UUID, int)
 * @see #isAllocationSupported(FileDescriptor)
 * @see Environment#isExternalStorageEmulated(File)
 */

public void allocateBytes(java.io.FileDescriptor fd, long bytes) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Enable or disable special cache behavior that treats this directory and
 * its contents as an entire group.
 * <p>
 * When enabled and this directory is considered for automatic deletion by
 * the OS, all contained files will either be deleted together, or not at
 * all. This is useful when you have a directory that contains several
 * related metadata files that depend on each other, such as movie file and
 * a subtitle file.
 * <p>
 * When enabled, the <em>newest</em> {@link File#lastModified()} value of
 * any contained files is considered the modified time of the entire
 * directory.
 * <p>
 * This behavior can only be set on a directory, and it applies recursively
 * to all contained files and directories.
 */

public void setCacheBehaviorGroup(java.io.File path, boolean group) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Read the current value set by
 * {@link #setCacheBehaviorGroup(File, boolean)}.
 */

public boolean isCacheBehaviorGroup(java.io.File path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Enable or disable special cache behavior that leaves deleted cache files
 * intact as tombstones.
 * <p>
 * When enabled and a file contained in this directory is automatically
 * deleted by the OS, the file will be truncated to have a length of 0 bytes
 * instead of being fully deleted. This is useful if you need to distinguish
 * between a file that was deleted versus one that never existed.
 * <p>
 * This behavior can only be set on a directory, and it applies recursively
 * to all contained files and directories.
 * <p class="note">
 * Note: this behavior is ignored completely if the user explicitly requests
 * that all cached data be cleared.
 * </p>
 */

public void setCacheBehaviorTombstone(java.io.File path, boolean tombstone) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Read the current value set by
 * {@link #setCacheBehaviorTombstone(File, boolean)}.
 */

public boolean isCacheBehaviorTombstone(java.io.File path) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Activity Action: Allows the user to manage their storage. This activity
 * provides the ability to free up space on the device by deleting data such
 * as apps.
 * <p>
 * If the sending application has a specific storage device or allocation
 * size in mind, they can optionally define {@link #EXTRA_UUID} or
 * {@link #EXTRA_REQUESTED_BYTES}, respectively.
 * <p>
 * This intent should be launched using
 * {@link Activity#startActivityForResult(Intent, int)} so that the user
 * knows which app is requesting the storage space. The returned result will
 * be {@link Activity#RESULT_OK} if the requested space was made available,
 * or {@link Activity#RESULT_CANCELED} otherwise.
 */

public static final java.lang.String ACTION_MANAGE_STORAGE = "android.os.storage.action.MANAGE_STORAGE";

/**
 * Extra used to indicate the total size (in bytes) that an application is
 * interested in allocating.
 * <p>
 * When defined, the management UI will help guide the user to free up
 * enough disk space to reach this requested value.
 *
 * @see #ACTION_MANAGE_STORAGE
 */

public static final java.lang.String EXTRA_REQUESTED_BYTES = "android.os.storage.extra.REQUESTED_BYTES";

/**
 * Extra {@link UUID} used to indicate the storage volume where an
 * application is interested in allocating or managing disk space.
 *
 * @see #ACTION_MANAGE_STORAGE
 * @see #UUID_DEFAULT
 * @see #getUuidForPath(File)
 * @see Intent#putExtra(String, java.io.Serializable)
 */

public static final java.lang.String EXTRA_UUID = "android.os.storage.extra.UUID";

/**
 * UUID representing the default internal storage of this device which
 * provides {@link Environment#getDataDirectory()}.
 * <p>
 * This value is constant across all devices and it will never change, and
 * thus it cannot be used to uniquely identify a particular physical device.
 *
 * @see #getUuidForPath(File)
 * @see ApplicationInfo#storageUuid
 */

public static final java.util.UUID UUID_DEFAULT;
static { UUID_DEFAULT = null; }
}

