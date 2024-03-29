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


package android.preference;

import android.content.SharedPreferences;
import android.app.Activity;
import android.content.Intent;
import android.app.Fragment;

/**
 * Shows a hierarchy of {@link Preference} objects as
 * lists. These preferences will
 * automatically save to {@link SharedPreferences} as the user interacts with
 * them. To retrieve an instance of {@link SharedPreferences} that the
 * preference hierarchy in this fragment will use, call
 * {@link PreferenceManager#getDefaultSharedPreferences(android.content.Context)}
 * with a context in the same package as this fragment.
 * <p>
 * Furthermore, the preferences shown will follow the visual style of system
 * preferences. It is easy to create a hierarchy of preferences (that can be
 * shown on multiple screens) via XML. For these reasons, it is recommended to
 * use this fragment (as a superclass) to deal with preferences in applications.
 * <p>
 * A {@link PreferenceScreen} object should be at the top of the preference
 * hierarchy. Furthermore, subsequent {@link PreferenceScreen} in the hierarchy
 * denote a screen break--that is the preferences contained within subsequent
 * {@link PreferenceScreen} should be shown on another screen. The preference
 * framework handles showing these other screens from the preference hierarchy.
 * <p>
 * The preference hierarchy can be formed in multiple ways:
 * <li> From an XML file specifying the hierarchy
 * <li> From different {@link Activity Activities} that each specify its own
 * preferences in an XML file via {@link Activity} meta-data
 * <li> From an object hierarchy rooted with {@link PreferenceScreen}
 * <p>
 * To inflate from XML, use the {@link #addPreferencesFromResource(int)}. The
 * root element should be a {@link PreferenceScreen}. Subsequent elements can point
 * to actual {@link Preference} subclasses. As mentioned above, subsequent
 * {@link PreferenceScreen} in the hierarchy will result in the screen break.
 * <p>
 * To specify an {@link Intent} to query {@link Activity Activities} that each
 * have preferences, use {@link #addPreferencesFromIntent}. Each
 * {@link Activity} can specify meta-data in the manifest (via the key
 * {@link PreferenceManager#METADATA_KEY_PREFERENCES}) that points to an XML
 * resource. These XML resources will be inflated into a single preference
 * hierarchy and shown by this fragment.
 * <p>
 * To specify an object hierarchy rooted with {@link PreferenceScreen}, use
 * {@link #setPreferenceScreen(PreferenceScreen)}.
 * <p>
 * As a convenience, this fragment implements a click listener for any
 * preference in the current hierarchy, see
 * {@link #onPreferenceTreeClick(PreferenceScreen, Preference)}.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about using {@code PreferenceFragment},
 * read the <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>
 * guide.</p>
 * </div>
 *
 * <a name="SampleCode"></a>
 * <h3>Sample Code</h3>
 *
 * <p>The following sample code shows a simple preference fragment that is
 * populated from a resource.  The resource it loads is:</p>
 *
 * {@sample development/samples/ApiDemos/res/xml/preferences.xml preferences}
 *
 * <p>The fragment implementation itself simply populates the preferences
 * when created.  Note that the preferences framework takes care of loading
 * the current values out of the app preferences and writing them when changed:</p>
 *
 * {@sample development/samples/ApiDemos/src/com/example/android/apis/preference/FragmentPreferences.java
 *      fragment}
 *
 * @see Preference
 * @see PreferenceScreen
 *
 * @deprecated Use {@link android.support.v7.preference.PreferenceFragmentCompat}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public abstract class PreferenceFragment extends android.app.Fragment {

public PreferenceFragment() { throw new RuntimeException("Stub!"); }

/**
 * @param savedInstanceState This value may be {@code null}.
 */

public void onCreate(@androidx.annotation.RecentlyNullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * @param container This value may be {@code null}.

 * @param savedInstanceState This value may be {@code null}.
 */

public android.view.View onCreateView(android.view.LayoutInflater inflater, @androidx.annotation.RecentlyNullable android.view.ViewGroup container, @androidx.annotation.RecentlyNullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * @param savedInstanceState This value may be {@code null}.
 */

public void onViewCreated(android.view.View view, @androidx.annotation.RecentlyNullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

/**
 * @param savedInstanceState This value may be {@code null}.
 */

public void onActivityCreated(@androidx.annotation.RecentlyNullable android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

public void onStart() { throw new RuntimeException("Stub!"); }

public void onStop() { throw new RuntimeException("Stub!"); }

public void onDestroyView() { throw new RuntimeException("Stub!"); }

public void onDestroy() { throw new RuntimeException("Stub!"); }

public void onSaveInstanceState(android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

public void onActivityResult(int requestCode, int resultCode, android.content.Intent data) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link PreferenceManager} used by this fragment.
 * @return The {@link PreferenceManager}.
 */

public android.preference.PreferenceManager getPreferenceManager() { throw new RuntimeException("Stub!"); }

/**
 * Sets the root of the preference hierarchy that this fragment is showing.
 *
 * @param preferenceScreen The root {@link PreferenceScreen} of the preference hierarchy.
 */

public void setPreferenceScreen(android.preference.PreferenceScreen preferenceScreen) { throw new RuntimeException("Stub!"); }

/**
 * Gets the root of the preference hierarchy that this fragment is showing.
 *
 * @return The {@link PreferenceScreen} that is the root of the preference
 *         hierarchy.
 */

public android.preference.PreferenceScreen getPreferenceScreen() { throw new RuntimeException("Stub!"); }

/**
 * Adds preferences from activities that match the given {@link Intent}.
 *
 * @param intent The {@link Intent} to query activities.
 */

public void addPreferencesFromIntent(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Inflates the given XML resource and adds the preference hierarchy to the current
 * preference hierarchy.
 *
 * @param preferencesResId The XML resource ID to inflate.
 */

public void addPreferencesFromResource(int preferencesResId) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public boolean onPreferenceTreeClick(android.preference.PreferenceScreen preferenceScreen, android.preference.Preference preference) { throw new RuntimeException("Stub!"); }

/**
 * Finds a {@link Preference} based on its key.
 *
 * @param key The key of the preference to retrieve.
 * @return The {@link Preference} with the key, or null.
 * @see PreferenceGroup#findPreference(CharSequence)
 */

public android.preference.Preference findPreference(java.lang.CharSequence key) { throw new RuntimeException("Stub!"); }
/**
 * Interface that PreferenceFragment's containing activity should
 * implement to be able to process preference items that wish to
 * switch to a new fragment.
 *
 * @deprecated Use {@link
 * android.support.v7.preference.PreferenceFragmentCompat.OnPreferenceStartFragmentCallback}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public static interface OnPreferenceStartFragmentCallback {

/**
 * Called when the user has clicked on a Preference that has
 * a fragment class name associated with it.  The implementation
 * to should instantiate and switch to an instance of the given
 * fragment.
 */

public boolean onPreferenceStartFragment(android.preference.PreferenceFragment caller, android.preference.Preference pref);
}

}

