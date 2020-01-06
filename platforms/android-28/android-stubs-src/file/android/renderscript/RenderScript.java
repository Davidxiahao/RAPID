/*
 * Copyright (C) 2008-2012 The Android Open Source Project
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


package android.renderscript;

import android.content.Context;

/**
 * This class provides access to a RenderScript context, which controls RenderScript
 * initialization, resource management, and teardown. An instance of the RenderScript
 * class must be created before any other RS objects can be created.
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating an application that uses RenderScript, read the
 * <a href="{@docRoot}guide/topics/renderscript/index.html">RenderScript</a> developer guide.</p>
 * </div>
 **/

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RenderScript {

RenderScript(android.content.Context ctx) { throw new RuntimeException("Stub!"); }

/**
 * Returns an identifier that can be used to identify a particular
 * minor version of RS.
 *
 * @return The minor RenderScript version number
 *
 */

public static long getMinorVersion() { throw new RuntimeException("Stub!"); }

public void setMessageHandler(android.renderscript.RenderScript.RSMessageHandler msg) { throw new RuntimeException("Stub!"); }

public android.renderscript.RenderScript.RSMessageHandler getMessageHandler() { throw new RuntimeException("Stub!"); }

/**
 * Place a message into the message queue to be sent back to the message
 * handler once all previous commands have been executed.
 *
 * @param id
 * @param data
 */

public void sendMessage(int id, int[] data) { throw new RuntimeException("Stub!"); }

public void setErrorHandler(android.renderscript.RenderScript.RSErrorHandler msg) { throw new RuntimeException("Stub!"); }

public android.renderscript.RenderScript.RSErrorHandler getErrorHandler() { throw new RuntimeException("Stub!"); }

/**
 * Change the priority of the worker threads for this context.
 *
 * @param p New priority to be set.
 */

public void setPriority(android.renderscript.RenderScript.Priority p) { throw new RuntimeException("Stub!"); }

/**
 * Gets the application context associated with the RenderScript context.
 *
 * @return The application context.
 */

public final android.content.Context getApplicationContext() { throw new RuntimeException("Stub!"); }

/**
 * calls create(ctx, ContextType.NORMAL, CREATE_FLAG_NONE)
 *
 * See documentation for @create for details
 *
 * @param ctx The context.
 * @return RenderScript
 */

public static android.renderscript.RenderScript create(android.content.Context ctx) { throw new RuntimeException("Stub!"); }

/**
 * calls create(ctx, ct, CREATE_FLAG_NONE)
 *
 * See documentation for @create for details
 *
 * @param ctx The context.
 * @param ct The type of context to be created.
 * @return RenderScript
 */

public static android.renderscript.RenderScript create(android.content.Context ctx, android.renderscript.RenderScript.ContextType ct) { throw new RuntimeException("Stub!"); }

/**
 * Gets or creates a RenderScript context of the specified type.
 *
 * The returned context will be cached for future reuse within
 * the process. When an application is finished using
 * RenderScript it should call releaseAllContexts()
 *
 * A process context is a context designed for easy creation and
 * lifecycle management.  Multiple calls to this function will
 * return the same object provided they are called with the same
 * options.  This allows it to be used any time a RenderScript
 * context is needed.
 *
 * Prior to API 23 this always created a new context.
 *
 * @param ctx The context.
 * @param ct The type of context to be created.
 * @param flags The OR of the CREATE_FLAG_* options desired
 * @return RenderScript
 */

public static android.renderscript.RenderScript create(android.content.Context ctx, android.renderscript.RenderScript.ContextType ct, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Releases all the process contexts.  This is the same as
 * calling .destroy() on each unique context retreived with
 * create(...). If no contexts have been created this
 * function does nothing.
 *
 * Typically you call this when your application is losing focus
 * and will not be using a context for some time.
 *
 * This has no effect on a context created with
 * createMultiContext()
 */

public static void releaseAllContexts() { throw new RuntimeException("Stub!"); }

/**
 * Create a RenderScript context.
 *
 * This is an advanced function intended for applications which
 * need to create more than one RenderScript context to be used
 * at the same time.
 *
 * If you need a single context please use create()
 *
 * @param ctx The context.
 * @return RenderScript
 */

public static android.renderscript.RenderScript createMultiContext(android.content.Context ctx, android.renderscript.RenderScript.ContextType ct, int flags, int API_number) { throw new RuntimeException("Stub!"); }

/**
 * Print the currently available debugging information about the state of
 * the RS context to the log.
 *
 */

public void contextDump() { throw new RuntimeException("Stub!"); }

/**
 * Wait for any pending asynchronous opeations (such as copies to a RS
 * allocation or RS script executions) to complete.
 *
 */

public void finish() { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Destroys this RenderScript context.  Once this function is called,
 * using this context or any objects belonging to this context is
 * illegal.
 *
 * API 23+, this function is a NOP if the context was created
 * with create().  Please use releaseAllContexts() to clean up
 * contexts created with the create function.
 *
 */

public void destroy() { throw new RuntimeException("Stub!"); }

public static final int CREATE_FLAG_LOW_LATENCY = 2; // 0x2

public static final int CREATE_FLAG_LOW_POWER = 4; // 0x4

public static final int CREATE_FLAG_NONE = 0; // 0x0
/**
 * ContextType specifies the specific type of context to be created.
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum ContextType {
NORMAL, DEBUG, PROFILE;
}

/**
 * RenderScript worker thread priority enumeration.  The default value is
 * NORMAL.  Applications wishing to do background processing should set
 * their priority to LOW to avoid starving forground processes.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Priority {
LOW, NORMAL;
}

/**
 * The runtime error handler base class.  An application should derive from this class
 * if it wishes to install an error handler.  When errors occur at runtime,
 * the fields in this class will be filled, and the run method will be called.
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class RSErrorHandler implements java.lang.Runnable {

public RSErrorHandler() { throw new RuntimeException("Stub!"); }

public void run() { throw new RuntimeException("Stub!"); }

protected java.lang.String mErrorMessage;

protected int mErrorNum;
}

/**
 * The base class from which an application should derive in order
 * to receive RS messages from scripts. When a script calls {@code
 * rsSendToClient}, the data fields will be filled, and the run
 * method will be called on a separate thread.  This will occur
 * some time after {@code rsSendToClient} completes in the script,
 * as {@code rsSendToClient} is asynchronous. Message handlers are
 * not guaranteed to have completed when {@link
 * android.renderscript.RenderScript#finish} returns.
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class RSMessageHandler implements java.lang.Runnable {

public RSMessageHandler() { throw new RuntimeException("Stub!"); }

public void run() { throw new RuntimeException("Stub!"); }

protected int[] mData;

protected int mID;

protected int mLength;
}

}

