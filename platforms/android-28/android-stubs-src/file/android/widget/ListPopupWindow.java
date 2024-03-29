/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.view.View;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.WindowManager;
import android.view.Gravity;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.KeyEvent;
import android.view.View.OnTouchListener;
import android.os.Build;
import android.view.ViewGroup;

/**
 * A ListPopupWindow anchors itself to a host view and displays a
 * list of choices.
 *
 * <p>ListPopupWindow contains a number of tricky behaviors surrounding
 * positioning, scrolling parents to fit the dropdown, interacting
 * sanely with the IME if present, and others.
 *
 * @see android.widget.AutoCompleteTextView
 * @see android.widget.Spinner
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ListPopupWindow {

/**
 * Create a new, empty popup window capable of displaying items from a ListAdapter.
 * Backgrounds should be set using {@link #setBackgroundDrawable(Drawable)}.
 *
 * @param context Context used for contained views.

 * This value must never be {@code null}.
 */

public ListPopupWindow(@androidx.annotation.RecentlyNonNull android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Create a new, empty popup window capable of displaying items from a ListAdapter.
 * Backgrounds should be set using {@link #setBackgroundDrawable(Drawable)}.
 *
 * @param context Context used for contained views.
 * This value must never be {@code null}.
 * @param attrs Attributes from inflating parent views used to style the popup.

 * This value may be {@code null}.
 */

public ListPopupWindow(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNullable android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Create a new, empty popup window capable of displaying items from a ListAdapter.
 * Backgrounds should be set using {@link #setBackgroundDrawable(Drawable)}.
 *
 * @param context Context used for contained views.
 * This value must never be {@code null}.
 * @param attrs Attributes from inflating parent views used to style the popup.
 * This value may be {@code null}.
 * @param defStyleAttr Default style attribute to use for popup content.
 */

public ListPopupWindow(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNullable android.util.AttributeSet attrs, int defStyleAttr) { throw new RuntimeException("Stub!"); }

/**
 * Create a new, empty popup window capable of displaying items from a ListAdapter.
 * Backgrounds should be set using {@link #setBackgroundDrawable(Drawable)}.
 *
 * @param context Context used for contained views.
 * This value must never be {@code null}.
 * @param attrs Attributes from inflating parent views used to style the popup.
 * This value may be {@code null}.
 * @param defStyleAttr Style attribute to read for default styling of popup content.
 * @param defStyleRes Style resource ID to use for default styling of popup content.
 */

public ListPopupWindow(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNullable android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { throw new RuntimeException("Stub!"); }

/**
 * Sets the adapter that provides the data and the views to represent the data
 * in this popup window.
 *
 * @param adapter The adapter to use to create this window's content.

 * This value may be {@code null}.
 */

public void setAdapter(@androidx.annotation.RecentlyNullable android.widget.ListAdapter adapter) { throw new RuntimeException("Stub!"); }

/**
 * Set where the optional prompt view should appear. The default is
 * {@link #POSITION_PROMPT_ABOVE}.
 *
 * @param position A position constant declaring where the prompt should be displayed.
 *
 * @see #POSITION_PROMPT_ABOVE
 * @see #POSITION_PROMPT_BELOW
 */

public void setPromptPosition(int position) { throw new RuntimeException("Stub!"); }

/**
 * @return Where the optional prompt view should appear.
 *
 * @see #POSITION_PROMPT_ABOVE
 * @see #POSITION_PROMPT_BELOW
 */

public int getPromptPosition() { throw new RuntimeException("Stub!"); }

/**
 * Set whether this window should be modal when shown.
 *
 * <p>If a popup window is modal, it will receive all touch and key input.
 * If the user touches outside the popup window's content area the popup window
 * will be dismissed.
 *
 * @param modal {@code true} if the popup window should be modal, {@code false} otherwise.
 */

public void setModal(boolean modal) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the popup window will be modal when shown.
 *
 * @return {@code true} if the popup window will be modal, {@code false} otherwise.
 */

public boolean isModal() { throw new RuntimeException("Stub!"); }

/**
 * Sets the operating mode for the soft input area.
 *
 * @param mode The desired mode, see
 *        {@link android.view.WindowManager.LayoutParams#softInputMode}
 *        for the full list
 *
 * @see android.view.WindowManager.LayoutParams#softInputMode
 * @see #getSoftInputMode()
 */

public void setSoftInputMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current value in {@link #setSoftInputMode(int)}.
 *
 * @see #setSoftInputMode(int)
 * @see android.view.WindowManager.LayoutParams#softInputMode
 */

public int getSoftInputMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets a drawable to use as the list item selector.
 *
 * @param selector List selector drawable to use in the popup.
 */

public void setListSelector(android.graphics.drawable.Drawable selector) { throw new RuntimeException("Stub!"); }

/**
 * @return The background drawable for the popup window.

 * This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.graphics.drawable.Drawable getBackground() { throw new RuntimeException("Stub!"); }

/**
 * Sets a drawable to be the background for the popup window.
 *
 * @param d A drawable to set as the background.

 * This value may be {@code null}.
 */

public void setBackgroundDrawable(@androidx.annotation.RecentlyNullable android.graphics.drawable.Drawable d) { throw new RuntimeException("Stub!"); }

/**
 * Set an animation style to use when the popup window is shown or dismissed.
 *
 * @param animationStyle Animation style to use.
 */

public void setAnimationStyle(int animationStyle) { throw new RuntimeException("Stub!"); }

/**
 * Returns the animation style that will be used when the popup window is
 * shown or dismissed.
 *
 * @return Animation style that will be used.
 */

public int getAnimationStyle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the view that will be used to anchor this popup.
 *
 * @return The popup's anchor view

 * This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.view.View getAnchorView() { throw new RuntimeException("Stub!"); }

/**
 * Sets the popup's anchor view. This popup will always be positioned relative to
 * the anchor view when shown.
 *
 * @param anchor The view to use as an anchor.

 * This value may be {@code null}.
 */

public void setAnchorView(@androidx.annotation.RecentlyNullable android.view.View anchor) { throw new RuntimeException("Stub!"); }

/**
 * @return The horizontal offset of the popup from its anchor in pixels.
 */

public int getHorizontalOffset() { throw new RuntimeException("Stub!"); }

/**
 * Set the horizontal offset of this popup from its anchor view in pixels.
 *
 * @param offset The horizontal offset of the popup from its anchor.
 */

public void setHorizontalOffset(int offset) { throw new RuntimeException("Stub!"); }

/**
 * @return The vertical offset of the popup from its anchor in pixels.
 */

public int getVerticalOffset() { throw new RuntimeException("Stub!"); }

/**
 * Set the vertical offset of this popup from its anchor view in pixels.
 *
 * @param offset The vertical offset of the popup from its anchor.
 */

public void setVerticalOffset(int offset) { throw new RuntimeException("Stub!"); }

/**
 * Set the gravity of the dropdown list. This is commonly used to
 * set gravity to START or END for alignment with the anchor.
 *
 * @param gravity Gravity value to use
 */

public void setDropDownGravity(int gravity) { throw new RuntimeException("Stub!"); }

/**
 * @return The width of the popup window in pixels.
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Sets the width of the popup window in pixels. Can also be {@link #MATCH_PARENT}
 * or {@link #WRAP_CONTENT}.
 *
 * @param width Width of the popup window.
 */

public void setWidth(int width) { throw new RuntimeException("Stub!"); }

/**
 * Sets the width of the popup window by the size of its content. The final width may be
 * larger to accommodate styled window dressing.
 *
 * @param width Desired width of content in pixels.
 */

public void setContentWidth(int width) { throw new RuntimeException("Stub!"); }

/**
 * @return The height of the popup window in pixels.
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Sets the height of the popup window in pixels. Can also be {@link #MATCH_PARENT}.
 *
 * @param height Height of the popup window must be a positive value,
 *               {@link #MATCH_PARENT}, or {@link #WRAP_CONTENT}.
 *
 * @throws IllegalArgumentException if height is set to negative value
 */

public void setHeight(int height) { throw new RuntimeException("Stub!"); }

/**
 * Set the layout type for this popup window.
 * <p>
 * See {@link WindowManager.LayoutParams#type} for possible values.
 *
 * @param layoutType Layout type for this window.
 *
 * @see WindowManager.LayoutParams#type
 */

public void setWindowLayoutType(int layoutType) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener to receive events when a list item is clicked.
 *
 * @param clickListener Listener to register
 *
 * This value may be {@code null}.
 * @see ListView#setOnItemClickListener(android.widget.AdapterView.OnItemClickListener)
 */

public void setOnItemClickListener(@androidx.annotation.RecentlyNullable android.widget.AdapterView.OnItemClickListener clickListener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener to receive events when a list item is selected.
 *
 * @param selectedListener Listener to register.
 *
 * This value may be {@code null}.
 * @see ListView#setOnItemSelectedListener(OnItemSelectedListener)
 */

public void setOnItemSelectedListener(@androidx.annotation.RecentlyNullable android.widget.AdapterView.OnItemSelectedListener selectedListener) { throw new RuntimeException("Stub!"); }

/**
 * Set a view to act as a user prompt for this popup window. Where the prompt view will appear
 * is controlled by {@link #setPromptPosition(int)}.
 *
 * @param prompt View to use as an informational prompt.

 * This value may be {@code null}.
 */

public void setPromptView(@androidx.annotation.RecentlyNullable android.view.View prompt) { throw new RuntimeException("Stub!"); }

/**
 * Post a {@link #show()} call to the UI thread.
 */

public void postShow() { throw new RuntimeException("Stub!"); }

/**
 * Show the popup list. If the list is already showing, this method
 * will recalculate the popup's size and position.
 */

public void show() { throw new RuntimeException("Stub!"); }

/**
 * Dismiss the popup window.
 */

public void dismiss() { throw new RuntimeException("Stub!"); }

/**
 * Set a listener to receive a callback when the popup is dismissed.
 *
 * @param listener Listener that will be notified when the popup is dismissed.

 * This value may be {@code null}.
 */

public void setOnDismissListener(@androidx.annotation.RecentlyNullable android.widget.PopupWindow.OnDismissListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Control how the popup operates with an input method: one of
 * {@link #INPUT_METHOD_FROM_FOCUSABLE}, {@link #INPUT_METHOD_NEEDED},
 * or {@link #INPUT_METHOD_NOT_NEEDED}.
 *
 * <p>If the popup is showing, calling this method will take effect only
 * the next time the popup is shown or through a manual call to the {@link #show()}
 * method.</p>
 *
 * @see #getInputMethodMode()
 * @see #show()
 */

public void setInputMethodMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Return the current value in {@link #setInputMethodMode(int)}.
 *
 * @see #setInputMethodMode(int)
 */

public int getInputMethodMode() { throw new RuntimeException("Stub!"); }

/**
 * Set the selected position of the list.
 * Only valid when {@link #isShowing()} == {@code true}.
 *
 * @param position List position to set as selected.
 */

public void setSelection(int position) { throw new RuntimeException("Stub!"); }

/**
 * Clear any current list selection.
 * Only valid when {@link #isShowing()} == {@code true}.
 */

public void clearListSelection() { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the popup is currently showing, {@code false} otherwise.
 */

public boolean isShowing() { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if this popup is configured to assume the user does not need
 * to interact with the IME while it is showing, {@code false} otherwise.
 */

public boolean isInputMethodNotNeeded() { throw new RuntimeException("Stub!"); }

/**
 * Perform an item click operation on the specified list adapter position.
 *
 * @param position Adapter position for performing the click
 * @return true if the click action could be performed, false if not.
 *         (e.g. if the popup was not showing, this method would return false.)
 */

public boolean performItemClick(int position) { throw new RuntimeException("Stub!"); }

/**
 * @return The currently selected item or null if the popup is not showing.
 */

@androidx.annotation.RecentlyNullable public java.lang.Object getSelectedItem() { throw new RuntimeException("Stub!"); }

/**
 * @return The position of the currently selected item or {@link ListView#INVALID_POSITION}
 * if {@link #isShowing()} == {@code false}.
 *
 * @see ListView#getSelectedItemPosition()
 */

public int getSelectedItemPosition() { throw new RuntimeException("Stub!"); }

/**
 * @return The ID of the currently selected item or {@link ListView#INVALID_ROW_ID}
 * if {@link #isShowing()} == {@code false}.
 *
 * @see ListView#getSelectedItemId()
 */

public long getSelectedItemId() { throw new RuntimeException("Stub!"); }

/**
 * @return The View for the currently selected item or null if
 * {@link #isShowing()} == {@code false}.
 *
 * @see ListView#getSelectedView()
 */

@androidx.annotation.RecentlyNullable public android.view.View getSelectedView() { throw new RuntimeException("Stub!"); }

/**
 * @return The {@link ListView} displayed within the popup window.
 * Only valid when {@link #isShowing()} == {@code true}.

 * This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.widget.ListView getListView() { throw new RuntimeException("Stub!"); }

/**
 * Filter key down events. By forwarding key down events to this function,
 * views using non-modal ListPopupWindow can have it handle key selection of items.
 *
 * @param keyCode keyCode param passed to the host view's onKeyDown
 * @param event event param passed to the host view's onKeyDown
 * This value must never be {@code null}.
 * @return true if the event was handled, false if it was ignored.
 *
 * @see #setModal(boolean)
 * @see #onKeyUp(int, KeyEvent)
 */

public boolean onKeyDown(int keyCode, @androidx.annotation.RecentlyNonNull android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Filter key up events. By forwarding key up events to this function,
 * views using non-modal ListPopupWindow can have it handle key selection of items.
 *
 * @param keyCode keyCode param passed to the host view's onKeyUp
 * @param event event param passed to the host view's onKeyUp
 * This value must never be {@code null}.
 * @return true if the event was handled, false if it was ignored.
 *
 * @see #setModal(boolean)
 * @see #onKeyDown(int, KeyEvent)
 */

public boolean onKeyUp(int keyCode, @androidx.annotation.RecentlyNonNull android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Filter pre-IME key events. By forwarding {@link View#onKeyPreIme(int, KeyEvent)}
 * events to this function, views using ListPopupWindow can have it dismiss the popup
 * when the back key is pressed.
 *
 * @param keyCode keyCode param passed to the host view's onKeyPreIme
 * @param event event param passed to the host view's onKeyPreIme
 * This value must never be {@code null}.
 * @return true if the event was handled, false if it was ignored.
 *
 * @see #setModal(boolean)
 */

public boolean onKeyPreIme(int keyCode, @androidx.annotation.RecentlyNonNull android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@link OnTouchListener} that can be added to the source view
 * to implement drag-to-open behavior. Generally, the source view should be
 * the same view that was passed to {@link #setAnchorView}.
 * <p>
 * When the listener is set on a view, touching that view and dragging
 * outside of its bounds will open the popup window. Lifting will select the
 * currently touched list item.
 * <p>
 * Example usage:
 * <pre>
 * ListPopupWindow myPopup = new ListPopupWindow(context);
 * myPopup.setAnchor(myAnchor);
 * OnTouchListener dragListener = myPopup.createDragToOpenListener(myAnchor);
 * myAnchor.setOnTouchListener(dragListener);
 * </pre>
 *
 * @param src the view on which the resulting listener will be set
 * @return a touch listener that controls drag-to-open behavior
 */

public android.view.View.OnTouchListener createDragToOpenListener(android.view.View src) { throw new RuntimeException("Stub!"); }

/**
 * Mode for {@link #setInputMethodMode(int)}: the requirements for the
 * input method should be based on the focusability of the popup.  That is
 * if it is focusable than it needs to work with the input method, else
 * it doesn't.
 */

public static final int INPUT_METHOD_FROM_FOCUSABLE = 0; // 0x0

/**
 * Mode for {@link #setInputMethodMode(int)}: this popup always needs to
 * work with an input method, regardless of whether it is focusable.  This
 * means that it will always be displayed so that the user can also operate
 * the input method while it is shown.
 */

public static final int INPUT_METHOD_NEEDED = 1; // 0x1

/**
 * Mode for {@link #setInputMethodMode(int)}: this popup never needs to
 * work with an input method, regardless of whether it is focusable.  This
 * means that it will always be displayed to use as much space on the
 * screen as needed, regardless of whether this covers the input method.
 */

public static final int INPUT_METHOD_NOT_NEEDED = 2; // 0x2

/**
 * Alias for {@link ViewGroup.LayoutParams#MATCH_PARENT}.
 * If used to specify a popup width, the popup will match the width of the anchor view.
 * If used to specify a popup height, the popup will fill available space.
 */

public static final int MATCH_PARENT = -1; // 0xffffffff

/**
 * The provided prompt view should appear above list content.
 *
 * @see #setPromptPosition(int)
 * @see #getPromptPosition()
 * @see #setPromptView(View)
 */

public static final int POSITION_PROMPT_ABOVE = 0; // 0x0

/**
 * The provided prompt view should appear below list content.
 *
 * @see #setPromptPosition(int)
 * @see #getPromptPosition()
 * @see #setPromptView(View)
 */

public static final int POSITION_PROMPT_BELOW = 1; // 0x1

/**
 * Alias for {@link ViewGroup.LayoutParams#WRAP_CONTENT}.
 * If used to specify a popup width, the popup will use the width of its content.
 */

public static final int WRAP_CONTENT = -2; // 0xfffffffe
}

