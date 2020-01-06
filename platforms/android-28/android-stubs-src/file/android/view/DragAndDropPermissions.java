/*
** Copyright 2015, The Android Open Source Project
**
** Licensed under the Apache License, Version 2.0 (the "License");
** you may not use this file except in compliance with the License.
** You may obtain a copy of the License at
**
**     http://www.apache.org/licenses/LICENSE-2.0
**
** Unless required by applicable law or agreed to in writing, software
** distributed under the License is distributed on an "AS IS" BASIS,
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
** See the License for the specific language governing permissions and
** limitations under the License.
*/


package android.view;

import android.app.Activity;
import android.os.Binder;

/**
 * {@link DragAndDropPermissions} controls the access permissions for the content URIs associated
 * with a {@link DragEvent}.
 * <p>
 * Permission are granted when this object is created by {@link
 * android.app.Activity#requestDragAndDropPermissions(DragEvent)
 * Activity.requestDragAndDropPermissions}.
 * Which permissions are granted is defined by the set of flags passed to {@link
 * View#startDragAndDrop(android.content.ClipData, View.DragShadowBuilder, Object, int)
 * View.startDragAndDrop} by the app that started the drag operation.
 * </p>
 * <p>
 * The life cycle of the permissions is bound to the activity used to call {@link
 * android.app.Activity#requestDragAndDropPermissions(DragEvent) requestDragAndDropPermissions}. The
 * permissions are revoked when this activity is destroyed, or when {@link #release()} is called,
 * whichever occurs first.
 * </p>
 * <p>
 * If you anticipate that your application will receive a large number of drops (e.g. document
 * editor), you should try to call {@link #release()} on the obtained permissions as soon as they
 * are no longer required. Permissions can be added to your activity's
 * {@link Activity#onSaveInstanceState} bundle and later retrieved in order to manually release
 * the permissions once they are no longer needed.
 * </p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DragAndDropPermissions implements android.os.Parcelable {

DragAndDropPermissions(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Revoke permissions explicitly.
 */

public void release() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel destination, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.view.DragAndDropPermissions> CREATOR;
static { CREATOR = null; }
}

