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


package android.text;


/**
 * This is the class for text whose content is immutable but to which
 * markup objects can be attached and detached.
 * For mutable text, see {@link SpannableStringBuilder}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SpannableString implements java.lang.CharSequence, android.text.GetChars, android.text.Spannable {

/**
 * For the backward compatibility reasons, this constructor copies all spans including {@link
 * android.text.NoCopySpan}.
 * @param source source text
 */

public SpannableString(java.lang.CharSequence source) { throw new RuntimeException("Stub!"); }

public static android.text.SpannableString valueOf(java.lang.CharSequence source) { throw new RuntimeException("Stub!"); }

public void setSpan(java.lang.Object what, int start, int end, int flags) { throw new RuntimeException("Stub!"); }

public void removeSpan(java.lang.Object what) { throw new RuntimeException("Stub!"); }

public final java.lang.CharSequence subSequence(int start, int end) { throw new RuntimeException("Stub!"); }

public final void getChars(int start, int end, char[] dest, int off) { throw new RuntimeException("Stub!"); }

public final int length() { throw new RuntimeException("Stub!"); }

public int getSpanStart(java.lang.Object what) { throw new RuntimeException("Stub!"); }

public int getSpanFlags(java.lang.Object what) { throw new RuntimeException("Stub!"); }

public int nextSpanTransition(int start, int limit, java.lang.Class kind) { throw new RuntimeException("Stub!"); }

public <T> T[] getSpans(int queryStart, int queryEnd, java.lang.Class<T> kind) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int getSpanEnd(java.lang.Object what) { throw new RuntimeException("Stub!"); }

public final java.lang.String toString() { throw new RuntimeException("Stub!"); }

public final char charAt(int i) { throw new RuntimeException("Stub!"); }
}

