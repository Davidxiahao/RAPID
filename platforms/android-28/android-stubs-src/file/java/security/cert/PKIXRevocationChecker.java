/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.util.List;
import java.util.Set;
import java.net.URI;

/**
 * A {@code PKIXCertPathChecker} for checking the revocation status of
 * certificates with the PKIX algorithm.
 *
 * <p>A {@code PKIXRevocationChecker} checks the revocation status of
 * certificates with the Online Certificate Status Protocol (OCSP) or
 * Certificate Revocation Lists (CRLs). OCSP is described in RFC 2560 and
 * is a network protocol for determining the status of a certificate. A CRL
 * is a time-stamped list identifying revoked certificates, and RFC 5280
 * describes an algorithm for determining the revocation status of certificates
 * using CRLs.
 *
 * <p>Each {@code PKIXRevocationChecker} must be able to check the revocation
 * status of certificates with OCSP and CRLs. By default, OCSP is the
 * preferred mechanism for checking revocation status, with CRLs as the
 * fallback mechanism. However, this preference can be switched to CRLs with
 * the {@link Option#PREFER_CRLS PREFER_CRLS} option. In addition, the fallback
 * mechanism can be disabled with the {@link Option#NO_FALLBACK NO_FALLBACK}
 * option.
 *
 * <p>A {@code PKIXRevocationChecker} is obtained by calling the
 * {@link CertPathValidator#getRevocationChecker getRevocationChecker} method
 * of a PKIX {@code CertPathValidator}. Additional parameters and options
 * specific to revocation can be set (by calling the
 * {@link #setOcspResponder setOcspResponder} method for instance). The
 * {@code PKIXRevocationChecker} is added to a {@code PKIXParameters} object
 * using the {@link PKIXParameters#addCertPathChecker addCertPathChecker}
 * or {@link PKIXParameters#setCertPathCheckers setCertPathCheckers} method,
 * and then the {@code PKIXParameters} is passed along with the {@code CertPath}
 * to be validated to the {@link CertPathValidator#validate validate} method
 * of a PKIX {@code CertPathValidator}. When supplying a revocation checker in
 * this manner, it will be used to check revocation irrespective of the setting
 * of the {@link PKIXParameters#isRevocationEnabled RevocationEnabled} flag.
 * Similarly, a {@code PKIXRevocationChecker} may be added to a
 * {@code PKIXBuilderParameters} object for use with a PKIX
 * {@code CertPathBuilder}.
 *
 * <p>Note that when a {@code PKIXRevocationChecker} is added to
 * {@code PKIXParameters}, it clones the {@code PKIXRevocationChecker};
 * thus any subsequent modifications to the {@code PKIXRevocationChecker}
 * have no effect.
 *
 * <p>Any parameter that is not set (or is set to {@code null}) will be set to
 * the default value for that parameter.
 *
 * <p><b>Concurrent Access</b>
 *
 * <p>Unless otherwise specified, the methods defined in this class are not
 * thread-safe. Multiple threads that need to access a single object
 * concurrently should synchronize amongst themselves and provide the
 * necessary locking. Multiple threads each manipulating separate objects
 * need not synchronize.
 *
 * <p>See RFC 2560: X.509 Internet Public Key Infrastructure Online Certificate Status Protocol -
 * OCSP, RFC 5280: Internet X.509 Public Key Infrastructure Certificate and Certificate Revocation
 * List (CRL) Profile (Android note: this paragraph was originally in a malformed "see" tag below,
 * moved here for correct construction of the docs).
 *
 * @since 1.8
 
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class PKIXRevocationChecker extends java.security.cert.PKIXCertPathChecker {

/**
 * Default constructor.
 */

protected PKIXRevocationChecker() { throw new RuntimeException("Stub!"); }

/**
 * Sets the URI that identifies the location of the OCSP responder. This
 * overrides the {@code ocsp.responderURL} security property and any
 * responder specified in a certificate's Authority Information Access
 * Extension, as defined in RFC 5280.
 *
 * @param uri the responder URI
 */

public void setOcspResponder(java.net.URI uri) { throw new RuntimeException("Stub!"); }

