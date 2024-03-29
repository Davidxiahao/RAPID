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


package android.util;


/**
 * @deprecated This class is no longer functional.
 * Use {@link android.util.EventLog} instead.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public class EventLogTags {

public EventLogTags() throws java.io.IOException { throw new RuntimeException("Stub!"); }

public EventLogTags(java.io.BufferedReader input) throws java.io.IOException { throw new RuntimeException("Stub!"); }

public android.util.EventLogTags.Description get(java.lang.String name) { throw new RuntimeException("Stub!"); }

public android.util.EventLogTags.Description get(int tag) { throw new RuntimeException("Stub!"); }
@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Description {

Description(int tag, java.lang.String name) { throw new RuntimeException("Stub!"); }

public final java.lang.String mName;
{ mName = null; }

public final int mTag;
{ mTag = 0; }
}

}

