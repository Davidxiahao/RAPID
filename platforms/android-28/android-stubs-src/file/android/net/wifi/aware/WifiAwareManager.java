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


package android.net.wifi.aware;

import android.os.Message;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Build;
import android.net.NetworkSpecifier;
import java.util.List;

/**
 * This class provides the primary API for managing Wi-Fi Aware operations:
 * discovery and peer-to-peer data connections.
 * <p>
 * The class provides access to:
 * <ul>
 * <li>Initialize a Aware cluster (peer-to-peer synchronization). Refer to
 * {@link #attach(AttachCallback, Handler)}.
 * <li>Create discovery sessions (publish or subscribe sessions). Refer to
 * {@link WifiAwareSession#publish(PublishConfig, DiscoverySessionCallback, Handler)} and
 * {@link WifiAwareSession#subscribe(SubscribeConfig, DiscoverySessionCallback, Handler)}.
 * <li>Create a Aware network specifier to be used with
 * {@link ConnectivityManager#requestNetwork(NetworkRequest, ConnectivityManager.NetworkCallback)}
 * to set-up a Aware connection with a peer. Refer to
 * {@link DiscoverySession#createNetworkSpecifierOpen(PeerHandle)},
 * {@link DiscoverySession#createNetworkSpecifierPassphrase(PeerHandle, String)},
 * {@link WifiAwareSession#createNetworkSpecifierOpen(int, byte[])}, and
 * {@link WifiAwareSession#createNetworkSpecifierPassphrase(int, byte[], String)}.
 * </ul>
 * <p>
 *     Aware may not be usable when Wi-Fi is disabled (and other conditions). To validate that
 *     the functionality is available use the {@link #isAvailable()} function. To track
 *     changes in Aware usability register for the {@link #ACTION_WIFI_AWARE_STATE_CHANGED}
 *     broadcast. Note that this broadcast is not sticky - you should register for it and then
 *     check the above API to avoid a race condition.
 * <p>
 *     An application must use {@link #attach(AttachCallback, Handler)} to initialize a
 *     Aware cluster - before making any other Aware operation. Aware cluster membership is a
 *     device-wide operation - the API guarantees that the device is in a cluster or joins a
 *     Aware cluster (or starts one if none can be found). Information about attach success (or
 *     failure) are returned in callbacks of {@link AttachCallback}. Proceed with Aware
 *     discovery or connection setup only after receiving confirmation that Aware attach
 *     succeeded - {@link AttachCallback#onAttached(WifiAwareSession)}. When an
 *     application is finished using Aware it <b>must</b> use the
 *     {@link WifiAwareSession#close()} API to indicate to the Aware service that the device
 *     may detach from the Aware cluster. The device will actually disable Aware once the last
 *     application detaches.
 * <p>
 *     Once a Aware attach is confirmed use the
 *     {@link WifiAwareSession#publish(PublishConfig, DiscoverySessionCallback, Handler)}
 *     or
 *     {@link WifiAwareSession#subscribe(SubscribeConfig, DiscoverySessionCallback,
 *     Handler)} to create publish or subscribe Aware discovery sessions. Events are called on the
 *     provided callback object {@link DiscoverySessionCallback}. Specifically, the
 *     {@link DiscoverySessionCallback#onPublishStarted(PublishDiscoverySession)}
 *     and
 *     {@link DiscoverySessionCallback#onSubscribeStarted(
 *SubscribeDiscoverySession)}
 *     return {@link PublishDiscoverySession} and
 *     {@link SubscribeDiscoverySession}
 *     objects respectively on which additional session operations can be performed, e.g. updating
 *     the session {@link PublishDiscoverySession#updatePublish(PublishConfig)} and
 *     {@link SubscribeDiscoverySession#updateSubscribe(SubscribeConfig)}. Sessions can
 *     also be used to send messages using the
 *     {@link DiscoverySession#sendMessage(PeerHandle, int, byte[])} APIs. When an
 *     application is finished with a discovery session it <b>must</b> terminate it using the
 *     {@link DiscoverySession#close()} API.
 * <p>
 *    Creating connections between Aware devices is managed by the standard
 *    {@link ConnectivityManager#requestNetwork(NetworkRequest,
 *    ConnectivityManager.NetworkCallback)}.
 *    The {@link NetworkRequest} object should be constructed with:
 *    <ul>
 *        <li>{@link NetworkRequest.Builder#addTransportType(int)} of
 *        {@link android.net.NetworkCapabilities#TRANSPORT_WIFI_AWARE}.
 *        <li>{@link NetworkRequest.Builder#setNetworkSpecifier(String)} using
 *        {@link WifiAwareSession#createNetworkSpecifierOpen(int, byte[])},
 *        {@link WifiAwareSession#createNetworkSpecifierPassphrase(int, byte[], String)},
 *        {@link DiscoverySession#createNetworkSpecifierOpen(PeerHandle)}, or
 *        {@link DiscoverySession#createNetworkSpecifierPassphrase(PeerHandle, String)}.
 *    </ul>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WifiAwareManager {

WifiAwareManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current status of Aware API: whether or not Aware is available. To track
 * changes in the state of Aware API register for the
 * {@link #ACTION_WIFI_AWARE_STATE_CHANGED} broadcast.
 *
 * @return A boolean indicating whether the app can use the Aware API at this time (true) or
 * not (false).
 */

