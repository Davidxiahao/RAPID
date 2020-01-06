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


package android.widget;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.view.ViewGroup;
import android.view.View;
import android.view.Gravity;
import android.os.Build;

/**
 * A view that displays one child at a time and lets the user pick among them.
 * The items in the Spinner come from the {@link Adapter} associated with
 * this view.
 *
 * <p>See the <a href="{@docRoot}guide/topics/ui/controls/spinner.html">Spinners</a> guide.</p>
 *
 * @attr ref android.R.styleable#Spinner_dropDownSelector
 * @attr ref android.R.styleable#Spinner_dropDownWidth
 * @attr ref android.R.styleable#Spinner_gravity
 * @attr ref android.R.styleable#Spinner_popupBackground
 * @attr ref android.R.styleable#Spinner_prompt
 * @attr ref android.R.styleable#Spinner_spinnerMode
 * @attr ref android.R.styleable#ListPopupWindow_dropDownVerticalOffset
 * @attr ref android.R.styleable#ListPopupWindow_dropDownHorizontalOffset
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Spinner extends android.widget.AbsSpinner implements android.content.DialogInterface.OnClickListener {

/**
 * Constructs a new spinner with the given context's theme.
 *
 * @param context The Context the view is running in, through which it can
 *                access the current theme, resources, etc.
 */

