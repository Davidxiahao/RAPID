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


package android.hardware;


/**
 * Used for receiving notifications from the SensorManager when
 * there is new sensor data.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface SensorEventListener {

/**
 * Called when there is a new sensor event.  Note that "on changed"
 * is somewhat of a misnomer, as this will also be called if we have a
 * new reading from a sensor with the exact same sensor values (but a
 * newer timestamp).
 *
 * <p>See {@link android.hardware.SensorManager SensorManager}
 * for details on possible sensor types.
 * <p>See also {@link android.hardware.SensorEvent SensorEvent}.
 *
 * <p><b>NOTE:</b> The application doesn't own the
 * {@link android.hardware.SensorEvent event}
 * object passed as a parameter and therefore cannot hold on to it.
 * The object may be part of an internal pool and may be reused by
 * the framework.
 *
 * @param event the {@link android.hardware.SensorEvent SensorEvent}.
 */

public void onSensorChanged(android.hardware.SensorEvent event);

/**
 * Called when the accuracy of the registered sensor has changed.  Unlike
 * onSensorChanged(), this is only called when this accuracy value changes.
 *
 * <p>See the SENSOR_STATUS_* constants in
 * {@link android.hardware.SensorManager SensorManager} for details.
 *
 * @param accuracy The new accuracy of this sensor, one of
 *         {@code SensorManager.SENSOR_STATUS_*}
 */

public void onAccuracyChanged(android.hardware.Sensor sensor, int accuracy);
}

