/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.content.pm;


/**
 * Information you can retrieve about a particular application
 * service. This corresponds to information collected from the
 * AndroidManifest.xml's &lt;service&gt; tags.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ServiceInfo extends android.content.pm.ComponentInfo implements android.os.Parcelable {

public ServiceInfo() { throw new RuntimeException("Stub!"); }

public ServiceInfo(android.content.pm.ServiceInfo orig) { throw new RuntimeException("Stub!"); }

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.ServiceInfo> CREATOR;
static { CREATOR = null; }

/**
 * Bit in {@link #flags}: If set, the service can be bound and run in the
 * calling application's package, rather than the package in which it is
 * declared.  Set from {@link android.R.attr#externalService} attribute.
 */

public static final int FLAG_EXTERNAL_SERVICE = 4; // 0x4

/**
 * Bit in {@link #flags}: If set, the service will run in its own
 * isolated process.  Set from the
 * {@link android.R.attr#isolatedProcess} attribute.
 */

public static final int FLAG_ISOLATED_PROCESS = 2; // 0x2

/**
 * Bit in {@link #flags}: If set, a single instance of the service will
 * run for all users on the device.  Set from the
 * {@link android.R.attr#singleUser} attribute.
 */

public static final int FLAG_SINGLE_USER = 1073741824; // 0x40000000

/**
 * Bit in {@link #flags}: If set, the service will automatically be
 * stopped by the system if the user removes a task that is rooted
 * in one of the application's activities.  Set from the
 * {@link android.R.attr#stopWithTask} attribute.
 */

public static final int FLAG_STOP_WITH_TASK = 1; // 0x1

/**
 * Options that have been set in the service declaration in the
 * manifest.
 * These include:
 * {@link #FLAG_STOP_WITH_TASK}, {@link #FLAG_ISOLATED_PROCESS},
 * {@link #FLAG_SINGLE_USER}.
 */

public int flags;

/**
 * Optional name of a permission required to be able to access this
 * Service.  From the "permission" attribute.
 */

public java.lang.String permission;
}

