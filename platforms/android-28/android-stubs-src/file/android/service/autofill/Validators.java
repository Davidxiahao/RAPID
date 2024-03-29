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
 * Factory for {@link Validator} operations.
 *
 * <p>See {@link SaveInfo.Builder#setValidator(Validator)} for examples.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Validators {

Validators() { throw new RuntimeException("Stub!"); }

/**
 * Creates a validator that is only valid if all {@code validators} are valid.
 *
 * <p>Used to represent an {@code AND} boolean operation in a chain of validators.
 *
 * @throws IllegalArgumentException if any element of {@code validators} is an instance of a
 * class that is not provided by the Android System.
 
 * @param validators This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public static android.service.autofill.Validator and(@androidx.annotation.RecentlyNonNull android.service.autofill.Validator... validators) { throw new RuntimeException("Stub!"); }

/**
 * Creates a validator that is valid if any of the {@code validators} is valid.
 *
 * <p>Used to represent an {@code OR} boolean operation in a chain of validators.
 *
 * @throws IllegalArgumentException if any element of {@code validators} is an instance of a
 * class that is not provided by the Android System.
 
 * @param validators This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public static android.service.autofill.Validator or(@androidx.annotation.RecentlyNonNull android.service.autofill.Validator... validators) { throw new RuntimeException("Stub!"); }

/**
 * Creates a validator that is valid when {@code validator} is not, and vice versa.
 *
 * <p>Used to represent a {@code NOT} boolean operation in a chain of validators.
 *
 * @throws IllegalArgumentException if {@code validator} is an instance of a class that is not
 * provided by the Android System.
 
 * @param validator This value must never be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public static android.service.autofill.Validator not(@androidx.annotation.RecentlyNonNull android.service.autofill.Validator validator) { throw new RuntimeException("Stub!"); }
}

