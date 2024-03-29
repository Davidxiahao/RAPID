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

import android.os.Message;

/**
 * Simple {@link ViewAnimator} that will animate between two or more views
 * that have been added to it.  Only one child is shown at a time.  If
 * requested, can automatically flip between each child at a regular interval.
 *
 * @attr ref android.R.styleable#AdapterViewFlipper_flipInterval
 * @attr ref android.R.styleable#AdapterViewFlipper_autoStart
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView public class AdapterViewFlipper extends android.widget.AdapterViewAnimator {

public AdapterViewFlipper(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public AdapterViewFlipper(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public AdapterViewFlipper(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public AdapterViewFlipper(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

protected void onWindowVisibilityChanged(int visibility) { throw new RuntimeException("Stub!"); }

public void setAdapter(android.widget.Adapter adapter) { throw new RuntimeException("Stub!"); }

/**
 * Returns the flip interval, in milliseconds.
 *
 * @return the flip interval in milliseconds
 *
 * @see #setFlipInterval(int)
 *
 * @attr ref android.R.styleable#AdapterViewFlipper_flipInterval
 */

public int getFlipInterval() { throw new RuntimeException("Stub!"); }

/**
 * How long to wait before flipping to the next view.
 *
 * @param flipInterval flip interval in milliseconds
 *
 * @see #getFlipInterval()
 *
 * @attr ref android.R.styleable#AdapterViewFlipper_flipInterval
 */

public void setFlipInterval(int flipInterval) { throw new RuntimeException("Stub!"); }

/**
 * Start a timer to cycle through child views
 */

public void startFlipping() { throw new RuntimeException("Stub!"); }

/**
 * No more flips
 */

public void stopFlipping() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public void showNext() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public void showPrevious() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the child views are flipping.
 */

public boolean isFlipping() { throw new RuntimeException("Stub!"); }

/**
 * Set if this view automatically calls {@link #startFlipping()} when it
 * becomes attached to a window.
 */

public void setAutoStart(boolean autoStart) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this view automatically calls {@link #startFlipping()}
 * when it becomes attached to a window.
 */

public boolean isAutoStart() { throw new RuntimeException("Stub!"); }

/**
 * Called by an {@link android.appwidget.AppWidgetHost} to indicate that it will be
 * automatically advancing the views of this {@link AdapterViewFlipper} by calling
 * {@link AdapterViewFlipper#advance()} at some point in the future. This allows
 * {@link AdapterViewFlipper} to prepare by no longer Advancing its children.
 */

public void fyiWillBeAdvancedByHostKThx() { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
}

