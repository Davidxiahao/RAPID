/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.io;


/**
 * A character stream whose source is a string.
 *
 * @author      Mark Reinhold
 * @since       JDK1.1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StringReader extends java.io.Reader {

/**
 * Creates a new string reader.
 *
 * @param s  String providing the character stream.
 */

public StringReader(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Reads a single character.
 *
 * @return     The character read, or -1 if the end of the stream has been
 *             reached
 *
 * @exception  IOException  If an I/O error occurs
 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads characters into a portion of an array.
 *
 * @param      cbuf  Destination buffer
 * @param      off   Offset at which to start writing characters
 * @param      len   Maximum number of characters to read
 *
 * @return     The number of characters read, or -1 if the end of the
 *             stream has been reached
 *
 * @exception  IOException  If an I/O error occurs
 */

public int read(char[] cbuf, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Skips the specified number of characters in the stream. Returns
 * the number of characters that were skipped.
 *
 * <p>The <code>ns</code> parameter may be negative, even though the
 * <code>skip</code> method of the {@link Reader} superclass throws
 * an exception in this case. Negative values of <code>ns</code> cause the
 * stream to skip backwards. Negative return values indicate a skip
 * backwards. It is not possible to skip backwards past the beginning of
 * the string.
 *
 * <p>If the entire string has been read or skipped, then this method has
 * no effect and always returns 0.
 *
 * @exception  IOException  If an I/O error occurs
 */

public long skip(long ns) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tells whether this stream is ready to be read.
 *
 * @return True if the next read() is guaranteed not to block for input
 *
 * @exception  IOException  If the stream is closed
 */

public boolean ready() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Tells whether this stream supports the mark() operation, which it does.
 */

public boolean markSupported() { throw new RuntimeException("Stub!"); }

/**
 * Marks the present position in the stream.  Subsequent calls to reset()
 * will reposition the stream to this point.
 *
 * @param  readAheadLimit  Limit on the number of characters that may be
 *                         read while still preserving the mark.  Because
 *                         the stream's input comes from a string, there
 *                         is no actual limit, so this argument must not
 *                         be negative, but is otherwise ignored.
 *
 * @exception  IllegalArgumentException  If {@code readAheadLimit < 0}
 * @exception  IOException  If an I/O error occurs
 */

public void mark(int readAheadLimit) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Resets the stream to the most recent mark, or to the beginning of the
 * string if it has never been marked.
 *
 * @exception  IOException  If an I/O error occurs
 */

public void reset() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Closes the stream and releases any system resources associated with
 * it. Once the stream has been closed, further read(),
 * ready(), mark(), or reset() invocations will throw an IOException.
 * Closing a previously closed stream has no effect.
 */

public void close() { throw new RuntimeException("Stub!"); }
}

