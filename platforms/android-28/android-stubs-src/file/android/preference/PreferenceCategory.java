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
 * Used to group {@link Preference} objects
 * and provide a disabled title above the group.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For information about building a settings UI with Preferences,
 * read the <a href="{@docRoot}guide/topics/ui/settings.html">Settings</a>
 * guide.</p>
 * </div>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PreferenceCategory extends android.preference.PreferenceGroup {

public PreferenceCategory(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null, (android.util.AttributeSet)null); throw new RuntimeException("Stub!"); }

public PreferenceCategory(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null, (android.util.AttributeSet)null); throw new RuntimeException("Stub!"); }

public PreferenceCategory(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null, (android.util.AttributeSet)null); throw new RuntimeException("Stub!"); }

public PreferenceCategory(android.content.Context context) { super((android.content.Context)null, (android.util.AttributeSet)null); throw new RuntimeException("Stub!"); }

protected boolean onPrepareAddPreference(android.preference.Preference preference) { throw new RuntimeException("Stub!"); }

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

public boolean shouldDisableDependents() { throw new RuntimeException("Stub!"); }
}

