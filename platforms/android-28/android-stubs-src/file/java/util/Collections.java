/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */


package java.util;

import java.lang.reflect.Array;
import java.util.stream.Stream;

/**
 * This class consists exclusively of static methods that operate on or return
 * collections.  It contains polymorphic algorithms that operate on
 * collections, "wrappers", which return a new collection backed by a
 * specified collection, and a few other odds and ends.
 *
 * <p>The methods of this class all throw a <tt>NullPointerException</tt>
 * if the collections or class objects provided to them are null.
 *
 * <p>The documentation for the polymorphic algorithms contained in this class
 * generally includes a brief description of the <i>implementation</i>.  Such
 * descriptions should be regarded as <i>implementation notes</i>, rather than
 * parts of the <i>specification</i>.  Implementors should feel free to
 * substitute other algorithms, so long as the specification itself is adhered
 * to.  (For example, the algorithm used by <tt>sort</tt> does not have to be
 * a mergesort, but it does have to be <i>stable</i>.)
 *
 * <p>The "destructive" algorithms contained in this class, that is, the
 * algorithms that modify the collection on which they operate, are specified
 * to throw <tt>UnsupportedOperationException</tt> if the collection does not
 * support the appropriate mutation primitive(s), such as the <tt>set</tt>
 * method.  These algorithms may, but are not required to, throw this
 * exception if an invocation would have no effect on the collection.  For
 * example, invoking the <tt>sort</tt> method on an unmodifiable list that is
 * already sorted may or may not throw <tt>UnsupportedOperationException</tt>.
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author  Josh Bloch
 * @author  Neal Gafter
 * @see     Collection
 * @see     Set
 * @see     List
 * @see     Map
 * @since   1.2
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Collections {

Collections() { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified list into ascending order, according to the
 * {@linkplain Comparable natural ordering} of its elements.
 * All elements in the list must implement the {@link Comparable}
 * interface.  Furthermore, all elements in the list must be
 * <i>mutually comparable</i> (that is, {@code e1.compareTo(e2)}
 * must not throw a {@code ClassCastException} for any elements
 * {@code e1} and {@code e2} in the list).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * <p>The specified list must be modifiable, but need not be resizable.
 *
 * @implNote
 * This implementation defers to the {@link List#sort(Comparator)}
 * method using the specified list and a {@code null} comparator.
 * Do not call this method from {@code List.sort()} since that can lead
 * to infinite recursion. Apps targeting APIs {@code <= 25} observe
 * backwards compatibility behavior where this method was implemented
 * on top of {@link List#toArray()}, {@link ListIterator#next()} and
 * {@link ListIterator#set(Object)}.
 *
 * @param  <T> the class of the objects in the list
 * @param  list the list to be sorted.
 * @throws ClassCastException if the list contains elements that are not
 *         <i>mutually comparable</i> (for example, strings and integers).
 * @throws UnsupportedOperationException if the specified list's
 *         list-iterator does not support the {@code set} operation.
 * @throws IllegalArgumentException (optional) if the implementation
 *         detects that the natural ordering of the list elements is
 *         found to violate the {@link Comparable} contract
 * @see List#sort(Comparator)
 */

