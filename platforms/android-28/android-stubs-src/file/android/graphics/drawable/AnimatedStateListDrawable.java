/*
 * Copyright (C) 2014 The Android Open Source Project
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
 * Drawable containing a set of Drawable keyframes where the currently displayed
 * keyframe is chosen based on the current state set. Animations between
 * keyframes may optionally be defined using transition elements.
 * <p>
 * This drawable can be defined in an XML file with the <code>
 * &lt;animated-selector></code> element. Each keyframe Drawable is defined in a
 * nested <code>&lt;item></code> element. Transitions are defined in a nested
 * <code>&lt;transition></code> element.
 *
 * @attr ref android.R.styleable#DrawableStates_state_focused
 * @attr ref android.R.styleable#DrawableStates_state_window_focused
 * @attr ref android.R.styleable#DrawableStates_state_enabled
 * @attr ref android.R.styleable#DrawableStates_state_checkable
 * @attr ref android.R.styleable#DrawableStates_state_checked
 * @attr ref android.R.styleable#DrawableStates_state_selected
 * @attr ref android.R.styleable#DrawableStates_state_activated
 * @attr ref android.R.styleable#DrawableStates_state_active
 * @attr ref android.R.styleable#DrawableStates_state_single
 * @attr ref android.R.styleable#DrawableStates_state_first
 * @attr ref android.R.styleable#DrawableStates_state_middle
 * @attr ref android.R.styleable#DrawableStates_state_last
 * @attr ref android.R.styleable#DrawableStates_state_pressed
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AnimatedStateListDrawable extends android.graphics.drawable.StateListDrawable {

public AnimatedStateListDrawable() { throw new RuntimeException("Stub!"); }

public boolean setVisible(boolean visible, boolean restart) { throw new RuntimeException("Stub!"); }

/**
 * Add a new drawable to the set of keyframes.
 *
 * @param stateSet An array of resource IDs to associate with the keyframe
 * This value must never be {@code null}.
 * @param drawable The drawable to show when in the specified state, may not be null
 * This value must never be {@code null}.
 * @param id The unique identifier for the keyframe
 */

public void addState(@androidx.annotation.RecentlyNonNull int[] stateSet, @androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable drawable, int id) { throw new RuntimeException("Stub!"); }

/**
 * Adds a new transition between keyframes.
 *
 * @param fromId Unique identifier of the starting keyframe
 * @param toId Unique identifier of the ending keyframe
 * @param transition An {@link Animatable} drawable to use as a transition, may not be null
 * This value must never be {@code null}.
 * @param reversible Whether the transition can be reversed
 */

public <T extends android.graphics.drawable.Drawable & android.graphics.drawable.Animatable> void addTransition(int fromId, int toId, @androidx.annotation.RecentlyNonNull T transition, boolean reversible) { throw new RuntimeException("Stub!"); }

public boolean isStateful() { throw new RuntimeException("Stub!"); }

protected boolean onStateChange(int[] stateSet) { throw new RuntimeException("Stub!"); }

public void jumpToCurrentState() { throw new RuntimeException("Stub!"); }

/**
 * @param r This value must never be {@code null}.

 * @param parser This value must never be {@code null}.
 
 * @param attrs This value must never be {@code null}.

 * @param theme This value may be {@code null}.
 */

public void inflate(@androidx.annotation.RecentlyNonNull android.content.res.Resources r, @androidx.annotation.RecentlyNonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.RecentlyNonNull android.util.AttributeSet attrs, @androidx.annotation.RecentlyNullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * @param theme This value may be {@code null}.
 */

public void applyTheme(@androidx.annotation.RecentlyNullable android.content.res.Resources.Theme theme) { throw new RuntimeException("Stub!"); }

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/**
 * @param state This value must never be {@code null}.
 */

protected void setConstantState(@androidx.annotation.RecentlyNonNull android.graphics.drawable.DrawableContainer.DrawableContainerState state) { throw new RuntimeException("Stub!"); }
}

