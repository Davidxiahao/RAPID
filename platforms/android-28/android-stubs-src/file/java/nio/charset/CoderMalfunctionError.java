/*
 * Copyright (c) 2001, 2007, Oracle and/or its affiliates. All rights reserved.
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


package java.nio.charset;


/**
 * Error thrown when the {@link CharsetDecoder#decodeLoop decodeLoop} method of
 * a {@link CharsetDecoder}, or the {@link CharsetEncoder#encodeLoop
 * encodeLoop} method of a {@link CharsetEncoder}, throws an unexpected
 * exception.
 *
 * @since 1.4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CoderMalfunctionError extends java.lang.Error {

/**
 * Initializes an instance of this class.
 *
 * @param  cause
 *         The unexpected exception that was thrown
 */

public CoderMalfunctionError(java.lang.Exception cause) { throw new RuntimeException("Stub!"); }
}

