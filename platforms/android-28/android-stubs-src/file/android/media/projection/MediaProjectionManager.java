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


package android.media.projection;

import android.app.Activity;
import android.content.Intent;

/**
 * Manages the retrieval of certain types of {@link MediaProjection} tokens.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaProjectionManager {

/** @hide */

MediaProjectionManager(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Returns an Intent that <b>must</b> passed to startActivityForResult()
 * in order to start screen capture. The activity will prompt
 * the user whether to allow screen capture.  The result of this
 * activity should be passed to getMediaProjection.
 */

public android.content.Intent createScreenCaptureIntent() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the MediaProjection obtained from a succesful screen
 * capture request. Will be null if the result from the
 * startActivityForResult() is anything other than RESULT_OK.
 *
 * @param resultCode The result code from {@link android.app.Activity#onActivityResult(int,
 * int, android.content.Intent)}
 * @param resultData The resulting data from {@link android.app.Activity#onActivityResult(int,
 * int, android.content.Intent)}

 * This value must never be {@code null}.
 */

public android.media.projection.MediaProjection getMediaProjection(int resultCode, @androidx.annotation.RecentlyNonNull android.content.Intent resultData) { throw new RuntimeException("Stub!"); }
}

