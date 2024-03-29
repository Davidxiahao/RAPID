/*
 * Copyright (C) 2009 The Android Open Source Project
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


package android.text;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A special kind of Parcelable for objects that will serve as text spans.
 * This can only be used by code in the framework; it is not intended for
 * applications to implement their own Parcelable spans.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface ParcelableSpan extends android.os.Parcelable {

/**
 * Return a special type identifier for this span class.
 */

public int getSpanTypeId();
}

