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


package android.net.sip;

import android.net.rtp.AudioStream;
import android.net.rtp.AudioGroup;
import android.os.Message;

/**
 * Handles an Internet audio call over SIP. You can instantiate this class with {@link SipManager},
 * using {@link SipManager#makeAudioCall makeAudioCall()} and  {@link SipManager#takeAudioCall
 * takeAudioCall()}.
 *
 * <p class="note"><strong>Note:</strong> Using this class require the
 *   {@link android.Manifest.permission#INTERNET} and
 *   {@link android.Manifest.permission#USE_SIP} permissions. In addition, {@link
 *   #startAudio} requires the
 *   {@link android.Manifest.permission#RECORD_AUDIO},
 *   {@link android.Manifest.permission#ACCESS_WIFI_STATE}, and
 *   {@link android.Manifest.permission#WAKE_LOCK} permissions; and {@link #setSpeakerMode
 *   setSpeakerMode()} requires the
 *   {@link android.Manifest.permission#MODIFY_AUDIO_SETTINGS} permission.</p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about using SIP, read the
 * <a href="{@docRoot}guide/topics/network/sip.html">Session Initiation Protocol</a>
 * developer guide.</p>
 * </div>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SipAudioCall {

/**
 * Creates a call object with the local SIP profile.
 * @param context the context for accessing system services such as
 *        ringtone, audio, WIFI etc
 */

