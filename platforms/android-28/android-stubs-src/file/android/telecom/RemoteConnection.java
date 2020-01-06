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

import android.os.Handler;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import android.os.Bundle;
import android.hardware.camera2.CameraManager;
import java.util.List;
import android.view.Surface;
import android.net.Uri;

/**
 * A connection provided to a {@link ConnectionService} by another {@code ConnectionService}
 * running in a different process.
 *
 * @see ConnectionService#createRemoteOutgoingConnection(PhoneAccountHandle, ConnectionRequest)
 * @see ConnectionService#createRemoteIncomingConnection(PhoneAccountHandle, ConnectionRequest)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RemoteConnection {

/**
 * Create a RemoteConnection which is used for failed connections. Note that using it for any
 * "real" purpose will almost certainly fail. Callers should note the failure and act
 * accordingly (moving on to another RemoteConnection, for example)
 *
 * @param disconnectCause The reason for the failed connection.
 * @hide
 */

RemoteConnection(android.telecom.DisconnectCause disconnectCause) { throw new RuntimeException("Stub!"); }

/**
 * Adds a callback to this {@code RemoteConnection}.
 *
 * @param callback A {@code Callback}.
 */

public void registerCallback(android.telecom.RemoteConnection.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Adds a callback to this {@code RemoteConnection}.
 *
 * @param callback A {@code Callback}.
 * @param handler A {@code Handler} which command and status changes will be delivered to.
 */

public void registerCallback(android.telecom.RemoteConnection.Callback callback, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Removes a callback from this {@code RemoteConnection}.
 *
 * @param callback A {@code Callback}.
 */

public void unregisterCallback(android.telecom.RemoteConnection.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the state of this {@code RemoteConnection}.
 *
 * @return A state value, chosen from the {@code STATE_*} constants.
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the reason why this {@code RemoteConnection} may have been disconnected.
 *
 * @return For a {@link Connection#STATE_DISCONNECTED} {@code RemoteConnection}, the
 *         disconnect cause expressed as a code chosen from among those declared in
 *         {@link DisconnectCause}.
 */

public android.telecom.DisconnectCause getDisconnectCause() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the capabilities of this {@code RemoteConnection}.
 *
 * @return A bitmask of the capabilities of the {@code RemoteConnection}, as defined in
 *         the {@code CAPABILITY_*} constants in class {@link Connection}.
 */

public int getConnectionCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the properties of this {@code RemoteConnection}.
 *
 * @return A bitmask of the properties of the {@code RemoteConnection}, as defined in the
 *         {@code PROPERTY_*} constants in class {@link Connection}.
 */

public int getConnectionProperties() { throw new RuntimeException("Stub!"); }

/**
 * Determines if the audio mode of this {@code RemoteConnection} is VOIP.
 *
 * @return {@code true} if the {@code RemoteConnection}'s current audio mode is VOIP.
 */

public boolean isVoipAudioMode() { throw new RuntimeException("Stub!"); }

/**
 * Obtains status hints pertaining to this {@code RemoteConnection}.
 *
 * @return The current {@link StatusHints} of this {@code RemoteConnection},
 *         or {@code null} if none have been set.
 */

public android.telecom.StatusHints getStatusHints() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the address of this {@code RemoteConnection}.
 *
 * @return The address (e.g., phone number) to which the {@code RemoteConnection}
 *         is currently connected.
 */

public android.net.Uri getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the presentation requirements for the address of this {@code RemoteConnection}.
 *
 * @return The presentation requirements for the address. See
 *         {@link TelecomManager} for valid values.
 */

public int getAddressPresentation() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the display name for this {@code RemoteConnection}'s caller.
 *
 * @return The display name for the caller.
 */

public java.lang.CharSequence getCallerDisplayName() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the presentation requirements for this {@code RemoteConnection}'s
 * caller's display name.
 *
 * @return The presentation requirements for the caller display name. See
 *         {@link TelecomManager} for valid values.
 */

public int getCallerDisplayNamePresentation() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the video state of this {@code RemoteConnection}.
 *
 * @return The video state of the {@code RemoteConnection}. See {@link VideoProfile}.
 */

public int getVideoState() { throw new RuntimeException("Stub!"); }

/**
 * Obtains the video provider of this {@code RemoteConnection}.
 * @return The video provider associated with this {@code RemoteConnection}.
 */

public android.telecom.RemoteConnection.VideoProvider getVideoProvider() { throw new RuntimeException("Stub!"); }

/**
 * Obtain the extras associated with this {@code RemoteConnection}.
 *
 * @return The extras for this connection.
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Determines whether this {@code RemoteConnection} is requesting ringback.
 *
 * @return Whether the {@code RemoteConnection} is requesting that the framework play a
 *         ringback tone on its behalf.
 */

public boolean isRingbackRequested() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code RemoteConnection} to abort.
 */

public void abort() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@link Connection#STATE_RINGING} {@code RemoteConnection} to answer.
 */

public void answer() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@link Connection#STATE_RINGING} {@code RemoteConnection} to reject.
 */

public void reject() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code RemoteConnection} to go on hold.
 */

public void hold() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@link Connection#STATE_HOLDING} call to release from hold.
 */

public void unhold() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code RemoteConnection} to disconnect.
 */

public void disconnect() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code RemoteConnection} to play a dual-tone multi-frequency signaling
 * (DTMF) tone.
 *
 * Any other currently playing DTMF tone in the specified call is immediately stopped.
 *
 * @param digit A character representing the DTMF digit for which to play the tone. This
 *         value must be one of {@code '0'} through {@code '9'}, {@code '*'} or {@code '#'}.
 */

