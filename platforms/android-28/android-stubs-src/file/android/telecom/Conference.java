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

import java.util.Set;
import android.telecom.Connection.VideoProvider;
import android.os.SystemClock;
import android.os.Bundle;
import java.util.List;

/**
 * Represents a conference call which can contain any number of {@link Connection} objects.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Conference extends android.telecom.Conferenceable {

/**
 * Constructs a new Conference with a mandatory {@link PhoneAccountHandle}
 *
 * @param phoneAccount The {@code PhoneAccountHandle} associated with the conference.
 */

public Conference(android.telecom.PhoneAccountHandle phoneAccount) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link PhoneAccountHandle} the conference call is being placed through.
 *
 * @return A {@code PhoneAccountHandle} object representing the PhoneAccount of the conference.
 */

public final android.telecom.PhoneAccountHandle getPhoneAccountHandle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the list of connections currently associated with the conference call.
 *
 * @return A list of {@code Connection} objects which represent the children of the conference.
 */

public final java.util.List<android.telecom.Connection> getConnections() { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of the conference call. See {@link Connection} for valid values.
 *
 * @return A constant representing the state the conference call is currently in.
 */

public final int getState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the capabilities of the conference. See {@code CAPABILITY_*} constants in class
 * {@link Connection} for valid values.
 *
 * @return A bitmask of the capabilities of the conference call.
 */

public final int getConnectionCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Returns the properties of the conference. See {@code PROPERTY_*} constants in class
 * {@link Connection} for valid values.
 *
 * @return A bitmask of the properties of the conference call.
 */

public final int getConnectionProperties() { throw new RuntimeException("Stub!"); }

/**
 * @return The audio state of the conference, describing how its audio is currently
 *         being routed by the system. This is {@code null} if this Conference
 *         does not directly know about its audio state.
 */

public final android.telecom.CallAudioState getCallAudioState() { throw new RuntimeException("Stub!"); }

/**
 * Returns VideoProvider of the primary call. This can be null.
 */

public android.telecom.Connection.VideoProvider getVideoProvider() { throw new RuntimeException("Stub!"); }

/**
 * Returns video state of the primary call.
 */

public int getVideoState() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link Conference} when the Conference and all it's {@link Connection}s should
 * be disconnected.
 */

public void onDisconnect() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link Conference} when the specified {@link Connection} should be separated
 * from the conference call.
 *
 * @param connection The connection to separate.
 */

public void onSeparate(android.telecom.Connection connection) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link Conference} when the specified {@link Connection} should merged with the
 * conference call.
 *
 * @param connection The {@code Connection} to merge.
 */

public void onMerge(android.telecom.Connection connection) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link Conference} when it should be put on hold.
 */

public void onHold() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link Conference} when it should be moved from a held to active state.
 */

public void onUnhold() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link Conference} when the child calls should be merged.  Only invoked if the
 * conference contains the capability {@link Connection#CAPABILITY_MERGE_CONFERENCE}.
 */

public void onMerge() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link Conference} when the child calls should be swapped. Only invoked if the
 * conference contains the capability {@link Connection#CAPABILITY_SWAP_CONFERENCE}.
 */

public void onSwap() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link Conference} of a request to play a DTMF tone.
 *
 * @param c A DTMF character.
 */

public void onPlayDtmfTone(char c) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link Conference} of a request to stop any currently playing DTMF tones.
 */

