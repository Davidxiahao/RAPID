/*
 * Copyright (C) 2017 The Android Open Source Project
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
import android.view.Surface;
import android.view.SurfaceView;

/**
 * Android magnifier widget. Can be used by any view which is attached to a window.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Magnifier {

/**
 * Initializes a magnifier.
 *
 * @param view the view for which this magnifier is attached

 * This value must never be {@code null}.
 */

public Magnifier(@androidx.annotation.RecentlyNonNull android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Shows the magnifier on the screen.
 *
 * @param xPosInView horizontal coordinate of the center point of the magnifier source relative
 *        to the view. The lower end is clamped to 0 and the higher end is clamped to the view
 *        width.
 * Value is 0 or greater
 * @param yPosInView vertical coordinate of the center point of the magnifier source
 *        relative to the view. The lower end is clamped to 0 and the higher end is clamped to
 *        the view height.

 * Value is 0 or greater
 */

public void show(float xPosInView, float yPosInView) { throw new RuntimeException("Stub!"); }

/**
 * Dismisses the magnifier from the screen. Calling this on a dismissed magnifier is a no-op.
 */

public void dismiss() { throw new RuntimeException("Stub!"); }

/**
 * Forces the magnifier to update its content. It uses the previous coordinates passed to
 * {@link #show(float, float)}. This only happens if the magnifier is currently showing.
 */

public void update() { throw new RuntimeException("Stub!"); }

/**
 * @return The width of the magnifier window, in pixels.
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * @return The height of the magnifier window, in pixels.
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * @return The zoom applied to the magnified view region copied to the magnifier window.
 * If the zoom is x and the magnifier window size is (width, height), the original size
 * of the content copied in the magnifier will be (width / x, height / x).
 */

public float getZoom() { throw new RuntimeException("Stub!"); }
}

