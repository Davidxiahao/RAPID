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


package android.media;

import android.os.PersistableBundle;
import android.os.Handler;
import java.nio.ByteBuffer;
import android.os.Looper;
import java.util.concurrent.Executor;

/**
 * The AudioTrack class manages and plays a single audio resource for Java applications.
 * It allows streaming of PCM audio buffers to the audio sink for playback. This is
 * achieved by "pushing" the data to the AudioTrack object using one of the
 *  {@link #write(byte[], int, int)}, {@link #write(short[], int, int)},
 *  and {@link #write(float[], int, int, int)} methods.
 *
 * <p>An AudioTrack instance can operate under two modes: static or streaming.<br>
 * In Streaming mode, the application writes a continuous stream of data to the AudioTrack, using
 * one of the {@code write()} methods. These are blocking and return when the data has been
 * transferred from the Java layer to the native layer and queued for playback. The streaming
 * mode is most useful when playing blocks of audio data that for instance are:
 *
 * <ul>
 *   <li>too big to fit in memory because of the duration of the sound to play,</li>
 *   <li>too big to fit in memory because of the characteristics of the audio data
 *         (high sampling rate, bits per sample ...)</li>
 *   <li>received or generated while previously queued audio is playing.</li>
 * </ul>
 *
 * The static mode should be chosen when dealing with short sounds that fit in memory and
 * that need to be played with the smallest latency possible. The static mode will
 * therefore be preferred for UI and game sounds that are played often, and with the
 * smallest overhead possible.
 *
 * <p>Upon creation, an AudioTrack object initializes its associated audio buffer.
 * The size of this buffer, specified during the construction, determines how long an AudioTrack
 * can play before running out of data.<br>
 * For an AudioTrack using the static mode, this size is the maximum size of the sound that can
 * be played from it.<br>
 * For the streaming mode, data will be written to the audio sink in chunks of
 * sizes less than or equal to the total buffer size.
 *
 * AudioTrack is not final and thus permits subclasses, but such use is not recommended.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AudioTrack implements android.media.AudioRouting, android.media.VolumeAutomation {

/**
 * Class constructor.
 * @param streamType the type of the audio stream. See
 *   {@link AudioManager#STREAM_VOICE_CALL}, {@link AudioManager#STREAM_SYSTEM},
 *   {@link AudioManager#STREAM_RING}, {@link AudioManager#STREAM_MUSIC},
 *   {@link AudioManager#STREAM_ALARM}, and {@link AudioManager#STREAM_NOTIFICATION}.
 * @param sampleRateInHz the initial source sample rate expressed in Hz.
 *   {@link AudioFormat#SAMPLE_RATE_UNSPECIFIED} means to use a route-dependent value
 *   which is usually the sample rate of the sink.
 *   {@link #getSampleRate()} can be used to retrieve the actual sample rate chosen.
 * @param channelConfig describes the configuration of the audio channels.
 *   See {@link AudioFormat#CHANNEL_OUT_MONO} and
 *   {@link AudioFormat#CHANNEL_OUT_STEREO}
 * @param audioFormat the format in which the audio data is represented.
 *   See {@link AudioFormat#ENCODING_PCM_16BIT},
 *   {@link AudioFormat#ENCODING_PCM_8BIT},
 *   and {@link AudioFormat#ENCODING_PCM_FLOAT}.
 * @param bufferSizeInBytes the total size (in bytes) of the internal buffer where audio data is
 *   read from for playback. This should be a nonzero multiple of the frame size in bytes.
 *   <p> If the track's creation mode is {@link #MODE_STATIC},
 *   this is the maximum length sample, or audio clip, that can be played by this instance.
 *   <p> If the track's creation mode is {@link #MODE_STREAM},
 *   this should be the desired buffer size
 *   for the <code>AudioTrack</code> to satisfy the application's
 *   latency requirements.
 *   If <code>bufferSizeInBytes</code> is less than the
 *   minimum buffer size for the output sink, it is increased to the minimum
 *   buffer size.
 *   The method {@link #getBufferSizeInFrames()} returns the
 *   actual size in frames of the buffer created, which
 *   determines the minimum frequency to write
 *   to the streaming <code>AudioTrack</code> to avoid underrun.
 *   See {@link #getMinBufferSize(int, int, int)} to determine the estimated minimum buffer size
 *   for an AudioTrack instance in streaming mode.
 * @param mode streaming or static buffer. See {@link #MODE_STATIC} and {@link #MODE_STREAM}
 * @throws java.lang.IllegalArgumentException
 * @deprecated use {@link Builder} or
 *   {@link #AudioTrack(AudioAttributes, AudioFormat, int, int, int)} to specify the
 *   {@link AudioAttributes} instead of the stream type which is only for volume control.
 */

