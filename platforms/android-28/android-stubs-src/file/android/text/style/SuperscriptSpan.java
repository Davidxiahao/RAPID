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


/**
 * The span that moves the position of the text baseline higher.
 * <p>
 * The span can be used like this:
 * <pre>{@code
 *  SpannableString string = new SpannableString("1st example");
 *string.setSpan(new SuperscriptSpan(), 1, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/superscriptspan.png" />
 * <figcaption>Text with <code>SuperscriptSpan</code>.</figcaption>
 * Note: Since the span affects the position of the text, if the text is on the first line of a
 * TextView, it may appear cut. This can be avoided by decreasing the text size with an {@link
 * AbsoluteSizeSpan}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SuperscriptSpan extends android.text.style.MetricAffectingSpan implements android.text.ParcelableSpan {

/**
 * Creates a {@link SuperscriptSpan}.
 */

public SuperscriptSpan() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link SuperscriptSpan} from a parcel.

 * @param src This value must never be {@code null}.
 */

public SuperscriptSpan(@androidx.annotation.RecentlyNonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @param dest This value must never be {@code null}.
 */

public void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @param textPaint This value must never be {@code null}.
 */

public void updateDrawState(@androidx.annotation.RecentlyNonNull android.text.TextPaint textPaint) { throw new RuntimeException("Stub!"); }

/**
 * @param textPaint This value must never be {@code null}.
 */

public void updateMeasureState(@androidx.annotation.RecentlyNonNull android.text.TextPaint textPaint) { throw new RuntimeException("Stub!"); }
}

