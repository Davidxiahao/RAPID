/*
 * Copyright 2015 The Android Open Source Project
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

import android.hardware.HardwareBuffer;
import android.graphics.ImageFormat;
import android.view.Surface;
import android.graphics.PixelFormat;
import java.util.List;
import java.nio.ByteBuffer;

/**
 * <p>
 * The ImageWriter class allows an application to produce Image data into a
 * {@link android.view.Surface}, and have it be consumed by another component
 * like {@link android.hardware.camera2.CameraDevice CameraDevice}.
 * </p>
 * <p>
 * Several Android API classes can provide input {@link android.view.Surface
 * Surface} objects for ImageWriter to produce data into, including
 * {@link MediaCodec MediaCodec} (encoder),
 * {@link android.hardware.camera2.CameraCaptureSession CameraCaptureSession}
 * (reprocessing input), {@link ImageReader}, etc.
 * </p>
 * <p>
 * The input Image data is encapsulated in {@link Image} objects. To produce
 * Image data into a destination {@link android.view.Surface Surface}, the
 * application can get an input Image via {@link #dequeueInputImage} then write
 * Image data into it. Multiple such {@link Image} objects can be dequeued at
 * the same time and queued back in any order, up to the number specified by the
 * {@code maxImages} constructor parameter.
 * </p>
 * <p>
 * If the application already has an Image from {@link ImageReader}, the
 * application can directly queue this Image into the ImageWriter (via
 * {@link #queueInputImage}), potentially with zero buffer copies. This
 * even works if the image format of the ImageWriter is
 * {@link ImageFormat#PRIVATE PRIVATE}, and prior to Android P is the only
 * way to enqueue images into such an ImageWriter. Starting in Android P
 * private images may also be accessed through their hardware buffers
 * (when available) through the {@link Image#getHardwareBuffer()} method.
 * Attempting to access the planes of a private image, will return an
 * empty array.
 * </p>
 * <p>
 * Once new input Images are queued into an ImageWriter, it's up to the
 * downstream components (e.g. {@link ImageReader} or
 * {@link android.hardware.camera2.CameraDevice}) to consume the Images. If the
 * downstream components cannot consume the Images at least as fast as the
 * ImageWriter production rate, the {@link #dequeueInputImage} call will
 * eventually block and the application will have to drop input frames.
 * </p>
 * <p>
 * If the consumer component that provided the input {@link android.view.Surface Surface}
 * abandons the {@link android.view.Surface Surface}, {@link #queueInputImage queueing}
 * or {@link #dequeueInputImage dequeueing} an {@link Image} will throw an
 * {@link IllegalStateException}.
 * </p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ImageWriter implements java.lang.AutoCloseable {

/**
 * @hide
 */

