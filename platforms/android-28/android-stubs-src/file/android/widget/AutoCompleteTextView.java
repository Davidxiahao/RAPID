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

import android.view.View;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/**
 * <p>An editable text view that shows completion suggestions automatically
 * while the user is typing. The list of suggestions is displayed in a drop
 * down menu from which the user can choose an item to replace the content
 * of the edit box with.</p>
 *
 * <p>The drop down can be dismissed at any time by pressing the back key or,
 * if no item is selected in the drop down, by pressing the enter/dpad center
 * key.</p>
 *
 * <p>The list of suggestions is obtained from a data adapter and appears
 * only after a given number of characters defined by
 * {@link #getThreshold() the threshold}.</p>
 *
 * <p>The following code snippet shows how to create a text view which suggests
 * various countries names while the user is typing:</p>
 *
 * <pre class="prettyprint">
 * public class CountriesActivity extends Activity {
 *     protected void onCreate(Bundle icicle) {
 *         super.onCreate(icicle);
 *         setContentView(R.layout.countries);
 *
 *         ArrayAdapter&lt;String&gt; adapter = new ArrayAdapter&lt;String&gt;(this,
 *                 android.R.layout.simple_dropdown_item_1line, COUNTRIES);
 *         AutoCompleteTextView textView = (AutoCompleteTextView)
 *                 findViewById(R.id.countries_list);
 *         textView.setAdapter(adapter);
 *     }
 *
 *     private static final String[] COUNTRIES = new String[] {
 *         "Belgium", "France", "Italy", "Germany", "Spain"
 *     };
 * }
 * </pre>
 *
 * <p>See the <a href="{@docRoot}guide/topics/ui/controls/text.html">Text Fields</a>
 * guide.</p>
 *
 * @attr ref android.R.styleable#AutoCompleteTextView_completionHint
 * @attr ref android.R.styleable#AutoCompleteTextView_completionThreshold
 * @attr ref android.R.styleable#AutoCompleteTextView_completionHintView
 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownSelector
 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownAnchor
 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownWidth
 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownHeight
 * @attr ref android.R.styleable#ListPopupWindow_dropDownVerticalOffset
 * @attr ref android.R.styleable#ListPopupWindow_dropDownHorizontalOffset
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AutoCompleteTextView extends android.widget.EditText implements android.widget.Filter.FilterListener {

/**
 * Constructs a new auto-complete text view with the given context's theme.
 *
 * @param context The Context the view is running in, through which it can
 *                access the current theme, resources, etc.
 */

public AutoCompleteTextView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new auto-complete text view with the given context's theme
 * and the supplied attribute set.
 *
 * @param context The Context the view is running in, through which it can
 *                access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view.
 */

public AutoCompleteTextView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new auto-complete text view with the given context's theme,
 * the supplied attribute set, and default style attribute.
 *
 * @param context The Context the view is running in, through which it can
 *                access the current theme, resources, etc.
 * @param attrs The attributes of the XML tag that is inflating the view.
 * @param defStyleAttr An attribute in the current theme that contains a
 *                     reference to a style resource that supplies default
 *                     values for the view. Can be 0 to not look for
 *                     defaults.
 */

public AutoCompleteTextView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new auto-complete text view with the given context's theme,
 * the supplied attribute set, and default styles.
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
 */

