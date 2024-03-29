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


package android.preference;

import android.content.Context;
import android.app.Dialog;
import android.widget.Adapter;
import android.view.View;
import android.widget.ListView;

/**
 * Represents a top-level {@link Preference} that
 * is the root of a Preference hierarchy. A {@link PreferenceActivity}
 * points to an instance of this class to show the preferences. To instantiate
 * this class, use {@link PreferenceManager#createPreferenceScreen(Context)}.
 * <ul>
 * This class can appear in two places:
 * <li> When a {@link PreferenceActivity} points to this, it is used as the root
 * and is not shown (only the contained preferences are shown).
 * <li> When it appears inside another preference hierarchy, it is shown and
 * serves as the gateway to another screen of preferences (either by showing
 * another screen of preferences as a {@link Dialog} or via a
 * {@link Context#startActivity(android.content.Intent)} from the
 * {@link Preference#getIntent()}). The children of this {@link PreferenceScreen}
 * are NOT shown in the screen that this {@link PreferenceScreen} is shown in.
 * Instead, a separate screen will be shown when this preference is clicked.
 * </ul>
 * <p>Here's an example XML layout of a PreferenceScreen:</p>
 * <pre>
 &lt;PreferenceScreen
        xmlns:android="http://schemas.android.com/apk/res/android"
        android:key="first_preferencescreen"&gt;
    &lt;CheckBoxPreference
            android:key="wifi enabled"
            android:title="WiFi" /&gt;
    &lt;PreferenceScreen
            android:key="second_preferencescreen"
            android:title="WiFi settings"&gt;
        &lt;CheckBoxPreference
                android:key="prefer wifi"
                android:title="Prefer WiFi" /&gt;
        ... other preferences here ...
    &lt;/PreferenceScreen&gt;
 &lt;/PreferenceScreen&gt; </pre>
 * <p>
 * In this example, the "first_preferencescreen" will be used as the root of the
 * hierarchy and given to a {@link PreferenceActivity}. The first screen will
 * show preferences "WiFi" (which can be used to quickly enable/disable WiFi)
 * and "WiFi settings". The "WiFi settings" is the "second_preferencescreen" and when
 * clicked will show another screen of preferences such as "Prefer WiFi" (and
 * the other preferences that are children of the "second_preferencescreen" tag).
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about building a settings UI with Preferences,
 * read the <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>
 * guide.</p>
 * </div>
 *
 * @see PreferenceCategory
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PreferenceScreen extends android.preference.PreferenceGroup implements android.widget.AdapterView.OnItemClickListener, android.content.DialogInterface.OnDismissListener {

/**
 * Do NOT use this constructor, use {@link PreferenceManager#createPreferenceScreen(Context)}.
 * @hide-
 */

PreferenceScreen(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null, (android.util.AttributeSet)null); throw new RuntimeException("Stub!"); }

/**
 * Returns an adapter that can be attached to a {@link PreferenceActivity}
 * or {@link PreferenceFragment} to show the preferences contained in this
 * {@link PreferenceScreen}.
 * <p>
 * This {@link PreferenceScreen} will NOT appear in the returned adapter, instead
 * it appears in the hierarchy above this {@link PreferenceScreen}.
 * <p>
 * This adapter's {@link Adapter#getItem(int)} should always return a
 * subclass of {@link Preference}.
 *
 * @return An adapter that provides the {@link Preference} contained in this
 *         {@link PreferenceScreen}.
 */

public android.widget.ListAdapter getRootAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Creates the root adapter.
 *
 * @return An adapter that contains the preferences contained in this {@link PreferenceScreen}.
 * @see #getRootAdapter()
 */

protected android.widget.ListAdapter onCreateRootAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Binds a {@link ListView} to the preferences contained in this {@link PreferenceScreen} via
 * {@link #getRootAdapter()}. It also handles passing list item clicks to the corresponding
 * {@link Preference} contained by this {@link PreferenceScreen}.
 *
 * @param listView The list view to attach to.
 */

public void bind(android.widget.ListView listView) { throw new RuntimeException("Stub!"); }

protected void onClick() { throw new RuntimeException("Stub!"); }

public void onDismiss(android.content.DialogInterface dialog) { throw new RuntimeException("Stub!"); }

/**
 * Used to get a handle to the dialog.
 * This is useful for cases where we want to manipulate the dialog
 * as we would with any other activity or view.
 */

public android.app.Dialog getDialog() { throw new RuntimeException("Stub!"); }

public void onItemClick(android.widget.AdapterView parent, android.view.View view, int position, long id) { throw new RuntimeException("Stub!"); }

protected boolean isOnSameScreenAsChildren() { throw new RuntimeException("Stub!"); }

protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }
}

