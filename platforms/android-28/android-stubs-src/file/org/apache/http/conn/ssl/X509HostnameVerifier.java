/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/ssl/X509HostnameVerifier.java $
 * $Revision: 618365 $
 * $Date: 2008-02-04 10:20:08 -0800 (Mon, 04 Feb 2008) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


package org.apache.http.conn.ssl;

import javax.net.ssl.SSLSession;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;

/**
 * Interface for checking if a hostname matches the names stored inside the
 * server's X.509 certificate.  Implements javax.net.ssl.HostnameVerifier, but
 * we don't actually use that interface.  Instead we added some methods that
 * take String parameters (instead of javax.net.ssl.HostnameVerifier's
 * SSLSession).  JUnit is a lot easier this way!  :-)
 * <p/>
 * We provide the HostnameVerifier.DEFAULT, HostnameVerifier.STRICT, and
 * HostnameVerifier.ALLOW_ALL implementations.  But feel free to define
 * your own implementation!
 * <p/>
 * Inspired by Sebastian Hauer's original StrictSSLProtocolSocketFactory in the
 * HttpClient "contrib" repository.
 *
 * @author Julius Davies
 * @author <a href="mailto:hauer@psicode.com">Sebastian Hauer</a>
 *
 * @since 4.0 (8-Dec-2006)
 *
 * @deprecated Please use {@link java.net.URL#openConnection} instead.
 *     Please visit <a href="http://android-developers.blogspot.com/2011/09/androids-http-clients.html">this webpage</a>
 *     for further details.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public interface X509HostnameVerifier extends javax.net.ssl.HostnameVerifier {

public boolean verify(java.lang.String host, javax.net.ssl.SSLSession session);

public void verify(java.lang.String host, javax.net.ssl.SSLSocket ssl) throws java.io.IOException;

public void verify(java.lang.String host, java.security.cert.X509Certificate cert) throws javax.net.ssl.SSLException;

/**
 * Checks to see if the supplied hostname matches any of the supplied CNs
 * or "DNS" Subject-Alts.  Most implementations only look at the first CN,
 * and ignore any additional CNs.  Most implementations do look at all of
 * the "DNS" Subject-Alts. The CNs or Subject-Alts may contain wildcards
 * according to RFC 2818.
 *
 * @param cns         CN fields, in order, as extracted from the X.509
 *                    certificate.
 * @param subjectAlts Subject-Alt fields of type 2 ("DNS"), as extracted
 *                    from the X.509 certificate.
 * @param host        The hostname to verify.
 * @throws SSLException If verification failed.
 */

public void verify(java.lang.String host, java.lang.String[] cns, java.lang.String[] subjectAlts) throws javax.net.ssl.SSLException;
}

