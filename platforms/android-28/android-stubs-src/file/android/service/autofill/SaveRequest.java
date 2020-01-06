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

import android.os.Bundle;

/**
 * This class represents a request to an {@link AutofillService
 * autofill provider} to save applicable data entered by the user.
 *
 * @see AutofillService#onSaveRequest(SaveRequest, SaveCallback)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SaveRequest implements android.os.Parcelable {

SaveRequest(android.os.Parcel parcel) { throw new RuntimeException("Stub!"); }

/**
 * @return The contexts associated with each previous fill request.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<android.service.autofill.FillContext> getFillContexts() { throw new RuntimeException("Stub!"); }

/**
 * Gets the latest client state bundle set by the service in a
 * {@link FillResponse.Builder#setClientState(Bundle) fill response}.
 *
 * <p><b>Note:</b> Prior to Android {@link android.os.Build.VERSION_CODES#P}, only client state
 * bundles set by {@link FillResponse.Builder#setClientState(Bundle)} were considered. On
 * Android {@link android.os.Build.VERSION_CODES#P} and higher, bundles set in the result of
 * an authenticated request through the
 * {@link android.view.autofill.AutofillManager#EXTRA_CLIENT_STATE} extra are
 * also considered (and take precedence when set).
 *
 * @return The client state.

 * This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.Bundle getClientState() { throw new RuntimeException("Stub!"); }

/**
 * Gets the ids of the datasets selected by the user, in the order in which they were selected.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.util.List<java.lang.String> getDatasetIds() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.service.autofill.SaveRequest> CREATOR;
static { CREATOR = null; }
}

