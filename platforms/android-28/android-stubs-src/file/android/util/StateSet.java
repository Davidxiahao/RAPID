/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.util;


/**
 * State sets are arrays of positive ints where each element
 * represents the state of a {@link android.view.View} (e.g. focused,
 * selected, visible, etc.).  A {@link android.view.View} may be in
 * one or more of those states.
 *
 * A state spec is an array of signed ints where each element
 * represents a required (if positive) or an undesired (if negative)
 * {@link android.view.View} state.
 *
 * Utils dealing with state sets.
 *
 * In theory we could encapsulate the state set and state spec arrays
 * and not have static methods here but there is some concern about
 * performance since these methods are called during view drawing.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StateSet {

/** @hide */

StateSet() { throw new RuntimeException("Stub!"); }

/**
 * Return whether the stateSetOrSpec is matched by all StateSets.
 *
 * @param stateSetOrSpec a state set or state spec.
 */

public static boolean isWildCard(int[] stateSetOrSpec) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the stateSet matches the desired stateSpec.
 *
 * @param stateSpec an array of required (if positive) or
 *        prohibited (if negative) {@link android.view.View} states.
 * @param stateSet an array of {@link android.view.View} states
 */

public static boolean stateSetMatches(int[] stateSpec, int[] stateSet) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the state matches the desired stateSpec.
 *
 * @param stateSpec an array of required (if positive) or
 *        prohibited (if negative) {@link android.view.View} states.
 * @param state a {@link android.view.View} state
 */

public static boolean stateSetMatches(int[] stateSpec, int state) { throw new RuntimeException("Stub!"); }

public static int[] trimStateSet(int[] states, int newSize) { throw new RuntimeException("Stub!"); }

public static java.lang.String dump(int[] states) { throw new RuntimeException("Stub!"); }

/**
 * A state set that does not contain any valid states.
 */

public static final int[] NOTHING;
static { NOTHING = new int[0]; }

/**
 * A state specification that will be matched by all StateSets.
 */

public static final int[] WILD_CARD;
static { WILD_CARD = new int[0]; }
}

