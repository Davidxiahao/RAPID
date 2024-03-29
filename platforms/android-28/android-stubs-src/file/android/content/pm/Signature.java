/*
 * Copyright (C) 2008 The Android Open Source Project
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


package android.content.pm;

import java.security.cert.CertificateEncodingException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

/**
 * Opaque, immutable representation of a signing certificate associated with an
 * application package.
 * <p>
 * This class name is slightly misleading, since it's not actually a signature.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Signature implements android.os.Parcelable {

/**
 * Create Signature from an existing raw byte array.
 */

public Signature(byte[] signature) { throw new RuntimeException("Stub!"); }

/**
 * Create Signature from a text representation previously returned by
 * {@link #toChars} or {@link #toCharsString()}. Signatures are expected to
 * be a hex-encoded ASCII string.
 *
 * @param text hex-encoded string representing the signature
 * @throws IllegalArgumentException when signature is odd-length
 */

public Signature(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Encode the Signature as ASCII text.
 */

public char[] toChars() { throw new RuntimeException("Stub!"); }

/**
 * Encode the Signature as ASCII text in to an existing array.
 *
 * @param existingArray Existing char array or null.
 * @param outLen Output parameter for the number of characters written in
 * to the array.
 * @return Returns either <var>existingArray</var> if it was large enough
 * to hold the ASCII representation, or a newly created char[] array if
 * needed.
 */

public char[] toChars(char[] existingArray, int[] outLen) { throw new RuntimeException("Stub!"); }

/**
 * Return the result of {@link #toChars()} as a String.
 */

public java.lang.String toCharsString() { throw new RuntimeException("Stub!"); }

/**
 * @return the contents of this signature as a byte array.
 */

public byte[] toByteArray() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.Signature> CREATOR;
static { CREATOR = null; }
}

