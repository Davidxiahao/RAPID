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


package android.util;


/**
 * Immutable class for describing width and height dimensions in some arbitrary
 * unit.
 * <p>
 * Width and height are finite values stored as a floating point representation.
 * </p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SizeF {

/**
 * Create a new immutable SizeF instance.
 *
 * <p>Both the {@code width} and the {@code height} must be a finite number.
 * In particular, {@code NaN} and positive/negative infinity are illegal values.</p>
 *
 * @param width The width of the size
 * @param height The height of the size
 *
 * @throws IllegalArgumentException
 *             if either {@code width} or {@code height} was not finite.
 */

public SizeF(float width, float height) { throw new RuntimeException("Stub!"); }

/**
 * Get the width of the size (as an arbitrary unit).
 * @return width
 */

public float getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Get the height of the size (as an arbitrary unit).
 * @return height
 */

public float getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Check if this size is equal to another size.
 *
 * <p>Two sizes are equal if and only if both their widths and heights are the same.</p>
 *
 * <p>For this purpose, the width/height float values are considered to be the same if and only
 * if the method {@link Float#floatToIntBits(float)} returns the identical {@code int} value
 * when applied to each.</p>
 *
 * @return {@code true} if the objects were equal, {@code false} otherwise
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Return the size represented as a string with the format {@code "WxH"}
 *
 * @return string representation of the size
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Parses the specified string as a size value.
 * <p>
 * The ASCII characters {@code \}{@code u002a} ('*') and
 * {@code \}{@code u0078} ('x') are recognized as separators between
 * the width and height.</p>
 * <p>
 * For any {@code SizeF s}: {@code SizeF.parseSizeF(s.toString()).equals(s)}.
 * However, the method also handles sizes expressed in the
 * following forms:</p>
 * <p>
 * "<i>width</i>{@code x}<i>height</i>" or
 * "<i>width</i>{@code *}<i>height</i>" {@code => new SizeF(width, height)},
 * where <i>width</i> and <i>height</i> are string floats potentially
 * containing a sign, such as "-10.3", "+7" or "5.2", but not containing
 * an {@code 'x'} (such as a float in hexadecimal string format).</p>
 *
 * <pre>{@code
 * SizeF.parseSizeF("3.2*+6").equals(new SizeF(3.2f, 6.0f)) == true
 * SizeF.parseSizeF("-3x-6").equals(new SizeF(-3.0f, -6.0f)) == true
 * SizeF.parseSizeF("4 by 3") => throws NumberFormatException
 * }</pre>
 *
 * @param string the string representation of a size value.
 * @return the size value represented by {@code string}.
 *
 * @throws NumberFormatException if {@code string} cannot be parsed
 * as a size value.
 * @throws NullPointerException if {@code string} was {@code null}
 */

public static android.util.SizeF parseSizeF(java.lang.String string) throws java.lang.NumberFormatException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

