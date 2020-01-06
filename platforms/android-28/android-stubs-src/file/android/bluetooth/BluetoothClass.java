/*
 * Copyright (C) 2008 The Android Open Source Project
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
 * Represents a Bluetooth class, which describes general characteristics
 * and capabilities of a device. For example, a Bluetooth class will
 * specify the general device type such as a phone, a computer, or
 * headset, and whether it's capable of services such as audio or telephony.
 *
 * <p>Every Bluetooth class is composed of zero or more service classes, and
 * exactly one device class. The device class is further broken down into major
 * and minor device class components.
 *
 * <p>{@link BluetoothClass} is useful as a hint to roughly describe a device
 * (for example to show an icon in the UI), but does not reliably describe which
 * Bluetooth profiles or services are actually supported by a device. Accurate
 * service discovery is done through SDP requests, which are automatically
 * performed when creating an RFCOMM socket with {@link
 * BluetoothDevice#createRfcommSocketToServiceRecord} and {@link
 * BluetoothAdapter#listenUsingRfcommWithServiceRecord}</p>
 *
 * <p>Use {@link BluetoothDevice#getBluetoothClass} to retrieve the class for
 * a remote device.
 *
 * <!--
 * The Bluetooth class is a 32 bit field. The format of these bits is defined at
 * http://www.bluetooth.org/Technical/AssignedNumbers/baseband.htm
 * (login required). This class contains that 32 bit field, and provides
 * constants and methods to determine which Service Class(es) and Device Class
 * are encoded in that field.
 * -->
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothClass implements android.os.Parcelable {

/** @hide */

