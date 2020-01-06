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

import android.text.util.Linkify;

/**
 * Interface for providing text classification related features.
 *
 * <p><strong>NOTE: </strong>Unless otherwise stated, methods of this interface are blocking
 * operations. Call on a worker thread.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public interface TextClassifier {

/**
 * Returns suggested text selection start and end indices, recognized entity types, and their
 * associated confidence scores. The entity types are ordered from highest to lowest scoring.
 *
 * <p><strong>NOTE: </strong>Call on a worker thread.
 *
 * <p><strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link IllegalStateException}. See {@link #isDestroyed()}.
 *
 * This method may take several seconds to complete, so it should
 *  *            only be called from a worker thread.
 * @param request the text selection request
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public default android.view.textclassifier.TextSelection suggestSelection(@androidx.annotation.RecentlyNonNull android.view.textclassifier.TextSelection.Request request) { throw new RuntimeException("Stub!"); }

/**
 * Returns suggested text selection start and end indices, recognized entity types, and their
 * associated confidence scores. The entity types are ordered from highest to lowest scoring.
 *
 * <p><strong>NOTE: </strong>Call on a worker thread.
 *
 * <p><strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link IllegalStateException}. See {@link #isDestroyed()}.
 *
 * <p><b>NOTE:</b> Do not implement. The default implementation of this method calls
 * {@link #suggestSelection(TextSelection.Request)}. If that method calls this method,
 * a stack overflow error will happen.
 *
 * This method may take several seconds to complete, so it should
 *  *            only be called from a worker thread.
 * @param text text providing context for the selected text (which is specified
 *      by the sub sequence starting at selectionStartIndex and ending at selectionEndIndex)
 * This value must never be {@code null}.
 * @param selectionStartIndex start index of the selected part of text
 * Value is 0 or greater
 * @param selectionEndIndex end index of the selected part of text
 * Value is 0 or greater
 * @param defaultLocales ordered list of locale preferences that may be used to
 *      disambiguate the provided text. If no locale preferences exist, set this to null
 *      or an empty locale list.
 *
 * This value may be {@code null}.
 * @throws IllegalArgumentException if text is null; selectionStartIndex is negative;
 *      selectionEndIndex is greater than text.length() or not greater than selectionStartIndex
 *
 * @see #suggestSelection(TextSelection.Request)
 */

@androidx.annotation.RecentlyNonNull public default android.view.textclassifier.TextSelection suggestSelection(@androidx.annotation.RecentlyNonNull java.lang.CharSequence text, int selectionStartIndex, int selectionEndIndex, @androidx.annotation.RecentlyNullable android.os.LocaleList defaultLocales) { throw new RuntimeException("Stub!"); }

/**
 * Classifies the specified text and returns a {@link TextClassification} object that can be
 * used to generate a widget for handling the classified text.
 *
 * <p><strong>NOTE: </strong>Call on a worker thread.
 *
 * <strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link IllegalStateException}. See {@link #isDestroyed()}.
 *
 * This method may take several seconds to complete, so it should
 *  *            only be called from a worker thread.
 * @param request the text classification request
 
 * This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public default android.view.textclassifier.TextClassification classifyText(@androidx.annotation.RecentlyNonNull android.view.textclassifier.TextClassification.Request request) { throw new RuntimeException("Stub!"); }

/**
 * Classifies the specified text and returns a {@link TextClassification} object that can be
 * used to generate a widget for handling the classified text.
 *
 * <p><strong>NOTE: </strong>Call on a worker thread.
 *
 * <p><b>NOTE:</b> Do not implement. The default implementation of this method calls
 * {@link #classifyText(TextClassification.Request)}. If that method calls this method,
 * a stack overflow error will happen.
 *
 * <strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link IllegalStateException}. See {@link #isDestroyed()}.
 *
 * This method may take several seconds to complete, so it should
 *  *            only be called from a worker thread.
 * @param text text providing context for the text to classify (which is specified
 *      by the sub sequence starting at startIndex and ending at endIndex)
 * This value must never be {@code null}.
 * @param startIndex start index of the text to classify
 * Value is 0 or greater
 * @param endIndex end index of the text to classify
 * Value is 0 or greater
 * @param defaultLocales ordered list of locale preferences that may be used to
 *      disambiguate the provided text. If no locale preferences exist, set this to null
 *      or an empty locale list.
 *
 * This value may be {@code null}.
 * @throws IllegalArgumentException if text is null; startIndex is negative;
 *      endIndex is greater than text.length() or not greater than startIndex
 *
 * @see #classifyText(TextClassification.Request)
 */

