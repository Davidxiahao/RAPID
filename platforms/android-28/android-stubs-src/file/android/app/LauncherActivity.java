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


package android.app;

import android.view.View;
import android.widget.ListView;
import java.util.List;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/**
 * Displays a list of all activities which can be performed
 * for a given intent. Launches when clicked.
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class LauncherActivity extends android.app.ListActivity {

public LauncherActivity() { throw new RuntimeException("Stub!"); }

protected void onCreate(android.os.Bundle icicle) { throw new RuntimeException("Stub!"); }

public void setTitle(java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

public void setTitle(int titleId) { throw new RuntimeException("Stub!"); }

/**
 * Override to call setContentView() with your own content view to
 * customize the list layout.
 */

protected void onSetContentView() { throw new RuntimeException("Stub!"); }

protected void onListItemClick(android.widget.ListView l, android.view.View v, int position, long id) { throw new RuntimeException("Stub!"); }

/**
 * Return the actual Intent for a specific position in our
 * {@link android.widget.ListView}.
 * @param position The item whose Intent to return
 */

protected android.content.Intent intentForPosition(int position) { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link ListItem} for a specific position in our
 * {@link android.widget.ListView}.
 * @param position The item to return
 */

protected android.app.LauncherActivity.ListItem itemForPosition(int position) { throw new RuntimeException("Stub!"); }

/**
 * Get the base intent to use when running
 * {@link PackageManager#queryIntentActivities(Intent, int)}.
 */

protected android.content.Intent getTargetIntent() { throw new RuntimeException("Stub!"); }

/**
 * Perform query on package manager for list items.  The default
 * implementation queries for activities.
 */

protected java.util.List<android.content.pm.ResolveInfo> onQueryPackageManager(android.content.Intent queryIntent) { throw new RuntimeException("Stub!"); }

/**
 * Perform the query to determine which results to show and return a list of them.
 */

public java.util.List<android.app.LauncherActivity.ListItem> makeListItems() { throw new RuntimeException("Stub!"); }
/**
 * Utility class to resize icons to match default icon size.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class IconResizer {

public IconResizer() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Drawable representing the thumbnail of the specified Drawable.
 * The size of the thumbnail is defined by the dimension
 * android.R.dimen.launcher_application_icon_size.
 *
 * This method is not thread-safe and should be invoked on the UI thread only.
 *
 * @param icon The icon to get a thumbnail of.
 *
 * @return A thumbnail for the specified icon or the icon itself if the
 *         thumbnail could not be created.
 */

public android.graphics.drawable.Drawable createIconThumbnail(android.graphics.drawable.Drawable icon) { throw new RuntimeException("Stub!"); }
}

/**
 * An item in the list
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ListItem {

public ListItem() { throw new RuntimeException("Stub!"); }

public java.lang.String className;

public android.os.Bundle extras;

public android.graphics.drawable.Drawable icon;

public java.lang.CharSequence label;

public java.lang.String packageName;

public android.content.pm.ResolveInfo resolveInfo;
}

}

