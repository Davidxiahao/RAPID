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


package android.bluetooth;

import java.io.IOException;

/**
 * A listening Bluetooth socket.
 *
 * <p>The interface for Bluetooth Sockets is similar to that of TCP sockets:
 * {@link java.net.Socket} and {@link java.net.ServerSocket}. On the server
 * side, use a {@link BluetoothServerSocket} to create a listening server
 * socket. When a connection is accepted by the {@link BluetoothServerSocket},
 * it will return a new {@link BluetoothSocket} to manage the connection.
 * On the client side, use a single {@link BluetoothSocket} to both initiate
 * an outgoing connection and to manage the connection.
 *
 * <p>The most common type of Bluetooth socket is RFCOMM, which is the type
 * supported by the Android APIs. RFCOMM is a connection-oriented, streaming
 * transport over Bluetooth. It is also known as the Serial Port Profile (SPP).
 *
 * <p>To create a listening {@link BluetoothServerSocket} that's ready for
 * incoming connections, use
 * {@link BluetoothAdapter#listenUsingRfcommWithServiceRecord
 * BluetoothAdapter.listenUsingRfcommWithServiceRecord()}. Then call
 * {@link #accept()} to listen for incoming connection requests. This call
 * will block until a connection is established, at which point, it will return
 * a {@link BluetoothSocket} to manage the connection. Once the {@link
 * BluetoothSocket} is acquired, it's a good idea to call {@link #close()} on
 * the {@link BluetoothServerSocket} when it's no longer needed for accepting
 * connections. Closing the {@link BluetoothServerSocket} will <em>not</em>
 * close the returned {@link BluetoothSocket}.
 *
 * <p>{@link BluetoothServerSocket} is thread
 * safe. In particular, {@link #close} will always immediately abort ongoing
 * operations and close the server socket.
 *
 * <p class="note"><strong>Note:</strong>
 * Requires the {@link android.Manifest.permission#BLUETOOTH} permission.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using Bluetooth, read the
 * <a href="{@docRoot}guide/topics/connectivity/bluetooth.html">Bluetooth</a> developer guide.</p>
 * </div>
 *
 * {@see BluetoothSocket}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothServerSocket implements java.io.Closeable {

/**
 * Construct a socket for incoming connections.
 *
 * @param type type of socket
 * @param auth require the remote device to be authenticated
 * @param encrypt require the connection to be encrypted
 * @param port remote port
 * @throws IOException On error, for example Bluetooth not available, or insufficient
 * privileges
 */

BluetoothServerSocket(int type, boolean auth, boolean encrypt, int port) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Block until a connection is established.
 * <p>Returns a connected {@link BluetoothSocket} on successful connection.
 * <p>Once this call returns, it can be called again to accept subsequent
 * incoming connections.
 * <p>{@link #close} can be used to abort this call from another thread.
 *
 * @return a connected {@link BluetoothSocket}
 * @throws IOException on error, for example this call was aborted, or timeout
 */

public android.bluetooth.BluetoothSocket accept() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Block until a connection is established, with timeout.
 * <p>Returns a connected {@link BluetoothSocket} on successful connection.
 * <p>Once this call returns, it can be called again to accept subsequent
 * incoming connections.
 * <p>{@link #close} can be used to abort this call from another thread.
 *
 * @return a connected {@link BluetoothSocket}
 * @throws IOException on error, for example this call was aborted, or timeout
 */

public android.bluetooth.BluetoothSocket accept(int timeout) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Immediately close this socket, and release all associated resources.
 * <p>Causes blocked calls on this socket in other threads to immediately
 * throw an IOException.
 * <p>Closing the {@link BluetoothServerSocket} will <em>not</em>
 * close any {@link BluetoothSocket} received from {@link #accept()}.
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

