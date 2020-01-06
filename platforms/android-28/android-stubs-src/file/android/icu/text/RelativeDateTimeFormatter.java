/* GENERATED SOURCE. DO NOT MODIFY. */
// © 2016 and later: Unicode, Inc. and others.
// License & terms of use: http://www.unicode.org/copyright.html#License
/*
 *******************************************************************************
 * Copyright (C) 2013-2016, International Business Machines Corporation and
 * others. All Rights Reserved.
 *******************************************************************************
 */

package android.icu.text;

import java.util.Locale;

/**
 * Formats simple relative dates. There are two types of relative dates that
 * it handles:
 * <ul>
 *   <li>relative dates with a quantity e.g "in 5 days"</li>
 *   <li>relative dates without a quantity e.g "next Tuesday"</li>
 * </ul>
 * <p>
 * This API is very basic and is intended to be a building block for more
 * fancy APIs. The caller tells it exactly what to display in a locale
 * independent way. While this class automatically provides the correct plural
 * forms, the grammatical form is otherwise as neutral as possible. It is the
 * caller's responsibility to handle cut-off logic such as deciding between
 * displaying "in 7 days" or "in 1 week." This API supports relative dates
 * involving one single unit. This API does not support relative dates
 * involving compound units.
 * e.g "in 5 days and 4 hours" nor does it support parsing.
 * This class is both immutable and thread-safe.
 * <p>
 * Here are some examples of use:
 * <blockquote>
 * <pre>
 * RelativeDateTimeFormatter fmt = RelativeDateTimeFormatter.getInstance();
 * fmt.format(1, Direction.NEXT, RelativeUnit.DAYS); // "in 1 day"
 * fmt.format(3, Direction.NEXT, RelativeUnit.DAYS); // "in 3 days"
 * fmt.format(3.2, Direction.LAST, RelativeUnit.YEARS); // "3.2 years ago"
 *
 * fmt.format(Direction.LAST, AbsoluteUnit.SUNDAY); // "last Sunday"
 * fmt.format(Direction.THIS, AbsoluteUnit.SUNDAY); // "this Sunday"
 * fmt.format(Direction.NEXT, AbsoluteUnit.SUNDAY); // "next Sunday"
 * fmt.format(Direction.PLAIN, AbsoluteUnit.SUNDAY); // "Sunday"
 *
 * fmt.format(Direction.LAST, AbsoluteUnit.DAY); // "yesterday"
 * fmt.format(Direction.THIS, AbsoluteUnit.DAY); // "today"
 * fmt.format(Direction.NEXT, AbsoluteUnit.DAY); // "tomorrow"
 *
 * fmt.format(Direction.PLAIN, AbsoluteUnit.NOW); // "now"
 * </pre>
 * </blockquote>
 * <p>
 * In the future, we may add more forms, such as abbreviated/short forms
 * (3 secs ago), and relative day periods ("yesterday afternoon"), etc.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class RelativeDateTimeFormatter {

RelativeDateTimeFormatter(java.util.EnumMap<android.icu.text.RelativeDateTimeFormatter.Style,java.util.EnumMap<android.icu.text.RelativeDateTimeFormatter.AbsoluteUnit,java.util.EnumMap<android.icu.text.RelativeDateTimeFormatter.Direction,java.lang.String>>> qualitativeUnitMap, java.util.EnumMap<android.icu.text.RelativeDateTimeFormatter.Style,java.util.EnumMap<android.icu.text.RelativeDateTimeFormatter.RelativeUnit,java.lang.String[][]>> patternMap, java.lang.String combinedDateAndTime, android.icu.text.PluralRules pluralRules, android.icu.text.NumberFormat numberFormat, android.icu.text.RelativeDateTimeFormatter.Style style, android.icu.text.DisplayContext capitalizationContext, android.icu.text.BreakIterator breakIterator, android.icu.util.ULocale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a RelativeDateTimeFormatter for the default locale.
 */

public static android.icu.text.RelativeDateTimeFormatter getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns a RelativeDateTimeFormatter for a particular locale.
 *
 * @param locale the locale.
 * @return An instance of RelativeDateTimeFormatter.
 */

