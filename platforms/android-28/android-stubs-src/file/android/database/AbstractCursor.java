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


package android.database;

import android.net.Uri;

/**
 * This is an abstract cursor class that handles a lot of the common code
 * that all cursors need to deal with and is provided for convenience reasons.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbstractCursor implements android.database.CrossProcessCursor {

public AbstractCursor() { throw new RuntimeException("Stub!"); }

public abstract int getCount();

public abstract java.lang.String[] getColumnNames();

public abstract java.lang.String getString(int column);

public abstract short getShort(int column);

public abstract int getInt(int column);

public abstract long getLong(int column);

public abstract float getFloat(int column);

public abstract double getDouble(int column);

public abstract boolean isNull(int column);

public int getType(int column) { throw new RuntimeException("Stub!"); }

public byte[] getBlob(int column) { throw new RuntimeException("Stub!"); }

/**
 * If the cursor is backed by a {@link CursorWindow}, returns a pre-filled
 * window with the contents of the cursor, otherwise null.
 *
 * @return The pre-filled window that backs this cursor, or null if none.
 */

public android.database.CursorWindow getWindow() { throw new RuntimeException("Stub!"); }

public int getColumnCount() { throw new RuntimeException("Stub!"); }

public void deactivate() { throw new RuntimeException("Stub!"); }

public boolean requery() { throw new RuntimeException("Stub!"); }

public boolean isClosed() { throw new RuntimeException("Stub!"); }

public void close() { throw new RuntimeException("Stub!"); }

/**
 * This function is called every time the cursor is successfully scrolled
 * to a new position, giving the subclass a chance to update any state it
 * may have. If it returns false the move function will also do so and the
 * cursor will scroll to the beforeFirst position.
 *
 * @param oldPosition the position that we're moving from
 * @param newPosition the position that we're moving to
 * @return true if the move is successful, false otherwise
 */

public boolean onMove(int oldPosition, int newPosition) { throw new RuntimeException("Stub!"); }

public void copyStringToBuffer(int columnIndex, android.database.CharArrayBuffer buffer) { throw new RuntimeException("Stub!"); }

public final int getPosition() { throw new RuntimeException("Stub!"); }

public final boolean moveToPosition(int position) { throw new RuntimeException("Stub!"); }

public void fillWindow(int position, android.database.CursorWindow window) { throw new RuntimeException("Stub!"); }

public final boolean move(int offset) { throw new RuntimeException("Stub!"); }

public final boolean moveToFirst() { throw new RuntimeException("Stub!"); }

public final boolean moveToLast() { throw new RuntimeException("Stub!"); }

public final boolean moveToNext() { throw new RuntimeException("Stub!"); }

public final boolean moveToPrevious() { throw new RuntimeException("Stub!"); }

public final boolean isFirst() { throw new RuntimeException("Stub!"); }

public final boolean isLast() { throw new RuntimeException("Stub!"); }

public final boolean isBeforeFirst() { throw new RuntimeException("Stub!"); }

public final boolean isAfterLast() { throw new RuntimeException("Stub!"); }

public int getColumnIndex(java.lang.String columnName) { throw new RuntimeException("Stub!"); }

public int getColumnIndexOrThrow(java.lang.String columnName) { throw new RuntimeException("Stub!"); }

public java.lang.String getColumnName(int columnIndex) { throw new RuntimeException("Stub!"); }

public void registerContentObserver(android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

public void unregisterContentObserver(android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

public void registerDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

public void unregisterDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses must call this method when they finish committing updates to notify all
 * observers.
 *
 * @param selfChange
 */

protected void onChange(boolean selfChange) { throw new RuntimeException("Stub!"); }

/**
 * Specifies a content URI to watch for changes.
 *
 * @param cr The content resolver from the caller's context.
 * @param notifyUri The URI to watch for changes. This can be a
 * specific row URI, or a base URI for a whole class of content.
 */

public void setNotificationUri(android.content.ContentResolver cr, android.net.Uri notifyUri) { throw new RuntimeException("Stub!"); }

public android.net.Uri getNotificationUri() { throw new RuntimeException("Stub!"); }

public boolean getWantsAllOnMoveCalls() { throw new RuntimeException("Stub!"); }

public void setExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

public android.os.Bundle respond(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Always returns false since Cursors do not support updating rows
 */

@Deprecated protected boolean isFieldUpdated(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Always returns null since Cursors do not support updating rows
 */

@Deprecated protected java.lang.Object getUpdatedField(int columnIndex) { throw new RuntimeException("Stub!"); }

/**
 * This function throws CursorIndexOutOfBoundsException if
 * the cursor position is out of bounds. Subclass implementations of
 * the get functions should call this before attempting
 * to retrieve data.
 *
 * @throws CursorIndexOutOfBoundsException
 */

protected void checkPosition() { throw new RuntimeException("Stub!"); }

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #isClosed()} instead.
 */

@Deprecated protected boolean mClosed;

/**
 * @deprecated Do not use.
 */

@Deprecated protected android.content.ContentResolver mContentResolver;

/**
 * @deprecated Use {@link #getPosition()} instead.
 */

@Deprecated protected int mPos;
/**
 * Cursors use this class to track changes others make to their URI.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static class SelfContentObserver extends android.database.ContentObserver {

public SelfContentObserver(android.database.AbstractCursor cursor) { super(null); throw new RuntimeException("Stub!"); }

public boolean deliverSelfNotifications() { throw new RuntimeException("Stub!"); }

public void onChange(boolean selfChange) { throw new RuntimeException("Stub!"); }
}

}

