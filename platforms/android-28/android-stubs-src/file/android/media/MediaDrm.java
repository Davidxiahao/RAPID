/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.media;

import android.os.Looper;
import java.util.List;
import java.util.UUID;
import android.os.Handler;
import android.os.PersistableBundle;

/**
 * MediaDrm can be used to obtain keys for decrypting protected media streams, in
 * conjunction with {@link android.media.MediaCrypto}.  The MediaDrm APIs
 * are designed to support the ISO/IEC 23001-7: Common Encryption standard, but
 * may also be used to implement other encryption schemes.
 * <p>
 * Encrypted content is prepared using an encryption server and stored in a content
 * library. The encrypted content is streamed or downloaded from the content library to
 * client devices via content servers.  Licenses to view the content are obtained from
 * a License Server.
 * <p>
 * <p><img src="../../../images/mediadrm_overview.png"
 *      alt="MediaDrm Overview diagram"
 *      border="0" /></p>
 * <p>
 * Keys are requested from the license server using a key request. The key
 * response is delivered to the client app, which provides the response to the
 * MediaDrm API.
 * <p>
 * A Provisioning server may be required to distribute device-unique credentials to
 * the devices.
 * <p>
 * Enforcing requirements related to the number of devices that may play content
 * simultaneously can be performed either through key renewal or using the secure
 * stop methods.
 * <p>
 * The following sequence diagram shows the interactions between the objects
 * involved while playing back encrypted content:
 * <p>
 * <p><img src="../../../images/mediadrm_decryption_sequence.png"
 *         alt="MediaDrm Overview diagram"
 *         border="0" /></p>
 * <p>
 * The app first constructs {@link android.media.MediaExtractor} and
 * {@link android.media.MediaCodec} objects. It accesses the DRM-scheme-identifying UUID,
 * typically from metadata in the content, and uses this UUID to construct an instance
 * of a MediaDrm object that is able to support the DRM scheme required by the content.
 * Crypto schemes are assigned 16 byte UUIDs.  The method {@link #isCryptoSchemeSupported}
 * can be used to query if a given scheme is supported on the device.
 * <p>
 * The app calls {@link #openSession} to generate a sessionId that will uniquely identify
 * the session in subsequent interactions. The app next uses the MediaDrm object to
 * obtain a key request message and send it to the license server, then provide
 * the server's response to the MediaDrm object.
 * <p>
 * Once the app has a sessionId, it can construct a MediaCrypto object from the UUID and
 * sessionId.  The MediaCrypto object is registered with the MediaCodec in the
 * {@link MediaCodec#configure} method to enable the codec to decrypt content.
 * <p>
 * When the app has constructed {@link android.media.MediaExtractor},
 * {@link android.media.MediaCodec} and {@link android.media.MediaCrypto} objects,
 * it proceeds to pull samples from the extractor and queue them into the decoder.  For
 * encrypted content, the samples returned from the extractor remain encrypted, they
 * are only decrypted when the samples are delivered to the decoder.
 * <p>
 * MediaDrm methods throw {@link android.media.MediaDrm.MediaDrmStateException}
 * when a method is called on a MediaDrm object that has had an unrecoverable failure
 * in the DRM plugin or security hardware.
 * {@link android.media.MediaDrm.MediaDrmStateException} extends
 * {@link java.lang.IllegalStateException} with the addition of a developer-readable
 * diagnostic information string associated with the exception.
 * <p>
 * In the event of a mediaserver process crash or restart while a MediaDrm object
 * is active, MediaDrm methods may throw {@link android.media.MediaDrmResetException}.
 * To recover, the app must release the MediaDrm object, then create and initialize
 * a new one.
 * <p>
 * As {@link android.media.MediaDrmResetException} and
 * {@link android.media.MediaDrm.MediaDrmStateException} both extend
 * {@link java.lang.IllegalStateException}, they should be in an earlier catch()
 * block than {@link java.lang.IllegalStateException} if handled separately.
 * <p>
 * <a name="Callbacks"></a>
 * <h3>Callbacks</h3>
 * <p>Applications should register for informational events in order
 * to be informed of key state updates during playback or streaming.
 * Registration for these events is done via a call to
 * {@link #setOnEventListener}. In order to receive the respective
 * callback associated with this listener, applications are required to create
 * MediaDrm objects on a thread with its own Looper running (main UI
 * thread by default has a Looper running).
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaDrm implements java.lang.AutoCloseable {

/**
 * Instantiate a MediaDrm object
 *
 * @param uuid The UUID of the crypto scheme.
 *
 * This value must never be {@code null}.
 * @throws UnsupportedSchemeException if the device does not support the
 * specified scheme UUID
 */

public MediaDrm(@androidx.annotation.RecentlyNonNull java.util.UUID uuid) throws android.media.UnsupportedSchemeException { throw new RuntimeException("Stub!"); }

/**
 * Query if the given scheme identified by its UUID is supported on
 * this device.
 * @param uuid The UUID of the crypto scheme.

 * This value must never be {@code null}.
 */

public static boolean isCryptoSchemeSupported(@androidx.annotation.RecentlyNonNull java.util.UUID uuid) { throw new RuntimeException("Stub!"); }

/**
 * Query if the given scheme identified by its UUID is supported on
 * this device, and whether the DRM plugin is able to handle the
 * media container format specified by mimeType.
 * @param uuid The UUID of the crypto scheme.
 * This value must never be {@code null}.
 * @param mimeType The MIME type of the media container, e.g. "video/mp4"
 *   or "video/webm"

 * This value must never be {@code null}.
 */

public static boolean isCryptoSchemeSupported(@androidx.annotation.RecentlyNonNull java.util.UUID uuid, @androidx.annotation.RecentlyNonNull java.lang.String mimeType) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when a session expiration update
 * occurs.  The app's OnExpirationUpdateListener will be notified
 * when the expiration time of the keys in the session have changed.
 * @param listener the callback that will be run, or {@code null} to unregister the
 *     previously registered callback.
 * This value may be {@code null}.
 * @param handler the handler on which the listener should be invoked, or
 *     {@code null} if the listener should be invoked on the calling thread's looper.

 * This value may be {@code null}.
 */

