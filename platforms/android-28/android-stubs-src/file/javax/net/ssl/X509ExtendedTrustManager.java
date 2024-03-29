/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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


package javax.net.ssl;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.net.Socket;

/**
 * Extensions to the <code>X509TrustManager</code> interface to support
 * SSL/TLS connection sensitive trust management.
 * <p>
 * To prevent man-in-the-middle attacks, hostname checks can be done
 * to verify that the hostname in an end-entity certificate matches the
 * targeted hostname.  TLS does not require such checks, but some protocols
 * over TLS (such as HTTPS) do.  In earlier versions of the JDK, the
 * certificate chain checks were done at the SSL/TLS layer, and the hostname
 * verification checks were done at the layer over TLS.  This class allows
 * for the checking to be done during a single call to this class.
 * <p>
 * RFC 2830 defines the server identification specification for the "LDAPS"
 * algorithm. RFC 2818 defines both the server identification and the
 * client identification specification for the "HTTPS" algorithm.
 *
 * @see X509TrustManager
 * @see HostnameVerifier
 *
 * @since 1.7
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class X509ExtendedTrustManager implements javax.net.ssl.X509TrustManager {

public X509ExtendedTrustManager() { throw new RuntimeException("Stub!"); }

/**
 * Given the partial or complete certificate chain provided by the
 * peer, build and validate the certificate path based on the
 * authentication type and ssl parameters.
 * <p>
 * The authentication type is determined by the actual certificate
 * used. For instance, if RSAPublicKey is used, the authType
 * should be "RSA". Checking is case-sensitive.
 * <p>
 * If the <code>socket</code> parameter is an instance of
 * {@link javax.net.ssl.SSLSocket}, and the endpoint identification
 * algorithm of the <code>SSLParameters</code> is non-empty, to prevent
 * man-in-the-middle attacks, the address that the <code>socket</code>
 * connected to should be checked against the peer's identity presented
 * in the end-entity X509 certificate, as specified in the endpoint
 * identification algorithm.
 * <p>
 * If the <code>socket</code> parameter is an instance of
 * {@link javax.net.ssl.SSLSocket}, and the algorithm constraints of the
 * <code>SSLParameters</code> is non-null, for every certificate in the
 * certification path, fields such as subject public key, the signature
 * algorithm, key usage, extended key usage, etc. need to conform to the
 * algorithm constraints in place on this socket.
 *
 * @param chain the peer certificate chain
 * @param authType the key exchange algorithm used
 * @param socket the socket used for this connection. This parameter
 *        can be null, which indicates that implementations need not check
 *        the ssl parameters
 * @throws IllegalArgumentException if null or zero-length array is passed
 *        in for the <code>chain</code> parameter or if null or zero-length
 *        string is passed in for the <code>authType</code> parameter
 * @throws CertificateException if the certificate chain is not trusted
 *        by this TrustManager
 *
 * @see SSLParameters#getEndpointIdentificationAlgorithm
 * @see SSLParameters#setEndpointIdentificationAlgorithm(String)
 * @see SSLParameters#getAlgorithmConstraints
 * @see SSLParameters#setAlgorithmConstraints(AlgorithmConstraints)
 */

public abstract void checkClientTrusted(java.security.cert.X509Certificate[] chain, java.lang.String authType, java.net.Socket socket) throws java.security.cert.CertificateException;

/**
 * Given the partial or complete certificate chain provided by the
 * peer, build and validate the certificate path based on the
 * authentication type and ssl parameters.
 * <p>
 * The authentication type is the key exchange algorithm portion
 * of the cipher suites represented as a String, such as "RSA",
 * "DHE_DSS". Note: for some exportable cipher suites, the key
 * exchange algorithm is determined at run time during the
 * handshake. For instance, for TLS_RSA_EXPORT_WITH_RC4_40_MD5,
 * the authType should be RSA_EXPORT when an ephemeral RSA key is
 * used for the key exchange, and RSA when the key from the server
 * certificate is used. Checking is case-sensitive.
 * <p>
 * If the <code>socket</code> parameter is an instance of
 * {@link javax.net.ssl.SSLSocket}, and the endpoint identification
 * algorithm of the <code>SSLParameters</code> is non-empty, to prevent
 * man-in-the-middle attacks, the address that the <code>socket</code>
 * connected to should be checked against the peer's identity presented
 * in the end-entity X509 certificate, as specified in the endpoint
 * identification algorithm.
 * <p>
 * If the <code>socket</code> parameter is an instance of
 * {@link javax.net.ssl.SSLSocket}, and the algorithm constraints of the
 *  <code>SSLParameters</code> is non-null, for every certificate in the
 * certification path, fields such as subject public key, the signature
 * algorithm, key usage, extended key usage, etc. need to conform to the
 * algorithm constraints in place on this socket.
 *
 * @param chain the peer certificate chain
 * @param authType the key exchange algorithm used
 * @param socket the socket used for this connection. This parameter
 *        can be null, which indicates that implementations need not check
 *        the ssl parameters
 * @throws IllegalArgumentException if null or zero-length array is passed
 *        in for the <code>chain</code> parameter or if null or zero-length
 *        string is passed in for the <code>authType</code> parameter
 * @throws CertificateException if the certificate chain is not trusted
 *        by this TrustManager
 *
 * @see SSLParameters#getEndpointIdentificationAlgorithm
 * @see SSLParameters#setEndpointIdentificationAlgorithm(String)
 * @see SSLParameters#getAlgorithmConstraints
 * @see SSLParameters#setAlgorithmConstraints(AlgorithmConstraints)
 */

