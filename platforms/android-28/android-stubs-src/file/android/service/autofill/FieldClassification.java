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
 * Represents the <a href="AutofillService.html#FieldClassification">field classification</a>
 * results for a given field.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class FieldClassification {

/** @hide */

FieldClassification(@androidx.annotation.RecentlyNonNull java.util.ArrayList<android.service.autofill.FieldClassification.Match> matches) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link Match matches} with the highest {@link Match#getScore() scores} (sorted in
 * descending order).
 *
 * <p><b>Note:</b> There's no guarantee of how many matches will be returned. In fact,
 * the Android System might return just the top match to minimize the impact of field
 * classification in the device's health.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<android.service.autofill.FieldClassification.Match> getMatches() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
/**
 * Represents the score of a {@link UserData} entry for the field.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Match {

/** @hide */

Match(java.lang.String categoryId, float score) { throw new RuntimeException("Stub!"); }

/**
 * Gets the category id of the {@link UserData} entry.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getCategoryId() { throw new RuntimeException("Stub!"); }

/**
 * Gets a classification score for the value of this field compared to the value of the
 * {@link UserData} entry.
 *
 * <p>The score is based in a comparison of the field value and the user data entry, and it
 * ranges from {@code 0.0F} to {@code 1.0F}:
 * <ul>
 *   <li>{@code 1.0F} represents a full match ({@code 100%}).
 *   <li>{@code 0.0F} represents a full mismatch ({@code 0%}).
 *   <li>Any other value is a partial match.
 * </ul>
 *
 * <p>How the score is calculated depends on the
 * {@link UserData.Builder#setFieldClassificationAlgorithm(String, android.os.Bundle)
 * algorithm} used.
 */

public float getScore() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

}

