/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.util;


/**
 * A class containing utility methods related to time zones.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TimeUtils {

/** @hide */

TimeUtils() { throw new RuntimeException("Stub!"); }

/**
 * Tries to return a time zone that would have had the specified offset
 * and DST value at the specified moment in the specified country.
 * Returns null if no suitable zone could be found.
 */

public static java.util.TimeZone getTimeZone(int offset, boolean dst, long when, java.lang.String country) { throw new RuntimeException("Stub!"); }

/**
 * Returns a String indicating the version of the time zone database currently
 * in use.  The format of the string is dependent on the underlying time zone
 * database implementation, but will typically contain the year in which the database
 * was updated plus a letter from a to z indicating changes made within that year.
 *
 * <p>Time zone database updates should be expected to occur periodically due to
 * political and legal changes that cannot be anticipated in advance.  Therefore,
 * when computing the UTC time for a future event, applications should be aware that
 * the results may differ following a time zone database update.  This method allows
 * applications to detect that a database change has occurred, and to recalculate any
 * cached times accordingly.
 *
 * <p>The time zone database may be assumed to change only when the device runtime
 * is restarted.  Therefore, it is not necessary to re-query the database version
 * during the lifetime of an activity.
 */

public static java.lang.String getTimeZoneDatabaseVersion() { throw new RuntimeException("Stub!"); }
}

