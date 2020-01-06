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


package android.os;


/**
 * Representation of a user on the device.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UserHandle implements android.os.Parcelable {

/**
 * Instantiate a new UserHandle from the data in a Parcel that was
 * previously written with {@link #writeToParcel(Parcel, int)}.  Note that you
 * must not use this with data written by
 * {@link #writeToParcel(UserHandle, Parcel)} since it is not possible
 * to handle a null UserHandle here.
 *
 * @param in The Parcel containing the previously written UserHandle,
 * positioned at the location in the buffer where it was written.
 */

public UserHandle(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Returns the user for a given uid.
 * @param uid A uid for an application running in a particular user.
 * @return A {@link UserHandle} for that user.
 */

public static android.os.UserHandle getUserHandleForUid(int uid) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Write a UserHandle to a Parcel, handling null pointers.  Must be
 * read with {@link #readFromParcel(Parcel)}.
 *
 * @param h The UserHandle to be written.
 * @param out The Parcel in which the UserHandle will be placed.
 *
 * @see #readFromParcel(Parcel)
 */

public static void writeToParcel(android.os.UserHandle h, android.os.Parcel out) { throw new RuntimeException("Stub!"); }

/**
 * Read a UserHandle from a Parcel that was previously written
 * with {@link #writeToParcel(UserHandle, Parcel)}, returning either
 * a null or new object as appropriate.
 *
 * @param in The Parcel from which to read the UserHandle
 * @return Returns a new UserHandle matching the previously written
 * object, or null if a null had been written.
 *
 * @see #writeToParcel(UserHandle, Parcel)
 */

public static android.os.UserHandle readFromParcel(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.os.UserHandle> CREATOR;
static { CREATOR = null; }
}

