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
 * Shader is the based class for objects that return horizontal spans of colors
 * during drawing. A subclass of Shader is installed in a Paint calling
 * paint.setShader(shader). After that any object (other than a bitmap) that is
 * drawn with that paint will get its color(s) from the shader.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Shader {

/**
 * @deprecated Use subclass constructors directly instead.
 */

@Deprecated public Shader() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the shader has a non-identity local matrix.
 * @param localM Set to the local matrix of the shader, if the shader's matrix is non-null.
 * This value must never be {@code null}.
 * @return true if the shader has a non-identity local matrix
 */

public boolean getLocalMatrix(@androidx.annotation.RecentlyNonNull android.graphics.Matrix localM) { throw new RuntimeException("Stub!"); }

/**
 * Set the shader's local matrix. Passing null will reset the shader's
 * matrix to identity. If the matrix has scale value as 0, the drawing
 * result is undefined.
 *
 * @param localM The shader's new local matrix, or null to specify identity

 * This value may be {@code null}.
 */

public void setLocalMatrix(@androidx.annotation.RecentlyNullable android.graphics.Matrix localM) { throw new RuntimeException("Stub!"); }
@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum TileMode {
CLAMP, REPEAT, MIRROR;
}

}

