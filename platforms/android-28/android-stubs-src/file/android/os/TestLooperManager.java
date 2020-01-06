/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */


package android.os;


/**
 * Blocks a looper from executing any messages, and allows the holder of this object
 * to control when and which messages get executed until it is released.
 * <p>
 * A TestLooperManager should be acquired using
 * {@link android.app.Instrumentation#acquireLooperManager}. Until {@link #release()} is called,
 * the Looper thread will not execute any messages except when {@link #execute(Message)} is called.
 * The test code may use {@link #next()} to acquire messages that have been queued to this
 * {@link Looper}/{@link MessageQueue} and then {@link #execute} to run any that desires.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TestLooperManager {

/**
 * @hide
 */

TestLooperManager(android.os.Looper looper) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link MessageQueue} this object is wrapping.
 */

public android.os.MessageQueue getMessageQueue() { throw new RuntimeException("Stub!"); }

/**
 * Returns the next message that should be executed by this queue, may block
 * if no messages are ready.
 * <p>
 * Callers should always call {@link #recycle(Message)} on the message when all
 * interactions with it have completed.
 */

public android.os.Message next() { throw new RuntimeException("Stub!"); }

/**
 * Releases the looper to continue standard looping and processing of messages,
 * no further interactions with TestLooperManager will be allowed after
 * release() has been called.
 */

public void release() { throw new RuntimeException("Stub!"); }

/**
 * Executes the given message on the Looper thread this wrapper is
 * attached to.
 * <p>
 * Execution will happen on the Looper's thread (whether it is the current thread
 * or not), but all RuntimeExceptions encountered while executing the message will
 * be thrown on the calling thread.
 */

public void execute(android.os.Message message) { throw new RuntimeException("Stub!"); }

/**
 * Called to indicate that a Message returned by {@link #next()} has been parsed
 * and should be recycled.
 */

public void recycle(android.os.Message msg) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if there are any queued messages that match the parameters.
 *
 * @param h      the value of {@link Message#getTarget()}
 * @param what   the value of {@link Message#what}
 * @param object the value of {@link Message#obj}, null for any
 */

public boolean hasMessages(android.os.Handler h, java.lang.Object object, int what) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if there are any queued messages that match the parameters.
 *
 * @param h      the value of {@link Message#getTarget()}
 * @param r      the value of {@link Message#getCallback()}
 * @param object the value of {@link Message#obj}, null for any
 */

public boolean hasMessages(android.os.Handler h, java.lang.Object object, java.lang.Runnable r) { throw new RuntimeException("Stub!"); }
}

