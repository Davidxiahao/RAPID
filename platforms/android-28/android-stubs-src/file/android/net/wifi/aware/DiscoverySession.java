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

import android.net.NetworkSpecifier;

/**
 * A class representing a single publish or subscribe Aware session. This object
 * will not be created directly - only its child classes are available:
 * {@link PublishDiscoverySession} and {@link SubscribeDiscoverySession}. This
 * class provides functionality common to both publish and subscribe discovery sessions:
 * <ul>
 *     <li>Sending messages: {@link #sendMessage(PeerHandle, int, byte[])} method.
 *     <li>Creating a network-specifier when requesting a Aware connection:
 *     {@link #createNetworkSpecifierOpen(PeerHandle)} or
 *     {@link #createNetworkSpecifierPassphrase(PeerHandle, String)}.
 * </ul>
 * The {@link #close()} method must be called to destroy discovery sessions once they are
 * no longer needed.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DiscoverySession implements java.lang.AutoCloseable {

/** @hide */

DiscoverySession(android.net.wifi.aware.WifiAwareManager manager, int clientId, int sessionId) { throw new RuntimeException("Stub!"); }

/**
 * Destroy the publish or subscribe session - free any resources, and stop
 * transmitting packets on-air (for an active session) or listening for
 * matches (for a passive session). The session may not be used for any
 * additional operations after its destruction.
 * <p>
 *     This operation must be done on a session which is no longer needed. Otherwise system
 *     resources will continue to be utilized until the application exits. The only
 *     exception is a session for which we received a termination callback,
 *     {@link DiscoverySessionCallback#onSessionTerminated()}.
 */

public void close() { throw new RuntimeException("Stub!"); }

/** @hide */

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Sends a message to the specified destination. Aware messages are transmitted in the context
 * of a discovery session - executed subsequent to a publish/subscribe
 * {@link DiscoverySessionCallback#onServiceDiscovered(PeerHandle,
 * byte[], java.util.List)} event.
 * <p>
 *     Aware messages are not guaranteed delivery. Callbacks on
 *     {@link DiscoverySessionCallback} indicate message was transmitted successfully,
 *     {@link DiscoverySessionCallback#onMessageSendSucceeded(int)}, or transmission
 *     failed (possibly after several retries) -
 *     {@link DiscoverySessionCallback#onMessageSendFailed(int)}.
 * <p>
 * The peer will get a callback indicating a message was received using
 * {@link DiscoverySessionCallback#onMessageReceived(PeerHandle,
 * byte[])}.
 *
 * @param peerHandle The peer's handle for the message. Must be a result of an
 * {@link DiscoverySessionCallback#onServiceDiscovered(PeerHandle,
 * byte[], java.util.List)} or
 * {@link DiscoverySessionCallback#onMessageReceived(PeerHandle,
 * byte[])} events.
 * This value must never be {@code null}.
 * @param messageId An arbitrary integer used by the caller to identify the message. The same
 *            integer ID will be returned in the callbacks indicating message send success or
 *            failure. The {@code messageId} is not used internally by the Aware service - it
 *                  can be arbitrary and non-unique.
 * @param message The message to be transmitted.

 * This value may be {@code null}.
 */

