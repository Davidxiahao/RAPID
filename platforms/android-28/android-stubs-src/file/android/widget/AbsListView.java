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
import android.view.View;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.content.Context;
import android.content.res.Configuration;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputConnection;
import android.os.Handler;
import android.graphics.Rect;
import android.os.StrictMode;

/**
 * Base class that can be used to implement virtualized lists of items. A list does
 * not have a spatial definition here. For instance, subclasses of this class can
 * display the content of the list in a grid, in a carousel, as stack, etc.
 *
 * @attr ref android.R.styleable#AbsListView_listSelector
 * @attr ref android.R.styleable#AbsListView_drawSelectorOnTop
 * @attr ref android.R.styleable#AbsListView_stackFromBottom
 * @attr ref android.R.styleable#AbsListView_scrollingCache
 * @attr ref android.R.styleable#AbsListView_textFilterEnabled
 * @attr ref android.R.styleable#AbsListView_transcriptMode
 * @attr ref android.R.styleable#AbsListView_cacheColorHint
 * @attr ref android.R.styleable#AbsListView_fastScrollEnabled
 * @attr ref android.R.styleable#AbsListView_smoothScrollbar
 * @attr ref android.R.styleable#AbsListView_choiceMode
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AbsListView extends android.widget.AdapterView<android.widget.ListAdapter> implements android.text.TextWatcher, android.view.ViewTreeObserver.OnGlobalLayoutListener, android.widget.Filter.FilterListener, android.view.ViewTreeObserver.OnTouchModeChangeListener {

public AbsListView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public AbsListView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public AbsListView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public AbsListView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public void setOverScrollMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public void setAdapter(android.widget.ListAdapter adapter) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of items currently selected. This will only be valid
 * if the choice mode is not {@link #CHOICE_MODE_NONE} (default).
 *
 * <p>To determine the specific items that are currently selected, use one of
 * the <code>getChecked*</code> methods.
 *
 * @return The number of items currently selected
 *
 * @see #getCheckedItemPosition()
 * @see #getCheckedItemPositions()
 * @see #getCheckedItemIds()
 */

