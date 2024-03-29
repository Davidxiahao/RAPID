/*
 * Copyright (C) 2007 The Android Open Source Project
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


@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LinearGradient extends android.graphics.Shader {

/**
 * Create a shader that draws a linear gradient along a line.
 *
 * @param x0           The x-coordinate for the start of the gradient line
 * @param y0           The y-coordinate for the start of the gradient line
 * @param x1           The x-coordinate for the end of the gradient line
 * @param y1           The y-coordinate for the end of the gradient line
 * @param colors       The colors to be distributed along the gradient line
 * This value must never be {@code null}.
 * @param positions    May be null. The relative positions [0..1] of
 *                     each corresponding color in the colors array. If this is null,
 *                     the the colors are distributed evenly along the gradient line.
 * This value may be {@code null}.
 * @param tile         The Shader tiling mode

 * This value must never be {@code null}.
 */

public LinearGradient(float x0, float y0, float x1, float y1, @androidx.annotation.RecentlyNonNull int[] colors, @androidx.annotation.RecentlyNullable float[] positions, @androidx.annotation.RecentlyNonNull android.graphics.Shader.TileMode tile) { throw new RuntimeException("Stub!"); }

/**
 * Create a shader that draws a linear gradient along a line.
 *
 * @param x0       The x-coordinate for the start of the gradient line
 * @param y0       The y-coordinate for the start of the gradient line
 * @param x1       The x-coordinate for the end of the gradient line
 * @param y1       The y-coordinate for the end of the gradient line
 * @param color0   The color at the start of the gradient line.
 * @param color1   The color at the end of the gradient line.
 * @param tile     The Shader tiling mode

 * This value must never be {@code null}.
 */

public LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, @androidx.annotation.RecentlyNonNull android.graphics.Shader.TileMode tile) { throw new RuntimeException("Stub!"); }
}

