/*
 * Copyright (C) 2016 The Android Open Source Project
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
 * Used for receiving NMEA sentences from the GNSS.
 * NMEA 0183 is a standard for communicating with marine electronic devices
 * and is a common method for receiving data from a GNSS, typically over a serial port.
 * See <a href="http://en.wikipedia.org/wiki/NMEA_0183">NMEA 0183</a> for more details.
 * You can implement this interface and call {@link LocationManager#addNmeaListener}
 * to receive NMEA data from the GNSS engine.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface OnNmeaMessageListener {

/**
 * Called when an NMEA message is received.
 * @param message NMEA message
 * @param timestamp milliseconds since January 1, 1970.
 */

public void onNmeaMessage(java.lang.String message, long timestamp);
}

