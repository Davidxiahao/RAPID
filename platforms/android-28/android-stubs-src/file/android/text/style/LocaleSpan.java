/*
 * Copyright (C) 2012 The Android Open Source Project
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

import java.util.Locale;
import android.os.LocaleList;

/**
 * Changes the {@link Locale} of the text to which the span is attached.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class LocaleSpan extends android.text.style.MetricAffectingSpan implements android.text.ParcelableSpan {

/**
 * Creates a {@link LocaleSpan} from a well-formed {@link Locale}.  Note that only
 * {@link Locale} objects that can be created by {@link Locale#forLanguageTag(String)} are
 * supported.
 *
 * <p><b>Caveat:</b> Do not specify any {@link Locale} object that cannot be created by
 * {@link Locale#forLanguageTag(String)}.  {@code new Locale(" a ", " b c", " d")} is an
 * example of such a malformed {@link Locale} object.</p>
 *
 * @param locale The {@link Locale} of the text to which the span is attached.
 *
 * This value may be {@code null}.
 * @see #LocaleSpan(LocaleList)
 */

public LocaleSpan(@androidx.annotation.RecentlyNullable java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link LocaleSpan} from {@link LocaleList}.
 *
 * @param locales The {@link LocaleList} of the text to which the span is attached.
 * This value must never be {@code null}.
 * @throws NullPointerException if {@code locales} is null
 */

public LocaleSpan(@androidx.annotation.RecentlyNonNull android.os.LocaleList locales) { throw new RuntimeException("Stub!"); }

public LocaleSpan(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @return The {@link Locale} for this span.  If multiple locales are associated with this
 * span, only the first locale is returned.  {@code null} if no {@link Locale} is specified.
 *
 * @see LocaleList#get()
 * @see #getLocales()
 */

@androidx.annotation.RecentlyNullable public java.util.Locale getLocale() { throw new RuntimeException("Stub!"); }

/**
 * @return The entire list of locales that are associated with this span.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.os.LocaleList getLocales() { throw new RuntimeException("Stub!"); }

public void updateDrawState(android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }

public void updateMeasureState(android.text.TextPaint paint) { throw new RuntimeException("Stub!"); }
}

