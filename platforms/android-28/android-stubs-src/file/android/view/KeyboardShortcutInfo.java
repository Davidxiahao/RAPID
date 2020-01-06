/*
 * Copyright (C) 2015 The Android Open Source Project
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

package android.view;


/**
 * Information about a Keyboard Shortcut.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class KeyboardShortcutInfo implements android.os.Parcelable {

/**
 * @param label The label that identifies the action performed by this shortcut.
 * @param keycode The keycode that triggers the shortcut. This should be a valid constant
 *     defined in {@link KeyEvent}.
 * @param modifiers The set of modifiers that, combined with the key, trigger the shortcut.
 *     These should be a combination of {@link KeyEvent#META_CTRL_ON},
 *     {@link KeyEvent#META_SHIFT_ON}, {@link KeyEvent#META_META_ON},
 *     {@link KeyEvent#META_ALT_ON}, {@link KeyEvent#META_FUNCTION_ON} and
 *     {@link KeyEvent#META_SYM_ON}.
 */

public KeyboardShortcutInfo(java.lang.CharSequence label, int keycode, int modifiers) { throw new RuntimeException("Stub!"); }

/**
 * @param label The label that identifies the action performed by this shortcut.
 * @param baseCharacter The character that triggers the shortcut.
 * @param modifiers The set of modifiers that, combined with the key, trigger the shortcut.
 *     These should be a combination of {@link KeyEvent#META_CTRL_ON},
 *     {@link KeyEvent#META_SHIFT_ON}, {@link KeyEvent#META_META_ON},
 *     {@link KeyEvent#META_ALT_ON}, {@link KeyEvent#META_FUNCTION_ON} and
 *     {@link KeyEvent#META_SYM_ON}.
 */

public KeyboardShortcutInfo(java.lang.CharSequence label, char baseCharacter, int modifiers) { throw new RuntimeException("Stub!"); }

/**
 * Returns the label to be used to describe this shortcut.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getLabel() { throw new RuntimeException("Stub!"); }

/**
 * Returns the base keycode that, combined with the modifiers, triggers this shortcut. If the
 * base character was set instead, returns {@link KeyEvent#KEYCODE_UNKNOWN}. Valid keycodes are
 * defined as constants in {@link KeyEvent}.
 */

public int getKeycode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the base character that, combined with the modifiers, triggers this shortcut. If the
 * keycode was set instead, returns {@link Character#MIN_VALUE}.
 */

public char getBaseCharacter() { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of modifiers that, combined with the key, trigger this shortcut. These can
 * be a combination of {@link KeyEvent#META_CTRL_ON}, {@link KeyEvent#META_SHIFT_ON},
 * {@link KeyEvent#META_META_ON}, {@link KeyEvent#META_ALT_ON},
 * {@link KeyEvent#META_FUNCTION_ON} and {@link KeyEvent#META_SYM_ON}.
 */

public int getModifiers() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.view.KeyboardShortcutInfo> CREATOR;
static { CREATOR = null; }
}

