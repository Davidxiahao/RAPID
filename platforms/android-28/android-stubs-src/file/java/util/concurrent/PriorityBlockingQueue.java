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

import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Collection;
import java.util.Arrays;
import java.util.Queue;
import java.util.SortedSet;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.concurrent.locks.Condition;

/**
 * An unbounded {@linkplain BlockingQueue blocking queue} that uses
 * the same ordering rules as class {@link PriorityQueue} and supplies
 * blocking retrieval operations.  While this queue is logically
 * unbounded, attempted additions may fail due to resource exhaustion
 * (causing {@code OutOfMemoryError}). This class does not permit
 * {@code null} elements.  A priority queue relying on {@linkplain
 * Comparable natural ordering} also does not permit insertion of
 * non-comparable objects (doing so results in
 * {@code ClassCastException}).
 *
 * <p>This class and its iterator implement all of the
 * <em>optional</em> methods of the {@link Collection} and {@link
 * Iterator} interfaces.  The Iterator provided in method {@link
 * #iterator()} is <em>not</em> guaranteed to traverse the elements of
 * the PriorityBlockingQueue in any particular order. If you need
 * ordered traversal, consider using
 * {@code Arrays.sort(pq.toArray())}.  Also, method {@code drainTo}
 * can be used to <em>remove</em> some or all elements in priority
 * order and place them in another collection.
 *
 * <p>Operations on this class make no guarantees about the ordering
 * of elements with equal priority. If you need to enforce an
 * ordering, you can define custom classes or comparators that use a
 * secondary key to break ties in primary priority values.  For
 * example, here is a class that applies first-in-first-out
 * tie-breaking to comparable elements. To use it, you would insert a
 * {@code new FIFOEntry(anEntry)} instead of a plain entry object.
 *
 * <pre> {@code
 * class FIFOEntry<E extends Comparable<? super E>>
 *     implements Comparable<FIFOEntry<E>> {
 *   static final AtomicLong seq = new AtomicLong(0);
 *   final long seqNum;
 *   final E entry;
 *   public FIFOEntry(E entry) {
 *     seqNum = seq.getAndIncrement();
 *     this.entry = entry;
 *   }
 *   public E getEntry() { return entry; }
 *   public int compareTo(FIFOEntry<E> other) {
 *     int res = entry.compareTo(other.entry);
 *     if (res == 0 && other.entry != this.entry)
 *       res = (seqNum < other.seqNum ? -1 : 1);
 *     return res;
 *   }
 * }}</pre>
 *
 * @since 1.5
 * @author Doug Lea
 * @param <E> the type of elements held in this queue
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class PriorityBlockingQueue<E> extends java.util.AbstractQueue<E> implements java.util.concurrent.BlockingQueue<E>, java.io.Serializable {

/**
 * Creates a {@code PriorityBlockingQueue} with the default
 * initial capacity (11) that orders its elements according to
 * their {@linkplain Comparable natural ordering}.
 */

public PriorityBlockingQueue() { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code PriorityBlockingQueue} with the specified
 * initial capacity that orders its elements according to their
 * {@linkplain Comparable natural ordering}.
 *
 * @param initialCapacity the initial capacity for this priority queue
 * @throws IllegalArgumentException if {@code initialCapacity} is less
 *         than 1
 */

public PriorityBlockingQueue(int initialCapacity) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code PriorityBlockingQueue} with the specified initial
 * capacity that orders its elements according to the specified
 * comparator.
 *
 * @param initialCapacity the initial capacity for this priority queue
 * @param  comparator the comparator that will be used to order this
 *         priority queue.  If {@code null}, the {@linkplain Comparable
 *         natural ordering} of the elements will be used.
 * @throws IllegalArgumentException if {@code initialCapacity} is less
 *         than 1
 */

public PriorityBlockingQueue(int initialCapacity, java.util.Comparator<? super E> comparator) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@code PriorityBlockingQueue} containing the elements
 * in the specified collection.  If the specified collection is a
 * {@link SortedSet} or a {@link PriorityQueue}, this
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

