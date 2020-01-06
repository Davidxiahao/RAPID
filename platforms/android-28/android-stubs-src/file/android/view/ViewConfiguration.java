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


package android.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/**
 * Contains methods to standard constants used in the UI for timeouts, sizes, and distances.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ViewConfiguration {

/**
 * @deprecated Use {@link android.view.ViewConfiguration#get(android.content.Context)} instead.
 */

@Deprecated public ViewConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Returns a configuration for the specified context. The configuration depends on
 * various parameters of the context, like the dimension of the display or the
 * density of the display.
 *
 * @param context The application context used to initialize the view configuration.
 */

public static android.view.ViewConfiguration get(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * @return The width of the horizontal scrollbar and the height of the vertical
 *         scrollbar in dips
 *
 * @deprecated Use {@link #getScaledScrollBarSize()} instead.
 */

@Deprecated public static int getScrollBarSize() { throw new RuntimeException("Stub!"); }

/**
 * @return The width of the horizontal scrollbar and the height of the vertical
 *         scrollbar in pixels
 */

public int getScaledScrollBarSize() { throw new RuntimeException("Stub!"); }

/**
 * @return Duration of the fade when scrollbars fade away in milliseconds
 */

public static int getScrollBarFadeDuration() { throw new RuntimeException("Stub!"); }

/**
 * @return Default delay before the scrollbars fade in milliseconds
 */

public static int getScrollDefaultDelay() { throw new RuntimeException("Stub!"); }

/**
 * @return the length of the fading edges in dips
 *
 * @deprecated Use {@link #getScaledFadingEdgeLength()} instead.
 */

@Deprecated public static int getFadingEdgeLength() { throw new RuntimeException("Stub!"); }

/**
 * @return the length of the fading edges in pixels
 */

public int getScaledFadingEdgeLength() { throw new RuntimeException("Stub!"); }

/**
 * @return the duration in milliseconds of the pressed state in child
 * components.
 */

public static int getPressedStateDuration() { throw new RuntimeException("Stub!"); }

/**
 * @return the duration in milliseconds before a press turns into
 * a long press
 */

public static int getLongPressTimeout() { throw new RuntimeException("Stub!"); }

/**
 * @return the time before the first key repeat in milliseconds.
 */

public static int getKeyRepeatTimeout() { throw new RuntimeException("Stub!"); }

/**
 * @return the time between successive key repeats in milliseconds.
 */

public static int getKeyRepeatDelay() { throw new RuntimeException("Stub!"); }

/**
 * @return the duration in milliseconds we will wait to see if a touch event
 * is a tap or a scroll. If the user does not move within this interval, it is
 * considered to be a tap.
 */

public static int getTapTimeout() { throw new RuntimeException("Stub!"); }

/**
 * @return the duration in milliseconds we will wait to see if a touch event
 * is a jump tap. If the user does not move within this interval, it is
 * considered to be a tap.
 */

public static int getJumpTapTimeout() { throw new RuntimeException("Stub!"); }

/**
 * @return the duration in milliseconds between the first tap's up event and
 * the second tap's down event for an interaction to be considered a
 * double-tap.
 */

public static int getDoubleTapTimeout() { throw new RuntimeException("Stub!"); }

/**
 * @return Inset in dips to look for touchable content when the user touches the edge of the
 *         screen
 *
 * @deprecated Use {@link #getScaledEdgeSlop()} instead.
 */

@Deprecated public static int getEdgeSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Inset in pixels to look for touchable content when the user touches the edge of the
 *         screen
 */

public int getScaledEdgeSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in dips a touch can wander before we think the user is scrolling
 *
 * @deprecated Use {@link #getScaledTouchSlop()} instead.
 */

@Deprecated public static int getTouchSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in pixels a touch can wander before we think the user is scrolling
 */

public int getScaledTouchSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in pixels a hover can wander while it is still considered "stationary".
 *
 */

public int getScaledHoverSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in pixels a touch can wander before we think the user is scrolling a full
 * page
 */

public int getScaledPagingTouchSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in pixels between the first touch and second touch to still be
 *         considered a double tap
 */

public int getScaledDoubleTapSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in dips a touch must be outside the bounds of a window for it
 * to be counted as outside the window for purposes of dismissing that
 * window.
 *
 * @deprecated Use {@link #getScaledWindowTouchSlop()} instead.
 */

@Deprecated public static int getWindowTouchSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Distance in pixels a touch must be outside the bounds of a window for it
 * to be counted as outside the window for purposes of dismissing that window.
 */

public int getScaledWindowTouchSlop() { throw new RuntimeException("Stub!"); }

/**
 * @return Minimum velocity to initiate a fling, as measured in dips per second.
 *
 * @deprecated Use {@link #getScaledMinimumFlingVelocity()} instead.
 */

@Deprecated public static int getMinimumFlingVelocity() { throw new RuntimeException("Stub!"); }

/**
 * @return Minimum velocity to initiate a fling, as measured in pixels per second.
 */

public int getScaledMinimumFlingVelocity() { throw new RuntimeException("Stub!"); }

/**
 * @return Maximum velocity to initiate a fling, as measured in dips per second.
 *
 * @deprecated Use {@link #getScaledMaximumFlingVelocity()} instead.
 */

@Deprecated public static int getMaximumFlingVelocity() { throw new RuntimeException("Stub!"); }

/**
 * @return Maximum velocity to initiate a fling, as measured in pixels per second.
 */

public int getScaledMaximumFlingVelocity() { throw new RuntimeException("Stub!"); }

/**
 * @return Amount to scroll in response to a horizontal {@link MotionEvent#ACTION_SCROLL} event.
 * Multiply this by the event's axis value to obtain the number of pixels to be scrolled.
 */

public float getScaledHorizontalScrollFactor() { throw new RuntimeException("Stub!"); }

/**
 * @return Amount to scroll in response to a vertical {@link MotionEvent#ACTION_SCROLL} event.
 * Multiply this by the event's axis value to obtain the number of pixels to be scrolled.
 */

public float getScaledVerticalScrollFactor() { throw new RuntimeException("Stub!"); }

/**
 * The maximum drawing cache size expressed in bytes.
 *
 * @return the maximum size of View's drawing cache expressed in bytes
 *
 * @deprecated Use {@link #getScaledMaximumDrawingCacheSize()} instead.
 */

@Deprecated public static int getMaximumDrawingCacheSize() { throw new RuntimeException("Stub!"); }

/**
 * The maximum drawing cache size expressed in bytes.
 *
 * @return the maximum size of View's drawing cache expressed in bytes
 */

public int getScaledMaximumDrawingCacheSize() { throw new RuntimeException("Stub!"); }

/**
 * @return The maximum distance a View should overscroll by when showing edge effects (in
 * pixels).
 */

public int getScaledOverscrollDistance() { throw new RuntimeException("Stub!"); }

/**
 * @return The maximum distance a View should overfling by when showing edge effects (in
 * pixels).
 */

public int getScaledOverflingDistance() { throw new RuntimeException("Stub!"); }

/**
 * The amount of time that the zoom controls should be
 * displayed on the screen expressed in milliseconds.
 *
 * @return the time the zoom controls should be visible expressed
 * in milliseconds.
 */

public static long getZoomControlsTimeout() { throw new RuntimeException("Stub!"); }

/**
 * The amount of time a user needs to press the relevant key to bring up
 * the global actions dialog.
 *
 * @return how long a user needs to press the relevant key to bring up
 *   the global actions dialog.
 * @deprecated This timeout should not be used by applications
 */

@Deprecated public static long getGlobalActionKeyTimeout() { throw new RuntimeException("Stub!"); }

/**
 * The amount of friction applied to scrolls and flings.
 *
 * @return A scalar dimensionless value representing the coefficient of
 *         friction.
 */

public static float getScrollFriction() { throw new RuntimeException("Stub!"); }

/**
 * @return the default duration in milliseconds for {@link ActionMode#hide(long)}.
 */

public static long getDefaultActionModeHideDuration() { throw new RuntimeException("Stub!"); }

/**
 * Report if the device has a permanent menu key available to the user.
 *
 * <p>As of Android 3.0, devices may not have a permanent menu key available.
 * Apps should use the action bar to present menu options to users.
 * However, there are some apps where the action bar is inappropriate
 * or undesirable. This method may be used to detect if a menu key is present.
 * If not, applications should provide another on-screen affordance to access
 * functionality.
 *
 * @return true if a permanent menu key is present, false otherwise.
 */

public boolean hasPermanentMenuKey() { throw new RuntimeException("Stub!"); }

/**
 * Check if shortcuts should be displayed in menus.
 *
 * @return {@code True} if shortcuts should be displayed in menus.
 */

public boolean shouldShowMenuShortcutsWhenKeyboardPresent() { throw new RuntimeException("Stub!"); }
}

