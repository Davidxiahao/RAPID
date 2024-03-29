/*
 * Copyright 2017 The Android Open Source Project
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


package android.app.slice;

import android.net.Uri;

/**
 * Class describing the structure of the data contained within a slice.
 * <p>
 * A data version contains a string which describes the type of structure
 * and a revision which denotes this specific implementation. Revisions are expected
 * to be backwards compatible and monotonically increasing. Meaning if a
 * SliceSpec has the same type and an equal or lesser revision,
 * it is expected to be compatible.
 * <p>
 * Apps rendering slices will provide a list of supported versions to the OS which
 * will also be given to the app. Apps should only return a {@link Slice} with a
 * {@link SliceSpec} that one of the supported {@link SliceSpec}s provided
 * {@link #canRender}.
 *
 * @see Slice
 * @see SliceProvider#onBindSlice(Uri)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SliceSpec implements android.os.Parcelable {

/**
 * @param type This value must never be {@code null}.
 */

public SliceSpec(@androidx.annotation.RecentlyNonNull java.lang.String type, int revision) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Gets the type of the version.
 */

public java.lang.String getType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the revision of the version.
 */

public int getRevision() { throw new RuntimeException("Stub!"); }

/**
 * Indicates that this spec can be used to render the specified spec.
 * <p>
 * Rendering support is not bi-directional (e.g. Spec v3 can render
 * Spec v2, but Spec v2 cannot render Spec v3).
 *
 * @param candidate candidate format of data.
 * This value must never be {@code null}.
 * @return true if versions are compatible.
 * @see androidx.slice.widget.SliceView
 */

public boolean canRender(@androidx.annotation.RecentlyNonNull android.app.slice.SliceSpec candidate) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.slice.SliceSpec> CREATOR;
static { CREATOR = null; }
}

