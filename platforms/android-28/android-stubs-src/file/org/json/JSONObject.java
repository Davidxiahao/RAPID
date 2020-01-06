/*
 * Copyright (C) 2010 The Android Open Source Project
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


package org.json;

import java.util.Objects;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Collection;

/**
 * A modifiable set of name/value mappings. Names are unique, non-null strings.
 * Values may be any mix of {@link JSONObject JSONObjects}, {@link JSONArray
 * JSONArrays}, Strings, Booleans, Integers, Longs, Doubles or {@link #NULL}.
 * Values may not be {@code null}, {@link Double#isNaN() NaNs}, {@link
 * Double#isInfinite() infinities}, or of any type not listed here.
 *
 * <p>This class can coerce values to another type when requested.
 * <ul>
 *   <li>When the requested type is a boolean, strings will be coerced using a
 *       case-insensitive comparison to "true" and "false".
 *   <li>When the requested type is a double, other {@link Number} types will
 *       be coerced using {@link Number#doubleValue() doubleValue}. Strings
 *       that can be coerced using {@link Double#valueOf(String)} will be.
 *   <li>When the requested type is an int, other {@link Number} types will
 *       be coerced using {@link Number#intValue() intValue}. Strings
 *       that can be coerced using {@link Double#valueOf(String)} will be,
 *       and then cast to int.
 *   <li><a name="lossy">When the requested type is a long, other {@link Number} types will
 *       be coerced using {@link Number#longValue() longValue}. Strings
 *       that can be coerced using {@link Double#valueOf(String)} will be,
 *       and then cast to long. This two-step conversion is lossy for very
 *       large values. For example, the string "9223372036854775806" yields the
 *       long 9223372036854775807.</a>
 *   <li>When the requested type is a String, other non-null values will be
 *       coerced using {@link String#valueOf(Object)}. Although null cannot be
 *       coerced, the sentinel value {@link JSONObject#NULL} is coerced to the
 *       string "null".
 * </ul>
 *
 * <p>This class can look up both mandatory and optional values:
 * <ul>
 *   <li>Use <code>get<i>Type</i>()</code> to retrieve a mandatory value. This
 *       fails with a {@code JSONException} if the requested name has no value
 *       or if the value cannot be coerced to the requested type.
 *   <li>Use <code>opt<i>Type</i>()</code> to retrieve an optional value. This
 *       returns a system- or user-supplied default if the requested name has no
 *       value or if the value cannot be coerced to the requested type.
 * </ul>
 *
 * <p><strong>Warning:</strong> this class represents null in two incompatible
 * ways: the standard Java {@code null} reference, and the sentinel value {@link
 * JSONObject#NULL}. In particular, calling {@code put(name, null)} removes the
 * named entry from the object but {@code put(name, JSONObject.NULL)} stores an
 * entry whose value is {@code JSONObject.NULL}.
 *
 * <p>Instances of this class are not thread safe. Although this class is
 * nonfinal, it was not designed for inheritance and should not be subclassed.
 * In particular, self-use by overrideable methods is not specified. See
 * <i>Effective Java</i> Item 17, "Design and Document or inheritance or else
 * prohibit it" for further information.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JSONObject {

/**
 * Creates a {@code JSONObject} with no name/value mappings.
 */

public JSONObject() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code JSONObject} by copying all name/value mappings from
 * the given map.
 *
 * @param copyFrom a map whose keys are of type {@link String} and whose
 *     values are of supported types.
 * @throws NullPointerException if any of the map's keys are null.
 */

public JSONObject(java.util.Map copyFrom) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code JSONObject} with name/value mappings from the next
 * object in the tokener.
 *
 * @param readFrom a tokener whose nextValue() method will yield a
 *     {@code JSONObject}.
 * @throws JSONException if the parse fails or doesn't yield a
 *     {@code JSONObject}.
 */

public JSONObject(org.json.JSONTokener readFrom) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code JSONObject} with name/value mappings from the JSON
 * string.
 *
 * @param json a JSON-encoded string containing an object.
 * @throws JSONException if the parse fails or doesn't yield a {@code
 *     JSONObject}.
 */

public JSONObject(java.lang.String json) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code JSONObject} by copying mappings for the listed names
 * from the given object. Names that aren't present in {@code copyFrom} will
 * be skipped.
 */

public JSONObject(org.json.JSONObject copyFrom, java.lang.String[] names) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of name/value mappings in this object.
 */

public int length() { throw new RuntimeException("Stub!"); }

/**
 * Maps {@code name} to {@code value}, clobbering any existing name/value
 * mapping with the same name.
 *
 * @return this object.
 */

