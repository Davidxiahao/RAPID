/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.security.spec;


/**
 * This immutable class specifies the set of parameters used for
 * generating elliptic curve (EC) domain parameters.
 *
 * @see AlgorithmParameterSpec
 *
 * @author Valerie Peng
 *
 * @since 1.5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ECGenParameterSpec implements java.security.spec.AlgorithmParameterSpec {

/**
 * Creates a parameter specification for EC parameter
 * generation using a standard (or predefined) name
 * {@code stdName} in order to generate the corresponding
 * (precomputed) elliptic curve domain parameters. For the
 * list of supported names, please consult the documentation
 * of provider whose implementation will be used.
 * @param stdName the standard name of the to-be-generated EC
 * domain parameters.
 * @exception NullPointerException if {@code stdName}
 * is null.
 */

public ECGenParameterSpec(java.lang.String stdName) { throw new RuntimeException("Stub!"); }

/**
 * Returns the standard or predefined name of the
 * to-be-generated EC domain parameters.
 * @return the standard or predefined name.
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }
}

