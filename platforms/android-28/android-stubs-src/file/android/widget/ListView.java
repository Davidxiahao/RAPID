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

import java.util.List;
import android.view.ViewGroup;
import android.view.View;
import android.widget.RemoteViews.RemoteView;
import android.graphics.drawable.Drawable;
import java.util.function.Predicate;

/**
 * <p>Displays a vertically-scrollable collection of views, where each view is positioned
 * immediatelybelow the previous view in the list.  For a more modern, flexible, and performant
 * approach to displaying lists, use {@link android.support.v7.widget.RecyclerView}.</p>
 *
 * <p>To display a list, you can include a list view in your layout XML file:</p>
 *
 * <pre>&lt;ListView
 *      android:id="@+id/list_view"
 *      android:layout_width="match_parent"
 *      android:layout_height="match_parent" /&gt;</pre>
 *
 * <p>A list view is an <a href="{@docRoot}guide/topics/ui/declaring-layout.html#AdapterViews">
 * adapter view</a> that does not know the details, such as type and contents, of the views it
 * contains. Instead list view requests views on demand from a {@link ListAdapter} as needed,
 * such as to display new views as the user scrolls up or down.</p>
 *
 * <p>In order to display items in the list, call {@link #setAdapter(ListAdapter adapter)}
 * to associate an adapter with the list.  For a simple example, see the discussion of filling an
 * adapter view with text in the
 * <a href="{@docRoot}guide/topics/ui/declaring-layout.html#FillingTheLayout">
 * Layouts</a> guide.</p>
 *
 * <p>To display a more custom view for each item in your dataset, implement a ListAdapter.
 * For example, extend {@link BaseAdapter} and create and configure the view for each data item in
 * {@code getView(...)}:</p>
 *
 *  <pre>private class MyAdapter extends BaseAdapter {
 *
 *      // override other abstract methods here
 *
 *      &#64;Override
 *      public View getView(int position, View convertView, ViewGroup container) {
 *          if (convertView == null) {
 *              convertView = getLayoutInflater().inflate(R.layout.list_item, container, false);
 *          }
 *
 *          ((TextView) convertView.findViewById(android.R.id.text1))
 *                  .setText(getItem(position));
 *          return convertView;
 *      }
 *  }</pre>
 *
 * <p class="note">ListView attempts to reuse view objects in order to improve performance and
 * avoid a lag in response to user scrolls.  To take advantage of this feature, check if the
 * {@code convertView} provided to {@code getView(...)} is null before creating or inflating a new
 * view object.  See
 * <a href="{@docRoot}training/improving-layouts/smooth-scrolling.html">
 * Making ListView Scrolling Smooth</a> for more ways to ensure a smooth user experience.</p>
 *
 * <p>For a more complete example of creating a custom adapter, see the
 * <a href="{@docRoot}samples/CustomChoiceList/index.html">
 *     Custom Choice List</a> sample app.</p>
 *
 * <p>To specify an action when a user clicks or taps on a single list item, see
 * <a href="{@docRoot}guide/topics/ui/declaring-layout.html#HandlingUserSelections">
 *     Handling click events</a>.</p>
 *
 * <p>To learn how to populate a list view with a CursorAdapter, see the discussion of filling an
 * adapter view with text in the
 * <a href="{@docRoot}guide/topics/ui/declaring-layout.html#FillingTheLayout">
 * Layouts</a> guide.
 * See <a href="{@docRoot}guide/topics/ui/layout/listview.html">
 *     Using a Loader</a>
 * to learn how to avoid blocking the main thread when using a cursor.</p>
 *
 * <p class="note">Note, many examples use {@link android.app.ListActivity ListActivity}
 * or {@link android.app.ListFragment ListFragment}
 * to display a list view. Instead, favor the more flexible approach when writing your own app:
 * use a more generic Activity subclass or Fragment subclass and add a list view to the layout
 * or view hierarchy directly.  This approach gives you more direct control of the
 * list view and adapter.</p>
 *
 * @attr ref android.R.styleable#ListView_entries
 * @attr ref android.R.styleable#ListView_divider
 * @attr ref android.R.styleable#ListView_dividerHeight
 * @attr ref android.R.styleable#ListView_headerDividersEnabled
 * @attr ref android.R.styleable#ListView_footerDividersEnabled
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView public class ListView extends android.widget.AbsListView {

public ListView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ListView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ListView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ListView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * @return The maximum amount a list view will scroll in response to
 *   an arrow event.
 */

