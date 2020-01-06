/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.provider;

import android.os.storage.StorageVolume;
import android.content.Intent;
import android.os.Build;
import android.net.Uri;
import android.content.Context;
import android.os.CancellationSignal;
import android.graphics.Point;
import android.os.Bundle;
import android.media.ExifInterface;
import android.content.IntentSender;
import android.content.res.AssetFileDescriptor;
import java.io.FileDescriptor;
import java.io.File;
import android.database.Cursor;
import android.content.ContentResolver;
import java.util.List;
import android.os.Parcel;
import android.os.ParcelFileDescriptor.OnCloseListener;
import android.os.ParcelFileDescriptor;

/**
 * Defines the contract between a documents provider and the platform.
 * <p>
 * To create a document provider, extend {@link DocumentsProvider}, which
 * provides a foundational implementation of this contract.
 * <p>
 * All client apps must hold a valid URI permission grant to access documents,
 * typically issued when a user makes a selection through
 * {@link Intent#ACTION_OPEN_DOCUMENT}, {@link Intent#ACTION_CREATE_DOCUMENT},
 * {@link Intent#ACTION_OPEN_DOCUMENT_TREE}, or
 * {@link StorageVolume#createAccessIntent(String) StorageVolume.createAccessIntent}.
 *
 * @see DocumentsProvider
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DocumentsContract {

DocumentsContract() { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the roots of a document provider. When queried, a
 * provider will return one or more rows with columns defined by
 * {@link Root}.
 *
 * @see DocumentsProvider#queryRoots(String[])
 */

