/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

/**
 * A Switch is a two-state toggle switch widget that can select between two
 * options. The user may drag the "thumb" back and forth to choose the selected option,
 * or simply tap to toggle as if it were a checkbox. The {@link #setText(CharSequence) text}
 * property controls the text displayed in the label for the switch, whereas the
 * {@link #setTextOff(CharSequence) off} and {@link #setTextOn(CharSequence) on} text
 * controls the text on the thumb. Similarly, the
 * {@link #setTextAppearance(android.content.Context, int) textAppearance} and the related
 * setTypeface() methods control the typeface and style of label text, whereas the
 * {@link #setSwitchTextAppearance(android.content.Context, int) switchTextAppearance} and
 * the related setSwitchTypeface() methods control that of the thumb.
 *
 * <p>{@link android.support.v7.widget.SwitchCompat} is a version of
 * the Switch widget which runs on devices back to API 7.</p>
 *
 * <p>See the <a href="{@docRoot}guide/topics/ui/controls/togglebutton.html">Toggle Buttons</a>
 * guide.</p>
 *
 * @attr ref android.R.styleable#Switch_textOn
 * @attr ref android.R.styleable#Switch_textOff
 * @attr ref android.R.styleable#Switch_switchMinWidth
 * @attr ref android.R.styleable#Switch_switchPadding
 * @attr ref android.R.styleable#Switch_switchTextAppearance
 * @attr ref android.R.styleable#Switch_thumb
 * @attr ref android.R.styleable#Switch_thumbTextPadding
 * @attr ref android.R.styleable#Switch_track
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Switch extends android.widget.CompoundButton {

/**
 * Construct a new Switch with default styling.
 *
 * @param context The Context that will determine this widget's theming.
 */

