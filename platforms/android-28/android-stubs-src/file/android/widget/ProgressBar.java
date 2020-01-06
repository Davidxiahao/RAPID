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


package android.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.graphics.Shader;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.view.animation.Animation;
import android.graphics.PorterDuff;
import android.content.res.ColorStateList;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.animation.Interpolator;

/**
 * <p>
 * A user interface element that indicates the progress of an operation.
 * Progress bar supports two modes to represent progress: determinate, and indeterminate. For
 * a visual overview of the difference between determinate and indeterminate progress modes, see
 * <a href="https://material.io/guidelines/components/progress-activity.html#progress-activity-types-of-indicators">
 * Progress & activity</a>.
 * Display progress bars to a user in a non-interruptive way.
 * Show the progress bar in your app's user interface or in a notification
 * instead of within a dialog.
 * </p>
 * <h3>Indeterminate Progress</h3>
 * <p>
 * Use indeterminate mode for the progress bar when you do not know how long an
 * operation will take.
 * Indeterminate mode is the default for progress bar and shows a cyclic animation without a
 * specific amount of progress indicated.
 * The following example shows an indeterminate progress bar:
 * <pre>
 * &lt;ProgressBar
 *      android:id="@+id/indeterminateBar"
 *      android:layout_width="wrap_content"
 *      android:layout_height="wrap_content"
 *      /&gt;
 * </pre>
 * </p>
 * <h3>Determinate Progress</h3>
 * <p>
 * Use determinate mode for the progress bar when you want to show that a specific quantity of
 * progress has occurred.
 * For example, the percent remaining of a file being retrieved, the amount records in
 * a batch written to database, or the percent remaining of an audio file that is playing.
 * <p>
 * <p>
 * To indicate determinate progress, you set the style of the progress bar to
 * {@link android.R.style#Widget_ProgressBar_Horizontal} and set the amount of progress.
 * The following example shows a determinate progress bar that is 25% complete:
 * <pre>
 * &lt;ProgressBar
 *      android:id="@+id/determinateBar"
 *      style="@android:style/Widget.ProgressBar.Horizontal"
 *      android:layout_width="wrap_content"
 *      android:layout_height="wrap_content"
 *      android:progress="25"/&gt;
 * </pre>
 * You can update the percentage of progress displayed by using the
 * {@link #setProgress(int)} method, or by calling
 * {@link #incrementProgressBy(int)} to increase the current progress completed
 * by a specified amount.
 * By default, the progress bar is full when the progress value reaches 100.
 * You can adjust this default by setting the
 * {@link android.R.styleable#ProgressBar_max android:max} attribute.
 * </p>
 * <p>Other progress bar styles provided by the system include:</p>
 * <ul>
 * <li>{@link android.R.style#Widget_ProgressBar_Horizontal Widget.ProgressBar.Horizontal}</li>
 * <li>{@link android.R.style#Widget_ProgressBar_Small Widget.ProgressBar.Small}</li>
 * <li>{@link android.R.style#Widget_ProgressBar_Large Widget.ProgressBar.Large}</li>
 * <li>{@link android.R.style#Widget_ProgressBar_Inverse Widget.ProgressBar.Inverse}</li>
 * <li>{@link android.R.style#Widget_ProgressBar_Small_Inverse
 * Widget.ProgressBar.Small.Inverse}</li>
 * <li>{@link android.R.style#Widget_ProgressBar_Large_Inverse
 * Widget.ProgressBar.Large.Inverse}</li>
 * </ul>
 * <p>The "inverse" styles provide an inverse color scheme for the spinner, which may be necessary
 * if your application uses a light colored theme (a white background).</p>
 *
 * <p><strong>XML attributes</b></strong>
 * <p>
 * See {@link android.R.styleable#ProgressBar ProgressBar Attributes},
 * {@link android.R.styleable#View View Attributes}
 * </p>
 *
 * @attr ref android.R.styleable#ProgressBar_animationResolution
 * @attr ref android.R.styleable#ProgressBar_indeterminate
 * @attr ref android.R.styleable#ProgressBar_indeterminateBehavior
 * @attr ref android.R.styleable#ProgressBar_indeterminateDrawable
 * @attr ref android.R.styleable#ProgressBar_indeterminateDuration
 * @attr ref android.R.styleable#ProgressBar_indeterminateOnly
 * @attr ref android.R.styleable#ProgressBar_interpolator
 * @attr ref android.R.styleable#ProgressBar_min
 * @attr ref android.R.styleable#ProgressBar_max
 * @attr ref android.R.styleable#ProgressBar_maxHeight
 * @attr ref android.R.styleable#ProgressBar_maxWidth
 * @attr ref android.R.styleable#ProgressBar_minHeight
 * @attr ref android.R.styleable#ProgressBar_minWidth
 * @attr ref android.R.styleable#ProgressBar_mirrorForRtl
 * @attr ref android.R.styleable#ProgressBar_progress
 * @attr ref android.R.styleable#ProgressBar_progressDrawable
 * @attr ref android.R.styleable#ProgressBar_secondaryProgress
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@android.widget.RemoteViews.RemoteView public class ProgressBar extends android.view.View {

/**
 * Create a new progress bar with range 0...100 and initial progress of 0.
 * @param context the application environment
 */

