/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.util;

import java.io.Writer;

/**
 * API for sending log output.
 *
 * <p>Generally, you should use the {@link #v Log.v()}, {@link #d Log.d()},
 * {@link #i Log.i()}, {@link #w Log.w()}, and {@link #e Log.e()} methods to write logs.
 * You can then <a href="{@docRoot}studio/debug/am-logcat.html">view the logs in logcat</a>.
 *
 * <p>The order in terms of verbosity, from least to most is
 * ERROR, WARN, INFO, DEBUG, VERBOSE.  Verbose should never be compiled
 * into an application except during development.  Debug logs are compiled
 * in but stripped at runtime.  Error, warning and info logs are always kept.
 *
 * <p><b>Tip:</b> A good convention is to declare a <code>TAG</code> constant
 * in your class:
 *
 * <pre>private static final String TAG = "MyActivity";</pre>
 *
 * and use that in subsequent calls to the log methods.
 * </p>
 *
 * <p><b>Tip:</b> Don't forget that when you make a call like
 * <pre>Log.v(TAG, "index=" + i);</pre>
 * that when you're building the string to pass into Log.d, the compiler uses a
 * StringBuilder and at least three allocations occur: the StringBuilder
 * itself, the buffer, and the String object.  Realistically, there is also
 * another buffer allocation and copy, and even more pressure on the gc.
 * That means that if your log message is filtered out, you might be doing
 * significant work and incurring significant overhead.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Log {

Log() { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #VERBOSE} log message.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */

public static int v(java.lang.String tag, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #VERBOSE} log message and log the exception.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */

public static int v(java.lang.String tag, java.lang.String msg, java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #DEBUG} log message.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */

public static int d(java.lang.String tag, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #DEBUG} log message and log the exception.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */

public static int d(java.lang.String tag, java.lang.String msg, java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Send an {@link #INFO} log message.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */

public static int i(java.lang.String tag, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #INFO} log message and log the exception.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */

public static int i(java.lang.String tag, java.lang.String msg, java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #WARN} log message.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */

public static int w(java.lang.String tag, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #WARN} log message and log the exception.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */

public static int w(java.lang.String tag, java.lang.String msg, java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Checks to see whether or not a log for the specified tag is loggable at the specified level.
 *
 *  The default level of any tag is set to INFO. This means that any level above and including
 *  INFO will be logged. Before you make any calls to a logging method you should check to see
 *  if your tag should be logged. You can change the default level by setting a system property:
 *      'setprop log.tag.&lt;YOUR_LOG_TAG> &lt;LEVEL>'
 *  Where level is either VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT, or SUPPRESS. SUPPRESS will
 *  turn off all logging for your tag. You can also create a local.prop file that with the
 *  following in it:
 *      'log.tag.&lt;YOUR_LOG_TAG>=&lt;LEVEL>'
 *  and place that in /data/local.prop.
 *
 * @param tag The tag to check.
 * @param level The level to check.
 * @return Whether or not that this is allowed to be logged.
 * @throws IllegalArgumentException is thrown if the tag.length() > 23
 *         for Nougat (7.0) releases (API <= 23) and prior, there is no
 *         tag limit of concern after this API level.
 */

public static native boolean isLoggable(java.lang.String tag, int level);

public static int w(java.lang.String tag, java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Send an {@link #ERROR} log message.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 */

public static int e(java.lang.String tag, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Send a {@link #ERROR} log message and log the exception.
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @param tr An exception to log
 */

public static int e(java.lang.String tag, java.lang.String msg, java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * What a Terrible Failure: Report a condition that should never happen.
 * The error will always be logged at level ASSERT with the call stack.
 * Depending on system configuration, a report may be added to the
 * {@link android.os.DropBoxManager} and/or the process may be terminated
 * immediately with an error dialog.
 * @param tag Used to identify the source of a log message.
 * @param msg The message you would like logged.
 */

public static int wtf(java.lang.String tag, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * What a Terrible Failure: Report an exception that should never happen.
 * Similar to {@link #wtf(String, String)}, with an exception to log.
 * @param tag Used to identify the source of a log message.
 * @param tr An exception to log.
 */

public static int wtf(java.lang.String tag, java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * What a Terrible Failure: Report an exception that should never happen.
 * Similar to {@link #wtf(String, Throwable)}, with a message as well.
 * @param tag Used to identify the source of a log message.
 * @param msg The message you would like logged.
 * @param tr An exception to log.  May be null.
 */

public static int wtf(java.lang.String tag, java.lang.String msg, java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Handy function to get a loggable stack trace from a Throwable
 * @param tr An exception to log
 */

@androidx.annotation.RecentlyNonNull public static java.lang.String getStackTraceString(@androidx.annotation.RecentlyNullable java.lang.Throwable tr) { throw new RuntimeException("Stub!"); }

/**
 * Low-level logging call.
 * @param priority The priority/type of this log message
 * @param tag Used to identify the source of a log message.  It usually identifies
 *        the class or activity where the log call occurs.
 * @param msg The message you would like logged.
 * @return The number of bytes written.
 */

public static int println(int priority, java.lang.String tag, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Priority constant for the println method.
 */

public static final int ASSERT = 7; // 0x7

/**
 * Priority constant for the println method; use Log.d.
 */

public static final int DEBUG = 3; // 0x3

/**
 * Priority constant for the println method; use Log.e.
 */

public static final int ERROR = 6; // 0x6

/**
 * Priority constant for the println method; use Log.i.
 */

public static final int INFO = 4; // 0x4

/**
 * Priority constant for the println method; use Log.v.
 */

public static final int VERBOSE = 2; // 0x2

/**
 * Priority constant for the println method; use Log.w.
 */

public static final int WARN = 5; // 0x5
}

