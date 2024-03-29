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

import android.view.View;
import android.inputmethodservice.Keyboard.Key;
import java.util.List;

/**
 * A view that renders a virtual {@link Keyboard}. It handles rendering of keys and
 * detecting key presses and touch movements.
 *
 * @attr ref android.R.styleable#KeyboardView_keyBackground
 * @attr ref android.R.styleable#KeyboardView_keyPreviewLayout
 * @attr ref android.R.styleable#KeyboardView_keyPreviewOffset
 * @attr ref android.R.styleable#KeyboardView_keyPreviewHeight
 * @attr ref android.R.styleable#KeyboardView_labelTextSize
 * @attr ref android.R.styleable#KeyboardView_keyTextSize
 * @attr ref android.R.styleable#KeyboardView_keyTextColor
 * @attr ref android.R.styleable#KeyboardView_verticalCorrection
 * @attr ref android.R.styleable#KeyboardView_popupLayout
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class KeyboardView extends android.view.View implements android.view.View.OnClickListener {

public KeyboardView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public KeyboardView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public KeyboardView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

public void setOnKeyboardActionListener(android.inputmethodservice.KeyboardView.OnKeyboardActionListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link OnKeyboardActionListener} object.
 * @return the listener attached to this keyboard
 */

protected android.inputmethodservice.KeyboardView.OnKeyboardActionListener getOnKeyboardActionListener() { throw new RuntimeException("Stub!"); }

/**
 * Attaches a keyboard to this view. The keyboard can be switched at any time and the
 * view will re-layout itself to accommodate the keyboard.
 * @see Keyboard
 * @see #getKeyboard()
 * @param keyboard the keyboard to display in this view
 */

public void setKeyboard(android.inputmethodservice.Keyboard keyboard) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current keyboard being displayed by this view.
 * @return the currently attached keyboard
 * @see #setKeyboard(Keyboard)
 */

public android.inputmethodservice.Keyboard getKeyboard() { throw new RuntimeException("Stub!"); }

/**
 * Sets the state of the shift key of the keyboard, if any.
 * @param shifted whether or not to enable the state of the shift key
 * @return true if the shift key state changed, false if there was no change
 * @see KeyboardView#isShifted()
 */

public boolean setShifted(boolean shifted) { throw new RuntimeException("Stub!"); }

/**
 * Returns the state of the shift key of the keyboard, if any.
 * @return true if the shift is in a pressed state, false otherwise. If there is
 * no shift key on the keyboard or there is no keyboard attached, it returns false.
 * @see KeyboardView#setShifted(boolean)
 */

public boolean isShifted() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the key feedback popup. This is a popup that shows a magnified
 * version of the depressed key. By default the preview is enabled.
 * @param previewEnabled whether or not to enable the key feedback popup
 * @see #isPreviewEnabled()
 */

public void setPreviewEnabled(boolean previewEnabled) { throw new RuntimeException("Stub!"); }

/**
 * Returns the enabled state of the key feedback popup.
 * @return whether or not the key feedback popup is enabled
 * @see #setPreviewEnabled(boolean)
 */

public boolean isPreviewEnabled() { throw new RuntimeException("Stub!"); }

public void setVerticalCorrection(int verticalOffset) { throw new RuntimeException("Stub!"); }

public void setPopupParent(android.view.View v) { throw new RuntimeException("Stub!"); }

public void setPopupOffset(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * When enabled, calls to {@link OnKeyboardActionListener#onKey} will include key
 * codes for adjacent keys.  When disabled, only the primary key code will be
 * reported.
 * @param enabled whether or not the proximity correction is enabled
 */

public void setProximityCorrectionEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if proximity correction is enabled.
 */

public boolean isProximityCorrectionEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Popup keyboard close button clicked.
 * @hide
 */

public void onClick(android.view.View v) { throw new RuntimeException("Stub!"); }

public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

public void onSizeChanged(int w, int h, int oldw, int oldh) { throw new RuntimeException("Stub!"); }

public void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Requests a redraw of the entire keyboard. Calling {@link #invalidate} is not sufficient
 * because the keyboard renders the keys to an off-screen buffer and an invalidate() only
 * draws the cached buffer.
 * @see #invalidateKey(int)
 */

public void invalidateAllKeys() { throw new RuntimeException("Stub!"); }

/**
 * Invalidates a key so that it will be redrawn on the next repaint. Use this method if only
 * one key is changing it's content. Any changes that affect the position or size of the key
 * may not be honored.
 * @param keyIndex the index of the key in the attached {@link Keyboard}.
 * @see #invalidateAllKeys
 */

public void invalidateKey(int keyIndex) { throw new RuntimeException("Stub!"); }

/**
 * Called when a key is long pressed. By default this will open any popup keyboard associated
 * with this key through the attributes popupLayout and popupCharacters.
 * @param popupKey the key that was long pressed
 * @return true if the long press is handled, false otherwise. Subclasses should call the
 * method on the base class if the subclass doesn't wish to handle the call.
 */

protected boolean onLongPress(android.inputmethodservice.Keyboard.Key popupKey) { throw new RuntimeException("Stub!"); }

public boolean onHoverEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

public boolean onTouchEvent(android.view.MotionEvent me) { throw new RuntimeException("Stub!"); }

protected void swipeRight() { throw new RuntimeException("Stub!"); }

protected void swipeLeft() { throw new RuntimeException("Stub!"); }

protected void swipeUp() { throw new RuntimeException("Stub!"); }

protected void swipeDown() { throw new RuntimeException("Stub!"); }

public void closing() { throw new RuntimeException("Stub!"); }

public void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

public boolean handleBack() { throw new RuntimeException("Stub!"); }
/**
 * Listener for virtual keyboard events.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnKeyboardActionListener {

/**
 * Called when the user presses a key. This is sent before the {@link #onKey} is called.
 * For keys that repeat, this is only called once.
 * @param primaryCode the unicode of the key being pressed. If the touch is not on a valid
 * key, the value will be zero.
 */

public void onPress(int primaryCode);

/**
 * Called when the user releases a key. This is sent after the {@link #onKey} is called.
 * For keys that repeat, this is only called once.
 * @param primaryCode the code of the key that was released
 */

public void onRelease(int primaryCode);

/**
 * Send a key press to the listener.
 * @param primaryCode this is the key that was pressed
 * @param keyCodes the codes for all the possible alternative keys
 * with the primary code being the first. If the primary key code is
 * a single character such as an alphabet or number or symbol, the alternatives
 * will include other characters that may be on the same key or adjacent keys.
 * These codes are useful to correct for accidental presses of a key adjacent to
 * the intended key.
 */

public void onKey(int primaryCode, int[] keyCodes);

/**
 * Sends a sequence of characters to the listener.
 * @param text the sequence of characters to be displayed.
 */

public void onText(java.lang.CharSequence text);

/**
 * Called when the user quickly moves the finger from right to left.
 */

public void swipeLeft();

/**
 * Called when the user quickly moves the finger from left to right.
 */

public void swipeRight();

/**
 * Called when the user quickly moves the finger from up to down.
 */

public void swipeDown();

/**
 * Called when the user quickly moves the finger from down to up.
 */

public void swipeUp();
}

}

