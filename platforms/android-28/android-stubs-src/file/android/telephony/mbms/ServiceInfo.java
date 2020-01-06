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


package android.telephony.mbms;

import java.util.Locale;
import java.util.NoSuchElementException;

/**
 * Describes a cell-broadcast service. This class should not be instantiated directly -- use
 * {@link StreamingServiceInfo} or {@link FileServiceInfo}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ServiceInfo {

/** @hide */

ServiceInfo(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Get the user-displayable name for this cell-broadcast service corresponding to the
 * provided {@link Locale}.
 * @param locale The {@link Locale} in which you want the name of the service. This must be a
 *               value from the set returned by {@link #getNamedContentLocales()} -- an
 *               {@link java.util.NoSuchElementException} may be thrown otherwise.
 * This value must never be {@code null}.
 * @return The {@link CharSequence} providing the name of the service in the given
 *         {@link Locale}
 
 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.CharSequence getNameForLocale(@androidx.annotation.RecentlyNonNull java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Return an unmodifiable set of the current {@link Locale}s that have a user-displayable name
 * associated with them. The user-displayable name associated with any {@link Locale} in this
 * set can be retrieved with {@link #getNameForLocale(Locale)}.
 * @return An unmodifiable set of {@link Locale} objects corresponding to a user-displayable
 * content name in that locale.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.Set<java.util.Locale> getNamedContentLocales() { throw new RuntimeException("Stub!"); }

/**
 * The class name for this service - used to categorize and filter
 */

public java.lang.String getServiceClassName() { throw new RuntimeException("Stub!"); }

/**
 * The languages available for this service content
 */

public java.util.List<java.util.Locale> getLocales() { throw new RuntimeException("Stub!"); }

/**
 * The carrier's identifier for the service.
 */

public java.lang.String getServiceId() { throw new RuntimeException("Stub!"); }

/**
 * The start time indicating when this service will be available.
 */

public java.util.Date getSessionStartTime() { throw new RuntimeException("Stub!"); }

/**
 * The end time indicating when this session stops being available.
 */

public java.util.Date getSessionEndTime() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }
}

