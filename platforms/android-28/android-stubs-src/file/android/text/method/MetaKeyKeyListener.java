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


package android.text.method;

import android.view.KeyEvent;
import android.text.Editable;
import android.view.View;
import android.view.KeyCharacterMap;

/**
 * This base class encapsulates the behavior for tracking the state of
 * meta keys such as SHIFT, ALT and SYM as well as the pseudo-meta state of selecting text.
 * <p>
 * Key listeners that care about meta state should inherit from this class;
 * you should not instantiate this class directly in a client.
 * </p><p>
 * This class provides two mechanisms for tracking meta state that can be used
 * together or independently.
 * </p>
 * <ul>
 * <li>Methods such as {@link #handleKeyDown(long, int, KeyEvent)} and
 * {@link #getMetaState(long)} operate on a meta key state bit mask.</li>
 * <li>Methods such as {@link #onKeyDown(View, Editable, int, KeyEvent)} and
 * {@link #getMetaState(CharSequence, int)} operate on meta key state flags stored
 * as spans in an {@link Editable} text buffer.  The spans only describe the current
 * meta key state of the text editor; they do not carry any positional information.</li>
 * </ul>
 * <p>
 * The behavior of this class varies according to the keyboard capabilities
 * described by the {@link KeyCharacterMap} of the keyboard device such as
 * the {@link KeyCharacterMap#getModifierBehavior() key modifier behavior}.
 * </p><p>
 * {@link MetaKeyKeyListener} implements chorded and toggled key modifiers.
 * When key modifiers are toggled into a latched or locked state, the state
 * of the modifier is stored in the {@link Editable} text buffer or in a
 * meta state integer managed by the client.  These latched or locked modifiers
 * should be considered to be held <b>in addition to</b> those that the
 * keyboard already reported as being pressed in {@link KeyEvent#getMetaState()}.
 * In other words, the {@link MetaKeyKeyListener} augments the meta state
 * provided by the keyboard; it does not replace it.  This distinction is important
 * to ensure that meta keys not handled by {@link MetaKeyKeyListener} such as
 * {@link KeyEvent#KEYCODE_CAPS_LOCK} or {@link KeyEvent#KEYCODE_NUM_LOCK} are
 * taken into consideration.
 * </p><p>
 * To ensure correct meta key behavior, the following pattern should be used
 * when mapping key codes to characters:
 * </p>
 * <code>
 * private char getUnicodeChar(TextKeyListener listener, KeyEvent event, Editable textBuffer) {
 *     // Use the combined meta states from the event and the key listener.
 *     int metaState = event.getMetaState() | listener.getMetaState(textBuffer);
 *     return event.getUnicodeChar(metaState);
 * }
 * </code>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class MetaKeyKeyListener {

public MetaKeyKeyListener() { throw new RuntimeException("Stub!"); }

/**
 * Resets all meta state to inactive.
 */

