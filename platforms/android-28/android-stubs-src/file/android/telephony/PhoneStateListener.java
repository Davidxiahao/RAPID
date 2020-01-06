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
import android.os.Looper;
import android.os.Message;

/**
 * A listener class for monitoring changes in specific telephony states
 * on the device, including service state, signal strength, message
 * waiting indicator (voicemail), and others.
 * <p>
 * Override the methods for the state that you wish to receive updates for, and
 * pass your PhoneStateListener object, along with bitwise-or of the LISTEN_
 * flags to {@link TelephonyManager#listen TelephonyManager.listen()}.
 * <p>
 * Note that access to some telephony information is
 * permission-protected. Your application won't receive updates for protected
 * information unless it has the appropriate permissions declared in
 * its manifest file. Where permissions apply, they are noted in the
 * appropriate LISTEN_ flags.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PhoneStateListener {

/**
 * Create a PhoneStateListener for the Phone with the default subscription.
 * This class requires Looper.myLooper() not return null.
 */

public PhoneStateListener() { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when device service state changes.
 *
 * @see ServiceState#STATE_EMERGENCY_ONLY
 * @see ServiceState#STATE_IN_SERVICE
 * @see ServiceState#STATE_OUT_OF_SERVICE
 * @see ServiceState#STATE_POWER_OFF
 */

public void onServiceStateChanged(android.telephony.ServiceState serviceState) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when network signal strength changes.
 *
 * @see ServiceState#STATE_EMERGENCY_ONLY
 * @see ServiceState#STATE_IN_SERVICE
 * @see ServiceState#STATE_OUT_OF_SERVICE
 * @see ServiceState#STATE_POWER_OFF
 * @deprecated Use {@link #onSignalStrengthsChanged(SignalStrength)}
 */

@Deprecated public void onSignalStrengthChanged(int asu) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when the message-waiting indicator changes.
 */

public void onMessageWaitingIndicatorChanged(boolean mwi) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when the call-forwarding indicator changes.
 */

public void onCallForwardingIndicatorChanged(boolean cfi) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when device cell location changes.
 */

public void onCellLocationChanged(android.telephony.CellLocation location) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when device call state changes.
 * @param state call state
 * @param phoneNumber call phone number. If application does not have
 * {@link android.Manifest.permission#READ_CALL_LOG READ_CALL_LOG} permission or carrier
 * privileges (see {@link TelephonyManager#hasCarrierPrivileges}), an empty string will be
 * passed as an argument.
 *
 * @see TelephonyManager#CALL_STATE_IDLE
 * @see TelephonyManager#CALL_STATE_RINGING
 * @see TelephonyManager#CALL_STATE_OFFHOOK
 */

public void onCallStateChanged(int state, java.lang.String phoneNumber) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when connection state changes.
 *
 * @see TelephonyManager#DATA_DISCONNECTED
 * @see TelephonyManager#DATA_CONNECTING
 * @see TelephonyManager#DATA_CONNECTED
 * @see TelephonyManager#DATA_SUSPENDED
 */

public void onDataConnectionStateChanged(int state) { throw new RuntimeException("Stub!"); }

/**
 * same as above, but with the network type.  Both called.
 */

public void onDataConnectionStateChanged(int state, int networkType) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when data activity state changes.
 *
 * @see TelephonyManager#DATA_ACTIVITY_NONE
 * @see TelephonyManager#DATA_ACTIVITY_IN
 * @see TelephonyManager#DATA_ACTIVITY_OUT
 * @see TelephonyManager#DATA_ACTIVITY_INOUT
 * @see TelephonyManager#DATA_ACTIVITY_DORMANT
 */

public void onDataActivity(int direction) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when network signal strengths changes.
 *
 * @see ServiceState#STATE_EMERGENCY_ONLY
 * @see ServiceState#STATE_IN_SERVICE
 * @see ServiceState#STATE_OUT_OF_SERVICE
 * @see ServiceState#STATE_POWER_OFF
 */

public void onSignalStrengthsChanged(android.telephony.SignalStrength signalStrength) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when a observed cell info has changed,
 * or new cells have been added or removed.
 * @param cellInfo is the list of currently visible cells.
 */

public void onCellInfoChanged(java.util.List<android.telephony.CellInfo> cellInfo) { throw new RuntimeException("Stub!"); }

/**
 * Callback invoked when the user mobile data state has changed
 * @param enabled indicates whether the current user mobile data state is enabled or disabled.
 */

public void onUserMobileDataStateChanged(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * Listen for changes to the call-forwarding indicator.
 * {@more}
 * Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE
 * READ_PHONE_STATE} or that the calling app has carrier privileges (see
 * {@link TelephonyManager#hasCarrierPrivileges}).
 *
 * @see #onCallForwardingIndicatorChanged
 */

public static final int LISTEN_CALL_FORWARDING_INDICATOR = 8; // 0x8

/**
 * Listen for changes to the device call state.
 * {@more}
 *
 * @see #onCallStateChanged
 */

public static final int LISTEN_CALL_STATE = 32; // 0x20

/**
 * Listen for changes to observed cell info.
 *
 * @see #onCellInfoChanged
 */

public static final int LISTEN_CELL_INFO = 1024; // 0x400

/**
 * Listen for changes to the device's cell location. Note that
 * this will result in frequent callbacks to the listener.
 * {@more}
 * Requires Permission: {@link android.Manifest.permission#ACCESS_COARSE_LOCATION
 * ACCESS_COARSE_LOCATION}
 * <p>
 * If you need regular location updates but want more control over
 * the update interval or location precision, you can set up a listener
 * through the {@link android.location.LocationManager location manager}
 * instead.
 *
 * @see #onCellLocationChanged
 */

public static final int LISTEN_CELL_LOCATION = 16; // 0x10

/**
 * Listen for changes to the direction of data traffic on the data
 * connection (cellular).
 * {@more}
 * Example: The status bar uses this to display the appropriate
 * data-traffic icon.
 *
 * @see #onDataActivity
 */

public static final int LISTEN_DATA_ACTIVITY = 128; // 0x80

/**
 * Listen for changes to the data connection state (cellular).
 *
 * @see #onDataConnectionStateChanged
 */

public static final int LISTEN_DATA_CONNECTION_STATE = 64; // 0x40

/**
 * Listen for changes to the message-waiting indicator.
 * {@more}
 * Requires Permission: {@link android.Manifest.permission#READ_PHONE_STATE
 * READ_PHONE_STATE} or that the calling app has carrier privileges (see
 * {@link TelephonyManager#hasCarrierPrivileges}).
 * <p>
 * Example: The status bar uses this to determine when to display the
 * voicemail icon.
 *
 * @see #onMessageWaitingIndicatorChanged
 */

public static final int LISTEN_MESSAGE_WAITING_INDICATOR = 4; // 0x4

/**
 * Stop listening for updates.
 */

public static final int LISTEN_NONE = 0; // 0x0

/**
 *  Listen for changes to the network service state (cellular).
 *
 *  @see #onServiceStateChanged
 *  @see ServiceState
 */

public static final int LISTEN_SERVICE_STATE = 1; // 0x1

/**
 * Listen for changes to the network signal strength (cellular).
 * {@more}
 *
 * @see #onSignalStrengthChanged
 *
 * @deprecated by {@link #LISTEN_SIGNAL_STRENGTHS}
 */

@Deprecated public static final int LISTEN_SIGNAL_STRENGTH = 2; // 0x2

/**
 * Listen for changes to the network signal strengths (cellular).
 * <p>
 * Example: The status bar uses this to control the signal-strength
 * icon.
 *
 * @see #onSignalStrengthsChanged
 */

public static final int LISTEN_SIGNAL_STRENGTHS = 256; // 0x100

/**
 *  Listen for changes to the user mobile data state
 *
 *  @see #onUserMobileDataStateChanged
 */

public static final int LISTEN_USER_MOBILE_DATA_STATE = 524288; // 0x80000
}