public boolean isAvailable() { throw new RuntimeException("Stub!"); }

/**
 * Returns the characteristics of the Wi-Fi Aware interface: a set of parameters which specify
 * limitations on configurations, e.g.&nbsp;the maximum service name length.
 *
 * @return An object specifying configuration limitations of Aware.
 */

public android.net.wifi.aware.Characteristics getCharacteristics() { throw new RuntimeException("Stub!"); }

/**
 * Attach to the Wi-Fi Aware service - enabling the application to create discovery sessions or
 * create connections to peers. The device will attach to an existing cluster if it can find
 * one or create a new cluster (if it is the first to enable Aware in its vicinity). Results
 * (e.g. successful attach to a cluster) are provided to the {@code attachCallback} object.
 * An application <b>must</b> call {@link WifiAwareSession#close()} when done with the
 * Wi-Fi Aware object.
 * <p>
 * Note: a Aware cluster is a shared resource - if the device is already attached to a cluster
 * then this function will simply indicate success immediately using the same {@code
 * attachCallback}.
 *
 * @param attachCallback A callback for attach events, extended from
 * {@link AttachCallback}.
 * This value must never be {@code null}.
 * @param handler The Handler on whose thread to execute the callbacks of the {@code
 * attachCallback} object. If a null is provided then the application's main thread will be
 *                used.

 * This value may be {@code null}.
 */

public void attach(@androidx.annotation.RecentlyNonNull android.net.wifi.aware.AttachCallback attachCallback, @androidx.annotation.RecentlyNullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Attach to the Wi-Fi Aware service - enabling the application to create discovery sessions or
 * create connections to peers. The device will attach to an existing cluster if it can find
 * one or create a new cluster (if it is the first to enable Aware in its vicinity). Results
 * (e.g. successful attach to a cluster) are provided to the {@code attachCallback} object.
 * An application <b>must</b> call {@link WifiAwareSession#close()} when done with the
 * Wi-Fi Aware object.
 * <p>
 * Note: a Aware cluster is a shared resource - if the device is already attached to a cluster
 * then this function will simply indicate success immediately using the same {@code
 * attachCallback}.
 * <p>
 * This version of the API attaches a listener to receive the MAC address of the Aware interface
 * on startup and whenever it is updated (it is randomized at regular intervals for privacy).
 * The application must have the {@link android.Manifest.permission#ACCESS_COARSE_LOCATION}
 * permission to execute this attach request. Otherwise, use the
 * {@link #attach(AttachCallback, Handler)} version. Note that aside from permission
 * requirements this listener will wake up the host at regular intervals causing higher power
 * consumption, do not use it unless the information is necessary (e.g. for OOB discovery).
 *
 * @param attachCallback A callback for attach events, extended from
 * {@link AttachCallback}.
 * This value must never be {@code null}.
 * @param identityChangedListener A listener for changed identity, extended from
 * {@link IdentityChangedListener}.
 * This value must never be {@code null}.
 * @param handler The Handler on whose thread to execute the callbacks of the {@code
 * attachCallback} and {@code identityChangedListener} objects. If a null is provided then the
 *                application's main thread will be used.

 * This value may be {@code null}.
 */

public void attach(@androidx.annotation.RecentlyNonNull android.net.wifi.aware.AttachCallback attachCallback, @androidx.annotation.RecentlyNonNull android.net.wifi.aware.IdentityChangedListener identityChangedListener, @androidx.annotation.RecentlyNullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Broadcast intent action to indicate that the state of Wi-Fi Aware availability has changed.
 * Use the {@link #isAvailable()} to query the current status.
 * This broadcast is <b>not</b> sticky, use the {@link #isAvailable()} API after registering
 * the broadcast to check the current state of Wi-Fi Aware.
 * <p>Note: The broadcast is only delivered to registered receivers - no manifest registered
 * components will be launched.
 */

public static final java.lang.String ACTION_WIFI_AWARE_STATE_CHANGED = "android.net.wifi.aware.action.WIFI_AWARE_STATE_CHANGED";

/**
 * Connection creation role is that of INITIATOR. Used to create a network specifier string
 * when requesting a Aware network.
 *
 * @see DiscoverySession#createNetworkSpecifierOpen(PeerHandle)
 * @see DiscoverySession#createNetworkSpecifierPassphrase(PeerHandle, String)
 * @see WifiAwareSession#createNetworkSpecifierOpen(int, byte[])
 * @see WifiAwareSession#createNetworkSpecifierPassphrase(int, byte[], String)
 */

public static final int WIFI_AWARE_DATA_PATH_ROLE_INITIATOR = 0; // 0x0

/**
 * Connection creation role is that of RESPONDER. Used to create a network specifier string
 * when requesting a Aware network.
 *
 * @see DiscoverySession#createNetworkSpecifierOpen(PeerHandle)
 * @see DiscoverySession#createNetworkSpecifierPassphrase(PeerHandle, String)
 * @see WifiAwareSession#createNetworkSpecifierOpen(int, byte[])
 * @see WifiAwareSession#createNetworkSpecifierPassphrase(int, byte[], String)
 */

public static final int WIFI_AWARE_DATA_PATH_ROLE_RESPONDER = 1; // 0x1
}

