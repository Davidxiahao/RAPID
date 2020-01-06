/*
 * Copyright (C) 2008 The Android Open Source Project
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

import java.util.List;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.ViewConfiguration;
import android.view.View;
import android.view.LayoutInflater.Filter;

/**
 * A widget that enables the user to select a number from a predefined range.
 * There are two flavors of this widget and which one is presented to the user
 * depends on the current theme.
 * <ul>
 * <li>
 * If the current theme is derived from {@link android.R.style#Theme} the widget
 * presents the current value as an editable input field with an increment button
 * above and a decrement button below. Long pressing the buttons allows for a quick
 * change of the current value. Tapping on the input field allows to type in
 * a desired value.
 * </li>
 * <li>
 * If the current theme is derived from {@link android.R.style#Theme_Holo} or
 * {@link android.R.style#Theme_Holo_Light} the widget presents the current
 * value as an editable input field with a lesser value above and a greater
 * value below. Tapping on the lesser or greater value selects it by animating
 * the number axis up or down to make the chosen value current. Flinging up
 * or down allows for multiple increments or decrements of the current value.
 * Long pressing on the lesser and greater values also allows for a quick change
 * of the current value. Tapping on the current value allows to type in a
 * desired value.
 * </li>
 * </ul>
 * <p>
 * For an example of using this widget, see {@link android.widget.TimePicker}.
 * </p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NumberPicker extends android.widget.LinearLayout {

/**
 * Create a new number picker.
 *
 * @param context The application environment.
 */

