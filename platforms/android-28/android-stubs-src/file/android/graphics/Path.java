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


/**
 * The Path class encapsulates compound (multiple contour) geometric paths
 * consisting of straight line segments, quadratic curves, and cubic curves.
 * It can be drawn with canvas.drawPath(path, paint), either filled or stroked
 * (based on the paint's Style), or it can be used for clipping or to draw
 * text on a path.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Path {

/**
 * Create an empty path
 */

public Path() { throw new RuntimeException("Stub!"); }

/**
 * Create a new path, copying the contents from the src path.
 *
 * @param src The path to copy from when initializing the new path
 */

public Path(android.graphics.Path src) { throw new RuntimeException("Stub!"); }

/**
 * Clear any lines and curves from the path, making it empty.
 * This does NOT change the fill-type setting.
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Rewinds the path: clears any lines and curves from the path but
 * keeps the internal data structure for faster reuse.
 */

public void rewind() { throw new RuntimeException("Stub!"); }

/** Replace the contents of this with the contents of src.
 * @param src This value must never be {@code null}.
 */

public void set(@androidx.annotation.RecentlyNonNull android.graphics.Path src) { throw new RuntimeException("Stub!"); }

/**
 * Set this path to the result of applying the Op to this path and the specified path.
 * The resulting path will be constructed from non-overlapping contours.
 * The curve order is reduced where possible so that cubics may be turned
 * into quadratics, and quadratics maybe turned into lines.
 *
 * @param path The second operand (for difference, the subtrahend)
 *
 * @return True if operation succeeded, false otherwise and this path remains unmodified.
 *
 * @see Op
 * @see #op(Path, Path, android.graphics.Path.Op)
 */

public boolean op(android.graphics.Path path, android.graphics.Path.Op op) { throw new RuntimeException("Stub!"); }

/**
 * Set this path to the result of applying the Op to the two specified paths.
 * The resulting path will be constructed from non-overlapping contours.
 * The curve order is reduced where possible so that cubics may be turned
 * into quadratics, and quadratics maybe turned into lines.
 *
 * @param path1 The first operand (for difference, the minuend)
 * @param path2 The second operand (for difference, the subtrahend)
 *
 * @return True if operation succeeded, false otherwise and this path remains unmodified.
 *
 * @see Op
 * @see #op(Path, android.graphics.Path.Op)
 */

public boolean op(android.graphics.Path path1, android.graphics.Path path2, android.graphics.Path.Op op) { throw new RuntimeException("Stub!"); }

/**
 * Returns the path's convexity, as defined by the content of the path.
 * <p>
 * A path is convex if it has a single contour, and only ever curves in a
 * single direction.
 * <p>
 * This function will calculate the convexity of the path from its control
 * points, and cache the result.
 *
 * @return True if the path is convex.
 */

public boolean isConvex() { throw new RuntimeException("Stub!"); }

/**
 * Return the path's fill type. This defines how "inside" is
 * computed. The default value is WINDING.
 *
 * @return the path's fill type
 */

@androidx.annotation.RecentlyNonNull public android.graphics.Path.FillType getFillType() { throw new RuntimeException("Stub!"); }

/**
 * Set the path's fill type. This defines how "inside" is computed.
 *
 * @param ft The new fill type for this path
 */

public void setFillType(android.graphics.Path.FillType ft) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the filltype is one of the INVERSE variants
 *
 * @return true if the filltype is one of the INVERSE variants
 */

public boolean isInverseFillType() { throw new RuntimeException("Stub!"); }

/**
 * Toggles the INVERSE state of the filltype
 */

public void toggleInverseFillType() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the path is empty (contains no lines or curves)
 *
 * @return true if the path is empty (contains no lines or curves)
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the path specifies a rectangle. If so, and if rect is
 * not null, set rect to the bounds of the path. If the path does not
 * specify a rectangle, return false and ignore rect.
 *
 * @param rect If not null, returns the bounds of the path if it specifies
 *             a rectangle
 * This value may be {@code null}.
 * @return     true if the path specifies a rectangle
 */

public boolean isRect(@androidx.annotation.RecentlyNullable android.graphics.RectF rect) { throw new RuntimeException("Stub!"); }

/**
 * Compute the bounds of the control points of the path, and write the
 * answer into bounds. If the path contains 0 or 1 points, the bounds is
 * set to (0,0,0,0)
 *
 * @param bounds Returns the computed bounds of the path's control points.
 * @param exact This parameter is no longer used.
 */

public void computeBounds(android.graphics.RectF bounds, boolean exact) { throw new RuntimeException("Stub!"); }

