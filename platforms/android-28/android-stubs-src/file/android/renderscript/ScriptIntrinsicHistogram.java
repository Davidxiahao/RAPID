/*
 * Copyright (C) 2013 The Android Open Source Project
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
 * Intrinsic Histogram filter.
 *
 *
 **/

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScriptIntrinsicHistogram extends android.renderscript.ScriptIntrinsic {

ScriptIntrinsicHistogram(long id, android.renderscript.RenderScript rs) { super(0, null); throw new RuntimeException("Stub!"); }

/**
 * Create an intrinsic for calculating the histogram of an uchar
 * or uchar4 image.
 *
 * Supported elements types are
 * {@link Element#U8_4}, {@link Element#U8_3},
 * {@link Element#U8_2}, {@link Element#U8}
 *
 * @param rs The RenderScript context
 * @param e Element type for inputs
 *
 * @return ScriptIntrinsicHistogram
 */

public static android.renderscript.ScriptIntrinsicHistogram create(android.renderscript.RenderScript rs, android.renderscript.Element e) { throw new RuntimeException("Stub!"); }

/**
 * Process an input buffer and place the histogram into the
 * output allocation. The output allocation may be a narrower
 * vector size than the input. In this case the vector size of
 * the output is used to determine how many of the input
 * channels are used in the computation. This is useful if you
 * have an RGBA input buffer but only want the histogram for
 * RGB.
 *
 * 1D and 2D input allocations are supported.
 *
 * @param ain The input image
 */

public void forEach(android.renderscript.Allocation ain) { throw new RuntimeException("Stub!"); }

/**
 * Process an input buffer and place the histogram into the
 * output allocation. The output allocation may be a narrower
 * vector size than the input. In this case the vector size of
 * the output is used to determine how many of the input
 * channels are used in the computation. This is useful if you
 * have an RGBA input buffer but only want the histogram for
 * RGB.
 *
 * 1D and 2D input allocations are supported.
 *
 * @param ain The input image
 * @param opt LaunchOptions for clipping
 */

public void forEach(android.renderscript.Allocation ain, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Set the coefficients used for the RGBA to Luminocity
 * calculation. The default is {0.299f, 0.587f, 0.114f, 0.f}.
 *
 * Coefficients must be >= 0 and sum to 1.0 or less.
 *
 * @param r Red coefficient
 * @param g Green coefficient
 * @param b Blue coefficient
 * @param a Alpha coefficient
 */

public void setDotCoefficients(float r, float g, float b, float a) { throw new RuntimeException("Stub!"); }

/**
 * Set the output of the histogram.  32 bit integer types are
 * supported.
 *
 * @param aout The output allocation
 */

public void setOutput(android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Process an input buffer and place the histogram into the
 * output allocation. The dot product of the input channel and
 * the coefficients from 'setDotCoefficients' are used to
 * calculate the output values.
 *
 * 1D and 2D input allocations are supported.
 *
 * @param ain The input image
 */

public void forEach_Dot(android.renderscript.Allocation ain) { throw new RuntimeException("Stub!"); }

/**
 * Process an input buffer and place the histogram into the
 * output allocation. The dot product of the input channel and
 * the coefficients from 'setDotCoefficients' are used to
 * calculate the output values.
 *
 * 1D and 2D input allocations are supported.
 *
 * @param ain The input image
 * @param opt LaunchOptions for clipping
 */

public void forEach_Dot(android.renderscript.Allocation ain, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for this intrinsic kernel.
 *
 * @return Script.KernelID The KernelID object.
 */

public android.renderscript.Script.KernelID getKernelID_Separate() { throw new RuntimeException("Stub!"); }

/**
 * Get a FieldID for the input field of this intrinsic.
 *
 * @return Script.FieldID The FieldID object.
 */

public android.renderscript.Script.FieldID getFieldID_Input() { throw new RuntimeException("Stub!"); }
}

