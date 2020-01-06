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
import android.os.Parcelable;

/**
 * RectF holds four float coordinates for a rectangle. The rectangle is
 * represented by the coordinates of its 4 edges (left, top, right bottom).
 * These fields can be accessed directly. Use width() and height() to retrieve
 * the rectangle's width and height. Note: most methods do not check to see that
 * the coordinates are sorted correctly (i.e. left <= right and top <= bottom).
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RectF implements android.os.Parcelable {

/**
 * Create a new empty RectF. All coordinates are initialized to 0.
 */

public RectF() { throw new RuntimeException("Stub!"); }

/**
 * Create a new rectangle with the specified coordinates. Note: no range
 * checking is performed, so the caller must ensure that left <= right and
 * top <= bottom.
 *
 * @param left   The X coordinate of the left side of the rectangle
 * @param top    The Y coordinate of the top of the rectangle
 * @param right  The X coordinate of the right side of the rectangle
 * @param bottom The Y coordinate of the bottom of the rectangle
 */

public RectF(float left, float top, float right, float bottom) { throw new RuntimeException("Stub!"); }

/**
 * Create a new rectangle, initialized with the values in the specified
 * rectangle (which is left unmodified).
 *
 * @param r The rectangle whose coordinates are copied into the new
 *          rectangle.
 */

public RectF(android.graphics.RectF r) { throw new RuntimeException("Stub!"); }

