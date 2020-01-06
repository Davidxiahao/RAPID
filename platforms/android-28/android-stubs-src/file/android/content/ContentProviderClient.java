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


package android.content;

import android.content.res.AssetFileDescriptor;
import android.os.Bundle;

/**
 * The public interface object used to interact with a specific
 * {@link ContentProvider}.
 * <p>
 * Instances can be obtained by calling
 * {@link ContentResolver#acquireContentProviderClient} or
 * {@link ContentResolver#acquireUnstableContentProviderClient}. Instances must
 * be released using {@link #close()} in order to indicate to the system that
 * the underlying {@link ContentProvider} is no longer needed and can be killed
 * to free up resources.
 * <p>
 * Note that you should generally create a new ContentProviderClient instance
 * for each thread that will be performing operations. Unlike
 * {@link ContentResolver}, the methods here such as {@link #query} and
 * {@link #openFile} are not thread safe -- you must not call {@link #close()}
 * on the ContentProviderClient those calls are made from until you are finished
 * with the data they have returned.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ContentProviderClient implements java.lang.AutoCloseable {

ContentProviderClient() { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#query ContentProvider.query}
 * @param url This value must never be {@code null}.
 * @param projection This value may be {@code null}.
 * @param selection This value may be {@code null}.
 * @param selectionArgs This value may be {@code null}.
 * @param sortOrder This value may be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.database.Cursor query(@androidx.annotation.RecentlyNonNull android.net.Uri url, @androidx.annotation.RecentlyNullable java.lang.String[] projection, @androidx.annotation.RecentlyNullable java.lang.String selection, @androidx.annotation.RecentlyNullable java.lang.String[] selectionArgs, @androidx.annotation.RecentlyNullable java.lang.String sortOrder) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#query ContentProvider.query}
 * @param uri This value must never be {@code null}.
 * @param projection This value may be {@code null}.
 * @param selection This value may be {@code null}.
 * @param selectionArgs This value may be {@code null}.
 * @param sortOrder This value may be {@code null}.
 * @param cancellationSignal This value may be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.database.Cursor query(@androidx.annotation.RecentlyNonNull android.net.Uri uri, @androidx.annotation.RecentlyNullable java.lang.String[] projection, @androidx.annotation.RecentlyNullable java.lang.String selection, @androidx.annotation.RecentlyNullable java.lang.String[] selectionArgs, @androidx.annotation.RecentlyNullable java.lang.String sortOrder, @androidx.annotation.RecentlyNullable android.os.CancellationSignal cancellationSignal) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#query ContentProvider.query}
 * @param uri This value must never be {@code null}.
 * @param projection This value may be {@code null}.
 * @param cancellationSignal This value may be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.database.Cursor query(@androidx.annotation.RecentlyNonNull android.net.Uri uri, @androidx.annotation.RecentlyNullable java.lang.String[] projection, android.os.Bundle queryArgs, @androidx.annotation.RecentlyNullable android.os.CancellationSignal cancellationSignal) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#getType ContentProvider.getType}
 * @param url This value must never be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getType(@androidx.annotation.RecentlyNonNull android.net.Uri url) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#getStreamTypes ContentProvider.getStreamTypes}
 * @param url This value must never be {@code null}.
 * @param mimeTypeFilter This value must never be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String[] getStreamTypes(@androidx.annotation.RecentlyNonNull android.net.Uri url, @androidx.annotation.RecentlyNonNull java.lang.String mimeTypeFilter) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#canonicalize}
 * @param url This value must never be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public final android.net.Uri canonicalize(@androidx.annotation.RecentlyNonNull android.net.Uri url) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#uncanonicalize}
 * @param url This value must never be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public final android.net.Uri uncanonicalize(@androidx.annotation.RecentlyNonNull android.net.Uri url) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#refresh}
 * @param args This value may be {@code null}.

 * @param cancellationSignal This value may be {@code null}.
 */

public boolean refresh(android.net.Uri url, @androidx.annotation.RecentlyNullable android.os.Bundle args, @androidx.annotation.RecentlyNullable android.os.CancellationSignal cancellationSignal) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#insert ContentProvider.insert}
 * @param url This value must never be {@code null}.
 * @param initialValues This value may be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.net.Uri insert(@androidx.annotation.RecentlyNonNull android.net.Uri url, @androidx.annotation.RecentlyNullable android.content.ContentValues initialValues) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#bulkInsert ContentProvider.bulkInsert}
 * @param url This value must never be {@code null}.

 * @param initialValues This value must never be {@code null}.
 */

public int bulkInsert(@androidx.annotation.RecentlyNonNull android.net.Uri url, @androidx.annotation.RecentlyNonNull android.content.ContentValues[] initialValues) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#delete ContentProvider.delete}
 * @param url This value must never be {@code null}.
 
 * @param selection This value may be {@code null}.

 * @param selectionArgs This value may be {@code null}.
 */

public int delete(@androidx.annotation.RecentlyNonNull android.net.Uri url, @androidx.annotation.RecentlyNullable java.lang.String selection, @androidx.annotation.RecentlyNullable java.lang.String[] selectionArgs) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#update ContentProvider.update}
 * @param url This value must never be {@code null}.

 * @param values This value may be {@code null}.
 
 * @param selection This value may be {@code null}.

 * @param selectionArgs This value may be {@code null}.
 */

