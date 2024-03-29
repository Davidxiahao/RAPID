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
 * Changes the background color of the text to which the span is attached.
 * <p>
 * For example, to set a green background color for a text you would create a {@link
 * android.text.SpannableString} based on the text and set the span.
 * <pre>{@code
 * SpannableString string = new SpannableString("Text with a background color span");
 *string.setSpan(new BackgroundColorSpan(color), 12, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/backgroundcolorspan.png" />
 * <figcaption>Set a background color for the text.</figcaption>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BackgroundColorSpan extends android.text.style.CharacterStyle implements android.text.style.UpdateAppearance, android.text.ParcelableSpan {

/**
 * Creates a {@link BackgroundColorSpan} from a color integer.
 * <p>
 *
 * @param color color integer that defines the background color
 * @see android.content.res.Resources#getColor(int, Resources.Theme)
 */

public BackgroundColorSpan(int color) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link BackgroundColorSpan} from a parcel.

 * @param src This value must never be {@code null}.
 */

public BackgroundColorSpan(@androidx.annotation.RecentlyNonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @param dest This value must never be {@code null}.
 */

public void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @return the background color of this span.
 * @see BackgroundColorSpan#BackgroundColorSpan(int)
 */

public int getBackgroundColor() { throw new RuntimeException("Stub!"); }

/**
 * Updates the background color of the TextPaint.

 * @param textPaint This value must never be {@code null}.
 */

public void updateDrawState(@androidx.annotation.RecentlyNonNull android.text.TextPaint textPaint) { throw new RuntimeException("Stub!"); }
}

