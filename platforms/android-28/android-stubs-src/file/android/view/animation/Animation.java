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


package android.view.animation;


/**
 * Abstraction for an Animation that can be applied to Views, Surfaces, or
 * other objects. See the {@link android.view.animation animation package
 * description file}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Animation implements java.lang.Cloneable {

/**
 * Creates a new animation with a duration of 0ms, the default interpolator, with
 * fillBefore set to true and fillAfter set to false
 */

public Animation() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new animation whose parameters come from the specified context and
 * attributes set.
 *
 * @param context the application environment
 * @param attrs the set of attributes holding the animation parameters
 */

public Animation(android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

protected android.view.animation.Animation clone() throws java.lang.CloneNotSupportedException { throw new RuntimeException("Stub!"); }

/**
 * Reset the initialization state of this animation.
 *
 * @see #initialize(int, int, int, int)
 */

public void reset() { throw new RuntimeException("Stub!"); }

/**
 * Cancel the animation. Cancelling an animation invokes the animation
 * listener, if set, to notify the end of the animation.
 *
 * If you cancel an animation manually, you must call {@link #reset()}
 * before starting the animation again.
 *
 * @see #reset()
 * @see #start()
 * @see #startNow()
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * Whether or not the animation has been initialized.
 *
 * @return Has this animation been initialized.
 * @see #initialize(int, int, int, int)
 */

public boolean isInitialized() { throw new RuntimeException("Stub!"); }

/**
 * Initialize this animation with the dimensions of the object being
 * animated as well as the objects parents. (This is to support animation
 * sizes being specified relative to these dimensions.)
 *
 * <p>Objects that interpret Animations should call this method when
 * the sizes of the object being animated and its parent are known, and
 * before calling {@link #getTransformation}.
 *
 *
 * @param width Width of the object being animated
 * @param height Height of the object being animated
 * @param parentWidth Width of the animated object's parent
 * @param parentHeight Height of the animated object's parent
 */

public void initialize(int width, int height, int parentWidth, int parentHeight) { throw new RuntimeException("Stub!"); }

/**
 * Sets the acceleration curve for this animation. The interpolator is loaded as
 * a resource from the specified context.
 *
 * @param context The application environment
 * @param resID The resource identifier of the interpolator to load
 * @attr ref android.R.styleable#Animation_interpolator
 */

public void setInterpolator(android.content.Context context, int resID) { throw new RuntimeException("Stub!"); }

/**
 * Sets the acceleration curve for this animation. Defaults to a linear
 * interpolation.
 *
 * @param i The interpolator which defines the acceleration curve
 * @attr ref android.R.styleable#Animation_interpolator
 */

public void setInterpolator(android.view.animation.Interpolator i) { throw new RuntimeException("Stub!"); }

/**
 * When this animation should start relative to the start time. This is most
 * useful when composing complex animations using an {@link AnimationSet }
 * where some of the animations components start at different times.
 *
 * @param startOffset When this Animation should start, in milliseconds from
 *                    the start time of the root AnimationSet.
 * @attr ref android.R.styleable#Animation_startOffset
 */

public void setStartOffset(long startOffset) { throw new RuntimeException("Stub!"); }

/**
 * How long this animation should last. The duration cannot be negative.
 *
 * @param durationMillis Duration in milliseconds
 *
 * @throws java.lang.IllegalArgumentException if the duration is < 0
 *
 * @attr ref android.R.styleable#Animation_duration
 */

public void setDuration(long durationMillis) { throw new RuntimeException("Stub!"); }

/**
 * Ensure that the duration that this animation will run is not longer
 * than <var>durationMillis</var>.  In addition to adjusting the duration
 * itself, this ensures that the repeat count also will not make it run
 * longer than the given time.
 *
 * @param durationMillis The maximum duration the animation is allowed
 * to run.
 */

public void restrictDuration(long durationMillis) { throw new RuntimeException("Stub!"); }

/**
 * How much to scale the duration by.
 *
 * @param scale The amount to scale the duration.
 */

public void scaleCurrentDuration(float scale) { throw new RuntimeException("Stub!"); }

/**
 * When this animation should start. When the start time is set to
 * {@link #START_ON_FIRST_FRAME}, the animation will start the first time
 * {@link #getTransformation(long, Transformation)} is invoked. The time passed
 * to this method should be obtained by calling
 * {@link AnimationUtils#currentAnimationTimeMillis()} instead of
 * {@link System#currentTimeMillis()}.
 *
 * @param startTimeMillis the start time in milliseconds
 */

public void setStartTime(long startTimeMillis) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to start the animation the first time
 * {@link #getTransformation(long, Transformation)} is invoked.
 */

public void start() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to start the animation at the current time in
 * milliseconds.
 */

public void startNow() { throw new RuntimeException("Stub!"); }

/**
 * Defines what this animation should do when it reaches the end. This
 * setting is applied only when the repeat count is either greater than
 * 0 or {@link #INFINITE}. Defaults to {@link #RESTART}.
 *
 * @param repeatMode {@link #RESTART} or {@link #REVERSE}
 * @attr ref android.R.styleable#Animation_repeatMode
 */

public void setRepeatMode(int repeatMode) { throw new RuntimeException("Stub!"); }

/**
 * Sets how many times the animation should be repeated. If the repeat
 * count is 0, the animation is never repeated. If the repeat count is
 * greater than 0 or {@link #INFINITE}, the repeat mode will be taken
 * into account. The repeat count is 0 by default.
 *
 * @param repeatCount the number of times the animation should be repeated
 * @attr ref android.R.styleable#Animation_repeatCount
 */

public void setRepeatCount(int repeatCount) { throw new RuntimeException("Stub!"); }

/**
 * If fillEnabled is true, this animation will apply the value of fillBefore.
 *
 * @return true if the animation will take fillBefore into account
 * @attr ref android.R.styleable#Animation_fillEnabled
 */

public boolean isFillEnabled() { throw new RuntimeException("Stub!"); }

/**
 * If fillEnabled is true, the animation will apply the value of fillBefore.
 * Otherwise, fillBefore is ignored and the animation
 * transformation is always applied until the animation ends.
 *
 * @param fillEnabled true if the animation should take the value of fillBefore into account
 * @attr ref android.R.styleable#Animation_fillEnabled
 *
 * @see #setFillBefore(boolean)
 * @see #setFillAfter(boolean)
 */

public void setFillEnabled(boolean fillEnabled) { throw new RuntimeException("Stub!"); }

/**
 * If fillBefore is true, this animation will apply its transformation
 * before the start time of the animation. Defaults to true if
 * {@link #setFillEnabled(boolean)} is not set to true.
 * Note that this applies when using an {@link
 * android.view.animation.AnimationSet AnimationSet} to chain
 * animations. The transformation is not applied before the AnimationSet
 * itself starts.
 *
 * @param fillBefore true if the animation should apply its transformation before it starts
 * @attr ref android.R.styleable#Animation_fillBefore
 *
 * @see #setFillEnabled(boolean)
 */

public void setFillBefore(boolean fillBefore) { throw new RuntimeException("Stub!"); }

/**
 * If fillAfter is true, the transformation that this animation performed
 * will persist when it is finished. Defaults to false if not set.
 * Note that this applies to individual animations and when using an {@link
 * android.view.animation.AnimationSet AnimationSet} to chain
 * animations.
 *
 * @param fillAfter true if the animation should apply its transformation after it ends
 * @attr ref android.R.styleable#Animation_fillAfter
 *
 * @see #setFillEnabled(boolean)
 */

public void setFillAfter(boolean fillAfter) { throw new RuntimeException("Stub!"); }

/**
 * Set the Z ordering mode to use while running the animation.
 *
 * @param zAdjustment The desired mode, one of {@link #ZORDER_NORMAL},
 * {@link #ZORDER_TOP}, or {@link #ZORDER_BOTTOM}.
 * @attr ref android.R.styleable#Animation_zAdjustment
 */

public void setZAdjustment(int zAdjustment) { throw new RuntimeException("Stub!"); }

/**
 * Set background behind animation.
 *
 * @param bg The background color.  If 0, no background.  Currently must
 * be black, with any desired alpha level.
 */

public void setBackgroundColor(int bg) { throw new RuntimeException("Stub!"); }

/**
 * The scale factor is set by the call to <code>getTransformation</code>. Overrides of
 * {@link #getTransformation(long, Transformation, float)} will get this value
 * directly. Overrides of {@link #applyTransformation(float, Transformation)} can
 * call this method to get the value.
 *
 * @return float The scale factor that should be applied to pre-scaled values in
 * an Animation such as the pivot points in {@link ScaleAnimation} and {@link RotateAnimation}.
 */

protected float getScaleFactor() { throw new RuntimeException("Stub!"); }

/**
 * If detachWallpaper is true, and this is a window animation of a window
 * that has a wallpaper background, then the window will be detached from
 * the wallpaper while it runs.  That is, the animation will only be applied
 * to the window, and the wallpaper behind it will remain static.
 *
 * @param detachWallpaper true if the wallpaper should be detached from the animation
 * @attr ref android.R.styleable#Animation_detachWallpaper
 */

public void setDetachWallpaper(boolean detachWallpaper) { throw new RuntimeException("Stub!"); }

/**
 * Gets the acceleration curve type for this animation.
 *
 * @return the {@link Interpolator} associated to this animation
 * @attr ref android.R.styleable#Animation_interpolator
 */

public android.view.animation.Interpolator getInterpolator() { throw new RuntimeException("Stub!"); }

/**
 * When this animation should start. If the animation has not startet yet,
 * this method might return {@link #START_ON_FIRST_FRAME}.
 *
 * @return the time in milliseconds when the animation should start or
 *         {@link #START_ON_FIRST_FRAME}
 */

public long getStartTime() { throw new RuntimeException("Stub!"); }

/**
 * How long this animation should last
 *
 * @return the duration in milliseconds of the animation
 * @attr ref android.R.styleable#Animation_duration
 */

public long getDuration() { throw new RuntimeException("Stub!"); }

/**
 * When this animation should start, relative to StartTime
 *
 * @return the start offset in milliseconds
 * @attr ref android.R.styleable#Animation_startOffset
 */

public long getStartOffset() { throw new RuntimeException("Stub!"); }

/**
 * Defines what this animation should do when it reaches the end.
 *
 * @return either one of {@link #REVERSE} or {@link #RESTART}
 * @attr ref android.R.styleable#Animation_repeatMode
 */

public int getRepeatMode() { throw new RuntimeException("Stub!"); }

/**
 * Defines how many times the animation should repeat. The default value
 * is 0.
 *
 * @return the number of times the animation should repeat, or {@link #INFINITE}
 * @attr ref android.R.styleable#Animation_repeatCount
 */

public int getRepeatCount() { throw new RuntimeException("Stub!"); }

/**
 * If fillBefore is true, this animation will apply its transformation
 * before the start time of the animation. If fillBefore is false and
 * {@link #isFillEnabled() fillEnabled} is true, the transformation will not be applied until
 * the start time of the animation.
 *
 * @return true if the animation applies its transformation before it starts
 * @attr ref android.R.styleable#Animation_fillBefore
 */

public boolean getFillBefore() { throw new RuntimeException("Stub!"); }

/**
 * If fillAfter is true, this animation will apply its transformation
 * after the end time of the animation.
 *
 * @return true if the animation applies its transformation after it ends
 * @attr ref android.R.styleable#Animation_fillAfter
 */

public boolean getFillAfter() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Z ordering mode to use while running the animation as
 * previously set by {@link #setZAdjustment}.
 *
 * @return Returns one of {@link #ZORDER_NORMAL},
 * {@link #ZORDER_TOP}, or {@link #ZORDER_BOTTOM}.
 * @attr ref android.R.styleable#Animation_zAdjustment
 */

public int getZAdjustment() { throw new RuntimeException("Stub!"); }

/**
 * Returns the background color behind the animation.
 */

public int getBackgroundColor() { throw new RuntimeException("Stub!"); }

/**
 * Return value of {@link #setDetachWallpaper(boolean)}.
 * @attr ref android.R.styleable#Animation_detachWallpaper
 */

public boolean getDetachWallpaper() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether or not this animation will affect the transformation
 * matrix. For instance, a fade animation will not affect the matrix whereas
 * a scale animation will.</p>
 *
 * @return true if this animation will change the transformation matrix
 */

public boolean willChangeTransformationMatrix() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether or not this animation will affect the bounds of the
 * animated view. For instance, a fade animation will not affect the bounds
 * whereas a 200% scale animation will.</p>
 *
 * @return true if this animation will change the view's bounds
 */

public boolean willChangeBounds() { throw new RuntimeException("Stub!"); }

/**
 * <p>Binds an animation listener to this animation. The animation listener
 * is notified of animation events such as the end of the animation or the
 * repetition of the animation.</p>
 *
 * @param listener the animation listener to be notified
 */

public void setAnimationListener(android.view.animation.Animation.AnimationListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Gurantees that this animation has an interpolator. Will use
 * a AccelerateDecelerateInterpolator is nothing else was specified.
 */

protected void ensureInterpolator() { throw new RuntimeException("Stub!"); }

/**
 * Compute a hint at how long the entire animation may last, in milliseconds.
 * Animations can be written to cause themselves to run for a different
 * duration than what is computed here, but generally this should be
 * accurate.
 */

public long computeDurationHint() { throw new RuntimeException("Stub!"); }

/**
 * Gets the transformation to apply at a specified point in time. Implementations of this
 * method should always replace the specified Transformation or document they are doing
 * otherwise.
 *
 * @param currentTime Where we are in the animation. This is wall clock time.
 * @param outTransformation A transformation object that is provided by the
 *        caller and will be filled in by the animation.
 * @return True if the animation is still running
 */

public boolean getTransformation(long currentTime, android.view.animation.Transformation outTransformation) { throw new RuntimeException("Stub!"); }

/**
 * Gets the transformation to apply at a specified point in time. Implementations of this
 * method should always replace the specified Transformation or document they are doing
 * otherwise.
 *
 * @param currentTime Where we are in the animation. This is wall clock time.
 * @param outTransformation A transformation object that is provided by the
 *        caller and will be filled in by the animation.
 * @param scale Scaling factor to apply to any inputs to the transform operation, such
 *        pivot points being rotated or scaled around.
 * @return True if the animation is still running
 */

public boolean getTransformation(long currentTime, android.view.animation.Transformation outTransformation, float scale) { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether this animation has started or not.</p>
 *
 * @return true if the animation has started, false otherwise
 */

public boolean hasStarted() { throw new RuntimeException("Stub!"); }

/**
 * <p>Indicates whether this animation has ended or not.</p>
 *
 * @return true if the animation has ended, false otherwise
 */

public boolean hasEnded() { throw new RuntimeException("Stub!"); }

/**
 * Helper for getTransformation. Subclasses should implement this to apply
 * their transforms given an interpolation value.  Implementations of this
 * method should always replace the specified Transformation or document
 * they are doing otherwise.
 *
 * @param interpolatedTime The value of the normalized time (0.0 to 1.0)
 *        after it has been run through the interpolation function.
 * @param t The Transformation object to fill in with the current
 *        transforms.
 */

protected void applyTransformation(float interpolatedTime, android.view.animation.Transformation t) { throw new RuntimeException("Stub!"); }

/**
 * Convert the information in the description of a size to an actual
 * dimension
 *
 * @param type One of Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
 *             Animation.RELATIVE_TO_PARENT.
 * @param value The dimension associated with the type parameter
 * @param size The size of the object being animated
 * @param parentSize The size of the parent of the object being animated
 * @return The dimension to use for the animation
 */

protected float resolveSize(int type, float value, int size, int parentSize) { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * The specified dimension is an absolute number of pixels.
 */

public static final int ABSOLUTE = 0; // 0x0

/**
 * Repeat the animation indefinitely.
 */

public static final int INFINITE = -1; // 0xffffffff

/**
 * The specified dimension holds a float and should be multiplied by the
 * height or width of the parent of the object being animated.
 */

public static final int RELATIVE_TO_PARENT = 2; // 0x2

/**
 * The specified dimension holds a float and should be multiplied by the
 * height or width of the object being animated.
 */

public static final int RELATIVE_TO_SELF = 1; // 0x1

/**
 * When the animation reaches the end and the repeat count is INFINTE_REPEAT
 * or a positive value, the animation restarts from the beginning.
 */

public static final int RESTART = 1; // 0x1

/**
 * When the animation reaches the end and the repeat count is INFINTE_REPEAT
 * or a positive value, the animation plays backward (and then forward again).
 */

public static final int REVERSE = 2; // 0x2

/**
 * Can be used as the start time to indicate the start time should be the current
 * time when {@link #getTransformation(long, Transformation)} is invoked for the
 * first animation frame. This can is useful for short animations.
 */

public static final int START_ON_FIRST_FRAME = -1; // 0xffffffff

/**
 * Requests that the content being animated be forced under all other
 * content for the duration of the animation.
 */

public static final int ZORDER_BOTTOM = -1; // 0xffffffff

/**
 * Requests that the content being animated be kept in its current Z
 * order.
 */

public static final int ZORDER_NORMAL = 0; // 0x0

/**
 * Requests that the content being animated be forced on top of all other
 * content for the duration of the animation.
 */

public static final int ZORDER_TOP = 1; // 0x1
/**
 * <p>An animation listener receives notifications from an animation.
 * Notifications indicate animation related events, such as the end or the
 * repetition of the animation.</p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface AnimationListener {

/**
 * <p>Notifies the start of the animation.</p>
 *
 * @param animation The started animation.
 */

public void onAnimationStart(android.view.animation.Animation animation);

/**
 * <p>Notifies the end of the animation. This callback is not invoked
 * for animations with repeat count set to INFINITE.</p>
 *
 * @param animation The animation which reached its end.
 */

public void onAnimationEnd(android.view.animation.Animation animation);

/**
 * <p>Notifies the repetition of the animation.</p>
 *
 * @param animation The animation which was repeated.
 */

public void onAnimationRepeat(android.view.animation.Animation animation);
}

/**
 * Utility class to parse a string description of a size.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
protected static class Description {

protected Description() { throw new RuntimeException("Stub!"); }

/**
 * One of Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF, or
 * Animation.RELATIVE_TO_PARENT.
 */

public int type;

/**
 * The absolute or relative dimension for this Description.
 */

public float value;
}

}

