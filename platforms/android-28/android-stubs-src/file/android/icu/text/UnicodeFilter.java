/* GENERATED SOURCE. DO NOT MODIFY. */
// © 2016 and later: Unicode, Inc. and others.
// License & terms of use: http://www.unicode.org/copyright.html#License
/*
 *******************************************************************************
 * Copyright (C) 1996-2016, International Business Machines Corporation and    *
 * others. All Rights Reserved.                                                *
 *******************************************************************************
 */

package android.icu.text;


/**
 * <code>UnicodeFilter</code> defines a protocol for selecting a
 * subset of the full range (U+0000 to U+FFFF) of Unicode characters.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class UnicodeFilter implements android.icu.text.UnicodeMatcher {

/**
 * (This should not be here; it is declared to make CheckTags
 * happy.  Java inserts a synthetic constructor and CheckTags
 * can't tell that it's synthetic.)
 *
 * @deprecated This API is ICU internal only.
 * @hide original deprecated declaration
 * @hide draft / provisional / internal are hidden on Android
 */

@Deprecated UnicodeFilter() { throw new RuntimeException("Stub!"); }

/**
 * Returns <tt>true</tt> for characters that are in the selected
 * subset.  In other words, if a character is <b>to be
 * filtered</b>, then <tt>contains()</tt> returns
 * <b><tt>false</tt></b>.
 */

public abstract boolean contains(int c);

/**
 * Default implementation of UnicodeMatcher::matches() for Unicode
 * filters.  Matches a single 16-bit code unit at offset.
 */

public int matches(android.icu.text.Replaceable text, int[] offset, int limit, boolean incremental) { throw new RuntimeException("Stub!"); }
}