public Spinner(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new spinner with the given context's theme and the supplied
 * mode of displaying choices. <code>mode</code> may be one of
 * {@link #MODE_DIALOG} or {@link #MODE_DROPDOWN}.
 *
 * @param context The Context the view is running in, through which it can
 *                access the current theme, resources, etc.
 * @param mode Constant describing how the user will select choices from
 *             the spinner.
 *
 * @see #MODE_DIALOG
 * @see #MODE_DROPDOWN
 */

public Spinner(android.content.Context context, int mode) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new spinner with the given context's theme and the supplied
 * attribute set.
 *
 * @param context The Context the view is running in, through which it can
 *                access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view.
 */

public Spinner(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new spinner with the given context's theme, the supplied
 * attribute set, and default style attribute.
 *
 * @param context The Context the view is running in, through which it can
 *                access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * @param defStyleAttr An attribute in the current theme that contains a
 *                     reference to a style resource that supplies default
 *                     values for the view. Can be 0 to not look for
 *                     defaults.
 */

public Spinner(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new spinner with the given context's theme, the supplied
 * attribute set, and default style attribute. <code>mode</code> may be one
 * of {@link #MODE_DIALOG} or {@link #MODE_DROPDOWN} and determines how the
 * user will select choices from the spinner.
 *
 * @param context The Context the view is running in, through which it can
 *                access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * @param defStyleAttr An attribute in the current theme that contains a
 *                     reference to a style resource that supplies default
 *                     values for the view. Can be 0 to not look for defaults.
 * @param mode Constant describing how the user will select choices from the
 *             spinner.
 *
 * @see #MODE_DIALOG
 * @see #MODE_DROPDOWN
 */

public Spinner(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int mode) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new spinner with the given context's theme, the supplied
 * attribute set, and default styles. <code>mode</code> may be one of
 * {@link #MODE_DIALOG} or {@link #MODE_DROPDOWN} and determines how the
 * user will select choices from the spinner.
 *
 * @param context The Context the view is running in, through which it can
 *                access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * @param defStyleAttr An attribute in the current theme that contains a
 *                     reference to a style resource that supplies default
 *                     values for the view. Can be 0 to not look for
 *                     defaults.
 * @param defStyleRes A resource identifier of a style resource that
 *                    supplies default values for the view, used only if
 *                    defStyleAttr is 0 or can not be found in the theme.
 *                    Can be 0 to not look for defaults.
 * @param mode Constant describing how the user will select choices from
 *             the spinner.
 *
 * @see #MODE_DIALOG
 * @see #MODE_DROPDOWN
 */

public Spinner(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes, int mode) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new spinner with the given context, the supplied attribute
 * set, default styles, popup mode (one of {@link #MODE_DIALOG} or
 * {@link #MODE_DROPDOWN}), and the theme against which the popup should be
 * inflated.
 *
 * @param context The context against which the view is inflated, which
 *                provides access to the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * @param defStyleAttr An attribute in the current theme that contains a
 *                     reference to a style resource that supplies default
 *                     values for the view. Can be 0 to not look for
 *                     defaults.
 * @param defStyleRes A resource identifier of a style resource that
 *                    supplies default values for the view, used only if
 *                    defStyleAttr is 0 or can not be found in the theme.
 *                    Can be 0 to not look for defaults.
 * @param mode Constant describing how the user will select choices from
 *             the spinner.
 * @param popupTheme The theme against which the dialog or dropdown popup
 *                   should be inflated. May be {@code null} to use the
 *                   view theme. If set, this will override any value
 *                   specified by
 *                   {@link android.R.styleable#Spinner_popupTheme}.
 *
 * @see #MODE_DIALOG
 * @see #MODE_DROPDOWN
 */

public Spinner(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes, int mode, android.content.res.Resources.Theme popupTheme) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @return the context used to inflate the Spinner's popup or dialog window
 */

public android.content.Context getPopupContext() { throw new RuntimeException("Stub!"); }

/**
 * Set the background drawable for the spinner's popup window of choices.
 * Only valid in {@link #MODE_DROPDOWN}; this method is a no-op in other modes.
 *
 * @param background Background drawable
 *
 * @attr ref android.R.styleable#Spinner_popupBackground
 */

public void setPopupBackgroundDrawable(android.graphics.drawable.Drawable background) { throw new RuntimeException("Stub!"); }

/**
 * Set the background drawable for the spinner's popup window of choices.
 * Only valid in {@link #MODE_DROPDOWN}; this method is a no-op in other modes.
 *
 * @param resId Resource ID of a background drawable
 *
 * @attr ref android.R.styleable#Spinner_popupBackground
 */

public void setPopupBackgroundResource(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Get the background drawable for the spinner's popup window of choices.
 * Only valid in {@link #MODE_DROPDOWN}; other modes will return null.
 *
 * @return background Background drawable
 *
 * @attr ref android.R.styleable#Spinner_popupBackground
 */

public android.graphics.drawable.Drawable getPopupBackground() { throw new RuntimeException("Stub!"); }

/**
 * Set a vertical offset in pixels for the spinner's popup window of choices.
 * Only valid in {@link #MODE_DROPDOWN}; this method is a no-op in other modes.
 *
 * @param pixels Vertical offset in pixels
 *
 * @attr ref android.R.styleable#ListPopupWindow_dropDownVerticalOffset
 */

public void setDropDownVerticalOffset(int pixels) { throw new RuntimeException("Stub!"); }

/**
 * Get the configured vertical offset in pixels for the spinner's popup window of choices.
 * Only valid in {@link #MODE_DROPDOWN}; other modes will return 0.
 *
 * @return Vertical offset in pixels
 *
 * @attr ref android.R.styleable#ListPopupWindow_dropDownVerticalOffset
 */

public int getDropDownVerticalOffset() { throw new RuntimeException("Stub!"); }

/**
 * Set a horizontal offset in pixels for the spinner's popup window of choices.
 * Only valid in {@link #MODE_DROPDOWN}; this method is a no-op in other modes.
 *
 * @param pixels Horizontal offset in pixels
 *
 * @attr ref android.R.styleable#ListPopupWindow_dropDownHorizontalOffset
 */

public void setDropDownHorizontalOffset(int pixels) { throw new RuntimeException("Stub!"); }

/**
 * Get the configured horizontal offset in pixels for the spinner's popup window of choices.
 * Only valid in {@link #MODE_DROPDOWN}; other modes will return 0.
 *
 * @return Horizontal offset in pixels
 *
 * @attr ref android.R.styleable#ListPopupWindow_dropDownHorizontalOffset
 */

public int getDropDownHorizontalOffset() { throw new RuntimeException("Stub!"); }

/**
 * Set the width of the spinner's popup window of choices in pixels. This value
 * may also be set to {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT}
 * to match the width of the Spinner itself, or
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT} to wrap to the measured size
 * of contained dropdown list items.
 *
 * <p>Only valid in {@link #MODE_DROPDOWN}; this method is a no-op in other modes.</p>
 *
 * @param pixels Width in pixels, WRAP_CONTENT, or MATCH_PARENT
 *
 * @attr ref android.R.styleable#Spinner_dropDownWidth
 */

public void setDropDownWidth(int pixels) { throw new RuntimeException("Stub!"); }

/**
 * Get the configured width of the spinner's popup window of choices in pixels.
 * The returned value may also be {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT}
 * meaning the popup window will match the width of the Spinner itself, or
 * {@link android.view.ViewGroup.LayoutParams#WRAP_CONTENT} to wrap to the measured size
 * of contained dropdown list items.
 *
 * @return Width in pixels, WRAP_CONTENT, or MATCH_PARENT
 *
 * @attr ref android.R.styleable#Spinner_dropDownWidth
 */

public int getDropDownWidth() { throw new RuntimeException("Stub!"); }

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Describes how the selected item view is positioned. Currently only the horizontal component
 * is used. The default is determined by the current theme.
 *
 * @param gravity See {@link android.view.Gravity}
 *
 * @attr ref android.R.styleable#Spinner_gravity
 */

public void setGravity(int gravity) { throw new RuntimeException("Stub!"); }

/**
 * Describes how the selected item view is positioned. The default is determined by the
 * current theme.
 *
 * @return A {@link android.view.Gravity Gravity} value
 */

public int getGravity() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link SpinnerAdapter} used to provide the data which backs
 * this Spinner.
 * <p>
 * If this Spinner has a popup theme set in XML via the
 * {@link android.R.styleable#Spinner_popupTheme popupTheme} attribute, the
 * adapter should inflate drop-down views using the same theme. The easiest
 * way to achieve this is by using {@link #getPopupContext()} to obtain a
 * layout inflater for use in
 * {@link SpinnerAdapter#getDropDownView(int, View, ViewGroup)}.
 * <p>
 * Spinner overrides {@link Adapter#getViewTypeCount()} on the
 * Adapter associated with this view. Calling
 * {@link Adapter#getItemViewType(int) getItemViewType(int)} on the object
 * returned from {@link #getAdapter()} will always return 0. Calling
 * {@link Adapter#getViewTypeCount() getViewTypeCount()} will always return
 * 1. On API {@link Build.VERSION_CODES#LOLLIPOP} and above, attempting to set an
 * adapter with more than one view type will throw an
 * {@link IllegalArgumentException}.
 *
 * @param adapter the adapter to set
 *
 * @see AbsSpinner#setAdapter(SpinnerAdapter)
 * @throws IllegalArgumentException if the adapter has more than one view
 *         type
 */

public void setAdapter(android.widget.SpinnerAdapter adapter) { throw new RuntimeException("Stub!"); }

public int getBaseline() { throw new RuntimeException("Stub!"); }

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/**
 * <p>A spinner does not support item click events. Calling this method
 * will raise an exception.</p>
 * <p>Instead use {@link AdapterView#setOnItemSelectedListener}.
 *
 * @param l this listener will be ignored
 */

public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener l) { throw new RuntimeException("Stub!"); }

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/**
 * @see android.view.View#onLayout(boolean,int,int,int,int)
 *
 * Creates and positions all views
 *
 */

protected void onLayout(boolean changed, int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

public boolean performClick() { throw new RuntimeException("Stub!"); }

public void onClick(android.content.DialogInterface dialog, int which) { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the prompt to display when the dialog is shown.
 * @param prompt the prompt to set
 */

public void setPrompt(java.lang.CharSequence prompt) { throw new RuntimeException("Stub!"); }

/**
 * Sets the prompt to display when the dialog is shown.
 * @param promptId the resource ID of the prompt to display when the dialog is shown
 */

public void setPromptId(int promptId) { throw new RuntimeException("Stub!"); }

/**
 * @return The prompt to display when the dialog is shown
 */

public java.lang.CharSequence getPrompt() { throw new RuntimeException("Stub!"); }

public android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

public void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

public android.view.PointerIcon onResolvePointerIcon(android.view.MotionEvent event, int pointerIndex) { throw new RuntimeException("Stub!"); }

/**
 * Use a dialog window for selecting spinner options.
 */

public static final int MODE_DIALOG = 0; // 0x0

/**
 * Use a dropdown anchored to the Spinner for selecting spinner options.
 */

public static final int MODE_DROPDOWN = 1; // 0x1
}

