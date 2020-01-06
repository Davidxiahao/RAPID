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

import android.view.Surface;
import android.graphics.ImageFormat;
import android.graphics.PixelFormat;
import android.hardware.HardwareBuffer;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

/**
 * <p>The ImageReader class allows direct application access to image data
 * rendered into a {@link android.view.Surface}</p>
 *
 * <p>Several Android media API classes accept Surface objects as targets to
 * render to, including {@link MediaPlayer}, {@link MediaCodec},
 * {@link android.hardware.camera2.CameraDevice}, {@link ImageWriter} and
 * {@link android.renderscript.Allocation RenderScript Allocations}. The image
 * sizes and formats that can be used with each source vary, and should be
 * checked in the documentation for the specific API.</p>
 *
 * <p>The image data is encapsulated in {@link Image} objects, and multiple such
 * objects can be accessed at the same time, up to the number specified by the
 * {@code maxImages} constructor parameter. New images sent to an ImageReader
 * through its {@link Surface} are queued until accessed through the {@link #acquireLatestImage}
 * or {@link #acquireNextImage} call. Due to memory limits, an image source will
 * eventually stall or drop Images in trying to render to the Surface if the
 * ImageReader does not obtain and release Images at a rate equal to the
 * production rate.</p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ImageReader implements java.lang.AutoCloseable {

/**
 * @hide
 */

