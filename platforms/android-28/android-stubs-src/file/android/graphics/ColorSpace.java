/*
 * Copyright (C) 2016 The Android Open Source Project
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

import java.util.List;

/**
 * {@usesMathJax}
 *
 * <p>A {@link ColorSpace} is used to identify a specific organization of colors.
 * Each color space is characterized by a {@link Model color model} that defines
 * how a color value is represented (for instance the {@link Model#RGB RGB} color
 * model defines a color value as a triplet of numbers).</p>
 *
 * <p>Each component of a color must fall within a valid range, specific to each
 * color space, defined by {@link #getMinValue(int)} and {@link #getMaxValue(int)}
 * This range is commonly \([0..1]\). While it is recommended to use values in the
 * valid range, a color space always clamps input and output values when performing
 * operations such as converting to a different color space.</p>
 *
 * <h3>Using color spaces</h3>
 *
 * <p>This implementation provides a pre-defined set of common color spaces
 * described in the {@link Named} enum. To obtain an instance of one of the
 * pre-defined color spaces, simply invoke {@link #get(Named)}:</p>
 *
 * <pre class="prettyprint">
 * ColorSpace sRgb = ColorSpace.get(ColorSpace.Named.SRGB);
 * </pre>
 *
 * <p>The {@link #get(Named)} method always returns the same instance for a given
 * name. Color spaces with an {@link Model#RGB RGB} color model can be safely
 * cast to {@link Rgb}. Doing so gives you access to more APIs to query various
 * properties of RGB color models: color gamut primaries, transfer functions,
 * conversions to and from linear space, etc. Please refer to {@link Rgb} for
 * more information.</p>
 *
 * <p>The documentation of {@link Named} provides a detailed description of the
 * various characteristics of each available color space.</p>
 *
 * <h3>Color space conversions</h3>
 
 * <p>To allow conversion between color spaces, this implementation uses the CIE
 * XYZ profile connection space (PCS). Color values can be converted to and from
 * this PCS using {@link #toXyz(float[])} and {@link #fromXyz(float[])}.</p>
 *
 * <p>For color space with a non-RGB color model, the white point of the PCS
 * <em>must be</em> the CIE standard illuminant D50. RGB color spaces use their
 * native white point (D65 for {@link Named#SRGB sRGB} for instance and must
 * undergo {@link Adaptation chromatic adaptation} as necessary.</p>
 *
 * <p>Since the white point of the PCS is not defined for RGB color space, it is
 * highly recommended to use the variants of the {@link #connect(ColorSpace, ColorSpace)}
 * method to perform conversions between color spaces. A color space can be
 * manually adapted to a specific white point using {@link #adapt(ColorSpace, float[])}.
 * Please refer to the documentation of {@link Rgb RGB color spaces} for more
 * information. Several common CIE standard illuminants are provided in this
 * class as reference (see {@link #ILLUMINANT_D65} or {@link #ILLUMINANT_D50}
 * for instance).</p>
 *
 * <p>Here is an example of how to convert from a color space to another:</p>
 *
 * <pre class="prettyprint">
 * // Convert from DCI-P3 to Rec.2020
 * ColorSpace.Connector connector = ColorSpace.connect(
 *         ColorSpace.get(ColorSpace.Named.DCI_P3),
 *         ColorSpace.get(ColorSpace.Named.BT2020));
 *
 * float[] bt2020 = connector.transform(p3r, p3g, p3b);
 * </pre>
 *
 * <p>You can easily convert to {@link Named#SRGB sRGB} by omitting the second
 * parameter:</p>
 *
 * <pre class="prettyprint">
 * // Convert from DCI-P3 to sRGB
 * ColorSpace.Connector connector = ColorSpace.connect(ColorSpace.get(ColorSpace.Named.DCI_P3));
 *
 * float[] sRGB = connector.transform(p3r, p3g, p3b);
 * </pre>
 *
 * <p>Conversions also work between color spaces with different color models:</p>
 *
 * <pre class="prettyprint">
 * // Convert from CIE L*a*b* (color model Lab) to Rec.709 (color model RGB)
 * ColorSpace.Connector connector = ColorSpace.connect(
 *         ColorSpace.get(ColorSpace.Named.CIE_LAB),
 *         ColorSpace.get(ColorSpace.Named.BT709));
 * </pre>
 *
 * <h3>Color spaces and multi-threading</h3>
 *
 * <p>Color spaces and other related classes ({@link Connector} for instance)
 * are immutable and stateless. They can be safely used from multiple concurrent
 * threads.</p>
 *
 * <p>Public static methods provided by this class, such as {@link #get(Named)}
 * and {@link #connect(ColorSpace, ColorSpace)}, are also guaranteed to be
 * thread-safe.</p>
 *
 * @see #get(Named)
 * @see Named
 * @see Model
 * @see Connector
 * @see Adaptation
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ColorSpace {

ColorSpace(java.lang.String name, android.graphics.ColorSpace.Model model, int id) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the name of this color space. The name is never null
 * and contains always at least 1 character.</p>
 *
 * <p>Color space names are recommended to be unique but are not
 * guaranteed to be. There is no defined format but the name usually
 * falls in one of the following categories:</p>
 * <ul>
 *     <li>Generic names used to identify color spaces in non-RGB
 *     color models. For instance: {@link Named#CIE_LAB Generic L*a*b*}.</li>
 *     <li>Names tied to a particular specification. For instance:
 *     {@link Named#SRGB sRGB IEC61966-2.1} or
 *     {@link Named#ACES SMPTE ST 2065-1:2012 ACES}.</li>
 *     <li>Ad-hoc names, often generated procedurally or by the user
 *     during a calibration workflow. These names often contain the
 *     make and model of the display.</li>
 * </ul>
 *
 * <p>Because the format of color space names is not defined, it is
 * not recommended to programmatically identify a color space by its
 * name alone. Names can be used as a first approximation.</p>
 *
 * <p>It is however perfectly acceptable to display color space names to
 * users in a UI, or in debuggers and logs. When displaying a color space
 * name to the user, it is recommended to add extra information to avoid
 * ambiguities: color model, a representation of the color space's gamut,
 * white point, etc.</p>
 *
 * @return A non-null String of length >= 1
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ID of this color space. Positive IDs match the color
 * spaces enumerated in {@link Named}. A negative ID indicates a
 * color space created by calling one of the public constructors.
 *
 * @return An integer between {@link #MIN_ID} and {@link #MAX_ID}

 * Value is between MIN_ID and MAX_ID inclusive
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * Return the color model of this color space.
 *
 * @return A non-null {@link Model}
 *
 * @see Model
 * @see #getComponentCount()
 */

@androidx.annotation.RecentlyNonNull public android.graphics.ColorSpace.Model getModel() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of components that form a color value according
 * to this color space's color model.
 *
 * @return An integer between 1 and 4
 *
 * Value is between 1 and 4 inclusive
 * @see Model
 * @see #getModel()
 */

