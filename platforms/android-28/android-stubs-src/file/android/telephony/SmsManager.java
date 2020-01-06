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


package android.telephony;

import android.content.Intent;
import android.app.PendingIntent;
import java.util.ArrayList;
import java.util.List;
import android.net.Uri;
import android.os.Bundle;

/**
 * Manages SMS operations such as sending data, text, and pdu SMS messages.
 * Get this object by calling the static method {@link #getDefault()}.
 *
 * <p>For information about how to behave as the default SMS app on Android 4.4 (API level 19)
 * and higher, see {@link android.provider.Telephony}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SmsManager {

SmsManager(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Send a text based SMS.
 *
 * <p class="note"><strong>Note:</strong> Using this method requires that your app has the
 * {@link android.Manifest.permission#SEND_SMS} permission.</p>
 *
 * <p class="note"><strong>Note:</strong> Beginning with Android 4.4 (API level 19), if
 * <em>and only if</em> an app is not selected as the default SMS app, the system automatically
 * writes messages sent using this method to the SMS Provider (the default SMS app is always
 * responsible for writing its sent messages to the SMS Provider). For information about
 * how to behave as the default SMS app, see {@link android.provider.Telephony}.</p>
 *
 *
 * @param destinationAddress the address to send the message to
 * @param scAddress is the service center address or null to use
 *  the current default SMSC
 * @param text the body of the message to send
 * @param sentIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is successfully sent, or failed.
 *  The result code will be <code>Activity.RESULT_OK</code> for success,
 *  or one of these errors:<br>
 *  <code>RESULT_ERROR_GENERIC_FAILURE</code><br>
 *  <code>RESULT_ERROR_RADIO_OFF</code><br>
 *  <code>RESULT_ERROR_NULL_PDU</code><br>
 *  For <code>RESULT_ERROR_GENERIC_FAILURE</code> the sentIntent may include
 *  the extra "errorCode" containing a radio technology specific value,
 *  generally only useful for troubleshooting.<br>
 *  The per-application based SMS control checks sentIntent. If sentIntent
 *  is NULL the caller will be checked against all unknown applications,
 *  which cause smaller number of SMS to be sent in checking period.
 * @param deliveryIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is delivered to the recipient.  The
 *  raw pdu of the status report is in the extended data ("pdu").
 *
 * @throws IllegalArgumentException if destinationAddress or text are empty
 */

public void sendTextMessage(java.lang.String destinationAddress, java.lang.String scAddress, java.lang.String text, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) { throw new RuntimeException("Stub!"); }

/**
 * Send a text based SMS without writing it into the SMS Provider.
 *
 * <p>
 * The message will be sent directly over the network and will not be visible in SMS
 * applications. Intended for internal carrier use only.
 * </p>
 *
 * <p>Requires Permission: Both {@link android.Manifest.permission#SEND_SMS} and
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE}, or that the calling app has carrier
 * privileges (see {@link TelephonyManager#hasCarrierPrivileges}), or that the calling app is
 * the default IMS app (see
 * {@link CarrierConfigManager#KEY_CONFIG_IMS_PACKAGE_OVERRIDE_STRING}).
 *
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE} and {@link android.Manifest.permission#SEND_SMS}
 * @see #sendTextMessage(String, String, String, PendingIntent, PendingIntent)
 */

public void sendTextMessageWithoutPersisting(java.lang.String destinationAddress, java.lang.String scAddress, java.lang.String text, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) { throw new RuntimeException("Stub!"); }

/**
 *
 * Inject an SMS PDU into the android application framework.
 *
 * <p>Requires permission: {@link android.Manifest.permission#MODIFY_PHONE_STATE} or carrier
 * privileges per {@link android.telephony.TelephonyManager#hasCarrierPrivileges}.
 *
 * @param pdu is the byte array of pdu to be injected into android application framework
 * @param format is the format of SMS pdu ({@link SmsMessage#FORMAT_3GPP} or
 *  {@link SmsMessage#FORMAT_3GPP2})
 * Value is {@link android.telephony.SmsMessage#FORMAT_3GPP}, or {@link android.telephony.SmsMessage#FORMAT_3GPP2}
 * @param receivedIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is successfully received by the
 *  android application framework, or failed. This intent is broadcasted at
 *  the same time an SMS received from radio is acknowledged back.
 *  The result code will be {@link android.provider.Telephony.Sms.Intents#RESULT_SMS_HANDLED}
 *  for success, or {@link android.provider.Telephony.Sms.Intents#RESULT_SMS_GENERIC_ERROR} for
 *  error.
 *
 * @throws IllegalArgumentException if the format is invalid.
 */

