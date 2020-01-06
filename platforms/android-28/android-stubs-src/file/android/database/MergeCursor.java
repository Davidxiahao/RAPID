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


/**
 * A convenience class that lets you present an array of Cursors as a single linear Cursor.
 * The schema of the cursors presented is entirely up to the creator of the MergeCursor, and
 * may be different if that is desired. Calls to getColumns, getColumnIndex, etc will return the
 * value for the row that the MergeCursor is currently pointing at.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MergeCursor extends android.database.AbstractCursor {

public MergeCursor(android.database.Cursor[] cursors) { throw new RuntimeException("Stub!"); }

public int getCount() { throw new RuntimeException("Stub!"); }

public boolean onMove(int oldPosition, int newPosition) { throw new RuntimeException("Stub!"); }

public java.lang.String getString(int column) { throw new RuntimeException("Stub!"); }

public short getShort(int column) { throw new RuntimeException("Stub!"); }

public int getInt(int column) { throw new RuntimeException("Stub!"); }

public long getLong(int column) { throw new RuntimeException("Stub!"); }

public float getFloat(int column) { throw new RuntimeException("Stub!"); }

public double getDouble(int column) { throw new RuntimeException("Stub!"); }

public int getType(int column) { throw new RuntimeException("Stub!"); }

public boolean isNull(int column) { throw new RuntimeException("Stub!"); }

public byte[] getBlob(int column) { throw new RuntimeException("Stub!"); }

public java.lang.String[] getColumnNames() { throw new RuntimeException("Stub!"); }

public void deactivate() { throw new RuntimeException("Stub!"); }

public void close() { throw new RuntimeException("Stub!"); }

public void registerContentObserver(android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

public void unregisterContentObserver(android.database.ContentObserver observer) { throw new RuntimeException("Stub!"); }

public void registerDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

public void unregisterDataSetObserver(android.database.DataSetObserver observer) { throw new RuntimeException("Stub!"); }

public boolean requery() { throw new RuntimeException("Stub!"); }
}

