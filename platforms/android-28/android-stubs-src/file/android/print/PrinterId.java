/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.print;


/**
 * This class represents the unique id of a printer.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PrinterId implements android.os.Parcelable {

PrinterId(android.os.Parcel parcel) { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of this printer which is unique in the context
 * of the print service that manages it.
 *
 * @return The printer name.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getLocalId() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object object) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.print.PrinterId> CREATOR;
static { CREATOR = null; }
}