public RectF(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Return a string representation of the rectangle in a compact form.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String toShortString() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the rectangle is empty (left >= right or top >= bottom)
 */

public final boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * @return the rectangle's width. This does not check for a valid rectangle
 * (i.e. left <= right) so the result may be negative.
 */

public final float width() { throw new RuntimeException("Stub!"); }

/**
 * @return the rectangle's height. This does not check for a valid rectangle
 * (i.e. top <= bottom) so the result may be negative.
 */

public final float height() { throw new RuntimeException("Stub!"); }

/**
 * @return the horizontal center of the rectangle. This does not check for
 * a valid rectangle (i.e. left <= right)
 */

public final float centerX() { throw new RuntimeException("Stub!"); }

/**
 * @return the vertical center of the rectangle. This does not check for
 * a valid rectangle (i.e. top <= bottom)
 */

public final float centerY() { throw new RuntimeException("Stub!"); }

/**
 * Set the rectangle to (0,0,0,0)
 */

public void setEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Set the rectangle's coordinates to the specified values. Note: no range
 * checking is performed, so it is up to the caller to ensure that
 * left <= right and top <= bottom.
 *
 * @param left   The X coordinate of the left side of the rectangle
 * @param top    The Y coordinate of the top of the rectangle
 * @param right  The X coordinate of the right side of the rectangle
 * @param bottom The Y coordinate of the bottom of the rectangle
 */

public void set(float left, float top, float right, float bottom) { throw new RuntimeException("Stub!"); }

/**
 * Copy the coordinates from src into this rectangle.
 *
 * @param src The rectangle whose coordinates are copied into this
 *           rectangle.
 */

public void set(android.graphics.RectF src) { throw new RuntimeException("Stub!"); }

/**
 * Copy the coordinates from src into this rectangle.
 *
 * @param src The rectangle whose coordinates are copied into this
 *           rectangle.
 */

public void set(android.graphics.Rect src) { throw new RuntimeException("Stub!"); }

/**
 * Offset the rectangle by adding dx to its left and right coordinates, and
 * adding dy to its top and bottom coordinates.
 *
 * @param dx The amount to add to the rectangle's left and right coordinates
 * @param dy The amount to add to the rectangle's top and bottom coordinates
 */

public void offset(float dx, float dy) { throw new RuntimeException("Stub!"); }

/**
 * Offset the rectangle to a specific (left, top) position,
 * keeping its width and height the same.
 *
 * @param newLeft   The new "left" coordinate for the rectangle
 * @param newTop    The new "top" coordinate for the rectangle
 */

public void offsetTo(float newLeft, float newTop) { throw new RuntimeException("Stub!"); }

/**
 * Inset the rectangle by (dx,dy). If dx is positive, then the sides are
 * moved inwards, making the rectangle narrower. If dx is negative, then the
 * sides are moved outwards, making the rectangle wider. The same holds true
 * for dy and the top and bottom.
 *
 * @param dx The amount to add(subtract) from the rectangle's left(right)
 * @param dy The amount to add(subtract) from the rectangle's top(bottom)
 */

public void inset(float dx, float dy) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if (x,y) is inside the rectangle. The left and top are
 * considered to be inside, while the right and bottom are not. This means
 * that for a x,y to be contained: left <= x < right and top <= y < bottom.
 * An empty rectangle never contains any point.
 *
 * @param x The X coordinate of the point being tested for containment
 * @param y The Y coordinate of the point being tested for containment
 * @return true iff (x,y) are contained by the rectangle, where containment
 *              means left <= x < right and top <= y < bottom
 */

public boolean contains(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Returns true iff the 4 specified sides of a rectangle are inside or equal
 * to this rectangle. i.e. is this rectangle a superset of the specified
 * rectangle. An empty rectangle never contains another rectangle.
 *
 * @param left The left side of the rectangle being tested for containment
 * @param top The top of the rectangle being tested for containment
 * @param right The right side of the rectangle being tested for containment
 * @param bottom The bottom of the rectangle being tested for containment
 * @return true iff the the 4 specified sides of a rectangle are inside or
 *              equal to this rectangle
 */

public boolean contains(float left, float top, float right, float bottom) { throw new RuntimeException("Stub!"); }

/**
 * Returns true iff the specified rectangle r is inside or equal to this
 * rectangle. An empty rectangle never contains another rectangle.
 *
 * @param r The rectangle being tested for containment.
 * @return true iff the specified rectangle r is inside or equal to this
 *              rectangle
 */

public boolean contains(android.graphics.RectF r) { throw new RuntimeException("Stub!"); }

/**
 * If the rectangle specified by left,top,right,bottom intersects this
 * rectangle, return true and set this rectangle to that intersection,
 * otherwise return false and do not change this rectangle. No check is
 * performed to see if either rectangle is empty. Note: To just test for
 * intersection, use intersects()
 *
 * @param left The left side of the rectangle being intersected with this
 *             rectangle
 * @param top The top of the rectangle being intersected with this rectangle
 * @param right The right side of the rectangle being intersected with this
 *              rectangle.
 * @param bottom The bottom of the rectangle being intersected with this
 *             rectangle.
 * @return true if the specified rectangle and this rectangle intersect
 *              (and this rectangle is then set to that intersection) else
 *              return false and do not change this rectangle.
 */

public boolean intersect(float left, float top, float right, float bottom) { throw new RuntimeException("Stub!"); }

/**
 * If the specified rectangle intersects this rectangle, return true and set
 * this rectangle to that intersection, otherwise return false and do not
 * change this rectangle. No check is performed to see if either rectangle
 * is empty. To just test for intersection, use intersects()
 *
 * @param r The rectangle being intersected with this rectangle.
 * @return true if the specified rectangle and this rectangle intersect
 *              (and this rectangle is then set to that intersection) else
 *              return false and do not change this rectangle.
 */

public boolean intersect(android.graphics.RectF r) { throw new RuntimeException("Stub!"); }

/**
 * If rectangles a and b intersect, return true and set this rectangle to
 * that intersection, otherwise return false and do not change this
 * rectangle. No check is performed to see if either rectangle is empty.
 * To just test for intersection, use intersects()
 *
 * @param a The first rectangle being intersected with
 * @param b The second rectangle being intersected with
 * @return true iff the two specified rectangles intersect. If they do, set
 *              this rectangle to that intersection. If they do not, return
 *              false and do not change this rectangle.
 */

public boolean setIntersect(android.graphics.RectF a, android.graphics.RectF b) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this rectangle intersects the specified rectangle.
 * In no event is this rectangle modified. No check is performed to see
 * if either rectangle is empty. To record the intersection, use intersect()
 * or setIntersect().
 *
 * @param left The left side of the rectangle being tested for intersection
 * @param top The top of the rectangle being tested for intersection
 * @param right The right side of the rectangle being tested for
 *              intersection
 * @param bottom The bottom of the rectangle being tested for intersection
 * @return true iff the specified rectangle intersects this rectangle. In
 *              no event is this rectangle modified.
 */

public boolean intersects(float left, float top, float right, float bottom) { throw new RuntimeException("Stub!"); }

/**
 * Returns true iff the two specified rectangles intersect. In no event are
 * either of the rectangles modified. To record the intersection,
 * use intersect() or setIntersect().
 *
 * @param a The first rectangle being tested for intersection
 * @param b The second rectangle being tested for intersection
 * @return true iff the two specified rectangles intersect. In no event are
 *              either of the rectangles modified.
 */

public static boolean intersects(android.graphics.RectF a, android.graphics.RectF b) { throw new RuntimeException("Stub!"); }

/**
 * Set the dst integer Rect by rounding this rectangle's coordinates
 * to their nearest integer values.
 */

public void round(android.graphics.Rect dst) { throw new RuntimeException("Stub!"); }

/**
 * Set the dst integer Rect by rounding "out" this rectangle, choosing the
 * floor of top and left, and the ceiling of right and bottom.
 */

public void roundOut(android.graphics.Rect dst) { throw new RuntimeException("Stub!"); }

/**
 * Update this Rect to enclose itself and the specified rectangle. If the
 * specified rectangle is empty, nothing is done. If this rectangle is empty
 * it is set to the specified rectangle.
 *
 * @param left The left edge being unioned with this rectangle
 * @param top The top edge being unioned with this rectangle
 * @param right The right edge being unioned with this rectangle
 * @param bottom The bottom edge being unioned with this rectangle
 */

public void union(float left, float top, float right, float bottom) { throw new RuntimeException("Stub!"); }

/**
 * Update this Rect to enclose itself and the specified rectangle. If the
 * specified rectangle is empty, nothing is done. If this rectangle is empty
 * it is set to the specified rectangle.
 *
 * @param r The rectangle being unioned with this rectangle
 */

public void union(android.graphics.RectF r) { throw new RuntimeException("Stub!"); }

/**
 * Update this Rect to enclose itself and the [x,y] coordinate. There is no
 * check to see that this rectangle is non-empty.
 *
 * @param x The x coordinate of the point to add to the rectangle
 * @param y The y coordinate of the point to add to the rectangle
 */

public void union(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Swap top/bottom or left/right if there are flipped (i.e. left > right
 * and/or top > bottom). This can be called if
 * the edges are computed separately, and may have crossed over each other.
 * If the edges are already correct (i.e. left <= right and top <= bottom)
 * then nothing is done.
 */

public void sort() { throw new RuntimeException("Stub!"); }

/**
 * Parcelable interface methods
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Write this rectangle to the specified parcel. To restore a rectangle from
 * a parcel, use readFromParcel()
 * @param out The parcel to write the rectangle's coordinates into
 */

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Set the rectangle's coordinates from the data stored in the specified
 * parcel. To write a rectangle to a parcel, call writeToParcel().
 *
 * @param in The parcel to read the rectangle's coordinates from
 */

public void readFromParcel(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.graphics.RectF> CREATOR;
static { CREATOR = null; }

public float bottom;

public float left;

public float right;

public float top;
}

