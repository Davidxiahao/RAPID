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

import java.util.Collection;

/**
 * Parameters used as input for the Collection {@code CertStore}
 * algorithm.
 * <p>
 * This class is used to provide necessary configuration parameters
 * to implementations of the Collection {@code CertStore}
 * algorithm. The only parameter included in this class is the
 * {@code Collection} from which the {@code CertStore} will
 * retrieve certificates and CRLs.
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * Unless otherwise specified, the methods defined in this class are not
 * thread-safe. Multiple threads that need to access a single
 * object concurrently should synchronize amongst themselves and
 * provide the necessary locking. Multiple threads each manipulating
 * separate objects need not synchronize.
 *
 * @since       1.4
 * @author      Steve Hanna
 * @see         java.util.Collection
 * @see         CertStore
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class CollectionCertStoreParameters implements java.security.cert.CertStoreParameters {

/**
 * Creates an instance of {@code CollectionCertStoreParameters}
 * which will allow certificates and CRLs to be retrieved from the
 * specified {@code Collection}. If the specified
 * {@code Collection} contains an object that is not a
 * {@code Certificate} or {@code CRL}, that object will be
 * ignored by the Collection {@code CertStore}.
 * <p>
 * The {@code Collection} is <b>not</b> copied. Instead, a
 * reference is used. This allows the caller to subsequently add or
 * remove {@code Certificates} or {@code CRL}s from the
 * {@code Collection}, thus changing the set of
 * {@code Certificates} or {@code CRL}s available to the
 * Collection {@code CertStore}. The Collection {@code CertStore}
 * will not modify the contents of the {@code Collection}.
 * <p>
 * If the {@code Collection} will be modified by one thread while
 * another thread is calling a method of a Collection {@code CertStore}
 * that has been initialized with this {@code Collection}, the
 * {@code Collection} must have fail-fast iterators.
 *
 * @param collection a {@code Collection} of
 *        {@code Certificate}s and {@code CRL}s
 * @exception NullPointerException if {@code collection} is
 * {@code null}
 */

public CollectionCertStoreParameters(java.util.Collection<?> collection) { throw new RuntimeException("Stub!"); }

/**
 * Creates an instance of {@code CollectionCertStoreParameters} with
 * the default parameter values (an empty and immutable
 * {@code Collection}).
 */

public CollectionCertStoreParameters() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code Collection} from which {@code Certificate}s
 * and {@code CRL}s are retrieved. This is <b>not</b> a copy of the
 * {@code Collection}, it is a reference. This allows the caller to
 * subsequently add or remove {@code Certificates} or
 * {@code CRL}s from the {@code Collection}.
 *
 * @return the {@code Collection} (never null)
 */

public java.util.Collection<?> getCollection() { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of this object. Note that only a reference to the
 * {@code Collection} is copied, and not the contents.
 *
 * @return the copy
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Returns a formatted string describing the parameters.
 *
 * @return a formatted string describing the parameters
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