public void injectSmsPdu(byte[] pdu, java.lang.String format, android.app.PendingIntent receivedIntent) { throw new RuntimeException("Stub!"); }

/**
 * Divide a message text into several fragments, none bigger than
 * the maximum SMS message size.
 *
 * @param text the original message.  Must not be null.
 * @return an <code>ArrayList</code> of strings that, in order,
 *   comprise the original message
 *
 * @throws IllegalArgumentException if text is null
 */

public java.util.ArrayList<java.lang.String> divideMessage(java.lang.String text) { throw new RuntimeException("Stub!"); }

/**
 * Send a multi-part text based SMS.  The callee should have already
 * divided the message into correctly sized parts by calling
 * <code>divideMessage</code>.
 *
 * <p class="note"><strong>Note:</strong> Using this method requires that your app has the
 * {@link android.Manifest.permission#SEND_SMS} permission.</p>
 *
 * <p class="note"><strong>Note:</strong> Beginning with Android 4.4 (API level 19), if
 * <em>and only if</em> an app is not selected as the default SMS app, the system automatically
 * writes messages sent using this method to the SMS Provider (the default SMS app is always
 * responsible for writing its sent messages to the SMS Provider). For information about
 * how to behave as the default SMS app, see {@link android.provider.Telephony}.</p>
 *
 * @param destinationAddress the address to send the message to
 * @param scAddress is the service center address or null to use
 *   the current default SMSC
 * @param parts an <code>ArrayList</code> of strings that, in order,
 *   comprise the original message
 * @param sentIntents if not null, an <code>ArrayList</code> of
 *   <code>PendingIntent</code>s (one for each message part) that is
 *   broadcast when the corresponding message part has been sent.
 *   The result code will be <code>Activity.RESULT_OK</code> for success,
 *   or one of these errors:<br>
 *   <code>RESULT_ERROR_GENERIC_FAILURE</code><br>
 *   <code>RESULT_ERROR_RADIO_OFF</code><br>
 *   <code>RESULT_ERROR_NULL_PDU</code><br>
 *   For <code>RESULT_ERROR_GENERIC_FAILURE</code> each sentIntent may include
 *   the extra "errorCode" containing a radio technology specific value,
 *   generally only useful for troubleshooting.<br>
 *   The per-application based SMS control checks sentIntent. If sentIntent
 *   is NULL the caller will be checked against all unknown applications,
 *   which cause smaller number of SMS to be sent in checking period.
 * @param deliveryIntents if not null, an <code>ArrayList</code> of
 *   <code>PendingIntent</code>s (one for each message part) that is
 *   broadcast when the corresponding message part has been delivered
 *   to the recipient.  The raw pdu of the status report is in the
 *   extended data ("pdu").
 *
 * @throws IllegalArgumentException if destinationAddress or data are empty
 */

public void sendMultipartTextMessage(java.lang.String destinationAddress, java.lang.String scAddress, java.util.ArrayList<java.lang.String> parts, java.util.ArrayList<android.app.PendingIntent> sentIntents, java.util.ArrayList<android.app.PendingIntent> deliveryIntents) { throw new RuntimeException("Stub!"); }

/**
 * Send a data based SMS to a specific application port.
 *
 * <p class="note"><strong>Note:</strong> Using this method requires that your app has the
 * {@link android.Manifest.permission#SEND_SMS} permission.</p>
 *
 * @param destinationAddress the address to send the message to
 * @param scAddress is the service center address or null to use
 *  the current default SMSC
 * @param destinationPort the port to deliver the message to
 * @param data the body of the message to send
 * @param sentIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is successfully sent, or failed.
 *  The result code will be <code>Activity.RESULT_OK</code> for success,
 *  or one of these errors:<br>
 *  <code>RESULT_ERROR_GENERIC_FAILURE</code><br>
 *  <code>RESULT_ERROR_RADIO_OFF</code><br>
 *  <code>RESULT_ERROR_NULL_PDU</code><br>
 *  For <code>RESULT_ERROR_GENERIC_FAILURE</code> the sentIntent may include
 *  the extra "errorCode" containing a radio technology specific value,
 *  generally only useful for troubleshooting.<br>
 *  The per-application based SMS control checks sentIntent. If sentIntent
 *  is NULL the caller will be checked against all unknown applications,
 *  which cause smaller number of SMS to be sent in checking period.
 * @param deliveryIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is delivered to the recipient.  The
 *  raw pdu of the status report is in the extended data ("pdu").
 *
 * @throws IllegalArgumentException if destinationAddress or data are empty
 */

