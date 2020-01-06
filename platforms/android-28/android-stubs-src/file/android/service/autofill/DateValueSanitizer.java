/*
 * Copyright (C) 2018 The Android Open Source Project
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


package android.service.autofill;

import android.icu.text.DateFormat;
import android.view.autofill.AutofillValue;
import java.util.Date;

/**
 * Sanitizes a date {@link AutofillValue} using a {@link DateFormat}.
 *
 * <p>For example, to sanitize a credit card expiration date to just its month and year:
 *
 * <pre class="prettyprint">
 * new DateValueSanitizer(new java.text.SimpleDateFormat("MM/yyyy");
 * </pre>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class DateValueSanitizer implements android.service.autofill.Sanitizer, android.os.Parcelable {

/**
 * Default constructor.
 *
 * @param dateFormat date format applied to the actual date value of an input field.

 * This value must never be {@code null}.
 */

public DateValueSanitizer(@androidx.annotation.RecentlyNonNull android.icu.text.DateFormat dateFormat) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.service.autofill.DateValueSanitizer> CREATOR;
static { CREATOR = null; }
}

