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


/**
 * A container for multiple
 * {@link Preference} objects. It is a base class for  Preference objects that are
 * parents, such as {@link PreferenceCategory} and {@link PreferenceScreen}.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about building a settings UI with Preferences,
 * read the <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>
 * guide.</p>
 * </div>
 *
 * @attr ref android.R.styleable#PreferenceGroup_orderingFromXml
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class PreferenceGroup extends android.preference.Preference {

public PreferenceGroup(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public PreferenceGroup(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public PreferenceGroup(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Whether to order the {@link Preference} children of this group as they
 * are added. If this is false, the ordering will follow each Preference
 * order and default to alphabetic for those without an order.
 * <p>
 * If this is called after preferences are added, they will not be
 * re-ordered in the order they were added, hence call this method early on.
 *
 * @param orderingAsAdded Whether to order according to the order added.
 * @see Preference#setOrder(int)
 */

public void setOrderingAsAdded(boolean orderingAsAdded) { throw new RuntimeException("Stub!"); }

/**
 * Whether this group is ordering preferences in the order they are added.
 *
 * @return Whether this group orders based on the order the children are added.
 * @see #setOrderingAsAdded(boolean)
 */

public boolean isOrderingAsAdded() { throw new RuntimeException("Stub!"); }

/**
 * Called by the inflater to add an item to this group.
 */

public void addItemFromInflater(android.preference.Preference preference) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of children {@link Preference}s.
 * @return The number of preference children in this group.
 */

public int getPreferenceCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link Preference} at a particular index.
 *
 * @param index The index of the {@link Preference} to retrieve.
 * @return The {@link Preference}.
 */

public android.preference.Preference getPreference(int index) { throw new RuntimeException("Stub!"); }

/**
 * Adds a {@link Preference} at the correct position based on the
 * preference's order.
 *
 * @param preference The preference to add.
 * @return Whether the preference is now in this group.
 */

public boolean addPreference(android.preference.Preference preference) { throw new RuntimeException("Stub!"); }

/**
 * Removes a {@link Preference} from this group.
 *
 * @param preference The preference to remove.
 * @return Whether the preference was found and removed.
 */

public boolean removePreference(android.preference.Preference preference) { throw new RuntimeException("Stub!"); }

/**
 * Removes all {@link Preference Preferences} from this group.
 */

public void removeAll() { throw new RuntimeException("Stub!"); }

/**
 * Prepares a {@link Preference} to be added to the group.
 *
 * @param preference The preference to add.
 * @return Whether to allow adding the preference (true), or not (false).
 */

protected boolean onPrepareAddPreference(android.preference.Preference preference) { throw new RuntimeException("Stub!"); }

/**
 * Finds a {@link Preference} based on its key. If two {@link Preference}
 * share the same key (not recommended), the first to appear will be
 * returned (to retrieve the other preference with the same key, call this
 * method on the first preference). If this preference has the key, it will
 * not be returned.
 * <p>
 * This will recursively search for the preference into children that are
 * also {@link PreferenceGroup PreferenceGroups}.
 *
 * @param key The key of the preference to retrieve.
 * @return The {@link Preference} with the key, or null.
 */

public android.preference.Preference findPreference(java.lang.CharSequence key) { throw new RuntimeException("Stub!"); }

/**
 * Whether this preference group should be shown on the same screen as its
 * contained preferences.
 *
 * @return True if the contained preferences should be shown on the same
 *         screen as this preference.
 */

protected boolean isOnSameScreenAsChildren() { throw new RuntimeException("Stub!"); }

protected void onAttachedToActivity() { throw new RuntimeException("Stub!"); }

protected void onPrepareForRemoval() { throw new RuntimeException("Stub!"); }

public void notifyDependencyChange(boolean disableDependents) { throw new RuntimeException("Stub!"); }

protected void dispatchSaveInstanceState(android.os.Bundle container) { throw new RuntimeException("Stub!"); }

protected void dispatchRestoreInstanceState(android.os.Bundle container) { throw new RuntimeException("Stub!"); }
}

