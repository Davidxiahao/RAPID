/*
 * Copyright (c) 2007, 2011, Oracle and/or its affiliates. All rights reserved.
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


package java.nio.file;


/**
 * A simple visitor of files with default behavior to visit all files and to
 * re-throw I/O errors.
 *
 * <p> Methods in this class may be overridden subject to their general contract.
 *
 * @param   <T>     The type of reference to the files
 *
 * @since 1.7
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SimpleFileVisitor<T> implements java.nio.file.FileVisitor<T> {

/**
 * Initializes a new instance of this class.
 */

protected SimpleFileVisitor() { throw new RuntimeException("Stub!"); }

/**
 * Invoked for a directory before entries in the directory are visited.
 *
 * <p> Unless overridden, this method returns {@link FileVisitResult#CONTINUE
 * CONTINUE}.
 */

public java.nio.file.FileVisitResult preVisitDirectory(T dir, java.nio.file.attribute.BasicFileAttributes attrs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Invoked for a file in a directory.
 *
 * <p> Unless overridden, this method returns {@link FileVisitResult#CONTINUE
 * CONTINUE}.
 */

public java.nio.file.FileVisitResult visitFile(T file, java.nio.file.attribute.BasicFileAttributes attrs) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Invoked for a file that could not be visited.
 *
 * <p> Unless overridden, this method re-throws the I/O exception that prevented
 * the file from being visited.
 */

public java.nio.file.FileVisitResult visitFileFailed(T file, java.io.IOException exc) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Invoked for a directory after entries in the directory, and all of their
 * descendants, have been visited.
 *
 * <p> Unless overridden, this method returns {@link FileVisitResult#CONTINUE
 * CONTINUE} if the directory iteration completes without an I/O exception;
 * otherwise this method re-throws the I/O exception that caused the iteration
 * of the directory to terminate prematurely.
 */

public java.nio.file.FileVisitResult postVisitDirectory(T dir, java.io.IOException exc) throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

