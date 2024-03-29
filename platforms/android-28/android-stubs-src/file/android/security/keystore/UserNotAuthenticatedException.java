/*
 * Copyright (C) 2015 The Android Open Source Project
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


package android.security.keystore;


/**
 * Indicates that a cryptographic operation could not be performed because the user has not been
 * authenticated recently enough. Authenticating the user will resolve this issue.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UserNotAuthenticatedException extends java.security.InvalidKeyException {

/**
 * Constructs a new {@code UserNotAuthenticatedException} without detail message and cause.
 */

public UserNotAuthenticatedException() { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code UserNotAuthenticatedException} with the provided detail message and
 * no cause.
 */

public UserNotAuthenticatedException(java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new {@code UserNotAuthenticatedException} with the provided detail message and
 * cause.
 */

public UserNotAuthenticatedException(java.lang.String message, java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }
}

