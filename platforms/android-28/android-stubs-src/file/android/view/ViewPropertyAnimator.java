/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.view;

import android.animation.Animator;
import java.util.Set;
import android.animation.ValueAnimator;
import android.animation.TimeInterpolator;

/**
 * This class enables automatic and optimized animation of select properties on View objects.
 * If only one or two properties on a View object are being animated, then using an
 * {@link android.animation.ObjectAnimator} is fine; the property setters called by ObjectAnimator
 * are well equipped to do the right thing to set the property and invalidate the view
 * appropriately. But if several properties are animated simultaneously, or if you just want a
 * more convenient syntax to animate a specific property, then ViewPropertyAnimator might be
 * more well-suited to the task.
 *
 * <p>This class may provide better performance for several simultaneous animations, because
 * it will optimize invalidate calls to take place only once for several properties instead of each
 * animated property independently causing its own invalidation. Also, the syntax of using this
 * class could be easier to use because the caller need only tell the View object which
 * property to animate, and the value to animate either to or by, and this class handles the
 * details of configuring the underlying Animator class and starting it.</p>
 *
 * <p>This class is not constructed by the caller, but rather by the View whose properties
 * it will animate. Calls to {@link android.view.View#animate()} will return a reference
 * to the appropriate ViewPropertyAnimator object for that View.</p>
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ViewPropertyAnimator {

/**
 * Constructor, called by View. This is private by design, as the user should only
 * get a ViewPropertyAnimator by calling View.animate().
 *
 * @param view The View associated with this ViewPropertyAnimator
 */

