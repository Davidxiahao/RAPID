/*
 * Copyright (C) 2008-2009 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.inputmethodservice;

import java.util.List;
import android.graphics.drawable.Drawable;

/**
 * Loads an XML description of a keyboard and stores the attributes of the keys. A keyboard
 * consists of rows of keys.
 * <p>The layout file for a keyboard contains XML that looks like the following snippet:</p>
 * <pre>
 * &lt;Keyboard
 *         android:keyWidth="%10p"
 *         android:keyHeight="50px"
 *         android:horizontalGap="2px"
 *         android:verticalGap="2px" &gt;
 *     &lt;Row android:keyWidth="32px" &gt;
 *         &lt;Key android:keyLabel="A" /&gt;
 *         ...
 *     &lt;/Row&gt;
 *     ...
 * &lt;/Keyboard&gt;
 * </pre>
 * @attr ref android.R.styleable#Keyboard_keyWidth
 * @attr ref android.R.styleable#Keyboard_keyHeight
 * @attr ref android.R.styleable#Keyboard_horizontalGap
 * @attr ref android.R.styleable#Keyboard_verticalGap
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Keyboard {

/**
 * Creates a keyboard from the given xml key layout file.
 * @param context the application or service context
 * @param xmlLayoutResId the resource file that contains the keyboard layout and keys.
 */

public Keyboard(android.content.Context context, int xmlLayoutResId) { throw new RuntimeException("Stub!"); }

/**
 * Creates a keyboard from the given xml key layout file. Weeds out rows
 * that have a keyboard mode defined but don't match the specified mode.
 * @param context the application or service context
 * @param xmlLayoutResId the resource file that contains the keyboard layout and keys.
 * @param modeId keyboard mode identifier
 * @param width sets width of keyboard
 * @param height sets height of keyboard
 */

