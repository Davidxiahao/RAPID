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
import android.content.IntentSender;

/**
 * Handles save requests from the {@link AutofillService} into the {@link Activity} being
 * autofilled.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SaveCallback {

SaveCallback() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android System that an
 * {@link AutofillService#onSaveRequest(SaveRequest, SaveCallback)} was successfully handled
 * by the service.
 */

public void onSuccess() { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android System that an
 * {@link AutofillService#onSaveRequest(SaveRequest, SaveCallback)} was successfully handled
 * by the service.
 *
 * <p>This method is useful when the service requires extra work&mdash;for example, launching an
 * activity asking the user to authenticate first &mdash;before it can process the request,
 * as the intent will be launched from the context of the activity being autofilled and hence
 * will be part of that activity's stack.
 *
 * @param intentSender intent that will be launched from the context of activity being
 * autofilled.

 * This value must never be {@code null}.
 */

public void onSuccess(@androidx.annotation.RecentlyNonNull android.content.IntentSender intentSender) { throw new RuntimeException("Stub!"); }

/**
 * Notifies the Android System that an
 * {@link AutofillService#onSaveRequest(SaveRequest, SaveCallback)} could not be handled
 * by the service.
 *
 * <p>This method should only be called when the service could not handle the request right away
 * and could not recover or retry it. If the service could retry or recover, it could keep
 * the {@link SaveRequest} and call {@link #onSuccess()} instead.
 *
 * <p><b>Note:</b> The Android System displays an UI with the supplied error message; if
 * you prefer to show your own message, call {@link #onSuccess()} or
 * {@link #onSuccess(IntentSender)} instead.
 *
 * @param message error message to be displayed to the user.
 */

public void onFailure(java.lang.CharSequence message) { throw new RuntimeException("Stub!"); }
}

