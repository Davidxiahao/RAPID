/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.security;

import java.security.KeyStore;
import javax.crypto.SecretKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

/**
 * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
 * for the {@code KeyStore} class.
 * All the abstract methods in this class must be implemented by each
 * cryptographic service provider who wishes to supply the implementation
 * of a keystore for a particular keystore type.
 *
 * @author Jan Luehe
 *
 *
 * @see KeyStore
 *
 * @since 1.2
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class KeyStoreSpi {

public KeyStoreSpi() { throw new RuntimeException("Stub!"); }

/**
 * Returns the key associated with the given alias, using the given
 * password to recover it.  The key must have been associated with
 * the alias by a call to {@code setKeyEntry},
 * or by a call to {@code setEntry} with a
 * {@code PrivateKeyEntry} or {@code SecretKeyEntry}.
 *
 * @param alias the alias name
 * @param password the password for recovering the key
 *
 * @return the requested key, or null if the given alias does not exist
 * or does not identify a key-related entry.
 *
 * @exception NoSuchAlgorithmException if the algorithm for recovering the
 * key cannot be found
 * @exception UnrecoverableKeyException if the key cannot be recovered
 * (e.g., the given password is wrong).
 */

public abstract java.security.Key engineGetKey(java.lang.String alias, char[] password) throws java.security.NoSuchAlgorithmException, java.security.UnrecoverableKeyException;

/**
 * Returns the certificate chain associated with the given alias.
 * The certificate chain must have been associated with the alias
 * by a call to {@code setKeyEntry},
 * or by a call to {@code setEntry} with a
 * {@code PrivateKeyEntry}.
 *
 * @param alias the alias name
 *
 * @return the certificate chain (ordered with the user's certificate first
 * and the root certificate authority last), or null if the given alias
 * does not exist or does not contain a certificate chain
 */

public abstract java.security.cert.Certificate[] engineGetCertificateChain(java.lang.String alias);

/**
 * Returns the certificate associated with the given alias.
 *
 * <p> If the given alias name identifies an entry
 * created by a call to {@code setCertificateEntry},
 * or created by a call to {@code setEntry} with a
 * {@code TrustedCertificateEntry},
 * then the trusted certificate contained in that entry is returned.
 *
 * <p> If the given alias name identifies an entry
 * created by a call to {@code setKeyEntry},
 * or created by a call to {@code setEntry} with a
 * {@code PrivateKeyEntry},
 * then the first element of the certificate chain in that entry
 * (if a chain exists) is returned.
 *
 * @param alias the alias name
 *
 * @return the certificate, or null if the given alias does not exist or
 * does not contain a certificate.
 */

public abstract java.security.cert.Certificate engineGetCertificate(java.lang.String alias);

/**
 * Returns the creation date of the entry identified by the given alias.
 *
 * @param alias the alias name
 *
 * @return the creation date of this entry, or null if the given alias does
 * not exist
 */

public abstract java.util.Date engineGetCreationDate(java.lang.String alias);

/**
 * Assigns the given key to the given alias, protecting it with the given
 * password.
 *
 * <p>If the given key is of type {@code java.security.PrivateKey},
 * it must be accompanied by a certificate chain certifying the
 * corresponding public key.
 *
 * <p>If the given alias already exists, the keystore information
 * associated with it is overridden by the given key (and possibly
 * certificate chain).
 *
 * @param alias the alias name
 * @param key the key to be associated with the alias
 * @param password the password to protect the key
 * @param chain the certificate chain for the corresponding public
 * key (only required if the given key is of type
 * {@code java.security.PrivateKey}).
 *
 * @exception KeyStoreException if the given key cannot be protected, or
 * this operation fails for some other reason
 */

public abstract void engineSetKeyEntry(java.lang.String alias, java.security.Key key, char[] password, java.security.cert.Certificate[] chain) throws java.security.KeyStoreException;

/**
 * Assigns the given key (that has already been protected) to the given
 * alias.
 *
 * <p>If the protected key is of type
 * {@code java.security.PrivateKey},
 * it must be accompanied by a certificate chain certifying the
 * corresponding public key.
 *
 * <p>If the given alias already exists, the keystore information
 * associated with it is overridden by the given key (and possibly
 * certificate chain).
 *
 * @param alias the alias name
 * @param key the key (in protected format) to be associated with the alias
 * @param chain the certificate chain for the corresponding public
 * key (only useful if the protected key is of type
 * {@code java.security.PrivateKey}).
 *
 * @exception KeyStoreException if this operation fails.
 */

public abstract void engineSetKeyEntry(java.lang.String alias, byte[] key, java.security.cert.Certificate[] chain) throws java.security.KeyStoreException;