/**
 * Hint to the path to prepare for adding more points. This can allow the
 * path to more efficiently allocate its storage.
 *
 * @param extraPtCount The number of extra points that may be added to this
 *                     path
 */

public void incReserve(int extraPtCount) { throw new RuntimeException("Stub!"); }

/**
 * Set the beginning of the next contour to the point (x,y).
 *
 * @param x The x-coordinate of the start of a new contour
 * @param y The y-coordinate of the start of a new contour
 */

public void moveTo(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Set the beginning of the next contour relative to the last point on the
 * previous contour. If there is no previous contour, this is treated the
 * same as moveTo().
 *
 * @param dx The amount to add to the x-coordinate of the end of the
 *           previous contour, to specify the start of a new contour
 * @param dy The amount to add to the y-coordinate of the end of the
 *           previous contour, to specify the start of a new contour
 */

public void rMoveTo(float dx, float dy) { throw new RuntimeException("Stub!"); }

/**
 * Add a line from the last point to the specified point (x,y).
 * If no moveTo() call has been made for this contour, the first point is
 * automatically set to (0,0).
 *
 * @param x The x-coordinate of the end of a line
 * @param y The y-coordinate of the end of a line
 */

public void lineTo(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Same as lineTo, but the coordinates are considered relative to the last
 * point on this contour. If there is no previous point, then a moveTo(0,0)
 * is inserted automatically.
 *
 * @param dx The amount to add to the x-coordinate of the previous point on
 *           this contour, to specify a line
 * @param dy The amount to add to the y-coordinate of the previous point on
 *           this contour, to specify a line
 */

public void rLineTo(float dx, float dy) { throw new RuntimeException("Stub!"); }

/**
 * Add a quadratic bezier from the last point, approaching control point
 * (x1,y1), and ending at (x2,y2). If no moveTo() call has been made for
 * this contour, the first point is automatically set to (0,0).
 *
 * @param x1 The x-coordinate of the control point on a quadratic curve
 * @param y1 The y-coordinate of the control point on a quadratic curve
 * @param x2 The x-coordinate of the end point on a quadratic curve
 * @param y2 The y-coordinate of the end point on a quadratic curve
 */

public void quadTo(float x1, float y1, float x2, float y2) { throw new RuntimeException("Stub!"); }

/**
 * Same as quadTo, but the coordinates are considered relative to the last
 * point on this contour. If there is no previous point, then a moveTo(0,0)
 * is inserted automatically.
 *
 * @param dx1 The amount to add to the x-coordinate of the last point on
 *            this contour, for the control point of a quadratic curve
 * @param dy1 The amount to add to the y-coordinate of the last point on
 *            this contour, for the control point of a quadratic curve
 * @param dx2 The amount to add to the x-coordinate of the last point on
 *            this contour, for the end point of a quadratic curve
 * @param dy2 The amount to add to the y-coordinate of the last point on
 *            this contour, for the end point of a quadratic curve
 */

public void rQuadTo(float dx1, float dy1, float dx2, float dy2) { throw new RuntimeException("Stub!"); }

/**
 * Add a cubic bezier from the last point, approaching control points
 * (x1,y1) and (x2,y2), and ending at (x3,y3). If no moveTo() call has been
 * made for this contour, the first point is automatically set to (0,0).
 *
 * @param x1 The x-coordinate of the 1st control point on a cubic curve
 * @param y1 The y-coordinate of the 1st control point on a cubic curve
 * @param x2 The x-coordinate of the 2nd control point on a cubic curve
 * @param y2 The y-coordinate of the 2nd control point on a cubic curve
 * @param x3 The x-coordinate of the end point on a cubic curve
 * @param y3 The y-coordinate of the end point on a cubic curve
 */

public void cubicTo(float x1, float y1, float x2, float y2, float x3, float y3) { throw new RuntimeException("Stub!"); }

/**
 * Same as cubicTo, but the coordinates are considered relative to the
 * current point on this contour. If there is no previous point, then a
 * moveTo(0,0) is inserted automatically.
 */

public void rCubicTo(float x1, float y1, float x2, float y2, float x3, float y3) { throw new RuntimeException("Stub!"); }

/**
 * Append the specified arc to the path as a new contour. If the start of
 * the path is different from the path's current last point, then an
 * automatic lineTo() is added to connect the current contour to the
 * start of the arc. However, if the path is empty, then we call moveTo()
 * with the first point of the arc.
 *
 * @param oval        The bounds of oval defining shape and size of the arc
 * @param startAngle  Starting angle (in degrees) where the arc begins
 * @param sweepAngle  Sweep angle (in degrees) measured clockwise, treated
 *                    mod 360.
 * @param forceMoveTo If true, always begin a new contour with the arc
 */

public void arcTo(android.graphics.RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo) { throw new RuntimeException("Stub!"); }

/**
 * Append the specified arc to the path as a new contour. If the start of
 * the path is different from the path's current last point, then an
 * automatic lineTo() is added to connect the current contour to the
 * start of the arc. However, if the path is empty, then we call moveTo()
 * with the first point of the arc.
 *
 * @param oval        The bounds of oval defining shape and size of the arc
 * @param startAngle  Starting angle (in degrees) where the arc begins
 * @param sweepAngle  Sweep angle (in degrees) measured clockwise
 */

public void arcTo(android.graphics.RectF oval, float startAngle, float sweepAngle) { throw new RuntimeException("Stub!"); }

/**
 * Append the specified arc to the path as a new contour. If the start of
 * the path is different from the path's current last point, then an
 * automatic lineTo() is added to connect the current contour to the
 * start of the arc. However, if the path is empty, then we call moveTo()
 * with the first point of the arc.
 *
 * @param startAngle  Starting angle (in degrees) where the arc begins
 * @param sweepAngle  Sweep angle (in degrees) measured clockwise, treated
 *                    mod 360.
 * @param forceMoveTo If true, always begin a new contour with the arc
 */

public void arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo) { throw new RuntimeException("Stub!"); }

/**
 * Close the current contour. If the current point is not equal to the
 * first point of the contour, a line segment is automatically added.
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Add a closed rectangle contour to the path
 *
 * @param rect The rectangle to add as a closed contour to the path
 * @param dir  The direction to wind the rectangle's contour
 */

public void addRect(android.graphics.RectF rect, android.graphics.Path.Direction dir) { throw new RuntimeException("Stub!"); }

/**
 * Add a closed rectangle contour to the path
 *
 * @param left   The left side of a rectangle to add to the path
 * @param top    The top of a rectangle to add to the path
 * @param right  The right side of a rectangle to add to the path
 * @param bottom The bottom of a rectangle to add to the path
 * @param dir    The direction to wind the rectangle's contour
 */

public void addRect(float left, float top, float right, float bottom, android.graphics.Path.Direction dir) { throw new RuntimeException("Stub!"); }

/**
 * Add a closed oval contour to the path
 *
 * @param oval The bounds of the oval to add as a closed contour to the path
 * @param dir  The direction to wind the oval's contour
 */

public void addOval(android.graphics.RectF oval, android.graphics.Path.Direction dir) { throw new RuntimeException("Stub!"); }

/**
 * Add a closed oval contour to the path
 *
 * @param dir The direction to wind the oval's contour
 */

public void addOval(float left, float top, float right, float bottom, android.graphics.Path.Direction dir) { throw new RuntimeException("Stub!"); }

/**
 * Add a closed circle contour to the path
 *
 * @param x   The x-coordinate of the center of a circle to add to the path
 * @param y   The y-coordinate of the center of a circle to add to the path
 * @param radius The radius of a circle to add to the path
 * @param dir    The direction to wind the circle's contour
 */

public void addCircle(float x, float y, float radius, android.graphics.Path.Direction dir) { throw new RuntimeException("Stub!"); }

/**
 * Add the specified arc to the path as a new contour.
 *
 * @param oval The bounds of oval defining the shape and size of the arc
 * @param startAngle Starting angle (in degrees) where the arc begins
 * @param sweepAngle Sweep angle (in degrees) measured clockwise
 */

public void addArc(android.graphics.RectF oval, float startAngle, float sweepAngle) { throw new RuntimeException("Stub!"); }

/**
 * Add the specified arc to the path as a new contour.
 *
 * @param startAngle Starting angle (in degrees) where the arc begins
 * @param sweepAngle Sweep angle (in degrees) measured clockwise
 */

public void addArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle) { throw new RuntimeException("Stub!"); }

