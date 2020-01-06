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
 * The Matrix class holds a 3x3 matrix for transforming coordinates.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Matrix {

/**
 * Create an identity matrix
 */

public Matrix() { throw new RuntimeException("Stub!"); }

/**
 * Create a matrix that is a (deep) copy of src
 *
 * @param src The matrix to copy into this matrix
 */

public Matrix(android.graphics.Matrix src) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the matrix is identity. This maybe faster than testing if (getType() == 0)
 */

public boolean isIdentity() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this matrix is affine. An affine matrix preserves straight lines and has no
 * perspective.
 *
 * @return Whether the matrix is affine.
 */

public boolean isAffine() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if will map a rectangle to another rectangle. This can be true if the matrix is
 * identity, scale-only, or rotates a multiple of 90 degrees.
 */

public boolean rectStaysRect() { throw new RuntimeException("Stub!"); }

/**
 * (deep) copy the src matrix into this matrix. If src is null, reset this matrix to the
 * identity matrix.
 */

public void set(android.graphics.Matrix src) { throw new RuntimeException("Stub!"); }

/**
 * Returns true iff obj is a Matrix and its values equal our values.
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

/** Set the matrix to identity */

public void reset() { throw new RuntimeException("Stub!"); }

/** Set the matrix to translate by (dx, dy). */

public void setTranslate(float dx, float dy) { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix to scale by sx and sy, with a pivot point at (px, py). The pivot point is the
 * coordinate that should remain unchanged by the specified transformation.
 */

public void setScale(float sx, float sy, float px, float py) { throw new RuntimeException("Stub!"); }

/** Set the matrix to scale by sx and sy. */

public void setScale(float sx, float sy) { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix to rotate by the specified number of degrees, with a pivot point at (px, py).
 * The pivot point is the coordinate that should remain unchanged by the specified
 * transformation.
 */

public void setRotate(float degrees, float px, float py) { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix to rotate about (0,0) by the specified number of degrees.
 */

public void setRotate(float degrees) { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix to rotate by the specified sine and cosine values, with a pivot point at (px,
 * py). The pivot point is the coordinate that should remain unchanged by the specified
 * transformation.
 */

public void setSinCos(float sinValue, float cosValue, float px, float py) { throw new RuntimeException("Stub!"); }

/** Set the matrix to rotate by the specified sine and cosine values. */

public void setSinCos(float sinValue, float cosValue) { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix to skew by sx and sy, with a pivot point at (px, py). The pivot point is the
 * coordinate that should remain unchanged by the specified transformation.
 */

public void setSkew(float kx, float ky, float px, float py) { throw new RuntimeException("Stub!"); }

/** Set the matrix to skew by sx and sy. */

public void setSkew(float kx, float ky) { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix to the concatenation of the two specified matrices and return true.
 * <p>
 * Either of the two matrices may also be the target matrix, that is
 * <code>matrixA.setConcat(matrixA, matrixB);</code> is valid.
 * </p>
 * <p class="note">
 * In {@link android.os.Build.VERSION_CODES#GINGERBREAD_MR1} and below, this function returns
 * true only if the result can be represented. In
 * {@link android.os.Build.VERSION_CODES#HONEYCOMB} and above, it always returns true.
 * </p>
 */

public boolean setConcat(android.graphics.Matrix a, android.graphics.Matrix b) { throw new RuntimeException("Stub!"); }

/**
 * Preconcats the matrix with the specified translation. M' = M * T(dx, dy)
 */

public boolean preTranslate(float dx, float dy) { throw new RuntimeException("Stub!"); }

/**
 * Preconcats the matrix with the specified scale. M' = M * S(sx, sy, px, py)
 */

public boolean preScale(float sx, float sy, float px, float py) { throw new RuntimeException("Stub!"); }

/**
 * Preconcats the matrix with the specified scale. M' = M * S(sx, sy)
 */

public boolean preScale(float sx, float sy) { throw new RuntimeException("Stub!"); }

/**
 * Preconcats the matrix with the specified rotation. M' = M * R(degrees, px, py)
 */

public boolean preRotate(float degrees, float px, float py) { throw new RuntimeException("Stub!"); }

/**
 * Preconcats the matrix with the specified rotation. M' = M * R(degrees)
 */

public boolean preRotate(float degrees) { throw new RuntimeException("Stub!"); }

/**
 * Preconcats the matrix with the specified skew. M' = M * K(kx, ky, px, py)
 */

public boolean preSkew(float kx, float ky, float px, float py) { throw new RuntimeException("Stub!"); }

/**
 * Preconcats the matrix with the specified skew. M' = M * K(kx, ky)
 */

public boolean preSkew(float kx, float ky) { throw new RuntimeException("Stub!"); }

/**
 * Preconcats the matrix with the specified matrix. M' = M * other
 */

public boolean preConcat(android.graphics.Matrix other) { throw new RuntimeException("Stub!"); }

/**
 * Postconcats the matrix with the specified translation. M' = T(dx, dy) * M
 */

public boolean postTranslate(float dx, float dy) { throw new RuntimeException("Stub!"); }

/**
 * Postconcats the matrix with the specified scale. M' = S(sx, sy, px, py) * M
 */

public boolean postScale(float sx, float sy, float px, float py) { throw new RuntimeException("Stub!"); }

/**
 * Postconcats the matrix with the specified scale. M' = S(sx, sy) * M
 */

public boolean postScale(float sx, float sy) { throw new RuntimeException("Stub!"); }

/**
 * Postconcats the matrix with the specified rotation. M' = R(degrees, px, py) * M
 */

public boolean postRotate(float degrees, float px, float py) { throw new RuntimeException("Stub!"); }

/**
 * Postconcats the matrix with the specified rotation. M' = R(degrees) * M
 */

public boolean postRotate(float degrees) { throw new RuntimeException("Stub!"); }

/**
 * Postconcats the matrix with the specified skew. M' = K(kx, ky, px, py) * M
 */

public boolean postSkew(float kx, float ky, float px, float py) { throw new RuntimeException("Stub!"); }

/**
 * Postconcats the matrix with the specified skew. M' = K(kx, ky) * M
 */

public boolean postSkew(float kx, float ky) { throw new RuntimeException("Stub!"); }

/**
 * Postconcats the matrix with the specified matrix. M' = other * M
 */

public boolean postConcat(android.graphics.Matrix other) { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix to the scale and translate values that map the source rectangle to the
 * destination rectangle, returning true if the the result can be represented.
 *
 * @param src the source rectangle to map from.
 * @param dst the destination rectangle to map to.
 * @param stf the ScaleToFit option
 * @return true if the matrix can be represented by the rectangle mapping.
 */

public boolean setRectToRect(android.graphics.RectF src, android.graphics.RectF dst, android.graphics.Matrix.ScaleToFit stf) { throw new RuntimeException("Stub!"); }

/**
 * Set the matrix such that the specified src points would map to the specified dst points. The
 * "points" are represented as an array of floats, order [x0, y0, x1, y1, ...], where each
 * "point" is 2 float values.
 *
 * @param src The array of src [x,y] pairs (points)
 * @param srcIndex Index of the first pair of src values
 * @param dst The array of dst [x,y] pairs (points)
 * @param dstIndex Index of the first pair of dst values
 * @param pointCount The number of pairs/points to be used. Must be [0..4]
 * @return true if the matrix was set to the specified transformation
 */

public boolean setPolyToPoly(float[] src, int srcIndex, float[] dst, int dstIndex, int pointCount) { throw new RuntimeException("Stub!"); }

/**
 * If this matrix can be inverted, return true and if inverse is not null, set inverse to be the
 * inverse of this matrix. If this matrix cannot be inverted, ignore inverse and return false.
 */

public boolean invert(android.graphics.Matrix inverse) { throw new RuntimeException("Stub!"); }

/**
 * Apply this matrix to the array of 2D points specified by src, and write the transformed
 * points into the array of points specified by dst. The two arrays represent their "points" as
 * pairs of floats [x, y].
 *
 * @param dst The array of dst points (x,y pairs)
 * @param dstIndex The index of the first [x,y] pair of dst floats
 * @param src The array of src points (x,y pairs)
 * @param srcIndex The index of the first [x,y] pair of src floats
 * @param pointCount The number of points (x,y pairs) to transform
 */

public void mapPoints(float[] dst, int dstIndex, float[] src, int srcIndex, int pointCount) { throw new RuntimeException("Stub!"); }

/**
 * Apply this matrix to the array of 2D vectors specified by src, and write the transformed
 * vectors into the array of vectors specified by dst. The two arrays represent their "vectors"
 * as pairs of floats [x, y]. Note: this method does not apply the translation associated with
 * the matrix. Use {@link Matrix#mapPoints(float[], int, float[], int, int)} if you want the
 * translation to be applied.
 *
 * @param dst The array of dst vectors (x,y pairs)
 * @param dstIndex The index of the first [x,y] pair of dst floats
 * @param src The array of src vectors (x,y pairs)
 * @param srcIndex The index of the first [x,y] pair of src floats
 * @param vectorCount The number of vectors (x,y pairs) to transform
 */

public void mapVectors(float[] dst, int dstIndex, float[] src, int srcIndex, int vectorCount) { throw new RuntimeException("Stub!"); }

/**
 * Apply this matrix to the array of 2D points specified by src, and write the transformed
 * points into the array of points specified by dst. The two arrays represent their "points" as
 * pairs of floats [x, y].
 *
 * @param dst The array of dst points (x,y pairs)
 * @param src The array of src points (x,y pairs)
 */

public void mapPoints(float[] dst, float[] src) { throw new RuntimeException("Stub!"); }

/**
 * Apply this matrix to the array of 2D vectors specified by src, and write the transformed
 * vectors into the array of vectors specified by dst. The two arrays represent their "vectors"
 * as pairs of floats [x, y]. Note: this method does not apply the translation associated with
 * the matrix. Use {@link Matrix#mapPoints(float[], float[])} if you want the translation to be
 * applied.
 *
 * @param dst The array of dst vectors (x,y pairs)
 * @param src The array of src vectors (x,y pairs)
 */

public void mapVectors(float[] dst, float[] src) { throw new RuntimeException("Stub!"); }

/**
 * Apply this matrix to the array of 2D points, and write the transformed points back into the
 * array
 *
 * @param pts The array [x0, y0, x1, y1, ...] of points to transform.
 */

public void mapPoints(float[] pts) { throw new RuntimeException("Stub!"); }

/**
 * Apply this matrix to the array of 2D vectors, and write the transformed vectors back into the
 * array. Note: this method does not apply the translation associated with the matrix. Use
 * {@link Matrix#mapPoints(float[])} if you want the translation to be applied.
 *
 * @param vecs The array [x0, y0, x1, y1, ...] of vectors to transform.
 */

public void mapVectors(float[] vecs) { throw new RuntimeException("Stub!"); }

/**
 * Apply this matrix to the src rectangle, and write the transformed rectangle into dst. This is
 * accomplished by transforming the 4 corners of src, and then setting dst to the bounds of
 * those points.
 *
 * @param dst Where the transformed rectangle is written.
 * @param src The original rectangle to be transformed.
 * @return the result of calling rectStaysRect()
 */

public boolean mapRect(android.graphics.RectF dst, android.graphics.RectF src) { throw new RuntimeException("Stub!"); }

/**
 * Apply this matrix to the rectangle, and write the transformed rectangle back into it. This is
 * accomplished by transforming the 4 corners of rect, and then setting it to the bounds of
 * those points
 *
 * @param rect The rectangle to transform.
 * @return the result of calling rectStaysRect()
 */

public boolean mapRect(android.graphics.RectF rect) { throw new RuntimeException("Stub!"); }

/**
 * Return the mean radius of a circle after it has been mapped by this matrix. NOTE: in
 * perspective this value assumes the circle has its center at the origin.
 */

public float mapRadius(float radius) { throw new RuntimeException("Stub!"); }

/**
 * Copy 9 values from the matrix into the array.
 */

public void getValues(float[] values) { throw new RuntimeException("Stub!"); }

/**
 * Copy 9 values from the array into the matrix. Depending on the implementation of Matrix,
 * these may be transformed into 16.16 integers in the Matrix, such that a subsequent call to
 * getValues() will not yield exactly the same values.
 */

public void setValues(float[] values) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public java.lang.String toShortString() { throw new RuntimeException("Stub!"); }

public static final int MPERSP_0 = 6; // 0x6

public static final int MPERSP_1 = 7; // 0x7

public static final int MPERSP_2 = 8; // 0x8

public static final int MSCALE_X = 0; // 0x0

public static final int MSCALE_Y = 4; // 0x4

public static final int MSKEW_X = 1; // 0x1

public static final int MSKEW_Y = 3; // 0x3

public static final int MTRANS_X = 2; // 0x2

public static final int MTRANS_Y = 5; // 0x5
/**
 * Controlls how the src rect should align into the dst rect for setRectToRect().
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum ScaleToFit {
FILL, START, CENTER, END;
}

}

