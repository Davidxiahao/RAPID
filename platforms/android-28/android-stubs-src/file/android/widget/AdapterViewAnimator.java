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
import android.view.ViewGroup;
import android.content.Context;
import android.animation.ObjectAnimator;
import android.os.Handler;

/**
 * Base class for a {@link AdapterView} that will perform animations
 * when switching between its views.
 *
 * @attr ref android.R.styleable#AdapterViewAnimator_inAnimation
 * @attr ref android.R.styleable#AdapterViewAnimator_outAnimation
 * @attr ref android.R.styleable#AdapterViewAnimator_animateFirstView
 * @attr ref android.R.styleable#AdapterViewAnimator_loopViews
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class AdapterViewAnimator extends android.widget.AdapterView<android.widget.Adapter> implements android.widget.Advanceable {

public AdapterViewAnimator(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public AdapterViewAnimator(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public AdapterViewAnimator(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public AdapterViewAnimator(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets which child view will be displayed.
 *
 * @param whichChild the index of the child view to display
 */

public void setDisplayedChild(int whichChild) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of the currently displayed child view.
 */

public int getDisplayedChild() { throw new RuntimeException("Stub!"); }

/**
 * Manually shows the next child.
 */

public void showNext() { throw new RuntimeException("Stub!"); }

/**
 * Manually shows the previous child.
 */

public void showPrevious() { throw new RuntimeException("Stub!"); }

public boolean onTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

public android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

public void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

/**
 * Returns the View corresponding to the currently displayed child.
 *
 * @return The View currently displayed.
 *
 * @see #getDisplayedChild()
 */

public android.view.View getCurrentView() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current animation used to animate a View that enters the screen.
 *
 * @return An Animation or null if none is set.
 *
 * @see #setInAnimation(android.animation.ObjectAnimator)
 * @see #setInAnimation(android.content.Context, int)
 */

public android.animation.ObjectAnimator getInAnimation() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the animation used to animate a View that enters the screen.
 *
 * @param inAnimation The animation started when a View enters the screen.
 *
 * @see #getInAnimation()
 * @see #setInAnimation(android.content.Context, int)
 */

public void setInAnimation(android.animation.ObjectAnimator inAnimation) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current animation used to animate a View that exits the screen.
 *
 * @return An Animation or null if none is set.
 *
 * @see #setOutAnimation(android.animation.ObjectAnimator)
 * @see #setOutAnimation(android.content.Context, int)
 */

public android.animation.ObjectAnimator getOutAnimation() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the animation used to animate a View that exit the screen.
 *
 * @param outAnimation The animation started when a View exit the screen.
 *
 * @see #getOutAnimation()
 * @see #setOutAnimation(android.content.Context, int)
 */

public void setOutAnimation(android.animation.ObjectAnimator outAnimation) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the animation used to animate a View that enters the screen.
 *
 * @param context The application's environment.
 * @param resourceID The resource id of the animation.
 *
 * @see #getInAnimation()
 * @see #setInAnimation(android.animation.ObjectAnimator)
 */

public void setInAnimation(android.content.Context context, int resourceID) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the animation used to animate a View that exit the screen.
 *
 * @param context The application's environment.
 * @param resourceID The resource id of the animation.
 *
 * @see #getOutAnimation()
 * @see #setOutAnimation(android.animation.ObjectAnimator)
 */

public void setOutAnimation(android.content.Context context, int resourceID) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the current View should be animated the first time
 * the ViewAnimation is displayed.
 *
 * @param animate True to animate the current View the first time it is displayed,
 *                false otherwise.
 */

public void setAnimateFirstView(boolean animate) { throw new RuntimeException("Stub!"); }

public int getBaseline() { throw new RuntimeException("Stub!"); }

public android.widget.Adapter getAdapter() { throw new RuntimeException("Stub!"); }

public void setAdapter(android.widget.Adapter adapter) { throw new RuntimeException("Stub!"); }

/**
 * Sets up this AdapterViewAnimator to use a remote views adapter which connects to a
 * RemoteViewsService through the specified intent.
 *
 * @param intent the intent used to identify the RemoteViewsService for the adapter to
 *        connect to.
 */

public void setRemoteViewsAdapter(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

public void setSelection(int position) { throw new RuntimeException("Stub!"); }

public android.view.View getSelectedView() { throw new RuntimeException("Stub!"); }

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
 * Called by an {@link android.appwidget.AppWidgetHost} in order to advance the current view when
 * it is being used within an app widget.
 */

public void advance() { throw new RuntimeException("Stub!"); }

/**
 * Called by an {@link android.appwidget.AppWidgetHost} to indicate that it will be
 * automatically advancing the views of this {@link AdapterViewAnimator} by calling
 * {@link AdapterViewAnimator#advance()} at some point in the future. This allows subclasses to
 * perform any required setup, for example, to stop automatically advancing their children.
 */

public void fyiWillBeAdvancedByHostKThx() { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
}