@androidx.annotation.RecentlyNonNull public default android.view.textclassifier.TextClassification classifyText(@androidx.annotation.RecentlyNonNull java.lang.CharSequence text, int startIndex, int endIndex, @androidx.annotation.RecentlyNullable android.os.LocaleList defaultLocales) { throw new RuntimeException("Stub!"); }

/**
 * Generates and returns a {@link TextLinks} that may be applied to the text to annotate it with
 * links information.
 *
 * <p><strong>NOTE: </strong>Call on a worker thread.
 *
 * <strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link IllegalStateException}. See {@link #isDestroyed()}.
 *
 * This method may take several seconds to complete, so it should
 *  *            only be called from a worker thread.
 * @param request the text links request
 *
 * This value must never be {@code null}.
 * @see #getMaxGenerateLinksTextLength()
 
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public default android.view.textclassifier.TextLinks generateLinks(@androidx.annotation.RecentlyNonNull android.view.textclassifier.TextLinks.Request request) { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximal length of text that can be processed by generateLinks.
 *
 * <strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link IllegalStateException}. See {@link #isDestroyed()}.
 *
 * This method may take several seconds to complete, so it should
 *  *            only be called from a worker thread.
 * @see #generateLinks(TextLinks.Request)
 */

public default int getMaxGenerateLinksTextLength() { throw new RuntimeException("Stub!"); }

/**
 * Reports a selection event.
 *
 * <strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to this method should
 * throw an {@link IllegalStateException}. See {@link #isDestroyed()}.

 * @param event This value must never be {@code null}.
 */

