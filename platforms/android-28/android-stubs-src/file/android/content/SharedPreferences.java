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


package android.content;

import java.util.Set;

/**
 * Interface for accessing and modifying preference data returned by {@link
 * Context#getSharedPreferences}.  For any particular set of preferences,
 * there is a single instance of this class that all clients share.
 * Modifications to the preferences must go through an {@link Editor} object
 * to ensure the preference values remain in a consistent state and control
 * when they are committed to storage.  Objects that are returned from the
 * various <code>get</code> methods must be treated as immutable by the application.
 *
 * <p>Note: This class provides strong consistency guarantees. It is using expensive operations
 * which might slow down an app. Frequently changing properties or properties where loss can be
 * tolerated should use other mechanisms. For more details read the comments on
 * {@link Editor#commit()} and {@link Editor#apply()}.
 *
 * <p><em>Note: This class does not support use across multiple processes.</em>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using SharedPreferences, read the
 * <a href="{@docRoot}guide/topics/data/data-storage.html#pref">Data Storage</a>
 * developer guide.</p></div>
 *
 * @see Context#getSharedPreferences
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface SharedPreferences {

/**
 * Retrieve all values from the preferences.
 *
 * <p>Note that you <em>must not</em> modify the collection returned
 * by this method, or alter any of its contents.  The consistency of your
 * stored data is not guaranteed if you do.
 *
 * @return Returns a map containing a list of pairs key/value representing
 * the preferences.
 *
 * @throws NullPointerException
 */

public java.util.Map<java.lang.String, ?> getAll();

/**
 * Retrieve a String value from the preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist.
 *
 * This value may be {@code null}.
 * @return Returns the preference value if it exists, or defValue.  Throws
 * ClassCastException if there is a preference with this name that is not
 * a String.
 *
 * This value may be {@code null}.
 * @throws ClassCastException
 */

@androidx.annotation.RecentlyNullable public java.lang.String getString(java.lang.String key, @androidx.annotation.RecentlyNullable java.lang.String defValue);

/**
 * Retrieve a set of String values from the preferences.
 *
 * <p>Note that you <em>must not</em> modify the set instance returned
 * by this call.  The consistency of the stored data is not guaranteed
 * if you do, nor is your ability to modify the instance at all.
 *
 * @param key The name of the preference to retrieve.
 * @param defValues Values to return if this preference does not exist.
 *
 * This value may be {@code null}.
 * @return Returns the preference values if they exist, or defValues.
 * Throws ClassCastException if there is a preference with this name
 * that is not a Set.
 *
 * This value may be {@code null}.
 * @throws ClassCastException
 */

@androidx.annotation.RecentlyNullable public java.util.Set<java.lang.String> getStringSet(java.lang.String key, @androidx.annotation.RecentlyNullable java.util.Set<java.lang.String> defValues);

/**
 * Retrieve an int value from the preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist.
 *
 * @return Returns the preference value if it exists, or defValue.  Throws
 * ClassCastException if there is a preference with this name that is not
 * an int.
 *
 * @throws ClassCastException
 */

public int getInt(java.lang.String key, int defValue);

/**
 * Retrieve a long value from the preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist.
 *
 * @return Returns the preference value if it exists, or defValue.  Throws
 * ClassCastException if there is a preference with this name that is not
 * a long.
 *
 * @throws ClassCastException
 */

public long getLong(java.lang.String key, long defValue);

/**
 * Retrieve a float value from the preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist.
 *
 * @return Returns the preference value if it exists, or defValue.  Throws
 * ClassCastException if there is a preference with this name that is not
 * a float.
 *
 * @throws ClassCastException
 */

public float getFloat(java.lang.String key, float defValue);

/**
 * Retrieve a boolean value from the preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist.
 *
 * @return Returns the preference value if it exists, or defValue.  Throws
 * ClassCastException if there is a preference with this name that is not
 * a boolean.
 *
 * @throws ClassCastException
 */

public boolean getBoolean(java.lang.String key, boolean defValue);

/**
 * Checks whether the preferences contains a preference.
 *
 * @param key The name of the preference to check.
 * @return Returns true if the preference exists in the preferences,
 *         otherwise false.
 */

public boolean contains(java.lang.String key);

/**
 * Create a new Editor for these preferences, through which you can make
 * modifications to the data in the preferences and atomically commit those
 * changes back to the SharedPreferences object.
 *
 * <p>Note that you <em>must</em> call {@link Editor#commit} to have any
 * changes you perform in the Editor actually show up in the
 * SharedPreferences.
 *
 * @return Returns a new instance of the {@link Editor} interface, allowing
 * you to modify the values in this SharedPreferences object.
 */

public android.content.SharedPreferences.Editor edit();

/**
 * Registers a callback to be invoked when a change happens to a preference.
 *
 * <p class="caution"><strong>Caution:</strong> The preference manager does
 * not currently store a strong reference to the listener. You must store a
 * strong reference to the listener, or it will be susceptible to garbage
 * collection. We recommend you keep a reference to the listener in the
 * instance data of an object that will exist as long as you need the
 * listener.</p>
 *
 * @param listener The callback that will run.
 * @see #unregisterOnSharedPreferenceChangeListener
 */

public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener listener);

/**
 * Unregisters a previous callback.
 *
 * @param listener The callback that should be unregistered.
 * @see #registerOnSharedPreferenceChangeListener
 */

public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener listener);
/**
 * Interface used for modifying values in a {@link SharedPreferences}
 * object.  All changes you make in an editor are batched, and not copied
 * back to the original {@link SharedPreferences} until you call {@link #commit}
 * or {@link #apply}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Editor {

/**
 * Set a String value in the preferences editor, to be written back once
 * {@link #commit} or {@link #apply} are called.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference.  Passing {@code null}
 *    for this argument is equivalent to calling {@link #remove(String)} with
 *    this key.
 *
 * This value may be {@code null}.
 * @return Returns a reference to the same Editor object, so you can
 * chain put calls together.
 */

