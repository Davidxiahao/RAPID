/*
 * Copyright (c) 1998, 2006, Oracle and/or its affiliates. All rights reserved.
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


/**
 * This class is an abstraction of certificate revocation lists (CRLs) that
 * have different formats but important common uses. For example, all CRLs
 * share the functionality of listing revoked certificates, and can be queried
 * on whether or not they list a given certificate.
 * <p>
 * Specialized CRL types can be defined by subclassing off of this abstract
 * class.
 *
 * @author Hemma Prafullchandra
 *
 *
 * @see X509CRL
 * @see CertificateFactory
 *
 * @since 1.2
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CRL {

/**
 * Creates a CRL of the specified type.
 *
 * @param type the standard name of the CRL type.
 * See Appendix A in the <a href=
 * "{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/security/crypto/CryptoSpec.html#AppA">
 * Java Cryptography Architecture API Specification &amp; Reference </a>
 * for information about standard CRL types.
 */

protected CRL(java.lang.String type) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of this CRL.
 *
 * @return the type of this CRL.
 */

public final java.lang.String getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of this CRL.
 *
 * @return a string representation of this CRL.
 */

public abstract java.lang.String toString();

/**
 * Checks whether the given certificate is on this CRL.
 *
 * @param cert the certificate to check for.
 * @return true if the given certificate is on this CRL,
 * false otherwise.
 */

public abstract boolean isRevoked(java.security.cert.Certificate cert);
}

