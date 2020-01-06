/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.app;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Provides an immutable reference to an entity that appears repeatedly on different surfaces of the
 * platform. For example, this could represent the sender of a message.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Person implements android.os.Parcelable {

Person(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/** Creates and returns a new {@link Builder} initialized with this Person's data. */

public android.app.Person.Builder toBuilder() { throw new RuntimeException("Stub!"); }

/**
 * @return the uri provided for this person or {@code null} if no Uri was provided.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getUri() { throw new RuntimeException("Stub!"); }

/**
 * @return the name provided for this person or {@code null} if no name was provided.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getName() { throw new RuntimeException("Stub!"); }

/**
 * @return the icon provided for this person or {@code null} if no icon was provided.
 */

@androidx.annotation.RecentlyNullable public android.graphics.drawable.Icon getIcon() { throw new RuntimeException("Stub!"); }

/**
 * @return the key provided for this person or {@code null} if no key was provided.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getKey() { throw new RuntimeException("Stub!"); }

/**
 * @return whether this Person is a machine.
 */

public boolean isBot() { throw new RuntimeException("Stub!"); }

/**
 * @return whether this Person is important.
 */

public boolean isImportant() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @param flags Value is either <code>0</code> or a combination of {@link android.os.Parcelable#PARCELABLE_WRITE_RETURN_VALUE}, and android.os.Parcelable.PARCELABLE_ELIDE_DUPLICATES
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.Person> CREATOR;
static { CREATOR = null; }
/** Builder for the immutable {@link Person} class. */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/** Creates a new, empty {@link Builder}. */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Give this person a name.
 *
 * @param name the name of this person.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.app.Person.Builder setName(@androidx.annotation.RecentlyNullable java.lang.CharSequence name) { throw new RuntimeException("Stub!"); }

/**
 * Add an icon for this person.
 * <br />
 * The system will prefer this icon over any images that are resolved from the URI.
 *
 * @param icon the icon of the person.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.app.Person.Builder setIcon(@androidx.annotation.RecentlyNullable android.graphics.drawable.Icon icon) { throw new RuntimeException("Stub!"); }

/**
 * Set a URI associated with this person.
 *
 * <P>
 * The person should be specified by the {@code String} representation of a
 * {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI}.
 * </P>
 *
 * <P>The system will also attempt to resolve {@code mailto:} and {@code tel:} schema
 * URIs. The path part of these URIs must exist in the contacts database, in the
 * appropriate column, or the reference will be discarded as invalid. Telephone schema
 * URIs will be resolved by {@link android.provider.ContactsContract.PhoneLookup}.
 * </P>
 *
 * @param uri a URI for the person.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.app.Person.Builder setUri(@androidx.annotation.RecentlyNullable java.lang.String uri) { throw new RuntimeException("Stub!"); }

/**
 * Add a key to this person in order to uniquely identify it.
 * This is especially useful if the name doesn't uniquely identify this person or if the
 * display name is a short handle of the actual name.
 *
 * <P>If no key is provided, the name serves as the key for the purpose of
 * identification.</P>
 *
 * @param key the key that uniquely identifies this person.
 
 * This value may be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.app.Person.Builder setKey(@androidx.annotation.RecentlyNullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this is an important person. Use this method to denote users who frequently
 * interact with the user of this device when {@link #setUri(String)} isn't provided with
 * {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI}, and instead with
 * the {@code mailto:} or {@code tel:} schemas.
 *
 * @param isImportant {@code true} if this is an important person, {@code false} otherwise.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.app.Person.Builder setImportant(boolean isImportant) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether this person is a machine rather than a human.
 *
 * @param isBot {@code true} if this person is a machine, {@code false} otherwise.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.app.Person.Builder setBot(boolean isBot) { throw new RuntimeException("Stub!"); }

/**
 * Creates and returns the {@link Person} this builder represents.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.app.Person build() { throw new RuntimeException("Stub!"); }
}

}

