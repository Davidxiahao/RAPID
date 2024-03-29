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
import android.content.Context;
import java.util.Locale;

/**
 * Holds suggestion candidates for the text enclosed in this span.
 *
 * When such a span is edited in an EditText, double tapping on the text enclosed in this span will
 * display a popup dialog listing suggestion replacement for that text. The user can then replace
 * the original text by one of the suggestions.
 *
 * These spans should typically be created by the input method to provide correction and alternates
 * for the text.
 *
 * @see TextView#isSuggestionsEnabled()
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SuggestionSpan extends android.text.style.CharacterStyle implements android.text.ParcelableSpan {

/**
 * @param context Context for the application
 * @param suggestions Suggestions for the string under the span
 * @param flags Additional flags indicating how this span is handled in TextView
 */

public SuggestionSpan(android.content.Context context, java.lang.String[] suggestions, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @param locale Locale of the suggestions
 * @param suggestions Suggestions for the string under the span
 * @param flags Additional flags indicating how this span is handled in TextView
 */

public SuggestionSpan(java.util.Locale locale, java.lang.String[] suggestions, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @param context Context for the application
 * @param locale locale Locale of the suggestions
 * @param suggestions Suggestions for the string under the span. Only the first up to
 * {@link SuggestionSpan#SUGGESTIONS_MAX_SIZE} will be considered. Null values not permitted.
 * @param flags Additional flags indicating how this span is handled in TextView
 * @param notificationTargetClass if not null, this class will get notified when the user
 * selects one of the suggestions.
 */

public SuggestionSpan(android.content.Context context, java.util.Locale locale, java.lang.String[] suggestions, int flags, java.lang.Class<?> notificationTargetClass) { throw new RuntimeException("Stub!"); }

public SuggestionSpan(android.os.Parcel src) { throw new RuntimeException("Stub!"); }

/**
 * @return an array of suggestion texts for this span
 */

public java.lang.String[] getSuggestions() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated use {@link #getLocaleObject()} instead.
 * @return the locale of the suggestions. An empty string is returned if no locale is specified.

 * This value will never be {@code null}.
 */

@Deprecated @androidx.annotation.RecentlyNonNull public java.lang.String getLocale() { throw new RuntimeException("Stub!"); }

/**
 * Returns a well-formed BCP 47 language tag representation of the suggestions, as a
 * {@link Locale} object.
 *
 * <p><b>Caveat</b>: The returned object is guaranteed to be a  a well-formed BCP 47 language tag
 * representation.  For example, this method can return an empty locale rather than returning a
 * malformed data when this object is initialized with an malformed {@link Locale} object, e.g.
 * {@code new Locale(" a ", " b c d ", " "}.</p>
 *
 * @return the locale of the suggestions. {@code null} is returned if no locale is specified.
 */

@androidx.annotation.RecentlyNullable public java.util.Locale getLocaleObject() { throw new RuntimeException("Stub!"); }

public int getFlags() { throw new RuntimeException("Stub!"); }

public void setFlags(int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public void updateDrawState(android.text.TextPaint tp) { throw new RuntimeException("Stub!"); }

public static final java.lang.String ACTION_SUGGESTION_PICKED = "android.text.style.SUGGESTION_PICKED";

public static final android.os.Parcelable.Creator<android.text.style.SuggestionSpan> CREATOR;
static { CREATOR = null; }

/**
 * Sets this flag if the auto correction is about to be applied to a word/text
 * that the user is typing/composing. This type of suggestion is rendered differently
 * to indicate the auto correction is happening.
 */

public static final int FLAG_AUTO_CORRECTION = 4; // 0x4

/**
 * Sets this flag if the suggestions should be easily accessible with few interactions.
 * This flag should be set for every suggestions that the user is likely to use.
 */

public static final int FLAG_EASY_CORRECT = 1; // 0x1

/**
 * Sets this flag if the suggestions apply to a misspelled word/text. This type of suggestion is
 * rendered differently to highlight the error.
 */

public static final int FLAG_MISSPELLED = 2; // 0x2

public static final int SUGGESTIONS_MAX_SIZE = 5; // 0x5

public static final java.lang.String SUGGESTION_SPAN_PICKED_AFTER = "after";

public static final java.lang.String SUGGESTION_SPAN_PICKED_BEFORE = "before";

public static final java.lang.String SUGGESTION_SPAN_PICKED_HASHCODE = "hashcode";
}

