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

import android.view.View;
import android.R;

/**
 * SlidingDrawer hides content out of the screen and allows the user to drag a handle
 * to bring the content on screen. SlidingDrawer can be used vertically or horizontally.
 *
 * A special widget composed of two children views: the handle, that the users drags,
 * and the content, attached to the handle and dragged with it.
 *
 * SlidingDrawer should be used as an overlay inside layouts. This means SlidingDrawer
 * should only be used inside of a FrameLayout or a RelativeLayout for instance. The
 * size of the SlidingDrawer defines how much space the content will occupy once slid
 * out so SlidingDrawer should usually use match_parent for both its dimensions.
 *
 * Inside an XML layout, SlidingDrawer must define the id of the handle and of the
 * content:
 *
 * <pre class="prettyprint">
 * &lt;SlidingDrawer
 *     android:id="@+id/drawer"
 *     android:layout_width="match_parent"
 *     android:layout_height="match_parent"
 *
 *     android:handle="@+id/handle"
 *     android:content="@+id/content"&gt;
 *
 *     &lt;ImageView
 *         android:id="@id/handle"
 *         android:layout_width="88dip"
 *         android:layout_height="44dip" /&gt;
 *
 *     &lt;GridView
 *         android:id="@id/content"
 *         android:layout_width="match_parent"
 *         android:layout_height="match_parent" /&gt;
 *
 * &lt;/SlidingDrawer&gt;
 * </pre>
 *
 * @attr ref android.R.styleable#SlidingDrawer_content
 * @attr ref android.R.styleable#SlidingDrawer_handle
 * @attr ref android.R.styleable#SlidingDrawer_topOffset
 * @attr ref android.R.styleable#SlidingDrawer_bottomOffset
 * @attr ref android.R.styleable#SlidingDrawer_orientation
 * @attr ref android.R.styleable#SlidingDrawer_allowSingleTap
 * @attr ref android.R.styleable#SlidingDrawer_animateOnClick
 *
 * @deprecated This class is not supported anymore. It is recommended you
 * base your own implementation on the source code for the Android Open
 * Source Project if you must use it in your application.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public class SlidingDrawer extends android.view.ViewGroup {

/**
 * Creates a new SlidingDrawer from a specified set of attributes defined in XML.
 *
 * @param context The application's environment.
 * @param attrs The attributes defined in XML.
 */

public SlidingDrawer(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new SlidingDrawer from a specified set of attributes defined in XML.
 *
 * @param context The application's environment.
 * @param attrs The attributes defined in XML.
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 */

public SlidingDrawer(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new SlidingDrawer from a specified set of attributes defined in XML.
 *
 * @param context The application's environment.
 * @param attrs The attributes defined in XML.
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 * @param defStyleRes A resource identifier of a style resource that
 *        supplies default values for the view, used only if
 *        defStyleAttr is 0 or can not be found in the theme. Can be 0
 *        to not look for defaults.
 */

public SlidingDrawer(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

protected void onFinishInflate() { throw new RuntimeException("Stub!"); }

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

protected void dispatchDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

protected void onLayout(boolean changed, int l, int t, int r, int b) { throw new RuntimeException("Stub!"); }

public boolean onInterceptTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Toggles the drawer open and close. Takes effect immediately.
 *
 * @see #open()
 * @see #close()
 * @see #animateClose()
 * @see #animateOpen()
 * @see #animateToggle()
 */

public void toggle() { throw new RuntimeException("Stub!"); }

/**
 * Toggles the drawer open and close with an animation.
 *
 * @see #open()
 * @see #close()
 * @see #animateClose()
 * @see #animateOpen()
 * @see #toggle()
 */

public void animateToggle() { throw new RuntimeException("Stub!"); }

/**
 * Opens the drawer immediately.
 *
 * @see #toggle()
 * @see #close()
 * @see #animateOpen()
 */

public void open() { throw new RuntimeException("Stub!"); }

/**
 * Closes the drawer immediately.
 *
 * @see #toggle()
 * @see #open()
 * @see #animateClose()
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Closes the drawer with an animation.
 *
 * @see #close()
 * @see #open()
 * @see #animateOpen()
 * @see #animateToggle()
 * @see #toggle()
 */

public void animateClose() { throw new RuntimeException("Stub!"); }

/**
 * Opens the drawer with an animation.
 *
 * @see #close()
 * @see #open()
 * @see #animateClose()
 * @see #animateToggle()
 * @see #toggle()
 */

public void animateOpen() { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener that receives a notification when the drawer becomes open.
 *
 * @param onDrawerOpenListener The listener to be notified when the drawer is opened.
 */

public void setOnDrawerOpenListener(android.widget.SlidingDrawer.OnDrawerOpenListener onDrawerOpenListener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener that receives a notification when the drawer becomes close.
 *
 * @param onDrawerCloseListener The listener to be notified when the drawer is closed.
 */

public void setOnDrawerCloseListener(android.widget.SlidingDrawer.OnDrawerCloseListener onDrawerCloseListener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener that receives a notification when the drawer starts or ends
 * a scroll. A fling is considered as a scroll. A fling will also trigger a
 * drawer opened or drawer closed event.
 *
 * @param onDrawerScrollListener The listener to be notified when scrolling
 *        starts or stops.
 */

public void setOnDrawerScrollListener(android.widget.SlidingDrawer.OnDrawerScrollListener onDrawerScrollListener) { throw new RuntimeException("Stub!"); }

/**
 * Returns the handle of the drawer.
 *
 * @return The View reprenseting the handle of the drawer, identified by
 *         the "handle" id in XML.
 */

public android.view.View getHandle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the content of the drawer.
 *
 * @return The View reprenseting the content of the drawer, identified by
 *         the "content" id in XML.
 */

public android.view.View getContent() { throw new RuntimeException("Stub!"); }

/**
 * Unlocks the SlidingDrawer so that touch events are processed.
 *
 * @see #lock()
 */

public void unlock() { throw new RuntimeException("Stub!"); }

/**
 * Locks the SlidingDrawer so that touch events are ignores.
 *
 * @see #unlock()
 */

public void lock() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the drawer is currently fully opened.
 *
 * @return True if the drawer is opened, false otherwise.
 */

public boolean isOpened() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the drawer is scrolling or flinging.
 *
 * @return True if the drawer is scroller or flinging, false otherwise.
 */

public boolean isMoving() { throw new RuntimeException("Stub!"); }

public static final int ORIENTATION_HORIZONTAL = 0; // 0x0

public static final int ORIENTATION_VERTICAL = 1; // 0x1
/**
 * Callback invoked when the drawer is closed.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDrawerCloseListener {

/**
 * Invoked when the drawer becomes fully closed.
 */

public void onDrawerClosed();
}

/**
 * Callback invoked when the drawer is opened.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDrawerOpenListener {

/**
 * Invoked when the drawer becomes fully open.
 */

public void onDrawerOpened();
}

/**
 * Callback invoked when the drawer is scrolled.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDrawerScrollListener {

/**
 * Invoked when the user starts dragging/flinging the drawer's handle.
 */

public void onScrollStarted();

/**
 * Invoked when the user stops dragging/flinging the drawer's handle.
 */

public void onScrollEnded();
}

}

