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

import android.bluetooth.BluetoothDevice;
import java.util.List;
import android.os.Parcel;

/**
 *  Encapsulates the telecom audio state, including the current audio routing, supported audio
 *  routing and mute.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CallAudioState implements android.os.Parcelable {

/**
 * Constructor for a {@link CallAudioState} object.
 *
 * @param muted {@code true} if the call is muted, {@code false} otherwise.
 * @param route The current audio route being used.
 * Allowed values:
 * {@link #ROUTE_EARPIECE}
 * {@link #ROUTE_BLUETOOTH}
 * {@link #ROUTE_WIRED_HEADSET}
 * {@link #ROUTE_SPEAKER}
 * Value is either <code>0</code> or a combination of {@link android.telecom.CallAudioState#ROUTE_EARPIECE}, {@link android.telecom.CallAudioState#ROUTE_BLUETOOTH}, {@link android.telecom.CallAudioState#ROUTE_WIRED_HEADSET}, and {@link android.telecom.CallAudioState#ROUTE_SPEAKER}
 * @param supportedRouteMask Bit mask of all routes supported by this call. This should be a
 * bitwise combination of the following values:
 * {@link #ROUTE_EARPIECE}
 * {@link #ROUTE_BLUETOOTH}
 * {@link #ROUTE_WIRED_HEADSET}
 * {@link #ROUTE_SPEAKER}

 * Value is either <code>0</code> or a combination of {@link android.telecom.CallAudioState#ROUTE_EARPIECE}, {@link android.telecom.CallAudioState#ROUTE_BLUETOOTH}, {@link android.telecom.CallAudioState#ROUTE_WIRED_HEADSET}, and {@link android.telecom.CallAudioState#ROUTE_SPEAKER}
 */

public CallAudioState(boolean muted, int route, int supportedRouteMask) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * @return {@code true} if the call is muted, {@code false} otherwise.
 */

public boolean isMuted() { throw new RuntimeException("Stub!"); }

/**
 * @return The current audio route being used.

 * Value is either <code>0</code> or a combination of {@link android.telecom.CallAudioState#ROUTE_EARPIECE}, {@link android.telecom.CallAudioState#ROUTE_BLUETOOTH}, {@link android.telecom.CallAudioState#ROUTE_WIRED_HEADSET}, and {@link android.telecom.CallAudioState#ROUTE_SPEAKER}
 */

public int getRoute() { throw new RuntimeException("Stub!"); }

/**
 * @return Bit mask of all routes supported by this call.

 * Value is either <code>0</code> or a combination of {@link android.telecom.CallAudioState#ROUTE_EARPIECE}, {@link android.telecom.CallAudioState#ROUTE_BLUETOOTH}, {@link android.telecom.CallAudioState#ROUTE_WIRED_HEADSET}, and {@link android.telecom.CallAudioState#ROUTE_SPEAKER}
 */

public int getSupportedRouteMask() { throw new RuntimeException("Stub!"); }

/**
 * @return The {@link BluetoothDevice} through which audio is being routed.
 *         Will not be {@code null} if {@link #getRoute()} returns {@link #ROUTE_BLUETOOTH}.
 */

public android.bluetooth.BluetoothDevice getActiveBluetoothDevice() { throw new RuntimeException("Stub!"); }

/**
 * @return {@link List} of {@link BluetoothDevice}s that can be used for this call.
 */

public java.util.Collection<android.bluetooth.BluetoothDevice> getSupportedBluetoothDevices() { throw new RuntimeException("Stub!"); }

/**
 * Converts the provided audio route into a human readable string representation.
 *
 * @param route to convert into a string.
 *
 * @return String representation of the provided audio route.
 */

public static java.lang.String audioRouteToString(int route) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Writes AudioState object into a serializeable Parcel.
 */

public void writeToParcel(android.os.Parcel destination, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Responsible for creating AudioState objects for deserialized Parcels.
 */

public static final android.os.Parcelable.Creator<android.telecom.CallAudioState> CREATOR;
static { CREATOR = null; }

/** Direct the audio stream through Bluetooth. */

public static final int ROUTE_BLUETOOTH = 2; // 0x2

/** Direct the audio stream through the device's earpiece. */

public static final int ROUTE_EARPIECE = 1; // 0x1

/** Direct the audio stream through the device's speakerphone. */

public static final int ROUTE_SPEAKER = 8; // 0x8

/** Direct the audio stream through a wired headset. */

public static final int ROUTE_WIRED_HEADSET = 4; // 0x4

/**
 * Direct the audio stream through the device's earpiece or wired headset if one is
 * connected.
 */

public static final int ROUTE_WIRED_OR_EARPIECE = 5; // 0x5
}

