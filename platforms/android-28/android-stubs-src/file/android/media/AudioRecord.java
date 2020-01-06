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

import java.nio.ByteBuffer;
import android.os.PersistableBundle;
import android.os.Handler;
import java.util.List;
import android.os.Looper;
import java.io.IOException;

/**
 * The AudioRecord class manages the audio resources for Java applications
 * to record audio from the audio input hardware of the platform. This is
 * achieved by "pulling" (reading) the data from the AudioRecord object. The
 * application is responsible for polling the AudioRecord object in time using one of
 * the following three methods:  {@link #read(byte[],int, int)}, {@link #read(short[], int, int)}
 * or {@link #read(ByteBuffer, int)}. The choice of which method to use will be based
 * on the audio data storage format that is the most convenient for the user of AudioRecord.
 * <p>Upon creation, an AudioRecord object initializes its associated audio buffer that it will
 * fill with the new audio data. The size of this buffer, specified during the construction,
 * determines how long an AudioRecord can record before "over-running" data that has not
 * been read yet. Data should be read from the audio hardware in chunks of sizes inferior to
 * the total recording buffer size.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AudioRecord implements android.media.AudioRouting {

/**
 * Class constructor.
 * Though some invalid parameters will result in an {@link IllegalArgumentException} exception,
 * other errors do not.  Thus you should call {@link #getState()} immediately after construction
 * to confirm that the object is usable.
 * @param audioSource the recording source.
 *   See {@link MediaRecorder.AudioSource} for the recording source definitions.
 * @param sampleRateInHz the sample rate expressed in Hertz. 44100Hz is currently the only
 *   rate that is guaranteed to work on all devices, but other rates such as 22050,
 *   16000, and 11025 may work on some devices.
 *   {@link AudioFormat#SAMPLE_RATE_UNSPECIFIED} means to use a route-dependent value
 *   which is usually the sample rate of the source.
 *   {@link #getSampleRate()} can be used to retrieve the actual sample rate chosen.
 * @param channelConfig describes the configuration of the audio channels.
 *   See {@link AudioFormat#CHANNEL_IN_MONO} and
 *   {@link AudioFormat#CHANNEL_IN_STEREO}.  {@link AudioFormat#CHANNEL_IN_MONO} is guaranteed
 *   to work on all devices.
 * @param audioFormat the format in which the audio data is to be returned.
 *   See {@link AudioFormat#ENCODING_PCM_8BIT}, {@link AudioFormat#ENCODING_PCM_16BIT},
 *   and {@link AudioFormat#ENCODING_PCM_FLOAT}.
 * @param bufferSizeInBytes the total size (in bytes) of the buffer where audio data is written
 *   to during the recording. New audio data can be read from this buffer in smaller chunks
 *   than this size. See {@link #getMinBufferSize(int, int, int)} to determine the minimum
 *   required buffer size for the successful creation of an AudioRecord instance. Using values
 *   smaller than getMinBufferSize() will result in an initialization failure.
 * @throws java.lang.IllegalArgumentException
 */

public AudioRecord(int audioSource, int sampleRateInHz, int channelConfig, int audioFormat, int bufferSizeInBytes) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Releases the native AudioRecord resources.
 * The object can no longer be used and the reference should be set to null
 * after a call to release()
 */

