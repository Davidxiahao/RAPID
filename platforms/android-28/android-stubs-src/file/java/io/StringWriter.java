/*
 * Copyright (c) 1996, 2004, Oracle and/or its affiliates. All rights reserved.
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
 * A character stream that collects its output in a string buffer, which can
 * then be used to construct a string.
 * <p>
 * Closing a <tt>StringWriter</tt> has no effect. The methods in this class
 * can be called after the stream has been closed without generating an
 * <tt>IOException</tt>.
 *
 * @author      Mark Reinhold
 * @since       JDK1.1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StringWriter extends java.io.Writer {

/**
 * Create a new string writer using the default initial string-buffer
 * size.
 */

public StringWriter() { throw new RuntimeException("Stub!"); }

/**
 * Create a new string writer using the specified initial string-buffer
 * size.
 *
 * @param initialSize
 *        The number of <tt>char</tt> values that will fit into this buffer
 *        before it is automatically expanded
 *
 * @throws IllegalArgumentException
 *         If <tt>initialSize</tt> is negative
 */

public StringWriter(int initialSize) { throw new RuntimeException("Stub!"); }

/**
 * Write a single character.
 */

public void write(int c) { throw new RuntimeException("Stub!"); }

/**
 * Write a portion of an array of characters.
 *
 * @param  cbuf  Array of characters
 * @param  off   Offset from which to start writing characters
 * @param  len   Number of characters to write
 */

public void write(char[] cbuf, int off, int len) { throw new RuntimeException("Stub!"); }

/**
 * Write a string.
 */

public void write(java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Write a portion of a string.
 *
 * @param  str  String to be written
 * @param  off  Offset from which to start writing characters
 * @param  len  Number of characters to write
 */

public void write(java.lang.String str, int off, int len) { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified character sequence to this writer.
 *
 * <p> An invocation of this method of the form <tt>out.append(csq)</tt>
 * behaves in exactly the same way as the invocation
 *
 * <pre>
 *     out.write(csq.toString()) </pre>
 *
 * <p> Depending on the specification of <tt>toString</tt> for the
 * character sequence <tt>csq</tt>, the entire sequence may not be
 * appended. For instance, invoking the <tt>toString</tt> method of a
 * character buffer will return a subsequence whose content depends upon
 * the buffer's position and limit.
 *
 * @param  csq
 *         The character sequence to append.  If <tt>csq</tt> is
 *         <tt>null</tt>, then the four characters <tt>"null"</tt> are
 *         appended to this writer.
 *
 * @return  This writer
 *
 * @since  1.5
 */

public java.io.StringWriter append(java.lang.CharSequence csq) { throw new RuntimeException("Stub!"); }

/**
 * Appends a subsequence of the specified character sequence to this writer.
 *
 * <p> An invocation of this method of the form <tt>out.append(csq, start,
 * end)</tt> when <tt>csq</tt> is not <tt>null</tt>, behaves in
 * exactly the same way as the invocation
 *
 * <pre>
 *     out.write(csq.subSequence(start, end).toString()) </pre>
 *
 * @param  csq
 *         The character sequence from which a subsequence will be
 *         appended.  If <tt>csq</tt> is <tt>null</tt>, then characters
 *         will be appended as if <tt>csq</tt> contained the four
 *         characters <tt>"null"</tt>.
 *
 * @param  start
 *         The index of the first character in the subsequence
 *
 * @param  end
 *         The index of the character following the last character in the
 *         subsequence
 *
 * @return  This writer
 *
 * @throws  IndexOutOfBoundsException
 *          If <tt>start</tt> or <tt>end</tt> are negative, <tt>start</tt>
 *          is greater than <tt>end</tt>, or <tt>end</tt> is greater than
 *          <tt>csq.length()</tt>
 *
 * @since  1.5
 */

public java.io.StringWriter append(java.lang.CharSequence csq, int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified character to this writer.
 *
 * <p> An invocation of this method of the form <tt>out.append(c)</tt>
 * behaves in exactly the same way as the invocation
 *
 * <pre>
 *     out.write(c) </pre>
 *
 * @param  c
 *         The 16-bit character to append
 *
 * @return  This writer
 *
 * @since 1.5
 */

public java.io.StringWriter append(char c) { throw new RuntimeException("Stub!"); }

/**
 * Return the buffer's current value as a string.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Return the string buffer itself.
 *
 * @return StringBuffer holding the current buffer value.
 */

public java.lang.StringBuffer getBuffer() { throw new RuntimeException("Stub!"); }

/**
 * Flush the stream.
 */

public void flush() { throw new RuntimeException("Stub!"); }

/**
 * Closing a <tt>StringWriter</tt> has no effect. The methods in this
 * class can be called after the stream has been closed without generating
 * an <tt>IOException</tt>.
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

