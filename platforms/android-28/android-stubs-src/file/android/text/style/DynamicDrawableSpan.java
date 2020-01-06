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

import android.graphics.drawable.Drawable;

/**
 * Span that replaces the text it's attached to with a {@link Drawable} that can be aligned with
 * the bottom or with the baseline of the surrounding text.
 * <p>
 * For an implementation that constructs the drawable from various sources (<code>Bitmap</code>,
 * <code>Drawable</code>, resource id or <code>Uri</code>) use {@link ImageSpan}.
 * <p>
 * A simple implementation of <code>DynamicDrawableSpan</code> that uses drawables from resources
 * looks like this:
 * <pre>
 * class MyDynamicDrawableSpan extends DynamicDrawableSpan {
 *
 * private final Context mContext;
 * private final int mResourceId;
 *
 * public MyDynamicDrawableSpan(Context context, @DrawableRes int resourceId) {
 *     mContext = context;
 *     mResourceId = resourceId;
 * }
 *
 * {@literal @}Override
 * public Drawable getDrawable() {
 *      Drawable drawable = mContext.getDrawable(mResourceId);
 *      drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
 *      return drawable;
 * }
 * }</pre>
 * The class can be used like this:
 * <pre>
 * SpannableString string = new SpannableString("Text with a drawable span");
 * string.setSpan(new MyDynamicDrawableSpan(context, R.mipmap.ic_launcher), 12, 20, Spanned
 * .SPAN_EXCLUSIVE_EXCLUSIVE);</pre>
 * <img src="{@docRoot}reference/android/images/text/style/dynamicdrawablespan.png" />
 * <figcaption>Replacing text with a drawable.</figcaption>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class DynamicDrawableSpan extends android.text.style.ReplacementSpan {

/**
 * Creates a {@link DynamicDrawableSpan}. The default vertical alignment is
 * {@link #ALIGN_BOTTOM}
 */

public DynamicDrawableSpan() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link DynamicDrawableSpan} based on a vertical alignment.\
 *
 * @param verticalAlignment one of {@link #ALIGN_BOTTOM} or {@link #ALIGN_BASELINE}
 */

protected DynamicDrawableSpan(int verticalAlignment) { throw new RuntimeException("Stub!"); }

/**
 * Returns the vertical alignment of this span, one of {@link #ALIGN_BOTTOM} or
 * {@link #ALIGN_BASELINE}.
 */

public int getVerticalAlignment() { throw new RuntimeException("Stub!"); }

/**
 * Your subclass must implement this method to provide the bitmap
 * to be drawn.  The dimensions of the bitmap must be the same
 * from each call to the next.
 */

public abstract android.graphics.drawable.Drawable getDrawable();

/**
 * @param paint This value must never be {@code null}.

 * @param start Value is 0 or greater
 
 * @param end Value is 0 or greater

 * @param fm This value may be {@code null}.
 */

public int getSize(@androidx.annotation.RecentlyNonNull android.graphics.Paint paint, java.lang.CharSequence text, int start, int end, @androidx.annotation.RecentlyNullable android.graphics.Paint.FontMetricsInt fm) { throw new RuntimeException("Stub!"); }

/**
 * @param canvas This value must never be {@code null}.

 * @param start Value is 0 or greater
 
 * @param end Value is 0 or greater

 * @param paint This value must never be {@code null}.
 */

public void draw(@androidx.annotation.RecentlyNonNull android.graphics.Canvas canvas, java.lang.CharSequence text, int start, int end, float x, int top, int y, int bottom, @androidx.annotation.RecentlyNonNull android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * A constant indicating that the bottom of this span should be aligned
 * with the baseline of the surrounding text.
 */

public static final int ALIGN_BASELINE = 1; // 0x1

/**
 * A constant indicating that the bottom of this span should be aligned
 * with the bottom of the surrounding text, i.e., at the same level as the
 * lowest descender in the text.
 */

public static final int ALIGN_BOTTOM = 0; // 0x0

protected final int mVerticalAlignment;
{ mVerticalAlignment = 0; }
}

