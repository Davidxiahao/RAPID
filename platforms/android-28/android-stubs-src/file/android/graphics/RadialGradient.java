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
public class RadialGradient extends android.graphics.Shader {

/**
 * Create a shader that draws a radial gradient given the center and radius.
 *
 * @param centerX  The x-coordinate of the center of the radius
 * @param centerY  The y-coordinate of the center of the radius
 * @param radius   Must be positive. The radius of the circle for this gradient.
 * @param colors   The colors to be distributed between the center and edge of the circle
 * This value must never be {@code null}.
 * @param stops    May be <code>null</code>. Valid values are between <code>0.0f</code> and
 *                 <code>1.0f</code>. The relative position of each corresponding color in
 *                 the colors array. If <code>null</code>, colors are distributed evenly
 *                 between the center and edge of the circle.
 * This value may be {@code null}.
 * @param tileMode The Shader tiling mode

 * This value must never be {@code null}.
 */

public RadialGradient(float centerX, float centerY, float radius, @androidx.annotation.RecentlyNonNull int[] colors, @androidx.annotation.RecentlyNullable float[] stops, @androidx.annotation.RecentlyNonNull android.graphics.Shader.TileMode tileMode) { throw new RuntimeException("Stub!"); }

/**
 * Create a shader that draws a radial gradient given the center and radius.
 *
 * @param centerX     The x-coordinate of the center of the radius
 * @param centerY     The y-coordinate of the center of the radius
 * @param radius      Must be positive. The radius of the circle for this gradient
 * @param centerColor The color at the center of the circle.
 * @param edgeColor   The color at the edge of the circle.
 * @param tileMode    The Shader tiling mode

 * This value must never be {@code null}.
 */

public RadialGradient(float centerX, float centerY, float radius, int centerColor, int edgeColor, @androidx.annotation.RecentlyNonNull android.graphics.Shader.TileMode tileMode) { throw new RuntimeException("Stub!"); }
}

