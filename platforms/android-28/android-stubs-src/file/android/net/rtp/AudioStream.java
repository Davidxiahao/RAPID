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


package android.net.rtp;

import java.net.SocketException;

/**
 * An AudioStream is a {@link RtpStream} which carrys audio payloads over
 * Real-time Transport Protocol (RTP). Two different classes are developed in
 * order to support various usages such as audio conferencing. An AudioStream
 * represents a remote endpoint which consists of a network mapping and a
 * configured {@link AudioCodec}. On the other side, An {@link AudioGroup}
 * represents a local endpoint which mixes all the AudioStreams and optionally
 * interacts with the speaker and the microphone at the same time. The simplest
 * usage includes one for each endpoints. For other combinations, developers
 * should be aware of the limitations described in {@link AudioGroup}.
 *
 * <p>An AudioStream becomes busy when it joins an AudioGroup. In this case most
 * of the setter methods are disabled. This is designed to ease the task of
 * managing native resources. One can always make an AudioStream leave its
 * AudioGroup by calling {@link #join(AudioGroup)} with {@code null} and put it
 * back after the modification is done.</p>
 *
 * <p class="note">Using this class requires
 * {@link android.Manifest.permission#INTERNET} permission.</p>
 *
 * @see RtpStream
 * @see AudioGroup
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AudioStream extends android.net.rtp.RtpStream {

/**
 * Creates an AudioStream on the given local address. Note that the local
 * port is assigned automatically to conform with RFC 3550.
 *
 * @param address The network address of the local host to bind to.
 * @throws SocketException if the address cannot be bound or a problem
 *     occurs during binding.
 */

public AudioStream(java.net.InetAddress address) throws java.net.SocketException { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the stream has already joined an
 * {@link AudioGroup}.
 */

public final boolean isBusy() { throw new RuntimeException("Stub!"); }

/**
 * Returns the joined {@link AudioGroup}.
 */

public android.net.rtp.AudioGroup getGroup() { throw new RuntimeException("Stub!"); }

/**
 * Joins an {@link AudioGroup}. Each stream can join only one group at a
 * time. The group can be changed by passing a different one or removed
 * by calling this method with {@code null}.
 *
 * @param group The AudioGroup to join or {@code null} to leave.
 * @throws IllegalStateException if the stream is not properly configured.
 * @see AudioGroup
 */

public void join(android.net.rtp.AudioGroup group) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link AudioCodec}, or {@code null} if it is not set.
 *
 * @see #setCodec(AudioCodec)
 */

public android.net.rtp.AudioCodec getCodec() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link AudioCodec}.
 *
 * @param codec The AudioCodec to be used.
 * @throws IllegalArgumentException if its type is used by DTMF.
 * @throws IllegalStateException if the stream is busy.
 */

public void setCodec(android.net.rtp.AudioCodec codec) { throw new RuntimeException("Stub!"); }

/**
 * Returns the RTP payload type for dual-tone multi-frequency (DTMF) digits,
 * or {@code -1} if it is not enabled.
 *
 * @see #setDtmfType(int)
 */

public int getDtmfType() { throw new RuntimeException("Stub!"); }

/**
 * Sets the RTP payload type for dual-tone multi-frequency (DTMF) digits.
 * The primary usage is to send digits to the remote gateway to perform
 * certain tasks, such as second-stage dialing. According to RFC 2833, the
 * RTP payload type for DTMF is assigned dynamically, so it must be in the
 * range of 96 and 127. One can use {@code -1} to disable DTMF and free up
 * the previous assigned type. This method cannot be called when the stream
 * already joined an {@link AudioGroup}.
 *
 * @param type The RTP payload type to be used or {@code -1} to disable it.
 * @throws IllegalArgumentException if the type is invalid or used by codec.
 * @throws IllegalStateException if the stream is busy.
 * @see AudioGroup#sendDtmf(int)
 */

public void setDtmfType(int type) { throw new RuntimeException("Stub!"); }
}