public void playDtmfTone(char digit) { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code RemoteConnection} to stop any dual-tone multi-frequency signaling
 * (DTMF) tone currently playing.
 *
 * DTMF tones are played by calling {@link #playDtmfTone(char)}. If no DTMF tone is
 * currently playing, this method will do nothing.
 */

public void stopDtmfTone() { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@code RemoteConnection} to continue playing a post-dial DTMF string.
 *
 * A post-dial DTMF string is a string of digits following the first instance of either
 * {@link TelecomManager#DTMF_CHARACTER_WAIT} or {@link TelecomManager#DTMF_CHARACTER_PAUSE}.
 * These digits are immediately sent as DTMF tones to the recipient as soon as the
 * connection is made.
 *
 * If the DTMF string contains a {@link TelecomManager#DTMF_CHARACTER_PAUSE} symbol, this
 * {@code RemoteConnection} will temporarily pause playing the tones for a pre-defined period
 * of time.
 *
 * If the DTMF string contains a {@link TelecomManager#DTMF_CHARACTER_WAIT} symbol, this
 * {@code RemoteConnection} will pause playing the tones and notify callbacks via
 * {@link Callback#onPostDialWait(RemoteConnection, String)}. At this point, the in-call app
 * should display to the user an indication of this state and an affordance to continue
 * the postdial sequence. When the user decides to continue the postdial sequence, the in-call
 * app should invoke the {@link #postDialContinue(boolean)} method.
 *
 * @param proceed Whether or not to continue with the post-dial sequence.
 */

public void postDialContinue(boolean proceed) { throw new RuntimeException("Stub!"); }

/**
 * Instructs this {@link RemoteConnection} to pull itself to the local device.
 * <p>
 * See {@link Call#pullExternalCall()} for more information.
 */

public void pullExternalCall() { throw new RuntimeException("Stub!"); }

/**
 * Set the audio state of this {@code RemoteConnection}.
 *
 * @param state The audio state of this {@code RemoteConnection}.
 */

public void setCallAudioState(android.telecom.CallAudioState state) { throw new RuntimeException("Stub!"); }

/**
 * Obtain the {@code RemoteConnection}s with which this {@code RemoteConnection} may be
 * successfully asked to create a conference with.
 *
 * @return The {@code RemoteConnection}s with which this {@code RemoteConnection} may be
 *         merged into a {@link RemoteConference}.
 */

public java.util.List<android.telecom.RemoteConnection> getConferenceableConnections() { throw new RuntimeException("Stub!"); }

/**
 * Obtain the {@code RemoteConference} that this {@code RemoteConnection} may be a part
 * of, or {@code null} if there is no such {@code RemoteConference}.
 *
 * @return A {@code RemoteConference} or {@code null};
 */

public android.telecom.RemoteConference getConference() { throw new RuntimeException("Stub!"); }
/**
 * Callback base class for {@link RemoteConnection}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the state of this {@code RemoteConnection} has changed. See
 * {@link #getState()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param state The new state of the {@code RemoteConnection}.
 */

public void onStateChanged(android.telecom.RemoteConnection connection, int state) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when this {@code RemoteConnection} is disconnected.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param disconnectCause The ({@see DisconnectCause}) associated with this failed
 *     connection.
 */

public void onDisconnected(android.telecom.RemoteConnection connection, android.telecom.DisconnectCause disconnectCause) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when this {@code RemoteConnection} is requesting ringback. See
 * {@link #isRingbackRequested()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param ringback Whether the {@code RemoteConnection} is requesting ringback.
 */

public void onRingbackRequested(android.telecom.RemoteConnection connection, boolean ringback) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the call capabilities of this {@code RemoteConnection} have changed.
 * See {@link #getConnectionCapabilities()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param connectionCapabilities The new capabilities of the {@code RemoteConnection}.
 */

public void onConnectionCapabilitiesChanged(android.telecom.RemoteConnection connection, int connectionCapabilities) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the call properties of this {@code RemoteConnection} have changed.
 * See {@link #getConnectionProperties()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param connectionProperties The new properties of the {@code RemoteConnection}.
 */

public void onConnectionPropertiesChanged(android.telecom.RemoteConnection connection, int connectionProperties) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the post-dial sequence in the outgoing {@code Connection} has reached a
 * pause character. This causes the post-dial signals to stop pending user confirmation. An
 * implementation should present this choice to the user and invoke
 * {@link RemoteConnection#postDialContinue(boolean)} when the user makes the choice.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param remainingPostDialSequence The post-dial characters that remain to be sent.
 */

public void onPostDialWait(android.telecom.RemoteConnection connection, java.lang.String remainingPostDialSequence) { throw new RuntimeException("Stub!"); }

/**
 * Invoked when the post-dial sequence in the outgoing {@code Connection} has processed
 * a character.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param nextChar The character being processed.
 */

public void onPostDialChar(android.telecom.RemoteConnection connection, char nextChar) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the VOIP audio status of this {@code RemoteConnection} has changed.
 * See {@link #isVoipAudioMode()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param isVoip Whether the new audio state of the {@code RemoteConnection} is VOIP.
 */

public void onVoipAudioChanged(android.telecom.RemoteConnection connection, boolean isVoip) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the status hints of this {@code RemoteConnection} have changed. See
 * {@link #getStatusHints()} ()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param statusHints The new status hints of the {@code RemoteConnection}.
 */

public void onStatusHintsChanged(android.telecom.RemoteConnection connection, android.telecom.StatusHints statusHints) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the address (e.g., phone number) of this {@code RemoteConnection} has
 * changed. See {@link #getAddress()} and {@link #getAddressPresentation()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param address The new address of the {@code RemoteConnection}.
 * @param presentation The presentation requirements for the address.
 *        See {@link TelecomManager} for valid values.
 */

public void onAddressChanged(android.telecom.RemoteConnection connection, android.net.Uri address, int presentation) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the caller display name of this {@code RemoteConnection} has changed.
 * See {@link #getCallerDisplayName()} and {@link #getCallerDisplayNamePresentation()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param callerDisplayName The new caller display name of the {@code RemoteConnection}.
 * @param presentation The presentation requirements for the handle.
 *        See {@link TelecomManager} for valid values.
 */

public void onCallerDisplayNameChanged(android.telecom.RemoteConnection connection, java.lang.String callerDisplayName, int presentation) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the video state of this {@code RemoteConnection} has changed.
 * See {@link #getVideoState()}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param videoState The new video state of the {@code RemoteConnection}.
 */

public void onVideoStateChanged(android.telecom.RemoteConnection connection, int videoState) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that this {@code RemoteConnection} has been destroyed. No further requests
 * should be made to the {@code RemoteConnection}, and references to it should be cleared.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 */

public void onDestroyed(android.telecom.RemoteConnection connection) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the {@code RemoteConnection}s with which this {@code RemoteConnection}
 * may be asked to create a conference has changed.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param conferenceableConnections The {@code RemoteConnection}s with which this
 *         {@code RemoteConnection} may be asked to create a conference.
 */

public void onConferenceableConnectionsChanged(android.telecom.RemoteConnection connection, java.util.List<android.telecom.RemoteConnection> conferenceableConnections) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the {@code VideoProvider} associated with this {@code RemoteConnection}
 * has changed.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param videoProvider The new {@code VideoProvider} associated with this
 *         {@code RemoteConnection}.
 */

public void onVideoProviderChanged(android.telecom.RemoteConnection connection, android.telecom.RemoteConnection.VideoProvider videoProvider) { throw new RuntimeException("Stub!"); }

/**
 * Indicates that the {@code RemoteConference} that this {@code RemoteConnection} is a part
 * of has changed.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param conference The {@code RemoteConference} of which this {@code RemoteConnection} is
 *         a part, which may be {@code null}.
 */

public void onConferenceChanged(android.telecom.RemoteConnection connection, android.telecom.RemoteConference conference) { throw new RuntimeException("Stub!"); }

/**
 * Handles changes to the {@code RemoteConnection} extras.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param extras The extras containing other information associated with the connection.

 * This value may be {@code null}.
 */

public void onExtrasChanged(android.telecom.RemoteConnection connection, @androidx.annotation.RecentlyNullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Handles a connection event propagated to this {@link RemoteConnection}.
 * <p>
 * Connection events originate from {@link Connection#sendConnectionEvent(String, Bundle)}.
 *
 * @param connection The {@code RemoteConnection} invoking this method.
 * @param event The connection event.
 * @param extras Extras associated with the event.
 */

public void onConnectionEvent(android.telecom.RemoteConnection connection, java.lang.String event, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }
}

/**
 * {@link RemoteConnection.VideoProvider} associated with a {@link RemoteConnection}.  Used to
 * receive video related events and control the video associated with a
 * {@link RemoteConnection}.
 *
 * @see Connection.VideoProvider
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class VideoProvider {

VideoProvider() { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback to receive commands and state changes for video calls.
 *
 * @param l The video call callback.
 */

public void registerCallback(android.telecom.RemoteConnection.VideoProvider.Callback l) { throw new RuntimeException("Stub!"); }

/**
 * Clears the video call callback set via {@link #registerCallback}.
 *
 * @param l The video call callback to clear.
 */

public void unregisterCallback(android.telecom.RemoteConnection.VideoProvider.Callback l) { throw new RuntimeException("Stub!"); }

/**
 * Sets the camera to be used for the outgoing video for the
 * {@link RemoteConnection.VideoProvider}.
 *
 * @param cameraId The id of the camera (use ids as reported by
 * {@link CameraManager#getCameraIdList()}).
 * @see Connection.VideoProvider#onSetCamera(String)
 */

public void setCamera(java.lang.String cameraId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the surface to be used for displaying a preview of what the user's camera is
 * currently capturing for the {@link RemoteConnection.VideoProvider}.
 *
 * @param surface The {@link Surface}.
 * @see Connection.VideoProvider#onSetPreviewSurface(Surface)
 */

public void setPreviewSurface(android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Sets the surface to be used for displaying the video received from the remote device for
 * the {@link RemoteConnection.VideoProvider}.
 *
 * @param surface The {@link Surface}.
 * @see Connection.VideoProvider#onSetDisplaySurface(Surface)
 */

public void setDisplaySurface(android.view.Surface surface) { throw new RuntimeException("Stub!"); }

/**
 * Sets the device orientation, in degrees, for the {@link RemoteConnection.VideoProvider}.
 * Assumes that a standard portrait orientation of the device is 0 degrees.
 *
 * @param rotation The device orientation, in degrees.
 * @see Connection.VideoProvider#onSetDeviceOrientation(int)
 */

public void setDeviceOrientation(int rotation) { throw new RuntimeException("Stub!"); }

/**
 * Sets camera zoom ratio for the {@link RemoteConnection.VideoProvider}.
 *
 * @param value The camera zoom ratio.
 * @see Connection.VideoProvider#onSetZoom(float)
 */

public void setZoom(float value) { throw new RuntimeException("Stub!"); }

/**
 * Issues a request to modify the properties of the current video session for the
 * {@link RemoteConnection.VideoProvider}.
 *
 * @param fromProfile The video profile prior to the request.
 * @param toProfile The video profile with the requested changes made.
 * @see Connection.VideoProvider#onSendSessionModifyRequest(VideoProfile, VideoProfile)
 */

public void sendSessionModifyRequest(android.telecom.VideoProfile fromProfile, android.telecom.VideoProfile toProfile) { throw new RuntimeException("Stub!"); }

/**
 * Provides a response to a request to change the current call video session
 * properties for the {@link RemoteConnection.VideoProvider}.
 *
 * @param responseProfile The response call video properties.
 * @see Connection.VideoProvider#onSendSessionModifyResponse(VideoProfile)
 */

public void sendSessionModifyResponse(android.telecom.VideoProfile responseProfile) { throw new RuntimeException("Stub!"); }

/**
 * Issues a request to retrieve the capabilities of the current camera for the
 * {@link RemoteConnection.VideoProvider}.
 *
 * @see Connection.VideoProvider#onRequestCameraCapabilities()
 */

public void requestCameraCapabilities() { throw new RuntimeException("Stub!"); }

/**
 * Issues a request to retrieve the data usage (in bytes) of the video portion of the
 * {@link RemoteConnection} for the {@link RemoteConnection.VideoProvider}.
 *
 * @see Connection.VideoProvider#onRequestConnectionDataUsage()
 */

public void requestCallDataUsage() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link Uri} of an image to be displayed to the peer device when the video signal
 * is paused, for the {@link RemoteConnection.VideoProvider}.
 *
 * @see Connection.VideoProvider#onSetPauseImage(Uri)
 */

public void setPauseImage(android.net.Uri uri) { throw new RuntimeException("Stub!"); }
/**
 * Callback class used by the {@link RemoteConnection.VideoProvider} to relay events from
 * the {@link Connection.VideoProvider}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Reports a session modification request received from the
 * {@link Connection.VideoProvider} associated with a {@link RemoteConnection}.
 *
 * @param videoProvider The {@link RemoteConnection.VideoProvider} invoking this method.
 * @param videoProfile The requested video call profile.
 * @see InCallService.VideoCall.Callback#onSessionModifyRequestReceived(VideoProfile)
 * @see Connection.VideoProvider#receiveSessionModifyRequest(VideoProfile)
 */

public void onSessionModifyRequestReceived(android.telecom.RemoteConnection.VideoProvider videoProvider, android.telecom.VideoProfile videoProfile) { throw new RuntimeException("Stub!"); }

/**
 * Reports a session modification response received from the
 * {@link Connection.VideoProvider} associated with a {@link RemoteConnection}.
 *
 * @param videoProvider The {@link RemoteConnection.VideoProvider} invoking this method.
 * @param status Status of the session modify request.
 * @param requestedProfile The original request which was sent to the peer device.
 * @param responseProfile The actual profile changes made by the peer device.
 * @see InCallService.VideoCall.Callback#onSessionModifyResponseReceived(int,
 *      VideoProfile, VideoProfile)
 * @see Connection.VideoProvider#receiveSessionModifyResponse(int, VideoProfile,
 *      VideoProfile)
 */

public void onSessionModifyResponseReceived(android.telecom.RemoteConnection.VideoProvider videoProvider, int status, android.telecom.VideoProfile requestedProfile, android.telecom.VideoProfile responseProfile) { throw new RuntimeException("Stub!"); }

/**
 * Reports a call session event received from the {@link Connection.VideoProvider}
 * associated with a {@link RemoteConnection}.
 *
 * @param videoProvider The {@link RemoteConnection.VideoProvider} invoking this method.
 * @param event The event.
 * @see InCallService.VideoCall.Callback#onCallSessionEvent(int)
 * @see Connection.VideoProvider#handleCallSessionEvent(int)
 */

public void onCallSessionEvent(android.telecom.RemoteConnection.VideoProvider videoProvider, int event) { throw new RuntimeException("Stub!"); }

/**
 * Reports a change in the peer video dimensions received from the
 * {@link Connection.VideoProvider} associated with a {@link RemoteConnection}.
 *
 * @param videoProvider The {@link RemoteConnection.VideoProvider} invoking this method.
 * @param width  The updated peer video width.
 * @param height The updated peer video height.
 * @see InCallService.VideoCall.Callback#onPeerDimensionsChanged(int, int)
 * @see Connection.VideoProvider#changePeerDimensions(int, int)
 */

public void onPeerDimensionsChanged(android.telecom.RemoteConnection.VideoProvider videoProvider, int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Reports a change in the data usage (in bytes) received from the
 * {@link Connection.VideoProvider} associated with a {@link RemoteConnection}.
 *
 * @param videoProvider The {@link RemoteConnection.VideoProvider} invoking this method.
 * @param dataUsage The updated data usage (in bytes).
 * @see InCallService.VideoCall.Callback#onCallDataUsageChanged(long)
 * @see Connection.VideoProvider#setCallDataUsage(long)
 */

public void onCallDataUsageChanged(android.telecom.RemoteConnection.VideoProvider videoProvider, long dataUsage) { throw new RuntimeException("Stub!"); }

/**
 * Reports a change in the capabilities of the current camera, received from the
 * {@link Connection.VideoProvider} associated with a {@link RemoteConnection}.
 *
 * @param videoProvider The {@link RemoteConnection.VideoProvider} invoking this method.
 * @param cameraCapabilities The changed camera capabilities.
 * @see InCallService.VideoCall.Callback#onCameraCapabilitiesChanged(
 *      VideoProfile.CameraCapabilities)
 * @see Connection.VideoProvider#changeCameraCapabilities(
 *      VideoProfile.CameraCapabilities)
 */

public void onCameraCapabilitiesChanged(android.telecom.RemoteConnection.VideoProvider videoProvider, android.telecom.VideoProfile.CameraCapabilities cameraCapabilities) { throw new RuntimeException("Stub!"); }

/**
 * Reports a change in the video quality received from the
 * {@link Connection.VideoProvider} associated with a {@link RemoteConnection}.
 *
 * @param videoProvider The {@link RemoteConnection.VideoProvider} invoking this method.
 * @param videoQuality  The updated peer video quality.
 * @see InCallService.VideoCall.Callback#onVideoQualityChanged(int)
 * @see Connection.VideoProvider#changeVideoQuality(int)
 */

public void onVideoQualityChanged(android.telecom.RemoteConnection.VideoProvider videoProvider, int videoQuality) { throw new RuntimeException("Stub!"); }
}

}

}

