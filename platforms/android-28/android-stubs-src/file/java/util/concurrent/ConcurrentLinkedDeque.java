/*
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

/*
 * This file is available under and governed by the GNU General Public
 * License version 2 only, as published by the Free Software Foundation.
 * However, the following notice accompanied the original version of this
 * file:
 *
 * Written by Doug Lea and Martin Buchholz with assistance from members of
 * JCP JSR-166 Expert Group and released to the public domain, as explained
 * at http://creativecommons.org/publicdomain/zero/1.0/
 */


package java.util.concurrent;

import java.util.Iterator;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;

/**
 * An unbounded concurrent {@linkplain Deque deque} based on linked nodes.
 * Concurrent insertion, removal, and access operations execute safely
 * across multiple threads.
 * A {@code ConcurrentLinkedDeque} is an appropriate choice when
 * many threads will share access to a common collection.
 * Like most other concurrent collection implementations, this class
 * does not permit the use of {@code null} elements.
 *
 * <p>Iterators and spliterators are
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * <p>Beware that, unlike in most collections, the {@code size} method
 * is <em>NOT</em> a constant-time operation. Because of the
 * asynchronous nature of these deques, determining the current number
 * of elements requires a traversal of the elements, and so may report
 * inaccurate results if this collection is modified during traversal.
 * Additionally, the bulk operations {@code addAll},
 * {@code removeAll}, {@code retainAll}, {@code containsAll},
 * {@code equals}, and {@code toArray} are <em>not</em> guaranteed
 * to be performed atomically. For example, an iterator operating
 * concurrently with an {@code addAll} operation might view only some
 * of the added elements.
 *
 * <p>This class and its iterator implement all of the <em>optional</em>
 * methods of the {@link Deque} and {@link Iterator} interfaces.
 *
 * <p>Memory consistency effects: As with other concurrent collections,
 * actions in a thread prior to placing an object into a
 * {@code ConcurrentLinkedDeque}
 * <a href="package-summary.html#MemoryVisibility"><i>happen-before</i></a>
 * actions subsequent to the access or removal of that element from
 * the {@code ConcurrentLinkedDeque} in another thread.
 *
 * @since 1.7
 * @author Doug Lea
 * @author Martin Buchholz
 * @param <E> the type of elements held in this deque
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConcurrentLinkedDeque<E> extends java.util.AbstractCollection<E> implements java.util.Deque<E>, java.io.Serializable {

/**
 * Constructs an empty deque.
 */

public ConcurrentLinkedDeque() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a deque initially containing the elements of
 * the given collection, added in traversal order of the
 * collection's iterator.
 *
 * @param c the collection of elements to initially contain
 * @throws NullPointerException if the specified collection or any
 *         of its elements are null
 */