/**
   * Add a closed round-rectangle contour to the path
 *
 * @param rect The bounds of a round-rectangle to add to the path
 * @param rx   The x-radius of the rounded corners on the round-rectangle
 * @param ry   The y-radius of the rounded corners on the round-rectangle
 * @param dir  The direction to wind the round-rectangle's contour
 */

public void addRoundRect(android.graphics.RectF rect, float rx, float ry, android.graphics.Path.Direction dir) { throw new RuntimeException("Stub!"); }

/**
 * Add a closed round-rectangle contour to the path
 *
 * @param rx   The x-radius of the rounded corners on the round-rectangle
 * @param ry   The y-radius of the rounded corners on the round-rectangle
 * @param dir  The direction to wind the round-rectangle's contour
 */

public void addRoundRect(float left, float top, float right, float bottom, float rx, float ry, android.graphics.Path.Direction dir) { throw new RuntimeException("Stub!"); }

/**
 * Add a closed round-rectangle contour to the path. Each corner receives
 * two radius values [X, Y]. The corners are ordered top-left, top-right,
 * bottom-right, bottom-left
 *
 * @param rect The bounds of a round-rectangle to add to the path
 * @param radii Array of 8 values, 4 pairs of [X,Y] radii
 * @param dir  The direction to wind the round-rectangle's contour
 */

