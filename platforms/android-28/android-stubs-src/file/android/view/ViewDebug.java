/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.view;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import android.content.res.Resources;
import android.os.Debug;
import java.lang.reflect.Method;
import java.io.BufferedWriter;
import android.content.Context;

/**
 * Various debugging/tracing tools related to {@link View} and the view hierarchy.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ViewDebug {

public ViewDebug() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is now unused and invoking it is a no-op
 */

@Deprecated public static void trace(android.view.View view, android.view.ViewDebug.RecyclerTraceType type, int... parameters) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is now unused and invoking it is a no-op
 */

@Deprecated public static void startRecyclerTracing(java.lang.String prefix, android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is now unused and invoking it is a no-op
 */

@Deprecated public static void stopRecyclerTracing() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is now unused and invoking it is a no-op
 */

@Deprecated public static void trace(android.view.View view, android.view.ViewDebug.HierarchyTraceType type) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is now unused and invoking it is a no-op
 */

@Deprecated public static void startHierarchyTracing(java.lang.String prefix, android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This method is now unused and invoking it is a no-op
 */

@Deprecated public static void stopHierarchyTracing() { throw new RuntimeException("Stub!"); }

/**
 * Dump view info for id based instrument test generation
 * (and possibly further data analysis). The results are dumped
 * to the log.
 * @param tag for log
 * @param view for dump
 */

public static void dumpCapturedView(java.lang.String tag, java.lang.Object view) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated This flag is now unused
 */

@Deprecated public static final boolean TRACE_HIERARCHY = false;

/**
 * @deprecated This flag is now unused
 */

@Deprecated public static final boolean TRACE_RECYCLER = false;
/**
 * This annotation can be used to mark fields and methods to be dumped when
 * the view is captured. Methods with this annotation must have no arguments
 * and must return a valid type of data.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD}) @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME) public static @interface CapturedViewProperty {

/**
 * When retrieveReturn is true, we need to retrieve second level methods
 * e.g., we need myView.getFirstLevelMethod().getSecondLevelMethod()
 * we will set retrieveReturn = true on the annotation of
 * myView.getFirstLevelMethod()
 * @return true if we need the second level methods
 */

public boolean retrieveReturn() default false;
}

/**
 * This annotation can be used to mark fields and methods to be dumped by
 * the view server. Only non-void methods with no arguments can be annotated
 * by this annotation.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD}) @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME) public static @interface ExportedProperty {

/**
 * When resolveId is true, and if the annotated field/method return value
 * is an int, the value is converted to an Android's resource name.
 *
 * @return true if the property's value must be transformed into an Android
 *         resource name, false otherwise
 */

public boolean resolveId() default false;

/**
 * A mapping can be defined to map int values to specific strings. For
 * instance, View.getVisibility() returns 0, 4 or 8. However, these values
 * actually mean VISIBLE, INVISIBLE and GONE. A mapping can be used to see
 * these human readable values:
 *
 * <pre>
 * {@literal @}ViewDebug.ExportedProperty(mapping = {
 *     {@literal @}ViewDebug.IntToString(from = 0, to = "VISIBLE"),
 *     {@literal @}ViewDebug.IntToString(from = 4, to = "INVISIBLE"),
 *     {@literal @}ViewDebug.IntToString(from = 8, to = "GONE")
 * })
 * public int getVisibility() { ...
 * <pre>
 *
 * @return An array of int to String mappings
 *
 * @see android.view.ViewDebug.IntToString
 */

public android.view.ViewDebug.IntToString[] mapping() default {};

/**
 * A mapping can be defined to map array indices to specific strings.
 * A mapping can be used to see human readable values for the indices
 * of an array:
 *
 * <pre>
 * {@literal @}ViewDebug.ExportedProperty(indexMapping = {
 *     {@literal @}ViewDebug.IntToString(from = 0, to = "INVALID"),
 *     {@literal @}ViewDebug.IntToString(from = 1, to = "FIRST"),
 *     {@literal @}ViewDebug.IntToString(from = 2, to = "SECOND")
 * })
 * private int[] mElements;
 * <pre>
 *
 * @return An array of int to String mappings
 *
 * @see android.view.ViewDebug.IntToString
 * @see #mapping()
 */

public android.view.ViewDebug.IntToString[] indexMapping() default {};

/**
 * A flags mapping can be defined to map flags encoded in an integer to
 * specific strings. A mapping can be used to see human readable values
 * for the flags of an integer:
 *
 * <pre>
 * {@literal @}ViewDebug.ExportedProperty(flagMapping = {
 *     {@literal @}ViewDebug.FlagToString(mask = ENABLED_MASK, equals = ENABLED,
 *             name = "ENABLED"),
 *     {@literal @}ViewDebug.FlagToString(mask = ENABLED_MASK, equals = DISABLED,
 *             name = "DISABLED"),
 * })
 * private int mFlags;
 * <pre>
 *
 * A specified String is output when the following is true:
 *
 * @return An array of int to String mappings
 */

public android.view.ViewDebug.FlagToString[] flagMapping() default {};

/**
 * When deep export is turned on, this property is not dumped. Instead, the
 * properties contained in this property are dumped. Each child property
 * is prefixed with the name of this property.
 *
 * @return true if the properties of this property should be dumped
 *
 * @see #prefix()
 */

public boolean deepExport() default false;

/**
 * The prefix to use on child properties when deep export is enabled
 *
 * @return a prefix as a String
 *
 * @see #deepExport()
 */

public java.lang.String prefix() default "";

/**
 * Specifies the category the property falls into, such as measurement,
 * layout, drawing, etc.
 *
 * @return the category as String
 */

public java.lang.String category() default "";

/**
 * Indicates whether or not to format an {@code int} or {@code byte} value as a hex string.
 *
 * @return true if the supported values should be formatted as a hex string.
 */

public boolean formatToHexString() default false;

/**
 * Indicates whether or not the key to value mappings are held in adjacent indices.
 *
 * Note: Applies only to fields and methods that return String[].
 *
 * @return true if the key to value mappings are held in adjacent indices.
 */

public boolean hasAdjacentMapping() default false;
}

