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
 * Contains constants for the USB protocol.
 * These constants correspond to definitions in linux/usb/ch9.h in the linux kernel.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UsbConstants {

public UsbConstants() { throw new RuntimeException("Stub!"); }

/**
 * Application specific USB class.
 */

public static final int USB_CLASS_APP_SPEC = 254; // 0xfe

/**
 * USB class for audio devices.
 */

public static final int USB_CLASS_AUDIO = 1; // 0x1

/**
 * USB class for CDC devices (communications device class).
 */

public static final int USB_CLASS_CDC_DATA = 10; // 0xa

/**
 * USB class for communication devices.
 */

public static final int USB_CLASS_COMM = 2; // 0x2

/**
 * USB class for content security devices.
 */

public static final int USB_CLASS_CONTENT_SEC = 13; // 0xd

/**
 * USB class for content smart card devices.
 */

public static final int USB_CLASS_CSCID = 11; // 0xb

/**
 * USB class for human interface devices (for example, mice and keyboards).
 */

public static final int USB_CLASS_HID = 3; // 0x3

/**
 * USB class for USB hubs.
 */

public static final int USB_CLASS_HUB = 9; // 0x9

/**
 * USB class for mass storage devices.
 */

public static final int USB_CLASS_MASS_STORAGE = 8; // 0x8

/**
 * USB class for wireless miscellaneous devices.
 */

public static final int USB_CLASS_MISC = 239; // 0xef

/**
 * USB class indicating that the class is determined on a per-interface basis.
 */

public static final int USB_CLASS_PER_INTERFACE = 0; // 0x0

/**
 * USB class for physical devices.
 */

public static final int USB_CLASS_PHYSICA = 5; // 0x5

/**
 * USB class for printers.
 */

public static final int USB_CLASS_PRINTER = 7; // 0x7

/**
 * USB class for still image devices (digital cameras).
 */

public static final int USB_CLASS_STILL_IMAGE = 6; // 0x6

/**
 * Vendor specific USB class.
 */

public static final int USB_CLASS_VENDOR_SPEC = 255; // 0xff

/**
 * USB class for video devices.
 */

public static final int USB_CLASS_VIDEO = 14; // 0xe

/**
 * USB class for wireless controller devices.
 */

public static final int USB_CLASS_WIRELESS_CONTROLLER = 224; // 0xe0

/**
 * Used to signify direction of data for a {@link UsbEndpoint} is IN (device to host)
 * @see UsbEndpoint#getDirection
 */

public static final int USB_DIR_IN = 128; // 0x80

/**
 * Used to signify direction of data for a {@link UsbEndpoint} is OUT (host to device)
 * @see UsbEndpoint#getDirection
 */

public static final int USB_DIR_OUT = 0; // 0x0

/**
 * Bitmask used for extracting the {@link UsbEndpoint} direction from its address field.
 * @see UsbEndpoint#getAddress
 * @see UsbEndpoint#getDirection
 * @see #USB_DIR_OUT
 * @see #USB_DIR_IN
 *
 */

public static final int USB_ENDPOINT_DIR_MASK = 128; // 0x80

/**
 * Bitmask used for extracting the {@link UsbEndpoint} number its address field.
 * @see UsbEndpoint#getAddress
 * @see UsbEndpoint#getEndpointNumber
 */

public static final int USB_ENDPOINT_NUMBER_MASK = 15; // 0xf

/**
 * Bitmask used for extracting the {@link UsbEndpoint} type from its address field.
 * @see UsbEndpoint#getAddress
 * @see UsbEndpoint#getType
 * @see #USB_ENDPOINT_XFER_CONTROL
 * @see #USB_ENDPOINT_XFER_ISOC
 * @see #USB_ENDPOINT_XFER_BULK
 * @see #USB_ENDPOINT_XFER_INT
 */

public static final int USB_ENDPOINT_XFERTYPE_MASK = 3; // 0x3

/**
 * Bulk endpoint type
 * @see UsbEndpoint#getType
 */

public static final int USB_ENDPOINT_XFER_BULK = 2; // 0x2

/**
 * Control endpoint type (endpoint zero)
 * @see UsbEndpoint#getType
 */

public static final int USB_ENDPOINT_XFER_CONTROL = 0; // 0x0

/**
 * Interrupt endpoint type
 * @see UsbEndpoint#getType
 */

public static final int USB_ENDPOINT_XFER_INT = 3; // 0x3

/**
 * Isochronous endpoint type (currently not supported)
 * @see UsbEndpoint#getType
 */

public static final int USB_ENDPOINT_XFER_ISOC = 1; // 0x1

/**
 * Boot subclass for HID devices.
 */

public static final int USB_INTERFACE_SUBCLASS_BOOT = 1; // 0x1

/**
 * Vendor specific USB subclass.
 */

public static final int USB_SUBCLASS_VENDOR_SPEC = 255; // 0xff

/**
 * Used to specify that an endpoint zero control request is a class specific request.
 */

public static final int USB_TYPE_CLASS = 32; // 0x20

/**
 * Bitmask used for encoding the request type for a control request on endpoint zero.
 */

public static final int USB_TYPE_MASK = 96; // 0x60

/**
 * Reserved endpoint zero control request type (currently unused).
 */

public static final int USB_TYPE_RESERVED = 96; // 0x60

/**
 * Used to specify that an endpoint zero control request is a standard request.
 */

public static final int USB_TYPE_STANDARD = 0; // 0x0

/**
 * Used to specify that an endpoint zero control request is a vendor specific request.
 */

public static final int USB_TYPE_VENDOR = 64; // 0x40
}

