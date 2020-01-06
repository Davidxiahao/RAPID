/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.telecom;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.List;
import java.util.Set;
import android.bluetooth.BluetoothDevice;
import android.net.Uri;
import android.app.Notification;
import android.content.Intent;
import java.util.concurrent.ConcurrentHashMap;
import android.hardware.camera2.CameraManager;
import android.view.Surface;
import android.os.Binder;
import android.os.IBinder;

/**
 * Represents a phone call or connection to a remote endpoint that carries voice and/or video
 * traffic.
 * <p>
 * Implementations create a custom subclass of {@code Connection} and return it to the framework
 * as the return value of
 * {@link ConnectionService#onCreateIncomingConnection(PhoneAccountHandle, ConnectionRequest)}
 * or
 * {@link ConnectionService#onCreateOutgoingConnection(PhoneAccountHandle, ConnectionRequest)}.
 * Implementations are then responsible for updating the state of the {@code Connection}, and
 * must call {@link #destroy()} to signal to the framework that the {@code Connection} is no
 * longer used and associated resources may be recovered.
 * <p>
 * Subclasses of {@code Connection} override the {@code on*} methods to provide the the
 * {@link ConnectionService}'s implementation of calling functionality.  The {@code on*} methods are
 * called by Telecom to inform an instance of a {@code Connection} of actions specific to that
 * {@code Connection} instance.
 * <p>
 * Basic call support requires overriding the following methods: {@link #onAnswer()},
 * {@link #onDisconnect()}, {@link #onReject()}, {@link #onAbort()}
 * <p>
 * Where a {@code Connection} has {@link #CAPABILITY_SUPPORT_HOLD}, the {@link #onHold()} and
 * {@link #onUnhold()} methods should be overridden to provide hold support for the
 * {@code Connection}.
 * <p>
 * Where a {@code Connection} supports a variation of video calling (e.g. the
 * {@code CAPABILITY_SUPPORTS_VT_*} capability bits), {@link #onAnswer(int)} should be overridden
 * to support answering a call as a video call.
 * <p>
 * Where a {@code Connection} has {@link #PROPERTY_IS_EXTERNAL_CALL} and
 * {@link #CAPABILITY_CAN_PULL_CALL}, {@link #onPullExternalCall()} should be overridden to provide
 * support for pulling the external call.
 * <p>
 * Where a {@code Connection} supports conference calling {@link #onSeparate()} should be
 * overridden.
 * <p>
 * There are a number of other {@code on*} methods which a {@code Connection} can choose to
 * implement, depending on whether it is concerned with the associated calls from Telecom.  If,
 * for example, call events from a {@link InCallService} are handled,
 * {@link #onCallEvent(String, Bundle)} should be overridden.  Another example is
 * {@link #onExtrasChanged(Bundle)}, which should be overridden if the {@code Connection} wishes to
 * make use of extra information provided via the {@link Call#putExtras(Bundle)} and
 * {@link Call#removeExtras(String...)} methods.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Connection extends android.telecom.Conferenceable {

/**
 * Create a new Connection.
 */

public Connection() { throw new RuntimeException("Stub!"); }

/**
 * Renders a set of capability bits ({@code CAPABILITY_*}) as a human readable string.
 *
 * @param capabilities A capability bit field.
 * @return A human readable string representation.
 */

public static java.lang.String capabilitiesToString(int capabilities) { throw new RuntimeException("Stub!"); }

/**
 * Renders a set of property bits ({@code PROPERTY_*}) as a human readable string.
 *
 * @param properties A property bit field.
 * @return A human readable string representation.
 */

public static java.lang.String propertiesToString(int properties) { throw new RuntimeException("Stub!"); }

/**
 * @return The address (e.g., phone number) to which this Connection is currently communicating.
 */

public final android.net.Uri getAddress() { throw new RuntimeException("Stub!"); }

/**
 * @return The presentation requirements for the address.
 *         See {@link TelecomManager} for valid values.
 */

public final int getAddressPresentation() { throw new RuntimeException("Stub!"); }

/**
 * @return The caller display name (CNAP).
 */

public final java.lang.String getCallerDisplayName() { throw new RuntimeException("Stub!"); }

/**
 * @return The presentation requirements for the handle.
 *         See {@link TelecomManager} for valid values.
 */

public final int getCallerDisplayNamePresentation() { throw new RuntimeException("Stub!"); }

/**
 * @return The state of this Connection.
 */

public final int getState() { throw new RuntimeException("Stub!"); }

/**
 * @return The audio state of the connection, describing how its audio is currently
 *         being routed by the system. This is {@code null} if this Connection
 *         does not directly know about its audio state.
 */

public final android.telecom.CallAudioState getCallAudioState() { throw new RuntimeException("Stub!"); }

/**
 * @return The conference that this connection is a part of.  Null if it is not part of any
 *         conference.
 */

public final android.telecom.Conference getConference() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this connection is requesting that the system play a ringback tone
 * on its behalf.
 */

public final boolean isRingbackRequested() { throw new RuntimeException("Stub!"); }

/**
 * @return True if the connection's audio mode is VOIP.
 */

public final boolean getAudioModeIsVoip() { throw new RuntimeException("Stub!"); }

/**
 * @return The status hints for this connection.
 */

public final android.telecom.StatusHints getStatusHints() { throw new RuntimeException("Stub!"); }

/**
 * Returns the extras associated with this connection.
 * <p>
 * Extras should be updated using {@link #putExtras(Bundle)}.
 * <p>
 * Telecom or an {@link InCallService} can also update the extras via
 * {@link android.telecom.Call#putExtras(Bundle)}, and
 * {@link Call#removeExtras(List)}.
 * <p>
 * The connection is notified of changes to the extras made by Telecom or an
 * {@link InCallService} by {@link #onExtrasChanged(Bundle)}.
 *
 * @return The extras associated with this connection.
 */

public final android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * @return The {@link DisconnectCause} for this connection.
 */

public final android.telecom.DisconnectCause getDisconnectCause() { throw new RuntimeException("Stub!"); }

/**
 * @param state An integer value of a {@code STATE_*} constant.
 * @return A string representation of the value.
 */

public static java.lang.String stateToString(int state) { throw new RuntimeException("Stub!"); }

/**
 * Returns the connection's capabilities, as a bit mask of the {@code CAPABILITY_*} constants.
 */

public final int getConnectionCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the connection's properties, as a bit mask of the {@code PROPERTY_*} constants.
 */

public final int getConnectionProperties() { throw new RuntimeException("Stub!"); }

/**
 * Sets the value of the {@link #getAddress()} property.
 *
 * @param address The new address.
 * @param presentation The presentation requirements for the address.
 *        See {@link TelecomManager} for valid values.
 */

public final void setAddress(android.net.Uri address, int presentation) { throw new RuntimeException("Stub!"); }

/**
 * Sets the caller display name (CNAP).
 *
 * @param callerDisplayName The new display name.
 * @param presentation The presentation requirements for the handle.
 *        See {@link TelecomManager} for valid values.
 */

public final void setCallerDisplayName(java.lang.String callerDisplayName, int presentation) { throw new RuntimeException("Stub!"); }