public Switch(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Construct a new Switch with default styling, overriding specific style
 * attributes as requested.
 *
 * @param context The Context that will determine this widget's theming.
 * @param attrs Specification of attributes that should deviate from default styling.
 */

public Switch(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Construct a new Switch with a default style determined by the given theme attribute,
 * overriding specific style attributes as requested.
 *
 * @param context The Context that will determine this widget's theming.
 * @param attrs Specification of attributes that should deviate from the default styling.
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 */

public Switch(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Construct a new Switch with a default style determined by the given theme
 * attribute or style resource, overriding specific style attributes as
 * requested.
 *
 * @param context The Context that will determine this widget's theming.
 * @param attrs Specification of attributes that should deviate from the
 *        default styling.
 * @param defStyleAttr An attribute in the current theme that contains a
 *        reference to a style resource that supplies default values for
 *        the view. Can be 0 to not look for defaults.
 * @param defStyleRes A resource identifier of a style resource that
 *        supplies default values for the view, used only if
 *        defStyleAttr is 0 or can not be found in the theme. Can be 0
 *        to not look for defaults.
 */

public Switch(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Sets the switch text color, size, style, hint color, and highlight color
 * from the specified TextAppearance resource.
 *
 * @attr ref android.R.styleable#Switch_switchTextAppearance
 */

public void setSwitchTextAppearance(android.content.Context context, int resid) { throw new RuntimeException("Stub!"); }

/**
 * Sets the typeface and style in which the text should be displayed on the
 * switch, and turns on the fake bold and italic bits in the Paint if the
 * Typeface that you provided does not have all the bits in the
 * style that you specified.
 */

public void setSwitchTypeface(android.graphics.Typeface tf, int style) { throw new RuntimeException("Stub!"); }

/**
 * Sets the typeface in which the text should be displayed on the switch.
 * Note that not all Typeface families actually have bold and italic
 * variants, so you may need to use
 * {@link #setSwitchTypeface(Typeface, int)} to get the appearance
 * that you actually want.
 *
 * @attr ref android.R.styleable#TextView_typeface
 * @attr ref android.R.styleable#TextView_textStyle
 */

public void setSwitchTypeface(android.graphics.Typeface tf) { throw new RuntimeException("Stub!"); }

/**
 * Set the amount of horizontal padding between the switch and the associated text.
 *
 * @param pixels Amount of padding in pixels
 *
 * @attr ref android.R.styleable#Switch_switchPadding
 */

public void setSwitchPadding(int pixels) { throw new RuntimeException("Stub!"); }

/**
 * Get the amount of horizontal padding between the switch and the associated text.
 *
 * @return Amount of padding in pixels
 *
 * @attr ref android.R.styleable#Switch_switchPadding
 */

public int getSwitchPadding() { throw new RuntimeException("Stub!"); }

/**
 * Set the minimum width of the switch in pixels. The switch's width will be the maximum
 * of this value and its measured width as determined by the switch drawables and text used.
 *
 * @param pixels Minimum width of the switch in pixels
 *
 * @attr ref android.R.styleable#Switch_switchMinWidth
 */

public void setSwitchMinWidth(int pixels) { throw new RuntimeException("Stub!"); }

/**
 * Get the minimum width of the switch in pixels. The switch's width will be the maximum
 * of this value and its measured width as determined by the switch drawables and text used.
 *
 * @return Minimum width of the switch in pixels
 *
 * @attr ref android.R.styleable#Switch_switchMinWidth
 */

public int getSwitchMinWidth() { throw new RuntimeException("Stub!"); }

/**
 * Set the horizontal padding around the text drawn on the switch itself.
 *
 * @param pixels Horizontal padding for switch thumb text in pixels
 *
 * @attr ref android.R.styleable#Switch_thumbTextPadding
 */

public void setThumbTextPadding(int pixels) { throw new RuntimeException("Stub!"); }

/**
 * Get the horizontal padding around the text drawn on the switch itself.
 *
 * @return Horizontal padding for switch thumb text in pixels
 *
 * @attr ref android.R.styleable#Switch_thumbTextPadding
 */

public int getThumbTextPadding() { throw new RuntimeException("Stub!"); }

/**
 * Set the drawable used for the track that the switch slides within.
 *
 * @param track Track drawable
 *
 * @attr ref android.R.styleable#Switch_track
 */

public void setTrackDrawable(android.graphics.drawable.Drawable track) { throw new RuntimeException("Stub!"); }

/**
 * Set the drawable used for the track that the switch slides within.
 *
 * @param resId Resource ID of a track drawable
 *
 * @attr ref android.R.styleable#Switch_track
 */

public void setTrackResource(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Get the drawable used for the track that the switch slides within.
 *
 * @return Track drawable
 *
 * @attr ref android.R.styleable#Switch_track
 */

public android.graphics.drawable.Drawable getTrackDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the track drawable. Does not modify the current
 * tint mode, which is {@link PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * Subsequent calls to {@link #setTrackDrawable(Drawable)} will
 * automatically mutate the drawable and apply the specified tint and tint
 * mode using {@link Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Switch_trackTint
 * @see #getTrackTintList()
 * @see Drawable#setTintList(ColorStateList)
 */

public void setTrackTintList(@androidx.annotation.RecentlyNullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * @return the tint applied to the track drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Switch_trackTint
 * @see #setTrackTintList(ColorStateList)
 */

@androidx.annotation.RecentlyNullable public android.content.res.ColorStateList getTrackTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setTrackTintList(ColorStateList)}} to the track drawable.
 * The default mode is {@link PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Switch_trackTintMode
 * @see #getTrackTintMode()
 * @see Drawable#setTintMode(PorterDuff.Mode)
 */

public void setTrackTintMode(@androidx.annotation.RecentlyNullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * @return the blending mode used to apply the tint to the track
 *         drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Switch_trackTintMode
 * @see #setTrackTintMode(PorterDuff.Mode)
 */

@androidx.annotation.RecentlyNullable public android.graphics.PorterDuff.Mode getTrackTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Set the drawable used for the switch "thumb" - the piece that the user
 * can physically touch and drag along the track.
 *
 * @param thumb Thumb drawable
 *
 * @attr ref android.R.styleable#Switch_thumb
 */

public void setThumbDrawable(android.graphics.drawable.Drawable thumb) { throw new RuntimeException("Stub!"); }

/**
 * Set the drawable used for the switch "thumb" - the piece that the user
 * can physically touch and drag along the track.
 *
 * @param resId Resource ID of a thumb drawable
 *
 * @attr ref android.R.styleable#Switch_thumb
 */

public void setThumbResource(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Get the drawable used for the switch "thumb" - the piece that the user
 * can physically touch and drag along the track.
 *
 * @return Thumb drawable
 *
 * @attr ref android.R.styleable#Switch_thumb
 */

public android.graphics.drawable.Drawable getThumbDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the thumb drawable. Does not modify the current
 * tint mode, which is {@link PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * Subsequent calls to {@link #setThumbDrawable(Drawable)} will
 * automatically mutate the drawable and apply the specified tint and tint
 * mode using {@link Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Switch_thumbTint
 * @see #getThumbTintList()
 * @see Drawable#setTintList(ColorStateList)
 */

public void setThumbTintList(@androidx.annotation.RecentlyNullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * @return the tint applied to the thumb drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Switch_thumbTint
 * @see #setThumbTintList(ColorStateList)
 */

@androidx.annotation.RecentlyNullable public android.content.res.ColorStateList getThumbTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setThumbTintList(ColorStateList)}} to the thumb drawable.
 * The default mode is {@link PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Switch_thumbTintMode
 * @see #getThumbTintMode()
 * @see Drawable#setTintMode(PorterDuff.Mode)
 */

public void setThumbTintMode(@androidx.annotation.RecentlyNullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * @return the blending mode used to apply the tint to the thumb
 *         drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#Switch_thumbTintMode
 * @see #setThumbTintMode(PorterDuff.Mode)
 */

@androidx.annotation.RecentlyNullable public android.graphics.PorterDuff.Mode getThumbTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Specifies whether the track should be split by the thumb. When true,
 * the thumb's optical bounds will be clipped out of the track drawable,
 * then the thumb will be drawn into the resulting gap.
 *
 * @param splitTrack Whether the track should be split by the thumb
 *
 * @attr ref android.R.styleable#Switch_splitTrack
 */

public void setSplitTrack(boolean splitTrack) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the track should be split by the thumb.
 *
 * @attr ref android.R.styleable#Switch_splitTrack
 */

public boolean getSplitTrack() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text displayed when the button is in the checked state.
 *
 * @attr ref android.R.styleable#Switch_textOn
 */

public java.lang.CharSequence getTextOn() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text displayed when the button is in the checked state.
 *
 * @attr ref android.R.styleable#Switch_textOn
 */

public void setTextOn(java.lang.CharSequence textOn) { throw new RuntimeException("Stub!"); }

/**
 * Returns the text displayed when the button is not in the checked state.
 *
 * @attr ref android.R.styleable#Switch_textOff
 */

public java.lang.CharSequence getTextOff() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text displayed when the button is not in the checked state.
 *
 * @attr ref android.R.styleable#Switch_textOff
 */

public void setTextOff(java.lang.CharSequence textOff) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether the on/off text should be displayed.
 *
 * @param showText {@code true} to display on/off text
 * @attr ref android.R.styleable#Switch_showText
 */

public void setShowText(boolean showText) { throw new RuntimeException("Stub!"); }

/**
 * @return whether the on/off text should be displayed
 * @attr ref android.R.styleable#Switch_showText
 */

public boolean getShowText() { throw new RuntimeException("Stub!"); }

public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

public boolean onTouchEvent(android.view.MotionEvent ev) { throw new RuntimeException("Stub!"); }

public void toggle() { throw new RuntimeException("Stub!"); }

public void setChecked(boolean checked) { throw new RuntimeException("Stub!"); }

protected void onLayout(boolean changed, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

public void draw(android.graphics.Canvas c) { throw new RuntimeException("Stub!"); }

protected void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

public int getCompoundPaddingLeft() { throw new RuntimeException("Stub!"); }

public int getCompoundPaddingRight() { throw new RuntimeException("Stub!"); }

protected int[] onCreateDrawableState(int extraSpace) { throw new RuntimeException("Stub!"); }

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

public void drawableHotspotChanged(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * @param who This value must never be {@code null}.
 */

protected boolean verifyDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

public void jumpDrawablesToCurrentState() { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

public void onProvideStructure(android.view.ViewStructure structure) { throw new RuntimeException("Stub!"); }

public void onProvideAutofillStructure(android.view.ViewStructure structure, int flags) { throw new RuntimeException("Stub!"); }
}

