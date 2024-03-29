/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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


/**
 * An unbounded priority {@linkplain Queue queue} based on a priority heap.
 * The elements of the priority queue are ordered according to their
 * {@linkplain Comparable natural ordering}, or by a {@link Comparator}
 * provided at queue construction time, depending on which constructor is
 * used.  A priority queue does not permit {@code null} elements.
 * A priority queue relying on natural ordering also does not permit
 * insertion of non-comparable objects (doing so may result in
 * {@code ClassCastException}).
 *
 * <p>The <em>head</em> of this queue is the <em>least</em> element
 * with respect to the specified ordering.  If multiple elements are
 * tied for least value, the head is one of those elements -- ties are
 * broken arbitrarily.  The queue retrieval operations {@code poll},
 * {@code remove}, {@code peek}, and {@code element} access the
 * element at the head of the queue.
 *
 * <p>A priority queue is unbounded, but has an internal
 * <i>capacity</i> governing the size of an array used to store the
 * elements on the queue.  It is always at least as large as the queue
 * size.  As elements are added to a priority queue, its capacity
 * grows automatically.  The details of the growth policy are not
 * specified.
 *
 * <p>This class and its iterator implement all of the
 * <em>optional</em> methods of the {@link Collection} and {@link
 * Iterator} interfaces.  The Iterator provided in method {@link
 * #iterator()} is <em>not</em> guaranteed to traverse the elements of
 * the priority queue in any particular order. If you need ordered
 * traversal, consider using {@code Arrays.sort(pq.toArray())}.
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * Multiple threads should not access a {@code PriorityQueue}
 * instance concurrently if any of the threads modifies the queue.
 * Instead, use the thread-safe {@link
 * java.util.concurrent.PriorityBlockingQueue} class.
 *
 * <p>Implementation note: this implementation provides
 * O(log(n)) time for the enqueuing and dequeuing methods
 * ({@code offer}, {@code poll}, {@code remove()} and {@code add});
 * linear time for the {@code remove(Object)} and {@code contains(Object)}
 * methods; and constant time for the retrieval methods
 * ({@code peek}, {@code element}, and {@code size}).
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @since 1.5
 * @author Josh Bloch, Doug Lea
 * @param <E> the type of elements held in this queue
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PriorityQueue<E> extends java.util.AbstractQueue<E> implements java.io.Serializable {

/**
 * Creates a {@code PriorityQueue} with the default initial
 * capacity (11) that orders its elements according to their
 * {@linkplain Comparable natural ordering}.
 */

public PriorityQueue() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code PriorityQueue} with the specified initial
 * capacity that orders its elements according to their
 * {@linkplain Comparable natural ordering}.
 *
 * @param initialCapacity the initial capacity for this priority queue
 * @throws IllegalArgumentException if {@code initialCapacity} is less
 *         than 1
 */

public PriorityQueue(int initialCapacity) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code PriorityQueue} with the default initial capacity and
 * whose elements are ordered according to the specified comparator.
 *
 * @param  comparator the comparator that will be used to order this
 *         priority queue.  If {@code null}, the {@linkplain Comparable
 *         natural ordering} of the elements will be used.
 * @since 1.8
 */

public PriorityQueue(java.util.Comparator<? super E> comparator) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code PriorityQueue} with the specified initial capacity
 * that orders its elements according to the specified comparator.
 *
 * @param  initialCapacity the initial capacity for this priority queue
 * @param  comparator the comparator that will be used to order this
 *         priority queue.  If {@code null}, the {@linkplain Comparable
 *         natural ordering} of the elements will be used.
 * @throws IllegalArgumentException if {@code initialCapacity} is
 *         less than 1
 */

public PriorityQueue(int initialCapacity, java.util.Comparator<? super E> comparator) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code PriorityQueue} containing the elements in the
 * specified collection.  If the specified collection is an instance of
 * a {@link SortedSet} or is another {@code PriorityQueue}, this
 * priority queue will be ordered according to the same ordering.
 * Otherwise, this priority queue will be ordered according to the
 * {@linkplain Comparable natural ordering} of its elements.
 *
 * @param  c the collection whose elements are to be placed
 *         into this priority queue
 * @throws ClassCastException if elements of the specified collection
 *         cannot be compared to one another according to the priority
 *         queue's ordering
 * @throws NullPointerException if the specified collection or any
 *         of its elements are null
 */

public PriorityQueue(java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code PriorityQueue} containing the elements in the
 * specified priority queue.  This priority queue will be
 * ordered according to the same ordering as the given priority
 * queue.
 *
 * @param  c the priority queue whose elements are to be placed
 *         into this priority queue
 * @throws ClassCastException if elements of {@code c} cannot be
 *         compared to one another according to {@code c}'s
 *         ordering
 * @throws NullPointerException if the specified priority queue or any
 *         of its elements are null
 */

public PriorityQueue(java.util.PriorityQueue<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code PriorityQueue} containing the elements in the
 * specified sorted set.   This priority queue will be ordered
 * according to the same ordering as the given sorted set.
 *
 * @param  c the sorted set whose elements are to be placed
 *         into this priority queue
 * @throws ClassCastException if elements of the specified sorted
 *         set cannot be compared to one another according to the
 *         sorted set's ordering
 * @throws NullPointerException if the specified sorted set or any
 *         of its elements are null
 */