/**
 * Gets the URI that identifies the location of the OCSP responder. This
 * overrides the {@code ocsp.responderURL} security property. If this
 * parameter or the {@code ocsp.responderURL} property is not set, the
 * location is determined from the certificate's Authority Information
 * Access Extension, as defined in RFC 5280.
 *
 * @return the responder URI, or {@code null} if not set
 */

public java.net.URI getOcspResponder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the OCSP responder's certificate. This overrides the
 * {@code ocsp.responderCertSubjectName},
 * {@code ocsp.responderCertIssuerName},
 * and {@code ocsp.responderCertSerialNumber} security properties.
 *
 * @param cert the responder's certificate
 */

public void setOcspResponderCert(java.security.cert.X509Certificate cert) { throw new RuntimeException("Stub!"); }

/**
 * Gets the OCSP responder's certificate. This overrides the
 * {@code ocsp.responderCertSubjectName},
 * {@code ocsp.responderCertIssuerName},
 * and {@code ocsp.responderCertSerialNumber} security properties. If this
 * parameter or the aforementioned properties are not set, then the
 * responder's certificate is determined as specified in RFC 2560.
 *
 * @return the responder's certificate, or {@code null} if not set
 */

public java.security.cert.X509Certificate getOcspResponderCert() { throw new RuntimeException("Stub!"); }

/**
 * Sets the optional OCSP request extensions.
 *
 * @param extensions a list of extensions. The list is copied to protect
 *        against subsequent modification.
 */

public void setOcspExtensions(java.util.List<java.security.cert.Extension> extensions) { throw new RuntimeException("Stub!"); }

/**
 * Gets the optional OCSP request extensions.
 *
 * @return an unmodifiable list of extensions. The list is empty if no
 *         extensions have been specified.
 */

public java.util.List<java.security.cert.Extension> getOcspExtensions() { throw new RuntimeException("Stub!"); }

/**
 * Sets the OCSP responses. These responses are used to determine
 * the revocation status of the specified certificates when OCSP is used.
 *
 * @param responses a map of OCSP responses. Each key is an
 *        {@code X509Certificate} that maps to the corresponding
 *        DER-encoded OCSP response for that certificate. A deep copy of
 *        the map is performed to protect against subsequent modification.
 */

public void setOcspResponses(java.util.Map<java.security.cert.X509Certificate, byte[]> responses) { throw new RuntimeException("Stub!"); }

/**
 * Gets the OCSP responses. These responses are used to determine
 * the revocation status of the specified certificates when OCSP is used.
 *
 * @return a map of OCSP responses. Each key is an
 *        {@code X509Certificate} that maps to the corresponding
 *        DER-encoded OCSP response for that certificate. A deep copy of
 *        the map is returned to protect against subsequent modification.
 *        Returns an empty map if no responses have been specified.
 */

public java.util.Map<java.security.cert.X509Certificate, byte[]> getOcspResponses() { throw new RuntimeException("Stub!"); }

/**
 * Sets the revocation options.
 *
 * @param options a set of revocation options. The set is copied to protect
 *        against subsequent modification.
 */

public void setOptions(java.util.Set<java.security.cert.PKIXRevocationChecker.Option> options) { throw new RuntimeException("Stub!"); }

/**
 * Gets the revocation options.
 *
 * @return an unmodifiable set of revocation options. The set is empty if
 *         no options have been specified.
 */

public java.util.Set<java.security.cert.PKIXRevocationChecker.Option> getOptions() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list containing the exceptions that are ignored by the
 * revocation checker when the {@link Option#SOFT_FAIL SOFT_FAIL} option
 * is set. The list is cleared each time {@link #init init} is called.
 * The list is ordered in ascending order according to the certificate
 * index returned by {@link CertPathValidatorException#getIndex getIndex}
 * method of each entry.
 * <p>
 * An implementation of {@code PKIXRevocationChecker} is responsible for
 * adding the ignored exceptions to the list.
 *
 * @return an unmodifiable list containing the ignored exceptions. The list
 *         is empty if no exceptions have been ignored.
 */

public abstract java.util.List<java.security.cert.CertPathValidatorException> getSoftFailExceptions();

public java.security.cert.PKIXRevocationChecker clone() { throw new RuntimeException("Stub!"); }
/**
 * Various revocation options that can be specified for the revocation
 * checking mechanism.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Option {
ONLY_END_ENTITY, PREFER_CRLS, NO_FALLBACK, SOFT_FAIL;
}

}

