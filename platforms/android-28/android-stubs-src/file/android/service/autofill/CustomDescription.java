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

import android.widget.RemoteViews;
import android.app.Activity;
import android.app.PendingIntent;

/**
 * Defines a custom description for the autofill save UI.
 *
 * <p>This is useful when the autofill service needs to show a detailed view of what would be saved;
 * for example, when the screen contains a credit card, it could display a logo of the credit card
 * bank, the last four digits of the credit card number, and its expiration number.
 *
 * <p>A custom description is made of 2 parts:
 * <ul>
 *   <li>A {@link RemoteViews presentation template} containing children views.
 *   <li>{@link Transformation Transformations} to populate the children views.
 * </ul>
 *
 * <p>For the credit card example mentioned above, the (simplified) template would be:
 *
 * <pre class="prettyprint">
 * &lt;LinearLayout&gt;
 *   &lt;ImageView android:id="@+id/templateccLogo"/&gt;
 *   &lt;TextView android:id="@+id/templateCcNumber"/&gt;
 *   &lt;TextView android:id="@+id/templateExpDate"/&gt;
 * &lt;/LinearLayout&gt;
 * </pre>
 *
 * <p>Which in code translates to:
 *
 * <pre class="prettyprint">
 *   CustomDescription.Builder buider = new Builder(new RemoteViews(pgkName, R.layout.cc_template);
 * </pre>
 *
 * <p>Then the value of each of the 3 children would be changed at runtime based on the the value of
 * the screen fields and the {@link Transformation Transformations}:
 *
 * <pre class="prettyprint">
 * // Image child - different logo for each bank, based on credit card prefix
 * builder.addChild(R.id.templateccLogo,
 *   new ImageTransformation.Builder(ccNumberId)
 *     .addOption(Pattern.compile("^4815.*$"), R.drawable.ic_credit_card_logo1)
 *     .addOption(Pattern.compile("^1623.*$"), R.drawable.ic_credit_card_logo2)
 *     .addOption(Pattern.compile("^42.*$"), R.drawable.ic_credit_card_logo3)
 *     .build();
 * // Masked credit card number (as .....LAST_4_DIGITS)
 * builder.addChild(R.id.templateCcNumber, new CharSequenceTransformation
 *     .Builder(ccNumberId, Pattern.compile("^.*(\\d\\d\\d\\d)$"), "...$1")
 *     .build();
 * // Expiration date as MM / YYYY:
 * builder.addChild(R.id.templateExpDate, new CharSequenceTransformation
 *     .Builder(ccExpMonthId, Pattern.compile("^(\\d\\d)$"), "Exp: $1")
 *     .addField(ccExpYearId, Pattern.compile("^(\\d\\d)$"), "/$1")
 *     .build();
 * </pre>
 *
 * <p>See {@link ImageTransformation}, {@link CharSequenceTransformation} for more info about these
 * transformations.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class CustomDescription implements android.os.Parcelable {

CustomDescription(android.service.autofill.CustomDescription.Builder builder) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.service.autofill.CustomDescription> CREATOR;
static { CREATOR = null; }
/**
 * Builder for {@link CustomDescription} objects.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Default constructor.
 *
 * <p><b>Note:</b> If any child view of presentation triggers a
 * {@link RemoteViews#setOnClickPendingIntent(int, android.app.PendingIntent) pending intent
 * on click}, such {@link PendingIntent} must follow the restrictions below, otherwise
 * it might not be triggered or the autofill save UI might not be shown when its activity
 * is finished:
 * <ul>
 *   <li>It cannot be created with the {@link PendingIntent#FLAG_IMMUTABLE} flag.
 *   <li>It must be a PendingIntent for an {@link Activity}.
 *   <li>The activity must call {@link Activity#finish()} when done.
 *   <li>The activity should not launch other activities.
 * </ul>
 *
 * @param parentPresentation template presentation with (optional) children views.
 * This value must never be {@code null}.
 * @throws NullPointerException if {@code parentPresentation} is null (on Android
 * {@link android.os.Build.VERSION_CODES#P} or higher).
 */

public Builder(@androidx.annotation.RecentlyNonNull android.widget.RemoteViews parentPresentation) { throw new RuntimeException("Stub!"); }

/**
 * Adds a transformation to replace the value of a child view with the fields in the
 * screen.
 *
 * <p>When multiple transformations are added for the same child view, they will be applied
 * in the same order as added.
 *
 * @param id view id of the children view.
 * @param transformation an implementation provided by the Android System.
 * This value must never be {@code null}.
 * @return this builder.
 * @throws IllegalArgumentException if {@code transformation} is not a class provided
 * by the Android System.
 */

