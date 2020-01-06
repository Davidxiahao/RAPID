/*
 * Copyright (C) 2014 The Android Open Source Project
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
 * limitations under the License
 */


package android.app.job;

import android.app.Service;
import android.content.Intent;
import android.os.Message;
import android.os.Handler;

/**
 * Helper for implementing a {@link android.app.Service} that interacts with
 * {@link JobScheduler}.  This is not intended for use by regular applications, but
 * allows frameworks built on top of the platform to create their own
 * {@link android.app.Service} that interact with {@link JobScheduler} as well as
 * add in additional functionality.  If you just want to execute jobs normally, you
 * should instead be looking at {@link JobService}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class JobServiceEngine {

/**
 * Create a new engine, ready for use.
 *
 * @param service The {@link Service} that is creating this engine and in which it will run.
 */

public JobServiceEngine(android.app.Service service) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the engine's IPC interface that should be returned by
 * {@link Service#onBind(Intent)}.
 */

public final android.os.IBinder getBinder() { throw new RuntimeException("Stub!"); }

/**
 * Engine's report that a job has started.  See
 * {@link JobService#onStartJob(JobParameters) JobService.onStartJob} for more information.
 */

public abstract boolean onStartJob(android.app.job.JobParameters params);

/**
 * Engine's report that a job has stopped.  See
 * {@link JobService#onStopJob(JobParameters) JobService.onStopJob} for more information.
 */

public abstract boolean onStopJob(android.app.job.JobParameters params);

/**
 * Call in to engine to report that a job has finished executing.  See
 * {@link JobService#jobFinished(JobParameters, boolean)}  JobService.jobFinished} for more
 * information.
 */

public void jobFinished(android.app.job.JobParameters params, boolean needsReschedule) { throw new RuntimeException("Stub!"); }
}

