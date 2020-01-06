/*
 * Copyright (C) 2017 The Android Open Source Project
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

import android.content.Context;
import android.net.Uri;

/**
 * A VibrationEffect describes a haptic effect to be performed by a {@link Vibrator}.
 *
 * These effects may be any number of things, from single shot vibrations to complex waveforms.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class VibrationEffect implements android.os.Parcelable {

/** @hide to prevent subclassing from outside of the framework */

VibrationEffect() { throw new RuntimeException("Stub!"); }

/**
 * Create a one shot vibration.
 *
 * One shot vibrations will vibrate constantly for the specified period of time at the
 * specified amplitude, and then stop.
 *
 * @param milliseconds The number of milliseconds to vibrate. This must be a positive number.
 * @param amplitude The strength of the vibration. This must be a value between 1 and 255, or
 * {@link #DEFAULT_AMPLITUDE}.
 *
 * @return The desired effect.
 */

public static android.os.VibrationEffect createOneShot(long milliseconds, int amplitude) { throw new RuntimeException("Stub!"); }

/**
 * Create a waveform vibration.
 *
 * Waveform vibrations are a potentially repeating series of timing and amplitude pairs. For
 * each pair, the value in the amplitude array determines the strength of the vibration and the
 * value in the timing array determines how long it vibrates for. An amplitude of 0 implies no
 * vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
 * <p>
 * The amplitude array of the generated waveform will be the same size as the given
 * timing array with alternating values of 0 (i.e. off) and {@link #DEFAULT_AMPLITUDE},
 * starting with 0. Therefore the first timing value will be the period to wait before turning
 * the vibrator on, the second value will be how long to vibrate at {@link #DEFAULT_AMPLITUDE}
 * strength, etc.
 * </p><p>
 * To cause the pattern to repeat, pass the index into the timings array at which to start the
 * repetition, or -1 to disable repeating.
 * </p>
 *
 * @param timings The pattern of alternating on-off timings, starting with off. Timing values
 *                of 0 will cause the timing / amplitude pair to be ignored.
 * @param repeat The index into the timings array at which to repeat, or -1 if you you don't
 *               want to repeat.
 *
 * @return The desired effect.
 */

public static android.os.VibrationEffect createWaveform(long[] timings, int repeat) { throw new RuntimeException("Stub!"); }

/**
 * Create a waveform vibration.
 *
 * Waveform vibrations are a potentially repeating series of timing and amplitude pairs. For
 * each pair, the value in the amplitude array determines the strength of the vibration and the
 * value in the timing array determines how long it vibrates for. An amplitude of 0 implies no
 * vibration (i.e. off), and any pairs with a timing value of 0 will be ignored.
 * </p><p>
 * To cause the pattern to repeat, pass the index into the timings array at which to start the
 * repetition, or -1 to disable repeating.
 * </p>
 *
 * @param timings The timing values of the timing / amplitude pairs. Timing values of 0
 *                will cause the pair to be ignored.
 * @param amplitudes The amplitude values of the timing / amplitude pairs. Amplitude values
 *                   must be between 0 and 255, or equal to {@link #DEFAULT_AMPLITUDE}. An
 *                   amplitude value of 0 implies the motor is off.
 * @param repeat The index into the timings array at which to repeat, or -1 if you you don't
 *               want to repeat.
 *
 * @return The desired effect.
 */

public static android.os.VibrationEffect createWaveform(long[] timings, int[] amplitudes, int repeat) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.os.VibrationEffect> CREATOR;
static { CREATOR = null; }

/**
 * The default vibration strength of the device.
 */

public static final int DEFAULT_AMPLITUDE = -1; // 0xffffffff
}

