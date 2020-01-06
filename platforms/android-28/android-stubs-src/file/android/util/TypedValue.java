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


package android.util;


/**
 * Container for a dynamically typed data value.  Primarily used with
 * {@link android.content.res.Resources} for holding resource values.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TypedValue {

public TypedValue() { throw new RuntimeException("Stub!"); }

/** Return the data for this value as a float.  Only use for values
 *  whose type is {@link #TYPE_FLOAT}. */

public final float getFloat() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the base value from a complex data integer.  This uses the
 * {@link #COMPLEX_MANTISSA_MASK} and {@link #COMPLEX_RADIX_MASK} fields of
 * the data to compute a floating point representation of the number they
 * describe.  The units are ignored.
 *
 * @param complex A complex data value.
 *
 * @return A floating point value corresponding to the complex data.
 */

public static float complexToFloat(int complex) { throw new RuntimeException("Stub!"); }

/**
 * Converts a complex data value holding a dimension to its final floating
 * point value. The given <var>data</var> must be structured as a
 * {@link #TYPE_DIMENSION}.
 *
 * @param data A complex data value holding a unit, magnitude, and
 *             mantissa.
 * @param metrics Current display metrics to use in the conversion --
 *                supplies display density and scaling information.
 *
 * @return The complex floating point value multiplied by the appropriate
 * metrics depending on its unit.
 */

public static float complexToDimension(int data, android.util.DisplayMetrics metrics) { throw new RuntimeException("Stub!"); }

/**
 * Converts a complex data value holding a dimension to its final value
 * as an integer pixel offset.  This is the same as
 * {@link #complexToDimension}, except the raw floating point value is
 * truncated to an integer (pixel) value.
 * The given <var>data</var> must be structured as a
 * {@link #TYPE_DIMENSION}.
 *
 * @param data A complex data value holding a unit, magnitude, and
 *             mantissa.
 * @param metrics Current display metrics to use in the conversion --
 *                supplies display density and scaling information.
 *
 * @return The number of pixels specified by the data and its desired
 * multiplier and units.
 */

public static int complexToDimensionPixelOffset(int data, android.util.DisplayMetrics metrics) { throw new RuntimeException("Stub!"); }

/**
 * Converts a complex data value holding a dimension to its final value
 * as an integer pixel size.  This is the same as
 * {@link #complexToDimension}, except the raw floating point value is
 * converted to an integer (pixel) value for use as a size.  A size
 * conversion involves rounding the base value, and ensuring that a
 * non-zero base value is at least one pixel in size.
 * The given <var>data</var> must be structured as a
 * {@link #TYPE_DIMENSION}.
 *
 * @param data A complex data value holding a unit, magnitude, and
 *             mantissa.
 * @param metrics Current display metrics to use in the conversion --
 *                supplies display density and scaling information.
 *
 * @return The number of pixels specified by the data and its desired
 * multiplier and units.
 */

public static int complexToDimensionPixelSize(int data, android.util.DisplayMetrics metrics) { throw new RuntimeException("Stub!"); }

/**
 * Return the complex unit type for this value. For example, a dimen type
 * with value 12sp will return {@link #COMPLEX_UNIT_SP}. Only use for values
 * whose type is {@link #TYPE_DIMENSION}.
 *
 * @return The complex unit type.
 */

public int getComplexUnit() { throw new RuntimeException("Stub!"); }

/**
 * Converts an unpacked complex data value holding a dimension to its final floating
 * point value. The two parameters <var>unit</var> and <var>value</var>
 * are as in {@link #TYPE_DIMENSION}.
 *
 * @param unit The unit to convert from.
 * @param value The value to apply the unit to.
 * @param metrics Current display metrics to use in the conversion --
 *                supplies display density and scaling information.
 *
 * @return The complex floating point value multiplied by the appropriate
 * metrics depending on its unit.
 */

public static float applyDimension(int unit, float value, android.util.DisplayMetrics metrics) { throw new RuntimeException("Stub!"); }

/**
 * Return the data for this value as a dimension.  Only use for values
 * whose type is {@link #TYPE_DIMENSION}.
 *
 * @param metrics Current display metrics to use in the conversion --
 *                supplies display density and scaling information.
 *
 * @return The complex floating point value multiplied by the appropriate
 * metrics depending on its unit.
 */

public float getDimension(android.util.DisplayMetrics metrics) { throw new RuntimeException("Stub!"); }

/**
 * Converts a complex data value holding a fraction to its final floating
 * point value. The given <var>data</var> must be structured as a
 * {@link #TYPE_FRACTION}.
 *
 * @param data A complex data value holding a unit, magnitude, and
 *             mantissa.
 * @param base The base value of this fraction.  In other words, a
 *             standard fraction is multiplied by this value.
 * @param pbase The parent base value of this fraction.  In other
 *             words, a parent fraction (nn%p) is multiplied by this
 *             value.
 *
 * @return The complex floating point value multiplied by the appropriate
 * base value depending on its unit.
 */

public static float complexToFraction(int data, float base, float pbase) { throw new RuntimeException("Stub!"); }

/**
 * Return the data for this value as a fraction.  Only use for values whose
 * type is {@link #TYPE_FRACTION}.
 *
 * @param base The base value of this fraction.  In other words, a
 *             standard fraction is multiplied by this value.
 * @param pbase The parent base value of this fraction.  In other
 *             words, a parent fraction (nn%p) is multiplied by this
 *             value.
 *
 * @return The complex floating point value multiplied by the appropriate
 * base value depending on its unit.
 */

public float getFraction(float base, float pbase) { throw new RuntimeException("Stub!"); }

/**
 * Regardless of the actual type of the value, try to convert it to a
 * string value.  For example, a color type will be converted to a
 * string of the form #aarrggbb.
 *
 * @return CharSequence The coerced string value.  If the value is
 *         null or the type is not known, null is returned.
 */

public final java.lang.CharSequence coerceToString() { throw new RuntimeException("Stub!"); }

/**
 * Perform type conversion as per {@link #coerceToString()} on an
 * explicitly supplied type and data.
 *
 * @param type The data type identifier.
 * @param data The data value.
 *
 * @return String The coerced string value.  If the value is
 *         null or the type is not known, null is returned.
 */

public static final java.lang.String coerceToString(int type, int data) { throw new RuntimeException("Stub!"); }

public void setTo(android.util.TypedValue other) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** Complex data: mask to extract mantissa information (after shifting by
 *  {@link #COMPLEX_MANTISSA_SHIFT}). This gives us 23 bits of precision;
 *  the top bit is the sign. */

public static final int COMPLEX_MANTISSA_MASK = 16777215; // 0xffffff

/** Complex data: bit location of mantissa information. */

public static final int COMPLEX_MANTISSA_SHIFT = 8; // 0x8

/** Complex data: the mantissa magnitude is 0 bits -- i.e, 0x0.nnnnnn */

public static final int COMPLEX_RADIX_0p23 = 3; // 0x3

/** Complex data: the mantissa magnitude is 16 bits -- i.e, 0xnnnn.nn */

public static final int COMPLEX_RADIX_16p7 = 1; // 0x1

/** Complex data: the mantissa is an integral number -- i.e., 0xnnnnnn.0 */

public static final int COMPLEX_RADIX_23p0 = 0; // 0x0

/** Complex data: the mantissa magnitude is 8 bits -- i.e, 0xnn.nnnn */

public static final int COMPLEX_RADIX_8p15 = 2; // 0x2

/** Complex data: mask to extract radix information (after shifting by
 * {@link #COMPLEX_RADIX_SHIFT}). This give us 4 possible fixed point
 * representations as defined below. */

public static final int COMPLEX_RADIX_MASK = 3; // 0x3

/** Complex data: where the radix information is, telling where the decimal
 *  place appears in the mantissa. */

public static final int COMPLEX_RADIX_SHIFT = 4; // 0x4

/** {@link #TYPE_DIMENSION} complex unit: Value is Device Independent
 *  Pixels. */

public static final int COMPLEX_UNIT_DIP = 1; // 0x1

/** {@link #TYPE_FRACTION} complex unit: A basic fraction of the overall
 *  size. */

public static final int COMPLEX_UNIT_FRACTION = 0; // 0x0

/** {@link #TYPE_FRACTION} complex unit: A fraction of the parent size. */

public static final int COMPLEX_UNIT_FRACTION_PARENT = 1; // 0x1

/** {@link #TYPE_DIMENSION} complex unit: Value is in inches. */

public static final int COMPLEX_UNIT_IN = 4; // 0x4

/** Complex data: mask to extract unit information (after shifting by
 *  {@link #COMPLEX_UNIT_SHIFT}). This gives us 16 possible types, as
 *  defined below. */

public static final int COMPLEX_UNIT_MASK = 15; // 0xf

/** {@link #TYPE_DIMENSION} complex unit: Value is in millimeters. */

public static final int COMPLEX_UNIT_MM = 5; // 0x5

/** {@link #TYPE_DIMENSION} complex unit: Value is in points. */

public static final int COMPLEX_UNIT_PT = 3; // 0x3

/** {@link #TYPE_DIMENSION} complex unit: Value is raw pixels. */

public static final int COMPLEX_UNIT_PX = 0; // 0x0

/** Complex data: bit location of unit information. */

public static final int COMPLEX_UNIT_SHIFT = 0; // 0x0

/** {@link #TYPE_DIMENSION} complex unit: Value is a scaled pixel. */

public static final int COMPLEX_UNIT_SP = 2; // 0x2

/**
 * {@link #TYPE_NULL} data indicating the value was explicitly set to null.
 */

public static final int DATA_NULL_EMPTY = 1; // 0x1

/**
 * {@link #TYPE_NULL} data indicating the value was not specified.
 */

public static final int DATA_NULL_UNDEFINED = 0; // 0x0

/**
 * If {@link #density} is equal to this value, then the density should be
 * treated as the system's default density value: {@link DisplayMetrics#DENSITY_DEFAULT}.
 */

public static final int DENSITY_DEFAULT = 0; // 0x0

/**
 * If {@link #density} is equal to this value, then there is no density
 * associated with the resource and it should not be scaled.
 */

public static final int DENSITY_NONE = 65535; // 0xffff

/** The <var>data</var> field holds an attribute resource
 *  identifier (referencing an attribute in the current theme
 *  style, not a resource entry). */

public static final int TYPE_ATTRIBUTE = 2; // 0x2

/** The <var>data</var> field holds a complex number encoding a
 *  dimension value. */

public static final int TYPE_DIMENSION = 5; // 0x5

/** Identifies the start of integer values that were specified as
 *  color constants (starting with '#'). */

public static final int TYPE_FIRST_COLOR_INT = 28; // 0x1c

/** Identifies the start of plain integer values.  Any type value
 *  from this to {@link #TYPE_LAST_INT} means the
 *  <var>data</var> field holds a generic integer value. */

public static final int TYPE_FIRST_INT = 16; // 0x10

/** The <var>data</var> field holds an IEEE 754 floating point number. */

public static final int TYPE_FLOAT = 4; // 0x4

/** The <var>data</var> field holds a complex number encoding a fraction
 *  of a container. */

public static final int TYPE_FRACTION = 6; // 0x6

/** The <var>data</var> field holds 0 or 1 that was originally
 *  specified as "false" or "true". */

public static final int TYPE_INT_BOOLEAN = 18; // 0x12

/** The <var>data</var> field holds a color that was originally
 *  specified as #argb. */

public static final int TYPE_INT_COLOR_ARGB4 = 30; // 0x1e

/** The <var>data</var> field holds a color that was originally
 *  specified as #aarrggbb. */

public static final int TYPE_INT_COLOR_ARGB8 = 28; // 0x1c

/** The <var>data</var> field holds a color that was originally
 *  specified as #rgb. */

public static final int TYPE_INT_COLOR_RGB4 = 31; // 0x1f

/** The <var>data</var> field holds a color that was originally
 *  specified as #rrggbb. */

public static final int TYPE_INT_COLOR_RGB8 = 29; // 0x1d

/** The <var>data</var> field holds a number that was
 *  originally specified in decimal. */

public static final int TYPE_INT_DEC = 16; // 0x10

/** The <var>data</var> field holds a number that was
 *  originally specified in hexadecimal (0xn). */

public static final int TYPE_INT_HEX = 17; // 0x11

/** Identifies the end of integer values that were specified as color
 *  constants. */

public static final int TYPE_LAST_COLOR_INT = 31; // 0x1f

/** Identifies the end of plain integer values. */

public static final int TYPE_LAST_INT = 31; // 0x1f

/** The value contains no data. */

public static final int TYPE_NULL = 0; // 0x0

/** The <var>data</var> field holds a resource identifier. */

public static final int TYPE_REFERENCE = 1; // 0x1

/** The <var>string</var> field holds string data.  In addition, if
 *  <var>data</var> is non-zero then it is the string block
 *  index of the string and <var>assetCookie</var> is the set of
 *  assets the string came from. */

public static final int TYPE_STRING = 3; // 0x3

/** Additional information about where the value came from; only
 *  set for strings. */

public int assetCookie;

/**
 * If the value came from a resource, these are the configurations for
 * which its contents can change.
 *
 * <p>For example, if a resource has a value defined for the -land resource qualifier,
 * this field will have the {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION} bit set.
 * </p>
 *
 * Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 * @see android.content.pm.ActivityInfo#CONFIG_MCC
 * @see android.content.pm.ActivityInfo#CONFIG_MNC
 * @see android.content.pm.ActivityInfo#CONFIG_LOCALE
 * @see android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN
 * @see android.content.pm.ActivityInfo#CONFIG_KEYBOARD
 * @see android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN
 * @see android.content.pm.ActivityInfo#CONFIG_NAVIGATION
 * @see android.content.pm.ActivityInfo#CONFIG_ORIENTATION
 * @see android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT
 * @see android.content.pm.ActivityInfo#CONFIG_UI_MODE
 * @see android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE
 * @see android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE
 * @see android.content.pm.ActivityInfo#CONFIG_DENSITY
 * @see android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION
 * @see android.content.pm.ActivityInfo#CONFIG_COLOR_MODE
 *
 */

public int changingConfigurations = -1; // 0xffffffff

/** Basic data in the value, interpreted according to {@link #type} */

public int data;

/**
 * If the Value came from a resource, this holds the corresponding pixel density.
 * */

public int density;

/** If Value came from a resource, this holds the corresponding resource id. */

public int resourceId;

/** If the value holds a string, this is it. */

public java.lang.CharSequence string;

/** The type held by this value, as defined by the constants here.
 *  This tells you how to interpret the other fields in the object. */

public int type;
}