public android.content.SharedPreferences.Editor putString(java.lang.String key, @androidx.annotation.RecentlyNullable java.lang.String value);

/**
 * Set a set of String values in the preferences editor, to be written
 * back once {@link #commit} or {@link #apply} is called.
 *
 * @param key The name of the preference to modify.
 * @param values The set of new values for the preference.  Passing {@code null}
 *    for this argument is equivalent to calling {@link #remove(String)} with
 *    this key.
 * This value may be {@code null}.
 * @return Returns a reference to the same Editor object, so you can
 * chain put calls together.
 */

public android.content.SharedPreferences.Editor putStringSet(java.lang.String key, @androidx.annotation.RecentlyNullable java.util.Set<java.lang.String> values);

/**
 * Set an int value in the preferences editor, to be written back once
 * {@link #commit} or {@link #apply} are called.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference.
 *
 * @return Returns a reference to the same Editor object, so you can
 * chain put calls together.
 */

public android.content.SharedPreferences.Editor putInt(java.lang.String key, int value);

/**
 * Set a long value in the preferences editor, to be written back once
 * {@link #commit} or {@link #apply} are called.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference.
 *
 * @return Returns a reference to the same Editor object, so you can
 * chain put calls together.
 */

public android.content.SharedPreferences.Editor putLong(java.lang.String key, long value);

/**
 * Set a float value in the preferences editor, to be written back once
 * {@link #commit} or {@link #apply} are called.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference.
 *
 * @return Returns a reference to the same Editor object, so you can
 * chain put calls together.
 */

public android.content.SharedPreferences.Editor putFloat(java.lang.String key, float value);

/**
 * Set a boolean value in the preferences editor, to be written back
 * once {@link #commit} or {@link #apply} are called.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference.
 *
 * @return Returns a reference to the same Editor object, so you can
 * chain put calls together.
 */

public android.content.SharedPreferences.Editor putBoolean(java.lang.String key, boolean value);

/**
 * Mark in the editor that a preference value should be removed, which
 * will be done in the actual preferences once {@link #commit} is
 * called.
 *
 * <p>Note that when committing back to the preferences, all removals
 * are done first, regardless of whether you called remove before
 * or after put methods on this editor.
 *
 * @param key The name of the preference to remove.
 *
 * @return Returns a reference to the same Editor object, so you can
 * chain put calls together.
 */

public android.content.SharedPreferences.Editor remove(java.lang.String key);

/**
 * Mark in the editor to remove <em>all</em> values from the
 * preferences.  Once commit is called, the only remaining preferences
 * will be any that you have defined in this editor.
 *
 * <p>Note that when committing back to the preferences, the clear
 * is done first, regardless of whether you called clear before
 * or after put methods on this editor.
 *
 * @return Returns a reference to the same Editor object, so you can
 * chain put calls together.
 */

public android.content.SharedPreferences.Editor clear();

/**
 * Commit your preferences changes back from this Editor to the
 * {@link SharedPreferences} object it is editing.  This atomically
 * performs the requested modifications, replacing whatever is currently
 * in the SharedPreferences.
 *
 * <p>Note that when two editors are modifying preferences at the same
 * time, the last one to call commit wins.
 *
 * <p>If you don't care about the return value and you're
 * using this from your application's main thread, consider
 * using {@link #apply} instead.
 *
 * @return Returns true if the new values were successfully written
 * to persistent storage.
 */

public boolean commit();

/**
 * Commit your preferences changes back from this Editor to the
 * {@link SharedPreferences} object it is editing.  This atomically
 * performs the requested modifications, replacing whatever is currently
 * in the SharedPreferences.
 *
 * <p>Note that when two editors are modifying preferences at the same
 * time, the last one to call apply wins.
 *
 * <p>Unlike {@link #commit}, which writes its preferences out
 * to persistent storage synchronously, {@link #apply}
 * commits its changes to the in-memory
 * {@link SharedPreferences} immediately but starts an
 * asynchronous commit to disk and you won't be notified of
 * any failures.  If another editor on this
 * {@link SharedPreferences} does a regular {@link #commit}
 * while a {@link #apply} is still outstanding, the
 * {@link #commit} will block until all async commits are
 * completed as well as the commit itself.
 *
 * <p>As {@link SharedPreferences} instances are singletons within
 * a process, it's safe to replace any instance of {@link #commit} with
 * {@link #apply} if you were already ignoring the return value.
 *
 * <p>You don't need to worry about Android component
 * lifecycles and their interaction with <code>apply()</code>
 * writing to disk.  The framework makes sure in-flight disk
 * writes from <code>apply()</code> complete before switching
 * states.
 *
 * <p class='note'>The SharedPreferences.Editor interface
 * isn't expected to be implemented directly.  However, if you
 * previously did implement it and are now getting errors
 * about missing <code>apply()</code>, you can simply call
 * {@link #commit} from <code>apply()</code>.
 */

public void apply();
}

/**
 * Interface definition for a callback to be invoked when a shared
 * preference is changed.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnSharedPreferenceChangeListener {

/**
 * Called when a shared preference is changed, added, or removed. This
 * may be called even if a preference is set to its existing value.
 *
 * <p>This callback will be run on your main thread.
 *
 * @param sharedPreferences The {@link SharedPreferences} that received
 *            the change.
 * @param key The key of the preference that was changed, added, or
 *            removed.
 */

public void onSharedPreferenceChanged(android.content.SharedPreferences sharedPreferences, java.lang.String key);
}

}

