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


package android.renderscript;


/**
 * Intrinsic for performing a resize of a 2D allocation.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ScriptIntrinsicResize extends android.renderscript.ScriptIntrinsic {

ScriptIntrinsicResize(long id, android.renderscript.RenderScript rs) { super(0, null); throw new RuntimeException("Stub!"); }

/**
 * Supported elements types are {@link Element#U8}, {@link
 * Element#U8_2}, {@link Element#U8_3}, {@link Element#U8_4}
 * {@link Element#F32}, {@link Element#F32_2}, {@link
 * Element#F32_3}, {@link Element#F32_4}
 *
 * @param rs The RenderScript context
 *
 * @return ScriptIntrinsicResize
 */

public static android.renderscript.ScriptIntrinsicResize create(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Set the input of the resize.
 * Must match the element type supplied during create.
 *
 * @param ain The input allocation.
 */

public void setInput(android.renderscript.Allocation ain) { throw new RuntimeException("Stub!"); }

/**
 * Get a FieldID for the input field of this intrinsic.
 *
 * @return Script.FieldID The FieldID object.
 */

public android.renderscript.Script.FieldID getFieldID_Input() { throw new RuntimeException("Stub!"); }

/**
 * Resize copy the input allocation to the output specified. The
 * Allocation is rescaled if necessary using bi-cubic
 * interpolation.
 *
 * @param aout Output allocation. Element type must match
 *             current input.  Must not be same as input.
 */

public void forEach_bicubic(android.renderscript.Allocation aout) { throw new RuntimeException("Stub!"); }

/**
 * Resize copy the input allocation to the output specified. The
 * Allocation is rescaled if necessary using bi-cubic
 * interpolation.
 *
 * @param aout Output allocation. Element type must match
 *             current input.
 * @param opt LaunchOptions for clipping
 */

public void forEach_bicubic(android.renderscript.Allocation aout, android.renderscript.Script.LaunchOptions opt) { throw new RuntimeException("Stub!"); }

/**
 * Get a KernelID for this intrinsic kernel.
 *
 * @return Script.KernelID The KernelID object.
 */

public android.renderscript.Script.KernelID getKernelID_bicubic() { throw new RuntimeException("Stub!"); }
}