public void sendMessage(@androidx.annotation.RecentlyNonNull android.net.wifi.aware.PeerHandle peerHandle, int messageId, @androidx.annotation.RecentlyNullable byte[] message) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.net.NetworkRequest.Builder#setNetworkSpecifier(NetworkSpecifier)} for
 * an unencrypted WiFi Aware connection (link) to the specified peer. The
 * {@link android.net.NetworkRequest.Builder#addTransportType(int)} should be set to
 * {@link android.net.NetworkCapabilities#TRANSPORT_WIFI_AWARE}.
 * <p>
 * This method should be used when setting up a connection with a peer discovered through Aware
 * discovery or communication (in such scenarios the MAC address of the peer is shielded by
 * an opaque peer ID handle). If an Aware connection is needed to a peer discovered using other
 * OOB (out-of-band) mechanism then use the alternative
 * {@link WifiAwareSession#createNetworkSpecifierOpen(int, byte[])} method - which uses the
 * peer's MAC address.
 * <p>
 * Note: per the Wi-Fi Aware specification the roles are fixed - a Subscriber is an INITIATOR
 * and a Publisher is a RESPONDER.
 * <p>
 * To set up an encrypted link use the
 * {@link #createNetworkSpecifierPassphrase(PeerHandle, String)} API.
 *
 * @param peerHandle The peer's handle obtained through
 * {@link DiscoverySessionCallback#onServiceDiscovered(PeerHandle, byte[], java.util.List)}
 *                   or
 *                   {@link DiscoverySessionCallback#onMessageReceived(PeerHandle, byte[])}.
 *                   On a RESPONDER this value is used to gate the acceptance of a connection
 *                   request from only that peer.
 *
 * This value must never be {@code null}.
 * @return A {@link NetworkSpecifier} to be used to construct
 * {@link android.net.NetworkRequest.Builder#setNetworkSpecifier(NetworkSpecifier)} to pass to
 * {@link android.net.ConnectivityManager#requestNetwork(android.net.NetworkRequest,
 * android.net.ConnectivityManager.NetworkCallback)}
 * [or other varieties of that API].
 */

public android.net.NetworkSpecifier createNetworkSpecifierOpen(@androidx.annotation.RecentlyNonNull android.net.wifi.aware.PeerHandle peerHandle) { throw new RuntimeException("Stub!"); }

/**
 * Create a {@link android.net.NetworkRequest.Builder#setNetworkSpecifier(NetworkSpecifier)} for
 * an encrypted WiFi Aware connection (link) to the specified peer. The
 * {@link android.net.NetworkRequest.Builder#addTransportType(int)} should be set to
 * {@link android.net.NetworkCapabilities#TRANSPORT_WIFI_AWARE}.
 * <p>
 * This method should be used when setting up a connection with a peer discovered through Aware
 * discovery or communication (in such scenarios the MAC address of the peer is shielded by
 * an opaque peer ID handle). If an Aware connection is needed to a peer discovered using other
 * OOB (out-of-band) mechanism then use the alternative
 * {@link WifiAwareSession#createNetworkSpecifierPassphrase(int, byte[], String)} method -
 * which uses the peer's MAC address.
 * <p>
 * Note: per the Wi-Fi Aware specification the roles are fixed - a Subscriber is an INITIATOR
 * and a Publisher is a RESPONDER.
 *
 * @param peerHandle The peer's handle obtained through
 * {@link DiscoverySessionCallback#onServiceDiscovered(PeerHandle,
 * byte[], java.util.List)} or
 * {@link DiscoverySessionCallback#onMessageReceived(PeerHandle,
 * byte[])}. On a RESPONDER this value is used to gate the acceptance of a connection request
 *                   from only that peer.
 * This value must never be {@code null}.
 * @param passphrase The passphrase to be used to encrypt the link. The PMK is generated from
 *                   the passphrase. Use the
 *                   {@link #createNetworkSpecifierOpen(PeerHandle)} API to
 *                   specify an open (unencrypted) link.
 *
 * This value must never be {@code null}.
 * @return A {@link NetworkSpecifier} to be used to construct
 * {@link android.net.NetworkRequest.Builder#setNetworkSpecifier(NetworkSpecifier)} to pass to
 * {@link android.net.ConnectivityManager#requestNetwork(android.net.NetworkRequest,
 * android.net.ConnectivityManager.NetworkCallback)}
 * [or other varieties of that API].
 */

public android.net.NetworkSpecifier createNetworkSpecifierPassphrase(@androidx.annotation.RecentlyNonNull android.net.wifi.aware.PeerHandle peerHandle, @androidx.annotation.RecentlyNonNull java.lang.String passphrase) { throw new RuntimeException("Stub!"); }
}