public ProgressBar(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ProgressBar(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ProgressBar(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public ProgressBar(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * <p>Indicate whether this progress bar is in indeterminate mode.</p>
 *
 * @return true if the progress bar is in indeterminate mode
 */

@android.view.ViewDebug.ExportedProperty(category="progress") public synchronized boolean isIndeterminate() { throw new RuntimeException("Stub!"); }

/**
 * <p>Change the indeterminate mode for this progress bar. In indeterminate
 * mode, the progress is ignored and the progress bar shows an infinite
 * animation instead.</p>
 *
 * If this progress bar's style only supports indeterminate mode (such as the circular
 * progress bars), then this will be ignored.
 *
 * @param indeterminate true to enable the indeterminate mode
 */

public synchronized void setIndeterminate(boolean indeterminate) { throw new RuntimeException("Stub!"); }

/**
 * <p>Get the drawable used to draw the progress bar in
 * indeterminate mode.</p>
 *
 * @return a {@link android.graphics.drawable.Drawable} instance
 *
 * @see #setIndeterminateDrawable(android.graphics.drawable.Drawable)
 * @see #setIndeterminate(boolean)
 */

public android.graphics.drawable.Drawable getIndeterminateDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Define the drawable used to draw the progress bar in indeterminate mode.
 *
 * @param d the new drawable
 * @see #getIndeterminateDrawable()
 * @see #setIndeterminate(boolean)
 */

public void setIndeterminateDrawable(android.graphics.drawable.Drawable d) { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the indeterminate drawable. Does not modify the
 * current tint mode, which is {@link PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * Subsequent calls to {@link #setIndeterminateDrawable(Drawable)} will
 * automatically mutate the drawable and apply the specified tint and
 * tint mode using
 * {@link Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_indeterminateTint
 * @see #getIndeterminateTintList()
 * @see Drawable#setTintList(ColorStateList)
 */

public void setIndeterminateTintList(@androidx.annotation.RecentlyNullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * @return the tint applied to the indeterminate drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_indeterminateTint
 * @see #setIndeterminateTintList(ColorStateList)
 */

@androidx.annotation.RecentlyNullable public android.content.res.ColorStateList getIndeterminateTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setIndeterminateTintList(ColorStateList)} to the indeterminate
 * drawable. The default mode is {@link PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_indeterminateTintMode
 * @see #setIndeterminateTintList(ColorStateList)
 * @see Drawable#setTintMode(PorterDuff.Mode)
 */

public void setIndeterminateTintMode(@androidx.annotation.RecentlyNullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to the indeterminate
 * drawable, if specified.
 *
 * @return the blending mode used to apply the tint to the indeterminate
 *         drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_indeterminateTintMode
 * @see #setIndeterminateTintMode(PorterDuff.Mode)
 */

@androidx.annotation.RecentlyNullable public android.graphics.PorterDuff.Mode getIndeterminateTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Define the tileable drawable used to draw the progress bar in
 * indeterminate mode.
 * <p>
 * If the drawable is a BitmapDrawable or contains BitmapDrawables, a
 * tiled copy will be generated for display as a progress bar.
 *
 * @param d the new drawable
 * @see #getIndeterminateDrawable()
 * @see #setIndeterminate(boolean)
 */

public void setIndeterminateDrawableTiled(android.graphics.drawable.Drawable d) { throw new RuntimeException("Stub!"); }

/**
 * <p>Get the drawable used to draw the progress bar in
 * progress mode.</p>
 *
 * @return a {@link android.graphics.drawable.Drawable} instance
 *
 * @see #setProgressDrawable(android.graphics.drawable.Drawable)
 * @see #setIndeterminate(boolean)
 */

public android.graphics.drawable.Drawable getProgressDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Define the drawable used to draw the progress bar in progress mode.
 *
 * @param d the new drawable
 * @see #getProgressDrawable()
 * @see #setIndeterminate(boolean)
 */

public void setProgressDrawable(android.graphics.drawable.Drawable d) { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the progress indicator, if one exists, or to the
 * entire progress drawable otherwise. Does not modify the current tint
 * mode, which is {@link PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * The progress indicator should be specified as a layer with
 * id {@link android.R.id#progress} in a {@link LayerDrawable}
 * used as the progress drawable.
 * <p>
 * Subsequent calls to {@link #setProgressDrawable(Drawable)} will
 * automatically mutate the drawable and apply the specified tint and
 * tint mode using
 * {@link Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_progressTint
 * @see #getProgressTintList()
 * @see Drawable#setTintList(ColorStateList)
 */

public void setProgressTintList(@androidx.annotation.RecentlyNullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the tint applied to the progress drawable, if specified.
 *
 * @return the tint applied to the progress drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_progressTint
 * @see #setProgressTintList(ColorStateList)
 */

@androidx.annotation.RecentlyNullable public android.content.res.ColorStateList getProgressTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setProgressTintList(ColorStateList)}} to the progress
 * indicator. The default mode is {@link PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_progressTintMode
 * @see #getProgressTintMode()
 * @see Drawable#setTintMode(PorterDuff.Mode)
 */

public void setProgressTintMode(@androidx.annotation.RecentlyNullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to the progress
 * drawable, if specified.
 *
 * @return the blending mode used to apply the tint to the progress
 *         drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_progressTintMode
 * @see #setProgressTintMode(PorterDuff.Mode)
 */

@androidx.annotation.RecentlyNullable public android.graphics.PorterDuff.Mode getProgressTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the progress background, if one exists. Does not
 * modify the current tint mode, which is
 * {@link PorterDuff.Mode#SRC_ATOP} by default.
 * <p>
 * The progress background must be specified as a layer with
 * id {@link android.R.id#background} in a {@link LayerDrawable}
 * used as the progress drawable.
 * <p>
 * Subsequent calls to {@link #setProgressDrawable(Drawable)} where the
 * drawable contains a progress background will automatically mutate the
 * drawable and apply the specified tint and tint mode using
 * {@link Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_progressBackgroundTint
 * @see #getProgressBackgroundTintList()
 * @see Drawable#setTintList(ColorStateList)
 */

public void setProgressBackgroundTintList(@androidx.annotation.RecentlyNullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the tint applied to the progress background, if specified.
 *
 * @return the tint applied to the progress background
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_progressBackgroundTint
 * @see #setProgressBackgroundTintList(ColorStateList)
 */

@androidx.annotation.RecentlyNullable public android.content.res.ColorStateList getProgressBackgroundTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setProgressBackgroundTintList(ColorStateList)}} to the progress
 * background. The default mode is {@link PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_progressBackgroundTintMode
 * @see #setProgressBackgroundTintList(ColorStateList)
 * @see Drawable#setTintMode(PorterDuff.Mode)
 */

public void setProgressBackgroundTintMode(@androidx.annotation.RecentlyNullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * @return the blending mode used to apply the tint to the progress
 *         background
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_progressBackgroundTintMode
 * @see #setProgressBackgroundTintMode(PorterDuff.Mode)
 */

@androidx.annotation.RecentlyNullable public android.graphics.PorterDuff.Mode getProgressBackgroundTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the secondary progress indicator, if one exists.
 * Does not modify the current tint mode, which is
 * {@link PorterDuff.Mode#SRC_ATOP} by default.
 * <p>
 * The secondary progress indicator must be specified as a layer with
 * id {@link android.R.id#secondaryProgress} in a {@link LayerDrawable}
 * used as the progress drawable.
 * <p>
 * Subsequent calls to {@link #setProgressDrawable(Drawable)} where the
 * drawable contains a secondary progress indicator will automatically
 * mutate the drawable and apply the specified tint and tint mode using
 * {@link Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_secondaryProgressTint
 * @see #getSecondaryProgressTintList()
 * @see Drawable#setTintList(ColorStateList)
 */

public void setSecondaryProgressTintList(@androidx.annotation.RecentlyNullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * Returns the tint applied to the secondary progress drawable, if
 * specified.
 *
 * @return the tint applied to the secondary progress drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_secondaryProgressTint
 * @see #setSecondaryProgressTintList(ColorStateList)
 */

@androidx.annotation.RecentlyNullable public android.content.res.ColorStateList getSecondaryProgressTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setSecondaryProgressTintList(ColorStateList)}} to the secondary
 * progress indicator. The default mode is
 * {@link PorterDuff.Mode#SRC_ATOP}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_secondaryProgressTintMode
 * @see #setSecondaryProgressTintList(ColorStateList)
 * @see Drawable#setTintMode(PorterDuff.Mode)
 */

public void setSecondaryProgressTintMode(@androidx.annotation.RecentlyNullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the blending mode used to apply the tint to the secondary
 * progress drawable, if specified.
 *
 * @return the blending mode used to apply the tint to the secondary
 *         progress drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#ProgressBar_secondaryProgressTintMode
 * @see #setSecondaryProgressTintMode(PorterDuff.Mode)
 */

@androidx.annotation.RecentlyNullable public android.graphics.PorterDuff.Mode getSecondaryProgressTintMode() { throw new RuntimeException("Stub!"); }

/**
 * Define the tileable drawable used to draw the progress bar in
 * progress mode.
 * <p>
 * If the drawable is a BitmapDrawable or contains BitmapDrawables, a
 * tiled copy will be generated for display as a progress bar.
 *
 * @param d the new drawable
 * @see #getProgressDrawable()
 * @see #setIndeterminate(boolean)
 */

public void setProgressDrawableTiled(android.graphics.drawable.Drawable d) { throw new RuntimeException("Stub!"); }

/**
 * @param who This value must never be {@code null}.
 */

protected boolean verifyDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

public void jumpDrawablesToCurrentState() { throw new RuntimeException("Stub!"); }

public void postInvalidate() { throw new RuntimeException("Stub!"); }

/**
 * Sets the current progress to the specified value. Does not do anything
 * if the progress bar is in indeterminate mode.
 * <p>
 * This method will immediately update the visual position of the progress
 * indicator. To animate the visual position to the target value, use
 * {@link #setProgress(int, boolean)}}.
 *
 * @param progress the new progress, between {@link #getMin()} and {@link #getMax()}
 *
 * @see #setIndeterminate(boolean)
 * @see #isIndeterminate()
 * @see #getProgress()
 * @see #incrementProgressBy(int)
 */

public synchronized void setProgress(int progress) { throw new RuntimeException("Stub!"); }

/**
 * Sets the current progress to the specified value, optionally animating
 * the visual position between the current and target values.
 * <p>
 * Animation does not affect the result of {@link #getProgress()}, which
 * will return the target value immediately after this method is called.
 *
 * @param progress the new progress value, between {@link #getMin()} and {@link #getMax()}
 * @param animate {@code true} to animate between the current and target
 *                values or {@code false} to not animate
 */

public void setProgress(int progress, boolean animate) { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Set the current secondary progress to the specified value. Does not do
 * anything if the progress bar is in indeterminate mode.
 * </p>
 *
 * @param secondaryProgress the new secondary progress, between {@link #getMin()} and
 * {@link #getMax()}
 * @see #setIndeterminate(boolean)
 * @see #isIndeterminate()
 * @see #getSecondaryProgress()
 * @see #incrementSecondaryProgressBy(int)
 */

public synchronized void setSecondaryProgress(int secondaryProgress) { throw new RuntimeException("Stub!"); }

/**
 * <p>Get the progress bar's current level of progress. Return 0 when the
 * progress bar is in indeterminate mode.</p>
 *
 * @return the current progress, between {@link #getMin()} and {@link #getMax()}
 *
 * @see #setIndeterminate(boolean)
 * @see #isIndeterminate()
 * @see #setProgress(int)
 * @see #setMax(int)
 * @see #getMax()
 */

@android.view.ViewDebug.ExportedProperty(category="progress") public synchronized int getProgress() { throw new RuntimeException("Stub!"); }

/**
 * <p>Get the progress bar's current level of secondary progress. Return 0 when the
 * progress bar is in indeterminate mode.</p>
 *
 * @return the current secondary progress, between {@link #getMin()} and {@link #getMax()}
 *
 * @see #setIndeterminate(boolean)
 * @see #isIndeterminate()
 * @see #setSecondaryProgress(int)
 * @see #setMax(int)
 * @see #getMax()
 */

@android.view.ViewDebug.ExportedProperty(category="progress") public synchronized int getSecondaryProgress() { throw new RuntimeException("Stub!"); }

/**
 * <p>Return the lower limit of this progress bar's range.</p>
 *
 * @return a positive integer
 *
 * @see #setMin(int)
 * @see #getProgress()
 * @see #getSecondaryProgress()
 */

@android.view.ViewDebug.ExportedProperty(category="progress") public synchronized int getMin() { throw new RuntimeException("Stub!"); }

/**
 * <p>Return the upper limit of this progress bar's range.</p>
 *
 * @return a positive integer
 *
 * @see #setMax(int)
 * @see #getProgress()
 * @see #getSecondaryProgress()
 */

@android.view.ViewDebug.ExportedProperty(category="progress") public synchronized int getMax() { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the lower range of the progress bar to <tt>min</tt>.</p>
 *
 * @param min the lower range of this progress bar
 *
 * @see #getMin()
 * @see #setProgress(int)
 * @see #setSecondaryProgress(int)
 */

public synchronized void setMin(int min) { throw new RuntimeException("Stub!"); }

/**
 * <p>Set the upper range of the progress bar <tt>max</tt>.</p>
 *
 * @param max the upper range of this progress bar
 *
 * @see #getMax()
 * @see #setProgress(int)
 * @see #setSecondaryProgress(int)
 */

public synchronized void setMax(int max) { throw new RuntimeException("Stub!"); }

/**
 * <p>Increase the progress bar's progress by the specified amount.</p>
 *
 * @param diff the amount by which the progress must be increased
 *
 * @see #setProgress(int)
 */

public final synchronized void incrementProgressBy(int diff) { throw new RuntimeException("Stub!"); }

/**
 * <p>Increase the progress bar's secondary progress by the specified amount.</p>
 *
 * @param diff the amount by which the secondary progress must be increased
 *
 * @see #setSecondaryProgress(int)
 */

public final synchronized void incrementSecondaryProgressBy(int diff) { throw new RuntimeException("Stub!"); }

/**
 * Sets the acceleration curve for the indeterminate animation.
 * The interpolator is loaded as a resource from the specified context.
 *
 * @param context The application environment
 * @param resID The resource identifier of the interpolator to load
 */

public void setInterpolator(android.content.Context context, int resID) { throw new RuntimeException("Stub!"); }

/**
 * Sets the acceleration curve for the indeterminate animation.
 * Defaults to a linear interpolation.
 *
 * @param interpolator The interpolator which defines the acceleration curve
 */

public void setInterpolator(android.view.animation.Interpolator interpolator) { throw new RuntimeException("Stub!"); }

/**
 * Gets the acceleration curve type for the indeterminate animation.
 *
 * @return the {@link Interpolator} associated to this animation
 */

public android.view.animation.Interpolator getInterpolator() { throw new RuntimeException("Stub!"); }

public void onVisibilityAggregated(boolean isVisible) { throw new RuntimeException("Stub!"); }

/**
 * @param dr This value must never be {@code null}.
 */

public void invalidateDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable dr) { throw new RuntimeException("Stub!"); }

protected void onSizeChanged(int w, int h, int oldw, int oldh) { throw new RuntimeException("Stub!"); }

protected synchronized void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

public void drawableHotspotChanged(float x, float y) { throw new RuntimeException("Stub!"); }

public android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

public void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

protected void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

protected void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the ProgressBar is animating or not. This is essentially the same
 * as whether the ProgressBar is {@link #isIndeterminate() indeterminate} and visible,
 * as indeterminate ProgressBars are always animating, and non-indeterminate
 * ProgressBars are not animating.
 *
 * @return true if the ProgressBar is animating, false otherwise.
 */

public boolean isAnimating() { throw new RuntimeException("Stub!"); }
}

