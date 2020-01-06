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
import android.view.ViewGroup;
import android.os.StrictMode;

/**
 * A view group that allows the view hierarchy placed within it to be scrolled.
 * Scroll view may have only one direct child placed within it.
 * To add multiple views within the scroll view, make
 * the direct child you add a view group, for example {@link LinearLayout}, and
 * place additional views within that LinearLayout.
 *
 * <p>Scroll view supports vertical scrolling only. For horizontal scrolling,
 * use {@link HorizontalScrollView} instead.</p>
 *
 * <p>Never add a {@link android.support.v7.widget.RecyclerView} or {@link ListView} to
 * a scroll view. Doing so results in poor user interface performance and a poor user
 * experience.</p>
 *
 * <p class="note">
 * For vertical scrolling, consider {@link android.support.v4.widget.NestedScrollView}
 * instead of scroll view which offers greater user interface flexibility and
 * support for the material design scrolling patterns.</p>
 *
 * <p>To learn more about material design patterns for handling scrolling, see
 * <a href="https://material.io/guidelines/patterns/scrolling-techniques.html#">
 * Scrolling techniques</a>.</p>
 *
 * @attr ref android.R.styleable#ScrollView_fillViewport
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ScrollView extends android.widget.FrameLayout {

public ScrollView(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ScrollView(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ScrollView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ScrollView(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public boolean shouldDelayChildPressedState() { throw new RuntimeException("Stub!"); }

protected float getTopFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

protected float getBottomFadingEdgeStrength() { throw new RuntimeException("Stub!"); }

/**
 * @return The maximum amount this scroll view will scroll in response to
 *   an arrow event.
 */

public int getMaxScrollAmount() { throw new RuntimeException("Stub!"); }

public void addView(android.view.View child) { throw new RuntimeException("Stub!"); }

public void addView(android.view.View child, int index) { throw new RuntimeException("Stub!"); }

public void addView(android.view.View child, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

public void addView(android.view.View child, int index, android.view.ViewGroup.LayoutParams params) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this ScrollView's content is stretched to fill the viewport.
 *
 * @return True if the content fills the viewport, false otherwise.
 *
 * @attr ref android.R.styleable#ScrollView_fillViewport
 */

public boolean isFillViewport() { throw new RuntimeException("Stub!"); }

/**
 * Indicates this ScrollView whether it should stretch its content height to fill
 * the viewport or not.
 *
 * @param fillViewport True to stretch the content's height to the viewport's
 *        boundaries, false otherwise.
 *
 * @attr ref android.R.styleable#ScrollView_fillViewport
 */

public void setFillViewport(boolean fillViewport) { throw new RuntimeException("Stub!"); }

/**
 * @return Whether arrow scrolling will animate its transition.
 */

public boolean isSmoothScrollingEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Set whether arrow scrolling will animate its transition.
 * @param smoothScrollingEnabled whether arrow scrolling will animate its transition
 */

public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) { throw new RuntimeException("Stub!"); }

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

public boolean dispatchKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * You can call this function yourself to have the scroll view perform
 * scrolling from a key event, just as if the event had been dispatched to
 * it by the view hierarchy.
 *
 * @param event The key event to execute.
 * @return Return true if the event was handled, else false.
 */

public boolean executeKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) { throw new RuntimeException("Stub!"); }

public boolean onInterceptTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

public boolean onTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

