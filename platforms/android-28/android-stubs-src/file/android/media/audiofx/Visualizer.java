/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.os.Handler;

/**
 * The Visualizer class enables application to retrieve part of the currently playing audio for
 * visualization purpose. It is not an audio recording interface and only returns partial and low
 * quality audio content. However, to protect privacy of certain audio data (e.g voice mail) the use
 * of the visualizer requires the permission android.permission.RECORD_AUDIO.
 * <p>The audio session ID passed to the constructor indicates which audio content should be
 * visualized:<br>
 * <ul>
 *   <li>If the session is 0, the audio output mix is visualized</li>
 *   <li>If the session is not 0, the audio from a particular {@link android.media.MediaPlayer} or
 *   {@link android.media.AudioTrack}
 *   using this audio session is visualized </li>
 * </ul>
 * <p>Two types of representation of audio content can be captured: <br>
 * <ul>
 *   <li>Waveform data: consecutive 8-bit (unsigned) mono samples by using the
 *   {@link #getWaveForm(byte[])} method</li>
 *   <li>Frequency data: 8-bit magnitude FFT by using the {@link #getFft(byte[])} method</li>
 * </ul>
 * <p>The length of the capture can be retrieved or specified by calling respectively
 * {@link #getCaptureSize()} and {@link #setCaptureSize(int)} methods. The capture size must be a
 * power of 2 in the range returned by {@link #getCaptureSizeRange()}.
 * <p>In addition to the polling capture mode described above with {@link #getWaveForm(byte[])} and
 *  {@link #getFft(byte[])} methods, a callback mode is also available by installing a listener by
 *  use of the {@link #setDataCaptureListener(OnDataCaptureListener, int, boolean, boolean)} method.
 *  The rate at which the listener capture method is called as well as the type of data returned is
 *  specified.
 * <p>Before capturing data, the Visualizer must be enabled by calling the
 * {@link #setEnabled(boolean)} method.
 * When data capture is not needed any more, the Visualizer should be disabled.
 * <p>It is good practice to call the {@link #release()} method when the Visualizer is not used
 * anymore to free up native resources associated to the Visualizer instance.
 * <p>Creating a Visualizer on the output mix (audio session 0) requires permission
 * {@link android.Manifest.permission#MODIFY_AUDIO_SETTINGS}
 * <p>The Visualizer class can also be used to perform measurements on the audio being played back.
 * The measurements to perform are defined by setting a mask of the requested measurement modes with
 * {@link #setMeasurementMode(int)}. Supported values are {@link #MEASUREMENT_MODE_NONE} to cancel
 * any measurement, and {@link #MEASUREMENT_MODE_PEAK_RMS} for peak and RMS monitoring.
 * Measurements can be retrieved through {@link #getMeasurementPeakRms(MeasurementPeakRms)}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Visualizer {

/**
 * Class constructor.
 * @param audioSession system wide unique audio session identifier. If audioSession
 *  is not 0, the visualizer will be attached to the MediaPlayer or AudioTrack in the
 *  same audio session. Otherwise, the Visualizer will apply to the output mix.
 *
 * @throws java.lang.UnsupportedOperationException
 * @throws java.lang.RuntimeException
 */

public Visualizer(int audioSession) throws java.lang.RuntimeException, java.lang.UnsupportedOperationException { throw new RuntimeException("Stub!"); }

/**
 * Releases the native Visualizer resources. It is a good practice to release the
 * visualization engine when not in use.
 */

public void release() { throw new RuntimeException("Stub!"); }

protected void finalize() { throw new RuntimeException("Stub!"); }

/**
 * Enable or disable the visualization engine.
 * @param enabled requested enable state
 * @return {@link #SUCCESS} in case of success,
 * {@link #ERROR_INVALID_OPERATION} or {@link #ERROR_DEAD_OBJECT} in case of failure.
 * @throws IllegalStateException
 */

public int setEnabled(boolean enabled) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Get current activation state of the visualizer.
 * @return true if the visualizer is active, false otherwise
 */

