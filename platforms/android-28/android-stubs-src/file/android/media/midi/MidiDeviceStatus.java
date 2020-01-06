/*
 * Copyright (C) 2015 The Android Open Source Project
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


package android.media.midi;


/**
 * This is an immutable class that describes the current status of a MIDI device's ports.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MidiDeviceStatus implements android.os.Parcelable {

/**
 * Creates a MidiDeviceStatus with zero for all port open counts
 * @hide
 */

MidiDeviceStatus(android.media.midi.MidiDeviceInfo deviceInfo) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link MidiDeviceInfo} of the device.
 *
 * @return the device info
 */

public android.media.midi.MidiDeviceInfo getDeviceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if an input port is open.
 * An input port can only be opened by one client at a time.
 *
 * @param portNumber the input port's port number
 * @return input port open status
 */

public boolean isInputPortOpen(int portNumber) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of clients currently connected to the specified output port.
 * Unlike input ports, an output port can be opened by multiple clients at the same time.
 *
 * @param portNumber the output port's port number
 * @return output port open count
 */

public int getOutputPortOpenCount(int portNumber) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.media.midi.MidiDeviceStatus> CREATOR;
static { CREATOR = null; }
}

