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
 * An exception  thrown as a <code>DataTruncation</code> exception
 * (on writes) or reported as a
 * <code>DataTruncation</code> warning (on reads)
 *  when a data values is unexpectedly truncated for reasons other than its having
 *  execeeded <code>MaxFieldSize</code>.
 *
 * <P>The SQLstate for a <code>DataTruncation</code> during read is <code>01004</code>.
 * <P>The SQLstate for a <code>DataTruncation</code> during write is <code>22001</code>.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DataTruncation extends java.sql.SQLWarning {

/**
 * Creates a <code>DataTruncation</code> object
 * with the SQLState initialized
 * to 01004 when <code>read</code> is set to <code>true</code> and 22001
 * when <code>read</code> is set to <code>false</code>,
 * the reason set to "Data truncation", the
 * vendor code set to 0, and
 * the other fields set to the given values.
 * The <code>cause</code> is not initialized, and may subsequently be
 * initialized by a call to the
 * {@link Throwable#initCause(java.lang.Throwable)} method.
 * <p>
 *
 * @param index The index of the parameter or column value
 * @param parameter true if a parameter value was truncated
 * @param read true if a read was truncated
 * @param dataSize the original size of the data
 * @param transferSize the size after truncation
 */

public DataTruncation(int index, boolean parameter, boolean read, int dataSize, int transferSize) { throw new RuntimeException("Stub!"); }

/**
 * Creates a <code>DataTruncation</code> object
 * with the SQLState initialized
 * to 01004 when <code>read</code> is set to <code>true</code> and 22001
 * when <code>read</code> is set to <code>false</code>,
 * the reason set to "Data truncation", the
 * vendor code set to 0, and
 * the other fields set to the given values.
 * <p>
 *
 * @param index The index of the parameter or column value
 * @param parameter true if a parameter value was truncated
 * @param read true if a read was truncated
 * @param dataSize the original size of the data
 * @param transferSize the size after truncation
 * @param cause the underlying reason for this <code>DataTruncation</code>
 * (which is saved for later retrieval by the <code>getCause()</code> method);
 * may be null indicating the cause is non-existent or unknown.
 *
 * @since 1.6
 */

public DataTruncation(int index, boolean parameter, boolean read, int dataSize, int transferSize, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the index of the column or parameter that was truncated.
 *
 * <P>This may be -1 if the column or parameter index is unknown, in
 * which case the <code>parameter</code> and <code>read</code> fields should be ignored.
 *
 * @return the index of the truncated paramter or column value
 */

public int getIndex() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the value truncated was a parameter value or
    * a column value.
 *
 * @return <code>true</code> if the value truncated was a parameter;
    *         <code>false</code> if it was a column value
 */

public boolean getParameter() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether or not the value was truncated on a read.
 *
 * @return <code>true</code> if the value was truncated when read from
    *         the database; <code>false</code> if the data was truncated on a write
 */

public boolean getRead() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of bytes of data that should have been transferred.
 * This number may be approximate if data conversions were being
 * performed.  The value may be <code>-1</code> if the size is unknown.
 *
 * @return the number of bytes of data that should have been transferred
 */

public int getDataSize() { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of bytes of data actually transferred.
 * The value may be <code>-1</code> if the size is unknown.
 *
 * @return the number of bytes of data actually transferred
 */

public int getTransferSize() { throw new RuntimeException("Stub!"); }
}

