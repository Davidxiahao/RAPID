/*
 * Copyright (C) 2016 The Android Open Source Project
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


package android.bluetooth;


/**
 * Represents the Service Discovery Protocol (SDP) settings for a Bluetooth HID Device application.
 *
 * <p>The BluetoothHidDevice framework adds the SDP record during app registration, so that the
 * Android device can be discovered as a Bluetooth HID Device.
 *
 * <p>{@see BluetoothHidDevice}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothHidDeviceAppSdpSettings implements android.os.Parcelable {

/**
 * Create a BluetoothHidDeviceAppSdpSettings object for the Bluetooth SDP record.
 *
 * @param name Name of this Bluetooth HID device. Maximum length is 50 bytes.
 * @param description Description for this Bluetooth HID device. Maximum length is 50 bytes.
 * @param provider Provider of this Bluetooth HID device. Maximum length is 50 bytes.
 * @param subclass Subclass of this Bluetooth HID device. See <a
 *     href="www.usb.org/developers/hidpage/HID1_11.pdf">
 *     www.usb.org/developers/hidpage/HID1_11.pdf Section 4.2</a>
 * @param descriptors Descriptors of this Bluetooth HID device. See <a
 *     href="www.usb.org/developers/hidpage/HID1_11.pdf">
 *     www.usb.org/developers/hidpage/HID1_11.pdf Chapter 6</a> Maximum length is 2048 bytes.
 */

public BluetoothHidDeviceAppSdpSettings(java.lang.String name, java.lang.String description, java.lang.String provider, byte subclass, byte[] descriptors) { throw new RuntimeException("Stub!"); }

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

public java.lang.String getDescription() { throw new RuntimeException("Stub!"); }

public java.lang.String getProvider() { throw new RuntimeException("Stub!"); }

public byte getSubclass() { throw new RuntimeException("Stub!"); }

public byte[] getDescriptors() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.bluetooth.BluetoothHidDeviceAppSdpSettings> CREATOR;
static { CREATOR = null; }
}

