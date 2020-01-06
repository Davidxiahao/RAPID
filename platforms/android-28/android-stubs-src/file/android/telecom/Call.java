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

import java.lang.String;
import android.os.Bundle;
import android.net.Uri;
import java.util.List;

/**
 * Represents an ongoing phone call that the in-call app should present to the user.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Call {

Call() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the post-dial sequence remaining to be emitted by this {@code Call}, if any.
 *
 * @return The remaining post-dial sequence, or {@code null} if there is no post-dial sequence
 * remaining or this {@code Call} is not in a post-dial state.
 */

public java.lang.String getRemainingPostDialSequence() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@link #STATE_RINGING} {@code Call} to answer.
 * @param videoState The video state in which to answer the call.

 * Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 */

public void answer(int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@link #STATE_RINGING} {@code Call} to deflect.
 *
 * @param address The address to which the call will be deflected.
 */

public void deflect(android.net.Uri address) { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@link #STATE_RINGING} {@code Call} to reject.
 *
 * @param rejectWithMessage Whether to reject with a text message.
 * @param textMessage An optional text message with which to respond.
 */

public void reject(boolean rejectWithMessage, java.lang.String textMessage) { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code Call} to disconnect.
 */

public void disconnect() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code Call} to go on hold.
 */

public void hold() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@link #STATE_HOLDING} call to release from hold.
 */

public void unhold() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code Call} to play a dual-tone multi-frequency signaling (DTMF) tone.
 *
 * Any other currently playing DTMF tone in the specified call is immediately stopped.
 *
 * @param digit A character representing the DTMF digit for which to play the tone. This
 *         value must be one of {@code '0'} through {@code '9'}, {@code '*'} or {@code '#'}.
 */

