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
 * A span which styles paragraphs by adding a vertical stripe at the beginning of the text
 * (respecting layout direction).
 * <p>
 * A <code>QuoteSpan</code> must be attached from the first character to the last character of a
 * single paragraph, otherwise the span will not be displayed.
 * <p>
 * <code>QuoteSpans</code> allow configuring the following elements:
 * <ul>
 * <li><b>color</b> - the vertical stripe color. By default, the stripe color is 0xff0000ff</li>
 * <li><b>gap width</b> - the distance, in pixels, between the stripe and the paragraph.
 * Default value is 2px.</li>
 * <li><b>stripe width</b> - the width, in pixels, of the stripe. Default value is
 * 2px.</li>
 * </ul>
 * For example, a <code>QuoteSpan</code> using the default values can be constructed like this:
 * <pre>{@code SpannableString string = new SpannableString("Text with quote span on a long line");
 *string.setSpan(new QuoteSpan(), 0, string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/defaultquotespan.png" />
 * <figcaption><code>QuoteSpan</code> constructed with default values.</figcaption>
 * <p>
 * <p>
 * To construct a <code>QuoteSpan</code> with a green stripe, of 20px in width and a gap width of
 * 40px:
 * <pre>{@code SpannableString string = new SpannableString("Text with quote span on a long line");
 *string.setSpan(new QuoteSpan(Color.GREEN, 20, 40), 0, string.length(),
 *Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/customquotespan.png" />
 * <figcaption>Customized <code>QuoteSpan</code>.</figcaption>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class QuoteSpan implements android.text.style.LeadingMarginSpan, android.text.ParcelableSpan {

/**
 * Creates a {@link QuoteSpan} with the default values.
 */

public QuoteSpan() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link QuoteSpan} based on a color.
 *
 * @param color the color of the quote stripe.
 */

public QuoteSpan(int color) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link QuoteSpan} based on a color, a stripe width and the width of the gap
 * between the stripe and the text.
 *
 * @param color       the color of the quote stripe.
 * @param stripeWidth the width of the stripe.
 * Value is 0 or greater
 * @param gapWidth    the width of the gap between the stripe and the text.

 * Value is 0 or greater
 */

public QuoteSpan(int color, int stripeWidth, int gapWidth) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link QuoteSpan} from a parcel.

 * @param src This value must never be {@code null}.
 */

public QuoteSpan(@androidx.annotation.RecentlyNonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Get the color of the quote stripe.
 *
 * @return the color of the quote stripe.
 */

public int getColor() { throw new RuntimeException("Stub!"); }

/**
 * Get the width of the quote stripe.
 *
 * @return the width of the quote stripe.
 */

public int getStripeWidth() { throw new RuntimeException("Stub!"); }

/**
 * Get the width of the gap between the stripe and the text.
 *
 * @return the width of the gap between the stripe and the text.
 */

public int getGapWidth() { throw new RuntimeException("Stub!"); }

public int getLeadingMargin(boolean first) { throw new RuntimeException("Stub!"); }

/**
 * @param c This value must never be {@code null}.

 * @param p This value must never be {@code null}.
 
 * @param text This value must never be {@code null}.

 * @param layout This value must never be {@code null}.
 */

public void drawLeadingMargin(@androidx.annotation.RecentlyNonNull android.graphics.Canvas c, @androidx.annotation.RecentlyNonNull android.graphics.Paint p, int x, int dir, int top, int baseline, int bottom, @androidx.annotation.RecentlyNonNull java.lang.CharSequence text, int start, int end, boolean first, @androidx.annotation.RecentlyNonNull android.text.Layout layout) { throw new RuntimeException("Stub!"); }

/**
 * Default color for the quote stripe.
 */

public static final int STANDARD_COLOR = -16776961; // 0xff0000ff

/**
 * Default gap width in pixels.
 */

public static final int STANDARD_GAP_WIDTH_PX = 2; // 0x2

/**
 * Default stripe width in pixels.
 */

public static final int STANDARD_STRIPE_WIDTH_PX = 2; // 0x2
}

