/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.nfc.tech;

import android.nfc.Tag;
import java.io.IOException;

/**
 * Provides access to ISO-DEP (ISO 14443-4) properties and I/O operations on a {@link Tag}.
 *
 * <p>Acquire an {@link IsoDep} object using {@link #get}.
 * <p>The primary ISO-DEP I/O operation is {@link #transceive}. Applications must
 * implement their own protocol stack on top of {@link #transceive}.
 * <p>Tags that enumerate the {@link IsoDep} technology in {@link Tag#getTechList}
 * will also enumerate
 * {@link NfcA} or {@link NfcB} (since IsoDep builds on top of either of these).
 *
 * <p class="note"><strong>Note:</strong> Methods that perform I/O operations
 * require the {@link android.Manifest.permission#NFC} permission.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class IsoDep implements android.nfc.tech.TagTechnology {

/** @hide */

IsoDep(android.nfc.Tag tag) throws android.os.RemoteException { throw new RuntimeException("Stub!"); }

/**
 * Get an instance of {@link IsoDep} for the given tag.
 * <p>Does not cause any RF activity and does not block.
 * <p>Returns null if {@link IsoDep} was not enumerated in {@link Tag#getTechList}.
 * This indicates the tag does not support ISO-DEP.
 *
 * @param tag an ISO-DEP compatible tag
 * @return ISO-DEP object
 */

public static android.nfc.tech.IsoDep get(android.nfc.Tag tag) { throw new RuntimeException("Stub!"); }

/**
 * Set the timeout of {@link #transceive} in milliseconds.
 * <p>The timeout only applies to ISO-DEP {@link #transceive}, and is
 * reset to a default value when {@link #close} is called.
 * <p>Setting a longer timeout may be useful when performing
 * transactions that require a long processing time on the tag
 * such as key generation.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param timeout timeout value in milliseconds
 */

public void setTimeout(int timeout) { throw new RuntimeException("Stub!"); }

/**
 * Get the current timeout for {@link #transceive} in milliseconds.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @return timeout value in milliseconds
 */

public int getTimeout() { throw new RuntimeException("Stub!"); }

/**
 * Return the ISO-DEP historical bytes for {@link NfcA} tags.
 * <p>Does not cause any RF activity and does not block.
 * <p>The historical bytes can be used to help identify a tag. They are present
 * only on {@link IsoDep} tags that are based on {@link NfcA} RF technology.
 * If this tag is not {@link NfcA} then null is returned.
 * <p>In ISO 14443-4 terminology, the historical bytes are a subset of the RATS
 * response.
 *
 * @return ISO-DEP historical bytes, or null if this is not a {@link NfcA} tag
 */

public byte[] getHistoricalBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the higher layer response bytes for {@link NfcB} tags.
 * <p>Does not cause any RF activity and does not block.
 * <p>The higher layer response bytes can be used to help identify a tag.
 * They are present only on {@link IsoDep} tags that are based on {@link NfcB}
 * RF technology. If this tag is not {@link NfcB} then null is returned.
 * <p>In ISO 14443-4 terminology, the higher layer bytes are a subset of the
 * ATTRIB response.
 *
 * @return ISO-DEP historical bytes, or null if this is not a {@link NfcB} tag
 */

public byte[] getHiLayerResponse() { throw new RuntimeException("Stub!"); }

/**
 * Send raw ISO-DEP data to the tag and receive the response.
 *
 * <p>Applications must only send the INF payload, and not the start of frame and
 * end of frame indicators. Applications do not need to fragment the payload, it
 * will be automatically fragmented and defragmented by {@link #transceive} if
 * it exceeds FSD/FSC limits.
 *
 * <p>Use {@link #getMaxTransceiveLength} to retrieve the maximum number of bytes
 * that can be sent with {@link #transceive}.
 *
 * <p>This is an I/O operation and will block until complete. It must
 * not be called from the main application thread. A blocked call will be canceled with
 * {@link IOException} if {@link #close} is called from another thread.
 *
 * <p class="note">Requires the {@link android.Manifest.permission#NFC} permission.
 *
 * @param data command bytes to send, must not be null
 * @return response bytes received, will not be null
 * @throws TagLostException if the tag leaves the field
 * @throws IOException if there is an I/O failure, or this operation is canceled
 */

public byte[] transceive(byte[] data) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Return the maximum number of bytes that can be sent with {@link #transceive}.
 * @return the maximum number of bytes that can be sent with {@link #transceive}.
 */

public int getMaxTransceiveLength() { throw new RuntimeException("Stub!"); }

/**
 * <p>Standard APDUs have a 1-byte length field, allowing a maximum of
 * 255 payload bytes, which results in a maximum APDU length of 261 bytes.
 *
 * <p>Extended length APDUs have a 3-byte length field, allowing 65535
 * payload bytes.
 *
 * <p>Some NFC adapters, like the one used in the Nexus S and the Galaxy Nexus
 * do not support extended length APDUs. They are expected to be well-supported
 * in the future though. Use this method to check for extended length APDU
 * support.
 *
 * @return whether the NFC adapter on this device supports extended length APDUs.
 */

public boolean isExtendedLengthApduSupported() { throw new RuntimeException("Stub!"); }

public boolean isConnected() { throw new RuntimeException("Stub!"); }

public android.nfc.Tag getTag() { throw new RuntimeException("Stub!"); }

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public void connect() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

