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


package android.animation;

import android.os.Build;
import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.List;

/**
 * This class plays a set of {@link Animator} objects in the specified order. Animations
 * can be set up to play together, in sequence, or after a specified delay.
 *
 * <p>There are two different approaches to adding animations to a <code>AnimatorSet</code>:
 * either the {@link AnimatorSet#playTogether(Animator[]) playTogether()} or
 * {@link AnimatorSet#playSequentially(Animator[]) playSequentially()} methods can be called to add
 * a set of animations all at once, or the {@link AnimatorSet#play(Animator)} can be
 * used in conjunction with methods in the {@link AnimatorSet.Builder Builder}
 * class to add animations
 * one by one.</p>
 *
 * <p>It is possible to set up a <code>AnimatorSet</code> with circular dependencies between
 * its animations. For example, an animation a1 could be set up to start before animation a2, a2
 * before a3, and a3 before a1. The results of this configuration are undefined, but will typically
 * result in none of the affected animations being played. Because of this (and because
 * circular dependencies do not make logical sense anyway), circular dependencies
 * should be avoided, and the dependency flow of animations should only be in one direction.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about animating with {@code AnimatorSet}, read the
 * <a href="{@docRoot}guide/topics/graphics/prop-animation.html#choreography">Property
 * Animation</a> developer guide.</p>
 * </div>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AnimatorSet extends android.animation.Animator {

public AnimatorSet() { throw new RuntimeException("Stub!"); }

/**
 * Sets up this AnimatorSet to play all of the supplied animations at the same time.
 * This is equivalent to calling {@link #play(Animator)} with the first animator in the
 * set and then {@link Builder#with(Animator)} with each of the other animators. Note that
 * an Animator with a {@link Animator#setStartDelay(long) startDelay} will not actually
 * start until that delay elapses, which means that if the first animator in the list
 * supplied to this constructor has a startDelay, none of the other animators will start
 * until that first animator's startDelay has elapsed.
 *
 * @param items The animations that will be started simultaneously.
 */

public void playTogether(android.animation.Animator... items) { throw new RuntimeException("Stub!"); }

/**
 * Sets up this AnimatorSet to play all of the supplied animations at the same time.
 *
 * @param items The animations that will be started simultaneously.
 */

public void playTogether(java.util.Collection<android.animation.Animator> items) { throw new RuntimeException("Stub!"); }

/**
 * Sets up this AnimatorSet to play each of the supplied animations when the
 * previous animation ends.
 *
 * @param items The animations that will be started one after another.
 */

public void playSequentially(android.animation.Animator... items) { throw new RuntimeException("Stub!"); }

/**
 * Sets up this AnimatorSet to play each of the supplied animations when the
 * previous animation ends.
 *
 * @param items The animations that will be started one after another.
 */

public void playSequentially(java.util.List<android.animation.Animator> items) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current list of child Animator objects controlled by this
 * AnimatorSet. This is a copy of the internal list; modifications to the returned list
 * will not affect the AnimatorSet, although changes to the underlying Animator objects
 * will affect those objects being managed by the AnimatorSet.
 *
 * @return ArrayList<Animator> The list of child animations of this AnimatorSet.
 */

public java.util.ArrayList<android.animation.Animator> getChildAnimations() { throw new RuntimeException("Stub!"); }

/**
 * Sets the target object for all current {@link #getChildAnimations() child animations}
 * of this AnimatorSet that take targets ({@link ObjectAnimator} and
 * AnimatorSet).
 *
 * @param target The object being animated
 */

public void setTarget(java.lang.Object target) { throw new RuntimeException("Stub!"); }

/**
 * Sets the TimeInterpolator for all current {@link #getChildAnimations() child animations}
 * of this AnimatorSet. The default value is null, which means that no interpolator
 * is set on this AnimatorSet. Setting the interpolator to any non-null value
 * will cause that interpolator to be set on the child animations
 * when the set is started.
 *
 * @param interpolator the interpolator to be used by each child animation of this AnimatorSet
 */

public void setInterpolator(android.animation.TimeInterpolator interpolator) { throw new RuntimeException("Stub!"); }

public android.animation.TimeInterpolator getInterpolator() { throw new RuntimeException("Stub!"); }

/**
 * This method creates a <code>Builder</code> object, which is used to
 * set up playing constraints. This initial <code>play()</code> method
 * tells the <code>Builder</code> the animation that is the dependency for
 * the succeeding commands to the <code>Builder</code>. For example,
 * calling <code>play(a1).with(a2)</code> sets up the AnimatorSet to play
 * <code>a1</code> and <code>a2</code> at the same time,
 * <code>play(a1).before(a2)</code> sets up the AnimatorSet to play
 * <code>a1</code> first, followed by <code>a2</code>, and
 * <code>play(a1).after(a2)</code> sets up the AnimatorSet to play
 * <code>a2</code> first, followed by <code>a1</code>.
 *
 * <p>Note that <code>play()</code> is the only way to tell the
 * <code>Builder</code> the animation upon which the dependency is created,
 * so successive calls to the various functions in <code>Builder</code>
 * will all refer to the initial parameter supplied in <code>play()</code>
 * as the dependency of the other animations. For example, calling
 * <code>play(a1).before(a2).before(a3)</code> will play both <code>a2</code>
 * and <code>a3</code> when a1 ends; it does not set up a dependency between
 * <code>a2</code> and <code>a3</code>.</p>
 *
 * @param anim The animation that is the dependency used in later calls to the
 * methods in the returned <code>Builder</code> object. A null parameter will result
 * in a null <code>Builder</code> return value.
 * @return Builder The object that constructs the AnimatorSet based on the dependencies
 * outlined in the calls to <code>play</code> and the other methods in the
 * <code>Builder</code object.
 */