public android.service.autofill.CustomDescription.Builder addChild(int id, @androidx.annotation.RecentlyNonNull android.service.autofill.Transformation transformation) { throw new RuntimeException("Stub!"); }

/**
 * Updates the {@link RemoteViews presentation template} when a condition is satisfied by
 * applying a series of remote view operations. This allows dynamic customization of the
 * portion of the save UI that is controlled by the autofill service. Such dynamic
 * customization is based on the content of target views.
 *
 * <p>The updates are applied in the sequence they are added, after the
 * {@link #addChild(int, Transformation) transformations} are applied to the children
 * views.
 *
 * <p>For example, to make children views visible when fields are not empty:
 *
 * <pre class="prettyprint">
 * RemoteViews template = new RemoteViews(pgkName, R.layout.my_full_template);
 *
 * Pattern notEmptyPattern = Pattern.compile(".+");
 * Validator hasAddress = new RegexValidator(addressAutofillId, notEmptyPattern);
 * Validator hasCcNumber = new RegexValidator(ccNumberAutofillId, notEmptyPattern);
 *
 * RemoteViews addressUpdates = new RemoteViews(pgkName, R.layout.my_full_template)
 * addressUpdates.setViewVisibility(R.id.address, View.VISIBLE);
 *
 * // Make address visible
 * BatchUpdates addressBatchUpdates = new BatchUpdates.Builder()
 *     .updateTemplate(addressUpdates)
 *     .build();
 *
 * RemoteViews ccUpdates = new RemoteViews(pgkName, R.layout.my_full_template)
 * ccUpdates.setViewVisibility(R.id.cc_number, View.VISIBLE);
 *
 * // Mask credit card number (as .....LAST_4_DIGITS) and make it visible
 * BatchUpdates ccBatchUpdates = new BatchUpdates.Builder()
 *     .updateTemplate(ccUpdates)
 *     .transformChild(R.id.templateCcNumber, new CharSequenceTransformation
 *                     .Builder(ccNumberId, Pattern.compile("^.*(\\d\\d\\d\\d)$"), "...$1")
 *                     .build())
 *     .build();
 *
 * CustomDescription customDescription = new CustomDescription.Builder(template)
 *     .batchUpdate(hasAddress, addressBatchUpdates)
 *     .batchUpdate(hasCcNumber, ccBatchUpdates)
 *     .build();
 * </pre>
 *
 * <p>Another approach is to add a child first, then apply the transformations. Example:
 *
 * <pre class="prettyprint">
 * RemoteViews template = new RemoteViews(pgkName, R.layout.my_base_template);
 *
 * RemoteViews addressPresentation = new RemoteViews(pgkName, R.layout.address)
 * RemoteViews addressUpdates = new RemoteViews(pgkName, R.layout.my_template)
 * addressUpdates.addView(R.id.parentId, addressPresentation);
 * BatchUpdates addressBatchUpdates = new BatchUpdates.Builder()
 *     .updateTemplate(addressUpdates)
 *     .build();
 *
 * RemoteViews ccPresentation = new RemoteViews(pgkName, R.layout.cc)
 * RemoteViews ccUpdates = new RemoteViews(pgkName, R.layout.my_template)
 * ccUpdates.addView(R.id.parentId, ccPresentation);
 * BatchUpdates ccBatchUpdates = new BatchUpdates.Builder()
 *     .updateTemplate(ccUpdates)
 *     .transformChild(R.id.templateCcNumber, new CharSequenceTransformation
 *                     .Builder(ccNumberId, Pattern.compile("^.*(\\d\\d\\d\\d)$"), "...$1")
 *                     .build())
 *     .build();
 *
 * CustomDescription customDescription = new CustomDescription.Builder(template)
 *     .batchUpdate(hasAddress, addressBatchUpdates)
 *     .batchUpdate(hasCcNumber, ccBatchUpdates)
 *     .build();
 * </pre>
 *
 * @param condition condition used to trigger the updates.
 * This value must never be {@code null}.
 * @param updates actions to be applied to the
 * {@link #CustomDescription.Builder(RemoteViews) template presentation} when the condition
 * is satisfied.
 *
 * This value must never be {@code null}.
 * @return this builder
 * @throws IllegalArgumentException if {@code condition} is not a class provided
 * by the Android System.
 */

public android.service.autofill.CustomDescription.Builder batchUpdate(@androidx.annotation.RecentlyNonNull android.service.autofill.Validator condition, @androidx.annotation.RecentlyNonNull android.service.autofill.BatchUpdates updates) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link CustomDescription} instance.
 */

public android.service.autofill.CustomDescription build() { throw new RuntimeException("Stub!"); }
}

}

