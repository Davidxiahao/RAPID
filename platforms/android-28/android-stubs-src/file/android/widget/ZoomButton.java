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

/**
 * This widget provides a simple utility for turning a continued long-press event
 * into a series of clicks at some set frequency. There is no actual 'zoom' functionality
 * handled by this widget directly. Instead, clients of this API should set up an
 * {@link View#setOnClickListener(OnClickListener) onClickListener} to handle
 * zoom functionality. That click listener is called on a frequency
 * determined by {@link #setZoomSpeed(long)} whenever the user long-presses
 * on the ZoomButton.
 *
 * @deprecated Use other means to handle this functionality. This widget is merely a
 * simple wrapper around a long-press handler.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public class ZoomButton extends android.widget.ImageButton implements android.view.View.OnLongClickListener {

public ZoomButton(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ZoomButton(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ZoomButton(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ZoomButton(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Sets the delay between calls to the widget's {@link View#setOnClickListener(OnClickListener)
 * onClickListener}.
 *
 * @param speed The delay between calls to the click listener, in milliseconds
 */

public void setZoomSpeed(long speed) { throw new RuntimeException("Stub!"); }

public boolean onLongClick(android.view.View v) { throw new RuntimeException("Stub!"); }

public boolean onKeyUp(int keyCode, android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public void setEnabled(boolean enabled) { throw new RuntimeException("Stub!"); }

public boolean dispatchUnhandledMove(android.view.View focused, int direction) { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
}

