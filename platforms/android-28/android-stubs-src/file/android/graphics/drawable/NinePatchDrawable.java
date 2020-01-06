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


package android.graphics.drawable;

import android.graphics.NinePatch;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.graphics.PorterDuff.Mode;

/**
 *
 * A resizeable bitmap, with stretchable areas that you define. This type of image
 * is defined in a .png file with a special format.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about how to use a NinePatchDrawable, read the
 * <a href="{@docRoot}guide/topics/graphics/2d-graphics.html#nine-patch">
 * Canvas and Drawables</a> developer guide. For information about creating a NinePatch image
 * file using the draw9patch tool, see the
 * <a href="{@docRoot}guide/developing/tools/draw9patch.html">Draw 9-patch</a> tool guide.</p></div>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NinePatchDrawable extends android.graphics.drawable.Drawable {

/**
 * Create drawable from raw nine-patch data, not dealing with density.
 *
 * @deprecated Use {@link #NinePatchDrawable(Resources, Bitmap, byte[], Rect, String)}
 *             to ensure that the drawable has correctly set its target density.
 */

@Deprecated public NinePatchDrawable(android.graphics.Bitmap bitmap, byte[] chunk, android.graphics.Rect padding, java.lang.String srcName) { throw new RuntimeException("Stub!"); }

/**
 * Create drawable from raw nine-patch data, setting initial target density
 * based on the display metrics of the resources.
 */

public NinePatchDrawable(android.content.res.Resources res, android.graphics.Bitmap bitmap, byte[] chunk, android.graphics.Rect padding, java.lang.String srcName) { throw new RuntimeException("Stub!"); }

/**
 * Create drawable from existing nine-patch, not dealing with density.
 *
 * @deprecated Use {@link #NinePatchDrawable(Resources, NinePatch)}
 *             to ensure that the drawable has correctly set its target
 *             density.

 * @param patch This value must never be {@code null}.
 */

@Deprecated public NinePatchDrawable(@androidx.annotation.RecentlyNonNull android.graphics.NinePatch patch) { throw new RuntimeException("Stub!"); }

/**
 * Create drawable from existing nine-patch, setting initial target density
 * based on the display metrics of the resources.
 
 * @param res This value may be {@code null}.

 * @param patch This value must never be {@code null}.
 */

public NinePatchDrawable(@androidx.annotation.RecentlyNullable android.content.res.Resources res, @androidx.annotation.RecentlyNonNull android.graphics.NinePatch patch) { throw new RuntimeException("Stub!"); }

/**
 * Set the density scale at which this drawable will be rendered. This
 * method assumes the drawable will be rendered at the same density as the
 * specified canvas.
 *
 * @param canvas The Canvas from which the density scale must be obtained.
 *
 * This value must never be {@code null}.
 * @see android.graphics.Bitmap#setDensity(int)
 * @see android.graphics.Bitmap#getDensity()
 */

public void setTargetDensity(@androidx.annotation.RecentlyNonNull android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Set the density scale at which this drawable will be rendered.
 *
 * @param metrics The DisplayMetrics indicating the density scale for this drawable.
 *
 * This value must never be {@code null}.
 * @see android.graphics.Bitmap#setDensity(int)
 * @see android.graphics.Bitmap#getDensity()
 */

public void setTargetDensity(@androidx.annotation.RecentlyNonNull android.util.DisplayMetrics metrics) { throw new RuntimeException("Stub!"); }

/**
 * Set the density at which this drawable will be rendered.
 *
 * @param density The density scale for this drawable.
 *
 * @see android.graphics.Bitmap#setDensity(int)
 * @see android.graphics.Bitmap#getDensity()
 */

public void setTargetDensity(int density) { throw new RuntimeException("Stub!"); }

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * @param padding This value must never be {@code null}.
 */

public boolean getPadding(@androidx.annotation.RecentlyNonNull android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

/**
 * @param outline This value must never be {@code null}.
 */

public void getOutline(@androidx.annotation.RecentlyNonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

public int getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * @param colorFilter This value may be {@code null}.
 */

public void setColorFilter(@androidx.annotation.RecentlyNullable android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

/**
 * @param tint This value may be {@code null}.
 */

public void setTintList(@androidx.annotation.RecentlyNullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * @param tintMode This value may be {@code null}.
 */

public void setTintMode(@androidx.annotation.RecentlyNullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

public void setDither(boolean dither) { throw new RuntimeException("Stub!"); }

public void setAutoMirrored(boolean mirrored) { throw new RuntimeException("Stub!"); }

public boolean isAutoMirrored() { throw new RuntimeException("Stub!"); }

public void setFilterBitmap(boolean filter) { throw new RuntimeException("Stub!"); }

public boolean isFilterBitmap() { throw new RuntimeException("Stub!"); }

public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs, android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * @param t This value must never be {@code null}.
 */

public void applyTheme(@androidx.annotation.RecentlyNonNull android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/**
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.graphics.Paint getPaint() { throw new RuntimeException("Stub!"); }

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

public int getOpacity() { throw new RuntimeException("Stub!"); }

public android.graphics.Region getTransparentRegion() { throw new RuntimeException("Stub!"); }

public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

protected boolean onStateChange(int[] stateSet) { throw new RuntimeException("Stub!"); }

public boolean isStateful() { throw new RuntimeException("Stub!"); }
}

