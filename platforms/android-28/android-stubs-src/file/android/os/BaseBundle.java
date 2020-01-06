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

import java.io.Serializable;
import android.util.ArrayMap;
import java.util.Set;
import java.util.ArrayList;

/**
 * A mapping from String keys to values of various types. In most cases, you
 * should work directly with either the {@link Bundle} or
 * {@link PersistableBundle} subclass.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BaseBundle {

/**
 * Constructs a new, empty Bundle.
 */

BaseBundle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of mappings contained in this Bundle.
 *
 * @return the number of mappings as an int.
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the mapping of this Bundle is empty, false otherwise.
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Removes all elements from the mapping of this Bundle.
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the given key is contained in the mapping
 * of this Bundle.
 *
 * @param key a String key
 * @return true if the key is part of the mapping, false otherwise
 */

public boolean containsKey(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the entry with the given key as an object.
 *
 * @param key a String key
 * @return an Object, or null
 */

@androidx.annotation.RecentlyNullable public java.lang.Object get(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Removes any entry with the given key from the mapping of this Bundle.
 *
 * @param key a String key
 */

public void remove(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Inserts all mappings from the given PersistableBundle into this BaseBundle.
 *
 * @param bundle a PersistableBundle
 */

public void putAll(android.os.PersistableBundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Returns a Set containing the Strings used as keys in this Bundle.
 *
 * @return a Set of String keys
 */

public java.util.Set<java.lang.String> keySet() { throw new RuntimeException("Stub!"); }

/**
 * Inserts a Boolean value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a boolean
 */

public void putBoolean(@androidx.annotation.RecentlyNullable java.lang.String key, boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts an int value into the mapping of this Bundle, replacing
 * any existing value for the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value an int
 */

public void putInt(@androidx.annotation.RecentlyNullable java.lang.String key, int value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a long value into the mapping of this Bundle, replacing
 * any existing value for the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a long
 */

public void putLong(@androidx.annotation.RecentlyNullable java.lang.String key, long value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a double value into the mapping of this Bundle, replacing
 * any existing value for the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a double
 */

public void putDouble(@androidx.annotation.RecentlyNullable java.lang.String key, double value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a String value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a String, or null

 * This value may be {@code null}.
 */

public void putString(@androidx.annotation.RecentlyNullable java.lang.String key, @androidx.annotation.RecentlyNullable java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a boolean array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a boolean array object, or null

 * This value may be {@code null}.
 */

public void putBooleanArray(@androidx.annotation.RecentlyNullable java.lang.String key, @androidx.annotation.RecentlyNullable boolean[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts an int array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value an int array object, or null

 * This value may be {@code null}.
 */

public void putIntArray(@androidx.annotation.RecentlyNullable java.lang.String key, @androidx.annotation.RecentlyNullable int[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a long array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a long array object, or null

 * This value may be {@code null}.
 */

public void putLongArray(@androidx.annotation.RecentlyNullable java.lang.String key, @androidx.annotation.RecentlyNullable long[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a double array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a double array object, or null

 * This value may be {@code null}.
 */

public void putDoubleArray(@androidx.annotation.RecentlyNullable java.lang.String key, @androidx.annotation.RecentlyNullable double[] value) { throw new RuntimeException("Stub!"); }

/**
 * Inserts a String array value into the mapping of this Bundle, replacing
 * any existing value for the given key.  Either key or value may be null.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param value a String array object, or null

 * This value may be {@code null}.
 */

public void putStringArray(@androidx.annotation.RecentlyNullable java.lang.String key, @androidx.annotation.RecentlyNullable java.lang.String[] value) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or false if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @return a boolean value
 */

public boolean getBoolean(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @param defaultValue Value to return if key does not exist
 * @return a boolean value
 */

public boolean getBoolean(java.lang.String key, boolean defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or 0 if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @return an int value
 */

public int getInt(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @param defaultValue Value to return if key does not exist
 * @return an int value
 */

public int getInt(java.lang.String key, int defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or 0L if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @return a long value
 */

public long getLong(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @param defaultValue Value to return if key does not exist
 * @return a long value
 */

public long getLong(java.lang.String key, long defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or 0.0 if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @return a double value
 */

public double getDouble(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key.
 *
 * @param key a String
 * @param defaultValue Value to return if key does not exist
 * @return a double value
 */

public double getDouble(java.lang.String key, double defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a String value, or null
 */

@androidx.annotation.RecentlyNullable public java.lang.String getString(@androidx.annotation.RecentlyNullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or defaultValue if
 * no mapping of the desired type exists for the given key or if a null
 * value is explicitly associated with the given key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @param defaultValue Value to return if key does not exist or if a null
 *     value is associated with the given key.
 * @return the String value associated with the given key, or defaultValue
 *     if no valid String object is currently mapped to that key.
 */

public java.lang.String getString(@androidx.annotation.RecentlyNullable java.lang.String key, java.lang.String defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a boolean[] value, or null
 */

@androidx.annotation.RecentlyNullable public boolean[] getBooleanArray(@androidx.annotation.RecentlyNullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return an int[] value, or null
 */

@androidx.annotation.RecentlyNullable public int[] getIntArray(@androidx.annotation.RecentlyNullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a long[] value, or null
 */

@androidx.annotation.RecentlyNullable public long[] getLongArray(@androidx.annotation.RecentlyNullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a double[] value, or null
 */

@androidx.annotation.RecentlyNullable public double[] getDoubleArray(@androidx.annotation.RecentlyNullable java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if
 * no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key.
 *
 * @param key a String, or null
 * This value may be {@code null}.
 * @return a String[] value, or null
 */

@androidx.annotation.RecentlyNullable public java.lang.String[] getStringArray(@androidx.annotation.RecentlyNullable java.lang.String key) { throw new RuntimeException("Stub!"); }
}

