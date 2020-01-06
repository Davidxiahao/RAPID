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
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */


package java.util.concurrent;

import java.util.Iterator;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.concurrent.locks.Condition;
import java.util.Spliterators;

/**
 * An optionally-bounded {@linkplain BlockingDeque blocking deque} based on
 * linked nodes.
 *
 * <p>The optional capacity bound constructor argument serves as a
 * way to prevent excessive expansion. The capacity, if unspecified,
 * is equal to {@link Integer#MAX_VALUE}.  Linked nodes are
 * dynamically created upon each insertion unless this would bring the
 * deque above capacity.
 *
 * <p>Most operations run in constant time (ignoring time spent
 * blocking).  Exceptions include {@link #remove(Object) remove},
 * {@link #removeFirstOccurrence removeFirstOccurrence}, {@link
 * #removeLastOccurrence removeLastOccurrence}, {@link #contains
 * contains}, {@link #iterator iterator.remove()}, and the bulk
 * operations, all of which run in linear time.
 *
 * <p>This class and its iterator implement all of the
 * <em>optional</em> methods of the {@link Collection} and {@link
 * Iterator} interfaces.
 *
 * @since 1.6
 * @author  Doug Lea
 * @param <E> the type of elements held in this deque
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LinkedBlockingDeque<E> extends java.util.AbstractQueue<E> implements java.util.concurrent.BlockingDeque<E>, java.io.Serializable {

/**
 * Creates a {@code LinkedBlockingDeque} with a capacity of
 * {@link Integer#MAX_VALUE}.
 */

public LinkedBlockingDeque() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code LinkedBlockingDeque} with the given (fixed) capacity.
 *
 * @param capacity the capacity of this deque
 * @throws IllegalArgumentException if {@code capacity} is less than 1
 */

