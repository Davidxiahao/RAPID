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


package android.view;

import android.text.method.MetaKeyKeyListener;

/**
 * Describes the keys provided by a keyboard device and their associated labels.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class KeyCharacterMap implements android.os.Parcelable {

KeyCharacterMap(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Loads the key character maps for the keyboard with the specified device id.
 *
 * @param deviceId The device id of the keyboard.
 * @return The associated key character map.
 * @throws {@link UnavailableException} if the key character map
 * could not be loaded because it was malformed or the default key character map
 * is missing from the system.
 */

public static android.view.KeyCharacterMap load(int deviceId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the Unicode character generated by the specified key and meta
 * key state combination.
 * <p>
 * Returns the Unicode character that the specified key would produce
 * when the specified meta bits (see {@link MetaKeyKeyListener})
 * were active.
 * </p><p>
 * Returns 0 if the key is not one that is used to type Unicode
 * characters.
 * </p><p>
 * If the return value has bit {@link #COMBINING_ACCENT} set, the
 * key is a "dead key" that should be combined with another to
 * actually produce a character -- see {@link #getDeadChar} --
 * after masking with {@link #COMBINING_ACCENT_MASK}.
 * </p>
 *
 * @param keyCode The key code.
 * @param metaState The meta key modifier state.
 * @return The associated character or combining accent, or 0 if none.
 */

public int get(int keyCode, int metaState) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number or symbol associated with the key.
 * <p>
 * The character value is returned, not the numeric value.
 * If the key is not a number, but is a symbol, the symbol is retuned.
 * </p><p>
 * This method is intended to to support dial pads and other numeric or
 * symbolic entry on keyboards where certain keys serve dual function
 * as alphabetic and symbolic keys.  This method returns the number
 * or symbol associated with the key independent of whether the user
 * has pressed the required modifier.
 * </p><p>
 * For example, on one particular keyboard the keys on the top QWERTY row generate
 * numbers when ALT is pressed such that ALT-Q maps to '1'.  So for that keyboard
 * when {@link #getNumber} is called with {@link KeyEvent#KEYCODE_Q} it returns '1'
 * so that the user can type numbers without pressing ALT when it makes sense.
 * </p>
 *
 * @param keyCode The key code.
 * @return The associated numeric or symbolic character, or 0 if none.
 */

public char getNumber(int keyCode) { throw new RuntimeException("Stub!"); }

/**
 * Gets the first character in the character array that can be generated
 * by the specified key code.
 * <p>
 * This is a convenience function that returns the same value as
 * {@link #getMatch(int,char[],int) getMatch(keyCode, chars, 0)}.
 * </p>
 *
 * @param keyCode The keycode.
 * @param chars The array of matching characters to consider.
 * @return The matching associated character, or 0 if none.
 * @throws {@link IllegalArgumentException} if the passed array of characters is null.
 */

public char getMatch(int keyCode, char[] chars) { throw new RuntimeException("Stub!"); }

/**
 * Gets the first character in the character array that can be generated
 * by the specified key code.  If there are multiple choices, prefers
 * the one that would be generated with the specified meta key modifier state.
 *
 * @param keyCode The key code.
 * @param chars The array of matching characters to consider.
 * @param metaState The preferred meta key modifier state.
 * @return The matching associated character, or 0 if none.
 * @throws {@link IllegalArgumentException} if the passed array of characters is null.
 */

public char getMatch(int keyCode, char[] chars, int metaState) { throw new RuntimeException("Stub!"); }

/**
 * Gets the primary character for this key.
 * In other words, the label that is physically printed on it.
 *
 * @param keyCode The key code.
 * @return The display label character, or 0 if none (eg. for non-printing keys).
 */

public char getDisplayLabel(int keyCode) { throw new RuntimeException("Stub!"); }

/**
 * Get the character that is produced by combining the dead key producing accent
 * with the key producing character c.
 * For example, getDeadChar('`', 'e') returns &egrave;.
 * getDeadChar('^', ' ') returns '^' and getDeadChar('^', '^') returns '^'.
 *
 * @param accent The accent character.  eg. '`'
 * @param c The basic character.
 * @return The combined character, or 0 if the characters cannot be combined.
 */

public static int getDeadChar(int accent, int c) { throw new RuntimeException("Stub!"); }

/**
 * Get the character conversion data for a given key code.
 *
 * @param keyCode The keyCode to query.
 * @param results A {@link KeyData} instance that will be filled with the results.
 * @return True if the key was mapped.  If the key was not mapped, results is not modified.
 *
 * @deprecated instead use {@link KeyCharacterMap#getDisplayLabel(int)},
 * {@link KeyCharacterMap#getNumber(int)} or {@link KeyCharacterMap#get(int, int)}.
 */

@Deprecated public boolean getKeyData(int keyCode, android.view.KeyCharacterMap.KeyData results) { throw new RuntimeException("Stub!"); }

/**
 * Get an array of KeyEvent objects that if put into the input stream
 * could plausibly generate the provided sequence of characters.  It is
 * not guaranteed that the sequence is the only way to generate these
 * events or that it is optimal.
 * <p>
 * This function is primarily offered for instrumentation and testing purposes.
 * It may fail to map characters to key codes.  In particular, the key character
 * map for the {@link #BUILT_IN_KEYBOARD built-in keyboard} device id may be empty.
 * Consider using the key character map associated with the
 * {@link #VIRTUAL_KEYBOARD virtual keyboard} device id instead.
 * </p><p>
 * For robust text entry, do not use this function.  Instead construct a
 * {@link KeyEvent} with action code {@link KeyEvent#ACTION_MULTIPLE} that contains
 * the desired string using {@link KeyEvent#KeyEvent(long, String, int, int)}.
 * </p>
 *
 * @param chars The sequence of characters to generate.
 * @return An array of {@link KeyEvent} objects, or null if the given char array
 *         can not be generated using the current key character map.
 * @throws {@link IllegalArgumentException} if the passed array of characters is null.
 */

public android.view.KeyEvent[] getEvents(char[] chars) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the specified key produces a glyph.
 *
 * @param keyCode The key code.
 * @return True if the key is a printing key.
 */

public boolean isPrintingKey(int keyCode) { throw new RuntimeException("Stub!"); }

/**
 * Gets the keyboard type.
 * Returns {@link #NUMERIC}, {@link #PREDICTIVE}, {@link #ALPHA}, {@link #FULL}
 * or {@link #SPECIAL_FUNCTION}.
 * <p>
 * Different keyboard types have different semantics.  Refer to the documentation
 * associated with the keyboard type constants for details.
 * </p>
 *
 * @return The keyboard type.
 */

public int getKeyboardType() { throw new RuntimeException("Stub!"); }

/**
 * Gets a constant that describes the behavior of this keyboard's modifier keys
 * such as {@link KeyEvent#KEYCODE_SHIFT_LEFT}.
 * <p>
 * Currently there are two behaviors that may be combined:
 * </p>
 * <ul>
 * <li>Chorded behavior: When the modifier key is pressed together with one or more
 * character keys, the keyboard inserts the modified keys and
 * then resets the modifier state when the modifier key is released.</li>
 * <li>Toggled behavior: When the modifier key is pressed and released on its own
 * it first toggles into a latched state.  When latched, the modifier will apply
 * to next character key that is pressed and will then reset itself to the initial state.
 * If the modifier is already latched and the modifier key is pressed and release on
 * its own again, then it toggles into a locked state.  When locked, the modifier will
 * apply to all subsequent character keys that are pressed until unlocked by pressing
 * the modifier key on its own one more time to reset it to the initial state.
 * Toggled behavior is useful for small profile keyboards designed for thumb typing.
 * </ul>
 * <p>
 * This function currently returns {@link #MODIFIER_BEHAVIOR_CHORDED} when the
 * {@link #getKeyboardType() keyboard type} is {@link #FULL} or {@link #SPECIAL_FUNCTION} and
 * {@link #MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED} otherwise.
 * In the future, the function may also take into account global keyboard
 * accessibility settings, other user preferences, or new device capabilities.
 * </p>
 *
 * @return The modifier behavior for this keyboard.
 *
 * @see #MODIFIER_BEHAVIOR_CHORDED
 * @see #MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED
 */

public int getModifierBehavior() { throw new RuntimeException("Stub!"); }

/**
 * Queries the framework about whether any physical keys exist on the
 * any keyboard attached to the device that are capable of producing the given key code.
 *
 * @param keyCode The key code to query.
 * @return True if at least one attached keyboard supports the specified key code.
 */

public static boolean deviceHasKey(int keyCode) { throw new RuntimeException("Stub!"); }

/**
 * Queries the framework about whether any physical keys exist on the
 * any keyboard attached to the device that are capable of producing the given
 * array of key codes.
 *
 * @param keyCodes The array of key codes to query.
 * @return A new array of the same size as the key codes array whose elements
 * are set to true if at least one attached keyboard supports the corresponding key code
 * at the same index in the key codes array.
 */

public static boolean[] deviceHasKeys(int[] keyCodes) { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * A keyboard with all the letters, and maybe some numbers.
 * <p>
 * An alphabetic keyboard supports text entry directly but may have a condensed
 * layout with a small form factor.  In contrast to a {@link #FULL full keyboard}, some
 * symbols may only be accessible using special on-screen character pickers.
 * In addition, to improve typing speed and accuracy, the framework provides
 * special affordances for alphabetic keyboards such as auto-capitalization
 * and toggled / locked shift and alt keys.
 * </p><p>
 * This type of keyboard is generally designed for thumb typing.
 * </p>
 */

public static final int ALPHA = 3; // 0x3

/**
 * The id of the device's primary built in keyboard is always 0.
 *
 * @deprecated This constant should no longer be used because there is no
 * guarantee that a device has a built-in keyboard that can be used for
 * typing text.  There might not be a built-in keyboard, the built-in keyboard
 * might be a {@link #NUMERIC} or {@link #SPECIAL_FUNCTION} keyboard, or there
 * might be multiple keyboards installed including external keyboards.
 * When interpreting key presses received from the framework, applications should
 * use the device id specified in the {@link KeyEvent} received.
 * When synthesizing key presses for delivery elsewhere or when translating key presses
 * from unknown keyboards, applications should use the special {@link #VIRTUAL_KEYBOARD}
 * device id.
 */

@Deprecated public static final int BUILT_IN_KEYBOARD = 0; // 0x0

public static final int COMBINING_ACCENT = -2147483648; // 0x80000000

/**
 * Mask the return value from {@link #get(int, int)} with this value to get
 * a printable representation of the accent character of a "dead key."
 */

public static final int COMBINING_ACCENT_MASK = 2147483647; // 0x7fffffff

public static final android.os.Parcelable.Creator<android.view.KeyCharacterMap> CREATOR;
static { CREATOR = null; }

/**
 * A full PC-style keyboard.
 * <p>
 * A full keyboard behaves like a PC keyboard.  All symbols are accessed directly
 * by pressing keys on the keyboard without on-screen support or affordances such
 * as auto-capitalization.
 * </p><p>
 * This type of keyboard is generally designed for full two hand typing.
 * </p>
 */

public static final int FULL = 4; // 0x4

/**
 * This private-use character is used to trigger Unicode character
 * input by hex digits.
 */

public static final char HEX_INPUT = 61184; // 0xef00 '\uef00'

/**
 * Modifier keys may be chorded with character keys.
 *
 * @see {#link #getModifierBehavior()} for more details.
 */

public static final int MODIFIER_BEHAVIOR_CHORDED = 0; // 0x0

/**
 * Modifier keys may be chorded with character keys or they may toggle
 * into latched or locked states when pressed independently.
 *
 * @see {#link #getModifierBehavior()} for more details.
 */

public static final int MODIFIER_BEHAVIOR_CHORDED_OR_TOGGLED = 1; // 0x1

/**
 * A numeric (12-key) keyboard.
 * <p>
 * A numeric keyboard supports text entry using a multi-tap approach.
 * It may be necessary to tap a key multiple times to generate the desired letter
 * or symbol.
 * </p><p>
 * This type of keyboard is generally designed for thumb typing.
 * </p>
 */

public static final int NUMERIC = 1; // 0x1

/**
 * This private-use character is used to bring up a character picker for
 * miscellaneous symbols.
 */

public static final char PICKER_DIALOG_INPUT = 61185; // 0xef01 '\uef01'

/**
 * A keyboard with all the letters, but with more than one letter per key.
 * <p>
 * This type of keyboard is generally designed for thumb typing.
 * </p>
 */

public static final int PREDICTIVE = 2; // 0x2

/**
 * A keyboard that is only used to control special functions rather than for typing.
 * <p>
 * A special function keyboard consists only of non-printing keys such as
 * HOME and POWER that are not actually used for typing.
 * </p>
 */

public static final int SPECIAL_FUNCTION = 5; // 0x5

/**
 * The id of a generic virtual keyboard with a full layout that can be used to
 * synthesize key events.  Typically used with {@link #getEvents}.
 */

public static final int VIRTUAL_KEYBOARD = -1; // 0xffffffff
/**
 * Describes the character mappings associated with a key.
 *
 * @deprecated instead use {@link KeyCharacterMap#getDisplayLabel(int)},
 * {@link KeyCharacterMap#getNumber(int)} and {@link KeyCharacterMap#get(int, int)}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public static class KeyData {

public KeyData() { throw new RuntimeException("Stub!"); }

public static final int META_LENGTH = 4; // 0x4

/**
 * The display label (see {@link #getDisplayLabel}).
 */

public char displayLabel;

/**
 * The character that will be generated in various meta states
 * (the same ones used for {@link #get} and defined as
 * {@link KeyEvent#META_SHIFT_ON} and {@link KeyEvent#META_ALT_ON}).
 *      <table>
 *          <tr><th>Index</th><th align="left">Value</th></tr>
 *          <tr><td>0</td><td>no modifiers</td></tr>
 *          <tr><td>1</td><td>caps</td></tr>
 *          <tr><td>2</td><td>alt</td></tr>
 *          <tr><td>3</td><td>caps + alt</td></tr>
 *      </table>
 */

public char[] meta;

/**
 * The "number" value (see {@link #getNumber}).
 */

public char number;
}

/**
 * Thrown by {@link KeyCharacterMap#load} when a key character map could not be loaded.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class UnavailableException extends android.util.AndroidRuntimeException {

public UnavailableException(java.lang.String msg) { throw new RuntimeException("Stub!"); }
}

}

