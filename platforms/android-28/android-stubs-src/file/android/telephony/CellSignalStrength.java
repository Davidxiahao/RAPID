/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.telephony;


/**
 * Abstract base class for cell phone signal strength related information.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CellSignalStrength {

/** @hide */

CellSignalStrength() { throw new RuntimeException("Stub!"); }

/**
 * Get signal level as an int from 0..4
 * <p>
 * @see SIGNAL_STRENGTH_NONE_OR_UNKNOWN
 * @see SIGNAL_STRENGTH_POOR
 * @see SIGNAL_STRENGTH_MODERATE
 * @see SIGNAL_STRENGTH_GOOD
 * @see SIGNAL_STRENGTH_GREAT
 */

public abstract int getLevel();

/**
 * Get the signal level as an asu value between 0..31, 99 is unknown
 */

public abstract int getAsuLevel();

/**
 * Get the signal strength as dBm
 */

public abstract int getDbm();

public abstract int hashCode();

public abstract boolean equals(java.lang.Object o);

public static final int SIGNAL_STRENGTH_GOOD = 3; // 0x3

public static final int SIGNAL_STRENGTH_GREAT = 4; // 0x4

public static final int SIGNAL_STRENGTH_MODERATE = 2; // 0x2

public static final int SIGNAL_STRENGTH_NONE_OR_UNKNOWN = 0; // 0x0

public static final int SIGNAL_STRENGTH_POOR = 1; // 0x1
}