public Keyboard(android.content.Context context, int xmlLayoutResId, int modeId, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Creates a keyboard from the given xml key layout file. Weeds out rows
 * that have a keyboard mode defined but don't match the specified mode.
 * @param context the application or service context
 * @param xmlLayoutResId the resource file that contains the keyboard layout and keys.
 * @param modeId keyboard mode identifier
 */

public Keyboard(android.content.Context context, int xmlLayoutResId, int modeId) { throw new RuntimeException("Stub!"); }

/**
 * <p>Creates a blank keyboard from the given resource file and populates it with the specified
 * characters in left-to-right, top-to-bottom fashion, using the specified number of columns.
 * </p>
 * <p>If the specified number of columns is -1, then the keyboard will fit as many keys as
 * possible in each row.</p>
 * @param context the application or service context
 * @param layoutTemplateResId the layout template file, containing no keys.
 * @param characters the list of characters to display on the keyboard. One key will be created
 * for each character.
 * @param columns the number of columns of keys to display. If this number is greater than the
 * number of keys that can fit in a row, it will be ignored. If this number is -1, the
 * keyboard will fit as many keys as possible in each row.
 */

public Keyboard(android.content.Context context, int layoutTemplateResId, java.lang.CharSequence characters, int columns, int horizontalPadding) { throw new RuntimeException("Stub!"); }

public java.util.List<android.inputmethodservice.Keyboard.Key> getKeys() { throw new RuntimeException("Stub!"); }

public java.util.List<android.inputmethodservice.Keyboard.Key> getModifierKeys() { throw new RuntimeException("Stub!"); }

protected int getHorizontalGap() { throw new RuntimeException("Stub!"); }

protected void setHorizontalGap(int gap) { throw new RuntimeException("Stub!"); }

protected int getVerticalGap() { throw new RuntimeException("Stub!"); }

protected void setVerticalGap(int gap) { throw new RuntimeException("Stub!"); }

protected int getKeyHeight() { throw new RuntimeException("Stub!"); }

protected void setKeyHeight(int height) { throw new RuntimeException("Stub!"); }

protected int getKeyWidth() { throw new RuntimeException("Stub!"); }

protected void setKeyWidth(int width) { throw new RuntimeException("Stub!"); }

/**
 * Returns the total height of the keyboard
 * @return the total height of the keyboard
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

public int getMinWidth() { throw new RuntimeException("Stub!"); }

public boolean setShifted(boolean shiftState) { throw new RuntimeException("Stub!"); }

public boolean isShifted() { throw new RuntimeException("Stub!"); }

public int getShiftKeyIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns the indices of the keys that are closest to the given point.
 * @param x the x-coordinate of the point
 * @param y the y-coordinate of the point
 * @return the array of integer indices for the nearest keys to the given point. If the given
 * point is out of range, then an array of size zero is returned.
 */

public int[] getNearestKeys(int x, int y) { throw new RuntimeException("Stub!"); }

protected android.inputmethodservice.Keyboard.Row createRowFromXml(android.content.res.Resources res, android.content.res.XmlResourceParser parser) { throw new RuntimeException("Stub!"); }

protected android.inputmethodservice.Keyboard.Key createKeyFromXml(android.content.res.Resources res, android.inputmethodservice.Keyboard.Row parent, int x, int y, android.content.res.XmlResourceParser parser) { throw new RuntimeException("Stub!"); }

public static final int EDGE_BOTTOM = 8; // 0x8

public static final int EDGE_LEFT = 1; // 0x1

public static final int EDGE_RIGHT = 2; // 0x2

public static final int EDGE_TOP = 4; // 0x4

public static final int KEYCODE_ALT = -6; // 0xfffffffa

public static final int KEYCODE_CANCEL = -3; // 0xfffffffd

public static final int KEYCODE_DELETE = -5; // 0xfffffffb

public static final int KEYCODE_DONE = -4; // 0xfffffffc

public static final int KEYCODE_MODE_CHANGE = -2; // 0xfffffffe

public static final int KEYCODE_SHIFT = -1; // 0xffffffff
/**
 * Class for describing the position and characteristics of a single key in the keyboard.
 *
 * @attr ref android.R.styleable#Keyboard_keyWidth
 * @attr ref android.R.styleable#Keyboard_keyHeight
 * @attr ref android.R.styleable#Keyboard_horizontalGap
 * @attr ref android.R.styleable#Keyboard_Key_codes
 * @attr ref android.R.styleable#Keyboard_Key_keyIcon
 * @attr ref android.R.styleable#Keyboard_Key_keyLabel
 * @attr ref android.R.styleable#Keyboard_Key_iconPreview
 * @attr ref android.R.styleable#Keyboard_Key_isSticky
 * @attr ref android.R.styleable#Keyboard_Key_isRepeatable
 * @attr ref android.R.styleable#Keyboard_Key_isModifier
 * @attr ref android.R.styleable#Keyboard_Key_popupKeyboard
 * @attr ref android.R.styleable#Keyboard_Key_popupCharacters
 * @attr ref android.R.styleable#Keyboard_Key_keyOutputText
 * @attr ref android.R.styleable#Keyboard_Key_keyEdgeFlags
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Key {

/** Create an empty key with no attributes. */

public Key(android.inputmethodservice.Keyboard.Row parent) { throw new RuntimeException("Stub!"); }

/** Create a key with the given top-left coordinate and extract its attributes from
 * the XML parser.
 * @param res resources associated with the caller's context
 * @param parent the row that this key belongs to. The row must already be attached to
 * a {@link Keyboard}.
 * @param x the x coordinate of the top-left
 * @param y the y coordinate of the top-left
 * @param parser the XML parser containing the attributes for this key
 */

public Key(android.content.res.Resources res, android.inputmethodservice.Keyboard.Row parent, int x, int y, android.content.res.XmlResourceParser parser) { throw new RuntimeException("Stub!"); }

/**
 * Informs the key that it has been pressed, in case it needs to change its appearance or
 * state.
 * @see #onReleased(boolean)
 */

public void onPressed() { throw new RuntimeException("Stub!"); }

/**
 * Changes the pressed state of the key.
 *
 * <p>Toggled state of the key will be flipped when all the following conditions are
 * fulfilled:</p>
 *
 * <ul>
 *     <li>This is a sticky key, that is, {@link #sticky} is {@code true}.
 *     <li>The parameter {@code inside} is {@code true}.
 *     <li>{@link android.os.Build.VERSION#SDK_INT} is greater than
 *         {@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1}.
 * </ul>
 *
 * @param inside whether the finger was released inside the key. Works only on Android M and
 * later. See the method document for details.
 * @see #onPressed()
 */

public void onReleased(boolean inside) { throw new RuntimeException("Stub!"); }

/**
 * Detects if a point falls inside this key.
 * @param x the x-coordinate of the point
 * @param y the y-coordinate of the point
 * @return whether or not the point falls inside the key. If the key is attached to an edge,
 * it will assume that all points between the key and the edge are considered to be inside
 * the key.
 */

public boolean isInside(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Returns the square of the distance between the center of the key and the given point.
 * @param x the x-coordinate of the point
 * @param y the y-coordinate of the point
 * @return the square of the distance of the point from the center of the key
 */

public int squaredDistanceFrom(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Returns the drawable state for the key, based on the current state and type of the key.
 * @return the drawable state of the key.
 * @see android.graphics.drawable.StateListDrawable#setState(int[])
 */

public int[] getCurrentDrawableState() { throw new RuntimeException("Stub!"); }

/** 
 * All the key codes (unicode or custom code) that this key could generate, zero'th
 * being the most important.
 */

public int[] codes;

/** 
 * Flags that specify the anchoring to edges of the keyboard for detecting touch events
 * that are just out of the boundary of the key. This is a bit mask of
 * {@link Keyboard#EDGE_LEFT}, {@link Keyboard#EDGE_RIGHT}, {@link Keyboard#EDGE_TOP} and
 * {@link Keyboard#EDGE_BOTTOM}.
 */

public int edgeFlags;

/** The horizontal gap before this key */

public int gap;

/** Height of the key, not including the gap */

public int height;

/** Icon to display instead of a label. Icon takes precedence over a label */

public android.graphics.drawable.Drawable icon;

/** Preview version of the icon, for the preview popup */

public android.graphics.drawable.Drawable iconPreview;

/** Label to display */

public java.lang.CharSequence label;

/** Whether this is a modifier key, such as Shift or Alt */

public boolean modifier;

/** If this is a sticky key, is it on? */

public boolean on;

/** Popup characters */

public java.lang.CharSequence popupCharacters;

/** 
 * If this key pops up a mini keyboard, this is the resource id for the XML layout for that
 * keyboard.
 */

public int popupResId;

/** The current pressed state of this key */

public boolean pressed;

/** Whether this key repeats itself when held down */

public boolean repeatable;

/** Whether this key is sticky, i.e., a toggle key */

public boolean sticky;

/** Text to output when pressed. This can be multiple characters, like ".com" */

public java.lang.CharSequence text;

/** Width of the key, not including the gap */

public int width;

/** X coordinate of the key in the keyboard layout */

public int x;

/** Y coordinate of the key in the keyboard layout */

public int y;
}

/**
 * Container for keys in the keyboard. All keys in a row are at the same Y-coordinate.
 * Some of the key size defaults can be overridden per row from what the {@link Keyboard}
 * defines.
 * @attr ref android.R.styleable#Keyboard_keyWidth
 * @attr ref android.R.styleable#Keyboard_keyHeight
 * @attr ref android.R.styleable#Keyboard_horizontalGap
 * @attr ref android.R.styleable#Keyboard_verticalGap
 * @attr ref android.R.styleable#Keyboard_Row_rowEdgeFlags
 * @attr ref android.R.styleable#Keyboard_Row_keyboardMode
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Row {

public Row(android.inputmethodservice.Keyboard parent) { throw new RuntimeException("Stub!"); }

public Row(android.content.res.Resources res, android.inputmethodservice.Keyboard parent, android.content.res.XmlResourceParser parser) { throw new RuntimeException("Stub!"); }

/** Default height of a key in this row. */

public int defaultHeight;

/** Default horizontal gap between keys in this row. */

public int defaultHorizontalGap;

/** Default width of a key in this row. */

public int defaultWidth;

/** The keyboard mode for this row */

public int mode;

/**
 * Edge flags for this row of keys. Possible values that can be assigned are
 * {@link Keyboard#EDGE_TOP EDGE_TOP} and {@link Keyboard#EDGE_BOTTOM EDGE_BOTTOM}
 */

public int rowEdgeFlags;

/** Vertical gap following this row. */

public int verticalGap;
}

}