public boolean getEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns the capture size range.
 * @return the mininum capture size is returned in first array element and the maximum in second
 * array element.
 */

public static native int[] getCaptureSizeRange();

/**
 * Returns the maximum capture rate for the callback capture method. This is the maximum value
 * for the rate parameter of the
 * {@link #setDataCaptureListener(OnDataCaptureListener, int, boolean, boolean)} method.
 * @return the maximum capture rate expressed in milliHertz
 */

public static native int getMaxCaptureRate();

/**
 * Sets the capture size, i.e. the number of bytes returned by {@link #getWaveForm(byte[])} and
 * {@link #getFft(byte[])} methods. The capture size must be a power of 2 in the range returned
 * by {@link #getCaptureSizeRange()}.
 * This method must not be called when the Visualizer is enabled.
 * @param size requested capture size
 * @return {@link #SUCCESS} in case of success,
 * {@link #ERROR_BAD_VALUE} in case of failure.
 * @throws IllegalStateException
 */

public int setCaptureSize(int size) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Returns current capture size.
 * @return the capture size in bytes.
 */

public int getCaptureSize() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Set the type of scaling applied on the captured visualization data.
 * @param mode see {@link #SCALING_MODE_NORMALIZED}
 *     and {@link #SCALING_MODE_AS_PLAYED}
 * @return {@link #SUCCESS} in case of success,
 *     {@link #ERROR_BAD_VALUE} in case of failure.
 * @throws IllegalStateException
 */

public int setScalingMode(int mode) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Returns the current scaling mode on the captured visualization data.
 * @return the scaling mode, see {@link #SCALING_MODE_NORMALIZED}
 *     and {@link #SCALING_MODE_AS_PLAYED}.
 * @throws IllegalStateException
 */

public int getScalingMode() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Sets the combination of measurement modes to be performed by this audio effect.
 * @param mode a mask of the measurements to perform. The valid values are
 *     {@link #MEASUREMENT_MODE_NONE} (to cancel any measurement)
 *     or {@link #MEASUREMENT_MODE_PEAK_RMS}.
 * @return {@link #SUCCESS} in case of success, {@link #ERROR_BAD_VALUE} in case of failure.
 * @throws IllegalStateException
 */

public int setMeasurementMode(int mode) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Returns the current measurement modes performed by this audio effect
 * @return the mask of the measurements,
 *     {@link #MEASUREMENT_MODE_NONE} (when no measurements are performed)
 *     or {@link #MEASUREMENT_MODE_PEAK_RMS}.
 * @throws IllegalStateException
 */

public int getMeasurementMode() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Returns the sampling rate of the captured audio.
 * @return the sampling rate in milliHertz.
 */

public int getSamplingRate() throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Returns a waveform capture of currently playing audio content. The capture consists in
 * a number of consecutive 8-bit (unsigned) mono PCM samples equal to the capture size returned
 * by {@link #getCaptureSize()}.
 * <p>This method must be called when the Visualizer is enabled.
 * @param waveform array of bytes where the waveform should be returned
 * @return {@link #SUCCESS} in case of success,
 * {@link #ERROR_NO_MEMORY}, {@link #ERROR_INVALID_OPERATION} or {@link #ERROR_DEAD_OBJECT}
 * in case of failure.
 * @throws IllegalStateException
 */

public int getWaveForm(byte[] waveform) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Returns a frequency capture of currently playing audio content.
 * <p>This method must be called when the Visualizer is enabled.
 * <p>The capture is an 8-bit magnitude FFT, the frequency range covered being 0 (DC) to half of
 * the sampling rate returned by {@link #getSamplingRate()}. The capture returns the real and
 * imaginary parts of a number of frequency points equal to half of the capture size plus one.
 * <p>Note: only the real part is returned for the first point (DC) and the last point
 * (sampling frequency / 2).
 * <p>The layout in the returned byte array is as follows:
 * <ul>
 *   <li> n is the capture size returned by getCaptureSize()</li>
 *   <li> Rfk, Ifk are respectively  the real and imaginary parts of the kth frequency
 *   component</li>
 *   <li> If Fs is the sampling frequency retuned by getSamplingRate() the kth frequency is:
 *   (k*Fs)/(n/2) </li>
 * </ul>
 * <table border="0" cellspacing="0" cellpadding="0">
 * <tr><td>Index </p></td>
 *     <td>0 </p></td>
 *     <td>1 </p></td>
 *     <td>2 </p></td>
 *     <td>3 </p></td>
 *     <td>4 </p></td>
 *     <td>5 </p></td>
 *     <td>... </p></td>
 *     <td>n - 2 </p></td>
 *     <td>n - 1 </p></td></tr>
 * <tr><td>Data </p></td>
 *     <td>Rf0 </p></td>
 *     <td>Rf(n/2) </p></td>
 *     <td>Rf1 </p></td>
 *     <td>If1 </p></td>
 *     <td>Rf2 </p></td>
 *     <td>If2 </p></td>
 *     <td>... </p></td>
 *     <td>Rf(n-1)/2 </p></td>
 *     <td>If(n-1)/2 </p></td></tr>
 * </table>
 * @param fft array of bytes where the FFT should be returned
 * @return {@link #SUCCESS} in case of success,
 * {@link #ERROR_NO_MEMORY}, {@link #ERROR_INVALID_OPERATION} or {@link #ERROR_DEAD_OBJECT}
 * in case of failure.
 * @throws IllegalStateException
 */

public int getFft(byte[] fft) throws java.lang.IllegalStateException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the latest peak and RMS measurement.
 * Sets the peak and RMS fields of the supplied {@link Visualizer.MeasurementPeakRms} to the
 * latest measured values.
 * @param measurement a non-null {@link Visualizer.MeasurementPeakRms} instance to store
 *    the measurement values.
 * @return {@link #SUCCESS} in case of success, {@link #ERROR_BAD_VALUE},
 *    {@link #ERROR_NO_MEMORY}, {@link #ERROR_INVALID_OPERATION} or {@link #ERROR_DEAD_OBJECT}
 *    in case of failure.
 */

public int getMeasurementPeakRms(android.media.audiofx.Visualizer.MeasurementPeakRms measurement) { throw new RuntimeException("Stub!"); }

/**
 * Registers an OnDataCaptureListener interface and specifies the rate at which the capture
 * should be updated as well as the type of capture requested.
 * <p>Call this method with a null listener to stop receiving the capture updates.
 * @param listener OnDataCaptureListener registered
 * @param rate rate in milliHertz at which the capture should be updated
 * @param waveform true if a waveform capture is requested: the onWaveFormDataCapture()
 * method will be called on the OnDataCaptureListener interface.
 * @param fft true if a frequency capture is requested: the onFftDataCapture() method will be
 * called on the OnDataCaptureListener interface.
 * @return {@link #SUCCESS} in case of success,
 * {@link #ERROR_NO_INIT} or {@link #ERROR_BAD_VALUE} in case of failure.
 */

public int setDataCaptureListener(android.media.audiofx.Visualizer.OnDataCaptureListener listener, int rate, boolean waveform, boolean fft) { throw new RuntimeException("Stub!"); }

/**
 * Internal operation status. Not returned by any method.
 */

public static final int ALREADY_EXISTS = -2; // 0xfffffffe

/**
 * Unspecified error.
 */

public static final int ERROR = -1; // 0xffffffff

/**
 * Operation failed due to bad parameter value.
 */

public static final int ERROR_BAD_VALUE = -4; // 0xfffffffc

/**
 * Operation failed due to dead remote object.
 */

public static final int ERROR_DEAD_OBJECT = -7; // 0xfffffff9

/**
 * Operation failed because it was requested in wrong state.
 */

public static final int ERROR_INVALID_OPERATION = -5; // 0xfffffffb

/**
 * Operation failed due to bad object initialization.
 */

public static final int ERROR_NO_INIT = -3; // 0xfffffffd

/**
 * Operation failed due to lack of memory.
 */

public static final int ERROR_NO_MEMORY = -6; // 0xfffffffa

/**
 * Defines a measurement mode in which no measurements are performed.
 */

public static final int MEASUREMENT_MODE_NONE = 0; // 0x0

/**
 * Defines a measurement mode which computes the peak and RMS value in mB, where 0mB is the
 * maximum sample value, and -9600mB is the minimum value.
 * Values for peak and RMS can be retrieved with
 * {@link #getMeasurementPeakRms(MeasurementPeakRms)}.
 */

public static final int MEASUREMENT_MODE_PEAK_RMS = 1; // 0x1

/**
 * Defines a capture mode where the playback volume will affect (scale) the range of the
 * captured data. A low playback volume will lead to low sample and fft values, and vice-versa.
 */

public static final int SCALING_MODE_AS_PLAYED = 1; // 0x1

/**
 * Defines a capture mode where amplification is applied based on the content of the captured
 * data. This is the default Visualizer mode, and is suitable for music visualization.
 */

public static final int SCALING_MODE_NORMALIZED = 0; // 0x0

/**
 * State of a Visualizer object that is active.
 */

public static final int STATE_ENABLED = 2; // 0x2

/**
 * State of a Visualizer object that is ready to be used.
 */

public static final int STATE_INITIALIZED = 1; // 0x1

/**
 * State of a Visualizer object that was not successfully initialized upon creation
 */

public static final int STATE_UNINITIALIZED = 0; // 0x0

/**
 * Successful operation.
 */

public static final int SUCCESS = 0; // 0x0
/**
 * A class to store peak and RMS values.
 * Peak and RMS are expressed in mB, as described in the
 * {@link Visualizer#MEASUREMENT_MODE_PEAK_RMS} measurement mode.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MeasurementPeakRms {

public MeasurementPeakRms() { throw new RuntimeException("Stub!"); }

/**
 * The peak value in mB.
 */

public int mPeak;

/**
 * The RMS value in mB.
 */

public int mRms;
}

/**
 * The OnDataCaptureListener interface defines methods called by the Visualizer to periodically
 * update the audio visualization capture.
 * The client application can implement this interface and register the listener with the
 * {@link #setDataCaptureListener(OnDataCaptureListener, int, boolean, boolean)} method.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDataCaptureListener {

/**
 * Method called when a new waveform capture is available.
 * <p>Data in the waveform buffer is valid only within the scope of the callback.
 * Applications which need access to the waveform data after returning from the callback
 * should make a copy of the data instead of holding a reference.
 * @param visualizer Visualizer object on which the listener is registered.
 * @param waveform array of bytes containing the waveform representation.
 * @param samplingRate sampling rate of the visualized audio.
 */

public void onWaveFormDataCapture(android.media.audiofx.Visualizer visualizer, byte[] waveform, int samplingRate);

/**
 * Method called when a new frequency capture is available.
 * <p>Data in the fft buffer is valid only within the scope of the callback.
 * Applications which need access to the fft data after returning from the callback
 * should make a copy of the data instead of holding a reference.
 *
 * <p>In order to obtain magnitude and phase values the following formulas can
 * be used:
 *    <pre class="prettyprint">
 *       for (int i = 0; i &lt; fft.size(); i += 2) {
 *           float magnitude = (float)Math.hypot(fft[i], fft[i + 1]);
 *           float phase = (float)Math.atan2(fft[i + 1], fft[i]);
 *       }</pre>
 * @param visualizer Visualizer object on which the listener is registered.
 * @param fft array of bytes containing the frequency representation.
 *    The fft array only contains the first half of the actual
 *    FFT spectrum (frequencies up to Nyquist frequency), exploiting
 *    the symmetry of the spectrum. For each frequencies bin <code>i</code>:
 *    <ul>
 *      <li>the element at index <code>2*i</code> in the array contains
 *          the real part of a complex number,</li>
 *      <li>the element at index <code>2*i+1</code> contains the imaginary
 *          part of the complex number.</li>
 *    </ul>
 * @param samplingRate sampling rate of the visualized audio.
 */

public void onFftDataCapture(android.media.audiofx.Visualizer visualizer, byte[] fft, int samplingRate);
}

}

