/*
 * Copyright (C) 2008 The Android Open Source Project
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
 * Sampler object that defines how Allocations can be read as textures within a
 * kernel. Samplers are used in conjunction with the {@code rsSample} runtime
 * function to return values from normalized coordinates.
 *
 * Any Allocation used with a Sampler must have been created with {@link
 * android.renderscript.Allocation#USAGE_GRAPHICS_TEXTURE}; using a Sampler on
 * an {@link android.renderscript.Allocation} that was not created with {@link
 * android.renderscript.Allocation#USAGE_GRAPHICS_TEXTURE} is undefined.
 **/

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Sampler extends android.renderscript.BaseObj {

Sampler(long id, android.renderscript.RenderScript rs) { super(0, null); throw new RuntimeException("Stub!"); }

/**
 * @return minification setting for the sampler
 */

public android.renderscript.Sampler.Value getMinification() { throw new RuntimeException("Stub!"); }

/**
 * @return magnification setting for the sampler
 */

public android.renderscript.Sampler.Value getMagnification() { throw new RuntimeException("Stub!"); }

/**
 * @return S wrapping mode for the sampler
 */

public android.renderscript.Sampler.Value getWrapS() { throw new RuntimeException("Stub!"); }

/**
 * @return T wrapping mode for the sampler
 */

public android.renderscript.Sampler.Value getWrapT() { throw new RuntimeException("Stub!"); }

/**
 * @return anisotropy setting for the sampler
 */

public float getAnisotropy() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a sampler with min and mag set to nearest and wrap modes set to
 * clamp.
 *
 * @param rs Context to which the sampler will belong.
 *
 * @return Sampler
 */

public static android.renderscript.Sampler CLAMP_NEAREST(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a sampler with min and mag set to linear and wrap modes set to
 * clamp.
 *
 * @param rs Context to which the sampler will belong.
 *
 * @return Sampler
 */

public static android.renderscript.Sampler CLAMP_LINEAR(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a sampler with mag set to linear, min linear mipmap linear, and
 * wrap modes set to clamp.
 *
 * @param rs Context to which the sampler will belong.
 *
 * @return Sampler
 */

public static android.renderscript.Sampler CLAMP_LINEAR_MIP_LINEAR(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a sampler with min and mag set to nearest and wrap modes set to
 * wrap.
 *
 * @param rs Context to which the sampler will belong.
 *
 * @return Sampler
 */

public static android.renderscript.Sampler WRAP_NEAREST(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a sampler with min and mag set to linear and wrap modes set to
 * wrap.
 *
 * @param rs Context to which the sampler will belong.
 *
 * @return Sampler
 */

public static android.renderscript.Sampler WRAP_LINEAR(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a sampler with mag set to linear, min linear mipmap linear, and
 * wrap modes set to wrap.
 *
 * @param rs Context to which the sampler will belong.
 *
 * @return Sampler
 */

public static android.renderscript.Sampler WRAP_LINEAR_MIP_LINEAR(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a sampler with min and mag set to nearest and wrap modes set to
 * mirrored repeat.
 *
 * @param rs Context to which the sampler will belong.
 *
 * @return Sampler
 */

public static android.renderscript.Sampler MIRRORED_REPEAT_NEAREST(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a sampler with min and mag set to linear and wrap modes set to
 * mirrored repeat.
 *
 * @param rs Context to which the sampler will belong.
 *
 * @return Sampler
 */

public static android.renderscript.Sampler MIRRORED_REPEAT_LINEAR(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a sampler with min and mag set to linear and wrap modes set to
 * mirrored repeat.
 *
 * @param rs Context to which the sampler will belong.
 *
 * @return Sampler
 */

public static android.renderscript.Sampler MIRRORED_REPEAT_LINEAR_MIP_LINEAR(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }
/**
 * Builder for creating non-standard samplers.  This is only necessary if
 * a Sampler with different min and mag modes is desired.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

public Builder(android.renderscript.RenderScript rs) { throw new RuntimeException("Stub!"); }

public void setMinification(android.renderscript.Sampler.Value v) { throw new RuntimeException("Stub!"); }

public void setMagnification(android.renderscript.Sampler.Value v) { throw new RuntimeException("Stub!"); }

public void setWrapS(android.renderscript.Sampler.Value v) { throw new RuntimeException("Stub!"); }

public void setWrapT(android.renderscript.Sampler.Value v) { throw new RuntimeException("Stub!"); }

public void setAnisotropy(float v) { throw new RuntimeException("Stub!"); }

public android.renderscript.Sampler create() { throw new RuntimeException("Stub!"); }
}

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Value {
NEAREST, LINEAR, LINEAR_MIP_LINEAR, LINEAR_MIP_NEAREST, WRAP, CLAMP, MIRRORED_REPEAT;
}

}

