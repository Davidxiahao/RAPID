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


package android.os;


/**
 * Retrieve overall information about the space on a filesystem. This is a
 * wrapper for Unix statvfs().
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StatFs {

/**
 * Construct a new StatFs for looking at the stats of the filesystem at
 * {@code path}. Upon construction, the stat of the file system will be
 * performed, and the values retrieved available from the methods on this
 * class.
 *
 * @param path path in the desired file system to stat.
 *
 * @throws IllegalArgumentException if the file system access fails
 */

public StatFs(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * Perform a restat of the file system referenced by this object. This is
 * the same as re-constructing the object with the same file system path,
 * and the new stat values are available upon return.
 *
 * @throws IllegalArgumentException if the file system access fails
 */

public void restat(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getBlockSizeLong()} instead.
 */

@Deprecated public int getBlockSize() { throw new RuntimeException("Stub!"); }

/**
 * The size, in bytes, of a block on the file system. This corresponds to
 * the Unix {@code statvfs.f_frsize} field.
 */

public long getBlockSizeLong() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getBlockCountLong()} instead.
 */

@Deprecated public int getBlockCount() { throw new RuntimeException("Stub!"); }

/**
 * The total number of blocks on the file system. This corresponds to the
 * Unix {@code statvfs.f_blocks} field.
 */

public long getBlockCountLong() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getFreeBlocksLong()} instead.
 */

@Deprecated public int getFreeBlocks() { throw new RuntimeException("Stub!"); }

/**
 * The total number of blocks that are free on the file system, including
 * reserved blocks (that are not available to normal applications). This
 * corresponds to the Unix {@code statvfs.f_bfree} field. Most applications
 * will want to use {@link #getAvailableBlocks()} instead.
 */

public long getFreeBlocksLong() { throw new RuntimeException("Stub!"); }

/**
 * The number of bytes that are free on the file system, including reserved
 * blocks (that are not available to normal applications). Most applications
 * will want to use {@link #getAvailableBytes()} instead.
 */

public long getFreeBytes() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getAvailableBlocksLong()} instead.
 */

@Deprecated public int getAvailableBlocks() { throw new RuntimeException("Stub!"); }

/**
 * The number of blocks that are free on the file system and available to
 * applications. This corresponds to the Unix {@code statvfs.f_bavail} field.
 */

public long getAvailableBlocksLong() { throw new RuntimeException("Stub!"); }

/**
 * The number of bytes that are free on the file system and available to
 * applications.
 */

public long getAvailableBytes() { throw new RuntimeException("Stub!"); }

/**
 * The total number of bytes supported by the file system.
 */

public long getTotalBytes() { throw new RuntimeException("Stub!"); }
}

