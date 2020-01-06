/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.view;

import android.graphics.Bitmap;
import android.os.Handler;
import android.graphics.Rect;
import android.view.ViewTreeObserver.OnDrawListener;

/**
 * Provides a mechanisms to issue pixel copy requests to allow for copy
 * operations from {@link Surface} to {@link Bitmap}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PixelCopy {

PixelCopy() { throw new RuntimeException("Stub!"); }

/**
 * Requests for the display content of a {@link SurfaceView} to be copied
 * into a provided {@link Bitmap}.
 *
 * The contents of the source will be scaled to fit exactly inside the bitmap.
 * The pixel format of the source buffer will be converted, as part of the copy,
 * to fit the the bitmap's {@link Bitmap.Config}. The most recently queued buffer
 * in the SurfaceView's Surface will be used as the source of the copy.
 *
 * @param source The source from which to copy
 * This value must never be {@code null}.
 * @param dest The destination of the copy. The source will be scaled to
 * match the width, height, and format of this bitmap.
 * This value must never be {@code null}.
 * @param listener Callback for when the pixel copy request completes
 * This value must never be {@code null}.
 * @param listenerThread The callback will be invoked on this Handler when
 * the copy is finished.

 * This value must never be {@code null}.
 */

public static void request(@androidx.annotation.RecentlyNonNull android.view.SurfaceView source, @androidx.annotation.RecentlyNonNull android.graphics.Bitmap dest, @androidx.annotation.RecentlyNonNull android.view.PixelCopy.OnPixelCopyFinishedListener listener, @androidx.annotation.RecentlyNonNull android.os.Handler listenerThread) { throw new RuntimeException("Stub!"); }

/**
 * Requests for the display content of a {@link SurfaceView} to be copied
 * into a provided {@link Bitmap}.
 *
 * The contents of the source will be scaled to fit exactly inside the bitmap.
 * The pixel format of the source buffer will be converted, as part of the copy,
 * to fit the the bitmap's {@link Bitmap.Config}. The most recently queued buffer
 * in the SurfaceView's Surface will be used as the source of the copy.
 *
 * @param source The source from which to copy
 * This value must never be {@code null}.
 * @param srcRect The area of the source to copy from. If this is null
 * the copy area will be the entire surface. The rect will be clamped to
 * the bounds of the Surface.
 * This value may be {@code null}.
 * @param dest The destination of the copy. The source will be scaled to
 * match the width, height, and format of this bitmap.
 * This value must never be {@code null}.
 * @param listener Callback for when the pixel copy request completes
 * This value must never be {@code null}.
 * @param listenerThread The callback will be invoked on this Handler when
 * the copy is finished.

 * This value must never be {@code null}.
 */

public static void request(@androidx.annotation.RecentlyNonNull android.view.SurfaceView source, @androidx.annotation.RecentlyNullable android.graphics.Rect srcRect, @androidx.annotation.RecentlyNonNull android.graphics.Bitmap dest, @androidx.annotation.RecentlyNonNull android.view.PixelCopy.OnPixelCopyFinishedListener listener, @androidx.annotation.RecentlyNonNull android.os.Handler listenerThread) { throw new RuntimeException("Stub!"); }

/**
 * Requests a copy of the pixels from a {@link Surface} to be copied into
 * a provided {@link Bitmap}.
 *
 * The contents of the source will be scaled to fit exactly inside the bitmap.
 * The pixel format of the source buffer will be converted, as part of the copy,
 * to fit the the bitmap's {@link Bitmap.Config}. The most recently queued buffer
 * in the Surface will be used as the source of the copy.
 *
 * @param source The source from which to copy
 * This value must never be {@code null}.
 * @param dest The destination of the copy. The source will be scaled to
 * match the width, height, and format of this bitmap.
 * This value must never be {@code null}.
 * @param listener Callback for when the pixel copy request completes
 * This value must never be {@code null}.
 * @param listenerThread The callback will be invoked on this Handler when
 * the copy is finished.

 * This value must never be {@code null}.
 */