/**
 * Set the video state for the connection.
 * Valid values: {@link VideoProfile#STATE_AUDIO_ONLY},
 * {@link VideoProfile#STATE_BIDIRECTIONAL},
 * {@link VideoProfile#STATE_TX_ENABLED},
 * {@link VideoProfile#STATE_RX_ENABLED}.
 *
 * @param videoState The new video state.
 */

public final void setVideoState(int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Sets state to active (e.g., an ongoing connection where two or more parties can actively
 * communicate).
 */

public final void setActive() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to ringing (e.g., an inbound ringing connection).
 */

public final void setRinging() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to initializing (this Connection is not yet ready to be used).
 */

public final void setInitializing() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to initialized (the Connection has been set up and is now ready to be used).
 */

public final void setInitialized() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to dialing (e.g., dialing an outbound connection).
 */

public final void setDialing() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to pulling (e.g.&nbsp;the connection is being pulled to the local device from another
 * device).  Only applicable for {@link Connection}s with
 * {@link Connection#PROPERTY_IS_EXTERNAL_CALL} and {@link Connection#CAPABILITY_CAN_PULL_CALL}.
 */

public final void setPulling() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to be on hold.
 */

public final void setOnHold() { throw new RuntimeException("Stub!"); }

/**
 * Sets the video connection provider.
 * @param videoProvider The video provider.
 */

public final void setVideoProvider(android.telecom.Connection.VideoProvider videoProvider) { throw new RuntimeException("Stub!"); }

public final android.telecom.Connection.VideoProvider getVideoProvider() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to disconnected.
 *
 * @param disconnectCause The reason for the disconnection, as specified by
 *         {@link DisconnectCause}.
 */

public final void setDisconnected(android.telecom.DisconnectCause disconnectCause) { throw new RuntimeException("Stub!"); }

/**
 * Informs listeners that this {@code Connection} is in a post-dial wait state. This is done
 * when (a) the {@code Connection} is issuing a DTMF sequence; (b) it has encountered a "wait"
 * character; and (c) it wishes to inform the In-Call app that it is waiting for the end-user
 * to send an {@link #onPostDialContinue(boolean)} signal.
 *
 * @param remaining The DTMF character sequence remaining to be emitted once the
 *         {@link #onPostDialContinue(boolean)} is received, including any "wait" characters
 *         that remaining sequence may contain.
 */

public final void setPostDialWait(java.lang.String remaining) { throw new RuntimeException("Stub!"); }

/**
 * Informs listeners that this {@code Connection} has processed a character in the post-dial
 * started state. This is done when (a) the {@code Connection} is issuing a DTMF sequence;
 * and (b) it wishes to signal Telecom to play the corresponding DTMF tone locally.
 *
 * @param nextChar The DTMF character that was just processed by the {@code Connection}.
 */

public final void setNextPostDialChar(char nextChar) { throw new RuntimeException("Stub!"); }

/**
 * Requests that the framework play a ringback tone. This is to be invoked by implementations
 * that do not play a ringback tone themselves in the connection's audio stream.
 *
 * @param ringback Whether the ringback tone is to be played.
 */

public final void setRingbackRequested(boolean ringback) { throw new RuntimeException("Stub!"); }

/**
 * Sets the connection's capabilities as a bit mask of the {@code CAPABILITY_*} constants.
 *
 * @param connectionCapabilities The new connection capabilities.
 */

public final void setConnectionCapabilities(int connectionCapabilities) { throw new RuntimeException("Stub!"); }

/**
 * Sets the connection's properties as a bit mask of the {@code PROPERTY_*} constants.
 *
 * @param connectionProperties The new connection properties.
 */

public final void setConnectionProperties(int connectionProperties) { throw new RuntimeException("Stub!"); }

/**
 * Tears down the Connection object.
 */

public final void destroy() { throw new RuntimeException("Stub!"); }

/**
 * Requests that the framework use VOIP audio mode for this connection.
 *
 * @param isVoip True if the audio mode is VOIP.
 */

public final void setAudioModeIsVoip(boolean isVoip) { throw new RuntimeException("Stub!"); }

/**
 * Sets the label and icon status to display in the in-call UI.
 *
 * @param statusHints The status label and icon to set.
 */

public final void setStatusHints(android.telecom.StatusHints statusHints) { throw new RuntimeException("Stub!"); }

/**
 * Sets the connections with which this connection can be conferenced.
 *
 * @param conferenceableConnections The set of connections this connection can conference with.
 */

public final void setConferenceableConnections(java.util.List<android.telecom.Connection> conferenceableConnections) { throw new RuntimeException("Stub!"); }

/**
 * Similar to {@link #setConferenceableConnections(java.util.List)}, sets a list of connections
 * or conferences with which this connection can be conferenced.
 *
 * @param conferenceables The conferenceables.
 */

public final void setConferenceables(java.util.List<android.telecom.Conferenceable> conferenceables) { throw new RuntimeException("Stub!"); }

/**
 * Returns the connections or conferences with which this connection can be conferenced.
 */

public final java.util.List<android.telecom.Conferenceable> getConferenceables() { throw new RuntimeException("Stub!"); }

/**
 * Set some extras that can be associated with this {@code Connection}.
 * <p>
 * New or existing keys are replaced in the {@code Connection} extras.  Keys which are no longer
 * in the new extras, but were present the last time {@code setExtras} was called are removed.
 * <p>
 * Alternatively you may use the {@link #putExtras(Bundle)}, and
 * {@link #removeExtras(String...)} methods to modify the extras.
 * <p>
 * No assumptions should be made as to how an In-Call UI or service will handle these extras.
 * Keys should be fully qualified (e.g., com.example.MY_EXTRA) to avoid conflicts.
 *
 * @param extras The extras associated with this {@code Connection}.

 * This value may be {@code null}.
 */

public final void setExtras(@androidx.annotation.RecentlyNullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Adds some extras to this {@code Connection}.  Existing keys are replaced and new ones are
 * added.
 * <p>
 * No assumptions should be made as to how an In-Call UI or service will handle these extras.
 * Keys should be fully qualified (e.g., com.example.MY_EXTRA) to avoid conflicts.
 *
 * @param extras The extras to add.

 * This value must never be {@code null}.
 */

public final void putExtras(@androidx.annotation.RecentlyNonNull android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Removes extras from this {@code Connection}.
 *
 * @param keys The keys of the extras to remove.
 */

public final void removeExtras(java.util.List<java.lang.String> keys) { throw new RuntimeException("Stub!"); }

/**
 * Removes extras from this {@code Connection}.
 *
 * @param keys The keys of the extras to remove.
 */

public final void removeExtras(java.lang.String... keys) { throw new RuntimeException("Stub!"); }

/**
 * Sets the audio route (speaker, bluetooth, etc...).  When this request is honored, there will
 * be change to the {@link #getCallAudioState()}.
 * <p>
 * Used by self-managed {@link ConnectionService}s which wish to change the audio route for a
 * self-managed {@link Connection} (see {@link PhoneAccount#CAPABILITY_SELF_MANAGED}.)
 * <p>
 * See also {@link InCallService#setAudioRoute(int)}.
 *
 * @param route The audio route to use (one of {@link CallAudioState#ROUTE_BLUETOOTH},
 *              {@link CallAudioState#ROUTE_EARPIECE}, {@link CallAudioState#ROUTE_SPEAKER}, or
 *              {@link CallAudioState#ROUTE_WIRED_HEADSET}).
 */

public final void setAudioRoute(int route) { throw new RuntimeException("Stub!"); }

/**
 * Request audio routing to a specific bluetooth device. Calling this method may result in
 * the device routing audio to a different bluetooth device than the one specified if the
 * bluetooth stack is unable to route audio to the requested device.
 * A list of available devices can be obtained via
 * {@link CallAudioState#getSupportedBluetoothDevices()}
 *
 * <p>
 * Used by self-managed {@link ConnectionService}s which wish to use bluetooth audio for a
 * self-managed {@link Connection} (see {@link PhoneAccount#CAPABILITY_SELF_MANAGED}.)
 * <p>
 * See also {@link InCallService#requestBluetoothAudio(BluetoothDevice)}
 * @param bluetoothDevice The bluetooth device to connect to.

 * This value must never be {@code null}.
 */

public void requestBluetoothAudio(@androidx.annotation.RecentlyNonNull android.bluetooth.BluetoothDevice bluetoothDevice) { throw new RuntimeException("Stub!"); }

/**
 * Informs listeners that a previously requested RTT session via
 * {@link ConnectionRequest#isRequestingRtt()} or
 * {@link #onStartRtt(RttTextStream)} has succeeded.
 */

public final void sendRttInitiationSuccess() { throw new RuntimeException("Stub!"); }

/**
 * Informs listeners that a previously requested RTT session via
 * {@link ConnectionRequest#isRequestingRtt()} or {@link #onStartRtt(RttTextStream)}
 * has failed.
 * @param reason One of the reason codes defined in {@link RttModifyStatus}, with the
 *               exception of {@link RttModifyStatus#SESSION_MODIFY_REQUEST_SUCCESS}.
 */

public final void sendRttInitiationFailure(int reason) { throw new RuntimeException("Stub!"); }

/**
 * Informs listeners that a currently active RTT session has been terminated by the remote
 * side of the coll.
 */

public final void sendRttSessionRemotelyTerminated() { throw new RuntimeException("Stub!"); }

/**
 * Informs listeners that the remote side of the call has requested an upgrade to include an
 * RTT session in the call.
 */

public final void sendRemoteRttRequest() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection that the {@link #getCallAudioState()} property has a new value.
 *
 * @param state The new connection audio state.
 */

public void onCallAudioStateChanged(android.telecom.CallAudioState state) { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection of an internal state change. This method is called after the
 * state is changed.
 *
 * @param state The new state, one of the {@code STATE_*} constants.
 */

public void onStateChanged(int state) { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection of a request to play a DTMF tone.
 *
 * @param c A DTMF character.
 */

public void onPlayDtmfTone(char c) { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection of a request to stop any currently playing DTMF tones.
 */

public void onStopDtmfTone() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection of a request to disconnect.
 */

public void onDisconnect() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection of a request to separate from its parent conference.
 */

public void onSeparate() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection of a request to abort.
 */

public void onAbort() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection of a request to hold.
 */

public void onHold() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection of a request to exit a hold state.
 */

public void onUnhold() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection, which is in {@link #STATE_RINGING}, of
 * a request to accept.
 * <p>
 * For managed {@link ConnectionService}s, this will be called when the user answers a call via
 * the default dialer's {@link InCallService}.
 * <p>
 * Although a self-managed {@link ConnectionService} provides its own incoming call UI, the
 * Telecom framework may request that the call is answered in the following circumstances:
 * <ul>
 *     <li>The user chooses to answer an incoming call via a Bluetooth device.</li>
 *     <li>A car mode {@link InCallService} is in use which has declared
 *     {@link TelecomManager#METADATA_INCLUDE_SELF_MANAGED_CALLS} in its manifest.  Such an
 *     {@link InCallService} will be able to see calls from self-managed
 *     {@link ConnectionService}s, and will be able to display an incoming call UI on their
 *     behalf.</li>
 * </ul>
 * @param videoState The video state in which to answer the connection.
 */

public void onAnswer(int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection, which is in {@link #STATE_RINGING}, of
 * a request to accept.
 * <p>
 * For managed {@link ConnectionService}s, this will be called when the user answers a call via
 * the default dialer's {@link InCallService}.
 * <p>
 * Although a self-managed {@link ConnectionService} provides its own incoming call UI, the
 * Telecom framework may request that the call is answered in the following circumstances:
 * <ul>
 *     <li>The user chooses to answer an incoming call via a Bluetooth device.</li>
 *     <li>A car mode {@link InCallService} is in use which has declared
 *     {@link TelecomManager#METADATA_INCLUDE_SELF_MANAGED_CALLS} in its manifest.  Such an
 *     {@link InCallService} will be able to see calls from self-managed
 *     {@link ConnectionService}s, and will be able to display an incoming call UI on their
 *     behalf.</li>
 * </ul>
 */

public void onAnswer() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection, which is in {@link #STATE_RINGING}, of
 * a request to deflect.
 */

public void onDeflect(android.net.Uri address) { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection, which is in {@link #STATE_RINGING}, of
 * a request to reject.
 * <p>
 * For managed {@link ConnectionService}s, this will be called when the user rejects a call via
 * the default dialer's {@link InCallService}.
 * <p>
 * Although a self-managed {@link ConnectionService} provides its own incoming call UI, the
 * Telecom framework may request that the call is rejected in the following circumstances:
 * <ul>
 *     <li>The user chooses to reject an incoming call via a Bluetooth device.</li>
 *     <li>A car mode {@link InCallService} is in use which has declared
 *     {@link TelecomManager#METADATA_INCLUDE_SELF_MANAGED_CALLS} in its manifest.  Such an
 *     {@link InCallService} will be able to see calls from self-managed
 *     {@link ConnectionService}s, and will be able to display an incoming call UI on their
 *     behalf.</li>
 * </ul>
 */

public void onReject() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection, which is in {@link #STATE_RINGING}, of
 * a request to reject with a message.
 */

public void onReject(java.lang.String replyMessage) { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection whether the user wishes to proceed with the post-dial DTMF codes.
 */

public void onPostDialContinue(boolean proceed) { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection of a request to pull an external call to the local device.
 * <p>
 * The {@link InCallService} issues a request to pull an external call to the local device via
 * {@link Call#pullExternalCall()}.
 * <p>
 * For a Connection to be pulled, both the {@link Connection#CAPABILITY_CAN_PULL_CALL}
 * capability and {@link Connection#PROPERTY_IS_EXTERNAL_CALL} property bits must be set.
 * <p>
 * For more information on external calls, see {@link Connection#PROPERTY_IS_EXTERNAL_CALL}.
 */

public void onPullExternalCall() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this Connection of a {@link Call} event initiated from an {@link InCallService}.
 * <p>
 * The {@link InCallService} issues a Call event via {@link Call#sendCallEvent(String, Bundle)}.
 * <p>
 * Where possible, the Connection should make an attempt to handle {@link Call} events which
 * are part of the {@code android.telecom.*} namespace.  The Connection should ignore any events
 * it does not wish to handle.  Unexpected events should be handled gracefully, as it is
 * possible that a {@link InCallService} has defined its own Call events which a Connection is
 * not aware of.
 * <p>
 * See also {@link Call#sendCallEvent(String, Bundle)}.
 *
 * @param event The call event.
 * @param extras Extras associated with the call event.
 */

public void onCallEvent(java.lang.String event, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Notifies this {@link Connection} that a handover has completed.
 * <p>
 * A handover is initiated with {@link android.telecom.Call#handoverTo(PhoneAccountHandle, int,
 * Bundle)} on the initiating side of the handover, and
 * {@link TelecomManager#acceptHandover(Uri, int, PhoneAccountHandle)}.
 */

public void onHandoverComplete() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this {@link Connection} of a change to the extras made outside the
 * {@link ConnectionService}.
 * <p>
 * These extras changes can originate from Telecom itself, or from an {@link InCallService} via
 * the {@link android.telecom.Call#putExtras(Bundle)} and
 * {@link Call#removeExtras(List)}.
 *
 * @param extras The new extras bundle.
 */

public void onExtrasChanged(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Notifies this {@link Connection} that its {@link ConnectionService} is responsible for
 * displaying its incoming call user interface for the {@link Connection}.
 * <p>
 * Will only be called for incoming calls added via a self-managed {@link ConnectionService}
 * (see {@link PhoneAccount#CAPABILITY_SELF_MANAGED}), where the {@link ConnectionService}
 * should show its own incoming call user interface.
 * <p>
 * Where there are ongoing calls in other self-managed {@link ConnectionService}s, or in a
 * regular {@link ConnectionService}, and it is not possible to hold these other calls, the
 * Telecom framework will display its own incoming call user interface to allow the user to
 * choose whether to answer the new incoming call and disconnect other ongoing calls, or to
 * reject the new incoming call.
 * <p>
 * You should trigger the display of the incoming call user interface for your application by
 * showing a {@link Notification} with a full-screen {@link Intent} specified.
 * For example:
 * <pre><code>
 *     // Create an intent which triggers your fullscreen incoming call user interface.
 *     Intent intent = new Intent(Intent.ACTION_MAIN, null);
 *     intent.setFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION | Intent.FLAG_ACTIVITY_NEW_TASK);
 *     intent.setClass(context, YourIncomingCallActivity.class);
 *     PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent, 0);
 *
 *     // Build the notification as an ongoing high priority item; this ensures it will show as
 *     // a heads up notification which slides down over top of the current content.
 *     final Notification.Builder builder = new Notification.Builder(context);
 *     builder.setOngoing(true);
 *     builder.setPriority(Notification.PRIORITY_HIGH);
 *
 *     // Set notification content intent to take user to fullscreen UI if user taps on the
 *     // notification body.
 *     builder.setContentIntent(pendingIntent);
 *     // Set full screen intent to trigger display of the fullscreen UI when the notification
 *     // manager deems it appropriate.
 *     builder.setFullScreenIntent(pendingIntent, true);
 *
 *     // Setup notification content.
 *     builder.setSmallIcon( yourIconResourceId );
 *     builder.setContentTitle("Your notification title");
 *     builder.setContentText("Your notification content.");
 *
 *     // Use builder.addAction(..) to add buttons to answer or reject the call.
 *
 *     NotificationManager notificationManager = mContext.getSystemService(
 *         NotificationManager.class);
 *     notificationManager.notify(YOUR_TAG, YOUR_ID, builder.build());
 * </code></pre>
 */

public void onShowIncomingCallUi() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this {@link Connection} that the user has requested an RTT session.
 * The connection service should call {@link #sendRttInitiationSuccess} or
 * {@link #sendRttInitiationFailure} to inform Telecom of the success or failure of the
 * request, respectively.
 * @param rttTextStream The object that should be used to send text to or receive text from
 *                      the in-call app.

 * This value must never be {@code null}.
 */

public void onStartRtt(@androidx.annotation.RecentlyNonNull android.telecom.Connection.RttTextStream rttTextStream) { throw new RuntimeException("Stub!"); }

/**
 * Notifies this {@link Connection} that it should terminate any existing RTT communication
 * channel. No response to Telecom is needed for this method.
 */

public void onStopRtt() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this connection of a response to a previous remotely-initiated RTT upgrade
 * request sent via {@link #sendRemoteRttRequest}. Acceptance of the request is
 * indicated by the supplied {@link RttTextStream} being non-null, and rejection is
 * indicated by {@code rttTextStream} being {@code null}
 * @param rttTextStream The object that should be used to send text to or receive text from
 *                      the in-call app.

 * This value may be {@code null}.
 */

public void handleRttUpgradeResponse(@androidx.annotation.RecentlyNullable android.telecom.Connection.RttTextStream rttTextStream) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@code Connection} which represents a failed connection attempt. The returned
 * {@code Connection} will have a {@link android.telecom.DisconnectCause} and as specified,
 * and a {@link #getState()} of {@link #STATE_DISCONNECTED}.
 * <p>
 * The returned {@code Connection} can be assumed to {@link #destroy()} itself when appropriate,
 * so users of this method need not maintain a reference to its return value to destroy it.
 *
 * @param disconnectCause The disconnect cause, ({@see android.telecomm.DisconnectCause}).
 * @return A {@code Connection} which indicates failure.
 */

public static android.telecom.Connection createFailedConnection(android.telecom.DisconnectCause disconnectCause) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@code Connection} which represents a canceled connection attempt. The returned
 * {@code Connection} will have state {@link #STATE_DISCONNECTED}, and cannot be moved out of
 * that state. This connection should not be used for anything, and no other
 * {@code Connection}s should be attempted.
 * <p>
 * so users of this method need not maintain a reference to its return value to destroy it.
 *
 * @return A {@code Connection} which indicates that the underlying connection should
 * be canceled.
 */

public static android.telecom.Connection createCanceledConnection() { throw new RuntimeException("Stub!"); }

/**
 * Sends an event associated with this {@code Connection} with associated event extras to the
 * {@link InCallService}.
 * <p>
 * Connection events are used to communicate point in time information from a
 * {@link ConnectionService} to a {@link InCallService} implementations.  An example of a
 * custom connection event includes notifying the UI when a WIFI call has been handed over to
 * LTE, which the InCall UI might use to inform the user that billing charges may apply.  The
 * Android Telephony framework will send the {@link #EVENT_CALL_MERGE_FAILED} connection event
 * when a call to {@link Call#mergeConference()} has failed to complete successfully.  A
 * connection event could also be used to trigger UI in the {@link InCallService} which prompts
 * the user to make a choice (e.g. whether they want to incur roaming costs for making a call),
 * which is communicated back via {@link Call#sendCallEvent(String, Bundle)}.
 * <p>
 * Events are exposed to {@link InCallService} implementations via
 * {@link Call.Callback#onConnectionEvent(Call, String, Bundle)}.
 * <p>
 * No assumptions should be made as to how an In-Call UI or service will handle these events.
 * The {@link ConnectionService} must assume that the In-Call UI could even chose to ignore
 * some events altogether.
 * <p>
 * Events should be fully qualified (e.g. {@code com.example.event.MY_EVENT}) to avoid
 * conflicts between {@link ConnectionService} implementations.  Further, custom
 * {@link ConnectionService} implementations shall not re-purpose events in the
 * {@code android.*} namespace, nor shall they define new event types in this namespace.  When
 * defining a custom event type, ensure the contents of the extras {@link Bundle} is clearly
 * defined.  Extra keys for this bundle should be named similar to the event type (e.g.
 * {@code com.example.extra.MY_EXTRA}).
 * <p>
 *  When defining events and the associated extras, it is important to keep their behavior
 * consistent when the associated {@link ConnectionService} is updated.  Support for deprecated
 * events/extras should me maintained to ensure backwards compatibility with older
 * {@link InCallService} implementations which were built to support the older behavior.
 *
 * @param event The connection event.
 * @param extras Optional bundle containing extra information associated with the event.
 */

public void sendConnectionEvent(java.lang.String event, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * When set, prevents a video call from being downgraded to an audio-only call.
 * <p>
 * Should be set when the VideoState has the {@link VideoProfile#STATE_TX_ENABLED} or
 * {@link VideoProfile#STATE_RX_ENABLED} bits set to indicate that the connection cannot be
 * downgraded from a video call back to a VideoState of
 * {@link VideoProfile#STATE_AUDIO_ONLY}.
 * <p>
 * Intuitively, a call which can be downgraded to audio should also have local and remote
 * video
 * capabilities (see {@link #CAPABILITY_SUPPORTS_VT_LOCAL_BIDIRECTIONAL} and
 * {@link #CAPABILITY_SUPPORTS_VT_REMOTE_BIDIRECTIONAL}).
 */

public static final int CAPABILITY_CANNOT_DOWNGRADE_VIDEO_TO_AUDIO = 8388608; // 0x800000

/**
 * For video calls, indicates whether the outgoing video for the call can be paused using
 * the {@link android.telecom.VideoProfile#STATE_PAUSED} VideoState.
 */

public static final int CAPABILITY_CAN_PAUSE_VIDEO = 1048576; // 0x100000

/**
 * When set for an external connection, indicates that this {@code Connection} can be pulled
 * from a remote device to the current device.
 * <p>
 * Should only be set on a {@code Connection} where {@link #PROPERTY_IS_EXTERNAL_CALL}
 * is set.
 */

public static final int CAPABILITY_CAN_PULL_CALL = 16777216; // 0x1000000

/**
 * Indicates that the connection itself wants to handle any sort of reply response, rather than
 * relying on SMS.
 */

public static final int CAPABILITY_CAN_SEND_RESPONSE_VIA_CONNECTION = 4194304; // 0x400000

/**
 * Call can be upgraded to a video call.
 */

public static final int CAPABILITY_CAN_UPGRADE_TO_VIDEO = 524288; // 0x80000

/**
 * Connection is able to be individually disconnected when in a {@code Conference}.
 */

public static final int CAPABILITY_DISCONNECT_FROM_CONFERENCE = 8192; // 0x2000

/**
 * Connection can currently be put on hold or unheld. This is distinct from
 * {@link #CAPABILITY_SUPPORT_HOLD} in that although a connection may support 'hold' most times,
 * it does not at the moment support the function. This can be true while the call is in the
 * state {@link #STATE_DIALING}, for example. During this condition, an in-call UI may
 * display a disabled 'hold' button.
 */

public static final int CAPABILITY_HOLD = 1; // 0x1

/**
 * Connection supports conference management. This capability only applies to
 * {@link Conference}s which can have {@link Connection}s as children.
 */

public static final int CAPABILITY_MANAGE_CONFERENCE = 128; // 0x80

/**
 * Connections within a conference can be merged. A {@link ConnectionService} has the option to
 * add a {@link Conference} before the child {@link Connection}s are merged. This is how
 * CDMA-based {@link Connection}s are implemented. For these unmerged {@link Conference}s, this
 * capability allows a merge button to be shown while the conference is in the foreground
 * of the in-call UI.
 * <p>
 * This is only intended for use by a {@link Conference}.
 */

public static final int CAPABILITY_MERGE_CONFERENCE = 4; // 0x4

/** Connection can be muted. */

public static final int CAPABILITY_MUTE = 64; // 0x40

/** Connection supports responding via text option. */

public static final int CAPABILITY_RESPOND_VIA_TEXT = 32; // 0x20

/**
 * Connection is able to be separated from its parent {@code Conference}, if any.
 */

public static final int CAPABILITY_SEPARATE_FROM_CONFERENCE = 4096; // 0x1000

/**
 * Local device supports bidirectional video calling.
 */

public static final int CAPABILITY_SUPPORTS_VT_LOCAL_BIDIRECTIONAL = 768; // 0x300

/**
 * Local device supports receiving video.
 */

public static final int CAPABILITY_SUPPORTS_VT_LOCAL_RX = 256; // 0x100

/**
 * Local device supports transmitting video.
 */

public static final int CAPABILITY_SUPPORTS_VT_LOCAL_TX = 512; // 0x200

/**
 * Remote device supports bidirectional video calling.
 */

public static final int CAPABILITY_SUPPORTS_VT_REMOTE_BIDIRECTIONAL = 3072; // 0xc00

/**
 * Remote device supports receiving video.
 */

public static final int CAPABILITY_SUPPORTS_VT_REMOTE_RX = 1024; // 0x400

/**
 * Remote device supports transmitting video.
 */

public static final int CAPABILITY_SUPPORTS_VT_REMOTE_TX = 2048; // 0x800

/** Call supports the deflect feature. */

public static final int CAPABILITY_SUPPORT_DEFLECT = 33554432; // 0x2000000

/** Connection supports the hold feature. */

public static final int CAPABILITY_SUPPORT_HOLD = 2; // 0x2

/**
 * Connections within a conference can be swapped between foreground and background.
 * See {@link #CAPABILITY_MERGE_CONFERENCE} for additional information.
 * <p>
 * This is only intended for use by a {@link Conference}.
 */

public static final int CAPABILITY_SWAP_CONFERENCE = 8; // 0x8

/**
 * Connection event used to inform {@link InCallService}s when the merging of two calls has
 * failed. The User Interface should use this message to inform the user of the error.
 * <p>
 * Sent via {@link #sendConnectionEvent(String, Bundle)}.  The {@link Bundle} parameter is
 * expected to be null when this connection event is used.
 */

public static final java.lang.String EVENT_CALL_MERGE_FAILED = "android.telecom.event.CALL_MERGE_FAILED";

/**
 * Connection event used to inform {@link InCallService}s when pulling of an external call has
 * failed.  The user interface should inform the user of the error.
 * <p>
 * Expected to be used by the {@link ConnectionService} when the {@link Call#pullExternalCall()}
 * API is called on a {@link Call} with the properties
 * {@link Call.Details#PROPERTY_IS_EXTERNAL_CALL} and
 * {@link Call.Details#CAPABILITY_CAN_PULL_CALL}, but the {@link ConnectionService} could not
 * pull the external call due to an error condition.
 * <p>
 * Sent via {@link #sendConnectionEvent(String, Bundle)}.  The {@link Bundle} parameter is
 * expected to be null when this connection event is used.
 */

public static final java.lang.String EVENT_CALL_PULL_FAILED = "android.telecom.event.CALL_PULL_FAILED";

/**
 * Boolean connection extra key set on a {@link Connection} in
 * {@link Connection#STATE_RINGING} state to indicate that answering the call will cause the
 * current active foreground call to be dropped.
 */

public static final java.lang.String EXTRA_ANSWERING_DROPS_FG_CALL = "android.telecom.extra.ANSWERING_DROPS_FG_CALL";

/**
 * String connection extra key set on a {@link Connection} in {@link Connection#STATE_RINGING}
 * state to indicate the name of the third-party app which is responsible for the current
 * foreground call.
 * <p>
 * Used when {@link #EXTRA_ANSWERING_DROPS_FG_CALL} is true to ensure that the default Phone app
 * is able to inform the user that answering the new incoming call will cause a call owned by
 * another app to be dropped when the incoming call is answered.
 */

public static final java.lang.String EXTRA_ANSWERING_DROPS_FG_CALL_APP_NAME = "android.telecom.extra.ANSWERING_DROPS_FG_CALL_APP_NAME";

/**
 * Connection extra key used to store the subject for an incoming call.  The user interface can
 * query this extra and display its contents for incoming calls.  Will only be used if the
 * {@link PhoneAccount} supports the capability {@link PhoneAccount#CAPABILITY_CALL_SUBJECT}.
 */

public static final java.lang.String EXTRA_CALL_SUBJECT = "android.telecom.extra.CALL_SUBJECT";

/**
 * Connection extra key used to store a child number associated with the current connection.
 * Used to communicate to the user interface that the connection was received via
 * a child address (i.e. phone number) associated with the {@link PhoneAccount}'s primary
 * address.
 */

public static final java.lang.String EXTRA_CHILD_ADDRESS = "android.telecom.extra.CHILD_ADDRESS";

/**
 * Connection extra key used to store the last forwarded number associated with the current
 * connection.  Used to communicate to the user interface that the connection was forwarded via
 * the specified number.
 */

public static final java.lang.String EXTRA_LAST_FORWARDED_NUMBER = "android.telecom.extra.LAST_FORWARDED_NUMBER";

/**
 * Indicates that the connection has CDMA Enhanced Voice Privacy enabled.
 */

public static final int PROPERTY_HAS_CDMA_VOICE_PRIVACY = 32; // 0x20

/**
 * When set, indicates that the {@code Connection} does not actually exist locally for the
 * {@link ConnectionService}.
 * <p>
 * Consider, for example, a scenario where a user has two devices with the same phone number.
 * When a user places a call on one devices, the telephony stack can represent that call on the
 * other device by adding is to the {@link ConnectionService} with the
 * {@link #PROPERTY_IS_EXTERNAL_CALL} capability set.
 * <p>
 * An {@link ConnectionService} should not assume that all {@link InCallService}s will handle
 * external connections.  Only those {@link InCallService}s which have the
 * {@link TelecomManager#METADATA_INCLUDE_EXTERNAL_CALLS} metadata set to {@code true} in its
 * manifest will see external connections.
 */

public static final int PROPERTY_IS_EXTERNAL_CALL = 16; // 0x10

/**
 * Set by the framework to indicate that a connection has an active RTT session associated with
 * it.
 */

public static final int PROPERTY_IS_RTT = 256; // 0x100

/**
 * Set by the framework to indicate that the {@link Connection} originated from a self-managed
 * {@link ConnectionService}.
 * <p>
 * See {@link PhoneAccount#CAPABILITY_SELF_MANAGED}.
 */

public static final int PROPERTY_SELF_MANAGED = 128; // 0x80

/**
 * A connection is active. Both parties are connected to the call and can actively communicate.
 */

public static final int STATE_ACTIVE = 4; // 0x4

/**
 * An outgoing connection is in the dialing state. In this state the other party has not yet
 * answered the call and the user traditionally hears a ringback tone.
 */

public static final int STATE_DIALING = 3; // 0x3

/**
 * A connection has been disconnected. This is the final state once the user has been
 * disconnected from a call either locally, remotely or by an error in the service.
 */

public static final int STATE_DISCONNECTED = 6; // 0x6

/**
 * A connection is on hold.
 */

public static final int STATE_HOLDING = 5; // 0x5

/**
 * The connection is initializing. This is generally the first state for a {@code Connection}
 * returned by a {@link ConnectionService}.
 */

public static final int STATE_INITIALIZING = 0; // 0x0

/**
 * The connection is new and not connected.
 */

public static final int STATE_NEW = 1; // 0x1

/**
 * The state of an external connection which is in the process of being pulled from a remote
 * device to the local device.
 * <p>
 * A connection can only be in this state if the {@link #PROPERTY_IS_EXTERNAL_CALL} property and
 * {@link #CAPABILITY_CAN_PULL_CALL} capability bits are set on the connection.
 */

public static final int STATE_PULLING_CALL = 7; // 0x7

/**
 * An incoming connection is in the ringing state. During this state, the user's ringer or
 * vibration feature will be activated.
 */

public static final int STATE_RINGING = 2; // 0x2
/**
 * Provides constants to represent the results of responses to session modify requests sent via
 * {@link Call#sendRttRequest()}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class RttModifyStatus {

RttModifyStatus() { throw new RuntimeException("Stub!"); }

/**
 * Session modify request failed.
 */

public static final int SESSION_MODIFY_REQUEST_FAIL = 2; // 0x2

/**
 * Session modify request ignored due to invalid parameters.
 */

public static final int SESSION_MODIFY_REQUEST_INVALID = 3; // 0x3

/**
 * Session modify request rejected by remote user.
 */

public static final int SESSION_MODIFY_REQUEST_REJECTED_BY_REMOTE = 5; // 0x5

/**
 * Session modify request was successful.
 */

public static final int SESSION_MODIFY_REQUEST_SUCCESS = 1; // 0x1

/**
 * Session modify request timed out.
 */

public static final int SESSION_MODIFY_REQUEST_TIMED_OUT = 4; // 0x4
}

/**
 * Provides methods to read and write RTT data to/from the in-call app.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class RttTextStream {

/**
 * @hide
 */

RttTextStream(android.os.ParcelFileDescriptor toInCall, android.os.ParcelFileDescriptor fromInCall) { throw new RuntimeException("Stub!"); }

/**
 * Writes the string {@param input} into the text stream to the UI for this RTT call. Since
 * RTT transmits text in real-time, this method should be called as often as text snippets
 * are received from the remote user, even if it is only one character.
 * <p>
 * This method is not thread-safe -- calling it from multiple threads simultaneously may
 * lead to interleaved text.
 *
 * @param input The message to send to the in-call app.
 */

public void write(java.lang.String input) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads a string from the in-call app, blocking if there is no data available. Returns
 * {@code null} if the RTT conversation has been terminated and there is no further data
 * to read.
 * <p>
 * This method is not thread-safe -- calling it from multiple threads simultaneously may
 * lead to interleaved text.
 *
 * @return A string containing text entered by the user, or {@code null} if the
 * conversation has been terminated or if there was an error while reading.
 */

public java.lang.String read() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Non-blocking version of {@link #read()}. Returns {@code null} if there is nothing to
 * be read.
 *
 * @return A string containing text entered by the user, or {@code null} if the user has
 * not entered any new text yet.
 */

public java.lang.String readImmediately() throws java.io.IOException { throw new RuntimeException("Stub!"); }
}

/**
 * Provides a means of controlling the video session associated with a {@link Connection}.
 * <p>
 * Implementations create a custom subclass of {@link VideoProvider} and the
 * {@link ConnectionService} creates an instance sets it on the {@link Connection} using
 * {@link Connection#setVideoProvider(VideoProvider)}.  Any connection which supports video
 * should set the {@link VideoProvider}.
 * <p>
 * The {@link VideoProvider} serves two primary purposes: it provides a means for Telecom and
 * {@link InCallService} implementations to issue requests related to the video session;
 * it provides a means for the {@link ConnectionService} to report events and information
 * related to the video session to Telecom and the {@link InCallService} implementations.
 * <p>
 * {@link InCallService} implementations interact with the {@link VideoProvider} via
 * {@link android.telecom.InCallService.VideoCall}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class VideoProvider {

public VideoProvider() { throw new RuntimeException("Stub!"); }

/**
 * Sets the camera to be used for the outgoing video.
 * <p>
 * The {@link VideoProvider} should respond by communicating the capabilities of the chosen
 * camera via
 * {@link VideoProvider#changeCameraCapabilities(VideoProfile.CameraCapabilities)}.
 * <p>
 * Sent from the {@link InCallService} via
 * {@link InCallService.VideoCall#setCamera(String)}.
 *
 * @param cameraId The id of the camera (use ids as reported by
 * {@link CameraManager#getCameraIdList()}).
 */

public abstract void onSetCamera(java.lang.String cameraId);

/**
 * Sets the surface to be used for displaying a preview of what the user's camera is
 * currently capturing.  When video transmission is enabled, this is the video signal which
 * is sent to the remote device.
 * <p>
 * Sent from the {@link InCallService} via
 * {@link InCallService.VideoCall#setPreviewSurface(Surface)}.
 *
 * @param surface The {@link Surface}.
 */

public abstract void onSetPreviewSurface(android.view.Surface surface);

/**
 * Sets the surface to be used for displaying the video received from the remote device.
 * <p>
 * Sent from the {@link InCallService} via
 * {@link InCallService.VideoCall#setDisplaySurface(Surface)}.
 *
 * @param surface The {@link Surface}.
 */

public abstract void onSetDisplaySurface(android.view.Surface surface);

/**
 * Sets the device orientation, in degrees.  Assumes that a standard portrait orientation of
 * the device is 0 degrees.
 * <p>
 * Sent from the {@link InCallService} via
 * {@link InCallService.VideoCall#setDeviceOrientation(int)}.
 *
 * @param rotation The device orientation, in degrees.
 */

public abstract void onSetDeviceOrientation(int rotation);

/**
 * Sets camera zoom ratio.
 * <p>
 * Sent from the {@link InCallService} via {@link InCallService.VideoCall#setZoom(float)}.
 *
 * @param value The camera zoom ratio.
 */

public abstract void onSetZoom(float value);

/**
 * Issues a request to modify the properties of the current video session.
 * <p>
 * Example scenarios include: requesting an audio-only call to be upgraded to a
 * bi-directional video call, turning on or off the user's camera, sending a pause signal
 * when the {@link InCallService} is no longer the foreground application.
 * <p>
 * If the {@link VideoProvider} determines a request to be invalid, it should call
 * {@link #receiveSessionModifyResponse(int, VideoProfile, VideoProfile)} to report the
 * invalid request back to the {@link InCallService}.
 * <p>
 * Where a request requires confirmation from the user of the peer device, the
 * {@link VideoProvider} must communicate the request to the peer device and handle the
 * user's response.  {@link #receiveSessionModifyResponse(int, VideoProfile, VideoProfile)}
 * is used to inform the {@link InCallService} of the result of the request.
 * <p>
 * Sent from the {@link InCallService} via
 * {@link InCallService.VideoCall#sendSessionModifyRequest(VideoProfile)}.
 *
 * @param fromProfile The video profile prior to the request.
 * @param toProfile The video profile with the requested changes made.
 */

public abstract void onSendSessionModifyRequest(android.telecom.VideoProfile fromProfile, android.telecom.VideoProfile toProfile);

/**
 * Provides a response to a request to change the current video session properties.
 * <p>
 * For example, if the peer requests and upgrade from an audio-only call to a bi-directional
 * video call, could decline the request and keep the call as audio-only.
 * In such a scenario, the {@code responseProfile} would have a video state of
 * {@link VideoProfile#STATE_AUDIO_ONLY}.  If the user had decided to accept the request,
 * the video state would be {@link VideoProfile#STATE_BIDIRECTIONAL}.
 * <p>
 * Sent from the {@link InCallService} via
 * {@link InCallService.VideoCall#sendSessionModifyResponse(VideoProfile)} in response to
 * a {@link InCallService.VideoCall.Callback#onSessionModifyRequestReceived(VideoProfile)}
 * callback.
 *
 * @param responseProfile The response video profile.
 */

public abstract void onSendSessionModifyResponse(android.telecom.VideoProfile responseProfile);

/**
 * Issues a request to the {@link VideoProvider} to retrieve the camera capabilities.
 * <p>
 * The {@link VideoProvider} should respond by communicating the capabilities of the chosen
 * camera via
 * {@link VideoProvider#changeCameraCapabilities(VideoProfile.CameraCapabilities)}.
 * <p>
 * Sent from the {@link InCallService} via
 * {@link InCallService.VideoCall#requestCameraCapabilities()}.
 */

public abstract void onRequestCameraCapabilities();

/**
 * Issues a request to the {@link VideoProvider} to retrieve the current data usage for the
 * video component of the current {@link Connection}.
 * <p>
 * The {@link VideoProvider} should respond by communicating current data usage, in bytes,
 * via {@link VideoProvider#setCallDataUsage(long)}.
 * <p>
 * Sent from the {@link InCallService} via
 * {@link InCallService.VideoCall#requestCallDataUsage()}.
 */

public abstract void onRequestConnectionDataUsage();

/**
 * Provides the {@link VideoProvider} with the {@link Uri} of an image to be displayed to
 * the peer device when the video signal is paused.
 * <p>
 * Sent from the {@link InCallService} via
 * {@link InCallService.VideoCall#setPauseImage(Uri)}.
 *
 * @param uri URI of image to display.
 */

public abstract void onSetPauseImage(android.net.Uri uri);

/**
 * Used to inform listening {@link InCallService} implementations when the
 * {@link VideoProvider} receives a session modification request.
 * <p>
 * Received by the {@link InCallService} via
 * {@link InCallService.VideoCall.Callback#onSessionModifyRequestReceived(VideoProfile)},
 *
 * @param videoProfile The requested video profile.
 * @see #onSendSessionModifyRequest(VideoProfile, VideoProfile)
 */

public void receiveSessionModifyRequest(android.telecom.VideoProfile videoProfile) { throw new RuntimeException("Stub!"); }

/**
 * Used to inform listening {@link InCallService} implementations when the
 * {@link VideoProvider} receives a response to a session modification request.
 * <p>
 * Received by the {@link InCallService} via
 * {@link InCallService.VideoCall.Callback#onSessionModifyResponseReceived(int,
 * VideoProfile, VideoProfile)}.
 *
 * @param status Status of the session modify request.  Valid values are
 *               {@link VideoProvider#SESSION_MODIFY_REQUEST_SUCCESS},
 *               {@link VideoProvider#SESSION_MODIFY_REQUEST_FAIL},
 *               {@link VideoProvider#SESSION_MODIFY_REQUEST_INVALID},
 *               {@link VideoProvider#SESSION_MODIFY_REQUEST_TIMED_OUT},
 *               {@link VideoProvider#SESSION_MODIFY_REQUEST_REJECTED_BY_REMOTE}
 * @param requestedProfile The original request which was sent to the peer device.
 * @param responseProfile The actual profile changes agreed to by the peer device.
 * @see #onSendSessionModifyRequest(VideoProfile, VideoProfile)
 */

public void receiveSessionModifyResponse(int status, android.telecom.VideoProfile requestedProfile, android.telecom.VideoProfile responseProfile) { throw new RuntimeException("Stub!"); }

/**
 * Used to inform listening {@link InCallService} implementations when the
 * {@link VideoProvider} reports a call session event.
 * <p>
 * Received by the {@link InCallService} via
 * {@link InCallService.VideoCall.Callback#onCallSessionEvent(int)}.
 *
 * @param event The event.  Valid values are: {@link VideoProvider#SESSION_EVENT_RX_PAUSE},
 *      {@link VideoProvider#SESSION_EVENT_RX_RESUME},
 *      {@link VideoProvider#SESSION_EVENT_TX_START},
 *      {@link VideoProvider#SESSION_EVENT_TX_STOP},
 *      {@link VideoProvider#SESSION_EVENT_CAMERA_FAILURE},
 *      {@link VideoProvider#SESSION_EVENT_CAMERA_READY},
 *      {@link VideoProvider#SESSION_EVENT_CAMERA_FAILURE}.
 */

public void handleCallSessionEvent(int event) { throw new RuntimeException("Stub!"); }

/**
 * Used to inform listening {@link InCallService} implementations when the dimensions of the
 * peer's video have changed.
 * <p>
 * This could occur if, for example, the peer rotates their device, changing the aspect
 * ratio of the video, or if the user switches between the back and front cameras.
 * <p>
 * Received by the {@link InCallService} via
 * {@link InCallService.VideoCall.Callback#onPeerDimensionsChanged(int, int)}.
 *
 * @param width  The updated peer video width.
 * @param height The updated peer video height.
 */

public void changePeerDimensions(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Used to inform listening {@link InCallService} implementations when the data usage of the
 * video associated with the current {@link Connection} has changed.
 * <p>
 * This could be in response to a preview request via
 * {@link #onRequestConnectionDataUsage()}, or as a periodic update by the
 * {@link VideoProvider}.  Where periodic updates of data usage are provided, they should be
 * provided at most for every 1 MB of data transferred and no more than once every 10 sec.
 * <p>
 * Received by the {@link InCallService} via
 * {@link InCallService.VideoCall.Callback#onCallDataUsageChanged(long)}.
 *
 * @param dataUsage The updated data usage (in bytes).  Reported as the cumulative bytes
 *                  used since the start of the call.
 */

public void setCallDataUsage(long dataUsage) { throw new RuntimeException("Stub!"); }

/**
 * Used to inform listening {@link InCallService} implementations when the capabilities of
 * the current camera have changed.
 * <p>
 * The {@link VideoProvider} should call this in response to
 * {@link VideoProvider#onRequestCameraCapabilities()}, or when the current camera is
 * changed via {@link VideoProvider#onSetCamera(String)}.
 * <p>
 * Received by the {@link InCallService} via
 * {@link InCallService.VideoCall.Callback#onCameraCapabilitiesChanged(
 * VideoProfile.CameraCapabilities)}.
 *
 * @param cameraCapabilities The new camera capabilities.
 */

public void changeCameraCapabilities(android.telecom.VideoProfile.CameraCapabilities cameraCapabilities) { throw new RuntimeException("Stub!"); }

/**
 * Used to inform listening {@link InCallService} implementations when the video quality
 * of the call has changed.
 * <p>
 * Received by the {@link InCallService} via
 * {@link InCallService.VideoCall.Callback#onVideoQualityChanged(int)}.
 *
 * @param videoQuality The updated video quality.  Valid values:
 *      {@link VideoProfile#QUALITY_HIGH},
 *      {@link VideoProfile#QUALITY_MEDIUM},
 *      {@link VideoProfile#QUALITY_LOW},
 *      {@link VideoProfile#QUALITY_DEFAULT}.
 */

public void changeVideoQuality(int videoQuality) { throw new RuntimeException("Stub!"); }

/**
 * A camera failure has occurred for the selected camera.  The {@link VideoProvider} can use
 * this as a cue to inform the user the camera is not available.
 * @see #handleCallSessionEvent(int)
 */

public static final int SESSION_EVENT_CAMERA_FAILURE = 5; // 0x5

/**
 * Session event raised by Telecom when
 * {@link android.telecom.InCallService.VideoCall#setCamera(String)} is called and the
 * caller does not have the necessary {@link android.Manifest.permission#CAMERA} permission.
 * @see #handleCallSessionEvent(int)
 */

public static final int SESSION_EVENT_CAMERA_PERMISSION_ERROR = 7; // 0x7

/**
 * Issued after {@link #SESSION_EVENT_CAMERA_FAILURE} when the camera is once again ready
 * for operation.  The {@link VideoProvider} can use this as a cue to inform the user that
 * the camera has become available again.
 * @see #handleCallSessionEvent(int)
 */

public static final int SESSION_EVENT_CAMERA_READY = 6; // 0x6

/**
 * Video is not being received (no protocol pause was issued).
 * @see #handleCallSessionEvent(int)
 */

public static final int SESSION_EVENT_RX_PAUSE = 1; // 0x1

/**
 * Video reception has resumed after a {@link #SESSION_EVENT_RX_PAUSE}.
 * @see #handleCallSessionEvent(int)
 */

public static final int SESSION_EVENT_RX_RESUME = 2; // 0x2

/**
 * Video transmission has begun. This occurs after a negotiated start of video transmission
 * when the underlying protocol has actually begun transmitting video to the remote party.
 * @see #handleCallSessionEvent(int)
 */

public static final int SESSION_EVENT_TX_START = 3; // 0x3

/**
 * Video transmission has stopped. This occurs after a negotiated stop of video transmission
 * when the underlying protocol has actually stopped transmitting video to the remote party.
 * @see #handleCallSessionEvent(int)
 */

public static final int SESSION_EVENT_TX_STOP = 4; // 0x4

/**
 * Session modify request failed.
 * @see #receiveSessionModifyResponse(int, VideoProfile, VideoProfile)
 */

public static final int SESSION_MODIFY_REQUEST_FAIL = 2; // 0x2

/**
 * Session modify request ignored due to invalid parameters.
 * @see #receiveSessionModifyResponse(int, VideoProfile, VideoProfile)
 */

public static final int SESSION_MODIFY_REQUEST_INVALID = 3; // 0x3

/**
 * Session modify request rejected by remote user.
 * @see #receiveSessionModifyResponse(int, VideoProfile, VideoProfile)
 */

public static final int SESSION_MODIFY_REQUEST_REJECTED_BY_REMOTE = 5; // 0x5

/**
 * Session modify request was successful.
 * @see #receiveSessionModifyResponse(int, VideoProfile, VideoProfile)
 */

public static final int SESSION_MODIFY_REQUEST_SUCCESS = 1; // 0x1

/**
 * Session modify request timed out.
 * @see #receiveSessionModifyResponse(int, VideoProfile, VideoProfile)
 */

public static final int SESSION_MODIFY_REQUEST_TIMED_OUT = 4; // 0x4
}

}

