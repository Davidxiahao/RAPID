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


package android.view;


/**
 * Constants to be used to play sound effects via {@link View#playSoundEffect(int)}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SoundEffectConstants {

SoundEffectConstants() { throw new RuntimeException("Stub!"); }

/**
 * Get the sonification constant for the focus directions.
 * @param direction One of {@link View#FOCUS_UP}, {@link View#FOCUS_DOWN},
 *     {@link View#FOCUS_LEFT}, {@link View#FOCUS_RIGHT}, {@link View#FOCUS_FORWARD}
 *     or {@link View#FOCUS_BACKWARD}
 
 * @return The appropriate sonification constant.
 * @throws {@link IllegalArgumentException} when the passed direction is not one of the
 *     documented values.
 */

public static int getContantForFocusDirection(int direction) { throw new RuntimeException("Stub!"); }

public static final int CLICK = 0; // 0x0

public static final int NAVIGATION_DOWN = 4; // 0x4

public static final int NAVIGATION_LEFT = 1; // 0x1

public static final int NAVIGATION_RIGHT = 3; // 0x3

public static final int NAVIGATION_UP = 2; // 0x2
}

