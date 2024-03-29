/*
 * Copyright 2015 The Android Open Source Project
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


package android.media;


/**
 * Structure for common playback params.
 *
 * Used by {@link AudioTrack} {@link AudioTrack#getPlaybackParams()} and
 * {@link AudioTrack#setPlaybackParams(PlaybackParams)}
 * to control playback behavior.
 * <p> <strong>audio fallback mode:</strong>
 * select out-of-range parameter handling.
 * <ul>
 * <li> {@link PlaybackParams#AUDIO_FALLBACK_MODE_DEFAULT}:
 *   System will determine best handling. </li>
 * <li> {@link PlaybackParams#AUDIO_FALLBACK_MODE_MUTE}:
 *   Play silence for params normally out of range.</li>
 * <li> {@link PlaybackParams#AUDIO_FALLBACK_MODE_FAIL}:
 *   Return {@link java.lang.IllegalArgumentException} from
 *   <code>AudioTrack.setPlaybackParams(PlaybackParams)</code>.</li>
 * </ul>
 * <p> <strong>pitch:</strong> increases or decreases the tonal frequency of the audio content.
 * It is expressed as a multiplicative factor, where normal pitch is 1.0f.
 * <p> <strong>speed:</strong> increases or decreases the time to
 * play back a set of audio or video frames.
 * It is expressed as a multiplicative factor, where normal speed is 1.0f.
 * <p> Different combinations of speed and pitch may be used for audio playback;
 * some common ones:
 * <ul>
 * <li> <em>Pitch equals 1.0f.</em> Speed change will be done with pitch preserved,
 * often called <em>timestretching</em>.</li>
 * <li> <em>Pitch equals speed.</em> Speed change will be done by <em>resampling</em>,
 * similar to {@link AudioTrack#setPlaybackRate(int)}.</li>
 * </ul>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PlaybackParams implements android.os.Parcelable {

public PlaybackParams() { throw new RuntimeException("Stub!"); }

/**
 * Allows defaults to be returned for properties not set.
 * Otherwise a {@link java.lang.IllegalArgumentException} exception
 * is raised when getting those properties
 * which have defaults but have never been set.
 * @return this <code>PlaybackParams</code> instance.
 */

public android.media.PlaybackParams allowDefaults() { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio fallback mode.
 * @param audioFallbackMode
 * Value is {@link android.media.PlaybackParams#AUDIO_FALLBACK_MODE_DEFAULT}, {@link android.media.PlaybackParams#AUDIO_FALLBACK_MODE_MUTE}, or {@link android.media.PlaybackParams#AUDIO_FALLBACK_MODE_FAIL}
 * @return this <code>PlaybackParams</code> instance.
 */

public android.media.PlaybackParams setAudioFallbackMode(int audioFallbackMode) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the audio fallback mode.
 * @return audio fallback mode
 * Value is {@link android.media.PlaybackParams#AUDIO_FALLBACK_MODE_DEFAULT}, {@link android.media.PlaybackParams#AUDIO_FALLBACK_MODE_MUTE}, or {@link android.media.PlaybackParams#AUDIO_FALLBACK_MODE_FAIL}
 * @throws IllegalStateException if the audio fallback mode is not set.
 */

public int getAudioFallbackMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the pitch factor.
 * @param pitch
 * @return this <code>PlaybackParams</code> instance.
 * @throws IllegalArgumentException if the pitch is negative.
 */

public android.media.PlaybackParams setPitch(float pitch) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the pitch factor.
 * @return pitch
 * @throws IllegalStateException if pitch is not set.
 */

public float getPitch() { throw new RuntimeException("Stub!"); }

/**
 * Sets the speed factor.
 * @param speed
 * @return this <code>PlaybackParams</code> instance.
 */

public android.media.PlaybackParams setSpeed(float speed) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the speed factor.
 * @return speed
 * @throws IllegalStateException if speed is not set.
 */

public float getSpeed() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final int AUDIO_FALLBACK_MODE_DEFAULT = 0; // 0x0

public static final int AUDIO_FALLBACK_MODE_FAIL = 2; // 0x2

public static final int AUDIO_FALLBACK_MODE_MUTE = 1; // 0x1

public static final android.os.Parcelable.Creator<android.media.PlaybackParams> CREATOR;
static { CREATOR = null; }
}

