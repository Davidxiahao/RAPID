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
 * Sets the text color, size, style, and typeface to match a TextAppearance
 * resource.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TextAppearanceSpan extends android.text.style.MetricAffectingSpan implements android.text.ParcelableSpan {

/**
 * Uses the specified TextAppearance resource to determine the
 * text appearance.  The <code>appearance</code> should be, for example,
 * <code>android.R.style.TextAppearance_Small</code>.
 */

public TextAppearanceSpan(android.content.Context context, int appearance) { throw new RuntimeException("Stub!"); }

/**
 * Uses the specified TextAppearance resource to determine the
 * text appearance, and the specified text color resource
 * to determine the color.  The <code>appearance</code> should be,
 * for example, <code>android.R.style.TextAppearance_Small</code>,
 * and the <code>colorList</code> should be, for example,
 * <code>android.R.styleable.Theme_textColorPrimary</code>.
 */

public TextAppearanceSpan(android.content.Context context, int appearance, int colorList) { throw new RuntimeException("Stub!"); }

/**
 * Makes text be drawn with the specified typeface, size, style,
 * and colors.
 */

public TextAppearanceSpan(java.lang.String family, int style, int size, android.content.res.ColorStateList color, android.content.res.ColorStateList linkColor) { throw new RuntimeException("Stub!"); }

public TextAppearanceSpan(android.os.Parcel src) { throw new RuntimeException("Stub!"); }

public int getSpanTypeId() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the typeface family specified by this span, or <code>null</code>
 * if it does not specify one.
 */

public java.lang.String getFamily() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text color specified by this span, or <code>null</code>
 * if it does not specify one.
 */

public android.content.res.ColorStateList getTextColor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the link color specified by this span, or <code>null</code>
 * if it does not specify one.
 */

public android.content.res.ColorStateList getLinkTextColor() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text size specified by this span, or <code>-1</code>
 * if it does not specify one.
 */

public int getTextSize() { throw new RuntimeException("Stub!"); }

/**
 * Returns the text style specified by this span, or <code>0</code>
 * if it does not specify one.
 */

public int getTextStyle() { throw new RuntimeException("Stub!"); }

public void updateDrawState(android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }

public void updateMeasureState(android.text.TextPaint ds) { throw new RuntimeException("Stub!"); }
}

