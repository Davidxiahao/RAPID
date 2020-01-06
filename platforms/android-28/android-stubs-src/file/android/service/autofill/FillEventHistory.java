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


package android.service.autofill;

import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.content.IntentSender;

/**
 * Describes what happened after the last
 * {@link AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal, FillCallback)}
 * call.
 *
 * <p>This history is typically used to keep track of previous user actions to optimize further
 * requests. For example, the service might return email addresses in alphabetical order by
 * default, but change that order based on the address the user picked on previous requests.
 *
 * <p>The history is not persisted over reboots, and it's cleared every time the service
 * replies to a
 * {@link AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal, FillCallback)}
 * by calling {@link FillCallback#onSuccess(FillResponse)} or
 * {@link FillCallback#onFailure(CharSequence)} (if the service doesn't call any of these methods,
 * the history will clear out after some pre-defined time).
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FillEventHistory implements android.os.Parcelable {

/**
 * @hide
 */

FillEventHistory(int sessionId, android.os.Bundle clientState) { throw new RuntimeException("Stub!"); }

/**
 * Returns the client state set in the previous {@link FillResponse}.
 *
 * <p><b>Note: </b>the state is associated with the app that was autofilled in the previous
 * {@link AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal, FillCallback)}
 * , which is not necessary the same app being autofilled now.
 *
 * @deprecated use {@link #getEvents()} then {@link Event#getClientState()} instead.

 * @return This value may be {@code null}.
 */

@Deprecated @androidx.annotation.RecentlyNullable public android.os.Bundle getClientState() { throw new RuntimeException("Stub!"); }

/**
 * Returns the events occurred after the latest call to
 * {@link FillCallback#onSuccess(FillResponse)}.
 *
 * @return The list of events or {@code null} if non occurred.
 */

@androidx.annotation.RecentlyNullable public java.util.List<android.service.autofill.FillEventHistory.Event> getEvents() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.service.autofill.FillEventHistory> CREATOR;
static { CREATOR = null; }
/**
 * Description of an event that occured after the latest call to
 * {@link FillCallback#onSuccess(FillResponse)}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Event {

/**
 * Creates a new event.
 *
 * @param eventType The type of the event
 * @param datasetId The dataset the event was on, or {@code null} if the event was on the
 *                  whole response.
 * @param clientState The client state associated with the event.
 * @param selectedDatasetIds The ids of datasets selected by the user.
 * @param ignoredDatasetIds The ids of datasets NOT select by the user.
 * @param changedFieldIds The ids of fields changed by the user.
 * @param changedDatasetIds The ids of the datasets that havd values matching the
 * respective entry on {@code changedFieldIds}.
 * @param manuallyFilledFieldIds The ids of fields that were manually entered by the user
 * and belonged to datasets.
 * @param manuallyFilledDatasetIds The ids of datasets that had values matching the
 * respective entry on {@code manuallyFilledFieldIds}.
 * @param detectedFieldClassifications the field classification matches.
 *
 * @throws IllegalArgumentException If the length of {@code changedFieldIds} and
 * {@code changedDatasetIds} doesn't match.
 * @throws IllegalArgumentException If the length of {@code manuallyFilledFieldIds} and
 * {@code manuallyFilledDatasetIds} doesn't match.
 *
 * @hide
 */

Event(int eventType, java.lang.String datasetId, android.os.Bundle clientState, java.util.List<java.lang.String> selectedDatasetIds, android.util.ArraySet<java.lang.String> ignoredDatasetIds, java.util.ArrayList<android.view.autofill.AutofillId> changedFieldIds, java.util.ArrayList<java.lang.String> changedDatasetIds, java.util.ArrayList<android.view.autofill.AutofillId> manuallyFilledFieldIds, java.util.ArrayList<java.util.ArrayList<java.lang.String>> manuallyFilledDatasetIds, android.view.autofill.AutofillId[] detectedFieldIds, android.service.autofill.FieldClassification[] detectedFieldClassifications) { throw new RuntimeException("Stub!"); }

