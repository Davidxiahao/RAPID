/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.accounts;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Value type that represents an Account in the {@link AccountManager}. This object is
 * {@link Parcelable} and also overrides {@link #equals} and {@link #hashCode}, making it
 * suitable for use as the key of a {@link java.util.Map}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Account implements android.os.Parcelable {

public Account(java.lang.String name, java.lang.String type) { throw new RuntimeException("Stub!"); }

public Account(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.accounts.Account> CREATOR;
static { CREATOR = null; }

public final java.lang.String name;
{ name = null; }

public final java.lang.String type;
{ type = null; }
}

