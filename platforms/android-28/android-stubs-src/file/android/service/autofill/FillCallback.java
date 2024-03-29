/*
 * Copyright (C) 2016 The Android Open Source Project
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

import android.app.Activity;

/**
 * Handles autofill requests from the {@link AutofillService} into the {@link Activity} being
 * autofilled.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FillCallback {

FillCallback() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android System that an
 * {@link AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal,
 * FillCallback)} was successfully fulfilled by the service.
 *
 * @param response autofill information for that activity, or {@code null} when the activity
 * cannot be autofilled (for example, if it only contains read-only fields). See
 * {@link FillResponse} for examples.

 * This value may be {@code null}.
 */

public void onSuccess(@androidx.annotation.RecentlyNullable android.service.autofill.FillResponse response) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android System that an
 * {@link AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal,
 * FillCallback)} could not be fulfilled by the service.
 *
 * @param message error message to be displayed to the user.

 * This value may be {@code null}.
 */

public void onFailure(@androidx.annotation.RecentlyNullable java.lang.CharSequence message) { throw new RuntimeException("Stub!"); }
}

