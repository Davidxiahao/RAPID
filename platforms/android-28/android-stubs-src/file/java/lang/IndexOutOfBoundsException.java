/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
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


package java.lang;


/**
 * Thrown to indicate that an index of some sort (such as to an array, to a
 * string, or to a vector) is out of range.
 * <p>
 * Applications can subclass this class to indicate similar exceptions.
 *
 * @author  Frank Yellin
 * @since   JDK1.0
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class IndexOutOfBoundsException extends java.lang.RuntimeException {

/**
 * Constructs an <code>IndexOutOfBoundsException</code> with no
 * detail message.
 */

public IndexOutOfBoundsException() { throw new RuntimeException("Stub!"); }

/**
 * Constructs an <code>IndexOutOfBoundsException</code> with the
 * specified detail message.
 *
 * @param   s   the detail message.
 */

public IndexOutOfBoundsException(java.lang.String s) { throw new RuntimeException("Stub!"); }
}

