/*
 * Copyright (c) 2005, 2010, Oracle and/or its affiliates. All rights reserved.
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


package javax.sql;

import java.sql.SQLException;
import java.io.PrintWriter;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * Interface that defines the methods which are common between <code>DataSource</code>,
 * <code>XADataSource</code> and <code>ConnectionPoolDataSource</code>.
 *<p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface CommonDataSource {

/**
 * <p>Retrieves the log writer for this <code>DataSource</code>
 * object.
 *
 * <p>The log writer is a character output stream to which all logging
 * and tracing messages for this data source will be
 * printed.  This includes messages printed by the methods of this
 * object, messages printed by methods of other objects manufactured
 * by this object, and so on.  Messages printed to a data source
 * specific log writer are not printed to the log writer associated
 * with the <code>java.sql.DriverManager</code> class.  When a
 * <code>DataSource</code> object is
 * created, the log writer is initially null; in other words, the
 * default is for logging to be disabled.
 *
 * @return the log writer for this data source or null if
 *        logging is disabled
 * @exception java.sql.SQLException if a database access error occurs
 * @see #setLogWriter
 * @since 1.4
 */

public java.io.PrintWriter getLogWriter() throws java.sql.SQLException;

/**
 * <p>Sets the log writer for this <code>DataSource</code>
 * object to the given <code>java.io.PrintWriter</code> object.
 *
 * <p>The log writer is a character output stream to which all logging
 * and tracing messages for this data source will be
 * printed.  This includes messages printed by the methods of this
 * object, messages printed by methods of other objects manufactured
 * by this object, and so on.  Messages printed to a data source-
 * specific log writer are not printed to the log writer associated
 * with the <code>java.sql.DriverManager</code> class. When a
 * <code>DataSource</code> object is created the log writer is
 * initially null; in other words, the default is for logging to be
 * disabled.
 *
 * @param out the new log writer; to disable logging, set to null
 * @exception SQLException if a database access error occurs
 * @see #getLogWriter
 * @since 1.4
 */

public void setLogWriter(java.io.PrintWriter out) throws java.sql.SQLException;

/**
 * <p>Sets the maximum time in seconds that this data source will wait
 * while attempting to connect to a database.  A value of zero
 * specifies that the timeout is the default system timeout
 * if there is one; otherwise, it specifies that there is no timeout.
 * When a <code>DataSource</code> object is created, the login timeout is
 * initially zero.
 *
 * @param seconds the data source login time limit
 * @exception SQLException if a database access error occurs.
 * @see #getLoginTimeout
 * @since 1.4
 */

public void setLoginTimeout(int seconds) throws java.sql.SQLException;

/**
 * Gets the maximum time in seconds that this data source can wait
 * while attempting to connect to a database.  A value of zero
 * means that the timeout is the default system timeout
 * if there is one; otherwise, it means that there is no timeout.
 * When a <code>DataSource</code> object is created, the login timeout is
 * initially zero.
 *
 * @return the data source login time limit
 * @exception SQLException if a database access error occurs.
 * @see #setLoginTimeout
 * @since 1.4
 */

public int getLoginTimeout() throws java.sql.SQLException;

/**
 * Return the parent Logger of all the Loggers used by this data source. This
 * should be the Logger farthest from the root Logger that is
 * still an ancestor of all of the Loggers used by this data source. Configuring
 * this Logger will affect all of the log messages generated by the data source.
 * In the worst case, this may be the root Logger.
 *
 * @return the parent Logger for this data source
 * @throws SQLFeatureNotSupportedException if the data source does not use <code>java.util.logging<code>.
 * @since 1.7
 */

public java.util.logging.Logger getParentLogger() throws java.sql.SQLFeatureNotSupportedException;
}

