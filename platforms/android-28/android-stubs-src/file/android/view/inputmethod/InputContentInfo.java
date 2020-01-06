/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.view.inputmethod;

import android.net.Uri;
import android.content.ClipDescription;
import java.security.InvalidParameterException;
import android.os.Parcel;
import android.content.ContentProvider;

/**
 * A container object with which input methods can send content files to the target application.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class InputContentInfo implements android.os.Parcelable {

/**
 * Constructs {@link InputContentInfo} object only with mandatory data.
 *
 * @param contentUri Content URI to be exported from the input method.
 * This cannot be {@code null}.
 * This value must never be {@code null}.
 * @param description A {@link ClipDescription} object that contains the metadata of
 * {@code contentUri} such as MIME type(s). This object cannot be {@code null}. Also
 * {@link ClipDescription#getLabel()} should be describing the content specified by
 * {@code contentUri} for accessibility reasons.

 * This value must never be {@code null}.
 */

public InputContentInfo(@androidx.annotation.RecentlyNonNull android.net.Uri contentUri, @androidx.annotation.RecentlyNonNull android.content.ClipDescription description) { throw new RuntimeException("Stub!"); }

/**
 * Constructs {@link InputContentInfo} object with additional link URI.
 *
 * @param contentUri Content URI to be exported from the input method.
 * This cannot be {@code null}.
 * This value must never be {@code null}.
 * @param description A {@link ClipDescription} object that contains the metadata of
 * {@code contentUri} such as MIME type(s). This object cannot be {@code null}. Also
 * {@link ClipDescription#getLabel()} should be describing the content specified by
 * {@code contentUri} for accessibility reasons.
 * This value must never be {@code null}.
 * @param linkUri An optional {@code http} or {@code https} URI. The editor author may provide
 * a way to navigate the user to the specified web page if this is not {@code null}.
 * This value may be {@code null}.
 * @throws InvalidParameterException if any invalid parameter is specified.
 */

public InputContentInfo(@androidx.annotation.RecentlyNonNull android.net.Uri contentUri, @androidx.annotation.RecentlyNonNull android.content.ClipDescription description, @androidx.annotation.RecentlyNullable android.net.Uri linkUri) { throw new RuntimeException("Stub!"); }

/**
 * @return Content URI with which the content can be obtained.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.net.Uri getContentUri() { throw new RuntimeException("Stub!"); }

/**
 * @return {@link ClipDescription} object that contains the metadata of {@code #getContentUri()}
 * such as MIME type(s). {@link ClipDescription#getLabel()} can be used for accessibility
 * purpose.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.content.ClipDescription getDescription() { throw new RuntimeException("Stub!"); }

/**
 * @return An optional {@code http} or {@code https} URI that is related to this content.

 * This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.net.Uri getLinkUri() { throw new RuntimeException("Stub!"); }

/**
 * Requests a temporary read-only access permission for content URI associated with this object.
 *
 * <p>Does nothing if the temporary permission is already granted.</p>
 */

public void requestPermission() { throw new RuntimeException("Stub!"); }

/**
 * Releases a temporary read-only access permission for content URI associated with this object.
 *
 * <p>Does nothing if the temporary permission is not granted.</p>
 */

public void releasePermission() { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link Parcel}.
 *
 * @param dest The {@link Parcel} to be written.
 * @param flags The flags used for parceling.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 */

public static final android.os.Parcelable.Creator<android.view.inputmethod.InputContentInfo> CREATOR;
static { CREATOR = null; }
}