public int getComponentCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this color space is a wide-gamut color space.
 * An RGB color space is wide-gamut if its gamut entirely contains
 * the {@link Named#SRGB sRGB} gamut and if the area of its gamut is
 * 90% of greater than the area of the {@link Named#NTSC_1953 NTSC}
 * gamut.
 *
 * @return True if this color space is a wide-gamut color space,
 *         false otherwise
 */

public abstract boolean isWideGamut();

/**
 * <p>Indicates whether this color space is the sRGB color space or
 * equivalent to the sRGB color space.</p>
 * <p>A color space is considered sRGB if it meets all the following
 * conditions:</p>
 * <ul>
 *     <li>Its color model is {@link Model#RGB}.</li>
 *     <li>
 *         Its primaries are within 1e-3 of the true
 *         {@link Named#SRGB sRGB} primaries.
 *     </li>
 *     <li>
 *         Its white point is withing 1e-3 of the CIE standard
 *         illuminant {@link #ILLUMINANT_D65 D65}.
 *     </li>
 *     <li>Its opto-electronic transfer function is not linear.</li>
 *     <li>Its electro-optical transfer function is not linear.</li>
 *     <li>Its range is \([0..1]\).</li>
 * </ul>
 * <p>This method always returns true for {@link Named#SRGB}.</p>
 *
 * @return True if this color space is the sRGB color space (or a
 *         close approximation), false otherwise
 */

public boolean isSrgb() { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum valid value for the specified component of this
 * color space's color model.
 *
 * @param component The index of the component
 * Value is between 0 and 3 inclusive
 * @return A floating point value less than {@link #getMaxValue(int)}
 *
 * @see #getMaxValue(int)
 * @see Model#getComponentCount()
 */

public abstract float getMinValue(int component);

/**
 * Returns the maximum valid value for the specified component of this
 * color space's color model.
 *
 * @param component The index of the component
 * Value is between 0 and 3 inclusive
 * @return A floating point value greater than {@link #getMinValue(int)}
 *
 * @see #getMinValue(int)
 * @see Model#getComponentCount()
 */

public abstract float getMaxValue(int component);

/**
 * <p>Converts a color value from this color space's model to
 * tristimulus CIE XYZ values. If the color model of this color
 * space is not {@link Model#RGB RGB}, it is assumed that the
 * target CIE XYZ space uses a {@link #ILLUMINANT_D50 D50}
 * standard illuminant.</p>
 *
 * <p>This method is a convenience for color spaces with a model
 * of 3 components ({@link Model#RGB RGB} or {@link Model#LAB}
 * for instance). With color spaces using fewer or more components,
 * use {@link #toXyz(float[])} instead</p>.
 *
 * @param r The first component of the value to convert from (typically R in RGB)
 * @param g The second component of the value to convert from (typically G in RGB)
 * @param b The third component of the value to convert from (typically B in RGB)
 * @return A new array of 3 floats, containing tristimulus XYZ values
 *
 * This value will never be {@code null}.
 * @see #toXyz(float[])
 * @see #fromXyz(float, float, float)
 */

@androidx.annotation.RecentlyNonNull public float[] toXyz(float r, float g, float b) { throw new RuntimeException("Stub!"); }

/**
 * <p>Converts a color value from this color space's model to
 * tristimulus CIE XYZ values. If the color model of this color
 * space is not {@link Model#RGB RGB}, it is assumed that the
 * target CIE XYZ space uses a {@link #ILLUMINANT_D50 D50}
 * standard illuminant.</p>
 *
 * <p class="note">The specified array's length  must be at least
 * equal to to the number of color components as returned by
 * {@link Model#getComponentCount()}.</p>
 *
 * @param v An array of color components containing the color space's
 *          color value to convert to XYZ, and large enough to hold
 *          the resulting tristimulus XYZ values
 * This value must never be {@code null}.
 * @return The array passed in parameter
 *
 * This value will never be {@code null}.
 * @see #toXyz(float, float, float)
 * @see #fromXyz(float[])
 */

@androidx.annotation.RecentlyNonNull public abstract float[] toXyz(@androidx.annotation.RecentlyNonNull float[] v);

/**
 * <p>Converts tristimulus values from the CIE XYZ space to this
 * color space's color model.</p>
 *
 * @param x The X component of the color value
 * @param y The Y component of the color value
 * @param z The Z component of the color value
 * @return A new array whose size is equal to the number of color
 *         components as returned by {@link Model#getComponentCount()}
 *
 * This value will never be {@code null}.
 * @see #fromXyz(float[])
 * @see #toXyz(float, float, float)
 */

@androidx.annotation.RecentlyNonNull public float[] fromXyz(float x, float y, float z) { throw new RuntimeException("Stub!"); }

/**
 * <p>Converts tristimulus values from the CIE XYZ space to this color
 * space's color model. The resulting value is passed back in the specified
 * array.</p>
 *
 * <p class="note">The specified array's length  must be at least equal to
 * to the number of color components as returned by
 * {@link Model#getComponentCount()}, and its first 3 values must
 * be the XYZ components to convert from.</p>
 *
 * @param v An array of color components containing the XYZ values
 *          to convert from, and large enough to hold the number
 *          of components of this color space's model
 * This value must never be {@code null}.
 * @return The array passed in parameter
 *
 * This value will never be {@code null}.
 * @see #fromXyz(float, float, float)
 * @see #toXyz(float[])
 */

@androidx.annotation.RecentlyNonNull public abstract float[] fromXyz(@androidx.annotation.RecentlyNonNull float[] v);

/**
 * <p>Returns a string representation of the object. This method returns
 * a string equal to the value of:</p>
 *
 * <pre class="prettyprint">
 * getName() + "(id=" + getId() + ", model=" + getModel() + ")"
 * </pre>
 *
 * <p>For instance, the string representation of the {@link Named#SRGB sRGB}
 * color space is equal to the following value:</p>
 *
 * <pre>
 * sRGB IEC61966-2.1 (id=0, model=RGB)
 * </pre>
 *
 * @return A string representation of the object

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * <p>Connects two color spaces to allow conversion from the source color
 * space to the destination color space. If the source and destination
 * color spaces do not have the same profile connection space (CIE XYZ
 * with the same white point), they are chromatically adapted to use the
 * CIE standard illuminant {@link #ILLUMINANT_D50 D50} as needed.</p>
 *
 * <p>If the source and destination are the same, an optimized connector
 * is returned to avoid unnecessary computations and loss of precision.</p>
 *
 * <p>Colors are mapped from the source color space to the destination color
 * space using the {@link RenderIntent#PERCEPTUAL perceptual} render intent.</p>
 *
 * @param source The color space to convert colors from
 * This value must never be {@code null}.
 * @param destination The color space to convert colors to
 * This value must never be {@code null}.
 * @return A non-null connector between the two specified color spaces
 *
 * @see #connect(ColorSpace)
 * @see #connect(ColorSpace, RenderIntent)
 * @see #connect(ColorSpace, ColorSpace, RenderIntent)
 */

@androidx.annotation.RecentlyNonNull public static android.graphics.ColorSpace.Connector connect(@androidx.annotation.RecentlyNonNull android.graphics.ColorSpace source, @androidx.annotation.RecentlyNonNull android.graphics.ColorSpace destination) { throw new RuntimeException("Stub!"); }

/**
 * <p>Connects two color spaces to allow conversion from the source color
 * space to the destination color space. If the source and destination
 * color spaces do not have the same profile connection space (CIE XYZ
 * with the same white point), they are chromatically adapted to use the
 * CIE standard illuminant {@link #ILLUMINANT_D50 D50} as needed.</p>
 *
 * <p>If the source and destination are the same, an optimized connector
 * is returned to avoid unnecessary computations and loss of precision.</p>
 *
 * @param source The color space to convert colors from
 * This value must never be {@code null}.
 * @param destination The color space to convert colors to
 * This value must never be {@code null}.
 * @param intent The render intent to map colors from the source to the destination
 * This value must never be {@code null}.
 * @return A non-null connector between the two specified color spaces
 *
 * @see #connect(ColorSpace)
 * @see #connect(ColorSpace, RenderIntent)
 * @see #connect(ColorSpace, ColorSpace)
 */

@androidx.annotation.RecentlyNonNull public static android.graphics.ColorSpace.Connector connect(@androidx.annotation.RecentlyNonNull android.graphics.ColorSpace source, @androidx.annotation.RecentlyNonNull android.graphics.ColorSpace destination, @androidx.annotation.RecentlyNonNull android.graphics.ColorSpace.RenderIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * <p>Connects the specified color spaces to sRGB.
 * If the source color space does not use CIE XYZ D65 as its profile
 * connection space, the two spaces are chromatically adapted to use the
 * CIE standard illuminant {@link #ILLUMINANT_D50 D50} as needed.</p>
 *
 * <p>If the source is the sRGB color space, an optimized connector
 * is returned to avoid unnecessary computations and loss of precision.</p>
 *
 * <p>Colors are mapped from the source color space to the destination color
 * space using the {@link RenderIntent#PERCEPTUAL perceptual} render intent.</p>
 *
 * @param source The color space to convert colors from
 * This value must never be {@code null}.
 * @return A non-null connector between the specified color space and sRGB
 *
 * @see #connect(ColorSpace, RenderIntent)
 * @see #connect(ColorSpace, ColorSpace)
 * @see #connect(ColorSpace, ColorSpace, RenderIntent)
 */

@androidx.annotation.RecentlyNonNull public static android.graphics.ColorSpace.Connector connect(@androidx.annotation.RecentlyNonNull android.graphics.ColorSpace source) { throw new RuntimeException("Stub!"); }

/**
 * <p>Connects the specified color spaces to sRGB.
 * If the source color space does not use CIE XYZ D65 as its profile
 * connection space, the two spaces are chromatically adapted to use the
 * CIE standard illuminant {@link #ILLUMINANT_D50 D50} as needed.</p>
 *
 * <p>If the source is the sRGB color space, an optimized connector
 * is returned to avoid unnecessary computations and loss of precision.</p>
 *
 * @param source The color space to convert colors from
 * This value must never be {@code null}.
 * @param intent The render intent to map colors from the source to the destination
 * This value must never be {@code null}.
 * @return A non-null connector between the specified color space and sRGB
 *
 * @see #connect(ColorSpace)
 * @see #connect(ColorSpace, ColorSpace)
 * @see #connect(ColorSpace, ColorSpace, RenderIntent)
 */

@androidx.annotation.RecentlyNonNull public static android.graphics.ColorSpace.Connector connect(@androidx.annotation.RecentlyNonNull android.graphics.ColorSpace source, @androidx.annotation.RecentlyNonNull android.graphics.ColorSpace.RenderIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * <p>Performs the chromatic adaptation of a color space from its native
 * white point to the specified white point.</p>
 *
 * <p>The chromatic adaptation is performed using the
 * {@link Adaptation#BRADFORD} matrix.</p>
 *
 * <p class="note">The color space returned by this method always has
 * an ID of {@link #MIN_ID}.</p>
 *
 * @param colorSpace The color space to chromatically adapt
 * This value must never be {@code null}.
 * @param whitePoint The new white point
 * This value must never be {@code null}.
 * @return A {@link ColorSpace} instance with the same name, primaries,
 *         transfer functions and range as the specified color space
 *
 * This value will never be {@code null}.
 * @see Adaptation
 * @see #adapt(ColorSpace, float[], Adaptation)
 */

@androidx.annotation.RecentlyNonNull public static android.graphics.ColorSpace adapt(@androidx.annotation.RecentlyNonNull android.graphics.ColorSpace colorSpace, @androidx.annotation.RecentlyNonNull float[] whitePoint) { throw new RuntimeException("Stub!"); }

/**
 * <p>Performs the chromatic adaptation of a color space from its native
 * white point to the specified white point. If the specified color space
 * does not have an {@link Model#RGB RGB} color model, or if the color
 * space already has the target white point, the color space is returned
 * unmodified.</p>
 *
 * <p>The chromatic adaptation is performed using the von Kries method
 * described in the documentation of {@link Adaptation}.</p>
 *
 * <p class="note">The color space returned by this method always has
 * an ID of {@link #MIN_ID}.</p>
 *
 * @param colorSpace The color space to chromatically adapt
 * This value must never be {@code null}.
 * @param whitePoint The new white point
 * This value must never be {@code null}.
 * @param adaptation The adaptation matrix
 * This value must never be {@code null}.
 * @return A new color space if the specified color space has an RGB
 *         model and a white point different from the specified white
 *         point; the specified color space otherwise
 *
 * This value will never be {@code null}.
 * @see Adaptation
 * @see #adapt(ColorSpace, float[])
 */

@androidx.annotation.RecentlyNonNull public static android.graphics.ColorSpace adapt(@androidx.annotation.RecentlyNonNull android.graphics.ColorSpace colorSpace, @androidx.annotation.RecentlyNonNull float[] whitePoint, @androidx.annotation.RecentlyNonNull android.graphics.ColorSpace.Adaptation adaptation) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns an instance of {@link ColorSpace} identified by the specified
 * name. The list of names provided in the {@link Named} enum gives access
 * to a variety of common RGB color spaces.</p>
 *
 * <p>This method always returns the same instance for a given name.</p>
 *
 * <p>This method is thread-safe.</p>
 *
 * @param name The name of the color space to get an instance of
 * This value must never be {@code null}.
 * @return A non-null {@link ColorSpace} instance
 */

@androidx.annotation.RecentlyNonNull public static android.graphics.ColorSpace get(@androidx.annotation.RecentlyNonNull android.graphics.ColorSpace.Named name) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns a {@link Named} instance of {@link ColorSpace} that matches
 * the specified RGB to CIE XYZ transform and transfer functions. If no
 * instance can be found, this method returns null.</p>
 *
 * <p>The color transform matrix is assumed to target the CIE XYZ space
 * a {@link #ILLUMINANT_D50 D50} standard illuminant.</p>
 *
 * @param toXYZD50 3x3 column-major transform matrix from RGB to the profile
 *                 connection space CIE XYZ as an array of 9 floats, cannot be null
 * This value must never be {@code null}.
 * @param function Parameters for the transfer functions
 * This value must never be {@code null}.
 * @return A non-null {@link ColorSpace} if a match is found, null otherwise
 */

@androidx.annotation.RecentlyNullable public static android.graphics.ColorSpace match(@androidx.annotation.RecentlyNonNull float[] toXYZD50, @androidx.annotation.RecentlyNonNull android.graphics.ColorSpace.Rgb.TransferParameters function) { throw new RuntimeException("Stub!"); }

/**
 * Standard CIE 1931 2° illuminant A, encoded in xyY.
 * This illuminant has a color temperature of 2856K.
 */

public static final float[] ILLUMINANT_A;
static { ILLUMINANT_A = new float[0]; }

/**
 * Standard CIE 1931 2° illuminant B, encoded in xyY.
 * This illuminant has a color temperature of 4874K.
 */

public static final float[] ILLUMINANT_B;
static { ILLUMINANT_B = new float[0]; }

/**
 * Standard CIE 1931 2° illuminant C, encoded in xyY.
 * This illuminant has a color temperature of 6774K.
 */

public static final float[] ILLUMINANT_C;
static { ILLUMINANT_C = new float[0]; }

/**
 * Standard CIE 1931 2° illuminant D50, encoded in xyY.
 * This illuminant has a color temperature of 5003K. This illuminant
 * is used by the profile connection space in ICC profiles.
 */

public static final float[] ILLUMINANT_D50;
static { ILLUMINANT_D50 = new float[0]; }

/**
 * Standard CIE 1931 2° illuminant D55, encoded in xyY.
 * This illuminant has a color temperature of 5503K.
 */

public static final float[] ILLUMINANT_D55;
static { ILLUMINANT_D55 = new float[0]; }

/**
 * Standard CIE 1931 2° illuminant D60, encoded in xyY.
 * This illuminant has a color temperature of 6004K.
 */

public static final float[] ILLUMINANT_D60;
static { ILLUMINANT_D60 = new float[0]; }

/**
 * Standard CIE 1931 2° illuminant D65, encoded in xyY.
 * This illuminant has a color temperature of 6504K. This illuminant
 * is commonly used in RGB color spaces such as sRGB, BT.209, etc.
 */

public static final float[] ILLUMINANT_D65;
static { ILLUMINANT_D65 = new float[0]; }

/**
 * Standard CIE 1931 2° illuminant D75, encoded in xyY.
 * This illuminant has a color temperature of 7504K.
 */

public static final float[] ILLUMINANT_D75;
static { ILLUMINANT_D75 = new float[0]; }

/**
 * Standard CIE 1931 2° illuminant E, encoded in xyY.
 * This illuminant has a color temperature of 5454K.
 */

public static final float[] ILLUMINANT_E;
static { ILLUMINANT_E = new float[0]; }

/**
 * The maximum ID value a color space can have.
 *
 * @see #getId()
 */

public static final int MAX_ID = 63; // 0x3f

/**
 * The minimum ID value a color space can have.
 *
 * @see #getId()
 */

public static final int MIN_ID = -1; // 0xffffffff
/**
 * {@usesMathJax}
 *
 * <p>List of adaptation matrices that can be used for chromatic adaptation
 * using the von Kries transform. These matrices are used to convert values
 * in the CIE XYZ space to values in the LMS space (Long Medium Short).</p>
 *
 * <p>Given an adaptation matrix \(A\), the conversion from XYZ to
 * LMS is straightforward:</p>
 *
 * $$\left[ \begin{array}{c} L\\ M\\ S \end{array} \right] =
 * A \left[ \begin{array}{c} X\\ Y\\ Z \end{array} \right]$$
 *
 * <p>The complete von Kries transform \(T\) uses a diagonal matrix
 * noted \(D\) to perform the adaptation in LMS space. In addition
 * to \(A\) and \(D\), the source white point \(W1\) and the destination
 * white point \(W2\) must be specified:</p>
 *
 * $$\begin{align*}
 * \left[ \begin{array}{c} L_1\\ M_1\\ S_1 \end{array} \right] &=
 *      A \left[ \begin{array}{c} W1_X\\ W1_Y\\ W1_Z \end{array} \right] \\
 * \left[ \begin{array}{c} L_2\\ M_2\\ S_2 \end{array} \right] &=
 *      A \left[ \begin{array}{c} W2_X\\ W2_Y\\ W2_Z \end{array} \right] \\
 * D &= \left[ \begin{matrix} \frac{L_2}{L_1} & 0 & 0 \\
 *      0 & \frac{M_2}{M_1} & 0 \\
 *      0 & 0 & \frac{S_2}{S_1} \end{matrix} \right] \\
 * T &= A^{-1}.D.A
 * \end{align*}$$
 *
 * <p>As an example, the resulting matrix \(T\) can then be used to
 * perform the chromatic adaptation of sRGB XYZ transform from D65
 * to D50:</p>
 *
 * $$sRGB_{D50} = T.sRGB_{D65}$$
 *
 * @see ColorSpace.Connector
 * @see ColorSpace#connect(ColorSpace, ColorSpace)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Adaptation {
BRADFORD, VON_KRIES, CIECAT02;
}

/**
 * {@usesMathJax}
 *
 * <p>A connector transforms colors from a source color space to a destination
 * color space.</p>
 *
 * <p>A source color space is connected to a destination color space using the
 * color transform \(C\) computed from their respective transforms noted
 * \(T_{src}\) and \(T_{dst}\) in the following equation:</p>
 *
 * $$C = T^{-1}_{dst} . T_{src}$$
 *
 * <p>The transform \(C\) shown above is only valid when the source and
 * destination color spaces have the same profile connection space (PCS).
 * We know that instances of {@link ColorSpace} always use CIE XYZ as their
 * PCS but their white points might differ. When they do, we must perform
 * a chromatic adaptation of the color spaces' transforms. To do so, we
 * use the von Kries method described in the documentation of {@link Adaptation},
 * using the CIE standard illuminant {@link ColorSpace#ILLUMINANT_D50 D50}
 * as the target white point.</p>
 *
 * <p>Example of conversion from {@link Named#SRGB sRGB} to
 * {@link Named#DCI_P3 DCI-P3}:</p>
 *
 * <pre class="prettyprint">
 * ColorSpace.Connector connector = ColorSpace.connect(
 *         ColorSpace.get(ColorSpace.Named.SRGB),
 *         ColorSpace.get(ColorSpace.Named.DCI_P3));
 * float[] p3 = connector.transform(1.0f, 0.0f, 0.0f);
 * // p3 contains { 0.9473, 0.2740, 0.2076 }
 * </pre>
 *
 * @see Adaptation
 * @see ColorSpace#adapt(ColorSpace, float[], Adaptation)
 * @see ColorSpace#adapt(ColorSpace, float[])
 * @see ColorSpace#connect(ColorSpace, ColorSpace, RenderIntent)
 * @see ColorSpace#connect(ColorSpace, ColorSpace)
 * @see ColorSpace#connect(ColorSpace, RenderIntent)
 * @see ColorSpace#connect(ColorSpace)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Connector {

/**
 * Creates a new connector between a source and a destination color space.
 *
 * @param source The source color space, cannot be null
 * @param destination The destination color space, cannot be null
 * @param intent The render intent to use when compressing gamuts
 */

Connector(android.graphics.ColorSpace source, android.graphics.ColorSpace destination, android.graphics.ColorSpace.RenderIntent intent) { throw new RuntimeException("Stub!"); }

/**
 * Returns the source color space this connector will convert from.
 *
 * @return A non-null instance of {@link ColorSpace}
 *
 * @see #getDestination()
 */

@androidx.annotation.RecentlyNonNull public android.graphics.ColorSpace getSource() { throw new RuntimeException("Stub!"); }

/**
 * Returns the destination color space this connector will convert to.
 *
 * @return A non-null instance of {@link ColorSpace}
 *
 * @see #getSource()
 */

@androidx.annotation.RecentlyNonNull public android.graphics.ColorSpace getDestination() { throw new RuntimeException("Stub!"); }

/**
 * Returns the render intent this connector will use when mapping the
 * source color space to the destination color space.
 *
 * @return A non-null {@link RenderIntent}
 *
 * @see RenderIntent
 */

public android.graphics.ColorSpace.RenderIntent getRenderIntent() { throw new RuntimeException("Stub!"); }

/**
 * <p>Transforms the specified color from the source color space
 * to a color in the destination color space. This convenience
 * method assumes a source color model with 3 components
 * (typically RGB). To transform from color models with more than
 * 3 components, such as {@link Model#CMYK CMYK}, use
 * {@link #transform(float[])} instead.</p>
 *
 * @param r The red component of the color to transform
 * @param g The green component of the color to transform
 * @param b The blue component of the color to transform
 * @return A new array of 3 floats containing the specified color
 *         transformed from the source space to the destination space
 *
 * This value will never be {@code null}.
 * @see #transform(float[])
 */

@androidx.annotation.RecentlyNonNull public float[] transform(float r, float g, float b) { throw new RuntimeException("Stub!"); }

/**
 * <p>Transforms the specified color from the source color space
 * to a color in the destination color space.</p>
 *
 * @param v A non-null array of 3 floats containing the value to transform
 *            and that will hold the result of the transform
 * This value must never be {@code null}.
 * @return The v array passed as a parameter, containing the specified color
 *         transformed from the source space to the destination space
 *
 * @see #transform(float, float, float)
 */

@androidx.annotation.RecentlyNonNull public float[] transform(@androidx.annotation.RecentlyNonNull float[] v) { throw new RuntimeException("Stub!"); }
}

/**
 * A color model is required by a {@link ColorSpace} to describe the
 * way colors can be represented as tuples of numbers. A common color
 * model is the {@link #RGB RGB} color model which defines a color
 * as represented by a tuple of 3 numbers (red, green and blue).
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Model {
RGB, XYZ, LAB, CMYK;

/**
 * Returns the number of components for this color model.
 *
 * @return An integer between 1 and 4

 * Value is between 1 and 4 inclusive
 */

public int getComponentCount() { throw new RuntimeException("Stub!"); }
}

/**
 * {@usesMathJax}
 *
 * <p>List of common, named color spaces. A corresponding instance of
 * {@link ColorSpace} can be obtained by calling {@link ColorSpace#get(Named)}:</p>
 *
 * <pre class="prettyprint">
 * ColorSpace cs = ColorSpace.get(ColorSpace.Named.DCI_P3);
 * </pre>
 *
 * <p>The properties of each color space are described below (see {@link #SRGB sRGB}
 * for instance). When applicable, the color gamut of each color space is compared
 * to the color gamut of sRGB using a CIE 1931 xy chromaticity diagram. This diagram
 * shows the location of the color space's primaries and white point.</p>
 *
 * @see ColorSpace#get(Named)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Named {
SRGB, LINEAR_SRGB, EXTENDED_SRGB, LINEAR_EXTENDED_SRGB, BT709, BT2020, DCI_P3, DISPLAY_P3, NTSC_1953, SMPTE_C, ADOBE_RGB, PRO_PHOTO_RGB, ACES, ACESCG, CIE_XYZ, CIE_LAB;
}

/**
 * <p>A render intent determines how a {@link ColorSpace.Connector connector}
 * maps colors from one color space to another. The choice of mapping is
 * important when the source color space has a larger color gamut than the
 * destination color space.</p>
 *
 * @see ColorSpace#connect(ColorSpace, ColorSpace, RenderIntent)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum RenderIntent {
PERCEPTUAL, RELATIVE, SATURATION, ABSOLUTE;
}

/**
 * {@usesMathJax}
 *
 * <p>An RGB color space is an additive color space using the
 * {@link Model#RGB RGB} color model (a color is therefore represented
 * by a tuple of 3 numbers).</p>
 *
 * <p>A specific RGB color space is defined by the following properties:</p>
 * <ul>
 *     <li>Three chromaticities of the red, green and blue primaries, which
 *     define the gamut of the color space.</li>
 *     <li>A white point chromaticity that defines the stimulus to which
 *     color space values are normalized (also just called "white").</li>
 *     <li>An opto-electronic transfer function, also called opto-electronic
 *     conversion function or often, and approximately, gamma function.</li>
 *     <li>An electro-optical transfer function, also called electo-optical
 *     conversion function or often, and approximately, gamma function.</li>
 *     <li>A range of valid RGB values (most commonly \([0..1]\)).</li>
 * </ul>
 *
 * <p>The most commonly used RGB color space is {@link Named#SRGB sRGB}.</p>
 *
 * <h3>Primaries and white point chromaticities</h3>
 * <p>In this implementation, the chromaticity of the primaries and the white
 * point of an RGB color space is defined in the CIE xyY color space. This
 * color space separates the chromaticity of a color, the x and y components,
 * and its luminance, the Y component. Since the primaries and the white
 * point have full brightness, the Y component is assumed to be 1 and only
 * the x and y components are needed to encode them.</p>
 * <p>For convenience, this implementation also allows to define the
 * primaries and white point in the CIE XYZ space. The tristimulus XYZ values
 * are internally converted to xyY.</p>
 *
 * <p>
 *     <img style="display: block; margin: 0 auto;" src="{@docRoot}reference/android/images/graphics/colorspace_srgb.png" />
 *     <figcaption style="text-align: center;">sRGB primaries and white point</figcaption>
 * </p>
 *
 * <h3>Transfer functions</h3>
 * <p>A transfer function is a color component conversion function, defined as
 * a single variable, monotonic mathematical function. It is applied to each
 * individual component of a color. They are used to perform the mapping
 * between linear tristimulus values and non-linear electronic signal value.</p>
 * <p>The <em>opto-electronic transfer function</em> (OETF or OECF) encodes
 * tristimulus values in a scene to a non-linear electronic signal value.
 * An OETF is often expressed as a power function with an exponent between
 * 0.38 and 0.55 (the reciprocal of 1.8 to 2.6).</p>
 * <p>The <em>electro-optical transfer function</em> (EOTF or EOCF) decodes
 * a non-linear electronic signal value to a tristimulus value at the display.
 * An EOTF is often expressed as a power function with an exponent between
 * 1.8 and 2.6.</p>
 * <p>Transfer functions are used as a compression scheme. For instance,
 * linear sRGB values would normally require 11 to 12 bits of precision to
 * store all values that can be perceived by the human eye. When encoding
 * sRGB values using the appropriate OETF (see {@link Named#SRGB sRGB} for
 * an exact mathematical description of that OETF), the values can be
 * compressed to only 8 bits precision.</p>
 * <p>When manipulating RGB values, particularly sRGB values, it is safe
 * to assume that these values have been encoded with the appropriate
 * OETF (unless noted otherwise). Encoded values are often said to be in
 * "gamma space". They are therefore defined in a non-linear space. This
 * in turns means that any linear operation applied to these values is
 * going to yield mathematically incorrect results (any linear interpolation
 * such as gradient generation for instance, most image processing functions
 * such as blurs, etc.).</p>
 * <p>To properly process encoded RGB values you must first apply the
 * EOTF to decode the value into linear space. After processing, the RGB
 * value must be encoded back to non-linear ("gamma") space. Here is a
 * formal description of the process, where \(f\) is the processing
 * function to apply:</p>
 *
 * $$RGB_{out} = OETF(f(EOTF(RGB_{in})))$$
 *
 * <p>If the transfer functions of the color space can be expressed as an
 * ICC parametric curve as defined in ICC.1:2004-10, the numeric parameters
 * can be retrieved by calling {@link #getTransferParameters()}. This can
 * be useful to match color spaces for instance.</p>
 *
 * <p class="note">Some RGB color spaces, such as {@link Named#ACES} and
 * {@link Named#LINEAR_EXTENDED_SRGB scRGB}, are said to be linear because
 * their transfer functions are the identity function: \(f(x) = x\).
 * If the source and/or destination are known to be linear, it is not
 * necessary to invoke the transfer functions.</p>
 *
 * <h3>Range</h3>
 * <p>Most RGB color spaces allow RGB values in the range \([0..1]\). There
 * are however a few RGB color spaces that allow much larger ranges. For
 * instance, {@link Named#EXTENDED_SRGB scRGB} is used to manipulate the
 * range \([-0.5..7.5]\) while {@link Named#ACES ACES} can be used throughout
 * the range \([-65504, 65504]\).</p>
 *
 * <p>
 *     <img style="display: block; margin: 0 auto;" src="{@docRoot}reference/android/images/graphics/colorspace_scrgb.png" />
 *     <figcaption style="text-align: center;">Extended sRGB and its large range</figcaption>
 * </p>
 *
 * <h3>Converting between RGB color spaces</h3>
 * <p>Conversion between two color spaces is achieved by using an intermediate
 * color space called the profile connection space (PCS). The PCS used by
 * this implementation is CIE XYZ. The conversion operation is defined
 * as such:</p>
 *
 * $$RGB_{out} = OETF(T_{dst}^{-1} \cdot T_{src} \cdot EOTF(RGB_{in}))$$
 *
 * <p>Where \(T_{src}\) is the {@link #getTransform() RGB to XYZ transform}
 * of the source color space and \(T_{dst}^{-1}\) the {@link #getInverseTransform()
 * XYZ to RGB transform} of the destination color space.</p>
 * <p>Many RGB color spaces commonly used with electronic devices use the
 * standard illuminant {@link #ILLUMINANT_D65 D65}. Care must be take however
 * when converting between two RGB color spaces if their white points do not
 * match. This can be achieved by either calling
 * {@link #adapt(ColorSpace, float[])} to adapt one or both color spaces to
 * a single common white point. This can be achieved automatically by calling
 * {@link ColorSpace#connect(ColorSpace, ColorSpace)}, which also handles
 * non-RGB color spaces.</p>
 * <p>To learn more about the white point adaptation process, refer to the
 * documentation of {@link Adaptation}.</p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Rgb extends android.graphics.ColorSpace {

/**
 * <p>Creates a new RGB color space using a 3x3 column-major transform matrix.
 * The transform matrix must convert from the RGB space to the profile connection
 * space CIE XYZ.</p>
 *
 * <p class="note">The range of the color space is imposed to be \([0..1]\).</p>
 *
 * @param name Name of the color space, cannot be null, its length must be >= 1
 * This value must never be {@code null}.
 * @param toXYZ 3x3 column-major transform matrix from RGB to the profile
 *              connection space CIE XYZ as an array of 9 floats, cannot be null
 * This value must never be {@code null}.
 * @param oetf Opto-electronic transfer function, cannot be null
 * This value must never be {@code null}.
 * @param eotf Electro-optical transfer function, cannot be null
 *
 * This value must never be {@code null}.
 * @throws IllegalArgumentException If any of the following conditions is met:
 * <ul>
 *     <li>The name is null or has a length of 0.</li>
 *     <li>The OETF is null or the EOTF is null.</li>
 *     <li>The minimum valid value is >= the maximum valid value.</li>
 * </ul>
 *
 * @see #get(Named)
 */

public Rgb(@androidx.annotation.RecentlyNonNull java.lang.String name, @androidx.annotation.RecentlyNonNull float[] toXYZ, @androidx.annotation.RecentlyNonNull java.util.function.DoubleUnaryOperator oetf, @androidx.annotation.RecentlyNonNull java.util.function.DoubleUnaryOperator eotf) { super(null, null, 0); throw new RuntimeException("Stub!"); }

/**
 * <p>Creates a new RGB color space using a specified set of primaries
 * and a specified white point.</p>
 *
 * <p>The primaries and white point can be specified in the CIE xyY space
 * or in CIE XYZ. The length of the arrays depends on the chosen space:</p>
 *
 * <table summary="Parameters length">
 *     <tr><th>Space</th><th>Primaries length</th><th>White point length</th></tr>
 *     <tr><td>xyY</td><td>6</td><td>2</td></tr>
 *     <tr><td>XYZ</td><td>9</td><td>3</td></tr>
 * </table>
 *
 * <p>When the primaries and/or white point are specified in xyY, the Y component
 * does not need to be specified and is assumed to be 1.0. Only the xy components
 * are required.</p>
 *
 * <p class="note">The ID, areturned by {@link #getId()}, of an object created by
 * this constructor is always {@link #MIN_ID}.</p>
 *
 * @param name Name of the color space, cannot be null, its length must be >= 1
 * This value must never be {@code null}.
 * @param primaries RGB primaries as an array of 6 (xy) or 9 (XYZ) floats
 * This value must never be {@code null}.
 * @param whitePoint Reference white as an array of 2 (xy) or 3 (XYZ) floats
 * This value must never be {@code null}.
 * @param oetf Opto-electronic transfer function, cannot be null
 * This value must never be {@code null}.
 * @param eotf Electro-optical transfer function, cannot be null
 * This value must never be {@code null}.
 * @param min The minimum valid value in this color space's RGB range
 * @param max The maximum valid value in this color space's RGB range
 *
 * @throws IllegalArgumentException <p>If any of the following conditions is met:</p>
 * <ul>
 *     <li>The name is null or has a length of 0.</li>
 *     <li>The primaries array is null or has a length that is neither 6 or 9.</li>
 *     <li>The white point array is null or has a length that is neither 2 or 3.</li>
 *     <li>The OETF is null or the EOTF is null.</li>
 *     <li>The minimum valid value is >= the maximum valid value.</li>
 * </ul>
 *
 * @see #get(Named)
 */

public Rgb(@androidx.annotation.RecentlyNonNull java.lang.String name, @androidx.annotation.RecentlyNonNull float[] primaries, @androidx.annotation.RecentlyNonNull float[] whitePoint, @androidx.annotation.RecentlyNonNull java.util.function.DoubleUnaryOperator oetf, @androidx.annotation.RecentlyNonNull java.util.function.DoubleUnaryOperator eotf, float min, float max) { super(null, null, 0); throw new RuntimeException("Stub!"); }

/**
 * <p>Creates a new RGB color space using a 3x3 column-major transform matrix.
 * The transform matrix must convert from the RGB space to the profile connection
 * space CIE XYZ.</p>
 *
 * <p class="note">The range of the color space is imposed to be \([0..1]\).</p>
 *
 * @param name Name of the color space, cannot be null, its length must be >= 1
 * This value must never be {@code null}.
 * @param toXYZ 3x3 column-major transform matrix from RGB to the profile
 *              connection space CIE XYZ as an array of 9 floats, cannot be null
 * This value must never be {@code null}.
 * @param function Parameters for the transfer functions
 *
 * This value must never be {@code null}.
 * @throws IllegalArgumentException If any of the following conditions is met:
 * <ul>
 *     <li>The name is null or has a length of 0.</li>
 *     <li>Gamma is negative.</li>
 * </ul>
 *
 * @see #get(Named)
 */

public Rgb(@androidx.annotation.RecentlyNonNull java.lang.String name, @androidx.annotation.RecentlyNonNull float[] toXYZ, @androidx.annotation.RecentlyNonNull android.graphics.ColorSpace.Rgb.TransferParameters function) { super(null, null, 0); throw new RuntimeException("Stub!"); }

/**
 * <p>Creates a new RGB color space using a specified set of primaries
 * and a specified white point.</p>
 *
 * <p>The primaries and white point can be specified in the CIE xyY space
 * or in CIE XYZ. The length of the arrays depends on the chosen space:</p>
 *
 * <table summary="Parameters length">
 *     <tr><th>Space</th><th>Primaries length</th><th>White point length</th></tr>
 *     <tr><td>xyY</td><td>6</td><td>2</td></tr>
 *     <tr><td>XYZ</td><td>9</td><td>3</td></tr>
 * </table>
 *
 * <p>When the primaries and/or white point are specified in xyY, the Y component
 * does not need to be specified and is assumed to be 1.0. Only the xy components
 * are required.</p>
 *
 * @param name Name of the color space, cannot be null, its length must be >= 1
 * This value must never be {@code null}.
 * @param primaries RGB primaries as an array of 6 (xy) or 9 (XYZ) floats
 * This value must never be {@code null}.
 * @param whitePoint Reference white as an array of 2 (xy) or 3 (XYZ) floats
 * This value must never be {@code null}.
 * @param function Parameters for the transfer functions
 *
 * This value must never be {@code null}.
 * @throws IllegalArgumentException If any of the following conditions is met:
 * <ul>
 *     <li>The name is null or has a length of 0.</li>
 *     <li>The primaries array is null or has a length that is neither 6 or 9.</li>
 *     <li>The white point array is null or has a length that is neither 2 or 3.</li>
 *     <li>The transfer parameters are invalid.</li>
 * </ul>
 *
 * @see #get(Named)
 */

public Rgb(@androidx.annotation.RecentlyNonNull java.lang.String name, @androidx.annotation.RecentlyNonNull float[] primaries, @androidx.annotation.RecentlyNonNull float[] whitePoint, @androidx.annotation.RecentlyNonNull android.graphics.ColorSpace.Rgb.TransferParameters function) { super(null, null, 0); throw new RuntimeException("Stub!"); }

/**
 * <p>Creates a new RGB color space using a 3x3 column-major transform matrix.
 * The transform matrix must convert from the RGB space to the profile connection
 * space CIE XYZ.</p>
 *
 * <p class="note">The range of the color space is imposed to be \([0..1]\).</p>
 *
 * @param name Name of the color space, cannot be null, its length must be >= 1
 * This value must never be {@code null}.
 * @param toXYZ 3x3 column-major transform matrix from RGB to the profile
 *              connection space CIE XYZ as an array of 9 floats, cannot be null
 * This value must never be {@code null}.
 * @param gamma Gamma to use as the transfer function
 *
 * @throws IllegalArgumentException If any of the following conditions is met:
 * <ul>
 *     <li>The name is null or has a length of 0.</li>
 *     <li>Gamma is negative.</li>
 * </ul>
 *
 * @see #get(Named)
 */

public Rgb(@androidx.annotation.RecentlyNonNull java.lang.String name, @androidx.annotation.RecentlyNonNull float[] toXYZ, double gamma) { super(null, null, 0); throw new RuntimeException("Stub!"); }

/**
 * <p>Creates a new RGB color space using a specified set of primaries
 * and a specified white point.</p>
 *
 * <p>The primaries and white point can be specified in the CIE xyY space
 * or in CIE XYZ. The length of the arrays depends on the chosen space:</p>
 *
 * <table summary="Parameters length">
 *     <tr><th>Space</th><th>Primaries length</th><th>White point length</th></tr>
 *     <tr><td>xyY</td><td>6</td><td>2</td></tr>
 *     <tr><td>XYZ</td><td>9</td><td>3</td></tr>
 * </table>
 *
 * <p>When the primaries and/or white point are specified in xyY, the Y component
 * does not need to be specified and is assumed to be 1.0. Only the xy components
 * are required.</p>
 *
 * @param name Name of the color space, cannot be null, its length must be >= 1
 * This value must never be {@code null}.
 * @param primaries RGB primaries as an array of 6 (xy) or 9 (XYZ) floats
 * This value must never be {@code null}.
 * @param whitePoint Reference white as an array of 2 (xy) or 3 (XYZ) floats
 * This value must never be {@code null}.
 * @param gamma Gamma to use as the transfer function
 *
 * @throws IllegalArgumentException If any of the following conditions is met:
 * <ul>
 *     <li>The name is null or has a length of 0.</li>
 *     <li>The primaries array is null or has a length that is neither 6 or 9.</li>
 *     <li>The white point array is null or has a length that is neither 2 or 3.</li>
 *     <li>Gamma is negative.</li>
 * </ul>
 *
 * @see #get(Named)
 */

public Rgb(@androidx.annotation.RecentlyNonNull java.lang.String name, @androidx.annotation.RecentlyNonNull float[] primaries, @androidx.annotation.RecentlyNonNull float[] whitePoint, double gamma) { super(null, null, 0); throw new RuntimeException("Stub!"); }

/**
 * Copies the non-adapted CIE xyY white point of this color space in
 * specified array. The Y component is assumed to be 1 and is therefore
 * not copied into the destination. The x and y components are written
 * in the array at positions 0 and 1 respectively.
 *
 * @param whitePoint The destination array, cannot be null, its length
 *                   must be >= 2
 *
 * This value must never be {@code null}.
 * @return The destination array passed as a parameter
 *
 * @see #getWhitePoint(float[])
 */

@androidx.annotation.RecentlyNonNull public float[] getWhitePoint(@androidx.annotation.RecentlyNonNull float[] whitePoint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the non-adapted CIE xyY white point of this color space as
 * a new array of 2 floats. The Y component is assumed to be 1 and is
 * therefore not copied into the destination. The x and y components
 * are written in the array at positions 0 and 1 respectively.
 *
 * @return A new non-null array of 2 floats
 *
 * @see #getWhitePoint()
 */

@androidx.annotation.RecentlyNonNull public float[] getWhitePoint() { throw new RuntimeException("Stub!"); }

/**
 * Copies the primaries of this color space in specified array. The Y
 * component is assumed to be 1 and is therefore not copied into the
 * destination. The x and y components of the first primary are written
 * in the array at positions 0 and 1 respectively.
 *
 * @param primaries The destination array, cannot be null, its length
 *                  must be >= 6
 *
 * This value must never be {@code null}.
 * @return The destination array passed as a parameter
 *
 * @see #getPrimaries(float[])
 */

@androidx.annotation.RecentlyNonNull public float[] getPrimaries(@androidx.annotation.RecentlyNonNull float[] primaries) { throw new RuntimeException("Stub!"); }

/**
 * Returns the primaries of this color space as a new array of 6 floats.
 * The Y component is assumed to be 1 and is therefore not copied into
 * the destination. The x and y components of the first primary are
 * written in the array at positions 0 and 1 respectively.
 *
 * @return A new non-null array of 2 floats
 *
 * @see #getWhitePoint()
 */

@androidx.annotation.RecentlyNonNull public float[] getPrimaries() { throw new RuntimeException("Stub!"); }

/**
 * <p>Copies the transform of this color space in specified array. The
 * transform is used to convert from RGB to XYZ (with the same white
 * point as this color space). To connect color spaces, you must first
 * {@link ColorSpace#adapt(ColorSpace, float[]) adapt} them to the
 * same white point.</p>
 * <p>It is recommended to use {@link ColorSpace#connect(ColorSpace, ColorSpace)}
 * to convert between color spaces.</p>
 *
 * @param transform The destination array, cannot be null, its length
 *                  must be >= 9
 *
 * This value must never be {@code null}.
 * @return The destination array passed as a parameter
 *
 * @see #getInverseTransform()
 */

@androidx.annotation.RecentlyNonNull public float[] getTransform(@androidx.annotation.RecentlyNonNull float[] transform) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the transform of this color space as a new array. The
 * transform is used to convert from RGB to XYZ (with the same white
 * point as this color space). To connect color spaces, you must first
 * {@link ColorSpace#adapt(ColorSpace, float[]) adapt} them to the
 * same white point.</p>
 * <p>It is recommended to use {@link ColorSpace#connect(ColorSpace, ColorSpace)}
 * to convert between color spaces.</p>
 *
 * @return A new array of 9 floats
 *
 * This value will never be {@code null}.
 * @see #getInverseTransform(float[])
 */

@androidx.annotation.RecentlyNonNull public float[] getTransform() { throw new RuntimeException("Stub!"); }

/**
 * <p>Copies the inverse transform of this color space in specified array.
 * The inverse transform is used to convert from XYZ to RGB (with the
 * same white point as this color space). To connect color spaces, you
 * must first {@link ColorSpace#adapt(ColorSpace, float[]) adapt} them
 * to the same white point.</p>
 * <p>It is recommended to use {@link ColorSpace#connect(ColorSpace, ColorSpace)}
 * to convert between color spaces.</p>
 *
 * @param inverseTransform The destination array, cannot be null, its length
 *                  must be >= 9
 *
 * This value must never be {@code null}.
 * @return The destination array passed as a parameter
 *
 * @see #getTransform()
 */

@androidx.annotation.RecentlyNonNull public float[] getInverseTransform(@androidx.annotation.RecentlyNonNull float[] inverseTransform) { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the inverse transform of this color space as a new array.
 * The inverse transform is used to convert from XYZ to RGB (with the
 * same white point as this color space). To connect color spaces, you
 * must first {@link ColorSpace#adapt(ColorSpace, float[]) adapt} them
 * to the same white point.</p>
 * <p>It is recommended to use {@link ColorSpace#connect(ColorSpace, ColorSpace)}
 * to convert between color spaces.</p>
 *
 * @return A new array of 9 floats
 *
 * This value will never be {@code null}.
 * @see #getTransform(float[])
 */

@androidx.annotation.RecentlyNonNull public float[] getInverseTransform() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the opto-electronic transfer function (OETF) of this color space.
 * The inverse function is the electro-optical transfer function (EOTF) returned
 * by {@link #getEotf()}. These functions are defined to satisfy the following
 * equality for \(x \in [0..1]\):</p>
 *
 * $$OETF(EOTF(x)) = EOTF(OETF(x)) = x$$
 *
 * <p>For RGB colors, this function can be used to convert from linear space
 * to "gamma space" (gamma encoded). The terms gamma space and gamma encoded
 * are frequently used because many OETFs can be closely approximated using
 * a simple power function of the form \(x^{\frac{1}{\gamma}}\) (the
 * approximation of the {@link Named#SRGB sRGB} OETF uses \(\gamma=2.2\)
 * for instance).</p>
 *
 * @return A transfer function that converts from linear space to "gamma space"
 *
 * This value will never be {@code null}.
 * @see #getEotf()
 * @see #getTransferParameters()
 */

@androidx.annotation.RecentlyNonNull public java.util.function.DoubleUnaryOperator getOetf() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the electro-optical transfer function (EOTF) of this color space.
 * The inverse function is the opto-electronic transfer function (OETF)
 * returned by {@link #getOetf()}. These functions are defined to satisfy the
 * following equality for \(x \in [0..1]\):</p>
 *
 * $$OETF(EOTF(x)) = EOTF(OETF(x)) = x$$
 *
 * <p>For RGB colors, this function can be used to convert from "gamma space"
 * (gamma encoded) to linear space. The terms gamma space and gamma encoded
 * are frequently used because many EOTFs can be closely approximated using
 * a simple power function of the form \(x^\gamma\) (the approximation of the
 * {@link Named#SRGB sRGB} EOTF uses \(\gamma=2.2\) for instance).</p>
 *
 * @return A transfer function that converts from "gamma space" to linear space
 *
 * This value will never be {@code null}.
 * @see #getOetf()
 * @see #getTransferParameters()
 */

@androidx.annotation.RecentlyNonNull public java.util.function.DoubleUnaryOperator getEotf() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the parameters used by the {@link #getEotf() electro-optical}
 * and {@link #getOetf() opto-electronic} transfer functions. If the transfer
 * functions do not match the ICC parametric curves defined in ICC.1:2004-10
 * (section 10.15), this method returns null.</p>
 *
 * <p>See {@link TransferParameters} for a full description of the transfer
 * functions.</p>
 *
 * @return An instance of {@link TransferParameters} or null if this color
 *         space's transfer functions do not match the equation defined in
 *         {@link TransferParameters}
 */

@androidx.annotation.RecentlyNullable public android.graphics.ColorSpace.Rgb.TransferParameters getTransferParameters() { throw new RuntimeException("Stub!"); }

public boolean isSrgb() { throw new RuntimeException("Stub!"); }

public boolean isWideGamut() { throw new RuntimeException("Stub!"); }

public float getMinValue(int component) { throw new RuntimeException("Stub!"); }

public float getMaxValue(int component) { throw new RuntimeException("Stub!"); }

/**
 * <p>Decodes an RGB value to linear space. This is achieved by
 * applying this color space's electro-optical transfer function
 * to the supplied values.</p>
 *
 * <p>Refer to the documentation of {@link ColorSpace.Rgb} for
 * more information about transfer functions and their use for
 * encoding and decoding RGB values.</p>
 *
 * @param r The red component to decode to linear space
 * @param g The green component to decode to linear space
 * @param b The blue component to decode to linear space
 * @return A new array of 3 floats containing linear RGB values
 *
 * This value will never be {@code null}.
 * @see #toLinear(float[])
 * @see #fromLinear(float, float, float)
 */

@androidx.annotation.RecentlyNonNull public float[] toLinear(float r, float g, float b) { throw new RuntimeException("Stub!"); }

/**
 * <p>Decodes an RGB value to linear space. This is achieved by
 * applying this color space's electro-optical transfer function
 * to the first 3 values of the supplied array. The result is
 * stored back in the input array.</p>
 *
 * <p>Refer to the documentation of {@link ColorSpace.Rgb} for
 * more information about transfer functions and their use for
 * encoding and decoding RGB values.</p>
 *
 * @param v A non-null array of non-linear RGB values, its length
 *          must be at least 3
 * This value must never be {@code null}.
 * @return The specified array
 *
 * @see #toLinear(float, float, float)
 * @see #fromLinear(float[])
 */

@androidx.annotation.RecentlyNonNull public float[] toLinear(@androidx.annotation.RecentlyNonNull float[] v) { throw new RuntimeException("Stub!"); }

/**
 * <p>Encodes an RGB value from linear space to this color space's
 * "gamma space". This is achieved by applying this color space's
 * opto-electronic transfer function to the supplied values.</p>
 *
 * <p>Refer to the documentation of {@link ColorSpace.Rgb} for
 * more information about transfer functions and their use for
 * encoding and decoding RGB values.</p>
 *
 * @param r The red component to encode from linear space
 * @param g The green component to encode from linear space
 * @param b The blue component to encode from linear space
 * @return A new array of 3 floats containing non-linear RGB values
 *
 * This value will never be {@code null}.
 * @see #fromLinear(float[])
 * @see #toLinear(float, float, float)
 */

@androidx.annotation.RecentlyNonNull public float[] fromLinear(float r, float g, float b) { throw new RuntimeException("Stub!"); }

/**
 * <p>Encodes an RGB value from linear space to this color space's
 * "gamma space". This is achieved by applying this color space's
 * opto-electronic transfer function to the first 3 values of the
 * supplied array. The result is stored back in the input array.</p>
 *
 * <p>Refer to the documentation of {@link ColorSpace.Rgb} for
 * more information about transfer functions and their use for
 * encoding and decoding RGB values.</p>
 *
 * @param v A non-null array of linear RGB values, its length
 *          must be at least 3
 * This value must never be {@code null}.
 * @return A new array of 3 floats containing non-linear RGB values
 *
 * @see #fromLinear(float[])
 * @see #toLinear(float, float, float)
 */

@androidx.annotation.RecentlyNonNull public float[] fromLinear(@androidx.annotation.RecentlyNonNull float[] v) { throw new RuntimeException("Stub!"); }

/**
 * @param v This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public float[] toXyz(@androidx.annotation.RecentlyNonNull float[] v) { throw new RuntimeException("Stub!"); }

/**
 * @param v This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public float[] fromXyz(@androidx.annotation.RecentlyNonNull float[] v) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }
/**
 * {@usesMathJax}
 *
 * <p>Defines the parameters for the ICC parametric curve type 4, as
 * defined in ICC.1:2004-10, section 10.15.</p>
 *
 * <p>The EOTF is of the form:</p>
 *
 * \(\begin{equation}
 * Y = \begin{cases}c X + f & X \lt d \\
 * \left( a X + b \right) ^{g} + e & X \ge d \end{cases}
 * \end{equation}\)
 *
 * <p>The corresponding OETF is simply the inverse function.</p>
 *
 * <p>The parameters defined by this class form a valid transfer
 * function only if all the following conditions are met:</p>
 * <ul>
 *     <li>No parameter is a {@link Double#isNaN(double) Not-a-Number}</li>
 *     <li>\(d\) is in the range \([0..1]\)</li>
 *     <li>The function is not constant</li>
 *     <li>The function is positive and increasing</li>
 * </ul>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class TransferParameters {

/**
 * <p>Defines the parameters for the ICC parametric curve type 3, as
 * defined in ICC.1:2004-10, section 10.15.</p>
 *
 * <p>The EOTF is of the form:</p>
 *
 * \(\begin{equation}
 * Y = \begin{cases}c X & X \lt d \\
 * \left( a X + b \right) ^{g} & X \ge d \end{cases}
 * \end{equation}\)
 *
 * <p>This constructor is equivalent to setting  \(e\) and \(f\) to 0.</p>
 *
 * @param a The value of \(a\) in the equation of the EOTF described above
 * @param b The value of \(b\) in the equation of the EOTF described above
 * @param c The value of \(c\) in the equation of the EOTF described above
 * @param d The value of \(d\) in the equation of the EOTF described above
 * @param g The value of \(g\) in the equation of the EOTF described above
 *
 * @throws IllegalArgumentException If the parameters form an invalid transfer function
 */

public TransferParameters(double a, double b, double c, double d, double g) { throw new RuntimeException("Stub!"); }

/**
 * <p>Defines the parameters for the ICC parametric curve type 4, as
 * defined in ICC.1:2004-10, section 10.15.</p>
 *
 * @param a The value of \(a\) in the equation of the EOTF described above
 * @param b The value of \(b\) in the equation of the EOTF described above
 * @param c The value of \(c\) in the equation of the EOTF described above
 * @param d The value of \(d\) in the equation of the EOTF described above
 * @param e The value of \(e\) in the equation of the EOTF described above
 * @param f The value of \(f\) in the equation of the EOTF described above
 * @param g The value of \(g\) in the equation of the EOTF described above
 *
 * @throws IllegalArgumentException If the parameters form an invalid transfer function
 */

public TransferParameters(double a, double b, double c, double d, double e, double f, double g) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

/** Variable \(a\) in the equation of the EOTF described above. */

public final double a;
{ a = 0; }

/** Variable \(b\) in the equation of the EOTF described above. */

public final double b;
{ b = 0; }

/** Variable \(c\) in the equation of the EOTF described above. */

public final double c;
{ c = 0; }

/** Variable \(d\) in the equation of the EOTF described above. */

public final double d;
{ d = 0; }

/** Variable \(e\) in the equation of the EOTF described above. */

public final double e;
{ e = 0; }

/** Variable \(f\) in the equation of the EOTF described above. */

public final double f;
{ f = 0; }

/** Variable \(g\) in the equation of the EOTF described above. */

public final double g;
{ g = 0; }
}

}

}