public int getCheckedItemCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the checked state of the specified position. The result is only
 * valid if the choice mode has been set to {@link #CHOICE_MODE_SINGLE}
 * or {@link #CHOICE_MODE_MULTIPLE}.
 *
 * @param position The item whose checked state to return
 * @return The item's checked state or <code>false</code> if choice mode
 *         is invalid
 *
 * @see #setChoiceMode(int)
 */

public boolean isItemChecked(int position) { throw new RuntimeException("Stub!"); }

/**
 * Returns the currently checked item. The result is only valid if the choice
 * mode has been set to {@link #CHOICE_MODE_SINGLE}.
 *
 * @return The position of the currently checked item or
 *         {@link #INVALID_POSITION} if nothing is selected
 *
 * @see #setChoiceMode(int)
 */

public int getCheckedItemPosition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of checked items in the list. The result is only valid if
 * the choice mode has not been set to {@link #CHOICE_MODE_NONE}.
 *
 * @return  A SparseBooleanArray which will return true for each call to
 *          get(int position) where position is a checked position in the
 *          list and false otherwise, or <code>null</code> if the choice
 *          mode is set to {@link #CHOICE_MODE_NONE}.
 */

public android.util.SparseBooleanArray getCheckedItemPositions() { throw new RuntimeException("Stub!"); }

/**
 * Returns the set of checked items ids. The result is only valid if the
 * choice mode has not been set to {@link #CHOICE_MODE_NONE} and the adapter
 * has stable IDs. ({@link ListAdapter#hasStableIds()} == {@code true})
 *
 * @return A new array which contains the id of each checked item in the
 *         list.
 */

public long[] getCheckedItemIds() { throw new RuntimeException("Stub!"); }

/**
 * Clear any choices previously set
 */

public void clearChoices() { throw new RuntimeException("Stub!"); }

/**
 * Sets the checked state of the specified position. The is only valid if
 * the choice mode has been set to {@link #CHOICE_MODE_SINGLE} or
 * {@link #CHOICE_MODE_MULTIPLE}.
 *
 * @param position The item whose checked state is to be checked
 * @param value The new checked state for the item
 */

public void setItemChecked(int position, boolean value) { throw new RuntimeException("Stub!"); }

public boolean performItemClick(android.view.View view, int position, long id) { throw new RuntimeException("Stub!"); }

/**
 * @see #setChoiceMode(int)
 *
 * @return The current choice mode
 */

public int getChoiceMode() { throw new RuntimeException("Stub!"); }

/**
 * Defines the choice behavior for the List. By default, Lists do not have any choice behavior
 * ({@link #CHOICE_MODE_NONE}). By setting the choiceMode to {@link #CHOICE_MODE_SINGLE}, the
 * List allows up to one item to  be in a chosen state. By setting the choiceMode to
 * {@link #CHOICE_MODE_MULTIPLE}, the list allows any number of items to be chosen.
 *
 * @param choiceMode One of {@link #CHOICE_MODE_NONE}, {@link #CHOICE_MODE_SINGLE}, or
 * {@link #CHOICE_MODE_MULTIPLE}
 */

public void setChoiceMode(int choiceMode) { throw new RuntimeException("Stub!"); }

/**
 * Set a {@link MultiChoiceModeListener} that will manage the lifecycle of the
 * selection {@link ActionMode}. Only used when the choice mode is set to
 * {@link #CHOICE_MODE_MULTIPLE_MODAL}.
 *
 * @param listener Listener that will manage the selection mode
 *
 * @see #setChoiceMode(int)
 */

public void setMultiChoiceModeListener(android.widget.AbsListView.MultiChoiceModeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether fast scrolling is enabled or disabled.
 * <p>
 * When fast scrolling is enabled, the user can quickly scroll through lists
 * by dragging the fast scroll thumb.
 * <p>
 * If the adapter backing this list implements {@link SectionIndexer}, the
 * fast scroller will display section header previews as the user scrolls.
 * Additionally, the user will be able to quickly jump between sections by
 * tapping along the length of the scroll bar.
 *
 * @see SectionIndexer
 * @see #isFastScrollEnabled()
 * @param enabled true to enable fast scrolling, false otherwise
 */

public void setFastScrollEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the style of the fast scroller decorations.
 *
 * @param styleResId style resource containing fast scroller properties
 * @see android.R.styleable#FastScroll
 */

public void setFastScrollStyle(int styleResId) { throw new RuntimeException("Stub!"); }

/**
 * Set whether or not the fast scroller should always be shown in place of
 * the standard scroll bars. This will enable fast scrolling if it is not
 * already enabled.
 * <p>
 * Fast scrollers shown in this way will not fade out and will be a
 * permanent fixture within the list. This is best combined with an inset
 * scroll bar style to ensure the scroll bar does not overlap content.
 *
 * @param alwaysShow true if the fast scroller should always be displayed,
 *            false otherwise
 * @see #setScrollBarStyle(int)
 * @see #setFastScrollEnabled(boolean)
 */

public void setFastScrollAlwaysVisible(boolean alwaysShow) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the fast scroller is set to always show on this view.
 *
 * @return true if the fast scroller will always show
 * @see #setFastScrollAlwaysVisible(boolean)
 */

public boolean isFastScrollAlwaysVisible() { throw new RuntimeException("Stub!"); }

public int getVerticalScrollbarWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the fast scroller is enabled.
 *
 * @see #setFastScrollEnabled(boolean)
 * @return true if fast scroll is enabled, false otherwise
 */

@android.view.ViewDebug.ExportedProperty public boolean isFastScrollEnabled() { throw new RuntimeException("Stub!"); }

public void setVerticalScrollbarPosition(int position) { throw new RuntimeException("Stub!"); }

public void setScrollBarStyle(int style) { throw new RuntimeException("Stub!"); }

/**
 * When smooth scrollbar is enabled, the position and size of the scrollbar thumb
 * is computed based on the number of visible pixels in the visible items. This
 * however assumes that all list items have the same height. If you use a list in
 * which items have different heights, the scrollbar will change appearance as the
 * user scrolls through the list. To avoid this issue, you need to disable this
 * property.
 *
 * When smooth scrollbar is disabled, the position and size of the scrollbar thumb
 * is based solely on the number of items in the adapter and the position of the
 * visible items inside the adapter. This provides a stable scrollbar as the user
 * navigates through a list of items with varying heights.
 *
 * @param enabled Whether or not to enable smooth scrollbar.
 *
 * @see #setSmoothScrollbarEnabled(boolean)
 * @attr ref android.R.styleable#AbsListView_smoothScrollbar
 */

public void setSmoothScrollbarEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current state of the fast scroll feature.
 *
 * @return True if smooth scrollbar is enabled is enabled, false otherwise.
 *
 * @see #setSmoothScrollbarEnabled(boolean)
 */

@android.view.ViewDebug.ExportedProperty public boolean isSmoothScrollbarEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Set the listener that will receive notifications every time the list scrolls.
 *
 * @param l the scroll listener
 */

public void setOnScrollListener(android.widget.AbsListView.OnScrollListener l) { throw new RuntimeException("Stub!"); }

/** @hide */

public void sendAccessibilityEventUnchecked(android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the children's drawing cache is used during a scroll.
 * By default, the drawing cache is enabled but this will consume more memory.
 *
 * @return true if the scrolling cache is enabled, false otherwise
 *
 * @see #setScrollingCacheEnabled(boolean)
 * @see View#setDrawingCacheEnabled(boolean)
 */

@android.view.ViewDebug.ExportedProperty public boolean isScrollingCacheEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the children's drawing cache during a scroll.
 * By default, the drawing cache is enabled but this will use more memory.
 *
 * When the scrolling cache is enabled, the caches are kept after the
 * first scrolling. You can manually clear the cache by calling
 * {@link android.view.ViewGroup#setChildrenDrawingCacheEnabled(boolean)}.
 *
 * @param enabled true to enable the scroll cache, false otherwise
 *
 * @see #isScrollingCacheEnabled()
 * @see View#setDrawingCacheEnabled(boolean)
 */

public void setScrollingCacheEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Enables or disables the type filter window. If enabled, typing when
 * this view has focus will filter the children to match the users input.
 * Note that the {@link Adapter} used by this view must implement the
 * {@link Filterable} interface.
 *
 * @param textFilterEnabled true to enable type filtering, false otherwise
 *
 * @see Filterable
 */

public void setTextFilterEnabled(boolean textFilterEnabled) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether type filtering is enabled for this view
 *
 * @return true if type filtering is enabled, false otherwise
 *
 * @see #setTextFilterEnabled(boolean)
 * @see Filterable
 */

@android.view.ViewDebug.ExportedProperty public boolean isTextFilterEnabled() { throw new RuntimeException("Stub!"); }

public void getFocusedRect(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the content of this view is pinned to, or stacked from,
 * the bottom edge.
 *
 * @return true if the content is stacked from the bottom edge, false otherwise
 */

@android.view.ViewDebug.ExportedProperty public boolean isStackFromBottom() { throw new RuntimeException("Stub!"); }

/**
 * When stack from bottom is set to true, the list fills its content starting from
 * the bottom of the view.
 *
 * @param stackFromBottom true to pin the view's content to the bottom edge,
 *        false to pin the view's content to the top edge
 */

public void setStackFromBottom(boolean stackFromBottom) { throw new RuntimeException("Stub!"); }

public android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

public void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

/**
 * Sets the initial value for the text filter.
 * @param filterText The text to use for the filter.
 *
 * @see #setTextFilterEnabled
 */

public void setFilterText(java.lang.String filterText) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list's text filter, if available.
 * @return the list's text filter or null if filtering isn't enabled
 */

public java.lang.CharSequence getTextFilter() { throw new RuntimeException("Stub!"); }

protected void onFocusChanged(boolean gainFocus, int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

public void requestLayout() { throw new RuntimeException("Stub!"); }

protected int computeVerticalScrollExtent() { throw new RuntimeException("Stub!"); }

protected int computeVerticalScrollOffset() { throw new RuntimeException("Stub!"); }

protected int computeVerticalScrollRange() { throw new RuntimeException("Stub!"); }

protected float getTopFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

protected float getBottomFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses should NOT override this method but
 *  {@link #layoutChildren()} instead.
 */

protected void onLayout(boolean changed, int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses must override this method to layout their children.
 */

protected void layoutChildren() { throw new RuntimeException("Stub!"); }

@android.view.ViewDebug.ExportedProperty public android.view.View getSelectedView() { throw new RuntimeException("Stub!"); }

/**
 * List padding is the maximum of the normal view's padding and the padding of the selector.
 *
 * @see android.view.View#getPaddingTop()
 * @see #getSelector()
 *
 * @return The top list padding.
 */

public int getListPaddingTop() { throw new RuntimeException("Stub!"); }

/**
 * List padding is the maximum of the normal view's padding and the padding of the selector.
 *
 * @see android.view.View#getPaddingBottom()
 * @see #getSelector()
 *
 * @return The bottom list padding.
 */

public int getListPaddingBottom() { throw new RuntimeException("Stub!"); }

/**
 * List padding is the maximum of the normal view's padding and the padding of the selector.
 *
 * @see android.view.View#getPaddingLeft()
 * @see #getSelector()
 *
 * @return The left list padding.
 */

public int getListPaddingLeft() { throw new RuntimeException("Stub!"); }

/**
 * List padding is the maximum of the normal view's padding and the padding of the selector.
 *
 * @see android.view.View#getPaddingRight()
 * @see #getSelector()
 *
 * @return The right list padding.
 */

public int getListPaddingRight() { throw new RuntimeException("Stub!"); }

/**
 * Initializes an {@link AccessibilityNodeInfo} with information about a
 * particular item in the list.
 *
 * @param view View representing the list item.
 * @param position Position of the list item within the adapter.
 * @param info Node info to populate.
 */

public void onInitializeAccessibilityNodeInfoForItem(android.view.View view, int position, android.view.accessibility.AccessibilityNodeInfo info) { throw new RuntimeException("Stub!"); }

protected void dispatchDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

protected boolean isPaddingOffsetRequired() { throw new RuntimeException("Stub!"); }

protected int getLeftPaddingOffset() { throw new RuntimeException("Stub!"); }

protected int getTopPaddingOffset() { throw new RuntimeException("Stub!"); }

protected int getRightPaddingOffset() { throw new RuntimeException("Stub!"); }

protected int getBottomPaddingOffset() { throw new RuntimeException("Stub!"); }

protected void onSizeChanged(int w, int h, int oldw, int oldh) { throw new RuntimeException("Stub!"); }

/**
 * Controls whether the selection highlight drawable should be drawn on top of the item or
 * behind it.
 *
 * @param onTop If true, the selector will be drawn on the item it is highlighting. The default
 *        is false.
 *
 * @attr ref android.R.styleable#AbsListView_drawSelectorOnTop
 */

public void setDrawSelectorOnTop(boolean onTop) { throw new RuntimeException("Stub!"); }

/**
 * Set a Drawable that should be used to highlight the currently selected item.
 *
 * @param resID A Drawable resource to use as the selection highlight.
 *
 * @attr ref android.R.styleable#AbsListView_listSelector
 */

public void setSelector(int resID) { throw new RuntimeException("Stub!"); }

public void setSelector(android.graphics.drawable.Drawable sel) { throw new RuntimeException("Stub!"); }

/**
 * Returns the selector {@link android.graphics.drawable.Drawable} that is used to draw the
 * selection in the list.
 *
 * @return the drawable used to display the selector
 */

public android.graphics.drawable.Drawable getSelector() { throw new RuntimeException("Stub!"); }

public void setScrollIndicators(android.view.View up, android.view.View down) { throw new RuntimeException("Stub!"); }

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

/**
 * @param dr This value must never be {@code null}.
 */

public boolean verifyDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable dr) { throw new RuntimeException("Stub!"); }

public void jumpDrawablesToCurrentState() { throw new RuntimeException("Stub!"); }

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

public void onWindowFocusChanged(boolean hasWindowFocus) { throw new RuntimeException("Stub!"); }

public void onRtlPropertiesChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

public void onCancelPendingInputEvents() { throw new RuntimeException("Stub!"); }

protected android.view.ContextMenu.ContextMenuInfo getContextMenuInfo() { throw new RuntimeException("Stub!"); }

public boolean showContextMenu() { throw new RuntimeException("Stub!"); }

public boolean showContextMenu(float x, float y) { throw new RuntimeException("Stub!"); }

public boolean showContextMenuForChild(android.view.View originalView) { throw new RuntimeException("Stub!"); }

public boolean showContextMenuForChild(android.view.View originalView, float x, float y) { throw new RuntimeException("Stub!"); }

public boolean onKeyDown(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

protected void dispatchSetPressed(boolean pressed) { throw new RuntimeException("Stub!"); }

public void dispatchDrawableHotspotChanged(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Maps a point to a position in the list.
 *
 * @param x X in local coordinate
 * @param y Y in local coordinate
 * @return The position of the item which contains the specified point, or
 *         {@link #INVALID_POSITION} if the point does not intersect an item.
 */

public int pointToPosition(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Maps a point to a the rowId of the item which intersects that point.
 *
 * @param x X in local coordinate
 * @param y Y in local coordinate
 * @return The rowId of the item which contains the specified point, or {@link #INVALID_ROW_ID}
 *         if the point does not intersect an item.
 */

public long pointToRowId(int x, int y) { throw new RuntimeException("Stub!"); }

public void onTouchModeChanged(boolean isInTouchMode) { throw new RuntimeException("Stub!"); }

public boolean onTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) { throw new RuntimeException("Stub!"); }

public boolean onGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Initiate a fling with the given velocity.
 *
 * <p>Applications can use this method to manually initiate a fling as if the user
 * initiated it via touch interaction.</p>
 *
 * @param velocityY Vertical velocity in pixels per second. Note that this is velocity of
 *                  content, not velocity of a touch that initiated the fling.
 */

public void fling(int velocityY) { throw new RuntimeException("Stub!"); }

public boolean onStartNestedScroll(android.view.View child, android.view.View target, int nestedScrollAxes) { throw new RuntimeException("Stub!"); }

public void onNestedScrollAccepted(android.view.View child, android.view.View target, int axes) { throw new RuntimeException("Stub!"); }

public void onNestedScroll(android.view.View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) { throw new RuntimeException("Stub!"); }

public boolean onNestedFling(android.view.View target, float velocityX, float velocityY, boolean consumed) { throw new RuntimeException("Stub!"); }

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) { throw new RuntimeException("Stub!"); }

public boolean onInterceptHoverEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

public android.view.PointerIcon onResolvePointerIcon(android.view.MotionEvent event, int pointerIndex) { throw new RuntimeException("Stub!"); }

public boolean onInterceptTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public void addTouchables(java.util.ArrayList<android.view.View> views) { throw new RuntimeException("Stub!"); }

/**
 * The amount of friction applied to flings. The default value
 * is {@link ViewConfiguration#getScrollFriction}.
 */

public void setFriction(float friction) { throw new RuntimeException("Stub!"); }

/**
 * Sets a scale factor for the fling velocity. The initial scale
 * factor is 1.0.
 *
 * @param scale The scale factor to multiply the velocity by.
 */

public void setVelocityScale(float scale) { throw new RuntimeException("Stub!"); }

/**
 * Smoothly scroll to the specified adapter position. The view will
 * scroll such that the indicated position is displayed.
 * @param position Scroll to this adapter position.
 */

public void smoothScrollToPosition(int position) { throw new RuntimeException("Stub!"); }

/**
 * Smoothly scroll to the specified adapter position. The view will scroll
 * such that the indicated position is displayed <code>offset</code> pixels below
 * the top edge of the view. If this is impossible, (e.g. the offset would scroll
 * the first or last item beyond the boundaries of the list) it will get as close
 * as possible. The scroll will take <code>duration</code> milliseconds to complete.
 *
 * @param position Position to scroll to
 * @param offset Desired distance in pixels of <code>position</code> from the top
 *               of the view when scrolling is finished
 * @param duration Number of milliseconds to use for the scroll
 */

public void smoothScrollToPositionFromTop(int position, int offset, int duration) { throw new RuntimeException("Stub!"); }

/**
 * Smoothly scroll to the specified adapter position. The view will scroll
 * such that the indicated position is displayed <code>offset</code> pixels below
 * the top edge of the view. If this is impossible, (e.g. the offset would scroll
 * the first or last item beyond the boundaries of the list) it will get as close
 * as possible.
 *
 * @param position Position to scroll to
 * @param offset Desired distance in pixels of <code>position</code> from the top
 *               of the view when scrolling is finished
 */

public void smoothScrollToPositionFromTop(int position, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Smoothly scroll to the specified adapter position. The view will
 * scroll such that the indicated position is displayed, but it will
 * stop early if scrolling further would scroll boundPosition out of
 * view.
 *
 * @param position Scroll to this adapter position.
 * @param boundPosition Do not scroll if it would move this adapter
 *          position out of view.
 */

public void smoothScrollToPosition(int position, int boundPosition) { throw new RuntimeException("Stub!"); }

/**
 * Smoothly scroll by distance pixels over duration milliseconds.
 * @param distance Distance to scroll in pixels.
 * @param duration Duration of the scroll animation in milliseconds.
 */

public void smoothScrollBy(int distance, int duration) { throw new RuntimeException("Stub!"); }

/**
 * Scrolls the list items within the view by a specified number of pixels.
 *
 * <p>The actual amount of scroll is capped by the list content viewport height
 * which is the list height minus top and bottom paddings minus one pixel.</p>
 *
 * @param y the amount of pixels to scroll by vertically
 * @see #canScrollList(int)
 */

public void scrollListBy(int y) { throw new RuntimeException("Stub!"); }

/**
 * Check if the items in the list can be scrolled in a certain direction.
 *
 * @param direction Negative to check scrolling up, positive to check
 *            scrolling down.
 * @return true if the list can be scrolled in the specified direction,
 *         false otherwise.
 * @see #scrollListBy(int)
 */

public boolean canScrollList(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Causes all the views to be rebuilt and redrawn.
 */

public void invalidateViews() { throw new RuntimeException("Stub!"); }

protected void handleDataChanged() { throw new RuntimeException("Stub!"); }

protected void onDisplayHint(int hint) { throw new RuntimeException("Stub!"); }

protected boolean isInFilterMode() { throw new RuntimeException("Stub!"); }

/**
 * Return an InputConnection for editing of the filter text.
 */

public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo outAttrs) { throw new RuntimeException("Stub!"); }

/**
 * For filtering we proxy an input connection to an internal text editor,
 * and this allows the proxying to happen.
 */

public boolean checkInputConnectionProxy(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Clear the text filter.
 */

public void clearTextFilter() { throw new RuntimeException("Stub!"); }

/**
 * Returns if the ListView currently has a text filter.
 */

public boolean hasTextFilter() { throw new RuntimeException("Stub!"); }

public void onGlobalLayout() { throw new RuntimeException("Stub!"); }

/**
 * For our text watcher that is associated with the text filter.  Does
 * nothing.
 */

public void beforeTextChanged(java.lang.CharSequence s, int start, int count, int after) { throw new RuntimeException("Stub!"); }

/**
 * For our text watcher that is associated with the text filter. Performs
 * the actual filtering as the text changes, and takes care of hiding and
 * showing the popup displaying the currently entered filter text.
 */

public void onTextChanged(java.lang.CharSequence s, int start, int before, int count) { throw new RuntimeException("Stub!"); }

/**
 * For our text watcher that is associated with the text filter.  Does
 * nothing.
 */

public void afterTextChanged(android.text.Editable s) { throw new RuntimeException("Stub!"); }

public void onFilterComplete(int count) { throw new RuntimeException("Stub!"); }

protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() { throw new RuntimeException("Stub!"); }

protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

public android.widget.AbsListView.LayoutParams generateLayoutParams(android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) { throw new RuntimeException("Stub!"); }

/**
 * Puts the list or grid into transcript mode. In this mode the list or grid will always scroll
 * to the bottom to show new items.
 *
 * @param mode the transcript mode to set
 *
 * @see #TRANSCRIPT_MODE_DISABLED
 * @see #TRANSCRIPT_MODE_NORMAL
 * @see #TRANSCRIPT_MODE_ALWAYS_SCROLL
 */

public void setTranscriptMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current transcript mode.
 *
 * @return {@link #TRANSCRIPT_MODE_DISABLED}, {@link #TRANSCRIPT_MODE_NORMAL} or
 *         {@link #TRANSCRIPT_MODE_ALWAYS_SCROLL}
 */

public int getTranscriptMode() { throw new RuntimeException("Stub!"); }

public int getSolidColor() { throw new RuntimeException("Stub!"); }

/**
 * When set to a non-zero value, the cache color hint indicates that this list is always drawn
 * on top of a solid, single-color, opaque background.
 *
 * Zero means that what's behind this object is translucent (non solid) or is not made of a
 * single color. This hint will not affect any existing background drawable set on this view (
 * typically set via {@link #setBackgroundDrawable(Drawable)}).
 *
 * @param color The background color
 */

public void setCacheColorHint(int color) { throw new RuntimeException("Stub!"); }

/**
 * When set to a non-zero value, the cache color hint indicates that this list is always drawn
 * on top of a solid, single-color, opaque background
 *
 * @return The cache color hint
 */

@android.view.ViewDebug.ExportedProperty(category="drawing") public int getCacheColorHint() { throw new RuntimeException("Stub!"); }

/**
 * Move all views (excluding headers and footers) held by this AbsListView into the supplied
 * List. This includes views displayed on the screen as well as views stored in AbsListView's
 * internal view recycler.
 *
 * @param views A list into which to put the reclaimed views
 */

public void reclaimViews(java.util.List<android.view.View> views) { throw new RuntimeException("Stub!"); }

/**
 * Sets up this AbsListView to use a remote views adapter which connects to a RemoteViewsService
 * through the specified intent.
 * @param intent the intent used to identify the RemoteViewsService for the adapter to connect to.
 */

public void setRemoteViewsAdapter(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * This defers a notifyDataSetChanged on the pending RemoteViewsAdapter if it has not
 * connected yet.
 */

public void deferNotifyDataSetChanged() { throw new RuntimeException("Stub!"); }

/**
 * Called back when the adapter connects to the RemoteViewsService.
 */

public boolean onRemoteAdapterConnected() { throw new RuntimeException("Stub!"); }

/**
 * Called back when the adapter disconnects from the RemoteViewsService.
 */

public void onRemoteAdapterDisconnected() { throw new RuntimeException("Stub!"); }

/**
 * Sets the recycler listener to be notified whenever a View is set aside in
 * the recycler for later reuse. This listener can be used to free resources
 * associated to the View.
 *
 * @param listener The recycler listener to be notified of views set aside
 *        in the recycler.
 *
 * @see android.widget.AbsListView.RecycleBin
 * @see android.widget.AbsListView.RecyclerListener
 */

public void setRecyclerListener(android.widget.AbsListView.RecyclerListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the selected item and positions the selection y pixels from the top edge
 * of the ListView. (If in touch mode, the item will not be selected but it will
 * still be positioned appropriately.)
 *
 * @param position Index (starting at 0) of the data item to be selected.
 * @param y The distance from the top edge of the ListView (plus padding) that the
 *        item will be positioned.
 */

public void setSelectionFromTop(int position, int y) { throw new RuntimeException("Stub!"); }

/**
 * The list allows multiple choices
 */

public static final int CHOICE_MODE_MULTIPLE = 2; // 0x2

/**
 * The list allows multiple choices in a modal selection mode
 */

public static final int CHOICE_MODE_MULTIPLE_MODAL = 3; // 0x3

/**
 * Normal list that does not indicate choices
 */

public static final int CHOICE_MODE_NONE = 0; // 0x0

/**
 * The list allows up to one choice
 */

public static final int CHOICE_MODE_SINGLE = 1; // 0x1

/**
 * The list will automatically scroll to the bottom, no matter what items
 * are currently visible.
 *
 * @see #setTranscriptMode(int)
 */

public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2; // 0x2

/**
 * Disables the transcript mode.
 *
 * @see #setTranscriptMode(int)
 */

public static final int TRANSCRIPT_MODE_DISABLED = 0; // 0x0

/**
 * The list will automatically scroll to the bottom when a data set change
 * notification is received and only if the last item is already visible
 * on screen.
 *
 * @see #setTranscriptMode(int)
 */

public static final int TRANSCRIPT_MODE_NORMAL = 1; // 0x1
/**
 * AbsListView extends LayoutParams to provide a place to hold the view type.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class LayoutParams extends android.view.ViewGroup.LayoutParams {

public LayoutParams(android.content.Context c, android.util.AttributeSet attrs) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

public LayoutParams(int w, int h) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

public LayoutParams(int w, int h, int viewType) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }

public LayoutParams(android.view.ViewGroup.LayoutParams source) { super((android.view.ViewGroup.LayoutParams)null); throw new RuntimeException("Stub!"); }
}

/**
 * A MultiChoiceModeListener receives events for {@link AbsListView#CHOICE_MODE_MULTIPLE_MODAL}.
 * It acts as the {@link ActionMode.Callback} for the selection mode and also receives
 * {@link #onItemCheckedStateChanged(ActionMode, int, long, boolean)} events when the user
 * selects and deselects list items.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface MultiChoiceModeListener extends android.view.ActionMode.Callback {

/**
 * Called when an item is checked or unchecked during selection mode.
 *
 * @param mode The {@link ActionMode} providing the selection mode
 * @param position Adapter position of the item that was checked or unchecked
 * @param id Adapter ID of the item that was checked or unchecked
 * @param checked <code>true</code> if the item is now checked, <code>false</code>
 *                if the item is now unchecked.
 */

public void onItemCheckedStateChanged(android.view.ActionMode mode, int position, long id, boolean checked);
}

/**
 * Interface definition for a callback to be invoked when the list or grid
 * has been scrolled.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnScrollListener {

/**
 * Callback method to be invoked while the list view or grid view is being scrolled. If the
 * view is being scrolled, this method will be called before the next frame of the scroll is
 * rendered. In particular, it will be called before any calls to
 * {@link Adapter#getView(int, View, ViewGroup)}.
 *
 * @param view The view whose scroll state is being reported
 *
 * @param scrollState The current scroll state. One of
 * {@link #SCROLL_STATE_TOUCH_SCROLL} or {@link #SCROLL_STATE_IDLE}.
 */

public void onScrollStateChanged(android.widget.AbsListView view, int scrollState);

/**
 * Callback method to be invoked when the list or grid has been scrolled. This will be
 * called after the scroll has completed
 * @param view The view whose scroll state is being reported
 * @param firstVisibleItem the index of the first visible cell (ignore if
 *        visibleItemCount == 0)
 * @param visibleItemCount the number of visible cells
 * @param totalItemCount the number of items in the list adaptor
 */

public void onScroll(android.widget.AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount);

/**
 * The user had previously been scrolling using touch and had performed a fling. The
 * animation is now coasting to a stop
 */

public static final int SCROLL_STATE_FLING = 2; // 0x2

/**
 * The view is not scrolling. Note navigating the list using the trackball counts as
 * being in the idle state since these transitions are not animated.
 */

public static final int SCROLL_STATE_IDLE = 0; // 0x0

/**
 * The user is scrolling using touch, and their finger is still on the screen
 */

public static final int SCROLL_STATE_TOUCH_SCROLL = 1; // 0x1
}

/**
 * A RecyclerListener is used to receive a notification whenever a View is placed
 * inside the RecycleBin's scrap heap. This listener is used to free resources
 * associated to Views placed in the RecycleBin.
 *
 * @see android.widget.AbsListView.RecycleBin
 * @see android.widget.AbsListView#setRecyclerListener(android.widget.AbsListView.RecyclerListener)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface RecyclerListener {

/**
 * Indicates that the specified View was moved into the recycler's scrap heap.
 * The view is not displayed on screen any more and any expensive resource
 * associated with the view should be discarded.
 *
 * @param view
 */

public void onMovedToScrapHeap(android.view.View view);
}

/**
 * The top-level view of a list item can implement this interface to allow
 * itself to modify the bounds of the selection shown for that item.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface SelectionBoundsAdjuster {

/**
 * Called to allow the list item to adjust the bounds shown for
 * its selection.
 *
 * @param bounds On call, this contains the bounds the list has
 * selected for the item (that is the bounds of the entire view).  The
 * values can be modified as desired.
 */

public void adjustListItemSelectionBounds(android.graphics.Rect bounds);
}

}

