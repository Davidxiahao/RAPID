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


package android.view.textclassifier;

import java.util.Locale;

/**
 * Information about where text selection should be.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TextSelection implements android.os.Parcelable {

TextSelection(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Returns the start index of the text selection.
 */

public int getSelectionStartIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns the end index of the text selection.
 */

public int getSelectionEndIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of entities found in the classified text.

 * @return Value is 0 or greater
 */

public int getEntityCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the entity at the specified index. Entities are ordered from high confidence
 * to low confidence.
 *
 * @throws IndexOutOfBoundsException if the specified index is out of range.
 * @see #getEntityCount() for the number of entities available.
 
 * @return This value will never be {@code null}.

 * Value is {@link android.view.textclassifier.TextClassifier#TYPE_UNKNOWN}, {@link android.view.textclassifier.TextClassifier#TYPE_OTHER}, {@link android.view.textclassifier.TextClassifier#TYPE_EMAIL}, {@link android.view.textclassifier.TextClassifier#TYPE_PHONE}, {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS}, {@link android.view.textclassifier.TextClassifier#TYPE_URL}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE_TIME}, or {@link android.view.textclassifier.TextClassifier#TYPE_FLIGHT_NUMBER}
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getEntity(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the confidence score for the specified entity. The value ranges from
 * 0 (low confidence) to 1 (high confidence). 0 indicates that the entity was not found for the
 * classified text.
 
 * @param entity Value is {@link android.view.textclassifier.TextClassifier#TYPE_UNKNOWN}, {@link android.view.textclassifier.TextClassifier#TYPE_OTHER}, {@link android.view.textclassifier.TextClassifier#TYPE_EMAIL}, {@link android.view.textclassifier.TextClassifier#TYPE_PHONE}, {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS}, {@link android.view.textclassifier.TextClassifier#TYPE_URL}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE_TIME}, or {@link android.view.textclassifier.TextClassifier#TYPE_FLIGHT_NUMBER}
 * @return Value is between 0.0 and 1.0 inclusive
 */

public float getConfidenceScore(java.lang.String entity) { throw new RuntimeException("Stub!"); }

/**
 * Returns the id, if one exists, for this object.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getId() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.view.textclassifier.TextSelection> CREATOR;
static { CREATOR = null; }
/**
 * Builder used to build {@link TextSelection} objects.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a builder used to build {@link TextSelection} objects.
 *
 * @param startIndex the start index of the text selection.
 * Value is 0 or greater
 * @param endIndex the end index of the text selection. Must be greater than startIndex

 * Value is 0 or greater
 */

public Builder(int startIndex, int endIndex) { throw new RuntimeException("Stub!"); }

/**
 * Sets an entity type for the classified text and assigns a confidence score.
 *
 * @param confidenceScore a value from 0 (low confidence) to 1 (high confidence).
 *      0 implies the entity does not exist for the classified text.
 *      Values greater than 1 are clamped to 1.
 
 * Value is between 0.0 and 1.0 inclusive
 * @param type This value must never be {@code null}.
 * Value is {@link android.view.textclassifier.TextClassifier#TYPE_UNKNOWN}, {@link android.view.textclassifier.TextClassifier#TYPE_OTHER}, {@link android.view.textclassifier.TextClassifier#TYPE_EMAIL}, {@link android.view.textclassifier.TextClassifier#TYPE_PHONE}, {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS}, {@link android.view.textclassifier.TextClassifier#TYPE_URL}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE_TIME}, or {@link android.view.textclassifier.TextClassifier#TYPE_FLIGHT_NUMBER}
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.view.textclassifier.TextSelection.Builder setEntityType(@androidx.annotation.RecentlyNonNull java.lang.String type, float confidenceScore) { throw new RuntimeException("Stub!"); }

/**
 * Sets an id for the TextSelection object.
 
 * @param id This value may be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.view.textclassifier.TextSelection.Builder setId(@androidx.annotation.RecentlyNullable java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns {@link TextSelection} object.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.view.textclassifier.TextSelection build() { throw new RuntimeException("Stub!"); }
}

/**
 * A request object for generating TextSelection.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Request implements android.os.Parcelable {

Request(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Returns the text providing context for the selected text (which is specified by the
 * sub sequence starting at startIndex and ending at endIndex).

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * Returns start index of the selected part of text.

 * @return Value is 0 or greater
 */

public int getStartIndex() { throw new RuntimeException("Stub!"); }

/**
 * Returns end index of the selected part of text.

 * @return Value is 0 or greater
 */

public int getEndIndex() { throw new RuntimeException("Stub!"); }

/**
 * @return ordered list of locale preferences that can be used to disambiguate the
 * provided text.

 * This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.LocaleList getDefaultLocales() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.view.textclassifier.TextSelection.Request> CREATOR;
static { CREATOR = null; }
/**
 * A builder for building TextSelection requests.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * @param text text providing context for the selected text (which is specified by the
 *      sub sequence starting at selectionStartIndex and ending at selectionEndIndex)
 * This value must never be {@code null}.
 * @param startIndex start index of the selected part of text
 * Value is 0 or greater
 * @param endIndex end index of the selected part of text

 * Value is 0 or greater
 */

public Builder(@androidx.annotation.RecentlyNonNull java.lang.CharSequence text, int startIndex, int endIndex) { throw new RuntimeException("Stub!"); }

/**
 * @param defaultLocales ordered list of locale preferences that may be used to
 *      disambiguate the provided text. If no locale preferences exist, set this to null
 *      or an empty locale list.
 *
 * This value may be {@code null}.
 * @return this builder.
 */

@androidx.annotation.RecentlyNonNull public android.view.textclassifier.TextSelection.Request.Builder setDefaultLocales(@androidx.annotation.RecentlyNullable android.os.LocaleList defaultLocales) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns the request object.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.view.textclassifier.TextSelection.Request build() { throw new RuntimeException("Stub!"); }
}

}

}

