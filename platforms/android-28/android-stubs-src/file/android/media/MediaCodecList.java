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

import android.media.MediaCodecInfo;

/**
 * Allows you to enumerate available codecs, each specified as a {@link MediaCodecInfo} object,
 * find a codec supporting a given format and query the capabilities
 * of a given codec.
 * <p>See {@link MediaCodecInfo} for sample usage.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaCodecList {

/**
 * Create a list of media-codecs of a specific kind.
 * @param kind Either {@code REGULAR_CODECS} or {@code ALL_CODECS}.
 */

public MediaCodecList(int kind) { throw new RuntimeException("Stub!"); }

/**
 * Count the number of available (regular) codecs.
 *
 * @deprecated Use {@link #getCodecInfos} instead.
 *
 * @see #REGULAR_CODECS
 */

@Deprecated public static int getCodecCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link MediaCodecInfo} object for the codec at
 * the given {@code index} in the regular list.
 *
 * @deprecated Use {@link #getCodecInfos} instead.
 *
 * @see #REGULAR_CODECS
 */

@Deprecated public static android.media.MediaCodecInfo getCodecInfoAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of {@link MediaCodecInfo} objects for the list
 * of media-codecs.
 */

public android.media.MediaCodecInfo[] getCodecInfos() { throw new RuntimeException("Stub!"); }

/**
 * Find a decoder supporting a given {@link MediaFormat} in the list
 * of media-codecs.
 *
 * <p class=note>
 * <strong>Note:</strong> On {@link android.os.Build.VERSION_CODES#LOLLIPOP},
 * {@code format} must not contain a {@linkplain MediaFormat#KEY_FRAME_RATE
 * frame rate}. Use
 * <code class=prettyprint>format.setString(MediaFormat.KEY_FRAME_RATE, null)</code>
 * to clear any existing frame rate setting in the format.
 *
 * @see MediaCodecList.CodecCapabilities.isFormatSupported for format keys
 * considered per android versions when evaluating suitable codecs.
 *
 * @param format A decoder media format with optional feature directives.
 * @throws IllegalArgumentException if format is not a valid media format.
 * @throws NullPointerException if format is null.
 * @return the name of a decoder that supports the given format and feature
 *         requests, or {@code null} if no such codec has been found.
 */

public java.lang.String findDecoderForFormat(android.media.MediaFormat format) { throw new RuntimeException("Stub!"); }

/**
 * Find an encoder supporting a given {@link MediaFormat} in the list
 * of media-codecs.
 *
 * <p class=note>
 * <strong>Note:</strong> On {@link android.os.Build.VERSION_CODES#LOLLIPOP},
 * {@code format} must not contain a {@linkplain MediaFormat#KEY_FRAME_RATE
 * frame rate}. Use
 * <code class=prettyprint>format.setString(MediaFormat.KEY_FRAME_RATE, null)</code>
 * to clear any existing frame rate setting in the format.
 *
 * @see MediaCodecList.CodecCapabilities.isFormatSupported for format keys
 * considered per android versions when evaluating suitable codecs.
 *
 * @param format An encoder media format with optional feature directives.
 * @throws IllegalArgumentException if format is not a valid media format.
 * @throws NullPointerException if format is null.
 * @return the name of an encoder that supports the given format and feature
 *         requests, or {@code null} if no such codec has been found.
 */

public java.lang.String findEncoderForFormat(android.media.MediaFormat format) { throw new RuntimeException("Stub!"); }

/**
 * Use in {@link #MediaCodecList} to enumerate all codecs, even ones that are
 * not suitable for regular (buffer-to-buffer) decoding or encoding.  These
 * include codecs, for example, that only work with special input or output
 * surfaces, such as secure-only or tunneled-only codecs.
 *
 * @see MediaCodecInfo.CodecCapabilities#isFormatSupported
 * @see MediaCodecInfo.CodecCapabilities#FEATURE_SecurePlayback
 * @see MediaCodecInfo.CodecCapabilities#FEATURE_TunneledPlayback
 */

public static final int ALL_CODECS = 1; // 0x1

/**
 * Use in {@link #MediaCodecList} to enumerate only codecs that are suitable
 * for regular (buffer-to-buffer) decoding or encoding.
 *
 * <em>NOTE:</em> These are the codecs that are returned prior to API 21,
 * using the now deprecated static methods.
 */

public static final int REGULAR_CODECS = 0; // 0x0
}