/**
 * Returns the type of the event.
 *
 * @return The type of the event
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the id of dataset the id was on.
 *
 * @return The id of dataset, or {@code null} the event is not associated with a dataset.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getDatasetId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the client state from the {@link FillResponse} used to generate this event.
 *
 * <p><b>Note: </b>the state is associated with the app that was autofilled in the previous
 * {@link
 * AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal, FillCallback)},
 * which is not necessary the same app being autofilled now.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.Bundle getClientState() { throw new RuntimeException("Stub!"); }

/**
 * Returns which datasets were selected by the user.
 *
 * <p><b>Note: </b>Only set on events of type {@link #TYPE_CONTEXT_COMMITTED}.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.Set<java.lang.String> getSelectedDatasetIds() { throw new RuntimeException("Stub!"); }

/**
 * Returns which datasets were NOT selected by the user.
 *
 * <p><b>Note: </b>Only set on events of type {@link #TYPE_CONTEXT_COMMITTED}.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.Set<java.lang.String> getIgnoredDatasetIds() { throw new RuntimeException("Stub!"); }

/**
 * Returns which fields in the selected datasets were changed by the user after the dataset
 * was selected.
 *
 * <p>For example, server provides:
 *
 * <pre class="prettyprint">
 *  FillResponse response = new FillResponse.Builder()
 *      .addDataset(new Dataset.Builder(presentation1)
 *          .setId("4815")
 *          .setValue(usernameId, AutofillValue.forText("MrPlow"))
 *          .build())
 *      .addDataset(new Dataset.Builder(presentation2)
 *          .setId("162342")
 *          .setValue(passwordId, AutofillValue.forText("D'OH"))
 *          .build())
 *      .build();
 * </pre>
 *
 * <p>User select both datasets (for username and password) but after the fields are
 * autofilled, user changes them to:
 *
 * <pre class="prettyprint">
 *   username = "ElBarto";
 *   password = "AyCaramba";
 * </pre>
 *
 * <p>Then the result is the following map:
 *
 * <pre class="prettyprint">
 *   usernameId => "4815"
 *   passwordId => "162342"
 * </pre>
 *
 * <p><b>Note: </b>Only set on events of type {@link #TYPE_CONTEXT_COMMITTED}.
 *
 * @return map map whose key is the id of the change fields, and value is the id of
 * dataset that has that field and was selected by the user.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.Map<android.view.autofill.AutofillId, java.lang.String> getChangedFields() { throw new RuntimeException("Stub!"); }

/**
 * Gets the <a href="AutofillService.html#FieldClassification">field classification</a>
 * results.
 *
 * <p><b>Note: </b>Only set on events of type {@link #TYPE_CONTEXT_COMMITTED}, when the
 * service requested {@link FillResponse.Builder#setFieldClassificationIds(AutofillId...)
 * field classification}.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.Map<android.view.autofill.AutofillId, android.service.autofill.FieldClassification> getFieldsClassification() { throw new RuntimeException("Stub!"); }

/**
 * Returns which fields were available on datasets provided by the service but manually
 * entered by the user.
 *
 * <p>For example, server provides:
 *
 * <pre class="prettyprint">
 *  FillResponse response = new FillResponse.Builder()
 *      .addDataset(new Dataset.Builder(presentation1)
 *          .setId("4815")
 *          .setValue(usernameId, AutofillValue.forText("MrPlow"))
 *          .setValue(passwordId, AutofillValue.forText("AyCaramba"))
 *          .build())
 *      .addDataset(new Dataset.Builder(presentation2)
 *          .setId("162342")
 *          .setValue(usernameId, AutofillValue.forText("ElBarto"))
 *          .setValue(passwordId, AutofillValue.forText("D'OH"))
 *          .build())
 *      .addDataset(new Dataset.Builder(presentation3)
 *          .setId("108")
 *          .setValue(usernameId, AutofillValue.forText("MrPlow"))
 *          .setValue(passwordId, AutofillValue.forText("D'OH"))
 *          .build())
 *      .build();
 * </pre>
 *
 * <p>User doesn't select a dataset but manually enters:
 *
 * <pre class="prettyprint">
 *   username = "MrPlow";
 *   password = "D'OH";
 * </pre>
 *
 * <p>Then the result is the following map:
 *
 * <pre class="prettyprint">
 *   usernameId => { "4815", "108"}
 *   passwordId => { "162342", "108" }
 * </pre>
 *
 * <p><b>Note: </b>Only set on events of type {@link #TYPE_CONTEXT_COMMITTED}.
 *
 * @return map map whose key is the id of the manually-entered field, and value is the
 * ids of the datasets that have that value but were not selected by the user.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.Map<android.view.autofill.AutofillId, java.util.Set<java.lang.String>> getManuallyEnteredField() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * A {@link FillResponse.Builder#setAuthentication(android.view.autofill.AutofillId[],
 * IntentSender, android.widget.RemoteViews) fill response authentication} was selected.
 */

public static final int TYPE_AUTHENTICATION_SELECTED = 2; // 0x2

/**
 * A committed autofill context for which the autofill service provided datasets.
 *
 * <p>This event is useful to track:
 * <ul>
 *   <li>Which datasets (if any) were selected by the user
 *       ({@link #getSelectedDatasetIds()}).
 *   <li>Which datasets (if any) were NOT selected by the user
 *       ({@link #getIgnoredDatasetIds()}).
 *   <li>Which fields in the selected datasets were changed by the user after the dataset
 *       was selected ({@link #getChangedFields()}.
 *   <li>Which fields match the {@link UserData} set by the service.
 * </ul>
 *
 * <p><b>Note: </b>This event is only generated when:
 * <ul>
 *   <li>The autofill context is committed.
 *   <li>The service provides at least one dataset in the
 *       {@link FillResponse fill responses} associated with the context.
 *   <li>The last {@link FillResponse fill responses} associated with the context has the
 *       {@link FillResponse#FLAG_TRACK_CONTEXT_COMMITED} flag.
 * </ul>
 *
 * <p>See {@link android.view.autofill.AutofillManager} for more information about autofill
 * contexts.
 */

public static final int TYPE_CONTEXT_COMMITTED = 4; // 0x4

/**
 * A {@link Dataset.Builder#setAuthentication(IntentSender) dataset authentication} was
 * selected. The dataset authenticated can be read from {@link #getDatasetId()}.
 */

public static final int TYPE_DATASET_AUTHENTICATION_SELECTED = 1; // 0x1

/**
 * A dataset was selected. The dataset selected can be read from {@link #getDatasetId()}.
 *
 * <p><b>Note: </b>on Android {@link android.os.Build.VERSION_CODES#O}, this event was also
 * incorrectly reported after a
 * {@link Dataset.Builder#setAuthentication(IntentSender) dataset authentication} was
 * selected and the service returned a dataset in the
 * {@link AutofillManager#EXTRA_AUTHENTICATION_RESULT} of the activity launched from that
 * {@link IntentSender}. This behavior was fixed on Android
 * {@link android.os.Build.VERSION_CODES#O_MR1}.
 */

public static final int TYPE_DATASET_SELECTED = 0; // 0x0

/** A save UI was shown. */

public static final int TYPE_SAVE_SHOWN = 3; // 0x3
}

}

