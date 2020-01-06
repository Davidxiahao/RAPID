/*
 * Copyright (C) 2016 The Android Open Source Project
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
 * The AudioRecordingConfiguration class collects the information describing an audio recording
 * session.
 * <p>Direct polling (see {@link AudioManager#getActiveRecordingConfigurations()}) or callback
 * (see {@link AudioManager#registerAudioRecordingCallback(android.media.AudioManager.AudioRecordingCallback, android.os.Handler)}
 * methods are ways to receive information about the current recording configuration of the device.
 * <p>An audio recording configuration contains information about the recording format as used by
 * the application ({@link #getClientFormat()}, as well as the recording format actually used by
 * the device ({@link #getFormat()}). The two recording formats may, for instance, be at different
 * sampling rates due to hardware limitations (e.g. application recording at 44.1kHz whereas the
 * device always records at 48kHz, and the Android framework resamples for the application).
 * <p>The configuration also contains the use case for which audio is recorded
 * ({@link #getClientAudioSource()}), enabling the ability to distinguish between different
 * activities such as ongoing voice recognition or camcorder recording.
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioRecordingConfiguration implements android.os.Parcelable {

AudioRecordingConfiguration(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio source being used for the recording.
 * @return one of {@link MediaRecorder.AudioSource#DEFAULT},
 *       {@link MediaRecorder.AudioSource#MIC},
 *       {@link MediaRecorder.AudioSource#VOICE_UPLINK},
 *       {@link MediaRecorder.AudioSource#VOICE_DOWNLINK},
 *       {@link MediaRecorder.AudioSource#VOICE_CALL},
 *       {@link MediaRecorder.AudioSource#CAMCORDER},
 *       {@link MediaRecorder.AudioSource#VOICE_RECOGNITION},
 *       {@link MediaRecorder.AudioSource#VOICE_COMMUNICATION},
 *       {@link MediaRecorder.AudioSource#UNPROCESSED}.

 * Value is {@link android.media.MediaRecorder.AudioSource#DEFAULT}, {@link android.media.MediaRecorder.AudioSource#MIC}, {@link android.media.MediaRecorder.AudioSource#VOICE_UPLINK}, {@link android.media.MediaRecorder.AudioSource#VOICE_DOWNLINK}, {@link android.media.MediaRecorder.AudioSource#VOICE_CALL}, {@link android.media.MediaRecorder.AudioSource#CAMCORDER}, {@link android.media.MediaRecorder.AudioSource#VOICE_RECOGNITION}, {@link android.media.MediaRecorder.AudioSource#VOICE_COMMUNICATION}, or {@link android.media.MediaRecorder.AudioSource#UNPROCESSED}
 */

public int getClientAudioSource() { throw new RuntimeException("Stub!"); }

/**
 * Returns the session number of the recording, see {@link AudioRecord#getAudioSessionId()}.
 * @return the session number.
 */

public int getClientAudioSessionId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio format at which audio is recorded on this Android device.
 * Note that it may differ from the client application recording format
 * (see {@link #getClientFormat()}).
 * @return the device recording format
 */

public android.media.AudioFormat getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio format at which the client application is recording audio.
 * Note that it may differ from the actual recording format (see {@link #getFormat()}).
 * @return the recording format
 */

public android.media.AudioFormat getClientFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns information about the audio input device used for this recording.
 * @return the audio recording device or null if this information cannot be retrieved
 */

public android.media.AudioDeviceInfo getAudioDevice() { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.media.AudioRecordingConfiguration> CREATOR;
static { CREATOR = null; }
}

