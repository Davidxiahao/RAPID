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

import java.lang.reflect.Array;

/**
 * A dense indexed sequence of values. Values may be any mix of
 * {@link JSONObject JSONObjects}, other {@link JSONArray JSONArrays}, Strings,
 * Booleans, Integers, Longs, Doubles, {@code null} or {@link JSONObject#NULL}.
 * Values may not be {@link Double#isNaN() NaNs}, {@link Double#isInfinite()
 * infinities}, or of any type not listed here.
 *
 * <p>{@code JSONArray} has the same type coercion behavior and
 * optional/mandatory accessors as {@link JSONObject}. See that class'
 * documentation for details.
 *
 * <p><strong>Warning:</strong> this class represents null in two incompatible
 * ways: the standard Java {@code null} reference, and the sentinel value {@link
 * JSONObject#NULL}. In particular, {@code get} fails if the requested index
 * holds the null reference, but succeeds if it holds {@code JSONObject.NULL}.
 *
 * <p>Instances of this class are not thread safe. Although this class is
 * nonfinal, it was not designed for inheritance and should not be subclassed.
 * In particular, self-use by overridable methods is not specified. See
 * <i>Effective Java</i> Item 17, "Design and Document or inheritance or else
 * prohibit it" for further information.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class JSONArray {

/**
 * Creates a {@code JSONArray} with no values.
 */

public JSONArray() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code JSONArray} by copying all values from the given
 * collection.
 *
 * @param copyFrom a collection whose values are of supported types.
 *     Unsupported values are not permitted and will yield an array in an
 *     inconsistent state.
 */

public JSONArray(java.util.Collection copyFrom) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code JSONArray} with values from the next array in the
 * tokener.
 *
 * @param readFrom a tokener whose nextValue() method will yield a
 *     {@code JSONArray}.
 * @throws JSONException if the parse fails or doesn't yield a
 *     {@code JSONArray}.
 */

public JSONArray(org.json.JSONTokener readFrom) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code JSONArray} with values from the JSON string.
 *
 * @param json a JSON-encoded string containing an array.
 * @throws JSONException if the parse fails or doesn't yield a {@code
 *     JSONArray}.
 */

public JSONArray(java.lang.String json) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@code JSONArray} with values from the given primitive array.
 */

public JSONArray(java.lang.Object array) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of values in this array.
 */

public int length() { throw new RuntimeException("Stub!"); }

/**
 * Appends {@code value} to the end of this array.
 *
 * @return this array.
 */

public org.json.JSONArray put(boolean value) { throw new RuntimeException("Stub!"); }

/**
 * Appends {@code value} to the end of this array.
 *
 * @param value a finite value. May not be {@link Double#isNaN() NaNs} or
 *     {@link Double#isInfinite() infinities}.
 * @return this array.
 */