public org.json.JSONObject put(java.lang.String name, boolean value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Maps {@code name} to {@code value}, clobbering any existing name/value
 * mapping with the same name.
 *
 * @param value a finite value. May not be {@link Double#isNaN() NaNs} or
 *     {@link Double#isInfinite() infinities}.
 * @return this object.
 */

public org.json.JSONObject put(java.lang.String name, double value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Maps {@code name} to {@code value}, clobbering any existing name/value
 * mapping with the same name.
 *
 * @return this object.
 */

public org.json.JSONObject put(java.lang.String name, int value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Maps {@code name} to {@code value}, clobbering any existing name/value
 * mapping with the same name.
 *
 * @return this object.
 */

public org.json.JSONObject put(java.lang.String name, long value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Maps {@code name} to {@code value}, clobbering any existing name/value
 * mapping with the same name. If the value is {@code null}, any existing
 * mapping for {@code name} is removed.
 *
 * @param value a {@link JSONObject}, {@link JSONArray}, String, Boolean,
 *     Integer, Long, Double, {@link #NULL}, or {@code null}. May not be
 *     {@link Double#isNaN() NaNs} or {@link Double#isInfinite()
 *     infinities}.
 * @return this object.
 */

public org.json.JSONObject put(java.lang.String name, java.lang.Object value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Equivalent to {@code put(name, value)} when both parameters are non-null;
 * does nothing otherwise.
 */

public org.json.JSONObject putOpt(java.lang.String name, java.lang.Object value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Appends {@code value} to the array already mapped to {@code name}. If
 * this object has no mapping for {@code name}, this inserts a new mapping.
 * If the mapping exists but its value is not an array, the existing
 * and new values are inserted in order into a new array which is itself
 * mapped to {@code name}. In aggregate, this allows values to be added to a
 * mapping one at a time.
 *
 * <p> Note that {@code append(String, Object)} provides better semantics.
 * In particular, the mapping for {@code name} will <b>always</b> be a
 * {@link JSONArray}. Using {@code accumulate} will result in either a
 * {@link JSONArray} or a mapping whose type is the type of {@code value}
 * depending on the number of calls to it.
 *
 * @param value a {@link JSONObject}, {@link JSONArray}, String, Boolean,
 *     Integer, Long, Double, {@link #NULL} or null. May not be {@link
 *     Double#isNaN() NaNs} or {@link Double#isInfinite() infinities}.
 */

public org.json.JSONObject accumulate(java.lang.String name, java.lang.Object value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Removes the named mapping if it exists; does nothing otherwise.
 *
 * @return the value previously mapped by {@code name}, or null if there was
 *     no such mapping.
 */

public java.lang.Object remove(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this object has no mapping for {@code name} or if it has
 * a mapping whose value is {@link #NULL}.
 */

public boolean isNull(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this object has a mapping for {@code name}. The mapping
 * may be {@link #NULL}.
 */

public boolean has(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name}, or throws if no such mapping exists.
 *
 * @throws JSONException if no such mapping exists.
 */

public java.lang.Object get(java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name}, or null if no such mapping
 * exists.
 */

public java.lang.Object opt(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a boolean or
 * can be coerced to a boolean, or throws otherwise.
 *
 * @throws JSONException if the mapping doesn't exist or cannot be coerced
 *     to a boolean.
 */

public boolean getBoolean(java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a boolean or
 * can be coerced to a boolean, or false otherwise.
 */

public boolean optBoolean(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a boolean or
 * can be coerced to a boolean, or {@code fallback} otherwise.
 */

public boolean optBoolean(java.lang.String name, boolean fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a double or
 * can be coerced to a double, or throws otherwise.
 *
 * @throws JSONException if the mapping doesn't exist or cannot be coerced
 *     to a double.
 */

public double getDouble(java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a double or
 * can be coerced to a double, or {@code NaN} otherwise.
 */

public double optDouble(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a double or
 * can be coerced to a double, or {@code fallback} otherwise.
 */

public double optDouble(java.lang.String name, double fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is an int or
 * can be coerced to an int, or throws otherwise.
 *
 * @throws JSONException if the mapping doesn't exist or cannot be coerced
 *     to an int.
 */

public int getInt(java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is an int or
 * can be coerced to an int, or 0 otherwise.
 */

public int optInt(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is an int or
 * can be coerced to an int, or {@code fallback} otherwise.
 */

public int optInt(java.lang.String name, int fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a long or
 * can be coerced to a long, or throws otherwise.
 * Note that JSON represents numbers as doubles,
 * so this is <a href="#lossy">lossy</a>; use strings to transfer numbers via JSON.
 *
 * @throws JSONException if the mapping doesn't exist or cannot be coerced
 *     to a long.
 */

public long getLong(java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a long or
 * can be coerced to a long, or 0 otherwise. Note that JSON represents numbers as doubles,
 * so this is <a href="#lossy">lossy</a>; use strings to transfer numbers via JSON.
 */

public long optLong(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a long or
 * can be coerced to a long, or {@code fallback} otherwise. Note that JSON represents
 * numbers as doubles, so this is <a href="#lossy">lossy</a>; use strings to transfer
 * numbers via JSON.
 */

public long optLong(java.lang.String name, long fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists, coercing it if
 * necessary, or throws if no such mapping exists.
 *
 * @throws JSONException if no such mapping exists.
 */

public java.lang.String getString(java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists, coercing it if
 * necessary, or the empty string if no such mapping exists.
 */

public java.lang.String optString(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists, coercing it if
 * necessary, or {@code fallback} if no such mapping exists.
 */

public java.lang.String optString(java.lang.String name, java.lang.String fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a {@code
 * JSONArray}, or throws otherwise.
 *
 * @throws JSONException if the mapping doesn't exist or is not a {@code
 *     JSONArray}.
 */

public org.json.JSONArray getJSONArray(java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a {@code
 * JSONArray}, or null otherwise.
 */

public org.json.JSONArray optJSONArray(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a {@code
 * JSONObject}, or throws otherwise.
 *
 * @throws JSONException if the mapping doesn't exist or is not a {@code
 *     JSONObject}.
 */

public org.json.JSONObject getJSONObject(java.lang.String name) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value mapped by {@code name} if it exists and is a {@code
 * JSONObject}, or null otherwise.
 */

public org.json.JSONObject optJSONObject(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array with the values corresponding to {@code names}. The
 * array contains null for names that aren't mapped. This method returns
 * null if {@code names} is either null or empty.
 */

public org.json.JSONArray toJSONArray(org.json.JSONArray names) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator of the {@code String} names in this object. The
 * returned iterator supports {@link Iterator#remove() remove}, which will
 * remove the corresponding mapping from this object. If this object is
 * modified after the iterator is returned, the iterator's behavior is
 * undefined. The order of the keys is undefined.
 */

public java.util.Iterator<java.lang.String> keys() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing the string names in this object. This method
 * returns null if this object contains no mappings.
 */

public org.json.JSONArray names() { throw new RuntimeException("Stub!"); }

/**
 * Encodes this object as a compact JSON string, such as:
 * <pre>{"query":"Pizza","locations":[94043,90210]}</pre>
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Encodes this object as a human readable JSON string for debugging, such
 * as:
 * <pre>
 * {
 *     "query": "Pizza",
 *     "locations": [
 *         94043,
 *         90210
 *     ]
 * }</pre>
 *
 * @param indentSpaces the number of spaces to indent for each level of
 *     nesting.
 */

public java.lang.String toString(int indentSpaces) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Encodes the number as a JSON string.
 *
 * @param number a finite value. May not be {@link Double#isNaN() NaNs} or
 *     {@link Double#isInfinite() infinities}.
 */

public static java.lang.String numberToString(java.lang.Number number) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Encodes {@code data} as a JSON string. This applies quotes and any
 * necessary character escaping.
 *
 * @param data the string to encode. Null will be interpreted as an empty
 *     string.
 */

public static java.lang.String quote(java.lang.String data) { throw new RuntimeException("Stub!"); }

/**
 * Wraps the given object if necessary.
 *
 * <p>If the object is null or , returns {@link #NULL}.
 * If the object is a {@code JSONArray} or {@code JSONObject}, no wrapping is necessary.
 * If the object is {@code NULL}, no wrapping is necessary.
 * If the object is an array or {@code Collection}, returns an equivalent {@code JSONArray}.
 * If the object is a {@code Map}, returns an equivalent {@code JSONObject}.
 * If the object is a primitive wrapper type or {@code String}, returns the object.
 * Otherwise if the object is from a {@code java} package, returns the result of {@code toString}.
 * If wrapping fails, returns null.
 */

public static java.lang.Object wrap(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * A sentinel value used to explicitly define a name with no value. Unlike
 * {@code null}, names with this value:
 * <ul>
 *   <li>show up in the {@link #names} array
 *   <li>show up in the {@link #keys} iterator
 *   <li>return {@code true} for {@link #has(String)}
 *   <li>do not throw on {@link #get(String)}
 *   <li>are included in the encoded JSON string.
 * </ul>
 *
 * <p>This value violates the general contract of {@link Object#equals} by
 * returning true when compared to {@code null}. Its {@link #toString}
 * method returns "null".
 */

public static final java.lang.Object NULL;
static { NULL = null; }
}

