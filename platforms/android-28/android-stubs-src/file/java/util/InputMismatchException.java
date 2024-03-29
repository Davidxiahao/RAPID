/*
 * Copyright (c) 2003, 2008, Oracle and/or its affiliates. All rights reserved.
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


package java.util;


/**
 * Thrown by a <code>Scanner</code> to indicate that the token
 * retrieved does not match the pattern for the expected type, or
 * that the token is out of range for the expected type.
 *
 * @author  unascribed
 * @see     java.util.Scanner
 * @since   1.5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InputMismatchException extends java.util.NoSuchElementException {

/**
 * Constructs an <code>InputMismatchException</code> with <tt>null</tt>
 * as its error message string.
 */

public InputMismatchException() { throw new RuntimeException("Stub!"); }

/**
 * Constructs an <code>InputMismatchException</code>, saving a reference
 * to the error message string <tt>s</tt> for later retrieval by the
 * <tt>getMessage</tt> method.
 *
 * @param   s   the detail message.
 */

public InputMismatchException(java.lang.String s) { throw new RuntimeException("Stub!"); }
}

