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


@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EmbossMaskFilter extends android.graphics.MaskFilter {

/**
 * Create an emboss maskfilter
 *
 * @deprecated This subclass is not supported and should not be instantiated.
 *
 * @param direction  array of 3 scalars [x, y, z] specifying the direction of the light source
 * @param ambient    0...1 amount of ambient light
 * @param specular   coefficient for specular highlights (e.g. 8)
 * @param blurRadius amount to blur before applying lighting (e.g. 3)
 * @return           the emboss maskfilter
 */

@Deprecated public EmbossMaskFilter(float[] direction, float ambient, float specular, float blurRadius) { throw new RuntimeException("Stub!"); }
}

