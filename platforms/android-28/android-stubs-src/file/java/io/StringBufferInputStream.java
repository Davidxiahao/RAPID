/*
 * Copyright (c) 1995, 2004, Oracle and/or its affiliates. All rights reserved.
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
 * This class allows an application to create an input stream in
 * which the bytes read are supplied by the contents of a string.
 * Applications can also read bytes from a byte array by using a
 * <code>ByteArrayInputStream</code>.
 * <p>
 * Only the low eight bits of each character in the string are used by
 * this class.
 *
 * @author     Arthur van Hoff
 * @see        java.io.ByteArrayInputStream
 * @see        java.io.StringReader
 * @since      JDK1.0
 * @deprecated This class does not properly convert characters into bytes.  As
 *             of JDK&nbsp;1.1, the preferred way to create a stream from a
 *             string is via the <code>StringReader</code> class.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public class StringBufferInputStream extends java.io.InputStream {

/**
 * Creates a string input stream to read data from the specified string.
 *
 * @param      s   the underlying input buffer.
 */

public StringBufferInputStream(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Reads the next byte of data from this input stream. The value
 * byte is returned as an <code>int</code> in the range
 * <code>0</code> to <code>255</code>. If no byte is available
 * because the end of the stream has been reached, the value
 * <code>-1</code> is returned.
 * <p>
 * The <code>read</code> method of
 * <code>StringBufferInputStream</code> cannot block. It returns the
 * low eight bits of the next character in this input stream's buffer.
 *
 * @return     the next byte of data, or <code>-1</code> if the end of the
 *             stream is reached.
 */

public synchronized int read() { throw new RuntimeException("Stub!"); }

/**
 * Reads up to <code>len</code> bytes of data from this input stream
 * into an array of bytes.
 * <p>
 * The <code>read</code> method of
 * <code>StringBufferInputStream</code> cannot block. It copies the
 * low eight bits from the characters in this input stream's buffer into
 * the byte array argument.
 *
 * @param      b     the buffer into which the data is read.
 * @param      off   the start offset of the data.
 * @param      len   the maximum number of bytes read.
 * @return     the total number of bytes read into the buffer, or
 *             <code>-1</code> if there is no more data because the end of
 *             the stream has been reached.
 */

public synchronized int read(byte[] b, int off, int len) { throw new RuntimeException("Stub!"); }

/**
 * Skips <code>n</code> bytes of input from this input stream. Fewer
 * bytes might be skipped if the end of the input stream is reached.
 *
 * @param      n   the number of bytes to be skipped.
 * @return     the actual number of bytes skipped.
 */

public synchronized long skip(long n) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of bytes that can be read from the input
 * stream without blocking.
 *
 * @return     the value of <code>count&nbsp;-&nbsp;pos</code>, which is the
 *             number of bytes remaining to be read from the input buffer.
 */

public synchronized int available() { throw new RuntimeException("Stub!"); }

/**
 * Resets the input stream to begin reading from the first character
 * of this input stream's underlying buffer.
 */

public synchronized void reset() { throw new RuntimeException("Stub!"); }

/**
 * The string from which bytes are read.
 */

protected java.lang.String buffer;

/**
 * The number of valid characters in the input stream buffer.
 *
 * @see        java.io.StringBufferInputStream#buffer
 */

protected int count;

/**
 * The index of the next character to read from the input stream buffer.
 *
 * @see        java.io.StringBufferInputStream#buffer
 */

protected int pos;
}