public static <T extends java.lang.Comparable<? super T>> void sort(java.util.List<T> list) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified list according to the order induced by the
 * specified comparator.  All elements in the list must be <i>mutually
 * comparable</i> using the specified comparator (that is,
 * {@code c.compare(e1, e2)} must not throw a {@code ClassCastException}
 * for any elements {@code e1} and {@code e2} in the list).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * <p>The specified list must be modifiable, but need not be resizable.
 *
 * @implNote
 * This implementation defers to the {@link List#sort(Comparator)}
 * method using the specified list and comparator.
 * Do not call this method from {@code List.sort()} since that can lead
 * to infinite recursion. Apps targeting APIs {@code <= 25} observe
 * backwards compatibility behavior where this method was implemented
 * on top of {@link List#toArray()}, {@link ListIterator#next()} and
 * {@link ListIterator#set(Object)}.
 *
 * @param  <T> the class of the objects in the list
 * @param  list the list to be sorted.
 * @param  c the comparator to determine the order of the list.  A
 *        {@code null} value indicates that the elements' <i>natural
 *        ordering</i> should be used.
 * @throws ClassCastException if the list contains elements that are not
 *         <i>mutually comparable</i> using the specified comparator.
 * @throws UnsupportedOperationException if the specified list's
 *         list-iterator does not support the {@code set} operation.
 * @throws IllegalArgumentException (optional) if the comparator is
 *         found to violate the {@link Comparator} contract
 * @see List#sort(Comparator)
 */

public static <T> void sort(java.util.List<T> list, java.util.Comparator<? super T> c) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified list for the specified object using the binary
 * search algorithm.  The list must be sorted into ascending order
 * according to the {@linkplain Comparable natural ordering} of its
 * elements (as by the {@link #sort(List)} method) prior to making this
 * call.  If it is not sorted, the results are undefined.  If the list
 * contains multiple elements equal to the specified object, there is no
 * guarantee which one will be found.
 *
 * <p>This method runs in log(n) time for a "random access" list (which
 * provides near-constant-time positional access).  If the specified list
 * does not implement the {@link RandomAccess} interface and is large,
 * this method will do an iterator-based binary search that performs
 * O(n) link traversals and O(log n) element comparisons.
 *
 * @param  <T> the class of the objects in the list
 * @param  list the list to be searched.
 * @param  key the key to be searched for.
 * @return the index of the search key, if it is contained in the list;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the list: the index of the first
 *         element greater than the key, or <tt>list.size()</tt> if all
 *         elements in the list are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws ClassCastException if the list contains elements that are not
 *         <i>mutually comparable</i> (for example, strings and
 *         integers), or the search key is not mutually comparable
 *         with the elements of the list.
 */

public static <T> int binarySearch(java.util.List<? extends java.lang.Comparable<? super T>> list, T key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified list for the specified object using the binary
 * search algorithm.  The list must be sorted into ascending order
 * according to the specified comparator (as by the
 * {@link #sort(List, Comparator) sort(List, Comparator)}
 * method), prior to making this call.  If it is
 * not sorted, the results are undefined.  If the list contains multiple
 * elements equal to the specified object, there is no guarantee which one
 * will be found.
 *
 * <p>This method runs in log(n) time for a "random access" list (which
 * provides near-constant-time positional access).  If the specified list
 * does not implement the {@link RandomAccess} interface and is large,
 * this method will do an iterator-based binary search that performs
 * O(n) link traversals and O(log n) element comparisons.
 *
 * @param  <T> the class of the objects in the list
 * @param  list the list to be searched.
 * @param  key the key to be searched for.
 * @param  c the comparator by which the list is ordered.
 *         A <tt>null</tt> value indicates that the elements'
 *         {@linkplain Comparable natural ordering} should be used.
 * @return the index of the search key, if it is contained in the list;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the list: the index of the first
 *         element greater than the key, or <tt>list.size()</tt> if all
 *         elements in the list are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws ClassCastException if the list contains elements that are not
 *         <i>mutually comparable</i> using the specified comparator,
 *         or the search key is not mutually comparable with the
 *         elements of the list using this comparator.
 */

public static <T> int binarySearch(java.util.List<? extends T> list, T key, java.util.Comparator<? super T> c) { throw new RuntimeException("Stub!"); }

/**
 * Reverses the order of the elements in the specified list.<p>
 *
 * This method runs in linear time.
 *
 * @param  list the list whose elements are to be reversed.
 * @throws UnsupportedOperationException if the specified list or
 *         its list-iterator does not support the <tt>set</tt> operation.
 */

public static void reverse(java.util.List<?> list) { throw new RuntimeException("Stub!"); }

/**
 * Randomly permutes the specified list using a default source of
 * randomness.  All permutations occur with approximately equal
 * likelihood.
 *
 * <p>The hedge "approximately" is used in the foregoing description because
 * default source of randomness is only approximately an unbiased source
 * of independently chosen bits. If it were a perfect source of randomly
 * chosen bits, then the algorithm would choose permutations with perfect
 * uniformity.
 *
 * <p>This implementation traverses the list backwards, from the last
 * element up to the second, repeatedly swapping a randomly selected element
 * into the "current position".  Elements are randomly selected from the
 * portion of the list that runs from the first element to the current
 * position, inclusive.
 *
 * <p>This method runs in linear time.  If the specified list does not
 * implement the {@link RandomAccess} interface and is large, this
 * implementation dumps the specified list into an array before shuffling
 * it, and dumps the shuffled array back into the list.  This avoids the
 * quadratic behavior that would result from shuffling a "sequential
 * access" list in place.
 *
 * @param  list the list to be shuffled.
 * @throws UnsupportedOperationException if the specified list or
 *         its list-iterator does not support the <tt>set</tt> operation.
 */

public static void shuffle(java.util.List<?> list) { throw new RuntimeException("Stub!"); }

/**
 * Randomly permute the specified list using the specified source of
 * randomness.  All permutations occur with equal likelihood
 * assuming that the source of randomness is fair.<p>
 *
 * This implementation traverses the list backwards, from the last element
 * up to the second, repeatedly swapping a randomly selected element into
 * the "current position".  Elements are randomly selected from the
 * portion of the list that runs from the first element to the current
 * position, inclusive.<p>
 *
 * This method runs in linear time.  If the specified list does not
 * implement the {@link RandomAccess} interface and is large, this
 * implementation dumps the specified list into an array before shuffling
 * it, and dumps the shuffled array back into the list.  This avoids the
 * quadratic behavior that would result from shuffling a "sequential
 * access" list in place.
 *
 * @param  list the list to be shuffled.
 * @param  rnd the source of randomness to use to shuffle the list.
 * @throws UnsupportedOperationException if the specified list or its
 *         list-iterator does not support the <tt>set</tt> operation.
 */

public static void shuffle(java.util.List<?> list, java.util.Random rnd) { throw new RuntimeException("Stub!"); }

/**
 * Swaps the elements at the specified positions in the specified list.
 * (If the specified positions are equal, invoking this method leaves
 * the list unchanged.)
 *
 * @param list The list in which to swap elements.
 * @param i the index of one element to be swapped.
 * @param j the index of the other element to be swapped.
 * @throws IndexOutOfBoundsException if either <tt>i</tt> or <tt>j</tt>
 *         is out of range (i &lt; 0 || i &gt;= list.size()
 *         || j &lt; 0 || j &gt;= list.size()).
 * @since 1.4
 */

public static void swap(java.util.List<?> list, int i, int j) { throw new RuntimeException("Stub!"); }

/**
 * Replaces all of the elements of the specified list with the specified
 * element. <p>
 *
 * This method runs in linear time.
 *
 * @param  <T> the class of the objects in the list
 * @param  list the list to be filled with the specified element.
 * @param  obj The element with which to fill the specified list.
 * @throws UnsupportedOperationException if the specified list or its
 *         list-iterator does not support the <tt>set</tt> operation.
 */

public static <T> void fill(java.util.List<? super T> list, T obj) { throw new RuntimeException("Stub!"); }

/**
 * Copies all of the elements from one list into another.  After the
 * operation, the index of each copied element in the destination list
 * will be identical to its index in the source list.  The destination
 * list must be at least as long as the source list.  If it is longer, the
 * remaining elements in the destination list are unaffected. <p>
 *
 * This method runs in linear time.
 *
 * @param  <T> the class of the objects in the lists
 * @param  dest The destination list.
 * @param  src The source list.
 * @throws IndexOutOfBoundsException if the destination list is too small
 *         to contain the entire source List.
 * @throws UnsupportedOperationException if the destination list's
 *         list-iterator does not support the <tt>set</tt> operation.
 */

public static <T> void copy(java.util.List<? super T> dest, java.util.List<? extends T> src) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum element of the given collection, according to the
 * <i>natural ordering</i> of its elements.  All elements in the
 * collection must implement the <tt>Comparable</tt> interface.
 * Furthermore, all elements in the collection must be <i>mutually
 * comparable</i> (that is, <tt>e1.compareTo(e2)</tt> must not throw a
 * <tt>ClassCastException</tt> for any elements <tt>e1</tt> and
 * <tt>e2</tt> in the collection).<p>
 *
 * This method iterates over the entire collection, hence it requires
 * time proportional to the size of the collection.
 *
 * @param  <T> the class of the objects in the collection
 * @param  coll the collection whose minimum element is to be determined.
 * @return the minimum element of the given collection, according
 *         to the <i>natural ordering</i> of its elements.
 * @throws ClassCastException if the collection contains elements that are
 *         not <i>mutually comparable</i> (for example, strings and
 *         integers).
 * @throws NoSuchElementException if the collection is empty.
 * @see Comparable
 */

public static <T extends java.lang.Object & java.lang.Comparable<? super T>> T min(java.util.Collection<? extends T> coll) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum element of the given collection, according to the
 * order induced by the specified comparator.  All elements in the
 * collection must be <i>mutually comparable</i> by the specified
 * comparator (that is, <tt>comp.compare(e1, e2)</tt> must not throw a
 * <tt>ClassCastException</tt> for any elements <tt>e1</tt> and
 * <tt>e2</tt> in the collection).<p>
 *
 * This method iterates over the entire collection, hence it requires
 * time proportional to the size of the collection.
 *
 * @param  <T> the class of the objects in the collection
 * @param  coll the collection whose minimum element is to be determined.
 * @param  comp the comparator with which to determine the minimum element.
 *         A <tt>null</tt> value indicates that the elements' <i>natural
 *         ordering</i> should be used.
 * @return the minimum element of the given collection, according
 *         to the specified comparator.
 * @throws ClassCastException if the collection contains elements that are
 *         not <i>mutually comparable</i> using the specified comparator.
 * @throws NoSuchElementException if the collection is empty.
 * @see Comparable
 */

public static <T> T min(java.util.Collection<? extends T> coll, java.util.Comparator<? super T> comp) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum element of the given collection, according to the
 * <i>natural ordering</i> of its elements.  All elements in the
 * collection must implement the <tt>Comparable</tt> interface.
 * Furthermore, all elements in the collection must be <i>mutually
 * comparable</i> (that is, <tt>e1.compareTo(e2)</tt> must not throw a
 * <tt>ClassCastException</tt> for any elements <tt>e1</tt> and
 * <tt>e2</tt> in the collection).<p>
 *
 * This method iterates over the entire collection, hence it requires
 * time proportional to the size of the collection.
 *
 * @param  <T> the class of the objects in the collection
 * @param  coll the collection whose maximum element is to be determined.
 * @return the maximum element of the given collection, according
 *         to the <i>natural ordering</i> of its elements.
 * @throws ClassCastException if the collection contains elements that are
 *         not <i>mutually comparable</i> (for example, strings and
 *         integers).
 * @throws NoSuchElementException if the collection is empty.
 * @see Comparable
 */

public static <T extends java.lang.Object & java.lang.Comparable<? super T>> T max(java.util.Collection<? extends T> coll) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum element of the given collection, according to the
 * order induced by the specified comparator.  All elements in the
 * collection must be <i>mutually comparable</i> by the specified
 * comparator (that is, <tt>comp.compare(e1, e2)</tt> must not throw a
 * <tt>ClassCastException</tt> for any elements <tt>e1</tt> and
 * <tt>e2</tt> in the collection).<p>
 *
 * This method iterates over the entire collection, hence it requires
 * time proportional to the size of the collection.
 *
 * @param  <T> the class of the objects in the collection
 * @param  coll the collection whose maximum element is to be determined.
 * @param  comp the comparator with which to determine the maximum element.
 *         A <tt>null</tt> value indicates that the elements' <i>natural
 *        ordering</i> should be used.
 * @return the maximum element of the given collection, according
 *         to the specified comparator.
 * @throws ClassCastException if the collection contains elements that are
 *         not <i>mutually comparable</i> using the specified comparator.
 * @throws NoSuchElementException if the collection is empty.
 * @see Comparable
 */

public static <T> T max(java.util.Collection<? extends T> coll, java.util.Comparator<? super T> comp) { throw new RuntimeException("Stub!"); }

/**
 * Rotates the elements in the specified list by the specified distance.
 * After calling this method, the element at index <tt>i</tt> will be
 * the element previously at index <tt>(i - distance)</tt> mod
 * <tt>list.size()</tt>, for all values of <tt>i</tt> between <tt>0</tt>
 * and <tt>list.size()-1</tt>, inclusive.  (This method has no effect on
 * the size of the list.)
 *
 * <p>For example, suppose <tt>list</tt> comprises<tt> [t, a, n, k, s]</tt>.
 * After invoking <tt>Collections.rotate(list, 1)</tt> (or
 * <tt>Collections.rotate(list, -4)</tt>), <tt>list</tt> will comprise
 * <tt>[s, t, a, n, k]</tt>.
 *
 * <p>Note that this method can usefully be applied to sublists to
 * move one or more elements within a list while preserving the
 * order of the remaining elements.  For example, the following idiom
 * moves the element at index <tt>j</tt> forward to position
 * <tt>k</tt> (which must be greater than or equal to <tt>j</tt>):
 * <pre>
 *     Collections.rotate(list.subList(j, k+1), -1);
 * </pre>
 * To make this concrete, suppose <tt>list</tt> comprises
 * <tt>[a, b, c, d, e]</tt>.  To move the element at index <tt>1</tt>
 * (<tt>b</tt>) forward two positions, perform the following invocation:
 * <pre>
 *     Collections.rotate(l.subList(1, 4), -1);
 * </pre>
 * The resulting list is <tt>[a, c, d, b, e]</tt>.
 *
 * <p>To move more than one element forward, increase the absolute value
 * of the rotation distance.  To move elements backward, use a positive
 * shift distance.
 *
 * <p>If the specified list is small or implements the {@link
 * RandomAccess} interface, this implementation exchanges the first
 * element into the location it should go, and then repeatedly exchanges
 * the displaced element into the location it should go until a displaced
 * element is swapped into the first element.  If necessary, the process
 * is repeated on the second and successive elements, until the rotation
 * is complete.  If the specified list is large and doesn't implement the
 * <tt>RandomAccess</tt> interface, this implementation breaks the
 * list into two sublist views around index <tt>-distance mod size</tt>.
 * Then the {@link #reverse(List)} method is invoked on each sublist view,
 * and finally it is invoked on the entire list.  For a more complete
 * description of both algorithms, see Section 2.3 of Jon Bentley's
 * <i>Programming Pearls</i> (Addison-Wesley, 1986).
 *
 * @param list the list to be rotated.
 * @param distance the distance to rotate the list.  There are no
 *        constraints on this value; it may be zero, negative, or
 *        greater than <tt>list.size()</tt>.
 * @throws UnsupportedOperationException if the specified list or
 *         its list-iterator does not support the <tt>set</tt> operation.
 * @since 1.4
 */

public static void rotate(java.util.List<?> list, int distance) { throw new RuntimeException("Stub!"); }

/**
 * Replaces all occurrences of one specified value in a list with another.
 * More formally, replaces with <tt>newVal</tt> each element <tt>e</tt>
 * in <tt>list</tt> such that
 * <tt>(oldVal==null ? e==null : oldVal.equals(e))</tt>.
 * (This method has no effect on the size of the list.)
 *
 * @param  <T> the class of the objects in the list
 * @param list the list in which replacement is to occur.
 * @param oldVal the old value to be replaced.
 * @param newVal the new value with which <tt>oldVal</tt> is to be
 *        replaced.
 * @return <tt>true</tt> if <tt>list</tt> contained one or more elements
 *         <tt>e</tt> such that
 *         <tt>(oldVal==null ?  e==null : oldVal.equals(e))</tt>.
 * @throws UnsupportedOperationException if the specified list or
 *         its list-iterator does not support the <tt>set</tt> operation.
 * @since  1.4
 */

public static <T> boolean replaceAll(java.util.List<T> list, T oldVal, T newVal) { throw new RuntimeException("Stub!"); }

/**
 * Returns the starting position of the first occurrence of the specified
 * target list within the specified source list, or -1 if there is no
 * such occurrence.  More formally, returns the lowest index <tt>i</tt>
 * such that {@code source.subList(i, i+target.size()).equals(target)},
 * or -1 if there is no such index.  (Returns -1 if
 * {@code target.size() > source.size()})
 *
 * <p>This implementation uses the "brute force" technique of scanning
 * over the source list, looking for a match with the target at each
 * location in turn.
 *
 * @param source the list in which to search for the first occurrence
 *        of <tt>target</tt>.
 * @param target the list to search for as a subList of <tt>source</tt>.
 * @return the starting position of the first occurrence of the specified
 *         target list within the specified source list, or -1 if there
 *         is no such occurrence.
 * @since  1.4
 */

public static int indexOfSubList(java.util.List<?> source, java.util.List<?> target) { throw new RuntimeException("Stub!"); }

/**
 * Returns the starting position of the last occurrence of the specified
 * target list within the specified source list, or -1 if there is no such
 * occurrence.  More formally, returns the highest index <tt>i</tt>
 * such that {@code source.subList(i, i+target.size()).equals(target)},
 * or -1 if there is no such index.  (Returns -1 if
 * {@code target.size() > source.size()})
 *
 * <p>This implementation uses the "brute force" technique of iterating
 * over the source list, looking for a match with the target at each
 * location in turn.
 *
 * @param source the list in which to search for the last occurrence
 *        of <tt>target</tt>.
 * @param target the list to search for as a subList of <tt>source</tt>.
 * @return the starting position of the last occurrence of the specified
 *         target list within the specified source list, or -1 if there
 *         is no such occurrence.
 * @since  1.4
 */

public static int lastIndexOfSubList(java.util.List<?> source, java.util.List<?> target) { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable view of the specified collection.  This method
 * allows modules to provide users with "read-only" access to internal
 * collections.  Query operations on the returned collection "read through"
 * to the specified collection, and attempts to modify the returned
 * collection, whether direct or via its iterator, result in an
 * <tt>UnsupportedOperationException</tt>.<p>
 *
 * The returned collection does <i>not</i> pass the hashCode and equals
 * operations through to the backing collection, but relies on
 * <tt>Object</tt>'s <tt>equals</tt> and <tt>hashCode</tt> methods.  This
 * is necessary to preserve the contracts of these operations in the case
 * that the backing collection is a set or a list.<p>
 *
 * The returned collection will be serializable if the specified collection
 * is serializable.
 *
 * @param  <T> the class of the objects in the collection
 * @param  c the collection for which an unmodifiable view is to be
 *         returned.
 * @return an unmodifiable view of the specified collection.
 */

public static <T> java.util.Collection<T> unmodifiableCollection(java.util.Collection<? extends T> c) { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable view of the specified set.  This method allows
 * modules to provide users with "read-only" access to internal sets.
 * Query operations on the returned set "read through" to the specified
 * set, and attempts to modify the returned set, whether direct or via its
 * iterator, result in an <tt>UnsupportedOperationException</tt>.<p>
 *
 * The returned set will be serializable if the specified set
 * is serializable.
 *
 * @param  <T> the class of the objects in the set
 * @param  s the set for which an unmodifiable view is to be returned.
 * @return an unmodifiable view of the specified set.
 */

public static <T> java.util.Set<T> unmodifiableSet(java.util.Set<? extends T> s) { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable view of the specified sorted set.  This method
 * allows modules to provide users with "read-only" access to internal
 * sorted sets.  Query operations on the returned sorted set "read
 * through" to the specified sorted set.  Attempts to modify the returned
 * sorted set, whether direct, via its iterator, or via its
 * <tt>subSet</tt>, <tt>headSet</tt>, or <tt>tailSet</tt> views, result in
 * an <tt>UnsupportedOperationException</tt>.<p>
 *
 * The returned sorted set will be serializable if the specified sorted set
 * is serializable.
 *
 * @param  <T> the class of the objects in the set
 * @param s the sorted set for which an unmodifiable view is to be
 *        returned.
 * @return an unmodifiable view of the specified sorted set.
 */

public static <T> java.util.SortedSet<T> unmodifiableSortedSet(java.util.SortedSet<T> s) { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable view of the specified navigable set.  This method
 * allows modules to provide users with "read-only" access to internal
 * navigable sets.  Query operations on the returned navigable set "read
 * through" to the specified navigable set.  Attempts to modify the returned
 * navigable set, whether direct, via its iterator, or via its
 * {@code subSet}, {@code headSet}, or {@code tailSet} views, result in
 * an {@code UnsupportedOperationException}.<p>
 *
 * The returned navigable set will be serializable if the specified
 * navigable set is serializable.
 *
 * @param  <T> the class of the objects in the set
 * @param s the navigable set for which an unmodifiable view is to be
 *        returned
 * @return an unmodifiable view of the specified navigable set
 * @since 1.8
 */

public static <T> java.util.NavigableSet<T> unmodifiableNavigableSet(java.util.NavigableSet<T> s) { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable view of the specified list.  This method allows
 * modules to provide users with "read-only" access to internal
 * lists.  Query operations on the returned list "read through" to the
 * specified list, and attempts to modify the returned list, whether
 * direct or via its iterator, result in an
 * <tt>UnsupportedOperationException</tt>.<p>
 *
 * The returned list will be serializable if the specified list
 * is serializable. Similarly, the returned list will implement
 * {@link RandomAccess} if the specified list does.
 *
 * @param  <T> the class of the objects in the list
 * @param  list the list for which an unmodifiable view is to be returned.
 * @return an unmodifiable view of the specified list.
 */

public static <T> java.util.List<T> unmodifiableList(java.util.List<? extends T> list) { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable view of the specified map.  This method
 * allows modules to provide users with "read-only" access to internal
 * maps.  Query operations on the returned map "read through"
 * to the specified map, and attempts to modify the returned
 * map, whether direct or via its collection views, result in an
 * <tt>UnsupportedOperationException</tt>.<p>
 *
 * The returned map will be serializable if the specified map
 * is serializable.
 *
 * @param <K> the class of the map keys
 * @param <V> the class of the map values
 * @param  m the map for which an unmodifiable view is to be returned.
 * @return an unmodifiable view of the specified map.
 */

public static <K, V> java.util.Map<K, V> unmodifiableMap(java.util.Map<? extends K, ? extends V> m) { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable view of the specified sorted map.  This method
 * allows modules to provide users with "read-only" access to internal
 * sorted maps.  Query operations on the returned sorted map "read through"
 * to the specified sorted map.  Attempts to modify the returned
 * sorted map, whether direct, via its collection views, or via its
 * <tt>subMap</tt>, <tt>headMap</tt>, or <tt>tailMap</tt> views, result in
 * an <tt>UnsupportedOperationException</tt>.<p>
 *
 * The returned sorted map will be serializable if the specified sorted map
 * is serializable.
 *
 * @param <K> the class of the map keys
 * @param <V> the class of the map values
 * @param m the sorted map for which an unmodifiable view is to be
 *        returned.
 * @return an unmodifiable view of the specified sorted map.
 */

public static <K, V> java.util.SortedMap<K, V> unmodifiableSortedMap(java.util.SortedMap<K, ? extends V> m) { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable view of the specified navigable map.  This method
 * allows modules to provide users with "read-only" access to internal
 * navigable maps.  Query operations on the returned navigable map "read
 * through" to the specified navigable map.  Attempts to modify the returned
 * navigable map, whether direct, via its collection views, or via its
 * {@code subMap}, {@code headMap}, or {@code tailMap} views, result in
 * an {@code UnsupportedOperationException}.<p>
 *
 * The returned navigable map will be serializable if the specified
 * navigable map is serializable.
 *
 * @param <K> the class of the map keys
 * @param <V> the class of the map values
 * @param m the navigable map for which an unmodifiable view is to be
 *        returned
 * @return an unmodifiable view of the specified navigable map
 * @since 1.8
 */

public static <K, V> java.util.NavigableMap<K, V> unmodifiableNavigableMap(java.util.NavigableMap<K, ? extends V> m) { throw new RuntimeException("Stub!"); }

/**
 * Returns a synchronized (thread-safe) collection backed by the specified
 * collection.  In order to guarantee serial access, it is critical that
 * <strong>all</strong> access to the backing collection is accomplished
 * through the returned collection.<p>
 *
 * It is imperative that the user manually synchronize on the returned
 * collection when traversing it via {@link Iterator}, {@link Spliterator}
 * or {@link Stream}:
 * <pre>
 *  Collection c = Collections.synchronizedCollection(myCollection);
 *     ...
 *  synchronized (c) {
 *      Iterator i = c.iterator(); // Must be in the synchronized block
 *      while (i.hasNext())
 *         foo(i.next());
 *  }
 * </pre>
 * Failure to follow this advice may result in non-deterministic behavior.
 *
 * <p>The returned collection does <i>not</i> pass the {@code hashCode}
 * and {@code equals} operations through to the backing collection, but
 * relies on {@code Object}'s equals and hashCode methods.  This is
 * necessary to preserve the contracts of these operations in the case
 * that the backing collection is a set or a list.<p>
 *
 * The returned collection will be serializable if the specified collection
 * is serializable.
 *
 * @param  <T> the class of the objects in the collection
 * @param  c the collection to be "wrapped" in a synchronized collection.
 * @return a synchronized view of the specified collection.
 */

public static <T> java.util.Collection<T> synchronizedCollection(java.util.Collection<T> c) { throw new RuntimeException("Stub!"); }

/**
 * Returns a synchronized (thread-safe) set backed by the specified
 * set.  In order to guarantee serial access, it is critical that
 * <strong>all</strong> access to the backing set is accomplished
 * through the returned set.<p>
 *
 * It is imperative that the user manually synchronize on the returned
 * set when iterating over it:
 * <pre>
 *  Set s = Collections.synchronizedSet(new HashSet());
 *      ...
 *  synchronized (s) {
 *      Iterator i = s.iterator(); // Must be in the synchronized block
 *      while (i.hasNext())
 *          foo(i.next());
 *  }
 * </pre>
 * Failure to follow this advice may result in non-deterministic behavior.
 *
 * <p>The returned set will be serializable if the specified set is
 * serializable.
 *
 * @param  <T> the class of the objects in the set
 * @param  s the set to be "wrapped" in a synchronized set.
 * @return a synchronized view of the specified set.
 */

public static <T> java.util.Set<T> synchronizedSet(java.util.Set<T> s) { throw new RuntimeException("Stub!"); }

/**
 * Returns a synchronized (thread-safe) sorted set backed by the specified
 * sorted set.  In order to guarantee serial access, it is critical that
 * <strong>all</strong> access to the backing sorted set is accomplished
 * through the returned sorted set (or its views).<p>
 *
 * It is imperative that the user manually synchronize on the returned
 * sorted set when iterating over it or any of its <tt>subSet</tt>,
 * <tt>headSet</tt>, or <tt>tailSet</tt> views.
 * <pre>
 *  SortedSet s = Collections.synchronizedSortedSet(new TreeSet());
 *      ...
 *  synchronized (s) {
 *      Iterator i = s.iterator(); // Must be in the synchronized block
 *      while (i.hasNext())
 *          foo(i.next());
 *  }
 * </pre>
 * or:
 * <pre>
 *  SortedSet s = Collections.synchronizedSortedSet(new TreeSet());
 *  SortedSet s2 = s.headSet(foo);
 *      ...
 *  synchronized (s) {  // Note: s, not s2!!!
 *      Iterator i = s2.iterator(); // Must be in the synchronized block
 *      while (i.hasNext())
 *          foo(i.next());
 *  }
 * </pre>
 * Failure to follow this advice may result in non-deterministic behavior.
 *
 * <p>The returned sorted set will be serializable if the specified
 * sorted set is serializable.
 *
 * @param  <T> the class of the objects in the set
 * @param  s the sorted set to be "wrapped" in a synchronized sorted set.
 * @return a synchronized view of the specified sorted set.
 */

public static <T> java.util.SortedSet<T> synchronizedSortedSet(java.util.SortedSet<T> s) { throw new RuntimeException("Stub!"); }

/**
 * Returns a synchronized (thread-safe) navigable set backed by the
 * specified navigable set.  In order to guarantee serial access, it is
 * critical that <strong>all</strong> access to the backing navigable set is
 * accomplished through the returned navigable set (or its views).<p>
 *
 * It is imperative that the user manually synchronize on the returned
 * navigable set when iterating over it or any of its {@code subSet},
 * {@code headSet}, or {@code tailSet} views.
 * <pre>
 *  NavigableSet s = Collections.synchronizedNavigableSet(new TreeSet());
 *      ...
 *  synchronized (s) {
 *      Iterator i = s.iterator(); // Must be in the synchronized block
 *      while (i.hasNext())
 *          foo(i.next());
 *  }
 * </pre>
 * or:
 * <pre>
 *  NavigableSet s = Collections.synchronizedNavigableSet(new TreeSet());
 *  NavigableSet s2 = s.headSet(foo, true);
 *      ...
 *  synchronized (s) {  // Note: s, not s2!!!
 *      Iterator i = s2.iterator(); // Must be in the synchronized block
 *      while (i.hasNext())
 *          foo(i.next());
 *  }
 * </pre>
 * Failure to follow this advice may result in non-deterministic behavior.
 *
 * <p>The returned navigable set will be serializable if the specified
 * navigable set is serializable.
 *
 * @param  <T> the class of the objects in the set
 * @param  s the navigable set to be "wrapped" in a synchronized navigable
 * set
 * @return a synchronized view of the specified navigable set
 * @since 1.8
 */

public static <T> java.util.NavigableSet<T> synchronizedNavigableSet(java.util.NavigableSet<T> s) { throw new RuntimeException("Stub!"); }

/**
 * Returns a synchronized (thread-safe) list backed by the specified
 * list.  In order to guarantee serial access, it is critical that
 * <strong>all</strong> access to the backing list is accomplished
 * through the returned list.<p>
 *
 * It is imperative that the user manually synchronize on the returned
 * list when iterating over it:
 * <pre>
 *  List list = Collections.synchronizedList(new ArrayList());
 *      ...
 *  synchronized (list) {
 *      Iterator i = list.iterator(); // Must be in synchronized block
 *      while (i.hasNext())
 *          foo(i.next());
 *  }
 * </pre>
 * Failure to follow this advice may result in non-deterministic behavior.
 *
 * <p>The returned list will be serializable if the specified list is
 * serializable.
 *
 * @param  <T> the class of the objects in the list
 * @param  list the list to be "wrapped" in a synchronized list.
 * @return a synchronized view of the specified list.
 */

public static <T> java.util.List<T> synchronizedList(java.util.List<T> list) { throw new RuntimeException("Stub!"); }

/**
 * Returns a synchronized (thread-safe) map backed by the specified
 * map.  In order to guarantee serial access, it is critical that
 * <strong>all</strong> access to the backing map is accomplished
 * through the returned map.<p>
 *
 * It is imperative that the user manually synchronize on the returned
 * map when iterating over any of its collection views:
 * <pre>
 *  Map m = Collections.synchronizedMap(new HashMap());
 *      ...
 *  Set s = m.keySet();  // Needn't be in synchronized block
 *      ...
 *  synchronized (m) {  // Synchronizing on m, not s!
 *      Iterator i = s.iterator(); // Must be in synchronized block
 *      while (i.hasNext())
 *          foo(i.next());
 *  }
 * </pre>
 * Failure to follow this advice may result in non-deterministic behavior.
 *
 * <p>The returned map will be serializable if the specified map is
 * serializable.
 *
 * @param <K> the class of the map keys
 * @param <V> the class of the map values
 * @param  m the map to be "wrapped" in a synchronized map.
 * @return a synchronized view of the specified map.
 */

public static <K, V> java.util.Map<K, V> synchronizedMap(java.util.Map<K, V> m) { throw new RuntimeException("Stub!"); }

/**
 * Returns a synchronized (thread-safe) sorted map backed by the specified
 * sorted map.  In order to guarantee serial access, it is critical that
 * <strong>all</strong> access to the backing sorted map is accomplished
 * through the returned sorted map (or its views).<p>
 *
 * It is imperative that the user manually synchronize on the returned
 * sorted map when iterating over any of its collection views, or the
 * collections views of any of its <tt>subMap</tt>, <tt>headMap</tt> or
 * <tt>tailMap</tt> views.
 * <pre>
 *  SortedMap m = Collections.synchronizedSortedMap(new TreeMap());
 *      ...
 *  Set s = m.keySet();  // Needn't be in synchronized block
 *      ...
 *  synchronized (m) {  // Synchronizing on m, not s!
 *      Iterator i = s.iterator(); // Must be in synchronized block
 *      while (i.hasNext())
 *          foo(i.next());
 *  }
 * </pre>
 * or:
 * <pre>
 *  SortedMap m = Collections.synchronizedSortedMap(new TreeMap());
 *  SortedMap m2 = m.subMap(foo, bar);
 *      ...
 *  Set s2 = m2.keySet();  // Needn't be in synchronized block
 *      ...
 *  synchronized (m) {  // Synchronizing on m, not m2 or s2!
 *      Iterator i = s.iterator(); // Must be in synchronized block
 *      while (i.hasNext())
 *          foo(i.next());
 *  }
 * </pre>
 * Failure to follow this advice may result in non-deterministic behavior.
 *
 * <p>The returned sorted map will be serializable if the specified
 * sorted map is serializable.
 *
 * @param <K> the class of the map keys
 * @param <V> the class of the map values
 * @param  m the sorted map to be "wrapped" in a synchronized sorted map.
 * @return a synchronized view of the specified sorted map.
 */

public static <K, V> java.util.SortedMap<K, V> synchronizedSortedMap(java.util.SortedMap<K, V> m) { throw new RuntimeException("Stub!"); }

/**
 * Returns a synchronized (thread-safe) navigable map backed by the
 * specified navigable map.  In order to guarantee serial access, it is
 * critical that <strong>all</strong> access to the backing navigable map is
 * accomplished through the returned navigable map (or its views).<p>
 *
 * It is imperative that the user manually synchronize on the returned
 * navigable map when iterating over any of its collection views, or the
 * collections views of any of its {@code subMap}, {@code headMap} or
 * {@code tailMap} views.
 * <pre>
 *  NavigableMap m = Collections.synchronizedNavigableMap(new TreeMap());
 *      ...
 *  Set s = m.keySet();  // Needn't be in synchronized block
 *      ...
 *  synchronized (m) {  // Synchronizing on m, not s!
 *      Iterator i = s.iterator(); // Must be in synchronized block
 *      while (i.hasNext())
 *          foo(i.next());
 *  }
 * </pre>
 * or:
 * <pre>
 *  NavigableMap m = Collections.synchronizedNavigableMap(new TreeMap());
 *  NavigableMap m2 = m.subMap(foo, true, bar, false);
 *      ...
 *  Set s2 = m2.keySet();  // Needn't be in synchronized block
 *      ...
 *  synchronized (m) {  // Synchronizing on m, not m2 or s2!
 *      Iterator i = s.iterator(); // Must be in synchronized block
 *      while (i.hasNext())
 *          foo(i.next());
 *  }
 * </pre>
 * Failure to follow this advice may result in non-deterministic behavior.
 *
 * <p>The returned navigable map will be serializable if the specified
 * navigable map is serializable.
 *
 * @param <K> the class of the map keys
 * @param <V> the class of the map values
 * @param  m the navigable map to be "wrapped" in a synchronized navigable
 *              map
 * @return a synchronized view of the specified navigable map.
 * @since 1.8
 */

public static <K, V> java.util.NavigableMap<K, V> synchronizedNavigableMap(java.util.NavigableMap<K, V> m) { throw new RuntimeException("Stub!"); }

/**
 * Returns a dynamically typesafe view of the specified collection.
 * Any attempt to insert an element of the wrong type will result in an
 * immediate {@link ClassCastException}.  Assuming a collection
 * contains no incorrectly typed elements prior to the time a
 * dynamically typesafe view is generated, and that all subsequent
 * access to the collection takes place through the view, it is
 * <i>guaranteed</i> that the collection cannot contain an incorrectly
 * typed element.
 *
 * <p>The generics mechanism in the language provides compile-time
 * (static) type checking, but it is possible to defeat this mechanism
 * with unchecked casts.  Usually this is not a problem, as the compiler
 * issues warnings on all such unchecked operations.  There are, however,
 * times when static type checking alone is not sufficient.  For example,
 * suppose a collection is passed to a third-party library and it is
 * imperative that the library code not corrupt the collection by
 * inserting an element of the wrong type.
 *
 * <p>Another use of dynamically typesafe views is debugging.  Suppose a
 * program fails with a {@code ClassCastException}, indicating that an
 * incorrectly typed element was put into a parameterized collection.
 * Unfortunately, the exception can occur at any time after the erroneous
 * element is inserted, so it typically provides little or no information
 * as to the real source of the problem.  If the problem is reproducible,
 * one can quickly determine its source by temporarily modifying the
 * program to wrap the collection with a dynamically typesafe view.
 * For example, this declaration:
 *  <pre> {@code
 *     Collection<String> c = new HashSet<>();
 * }</pre>
 * may be replaced temporarily by this one:
 *  <pre> {@code
 *     Collection<String> c = Collections.checkedCollection(
 *         new HashSet<>(), String.class);
 * }</pre>
 * Running the program again will cause it to fail at the point where
 * an incorrectly typed element is inserted into the collection, clearly
 * identifying the source of the problem.  Once the problem is fixed, the
 * modified declaration may be reverted back to the original.
 *
 * <p>The returned collection does <i>not</i> pass the hashCode and equals
 * operations through to the backing collection, but relies on
 * {@code Object}'s {@code equals} and {@code hashCode} methods.  This
 * is necessary to preserve the contracts of these operations in the case
 * that the backing collection is a set or a list.
 *
 * <p>The returned collection will be serializable if the specified
 * collection is serializable.
 *
 * <p>Since {@code null} is considered to be a value of any reference
 * type, the returned collection permits insertion of null elements
 * whenever the backing collection does.
 *
 * @param <E> the class of the objects in the collection
 * @param c the collection for which a dynamically typesafe view is to be
 *          returned
 * @param type the type of element that {@code c} is permitted to hold
 * @return a dynamically typesafe view of the specified collection
 * @since 1.5
 */

public static <E> java.util.Collection<E> checkedCollection(java.util.Collection<E> c, java.lang.Class<E> type) { throw new RuntimeException("Stub!"); }

/**
 * Returns a dynamically typesafe view of the specified queue.
 * Any attempt to insert an element of the wrong type will result in
 * an immediate {@link ClassCastException}.  Assuming a queue contains
 * no incorrectly typed elements prior to the time a dynamically typesafe
 * view is generated, and that all subsequent access to the queue
 * takes place through the view, it is <i>guaranteed</i> that the
 * queue cannot contain an incorrectly typed element.
 *
 * <p>A discussion of the use of dynamically typesafe views may be
 * found in the documentation for the {@link #checkedCollection
 * checkedCollection} method.
 *
 * <p>The returned queue will be serializable if the specified queue
 * is serializable.
 *
 * <p>Since {@code null} is considered to be a value of any reference
 * type, the returned queue permits insertion of {@code null} elements
 * whenever the backing queue does.
 *
 * @param <E> the class of the objects in the queue
 * @param queue the queue for which a dynamically typesafe view is to be
 *             returned
 * @param type the type of element that {@code queue} is permitted to hold
 * @return a dynamically typesafe view of the specified queue
 * @since 1.8
 */

public static <E> java.util.Queue<E> checkedQueue(java.util.Queue<E> queue, java.lang.Class<E> type) { throw new RuntimeException("Stub!"); }

/**
 * Returns a dynamically typesafe view of the specified set.
 * Any attempt to insert an element of the wrong type will result in
 * an immediate {@link ClassCastException}.  Assuming a set contains
 * no incorrectly typed elements prior to the time a dynamically typesafe
 * view is generated, and that all subsequent access to the set
 * takes place through the view, it is <i>guaranteed</i> that the
 * set cannot contain an incorrectly typed element.
 *
 * <p>A discussion of the use of dynamically typesafe views may be
 * found in the documentation for the {@link #checkedCollection
 * checkedCollection} method.
 *
 * <p>The returned set will be serializable if the specified set is
 * serializable.
 *
 * <p>Since {@code null} is considered to be a value of any reference
 * type, the returned set permits insertion of null elements whenever
 * the backing set does.
 *
 * @param <E> the class of the objects in the set
 * @param s the set for which a dynamically typesafe view is to be
 *          returned
 * @param type the type of element that {@code s} is permitted to hold
 * @return a dynamically typesafe view of the specified set
 * @since 1.5
 */

public static <E> java.util.Set<E> checkedSet(java.util.Set<E> s, java.lang.Class<E> type) { throw new RuntimeException("Stub!"); }

/**
 * Returns a dynamically typesafe view of the specified sorted set.
 * Any attempt to insert an element of the wrong type will result in an
 * immediate {@link ClassCastException}.  Assuming a sorted set
 * contains no incorrectly typed elements prior to the time a
 * dynamically typesafe view is generated, and that all subsequent
 * access to the sorted set takes place through the view, it is
 * <i>guaranteed</i> that the sorted set cannot contain an incorrectly
 * typed element.
 *
 * <p>A discussion of the use of dynamically typesafe views may be
 * found in the documentation for the {@link #checkedCollection
 * checkedCollection} method.
 *
 * <p>The returned sorted set will be serializable if the specified sorted
 * set is serializable.
 *
 * <p>Since {@code null} is considered to be a value of any reference
 * type, the returned sorted set permits insertion of null elements
 * whenever the backing sorted set does.
 *
 * @param <E> the class of the objects in the set
 * @param s the sorted set for which a dynamically typesafe view is to be
 *          returned
 * @param type the type of element that {@code s} is permitted to hold
 * @return a dynamically typesafe view of the specified sorted set
 * @since 1.5
 */

public static <E> java.util.SortedSet<E> checkedSortedSet(java.util.SortedSet<E> s, java.lang.Class<E> type) { throw new RuntimeException("Stub!"); }

/**
 * Returns a dynamically typesafe view of the specified navigable set.
 * Any attempt to insert an element of the wrong type will result in an
 * immediate {@link ClassCastException}.  Assuming a navigable set
 * contains no incorrectly typed elements prior to the time a
 * dynamically typesafe view is generated, and that all subsequent
 * access to the navigable set takes place through the view, it is
 * <em>guaranteed</em> that the navigable set cannot contain an incorrectly
 * typed element.
 *
 * <p>A discussion of the use of dynamically typesafe views may be
 * found in the documentation for the {@link #checkedCollection
 * checkedCollection} method.
 *
 * <p>The returned navigable set will be serializable if the specified
 * navigable set is serializable.
 *
 * <p>Since {@code null} is considered to be a value of any reference
 * type, the returned navigable set permits insertion of null elements
 * whenever the backing sorted set does.
 *
 * @param <E> the class of the objects in the set
 * @param s the navigable set for which a dynamically typesafe view is to be
 *          returned
 * @param type the type of element that {@code s} is permitted to hold
 * @return a dynamically typesafe view of the specified navigable set
 * @since 1.8
 */

public static <E> java.util.NavigableSet<E> checkedNavigableSet(java.util.NavigableSet<E> s, java.lang.Class<E> type) { throw new RuntimeException("Stub!"); }

/**
 * Returns a dynamically typesafe view of the specified list.
 * Any attempt to insert an element of the wrong type will result in
 * an immediate {@link ClassCastException}.  Assuming a list contains
 * no incorrectly typed elements prior to the time a dynamically typesafe
 * view is generated, and that all subsequent access to the list
 * takes place through the view, it is <i>guaranteed</i> that the
 * list cannot contain an incorrectly typed element.
 *
 * <p>A discussion of the use of dynamically typesafe views may be
 * found in the documentation for the {@link #checkedCollection
 * checkedCollection} method.
 *
 * <p>The returned list will be serializable if the specified list
 * is serializable.
 *
 * <p>Since {@code null} is considered to be a value of any reference
 * type, the returned list permits insertion of null elements whenever
 * the backing list does.
 *
 * @param <E> the class of the objects in the list
 * @param list the list for which a dynamically typesafe view is to be
 *             returned
 * @param type the type of element that {@code list} is permitted to hold
 * @return a dynamically typesafe view of the specified list
 * @since 1.5
 */

public static <E> java.util.List<E> checkedList(java.util.List<E> list, java.lang.Class<E> type) { throw new RuntimeException("Stub!"); }

/**
 * Returns a dynamically typesafe view of the specified map.
 * Any attempt to insert a mapping whose key or value have the wrong
 * type will result in an immediate {@link ClassCastException}.
 * Similarly, any attempt to modify the value currently associated with
 * a key will result in an immediate {@link ClassCastException},
 * whether the modification is attempted directly through the map
 * itself, or through a {@link Map.Entry} instance obtained from the
 * map's {@link Map#entrySet() entry set} view.
 *
 * <p>Assuming a map contains no incorrectly typed keys or values
 * prior to the time a dynamically typesafe view is generated, and
 * that all subsequent access to the map takes place through the view
 * (or one of its collection views), it is <i>guaranteed</i> that the
 * map cannot contain an incorrectly typed key or value.
 *
 * <p>A discussion of the use of dynamically typesafe views may be
 * found in the documentation for the {@link #checkedCollection
 * checkedCollection} method.
 *
 * <p>The returned map will be serializable if the specified map is
 * serializable.
 *
 * <p>Since {@code null} is considered to be a value of any reference
 * type, the returned map permits insertion of null keys or values
 * whenever the backing map does.
 *
 * @param <K> the class of the map keys
 * @param <V> the class of the map values
 * @param m the map for which a dynamically typesafe view is to be
 *          returned
 * @param keyType the type of key that {@code m} is permitted to hold
 * @param valueType the type of value that {@code m} is permitted to hold
 * @return a dynamically typesafe view of the specified map
 * @since 1.5
 */

public static <K, V> java.util.Map<K, V> checkedMap(java.util.Map<K, V> m, java.lang.Class<K> keyType, java.lang.Class<V> valueType) { throw new RuntimeException("Stub!"); }

/**
 * Returns a dynamically typesafe view of the specified sorted map.
 * Any attempt to insert a mapping whose key or value have the wrong
 * type will result in an immediate {@link ClassCastException}.
 * Similarly, any attempt to modify the value currently associated with
 * a key will result in an immediate {@link ClassCastException},
 * whether the modification is attempted directly through the map
 * itself, or through a {@link Map.Entry} instance obtained from the
 * map's {@link Map#entrySet() entry set} view.
 *
 * <p>Assuming a map contains no incorrectly typed keys or values
 * prior to the time a dynamically typesafe view is generated, and
 * that all subsequent access to the map takes place through the view
 * (or one of its collection views), it is <i>guaranteed</i> that the
 * map cannot contain an incorrectly typed key or value.
 *
 * <p>A discussion of the use of dynamically typesafe views may be
 * found in the documentation for the {@link #checkedCollection
 * checkedCollection} method.
 *
 * <p>The returned map will be serializable if the specified map is
 * serializable.
 *
 * <p>Since {@code null} is considered to be a value of any reference
 * type, the returned map permits insertion of null keys or values
 * whenever the backing map does.
 *
 * @param <K> the class of the map keys
 * @param <V> the class of the map values
 * @param m the map for which a dynamically typesafe view is to be
 *          returned
 * @param keyType the type of key that {@code m} is permitted to hold
 * @param valueType the type of value that {@code m} is permitted to hold
 * @return a dynamically typesafe view of the specified map
 * @since 1.5
 */

public static <K, V> java.util.SortedMap<K, V> checkedSortedMap(java.util.SortedMap<K, V> m, java.lang.Class<K> keyType, java.lang.Class<V> valueType) { throw new RuntimeException("Stub!"); }

/**
 * Returns a dynamically typesafe view of the specified navigable map.
 * Any attempt to insert a mapping whose key or value have the wrong
 * type will result in an immediate {@link ClassCastException}.
 * Similarly, any attempt to modify the value currently associated with
 * a key will result in an immediate {@link ClassCastException},
 * whether the modification is attempted directly through the map
 * itself, or through a {@link Map.Entry} instance obtained from the
 * map's {@link Map#entrySet() entry set} view.
 *
 * <p>Assuming a map contains no incorrectly typed keys or values
 * prior to the time a dynamically typesafe view is generated, and
 * that all subsequent access to the map takes place through the view
 * (or one of its collection views), it is <em>guaranteed</em> that the
 * map cannot contain an incorrectly typed key or value.
 *
 * <p>A discussion of the use of dynamically typesafe views may be
 * found in the documentation for the {@link #checkedCollection
 * checkedCollection} method.
 *
 * <p>The returned map will be serializable if the specified map is
 * serializable.
 *
 * <p>Since {@code null} is considered to be a value of any reference
 * type, the returned map permits insertion of null keys or values
 * whenever the backing map does.
 *
 * @param <K> type of map keys
 * @param <V> type of map values
 * @param m the map for which a dynamically typesafe view is to be
 *          returned
 * @param keyType the type of key that {@code m} is permitted to hold
 * @param valueType the type of value that {@code m} is permitted to hold
 * @return a dynamically typesafe view of the specified map
 * @since 1.8
 */

public static <K, V> java.util.NavigableMap<K, V> checkedNavigableMap(java.util.NavigableMap<K, V> m, java.lang.Class<K> keyType, java.lang.Class<V> valueType) { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator that has no elements.  More precisely,
 *
 * <ul>
 * <li>{@link Iterator#hasNext hasNext} always returns {@code
 * false}.</li>
 * <li>{@link Iterator#next next} always throws {@link
 * NoSuchElementException}.</li>
 * <li>{@link Iterator#remove remove} always throws {@link
 * IllegalStateException}.</li>
 * </ul>
 *
 * <p>Implementations of this method are permitted, but not
 * required, to return the same object from multiple invocations.
 *
 * @param <T> type of elements, if there were any, in the iterator
 * @return an empty iterator
 * @since 1.7
 */

public static <T> java.util.Iterator<T> emptyIterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list iterator that has no elements.  More precisely,
 *
 * <ul>
 * <li>{@link Iterator#hasNext hasNext} and {@link
 * ListIterator#hasPrevious hasPrevious} always return {@code
 * false}.</li>
 * <li>{@link Iterator#next next} and {@link ListIterator#previous
 * previous} always throw {@link NoSuchElementException}.</li>
 * <li>{@link Iterator#remove remove} and {@link ListIterator#set
 * set} always throw {@link IllegalStateException}.</li>
 * <li>{@link ListIterator#add add} always throws {@link
 * UnsupportedOperationException}.</li>
 * <li>{@link ListIterator#nextIndex nextIndex} always returns
 * {@code 0}.</li>
 * <li>{@link ListIterator#previousIndex previousIndex} always
 * returns {@code -1}.</li>
 * </ul>
 *
 * <p>Implementations of this method are permitted, but not
 * required, to return the same object from multiple invocations.
 *
 * @param <T> type of elements, if there were any, in the iterator
 * @return an empty list iterator
 * @since 1.7
 */

public static <T> java.util.ListIterator<T> emptyListIterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns an enumeration that has no elements.  More precisely,
 *
 * <ul>
 * <li>{@link Enumeration#hasMoreElements hasMoreElements} always
 * returns {@code false}.</li>
 * <li> {@link Enumeration#nextElement nextElement} always throws
 * {@link NoSuchElementException}.</li>
 * </ul>
 *
 * <p>Implementations of this method are permitted, but not
 * required, to return the same object from multiple invocations.
 *
 * @param  <T> the class of the objects in the enumeration
 * @return an empty enumeration
 * @since 1.7
 */

public static <T> java.util.Enumeration<T> emptyEnumeration() { throw new RuntimeException("Stub!"); }

/**
 * Returns an empty set (immutable).  This set is serializable.
 * Unlike the like-named field, this method is parameterized.
 *
 * <p>This example illustrates the type-safe way to obtain an empty set:
 * <pre>
 *     Set&lt;String&gt; s = Collections.emptySet();
 * </pre>
 * @implNote Implementations of this method need not create a separate
 * {@code Set} object for each call.  Using this method is likely to have
 * comparable cost to using the like-named field.  (Unlike this method, the
 * field does not provide type safety.)
 *
 * @param  <T> the class of the objects in the set
 * @return the empty set
 *
 * @see #EMPTY_SET
 * @since 1.5
 */

public static final <T> java.util.Set<T> emptySet() { throw new RuntimeException("Stub!"); }

/**
 * Returns an empty sorted set (immutable).  This set is serializable.
 *
 * <p>This example illustrates the type-safe way to obtain an empty
 * sorted set:
 * <pre> {@code
 *     SortedSet<String> s = Collections.emptySortedSet();
 * }</pre>
 *
 * @implNote Implementations of this method need not create a separate
 * {@code SortedSet} object for each call.
 *
 * @param <E> type of elements, if there were any, in the set
 * @return the empty sorted set
 * @since 1.8
 */

public static <E> java.util.SortedSet<E> emptySortedSet() { throw new RuntimeException("Stub!"); }

/**
 * Returns an empty navigable set (immutable).  This set is serializable.
 *
 * <p>This example illustrates the type-safe way to obtain an empty
 * navigable set:
 * <pre> {@code
 *     NavigableSet<String> s = Collections.emptyNavigableSet();
 * }</pre>
 *
 * @implNote Implementations of this method need not
 * create a separate {@code NavigableSet} object for each call.
 *
 * @param <E> type of elements, if there were any, in the set
 * @return the empty navigable set
 * @since 1.8
 */

public static <E> java.util.NavigableSet<E> emptyNavigableSet() { throw new RuntimeException("Stub!"); }

/**
 * Returns an empty list (immutable).  This list is serializable.
 *
 * <p>This example illustrates the type-safe way to obtain an empty list:
 * <pre>
 *     List&lt;String&gt; s = Collections.emptyList();
 * </pre>
 *
 * @implNote
 * Implementations of this method need not create a separate <tt>List</tt>
 * object for each call.   Using this method is likely to have comparable
 * cost to using the like-named field.  (Unlike this method, the field does
 * not provide type safety.)
 *
 * @param <T> type of elements, if there were any, in the list
 * @return an empty immutable list
 *
 * @see #EMPTY_LIST
 * @since 1.5
 */

public static final <T> java.util.List<T> emptyList() { throw new RuntimeException("Stub!"); }

/**
 * Returns an empty map (immutable).  This map is serializable.
 *
 * <p>This example illustrates the type-safe way to obtain an empty map:
 * <pre>
 *     Map&lt;String, Date&gt; s = Collections.emptyMap();
 * </pre>
 * @implNote Implementations of this method need not create a separate
 * {@code Map} object for each call.  Using this method is likely to have
 * comparable cost to using the like-named field.  (Unlike this method, the
 * field does not provide type safety.)
 *
 * @param <K> the class of the map keys
 * @param <V> the class of the map values
 * @return an empty map
 * @see #EMPTY_MAP
 * @since 1.5
 */

public static final <K, V> java.util.Map<K, V> emptyMap() { throw new RuntimeException("Stub!"); }

/**
 * Returns an empty sorted map (immutable).  This map is serializable.
 *
 * <p>This example illustrates the type-safe way to obtain an empty map:
 * <pre> {@code
 *     SortedMap<String, Date> s = Collections.emptySortedMap();
 * }</pre>
 *
 * @implNote Implementations of this method need not create a separate
 * {@code SortedMap} object for each call.
 *
 * @param <K> the class of the map keys
 * @param <V> the class of the map values
 * @return an empty sorted map
 * @since 1.8
 */

public static final <K, V> java.util.SortedMap<K, V> emptySortedMap() { throw new RuntimeException("Stub!"); }

/**
 * Returns an empty navigable map (immutable).  This map is serializable.
 *
 * <p>This example illustrates the type-safe way to obtain an empty map:
 * <pre> {@code
 *     NavigableMap<String, Date> s = Collections.emptyNavigableMap();
 * }</pre>
 *
 * @implNote Implementations of this method need not create a separate
 * {@code NavigableMap} object for each call.
 *
 * @param <K> the class of the map keys
 * @param <V> the class of the map values
 * @return an empty navigable map
 * @since 1.8
 */

public static final <K, V> java.util.NavigableMap<K, V> emptyNavigableMap() { throw new RuntimeException("Stub!"); }

/**
 * Returns an immutable set containing only the specified object.
 * The returned set is serializable.
 *
 * @param  <T> the class of the objects in the set
 * @param o the sole object to be stored in the returned set.
 * @return an immutable set containing only the specified object.
 */

public static <T> java.util.Set<T> singleton(T o) { throw new RuntimeException("Stub!"); }

/**
 * Returns an immutable list containing only the specified object.
 * The returned list is serializable.
 *
 * @param  <T> the class of the objects in the list
 * @param o the sole object to be stored in the returned list.
 * @return an immutable list containing only the specified object.
 * @since 1.3
 */

public static <T> java.util.List<T> singletonList(T o) { throw new RuntimeException("Stub!"); }

/**
 * Returns an immutable map, mapping only the specified key to the
 * specified value.  The returned map is serializable.
 *
 * @param <K> the class of the map keys
 * @param <V> the class of the map values
 * @param key the sole key to be stored in the returned map.
 * @param value the value to which the returned map maps <tt>key</tt>.
 * @return an immutable map containing only the specified key-value
 *         mapping.
 * @since 1.3
 */

public static <K, V> java.util.Map<K, V> singletonMap(K key, V value) { throw new RuntimeException("Stub!"); }

/**
 * Returns an immutable list consisting of <tt>n</tt> copies of the
 * specified object.  The newly allocated data object is tiny (it contains
 * a single reference to the data object).  This method is useful in
 * combination with the <tt>List.addAll</tt> method to grow lists.
 * The returned list is serializable.
 *
 * @param  <T> the class of the object to copy and of the objects
 *         in the returned list.
 * @param  n the number of elements in the returned list.
 * @param  o the element to appear repeatedly in the returned list.
 * @return an immutable list consisting of <tt>n</tt> copies of the
 *         specified object.
 * @throws IllegalArgumentException if {@code n < 0}
 * @see    List#addAll(Collection)
 * @see    List#addAll(int, Collection)
 */

public static <T> java.util.List<T> nCopies(int n, T o) { throw new RuntimeException("Stub!"); }

/**
 * Returns a comparator that imposes the reverse of the <em>natural
 * ordering</em> on a collection of objects that implement the
 * {@code Comparable} interface.  (The natural ordering is the ordering
 * imposed by the objects' own {@code compareTo} method.)  This enables a
 * simple idiom for sorting (or maintaining) collections (or arrays) of
 * objects that implement the {@code Comparable} interface in
 * reverse-natural-order.  For example, suppose {@code a} is an array of
 * strings. Then: <pre>
 *          Arrays.sort(a, Collections.reverseOrder());
 * </pre> sorts the array in reverse-lexicographic (alphabetical) order.<p>
 *
 * The returned comparator is serializable.
 *
 * @param  <T> the class of the objects compared by the comparator
 * @return A comparator that imposes the reverse of the <i>natural
 *         ordering</i> on a collection of objects that implement
 *         the <tt>Comparable</tt> interface.
 * @see Comparable
 */

public static <T> java.util.Comparator<T> reverseOrder() { throw new RuntimeException("Stub!"); }

/**
 * Returns a comparator that imposes the reverse ordering of the specified
 * comparator.  If the specified comparator is {@code null}, this method is
 * equivalent to {@link #reverseOrder()} (in other words, it returns a
 * comparator that imposes the reverse of the <em>natural ordering</em> on
 * a collection of objects that implement the Comparable interface).
 *
 * <p>The returned comparator is serializable (assuming the specified
 * comparator is also serializable or {@code null}).
 *
 * @param <T> the class of the objects compared by the comparator
 * @param cmp a comparator who's ordering is to be reversed by the returned
 * comparator or {@code null}
 * @return A comparator that imposes the reverse ordering of the
 *         specified comparator.
 * @since 1.5
 */

public static <T> java.util.Comparator<T> reverseOrder(java.util.Comparator<T> cmp) { throw new RuntimeException("Stub!"); }

/**
 * Returns an enumeration over the specified collection.  This provides
 * interoperability with legacy APIs that require an enumeration
 * as input.
 *
 * @param  <T> the class of the objects in the collection
 * @param c the collection for which an enumeration is to be returned.
 * @return an enumeration over the specified collection.
 * @see Enumeration
 */

public static <T> java.util.Enumeration<T> enumeration(java.util.Collection<T> c) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array list containing the elements returned by the
 * specified enumeration in the order they are returned by the
 * enumeration.  This method provides interoperability between
 * legacy APIs that return enumerations and new APIs that require
 * collections.
 *
 * @param <T> the class of the objects returned by the enumeration
 * @param e enumeration providing elements for the returned
 *          array list
 * @return an array list containing the elements returned
 *         by the specified enumeration.
 * @since 1.4
 * @see Enumeration
 * @see ArrayList
 */

public static <T> java.util.ArrayList<T> list(java.util.Enumeration<T> e) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of elements in the specified collection equal to the
 * specified object.  More formally, returns the number of elements
 * <tt>e</tt> in the collection such that
 * <tt>(o == null ? e == null : o.equals(e))</tt>.
 *
 * @param c the collection in which to determine the frequency
 *     of <tt>o</tt>
 * @param o the object whose frequency is to be determined
 * @return the number of elements in {@code c} equal to {@code o}
 * @throws NullPointerException if <tt>c</tt> is null
 * @since 1.5
 */

public static int frequency(java.util.Collection<?> c, java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if the two specified collections have no
 * elements in common.
 *
 * <p>Care must be exercised if this method is used on collections that
 * do not comply with the general contract for {@code Collection}.
 * Implementations may elect to iterate over either collection and test
 * for containment in the other collection (or to perform any equivalent
 * computation).  If either collection uses a nonstandard equality test
 * (as does a {@link SortedSet} whose ordering is not <em>compatible with
 * equals</em>, or the key set of an {@link IdentityHashMap}), both
 * collections must use the same nonstandard equality test, or the
 * result of this method is undefined.
 *
 * <p>Care must also be exercised when using collections that have
 * restrictions on the elements that they may contain. Collection
 * implementations are allowed to throw exceptions for any operation
 * involving elements they deem ineligible. For absolute safety the
 * specified collections should contain only elements which are
 * eligible elements for both collections.
 *
 * <p>Note that it is permissible to pass the same collection in both
 * parameters, in which case the method will return {@code true} if and
 * only if the collection is empty.
 *
 * @param c1 a collection
 * @param c2 a collection
 * @return {@code true} if the two specified collections have no
 * elements in common.
 * @throws NullPointerException if either collection is {@code null}.
 * @throws NullPointerException if one collection contains a {@code null}
 * element and {@code null} is not an eligible element for the other collection.
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @throws ClassCastException if one collection contains an element that is
 * of a type which is ineligible for the other collection.
 * (<a href="Collection.html#optional-restrictions">optional</a>)
 * @since 1.5
 */

public static boolean disjoint(java.util.Collection<?> c1, java.util.Collection<?> c2) { throw new RuntimeException("Stub!"); }

/**
 * Adds all of the specified elements to the specified collection.
 * Elements to be added may be specified individually or as an array.
 * The behavior of this convenience method is identical to that of
 * <tt>c.addAll(Arrays.asList(elements))</tt>, but this method is likely
 * to run significantly faster under most implementations.
 *
 * <p>When elements are specified individually, this method provides a
 * convenient way to add a few elements to an existing collection:
 * <pre>
 *     Collections.addAll(flavors, "Peaches 'n Plutonium", "Rocky Racoon");
 * </pre>
 *
 * @param  <T> the class of the elements to add and of the collection
 * @param c the collection into which <tt>elements</tt> are to be inserted
 * @param elements the elements to insert into <tt>c</tt>
 * @return <tt>true</tt> if the collection changed as a result of the call
 * @throws UnsupportedOperationException if <tt>c</tt> does not support
 *         the <tt>add</tt> operation
 * @throws NullPointerException if <tt>elements</tt> contains one or more
 *         null values and <tt>c</tt> does not permit null elements, or
 *         if <tt>c</tt> or <tt>elements</tt> are <tt>null</tt>
 * @throws IllegalArgumentException if some property of a value in
 *         <tt>elements</tt> prevents it from being added to <tt>c</tt>
 * @see Collection#addAll(Collection)
 * @since 1.5
 */

@java.lang.SafeVarargs public static <T> boolean addAll(java.util.Collection<? super T> c, T... elements) { throw new RuntimeException("Stub!"); }

/**
 * Returns a set backed by the specified map.  The resulting set displays
 * the same ordering, concurrency, and performance characteristics as the
 * backing map.  In essence, this factory method provides a {@link Set}
 * implementation corresponding to any {@link Map} implementation.  There
 * is no need to use this method on a {@link Map} implementation that
 * already has a corresponding {@link Set} implementation (such as {@link
 * HashMap} or {@link TreeMap}).
 *
 * <p>Each method invocation on the set returned by this method results in
 * exactly one method invocation on the backing map or its <tt>keySet</tt>
 * view, with one exception.  The <tt>addAll</tt> method is implemented
 * as a sequence of <tt>put</tt> invocations on the backing map.
 *
 * <p>The specified map must be empty at the time this method is invoked,
 * and should not be accessed directly after this method returns.  These
 * conditions are ensured if the map is created empty, passed directly
 * to this method, and no reference to the map is retained, as illustrated
 * in the following code fragment:
 * <pre>
 *    Set&lt;Object&gt; weakHashSet = Collections.newSetFromMap(
 *        new WeakHashMap&lt;Object, Boolean&gt;());
 * </pre>
 *
 * @param <E> the class of the map keys and of the objects in the
 *        returned set
 * @param map the backing map
 * @return the set backed by the map
 * @throws IllegalArgumentException if <tt>map</tt> is not empty
 * @since 1.6
 */

public static <E> java.util.Set<E> newSetFromMap(java.util.Map<E, java.lang.Boolean> map) { throw new RuntimeException("Stub!"); }

/**
 * Returns a view of a {@link Deque} as a Last-in-first-out (Lifo)
 * {@link Queue}. Method <tt>add</tt> is mapped to <tt>push</tt>,
 * <tt>remove</tt> is mapped to <tt>pop</tt> and so on. This
 * view can be useful when you would like to use a method
 * requiring a <tt>Queue</tt> but you need Lifo ordering.
 *
 * <p>Each method invocation on the queue returned by this method
 * results in exactly one method invocation on the backing deque, with
 * one exception.  The {@link Queue#addAll addAll} method is
 * implemented as a sequence of {@link Deque#addFirst addFirst}
 * invocations on the backing deque.
 *
 * @param  <T> the class of the objects in the deque
 * @param deque the deque
 * @return the queue
 * @since  1.6
 */

public static <T> java.util.Queue<T> asLifoQueue(java.util.Deque<T> deque) { throw new RuntimeException("Stub!"); }

/**
 * The empty list (immutable).  This list is serializable.
 *
 * @see #emptyList()
 */

public static final java.util.List EMPTY_LIST;
static { EMPTY_LIST = null; }

/**
 * The empty map (immutable).  This map is serializable.
 *
 * @see #emptyMap()
 * @since 1.3
 */

public static final java.util.Map EMPTY_MAP;
static { EMPTY_MAP = null; }

/**
 * The empty set (immutable).  This set is serializable.
 *
 * @see #emptySet()
 */

public static final java.util.Set EMPTY_SET;
static { EMPTY_SET = null; }
}

