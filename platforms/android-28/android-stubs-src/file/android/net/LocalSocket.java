/*
 * Copyright (C) 2007 The Android Open Source Project
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

import java.io.FileDescriptor;
import java.io.IOException;

/**
 * Creates a (non-server) socket in the UNIX-domain namespace. The interface
 * here is not entirely unlike that of java.net.Socket. This class and the streams
 * returned from it may be used from multiple threads.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LocalSocket implements java.io.Closeable {

/**
 * Creates a AF_LOCAL/UNIX domain stream socket.
 */

public LocalSocket() { throw new RuntimeException("Stub!"); }

/**
 * Creates a AF_LOCAL/UNIX domain stream socket with given socket type
 *
 * @param sockType either {@link #SOCKET_DGRAM}, {@link #SOCKET_STREAM}
 * or {@link #SOCKET_SEQPACKET}
 */

public LocalSocket(int sockType) { throw new RuntimeException("Stub!"); }

/** {@inheritDoc} */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Connects this socket to an endpoint. May only be called on an instance
 * that has not yet been connected.
 *
 * @param endpoint endpoint address
 * @throws IOException if socket is in invalid state or the address does
 * not exist.
 */

public void connect(android.net.LocalSocketAddress endpoint) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Binds this socket to an endpoint name. May only be called on an instance
 * that has not yet been bound.
 *
 * @param bindpoint endpoint address
 * @throws IOException
 */

public void bind(android.net.LocalSocketAddress bindpoint) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the name that this socket is bound to, if any.
 *
 * @return Local address or null if anonymous
 */

public android.net.LocalSocketAddress getLocalSocketAddress() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the input stream for this instance.
 *
 * @return input stream
 * @throws IOException if socket has been closed or cannot be created.
 */

public java.io.InputStream getInputStream() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the output stream for this instance.
 *
 * @return output stream
 * @throws IOException if socket has been closed or cannot be created.
 */

public java.io.OutputStream getOutputStream() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes the socket.
 *
 * @throws IOException
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Shuts down the input side of the socket.
 *
 * @throws IOException
 */

public void shutdownInput() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Shuts down the output side of the socket.
 *
 * @throws IOException
 */

public void shutdownOutput() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public void setReceiveBufferSize(int size) throws java.io.IOException { throw new RuntimeException("Stub!"); }

public int getReceiveBufferSize() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public void setSoTimeout(int n) throws java.io.IOException { throw new RuntimeException("Stub!"); }

public int getSoTimeout() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public void setSendBufferSize(int n) throws java.io.IOException { throw new RuntimeException("Stub!"); }

public int getSendBufferSize() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public android.net.LocalSocketAddress getRemoteSocketAddress() { throw new RuntimeException("Stub!"); }

public synchronized boolean isConnected() { throw new RuntimeException("Stub!"); }

public boolean isClosed() { throw new RuntimeException("Stub!"); }

public synchronized boolean isBound() { throw new RuntimeException("Stub!"); }

public boolean isOutputShutdown() { throw new RuntimeException("Stub!"); }

public boolean isInputShutdown() { throw new RuntimeException("Stub!"); }

public void connect(android.net.LocalSocketAddress endpoint, int timeout) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Enqueues a set of file descriptors to send to the peer. The queue
 * is one deep. The file descriptors will be sent with the next write
 * of normal data, and will be delivered in a single ancillary message.
 * See "man 7 unix" SCM_RIGHTS on a desktop Linux machine.
 *
 * @param fds non-null; file descriptors to send.
 */

public void setFileDescriptorsForSend(java.io.FileDescriptor[] fds) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves a set of file descriptors that a peer has sent through
 * an ancillary message. This method retrieves the most recent set sent,
 * and then returns null until a new set arrives.
 * File descriptors may only be passed along with regular data, so this
 * method can only return a non-null after a read operation.
 *
 * @return null or file descriptor array
 * @throws IOException
 */

public java.io.FileDescriptor[] getAncillaryFileDescriptors() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the credentials of this socket's peer. Only valid on
 * connected sockets.
 *
 * @return non-null; peer credentials
 * @throws IOException
 */

public android.net.Credentials getPeerCredentials() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns file descriptor or null if not yet open/already closed
 *
 * @return fd or null
 */

public java.io.FileDescriptor getFileDescriptor() { throw new RuntimeException("Stub!"); }

/** Datagram socket type */

public static final int SOCKET_DGRAM = 1; // 0x1

/** Sequential packet socket type */

public static final int SOCKET_SEQPACKET = 3; // 0x3

/** Stream socket type */

public static final int SOCKET_STREAM = 2; // 0x2
}