public SipAudioCall(android.content.Context context, android.net.sip.SipProfile localProfile) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to listen to the audio call events. The method calls
 * {@link #setListener setListener(listener, false)}.
 *
 * @param listener to listen to the audio call events of this object
 * @see #setListener(Listener, boolean)
 */

public void setListener(android.net.sip.SipAudioCall.Listener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets the listener to listen to the audio call events. A
 * {@link SipAudioCall} can only hold one listener at a time. Subsequent
 * calls to this method override the previous listener.
 *
 * @param listener to listen to the audio call events of this object
 * @param callbackImmediately set to true if the caller wants to be called
 *      back immediately on the current state
 */

public void setListener(android.net.sip.SipAudioCall.Listener listener, boolean callbackImmediately) { throw new RuntimeException("Stub!"); }

/**
 * Checks if the call is established.
 *
 * @return true if the call is established
 */

public boolean isInCall() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the call is on hold.
 *
 * @return true if the call is on hold
 */

public boolean isOnHold() { throw new RuntimeException("Stub!"); }

/**
 * Closes this object. This object is not usable after being closed.
 */

public void close() { throw new RuntimeException("Stub!"); }

/**
 * Gets the local SIP profile.
 *
 * @return the local SIP profile
 */

public android.net.sip.SipProfile getLocalProfile() { throw new RuntimeException("Stub!"); }

/**
 * Gets the peer's SIP profile.
 *
 * @return the peer's SIP profile
 */

public android.net.sip.SipProfile getPeerProfile() { throw new RuntimeException("Stub!"); }

/**
 * Gets the state of the {@link SipSession} that carries this call.
 * The value returned must be one of the states in {@link SipSession.State}.
 *
 * @return the session state
 */

public int getState() { throw new RuntimeException("Stub!"); }

/**
 * Attaches an incoming call to this call object.
 *
 * @param session the session that receives the incoming call
 * @param sessionDescription the session description of the incoming call
 * @throws SipException if the SIP service fails to attach this object to
 *        the session or VOIP API is not supported by the device
 * @see SipManager#isVoipSupported
 */

public void attachCall(android.net.sip.SipSession session, java.lang.String sessionDescription) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Initiates an audio call to the specified profile. The attempt will be
 * timed out if the call is not established within {@code timeout} seconds
 * and {@link Listener#onError onError(SipAudioCall, SipErrorCode.TIME_OUT, String)}
 * will be called.
 *
 * @param peerProfile the SIP profile to make the call to
 * @param sipSession the {@link SipSession} for carrying out the call
 * @param timeout the timeout value in seconds. Default value (defined by
 *        SIP protocol) is used if {@code timeout} is zero or negative.
 * @see Listener#onError
 * @throws SipException if the SIP service fails to create a session for the
 *        call or VOIP API is not supported by the device
 * @see SipManager#isVoipSupported
 */

public void makeCall(android.net.sip.SipProfile peerProfile, android.net.sip.SipSession sipSession, int timeout) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Ends a call.
 * @throws SipException if the SIP service fails to end the call
 */

public void endCall() throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Puts a call on hold.  When succeeds, {@link Listener#onCallHeld} is
 * called. The attempt will be timed out if the call is not established
 * within {@code timeout} seconds and
 * {@link Listener#onError onError(SipAudioCall, SipErrorCode.TIME_OUT, String)}
 * will be called.
 *
 * @param timeout the timeout value in seconds. Default value (defined by
 *        SIP protocol) is used if {@code timeout} is zero or negative.
 * @see Listener#onError
 * @throws SipException if the SIP service fails to hold the call
 */

public void holdCall(int timeout) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Answers a call. The attempt will be timed out if the call is not
 * established within {@code timeout} seconds and
 * {@link Listener#onError onError(SipAudioCall, SipErrorCode.TIME_OUT, String)}
 * will be called.
 *
 * @param timeout the timeout value in seconds. Default value (defined by
 *        SIP protocol) is used if {@code timeout} is zero or negative.
 * @see Listener#onError
 * @throws SipException if the SIP service fails to answer the call
 */

public void answerCall(int timeout) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/**
 * Continues a call that's on hold. When succeeds,
 * {@link Listener#onCallEstablished} is called. The attempt will be timed
 * out if the call is not established within {@code timeout} seconds and
 * {@link Listener#onError onError(SipAudioCall, SipErrorCode.TIME_OUT, String)}
 * will be called.
 *
 * @param timeout the timeout value in seconds. Default value (defined by
 *        SIP protocol) is used if {@code timeout} is zero or negative.
 * @see Listener#onError
 * @throws SipException if the SIP service fails to unhold the call
 */

public void continueCall(int timeout) throws android.net.sip.SipException { throw new RuntimeException("Stub!"); }

/** Toggles mute. */

public void toggleMute() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the call is muted.
 *
 * @return true if the call is muted
 */

public boolean isMuted() { throw new RuntimeException("Stub!"); }

/**
 * Puts the device to speaker mode.
 * <p class="note"><strong>Note:</strong> Requires the
 *   {@link android.Manifest.permission#MODIFY_AUDIO_SETTINGS} permission.</p>
 *
 * @param speakerMode set true to enable speaker mode; false to disable
 */

public void setSpeakerMode(boolean speakerMode) { throw new RuntimeException("Stub!"); }

/**
 * Sends a DTMF code. According to <a href="http://tools.ietf.org/html/rfc2833">RFC 2883</a>,
 * event 0--9 maps to decimal
 * value 0--9, '*' to 10, '#' to 11, event 'A'--'D' to 12--15, and event
 * flash to 16. Currently, event flash is not supported.
 *
 * @param code the DTMF code to send. Value 0 to 15 (inclusive) are valid
 *        inputs.
 */

public void sendDtmf(int code) { throw new RuntimeException("Stub!"); }

/**
 * Sends a DTMF code. According to <a href="http://tools.ietf.org/html/rfc2833">RFC 2883</a>,
 * event 0--9 maps to decimal
 * value 0--9, '*' to 10, '#' to 11, event 'A'--'D' to 12--15, and event
 * flash to 16. Currently, event flash is not supported.
 *
 * @param code the DTMF code to send. Value 0 to 15 (inclusive) are valid
 *        inputs.
 * @param result the result message to send when done
 */

public void sendDtmf(int code, android.os.Message result) { throw new RuntimeException("Stub!"); }

/**
 * Starts the audio for the established call. This method should be called
 * after {@link Listener#onCallEstablished} is called.
 * <p class="note"><strong>Note:</strong> Requires the
 *   {@link android.Manifest.permission#RECORD_AUDIO},
 *   {@link android.Manifest.permission#ACCESS_WIFI_STATE} and
 *   {@link android.Manifest.permission#WAKE_LOCK} permissions.</p>
 */

public void startAudio() { throw new RuntimeException("Stub!"); }
/** Listener for events relating to a SIP call, such as when a call is being
 * recieved ("on ringing") or a call is outgoing ("on calling").
 * <p>Many of these events are also received by {@link SipSession.Listener}.</p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Listener {

public Listener() { throw new RuntimeException("Stub!"); }

/**
 * Called when the call object is ready to make another call.
 * The default implementation calls {@link #onChanged}.
 *
 * @param call the call object that is ready to make another call
 */

public void onReadyToCall(android.net.sip.SipAudioCall call) { throw new RuntimeException("Stub!"); }

/**
 * Called when a request is sent out to initiate a new call.
 * The default implementation calls {@link #onChanged}.
 *
 * @param call the call object that carries out the audio call
 */

public void onCalling(android.net.sip.SipAudioCall call) { throw new RuntimeException("Stub!"); }

/**
 * Called when a new call comes in.
 * The default implementation calls {@link #onChanged}.
 *
 * @param call the call object that carries out the audio call
 * @param caller the SIP profile of the caller
 */

public void onRinging(android.net.sip.SipAudioCall call, android.net.sip.SipProfile caller) { throw new RuntimeException("Stub!"); }

/**
 * Called when a RINGING response is received for the INVITE request
 * sent. The default implementation calls {@link #onChanged}.
 *
 * @param call the call object that carries out the audio call
 */

public void onRingingBack(android.net.sip.SipAudioCall call) { throw new RuntimeException("Stub!"); }

/**
 * Called when the session is established.
 * The default implementation calls {@link #onChanged}.
 *
 * @param call the call object that carries out the audio call
 */

public void onCallEstablished(android.net.sip.SipAudioCall call) { throw new RuntimeException("Stub!"); }

/**
 * Called when the session is terminated.
 * The default implementation calls {@link #onChanged}.
 *
 * @param call the call object that carries out the audio call
 */

public void onCallEnded(android.net.sip.SipAudioCall call) { throw new RuntimeException("Stub!"); }

/**
 * Called when the peer is busy during session initialization.
 * The default implementation calls {@link #onChanged}.
 *
 * @param call the call object that carries out the audio call
 */

public void onCallBusy(android.net.sip.SipAudioCall call) { throw new RuntimeException("Stub!"); }

/**
 * Called when the call is on hold.
 * The default implementation calls {@link #onChanged}.
 *
 * @param call the call object that carries out the audio call
 */

public void onCallHeld(android.net.sip.SipAudioCall call) { throw new RuntimeException("Stub!"); }

/**
 * Called when an error occurs. The default implementation is no op.
 *
 * @param call the call object that carries out the audio call
 * @param errorCode error code of this error
 * @param errorMessage error message
 * @see SipErrorCode
 */

public void onError(android.net.sip.SipAudioCall call, int errorCode, java.lang.String errorMessage) { throw new RuntimeException("Stub!"); }

/**
 * Called when an event occurs and the corresponding callback is not
 * overridden. The default implementation is no op. Error events are
 * not re-directed to this callback and are handled in {@link #onError}.
 */

public void onChanged(android.net.sip.SipAudioCall call) { throw new RuntimeException("Stub!"); }
}

}

