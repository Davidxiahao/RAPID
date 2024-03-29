/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.content;

import android.database.Cursor;
import android.net.Uri;

/**
 * A loader that queries the {@link ContentResolver} and returns a {@link Cursor}.
 * This class implements the {@link Loader} protocol in a standard way for
 * querying cursors, building on {@link AsyncTaskLoader} to perform the cursor
 * query on a background thread so that it does not block the application's UI.
 *
 * <p>A CursorLoader must be built with the full information for the query to
 * perform, either through the
 * {@link #CursorLoader(Context, Uri, String[], String, String[], String)} or
 * creating an empty instance with {@link #CursorLoader(Context)} and filling
 * in the desired paramters with {@link #setUri(Uri)}, {@link #setSelection(String)},
 * {@link #setSelectionArgs(String[])}, {@link #setSortOrder(String)},
 * and {@link #setProjection(String[])}.
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.content.CursorLoader}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public class CursorLoader extends android.content.AsyncTaskLoader<android.database.Cursor> {

/**
 * Creates an empty unspecified CursorLoader.  You must follow this with
 * calls to {@link #setUri(Uri)}, {@link #setSelection(String)}, etc
 * to specify the query to perform.
 */

public CursorLoader(android.content.Context context) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a fully-specified CursorLoader.  See
 * {@link ContentResolver#query(Uri, String[], String, String[], String)
 * ContentResolver.query()} for documentation on the meaning of the
 * parameters.  These will be passed as-is to that call.
 */

public CursorLoader(android.content.Context context, android.net.Uri uri, java.lang.String[] projection, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String sortOrder) { super(null); throw new RuntimeException("Stub!"); }

public android.database.Cursor loadInBackground() { throw new RuntimeException("Stub!"); }

public void cancelLoadInBackground() { throw new RuntimeException("Stub!"); }

public void deliverResult(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

/**
 * Starts an asynchronous load of the data. When the result is ready the callbacks
 * will be called on the UI thread. If a previous load has been completed and is still valid
 * the result may be passed to the callbacks immediately.
 *
 * Must be called from the UI thread
 */

protected void onStartLoading() { throw new RuntimeException("Stub!"); }

/**
 * Must be called from the UI thread
 */

protected void onStopLoading() { throw new RuntimeException("Stub!"); }

public void onCanceled(android.database.Cursor cursor) { throw new RuntimeException("Stub!"); }

protected void onReset() { throw new RuntimeException("Stub!"); }

public android.net.Uri getUri() { throw new RuntimeException("Stub!"); }

public void setUri(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

public java.lang.String[] getProjection() { throw new RuntimeException("Stub!"); }

public void setProjection(java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

public java.lang.String getSelection() { throw new RuntimeException("Stub!"); }

public void setSelection(java.lang.String selection) { throw new RuntimeException("Stub!"); }

public java.lang.String[] getSelectionArgs() { throw new RuntimeException("Stub!"); }

public void setSelectionArgs(java.lang.String[] selectionArgs) { throw new RuntimeException("Stub!"); }

public java.lang.String getSortOrder() { throw new RuntimeException("Stub!"); }

public void setSortOrder(java.lang.String sortOrder) { throw new RuntimeException("Stub!"); }

public void dump(java.lang.String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }
}

