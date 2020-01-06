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

package android.media;

import android.media.MediaDrm;
import java.util.UUID;

/**
 * Encapsulates initialization data required by a {@link MediaDrm} instance.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class DrmInitData {

/**
 * Prevent public constuctor access
 */

DrmInitData() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves initialization data for a given DRM scheme, specified by its UUID.
 *
 * @param schemeUuid The DRM scheme's UUID.
 * @return The initialization data for the scheme, or null if the scheme is not supported.
 */

public abstract android.media.DrmInitData.SchemeInitData get(java.util.UUID schemeUuid);
/**
 * Scheme initialization data.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class SchemeInitData {

/**
 * @param mimeType The mimeType of the initialization data.
 * @param data The initialization data.
 *
 * @hide
 */

SchemeInitData(java.lang.String mimeType, byte[] data) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * The initialization data.
 */

public final byte[] data;
{ data = new byte[0]; }

/**
 * The mimeType of {@link #data}.
 */

public final java.lang.String mimeType;
{ mimeType = null; }
}

}

