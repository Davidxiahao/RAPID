/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Enumeration;

/**
 * A <code>SSLSessionContext</code> represents a set of
 * <code>SSLSession</code>s associated with a single entity. For example,
 * it could be associated with a server or client who participates in many
 * sessions concurrently.
 * <p>
 * Not all environments will contain session contexts.
 * <p>
 * There are <code>SSLSessionContext</code> parameters that affect how
 * sessions are stored:
 * <UL>
 *      <LI>Sessions can be set to expire after a specified
 *      time limit.
 *      <LI>The number of sessions that can be stored in context
 *      can be limited.
 * </UL>
 * A session can be retrieved based on its session id, and all session id's
 * in a <code>SSLSessionContext</code> can be listed.
 *
 * @see SSLSession
 *
 * @since 1.4
 * @author Nathan Abramson
 * @author David Brownell
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface SSLSessionContext {

/**
 * Returns the <code>SSLSession</code> bound to the specified session id.
 *
 * @param sessionId the Session identifier
 * @return the <code>SSLSession</code> or null if
 * the specified session id does not refer to a valid SSLSession.
 *
 * @throws NullPointerException if <code>sessionId</code> is null.
 */

public javax.net.ssl.SSLSession getSession(byte[] sessionId);

/**
 * Returns an Enumeration of all session id's grouped under this
 * <code>SSLSessionContext</code>.
 *
 * @return an enumeration of all the Session id's
 */

public java.util.Enumeration<byte[]> getIds();

/**
 * Sets the timeout limit for <code>SSLSession</code> objects grouped
 * under this <code>SSLSessionContext</code>.
 * <p>
 * If the timeout limit is set to 't' seconds, a session exceeds the
 * timeout limit 't' seconds after its creation time.
 * When the timeout limit is exceeded for a session, the
 * <code>SSLSession</code> object is invalidated and future connections
 * cannot resume or rejoin the session.
 * A check for sessions exceeding the timeout is made immediately whenever
 * the timeout limit is changed for this <code>SSLSessionContext</code>.
 *
 * @param seconds the new session timeout limit in seconds; zero means
 *          there is no limit.
 *
 * @exception IllegalArgumentException if the timeout specified is {@code < 0}.
 * @see #getSessionTimeout
 */

public void setSessionTimeout(int seconds) throws java.lang.IllegalArgumentException;

/**
 * Returns the timeout limit of <code>SSLSession</code> objects grouped
 * under this <code>SSLSessionContext</code>.
 * <p>
 * If the timeout limit is set to 't' seconds, a session exceeds the
 * timeout limit 't' seconds after its creation time.
 * When the timeout limit is exceeded for a session, the
 * <code>SSLSession</code> object is invalidated and future connections
 * cannot resume or rejoin the session.
 * A check for sessions exceeding the timeout limit is made immediately
 * whenever the timeout limit is changed for this
 * <code>SSLSessionContext</code>.
 *
 * @return the session timeout limit in seconds; zero means there is no
 * limit.
 * @see #setSessionTimeout
 */

public int getSessionTimeout();

/**
 * Sets the size of the cache used for storing
 * <code>SSLSession</code> objects grouped under this
 * <code>SSLSessionContext</code>.
 *
 * @param size the new session cache size limit; zero means there is no
 * limit.
 * @exception IllegalArgumentException if the specified size is {@code < 0}.
 * @see #getSessionCacheSize
 */

public void setSessionCacheSize(int size) throws java.lang.IllegalArgumentException;

/**
 * Returns the size of the cache used for storing
 * <code>SSLSession</code> objects grouped under this
 * <code>SSLSessionContext</code>.
 *
 * @return size of the session cache; zero means there is no size limit.
 * @see #setSessionCacheSize
 */

public int getSessionCacheSize();
}

