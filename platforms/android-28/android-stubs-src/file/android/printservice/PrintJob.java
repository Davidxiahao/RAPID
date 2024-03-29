/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.printservice;

import android.print.PrintJobInfo;
import android.content.Context;

/**
 * This class represents a print job from the perspective of a print
 * service. It provides APIs for observing the print job state and
 * performing operations on the print job.
 * <p>
 * <strong>Note: </strong> All methods of this class must be invoked on
 * the main application thread.
 * </p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PrintJob {

PrintJob() { throw new RuntimeException("Stub!"); }

/**
 * Gets the unique print job id.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return The id.
 */

public android.print.PrintJobId getId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link PrintJobInfo} that describes this job.
 * <p>
 * <strong>Node:</strong>The returned info object is a snapshot of the
 * current print job state. Every call to this method returns a fresh
 * info object that reflects the current print job state.
 * </p>
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return The print job info.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.print.PrintJobInfo getInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the printed document.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return The document.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.printservice.PrintDocument getDocument() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this print job is queued. Such a print job is
 * ready to be printed and can be started or cancelled.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return Whether the print job is queued.
 *
 * @see #start()
 * @see #cancel()
 */

public boolean isQueued() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this print job is started. Such a print job is
 * being printed and can be completed or canceled or failed.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return Whether the print job is started.
 *
 * @see #complete()
 * @see #cancel()
 * @see #fail(String)
 */

public boolean isStarted() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this print job is blocked. Such a print job is halted
 * due to an abnormal condition and can be started or canceled or failed.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return Whether the print job is blocked.
 *
 * @see #start()
 * @see #cancel()
 * @see #fail(String)
 */

public boolean isBlocked() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this print job is completed. Such a print job
 * is successfully printed. This is a final state.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return Whether the print job is completed.
 *
 * @see #complete()
 */

public boolean isCompleted() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this print job is failed. Such a print job is
 * not successfully printed due to an error. This is a final state.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return Whether the print job is failed.
 *
 * @see #fail(String)
 */

public boolean isFailed() { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this print job is cancelled. Such a print job was
 * cancelled as a result of a user request. This is a final state.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return Whether the print job is cancelled.
 *
 * @see #cancel()
 */

public boolean isCancelled() { throw new RuntimeException("Stub!"); }

/**
 * Starts the print job. You should call this method if {@link
 * #isQueued()} or {@link #isBlocked()} returns true and you started
 * resumed printing.
 * <p>
 * This resets the print status to null. Set the new status by using {@link #setStatus}.
 * </p>
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return Whether the job was started.
 *
 * @see #isQueued()
 * @see #isBlocked()
 */

public boolean start() { throw new RuntimeException("Stub!"); }

/**
 * Blocks the print job. You should call this method if {@link #isStarted()} returns true and
 * you need to block the print job. For example, the user has to add some paper to continue
 * printing. To resume the print job call {@link #start()}. To change the reason call
 * {@link #setStatus(CharSequence)}.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @param reason The human readable, short, and translated reason why the print job is blocked.
 * This value may be {@code null}.
 * @return Whether the job was blocked.
 *
 * @see #isStarted()
 * @see #isBlocked()
 */

public boolean block(@androidx.annotation.RecentlyNullable java.lang.String reason) { throw new RuntimeException("Stub!"); }

/**
 * Completes the print job. You should call this method if {@link
 * #isStarted()} returns true and you are done printing.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return Whether the job as completed.
 *
 * @see #isStarted()
 */

public boolean complete() { throw new RuntimeException("Stub!"); }

/**
 * Fails the print job. You should call this method if {@link
 * #isQueued()} or {@link #isStarted()} or {@link #isBlocked()}
 * returns true you failed while printing.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @param error The human readable, short, and translated reason
 * for the failure.
 * This value may be {@code null}.
 * @return Whether the job was failed.
 *
 * @see #isQueued()
 * @see #isStarted()
 * @see #isBlocked()
 */

public boolean fail(@androidx.annotation.RecentlyNullable java.lang.String error) { throw new RuntimeException("Stub!"); }

/**
 * Cancels the print job. You should call this method if {@link
 * #isQueued()} or {@link #isStarted() or #isBlocked()} returns
 * true and you canceled the print job as a response to a call to
 * {@link PrintService#onRequestCancelPrintJob(PrintJob)}.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return Whether the job is canceled.
 *
 * @see #isStarted()
 * @see #isQueued()
 * @see #isBlocked()
 */

public boolean cancel() { throw new RuntimeException("Stub!"); }

/**
 * Sets the progress of this print job as a fraction of 1.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @param progress The new progress

 * Value is between 0.0 and 1.0 inclusive
 */

public void setProgress(float progress) { throw new RuntimeException("Stub!"); }

/**
 * Sets the status of this print job. This should be a human readable, short, and translated
 * description of the current state of the print job.
 * <p />
 * This overrides any previously set status set via {@link #setStatus(CharSequence)},
 * {@link #setStatus(int)}, {@link #block(String)}, or {@link #fail(String)},
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @param status The new status. If null the status will be empty.

 * This value may be {@code null}.
 */

public void setStatus(@androidx.annotation.RecentlyNullable java.lang.CharSequence status) { throw new RuntimeException("Stub!"); }

/**
 * Sets the status of this print job as a string resource.
 * <p />
 * This overrides any previously set status set via {@link #setStatus(CharSequence)},
 * {@link #setStatus(int)}, {@link #block(String)}, or {@link #fail(String)},
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @param statusResId The new status as a String resource. If 0 the status will be empty.
 */

public void setStatus(int statusResId) { throw new RuntimeException("Stub!"); }

/**
 * Sets a tag that is valid in the context of a {@link PrintService}
 * and is not interpreted by the system. For example, a print service
 * may set as a tag the key of the print job returned by a remote
 * print server, if the printing is off handed to a cloud based service.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @param tag The tag.
 * This value must never be {@code null}.
 * @return True if the tag was set, false otherwise.
 */

public boolean setTag(@androidx.annotation.RecentlyNonNull java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Gets the print job tag.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @return The tag or null.
 *
 * @see #setTag(String)
 */

@androidx.annotation.RecentlyNullable public java.lang.String getTag() { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of an advanced (printer specific) print option.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @param key The option key.
 * @return The option value.
 */

public java.lang.String getAdvancedStringOption(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets whether this job has a given advanced (printer specific) print
 * option.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @param key The option key.
 * @return Whether the option is present.
 */

public boolean hasAdvancedOption(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets the value of an advanced (printer specific) print option.
 *
 * This method must be called from the
 *  *            {@linkplain Looper#getMainLooper() main thread} of your app.
 * @param key The option key.
 * @return The option value.
 */

public int getAdvancedIntOption(java.lang.String key) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }
}

