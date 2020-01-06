/*
 * Copyright 2017 The Android Open Source Project
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
import android.graphics.Region.Op;
import android.graphics.Region;
import android.graphics.Path;
import android.os.Parcel;

/**
 * Represents the area of the display that is not functional for displaying content.
 *
 * <p>{@code DisplayCutout} is immutable.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DisplayCutout {

/**
 * Creates a DisplayCutout instance.
 *
 * @param safeInsets the insets from each edge which avoid the display cutout as returned by
 *                   {@link #getSafeInsetTop()} etc.
 * @param boundingRects the bounding rects of the display cutouts as returned by
 *               {@link #getBoundingRects()} ()}.
 */

public DisplayCutout(android.graphics.Rect safeInsets, java.util.List<android.graphics.Rect> boundingRects) { throw new RuntimeException("Stub!"); }

/** Returns the inset from the top which avoids the display cutout in pixels. */

public int getSafeInsetTop() { throw new RuntimeException("Stub!"); }

/** Returns the inset from the bottom which avoids the display cutout in pixels. */

public int getSafeInsetBottom() { throw new RuntimeException("Stub!"); }

/** Returns the inset from the left which avoids the display cutout in pixels. */

public int getSafeInsetLeft() { throw new RuntimeException("Stub!"); }

/** Returns the inset from the right which avoids the display cutout in pixels. */

public int getSafeInsetRight() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of {@code Rect}s, each of which is the bounding rectangle for a non-functional
 * area on the display.
 *
 * There will be at most one non-functional area per short edge of the device, and none on
 * the long edges.
 *
 * @return a list of bounding {@code Rect}s, one for each display cutout area.
 */

public java.util.List<android.graphics.Rect> getBoundingRects() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

