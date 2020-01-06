/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.net.wifi.rtt;

import java.util.concurrent.Executor;
import java.util.List;
import android.content.Context;
import android.os.WorkSource;

/**
 * This class provides the primary API for measuring distance (range) to other devices using the
 * IEEE 802.11mc Wi-Fi Round Trip Time (RTT) technology.
 * <p>
 * The devices which can be ranged include:
 * <li>Access Points (APs)
 * <li>Wi-Fi Aware peers
 * <p>
 * Ranging requests are triggered using
 * {@link #startRanging(RangingRequest, Executor, RangingResultCallback)}. Results (in case of
 * successful operation) are returned in the {@link RangingResultCallback#onRangingResults(List)}
 * callback.
 * <p>
 *     Wi-Fi RTT may not be usable at some points, e.g. when Wi-Fi is disabled. To validate that
 *     the functionality is available use the {@link #isAvailable()} function. To track
 *     changes in RTT usability register for the {@link #ACTION_WIFI_RTT_STATE_CHANGED}
 *     broadcast. Note that this broadcast is not sticky - you should register for it and then
 *     check the above API to avoid a race condition.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiRttManager {

WifiRttManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current status of RTT API: whether or not RTT is available. To track
 * changes in the state of RTT API register for the
 * {@link #ACTION_WIFI_RTT_STATE_CHANGED} broadcast.
 * <p>Note: availability of RTT does not mean that the app can use the API. The app's
 * permissions and platform Location Mode are validated at run-time.
 *
 * @return A boolean indicating whether the app can use the RTT API at this time (true) or
 * not (false).
 */

public boolean isAvailable() { throw new RuntimeException("Stub!"); }

/**
 * Initiate a request to range to a set of devices specified in the {@link RangingRequest}.
 * Results will be returned in the {@link RangingResultCallback} set of callbacks.
 *
 * Requires {@link android.Manifest.permission#ACCESS_FINE_LOCATION} and {@link android.Manifest.permission#CHANGE_WIFI_STATE} and {@link android.Manifest.permission#ACCESS_WIFI_STATE}
 * @param request  A request specifying a set of devices whose distance measurements are
 *                 requested.
 * This value must never be {@code null}.
 * @param executor The Executor on which to run the callback.
 * This value must never be {@code null}.
 * Callback and listener events are dispatched through this
 *  *           {@link Executor}, providing an easy way to control which thread is
 *  *           used. To dispatch events through the main thread of your
 *  *           application, you can use {@link Context#getMainExecutor()}. To
 *  *           dispatch events through a shared thread pool, you can use
 *  *           {@link AsyncTask#THREAD_POOL_EXECUTOR}.
 * @param callback A callback for the result of the ranging request.

 * This value must never be {@code null}.
 */

public void startRanging(@androidx.annotation.RecentlyNonNull android.net.wifi.rtt.RangingRequest request, @androidx.annotation.RecentlyNonNull java.util.concurrent.Executor executor, @androidx.annotation.RecentlyNonNull android.net.wifi.rtt.RangingResultCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast intent action to indicate that the state of Wi-Fi RTT availability has changed.
 * Use the {@link #isAvailable()} to query the current status.
 * This broadcast is <b>not</b> sticky, use the {@link #isAvailable()} API after registering
 * the broadcast to check the current state of Wi-Fi RTT.
 * <p>Note: The broadcast is only delivered to registered receivers - no manifest registered
 * components will be launched.
 */

public static final java.lang.String ACTION_WIFI_RTT_STATE_CHANGED = "android.net.wifi.rtt.action.WIFI_RTT_STATE_CHANGED";
}

