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


package android.content;

import java.util.HashMap;
import android.os.Parcel;
import java.util.Map;

/**
 * This class is used to store a set of values that the {@link ContentResolver}
 * can process.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ContentValues implements android.os.Parcelable {

/**
 * Creates an empty set of values using the default initial size
 */

public ContentValues() { throw new RuntimeException("Stub!"); }

/**
 * Creates an empty set of values using the given initial size
 *
 * @param size the initial size of the set of values
 */

public ContentValues(int size) { throw new RuntimeException("Stub!"); }

/**
 * Creates a set of values copied from the given set
 *
 * @param from the values to copy
 */

public ContentValues(android.content.ContentValues from) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object object) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Adds a value to the set.
 *
 * @param key the name of the value to put
 * @param value the data for the value to put
 */

public void put(java.lang.String key, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Adds all values from the passed in ContentValues.
 *
 * @param other the ContentValues from which to copy
 */

public void putAll(android.content.ContentValues other) { throw new RuntimeException("Stub!"); }

/**
 * Adds a value to the set.
 *
 * @param key the name of the value to put
 * @param value the data for the value to put
 */

public void put(java.lang.String key, java.lang.Byte value) { throw new RuntimeException("Stub!"); }

/**
 * Adds a value to the set.
 *
 * @param key the name of the value to put
 * @param value the data for the value to put
 */

public void put(java.lang.String key, java.lang.Short value) { throw new RuntimeException("Stub!"); }

/**
 * Adds a value to the set.
 *
 * @param key the name of the value to put
 * @param value the data for the value to put
 */

public void put(java.lang.String key, java.lang.Integer value) { throw new RuntimeException("Stub!"); }

/**
 * Adds a value to the set.
 *
 * @param key the name of the value to put
 * @param value the data for the value to put
 */

public void put(java.lang.String key, java.lang.Long value) { throw new RuntimeException("Stub!"); }

/**
 * Adds a value to the set.
 *
 * @param key the name of the value to put
 * @param value the data for the value to put
 */

public void put(java.lang.String key, java.lang.Float value) { throw new RuntimeException("Stub!"); }

/**
 * Adds a value to the set.
 *
 * @param key the name of the value to put
 * @param value the data for the value to put
 */

public void put(java.lang.String key, java.lang.Double value) { throw new RuntimeException("Stub!"); }

/**
 * Adds a value to the set.
 *
 * @param key the name of the value to put
 * @param value the data for the value to put
 */

public void put(java.lang.String key, java.lang.Boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Adds a value to the set.
 *
 * @param key the name of the value to put
 * @param value the data for the value to put
 */

public void put(java.lang.String key, byte[] value) { throw new RuntimeException("Stub!"); }

/**
 * Adds a null value to the set.
 *
 * @param key the name of the value to make null
 */

public void putNull(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of values.
 *
 * @return the number of values
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Remove a single value.
 *
 * @param key the name of the value to remove
 */

public void remove(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Removes all values.
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this object has the named value.
 *
 * @param key the value to check for
 * @return {@code true} if the value is present, {@code false} otherwise
 */

public boolean containsKey(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets a value. Valid value types are {@link String}, {@link Boolean},
 * {@link Number}, and {@code byte[]} implementations.
 *
 * @param key the value to get
 * @return the data for the value, or {@code null} if the value is missing or if {@code null}
 *         was previously added with the given {@code key}
 */

public java.lang.Object get(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets a value and converts it to a String.
 *
 * @param key the value to get
 * @return the String for the value
 */

public java.lang.String getAsString(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets a value and converts it to a Long.
 *
 * @param key the value to get
 * @return the Long value, or {@code null} if the value is missing or cannot be converted
 */

public java.lang.Long getAsLong(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets a value and converts it to an Integer.
 *
 * @param key the value to get
 * @return the Integer value, or {@code null} if the value is missing or cannot be converted
 */

public java.lang.Integer getAsInteger(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets a value and converts it to a Short.
 *
 * @param key the value to get
 * @return the Short value, or {@code null} if the value is missing or cannot be converted
 */

public java.lang.Short getAsShort(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets a value and converts it to a Byte.
 *
 * @param key the value to get
 * @return the Byte value, or {@code null} if the value is missing or cannot be converted
 */

public java.lang.Byte getAsByte(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets a value and converts it to a Double.
 *
 * @param key the value to get
 * @return the Double value, or {@code null} if the value is missing or cannot be converted
 */

public java.lang.Double getAsDouble(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets a value and converts it to a Float.
 *
 * @param key the value to get
 * @return the Float value, or {@code null} if the value is missing or cannot be converted
 */

public java.lang.Float getAsFloat(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets a value and converts it to a Boolean.
 *
 * @param key the value to get
 * @return the Boolean value, or {@code null} if the value is missing or cannot be converted
 */

public java.lang.Boolean getAsBoolean(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets a value that is a byte array. Note that this method will not convert
 * any other types to byte arrays.
 *
 * @param key the value to get
 * @return the {@code byte[]} value, or {@code null} is the value is missing or not a
 *         {@code byte[]}
 */

public byte[] getAsByteArray(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns a set of all of the keys and values
 *
 * @return a set of all of the keys and values
 */

public java.util.Set<java.util.Map.Entry<java.lang.String, java.lang.Object>> valueSet() { throw new RuntimeException("Stub!"); }

/**
 * Returns a set of all of the keys
 *
 * @return a set of all of the keys
 */

public java.util.Set<java.lang.String> keySet() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string containing a concise, human-readable description of this object.
 * @return a printable representation of this object.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.ContentValues> CREATOR;
static { CREATOR = null; }

public static final java.lang.String TAG = "ContentValues";
}

