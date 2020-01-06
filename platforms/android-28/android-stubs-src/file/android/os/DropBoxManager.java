/*
 * Copyright (C) 2009 The Android Open Source Project
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

import android.content.Context;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;

/**
 * Enqueues chunks of data (from various sources -- application crashes, kernel
 * log records, etc.).  The queue is size bounded and will drop old data if the
 * enqueued data exceeds the maximum size.  You can think of this as a
 * persistent, system-wide, blob-oriented "logcat".
 *
 * <p>DropBoxManager entries are not sent anywhere directly, but other system
 * services and debugging tools may scan and upload entries for processing.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DropBoxManager {

/**
 * Create a dummy instance for testing.  All methods will fail unless
 * overridden with an appropriate mock implementation.  To obtain a
 * functional instance, use {@link android.content.Context#getSystemService}.
 */

protected DropBoxManager() { throw new RuntimeException("Stub!"); }

/**
 * Stores human-readable text.  The data may be discarded eventually (or even
 * immediately) if space is limited, or ignored entirely if the tag has been
 * blocked (see {@link #isTagEnabled}).
 *
 * @param tag describing the type of entry being stored
 * @param data value to store
 */

public void addText(java.lang.String tag, java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Stores binary data, which may be ignored or discarded as with {@link #addText}.
 *
 * @param tag describing the type of entry being stored
 * @param data value to store
 * @param flags describing the data
 */

public void addData(java.lang.String tag, byte[] data, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Stores the contents of a file, which may be ignored or discarded as with
 * {@link #addText}.
 *
 * @param tag describing the type of entry being stored
 * @param file to read from
 * @param flags describing the data
 * @throws IOException if the file can't be opened
 */

public void addFile(java.lang.String tag, java.io.File file, int flags) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Checks any blacklists (set in system settings) to see whether a certain
 * tag is allowed.  Entries with disabled tags will be dropped immediately,
 * so you can save the work of actually constructing and sending the data.
 *
 * @param tag that would be used in {@link #addText} or {@link #addFile}
 * @return whether events with that tag would be accepted
 */

public boolean isTagEnabled(java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Gets the next entry from the drop box <em>after</em> the specified time.
 * Requires <code>android.permission.READ_LOGS</code>.  You must always call
 * {@link Entry#close()} on the return value!
 *
 * Requires {@link android.Manifest.permission#READ_LOGS} and {@link android.Manifest.permission#PACKAGE_USAGE_STATS}
 * @param tag of entry to look for, null for all tags
 * @param msec time of the last entry seen
 * @return the next entry, or null if there are no more entries
 */

@androidx.annotation.RecentlyNullable public android.os.DropBoxManager.Entry getNextEntry(@androidx.annotation.RecentlyNonNull java.lang.String tag, long msec) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: This is broadcast when a new entry is added in the dropbox.
 * You must hold the {@link android.Manifest.permission#READ_LOGS} permission
 * in order to receive this broadcast.
 *
 * <p class="note">This is a protected intent that can only be sent
 * by the system.
 */

public static final java.lang.String ACTION_DROPBOX_ENTRY_ADDED = "android.intent.action.DROPBOX_ENTRY_ADDED";

/**
 * Extra for {@link android.os.DropBoxManager#ACTION_DROPBOX_ENTRY_ADDED}:
 * string containing the dropbox tag.
 */

public static final java.lang.String EXTRA_TAG = "tag";

/**
 * Extra for {@link android.os.DropBoxManager#ACTION_DROPBOX_ENTRY_ADDED}:
 * long integer value containing time (in milliseconds since January 1, 1970 00:00:00 UTC)
 * when the entry was created.
 */

public static final java.lang.String EXTRA_TIME = "time";

/** Flag value: Entry's content was deleted to save space. */

public static final int IS_EMPTY = 1; // 0x1

/** Flag value: Content can be decompressed with {@link java.util.zip.GZIPOutputStream}. */

public static final int IS_GZIPPED = 4; // 0x4

/** Flag value: Content is human-readable UTF-8 text (can be combined with IS_GZIPPED). */

public static final int IS_TEXT = 2; // 0x2
/**
 * A single entry retrieved from the drop box.
 * This may include a reference to a stream, so you must call
 * {@link #close()} when you are done using it.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Entry implements android.os.Parcelable, java.io.Closeable {

/** Create a new empty Entry with no contents. */

public Entry(java.lang.String tag, long millis) { throw new RuntimeException("Stub!"); }

/** Create a new Entry with plain text contents. */

public Entry(java.lang.String tag, long millis, java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Create a new Entry with byte array contents.
 * The data array must not be modified after creating this entry.
 */

public Entry(java.lang.String tag, long millis, byte[] data, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Create a new Entry with streaming data contents.
 * Takes ownership of the ParcelFileDescriptor.
 */

public Entry(java.lang.String tag, long millis, android.os.ParcelFileDescriptor data, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Create a new Entry with the contents read from a file.
 * The file will be read when the entry's contents are requested.
 */

public Entry(java.lang.String tag, long millis, java.io.File data, int flags) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/** Close the input stream associated with this entry. */

public void close() { throw new RuntimeException("Stub!"); }

/** @return the tag originally attached to the entry. */

public java.lang.String getTag() { throw new RuntimeException("Stub!"); }

/** @return time when the entry was originally created. */

public long getTimeMillis() { throw new RuntimeException("Stub!"); }

/** @return flags describing the content returned by {@link #getInputStream()}. */

public int getFlags() { throw new RuntimeException("Stub!"); }

/**
 * @param maxBytes of string to return (will truncate at this length).
 * @return the uncompressed text contents of the entry, null if the entry is not text.
 */

public java.lang.String getText(int maxBytes) { throw new RuntimeException("Stub!"); }

/** @return the uncompressed contents of the entry, or null if the contents were lost */

public java.io.InputStream getInputStream() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.os.DropBoxManager.Entry> CREATOR;
static { CREATOR = null; }
}

}

