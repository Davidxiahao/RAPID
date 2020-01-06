/* Copyright (C) 2010 The Android Open Source Project
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


package android.graphics;

import java.io.IOException;
import java.io.InputStream;

/**
 * BitmapRegionDecoder can be used to decode a rectangle region from an image.
 * BitmapRegionDecoder is particularly useful when an original image is large and
 * you only need parts of the image.
 *
 * <p>To create a BitmapRegionDecoder, call newInstance(...).
 * Given a BitmapRegionDecoder, users can call decodeRegion() repeatedly
 * to get a decoded Bitmap of the specified region.
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BitmapRegionDecoder {

BitmapRegionDecoder(long decoder) { throw new RuntimeException("Stub!"); }

/**
 * Create a BitmapRegionDecoder from the specified byte array.
 * Currently only the JPEG and PNG formats are supported.
 *
 * @param data byte array of compressed image data.
 * @param offset offset into data for where the decoder should begin
 *               parsing.
 * @param length the number of bytes, beginning at offset, to parse
 * @param isShareable If this is true, then the BitmapRegionDecoder may keep a
 *                    shallow reference to the input. If this is false,
 *                    then the BitmapRegionDecoder will explicitly make a copy of the
 *                    input data, and keep that. Even if sharing is allowed,
 *                    the implementation may still decide to make a deep
 *                    copy of the input data. If an image is progressively encoded,
 *                    allowing sharing may degrade the decoding speed.
 * @return BitmapRegionDecoder, or null if the image data could not be decoded.
 * @throws IOException if the image format is not supported or can not be decoded.
 */

public static android.graphics.BitmapRegionDecoder newInstance(byte[] data, int offset, int length, boolean isShareable) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a BitmapRegionDecoder from the file descriptor.
 * The position within the descriptor will not be changed when
 * this returns, so the descriptor can be used again as is.
 * Currently only the JPEG and PNG formats are supported.
 *
 * @param fd The file descriptor containing the data to decode
 * @param isShareable If this is true, then the BitmapRegionDecoder may keep a
 *                    shallow reference to the input. If this is false,
 *                    then the BitmapRegionDecoder will explicitly make a copy of the
 *                    input data, and keep that. Even if sharing is allowed,
 *                    the implementation may still decide to make a deep
 *                    copy of the input data. If an image is progressively encoded,
 *                    allowing sharing may degrade the decoding speed.
 * @return BitmapRegionDecoder, or null if the image data could not be decoded.
 * @throws IOException if the image format is not supported or can not be decoded.
 */

public static android.graphics.BitmapRegionDecoder newInstance(java.io.FileDescriptor fd, boolean isShareable) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a BitmapRegionDecoder from an input stream.
 * The stream's position will be where ever it was after the encoded data
 * was read.
 * Currently only the JPEG and PNG formats are supported.
 *
 * @param is The input stream that holds the raw data to be decoded into a
 *           BitmapRegionDecoder.
 * @param isShareable If this is true, then the BitmapRegionDecoder may keep a
 *                    shallow reference to the input. If this is false,
 *                    then the BitmapRegionDecoder will explicitly make a copy of the
 *                    input data, and keep that. Even if sharing is allowed,
 *                    the implementation may still decide to make a deep
 *                    copy of the input data. If an image is progressively encoded,
 *                    allowing sharing may degrade the decoding speed.
 * @return BitmapRegionDecoder, or null if the image data could not be decoded.
 * @throws IOException if the image format is not supported or can not be decoded.
 *
 * <p class="note">Prior to {@link android.os.Build.VERSION_CODES#KITKAT},
 * if {@link InputStream#markSupported is.markSupported()} returns true,
 * <code>is.mark(1024)</code> would be called. As of
 * {@link android.os.Build.VERSION_CODES#KITKAT}, this is no longer the case.</p>
 */

public static android.graphics.BitmapRegionDecoder newInstance(java.io.InputStream is, boolean isShareable) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Create a BitmapRegionDecoder from a file path.
 * Currently only the JPEG and PNG formats are supported.
 *
 * @param pathName complete path name for the file to be decoded.
 * @param isShareable If this is true, then the BitmapRegionDecoder may keep a
 *                    shallow reference to the input. If this is false,
 *                    then the BitmapRegionDecoder will explicitly make a copy of the
 *                    input data, and keep that. Even if sharing is allowed,
 *                    the implementation may still decide to make a deep
 *                    copy of the input data. If an image is progressively encoded,
 *                    allowing sharing may degrade the decoding speed.
 * @return BitmapRegionDecoder, or null if the image data could not be decoded.
 * @throws IOException if the image format is not supported or can not be decoded.
 */

public static android.graphics.BitmapRegionDecoder newInstance(java.lang.String pathName, boolean isShareable) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Decodes a rectangle region in the image specified by rect.
 *
 * @param rect The rectangle that specified the region to be decode.
 * @param options null-ok; Options that control downsampling.
 *             inPurgeable is not supported.
 * @return The decoded bitmap, or null if the image data could not be
 *         decoded.
 * @throws IllegalArgumentException if {@link BitmapFactory.Options#inPreferredConfig}
 *         is {@link android.graphics.Bitmap.Config#HARDWARE}
 *         and {@link BitmapFactory.Options#inMutable} is set, if the specified color space
 *         is not {@link ColorSpace.Model#RGB RGB}, or if the specified color space's transfer
 *         function is not an {@link ColorSpace.Rgb.TransferParameters ICC parametric curve}
 */

public android.graphics.Bitmap decodeRegion(android.graphics.Rect rect, android.graphics.BitmapFactory.Options options) { throw new RuntimeException("Stub!"); }

/** Returns the original image's width */

public int getWidth() { throw new RuntimeException("Stub!"); }

/** Returns the original image's height */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Frees up the memory associated with this region decoder, and mark the
 * region decoder as "dead", meaning it will throw an exception if decodeRegion(),
 * getWidth() or getHeight() is called.
 *
 * <p>This operation cannot be reversed, so it should only be called if you are
 * sure there are no further uses for the region decoder. This is an advanced call,
 * and normally need not be called, since the normal GC process will free up this
 * memory when there are no more references to this region decoder.
 */

public void recycle() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this region decoder has been recycled.
 * If so, then it is an error to try use its method.
 *
 * @return true if the region decoder has been recycled
 */

public boolean isRecycled() { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

