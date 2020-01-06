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


package android.media;

import android.os.Bundle;
import android.os.Parcel;
import java.util.Set;

/**
 * A class to encapsulate a collection of attributes describing information about an audio
 * stream.
 * <p><code>AudioAttributes</code> supersede the notion of stream types (see for instance
 * {@link AudioManager#STREAM_MUSIC} or {@link AudioManager#STREAM_ALARM}) for defining the
 * behavior of audio playback. Attributes allow an application to specify more information than is
 * conveyed in a stream type by allowing the application to define:
 * <ul>
 * <li>usage: "why" you are playing a sound, what is this sound used for. This is achieved with
 *     the "usage" information. Examples of usage are {@link #USAGE_MEDIA} and {@link #USAGE_ALARM}.
 *     These two examples are the closest to stream types, but more detailed use cases are
 *     available. Usage information is more expressive than a stream type, and allows certain
 *     platforms or routing policies to use this information for more refined volume or routing
 *     decisions. Usage is the most important information to supply in <code>AudioAttributes</code>
 *     and it is recommended to build any instance with this information supplied, see
 *     {@link AudioAttributes.Builder} for exceptions.</li>
 * <li>content type: "what" you are playing. The content type expresses the general category of
 *     the content. This information is optional. But in case it is known (for instance
 *     {@link #CONTENT_TYPE_MOVIE} for a movie streaming service or {@link #CONTENT_TYPE_MUSIC} for
 *     a music playback application) this information might be used by the audio framework to
 *     selectively configure some audio post-processing blocks.</li>
 * <li>flags: "how" is playback to be affected, see the flag definitions for the specific playback
 *     behaviors they control. </li>
 * </ul>
 * <p><code>AudioAttributes</code> are used for example in one of the {@link AudioTrack}
 * constructors (see {@link AudioTrack#AudioTrack(AudioAttributes, AudioFormat, int, int, int)}),
 * to configure a {@link MediaPlayer}
 * (see {@link MediaPlayer#setAudioAttributes(AudioAttributes)} or a
 * {@link android.app.Notification} (see {@link android.app.Notification#audioAttributes}). An
 * <code>AudioAttributes</code> instance is built through its builder,
 * {@link AudioAttributes.Builder}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioAttributes implements android.os.Parcelable {

AudioAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Return the content type.
 * @return one of the values that can be set in {@link Builder#setContentType(int)}
 */

public int getContentType() { throw new RuntimeException("Stub!"); }

/**
 * Return the usage.
 * @return one of the values that can be set in {@link Builder#setUsage(int)}
 */

public int getUsage() { throw new RuntimeException("Stub!"); }

/**
 * Return the flags.
 * @return a combined mask of all flags
 */

