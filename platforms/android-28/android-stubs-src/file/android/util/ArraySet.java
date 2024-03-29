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


package android.util;

import java.lang.reflect.Array;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;

/**
 * ArraySet is a generic set data structure that is designed to be more memory efficient than a
 * traditional {@link java.util.HashSet}.  The design is very similar to
 * {@link ArrayMap}, with all of the caveats described there.  This implementation is
 * separate from ArrayMap, however, so the Object array contains only one item for each
 * entry in the set (instead of a pair for a mapping).
 *
 * <p>Note that this implementation is not intended to be appropriate for data structures
 * that may contain large numbers of items.  It is generally slower than a traditional
 * HashSet, since lookups require a binary search and adds and removes require inserting
 * and deleting entries in the array.  For containers holding up to hundreds of items,
 * the performance difference is not significant, less than 50%.</p>
 *
 * <p>Because this container is intended to better balance memory use, unlike most other
 * standard Java containers it will shrink its array as items are removed from it.  Currently
 * you have no control over this shrinking -- if you set a capacity and then remove an
 * item, it may reduce the capacity to better match the current size.  In the future an
 * explicit call to set the capacity should turn off this aggressive shrinking behavior.</p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ArraySet<E> implements java.util.Collection<E>, java.util.Set<E> {

/**
 * Create a new empty ArraySet.  The default capacity of an array map is 0, and
 * will grow once items are added to it.
 */

public ArraySet() { throw new RuntimeException("Stub!"); }

/**
 * Create a new ArraySet with a given initial capacity.
 */

public ArraySet(int capacity) { throw new RuntimeException("Stub!"); }

/**
 * Create a new ArraySet with the mappings from the given ArraySet.
 */

public ArraySet(android.util.ArraySet<E> set) { throw new RuntimeException("Stub!"); }

/**
 * Make the array map empty.  All storage is released.
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Ensure the array map can hold at least <var>minimumCapacity</var>
 * items.
 */

public void ensureCapacity(int minimumCapacity) { throw new RuntimeException("Stub!"); }

/**
 * Check whether a value exists in the set.
 *
 * @param key The value to search for.
 * @return Returns true if the value exists, else false.
 */

public boolean contains(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the index of a value in the set.
 *
 * @param key The value to search for.
 * @return Returns the index of the value if it exists, else a negative integer.
 */

public int indexOf(java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Return the value at the given index in the array.
 * @param index The desired index, must be between 0 and {@link #size()}-1.
 * @return Returns the value stored at the given index.
 */

public E valueAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the array map contains no items.
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Adds the specified object to this set. The set is not modified if it
 * already contains the object.
 *
 * @param value the object to add.
 * @return {@code true} if this set is modified, {@code false} otherwise.
 * @throws ClassCastException
 *             when the class of the object is inappropriate for this set.
 */

public boolean add(E value) { throw new RuntimeException("Stub!"); }

/**
 * Perform a {@link #add(Object)} of all values in <var>array</var>
 * @param array The array whose contents are to be retrieved.
 */

public void addAll(android.util.ArraySet<? extends E> array) { throw new RuntimeException("Stub!"); }

/**
 * Removes the specified object from this set.
 *
 * @param object the object to remove.
 * @return {@code true} if this set was modified, {@code false} otherwise.
 */

public boolean remove(java.lang.Object object) { throw new RuntimeException("Stub!"); }

/**
 * Remove the key/value mapping at the given index.
 * @param index The desired index, must be between 0 and {@link #size()}-1.
 * @return Returns the value that was stored at this index.
 */

public E removeAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Perform a {@link #remove(Object)} of all values in <var>array</var>
 * @param array The array whose contents are to be removed.
 */

public boolean removeAll(android.util.ArraySet<? extends E> array) { throw new RuntimeException("Stub!"); }

/**
 * Return the number of items in this array map.
 */

public int size() { throw new RuntimeException("Stub!"); }

public java.lang.Object[] toArray() { throw new RuntimeException("Stub!"); }

public <T> T[] toArray(T[] array) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation returns false if the object is not a set, or
 * if the sets have different sizes.  Otherwise, for each value in this
 * set, it checks to make sure the value also exists in the other set.
 * If any value doesn't exist, the method returns false; otherwise, it
 * returns true.
 */

public boolean equals(java.lang.Object object) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 *
 * <p>This implementation composes a string by iterating over its values. If
 * this set contains itself as a value, the string "(this Set)"
 * will appear in its place.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Return an {@link java.util.Iterator} over all values in the set.
 *
 * <p><b>Note:</b> this is a fairly inefficient way to access the array contents, it
 * requires generating a number of temporary objects and allocates additional state
 * information associated with the container that will remain for the life of the container.</p>
 */

public java.util.Iterator<E> iterator() { throw new RuntimeException("Stub!"); }

/**
 * Determine if the array set contains all of the values in the given collection.
 * @param collection The collection whose contents are to be checked against.
 * @return Returns true if this array set contains a value for every entry
 * in <var>collection</var>, else returns false.
 */

public boolean containsAll(java.util.Collection<?> collection) { throw new RuntimeException("Stub!"); }

/**
 * Perform an {@link #add(Object)} of all values in <var>collection</var>
 * @param collection The collection whose contents are to be retrieved.
 */

public boolean addAll(java.util.Collection<? extends E> collection) { throw new RuntimeException("Stub!"); }

/**
 * Remove all values in the array set that exist in the given collection.
 * @param collection The collection whose contents are to be used to remove values.
 * @return Returns true if any values were removed from the array set, else false.
 */

public boolean removeAll(java.util.Collection<?> collection) { throw new RuntimeException("Stub!"); }

/**
 * Remove all values in the array set that do <b>not</b> exist in the given collection.
 * @param collection The collection whose contents are to be used to determine which
 * values to keep.
 * @return Returns true if any values were removed from the array set, else false.
 */

public boolean retainAll(java.util.Collection<?> collection) { throw new RuntimeException("Stub!"); }
}