BluetoothClass(int classInt) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the specified service class is supported by this
 * {@link BluetoothClass}.
 * <p>Valid service classes are the public constants in
 * {@link BluetoothClass.Service}. For example, {@link
 * BluetoothClass.Service#AUDIO}.
 *
 * @param service valid service class
 * @return true if the service class is supported
 */

public boolean hasService(int service) { throw new RuntimeException("Stub!"); }

/**
 * Return the major device class component of this {@link BluetoothClass}.
 * <p>Values returned from this function can be compared with the
 * public constants in {@link BluetoothClass.Device.Major} to determine
 * which major class is encoded in this Bluetooth class.
 *
 * @return major device class component
 */

public int getMajorDeviceClass() { throw new RuntimeException("Stub!"); }

/**
 * Return the (major and minor) device class component of this
 * {@link BluetoothClass}.
 * <p>Values returned from this function can be compared with the
 * public constants in {@link BluetoothClass.Device} to determine which
 * device class is encoded in this Bluetooth class.
 *
 * @return device class component
 */

public int getDeviceClass() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.bluetooth.BluetoothClass> CREATOR;
static { CREATOR = null; }
/**
 * Defines all device class constants.
 * <p>Each {@link BluetoothClass} encodes exactly one device class, with
 * major and minor components.
 * <p>The constants in {@link
 * BluetoothClass.Device} represent a combination of major and minor
 * device components (the complete device class). The constants in {@link
 * BluetoothClass.Device.Major} represent only major device classes.
 * <p>See {@link BluetoothClass.Service} for service class constants.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Device {

public Device() { throw new RuntimeException("Stub!"); }

public static final int AUDIO_VIDEO_CAMCORDER = 1076; // 0x434

public static final int AUDIO_VIDEO_CAR_AUDIO = 1056; // 0x420

public static final int AUDIO_VIDEO_HANDSFREE = 1032; // 0x408

public static final int AUDIO_VIDEO_HEADPHONES = 1048; // 0x418

public static final int AUDIO_VIDEO_HIFI_AUDIO = 1064; // 0x428

public static final int AUDIO_VIDEO_LOUDSPEAKER = 1044; // 0x414

public static final int AUDIO_VIDEO_MICROPHONE = 1040; // 0x410

public static final int AUDIO_VIDEO_PORTABLE_AUDIO = 1052; // 0x41c

public static final int AUDIO_VIDEO_SET_TOP_BOX = 1060; // 0x424

public static final int AUDIO_VIDEO_UNCATEGORIZED = 1024; // 0x400

public static final int AUDIO_VIDEO_VCR = 1068; // 0x42c

public static final int AUDIO_VIDEO_VIDEO_CAMERA = 1072; // 0x430

public static final int AUDIO_VIDEO_VIDEO_CONFERENCING = 1088; // 0x440

public static final int AUDIO_VIDEO_VIDEO_DISPLAY_AND_LOUDSPEAKER = 1084; // 0x43c

public static final int AUDIO_VIDEO_VIDEO_GAMING_TOY = 1096; // 0x448

public static final int AUDIO_VIDEO_VIDEO_MONITOR = 1080; // 0x438

public static final int AUDIO_VIDEO_WEARABLE_HEADSET = 1028; // 0x404

public static final int COMPUTER_DESKTOP = 260; // 0x104

public static final int COMPUTER_HANDHELD_PC_PDA = 272; // 0x110

public static final int COMPUTER_LAPTOP = 268; // 0x10c

public static final int COMPUTER_PALM_SIZE_PC_PDA = 276; // 0x114

public static final int COMPUTER_SERVER = 264; // 0x108

public static final int COMPUTER_UNCATEGORIZED = 256; // 0x100

public static final int COMPUTER_WEARABLE = 280; // 0x118

public static final int HEALTH_BLOOD_PRESSURE = 2308; // 0x904

public static final int HEALTH_DATA_DISPLAY = 2332; // 0x91c

public static final int HEALTH_GLUCOSE = 2320; // 0x910

public static final int HEALTH_PULSE_OXIMETER = 2324; // 0x914

public static final int HEALTH_PULSE_RATE = 2328; // 0x918

public static final int HEALTH_THERMOMETER = 2312; // 0x908

public static final int HEALTH_UNCATEGORIZED = 2304; // 0x900

public static final int HEALTH_WEIGHING = 2316; // 0x90c

public static final int PHONE_CELLULAR = 516; // 0x204

public static final int PHONE_CORDLESS = 520; // 0x208

public static final int PHONE_ISDN = 532; // 0x214

public static final int PHONE_MODEM_OR_GATEWAY = 528; // 0x210

public static final int PHONE_SMART = 524; // 0x20c

public static final int PHONE_UNCATEGORIZED = 512; // 0x200

public static final int TOY_CONTROLLER = 2064; // 0x810

public static final int TOY_DOLL_ACTION_FIGURE = 2060; // 0x80c

public static final int TOY_GAME = 2068; // 0x814

public static final int TOY_ROBOT = 2052; // 0x804

public static final int TOY_UNCATEGORIZED = 2048; // 0x800

public static final int TOY_VEHICLE = 2056; // 0x808

public static final int WEARABLE_GLASSES = 1812; // 0x714

public static final int WEARABLE_HELMET = 1808; // 0x710

public static final int WEARABLE_JACKET = 1804; // 0x70c

public static final int WEARABLE_PAGER = 1800; // 0x708

public static final int WEARABLE_UNCATEGORIZED = 1792; // 0x700

public static final int WEARABLE_WRIST_WATCH = 1796; // 0x704
/**
 * Defines all major device class constants.
 * <p>See {@link BluetoothClass.Device} for minor classes.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Major {

public Major() { throw new RuntimeException("Stub!"); }

public static final int AUDIO_VIDEO = 1024; // 0x400

public static final int COMPUTER = 256; // 0x100

public static final int HEALTH = 2304; // 0x900

public static final int IMAGING = 1536; // 0x600

public static final int MISC = 0; // 0x0

public static final int NETWORKING = 768; // 0x300

public static final int PERIPHERAL = 1280; // 0x500

public static final int PHONE = 512; // 0x200

public static final int TOY = 2048; // 0x800

public static final int UNCATEGORIZED = 7936; // 0x1f00

public static final int WEARABLE = 1792; // 0x700
}

}

/**
 * Defines all service class constants.
 * <p>Each {@link BluetoothClass} encodes zero or more service classes.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Service {

public Service() { throw new RuntimeException("Stub!"); }

public static final int AUDIO = 2097152; // 0x200000

public static final int CAPTURE = 524288; // 0x80000

public static final int INFORMATION = 8388608; // 0x800000

public static final int LIMITED_DISCOVERABILITY = 8192; // 0x2000

public static final int NETWORKING = 131072; // 0x20000

public static final int OBJECT_TRANSFER = 1048576; // 0x100000

public static final int POSITIONING = 65536; // 0x10000

public static final int RENDER = 262144; // 0x40000

public static final int TELEPHONY = 4194304; // 0x400000
}

}