public void onStopDtmfTone() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link Conference} that the {@link #getCallAudioState()} property has a new
 * value.
 *
 * @param state The new call audio state.
 */

public void onCallAudioStateChanged(android.telecom.CallAudioState state) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the {@link Conference} that a {@link Connection} has been added to it.
 *
 * @param connection The newly added connection.
 */

public void onConnectionAdded(android.telecom.Connection connection) { throw new RuntimeException("Stub!"); }

/**
 * Sets state to be on hold.
 */

public final void setOnHold() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to be dialing.
 */

public final void setDialing() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to be active.
 */

public final void setActive() { throw new RuntimeException("Stub!"); }

/**
 * Sets state to disconnected.
 *
 * @param disconnectCause The reason for the disconnection, as described by
 *     {@link android.telecom.DisconnectCause}.
 */

public final void setDisconnected(android.telecom.DisconnectCause disconnectCause) { throw new RuntimeException("Stub!"); }

/**
 * @return The {@link DisconnectCause} for this connection.
 */

public final android.telecom.DisconnectCause getDisconnectCause() { throw new RuntimeException("Stub!"); }

/**
 * Sets the capabilities of a conference. See {@code CAPABILITY_*} constants of class
 * {@link Connection} for valid values.
 *
 * @param connectionCapabilities A bitmask of the {@code Capabilities} of the conference call.
 */

public final void setConnectionCapabilities(int connectionCapabilities) { throw new RuntimeException("Stub!"); }

/**
 * Sets the properties of a conference. See {@code PROPERTY_*} constants of class
 * {@link Connection} for valid values.
 *
 * @param connectionProperties A bitmask of the {@code Properties} of the conference call.
 */

public final void setConnectionProperties(int connectionProperties) { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified connection as a child of this conference.
 *
 * @param connection The connection to add.
 * @return True if the connection was successfully added.
 */

public final boolean addConnection(android.telecom.Connection connection) { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified connection as a child of this conference.
 *
 * @param connection The connection to remove.
 */

public final void removeConnection(android.telecom.Connection connection) { throw new RuntimeException("Stub!"); }

/**
 * Sets the connections with which this connection can be conferenced.
 *
 * @param conferenceableConnections The set of connections this connection can conference with.
 */

public final void setConferenceableConnections(java.util.List<android.telecom.Connection> conferenceableConnections) { throw new RuntimeException("Stub!"); }

/**
 * Set the video state for the conference.
 * Valid values: {@link VideoProfile#STATE_AUDIO_ONLY},
 * {@link VideoProfile#STATE_BIDIRECTIONAL},
 * {@link VideoProfile#STATE_TX_ENABLED},
 * {@link VideoProfile#STATE_RX_ENABLED}.
 *
 * @param videoState The new video state.
 */

public final void setVideoState(android.telecom.Connection c, int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Sets the video connection provider.
 *
 * @param videoProvider The video provider.
 */

public final void setVideoProvider(android.telecom.Connection c, android.telecom.Connection.VideoProvider videoProvider) { throw new RuntimeException("Stub!"); }

/**
 * Returns the connections with which this connection can be conferenced.
 */

public final java.util.List<android.telecom.Connection> getConferenceableConnections() { throw new RuntimeException("Stub!"); }

/**
 * Tears down the conference object and any of its current connections.
 */

public final void destroy() { throw new RuntimeException("Stub!"); }

/**
 * Sets the connection start time of the {@code Conference}.  This is used in the call log to
 * indicate the date and time when the conference took place.
 * <p>
 * Should be specified in wall-clock time returned by {@link System#currentTimeMillis()}.
 * <p>
 * When setting the connection time, you should always set the connection elapsed time via
 * {@link #setConnectionStartElapsedRealTime(long)} to ensure the duration is reflected.
 *
 * @param connectionTimeMillis The connection time, in milliseconds, as returned by
 *                             {@link System#currentTimeMillis()}.
 */

public final void setConnectionTime(long connectionTimeMillis) { throw new RuntimeException("Stub!"); }

/**
 * Sets the start time of the {@link Conference} which is the basis for the determining the
 * duration of the {@link Conference}.
 * <p>
 * You should use a value returned by {@link SystemClock#elapsedRealtime()} to ensure that time
 * zone changes do not impact the conference duration.
 * <p>
 * When setting this, you should also set the connection time via
 * {@link #setConnectionTime(long)}.
 *
 * @param connectionStartElapsedRealTime The connection time, as measured by
 * {@link SystemClock#elapsedRealtime()}.
 */

public final void setConnectionStartElapsedRealTime(long connectionStartElapsedRealTime) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the connection start time of the {@code Conference}, if specified.  A value of
 * {@link #CONNECT_TIME_NOT_SPECIFIED} indicates that Telecom should determine the start time
 * of the conference.
 *
 * @return The time at which the {@code Conference} was connected.
 */

public final long getConnectionTime() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Sets the label and icon status to display in the InCall UI.
 *
 * @param statusHints The status label and icon to set.
 */

public final void setStatusHints(android.telecom.StatusHints statusHints) { throw new RuntimeException("Stub!"); }

/**
 * @return The status hints for this conference.
 */

public final android.telecom.StatusHints getStatusHints() { throw new RuntimeException("Stub!"); }

/**
 * Replaces all the extras associated with this {@code Conference}.
 * <p>
 * New or existing keys are replaced in the {@code Conference} extras.  Keys which are no longer
 * in the new extras, but were present the last time {@code setExtras} was called are removed.
 * <p>
 * Alternatively you may use the {@link #putExtras(Bundle)}, and
 * {@link #removeExtras(String...)} methods to modify the extras.
 * <p>
 * No assumptions should be made as to how an In-Call UI or service will handle these extras.
 * Keys should be fully qualified (e.g., com.example.extras.MY_EXTRA) to avoid conflicts.
 *
 * @param extras The extras associated with this {@code Conference}.

 * This value may be {@code null}.
 */

public final void setExtras(@androidx.annotation.RecentlyNullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Adds some extras to this {@link Conference}.  Existing keys are replaced and new ones are
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
 * Removes extras from this {@link Conference}.
 *
 * @param keys The keys of the extras to remove.
 */

public final void removeExtras(java.util.List<java.lang.String> keys) { throw new RuntimeException("Stub!"); }

/**
 * Removes extras from this {@link Conference}.
 *
 * @param keys The keys of the extras to remove.
 */

public final void removeExtras(java.lang.String... keys) { throw new RuntimeException("Stub!"); }

/**
 * Returns the extras associated with this conference.
 * <p>
 * Extras should be updated using {@link #putExtras(Bundle)} and {@link #removeExtras(List)}.
 * <p>
 * Telecom or an {@link InCallService} can also update the extras via
 * {@link android.telecom.Call#putExtras(Bundle)}, and
 * {@link Call#removeExtras(List)}.
 * <p>
 * The conference is notified of changes to the extras made by Telecom or an
 * {@link InCallService} by {@link #onExtrasChanged(Bundle)}.
 *
 * @return The extras associated with this connection.
 */

public final android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Notifies this {@link Conference} of a change to the extras made outside the
 * {@link ConnectionService}.
 * <p>
 * These extras changes can originate from Telecom itself, or from an {@link InCallService} via
 * {@link android.telecom.Call#putExtras(Bundle)}, and
 * {@link Call#removeExtras(List)}.
 *
 * @param extras The new extras bundle.
 */

public void onExtrasChanged(android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Used to indicate that the conference connection time is not specified.  If not specified,
 * Telecom will set the connect time.
 */

public static final long CONNECT_TIME_NOT_SPECIFIED = 0L; // 0x0L
}

