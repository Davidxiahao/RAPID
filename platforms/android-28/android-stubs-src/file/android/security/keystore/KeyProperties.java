/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.security.keystore;


/**
 * Properties of <a href="{@docRoot}training/articles/keystore.html">Android Keystore</a> keys.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class KeyProperties {

KeyProperties() { throw new RuntimeException("Stub!"); }

/** Cipher Block Chaining (CBC) block mode. */

public static final java.lang.String BLOCK_MODE_CBC = "CBC";

/** Counter (CTR) block mode. */

public static final java.lang.String BLOCK_MODE_CTR = "CTR";

/** Electronic Codebook (ECB) block mode. */

public static final java.lang.String BLOCK_MODE_ECB = "ECB";

/** Galois/Counter Mode (GCM) block mode. */

public static final java.lang.String BLOCK_MODE_GCM = "GCM";

/**
 * MD5 digest.
 */

public static final java.lang.String DIGEST_MD5 = "MD5";

/**
 * No digest: sign/authenticate the raw message.
 */

public static final java.lang.String DIGEST_NONE = "NONE";

/**
 * SHA-1 digest.
 */

public static final java.lang.String DIGEST_SHA1 = "SHA-1";

/**
 * SHA-2 224 (aka SHA-224) digest.
 */

public static final java.lang.String DIGEST_SHA224 = "SHA-224";

/**
 * SHA-2 256 (aka SHA-256) digest.
 */

public static final java.lang.String DIGEST_SHA256 = "SHA-256";

/**
 * SHA-2 384 (aka SHA-384) digest.
 */

public static final java.lang.String DIGEST_SHA384 = "SHA-384";

/**
 * SHA-2 512 (aka SHA-512) digest.
 */

public static final java.lang.String DIGEST_SHA512 = "SHA-512";

/**
 * No encryption padding.
 */

public static final java.lang.String ENCRYPTION_PADDING_NONE = "NoPadding";

/**
 * PKCS#7 encryption padding scheme.
 */

public static final java.lang.String ENCRYPTION_PADDING_PKCS7 = "PKCS7Padding";

/**
 * RSA Optimal Asymmetric Encryption Padding (OAEP) scheme.
 */

public static final java.lang.String ENCRYPTION_PADDING_RSA_OAEP = "OAEPPadding";

/**
 * RSA PKCS#1 v1.5 padding scheme for encryption.
 */

public static final java.lang.String ENCRYPTION_PADDING_RSA_PKCS1 = "PKCS1Padding";

/**
 * Triple Data Encryption Algorithm (3DES) key.
 *
 * @deprecated Included for interoperability with legacy systems. Prefer {@link
 * KeyProperties#KEY_ALGORITHM_AES} for new development.
 */

@Deprecated public static final java.lang.String KEY_ALGORITHM_3DES = "DESede";

/** Advanced Encryption Standard (AES) key. */

public static final java.lang.String KEY_ALGORITHM_AES = "AES";

/** Elliptic Curve (EC) Cryptography key. */

public static final java.lang.String KEY_ALGORITHM_EC = "EC";

/** Keyed-Hash Message Authentication Code (HMAC) key using SHA-1 as the hash. */

public static final java.lang.String KEY_ALGORITHM_HMAC_SHA1 = "HmacSHA1";

/** Keyed-Hash Message Authentication Code (HMAC) key using SHA-224 as the hash. */

public static final java.lang.String KEY_ALGORITHM_HMAC_SHA224 = "HmacSHA224";

/** Keyed-Hash Message Authentication Code (HMAC) key using SHA-256 as the hash. */

public static final java.lang.String KEY_ALGORITHM_HMAC_SHA256 = "HmacSHA256";

/** Keyed-Hash Message Authentication Code (HMAC) key using SHA-384 as the hash. */

public static final java.lang.String KEY_ALGORITHM_HMAC_SHA384 = "HmacSHA384";

/** Keyed-Hash Message Authentication Code (HMAC) key using SHA-512 as the hash. */

public static final java.lang.String KEY_ALGORITHM_HMAC_SHA512 = "HmacSHA512";

/** Rivest Shamir Adleman (RSA) key. */

public static final java.lang.String KEY_ALGORITHM_RSA = "RSA";

/** Key was generated inside AndroidKeyStore. */

public static final int ORIGIN_GENERATED = 1; // 0x1

/** Key was imported into AndroidKeyStore. */

public static final int ORIGIN_IMPORTED = 2; // 0x2

/**
 * Key was imported into the AndroidKeyStore in an encrypted wrapper. Unlike imported keys,
 * securely imported keys can be imported without appearing as plaintext in the device's host
 * memory.
 */

public static final int ORIGIN_SECURELY_IMPORTED = 8; // 0x8

/**
 * Origin of the key is unknown. This can occur only for keys backed by an old TEE-backed
 * implementation which does not record origin information.
 */

public static final int ORIGIN_UNKNOWN = 4; // 0x4

/**
 * Purpose of key: decryption.
 */

public static final int PURPOSE_DECRYPT = 2; // 0x2

/**
 * Purpose of key: encryption.
 */

public static final int PURPOSE_ENCRYPT = 1; // 0x1

/**
 * Purpose of key: signing or generating a Message Authentication Code (MAC).
 */

public static final int PURPOSE_SIGN = 4; // 0x4

/**
 * Purpose of key: signature or Message Authentication Code (MAC) verification.
 */

public static final int PURPOSE_VERIFY = 8; // 0x8

/**
 * Purpose of key: wrapping and unwrapping wrapped keys for secure import.
 */

public static final int PURPOSE_WRAP_KEY = 32; // 0x20

/**
 * RSA PKCS#1 v1.5 padding for signatures.
 */

public static final java.lang.String SIGNATURE_PADDING_RSA_PKCS1 = "PKCS1";

/**
 * RSA PKCS#1 v2.1 Probabilistic Signature Scheme (PSS) padding.
 */

public static final java.lang.String SIGNATURE_PADDING_RSA_PSS = "PSS";
}