public org.json.JSONArray put(double value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Appends {@code value} to the end of this array.
 *
 * @return this array.
 */

public org.json.JSONArray put(int value) { throw new RuntimeException("Stub!"); }

/**
 * Appends {@code value} to the end of this array.
 *
 * @return this array.
 */

public org.json.JSONArray put(long value) { throw new RuntimeException("Stub!"); }

/**
 * Appends {@code value} to the end of this array.
 *
 * @param value a {@link JSONObject}, {@link JSONArray}, String, Boolean,
 *     Integer, Long, Double, {@link JSONObject#NULL}, or {@code null}. May
 *     not be {@link Double#isNaN() NaNs} or {@link Double#isInfinite()
 *     infinities}. Unsupported values are not permitted and will cause the
 *     array to be in an inconsistent state.
 * @return this array.
 */

public org.json.JSONArray put(java.lang.Object value) { throw new RuntimeException("Stub!"); }

/**
 * Sets the value at {@code index} to {@code value}, null padding this array
 * to the required length if necessary. If a value already exists at {@code
 * index}, it will be replaced.
 *
 * @return this array.
 */

public org.json.JSONArray put(int index, boolean value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value at {@code index} to {@code value}, null padding this array
 * to the required length if necessary. If a value already exists at {@code
 * index}, it will be replaced.
 *
 * @param value a finite value. May not be {@link Double#isNaN() NaNs} or
 *     {@link Double#isInfinite() infinities}.
 * @return this array.
 */

public org.json.JSONArray put(int index, double value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value at {@code index} to {@code value}, null padding this array
 * to the required length if necessary. If a value already exists at {@code
 * index}, it will be replaced.
 *
 * @return this array.
 */

public org.json.JSONArray put(int index, int value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value at {@code index} to {@code value}, null padding this array
 * to the required length if necessary. If a value already exists at {@code
 * index}, it will be replaced.
 *
 * @return this array.
 */

public org.json.JSONArray put(int index, long value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Sets the value at {@code index} to {@code value}, null padding this array
 * to the required length if necessary. If a value already exists at {@code
 * index}, it will be replaced.
 *
 * @param value a {@link JSONObject}, {@link JSONArray}, String, Boolean,
 *     Integer, Long, Double, {@link JSONObject#NULL}, or {@code null}. May
 *     not be {@link Double#isNaN() NaNs} or {@link Double#isInfinite()
 *     infinities}.
 * @return this array.
 */

public org.json.JSONArray put(int index, java.lang.Object value) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this array has no value at {@code index}, or if its value
 * is the {@code null} reference or {@link JSONObject#NULL}.
 */

public boolean isNull(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index}.
 *
 * @throws JSONException if this array has no value at {@code index}, or if
 *     that value is the {@code null} reference. This method returns
 *     normally if the value is {@code JSONObject#NULL}.
 */

public java.lang.Object get(int index) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index}, or null if the array has no value
 * at {@code index}.
 */

public java.lang.Object opt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Removes and returns the value at {@code index}, or null if the array has no value
 * at {@code index}.
 */

public java.lang.Object remove(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a boolean or can
 * be coerced to a boolean.
 *
 * @throws JSONException if the value at {@code index} doesn't exist or
 *     cannot be coerced to a boolean.
 */

public boolean getBoolean(int index) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a boolean or can
 * be coerced to a boolean. Returns false otherwise.
 */

public boolean optBoolean(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a boolean or can
 * be coerced to a boolean. Returns {@code fallback} otherwise.
 */

public boolean optBoolean(int index, boolean fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a double or can
 * be coerced to a double.
 *
 * @throws JSONException if the value at {@code index} doesn't exist or
 *     cannot be coerced to a double.
 */

public double getDouble(int index) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a double or can
 * be coerced to a double. Returns {@code NaN} otherwise.
 */

public double optDouble(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a double or can
 * be coerced to a double. Returns {@code fallback} otherwise.
 */

public double optDouble(int index, double fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is an int or
 * can be coerced to an int.
 *
 * @throws JSONException if the value at {@code index} doesn't exist or
 *     cannot be coerced to a int.
 */

public int getInt(int index) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is an int or
 * can be coerced to an int. Returns 0 otherwise.
 */

public int optInt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is an int or
 * can be coerced to an int. Returns {@code fallback} otherwise.
 */

public int optInt(int index, int fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a long or
 * can be coerced to a long.
 *
 * @throws JSONException if the value at {@code index} doesn't exist or
 *     cannot be coerced to a long.
 */

public long getLong(int index) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a long or
 * can be coerced to a long. Returns 0 otherwise.
 */

public long optLong(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a long or
 * can be coerced to a long. Returns {@code fallback} otherwise.
 */

public long optLong(int index, long fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists, coercing it if
 * necessary.
 *
 * @throws JSONException if no such value exists.
 */

public java.lang.String getString(int index) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists, coercing it if
 * necessary. Returns the empty string if no such value exists.
 */

public java.lang.String optString(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists, coercing it if
 * necessary. Returns {@code fallback} if no such value exists.
 */

public java.lang.String optString(int index, java.lang.String fallback) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a {@code
 * JSONArray}.
 *
 * @throws JSONException if the value doesn't exist or is not a {@code
 *     JSONArray}.
 */

public org.json.JSONArray getJSONArray(int index) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a {@code
 * JSONArray}. Returns null otherwise.
 */

public org.json.JSONArray optJSONArray(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a {@code
 * JSONObject}.
 *
 * @throws JSONException if the value doesn't exist or is not a {@code
 *     JSONObject}.
 */

public org.json.JSONObject getJSONObject(int index) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value at {@code index} if it exists and is a {@code
 * JSONObject}. Returns null otherwise.
 */

public org.json.JSONObject optJSONObject(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new object whose values are the values in this array, and whose
 * names are the values in {@code names}. Names and values are paired up by
 * index from 0 through to the shorter array's length. Names that are not
 * strings will be coerced to strings. This method returns null if either
 * array is empty.
 */

public org.json.JSONObject toJSONObject(org.json.JSONArray names) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Returns a new string by alternating this array's values with {@code
 * separator}. This array's string values are quoted and have their special
 * characters escaped. For example, the array containing the strings '12"
 * pizza', 'taco' and 'soda' joined on '+' returns this:
 * <pre>"12\" pizza"+"taco"+"soda"</pre>
 */

public java.lang.String join(java.lang.String separator) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

/**
 * Encodes this array as a compact JSON string, such as:
 * <pre>[94043,90210]</pre>
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Encodes this array as a human readable JSON string for debugging, such
 * as:
 * <pre>
 * [
 *     94043,
 *     90210
 * ]</pre>
 *
 * @param indentSpaces the number of spaces to indent for each level of
 *     nesting.
 */

public java.lang.String toString(int indentSpaces) throws org.json.JSONException { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }
}

