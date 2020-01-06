/*
 * Copyright (C) 2008 The Android Open Source Project
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


/**
 * A specialized Drawable that fills the Canvas with a specified color.
 * Note that a ColorDrawable ignores the ColorFilter.
 *
 * <p>It can be defined in an XML file with the <code>&lt;color></code> element.</p>
 *
 * @attr ref android.R.styleable#ColorDrawable_color
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ColorDrawable extends android.graphics.drawable.Drawable {

/**
 * Creates a new black ColorDrawable.
 */

public ColorDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new ColorDrawable with the specified color.
 *
 * @param color The color to draw.
 */

public ColorDrawable(int color) { throw new RuntimeException("Stub!"); }

/**
 * @return Value is either <code>0</code> or a combination of {@link android.content.pm.ActivityInfo#CONFIG_MCC}, {@link android.content.pm.ActivityInfo#CONFIG_MNC}, {@link android.content.pm.ActivityInfo#CONFIG_LOCALE}, {@link android.content.pm.ActivityInfo#CONFIG_TOUCHSCREEN}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD}, {@link android.content.pm.ActivityInfo#CONFIG_KEYBOARD_HIDDEN}, {@link android.content.pm.ActivityInfo#CONFIG_NAVIGATION}, {@link android.content.pm.ActivityInfo#CONFIG_ORIENTATION}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_LAYOUT}, {@link android.content.pm.ActivityInfo#CONFIG_UI_MODE}, {@link android.content.pm.ActivityInfo#CONFIG_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_SMALLEST_SCREEN_SIZE}, {@link android.content.pm.ActivityInfo#CONFIG_DENSITY}, {@link android.content.pm.ActivityInfo#CONFIG_LAYOUT_DIRECTION}, {@link android.content.pm.ActivityInfo#CONFIG_COLOR_MODE}, and {@link android.content.pm.ActivityInfo#CONFIG_FONT_SCALE}
 */

public int getChangingConfigurations() { throw new RuntimeException("Stub!"); }

/**
 * A mutable BitmapDrawable still shares its Bitmap with any other Drawable
 * that comes from the same resource.
 *
 * @return This drawable.
 */

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

public void draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Gets the drawable's color value.
 *
 * @return int The color to draw.
 */

public int getColor() { throw new RuntimeException("Stub!"); }

/**
 * Sets the drawable's color value. This action will clobber the results of
 * prior calls to {@link #setAlpha(int)} on this object, which side-affected
 * the underlying color.
 *
 * @param color The color to draw.
 */

public void setColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Returns the alpha value of this drawable's color.
 *
 * @return A value between 0 and 255.
 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Sets the color's alpha value.
 *
 * @param alpha The alpha value to set, between 0 and 255.
 */

public void setAlpha(int alpha) { throw new RuntimeException("Stub!"); }

/**
 * Sets the color filter applied to this color.
 * <p>
 * Only supported on version {@link android.os.Build.VERSION_CODES#LOLLIPOP} and
 * above. Calling this method has no effect on earlier versions.
 *
 * @see android.graphics.drawable.Drawable#setColorFilter(ColorFilter)
 */

public void setColorFilter(android.graphics.ColorFilter colorFilter) { throw new RuntimeException("Stub!"); }

public void setTintList(android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

public void setTintMode(android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

protected boolean onStateChange(int[] stateSet) { throw new RuntimeException("Stub!"); }

public boolean isStateful() { throw new RuntimeException("Stub!"); }

public int getOpacity() { throw new RuntimeException("Stub!"); }

/**
 * @param outline This value must never be {@code null}.
 */

public void getOutline(@androidx.annotation.RecentlyNonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

public void inflate(android.content.res.Resources r, org.xmlpull.v1.XmlPullParser parser, android.util.AttributeSet attrs, android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

public void applyTheme(android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }
}

