/*
 * Copyright (C) 2008 The Android Open Source Project
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

package android.net;

import android.os.Build.VERSION_CODES;
import android.provider.Settings;
import android.os.Process;
import java.util.List;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.content.Intent;
import android.app.PendingIntent;
import android.os.ResultReceiver;
import android.os.Binder;

/**
 * Class that answers queries about the state of network connectivity. It also
 * notifies applications when network connectivity changes.
 * <p>
 * The primary responsibilities of this class are to:
 * <ol>
 * <li>Monitor network connections (Wi-Fi, GPRS, UMTS, etc.)</li>
 * <li>Send broadcast intents when network connectivity changes</li>
 * <li>Attempt to "fail over" to another network when connectivity to a network
 * is lost</li>
 * <li>Provide an API that allows applications to query the coarse-grained or fine-grained
 * state of the available networks</li>
 * <li>Provide an API that allows applications to request and select networks for their data
 * traffic</li>
 * </ol>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConnectivityManager {

ConnectivityManager() { throw new RuntimeException("Stub!"); }

/**
 * Tests if a given integer represents a valid network type.
 * @param networkType the type to be tested
 * @return a boolean.  {@code true} if the type is valid, else {@code false}
 * @deprecated All APIs accepting a network type are deprecated. There should be no need to
 *             validate a network type.
 */

@Deprecated public static boolean isNetworkTypeValid(int networkType) { throw new RuntimeException("Stub!"); }

/**
 * Specifies the preferred network type.  When the device has more
 * than one type available the preferred network type will be used.
 *
 * @param preference the network type to prefer over all others.  It is
 *         unspecified what happens to the old preferred network in the
 *         overall ordering.
 * @deprecated Functionality has been removed as it no longer makes sense,
 *             with many more than two networks - we'd need an array to express
 *             preference.  Instead we use dynamic network properties of
 *             the networks to describe their precedence.
 */

@Deprecated public void setNetworkPreference(int preference) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the current preferred network type.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @return an integer representing the preferred network type
 *
 * @deprecated Functionality has been removed as it no longer makes sense,
 *             with many more than two networks - we'd need an array to express
 *             preference.  Instead we use dynamic network properties of
 *             the networks to describe their precedence.
 */

@Deprecated public int getNetworkPreference() { throw new RuntimeException("Stub!"); }

/**
 * Returns details about the currently active default data network. When
 * connected, this network is the default route for outgoing connections.
 * You should always check {@link NetworkInfo#isConnected()} before initiating
 * network traffic. This may return {@code null} when there is no default
 * network.
 * Note that if the default network is a VPN, this method will return the
 * NetworkInfo for one of its underlying networks instead, or null if the
 * VPN agent did not specify any. Apps interested in realfix_check about VPNs
 * should use {@link #getNetworkInfo(android.net.Network)} instead.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @return a {@link NetworkInfo} object for the current default network
 *        or {@code null} if no default network is currently active
 */

public android.net.NetworkInfo getActiveNetworkInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Network} object corresponding to the currently active
 * default data network.  In the event that the current active default data
 * network disconnects, the returned {@code Network} object will no longer
 * be usable.  This will return {@code null} when there is no default
 * network.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @return a {@link Network} object for the current default network or
 *        {@code null} if no default network is currently active
 */

public android.net.Network getActiveNetwork() { throw new RuntimeException("Stub!"); }

/**
 * Returns connection status information about a particular
 * network type.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param networkType integer specifying which networkType in
 *        which you're interested.
 * @return a {@link NetworkInfo} object for the requested
 *        network type or {@code null} if the type is not
 *        supported by the device. If {@code networkType} is
 *        TYPE_VPN and a VPN is active for the calling app,
 *        then this method will try to return one of the
 *        underlying networks for the VPN or null if the
 *        VPN agent didn't specify any.
 *
 * @deprecated This method does not support multiple connected networks
 *             of the same type. Use {@link #getAllNetworks} and
 *             {@link #getNetworkInfo(android.net.Network)} instead.
 */

@Deprecated public android.net.NetworkInfo getNetworkInfo(int networkType) { throw new RuntimeException("Stub!"); }

/**
 * Returns connection status information about a particular
 * Network.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param network {@link Network} specifying which network
 *        in which you're interested.
 * @return a {@link NetworkInfo} object for the requested
 *        network or {@code null} if the {@code Network}
 *        is not valid.
 */