ImageReader(int width, int height, int format, int maxImages, long usage) { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Create a new reader for images of the desired size and format.
 * </p>
 * <p>
 * The {@code maxImages} parameter determines the maximum number of
 * {@link Image} objects that can be be acquired from the
 * {@code ImageReader} simultaneously. Requesting more buffers will use up
 * more memory, so it is important to use only the minimum number necessary
 * for the use case.
 * </p>
 * <p>
 * The valid sizes and formats depend on the source of the image data.
 * </p>
 * <p>
 * If the {@code format} is {@link ImageFormat#PRIVATE PRIVATE}, the created
 * {@link ImageReader} will produce images that are not directly accessible
 * by the application. The application can still acquire images from this
 * {@link ImageReader}, and send them to the
 * {@link android.hardware.camera2.CameraDevice camera} for reprocessing via
 * {@link ImageWriter} interface. However, the {@link Image#getPlanes()
 * getPlanes()} will return an empty array for {@link ImageFormat#PRIVATE
 * PRIVATE} format images. The application can check if an existing reader's
 * format by calling {@link #getImageFormat()}.
 * </p>
 * <p>
 * {@link ImageFormat#PRIVATE PRIVATE} format {@link ImageReader
 * ImageReaders} are more efficient to use when application access to image
 * data is not necessary, compared to ImageReaders using other format such
 * as {@link ImageFormat#YUV_420_888 YUV_420_888}.
 * </p>
 *
 * @param width The default width in pixels of the Images that this reader
 *            will produce.
 * @param height The default height in pixels of the Images that this reader
 *            will produce.
 * @param format The format of the Image that this reader will produce. This
 *            must be one of the {@link android.graphics.ImageFormat} or
 *            {@link android.graphics.PixelFormat} constants. Note that not
 *            all formats are supported, like ImageFormat.NV21.
 * @param maxImages The maximum number of images the user will want to
 *            access simultaneously. This should be as small as possible to
 *            limit memory use. Once maxImages Images are obtained by the
 *            user, one of them has to be released before a new Image will
 *            become available for access through
 *            {@link #acquireLatestImage()} or {@link #acquireNextImage()}.
 *            Must be greater than 0.
 * @see Image
 */

public static android.media.ImageReader newInstance(int width, int height, int format, int maxImages) { throw new RuntimeException("Stub!"); }

/**
 * The default width of {@link Image Images}, in pixels.
 *
 * <p>The width may be overridden by the producer sending buffers to this
 * ImageReader's Surface. If so, the actual width of the images can be
 * found using {@link Image#getWidth}.</p>
 *
 * @return the expected width of an Image
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * The default height of {@link Image Images}, in pixels.
 *
 * <p>The height may be overridden by the producer sending buffers to this
 * ImageReader's Surface. If so, the actual height of the images can be
 * found using {@link Image#getHeight}.</p>
 *
 * @return the expected height of an Image
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * The default {@link ImageFormat image format} of {@link Image Images}.
 *
 * <p>Some color formats may be overridden by the producer sending buffers to
 * this ImageReader's Surface if the default color format allows. ImageReader
 * guarantees that all {@link Image Images} acquired from ImageReader
 * (for example, with {@link #acquireNextImage}) will have a "compatible"
 * format to what was specified in {@link #newInstance}.
 * As of now, each format is only compatible to itself.
 * The actual format of the images can be found using {@link Image#getFormat}.</p>
 *
 * @return the expected format of an Image
 *
 * @see ImageFormat
 */

public int getImageFormat() { throw new RuntimeException("Stub!"); }

/**
 * Maximum number of images that can be acquired from the ImageReader by any time (for example,
 * with {@link #acquireNextImage}).
 *
 * <p>An image is considered acquired after it's returned by a function from ImageReader, and
 * until the Image is {@link Image#close closed} to release the image back to the ImageReader.
 * </p>
 *
 * <p>Attempting to acquire more than {@code maxImages} concurrently will result in the
 * acquire function throwing a {@link IllegalStateException}. Furthermore,
 * while the max number of images have been acquired by the ImageReader user, the producer
 * enqueueing additional images may stall until at least one image has been released. </p>
 *
 * @return Maximum number of images for this ImageReader.
 *
 * @see Image#close
 */

public int getMaxImages() { throw new RuntimeException("Stub!"); }

/**
 * <p>Get a {@link Surface} that can be used to produce {@link Image Images} for this
 * {@code ImageReader}.</p>
 *
 * <p>Until valid image data is rendered into this {@link Surface}, the
 * {@link #acquireNextImage} method will return {@code null}. Only one source
 * can be producing data into this Surface at the same time, although the
 * same {@link Surface} can be reused with a different API once the first source is
 * disconnected from the {@link Surface}.</p>
 *
 * <p>Please note that holding on to the Surface object returned by this method is not enough
 * to keep its parent ImageReader from being reclaimed. In that sense, a Surface acts like a
 * {@link java.lang.ref.WeakReference weak reference} to the ImageReader that provides it.</p>
 *
 * @return A {@link Surface} to use for a drawing target for various APIs.
 */

public android.view.Surface getSurface() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Acquire the latest {@link Image} from the ImageReader's queue, dropping older
 * {@link Image images}. Returns {@code null} if no new image is available.
 * </p>
 * <p>
 * This operation will acquire all the images possible from the ImageReader,
 * but {@link #close} all images that aren't the latest. This function is
 * recommended to use over {@link #acquireNextImage} for most use-cases, as it's
 * more suited for real-time processing.
 * </p>
 * <p>
 * Note that {@link #getMaxImages maxImages} should be at least 2 for
 * {@link #acquireLatestImage} to be any different than {@link #acquireNextImage} -
 * discarding all-but-the-newest {@link Image} requires temporarily acquiring two
 * {@link Image Images} at once. Or more generally, calling {@link #acquireLatestImage}
 * with less than two images of margin, that is
 * {@code (maxImages - currentAcquiredImages < 2)} will not discard as expected.
 * </p>
 * <p>
 * This operation will fail by throwing an {@link IllegalStateException} if
 * {@code maxImages} have been acquired with {@link #acquireLatestImage} or
 * {@link #acquireNextImage}. In particular a sequence of {@link #acquireLatestImage}
 * calls greater than {@link #getMaxImages} without calling {@link Image#close} in-between
 * will exhaust the underlying queue. At such a time, {@link IllegalStateException}
 * will be thrown until more images are
 * released with {@link Image#close}.
 * </p>
 *
 * @return latest frame of image data, or {@code null} if no image data is available.
 * @throws IllegalStateException if too many images are currently acquired
 */

public android.media.Image acquireLatestImage() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Acquire the next Image from the ImageReader's queue. Returns {@code null} if
 * no new image is available.
 * </p>
 *
 * <p><i>Warning:</i> Consider using {@link #acquireLatestImage()} instead, as it will
 * automatically release older images, and allow slower-running processing routines to catch
 * up to the newest frame. Usage of {@link #acquireNextImage} is recommended for
 * batch/background processing. Incorrectly using this function can cause images to appear
 * with an ever-increasing delay, followed by a complete stall where no new images seem to
 * appear.
 * </p>
 *
 * <p>
 * This operation will fail by throwing an {@link IllegalStateException} if
 * {@code maxImages} have been acquired with {@link #acquireNextImage} or
 * {@link #acquireLatestImage}. In particular a sequence of {@link #acquireNextImage} or
 * {@link #acquireLatestImage} calls greater than {@link #getMaxImages maxImages} without
 * calling {@link Image#close} in-between will exhaust the underlying queue. At such a time,
 * {@link IllegalStateException} will be thrown until more images are released with
 * {@link Image#close}.
 * </p>
 *
 * @return a new frame of image data, or {@code null} if no image data is available.
 * @throws IllegalStateException if {@code maxImages} images are currently acquired
 * @see #acquireLatestImage
 */

public android.media.Image acquireNextImage() { throw new RuntimeException("Stub!"); }

/**
 * Register a listener to be invoked when a new image becomes available
 * from the ImageReader.
 *
 * @param listener
 *            The listener that will be run.
 * @param handler
 *            The handler on which the listener should be invoked, or null
 *            if the listener should be invoked on the calling thread's looper.
 * @throws IllegalArgumentException
 *            If no handler specified and the calling thread has no looper.
 */

public void setOnImageAvailableListener(android.media.ImageReader.OnImageAvailableListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Free up all the resources associated with this ImageReader.
 *
 * <p>
 * After calling this method, this ImageReader can not be used. Calling
 * any methods on this ImageReader and Images previously provided by
 * {@link #acquireNextImage} or {@link #acquireLatestImage}
 * will result in an {@link IllegalStateException}, and attempting to read from
 * {@link ByteBuffer ByteBuffers} returned by an earlier
 * {@link Image.Plane#getBuffer Plane#getBuffer} call will
 * have undefined behavior.
 * </p>
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Discard any free buffers owned by this ImageReader.
 *
 * <p>
 * Generally, the ImageReader caches buffers for reuse once they have been
 * allocated, for best performance. However, sometimes it may be important to
 * release all the cached, unused buffers to save on memory.
 * </p>
 * <p>
 * Calling this method will discard all free cached buffers. This does not include any buffers
 * associated with Images acquired from the ImageReader, any filled buffers waiting to be
 * acquired, and any buffers currently in use by the source rendering buffers into the
 * ImageReader's Surface.
 * <p>
 * The ImageReader continues to be usable after this call, but may need to reallocate buffers
 * when more buffers are needed for rendering.
 * </p>
 */

public void discardFreeBuffers() { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
/**
 * Callback interface for being notified that a new image is available.
 *
 * <p>
 * The onImageAvailable is called per image basis, that is, callback fires for every new frame
 * available from ImageReader.
 * </p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnImageAvailableListener {

/**
 * Callback that is called when a new image is available from ImageReader.
 *
 * @param reader the ImageReader the callback is associated with.
 * @see ImageReader
 * @see Image
 */

public void onImageAvailable(android.media.ImageReader reader);
}

}

