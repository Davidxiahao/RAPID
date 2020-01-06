/*
 * Copyright (C) 2010 The Android Open Source Project
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


package android.app.backup;


/**
 * Callback class for receiving progress reports during a restore operation.  These
 * methods will all be called on your application's main thread.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class RestoreObserver {

public RestoreObserver() { throw new RuntimeException("Stub!"); }

/**
 * The restore operation has begun.
 *
 * @param numPackages The total number of packages being processed in
 *   this restore operation.
 */

public void restoreStarting(int numPackages) { throw new RuntimeException("Stub!"); }

/**
 * An indication of which package is being restored currently, out of the
 * total number provided in the {@link #restoreStarting(int)} callback.  This method
 * is not guaranteed to be called: if the transport is unable to obtain
 * data for one or more of the requested packages, no onUpdate() call will
 * occur for those packages.
 *
 * @param nowBeingRestored The index, between 1 and the numPackages parameter
 *   to the {@link #restoreStarting(int)} callback, of the package now being
 *   restored.  This may be non-monotonic; it is intended purely as a rough
 *   indication of the backup manager's progress through the overall restore process.
 * @param currentPackage The name of the package now being restored.
 */

public void onUpdate(int nowBeingRestored, java.lang.String currentPackage) { throw new RuntimeException("Stub!"); }

/**
 * The restore process has completed.  This method will always be called,
 * even if no individual package restore operations were attempted.
 *
 * @param error Zero on success; a nonzero error code if the restore operation
 *   as a whole failed.
 */

public void restoreFinished(int error) { throw new RuntimeException("Stub!"); }
}