public int getFlags() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns the stream type matching this {@code AudioAttributes} instance for volume control.
 * Use this method to derive the stream type needed to configure the volume
 * control slider in an {@link android.app.Activity} with
 * {@link android.app.Activity#setVolumeControlStream(int)} for playback conducted with these
 * attributes.
 * <BR>Do not use this method to set the stream type on an audio player object
 * (e.g. {@link AudioTrack}, {@link MediaPlayer}) as this is deprecated,
 * use {@code AudioAttributes} instead.
 * @return a valid stream type for {@code Activity} or stream volume control that matches
 *     the attributes, or {@link AudioManager#USE_DEFAULT_STREAM_TYPE} if there isn't a direct
 *     match. Note that {@code USE_DEFAULT_STREAM_TYPE} is not a valid value
 *     for {@link AudioManager#setStreamVolume(int, int, int)}.
 */

public int getVolumeControlStream() { throw new RuntimeException("Stub!"); }

/**
 * Content type value to use when the content type is a soundtrack, typically accompanying
 * a movie or TV program.
 */

public static final int CONTENT_TYPE_MOVIE = 3; // 0x3

/**
 * Content type value to use when the content type is music.
 */

public static final int CONTENT_TYPE_MUSIC = 2; // 0x2

/**
 * Content type value to use when the content type is a sound used to accompany a user
 * action, such as a beep or sound effect expressing a key click, or event, such as the
 * type of a sound for a bonus being received in a game. These sounds are mostly synthesized
 * or short Foley sounds.
 */

public static final int CONTENT_TYPE_SONIFICATION = 4; // 0x4

/**
 * Content type value to use when the content type is speech.
 */

public static final int CONTENT_TYPE_SPEECH = 1; // 0x1

/**
 * Content type value to use when the content type is unknown, or other than the ones defined.
 */

public static final int CONTENT_TYPE_UNKNOWN = 0; // 0x0

public static final android.os.Parcelable.Creator<android.media.AudioAttributes> CREATOR;
static { CREATOR = null; }

/**
 * Flag defining a behavior where the audibility of the sound will be ensured by the system.
 */

public static final int FLAG_AUDIBILITY_ENFORCED = 1; // 0x1

/**
 * Flag requesting the use of an output stream supporting hardware A/V synchronization.
 */

public static final int FLAG_HW_AV_SYNC = 16; // 0x10

/**
 * Flag requesting a low latency path when creating an AudioTrack.
 * When using this flag, the sample rate must match the native sample rate
 * of the device. Effects processing is also unavailable.
 *
 * Note that if this flag is used without specifying a bufferSizeInBytes then the
 * AudioTrack's actual buffer size may be too small. It is recommended that a fairly
 * large buffer should be specified when the AudioTrack is created.
 * Then the actual size can be reduced by calling
 * {@link AudioTrack#setBufferSizeInFrames(int)}. The buffer size can be optimized
 * by lowering it after each write() call until the audio glitches, which is detected by calling
 * {@link AudioTrack#getUnderrunCount()}. Then the buffer size can be increased
 * until there are no glitches.
 * This tuning step should be done while playing silence.
 * This technique provides a compromise between latency and glitch rate.
 *
 * @deprecated Use {@link AudioTrack.Builder#setPerformanceMode(int)} with
 * {@link AudioTrack#PERFORMANCE_MODE_LOW_LATENCY} to control performance.
 */

@Deprecated public static final int FLAG_LOW_LATENCY = 256; // 0x100

/**
 * Usage value to use when the usage is an alarm (e.g.&nbsp;wake-up alarm).
 */

public static final int USAGE_ALARM = 4; // 0x4

/**
 * Usage value to use when the usage is for accessibility, such as with
 * a screen reader.
 */

public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11; // 0xb

/**
 * Usage value to use when the usage is driving or navigation directions.
 */

public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12; // 0xc

/**
 * Usage value to use when the usage is sonification, such as  with user
 * interface sounds.
 */

public static final int USAGE_ASSISTANCE_SONIFICATION = 13; // 0xd

/**
 * Usage value to use for audio responses to user queries, audio instructions or help
 * utterances.
 */

public static final int USAGE_ASSISTANT = 16; // 0x10

/**
 * Usage value to use when the usage is for game audio.
 */

public static final int USAGE_GAME = 14; // 0xe

/**
 * Usage value to use when the usage is media, such as music, or movie
 * soundtracks.
 */

public static final int USAGE_MEDIA = 1; // 0x1

/**
 * Usage value to use when the usage is notification. See other
 * notification usages for more specialized uses.
 */

public static final int USAGE_NOTIFICATION = 5; // 0x5

/**
 * Usage value to use when the usage is notification for a
 * non-immediate type of communication such as e-mail.
 */

public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9; // 0x9

/**
 * Usage value to use when the usage is notification for an "instant"
 * communication such as a chat, or SMS.
 */

public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8; // 0x8

/**
 * Usage value to use when the usage is a request to enter/end a
 * communication, such as a VoIP communication or video-conference.
 */

public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7; // 0x7

/**
 * Usage value to use when the usage is to attract the user's attention,
 * such as a reminder or low battery warning.
 */

public static final int USAGE_NOTIFICATION_EVENT = 10; // 0xa

/**
 * Usage value to use when the usage is telephony ringtone.
 */

public static final int USAGE_NOTIFICATION_RINGTONE = 6; // 0x6

/**
 * Usage value to use when the usage is unknown.
 */

public static final int USAGE_UNKNOWN = 0; // 0x0

/**
 * Usage value to use when the usage is voice communications, such as telephony
 * or VoIP.
 */

public static final int USAGE_VOICE_COMMUNICATION = 2; // 0x2

/**
 * Usage value to use when the usage is in-call signalling, such as with
 * a "busy" beep, or DTMF tones.
 */

public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3; // 0x3
/**
 * Builder class for {@link AudioAttributes} objects.
 * <p> Here is an example where <code>Builder</code> is used to define the
 * {@link AudioAttributes} to be used by a new <code>AudioTrack</code> instance:
 *
 * <pre class="prettyprint">
 * AudioTrack myTrack = new AudioTrack(
 *         new AudioAttributes.Builder()
 *             .setUsage(AudioAttributes.USAGE_MEDIA)
 *             .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
 *             .build(),
 *         myFormat, myBuffSize, AudioTrack.MODE_STREAM, mySession);
 * </pre>
 *
 * <p>By default all types of information (usage, content type, flags) conveyed by an
 * <code>AudioAttributes</code> instance are set to "unknown". Unknown information will be
 * interpreted as a default value that is dependent on the context of use, for instance a
 * {@link MediaPlayer} will use a default usage of {@link AudioAttributes#USAGE_MEDIA}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Constructs a new Builder with the defaults.
 * By default, usage and content type are respectively {@link AudioAttributes#USAGE_UNKNOWN}
 * and {@link AudioAttributes#CONTENT_TYPE_UNKNOWN}, and flags are 0. It is recommended to
 * configure the usage (with {@link #setUsage(int)}) or deriving attributes from a legacy
 * stream type (with {@link #setLegacyStreamType(int)}) before calling {@link #build()}
 * to override any default playback behavior in terms of routing and volume management.
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new Builder from a given AudioAttributes
 * @param aa the AudioAttributes object whose data will be reused in the new Builder.
 */

public Builder(android.media.AudioAttributes aa) { throw new RuntimeException("Stub!"); }

/**
 * Combines all of the attributes that have been set and return a new
 * {@link AudioAttributes} object.
 * @return a new {@link AudioAttributes} object
 */

public android.media.AudioAttributes build() { throw new RuntimeException("Stub!"); }

/**
 * Sets the attribute describing what is the intended use of the the audio signal,
 * such as alarm or ringtone.
 * @param usage one of {@link AudioAttributes#USAGE_UNKNOWN},
 *     {@link AudioAttributes#USAGE_MEDIA},
 *     {@link AudioAttributes#USAGE_VOICE_COMMUNICATION},
 *     {@link AudioAttributes#USAGE_VOICE_COMMUNICATION_SIGNALLING},
 *     {@link AudioAttributes#USAGE_ALARM}, {@link AudioAttributes#USAGE_NOTIFICATION},
 *     {@link AudioAttributes#USAGE_NOTIFICATION_RINGTONE},
 *     {@link AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_REQUEST},
 *     {@link AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_INSTANT},
 *     {@link AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_DELAYED},
 *     {@link AudioAttributes#USAGE_NOTIFICATION_EVENT},
 *     {@link AudioAttributes#USAGE_ASSISTANT},
 *     {@link AudioAttributes#USAGE_ASSISTANCE_ACCESSIBILITY},
 *     {@link AudioAttributes#USAGE_ASSISTANCE_NAVIGATION_GUIDANCE},
 *     {@link AudioAttributes#USAGE_ASSISTANCE_SONIFICATION},
 *     {@link AudioAttributes#USAGE_GAME}.
 * Value is {@link android.media.AudioAttributes#USAGE_UNKNOWN}, {@link android.media.AudioAttributes#USAGE_MEDIA}, {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION}, {@link android.media.AudioAttributes#USAGE_VOICE_COMMUNICATION_SIGNALLING}, {@link android.media.AudioAttributes#USAGE_ALARM}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_RINGTONE}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_REQUEST}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_INSTANT}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_COMMUNICATION_DELAYED}, {@link android.media.AudioAttributes#USAGE_NOTIFICATION_EVENT}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_ACCESSIBILITY}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_NAVIGATION_GUIDANCE}, {@link android.media.AudioAttributes#USAGE_ASSISTANCE_SONIFICATION}, {@link android.media.AudioAttributes#USAGE_GAME}, or {@link android.media.AudioAttributes#USAGE_ASSISTANT}
 * @return the same Builder instance.
 */

public android.media.AudioAttributes.Builder setUsage(int usage) { throw new RuntimeException("Stub!"); }

/**
 * Sets the attribute describing the content type of the audio signal, such as speech,
 * or music.
 * @param contentType the content type values, one of
 *     {@link AudioAttributes#CONTENT_TYPE_MOVIE},
 *     {@link AudioAttributes#CONTENT_TYPE_MUSIC},
 *     {@link AudioAttributes#CONTENT_TYPE_SONIFICATION},
 *     {@link AudioAttributes#CONTENT_TYPE_SPEECH},
 *     {@link AudioAttributes#CONTENT_TYPE_UNKNOWN}.
 * Value is {@link android.media.AudioAttributes#CONTENT_TYPE_UNKNOWN}, {@link android.media.AudioAttributes#CONTENT_TYPE_SPEECH}, {@link android.media.AudioAttributes#CONTENT_TYPE_MUSIC}, {@link android.media.AudioAttributes#CONTENT_TYPE_MOVIE}, or {@link android.media.AudioAttributes#CONTENT_TYPE_SONIFICATION}
 * @return the same Builder instance.
 */

public android.media.AudioAttributes.Builder setContentType(int contentType) { throw new RuntimeException("Stub!"); }

/**
 * Sets the combination of flags.
 *
 * This is a bitwise OR with the existing flags.
 * @param flags a combination of {@link AudioAttributes#FLAG_AUDIBILITY_ENFORCED},
 *    {@link AudioAttributes#FLAG_HW_AV_SYNC}.
 * @return the same Builder instance.
 */

public android.media.AudioAttributes.Builder setFlags(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Sets attributes as inferred from the legacy stream types.
 * Use this method when building an {@link AudioAttributes} instance to initialize some of
 * the attributes by information derived from a legacy stream type.
 * @param streamType one of {@link AudioManager#STREAM_VOICE_CALL},
 *   {@link AudioManager#STREAM_SYSTEM}, {@link AudioManager#STREAM_RING},
 *   {@link AudioManager#STREAM_MUSIC}, {@link AudioManager#STREAM_ALARM},
 *    or {@link AudioManager#STREAM_NOTIFICATION}.
 * @return the same Builder instance.
 */

public android.media.AudioAttributes.Builder setLegacyStreamType(int streamType) { throw new RuntimeException("Stub!"); }
}

}

