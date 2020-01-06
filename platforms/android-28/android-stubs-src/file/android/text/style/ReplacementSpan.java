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

import android.graphics.Canvas;
import android.graphics.Paint;

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ReplacementSpan extends android.text.style.MetricAffectingSpan {

public ReplacementSpan() { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of the span. Extending classes can set the height of the span by updating
 * attributes of {@link android.graphics.Paint.FontMetricsInt}. If the span covers the whole
 * text, and the height is not set,
 * {@link #draw(Canvas, CharSequence, int, int, float, int, int, int, Paint)} will not be
 * called for the span.
 *
 * @param paint Paint instance.
 * This value must never be {@code null}.
 * @param text Current text.
 * @param start Start character index for span.
 * Value is 0 or greater
 * @param end End character index for span.
 * Value is 0 or greater
 * @param fm Font metrics, can be null.
 * This value may be {@code null}.
 * @return Width of the span.
 */

public abstract int getSize(@androidx.annotation.RecentlyNonNull android.graphics.Paint paint, java.lang.CharSequence text, int start, int end, @androidx.annotation.RecentlyNullable android.graphics.Paint.FontMetricsInt fm);

/**
 * Draws the span into the canvas.
 *
 * @param canvas Canvas into which the span should be rendered.
 * This value must never be {@code null}.
 * @param text Current text.
 * @param start Start character index for span.
 * Value is 0 or greater
 * @param end End character index for span.
 * Value is 0 or greater
 * @param x Edge of the replacement closest to the leading margin.
 * @param top Top of the line.
 * @param y Baseline.
 * @param bottom Bottom of the line.
 * @param paint Paint instance.

 * This value must never be {@code null}.
 */

public abstract void draw(@androidx.annotation.RecentlyNonNull android.graphics.Canvas canvas, java.lang.CharSequence text, int start, int end, float x, int top, int y, int bottom, @androidx.annotation.RecentlyNonNull android.graphics.Paint paint);

/**
 * This method does nothing, since ReplacementSpans are measured
 * explicitly instead of affecting Paint properties.
 */

public void updateMeasureState(android.text.TextPaint p) { throw new RuntimeException("Stub!"); }

/**
 * This method does nothing, since ReplacementSpans are drawn
 * explicitly instead of affecting Paint properties.
 */

public void updateDrawState(android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }
}

