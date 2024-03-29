/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.text.style;

import android.widget.TextView;
import android.text.TextUtils;
import android.app.PendingIntent;

/**
 * Provides an easy way to edit a portion of text.
 * <p>
 * The {@link TextView} uses this span to allow the user to delete a chuck of text in one click.
 * <p>
 * {@link TextView} removes the span when the user deletes the whole text or modifies it.
 * <p>
 * This span can be also used to receive notification when the user deletes or modifies the text;
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EasyEditSpan implements android.text.ParcelableSpan {

/**
 * Creates the span. No intent is sent when the wrapped text is modified or
 * deleted.
 */

public EasyEditSpan() { throw new RuntimeException("Stub!"); }

/**
 * @param pendingIntent The intent will be sent when the wrapped text is deleted or modified.
 *                      When the pending intent is sent, {@link #EXTRA_TEXT_CHANGED_TYPE} is
 *                      added in the intent to describe how the text changed.
 */

public EasyEditSpan(android.app.PendingIntent pendingIntent) { throw new RuntimeException("Stub!"); }

/**
 * Constructor called from {@link TextUtils} to restore the span.

 * @param source This value must never be {@code null}.
 */

public EasyEditSpan(@androidx.annotation.RecentlyNonNull android.os.Parcel source) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @param dest This value must never be {@code null}.
 */

public void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

/**
 * The extra key field in the pending intent that describes how the text changed.
 *
 * @see #TEXT_DELETED
 * @see #TEXT_MODIFIED
 * @see #getPendingIntent()
 */

public static final java.lang.String EXTRA_TEXT_CHANGED_TYPE = "android.text.style.EXTRA_TEXT_CHANGED_TYPE";

/**
 * The value of {@link #EXTRA_TEXT_CHANGED_TYPE} when the text wrapped by this span is deleted.
 */

public static final int TEXT_DELETED = 1; // 0x1

/**
 * The value of {@link #EXTRA_TEXT_CHANGED_TYPE} when the text wrapped by this span is modified.
 */

public static final int TEXT_MODIFIED = 2; // 0x2
}