public NumberPicker(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Create a new number picker.
 *
 * @param context The application environment.
 * @param attrs A collection of attributes.
 */

public NumberPicker(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Create a new number picker
 *
 * @param context the application environment.
 * @param attrs a collection of attributes.
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 */

public NumberPicker(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Create a new number picker
 *
 * @param context the application environment.
 * @param attrs a collection of attributes.
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 * @param defStyleRes A resource identifier of a style resource that
 *        supplies default values for the view, used only if
 *        defStyleAttr is 0 or can not be found in the theme. Can be 0
 *        to not look for defaults.
 */

public NumberPicker(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

public boolean onInterceptTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

public boolean dispatchTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

public boolean dispatchKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public boolean dispatchTrackballEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

protected boolean dispatchHoverEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

public void computeScroll() { throw new RuntimeException("Stub!"); }

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

public void scrollBy(int x, int y) { throw new RuntimeException("Stub!"); }

protected int computeVerticalScrollOffset() { throw new RuntimeException("Stub!"); }

protected int computeVerticalScrollRange() { throw new RuntimeException("Stub!"); }

protected int computeVerticalScrollExtent() { throw new RuntimeException("Stub!"); }

public int getSolidColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to be notified on change of the current value.
 *
 * @param onValueChangedListener The listener.
 */

public void setOnValueChangedListener(android.widget.NumberPicker.OnValueChangeListener onValueChangedListener) { throw new RuntimeException("Stub!"); }

/**
 * Set listener to be notified for scroll state changes.
 *
 * @param onScrollListener The listener.
 */

public void setOnScrollListener(android.widget.NumberPicker.OnScrollListener onScrollListener) { throw new RuntimeException("Stub!"); }

/**
 * Set the formatter to be used for formatting the current value.
 * <p>
 * Note: If you have provided alternative values for the values this
 * formatter is never invoked.
 * </p>
 *
 * @param formatter The formatter object. If formatter is <code>null</code>,
 *            {@link String#valueOf(int)} will be used.
 *@see #setDisplayedValues(String[])
 */

public void setFormatter(android.widget.NumberPicker.Formatter formatter) { throw new RuntimeException("Stub!"); }

/**
 * Set the current value for the number picker.
 * <p>
 * If the argument is less than the {@link NumberPicker#getMinValue()} and
 * {@link NumberPicker#getWrapSelectorWheel()} is <code>false</code> the
 * current value is set to the {@link NumberPicker#getMinValue()} value.
 * </p>
 * <p>
 * If the argument is less than the {@link NumberPicker#getMinValue()} and
 * {@link NumberPicker#getWrapSelectorWheel()} is <code>true</code> the
 * current value is set to the {@link NumberPicker#getMaxValue()} value.
 * </p>
 * <p>
 * If the argument is less than the {@link NumberPicker#getMaxValue()} and
 * {@link NumberPicker#getWrapSelectorWheel()} is <code>false</code> the
 * current value is set to the {@link NumberPicker#getMaxValue()} value.
 * </p>
 * <p>
 * If the argument is less than the {@link NumberPicker#getMaxValue()} and
 * {@link NumberPicker#getWrapSelectorWheel()} is <code>true</code> the
 * current value is set to the {@link NumberPicker#getMinValue()} value.
 * </p>
 *
 * @param value The current value.
 * @see #setWrapSelectorWheel(boolean)
 * @see #setMinValue(int)
 * @see #setMaxValue(int)
 */

public void setValue(int value) { throw new RuntimeException("Stub!"); }

public boolean performClick() { throw new RuntimeException("Stub!"); }

public boolean performLongClick() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether the selector wheel wraps when reaching the min/max value.
 *
 * @return True if the selector wheel wraps.
 *
 * @see #getMinValue()
 * @see #getMaxValue()
 */

public boolean getWrapSelectorWheel() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the selector wheel shown during flinging/scrolling should
 * wrap around the {@link NumberPicker#getMinValue()} and
 * {@link NumberPicker#getMaxValue()} values.
 * <p>
 * By default if the range (max - min) is more than the number of items shown
 * on the selector wheel the selector wheel wrapping is enabled.
 * </p>
 * <p>
 * <strong>Note:</strong> If the number of items, i.e. the range (
 * {@link #getMaxValue()} - {@link #getMinValue()}) is less than
 * the number of items shown on the selector wheel, the selector wheel will
 * not wrap. Hence, in such a case calling this method is a NOP.
 * </p>
 *
 * @param wrapSelectorWheel Whether to wrap.
 */

public void setWrapSelectorWheel(boolean wrapSelectorWheel) { throw new RuntimeException("Stub!"); }

/**
 * Sets the speed at which the numbers be incremented and decremented when
 * the up and down buttons are long pressed respectively.
 * <p>
 * The default value is 300 ms.
 * </p>
 *
 * @param intervalMillis The speed (in milliseconds) at which the numbers
 *            will be incremented and decremented.
 */

public void setOnLongPressUpdateInterval(long intervalMillis) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the picker.
 *
 * @return The value.
 */

public int getValue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the min value of the picker.
 *
 * @return The min value
 */

public int getMinValue() { throw new RuntimeException("Stub!"); }

/**
 * Sets the min value of the picker.
 *
 * @param minValue The min value inclusive.
 *
 * <strong>Note:</strong> The length of the displayed values array
 * set via {@link #setDisplayedValues(String[])} must be equal to the
 * range of selectable numbers which is equal to
 * {@link #getMaxValue()} - {@link #getMinValue()} + 1.
 */

public void setMinValue(int minValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the max value of the picker.
 *
 * @return The max value.
 */

public int getMaxValue() { throw new RuntimeException("Stub!"); }

/**
 * Sets the max value of the picker.
 *
 * @param maxValue The max value inclusive.
 *
 * <strong>Note:</strong> The length of the displayed values array
 * set via {@link #setDisplayedValues(String[])} must be equal to the
 * range of selectable numbers which is equal to
 * {@link #getMaxValue()} - {@link #getMinValue()} + 1.
 */

public void setMaxValue(int maxValue) { throw new RuntimeException("Stub!"); }

/**
 * Gets the values to be displayed instead of string values.
 *
 * @return The displayed values.
 */

public java.lang.String[] getDisplayedValues() { throw new RuntimeException("Stub!"); }

/**
 * Sets the values to be displayed.
 *
 * @param displayedValues The displayed values.
 *
 * <strong>Note:</strong> The length of the displayed values array
 * must be equal to the range of selectable numbers which is equal to
 * {@link #getMaxValue()} - {@link #getMinValue()} + 1.
 */

public void setDisplayedValues(java.lang.String[] displayedValues) { throw new RuntimeException("Stub!"); }

protected float getTopFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

protected float getBottomFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/** If you override this method you <em>must</em> call through to the
 *            superclass implementation. */

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

/** If you override this method you <em>must</em> call through to the
 *            superclass implementation. */

public void jumpDrawablesToCurrentState() { throw new RuntimeException("Stub!"); }

protected void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

public android.view.accessibility.AccessibilityNodeProvider getAccessibilityNodeProvider() { throw new RuntimeException("Stub!"); }
/**
 * Interface used to format current value into a string for presentation.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Formatter {

/**
 * Formats a string representation of the current value.
 *
 * @param value The currently selected value.
 * @return A formatted string representation.
 */

public java.lang.String format(int value);
}

/**
 * Interface to listen for the picker scroll state.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnScrollListener {

/**
 * Callback invoked while the number picker scroll state has changed.
 *
 * @param view The view whose scroll state is being reported.
 * @param scrollState The current scroll state. One of
 *            {@link #SCROLL_STATE_IDLE},
 *            {@link #SCROLL_STATE_TOUCH_SCROLL} or
 *            {@link #SCROLL_STATE_IDLE}.

 * Value is {@link android.widget.NumberPicker.OnScrollListener#SCROLL_STATE_IDLE}, {@link android.widget.NumberPicker.OnScrollListener#SCROLL_STATE_TOUCH_SCROLL}, or {@link android.widget.NumberPicker.OnScrollListener#SCROLL_STATE_FLING}
 */

public void onScrollStateChange(android.widget.NumberPicker view, int scrollState);

/**
 * The user had previously been scrolling using touch and performed a fling.
 */

public static final int SCROLL_STATE_FLING = 2; // 0x2

/**
 * The view is not scrolling.
 */

public static final int SCROLL_STATE_IDLE = 0; // 0x0

/**
 * The user is scrolling using touch, and his finger is still on the screen.
 */

public static final int SCROLL_STATE_TOUCH_SCROLL = 1; // 0x1
}

/**
 * Interface to listen for changes of the current value.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnValueChangeListener {

/**
 * Called upon a change of the current value.
 *
 * @param picker The NumberPicker associated with this listener.
 * @param oldVal The previous value.
 * @param newVal The new value.
 */

public void onValueChange(android.widget.NumberPicker picker, int oldVal, int newVal);
}

}

