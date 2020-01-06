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


package android.net;

import javax.net.SocketFactory;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.DatagramSocket;
import java.io.FileDescriptor;

/**
 * Identifies a {@code Network}.  This is supplied to applications via
 * {@link ConnectivityManager.NetworkCallback} in response to the active
 * {@link ConnectivityManager#requestNetwork} or passive
 * {@link ConnectivityManager#registerNetworkCallback} calls.
 * It is used to direct traffic to the given {@code Network}, either on a {@link Socket} basis
 * through a targeted {@link SocketFactory} or process-wide via
 * {@link ConnectivityManager#bindProcessToNetwork}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Network implements android.os.Parcelable {

/**
 * @hide
 */

Network(int netId) { throw new RuntimeException("Stub!"); }

/**
 * Operates the same as {@code InetAddress.getAllByName} except that host
 * resolution is done on this network.
 *
 * @param host the hostname or literal IP string to be resolved.
 * @return the array of addresses associated with the specified host.
 * @throws UnknownHostException if the address lookup fails.
 */

public java.net.InetAddress[] getAllByName(java.lang.String host) throws java.net.UnknownHostException { throw new RuntimeException("Stub!"); }

/**
 * Operates the same as {@code InetAddress.getByName} except that host
 * resolution is done on this network.
 *
 * @param host
 *            the hostName to be resolved to an address or {@code null}.
 * @return the {@code InetAddress} instance representing the host.
 * @throws UnknownHostException
 *             if the address lookup fails.
 */

public java.net.InetAddress getByName(java.lang.String host) throws java.net.UnknownHostException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link SocketFactory} bound to this network.  Any {@link Socket} created by
 * this factory will have its traffic sent over this {@code Network}.  Note that if this
 * {@code Network} ever disconnects, this factory and any {@link Socket} it produced in the
 * past or future will cease to work.
 *
 * @return a {@link SocketFactory} which produces {@link Socket} instances bound to this
 *         {@code Network}.
 */

public javax.net.SocketFactory getSocketFactory() { throw new RuntimeException("Stub!"); }

/**
 * Opens the specified {@link URL} on this {@code Network}, such that all traffic will be sent
 * on this Network. The URL protocol must be {@code HTTP} or {@code HTTPS}.
 *
 * @return a {@code URLConnection} to the resource referred to by this URL.
 * @throws MalformedURLException if the URL protocol is not HTTP or HTTPS.
 * @throws IOException if an error occurs while opening the connection.
 * @see java.net.URL#openConnection()
 */

public java.net.URLConnection openConnection(java.net.URL url) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens the specified {@link URL} on this {@code Network}, such that all traffic will be sent
 * on this Network. The URL protocol must be {@code HTTP} or {@code HTTPS}.
 *
 * @param proxy the proxy through which the connection will be established.
 * @return a {@code URLConnection} to the resource referred to by this URL.
 * @throws MalformedURLException if the URL protocol is not HTTP or HTTPS.
 * @throws IllegalArgumentException if the argument proxy is null.
 * @throws IOException if an error occurs while opening the connection.
 * @see java.net.URL#openConnection()
 */

public java.net.URLConnection openConnection(java.net.URL url, java.net.Proxy proxy) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Binds the specified {@link DatagramSocket} to this {@code Network}. All data traffic on the
 * socket will be sent on this {@code Network}, irrespective of any process-wide network binding
 * set by {@link ConnectivityManager#bindProcessToNetwork}. The socket must not be
 * connected.
 */

public void bindSocket(java.net.DatagramSocket socket) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Binds the specified {@link Socket} to this {@code Network}. All data traffic on the socket
 * will be sent on this {@code Network}, irrespective of any process-wide network binding set by
 * {@link ConnectivityManager#bindProcessToNetwork}. The socket must not be connected.
 */

public void bindSocket(java.net.Socket socket) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Binds the specified {@link FileDescriptor} to this {@code Network}. All data traffic on the
 * socket represented by this file descriptor will be sent on this {@code Network},
 * irrespective of any process-wide network binding set by
 * {@link ConnectivityManager#bindProcessToNetwork}. The socket must not be connected.
 */

public void bindSocket(java.io.FileDescriptor fd) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Network} object given a handle returned from {@link #getNetworkHandle}.
 *
 * @param networkHandle a handle returned from {@link #getNetworkHandle}.
 * @return A {@link Network} object derived from {@code networkHandle}.
 */

public static android.net.Network fromNetworkHandle(long networkHandle) { throw new RuntimeException("Stub!"); }

/**
 * Returns a handle representing this {@code Network}, for use with the NDK API.
 */

public long getNetworkHandle() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.net.Network> CREATOR;
static { CREATOR = null; }
}