public default void onSelectionEvent(@androidx.annotation.RecentlyNonNull android.view.textclassifier.SelectionEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Destroys this TextClassifier.
 *
 * <strong>NOTE: </strong>If a TextClassifier has been destroyed, calls to its methods should
 * throw an {@link IllegalStateException}. See {@link #isDestroyed()}.
 *
 * <p>Subsequent calls to this method are no-ops.
 */

public default void destroy() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not this TextClassifier has been destroyed.
 *
 * <strong>NOTE: </strong>If a TextClassifier has been destroyed, caller should not interact
 * with the classifier and an attempt to do so would throw an {@link IllegalStateException}.
 * However, this method should never throw an {@link IllegalStateException}.
 *
 * @see #destroy()
 */

public default boolean isDestroyed() { throw new RuntimeException("Stub!"); }

/** Designates that the text in question is editable. **/

public static final java.lang.String HINT_TEXT_IS_EDITABLE = "android.text_is_editable";

/** Designates that the text in question is not editable. **/

public static final java.lang.String HINT_TEXT_IS_NOT_EDITABLE = "android.text_is_not_editable";

/**
 * No-op TextClassifier.
 * This may be used to turn off TextClassifier features.
 */

public static final android.view.textclassifier.TextClassifier NO_OP = null;

/** Physical address. */

public static final java.lang.String TYPE_ADDRESS = "address";

/** Time reference that is no more specific than a date. May be absolute such as "01/01/2000" or
 * relative like "tomorrow". **/

public static final java.lang.String TYPE_DATE = "date";

/** Time reference that includes a specific time. May be absolute such as "01/01/2000 5:30pm" or
 * relative like "tomorrow at 5:30pm". **/

public static final java.lang.String TYPE_DATE_TIME = "datetime";

/** E-mail address (e.g.&nbsp;"noreply@android.com"). */

public static final java.lang.String TYPE_EMAIL = "email";

/** Flight number in IATA format. */

public static final java.lang.String TYPE_FLIGHT_NUMBER = "flight";

/** The classifier ran, but didn't recognize a known entity. */

public static final java.lang.String TYPE_OTHER = "other";

/** Phone number (e.g.&nbsp;"555-123 456"). */

public static final java.lang.String TYPE_PHONE = "phone";

/** The TextClassifier failed to run. */

public static final java.lang.String TYPE_UNKNOWN = "";

/** Web URL. */

public static final java.lang.String TYPE_URL = "url";

/** The widget involved in the text classification session is a custom editable text widget. */

public static final java.lang.String WIDGET_TYPE_CUSTOM_EDITTEXT = "customedit";

/** The widget involved in the text classification session is a custom text widget. */

public static final java.lang.String WIDGET_TYPE_CUSTOM_TEXTVIEW = "customview";

/** The widget involved in the text classification session is a custom non-selectable text
 * widget. */

public static final java.lang.String WIDGET_TYPE_CUSTOM_UNSELECTABLE_TEXTVIEW = "nosel-customview";

/** The widget involved in the text classification session is a standard
 * {@link android.widget.EditText}. */

public static final java.lang.String WIDGET_TYPE_EDITTEXT = "edittext";

/** The widget involved in the text classification session is a standard editable
 * {@link android.webkit.WebView}. */

public static final java.lang.String WIDGET_TYPE_EDIT_WEBVIEW = "edit-webview";

/** The widget involved in the text classification session is a standard
 * {@link android.widget.TextView}. */

public static final java.lang.String WIDGET_TYPE_TEXTVIEW = "textview";

/** The widget involved in the text classification session is of an unknown/unspecified type. */

public static final java.lang.String WIDGET_TYPE_UNKNOWN = "unknown";

/** The widget involved in the text classification session is a standard non-selectable
 * {@link android.widget.TextView}. */

public static final java.lang.String WIDGET_TYPE_UNSELECTABLE_TEXTVIEW = "nosel-textview";

/** The widget involved in the text classification session is a standard
 * {@link android.webkit.WebView}. */

public static final java.lang.String WIDGET_TYPE_WEBVIEW = "webview";
/**
 * Configuration object for specifying what entities to identify.
 *
 * Configs are initially based on a predefined preset, and can be modified from there.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class EntityConfig implements android.os.Parcelable {

EntityConfig(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Creates an EntityConfig.
 *
 * @param hints Hints for the TextClassifier to determine what types of entities to find.

 * This value may be {@code null}.
 */

public static android.view.textclassifier.TextClassifier.EntityConfig createWithHints(@androidx.annotation.RecentlyNullable java.util.Collection<java.lang.String> hints) { throw new RuntimeException("Stub!"); }

/**
 * Creates an EntityConfig.
 *
 * @param hints Hints for the TextClassifier to determine what types of entities to find
 * This value may be {@code null}.
 * @param includedEntityTypes Entity types, e.g. {@link #TYPE_EMAIL}, to explicitly include
 * This value may be {@code null}.
 * @param excludedEntityTypes Entity types, e.g. {@link #TYPE_PHONE}, to explicitly exclude
 *
 *
 * Note that if an entity has been excluded, the exclusion will take precedence.

 * This value may be {@code null}.
 */

public static android.view.textclassifier.TextClassifier.EntityConfig create(@androidx.annotation.RecentlyNullable java.util.Collection<java.lang.String> hints, @androidx.annotation.RecentlyNullable java.util.Collection<java.lang.String> includedEntityTypes, @androidx.annotation.RecentlyNullable java.util.Collection<java.lang.String> excludedEntityTypes) { throw new RuntimeException("Stub!"); }

/**
 * Creates an EntityConfig with an explicit entity list.
 *
 * @param entityTypes Complete set of entities, e.g. {@link #TYPE_URL} to find.
 *

 * This value may be {@code null}.
 */

public static android.view.textclassifier.TextClassifier.EntityConfig createWithExplicitEntityList(@androidx.annotation.RecentlyNullable java.util.Collection<java.lang.String> entityTypes) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of the final set of entities to find.
 *
 * @param entities Entities we think should be found before factoring in includes/excludes
 *
 * This method is intended for use by TextClassifier implementations.

 * This value must never be {@code null}.
 */

public java.util.Collection<java.lang.String> resolveEntityListModifications(@androidx.annotation.RecentlyNonNull java.util.Collection<java.lang.String> entities) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the list of hints.
 *
 * @return An unmodifiable collection of the hints.
 */

public java.util.Collection<java.lang.String> getHints() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.view.textclassifier.TextClassifier.EntityConfig> CREATOR;
static { CREATOR = null; }
}

}

