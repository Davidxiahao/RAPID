/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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


/**
 * The interface that a <code>RowSet</code> object implements in order to
 * present itself to a <code>RowSetReader</code> or <code>RowSetWriter</code>
 * object. The <code>RowSetInternal</code> interface contains
 * methods that let the reader or writer access and modify the internal
 * state of the rowset.
 *
 * @since 1.4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface RowSetInternal {

/**
 * Retrieves the parameters that have been set for this
 * <code>RowSet</code> object's command.
 *
 * @return an array of the current parameter values for this <code>RowSet</code>
 *         object's command
 * @exception SQLException if a database access error occurs
 */

public java.lang.Object[] getParams() throws java.sql.SQLException;

/**
 * Retrieves the <code>Connection</code> object that was passed to this
 * <code>RowSet</code> object.
 *
 * @return the <code>Connection</code> object passed to the rowset
 *      or <code>null</code> if none was passed
 * @exception SQLException if a database access error occurs
 */

public java.sql.Connection getConnection() throws java.sql.SQLException;

/**
 * Sets the given <code>RowSetMetaData</code> object as the
 * <code>RowSetMetaData</code> object for this <code>RowSet</code>
 * object. The <code>RowSetReader</code> object associated with the rowset
 * will use <code>RowSetMetaData</code> methods to set the values giving
 * information about the rowset's columns.
 *
 * @param md the <code>RowSetMetaData</code> object that will be set with
 *        information about the rowset's columns
 *
 * @exception SQLException if a database access error occurs
 */

public void setMetaData(javax.sql.RowSetMetaData md) throws java.sql.SQLException;

/**
 * Retrieves a <code>ResultSet</code> object containing the original
 * value of this <code>RowSet</code> object.
 * <P>
 * The cursor is positioned before the first row in the result set.
 * Only rows contained in the result set returned by the method
 * <code>getOriginal</code> are said to have an original value.
 *
 * @return the original value of the rowset
 * @exception SQLException if a database access error occurs
 */

public java.sql.ResultSet getOriginal() throws java.sql.SQLException;

/**
 * Retrieves a <code>ResultSet</code> object containing the original value
 * of the current row only.  If the current row has no original value,
 * an empty result set is returned. If there is no current row,
 * an exception is thrown.
 *
 * @return the original value of the current row as a <code>ResultSet</code>
 *          object
 * @exception SQLException if a database access error occurs or this method
 *           is called while the cursor is on the insert row, before the
 *           first row, or after the last row
 */

public java.sql.ResultSet getOriginalRow() throws java.sql.SQLException;
}

