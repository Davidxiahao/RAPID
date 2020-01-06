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


package android.graphics;

import java.util.Locale;
import android.os.LocaleList;
import android.graphics.fonts.FontVariationAxis;

/**
 * The Paint class holds the style and color information about how to draw
 * geometries, text and bitmaps.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Paint {

/**
 * Create a new paint with default settings.
 */

public Paint() { throw new RuntimeException("Stub!"); }

/**
 * Create a new paint with the specified flags. Use setFlags() to change
 * these after the paint is created.
 *
 * @param flags initial flag bits, as if they were passed via setFlags().
 */

public Paint(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Create a new paint, initialized with the attributes in the specified
 * paint parameter.
 *
 * @param paint Existing paint used to initialized the attributes of the
 *              new paint.
 */

public Paint(android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/** Restores the paint to its default settings. */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Copy the fields from src into this paint. This is equivalent to calling
 * get() on all of the src fields, and calling the corresponding set()
 * methods on this.
 */

public void set(android.graphics.Paint src) { throw new RuntimeException("Stub!"); }

/**
 * Return the paint's flags. Use the Flag enum to test flag values.
 *
 * @return the paint's flags (see enums ending in _Flag for bit masks)
 */

public int getFlags() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's flags. Use the Flag enum to specific flag values.
 *
 * @param flags The new flag bits for the paint
 */

public void setFlags(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Return the paint's hinting mode.  Returns either
 * {@link #HINTING_OFF} or {@link #HINTING_ON}.
 */

public int getHinting() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's hinting mode.  May be either
 * {@link #HINTING_OFF} or {@link #HINTING_ON}.
 */

public void setHinting(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Helper for getFlags(), returning true if ANTI_ALIAS_FLAG bit is set
 * AntiAliasing smooths out the edges of what is being drawn, but is has
 * no impact on the interior of the shape. See setDither() and
 * setFilterBitmap() to affect how colors are treated.
 *
 * @return true if the antialias bit is set in the paint's flags.
 */

public final boolean isAntiAlias() { throw new RuntimeException("Stub!"); }

/**
 * Helper for setFlags(), setting or clearing the ANTI_ALIAS_FLAG bit
 * AntiAliasing smooths out the edges of what is being drawn, but is has
 * no impact on the interior of the shape. See setDither() and
 * setFilterBitmap() to affect how colors are treated.
 *
 * @param aa true to set the antialias bit in the flags, false to clear it
 */

public void setAntiAlias(boolean aa) { throw new RuntimeException("Stub!"); }

/**
 * Helper for getFlags(), returning true if DITHER_FLAG bit is set
 * Dithering affects how colors that are higher precision than the device
 * are down-sampled. No dithering is generally faster, but higher precision
 * colors are just truncated down (e.g. 8888 -> 565). Dithering tries to
 * distribute the error inherent in this process, to reduce the visual
 * artifacts.
 *
 * @return true if the dithering bit is set in the paint's flags.
 */

public final boolean isDither() { throw new RuntimeException("Stub!"); }

/**
 * Helper for setFlags(), setting or clearing the DITHER_FLAG bit
 * Dithering affects how colors that are higher precision than the device
 * are down-sampled. No dithering is generally faster, but higher precision
 * colors are just truncated down (e.g. 8888 -> 565). Dithering tries to
 * distribute the error inherent in this process, to reduce the visual
 * artifacts.
 *
 * @param dither true to set the dithering bit in flags, false to clear it
 */

public void setDither(boolean dither) { throw new RuntimeException("Stub!"); }

/**
 * Helper for getFlags(), returning true if LINEAR_TEXT_FLAG bit is set
 *
 * @return true if the lineartext bit is set in the paint's flags
 */

public final boolean isLinearText() { throw new RuntimeException("Stub!"); }

/**
 * Helper for setFlags(), setting or clearing the LINEAR_TEXT_FLAG bit
 *
 * @param linearText true to set the linearText bit in the paint's flags,
 *                   false to clear it.
 */

public void setLinearText(boolean linearText) { throw new RuntimeException("Stub!"); }

/**
 * Helper for getFlags(), returning true if SUBPIXEL_TEXT_FLAG bit is set
 *
 * @return true if the subpixel bit is set in the paint's flags
 */

public final boolean isSubpixelText() { throw new RuntimeException("Stub!"); }

/**
 * Helper for setFlags(), setting or clearing the SUBPIXEL_TEXT_FLAG bit
 *
 * @param subpixelText true to set the subpixelText bit in the paint's
 *                     flags, false to clear it.
 */

public void setSubpixelText(boolean subpixelText) { throw new RuntimeException("Stub!"); }

/**
 * Helper for getFlags(), returning true if UNDERLINE_TEXT_FLAG bit is set
 *
 * @return true if the underlineText bit is set in the paint's flags.
 */

public final boolean isUnderlineText() { throw new RuntimeException("Stub!"); }

/**
 * Helper for setFlags(), setting or clearing the UNDERLINE_TEXT_FLAG bit
 *
 * @param underlineText true to set the underlineText bit in the paint's
 *                      flags, false to clear it.
 */

public void setUnderlineText(boolean underlineText) { throw new RuntimeException("Stub!"); }

/**
 * Helper for getFlags(), returning true if STRIKE_THRU_TEXT_FLAG bit is set
 *
 * @return true if the strikeThruText bit is set in the paint's flags.
 */

public final boolean isStrikeThruText() { throw new RuntimeException("Stub!"); }

/**
 * Helper for setFlags(), setting or clearing the STRIKE_THRU_TEXT_FLAG bit
 *
 * @param strikeThruText true to set the strikeThruText bit in the paint's
 *                       flags, false to clear it.
 */

public void setStrikeThruText(boolean strikeThruText) { throw new RuntimeException("Stub!"); }

/**
 * Helper for getFlags(), returning true if FAKE_BOLD_TEXT_FLAG bit is set
 *
 * @return true if the fakeBoldText bit is set in the paint's flags.
 */

public final boolean isFakeBoldText() { throw new RuntimeException("Stub!"); }

/**
 * Helper for setFlags(), setting or clearing the FAKE_BOLD_TEXT_FLAG bit
 *
 * @param fakeBoldText true to set the fakeBoldText bit in the paint's
 *                     flags, false to clear it.
 */

public void setFakeBoldText(boolean fakeBoldText) { throw new RuntimeException("Stub!"); }

/**
 * Whether or not the bitmap filter is activated.
 * Filtering affects the sampling of bitmaps when they are transformed.
 * Filtering does not affect how the colors in the bitmap are converted into
 * device pixels. That is dependent on dithering and xfermodes.
 *
 * @see #setFilterBitmap(boolean) setFilterBitmap()
 */

public final boolean isFilterBitmap() { throw new RuntimeException("Stub!"); }

/**
 * Helper for setFlags(), setting or clearing the FILTER_BITMAP_FLAG bit.
 * Filtering affects the sampling of bitmaps when they are transformed.
 * Filtering does not affect how the colors in the bitmap are converted into
 * device pixels. That is dependent on dithering and xfermodes.
 *
 * @param filter true to set the FILTER_BITMAP_FLAG bit in the paint's
 *               flags, false to clear it.
 */

public void setFilterBitmap(boolean filter) { throw new RuntimeException("Stub!"); }

/**
 * Return the paint's style, used for controlling how primitives'
 * geometries are interpreted (except for drawBitmap, which always assumes
 * FILL_STYLE).
 *
 * @return the paint's style setting (Fill, Stroke, StrokeAndFill)
 */

public android.graphics.Paint.Style getStyle() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's style, used for controlling how primitives'
 * geometries are interpreted (except for drawBitmap, which always assumes
 * Fill).
 *
 * @param style The new style to set in the paint
 */

public void setStyle(android.graphics.Paint.Style style) { throw new RuntimeException("Stub!"); }

/**
 * Return the paint's color. Note that the color is a 32bit value
 * containing alpha as well as r,g,b. This 32bit value is not premultiplied,
 * meaning that its alpha can be any value, regardless of the values of
 * r,g,b. See the Color class for more details.
 *
 * @return the paint's color (and alpha).
 */

public int getColor() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's color. Note that the color is an int containing alpha
 * as well as r,g,b. This 32bit value is not premultiplied, meaning that
 * its alpha can be any value, regardless of the values of r,g,b.
 * See the Color class for more details.
 *
 * @param color The new color (including alpha) to set in the paint.
 */

public void setColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Helper to getColor() that just returns the color's alpha value. This is
 * the same as calling getColor() >>> 24. It always returns a value between
 * 0 (completely transparent) and 255 (completely opaque).
 *
 * @return the alpha component of the paint's color.
 */

public int getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Helper to setColor(), that only assigns the color's alpha value,
 * leaving its r,g,b values unchanged. Results are undefined if the alpha
 * value is outside of the range [0..255]
 *
 * @param a set the alpha component [0..255] of the paint's color.
 */

public void setAlpha(int a) { throw new RuntimeException("Stub!"); }

/**
 * Helper to setColor(), that takes a,r,g,b and constructs the color int
 *
 * @param a The new alpha component (0..255) of the paint's color.
 * @param r The new red component (0..255) of the paint's color.
 * @param g The new green component (0..255) of the paint's color.
 * @param b The new blue component (0..255) of the paint's color.
 */

public void setARGB(int a, int r, int g, int b) { throw new RuntimeException("Stub!"); }

/**
 * Return the width for stroking.
 * <p />
 * A value of 0 strokes in hairline mode.
 * Hairlines always draws a single pixel independent of the canva's matrix.
 *
 * @return the paint's stroke width, used whenever the paint's style is
 *         Stroke or StrokeAndFill.
 */

public float getStrokeWidth() { throw new RuntimeException("Stub!"); }

/**
 * Set the width for stroking.
 * Pass 0 to stroke in hairline mode.
 * Hairlines always draws a single pixel independent of the canva's matrix.
 *
 * @param width set the paint's stroke width, used whenever the paint's
 *              style is Stroke or StrokeAndFill.
 */

public void setStrokeWidth(float width) { throw new RuntimeException("Stub!"); }

/**
 * Return the paint's stroke miter value. Used to control the behavior
 * of miter joins when the joins angle is sharp.
 *
 * @return the paint's miter limit, used whenever the paint's style is
 *         Stroke or StrokeAndFill.
 */

public float getStrokeMiter() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's stroke miter value. This is used to control the behavior
 * of miter joins when the joins angle is sharp. This value must be >= 0.
 *
 * @param miter set the miter limit on the paint, used whenever the paint's
 *              style is Stroke or StrokeAndFill.
 */

public void setStrokeMiter(float miter) { throw new RuntimeException("Stub!"); }

/**
 * Return the paint's Cap, controlling how the start and end of stroked
 * lines and paths are treated.
 *
 * @return the line cap style for the paint, used whenever the paint's
 *         style is Stroke or StrokeAndFill.
 */

public android.graphics.Paint.Cap getStrokeCap() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's Cap.
 *
 * @param cap set the paint's line cap style, used whenever the paint's
 *            style is Stroke or StrokeAndFill.
 */

public void setStrokeCap(android.graphics.Paint.Cap cap) { throw new RuntimeException("Stub!"); }

/**
 * Return the paint's stroke join type.
 *
 * @return the paint's Join.
 */

public android.graphics.Paint.Join getStrokeJoin() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's Join.
 *
 * @param join set the paint's Join, used whenever the paint's style is
 *             Stroke or StrokeAndFill.
 */

public void setStrokeJoin(android.graphics.Paint.Join join) { throw new RuntimeException("Stub!"); }

/**
 * Applies any/all effects (patheffect, stroking) to src, returning the
 * result in dst. The result is that drawing src with this paint will be
 * the same as drawing dst with a default paint (at least from the
 * geometric perspective).
 *
 * @param src input path
 * @param dst output path (may be the same as src)
 * @return    true if the path should be filled, or false if it should be
 *                 drawn with a hairline (width == 0)
 */

public boolean getFillPath(android.graphics.Path src, android.graphics.Path dst) { throw new RuntimeException("Stub!"); }

/**
 * Get the paint's shader object.
 *
 * @return the paint's shader (or null)
 */

public android.graphics.Shader getShader() { throw new RuntimeException("Stub!"); }

/**
 * Set or clear the shader object.
 * <p />
 * Pass null to clear any previous shader.
 * As a convenience, the parameter passed is also returned.
 *
 * @param shader May be null. the new shader to be installed in the paint
 * @return       shader
 */

public android.graphics.Shader setShader(android.graphics.Shader shader) { throw new RuntimeException("Stub!"); }

/**
 * Get the paint's colorfilter (maybe be null).
 *
 * @return the paint's colorfilter (maybe be null)
 */

public android.graphics.ColorFilter getColorFilter() { throw new RuntimeException("Stub!"); }

/**
 * Set or clear the paint's colorfilter, returning the parameter.
 *
 * @param filter May be null. The new filter to be installed in the paint
 * @return       filter
 */

public android.graphics.ColorFilter setColorFilter(android.graphics.ColorFilter filter) { throw new RuntimeException("Stub!"); }

/**
 * Get the paint's transfer mode object.
 *
 * @return the paint's transfer mode (or null)
 */

public android.graphics.Xfermode getXfermode() { throw new RuntimeException("Stub!"); }

/**
 * Set or clear the transfer mode object. A transfer mode defines how
 * source pixels (generate by a drawing command) are composited with
 * the destination pixels (content of the render target).
 * <p />
 * Pass null to clear any previous transfer mode.
 * As a convenience, the parameter passed is also returned.
 * <p />
 * {@link PorterDuffXfermode} is the most common transfer mode.
 *
 * @param xfermode May be null. The xfermode to be installed in the paint
 * @return         xfermode
 */

public android.graphics.Xfermode setXfermode(android.graphics.Xfermode xfermode) { throw new RuntimeException("Stub!"); }

/**
 * Get the paint's patheffect object.
 *
 * @return the paint's patheffect (or null)
 */

public android.graphics.PathEffect getPathEffect() { throw new RuntimeException("Stub!"); }

/**
 * Set or clear the patheffect object.
 * <p />
 * Pass null to clear any previous patheffect.
 * As a convenience, the parameter passed is also returned.
 *
 * @param effect May be null. The patheffect to be installed in the paint
 * @return       effect
 */

public android.graphics.PathEffect setPathEffect(android.graphics.PathEffect effect) { throw new RuntimeException("Stub!"); }

/**
 * Get the paint's maskfilter object.
 *
 * @return the paint's maskfilter (or null)
 */

public android.graphics.MaskFilter getMaskFilter() { throw new RuntimeException("Stub!"); }

/**
 * Set or clear the maskfilter object.
 * <p />
 * Pass null to clear any previous maskfilter.
 * As a convenience, the parameter passed is also returned.
 *
 * @param maskfilter May be null. The maskfilter to be installed in the
 *                   paint
 * @return           maskfilter
 */

public android.graphics.MaskFilter setMaskFilter(android.graphics.MaskFilter maskfilter) { throw new RuntimeException("Stub!"); }

/**
 * Get the paint's typeface object.
 * <p />
 * The typeface object identifies which font to use when drawing or
 * measuring text.
 *
 * @return the paint's typeface (or null)
 */

public android.graphics.Typeface getTypeface() { throw new RuntimeException("Stub!"); }

/**
 * Set or clear the typeface object.
 * <p />
 * Pass null to clear any previous typeface.
 * As a convenience, the parameter passed is also returned.
 *
 * @param typeface May be null. The typeface to be installed in the paint
 * @return         typeface
 */

public android.graphics.Typeface setTypeface(android.graphics.Typeface typeface) { throw new RuntimeException("Stub!"); }

/**
 * This draws a shadow layer below the main layer, with the specified
 * offset and color, and blur radius. If radius is 0, then the shadow
 * layer is removed.
 * <p>
 * Can be used to create a blurred shadow underneath text. Support for use
 * with other drawing operations is constrained to the software rendering
 * pipeline.
 * <p>
 * The alpha of the shadow will be the paint's alpha if the shadow color is
 * opaque, or the alpha from the shadow color if not.
 */

public void setShadowLayer(float radius, float dx, float dy, int shadowColor) { throw new RuntimeException("Stub!"); }

/**
 * Clear the shadow layer.
 */

public void clearShadowLayer() { throw new RuntimeException("Stub!"); }

/**
 * Return the paint's Align value for drawing text. This controls how the
 * text is positioned relative to its origin. LEFT align means that all of
 * the text will be drawn to the right of its origin (i.e. the origin
 * specifieds the LEFT edge of the text) and so on.
 *
 * @return the paint's Align value for drawing text.
 */

public android.graphics.Paint.Align getTextAlign() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's text alignment. This controls how the
 * text is positioned relative to its origin. LEFT align means that all of
 * the text will be drawn to the right of its origin (i.e. the origin
 * specifieds the LEFT edge of the text) and so on.
 *
 * @param align set the paint's Align value for drawing text.
 */

public void setTextAlign(android.graphics.Paint.Align align) { throw new RuntimeException("Stub!"); }

/**
 * Get the text's primary Locale. Note that this is not all of the locale-related information
 * Paint has. Use {@link #getTextLocales()} to get the complete list.
 *
 * @return the paint's primary Locale used for drawing text, never null.
 */

@androidx.annotation.RecentlyNonNull public java.util.Locale getTextLocale() { throw new RuntimeException("Stub!"); }

/**
 * Get the text locale list.
 *
 * @return the paint's LocaleList used for drawing text, never null or empty.
 */

@androidx.annotation.RecentlyNonNull public android.os.LocaleList getTextLocales() { throw new RuntimeException("Stub!"); }

/**
 * Set the text locale list to a one-member list consisting of just the locale.
 *
 * See {@link #setTextLocales(LocaleList)} for how the locale list affects
 * the way the text is drawn for some languages.
 *
 * @param locale the paint's locale value for drawing text, must not be null.

 * This value must never be {@code null}.
 */

public void setTextLocale(@androidx.annotation.RecentlyNonNull java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Set the text locale list.
 *
 * The text locale list affects how the text is drawn for some languages.
 *
 * For example, if the locale list contains {@link Locale#CHINESE} or {@link Locale#CHINA},
 * then the text renderer will prefer to draw text using a Chinese font. Likewise,
 * if the locale list contains {@link Locale#JAPANESE} or {@link Locale#JAPAN}, then the text
 * renderer will prefer to draw text using a Japanese font. If the locale list contains both,
 * the order those locales appear in the list is considered for deciding the font.
 *
 * This distinction is important because Chinese and Japanese text both use many
 * of the same Unicode code points but their appearance is subtly different for
 * each language.
 *
 * By default, the text locale list is initialized to a one-member list just containing the
 * system locales. This assumes that the text to be rendered will most likely be in the user's
 * preferred language.
 *
 * If the actual language or languages of the text is/are known, then they can be provided to
 * the text renderer using this method. The text renderer may attempt to guess the
 * language script based on the contents of the text to be drawn independent of
 * the text locale here. Specifying the text locales just helps it do a better
 * job in certain ambiguous cases.
 *
 * @param locales the paint's locale list for drawing text, must not be null or empty.

 * This value must never be {@code null}.
 */

public void setTextLocales(@androidx.annotation.RecentlyNonNull android.os.LocaleList locales) { throw new RuntimeException("Stub!"); }

/**
 * Get the elegant metrics flag.
 *
 * @return true if elegant metrics are enabled for text drawing.
 */

public boolean isElegantTextHeight() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's elegant height metrics flag. This setting selects font
 * variants that have not been compacted to fit Latin-based vertical
 * metrics, and also increases top and bottom bounds to provide more space.
 *
 * @param elegant set the paint's elegant metrics flag for drawing text.
 */

public void setElegantTextHeight(boolean elegant) { throw new RuntimeException("Stub!"); }

/**
 * Return the paint's text size.
 *
 * @return the paint's text size in pixel units.
 */

public float getTextSize() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's text size. This value must be > 0
 *
 * @param textSize set the paint's text size in pixel units.
 */

public void setTextSize(float textSize) { throw new RuntimeException("Stub!"); }

/**
 * Return the paint's horizontal scale factor for text. The default value
 * is 1.0.
 *
 * @return the paint's scale factor in X for drawing/measuring text
 */

public float getTextScaleX() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's horizontal scale factor for text. The default value
 * is 1.0. Values > 1.0 will stretch the text wider. Values < 1.0 will
 * stretch the text narrower.
 *
 * @param scaleX set the paint's scale in X for drawing/measuring text.
 */

public void setTextScaleX(float scaleX) { throw new RuntimeException("Stub!"); }

/**
 * Return the paint's horizontal skew factor for text. The default value
 * is 0.
 *
 * @return         the paint's skew factor in X for drawing text.
 */

public float getTextSkewX() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's horizontal skew factor for text. The default value
 * is 0. For approximating oblique text, use values around -0.25.
 *
 * @param skewX set the paint's skew factor in X for drawing text.
 */

public void setTextSkewX(float skewX) { throw new RuntimeException("Stub!"); }

/**
 * Return the paint's letter-spacing for text. The default value
 * is 0.
 *
 * @return         the paint's letter-spacing for drawing text.
 */

public float getLetterSpacing() { throw new RuntimeException("Stub!"); }

/**
 * Set the paint's letter-spacing for text. The default value
 * is 0.  The value is in 'EM' units.  Typical values for slight
 * expansion will be around 0.05.  Negative values tighten text.
 *
 * @param letterSpacing set the paint's letter-spacing for drawing text.
 */

public void setLetterSpacing(float letterSpacing) { throw new RuntimeException("Stub!"); }

/**
 * Returns the font feature settings. The format is the same as the CSS
 * font-feature-settings attribute:
 * <a href="https://www.w3.org/TR/css-fonts-3/#font-feature-settings-prop">
 *     https://www.w3.org/TR/css-fonts-3/#font-feature-settings-prop</a>
 *
 * @return the paint's currently set font feature settings. Default is null.
 *
 * @see #setFontFeatureSettings(String)
 */

public java.lang.String getFontFeatureSettings() { throw new RuntimeException("Stub!"); }

/**
 * Set font feature settings.
 *
 * The format is the same as the CSS font-feature-settings attribute:
 * <a href="https://www.w3.org/TR/css-fonts-3/#font-feature-settings-prop">
 *     https://www.w3.org/TR/css-fonts-3/#font-feature-settings-prop</a>
 *
 * @see #getFontFeatureSettings()
 *
 * @param settings the font feature settings string to use, may be null.
 */

public void setFontFeatureSettings(java.lang.String settings) { throw new RuntimeException("Stub!"); }

/**
 * Returns the font variation settings.
 *
 * @return the paint's currently set font variation settings. Default is null.
 *
 * @see #setFontVariationSettings(String)
 */

public java.lang.String getFontVariationSettings() { throw new RuntimeException("Stub!"); }

/**
 * Sets TrueType or OpenType font variation settings. The settings string is constructed from
 * multiple pairs of axis tag and style values. The axis tag must contain four ASCII characters
 * and must be wrapped with single quotes (U+0027) or double quotes (U+0022). Axis strings that
 * are longer or shorter than four characters, or contain characters outside of U+0020..U+007E
 * are invalid. If a specified axis name is not defined in the font, the settings will be
 * ignored.
 *
 * Examples,
 * <ul>
 * <li>Set font width to 150.
 * <pre>
 * <code>
 *   Paint paint = new Paint();
 *   paint.setFontVariationSettings("'wdth' 150");
 * </code>
 * </pre>
 * </li>
 *
 * <li>Set the font slant to 20 degrees and ask for italic style.
 * <pre>
 * <code>
 *   Paint paint = new Paint();
 *   paint.setFontVariationSettings("'slnt' 20, 'ital' 1");
 * </code>
 * </pre>
 * </li>
 * </ul>
 *
 * @param fontVariationSettings font variation settings. You can pass null or empty string as
 *                              no variation settings.
 *
 * @return true if the given settings is effective to at least one font file underlying this
 *         typeface. This function also returns true for empty settings string. Otherwise
 *         returns false
 *
 * @throws IllegalArgumentException If given string is not a valid font variation settings
 *                                  format
 *
 * @see #getFontVariationSettings()
 * @see FontVariationAxis
 */

public boolean setFontVariationSettings(java.lang.String fontVariationSettings) { throw new RuntimeException("Stub!"); }

/**
 * Return the distance above (negative) the baseline (ascent) based on the
 * current typeface and text size.
 *
 * <p>Note that this is the ascent of the main typeface, and actual text rendered may need a
 * larger ascent because fallback fonts may get used in rendering the text.
 *
 * @return the distance above (negative) the baseline (ascent) based on the
 *         current typeface and text size.
 */

public float ascent() { throw new RuntimeException("Stub!"); }

/**
 * Return the distance below (positive) the baseline (descent) based on the
 * current typeface and text size.
 *
 * <p>Note that this is the descent of the main typeface, and actual text rendered may need a
 * larger descent because fallback fonts may get used in rendering the text.
 *
 * @return the distance below (positive) the baseline (descent) based on
 *         the current typeface and text size.
 */

public float descent() { throw new RuntimeException("Stub!"); }

/**
 * Return the font's recommended interline spacing, given the Paint's
 * settings for typeface, textSize, etc. If metrics is not null, return the
 * fontmetric values in it.
 *
 * <p>Note that these are the values for the main typeface, and actual text rendered may need a
 * larger set of values because fallback fonts may get used in rendering the text.
 *
 * @param metrics If this object is not null, its fields are filled with
 *                the appropriate values given the paint's text attributes.
 * @return the font's recommended interline spacing.
 */

public float getFontMetrics(android.graphics.Paint.FontMetrics metrics) { throw new RuntimeException("Stub!"); }

/**
 * Allocates a new FontMetrics object, and then calls getFontMetrics(fm)
 * with it, returning the object.
 */

public android.graphics.Paint.FontMetrics getFontMetrics() { throw new RuntimeException("Stub!"); }

/**
 * Return the font's interline spacing, given the Paint's settings for
 * typeface, textSize, etc. If metrics is not null, return the fontmetric
 * values in it. Note: all values have been converted to integers from
 * floats, in such a way has to make the answers useful for both spacing
 * and clipping. If you want more control over the rounding, call
 * getFontMetrics().
 *
 * <p>Note that these are the values for the main typeface, and actual text rendered may need a
 * larger set of values because fallback fonts may get used in rendering the text.
 *
 * @return the font's interline spacing.
 */

public int getFontMetricsInt(android.graphics.Paint.FontMetricsInt fmi) { throw new RuntimeException("Stub!"); }

public android.graphics.Paint.FontMetricsInt getFontMetricsInt() { throw new RuntimeException("Stub!"); }

/**
 * Return the recommend line spacing based on the current typeface and
 * text size.
 *
 * <p>Note that this is the value for the main typeface, and actual text rendered may need a
 * larger value because fallback fonts may get used in rendering the text.
 *
 * @return  recommend line spacing based on the current typeface and
 *          text size.
 */

public float getFontSpacing() { throw new RuntimeException("Stub!"); }

/**
 * Return the width of the text.
 *
 * @param text  The text to measure. Cannot be null.
 * @param index The index of the first character to start measuring
 * @param count THe number of characters to measure, beginning with start
 * @return      The width of the text
 */

public float measureText(char[] text, int index, int count) { throw new RuntimeException("Stub!"); }

/**
 * Return the width of the text.
 *
 * @param text  The text to measure. Cannot be null.
 * @param start The index of the first character to start measuring
 * @param end   1 beyond the index of the last character to measure
 * @return      The width of the text
 */

public float measureText(java.lang.String text, int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Return the width of the text.
 *
 * @param text  The text to measure. Cannot be null.
 * @return      The width of the text
 */

public float measureText(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Return the width of the text.
 *
 * @param text  The text to measure
 * @param start The index of the first character to start measuring
 * @param end   1 beyond the index of the last character to measure
 * @return      The width of the text
 */

public float measureText(java.lang.CharSequence text, int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Measure the text, stopping early if the measured width exceeds maxWidth.
 * Return the number of chars that were measured, and if measuredWidth is
 * not null, return in it the actual width measured.
 *
 * @param text  The text to measure. Cannot be null.
 * @param index The offset into text to begin measuring at
 * @param count The number of maximum number of entries to measure. If count
 *              is negative, then the characters are measured in reverse order.
 * @param maxWidth The maximum width to accumulate.
 * @param measuredWidth Optional. If not null, returns the actual width
 *                     measured.
 * @return The number of chars that were measured. Will always be <=
 *         abs(count).
 */

public int breakText(char[] text, int index, int count, float maxWidth, float[] measuredWidth) { throw new RuntimeException("Stub!"); }

/**
 * Measure the text, stopping early if the measured width exceeds maxWidth.
 * Return the number of chars that were measured, and if measuredWidth is
 * not null, return in it the actual width measured.
 *
 * @param text  The text to measure. Cannot be null.
 * @param start The offset into text to begin measuring at
 * @param end   The end of the text slice to measure.
 * @param measureForwards If true, measure forwards, starting at start.
 *                        Otherwise, measure backwards, starting with end.
 * @param maxWidth The maximum width to accumulate.
 * @param measuredWidth Optional. If not null, returns the actual width
 *                     measured.
 * @return The number of chars that were measured. Will always be <=
 *         abs(end - start).
 */

public int breakText(java.lang.CharSequence text, int start, int end, boolean measureForwards, float maxWidth, float[] measuredWidth) { throw new RuntimeException("Stub!"); }

/**
 * Measure the text, stopping early if the measured width exceeds maxWidth.
 * Return the number of chars that were measured, and if measuredWidth is
 * not null, return in it the actual width measured.
 *
 * @param text  The text to measure. Cannot be null.
 * @param measureForwards If true, measure forwards, starting with the
 *                        first character in the string. Otherwise,
 *                        measure backwards, starting with the
 *                        last character in the string.
 * @param maxWidth The maximum width to accumulate.
 * @param measuredWidth Optional. If not null, returns the actual width
 *                     measured.
 * @return The number of chars that were measured. Will always be <=
 *         abs(count).
 */

public int breakText(java.lang.String text, boolean measureForwards, float maxWidth, float[] measuredWidth) { throw new RuntimeException("Stub!"); }

/**
 * Return the advance widths for the characters in the string.
 *
 * @param text     The text to measure. Cannot be null.
 * @param index    The index of the first char to to measure
 * @param count    The number of chars starting with index to measure
 * @param widths   array to receive the advance widths of the characters.
 *                 Must be at least a large as count.
 * @return         the actual number of widths returned.
 */

public int getTextWidths(char[] text, int index, int count, float[] widths) { throw new RuntimeException("Stub!"); }

/**
 * Return the advance widths for the characters in the string.
 *
 * @param text     The text to measure. Cannot be null.
 * @param start    The index of the first char to to measure
 * @param end      The end of the text slice to measure
 * @param widths   array to receive the advance widths of the characters.
 *                 Must be at least a large as (end - start).
 * @return         the actual number of widths returned.
 */

public int getTextWidths(java.lang.CharSequence text, int start, int end, float[] widths) { throw new RuntimeException("Stub!"); }

/**
 * Return the advance widths for the characters in the string.
 *
 * @param text   The text to measure. Cannot be null.
 * @param start  The index of the first char to to measure
 * @param end    The end of the text slice to measure
 * @param widths array to receive the advance widths of the characters.
 *               Must be at least a large as the text.
 * @return       the number of code units in the specified text.
 */

public int getTextWidths(java.lang.String text, int start, int end, float[] widths) { throw new RuntimeException("Stub!"); }

/**
 * Return the advance widths for the characters in the string.
 *
 * @param text   The text to measure
 * @param widths array to receive the advance widths of the characters.
 *               Must be at least a large as the text.
 * @return       the number of code units in the specified text.
 */

public int getTextWidths(java.lang.String text, float[] widths) { throw new RuntimeException("Stub!"); }

/**
 * Return the path (outline) for the specified text.
 * Note: just like Canvas.drawText, this will respect the Align setting in
 * the paint.
 *
 * @param text the text to retrieve the path from
 * @param index the index of the first character in text
 * @param count the number of characters starting with index
 * @param x the x coordinate of the text's origin
 * @param y the y coordinate of the text's origin
 * @param path the path to receive the data describing the text. Must be allocated by the caller
 */

public void getTextPath(char[] text, int index, int count, float x, float y, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Return the path (outline) for the specified text.
 * Note: just like Canvas.drawText, this will respect the Align setting
 * in the paint.
 *
 * @param text the text to retrieve the path from
 * @param start the first character in the text
 * @param end 1 past the last character in the text
 * @param x the x coordinate of the text's origin
 * @param y the y coordinate of the text's origin
 * @param path the path to receive the data describing the text. Must be allocated by the caller
 */

public void getTextPath(java.lang.String text, int start, int end, float x, float y, android.graphics.Path path) { throw new RuntimeException("Stub!"); }

/**
 * Return in bounds (allocated by the caller) the smallest rectangle that
 * encloses all of the characters, with an implied origin at (0,0).
 *
 * @param text string to measure and return its bounds
 * @param start index of the first char in the string to measure
 * @param end 1 past the last char in the string to measure
 * @param bounds returns the unioned bounds of all the text. Must be allocated by the caller
 */

public void getTextBounds(java.lang.String text, int start, int end, android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/**
 * Return in bounds (allocated by the caller) the smallest rectangle that
 * encloses all of the characters, with an implied origin at (0,0).
 *
 * @param text  array of chars to measure and return their unioned bounds
 * @param index index of the first char in the array to measure
 * @param count the number of chars, beginning at index, to measure
 * @param bounds returns the unioned bounds of all the text. Must be allocated by the caller
 */

public void getTextBounds(char[] text, int index, int count, android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/**
 * Determine whether the typeface set on the paint has a glyph supporting the string. The
 * simplest case is when the string contains a single character, in which this method
 * determines whether the font has the character. In the case of multiple characters, the
 * method returns true if there is a single glyph representing the ligature. For example, if
 * the input is a pair of regional indicator symbols, determine whether there is an emoji flag
 * for the pair.
 *
 * <p>Finally, if the string contains a variation selector, the method only returns true if
 * the fonts contains a glyph specific to that variation.
 *
 * <p>Checking is done on the entire fallback chain, not just the immediate font referenced.
 *
 * @param string the string to test whether there is glyph support
 * @return true if the typeface has a glyph for the string
 */

public boolean hasGlyph(java.lang.String string) { throw new RuntimeException("Stub!"); }

/**
 * Measure cursor position within a run of text.
 *
 * <p>The run of text includes the characters from {@code start} to {@code end} in the text. In
 * addition, the range {@code contextStart} to {@code contextEnd} is used as context for the
 * purpose of complex text shaping, such as Arabic text potentially shaped differently based on
 * the text next to it.
 *
 * <p>All text outside the range {@code contextStart..contextEnd} is ignored. The text between
 * {@code start} and {@code end} will be laid out to be measured.
 *
 * <p>The returned width measurement is the advance from {@code start} to {@code offset}. It is
 * generally a positive value, no matter the direction of the run. If {@code offset == end},
 * the return value is simply the width of the whole run from {@code start} to {@code end}.
 *
 * <p>Ligatures are formed for characters in the range {@code start..end} (but not for
 * {@code start..contextStart} or {@code end..contextEnd}). If {@code offset} points to a
 * character in the middle of such a formed ligature, but at a grapheme cluster boundary, the
 * return value will also reflect an advance in the middle of the ligature. See
 * {@link #getOffsetForAdvance} for more discussion of grapheme cluster boundaries.
 *
 * <p>The direction of the run is explicitly specified by {@code isRtl}. Thus, this method is
 * suitable only for runs of a single direction.
 *
 * <p>All indices are relative to the start of {@code text}. Further, {@code 0 <= contextStart
 * <= start <= offset <= end <= contextEnd <= text.length} must hold on entry.
 *
 * @param text the text to measure. Cannot be null.
 * @param start the index of the start of the range to measure
 * @param end the index + 1 of the end of the range to measure
 * @param contextStart the index of the start of the shaping context
 * @param contextEnd the index + 1 of the end of the shaping context
 * @param isRtl whether the run is in RTL direction
 * @param offset index of caret position
 * @return width measurement between start and offset
 */

public float getRunAdvance(char[] text, int start, int end, int contextStart, int contextEnd, boolean isRtl, int offset) { throw new RuntimeException("Stub!"); }

/**
 * @see #getRunAdvance(char[], int, int, int, int, boolean, int)
 *
 * @param text the text to measure. Cannot be null.
 * @param start the index of the start of the range to measure
 * @param end the index + 1 of the end of the range to measure
 * @param contextStart the index of the start of the shaping context
 * @param contextEnd the index + 1 of the end of the shaping context
 * @param isRtl whether the run is in RTL direction
 * @param offset index of caret position
 * @return width measurement between start and offset
 */

public float getRunAdvance(java.lang.CharSequence text, int start, int end, int contextStart, int contextEnd, boolean isRtl, int offset) { throw new RuntimeException("Stub!"); }

/**
 * Get the character offset within the string whose position is closest to the specified
 * horizontal position.
 *
 * <p>The returned value is generally the value of {@code offset} for which
 * {@link #getRunAdvance} yields a result most closely approximating {@code advance},
 * and which is also on a grapheme cluster boundary. As such, it is the preferred method
 * for positioning a cursor in response to a touch or pointer event. The grapheme cluster
 * boundaries are based on
 * <a href="http://unicode.org/reports/tr29/">Unicode Standard Annex #29</a> but with some
 * tailoring for better user experience.
 *
 * <p>Note that {@code advance} is a (generally positive) width measurement relative to the start
 * of the run. Thus, for RTL runs it the distance from the point to the right edge.
 *
 * <p>All indices are relative to the start of {@code text}. Further, {@code 0 <= contextStart
 * <= start <= end <= contextEnd <= text.length} must hold on entry, and {@code start <= result
 * <= end} will hold on return.
 *
 * @param text the text to measure. Cannot be null.
 * @param start the index of the start of the range to measure
 * @param end the index + 1 of the end of the range to measure
 * @param contextStart the index of the start of the shaping context
 * @param contextEnd the index + 1 of the end of the range to measure
 * @param isRtl whether the run is in RTL direction
 * @param advance width relative to start of run
 * @return index of offset
 */

public int getOffsetForAdvance(char[] text, int start, int end, int contextStart, int contextEnd, boolean isRtl, float advance) { throw new RuntimeException("Stub!"); }

/**
 * @see #getOffsetForAdvance(char[], int, int, int, int, boolean, float)
 *
 * @param text the text to measure. Cannot be null.
 * @param start the index of the start of the range to measure
 * @param end the index + 1 of the end of the range to measure
 * @param contextStart the index of the start of the shaping context
 * @param contextEnd the index + 1 of the end of the range to measure
 * @param isRtl whether the run is in RTL direction
 * @param advance width relative to start of run
 * @return index of offset
 */

public int getOffsetForAdvance(java.lang.CharSequence text, int start, int end, int contextStart, int contextEnd, boolean isRtl, float advance) { throw new RuntimeException("Stub!"); }

/**
 * Returns true of the passed {@link Paint} will have the same effect on text measurement
 *
 * @param other A {@link Paint} object.
 * This value must never be {@code null}.
 * @return true if the other {@link Paint} has the same effect on text measurement.
 */

public boolean equalsForTextMeasurement(@androidx.annotation.RecentlyNonNull android.graphics.Paint other) { throw new RuntimeException("Stub!"); }

/**
 * Paint flag that enables antialiasing when drawing.
 *
 * <p>Enabling this flag will cause all draw operations that support
 * antialiasing to use it.</p>
 *
 * @see #Paint(int)
 * @see #setFlags(int)
 */

public static final int ANTI_ALIAS_FLAG = 1; // 0x1

/** Legacy Paint flag, no longer used. */

public static final int DEV_KERN_TEXT_FLAG = 256; // 0x100

/**
 * Paint flag that enables dithering when blitting.
 *
 * <p>Enabling this flag applies a dither to any blit operation where the
 * target's colour space is more constrained than the source.
 *
 * @see #Paint(int)
 * @see #setFlags(int)
 */

public static final int DITHER_FLAG = 4; // 0x4

/**
 * Paint flag that enables the use of bitmap fonts when drawing text.
 *
 * <p>Disabling this flag will prevent text draw operations from using
 * embedded bitmap strikes in fonts, causing fonts with both scalable
 * outlines and bitmap strikes to draw only the scalable outlines, and
 * fonts with only bitmap strikes to not draw at all.</p>
 *
 * @see #Paint(int)
 * @see #setFlags(int)
 */

public static final int EMBEDDED_BITMAP_TEXT_FLAG = 1024; // 0x400

/**
 * Paint flag that applies a synthetic bolding effect to drawn text.
 *
 * <p>Enabling this flag will cause text draw operations to apply a
 * simulated bold effect when drawing a {@link Typeface} that is not
 * already bold.</p>
 *
 * @see #Paint(int)
 * @see #setFlags(int)
 */

public static final int FAKE_BOLD_TEXT_FLAG = 32; // 0x20

/**
 * Paint flag that enables bilinear sampling on scaled bitmaps.
 *
 * <p>If cleared, scaled bitmaps will be drawn with nearest neighbor
 * sampling, likely resulting in artifacts. This should generally be on
 * when drawing bitmaps, unless performance-bound (rendering to software
 * canvas) or preferring pixelation artifacts to blurriness when scaling
 * significantly.</p>
 *
 * <p>If bitmaps are scaled for device density at creation time (as
 * resource bitmaps often are) the filtering will already have been
 * done.</p>
 *
 * @see #Paint(int)
 * @see #setFlags(int)
 */

public static final int FILTER_BITMAP_FLAG = 2; // 0x2

/**
 * Font hinter option that disables font hinting.
 *
 * @see #setHinting(int)
 */

public static final int HINTING_OFF = 0; // 0x0

/**
 * Font hinter option that enables font hinting.
 *
 * @see #setHinting(int)
 */

public static final int HINTING_ON = 1; // 0x1

/**
 * Paint flag that enables smooth linear scaling of text.
 *
 * <p>Enabling this flag does not actually scale text, but rather adjusts
 * text draw operations to deal gracefully with smooth adjustment of scale.
 * When this flag is enabled, font hinting is disabled to prevent shape
 * deformation between scale factors, and glyph caching is disabled due to
 * the large number of glyph images that will be generated.</p>
 *
 * <p>{@link #SUBPIXEL_TEXT_FLAG} should be used in conjunction with this
 * flag to prevent glyph positions from snapping to whole pixel values as
 * scale factor is adjusted.</p>
 *
 * @see #Paint(int)
 * @see #setFlags(int)
 */

public static final int LINEAR_TEXT_FLAG = 64; // 0x40

/**
 * Paint flag that applies a strike-through decoration to drawn text.
 *
 * @see #Paint(int)
 * @see #setFlags(int)
 */

public static final int STRIKE_THRU_TEXT_FLAG = 16; // 0x10

/**
 * Paint flag that enables subpixel positioning of text.
 *
 * <p>Enabling this flag causes glyph advances to be computed with subpixel
 * accuracy.</p>
 *
 * <p>This can be used with {@link #LINEAR_TEXT_FLAG} to prevent text from
 * jittering during smooth scale transitions.</p>
 *
 * @see #Paint(int)
 * @see #setFlags(int)
 */

public static final int SUBPIXEL_TEXT_FLAG = 128; // 0x80

/**
 * Paint flag that applies an underline decoration to drawn text.
 *
 * @see #Paint(int)
 * @see #setFlags(int)
 */

public static final int UNDERLINE_TEXT_FLAG = 8; // 0x8
/**
 * Align specifies how drawText aligns its text relative to the
 * [x,y] coordinates. The default is LEFT.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Align {
LEFT, CENTER, RIGHT;
}

/**
 * The Cap specifies the treatment for the beginning and ending of
 * stroked lines and paths. The default is BUTT.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Cap {
BUTT, ROUND, SQUARE;
}

/**
 * Class that describes the various metrics for a font at a given text size.
 * Remember, Y values increase going down, so those values will be positive,
 * and values that measure distances going up will be negative. This class
 * is returned by getFontMetrics().
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class FontMetrics {

public FontMetrics() { throw new RuntimeException("Stub!"); }

/**
 * The recommended distance above the baseline for singled spaced text.
 */

public float ascent;

/**
 * The maximum distance below the baseline for the lowest glyph in
 * the font at a given text size.
 */

public float bottom;

/**
 * The recommended distance below the baseline for singled spaced text.
 */

public float descent;

/**
 * The recommended additional space to add between lines of text.
 */

public float leading;

/**
 * The maximum distance above the baseline for the tallest glyph in
 * the font at a given text size.
 */

public float top;
}

/**
 * Convenience method for callers that want to have FontMetrics values as
 * integers.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class FontMetricsInt {

public FontMetricsInt() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The recommended distance above the baseline for singled spaced text.
 */

public int ascent;

/**
 * The maximum distance below the baseline for the lowest glyph in
 * the font at a given text size.
 */

public int bottom;

/**
 * The recommended distance below the baseline for singled spaced text.
 */

public int descent;

/**
 * The recommended additional space to add between lines of text.
 */

public int leading;

/**
 * The maximum distance above the baseline for the tallest glyph in
 * the font at a given text size.
 */

public int top;
}

/**
 * The Join specifies the treatment where lines and curve segments
 * join on a stroked path. The default is MITER.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Join {
MITER, ROUND, BEVEL;
}

/**
 * The Style specifies if the primitive being drawn is filled, stroked, or
 * both (in the same color). The default is FILL.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Style {
FILL, STROKE, FILL_AND_STROKE;
}

}

