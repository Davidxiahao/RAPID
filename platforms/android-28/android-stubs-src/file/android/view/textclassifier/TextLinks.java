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


package android.view.textclassifier;

import java.util.Collection;
import android.view.View;
import android.text.method.MovementMethod;
import android.widget.TextView;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import java.util.Locale;
import java.util.Map;

/**
 * A collection of links, representing subsequences of text and the entity types (phone number,
 * address, url, etc) they may be.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TextLinks implements android.os.Parcelable {

TextLinks(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Returns an unmodifiable Collection of the links.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.Collection<android.view.textclassifier.TextLinks.TextLink> getLinks() { throw new RuntimeException("Stub!"); }

/**
 * Annotates the given text with the generated links. It will fail if the provided text doesn't
 * match the original text used to create the TextLinks.
 *
 * <p><strong>NOTE: </strong>It may be necessary to set a LinkMovementMethod on the TextView
 * widget to properly handle links. See {@link TextView#setMovementMethod(MovementMethod)}
 *
 * @param text the text to apply the links to. Must match the original text
 * This value must never be {@code null}.
 * @param applyStrategy the apply strategy used to determine how to apply links to text.
 *      e.g {@link TextLinks#APPLY_STRATEGY_IGNORE}
 * Value is {@link android.view.textclassifier.TextLinks#APPLY_STRATEGY_IGNORE}, or {@link android.view.textclassifier.TextLinks#APPLY_STRATEGY_REPLACE}
 * @param spanFactory a custom span factory for converting TextLinks to TextLinkSpans.
 *      Set to {@code null} to use the default span factory.
 *
 * This value may be {@code null}.
 * @return a status code indicating whether or not the links were successfully applied
 *      e.g. {@link #STATUS_LINKS_APPLIED}
 
 * Value is {@link android.view.textclassifier.TextLinks#STATUS_LINKS_APPLIED}, {@link android.view.textclassifier.TextLinks#STATUS_NO_LINKS_FOUND}, {@link android.view.textclassifier.TextLinks#STATUS_NO_LINKS_APPLIED}, or {@link android.view.textclassifier.TextLinks#STATUS_DIFFERENT_TEXT}
 */

public int apply(@androidx.annotation.RecentlyNonNull android.text.Spannable text, int applyStrategy, @androidx.annotation.RecentlyNullable java.util.function.Function<android.view.textclassifier.TextLinks.TextLink, android.view.textclassifier.TextLinks.TextLinkSpan> spanFactory) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Do not replace {@link ClickableSpan}s that exist where the {@link TextLinkSpan} needs to
 * be applied to. Do not apply the TextLinkSpan.
 */

public static final int APPLY_STRATEGY_IGNORE = 0; // 0x0

/**
 * Replace any {@link ClickableSpan}s that exist where the {@link TextLinkSpan} needs to be
 * applied to.
 */

public static final int APPLY_STRATEGY_REPLACE = 1; // 0x1

public static final android.os.Parcelable.Creator<android.view.textclassifier.TextLinks> CREATOR;
static { CREATOR = null; }

/** The specified text does not match the text used to generate the links. */

public static final int STATUS_DIFFERENT_TEXT = 3; // 0x3

/** Links were successfully applied to the text. */

public static final int STATUS_LINKS_APPLIED = 0; // 0x0

/** No links applied to text. The links were filtered out. */

public static final int STATUS_NO_LINKS_APPLIED = 2; // 0x2

/** No links exist to apply to text. Links count is zero. */

public static final int STATUS_NO_LINKS_FOUND = 1; // 0x1
/**
 * A builder to construct a TextLinks instance.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Create a new TextLinks.Builder.
 *
 * @param fullText The full text to annotate with links

 * This value must never be {@code null}.
 */

public Builder(@androidx.annotation.RecentlyNonNull java.lang.String fullText) { throw new RuntimeException("Stub!"); }

/**
 * Adds a TextLink.
 *
 * @param start The start index of the identified subsequence
 * @param end The end index of the identified subsequence
 * @param entityScores A mapping of entity type to confidence score
 *
 * @throws IllegalArgumentException if entityScores is null or empty.
 */

@androidx.annotation.RecentlyNonNull public android.view.textclassifier.TextLinks.Builder addLink(int start, int end, java.util.Map<java.lang.String, java.lang.Float> entityScores) { throw new RuntimeException("Stub!"); }

/**
 * Removes all {@link TextLink}s.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.view.textclassifier.TextLinks.Builder clearTextLinks() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a TextLinks instance.
 *
 * @return the constructed TextLinks

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.view.textclassifier.TextLinks build() { throw new RuntimeException("Stub!"); }
}

/**
 * A request object for generating TextLinks.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Request implements android.os.Parcelable {

Request(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Returns the text to generate links for.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * @return ordered list of locale preferences that can be used to disambiguate
 *      the provided text

 * This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.LocaleList getDefaultLocales() { throw new RuntimeException("Stub!"); }

/**
 * @return The config representing the set of entities to look for
 * This value may be {@code null}.
 * @see Builder#setEntityConfig(TextClassifier.EntityConfig)
 */

