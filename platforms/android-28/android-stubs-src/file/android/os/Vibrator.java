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


package android.os;

import android.media.AudioAttributes;

/**
 * Class that operates the vibrator on the device.
 * <p>
 * If your process exits, any vibration you started will stop.
 * </p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Vibrator {

/**
 * @hide to prevent subclassing from outside of the framework
 */

Vibrator() { throw new RuntimeException("Stub!"); }

/**
 * Check whether the hardware has a vibrator.
 *
 * @return True if the hardware has a vibrator, else false.
 */

public abstract boolean hasVibrator();

/**
 * Check whether the vibrator has amplitude control.
 *
 * @return True if the hardware can control the amplitude of the vibrations, otherwise false.
 */

public abstract boolean hasAmplitudeControl();

/**
 * Vibrate constantly for the specified period of time.
 *
 * Requires {@link android.Manifest.permission#VIBRATE}
 * @param milliseconds The number of milliseconds to vibrate.
 *
 * @deprecated Use {@link #vibrate(VibrationEffect)} instead.
 */

@Deprecated public void vibrate(long milliseconds) { throw new RuntimeException("Stub!"); }

/**
 * Vibrate constantly for the specified period of time.
 *
 * Requires {@link android.Manifest.permission#VIBRATE}
 * @param milliseconds The number of milliseconds to vibrate.
 * @param attributes {@link AudioAttributes} corresponding to the vibration. For example,
 *        specify {@link AudioAttributes#USAGE_ALARM} for alarm vibrations or
 *        {@link AudioAttributes#USAGE_NOTIFICATION_RINGTONE} for
 *        vibrations associated with incoming calls.
 *
 * @deprecated Use {@link #vibrate(VibrationEffect, AudioAttributes)} instead.
 */

@Deprecated public void vibrate(long milliseconds, android.media.AudioAttributes attributes) { throw new RuntimeException("Stub!"); }

/**
 * Vibrate with a given pattern.
 *
 * <p>
 * Pass in an array of ints that are the durations for which to turn on or off
 * the vibrator in milliseconds.  The first value indicates the number of milliseconds
 * to wait before turning the vibrator on.  The next value indicates the number of milliseconds
 * for which to keep the vibrator on before turning it off.  Subsequent values alternate
 * between durations in milliseconds to turn the vibrator off or to turn the vibrator on.
 * </p><p>
 * To cause the pattern to repeat, pass the index into the pattern array at which
 * to start the repeat, or -1 to disable repeating.
 * </p>
 *
 * Requires {@link android.Manifest.permission#VIBRATE}
 * @param pattern an array of longs of times for which to turn the vibrator on or off.
 * @param repeat the index into pattern at which to repeat, or -1 if
 *        you don't want to repeat.
 *
 * @deprecated Use {@link #vibrate(VibrationEffect)} instead.
 */

@Deprecated public void vibrate(long[] pattern, int repeat) { throw new RuntimeException("Stub!"); }

/**
 * Vibrate with a given pattern.
 *
 * <p>
 * Pass in an array of ints that are the durations for which to turn on or off
 * the vibrator in milliseconds.  The first value indicates the number of milliseconds
 * to wait before turning the vibrator on.  The next value indicates the number of milliseconds
 * for which to keep the vibrator on before turning it off.  Subsequent values alternate
 * between durations in milliseconds to turn the vibrator off or to turn the vibrator on.
 * </p><p>
 * To cause the pattern to repeat, pass the index into the pattern array at which
 * to start the repeat, or -1 to disable repeating.
 * </p>
 *
 * Requires {@link android.Manifest.permission#VIBRATE}
 * @param pattern an array of longs of times for which to turn the vibrator on or off.
 * @param repeat the index into pattern at which to repeat, or -1 if
 *        you don't want to repeat.
 * @param attributes {@link AudioAttributes} corresponding to the vibration. For example,
 *        specify {@link AudioAttributes#USAGE_ALARM} for alarm vibrations or
 *        {@link AudioAttributes#USAGE_NOTIFICATION_RINGTONE} for
 *        vibrations associated with incoming calls.
 *
 * @deprecated Use {@link #vibrate(VibrationEffect, AudioAttributes)} instead.
 */

@Deprecated public void vibrate(long[] pattern, int repeat, android.media.AudioAttributes attributes) { throw new RuntimeException("Stub!"); }

/**
 * Requires {@link android.Manifest.permission#VIBRATE}
 */

public void vibrate(android.os.VibrationEffect vibe) { throw new RuntimeException("Stub!"); }

/**
 * Requires {@link android.Manifest.permission#VIBRATE}
 */

public void vibrate(android.os.VibrationEffect vibe, android.media.AudioAttributes attributes) { throw new RuntimeException("Stub!"); }

/**
 * Turn the vibrator off.

 * Requires {@link android.Manifest.permission#VIBRATE}
 */

public abstract void cancel();
}