public void addRoundRect(android.graphics.RectF rect, float[] radii, android.graphics.Path.Direction dir) { throw new RuntimeException("Stub!"); }

/**
 * Add a closed round-rectangle contour to the path. Each corner receives
 * two radius values [X, Y]. The corners are ordered top-left, top-right,
 * bottom-right, bottom-left
 *
 * @param radii Array of 8 values, 4 pairs of [X,Y] radii
 * @param dir  The direction to wind the round-rectangle's contour
 */

public void addRoundRect(float left, float top, float right, float bottom, float[] radii, android.graphics.Path.Direction dir) { throw new RuntimeException("Stub!"); }

/**
 * Add a copy of src to the path, offset by (dx,dy)
 *
 * @param src The path to add as a new contour
 * @param dx  The amount to translate the path in X as it is added
 */

public void addPath(android.graphics.Path src, float dx, float dy) { throw new RuntimeException("Stub!"); }

/**
 * Add a copy of src to the path
 *
 * @param src The path that is appended to the current path
 */

public void addPath(android.graphics.Path src) { throw new RuntimeException("Stub!"); }

/**
 * Add a copy of src to the path, transformed by matrix
 *
 * @param src The path to add as a new contour
 */

public void addPath(android.graphics.Path src, android.graphics.Matrix matrix) { throw new RuntimeException("Stub!"); }

/**
 * Offset the path by (dx,dy)
 *
 * @param dx  The amount in the X direction to offset the entire path
 * @param dy  The amount in the Y direction to offset the entire path
 * @param dst The translated path is written here. If this is null, then
 *            the original path is modified.

 * This value may be {@code null}.
 */

public void offset(float dx, float dy, @androidx.annotation.RecentlyNullable android.graphics.Path dst) { throw new RuntimeException("Stub!"); }

/**
 * Offset the path by (dx,dy)
 *
 * @param dx The amount in the X direction to offset the entire path
 * @param dy The amount in the Y direction to offset the entire path
 */

public void offset(float dx, float dy) { throw new RuntimeException("Stub!"); }

/**
 * Sets the last point of the path.
 *
 * @param dx The new X coordinate for the last point
 * @param dy The new Y coordinate for the last point
 */

public void setLastPoint(float dx, float dy) { throw new RuntimeException("Stub!"); }

/**
 * Transform the points in this path by matrix, and write the answer
 * into dst. If dst is null, then the the original path is modified.
 *
 * @param matrix The matrix to apply to the path
 * @param dst    The transformed path is written here. If dst is null,
 *               then the the original path is modified
 */

public void transform(android.graphics.Matrix matrix, android.graphics.Path dst) { throw new RuntimeException("Stub!"); }

/**
 * Transform the points in this path by matrix.
 *
 * @param matrix The matrix to apply to the path
 */

public void transform(android.graphics.Matrix matrix) { throw new RuntimeException("Stub!"); }

/**
 * Approximate the <code>Path</code> with a series of line segments.
 * This returns float[] with the array containing point components.
 * There are three components for each point, in order:
 * <ul>
 *     <li>Fraction along the length of the path that the point resides</li>
 *     <li>The x coordinate of the point</li>
 *     <li>The y coordinate of the point</li>
 * </ul>
 * <p>Two points may share the same fraction along its length when there is
 * a move action within the Path.</p>
 *
 * @param acceptableError The acceptable error for a line on the
 *                        Path. Typically this would be 0.5 so that
 *                        the error is less than half a pixel.
 * Value is 0 or greater
 * @return An array of components for points approximating the Path.
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public float[] approximate(float acceptableError) { throw new RuntimeException("Stub!"); }
/**
 * Specifies how closed shapes (e.g.&nbsp;rects, ovals) are oriented when they
 * are added to a path.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Direction {
CW, CCW;
}

/**
 * Enum for the ways a path may be filled.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum FillType {
WINDING, EVEN_ODD, INVERSE_WINDING, INVERSE_EVEN_ODD;
}

/**
 * The logical operations that can be performed when combining two paths.
 *
 * @see #op(Path, android.graphics.Path.Op)
 * @see #op(Path, Path, android.graphics.Path.Op)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Op {
DIFFERENCE, INTERSECT, UNION, XOR, REVERSE_DIFFERENCE;
}

}

