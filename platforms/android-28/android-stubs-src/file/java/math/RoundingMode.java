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


/**
 * Specifies the rounding behavior for operations whose results cannot be
 * represented exactly.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum RoundingMode {
UP, DOWN, CEILING, FLOOR, HALF_UP, HALF_DOWN, HALF_EVEN, UNNECESSARY;

/**
 * Converts rounding mode constants from class {@code BigDecimal} into
 * {@code RoundingMode} values.
 *
 * @param mode
 *            rounding mode constant as defined in class {@code BigDecimal}
 * @return corresponding rounding mode object
 */

public static java.math.RoundingMode valueOf(int mode) { throw new RuntimeException("Stub!"); }
}

