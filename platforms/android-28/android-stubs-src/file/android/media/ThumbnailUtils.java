/*
 * Copyright (C) 2009 The Android Open Source Project
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

import android.graphics.Bitmap;
import android.net.Uri;
import android.content.ContentResolver;
import android.graphics.BitmapFactory;

/**
 * Thumbnail generation routines for media provider.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ThumbnailUtils {

public ThumbnailUtils() { throw new RuntimeException("Stub!"); }

/**
 * Create a video thumbnail for a video. May return null if the video is
 * corrupt or the format is not supported.
 *
 * @param filePath the path of video file
 * @param kind could be MINI_KIND or MICRO_KIND
 */

public static android.graphics.Bitmap createVideoThumbnail(java.lang.String filePath, int kind) { throw new RuntimeException("Stub!"); }

/**
 * Creates a centered bitmap of the desired size.
 *
 * @param source original bitmap source
 * @param width targeted width
 * @param height targeted height
 */

public static android.graphics.Bitmap extractThumbnail(android.graphics.Bitmap source, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Creates a centered bitmap of the desired size.
 *
 * @param source original bitmap source
 * @param width targeted width
 * @param height targeted height
 * @param options options used during thumbnail extraction
 */

public static android.graphics.Bitmap extractThumbnail(android.graphics.Bitmap source, int width, int height, int options) { throw new RuntimeException("Stub!"); }

/**
 * Constant used to indicate we should recycle the input in
 * {@link #extractThumbnail(Bitmap, int, int, int)} unless the output is the input.
 */

public static final int OPTIONS_RECYCLE_INPUT = 2; // 0x2
}

