/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */


package javax.net.ssl;


/**
 * An encapsulation of the result state produced by
 * <code>SSLEngine</code> I/O calls.
 *
 * <p> A <code>SSLEngine</code> provides a means for establishing
 * secure communication sessions between two peers.  <code>SSLEngine</code>
 * operations typically consume bytes from an input buffer and produce
 * bytes in an output buffer.  This class provides operational result
 * values describing the state of the <code>SSLEngine</code>, including
 * indications of what operations are needed to finish an
 * ongoing handshake.  Lastly, it reports the number of bytes consumed
 * and produced as a result of this operation.
 *
 * @see SSLEngine
 * @see SSLEngine#wrap(ByteBuffer, ByteBuffer)
 * @see SSLEngine#unwrap(ByteBuffer, ByteBuffer)
 *
 * @author Brad R. Wetmore
 * @since 1.5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SSLEngineResult {

/**
 * Initializes a new instance of this class.
 *
 * @param   status
 *          the return value of the operation.
 *
 * @param   handshakeStatus
 *          the current handshaking status.
 *
 * @param   bytesConsumed
 *          the number of bytes consumed from the source ByteBuffer
 *
 * @param   bytesProduced
 *          the number of bytes placed into the destination ByteBuffer
 *
 * @throws  IllegalArgumentException
 *          if the <code>status</code> or <code>handshakeStatus</code>
 *          arguments are null, or if <code>bytesConsumed</code> or
 *          <code>bytesProduced</code> is negative.
 */

public SSLEngineResult(javax.net.ssl.SSLEngineResult.Status status, javax.net.ssl.SSLEngineResult.HandshakeStatus handshakeStatus, int bytesConsumed, int bytesProduced) { throw new RuntimeException("Stub!"); }

/**
 * Gets the return value of this <code>SSLEngine</code> operation.
 *
 * @return  the return value
 */

public final javax.net.ssl.SSLEngineResult.Status getStatus() { throw new RuntimeException("Stub!"); }

/**
 * Gets the handshake status of this <code>SSLEngine</code>
 * operation.
 *
 * @return  the handshake status
 */

public final javax.net.ssl.SSLEngineResult.HandshakeStatus getHandshakeStatus() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of bytes consumed from the input buffer.
 *
 * @return  the number of bytes consumed.
 */

public final int bytesConsumed() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of bytes written to the output buffer.
 *
 * @return  the number of bytes produced
 */

public final int bytesProduced() { throw new RuntimeException("Stub!"); }

/**
 * Returns a String representation of this object.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/**
 * An <code>SSLEngineResult</code> enum describing the current
 * handshaking state of this <code>SSLEngine</code>.
 *
 * @author Brad R. Wetmore
 * @since 1.5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum HandshakeStatus {
NOT_HANDSHAKING, FINISHED, NEED_TASK, NEED_WRAP, NEED_UNWRAP;
}

/**
 * An <code>SSLEngineResult</code> enum describing the overall result
 * of the <code>SSLEngine</code> operation.
 *
 * The <code>Status</code> value does not reflect the
 * state of a <code>SSLEngine</code> handshake currently
 * in progress.  The <code>SSLEngineResult's HandshakeStatus</code>
 * should be consulted for that information.
 *
 * @author Brad R. Wetmore
 * @since 1.5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Status {
BUFFER_UNDERFLOW, BUFFER_OVERFLOW, OK, CLOSED;
}

}

