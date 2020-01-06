/*
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

/*
 * This file is available under and governed by the GNU General Public
 * License version 2 only, as published by the Free Software Foundation.
 * However, the following notice accompanied the original version of this
 * file:
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */


package java.util.concurrent;


/**
 * Exception thrown when an error or other exception is encountered
 * in the course of completing a result or task.
 *
 * @since 1.8
 * @author Doug Lea
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CompletionException extends java.lang.RuntimeException {

/**
 * Constructs a {@code CompletionException} with no detail message.
 * The cause is not initialized, and may subsequently be
 * initialized by a call to {@link #initCause(Throwable) initCause}.
 */

protected CompletionException() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@code CompletionException} with the specified detail
 * message. The cause is not initialized, and may subsequently be
 * initialized by a call to {@link #initCause(Throwable) initCause}.
 *
 * @param message the detail message
 */

protected CompletionException(java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@code CompletionException} with the specified detail
 * message and cause.
 *
 * @param  message the detail message
 * @param  cause the cause (which is saved for later retrieval by the
 *         {@link #getCause()} method)
 */

public CompletionException(java.lang.String message, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@code CompletionException} with the specified cause.
 * The detail message is set to {@code (cause == null ? null :
 * cause.toString())} (which typically contains the class and
 * detail message of {@code cause}).
 *
 * @param  cause the cause (which is saved for later retrieval by the
 *         {@link #getCause()} method)
 */

public CompletionException(java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }
}

