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


package android.service.autofill;


/**
 * Validator that returns {@code true} if the number created by concatenating all given fields
 * pass a Luhn algorithm checksum. All non-digits are ignored.
 *
 * <p>See {@link SaveInfo.Builder#setValidator(Validator)} for examples.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class LuhnChecksumValidator implements android.service.autofill.Validator, android.os.Parcelable {

/**
 * Default constructor.
 *
 * @param ids id of fields that comprises the number to be checked.

 * This value must never be {@code null}.
 */

public LuhnChecksumValidator(@androidx.annotation.RecentlyNonNull android.view.autofill.AutofillId... ids) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.service.autofill.LuhnChecksumValidator> CREATOR;
static { CREATOR = null; }
}

