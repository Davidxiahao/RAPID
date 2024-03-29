/*
 * Copyright (C) 2017 The Android Open Source Project
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


/**
 * Constants for {@link Intent#ACTION_QUICK_VIEW}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class QuickViewConstants {

QuickViewConstants() { throw new RuntimeException("Stub!"); }

/**
 * Feature to delete an individual document. Quick viewer implementations must use
 * Storage Access Framework to both verify delete permission and to delete content.
 *
 * @see DocumentsContract.Document#FLAG_SUPPORTS_DELETE
 * @see DocumentsContract#deleteDocument(ContentResolver, Uri)
 */

public static final java.lang.String FEATURE_DELETE = "android:delete";

/**
 * Feature to download a document to the local file system.
 *
 * @see Intent#EXTRA_QUICK_VIEW_FEATURES
 * @see Intent#ACTION_QUICK_VIEW
 */

public static final java.lang.String FEATURE_DOWNLOAD = "android:download";

/**
 * Feature to edit a document using system standard editing mechanism, like
 * {@link Intent#ACTION_EDIT}.
 *
 * @see Intent#EXTRA_QUICK_VIEW_FEATURES
 * @see Intent#ACTION_QUICK_VIEW
 */

public static final java.lang.String FEATURE_EDIT = "android:edit";

/**
 * Feature to print a document.
 *
 * @see Intent#EXTRA_QUICK_VIEW_FEATURES
 * @see Intent#ACTION_QUICK_VIEW
 */

public static final java.lang.String FEATURE_PRINT = "android:print";

/**
 * Feature to view a document using system standard sending mechanism, like
 * {@link Intent#ACTION_SEND}.
 *
 * @see Intent#EXTRA_QUICK_VIEW_FEATURES
 * @see Intent#ACTION_QUICK_VIEW
 */

public static final java.lang.String FEATURE_SEND = "android:send";

/**
 * Feature to view a document using system standard viewing mechanism, like
 * {@link Intent#ACTION_VIEW}.
 *
 * @see Intent#EXTRA_QUICK_VIEW_FEATURES
 * @see Intent#ACTION_QUICK_VIEW
 */

public static final java.lang.String FEATURE_VIEW = "android:view";
}

