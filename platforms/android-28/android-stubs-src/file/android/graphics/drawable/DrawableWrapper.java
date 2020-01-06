/*
 * Copyright (C) 2015 The Android Open Source Project
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

import android.graphics.Rect;
import android.view.View;
import android.content.res.Resources.Theme;
import android.content.res.Resources;

/**
 * Drawable container with only one child element.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class DrawableWrapper extends android.graphics.drawable.Drawable implements android.graphics.drawable.Drawable.Callback {

/**
 * Creates a new wrapper around the specified drawable.
 *
 * @param dr the drawable to wrap

 * This value may be {@code null}.
 */

public DrawableWrapper(@androidx.annotation.RecentlyNullable android.graphics.drawable.Drawable dr) { throw new RuntimeException("Stub!"); }

/**
 * Sets the wrapped drawable.
 *
 * @param dr the wrapped drawable

 * This value may be {@code null}.
 */

public void setDrawable(@androidx.annotation.RecentlyNullable android.graphics.drawable.Drawable dr) { throw new RuntimeException("Stub!"); }

/**
 * @return the wrapped drawable

 * This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.graphics.drawable.Drawable getDrawable() { throw new RuntimeException("Stub!"); }

/**
 * @param r This value must never be {@code null}.

 * @param parser This value must never be {@code null}.
 
 * @param attrs This value must never be {@code null}.

 * @param theme This value may be {@code null}.
 */

public void inflate(@androidx.annotation.RecentlyNonNull android.content.res.Resources r, @androidx.annotation.RecentlyNonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.RecentlyNonNull android.util.AttributeSet attrs, @androidx.annotation.RecentlyNullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * @param t This value must never be {@code null}.
 */

public void applyTheme(@androidx.annotation.RecentlyNonNull android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

/**
 * @param who This value must never be {@code null}.
 */

public void invalidateDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

/**
 * @param who This value must never be {@code null}.

 * @param what This value must never be {@code null}.
 */

public void scheduleDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable who, @androidx.annotation.RecentlyNonNull java.lang.Runnable what, long when) { throw new RuntimeException("Stub!"); }

/**
 * @param who This value must never be {@code null}.

 * @param what This value must never be {@code null}.
 */

public void unscheduleDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable who, @androidx.annotation.RecentlyNonNull java.lang.Runnable what) { throw new RuntimeException("Stub!"); }

/**
 * @param canvas This value must never be {@code null}.
 */

public void draw(@androidx.annotation.RecentlyNonNull android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * @param padding This value must never be {@code null}.
 */

public boolean getPadding(@androidx.annotation.RecentlyNonNull android.graphics.Rect padding) { throw new RuntimeException("Stub!"); }

public void setHotspot(float x, float y) { throw new RuntimeException("Stub!"); }

public void setHotspotBounds(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * @param outRect This value must never be {@code null}.
 */

public void getHotspotBounds(@androidx.annotation.RecentlyNonNull android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

public boolean setVisible(boolean visible, boolean restart) { throw new RuntimeException("Stub!"); }

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

public int getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * @param colorFilter This value may be {@code null}.
 */

public void setColorFilter(@androidx.annotation.RecentlyNullable android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

public android.graphics.ColorFilter getColorFilter() { throw new RuntimeException("Stub!"); }

/**
 * @param tint This value may be {@code null}.
 */

public void setTintList(@androidx.annotation.RecentlyNullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * @param tintMode This value may be {@code null}.
 */

public void setTintMode(@androidx.annotation.RecentlyNullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * @param layoutDirection Value is {@link android.view.View#LAYOUT_DIRECTION_LTR}, or {@link android.view.View#LAYOUT_DIRECTION_RTL}
 */

public boolean onLayoutDirectionChanged(int layoutDirection) { throw new RuntimeException("Stub!"); }

public int getOpacity() { throw new RuntimeException("Stub!"); }

public boolean isStateful() { throw new RuntimeException("Stub!"); }

protected boolean onStateChange(int[] state) { throw new RuntimeException("Stub!"); }

protected boolean onLevelChange(int level) { throw new RuntimeException("Stub!"); }

/**
 * @param bounds This value must never be {@code null}.
 */

protected void onBoundsChange(@androidx.annotation.RecentlyNonNull android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

public int getIntrinsicWidth() { throw new RuntimeException("Stub!"); }

public int getIntrinsicHeight() { throw new RuntimeException("Stub!"); }

/**
 * @param outline This value must never be {@code null}.
 */

public void getOutline(@androidx.annotation.RecentlyNonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

/**
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }
}

