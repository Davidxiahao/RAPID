/*
 * Copyright (C) 2012 The Android Open Source Project
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

import android.util.Range;

/**
 * Provides information about a given media codec available on the device. You can
 * iterate through all codecs available by querying {@link MediaCodecList}. For example,
 * here's how to find an encoder that supports a given MIME type:
 * <pre>
 * private static MediaCodecInfo selectCodec(String mimeType) {
 *     int numCodecs = MediaCodecList.getCodecCount();
 *     for (int i = 0; i &lt; numCodecs; i++) {
 *         MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i);
 *
 *         if (!codecInfo.isEncoder()) {
 *             continue;
 *         }
 *
 *         String[] types = codecInfo.getSupportedTypes();
 *         for (int j = 0; j &lt; types.length; j++) {
 *             if (types[j].equalsIgnoreCase(mimeType)) {
 *                 return codecInfo;
 *             }
 *         }
 *     }
 *     return null;
 * }</pre>
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaCodecInfo {

MediaCodecInfo(java.lang.String name, boolean isEncoder, android.media.MediaCodecInfo.CodecCapabilities[] caps) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the codec name.
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Query if the codec is an encoder.
 */

public boolean isEncoder() { throw new RuntimeException("Stub!"); }

/**
 * Query the media types supported by the codec.
 */

public java.lang.String[] getSupportedTypes() { throw new RuntimeException("Stub!"); }

/**
 * Enumerates the capabilities of the codec component. Since a single
 * component can support data of a variety of types, the type has to be
 * specified to yield a meaningful result.
 * @param type The MIME type to query
 */

public android.media.MediaCodecInfo.CodecCapabilities getCapabilitiesForType(java.lang.String type) { throw new RuntimeException("Stub!"); }
/**
 * A class that supports querying the audio capabilities of a codec.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class AudioCapabilities {

AudioCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported bitrates in bits/second.
 */

public android.util.Range<java.lang.Integer> getBitrateRange() { throw new RuntimeException("Stub!"); }

/**
 * Returns the array of supported sample rates if the codec
 * supports only discrete values.  Otherwise, it returns
 * {@code null}.  The array is sorted in ascending order.
 */

public int[] getSupportedSampleRates() { throw new RuntimeException("Stub!"); }

/**
 * Returns the array of supported sample rate ranges.  The
 * array is sorted in ascending order, and the ranges are
 * distinct.
 */

public android.util.Range<java.lang.Integer>[] getSupportedSampleRateRanges() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum number of input channels supported.  The codec
 * supports any number of channels between 1 and this maximum value.
 */

public int getMaxInputChannelCount() { throw new RuntimeException("Stub!"); }

/**
 * Query whether the sample rate is supported by the codec.
 */

public boolean isSampleRateSupported(int sampleRate) { throw new RuntimeException("Stub!"); }
}

/**
 * Encapsulates the capabilities of a given codec component.
 * For example, what profile/level combinations it supports and what colorspaces
 * it is capable of providing the decoded data in, as well as some
 * codec-type specific capability flags.
 * <p>You can get an instance for a given {@link MediaCodecInfo} object with
 * {@link MediaCodecInfo#getCapabilitiesForType getCapabilitiesForType()}, passing a MIME type.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CodecCapabilities {

public CodecCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Query codec feature capabilities.
 * <p>
 * These features are supported to be used by the codec.  These
 * include optional features that can be turned on, as well as
 * features that are always on.
 */

