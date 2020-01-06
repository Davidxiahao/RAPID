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


package android.widget;


/**
 * This widget is a layout that contains several specifically-named child views that
 * handle keyboard entry interpreted as standard phone dialpad digits.
 *
 * @deprecated Use a custom view or layout to handle this functionality instead
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public class DialerFilter extends android.widget.RelativeLayout {

public DialerFilter(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public DialerFilter(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

protected void onFinishInflate() { throw new RuntimeException("Stub!"); }

/**
 * Only show the icon view when focused, if there is one.
 */

protected void onFocusChanged(boolean focused, int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

public boolean isQwertyKeyboard() { throw new RuntimeException("Stub!"); }

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public int getMode() { throw new RuntimeException("Stub!"); }

/**
 * Change the mode of the widget.
 *
 * @param newMode The mode to switch to.
 */

public void setMode(int newMode) { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getLetters() { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getDigits() { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getFilterText() { throw new RuntimeException("Stub!"); }

public void append(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Clears both the digits and the filter text.
 */

public void clearText() { throw new RuntimeException("Stub!"); }

public void setLettersWatcher(android.text.TextWatcher watcher) { throw new RuntimeException("Stub!"); }

public void setDigitsWatcher(android.text.TextWatcher watcher) { throw new RuntimeException("Stub!"); }

public void setFilterWatcher(android.text.TextWatcher watcher) { throw new RuntimeException("Stub!"); }

public void removeFilterWatcher(android.text.TextWatcher watcher) { throw new RuntimeException("Stub!"); }

/**
 * Called right after the mode changes to give subclasses the option to
 * restyle, etc.
 */

protected void onModeChange(int oldMode, int newMode) { throw new RuntimeException("Stub!"); }

/** This mode has both lines */

public static final int DIGITS_AND_LETTERS = 1; // 0x1

/** This mode is when after starting in {@link #DIGITS_AND_LETTERS} mode the filter
 *  has removed all possibility of the digits matching, leaving only the letters line */

public static final int DIGITS_AND_LETTERS_NO_DIGITS = 2; // 0x2

/** This mode is when after starting in {@link #DIGITS_AND_LETTERS} mode the filter
 *  has removed all possibility of the letters matching, leaving only the digits line */

public static final int DIGITS_AND_LETTERS_NO_LETTERS = 3; // 0x3

/** This mode has only the digits line */

public static final int DIGITS_ONLY = 4; // 0x4

/** This mode has only the letters line */

public static final int LETTERS_ONLY = 5; // 0x5
}