public void setOnExpirationUpdateListener(@androidx.annotation.RecentlyNullable android.media.MediaDrm.OnExpirationUpdateListener listener, @androidx.annotation.RecentlyNullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the state of keys in a session
 * change, e.g.&nbsp;when a license update occurs or when a license expires.
 *
 * @param listener the callback that will be run when key status changes, or
 *     {@code null} to unregister the previously registered callback.
 * This value may be {@code null}.
 * @param handler the handler on which the listener should be invoked, or
 *     null if the listener should be invoked on the calling thread's looper.

 * This value may be {@code null}.
 */

public void setOnKeyStatusChangeListener(@androidx.annotation.RecentlyNullable android.media.MediaDrm.OnKeyStatusChangeListener listener, @androidx.annotation.RecentlyNullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when an event occurs
 *
 * @param listener the callback that will be run.  Use {@code null} to
 *        stop receiving event callbacks.

 * This value may be {@code null}.
 */

public void setOnEventListener(@androidx.annotation.RecentlyNullable android.media.MediaDrm.OnEventListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Open a new session with the MediaDrm object. A session ID is returned.
 * By default, sessions are opened at the native security level of the device.
 *
 * @throws NotProvisionedException if provisioning is needed
 * @throws ResourceBusyException if required resources are in use

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public byte[] openSession() throws android.media.NotProvisionedException, android.media.ResourceBusyException { throw new RuntimeException("Stub!"); }

/**
 * Open a new session at a requested security level. The security level
 * represents the robustness of the device's DRM implementation. By default,
 * sessions are opened at the native security level of the device.
 * Overriding the security level is necessary when the decrypted frames need
 * to be manipulated, such as for image compositing. The security level
 * parameter must be lower than the native level. Reducing the security
 * level will typically limit the content to lower resolutions, as
 * determined by the license policy. If the requested level is not
 * supported, the next lower supported security level will be set. The level
 * can be queried using {@link #getSecurityLevel}. A session
 * ID is returned.
 *
 * @param level the new security level, one of
 * {@link #SECURITY_LEVEL_SW_SECURE_CRYPTO},
 * {@link #SECURITY_LEVEL_SW_SECURE_DECODE},
 * {@link #SECURITY_LEVEL_HW_SECURE_CRYPTO},
 * {@link #SECURITY_LEVEL_HW_SECURE_DECODE} or
 * {@link #SECURITY_LEVEL_HW_SECURE_ALL}.
 *
 * Value is {@link android.media.MediaDrm#SECURITY_LEVEL_UNKNOWN}, {@link android.media.MediaDrm#SECURITY_LEVEL_SW_SECURE_CRYPTO}, {@link android.media.MediaDrm#SECURITY_LEVEL_SW_SECURE_DECODE}, {@link android.media.MediaDrm#SECURITY_LEVEL_HW_SECURE_CRYPTO}, {@link android.media.MediaDrm#SECURITY_LEVEL_HW_SECURE_DECODE}, or {@link android.media.MediaDrm#SECURITY_LEVEL_HW_SECURE_ALL}
 * @throws NotProvisionedException if provisioning is needed
 * @throws ResourceBusyException if required resources are in use
 * @throws IllegalArgumentException if the requested security level is
 * higher than the native level or lower than the lowest supported level or
 * if the device does not support specifying the security level when opening
 * a session
 
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public native byte[] openSession(int level) throws android.media.NotProvisionedException, android.media.ResourceBusyException;

/**
 * Close a session on the MediaDrm object that was previously opened
 * with {@link #openSession}.

 * @param sessionId This value must never be {@code null}.
 */

public native void closeSession(@androidx.annotation.RecentlyNonNull byte[] sessionId);

/**
 * A key request/response exchange occurs between the app and a license server
 * to obtain or release keys used to decrypt encrypted content.
 * <p>
 * getKeyRequest() is used to obtain an opaque key request byte array that is
 * delivered to the license server.  The opaque key request byte array is returned
 * in KeyRequest.data.  The recommended URL to deliver the key request to is
 * returned in KeyRequest.defaultUrl.
 * <p>
 * After the app has received the key request response from the server,
 * it should deliver to the response to the MediaDrm instance using the method
 * {@link #provideKeyResponse}.
 *
 * @param scope may be a sessionId or a keySetId, depending on the specified keyType.
 * When the keyType is KEY_TYPE_STREAMING or KEY_TYPE_OFFLINE,
 * scope should be set to the sessionId the keys will be provided to.  When the keyType
 * is KEY_TYPE_RELEASE, scope should be set to the keySetId of the keys
 * being released. Releasing keys from a device invalidates them for all sessions.
 * This value must never be {@code null}.
 * @param init container-specific data, its meaning is interpreted based on the
 * mime type provided in the mimeType parameter.  It could contain, for example,
 * the content ID, key ID or other data obtained from the content metadata that is
 * required in generating the key request. May be null when keyType is
 * KEY_TYPE_RELEASE or if the request is a renewal, i.e. not the first key
 * request for the session.
 * This value may be {@code null}.
 * @param mimeType identifies the mime type of the content. May be null if the
 * keyType is KEY_TYPE_RELEASE or if the request is a renewal, i.e. not the
 * first key request for the session.
 * This value may be {@code null}.
 * @param keyType specifes the type of the request. The request may be to acquire
 * keys for streaming or offline content, or to release previously acquired
 * keys, which are identified by a keySetId.
 * Value is {@link android.media.MediaDrm#KEY_TYPE_STREAMING}, {@link android.media.MediaDrm#KEY_TYPE_OFFLINE}, or {@link android.media.MediaDrm#KEY_TYPE_RELEASE}
 * @param optionalParameters are included in the key request message to
 * allow a client application to provide additional message parameters to the server.
 * This may be {@code null} if no additional parameters are to be sent.
 * This value may be {@code null}.
 * @throws NotProvisionedException if reprovisioning is needed, due to a
 * problem with the certifcate
 */

@androidx.annotation.RecentlyNonNull public native android.media.MediaDrm.KeyRequest getKeyRequest(@androidx.annotation.RecentlyNonNull byte[] scope, @androidx.annotation.RecentlyNullable byte[] init, @androidx.annotation.RecentlyNullable java.lang.String mimeType, int keyType, @androidx.annotation.RecentlyNullable java.util.HashMap<java.lang.String, java.lang.String> optionalParameters) throws android.media.NotProvisionedException;

/**
 * A key response is received from the license server by the app, then it is
 * provided to the MediaDrm instance using provideKeyResponse.  When the
 * response is for an offline key request, a keySetId is returned that can be
 * used to later restore the keys to a new session with the method
 * {@link #restoreKeys}.
 * When the response is for a streaming or release request, an empty byte array
 * is returned.
 *
 * @param scope may be a sessionId or keySetId depending on the type of the
 * response.  Scope should be set to the sessionId when the response is for either
 * streaming or offline key requests.  Scope should be set to the keySetId when
 * the response is for a release request.
 * This value must never be {@code null}.
 * @param response the byte array response from the server
 * This value must never be {@code null}.
 * @return If the response is for an offline request, the keySetId for the offline
 * keys will be returned. If the response is for a streaming or release request
 * an empty byte array will be returned.
 *
 * This value may be {@code null}.
 * @throws NotProvisionedException if the response indicates that
 * reprovisioning is required
 * @throws DeniedByServerException if the response indicates that the
 * server rejected the request
 */

@androidx.annotation.RecentlyNullable public native byte[] provideKeyResponse(@androidx.annotation.RecentlyNonNull byte[] scope, @androidx.annotation.RecentlyNonNull byte[] response) throws android.media.DeniedByServerException, android.media.NotProvisionedException;

/**
 * Restore persisted offline keys into a new session.  keySetId identifies the
 * keys to load, obtained from a prior call to {@link #provideKeyResponse}.
 *
 * @param sessionId the session ID for the DRM session
 * This value must never be {@code null}.
 * @param keySetId identifies the saved key set to restore

 * This value must never be {@code null}.
 */

public native void restoreKeys(@androidx.annotation.RecentlyNonNull byte[] sessionId, @androidx.annotation.RecentlyNonNull byte[] keySetId);

/**
 * Remove the current keys from a session.
 *
 * @param sessionId the session ID for the DRM session

 * This value must never be {@code null}.
 */

public native void removeKeys(@androidx.annotation.RecentlyNonNull byte[] sessionId);

/**
 * Request an informative description of the key status for the session.  The status is
 * in the form of {name, value} pairs.  Since DRM license policies vary by vendor,
 * the specific status field names are determined by each DRM vendor.  Refer to your
 * DRM provider documentation for definitions of the field names for a particular
 * DRM plugin.
 *
 * @param sessionId the session ID for the DRM session
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public native java.util.HashMap<java.lang.String, java.lang.String> queryKeyStatus(@androidx.annotation.RecentlyNonNull byte[] sessionId);

/**
 * A provision request/response exchange occurs between the app and a provisioning
 * server to retrieve a device certificate.  If provisionining is required, the
 * EVENT_PROVISION_REQUIRED event will be sent to the event handler.
 * getProvisionRequest is used to obtain the opaque provision request byte array that
 * should be delivered to the provisioning server. The provision request byte array
 * is returned in ProvisionRequest.data. The recommended URL to deliver the provision
 * request to is returned in ProvisionRequest.defaultUrl.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.media.MediaDrm.ProvisionRequest getProvisionRequest() { throw new RuntimeException("Stub!"); }

/**
 * After a provision response is received by the app, it is provided to the
 * MediaDrm instance using this method.
 *
 * @param response the opaque provisioning response byte array to provide to the
 * MediaDrm instance.
 *
 * This value must never be {@code null}.
 * @throws DeniedByServerException if the response indicates that the
 * server rejected the request
 */

public void provideProvisionResponse(@androidx.annotation.RecentlyNonNull byte[] response) throws android.media.DeniedByServerException { throw new RuntimeException("Stub!"); }

/**
 * Secure stops are a way to enforce limits on the number of concurrent
 * streams per subscriber across devices. They provide secure monitoring of
 * the lifetime of content decryption keys in MediaDrm sessions.
 * <p>
 * A secure stop is written to secure persistent memory when keys are loaded
 * into a MediaDrm session. The secure stop state indicates that the keys
 * are available for use. When playback completes and the keys are removed
 * or the session is destroyed, the secure stop state is updated to indicate
 * that keys are no longer usable.
 * <p>
 * After playback, the app can query the secure stop and send it in a
 * message to the license server confirming that the keys are no longer
 * active. The license server returns a secure stop release response
 * message to the app which then deletes the secure stop from persistent
 * memory using {@link #releaseSecureStops}.
 * <p>
 * Each secure stop has a unique ID that can be used to identify it during
 * enumeration, access and removal.
 * @return a list of all secure stops from secure persistent memory

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public native java.util.List<byte[]> getSecureStops();

/**
 * Return a list of all secure stop IDs currently in persistent memory.
 * The secure stop ID can be used to access or remove the corresponding
 * secure stop.
 *
 * @return a list of secure stop IDs

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public native java.util.List<byte[]> getSecureStopIds();

/**
 * Access a specific secure stop given its secure stop ID.
 * Each secure stop has a unique ID.
 *
 * @param ssid the ID of the secure stop to return
 * This value must never be {@code null}.
 * @return the secure stop identified by ssid
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public native byte[] getSecureStop(@androidx.annotation.RecentlyNonNull byte[] ssid);

/**
 * Process the secure stop server response message ssRelease.  After
 * authenticating the message, remove the secure stops identified in the
 * response.
 *
 * @param ssRelease the server response indicating which secure stops to release

 * This value must never be {@code null}.
 */

public native void releaseSecureStops(@androidx.annotation.RecentlyNonNull byte[] ssRelease);

/**
 * Remove a specific secure stop without requiring a secure stop release message
 * from the license server.
 * @param ssid the ID of the secure stop to remove

 * This value must never be {@code null}.
 */

public native void removeSecureStop(@androidx.annotation.RecentlyNonNull byte[] ssid);

/**
 * Remove all secure stops without requiring a secure stop release message from
 * the license server.
 *
 * This method was added in API 28. In API versions 18 through 27,
 * {@link #releaseAllSecureStops} should be called instead. There is no need to
 * do anything for API versions prior to 18.
 */

public native void removeAllSecureStops();

/**
 * Remove all secure stops without requiring a secure stop release message from
 * the license server.
 *
 * @deprecated Remove all secure stops using {@link #removeAllSecureStops} instead.
 */

@Deprecated public void releaseAllSecureStops() { throw new RuntimeException("Stub!"); }

/**
 * Return the HDCP level negotiated with downstream receivers the
 * device is connected to. If multiple HDCP-capable displays are
 * simultaneously connected to separate interfaces, this method
 * returns the lowest negotiated level of all interfaces.
 * <p>
 * This method should only be used for informational purposes, not for
 * enforcing compliance with HDCP requirements. Trusted enforcement of
 * HDCP policies must be handled by the DRM system.
 * <p>
 * @return one of {@link #HDCP_LEVEL_UNKNOWN}, {@link #HDCP_NONE},
 * {@link #HDCP_V1}, {@link #HDCP_V2}, {@link #HDCP_V2_1}, {@link #HDCP_V2_2}
 * or {@link #HDCP_NO_DIGITAL_OUTPUT}.

 * Value is {@link android.media.MediaDrm#HDCP_LEVEL_UNKNOWN}, {@link android.media.MediaDrm#HDCP_NONE}, {@link android.media.MediaDrm#HDCP_V1}, {@link android.media.MediaDrm#HDCP_V2}, {@link android.media.MediaDrm#HDCP_V2_1}, {@link android.media.MediaDrm#HDCP_V2_2}, or {@link android.media.MediaDrm#HDCP_NO_DIGITAL_OUTPUT}
 */

public native int getConnectedHdcpLevel();

/**
 * Return the maximum supported HDCP level. The maximum HDCP level is a
 * constant for a given device, it does not depend on downstream receivers
 * that may be connected. If multiple HDCP-capable interfaces are present,
 * it indicates the highest of the maximum HDCP levels of all interfaces.
 * <p>
 * @return one of {@link #HDCP_LEVEL_UNKNOWN}, {@link #HDCP_NONE},
 * {@link #HDCP_V1}, {@link #HDCP_V2}, {@link #HDCP_V2_1}, {@link #HDCP_V2_2}
 * or {@link #HDCP_NO_DIGITAL_OUTPUT}.

 * Value is {@link android.media.MediaDrm#HDCP_LEVEL_UNKNOWN}, {@link android.media.MediaDrm#HDCP_NONE}, {@link android.media.MediaDrm#HDCP_V1}, {@link android.media.MediaDrm#HDCP_V2}, {@link android.media.MediaDrm#HDCP_V2_1}, {@link android.media.MediaDrm#HDCP_V2_2}, or {@link android.media.MediaDrm#HDCP_NO_DIGITAL_OUTPUT}
 */

public native int getMaxHdcpLevel();

/**
 * Return the number of MediaDrm sessions that are currently opened
 * simultaneously among all MediaDrm instances for the active DRM scheme.
 * @return the number of open sessions.
 */

public native int getOpenSessionCount();

/**
 * Return the maximum number of MediaDrm sessions that may be opened
 * simultaneosly among all MediaDrm instances for the active DRM
 * scheme. The maximum number of sessions is not affected by any
 * sessions that may have already been opened.
 * @return maximum sessions.
 */

public native int getMaxSessionCount();

/**
 * The maximum security level supported by the device. This is the default
 * security level when a session is opened.

 * @return Value is {@link android.media.MediaDrm#SECURITY_LEVEL_UNKNOWN}, {@link android.media.MediaDrm#SECURITY_LEVEL_SW_SECURE_CRYPTO}, {@link android.media.MediaDrm#SECURITY_LEVEL_SW_SECURE_DECODE}, {@link android.media.MediaDrm#SECURITY_LEVEL_HW_SECURE_CRYPTO}, {@link android.media.MediaDrm#SECURITY_LEVEL_HW_SECURE_DECODE}, or {@link android.media.MediaDrm#SECURITY_LEVEL_HW_SECURE_ALL}
 */

public static int getMaxSecurityLevel() { throw new RuntimeException("Stub!"); }

/**
 * Return the current security level of a session. A session has an initial
 * security level determined by the robustness of the DRM system's
 * implementation on the device. The security level may be changed at the
 * time a session is opened using {@link #openSession}.
 * @param sessionId the session to query.
 * <p>
 * This value must never be {@code null}.
 * @return one of {@link #SECURITY_LEVEL_UNKNOWN},
 * {@link #SECURITY_LEVEL_SW_SECURE_CRYPTO}, {@link #SECURITY_LEVEL_SW_SECURE_DECODE},
 * {@link #SECURITY_LEVEL_HW_SECURE_CRYPTO}, {@link #SECURITY_LEVEL_HW_SECURE_DECODE} or
 * {@link #SECURITY_LEVEL_HW_SECURE_ALL}.
 
 * Value is {@link android.media.MediaDrm#SECURITY_LEVEL_UNKNOWN}, {@link android.media.MediaDrm#SECURITY_LEVEL_SW_SECURE_CRYPTO}, {@link android.media.MediaDrm#SECURITY_LEVEL_SW_SECURE_DECODE}, {@link android.media.MediaDrm#SECURITY_LEVEL_HW_SECURE_CRYPTO}, {@link android.media.MediaDrm#SECURITY_LEVEL_HW_SECURE_DECODE}, or {@link android.media.MediaDrm#SECURITY_LEVEL_HW_SECURE_ALL}
 */

public native int getSecurityLevel(@androidx.annotation.RecentlyNonNull byte[] sessionId);

/**
 * Read a MediaDrm String property value, given the property name string.
 * <p>
 * Standard fields names are:
 * {@link #PROPERTY_VENDOR}, {@link #PROPERTY_VERSION},
 * {@link #PROPERTY_DESCRIPTION}, {@link #PROPERTY_ALGORITHMS}
 
 * @param propertyName This value must never be {@code null}.
 * Value is {@link android.media.MediaDrm#PROPERTY_VENDOR}, {@link android.media.MediaDrm#PROPERTY_VERSION}, {@link android.media.MediaDrm#PROPERTY_DESCRIPTION}, or {@link android.media.MediaDrm#PROPERTY_ALGORITHMS}
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public native java.lang.String getPropertyString(@androidx.annotation.RecentlyNonNull java.lang.String propertyName);

/**
 * Set a MediaDrm String property value, given the property name string
 * and new value for the property.

 * @param propertyName This value must never be {@code null}.
 
 * Value is {@link android.media.MediaDrm#PROPERTY_VENDOR}, {@link android.media.MediaDrm#PROPERTY_VERSION}, {@link android.media.MediaDrm#PROPERTY_DESCRIPTION}, or {@link android.media.MediaDrm#PROPERTY_ALGORITHMS}

 * @param value This value must never be {@code null}.
 */

public native void setPropertyString(@androidx.annotation.RecentlyNonNull java.lang.String propertyName, @androidx.annotation.RecentlyNonNull java.lang.String value);

/**
 * Read a MediaDrm byte array property value, given the property name string.
 * <p>
 * Standard fields names are {@link #PROPERTY_DEVICE_UNIQUE_ID}
 
 * @param propertyName Value is {@link android.media.MediaDrm#PROPERTY_DEVICE_UNIQUE_ID}
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public native byte[] getPropertyByteArray(java.lang.String propertyName);

/**
 * Set a MediaDrm byte array property value, given the property name string
 * and new value for the property.

 * @param propertyName This value must never be {@code null}.
 
 * Value is {@link android.media.MediaDrm#PROPERTY_DEVICE_UNIQUE_ID}

 * @param value This value must never be {@code null}.
 */

public native void setPropertyByteArray(@androidx.annotation.RecentlyNonNull java.lang.String propertyName, @androidx.annotation.RecentlyNonNull byte[] value);

/**
 * Return Metrics data about the current MediaDrm instance.
 *
 * @return a {@link PersistableBundle} containing the set of attributes and values
 * available for this instance of MediaDrm.
 * The attributes are described in {@link MetricsConstants}.
 *
 * Additional vendor-specific fields may also be present in
 * the return value.
 */

public android.os.PersistableBundle getMetrics() { throw new RuntimeException("Stub!"); }

/**
 * Obtain a CryptoSession object which can be used to encrypt, decrypt,
 * sign and verify messages or data using the session keys established
 * for the session using methods {@link #getKeyRequest} and
 * {@link #provideKeyResponse} using a session key server.
 *
 * @param sessionId the session ID for the session containing keys
 * to be used for encrypt, decrypt, sign and/or verify
 * This value must never be {@code null}.
 * @param cipherAlgorithm the algorithm to use for encryption and
 * decryption ciphers. The algorithm string conforms to JCA Standard
 * Names for Cipher Transforms and is case insensitive.  For example
 * "AES/CBC/NoPadding".
 * This value must never be {@code null}.
 * @param macAlgorithm the algorithm to use for sign and verify
 * The algorithm string conforms to JCA Standard Names for Mac
 * Algorithms and is case insensitive.  For example "HmacSHA256".
 * <p>
 * The list of supported algorithms for a DRM plugin can be obtained
 * using the method {@link #getPropertyString} with the property name
 * "algorithms".

 * This value must never be {@code null}.
 */

public android.media.MediaDrm.CryptoSession getCryptoSession(@androidx.annotation.RecentlyNonNull byte[] sessionId, @androidx.annotation.RecentlyNonNull java.lang.String cipherAlgorithm, @androidx.annotation.RecentlyNonNull java.lang.String macAlgorithm) { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Releases resources associated with the current session of
 * MediaDrm. It is considered good practice to call this method when
 * the {@link MediaDrm} object is no longer needed in your
 * application. After this method is called, {@link MediaDrm} is no
 * longer usable since it has lost all of its required resource.
 *
 * This method was added in API 28. In API versions 18 through 27, release()
 * should be called instead. There is no need to do anything for API
 * versions prior to 18.
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated replaced by {@link #close()}.
 */

@Deprecated public void release() { throw new RuntimeException("Stub!"); }

/**
 * This event type indicates that the licensed usage duration for keys in a session
 * has expired.  The keys are no longer valid.
 * @deprecated Use {@link OnKeyStatusChangeListener#onKeyStatusChange}
 * and check for {@link MediaDrm.KeyStatus#STATUS_EXPIRED} in the {@link MediaDrm.KeyStatus}
 * instead.
 */

@Deprecated public static final int EVENT_KEY_EXPIRED = 3; // 0x3

/**
 * This event type indicates that the app needs to request keys from a license
 * server.  The request message data is obtained using {@link #getKeyRequest}.
 */

public static final int EVENT_KEY_REQUIRED = 2; // 0x2

/**
 * This event type indicates that the app needs to request a certificate from
 * the provisioning server.  The request message data is obtained using
 * {@link #getProvisionRequest}
 *
 * @deprecated Handle provisioning via {@link android.media.NotProvisionedException}
 * instead.
 */

@Deprecated public static final int EVENT_PROVISION_REQUIRED = 1; // 0x1

/**
 * This event indicates that a session opened by the app has been reclaimed by the resource
 * manager.
 */

public static final int EVENT_SESSION_RECLAIMED = 5; // 0x5

/**
 * This event may indicate some specific vendor-defined condition, see your
 * DRM provider documentation for details
 */

public static final int EVENT_VENDOR_DEFINED = 4; // 0x4

/**
 * The DRM plugin did not report an HDCP level, or an error
 * occurred accessing it
 */

public static final int HDCP_LEVEL_UNKNOWN = 0; // 0x0

/**
 * HDCP is not supported on this device, content is unprotected
 */

public static final int HDCP_NONE = 1; // 0x1

/**
 * No digital output, implicitly secure
 */

public static final int HDCP_NO_DIGITAL_OUTPUT = 2147483647; // 0x7fffffff

/**
 * HDCP version 1.0
 */

public static final int HDCP_V1 = 2; // 0x2

/**
 * HDCP version 2.0 Type 1.
 */

public static final int HDCP_V2 = 3; // 0x3

/**
 * HDCP version 2.1 Type 1.
 */

public static final int HDCP_V2_1 = 4; // 0x4

/**
 *  HDCP version 2.2 Type 1.
 */

public static final int HDCP_V2_2 = 5; // 0x5

/**
 * This key request type specifies that the keys will be for offline use, they
 * will be saved to the device for use when the device is not connected to a network.
 */

public static final int KEY_TYPE_OFFLINE = 2; // 0x2

/**
 * This key request type specifies that previously saved offline keys should be released.
 */

public static final int KEY_TYPE_RELEASE = 3; // 0x3

/**
 * This key request type species that the keys will be for online use, they will
 * not be saved to the device for subsequent use when the device is not connected
 * to a network.
 */

public static final int KEY_TYPE_STREAMING = 1; // 0x1

/**
 * String property name: a comma-separated list of cipher and mac algorithms
 * supported by CryptoSession.  The list may be empty if the DRM
 * plugin does not support CryptoSession operations.
 */

public static final java.lang.String PROPERTY_ALGORITHMS = "algorithms";

/**
 * String property name: describes the DRM plugin
 */

public static final java.lang.String PROPERTY_DESCRIPTION = "description";

/**
 * Byte array property name: the device unique identifier is established during
 * device provisioning and provides a means of uniquely identifying each device.
 */

public static final java.lang.String PROPERTY_DEVICE_UNIQUE_ID = "deviceUniqueId";

/**
 * String property name: identifies the maker of the DRM plugin
 */

public static final java.lang.String PROPERTY_VENDOR = "vendor";

/**
 * String property name: identifies the version of the DRM plugin
 */

public static final java.lang.String PROPERTY_VERSION = "version";

/**
 * DRM key management, crypto operations, decoding of content and all
 * handling of the media (compressed and uncompressed) is handled within a
 * hardware backed trusted execution environment.
 */

public static final int SECURITY_LEVEL_HW_SECURE_ALL = 5; // 0x5

/**
 * DRM key management and crypto operations are performed within a hardware
 * backed trusted execution environment.
 */

public static final int SECURITY_LEVEL_HW_SECURE_CRYPTO = 3; // 0x3

/**
 * DRM key management, crypto operations and decoding of content are
 * performed within a hardware backed trusted execution environment.
 */

public static final int SECURITY_LEVEL_HW_SECURE_DECODE = 4; // 0x4

/**
 * DRM key management uses software-based whitebox crypto.
 */

public static final int SECURITY_LEVEL_SW_SECURE_CRYPTO = 1; // 0x1

/**
 * DRM key management and decoding use software-based whitebox crypto.
 */

public static final int SECURITY_LEVEL_SW_SECURE_DECODE = 2; // 0x2

/**
 * The DRM plugin did not report a security level, or an error occurred
 * accessing it
 */

public static final int SECURITY_LEVEL_UNKNOWN = 0; // 0x0
/**
 * In addition to supporting decryption of DASH Common Encrypted Media, the
 * MediaDrm APIs provide the ability to securely deliver session keys from
 * an operator's session key server to a client device, based on the factory-installed
 * root of trust, and then perform encrypt, decrypt, sign and verify operations
 * with the session key on arbitrary user data.
 * <p>
 * The CryptoSession class implements generic encrypt/decrypt/sign/verify methods
 * based on the established session keys.  These keys are exchanged using the
 * getKeyRequest/provideKeyResponse methods.
 * <p>
 * Applications of this capability could include securing various types of
 * purchased or private content, such as applications, books and other media,
 * photos or media delivery protocols.
 * <p>
 * Operators can create session key servers that are functionally similar to a
 * license key server, except that instead of receiving license key requests and
 * providing encrypted content keys which are used specifically to decrypt A/V media
 * content, the session key server receives session key requests and provides
 * encrypted session keys which can be used for general purpose crypto operations.
 * <p>
 * A CryptoSession is obtained using {@link #getCryptoSession}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CryptoSession {

CryptoSession(byte[] sessionId, java.lang.String cipherAlgorithm, java.lang.String macAlgorithm) { throw new RuntimeException("Stub!"); }

/**
 * Encrypt data using the CryptoSession's cipher algorithm
 *
 * @param keyid specifies which key to use
 * This value must never be {@code null}.
 * @param input the data to encrypt
 * This value must never be {@code null}.
 * @param iv the initialization vector to use for the cipher
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public byte[] encrypt(@androidx.annotation.RecentlyNonNull byte[] keyid, @androidx.annotation.RecentlyNonNull byte[] input, @androidx.annotation.RecentlyNonNull byte[] iv) { throw new RuntimeException("Stub!"); }

/**
 * Decrypt data using the CryptoSessions's cipher algorithm
 *
 * @param keyid specifies which key to use
 * This value must never be {@code null}.
 * @param input the data to encrypt
 * This value must never be {@code null}.
 * @param iv the initialization vector to use for the cipher
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public byte[] decrypt(@androidx.annotation.RecentlyNonNull byte[] keyid, @androidx.annotation.RecentlyNonNull byte[] input, @androidx.annotation.RecentlyNonNull byte[] iv) { throw new RuntimeException("Stub!"); }

/**
 * Sign data using the CryptoSessions's mac algorithm.
 *
 * @param keyid specifies which key to use
 * This value must never be {@code null}.
 * @param message the data for which a signature is to be computed
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public byte[] sign(@androidx.annotation.RecentlyNonNull byte[] keyid, @androidx.annotation.RecentlyNonNull byte[] message) { throw new RuntimeException("Stub!"); }

/**
 * Verify a signature using the CryptoSessions's mac algorithm. Return true
 * if the signatures match, false if they do no.
 *
 * @param keyid specifies which key to use
 * This value must never be {@code null}.
 * @param message the data to verify
 * This value must never be {@code null}.
 * @param signature the reference signature which will be compared with the
 *        computed signature

 * This value must never be {@code null}.
 */

public boolean verify(@androidx.annotation.RecentlyNonNull byte[] keyid, @androidx.annotation.RecentlyNonNull byte[] message, @androidx.annotation.RecentlyNonNull byte[] signature) { throw new RuntimeException("Stub!"); }
}

/**
 * Value is {@link android.media.MediaDrm#HDCP_LEVEL_UNKNOWN}, {@link android.media.MediaDrm#HDCP_NONE}, {@link android.media.MediaDrm#HDCP_V1}, {@link android.media.MediaDrm#HDCP_V2}, {@link android.media.MediaDrm#HDCP_V2_1}, {@link android.media.MediaDrm#HDCP_V2_2}, or {@link android.media.MediaDrm#HDCP_NO_DIGITAL_OUTPUT}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE) public static @interface HdcpLevel {
}

/**
 * Contains the opaque data an app uses to request keys from a license server.
 * These request types may or may not be generated by a given plugin. Refer
 * to plugin vendor documentation for more information.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class KeyRequest {

KeyRequest() { throw new RuntimeException("Stub!"); }

/**
 * Get the opaque message data

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public byte[] getData() { throw new RuntimeException("Stub!"); }

/**
 * Get the default URL to use when sending the key request message to a
 * server, if known.  The app may prefer to use a different license
 * server URL from other sources.
 * This method returns an empty string if the default URL is not known.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getDefaultUrl() { throw new RuntimeException("Stub!"); }

/**
 * Get the type of the request
 * @return one of {@link #REQUEST_TYPE_INITIAL},
 * {@link #REQUEST_TYPE_RENEWAL}, {@link #REQUEST_TYPE_RELEASE},
 * {@link #REQUEST_TYPE_NONE} or {@link #REQUEST_TYPE_UPDATE}

 * Value is {@link android.media.MediaDrm.KeyRequest#REQUEST_TYPE_INITIAL}, {@link android.media.MediaDrm.KeyRequest#REQUEST_TYPE_RENEWAL}, {@link android.media.MediaDrm.KeyRequest#REQUEST_TYPE_RELEASE}, {@link android.media.MediaDrm.KeyRequest#REQUEST_TYPE_NONE}, or {@link android.media.MediaDrm.KeyRequest#REQUEST_TYPE_UPDATE}
 */

public int getRequestType() { throw new RuntimeException("Stub!"); }

/**
 * Key request type is initial license request. A license request
 * is necessary to load keys.
 */

public static final int REQUEST_TYPE_INITIAL = 0; // 0x0

/**
 * Keys are already loaded and are available for use. No license request is necessary, and
 * no key request data is returned.
 */

public static final int REQUEST_TYPE_NONE = 3; // 0x3

/**
 * Key request type is license release
 */

public static final int REQUEST_TYPE_RELEASE = 2; // 0x2

/**
 * Key request type is license renewal. A license request is
 * necessary to prevent the keys from expiring.
 */

public static final int REQUEST_TYPE_RENEWAL = 1; // 0x1

/**
 * Keys have been loaded but an additional license request is needed
 * to update their values.
 */

public static final int REQUEST_TYPE_UPDATE = 4; // 0x4
}

/**
 * Defines the status of a key.
 * A KeyStatus for each key in a session is provided to the
 * {@link OnKeyStatusChangeListener#onKeyStatusChange}
 * listener.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class KeyStatus {

KeyStatus(byte[] keyId, int statusCode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the status code for the key
 * @return one of {@link #STATUS_USABLE}, {@link #STATUS_EXPIRED},
 * {@link #STATUS_OUTPUT_NOT_ALLOWED}, {@link #STATUS_PENDING}
 * or {@link #STATUS_INTERNAL_ERROR}.

 * Value is {@link android.media.MediaDrm.KeyStatus#STATUS_USABLE}, {@link android.media.MediaDrm.KeyStatus#STATUS_EXPIRED}, {@link android.media.MediaDrm.KeyStatus#STATUS_OUTPUT_NOT_ALLOWED}, {@link android.media.MediaDrm.KeyStatus#STATUS_PENDING}, or {@link android.media.MediaDrm.KeyStatus#STATUS_INTERNAL_ERROR}
 */

public int getStatusCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the id for the key

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public byte[] getKeyId() { throw new RuntimeException("Stub!"); }

/**
 * The key is no longer usable to decrypt media data because its
 * expiration time has passed.
 */

public static final int STATUS_EXPIRED = 1; // 0x1

/**
 * The key is not currently usable to decrypt media data because of an
 * internal error in processing unrelated to input parameters.  This error
 * is not actionable by an app.
 */

public static final int STATUS_INTERNAL_ERROR = 4; // 0x4

/**
 * The key is not currently usable to decrypt media data because its
 * output requirements cannot currently be met.
 */

public static final int STATUS_OUTPUT_NOT_ALLOWED = 2; // 0x2

/**
 * The status of the key is not yet known and is being determined.
 * The status will be updated with the actual status when it has
 * been determined.
 */

public static final int STATUS_PENDING = 3; // 0x3

/**
 * The key is currently usable to decrypt media data
 */

public static final int STATUS_USABLE = 0; // 0x0
}

/**
 * Thrown when an unrecoverable failure occurs during a MediaDrm operation.
 * Extends java.lang.IllegalStateException with the addition of an error
 * code that may be useful in diagnosing the failure.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MediaDrmStateException extends java.lang.IllegalStateException {

/**
 * @hide
 */

MediaDrmStateException(int errorCode, java.lang.String detailMessage) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve a developer-readable diagnostic information string
 * associated with the exception. Do not show this to end-users,
 * since this string will not be localized or generally comprehensible
 * to end-users.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getDiagnosticInfo() { throw new RuntimeException("Stub!"); }
}

/**
 * Definitions for the metrics that are reported via the
 * {@link #getMetrics} call.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class MetricsConstants {

MetricsConstants() { throw new RuntimeException("Stub!"); }

/**
 * Key to extract the number of failed {@link #closeSession} calls
 * from the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String CLOSE_SESSION_ERROR_COUNT = "drm.mediadrm.close_session.error.count";

/**
 * Key to extract the list of error codes that were returned from
 * {@link #closeSession} calls. The key is used to lookup the list
 * in the {@link PersistableBundle} returned by a {@link #getMetrics}
 * call.
 * The list is an array of Long values
 * ({@link android.os.BaseBundle#getLongArray}).
 */

public static final java.lang.String CLOSE_SESSION_ERROR_LIST = "drm.mediadrm.close_session.error.list";

/**
 * Key to extract the number of successful {@link #closeSession} calls
 * from the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String CLOSE_SESSION_OK_COUNT = "drm.mediadrm.close_session.ok.count";

/**
 * Key to extract the count of {@link OnEventListener#onEvent}
 * calls of type KEY_EXPIRED occured. The count is
 * extracted from the {@link PersistableBundle} returned from a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String EVENT_KEY_EXPIRED_COUNT = "drm.mediadrm.event.KEY_EXPIRED.count";

/**
 * Key to extract the count of {@link OnEventListener#onEvent}
 * calls of type KEY_NEEDED occured. The count is
 * extracted from the {@link PersistableBundle} returned from a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String EVENT_KEY_NEEDED_COUNT = "drm.mediadrm.event.KEY_NEEDED.count";

/**
 * Key to extract the count of {@link OnEventListener#onEvent}
 * calls of type PROVISION_REQUIRED occured. The count is
 * extracted from the {@link PersistableBundle} returned from a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String EVENT_PROVISION_REQUIRED_COUNT = "drm.mediadrm.event.PROVISION_REQUIRED.count";

/**
 * Key to extract the count of {@link OnEventListener#onEvent}
 * calls of type SESSION_RECLAIMED. The count is
 * extracted from the {@link PersistableBundle} returned from a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String EVENT_SESSION_RECLAIMED_COUNT = "drm.mediadrm.event.SESSION_RECLAIMED.count";

/**
 * Key to extract the count of {@link OnEventListener#onEvent}
 * calls of type VENDOR_DEFINED. The count is
 * extracted from the {@link PersistableBundle} returned from a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String EVENT_VENDOR_DEFINED_COUNT = "drm.mediadrm.event.VENDOR_DEFINED.count";

/**
 * Key to extract the number of failed
 * {@link #getPropertyByteArray} calls were made with the
 * {@link #PROPERTY_DEVICE_UNIQUE_ID} value. The key is used to lookup
 * the value in the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String GET_DEVICE_UNIQUE_ID_ERROR_COUNT = "drm.mediadrm.get_device_unique_id.error.count";

/**
 * Key to extract the list of error codes that were returned from
 * {@link #getPropertyByteArray} calls with the
 * {@link #PROPERTY_DEVICE_UNIQUE_ID} value. The key is used to lookup
 * the list in the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The list is an array of Long values
 * ({@link android.os.BaseBundle#getLongArray}).
 */

public static final java.lang.String GET_DEVICE_UNIQUE_ID_ERROR_LIST = "drm.mediadrm.get_device_unique_id.error.list";

/**
 * Key to extract the number of successful
 * {@link #getPropertyByteArray} calls were made with the
 * {@link #PROPERTY_DEVICE_UNIQUE_ID} value. The key is used to lookup
 * the value in the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String GET_DEVICE_UNIQUE_ID_OK_COUNT = "drm.mediadrm.get_device_unique_id.ok.count";

/**
 * Key to extract the number of failed {@link #getKeyRequest}
 * calls from the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String GET_KEY_REQUEST_ERROR_COUNT = "drm.mediadrm.get_key_request.error.count";

/**
 * Key to extract the list of error codes that were returned from
 * {@link #getKeyRequest} calls. The key is used to lookup the list
 * in the {@link PersistableBundle} returned by a {@link #getMetrics}
 * call.
 * The list is an array of Long values
 * ({@link android.os.BaseBundle#getLongArray}).
 */

public static final java.lang.String GET_KEY_REQUEST_ERROR_LIST = "drm.mediadrm.get_key_request.error.list";

/**
 * Key to extract the number of successful {@link #getKeyRequest} calls
 * from the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String GET_KEY_REQUEST_OK_COUNT = "drm.mediadrm.get_key_request.ok.count";

/**
 * Key to extract the average time in microseconds of calls to
 * {@link #getKeyRequest}. The value is retrieved from the
 * {@link PersistableBundle} returned from {@link #getMetrics}.
 * The time is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String GET_KEY_REQUEST_OK_TIME_MICROS = "drm.mediadrm.get_key_request.ok.average_time_micros";

/**
 * Key to extract the number of failed {@link #getProvisionRequest}
 * calls from the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String GET_PROVISION_REQUEST_ERROR_COUNT = "drm.mediadrm.get_provision_request.error.count";

/**
 * Key to extract the list of error codes that were returned from
 * {@link #getProvisionRequest} calls. The key is used to lookup the
 * list in the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The list is an array of Long values
 * ({@link android.os.BaseBundle#getLongArray}).
 */

public static final java.lang.String GET_PROVISION_REQUEST_ERROR_LIST = "drm.mediadrm.get_provision_request.error.list";

/**
 * Key to extract the number of successful {@link #getProvisionRequest}
 * calls from the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String GET_PROVISION_REQUEST_OK_COUNT = "drm.mediadrm.get_provision_request.ok.count";

/**
 * Key to extraact the count of {@link KeyStatus#STATUS_EXPIRED} events
 * that occured. The count is extracted from the
 * {@link PersistableBundle} returned from a {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String KEY_STATUS_EXPIRED_COUNT = "drm.mediadrm.key_status.EXPIRED.count";

/**
 * Key to extract the count of {@link KeyStatus#STATUS_INTERNAL_ERROR}
 * events that occured. The count is extracted from the
 * {@link PersistableBundle} returned from a {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String KEY_STATUS_INTERNAL_ERROR_COUNT = "drm.mediadrm.key_status.INTERNAL_ERROR.count";

/**
 * Key to extract the count of
 * {@link KeyStatus#STATUS_OUTPUT_NOT_ALLOWED} events that occured.
 * The count is extracted from the
 * {@link PersistableBundle} returned from a {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String KEY_STATUS_OUTPUT_NOT_ALLOWED_COUNT = "drm.mediadrm.key_status_change.OUTPUT_NOT_ALLOWED.count";

/**
 * Key to extract the count of {@link KeyStatus#STATUS_PENDING}
 * events that occured. The count is extracted from the
 * {@link PersistableBundle} returned from a {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String KEY_STATUS_PENDING_COUNT = "drm.mediadrm.key_status_change.PENDING.count";

/**
 * Key to extract the count of {@link KeyStatus#STATUS_USABLE}
 * events that occured. The count is extracted from the
 * {@link PersistableBundle} returned from a {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String KEY_STATUS_USABLE_COUNT = "drm.mediadrm.key_status_change.USABLE.count";

/**
 * Key to extract the number of failed {@link #openSession} calls
 * from the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String OPEN_SESSION_ERROR_COUNT = "drm.mediadrm.open_session.error.count";

/**
 * Key to extract the list of error codes that were returned from
 * {@link #openSession} calls. The key is used to lookup the list
 * in the {@link PersistableBundle} returned by a {@link #getMetrics}
 * call.
 * The list is an array of Long values
 * ({@link android.os.BaseBundle#getLongArray}).
 */

public static final java.lang.String OPEN_SESSION_ERROR_LIST = "drm.mediadrm.open_session.error.list";

/**
 * Key to extract the number of successful {@link #openSession} calls
 * from the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String OPEN_SESSION_OK_COUNT = "drm.mediadrm.open_session.ok.count";

/**
 * Key to extract the number of failed {@link #provideKeyResponse}
 * calls from the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String PROVIDE_KEY_RESPONSE_ERROR_COUNT = "drm.mediadrm.provide_key_response.error.count";

/**
 * Key to extract the list of error codes that were returned from
 * {@link #provideKeyResponse} calls. The key is used to lookup the
 * list in the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The list is an array of Long values
 * ({@link android.os.BaseBundle#getLongArray}).
 */

public static final java.lang.String PROVIDE_KEY_RESPONSE_ERROR_LIST = "drm.mediadrm.provide_key_response.error.list";

/**
 * Key to extract the number of successful {@link #provideKeyResponse}
 * calls from the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String PROVIDE_KEY_RESPONSE_OK_COUNT = "drm.mediadrm.provide_key_response.ok.count";

/**
 * Key to extract the average time in microseconds of calls to
 * {@link #provideKeyResponse}. The valus is retrieved from the
 * {@link PersistableBundle} returned from {@link #getMetrics}.
 * The time is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String PROVIDE_KEY_RESPONSE_OK_TIME_MICROS = "drm.mediadrm.provide_key_response.ok.average_time_micros";

/**
 * Key to extract the number of failed
 * {@link #provideProvisionResponse} calls from the
 * {@link PersistableBundle} returned by a {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String PROVIDE_PROVISION_RESPONSE_ERROR_COUNT = "drm.mediadrm.provide_provision_response.error.count";

/**
 * Key to extract the list of error codes that were returned from
 * {@link #provideProvisionResponse} calls. The key is used to lookup
 * the list in the {@link PersistableBundle} returned by a
 * {@link #getMetrics} call.
 * The list is an array of Long values
 * ({@link android.os.BaseBundle#getLongArray}).
 */

public static final java.lang.String PROVIDE_PROVISION_RESPONSE_ERROR_LIST = "drm.mediadrm.provide_provision_response.error.list";

/**
 * Key to extract the number of successful
 * {@link #provideProvisionResponse} calls from the
 * {@link PersistableBundle} returned by a {@link #getMetrics} call.
 * The count is a Long value ({@link android.os.BaseBundle#getLong}).
 */

public static final java.lang.String PROVIDE_PROVISION_RESPONSE_OK_COUNT = "drm.mediadrm.provide_provision_response.ok.count";

/**
 * Key to extract the end times of sessions. Times are
 * represented as milliseconds since epoch (1970-01-01T00:00:00Z).
 * The end times are returned from the {@link PersistableBundle}
 * from a {@link #getMetrics} call.
 * The end times are returned as another {@link PersistableBundle}
 * containing the session ids as keys and the end times as long
 * values. Use {@link android.os.BaseBundle#keySet} to get the list of
 * session ids, and then {@link android.os.BaseBundle#getLong} to get
 * the end time for each session.
 */

public static final java.lang.String SESSION_END_TIMES_MS = "drm.mediadrm.session_end_times_ms";

/**
 * Key to extract the start times of sessions. Times are
 * represented as milliseconds since epoch (1970-01-01T00:00:00Z).
 * The start times are returned from the {@link PersistableBundle}
 * from a {@link #getMetrics} call.
 * The start times are returned as another {@link PersistableBundle}
 * containing the session ids as keys and the start times as long
 * values. Use {@link android.os.BaseBundle#keySet} to get the list of
 * session ids, and then {@link android.os.BaseBundle#getLong} to get
 * the start time for each session.
 */

public static final java.lang.String SESSION_START_TIMES_MS = "drm.mediadrm.session_start_times_ms";
}

