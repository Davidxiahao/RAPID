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
 * File information returned by {@link Os#fstatvfs} and {@link Os#statvfs}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StructStatVfs {

/**
 * Constructs an instance with the given field values.
 */

public StructStatVfs(long f_bsize, long f_frsize, long f_blocks, long f_bfree, long f_bavail, long f_files, long f_ffree, long f_favail, long f_fsid, long f_flag, long f_namemax) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Free block count available to non-root. */

public final long f_bavail;
{ f_bavail = 0; }

/** Free block count. */

public final long f_bfree;
{ f_bfree = 0; }

/** Total block count. */

public final long f_blocks;
{ f_blocks = 0; }

/** File system block size (used for block counts). */

public final long f_bsize;
{ f_bsize = 0; }

/** Free file (inode) count available to non-root. */

public final long f_favail;
{ f_favail = 0; }

/** Free file (inode) count. */

public final long f_ffree;
{ f_ffree = 0; }

/** Total file (inode) count. */

public final long f_files;
{ f_files = 0; }

/** Bit mask of ST_* flags. */

public final long f_flag;
{ f_flag = 0; }

/** Fundamental file system block size. */

public final long f_frsize;
{ f_frsize = 0; }

/** File system id. */

public final long f_fsid;
{ f_fsid = 0; }

/** Maximum filename length. */

public final long f_namemax;
{ f_namemax = 0; }
}