public ConcurrentLinkedDeque(java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the front of this deque.
 * As the deque is unbounded, this method will never throw
 * {@link IllegalStateException}.
 *
 * @throws NullPointerException if the specified element is null
 */

public void addFirst(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the end of this deque.
 * As the deque is unbounded, this method will never throw
 * {@link IllegalStateException}.
 *
 * <p>This method is equivalent to {@link #add}.
 *
 * @throws NullPointerException if the specified element is null
 */

public void addLast(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the front of this deque.
 * As the deque is unbounded, this method will never return {@code false}.
 *
 * @return {@code true} (as specified by {@link Deque#offerFirst})
 * @throws NullPointerException if the specified element is null
 */

public boolean offerFirst(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the end of this deque.
 * As the deque is unbounded, this method will never return {@code false}.
 *
 * <p>This method is equivalent to {@link #add}.
 *
 * @return {@code true} (as specified by {@link Deque#offerLast})
 * @throws NullPointerException if the specified element is null
 */

public boolean offerLast(E e) { throw new RuntimeException("Stub!"); }

public E peekFirst() { throw new RuntimeException("Stub!"); }

public E peekLast() { throw new RuntimeException("Stub!"); }

/**
 * @throws NoSuchElementException {@inheritDoc}
 */

public E getFirst() { throw new RuntimeException("Stub!"); }

/**
 * @throws NoSuchElementException {@inheritDoc}
 */

public E getLast() { throw new RuntimeException("Stub!"); }

public E pollFirst() { throw new RuntimeException("Stub!"); }

public E pollLast() { throw new RuntimeException("Stub!"); }

/**
 * @throws NoSuchElementException {@inheritDoc}
 */

public E removeFirst() { throw new RuntimeException("Stub!"); }

/**
 * @throws NoSuchElementException {@inheritDoc}
 */

public E removeLast() { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the tail of this deque.
 * As the deque is unbounded, this method will never return {@code false}.
 *
 * @return {@code true} (as specified by {@link Queue#offer})
 * @throws NullPointerException if the specified element is null
 */

public boolean offer(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the tail of this deque.
 * As the deque is unbounded, this method will never throw
 * {@link IllegalStateException} or return {@code false}.
 *
 * @return {@code true} (as specified by {@link Collection#add})
 * @throws NullPointerException if the specified element is null
 */

public boolean add(E e) { throw new RuntimeException("Stub!"); }

public E poll() { throw new RuntimeException("Stub!"); }

public E peek() { throw new RuntimeException("Stub!"); }

/**
 * @throws NoSuchElementException {@inheritDoc}
 */

public E remove() { throw new RuntimeException("Stub!"); }

/**
 * @throws NoSuchElementException {@inheritDoc}
 */

public E pop() { throw new RuntimeException("Stub!"); }

/**
 * @throws NoSuchElementException {@inheritDoc}
 */

public E element() { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 */

public void push(E e) { throw new RuntimeException("Stub!"); }

/**
 * Removes the first occurrence of the specified element from this deque.
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the first element {@code e} such that
 * {@code o.equals(e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if the deque contained the specified element
 * @throws NullPointerException if the specified element is null
 */

public boolean removeFirstOccurrence(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Removes the last occurrence of the specified element from this deque.
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the last element {@code e} such that
 * {@code o.equals(e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if the deque contained the specified element
 * @throws NullPointerException if the specified element is null
 */

public boolean removeLastOccurrence(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this deque contains the specified element.
 * More formally, returns {@code true} if and only if this deque contains
 * at least one element {@code e} such that {@code o.equals(e)}.
 *
 * @param o element whose presence in this deque is to be tested
 * @return {@code true} if this deque contains the specified element
 */

public boolean contains(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this collection contains no elements.
 *
 * @return {@code true} if this collection contains no elements
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of elements in this deque.  If this deque
 * contains more than {@code Integer.MAX_VALUE} elements, it
 * returns {@code Integer.MAX_VALUE}.
 *
 * <p>Beware that, unlike in most collections, this method is
 * <em>NOT</em> a constant-time operation. Because of the
 * asynchronous nature of these deques, determining the current
 * number of elements requires traversing them all to count them.
 * Additionally, it is possible for the size to change during
 * execution of this method, in which case the returned result
 * will be inaccurate. Thus, this method is typically not very
 * useful in concurrent applications.
 *
 * @return the number of elements in this deque
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Removes the first occurrence of the specified element from this deque.
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the first element {@code e} such that
 * {@code o.equals(e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * <p>This method is equivalent to {@link #removeFirstOccurrence(Object)}.
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if the deque contained the specified element
 * @throws NullPointerException if the specified element is null
 */

public boolean remove(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Appends all of the elements in the specified collection to the end of
 * this deque, in the order that they are returned by the specified
 * collection's iterator.  Attempts to {@code addAll} of a deque to
 * itself result in {@code IllegalArgumentException}.
 *
 * @param c the elements to be inserted into this deque
 * @return {@code true} if this deque changed as a result of the call
 * @throws NullPointerException if the specified collection or any
 *         of its elements are null
 * @throws IllegalArgumentException if the collection is this deque
 */

public boolean addAll(java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Removes all of the elements from this deque.
 */

public void clear() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing all of the elements in this deque, in
 * proper sequence (from first to last element).
 *
 * <p>The returned array will be "safe" in that no references to it are
 * maintained by this deque.  (In other words, this method must allocate
 * a new array).  The caller is thus free to modify the returned array.
 *
 * <p>This method acts as bridge between array-based and collection-based
 * APIs.
 *
 * @return an array containing all of the elements in this deque
 */

public java.lang.Object[] toArray() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing all of the elements in this deque,
 * in proper sequence (from first to last element); the runtime
 * type of the returned array is that of the specified array.  If
 * the deque fits in the specified array, it is returned therein.
 * Otherwise, a new array is allocated with the runtime type of
 * the specified array and the size of this deque.
 *
 * <p>If this deque fits in the specified array with room to spare
 * (i.e., the array has more elements than this deque), the element in
 * the array immediately following the end of the deque is set to
 * {@code null}.
 *
 * <p>Like the {@link #toArray()} method, this method acts as
 * bridge between array-based and collection-based APIs.  Further,
 * this method allows precise control over the runtime type of the
 * output array, and may, under certain circumstances, be used to
 * save allocation costs.
 *
 * <p>Suppose {@code x} is a deque known to contain only strings.
 * The following code can be used to dump the deque into a newly
 * allocated array of {@code String}:
 *
 * <pre> {@code String[] y = x.toArray(new String[0]);}</pre>
 *
 * Note that {@code toArray(new Object[0])} is identical in function to
 * {@code toArray()}.
 *
 * @param a the array into which the elements of the deque are to
 *          be stored, if it is big enough; otherwise, a new array of the
 *          same runtime type is allocated for this purpose
 * @return an array containing all of the elements in this deque
 * @throws ArrayStoreException if the runtime type of the specified array
 *         is not a supertype of the runtime type of every element in
 *         this deque
 * @throws NullPointerException if the specified array is null
 */

public <T> T[] toArray(T[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over the elements in this deque in proper sequence.
 * The elements will be returned in order from first (head) to last (tail).
 *
 * <p>The returned iterator is
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * @return an iterator over the elements in this deque in proper sequence
 */

public java.util.Iterator<E> iterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over the elements in this deque in reverse
 * sequential order.  The elements will be returned in order from
 * last (tail) to first (head).
 *
 * <p>The returned iterator is
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * @return an iterator over the elements in this deque in reverse order
 */

public java.util.Iterator<E> descendingIterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Spliterator} over the elements in this deque.
 *
 * <p>The returned spliterator is
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * <p>The {@code Spliterator} reports {@link Spliterator#CONCURRENT},
 * {@link Spliterator#ORDERED}, and {@link Spliterator#NONNULL}.
 *
 * @implNote
 * The {@code Spliterator} implements {@code trySplit} to permit limited
 * parallelism.
 *
 * @return a {@code Spliterator} over the elements in this deque
 * @since 1.8
 */

public java.util.Spliterator<E> spliterator() { throw new RuntimeException("Stub!"); }
}

