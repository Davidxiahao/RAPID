/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Parcel;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;

/**
 * Searchability meta-data for an activity. Only applications that search other applications
 * should need to use this class.
 * See <a href="{@docRoot}guide/topics/search/searchable-config.html">Searchable Configuration</a>
 * for more information about declaring searchability meta-data for your application.
 *
 * @see SearchManager#getSearchableInfo(ComponentName)
 * @see SearchManager#getSearchablesInGlobalSearch()
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SearchableInfo implements android.os.Parcelable {

/**
 * Instantiates a new SearchableInfo from the data in a Parcel that was
 * previously written with {@link #writeToParcel(Parcel, int)}.
 *
 * @param in The Parcel containing the previously written SearchableInfo,
 * positioned at the location in the buffer where it was written.
 */

SearchableInfo(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Gets the search suggestion content provider authority.
 *
 * @return The search suggestions authority, or {@code null} if not set.
 * @see android.R.styleable#Searchable_searchSuggestAuthority
 */

public java.lang.String getSuggestAuthority() { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the package where the suggestion provider lives,
 * or {@code null}.
 */

public java.lang.String getSuggestPackage() { throw new RuntimeException("Stub!"); }

/**
 * Gets the component name of the searchable activity.
 *
 * @return A component name, never {@code null}.
 */

public android.content.ComponentName getSearchActivity() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the text in the query field should come from the suggestion intent data.
 *
 * @see android.R.styleable#Searchable_searchMode
 */

public boolean shouldRewriteQueryFromData() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the text in the query field should come from the suggestion title.
 *
 * @see android.R.styleable#Searchable_searchMode
 */

public boolean shouldRewriteQueryFromText() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource id of the description string to use for this source in system search
 * settings, or {@code 0} if none has been specified.
 *
 * @see android.R.styleable#Searchable_searchSettingsDescription
 */

public int getSettingsDescriptionId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the content provider path for obtaining search suggestions.
 *
 * @return The suggestion path, or {@code null} if not set.
 * @see android.R.styleable#Searchable_searchSuggestPath
 */

public java.lang.String getSuggestPath() { throw new RuntimeException("Stub!"); }

/**
 * Gets the selection for obtaining search suggestions.
 *
 * @see android.R.styleable#Searchable_searchSuggestSelection
 */

public java.lang.String getSuggestSelection() { throw new RuntimeException("Stub!"); }

/**
 * Gets the optional intent action for use with these suggestions. This is
 * useful if all intents will have the same action
 * (e.g. {@link android.content.Intent#ACTION_VIEW})
 *
 * This can be overriden in any given suggestion using the column
 * {@link SearchManager#SUGGEST_COLUMN_INTENT_ACTION}.
 *
 * @return The default intent action, or {@code null} if not set.
 * @see android.R.styleable#Searchable_searchSuggestIntentAction
 */

public java.lang.String getSuggestIntentAction() { throw new RuntimeException("Stub!"); }

/**
 * Gets the optional intent data for use with these suggestions.  This is
 * useful if all intents will have similar data URIs,
 * but you'll likely need to provide a specific ID as well via the column
 * {@link SearchManager#SUGGEST_COLUMN_INTENT_DATA_ID}, which will be appended to the
 * intent data URI.
 *
 * This can be overriden in any given suggestion using the column
 * {@link SearchManager#SUGGEST_COLUMN_INTENT_DATA}.
 *
 * @return The default intent data, or {@code null} if not set.
 * @see android.R.styleable#Searchable_searchSuggestIntentData
 */

public java.lang.String getSuggestIntentData() { throw new RuntimeException("Stub!"); }

/**
 * Gets the suggestion threshold.
 *
 * @return The suggestion threshold, or {@code 0} if not set.
 * @see android.R.styleable#Searchable_searchSuggestThreshold
 */

public int getSuggestThreshold() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource id of the hint text. This must be
 * read using the searchable Activity's resources.
 *
 * @return A resource id, or {@code 0} if no hint was specified.
 * @see android.R.styleable#Searchable_hint
 */

public int getHintId() { throw new RuntimeException("Stub!"); }

/**
 * Checks if the searchable activity wants the voice search button to be shown.
 *
 * @see android.R.styleable#Searchable_voiceSearchMode
 */

public boolean getVoiceSearchEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Checks if voice search should start web search.
 *
 * @see android.R.styleable#Searchable_voiceSearchMode
 */

public boolean getVoiceSearchLaunchWebSearch() { throw new RuntimeException("Stub!"); }

/**
 * Checks if voice search should start in-app search.
 *
 * @see android.R.styleable#Searchable_voiceSearchMode
 */

public boolean getVoiceSearchLaunchRecognizer() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource id of the voice search language model string.
 *
 * @return A resource id, or {@code 0} if no language model was specified.
 * @see android.R.styleable#Searchable_voiceLanguageModel
 */

public int getVoiceLanguageModeId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource id of the voice prompt text string.
 *
 * @return A resource id, or {@code 0} if no voice prompt text was specified.
 * @see android.R.styleable#Searchable_voicePromptText
 */

public int getVoicePromptTextId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource id of the spoken language to recognize in voice search.
 *
 * @return A resource id, or {@code 0} if no language was specified.
 * @see android.R.styleable#Searchable_voiceLanguage
 */

public int getVoiceLanguageId() { throw new RuntimeException("Stub!"); }

/**
 * The maximum number of voice recognition results to return.
 *
 * @return the max results count, if specified in the searchable
 *         activity's metadata, or {@code 0} if not specified.
 * @see android.R.styleable#Searchable_voiceMaxResults
 */

public int getVoiceMaxResults() { throw new RuntimeException("Stub!"); }

/**
 * Gets the input type as specified in the searchable attributes. This will default to
 * {@link InputType#TYPE_CLASS_TEXT} if not specified (which is appropriate
 * for free text input).
 *
 * @return the input type
 * @see android.R.styleable#Searchable_inputType
 */

public int getInputType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the input method options specified in the searchable attributes.
 * This will default to {@link EditorInfo#IME_ACTION_GO} if not specified (which is
 * appropriate for a search box).
 *
 * @return the input type
 * @see android.R.styleable#Searchable_imeOptions
 */

public int getImeOptions() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the searchable should be included in global search.
 *
 * @return The value of the {@link android.R.styleable#Searchable_includeInGlobalSearch}
 *         attribute, or {@code false} if the attribute is not set.
 * @see android.R.styleable#Searchable_includeInGlobalSearch
 */

public boolean shouldIncludeInGlobalSearch() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this searchable activity should be queried for suggestions if a prefix
 * of the query has returned no results.
 *
 * @see android.R.styleable#Searchable_queryAfterZeroResults
 */

public boolean queryAfterZeroResults() { throw new RuntimeException("Stub!"); }

/**
 * Checks whether this searchable activity has auto URL detection turned on.
 *
 * @see android.R.styleable#Searchable_autoUrlDetect
 */

public boolean autoUrlDetect() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Support for parcelable and aidl operations.
 */

public static final android.os.Parcelable.Creator<android.app.SearchableInfo> CREATOR;
static { CREATOR = null; }
}

