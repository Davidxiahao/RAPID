/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.hardware.camera2.params;

import android.hardware.camera2.CaptureResult;

/**
 * Immutable class for describing a {@code 4 x N x M} lens shading map of floats.
 *
 * @see CaptureResult#STATISTICS_LENS_SHADING_CORRECTION_MAP
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class LensShadingMap {

/**
 * Create a new immutable LensShadingMap instance.
 *
 * <p>The elements must be stored in a row-major order (fully packed).</p>
 *
 * <p>This constructor takes over the array; do not write to the array afterwards.</p>
 *
 * @param elements
 *          An array of elements whose length is
 *          {@code RggbChannelVector.COUNT * rows * columns}
 *
 * @throws IllegalArgumentException
 *            if the {@code elements} array length is invalid,
 *            if any of the subelems are not finite or less than {@value #MINIMUM_GAIN_FACTOR},
 *            or if rows or columns is not positive
 * @throws NullPointerException
 *            if {@code elements} is {@code null}
 *
 * @hide
 */

LensShadingMap(float[] elements, int rows, int columns) { throw new RuntimeException("Stub!"); }

/**
 * Get the number of rows in this map.
 */

public int getRowCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the number of columns in this map.
 */

public int getColumnCount() { throw new RuntimeException("Stub!"); }

/**
 * Get the total number of gain factors in this map.
 *
 * <p>A single gain factor contains exactly one color channel.
 * Use with {@link #copyGainFactors} to allocate a large-enough array.</p>
 */

public int getGainFactorCount() { throw new RuntimeException("Stub!"); }

/**
 * Get a single color channel gain factor from this lens shading map by its row and column.
 *
 * <p>The rows must be within the range [0, {@link #getRowCount}),
 * the column must be within the range [0, {@link #getColumnCount}),
 * and the color channel must be within the range [0, {@value RggbChannelVector#COUNT}).</p>
 *
 * <p>The channel order is {@code [R, Geven, Godd, B]}, where
 * {@code Geven} is the green channel for the even rows of a Bayer pattern, and
 * {@code Godd} is the odd rows.
 * </p>
 *
 * @param colorChannel color channel from {@code [R, Geven, Godd, B]}
 * @param column within the range [0, {@link #getColumnCount})
 * @param row within the range [0, {@link #getRowCount})
 *
 * @return a gain factor >= {@value #MINIMUM_GAIN_FACTOR}
 *
 * @throws IllegalArgumentException if any of the parameters was out of range
 *
 * @see #RED
 * @see #GREEN_EVEN
 * @see #GREEN_ODD
 * @see #BLUE
 * @see #getRowCount
 * @see #getColumnCount
 */

public float getGainFactor(int colorChannel, int column, int row) { throw new RuntimeException("Stub!"); }

/**
 * Get a gain factor vector from this lens shading map by its row and column.
 *
 * <p>The rows must be within the range [0, {@link #getRowCount}),
 * the column must be within the range [0, {@link #getColumnCount}).</p>
 *
 * @param column within the range [0, {@link #getColumnCount})
 * @param row within the range [0, {@link #getRowCount})
 *
 * @return an {@link RggbChannelVector} where each gain factor >= {@value #MINIMUM_GAIN_FACTOR}
 *
 * @throws IllegalArgumentException if any of the parameters was out of range
 *
 * @see #getRowCount
 * @see #getColumnCount
 */

public android.hardware.camera2.params.RggbChannelVector getGainFactorVector(int column, int row) { throw new RuntimeException("Stub!"); }

/**
 * Copy all gain factors in row-major order from this lens shading map into the destination.
 *
 * <p>Each gain factor will be >= {@link #MINIMUM_GAIN_FACTOR}.</p>
 *
 * @param destination
 *          an array big enough to hold at least {@link RggbChannelVector#COUNT}
 *          elements after the {@code offset}
 * @param offset
 *          a non-negative offset into the array
 * @throws NullPointerException
 *          If {@code destination} was {@code null}
 * @throws IllegalArgumentException
 *          If offset was negative
 * @throws ArrayIndexOutOfBoundsException
 *          If there's not enough room to write the elements at the specified destination and
 *          offset.
 *
 * @see CaptureResult#STATISTICS_LENS_SHADING_MAP
 */

public void copyGainFactors(float[] destination, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Check if this LensShadingMap is equal to another LensShadingMap.
 *
 * <p>Two lens shading maps are equal if and only if they have the same rows/columns,
 * and all of their elements are {@link Object#equals equal}.</p>
 *
 * @return {@code true} if the objects were equal, {@code false} otherwise
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Return the LensShadingMap as a string representation.
 *
 * <p> {@code "LensShadingMap{R:([%f, %f, ... %f], ... [%f, %f, ... %f]), G_even:([%f, %f, ...
 *  %f], ... [%f, %f, ... %f]), G_odd:([%f, %f, ... %f], ... [%f, %f, ... %f]), B:([%f, %f, ...
 *  %f], ... [%f, %f, ... %f])}"},
 * where each {@code %f} represents one gain factor and each {@code [%f, %f, ... %f]} represents
 * a row of the lens shading map</p>
 *
 * @return string representation of {@link LensShadingMap}
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The smallest gain factor in this map.
 *
 * <p>All values in this map will be at least this large.</p>
 */

public static final float MINIMUM_GAIN_FACTOR = 1.0f;
}

