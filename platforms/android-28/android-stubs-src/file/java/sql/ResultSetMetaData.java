/*
 * Copyright (c) 1996, 2005, Oracle and/or its affiliates. All rights reserved.
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


package java.sql;


/**
 * An object that can be used to get information about the types
 * and properties of the columns in a <code>ResultSet</code> object.
 * The following code fragment creates the <code>ResultSet</code> object rs,
 * creates the <code>ResultSetMetaData</code> object rsmd, and uses rsmd
 * to find out how many columns rs has and whether the first column in rs
 * can be used in a <code>WHERE</code> clause.
 * <PRE>
 *
 *     ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM TABLE2");
 *     ResultSetMetaData rsmd = rs.getMetaData();
 *     int numberOfColumns = rsmd.getColumnCount();
 *     boolean b = rsmd.isSearchable(1);
 *
 * </PRE>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface ResultSetMetaData extends java.sql.Wrapper {

/**
 * Returns the number of columns in this <code>ResultSet</code> object.
 *
 * @return the number of columns
 * @exception SQLException if a database access error occurs
 */

public int getColumnCount() throws java.sql.SQLException;

/**
 * Indicates whether the designated column is automatically numbered.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return <code>true</code> if so; <code>false</code> otherwise
 * @exception SQLException if a database access error occurs
 */

public boolean isAutoIncrement(int column) throws java.sql.SQLException;

/**
 * Indicates whether a column's case matters.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return <code>true</code> if so; <code>false</code> otherwise
 * @exception SQLException if a database access error occurs
 */

public boolean isCaseSensitive(int column) throws java.sql.SQLException;

/**
 * Indicates whether the designated column can be used in a where clause.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return <code>true</code> if so; <code>false</code> otherwise
 * @exception SQLException if a database access error occurs
 */

public boolean isSearchable(int column) throws java.sql.SQLException;

/**
 * Indicates whether the designated column is a cash value.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return <code>true</code> if so; <code>false</code> otherwise
 * @exception SQLException if a database access error occurs
 */

public boolean isCurrency(int column) throws java.sql.SQLException;

/**
 * Indicates the nullability of values in the designated column.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return the nullability status of the given column; one of <code>columnNoNulls</code>,
 *          <code>columnNullable</code> or <code>columnNullableUnknown</code>
 * @exception SQLException if a database access error occurs
 */

public int isNullable(int column) throws java.sql.SQLException;

/**
 * Indicates whether values in the designated column are signed numbers.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return <code>true</code> if so; <code>false</code> otherwise
 * @exception SQLException if a database access error occurs
 */

public boolean isSigned(int column) throws java.sql.SQLException;

/**
 * Indicates the designated column's normal maximum width in characters.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return the normal maximum number of characters allowed as the width
 *          of the designated column
 * @exception SQLException if a database access error occurs
 */

public int getColumnDisplaySize(int column) throws java.sql.SQLException;

/**
 * Gets the designated column's suggested title for use in printouts and
 * displays. The suggested title is usually specified by the SQL <code>AS</code>
 * clause.  If a SQL <code>AS</code> is not specified, the value returned from
 * <code>getColumnLabel</code> will be the same as the value returned by the
 * <code>getColumnName</code> method.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return the suggested column title
 * @exception SQLException if a database access error occurs
 */

public java.lang.String getColumnLabel(int column) throws java.sql.SQLException;

/**
 * Get the designated column's name.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return column name
 * @exception SQLException if a database access error occurs
 */

public java.lang.String getColumnName(int column) throws java.sql.SQLException;

/**
 * Get the designated column's table's schema.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return schema name or "" if not applicable
 * @exception SQLException if a database access error occurs
 */

public java.lang.String getSchemaName(int column) throws java.sql.SQLException;

/**
 * Get the designated column's specified column size.
 * For numeric data, this is the maximum precision.  For character data, this is the length in characters.
 * For datetime datatypes, this is the length in characters of the String representation (assuming the
 * maximum allowed precision of the fractional seconds component). For binary data, this is the length in bytes.  For the ROWID datatype,
 * this is the length in bytes. 0 is returned for data types where the
 * column size is not applicable.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return precision
 * @exception SQLException if a database access error occurs
 */

public int getPrecision(int column) throws java.sql.SQLException;

/**
 * Gets the designated column's number of digits to right of the decimal point.
 * 0 is returned for data types where the scale is not applicable.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return scale
 * @exception SQLException if a database access error occurs
 */

public int getScale(int column) throws java.sql.SQLException;

/**
 * Gets the designated column's table name.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return table name or "" if not applicable
 * @exception SQLException if a database access error occurs
 */

public java.lang.String getTableName(int column) throws java.sql.SQLException;

/**
 * Gets the designated column's table's catalog name.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return the name of the catalog for the table in which the given column
 *          appears or "" if not applicable
 * @exception SQLException if a database access error occurs
 */

public java.lang.String getCatalogName(int column) throws java.sql.SQLException;

/**
 * Retrieves the designated column's SQL type.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return SQL type from java.sql.Types
 * @exception SQLException if a database access error occurs
 * @see Types
 */

public int getColumnType(int column) throws java.sql.SQLException;

/**
 * Retrieves the designated column's database-specific type name.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return type name used by the database. If the column type is
 * a user-defined type, then a fully-qualified type name is returned.
 * @exception SQLException if a database access error occurs
 */

public java.lang.String getColumnTypeName(int column) throws java.sql.SQLException;

/**
 * Indicates whether the designated column is definitely not writable.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return <code>true</code> if so; <code>false</code> otherwise
 * @exception SQLException if a database access error occurs
 */

public boolean isReadOnly(int column) throws java.sql.SQLException;

/**
 * Indicates whether it is possible for a write on the designated column to succeed.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return <code>true</code> if so; <code>false</code> otherwise
 * @exception SQLException if a database access error occurs
 */

public boolean isWritable(int column) throws java.sql.SQLException;

/**
 * Indicates whether a write on the designated column will definitely succeed.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return <code>true</code> if so; <code>false</code> otherwise
 * @exception SQLException if a database access error occurs
 */

public boolean isDefinitelyWritable(int column) throws java.sql.SQLException;

/**
 * <p>Returns the fully-qualified name of the Java class whose instances
 * are manufactured if the method <code>ResultSet.getObject</code>
 * is called to retrieve a value
 * from the column.  <code>ResultSet.getObject</code> may return a subclass of the
 * class returned by this method.
 *
 * @param column the first column is 1, the second is 2, ...
 * @return the fully-qualified name of the class in the Java programming
 *         language that would be used by the method
 * <code>ResultSet.getObject</code> to retrieve the value in the specified
 * column. This is the class name used for custom mapping.
 * @exception SQLException if a database access error occurs
 * @since 1.2
 */

public java.lang.String getColumnClassName(int column) throws java.sql.SQLException;

/**
 * The constant indicating that a
 * column does not allow <code>NULL</code> values.
 */

public static final int columnNoNulls = 0; // 0x0

/**
 * The constant indicating that a
 * column allows <code>NULL</code> values.
 */

public static final int columnNullable = 1; // 0x1

/**
 * The constant indicating that the
 * nullability of a column's values is unknown.
 */

public static final int columnNullableUnknown = 2; // 0x2
}

