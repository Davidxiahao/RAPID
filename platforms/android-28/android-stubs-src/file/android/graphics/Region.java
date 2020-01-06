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


package android.graphics;

import android.os.Parcel;

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Region implements android.os.Parcelable {

/** Create an empty region
 */

public Region() { throw new RuntimeException("Stub!"); }

/** Return a copy of the specified region
 */

public Region(android.graphics.Region region) { throw new RuntimeException("Stub!"); }

/** Return a region set to the specified rectangle
 */

public Region(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

/** Return a region set to the specified rectangle
 */

public Region(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/** Set the region to the empty region
 */

public void setEmpty() { throw new RuntimeException("Stub!"); }

/** Set the region to the specified region.
 */

public boolean set(android.graphics.Region region) { throw new RuntimeException("Stub!"); }

/** Set the region to the specified rectangle
 */

public boolean set(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

/** Set the region to the specified rectangle
 */

public boolean set(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Set the region to the area described by the path and clip.
 * Return true if the resulting region is non-empty. This produces a region
 * that is identical to the pixels that would be drawn by the path
 * (with no antialiasing).
 */

public boolean setPath(android.graphics.Path path, android.graphics.Region clip) { throw new RuntimeException("Stub!"); }

/**
 * Return true if this region is empty
 */

public native boolean isEmpty();

/**
 * Return true if the region contains a single rectangle
 */

public native boolean isRect();

/**
 * Return true if the region contains more than one rectangle
 */

public native boolean isComplex();

/**
 * Return a new Rect set to the bounds of the region. If the region is
 * empty, the Rect will be set to [0, 0, 0, 0]
 */

public android.graphics.Rect getBounds() { throw new RuntimeException("Stub!"); }

/**
 * Set the Rect to the bounds of the region. If the region is empty, the
 * Rect will be set to [0, 0, 0, 0]
 */

public boolean getBounds(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

/**
 * Return the boundary of the region as a new Path. If the region is empty,
 * the path will also be empty.
 */

public android.graphics.Path getBoundaryPath() { throw new RuntimeException("Stub!"); }

/**
 * Set the path to the boundary of the region. If the region is empty, the
 * path will also be empty.
 */

public boolean getBoundaryPath(android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the region contains the specified point
 */

public native boolean contains(int x, int y);

/**
 * Return true if the region is a single rectangle (not complex) and it
 * contains the specified rectangle. Returning false is not a guarantee
 * that the rectangle is not contained by this region, but return true is a
 * guarantee that the rectangle is contained by this region.
 */

public boolean quickContains(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the region is a single rectangle (not complex) and it
 * contains the specified rectangle. Returning false is not a guarantee
 * that the rectangle is not contained by this region, but return true is a
 * guarantee that the rectangle is contained by this region.
 */

public native boolean quickContains(int left, int top, int right, int bottom);

/**
 * Return true if the region is empty, or if the specified rectangle does
 * not intersect the region. Returning false is not a guarantee that they
 * intersect, but returning true is a guarantee that they do not.
 */

public boolean quickReject(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the region is empty, or if the specified rectangle does
 * not intersect the region. Returning false is not a guarantee that they
 * intersect, but returning true is a guarantee that they do not.
 */

public native boolean quickReject(int left, int top, int right, int bottom);

/**
 * Return true if the region is empty, or if the specified region does not
 * intersect the region. Returning false is not a guarantee that they
 * intersect, but returning true is a guarantee that they do not.
 */

public native boolean quickReject(android.graphics.Region rgn);

/**
 * Translate the region by [dx, dy]. If the region is empty, do nothing.
 */

public void translate(int dx, int dy) { throw new RuntimeException("Stub!"); }

/**
 * Set the dst region to the result of translating this region by [dx, dy].
 * If this region is empty, then dst will be set to empty.
 */

public native void translate(int dx, int dy, android.graphics.Region dst);

public final boolean union(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

/**
 * Perform the specified Op on this region and the specified rect. Return
 * true if the result of the op is not empty.
 */

public boolean op(android.graphics.Rect r, android.graphics.Region.Op op) { throw new RuntimeException("Stub!"); }

/**
 * Perform the specified Op on this region and the specified rect. Return
 * true if the result of the op is not empty.
 */

public boolean op(int left, int top, int right, int bottom, android.graphics.Region.Op op) { throw new RuntimeException("Stub!"); }

/**
 * Perform the specified Op on this region and the specified region. Return
 * true if the result of the op is not empty.
 */

public boolean op(android.graphics.Region region, android.graphics.Region.Op op) { throw new RuntimeException("Stub!"); }

/**
 * Set this region to the result of performing the Op on the specified rect
 * and region. Return true if the result is not empty.
 */

public boolean op(android.graphics.Rect rect, android.graphics.Region region, android.graphics.Region.Op op) { throw new RuntimeException("Stub!"); }

/**
 * Set this region to the result of performing the Op on the specified
 * regions. Return true if the result is not empty.
 */

public boolean op(android.graphics.Region region1, android.graphics.Region region2, android.graphics.Region.Op op) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Write the region and its pixels to the parcel. The region can be
 * rebuilt from the parcel by calling CREATOR.createFromParcel().
 * @param p    Parcel object to write the region data into
 */

public void writeToParcel(android.os.Parcel p, int flags) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.graphics.Region> CREATOR;
static { CREATOR = null; }
@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Op {
DIFFERENCE, INTERSECT, UNION, XOR, REVERSE_DIFFERENCE, REPLACE;
}

}

