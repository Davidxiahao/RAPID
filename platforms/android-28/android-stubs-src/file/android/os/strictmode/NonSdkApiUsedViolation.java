/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.os.strictmode;


/**
 * Subclass of {@code Violation} that is used when a process accesses
 * a non SDK API.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class NonSdkApiUsedViolation extends android.os.strictmode.Violation {

/** @hide */

NonSdkApiUsedViolation(java.lang.String message) { super(null); throw new RuntimeException("Stub!"); }
}