public static void request(@androidx.annotation.RecentlyNonNull android.view.Surface source, @androidx.annotation.RecentlyNonNull android.graphics.Bitmap dest, @androidx.annotation.RecentlyNonNull android.view.PixelCopy.OnPixelCopyFinishedListener listener, @androidx.annotation.RecentlyNonNull android.os.Handler listenerThread) { throw new RuntimeException("Stub!"); }

/**
 * Requests a copy of the pixels at the provided {@link Rect} from
 * a {@link Surface} to be copied into a provided {@link Bitmap}.
 *
 * The contents of the source rect will be scaled to fit exactly inside the bitmap.
 * The pixel format of the source buffer will be converted, as part of the copy,
 * to fit the the bitmap's {@link Bitmap.Config}. The most recently queued buffer
 * in the Surface will be used as the source of the copy.
 *
 * @param source The source from which to copy
 * This value must never be {@code null}.
 * @param srcRect The area of the source to copy from. If this is null
 * the copy area will be the entire surface. The rect will be clamped to
 * the bounds of the Surface.
 * This value may be {@code null}.
 * @param dest The destination of the copy. The source will be scaled to
 * match the width, height, and format of this bitmap.
 * This value must never be {@code null}.
 * @param listener Callback for when the pixel copy request completes
 * This value must never be {@code null}.
 * @param listenerThread The callback will be invoked on this Handler when
 * the copy is finished.

 * This value must never be {@code null}.
 */

public static void request(@androidx.annotation.RecentlyNonNull android.view.Surface source, @androidx.annotation.RecentlyNullable android.graphics.Rect srcRect, @androidx.annotation.RecentlyNonNull android.graphics.Bitmap dest, @androidx.annotation.RecentlyNonNull android.view.PixelCopy.OnPixelCopyFinishedListener listener, @androidx.annotation.RecentlyNonNull android.os.Handler listenerThread) { throw new RuntimeException("Stub!"); }

/**
 * Requests a copy of the pixels from a {@link Window} to be copied into
 * a provided {@link Bitmap}.
 *
 * The contents of the source will be scaled to fit exactly inside the bitmap.
 * The pixel format of the source buffer will be converted, as part of the copy,
 * to fit the the bitmap's {@link Bitmap.Config}. The most recently queued buffer
 * in the Window's Surface will be used as the source of the copy.
 *
 * Note: This is limited to being able to copy from Window's with a non-null
 * DecorView. If {@link Window#peekDecorView()} is null this throws an
 * {@link IllegalArgumentException}. It will similarly throw an exception
 * if the DecorView has not yet acquired a backing surface. It is recommended
 * that {@link OnDrawListener} is used to ensure that at least one draw
 * has happened before trying to copy from the window, otherwise either
 * an {@link IllegalArgumentException} will be thrown or an error will
 * be returned to the {@link OnPixelCopyFinishedListener}.
 *
 * @param source The source from which to copy
 * This value must never be {@code null}.
 * @param dest The destination of the copy. The source will be scaled to
 * match the width, height, and format of this bitmap.
 * This value must never be {@code null}.
 * @param listener Callback for when the pixel copy request completes
 * This value must never be {@code null}.
 * @param listenerThread The callback will be invoked on this Handler when
 * the copy is finished.

 * This value must never be {@code null}.
 */

public static void request(@androidx.annotation.RecentlyNonNull android.view.Window source, @androidx.annotation.RecentlyNonNull android.graphics.Bitmap dest, @androidx.annotation.RecentlyNonNull android.view.PixelCopy.OnPixelCopyFinishedListener listener, @androidx.annotation.RecentlyNonNull android.os.Handler listenerThread) { throw new RuntimeException("Stub!"); }

