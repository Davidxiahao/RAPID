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


package android.app;

import android.content.pm.PackageManager;
import android.util.Printer;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Describes an application error.
 *
 * A report has a type, which is one of
 * <ul>
 * <li> {@link #TYPE_NONE} uninitialized instance of {@link ApplicationErrorReport}.
 * <li> {@link #TYPE_CRASH} application crash. Information about the crash
 * is stored in {@link #crashInfo}.
 * <li> {@link #TYPE_ANR} application not responding. Information about the
 * ANR is stored in {@link #anrInfo}.
 * <li> {@link #TYPE_BATTERY} user reported application is using too much
 * battery. Information about the battery use is stored in {@link #batteryInfo}.
 * <li> {@link #TYPE_RUNNING_SERVICE} user reported application is leaving an
 * unneeded serive running. Information about the battery use is stored in
 * {@link #runningServiceInfo}.
 * </ul>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ApplicationErrorReport implements android.os.Parcelable {

/**
 * Create an uninitialized instance of {@link ApplicationErrorReport}.
 */

public ApplicationErrorReport() { throw new RuntimeException("Stub!"); }

public static android.content.ComponentName getErrorReportReceiver(android.content.Context context, java.lang.String packageName, int appFlags) { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public void readFromParcel(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Dump the report to a Printer.
 */

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.ApplicationErrorReport> CREATOR;
static { CREATOR = null; }

/**
 * An error report about an application that's not responding.
 */

public static final int TYPE_ANR = 2; // 0x2

/**
 * An error report about an application that's consuming too much battery.
 */

public static final int TYPE_BATTERY = 3; // 0x3

/**
 * An error report about an application crash.
 */

public static final int TYPE_CRASH = 1; // 0x1

/**
 * Uninitialized error report.
 */

public static final int TYPE_NONE = 0; // 0x0

/**
 * A report from a user to a developer about a running service that the
 * user doesn't think should be running.
 */

public static final int TYPE_RUNNING_SERVICE = 5; // 0x5

/**
 * If this report is of type {@link #TYPE_ANR}, contains an instance
 * of AnrInfo describing the ANR; otherwise null.
 */

public android.app.ApplicationErrorReport.AnrInfo anrInfo;

/**
 * If this report is of type {@link #TYPE_BATTERY}, contains an instance
 * of BatteryInfo; otherwise null.
 */

public android.app.ApplicationErrorReport.BatteryInfo batteryInfo;

/**
 * If this report is of type {@link #TYPE_CRASH}, contains an instance
 * of CrashInfo describing the crash; otherwise null.
 */

public android.app.ApplicationErrorReport.CrashInfo crashInfo;

/**
 * Package name of the application which installed the application this
 * report pertains to.
 * This identifies which market the application came from.
 */

public java.lang.String installerPackageName;

/**
 * Package name of the application.
 */

public java.lang.String packageName;

/**
 * Process name of the application.
 */

public java.lang.String processName;

/**
 * If this report is of type {@link #TYPE_RUNNING_SERVICE}, contains an instance
 * of RunningServiceInfo; otherwise null.
 */

public android.app.ApplicationErrorReport.RunningServiceInfo runningServiceInfo;

/**
 * Set if the app is on the system image.
 */

public boolean systemApp;

/**
 * Time at which the error occurred.
 */

public long time;

/**
 * Type of this report. Can be one of {@link #TYPE_NONE},
 * {@link #TYPE_CRASH}, {@link #TYPE_ANR}, {@link #TYPE_BATTERY},
 * or {@link #TYPE_RUNNING_SERVICE}.
 */

public int type;
/**
 * Describes an application not responding error.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class AnrInfo {

/**
 * Create an uninitialized instance of AnrInfo.
 */

public AnrInfo() { throw new RuntimeException("Stub!"); }

/**
 * Create an instance of AnrInfo initialized from a Parcel.
 */

public AnrInfo(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Save an AnrInfo instance to a parcel.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Dump an AnrInfo instance to a Printer.
 */

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/**
 * Activity name.
 */

public java.lang.String activity;

/**
 * Description of the operation that timed out.
 */

public java.lang.String cause;

/**
 * Additional info, including CPU stats.
 */

public java.lang.String info;
}

/**
 * Describes a battery usage report.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class BatteryInfo {

/**
 * Create an uninitialized instance of BatteryInfo.
 */

public BatteryInfo() { throw new RuntimeException("Stub!"); }

/**
 * Create an instance of BatteryInfo initialized from a Parcel.
 */

public BatteryInfo(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Save a BatteryInfo instance to a parcel.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Dump a BatteryInfo instance to a Printer.
 */

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/**
 * Checkin details.
 */

public java.lang.String checkinDetails;

/**
 * Duration in microseconds over which the process used the above
 * percentage of battery.
 */

public long durationMicros;

/**
 * Dump of various info impacting battery use.
 */

public java.lang.String usageDetails;

/**
 * Percentage of the battery that was used up by the process.
 */

public int usagePercent;
}

/**
 * Describes an application crash.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class CrashInfo {

/**
 * Create an uninitialized instance of CrashInfo.
 */

public CrashInfo() { throw new RuntimeException("Stub!"); }

/**
 * Create an instance of CrashInfo initialized from an exception.
 */

public CrashInfo(java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Create an instance of CrashInfo initialized from a Parcel.
 */

public CrashInfo(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Save a CrashInfo instance to a parcel.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Dump a CrashInfo instance to a Printer.
 */

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/**
 * Class name of the exception that caused the crash.
 */

public java.lang.String exceptionClassName;

/**
 * Message stored in the exception.
 */

public java.lang.String exceptionMessage;

/**
 * Stack trace.
 */

public java.lang.String stackTrace;

/**
 * Class which the exception was thrown from.
 */

public java.lang.String throwClassName;

/**
 * File which the exception was thrown from.
 */

public java.lang.String throwFileName;

/**
 * Line number the exception was thrown from.
 */

public int throwLineNumber;

/**
 * Method which the exception was thrown from.
 */

public java.lang.String throwMethodName;
}

/**
 * Describes a running service report.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class RunningServiceInfo {

/**
 * Create an uninitialized instance of RunningServiceInfo.
 */

public RunningServiceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Create an instance of RunningServiceInfo initialized from a Parcel.
 */

public RunningServiceInfo(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Save a RunningServiceInfo instance to a parcel.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Dump a BatteryInfo instance to a Printer.
 */

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

/**
 * Duration in milliseconds that the service has been running.
 */

public long durationMillis;

/**
 * Dump of debug information about the service.
 */

public java.lang.String serviceDetails;
}

}

