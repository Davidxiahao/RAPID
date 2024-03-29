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


package android.text.style;


/**
 * A span that changes the size of the text it's attached to.
 * <p>
 * For example, the size of the text can be changed to 55dp like this:
 * <pre>{@code
 * SpannableString string = new SpannableString("Text with absolute size span");
 *string.setSpan(new AbsoluteSizeSpan(55, true), 10, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/absolutesizespan.png" />
 * <figcaption>Text with text size updated.</figcaption>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AbsoluteSizeSpan extends android.text.style.MetricAffectingSpan implements android.text.ParcelableSpan {

/**
 * Set the text size to <code>size</code> physical pixels.
 */

public AbsoluteSizeSpan(int size) { throw new RuntimeException("Stub!"); }

/**
 * Set the text size to <code>size</code> physical pixels, or to <code>size</code>
 * device-independent pixels if <code>dip</code> is true.
 */

public AbsoluteSizeSpan(int size, boolean dip) { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@link AbsoluteSizeSpan} from a parcel.

 * @param src This value must never be {@code null}.
 */

public AbsoluteSizeSpan(@androidx.annotation.RecentlyNonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @param dest This value must never be {@code null}.
 */

public void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Get the text size. This is in physical pixels if {@link #getDip()} returns false or in
 * device-independent pixels if {@link #getDip()} returns true.
 *
 * @return the text size, either in physical pixels or device-independent pixels.
 * @see AbsoluteSizeSpan#AbsoluteSizeSpan(int, boolean)
 */

public int getSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the size is in device-independent pixels or not, depending on the
 * <code>dip</code> flag passed in {@link #AbsoluteSizeSpan(int, boolean)}
 *
 * @return <code>true</code> if the size is in device-independent pixels, <code>false</code>
 * otherwise
 *
 * @see #AbsoluteSizeSpan(int, boolean)
 */

public boolean getDip() { throw new RuntimeException("Stub!"); }

/**
 * @param ds This value must never be {@code null}.
 */

public void updateDrawState(@androidx.annotation.RecentlyNonNull android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }

/**
 * @param ds This value must never be {@code null}.
 */

public void updateMeasureState(@androidx.annotation.RecentlyNonNull android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }
}