public android.animation.AnimatorSet.Builder play(android.animation.Animator anim) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>Note that canceling a <code>AnimatorSet</code> also cancels all of the animations that it
 * is responsible for.</p>
 */

public void cancel() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>Note that ending a <code>AnimatorSet</code> also ends all of the animations that it is
 * responsible for.</p>
 */

public void end() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if any of the child animations of this AnimatorSet have been started and have
 * not yet ended. Child animations will not be started until the AnimatorSet has gone past
 * its initial delay set through {@link #setStartDelay(long)}.
 *
 * @return Whether this AnimatorSet has gone past the initial delay, and at least one child
 *         animation has been started and not yet ended.
 */

public boolean isRunning() { throw new RuntimeException("Stub!"); }

public boolean isStarted() { throw new RuntimeException("Stub!"); }

/**
 * The amount of time, in milliseconds, to delay starting the animation after
 * {@link #start()} is called.
 *
 * @return the number of milliseconds to delay running the animation
 */

public long getStartDelay() { throw new RuntimeException("Stub!"); }

/**
 * The amount of time, in milliseconds, to delay starting the animation after
 * {@link #start()} is called. Note that the start delay should always be non-negative. Any
 * negative start delay will be clamped to 0 on N and above.
 *
 * @param startDelay The amount of the delay, in milliseconds
 */

public void setStartDelay(long startDelay) { throw new RuntimeException("Stub!"); }

/**
 * Gets the length of each of the child animations of this AnimatorSet. This value may
 * be less than 0, which indicates that no duration has been set on this AnimatorSet
 * and each of the child animations will use their own duration.
 *
 * @return The length of the animation, in milliseconds, of each of the child
 * animations of this AnimatorSet.
 */

public long getDuration() { throw new RuntimeException("Stub!"); }

/**
 * Sets the length of each of the current child animations of this AnimatorSet. By default,
 * each child animation will use its own duration. If the duration is set on the AnimatorSet,
 * then each child animation inherits this duration.
 *
 * @param duration The length of the animation, in milliseconds, of each of the child
 * animations of this AnimatorSet.
 */

public android.animation.AnimatorSet setDuration(long duration) { throw new RuntimeException("Stub!"); }

public void setupStartValues() { throw new RuntimeException("Stub!"); }

public void setupEndValues() { throw new RuntimeException("Stub!"); }

public void pause() { throw new RuntimeException("Stub!"); }

public void resume() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>Starting this <code>AnimatorSet</code> will, in turn, start the animations for which
 * it is responsible. The details of when exactly those animations are started depends on
 * the dependency relationships that have been set up between the animations.
 *
 * <b>Note:</b> Manipulating AnimatorSet's lifecycle in the child animators' listener callbacks
 * will lead to undefined behaviors. Also, AnimatorSet will ignore any seeking in the child
 * animators once {@link #start()} is called.
 */

public void start() { throw new RuntimeException("Stub!"); }

/**
 * Sets the position of the animation to the specified point in time. This time should
 * be between 0 and the total duration of the animation, including any repetition. If
 * the animation has not yet been started, then it will not advance forward after it is
 * set to this time; it will simply set the time to this value and perform any appropriate
 * actions based on that time. If the animation is already running, then setCurrentPlayTime()
 * will set the current playing time to this value and continue playing from that point.
 *
 * @param playTime The time, in milliseconds, to which the animation is advanced or rewound.
 *                 Unless the animation is reversing, the playtime is considered the time since
 *                 the end of the start delay of the AnimatorSet in a forward playing direction.
 *
 */

public void setCurrentPlayTime(long playTime) { throw new RuntimeException("Stub!"); }

/**
 * Returns the milliseconds elapsed since the start of the animation.
 *
 * <p>For ongoing animations, this method returns the current progress of the animation in
 * terms of play time. For an animation that has not yet been started: if the animation has been
 * seeked to a certain time via {@link #setCurrentPlayTime(long)}, the seeked play time will
 * be returned; otherwise, this method will return 0.
 *
 * @return the current position in time of the animation in milliseconds
 */

public long getCurrentPlayTime() { throw new RuntimeException("Stub!"); }

public android.animation.AnimatorSet clone() { throw new RuntimeException("Stub!"); }

/**
 * Plays the AnimatorSet in reverse. If the animation has been seeked to a specific play time
 * using {@link #setCurrentPlayTime(long)}, it will play backwards from the point seeked when
 * reverse was called. Otherwise, then it will start from the end and play backwards. This
 * behavior is only set for the current animation; future playing of the animation will use the
 * default behavior of playing forward.
 * <p>
 * Note: reverse is not supported for infinite AnimatorSet.
 */

public void reverse() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public long getTotalDuration() { throw new RuntimeException("Stub!"); }
/**
 * The <code>Builder</code> object is a utility class to facilitate adding animations to a
 * <code>AnimatorSet</code> along with the relationships between the various animations. The
 * intention of the <code>Builder</code> methods, along with the {@link
 * AnimatorSet#play(Animator) play()} method of <code>AnimatorSet</code> is to make it possible
 * to express the dependency relationships of animations in a natural way. Developers can also
 * use the {@link AnimatorSet#playTogether(Animator[]) playTogether()} and {@link
 * AnimatorSet#playSequentially(Animator[]) playSequentially()} methods if these suit the need,
 * but it might be easier in some situations to express the AnimatorSet of animations in pairs.
 * <p/>
 * <p>The <code>Builder</code> object cannot be constructed directly, but is rather constructed
 * internally via a call to {@link AnimatorSet#play(Animator)}.</p>
 * <p/>
 * <p>For example, this sets up a AnimatorSet to play anim1 and anim2 at the same time, anim3 to
 * play when anim2 finishes, and anim4 to play when anim3 finishes:</p>
 * <pre>
 *     AnimatorSet s = new AnimatorSet();
 *     s.play(anim1).with(anim2);
 *     s.play(anim2).before(anim3);
 *     s.play(anim4).after(anim3);
 * </pre>
 * <p/>
 * <p>Note in the example that both {@link Builder#before(Animator)} and {@link
 * Builder#after(Animator)} are used. These are just different ways of expressing the same
 * relationship and are provided to make it easier to say things in a way that is more natural,
 * depending on the situation.</p>
 * <p/>
 * <p>It is possible to make several calls into the same <code>Builder</code> object to express
 * multiple relationships. However, note that it is only the animation passed into the initial
 * {@link AnimatorSet#play(Animator)} method that is the dependency in any of the successive
 * calls to the <code>Builder</code> object. For example, the following code starts both anim2
 * and anim3 when anim1 ends; there is no direct dependency relationship between anim2 and
 * anim3:
 * <pre>
 *   AnimatorSet s = new AnimatorSet();
 *   s.play(anim1).before(anim2).before(anim3);
 * </pre>
 * If the desired result is to play anim1 then anim2 then anim3, this code expresses the
 * relationship correctly:</p>
 * <pre>
 *   AnimatorSet s = new AnimatorSet();
 *   s.play(anim1).before(anim2);
 *   s.play(anim2).before(anim3);
 * </pre>
 * <p/>
 * <p>Note that it is possible to express relationships that cannot be resolved and will not
 * result in sensible results. For example, <code>play(anim1).after(anim1)</code> makes no
 * sense. In general, circular dependencies like this one (or more indirect ones where a depends
 * on b, which depends on c, which depends on a) should be avoided. Only create AnimatorSets
 * that can boil down to a simple, one-way relationship of animations starting with, before, and
 * after other, different, animations.</p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Builder {

/**
 * package-private constructor. Builders are only constructed by AnimatorSet, when the
 * play() method is called.
 *
 * @param anim The animation that is the dependency for the other animations passed into
 * the other methods of this Builder object.
 */

Builder(android.animation.Animator anim) { throw new RuntimeException("Stub!"); }

/**
 * Sets up the given animation to play at the same time as the animation supplied in the
 * {@link AnimatorSet#play(Animator)} call that created this <code>Builder</code> object.
 *
 * @param anim The animation that will play when the animation supplied to the
 * {@link AnimatorSet#play(Animator)} method starts.
 */

public android.animation.AnimatorSet.Builder with(android.animation.Animator anim) { throw new RuntimeException("Stub!"); }

/**
 * Sets up the given animation to play when the animation supplied in the
 * {@link AnimatorSet#play(Animator)} call that created this <code>Builder</code> object
 * ends.
 *
 * @param anim The animation that will play when the animation supplied to the
 * {@link AnimatorSet#play(Animator)} method ends.
 */

public android.animation.AnimatorSet.Builder before(android.animation.Animator anim) { throw new RuntimeException("Stub!"); }

/**
 * Sets up the given animation to play when the animation supplied in the
 * {@link AnimatorSet#play(Animator)} call that created this <code>Builder</code> object
 * to start when the animation supplied in this method call ends.
 *
 * @param anim The animation whose end will cause the animation supplied to the
 * {@link AnimatorSet#play(Animator)} method to play.
 */

public android.animation.AnimatorSet.Builder after(android.animation.Animator anim) { throw new RuntimeException("Stub!"); }

/**
 * Sets up the animation supplied in the
 * {@link AnimatorSet#play(Animator)} call that created this <code>Builder</code> object
 * to play when the given amount of time elapses.
 *
 * @param delay The number of milliseconds that should elapse before the
 * animation starts.
 */

public android.animation.AnimatorSet.Builder after(long delay) { throw new RuntimeException("Stub!"); }
}

}