/**
 * Defines a mapping from a flag to a String. Such a mapping can be used
 * in an @ExportedProperty to provide more meaningful values to the end user.
 *
 * @see android.view.ViewDebug.ExportedProperty
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE}) @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME) public static @interface FlagToString {

/**
 * The mask to apply to the original value.
 *
 * @return An arbitrary int value.
 */

public int mask();

/**
 * The value to compare to the result of:
 * <code>original value &amp; {@link #mask()}</code>.
 *
 * @return An arbitrary value.
 */

public int equals();

/**
 * The String to use in place of the original int value.
 *
 * @return An arbitrary non-null String.
 */

public java.lang.String name();

/**
 * Indicates whether to output the flag when the test is true,
 * or false. Defaults to true.
 */

public boolean outputIf() default true;
}

/**
 * @deprecated This enum is now unused
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public static enum HierarchyTraceType {
INVALIDATE, INVALIDATE_CHILD, INVALIDATE_CHILD_IN_PARENT, REQUEST_LAYOUT, ON_LAYOUT, ON_MEASURE, DRAW, BUILD_CACHE;
}

/**
 * Defines a mapping from an int value to a String. Such a mapping can be used
 * in an @ExportedProperty to provide more meaningful values to the end user.
 *
 * @see android.view.ViewDebug.ExportedProperty
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE}) @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME) public static @interface IntToString {

/**
 * The original int value to map to a String.
 *
 * @return An arbitrary int value.
 */

public int from();

/**
 * The String to use in place of the original int value.
 *
 * @return An arbitrary non-null String.
 */

public java.lang.String to();
}

/**
 * @deprecated This enum is now unused
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public static enum RecyclerTraceType {
NEW_VIEW, BIND_VIEW, RECYCLE_FROM_ACTIVE_HEAP, RECYCLE_FROM_SCRAP_HEAP, MOVE_TO_SCRAP_HEAP, MOVE_FROM_ACTIVE_TO_SCRAP_HEAP;
}

}

