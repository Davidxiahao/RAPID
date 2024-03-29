/*
 * Copyright (C) 2012 The Android Open Source Project
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
 * Writes trace events to the system trace buffer.  These trace events can be
 * collected and visualized using the Systrace tool.
 *
 * <p>This tracing mechanism is independent of the method tracing mechanism
 * offered by {@link Debug#startMethodTracing}.  In particular, it enables
 * tracing of events that occur across multiple processes.
 * <p>For information about using the Systrace tool, read <a
 * href="{@docRoot}tools/debugging/systrace.html">Analyzing Display and Performance
 * with Systrace</a>.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Trace {

Trace() { throw new RuntimeException("Stub!"); }

/**
 * Writes a trace message to indicate that a given section of code has begun. This call must
 * be followed by a corresponding call to {@link #endSection()} on the same thread.
 *
 * <p class="note"> At this time the vertical bar character '|', newline character '\n', and
 * null character '\0' are used internally by the tracing mechanism.  If sectionName contains
 * these characters they will be replaced with a space character in the trace.
 *
 * @param sectionName The name of the code section to appear in the trace.  This may be at
 * most 127 Unicode code units long.
 */

public static void beginSection(java.lang.String sectionName) { throw new RuntimeException("Stub!"); }

/**
 * Writes a trace message to indicate that a given section of code has ended. This call must
 * be preceeded by a corresponding call to {@link #beginSection(String)}. Calling this method
 * will mark the end of the most recently begun section of code, so care must be taken to
 * ensure that beginSection / endSection pairs are properly nested and called from the same
 * thread.
 */

public static void endSection() { throw new RuntimeException("Stub!"); }
}

