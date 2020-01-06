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

import android.os.Message;

/**
 * Simple {@link ViewAnimator} that will animate between two or more views
 * that have been added to it.  Only one child is shown at a time.  If
 * requested, can automatically flip between each child at a regular interval.
 *
 * @attr ref android.R.styleable#ViewFlipper_flipInterval
 * @attr ref android.R.styleable#ViewFlipper_autoStart
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView public class ViewFlipper extends android.widget.ViewAnimator {

public ViewFlipper(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ViewFlipper(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

protected void onWindowVisibilityChanged(int visibility) { throw new RuntimeException("Stub!"); }

/**
 * How long to wait before flipping to the next view
 *
 * @param milliseconds
 *            time in milliseconds
 */

public void setFlipInterval(int milliseconds) { throw new RuntimeException("Stub!"); }

/**
 * Start a timer to cycle through child views
 */

public void startFlipping() { throw new RuntimeException("Stub!"); }

/**
 * No more flips
 */

public void stopFlipping() { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

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
}

