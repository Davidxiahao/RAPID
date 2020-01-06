/*
 * Copyright (C) 2013 The Android Open Source Project
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

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec;
import java.nio.ByteBuffer;
import java.io.IOException;
import java.io.FileDescriptor;

/**
 * MediaMuxer facilitates muxing elementary streams. Currently MediaMuxer supports MP4, Webm
 * and 3GP file as the output. It also supports muxing B-frames in MP4 since Android Nougat.
 * <p>
 * It is generally used like this:
 *
 * <pre>
 * MediaMuxer muxer = new MediaMuxer("temp.mp4", OutputFormat.MUXER_OUTPUT_MPEG_4);
 * // More often, the MediaFormat will be retrieved from MediaCodec.getOutputFormat()
 * // or MediaExtractor.getTrackFormat().
 * MediaFormat audioFormat = new MediaFormat(...);
 * MediaFormat videoFormat = new MediaFormat(...);
 * int audioTrackIndex = muxer.addTrack(audioFormat);
 * int videoTrackIndex = muxer.addTrack(videoFormat);
 * ByteBuffer inputBuffer = ByteBuffer.allocate(bufferSize);
 * boolean finished = false;
 * BufferInfo bufferInfo = new BufferInfo();
 *
 * muxer.start();
 * while(!finished) {
 *   // getInputBuffer() will fill the inputBuffer with one frame of encoded
 *   // sample from either MediaCodec or MediaExtractor, set isAudioSample to
 *   // true when the sample is audio data, set up all the fields of bufferInfo,
 *   // and return true if there are no more samples.
 *   finished = getInputBuffer(inputBuffer, isAudioSample, bufferInfo);
 *   if (!finished) {
 *     int currentTrackIndex = isAudioSample ? audioTrackIndex : videoTrackIndex;
 *     muxer.writeSampleData(currentTrackIndex, inputBuffer, bufferInfo);
 *   }
 * };
 * muxer.stop();
 * muxer.release();
 * </pre>
 *
 
 <h4>Metadata Track</h4>
 <p>
  Per-frame metadata is useful in carrying extra information that correlated with video or audio to
  facilitate offline processing, e.g. gyro signals from the sensor could help video stabilization when
  doing offline processing. Metadata track is only supported in MP4 container. When adding a new
  metadata track, track's mime format must start with prefix "application/", e.g. "applicaton/gyro".
  Metadata's format/layout will be defined by the application. Writing metadata is nearly the same as
  writing video/audio data except that the data will not be from mediacodec. Application just needs
  to pass the bytebuffer that contains the metadata and also the associated timestamp to the
  {@link #writeSampleData} api. The timestamp must be in the same time base as video and audio. The
  generated MP4 file uses TextMetaDataSampleEntry defined in section 12.3.3.2 of the ISOBMFF to signal
  the metadata's mime format. When using{@link android.media.MediaExtractor} to extract the file with
  metadata track, the mime format of the metadata will be extracted into {@link android.media.MediaFormat}.
 
 <pre class=prettyprint>
   MediaMuxer muxer = new MediaMuxer("temp.mp4", OutputFormat.MUXER_OUTPUT_MPEG_4);
   // SetUp Video/Audio Tracks.
   MediaFormat audioFormat = new MediaFormat(...);
   MediaFormat videoFormat = new MediaFormat(...);
   int audioTrackIndex = muxer.addTrack(audioFormat);
   int videoTrackIndex = muxer.addTrack(videoFormat);
 
   // Setup Metadata Track
   MediaFormat metadataFormat = new MediaFormat(...);
   metadataFormat.setString(KEY_MIME, "application/gyro");
   int metadataTrackIndex = muxer.addTrack(metadataFormat);
 
   muxer.start();
   while(..) {
       // Allocate bytebuffer and write gyro data(x,y,z) into it.
       ByteBuffer metaData = ByteBuffer.allocate(bufferSize);
       metaData.putFloat(x);
       metaData.putFloat(y);
       metaData.putFloat(z);
       BufferInfo metaInfo = new BufferInfo();
       // Associate this metadata with the video frame by setting
       // the same timestamp as the video frame.
       metaInfo.presentationTimeUs = currentVideoTrackTimeUs;
       metaInfo.offset = 0;
       metaInfo.flags = 0;
       metaInfo.size = bufferSize;
       muxer.writeSampleData(metadataTrackIndex, metaData, metaInfo);
   };
   muxer.stop();
   muxer.release();
 }</pre>
 
 <h2 id=History><a name="History"></a>Features and API History</h2>
 <p>
 The following table summarizes the feature support in different API version and containers.
 For API version numbers, see {@link android.os.Build.VERSION_CODES}.
 
 <style>
 .api > tr > th, .api > tr > td { text-align: center; padding: 4px 4px; }
 .api > tr > th     { vertical-align: bottom; }
 .api > tr > td     { vertical-align: middle; }
 .sml > tr > th, .sml > tr > td { text-align: center; padding: 2px 4px; }
 .fn { text-align: center; }
 </style>
 
 <table align="right" style="width: 0%">
  <thead>
   <tbody class=api>
    <tr><th>Symbol</th>
    <th>Meaning</th></tr>
   </tbody>
  </thead>
  <tbody class=sml>
   <tr><td>&#9679;</td><td>Supported</td></tr>
   <tr><td>&#9675;</td><td>Not supported</td></tr>
   <tr><td>&#9639;</td><td>Supported in MP4/WebM/3GP</td></tr>
   <tr><td>&#8277;</td><td>Only Supported in MP4</td></tr>
  </tbody>
 </table>
 <table align="center" style="width: 100%;">
  <thead class=api>
   <tr>
    <th rowspan=2>Feature</th>
    <th colspan="24">SDK Version</th>
   </tr>
   <tr>
    <th>18</th>
    <th>19</th>
    <th>20</th>
    <th>21</th>
    <th>22</th>
    <th>23</th>
    <th>24</th>
    <th>25</th>
    <th>26+</th>
   </tr>
  </thead>
 <tbody class=api>
   <tr>
    <td align="center">MP4 container</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
   </tr>
    <td align="center">WebM container</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
    <td>&#9679;</td>
   </tr>
    <td align="center">3GP container</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9679;</td>
   </tr>
    <td align="center">Muxing B-Frames(bi-directional predicted frames)</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#8277;</td>
    <td>&#8277;</td>
    <td>&#8277;</td>
   </tr>
   </tr>
    <td align="center">Muxing Single Video/Audio Track</td>
    <td>&#9639;</td>
    <td>&#9639;</td>
    <td>&#9639;</td>
    <td>&#9639;</td>
    <td>&#9639;</td>
    <td>&#9639;</td>
    <td>&#9639;</td>
    <td>&#9639;</td>
    <td>&#9639;</td>
   </tr>
   </tr>
    <td align="center">Muxing Multiple Video/Audio Tracks</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#8277;</td>
   </tr>
   </tr>
    <td align="center">Muxing Metadata Tracks</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#9675;</td>
    <td>&#8277;</td>
   </tr>
   </tbody>
 </table>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaMuxer {

/**
 * Constructor.
 * Creates a media muxer that writes to the specified path.
 * @param path The path of the output media file.
 * This value must never be {@code null}.
 * @param format The format of the output media file.
 * Value is {@link android.media.MediaMuxer.OutputFormat#MUXER_OUTPUT_MPEG_4}, {@link android.media.MediaMuxer.OutputFormat#MUXER_OUTPUT_WEBM}, {@link android.media.MediaMuxer.OutputFormat#MUXER_OUTPUT_3GPP}, or {@link android.media.MediaMuxer.OutputFormat#MUXER_OUTPUT_HEIF}
 * @see android.media.MediaMuxer.OutputFormat
 * @throws IllegalArgumentException if path is invalid or format is not supported.
 * @throws IOException if failed to open the file for write.
 */

