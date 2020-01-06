/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.media.audiofx;

import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.audiofx.AudioEffect;

/**
 * LoudnessEnhancer is an audio effect for increasing audio loudness.
 * The processing is parametrized by a target gain value, which determines the maximum amount
 * by which an audio signal will be amplified; signals amplified outside of the sample
 * range supported by the platform are compressed.
 * An application creates a LoudnessEnhancer object to instantiate and control a
 * this audio effect in the audio framework.
 * To attach the LoudnessEnhancer to a particular AudioTrack or MediaPlayer,
 * specify the audio session ID of this AudioTrack or MediaPlayer when constructing the effect
 * (see {@link AudioTrack#getAudioSessionId()} and {@link MediaPlayer#getAudioSessionId()}).
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LoudnessEnhancer extends android.media.audiofx.AudioEffect {

/**
 * Class constructor.
 * @param audioSession system-wide unique audio session identifier. The LoudnessEnhancer
 * will be attached to the MediaPlayer or AudioTrack in the same audio session.
 *
 * @throws java.lang.IllegalStateException
 * @throws java.lang.IllegalArgumentException
 * @throws java.lang.UnsupportedOperationException
 * @throws java.lang.RuntimeException
 */

public LoudnessEnhancer(int audioSession) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.RuntimeException, java.lang.UnsupportedOperationException { super(null, null, 0, 0); throw new RuntimeException("Stub!"); }

/**
 * Set the target gain for the audio effect.
 * The target gain is the maximum value by which a sample value will be amplified when the
 * effect is enabled.
 * @param gainmB the effect target gain expressed in mB. 0mB corresponds to no amplification.
 * @throws IllegalStateException
 * @throws IllegalArgumentException
 * @throws UnsupportedOperationException
 */

public void setTargetGain(int gainmB) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Return the target gain.
 * @return the effect target gain expressed in mB.
 * @throws IllegalStateException
 * @throws IllegalArgumentException
 * @throws UnsupportedOperationException
 */

public float getTargetGain() throws java.lang.IllegalArgumentException, java.lang.IllegalStateException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * The maximum gain applied applied to the signal to process.
 * It is expressed in millibels (100mB = 1dB) where 0mB corresponds to no amplification.
 */

public static final int PARAM_TARGET_GAIN_MB = 0; // 0x0
}