/**
 * Assigns the given certificate to the given alias.
 *
 * <p> If the given alias identifies an existing entry
 * created by a call to {@code setCertificateEntry},
 * or created by a call to {@code setEntry} with a
 * {@code TrustedCertificateEntry},
 * the trusted certificate in the existing entry
 * is overridden by the given certificate.
 *
 * @param alias the alias name
 * @param cert the certificate
 *
 * @exception KeyStoreException if the given alias already exists and does
 * not identify an entry containing a trusted certificate,
 * or this operation fails for some other reason.
 */

public abstract void engineSetCertificateEntry(java.lang.String alias, java.security.cert.Certificate cert) throws java.security.KeyStoreException;

/**
 * Deletes the entry identified by the given alias from this keystore.
 *
 * @param alias the alias name
 *
 * @exception KeyStoreException if the entry cannot be removed.
 */

public abstract void engineDeleteEntry(java.lang.String alias) throws java.security.KeyStoreException;

/**
 * Lists all the alias names of this keystore.
 *
 * @return enumeration of the alias names
 */

public abstract java.util.Enumeration<java.lang.String> engineAliases();

/**
 * Checks if the given alias exists in this keystore.
 *
 * @param alias the alias name
 *
 * @return true if the alias exists, false otherwise
 */

public abstract boolean engineContainsAlias(java.lang.String alias);

/**
 * Retrieves the number of entries in this keystore.
 *
 * @return the number of entries in this keystore
 */

public abstract int engineSize();

/**
 * Returns true if the entry identified by the given alias
 * was created by a call to {@code setKeyEntry},
 * or created by a call to {@code setEntry} with a
 * {@code PrivateKeyEntry} or a {@code SecretKeyEntry}.
 *
 * @param alias the alias for the keystore entry to be checked
 *
 * @return true if the entry identified by the given alias is a
 * key-related, false otherwise.
 */

public abstract boolean engineIsKeyEntry(java.lang.String alias);

/**
 * Returns true if the entry identified by the given alias
 * was created by a call to {@code setCertificateEntry},
 * or created by a call to {@code setEntry} with a
 * {@code TrustedCertificateEntry}.
 *
 * @param alias the alias for the keystore entry to be checked
 *
 * @return true if the entry identified by the given alias contains a
 * trusted certificate, false otherwise.
 */

public abstract boolean engineIsCertificateEntry(java.lang.String alias);

/**
 * Returns the (alias) name of the first keystore entry whose certificate
 * matches the given certificate.
 *
 * <p>This method attempts to match the given certificate with each
 * keystore entry. If the entry being considered was
 * created by a call to {@code setCertificateEntry},
 * or created by a call to {@code setEntry} with a
 * {@code TrustedCertificateEntry},
 * then the given certificate is compared to that entry's certificate.
 *
 * <p> If the entry being considered was
 * created by a call to {@code setKeyEntry},
 * or created by a call to {@code setEntry} with a
 * {@code PrivateKeyEntry},
 * then the given certificate is compared to the first
 * element of that entry's certificate chain.
 *
 * @param cert the certificate to match with.
 *
 * @return the alias name of the first entry with matching certificate,
 * or null if no such entry exists in this keystore.
 */

public abstract java.lang.String engineGetCertificateAlias(java.security.cert.Certificate cert);

/**
 * Stores this keystore to the given output stream, and protects its
 * integrity with the given password.
 *
 * @param stream the output stream to which this keystore is written.
 * @param password the password to generate the keystore integrity check
 *
 * @exception IOException if there was an I/O problem with data
 * @exception NoSuchAlgorithmException if the appropriate data integrity
 * algorithm could not be found
 * @exception CertificateException if any of the certificates included in
 * the keystore data could not be stored
 */

public abstract void engineStore(java.io.OutputStream stream, char[] password) throws java.security.cert.CertificateException, java.io.IOException, java.security.NoSuchAlgorithmException;

/**
 * Stores this keystore using the given
 * {@code KeyStore.LoadStoreParmeter}.
 *
 * @param param the {@code KeyStore.LoadStoreParmeter}
 *          that specifies how to store the keystore,
 *          which may be {@code null}
 *
 * @exception IllegalArgumentException if the given
 *          {@code KeyStore.LoadStoreParmeter}
 *          input is not recognized
 * @exception IOException if there was an I/O problem with data
 * @exception NoSuchAlgorithmException if the appropriate data integrity
 *          algorithm could not be found
 * @exception CertificateException if any of the certificates included in
 *          the keystore data could not be stored
 *
 * @since 1.5
 */

