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


package android.view;


/**
 * This is the base class for frame statistics.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class FrameStats {

public FrameStats() { throw new RuntimeException("Stub!"); }

/**
 * Gets the refresh period of the display hosting the window(s) for
 * which these statistics apply.
 *
 * @return The refresh period in nanoseconds.
 */

public final long getRefreshPeriodNano() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of frames for which there is data.
 *
 * @return The number of frames.
 */

public final int getFrameCount() { throw new RuntimeException("Stub!"); }

/**
 * Gets the start time of the interval for which these statistics
 * apply. The start interval is the time when the first frame was
 * presented.
 *
 * @return The start time in nanoseconds or {@link #UNDEFINED_TIME_NANO}
 *         if there is no frame data.
 */

public final long getStartTimeNano() { throw new RuntimeException("Stub!"); }

/**
 * Gets the end time of the interval for which these statistics
 * apply. The end interval is the time when the last frame was
 * presented.
 *
 * @return The end time in nanoseconds or {@link #UNDEFINED_TIME_NANO}
 *         if there is no frame data.
 */

public final long getEndTimeNano() { throw new RuntimeException("Stub!"); }

/**
 * Get the time a frame at a given index was presented.
 *
 * @param index The frame index.
 * @return The presented time in nanoseconds or {@link #UNDEFINED_TIME_NANO}
 *         if the frame is not presented yet.
 */

public final long getFramePresentedTimeNano(int index) { throw new RuntimeException("Stub!"); }

/**
 * Undefined time.
 */

public static final long UNDEFINED_TIME_NANO = -1L; // 0xffffffffffffffffL
}

