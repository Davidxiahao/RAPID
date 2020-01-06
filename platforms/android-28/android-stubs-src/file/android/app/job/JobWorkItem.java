/*
 * Copyright (C) 2017 The Android Open Source Project
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


package android.app.job;

import android.content.Intent;

/**
 * A unit of work that can be enqueued for a job using
 * {@link JobScheduler#enqueue JobScheduler.enqueue}.  See
 * {@link JobParameters#dequeueWork() JobParameters.dequeueWork} for more details.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class JobWorkItem implements android.os.Parcelable {

/**
 * Create a new piece of work, which can be submitted to
 * {@link JobScheduler#enqueue JobScheduler.enqueue}.
 *
 * @param intent The general Intent describing this work.
 */

public JobWorkItem(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

/**
 * Create a new piece of work, which can be submitted to
 * {@link JobScheduler#enqueue JobScheduler.enqueue}.
 * <p>
 * See {@link JobInfo.Builder#setEstimatedNetworkBytes(long, long)} for
 * details about how to estimate network traffic.
 *
 * @param intent The general Intent describing this work.
 * @param downloadBytes The estimated size of network traffic that will be
 *            downloaded by this job work item, in bytes.
 * Value is a non-negative number of bytes.
 * @param uploadBytes The estimated size of network traffic that will be
 *            uploaded by this job work item, in bytes.

 * Value is a non-negative number of bytes.
 */

public JobWorkItem(android.content.Intent intent, long downloadBytes, long uploadBytes) { throw new RuntimeException("Stub!"); }

/**
 * Return the Intent associated with this work.
 */

public android.content.Intent getIntent() { throw new RuntimeException("Stub!"); }

/**
 * Return the estimated size of download traffic that will be performed by
 * this job, in bytes.
 *
 * Value is a non-negative number of bytes.
 * @return Estimated size of download traffic, or
 *         {@link JobInfo#NETWORK_BYTES_UNKNOWN} when unknown.

 * Value is a non-negative number of bytes.
 */

public long getEstimatedNetworkDownloadBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the estimated size of upload traffic that will be performed by
 * this job work item, in bytes.
 *
 * Value is a non-negative number of bytes.
 * @return Estimated size of upload traffic, or
 *         {@link JobInfo#NETWORK_BYTES_UNKNOWN} when unknown.

 * Value is a non-negative number of bytes.
 */

public long getEstimatedNetworkUploadBytes() { throw new RuntimeException("Stub!"); }

/**
 * Return the count of the number of times this work item has been delivered
 * to the job.  The value will be > 1 if it has been redelivered because the job
 * was stopped or crashed while it had previously been delivered but before the
 * job had called {@link JobParameters#completeWork JobParameters.completeWork} for it.
 */

public int getDeliveryCount() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.job.JobWorkItem> CREATOR;
static { CREATOR = null; }
}

