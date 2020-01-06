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

import android.widget.RemoteViews;

/**
 * Defines actions to be applied to a {@link RemoteViews template presentation}.
 *
 *
 * <p>It supports 2 types of actions:
 *
 * <ol>
 *   <li>{@link RemoteViews Actions} to be applied to the template.
 *   <li>{@link Transformation Transformations} to be applied on child views.
 * </ol>
 *
 * <p>Typically used on {@link CustomDescription custom descriptions} to conditionally display
 * differents views based on user input - see
 * {@link CustomDescription.Builder#batchUpdate(Validator, BatchUpdates)} for more information.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class BatchUpdates implements android.os.Parcelable {

BatchUpdates(android.service.autofill.BatchUpdates.Builder builder) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.service.autofill.BatchUpdates> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link BatchUpdates} objects.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Applies the {@code updates} in the underlying presentation template.
 *
 * <p><b>Note:</b> The updates are applied before the
 * {@link #transformChild(int, Transformation) transformations} are applied to the children
 * views.
 *
 * <p>Theme does not work with RemoteViews layout. Avoid hardcoded text color
 * or background color: Autofill on different platforms may have different themes.
 *
 * @param updates a {@link RemoteViews} with the updated actions to be applied in the
 * underlying presentation template.
 *
 * This value must never be {@code null}.
 * @return this builder
 * @throws IllegalArgumentException if {@code condition} is not a class provided
 * by the Android System.
 */

public android.service.autofill.BatchUpdates.Builder updateTemplate(@androidx.annotation.RecentlyNonNull android.widget.RemoteViews updates) { throw new RuntimeException("Stub!"); }

/**
 * Adds a transformation to replace the value of a child view with the fields in the
 * screen.
 *
 * <p>When multiple transformations are added for the same child view, they are applied
 * in the same order as added.
 *
 * <p><b>Note:</b> The transformations are applied after the
 * {@link #updateTemplate(RemoteViews) updates} are applied to the presentation template.
 *
 * @param id view id of the children view.
 * @param transformation an implementation provided by the Android System.
 * This value must never be {@code null}.
 * @return this builder.
 * @throws IllegalArgumentException if {@code transformation} is not a class provided
 * by the Android System.
 */

public android.service.autofill.BatchUpdates.Builder transformChild(int id, @androidx.annotation.RecentlyNonNull android.service.autofill.Transformation transformation) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link BatchUpdates} instance.
 *
 * @throws IllegalStateException if {@link #build()} was already called before or no call
 * to {@link #updateTemplate(RemoteViews)} or {@link #transformChild(int, Transformation)}
 * has been made.
 */

public android.service.autofill.BatchUpdates build() { throw new RuntimeException("Stub!"); }
}

}