public PriorityQueue(java.util.SortedSet<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element into this priority queue.
 *
 * @return {@code true} (as specified by {@link Collection#add})
 * @throws ClassCastException if the specified element cannot be
 *         compared with elements currently in this priority queue
 *         according to the priority queue's ordering
 * @throws NullPointerException if the specified element is null
 */

public boolean add(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element into this priority queue.
 *
 * @return {@code true} (as specified by {@link Queue#offer})
 * @throws ClassCastException if the specified element cannot be
 *         compared with elements currently in this priority queue
 *         according to the priority queue's ordering
 * @throws NullPointerException if the specified element is null
 */

public boolean offer(E e) { throw new RuntimeException("Stub!"); }

public E peek() { throw new RuntimeException("Stub!"); }

/**
 * Removes a single instance of the specified element from this queue,
 * if it is present.  More formally, removes an element {@code e} such
 * that {@code o.equals(e)}, if this queue contains one or more such
 * elements.  Returns {@code true} if and only if this queue contained
 * the specified element (or equivalently, if this queue changed as a
 * result of the call).
 *
 * @param o element to be removed from this queue, if present
 * @return {@code true} if this queue changed as a result of the call
 */

public boolean remove(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this queue contains the specified element.
 * More formally, returns {@code true} if and only if this queue contains
 * at least one element {@code e} such that {@code o.equals(e)}.
 *
 * @param o object to be checked for containment in this queue
 * @return {@code true} if this queue contains the specified element
 */

public boolean contains(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing all of the elements in this queue.
 * The elements are in no particular order.
 *
 * <p>The returned array will be "safe" in that no references to it are
 * maintained by this queue.  (In other words, this method must allocate
 * a new array).  The caller is thus free to modify the returned array.
 *
 * <p>This method acts as bridge between array-based and collection-based
 * APIs.
 *
 * @return an array containing all of the elements in this queue
 */

public java.lang.Object[] toArray() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing all of the elements in this queue; the
 * runtime type of the returned array is that of the specified array.
 * The returned array elements are in no particular order.
 * If the queue fits in the specified array, it is returned therein.
 * Otherwise, a new array is allocated with the runtime type of the
 * specified array and the size of this queue.
 *
 * <p>If the queue fits in the specified array with room to spare
 * (i.e., the array has more elements than the queue), the element in
 * the array immediately following the end of the collection is set to
 * {@code null}.
 *
 * <p>Like the {@link #toArray()} method, this method acts as bridge between
 * array-based and collection-based APIs.  Further, this method allows
 * precise control over the runtime type of the output array, and may,
 * under certain circumstances, be used to save allocation costs.
 *
 * <p>Suppose {@code x} is a queue known to contain only strings.
 * The following code can be used to dump the queue into a newly
 * allocated array of {@code String}:
 *
 * <pre> {@code String[] y = x.toArray(new String[0]);}</pre>
 *
 * Note that {@code toArray(new Object[0])} is identical in function to
 * {@code toArray()}.
 *
 * @param a the array into which the elements of the queue are to
 *          be stored, if it is big enough; otherwise, a new array of the
 *          same runtime type is allocated for this purpose.
 * @return an array containing all of the elements in this queue
 * @throws ArrayStoreException if the runtime type of the specified array
 *         is not a supertype of the runtime type of every element in
 *         this queue
 * @throws NullPointerException if the specified array is null
 */

public <T> T[] toArray(T[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over the elements in this queue. The iterator
 * does not return the elements in any particular order.
 *
 * @return an iterator over the elements in this queue
 */

public java.util.Iterator<E> iterator() { throw new RuntimeException("Stub!"); }

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Removes all of the elements from this priority queue.
 * The queue will be empty after this call returns.
 */

public void clear() { throw new RuntimeException("Stub!"); }

public E poll() { throw new RuntimeException("Stub!"); }

/**
 * Returns the comparator used to order the elements in this
 * queue, or {@code null} if this queue is sorted according to
 * the {@linkplain Comparable natural ordering} of its elements.
 *
 * @return the comparator used to order this queue, or
 *         {@code null} if this queue is sorted according to the
 *         natural ordering of its elements
 */

public java.util.Comparator<? super E> comparator() { throw new RuntimeException("Stub!"); }

/**
 * Creates a <em><a href="Spliterator.html#binding">late-binding</a></em>
 * and <em>fail-fast</em> {@link Spliterator} over the elements in this
 * queue.
 *
 * <p>The {@code Spliterator} reports {@link Spliterator#SIZED},
 * {@link Spliterator#SUBSIZED}, and {@link Spliterator#NONNULL}.
 * Overriding implementations should document the reporting of additional
 * characteristic values.
 *
 * @return a {@code Spliterator} over the elements in this queue
 * @since 1.8
 */

public final java.util.Spliterator<E> spliterator() { throw new RuntimeException("Stub!"); }
}