/**
 * Interface definition for a callback to be invoked when a drm event
 * occurs
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnEventListener {

/**
 * Called when an event occurs that requires the app to be notified
 *
 * @param md the MediaDrm object on which the event occurred
 * This value must never be {@code null}.
 * @param sessionId the DRM session ID on which the event occurred,
 *        or {@code null} if there is no session ID associated with the event.
 * This value may be {@code null}.
 * @param event indicates the event type
 * Value is {@link android.media.MediaDrm#EVENT_PROVISION_REQUIRED}, {@link android.media.MediaDrm#EVENT_KEY_REQUIRED}, {@link android.media.MediaDrm#EVENT_KEY_EXPIRED}, {@link android.media.MediaDrm#EVENT_VENDOR_DEFINED}, or {@link android.media.MediaDrm#EVENT_SESSION_RECLAIMED}
 * @param extra an secondary error code
 * @param data optional byte array of data that may be associated with the event

 * This value may be {@code null}.
 */

public void onEvent(@androidx.annotation.RecentlyNonNull android.media.MediaDrm md, @androidx.annotation.RecentlyNullable byte[] sessionId, int event, int extra, @androidx.annotation.RecentlyNullable byte[] data);
}

/**
 * Interface definition for a callback to be invoked when a drm session
 * expiration update occurs
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnExpirationUpdateListener {

/**
 * Called when a session expiration update occurs, to inform the app
 * about the change in expiration time
 *
 * @param md the MediaDrm object on which the event occurred
 * This value must never be {@code null}.
 * @param sessionId the DRM session ID on which the event occurred
 * This value must never be {@code null}.
 * @param expirationTime the new expiration time for the keys in the session.
 *     The time is in milliseconds, relative to the Unix epoch.  A time of
 *     0 indicates that the keys never expire.
 */

