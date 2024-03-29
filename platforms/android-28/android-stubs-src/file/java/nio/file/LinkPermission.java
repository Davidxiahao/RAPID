/*
 * Copyright (c) 2007, 2011, Oracle and/or its affiliates. All rights reserved.
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


package java.nio.file;


/**
 * The {@code Permission} class for link creation operations.
 *
 * <p> The following table provides a summary description of what the permission
 * allows, and discusses the risks of granting code the permission.
 *
 * <table border=1 cellpadding=5
 *        summary="Table shows permission target name, what the permission allows, and associated risks">
 * <tr>
 * <th>Permission Target Name</th>
 * <th>What the Permission Allows</th>
 * <th>Risks of Allowing this Permission</th>
 * </tr>
 * <tr>
 *   <td>hard</td>
 *   <td> Ability to add an existing file to a directory. This is sometimes
 *   known as creating a link, or hard link. </td>
 *   <td> Extreme care should be taken when granting this permission. It allows
 *   linking to any file or directory in the file system thus allowing the
 *   attacker access to all files. </td>
 * </tr>
 * <tr>
 *   <td>symbolic</td>
 *   <td> Ability to create symbolic links. </td>
 *   <td> Extreme care should be taken when granting this permission. It allows
 *   linking to any file or directory in the file system thus allowing the
 *   attacker to access to all files. </td>
 * </tr>
 * </table>
 *
 * @since 1.7
 *
 * @see Files#createLink
 * @see Files#createSymbolicLink
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class LinkPermission extends java.security.BasicPermission {

/**
 * Constructs a {@code LinkPermission} with the specified name.
 *
 * @param   name
 *          the name of the permission. It must be "hard" or "symbolic".
 *
 * @throws  IllegalArgumentException
 *          if name is empty or invalid
 */

public LinkPermission(java.lang.String name) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }

/**
 * Constructs a {@code LinkPermission} with the specified name.
 *
 * @param   name
 *          the name of the permission; must be "hard" or "symbolic".
 * @param   actions
 *          the actions for the permission; must be the empty string or
 *          {@code null}
 *
 * @throws  IllegalArgumentException
 *          if name is empty or invalid, or actions is a non-empty string
 */

public LinkPermission(java.lang.String name, java.lang.String actions) { super((java.lang.String)null); throw new RuntimeException("Stub!"); }
}

