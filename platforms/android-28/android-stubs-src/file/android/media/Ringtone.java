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


package android.media;

import android.provider.Settings;
import android.net.Uri;

/**
 * Ringtone provides a quick method for playing a ringtone, notification, or
 * other similar types of sounds.
 * <p>
 * For ways of retrieving {@link Ringtone} objects or to show a ringtone
 * picker, see {@link RingtoneManager}.
 *
 * @see RingtoneManager
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Ringtone {

/** {@hide} */

Ringtone(android.content.Context context, boolean allowRemote) { throw new RuntimeException("Stub!"); }

/**
 * Sets the stream type where this ringtone will be played.
 *
 * @param streamType The stream, see {@link AudioManager}.
 * @deprecated use {@link #setAudioAttributes(AudioAttributes)}
 */

@Deprecated public void setStreamType(int streamType) { throw new RuntimeException("Stub!"); }

/**
 * Gets the stream type where this ringtone will be played.
 *
 * @return The stream type, see {@link AudioManager}.
 * @deprecated use of stream types is deprecated, see
 *     {@link #setAudioAttributes(AudioAttributes)}
 */

@Deprecated public int getStreamType() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link AudioAttributes} for this ringtone.
 * @param attributes the non-null attributes characterizing this ringtone.
 */

public void setAudioAttributes(android.media.AudioAttributes attributes) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link AudioAttributes} used by this object.
 * @return the {@link AudioAttributes} that were set with
 *     {@link #setAudioAttributes(AudioAttributes)} or the default attributes if none were set.
 */

public android.media.AudioAttributes getAudioAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Sets the player to be looping or non-looping.
 * @param looping whether to loop or not.
 */

public void setLooping(boolean looping) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the looping mode was enabled on this player.
 * @return true if this player loops when playing.
 */

public boolean isLooping() { throw new RuntimeException("Stub!"); }

/**
 * Sets the volume on this player.
 * @param volume a raw scalar in range 0.0 to 1.0, where 0.0 mutes this player, and 1.0
 *   corresponds to no attenuation being applied.
 */

public void setVolume(float volume) { throw new RuntimeException("Stub!"); }

/**
 * Returns the volume scalar set on this player.
 * @return a value between 0.0f and 1.0f.
 */

public float getVolume() { throw new RuntimeException("Stub!"); }

/**
 * Returns a human-presentable title for ringtone. Looks in media
 * content provider. If not in either, uses the filename
 *
 * @param context A context used for querying.
 */

public java.lang.String getTitle(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Plays the ringtone.
 */

public void play() { throw new RuntimeException("Stub!"); }

/**
 * Stops a playing ringtone.
 */

public void stop() { throw new RuntimeException("Stub!"); }

/**
 * Whether this ringtone is currently playing.
 *
 * @return True if playing, false otherwise.
 */

public boolean isPlaying() { throw new RuntimeException("Stub!"); }

protected void finalize() { throw new RuntimeException("Stub!"); }
}

