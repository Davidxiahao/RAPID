/* GENERATED SOURCE. DO NOT MODIFY. */
// © 2016 and later: Unicode, Inc. and others.
// License & terms of use: http://www.unicode.org/copyright.html#License
/*
 *******************************************************************************
 * Copyright (C) 2012-2015, International Business Machines Corporation and    *
 * others. All Rights Reserved.                                                *
 *******************************************************************************
 */

package android.icu.text;


/**
 * Display context settings.
 * Note, the specific numeric values are internal and may change.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public enum DisplayContext {
STANDARD_NAMES, DIALECT_NAMES, CAPITALIZATION_NONE, CAPITALIZATION_FOR_MIDDLE_OF_SENTENCE, CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE, CAPITALIZATION_FOR_UI_LIST_OR_MENU, CAPITALIZATION_FOR_STANDALONE, LENGTH_FULL, LENGTH_SHORT, SUBSTITUTE, NO_SUBSTITUTE;

/**
 * Get the Type part of the enum item
 * (e.g.&nbsp;CAPITALIZATION)
 */

public android.icu.text.DisplayContext.Type type() { throw new RuntimeException("Stub!"); }

/**
 * Get the value part of the enum item
 * (e.g.&nbsp;CAPITALIZATION_FOR_STANDALONE)
 */

public int value() { throw new RuntimeException("Stub!"); }
/**
 * Type values for DisplayContext
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Type {
DIALECT_HANDLING, CAPITALIZATION, DISPLAY_LENGTH, SUBSTITUTE_HANDLING;
}

}

