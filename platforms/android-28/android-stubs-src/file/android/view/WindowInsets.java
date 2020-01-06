/*
 * Copyright (C) 2014 The Android Open Source Project
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

import android.graphics.Rect;

/**
 * Describes a set of insets for window content.
 *
 * <p>WindowInsets are immutable and may be expanded to include more inset types in the future.
 * To adjust insets, use one of the supplied clone methods to obtain a new WindowInsets instance
 * with the adjusted properties.</p>
 *
 * <p>Note: Before {@link android.os.Build.VERSION_CODES#P P}, WindowInsets instances were only
 * immutable during a single layout pass (i.e. would return the same values between
 * {@link View#onApplyWindowInsets} and {@link View#onLayout}, but could return other values
 * otherwise). Starting with {@link android.os.Build.VERSION_CODES#P P}, WindowInsets are
 * always immutable and implement equality.
 *
 * @see View.OnApplyWindowInsetsListener
 * @see View#onApplyWindowInsets(WindowInsets)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class WindowInsets {

/**
 * Construct a new WindowInsets, copying all values from a source WindowInsets.
 *
 * @param src Source to copy insets from
 */

public WindowInsets(android.view.WindowInsets src) { throw new RuntimeException("Stub!"); }

/**
 * Returns the left system window inset in pixels.
 *
 * <p>The system window inset represents the area of a full-screen window that is
 * partially or fully obscured by the status bar, navigation bar, IME or other system windows.
 * </p>
 *
 * @return The left system window inset
 */

public int getSystemWindowInsetLeft() { throw new RuntimeException("Stub!"); }

/**
 * Returns the top system window inset in pixels.
 *
 * <p>The system window inset represents the area of a full-screen window that is
 * partially or fully obscured by the status bar, navigation bar, IME or other system windows.
 * </p>
 *
 * @return The top system window inset
 */

public int getSystemWindowInsetTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the right system window inset in pixels.
 *
 * <p>The system window inset represents the area of a full-screen window that is
 * partially or fully obscured by the status bar, navigation bar, IME or other system windows.
 * </p>
 *
 * @return The right system window inset
 */

public int getSystemWindowInsetRight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the bottom system window inset in pixels.
 *
 * <p>The system window inset represents the area of a full-screen window that is
 * partially or fully obscured by the status bar, navigation bar, IME or other system windows.
 * </p>
 *
 * @return The bottom system window inset
 */

public int getSystemWindowInsetBottom() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this WindowInsets has nonzero system window insets.
 *
 * <p>The system window inset represents the area of a full-screen window that is
 * partially or fully obscured by the status bar, navigation bar, IME or other system windows.
 * </p>
 *
 * @return true if any of the system window inset values are nonzero
 */

public boolean hasSystemWindowInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this WindowInsets has any nonzero insets.
 *
 * @return true if any inset values are nonzero
 */

public boolean hasInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns the display cutout if there is one.
 *
 * @return the display cutout or null if there is none
 * @see DisplayCutout
 */

@androidx.annotation.RecentlyNullable public android.view.DisplayCutout getDisplayCutout() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this WindowInsets with the cutout fully consumed.
 *
 * @return A modified copy of this WindowInsets
 */

public android.view.WindowInsets consumeDisplayCutout() { throw new RuntimeException("Stub!"); }

/**
 * Check if these insets have been fully consumed.
 *
 * <p>Insets are considered "consumed" if the applicable <code>consume*</code> methods
 * have been called such that all insets have been set to zero. This affects propagation of
 * insets through the view hierarchy; insets that have not been fully consumed will continue
 * to propagate down to child views.</p>
 *
 * <p>The result of this method is equivalent to the return value of
 * {@link View#fitSystemWindows(android.graphics.Rect)}.</p>
 *
 * @return true if the insets have been fully consumed.
 */

public boolean isConsumed() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the associated window has a round shape.
 *
 * <p>A round window's left, top, right and bottom edges reach all the way to the
 * associated edges of the window but the corners may not be visible. Views responding
 * to round insets should take care to not lay out critical elements within the corners
 * where they may not be accessible.</p>
 *
 * @return True if the window is round
 */

public boolean isRound() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this WindowInsets with the system window insets fully consumed.
 *
 * @return A modified copy of this WindowInsets
 */

public android.view.WindowInsets consumeSystemWindowInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this WindowInsets with selected system window insets replaced
 * with new values.
 *
 * @param left New left inset in pixels
 * @param top New top inset in pixels
 * @param right New right inset in pixels
 * @param bottom New bottom inset in pixels
 * @return A modified copy of this WindowInsets
 */

public android.view.WindowInsets replaceSystemWindowInsets(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this WindowInsets with selected system window insets replaced
 * with new values.
 *
 * @param systemWindowInsets New system window insets. Each field is the inset in pixels
 *                           for that edge
 * @return A modified copy of this WindowInsets
 */

public android.view.WindowInsets replaceSystemWindowInsets(android.graphics.Rect systemWindowInsets) { throw new RuntimeException("Stub!"); }

/**
 * Returns the top stable inset in pixels.
 *
 * <p>The stable inset represents the area of a full-screen window that <b>may</b> be
 * partially or fully obscured by the system UI elements.  This value does not change
 * based on the visibility state of those elements; for example, if the status bar is
 * normally shown, but temporarily hidden, the stable inset will still provide the inset
 * associated with the status bar being shown.</p>
 *
 * @return The top stable inset
 */

public int getStableInsetTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the left stable inset in pixels.
 *
 * <p>The stable inset represents the area of a full-screen window that <b>may</b> be
 * partially or fully obscured by the system UI elements.  This value does not change
 * based on the visibility state of those elements; for example, if the status bar is
 * normally shown, but temporarily hidden, the stable inset will still provide the inset
 * associated with the status bar being shown.</p>
 *
 * @return The left stable inset
 */

public int getStableInsetLeft() { throw new RuntimeException("Stub!"); }

/**
 * Returns the right stable inset in pixels.
 *
 * <p>The stable inset represents the area of a full-screen window that <b>may</b> be
 * partially or fully obscured by the system UI elements.  This value does not change
 * based on the visibility state of those elements; for example, if the status bar is
 * normally shown, but temporarily hidden, the stable inset will still provide the inset
 * associated with the status bar being shown.</p>
 *
 * @return The right stable inset
 */

public int getStableInsetRight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the bottom stable inset in pixels.
 *
 * <p>The stable inset represents the area of a full-screen window that <b>may</b> be
 * partially or fully obscured by the system UI elements.  This value does not change
 * based on the visibility state of those elements; for example, if the status bar is
 * normally shown, but temporarily hidden, the stable inset will still provide the inset
 * associated with the status bar being shown.</p>
 *
 * @return The bottom stable inset
 */

public int getStableInsetBottom() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this WindowInsets has nonzero stable insets.
 *
 * <p>The stable inset represents the area of a full-screen window that <b>may</b> be
 * partially or fully obscured by the system UI elements.  This value does not change
 * based on the visibility state of those elements; for example, if the status bar is
 * normally shown, but temporarily hidden, the stable inset will still provide the inset
 * associated with the status bar being shown.</p>
 *
 * @return true if any of the stable inset values are nonzero
 */

public boolean hasStableInsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this WindowInsets with the stable insets fully consumed.
 *
 * @return A modified copy of this WindowInsets
 */

public android.view.WindowInsets consumeStableInsets() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }
}

