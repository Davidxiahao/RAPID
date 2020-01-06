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


package android.os;

import android.util.Printer;

/**
 * Class used to run a message loop for a thread.  Threads by default do
 * not have a message loop associated with them; to create one, call
 * {@link #prepare} in the thread that is to run the loop, and then
 * {@link #loop} to have it process messages until the loop is stopped.
 *
 * <p>Most interaction with a message loop is through the
 * {@link Handler} class.
 *
 * <p>This is a typical example of the implementation of a Looper thread,
 * using the separation of {@link #prepare} and {@link #loop} to create an
 * initial Handler to communicate with the Looper.
 *
 * <pre>
 *  class LooperThread extends Thread {
 *      public Handler mHandler;
 *
 *      public void run() {
 *          Looper.prepare();
 *
 *          mHandler = new Handler() {
 *              public void handleMessage(Message msg) {
 *                  // process incoming messages here
 *              }
 *          };
 *
 *          Looper.loop();
 *      }
 *  }</pre>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Looper {

Looper(boolean quitAllowed) { throw new RuntimeException("Stub!"); }

/** Initialize the current thread as a looper.
 * This gives you a chance to create handlers that then reference
 * this looper, before actually starting the loop. Be sure to call
 * {@link #loop()} after calling this method, and end it by calling
 * {@link #quit()}.
 */

public static void prepare() { throw new RuntimeException("Stub!"); }

/**
 * Initialize the current thread as a looper, marking it as an
 * application's main looper. The main looper for your application
 * is created by the Android environment, so you should never need
 * to call this function yourself.  See also: {@link #prepare()}
 */

public static void prepareMainLooper() { throw new RuntimeException("Stub!"); }

/**
 * Returns the application's main looper, which lives in the main thread of the application.
 */

public static android.os.Looper getMainLooper() { throw new RuntimeException("Stub!"); }

/**
 * Run the message queue in this thread. Be sure to call
 * {@link #quit()} to end the loop.
 */

public static void loop() { throw new RuntimeException("Stub!"); }

/**
 * Return the Looper object associated with the current thread.  Returns
 * null if the calling thread is not associated with a Looper.
 */

@androidx.annotation.RecentlyNullable public static android.os.Looper myLooper() { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link MessageQueue} object associated with the current
 * thread.  This must be called from a thread running a Looper, or a
 * NullPointerException will be thrown.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public static android.os.MessageQueue myQueue() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the current thread is this looper's thread.
 */

public boolean isCurrentThread() { throw new RuntimeException("Stub!"); }

/**
 * Control logging of messages as they are processed by this Looper.  If
 * enabled, a log message will be written to <var>printer</var>
 * at the beginning and ending of each message dispatch, identifying the
 * target Handler and message contents.
 *
 * @param printer A Printer object that will receive log messages, or
 * null to disable message logging.

 * This value may be {@code null}.
 */

public void setMessageLogging(@androidx.annotation.RecentlyNullable android.util.Printer printer) { throw new RuntimeException("Stub!"); }

/**
 * Quits the looper.
 * <p>
 * Causes the {@link #loop} method to terminate without processing any
 * more messages in the message queue.
 * </p><p>
 * Any attempt to post messages to the queue after the looper is asked to quit will fail.
 * For example, the {@link Handler#sendMessage(Message)} method will return false.
 * </p><p class="note">
 * Using this method may be unsafe because some messages may not be delivered
 * before the looper terminates.  Consider using {@link #quitSafely} instead to ensure
 * that all pending work is completed in an orderly manner.
 * </p>
 *
 * @see #quitSafely
 */

public void quit() { throw new RuntimeException("Stub!"); }

/**
 * Quits the looper safely.
 * <p>
 * Causes the {@link #loop} method to terminate as soon as all remaining messages
 * in the message queue that are already due to be delivered have been handled.
 * However pending delayed messages with due times in the future will not be
 * delivered before the loop terminates.
 * </p><p>
 * Any attempt to post messages to the queue after the looper is asked to quit will fail.
 * For example, the {@link Handler#sendMessage(Message)} method will return false.
 * </p>
 */

public void quitSafely() { throw new RuntimeException("Stub!"); }

/**
 * Gets the Thread associated with this Looper.
 *
 * @return The looper's thread.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.Thread getThread() { throw new RuntimeException("Stub!"); }

/**
 * Gets this looper's message queue.
 *
 * @return The looper's message queue.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.os.MessageQueue getQueue() { throw new RuntimeException("Stub!"); }

/**
 * Dumps the state of the looper for debugging purposes.
 *
 * @param pw A printer to receive the contents of the dump.
 * This value must never be {@code null}.
 * @param prefix A prefix to prepend to each line which is printed.

 * This value must never be {@code null}.
 */

public void dump(@androidx.annotation.RecentlyNonNull android.util.Printer pw, @androidx.annotation.RecentlyNonNull java.lang.String prefix) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

