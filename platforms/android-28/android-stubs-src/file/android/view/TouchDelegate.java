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


package android.view;


/**
 * Helper class to handle situations where you want a view to have a larger touch area than its
 * actual view bounds. The view whose touch area is changed is called the delegate view. This
 * class should be used by an ancestor of the delegate. To use a TouchDelegate, first create an
 * instance that specifies the bounds that should be mapped to the delegate and the delegate
 * view itself.
 * <p>
 * The ancestor should then forward all of its touch events received in its
 * {@link android.view.View#onTouchEvent(MotionEvent)} to {@link #onTouchEvent(MotionEvent)}.
 * </p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TouchDelegate {

/**
 * Constructor
 *
 * @param bounds Bounds in local coordinates of the containing view that should be mapped to
 *        the delegate view
 * @param delegateView The view that should receive motion events
 */

public TouchDelegate(android.graphics.Rect bounds, android.view.View delegateView) { throw new RuntimeException("Stub!"); }

/**
 * Will forward touch events to the delegate view if the event is within the bounds
 * specified in the constructor.
 *
 * @param event The touch event to forward
 * @return True if the event was forwarded to the delegate, false otherwise.
 */

public boolean onTouchEvent(android.view.MotionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * The touchable region of the View extends above its actual extent.
 */

public static final int ABOVE = 1; // 0x1

/**
 * The touchable region of the View extends below its actual extent.
 */

public static final int BELOW = 2; // 0x2

/**
 * The touchable region of the View extends to the left of its actual extent.
 */

public static final int TO_LEFT = 4; // 0x4

/**
 * The touchable region of the View extends to the right of its actual extent.
 */

public static final int TO_RIGHT = 8; // 0x8
}