ImageWriter(android.view.Surface surface, int maxImages, int format) { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Create a new ImageWriter.
 * </p>
 * <p>
 * The {@code maxImages} parameter determines the maximum number of
 * {@link Image} objects that can be be dequeued from the
 * {@code ImageWriter} simultaneously. Requesting more buffers will use up
 * more memory, so it is important to use only the minimum number necessary.
 * </p>
 * <p>
 * The input Image size and format depend on the Surface that is provided by
 * the downstream consumer end-point.
 * </p>
 *
 * @param surface The destination Surface this writer produces Image data
 *            into.
 * @param maxImages The maximum number of Images the user will want to
 *            access simultaneously for producing Image data. This should be
 *            as small as possible to limit memory use. Once maxImages
 *            Images are dequeued by the user, one of them has to be queued
 *            back before a new Image can be dequeued for access via
 *            {@link #dequeueInputImage()}.
 * @return a new ImageWriter instance.
 */

public static android.media.ImageWriter newInstance(android.view.Surface surface, int maxImages) { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Maximum number of Images that can be dequeued from the ImageWriter
 * simultaneously (for example, with {@link #dequeueInputImage()}).
 * </p>
 * <p>
 * An Image is considered dequeued after it's returned by
 * {@link #dequeueInputImage()} from ImageWriter, and until the Image is
 * sent back to ImageWriter via {@link #queueInputImage}, or
 * {@link Image#close()}.
 * </p>
 * <p>
 * Attempting to dequeue more than {@code maxImages} concurrently will
 * result in the {@link #dequeueInputImage()} function throwing an
 * {@link IllegalStateException}.
 * </p>
 *
 * @return Maximum number of Images that can be dequeued from this
 *         ImageWriter.
 * @see #dequeueInputImage
 * @see #queueInputImage
 * @see Image#close
 */

public int getMaxImages() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Dequeue the next available input Image for the application to produce
 * data into.
 * </p>
 * <p>
 * This method requests a new input Image from ImageWriter. The application
 * owns this Image after this call. Once the application fills the Image
 * data, it is expected to return this Image back to ImageWriter for
 * downstream consumer components (e.g.
 * {@link android.hardware.camera2.CameraDevice}) to consume. The Image can
 * be returned to ImageWriter via {@link #queueInputImage} or
 * {@link Image#close()}.
 * </p>
 * <p>
 * This call will block if all available input images have been queued by
 * the application and the downstream consumer has not yet consumed any.
 * When an Image is consumed by the downstream consumer and released, an
 * {@link OnImageReleasedListener#onImageReleased} callback will be fired,
 * which indicates that there is one input Image available. For non-
 * {@link ImageFormat#PRIVATE PRIVATE} formats (
 * {@link ImageWriter#getFormat()} != {@link ImageFormat#PRIVATE}), it is
 * recommended to dequeue the next Image only after this callback is fired,
 * in the steady state.
 * </p>
 * <p>
 * If the format of ImageWriter is {@link ImageFormat#PRIVATE PRIVATE} (
 * {@link ImageWriter#getFormat()} == {@link ImageFormat#PRIVATE}), the
 * image buffer is accessible to the application only through the hardware
 * buffer obtained through {@link Image#getHardwareBuffer()}. (On Android
 * versions prior to P, dequeueing private buffers will cause an
 * {@link IllegalStateException} to be thrown). Alternatively,
 * the application can acquire images from some other component (e.g. an
 * {@link ImageReader}), and queue them directly to this ImageWriter via the
 * {@link ImageWriter#queueInputImage queueInputImage()} method.
 * </p>
 *
 * @return The next available input Image from this ImageWriter.
 * @throws IllegalStateException if {@code maxImages} Images are currently
 *             dequeued, or the input {@link android.view.Surface Surface}
 *             has been abandoned by the consumer component that provided
 *             the {@link android.view.Surface Surface}. Prior to Android
 *             P, throws if the ImageWriter format is
 *             {@link ImageFormat#PRIVATE PRIVATE}.
 * @see #queueInputImage
 * @see Image#close
 */

public android.media.Image dequeueInputImage() { throw new RuntimeException("Stub!"); }

/**
 * <p>
 * Queue an input {@link Image} back to ImageWriter for the downstream
 * consumer to access.
 * </p>
 * <p>
 * The input {@link Image} could be from ImageReader (acquired via
 * {@link ImageReader#acquireNextImage} or
 * {@link ImageReader#acquireLatestImage}), or from this ImageWriter
 * (acquired via {@link #dequeueInputImage}). In the former case, the Image
 * data will be moved to this ImageWriter. Note that the Image properties
 * (size, format, strides, etc.) must be the same as the properties of the
 * images dequeued from this ImageWriter, or this method will throw an
 * {@link IllegalArgumentException}. In the latter case, the application has
 * filled the input image with data. This method then passes the filled
 * buffer to the downstream consumer. In both cases, it's up to the caller
 * to ensure that the Image timestamp (in nanoseconds) is correctly set, as
 * the downstream component may want to use it to indicate the Image data
 * capture time.
 * </p>
 * <p>
 * After this method is called and the downstream consumer consumes and
 * releases the Image, an {@link OnImageReleasedListener#onImageReleased}
 * callback will fire. The application can use this callback to avoid
 * sending Images faster than the downstream consumer processing rate in
 * steady state.
 * </p>
 * <p>
 * Passing in an Image from some other component (e.g. an
 * {@link ImageReader}) requires a free input Image from this ImageWriter as
 * the destination. In this case, this call will block, as
 * {@link #dequeueInputImage} does, if there are no free Images available.
 * To avoid blocking, the application should ensure that there is at least
 * one free Image available in this ImageWriter before calling this method.
 * </p>
 * <p>
 * After this call, the input Image is no longer valid for further access,
 * as if the Image is {@link Image#close closed}. Attempting to access the
 * {@link ByteBuffer ByteBuffers} returned by an earlier
 * {@link Image.Plane#getBuffer Plane#getBuffer} call will result in an
 * {@link IllegalStateException}.
 * </p>
 *
 * @param image The Image to be queued back to ImageWriter for future
 *            consumption.
 * @throws IllegalStateException if the image was already queued previously,
 *            or the image was aborted previously, or the input
 *            {@link android.view.Surface Surface} has been abandoned by the
 *            consumer component that provided the
 *            {@link android.view.Surface Surface}.
 * @see #dequeueInputImage()
 */

public void queueInputImage(android.media.Image image) { throw new RuntimeException("Stub!"); }

/**
 * Get the ImageWriter format.
 * <p>
 * This format may be different than the Image format returned by
 * {@link Image#getFormat()}. However, if the ImageWriter format is
 * {@link ImageFormat#PRIVATE PRIVATE}, calling {@link #dequeueInputImage()}
 * will result in an {@link IllegalStateException}.
 * </p>
 *
 * @return The ImageWriter format.
 */

public int getFormat() { throw new RuntimeException("Stub!"); }

/**
 * Register a listener to be invoked when an input Image is returned to the
 * ImageWriter.
 *
 * @param listener The listener that will be run.
 * @param handler The handler on which the listener should be invoked, or
 *            null if the listener should be invoked on the calling thread's
 *            looper.
 * @throws IllegalArgumentException If no handler specified and the calling
 *             thread has no looper.
 */

public void setOnImageReleasedListener(android.media.ImageWriter.OnImageReleasedListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Free up all the resources associated with this ImageWriter.
 * <p>
 * After calling this method, this ImageWriter cannot be used. Calling any
 * methods on this ImageWriter and Images previously provided by
 * {@link #dequeueInputImage()} will result in an
 * {@link IllegalStateException}, and attempting to write into
 * {@link ByteBuffer ByteBuffers} returned by an earlier
 * {@link Image.Plane#getBuffer Plane#getBuffer} call will have undefined
 * behavior.
 * </p>
 */

public void close() { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
/**
 * ImageWriter callback interface, used to to asynchronously notify the
 * application of various ImageWriter events.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnImageReleasedListener {

/**
 * <p>
 * Callback that is called when an input Image is released back to
 * ImageWriter after the data consumption.
 * </p>
 * <p>
 * The client can use this callback to be notified that an input Image
 * has been consumed and released by the downstream consumer. More
 * specifically, this callback will be fired for below cases:
 * <li>The application dequeues an input Image via the
 * {@link ImageWriter#dequeueInputImage dequeueInputImage()} method,
 * uses it, and then queues it back to this ImageWriter via the
 * {@link ImageWriter#queueInputImage queueInputImage()} method. After
 * the downstream consumer uses and releases this image to this
 * ImageWriter, this callback will be fired. This image will be
 * available to be dequeued after this callback.</li>
 * <li>The application obtains an Image from some other component (e.g.
 * an {@link ImageReader}), uses it, and then queues it to this
 * ImageWriter via {@link ImageWriter#queueInputImage queueInputImage()}.
 * After the downstream consumer uses and releases this image to this
 * ImageWriter, this callback will be fired.</li>
 * </p>
 *
 * @param writer the ImageWriter the callback is associated with.
 * @see ImageWriter
 * @see Image
 */

public void onImageReleased(android.media.ImageWriter writer);
}

}

