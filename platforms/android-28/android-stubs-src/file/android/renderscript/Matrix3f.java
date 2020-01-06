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
 * Class for exposing the native RenderScript rs_matrix3x3 type back to the Android system.
 *
 **/

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Matrix3f {

/**
 * Creates a new identity 3x3 matrix
 */

public Matrix3f() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new matrix and sets its values from the given
 * parameter
 *
 * @param dataArray values to set the matrix to, must be 9
 *                  floats long
 */

public Matrix3f(float[] dataArray) { throw new RuntimeException("Stub!"); }

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

public void load(android.renderscript.Matrix3f src) { throw new RuntimeException("Stub!"); }

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
 * Makes the upper 2x2 a rotation matrix of the given angle
 *
 * @param rot rotation angle
 */

public void loadRotate(float rot) { throw new RuntimeException("Stub!"); }

/**
 * Makes the upper 2x2 a scale matrix of given dimensions
 *
 * @param x scale component x
 * @param y scale component y
 */

public void loadScale(float x, float y) { throw new RuntimeException("Stub!"); }

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
 */

public void loadTranslate(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Sets current values to be the result of multiplying two given
 * matrices
 *
 * @param lhs left hand side matrix
 * @param rhs right hand side matrix
 */

public void loadMultiply(android.renderscript.Matrix3f lhs, android.renderscript.Matrix3f rhs) { throw new RuntimeException("Stub!"); }

/**
 * Post-multiplies the current matrix by a given parameter
 *
 * @param rhs right hand side to multiply by
 */

public void multiply(android.renderscript.Matrix3f rhs) { throw new RuntimeException("Stub!"); }

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
 * Modifies the upper 2x2 of the current matrix by
 * post-multiplying it with a rotation matrix of given angle
 *
 * @param rot angle of rotation
 */

public void rotate(float rot) { throw new RuntimeException("Stub!"); }

/**
 * Modifies the upper 2x2 of the current matrix by
 * post-multiplying it with a scale matrix of given dimensions
 *
 * @param x scale component x
 * @param y scale component y
 */

public void scale(float x, float y) { throw new RuntimeException("Stub!"); }

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
 */

public void translate(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * Sets the current matrix to its transpose
 */

public void transpose() { throw new RuntimeException("Stub!"); }
}

