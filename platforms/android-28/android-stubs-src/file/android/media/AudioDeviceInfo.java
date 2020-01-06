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


/**
 * Class to provide information about the audio devices.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AudioDeviceInfo {

AudioDeviceInfo() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * @return The internal device ID.
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * @return The human-readable name of the audio device.
 */

public java.lang.CharSequence getProductName() { throw new RuntimeException("Stub!"); }

/**
 * @return The "address" string of the device. This generally contains device-specific
 * parameters.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getAddress() { throw new RuntimeException("Stub!"); }

/**
 * @return true if the audio device is a source for audio data (e.e an input).
 */

public boolean isSource() { throw new RuntimeException("Stub!"); }

/**
 * @return true if the audio device is a sink for audio data (i.e. an output).
 */

public boolean isSink() { throw new RuntimeException("Stub!"); }

/**
 * @return An array of sample rates supported by the audio device.
 *
 * Note: an empty array indicates that the device supports arbitrary rates.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public int[] getSampleRates() { throw new RuntimeException("Stub!"); }

/**
 * @return An array of channel position masks (e.g.&nbsp;{@link AudioFormat#CHANNEL_IN_STEREO},
 * {@link AudioFormat#CHANNEL_OUT_7POINT1}) for which this audio device can be configured.
 *
 * This value will never be {@code null}.
 * @see AudioFormat
 *
 * Note: an empty array indicates that the device supports arbitrary channel masks.
 */

@androidx.annotation.RecentlyNonNull public int[] getChannelMasks() { throw new RuntimeException("Stub!"); }

/**
 * @return An array of channel index masks for which this audio device can be configured.
 *
 * This value will never be {@code null}.
 * @see AudioFormat
 *
 * Note: an empty array indicates that the device supports arbitrary channel index masks.
 */

@androidx.annotation.RecentlyNonNull public int[] getChannelIndexMasks() { throw new RuntimeException("Stub!"); }

/**
 * @return An array of channel counts (1, 2, 4, ...) for which this audio device
 * can be configured.
 *
 * Note: an empty array indicates that the device supports arbitrary channel counts.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public int[] getChannelCounts() { throw new RuntimeException("Stub!"); }

/**
 * @return An array of audio encodings (e.g.&nbsp;{@link AudioFormat#ENCODING_PCM_16BIT},
 * {@link AudioFormat#ENCODING_PCM_FLOAT}) supported by the audio device.
 * <code>ENCODING_PCM_FLOAT</code> indicates the device supports more
 * than 16 bits of integer precision.  As there is no AudioFormat constant
 * specifically defined for 24-bit PCM, the value <code>ENCODING_PCM_FLOAT</code>
 * indicates that {@link AudioTrack} or {@link AudioRecord} can preserve at least 24 bits of
 * integer precision to that device.
 *
 * This value will never be {@code null}.
 * @see AudioFormat
 *
 * Note: an empty array indicates that the device supports arbitrary encodings.
 */

@androidx.annotation.RecentlyNonNull public int[] getEncodings() { throw new RuntimeException("Stub!"); }

/**
 * @return The device type identifier of the audio device (i.e. TYPE_BUILTIN_SPEAKER).
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * A device type describing the auxiliary line-level connectors.
 */

public static final int TYPE_AUX_LINE = 19; // 0x13

/**
 * A device type describing a Bluetooth device supporting the A2DP profile.
 */

public static final int TYPE_BLUETOOTH_A2DP = 8; // 0x8

/**
 * A device type describing a Bluetooth device typically used for telephony.
 */

public static final int TYPE_BLUETOOTH_SCO = 7; // 0x7

/**
 * A device type describing the attached earphone speaker.
 */

public static final int TYPE_BUILTIN_EARPIECE = 1; // 0x1

/**
 * A device type describing the microphone(s) built in a device.
 */

public static final int TYPE_BUILTIN_MIC = 15; // 0xf

/**
 * A device type describing the speaker system (i.e. a mono speaker or stereo speakers) built
 * in a device.
 */

public static final int TYPE_BUILTIN_SPEAKER = 2; // 0x2

/**
 * A type-agnostic device used for communication with external audio systems
 */

public static final int TYPE_BUS = 21; // 0x15

/**
 * A device type describing the audio device associated with a dock.
 */

public static final int TYPE_DOCK = 13; // 0xd

/**
 * A device type associated with the transmission of audio signals over FM.
 */

public static final int TYPE_FM = 14; // 0xe

/**
 * A device type for accessing the audio content transmitted over FM.
 */

public static final int TYPE_FM_TUNER = 16; // 0x10

/**
 * A device type describing an HDMI connection .
 */

public static final int TYPE_HDMI = 9; // 0x9

/**
 * A device type describing the Audio Return Channel of an HDMI connection.
 */

public static final int TYPE_HDMI_ARC = 10; // 0xa

/**
 * A device type describing a Hearing Aid.
 */

public static final int TYPE_HEARING_AID = 23; // 0x17

/**
 * A device type connected over IP.
 */

public static final int TYPE_IP = 20; // 0x14

/**
 * A device type describing an analog line-level connection.
 */

public static final int TYPE_LINE_ANALOG = 5; // 0x5

/**
 * A device type describing a digital line connection (e.g.&nbsp;SPDIF).
 */

public static final int TYPE_LINE_DIGITAL = 6; // 0x6

/**
 * A device type describing the transmission of audio signals over the telephony network.
 */

public static final int TYPE_TELEPHONY = 18; // 0x12

/**
 * A device type for accessing the audio content transmitted over the TV tuner system.
 */

public static final int TYPE_TV_TUNER = 17; // 0x11

/**
 * A device type associated with an unknown or uninitialized device.
 */

public static final int TYPE_UNKNOWN = 0; // 0x0

/**
 * A device type describing a USB audio device in accessory mode.
 */

public static final int TYPE_USB_ACCESSORY = 12; // 0xc

/**
 * A device type describing a USB audio device.
 */

public static final int TYPE_USB_DEVICE = 11; // 0xb

/**
 * A device type describing a USB audio headset.
 */

public static final int TYPE_USB_HEADSET = 22; // 0x16

/**
 * A device type describing a pair of wired headphones.
 */

public static final int TYPE_WIRED_HEADPHONES = 4; // 0x4

/**
 * A device type describing a headset, which is the combination of a headphones and microphone.
 */

public static final int TYPE_WIRED_HEADSET = 3; // 0x3
}

