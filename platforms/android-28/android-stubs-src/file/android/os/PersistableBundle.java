/*
 * Copyright (C) 2014 The Android Open Source Project
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

import java.util.ArrayList;

/**
 * A mapping from String keys to values of various types. The set of types
 * supported by this class is purposefully restricted to simple objects that can
 * safely be persisted to and restored from disk.
 *
 * @see Bundle
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PersistableBundle extends android.os.BaseBundle implements java.lang.Cloneable, android.os.Parcelable {

/**
 * Constructs a new, empty PersistableBundle.
 */

public PersistableBundle() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new, empty PersistableBundle sized to hold the given number of
 * elements. The PersistableBundle will grow as needed.
 *
 * @param capacity the initial capacity of the PersistableBundle
 */

public PersistableBundle(int capacity) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a PersistableBundle containing a copy of the mappings from the given
 * PersistableBundle.  Does only a shallow copy of the original PersistableBundle -- see
 * {@link #deepCopy()} if that is not what you want.
 *
 * @param b a PersistableBundle to be copied.
 *
 * @see #deepCopy()
 */

public PersistableBundle(android.os.PersistableBundle b) { throw new RuntimeException("Stub!"); }

/**
 * Clones the current PersistableBundle. The internal map is cloned, but the keys and
 * values to which it refers are copied by reference.
 */

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * Make a deep copy of the given bundle.  Traverses into inner containers and copies
 * them as well, so they are not shared across bundles.  Will traverse in to
 * {@link Bundle}, {@link PersistableBundle}, {@link ArrayList}, and all types of
 * primitive arrays.  Other types of objects (such as Parcelable or Serializable)
 * are referenced as-is and not copied in any way.
 */

public android.os.PersistableBundle deepCopy() { throw new RuntimeException("Stub!"); }

/**
 * Inserts a PersistableBundle value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a Bundle object, or null

 * This value may be {@code null}.
 */

public void putPersistableBundle(@androidx.annotation.RecentlyNullable java.lang.String key, @androidx.annotation.RecentlyNullable android.os.PersistableBundle value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a Bundle value, or null
 */

@androidx.annotation.RecentlyNullable public android.os.PersistableBundle getPersistableBundle(@androidx.annotation.RecentlyNullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Report the nature of this Parcelable's contents
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Writes the PersistableBundle contents to a Parcel, typically in order for
 * it to be passed through an IBinder connection.
 * @param parcel The parcel to copy this bundle to.
 */

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public synchronized java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.os.PersistableBundle> CREATOR;
static { CREATOR = null; }

public static final android.os.PersistableBundle EMPTY;
static { EMPTY = null; }
}

