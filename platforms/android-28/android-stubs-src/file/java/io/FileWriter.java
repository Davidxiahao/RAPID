/*
 * Copyright (c) 1996, 2001, Oracle and/or its affiliates. All rights reserved.
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
 * Convenience class for writing character files.  The constructors of this
 * class assume that the default character encoding and the default byte-buffer
 * size are acceptable.  To specify these values yourself, construct an
 * OutputStreamWriter on a FileOutputStream.
 *
 * <p>Whether or not a file is available or may be created depends upon the
 * underlying platform.  Some platforms, in particular, allow a file to be
 * opened for writing by only one <tt>FileWriter</tt> (or other file-writing
 * object) at a time.  In such situations the constructors in this class
 * will fail if the file involved is already open.
 *
 * <p><code>FileWriter</code> is meant for writing streams of characters.
 * For writing streams of raw bytes, consider using a
 * <code>FileOutputStream</code>.
 *
 * @see OutputStreamWriter
 * @see FileOutputStream
 *
 * @author      Mark Reinhold
 * @since       JDK1.1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class FileWriter extends java.io.OutputStreamWriter {

/**
 * Constructs a FileWriter object given a file name.
 *
 * @param fileName  String The system-dependent filename.
 * @throws IOException  if the named file exists but is a directory rather
 *                  than a regular file, does not exist but cannot be
 *                  created, or cannot be opened for any other reason
 */

public FileWriter(java.lang.String fileName) throws java.io.IOException { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a FileWriter object given a file name with a boolean
 * indicating whether or not to append the data written.
 *
 * @param fileName  String The system-dependent filename.
 * @param append    boolean if <code>true</code>, then data will be written
 *                  to the end of the file rather than the beginning.
 * @throws IOException  if the named file exists but is a directory rather
 *                  than a regular file, does not exist but cannot be
 *                  created, or cannot be opened for any other reason
 */

public FileWriter(java.lang.String fileName, boolean append) throws java.io.IOException { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a FileWriter object given a File object.
 *
 * @param file  a File object to write to.
 * @throws IOException  if the file exists but is a directory rather than
 *                  a regular file, does not exist but cannot be created,
 *                  or cannot be opened for any other reason
 */

public FileWriter(java.io.File file) throws java.io.IOException { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a FileWriter object given a File object. If the second
 * argument is <code>true</code>, then bytes will be written to the end
 * of the file rather than the beginning.
 *
 * @param file  a File object to write to
 * @param     append    if <code>true</code>, then bytes will be written
 *                      to the end of the file rather than the beginning
 * @throws IOException  if the file exists but is a directory rather than
 *                  a regular file, does not exist but cannot be created,
 *                  or cannot be opened for any other reason
 * @since 1.4
 */

public FileWriter(java.io.File file, boolean append) throws java.io.IOException { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a FileWriter object associated with a file descriptor.
 *
 * @param fd  FileDescriptor object to write to.
 */

public FileWriter(java.io.FileDescriptor fd) { super((java.io.OutputStream)null); throw new RuntimeException("Stub!"); }
}

