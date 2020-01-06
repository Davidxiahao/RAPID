/*
 * Copyright (C) 2009-2012 The Android Open Source Project
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


package android.renderscript;


/**
 * Class for exposing the native RenderScript rs_matrix4x4 type back to the Android system.
 *
 **/

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Matrix4f {

/**
 * Creates a new identity 4x4 matrix
 */

public Matrix4f() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new matrix and sets its values from the given
 * parameter
 *
 * @param dataArray values to set the matrix to, must be 16
 *                  floats long
 */

public Matrix4f(float[] dataArray) { throw new RuntimeException("Stub!"); }

/**
 * Return a reference to the internal array representing matrix
 * values. Modifying this array will also change the matrix
 *
 * @return internal array representing the matrix
 */

public float[] getArray() { throw new RuntimeException("Stub!"); }

/**
 * Returns the value for a given row and column
 *
 * @param x column of the value to return
 * @param y row of the value to return
 *
 * @return value in the yth row and xth column
 */

public float get(int x, int y) { throw new RuntimeException("Stub!"); }

/**
 * Sets the value for a given row and column
 *
 * @param x column of the value to set
 * @param y row of the value to set
 */

public void set(int x, int y, float v) { throw new RuntimeException("Stub!"); }

/**
 * Sets the matrix values to identity
 */

public void loadIdentity() { throw new RuntimeException("Stub!"); }

/**
 * Sets the values of the matrix to those of the parameter
 *
 * @param src matrix to load the values from
 */

public void load(android.renderscript.Matrix4f src) { throw new RuntimeException("Stub!"); }

/**
 * Sets current values to be a rotation matrix of certain angle
 * about a given axis
 *
 * @param rot angle of rotation
 * @param x rotation axis x
 * @param y rotation axis y
 * @param z rotation axis z
 */

public void loadRotate(float rot, float x, float y, float z) { throw new RuntimeException("Stub!"); }

/**
 * Sets current values to be a scale matrix of given dimensions
 *
 * @param x scale component x
 * @param y scale component y
 * @param z scale component z
 */

public void loadScale(float x, float y, float z) { throw new RuntimeException("Stub!"); }

/**
 * Sets current values to be a translation matrix of given
 * dimensions
 *
 * @param x translation component x
 * @param y translation component y
 * @param z translation component z
 */

public void loadTranslate(float x, float y, float z) { throw new RuntimeException("Stub!"); }

/**
 * Sets current values to be the result of multiplying two given
 * matrices
 *
 * @param lhs left hand side matrix
 * @param rhs right hand side matrix
 */

public void loadMultiply(android.renderscript.Matrix4f lhs, android.renderscript.Matrix4f rhs) { throw new RuntimeException("Stub!"); }

/**
 * Set current values to be an orthographic projection matrix
 *
 * @param l location of the left vertical clipping plane
 * @param r location of the right vertical clipping plane
 * @param b location of the bottom horizontal clipping plane
 * @param t location of the top horizontal clipping plane
 * @param n location of the near clipping plane
 * @param f location of the far clipping plane
 */

public void loadOrtho(float l, float r, float b, float t, float n, float f) { throw new RuntimeException("Stub!"); }

/**
 * Set current values to be an orthographic projection matrix
 * with the right and bottom clipping planes set to the given
 * values. Left and top clipping planes are set to 0. Near and
 * far are set to -1, 1 respectively
 *
 * @param w location of the right vertical clipping plane
 * @param h location of the bottom horizontal clipping plane
 *
 */

public void loadOrthoWindow(int w, int h) { throw new RuntimeException("Stub!"); }

/**
 * Sets current values to be a perspective projection matrix
 *
 * @param l location of the left vertical clipping plane
 * @param r location of the right vertical clipping plane
 * @param b location of the bottom horizontal clipping plane
 * @param t location of the top horizontal clipping plane
 * @param n location of the near clipping plane, must be positive
 * @param f location of the far clipping plane, must be positive
 *
 */

public void loadFrustum(float l, float r, float b, float t, float n, float f) { throw new RuntimeException("Stub!"); }

/**
 * Sets current values to be a perspective projection matrix
 *
 * @param fovy vertical field of view angle in degrees
 * @param aspect aspect ratio of the screen
 * @param near near cliping plane, must be positive
 * @param far far clipping plane, must be positive
 */

public void loadPerspective(float fovy, float aspect, float near, float far) { throw new RuntimeException("Stub!"); }

/**
 * Helper function to set the current values to a perspective
 * projection matrix with aspect ratio defined by the parameters
 * and (near, far), (bottom, top) mapping to (-1, 1) at z = 0
 *
 * @param w screen width
 * @param h screen height
 */

public void loadProjectionNormalized(int w, int h) { throw new RuntimeException("Stub!"); }

/**
 * Post-multiplies the current matrix by a given parameter
 *
 * @param rhs right hand side to multiply by
 */

public void multiply(android.renderscript.Matrix4f rhs) { throw new RuntimeException("Stub!"); }

/**
 * Modifies the current matrix by post-multiplying it with a
 * rotation matrix of certain angle about a given axis
 *
 * @param rot angle of rotation
 * @param x rotation axis x
 * @param y rotation axis y
 * @param z rotation axis z
 */

public void rotate(float rot, float x, float y, float z) { throw new RuntimeException("Stub!"); }

/**
 * Modifies the current matrix by post-multiplying it with a
 * scale matrix of given dimensions
 *
 * @param x scale component x
 * @param y scale component y
 * @param z scale component z
 */

public void scale(float x, float y, float z) { throw new RuntimeException("Stub!"); }

/**
 * Modifies the current matrix by post-multiplying it with a
 * translation matrix of given dimensions
 *
 * @param x translation component x
 * @param y translation component y
 * @param z translation component z
 */

public void translate(float x, float y, float z) { throw new RuntimeException("Stub!"); }

/**
 * Sets the current matrix to its inverse
 */

public boolean inverse() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current matrix to its inverse transpose
 */

public boolean inverseTranspose() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current matrix to its transpose
 */

public void transpose() { throw new RuntimeException("Stub!"); }
}