/**
 * Requests a copy of the pixels at the provided {@link Rect} from
 * a {@link Window} to be copied into a provided {@link Bitmap}.
 *
 * The contents of the source rect will be scaled to fit exactly inside the bitmap.
 * The pixel format of the source buffer will be converted, as part of the copy,
 * to fit the the bitmap's {@link Bitmap.Config}. The most recently queued buffer
 * in the Window's Surface will be used as the source of the copy.
 *
 * Note: This is limited to being able to copy from Window's with a non-null
 * DecorView. If {@link Window#peekDecorView()} is null this throws an
 * {@link IllegalArgumentException}. It will similarly throw an exception
 * if the DecorView has not yet acquired a backing surface. It is recommended
 * that {@link OnDrawListener} is used to ensure that at least one draw
 * has happened before trying to copy from the window, otherwise either
 * an {@link IllegalArgumentException} will be thrown or an error will
 * be returned to the {@link OnPixelCopyFinishedListener}.
 *
 * @param source The source from which to copy
 * This value must never be {@code null}.
 * @param srcRect The area of the source to copy from. If this is null
 * the copy area will be the entire surface. The rect will be clamped to
 * the bounds of the Surface.
 * This value may be {@code null}.
 * @param dest The destination of the copy. The source will be scaled to
 * match the width, height, and format of this bitmap.
 * This value must never be {@code null}.
 * @param listener Callback for when the pixel copy request completes
 * This value must never be {@code null}.
 * @param listenerThread The callback will be invoked on this Handler when
 * the copy is finished.

 * This value must never be {@code null}.
 */

public static void request(@androidx.annotation.RecentlyNonNull android.view.Window source, @androidx.annotation.RecentlyNullable android.graphics.Rect srcRect, @androidx.annotation.RecentlyNonNull android.graphics.Bitmap dest, @androidx.annotation.RecentlyNonNull android.view.PixelCopy.OnPixelCopyFinishedListener listener, @androidx.annotation.RecentlyNonNull android.os.Handler listenerThread) { throw new RuntimeException("Stub!"); }

/**
 * The destination isn't a valid copy target. If the destination is a bitmap
 * this can occur if the bitmap is too large for the hardware to copy to.
 * It can also occur if the destination has been destroyed.
 */

public static final int ERROR_DESTINATION_INVALID = 5; // 0x5

/**
 * It is not possible to copy from the source. This can happen if the source
 * is hardware-protected or destroyed.
 */

public static final int ERROR_SOURCE_INVALID = 4; // 0x4

/**
 * The source has nothing to copy from. When the source is a {@link Surface}
 * this means that no buffers have been queued yet. Wait for the source
 * to produce a frame and try again.
 */

public static final int ERROR_SOURCE_NO_DATA = 3; // 0x3

/**
 * A timeout occurred while trying to acquire a buffer from the source to
 * copy from.
 */

public static final int ERROR_TIMEOUT = 2; // 0x2

/** The pixel copy request failed with an unknown error. */

public static final int ERROR_UNKNOWN = 1; // 0x1

/** The pixel copy request succeeded */

public static final int SUCCESS = 0; // 0x0
/**
 * Listener for observing the completion of a PixelCopy request.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnPixelCopyFinishedListener {

/**
 * Callback for when a pixel copy request has completed. This will be called
 * regardless of whether the copy succeeded or failed.
 *
 * @param copyResult Contains the resulting status of the copy request.
 * This will either be {@link PixelCopy#SUCCESS} or one of the
 * <code>PixelCopy.ERROR_*</code> values.

 * Value is {@link android.view.PixelCopy#SUCCESS}, {@link android.view.PixelCopy#ERROR_UNKNOWN}, {@link android.view.PixelCopy#ERROR_TIMEOUT}, {@link android.view.PixelCopy#ERROR_SOURCE_NO_DATA}, {@link android.view.PixelCopy#ERROR_SOURCE_INVALID}, or {@link android.view.PixelCopy#ERROR_DESTINATION_INVALID}
 */

public void onPixelCopyFinished(int copyResult);
}

}

