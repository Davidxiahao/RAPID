/*
 * Copyright (C) 2012 The Android Open Source Project
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

package android.annotation;


/** Indicates that Lint should ignore the specified warnings for the annotated element. */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.LOCAL_VARIABLE}) @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.CLASS) public @interface SuppressLint {

/**
 * The set of warnings (identified by the lint issue id) that should be
 * ignored by lint. It is not an error to specify an unrecognized name.
 */

public java.lang.String[] value();
}