public static android.net.Uri buildRootsUri(java.lang.String authority) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the given {@link Root#COLUMN_ROOT_ID} in a
 * document provider.
 *
 * @see #getRootId(Uri)
 */

public static android.net.Uri buildRootUri(java.lang.String authority, java.lang.String rootId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the recently modified documents of a specific root
 * in a document provider. When queried, a provider will return zero or more
 * rows with columns defined by {@link Document}.
 *
 * @see DocumentsProvider#queryRecentDocuments(String, String[])
 * @see #getRootId(Uri)
 */

public static android.net.Uri buildRecentDocumentsUri(java.lang.String authority, java.lang.String rootId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing access to descendant documents of the given
 * {@link Document#COLUMN_DOCUMENT_ID}.
 *
 * @see #getTreeDocumentId(Uri)
 */

public static android.net.Uri buildTreeDocumentUri(java.lang.String authority, java.lang.String documentId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the target {@link Document#COLUMN_DOCUMENT_ID} in
 * a document provider. When queried, a provider will return a single row
 * with columns defined by {@link Document}.
 *
 * @see DocumentsProvider#queryDocument(String, String[])
 * @see #getDocumentId(Uri)
 */

public static android.net.Uri buildDocumentUri(java.lang.String authority, java.lang.String documentId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the target {@link Document#COLUMN_DOCUMENT_ID} in
 * a document provider. When queried, a provider will return a single row
 * with columns defined by {@link Document}.
 * <p>
 * However, instead of directly accessing the target document, the returned
 * URI will leverage access granted through a subtree URI, typically
 * returned by {@link Intent#ACTION_OPEN_DOCUMENT_TREE}. The target document
 * must be a descendant (child, grandchild, etc) of the subtree.
 * <p>
 * This is typically used to access documents under a user-selected
 * directory tree, since it doesn't require the user to separately confirm
 * each new document access.
 *
 * @param treeUri the subtree to leverage to gain access to the target
 *            document. The target directory must be a descendant of this
 *            subtree.
 * @param documentId the target document, which the caller may not have
 *            direct access to.
 * @see Intent#ACTION_OPEN_DOCUMENT_TREE
 * @see DocumentsProvider#isChildDocument(String, String)
 * @see #buildDocumentUri(String, String)
 */

public static android.net.Uri buildDocumentUriUsingTree(android.net.Uri treeUri, java.lang.String documentId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the children of the target directory in a document
 * provider. When queried, a provider will return zero or more rows with
 * columns defined by {@link Document}.
 *
 * @param parentDocumentId the document to return children for, which must
 *            be a directory with MIME type of
 *            {@link Document#MIME_TYPE_DIR}.
 * @see DocumentsProvider#queryChildDocuments(String, String[], String)
 * @see #getDocumentId(Uri)
 */

public static android.net.Uri buildChildDocumentsUri(java.lang.String authority, java.lang.String parentDocumentId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing the children of the target directory in a document
 * provider. When queried, a provider will return zero or more rows with
 * columns defined by {@link Document}.
 * <p>
 * However, instead of directly accessing the target directory, the returned
 * URI will leverage access granted through a subtree URI, typically
 * returned by {@link Intent#ACTION_OPEN_DOCUMENT_TREE}. The target
 * directory must be a descendant (child, grandchild, etc) of the subtree.
 * <p>
 * This is typically used to access documents under a user-selected
 * directory tree, since it doesn't require the user to separately confirm
 * each new document access.
 *
 * @param treeUri the subtree to leverage to gain access to the target
 *            document. The target directory must be a descendant of this
 *            subtree.
 * @param parentDocumentId the document to return children for, which the
 *            caller may not have direct access to, and which must be a
 *            directory with MIME type of {@link Document#MIME_TYPE_DIR}.
 * @see Intent#ACTION_OPEN_DOCUMENT_TREE
 * @see DocumentsProvider#isChildDocument(String, String)
 * @see #buildChildDocumentsUri(String, String)
 */

public static android.net.Uri buildChildDocumentsUriUsingTree(android.net.Uri treeUri, java.lang.String parentDocumentId) { throw new RuntimeException("Stub!"); }

/**
 * Build URI representing a search for matching documents under a specific
 * root in a document provider. When queried, a provider will return zero or
 * more rows with columns defined by {@link Document}.
 *
 * @see DocumentsProvider#querySearchDocuments(String, String, String[])
 * @see #getRootId(Uri)
 * @see #getSearchDocumentsQuery(Uri)
 */

public static android.net.Uri buildSearchDocumentsUri(java.lang.String authority, java.lang.String rootId, java.lang.String query) { throw new RuntimeException("Stub!"); }

/**
 * Test if the given URI represents a {@link Document} backed by a
 * {@link DocumentsProvider}.
 *
 * @see #buildDocumentUri(String, String)
 * @see #buildDocumentUriUsingTree(Uri, String)

 * @param uri This value may be {@code null}.
 */

public static boolean isDocumentUri(android.content.Context context, @androidx.annotation.RecentlyNullable android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Test if the given URI represents a {@link Document} tree.
 *
 * @see #buildTreeDocumentUri(String, String)
 * @see #getTreeDocumentId(Uri)
 */

public static boolean isTreeUri(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Extract the {@link Root#COLUMN_ROOT_ID} from the given URI.
 */

public static java.lang.String getRootId(android.net.Uri rootUri) { throw new RuntimeException("Stub!"); }

/**
 * Extract the {@link Document#COLUMN_DOCUMENT_ID} from the given URI.
 *
 * @see #isDocumentUri(Context, Uri)
 */

public static java.lang.String getDocumentId(android.net.Uri documentUri) { throw new RuntimeException("Stub!"); }

/**
 * Extract the via {@link Document#COLUMN_DOCUMENT_ID} from the given URI.
 */

public static java.lang.String getTreeDocumentId(android.net.Uri documentUri) { throw new RuntimeException("Stub!"); }

/**
 * Extract the search query from a URI built by
 * {@link #buildSearchDocumentsUri(String, String, String)}.
 */

public static java.lang.String getSearchDocumentsQuery(android.net.Uri searchDocumentsUri) { throw new RuntimeException("Stub!"); }

/**
 * Return thumbnail representing the document at the given URI. Callers are
 * responsible for their own in-memory caching.
 *
 * @param documentUri document to return thumbnail for, which must have
 *            {@link Document#FLAG_SUPPORTS_THUMBNAIL} set.
 * @param size optimal thumbnail size desired. A provider may return a
 *            thumbnail of a different size, but never more than double the
 *            requested size.
 * @param signal signal used to indicate if caller is no longer interested
 *            in the thumbnail.
 * @return decoded thumbnail, or {@code null} if problem was encountered.
 * @see DocumentsProvider#openDocumentThumbnail(String, Point,
 *      android.os.CancellationSignal)
 */

public static android.graphics.Bitmap getDocumentThumbnail(android.content.ContentResolver resolver, android.net.Uri documentUri, android.graphics.Point size, android.os.CancellationSignal signal) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Create a new document with given MIME type and display name.
 *
 * @param parentDocumentUri directory with {@link Document#FLAG_DIR_SUPPORTS_CREATE}
 * @param mimeType MIME type of new document
 * @param displayName name of new document
 * @return newly created document, or {@code null} if failed
 */

public static android.net.Uri createDocument(android.content.ContentResolver resolver, android.net.Uri parentDocumentUri, java.lang.String mimeType, java.lang.String displayName) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Change the display name of an existing document.
 * <p>
 * If the underlying provider needs to create a new
 * {@link Document#COLUMN_DOCUMENT_ID} to represent the updated display
 * name, that new document is returned and the original document is no
 * longer valid. Otherwise, the original document is returned.
 *
 * @param documentUri document with {@link Document#FLAG_SUPPORTS_RENAME}
 * @param displayName updated name for document
 * @return the existing or new document after the rename, or {@code null} if
 *         failed.
 */

public static android.net.Uri renameDocument(android.content.ContentResolver resolver, android.net.Uri documentUri, java.lang.String displayName) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Delete the given document.
 *
 * @param documentUri document with {@link Document#FLAG_SUPPORTS_DELETE}
 * @return if the document was deleted successfully.
 */

public static boolean deleteDocument(android.content.ContentResolver resolver, android.net.Uri documentUri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Copies the given document.
 *
 * @param sourceDocumentUri document with {@link Document#FLAG_SUPPORTS_COPY}
 * @param targetParentDocumentUri document which will become a parent of the source
 *         document's copy.
 * @return the copied document, or {@code null} if failed.
 */

public static android.net.Uri copyDocument(android.content.ContentResolver resolver, android.net.Uri sourceDocumentUri, android.net.Uri targetParentDocumentUri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Moves the given document under a new parent.
 *
 * @param sourceDocumentUri document with {@link Document#FLAG_SUPPORTS_MOVE}
 * @param sourceParentDocumentUri parent document of the document to move.
 * @param targetParentDocumentUri document which will become a new parent of the source
 *         document.
 * @return the moved document, or {@code null} if failed.
 */

public static android.net.Uri moveDocument(android.content.ContentResolver resolver, android.net.Uri sourceDocumentUri, android.net.Uri sourceParentDocumentUri, android.net.Uri targetParentDocumentUri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Removes the given document from a parent directory.
 *
 * <p>In contrast to {@link #deleteDocument} it requires specifying the parent.
 * This method is especially useful if the document can be in multiple parents.
 *
 * @param documentUri document with {@link Document#FLAG_SUPPORTS_REMOVE}
 * @param parentDocumentUri parent document of the document to remove.
 * @return true if the document was removed successfully.
 */

public static boolean removeDocument(android.content.ContentResolver resolver, android.net.Uri documentUri, android.net.Uri parentDocumentUri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Ejects the given root. It throws {@link IllegalStateException} when ejection failed.
 *
 * @param rootUri root with {@link Root#FLAG_SUPPORTS_EJECT} to be ejected
 */

public static void ejectRoot(android.content.ContentResolver resolver, android.net.Uri rootUri) { throw new RuntimeException("Stub!"); }

/**
 * Finds the canonical path from the top of the document tree.
 *
 * The {@link Path#getPath()} of the return value contains the document ID
 * of all documents along the path from the top the document tree to the
 * requested document, both inclusive.
 *
 * The {@link Path#getRootId()} of the return value returns {@code null}.
 *
 * @param treeUri treeUri of the document which path is requested.
 * @return the path of the document, or {@code null} if failed.
 * @see DocumentsProvider#findDocumentPath(String, String)
 */

public static android.provider.DocumentsContract.Path findDocumentPath(android.content.ContentResolver resolver, android.net.Uri treeUri) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Creates an intent for obtaining a web link for the specified document.
 *
 * <p>Note, that due to internal limitations, if there is already a web link
 * intent created for the specified document but with different options,
 * then it may be overriden.
 *
 * <p>Providers are required to show confirmation UI for all new permissions granted
 * for the linked document.
 *
 * <p>If list of recipients is known, then it should be passed in options as
 * {@link Intent#EXTRA_EMAIL} as a list of email addresses. Note, that
 * this is just a hint for the provider, which can ignore the list. In either
 * case the provider is required to show a UI for letting the user confirm
 * any new permission grants.
 *
 * <p>Note, that the entire <code>options</code> bundle will be sent to the provider
 * backing the passed <code>uri</code>. Make sure that you trust the provider
 * before passing any sensitive information.
 *
 * <p>Since this API may show a UI, it cannot be called from background.
 *
 * <p>In order to obtain the Web Link use code like this:
 * <pre><code>
 * void onSomethingHappened() {
 *   IntentSender sender = DocumentsContract.createWebLinkIntent(<i>...</i>);
 *   if (sender != null) {
 *     startIntentSenderForResult(
 *         sender,
 *         WEB_LINK_REQUEST_CODE,
 *         null, 0, 0, 0, null);
 *   }
 * }
 *
 * <i>(...)</i>
 *
 * void onActivityResult(int requestCode, int resultCode, Intent data) {
 *   if (requestCode == WEB_LINK_REQUEST_CODE && resultCode == RESULT_OK) {
 *     Uri weblinkUri = data.getData();
 *     <i>...</i>
 *   }
 * }
 * </code></pre>
 *
 * @param uri uri for the document to create a link to.
 * @param options Extra information for generating the link.
 * @return an intent sender to obtain the web link, or null if the document
 *      is not linkable, or creating the intent sender failed.
 * @see DocumentsProvider#createWebLinkIntent(String, Bundle)
 * @see Intent#EXTRA_EMAIL
 */

public static android.content.IntentSender createWebLinkIntent(android.content.ContentResolver resolver, android.net.Uri uri, android.os.Bundle options) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Action of intent issued by DocumentsUI when user wishes to open/configure/manage a particular
 * document in the provider application.
 *
 * <p>When issued, the intent will include the URI of the document as the intent data.
 *
 * <p>A provider wishing to provide support for this action should do two things.
 * <li>Add an {@code <intent-filter>} matching this action.
 * <li>When supplying information in {@link DocumentsProvider#queryChildDocuments}, include
 * {@link Document#FLAG_SUPPORTS_SETTINGS} in the flags for each document that supports
 * settings.
 *
 * @see DocumentsContact#Document#FLAG_SUPPORTS_SETTINGS
 */

public static final java.lang.String ACTION_DOCUMENT_SETTINGS = "android.provider.action.DOCUMENT_SETTINGS";

/**
 * Optional string included in a directory {@link Cursor#getExtras()}
 * providing an error message that should be shown to a user. For example, a
 * provider may wish to indicate that a network error occurred. The user may
 * choose to retry, resulting in a new query.
 */

public static final java.lang.String EXTRA_ERROR = "error";

/**
 * Set this in a DocumentsUI intent to cause a package's own roots to be
 * excluded from the roots list.
 */

public static final java.lang.String EXTRA_EXCLUDE_SELF = "android.provider.extra.EXCLUDE_SELF";

/**
 * Optional string included in a directory {@link Cursor#getExtras()}
 * providing an informational message that should be shown to a user. For
 * example, a provider may wish to indicate that not all documents are
 * available.
 */

public static final java.lang.String EXTRA_INFO = "info";

/**
 * Sets the desired initial location visible to user when file chooser is shown.
 *
 * <p>Applicable to {@link Intent} with actions:
 * <ul>
 *      <li>{@link Intent#ACTION_OPEN_DOCUMENT}</li>
 *      <li>{@link Intent#ACTION_CREATE_DOCUMENT}</li>
 *      <li>{@link Intent#ACTION_OPEN_DOCUMENT_TREE}</li>
 * </ul>
 *
 * <p>Location should specify a document URI or a tree URI with document ID. If
 * this URI identifies a non-directory, document navigator will attempt to use the parent
 * of the document as the initial location.
 *
 * <p>The initial location is system specific if this extra is missing or document navigator
 * failed to locate the desired initial location.
 */

public static final java.lang.String EXTRA_INITIAL_URI = "android.provider.extra.INITIAL_URI";

/**
 * Optional boolean flag included in a directory {@link Cursor#getExtras()}
 * indicating that a document provider is still loading data. For example, a
 * provider has returned some results, but is still waiting on an
 * outstanding network request. The provider must send a content changed
 * notification when loading is finished.
 *
 * @see ContentResolver#notifyChange(Uri, android.database.ContentObserver,
 *      boolean)
 */

public static final java.lang.String EXTRA_LOADING = "loading";

/**
 * Included in {@link AssetFileDescriptor#getExtras()} when returned
 * thumbnail should be rotated.
 *
 * @see MediaStore.Images.ImageColumns#ORIENTATION
 */

public static final java.lang.String EXTRA_ORIENTATION = "android.provider.extra.ORIENTATION";

/**
 * Overrides the default prompt text in DocumentsUI when set in an intent.
 */

public static final java.lang.String EXTRA_PROMPT = "android.provider.extra.PROMPT";

/**
 * Intent action used to identify {@link DocumentsProvider} instances. This
 * is used in the {@code <intent-filter>} of a {@code <provider>}.
 */

public static final java.lang.String PROVIDER_INTERFACE = "android.content.action.DOCUMENTS_PROVIDER";
/**
 * Constants related to a document, including {@link Cursor} column names
 * and flags.
 * <p>
 * A document can be either an openable stream (with a specific MIME type),
 * or a directory containing additional documents (with the
 * {@link #MIME_TYPE_DIR} MIME type). A directory represents the top of a
 * subtree containing zero or more documents, which can recursively contain
 * even more documents and directories.
 * <p>
 * All columns are <em>read-only</em> to client applications.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Document {

Document() { throw new RuntimeException("Stub!"); }

/**
 * Display name of a document, used as the primary title displayed to a
 * user. This column is required.
 * <p>
 * Type: STRING
 */

public static final java.lang.String COLUMN_DISPLAY_NAME = "_display_name";

/**
 * Unique ID of a document. This ID is both provided by and interpreted
 * by a {@link DocumentsProvider}, and should be treated as an opaque
 * value by client applications. This column is required.
 * <p>
 * Each document must have a unique ID within a provider, but that
 * single document may be included as a child of multiple directories.
 * <p>
 * A provider must always return durable IDs, since they will be used to
 * issue long-term URI permission grants when an application interacts
 * with {@link Intent#ACTION_OPEN_DOCUMENT} and
 * {@link Intent#ACTION_CREATE_DOCUMENT}.
 * <p>
 * Type: STRING
 */

public static final java.lang.String COLUMN_DOCUMENT_ID = "document_id";

/**
 * Flags that apply to a document. This column is required.
 * <p>
 * Type: INTEGER (int)
 *
 * @see #FLAG_SUPPORTS_WRITE
 * @see #FLAG_SUPPORTS_DELETE
 * @see #FLAG_SUPPORTS_THUMBNAIL
 * @see #FLAG_DIR_PREFERS_GRID
 * @see #FLAG_DIR_PREFERS_LAST_MODIFIED
 * @see #FLAG_VIRTUAL_DOCUMENT
 * @see #FLAG_SUPPORTS_COPY
 * @see #FLAG_SUPPORTS_MOVE
 * @see #FLAG_SUPPORTS_REMOVE
 */

public static final java.lang.String COLUMN_FLAGS = "flags";

/**
 * Specific icon resource ID for a document. This column is optional,
 * and may be {@code null} to use a platform-provided default icon based
 * on {@link #COLUMN_MIME_TYPE}.
 * <p>
 * Type: INTEGER (int)
 */

public static final java.lang.String COLUMN_ICON = "icon";

/**
 * Timestamp when a document was last modified, in milliseconds since
 * January 1, 1970 00:00:00.0 UTC. This column is required, and may be
 * {@code null} if unknown. A {@link DocumentsProvider} can update this
 * field using events from {@link OnCloseListener} or other reliable
 * {@link ParcelFileDescriptor} transports.
 * <p>
 * Type: INTEGER (long)
 *
 * @see System#currentTimeMillis()
 */

public static final java.lang.String COLUMN_LAST_MODIFIED = "last_modified";

/**
 * Concrete MIME type of a document. For example, "image/png" or
 * "application/pdf" for openable files. A document can also be a
 * directory containing additional documents, which is represented with
 * the {@link #MIME_TYPE_DIR} MIME type. This column is required.
 * <p>
 * Type: STRING
 *
 * @see #MIME_TYPE_DIR
 */

public static final java.lang.String COLUMN_MIME_TYPE = "mime_type";

/**
 * Size of a document, in bytes, or {@code null} if unknown. This column
 * is required.
 * <p>
 * Type: INTEGER (long)
 */

public static final java.lang.String COLUMN_SIZE = "_size";

/**
 * Summary of a document, which may be shown to a user. This column is
 * optional, and may be {@code null}.
 * <p>
 * Type: STRING
 */

public static final java.lang.String COLUMN_SUMMARY = "summary";

/**
 * Flag indicating that a directory prefers its contents be shown in a
 * larger format grid. Usually suitable when a directory contains mostly
 * pictures. Only valid when {@link #COLUMN_MIME_TYPE} is
 * {@link #MIME_TYPE_DIR}.
 *
 * @see #COLUMN_FLAGS
 */

public static final int FLAG_DIR_PREFERS_GRID = 16; // 0x10

/**
 * Flag indicating that a directory prefers its contents be sorted by
 * {@link #COLUMN_LAST_MODIFIED}. Only valid when
 * {@link #COLUMN_MIME_TYPE} is {@link #MIME_TYPE_DIR}.
 *
 * @see #COLUMN_FLAGS
 */

public static final int FLAG_DIR_PREFERS_LAST_MODIFIED = 32; // 0x20

/**
 * Flag indicating that a document is a directory that supports creation
 * of new files within it. Only valid when {@link #COLUMN_MIME_TYPE} is
 * {@link #MIME_TYPE_DIR}.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsProvider#createDocument(String, String, String)
 */

public static final int FLAG_DIR_SUPPORTS_CREATE = 8; // 0x8

/**
 * Flag indicating that a document can be copied to another location
 * within the same document provider.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#copyDocument(ContentResolver, Uri, Uri)
 * @see DocumentsProvider#copyDocument(String, String)
 */

public static final int FLAG_SUPPORTS_COPY = 128; // 0x80

/**
 * Flag indicating that a document is deletable.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#deleteDocument(ContentResolver, Uri)
 * @see DocumentsProvider#deleteDocument(String)
 */

public static final int FLAG_SUPPORTS_DELETE = 4; // 0x4

/**
 * Flag indicating that a document can be moved to another location
 * within the same document provider.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#moveDocument(ContentResolver, Uri, Uri, Uri)
 * @see DocumentsProvider#moveDocument(String, String, String)
 */

public static final int FLAG_SUPPORTS_MOVE = 256; // 0x100

/**
 * Flag indicating that a document can be removed from a parent.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#removeDocument(ContentResolver, Uri, Uri)
 * @see DocumentsProvider#removeDocument(String, String)
 */

public static final int FLAG_SUPPORTS_REMOVE = 1024; // 0x400

/**
 * Flag indicating that a document can be renamed.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#renameDocument(ContentResolver, Uri,
 *      String)
 * @see DocumentsProvider#renameDocument(String, String)
 */

public static final int FLAG_SUPPORTS_RENAME = 64; // 0x40

/**
 * Flag indicating that a document has settings that can be configured by user.
 *
 * @see #COLUMN_FLAGS
 * @see #ACTION_DOCUMENT_SETTINGS
 */

public static final int FLAG_SUPPORTS_SETTINGS = 2048; // 0x800

/**
 * Flag indicating that a document can be represented as a thumbnail.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#getDocumentThumbnail(ContentResolver, Uri,
 *      Point, CancellationSignal)
 * @see DocumentsProvider#openDocumentThumbnail(String, Point,
 *      android.os.CancellationSignal)
 */

public static final int FLAG_SUPPORTS_THUMBNAIL = 1; // 0x1

/**
 * Flag indicating that a document supports writing.
 * <p>
 * When a document is opened with {@link Intent#ACTION_OPEN_DOCUMENT},
 * the calling application is granted both
 * {@link Intent#FLAG_GRANT_READ_URI_PERMISSION} and
 * {@link Intent#FLAG_GRANT_WRITE_URI_PERMISSION}. However, the actual
 * writability of a document may change over time, for example due to
 * remote access changes. This flag indicates that a document client can
 * expect {@link ContentResolver#openOutputStream(Uri)} to succeed.
 *
 * @see #COLUMN_FLAGS
 */

public static final int FLAG_SUPPORTS_WRITE = 2; // 0x2

/**
 * Flag indicating that a document is virtual, and doesn't have byte
 * representation in the MIME type specified as {@link #COLUMN_MIME_TYPE}.
 *
 * <p><em>Virtual documents must have at least one alternative streamable
 * format via {@link DocumentsProvider#openTypedDocument}</em>
 *
 * @see #COLUMN_FLAGS
 * @see #COLUMN_MIME_TYPE
 * @see DocumentsProvider#openTypedDocument(String, String, Bundle,
 *      android.os.CancellationSignal)
 * @see DocumentsProvider#getDocumentStreamTypes(String, String)
 */

public static final int FLAG_VIRTUAL_DOCUMENT = 512; // 0x200

/**
 * Flag indicating that a Web link can be obtained for the document.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#createWebLinkIntent(PackageManager, Uri, Bundle)
 */

public static final int FLAG_WEB_LINKABLE = 4096; // 0x1000

/**
 * MIME type of a document which is a directory that may contain
 * additional documents.
 *
 * @see #COLUMN_MIME_TYPE
 */

public static final java.lang.String MIME_TYPE_DIR = "vnd.android.document/directory";
}

/**
 * Holds a path from a document to a particular document under it. It
 * may also contains the root ID where the path resides.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Path implements android.os.Parcelable {

/**
 * Creates a Path.
 *
 * @param rootId the ID of the root. May be null.
 * This value may be {@code null}.
 * @param path the list of document ID from the parent document at
 *          position 0 to the child document.
 */

public Path(@androidx.annotation.RecentlyNullable java.lang.String rootId, java.util.List<java.lang.String> path) { throw new RuntimeException("Stub!"); }

/**
 * Returns the root id or null if the calling package doesn't have
 * permission to access root information.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getRootId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the path. The path is trimmed to the top of tree if
 * calling package doesn't have permission to access those
 * documents.
 */

public java.util.List<java.lang.String> getPath() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.provider.DocumentsContract.Path> CREATOR;
static { CREATOR = null; }
}

/**
 * Constants related to a root of documents, including {@link Cursor} column
 * names and flags. A root is the start of a tree of documents, such as a
 * physical storage device, or an account. Each root starts at the directory
 * referenced by {@link Root#COLUMN_DOCUMENT_ID}, which can recursively
 * contain both documents and directories.
 * <p>
 * All columns are <em>read-only</em> to client applications.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Root {

Root() { throw new RuntimeException("Stub!"); }

/**
 * Number of bytes available in this root. This column is optional, and
 * may be {@code null} if unknown or unbounded.
 * <p>
 * Type: INTEGER (long)
 */

public static final java.lang.String COLUMN_AVAILABLE_BYTES = "available_bytes";

/**
 * Capacity of a root in bytes. This column is optional, and may be
 * {@code null} if unknown or unbounded.
 * <p>
 * Type: INTEGER (long)
 */

public static final java.lang.String COLUMN_CAPACITY_BYTES = "capacity_bytes";

/**
 * Document which is a directory that represents the top directory of
 * this root. This column is required.
 * <p>
 * Type: STRING
 *
 * @see Document#COLUMN_DOCUMENT_ID
 */

public static final java.lang.String COLUMN_DOCUMENT_ID = "document_id";

/**
 * Flags that apply to a root. This column is required.
 * <p>
 * Type: INTEGER (int)
 *
 * @see #FLAG_LOCAL_ONLY
 * @see #FLAG_SUPPORTS_CREATE
 * @see #FLAG_SUPPORTS_RECENTS
 * @see #FLAG_SUPPORTS_SEARCH
 */

public static final java.lang.String COLUMN_FLAGS = "flags";

/**
 * Icon resource ID for a root. This column is required.
 * <p>
 * Type: INTEGER (int)
 */

public static final java.lang.String COLUMN_ICON = "icon";

/**
 * MIME types supported by this root. This column is optional, and if
 * {@code null} the root is assumed to support all MIME types. Multiple
 * MIME types can be separated by a newline. For example, a root
 * supporting audio might return "audio/*\napplication/x-flac".
 * <p>
 * Type: STRING
 */

public static final java.lang.String COLUMN_MIME_TYPES = "mime_types";

/**
 * Unique ID of a root. This ID is both provided by and interpreted by a
 * {@link DocumentsProvider}, and should be treated as an opaque value
 * by client applications. This column is required.
 * <p>
 * Type: STRING
 */

public static final java.lang.String COLUMN_ROOT_ID = "root_id";

/**
 * Summary for this root, which may be shown to a user. This column is
 * optional, and may be {@code null}. For a single storage service
 * surfacing multiple accounts as different roots, this summary should
 * be the name of the account.
 * <p>
 * Type: STRING
 */

public static final java.lang.String COLUMN_SUMMARY = "summary";

/**
 * Title for a root, which will be shown to a user. This column is
 * required. For a single storage service surfacing multiple accounts as
 * different roots, this title should be the name of the service.
 * <p>
 * Type: STRING
 */

public static final java.lang.String COLUMN_TITLE = "title";

/**
 * Flag indicating that this root offers content that is strictly local
 * on the device. That is, no network requests are made for the content.
 *
 * @see #COLUMN_FLAGS
 * @see Intent#EXTRA_LOCAL_ONLY
 */

public static final int FLAG_LOCAL_ONLY = 2; // 0x2

/**
 * Flag indicating that at least one directory under this root supports
 * creating content. Roots with this flag will be shown when an
 * application interacts with {@link Intent#ACTION_CREATE_DOCUMENT}.
 *
 * @see #COLUMN_FLAGS
 */

public static final int FLAG_SUPPORTS_CREATE = 1; // 0x1

/**
 * Flag indicating that this root can be ejected.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#ejectRoot(ContentResolver, Uri)
 * @see DocumentsProvider#ejectRoot(String)
 */

public static final int FLAG_SUPPORTS_EJECT = 32; // 0x20

/**
 * Flag indicating that this root supports testing parent child
 * relationships.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsProvider#isChildDocument(String, String)
 */

public static final int FLAG_SUPPORTS_IS_CHILD = 16; // 0x10

/**
 * Flag indicating that this root can be queried to provide recently
 * modified documents.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#buildRecentDocumentsUri(String, String)
 * @see DocumentsProvider#queryRecentDocuments(String, String[])
 */

public static final int FLAG_SUPPORTS_RECENTS = 4; // 0x4

/**
 * Flag indicating that this root supports search.
 *
 * @see #COLUMN_FLAGS
 * @see DocumentsContract#buildSearchDocumentsUri(String, String,
 *      String)
 * @see DocumentsProvider#querySearchDocuments(String, String,
 *      String[])
 */

public static final int FLAG_SUPPORTS_SEARCH = 8; // 0x8

/**
 * MIME type for a root.
 */

public static final java.lang.String MIME_TYPE_ITEM = "vnd.android.document/root";
}

}