ViewPropertyAnimator(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Sets the duration for the underlying animator that animates the requested properties.
 * By default, the animator uses the default value for ValueAnimator. Calling this method
 * will cause the declared value to be used instead.
 * @param duration The length of ensuing property animations, in milliseconds. The value
 * cannot be negative.
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator setDuration(long duration) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current duration of property animations. If the duration was set on this
 * object, that value is returned. Otherwise, the default value of the underlying Animator
 * is returned.
 *
 * @see #setDuration(long)
 * @return The duration of animations, in milliseconds.
 */

public long getDuration() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current startDelay of property animations. If the startDelay was set on this
 * object, that value is returned. Otherwise, the default value of the underlying Animator
 * is returned.
 *
 * @see #setStartDelay(long)
 * @return The startDelay of animations, in milliseconds.
 */

public long getStartDelay() { throw new RuntimeException("Stub!"); }

/**
 * Sets the startDelay for the underlying animator that animates the requested properties.
 * By default, the animator uses the default value for ValueAnimator. Calling this method
 * will cause the declared value to be used instead.
 * @param startDelay The delay of ensuing property animations, in milliseconds. The value
 * cannot be negative.
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator setStartDelay(long startDelay) { throw new RuntimeException("Stub!"); }

/**
 * Sets the interpolator for the underlying animator that animates the requested properties.
 * By default, the animator uses the default interpolator for ValueAnimator. Calling this method
 * will cause the declared object to be used instead.
 *
 * @param interpolator The TimeInterpolator to be used for ensuing property animations. A value
 * of <code>null</code> will result in linear interpolation.
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator setInterpolator(android.animation.TimeInterpolator interpolator) { throw new RuntimeException("Stub!"); }

/**
 * Returns the timing interpolator that this animation uses.
 *
 * @return The timing interpolator for this animation.
 */

public android.animation.TimeInterpolator getInterpolator() { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener for events in the underlying Animators that run the property
 * animations.
 *
 * @see Animator.AnimatorListener
 *
 * @param listener The listener to be called with AnimatorListener events. A value of
 * <code>null</code> removes any existing listener.
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator setListener(android.animation.Animator.AnimatorListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a listener for update events in the underlying ValueAnimator that runs
 * the property animations. Note that the underlying animator is animating between
 * 0 and 1 (these values are then turned into the actual property values internally
 * by ViewPropertyAnimator). So the animator cannot give information on the current
 * values of the properties being animated by this ViewPropertyAnimator, although
 * the view object itself can be queried to get the current values.
 *
 * @see android.animation.ValueAnimator.AnimatorUpdateListener
 *
 * @param listener The listener to be called with update events. A value of
 * <code>null</code> removes any existing listener.
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator setUpdateListener(android.animation.ValueAnimator.AnimatorUpdateListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Starts the currently pending property animations immediately. Calling <code>start()</code>
 * is optional because all animations start automatically at the next opportunity. However,
 * if the animations are needed to start immediately and synchronously (not at the time when
 * the next event is processed by the hierarchy, which is when the animations would begin
 * otherwise), then this method can be used.
 */

public void start() { throw new RuntimeException("Stub!"); }

/**
 * Cancels all property animations that are currently running or pending.
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>x</code> property to be animated to the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The value to be animated to.
 * @see View#setX(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator x(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>x</code> property to be animated by the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The amount to be animated by, as an offset from the current value.
 * @see View#setX(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator xBy(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>y</code> property to be animated to the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The value to be animated to.
 * @see View#setY(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator y(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>y</code> property to be animated by the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The amount to be animated by, as an offset from the current value.
 * @see View#setY(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator yBy(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>z</code> property to be animated to the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The value to be animated to.
 * @see View#setZ(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator z(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>z</code> property to be animated by the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The amount to be animated by, as an offset from the current value.
 * @see View#setZ(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator zBy(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>rotation</code> property to be animated to the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The value to be animated to.
 * @see View#setRotation(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator rotation(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>rotation</code> property to be animated by the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The amount to be animated by, as an offset from the current value.
 * @see View#setRotation(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator rotationBy(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>rotationX</code> property to be animated to the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The value to be animated to.
 * @see View#setRotationX(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator rotationX(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>rotationX</code> property to be animated by the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The amount to be animated by, as an offset from the current value.
 * @see View#setRotationX(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator rotationXBy(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>rotationY</code> property to be animated to the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The value to be animated to.
 * @see View#setRotationY(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator rotationY(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>rotationY</code> property to be animated by the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The amount to be animated by, as an offset from the current value.
 * @see View#setRotationY(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator rotationYBy(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>translationX</code> property to be animated to the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The value to be animated to.
 * @see View#setTranslationX(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator translationX(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>translationX</code> property to be animated by the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The amount to be animated by, as an offset from the current value.
 * @see View#setTranslationX(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator translationXBy(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>translationY</code> property to be animated to the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The value to be animated to.
 * @see View#setTranslationY(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator translationY(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>translationY</code> property to be animated by the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The amount to be animated by, as an offset from the current value.
 * @see View#setTranslationY(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator translationYBy(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>translationZ</code> property to be animated to the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The value to be animated to.
 * @see View#setTranslationZ(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator translationZ(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>translationZ</code> property to be animated by the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The amount to be animated by, as an offset from the current value.
 * @see View#setTranslationZ(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator translationZBy(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>scaleX</code> property to be animated to the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The value to be animated to.
 * @see View#setScaleX(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator scaleX(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>scaleX</code> property to be animated by the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The amount to be animated by, as an offset from the current value.
 * @see View#setScaleX(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator scaleXBy(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>scaleY</code> property to be animated to the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The value to be animated to.
 * @see View#setScaleY(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator scaleY(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>scaleY</code> property to be animated by the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The amount to be animated by, as an offset from the current value.
 * @see View#setScaleY(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator scaleYBy(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>alpha</code> property to be animated to the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The value to be animated to.
 * @see View#setAlpha(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator alpha(float value) { throw new RuntimeException("Stub!"); }

/**
 * This method will cause the View's <code>alpha</code> property to be animated by the
 * specified value. Animations already running on the property will be canceled.
 *
 * @param value The amount to be animated by, as an offset from the current value.
 * @see View#setAlpha(float)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator alphaBy(float value) { throw new RuntimeException("Stub!"); }

/**
 * The View associated with this ViewPropertyAnimator will have its
 * {@link View#setLayerType(int, android.graphics.Paint) layer type} set to
 * {@link View#LAYER_TYPE_HARDWARE} for the duration of the next animation.
 * As stated in the documentation for {@link View#LAYER_TYPE_HARDWARE},
 * the actual type of layer used internally depends on the runtime situation of the
 * view. If the activity and this view are hardware-accelerated, then the layer will be
 * accelerated as well. If the activity or the view is not accelerated, then the layer will
 * effectively be the same as {@link View#LAYER_TYPE_SOFTWARE}.
 *
 * <p>This state is not persistent, either on the View or on this ViewPropertyAnimator: the
 * layer type of the View will be restored when the animation ends to what it was when this
 * method was called, and this setting on ViewPropertyAnimator is only valid for the next
 * animation. Note that calling this method and then independently setting the layer type of
 * the View (by a direct call to {@link View#setLayerType(int, android.graphics.Paint)}) will
 * result in some inconsistency, including having the layer type restored to its pre-withLayer()
 * value when the animation ends.</p>
 *
 * @see View#setLayerType(int, android.graphics.Paint)
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator withLayer() { throw new RuntimeException("Stub!"); }

/**
 * Specifies an action to take place when the next animation runs. If there is a
 * {@link #setStartDelay(long) startDelay} set on this ViewPropertyAnimator, then the
 * action will run after that startDelay expires, when the actual animation begins.
 * This method, along with {@link #withEndAction(Runnable)}, is intended to help facilitate
 * choreographing ViewPropertyAnimator animations with other animations or actions
 * in the application.
 *
 * @param runnable The action to run when the next animation starts.
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator withStartAction(java.lang.Runnable runnable) { throw new RuntimeException("Stub!"); }

/**
 * Specifies an action to take place when the next animation ends. The action is only
 * run if the animation ends normally; if the ViewPropertyAnimator is canceled during
 * that animation, the runnable will not run.
 * This method, along with {@link #withStartAction(Runnable)}, is intended to help facilitate
 * choreographing ViewPropertyAnimator animations with other animations or actions
 * in the application.
 *
 * <p>For example, the following code animates a view to x=200 and then back to 0:</p>
 * <pre>
 *     Runnable endAction = new Runnable() {
 *         public void run() {
 *             view.animate().x(0);
 *         }
 *     };
 *     view.animate().x(200).withEndAction(endAction);
 * </pre>
 *
 * @param runnable The action to run when the next animation ends.
 * @return This object, allowing calls to methods in this class to be chained.
 */

public android.view.ViewPropertyAnimator withEndAction(java.lang.Runnable runnable) { throw new RuntimeException("Stub!"); }
}

