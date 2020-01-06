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


package android.hardware.usb;


/**
 * A class representing a configuration on a {@link UsbDevice}.
 * A USB configuration can have one or more interfaces, each one providing a different
 * piece of functionality, separate from the other interfaces.
 * An interface will have one or more {@link UsbEndpoint}s, which are the
 * channels by which the host transfers data with the device.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about communicating with USB hardware, read the
 * <a href="{@docRoot}guide/topics/usb/index.html">USB</a> developer guide.</p>
 * </div>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UsbConfiguration implements android.os.Parcelable {

/**
 * UsbConfiguration should only be instantiated by UsbService implementation
 * @hide
 */

UsbConfiguration(int id, java.lang.String name, int attributes, int maxPower) { throw new RuntimeException("Stub!"); }

/**
 * Returns the configuration's ID field.
 * This is an integer that uniquely identifies the configuration on the device.
 *
 * @return the configuration's ID
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configuration's name.
 *
 * @return the configuration's name, or {@code null} if the property could not be read
 */

@androidx.annotation.RecentlyNullable public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the self-powered attribute value configuration's attributes field.
 * This attribute indicates that the device has a power source other than the USB connection.
 *
 * @return the configuration's self-powered attribute
 */

public boolean isSelfPowered() { throw new RuntimeException("Stub!"); }

/**
 * Returns the remote-wakeup attribute value configuration's attributes field.
 * This attributes that the device may signal the host to wake from suspend.
 *
 * @return the configuration's remote-wakeup attribute
 */

public boolean isRemoteWakeup() { throw new RuntimeException("Stub!"); }

/**
 * Returns the configuration's max power consumption, in milliamps.
 *
 * @return the configuration's max power
 */

public int getMaxPower() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of {@link UsbInterface}s this configuration contains.
 *
 * @return the number of endpoints
 */

public int getInterfaceCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link UsbInterface} at the given index.
 *
 * @return the interface

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.hardware.usb.UsbInterface getInterface(int index) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.hardware.usb.UsbConfiguration> CREATOR;
static { CREATOR = null; }
}