public PriorityBlockingQueue(java.util.Collection<? extends E> c) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element into this priority queue.
 *
 * @param e the element to add
 * @return {@code true} (as specified by {@link Collection#add})
 * @throws ClassCastException if the specified element cannot be compared
 *         with elements currently in the priority queue according to the
 *         priority queue's ordering
 * @throws NullPointerException if the specified element is null
 */

public boolean add(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element into this priority queue.
 * As the queue is unbounded, this method will never return {@code false}.
 *
 * @param e the element to add
 * @return {@code true} (as specified by {@link Queue#offer})
 * @throws ClassCastException if the specified element cannot be compared
 *         with elements currently in the priority queue according to the
 *         priority queue's ordering
 * @throws NullPointerException if the specified element is null
 */

public boolean offer(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element into this priority queue.
 * As the queue is unbounded, this method will never block.
 *
 * @param e the element to add
 * @throws ClassCastException if the specified element cannot be compared
 *         with elements currently in the priority queue according to the
 *         priority queue's ordering
 * @throws NullPointerException if the specified element is null
 */

public void put(E e) { throw new RuntimeException("Stub!"); }

/**
 * Inserts the specified element into this priority queue.
 * As the queue is unbounded, this method will never block or
 * return {@code false}.
 *
 * @param e the element to add
 * @param timeout This parameter is ignored as the method never blocks
 * @param unit This parameter is ignored as the method never blocks
 * @return {@code true} (as specified by
 *  {@link BlockingQueue#offer(Object,long,TimeUnit) BlockingQueue.offer})
 * @throws ClassCastException if the specified element cannot be compared
 *         with elements currently in the priority queue according to the
 *         priority queue's ordering
 * @throws NullPointerException if the specified element is null
 */

public boolean offer(E e, long timeout, java.util.concurrent.TimeUnit unit) { throw new RuntimeException("Stub!"); }

public E poll() { throw new RuntimeException("Stub!"); }

public E take() throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

public E poll(long timeout, java.util.concurrent.TimeUnit unit) throws java.lang.InterruptedException { throw new RuntimeException("Stub!"); }

public E peek() { throw new RuntimeException("Stub!"); }

/**
 * Returns the comparator used to order the elements in this queue,
 * or {@code null} if this queue uses the {@linkplain Comparable
 * natural ordering} of its elements.
 *
 * @return the comparator used to order the elements in this queue,
 *         or {@code null} if this queue uses the natural
 *         ordering of its elements
 */

public java.util.Comparator<? super E> comparator() { throw new RuntimeException("Stub!"); }

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Always returns {@code Integer.MAX_VALUE} because
 * a {@code PriorityBlockingQueue} is not capacity constrained.
 * @return {@code Integer.MAX_VALUE} always
 */

public int remainingCapacity() { throw new RuntimeException("Stub!"); }

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

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

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
 * Atomically removes all of the elements from this queue.
 * The queue will be empty after this call returns.
 */

public void clear() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array containing all of the elements in this queue.
 * The returned array elements are in no particular order.
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
 * <p>If this queue fits in the specified array with room to spare
 * (i.e., the array has more elements than this queue), the element in
 * the array immediately following the end of the queue is set to
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
 *          same runtime type is allocated for this purpose
 * @return an array containing all of the elements in this queue
 * @throws ArrayStoreException if the runtime type of the specified array
 *         is not a supertype of the runtime type of every element in
 *         this queue
 * @throws NullPointerException if the specified array is null
 */

public <T> T[] toArray(T[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns an iterator over the elements in this queue. The
 * iterator does not return the elements in any particular order.
 *
 * <p>The returned iterator is
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * @return an iterator over the elements in this queue
 */

public java.util.Iterator<E> iterator() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Spliterator} over the elements in this queue.
 *
 * <p>The returned spliterator is
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * <p>The {@code Spliterator} reports {@link Spliterator#SIZED} and
 * {@link Spliterator#NONNULL}.
 *
 * @implNote
 * The {@code Spliterator} additionally reports {@link Spliterator#SUBSIZED}.
 *
 * @return a {@code Spliterator} over the elements in this queue
 * @since 1.8
 */

public java.util.Spliterator<E> spliterator() { throw new RuntimeException("Stub!"); }
}

