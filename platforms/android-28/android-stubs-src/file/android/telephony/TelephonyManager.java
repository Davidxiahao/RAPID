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

import java.util.List;
import android.telecom.PhoneAccountHandle;
import android.telecom.PhoneAccount;
import android.telecom.TelecomManager;
import android.telephony.VisualVoicemailService.VisualVoicemailTask;
import android.content.Intent;
import android.app.PendingIntent;
import android.util.Log;
import android.provider.Settings.SettingNotFoundException;
import android.os.AsyncTask;
import java.util.concurrent.Executor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.net.ConnectivityManager;
import android.os.RemoteException;
import android.service.carrier.CarrierIdentifier;
import android.os.ResultReceiver;
import android.content.Context;
import java.util.regex.Pattern;

/**
 * Provides access to information about the telephony services on
 * the device. Applications can use the methods in this class to
 * determine telephony services and states, as well as to access some
 * types of subscriber information. Applications can also register
 * a listener to receive notification of telephony state changes.
 * <p>
 * The returned TelephonyManager will use the default subscription for all calls.
 * To call an API for a specific subscription, use {@link #createForSubscriptionId(int)}. e.g.
 * <code>
 *   telephonyManager = defaultSubTelephonyManager.createForSubscriptionId(subId);
 * </code>
 * <p>
 * Note that access to some telephony information is
 * permission-protected. Your application cannot access the protected
 * information unless it has the appropriate permissions declared in
 * its manifest file. Where permissions apply, they are noted in the
 * the methods through which you access the protected information.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TelephonyManager {

/** @hide */

TelephonyManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of phones available.
 * Returns 0 if none of voice, sms, data is not supported
 * Returns 1 for Single standby mode (Single SIM functionality)
 * Returns 2 for Dual standby mode.(Dual SIM functionality)
 */

public int getPhoneCount() { throw new RuntimeException("Stub!"); }

/**
 * Create a new TelephonyManager object pinned to the given subscription ID.
 *
 * @return a TelephonyManager that uses the given subId for all calls.
 */

public android.telephony.TelephonyManager createForSubscriptionId(int subId) { throw new RuntimeException("Stub!"); }

/**
 * Create a new TelephonyManager object pinned to the subscription ID associated with the given
 * phone account.
 *
 * @return a TelephonyManager that uses the given phone account for all calls, or {@code null}
 * if the phone account does not correspond to a valid subscription ID.
 */

