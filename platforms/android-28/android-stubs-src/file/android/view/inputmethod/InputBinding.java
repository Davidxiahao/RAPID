/*
 * Copyright (C) 2007-2008 The Android Open Source Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.view.inputmethod;

import android.os.Parcel;

/**
 * Information given to an {@link InputMethod} about a client connecting
 * to it.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class InputBinding implements android.os.Parcelable {

/**
 * Constructor.
 *
 * @param conn The interface for communicating back with the application.
 * @param connToken A remoteable token for communicating across processes.
 * @param uid The user id of the client of this binding.
 * @param pid The process id of where the binding came from.
 */

public InputBinding(android.view.inputmethod.InputConnection conn, android.os.IBinder connToken, int uid, int pid) { throw new RuntimeException("Stub!"); }

/**
 * Constructor from an existing InputBinding taking a new local input
 * connection interface.
 *
 * @param conn The new connection interface.
 * @param binding Existing binding to copy.
 */

public InputBinding(android.view.inputmethod.InputConnection conn, android.view.inputmethod.InputBinding binding) { throw new RuntimeException("Stub!"); }

/**
 * Return the connection for interacting back with the application.
 */

public android.view.inputmethod.InputConnection getConnection() { throw new RuntimeException("Stub!"); }

/**
 * Return the token for the connection back to the application.  You can
 * not use this directly, it must be converted to a {@link InputConnection}
 * for you.
 */

public android.os.IBinder getConnectionToken() { throw new RuntimeException("Stub!"); }

/**
 * Return the user id of the client associated with this binding.
 */

public int getUid() { throw new RuntimeException("Stub!"); }

/**
 * Return the process id where this binding came from.
 */

public int getPid() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link Parcel}.
 *
 * @param dest The {@link Parcel} to be written.
 * @param flags The flags used for parceling.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 */

public static final android.os.Parcelable.Creator<android.view.inputmethod.InputBinding> CREATOR;
static { CREATOR = null; }
}

