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


package android.print;

import android.content.pm.PackageManager;
import android.graphics.drawable.Icon;
import android.app.Activity;
import java.util.List;
import android.os.Handler;
import android.content.IntentSender;

/**
 * System level service for accessing the printing capabilities of the platform.
 *
 * <h3>Print mechanics</h3>
 * <p>
 * The key idea behind printing on the platform is that the content to be printed
 * should be laid out for the currently selected print options resulting in an
 * optimized output and higher user satisfaction. To achieve this goal the platform
 * declares a contract that the printing application has to follow which is defined
 * by the {@link PrintDocumentAdapter} class. At a higher level the contract is that
 * when the user selects some options from the print UI that may affect the way
 * content is laid out, for example page size, the application receives a callback
 * allowing it to layout the content to better fit these new constraints. After a
 * layout pass the system may ask the application to render one or more pages one
 * or more times. For example, an application may produce a single column list for
 * smaller page sizes and a multi-column table for larger page sizes.
 * </p>
 * <h3>Print jobs</h3>
 * <p>
 * Print jobs are started by calling the {@link #print(String, PrintDocumentAdapter,
 * PrintAttributes)} from an activity which results in bringing up the system print
 * UI. Once the print UI is up, when the user changes a selected print option that
 * affects the way content is laid out the system starts to interact with the
 * application following the mechanics described the section above.
 * </p>
 * <p>
 * Print jobs can be in {@link PrintJobInfo#STATE_CREATED created}, {@link
 * PrintJobInfo#STATE_QUEUED queued}, {@link PrintJobInfo#STATE_STARTED started},
 * {@link PrintJobInfo#STATE_BLOCKED blocked}, {@link PrintJobInfo#STATE_COMPLETED
 * completed}, {@link PrintJobInfo#STATE_FAILED failed}, and {@link
 * PrintJobInfo#STATE_CANCELED canceled} state. Print jobs are stored in dedicated
 * system spooler until they are handled which is they are cancelled or completed.
 * Active print jobs, ones that are not cancelled or completed, are considered failed
 * if the device reboots as the new boot may be after a very long time. The user may
 * choose to restart such print jobs. Once a print job is queued all relevant content
 * is stored in the system spooler and its lifecycle becomes detached from this of
 * the application that created it.
 * </p>
 * <p>
 * An applications can query the print spooler for current print jobs it created
 * but not print jobs created by other applications.
 * </p>
 *
 * Requires the {@link android.content.pm.PackageManager#FEATURE_PRINTING PackageManager#FEATURE_PRINTING} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 * @see PrintJob
 * @see PrintJobInfo
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PrintManager {

PrintManager() { throw new RuntimeException("Stub!"); }

/**
 * Gets the print jobs for this application.
 *
 * @return The print job list.
 * This value will never be {@code null}.
 * @see PrintJob
 */

@androidx.annotation.RecentlyNonNull public java.util.List<android.print.PrintJob> getPrintJobs() { throw new RuntimeException("Stub!"); }

/**
 * Creates a print job for printing a {@link PrintDocumentAdapter} with
 * default print attributes.
 * <p>
 * Calling this method brings the print UI allowing the user to customize
 * the print job and returns a {@link PrintJob} object without waiting for the
 * user to customize or confirm the print job. The returned print job instance
 * is in a {@link PrintJobInfo#STATE_CREATED created} state.
 * <p>
 * This method can be called only from an {@link Activity}. The rationale is that
 * printing from a service will create an inconsistent user experience as the print
 * UI would appear without any context.
 * </p>
 * <p>
 * Also the passed in {@link PrintDocumentAdapter} will be considered invalid if
 * your activity is finished. The rationale is that once the activity that
 * initiated printing is finished, the provided adapter may be in an inconsistent
 * state as it may depend on the UI presented by the activity.
 * </p>
 * <p>
 * The default print attributes are a hint to the system how the data is to
 * be printed. For example, a photo editor may look at the photo aspect ratio
 * to determine the default orientation and provide a hint whether the printing
 * should be in portrait or landscape. The system will do a best effort to
 * selected the hinted options in the print dialog, given the current printer
 * supports them.
 * </p>
 * <p>
 * <strong>Note:</strong> Calling this method will bring the print dialog and
 * the system will connect to the provided {@link PrintDocumentAdapter}. If a
 * configuration change occurs that you application does not handle, for example
 * a rotation change, the system will drop the connection to the adapter as the
 * activity has to be recreated and the old adapter may be invalid in this context,
 * hence a new adapter instance is required. As a consequence, if your activity
 * does not handle configuration changes (default behavior), you have to save the
 * state that you were printing and call this method again when your activity
 * is recreated.
 * </p>
 *
 * @param printJobName A name for the new print job which is shown to the user.
 * This value must never be {@code null}.
 * @param documentAdapter An adapter that emits the document to print.
 * This value must never be {@code null}.
 * @param attributes The default print job attributes or <code>null</code>.
 * This value may be {@code null}.
 * @return The created print job on success or null on failure.
 * @throws IllegalStateException If not called from an {@link Activity}.
 * @throws IllegalArgumentException If the print job name is empty or the
 * document adapter is null.
 *
 * @see PrintJob
 */

@androidx.annotation.RecentlyNonNull public android.print.PrintJob print(@androidx.annotation.RecentlyNonNull java.lang.String printJobName, @androidx.annotation.RecentlyNonNull android.print.PrintDocumentAdapter documentAdapter, @androidx.annotation.RecentlyNullable android.print.PrintAttributes attributes) { throw new RuntimeException("Stub!"); }
}

