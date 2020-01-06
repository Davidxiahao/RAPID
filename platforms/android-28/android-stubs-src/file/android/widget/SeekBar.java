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


/**
 * A SeekBar is an extension of ProgressBar that adds a draggable thumb. The user can touch
 * the thumb and drag left or right to set the current progress level or use the arrow keys.
 * Placing focusable widgets to the left or right of a SeekBar is discouraged.
 * <p>
 * Clients of the SeekBar can attach a {@link SeekBar.OnSeekBarChangeListener} to
 * be notified of the user's actions.
 *
 * @attr ref android.R.styleable#SeekBar_thumb
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SeekBar extends android.widget.AbsSeekBar {

public SeekBar(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public SeekBar(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public SeekBar(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public SeekBar(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets a listener to receive notifications of changes to the SeekBar's progress level. Also
 * provides notifications of when the user starts and stops a touch gesture within the SeekBar.
 *
 * @param l The seek bar notification listener
 *
 * @see SeekBar.OnSeekBarChangeListener
 */

public void setOnSeekBarChangeListener(android.widget.SeekBar.OnSeekBarChangeListener l) { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }
/**
 * A callback that notifies clients when the progress level has been
 * changed. This includes changes that were initiated by the user through a
 * touch gesture or arrow key/trackball as well as changes that were initiated
 * programmatically.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnSeekBarChangeListener {

/**
 * Notification that the progress level has changed. Clients can use the fromUser parameter
 * to distinguish user-initiated changes from those that occurred programmatically.
 *
 * @param seekBar The SeekBar whose progress has changed
 * @param progress The current progress level. This will be in the range min..max where min
 *                 and max were set by {@link ProgressBar#setMin(int)} and
 *                 {@link ProgressBar#setMax(int)}, respectively. (The default values for
 *                 min is 0 and max is 100.)
 * @param fromUser True if the progress change was initiated by the user.
 */

public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser);

/**
 * Notification that the user has started a touch gesture. Clients may want to use this
 * to disable advancing the seekbar.
 * @param seekBar The SeekBar in which the touch gesture began
 */

public void onStartTrackingTouch(android.widget.SeekBar seekBar);

/**
 * Notification that the user has finished a touch gesture. Clients may want to use this
 * to re-enable advancing the seekbar.
 * @param seekBar The SeekBar in which the touch gesture began
 */

public void onStopTrackingTouch(android.widget.SeekBar seekBar);
}

}

