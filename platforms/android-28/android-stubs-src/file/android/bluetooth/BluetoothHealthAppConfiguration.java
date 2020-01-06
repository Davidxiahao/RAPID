/*
 * Copyright (C) 2011 The Android Open Source Project
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
 * The Bluetooth Health Application Configuration that is used in conjunction with
 * the {@link BluetoothHealth} class. This class represents an application configuration
 * that the Bluetooth Health third party application will register to communicate with the
 * remote Bluetooth health device.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothHealthAppConfiguration implements android.os.Parcelable {

/**
 * Constructor to register the SINK role
 *
 * @param name Friendly name associated with the application configuration
 * @param dataType Data Type of the remote Bluetooth Health device
 * @hide
 */

BluetoothHealthAppConfiguration(java.lang.String name, int dataType) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Return the data type associated with this application configuration.
 *
 * @return dataType
 */

public int getDataType() { throw new RuntimeException("Stub!"); }

/**
 * Return the name of the application configuration.
 *
 * @return String name
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Return the role associated with this application configuration.
 *
 * @return One of {@link BluetoothHealth#SOURCE_ROLE} or {@link BluetoothHealth#SINK_ROLE}
 */

public int getRole() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.bluetooth.BluetoothHealthAppConfiguration> CREATOR;
static { CREATOR = null; }
}