@androidx.annotation.RecentlyNullable public android.view.textclassifier.TextClassifier.EntityConfig getEntityConfig() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.view.textclassifier.TextLinks.Request> CREATOR;
static { CREATOR = null; }
/**
 * A builder for building TextLinks requests.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * @param text This value must never be {@code null}.
 */

public Builder(@androidx.annotation.RecentlyNonNull java.lang.CharSequence text) { throw new RuntimeException("Stub!"); }

/**
 * @param defaultLocales ordered list of locale preferences that may be used to
 *                       disambiguate the provided text. If no locale preferences exist,
 *                       set this to null or an empty locale list.
 * This value may be {@code null}.
 * @return this builder
 */

@androidx.annotation.RecentlyNonNull public android.view.textclassifier.TextLinks.Request.Builder setDefaultLocales(@androidx.annotation.RecentlyNullable android.os.LocaleList defaultLocales) { throw new RuntimeException("Stub!"); }

/**
 * Sets the entity configuration to use. This determines what types of entities the
 * TextClassifier will look for.
 * Set to {@code null} for the default entity config and teh TextClassifier will
 * automatically determine what links to generate.
 *
 * @param entityConfig This value may be {@code null}.
 * @return this builder
 */

@androidx.annotation.RecentlyNonNull public android.view.textclassifier.TextLinks.Request.Builder setEntityConfig(@androidx.annotation.RecentlyNullable android.view.textclassifier.TextClassifier.EntityConfig entityConfig) { throw new RuntimeException("Stub!"); }

/**
 * Builds and returns the request object.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.view.textclassifier.TextLinks.Request build() { throw new RuntimeException("Stub!"); }
}

}

/**
 * A link, identifying a substring of text and possible entity types for it.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class TextLink implements android.os.Parcelable {

TextLink(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Returns the start index of this link in the original text.
 *
 * @return the start index
 */

public int getStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns the end index of this link in the original text.
 *
 * @return the end index
 */

public int getEnd() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of entity types that have confidence scores.
 *
 * @return the entity count
 */

public int getEntityCount() { throw new RuntimeException("Stub!"); }

/**
 * Returns the entity type at a given index. Entity types are sorted by confidence.
 *
 * @return the entity type at the provided index
 
 * This value will never be {@code null}.

 * Value is {@link android.view.textclassifier.TextClassifier#TYPE_UNKNOWN}, {@link android.view.textclassifier.TextClassifier#TYPE_OTHER}, {@link android.view.textclassifier.TextClassifier#TYPE_EMAIL}, {@link android.view.textclassifier.TextClassifier#TYPE_PHONE}, {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS}, {@link android.view.textclassifier.TextClassifier#TYPE_URL}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE_TIME}, or {@link android.view.textclassifier.TextClassifier#TYPE_FLIGHT_NUMBER}
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getEntity(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the confidence score for a particular entity type.
 *
 * @param entityType the entity type
 
 * Value is {@link android.view.textclassifier.TextClassifier#TYPE_UNKNOWN}, {@link android.view.textclassifier.TextClassifier#TYPE_OTHER}, {@link android.view.textclassifier.TextClassifier#TYPE_EMAIL}, {@link android.view.textclassifier.TextClassifier#TYPE_PHONE}, {@link android.view.textclassifier.TextClassifier#TYPE_ADDRESS}, {@link android.view.textclassifier.TextClassifier#TYPE_URL}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE}, {@link android.view.textclassifier.TextClassifier#TYPE_DATE_TIME}, or {@link android.view.textclassifier.TextClassifier#TYPE_FLIGHT_NUMBER}
 * @return Value is between 0.0 and 1.0 inclusive
 */

public float getConfidenceScore(java.lang.String entityType) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.view.textclassifier.TextLinks.TextLink> CREATOR;
static { CREATOR = null; }
}

/**
 * A ClickableSpan for a TextLink.
 *
 * <p>Applies only to TextViews.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class TextLinkSpan extends android.text.style.ClickableSpan {

/**
 * @param textLink This value must never be {@code null}.
 */

public TextLinkSpan(@androidx.annotation.RecentlyNonNull android.view.textclassifier.TextLinks.TextLink textLink) { throw new RuntimeException("Stub!"); }

public void onClick(android.view.View widget) { throw new RuntimeException("Stub!"); }

public final android.view.textclassifier.TextLinks.TextLink getTextLink() { throw new RuntimeException("Stub!"); }
}

}