public void release() { throw new RuntimeException("Stub!"); }

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured audio sink sample rate in Hz.
 * The sink sample rate never changes after construction.
 * If the constructor had a specific sample rate, then the sink sample rate is that value.
 * If the constructor had {@link AudioFormat#SAMPLE_RATE_UNSPECIFIED},
 * then the sink sample rate is a route-dependent default value based on the source [sic].
 */

public int getSampleRate() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio recording source.
 * @see MediaRecorder.AudioSource
 */

public int getAudioSource() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured audio data encoding. See {@link AudioFormat#ENCODING_PCM_8BIT},
 * {@link AudioFormat#ENCODING_PCM_16BIT}, and {@link AudioFormat#ENCODING_PCM_FLOAT}.
 */

public int getAudioFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured channel position mask.
 * <p> See {@link AudioFormat#CHANNEL_IN_MONO}
 * and {@link AudioFormat#CHANNEL_IN_STEREO}.
 * This method may return {@link AudioFormat#CHANNEL_INVALID} if
 * a channel index mask is used.
 * Consider {@link #getFormat()} instead, to obtain an {@link AudioFormat},
 * which contains both the channel position mask and the channel index mask.
 */

public int getChannelConfiguration() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured <code>AudioRecord</code> format.
 * @return an {@link AudioFormat} containing the
 * <code>AudioRecord</code> parameters at the time of configuration.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.media.AudioFormat getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configured number of channels.
 */

public int getChannelCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the state of the AudioRecord instance. This is useful after the
 * AudioRecord instance has been created to check if it was initialized
 * properly. This ensures that the appropriate hardware resources have been
 * acquired.
 * @see AudioRecord#STATE_INITIALIZED
 * @see AudioRecord#STATE_UNINITIALIZED
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the recording state of the AudioRecord instance.
 * @see AudioRecord#RECORDSTATE_STOPPED
 * @see AudioRecord#RECORDSTATE_RECORDING
 */

public int getRecordingState() { throw new RuntimeException("Stub!"); }

/**
 *  Returns the frame count of the native <code>AudioRecord</code> buffer.
 *  This is greater than or equal to the bufferSizeInBytes converted to frame units
 *  specified in the <code>AudioRecord</code> constructor or Builder.
 *  The native frame count may be enlarged to accommodate the requirements of the
 *  source on creation or if the <code>AudioRecord</code>
 *  is subsequently rerouted.
 *  @return current size in frames of the <code>AudioRecord</code> buffer.
 *  @throws IllegalStateException
 */

public int getBufferSizeInFrames() { throw new RuntimeException("Stub!"); }

/**
 * Returns the notification marker position expressed in frames.
 */

public int getNotificationMarkerPosition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the notification update period expressed in frames.
 */

public int getPositionNotificationPeriod() { throw new RuntimeException("Stub!"); }

/**
 * Poll for an {@link AudioTimestamp} on demand.
 * <p>
 * The AudioTimestamp reflects the frame delivery information at
 * the earliest point available in the capture pipeline.
 * <p>
 * Calling {@link #startRecording()} following a {@link #stop()} will reset
 * the frame count to 0.
 *
 * @param outTimestamp a caller provided non-null AudioTimestamp instance,
 *        which is updated with the AudioRecord frame delivery information upon success.
 * This value must never be {@code null}.
 * @param timebase one of
 *        {@link AudioTimestamp#TIMEBASE_BOOTTIME AudioTimestamp.TIMEBASE_BOOTTIME} or
 *        {@link AudioTimestamp#TIMEBASE_MONOTONIC AudioTimestamp.TIMEBASE_MONOTONIC},
 *        used to select the clock for the AudioTimestamp time.
 * Value is {@link android.media.AudioTimestamp#TIMEBASE_MONOTONIC}, or {@link android.media.AudioTimestamp#TIMEBASE_BOOTTIME}
 * @return {@link #SUCCESS} if a timestamp is available,
 *         or {@link #ERROR_INVALID_OPERATION} if a timestamp not available.
 */

public int getTimestamp(@androidx.annotation.RecentlyNonNull android.media.AudioTimestamp outTimestamp, int timebase) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum buffer size required for the successful creation of an AudioRecord
 * object, in byte units.
 * Note that this size doesn't guarantee a smooth recording under load, and higher values
 * should be chosen according to the expected frequency at which the AudioRecord instance
 * will be polled for new data.
 * See {@link #AudioRecord(int, int, int, int, int)} for more information on valid
 * configuration values.
 * @param sampleRateInHz the sample rate expressed in Hertz.
 *   {@link AudioFormat#SAMPLE_RATE_UNSPECIFIED} is not permitted.
 * @param channelConfig describes the configuration of the audio channels.
 *   See {@link AudioFormat#CHANNEL_IN_MONO} and
 *   {@link AudioFormat#CHANNEL_IN_STEREO}
 * @param audioFormat the format in which the audio data is represented.
 *   See {@link AudioFormat#ENCODING_PCM_16BIT}.
 * @return {@link #ERROR_BAD_VALUE} if the recording parameters are not supported by the
 *  hardware, or an invalid parameter was passed,
 *  or {@link #ERROR} if the implementation was unable to query the hardware for its
 *  input properties,
 *   or the minimum buffer size expressed in bytes.
 * @see #AudioRecord(int, int, int, int, int)
 */

public static int getMinBufferSize(int sampleRateInHz, int channelConfig, int audioFormat) { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio session ID.
 *
 * @return the ID of the audio session this AudioRecord belongs to.
 */

public int getAudioSessionId() { throw new RuntimeException("Stub!"); }

/**
 * Starts recording from the AudioRecord instance.
 * @throws IllegalStateException
 */

public void startRecording() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Starts recording from the AudioRecord instance when the specified synchronization event
 * occurs on the specified audio session.
 * @throws IllegalStateException
 * @param syncEvent event that triggers the capture.
 * @see MediaSyncEvent
 */

public void startRecording(android.media.MediaSyncEvent syncEvent) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Stops recording.
 * @throws IllegalStateException
 */

public void stop() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a byte array.
 * The format specified in the AudioRecord constructor should be
 * {@link AudioFormat#ENCODING_PCM_8BIT} to correspond to the data in the array.
 * @param audioData the array to which the recorded audio data is written.
 * This value must never be {@code null}.
 * @param offsetInBytes index in audioData from which the data is written expressed in bytes.
 * @param sizeInBytes the number of requested bytes.
 * @return zero or the positive number of bytes that were read, or one of the following
 *    error codes. The number of bytes will not exceed sizeInBytes.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 */

public int read(@androidx.annotation.RecentlyNonNull byte[] audioData, int offsetInBytes, int sizeInBytes) { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a byte array.
 * The format specified in the AudioRecord constructor should be
 * {@link AudioFormat#ENCODING_PCM_8BIT} to correspond to the data in the array.
 * The format can be {@link AudioFormat#ENCODING_PCM_16BIT}, but this is deprecated.
 * @param audioData the array to which the recorded audio data is written.
 * This value must never be {@code null}.
 * @param offsetInBytes index in audioData to which the data is written expressed in bytes.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInBytes the number of requested bytes.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param readMode one of {@link #READ_BLOCKING}, {@link #READ_NON_BLOCKING}.
 *     <br>With {@link #READ_BLOCKING}, the read will block until all the requested data
 *     is read.
 *     <br>With {@link #READ_NON_BLOCKING}, the read will return immediately after
 *     reading as much audio data as possible without blocking.
 * Value is {@link android.media.AudioRecord#READ_BLOCKING}, or {@link android.media.AudioRecord#READ_NON_BLOCKING}
 * @return zero or the positive number of bytes that were read, or one of the following
 *    error codes. The number of bytes will be a multiple of the frame size in bytes
 *    not to exceed sizeInBytes.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 */

public int read(@androidx.annotation.RecentlyNonNull byte[] audioData, int offsetInBytes, int sizeInBytes, int readMode) { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a short array.
 * The format specified in the AudioRecord constructor should be
 * {@link AudioFormat#ENCODING_PCM_16BIT} to correspond to the data in the array.
 * @param audioData the array to which the recorded audio data is written.
 * This value must never be {@code null}.
 * @param offsetInShorts index in audioData to which the data is written expressed in shorts.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInShorts the number of requested shorts.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @return zero or the positive number of shorts that were read, or one of the following
 *    error codes. The number of shorts will be a multiple of the channel count not to exceed
 *    sizeInShorts.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 */

public int read(@androidx.annotation.RecentlyNonNull short[] audioData, int offsetInShorts, int sizeInShorts) { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a short array.
 * The format specified in the AudioRecord constructor should be
 * {@link AudioFormat#ENCODING_PCM_16BIT} to correspond to the data in the array.
 * @param audioData the array to which the recorded audio data is written.
 * This value must never be {@code null}.
 * @param offsetInShorts index in audioData from which the data is written expressed in shorts.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInShorts the number of requested shorts.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param readMode one of {@link #READ_BLOCKING}, {@link #READ_NON_BLOCKING}.
 *     <br>With {@link #READ_BLOCKING}, the read will block until all the requested data
 *     is read.
 *     <br>With {@link #READ_NON_BLOCKING}, the read will return immediately after
 *     reading as much audio data as possible without blocking.
 * Value is {@link android.media.AudioRecord#READ_BLOCKING}, or {@link android.media.AudioRecord#READ_NON_BLOCKING}
 * @return zero or the positive number of shorts that were read, or one of the following
 *    error codes. The number of shorts will be a multiple of the channel count not to exceed
 *    sizeInShorts.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 */

public int read(@androidx.annotation.RecentlyNonNull short[] audioData, int offsetInShorts, int sizeInShorts, int readMode) { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a float array.
 * The format specified in the AudioRecord constructor should be
 * {@link AudioFormat#ENCODING_PCM_FLOAT} to correspond to the data in the array.
 * @param audioData the array to which the recorded audio data is written.
 * This value must never be {@code null}.
 * @param offsetInFloats index in audioData from which the data is written.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param sizeInFloats the number of requested floats.
 *        Must not be negative, or cause the data access to go out of bounds of the array.
 * @param readMode one of {@link #READ_BLOCKING}, {@link #READ_NON_BLOCKING}.
 *     <br>With {@link #READ_BLOCKING}, the read will block until all the requested data
 *     is read.
 *     <br>With {@link #READ_NON_BLOCKING}, the read will return immediately after
 *     reading as much audio data as possible without blocking.
 * Value is {@link android.media.AudioRecord#READ_BLOCKING}, or {@link android.media.AudioRecord#READ_NON_BLOCKING}
 * @return zero or the positive number of floats that were read, or one of the following
 *    error codes. The number of floats will be a multiple of the channel count not to exceed
 *    sizeInFloats.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 */

public int read(@androidx.annotation.RecentlyNonNull float[] audioData, int offsetInFloats, int sizeInFloats, int readMode) { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a direct buffer. If this buffer
 * is not a direct buffer, this method will always return 0.
 * Note that the value returned by {@link java.nio.Buffer#position()} on this buffer is
 * unchanged after a call to this method.
 * The representation of the data in the buffer will depend on the format specified in
 * the AudioRecord constructor, and will be native endian.
 * @param audioBuffer the direct buffer to which the recorded audio data is written.
 * Data is written to audioBuffer.position().
 * This value must never be {@code null}.
 * @param sizeInBytes the number of requested bytes. It is recommended but not enforced
 *    that the number of bytes requested be a multiple of the frame size (sample size in
 *    bytes multiplied by the channel count).
 * @return zero or the positive number of bytes that were read, or one of the following
 *    error codes. The number of bytes will not exceed sizeInBytes and will be truncated to be
 *    a multiple of the frame size.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 */

public int read(@androidx.annotation.RecentlyNonNull java.nio.ByteBuffer audioBuffer, int sizeInBytes) { throw new RuntimeException("Stub!"); }

/**
 * Reads audio data from the audio hardware for recording into a direct buffer. If this buffer
 * is not a direct buffer, this method will always return 0.
 * Note that the value returned by {@link java.nio.Buffer#position()} on this buffer is
 * unchanged after a call to this method.
 * The representation of the data in the buffer will depend on the format specified in
 * the AudioRecord constructor, and will be native endian.
 * @param audioBuffer the direct buffer to which the recorded audio data is written.
 * Data is written to audioBuffer.position().
 * This value must never be {@code null}.
 * @param sizeInBytes the number of requested bytes. It is recommended but not enforced
 *    that the number of bytes requested be a multiple of the frame size (sample size in
 *    bytes multiplied by the channel count).
 * @param readMode one of {@link #READ_BLOCKING}, {@link #READ_NON_BLOCKING}.
 *     <br>With {@link #READ_BLOCKING}, the read will block until all the requested data
 *     is read.
 *     <br>With {@link #READ_NON_BLOCKING}, the read will return immediately after
 *     reading as much audio data as possible without blocking.
 * Value is {@link android.media.AudioRecord#READ_BLOCKING}, or {@link android.media.AudioRecord#READ_NON_BLOCKING}
 * @return zero or the positive number of bytes that were read, or one of the following
 *    error codes. The number of bytes will not exceed sizeInBytes and will be truncated to be
 *    a multiple of the frame size.
 * <ul>
 * <li>{@link #ERROR_INVALID_OPERATION} if the object isn't properly initialized</li>
 * <li>{@link #ERROR_BAD_VALUE} if the parameters don't resolve to valid data and indexes</li>
 * <li>{@link #ERROR_DEAD_OBJECT} if the object is not valid anymore and
 *    needs to be recreated. The dead object error code is not returned if some data was
 *    successfully transferred. In this case, the error is returned at the next read()</li>
 * <li>{@link #ERROR} in case of other error</li>
 * </ul>
 */

public int read(@androidx.annotation.RecentlyNonNull java.nio.ByteBuffer audioBuffer, int sizeInBytes, int readMode) { throw new RuntimeException("Stub!"); }

/**
 *  Return Metrics data about the current AudioTrack instance.
 *
 * @return a {@link PersistableBundle} containing the set of attributes and values
 * available for the media being handled by this instance of AudioRecord
 * The attributes are descibed in {@link MetricsConstants}.
 *
 * Additional vendor-specific fields may also be present in
 * the return value.
 */

public android.os.PersistableBundle getMetrics() { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener the AudioRecord notifies when a previously set marker is reached or
 * for each periodic record head position update.
 * @param listener
 */

public void setRecordPositionUpdateListener(android.media.AudioRecord.OnRecordPositionUpdateListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener the AudioRecord notifies when a previously set marker is reached or
 * for each periodic record head position update.
 * Use this method to receive AudioRecord events in the Handler associated with another
 * thread than the one in which you created the AudioRecord instance.
 * @param listener
 * @param handler the Handler that will receive the event notification messages.
 */

public void setRecordPositionUpdateListener(android.media.AudioRecord.OnRecordPositionUpdateListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Sets the marker position at which the listener is called, if set with
 * {@link #setRecordPositionUpdateListener(OnRecordPositionUpdateListener)} or
 * {@link #setRecordPositionUpdateListener(OnRecordPositionUpdateListener, Handler)}.
 * @param markerInFrames marker position expressed in frames
 * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_BAD_VALUE},
 *  {@link #ERROR_INVALID_OPERATION}
 */

public int setNotificationMarkerPosition(int markerInFrames) { throw new RuntimeException("Stub!"); }

/**
 * Returns an {@link AudioDeviceInfo} identifying the current routing of this AudioRecord.
 * Note: The query is only valid if the AudioRecord is currently recording. If it is not,
 * <code>getRoutedDevice()</code> will return null.
 */

public android.media.AudioDeviceInfo getRoutedDevice() { throw new RuntimeException("Stub!"); }

/**
 * Adds an {@link AudioRouting.OnRoutingChangedListener} to receive notifications of
 * routing changes on this AudioRecord.
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
 * on this AudioRecord.
 * @param listener The {@link OnRoutingChangedListener} interface to receive notifications
 * of rerouting events.
 * @param handler  Specifies the {@link Handler} object for the thread on which to execute
 * the callback. If <code>null</code>, the {@link Handler} associated with the main
 * {@link Looper} will be used.
 * @deprecated users should switch to the general purpose
 *             {@link AudioRouting.OnRoutingChangedListener} class instead.
 */

@Deprecated public void addOnRoutingChangedListener(android.media.AudioRecord.OnRoutingChangedListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes an {@link OnRoutingChangedListener} which has been previously added
 * to receive rerouting notifications.
 * @param listener The previously added {@link OnRoutingChangedListener} interface to remove.
 * @deprecated users should switch to the general purpose
 *             {@link AudioRouting.OnRoutingChangedListener} class instead.
 */

@Deprecated public void removeOnRoutingChangedListener(android.media.AudioRecord.OnRoutingChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the period at which the listener is called, if set with
 * {@link #setRecordPositionUpdateListener(OnRecordPositionUpdateListener)} or
 * {@link #setRecordPositionUpdateListener(OnRecordPositionUpdateListener, Handler)}.
 * It is possible for notifications to be lost if the period is too small.
 * @param periodInFrames update period expressed in frames
 * @return error code or success, see {@link #SUCCESS}, {@link #ERROR_INVALID_OPERATION}
 */

public int setPositionNotificationPeriod(int periodInFrames) { throw new RuntimeException("Stub!"); }

/**
 * Specifies an audio device (via an {@link AudioDeviceInfo} object) to route
 * the input to this AudioRecord.
 * @param deviceInfo The {@link AudioDeviceInfo} specifying the audio source.
 *  If deviceInfo is null, default routing is restored.
 * @return true if successful, false if the specified {@link AudioDeviceInfo} is non-null and
 * does not correspond to a valid audio input device.
 */

public boolean setPreferredDevice(android.media.AudioDeviceInfo deviceInfo) { throw new RuntimeException("Stub!"); }

/**
 * Returns the selected input specified by {@link #setPreferredDevice}. Note that this
 * is not guarenteed to correspond to the actual device being used for recording.
 */

public android.media.AudioDeviceInfo getPreferredDevice() { throw new RuntimeException("Stub!"); }

/**
 * Returns a lists of {@link MicrophoneInfo} representing the active microphones.
 * By querying channel mapping for each active microphone, developer can know how
 * the microphone is used by each channels or a capture stream.
 * Note that the information about the active microphones may change during a recording.
 * See {@link AudioManager#registerAudioDeviceCallback} to be notified of changes
 * in the audio devices, querying the active microphones then will return the latest
 * information.
 *
 * @return a lists of {@link MicrophoneInfo} representing the active microphones.
 * @throws IOException if an error occurs
 */

public java.util.List<android.media.MicrophoneInfo> getActiveMicrophones() throws java.io.IOException { throw new RuntimeException("Stub!"); }

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
 * The read mode indicating the read operation will block until all data
 * requested has been read.
 */

public static final int READ_BLOCKING = 0; // 0x0

/**
 * The read mode indicating the read operation will return immediately after
 * reading as much audio data as possible without blocking.
 */

public static final int READ_NON_BLOCKING = 1; // 0x1

/**
 * indicates AudioRecord recording state is recording
 */

public static final int RECORDSTATE_RECORDING = 3; // 0x3

/**
 * indicates AudioRecord recording state is not recording
 */

public static final int RECORDSTATE_STOPPED = 1; // 0x1

/**
 *  indicates AudioRecord state is ready to be used
 */

public static final int STATE_INITIALIZED = 1; // 0x1

/**
 *  indicates AudioRecord state is not successfully initialized.
 */

public static final int STATE_UNINITIALIZED = 0; // 0x0

/**
 * Denotes a successful operation.
 */

public static final int SUCCESS = 0; // 0x0
/**
 * Builder class for {@link AudioRecord} objects.
 * Use this class to configure and create an <code>AudioRecord</code> instance. By setting the
 * recording source and audio format parameters, you indicate which of
 * those vary from the default behavior on the device.
 * <p> Here is an example where <code>Builder</code> is used to specify all {@link AudioFormat}
 * parameters, to be used by a new <code>AudioRecord</code> instance:
 *
 * <pre class="prettyprint">
 * AudioRecord recorder = new AudioRecord.Builder()
 *         .setAudioSource(MediaRecorder.AudioSource.VOICE_COMMUNICATION)
 *         .setAudioFormat(new AudioFormat.Builder()
 *                 .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
 *                 .setSampleRate(32000)
 *                 .setChannelMask(AudioFormat.CHANNEL_IN_MONO)
 *                 .build())
 *         .setBufferSize(2*minBuffSize)
 *         .build();
 * </pre>
 * <p>
 * If the audio source is not set with {@link #setAudioSource(int)},
 * {@link MediaRecorder.AudioSource#DEFAULT} is used.
 * <br>If the audio format is not specified or is incomplete, its channel configuration will be
 * {@link AudioFormat#CHANNEL_IN_MONO}, and the encoding will be
 * {@link AudioFormat#ENCODING_PCM_16BIT}.
 * The sample rate will depend on the device actually selected for capture and can be queried
 * with {@link #getSampleRate()} method.
 * <br>If the buffer size is not specified with {@link #setBufferSizeInBytes(int)},
 * the minimum buffer size for the source is used.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Constructs a new Builder with the default values as described above.
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * @param source the audio source.
 * See {@link MediaRecorder.AudioSource} for the supported audio source definitions.
 * @return the same Builder instance.
 * @throws IllegalArgumentException
 */

public android.media.AudioRecord.Builder setAudioSource(int source) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the format of the audio data to be captured.
 * @param format a non-null {@link AudioFormat} instance
 * This value must never be {@code null}.
 * @return the same Builder instance.
 * @throws IllegalArgumentException
 */

public android.media.AudioRecord.Builder setAudioFormat(@androidx.annotation.RecentlyNonNull android.media.AudioFormat format) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Sets the total size (in bytes) of the buffer where audio data is written
 * during the recording. New audio data can be read from this buffer in smaller chunks
 * than this size. See {@link #getMinBufferSize(int, int, int)} to determine the minimum
 * required buffer size for the successful creation of an AudioRecord instance.
 * Since bufferSizeInBytes may be internally increased to accommodate the source
 * requirements, use {@link #getBufferSizeInFrames()} to determine the actual buffer size
 * in frames.
 * @param bufferSizeInBytes a value strictly greater than 0
 * @return the same Builder instance.
 * @throws IllegalArgumentException
 */

public android.media.AudioRecord.Builder setBufferSizeInBytes(int bufferSizeInBytes) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * @return a new {@link AudioRecord} instance successfully initialized with all
 *     the parameters set on this <code>Builder</code>.
 * @throws UnsupportedOperationException if the parameters set on the <code>Builder</code>
 *     were incompatible, or if they are not supported by the device,
 *     or if the device was not available.
 */

public android.media.AudioRecord build() throws java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }
}

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MetricsConstants {

MetricsConstants() { throw new RuntimeException("Stub!"); }

/**
 * Key to extract the number of channels being recorded in this record track
 * from the {@link AudioRecord#getMetrics} return value.
 * The value is an integer.
 */

public static final java.lang.String CHANNELS = "android.media.audiorecord.channels";

/**
 * Key to extract the output format being recorded
 * from the {@link AudioRecord#getMetrics} return value.
 * The value is a String.
 */

public static final java.lang.String ENCODING = "android.media.audiorecord.encoding";

/**
 * Key to extract the estimated latency through the recording pipeline
 * from the {@link AudioRecord#getMetrics} return value.
 * This is in units of milliseconds.
 * The value is an integer.
 */

public static final java.lang.String LATENCY = "android.media.audiorecord.latency";

/**
 * Key to extract the sink sample rate for this record track in Hz
 * from the {@link AudioRecord#getMetrics} return value.
 * The value is an integer.
 */

public static final java.lang.String SAMPLERATE = "android.media.audiorecord.samplerate";

/**
 * Key to extract the Source Type for this track
 * from the {@link AudioRecord#getMetrics} return value.
 * The value is a String.
 */

public static final java.lang.String SOURCE = "android.media.audiorecord.source";
}

/**
 * Interface definition for a callback to be invoked when an AudioRecord has
 * reached a notification marker set by {@link AudioRecord#setNotificationMarkerPosition(int)}
 * or for periodic updates on the progress of the record head, as set by
 * {@link AudioRecord#setPositionNotificationPeriod(int)}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnRecordPositionUpdateListener {

/**
 * Called on the listener to notify it that the previously set marker has been reached
 * by the recording head.
 */

public void onMarkerReached(android.media.AudioRecord recorder);

/**
 * Called on the listener to periodically notify it that the record head has reached
 * a multiple of the notification period.
 */

public void onPeriodicNotification(android.media.AudioRecord recorder);
}

/**
 * Defines the interface by which applications can receive notifications of
 * routing changes for the associated {@link AudioRecord}.
 *
 * @deprecated users should switch to the general purpose
 *             {@link AudioRouting.OnRoutingChangedListener} class instead.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public static interface OnRoutingChangedListener extends android.media.AudioRouting.OnRoutingChangedListener {

/**
 * Called when the routing of an AudioRecord changes from either and
 * explicit or policy rerouting. Use {@link #getRoutedDevice()} to
 * retrieve the newly routed-from device.
 */

public void onRoutingChanged(android.media.AudioRecord audioRecord);

public default void onRoutingChanged(android.media.AudioRouting router) { throw new RuntimeException("Stub!"); }
}

}

