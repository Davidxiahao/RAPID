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


/**
 * A Handler allows you to send and process {@link Message} and Runnable
 * objects associated with a thread's {@link MessageQueue}.  Each Handler
 * instance is associated with a single thread and that thread's message
 * queue.  When you create a new Handler, it is bound to the thread /
 * message queue of the thread that is creating it -- from that point on,
 * it will deliver messages and runnables to that message queue and execute
 * them as they come out of the message queue.
 *
 * <p>There are two main uses for a Handler: (1) to schedule messages and
 * runnables to be executed as some point in the future; and (2) to enqueue
 * an action to be performed on a different thread than your own.
 *
 * <p>Scheduling messages is accomplished with the
 * {@link #post}, {@link #postAtTime(Runnable, long)},
 * {@link #postDelayed}, {@link #sendEmptyMessage},
 * {@link #sendMessage}, {@link #sendMessageAtTime}, and
 * {@link #sendMessageDelayed} methods.  The <em>post</em> versions allow
 * you to enqueue Runnable objects to be called by the message queue when
 * they are received; the <em>sendMessage</em> versions allow you to enqueue
 * a {@link Message} object containing a bundle of data that will be
 * processed by the Handler's {@link #handleMessage} method (requiring that
 * you implement a subclass of Handler).
 *
 * <p>When posting or sending to a Handler, you can either
 * allow the item to be processed as soon as the message queue is ready
 * to do so, or specify a delay before it gets processed or absolute time for
 * it to be processed.  The latter two allow you to implement timeouts,
 * ticks, and other timing-based behavior.
 *
 * <p>When a
 * process is created for your application, its main thread is dedicated to
 * running a message queue that takes care of managing the top-level
 * application objects (activities, broadcast receivers, etc) and any windows
 * they create.  You can create your own threads, and communicate back with
 * the main application thread through a Handler.  This is done by calling
 * the same <em>post</em> or <em>sendMessage</em> methods as before, but from
 * your new thread.  The given Runnable or Message will then be scheduled
 * in the Handler's message queue and processed when appropriate.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Handler {

/**
 * Default constructor associates this handler with the {@link Looper} for the
 * current thread.
 *
 * If this thread does not have a looper, this handler won't be able to receive messages
 * so an exception is thrown.
 */

public Handler() { throw new RuntimeException("Stub!"); }

/**
 * Constructor associates this handler with the {@link Looper} for the
 * current thread and takes a callback interface in which you can handle
 * messages.
 *
 * If this thread does not have a looper, this handler won't be able to receive messages
 * so an exception is thrown.
 *
 * @param callback The callback interface in which to handle messages, or null.
 */

