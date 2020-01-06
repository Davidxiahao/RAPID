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


package android.widget;

import android.view.ActionProvider;
import android.content.Intent;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.content.Context;

/**
 * This is a provider for a share action. It is responsible for creating views
 * that enable data sharing and also to show a sub menu with sharing activities
 * if the hosting item is placed on the overflow menu.
 * <p>
 * Here is how to use the action provider with custom backing file in a {@link MenuItem}:
 * </p>
 * <pre>
 * // In Activity#onCreateOptionsMenu
 * public boolean onCreateOptionsMenu(Menu menu) {
 *     // Get the menu item.
 *     MenuItem menuItem = menu.findItem(R.id.my_menu_item);
 *     // Get the provider and hold onto it to set/change the share intent.
 *     mShareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
 *     // Set history different from the default before getting the action
 *     // view since a call to {@link MenuItem#getActionView() MenuItem.getActionView()} calls
 *     // {@link ActionProvider#onCreateActionView()} which uses the backing file name. Omit this
 *     // line if using the default share history file is desired.
 *     mShareActionProvider.setShareHistoryFileName("custom_share_history.xml");
 *     . . .
 * }
 *
 * // Somewhere in the application.
 * public void doShare(Intent shareIntent) {
 *     // When you want to share set the share intent.
 *     mShareActionProvider.setShareIntent(shareIntent);
 * }</pre>
 * <p>
 * <strong>Note:</strong> While the sample snippet demonstrates how to use this provider
 * in the context of a menu item, the use of the provider is not limited to menu items.
 * </p>
 *
 * @see ActionProvider
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ShareActionProvider extends android.view.ActionProvider {

/**
 * Creates a new instance.
 *
 * @param context Context for accessing resources.
 */

public ShareActionProvider(android.content.Context context) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Sets a listener to be notified when a share target has been selected.
 * The listener can optionally decide to handle the selection and
 * not rely on the default behavior which is to launch the activity.
 * <p>
 * <strong>Note:</strong> If you choose the backing share history file
 *     you will still be notified in this callback.
 * </p>
 * @param listener The listener.
 */

public void setOnShareTargetSelectedListener(android.widget.ShareActionProvider.OnShareTargetSelectedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public android.view.View onCreateActionView() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public boolean hasSubMenu() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public void onPrepareSubMenu(android.view.SubMenu subMenu) { throw new RuntimeException("Stub!"); }

/**
 * Sets the file name of a file for persisting the share history which
 * history will be used for ordering share targets. This file will be used
 * for all view created by {@link #onCreateActionView()}. Defaults to
 * {@link #DEFAULT_SHARE_HISTORY_FILE_NAME}. Set to <code>null</code>
 * if share history should not be persisted between sessions.
 * <p>
 * <strong>Note:</strong> The history file name can be set any time, however
 * only the action views created by {@link #onCreateActionView()} after setting
 * the file name will be backed by the provided file. Therefore, if you want to
 * use different history files for sharing specific types of content, every time
 * you change the history file {@link #setShareHistoryFileName(String)} you must
 * call {@link android.app.Activity#invalidateOptionsMenu()} to recreate the
 * action view. You should <strong>not</strong> call
 * {@link android.app.Activity#invalidateOptionsMenu()} from
 * {@link android.app.Activity#onCreateOptionsMenu(Menu)}.
 * </p>
 * <pre>
 * private void doShare(Intent intent) {
 *     if (IMAGE.equals(intent.getMimeType())) {
 *         mShareActionProvider.setHistoryFileName(SHARE_IMAGE_HISTORY_FILE_NAME);
 *     } else if (TEXT.equals(intent.getMimeType())) {
 *         mShareActionProvider.setHistoryFileName(SHARE_TEXT_HISTORY_FILE_NAME);
 *     }
 *     mShareActionProvider.setIntent(intent);
 *     invalidateOptionsMenu();
 * }</pre>
 * @param shareHistoryFile The share history file name.
 */

public void setShareHistoryFileName(java.lang.String shareHistoryFile) { throw new RuntimeException("Stub!"); }

/**
 * Sets an intent with information about the share action. Here is a
 * sample for constructing a share intent:
 * <pre>
 * Intent shareIntent = new Intent(Intent.ACTION_SEND);
 * shareIntent.setType("image/*");
 * Uri uri = Uri.fromFile(new File(getFilesDir(), "foo.jpg"));
 * shareIntent.putExtra(Intent.EXTRA_STREAM, uri));</pre>
 *
 * @param shareIntent The share intent.
 *
 * @see Intent#ACTION_SEND
 * @see Intent#ACTION_SEND_MULTIPLE
 */

public void setShareIntent(android.content.Intent shareIntent) { throw new RuntimeException("Stub!"); }

/**
 * The default name for storing share history.
 */

public static final java.lang.String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
/**
 * Listener for the event of selecting a share target.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnShareTargetSelectedListener {

/**
 * Called when a share target has been selected. The client can
 * decide whether to perform some action before the sharing is
 * actually performed.
 * <p>
 * <strong>Note:</strong> Modifying the intent is not permitted and
 *     any changes to the latter will be ignored.
 * </p>
 * <p>
 * <strong>Note:</strong> You should <strong>not</strong> handle the
 *     intent here. This callback aims to notify the client that a
 *     sharing is being performed, so the client can update the UI
 *     if necessary.
 * </p>
 *
 * @param source The source of the notification.
 * @param intent The intent for launching the chosen share target.
 * @return The return result is ignored. Always return false for consistency.
 */

public boolean onShareTargetSelected(android.widget.ShareActionProvider source, android.content.Intent intent);
}

}

