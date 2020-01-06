/*
 * Copyright 2017 The Android Open Source Project
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

import android.service.autofill.FieldClassification.Match;
import android.view.autofill.AutofillManager;

/**
 * Defines the user data used for
 * <a href="AutofillService.html#FieldClassification">field classification</a>.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class UserData implements android.os.Parcelable {

UserData(android.service.autofill.UserData.Builder builder) { throw new RuntimeException("Stub!"); }

/**
 * Gets the name of the algorithm that is used to calculate
 * {@link Match#getScore() match scores}.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getFieldClassificationAlgorithm() { throw new RuntimeException("Stub!"); }

/**
 * Gets the id.
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum number of values that can be added to a {@link UserData}.
 */

public static int getMaxUserDataSize() { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum number of ids that can be passed to {@link
 * FillResponse.Builder#setFieldClassificationIds(android.view.autofill.AutofillId...)}.
 */

public static int getMaxFieldClassificationIdsSize() { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum number of unique category ids that can be passed to
 * the builder's constructor and {@link Builder#add(String, String)}.
 */

public static int getMaxCategoryCount() { throw new RuntimeException("Stub!"); }

/**
 * Gets the minimum length of values passed to the builder's constructor or
 * or {@link Builder#add(String, String)}.
 */

public static int getMinValueLength() { throw new RuntimeException("Stub!"); }

/**
 * Gets the maximum length of values passed to the builder's constructor or
 * or {@link Builder#add(String, String)}.
 */

public static int getMaxValueLength() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.service.autofill.UserData> CREATOR;
static { CREATOR = null; }
/**
 * A builder for {@link UserData} objects.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a new builder for the user data used for <a href="#FieldClassification">field
 * classification</a>.
 *
 * <p>The user data must contain at least one pair of {@code value} -> {@code categoryId},
 * and more pairs can be added through the {@link #add(String, String)} method. For example:
 *
 * <pre class="prettyprint">
 * new UserData.Builder("v1", "Bart Simpson", "name")
 *   .add("bart.simpson@example.com", "email")
 *   .add("el_barto@example.com", "email")
 *   .build();
 * </pre>
 *
 * @param id id used to identify the whole {@link UserData} object. This id is also returned
 * by {@link AutofillManager#getUserDataId()}, which can be used to check if the
 * {@link UserData} is up-to-date without fetching the whole object (through
 * {@link AutofillManager#getUserData()}).
 *
 * This value must never be {@code null}.
 * @param value value of the user data.
 * This value must never be {@code null}.
 * @param categoryId string used to identify the category the value is associated with.
 *
 * This value must never be {@code null}.
 * @throws IllegalArgumentException if any of the following occurs:
 * <ul>
 *   <li>{@code id} is empty</li>
 *   <li>{@code categoryId} is empty</li>
 *   <li>{@code value} is empty</li>
 *   <li>the length of {@code value} is lower than {@link UserData#getMinValueLength()}</li>
 *   <li>the length of {@code value} is higher than
 *       {@link UserData#getMaxValueLength()}</li>
 * </ul>
 */

public Builder(@androidx.annotation.RecentlyNonNull java.lang.String id, @androidx.annotation.RecentlyNonNull java.lang.String value, @androidx.annotation.RecentlyNonNull java.lang.String categoryId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the algorithm used for <a href="#FieldClassification">field classification</a>.
 *
 * <p>The currently available algorithms can be retrieve through
 * {@link AutofillManager#getAvailableFieldClassificationAlgorithms()}.
 *
 * <p>If not set, the
 * {@link AutofillManager#getDefaultFieldClassificationAlgorithm() default algorithm} is
 * used instead.
 *
 * @param name name of the algorithm or {@code null} to used default.
 * This value may be {@code null}.
 * @param args optional arguments to the algorithm.
 *
 * This value may be {@code null}.
 * @return this builder
 */

public android.service.autofill.UserData.Builder setFieldClassificationAlgorithm(@androidx.annotation.RecentlyNullable java.lang.String name, @androidx.annotation.RecentlyNullable android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Adds a new value for user data.
 *
 * @param value value of the user data.
 * This value must never be {@code null}.
 * @param categoryId string used to identify the category the value is associated with.
 *
 * This value must never be {@code null}.
 * @throws IllegalStateException if:
 * <ul>
 *   <li>{@link #build()} already called</li>
 *   <li>the {@code value} has already been added</li>
 *   <li>the number of unique {@code categoryId} values added so far is more than
 *       {@link UserData#getMaxCategoryCount()}</li>
 *   <li>the number of {@code values} added so far is is more than
 *       {@link UserData#getMaxUserDataSize()}</li>
 * </ul>
 *
 * @throws IllegalArgumentException if any of the following occurs:
 * <ul>
 *   <li>{@code id} is empty</li>
 *   <li>{@code categoryId} is empty</li>
 *   <li>{@code value} is empty</li>
 *   <li>the length of {@code value} is lower than {@link UserData#getMinValueLength()}</li>
 *   <li>the length of {@code value} is higher than
 *       {@link UserData#getMaxValueLength()}</li>
 * </ul>
 */

public android.service.autofill.UserData.Builder add(@androidx.annotation.RecentlyNonNull java.lang.String value, @androidx.annotation.RecentlyNonNull java.lang.String categoryId) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new {@link UserData} instance.
 *
 * <p>You should not interact with this builder once this method is called.
 *
 * @throws IllegalStateException if {@link #build()} was already called.
 *
 * @return The built dataset.
 */

public android.service.autofill.UserData build() { throw new RuntimeException("Stub!"); }
}

}

