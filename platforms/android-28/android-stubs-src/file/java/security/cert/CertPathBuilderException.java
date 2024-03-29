/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.security.cert;


/**
 * An exception indicating one of a variety of problems encountered when
 * building a certification path with a {@code CertPathBuilder}.
 * <p>
 * A {@code CertPathBuilderException} provides support for wrapping
 * exceptions. The {@link #getCause getCause} method returns the throwable,
 * if any, that caused this exception to be thrown.
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * Unless otherwise specified, the methods defined in this class are not
 * thread-safe. Multiple threads that need to access a single
 * object concurrently should synchronize amongst themselves and
 * provide the necessary locking. Multiple threads each manipulating
 * separate objects need not synchronize.
 *
 * @see CertPathBuilder
 *
 * @since       1.4
 * @author      Sean Mullan
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CertPathBuilderException extends java.security.GeneralSecurityException {

/**
 * Creates a {@code CertPathBuilderException} with {@code null}
 * as its detail message.
 */

public CertPathBuilderException() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code CertPathBuilderException} with the given
 * detail message. The detail message is a {@code String} that
 * describes this particular exception in more detail.
 *
 * @param msg the detail message
 */

public CertPathBuilderException(java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code CertPathBuilderException} that wraps the specified
 * throwable. This allows any exception to be converted into a
 * {@code CertPathBuilderException}, while retaining information
 * about the wrapped exception, which may be useful for debugging. The
 * detail message is set to ({@code cause==null ? null : cause.toString()})
 * (which typically contains the class and detail message of
 * cause).
 *
 * @param cause the cause (which is saved for later retrieval by the
 * {@link #getCause getCause()} method). (A {@code null} value is
 * permitted, and indicates that the cause is nonexistent or unknown.)
 */

public CertPathBuilderException(java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code CertPathBuilderException} with the specified
 * detail message and cause.
 *
 * @param msg the detail message
 * @param  cause the cause (which is saved for later retrieval by the
 * {@link #getCause getCause()} method). (A {@code null} value is
 * permitted, and indicates that the cause is nonexistent or unknown.)
 */

public CertPathBuilderException(java.lang.String msg, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }
}