public int getMaxScrollAmount() { throw new RuntimeException("Stub!"); }

/**
 * Add a fixed view to appear at the top of the list. If this method is
 * called more than once, the views will appear in the order they were
 * added. Views added using this call can take focus if they want.
 * <p>
 * Note: When first introduced, this method could only be called before
 * setting the adapter with {@link #setAdapter(ListAdapter)}. Starting with
 * {@link android.os.Build.VERSION_CODES#KITKAT}, this method may be
 * called at any time. If the ListView's adapter does not extend
 * {@link HeaderViewListAdapter}, it will be wrapped with a supporting
 * instance of {@link WrapperListAdapter}.
 *
 * @param v The view to add.
 * @param data Data to associate with this view
 * @param isSelectable whether the item is selectable
 */

public void addHeaderView(android.view.View v, java.lang.Object data, boolean isSelectable) { throw new RuntimeException("Stub!"); }

/**
 * Add a fixed view to appear at the top of the list. If addHeaderView is
 * called more than once, the views will appear in the order they were
 * added. Views added using this call can take focus if they want.
 * <p>
 * Note: When first introduced, this method could only be called before
 * setting the adapter with {@link #setAdapter(ListAdapter)}. Starting with
 * {@link android.os.Build.VERSION_CODES#KITKAT}, this method may be
 * called at any time. If the ListView's adapter does not extend
 * {@link HeaderViewListAdapter}, it will be wrapped with a supporting
 * instance of {@link WrapperListAdapter}.
 *
 * @param v The view to add.
 */

public void addHeaderView(android.view.View v) { throw new RuntimeException("Stub!"); }

public int getHeaderViewsCount() { throw new RuntimeException("Stub!"); }

/**
 * Removes a previously-added header view.
 *
 * @param v The view to remove
 * @return true if the view was removed, false if the view was not a header
 *         view
 */

public boolean removeHeaderView(android.view.View v) { throw new RuntimeException("Stub!"); }

/**
 * Add a fixed view to appear at the bottom of the list. If addFooterView is
 * called more than once, the views will appear in the order they were
 * added. Views added using this call can take focus if they want.
 * <p>
 * Note: When first introduced, this method could only be called before
 * setting the adapter with {@link #setAdapter(ListAdapter)}. Starting with
 * {@link android.os.Build.VERSION_CODES#KITKAT}, this method may be
 * called at any time. If the ListView's adapter does not extend
 * {@link HeaderViewListAdapter}, it will be wrapped with a supporting
 * instance of {@link WrapperListAdapter}.
 *
 * @param v The view to add.
 * @param data Data to associate with this view
 * @param isSelectable true if the footer view can be selected
 */

public void addFooterView(android.view.View v, java.lang.Object data, boolean isSelectable) { throw new RuntimeException("Stub!"); }

/**
 * Add a fixed view to appear at the bottom of the list. If addFooterView is
 * called more than once, the views will appear in the order they were
 * added. Views added using this call can take focus if they want.
 * <p>
 * Note: When first introduced, this method could only be called before
 * setting the adapter with {@link #setAdapter(ListAdapter)}. Starting with
 * {@link android.os.Build.VERSION_CODES#KITKAT}, this method may be
 * called at any time. If the ListView's adapter does not extend
 * {@link HeaderViewListAdapter}, it will be wrapped with a supporting
 * instance of {@link WrapperListAdapter}.
 *
 * @param v The view to add.
 */

public void addFooterView(android.view.View v) { throw new RuntimeException("Stub!"); }

public int getFooterViewsCount() { throw new RuntimeException("Stub!"); }

