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

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

/**
 * Span that replaces the text it's attached to with a {@link Drawable} that can be aligned with
 * the bottom or with the baseline of the surrounding text. The drawable can be constructed from
 * varied sources:
 * <ul>
 * <li>{@link Bitmap} - see {@link #ImageSpan(Context, Bitmap)} and
 * {@link #ImageSpan(Context, Bitmap, int)}
 * </li>
 * <li>{@link Drawable} - see {@link #ImageSpan(Drawable, int)}</li>
 * <li>resource id - see {@link #ImageSpan(Context, int, int)}</li>
 * <li>{@link Uri} - see {@link #ImageSpan(Context, Uri, int)}</li>
 * </ul>
 * The default value for the vertical alignment is {@link DynamicDrawableSpan#ALIGN_BOTTOM}
 * <p>
 * For example, an <code>ImagedSpan</code> can be used like this:
 * <pre>
 * SpannableString string = SpannableString("Bottom: span.\nBaseline: span.");
 * // using the default alignment: ALIGN_BOTTOM
 * string.setSpan(ImageSpan(this, R.mipmap.ic_launcher), 7, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
 * string.setSpan(ImageSpan(this, R.mipmap.ic_launcher, DynamicDrawableSpan.ALIGN_BASELINE),
 * 22, 23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
 * </pre>
 * <img src="{@docRoot}reference/android/images/text/style/imagespan.png" />
 * <figcaption>Text with <code>ImageSpan</code>s aligned bottom and baseline.</figcaption>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ImageSpan extends android.text.style.DynamicDrawableSpan {

/**
 * @deprecated Use {@link #ImageSpan(Context, Bitmap)} instead.

 * @param b This value must never be {@code null}.
 */

@Deprecated public ImageSpan(@androidx.annotation.RecentlyNonNull android.graphics.Bitmap b) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #ImageSpan(Context, Bitmap, int)} instead.

 * @param b This value must never be {@code null}.
 */

@Deprecated public ImageSpan(@androidx.annotation.RecentlyNonNull android.graphics.Bitmap b, int verticalAlignment) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an {@link ImageSpan} from a {@link Context} and a {@link Bitmap} with the default
 * alignment {@link DynamicDrawableSpan#ALIGN_BOTTOM}
 *
 * @param context context used to create a drawable from {@param bitmap} based on the display
 *                metrics of the resources
 * This value must never be {@code null}.
 * @param bitmap  bitmap to be rendered

 * This value must never be {@code null}.
 */

public ImageSpan(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an {@link ImageSpan} from a {@link Context}, a {@link Bitmap} and a vertical
 * alignment.
 *
 * @param context           context used to create a drawable from {@param bitmap} based on
 *                          the display metrics of the resources
 * This value must never be {@code null}.
 * @param bitmap            bitmap to be rendered
 * This value must never be {@code null}.
 * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
 *                          {@link DynamicDrawableSpan#ALIGN_BASELINE}
 */

public ImageSpan(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.graphics.Bitmap bitmap, int verticalAlignment) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an {@link ImageSpan} from a drawable with the default
 * alignment {@link DynamicDrawableSpan#ALIGN_BOTTOM}.
 *
 * @param drawable drawable to be rendered

 * This value must never be {@code null}.
 */

public ImageSpan(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an {@link ImageSpan} from a drawable and a vertical alignment.
 *
 * @param drawable          drawable to be rendered
 * This value must never be {@code null}.
 * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
 *                          {@link DynamicDrawableSpan#ALIGN_BASELINE}
 */

public ImageSpan(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable drawable, int verticalAlignment) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an {@link ImageSpan} from a drawable and a source with the default
 * alignment {@link DynamicDrawableSpan#ALIGN_BOTTOM}
 *
 * @param drawable drawable to be rendered
 * This value must never be {@code null}.
 * @param source   drawable's Uri source

 * This value must never be {@code null}.
 */

public ImageSpan(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.RecentlyNonNull java.lang.String source) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an {@link ImageSpan} from a drawable, a source and a vertical alignment.
 *
 * @param drawable          drawable to be rendered
 * This value must never be {@code null}.
 * @param source            drawable's uri source
 * This value must never be {@code null}.
 * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
 *                          {@link DynamicDrawableSpan#ALIGN_BASELINE}
 */

public ImageSpan(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable drawable, @androidx.annotation.RecentlyNonNull java.lang.String source, int verticalAlignment) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an {@link ImageSpan} from a {@link Context} and a {@link Uri} with the default
 * alignment {@link DynamicDrawableSpan#ALIGN_BOTTOM}. The Uri source can be retrieved via
 * {@link #getSource()}
 *
 * @param context context used to create a drawable from {@param bitmap} based on the display
 *                metrics of the resources
 * This value must never be {@code null}.
 * @param uri     {@link Uri} used to construct the drawable that will be rendered

 * This value must never be {@code null}.
 */

public ImageSpan(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an {@link ImageSpan} from a {@link Context}, a {@link Uri} and a vertical
 * alignment. The Uri source can be retrieved via {@link #getSource()}
 *
 * @param context           context used to create a drawable from {@param bitmap} based on
 *                          the display
 *                          metrics of the resources
 * This value must never be {@code null}.
 * @param uri               {@link Uri} used to construct the drawable that will be rendered.
 * This value must never be {@code null}.
 * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
 *                          {@link DynamicDrawableSpan#ALIGN_BASELINE}
 */

public ImageSpan(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.net.Uri uri, int verticalAlignment) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an {@link ImageSpan} from a {@link Context} and a resource id with the default
 * alignment {@link DynamicDrawableSpan#ALIGN_BOTTOM}
 *
 * @param context    context used to retrieve the drawable from resources
 * This value must never be {@code null}.
 * @param resourceId drawable resource id based on which the drawable is retrieved
 */

public ImageSpan(@androidx.annotation.RecentlyNonNull android.content.Context context, int resourceId) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an {@link ImageSpan} from a {@link Context}, a resource id and a vertical
 * alignment.
 *
 * @param context           context used to retrieve the drawable from resources
 * This value must never be {@code null}.
 * @param resourceId        drawable resource id based on which the drawable is retrieved.
 * @param verticalAlignment one of {@link DynamicDrawableSpan#ALIGN_BOTTOM} or
 *                          {@link DynamicDrawableSpan#ALIGN_BASELINE}
 */

public ImageSpan(@androidx.annotation.RecentlyNonNull android.content.Context context, int resourceId, int verticalAlignment) { throw new RuntimeException("Stub!"); }

public android.graphics.drawable.Drawable getDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Returns the source string that was saved during construction.
 *
 * @return the source string that was saved during construction
 * This value may be {@code null}.
 * @see #ImageSpan(Drawable, String) and this{@link #ImageSpan(Context, Uri)}
 */

@androidx.annotation.RecentlyNullable public java.lang.String getSource() { throw new RuntimeException("Stub!"); }
}

