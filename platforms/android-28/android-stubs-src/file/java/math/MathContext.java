/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


package java.math;

import java.io.StreamCorruptedException;

/**
 * Immutable objects describing settings such as rounding mode and digit
 * precision for the numerical operations provided by class {@link BigDecimal}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MathContext implements java.io.Serializable {

/**
 * Constructs a new {@code MathContext} with the specified precision and
 * with the rounding mode {@link RoundingMode#HALF_UP HALF_UP}. If the
 * precision passed is zero, then this implies that the computations have to
 * be performed exact, the rounding mode in this case is irrelevant.
 *
 * @param precision
 *            the precision for the new {@code MathContext}.
 * @throws IllegalArgumentException
 *             if {@code precision < 0}.
 */

public MathContext(int precision) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code MathContext} with the specified precision and
 * with the specified rounding mode. If the precision passed is zero, then
 * this implies that the computations have to be performed exact, the
 * rounding mode in this case is irrelevant.
 *
 * @param precision
 *            the precision for the new {@code MathContext}.
 * @param roundingMode
 *            the rounding mode for the new {@code MathContext}.
 * @throws IllegalArgumentException
 *             if {@code precision < 0}.
 * @throws NullPointerException
 *             if {@code roundingMode} is {@code null}.
 */

public MathContext(int precision, java.math.RoundingMode roundingMode) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code MathContext} from a string. The string has to
 * specify the precision and the rounding mode to be used and has to follow
 * the following syntax: "precision=&lt;precision&gt; roundingMode=&lt;roundingMode&gt;"
 * This is the same form as the one returned by the {@link #toString}
 * method.
 *
 * @throws IllegalArgumentException
 *             if the string is not in the correct format or if the
 *             precision specified is < 0.
 */

public MathContext(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Returns the precision. The precision is the number of digits used for an
 * operation. Results are rounded to this precision. The precision is
 * guaranteed to be non negative. If the precision is zero, then the
 * computations have to be performed exact, results are not rounded in this
 * case.
 *
 * @return the precision.
 */

public int getPrecision() { throw new RuntimeException("Stub!"); }

/**
 * Returns the rounding mode. The rounding mode is the strategy to be used
 * to round results.
 * <p>
 * The rounding mode is one of
 * {@link RoundingMode#UP},
 * {@link RoundingMode#DOWN},
 * {@link RoundingMode#CEILING},
 * {@link RoundingMode#FLOOR},
 * {@link RoundingMode#HALF_UP},
 * {@link RoundingMode#HALF_DOWN},
 * {@link RoundingMode#HALF_EVEN}, or
 * {@link RoundingMode#UNNECESSARY}.
 *
 * @return the rounding mode.
 */

public java.math.RoundingMode getRoundingMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if x is a {@code MathContext} with the same precision
 * setting and the same rounding mode as this {@code MathContext} instance.
 *
 * @param x
 *            object to be compared.
 * @return {@code true} if this {@code MathContext} instance is equal to the
 *         {@code x} argument; {@code false} otherwise.
 */

public boolean equals(java.lang.Object x) { throw new RuntimeException("Stub!"); }

/**
 * Returns the hash code for this {@code MathContext} instance.
 *
 * @return the hash code for this {@code MathContext}.
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the string representation for this {@code MathContext} instance.
 * The string has the form
 * {@code
 * "precision=<precision> roundingMode=<roundingMode>"
 * } where {@code <precision>} is an integer describing the number
 * of digits used for operations and {@code <roundingMode>} is the
 * string representation of the rounding mode.
 *
 * @return a string representation for this {@code MathContext} instance
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * A {@code MathContext} which corresponds to the <a href="http://en.wikipedia.org/wiki/IEEE_754-1985">IEEE 754</a> quadruple
 * decimal precision format: 34 digit precision and
 * {@link RoundingMode#HALF_EVEN} rounding.
 */

public static final java.math.MathContext DECIMAL128;
static { DECIMAL128 = null; }

/**
 * A {@code MathContext} which corresponds to the <a href="http://en.wikipedia.org/wiki/IEEE_754-1985">IEEE 754</a> single decimal
 * precision format: 7 digit precision and {@link RoundingMode#HALF_EVEN}
 * rounding.
 */

public static final java.math.MathContext DECIMAL32;
static { DECIMAL32 = null; }

/**
 * A {@code MathContext} which corresponds to the <a href="http://en.wikipedia.org/wiki/IEEE_754-1985">IEEE 754</a> double decimal
 * precision format: 16 digit precision and {@link RoundingMode#HALF_EVEN}
 * rounding.
 */

public static final java.math.MathContext DECIMAL64;
static { DECIMAL64 = null; }

/**
 * A {@code MathContext} for unlimited precision with
 * {@link RoundingMode#HALF_UP} rounding.
 */

public static final java.math.MathContext UNLIMITED;
static { UNLIMITED = null; }
}

