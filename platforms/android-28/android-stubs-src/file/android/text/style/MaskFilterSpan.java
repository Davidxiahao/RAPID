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


package android.text.style;

import android.graphics.MaskFilter;
import android.text.TextPaint;

/**
 * Span that allows setting a {@link MaskFilter} to the text it's attached to.
 * <p>
 * For example, to blur a text, a {@link android.graphics.BlurMaskFilter} can be used:
 * <pre>
 * MaskFilter blurMask = new BlurMaskFilter(5f, BlurMaskFilter.Blur.NORMAL);
 * SpannableString string = new SpannableString("Text with blur mask");
 * string.setSpan(new MaskFilterSpan(blurMask), 10, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
 * </pre>
 * <img src="{@docRoot}reference/android/images/text/style/maskfilterspan.png" />
 * <figcaption>Text blurred with the <code>MaskFilterSpan</code>.</figcaption>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MaskFilterSpan extends android.text.style.CharacterStyle implements android.text.style.UpdateAppearance {

/**
 * Creates a {@link MaskFilterSpan} from a {@link MaskFilter}.
 *
 * @param filter the filter to be applied to the <code>TextPaint</code>
 */

public MaskFilterSpan(android.graphics.MaskFilter filter) { throw new RuntimeException("Stub!"); }

/**
 * Return the mask filter for this span.
 *
 * @return the mask filter for this span
 */

public android.graphics.MaskFilter getMaskFilter() { throw new RuntimeException("Stub!"); }

public void updateDrawState(android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }
}

