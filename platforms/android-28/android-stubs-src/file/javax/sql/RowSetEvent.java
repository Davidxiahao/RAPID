/*
 * Copyright (c) 2000, 2006, Oracle and/or its affiliates. All rights reserved.
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
 * An <code>Event</code> object generated when an event occurs to a
 * <code>RowSet</code> object.  A <code>RowSetEvent</code> object is
 * generated when a single row in a rowset is changed, the whole rowset
 * is changed, or the rowset cursor moves.
 * <P>
 * When an event occurs on a <code>RowSet</code> object, one of the
 * <code>RowSetListener</code> methods will be sent to all registered
 * listeners to notify them of the event.  An <code>Event</code> object
 * is supplied to the <code>RowSetListener</code> method so that the
 * listener can use it to find out which <code>RowSet</code> object is
 * the source of the event.
 *
 * @since 1.4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RowSetEvent extends java.util.EventObject {

/**
 * Constructs a <code>RowSetEvent</code> object initialized with the
 * given <code>RowSet</code> object.
 *
 * @param source the <code>RowSet</code> object whose data has changed or
 *        whose cursor has moved
 * @throws IllegalArgumentException if <code>source</code> is null.
 */

public RowSetEvent(javax.sql.RowSet source) { super(null); throw new RuntimeException("Stub!"); }
}