@androidx.annotation.RecentlyNullable public android.telephony.TelephonyManager createForPhoneAccountHandle(android.telecom.PhoneAccountHandle phoneAccountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Returns the software version number for the device, for example,
 * the IMEI/SV for GSM phones. Return null if the software version is
 * not available.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 */

public java.lang.String getDeviceSoftwareVersion() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unique device ID, for example, the IMEI for GSM and the MEID
 * or ESN for CDMA phones. Return null if device ID is not available.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @deprecated Use (@link getImei} which returns IMEI for GSM or (@link getMeid} which returns
 * MEID for CDMA.
 */

@Deprecated public java.lang.String getDeviceId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unique device ID of a subscription, for example, the IMEI for
 * GSM and the MEID for CDMA phones. Return null if device ID is not available.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param slotIndex of which deviceID is returned
 *
 * @deprecated Use (@link getImei} which returns IMEI for GSM or (@link getMeid} which returns
 * MEID for CDMA.
 */

@Deprecated public java.lang.String getDeviceId(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the IMEI (International Mobile Equipment Identity). Return null if IMEI is not
 * available.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 */

public java.lang.String getImei() { throw new RuntimeException("Stub!"); }

/**
 * Returns the IMEI (International Mobile Equipment Identity). Return null if IMEI is not
 * available.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param slotIndex of which IMEI is returned
 */

public java.lang.String getImei(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the MEID (Mobile Equipment Identifier). Return null if MEID is not available.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 */

public java.lang.String getMeid() { throw new RuntimeException("Stub!"); }

/**
 * Returns the MEID (Mobile Equipment Identifier). Return null if MEID is not available.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @param slotIndex of which MEID is returned
 */

public java.lang.String getMeid(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Network Access Identifier (NAI). Return null if NAI is not available.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 */

public java.lang.String getNai() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current location of the device.
 *<p>
 * If there is only one radio in the device and that radio has an LTE connection,
 * this method will return null. The implementation must not to try add LTE
 * identifiers into the existing cdma/gsm classes.
 *<p>
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION} or {@link android.Manifest.permission#ACCESS_FINE_LOCATION}
 * @return Current location of the device or null if not available.
 *
 * @deprecated use {@link #getAllCellInfo} instead, which returns a superset of this API.
 */

@Deprecated public android.telephony.CellLocation getCellLocation() { throw new RuntimeException("Stub!"); }

/**
 * Returns the neighboring cell information of the device.
 *
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION}
 * @return List of NeighboringCellInfo or null if info unavailable.
 *
 * @deprecated Use {@link #getAllCellInfo} which returns a superset of the information
 *             from NeighboringCellInfo.
 */

@Deprecated public java.util.List<android.telephony.NeighboringCellInfo> getNeighboringCellInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the device phone type.  This
 * indicates the type of radio used to transmit voice calls.
 *
 * @see #PHONE_TYPE_NONE
 * @see #PHONE_TYPE_GSM
 * @see #PHONE_TYPE_CDMA
 * @see #PHONE_TYPE_SIP
 */

public int getPhoneType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the alphabetic name of current registered operator.
 * <p>
 * Availability: Only when user is registered to a network. Result may be
 * unreliable on CDMA networks (use {@link #getPhoneType()} to determine if
 * on a CDMA network).
 */

public java.lang.String getNetworkOperatorName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the numeric name (MCC+MNC) of current registered operator.
 * <p>
 * Availability: Only when user is registered to a network. Result may be
 * unreliable on CDMA networks (use {@link #getPhoneType()} to determine if
 * on a CDMA network).
 */

public java.lang.String getNetworkOperator() { throw new RuntimeException("Stub!"); }

/**
 * Returns the network specifier of the subscription ID pinned to the TelephonyManager. The
 * network specifier is used by {@link
 * android.net.NetworkRequest.Builder#setNetworkSpecifier(String)} to create a {@link
 * android.net.NetworkRequest} that connects through the subscription.
 *
 * @see android.net.NetworkRequest.Builder#setNetworkSpecifier(String)
 * @see #createForSubscriptionId(int)
 * @see #createForPhoneAccountHandle(PhoneAccountHandle)
 */

public java.lang.String getNetworkSpecifier() { throw new RuntimeException("Stub!"); }

/**
 * Returns the carrier config of the subscription ID pinned to the TelephonyManager. If an
 * invalid subscription ID is pinned to the TelephonyManager, the returned config will contain
 * default values.
 *
 * <p>This method may take several seconds to complete, so it should only be called from a
 * worker thread.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * This method may take several seconds to complete, so it should
 *  *            only be called from a worker thread.
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @see CarrierConfigManager#getConfigForSubId(int)
 * @see #createForSubscriptionId(int)
 * @see #createForPhoneAccountHandle(PhoneAccountHandle)
 */

public android.os.PersistableBundle getCarrierConfig() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the device is considered roaming on the current
 * network, for GSM purposes.
 * <p>
 * Availability: Only when user registered to a network.
 */

public boolean isNetworkRoaming() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ISO country code equivalent of the MCC (Mobile Country Code) of the current
 * registered operator, or nearby cell information if not registered.
 * .
 * <p>
 * Note: Result may be unreliable on CDMA networks (use {@link #getPhoneType()} to determine
 * if on a CDMA network).
 */

public java.lang.String getNetworkCountryIso() { throw new RuntimeException("Stub!"); }

/**
 * @return the NETWORK_TYPE_xxxx for current data connection.
 */

public int getNetworkType() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the radio technology (network type)
 * currently in use on the device for data transmission.
 *
 * If this object has been created with {@link #createForSubscriptionId}, applies to the given
 * subId. Otherwise, applies to {@link SubscriptionManager#getDefaultDataSubscriptionId()}
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return the network type
 *
 * @see #NETWORK_TYPE_UNKNOWN
 * @see #NETWORK_TYPE_GPRS
 * @see #NETWORK_TYPE_EDGE
 * @see #NETWORK_TYPE_UMTS
 * @see #NETWORK_TYPE_HSDPA
 * @see #NETWORK_TYPE_HSUPA
 * @see #NETWORK_TYPE_HSPA
 * @see #NETWORK_TYPE_CDMA
 * @see #NETWORK_TYPE_EVDO_0
 * @see #NETWORK_TYPE_EVDO_A
 * @see #NETWORK_TYPE_EVDO_B
 * @see #NETWORK_TYPE_1xRTT
 * @see #NETWORK_TYPE_IDEN
 * @see #NETWORK_TYPE_LTE
 * @see #NETWORK_TYPE_EHRPD
 * @see #NETWORK_TYPE_HSPAP
 */

public int getDataNetworkType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the NETWORK_TYPE_xxxx for voice
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 */

public int getVoiceNetworkType() { throw new RuntimeException("Stub!"); }

/**
 * @return true if a ICC card is present
 */

public boolean hasIccCard() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the state of the default SIM card.
 *
 * @see #SIM_STATE_UNKNOWN
 * @see #SIM_STATE_ABSENT
 * @see #SIM_STATE_PIN_REQUIRED
 * @see #SIM_STATE_PUK_REQUIRED
 * @see #SIM_STATE_NETWORK_LOCKED
 * @see #SIM_STATE_READY
 * @see #SIM_STATE_NOT_READY
 * @see #SIM_STATE_PERM_DISABLED
 * @see #SIM_STATE_CARD_IO_ERROR
 * @see #SIM_STATE_CARD_RESTRICTED
 */

public int getSimState() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the state of the device SIM card in a slot.
 *
 * @param slotIndex
 *
 * @see #SIM_STATE_UNKNOWN
 * @see #SIM_STATE_ABSENT
 * @see #SIM_STATE_PIN_REQUIRED
 * @see #SIM_STATE_PUK_REQUIRED
 * @see #SIM_STATE_NETWORK_LOCKED
 * @see #SIM_STATE_READY
 * @see #SIM_STATE_NOT_READY
 * @see #SIM_STATE_PERM_DISABLED
 * @see #SIM_STATE_CARD_IO_ERROR
 * @see #SIM_STATE_CARD_RESTRICTED
 */

public int getSimState(int slotIndex) { throw new RuntimeException("Stub!"); }

/**
 * Returns the MCC+MNC (mobile country code + mobile network code) of the
 * provider of the SIM. 5 or 6 decimal digits.
 * <p>
 * Availability: SIM state must be {@link #SIM_STATE_READY}
 *
 * @see #getSimState
 */

public java.lang.String getSimOperator() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Service Provider Name (SPN).
 * <p>
 * Availability: SIM state must be {@link #SIM_STATE_READY}
 *
 * @see #getSimState
 */

public java.lang.String getSimOperatorName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ISO country code equivalent for the SIM provider's country code.
 */

public java.lang.String getSimCountryIso() { throw new RuntimeException("Stub!"); }

/**
 * Returns the serial number of the SIM, if applicable. Return null if it is
 * unavailable.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 */

public java.lang.String getSimSerialNumber() { throw new RuntimeException("Stub!"); }

/**
 * Returns the unique subscriber ID, for example, the IMSI for a GSM phone.
 * Return null if it is unavailable.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 */

public java.lang.String getSubscriberId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Group Identifier Level1 for a GSM phone.
 * Return null if it is unavailable.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 */

public java.lang.String getGroupIdLevel1() { throw new RuntimeException("Stub!"); }

/**
 * Returns the phone number string for line 1, for example, the MSISDN
 * for a GSM phone. Return null if it is unavailable.
 *
 * <p>Requires Permission:
 *     {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE},
 *     {@link android.Manifest.permission#READ_SMS READ_SMS},
 *     {@link android.Manifest.permission#READ_PHONE_NUMBERS READ_PHONE_NUMBERS},
 *     that the caller is the default SMS app,
 *     or that the caller has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#READ_PHONE_STATE} or {@link android.Manifest.permission#READ_SMS} or {@link android.Manifest.permission#READ_PHONE_NUMBERS}
 */

public java.lang.String getLine1Number() { throw new RuntimeException("Stub!"); }

/**
 * Set the line 1 phone number string and its alphatag for the current ICCID
 * for display purpose only, for example, displayed in Phone Status. It won't
 * change the actual MSISDN/MDN. To unset alphatag or number, pass in a null
 * value.
 *
 * <p>Requires that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param alphaTag alpha-tagging of the dailing nubmer
 * @param number The dialing number
 * @return true if the operation was executed correctly.
 */

public boolean setLine1NumberForDisplay(java.lang.String alphaTag, java.lang.String number) { throw new RuntimeException("Stub!"); }

/**
 * Returns the voice mail number. Return null if it is unavailable.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 */

public java.lang.String getVoiceMailNumber() { throw new RuntimeException("Stub!"); }

/**
 * Sets the voice mail number.
 *
 * <p>Requires that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param alphaTag The alpha tag to display.
 * @param number The voicemail number.
 */

public boolean setVoiceMailNumber(java.lang.String alphaTag, java.lang.String number) { throw new RuntimeException("Stub!"); }

/**
 * Returns the package responsible of processing visual voicemail for the subscription ID pinned
 * to the TelephonyManager. Returns {@code null} when there is no package responsible for
 * processing visual voicemail for the subscription.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @see #createForSubscriptionId(int)
 * @see #createForPhoneAccountHandle(PhoneAccountHandle)
 * @see VisualVoicemailService
 */

@androidx.annotation.RecentlyNullable public java.lang.String getVisualVoicemailPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Set the visual voicemail SMS filter settings for the subscription ID pinned
 * to the TelephonyManager.
 * When the filter is enabled, {@link
 * VisualVoicemailService#onSmsReceived(VisualVoicemailTask, VisualVoicemailSms)} will be
 * called when a SMS matching the settings is received. Caller must be the default dialer,
 * system dialer, or carrier visual voicemail app.
 *
 * @param settings The settings for the filter, or {@code null} to disable the filter.
 *
 * @see {@link TelecomManager#getDefaultDialerPackage()}
 * @see {@link CarrierConfigManager#KEY_CARRIER_VVM_PACKAGE_NAME_STRING_ARRAY}
 */

public void setVisualVoicemailSmsFilterSettings(android.telephony.VisualVoicemailSmsFilterSettings settings) { throw new RuntimeException("Stub!"); }

/**
 * Send a visual voicemail SMS. The caller must be the current default dialer.
 * A {@link VisualVoicemailService} uses this method to send a command via SMS to the carrier's
 * visual voicemail server.  Some examples for carriers using the OMTP standard include
 * activating and deactivating visual voicemail, or requesting the current visual voicemail
 * provisioning status.  See the OMTP Visual Voicemail specification for more information on the
 * format of these SMS messages.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#SEND_SMS SEND_SMS}
 *
 * @param number The destination number.
 * @param port The destination port for data SMS, or 0 for text SMS.
 * @param text The message content. For data sms, it will be encoded as a UTF-8 byte stream.
 * @param sentIntent The sent intent passed to the {@link SmsManager}
 *
 * @throws SecurityException if the caller is not the current default dialer
 *
 * @see SmsManager#sendDataMessage(String, String, short, byte[], PendingIntent, PendingIntent)
 * @see SmsManager#sendTextMessage(String, String, String, PendingIntent, PendingIntent)
 */

public void sendVisualVoicemailSms(java.lang.String number, int port, java.lang.String text, android.app.PendingIntent sentIntent) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the alphabetic identifier associated with the voice
 * mail number.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 */

public java.lang.String getVoiceMailAlphaTag() { throw new RuntimeException("Stub!"); }

/**
 * Send the special dialer code. The IPC caller must be the current default dialer or have
 * carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param inputCode The special dialer code to send
 *
 * @throws SecurityException if the caller does not have carrier privileges or is not the
 *         current default dialer
 */

public void sendDialerSpecialCode(java.lang.String inputCode) { throw new RuntimeException("Stub!"); }

/**
 * Returns one of the following constants that represents the current state of all
 * phone calls.
 *
 * {@link TelephonyManager#CALL_STATE_RINGING}
 * {@link TelephonyManager#CALL_STATE_OFFHOOK}
 * {@link TelephonyManager#CALL_STATE_IDLE}
 */

public int getCallState() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the type of activity on a data connection
 * (cellular).
 *
 * @see #DATA_ACTIVITY_NONE
 * @see #DATA_ACTIVITY_IN
 * @see #DATA_ACTIVITY_OUT
 * @see #DATA_ACTIVITY_INOUT
 * @see #DATA_ACTIVITY_DORMANT
 */

public int getDataActivity() { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the current data connection state
 * (cellular).
 *
 * @see #DATA_DISCONNECTED
 * @see #DATA_CONNECTING
 * @see #DATA_CONNECTED
 * @see #DATA_SUSPENDED
 */

public int getDataState() { throw new RuntimeException("Stub!"); }

/**
 * Registers a listener object to receive notification of changes
 * in specified telephony states.
 * <p>
 * To register a listener, pass a {@link PhoneStateListener}
 * and specify at least one telephony state of interest in
 * the events argument.
 *
 * At registration, and when a specified telephony state
 * changes, the telephony manager invokes the appropriate
 * callback method on the listener object and passes the
 * current (updated) values.
 * <p>
 * To unregister a listener, pass the listener object and set the
 * events argument to
 * {@link PhoneStateListener#LISTEN_NONE LISTEN_NONE} (0).
 * Note: if you call this method while in the middle of a binder transaction, you <b>must</b>
 * call {@link android.os.Binder#clearCallingIdentity()} before calling this method. A
 * {@link SecurityException} will be thrown otherwise.
 *
 * @param listener The {@link PhoneStateListener} object to register
 *                 (or unregister)
 * @param events The telephony state(s) of interest to the listener,
 *               as a bitwise-OR combination of {@link PhoneStateListener}
 *               LISTEN_ flags.
 */

public void listen(android.telephony.PhoneStateListener listener, int events) { throw new RuntimeException("Stub!"); }

/**
 * @return true if the current device is "voice capable".
 * <p>
 * "Voice capable" means that this device supports circuit-switched
 * (i.e. voice) phone calls over the telephony network, and is allowed
 * to display the in-call UI while a cellular voice call is active.
 * This will be false on "data only" devices which can't make voice
 * calls and don't support any in-call UI.
 * <p>
 * Note: the meaning of this flag is subtly different from the
 * PackageManager.FEATURE_TELEPHONY system feature, which is available
 * on any device with a telephony radio, even if the device is
 * data-only.
 */

public boolean isVoiceCapable() { throw new RuntimeException("Stub!"); }

/**
 * @return true if the current device supports sms service.
 * <p>
 * If true, this means that the device supports both sending and
 * receiving sms via the telephony network.
 * <p>
 * Note: Voicemail waiting sms, cell broadcasting sms, and MMS are
 *       disabled when device doesn't support sms.
 */

public boolean isSmsCapable() { throw new RuntimeException("Stub!"); }

/**
 * Returns all observed cell information from all radios on the
 * device including the primary and neighboring cells. Calling this method does
 * not trigger a call to {@link android.telephony.PhoneStateListener#onCellInfoChanged
 * onCellInfoChanged()}, or change the rate at which
 * {@link android.telephony.PhoneStateListener#onCellInfoChanged
 * onCellInfoChanged()} is called.
 *
 *<p>
 * The list can include one or more {@link android.telephony.CellInfoGsm CellInfoGsm},
 * {@link android.telephony.CellInfoCdma CellInfoCdma},
 * {@link android.telephony.CellInfoLte CellInfoLte}, and
 * {@link android.telephony.CellInfoWcdma CellInfoWcdma} objects, in any combination.
 * On devices with multiple radios it is typical to see instances of
 * one or more of any these in the list. In addition, zero, one, or more
 * of the returned objects may be considered registered; that is, their
 * {@link android.telephony.CellInfo#isRegistered CellInfo.isRegistered()}
 * methods may return true.
 *
 * <p>This method returns valid data for registered cells on devices with
 * {@link android.content.pm.PackageManager#FEATURE_TELEPHONY}. In cases where only
 * partial information is available for a particular CellInfo entry, unavailable fields
 * will be reported as Integer.MAX_VALUE. All reported cells will include at least a
 * valid set of technology-specific identification info and a power level measurement.
 *
 *<p>
 * This method is preferred over using {@link
 * android.telephony.TelephonyManager#getCellLocation getCellLocation()}.
 * However, for older devices, <code>getAllCellInfo()</code> may return
 * null. In these cases, you should call {@link
 * android.telephony.TelephonyManager#getCellLocation getCellLocation()}
 * instead.
 *
 * Requires {@link android.Manifest.permission#ACCESS_COARSE_LOCATION}
 * @return List of {@link android.telephony.CellInfo}; null if cell
 * information is unavailable.
 */

public java.util.List<android.telephony.CellInfo> getAllCellInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the MMS user agent.
 */

public java.lang.String getMmsUserAgent() { throw new RuntimeException("Stub!"); }

/**
 * Returns the MMS user agent profile URL.
 */

public java.lang.String getMmsUAProfUrl() { throw new RuntimeException("Stub!"); }

/**
 * Opens a logical channel to the ICC card.
 *
 * Input parameters equivalent to TS 27.007 AT+CCHO command.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param AID Application id. See ETSI 102.221 and 101.220.
 * @return an IccOpenLogicalChannelResponse object.
 * @deprecated Replaced by {@link #iccOpenLogicalChannel(String, int)}
 */

@Deprecated public android.telephony.IccOpenLogicalChannelResponse iccOpenLogicalChannel(java.lang.String AID) { throw new RuntimeException("Stub!"); }

/**
 * Opens a logical channel to the ICC card.
 *
 * Input parameters equivalent to TS 27.007 AT+CCHO command.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param AID Application id. See ETSI 102.221 and 101.220.
 * @param p2 P2 parameter (described in ISO 7816-4).
 * @return an IccOpenLogicalChannelResponse object.
 */

public android.telephony.IccOpenLogicalChannelResponse iccOpenLogicalChannel(java.lang.String AID, int p2) { throw new RuntimeException("Stub!"); }

/**
 * Closes a previously opened logical channel to the ICC card.
 *
 * Input parameters equivalent to TS 27.007 AT+CCHC command.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param channel is the channel id to be closed as retruned by a successful
 *            iccOpenLogicalChannel.
 * @return true if the channel was closed successfully.
 */

public boolean iccCloseLogicalChannel(int channel) { throw new RuntimeException("Stub!"); }

/**
 * Transmit an APDU to the ICC card over a logical channel.
 *
 * Input parameters equivalent to TS 27.007 AT+CGLA command.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param channel is the channel id to be closed as returned by a successful
 *            iccOpenLogicalChannel.
 * @param cla Class of the APDU command.
 * @param instruction Instruction of the APDU command.
 * @param p1 P1 value of the APDU command.
 * @param p2 P2 value of the APDU command.
 * @param p3 P3 value of the APDU command. If p3 is negative a 4 byte APDU
 *            is sent to the SIM.
 * @param data Data to be sent with the APDU.
 * @return The APDU response from the ICC card with the status appended at
 *            the end.
 */

public java.lang.String iccTransmitApduLogicalChannel(int channel, int cla, int instruction, int p1, int p2, int p3, java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Transmit an APDU to the ICC card over the basic channel.
 *
 * Input parameters equivalent to TS 27.007 AT+CSIM command.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param cla Class of the APDU command.
 * @param instruction Instruction of the APDU command.
 * @param p1 P1 value of the APDU command.
 * @param p2 P2 value of the APDU command.
 * @param p3 P3 value of the APDU command. If p3 is negative a 4 byte APDU
 *            is sent to the SIM.
 * @param data Data to be sent with the APDU.
 * @return The APDU response from the ICC card with the status appended at
 *            the end.
 */

public java.lang.String iccTransmitApduBasicChannel(int cla, int instruction, int p1, int p2, int p3, java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Returns the response APDU for a command APDU sent through SIM_IO.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param fileID
 * @param command
 * @param p1 P1 value of the APDU command.
 * @param p2 P2 value of the APDU command.
 * @param p3 P3 value of the APDU command.
 * @param filePath
 * @return The APDU response.
 */

public byte[] iccExchangeSimIO(int fileID, int command, int p1, int p2, int p3, java.lang.String filePath) { throw new RuntimeException("Stub!"); }

/**
 * Send ENVELOPE to the SIM and return the response.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param content String containing SAT/USAT response in hexadecimal
 *                format starting with command tag. See TS 102 223 for
 *                details.
 * @return The APDU response from the ICC card in hexadecimal format
 *         with the last 4 bytes being the status word. If the command fails,
 *         returns an empty string.
 */

public java.lang.String sendEnvelopeWithStatus(java.lang.String content) { throw new RuntimeException("Stub!"); }

/**
 * Returns the response of authentication for the default subscription.
 * Returns null if the authentication hasn't been successful
 *
 * <p>Requires Permission: READ_PRIVILEGED_PHONE_STATE or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param appType the icc application type, like {@link #APPTYPE_USIM}
 * @param authType the authentication type, {@link #AUTHTYPE_EAP_AKA} or
 * {@link #AUTHTYPE_EAP_SIM}
 * @param data authentication challenge data, base64 encoded.
 * See 3GPP TS 31.102 7.1.2 for more details.
 * @return the response of authentication. This value will be null in the following cases:
 *   Authentication error, incorrect MAC
 *   Authentication error, security context not supported
 *   Key freshness failure
 *   Authentication error, no memory space available
 *   Authentication error, no memory space available in EFMUK
 */

public java.lang.String getIccAuthentication(int appType, int authType, java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of Forbidden PLMNs from the USIM App
 * Returns null if the query fails.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @return an array of forbidden PLMNs or null if not available
 */

public java.lang.String[] getForbiddenPlmns() { throw new RuntimeException("Stub!"); }

/**
 * Sets the network selection mode to automatic.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 */

public void setNetworkSelectionModeAutomatic() { throw new RuntimeException("Stub!"); }

/**
 * Request a network scan.
 *
 * This method is asynchronous, so the network scan results will be returned by callback.
 * The returned NetworkScan will contain a callback method which can be used to stop the scan.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param request Contains all the RAT with bands/channels that need to be scanned.
 * @param executor The executor through which the callback should be invoked. Since the scan
 *        request may trigger multiple callbacks and they must be invoked in the same order as
 *        they are received by the platform, the user should provide an executor which executes
 *        tasks one at a time in serial order. For example AsyncTask.SERIAL_EXECUTOR.
 * @param callback Returns network scan results or errors.
 * @return A NetworkScan obj which contains a callback which can be used to stop the scan.
 */

public android.telephony.NetworkScan requestNetworkScan(android.telephony.NetworkScanRequest request, java.util.concurrent.Executor executor, android.telephony.TelephonyScanManager.NetworkScanCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Ask the radio to connect to the input network and change selection mode to manual.
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param operatorNumeric the PLMN ID of the network to select.
 * @param persistSelection whether the selection will persist until reboot. If true, only allows
 * attaching to the selected PLMN until reboot; otherwise, attach to the chosen PLMN and resume
 * normal network selection next time.
 * @return true on success; false on any failure.
 */

public boolean setNetworkSelectionModeManual(java.lang.String operatorNumeric, boolean persistSelection) { throw new RuntimeException("Stub!"); }

/**
 * Set the preferred network type to global mode which includes LTE, CDMA, EvDo and GSM/WCDMA.
 *
 * <p>Requires that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @return true on success; false on any failure.
 */

public boolean setPreferredNetworkTypeToGlobal() { throw new RuntimeException("Stub!"); }

/**
 * Has the calling application been granted carrier privileges by the carrier.
 *
 * If any of the packages in the calling UID has carrier privileges, the
 * call will return true. This access is granted by the owner of the UICC
 * card and does not depend on the registered carrier.
 *
 * @return true if the app has carrier privileges.
 */

public boolean hasCarrierPrivileges() { throw new RuntimeException("Stub!"); }

/**
 * Override the branding for the current ICCID.
 *
 * Once set, whenever the SIM is present in the device, the service
 * provider name (SPN) and the operator name will both be replaced by the
 * brand value input. To unset the value, the same function should be
 * called with a null brand value.
 *
 * <p>Requires that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * @param brand The brand name to display/set.
 * @return true if the operation was executed correctly.
 */

public boolean setOperatorBrandOverride(java.lang.String brand) { throw new RuntimeException("Stub!"); }

/**
 * Sends an Unstructured Supplementary Service Data (USSD) request to the mobile network and
 * informs the caller of the response via the supplied {@code callback}.
 * <p>Carriers define USSD codes which can be sent by the user to request information such as
 * the user's current data balance or minutes balance.
 * <p>Requires permission:
 * {@link android.Manifest.permission#CALL_PHONE}
 * Requires {@link android.Manifest.permission#CALL_PHONE}
 * @param ussdRequest the USSD command to be executed.
 * @param callback called by the framework to inform the caller of the result of executing the
 *                 USSD request (see {@link UssdResponseCallback}).
 * @param handler the {@link Handler} to run the request on.
 */

public void sendUssdRequest(java.lang.String ussdRequest, android.telephony.TelephonyManager.UssdResponseCallback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Whether the device is currently on a technology (e.g.&nbsp;UMTS or LTE) which can support
 * voice and data simultaneously. This can change based on location or network condition.
 *
 * @return {@code true} if simultaneous voice and data supported, and {@code false} otherwise.
 */

public boolean isConcurrentVoiceAndDataSupported() { throw new RuntimeException("Stub!"); }

/**
 * Turns mobile data on or off.
 * If this object has been created with {@link #createForSubscriptionId}, applies to the given
 * subId. Otherwise, applies to {@link SubscriptionManager#getDefaultDataSubscriptionId()}
 *
 * <p>Requires Permission:
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE} or that the calling
 * app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * Requires {@link android.Manifest.permission#MODIFY_PHONE_STATE}
 * @param enable Whether to enable mobile data.
 *
 */

public void setDataEnabled(boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether mobile data is enabled or not per user setting. There are other factors
 * that could disable mobile data, but they are not considered here.
 *
 * If this object has been created with {@link #createForSubscriptionId}, applies to the given
 * subId. Otherwise, applies to {@link SubscriptionManager#getDefaultDataSubscriptionId()}
 *
 * <p>Requires one of the following permissions:
 * {@link android.Manifest.permission#ACCESS_NETWORK_STATE ACCESS_NETWORK_STATE},
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE}, or that the
 * calling app has carrier privileges (see {@link #hasCarrierPrivileges}).
 *
 * <p>Note that this does not take into account any data restrictions that may be present on the
 * calling app. Such restrictions may be inspected with
 * {@link ConnectivityManager#getRestrictBackgroundStatus}.
 *
 * @return true if mobile data is enabled.
 */

public boolean isDataEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Whether the device supports configuring the DTMF tone length.
 *
 * @return {@code true} if the DTMF tone length can be changed, and {@code false} otherwise.
 */

public boolean canChangeDtmfToneLength() { throw new RuntimeException("Stub!"); }

/**
 * Whether the device is a world phone.
 *
 * @return {@code true} if the device is a world phone, and {@code false} otherwise.
 */

public boolean isWorldPhone() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link TelecomManager#isTtySupported()} instead
 * Whether the phone supports TTY mode.
 *
 * @return {@code true} if the device supports TTY mode, and {@code false} otherwise.
 *
 */

@Deprecated public boolean isTtyModeSupported() { throw new RuntimeException("Stub!"); }

/**
 * Whether the phone supports hearing aid compatibility.
 *
 * @return {@code true} if the device supports hearing aid compatibility, and {@code false}
 * otherwise.
 */

public boolean isHearingAidCompatibilitySupported() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current {@link ServiceState} information.
 *
 * <p>Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE}
 * or that the calling app has carrier privileges (see {@link #hasCarrierPrivileges}).

 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 */

public android.telephony.ServiceState getServiceState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the URI for the per-account voicemail ringtone set in Phone settings.
 *
 * @param accountHandle The handle for the {@link PhoneAccount} for which to retrieve the
 * voicemail ringtone.
 * @return The URI for the ringtone to play when receiving a voicemail from a specific
 * PhoneAccount.
 */

public android.net.Uri getVoicemailRingtoneUri(android.telecom.PhoneAccountHandle accountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Sets the per-account voicemail ringtone.
 *
 * <p>Requires that the calling app is the default dialer, or has carrier privileges (see
 * {@link #hasCarrierPrivileges}, or has permission
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE}.
 *
 * @param phoneAccountHandle The handle for the {@link PhoneAccount} for which to set the
 * voicemail ringtone.
 * @param uri The URI for the ringtone to play when receiving a voicemail from a specific
 * PhoneAccount.
 *
 * @deprecated Use {@link android.provider.Settings#ACTION_CHANNEL_NOTIFICATION_SETTINGS}
 * instead.
 */

@Deprecated public void setVoicemailRingtoneUri(android.telecom.PhoneAccountHandle phoneAccountHandle, android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether vibration is set for voicemail notification in Phone settings.
 *
 * @param accountHandle The handle for the {@link PhoneAccount} for which to retrieve the
 * voicemail vibration setting.
 * @return {@code true} if the vibration is set for this PhoneAccount, {@code false} otherwise.
 */

public boolean isVoicemailVibrationEnabled(android.telecom.PhoneAccountHandle accountHandle) { throw new RuntimeException("Stub!"); }

/**
 * Sets the per-account preference whether vibration is enabled for voicemail notifications.
 *
 * <p>Requires that the calling app is the default dialer, or has carrier privileges (see
 * {@link #hasCarrierPrivileges}, or has permission
 * {@link android.Manifest.permission#MODIFY_PHONE_STATE MODIFY_PHONE_STATE}.
 *
 * @param phoneAccountHandle The handle for the {@link PhoneAccount} for which to set the
 * voicemail vibration setting.
 * @param enabled Whether to enable or disable vibration for voicemail notifications from a
 * specific PhoneAccount.
 *
 * @deprecated Use {@link android.provider.Settings#ACTION_CHANNEL_NOTIFICATION_SETTINGS}
 * instead.
 */

@Deprecated public void setVoicemailVibrationEnabled(android.telecom.PhoneAccountHandle phoneAccountHandle, boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Returns carrier id of the current subscription.
 * <p>To recognize a carrier (including MVNO) as a first-class identity, Android assigns each
 * carrier with a canonical integer a.k.a. carrier id. The carrier ID is an Android
 * platform-wide identifier for a carrier. AOSP maintains carrier ID assignments in
 * <a href="https://android.googlesource.com/platform/packages/providers/TelephonyProvider/+/master/assets/carrier_list.textpb">here</a>
 *
 * <p>Apps which have carrier-specific configurations or business logic can use the carrier id
 * as an Android platform-wide identifier for carriers.
 *
 * @return Carrier id of the current subscription. Return {@link #UNKNOWN_CARRIER_ID} if the
 * subscription is unavailable or the carrier cannot be identified.
 */

public int getSimCarrierId() { throw new RuntimeException("Stub!"); }

/**
 * Returns carrier id name of the current subscription.
 * <p>Carrier id name is a user-facing name of carrier id
 * {@link #getSimCarrierId()}, usually the brand name of the subsidiary
 * (e.g. T-Mobile). Each carrier could configure multiple {@link #getSimOperatorName() SPN} but
 * should have a single carrier name. Carrier name is not a canonical identity,
 * use {@link #getSimCarrierId()} instead.
 * <p>The returned carrier name is unlocalized.
 *
 * @return Carrier name of the current subscription. Return {@code null} if the subscription is
 * unavailable or the carrier cannot be identified.
 */

public java.lang.CharSequence getSimCarrierIdName() { throw new RuntimeException("Stub!"); }

/**
 * Get the most recently available signal strength information.
 *
 * Get the most recent SignalStrength information reported by the modem. Due
 * to power saving this information may not always be current.
 * @return the most recent cached signal strength info from the modem

 * This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.telephony.SignalStrength getSignalStrength() { throw new RuntimeException("Stub!"); }

/**
 * Open the voicemail settings activity to make changes to voicemail configuration.
 *
 * <p>
 * The {@link #EXTRA_PHONE_ACCOUNT_HANDLE} extra indicates which {@link PhoneAccountHandle} to
 * configure voicemail.
 * The {@link #EXTRA_HIDE_PUBLIC_SETTINGS} hides settings the dialer will modify through public
 * API if set.
 *
 * @see #EXTRA_PHONE_ACCOUNT_HANDLE
 * @see #EXTRA_HIDE_PUBLIC_SETTINGS
 */

public static final java.lang.String ACTION_CONFIGURE_VOICEMAIL = "android.telephony.action.CONFIGURE_VOICEMAIL";

/**
 * Broadcast intent action indicating that the call state
 * on the device has changed.
 *
 * <p>
 * The {@link #EXTRA_STATE} extra indicates the new call state.
 * If a receiving app has {@link android.Manifest.permission#READ_CALL_LOG} permission, a second
 * extra {@link #EXTRA_INCOMING_NUMBER} provides the phone number for incoming and outgoing
 * calls as a String.
 * <p>
 * If the receiving app has
 * {@link android.Manifest.permission#READ_CALL_LOG} and
 * {@link android.Manifest.permission#READ_PHONE_STATE} permission, it will receive the
 * broadcast twice; one with the {@link #EXTRA_INCOMING_NUMBER} populated with the phone number,
 * and another with it blank.  Due to the nature of broadcasts, you cannot assume the order
 * in which these broadcasts will arrive, however you are guaranteed to receive two in this
 * case.  Apps which are interested in the {@link #EXTRA_INCOMING_NUMBER} can ignore the
 * broadcasts where {@link #EXTRA_INCOMING_NUMBER} is not present in the extras (e.g. where
 * {@link Intent#hasExtra(String)} returns {@code false}).
 * <p class="note">
 * This was a {@link android.content.Context#sendStickyBroadcast sticky}
 * broadcast in version 1.0, but it is no longer sticky.
 * Instead, use {@link #getCallState} to synchronously query the current call state.
 *
 * Requires {@link android.Manifest.permission#READ_PHONE_STATE}
 * @see #EXTRA_STATE
 * @see #EXTRA_INCOMING_NUMBER
 * @see #getCallState
 */

public static final java.lang.String ACTION_PHONE_STATE_CHANGED = "android.intent.action.PHONE_STATE";

/**
 * The Phone app sends this intent when a user opts to respond-via-message during an incoming
 * call. By default, the device's default SMS app consumes this message and sends a text message
 * to the caller. A third party app can also provide this functionality by consuming this Intent
 * with a {@link android.app.Service} and sending the message using its own messaging system.
 * <p>The intent contains a URI (available from {@link android.content.Intent#getData})
 * describing the recipient, using either the {@code sms:}, {@code smsto:}, {@code mms:},
 * or {@code mmsto:} URI schema. Each of these URI schema carry the recipient information the
 * same way: the path part of the URI contains the recipient's phone number or a comma-separated
 * set of phone numbers if there are multiple recipients. For example, {@code
 * smsto:2065551234}.</p>
 *
 * <p>The intent may also contain extras for the message text (in {@link
 * android.content.Intent#EXTRA_TEXT}) and a message subject
 * (in {@link android.content.Intent#EXTRA_SUBJECT}).</p>
 *
 * <p class="note"><strong>Note:</strong>
 * The intent-filter that consumes this Intent needs to be in a {@link android.app.Service}
 * that requires the
 * permission {@link android.Manifest.permission#SEND_RESPOND_VIA_MESSAGE}.</p>
 * <p>For example, the service that receives this intent can be declared in the manifest file
 * with an intent filter like this:</p>
 * <pre>
 * &lt;!-- Service that delivers SMS messages received from the phone "quick response" -->
 * &lt;service android:name=".HeadlessSmsSendService"
 *          android:permission="android.permission.SEND_RESPOND_VIA_MESSAGE"
 *          android:exported="true" >
 *   &lt;intent-filter>
 *     &lt;action android:name="android.intent.action.RESPOND_VIA_MESSAGE" />
 *     &lt;category android:name="android.intent.category.DEFAULT" />
 *     &lt;data android:scheme="sms" />
 *     &lt;data android:scheme="smsto" />
 *     &lt;data android:scheme="mms" />
 *     &lt;data android:scheme="mmsto" />
 *   &lt;/intent-filter>
 * &lt;/service></pre>
 * <p>
 * Output: nothing.
 */

public static final java.lang.String ACTION_RESPOND_VIA_MESSAGE = "android.intent.action.RESPOND_VIA_MESSAGE";

/**
 * Broadcast intent action for letting the default dialer to know to show voicemail
 * notification.
 *
 * <p>
 * The {@link #EXTRA_PHONE_ACCOUNT_HANDLE} extra indicates which {@link PhoneAccountHandle} the
 * voicemail is received on.
 * The {@link #EXTRA_NOTIFICATION_COUNT} extra indicates the total numbers of unheard
 * voicemails.
 * The {@link #EXTRA_VOICEMAIL_NUMBER} extra indicates the voicemail number if available.
 * The {@link #EXTRA_CALL_VOICEMAIL_INTENT} extra is a {@link android.app.PendingIntent} that
 * will call the voicemail number when sent. This extra will be empty if the voicemail number
 * is not set, and {@link #EXTRA_LAUNCH_VOICEMAIL_SETTINGS_INTENT} will be set instead.
 * The {@link #EXTRA_LAUNCH_VOICEMAIL_SETTINGS_INTENT} extra is a
 * {@link android.app.PendingIntent} that will launch the voicemail settings. This extra is only
 * available when the voicemail number is not set.
 * The {@link #EXTRA_IS_REFRESH} extra indicates whether the notification is a refresh or a new
 * notification.
 *
 * @see #EXTRA_PHONE_ACCOUNT_HANDLE
 * @see #EXTRA_NOTIFICATION_COUNT
 * @see #EXTRA_VOICEMAIL_NUMBER
 * @see #EXTRA_CALL_VOICEMAIL_INTENT
 * @see #EXTRA_LAUNCH_VOICEMAIL_SETTINGS_INTENT
 * @see #EXTRA_IS_REFRESH
 */

public static final java.lang.String ACTION_SHOW_VOICEMAIL_NOTIFICATION = "android.telephony.action.SHOW_VOICEMAIL_NOTIFICATION";

/**
 * Broadcast Action: The subscription carrier identity has changed.
 * This intent could be sent on the following events:
 * <ul>
 *   <li>Subscription absent. Carrier identity could change from a valid id to
 *   {@link TelephonyManager#UNKNOWN_CARRIER_ID}.</li>
 *   <li>Subscription loaded. Carrier identity could change from
 *   {@link TelephonyManager#UNKNOWN_CARRIER_ID} to a valid id.</li>
 *   <li>The subscription carrier is recognized after a remote update.</li>
 * </ul>
 * The intent will have the following extra values:
 * <ul>
 *   <li>{@link #EXTRA_CARRIER_ID} The up-to-date carrier id of the current subscription id.
 *   </li>
 *   <li>{@link #EXTRA_CARRIER_NAME} The up-to-date carrier name of the current subscription.
 *   </li>
 *   <li>{@link #EXTRA_SUBSCRIPTION_ID} The subscription id associated with the changed carrier
 *   identity.
 *   </li>
 * </ul>
 * <p class="note">This is a protected intent that can only be sent by the system.
 */

public static final java.lang.String ACTION_SUBSCRIPTION_CARRIER_IDENTITY_CHANGED = "android.telephony.action.SUBSCRIPTION_CARRIER_IDENTITY_CHANGED";

/** UICC application type is CSIM */

public static final int APPTYPE_CSIM = 4; // 0x4

/** UICC application type is ISIM */

public static final int APPTYPE_ISIM = 5; // 0x5

/** UICC application type is RUIM */

public static final int APPTYPE_RUIM = 3; // 0x3

/** UICC application type is SIM */

public static final int APPTYPE_SIM = 1; // 0x1

/** UICC application type is USIM */

public static final int APPTYPE_USIM = 2; // 0x2

/** Authentication type for UICC challenge is EAP AKA. See RFC 4187 for details. */

public static final int AUTHTYPE_EAP_AKA = 129; // 0x81

/** Authentication type for UICC challenge is EAP SIM. See RFC 4186 for details. */

public static final int AUTHTYPE_EAP_SIM = 128; // 0x80

/** Device call state: No activity. */

public static final int CALL_STATE_IDLE = 0; // 0x0

/** Device call state: Off-hook. At least one call exists
 * that is dialing, active, or on hold, and no calls are ringing
 * or waiting. */

public static final int CALL_STATE_OFFHOOK = 2; // 0x2

/** Device call state: Ringing. A new call arrived and is
 *  ringing or waiting. In the latter case, another call is
 *  already active. */

public static final int CALL_STATE_RINGING = 1; // 0x1

/**
 * Value for {@link CarrierConfigManager#KEY_CDMA_ROAMING_MODE_INT} which permits roaming on
 * affiliated networks.
 */

public static final int CDMA_ROAMING_MODE_AFFILIATED = 1; // 0x1

/**
 * Value for {@link CarrierConfigManager#KEY_CDMA_ROAMING_MODE_INT} which permits roaming on
 * any network.
 */

public static final int CDMA_ROAMING_MODE_ANY = 2; // 0x2

/**
 * Value for {@link CarrierConfigManager#KEY_CDMA_ROAMING_MODE_INT} which only permits
 * connections on home networks.
 */

public static final int CDMA_ROAMING_MODE_HOME = 0; // 0x0

/**
 * Value for {@link CarrierConfigManager#KEY_CDMA_ROAMING_MODE_INT} which leaves the roaming
 * mode set to the radio default or to the user's preference if they've indicated one.
 */

public static final int CDMA_ROAMING_MODE_RADIO_DEFAULT = -1; // 0xffffffff

/**
 * Data connection is active, but physical link is down
 */

public static final int DATA_ACTIVITY_DORMANT = 4; // 0x4

/** Data connection activity: Currently receiving IP PPP traffic. */

public static final int DATA_ACTIVITY_IN = 1; // 0x1

/** Data connection activity: Currently both sending and receiving
 *  IP PPP traffic. */

public static final int DATA_ACTIVITY_INOUT = 3; // 0x3

/** Data connection activity: No traffic. */

public static final int DATA_ACTIVITY_NONE = 0; // 0x0

/** Data connection activity: Currently sending IP PPP traffic. */

public static final int DATA_ACTIVITY_OUT = 2; // 0x2

/** Data connection state: Connected. IP traffic should be available. */

public static final int DATA_CONNECTED = 2; // 0x2

/** Data connection state: Currently setting up a data connection. */

public static final int DATA_CONNECTING = 1; // 0x1

/** Data connection state: Disconnected. IP traffic not available. */

public static final int DATA_DISCONNECTED = 0; // 0x0

/** Data connection state: Suspended. The connection is up, but IP
 * traffic is temporarily unavailable. For example, in a 2G network,
 * data activity may be suspended when a voice call arrives. */

public static final int DATA_SUSPENDED = 3; // 0x3

/**
 * The intent to call voicemail.
 */

public static final java.lang.String EXTRA_CALL_VOICEMAIL_INTENT = "android.telephony.extra.CALL_VOICEMAIL_INTENT";

/**
 * An int extra used with {@link #ACTION_SUBSCRIPTION_CARRIER_IDENTITY_CHANGED} which indicates
 * the updated carrier id {@link TelephonyManager#getSimCarrierId()} of
 * the current subscription.
 * <p>Will be {@link TelephonyManager#UNKNOWN_CARRIER_ID} if the subscription is unavailable or
 * the carrier cannot be identified.
 */

public static final java.lang.String EXTRA_CARRIER_ID = "android.telephony.extra.CARRIER_ID";

/**
 * An string extra used with {@link #ACTION_SUBSCRIPTION_CARRIER_IDENTITY_CHANGED} which
 * indicates the updated carrier name of the current subscription.
 * {@see TelephonyManager#getSimCarrierIdName()}
 * <p>Carrier name is a user-facing name of the carrier id {@link #EXTRA_CARRIER_ID},
 * usually the brand name of the subsidiary (e.g. T-Mobile).
 */

public static final java.lang.String EXTRA_CARRIER_NAME = "android.telephony.extra.CARRIER_NAME";

/**
 * The boolean value indicating whether the voicemail settings activity launched by {@link
 * #ACTION_CONFIGURE_VOICEMAIL} should hide settings accessible through public API. This is
 * used by dialer implementations which provides their own voicemail settings UI, but still
 * needs to expose device specific voicemail settings to the user.
 *
 * @see #ACTION_CONFIGURE_VOICEMAIL
 * @see #METADATA_HIDE_VOICEMAIL_SETTINGS_MENU
 */

public static final java.lang.String EXTRA_HIDE_PUBLIC_SETTINGS = "android.telephony.extra.HIDE_PUBLIC_SETTINGS";

/**
 * Extra key used with the {@link #ACTION_PHONE_STATE_CHANGED} broadcast
 * for a String containing the incoming or outgoing phone number.
 * <p>
 * This extra is only populated for receivers of the {@link #ACTION_PHONE_STATE_CHANGED}
 * broadcast which have been granted the {@link android.Manifest.permission#READ_CALL_LOG} and
 * {@link android.Manifest.permission#READ_PHONE_STATE} permissions.
 * <p>
 * For incoming calls, the phone number is only guaranteed to be populated when the
 * {@link #EXTRA_STATE} changes from {@link #EXTRA_STATE_IDLE} to {@link #EXTRA_STATE_RINGING}.
 * If the incoming caller is from an unknown number, the extra will be populated with an empty
 * string.
 * For outgoing calls, the phone number is only guaranteed to be populated when the
 * {@link #EXTRA_STATE} changes from {@link #EXTRA_STATE_IDLE} to {@link #EXTRA_STATE_OFFHOOK}.
 * <p class="note">
 * Retrieve with
 * {@link android.content.Intent#getStringExtra(String)}.
 */

public static final java.lang.String EXTRA_INCOMING_NUMBER = "incoming_number";

/**
 * Boolean value representing whether the {@link
 * TelephonyManager#ACTION_SHOW_VOICEMAIL_NOTIFICATION} is new or a refresh of an existing
 * notification. Notification refresh happens after reboot or connectivity changes. The user has
 * already been notified for the voicemail so it should not alert the user, and should not be
 * shown again if the user has dismissed it.
 */

public static final java.lang.String EXTRA_IS_REFRESH = "android.telephony.extra.IS_REFRESH";

/**
 * The intent to launch voicemail settings.
 */

public static final java.lang.String EXTRA_LAUNCH_VOICEMAIL_SETTINGS_INTENT = "android.telephony.extra.LAUNCH_VOICEMAIL_SETTINGS_INTENT";

/**
 * The number of voice messages associated with the notification.
 */

public static final java.lang.String EXTRA_NOTIFICATION_COUNT = "android.telephony.extra.NOTIFICATION_COUNT";

/**
 * The extra used with an {@link #ACTION_CONFIGURE_VOICEMAIL} and
 * {@link #ACTION_SHOW_VOICEMAIL_NOTIFICATION} {@code Intent} to specify the
 * {@link PhoneAccountHandle} the configuration or notification is for.
 * <p class="note">
 * Retrieve with {@link android.content.Intent#getParcelableExtra(String)}.
 */

public static final java.lang.String EXTRA_PHONE_ACCOUNT_HANDLE = "android.telephony.extra.PHONE_ACCOUNT_HANDLE";

/**
 * The lookup key used with the {@link #ACTION_PHONE_STATE_CHANGED} broadcast
 * for a String containing the new call state.
 *
 * <p class="note">
 * Retrieve with
 * {@link android.content.Intent#getStringExtra(String)}.
 *
 * @see #EXTRA_STATE_IDLE
 * @see #EXTRA_STATE_RINGING
 * @see #EXTRA_STATE_OFFHOOK
 */

public static final java.lang.String EXTRA_STATE = "state";

/**
 * Value used with {@link #EXTRA_STATE} corresponding to
 * {@link #CALL_STATE_IDLE}.
 */

public static final java.lang.String EXTRA_STATE_IDLE;
static { EXTRA_STATE_IDLE = null; }

/**
 * Value used with {@link #EXTRA_STATE} corresponding to
 * {@link #CALL_STATE_OFFHOOK}.
 */

public static final java.lang.String EXTRA_STATE_OFFHOOK;
static { EXTRA_STATE_OFFHOOK = null; }

/**
 * Value used with {@link #EXTRA_STATE} corresponding to
 * {@link #CALL_STATE_RINGING}.
 */

public static final java.lang.String EXTRA_STATE_RINGING;
static { EXTRA_STATE_RINGING = null; }

/**
 * An int extra used with {@link #ACTION_SUBSCRIPTION_CARRIER_IDENTITY_CHANGED} to indicate the
 * subscription which has changed.
 */

public static final java.lang.String EXTRA_SUBSCRIPTION_ID = "android.telephony.extra.SUBSCRIPTION_ID";

/**
 * The voicemail number.
 */

public static final java.lang.String EXTRA_VOICEMAIL_NUMBER = "android.telephony.extra.VOICEMAIL_NUMBER";

/**
 * A boolean meta-data value indicating whether the voicemail settings should be hidden in the
 * call settings page launched by
 * {@link android.telecom.TelecomManager#ACTION_SHOW_CALL_SETTINGS}.
 * Dialer implementations (see {@link android.telecom.TelecomManager#getDefaultDialerPackage()})
 * which would also like to manage voicemail settings should set this meta-data to {@code true}
 * in the manifest registration of their application.
 *
 * @see android.telecom.TelecomManager#ACTION_SHOW_CALL_SETTINGS
 * @see #ACTION_CONFIGURE_VOICEMAIL
 * @see #EXTRA_HIDE_PUBLIC_SETTINGS
 */

public static final java.lang.String METADATA_HIDE_VOICEMAIL_SETTINGS_MENU = "android.telephony.HIDE_VOICEMAIL_SETTINGS_MENU";

/** Current network is 1xRTT*/

public static final int NETWORK_TYPE_1xRTT = 7; // 0x7

/** Current network is CDMA: Either IS95A or IS95B*/

public static final int NETWORK_TYPE_CDMA = 4; // 0x4

/** Current network is EDGE */

public static final int NETWORK_TYPE_EDGE = 2; // 0x2

/** Current network is eHRPD */

public static final int NETWORK_TYPE_EHRPD = 14; // 0xe

/** Current network is EVDO revision 0*/

public static final int NETWORK_TYPE_EVDO_0 = 5; // 0x5

/** Current network is EVDO revision A*/

public static final int NETWORK_TYPE_EVDO_A = 6; // 0x6

/** Current network is EVDO revision B*/

public static final int NETWORK_TYPE_EVDO_B = 12; // 0xc

/** Current network is GPRS */

public static final int NETWORK_TYPE_GPRS = 1; // 0x1

/** Current network is GSM */

public static final int NETWORK_TYPE_GSM = 16; // 0x10

/** Current network is HSDPA */

public static final int NETWORK_TYPE_HSDPA = 8; // 0x8

/** Current network is HSPA */

public static final int NETWORK_TYPE_HSPA = 10; // 0xa

/** Current network is HSPA+ */

public static final int NETWORK_TYPE_HSPAP = 15; // 0xf

/** Current network is HSUPA */

public static final int NETWORK_TYPE_HSUPA = 9; // 0x9

/** Current network is iDen */

public static final int NETWORK_TYPE_IDEN = 11; // 0xb

/** Current network is IWLAN */

public static final int NETWORK_TYPE_IWLAN = 18; // 0x12

/** Current network is LTE */

public static final int NETWORK_TYPE_LTE = 13; // 0xd

/** Current network is TD_SCDMA */

public static final int NETWORK_TYPE_TD_SCDMA = 17; // 0x11

/** Current network is UMTS */

public static final int NETWORK_TYPE_UMTS = 3; // 0x3

/** Network type is unknown */

public static final int NETWORK_TYPE_UNKNOWN = 0; // 0x0

/** Phone radio is CDMA. */

public static final int PHONE_TYPE_CDMA = 2; // 0x2

/** Phone radio is GSM. */

public static final int PHONE_TYPE_GSM = 1; // 0x1

/** No phone radio. */

public static final int PHONE_TYPE_NONE = 0; // 0x0

/** Phone is via SIP. */

public static final int PHONE_TYPE_SIP = 3; // 0x3

/** SIM card state: no SIM card is available in the device */

public static final int SIM_STATE_ABSENT = 1; // 0x1

/** SIM card state: SIM Card Error, present but faulty */

public static final int SIM_STATE_CARD_IO_ERROR = 8; // 0x8

/** SIM card state: SIM Card restricted, present but not usable due to
 * carrier restrictions.
 */

public static final int SIM_STATE_CARD_RESTRICTED = 9; // 0x9

/** SIM card state: Locked: requires a network PIN to unlock */

public static final int SIM_STATE_NETWORK_LOCKED = 4; // 0x4

/** SIM card state: SIM Card is NOT READY */

public static final int SIM_STATE_NOT_READY = 6; // 0x6

/** SIM card state: SIM Card Error, permanently disabled */

public static final int SIM_STATE_PERM_DISABLED = 7; // 0x7

/** SIM card state: Locked: requires the user's SIM PIN to unlock */

public static final int SIM_STATE_PIN_REQUIRED = 2; // 0x2

/** SIM card state: Locked: requires the user's SIM PUK to unlock */

public static final int SIM_STATE_PUK_REQUIRED = 3; // 0x3

/** SIM card state: Ready */

public static final int SIM_STATE_READY = 5; // 0x5

/**
 * SIM card state: Unknown. Signifies that the SIM is in transition
 * between states. For example, when the user inputs the SIM pin
 * under PIN_REQUIRED state, a query for sim status returns
 * this state before turning to SIM_STATE_READY.
 *
 * These are the ordinal value of IccCardConstants.State.
 */

public static final int SIM_STATE_UNKNOWN = 0; // 0x0

/**
 * An unknown carrier id. It could either be subscription unavailable or the subscription
 * carrier cannot be recognized. Unrecognized carriers here means
 * {@link #getSimOperator() MCC+MNC} cannot be identified.
 */

public static final int UNKNOWN_CARRIER_ID = -1; // 0xffffffff

/**
 * Failure code returned when a USSD request has failed to execute because the Telephony
 * service is unavailable.
 * <p>
 * Returned via {@link TelephonyManager.UssdResponseCallback#onReceiveUssdResponseFailed(
 * TelephonyManager, String, int)}.
 */

public static final int USSD_ERROR_SERVICE_UNAVAIL = -2; // 0xfffffffe

/**
 * Failed code returned when the mobile network has failed to complete a USSD request.
 * <p>
 * Returned via {@link TelephonyManager.UssdResponseCallback#onReceiveUssdResponseFailed(
 * TelephonyManager, String, int)}.
 */

public static final int USSD_RETURN_FAILURE = -1; // 0xffffffff

/**
 * A flavor of OMTP protocol with a different mobile originated (MO) format
 */

public static final java.lang.String VVM_TYPE_CVVM = "vvm_type_cvvm";

/**
 * The OMTP protocol.
 */

public static final java.lang.String VVM_TYPE_OMTP = "vvm_type_omtp";
/**
 * Used to notify callers of
 * {@link TelephonyManager#sendUssdRequest(String, UssdResponseCallback, Handler)} when the
 * network either successfully executes a USSD request, or if there was a failure while
 * executing the request.
 * <p>
 * {@link #onReceiveUssdResponse(TelephonyManager, String, CharSequence)} will be called if the
 * USSD request has succeeded.
 * {@link #onReceiveUssdResponseFailed(TelephonyManager, String, int)} will be called if the
 * USSD request has failed.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class UssdResponseCallback {

public UssdResponseCallback() { throw new RuntimeException("Stub!"); }

/**
 * Called when a USSD request has succeeded.  The {@code response} contains the USSD
 * response received from the network.  The calling app can choose to either display the
 * response to the user or perform some operation based on the response.
 * <p>
 * USSD responses are unstructured text and their content is determined by the mobile network
 * operator.
 *
 * @param telephonyManager the TelephonyManager the callback is registered to.
 * @param request the USSD request sent to the mobile network.
 * @param response the response to the USSD request provided by the mobile network.
 **/

public void onReceiveUssdResponse(android.telephony.TelephonyManager telephonyManager, java.lang.String request, java.lang.CharSequence response) { throw new RuntimeException("Stub!"); }

/**
 * Called when a USSD request has failed to complete.
 *
 * @param telephonyManager the TelephonyManager the callback is registered to.
 * @param request the USSD request sent to the mobile network.
 * @param failureCode failure code indicating why the request failed.  Will be either
 *        {@link TelephonyManager#USSD_RETURN_FAILURE} or
 *        {@link TelephonyManager#USSD_ERROR_SERVICE_UNAVAIL}.
 **/

public void onReceiveUssdResponseFailed(android.telephony.TelephonyManager telephonyManager, java.lang.String request, int failureCode) { throw new RuntimeException("Stub!"); }
}

}