public void sendDataMessage(java.lang.String destinationAddress, java.lang.String scAddress, short destinationPort, byte[] data, android.app.PendingIntent sentIntent, android.app.PendingIntent deliveryIntent) { throw new RuntimeException("Stub!"); }

/**
 * Get the SmsManager associated with the default subscription id. The instance will always be
 * associated with the default subscription id, even if the default subscription id is changed.
 *
 * @return the SmsManager associated with the default subscription id
 */

public static android.telephony.SmsManager getDefault() { throw new RuntimeException("Stub!"); }

/**
 * Get the the instance of the SmsManager associated with a particular subscription id
 *
 * @param subId an SMS subscription id, typically accessed using
 *   {@link android.telephony.SubscriptionManager}
 * @return the instance of the SmsManager associated with subId
 */

public static android.telephony.SmsManager getSmsManagerForSubscriptionId(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Get the associated subscription id. If the instance was returned by {@link #getDefault()},
 * then this method may return different values at different points in time (if the user
 * changes the default subscription id). It will return < 0 if the default subscription id
 * cannot be determined.
 *
 * Additionally, to support legacy applications that are not multi-SIM aware,
 * if the following are true:
 *     - We are using a multi-SIM device
 *     - A default SMS SIM has not been selected
 *     - At least one SIM subscription is available
 * then ask the user to set the default SMS SIM.
 *
 * @return associated subscription id
 */

public int getSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Get default sms subscription id
 *
 * @return the default SMS subscription id
 */

public static int getDefaultSmsSubscriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Send an MMS message
 *
 * @param context application context
 * @param contentUri the content Uri from which the message pdu will be read
 * @param locationUrl the optional location url where message should be sent to
 * @param configOverrides the carrier-specific messaging configuration values to override for
 *  sending the message.
 * @param sentIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is successfully sent, or failed
 * @throws IllegalArgumentException if contentUri is empty
 */

public void sendMultimediaMessage(android.content.Context context, android.net.Uri contentUri, java.lang.String locationUrl, android.os.Bundle configOverrides, android.app.PendingIntent sentIntent) { throw new RuntimeException("Stub!"); }

/**
 * Download an MMS message from carrier by a given location URL
 *
 * @param context application context
 * @param locationUrl the location URL of the MMS message to be downloaded, usually obtained
 *  from the MMS WAP push notification
 * @param contentUri the content uri to which the downloaded pdu will be written
 * @param configOverrides the carrier-specific messaging configuration values to override for
 *  downloading the message.
 * @param downloadedIntent if not NULL this <code>PendingIntent</code> is
 *  broadcast when the message is downloaded, or the download is failed
 * @throws IllegalArgumentException if locationUrl or contentUri is empty
 */

public void downloadMultimediaMessage(android.content.Context context, java.lang.String locationUrl, android.net.Uri contentUri, android.os.Bundle configOverrides, android.app.PendingIntent downloadedIntent) { throw new RuntimeException("Stub!"); }

/**
 * Get carrier-dependent configuration values.
 *
 * @return bundle key/values pairs of configuration values
 */

public android.os.Bundle getCarrierConfigValues() { throw new RuntimeException("Stub!"); }

/**
 * Create a single use app specific incoming SMS request for the the calling package.
 *
 * This method returns a token that if included in a subsequent incoming SMS message will cause
 * {@code intent} to be sent with the SMS data.
 *
 * The token is only good for one use, after an SMS has been received containing the token all
 * subsequent SMS messages with the token will be routed as normal.
 *
 * An app can only have one request at a time, if the app already has a request pending it will
 * be replaced with a new request.
 *
 * @return Token to include in an SMS message. The token will be 11 characters long.
 * @see android.provider.Telephony.Sms.Intents#getMessagesFromIntent
 */

public java.lang.String createAppSpecificSmsToken(android.app.PendingIntent intent) { throw new RuntimeException("Stub!"); }

/** Intent extra name for MMS sending result data in byte array type */

public static final java.lang.String EXTRA_MMS_DATA = "android.telephony.extra.MMS_DATA";

/** Intent extra name for HTTP status code for MMS HTTP failure in integer type */

public static final java.lang.String EXTRA_MMS_HTTP_STATUS = "android.telephony.extra.MMS_HTTP_STATUS";

/**
 * Whether alias is enabled (boolean type)
 */

public static final java.lang.String MMS_CONFIG_ALIAS_ENABLED = "aliasEnabled";

/**
 * Max alias character count (int type)
 */

public static final java.lang.String MMS_CONFIG_ALIAS_MAX_CHARS = "aliasMaxChars";

/**
 * Min alias character count (int type)
 */

public static final java.lang.String MMS_CONFIG_ALIAS_MIN_CHARS = "aliasMinChars";

/**
 * Whether audio is allowed to be attached for MMS messages (boolean type)
 */

public static final java.lang.String MMS_CONFIG_ALLOW_ATTACH_AUDIO = "allowAttachAudio";

/**
 * Whether to append transaction id to MMS WAP Push M-Notification.ind's content location URI
 * when constructing the download URL of a new MMS (boolean type)
 */

public static final java.lang.String MMS_CONFIG_APPEND_TRANSACTION_ID = "enabledTransID";

/**
 * Email gateway number (String type)
 */

public static final java.lang.String MMS_CONFIG_EMAIL_GATEWAY_NUMBER = "emailGatewayNumber";

/**
 * Whether group MMS is enabled for the current carrier (boolean type)
 */

public static final java.lang.String MMS_CONFIG_GROUP_MMS_ENABLED = "enableGroupMms";

/**
 * A list of HTTP headers to add to MMS HTTP request, separated by "|" (String type)
 */

public static final java.lang.String MMS_CONFIG_HTTP_PARAMS = "httpParams";

/**
 * MMS HTTP socket timeout in milliseconds (int type)
 */

public static final java.lang.String MMS_CONFIG_HTTP_SOCKET_TIMEOUT = "httpSocketTimeout";

/**
 * Max MMS image height (int type)
 */

public static final java.lang.String MMS_CONFIG_MAX_IMAGE_HEIGHT = "maxImageHeight";

/**
 * Max MMS image width (int type)
 */

public static final java.lang.String MMS_CONFIG_MAX_IMAGE_WIDTH = "maxImageWidth";

/**
 * Max MMS message size in bytes (int type)
 */

public static final java.lang.String MMS_CONFIG_MAX_MESSAGE_SIZE = "maxMessageSize";

/**
 * Max message text size (int type)
 */

public static final java.lang.String MMS_CONFIG_MESSAGE_TEXT_MAX_SIZE = "maxMessageTextSize";

/**
 * Whether MMS delivery report is enabled (boolean type)
 */

public static final java.lang.String MMS_CONFIG_MMS_DELIVERY_REPORT_ENABLED = "enableMMSDeliveryReports";

/**
 * Whether MMS is enabled for the current carrier (boolean type)
 */

public static final java.lang.String MMS_CONFIG_MMS_ENABLED = "enabledMMS";

/**
 * Whether MMS read report is enabled (boolean type)
 */

public static final java.lang.String MMS_CONFIG_MMS_READ_REPORT_ENABLED = "enableMMSReadReports";

/**
 * Whether multipart SMS is enabled (boolean type)
 */

public static final java.lang.String MMS_CONFIG_MULTIPART_SMS_ENABLED = "enableMultipartSMS";

/**
 * The suffix to append to the NAI header value for MMS HTTP request (String type)
 */

public static final java.lang.String MMS_CONFIG_NAI_SUFFIX = "naiSuffix";

/**
 * If this is enabled, M-NotifyResp.ind should be sent to the WAP Push content location instead
 * of the default MMSC (boolean type)
 */

public static final java.lang.String MMS_CONFIG_NOTIFY_WAP_MMSC_ENABLED = "enabledNotifyWapMMSC";

/**
 * Limit of recipients of MMS messages (int type)
 */

public static final java.lang.String MMS_CONFIG_RECIPIENT_LIMIT = "recipientLimit";

/**
 * Whether multipart SMS should be sent as separate messages
 */

public static final java.lang.String MMS_CONFIG_SEND_MULTIPART_SMS_AS_SEPARATE_MESSAGES = "sendMultipartSmsAsSeparateMessages";

/**
 * If true, show the cell broadcast (amber alert) in the SMS settings. Some carriers don't want
 * this shown. (Boolean type)
 */

public static final java.lang.String MMS_CONFIG_SHOW_CELL_BROADCAST_APP_LINKS = "config_cellBroadcastAppLinks";

/**
 * Whether SMS delivery report is enabled (boolean type)
 */

public static final java.lang.String MMS_CONFIG_SMS_DELIVERY_REPORT_ENABLED = "enableSMSDeliveryReports";

/**
 * Some carriers require SMS to be converted into MMS when text length reaches this threshold
 * (int type)
 */

public static final java.lang.String MMS_CONFIG_SMS_TO_MMS_TEXT_LENGTH_THRESHOLD = "smsToMmsTextLengthThreshold";

/**
 * When the number of parts of a multipart SMS reaches this threshold, it should be converted
 * into an MMS (int type)
 */

public static final java.lang.String MMS_CONFIG_SMS_TO_MMS_TEXT_THRESHOLD = "smsToMmsTextThreshold";

/**
 * Max message subject length (int type)
 */

public static final java.lang.String MMS_CONFIG_SUBJECT_MAX_LENGTH = "maxSubjectLength";

/**
 * Whether the carrier MMSC supports charset field in Content-Type header. If this is false,
 * then we don't add "charset" to "Content-Type"
 */

public static final java.lang.String MMS_CONFIG_SUPPORT_HTTP_CHARSET_HEADER = "supportHttpCharsetHeader";

/**
 * Whether content-disposition field should be expected in an MMS PDU (boolean type)
 */

public static final java.lang.String MMS_CONFIG_SUPPORT_MMS_CONTENT_DISPOSITION = "supportMmsContentDisposition";

/**
 * The name of the UA Prof URL HTTP header for MMS HTTP request (String type)
 */

public static final java.lang.String MMS_CONFIG_UA_PROF_TAG_NAME = "uaProfTagName";

/**
 * The UA Profile URL header value for MMS HTTP request (String type)
 */

public static final java.lang.String MMS_CONFIG_UA_PROF_URL = "uaProfUrl";

/**
 * The User-Agent header value for MMS HTTP request (String type)
 */

public static final java.lang.String MMS_CONFIG_USER_AGENT = "userAgent";

public static final int MMS_ERROR_CONFIGURATION_ERROR = 7; // 0x7

public static final int MMS_ERROR_HTTP_FAILURE = 4; // 0x4

public static final int MMS_ERROR_INVALID_APN = 2; // 0x2

public static final int MMS_ERROR_IO_ERROR = 5; // 0x5

public static final int MMS_ERROR_NO_DATA_NETWORK = 8; // 0x8

public static final int MMS_ERROR_RETRY = 6; // 0x6

public static final int MMS_ERROR_UNABLE_CONNECT_MMS = 3; // 0x3

public static final int MMS_ERROR_UNSPECIFIED = 1; // 0x1

/** Generic failure cause */

public static final int RESULT_ERROR_GENERIC_FAILURE = 1; // 0x1

/** Failed because we reached the sending queue limit. */

public static final int RESULT_ERROR_LIMIT_EXCEEDED = 5; // 0x5

/** Failed because service is currently unavailable */

public static final int RESULT_ERROR_NO_SERVICE = 4; // 0x4

/** Failed because no pdu provided */

public static final int RESULT_ERROR_NULL_PDU = 3; // 0x3

/** Failed because radio was explicitly turned off */

public static final int RESULT_ERROR_RADIO_OFF = 2; // 0x2

/** Failed because the user has denied this app ever send premium short codes. */

public static final int RESULT_ERROR_SHORT_CODE_NEVER_ALLOWED = 8; // 0x8

/** Failed because user denied the sending of this short code. */

public static final int RESULT_ERROR_SHORT_CODE_NOT_ALLOWED = 7; // 0x7

/** Free space (TS 51.011 10.5.3 / 3GPP2 C.S0023 3.4.27). */

public static final int STATUS_ON_ICC_FREE = 0; // 0x0

/** Received and read (TS 51.011 10.5.3 / 3GPP2 C.S0023 3.4.27). */

public static final int STATUS_ON_ICC_READ = 1; // 0x1

/** Stored and sent (TS 51.011 10.5.3 / 3GPP2 C.S0023 3.4.27). */

public static final int STATUS_ON_ICC_SENT = 5; // 0x5

/** Received and unread (TS 51.011 10.5.3 / 3GPP2 C.S0023 3.4.27). */

public static final int STATUS_ON_ICC_UNREAD = 3; // 0x3

/** Stored and unsent (TS 51.011 10.5.3 / 3GPP2 C.S0023 3.4.27). */

public static final int STATUS_ON_ICC_UNSENT = 7; // 0x7
}