public boolean onGenericMotionEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * <p>Handles scrolling in response to a "page up/down" shortcut press. This
 * method will scroll the view by one page up or down and give the focus
 * to the topmost/bottommost component in the new visible area. If no
 * component is a good candidate for focus, this scrollview reclaims the
 * focus.</p>
 *
 * @param direction the scroll direction: {@link android.view.View#FOCUS_UP}
 *                  to go one page up or
 *                  {@link android.view.View#FOCUS_DOWN} to go one page down
 * @return true if the key event is consumed by this method, false otherwise
 */

public boolean pageScroll(int direction) { throw new RuntimeException("Stub!"); }

/**
 * <p>Handles scrolling in response to a "home/end" shortcut press. This
 * method will scroll the view to the top or bottom and give the focus
 * to the topmost/bottommost component in the new visible area. If no
 * component is a good candidate for focus, this scrollview reclaims the
 * focus.</p>
 *
 * @param direction the scroll direction: {@link android.view.View#FOCUS_UP}
 *                  to go the top of the view or
 *                  {@link android.view.View#FOCUS_DOWN} to go the bottom
 * @return true if the key event is consumed by this method, false otherwise
 */

public boolean fullScroll(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Handle scrolling in response to an up or down arrow click.
 *
 * @param direction The direction corresponding to the arrow key that was
 *                  pressed
 * @return True if we consumed the event, false otherwise
 */

public boolean arrowScroll(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link View#scrollBy}, but scroll smoothly instead of immediately.
 *
 * @param dx the number of pixels to scroll by on the X axis
 * @param dy the number of pixels to scroll by on the Y axis
 */

public final void smoothScrollBy(int dx, int dy) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #scrollTo}, but scroll smoothly instead of immediately.
 *
 * @param x the position where to scroll on the X axis
 * @param y the position where to scroll on the Y axis
 */

public final void smoothScrollTo(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * <p>The scroll range of a scroll view is the overall height of all of its
 * children.</p>
 */

protected int computeVerticalScrollRange() { throw new RuntimeException("Stub!"); }

protected int computeVerticalScrollOffset() { throw new RuntimeException("Stub!"); }

protected void measureChild(android.view.View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) { throw new RuntimeException("Stub!"); }

protected void measureChildWithMargins(android.view.View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) { throw new RuntimeException("Stub!"); }

public void computeScroll() { throw new RuntimeException("Stub!"); }

/**
 * Compute the amount to scroll in the Y direction in order to get
 * a rectangle completely on the screen (or, if taller than the screen,
 * at least the first screen size chunk of it).
 *
 * @param rect The rect.
 * @return The scroll delta.
 */

protected int computeScrollDeltaToGetChildRectOnScreen(android.graphics.Rect rect) { throw new RuntimeException("Stub!"); }

public void requestChildFocus(android.view.View child, android.view.View focused) { throw new RuntimeException("Stub!"); }

/**
 * When looking for focus in children of a scroll view, need to be a little
 * more careful not to give focus to something that is scrolled off screen.
 *
 * This is more expensive than the default {@link android.view.ViewGroup}
 * implementation, otherwise this behavior might have been made the default.
 */

protected boolean onRequestFocusInDescendants(int direction, android.graphics.Rect previouslyFocusedRect) { throw new RuntimeException("Stub!"); }

public boolean requestChildRectangleOnScreen(android.view.View child, android.graphics.Rect rectangle, boolean immediate) { throw new RuntimeException("Stub!"); }

public void requestLayout() { throw new RuntimeException("Stub!"); }

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

protected void onLayout(boolean changed, int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

protected void onSizeChanged(int w, int h, int oldw, int oldh) { throw new RuntimeException("Stub!"); }

/**
 * Fling the scroll view
 *
 * @param velocityY The initial velocity in the Y direction. Positive
 *                  numbers mean that the finger/cursor is moving down the screen,
 *                  which means we want to scroll towards the top.
 */

public void fling(int velocityY) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This version also clamps the scrolling to the bounds of our child.
 */

public void scrollTo(int x, int y) { throw new RuntimeException("Stub!"); }

public void setOverScrollMode(int mode) { throw new RuntimeException("Stub!"); }

public boolean onStartNestedScroll(android.view.View child, android.view.View target, int nestedScrollAxes) { throw new RuntimeException("Stub!"); }

public void onNestedScrollAccepted(android.view.View child, android.view.View target, int axes) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 */

public void onStopNestedScroll(android.view.View target) { throw new RuntimeException("Stub!"); }

public void onNestedScroll(android.view.View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) { throw new RuntimeException("Stub!"); }

/**
 * @inheritDoc
 */

public boolean onNestedFling(android.view.View target, float velocityX, float velocityY, boolean consumed) { throw new RuntimeException("Stub!"); }

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

protected void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

protected android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }
}