public boolean isFeatureSupported(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Query codec feature requirements.
 * <p>
 * These features are required to be used by the codec, and as such,
 * they are always turned on.
 */

public boolean isFeatureRequired(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Query whether codec supports a given {@link MediaFormat}.
 *
 * <p class=note>
 * <strong>Note:</strong> On {@link android.os.Build.VERSION_CODES#LOLLIPOP},
 * {@code format} must not contain a {@linkplain MediaFormat#KEY_FRAME_RATE
 * frame rate}. Use
 * <code class=prettyprint>format.setString(MediaFormat.KEY_FRAME_RATE, null)</code>
 * to clear any existing frame rate setting in the format.
 * <p>
 *
 * The following table summarizes the format keys considered by this method.
 *
 * <table style="width: 0%">
 *  <thead>
 *   <tr>
 *    <th rowspan=3>OS Version(s)</th>
 *    <td colspan=3>{@code MediaFormat} keys considered for</th>
 *   </tr><tr>
 *    <th>Audio Codecs</th>
 *    <th>Video Codecs</th>
 *    <th>Encoders</th>
 *   </tr>
 *  </thead>
 *  <tbody>
 *   <tr>
 *    <td>{@link android.os.Build.VERSION_CODES#LOLLIPOP}</th>
 *    <td rowspan=3>{@link MediaFormat#KEY_MIME}<sup>*</sup>,<br>
 *        {@link MediaFormat#KEY_SAMPLE_RATE},<br>
 *        {@link MediaFormat#KEY_CHANNEL_COUNT},</td>
 *    <td>{@link MediaFormat#KEY_MIME}<sup>*</sup>,<br>
 *        {@link CodecCapabilities#FEATURE_AdaptivePlayback}<sup>D</sup>,<br>
 *        {@link CodecCapabilities#FEATURE_SecurePlayback}<sup>D</sup>,<br>
 *        {@link CodecCapabilities#FEATURE_TunneledPlayback}<sup>D</sup>,<br>
 *        {@link MediaFormat#KEY_WIDTH},<br>
 *        {@link MediaFormat#KEY_HEIGHT},<br>
 *        <strong>no</strong> {@code KEY_FRAME_RATE}</td>
 *    <td rowspan=4>{@link MediaFormat#KEY_BITRATE_MODE},<br>
 *        {@link MediaFormat#KEY_PROFILE}
 *        (and/or {@link MediaFormat#KEY_AAC_PROFILE}<sup>~</sup>),<br>
 *        <!-- {link MediaFormat#KEY_QUALITY},<br> -->
 *        {@link MediaFormat#KEY_COMPLEXITY}
 *        (and/or {@link MediaFormat#KEY_FLAC_COMPRESSION_LEVEL}<sup>~</sup>)</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1}</th>
 *    <td rowspan=2>as above, plus<br>
 *        {@link MediaFormat#KEY_FRAME_RATE}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#M}</th>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#N}</th>
 *    <td>as above, plus<br>
 *        {@link MediaFormat#KEY_PROFILE},<br>
 *        <!-- {link MediaFormat#KEY_MAX_BIT_RATE},<br> -->
 *        {@link MediaFormat#KEY_BIT_RATE}</td>
 *    <td>as above, plus<br>
 *        {@link MediaFormat#KEY_PROFILE},<br>
 *        {@link MediaFormat#KEY_LEVEL}<sup>+</sup>,<br>
 *        <!-- {link MediaFormat#KEY_MAX_BIT_RATE},<br> -->
 *        {@link MediaFormat#KEY_BIT_RATE},<br>
 *        {@link CodecCapabilities#FEATURE_IntraRefresh}<sup>E</sup></td>
 *   </tr>
 *   <tr>
 *    <td colspan=4>
 *     <p class=note><strong>Notes:</strong><br>
 *      *: must be specified; otherwise, method returns {@code false}.<br>
 *      +: method does not verify that the format parameters are supported
 *      by the specified level.<br>
 *      D: decoders only<br>
 *      E: encoders only<br>
 *      ~: if both keys are provided values must match
 *    </td>
 *   </tr>
 *  </tbody>
 * </table>
 *
 * @param format media format with optional feature directives.
 * @throws IllegalArgumentException if format is not a valid media format.
 * @return whether the codec capabilities support the given format
 *         and feature requests.
 */

public boolean isFormatSupported(android.media.MediaFormat format) { throw new RuntimeException("Stub!"); }

/**
 * Returns a MediaFormat object with default values for configurations that have
 * defaults.
 */

public android.media.MediaFormat getDefaultFormat() { throw new RuntimeException("Stub!"); }

/**
 * Returns the mime type for which this codec-capability object was created.
 */

public java.lang.String getMimeType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the max number of the supported concurrent codec instances.
 * <p>
 * This is a hint for an upper bound. Applications should not expect to successfully
 * operate more instances than the returned value, but the actual number of
 * concurrently operable instances may be less as it depends on the available
 * resources at time of use.
 */

public int getMaxSupportedInstances() { throw new RuntimeException("Stub!"); }

/**
 * Returns the audio capabilities or {@code null} if this is not an audio codec.
 */

public android.media.MediaCodecInfo.AudioCapabilities getAudioCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the encoding capabilities or {@code null} if this is not an encoder.
 */

public android.media.MediaCodecInfo.EncoderCapabilities getEncoderCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the video capabilities or {@code null} if this is not a video codec.
 */

public android.media.MediaCodecInfo.VideoCapabilities getVideoCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the codec capabilities for a certain {@code mime type}, {@code
 * profile} and {@code level}.  If the type, or profile-level combination
 * is not understood by the framework, it returns null.
 * <p class=note> In {@link android.os.Build.VERSION_CODES#M}, calling this
 * method without calling any method of the {@link MediaCodecList} class beforehand
 * results in a {@link NullPointerException}.</p>
 */

public static android.media.MediaCodecInfo.CodecCapabilities createFromProfileLevel(java.lang.String mime, int profile, int level) { throw new RuntimeException("Stub!"); }

/** @deprecated Use {@link #COLOR_Format24bitBGR888}. */

@Deprecated public static final int COLOR_Format12bitRGB444 = 3; // 0x3

/** @deprecated Use {@link #COLOR_Format32bitABGR8888}. */

@Deprecated public static final int COLOR_Format16bitARGB1555 = 5; // 0x5

/** @deprecated Use {@link #COLOR_Format32bitABGR8888}. */

@Deprecated public static final int COLOR_Format16bitARGB4444 = 4; // 0x4

/** @deprecated Use {@link #COLOR_Format16bitRGB565}. */

@Deprecated public static final int COLOR_Format16bitBGR565 = 7; // 0x7

/**
 * 16 bits per pixel RGB color format, with 5-bit red & blue and 6-bit green component.
 * <p>
 * Using 16-bit little-endian representation, colors stored as Red 15:11, Green 10:5, Blue 4:0.
 * <pre>
 *            byte                   byte
 *  <--------- i --------> | <------ i + 1 ------>
 * +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
 * |     BLUE     |      GREEN      |     RED      |
 * +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
 *  0           4  5     7   0     2  3           7
 * bit
 * </pre>
 *
 * This format corresponds to {@link android.graphics.PixelFormat#RGB_565} and
 * {@link android.graphics.ImageFormat#RGB_565}.
 */

public static final int COLOR_Format16bitRGB565 = 6; // 0x6

/** @deprecated Use {@link #COLOR_Format24bitBGR888}. */

@Deprecated public static final int COLOR_Format18BitBGR666 = 41; // 0x29

/** @deprecated Use {@link #COLOR_Format32bitABGR8888}. */

@Deprecated public static final int COLOR_Format18bitARGB1665 = 9; // 0x9

/** @deprecated Use {@link #COLOR_Format24bitBGR888}. */

@Deprecated public static final int COLOR_Format18bitRGB666 = 8; // 0x8

/** @deprecated Use {@link #COLOR_Format32bitABGR8888}. */

@Deprecated public static final int COLOR_Format19bitARGB1666 = 10; // 0xa

/** @deprecated Use {@link #COLOR_Format32bitABGR8888}. */

@Deprecated public static final int COLOR_Format24BitABGR6666 = 43; // 0x2b

/** @deprecated Use {@link #COLOR_Format32bitABGR8888}. */

@Deprecated public static final int COLOR_Format24BitARGB6666 = 42; // 0x2a

/** @deprecated Use {@link #COLOR_Format32bitABGR8888}. */

@Deprecated public static final int COLOR_Format24bitARGB1887 = 13; // 0xd

/**
 * 24 bits per pixel RGB color format, with 8-bit red, green & blue components.
 * <p>
 * Using 24-bit little-endian representation, colors stored as Red 7:0, Green 15:8, Blue 23:16.
 * <pre>
 *         byte              byte             byte
 *  <------ i -----> | <---- i+1 ----> | <---- i+2 ----->
 * +-----------------+-----------------+-----------------+
 * |       RED       |      GREEN      |       BLUE      |
 * +-----------------+-----------------+-----------------+
 * </pre>
 *
 * This format corresponds to {@link android.graphics.PixelFormat#RGB_888}, and can also be
 * represented as a flexible format by {@link #COLOR_FormatRGBFlexible}.
 */

public static final int COLOR_Format24bitBGR888 = 12; // 0xc

/** @deprecated Use {@link #COLOR_Format24bitBGR888} or {@link #COLOR_FormatRGBFlexible}. */

@Deprecated public static final int COLOR_Format24bitRGB888 = 11; // 0xb

/** @deprecated Use {@link #COLOR_Format32bitABGR8888}. */

@Deprecated public static final int COLOR_Format25bitARGB1888 = 14; // 0xe

/**
 * 32 bits per pixel RGBA color format, with 8-bit red, green, blue, and alpha components.
 * <p>
 * Using 32-bit little-endian representation, colors stored as Red 7:0, Green 15:8,
 * Blue 23:16, and Alpha 31:24.
 * <pre>
 *         byte              byte             byte              byte
 *  <------ i -----> | <---- i+1 ----> | <---- i+2 ----> | <---- i+3 ----->
 * +-----------------+-----------------+-----------------+-----------------+
 * |       RED       |      GREEN      |       BLUE      |      ALPHA      |
 * +-----------------+-----------------+-----------------+-----------------+
 * </pre>
 *
 * This corresponds to {@link android.graphics.PixelFormat#RGBA_8888}.
 */

public static final int COLOR_Format32bitABGR8888 = 2130747392; // 0x7f00a000

/**
 * @deprecated Use {@link #COLOR_Format32bitABGR8888} Or {@link #COLOR_FormatRGBAFlexible}.
 */

@Deprecated public static final int COLOR_Format32bitARGB8888 = 16; // 0x10

/**
 * @deprecated Use {@link #COLOR_Format32bitABGR8888} Or {@link #COLOR_FormatRGBAFlexible}.
 */

@Deprecated public static final int COLOR_Format32bitBGRA8888 = 15; // 0xf

/** @deprecated Use {@link #COLOR_Format24bitBGR888}. */

@Deprecated public static final int COLOR_Format8bitRGB332 = 2; // 0x2

/** @deprecated Use {@link #COLOR_FormatYUV422Flexible}. */

@Deprecated public static final int COLOR_FormatCbYCrY = 27; // 0x1b

/** @deprecated Use {@link #COLOR_FormatYUV422Flexible}. */

@Deprecated public static final int COLOR_FormatCrYCbY = 28; // 0x1c

/**
 * 16 bits per pixel, little-endian Y color format.
 * <p>
 * <pre>
 *            byte                   byte
 *  <--------- i --------> | <------ i + 1 ------>
 * +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
 * |                       Y                       |
 * +--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+
 *  0                    7   0                    7
 * bit
 * </pre>
 */

public static final int COLOR_FormatL16 = 36; // 0x24

/** @deprecated Use {@link #COLOR_FormatL8}. */

@Deprecated public static final int COLOR_FormatL2 = 33; // 0x21

/** @deprecated Use {@link #COLOR_FormatL16}. */

@Deprecated public static final int COLOR_FormatL24 = 37; // 0x25

/**
 * 32 bits per pixel, little-endian Y color format.
 * <p>
 * <pre>
 *         byte              byte             byte              byte
 *  <------ i -----> | <---- i+1 ----> | <---- i+2 ----> | <---- i+3 ----->
 * +-----------------+-----------------+-----------------+-----------------+
 * |                                   Y                                   |
 * +-----------------+-----------------+-----------------+-----------------+
 *  0               7 0               7 0               7 0               7
 * bit
 * </pre>
 *
 * @deprecated Use {@link #COLOR_FormatL16}.
 */

@Deprecated public static final int COLOR_FormatL32 = 38; // 0x26

/** @deprecated Use {@link #COLOR_FormatL8}. */

@Deprecated public static final int COLOR_FormatL4 = 34; // 0x22

/**
 * 8 bits per pixel Y color format.
 * <p>
 * Each byte contains a single pixel.
 * This format corresponds to {@link android.graphics.PixelFormat#L_8}.
 */

public static final int COLOR_FormatL8 = 35; // 0x23

/** @deprecated Use {@link #COLOR_Format24bitBGR888}. */

@Deprecated public static final int COLOR_FormatMonochrome = 1; // 0x1

/**
 * Flexible 32 bits per pixel RGBA color format with 8-bit red, green, blue, and alpha
 * components.
 * <p>
 * Use this format with {@link Image}. This format corresponds to
 * {@link android.graphics.ImageFormat#FLEX_RGBA_8888}, and can represent
 * {@link #COLOR_Format32bitBGRA8888}, {@link #COLOR_Format32bitABGR8888} and
 * {@link #COLOR_Format32bitARGB8888} formats.
 *
 * @see Image#getFormat
 */

public static final int COLOR_FormatRGBAFlexible = 2134288520; // 0x7f36a888

/**
 * Flexible 24 bits per pixel RGB color format with 8-bit red, green and blue
 * components.
 * <p>
 * Use this format with {@link Image}. This format corresponds to
 * {@link android.graphics.ImageFormat#FLEX_RGB_888}, and can represent
 * {@link #COLOR_Format24bitBGR888} and {@link #COLOR_Format24bitRGB888} formats.
 * @see Image#getFormat.
 */

public static final int COLOR_FormatRGBFlexible = 2134292616; // 0x7f36b888

/**
 * SMIA 10-bit Bayer format.
 */

public static final int COLOR_FormatRawBayer10bit = 31; // 0x1f

/**
 * SMIA 8-bit Bayer format.
 * Each byte represents the top 8-bits of a 10-bit signal.
 */

public static final int COLOR_FormatRawBayer8bit = 30; // 0x1e

/**
 * SMIA 8-bit compressed Bayer format.
 * Each byte represents a sample from the 10-bit signal that is compressed into 8-bits
 * using DPCM/PCM compression, as defined by the SMIA Functional Specification.
 */

public static final int COLOR_FormatRawBayer8bitcompressed = 32; // 0x20

public static final int COLOR_FormatSurface = 2130708361; // 0x7f000789

/** @deprecated Use {@link #COLOR_FormatYUV422Flexible}. */

@Deprecated public static final int COLOR_FormatYCbYCr = 25; // 0x19

/** @deprecated Use {@link #COLOR_FormatYUV422Flexible}. */

@Deprecated public static final int COLOR_FormatYCrYCb = 26; // 0x1a

/** @deprecated Use {@link #COLOR_FormatYUV420Flexible}. */

@Deprecated public static final int COLOR_FormatYUV411PackedPlanar = 18; // 0x12

/** @deprecated Use {@link #COLOR_FormatYUV420Flexible}. */

@Deprecated public static final int COLOR_FormatYUV411Planar = 17; // 0x11

/**
 * Flexible 12 bits per pixel, subsampled YUV color format with 8-bit chroma and luma
 * components.
 * <p>
 * Chroma planes are subsampled by 2 both horizontally and vertically.
 * Use this format with {@link Image}.
 * This format corresponds to {@link android.graphics.ImageFormat#YUV_420_888},
 * and can represent the {@link #COLOR_FormatYUV411Planar},
 * {@link #COLOR_FormatYUV411PackedPlanar}, {@link #COLOR_FormatYUV420Planar},
 * {@link #COLOR_FormatYUV420PackedPlanar}, {@link #COLOR_FormatYUV420SemiPlanar}
 * and {@link #COLOR_FormatYUV420PackedSemiPlanar} formats.
 *
 * @see Image#getFormat
 */

public static final int COLOR_FormatYUV420Flexible = 2135033992; // 0x7f420888

/** @deprecated Use {@link #COLOR_FormatYUV420Flexible}. */

@Deprecated public static final int COLOR_FormatYUV420PackedPlanar = 20; // 0x14

/** @deprecated Use {@link #COLOR_FormatYUV420Flexible}. */

@Deprecated public static final int COLOR_FormatYUV420PackedSemiPlanar = 39; // 0x27

/** @deprecated Use {@link #COLOR_FormatYUV420Flexible}. */

@Deprecated public static final int COLOR_FormatYUV420Planar = 19; // 0x13

/** @deprecated Use {@link #COLOR_FormatYUV420Flexible}. */

@Deprecated public static final int COLOR_FormatYUV420SemiPlanar = 21; // 0x15

/**
 * Flexible 16 bits per pixel, subsampled YUV color format with 8-bit chroma and luma
 * components.
 * <p>
 * Chroma planes are horizontally subsampled by 2. Use this format with {@link Image}.
 * This format corresponds to {@link android.graphics.ImageFormat#YUV_422_888},
 * and can represent the {@link #COLOR_FormatYCbYCr}, {@link #COLOR_FormatYCrYCb},
 * {@link #COLOR_FormatCbYCrY}, {@link #COLOR_FormatCrYCbY},
 * {@link #COLOR_FormatYUV422Planar}, {@link #COLOR_FormatYUV422PackedPlanar},
 * {@link #COLOR_FormatYUV422SemiPlanar} and {@link #COLOR_FormatYUV422PackedSemiPlanar}
 * formats.
 *
 * @see Image#getFormat
 */

public static final int COLOR_FormatYUV422Flexible = 2135042184; // 0x7f422888

/** @deprecated Use {@link #COLOR_FormatYUV422Flexible}. */

@Deprecated public static final int COLOR_FormatYUV422PackedPlanar = 23; // 0x17

/** @deprecated Use {@link #COLOR_FormatYUV422Flexible}. */

@Deprecated public static final int COLOR_FormatYUV422PackedSemiPlanar = 40; // 0x28

/** @deprecated Use {@link #COLOR_FormatYUV422Flexible}. */

@Deprecated public static final int COLOR_FormatYUV422Planar = 22; // 0x16

/** @deprecated Use {@link #COLOR_FormatYUV422Flexible}. */

@Deprecated public static final int COLOR_FormatYUV422SemiPlanar = 24; // 0x18

/**
 * Flexible 24 bits per pixel YUV color format with 8-bit chroma and luma
 * components.
 * <p>
 * Chroma planes are not subsampled. Use this format with {@link Image}.
 * This format corresponds to {@link android.graphics.ImageFormat#YUV_444_888},
 * and can represent the {@link #COLOR_FormatYUV444Interleaved} format.
 * @see Image#getFormat
 */

public static final int COLOR_FormatYUV444Flexible = 2135181448; // 0x7f444888

/** @deprecated Use {@link #COLOR_FormatYUV444Flexible}. */

@Deprecated public static final int COLOR_FormatYUV444Interleaved = 29; // 0x1d

/** @deprecated Use {@link #COLOR_FormatYUV420Flexible}. */

@Deprecated public static final int COLOR_QCOM_FormatYUV420SemiPlanar = 2141391872; // 0x7fa30c00

/** @deprecated Use {@link #COLOR_FormatYUV420Flexible}. */

@Deprecated public static final int COLOR_TI_FormatYUV420PackedSemiPlanar = 2130706688; // 0x7f000100

/**
 * <b>video decoder only</b>: codec supports seamless resolution changes.
 */

public static final java.lang.String FEATURE_AdaptivePlayback = "adaptive-playback";

/**
 * <b>video encoder only</b>: codec supports intra refresh.
 */

public static final java.lang.String FEATURE_IntraRefresh = "intra-refresh";

/**
 * <b>video decoder only</b>: codec supports queuing partial frames.
 */

public static final java.lang.String FEATURE_PartialFrame = "partial-frame";

/**
 * <b>video decoder only</b>: codec supports secure decryption.
 */

public static final java.lang.String FEATURE_SecurePlayback = "secure-playback";

/**
 * <b>video or audio decoder only</b>: codec supports tunneled playback.
 */

public static final java.lang.String FEATURE_TunneledPlayback = "tunneled-playback";

/**
 * Defined in the OpenMAX IL specs, color format values are drawn from
 * OMX_COLOR_FORMATTYPE.
 */

public int[] colorFormats;

public android.media.MediaCodecInfo.CodecProfileLevel[] profileLevels;
}

/**
 * Encapsulates the profiles available for a codec component.
 * <p>You can get a set of {@link MediaCodecInfo.CodecProfileLevel} objects for a given
 * {@link MediaCodecInfo} object from the
 * {@link MediaCodecInfo.CodecCapabilities#profileLevels} field.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class CodecProfileLevel {

public CodecProfileLevel() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public static final int AACObjectELD = 39; // 0x27

public static final int AACObjectERLC = 17; // 0x11

public static final int AACObjectERScalable = 20; // 0x14

public static final int AACObjectHE = 5; // 0x5

public static final int AACObjectHE_PS = 29; // 0x1d

public static final int AACObjectLC = 2; // 0x2

public static final int AACObjectLD = 23; // 0x17

public static final int AACObjectLTP = 4; // 0x4

public static final int AACObjectMain = 1; // 0x1

public static final int AACObjectSSR = 3; // 0x3

public static final int AACObjectScalable = 6; // 0x6

/** xHE-AAC (includes USAC) */

public static final int AACObjectXHE = 42; // 0x2a

public static final int AVCLevel1 = 1; // 0x1

public static final int AVCLevel11 = 4; // 0x4

public static final int AVCLevel12 = 8; // 0x8

public static final int AVCLevel13 = 16; // 0x10

public static final int AVCLevel1b = 2; // 0x2

public static final int AVCLevel2 = 32; // 0x20

public static final int AVCLevel21 = 64; // 0x40

public static final int AVCLevel22 = 128; // 0x80

public static final int AVCLevel3 = 256; // 0x100

public static final int AVCLevel31 = 512; // 0x200

public static final int AVCLevel32 = 1024; // 0x400

public static final int AVCLevel4 = 2048; // 0x800

public static final int AVCLevel41 = 4096; // 0x1000

public static final int AVCLevel42 = 8192; // 0x2000

public static final int AVCLevel5 = 16384; // 0x4000

public static final int AVCLevel51 = 32768; // 0x8000

public static final int AVCLevel52 = 65536; // 0x10000

public static final int AVCProfileBaseline = 1; // 0x1

public static final int AVCProfileConstrainedBaseline = 65536; // 0x10000

public static final int AVCProfileConstrainedHigh = 524288; // 0x80000

public static final int AVCProfileExtended = 4; // 0x4

public static final int AVCProfileHigh = 8; // 0x8

public static final int AVCProfileHigh10 = 16; // 0x10

public static final int AVCProfileHigh422 = 32; // 0x20

public static final int AVCProfileHigh444 = 64; // 0x40

public static final int AVCProfileMain = 2; // 0x2

public static final int DolbyVisionLevelFhd24 = 4; // 0x4

public static final int DolbyVisionLevelFhd30 = 8; // 0x8

public static final int DolbyVisionLevelFhd60 = 16; // 0x10

public static final int DolbyVisionLevelHd24 = 1; // 0x1

public static final int DolbyVisionLevelHd30 = 2; // 0x2

public static final int DolbyVisionLevelUhd24 = 32; // 0x20

public static final int DolbyVisionLevelUhd30 = 64; // 0x40

public static final int DolbyVisionLevelUhd48 = 128; // 0x80

public static final int DolbyVisionLevelUhd60 = 256; // 0x100

public static final int DolbyVisionProfileDvavPen = 2; // 0x2

public static final int DolbyVisionProfileDvavPer = 1; // 0x1

public static final int DolbyVisionProfileDvavSe = 512; // 0x200

public static final int DolbyVisionProfileDvheDen = 8; // 0x8

public static final int DolbyVisionProfileDvheDer = 4; // 0x4

public static final int DolbyVisionProfileDvheDtb = 128; // 0x80

public static final int DolbyVisionProfileDvheDth = 64; // 0x40

public static final int DolbyVisionProfileDvheDtr = 16; // 0x10

public static final int DolbyVisionProfileDvheSt = 256; // 0x100

public static final int DolbyVisionProfileDvheStn = 32; // 0x20

public static final int H263Level10 = 1; // 0x1

public static final int H263Level20 = 2; // 0x2

public static final int H263Level30 = 4; // 0x4

public static final int H263Level40 = 8; // 0x8

public static final int H263Level45 = 16; // 0x10

public static final int H263Level50 = 32; // 0x20

public static final int H263Level60 = 64; // 0x40

public static final int H263Level70 = 128; // 0x80

public static final int H263ProfileBackwardCompatible = 4; // 0x4

public static final int H263ProfileBaseline = 1; // 0x1

public static final int H263ProfileH320Coding = 2; // 0x2

public static final int H263ProfileHighCompression = 32; // 0x20

public static final int H263ProfileHighLatency = 256; // 0x100

public static final int H263ProfileISWV2 = 8; // 0x8

public static final int H263ProfileISWV3 = 16; // 0x10

public static final int H263ProfileInterlace = 128; // 0x80

public static final int H263ProfileInternet = 64; // 0x40

public static final int HEVCHighTierLevel1 = 2; // 0x2

public static final int HEVCHighTierLevel2 = 8; // 0x8

public static final int HEVCHighTierLevel21 = 32; // 0x20

public static final int HEVCHighTierLevel3 = 128; // 0x80

public static final int HEVCHighTierLevel31 = 512; // 0x200

public static final int HEVCHighTierLevel4 = 2048; // 0x800

public static final int HEVCHighTierLevel41 = 8192; // 0x2000

public static final int HEVCHighTierLevel5 = 32768; // 0x8000

public static final int HEVCHighTierLevel51 = 131072; // 0x20000

public static final int HEVCHighTierLevel52 = 524288; // 0x80000

public static final int HEVCHighTierLevel6 = 2097152; // 0x200000

public static final int HEVCHighTierLevel61 = 8388608; // 0x800000

public static final int HEVCHighTierLevel62 = 33554432; // 0x2000000

public static final int HEVCMainTierLevel1 = 1; // 0x1

public static final int HEVCMainTierLevel2 = 4; // 0x4

public static final int HEVCMainTierLevel21 = 16; // 0x10

public static final int HEVCMainTierLevel3 = 64; // 0x40

public static final int HEVCMainTierLevel31 = 256; // 0x100

public static final int HEVCMainTierLevel4 = 1024; // 0x400

public static final int HEVCMainTierLevel41 = 4096; // 0x1000

public static final int HEVCMainTierLevel5 = 16384; // 0x4000

public static final int HEVCMainTierLevel51 = 65536; // 0x10000

public static final int HEVCMainTierLevel52 = 262144; // 0x40000

public static final int HEVCMainTierLevel6 = 1048576; // 0x100000

public static final int HEVCMainTierLevel61 = 4194304; // 0x400000

public static final int HEVCMainTierLevel62 = 16777216; // 0x1000000

public static final int HEVCProfileMain = 1; // 0x1

public static final int HEVCProfileMain10 = 2; // 0x2

public static final int HEVCProfileMain10HDR10 = 4096; // 0x1000

public static final int HEVCProfileMainStill = 4; // 0x4

public static final int MPEG2LevelH14 = 2; // 0x2

public static final int MPEG2LevelHL = 3; // 0x3

public static final int MPEG2LevelHP = 4; // 0x4

public static final int MPEG2LevelLL = 0; // 0x0

public static final int MPEG2LevelML = 1; // 0x1

public static final int MPEG2Profile422 = 2; // 0x2

public static final int MPEG2ProfileHigh = 5; // 0x5

public static final int MPEG2ProfileMain = 1; // 0x1

public static final int MPEG2ProfileSNR = 3; // 0x3

public static final int MPEG2ProfileSimple = 0; // 0x0

public static final int MPEG2ProfileSpatial = 4; // 0x4

public static final int MPEG4Level0 = 1; // 0x1

public static final int MPEG4Level0b = 2; // 0x2

public static final int MPEG4Level1 = 4; // 0x4

public static final int MPEG4Level2 = 8; // 0x8

public static final int MPEG4Level3 = 16; // 0x10

public static final int MPEG4Level3b = 24; // 0x18

public static final int MPEG4Level4 = 32; // 0x20

public static final int MPEG4Level4a = 64; // 0x40

public static final int MPEG4Level5 = 128; // 0x80

public static final int MPEG4Level6 = 256; // 0x100

public static final int MPEG4ProfileAdvancedCoding = 4096; // 0x1000

public static final int MPEG4ProfileAdvancedCore = 8192; // 0x2000

public static final int MPEG4ProfileAdvancedRealTime = 1024; // 0x400

public static final int MPEG4ProfileAdvancedScalable = 16384; // 0x4000

public static final int MPEG4ProfileAdvancedSimple = 32768; // 0x8000

public static final int MPEG4ProfileBasicAnimated = 256; // 0x100

public static final int MPEG4ProfileCore = 4; // 0x4

public static final int MPEG4ProfileCoreScalable = 2048; // 0x800

public static final int MPEG4ProfileHybrid = 512; // 0x200

public static final int MPEG4ProfileMain = 8; // 0x8

public static final int MPEG4ProfileNbit = 16; // 0x10

public static final int MPEG4ProfileScalableTexture = 32; // 0x20

public static final int MPEG4ProfileSimple = 1; // 0x1

public static final int MPEG4ProfileSimpleFBA = 128; // 0x80

public static final int MPEG4ProfileSimpleFace = 64; // 0x40

public static final int MPEG4ProfileSimpleScalable = 2; // 0x2

public static final int VP8Level_Version0 = 1; // 0x1

public static final int VP8Level_Version1 = 2; // 0x2

public static final int VP8Level_Version2 = 4; // 0x4

public static final int VP8Level_Version3 = 8; // 0x8

public static final int VP8ProfileMain = 1; // 0x1

public static final int VP9Level1 = 1; // 0x1

public static final int VP9Level11 = 2; // 0x2

public static final int VP9Level2 = 4; // 0x4

public static final int VP9Level21 = 8; // 0x8

public static final int VP9Level3 = 16; // 0x10

public static final int VP9Level31 = 32; // 0x20

public static final int VP9Level4 = 64; // 0x40

public static final int VP9Level41 = 128; // 0x80

public static final int VP9Level5 = 256; // 0x100

public static final int VP9Level51 = 512; // 0x200

public static final int VP9Level52 = 1024; // 0x400

public static final int VP9Level6 = 2048; // 0x800

public static final int VP9Level61 = 4096; // 0x1000

public static final int VP9Level62 = 8192; // 0x2000

public static final int VP9Profile0 = 1; // 0x1

public static final int VP9Profile1 = 2; // 0x2

public static final int VP9Profile2 = 4; // 0x4

public static final int VP9Profile2HDR = 4096; // 0x1000

public static final int VP9Profile3 = 8; // 0x8

public static final int VP9Profile3HDR = 8192; // 0x2000

/**
 * Defined in the OpenMAX IL specs, depending on the type of media
 * this can be OMX_VIDEO_AVCLEVELTYPE, OMX_VIDEO_H263LEVELTYPE
 * OMX_VIDEO_MPEG4LEVELTYPE, OMX_VIDEO_VP8LEVELTYPE or OMX_VIDEO_VP9LEVELTYPE.
 *
 * Note that VP9 decoder on platforms before {@link android.os.Build.VERSION_CODES#N} may
 * not advertise a profile level support. For those VP9 decoders, please use
 * {@link VideoCapabilities} to determine the codec capabilities.
 */

public int level;

/**
 * Defined in the OpenMAX IL specs, depending on the type of media
 * this can be OMX_VIDEO_AVCPROFILETYPE, OMX_VIDEO_H263PROFILETYPE,
 * OMX_VIDEO_MPEG4PROFILETYPE, OMX_VIDEO_VP8PROFILETYPE or OMX_VIDEO_VP9PROFILETYPE.
 */

public int profile;
}

/**
 * A class that supports querying the encoding capabilities of a codec.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class EncoderCapabilities {

EncoderCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the supported range of quality values.
 *
 * Quality is implementation-specific. As a general rule, a higher quality
 * setting results in a better image quality and a lower compression ratio.
 */

public android.util.Range<java.lang.Integer> getQualityRange() { throw new RuntimeException("Stub!"); }

/**
 * Returns the supported range of encoder complexity values.
 * <p>
 * Some codecs may support multiple complexity levels, where higher
 * complexity values use more encoder tools (e.g. perform more
 * intensive calculations) to improve the quality or the compression
 * ratio.  Use a lower value to save power and/or time.
 */

public android.util.Range<java.lang.Integer> getComplexityRange() { throw new RuntimeException("Stub!"); }

/**
 * Query whether a bitrate mode is supported.
 */

public boolean isBitrateModeSupported(int mode) { throw new RuntimeException("Stub!"); }

/** Constant bitrate mode */

public static final int BITRATE_MODE_CBR = 2; // 0x2

/** Constant quality mode */

public static final int BITRATE_MODE_CQ = 0; // 0x0

/** Variable bitrate mode */

public static final int BITRATE_MODE_VBR = 1; // 0x1
}

/**
 * A class that supports querying the video capabilities of a codec.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class VideoCapabilities {

VideoCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported bitrates in bits/second.
 */

public android.util.Range<java.lang.Integer> getBitrateRange() { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported video widths.
 */

public android.util.Range<java.lang.Integer> getSupportedWidths() { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported video heights.
 */

public android.util.Range<java.lang.Integer> getSupportedHeights() { throw new RuntimeException("Stub!"); }

/**
 * Returns the alignment requirement for video width (in pixels).
 *
 * This is a power-of-2 value that video width must be a
 * multiple of.
 */

public int getWidthAlignment() { throw new RuntimeException("Stub!"); }

/**
 * Returns the alignment requirement for video height (in pixels).
 *
 * This is a power-of-2 value that video height must be a
 * multiple of.
 */

public int getHeightAlignment() { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported frame rates.
 * <p>
 * This is not a performance indicator.  Rather, it expresses the
 * limits specified in the coding standard, based on the complexities
 * of encoding material for later playback at a certain frame rate,
 * or the decoding of such material in non-realtime.
 */

public android.util.Range<java.lang.Integer> getSupportedFrameRates() { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported video widths for a video height.
 * @param height the height of the video
 */

public android.util.Range<java.lang.Integer> getSupportedWidthsFor(int height) { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported video heights for a video width
 * @param width the width of the video
 */

public android.util.Range<java.lang.Integer> getSupportedHeightsFor(int width) { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of supported video frame rates for a video size.
 * <p>
 * This is not a performance indicator.  Rather, it expresses the limits specified in
 * the coding standard, based on the complexities of encoding material of a given
 * size for later playback at a certain frame rate, or the decoding of such material
 * in non-realtime.
 
 * @param width the width of the video
 * @param height the height of the video
 */

public android.util.Range<java.lang.Double> getSupportedFrameRatesFor(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Returns the range of achievable video frame rates for a video size.
 * May return {@code null}, if the codec did not publish any measurement
 * data.
 * <p>
 * This is a performance estimate provided by the device manufacturer based on statistical
 * sampling of full-speed decoding and encoding measurements in various configurations
 * of common video sizes supported by the codec. As such it should only be used to
 * compare individual codecs on the device. The value is not suitable for comparing
 * different devices or even different android releases for the same device.
 * <p>
 * <em>On {@link android.os.Build.VERSION_CODES#M} release</em> the returned range
 * corresponds to the fastest frame rates achieved in the tested configurations. As
 * such, it should not be used to gauge guaranteed or even average codec performance
 * on the device.
 * <p>
 * <em>On {@link android.os.Build.VERSION_CODES#N} release</em> the returned range
 * corresponds closer to sustained performance <em>in tested configurations</em>.
 * One can expect to achieve sustained performance higher than the lower limit more than
 * 50% of the time, and higher than half of the lower limit at least 90% of the time
 * <em>in tested configurations</em>.
 * Conversely, one can expect performance lower than twice the upper limit at least
 * 90% of the time.
 * <p class=note>
 * Tested configurations use a single active codec. For use cases where multiple
 * codecs are active, applications can expect lower and in most cases significantly lower
 * performance.
 * <p class=note>
 * The returned range value is interpolated from the nearest frame size(s) tested.
 * Codec performance is severely impacted by other activity on the device as well
 * as environmental factors (such as battery level, temperature or power source), and can
 * vary significantly even in a steady environment.
 * <p class=note>
 * Use this method in cases where only codec performance matters, e.g. to evaluate if
 * a codec has any chance of meeting a performance target. Codecs are listed
 * in {@link MediaCodecList} in the preferred order as defined by the device
 * manufacturer. As such, applications should use the first suitable codec in the
 * list to achieve the best balance between power use and performance.
 *
 * @param width the width of the video
 * @param height the height of the video
 *
 * @throws IllegalArgumentException if the video size is not supported.
 */

@androidx.annotation.RecentlyNullable public android.util.Range<java.lang.Double> getAchievableFrameRatesFor(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether a given video size ({@code width} and
 * {@code height}) and {@code frameRate} combination is supported.
 */

public boolean areSizeAndRateSupported(int width, int height, double frameRate) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether a given video size ({@code width} and
 * {@code height}) is supported.
 */

public boolean isSizeSupported(int width, int height) { throw new RuntimeException("Stub!"); }
}

}

