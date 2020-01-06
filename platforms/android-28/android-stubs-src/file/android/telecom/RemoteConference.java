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


/**
 * A conference provided to a {@link ConnectionService} by another {@code ConnectionService} through
 * {@link ConnectionService#conferenceRemoteConnections}. Once created, a {@code RemoteConference}
 * can be used to control the conference call or monitor changes through
 * {@link RemoteConnection.Callback}.
 *
 * @see ConnectionService#onRemoteConferenceAdded
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RemoteConference {

RemoteConference() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of {@link RemoteConnection}s contained in this conference.
 *
 * @return A list of child connections.
 */

public java.util.List<android.telecom.RemoteConnection> getConnections() { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of the conference call. See {@link Connection} for valid values.
 *
 * @return A constant representing the state the conference call is currently in.
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the capabilities of the conference. See {@code CAPABILITY_*} constants in class
 * {@link Connection} for valid values.
 *
 * @return A bitmask of the capabilities of the conference call.
 */

public int getConnectionCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the properties of the conference. See {@code PROPERTY_*} constants in class
 * {@link Connection} for valid values.
 *
 * @return A bitmask of the properties of the conference call.
 */

public int getConnectionProperties() { throw new RuntimeException("Stub!"); }

/**
 * Obtain the extras associated with this {@code RemoteConnection}.
 *
 * @return The extras for this connection.
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Disconnects the conference call as well as the child {@link RemoteConnection}s.
 */

public void disconnect() { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified {@link RemoteConnection} from the conference. This causes the
 * {@link RemoteConnection} to become a standalone connection. This is a no-op if the
 * {@link RemoteConnection} does not belong to this conference.
 *
 * @param connection The remote-connection to remove.
 */

public void separate(android.telecom.RemoteConnection connection) { throw new RuntimeException("Stub!"); }

/**
 * Merges all {@link RemoteConnection}s of this conference into a single call. This should be
 * invoked only if the conference contains the capability
 * {@link Connection#CAPABILITY_MERGE_CONFERENCE}, otherwise it is a no-op. The presence of said
 * capability indicates that the connections of this conference, despite being part of the
 * same conference object, are yet to have their audio streams merged; this is a common pattern
 * for CDMA conference calls, but the capability is not used for GSM and SIP conference calls.
 * Invoking this method will cause the unmerged child connections to merge their audio
 * streams.
 */

public void merge() { throw new RuntimeException("Stub!"); }

/**
 * Swaps the active audio stream between the conference's child {@link RemoteConnection}s.
 * This should be invoked only if the conference contains the capability
 * {@link Connection#CAPABILITY_SWAP_CONFERENCE}, otherwise it is a no-op. This is only used by
 * {@link ConnectionService}s that create conferences for connections that do not yet have
 * their audio streams merged; this is a common pattern for CDMA conference calls, but the
 * capability is not used for GSM and SIP conference calls. Invoking this method will change the
 * active audio stream to a different child connection.
 */

public void swap() { throw new RuntimeException("Stub!"); }

/**
 * Puts the conference on hold.
 */

public void hold() { throw new RuntimeException("Stub!"); }

/**
 * Unholds the conference call.
 */

public void unhold() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link DisconnectCause} for the conference if it is in the state
 * {@link Connection#STATE_DISCONNECTED}. If the conference is not disconnected, this will
 * return null.
 *
 * @return The disconnect cause.
 */

public android.telecom.DisconnectCause getDisconnectCause() { throw new RuntimeException("Stub!"); }

/**
 * Requests that the conference start playing the specified DTMF tone.
 *
 * @param digit The digit for which to play a DTMF tone.
 */

public void playDtmfTone(char digit) { throw new RuntimeException("Stub!"); }

/**
 * Stops the most recent request to play a DTMF tone.
 *
 * @see #playDtmfTone
 */

public void stopDtmfTone() { throw new RuntimeException("Stub!"); }

/**
 * Request to change the conference's audio routing to the specified state. The specified state
 * can include audio routing (Bluetooth, Speaker, etc) and muting state.
 */

public void setCallAudioState(android.telecom.CallAudioState state) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of independent connections that can me merged with this conference.
 *
 * @return A list of conferenceable connections.
 */

public java.util.List<android.telecom.RemoteConnection> getConferenceableConnections() { throw new RuntimeException("Stub!"); }

/**
 * Register a callback through which to receive state updates for this conference.
 *
 * @param callback The callback to notify of state changes.
 */

public void registerCallback(android.telecom.RemoteConference.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback through which to receive state updates for this conference.
 * Callbacks will be notified using the specified handler, if provided.
 *
 * @param callback The callback to notify of state changes.
 * @param handler The handler on which to execute the callbacks.
 */

public void registerCallback(android.telecom.RemoteConference.Callback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a previously registered callback.
 *
 * @see #registerCallback
 *
 * @param callback The callback to unregister.
 */

public void unregisterCallback(android.telecom.RemoteConference.Callback callback) { throw new RuntimeException("Stub!"); }
/**
 * Callback base class for {@link RemoteConference}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the state of this {@code RemoteConferece} has changed. See
 * {@link #getState()}.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param oldState The previous state of the {@code RemoteConference}.
 * @param newState The new state of the {@code RemoteConference}.
 */

public void onStateChanged(android.telecom.RemoteConference conference, int oldState, int newState) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when this {@code RemoteConference} is disconnected.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param disconnectCause The ({@see DisconnectCause}) associated with this failed
 *     conference.
 */

public void onDisconnected(android.telecom.RemoteConference conference, android.telecom.DisconnectCause disconnectCause) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when a {@link RemoteConnection} is added to the conference call.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param connection The {@link RemoteConnection} being added.
 */

public void onConnectionAdded(android.telecom.RemoteConference conference, android.telecom.RemoteConnection connection) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when a {@link RemoteConnection} is removed from the conference call.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param connection The {@link RemoteConnection} being removed.
 */

public void onConnectionRemoved(android.telecom.RemoteConference conference, android.telecom.RemoteConnection connection) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the call capabilities of this {@code RemoteConference} have changed.
 * See {@link #getConnectionCapabilities()}.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param connectionCapabilities The new capabilities of the {@code RemoteConference}.
 */

public void onConnectionCapabilitiesChanged(android.telecom.RemoteConference conference, int connectionCapabilities) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the call properties of this {@code RemoteConference} have changed.
 * See {@link #getConnectionProperties()}.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param connectionProperties The new properties of the {@code RemoteConference}.
 */

public void onConnectionPropertiesChanged(android.telecom.RemoteConference conference, int connectionProperties) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the set of {@link RemoteConnection}s which can be added to this conference
 * call have changed.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param conferenceableConnections The list of conferenceable {@link RemoteConnection}s.
 */

public void onConferenceableConnectionsChanged(android.telecom.RemoteConference conference, java.util.List<android.telecom.RemoteConnection> conferenceableConnections) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that this {@code RemoteConference} has been destroyed. No further requests
 * should be made to the {@code RemoteConference}, and references to it should be cleared.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 */

public void onDestroyed(android.telecom.RemoteConference conference) { throw new RuntimeException("Stub!"); }

/**
 * Handles changes to the {@code RemoteConference} extras.
 *
 * @param conference The {@code RemoteConference} invoking this method.
 * @param extras The extras containing other information associated with the conference.

 * This value may be {@code null}.
 */

public void onExtrasChanged(android.telecom.RemoteConference conference, @androidx.annotation.RecentlyNullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }
}

}

