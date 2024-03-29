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


package android.hardware.usb;


/**
 * This class represents a USB device attached to the android device with the android device
 * acting as the USB host.
 * Each device contains one or more {@link UsbInterface}s, each of which contains a number of
 * {@link UsbEndpoint}s (the channels via which data is transmitted over USB).
 *
 * <p> This class contains information (along with {@link UsbInterface} and {@link UsbEndpoint})
 * that describes the capabilities of the USB device.
 * To communicate with the device, you open a {@link UsbDeviceConnection} for the device
 * and use {@link UsbRequest} to send and receive data on an endpoint.
 * {@link UsbDeviceConnection#controlTransfer} is used for control requests on endpoint zero.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about communicating with USB hardware, read the
 * <a href="{@docRoot}guide/topics/connectivity/usb/index.html">USB</a> developer guide.</p>
 * </div>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UsbDevice implements android.os.Parcelable {

/**
 * UsbDevice should only be instantiated by UsbService implementation
 * @hide
 */

UsbDevice(java.lang.String name, int vendorId, int productId, int Class, int subClass, int protocol, java.lang.String manufacturerName, java.lang.String productName, java.lang.String version, java.lang.String serialNumber) { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the device.
 * In the standard implementation, this is the path of the device file
 * for the device in the usbfs file system.
 *
 * @return the device name

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getDeviceName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the manufacturer name of the device.
 *
 * @return the manufacturer name, or {@code null} if the property could not be read
 */

@androidx.annotation.RecentlyNullable public java.lang.String getManufacturerName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the product name of the device.
 *
 * @return the product name, or {@code null} if the property could not be read
 */

@androidx.annotation.RecentlyNullable public java.lang.String getProductName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the version number of the device.
 *
 * @return the device version

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getVersion() { throw new RuntimeException("Stub!"); }

/**
 * Returns the serial number of the device.
 *
 * @return the serial number name, or {@code null} if the property could not be read
 */

@androidx.annotation.RecentlyNullable public java.lang.String getSerialNumber() { throw new RuntimeException("Stub!"); }

/**
 * Returns a unique integer ID for the device.
 * This is a convenience for clients that want to use an integer to represent
 * the device, rather than the device name.
 * IDs are not persistent across USB disconnects.
 *
 * @return the device ID
 */

public int getDeviceId() { throw new RuntimeException("Stub!"); }

/**
 * Returns a vendor ID for the device.
 *
 * @return the device vendor ID
 */

public int getVendorId() { throw new RuntimeException("Stub!"); }

/**
 * Returns a product ID for the device.
 *
 * @return the device product ID
 */

public int getProductId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the devices's class field.
 * Some useful constants for USB device classes can be found in {@link UsbConstants}.
 *
 * @return the devices's class
 */

public int getDeviceClass() { throw new RuntimeException("Stub!"); }

/**
 * Returns the device's subclass field.
 *
 * @return the device's subclass
 */

public int getDeviceSubclass() { throw new RuntimeException("Stub!"); }

/**
 * Returns the device's protocol field.
 *
 * @return the device's protocol
 */

public int getDeviceProtocol() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of {@link UsbConfiguration}s this device contains.
 *
 * @return the number of configurations
 */

public int getConfigurationCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link UsbConfiguration} at the given index.
 *
 * @return the configuration

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.hardware.usb.UsbConfiguration getConfiguration(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of {@link UsbInterface}s this device contains.
 * For devices with multiple configurations, you will probably want to use
 * {@link UsbConfiguration#getInterfaceCount} instead.
 *
 * @return the number of interfaces
 */

public int getInterfaceCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link UsbInterface} at the given index.
 * For devices with multiple configurations, you will probably want to use
 * {@link UsbConfiguration#getInterface} instead.
 *
 * @return the interface

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.hardware.usb.UsbInterface getInterface(int index) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static int getDeviceId(java.lang.String name) { throw new RuntimeException("Stub!"); }

public static java.lang.String getDeviceName(int id) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.hardware.usb.UsbDevice> CREATOR;
static { CREATOR = null; }
}

