/*
 * Copyright (C) 2015 The Android Open Source Project
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


package android.os;

import java.util.Locale;

/**
 * LocaleList is an immutable list of Locales, typically used to keep an ordered list of user
 * preferences for locales.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class LocaleList implements android.os.Parcelable {

/**
 * Creates a new {@link LocaleList}.
 *
 * <p>For empty lists of {@link Locale} items it is better to use {@link #getEmptyLocaleList()},
 * which returns a pre-constructed empty list.</p>
 *
 * @throws NullPointerException if any of the input locales is <code>null</code>.
 * @throws IllegalArgumentException if any of the input locales repeat.

 * @param list This value must never be {@code null}.
 */

public LocaleList(@androidx.annotation.RecentlyNonNull java.util.Locale... list) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the {@link Locale} at the specified index.
 *
 * @param index The position to retrieve.
 * @return The {@link Locale} in the given index.
 */

public java.util.Locale get(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the {@link LocaleList} contains no {@link Locale} items.
 *
 * @return {@code true} if this {@link LocaleList} has no {@link Locale} items, {@code false}
 *     otherwise.
 */

public boolean isEmpty() { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of {@link Locale} items in this {@link LocaleList}.

 * @return Value is 0 or greater
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Searches this {@link LocaleList} for the specified {@link Locale} and returns the index of
 * the first occurrence.
 *
 * @param locale The {@link Locale} to search for.
 * @return The index of the first occurrence of the {@link Locale} or {@code -1} if the item
 *     wasn't found.

 * Value is -1 or greater
 */

public int indexOf(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object other) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves a String representation of the language tags in this list.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String toLanguageTags() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve an empty instance of {@link LocaleList}.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public static android.os.LocaleList getEmptyLocaleList() { throw new RuntimeException("Stub!"); }

/**
 * Generates a new LocaleList with the given language tags.
 *
 * @param list The language tags to be included as a single {@link String} separated by commas.
 * This value may be {@code null}.
 * @return A new instance with the {@link Locale} items identified by the given tags.
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public static android.os.LocaleList forLanguageTags(@androidx.annotation.RecentlyNullable java.lang.String list) { throw new RuntimeException("Stub!"); }

/**
 * Returns the first match in the locale list given an unordered array of supported locales
 * in BCP 47 format.
 *
 * @return The first {@link Locale} from this list that appears in the given array, or
 *     {@code null} if the {@link LocaleList} is empty.
 */

@androidx.annotation.RecentlyNullable public java.util.Locale getFirstMatch(java.lang.String[] supportedLocales) { throw new RuntimeException("Stub!"); }

/**
 * The result is guaranteed to include the default Locale returned by Locale.getDefault(), but
 * not necessarily at the top of the list. The default locale not being at the top of the list
 * is an indication that the system has set the default locale to one of the user's other
 * preferred locales, having concluded that the primary preference is not supported but a
 * secondary preference is.
 *
 * <p>Note that the default LocaleList would change if Locale.setDefault() is called. This
 * method takes that into account by always checking the output of Locale.getDefault() and
 * recalculating the default LocaleList if needed.</p>

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public static android.os.LocaleList getDefault() { throw new RuntimeException("Stub!"); }

/**
 * Returns the default locale list, adjusted by moving the default locale to its first
 * position.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public static android.os.LocaleList getAdjustedDefault() { throw new RuntimeException("Stub!"); }

/**
 * Also sets the default locale by calling Locale.setDefault() with the first locale in the
 * list.
 *
 * @throws NullPointerException if the input is <code>null</code>.
 * @throws IllegalArgumentException if the input is empty.

 * @param locales This value must never be {@code null}.
 */

public static void setDefault(@androidx.annotation.RecentlyNonNull android.os.LocaleList locales) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.os.LocaleList> CREATOR;
static { CREATOR = null; }
}

