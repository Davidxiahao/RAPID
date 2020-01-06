/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1995, 2015, Oracle and/or its affiliates. All rights reserved.
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


package java.util.zip;

import java.nio.charset.Charset;
import java.io.IOException;
import java.io.File;
import java.util.stream.Stream;
import java.io.InputStream;

/**
 * This class is used to read entries from a zip file.
 *
 * <p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor
 * or method in this class will cause a {@link NullPointerException} to be
 * thrown.
 *
 * @author      David Connelly
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ZipFile implements java.io.Closeable {

/**
 * Opens a zip file for reading.
 *
 * <p>First, if there is a security manager, its <code>checkRead</code>
 * method is called with the <code>name</code> argument as its argument
 * to ensure the read is allowed.
 *
 * <p>The UTF-8 {@link java.nio.charset.Charset charset} is used to
 * decode the entry names and comments.
 *
 * @param name the name of the zip file
 * @throws ZipException if a ZIP format error has occurred
 * @throws IOException if an I/O error has occurred
 * @throws SecurityException if a security manager exists and its
 *         <code>checkRead</code> method doesn't allow read access to the file.
 *
 * @see SecurityManager#checkRead(java.lang.String)
 */

public ZipFile(java.lang.String name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens a new <code>ZipFile</code> to read from the specified
 * <code>File</code> object in the specified mode.  The mode argument
 * must be either <tt>OPEN_READ</tt> or <tt>OPEN_READ | OPEN_DELETE</tt>.
 *
 * <p>First, if there is a security manager, its <code>checkRead</code>
 * method is called with the <code>name</code> argument as its argument to
 * ensure the read is allowed.
 *
 * <p>The UTF-8 {@link java.nio.charset.Charset charset} is used to
 * decode the entry names and comments
 *
 * @param file the ZIP file to be opened for reading
 * @param mode the mode in which the file is to be opened
 * @throws ZipException if a ZIP format error has occurred
 * @throws IOException if an I/O error has occurred
 * @throws SecurityException if a security manager exists and
 *         its <code>checkRead</code> method
 *         doesn't allow read access to the file,
 *         or its <code>checkDelete</code> method doesn't allow deleting
 *         the file when the <tt>OPEN_DELETE</tt> flag is set.
 * @throws IllegalArgumentException if the <tt>mode</tt> argument is invalid
 * @see SecurityManager#checkRead(java.lang.String)
 * @since 1.3
 */

public ZipFile(java.io.File file, int mode) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens a ZIP file for reading given the specified File object.
 *
 * <p>The UTF-8 {@link java.nio.charset.Charset charset} is used to
 * decode the entry names and comments.
 *
 * @param file the ZIP file to be opened for reading
 * @throws ZipException if a ZIP format error has occurred
 * @throws IOException if an I/O error has occurred
 */

public ZipFile(java.io.File file) throws java.io.IOException, java.util.zip.ZipException { throw new RuntimeException("Stub!"); }

/**
 * Opens a new <code>ZipFile</code> to read from the specified
 * <code>File</code> object in the specified mode.  The mode argument
 * must be either <tt>OPEN_READ</tt> or <tt>OPEN_READ | OPEN_DELETE</tt>.
 *
 * <p>First, if there is a security manager, its <code>checkRead</code>
 * method is called with the <code>name</code> argument as its argument to
 * ensure the read is allowed.
 *
 * @param file the ZIP file to be opened for reading
 * @param mode the mode in which the file is to be opened
 * @param charset
 *        the {@linkplain java.nio.charset.Charset charset} to
 *        be used to decode the ZIP entry name and comment that are not
 *        encoded by using UTF-8 encoding (indicated by entry's general
 *        purpose flag).
 *
 * @throws ZipException if a ZIP format error has occurred
 * @throws IOException if an I/O error has occurred
 *
 * @throws SecurityException
 *         if a security manager exists and its <code>checkRead</code>
 *         method doesn't allow read access to the file,or its
 *         <code>checkDelete</code> method doesn't allow deleting the
 *         file when the <tt>OPEN_DELETE</tt> flag is set
 *
 * @throws IllegalArgumentException if the <tt>mode</tt> argument is invalid
 *
 * @see SecurityManager#checkRead(java.lang.String)
 *
 * @since 1.7
 */

public ZipFile(java.io.File file, int mode, java.nio.charset.Charset charset) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens a zip file for reading.
 *
 * <p>First, if there is a security manager, its <code>checkRead</code>
 * method is called with the <code>name</code> argument as its argument
 * to ensure the read is allowed.
 *
 * @param name the name of the zip file
 * @param charset
 *        the {@linkplain java.nio.charset.Charset charset} to
 *        be used to decode the ZIP entry name and comment that are not
 *        encoded by using UTF-8 encoding (indicated by entry's general
 *        purpose flag).
 *
 * @throws ZipException if a ZIP format error has occurred
 * @throws IOException if an I/O error has occurred
 * @throws SecurityException
 *         if a security manager exists and its <code>checkRead</code>
 *         method doesn't allow read access to the file
 *
 * @see SecurityManager#checkRead(java.lang.String)
 *
 * @since 1.7
 */

public ZipFile(java.lang.String name, java.nio.charset.Charset charset) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Opens a ZIP file for reading given the specified File object.
 * @param file the ZIP file to be opened for reading
 * @param charset
 *        The {@linkplain java.nio.charset.Charset charset} to be
 *        used to decode the ZIP entry name and comment (ignored if
 *        the <a href="package-summary.html#lang_encoding"> language
 *        encoding bit</a> of the ZIP entry's general purpose bit
 *        flag is set).
 *
 * @throws ZipException if a ZIP format error has occurred
 * @throws IOException if an I/O error has occurred
 *
 * @since 1.7
 */

public ZipFile(java.io.File file, java.nio.charset.Charset charset) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the zip file comment, or null if none.
 *
 * @return the comment string for the zip file, or null if none
 *
 * @throws IllegalStateException if the zip file has been closed
 *
 * Since 1.7
 */

public java.lang.String getComment() { throw new RuntimeException("Stub!"); }

/**
 * Returns the zip file entry for the specified name, or null
 * if not found.
 *
 * @param name the name of the entry
 * @return the zip file entry, or null if not found
 * @throws IllegalStateException if the zip file has been closed
 */

public java.util.zip.ZipEntry getEntry(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns an input stream for reading the contents of the specified
 * zip file entry.
 *
 * <p> Closing this ZIP file will, in turn, close all input
 * streams that have been returned by invocations of this method.
 *
 * @param entry the zip file entry
 * @return the input stream for reading the contents of the specified
 * zip file entry.
 * @throws ZipException if a ZIP format error has occurred
 * @throws IOException if an I/O error has occurred
 * @throws IllegalStateException if the zip file has been closed
 */

public java.io.InputStream getInputStream(java.util.zip.ZipEntry entry) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the path name of the ZIP file.
 * @return the path name of the ZIP file
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns an enumeration of the ZIP file entries.
 * @return an enumeration of the ZIP file entries
 * @throws IllegalStateException if the zip file has been closed
 */

public java.util.Enumeration<? extends java.util.zip.ZipEntry> entries() { throw new RuntimeException("Stub!"); }

/**
 * Return an ordered {@code Stream} over the ZIP file entries.
 * Entries appear in the {@code Stream} in the order they appear in
 * the central directory of the ZIP file.
 *
 * @return an ordered {@code Stream} of entries in this ZIP file
 * @throws IllegalStateException if the zip file has been closed
 * @since 1.8
 */

public java.util.stream.Stream<? extends java.util.zip.ZipEntry> stream() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of entries in the ZIP file.
 * @return the number of entries in the ZIP file
 * @throws IllegalStateException if the zip file has been closed
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Closes the ZIP file.
 * <p> Closing this ZIP file will close all of the input streams
 * previously returned by invocations of the {@link #getInputStream
 * getInputStream} method.
 *
 * @throws IOException if an I/O error has occurred
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Ensures that the system resources held by this ZipFile object are
 * released when there are no more references to it.
 *
 * <p>
 * Since the time when GC would invoke this method is undetermined,
 * it is strongly recommended that applications invoke the <code>close</code>
 * method as soon they have finished accessing this <code>ZipFile</code>.
 * This will prevent holding up system resources for an undetermined
 * length of time.
 *
 * @throws IOException if an I/O error has occurred
 * @see    java.util.zip.ZipFile#close()
 */

protected void finalize() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public static final int CENATT = 36; // 0x24

public static final int CENATX = 38; // 0x26

public static final int CENCOM = 32; // 0x20

public static final int CENCRC = 16; // 0x10

public static final int CENDSK = 34; // 0x22

public static final int CENEXT = 30; // 0x1e

public static final int CENFLG = 8; // 0x8

public static final int CENHDR = 46; // 0x2e

public static final int CENHOW = 10; // 0xa

public static final int CENLEN = 24; // 0x18

public static final int CENNAM = 28; // 0x1c

public static final int CENOFF = 42; // 0x2a

public static final long CENSIG = 33639248L; // 0x2014b50L

public static final int CENSIZ = 20; // 0x14

public static final int CENTIM = 12; // 0xc

public static final int CENVEM = 4; // 0x4

public static final int CENVER = 6; // 0x6

public static final int ENDCOM = 20; // 0x14

public static final int ENDHDR = 22; // 0x16

public static final int ENDOFF = 16; // 0x10

public static final long ENDSIG = 101010256L; // 0x6054b50L

public static final int ENDSIZ = 12; // 0xc

public static final int ENDSUB = 8; // 0x8

public static final int ENDTOT = 10; // 0xa

public static final int EXTCRC = 4; // 0x4

public static final int EXTHDR = 16; // 0x10

public static final int EXTLEN = 12; // 0xc

public static final long EXTSIG = 134695760L; // 0x8074b50L

public static final int EXTSIZ = 8; // 0x8

public static final int LOCCRC = 14; // 0xe

public static final int LOCEXT = 28; // 0x1c

public static final int LOCFLG = 6; // 0x6

public static final int LOCHDR = 30; // 0x1e

public static final int LOCHOW = 8; // 0x8

public static final int LOCLEN = 22; // 0x16

public static final int LOCNAM = 26; // 0x1a

public static final long LOCSIG = 67324752L; // 0x4034b50L

public static final int LOCSIZ = 18; // 0x12

public static final int LOCTIM = 10; // 0xa

public static final int LOCVER = 4; // 0x4

/**
 * Mode flag to open a zip file and mark it for deletion.  The file will be
 * deleted some time between the moment that it is opened and the moment
 * that it is closed, but its contents will remain accessible via the
 * <tt>ZipFile</tt> object until either the close method is invoked or the
 * virtual machine exits.
 */

public static final int OPEN_DELETE = 4; // 0x4

/**
 * Mode flag to open a zip file for reading.
 */

public static final int OPEN_READ = 1; // 0x1
}