public static android.icu.text.RelativeDateTimeFormatter getInstance(android.icu.util.ULocale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a RelativeDateTimeFormatter for a particular {@link java.util.Locale}.
 *
 * @param locale the {@link java.util.Locale}.
 * @return An instance of RelativeDateTimeFormatter.
 */

public static android.icu.text.RelativeDateTimeFormatter getInstance(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a RelativeDateTimeFormatter for a particular locale that uses a particular
 * NumberFormat object.
 *
 * @param locale the locale
 * @param nf the number format object. It is defensively copied to ensure thread-safety
 * and immutability of this class.
 * @return An instance of RelativeDateTimeFormatter.
 */

public static android.icu.text.RelativeDateTimeFormatter getInstance(android.icu.util.ULocale locale, android.icu.text.NumberFormat nf) { throw new RuntimeException("Stub!"); }

/**
 * Returns a RelativeDateTimeFormatter for a particular locale that uses a particular
 * NumberFormat object, style, and capitalization context
 *
 * @param locale the locale
 * @param nf the number format object. It is defensively copied to ensure thread-safety
 * and immutability of this class. May be null.
 * @param style the style.
 * @param capitalizationContext the capitalization context.
 */

public static android.icu.text.RelativeDateTimeFormatter getInstance(android.icu.util.ULocale locale, android.icu.text.NumberFormat nf, android.icu.text.RelativeDateTimeFormatter.Style style, android.icu.text.DisplayContext capitalizationContext) { throw new RuntimeException("Stub!"); }

/**
 * Returns a RelativeDateTimeFormatter for a particular {@link java.util.Locale} that uses a
 * particular NumberFormat object.
 *
 * @param locale the {@link java.util.Locale}
 * @param nf the number format object. It is defensively copied to ensure thread-safety
 * and immutability of this class.
 * @return An instance of RelativeDateTimeFormatter.
 */

public static android.icu.text.RelativeDateTimeFormatter getInstance(java.util.Locale locale, android.icu.text.NumberFormat nf) { throw new RuntimeException("Stub!"); }

/**
 * Formats a relative date with a quantity such as "in 5 days" or
 * "3 months ago"
 * @param quantity The numerical amount e.g 5. This value is formatted
 * according to this object's {@link NumberFormat} object.
 * @param direction NEXT means a future relative date; LAST means a past
 * relative date.
 * @param unit the unit e.g day? month? year?
 * @return the formatted string
 * @throws IllegalArgumentException if direction is something other than
 * NEXT or LAST.
 */

public java.lang.String format(double quantity, android.icu.text.RelativeDateTimeFormatter.Direction direction, android.icu.text.RelativeDateTimeFormatter.RelativeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Format a combination of RelativeDateTimeUnit and numeric offset
 * using a numeric style, e.g.&nbsp;"1 week ago", "in 1 week",
 * "5 weeks ago", "in 5 weeks".
 *
 * @param offset    The signed offset for the specified unit. This
 *                  will be formatted according to this object's
 *                  NumberFormat object.
 * @param unit      The unit to use when formatting the relative
 *                  date, e.g. RelativeDateTimeUnit.WEEK,
 *                  RelativeDateTimeUnit.FRIDAY.
 * @return          The formatted string (may be empty in case of error)
 */

public java.lang.String formatNumeric(double offset, android.icu.text.RelativeDateTimeFormatter.RelativeDateTimeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Formats a relative date without a quantity.
 * @param direction NEXT, LAST, THIS, etc.
 * @param unit e.g SATURDAY, DAY, MONTH
 * @return the formatted string. If direction has a value that is documented as not being
 *  fully supported in every locale (for example NEXT_2 or LAST_2) then this function may
 *  return null to signal that no formatted string is available.
 * @throws IllegalArgumentException if the direction is incompatible with
 * unit this can occur with NOW which can only take PLAIN.
 */

public java.lang.String format(android.icu.text.RelativeDateTimeFormatter.Direction direction, android.icu.text.RelativeDateTimeFormatter.AbsoluteUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Format a combination of RelativeDateTimeUnit and numeric offset
 * using a text style if possible, e.g.&nbsp;"last week", "this week",
 * "next week", "yesterday", "tomorrow". Falls back to numeric
 * style if no appropriate text term is available for the specified
 * offset in the object’s locale.
 *
 * @param offset    The signed offset for the specified field.
 * @param unit      The unit to use when formatting the relative
 *                  date, e.g. RelativeDateTimeUnit.WEEK,
 *                  RelativeDateTimeUnit.FRIDAY.
 * @return          The formatted string (may be empty in case of error)
 */

public java.lang.String format(double offset, android.icu.text.RelativeDateTimeFormatter.RelativeDateTimeUnit unit) { throw new RuntimeException("Stub!"); }

/**
 * Combines a relative date string and a time string in this object's
 * locale. This is done with the same date-time separator used for the
 * default calendar in this locale.
 * @param relativeDateString the relative date e.g 'yesterday'
 * @param timeString the time e.g '3:45'
 * @return the date and time concatenated according to the default
 * calendar in this locale e.g 'yesterday, 3:45'
 */

public java.lang.String combineDateAndTime(java.lang.String relativeDateString, java.lang.String timeString) { throw new RuntimeException("Stub!"); }

/**
 * Returns a copy of the NumberFormat this object is using.
 * @return A copy of the NumberFormat.
 */

public android.icu.text.NumberFormat getNumberFormat() { throw new RuntimeException("Stub!"); }

/**
 * Return capitalization context.
 * @return The capitalization context.
 */

public android.icu.text.DisplayContext getCapitalizationContext() { throw new RuntimeException("Stub!"); }

/**
 * Return style
 * @return The formatting style.
 */

public android.icu.text.RelativeDateTimeFormatter.Style getFormatStyle() { throw new RuntimeException("Stub!"); }
/**
 * Represents an absolute unit.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum AbsoluteUnit {
SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, DAY, WEEK, MONTH, YEAR, NOW, QUARTER;
}

/**
 * Represents a direction for an absolute unit e.g "Next Tuesday"
 * or "Last Tuesday"
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Direction {
LAST_2, LAST, THIS, NEXT, NEXT_2, PLAIN;
}

/**
 * Represents the unit for formatting a relative date. e.g "in 5 days"
 * or "next year"
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum RelativeDateTimeUnit {
YEAR, QUARTER, MONTH, WEEK, DAY, HOUR, MINUTE, SECOND, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

/**
 * Represents the unit for formatting a relative date. e.g "in 5 days"
 * or "in 3 months"
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum RelativeUnit {
SECONDS, MINUTES, HOURS, DAYS, WEEKS, MONTHS, YEARS, QUARTERS;
}

/**
 * The formatting style
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static enum Style {
LONG, SHORT, NARROW;
}

}

