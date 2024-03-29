/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.location;


/**
 * A class indicating the application criteria for selecting a
 * location provider.  Providers maybe ordered according to accuracy,
 * power usage, ability to report altitude, speed,
 * and bearing, and monetary cost.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Criteria implements android.os.Parcelable {

/**
 * Constructs a new Criteria object.  The new object will have no
 * requirements on accuracy, power, or response time; will not
 * require altitude, speed, or bearing; and will not allow monetary
 * cost.
 */

public Criteria() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new Criteria object that is a copy of the given criteria.
 */

public Criteria(android.location.Criteria criteria) { throw new RuntimeException("Stub!"); }

/**
 * Indicates the desired horizontal accuracy (latitude and longitude).
 * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_MEDIUM},
 * {@link #ACCURACY_HIGH} or {@link #NO_REQUIREMENT}.
 * More accurate location may consume more power and may take longer.
 *
 * @throws IllegalArgumentException if accuracy is not one of the supported constants
 */

public void setHorizontalAccuracy(int accuracy) { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the desired horizontal accuracy (latitude and longitude).
 * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_MEDIUM},
 * {@link #ACCURACY_HIGH} or {@link #NO_REQUIREMENT}.
 */

public int getHorizontalAccuracy() { throw new RuntimeException("Stub!"); }

/**
 * Indicates the desired vertical accuracy (altitude).
 * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_MEDIUM},
 * {@link #ACCURACY_HIGH} or {@link #NO_REQUIREMENT}.
 * More accurate location may consume more power and may take longer.
 *
 * @throws IllegalArgumentException if accuracy is not one of the supported constants
 */

public void setVerticalAccuracy(int accuracy) { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the desired vertical accuracy (altitude).
 * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_HIGH},
 * or {@link #NO_REQUIREMENT}.
 */

public int getVerticalAccuracy() { throw new RuntimeException("Stub!"); }

/**
 * Indicates the desired speed accuracy.
 * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_HIGH},
 * or {@link #NO_REQUIREMENT}.
 * More accurate location may consume more power and may take longer.
 *
 * @throws IllegalArgumentException if accuracy is not one of the supported constants
 */

public void setSpeedAccuracy(int accuracy) { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the desired speed accuracy
 * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_HIGH},
 * or {@link #NO_REQUIREMENT}.
 */

public int getSpeedAccuracy() { throw new RuntimeException("Stub!"); }

/**
 * Indicates the desired bearing accuracy.
 * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_HIGH},
 * or {@link #NO_REQUIREMENT}.
 * More accurate location may consume more power and may take longer.
 *
 * @throws IllegalArgumentException if accuracy is not one of the supported constants
 */

public void setBearingAccuracy(int accuracy) { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the desired bearing accuracy.
 * Accuracy may be {@link #ACCURACY_LOW}, {@link #ACCURACY_HIGH},
 * or {@link #NO_REQUIREMENT}.
 */

public int getBearingAccuracy() { throw new RuntimeException("Stub!"); }

/**
 * Indicates the desired accuracy for latitude and longitude. Accuracy
 * may be {@link #ACCURACY_FINE} if desired location
 * is fine, else it can be {@link #ACCURACY_COARSE}.
 * More accurate location may consume more power and may take longer.
 *
 * @throws IllegalArgumentException if accuracy is not one of the supported constants
 */

public void setAccuracy(int accuracy) { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating desired accuracy of location
 * Accuracy may be {@link #ACCURACY_FINE} if desired location
 * is fine, else it can be {@link #ACCURACY_COARSE}.
 */

public int getAccuracy() { throw new RuntimeException("Stub!"); }

/**
 * Indicates the desired maximum power level.  The level parameter
 * must be one of NO_REQUIREMENT, POWER_LOW, POWER_MEDIUM, or
 * POWER_HIGH.
 */

public void setPowerRequirement(int level) { throw new RuntimeException("Stub!"); }

/**
 * Returns a constant indicating the desired power requirement.  The
 * returned
 */

public int getPowerRequirement() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the provider is allowed to incur monetary cost.
 */

public void setCostAllowed(boolean costAllowed) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the provider is allowed to incur monetary cost.
 */

public boolean isCostAllowed() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the provider must provide altitude information.
 * Not all fixes are guaranteed to contain such information.
 */

public void setAltitudeRequired(boolean altitudeRequired) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the provider must provide altitude information.
 * Not all fixes are guaranteed to contain such information.
 */

public boolean isAltitudeRequired() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the provider must provide speed information.
 * Not all fixes are guaranteed to contain such information.
 */

public void setSpeedRequired(boolean speedRequired) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the provider must provide speed information.
 * Not all fixes are guaranteed to contain such information.
 */

public boolean isSpeedRequired() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether the provider must provide bearing information.
 * Not all fixes are guaranteed to contain such information.
 */

public void setBearingRequired(boolean bearingRequired) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the provider must provide bearing information.
 * Not all fixes are guaranteed to contain such information.
 */

public boolean isBearingRequired() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * A constant indicating an approximate accuracy requirement
 */

public static final int ACCURACY_COARSE = 2; // 0x2

/**
 * A constant indicating a finer location accuracy requirement
 */

public static final int ACCURACY_FINE = 1; // 0x1

/**
 * a constant indicating a high accuracy requirement
 * - may be used for horizontal, altitude, speed or bearing accuracy.
 * For horizontal and vertical position this corresponds roughly to
 * an accuracy of less than 100 meters.
 */

public static final int ACCURACY_HIGH = 3; // 0x3

/**
 * A constant indicating a low location accuracy requirement
 * - may be used for horizontal, altitude, speed or bearing accuracy.
 * For horizontal and vertical position this corresponds roughly to
 * an accuracy of greater than 500 meters.
 */

public static final int ACCURACY_LOW = 1; // 0x1

/**
 * A constant indicating a medium accuracy requirement
 * - currently used only for horizontal accuracy.
 * For horizontal position this corresponds roughly to to an accuracy
 * of between 100 and 500 meters.
 */

public static final int ACCURACY_MEDIUM = 2; // 0x2

public static final android.os.Parcelable.Creator<android.location.Criteria> CREATOR;
static { CREATOR = null; }

/**
 * A constant indicating that the application does not choose to
 * place requirement on a particular feature.
 */

public static final int NO_REQUIREMENT = 0; // 0x0

/**
 * A constant indicating a high power requirement.
 */

public static final int POWER_HIGH = 3; // 0x3

/**
 * A constant indicating a low power requirement.
 */

public static final int POWER_LOW = 1; // 0x1

/**
 * A constant indicating a medium power requirement.
 */

public static final int POWER_MEDIUM = 2; // 0x2
}

