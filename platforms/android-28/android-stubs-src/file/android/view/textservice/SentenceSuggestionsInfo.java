/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.view.textservice;

import android.os.Parcel;

/**
 * This class contains a metadata of suggestions returned from a text service
 * (e.g.&nbsp;{@link android.service.textservice.SpellCheckerService}).
 * The text service uses this class to return the suggestions
 * for a sentence. See {@link SuggestionsInfo} which is used for suggestions for a word.
 * This class extends the functionality of {@link SuggestionsInfo} as far as this class enables
 * you to put multiple {@link SuggestionsInfo}s on a sentence with the offsets and the lengths
 * of all {@link SuggestionsInfo}s.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SentenceSuggestionsInfo implements android.os.Parcelable {

/**
 * Constructor.
 * @param suggestionsInfos from the text service
 * @param offsets the array of offsets of suggestions
 * @param lengths the array of lengths of suggestions
 */

public SentenceSuggestionsInfo(android.view.textservice.SuggestionsInfo[] suggestionsInfos, int[] offsets, int[] lengths) { throw new RuntimeException("Stub!"); }

public SentenceSuggestionsInfo(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link Parcel}.
 *
 * @param dest The {@link Parcel} to be written.
 * @param flags The flags used for parceling.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @return the count of {@link SuggestionsInfo}s this instance holds.
 */

public int getSuggestionsCount() { throw new RuntimeException("Stub!"); }

/**
 * @param i the id of {@link SuggestionsInfo}s this instance holds.
 * @return a {@link SuggestionsInfo} at the specified id
 */

public android.view.textservice.SuggestionsInfo getSuggestionsInfoAt(int i) { throw new RuntimeException("Stub!"); }

/**
 * @param i the id of {@link SuggestionsInfo}s this instance holds
 * @return the offset of the specified {@link SuggestionsInfo}
 */

public int getOffsetAt(int i) { throw new RuntimeException("Stub!"); }

/**
 * @param i the id of {@link SuggestionsInfo}s this instance holds
 * @return the length of the specified {@link SuggestionsInfo}
 */

public int getLengthAt(int i) { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 */

public static final android.os.Parcelable.Creator<android.view.textservice.SentenceSuggestionsInfo> CREATOR;
static { CREATOR = null; }
}

