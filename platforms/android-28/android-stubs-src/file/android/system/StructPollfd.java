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

import java.io.FileDescriptor;

/**
 * Used as an in/out parameter to {@link Os#poll}.
 * Corresponds to C's {@code struct pollfd} from {@code <poll.h>}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class StructPollfd {

public StructPollfd() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The events we're interested in. POLLIN corresponds to being in select(2)'s read fd set,
 * POLLOUT to the write fd set.
 */

public short events;

/** The file descriptor to poll. */

public java.io.FileDescriptor fd;

/** The events that actually happened. */

public short revents;

/**
 * A non-standard extension that lets callers conveniently map back to the object
 * their fd belongs to. This is used by Selector, for example, to associate each
 * FileDescriptor with the corresponding SelectionKey.
 */

public java.lang.Object userData;
}

