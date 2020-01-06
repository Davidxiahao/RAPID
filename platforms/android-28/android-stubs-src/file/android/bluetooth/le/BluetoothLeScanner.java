/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.bluetooth.le;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import java.util.List;
import android.app.PendingIntent;
import android.os.WorkSource;

/**
 * This class provides methods to perform scan related operations for Bluetooth LE devices. An
 * application can scan for a particular type of Bluetooth LE devices using {@link ScanFilter}. It
 * can also request different types of callbacks for delivering the result.
 * <p>
 * Use {@link BluetoothAdapter#getBluetoothLeScanner()} to get an instance of
 * {@link BluetoothLeScanner}.
 * <p>
 * <b>Note:</b> Most of the scan methods here require
 * {@link android.Manifest.permission#BLUETOOTH_ADMIN} permission.
 *
 * @see ScanFilter
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BluetoothLeScanner {

BluetoothLeScanner() { throw new RuntimeException("Stub!"); }

/**
 * Start Bluetooth LE scan with default parameters and no filters. The scan results will be
 * delivered through {@code callback}. For unfiltered scans, scanning is stopped on screen
 * off to save power. Scanning is resumed when screen is turned on again. To avoid this, use
 * {@link #startScan(List, ScanSettings, ScanCallback)} with desired {@link ScanFilter}.
 * <p>
 * An app must hold
 * {@link android.Manifest.permission#ACCESS_COARSE_LOCATION ACCESS_COARSE_LOCATION} or
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION ACCESS_FINE_LOCATION} permission
 * in order to get results.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @param callback Callback used to deliver scan results.
 * @throws IllegalArgumentException If {@code callback} is null.
 */

public void startScan(android.bluetooth.le.ScanCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Start Bluetooth LE scan. The scan results will be delivered through {@code callback}.
 * For unfiltered scans, scanning is stopped on screen off to save power. Scanning is
 * resumed when screen is turned on again. To avoid this, do filetered scanning by
 * using proper {@link ScanFilter}.
 * <p>
 * An app must hold
 * {@link android.Manifest.permission#ACCESS_COARSE_LOCATION ACCESS_COARSE_LOCATION} or
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION ACCESS_FINE_LOCATION} permission
 * in order to get results.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @param filters {@link ScanFilter}s for finding exact BLE devices.
 * @param settings Settings for the scan.
 * @param callback Callback used to deliver scan results.
 * @throws IllegalArgumentException If {@code settings} or {@code callback} is null.
 */

public void startScan(java.util.List<android.bluetooth.le.ScanFilter> filters, android.bluetooth.le.ScanSettings settings, android.bluetooth.le.ScanCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Start Bluetooth LE scan using a {@link PendingIntent}. The scan results will be delivered via
 * the PendingIntent. Use this method of scanning if your process is not always running and it
 * should be started when scan results are available.
 * <p>
 * An app must hold
 * {@link android.Manifest.permission#ACCESS_COARSE_LOCATION ACCESS_COARSE_LOCATION} or
 * {@link android.Manifest.permission#ACCESS_FINE_LOCATION ACCESS_FINE_LOCATION} permission
 * in order to get results.
 * <p>
 * When the PendingIntent is delivered, the Intent passed to the receiver or activity
 * will contain one or more of the extras {@link #EXTRA_CALLBACK_TYPE},
 * {@link #EXTRA_ERROR_CODE} and {@link #EXTRA_LIST_SCAN_RESULT} to indicate the result of
 * the scan.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @param filters Optional list of ScanFilters for finding exact BLE devices.
 * This value may be {@code null}.
 * @param settings Optional settings for the scan.
 * This value may be {@code null}.
 * @param callbackIntent The PendingIntent to deliver the result to.
 * This value must never be {@code null}.
 * @return Returns 0 for success or an error code from {@link ScanCallback} if the scan request
 * could not be sent.
 * @see #stopScan(PendingIntent)
 */

public int startScan(@androidx.annotation.RecentlyNullable java.util.List<android.bluetooth.le.ScanFilter> filters, @androidx.annotation.RecentlyNullable android.bluetooth.le.ScanSettings settings, @androidx.annotation.RecentlyNonNull android.app.PendingIntent callbackIntent) { throw new RuntimeException("Stub!"); }

/**
 * Stops an ongoing Bluetooth LE scan.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @param callback
 */

public void stopScan(android.bluetooth.le.ScanCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Stops an ongoing Bluetooth LE scan started using a PendingIntent.
 *
 * Requires {@link android.Manifest.permission#BLUETOOTH_ADMIN}
 * @param callbackIntent The PendingIntent that was used to start the scan.
 * @see #startScan(List, ScanSettings, PendingIntent)
 */

public void stopScan(android.app.PendingIntent callbackIntent) { throw new RuntimeException("Stub!"); }

/**
 * Flush pending batch scan results stored in Bluetooth controller. This will return Bluetooth
 * LE scan results batched on bluetooth controller. Returns immediately, batch scan results data
 * will be delivered through the {@code callback}.
 *
 * @param callback Callback of the Bluetooth LE Scan, it has to be the same instance as the one
 * used to start scan.
 */

public void flushPendingScanResults(android.bluetooth.le.ScanCallback callback) { throw new RuntimeException("Stub!"); }

/**
 * Optional extra indicating the callback type, which will be one of
 * CALLBACK_TYPE_* constants in {@link ScanSettings}.
 *
 * @see ScanCallback#onScanResult(int, ScanResult)
 */

public static final java.lang.String EXTRA_CALLBACK_TYPE = "android.bluetooth.le.extra.CALLBACK_TYPE";

/**
 * Optional extra indicating the error code, if any. The error code will be one of the
 * SCAN_FAILED_* codes in {@link ScanCallback}.
 */

public static final java.lang.String EXTRA_ERROR_CODE = "android.bluetooth.le.extra.ERROR_CODE";

/**
 * Extra containing a list of ScanResults. It can have one or more results if there was no
 * error. In case of error, {@link #EXTRA_ERROR_CODE} will contain the error code and this
 * extra will not be available.
 */

public static final java.lang.String EXTRA_LIST_SCAN_RESULT = "android.bluetooth.le.extra.LIST_SCAN_RESULT";
}