public void playDtmfTone(char digit) { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code Call} to stop any dual-tone multi-frequency signaling (DTMF) tone
 * currently playing.
 *
 * DTMF tones are played by calling {@link #playDtmfTone(char)}. If no DTMF tone is
 * currently playing, this method will do nothing.
 */

public void stopDtmfTone() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code Call} to continue playing a post-dial DTMF string.
 *
 * A post-dial DTMF string is a string of digits entered after a phone number, when dialed,
 * that are immediately sent as DTMF tones to the recipient as soon as the connection is made.
 *
 * If the DTMF string contains a {@link TelecomManager#DTMF_CHARACTER_PAUSE} symbol, this
 * {@code Call} will temporarily pause playing the tones for a pre-defined period of time.
 *
 * If the DTMF string contains a {@link TelecomManager#DTMF_CHARACTER_WAIT} symbol, this
 * {@code Call} will pause playing the tones and notify callbacks via
 * {@link Callback#onPostDialWait(Call, String)}. At this point, the in-call app
 * should display to the user an indication of this state and an affordance to continue
 * the postdial sequence. When the user decides to continue the postdial sequence, the in-call
 * app should invoke the {@link #postDialContinue(boolean)} method.
 *
 * @param proceed Whether or not to continue with the post-dial sequence.
 */

public void postDialContinue(boolean proceed) { throw new RuntimeException("Stub!"); }

/**
 * Notifies this {@code Call} that an account has been selected and to proceed with placing
 * an outgoing call. Optionally sets this account as the default account.
 */

public void phoneAccountSelected(android.telecom.PhoneAccountHandle accountHandle, boolean setDefault) { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code Call} to enter a conference.
 *
 * @param callToConferenceWith The other call with which to conference.
 */

public void conference(android.telecom.Call callToConferenceWith) { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code Call} to split from any conference call with which it may be
 * connected.
 */

public void splitFromConference() { throw new RuntimeException("Stub!"); }

/**
 * Merges the calls within this conference. See {@link Details#CAPABILITY_MERGE_CONFERENCE}.
 */

public void mergeConference() { throw new RuntimeException("Stub!"); }

/**
 * Swaps the calls within this conference. See {@link Details#CAPABILITY_SWAP_CONFERENCE}.
 */

public void swapConference() { throw new RuntimeException("Stub!"); }

/**
 * Initiates a request to the {@link ConnectionService} to pull an external call to the local
 * device.
 * <p>
 * Calls to this method are ignored if the call does not have the
 * {@link Call.Details#PROPERTY_IS_EXTERNAL_CALL} property set.
 * <p>
 * An {@link InCallService} will only see calls which support this method if it has the
 * {@link TelecomManager#METADATA_INCLUDE_EXTERNAL_CALLS} metadata set to {@code true}
 * in its manifest.
 */

public void pullExternalCall() { throw new RuntimeException("Stub!"); }

/**
 * Sends a {@code Call} event from this {@code Call} to the associated {@link Connection} in
 * the {@link ConnectionService}.
 * <p>
 * Call events are used to communicate point in time information from an {@link InCallService}
 * to a {@link ConnectionService}.  A {@link ConnectionService} implementation could define
 * events which enable the {@link InCallService}, for example, toggle a unique feature of the
 * {@link ConnectionService}.
 * <p>
 * A {@link ConnectionService} can communicate to the {@link InCallService} using
 * {@link Connection#sendConnectionEvent(String, Bundle)}.
 * <p>
 * Events are exposed to {@link ConnectionService} implementations via
 * {@link android.telecom.Connection#onCallEvent(String, Bundle)}.
 * <p>
 * No assumptions should be made as to how a {@link ConnectionService} will handle these events.
 * The {@link InCallService} must assume that the {@link ConnectionService} could chose to
 * ignore some events altogether.
 * <p>
 * Events should be fully qualified (e.g., {@code com.example.event.MY_EVENT}) to avoid
 * conflicts between {@link InCallService} implementations.  Further, {@link InCallService}
 * implementations shall not re-purpose events in the {@code android.*} namespace, nor shall
 * they define their own event types in this namespace.  When defining a custom event type,
 * ensure the contents of the extras {@link Bundle} is clearly defined.  Extra keys for this
 * bundle should be named similar to the event type (e.g. {@code com.example.extra.MY_EXTRA}).
 * <p>
 * When defining events and the associated extras, it is important to keep their behavior
 * consistent when the associated {@link InCallService} is updated.  Support for deprecated
 * events/extras should me maintained to ensure backwards compatibility with older
 * {@link ConnectionService} implementations which were built to support the older behavior.
 *
 * @param event The connection event.
 * @param extras Bundle containing extra information associated with the event.
 */

public void sendCallEvent(java.lang.String event, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Sends an RTT upgrade request to the remote end of the connection. Success is not
 * guaranteed, and notification of success will be via the
 * {@link Callback#onRttStatusChanged(Call, boolean, RttCall)} callback.
 */

public void sendRttRequest() { throw new RuntimeException("Stub!"); }

/**
 * Responds to an RTT request received via the {@link Callback#onRttRequest(Call, int)} )}
 * callback.
 * The ID used here should be the same as the ID that was received via the callback.
 * @param id The request ID received via {@link Callback#onRttRequest(Call, int)}
 * @param accept {@code true} if the RTT request should be accepted, {@code false} otherwise.
 */

public void respondToRttRequest(int id, boolean accept) { throw new RuntimeException("Stub!"); }

/**
 * Initiates a handover of this {@link Call} to the {@link ConnectionService} identified
 * by {@code toHandle}.  The videoState specified indicates the desired video state after the
 * handover.
 * <p>
 * A call handover is the process where an ongoing call is transferred from one app (i.e.
 * {@link ConnectionService} to another app.  The user could, for example, choose to continue a
 * mobile network call in a video calling app.  The mobile network call via the Telephony stack
 * is referred to as the source of the handover, and the video calling app is referred to as the
 * destination.
 * <p>
 * When considering a handover scenario the device this method is called on is considered the
 * <em>initiating</em> device (since the user initiates the handover from this device), and the
 * other device is considered the <em>receiving</em> device.
 * <p>
 * When this method is called on the <em>initiating</em> device, the Telecom framework will bind
 * to the {@link ConnectionService} defined by the {@code toHandle} {@link PhoneAccountHandle}
 * and invoke
 * {@link ConnectionService#onCreateOutgoingHandoverConnection(PhoneAccountHandle,
 * ConnectionRequest)} to inform the destination app that a request has been made to handover a
 * call to it.  The app returns an instance of {@link Connection} to represent the handover call
 * At this point the app should display UI to indicate to the user that a call
 * handover is in process.
 * <p>
 * The destination app is responsible for communicating the handover request from the
 * <em>initiating</em> device to the <em>receiving</em> device.
 * <p>
 * When the app on the <em>receiving</em> device receives the handover request, it calls
 * {@link TelecomManager#acceptHandover(Uri, int, PhoneAccountHandle)} to continue the handover
 * process from the <em>initiating</em> device to the <em>receiving</em> device.  At this point
 * the destination app on the <em>receiving</em> device should show UI to allow the user to
 * choose whether they want to continue their call in the destination app.
 * <p>
 * When the destination app on the <em>receiving</em> device calls
 * {@link TelecomManager#acceptHandover(Uri, int, PhoneAccountHandle)}, Telecom will bind to its
 * {@link ConnectionService} and call
 * {@link ConnectionService#onCreateIncomingHandoverConnection(PhoneAccountHandle,
 * ConnectionRequest)} to inform it of the handover request.  The app returns an instance of
 * {@link Connection} to represent the handover call.
 * <p>
 * If the user of the <em>receiving</em> device accepts the handover, the app calls
 * {@link Connection#setActive()} to complete the handover process; Telecom will disconnect the
 * original call.  If the user rejects the handover, the app calls
 * {@link Connection#setDisconnected(DisconnectCause)} and specifies a {@link DisconnectCause}
 * of {@link DisconnectCause#CANCELED} to indicate that the handover has been cancelled.
 * <p>
 * Telecom will only allow handovers from {@link PhoneAccount}s which declare
 * {@link PhoneAccount#EXTRA_SUPPORTS_HANDOVER_FROM}.  Similarly, the {@link PhoneAccount}
 * specified by {@code toHandle} must declare {@link PhoneAccount#EXTRA_SUPPORTS_HANDOVER_TO}.
 * <p>
 * Errors in the handover process are reported to the {@link InCallService} via
 * {@link Callback#onHandoverFailed(Call, int)}.  Errors in the handover process are reported to
 * the involved {@link ConnectionService}s via
 * {@link ConnectionService#onHandoverFailed(ConnectionRequest, int)}.
 *
 * @param toHandle {@link PhoneAccountHandle} of the {@link ConnectionService} to handover
 *                 this call to.
 * @param videoState Indicates the video state desired after the handover (see the
 *               {@code STATE_*} constants defined in {@link VideoProfile}).
 * Value is either <code>0</code> or a combination of {@link android.telecom.VideoProfile#STATE_AUDIO_ONLY}, {@link android.telecom.VideoProfile#STATE_TX_ENABLED}, {@link android.telecom.VideoProfile#STATE_RX_ENABLED}, {@link android.telecom.VideoProfile#STATE_BIDIRECTIONAL}, and {@link android.telecom.VideoProfile#STATE_PAUSED}
 * @param extras Bundle containing extra information to be passed to the
 *               {@link ConnectionService}
 */

public void handoverTo(android.telecom.PhoneAccountHandle toHandle, int videoState, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Terminate the RTT session on this call. The resulting state change will be notified via
 * the {@link Callback#onRttStatusChanged(Call, boolean, RttCall)} callback.
 */

public void stopRtt() { throw new RuntimeException("Stub!"); }

/**
 * Adds some extras to this {@link Call}.  Existing keys are replaced and new ones are
 * added.
 * <p>
 * No assumptions should be made as to how an In-Call UI or service will handle these
 * extras.  Keys should be fully qualified (e.g., com.example.MY_EXTRA) to avoid conflicts.
 *
 * @param extras The extras to add.
 */

public void putExtras(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Removes extras from this {@link Call}.
 *
 * @param keys The keys of the extras to remove.
 */

public void removeExtras(java.util.List<java.lang.String> keys) { throw new RuntimeException("Stub!"); }

/**
 * Removes extras from this {@link Call}.
 *
 * @param keys The keys of the extras to remove.
 */

public void removeExtras(java.lang.String... keys) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the parent of this {@code Call} in a conference, if any.
 *
 * @return The parent {@code Call}, or {@code null} if this {@code Call} is not a
 * child of any conference {@code Call}s.
 */

public android.telecom.Call getParent() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the children of this conference {@code Call}, if any.
 *
 * @return The children of this {@code Call} if this {@code Call} is a conference, or an empty
 * {@code List} otherwise.
 */

public java.util.List<android.telecom.Call> getChildren() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of {@code Call}s with which this {@code Call} is allowed to conference.
 *
 * @return The list of conferenceable {@code Call}s.
 */

public java.util.List<android.telecom.Call> getConferenceableCalls() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the state of this {@code Call}.
 *
 * @return A state value, chosen from the {@code STATE_*} constants.
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Obtains a list of canned, pre-configured message responses to present to the user as
 * ways of rejecting this {@code Call} using via a text message.
 *
 * @see #reject(boolean, String)
 *
 * @return A list of canned text message responses.
 */

public java.util.List<java.lang.String> getCannedTextResponses() { throw new RuntimeException("Stub!"); }

/**
 * Obtains an object that can be used to display video from this {@code Call}.
 *
 * @return An {@code Call.VideoCall}.
 */

public android.telecom.InCallService.VideoCall getVideoCall() { throw new RuntimeException("Stub!"); }

/**
 * Obtains an object containing call details.
 *
 * @return A {@link Details} object. Depending on the state of the {@code Call}, the
 * result may be {@code null}.
 */

public android.telecom.Call.Details getDetails() { throw new RuntimeException("Stub!"); }

/**
 * Returns this call's RttCall object. The {@link RttCall} instance is used to send and
 * receive RTT text data, as well as to change the RTT mode.
 * @return A {@link Call.RttCall}. {@code null} if there is no active RTT connection.
 */

@androidx.annotation.RecentlyNullable public android.telecom.Call.RttCall getRttCall() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether this call has an active RTT connection.
 * @return true if there is a connection, false otherwise.
 */

public boolean isRttActive() { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback to this {@code Call}.
 *
 * @param callback A {@code Callback}.
 */

public void registerCallback(android.telecom.Call.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback to this {@code Call}.
 *
 * @param callback A {@code Callback}.
 * @param handler A handler which command and status changes will be delivered to.
 */

public void registerCallback(android.telecom.Call.Callback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a callback from this {@code Call}.
 *
 * @param callback A {@code Callback}.
 */

public void unregisterCallback(android.telecom.Call.Callback callback) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The key to retrieve the optional {@code PhoneAccount}s Telecom can bundle with its Call
 * extras. Used to pass the phone accounts to display on the front end to the user in order to
 * select phone accounts to (for example) place a call.
 */

public static final java.lang.String AVAILABLE_PHONE_ACCOUNTS = "selectPhoneAccountAccounts";

/**
 * Extra key used to indicate the time (in milliseconds since midnight, January 1, 1970 UTC)
 * when the last outgoing emergency call was made.  This is used to identify potential emergency
 * callbacks.
 */

public static final java.lang.String EXTRA_LAST_EMERGENCY_CALLBACK_TIME_MILLIS = "android.telecom.extra.LAST_EMERGENCY_CALLBACK_TIME_MILLIS";

/**
 * The state of a {@code Call} when actively supporting conversation.
 */

public static final int STATE_ACTIVE = 4; // 0x4

/**
 * The initial state of an outgoing {@code Call}.
 * Common transitions are to {@link #STATE_DIALING} state for a successful call or
 * {@link #STATE_DISCONNECTED} if it failed.
 */

public static final int STATE_CONNECTING = 9; // 0x9

/**
 * The state of an outgoing {@code Call} when dialing the remote number, but not yet connected.
 */

public static final int STATE_DIALING = 1; // 0x1

/**
 * The state of a {@code Call} when no further voice or other communication is being
 * transmitted, the remote side has been or will inevitably be informed that the {@code Call}
 * is no longer active, and the local data transport has or inevitably will release resources
 * associated with this {@code Call}.
 */

public static final int STATE_DISCONNECTED = 7; // 0x7

/**
 * The state of a {@code Call} when the user has initiated a disconnection of the call, but the
 * call has not yet been disconnected by the underlying {@code ConnectionService}.  The next
 * state of the call is (potentially) {@link #STATE_DISCONNECTED}.
 */

public static final int STATE_DISCONNECTING = 10; // 0xa

/**
 * The state of a {@code Call} when in a holding state.
 */

public static final int STATE_HOLDING = 3; // 0x3

/**
 * The state of a {@code Call} when newly created.
 */

public static final int STATE_NEW = 0; // 0x0

/**
 * The state of an external call which is in the process of being pulled from a remote device to
 * the local device.
 * <p>
 * A call can only be in this state if the {@link Details#PROPERTY_IS_EXTERNAL_CALL} property
 * and {@link Details#CAPABILITY_CAN_PULL_CALL} capability are set on the call.
 * <p>
 * An {@link InCallService} will only see this state if it has the
 * {@link TelecomManager#METADATA_INCLUDE_EXTERNAL_CALLS} metadata set to {@code true} in its
 * manifest.
 */

public static final int STATE_PULLING_CALL = 11; // 0xb

/**
 * The state of an incoming {@code Call} when ringing locally, but not yet connected.
 */

public static final int STATE_RINGING = 2; // 0x2

/**
 * The state of an outgoing {@code Call} when waiting on user to select a
 * {@link PhoneAccount} through which to place the call.
 */

public static final int STATE_SELECT_PHONE_ACCOUNT = 8; // 0x8
/**
 * Defines callbacks which inform the {@link InCallService} of changes to a {@link Call}.
 * These callbacks can originate from the Telecom framework, or a {@link ConnectionService}
 * implementation.
 * <p>
 * You can handle these callbacks by extending the {@link Callback} class and overriding the
 * callbacks that your {@link InCallService} is interested in.  The callback methods include the
 * {@link Call} for which the callback applies, allowing reuse of a single instance of your
 * {@link Callback} implementation, if desired.
 * <p>
 * Use {@link Call#registerCallback(Callback)} to register your callback(s).  Ensure
 * {@link Call#unregisterCallback(Callback)} is called when you no longer require callbacks
 * (typically in {@link InCallService#onCallRemoved(Call)}).
 * Note: Callbacks which occur before you call {@link Call#registerCallback(Callback)} will not
 * reach your implementation of {@link Callback}, so it is important to register your callback
 * as soon as your {@link InCallService} is notified of a new call via
 * {@link InCallService#onCallAdded(Call)}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the state of this {@code Call} has changed. See {@link #getState()}.
 *
 * @param call The {@code Call} invoking this method.
 * @param state The new state of the {@code Call}.
 */

public void onStateChanged(android.telecom.Call call, int state) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the parent of this {@code Call} has changed. See {@link #getParent()}.
 *
 * @param call The {@code Call} invoking this method.
 * @param parent The new parent of the {@code Call}.
 */

public void onParentChanged(android.telecom.Call call, android.telecom.Call parent) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the children of this {@code Call} have changed. See {@link #getChildren()}.
 *
 * @param call The {@code Call} invoking this method.
 * @param children The new children of the {@code Call}.
 */

public void onChildrenChanged(android.telecom.Call call, java.util.List<android.telecom.Call> children) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the details of this {@code Call} have changed. See {@link #getDetails()}.
 *
 * @param call The {@code Call} invoking this method.
 * @param details A {@code Details} object describing the {@code Call}.
 */

public void onDetailsChanged(android.telecom.Call call, android.telecom.Call.Details details) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the text messages that can be used as responses to the incoming
 * {@code Call} are loaded from the relevant database.
 * See {@link #getCannedTextResponses()}.
 *
 * @param call The {@code Call} invoking this method.
 * @param cannedTextResponses The text messages useable as responses.
 */

public void onCannedTextResponsesLoaded(android.telecom.Call call, java.util.List<java.lang.String> cannedTextResponses) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the post-dial sequence in the outgoing {@code Call} has reached a pause
 * character. This causes the post-dial signals to stop pending user confirmation. An
 * implementation should present this choice to the user and invoke
 * {@link #postDialContinue(boolean)} when the user makes the choice.
 *
 * @param call The {@code Call} invoking this method.
 * @param remainingPostDialSequence The post-dial characters that remain to be sent.
 */

public void onPostDialWait(android.telecom.Call call, java.lang.String remainingPostDialSequence) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the {@code Call.VideoCall} of the {@code Call} has changed.
 *
 * @param call The {@code Call} invoking this method.
 * @param videoCall The {@code Call.VideoCall} associated with the {@code Call}.
 */

public void onVideoCallChanged(android.telecom.Call call, android.telecom.InCallService.VideoCall videoCall) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the {@code Call} is destroyed. Clients should refrain from cleaning
 * up their UI for the {@code Call} in response to state transitions. Specifically,
 * clients should not assume that a {@link #onStateChanged(Call, int)} with a state of
 * {@link #STATE_DISCONNECTED} is the final notification the {@code Call} will send. Rather,
 * clients should wait for this method to be invoked.
 *
 * @param call The {@code Call} being destroyed.
 */

public void onCallDestroyed(android.telecom.Call call) { throw new RuntimeException("Stub!"); }

/**
 * Invoked upon changes to the set of {@code Call}s with which this {@code Call} can be
 * conferenced.
 *
 * @param call The {@code Call} being updated.
 * @param conferenceableCalls The {@code Call}s with which this {@code Call} can be
 *          conferenced.
 */

public void onConferenceableCallsChanged(android.telecom.Call call, java.util.List<android.telecom.Call> conferenceableCalls) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when a {@link Call} receives an event from its associated {@link Connection}.
 * <p>
 * Where possible, the Call should make an attempt to handle {@link Connection} events which
 * are part of the {@code android.telecom.*} namespace.  The Call should ignore any events
 * it does not wish to handle.  Unexpected events should be handled gracefully, as it is
 * possible that a {@link ConnectionService} has defined its own Connection events which a
 * Call is not aware of.
 * <p>
 * See {@link Connection#sendConnectionEvent(String, Bundle)}.
 *
 * @param call The {@code Call} receiving the event.
 * @param event The event.
 * @param extras Extras associated with the connection event.
 */

public void onConnectionEvent(android.telecom.Call call, java.lang.String event, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the RTT mode changes for this call.
 * @param call The call whose RTT mode has changed.
 * @param mode the new RTT mode, one of
 * {@link RttCall#RTT_MODE_FULL}, {@link RttCall#RTT_MODE_HCO},
 *             or {@link RttCall#RTT_MODE_VCO}
 */

public void onRttModeChanged(android.telecom.Call call, int mode) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the call's RTT status changes, either from off to on or from on to off.
 * @param call The call whose RTT status has changed.
 * @param enabled whether RTT is now enabled or disabled
 * @param rttCall the {@link RttCall} object to use for reading and writing if RTT is now
 *                on, null otherwise.
 */

public void onRttStatusChanged(android.telecom.Call call, boolean enabled, android.telecom.Call.RttCall rttCall) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the remote end of the connection has requested that an RTT communication
 * channel be opened. A response to this should be sent via {@link #respondToRttRequest}
 * with the same ID that this method is invoked with.
 * @param call The call which the RTT request was placed on
 * @param id The ID of the request.
 */

public void onRttRequest(android.telecom.Call call, int id) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the RTT session failed to initiate for some reason, including rejection
 * by the remote party.
 * @param call The call which the RTT initiation failure occurred on.
 * @param reason One of the status codes defined in
 *               {@link android.telecom.Connection.RttModifyStatus}, with the exception of
 *               {@link android.telecom.Connection.RttModifyStatus#SESSION_MODIFY_REQUEST_SUCCESS}.
 */

public void onRttInitiationFailure(android.telecom.Call call, int reason) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when Call handover from one {@link PhoneAccount} to other {@link PhoneAccount}
 * has completed successfully.
 * <p>
 * For a full discussion of the handover process and the APIs involved, see
 * {@link android.telecom.Call#handoverTo(PhoneAccountHandle, int, Bundle)}.
 *
 * @param call The call which had initiated handover.
 */

public void onHandoverComplete(android.telecom.Call call) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when Call handover from one {@link PhoneAccount} to other {@link PhoneAccount}
 * has failed.
 * <p>
 * For a full discussion of the handover process and the APIs involved, see
 * {@link android.telecom.Call#handoverTo(PhoneAccountHandle, int, Bundle)}.
 *
 * @param call The call which had initiated handover.
 * @param failureReason Error reason for failure.

 * Value is {@link android.telecom.Call.Callback#HANDOVER_FAILURE_DEST_APP_REJECTED}, {@link android.telecom.Call.Callback#HANDOVER_FAILURE_NOT_SUPPORTED}, {@link android.telecom.Call.Callback#HANDOVER_FAILURE_USER_REJECTED}, {@link android.telecom.Call.Callback#HANDOVER_FAILURE_ONGOING_EMERGENCY_CALL}, or {@link android.telecom.Call.Callback#HANDOVER_FAILURE_UNKNOWN}
 */

public void onHandoverFailed(android.telecom.Call call, int failureReason) { throw new RuntimeException("Stub!"); }

/**
 * Handover failure reason returned via {@link #onHandoverFailed(Call, int)} when the app
 * to handover the call to rejects the handover request.
 * <p>
 * Will be returned when {@link Call#handoverTo(PhoneAccountHandle, int, Bundle)} is called
 * and the destination {@link PhoneAccountHandle}'s {@link ConnectionService} returns a
 * {@code null} {@link Connection} from
 * {@link ConnectionService#onCreateOutgoingHandoverConnection(PhoneAccountHandle,
 * ConnectionRequest)}.
 * <p>
 * For more information on call handovers, see
 * {@link #handoverTo(PhoneAccountHandle, int, Bundle)}.
 */

public static final int HANDOVER_FAILURE_DEST_APP_REJECTED = 1; // 0x1

/**
 * Handover failure reason returned via {@link #onHandoverFailed(Call, int)} when a handover
 * is initiated but the source or destination app does not support handover.
 * <p>
 * Will be returned when a handover is requested via
 * {@link #handoverTo(PhoneAccountHandle, int, Bundle)} and the destination
 * {@link PhoneAccountHandle} does not declare
 * {@link PhoneAccount#EXTRA_SUPPORTS_HANDOVER_TO}.  May also be returned when a handover is
 * requested at the {@link PhoneAccountHandle} for the current call (i.e. the source call's
 * {@link Details#getAccountHandle()}) does not declare
 * {@link PhoneAccount#EXTRA_SUPPORTS_HANDOVER_FROM}.
 * <p>
 * For more information on call handovers, see
 * {@link #handoverTo(PhoneAccountHandle, int, Bundle)}.
 */

public static final int HANDOVER_FAILURE_NOT_SUPPORTED = 2; // 0x2

/**
 * Handover failure reason returned via {@link #onHandoverFailed(Call, int)} when there
 * is ongoing emergency call.
 * <p>
 * This error code is returned when {@link #handoverTo(PhoneAccountHandle, int, Bundle)} is
 * called on an emergency call, or if any other call is an emergency call.
 * <p>
 * Handovers are not permitted while there are ongoing emergency calls.
 * <p>
 * For more information on call handovers, see
 * {@link #handoverTo(PhoneAccountHandle, int, Bundle)}.
 */

public static final int HANDOVER_FAILURE_ONGOING_EMERGENCY_CALL = 4; // 0x4

/**
 * Handover failure reason returned via {@link #onHandoverFailed(Call, int)} when a handover
 * fails for an unknown reason.
 * <p>
 * For more information on call handovers, see
 * {@link #handoverTo(PhoneAccountHandle, int, Bundle)}.
 */

public static final int HANDOVER_FAILURE_UNKNOWN = 5; // 0x5

/**
 * Handover failure reason returned via {@link #onHandoverFailed(Call, int)} when the remote
 * user rejects the handover request.
 * <p>
 * For more information on call handovers, see
 * {@link #handoverTo(PhoneAccountHandle, int, Bundle)}.
 */

public static final int HANDOVER_FAILURE_USER_REJECTED = 3; // 0x3
}

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Details {

/** {@hide} */

Details(java.lang.String telecomCallId, android.net.Uri handle, int handlePresentation, java.lang.String callerDisplayName, int callerDisplayNamePresentation, android.telecom.PhoneAccountHandle accountHandle, int capabilities, int properties, android.telecom.DisconnectCause disconnectCause, long connectTimeMillis, android.telecom.GatewayInfo gatewayInfo, int videoState, android.telecom.StatusHints statusHints, android.os.Bundle extras, android.os.Bundle intentExtras, long creationTimeMillis) { throw new RuntimeException("Stub!"); }

/**
 * Whether the supplied capabilities  supports the specified capability.
 *
 * @param capabilities A bit field of capabilities.
 * @param capability The capability to check capabilities for.
 * @return Whether the specified capability is supported.
 */

public static boolean can(int capabilities, int capability) { throw new RuntimeException("Stub!"); }

/**
 * Whether the capabilities of this {@code Details} supports the specified capability.
 *
 * @param capability The capability to check capabilities for.
 * @return Whether the specified capability is supported.
 */

public boolean can(int capability) { throw new RuntimeException("Stub!"); }

/**
 * Render a set of capability bits ({@code CAPABILITY_*}) as a human readable string.
 *
 * @param capabilities A capability bit field.
 * @return A human readable string representation.
 */

public static java.lang.String capabilitiesToString(int capabilities) { throw new RuntimeException("Stub!"); }

/**
 * Whether the supplied properties includes the specified property.
 *
 * @param properties A bit field of properties.
 * @param property The property to check properties for.
 * @return Whether the specified property is supported.
 */

public static boolean hasProperty(int properties, int property) { throw new RuntimeException("Stub!"); }

/**
 * Whether the properties of this {@code Details} includes the specified property.
 *
 * @param property The property to check properties for.
 * @return Whether the specified property is supported.
 */

public boolean hasProperty(int property) { throw new RuntimeException("Stub!"); }

/**
 * Render a set of property bits ({@code PROPERTY_*}) as a human readable string.
 *
 * @param properties A property bit field.
 * @return A human readable string representation.
 */

public static java.lang.String propertiesToString(int properties) { throw new RuntimeException("Stub!"); }

/**
 * @return The handle (e.g., phone number) to which the {@code Call} is currently
 * connected.
 */

public android.net.Uri getHandle() { throw new RuntimeException("Stub!"); }

/**
 * @return The presentation requirements for the handle. See
 * {@link TelecomManager} for valid values.
 */

public int getHandlePresentation() { throw new RuntimeException("Stub!"); }

/**
 * @return The display name for the caller.
 */

public java.lang.String getCallerDisplayName() { throw new RuntimeException("Stub!"); }

/**
 * @return The presentation requirements for the caller display name. See
 * {@link TelecomManager} for valid values.
 */

public int getCallerDisplayNamePresentation() { throw new RuntimeException("Stub!"); }

/**
 * @return The {@code PhoneAccountHandle} whereby the {@code Call} is currently being
 * routed.
 */

public android.telecom.PhoneAccountHandle getAccountHandle() { throw new RuntimeException("Stub!"); }

/**
 * @return A bitmask of the capabilities of the {@code Call}, as defined by the various
 *         {@code CAPABILITY_*} constants in this class.
 */

public int getCallCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * @return A bitmask of the properties of the {@code Call}, as defined by the various
 *         {@code PROPERTY_*} constants in this class.
 */

public int getCallProperties() { throw new RuntimeException("Stub!"); }

/**
 * @return For a {@link #STATE_DISCONNECTED} {@code Call}, the disconnect cause expressed
 * by {@link android.telecom.DisconnectCause}.
 */

public android.telecom.DisconnectCause getDisconnectCause() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time the {@link Call} connected (i.e. became active).  This information is
 * updated periodically, but user interfaces should not rely on this to display the "call
 * time clock".  For the time when the call was first added to Telecom, see
 * {@link #getCreationTimeMillis()}.
 *
 * @return The time the {@link Call} connected in milliseconds since the epoch.
 */

public final long getConnectTimeMillis() { throw new RuntimeException("Stub!"); }

/**
 * @return Information about any calling gateway the {@code Call} may be using.
 */

public android.telecom.GatewayInfo getGatewayInfo() { throw new RuntimeException("Stub!"); }

/**
 * @return The video state of the {@code Call}.
 */

public int getVideoState() { throw new RuntimeException("Stub!"); }

/**
 * @return The current {@link android.telecom.StatusHints}, or {@code null} if none
 * have been set.
 */

public android.telecom.StatusHints getStatusHints() { throw new RuntimeException("Stub!"); }

/**
 * @return The extras associated with this call.
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * @return The extras used with the original intent to place this call.
 */

public android.os.Bundle getIntentExtras() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time when the call was first created and added to Telecom.  This is the same
 * time that is logged as the start time in the Call Log (see
 * {@link android.provider.CallLog.Calls#DATE}).  To determine when the call was connected
 * (became active), see {@link #getConnectTimeMillis()}.
 *
 * @return The creation time of the call, in millis since the epoch.
 */

public long getCreationTimeMillis() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * When set, prevents a video {@code Call} from being downgraded to an audio-only call.
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

public static final int CAPABILITY_CANNOT_DOWNGRADE_VIDEO_TO_AUDIO = 4194304; // 0x400000

/**
 * For video calls, indicates whether the outgoing video for the call can be paused using
 * the {@link android.telecom.VideoProfile#STATE_PAUSED} VideoState.
 */

public static final int CAPABILITY_CAN_PAUSE_VIDEO = 1048576; // 0x100000

/**
 * When set for an external call, indicates that this {@code Call} can be pulled from a
 * remote device to the current device.
 * <p>
 * Should only be set on a {@code Call} where {@link #PROPERTY_IS_EXTERNAL_CALL} is set.
 * <p>
 * An {@link InCallService} will only see calls with this capability if it has the
 * {@link TelecomManager#METADATA_INCLUDE_EXTERNAL_CALLS} metadata set to {@code true}
 * in its manifest.
 * <p>
 * See {@link Connection#CAPABILITY_CAN_PULL_CALL} and
 * {@link Connection#PROPERTY_IS_EXTERNAL_CALL}.
 */

public static final int CAPABILITY_CAN_PULL_CALL = 8388608; // 0x800000

/**
 * Call is able to be individually disconnected when in a {@code Conference}.
 */

public static final int CAPABILITY_DISCONNECT_FROM_CONFERENCE = 8192; // 0x2000

/** Call can currently be put on hold or unheld. */

public static final int CAPABILITY_HOLD = 1; // 0x1

/**
 * Call supports conference call management. This capability only applies to {@link Conference}
 * calls which can have {@link Connection}s as children.
 */

public static final int CAPABILITY_MANAGE_CONFERENCE = 128; // 0x80

/**
 * Calls within a conference can be merged. A {@link ConnectionService} has the option to
 * add a {@link Conference} call before the child {@link Connection}s are merged. This is how
 * CDMA-based {@link Connection}s are implemented. For these unmerged {@link Conference}s, this
 * capability allows a merge button to be shown while the conference call is in the foreground
 * of the in-call UI.
 * <p>
 * This is only intended for use by a {@link Conference}.
 */

public static final int CAPABILITY_MERGE_CONFERENCE = 4; // 0x4

/** Call can be muted. */

public static final int CAPABILITY_MUTE = 64; // 0x40

/** Call supports responding via text option. */

public static final int CAPABILITY_RESPOND_VIA_TEXT = 32; // 0x20

/**
 * Call is able to be separated from its parent {@code Conference}, if any.
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

public static final int CAPABILITY_SUPPORT_DEFLECT = 16777216; // 0x1000000

/** Call supports the hold feature. */

public static final int CAPABILITY_SUPPORT_HOLD = 2; // 0x2

/**
 * Calls within a conference can be swapped between foreground and background.
 * See {@link #CAPABILITY_MERGE_CONFERENCE} for additional information.
 * <p>
 * This is only intended for use by a {@link Conference}.
 */

public static final int CAPABILITY_SWAP_CONFERENCE = 8; // 0x8

/**
 * Whether the call is currently a conference.
 */

public static final int PROPERTY_CONFERENCE = 1; // 0x1

/**
 * Whether the call is made while the device is in emergency callback mode.
 */

public static final int PROPERTY_EMERGENCY_CALLBACK_MODE = 4; // 0x4

/**
 * Whether the call is associated with the work profile.
 */

public static final int PROPERTY_ENTERPRISE_CALL = 32; // 0x20

/**
 * Whether the call is a generic conference, where we do not know the precise state of
 * participants in the conference (eg. on CDMA).
 */

public static final int PROPERTY_GENERIC_CONFERENCE = 2; // 0x2

/**
 * Indicates that the call has CDMA Enhanced Voice Privacy enabled.
 */

public static final int PROPERTY_HAS_CDMA_VOICE_PRIVACY = 128; // 0x80

/**
 * Call is using high definition audio.
 */

public static final int PROPERTY_HIGH_DEF_AUDIO = 16; // 0x10

/**
 * When set, indicates that this {@code Call} does not actually exist locally for the
 * {@link ConnectionService}.
 * <p>
 * Consider, for example, a scenario where a user has two phones with the same phone number.
 * When a user places a call on one device, the telephony stack can represent that call on
 * the other device by adding it to the {@link ConnectionService} with the
 * {@link Connection#PROPERTY_IS_EXTERNAL_CALL} property set.
 * <p>
 * An {@link InCallService} will only see calls with this property if it has the
 * {@link TelecomManager#METADATA_INCLUDE_EXTERNAL_CALLS} metadata set to {@code true}
 * in its manifest.
 * <p>
 * See {@link Connection#PROPERTY_IS_EXTERNAL_CALL}.
 */

public static final int PROPERTY_IS_EXTERNAL_CALL = 64; // 0x40

/**
 * Indicates that the call is an RTT call. Use {@link #getRttCall()} to get the
 * {@link RttCall} object that is used to send and receive text.
 */

public static final int PROPERTY_RTT = 1024; // 0x400

/**
 * Indicates that the call is from a self-managed {@link ConnectionService}.
 * <p>
 * See also {@link Connection#PROPERTY_SELF_MANAGED}
 */

public static final int PROPERTY_SELF_MANAGED = 256; // 0x100

/**
 * Connection is using WIFI.
 */

public static final int PROPERTY_WIFI = 8; // 0x8
}

/**
 * A class that holds the state that describes the state of the RTT channel to the remote
 * party, if it is active.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class RttCall {

RttCall() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current RTT audio mode.
 * @return Current RTT audio mode. One of {@link #RTT_MODE_FULL}, {@link #RTT_MODE_VCO}, or
 * {@link #RTT_MODE_HCO}.
 */

public int getRttAudioMode() { throw new RuntimeException("Stub!"); }

/**
 * Sets the RTT audio mode. The requested mode change will be communicated through
 * {@link Callback#onRttModeChanged(Call, int)}.
 * @param mode The desired RTT audio mode, one of {@link #RTT_MODE_FULL},
 * {@link #RTT_MODE_VCO}, or {@link #RTT_MODE_HCO}.

 * Value is android.telecom.Call.RttCall.RTT_MODE_INVALID, {@link android.telecom.Call.RttCall#RTT_MODE_FULL}, {@link android.telecom.Call.RttCall#RTT_MODE_HCO}, or {@link android.telecom.Call.RttCall#RTT_MODE_VCO}
 */

public void setRttMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Writes the string {@param input} into the outgoing text stream for this RTT call. Since
 * RTT transmits text in real-time, this method should be called once for each character
 * the user enters into the device.
 *
 * This method is not thread-safe -- calling it from multiple threads simultaneously may
 * lead to interleaved text.
 * @param input The message to send to the remote user.
 */

public void write(java.lang.String input) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads a string from the remote user, blocking if there is no data available. Returns
 * {@code null} if the RTT conversation has been terminated and there is no further data
 * to read.
 *
 * This method is not thread-safe -- calling it from multiple threads simultaneously may
 * lead to interleaved text.
 * @return A string containing text sent by the remote user, or {@code null} if the
 * conversation has been terminated or if there was an error while reading.
 */

public java.lang.String read() { throw new RuntimeException("Stub!"); }

/**
 * Non-blocking version of {@link #read()}. Returns {@code null} if there is nothing to
 * be read.
 * @return A string containing text entered by the user, or {@code null} if the user has
 * not entered any new text yet.
 */

public java.lang.String readImmediately() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Indicates that there should be a bidirectional audio stream between the two parties
 * on the call.
 */

public static final int RTT_MODE_FULL = 1; // 0x1

/**
 * Indicates that the local user should be able to hear the audio stream from the remote
 * user, but not vice versa. Equivalent to muting the microphone.
 */

public static final int RTT_MODE_HCO = 2; // 0x2

/**
 * Indicates that the remote user should be able to hear the audio stream from the local
 * user, but not vice versa. Equivalent to setting the volume to zero.
 */

public static final int RTT_MODE_VCO = 3; // 0x3
}

}