@Deprecated public AudioTrack(int streamType, int sampleRateInHz, int channelConfig, int audioFormat, int bufferSizeInBytes, int mode) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Class constructor with audio session. Use this constructor when the AudioTrack must be
 * attached to a particular audio session. The primary use of the audio session ID is to
 * associate audio effects to a particular instance of AudioTrack: if an audio session ID
 * is provided when creating an AudioEffect, this effect will be applied only to audio tracks
 * and media players in the same session and not to the output mix.
 * When an AudioTrack is created without specifying a session, it will create its own session
 * which can be retrieved by calling the {@link #getAudioSessionId()} method.
 * If a non-zero session ID is provided, this AudioTrack will share effects attached to this
 * session
 * with all other media players or audio tracks in the same session, otherwise a new session
 * will be created for this track if none is supplied.
 * @param streamType the type of the audio stream. See
 *   {@link AudioManager#STREAM_VOICE_CALL}, {@link AudioManager#STREAM_SYSTEM},
 *   {@link AudioManager#STREAM_RING}, {@link AudioManager#STREAM_MUSIC},
 *   {@link AudioManager#STREAM_ALARM}, and {@link AudioManager#STREAM_NOTIFICATION}.
 * @param sampleRateInHz the initial source sample rate expressed in Hz.
 *   {@link AudioFormat#SAMPLE_RATE_UNSPECIFIED} means to use a route-dependent value
 *   which is usually the sample rate of the sink.
 * @param channelConfig describes the configuration of the audio channels.
 *   See {@link AudioFormat#CHANNEL_OUT_MONO} and
 *   {@link AudioFormat#CHANNEL_OUT_STEREO}
 * @param audioFormat the format in which the audio data is represented.
 *   See {@link AudioFormat#ENCODING_PCM_16BIT} and
 *   {@link AudioFormat#ENCODING_PCM_8BIT},
 *   and {@link AudioFormat#ENCODING_PCM_FLOAT}.
 * @param bufferSizeInBytes the total size (in bytes) of the internal buffer where audio data is
 *   read from for playback. This should be a nonzero multiple of the frame size in bytes.
 *   <p> If the track's creation mode is {@link #MODE_STATIC},
 *   this is the maximum length sample, or audio clip, that can be played by this instance.
 *   <p> If the track's creation mode is {@link #MODE_STREAM},
 *   this should be the desired buffer size
 *   for the <code>AudioTrack</code> to satisfy the application's
 *   latency requirements.
 *   If <code>bufferSizeInBytes</code> is less than the
 *   minimum buffer size for the output sink, it is increased to the minimum
 *   buffer size.
 *   The method {@link #getBufferSizeInFrames()} returns the
 *   actual size in frames of the buffer created, which
 *   determines the minimum frequency to write
 *   to the streaming <code>AudioTrack</code> to avoid underrun.
 *   You can write data into this buffer in smaller chunks than this size.
 *   See {@link #getMinBufferSize(int, int, int)} to determine the estimated minimum buffer size
 *   for an AudioTrack instance in streaming mode.
 * @param mode streaming or static buffer. See {@link #MODE_STATIC} and {@link #MODE_STREAM}
 * @param sessionId Id of audio session the AudioTrack must be attached to
 * @throws java.lang.IllegalArgumentException
 * @deprecated use {@link Builder} or
 *   {@link #AudioTrack(AudioAttributes, AudioFormat, int, int, int)} to specify the
 *   {@link AudioAttributes} instead of the stream type which is only for volume control.
 */

@Deprecated public AudioTrack(int streamType, int sampleRateInHz, int channelConfig, int audioFormat, int bufferSizeInBytes, int mode, int sessionId) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Class constructor with {@link AudioAttributes} and {@link AudioFormat}.
 * @param attributes a non-null {@link AudioAttributes} instance.
 * @param format a non-null {@link AudioFormat} instance describing the format of the data
 *     that will be played through this AudioTrack. See {@link AudioFormat.Builder} for
 *     configuring the audio format parameters such as encoding, channel mask and sample rate.
 * @param bufferSizeInBytes the total size (in bytes) of the internal buffer where audio data is
 *   read from for playback. This should be a nonzero multiple of the frame size in bytes.
 *   <p> If the track's creation mode is {@link #MODE_STATIC},
 *   this is the maximum length sample, or audio clip, that can be played by this instance.
 *   <p> If the track's creation mode is {@link #MODE_STREAM},
 *   this should be the desired buffer size
 *   for the <code>AudioTrack</code> to satisfy the application's
 *   latency requirements.
 *   If <code>bufferSizeInBytes</code> is less than the
 *   minimum buffer size for the output sink, it is increased to the minimum
 *   buffer size.
 *   The method {@link #getBufferSizeInFrames()} returns the
 *   actual size in frames of the buffer created, which
 *   determines the minimum frequency to write
 *   to the streaming <code>AudioTrack</code> to avoid underrun.
 *   See {@link #getMinBufferSize(int, int, int)} to determine the estimated minimum buffer size
 *   for an AudioTrack instance in streaming mode.
 * @param mode streaming or static buffer. See {@link #MODE_STATIC} and {@link #MODE_STREAM}.
 * @param sessionId ID of audio session the AudioTrack must be attached to, or
 *   {@link AudioManager#AUDIO_SESSION_ID_GENERATE} if the session isn't known at construction
 *   time. See also {@link AudioManager#generateAudioSessionId()} to obtain a session ID before
 *   construction.
 * @throws IllegalArgumentException
 */

public AudioTrack(android.media.AudioAttributes attributes, android.media.AudioFormat format, int bufferSizeInBytes, int mode, int sessionId) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Releases the native AudioTrack resources.
 */

public void release() { throw new RuntimeException("Stub!"); }

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum gain value, which is the constant 0.0.
 * Gain values less than 0.0 will be clamped to 0.0.
 * <p>The word "volume" in the API name is historical; this is actually a linear gain.
 * @return the minimum value, which is the constant 0.0.
 */

public static float getMinVolume() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum gain value, which is greater than or equal to 1.0.
 * Gain values greater than the maximum will be clamped to the maximum.
 * <p>The word "volume" in the API name is historical; this is actually a gain.
 * expressed as a linear multiplier on sample values, where a maximum value of 1.0
 * corresponds to a gain of 0 dB (sample values left unmodified).
 * @return the maximum value, which is greater than or equal to 1.0.
 */

public static float getMaxVolume() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured audio source sample rate in Hz.
 * The initial source sample rate depends on the constructor parameters,
 * but the source sample rate may change if {@link #setPlaybackRate(int)} is called.
 * If the constructor had a specific sample rate, then the initial sink sample rate is that
 * value.
 * If the constructor had {@link AudioFormat#SAMPLE_RATE_UNSPECIFIED},
 * then the initial sink sample rate is a route-dependent default value based on the source [sic].
 */

public int getSampleRate() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current playback sample rate rate in Hz.
 */

public int getPlaybackRate() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current playback parameters.
 * See {@link #setPlaybackParams(PlaybackParams)} to set playback parameters
 * @return current {@link PlaybackParams}.
 * This value will never be {@code null}.
 * @throws IllegalStateException if track is not initialized.
 */

@androidx.annotation.RecentlyNonNull public android.media.PlaybackParams getPlaybackParams() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured audio data encoding. See {@link AudioFormat#ENCODING_PCM_8BIT},
 * {@link AudioFormat#ENCODING_PCM_16BIT}, and {@link AudioFormat#ENCODING_PCM_FLOAT}.
 */

public int getAudioFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the volume stream type of this AudioTrack.
 * Compare the result against {@link AudioManager#STREAM_VOICE_CALL},
 * {@link AudioManager#STREAM_SYSTEM}, {@link AudioManager#STREAM_RING},
 * {@link AudioManager#STREAM_MUSIC}, {@link AudioManager#STREAM_ALARM},
 * {@link AudioManager#STREAM_NOTIFICATION}, {@link AudioManager#STREAM_DTMF} or
 * {@link AudioManager#STREAM_ACCESSIBILITY}.
 */

public int getStreamType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured channel position mask.
 * <p> For example, refer to {@link AudioFormat#CHANNEL_OUT_MONO},
 * {@link AudioFormat#CHANNEL_OUT_STEREO}, {@link AudioFormat#CHANNEL_OUT_5POINT1}.
 * This method may return {@link AudioFormat#CHANNEL_INVALID} if
 * a channel index mask was used. Consider
 * {@link #getFormat()} instead, to obtain an {@link AudioFormat},
 * which contains both the channel position mask and the channel index mask.
 */

public int getChannelConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured <code>AudioTrack</code> format.
 * @return an {@link AudioFormat} containing the
 * <code>AudioTrack</code> parameters at the time of configuration.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioFormat getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured number of channels.
 */

public int getChannelCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the state of the AudioTrack instance. This is useful after the
 * AudioTrack instance has been created to check if it was initialized
 * properly. This ensures that the appropriate resources have been acquired.
 * @see #STATE_UNINITIALIZED
 * @see #STATE_INITIALIZED
 * @see #STATE_NO_STATIC_DATA
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the playback state of the AudioTrack instance.
 * @see #PLAYSTATE_STOPPED
 * @see #PLAYSTATE_PAUSED
 * @see #PLAYSTATE_PLAYING
 */

public int getPlayState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the effective size of the <code>AudioTrack</code> buffer
 * that the application writes to.
 * <p> This will be less than or equal to the result of
 * {@link #getBufferCapacityInFrames()}.
 * It will be equal if {@link #setBufferSizeInFrames(int)} has never been called.
 * <p> If the track is subsequently routed to a different output sink, the buffer
 * size and capacity may enlarge to accommodate.
 * <p> If the <code>AudioTrack</code> encoding indicates compressed data,
 * e.g. {@link AudioFormat#ENCODING_AC3}, then the frame count returned is
 * the size of the <code>AudioTrack</code> buffer in bytes.
 * <p> See also {@link AudioManager#getProperty(String)} for key
 * {@link AudioManager#PROPERTY_OUTPUT_FRAMES_PER_BUFFER}.
 * @return current size in frames of the <code>AudioTrack</code> buffer.
 * @throws IllegalStateException if track is not initialized.
 */

public int getBufferSizeInFrames() { throw new RuntimeException("Stub!"); }

/**
 * Limits the effective size of the <code>AudioTrack</code> buffer
 * that the application writes to.
 * <p> A write to this AudioTrack will not fill the buffer beyond this limit.
 * If a blocking write is used then the write will block until the data
 * can fit within this limit.
 * <p>Changing this limit modifies the latency associated with
 * the buffer for this track. A smaller size will give lower latency
 * but there may be more glitches due to buffer underruns.
 * <p>The actual size used may not be equal to this requested size.
 * It will be limited to a valid range with a maximum of
 * {@link #getBufferCapacityInFrames()}.
 * It may also be adjusted slightly for internal reasons.
 * If bufferSizeInFrames is less than zero then {@link #ERROR_BAD_VALUE}
 * will be returned.
 * <p>This method is only supported for PCM audio.
 * It is not supported for compressed audio tracks.
 *
 * @param bufferSizeInFrames requested buffer size in frames
 * @return the actual buffer size in frames or an error code,
 *    {@link #ERROR_BAD_VALUE}, {@link #ERROR_INVALID_OPERATION}
 * @throws IllegalStateException if track is not initialized.
 */

public int setBufferSizeInFrames(int bufferSizeInFrames) { throw new RuntimeException("Stub!"); }

/**
 *  Returns the maximum size of the <code>AudioTrack</code> buffer in frames.
 *  <p> If the track's creation mode is {@link #MODE_STATIC},
 *  it is equal to the specified bufferSizeInBytes on construction, converted to frame units.
 *  A static track's frame count will not change.
 *  <p> If the track's creation mode is {@link #MODE_STREAM},
 *  it is greater than or equal to the specified bufferSizeInBytes converted to frame units.
 *  For streaming tracks, this value may be rounded up to a larger value if needed by
 *  the target output sink, and
 *  if the track is subsequently routed to a different output sink, the
 *  frame count may enlarge to accommodate.
 *  <p> If the <code>AudioTrack</code> encoding indicates compressed data,
 *  e.g. {@link AudioFormat#ENCODING_AC3}, then the frame count returned is
 *  the size of the <code>AudioTrack</code> buffer in bytes.
 *  <p> See also {@link AudioManager#getProperty(String)} for key
 *  {@link AudioManager#PROPERTY_OUTPUT_FRAMES_PER_BUFFER}.
 *  @return maximum size in frames of the <code>AudioTrack</code> buffer.
 *  @throws IllegalStateException if track is not initialized.
 */

public int getBufferCapacityInFrames() { throw new RuntimeException("Stub!"); }

/**
 *  Returns the frame count of the native <code>AudioTrack</code> buffer.
 *  @return current size in frames of the <code>AudioTrack</code> buffer.
 *  @throws IllegalStateException
 *  @deprecated Use the identical public method {@link #getBufferSizeInFrames()} instead.
 */

@Deprecated protected int getNativeFrameCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns marker position expressed in frames.
 * @return marker position in wrapping frame units similar to {@link #getPlaybackHeadPosition},
 * or zero if marker is disabled.
 */

public int getNotificationMarkerPosition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the notification update period expressed in frames.
 * Zero means that no position update notifications are being delivered.
 */

public int getPositionNotificationPeriod() { throw new RuntimeException("Stub!"); }

/**
 * Returns the playback head position expressed in frames.
 * Though the "int" type is signed 32-bits, the value should be reinterpreted as if it is
 * unsigned 32-bits.  That is, the next position after 0x7FFFFFFF is (int) 0x80000000.
 * This is a continuously advancing counter.  It will wrap (overflow) periodically,
 * for example approximately once every 27:03:11 hours:minutes:seconds at 44.1 kHz.
 * It is reset to zero by {@link #flush()}, {@link #reloadStaticData()}, and {@link #stop()}.
 * If the track's creation mode is {@link #MODE_STATIC}, the return value indicates
 * the total number of frames played since reset,
 * <i>not</i> the current offset within the buffer.
 */

public int getPlaybackHeadPosition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of underrun occurrences in the application-level write buffer
 * since the AudioTrack was created.
 * An underrun occurs if the application does not write audio
 * data quickly enough, causing the buffer to underflow
 * and a potential audio glitch or pop.
 * <p>
 * Underruns are less likely when buffer sizes are large.
 * It may be possible to eliminate underruns by recreating the AudioTrack with
 * a larger buffer.
 * Or by using {@link #setBufferSizeInFrames(int)} to dynamically increase the
 * effective size of the buffer.
 */

public int getUnderrunCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current performance mode of the {@link AudioTrack}.
 *
 * @return one of {@link AudioTrack#PERFORMANCE_MODE_NONE},
 * {@link AudioTrack#PERFORMANCE_MODE_LOW_LATENCY},
 * or {@link AudioTrack#PERFORMANCE_MODE_POWER_SAVING}.
 * Use {@link AudioTrack.Builder#setPerformanceMode}
 * in the {@link AudioTrack.Builder} to enable a performance mode.
 * Value is {@link android.media.AudioTrack#PERFORMANCE_MODE_NONE}, {@link android.media.AudioTrack#PERFORMANCE_MODE_LOW_LATENCY}, or {@link android.media.AudioTrack#PERFORMANCE_MODE_POWER_SAVING}
 * @throws IllegalStateException if track is not initialized.
 */

public int getPerformanceMode() { throw new RuntimeException("Stub!"); }

/**
 *  Returns the output sample rate in Hz for the specified stream type.
 */

public static int getNativeOutputSampleRate(int streamType) { throw new RuntimeException("Stub!"); }

/**
 * Returns the estimated minimum buffer size required for an AudioTrack
 * object to be created in the {@link #MODE_STREAM} mode.
 * The size is an estimate because it does not consider either the route or the sink,
 * since neither is known yet.  Note that this size doesn't
 * guarantee a smooth playback under load, and higher values should be chosen according to
 * the expected frequency at which the buffer will be refilled with additional data to play.
 * For example, if you intend to dynamically set the source sample rate of an AudioTrack
 * to a higher value than the initial source sample rate, be sure to configure the buffer size
 * based on the highest planned sample rate.
 * @param sampleRateInHz the source sample rate expressed in Hz.
 *   {@link AudioFormat#SAMPLE_RATE_UNSPECIFIED} is not permitted.
 * @param channelConfig describes the configuration of the audio channels.
 *   See {@link AudioFormat#CHANNEL_OUT_MONO} and
 *   {@link AudioFormat#CHANNEL_OUT_STEREO}
 * @param audioFormat the format in which the audio data is represented.
 *   See {@link AudioFormat#ENCODING_PCM_16BIT} and
 *   {@link AudioFormat#ENCODING_PCM_8BIT},
 *   and {@link AudioFormat#ENCODING_PCM_FLOAT}.
 * @return {@link #ERROR_BAD_VALUE} if an invalid parameter was passed,
 *   or {@link #ERROR} if unable to query for output properties,
 *   or the minimum buffer size expressed in bytes.
 */

public static int getMinBufferSize(int sampleRateInHz, int channelConfig, int audioFormat) { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio session ID.
 *
 * @return the ID of the audio session this AudioTrack belongs to.
 */

public int getAudioSessionId() { throw new RuntimeException("Stub!"); }

/**
 * Poll for a timestamp on demand.
 * <p>
 * If you need to track timestamps during initial warmup or after a routing or mode change,
 * you should request a new timestamp periodically until the reported timestamps
 * show that the frame position is advancing, or until it becomes clear that
 * timestamps are unavailable for this route.
 * <p>
 * After the clock is advancing at a stable rate,
 * query for a new timestamp approximately once every 10 seconds to once per minute.
 * Calling this method more often is inefficient.
 * It is also counter-productive to call this method more often than recommended,
 * because the short-term differences between successive timestamp reports are not meaningful.
 * If you need a high-resolution mapping between frame position and presentation time,
 * consider implementing that at application level, based on low-resolution timestamps.
 * <p>
 * The audio data at the returned position may either already have been
 * presented, or may have not yet been presented but is committed to be presented.
 * It is not possible to request the time corresponding to a particular position,
 * or to request the (fractional) position corresponding to a particular time.
 * If you need such features, consider implementing them at application level.
 *
 * @param timestamp a reference to a non-null AudioTimestamp instance allocated
 *        and owned by caller.
 * @return true if a timestamp is available, or false if no timestamp is available.
 *         If a timestamp if available,
 *         the AudioTimestamp instance is filled in with a position in frame units, together
 *         with the estimated time when that frame was presented or is committed to
 *         be presented.
 *         In the case that no timestamp is available, any supplied instance is left unaltered.
 *         A timestamp may be temporarily unavailable while the audio clock is stabilizing,
 *         or during and immediately after a route change.
 *         A timestamp is permanently unavailable for a given route if the route does not support
 *         timestamps.  In this case, the approximate frame position can be obtained
 *         using {@link #getPlaybackHeadPosition}.
 *         However, it may be useful to continue to query for
 *         timestamps occasionally, to recover after a route change.
 */

public boolean getTimestamp(android.media.AudioTimestamp timestamp) { throw new RuntimeException("Stub!"); }

/**
 *  Return Metrics data about the current AudioTrack instance.
 *
 * @return a {@link PersistableBundle} containing the set of attributes and values
 * available for the media being handled by this instance of AudioTrack
 * The attributes are descibed in {@link MetricsConstants}.
 *
 * Additional vendor-specific fields may also be present in
 * the return value.
 */

public android.os.PersistableBundle getMetrics() { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener the AudioTrack notifies when a previously set marker is reached or
 * for each periodic playback head position update.
 * Notifications will be received in the same thread as the one in which the AudioTrack
 * instance was created.
 * @param listener
 */

public void setPlaybackPositionUpdateListener(android.media.AudioTrack.OnPlaybackPositionUpdateListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener the AudioTrack notifies when a previously set marker is reached or
 * for each periodic playback head position update.
 * Use this method to receive AudioTrack events in the Handler associated with another
 * thread than the one in which you created the AudioTrack instance.
 * @param listener
 * @param handler the Handler that will receive the event notification messages.
 */

public void setPlaybackPositionUpdateListener(android.media.AudioTrack.OnPlaybackPositionUpdateListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Sets the specified left and right output gain values on the AudioTrack.
 * <p>Gain values are clamped to the closed interval [0.0, max] where
 * max is the value of {@link #getMaxVolume}.
 * A value of 0.0 results in zero gain (silence), and
 * a value of 1.0 means unity gain (signal unchanged).
 * The default value is 1.0 meaning unity gain.
 * <p>The word "volume" in the API name is historical; this is actually a linear gain.
 * @param leftGain output gain for the left channel.
 * @param rightGain output gain for the right channel
 * @return error code or success, see {@link #SUCCESS},
 *    {@link #ERROR_INVALID_OPERATION}
 * @deprecated Applications should use {@link #setVolume} instead, as it
 * more gracefully scales down to mono, and up to multi-channel content beyond stereo.
 */

@Deprecated public int setStereoVolume(float leftGain, float rightGain) { throw new RuntimeException("Stub!"); }

/**
 * Sets the specified output gain value on all channels of this track.
 * <p>Gain values are clamped to the closed interval [0.0, max] where
 * max is the value of {@link #getMaxVolume}.
 * A value of 0.0 results in zero gain (silence), and
 * a value of 1.0 means unity gain (signal unchanged).
 * The default value is 1.0 meaning unity gain.
 * <p>This API is preferred over {@link #setStereoVolume}, as it
 * more gracefully scales down to mono, and up to multi-channel content beyond stereo.
 * <p>The word "volume" in the API name is historical; this is actually a linear gain.
 * @param gain output gain for all channels.
 * @return error code or success, see {@link #SUCCESS},
 *    {@link #ERROR_INVALID_OPERATION}
 */

public int setVolume(float gain) { throw new RuntimeException("Stub!"); }

/**
 * @param configuration This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.media.VolumeShaper createVolumeShaper(@androidx.annotation.RecentlyNonNull android.media.VolumeShaper.Configuration configuration) { throw new RuntimeException("Stub!"); }

/**
 * Sets the playback sample rate for this track. This sets the sampling rate at which
 * the audio data will be consumed and played back
 * (as set by the sampleRateInHz parameter in the
 * {@link #AudioTrack(int, int, int, int, int, int)} constructor),
 * not the original sampling rate of the
 * content. For example, setting it to half the sample rate of the content will cause the
 * playback to last twice as long, but will also result in a pitch shift down by one octave.
 * The valid sample rate range is from 1 Hz to twice the value returned by
 * {@link #getNativeOutputSampleRate(int)}.
 * Use {@link #setPlaybackParams(PlaybackParams)} for speed control.
 * <p> This method may also be used to repurpose an existing <code>AudioTrack</code>
 * for playback of content of differing sample rate,
 * but with identical encoding and channel mask.
 * @param sampleRateInHz the sample rate expressed in Hz
 * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
 *    {@link #ERROR_INVALID_OPERATION}
 */

public int setPlaybackRate(int sampleRateInHz) { throw new RuntimeException("Stub!"); }

/**
 * Sets the playback parameters.
 * This method returns failure if it cannot apply the playback parameters.
 * One possible cause is that the parameters for speed or pitch are out of range.
 * Another possible cause is that the <code>AudioTrack</code> is streaming
 * (see {@link #MODE_STREAM}) and the
 * buffer size is too small. For speeds greater than 1.0f, the <code>AudioTrack</code> buffer
 * on configuration must be larger than the speed multiplied by the minimum size
 * {@link #getMinBufferSize(int, int, int)}) to allow proper playback.
 * @param params see {@link PlaybackParams}. In particular,
 * speed, pitch, and audio mode should be set.
 * This value must never be {@code null}.
 * @throws IllegalArgumentException if the parameters are invalid or not accepted.
 * @throws IllegalStateException if track is not initialized.
 */

public void setPlaybackParams(@androidx.annotation.RecentlyNonNull android.media.PlaybackParams params) { throw new RuntimeException("Stub!"); }

/**
 * Sets the position of the notification marker.  At most one marker can be active.
 * @param markerInFrames marker position in wrapping frame units similar to
 * {@link #getPlaybackHeadPosition}, or zero to disable the marker.
 * To set a marker at a position which would appear as zero due to wraparound,
 * a workaround is to use a non-zero position near zero, such as -1 or 1.
 * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
 *  {@link #ERROR_INVALID_OPERATION}
 */

public int setNotificationMarkerPosition(int markerInFrames) { throw new RuntimeException("Stub!"); }

/**
 * Sets the period for the periodic notification event.
 * @param periodInFrames update period expressed in frames.
 * Zero period means no position updates.  A negative period is not allowed.
 * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_INVALID_OPERATION}
 */

public int setPositionNotificationPeriod(int periodInFrames) { throw new RuntimeException("Stub!"); }

/**
 * Sets the playback head position within the static buffer.
 * The track must be stopped or paused for the position to be changed,
 * and must use the {@link #MODE_STATIC} mode.
 * @param positionInFrames playback head position within buffer, expressed in frames.
 * Zero corresponds to start of buffer.
 * The position must not be greater than the buffer size in frames, or negative.
 * Though this method and {@link #getPlaybackHeadPosition()} have similar names,
 * the position values have different meanings.
 * <br>
 * If looping is currently enabled and the new position is greater than or equal to the
 * loop end marker, the behavior varies by API level:
 * as of {@link android.os.Build.VERSION_CODES#M},
 * the looping is first disabled and then the position is set.
 * For earlier API levels, the behavior is unspecified.
 * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
 *    {@link #ERROR_INVALID_OPERATION}
 */

public int setPlaybackHeadPosition(int positionInFrames) { throw new RuntimeException("Stub!"); }

/**
 * Sets the loop points and the loop count. The loop can be infinite.
 * Similarly to setPlaybackHeadPosition,
 * the track must be stopped or paused for the loop points to be changed,
 * and must use the {@link #MODE_STATIC} mode.
 * @param startInFrames loop start marker expressed in frames.
 * Zero corresponds to start of buffer.
 * The start marker must not be greater than or equal to the buffer size in frames, or negative.
 * @param endInFrames loop end marker expressed in frames.
 * The total buffer size in frames corresponds to end of buffer.
 * The end marker must not be greater than the buffer size in frames.
 * For looping, the end marker must not be less than or equal to the start marker,
 * but to disable looping
 * it is permitted for start marker, end marker, and loop count to all be 0.
 * If any input parameters are out of range, this method returns {@link #ERROR_BAD_VALUE}.
 * If the loop period (endInFrames - startInFrames) is too small for the implementation to
 * support,
 * {@link #ERROR_BAD_VALUE} is returned.
 * The loop range is the interval [startInFrames, endInFrames).
 * <br>
 * As of {@link android.os.Build.VERSION_CODES#M}, the position is left unchanged,
 * unless it is greater than or equal to the loop end marker, in which case
 * it is forced to the loop start marker.
 * For earlier API levels, the effect on position is unspecified.
 * @param loopCount the number of times the loop is looped; must be greater than or equal to -1.
 *    A value of -1 means infinite looping, and 0 disables looping.
 *    A value of positive N means to "loop" (go back) N times.  For example,
 *    a value of one means to play the region two times in total.
 * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
 *    {@link #ERROR_INVALID_OPERATION}
 */

public int setLoopPoints(int startInFrames, int endInFrames, int loopCount) { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio presentation.
 * If the audio presentation is invalid then {@link #ERROR_BAD_VALUE} will be returned.
 * If a multi-stream decoder (MSD) is not present, or the format does not support
 * multiple presentations, then {@link #ERROR_INVALID_OPERATION} will be returned.
 * {@link #ERROR} is returned in case of any other error.
 * @param presentation see {@link AudioPresentation}. In particular, id should be set.
 * This value must never be {@code null}.
 * @return error code or success, see {@link #SUCCESS}, {@link #ERROR},
 *    {@link #ERROR_BAD_VALUE}, {@link #ERROR_INVALID_OPERATION}
 * @throws IllegalArgumentException if the audio presentation is null.
 * @throws IllegalStateException if track is not initialized.
 */

public int setPresentation(@androidx.annotation.RecentlyNonNull android.media.AudioPresentation presentation) { throw new RuntimeException("Stub!"); }

/**
 * Sets the initialization state of the instance. This method was originally intended to be used
 * in an AudioTrack subclass constructor to set a subclass-specific post-initialization state.
 * However, subclasses of AudioTrack are no longer recommended, so this method is obsolete.
 * @param state the state of the AudioTrack instance
 * @deprecated Only accessible by subclasses, which are not recommended for AudioTrack.
 */

@Deprecated protected void setState(int state) { throw new RuntimeException("Stub!"); }

/**
 * Starts playing an AudioTrack.
 * <p>
 * If track's creation mode is {@link #MODE_STATIC}, you must have called one of
 * the write methods ({@link #write(byte[], int, int)}, {@link #write(byte[], int, int, int)},
 * {@link #write(short[], int, int)}, {@link #write(short[], int, int, int)},
 * {@link #write(float[], int, int, int)}, or {@link #write(ByteBuffer, int, int)}) prior to
 * play().
 * <p>
 * If the mode is {@link #MODE_STREAM}, you can optionally prime the data path prior to
 * calling play(), by writing up to <code>bufferSizeInBytes</code> (from constructor).
 * If you don't call write() first, or if you call write() but with an insufficient amount of
 * data, then the track will be in underrun state at play().  In this case,
 * playback will not actually start playing until the data path is filled to a
 * device-specific minimum level.  This requirement for the path to be filled
 * to a minimum level is also true when resuming audio playback after calling stop().
 * Similarly the buffer will need to be filled up again after
 * the track underruns due to failure to call write() in a timely manner with sufficient data.
 * For portability, an application should prime the data path to the maximum allowed
 * by writing data until the write() method returns a short transfer count.
 * This allows play() to start immediately, and reduces the chance of underrun.
 *
 * @throws IllegalStateException if the track isn't properly initialized
 */

public void play() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Stops playing the audio data.
 * When used on an instance created in {@link #MODE_STREAM} mode, audio will stop playing
 * after the last buffer that was written has been played. For an immediate stop, use
 * {@link #pause()}, followed by {@link #flush()} to discard audio data that hasn't been played
 * back yet.
 * @throws IllegalStateException
 */

public void stop() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Pauses the playback of the audio data. Data that has not been played
 * back will not be discarded. Subsequent calls to {@link #play} will play
 * this data back. See {@link #flush()} to discard this data.
 *
 * @throws IllegalStateException
 */

public void pause() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Flushes the audio data currently queued for playback. Any data that has
 * been written but not yet presented will be discarded.  No-op if not stopped or paused,
 * or if the track's creation mode is not {@link #MODE_STREAM}.
 * <BR> Note that although data written but not yet presented is discarded, there is no
 * guarantee that all of the buffer space formerly used by that data
 * is available for a subsequent write.
 * For example, a call to {@link #write(byte[], int, int)} with <code>sizeInBytes</code>
 * less than or equal to the total buffer size
 * may return a short actual transfer count.
 */

public void flush() { throw new RuntimeException("Stub!"); }

/**
 * Writes the audio data to the audio sink for playback (streaming mode),
 * or copies audio data for later playback (static buffer mode).
 * The format specified in the AudioTrack constructor should be
 * {@link AudioFormat#ENCODING_PCM_8BIT} to correspond to the data in the array.
 * The format can be {@link AudioFormat#ENCODING_PCM_16BIT}, but this is deprecated.
 * <p>
 * In streaming mode, the write will normally block until all the data has been enqueued for
 * playback, and will return a full transfer count.  However, if the track is stopped or paused
 * on entry, or another thread interrupts the write by calling stop or pause, or an I/O error
 * occurs during the write, then the write may return a short transfer count.
 * <p>
 * In static buffer mode, copies the data to the buffer starting at offset 0.
 * Note that the actual playback of this data might occur after this function returns.
 *
 * @param audioData the array that holds the data to play.
 * This value must never be {@code null}.
 * @param offsetInBytes the offset expressed in bytes in audioData where the data to write
 *    starts.
 *    Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInBytes the number of bytes to write in audioData after the offset.
 *    Must not be negative, or cause the data access to go out of bounds of the array.
 * @return zero or the positive number of bytes that were written, or one of the following
 *    error codes. The number of bytes will be a multiple of the frame size in bytes
 *    not to exceed sizeInBytes.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the track isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the AudioTrack is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next write()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 * This is equivalent to {@link #write(byte[], int, int, int)} with <code>writeMode</code>
 * set to  {@link #WRITE_BLOCKING}.
 */

public int write(@androidx.annotation.RecentlyNonNull byte[] audioData, int offsetInBytes, int sizeInBytes) { throw new RuntimeException("Stub!"); }

/**
 * Writes the audio data to the audio sink for playback (streaming mode),
 * or copies audio data for later playback (static buffer mode).
 * The format specified in the AudioTrack constructor should be
 * {@link AudioFormat#ENCODING_PCM_8BIT} to correspond to the data in the array.
 * The format can be {@link AudioFormat#ENCODING_PCM_16BIT}, but this is deprecated.
 * <p>
 * In streaming mode, the blocking behavior depends on the write mode.  If the write mode is
 * {@link #WRITE_BLOCKING}, the write will normally block until all the data has been enqueued
 * for playback, and will return a full transfer count.  However, if the write mode is
 * {@link #WRITE_NON_BLOCKING}, or the track is stopped or paused on entry, or another thread
 * interrupts the write by calling stop or pause, or an I/O error
 * occurs during the write, then the write may return a short transfer count.
 * <p>
 * In static buffer mode, copies the data to the buffer starting at offset 0,
 * and the write mode is ignored.
 * Note that the actual playback of this data might occur after this function returns.
 *
 * @param audioData the array that holds the data to play.
 * This value must never be {@code null}.
 * @param offsetInBytes the offset expressed in bytes in audioData where the data to write
 *    starts.
 *    Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInBytes the number of bytes to write in audioData after the offset.
 *    Must not be negative, or cause the data access to go out of bounds of the array.
 * @param writeMode one of {@link #WRITE_BLOCKING}, {@link #WRITE_NON_BLOCKING}. It has no
 *     effect in static mode.
 *     <br>With {@link #WRITE_BLOCKING}, the write will block until all data has been written
 *         to the audio sink.
 *     <br>With {@link #WRITE_NON_BLOCKING}, the write will return immediately after
 *     queuing as much audio data for playback as possible without blocking.
 * Value is {@link android.media.AudioTrack#WRITE_BLOCKING}, or {@link android.media.AudioTrack#WRITE_NON_BLOCKING}
 * @return zero or the positive number of bytes that were written, or one of the following
 *    error codes. The number of bytes will be a multiple of the frame size in bytes
 *    not to exceed sizeInBytes.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the track isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the AudioTrack is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next write()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 */

public int write(@androidx.annotation.RecentlyNonNull byte[] audioData, int offsetInBytes, int sizeInBytes, int writeMode) { throw new RuntimeException("Stub!"); }

/**
 * Writes the audio data to the audio sink for playback (streaming mode),
 * or copies audio data for later playback (static buffer mode).
 * The format specified in the AudioTrack constructor should be
 * {@link AudioFormat#ENCODING_PCM_16BIT} to correspond to the data in the array.
 * <p>
 * In streaming mode, the write will normally block until all the data has been enqueued for
 * playback, and will return a full transfer count.  However, if the track is stopped or paused
 * on entry, or another thread interrupts the write by calling stop or pause, or an I/O error
 * occurs during the write, then the write may return a short transfer count.
 * <p>
 * In static buffer mode, copies the data to the buffer starting at offset 0.
 * Note that the actual playback of this data might occur after this function returns.
 *
 * @param audioData the array that holds the data to play.
 * This value must never be {@code null}.
 * @param offsetInShorts the offset expressed in shorts in audioData where the data to play
 *     starts.
 *    Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInShorts the number of shorts to read in audioData after the offset.
 *    Must not be negative, or cause the data access to go out of bounds of the array.
 * @return zero or the positive number of shorts that were written, or one of the following
 *    error codes. The number of shorts will be a multiple of the channel count not to
 *    exceed sizeInShorts.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the track isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the AudioTrack is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next write()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 * This is equivalent to {@link #write(short[], int, int, int)} with <code>writeMode</code>
 * set to  {@link #WRITE_BLOCKING}.
 */

public int write(@androidx.annotation.RecentlyNonNull short[] audioData, int offsetInShorts, int sizeInShorts) { throw new RuntimeException("Stub!"); }

/**
 * Writes the audio data to the audio sink for playback (streaming mode),
 * or copies audio data for later playback (static buffer mode).
 * The format specified in the AudioTrack constructor should be
 * {@link AudioFormat#ENCODING_PCM_16BIT} to correspond to the data in the array.
 * <p>
 * In streaming mode, the blocking behavior depends on the write mode.  If the write mode is
 * {@link #WRITE_BLOCKING}, the write will normally block until all the data has been enqueued
 * for playback, and will return a full transfer count.  However, if the write mode is
 * {@link #WRITE_NON_BLOCKING}, or the track is stopped or paused on entry, or another thread
 * interrupts the write by calling stop or pause, or an I/O error
 * occurs during the write, then the write may return a short transfer count.
 * <p>
 * In static buffer mode, copies the data to the buffer starting at offset 0.
 * Note that the actual playback of this data might occur after this function returns.
 *
 * @param audioData the array that holds the data to write.
 * This value must never be {@code null}.
 * @param offsetInShorts the offset expressed in shorts in audioData where the data to write
 *     starts.
 *    Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInShorts the number of shorts to read in audioData after the offset.
 *    Must not be negative, or cause the data access to go out of bounds of the array.
 * @param writeMode one of {@link #WRITE_BLOCKING}, {@link #WRITE_NON_BLOCKING}. It has no
 *     effect in static mode.
 *     <br>With {@link #WRITE_BLOCKING}, the write will block until all data has been written
 *         to the audio sink.
 *     <br>With {@link #WRITE_NON_BLOCKING}, the write will return immediately after
 *     queuing as much audio data for playback as possible without blocking.
 * Value is {@link android.media.AudioTrack#WRITE_BLOCKING}, or {@link android.media.AudioTrack#WRITE_NON_BLOCKING}
 * @return zero or the positive number of shorts that were written, or one of the following
 *    error codes. The number of shorts will be a multiple of the channel count not to
 *    exceed sizeInShorts.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the track isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the AudioTrack is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next write()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 */

public int write(@androidx.annotation.RecentlyNonNull short[] audioData, int offsetInShorts, int sizeInShorts, int writeMode) { throw new RuntimeException("Stub!"); }

/**
 * Writes the audio data to the audio sink for playback (streaming mode),
 * or copies audio data for later playback (static buffer mode).
 * The format specified in the AudioTrack constructor should be
 * {@link AudioFormat#ENCODING_PCM_FLOAT} to correspond to the data in the array.
 * <p>
 * In streaming mode, the blocking behavior depends on the write mode.  If the write mode is
 * {@link #WRITE_BLOCKING}, the write will normally block until all the data has been enqueued
 * for playback, and will return a full transfer count.  However, if the write mode is
 * {@link #WRITE_NON_BLOCKING}, or the track is stopped or paused on entry, or another thread
 * interrupts the write by calling stop or pause, or an I/O error
 * occurs during the write, then the write may return a short transfer count.
 * <p>
 * In static buffer mode, copies the data to the buffer starting at offset 0,
 * and the write mode is ignored.
 * Note that the actual playback of this data might occur after this function returns.
 *
 * @param audioData the array that holds the data to write.
 *     The implementation does not clip for sample values within the nominal range
 *     [-1.0f, 1.0f], provided that all gains in the audio pipeline are
 *     less than or equal to unity (1.0f), and in the absence of post-processing effects
 *     that could add energy, such as reverb.  For the convenience of applications
 *     that compute samples using filters with non-unity gain,
 *     sample values +3 dB beyond the nominal range are permitted.
 *     However such values may eventually be limited or clipped, depending on various gains
 *     and later processing in the audio path.  Therefore applications are encouraged
 *     to provide samples values within the nominal range.
 * This value must never be {@code null}.
 * @param offsetInFloats the offset, expressed as a number of floats,
 *     in audioData where the data to write starts.
 *    Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInFloats the number of floats to write in audioData after the offset.
 *    Must not be negative, or cause the data access to go out of bounds of the array.
 * @param writeMode one of {@link #WRITE_BLOCKING}, {@link #WRITE_NON_BLOCKING}. It has no
 *     effect in static mode.
 *     <br>With {@link #WRITE_BLOCKING}, the write will block until all data has been written
 *         to the audio sink.
 *     <br>With {@link #WRITE_NON_BLOCKING}, the write will return immediately after
 *     queuing as much audio data for playback as possible without blocking.
 * Value is {@link android.media.AudioTrack#WRITE_BLOCKING}, or {@link android.media.AudioTrack#WRITE_NON_BLOCKING}
 * @return zero or the positive number of floats that were written, or one of the following
 *    error codes. The number of floats will be a multiple of the channel count not to
 *    exceed sizeInFloats.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the track isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the AudioTrack is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next write()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 */

public int write(@androidx.annotation.RecentlyNonNull float[] audioData, int offsetInFloats, int sizeInFloats, int writeMode) { throw new RuntimeException("Stub!"); }

/**
 * Writes the audio data to the audio sink for playback (streaming mode),
 * or copies audio data for later playback (static buffer mode).
 * The audioData in ByteBuffer should match the format specified in the AudioTrack constructor.
 * <p>
 * In streaming mode, the blocking behavior depends on the write mode.  If the write mode is
 * {@link #WRITE_BLOCKING}, the write will normally block until all the data has been enqueued
 * for playback, and will return a full transfer count.  However, if the write mode is
 * {@link #WRITE_NON_BLOCKING}, or the track is stopped or paused on entry, or another thread
 * interrupts the write by calling stop or pause, or an I/O error
 * occurs during the write, then the write may return a short transfer count.
 * <p>
 * In static buffer mode, copies the data to the buffer starting at offset 0,
 * and the write mode is ignored.
 * Note that the actual playback of this data might occur after this function returns.
 *
 * @param audioData the buffer that holds the data to write, starting at the position reported
 *     by <code>audioData.position()</code>.
 *     <BR>Note that upon return, the buffer position (<code>audioData.position()</code>) will
 *     have been advanced to reflect the amount of data that was successfully written to
 *     the AudioTrack.
 * This value must never be {@code null}.
 * @param sizeInBytes number of bytes to write.  It is recommended but not enforced
 *     that the number of bytes requested be a multiple of the frame size (sample size in
 *     bytes multiplied by the channel count).
 *     <BR>Note this may differ from <code>audioData.remaining()</code>, but cannot exceed it.
 * @param writeMode one of {@link #WRITE_BLOCKING}, {@link #WRITE_NON_BLOCKING}. It has no
 *     effect in static mode.
 *     <BR>With {@link #WRITE_BLOCKING}, the write will block until all data has been written
 *         to the audio sink.
 *     <BR>With {@link #WRITE_NON_BLOCKING}, the write will return immediately after
 *     queuing as much audio data for playback as possible without blocking.
 * Value is {@link android.media.AudioTrack#WRITE_BLOCKING}, or {@link android.media.AudioTrack#WRITE_NON_BLOCKING}
 * @return zero or the positive number of bytes that were written, or one of the following
 *    error codes.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the track isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the AudioTrack is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next write()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 */

public int write(@androidx.annotation.RecentlyNonNull java.nio.ByteBuffer audioData, int sizeInBytes, int writeMode) { throw new RuntimeException("Stub!"); }

/**
 * Writes the audio data to the audio sink for playback in streaming mode on a HW_AV_SYNC track.
 * The blocking behavior will depend on the write mode.
 * @param audioData the buffer that holds the data to write, starting at the position reported
 *     by <code>audioData.position()</code>.
 *     <BR>Note that upon return, the buffer position (<code>audioData.position()</code>) will
 *     have been advanced to reflect the amount of data that was successfully written to
 *     the AudioTrack.
 * This value must never be {@code null}.
 * @param sizeInBytes number of bytes to write.  It is recommended but not enforced
 *     that the number of bytes requested be a multiple of the frame size (sample size in
 *     bytes multiplied by the channel count).
 *     <BR>Note this may differ from <code>audioData.remaining()</code>, but cannot exceed it.
 * @param writeMode one of {@link #WRITE_BLOCKING}, {@link #WRITE_NON_BLOCKING}.
 *     <BR>With {@link #WRITE_BLOCKING}, the write will block until all data has been written
 *         to the audio sink.
 *     <BR>With {@link #WRITE_NON_BLOCKING}, the write will return immediately after
 *     queuing as much audio data for playback as possible without blocking.
 * Value is {@link android.media.AudioTrack#WRITE_BLOCKING}, or {@link android.media.AudioTrack#WRITE_NON_BLOCKING}
 * @param timestamp The timestamp of the first decodable audio frame in the provided audioData.
 * @return zero or the positive number of bytes that were written, or one of the following
 *    error codes.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the track isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the AudioTrack is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next write()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 */

public int write(@androidx.annotation.RecentlyNonNull java.nio.ByteBuffer audioData, int sizeInBytes, int writeMode, long timestamp) { throw new RuntimeException("Stub!"); }

/**
 * Sets the playback head position within the static buffer to zero,
 * that is it rewinds to start of static buffer.
 * The track must be stopped or paused, and
 * the track's creation mode must be {@link #MODE_STATIC}.
 * <p>
 * As of {@link android.os.Build.VERSION_CODES#M}, also resets the value returned by
 * {@link #getPlaybackHeadPosition()} to zero.
 * For earlier API levels, the reset behavior is unspecified.
 * <p>
 * Use {@link #setPlaybackHeadPosition(int)} with a zero position
 * if the reset of <code>getPlaybackHeadPosition()</code> is not needed.
 * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
 *  {@link #ERROR_INVALID_OPERATION}
 */

public int reloadStaticData() { throw new RuntimeException("Stub!"); }

/**
 * Attaches an auxiliary effect to the audio track. A typical auxiliary
 * effect is a reverberation effect which can be applied on any sound source
 * that directs a certain amount of its energy to this effect. This amount
 * is defined by setAuxEffectSendLevel().
 * {@see #setAuxEffectSendLevel(float)}.
 * <p>After creating an auxiliary effect (e.g.
 * {@link android.media.audiofx.EnvironmentalReverb}), retrieve its ID with
 * {@link android.media.audiofx.AudioEffect#getId()} and use it when calling
 * this method to attach the audio track to the effect.
 * <p>To detach the effect from the audio track, call this method with a
 * null effect id.
 *
 * @param effectId system wide unique id of the effect to attach
 * @return error code or success, see {@link #SUCCESS},
 *    {@link #ERROR_INVALID_OPERATION}, {@link #ERROR_BAD_VALUE}
 */

public int attachAuxEffect(int effectId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the send level of the audio track to the attached auxiliary effect
 * {@link #attachAuxEffect(int)}.  Effect levels
 * are clamped to the closed interval [0.0, max] where
 * max is the value of {@link #getMaxVolume}.
 * A value of 0.0 results in no effect, and a value of 1.0 is full send.
 * <p>By default the send level is 0.0f, so even if an effect is attached to the player
 * this method must be called for the effect to be applied.
 * <p>Note that the passed level value is a linear scalar. UI controls should be scaled
 * logarithmically: the gain applied by audio framework ranges from -72dB to at least 0dB,
 * so an appropriate conversion from linear UI input x to level is:
 * x == 0 -&gt; level = 0
 * 0 &lt; x &lt;= R -&gt; level = 10^(72*(x-R)/20/R)
 *
 * @param level linear send level
 * @return error code or success, see {@link #SUCCESS},
 *    {@link #ERROR_INVALID_OPERATION}, {@link #ERROR}
 */

public int setAuxEffectSendLevel(float level) { throw new RuntimeException("Stub!"); }

/**
 * Specifies an audio device (via an {@link AudioDeviceInfo} object) to route
 * the output from this AudioTrack.
 * @param deviceInfo The {@link AudioDeviceInfo} specifying the audio sink.
 *  If deviceInfo is null, default routing is restored.
 * @return true if succesful, false if the specified {@link AudioDeviceInfo} is non-null and
 * does not correspond to a valid audio output device.
 */

public boolean setPreferredDevice(android.media.AudioDeviceInfo deviceInfo) { throw new RuntimeException("Stub!"); }

/**
 * Returns the selected output specified by {@link #setPreferredDevice}. Note that this
 * is not guaranteed to correspond to the actual device being used for playback.
 */

public android.media.AudioDeviceInfo getPreferredDevice() { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@link AudioDeviceInfo} identifying the current routing of this AudioTrack.
 * Note: The query is only valid if the AudioTrack is currently playing. If it is not,
 * <code>getRoutedDevice()</code> will return null.
 */

public android.media.AudioDeviceInfo getRoutedDevice() { throw new RuntimeException("Stub!"); }

/**
 * Adds an {@link AudioRouting.OnRoutingChangedListener} to receive notifications of routing
 * changes on this AudioTrack.
 * @param listener The {@link AudioRouting.OnRoutingChangedListener} interface to receive
 * notifications of rerouting events.
 * @param handler  Specifies the {@link Handler} object for the thread on which to execute
 * the callback. If <code>null</code>, the {@link Handler} associated with the main
 * {@link Looper} will be used.
 */

public void addOnRoutingChangedListener(android.media.AudioRouting.OnRoutingChangedListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes an {@link AudioRouting.OnRoutingChangedListener} which has been previously added
 * to receive rerouting notifications.
 * @param listener The previously added {@link AudioRouting.OnRoutingChangedListener} interface
 * to remove.
 */

public void removeOnRoutingChangedListener(android.media.AudioRouting.OnRoutingChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Adds an {@link OnRoutingChangedListener} to receive notifications of routing changes
 * on this AudioTrack.
 * @param listener The {@link OnRoutingChangedListener} interface to receive notifications
 * of rerouting events.
 * @param handler  Specifies the {@link Handler} object for the thread on which to execute
 * the callback. If <code>null</code>, the {@link Handler} associated with the main
 * {@link Looper} will be used.
 * @deprecated users should switch to the general purpose
 *             {@link AudioRouting.OnRoutingChangedListener} class instead.
 */

@Deprecated public void addOnRoutingChangedListener(android.media.AudioTrack.OnRoutingChangedListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes an {@link OnRoutingChangedListener} which has been previously added
 * to receive rerouting notifications.
 * @param listener The previously added {@link OnRoutingChangedListener} interface to remove.
 * @deprecated users should switch to the general purpose
 *             {@link AudioRouting.OnRoutingChangedListener} class instead.
 */

@Deprecated public void removeOnRoutingChangedListener(android.media.AudioTrack.OnRoutingChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Denotes a generic operation failure.
 */

public static final int ERROR = -1; // 0xffffffff

/**
 * Denotes a failure due to the use of an invalid value.
 */

public static final int ERROR_BAD_VALUE = -2; // 0xfffffffe

/**
 * An error code indicating that the object reporting it is no longer valid and needs to
 * be recreated.
 */

public static final int ERROR_DEAD_OBJECT = -6; // 0xfffffffa

/**
 * Denotes a failure due to the improper use of a method.
 */

public static final int ERROR_INVALID_OPERATION = -3; // 0xfffffffd

/**
 * Creation mode where audio data is transferred from Java to the native layer
 * only once before the audio starts playing.
 */

public static final int MODE_STATIC = 0; // 0x0

/**
 * Creation mode where audio data is streamed from Java to the native layer
 * as the audio is playing.
 */

public static final int MODE_STREAM = 1; // 0x1

/**
 * Low latency performance mode for an {@link AudioTrack}.
 * If the device supports it, this mode
 * enables a lower latency path through to the audio output sink.
 * Effects may no longer work with such an {@code AudioTrack} and
 * the sample rate must match that of the output sink.
 * <p>
 * Applications should be aware that low latency requires careful
 * buffer management, with smaller chunks of audio data written by each
 * {@code write()} call.
 * <p>
 * If this flag is used without specifying a {@code bufferSizeInBytes} then the
 * {@code AudioTrack}'s actual buffer size may be too small.
 * It is recommended that a fairly
 * large buffer should be specified when the {@code AudioTrack} is created.
 * Then the actual size can be reduced by calling
 * {@link #setBufferSizeInFrames(int)}. The buffer size can be optimized
 * by lowering it after each {@code write()} call until the audio glitches,
 * which is detected by calling
 * {@link #getUnderrunCount()}. Then the buffer size can be increased
 * until there are no glitches.
 * This tuning step should be done while playing silence.
 * This technique provides a compromise between latency and glitch rate.
 */

public static final int PERFORMANCE_MODE_LOW_LATENCY = 1; // 0x1

/**
 * Default performance mode for an {@link AudioTrack}.
 */

public static final int PERFORMANCE_MODE_NONE = 0; // 0x0

/**
 * Power saving performance mode for an {@link AudioTrack}.
 * If the device supports it, this
 * mode will enable a lower power path to the audio output sink.
 * In addition, this lower power path typically will have
 * deeper internal buffers and better underrun resistance,
 * with a tradeoff of higher latency.
 * <p>
 * In this mode, applications should attempt to use a larger buffer size
 * and deliver larger chunks of audio data per {@code write()} call.
 * Use {@link #getBufferSizeInFrames()} to determine
 * the actual buffer size of the {@code AudioTrack} as it may have increased
 * to accommodate a deeper buffer.
 */

public static final int PERFORMANCE_MODE_POWER_SAVING = 2; // 0x2

/** indicates AudioTrack state is paused */

public static final int PLAYSTATE_PAUSED = 2; // 0x2

/** indicates AudioTrack state is playing */

public static final int PLAYSTATE_PLAYING = 3; // 0x3

/** indicates AudioTrack state is stopped */

public static final int PLAYSTATE_STOPPED = 1; // 0x1

/**
 * State of an AudioTrack that is ready to be used.
 */

public static final int STATE_INITIALIZED = 1; // 0x1

/**
 * State of a successfully initialized AudioTrack that uses static data,
 * but that hasn't received that data yet.
 */

public static final int STATE_NO_STATIC_DATA = 2; // 0x2

/**
 * State of an AudioTrack that was not successfully initialized upon creation.
 */

public static final int STATE_UNINITIALIZED = 0; // 0x0

/**
 * Denotes a successful operation.
 */

public static final int SUCCESS = 0; // 0x0

/**
 * The write mode indicating the write operation will block until all data has been written,
 * to be used as the actual value of the writeMode parameter in
 * {@link #write(byte[], int, int, int)}, {@link #write(short[], int, int, int)},
 * {@link #write(float[], int, int, int)}, {@link #write(ByteBuffer, int, int)}, and
 * {@link #write(ByteBuffer, int, int, long)}.
 */

public static final int WRITE_BLOCKING = 0; // 0x0

/**
 * The write mode indicating the write operation will return immediately after
 * queuing as much audio data for playback as possible without blocking,
 * to be used as the actual value of the writeMode parameter in
 * {@link #write(ByteBuffer, int, int)}, {@link #write(short[], int, int, int)},
 * {@link #write(float[], int, int, int)}, {@link #write(ByteBuffer, int, int)}, and
 * {@link #write(ByteBuffer, int, int, long)}.
 */

public static final int WRITE_NON_BLOCKING = 1; // 0x1
/**
 * Builder class for {@link AudioTrack} objects.
 * Use this class to configure and create an <code>AudioTrack</code> instance. By setting audio
 * attributes and audio format parameters, you indicate which of those vary from the default
 * behavior on the device.
 * <p> Here is an example where <code>Builder</code> is used to specify all {@link AudioFormat}
 * parameters, to be used by a new <code>AudioTrack</code> instance:
 *
 * <pre class="prettyprint">
 * AudioTrack player = new AudioTrack.Builder()
 *         .setAudioAttributes(new AudioAttributes.Builder()
 *                  .setUsage(AudioAttributes.USAGE_ALARM)
 *                  .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
 *                  .build())
 *         .setAudioFormat(new AudioFormat.Builder()
 *                 .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
 *                 .setSampleRate(44100)
 *                 .setChannelMask(AudioFormat.CHANNEL_OUT_STEREO)
 *                 .build())
 *         .setBufferSizeInBytes(minBuffSize)
 *         .build();
 * </pre>
 * <p>
 * If the audio attributes are not set with {@link #setAudioAttributes(AudioAttributes)},
 * attributes comprising {@link AudioAttributes#USAGE_MEDIA} will be used.
 * <br>If the audio format is not specified or is incomplete, its channel configuration will be
 * {@link AudioFormat#CHANNEL_OUT_STEREO} and the encoding will be
 * {@link AudioFormat#ENCODING_PCM_16BIT}.
 * The sample rate will depend on the device actually selected for playback and can be queried
 * with {@link #getSampleRate()} method.
 * <br>If the buffer size is not specified with {@link #setBufferSizeInBytes(int)},
 * and the mode is {@link AudioTrack#MODE_STREAM}, the minimum buffer size is used.
 * <br>If the transfer mode is not specified with {@link #setTransferMode(int)},
 * <code>MODE_STREAM</code> will be used.
 * <br>If the session ID is not specified with {@link #setSessionId(int)}, a new one will
 * be generated.
 * <br>Offload is false by default.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Constructs a new Builder with the default values as described above.
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link AudioAttributes}.
 * @param attributes a non-null {@link AudioAttributes} instance that describes the audio
 *     data to be played.
 * This value must never be {@code null}.
 * @return the same Builder instance.
 * @throws IllegalArgumentException
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioTrack.Builder setAudioAttributes(@androidx.annotation.RecentlyNonNull android.media.AudioAttributes attributes) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the format of the audio data to be played by the {@link AudioTrack}.
 * See {@link AudioFormat.Builder} for configuring the audio format parameters such
 * as encoding, channel mask and sample rate.
 * @param format a non-null {@link AudioFormat} instance.
 * This value must never be {@code null}.
 * @return the same Builder instance.
 * @throws IllegalArgumentException
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioTrack.Builder setAudioFormat(@androidx.annotation.RecentlyNonNull android.media.AudioFormat format) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the total size (in bytes) of the buffer where audio data is read from for playback.
 * If using the {@link AudioTrack} in streaming mode
 * (see {@link AudioTrack#MODE_STREAM}, you can write data into this buffer in smaller
 * chunks than this size. See {@link #getMinBufferSize(int, int, int)} to determine
 * the estimated minimum buffer size for the creation of an AudioTrack instance
 * in streaming mode.
 * <br>If using the <code>AudioTrack</code> in static mode (see
 * {@link AudioTrack#MODE_STATIC}), this is the maximum size of the sound that will be
 * played by this instance.
 * @param bufferSizeInBytes
 * @return the same Builder instance.
 * This value will never be {@code null}.
 * @throws IllegalArgumentException
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioTrack.Builder setBufferSizeInBytes(int bufferSizeInBytes) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the mode under which buffers of audio data are transferred from the
 * {@link AudioTrack} to the framework.
 * @param mode one of {@link AudioTrack#MODE_STREAM}, {@link AudioTrack#MODE_STATIC}.
 * Value is {@link android.media.AudioTrack#MODE_STATIC}, or {@link android.media.AudioTrack#MODE_STREAM}
 * @return the same Builder instance.
 * This value will never be {@code null}.
 * @throws IllegalArgumentException
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioTrack.Builder setTransferMode(int mode) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the session ID the {@link AudioTrack} will be attached to.
 * @param sessionId a strictly positive ID number retrieved from another
 *     <code>AudioTrack</code> via {@link AudioTrack#getAudioSessionId()} or allocated by
 *     {@link AudioManager} via {@link AudioManager#generateAudioSessionId()}, or
 *     {@link AudioManager#AUDIO_SESSION_ID_GENERATE}.
 * @return the same Builder instance.
 * This value will never be {@code null}.
 * @throws IllegalArgumentException
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioTrack.Builder setSessionId(int sessionId) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link AudioTrack} performance mode.  This is an advisory request which
 * may not be supported by the particular device, and the framework is free
 * to ignore such request if it is incompatible with other requests or hardware.
 *
 * @param performanceMode one of
 * {@link AudioTrack#PERFORMANCE_MODE_NONE},
 * {@link AudioTrack#PERFORMANCE_MODE_LOW_LATENCY},
 * or {@link AudioTrack#PERFORMANCE_MODE_POWER_SAVING}.
 * Value is {@link android.media.AudioTrack#PERFORMANCE_MODE_NONE}, {@link android.media.AudioTrack#PERFORMANCE_MODE_LOW_LATENCY}, or {@link android.media.AudioTrack#PERFORMANCE_MODE_POWER_SAVING}
 * @return the same Builder instance.
 * This value will never be {@code null}.
 * @throws IllegalArgumentException if {@code performanceMode} is not valid.
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioTrack.Builder setPerformanceMode(int performanceMode) { throw new RuntimeException("Stub!"); }

/**
 * Builds an {@link AudioTrack} instance initialized with all the parameters set
 * on this <code>Builder</code>.
 * @return a new successfully initialized {@link AudioTrack} instance.
 * This value will never be {@code null}.
 * @throws UnsupportedOperationException if the parameters set on the <code>Builder</code>
 *     were incompatible, or if they are not supported by the device,
 *     or if the device was not available.
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioTrack build() throws java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }
}

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MetricsConstants {

MetricsConstants() { throw new RuntimeException("Stub!"); }

/**
 * Key to extract the channel mask information for this track
 * from the {@link AudioTrack#getMetrics} return value.
 *
 * The value is a Long integer.
 */

public static final java.lang.String CHANNELMASK = "android.media.audiorecord.channelmask";

/**
 * Key to extract the Content Type for this track
 * from the {@link AudioTrack#getMetrics} return value.
 * The value is a String.
 */

public static final java.lang.String CONTENTTYPE = "android.media.audiotrack.type";

/**
 * Key to extract the sample rate for this track in Hz
 * from the {@link AudioTrack#getMetrics} return value.
 * The value is an integer.
 */

public static final java.lang.String SAMPLERATE = "android.media.audiorecord.samplerate";

/**
 * Key to extract the Stream Type for this track
 * from the {@link AudioTrack#getMetrics} return value.
 * The value is a String.
 */

public static final java.lang.String STREAMTYPE = "android.media.audiotrack.streamtype";

/**
 * Key to extract the Content Type for this track
 * from the {@link AudioTrack#getMetrics} return value.
 * The value is a String.
 */

public static final java.lang.String USAGE = "android.media.audiotrack.usage";
}

/**
 * Interface definition for a callback to be invoked when the playback head position of
 * an AudioTrack has reached a notification marker or has increased by a certain period.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnPlaybackPositionUpdateListener {

/**
 * Called on the listener to notify it that the previously set marker has been reached
 * by the playback head.
 */

public void onMarkerReached(android.media.AudioTrack track);

/**
 * Called on the listener to periodically notify it that the playback head has reached
 * a multiple of the notification period.
 */

public void onPeriodicNotification(android.media.AudioTrack track);
}

/**
 * Defines the interface by which applications can receive notifications of
 * routing changes for the associated {@link AudioTrack}.
 *
 * @deprecated users should switch to the general purpose
 *             {@link AudioRouting.OnRoutingChangedListener} class instead.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public static interface OnRoutingChangedListener extends android.media.AudioRouting.OnRoutingChangedListener {

/**
 * Called when the routing of an AudioTrack changes from either and
 * explicit or policy rerouting. Use {@link #getRoutedDevice()} to
 * retrieve the newly routed-to device.
 */

public void onRoutingChanged(android.media.AudioTrack audioTrack);

public default void onRoutingChanged(android.media.AudioRouting router) { throw new RuntimeException("Stub!"); }
}

}