public abstract void checkServerTrusted(java.security.cert.X509Certificate[] chain, java.lang.String authType, java.net.Socket socket) throws java.security.cert.CertificateException;

/**
 * Given the partial or complete certificate chain provided by the
 * peer, build and validate the certificate path based on the
 * authentication type and ssl parameters.
 * <p>
 * The authentication type is determined by the actual certificate
 * used. For instance, if RSAPublicKey is used, the authType
 * should be "RSA". Checking is case-sensitive.
 * <p>
 * If the <code>engine</code> parameter is available, and the endpoint
 * identification algorithm of the <code>SSLParameters</code> is
 * non-empty, to prevent man-in-the-middle attacks, the address that
 * the <code>engine</code> connected to should be checked against
 * the peer's identity presented in the end-entity X509 certificate,
 * as specified in the endpoint identification algorithm.
 * <p>
 * If the <code>engine</code> parameter is available, and the algorithm
 * constraints of the <code>SSLParameters</code> is non-null, for every
 * certificate in the certification path, fields such as subject public
 * key, the signature algorithm, key usage, extended key usage, etc.
 * need to conform to the algorithm constraints in place on this engine.
 *
 * @param chain the peer certificate chain
 * @param authType the key exchange algorithm used
 * @param engine the engine used for this connection. This parameter
 *        can be null, which indicates that implementations need not check
 *        the ssl parameters
 * @throws IllegalArgumentException if null or zero-length array is passed
 *        in for the <code>chain</code> parameter or if null or zero-length
 *        string is passed in for the <code>authType</code> parameter
 * @throws CertificateException if the certificate chain is not trusted
 *        by this TrustManager
 *
 * @see SSLParameters#getEndpointIdentificationAlgorithm
 * @see SSLParameters#setEndpointIdentificationAlgorithm(String)
 * @see SSLParameters#getAlgorithmConstraints
 * @see SSLParameters#setAlgorithmConstraints(AlgorithmConstraints)
 */

public abstract void checkClientTrusted(java.security.cert.X509Certificate[] chain, java.lang.String authType, javax.net.ssl.SSLEngine engine) throws java.security.cert.CertificateException;

/**
 * Given the partial or complete certificate chain provided by the
 * peer, build and validate the certificate path based on the
 * authentication type and ssl parameters.
 * <p>
 * The authentication type is the key exchange algorithm portion
 * of the cipher suites represented as a String, such as "RSA",
 * "DHE_DSS". Note: for some exportable cipher suites, the key
 * exchange algorithm is determined at run time during the
 * handshake. For instance, for TLS_RSA_EXPORT_WITH_RC4_40_MD5,
 * the authType should be RSA_EXPORT when an ephemeral RSA key is
 * used for the key exchange, and RSA when the key from the server
 * certificate is used. Checking is case-sensitive.
 * <p>
 * If the <code>engine</code> parameter is available, and the endpoint
 * identification algorithm of the <code>SSLParameters</code> is
 * non-empty, to prevent man-in-the-middle attacks, the address that
 * the <code>engine</code> connected to should be checked against
 * the peer's identity presented in the end-entity X509 certificate,
 * as specified in the endpoint identification algorithm.
 * <p>
 * If the <code>engine</code> parameter is available, and the algorithm
 * constraints of the <code>SSLParameters</code> is non-null, for every
 * certificate in the certification path, fields such as subject public
 * key, the signature algorithm, key usage, extended key usage, etc.
 * need to conform to the algorithm constraints in place on this engine.
 *
 * @param chain the peer certificate chain
 * @param authType the key exchange algorithm used
 * @param engine the engine used for this connection. This parameter
 *        can be null, which indicates that implementations need not check
 *        the ssl parameters
 * @throws IllegalArgumentException if null or zero-length array is passed
 *        in for the <code>chain</code> parameter or if null or zero-length
 *        string is passed in for the <code>authType</code> parameter
 * @throws CertificateException if the certificate chain is not trusted
 *        by this TrustManager
 *
 * @see SSLParameters#getEndpointIdentificationAlgorithm
 * @see SSLParameters#setEndpointIdentificationAlgorithm(String)
 * @see SSLParameters#getAlgorithmConstraints
 * @see SSLParameters#setAlgorithmConstraints(AlgorithmConstraints)
 */

public abstract void checkServerTrusted(java.security.cert.X509Certificate[] chain, java.lang.String authType, javax.net.ssl.SSLEngine engine) throws java.security.cert.CertificateException;
}

