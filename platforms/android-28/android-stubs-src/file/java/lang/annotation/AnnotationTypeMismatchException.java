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


package java.lang.annotation;

import java.lang.reflect.Method;

/**
 * Thrown to indicate that a program has attempted to access an element of
 * an annotation whose type has changed after the annotation was compiled
 * (or serialized).
 * This exception can be thrown by the {@linkplain
 * java.lang.reflect.AnnotatedElement API used to read annotations
 * reflectively}.
 *
 * @author  Josh Bloch
 * @see     java.lang.reflect.AnnotatedElement
 * @since 1.5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AnnotationTypeMismatchException extends java.lang.RuntimeException {

/**
 * Constructs an AnnotationTypeMismatchException for the specified
 * annotation type element and found data type.
 *
 * @param element the <tt>Method</tt> object for the annotation element
 * @param foundType the (erroneous) type of data found in the annotation.
 *        This string may, but is not required to, contain the value
 *        as well.  The exact format of the string is unspecified.
 */

public AnnotationTypeMismatchException(java.lang.reflect.Method element, java.lang.String foundType) { throw new RuntimeException("Stub!"); }

/**
 * Returns the <tt>Method</tt> object for the incorrectly typed element.
 *
 * @return the <tt>Method</tt> object for the incorrectly typed element
 */

public java.lang.reflect.Method element() { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of data found in the incorrectly typed element.
 * The returned string may, but is not required to, contain the value
 * as well.  The exact format of the string is unspecified.
 *
 * @return the type of data found in the incorrectly typed element
 */

public java.lang.String foundType() { throw new RuntimeException("Stub!"); }
}

