/* GENERATED SOURCE. DO NOT MODIFY. */
// © 2016 and later: Unicode, Inc. and others.
// License & terms of use: http://www.unicode.org/copyright.html#License
/*
 *******************************************************************************
 * Copyright (C) 2012-2016, Google, International Business Machines Corporation and
 * others. All Rights Reserved.
 *******************************************************************************
 */

package android.icu.text;


/**
 * Immutable class for formatting a list, using data from CLDR (or supplied
 * separately). The class is not subclassable.
 *
 * @author Mark Davis
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class ListFormatter {

/**
 * <b>Internal:</b> Create a ListFormatter from component strings,
 * with definitions as in LDML.
 *
 * @param two
 *            string for two items, containing {0} for the first, and {1}
 *            for the second.
 * @param start
 *            string for the start of a list items, containing {0} for the
 *            first, and {1} for the rest.
 * @param middle
 *            string for the start of a list items, containing {0} for the
 *            first part of the list, and {1} for the rest of the list.
 * @param end
 *            string for the end of a list items, containing {0} for the
 *            first part of the list, and {1} for the last item.
 * @deprecated This API is ICU internal only.
 * @hide draft / provisional / internal are hidden on Android
 */

@Deprecated ListFormatter(java.lang.String two, java.lang.String start, java.lang.String middle, java.lang.String end) { throw new RuntimeException("Stub!"); }

/**
 * Create a list formatter that is appropriate for a locale.
 *
 * @param locale
 *            the locale in question.
 * @return ListFormatter
 */

public static android.icu.text.ListFormatter getInstance(android.icu.util.ULocale locale) { throw new RuntimeException("Stub!"); }

/**
 * Create a list formatter that is appropriate for a locale.
 *
 * @param locale
 *            the locale in question.
 * @return ListFormatter
 */

public static android.icu.text.ListFormatter getInstance(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Create a list formatter that is appropriate for the default FORMAT locale.
 *
 * @return ListFormatter
 */

public static android.icu.text.ListFormatter getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Format a list of objects.
 *
 * @param items
 *            items to format. The toString() method is called on each.
 * @return items formatted into a string
 */

public java.lang.String format(java.lang.Object... items) { throw new RuntimeException("Stub!"); }

/**
 * Format a collection of objects. The toString() method is called on each.
 *
 * @param items
 *            items to format. The toString() method is called on each.
 * @return items formatted into a string
 */

public java.lang.String format(java.util.Collection<?> items) { throw new RuntimeException("Stub!"); }

/**
 * Returns the pattern to use for a particular item count.
 * @param count the item count.
 * @return the pattern with {0}, {1}, {2}, etc. For English,
 * getPatternForNumItems(3) == "{0}, {1}, and {2}"
 * @throws IllegalArgumentException when count is 0 or negative.
 */

public java.lang.String getPatternForNumItems(int count) { throw new RuntimeException("Stub!"); }
}