public AutoCompleteTextView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new auto-complete text view with the given context, the
 * supplied attribute set, default styles, and the theme against which the
 * completion popup should be inflated.
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
 * @param popupTheme The theme against which the completion popup window
 *                   should be inflated. May be {@code null} to use the
 *                   view theme. If set, this will override any value
 *                   specified by
 *                   {@link android.R.styleable#AutoCompleteTextView_popupTheme}.
 */

public AutoCompleteTextView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes, android.content.res.Resources.Theme popupTheme) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public void setOnClickListener(android.view.View.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the optional hint text that is displayed at the bottom of the
 * the matching list.  This can be used as a cue to the user on how to
 * best use the list, or to provide extra information.</p>
 *
 * @param hint the text to be displayed to the user
 *
 * @see #getCompletionHint()
 *
 * @attr ref android.R.styleable#AutoCompleteTextView_completionHint
 */

public void setCompletionHint(java.lang.CharSequence hint) { throw new RuntimeException("Stub!"); }

/**
 * Gets the optional hint text displayed at the bottom of the the matching list.
 *
 * @return The hint text, if any
 *
 * @see #setCompletionHint(CharSequence)
 *
 * @attr ref android.R.styleable#AutoCompleteTextView_completionHint
 */

public java.lang.CharSequence getCompletionHint() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the current width for the auto-complete drop down list. This can
 * be a fixed width, or {@link ViewGroup.LayoutParams#MATCH_PARENT} to fill the screen, or
 * {@link ViewGroup.LayoutParams#WRAP_CONTENT} to fit the width of its anchor view.</p>
 *
 * @return the width for the drop down list
 *
 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownWidth
 */

public int getDropDownWidth() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the current width for the auto-complete drop down list. This can
 * be a fixed width, or {@link ViewGroup.LayoutParams#MATCH_PARENT} to fill the screen, or
 * {@link ViewGroup.LayoutParams#WRAP_CONTENT} to fit the width of its anchor view.</p>
 *
 * @param width the width to use
 *
 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownWidth
 */

public void setDropDownWidth(int width) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the current height for the auto-complete drop down list. This can
 * be a fixed height, or {@link ViewGroup.LayoutParams#MATCH_PARENT} to fill
 * the screen, or {@link ViewGroup.LayoutParams#WRAP_CONTENT} to fit the height
 * of the drop down's content.</p>
 *
 * @return the height for the drop down list
 *
 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownHeight
 */

public int getDropDownHeight() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the current height for the auto-complete drop down list. This can
 * be a fixed height, or {@link ViewGroup.LayoutParams#MATCH_PARENT} to fill
 * the screen, or {@link ViewGroup.LayoutParams#WRAP_CONTENT} to fit the height
 * of the drop down's content.</p>
 *
 * @param height the height to use
 *
 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownHeight
 */

public void setDropDownHeight(int height) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the id for the view that the auto-complete drop down list is anchored to.</p>
 *
 * @return the view's id, or {@link View#NO_ID} if none specified
 *
 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownAnchor
 */

public int getDropDownAnchor() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the view to which the auto-complete drop down list should anchor. The view
 * corresponding to this id will not be loaded until the next time it is needed to avoid
 * loading a view which is not yet instantiated.</p>
 *
 * @param id the id to anchor the drop down list view to
 *
 * @attr ref android.R.styleable#AutoCompleteTextView_dropDownAnchor
 */

public void setDropDownAnchor(int id) { throw new RuntimeException("Stub!"); }

/**
 * <p>Gets the background of the auto-complete drop-down list.</p>
 *
 * @return the background drawable
 *
 * @attr ref android.R.styleable#PopupWindow_popupBackground
 */

public android.graphics.drawable.Drawable getDropDownBackground() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the background of the auto-complete drop-down list.</p>
 *
 * @param d the drawable to set as the background
 *
 * @attr ref android.R.styleable#PopupWindow_popupBackground
 */

public void setDropDownBackgroundDrawable(android.graphics.drawable.Drawable d) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the background of the auto-complete drop-down list.</p>
 *
 * @param id the id of the drawable to set as the background
 *
 * @attr ref android.R.styleable#PopupWindow_popupBackground
 */

public void setDropDownBackgroundResource(int id) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the vertical offset used for the auto-complete drop-down list.</p>
 *
 * @param offset the vertical offset
 *
 * @attr ref android.R.styleable#ListPopupWindow_dropDownVerticalOffset
 */

public void setDropDownVerticalOffset(int offset) { throw new RuntimeException("Stub!"); }

/**
 * <p>Gets the vertical offset used for the auto-complete drop-down list.</p>
 *
 * @return the vertical offset
 *
 * @attr ref android.R.styleable#ListPopupWindow_dropDownVerticalOffset
 */

public int getDropDownVerticalOffset() { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the horizontal offset used for the auto-complete drop-down list.</p>
 *
 * @param offset the horizontal offset
 *
 * @attr ref android.R.styleable#ListPopupWindow_dropDownHorizontalOffset
 */

public void setDropDownHorizontalOffset(int offset) { throw new RuntimeException("Stub!"); }

/**
 * <p>Gets the horizontal offset used for the auto-complete drop-down list.</p>
 *
 * @return the horizontal offset
 *
 * @attr ref android.R.styleable#ListPopupWindow_dropDownHorizontalOffset
 */

public int getDropDownHorizontalOffset() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the number of characters the user must type before the drop
 * down list is shown.</p>
 *
 * @return the minimum number of characters to type to show the drop down
 *
 * @see #setThreshold(int)
 *
 * @attr ref android.R.styleable#AutoCompleteTextView_completionThreshold
 */

public int getThreshold() { throw new RuntimeException("Stub!"); }

/**
 * <p>Specifies the minimum number of characters the user has to type in the
 * edit box before the drop down list is shown.</p>
 *
 * <p>When <code>threshold</code> is less than or equals 0, a threshold of
 * 1 is applied.</p>
 *
 * @param threshold the number of characters to type before the drop down
 *                  is shown
 *
 * @see #getThreshold()
 *
 * @attr ref android.R.styleable#AutoCompleteTextView_completionThreshold
 */

public void setThreshold(int threshold) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the listener that will be notified when the user clicks an item
 * in the drop down list.</p>
 *
 * @param l the item click listener
 */

public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener l) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the listener that will be notified when the user selects an item
 * in the drop down list.</p>
 *
 * @param l the item selected listener
 */

public void setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener l) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the listener that is notified whenever the user clicks an item
 * in the drop down list.</p>
 *
 * @return the item click listener
 *
 * @deprecated Use {@link #getOnItemClickListener()} intead
 */

@Deprecated public android.widget.AdapterView.OnItemClickListener getItemClickListener() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the listener that is notified whenever the user selects an
 * item in the drop down list.</p>
 *
 * @return the item selected listener
 *
 * @deprecated Use {@link #getOnItemSelectedListener()} intead
 */

@Deprecated public android.widget.AdapterView.OnItemSelectedListener getItemSelectedListener() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the listener that is notified whenever the user clicks an item
 * in the drop down list.</p>
 *
 * @return the item click listener
 */

public android.widget.AdapterView.OnItemClickListener getOnItemClickListener() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the listener that is notified whenever the user selects an
 * item in the drop down list.</p>
 *
 * @return the item selected listener
 */

public android.widget.AdapterView.OnItemSelectedListener getOnItemSelectedListener() { throw new RuntimeException("Stub!"); }

/**
 * Set a listener that will be invoked whenever the AutoCompleteTextView's
 * list of completions is dismissed.
 * @param dismissListener Listener to invoke when completions are dismissed
 */

public void setOnDismissListener(android.widget.AutoCompleteTextView.OnDismissListener dismissListener) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns a filterable list adapter used for auto completion.</p>
 *
 * @return a data adapter used for auto completion
 */

public android.widget.ListAdapter getAdapter() { throw new RuntimeException("Stub!"); }

/**
 * <p>Changes the list of data used for auto completion. The provided list
 * must be a filterable list adapter.</p>
 *
 * <p>The caller is still responsible for managing any resources used by the adapter.
 * Notably, when the AutoCompleteTextView is closed or released, the adapter is not notified.
 * A common case is the use of {@link android.widget.CursorAdapter}, which
 * contains a {@link android.database.Cursor} that must be closed.  This can be done
 * automatically (see
 * {@link android.app.Activity#startManagingCursor(android.database.Cursor)
 * startManagingCursor()}),
 * or by manually closing the cursor when the AutoCompleteTextView is dismissed.</p>
 *
 * @param adapter the adapter holding the auto completion data
 *
 * @see #getAdapter()
 * @see android.widget.Filterable
 * @see android.widget.ListAdapter
 */

public <T extends android.widget.ListAdapter & android.widget.Filterable> void setAdapter(T adapter) { throw new RuntimeException("Stub!"); }

public boolean onKeyPreIme(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Returns <code>true</code> if the amount of text in the field meets
 * or exceeds the {@link #getThreshold} requirement.  You can override
 * this to impose a different standard for when filtering will be
 * triggered.
 */

public boolean enoughToFilter() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether the popup menu is showing.</p>
 *
 * @return true if the popup menu is showing, false otherwise
 */

public boolean isPopupShowing() { throw new RuntimeException("Stub!"); }

/**
 * <p>Converts the selected item from the drop down list into a sequence
 * of character that can be used in the edit box.</p>
 *
 * @param selectedItem the item selected by the user for completion
 *
 * @return a sequence of characters representing the selected suggestion
 */

protected java.lang.CharSequence convertSelectionToString(java.lang.Object selectedItem) { throw new RuntimeException("Stub!"); }

/**
 * <p>Clear the list selection.  This may only be temporary, as user input will often bring
 * it back.
 */

public void clearListSelection() { throw new RuntimeException("Stub!"); }

/**
 * Set the position of the dropdown view selection.
 *
 * @param position The position to move the selector to.
 */

public void setListSelection(int position) { throw new RuntimeException("Stub!"); }

/**
 * Get the position of the dropdown view selection, if there is one.  Returns
 * {@link ListView#INVALID_POSITION ListView.INVALID_POSITION} if there is no dropdown or if
 * there is no selection.
 *
 * @return the position of the current selection, if there is one, or
 * {@link ListView#INVALID_POSITION ListView.INVALID_POSITION} if not.
 *
 * @see ListView#getSelectedItemPosition()
 */

public int getListSelection() { throw new RuntimeException("Stub!"); }

/**
 * <p>Starts filtering the content of the drop down list. The filtering
 * pattern is the content of the edit box. Subclasses should override this
 * method to filter with a different pattern, for instance a substring of
 * <code>text</code>.</p>
 *
 * @param text the filtering pattern
 * @param keyCode the last character inserted in the edit box; beware that
 * this will be null when text is being added through a soft input method.
 */

protected void performFiltering(java.lang.CharSequence text, int keyCode) { throw new RuntimeException("Stub!"); }

/**
 * <p>Performs the text completion by converting the selected item from
 * the drop down list into a string, replacing the text box's content with
 * this string and finally dismissing the drop down menu.</p>
 */

public void performCompletion() { throw new RuntimeException("Stub!"); }

public void onCommitCompletion(android.view.inputmethod.CompletionInfo completion) { throw new RuntimeException("Stub!"); }

/**
 * Identifies whether the view is currently performing a text completion, so subclasses
 * can decide whether to respond to text changed events.
 */

public boolean isPerformingCompletion() { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #setText(CharSequence)}, except that it can disable filtering.
 *
 * @param filter If <code>false</code>, no filtering will be performed
 *        as a result of this call.
 */

public void setText(java.lang.CharSequence text, boolean filter) { throw new RuntimeException("Stub!"); }

/**
 * <p>Performs the text completion by replacing the current text by the
 * selected item. Subclasses should override this method to avoid replacing
 * the whole content of the edit box.</p>
 *
 * @param text the selected suggestion in the drop down list
 */

protected void replaceText(java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/** {@inheritDoc} */

public void onFilterComplete(int count) { throw new RuntimeException("Stub!"); }

public void onWindowFocusChanged(boolean hasWindowFocus) { throw new RuntimeException("Stub!"); }

protected void onDisplayHint(int hint) { throw new RuntimeException("Stub!"); }

protected void onFocusChanged(boolean focused, int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

/**
 * <p>Closes the drop down if present on screen.</p>
 */

public void dismissDropDown() { throw new RuntimeException("Stub!"); }

protected boolean setFrame(int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/**
 * <p>Displays the drop down on screen.</p>
 */

public void showDropDown() { throw new RuntimeException("Stub!"); }

/**
 * Sets the validator used to perform text validation.
 *
 * @param validator The validator used to validate the text entered in this widget.
 *
 * @see #getValidator()
 * @see #performValidation()
 */

public void setValidator(android.widget.AutoCompleteTextView.Validator validator) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Validator set with {@link #setValidator},
 * or <code>null</code> if it was not set.
 *
 * @see #setValidator(android.widget.AutoCompleteTextView.Validator)
 * @see #performValidation()
 */

public android.widget.AutoCompleteTextView.Validator getValidator() { throw new RuntimeException("Stub!"); }

/**
 * If a validator was set on this view and the current string is not valid,
 * ask the validator to fix it.
 *
 * @see #getValidator()
 * @see #setValidator(android.widget.AutoCompleteTextView.Validator)
 */

public void performValidation() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Filter obtained from {@link Filterable#getFilter},
 * or <code>null</code> if {@link #setAdapter} was not called with
 * a Filterable.
 */

protected android.widget.Filter getFilter() { throw new RuntimeException("Stub!"); }
/**
 * Listener to respond to the AutoCompleteTextView's completion list being dismissed.
 * @see AutoCompleteTextView#setOnDismissListener(OnDismissListener)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDismissListener {

/**
 * This method will be invoked whenever the AutoCompleteTextView's list
 * of completion options has been dismissed and is no longer available
 * for user interaction.
 */

public void onDismiss();
}

/**
 * This interface is used to make sure that the text entered in this TextView complies to
 * a certain format.  Since there is no foolproof way to prevent the user from leaving
 * this View with an incorrect value in it, all we can do is try to fix it ourselves
 * when this happens.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Validator {

/**
 * Validates the specified text.
 *
 * @return true If the text currently in the text editor is valid.
 *
 * @see #fixText(CharSequence)
 */

public boolean isValid(java.lang.CharSequence text);

/**
 * Corrects the specified text to make it valid.
 *
 * @param invalidText A string that doesn't pass validation: isValid(invalidText)
 *        returns false
 *
 * @return A string based on invalidText such as invoking isValid() on it returns true.
 *
 * @see #isValid(CharSequence)
 */

public java.lang.CharSequence fixText(java.lang.CharSequence invalidText);
}

}

