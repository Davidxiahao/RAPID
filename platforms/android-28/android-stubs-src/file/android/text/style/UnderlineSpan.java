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


package android.text.style;


/**
 * A span that underlines the text it's attached to.
 * <p>
 * The span can be used like this:
 * <pre>{@code
 * SpannableString string = new SpannableString("Text with underline span");
 *string.setSpan(new UnderlineSpan(), 10, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);}</pre>
 * <img src="{@docRoot}reference/android/images/text/style/underlinespan.png" />
 * <figcaption>Underlined text.</figcaption>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class UnderlineSpan extends android.text.style.CharacterStyle implements android.text.style.UpdateAppearance, android.text.ParcelableSpan {

/**
 * Creates an {@link UnderlineSpan}.
 */

public UnderlineSpan() { throw new RuntimeException("Stub!"); }

/**
 * Creates an {@link UnderlineSpan} from a parcel.

 * @param src This value must never be {@code null}.
 */

public UnderlineSpan(@androidx.annotation.RecentlyNonNull android.os.Parcel src) { throw new RuntimeException("Stub!"); }

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * @param dest This value must never be {@code null}.
 */

public void writeToParcel(@androidx.annotation.RecentlyNonNull android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * @param ds This value must never be {@code null}.
 */

public void updateDrawState(@androidx.annotation.RecentlyNonNull android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }
}

