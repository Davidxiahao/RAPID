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
import android.view.View;

/**
 * This class represents a request to an autofill service
 * to interpret the screen and provide information to the system which views are
 * interesting for saving and what are the possible ways to fill the inputs on
 * the screen if applicable.
 *
 * @see AutofillService#onFillRequest(FillRequest, android.os.CancellationSignal, FillCallback)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FillRequest implements android.os.Parcelable {

FillRequest(android.os.Parcel parcel) { throw new RuntimeException("Stub!"); }

/**
 * Gets the unique id of this request.
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the flags associated with this request.
 *
 * @see #FLAG_MANUAL_REQUEST

 * @return Value is either <code>0</code> or {@link android.service.autofill.FillRequest#FLAG_MANUAL_REQUEST}
 */

public int getFlags() { throw new RuntimeException("Stub!"); }

/**
 * Gets the contexts associated with each previous fill request.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<android.service.autofill.FillContext> getFillContexts() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

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

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.service.autofill.FillRequest> CREATOR;
static { CREATOR = null; }

/**
 * Indicates autofill was explicitly requested by the user.
 *
 * <p>Users typically make an explicit request to autofill a screen in two situations:
 * <ul>
 *   <li>The app disabled autofill (using {@link View#setImportantForAutofill(int)}.
 *   <li>The service could not figure out how to autofill a screen (but the user knows the
 *       service has data for that app).
 * </ul>
 *
 * <p>This flag is particularly useful for the second case. For example, the service could offer
 * a complex UI where the user can map which screen views belong to each user data, or it could
 * offer a simpler UI where the user picks the data for just the view used to trigger the
 * request (that would be the view whose
 * {@link android.app.assist.AssistStructure.ViewNode#isFocused()} method returns {@code true}).
 *
 * <p>An explicit autofill request is triggered when the
 * {@link android.view.autofill.AutofillManager#requestAutofill(View)} or
 * {@link android.view.autofill.AutofillManager#requestAutofill(View, int, android.graphics.Rect)}
 * is called. For example, standard {@link android.widget.TextView} views show an
 * {@code AUTOFILL} option in the overflow menu that triggers such request.
 */

public static final int FLAG_MANUAL_REQUEST = 1; // 0x1
}

