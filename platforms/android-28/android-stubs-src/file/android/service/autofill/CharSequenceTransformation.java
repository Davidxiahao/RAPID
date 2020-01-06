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

import java.util.regex.Pattern;
import android.widget.TextView;

/**
 * Replaces a {@link TextView} child of a {@link CustomDescription} with the contents of one or
 * more regular expressions (regexs).
 *
 * <p>When it contains more than one field, the fields that match their regex are added to the
 * overall transformation result.
 *
 * <p>For example, a transformation to mask a credit card number contained in just one field would
 * be:
 *
 * <pre class="prettyprint">
 * new CharSequenceTransformation
 *     .Builder(ccNumberId, Pattern.compile("^.*(\\d\\d\\d\\d)$"), "...$1")
 *     .build();
 * </pre>
 *
 * <p>But a transformation that generates a {@code Exp: MM / YYYY} credit expiration date from two
 * fields (month and year) would be:
 *
 * <pre class="prettyprint">
 * new CharSequenceTransformation
 *   .Builder(ccExpMonthId, Pattern.compile("^(\\d\\d)$"), "Exp: $1")
 *   .addField(ccExpYearId, Pattern.compile("^(\\d\\d\\d\\d)$"), " / $1");
 * </pre>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CharSequenceTransformation implements android.service.autofill.Transformation, android.os.Parcelable {

CharSequenceTransformation(android.service.autofill.CharSequenceTransformation.Builder builder) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.service.autofill.CharSequenceTransformation> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link CharSequenceTransformation} objects.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Creates a new builder and adds the first transformed contents of a field to the overall
 * result of this transformation.
 *
 * @param id id of the screen field.
 * This value must never be {@code null}.
 * @param regex regular expression with groups (delimited by {@code (} and {@code (}) that
 * are used to substitute parts of the value.
 * This value must never be {@code null}.
 * @param subst the string that substitutes the matched regex, using {@code $} for
 * group substitution ({@code $1} for 1st group match, {@code $2} for 2nd, etc).

 * This value must never be {@code null}.
 */

public Builder(@androidx.annotation.RecentlyNonNull android.view.autofill.AutofillId id, @androidx.annotation.RecentlyNonNull java.util.regex.Pattern regex, @androidx.annotation.RecentlyNonNull java.lang.String subst) { throw new RuntimeException("Stub!"); }

/**
 * Adds the transformed contents of a field to the overall result of this transformation.
 *
 * @param id id of the screen field.
 * This value must never be {@code null}.
 * @param regex regular expression with groups (delimited by {@code (} and {@code (}) that
 * are used to substitute parts of the value.
 * This value must never be {@code null}.
 * @param subst the string that substitutes the matched regex, using {@code $} for
 * group substitution ({@code $1} for 1st group match, {@code $2} for 2nd, etc).
 *
 * This value must never be {@code null}.
 * @return this builder.
 */

public android.service.autofill.CharSequenceTransformation.Builder addField(@androidx.annotation.RecentlyNonNull android.view.autofill.AutofillId id, @androidx.annotation.RecentlyNonNull java.util.regex.Pattern regex, @androidx.annotation.RecentlyNonNull java.lang.String subst) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link CharSequenceTransformation} instance.
 */

public android.service.autofill.CharSequenceTransformation build() { throw new RuntimeException("Stub!"); }
}

}