public MediaMuxer(@androidx.annotation.RecentlyNonNull java.lang.String path, int format) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Constructor.
 * Creates a media muxer that writes to the specified FileDescriptor. File descriptor
 * must be seekable and writable. Application should not use the file referenced
 * by this file descriptor until {@link #stop}. It is the application's responsibility
 * to close the file descriptor. It is safe to do so as soon as this call returns.
 * @param fd The FileDescriptor of the output media file.
 * This value must never be {@code null}.
 * @param format The format of the output media file.
 * Value is {@link android.media.MediaMuxer.OutputFormat#MUXER_OUTPUT_MPEG_4}, {@link android.media.MediaMuxer.OutputFormat#MUXER_OUTPUT_WEBM}, {@link android.media.MediaMuxer.OutputFormat#MUXER_OUTPUT_3GPP}, or {@link android.media.MediaMuxer.OutputFormat#MUXER_OUTPUT_HEIF}
 * @see android.media.MediaMuxer.OutputFormat
 * @throws IllegalArgumentException if fd is invalid or format is not supported.
 * @throws IOException if failed to open the file for write.
 */

public MediaMuxer(@androidx.annotation.RecentlyNonNull java.io.FileDescriptor fd, int format) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Sets the orientation hint for output video playback.
 * <p>This method should be called before {@link #start}. Calling this
 * method will not rotate the video frame when muxer is generating the file,
 * but add a composition matrix containing the rotation angle in the output
 * video if the output format is
 * {@link OutputFormat#MUXER_OUTPUT_MPEG_4} so that a video player can
 * choose the proper orientation for playback. Note that some video players
 * may choose to ignore the composition matrix in a video during playback.
 * By default, the rotation degree is 0.</p>
 * @param degrees the angle to be rotated clockwise in degrees.
 * The supported angles are 0, 90, 180, and 270 degrees.
 * @throws IllegalArgumentException if degree is not supported.
 * @throws IllegalStateException If this method is called after {@link #start}.
 */

public void setOrientationHint(int degrees) { throw new RuntimeException("Stub!"); }

/**
 * Set and store the geodata (latitude and longitude) in the output file.
 * This method should be called before {@link #start}. The geodata is stored
 * in udta box if the output format is
 * {@link OutputFormat#MUXER_OUTPUT_MPEG_4}, and is ignored for other output
 * formats. The geodata is stored according to ISO-6709 standard.
 *
 * @param latitude Latitude in degrees. Its value must be in the range [-90,
 * 90].
 * @param longitude Longitude in degrees. Its value must be in the range
 * [-180, 180].
 * @throws IllegalArgumentException If the given latitude or longitude is out
 * of range.
 * @throws IllegalStateException If this method is called after {@link #start}.
 */

public void setLocation(float latitude, float longitude) { throw new RuntimeException("Stub!"); }

/**
 * Starts the muxer.
 * <p>Make sure this is called after {@link #addTrack} and before
 * {@link #writeSampleData}.</p>
 * @throws IllegalStateException If this method is called after {@link #start}
 * or Muxer is released
 */

public void start() { throw new RuntimeException("Stub!"); }

/**
 * Stops the muxer.
 * <p>Once the muxer stops, it can not be restarted.</p>
 * @throws IllegalStateException if muxer is in the wrong state.
 */

public void stop() { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Adds a track with the specified format.
 * <p>
 * The following table summarizes support for specific format keys across android releases.
 * Keys marked with '+:' are required.
 *
 * <table style="width: 0%">
 *  <thead>
 *   <tr>
 *    <th rowspan=2>OS Version(s)</th>
 *    <td colspan=3>{@code MediaFormat} keys used for</th>
 *   </tr><tr>
 *    <th>All Tracks</th>
 *    <th>Audio Tracks</th>
 *    <th>Video Tracks</th>
 *   </tr>
 *  </thead>
 *  <tbody>
 *   <tr>
 *    <td>{@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}</td>
 *    <td rowspan=7>+: {@link MediaFormat#KEY_MIME}</td>
 *    <td rowspan=3>+: {@link MediaFormat#KEY_SAMPLE_RATE},<br>
 *        +: {@link MediaFormat#KEY_CHANNEL_COUNT},<br>
 *        +: <strong>codec-specific data<sup>AAC</sup></strong></td>
 *    <td rowspan=5>+: {@link MediaFormat#KEY_WIDTH},<br>
 *        +: {@link MediaFormat#KEY_HEIGHT},<br>
 *        no {@code KEY_ROTATION},
 *        use {@link #setOrientationHint setOrientationHint()}<sup>.mp4</sup>,<br>
 *        +: <strong>codec-specific data<sup>AVC, MPEG4</sup></strong></td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#KITKAT}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#KITKAT_WATCH}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#LOLLIPOP}</td>
 *    <td rowspan=4>as above, plus<br>
 *        +: <strong>codec-specific data<sup>Vorbis & .webm</sup></strong></td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#M}</td>
 *    <td>as above, plus<br>
 *        {@link MediaFormat#KEY_BIT_RATE}<sup>AAC</sup></td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#N}</td>
 *    <td>as above, plus<br>
 *        <!-- {link MediaFormat#KEY_MAX_BIT_RATE}<sup>AAC, MPEG4</sup>,<br> -->
 *        {@link MediaFormat#KEY_BIT_RATE}<sup>MPEG4</sup>,<br>
 *        {@link MediaFormat#KEY_HDR_STATIC_INFO}<sup>#, .webm</sup>,<br>
 *        {@link MediaFormat#KEY_COLOR_STANDARD}<sup>#</sup>,<br>
 *        {@link MediaFormat#KEY_COLOR_TRANSFER}<sup>#</sup>,<br>
 *        {@link MediaFormat#KEY_COLOR_RANGE}<sup>#</sup>,<br>
 *        +: <strong>codec-specific data<sup>HEVC</sup></strong>,<br>
 *        codec-specific data<sup>VP9</sup></td>
 *   </tr>
 *   <tr>
 *    <td colspan=4>
 *     <p class=note><strong>Notes:</strong><br>
 *      #: storing into container metadata.<br>
 *      .mp4, .webm&hellip;: for listed containers<br>
 *      MPEG4, AAC&hellip;: for listed codecs
 *    </td>
 *   </tr><tr>
 *    <td colspan=4>
 *     <p class=note>Note that the codec-specific data for the track must be specified using
 *     this method. Furthermore, codec-specific data must not be passed/specified via the
 *     {@link #writeSampleData writeSampleData()} call.
 *    </td>
 *   </tr>
 *  </tbody>
 * </table>
 *
 * <p>
 * The following table summarizes codec support for containers across android releases:
 *
 * <table style="width: 0%">
 *  <thead>
 *   <tr>
 *    <th rowspan=2>OS Version(s)</th>
 *    <td colspan=3>Codec support</th>
 *   </tr><tr>
 *    <th>{@linkplain OutputFormat#MUXER_OUTPUT_MPEG_4 MP4}</th>
 *    <th>{@linkplain OutputFormat#MUXER_OUTPUT_WEBM WEBM}</th>
 *   </tr>
 *  </thead>
 *  <tbody>
 *   <tr>
 *    <td>{@link android.os.Build.VERSION_CODES#JELLY_BEAN_MR2}</td>
 *    <td rowspan=6>{@link MediaFormat#MIMETYPE_AUDIO_AAC AAC},<br>
 *        {@link MediaFormat#MIMETYPE_AUDIO_AMR_NB NB-AMR},<br>
 *        {@link MediaFormat#MIMETYPE_AUDIO_AMR_WB WB-AMR},<br>
 *        {@link MediaFormat#MIMETYPE_VIDEO_H263 H.263},<br>
 *        {@link MediaFormat#MIMETYPE_VIDEO_MPEG4 MPEG-4},<br>
 *        {@link MediaFormat#MIMETYPE_VIDEO_AVC AVC} (H.264)</td>
 *    <td rowspan=3>Not supported</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#KITKAT}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#KITKAT_WATCH}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#LOLLIPOP}</td>
 *    <td rowspan=3>{@link MediaFormat#MIMETYPE_AUDIO_VORBIS Vorbis},<br>
 *        {@link MediaFormat#MIMETYPE_VIDEO_VP8 VP8}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#LOLLIPOP_MR1}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#M}</td>
 *   </tr><tr>
 *    <td>{@link android.os.Build.VERSION_CODES#N}</td>
 *    <td>as above, plus<br>
 *        {@link MediaFormat#MIMETYPE_VIDEO_HEVC HEVC} (H.265)</td>
 *    <td>as above, plus<br>
 *        {@link MediaFormat#MIMETYPE_VIDEO_VP9 VP9}</td>
 *   </tr>
 *  </tbody>
 * </table>
 *
 * @param format The media format for the track.  This must not be an empty
 *               MediaFormat.
 * This value must never be {@code null}.
 * @return The track index for this newly added track, and it should be used
 * in the {@link #writeSampleData}.
 * @throws IllegalArgumentException if format is invalid.
 * @throws IllegalStateException if muxer is in the wrong state.
 */

public int addTrack(@androidx.annotation.RecentlyNonNull android.media.MediaFormat format) { throw new RuntimeException("Stub!"); }

/**
 * Writes an encoded sample into the muxer.
 * <p>The application needs to make sure that the samples are written into
 * the right tracks. Also, it needs to make sure the samples for each track
 * are written in chronological order (e.g. in the order they are provided
 * by the encoder.)</p>
 * @param byteBuf The encoded sample.
 * This value must never be {@code null}.
 * @param trackIndex The track index for this sample.
 * @param bufferInfo The buffer information related to this sample.
 * This value must never be {@code null}.
 * @throws IllegalArgumentException if trackIndex, byteBuf or bufferInfo is  invalid.
 * @throws IllegalStateException if muxer is in wrong state.
 * MediaMuxer uses the flags provided in {@link MediaCodec.BufferInfo},
 * to signal sync frames.
 */

public void writeSampleData(int trackIndex, @androidx.annotation.RecentlyNonNull java.nio.ByteBuffer byteBuf, @androidx.annotation.RecentlyNonNull android.media.MediaCodec.BufferInfo bufferInfo) { throw new RuntimeException("Stub!"); }

/**
 * Make sure you call this when you're done to free up any resources
 * instead of relying on the garbage collector to do this for you at
 * some point in the future.
 */

public void release() { throw new RuntimeException("Stub!"); }
/**
 * Defines the output format. These constants are used with constructor.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class OutputFormat {

OutputFormat() { throw new RuntimeException("Stub!"); }

/** 3GPP media file format*/

public static final int MUXER_OUTPUT_3GPP = 2; // 0x2

/** HEIF media file format*/

public static final int MUXER_OUTPUT_HEIF = 3; // 0x3

/** MPEG4 media file format*/

public static final int MUXER_OUTPUT_MPEG_4 = 0; // 0x0

/** WEBM media file format*/

public static final int MUXER_OUTPUT_WEBM = 1; // 0x1
}

}

