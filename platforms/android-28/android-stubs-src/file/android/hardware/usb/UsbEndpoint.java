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
 * A class representing an endpoint on a {@link UsbInterface}.
 * Endpoints are the channels for sending and receiving data over USB.
 * Typically bulk endpoints are used for sending non-trivial amounts of data.
 * Interrupt endpoints are used for sending small amounts of data, typically events,
 * separately from the main data streams.
 * The endpoint zero is a special endpoint for control messages sent from the host
 * to device.
 * Isochronous endpoints are currently unsupported.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UsbEndpoint implements android.os.Parcelable {

/**
 * UsbEndpoint should only be instantiated by UsbService implementation
 * @hide
 */

UsbEndpoint(int address, int attributes, int maxPacketSize, int interval) { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint's address field.
 * The address is a bitfield containing both the endpoint number
 * as well as the data direction of the endpoint.
 * the endpoint number and direction can also be accessed via
 * {@link #getEndpointNumber} and {@link #getDirection}.
 *
 * @return the endpoint's address
 */

public int getAddress() { throw new RuntimeException("Stub!"); }

/**
 * Extracts the endpoint's endpoint number from its address
 *
 * @return the endpoint's endpoint number
 */

public int getEndpointNumber() { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint's direction.
 * Returns {@link UsbConstants#USB_DIR_OUT}
 * if the direction is host to device, and
 * {@link UsbConstants#USB_DIR_IN} if the
 * direction is device to host.
 * @see UsbConstants#USB_DIR_IN
 * @see UsbConstants#USB_DIR_OUT
 *
 * @return the endpoint's direction
 */

public int getDirection() { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint's attributes field.
 *
 * @return the endpoint's attributes
 */

public int getAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint's type.
 * Possible results are:
 * <ul>
 * <li>{@link UsbConstants#USB_ENDPOINT_XFER_CONTROL} (endpoint zero)
 * <li>{@link UsbConstants#USB_ENDPOINT_XFER_ISOC} (isochronous endpoint)
 * <li>{@link UsbConstants#USB_ENDPOINT_XFER_BULK} (bulk endpoint)
 * <li>{@link UsbConstants#USB_ENDPOINT_XFER_INT} (interrupt endpoint)
 * </ul>
 *
 * @return the endpoint's type
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint's maximum packet size.
 *
 * @return the endpoint's maximum packet size
 */

public int getMaxPacketSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the endpoint's interval field.
 *
 * @return the endpoint's interval
 */

public int getInterval() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.hardware.usb.UsbEndpoint> CREATOR;
static { CREATOR = null; }
}

