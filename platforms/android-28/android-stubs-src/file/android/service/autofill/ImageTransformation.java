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
import android.widget.RemoteViews;
import android.widget.ImageView;
import android.view.autofill.AutofillId;

/**
 * Replaces the content of a child {@link ImageView} of a
 * {@link RemoteViews presentation template} with the first image that matches a regular expression
 * (regex).
 *
 * <p>Typically used to display credit card logos. Example:
 *
 * <pre class="prettyprint">
 *   new ImageTransformation.Builder(ccNumberId, Pattern.compile("^4815.*$"),
 *                                   R.drawable.ic_credit_card_logo1, "Brand 1")
 *     .addOption(Pattern.compile("^1623.*$"), R.drawable.ic_credit_card_logo2, "Brand 2")
 *     .addOption(Pattern.compile("^42.*$"), R.drawable.ic_credit_card_logo3, "Brand 3")
 *     .build();
 * </pre>
 *
 * <p>There is no imposed limit in the number of options, but keep in mind that regexs are
 * expensive to evaluate, so use the minimum number of regexs and add the most common first
 * (for example, if this is a tranformation for a credit card logo and the most common credit card
 * issuers are banks X and Y, add the regexes that resolves these 2 banks first).
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ImageTransformation implements android.service.autofill.Transformation, android.os.Parcelable {

ImageTransformation(android.service.autofill.ImageTransformation.Builder builder) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.service.autofill.ImageTransformation> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link ImageTransformation} objects.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Creates a new builder for a autofill id and add a first option.
 *
 * @param id id of the screen field that will be used to evaluate whether the image should
 * be used.
 * This value must never be {@code null}.
 * @param regex regular expression defining what should be matched to use this image.
 * This value must never be {@code null}.
 * @param resId resource id of the image (in the autofill service's package). The
 * {@link RemoteViews presentation} must contain a {@link ImageView} child with that id.
 *
 * @deprecated use
 * {@link #ImageTransformation.Builder(AutofillId, Pattern, int, CharSequence)} instead.
 */

@Deprecated public Builder(@androidx.annotation.RecentlyNonNull android.view.autofill.AutofillId id, @androidx.annotation.RecentlyNonNull java.util.regex.Pattern regex, int resId) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new builder for a autofill id and add a first option.
 *
 * @param id id of the screen field that will be used to evaluate whether the image should
 * be used.
 * This value must never be {@code null}.
 * @param regex regular expression defining what should be matched to use this image.
 * This value must never be {@code null}.
 * @param resId resource id of the image (in the autofill service's package). The
 * {@link RemoteViews presentation} must contain a {@link ImageView} child with that id.
 * @param contentDescription content description to be applied in the child view.

 * This value must never be {@code null}.
 */

public Builder(@androidx.annotation.RecentlyNonNull android.view.autofill.AutofillId id, @androidx.annotation.RecentlyNonNull java.util.regex.Pattern regex, int resId, @androidx.annotation.RecentlyNonNull java.lang.CharSequence contentDescription) { throw new RuntimeException("Stub!"); }

/**
 * Adds an option to replace the child view with a different image when the regex matches.
 *
 * @param regex regular expression defining what should be matched to use this image.
 * This value must never be {@code null}.
 * @param resId resource id of the image (in the autofill service's package). The
 * {@link RemoteViews presentation} must contain a {@link ImageView} child with that id.
 *
 * @return this build
 *
 * @deprecated use {@link #addOption(Pattern, int, CharSequence)} instead.
 */

@Deprecated public android.service.autofill.ImageTransformation.Builder addOption(@androidx.annotation.RecentlyNonNull java.util.regex.Pattern regex, int resId) { throw new RuntimeException("Stub!"); }

/**
 * Adds an option to replace the child view with a different image and content description
 * when the regex matches.
 *
 * @param regex regular expression defining what should be matched to use this image.
 * This value must never be {@code null}.
 * @param resId resource id of the image (in the autofill service's package). The
 * {@link RemoteViews presentation} must contain a {@link ImageView} child with that id.
 * @param contentDescription content description to be applied in the child view.
 *
 * This value must never be {@code null}.
 * @return this build
 */

public android.service.autofill.ImageTransformation.Builder addOption(@androidx.annotation.RecentlyNonNull java.util.regex.Pattern regex, int resId, @androidx.annotation.RecentlyNonNull java.lang.CharSequence contentDescription) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link ImageTransformation} instance.
 */

public android.service.autofill.ImageTransformation build() { throw new RuntimeException("Stub!"); }
}

}

