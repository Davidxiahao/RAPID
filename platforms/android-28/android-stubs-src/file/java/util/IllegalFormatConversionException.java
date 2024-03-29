/*
 * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Unchecked exception thrown when the argument corresponding to the format
 * specifier is of an incompatible type.
 *
 * <p> Unless otherwise specified, passing a <tt>null</tt> argument to any
 * method or constructor in this class will cause a {@link
 * NullPointerException} to be thrown.
 *
 * @since 1.5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class IllegalFormatConversionException extends java.util.IllegalFormatException {

/**
 * Constructs an instance of this class with the mismatched conversion and
 * the corresponding argument class.
 *
 * @param  c
 *         Inapplicable conversion
 *
 * @param  arg
 *         Class of the mismatched argument
 */

public IllegalFormatConversionException(char c, java.lang.Class<?> arg) { throw new RuntimeException("Stub!"); }

/**
 * Returns the inapplicable conversion.
 *
 * @return  The inapplicable conversion
 */

public char getConversion() { throw new RuntimeException("Stub!"); }

/**
 * Returns the class of the mismatched argument.
 *
 * @return   The class of the mismatched argument
 */

public java.lang.Class<?> getArgumentClass() { throw new RuntimeException("Stub!"); }

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }
}