public static void resetMetaState(android.text.Spannable text) { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of the meta keys.
 *
 * @param text the buffer in which the meta key would have been pressed.
 *
 * @return an integer in which each bit set to one represents a pressed
 *         or locked meta key.
 */

public static final int getMetaState(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of the meta keys for a specific key event.
 *
 * For input devices that use toggled key modifiers, the `toggled' state
 * is stored into the text buffer. This method retrieves the meta state
 * for this event, accounting for the stored state. If the event has been
 * created by a device that does not support toggled key modifiers, like
 * a virtual device for example, the stored state is ignored.
 *
 * @param text the buffer in which the meta key would have been pressed.
 * @param event the event for which to evaluate the meta state.
 * @return an integer in which each bit set to one represents a pressed
 *         or locked meta key.
 */

public static final int getMetaState(java.lang.CharSequence text, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of a particular meta key.
 *
 * @param meta META_SHIFT_ON, META_ALT_ON, META_SYM_ON
 * @param text the buffer in which the meta key would have been pressed.
 *
 * @return 0 if inactive, 1 if active, 2 if locked.
 */

public static final int getMetaState(java.lang.CharSequence text, int meta) { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of a particular meta key to use with a particular key event.
 *
 * If the key event has been created by a device that does not support toggled
 * key modifiers, like a virtual keyboard for example, only the meta state in
 * the key event is considered.
 *
 * @param meta META_SHIFT_ON, META_ALT_ON, META_SYM_ON
 * @param text the buffer in which the meta key would have been pressed.
 * @param event the event for which to evaluate the meta state.
 * @return 0 if inactive, 1 if active, 2 if locked.
 */

public static final int getMetaState(java.lang.CharSequence text, int meta, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Call this method after you handle a keypress so that the meta
 * state will be reset to unshifted (if it is not still down)
 * or primed to be reset to unshifted (once it is released).
 */

public static void adjustMetaAfterKeypress(android.text.Spannable content) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this object is one that this class would use to
 * keep track of any meta state in the specified text.
 */

public static boolean isMetaTracker(java.lang.CharSequence text, java.lang.Object what) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this object is one that this class would use to
 * keep track of the selecting meta state in the specified text.
 */

public static boolean isSelectingMetaTracker(java.lang.CharSequence text, java.lang.Object what) { throw new RuntimeException("Stub!"); }

/**
 * Call this if you are a method that ignores the locked meta state
 * (arrow keys, for example) and you handle a key.
 */

protected static void resetLockedMeta(android.text.Spannable content) { throw new RuntimeException("Stub!"); }

/**
 * Handles presses of the meta keys.
 */

public boolean onKeyDown(android.view.View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Handles release of the meta keys.
 */

public boolean onKeyUp(android.view.View view, android.text.Editable content, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public void clearMetaKeyState(android.view.View view, android.text.Editable content, int states) { throw new RuntimeException("Stub!"); }

public static void clearMetaKeyState(android.text.Editable content, int states) { throw new RuntimeException("Stub!"); }

/**
 * Call this if you are a method that ignores the locked meta state
 * (arrow keys, for example) and you handle a key.
 */

public static long resetLockedMeta(long state) { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of the meta keys.
 *
 * @param state the current meta state bits.
 *
 * @return an integer in which each bit set to one represents a pressed
 *         or locked meta key.
 */

public static final int getMetaState(long state) { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of a particular meta key.
 *
 * @param state the current state bits.
 * @param meta META_SHIFT_ON, META_ALT_ON, or META_SYM_ON
 *
 * @return 0 if inactive, 1 if active, 2 if locked.
 */

public static final int getMetaState(long state, int meta) { throw new RuntimeException("Stub!"); }

/**
 * Call this method after you handle a keypress so that the meta
 * state will be reset to unshifted (if it is not still down)
 * or primed to be reset to unshifted (once it is released).  Takes
 * the current state, returns the new state.
 */

public static long adjustMetaAfterKeypress(long state) { throw new RuntimeException("Stub!"); }

/**
 * Handles presses of the meta keys.
 */

public static long handleKeyDown(long state, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Handles release of the meta keys.
 */

public static long handleKeyUp(long state, int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Clears the state of the specified meta key if it is locked.
 * @param state the meta key state
 * @param which meta keys to clear, may be a combination of {@link #META_SHIFT_ON},
 * {@link #META_ALT_ON} or {@link #META_SYM_ON}.
 */

public long clearMetaKeyState(long state, int which) { throw new RuntimeException("Stub!"); }

/**
 * Flag that indicates that the ALT key is locked.
 */

public static final int META_ALT_LOCKED = 512; // 0x200

/**
 * Flag that indicates that the ALT key is on.
 * Value equals {@link KeyEvent#META_ALT_ON}.
 */

public static final int META_ALT_ON = 2; // 0x2

/**
 * Flag that indicates that the SHIFT key is locked in CAPS mode.
 */

public static final int META_CAP_LOCKED = 256; // 0x100

/**
 * Flag that indicates that the SHIFT key is on.
 * Value equals {@link KeyEvent#META_SHIFT_ON}.
 */

public static final int META_SHIFT_ON = 1; // 0x1

/**
 * Flag that indicates that the SYM key is locked.
 */

public static final int META_SYM_LOCKED = 1024; // 0x400

/**
 * Flag that indicates that the SYM key is on.
 * Value equals {@link KeyEvent#META_SYM_ON}.
 */

public static final int META_SYM_ON = 4; // 0x4
}