public LinkedBlockingDeque(int capacity) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code LinkedBlockingDeque} with a capacity of
 * {@link Integer#MAX_VALUE}, initially containing the elements of
 * the given collection, added in traversal order of the
 * collection's iterator.
 *
 * @param c the collection of elements to initially contain
 * @throws NullPointerException if the specified collection or any
 *         of its elements are null
 */

public LinkedBlockingDeque(java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * @throws IllegalStateException if this deque is full
 * @throws NullPointerException {@inheritDoc}
 */

public void addFirst(E e) { throw new RuntimeException("Stub!"); }

/**
 * @throws IllegalStateException if this deque is full
 * @throws NullPointerException  {@inheritDoc}
 */

public void addLast(E e) { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 */

public boolean offerFirst(E e) { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 */

public boolean offerLast(E e) { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 * @throws InterruptedException {@inheritDoc}
 */

public void putFirst(E e) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 * @throws InterruptedException {@inheritDoc}
 */

public void putLast(E e) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 * @throws InterruptedException {@inheritDoc}
 */

public boolean offerFirst(E e, long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 * @throws InterruptedException {@inheritDoc}
 */

public boolean offerLast(E e, long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * @throws NoSuchElementException {@inheritDoc}
 */

public E removeFirst() { throw new RuntimeException("Stub!"); }

/**
 * @throws NoSuchElementException {@inheritDoc}
 */

public E removeLast() { throw new RuntimeException("Stub!"); }

public E pollFirst() { throw new RuntimeException("Stub!"); }

public E pollLast() { throw new RuntimeException("Stub!"); }

public E takeFirst() throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

public E takeLast() throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

public E pollFirst(long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

public E pollLast(long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * @throws NoSuchElementException {@inheritDoc}
 */

public E getFirst() { throw new RuntimeException("Stub!"); }

/**
 * @throws NoSuchElementException {@inheritDoc}
 */

public E getLast() { throw new RuntimeException("Stub!"); }

public E peekFirst() { throw new RuntimeException("Stub!"); }

public E peekLast() { throw new RuntimeException("Stub!"); }

public boolean removeFirstOccurrence(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public boolean removeLastOccurrence(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element at the end of this deque unless it would
 * violate capacity restrictions.  When using a capacity-restricted deque,
 * it is generally preferable to use method {@link #offer(Object) offer}.
 *
 * <p>This method is equivalent to {@link #addLast}.
 *
 * @throws IllegalStateException if this deque is full
 * @throws NullPointerException if the specified element is null
 */

public boolean add(E e) { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException if the specified element is null
 */

public boolean offer(E e) { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 * @throws InterruptedException {@inheritDoc}
 */

public void put(E e) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 * @throws InterruptedException {@inheritDoc}
 */

public boolean offer(E e, long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves and removes the head of the queue represented by this deque.
 * This method differs from {@link #poll poll} only in that it throws an
 * exception if this deque is empty.
 *
 * <p>This method is equivalent to {@link #removeFirst() removeFirst}.
 *
 * @return the head of the queue represented by this deque
 * @throws NoSuchElementException if this deque is empty
 */

public E remove() { throw new RuntimeException("Stub!"); }

public E poll() { throw new RuntimeException("Stub!"); }

public E take() throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

public E poll(long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves, but does not remove, the head of the queue represented by
 * this deque.  This method differs from {@link #peek peek} only in that
 * it throws an exception if this deque is empty.
 *
 * <p>This method is equivalent to {@link #getFirst() getFirst}.
 *
 * @return the head of the queue represented by this deque
 * @throws NoSuchElementException if this deque is empty
 */

public E element() { throw new RuntimeException("Stub!"); }

public E peek() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of additional elements that this deque can ideally
 * (in the absence of memory or resource constraints) accept without
 * blocking. This is always equal to the initial capacity of this deque
 * less the current {@code size} of this deque.
 *
 * <p>Note that you <em>cannot</em> always tell if an attempt to insert
 * an element will succeed by inspecting {@code remainingCapacity}
 * because it may be the case that another thread is about to
 * insert or remove an element.
 */

public int remainingCapacity() { throw new RuntimeException("Stub!"); }

/**
 * @throws UnsupportedOperationException {@inheritDoc}
 * @throws ClassCastException            {@inheritDoc}
 * @throws NullPointerException          {@inheritDoc}
 * @throws IllegalArgumentException      {@inheritDoc}
 */

public int drainTo(java.util.Collection<? super E> c) { throw new RuntimeException("Stub!"); }

/**
 * @throws UnsupportedOperationException {@inheritDoc}
 * @throws ClassCastException            {@inheritDoc}
 * @throws NullPointerException          {@inheritDoc}
 * @throws IllegalArgumentException      {@inheritDoc}
 */

public int drainTo(java.util.Collection<? super E> c, int maxElements) { throw new RuntimeException("Stub!"); }

/**
 * @throws IllegalStateException if this deque is full
 * @throws NullPointerException {@inheritDoc}
 */

public void push(E e) { throw new RuntimeException("Stub!"); }

/**
 * @throws NoSuchElementException {@inheritDoc}
 */

public E pop() { throw new RuntimeException("Stub!"); }

/**
 * Removes the first occurrence of the specified element from this deque.
 * If the deque does not contain the element, it is unchanged.
 * More formally, removes the first element {@code e} such that
 * {@code o.equals(e)} (if such an element exists).
 * Returns {@code true} if this deque contained the specified element
 * (or equivalently, if this deque changed as a result of the call).
 *
 * <p>This method is equivalent to
 * {@link #removeFirstOccurrence(Object) removeFirstOccurrence}.
 *
 * @param o element to be removed from this deque, if present
 * @return {@code true} if this deque changed as a result of the call
 */

public boolean remove(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of elements in this deque.
 *
 * @return the number of elements in this deque
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this deque contains the specified element.
 * More formally, returns {@code true} if and only if this deque contains
 * at least one element {@code e} such that {@code o.equals(e)}.
 *
 * @param o object to be checked for containment in this deque
 * @return {@code true} if this deque contains the specified element
 */

public boolean contains(java.lang.Object o) { throw new RuntimeException("Stub!"); }

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
 * Returns an array containing all of the elements in this deque, in
 * proper sequence; the runtime type of the returned array is that of
 * the specified array.  If the deque fits in the specified array, it
 * is returned therein.  Otherwise, a new array is allocated with the
 * runtime type of the specified array and the size of this deque.
 *
 * <p>If this deque fits in the specified array with room to spare
 * (i.e., the array has more elements than this deque), the element in
 * the array immediately following the end of the deque is set to
 * {@code null}.
 *
 * <p>Like the {@link #toArray()} method, this method acts as bridge between
 * array-based and collection-based APIs.  Further, this method allows
 * precise control over the runtime type of the output array, and may,
 * under certain circumstances, be used to save allocation costs.
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

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Atomically removes all of the elements from this deque.
 * The deque will be empty after this call returns.
 */

public void clear() { throw new RuntimeException("Stub!"); }

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