public void onExpirationUpdate(@androidx.annotation.RecentlyNonNull android.media.MediaDrm md, @androidx.annotation.RecentlyNonNull byte[] sessionId, long expirationTime);
}

/**
 * Interface definition for a callback to be invoked when the keys in a drm
 * session change states.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnKeyStatusChangeListener {

/**
 * Called when the keys in a session change status, such as when the license
 * is renewed or expires.
 *
 * @param md the MediaDrm object on which the event occurred
 * This value must never be {@code null}.
 * @param sessionId the DRM session ID on which the event occurred
 * This value must never be {@code null}.
 * @param keyInformation a list of {@link MediaDrm.KeyStatus}
 *     instances indicating the status for each key in the session
 * This value must never be {@code null}.
 * @param hasNewUsableKey indicates if a key has been added that is usable,
 *     which may trigger an attempt to resume playback on the media stream
 *     if it is currently blocked waiting for a key.
 */

public void onKeyStatusChange(@androidx.annotation.RecentlyNonNull android.media.MediaDrm md, @androidx.annotation.RecentlyNonNull byte[] sessionId, @androidx.annotation.RecentlyNonNull java.util.List<android.media.MediaDrm.KeyStatus> keyInformation, boolean hasNewUsableKey);
}

/**
 * Contains the opaque data an app uses to request a certificate from a provisioning
 * server
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class ProvisionRequest {

ProvisionRequest() { throw new RuntimeException("Stub!"); }

/**
 * Get the opaque message data

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public byte[] getData() { throw new RuntimeException("Stub!"); }

/**
 * Get the default URL to use when sending the provision request
 * message to a server, if known. The app may prefer to use a different
 * provisioning server URL obtained from other sources.
 * This method returns an empty string if the default URL is not known.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getDefaultUrl() { throw new RuntimeException("Stub!"); }
}

/**
 * Security level indicates the robustness of the device's DRM
 * implementation.

 * Value is {@link android.media.MediaDrm#SECURITY_LEVEL_UNKNOWN}, {@link android.media.MediaDrm#SECURITY_LEVEL_SW_SECURE_CRYPTO}, {@link android.media.MediaDrm#SECURITY_LEVEL_SW_SECURE_DECODE}, {@link android.media.MediaDrm#SECURITY_LEVEL_HW_SECURE_CRYPTO}, {@link android.media.MediaDrm#SECURITY_LEVEL_HW_SECURE_DECODE}, or {@link android.media.MediaDrm#SECURITY_LEVEL_HW_SECURE_ALL}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE) public static @interface SecurityLevel {
}

}

