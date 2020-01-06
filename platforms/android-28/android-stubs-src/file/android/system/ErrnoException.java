/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.system;


/**
 * A checked exception thrown when {@link Os} methods fail. This exception contains the native
 * errno value, for comparison against the constants in {@link OsConstants}, should sophisticated
 * callers need to adjust their behavior based on the exact failure.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ErrnoException extends java.lang.Exception {

/**
 * Constructs an instance with the given function name and errno value.
 */

public ErrnoException(java.lang.String functionName, int errno) { throw new RuntimeException("Stub!"); }

/**
 * Constructs an instance with the given function name, errno value, and cause.
 */

public ErrnoException(java.lang.String functionName, int errno, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

/**
 * Converts the stashed function name and errno value to a human-readable string.
 * We do this here rather than in the constructor so that callers only pay for
 * this if they need it.
 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }

/**
 * The errno value, for comparison with the {@code E} constants in {@link OsConstants}.
 */

public final int errno;
{ errno = 0; }
}

