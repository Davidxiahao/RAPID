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
 * A {@link Parcelable} value type that contains information about an account authenticator.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AuthenticatorDescription implements android.os.Parcelable {

/** A constructor for a full AuthenticatorDescription */

public AuthenticatorDescription(java.lang.String type, java.lang.String packageName, int labelId, int iconId, int smallIconId, int prefId, boolean customTokens) { throw new RuntimeException("Stub!"); }

public AuthenticatorDescription(java.lang.String type, java.lang.String packageName, int labelId, int iconId, int smallIconId, int prefId) { throw new RuntimeException("Stub!"); }

/**
 * A factory method for creating an AuthenticatorDescription that can be used as a key
 * to identify the authenticator by its type.
 */

public static android.accounts.AuthenticatorDescription newKey(java.lang.String type) { throw new RuntimeException("Stub!"); }

/** @inheritDoc */

public int describeContents() { throw new RuntimeException("Stub!"); }

/** Returns the hashcode of the type only. */

public int hashCode() { throw new RuntimeException("Stub!"); }

/** Compares the type only, suitable for key comparisons. */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/** @inheritDoc */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/** Used to create the object from a parcel. */

public static final android.os.Parcelable.Creator<android.accounts.AuthenticatorDescription> CREATOR;
static { CREATOR = null; }

/**
 * A resource id for a hierarchy of PreferenceScreen to be added to the settings page for the
 * account. See {@link AbstractAccountAuthenticator} for an example.
 */

public final int accountPreferencesId;
{ accountPreferencesId = 0; }

/** Authenticator handles its own token caching and permission screen */

public final boolean customTokens;
{ customTokens = false; }

/** A resource id of a icon for the authenticator */

public final int iconId;
{ iconId = 0; }

/** A resource id of a label for the authenticator that is suitable for displaying */

public final int labelId;
{ labelId = 0; }

/** The package name that can be used to lookup the resources from above. */

public final java.lang.String packageName;
{ packageName = null; }

/** A resource id of a smaller icon for the authenticator */

public final int smallIconId;
{ smallIconId = 0; }

/** The string that uniquely identifies an authenticator */

public final java.lang.String type;
{ type = null; }
}

