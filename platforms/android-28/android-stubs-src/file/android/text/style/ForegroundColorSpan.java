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

import android.text.TextPaint;

/**
 * Changes the color of the text to which the span is attached.
 * <p>
 * For example, to set a green text color you would create a {@link
 * android.text.SpannableString} based on the text and set the span.
 * <pre>{@code
 * SpannableString string = new SpannableString("Text with a foreground color span");
 *string.setSpan(new ForegroundColorSpan(color), 12, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/foregroundcolorspan.png" />
 * <figcaption>Set a text color.</figcaption>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ForegroundColorSpan extends android.text.style.CharacterStyle implements android.text.style.UpdateAppearance, android.text.ParcelableSpan {

/**
 * Creates a {@link ForegroundColorSpan} from a color integer.
 * <p>
 * To get the color integer associated with a particular color resource ID, use
 * {@link android.content.res.Resources#getColor(int, Resources.Theme)}
 *
 * @param color color integer that defines the text color
 */

public ForegroundColorSpan(int color) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link ForegroundColorSpan} from a parcel.

 * @param src This value must never be {@code null}.
 */

public ForegroundColorSpan(@androidx.annotation.RecentlyNonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @param dest This value must never be {@code null}.
 */

public void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @return the foreground color of this span.
 * @see ForegroundColorSpan#ForegroundColorSpan(int)
 */

public int getForegroundColor() { throw new RuntimeException("Stub!"); }

/**
 * Updates the color of the TextPaint to the foreground color.

 * @param textPaint This value must never be {@code null}.
 */

public void updateDrawState(@androidx.annotation.RecentlyNonNull android.text.TextPaint textPaint) { throw new RuntimeException("Stub!"); }
}

