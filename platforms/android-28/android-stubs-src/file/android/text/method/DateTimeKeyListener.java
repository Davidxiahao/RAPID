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


package android.text.method;

import java.util.Locale;
import android.view.KeyEvent;

/**
 * For entering dates and times in the same text field.
 * <p></p>
 * As for all implementations of {@link KeyListener}, this class is only concerned
 * with hardware keyboards.  Software input methods have no obligation to trigger
 * the methods in this class.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class DateTimeKeyListener extends android.text.method.NumberKeyListener {

/**
 * @deprecated Use {@link #DateTimeKeyListener(Locale)} instead.
 */

@Deprecated public DateTimeKeyListener() { throw new RuntimeException("Stub!"); }

/**
 * @param locale This value may be {@code null}.
 */

public DateTimeKeyListener(@androidx.annotation.RecentlyNullable java.util.Locale locale) { throw new RuntimeException("Stub!"); }

public int getInputType() { throw new RuntimeException("Stub!"); }

/**
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull protected char[] getAcceptedChars() { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link #getInstance(Locale)} instead.

 * @return This value will never be {@code null}.
 */

@Deprecated @androidx.annotation.RecentlyNonNull public static android.text.method.DateTimeKeyListener getInstance() { throw new RuntimeException("Stub!"); }

/**
 * Returns an instance of DateTimeKeyListener appropriate for the given locale.
 
 * @param locale This value may be {@code null}.
 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public static android.text.method.DateTimeKeyListener getInstance(@androidx.annotation.RecentlyNullable java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * This field used to list the characters that were used. But is now a fixed data
 * field that is the list of code units used for the deprecated case where the class
 * is instantiated with null or no input parameter.
 *
 * @see KeyEvent#getMatch
 * @see #getAcceptedChars
 *
 * @deprecated Use {@link #getAcceptedChars()} instead.
 */

@Deprecated public static final char[] CHARACTERS;
static { CHARACTERS = new char[0]; }
}

