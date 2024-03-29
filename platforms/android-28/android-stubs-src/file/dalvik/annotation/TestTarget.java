/*
 * Copyright (C) 2008 The Android Open Source Project
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


package dalvik.annotation;


/**
 * Defines an annotation used be used within the TestInfo annotation. It
 * specifies a single method target for the test (but can be used multiple
 * times).
 *
 * @deprecated Obsolete.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME) @java.lang.annotation.Target({java.lang.annotation.ElementType.ANNOTATION_TYPE}) public @interface TestTarget {

/**
 * Specifies the name of the method that is being tested.
 */

public java.lang.String methodName() default "";

/**
 * Specifies the name of a concept being tested. Use this if
 * {@code methodName} is not accurate enough. E.g. for
 * {@link java.util.regex.Pattern#compile(String)} {@code methodName} is not
 * sufficient since the String contains a pattern with its own syntax which
 * has to be tested with different aspects. Areas concerned are e.g. JDBC
 * (SELECT, INSERT, UPDATE, DELETE, ...), regex (character sets,
 * operators,...), formatters (DecimalFormat, DateFormat, ChoiceFormat,
 * ...), ...
 */

public java.lang.String conceptName() default "";

/**
 * Specifies the signature of the method that is being tested, in terms of
 * Java classes.
 */

public java.lang.Class<?>[] methodArgs() default {};
}

