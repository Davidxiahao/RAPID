/*
 * Copyright (c) 1996, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * A buffered character-input stream that keeps track of line numbers.  This
 * class defines methods {@link #setLineNumber(int)} and {@link
 * #getLineNumber()} for setting and getting the current line number
 * respectively.
 *
 * <p> By default, line numbering begins at 0. This number increments at every
 * <a href="#lt">line terminator</a> as the data is read, and can be changed
 * with a call to <tt>setLineNumber(int)</tt>.  Note however, that
 * <tt>setLineNumber(int)</tt> does not actually change the current position in
 * the stream; it only changes the value that will be returned by
 * <tt>getLineNumber()</tt>.
 *
 * <p> A line is considered to be <a name="lt">terminated</a> by any one of a
 * line feed ('\n'), a carriage return ('\r'), or a carriage return followed
 * immediately by a linefeed.
 *
 * @author      Mark Reinhold
 * @since       JDK1.1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LineNumberReader extends java.io.BufferedReader {

/**
 * Create a new line-numbering reader, using the default input-buffer
 * size.
 *
 * @param  in
 *         A Reader object to provide the underlying stream
 */

public LineNumberReader(java.io.Reader in) { super((java.io.Reader)null); throw new RuntimeException("Stub!"); }

/**
 * Create a new line-numbering reader, reading characters into a buffer of
 * the given size.
 *
 * @param  in
 *         A Reader object to provide the underlying stream
 *
 * @param  sz
 *         An int specifying the size of the buffer
 */

public LineNumberReader(java.io.Reader in, int sz) { super((java.io.Reader)null); throw new RuntimeException("Stub!"); }

/**
 * Set the current line number.
 *
 * @param  lineNumber
 *         An int specifying the line number
 *
 * @see #getLineNumber
 */

public void setLineNumber(int lineNumber) { throw new RuntimeException("Stub!"); }

/**
 * Get the current line number.
 *
 * @return  The current line number
 *
 * @see #setLineNumber
 */

public int getLineNumber() { throw new RuntimeException("Stub!"); }

/**
 * Read a single character.  <a href="#lt">Line terminators</a> are
 * compressed into single newline ('\n') characters.  Whenever a line
 * terminator is read the current line number is incremented.
 *
 * @return  The character read, or -1 if the end of the stream has been
 *          reached
 *
 * @throws  IOException
 *          If an I/O error occurs
 */

public int read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Read characters into a portion of an array.  Whenever a <a
 * href="#lt">line terminator</a> is read the current line number is
 * incremented.
 *
 * @param  cbuf
 *         Destination buffer
 *
 * @param  off
 *         Offset at which to start storing characters
 *
 * @param  len
 *         Maximum number of characters to read
 *
 * @return  The number of bytes read, or -1 if the end of the stream has
 *          already been reached
 *
 * @throws  IOException
 *          If an I/O error occurs
 */

public int read(char[] cbuf, int off, int len) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Read a line of text.  Whenever a <a href="#lt">line terminator</a> is
 * read the current line number is incremented.
 *
 * @return  A String containing the contents of the line, not including
 *          any <a href="#lt">line termination characters</a>, or
 *          <tt>null</tt> if the end of the stream has been reached
 *
 * @throws  IOException
 *          If an I/O error occurs
 */

public java.lang.String readLine() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Skip characters.
 *
 * @param  n
 *         The number of characters to skip
 *
 * @return  The number of characters actually skipped
 *
 * @throws  IOException
 *          If an I/O error occurs
 *
 * @throws  IllegalArgumentException
 *          If <tt>n</tt> is negative
 */

public long skip(long n) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Mark the present position in the stream.  Subsequent calls to reset()
 * will attempt to reposition the stream to this point, and will also reset
 * the line number appropriately.
 *
 * @param  readAheadLimit
 *         Limit on the number of characters that may be read while still
 *         preserving the mark.  After reading this many characters,
 *         attempting to reset the stream may fail.
 *
 * @throws  IOException
 *          If an I/O error occurs
 */

public void mark(int readAheadLimit) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reset the stream to the most recent mark.
 *
 * @throws  IOException
 *          If the stream has not been marked, or if the mark has been
 *          invalidated
 */

public void reset() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