public Handler(android.os.Handler.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Use the provided {@link Looper} instead of the default one.
 *
 * @param looper The looper, must not be null.
 */

public Handler(android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/**
 * Use the provided {@link Looper} instead of the default one and take a callback
 * interface in which to handle messages.
 *
 * @param looper The looper, must not be null.
 * @param callback The callback interface in which to handle messages, or null.
 */

public Handler(android.os.Looper looper, android.os.Handler.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Subclasses must implement this to receive messages.
 */

public void handleMessage(android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Handle system messages here.
 */

public void dispatchMessage(android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Create a new Handler whose posted messages and runnables are not subject to
 * synchronization barriers such as display vsync.
 *
 * <p>Messages sent to an async handler are guaranteed to be ordered with respect to one another,
 * but not necessarily with respect to messages from other Handlers.</p>
 *
 * @see #createAsync(Looper, Callback) to create an async Handler with custom message handling.
 *
 * @param looper the Looper that the new Handler should be bound to
 * This value must never be {@code null}.
 * @return a new async Handler instance
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public static android.os.Handler createAsync(@androidx.annotation.RecentlyNonNull android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/**
 * Create a new Handler whose posted messages and runnables are not subject to
 * synchronization barriers such as display vsync.
 *
 * <p>Messages sent to an async handler are guaranteed to be ordered with respect to one another,
 * but not necessarily with respect to messages from other Handlers.</p>
 *
 * @see #createAsync(Looper) to create an async Handler without custom message handling.
 *
 * @param looper the Looper that the new Handler should be bound to
 * This value must never be {@code null}.
 * @param callback This value must never be {@code null}.
 * @return a new async Handler instance
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public static android.os.Handler createAsync(@androidx.annotation.RecentlyNonNull android.os.Looper looper, @androidx.annotation.RecentlyNonNull android.os.Handler.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string representing the name of the specified message.
 * The default implementation will either return the class name of the
 * message callback if any, or the hexadecimal representation of the
 * message "what" field.
 *
 * @param message The message whose name is being queried
 */

public java.lang.String getMessageName(android.os.Message message) { throw new RuntimeException("Stub!"); }

/**
 * Returns a new {@link android.os.Message Message} from the global message pool. More efficient than
 * creating and allocating new instances. The retrieved message has its handler set to this instance (Message.target == this).
 *  If you don't want that facility, just call Message.obtain() instead.
 */

public final android.os.Message obtainMessage() { throw new RuntimeException("Stub!"); }

/**
 * Same as {@link #obtainMessage()}, except that it also sets the what member of the returned Message.
 *
 * @param what Value to assign to the returned Message.what field.
 * @return A Message from the global message pool.
 */

public final android.os.Message obtainMessage(int what) { throw new RuntimeException("Stub!"); }

/**
 *
 * Same as {@link #obtainMessage()}, except that it also sets the what and obj members
 * of the returned Message.
 *
 * @param what Value to assign to the returned Message.what field.
 * @param obj Value to assign to the returned Message.obj field.
 * @return A Message from the global message pool.
 */

public final android.os.Message obtainMessage(int what, java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 *
 * Same as {@link #obtainMessage()}, except that it also sets the what, arg1 and arg2 members of the returned
 * Message.
 * @param what Value to assign to the returned Message.what field.
 * @param arg1 Value to assign to the returned Message.arg1 field.
 * @param arg2 Value to assign to the returned Message.arg2 field.
 * @return A Message from the global message pool.
 */

public final android.os.Message obtainMessage(int what, int arg1, int arg2) { throw new RuntimeException("Stub!"); }

/**
 *
 * Same as {@link #obtainMessage()}, except that it also sets the what, obj, arg1,and arg2 values on the
 * returned Message.
 * @param what Value to assign to the returned Message.what field.
 * @param arg1 Value to assign to the returned Message.arg1 field.
 * @param arg2 Value to assign to the returned Message.arg2 field.
 * @param obj Value to assign to the returned Message.obj field.
 * @return A Message from the global message pool.
 */

public final android.os.Message obtainMessage(int what, int arg1, int arg2, java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Causes the Runnable r to be added to the message queue.
 * The runnable will be run on the thread to which this handler is
 * attached.
 *
 * @param r The Runnable that will be executed.
 *
 * @return Returns true if the Runnable was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 */

public final boolean post(java.lang.Runnable r) { throw new RuntimeException("Stub!"); }

/**
 * Causes the Runnable r to be added to the message queue, to be run
 * at a specific time given by <var>uptimeMillis</var>.
 * <b>The time-base is {@link android.os.SystemClock#uptimeMillis}.</b>
 * Time spent in deep sleep will add an additional delay to execution.
 * The runnable will be run on the thread to which this handler is attached.
 *
 * @param r The Runnable that will be executed.
 * @param uptimeMillis The absolute time at which the callback should run,
 *         using the {@link android.os.SystemClock#uptimeMillis} time-base.
 *
 * @return Returns true if the Runnable was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the Runnable will be processed -- if
 *         the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 */

public final boolean postAtTime(java.lang.Runnable r, long uptimeMillis) { throw new RuntimeException("Stub!"); }

/**
 * Causes the Runnable r to be added to the message queue, to be run
 * at a specific time given by <var>uptimeMillis</var>.
 * <b>The time-base is {@link android.os.SystemClock#uptimeMillis}.</b>
 * Time spent in deep sleep will add an additional delay to execution.
 * The runnable will be run on the thread to which this handler is attached.
 *
 * @param r The Runnable that will be executed.
 * @param token An instance which can be used to cancel {@code r} via
 *         {@link #removeCallbacksAndMessages}.
 * @param uptimeMillis The absolute time at which the callback should run,
 *         using the {@link android.os.SystemClock#uptimeMillis} time-base.
 *
 * @return Returns true if the Runnable was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the Runnable will be processed -- if
 *         the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 *
 * @see android.os.SystemClock#uptimeMillis
 */

public final boolean postAtTime(java.lang.Runnable r, java.lang.Object token, long uptimeMillis) { throw new RuntimeException("Stub!"); }

/**
 * Causes the Runnable r to be added to the message queue, to be run
 * after the specified amount of time elapses.
 * The runnable will be run on the thread to which this handler
 * is attached.
 * <b>The time-base is {@link android.os.SystemClock#uptimeMillis}.</b>
 * Time spent in deep sleep will add an additional delay to execution.
 *
 * @param r The Runnable that will be executed.
 * @param delayMillis The delay (in milliseconds) until the Runnable
 *        will be executed.
 *
 * @return Returns true if the Runnable was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the Runnable will be processed --
 *         if the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 */

public final boolean postDelayed(java.lang.Runnable r, long delayMillis) { throw new RuntimeException("Stub!"); }

/**
 * Causes the Runnable r to be added to the message queue, to be run
 * after the specified amount of time elapses.
 * The runnable will be run on the thread to which this handler
 * is attached.
 * <b>The time-base is {@link android.os.SystemClock#uptimeMillis}.</b>
 * Time spent in deep sleep will add an additional delay to execution.
 *
 * @param r The Runnable that will be executed.
 * @param token An instance which can be used to cancel {@code r} via
 *         {@link #removeCallbacksAndMessages}.
 * @param delayMillis The delay (in milliseconds) until the Runnable
 *        will be executed.
 *
 * @return Returns true if the Runnable was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the Runnable will be processed --
 *         if the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 */

public final boolean postDelayed(java.lang.Runnable r, java.lang.Object token, long delayMillis) { throw new RuntimeException("Stub!"); }

/**
 * Posts a message to an object that implements Runnable.
 * Causes the Runnable r to executed on the next iteration through the
 * message queue. The runnable will be run on the thread to which this
 * handler is attached.
 * <b>This method is only for use in very special circumstances -- it
 * can easily starve the message queue, cause ordering problems, or have
 * other unexpected side-effects.</b>
 *
 * @param r The Runnable that will be executed.
 *
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 */

public final boolean postAtFrontOfQueue(java.lang.Runnable r) { throw new RuntimeException("Stub!"); }

/**
 * Remove any pending posts of Runnable r that are in the message queue.
 */

public final void removeCallbacks(java.lang.Runnable r) { throw new RuntimeException("Stub!"); }

/**
 * Remove any pending posts of Runnable <var>r</var> with Object
 * <var>token</var> that are in the message queue.  If <var>token</var> is null,
 * all callbacks will be removed.
 */

public final void removeCallbacks(java.lang.Runnable r, java.lang.Object token) { throw new RuntimeException("Stub!"); }

/**
 * Pushes a message onto the end of the message queue after all pending messages
 * before the current time. It will be received in {@link #handleMessage},
 * in the thread attached to this handler.
 *
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 */

public final boolean sendMessage(android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Sends a Message containing only the what value.
 *
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 */

public final boolean sendEmptyMessage(int what) { throw new RuntimeException("Stub!"); }

/**
 * Sends a Message containing only the what value, to be delivered
 * after the specified amount of time elapses.
 * @see #sendMessageDelayed(android.os.Message, long)
 *
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 */

public final boolean sendEmptyMessageDelayed(int what, long delayMillis) { throw new RuntimeException("Stub!"); }

/**
 * Sends a Message containing only the what value, to be delivered
 * at a specific time.
 * @see #sendMessageAtTime(android.os.Message, long)
 *
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 */

public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis) { throw new RuntimeException("Stub!"); }

/**
 * Enqueue a message into the message queue after all pending messages
 * before (current time + delayMillis). You will receive it in
 * {@link #handleMessage}, in the thread attached to this handler.
 *
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the message will be processed -- if
 *         the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 */

public final boolean sendMessageDelayed(android.os.Message msg, long delayMillis) { throw new RuntimeException("Stub!"); }

/**
 * Enqueue a message into the message queue after all pending messages
 * before the absolute time (in milliseconds) <var>uptimeMillis</var>.
 * <b>The time-base is {@link android.os.SystemClock#uptimeMillis}.</b>
 * Time spent in deep sleep will add an additional delay to execution.
 * You will receive it in {@link #handleMessage}, in the thread attached
 * to this handler.
 *
 * @param uptimeMillis The absolute time at which the message should be
 *         delivered, using the
 *         {@link android.os.SystemClock#uptimeMillis} time-base.
 *
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.  Note that a
 *         result of true does not mean the message will be processed -- if
 *         the looper is quit before the delivery time of the message
 *         occurs then the message will be dropped.
 */

public boolean sendMessageAtTime(android.os.Message msg, long uptimeMillis) { throw new RuntimeException("Stub!"); }

/**
 * Enqueue a message at the front of the message queue, to be processed on
 * the next iteration of the message loop.  You will receive it in
 * {@link #handleMessage}, in the thread attached to this handler.
 * <b>This method is only for use in very special circumstances -- it
 * can easily starve the message queue, cause ordering problems, or have
 * other unexpected side-effects.</b>
 *
 * @return Returns true if the message was successfully placed in to the
 *         message queue.  Returns false on failure, usually because the
 *         looper processing the message queue is exiting.
 */

public final boolean sendMessageAtFrontOfQueue(android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Remove any pending posts of messages with code 'what' that are in the
 * message queue.
 */

public final void removeMessages(int what) { throw new RuntimeException("Stub!"); }

/**
 * Remove any pending posts of messages with code 'what' and whose obj is
 * 'object' that are in the message queue.  If <var>object</var> is null,
 * all messages will be removed.
 */

public final void removeMessages(int what, java.lang.Object object) { throw new RuntimeException("Stub!"); }

/**
 * Remove any pending posts of callbacks and sent messages whose
 * <var>obj</var> is <var>token</var>.  If <var>token</var> is null,
 * all callbacks and messages will be removed.
 */

public final void removeCallbacksAndMessages(java.lang.Object token) { throw new RuntimeException("Stub!"); }

/**
 * Check if there are any pending posts of messages with code 'what' in
 * the message queue.
 */

public final boolean hasMessages(int what) { throw new RuntimeException("Stub!"); }

/**
 * Check if there are any pending posts of messages with code 'what' and
 * whose obj is 'object' in the message queue.
 */

public final boolean hasMessages(int what, java.lang.Object object) { throw new RuntimeException("Stub!"); }

public final android.os.Looper getLooper() { throw new RuntimeException("Stub!"); }

public final void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/**
 * Callback interface you can use when instantiating a Handler to avoid
 * having to implement your own subclass of Handler.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Callback {

/**
 * @param msg A {@link android.os.Message Message} object
 * @return True if no further handling is desired
 */

public boolean handleMessage(android.os.Message msg);
}

}

