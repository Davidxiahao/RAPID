/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.net.rtp;

import java.net.SocketException;

/**
 * RtpStream represents the base class of streams which send and receive network
 * packets with media payloads over Real-time Transport Protocol (RTP).
 *
 * <p class="note">Using this class requires
 * {@link android.Manifest.permission#INTERNET} permission.</p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RtpStream {

/**
 * Creates a RtpStream on the given local address. Note that the local
 * port is assigned automatically to conform with RFC 3550.
 *
 * @param address The network address of the local host to bind to.
 * @throws SocketException if the address cannot be bound or a problem
 *     occurs during binding.
 */

RtpStream(java.net.InetAddress address) throws java.net.SocketException { throw new RuntimeException("Stub!"); }

/**
 * Returns the network address of the local host.
 */

public java.net.InetAddress getLocalAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the network port of the local host.
 */

public int getLocalPort() { throw new RuntimeException("Stub!"); }

/**
 * Returns the network address of the remote host or {@code null} if the
 * stream is not associated.
 */

public java.net.InetAddress getRemoteAddress() { throw new RuntimeException("Stub!"); }

/**
 * Returns the network port of the remote host or {@code -1} if the stream
 * is not associated.
 */

public int getRemotePort() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the stream is busy. In this case most of the
 * setter methods are disabled. This method is intended to be overridden
 * by subclasses.
 */

public boolean isBusy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current mode.
 */

public int getMode() { throw new RuntimeException("Stub!"); }

/**
 * Changes the current mode. It must be one of {@link #MODE_NORMAL},
 * {@link #MODE_SEND_ONLY}, and {@link #MODE_RECEIVE_ONLY}.
 *
 * @param mode The mode to change to.
 * @throws IllegalArgumentException if the mode is invalid.
 * @throws IllegalStateException if the stream is busy.
 * @see #isBusy()
 */

public void setMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Associates with a remote host. This defines the destination of the
 * outgoing packets.
 *
 * @param address The network address of the remote host.
 * @param port The network port of the remote host.
 * @throws IllegalArgumentException if the address is not supported or the
 *     port is invalid.
 * @throws IllegalStateException if the stream is busy.
 * @see #isBusy()
 */

public void associate(java.net.InetAddress address, int port) { throw new RuntimeException("Stub!"); }

/**
 * Releases allocated resources. The stream becomes inoperable after calling
 * this method.
 *
 * @throws IllegalStateException if the stream is busy.
 * @see #isBusy()
 */

public void release() { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * This mode indicates that the stream sends and receives packets at the
 * same time. This is the initial mode for new streams.
 */

public static final int MODE_NORMAL = 0; // 0x0

/**
 * This mode indicates that the stream only receives packets.
 */

public static final int MODE_RECEIVE_ONLY = 2; // 0x2

/**
 * This mode indicates that the stream only sends packets.
 */

public static final int MODE_SEND_ONLY = 1; // 0x1
}

