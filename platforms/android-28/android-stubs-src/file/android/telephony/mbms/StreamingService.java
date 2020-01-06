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


package android.telephony.mbms;

import android.telephony.MbmsStreamingSession;
import android.net.Uri;

/**
 * Class used to represent a single MBMS stream. After a stream has been started with
 * {@link MbmsStreamingSession#startStreaming(StreamingServiceInfo, java.util.concurrent.Executor,
 * StreamingServiceCallback)},
 * this class is used to hold information about the stream and control it.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StreamingService implements java.lang.AutoCloseable {

StreamingService() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the Uri used to play this stream.
 *
 * May throw an {@link IllegalArgumentException} or an {@link IllegalStateException}.
 *
 * @return The {@link Uri} to pass to the streaming client, or {@code null} if an error
 *         occurred.
 */

@androidx.annotation.RecentlyNullable public android.net.Uri getPlaybackUri() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link StreamingServiceInfo} corresponding to this stream.
 */

public android.telephony.mbms.StreamingServiceInfo getInfo() { throw new RuntimeException("Stub!"); }

/**
 * Stop streaming this service. Further operations on this object will fail with an
 * {@link IllegalStateException}.
 *
 * May throw an {@link IllegalArgumentException} or an {@link IllegalStateException}
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * The method of transmission currently used for a stream,
 * reported via {@link StreamingServiceCallback#onStreamMethodUpdated}
 */

public static final int BROADCAST_METHOD = 1; // 0x1

/**
 * State changed due to a call to {@link #close()} or
 * {@link MbmsStreamingSession#startStreaming(StreamingServiceInfo,
 * java.util.concurrent.Executor, StreamingServiceCallback)}
 */

public static final int REASON_BY_USER_REQUEST = 1; // 0x1

/**
 * State changed due to the streaming session ending at the carrier.
 */

public static final int REASON_END_OF_SESSION = 2; // 0x2

/**
 * State changed due to a frequency conflict with another requested stream.
 */

public static final int REASON_FREQUENCY_CONFLICT = 3; // 0x3

/**
 * State changed due to the device leaving the where this stream is being broadcast.
 */

public static final int REASON_LEFT_MBMS_BROADCAST_AREA = 6; // 0x6

/**
 * Indicates that the middleware does not have a reason to provide for the state change.
 */

public static final int REASON_NONE = 0; // 0x0

/**
 * State changed due to the device leaving the home carrier's LTE network.
 */

public static final int REASON_NOT_CONNECTED_TO_HOMECARRIER_LTE = 5; // 0x5

/**
 * State changed due to the middleware running out of memory
 */

public static final int REASON_OUT_OF_MEMORY = 4; // 0x4

public static final int STATE_STALLED = 3; // 0x3

public static final int STATE_STARTED = 2; // 0x2

public static final int STATE_STOPPED = 1; // 0x1

public static final int UNICAST_METHOD = 2; // 0x2
}

