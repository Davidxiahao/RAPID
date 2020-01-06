/*
 * Copyright (C) 2008 The Android Open Source Project
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
 * This class represents the current state of the GPS engine.
 *
 * <p>This class is used in conjunction with the {@link Listener} interface.
 *
 * @deprecated use {@link GnssStatus} and {@link GnssStatus.Callback}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public final class GpsStatus {

GpsStatus() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time required to receive the first fix since the most recent
 * restart of the GPS engine.
 *
 * @return time to first fix in milliseconds
 */

public int getTimeToFirstFix() { throw new RuntimeException("Stub!"); }

/**
 * Returns an array of {@link GpsSatellite} objects, which represent the
 * current state of the GPS engine.
 *
 * @return the list of satellites
 */

public java.lang.Iterable<android.location.GpsSatellite> getSatellites() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum number of satellites that can be in the satellite
 * list that can be returned by {@link #getSatellites()}.
 *
 * @return the maximum number of satellites
 */

public int getMaxSatellites() { throw new RuntimeException("Stub!"); }

/**
 * Event sent when the GPS system has received its first fix since starting.
 * Call {@link #getTimeToFirstFix()} to find the time from start to first fix.
 */

public static final int GPS_EVENT_FIRST_FIX = 3; // 0x3

/**
 * Event sent periodically to report GPS satellite status.
 * Call {@link #getSatellites()} to retrieve the status for each satellite.
 */

public static final int GPS_EVENT_SATELLITE_STATUS = 4; // 0x4

/**
 * Event sent when the GPS system has started.
 */

public static final int GPS_EVENT_STARTED = 1; // 0x1

/**
 * Event sent when the GPS system has stopped.
 */

public static final int GPS_EVENT_STOPPED = 2; // 0x2
/**
 * Used for receiving notifications when GPS status has changed.
 * @deprecated use {@link GnssStatus.Callback} instead.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public static interface Listener {

/**
 * Called to report changes in the GPS status.
 * The event number is one of:
 * <ul>
 * <li> {@link GpsStatus#GPS_EVENT_STARTED}
 * <li> {@link GpsStatus#GPS_EVENT_STOPPED}
 * <li> {@link GpsStatus#GPS_EVENT_FIRST_FIX}
 * <li> {@link GpsStatus#GPS_EVENT_SATELLITE_STATUS}
 * </ul>
 *
 * When this method is called, the client should call
 * {@link LocationManager#getGpsStatus} to get additional
 * status information.
 *
 * @param event event number for this notification
 */

public void onGpsStatusChanged(int event);
}

/**
 * Used for receiving NMEA sentences from the GPS.
 * NMEA 0183 is a standard for communicating with marine electronic devices
 * and is a common method for receiving data from a GPS, typically over a serial port.
 * See <a href="http://en.wikipedia.org/wiki/NMEA_0183">NMEA 0183</a> for more details.
 * You can implement this interface and call {@link LocationManager#addNmeaListener}
 * to receive NMEA data from the GPS engine.
 * @deprecated use {@link OnNmeaMessageListener} instead.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public static interface NmeaListener {

public void onNmeaReceived(long timestamp, java.lang.String nmea);
}

}