public android.net.NetworkInfo getNetworkInfo(android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Returns connection status information about all network
 * types supported by the device.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @return an array of {@link NetworkInfo} objects.  Check each
 * {@link NetworkInfo#getType} for which type each applies.
 *
 * @deprecated This method does not support multiple connected networks
 *             of the same type. Use {@link #getAllNetworks} and
 *             {@link #getNetworkInfo(android.net.Network)} instead.
 */

@Deprecated public android.net.NetworkInfo[] getAllNetworkInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of all {@link Network} currently tracked by the
 * framework.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @return an array of {@link Network} objects.
 */

public android.net.Network[] getAllNetworks() { throw new RuntimeException("Stub!"); }

/**
 * Get the {@link LinkProperties} for the given {@link Network}.  This
 * will return {@code null} if the network is unknown.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param network The {@link Network} object identifying the network in question.
 * @return The {@link LinkProperties} for the network, or {@code null}.
 */

public android.net.LinkProperties getLinkProperties(android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Get the {@link android.net.NetworkCapabilities} for the given {@link Network}.  This
 * will return {@code null} if the network is unknown.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param network The {@link Network} object identifying the network in question.
 * @return The {@link android.net.NetworkCapabilities} for the network, or {@code null}.
 */

public android.net.NetworkCapabilities getNetworkCapabilities(android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the setting for background data usage. If false,
 * applications should not use the network if the application is not in the
 * foreground. Developers should respect this setting, and check the value
 * of this before performing any background data operations.
 * <p>
 * All applications that have background services that use the network
 * should listen to {@link #ACTION_BACKGROUND_DATA_SETTING_CHANGED}.
 * <p>
 * @deprecated As of {@link VERSION_CODES#ICE_CREAM_SANDWICH}, availability of
 * background data depends on several combined factors, and this method will
 * always return {@code true}. Instead, when background data is unavailable,
 * {@link #getActiveNetworkInfo()} will now appear disconnected.
 *
 * @return Whether background data usage is allowed.
 */

@Deprecated public boolean getBackgroundDataSetting() { throw new RuntimeException("Stub!"); }

/**
 * Start listening to reports when the system's default data network is active, meaning it is
 * a good time to perform network traffic.  Use {@link #isDefaultNetworkActive()}
 * to determine the current state of the system's default network after registering the
 * listener.
 * <p>
 * If the process default network has been set with
 * {@link ConnectivityManager#bindProcessToNetwork} this function will not
 * reflect the process's default, but the system default.
 *
 * @param l The listener to be told when the network is active.
 */

public void addDefaultNetworkActiveListener(android.net.ConnectivityManager.OnNetworkActiveListener l) { throw new RuntimeException("Stub!"); }

/**
 * Remove network active listener previously registered with
 * {@link #addDefaultNetworkActiveListener}.
 *
 * @param l Previously registered listener.
 */

public void removeDefaultNetworkActiveListener(android.net.ConnectivityManager.OnNetworkActiveListener l) { throw new RuntimeException("Stub!"); }

/**
 * Return whether the data network is currently active.  An active network means that
 * it is currently in a high power state for performing data transmission.  On some
 * types of networks, it may be expensive to move and stay in such a state, so it is
 * more power efficient to batch network traffic together when the radio is already in
 * this state.  This method tells you whether right now is currently a good time to
 * initiate network traffic, as the network is already active.
 */

public boolean isDefaultNetworkActive() { throw new RuntimeException("Stub!"); }

/**
 * Report a problem network to the framework.  This provides a hint to the system
 * that there might be connectivity problems on this network and may cause
 * the framework to re-evaluate network connectivity and/or switch to another
 * network.
 *
 * @param network The {@link Network} the application was attempting to use
 *                or {@code null} to indicate the current default network.
 * @deprecated Use {@link #reportNetworkConnectivity} which allows reporting both
 *             working and non-working connectivity.
 */

@Deprecated public void reportBadNetwork(android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Report to the framework whether a network has working connectivity.
 * This provides a hint to the system that a particular network is providing
 * working connectivity or not.  In response the framework may re-evaluate
 * the network's connectivity and might take further action thereafter.
 *
 * @param network The {@link Network} the application was attempting to use
 *                or {@code null} to indicate the current default network.
 * @param hasConnectivity {@code true} if the application was able to successfully access the
 *                        Internet using {@code network} or {@code false} if not.
 */

public void reportNetworkConnectivity(android.net.Network network, boolean hasConnectivity) { throw new RuntimeException("Stub!"); }

/**
 * Get the current default HTTP proxy settings.  If a global proxy is set it will be returned,
 * otherwise if this process is bound to a {@link Network} using
 * {@link #bindProcessToNetwork} then that {@code Network}'s proxy is returned, otherwise
 * the default network's proxy is returned.
 *
 * @return the {@link ProxyInfo} for the current HTTP proxy, or {@code null} if no
 *        HTTP proxy is active.
 */

public android.net.ProxyInfo getDefaultProxy() { throw new RuntimeException("Stub!"); }

/**
 * Returns if the currently active data network is metered. A network is
 * classified as metered when the user is sensitive to heavy data usage on
 * that connection due to monetary costs, data limitations or
 * battery/performance issues. You should check this before doing large
 * data transfers, and warn the user or delay the operation until another
 * network is available.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @return {@code true} if large transfers should be avoided, otherwise
 *        {@code false}.
 */

public boolean isActiveNetworkMetered() { throw new RuntimeException("Stub!"); }

/**
 * Request a network to satisfy a set of {@link android.net.NetworkCapabilities}.
 *
 * This {@link NetworkRequest} will live until released via
 * {@link #unregisterNetworkCallback(NetworkCallback)} or the calling application exits. A
 * version of the method which takes a timeout is
 * {@link #requestNetwork(NetworkRequest, NetworkCallback, int)}.
 * Status of the request can be followed by listening to the various
 * callbacks described in {@link NetworkCallback}.  The {@link Network}
 * can be used to direct traffic to the network.
 * <p>It is presently unsupported to request a network with mutable
 * {@link NetworkCapabilities} such as
 * {@link NetworkCapabilities#NET_CAPABILITY_VALIDATED} or
 * {@link NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}
 * as these {@code NetworkCapabilities} represent states that a particular
 * network may never attain, and whether a network will attain these states
 * is unknown prior to bringing up the network so the framework does not
 * know how to go about satisfing a request with these capabilities.
 *
 * <p>This method requires the caller to hold either the
 * {@link android.Manifest.permission#CHANGE_NETWORK_STATE} permission
 * or the ability to modify system settings as determined by
 * {@link android.provider.Settings.System#canWrite}.</p>
 *
 * @param request {@link NetworkRequest} describing this request.
 * @param networkCallback The {@link NetworkCallback} to be utilized for this request. Note
 *                        the callback must not be shared - it uniquely specifies this request.
 *                        The callback is invoked on the default internal Handler.
 * @throws IllegalArgumentException if {@code request} specifies any mutable
 *         {@code NetworkCapabilities}.
 */

public void requestNetwork(android.net.NetworkRequest request, android.net.ConnectivityManager.NetworkCallback networkCallback) { throw new RuntimeException("Stub!"); }

/**
 * Request a network to satisfy a set of {@link android.net.NetworkCapabilities}.
 *
 * This {@link NetworkRequest} will live until released via
 * {@link #unregisterNetworkCallback(NetworkCallback)} or the calling application exits. A
 * version of the method which takes a timeout is
 * {@link #requestNetwork(NetworkRequest, NetworkCallback, int)}.
 * Status of the request can be followed by listening to the various
 * callbacks described in {@link NetworkCallback}.  The {@link Network}
 * can be used to direct traffic to the network.
 * <p>It is presently unsupported to request a network with mutable
 * {@link NetworkCapabilities} such as
 * {@link NetworkCapabilities#NET_CAPABILITY_VALIDATED} or
 * {@link NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}
 * as these {@code NetworkCapabilities} represent states that a particular
 * network may never attain, and whether a network will attain these states
 * is unknown prior to bringing up the network so the framework does not
 * know how to go about satisfing a request with these capabilities.
 *
 * <p>This method requires the caller to hold either the
 * {@link android.Manifest.permission#CHANGE_NETWORK_STATE} permission
 * or the ability to modify system settings as determined by
 * {@link android.provider.Settings.System#canWrite}.</p>
 *
 * @param request {@link NetworkRequest} describing this request.
 * @param networkCallback The {@link NetworkCallback} to be utilized for this request. Note
 *                        the callback must not be shared - it uniquely specifies this request.
 * @param handler {@link Handler} to specify the thread upon which the callback will be invoked.
 * @throws IllegalArgumentException if {@code request} specifies any mutable
 *         {@code NetworkCapabilities}.
 */

public void requestNetwork(android.net.NetworkRequest request, android.net.ConnectivityManager.NetworkCallback networkCallback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Request a network to satisfy a set of {@link android.net.NetworkCapabilities}, limited
 * by a timeout.
 *
 * This function behaves identically to the non-timed-out version
 * {@link #requestNetwork(NetworkRequest, NetworkCallback)}, but if a suitable network
 * is not found within the given time (in milliseconds) the
 * {@link NetworkCallback#onUnavailable()} callback is called. The request can still be
 * released normally by calling {@link #unregisterNetworkCallback(NetworkCallback)} but does
 * not have to be released if timed-out (it is automatically released). Unregistering a
 * request that timed out is not an error.
 *
 * <p>Do not use this method to poll for the existence of specific networks (e.g. with a small
 * timeout) - {@link #registerNetworkCallback(NetworkRequest, NetworkCallback)} is provided
 * for that purpose. Calling this method will attempt to bring up the requested network.
 *
 * <p>This method requires the caller to hold either the
 * {@link android.Manifest.permission#CHANGE_NETWORK_STATE} permission
 * or the ability to modify system settings as determined by
 * {@link android.provider.Settings.System#canWrite}.</p>
 *
 * @param request {@link NetworkRequest} describing this request.
 * @param networkCallback The {@link NetworkCallback} to be utilized for this request. Note
 *                        the callback must not be shared - it uniquely specifies this request.
 * @param timeoutMs The time in milliseconds to attempt looking for a suitable network
 *                  before {@link NetworkCallback#onUnavailable()} is called. The timeout must
 *                  be a positive value (i.e. >0).
 */

public void requestNetwork(android.net.NetworkRequest request, android.net.ConnectivityManager.NetworkCallback networkCallback, int timeoutMs) { throw new RuntimeException("Stub!"); }

/**
 * Request a network to satisfy a set of {@link android.net.NetworkCapabilities}, limited
 * by a timeout.
 *
 * This function behaves identically to the non-timedout version, but if a suitable
 * network is not found within the given time (in milliseconds) the
 * {@link NetworkCallback#onUnavailable} callback is called. The request can still be
 * released normally by calling {@link #unregisterNetworkCallback(NetworkCallback)} but does
 * not have to be released if timed-out (it is automatically released). Unregistering a
 * request that timed out is not an error.
 *
 * <p>Do not use this method to poll for the existence of specific networks (e.g. with a small
 * timeout) - {@link #registerNetworkCallback(NetworkRequest, NetworkCallback)} is provided
 * for that purpose. Calling this method will attempt to bring up the requested network.
 *
 * <p>This method requires the caller to hold either the
 * {@link android.Manifest.permission#CHANGE_NETWORK_STATE} permission
 * or the ability to modify system settings as determined by
 * {@link android.provider.Settings.System#canWrite}.</p>
 *
 * @param request {@link NetworkRequest} describing this request.
 * @param networkCallback The {@link NetworkCallback} to be utilized for this request. Note
 *                        the callback must not be shared - it uniquely specifies this request.
 * @param handler {@link Handler} to specify the thread upon which the callback will be invoked.
 * @param timeoutMs The time in milliseconds to attempt looking for a suitable network
 *                  before {@link NetworkCallback#onUnavailable} is called.
 */

public void requestNetwork(android.net.NetworkRequest request, android.net.ConnectivityManager.NetworkCallback networkCallback, android.os.Handler handler, int timeoutMs) { throw new RuntimeException("Stub!"); }

/**
 * Request a network to satisfy a set of {@link android.net.NetworkCapabilities}.
 *
 * This function behaves identically to the version that takes a NetworkCallback, but instead
 * of {@link NetworkCallback} a {@link PendingIntent} is used.  This means
 * the request may outlive the calling application and get called back when a suitable
 * network is found.
 * <p>
 * The operation is an Intent broadcast that goes to a broadcast receiver that
 * you registered with {@link Context#registerReceiver} or through the
 * &lt;receiver&gt; tag in an AndroidManifest.xml file
 * <p>
 * The operation Intent is delivered with two extras, a {@link Network} typed
 * extra called {@link #EXTRA_NETWORK} and a {@link NetworkRequest}
 * typed extra called {@link #EXTRA_NETWORK_REQUEST} containing
 * the original requests parameters.  It is important to create a new,
 * {@link NetworkCallback} based request before completing the processing of the
 * Intent to reserve the network or it will be released shortly after the Intent
 * is processed.
 * <p>
 * If there is already a request for this Intent registered (with the equality of
 * two Intents defined by {@link Intent#filterEquals}), then it will be removed and
 * replaced by this one, effectively releasing the previous {@link NetworkRequest}.
 * <p>
 * The request may be released normally by calling
 * {@link #releaseNetworkRequest(android.app.PendingIntent)}.
 * <p>It is presently unsupported to request a network with either
 * {@link NetworkCapabilities#NET_CAPABILITY_VALIDATED} or
 * {@link NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}
 * as these {@code NetworkCapabilities} represent states that a particular
 * network may never attain, and whether a network will attain these states
 * is unknown prior to bringing up the network so the framework does not
 * know how to go about satisfing a request with these capabilities.
 *
 * <p>This method requires the caller to hold either the
 * {@link android.Manifest.permission#CHANGE_NETWORK_STATE} permission
 * or the ability to modify system settings as determined by
 * {@link android.provider.Settings.System#canWrite}.</p>
 *
 * @param request {@link NetworkRequest} describing this request.
 * @param operation Action to perform when the network is available (corresponds
 *                  to the {@link NetworkCallback#onAvailable} call.  Typically
 *                  comes from {@link PendingIntent#getBroadcast}. Cannot be null.
 * @throws IllegalArgumentException if {@code request} contains either
 *         {@link NetworkCapabilities#NET_CAPABILITY_VALIDATED} or
 *         {@link NetworkCapabilities#NET_CAPABILITY_CAPTIVE_PORTAL}.
 */

public void requestNetwork(android.net.NetworkRequest request, android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Removes a request made via {@link #requestNetwork(NetworkRequest, android.app.PendingIntent)}
 * <p>
 * This method has the same behavior as
 * {@link #unregisterNetworkCallback(android.app.PendingIntent)} with respect to
 * releasing network resources and disconnecting.
 *
 * @param operation A PendingIntent equal (as defined by {@link Intent#filterEquals}) to the
 *                  PendingIntent passed to
 *                  {@link #requestNetwork(NetworkRequest, android.app.PendingIntent)} with the
 *                  corresponding NetworkRequest you'd like to remove. Cannot be null.
 */

public void releaseNetworkRequest(android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Registers to receive notifications about all networks which satisfy the given
 * {@link NetworkRequest}.  The callbacks will continue to be called until
 * either the application exits or link #unregisterNetworkCallback(NetworkCallback)} is called.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param request {@link NetworkRequest} describing this request.
 * @param networkCallback The {@link NetworkCallback} that the system will call as suitable
 *                        networks change state.
 *                        The callback is invoked on the default internal Handler.
 */

public void registerNetworkCallback(android.net.NetworkRequest request, android.net.ConnectivityManager.NetworkCallback networkCallback) { throw new RuntimeException("Stub!"); }

/**
 * Registers to receive notifications about all networks which satisfy the given
 * {@link NetworkRequest}.  The callbacks will continue to be called until
 * either the application exits or link #unregisterNetworkCallback(NetworkCallback)} is called.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param request {@link NetworkRequest} describing this request.
 * @param networkCallback The {@link NetworkCallback} that the system will call as suitable
 *                        networks change state.
 * @param handler {@link Handler} to specify the thread upon which the callback will be invoked.
 */

public void registerNetworkCallback(android.net.NetworkRequest request, android.net.ConnectivityManager.NetworkCallback networkCallback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Registers a PendingIntent to be sent when a network is available which satisfies the given
 * {@link NetworkRequest}.
 *
 * This function behaves identically to the version that takes a NetworkCallback, but instead
 * of {@link NetworkCallback} a {@link PendingIntent} is used.  This means
 * the request may outlive the calling application and get called back when a suitable
 * network is found.
 * <p>
 * The operation is an Intent broadcast that goes to a broadcast receiver that
 * you registered with {@link Context#registerReceiver} or through the
 * &lt;receiver&gt; tag in an AndroidManifest.xml file
 * <p>
 * The operation Intent is delivered with two extras, a {@link Network} typed
 * extra called {@link #EXTRA_NETWORK} and a {@link NetworkRequest}
 * typed extra called {@link #EXTRA_NETWORK_REQUEST} containing
 * the original requests parameters.
 * <p>
 * If there is already a request for this Intent registered (with the equality of
 * two Intents defined by {@link Intent#filterEquals}), then it will be removed and
 * replaced by this one, effectively releasing the previous {@link NetworkRequest}.
 * <p>
 * The request may be released normally by calling
 * {@link #unregisterNetworkCallback(android.app.PendingIntent)}.
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param request {@link NetworkRequest} describing this request.
 * @param operation Action to perform when the network is available (corresponds
 *                  to the {@link NetworkCallback#onAvailable} call.  Typically
 *                  comes from {@link PendingIntent#getBroadcast}. Cannot be null.
 */

public void registerNetworkCallback(android.net.NetworkRequest request, android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Registers to receive notifications about changes in the system default network. The callbacks
 * will continue to be called until either the application exits or
 * {@link #unregisterNetworkCallback(NetworkCallback)} is called.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param networkCallback The {@link NetworkCallback} that the system will call as the
 *                        system default network changes.
 *                        The callback is invoked on the default internal Handler.
 */

public void registerDefaultNetworkCallback(android.net.ConnectivityManager.NetworkCallback networkCallback) { throw new RuntimeException("Stub!"); }

/**
 * Registers to receive notifications about changes in the system default network. The callbacks
 * will continue to be called until either the application exits or
 * {@link #unregisterNetworkCallback(NetworkCallback)} is called.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param networkCallback The {@link NetworkCallback} that the system will call as the
 *                        system default network changes.
 * @param handler {@link Handler} to specify the thread upon which the callback will be invoked.
 */

public void registerDefaultNetworkCallback(android.net.ConnectivityManager.NetworkCallback networkCallback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Requests bandwidth update for a given {@link Network} and returns whether the update request
 * is accepted by ConnectivityService. Once accepted, ConnectivityService will poll underlying
 * network connection for updated bandwidth information. The caller will be notified via
 * {@link ConnectivityManager.NetworkCallback} if there is an update. Notice that this
 * method assumes that the caller has previously called
 * {@link #registerNetworkCallback(NetworkRequest, NetworkCallback)} to listen for network
 * changes.
 *
 * @param network {@link Network} specifying which network you're interested.
 * @return {@code true} on success, {@code false} if the {@link Network} is no longer valid.
 */

public boolean requestBandwidthUpdate(android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a {@code NetworkCallback} and possibly releases networks originating from
 * {@link #requestNetwork(NetworkRequest, NetworkCallback)} and
 * {@link #registerNetworkCallback(NetworkRequest, NetworkCallback)} calls.
 * If the given {@code NetworkCallback} had previously been used with
 * {@code #requestNetwork}, any networks that had been connected to only to satisfy that request
 * will be disconnected.
 *
 * Notifications that would have triggered that {@code NetworkCallback} will immediately stop
 * triggering it as soon as this call returns.
 *
 * @param networkCallback The {@link NetworkCallback} used when making the request.
 */

public void unregisterNetworkCallback(android.net.ConnectivityManager.NetworkCallback networkCallback) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a callback previously registered via
 * {@link #registerNetworkCallback(NetworkRequest, android.app.PendingIntent)}.
 *
 * @param operation A PendingIntent equal (as defined by {@link Intent#filterEquals}) to the
 *                  PendingIntent passed to
 *                  {@link #registerNetworkCallback(NetworkRequest, android.app.PendingIntent)}.
 *                  Cannot be null.
 */

public void unregisterNetworkCallback(android.app.PendingIntent operation) { throw new RuntimeException("Stub!"); }

/**
 * Provides a hint to the calling application on whether it is desirable to use the
 * multinetwork APIs (e.g., {@link Network#openConnection}, {@link Network#bindSocket}, etc.)
 * for multipath data transfer on this network when it is not the system default network.
 * Applications desiring to use multipath network protocols should call this method before
 * each such operation.
 *
 * Requires {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 * @param network The network on which the application desires to use multipath data.
 *                If {@code null}, this method will return the a preference that will generally
 *                apply to metered networks.
 * @return a bitwise OR of zero or more of the  {@code MULTIPATH_PREFERENCE_*} constants.

 * Value is either <code>0</code> or a combination of {@link android.net.ConnectivityManager#MULTIPATH_PREFERENCE_HANDOVER}, {@link android.net.ConnectivityManager#MULTIPATH_PREFERENCE_RELIABILITY}, and {@link android.net.ConnectivityManager#MULTIPATH_PREFERENCE_PERFORMANCE}
 */

public int getMultipathPreference(android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Binds the current process to {@code network}.  All Sockets created in the future
 * (and not explicitly bound via a bound SocketFactory from
 * {@link Network#getSocketFactory() Network.getSocketFactory()}) will be bound to
 * {@code network}.  All host name resolutions will be limited to {@code network} as well.
 * Note that if {@code network} ever disconnects, all Sockets created in this way will cease to
 * work and all host name resolutions will fail.  This is by design so an application doesn't
 * accidentally use Sockets it thinks are still bound to a particular {@link Network}.
 * To clear binding pass {@code null} for {@code network}.  Using individually bound
 * Sockets created by Network.getSocketFactory().createSocket() and
 * performing network-specific host name resolutions via
 * {@link Network#getAllByName Network.getAllByName} is preferred to calling
 * {@code bindProcessToNetwork}.
 *
 * @param network The {@link Network} to bind the current process to, or {@code null} to clear
 *                the current binding.
 * @return {@code true} on success, {@code false} if the {@link Network} is no longer valid.
 */

public boolean bindProcessToNetwork(android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Binds the current process to {@code network}.  All Sockets created in the future
 * (and not explicitly bound via a bound SocketFactory from
 * {@link Network#getSocketFactory() Network.getSocketFactory()}) will be bound to
 * {@code network}.  All host name resolutions will be limited to {@code network} as well.
 * Note that if {@code network} ever disconnects, all Sockets created in this way will cease to
 * work and all host name resolutions will fail.  This is by design so an application doesn't
 * accidentally use Sockets it thinks are still bound to a particular {@link Network}.
 * To clear binding pass {@code null} for {@code network}.  Using individually bound
 * Sockets created by Network.getSocketFactory().createSocket() and
 * performing network-specific host name resolutions via
 * {@link Network#getAllByName Network.getAllByName} is preferred to calling
 * {@code setProcessDefaultNetwork}.
 *
 * @param network The {@link Network} to bind the current process to, or {@code null} to clear
 *                the current binding.
 * @return {@code true} on success, {@code false} if the {@link Network} is no longer valid.
 * @deprecated This function can throw {@link IllegalStateException}.  Use
 *             {@link #bindProcessToNetwork} instead.  {@code bindProcessToNetwork}
 *             is a direct replacement.
 */

@Deprecated public static boolean setProcessDefaultNetwork(android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link Network} currently bound to this process via
 * {@link #bindProcessToNetwork}, or {@code null} if no {@link Network} is explicitly bound.
 *
 * @return {@code Network} to which this process is bound, or {@code null}.
 */

public android.net.Network getBoundNetworkForProcess() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link Network} currently bound to this process via
 * {@link #bindProcessToNetwork}, or {@code null} if no {@link Network} is explicitly bound.
 *
 * @return {@code Network} to which this process is bound, or {@code null}.
 * @deprecated Using this function can lead to other functions throwing
 *             {@link IllegalStateException}.  Use {@link #getBoundNetworkForProcess} instead.
 *             {@code getBoundNetworkForProcess} is a direct replacement.
 */

@Deprecated public static android.net.Network getProcessDefaultNetwork() { throw new RuntimeException("Stub!"); }

/**
 * Determines if the calling application is subject to metered network restrictions while
 * running on background.
 *
 * @return {@link #RESTRICT_BACKGROUND_STATUS_DISABLED},
 * {@link #RESTRICT_BACKGROUND_STATUS_ENABLED},
 * or {@link #RESTRICT_BACKGROUND_STATUS_WHITELISTED}

 * Value is {@link android.net.ConnectivityManager#RESTRICT_BACKGROUND_STATUS_DISABLED}, {@link android.net.ConnectivityManager#RESTRICT_BACKGROUND_STATUS_WHITELISTED}, or {@link android.net.ConnectivityManager#RESTRICT_BACKGROUND_STATUS_ENABLED}
 */

public int getRestrictBackgroundStatus() { throw new RuntimeException("Stub!"); }

/**
 * The network watchlist is a list of domains and IP addresses that are associated with
 * potentially harmful apps. This method returns the SHA-256 of the watchlist config file
 * currently used by the system for validation purposes.
 *
 * @return Hash of network watchlist config file. Null if config does not exist.
 */

public byte[] getNetworkWatchlistConfigHash() { throw new RuntimeException("Stub!"); }

/**
 * Broadcast Action: The setting for background data usage has changed
 * values. Use {@link #getBackgroundDataSetting()} to get the current value.
 * <p>
 * If an application uses the network in the background, it should listen
 * for this broadcast and stop using the background data if the value is
 * {@code false}.
 * <p>
 *
 * @deprecated As of {@link VERSION_CODES#ICE_CREAM_SANDWICH}, availability
 *             of background data depends on several combined factors, and
 *             this broadcast is no longer sent. Instead, when background
 *             data is unavailable, {@link #getActiveNetworkInfo()} will now
 *             appear disconnected. During first boot after a platform
 *             upgrade, this broadcast will be sent once if
 *             {@link #getBackgroundDataSetting()} was {@code false} before
 *             the upgrade.
 */

@Deprecated public static final java.lang.String ACTION_BACKGROUND_DATA_SETTING_CHANGED = "android.net.conn.BACKGROUND_DATA_SETTING_CHANGED";

/**
 * The device has connected to a network that has presented a captive
 * portal, which is blocking Internet connectivity. The user was presented
 * with a notification that network sign in is required,
 * and the user invoked the notification's action indicating they
 * desire to sign in to the network. Apps handling this activity should
 * facilitate signing in to the network. This action includes a
 * {@link Network} typed extra called {@link #EXTRA_NETWORK} that represents
 * the network presenting the captive portal; all communication with the
 * captive portal must be done using this {@code Network} object.
 * <p/>
 * This activity includes a {@link CaptivePortal} extra named
 * {@link #EXTRA_CAPTIVE_PORTAL} that can be used to indicate different
 * outcomes of the captive portal sign in to the system:
 * <ul>
 * <li> When the app handling this action believes the user has signed in to
 * the network and the captive portal has been dismissed, the app should
 * call {@link CaptivePortal#reportCaptivePortalDismissed} so the system can
 * reevaluate the network. If reevaluation finds the network no longer
 * subject to a captive portal, the network may become the default active
 * data network. </li>
 * <li> When the app handling this action believes the user explicitly wants
 * to ignore the captive portal and the network, the app should call
 * {@link CaptivePortal#ignoreNetwork}. </li>
 * </ul>
 */

public static final java.lang.String ACTION_CAPTIVE_PORTAL_SIGN_IN = "android.net.conn.CAPTIVE_PORTAL";

/**
 * A change in the background metered network activity restriction has occurred.
 * <p>
 * Applications should call {@link #getRestrictBackgroundStatus()} to check if the restriction
 * applies to them.
 * <p>
 * This is only sent to registered receivers, not manifest receivers.
 */

public static final java.lang.String ACTION_RESTRICT_BACKGROUND_CHANGED = "android.net.conn.RESTRICT_BACKGROUND_CHANGED";

/**
 * A change in network connectivity has occurred. A default connection has either
 * been established or lost. The NetworkInfo for the affected network is
 * sent as an extra; it should be consulted to see what kind of
 * connectivity event occurred.
 * <p/>
 * Apps targeting Android 7.0 (API level 24) and higher do not receive this
 * broadcast if they declare the broadcast receiver in their manifest. Apps
 * will still receive broadcasts if they register their
 * {@link android.content.BroadcastReceiver} with
 * {@link android.content.Context#registerReceiver Context.registerReceiver()}
 * and that context is still valid.
 * <p/>
 * If this is a connection that was the result of failing over from a
 * disconnected network, then the FAILOVER_CONNECTION boolean extra is
 * set to true.
 * <p/>
 * For a loss of connectivity, if the connectivity manager is attempting
 * to connect (or has already connected) to another network, the
 * NetworkInfo for the new network is also passed as an extra. This lets
 * any receivers of the broadcast know that they should not necessarily
 * tell the user that no data traffic will be possible. Instead, the
 * receiver should expect another broadcast soon, indicating either that
 * the failover attempt succeeded (and so there is still overall data
 * connectivity), or that the failover attempt failed, meaning that all
 * connectivity has been lost.
 * <p/>
 * For a disconnect event, the boolean extra EXTRA_NO_CONNECTIVITY
 * is set to {@code true} if there are no connected networks at all.
 *
 * @deprecated apps should use the more versatile {@link #requestNetwork},
 *             {@link #registerNetworkCallback} or {@link #registerDefaultNetworkCallback}
 *             functions instead for faster and more detailed updates about the network
 *             changes they care about.
 */

@Deprecated public static final java.lang.String CONNECTIVITY_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

/**
 * If you want to set the default network preference,you can directly
 * change the networkAttributes array in framework's config.xml.
 *
 * @deprecated Since we support so many more networks now, the single
 *             network default network preference can't really express
 *             the hierarchy.  Instead, the default is defined by the
 *             networkAttributes in config.xml.  You can determine
 *             the current value by calling {@link #getNetworkPreference()}
 *             from an App.
 */

@Deprecated public static final int DEFAULT_NETWORK_PREFERENCE = 1; // 0x1

/**
 * The lookup key for a {@link CaptivePortal} object included with the
 * {@link #ACTION_CAPTIVE_PORTAL_SIGN_IN} intent.  The {@code CaptivePortal}
 * object can be used to either indicate to the system that the captive
 * portal has been dismissed or that the user does not want to pursue
 * signing in to captive portal.  Retrieve it with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 */

public static final java.lang.String EXTRA_CAPTIVE_PORTAL = "android.net.extra.CAPTIVE_PORTAL";

/**
 * Key for passing a URL to the captive portal login activity.
 */

public static final java.lang.String EXTRA_CAPTIVE_PORTAL_URL = "android.net.extra.CAPTIVE_PORTAL_URL";

/**
 * The lookup key for a string that provides optionally supplied
 * extra information about the network state. The information
 * may be passed up from the lower networking layers, and its
 * meaning may be specific to a particular network type. Retrieve
 * it with {@link android.content.Intent#getStringExtra(String)}.
 */

public static final java.lang.String EXTRA_EXTRA_INFO = "extraInfo";

/**
 * The lookup key for a boolean that indicates whether a connect event
 * is for a network to which the connectivity manager was failing over
 * following a disconnect on another network.
 * Retrieve it with {@link android.content.Intent#getBooleanExtra(String,boolean)}.
 */

public static final java.lang.String EXTRA_IS_FAILOVER = "isFailover";

/**
 * The lookup key for a {@link Network} object included with the intent after
 * successfully finding a network for the applications request.  Retrieve it with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 * <p>
 * Note that if you intend to invoke {@link Network#openConnection(java.net.URL)}
 * then you must get a ConnectivityManager instance before doing so.
 */

public static final java.lang.String EXTRA_NETWORK = "android.net.extra.NETWORK";

/**
 * The lookup key for a {@link NetworkInfo} object. Retrieve with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 *
 * @deprecated Since {@link NetworkInfo} can vary based on UID, applications
 *             should always obtain network information through
 *             {@link #getActiveNetworkInfo()}.
 * @see #EXTRA_NETWORK_TYPE
 */

@Deprecated public static final java.lang.String EXTRA_NETWORK_INFO = "networkInfo";

/**
 * The lookup key for a {@link NetworkRequest} object included with the intent after
 * successfully finding a network for the applications request.  Retrieve it with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 */

public static final java.lang.String EXTRA_NETWORK_REQUEST = "android.net.extra.NETWORK_REQUEST";

/**
 * Network type which triggered a {@link #CONNECTIVITY_ACTION} broadcast.
 *
 * @see android.content.Intent#getIntExtra(String, int)
 */

public static final java.lang.String EXTRA_NETWORK_TYPE = "networkType";

/**
 * The lookup key for a boolean that indicates whether there is a
 * complete lack of connectivity, i.e., no network is available.
 * Retrieve it with {@link android.content.Intent#getBooleanExtra(String,boolean)}.
 */

public static final java.lang.String EXTRA_NO_CONNECTIVITY = "noConnectivity";

/**
 * The lookup key for a {@link NetworkInfo} object. This is supplied when
 * there is another network that it may be possible to connect to. Retrieve with
 * {@link android.content.Intent#getParcelableExtra(String)}.
 */

public static final java.lang.String EXTRA_OTHER_NETWORK_INFO = "otherNetwork";

/**
 * The lookup key for a string that indicates why an attempt to connect
 * to a network failed. The string has no particular structure. It is
 * intended to be used in notifications presented to users. Retrieve
 * it with {@link android.content.Intent#getStringExtra(String)}.
 */

public static final java.lang.String EXTRA_REASON = "reason";

/**
 * It is acceptable to briefly use multipath data to provide seamless connectivity for
 * time-sensitive user-facing operations when the system default network is temporarily
 * unresponsive. The amount of data should be limited (less than one megabyte for every call to
 * this method), and the operation should be infrequent to ensure that data usage is limited.
 *
 * An example of such an operation might be a time-sensitive foreground activity, such as a
 * voice command, that the user is performing while walking out of range of a Wi-Fi network.
 */

public static final int MULTIPATH_PREFERENCE_HANDOVER = 1; // 0x1

/**
 * It is acceptable to use metered data to improve network latency and performance.
 */

public static final int MULTIPATH_PREFERENCE_PERFORMANCE = 4; // 0x4

/**
 * It is acceptable to use small amounts of multipath data on an ongoing basis to provide
 * a backup channel for traffic that is primarily going over another network.
 *
 * An example might be maintaining backup connections to peers or servers for the purpose of
 * fast fallback if the default network is temporarily unresponsive or disconnects. The traffic
 * on backup paths should be negligible compared to the traffic on the main path.
 */

public static final int MULTIPATH_PREFERENCE_RELIABILITY = 2; // 0x2

/**
 * Device is not restricting metered network activity while application is running on
 * background.
 */

public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1; // 0x1

/**
 * Device is restricting metered network activity while application is running on background.
 * <p>
 * In this state, application should not try to use the network while running on background,
 * because it would be denied.
 */

public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3; // 0x3

/**
 * Device is restricting metered network activity while application is running on background,
 * but application is allowed to bypass it.
 * <p>
 * In this state, application should take action to mitigate metered network access.
 * For example, a music streaming application should switch to a low-bandwidth bitrate.
 */

public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2; // 0x2

/**
 * A Bluetooth data connection.
 *
 * @deprecated Applications should instead use {@link NetworkCapabilities#hasTransport} or
 *         {@link #requestNetwork(NetworkRequest, NetworkCallback)} to request an
 *         appropriate network. {@see NetworkCapabilities} for supported transports.
 */

@Deprecated public static final int TYPE_BLUETOOTH = 7; // 0x7

/**
 * Dummy data connection.  This should not be used on shipping devices.
 * @deprecated This is not used any more.
 */

@Deprecated public static final int TYPE_DUMMY = 8; // 0x8

/**
 * An Ethernet data connection.
 *
 * @deprecated Applications should instead use {@link NetworkCapabilities#hasTransport} or
 *         {@link #requestNetwork(NetworkRequest, NetworkCallback)} to request an
 *         appropriate network. {@see NetworkCapabilities} for supported transports.
 */

@Deprecated public static final int TYPE_ETHERNET = 9; // 0x9

/**
 * A Mobile data connection. Devices may support more than one.
 *
 * @deprecated Applications should instead use {@link NetworkCapabilities#hasTransport} or
 *         {@link #requestNetwork(NetworkRequest, NetworkCallback)} to request an
 *         appropriate network. {@see NetworkCapabilities} for supported transports.
 */

@Deprecated public static final int TYPE_MOBILE = 0; // 0x0

/**
 * A DUN-specific Mobile data connection.  This network type may use the
 * same network interface as {@link #TYPE_MOBILE} or it may use a different
 * one.  This is sometimes by the system when setting up an upstream connection
 * for tethering so that the carrier is aware of DUN traffic.
 *
 * @deprecated Applications should instead use {@link NetworkCapabilities#hasCapability} or
 *         {@link #requestNetwork(NetworkRequest, NetworkCallback)} to request a network that
 *         provides the {@link NetworkCapabilities#NET_CAPABILITY_DUN} capability.
 */

@Deprecated public static final int TYPE_MOBILE_DUN = 4; // 0x4

/**
 * A High Priority Mobile data connection.  This network type uses the
 * same network interface as {@link #TYPE_MOBILE} but the routing setup
 * is different.
 *
 * @deprecated Applications should instead use {@link NetworkCapabilities#hasTransport} or
 *         {@link #requestNetwork(NetworkRequest, NetworkCallback)} to request an
 *         appropriate network. {@see NetworkCapabilities} for supported transports.
 */

@Deprecated public static final int TYPE_MOBILE_HIPRI = 5; // 0x5

/**
 * An MMS-specific Mobile data connection.  This network type may use the
 * same network interface as {@link #TYPE_MOBILE} or it may use a different
 * one.  This is used by applications needing to talk to the carrier's
 * Multimedia Messaging Service servers.
 *
 * @deprecated Applications should instead use {@link NetworkCapabilities#hasCapability} or
 *         {@link #requestNetwork(NetworkRequest, NetworkCallback)} to request a network that
 *         provides the {@link NetworkCapabilities#NET_CAPABILITY_MMS} capability.
 */

@Deprecated public static final int TYPE_MOBILE_MMS = 2; // 0x2

/**
 * A SUPL-specific Mobile data connection.  This network type may use the
 * same network interface as {@link #TYPE_MOBILE} or it may use a different
 * one.  This is used by applications needing to talk to the carrier's
 * Secure User Plane Location servers for help locating the device.
 *
 * @deprecated Applications should instead use {@link NetworkCapabilities#hasCapability} or
 *         {@link #requestNetwork(NetworkRequest, NetworkCallback)} to request a network that
 *         provides the {@link NetworkCapabilities#NET_CAPABILITY_SUPL} capability.
 */

@Deprecated public static final int TYPE_MOBILE_SUPL = 3; // 0x3

/**
 * A virtual network using one or more native bearers.
 * It may or may not be providing security services.
 * @deprecated Applications should use {@link NetworkCapabilities#TRANSPORT_VPN} instead.
 */

@Deprecated public static final int TYPE_VPN = 17; // 0x11

/**
 * A WIFI data connection. Devices may support more than one.
 *
 * @deprecated Applications should instead use {@link NetworkCapabilities#hasTransport} or
 *         {@link #requestNetwork(NetworkRequest, NetworkCallback)} to request an
 *         appropriate network. {@see NetworkCapabilities} for supported transports.
 */

@Deprecated public static final int TYPE_WIFI = 1; // 0x1

/**
 * A WiMAX data connection.
 *
 * @deprecated Applications should instead use {@link NetworkCapabilities#hasTransport} or
 *         {@link #requestNetwork(NetworkRequest, NetworkCallback)} to request an
 *         appropriate network. {@see NetworkCapabilities} for supported transports.
 */

@Deprecated public static final int TYPE_WIMAX = 6; // 0x6
/**
 * Base class for {@code NetworkRequest} callbacks. Used for notifications about network
 * changes. Should be extended by applications wanting notifications.
 *
 * A {@code NetworkCallback} is registered by calling
 * {@link #requestNetwork(NetworkRequest, NetworkCallback)},
 * {@link #registerNetworkCallback(NetworkRequest, NetworkCallback)},
 * or {@link #registerDefaultNetworkCallback(NetworkCallback)}. A {@code NetworkCallback} is
 * unregistered by calling {@link #unregisterNetworkCallback(NetworkCallback)}.
 * A {@code NetworkCallback} should be registered at most once at any time.
 * A {@code NetworkCallback} that has been unregistered can be registered again.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class NetworkCallback {

public NetworkCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when the framework connects and has declared a new network ready for use.
 * This callback may be called more than once if the {@link Network} that is
 * satisfying the request changes. This will always immediately be followed by a
 * call to {@link #onCapabilitiesChanged(Network, NetworkCapabilities)} then by a
 * call to {@link #onLinkPropertiesChanged(Network, LinkProperties)}.
 *
 * @param network The {@link Network} of the satisfying network.
 */

public void onAvailable(android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Called when the network is about to be disconnected.  Often paired with an
 * {@link NetworkCallback#onAvailable} call with the new replacement network
 * for graceful handover.  This may not be called if we have a hard loss
 * (loss without warning).  This may be followed by either a
 * {@link NetworkCallback#onLost} call or a
 * {@link NetworkCallback#onAvailable} call for this network depending
 * on whether we lose or regain it.
 *
 * @param network The {@link Network} that is about to be disconnected.
 * @param maxMsToLive The time in ms the framework will attempt to keep the
 *                     network connected.  Note that the network may suffer a
 *                     hard loss at any time.
 */

public void onLosing(android.net.Network network, int maxMsToLive) { throw new RuntimeException("Stub!"); }

/**
 * Called when the framework has a hard loss of the network or when the
 * graceful failure ends.
 *
 * @param network The {@link Network} lost.
 */

public void onLost(android.net.Network network) { throw new RuntimeException("Stub!"); }

/**
 * Called if no network is found in the timeout time specified in
 * {@link #requestNetwork(NetworkRequest, NetworkCallback, int)} call. This callback is not
 * called for the version of {@link #requestNetwork(NetworkRequest, NetworkCallback)}
 * without timeout. When this callback is invoked the associated
 * {@link NetworkRequest} will have already been removed and released, as if
 * {@link #unregisterNetworkCallback(NetworkCallback)} had been called.
 */

public void onUnavailable() { throw new RuntimeException("Stub!"); }

/**
 * Called when the network the framework connected to for this request
 * changes capabilities but still satisfies the stated need.
 *
 * @param network The {@link Network} whose capabilities have changed.
 * @param networkCapabilities The new {@link android.net.NetworkCapabilities} for this
 *                            network.
 */

public void onCapabilitiesChanged(android.net.Network network, android.net.NetworkCapabilities networkCapabilities) { throw new RuntimeException("Stub!"); }

/**
 * Called when the network the framework connected to for this request
 * changes {@link LinkProperties}.
 *
 * @param network The {@link Network} whose link properties have changed.
 * @param linkProperties The new {@link LinkProperties} for this network.
 */

public void onLinkPropertiesChanged(android.net.Network network, android.net.LinkProperties linkProperties) { throw new RuntimeException("Stub!"); }
}

/**
 * Callback for use with {@link ConnectivityManager#addDefaultNetworkActiveListener}
 * to find out when the system default network has gone in to a high power state.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnNetworkActiveListener {

/**
 * Called on the main thread of the process to report that the current data network
 * has become active, and it is now a good time to perform any pending network
 * operations.  Note that this listener only tells you when the network becomes
 * active; if at any other time you want to know whether it is active (and thus okay
 * to initiate network traffic), you can retrieve its instantaneous state with
 * {@link ConnectivityManager#isDefaultNetworkActive}.
 */

public void onNetworkActive();
}

}

