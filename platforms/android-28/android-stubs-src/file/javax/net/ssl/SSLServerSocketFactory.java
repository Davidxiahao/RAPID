/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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



package javax.net.ssl;

import javax.net.ServerSocketFactory;
import java.net.ServerSocket;

/**
 * <code>SSLServerSocketFactory</code>s create
 * <code>SSLServerSocket</code>s.
 *
 * @since 1.4
 * @see SSLSocket
 * @see SSLServerSocket
 * @author David Brownell
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SSLServerSocketFactory extends javax.net.ServerSocketFactory {

/**
 * Constructor is used only by subclasses.
 */

protected SSLServerSocketFactory() { throw new RuntimeException("Stub!"); }

/**
 * Returns the default SSL server socket factory.
 *
 * <p>The first time this method is called, the security property
 * "ssl.ServerSocketFactory.provider" is examined. If it is non-null, a
 * class by that name is loaded and instantiated. If that is successful and
 * the object is an instance of SSLServerSocketFactory, it is made the
 * default SSL server socket factory.
 *
 * <p>Otherwise, this method returns
 * <code>SSLContext.getDefault().getServerSocketFactory()</code>. If that
 * call fails, an inoperative factory is returned.
 *
 * @return the default <code>ServerSocketFactory</code>
 * @see SSLContext#getDefault
 */

public static synchronized javax.net.ServerSocketFactory getDefault() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of cipher suites which are enabled by default.
 * Unless a different list is enabled, handshaking on an SSL connection
 * will use one of these cipher suites.  The minimum quality of service
 * for these defaults requires confidentiality protection and server
 * authentication (that is, no anonymous cipher suites).
 *
 * @see #getSupportedCipherSuites()
 * @return array of the cipher suites enabled by default
 */

public abstract java.lang.String[] getDefaultCipherSuites();

/**
 * Returns the names of the cipher suites which could be enabled for use
 * on an SSL connection created by this factory.
 * Normally, only a subset of these will actually
 * be enabled by default, since this list may include cipher suites which
 * do not meet quality of service requirements for those defaults.  Such
 * cipher suites are useful in specialized applications.
 *
 * @return an array of cipher suite names
 * @see #getDefaultCipherSuites()
 */

public abstract java.lang.String[] getSupportedCipherSuites();
}