public int update(@androidx.annotation.RecentlyNonNull android.net.Uri url, @androidx.annotation.RecentlyNullable android.content.ContentValues values, @androidx.annotation.RecentlyNullable java.lang.String selection, @androidx.annotation.RecentlyNullable java.lang.String[] selectionArgs) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#openFile ContentProvider.openFile}.  Note that
 * this <em>does not</em>
 * take care of non-content: URIs such as file:.  It is strongly recommended
 * you use the {@link ContentResolver#openFileDescriptor
 * ContentResolver.openFileDescriptor} API instead.
 
 * @param url This value must never be {@code null}.
 * @param mode This value must never be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.ParcelFileDescriptor openFile(@androidx.annotation.RecentlyNonNull android.net.Uri url, @androidx.annotation.RecentlyNonNull java.lang.String mode) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#openFile ContentProvider.openFile}.  Note that
 * this <em>does not</em>
 * take care of non-content: URIs such as file:.  It is strongly recommended
 * you use the {@link ContentResolver#openFileDescriptor
 * ContentResolver.openFileDescriptor} API instead.
 
 * @param url This value must never be {@code null}.
 * @param mode This value must never be {@code null}.
 * @param signal This value may be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.ParcelFileDescriptor openFile(@androidx.annotation.RecentlyNonNull android.net.Uri url, @androidx.annotation.RecentlyNonNull java.lang.String mode, @androidx.annotation.RecentlyNullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#openAssetFile ContentProvider.openAssetFile}.
 * Note that this <em>does not</em>
 * take care of non-content: URIs such as file:.  It is strongly recommended
 * you use the {@link ContentResolver#openAssetFileDescriptor
 * ContentResolver.openAssetFileDescriptor} API instead.
 
 * @param url This value must never be {@code null}.
 * @param mode This value must never be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.content.res.AssetFileDescriptor openAssetFile(@androidx.annotation.RecentlyNonNull android.net.Uri url, @androidx.annotation.RecentlyNonNull java.lang.String mode) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#openAssetFile ContentProvider.openAssetFile}.
 * Note that this <em>does not</em>
 * take care of non-content: URIs such as file:.  It is strongly recommended
 * you use the {@link ContentResolver#openAssetFileDescriptor
 * ContentResolver.openAssetFileDescriptor} API instead.
 
 * @param url This value must never be {@code null}.
 * @param mode This value must never be {@code null}.
 * @param signal This value may be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.content.res.AssetFileDescriptor openAssetFile(@androidx.annotation.RecentlyNonNull android.net.Uri url, @androidx.annotation.RecentlyNonNull java.lang.String mode, @androidx.annotation.RecentlyNullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#openTypedAssetFile ContentProvider.openTypedAssetFile}
 * @param uri This value must never be {@code null}.
 * @param mimeType This value must never be {@code null}.
 * @param opts This value may be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public final android.content.res.AssetFileDescriptor openTypedAssetFileDescriptor(@androidx.annotation.RecentlyNonNull android.net.Uri uri, @androidx.annotation.RecentlyNonNull java.lang.String mimeType, @androidx.annotation.RecentlyNullable android.os.Bundle opts) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#openTypedAssetFile ContentProvider.openTypedAssetFile}
 * @param uri This value must never be {@code null}.
 * @param mimeType This value must never be {@code null}.
 * @param opts This value may be {@code null}.
 * @param signal This value may be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public final android.content.res.AssetFileDescriptor openTypedAssetFileDescriptor(@androidx.annotation.RecentlyNonNull android.net.Uri uri, @androidx.annotation.RecentlyNonNull java.lang.String mimeType, @androidx.annotation.RecentlyNullable android.os.Bundle opts, @androidx.annotation.RecentlyNullable android.os.CancellationSignal signal) throws java.io.FileNotFoundException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#applyBatch ContentProvider.applyBatch}
 * @param operations This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.ContentProviderResult[] applyBatch(@androidx.annotation.RecentlyNonNull java.util.ArrayList<android.content.ContentProviderOperation> operations) throws android.content.OperationApplicationException, android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * See {@link ContentProvider#call(String, String, Bundle)}
 * @param method This value must never be {@code null}.
 * @param arg This value may be {@code null}.
 * @param extras This value may be {@code null}.
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.Bundle call(@androidx.annotation.RecentlyNonNull java.lang.String method, @androidx.annotation.RecentlyNullable java.lang.String arg, @androidx.annotation.RecentlyNullable android.os.Bundle extras) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * Closes this client connection, indicating to the system that the
 * underlying {@link ContentProvider} is no longer needed.
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated replaced by {@link #close()}.
 */

@Deprecated public boolean release() { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Get a reference to the {@link ContentProvider} that is associated with this
 * client. If the {@link ContentProvider} is running in a different process then
 * null will be returned. This can be used if you know you are running in the same
 * process as a provider, and want to get direct access to its implementation details.
 *
 * @return If the associated {@link ContentProvider} is local, returns it.
 * Otherwise returns null.
 */

@androidx.annotation.RecentlyNullable public android.content.ContentProvider getLocalContentProvider() { throw new RuntimeException("Stub!"); }
}