/**
 * Removes a previously-added footer view.
 *
 * @param v The view to remove
 * @return
 * true if the view was removed, false if the view was not a footer view
 */

public boolean removeFooterView(android.view.View v) { throw new RuntimeException("Stub!"); }

/**
 * Returns the adapter currently in use in this ListView. The returned adapter
 * might not be the same adapter passed to {@link #setAdapter(ListAdapter)} but
 * might be a {@link WrapperListAdapter}.
 *
 * @return The adapter currently used to display data in this ListView.
 *
 * @see #setAdapter(ListAdapter)
 */

public android.widget.ListAdapter getAdapter() { throw new RuntimeException("Stub!"); }

/**
 * Sets up this AbsListView to use a remote views adapter which connects to a RemoteViewsService
 * through the specified intent.
 * @param intent the intent used to identify the RemoteViewsService for the adapter to connect to.
 */

public void setRemoteViewsAdapter(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Sets the data behind this ListView.
 *
 * The adapter passed to this method may be wrapped by a {@link WrapperListAdapter},
 * depending on the ListView features currently in use. For instance, adding
 * headers and/or footers will cause the adapter to be wrapped.
 *
 * @param adapter The ListAdapter which is responsible for maintaining the
 *        data backing this list and for producing a view to represent an
 *        item in that data set.
 *
 * @see #getAdapter()
 */

public void setAdapter(android.widget.ListAdapter adapter) { throw new RuntimeException("Stub!"); }

public boolean requestChildRectangleOnScreen(android.view.View child, android.graphics.Rect rect, boolean immediate) { throw new RuntimeException("Stub!"); }

/**
 * Smoothly scroll to the specified adapter position. The view will
 * scroll such that the indicated position is displayed.
 * @param position Scroll to this adapter position.
 */

public void smoothScrollToPosition(int position) { throw new RuntimeException("Stub!"); }

/**
 * Smoothly scroll to the specified adapter position offset. The view will
 * scroll such that the indicated position is displayed.
 * @param offset The amount to offset from the adapter position to scroll to.
 */

public void smoothScrollByOffset(int offset) { throw new RuntimeException("Stub!"); }

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

protected void onSizeChanged(int w, int h, int oldw, int oldh) { throw new RuntimeException("Stub!"); }

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

protected void layoutChildren() { throw new RuntimeException("Stub!"); }

protected boolean canAnimate() { throw new RuntimeException("Stub!"); }

/**
 * Sets the currently selected item. If in touch mode, the item will not be selected
 * but it will still be positioned appropriately. If the specified selection position
 * is less than 0, then the item at position 0 will be selected.
 *
 * @param position Index (starting at 0) of the data item to be selected.
 */

public void setSelection(int position) { throw new RuntimeException("Stub!"); }

/**
 * setSelectionAfterHeaderView set the selection to be the first list item
 * after the header views.
 */

public void setSelectionAfterHeaderView() { throw new RuntimeException("Stub!"); }

public boolean dispatchKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public boolean onKeyMultiple(int keyCode, int repeatCount, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the views created by the ListAdapter can contain focusable
 * items.
 *
 * @param itemsCanFocus true if items can get focus, false otherwise
 */

public void setItemsCanFocus(boolean itemsCanFocus) { throw new RuntimeException("Stub!"); }

/**
 * @return Whether the views created by the ListAdapter can contain focusable
 * items.
 */

public boolean getItemsCanFocus() { throw new RuntimeException("Stub!"); }

public boolean isOpaque() { throw new RuntimeException("Stub!"); }

public void setCacheColorHint(int color) { throw new RuntimeException("Stub!"); }

protected void dispatchDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

protected boolean drawChild(android.graphics.Canvas canvas, android.view.View child, long drawingTime) { throw new RuntimeException("Stub!"); }

/**
 * Returns the drawable that will be drawn between each item in the list.
 *
 * @return the current drawable drawn between list elements
 * This value may be {@code null}.
 * @attr ref R.styleable#ListView_divider
 */

@androidx.annotation.RecentlyNullable public android.graphics.drawable.Drawable getDivider() { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable that will be drawn between each item in the list.
 * <p>
 * <strong>Note:</strong> If the drawable does not have an intrinsic
 * height, you should also call {@link #setDividerHeight(int)}.
 *
 * @param divider the drawable to use
 * This value may be {@code null}.
 * @attr ref R.styleable#ListView_divider
 */

public void setDivider(@androidx.annotation.RecentlyNullable android.graphics.drawable.Drawable divider) { throw new RuntimeException("Stub!"); }

/**
 * @return Returns the height of the divider that will be drawn between each item in the list.
 */

public int getDividerHeight() { throw new RuntimeException("Stub!"); }

/**
 * Sets the height of the divider that will be drawn between each item in the list. Calling
 * this will override the intrinsic height as set by {@link #setDivider(Drawable)}
 *
 * @param height The new height of the divider in pixels.
 */

public void setDividerHeight(int height) { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the drawing of the divider for header views.
 *
 * @param headerDividersEnabled True to draw the headers, false otherwise.
 *
 * @see #setFooterDividersEnabled(boolean)
 * @see #areHeaderDividersEnabled()
 * @see #addHeaderView(android.view.View)
 */

public void setHeaderDividersEnabled(boolean headerDividersEnabled) { throw new RuntimeException("Stub!"); }

/**
 * @return Whether the drawing of the divider for header views is enabled
 *
 * @see #setHeaderDividersEnabled(boolean)
 */

public boolean areHeaderDividersEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the drawing of the divider for footer views.
 *
 * @param footerDividersEnabled True to draw the footers, false otherwise.
 *
 * @see #setHeaderDividersEnabled(boolean)
 * @see #areFooterDividersEnabled()
 * @see #addFooterView(android.view.View)
 */

public void setFooterDividersEnabled(boolean footerDividersEnabled) { throw new RuntimeException("Stub!"); }

/**
 * @return Whether the drawing of the divider for footer views is enabled
 *
 * @see #setFooterDividersEnabled(boolean)
 */

public boolean areFooterDividersEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable that will be drawn above all other list content.
 * This area can become visible when the user overscrolls the list.
 *
 * @param header The drawable to use
 */

public void setOverscrollHeader(android.graphics.drawable.Drawable header) { throw new RuntimeException("Stub!"); }

/**
 * @return The drawable that will be drawn above all other list content
 */

public android.graphics.drawable.Drawable getOverscrollHeader() { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable that will be drawn below all other list content.
 * This area can become visible when the user overscrolls the list,
 * or when the list's content does not fully fill the container area.
 *
 * @param footer The drawable to use
 */

public void setOverscrollFooter(android.graphics.drawable.Drawable footer) { throw new RuntimeException("Stub!"); }

/**
 * @return The drawable that will be drawn below all other list content
 */

public android.graphics.drawable.Drawable getOverscrollFooter() { throw new RuntimeException("Stub!"); }

protected void onFocusChanged(boolean gainFocus, int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

protected void onFinishInflate() { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of checked items ids. The result is only valid if the
 * choice mode has not been set to {@link #CHOICE_MODE_NONE}.
 *
 * @return A new array which contains the id of each checked item in the
 *         list.
 *
 * @deprecated Use {@link #getCheckedItemIds()} instead.
 */

@Deprecated public long[] getCheckItemIds() { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

public void onInitializeAccessibilityNodeInfoForItem(android.view.View view, int position, android.view.accessibility.AccessibilityNodeInfo info) { throw new RuntimeException("Stub!"); }
/**
 * A class that represents a fixed view in a list, for example a header at the top
 * or a footer at the bottom.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FixedViewInfo {

public FixedViewInfo() { throw new RuntimeException("Stub!"); }

/** The data backing the view. This is returned from {@link ListAdapter#getItem(int)}. */

public java.lang.Object data;

/** <code>true</code> if the fixed view should be selectable in the list */

public boolean isSelectable;

/** The view to add to the list */

public android.view.View view;
}

}

