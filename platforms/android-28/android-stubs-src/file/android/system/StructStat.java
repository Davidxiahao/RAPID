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


package android.system;


/**
 * File information returned by {@link Os#fstat}, {@link Os#lstat}, and {@link Os#stat}.
 * Corresponds to C's {@code struct stat} from {@code <stat.h>}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StructStat {

/**
 * Constructs an instance with the given field values.
 */

public StructStat(long st_dev, long st_ino, int st_mode, long st_nlink, int st_uid, int st_gid, long st_rdev, long st_size, long st_atime, long st_mtime, long st_ctime, long st_blksize, long st_blocks) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an instance with the given field values.
 */

public StructStat(long st_dev, long st_ino, int st_mode, long st_nlink, int st_uid, int st_gid, long st_rdev, long st_size, android.system.StructTimespec st_atim, android.system.StructTimespec st_mtim, android.system.StructTimespec st_ctim, long st_blksize, long st_blocks) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** StructTimespec with time of last access. */

public final android.system.StructTimespec st_atim;
{ st_atim = null; }

/** Seconds part of time of last access. */

public final long st_atime;
{ st_atime = 0; }

/**
 * A file system-specific preferred I/O block size for this object.
 * For some file system types, this may vary from file to file.
 */

public final long st_blksize;
{ st_blksize = 0; }

/** Number of blocks allocated for this object. */

public final long st_blocks;
{ st_blocks = 0; }

/** StructTimespec with time of last status change. */

public final android.system.StructTimespec st_ctim;
{ st_ctim = null; }

/** Seconds part of time of last status change */

public final long st_ctime;
{ st_ctime = 0; }

/** Device ID of device containing file. */

public final long st_dev;
{ st_dev = 0; }

/** Group ID of file. */

public final int st_gid;
{ st_gid = 0; }

/** File serial number (inode). */

public final long st_ino;
{ st_ino = 0; }

/** Mode (permissions) of file. */

public final int st_mode;
{ st_mode = 0; }

/** StructTimespec with time of last modification. */

public final android.system.StructTimespec st_mtim;
{ st_mtim = null; }

/** Seconds part of time of last data modification. */

public final long st_mtime;
{ st_mtime = 0; }

/** Number of hard links to the file. */

public final long st_nlink;
{ st_nlink = 0; }

/** Device ID (if file is character or block special). */

public final long st_rdev;
{ st_rdev = 0; }

/**
 * For regular files, the file size in bytes.
 * For symbolic links, the length in bytes of the pathname contained in the symbolic link.
 * For a shared memory object, the length in bytes.
 * For a typed memory object, the length in bytes.
 * For other file types, the use of this field is unspecified.
 */

public final long st_size;
{ st_size = 0; }

/** User ID of file. */

public final int st_uid;
{ st_uid = 0; }
}

