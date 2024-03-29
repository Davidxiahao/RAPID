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
 * limitations under the License
 */


package android.telecom;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents attributes of video calls.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class VideoProfile implements android.os.Parcelable {

/**
 * Creates an instance of the VideoProfile
 *
 * @param videoState The video state.

 * Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 */

public VideoProfile(int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Creates an instance of the VideoProfile
 *
 * @param videoState The video state.
 * Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 * @param quality The video quality.

 * Value is android.telecom.VideoProfile.QUALITY_UNKNOWN, {@link android.telecom.VideoProfile#QUALITY_HIGH}, {@link android.telecom.VideoProfile#QUALITY_MEDIUM}, {@link android.telecom.VideoProfile#QUALITY_LOW}, or {@link android.telecom.VideoProfile#QUALITY_DEFAULT}
 */

public VideoProfile(int videoState, int quality) { throw new RuntimeException("Stub!"); }

/**
 * The video state of the call.
 * Valid values: {@link VideoProfile#STATE_AUDIO_ONLY},
 * {@link VideoProfile#STATE_BIDIRECTIONAL},
 * {@link VideoProfile#STATE_TX_ENABLED},
 * {@link VideoProfile#STATE_RX_ENABLED},
 * {@link VideoProfile#STATE_PAUSED}.

 * @return Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 */

public int getVideoState() { throw new RuntimeException("Stub!"); }

/**
 * The desired video quality for the call.
 * Valid values: {@link VideoProfile#QUALITY_HIGH}, {@link VideoProfile#QUALITY_MEDIUM},
 * {@link VideoProfile#QUALITY_LOW}, {@link VideoProfile#QUALITY_DEFAULT}.

 * @return Value is android.telecom.VideoProfile.QUALITY_UNKNOWN, {@link android.telecom.VideoProfile#QUALITY_HIGH}, {@link android.telecom.VideoProfile#QUALITY_MEDIUM}, {@link android.telecom.VideoProfile#QUALITY_LOW}, or {@link android.telecom.VideoProfile#QUALITY_DEFAULT}
 */

public int getQuality() { throw new RuntimeException("Stub!"); }

/**
 * Describe the kinds of special objects contained in this Parcelable's
 * marshalled representation.
 *
 * @return a bitmask indicating the set of special object types marshalled
 * by the Parcelable.
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Flatten this object in to a Parcel.
 *
 * @param dest  The Parcel in which the object should be written.
 * @param flags Additional flags about how the object should be written.
 *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Generates a string representation of a video state.
 *
 * @param videoState The video state.
 * Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 * @return String representation of the video state.
 */

public static java.lang.String videoStateToString(int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the video state is audio only.
 * <p>
 * Note: Considers only whether either both the {@link #STATE_RX_ENABLED} or
 * {@link #STATE_TX_ENABLED} bits are off, but not {@link #STATE_PAUSED}.
 *
 * @param videoState The video state.
 * Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 * @return {@code True} if the video state is audio only, {@code false} otherwise.
 */

public static boolean isAudioOnly(int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether video transmission or reception is enabled for a video state.
 *
 * @param videoState The video state.
 * Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 * @return {@code True} if video transmission or reception is enabled, {@code false} otherwise.
 */

public static boolean isVideo(int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the video state has video transmission enabled.
 *
 * @param videoState The video state.
 * Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 * @return {@code True} if video transmission is enabled, {@code false} otherwise.
 */

public static boolean isTransmissionEnabled(int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the video state has video reception enabled.
 *
 * @param videoState The video state.
 * Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 * @return {@code True} if video reception is enabled, {@code false} otherwise.
 */

public static boolean isReceptionEnabled(int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the video state is bi-directional.
 *
 * @param videoState The video state.
 * Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 * @return {@code True} if the video is bi-directional, {@code false} otherwise.
 */

public static boolean isBidirectional(int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the video state is paused.
 *
 * @param videoState The video state.
 * Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 * @return {@code True} if the video is paused, {@code false} otherwise.
 */

public static boolean isPaused(int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Responsible for creating VideoProfile objects from deserialized Parcels.
 **/

public static final android.os.Parcelable.Creator<android.telecom.VideoProfile> CREATOR;
static { CREATOR = null; }

/**
 * Use default video quality.
 */

public static final int QUALITY_DEFAULT = 4; // 0x4

/**
 * "High" video quality.
 */

public static final int QUALITY_HIGH = 1; // 0x1

/**
 * "Low" video quality.
 */

public static final int QUALITY_LOW = 3; // 0x3

/**
 * "Medium" video quality.
 */

public static final int QUALITY_MEDIUM = 2; // 0x2

/**
 * Used when answering or dialing a call to indicate that the call does not have a video
 * component.
 * <p>
 * Should <b>not</b> be used in comparison checks to determine if a video state represents an
 * audio-only call.
 * <p>
 * The following, for example, is not the correct way to check if a call is audio-only:
 * <pre>
 * {@code
 * // This is the incorrect way to check for an audio-only call.
 * if (videoState == VideoProfile.STATE_AUDIO_ONLY) {
 *      // Handle audio-only call.
 * }
 * }
 * </pre>
 * <p>
 * Instead, use the {@link VideoProfile#isAudioOnly(int)} helper function to check if a
 * video state represents an audio-only call:
 * <pre>
 * {@code
 * // This is the correct way to check for an audio-only call.
 * if (VideoProfile.isAudioOnly(videoState)) {
 *      // Handle audio-only call.
 * }
 * }
 * </pre>
 */

public static final int STATE_AUDIO_ONLY = 0; // 0x0

/**
 * Video signal is bi-directional.
 */

public static final int STATE_BIDIRECTIONAL = 3; // 0x3

/**
 * Video is paused.
 */

public static final int STATE_PAUSED = 4; // 0x4

/**
 * Video reception is enabled.
 */

public static final int STATE_RX_ENABLED = 2; // 0x2

/**
 * Video transmission is enabled.
 */

public static final int STATE_TX_ENABLED = 1; // 0x1
/**
 * Represents the camera capabilities important to a Video Telephony provider.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CameraCapabilities implements android.os.Parcelable {

/**
 * Create a call camera capabilities instance.
 *
 * @param width The width of the camera video (in pixels).
 * @param height The height of the camera video (in pixels).
 */

public CameraCapabilities(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Describe the kinds of special objects contained in this Parcelable's
 * marshalled representation.
 *
 * @return a bitmask indicating the set of special object types marshalled
 * by the Parcelable.
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Flatten this object in to a Parcel.
 *
 * @param dest  The Parcel in which the object should be written.
 * @param flags Additional flags about how the object should be written.
 *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * The width of the camera video in pixels.
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * The height of the camera video in pixels.
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Responsible for creating CallCameraCapabilities objects from deserialized Parcels.
 **/

public static final android.os.Parcelable.Creator<android.telecom.VideoProfile.CameraCapabilities> CREATOR;
static { CREATOR = null; }
}

}

