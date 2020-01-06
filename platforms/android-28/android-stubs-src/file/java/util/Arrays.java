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
import java.util.concurrent.ForkJoinPool;
import java.util.function.BinaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;

/**
 * This class contains various methods for manipulating arrays (such as
 * sorting and searching). This class also contains a static factory
 * that allows arrays to be viewed as lists.
 *
 * <p>The methods in this class all throw a {@code NullPointerException},
 * if the specified array reference is null, except where noted.
 *
 * <p>The documentation for the methods contained in this class includes
 * briefs description of the <i>implementations</i>. Such descriptions should
 * be regarded as <i>implementation notes</i>, rather than parts of the
 * <i>specification</i>. Implementors should feel free to substitute other
 * algorithms, so long as the specification itself is adhered to. (For
 * example, the algorithm used by {@code sort(Object[])} does not have to be
 * a MergeSort, but it does have to be <i>stable</i>.)
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}openjdk-redirect.html?v=8&path=/technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author Josh Bloch
 * @author Neal Gafter
 * @author John Rose
 * @since  1.2
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Arrays {

Arrays() { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 */

public static void sort(int[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 */

public static void sort(int[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 */

public static void sort(long[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 */

public static void sort(long[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 */

public static void sort(short[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 */

public static void sort(short[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 */

public static void sort(char[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 */

public static void sort(char[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 */

public static void sort(byte[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 */

public static void sort(byte[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>The {@code <} relation does not provide a total order on all float
 * values: {@code -0.0f == 0.0f} is {@code true} and a {@code Float.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link Float#compareTo}: {@code -0.0f} is treated as less than value
 * {@code 0.0f} and {@code Float.NaN} is considered greater than any
 * other value and all {@code Float.NaN} values are considered equal.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 */

public static void sort(float[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>The {@code <} relation does not provide a total order on all float
 * values: {@code -0.0f == 0.0f} is {@code true} and a {@code Float.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link Float#compareTo}: {@code -0.0f} is treated as less than value
 * {@code 0.0f} and {@code Float.NaN} is considered greater than any
 * other value and all {@code Float.NaN} values are considered equal.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 */

public static void sort(float[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>The {@code <} relation does not provide a total order on all double
 * values: {@code -0.0d == 0.0d} is {@code true} and a {@code Double.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link Double#compareTo}: {@code -0.0d} is treated as less than value
 * {@code 0.0d} and {@code Double.NaN} is considered greater than any
 * other value and all {@code Double.NaN} values are considered equal.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 */

public static void sort(double[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending order. The range
 * to be sorted extends from the index {@code fromIndex}, inclusive, to
 * the index {@code toIndex}, exclusive. If {@code fromIndex == toIndex},
 * the range to be sorted is empty.
 *
 * <p>The {@code <} relation does not provide a total order on all double
 * values: {@code -0.0d == 0.0d} is {@code true} and a {@code Double.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link Double#compareTo}: {@code -0.0d} is treated as less than value
 * {@code 0.0d} and {@code Double.NaN} is considered greater than any
 * other value and all {@code Double.NaN} values are considered equal.
 *
 * <p>Implementation note: The sorting algorithm is a Dual-Pivot Quicksort
 * by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch. This algorithm
 * offers O(n log(n)) performance on many data sets that cause other
 * quicksorts to degrade to quadratic performance, and is typically
 * faster than traditional (one-pivot) Quicksort implementations.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 */

public static void sort(double[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(byte[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(byte[]) Arrays.sort} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link ForkJoinPool#commonPool() ForkJoin common pool} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 */

public static void parallelSort(byte[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(byte[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(byte[]) Arrays.sort} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link ForkJoinPool#commonPool() ForkJoin common pool} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 */

public static void parallelSort(byte[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(char[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(char[]) Arrays.sort} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link ForkJoinPool#commonPool() ForkJoin common pool} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 */

public static void parallelSort(char[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(char[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(char[]) Arrays.sort} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link ForkJoinPool#commonPool() ForkJoin common pool} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 */

public static void parallelSort(char[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(short[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(short[]) Arrays.sort} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link ForkJoinPool#commonPool() ForkJoin common pool} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 */

public static void parallelSort(short[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(short[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(short[]) Arrays.sort} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link ForkJoinPool#commonPool() ForkJoin common pool} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 */

public static void parallelSort(short[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(int[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(int[]) Arrays.sort} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link ForkJoinPool#commonPool() ForkJoin common pool} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 */

public static void parallelSort(int[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(int[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(int[]) Arrays.sort} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link ForkJoinPool#commonPool() ForkJoin common pool} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 */

public static void parallelSort(int[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(long[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(long[]) Arrays.sort} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link ForkJoinPool#commonPool() ForkJoin common pool} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 */

public static void parallelSort(long[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(long[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(long[]) Arrays.sort} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link ForkJoinPool#commonPool() ForkJoin common pool} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 */

public static void parallelSort(long[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>The {@code <} relation does not provide a total order on all float
 * values: {@code -0.0f == 0.0f} is {@code true} and a {@code Float.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link Float#compareTo}: {@code -0.0f} is treated as less than value
 * {@code 0.0f} and {@code Float.NaN} is considered greater than any
 * other value and all {@code Float.NaN} values are considered equal.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(float[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(float[]) Arrays.sort} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link ForkJoinPool#commonPool() ForkJoin common pool} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 */

public static void parallelSort(float[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 * <p>The {@code <} relation does not provide a total order on all float
 * values: {@code -0.0f == 0.0f} is {@code true} and a {@code Float.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link Float#compareTo}: {@code -0.0f} is treated as less than value
 * {@code 0.0f} and {@code Float.NaN} is considered greater than any
 * other value and all {@code Float.NaN} values are considered equal.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(float[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(float[]) Arrays.sort} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link ForkJoinPool#commonPool() ForkJoin common pool} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 */

public static void parallelSort(float[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array into ascending numerical order.
 *
 * <p>The {@code <} relation does not provide a total order on all double
 * values: {@code -0.0d == 0.0d} is {@code true} and a {@code Double.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link Double#compareTo}: {@code -0.0d} is treated as less than value
 * {@code 0.0d} and {@code Double.NaN} is considered greater than any
 * other value and all {@code Double.NaN} values are considered equal.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(double[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(double[]) Arrays.sort} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link ForkJoinPool#commonPool() ForkJoin common pool} is used to
 * execute any parallel tasks.
 *
 * @param a the array to be sorted
 *
 * @since 1.8
 */

public static void parallelSort(double[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the array into ascending numerical order.
 * The range to be sorted extends from the index {@code fromIndex},
 * inclusive, to the index {@code toIndex}, exclusive. If
 * {@code fromIndex == toIndex}, the range to be sorted is empty.
 *
 * <p>The {@code <} relation does not provide a total order on all double
 * values: {@code -0.0d == 0.0d} is {@code true} and a {@code Double.NaN}
 * value compares neither less than, greater than, nor equal to any value,
 * even itself. This method uses the total order imposed by the method
 * {@link Double#compareTo}: {@code -0.0d} is treated as less than value
 * {@code 0.0d} and {@code Double.NaN} is considered greater than any
 * other value and all {@code Double.NaN} values are considered equal.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(double[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(double[]) Arrays.sort} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link ForkJoinPool#commonPool() ForkJoin common pool} is
 * used to execute any parallel tasks.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element, inclusive, to be sorted
 * @param toIndex the index of the last element, exclusive, to be sorted
 *
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > a.length}
 *
 * @since 1.8
 */

public static void parallelSort(double[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array of objects into ascending order, according
 * to the {@linkplain Comparable natural ordering} of its elements.
 * All elements in the array must implement the {@link Comparable}
 * interface.  Furthermore, all elements in the array must be
 * <i>mutually comparable</i> (that is, {@code e1.compareTo(e2)} must
 * not throw a {@code ClassCastException} for any elements {@code e1}
 * and {@code e2} in the array).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(Object[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(Object[]) Arrays.sort} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link ForkJoinPool#commonPool() ForkJoin common pool} is used to
 * execute any parallel tasks.
 *
 * @param <T> the class of the objects to be sorted
 * @param a the array to be sorted
 *
 * @throws ClassCastException if the array contains elements that are not
 *         <i>mutually comparable</i> (for example, strings and integers)
 * @throws IllegalArgumentException (optional) if the natural
 *         ordering of the array elements is found to violate the
 *         {@link Comparable} contract
 *
 * @since 1.8
 */

public static <T extends java.lang.Comparable<? super T>> void parallelSort(T[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the specified array of objects into
 * ascending order, according to the
 * {@linkplain Comparable natural ordering} of its
 * elements.  The range to be sorted extends from index
 * {@code fromIndex}, inclusive, to index {@code toIndex}, exclusive.
 * (If {@code fromIndex==toIndex}, the range to be sorted is empty.)  All
 * elements in this range must implement the {@link Comparable}
 * interface.  Furthermore, all elements in this range must be <i>mutually
 * comparable</i> (that is, {@code e1.compareTo(e2)} must not throw a
 * {@code ClassCastException} for any elements {@code e1} and
 * {@code e2} in the array).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(Object[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(Object[]) Arrays.sort} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link ForkJoinPool#commonPool() ForkJoin common pool} is
 * used to execute any parallel tasks.
 *
 * @param <T> the class of the objects to be sorted
 * @param a the array to be sorted
 * @param fromIndex the index of the first element (inclusive) to be
 *        sorted
 * @param toIndex the index of the last element (exclusive) to be sorted
 * @throws IllegalArgumentException if {@code fromIndex > toIndex} or
 *         (optional) if the natural ordering of the array elements is
 *         found to violate the {@link Comparable} contract
 * @throws ArrayIndexOutOfBoundsException if {@code fromIndex < 0} or
 *         {@code toIndex > a.length}
 * @throws ClassCastException if the array contains elements that are
 *         not <i>mutually comparable</i> (for example, strings and
 *         integers).
 *
 * @since 1.8
 */

public static <T extends java.lang.Comparable<? super T>> void parallelSort(T[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array of objects according to the order induced by
 * the specified comparator.  All elements in the array must be
 * <i>mutually comparable</i> by the specified comparator (that is,
 * {@code c.compare(e1, e2)} must not throw a {@code ClassCastException}
 * for any elements {@code e1} and {@code e2} in the array).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(Object[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(Object[]) Arrays.sort} method. The algorithm requires a
 * working space no greater than the size of the original array. The
 * {@link ForkJoinPool#commonPool() ForkJoin common pool} is used to
 * execute any parallel tasks.
 *
 * @param <T> the class of the objects to be sorted
 * @param a the array to be sorted
 * @param cmp the comparator to determine the order of the array.  A
 *        {@code null} value indicates that the elements'
 *        {@linkplain Comparable natural ordering} should be used.
 * @throws ClassCastException if the array contains elements that are
 *         not <i>mutually comparable</i> using the specified comparator
 * @throws IllegalArgumentException (optional) if the comparator is
 *         found to violate the {@link java.util.Comparator} contract
 *
 * @since 1.8
 */

public static <T> void parallelSort(T[] a, java.util.Comparator<? super T> cmp) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the specified array of objects according
 * to the order induced by the specified comparator.  The range to be
 * sorted extends from index {@code fromIndex}, inclusive, to index
 * {@code toIndex}, exclusive.  (If {@code fromIndex==toIndex}, the
 * range to be sorted is empty.)  All elements in the range must be
 * <i>mutually comparable</i> by the specified comparator (that is,
 * {@code c.compare(e1, e2)} must not throw a {@code ClassCastException}
 * for any elements {@code e1} and {@code e2} in the range).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * @implNote The sorting algorithm is a parallel sort-merge that breaks the
 * array into sub-arrays that are themselves sorted and then merged. When
 * the sub-array length reaches a minimum granularity, the sub-array is
 * sorted using the appropriate {@link Arrays#sort(Object[]) Arrays.sort}
 * method. If the length of the specified array is less than the minimum
 * granularity, then it is sorted using the appropriate {@link
 * Arrays#sort(Object[]) Arrays.sort} method. The algorithm requires a working
 * space no greater than the size of the specified range of the original
 * array. The {@link ForkJoinPool#commonPool() ForkJoin common pool} is
 * used to execute any parallel tasks.
 *
 * @param <T> the class of the objects to be sorted
 * @param a the array to be sorted
 * @param fromIndex the index of the first element (inclusive) to be
 *        sorted
 * @param toIndex the index of the last element (exclusive) to be sorted
 * @param cmp the comparator to determine the order of the array.  A
 *        {@code null} value indicates that the elements'
 *        {@linkplain Comparable natural ordering} should be used.
 * @throws IllegalArgumentException if {@code fromIndex > toIndex} or
 *         (optional) if the natural ordering of the array elements is
 *         found to violate the {@link Comparable} contract
 * @throws ArrayIndexOutOfBoundsException if {@code fromIndex < 0} or
 *         {@code toIndex > a.length}
 * @throws ClassCastException if the array contains elements that are
 *         not <i>mutually comparable</i> (for example, strings and
 *         integers).
 *
 * @since 1.8
 */

public static <T> void parallelSort(T[] a, int fromIndex, int toIndex, java.util.Comparator<? super T> cmp) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array of objects into ascending order, according
 * to the {@linkplain Comparable natural ordering} of its elements.
 * All elements in the array must implement the {@link Comparable}
 * interface.  Furthermore, all elements in the array must be
 * <i>mutually comparable</i> (that is, {@code e1.compareTo(e2)} must
 * not throw a {@code ClassCastException} for any elements {@code e1}
 * and {@code e2} in the array).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * <p>Implementation note: This implementation is a stable, adaptive,
 * iterative mergesort that requires far fewer than n lg(n) comparisons
 * when the input array is partially sorted, while offering the
 * performance of a traditional mergesort when the input array is
 * randomly ordered.  If the input array is nearly sorted, the
 * implementation requires approximately n comparisons.  Temporary
 * storage requirements vary from a small constant for nearly sorted
 * input arrays to n/2 object references for randomly ordered input
 * arrays.
 *
 * <p>The implementation takes equal advantage of ascending and
 * descending order in its input array, and can take advantage of
 * ascending and descending order in different parts of the the same
 * input array.  It is well-suited to merging two or more sorted arrays:
 * simply concatenate the arrays and sort the resulting array.
 *
 * <p>The implementation was adapted from Tim Peters's list sort for Python
 * (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
 * TimSort</a>).  It uses techniques from Peter McIlroy's "Optimistic
 * Sorting and Information Theoretic Complexity", in Proceedings of the
 * Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
 * January 1993.
 *
 * @param a the array to be sorted
 * @throws ClassCastException if the array contains elements that are not
 *         <i>mutually comparable</i> (for example, strings and integers)
 * @throws IllegalArgumentException (optional) if the natural
 *         ordering of the array elements is found to violate the
 *         {@link Comparable} contract
 */

public static void sort(java.lang.Object[] a) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the specified array of objects into
 * ascending order, according to the
 * {@linkplain Comparable natural ordering} of its
 * elements.  The range to be sorted extends from index
 * {@code fromIndex}, inclusive, to index {@code toIndex}, exclusive.
 * (If {@code fromIndex==toIndex}, the range to be sorted is empty.)  All
 * elements in this range must implement the {@link Comparable}
 * interface.  Furthermore, all elements in this range must be <i>mutually
 * comparable</i> (that is, {@code e1.compareTo(e2)} must not throw a
 * {@code ClassCastException} for any elements {@code e1} and
 * {@code e2} in the array).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * <p>Implementation note: This implementation is a stable, adaptive,
 * iterative mergesort that requires far fewer than n lg(n) comparisons
 * when the input array is partially sorted, while offering the
 * performance of a traditional mergesort when the input array is
 * randomly ordered.  If the input array is nearly sorted, the
 * implementation requires approximately n comparisons.  Temporary
 * storage requirements vary from a small constant for nearly sorted
 * input arrays to n/2 object references for randomly ordered input
 * arrays.
 *
 * <p>The implementation takes equal advantage of ascending and
 * descending order in its input array, and can take advantage of
 * ascending and descending order in different parts of the the same
 * input array.  It is well-suited to merging two or more sorted arrays:
 * simply concatenate the arrays and sort the resulting array.
 *
 * <p>The implementation was adapted from Tim Peters's list sort for Python
 * (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
 * TimSort</a>).  It uses techniques from Peter McIlroy's "Optimistic
 * Sorting and Information Theoretic Complexity", in Proceedings of the
 * Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
 * January 1993.
 *
 * @param a the array to be sorted
 * @param fromIndex the index of the first element (inclusive) to be
 *        sorted
 * @param toIndex the index of the last element (exclusive) to be sorted
 * @throws IllegalArgumentException if {@code fromIndex > toIndex} or
 *         (optional) if the natural ordering of the array elements is
 *         found to violate the {@link Comparable} contract
 * @throws ArrayIndexOutOfBoundsException if {@code fromIndex < 0} or
 *         {@code toIndex > a.length}
 * @throws ClassCastException if the array contains elements that are
 *         not <i>mutually comparable</i> (for example, strings and
 *         integers).
 */

public static void sort(java.lang.Object[] a, int fromIndex, int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified array of objects according to the order induced by
 * the specified comparator.  All elements in the array must be
 * <i>mutually comparable</i> by the specified comparator (that is,
 * {@code c.compare(e1, e2)} must not throw a {@code ClassCastException}
 * for any elements {@code e1} and {@code e2} in the array).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * <p>Implementation note: This implementation is a stable, adaptive,
 * iterative mergesort that requires far fewer than n lg(n) comparisons
 * when the input array is partially sorted, while offering the
 * performance of a traditional mergesort when the input array is
 * randomly ordered.  If the input array is nearly sorted, the
 * implementation requires approximately n comparisons.  Temporary
 * storage requirements vary from a small constant for nearly sorted
 * input arrays to n/2 object references for randomly ordered input
 * arrays.
 *
 * <p>The implementation takes equal advantage of ascending and
 * descending order in its input array, and can take advantage of
 * ascending and descending order in different parts of the the same
 * input array.  It is well-suited to merging two or more sorted arrays:
 * simply concatenate the arrays and sort the resulting array.
 *
 * <p>The implementation was adapted from Tim Peters's list sort for Python
 * (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
 * TimSort</a>).  It uses techniques from Peter McIlroy's "Optimistic
 * Sorting and Information Theoretic Complexity", in Proceedings of the
 * Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
 * January 1993.
 *
 * @param <T> the class of the objects to be sorted
 * @param a the array to be sorted
 * @param c the comparator to determine the order of the array.  A
 *        {@code null} value indicates that the elements'
 *        {@linkplain Comparable natural ordering} should be used.
 * @throws ClassCastException if the array contains elements that are
 *         not <i>mutually comparable</i> using the specified comparator
 * @throws IllegalArgumentException (optional) if the comparator is
 *         found to violate the {@link Comparator} contract
 */

public static <T> void sort(T[] a, java.util.Comparator<? super T> c) { throw new RuntimeException("Stub!"); }

/**
 * Sorts the specified range of the specified array of objects according
 * to the order induced by the specified comparator.  The range to be
 * sorted extends from index {@code fromIndex}, inclusive, to index
 * {@code toIndex}, exclusive.  (If {@code fromIndex==toIndex}, the
 * range to be sorted is empty.)  All elements in the range must be
 * <i>mutually comparable</i> by the specified comparator (that is,
 * {@code c.compare(e1, e2)} must not throw a {@code ClassCastException}
 * for any elements {@code e1} and {@code e2} in the range).
 *
 * <p>This sort is guaranteed to be <i>stable</i>:  equal elements will
 * not be reordered as a result of the sort.
 *
 * <p>Implementation note: This implementation is a stable, adaptive,
 * iterative mergesort that requires far fewer than n lg(n) comparisons
 * when the input array is partially sorted, while offering the
 * performance of a traditional mergesort when the input array is
 * randomly ordered.  If the input array is nearly sorted, the
 * implementation requires approximately n comparisons.  Temporary
 * storage requirements vary from a small constant for nearly sorted
 * input arrays to n/2 object references for randomly ordered input
 * arrays.
 *
 * <p>The implementation takes equal advantage of ascending and
 * descending order in its input array, and can take advantage of
 * ascending and descending order in different parts of the the same
 * input array.  It is well-suited to merging two or more sorted arrays:
 * simply concatenate the arrays and sort the resulting array.
 *
 * <p>The implementation was adapted from Tim Peters's list sort for Python
 * (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
 * TimSort</a>).  It uses techniques from Peter McIlroy's "Optimistic
 * Sorting and Information Theoretic Complexity", in Proceedings of the
 * Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
 * January 1993.
 *
 * @param <T> the class of the objects to be sorted
 * @param a the array to be sorted
 * @param fromIndex the index of the first element (inclusive) to be
 *        sorted
 * @param toIndex the index of the last element (exclusive) to be sorted
 * @param c the comparator to determine the order of the array.  A
 *        {@code null} value indicates that the elements'
 *        {@linkplain Comparable natural ordering} should be used.
 * @throws ClassCastException if the array contains elements that are not
 *         <i>mutually comparable</i> using the specified comparator.
 * @throws IllegalArgumentException if {@code fromIndex > toIndex} or
 *         (optional) if the comparator is found to violate the
 *         {@link Comparator} contract
 * @throws ArrayIndexOutOfBoundsException if {@code fromIndex < 0} or
 *         {@code toIndex > a.length}
 */

public static <T> void sort(T[] a, int fromIndex, int toIndex, java.util.Comparator<? super T> c) { throw new RuntimeException("Stub!"); }

/**
 * Cumulates, in parallel, each element of the given array in place,
 * using the supplied function. For example if the array initially
 * holds {@code [2, 1, 0, 3]} and the operation performs addition,
 * then upon return the array holds {@code [2, 3, 3, 6]}.
 * Parallel prefix computation is usually more efficient than
 * sequential loops for large arrays.
 *
 * @param <T> the class of the objects in the array
 * @param array the array, which is modified in-place by this method
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws NullPointerException if the specified array or function is null
 * @since 1.8
 */

public static <T> void parallelPrefix(T[] array, java.util.function.BinaryOperator<T> op) { throw new RuntimeException("Stub!"); }

/**
 * Performs {@link #parallelPrefix(Object[], BinaryOperator)}
 * for the given subrange of the array.
 *
 * @param <T> the class of the objects in the array
 * @param array the array
 * @param fromIndex the index of the first element, inclusive
 * @param toIndex the index of the last element, exclusive
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > array.length}
 * @throws NullPointerException if the specified array or function is null
 * @since 1.8
 */

public static <T> void parallelPrefix(T[] array, int fromIndex, int toIndex, java.util.function.BinaryOperator<T> op) { throw new RuntimeException("Stub!"); }

/**
 * Cumulates, in parallel, each element of the given array in place,
 * using the supplied function. For example if the array initially
 * holds {@code [2, 1, 0, 3]} and the operation performs addition,
 * then upon return the array holds {@code [2, 3, 3, 6]}.
 * Parallel prefix computation is usually more efficient than
 * sequential loops for large arrays.
 *
 * @param array the array, which is modified in-place by this method
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws NullPointerException if the specified array or function is null
 * @since 1.8
 */

public static void parallelPrefix(long[] array, java.util.function.LongBinaryOperator op) { throw new RuntimeException("Stub!"); }

/**
 * Performs {@link #parallelPrefix(long[], LongBinaryOperator)}
 * for the given subrange of the array.
 *
 * @param array the array
 * @param fromIndex the index of the first element, inclusive
 * @param toIndex the index of the last element, exclusive
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > array.length}
 * @throws NullPointerException if the specified array or function is null
 * @since 1.8
 */

public static void parallelPrefix(long[] array, int fromIndex, int toIndex, java.util.function.LongBinaryOperator op) { throw new RuntimeException("Stub!"); }

/**
 * Cumulates, in parallel, each element of the given array in place,
 * using the supplied function. For example if the array initially
 * holds {@code [2.0, 1.0, 0.0, 3.0]} and the operation performs addition,
 * then upon return the array holds {@code [2.0, 3.0, 3.0, 6.0]}.
 * Parallel prefix computation is usually more efficient than
 * sequential loops for large arrays.
 *
 * <p> Because floating-point operations may not be strictly associative,
 * the returned result may not be identical to the value that would be
 * obtained if the operation was performed sequentially.
 *
 * @param array the array, which is modified in-place by this method
 * @param op a side-effect-free function to perform the cumulation
 * @throws NullPointerException if the specified array or function is null
 * @since 1.8
 */

public static void parallelPrefix(double[] array, java.util.function.DoubleBinaryOperator op) { throw new RuntimeException("Stub!"); }

/**
 * Performs {@link #parallelPrefix(double[], DoubleBinaryOperator)}
 * for the given subrange of the array.
 *
 * @param array the array
 * @param fromIndex the index of the first element, inclusive
 * @param toIndex the index of the last element, exclusive
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > array.length}
 * @throws NullPointerException if the specified array or function is null
 * @since 1.8
 */

public static void parallelPrefix(double[] array, int fromIndex, int toIndex, java.util.function.DoubleBinaryOperator op) { throw new RuntimeException("Stub!"); }

/**
 * Cumulates, in parallel, each element of the given array in place,
 * using the supplied function. For example if the array initially
 * holds {@code [2, 1, 0, 3]} and the operation performs addition,
 * then upon return the array holds {@code [2, 3, 3, 6]}.
 * Parallel prefix computation is usually more efficient than
 * sequential loops for large arrays.
 *
 * @param array the array, which is modified in-place by this method
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws NullPointerException if the specified array or function is null
 * @since 1.8
 */

public static void parallelPrefix(int[] array, java.util.function.IntBinaryOperator op) { throw new RuntimeException("Stub!"); }

/**
 * Performs {@link #parallelPrefix(int[], IntBinaryOperator)}
 * for the given subrange of the array.
 *
 * @param array the array
 * @param fromIndex the index of the first element, inclusive
 * @param toIndex the index of the last element, exclusive
 * @param op a side-effect-free, associative function to perform the
 * cumulation
 * @throws IllegalArgumentException if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *     if {@code fromIndex < 0} or {@code toIndex > array.length}
 * @throws NullPointerException if the specified array or function is null
 * @since 1.8
 */

public static void parallelPrefix(int[] array, int fromIndex, int toIndex, java.util.function.IntBinaryOperator op) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of longs for the specified value using the
 * binary search algorithm.  The array must be sorted (as
 * by the {@link #sort(long[])} method) prior to making this call.  If it
 * is not sorted, the results are undefined.  If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 */

public static int binarySearch(long[] a, long key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of longs for the specified value using the
 * binary search algorithm.
 * The range must be sorted (as
 * by the {@link #sort(long[], int, int)} method)
 * prior to making this call.  If it
 * is not sorted, the results are undefined.  If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 */

public static int binarySearch(long[] a, int fromIndex, int toIndex, long key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of ints for the specified value using the
 * binary search algorithm.  The array must be sorted (as
 * by the {@link #sort(int[])} method) prior to making this call.  If it
 * is not sorted, the results are undefined.  If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 */

public static int binarySearch(int[] a, int key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of ints for the specified value using the
 * binary search algorithm.
 * The range must be sorted (as
 * by the {@link #sort(int[], int, int)} method)
 * prior to making this call.  If it
 * is not sorted, the results are undefined.  If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 */

public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of shorts for the specified value using
 * the binary search algorithm.  The array must be sorted
 * (as by the {@link #sort(short[])} method) prior to making this call.  If
 * it is not sorted, the results are undefined.  If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 */

public static int binarySearch(short[] a, short key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of shorts for the specified value using
 * the binary search algorithm.
 * The range must be sorted
 * (as by the {@link #sort(short[], int, int)} method)
 * prior to making this call.  If
 * it is not sorted, the results are undefined.  If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 */

public static int binarySearch(short[] a, int fromIndex, int toIndex, short key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of chars for the specified value using the
 * binary search algorithm.  The array must be sorted (as
 * by the {@link #sort(char[])} method) prior to making this call.  If it
 * is not sorted, the results are undefined.  If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 */

public static int binarySearch(char[] a, char key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of chars for the specified value using the
 * binary search algorithm.
 * The range must be sorted (as
 * by the {@link #sort(char[], int, int)} method)
 * prior to making this call.  If it
 * is not sorted, the results are undefined.  If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 */

public static int binarySearch(char[] a, int fromIndex, int toIndex, char key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of bytes for the specified value using the
 * binary search algorithm.  The array must be sorted (as
 * by the {@link #sort(byte[])} method) prior to making this call.  If it
 * is not sorted, the results are undefined.  If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 */

public static int binarySearch(byte[] a, byte key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of bytes for the specified value using the
 * binary search algorithm.
 * The range must be sorted (as
 * by the {@link #sort(byte[], int, int)} method)
 * prior to making this call.  If it
 * is not sorted, the results are undefined.  If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 */

public static int binarySearch(byte[] a, int fromIndex, int toIndex, byte key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of doubles for the specified value using
 * the binary search algorithm.  The array must be sorted
 * (as by the {@link #sort(double[])} method) prior to making this call.
 * If it is not sorted, the results are undefined.  If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.  This method considers all NaN values to be
 * equivalent and equal.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 */

public static int binarySearch(double[] a, double key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of doubles for the specified value using
 * the binary search algorithm.
 * The range must be sorted
 * (as by the {@link #sort(double[], int, int)} method)
 * prior to making this call.
 * If it is not sorted, the results are undefined.  If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found.  This method considers all NaN values to be
 * equivalent and equal.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 */

public static int binarySearch(double[] a, int fromIndex, int toIndex, double key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array of floats for the specified value using
 * the binary search algorithm. The array must be sorted
 * (as by the {@link #sort(float[])} method) prior to making this call. If
 * it is not sorted, the results are undefined. If the array contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found. This method considers all NaN values to be
 * equivalent and equal.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>. The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key. Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 */

public static int binarySearch(float[] a, float key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array of floats for the specified value using
 * the binary search algorithm.
 * The range must be sorted
 * (as by the {@link #sort(float[], int, int)} method)
 * prior to making this call. If
 * it is not sorted, the results are undefined. If the range contains
 * multiple elements with the specified value, there is no guarantee which
 * one will be found. This method considers all NaN values to be
 * equivalent and equal.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>. The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key. Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 */

public static int binarySearch(float[] a, int fromIndex, int toIndex, float key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array for the specified object using the binary
 * search algorithm. The array must be sorted into ascending order
 * according to the
 * {@linkplain Comparable natural ordering}
 * of its elements (as by the
 * {@link #sort(Object[])} method) prior to making this call.
 * If it is not sorted, the results are undefined.
 * (If the array contains elements that are not mutually comparable (for
 * example, strings and integers), it <i>cannot</i> be sorted according
 * to the natural ordering of its elements, hence results are undefined.)
 * If the array contains multiple
 * elements equal to the specified object, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws ClassCastException if the search key is not comparable to the
 *         elements of the array.
 */

public static int binarySearch(java.lang.Object[] a, java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array for the specified object using the binary
 * search algorithm.
 * The range must be sorted into ascending order
 * according to the
 * {@linkplain Comparable natural ordering}
 * of its elements (as by the
 * {@link #sort(Object[], int, int)} method) prior to making this
 * call.  If it is not sorted, the results are undefined.
 * (If the range contains elements that are not mutually comparable (for
 * example, strings and integers), it <i>cannot</i> be sorted according
 * to the natural ordering of its elements, hence results are undefined.)
 * If the range contains multiple
 * elements equal to the specified object, there is no guarantee which
 * one will be found.
 *
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws ClassCastException if the search key is not comparable to the
 *         elements of the array within the specified range.
 * @throws IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 */

public static int binarySearch(java.lang.Object[] a, int fromIndex, int toIndex, java.lang.Object key) { throw new RuntimeException("Stub!"); }

/**
 * Searches the specified array for the specified object using the binary
 * search algorithm.  The array must be sorted into ascending order
 * according to the specified comparator (as by the
 * {@link #sort(Object[], Comparator) sort(T[], Comparator)}
 * method) prior to making this call.  If it is
 * not sorted, the results are undefined.
 * If the array contains multiple
 * elements equal to the specified object, there is no guarantee which one
 * will be found.
 *
 * @param <T> the class of the objects in the array
 * @param a the array to be searched
 * @param key the value to be searched for
 * @param c the comparator by which the array is ordered.  A
 *        <tt>null</tt> value indicates that the elements'
 *        {@linkplain Comparable natural ordering} should be used.
 * @return index of the search key, if it is contained in the array;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element greater than the key, or <tt>a.length</tt> if all
 *         elements in the array are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws ClassCastException if the array contains elements that are not
 *         <i>mutually comparable</i> using the specified comparator,
 *         or the search key is not comparable to the
 *         elements of the array using this comparator.
 */

public static <T> int binarySearch(T[] a, T key, java.util.Comparator<? super T> c) { throw new RuntimeException("Stub!"); }

/**
 * Searches a range of
 * the specified array for the specified object using the binary
 * search algorithm.
 * The range must be sorted into ascending order
 * according to the specified comparator (as by the
 * {@link #sort(Object[], int, int, Comparator)
 * sort(T[], int, int, Comparator)}
 * method) prior to making this call.
 * If it is not sorted, the results are undefined.
 * If the range contains multiple elements equal to the specified object,
 * there is no guarantee which one will be found.
 *
 * @param <T> the class of the objects in the array
 * @param a the array to be searched
 * @param fromIndex the index of the first element (inclusive) to be
 *          searched
 * @param toIndex the index of the last element (exclusive) to be searched
 * @param key the value to be searched for
 * @param c the comparator by which the array is ordered.  A
 *        <tt>null</tt> value indicates that the elements'
 *        {@linkplain Comparable natural ordering} should be used.
 * @return index of the search key, if it is contained in the array
 *         within the specified range;
 *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
 *         <i>insertion point</i> is defined as the point at which the
 *         key would be inserted into the array: the index of the first
 *         element in the range greater than the key,
 *         or <tt>toIndex</tt> if all
 *         elements in the range are less than the specified key.  Note
 *         that this guarantees that the return value will be &gt;= 0 if
 *         and only if the key is found.
 * @throws ClassCastException if the range contains elements that are not
 *         <i>mutually comparable</i> using the specified comparator,
 *         or the search key is not comparable to the
 *         elements in the range using this comparator.
 * @throws IllegalArgumentException
 *         if {@code fromIndex > toIndex}
 * @throws ArrayIndexOutOfBoundsException
 *         if {@code fromIndex < 0 or toIndex > a.length}
 * @since 1.6
 */

public static <T> int binarySearch(T[] a, int fromIndex, int toIndex, T key, java.util.Comparator<? super T> c) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of longs are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 */

public static boolean equals(long[] a, long[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of ints are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 */

public static boolean equals(int[] a, int[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of shorts are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 */

public static boolean equals(short[] a, short[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of chars are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 */

public static boolean equals(char[] a, char[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of bytes are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 */

public static boolean equals(byte[] a, byte[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of booleans are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 */

public static boolean equals(boolean[] a, boolean[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of doubles are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * Two doubles <tt>d1</tt> and <tt>d2</tt> are considered equal if:
 * <pre>    <tt>new Double(d1).equals(new Double(d2))</tt></pre>
 * (Unlike the <tt>==</tt> operator, this method considers
 * <tt>NaN</tt> equals to itself, and 0.0d unequal to -0.0d.)
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @see Double#equals(Object)
 */

public static boolean equals(double[] a, double[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of floats are
 * <i>equal</i> to one another.  Two arrays are considered equal if both
 * arrays contain the same number of elements, and all corresponding pairs
 * of elements in the two arrays are equal.  In other words, two arrays
 * are equal if they contain the same elements in the same order.  Also,
 * two array references are considered equal if both are <tt>null</tt>.<p>
 *
 * Two floats <tt>f1</tt> and <tt>f2</tt> are considered equal if:
 * <pre>    <tt>new Float(f1).equals(new Float(f2))</tt></pre>
 * (Unlike the <tt>==</tt> operator, this method considers
 * <tt>NaN</tt> equals to itself, and 0.0f unequal to -0.0f.)
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @see Float#equals(Object)
 */

public static boolean equals(float[] a, float[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays of Objects are
 * <i>equal</i> to one another.  The two arrays are considered equal if
 * both arrays contain the same number of elements, and all corresponding
 * pairs of elements in the two arrays are equal.  Two objects <tt>e1</tt>
 * and <tt>e2</tt> are considered <i>equal</i> if <tt>(e1==null ? e2==null
 * : e1.equals(e2))</tt>.  In other words, the two arrays are equal if
 * they contain the same elements in the same order.  Also, two array
 * references are considered equal if both are <tt>null</tt>.<p>
 *
 * @param a one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 */

public static boolean equals(java.lang.Object[] a, java.lang.Object[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified long value to each element of the specified array
 * of longs.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 */

public static void fill(long[] a, long val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified long value to each element of the specified
 * range of the specified array of longs.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 */

public static void fill(long[] a, int fromIndex, int toIndex, long val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified int value to each element of the specified array
 * of ints.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 */

public static void fill(int[] a, int val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified int value to each element of the specified
 * range of the specified array of ints.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 */

public static void fill(int[] a, int fromIndex, int toIndex, int val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified short value to each element of the specified array
 * of shorts.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 */

public static void fill(short[] a, short val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified short value to each element of the specified
 * range of the specified array of shorts.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 */

public static void fill(short[] a, int fromIndex, int toIndex, short val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified char value to each element of the specified array
 * of chars.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 */

public static void fill(char[] a, char val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified char value to each element of the specified
 * range of the specified array of chars.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 */

public static void fill(char[] a, int fromIndex, int toIndex, char val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified byte value to each element of the specified array
 * of bytes.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 */

public static void fill(byte[] a, byte val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified byte value to each element of the specified
 * range of the specified array of bytes.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 */

public static void fill(byte[] a, int fromIndex, int toIndex, byte val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified boolean value to each element of the specified
 * array of booleans.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 */

public static void fill(boolean[] a, boolean val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified boolean value to each element of the specified
 * range of the specified array of booleans.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 */

public static void fill(boolean[] a, int fromIndex, int toIndex, boolean val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified double value to each element of the specified
 * array of doubles.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 */

public static void fill(double[] a, double val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified double value to each element of the specified
 * range of the specified array of doubles.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 */

public static void fill(double[] a, int fromIndex, int toIndex, double val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified float value to each element of the specified array
 * of floats.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 */

public static void fill(float[] a, float val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified float value to each element of the specified
 * range of the specified array of floats.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 */

public static void fill(float[] a, int fromIndex, int toIndex, float val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified Object reference to each element of the specified
 * array of Objects.
 *
 * @param a the array to be filled
 * @param val the value to be stored in all elements of the array
 * @throws ArrayStoreException if the specified value is not of a
 *         runtime type that can be stored in the specified array
 */

public static void fill(java.lang.Object[] a, java.lang.Object val) { throw new RuntimeException("Stub!"); }

/**
 * Assigns the specified Object reference to each element of the specified
 * range of the specified array of Objects.  The range to be filled
 * extends from index <tt>fromIndex</tt>, inclusive, to index
 * <tt>toIndex</tt>, exclusive.  (If <tt>fromIndex==toIndex</tt>, the
 * range to be filled is empty.)
 *
 * @param a the array to be filled
 * @param fromIndex the index of the first element (inclusive) to be
 *        filled with the specified value
 * @param toIndex the index of the last element (exclusive) to be
 *        filled with the specified value
 * @param val the value to be stored in all elements of the array
 * @throws IllegalArgumentException if <tt>fromIndex &gt; toIndex</tt>
 * @throws ArrayIndexOutOfBoundsException if <tt>fromIndex &lt; 0</tt> or
 *         <tt>toIndex &gt; a.length</tt>
 * @throws ArrayStoreException if the specified value is not of a
 *         runtime type that can be stored in the specified array
 */

public static void fill(java.lang.Object[] a, int fromIndex, int toIndex, java.lang.Object val) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with nulls (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>null</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 * The resulting array is of exactly the same class as the original array.
 *
 * @param <T> the class of the objects in the array
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with nulls
 *     to obtain the specified length
 * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static <T> T[] copyOf(T[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with nulls (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>null</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 * The resulting array is of the class <tt>newType</tt>.
 *
 * @param <U> the class of the objects in the original array
 * @param <T> the class of the objects in the returned array
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @param newType the class of the copy to be returned
 * @return a copy of the original array, truncated or padded with nulls
 *     to obtain the specified length
 * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws NullPointerException if <tt>original</tt> is null
 * @throws ArrayStoreException if an element copied from
 *     <tt>original</tt> is not of a runtime type that can be stored in
 *     an array of class <tt>newType</tt>
 * @since 1.6
 */

public static <T, U> T[] copyOf(U[] original, int newLength, java.lang.Class<? extends T[]> newType) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with zeros (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>(byte)0</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with zeros
 *     to obtain the specified length
 * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static byte[] copyOf(byte[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with zeros (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>(short)0</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with zeros
 *     to obtain the specified length
 * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static short[] copyOf(short[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with zeros (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>0</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with zeros
 *     to obtain the specified length
 * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static int[] copyOf(int[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with zeros (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>0L</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with zeros
 *     to obtain the specified length
 * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static long[] copyOf(long[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with null characters (if necessary)
 * so the copy has the specified length.  For all indices that are valid
 * in both the original array and the copy, the two arrays will contain
 * identical values.  For any indices that are valid in the copy but not
 * the original, the copy will contain <tt>'\\u000'</tt>.  Such indices
 * will exist if and only if the specified length is greater than that of
 * the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with null characters
 *     to obtain the specified length
 * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static char[] copyOf(char[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with zeros (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>0f</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with zeros
 *     to obtain the specified length
 * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static float[] copyOf(float[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with zeros (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>0d</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with zeros
 *     to obtain the specified length
 * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static double[] copyOf(double[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified array, truncating or padding with <tt>false</tt> (if necessary)
 * so the copy has the specified length.  For all indices that are
 * valid in both the original array and the copy, the two arrays will
 * contain identical values.  For any indices that are valid in the
 * copy but not the original, the copy will contain <tt>false</tt>.
 * Such indices will exist if and only if the specified length
 * is greater than that of the original array.
 *
 * @param original the array to be copied
 * @param newLength the length of the copy to be returned
 * @return a copy of the original array, truncated or padded with false elements
 *     to obtain the specified length
 * @throws NegativeArraySizeException if <tt>newLength</tt> is negative
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static boolean[] copyOf(boolean[] original, int newLength) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>null</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 * <p>
 * The resulting array is of exactly the same class as the original array.
 *
 * @param <T> the class of the objects in the array
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with nulls to obtain the required length
 * @throws ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static <T> T[] copyOfRange(T[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>null</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 * The resulting array is of the class <tt>newType</tt>.
 *
 * @param <U> the class of the objects in the original array
 * @param <T> the class of the objects in the returned array
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @param newType the class of the copy to be returned
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with nulls to obtain the required length
 * @throws ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws NullPointerException if <tt>original</tt> is null
 * @throws ArrayStoreException if an element copied from
 *     <tt>original</tt> is not of a runtime type that can be stored in
 *     an array of class <tt>newType</tt>.
 * @since 1.6
 */

public static <T, U> T[] copyOfRange(U[] original, int from, int to, java.lang.Class<? extends T[]> newType) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>(byte)0</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with zeros to obtain the required length
 * @throws ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static byte[] copyOfRange(byte[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>(short)0</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with zeros to obtain the required length
 * @throws ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static short[] copyOfRange(short[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>0</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with zeros to obtain the required length
 * @throws ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static int[] copyOfRange(int[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>0L</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with zeros to obtain the required length
 * @throws ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static long[] copyOfRange(long[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>'\\u000'</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with null characters to obtain the required length
 * @throws ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static char[] copyOfRange(char[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>0f</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with zeros to obtain the required length
 * @throws ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static float[] copyOfRange(float[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>0d</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with zeros to obtain the required length
 * @throws ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static double[] copyOfRange(double[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Copies the specified range of the specified array into a new array.
 * The initial index of the range (<tt>from</tt>) must lie between zero
 * and <tt>original.length</tt>, inclusive.  The value at
 * <tt>original[from]</tt> is placed into the initial element of the copy
 * (unless <tt>from == original.length</tt> or <tt>from == to</tt>).
 * Values from subsequent elements in the original array are placed into
 * subsequent elements in the copy.  The final index of the range
 * (<tt>to</tt>), which must be greater than or equal to <tt>from</tt>,
 * may be greater than <tt>original.length</tt>, in which case
 * <tt>false</tt> is placed in all elements of the copy whose index is
 * greater than or equal to <tt>original.length - from</tt>.  The length
 * of the returned array will be <tt>to - from</tt>.
 *
 * @param original the array from which a range is to be copied
 * @param from the initial index of the range to be copied, inclusive
 * @param to the final index of the range to be copied, exclusive.
 *     (This index may lie outside the array.)
 * @return a new array containing the specified range from the original array,
 *     truncated or padded with false elements to obtain the required length
 * @throws ArrayIndexOutOfBoundsException if {@code from < 0}
 *     or {@code from > original.length}
 * @throws IllegalArgumentException if <tt>from &gt; to</tt>
 * @throws NullPointerException if <tt>original</tt> is null
 * @since 1.6
 */

public static boolean[] copyOfRange(boolean[] original, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * Returns a fixed-size list backed by the specified array.  (Changes to
 * the returned list "write through" to the array.)  This method acts
 * as bridge between array-based and collection-based APIs, in
 * combination with {@link Collection#toArray}.  The returned list is
 * serializable and implements {@link RandomAccess}.
 *
 * <p>This method also provides a convenient way to create a fixed-size
 * list initialized to contain several elements:
 * <pre>
 *     List&lt;String&gt; stooges = Arrays.asList("Larry", "Moe", "Curly");
 * </pre>
 *
 * @param <T> the class of the objects in the array
 * @param a the array by which the list will be backed
 * @return a list view of the specified array
 */

@java.lang.SafeVarargs public static <T> java.util.List<T> asList(T... a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>long</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link List#hashCode() <tt>hashCode</tt>}
 * method on a {@link List} containing a sequence of {@link Long}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 */

public static int hashCode(long[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two non-null <tt>int</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link List#hashCode() <tt>hashCode</tt>}
 * method on a {@link List} containing a sequence of {@link Integer}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 */

public static int hashCode(int[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>short</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link List#hashCode() <tt>hashCode</tt>}
 * method on a {@link List} containing a sequence of {@link Short}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 */

public static int hashCode(short[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>char</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link List#hashCode() <tt>hashCode</tt>}
 * method on a {@link List} containing a sequence of {@link Character}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 */

public static int hashCode(char[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>byte</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link List#hashCode() <tt>hashCode</tt>}
 * method on a {@link List} containing a sequence of {@link Byte}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 */

public static int hashCode(byte[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>boolean</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link List#hashCode() <tt>hashCode</tt>}
 * method on a {@link List} containing a sequence of {@link Boolean}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 */

public static int hashCode(boolean[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>float</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link List#hashCode() <tt>hashCode</tt>}
 * method on a {@link List} containing a sequence of {@link Float}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 */

public static int hashCode(float[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.
 * For any two <tt>double</tt> arrays <tt>a</tt> and <tt>b</tt>
 * such that <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is the same value that would be
 * obtained by invoking the {@link List#hashCode() <tt>hashCode</tt>}
 * method on a {@link List} containing a sequence of {@link Double}
 * instances representing the elements of <tt>a</tt> in the same order.
 * If <tt>a</tt> is <tt>null</tt>, this method returns 0.
 *
 * @param a the array whose hash value to compute
 * @return a content-based hash code for <tt>a</tt>
 * @since 1.5
 */

public static int hashCode(double[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the contents of the specified array.  If
 * the array contains other arrays as elements, the hash code is based on
 * their identities rather than their contents.  It is therefore
 * acceptable to invoke this method on an array that contains itself as an
 * element,  either directly or indirectly through one or more levels of
 * arrays.
 *
 * <p>For any two arrays <tt>a</tt> and <tt>b</tt> such that
 * <tt>Arrays.equals(a, b)</tt>, it is also the case that
 * <tt>Arrays.hashCode(a) == Arrays.hashCode(b)</tt>.
 *
 * <p>The value returned by this method is equal to the value that would
 * be returned by <tt>Arrays.asList(a).hashCode()</tt>, unless <tt>a</tt>
 * is <tt>null</tt>, in which case <tt>0</tt> is returned.
 *
 * @param a the array whose content-based hash code to compute
 * @return a content-based hash code for <tt>a</tt>
 * @see #deepHashCode(Object[])
 * @since 1.5
 */

public static int hashCode(java.lang.Object[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the "deep contents" of the specified
 * array.  If the array contains other arrays as elements, the
 * hash code is based on their contents and so on, ad infinitum.
 * It is therefore unacceptable to invoke this method on an array that
 * contains itself as an element, either directly or indirectly through
 * one or more levels of arrays.  The behavior of such an invocation is
 * undefined.
 *
 * <p>For any two arrays <tt>a</tt> and <tt>b</tt> such that
 * <tt>Arrays.deepEquals(a, b)</tt>, it is also the case that
 * <tt>Arrays.deepHashCode(a) == Arrays.deepHashCode(b)</tt>.
 *
 * <p>The computation of the value returned by this method is similar to
 * that of the value returned by {@link List#hashCode()} on a list
 * containing the same elements as <tt>a</tt> in the same order, with one
 * difference: If an element <tt>e</tt> of <tt>a</tt> is itself an array,
 * its hash code is computed not by calling <tt>e.hashCode()</tt>, but as
 * by calling the appropriate overloading of <tt>Arrays.hashCode(e)</tt>
 * if <tt>e</tt> is an array of a primitive type, or as by calling
 * <tt>Arrays.deepHashCode(e)</tt> recursively if <tt>e</tt> is an array
 * of a reference type.  If <tt>a</tt> is <tt>null</tt>, this method
 * returns 0.
 *
 * @param a the array whose deep-content-based hash code to compute
 * @return a deep-content-based hash code for <tt>a</tt>
 * @see #hashCode(Object[])
 * @since 1.5
 */

public static int deepHashCode(java.lang.Object[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> if the two specified arrays are <i>deeply
 * equal</i> to one another.  Unlike the {@link #equals(Object[],Object[])}
 * method, this method is appropriate for use with nested arrays of
 * arbitrary depth.
 *
 * <p>Two array references are considered deeply equal if both
 * are <tt>null</tt>, or if they refer to arrays that contain the same
 * number of elements and all corresponding pairs of elements in the two
 * arrays are deeply equal.
 *
 * <p>Two possibly <tt>null</tt> elements <tt>e1</tt> and <tt>e2</tt> are
 * deeply equal if any of the following conditions hold:
 * <ul>
 *    <li> <tt>e1</tt> and <tt>e2</tt> are both arrays of object reference
 *         types, and <tt>Arrays.deepEquals(e1, e2) would return true</tt>
 *    <li> <tt>e1</tt> and <tt>e2</tt> are arrays of the same primitive
 *         type, and the appropriate overloading of
 *         <tt>Arrays.equals(e1, e2)</tt> would return true.
 *    <li> <tt>e1 == e2</tt>
 *    <li> <tt>e1.equals(e2)</tt> would return true.
 * </ul>
 * Note that this definition permits <tt>null</tt> elements at any depth.
 *
 * <p>If either of the specified arrays contain themselves as elements
 * either directly or indirectly through one or more levels of arrays,
 * the behavior of this method is undefined.
 *
 * @param a1 one array to be tested for equality
 * @param a2 the other array to be tested for equality
 * @return <tt>true</tt> if the two arrays are equal
 * @see #equals(Object[],Object[])
 * @see Objects#deepEquals(Object, Object)
 * @since 1.5
 */

public static boolean deepEquals(java.lang.Object[] a1, java.lang.Object[] a2) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(long)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
 * is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 */

public static java.lang.String toString(long[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(int)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt> is
 * <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 */

public static java.lang.String toString(int[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(short)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
 * is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 */

public static java.lang.String toString(short[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(char)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
 * is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 */

public static java.lang.String toString(char[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements
 * are separated by the characters <tt>", "</tt> (a comma followed
 * by a space).  Elements are converted to strings as by
 * <tt>String.valueOf(byte)</tt>.  Returns <tt>"null"</tt> if
 * <tt>a</tt> is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 */

public static java.lang.String toString(byte[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(boolean)</tt>.  Returns <tt>"null"</tt> if
 * <tt>a</tt> is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 */

public static java.lang.String toString(boolean[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(float)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
 * is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 */

public static java.lang.String toString(float[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * The string representation consists of a list of the array's elements,
 * enclosed in square brackets (<tt>"[]"</tt>).  Adjacent elements are
 * separated by the characters <tt>", "</tt> (a comma followed by a
 * space).  Elements are converted to strings as by
 * <tt>String.valueOf(double)</tt>.  Returns <tt>"null"</tt> if <tt>a</tt>
 * is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @since 1.5
 */

public static java.lang.String toString(double[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the contents of the specified array.
 * If the array contains other arrays as elements, they are converted to
 * strings by the {@link Object#toString} method inherited from
 * <tt>Object</tt>, which describes their <i>identities</i> rather than
 * their contents.
 *
 * <p>The value returned by this method is equal to the value that would
 * be returned by <tt>Arrays.asList(a).toString()</tt>, unless <tt>a</tt>
 * is <tt>null</tt>, in which case <tt>"null"</tt> is returned.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @see #deepToString(Object[])
 * @since 1.5
 */

public static java.lang.String toString(java.lang.Object[] a) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representation of the "deep contents" of the specified
 * array.  If the array contains other arrays as elements, the string
 * representation contains their contents and so on.  This method is
 * designed for converting multidimensional arrays to strings.
 *
 * <p>The string representation consists of a list of the array's
 * elements, enclosed in square brackets (<tt>"[]"</tt>).  Adjacent
 * elements are separated by the characters <tt>", "</tt> (a comma
 * followed by a space).  Elements are converted to strings as by
 * <tt>String.valueOf(Object)</tt>, unless they are themselves
 * arrays.
 *
 * <p>If an element <tt>e</tt> is an array of a primitive type, it is
 * converted to a string as by invoking the appropriate overloading of
 * <tt>Arrays.toString(e)</tt>.  If an element <tt>e</tt> is an array of a
 * reference type, it is converted to a string as by invoking
 * this method recursively.
 *
 * <p>To avoid infinite recursion, if the specified array contains itself
 * as an element, or contains an indirect reference to itself through one
 * or more levels of arrays, the self-reference is converted to the string
 * <tt>"[...]"</tt>.  For example, an array containing only a reference
 * to itself would be rendered as <tt>"[[...]]"</tt>.
 *
 * <p>This method returns <tt>"null"</tt> if the specified array
 * is <tt>null</tt>.
 *
 * @param a the array whose string representation to return
 * @return a string representation of <tt>a</tt>
 * @see #toString(Object[])
 * @since 1.5
 */

public static java.lang.String deepToString(java.lang.Object[] a) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, using the provided
 * generator function to compute each element.
 *
 * <p>If the generator function throws an exception, it is relayed to
 * the caller and the array is left in an indeterminate state.
 *
 * @param <T> type of elements of the array
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws NullPointerException if the generator is null
 * @since 1.8
 */

public static <T> void setAll(T[] array, java.util.function.IntFunction<? extends T> generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, in parallel, using the
 * provided generator function to compute each element.
 *
 * <p>If the generator function throws an exception, an unchecked exception
 * is thrown from {@code parallelSetAll} and the array is left in an
 * indeterminate state.
 *
 * @param <T> type of elements of the array
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws NullPointerException if the generator is null
 * @since 1.8
 */

public static <T> void parallelSetAll(T[] array, java.util.function.IntFunction<? extends T> generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, using the provided
 * generator function to compute each element.
 *
 * <p>If the generator function throws an exception, it is relayed to
 * the caller and the array is left in an indeterminate state.
 *
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws NullPointerException if the generator is null
 * @since 1.8
 */

public static void setAll(int[] array, java.util.function.IntUnaryOperator generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, in parallel, using the
 * provided generator function to compute each element.
 *
 * <p>If the generator function throws an exception, an unchecked exception
 * is thrown from {@code parallelSetAll} and the array is left in an
 * indeterminate state.
 *
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 * value for that position
 * @throws NullPointerException if the generator is null
 * @since 1.8
 */

public static void parallelSetAll(int[] array, java.util.function.IntUnaryOperator generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, using the provided
 * generator function to compute each element.
 *
 * <p>If the generator function throws an exception, it is relayed to
 * the caller and the array is left in an indeterminate state.
 *
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws NullPointerException if the generator is null
 * @since 1.8
 */

public static void setAll(long[] array, java.util.function.IntToLongFunction generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, in parallel, using the
 * provided generator function to compute each element.
 *
 * <p>If the generator function throws an exception, an unchecked exception
 * is thrown from {@code parallelSetAll} and the array is left in an
 * indeterminate state.
 *
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws NullPointerException if the generator is null
 * @since 1.8
 */

public static void parallelSetAll(long[] array, java.util.function.IntToLongFunction generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, using the provided
 * generator function to compute each element.
 *
 * <p>If the generator function throws an exception, it is relayed to
 * the caller and the array is left in an indeterminate state.
 *
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws NullPointerException if the generator is null
 * @since 1.8
 */

public static void setAll(double[] array, java.util.function.IntToDoubleFunction generator) { throw new RuntimeException("Stub!"); }

/**
 * Set all elements of the specified array, in parallel, using the
 * provided generator function to compute each element.
 *
 * <p>If the generator function throws an exception, an unchecked exception
 * is thrown from {@code parallelSetAll} and the array is left in an
 * indeterminate state.
 *
 * @param array array to be initialized
 * @param generator a function accepting an index and producing the desired
 *        value for that position
 * @throws NullPointerException if the generator is null
 * @since 1.8
 */

public static void parallelSetAll(double[] array, java.util.function.IntToDoubleFunction generator) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Spliterator} covering all of the specified array.
 *
 * <p>The spliterator reports {@link Spliterator#SIZED},
 * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
 * {@link Spliterator#IMMUTABLE}.
 *
 * @param <T> type of elements
 * @param array the array, assumed to be unmodified during use
 * @return a spliterator for the array elements
 * @since 1.8
 */

public static <T> java.util.Spliterator<T> spliterator(T[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Spliterator} covering the specified range of the
 * specified array.
 *
 * <p>The spliterator reports {@link Spliterator#SIZED},
 * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
 * {@link Spliterator#IMMUTABLE}.
 *
 * @param <T> type of elements
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a spliterator for the array elements
 * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 */

public static <T> java.util.Spliterator<T> spliterator(T[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Spliterator.OfInt} covering all of the specified array.
 *
 * <p>The spliterator reports {@link Spliterator#SIZED},
 * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
 * {@link Spliterator#IMMUTABLE}.
 *
 * @param array the array, assumed to be unmodified during use
 * @return a spliterator for the array elements
 * @since 1.8
 */

public static java.util.Spliterator.OfInt spliterator(int[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Spliterator.OfInt} covering the specified range of the
 * specified array.
 *
 * <p>The spliterator reports {@link Spliterator#SIZED},
 * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
 * {@link Spliterator#IMMUTABLE}.
 *
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a spliterator for the array elements
 * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 */

public static java.util.Spliterator.OfInt spliterator(int[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Spliterator.OfLong} covering all of the specified array.
 *
 * <p>The spliterator reports {@link Spliterator#SIZED},
 * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
 * {@link Spliterator#IMMUTABLE}.
 *
 * @param array the array, assumed to be unmodified during use
 * @return the spliterator for the array elements
 * @since 1.8
 */

public static java.util.Spliterator.OfLong spliterator(long[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Spliterator.OfLong} covering the specified range of the
 * specified array.
 *
 * <p>The spliterator reports {@link Spliterator#SIZED},
 * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
 * {@link Spliterator#IMMUTABLE}.
 *
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a spliterator for the array elements
 * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 */

public static java.util.Spliterator.OfLong spliterator(long[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Spliterator.OfDouble} covering all of the specified
 * array.
 *
 * <p>The spliterator reports {@link Spliterator#SIZED},
 * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
 * {@link Spliterator#IMMUTABLE}.
 *
 * @param array the array, assumed to be unmodified during use
 * @return a spliterator for the array elements
 * @since 1.8
 */

public static java.util.Spliterator.OfDouble spliterator(double[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Spliterator.OfDouble} covering the specified range of
 * the specified array.
 *
 * <p>The spliterator reports {@link Spliterator#SIZED},
 * {@link Spliterator#SUBSIZED}, {@link Spliterator#ORDERED}, and
 * {@link Spliterator#IMMUTABLE}.
 *
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a spliterator for the array elements
 * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 */

public static java.util.Spliterator.OfDouble spliterator(double[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link Stream} with the specified array as its
 * source.
 *
 * @param <T> The type of the array elements
 * @param array The array, assumed to be unmodified during use
 * @return a {@code Stream} for the array
 * @since 1.8
 */

public static <T> java.util.stream.Stream<T> stream(T[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link Stream} with the specified range of the
 * specified array as its source.
 *
 * @param <T> the type of the array elements
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a {@code Stream} for the array range
 * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 */

public static <T> java.util.stream.Stream<T> stream(T[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link IntStream} with the specified array as its
 * source.
 *
 * @param array the array, assumed to be unmodified during use
 * @return an {@code IntStream} for the array
 * @since 1.8
 */

public static java.util.stream.IntStream stream(int[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link IntStream} with the specified range of the
 * specified array as its source.
 *
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return an {@code IntStream} for the array range
 * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 */

public static java.util.stream.IntStream stream(int[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link LongStream} with the specified array as its
 * source.
 *
 * @param array the array, assumed to be unmodified during use
 * @return a {@code LongStream} for the array
 * @since 1.8
 */

public static java.util.stream.LongStream stream(long[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link LongStream} with the specified range of the
 * specified array as its source.
 *
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a {@code LongStream} for the array range
 * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 */

public static java.util.stream.LongStream stream(long[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link DoubleStream} with the specified array as its
 * source.
 *
 * @param array the array, assumed to be unmodified during use
 * @return a {@code DoubleStream} for the array
 * @since 1.8
 */

public static java.util.stream.DoubleStream stream(double[] array) { throw new RuntimeException("Stub!"); }

/**
 * Returns a sequential {@link DoubleStream} with the specified range of the
 * specified array as its source.
 *
 * @param array the array, assumed to be unmodified during use
 * @param startInclusive the first index to cover, inclusive
 * @param endExclusive index immediately past the last index to cover
 * @return a {@code DoubleStream} for the array range
 * @throws ArrayIndexOutOfBoundsException if {@code startInclusive} is
 *         negative, {@code endExclusive} is less than
 *         {@code startInclusive}, or {@code endExclusive} is greater than
 *         the array size
 * @since 1.8
 */

public static java.util.stream.DoubleStream stream(double[] array, int startInclusive, int endExclusive) { throw new RuntimeException("Stub!"); }
}