public void engineStore(java.security.KeyStore.LoadStoreParameter param) throws java.security.cert.CertificateException, java.io.IOException, java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Loads the keystore from the given input stream.
 *
 * <p>A password may be given to unlock the keystore
 * (e.g. the keystore resides on a hardware token device),
 * or to check the integrity of the keystore data.
 * If a password is not given for integrity checking,
 * then integrity checking is not performed.
 *
 * @param stream the input stream from which the keystore is loaded,
 * or {@code null}
 * @param password the password used to check the integrity of
 * the keystore, the password used to unlock the keystore,
 * or {@code null}
 *
 * @exception IOException if there is an I/O or format problem with the
 * keystore data, if a password is required but not given,
 * or if the given password was incorrect. If the error is due to a
 * wrong password, the {@link Throwable#getCause cause} of the
 * {@code IOException} should be an
 * {@code UnrecoverableKeyException}
 * @exception NoSuchAlgorithmException if the algorithm used to check
 * the integrity of the keystore cannot be found
 * @exception CertificateException if any of the certificates in the
 * keystore could not be loaded
 */

public abstract void engineLoad(java.io.InputStream stream, char[] password) throws java.security.cert.CertificateException, java.io.IOException, java.security.NoSuchAlgorithmException;

/**
 * Loads the keystore using the given
 * {@code KeyStore.LoadStoreParameter}.
 *
 * <p> Note that if this KeyStore has already been loaded, it is
 * reinitialized and loaded again from the given parameter.
 *
 * @param param the {@code KeyStore.LoadStoreParameter}
 *          that specifies how to load the keystore,
 *          which may be {@code null}
 *
 * @exception IllegalArgumentException if the given
 *          {@code KeyStore.LoadStoreParameter}
 *          input is not recognized
 * @exception IOException if there is an I/O or format problem with the
 *          keystore data. If the error is due to an incorrect
 *         {@code ProtectionParameter} (e.g. wrong password)
 *         the {@link Throwable#getCause cause} of the
 *         {@code IOException} should be an
 *         {@code UnrecoverableKeyException}
 * @exception NoSuchAlgorithmException if the algorithm used to check
 *          the integrity of the keystore cannot be found
 * @exception CertificateException if any of the certificates in the
 *          keystore could not be loaded
 *
 * @since 1.5
 */

public void engineLoad(java.security.KeyStore.LoadStoreParameter param) throws java.security.cert.CertificateException, java.io.IOException, java.security.NoSuchAlgorithmException { throw new RuntimeException("Stub!"); }

/**
 * Gets a {@code KeyStore.Entry} for the specified alias
 * with the specified protection parameter.
 *
 * @param alias get the {@code KeyStore.Entry} for this alias
 * @param protParam the {@code ProtectionParameter}
 *          used to protect the {@code Entry},
 *          which may be {@code null}
 *
 * @return the {@code KeyStore.Entry} for the specified alias,
 *          or {@code null} if there is no such entry
 *
 * @exception KeyStoreException if the operation failed
 * @exception NoSuchAlgorithmException if the algorithm for recovering the
 *          entry cannot be found
 * @exception UnrecoverableEntryException if the specified
 *          {@code protParam} were insufficient or invalid
 * @exception UnrecoverableKeyException if the entry is a
 *          {@code PrivateKeyEntry} or {@code SecretKeyEntry}
 *          and the specified {@code protParam} does not contain
 *          the information needed to recover the key (e.g. wrong password)
 *
 * @since 1.5
 */

public java.security.KeyStore.Entry engineGetEntry(java.lang.String alias, java.security.KeyStore.ProtectionParameter protParam) throws java.security.KeyStoreException, java.security.NoSuchAlgorithmException, java.security.UnrecoverableEntryException { throw new RuntimeException("Stub!"); }

/**
 * Saves a {@code KeyStore.Entry} under the specified alias.
 * The specified protection parameter is used to protect the
 * {@code Entry}.
 *
 * <p> If an entry already exists for the specified alias,
 * it is overridden.
 *
 * @param alias save the {@code KeyStore.Entry} under this alias
 * @param entry the {@code Entry} to save
 * @param protParam the {@code ProtectionParameter}
 *          used to protect the {@code Entry},
 *          which may be {@code null}
 *
 * @exception KeyStoreException if this operation fails
 *
 * @since 1.5
 */

public void engineSetEntry(java.lang.String alias, java.security.KeyStore.Entry entry, java.security.KeyStore.ProtectionParameter protParam) throws java.security.KeyStoreException { throw new RuntimeException("Stub!"); }

/**
 * Determines if the keystore {@code Entry} for the specified
 * {@code alias} is an instance or subclass of the specified
 * {@code entryClass}.
 *
 * @param alias the alias name
 * @param entryClass the entry class
 *
 * @return true if the keystore {@code Entry} for the specified
 *          {@code alias} is an instance or subclass of the
 *          specified {@code entryClass}, false otherwise
 *
 * @since 1.5
 */

public boolean engineEntryInstanceOf(java.lang.String alias, java.lang.Class<? extends java.security.KeyStore.Entry> entryClass) { throw new RuntimeException("Stub!"); }
}

