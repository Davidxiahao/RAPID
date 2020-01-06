/*
 * Copyright (C) 2007 The Android Open Source Project
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


package android.widget;

import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff;
import android.content.res.ColorStateList;

/**
 * <p>
 * A button with two states, checked and unchecked. When the button is pressed
 * or clicked, the state changes automatically.
 * </p>
 *
 * <p><strong>XML attributes</strong></p>
 * <p>
 * See {@link android.R.styleable#CompoundButton
 * CompoundButton Attributes}, {@link android.R.styleable#Button Button
 * Attributes}, {@link android.R.styleable#TextView TextView Attributes}, {@link
 * android.R.styleable#View View Attributes}
 * </p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class CompoundButton extends android.widget.Button implements android.widget.Checkable {

public CompoundButton(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public CompoundButton(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public CompoundButton(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public CompoundButton(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public void toggle() { throw new RuntimeException("Stub!"); }

public boolean performClick() { throw new RuntimeException("Stub!"); }

@android.view.ViewDebug.ExportedProperty public boolean isChecked() { throw new RuntimeException("Stub!"); }

/**
 * <p>Changes the checked state of this button.</p>
 *
 * @param checked true to check the button, false to uncheck it
 */

public void setChecked(boolean checked) { throw new RuntimeException("Stub!"); }

/**
 * Register a callback to be invoked when the checked state of this button
 * changes.
 *
 * @param listener the callback to call on checked state change

 * This value may be {@code null}.
 */

public void setOnCheckedChangeListener(@androidx.annotation.RecentlyNullable android.widget.CompoundButton.OnCheckedChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Sets a drawable as the compound button image given its resource
 * identifier.
 *
 * @param resId the resource identifier of the drawable
 * @attr ref android.R.styleable#CompoundButton_button
 */

public void setButtonDrawable(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Sets a drawable as the compound button image.
 *
 * @param drawable the drawable to set
 * This value may be {@code null}.
 * @attr ref android.R.styleable#CompoundButton_button
 */

public void setButtonDrawable(@androidx.annotation.RecentlyNullable android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * @return the drawable used as the compound button image
 * This value may be {@code null}.
 * @see #setButtonDrawable(Drawable)
 * @see #setButtonDrawable(int)
 */

@androidx.annotation.RecentlyNullable public android.graphics.drawable.Drawable getButtonDrawable() { throw new RuntimeException("Stub!"); }

/**
 * Applies a tint to the button drawable. Does not modify the current tint
 * mode, which is {@link PorterDuff.Mode#SRC_IN} by default.
 * <p>
 * Subsequent calls to {@link #setButtonDrawable(Drawable)} will
 * automatically mutate the drawable and apply the specified tint and tint
 * mode using
 * {@link Drawable#setTintList(ColorStateList)}.
 *
 * @param tint the tint to apply, may be {@code null} to clear tint
 *
 * This value may be {@code null}.
 * @attr ref android.R.styleable#CompoundButton_buttonTint
 * @see #setButtonTintList(ColorStateList)
 * @see Drawable#setTintList(ColorStateList)
 */

public void setButtonTintList(@androidx.annotation.RecentlyNullable android.content.res.ColorStateList tint) { throw new RuntimeException("Stub!"); }

/**
 * @return the tint applied to the button drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#CompoundButton_buttonTint
 * @see #setButtonTintList(ColorStateList)
 */

@androidx.annotation.RecentlyNullable public android.content.res.ColorStateList getButtonTintList() { throw new RuntimeException("Stub!"); }

/**
 * Specifies the blending mode used to apply the tint specified by
 * {@link #setButtonTintList(ColorStateList)}} to the button drawable. The
 * default mode is {@link PorterDuff.Mode#SRC_IN}.
 *
 * @param tintMode the blending mode used to apply the tint, may be
 *                 {@code null} to clear tint
 * This value may be {@code null}.
 * @attr ref android.R.styleable#CompoundButton_buttonTintMode
 * @see #getButtonTintMode()
 * @see Drawable#setTintMode(PorterDuff.Mode)
 */

public void setButtonTintMode(@androidx.annotation.RecentlyNullable android.graphics.PorterDuff.Mode tintMode) { throw new RuntimeException("Stub!"); }

/**
 * @return the blending mode used to apply the tint to the button drawable
 * This value may be {@code null}.
 * @attr ref android.R.styleable#CompoundButton_buttonTintMode
 * @see #setButtonTintMode(PorterDuff.Mode)
 */

@androidx.annotation.RecentlyNullable public android.graphics.PorterDuff.Mode getButtonTintMode() { throw new RuntimeException("Stub!"); }

public java.lang.CharSequence getAccessibilityClassName() { throw new RuntimeException("Stub!"); }

public int getCompoundPaddingLeft() { throw new RuntimeException("Stub!"); }

public int getCompoundPaddingRight() { throw new RuntimeException("Stub!"); }

protected void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

protected int[] onCreateDrawableState(int extraSpace) { throw new RuntimeException("Stub!"); }

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

public void drawableHotspotChanged(float x, float y) { throw new RuntimeException("Stub!"); }

/**
 * @param who This value must never be {@code null}.
 */

protected boolean verifyDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

public void jumpDrawablesToCurrentState() { throw new RuntimeException("Stub!"); }

public android.os.Parcelable onSaveInstanceState() { throw new RuntimeException("Stub!"); }

public void onRestoreInstanceState(android.os.Parcelable state) { throw new RuntimeException("Stub!"); }

public void onProvideAutofillStructure(android.view.ViewStructure structure, int flags) { throw new RuntimeException("Stub!"); }

public void autofill(android.view.autofill.AutofillValue value) { throw new RuntimeException("Stub!"); }

/**
 * @return Value is {@link android.view.View#AUTOFILL_TYPE_NONE}, {@link android.view.View#AUTOFILL_TYPE_TEXT}, {@link android.view.View#AUTOFILL_TYPE_TOGGLE}, {@link android.view.View#AUTOFILL_TYPE_LIST}, or {@link android.view.View#AUTOFILL_TYPE_DATE}
 */

public int getAutofillType() { throw new RuntimeException("Stub!"); }

public android.view.autofill.AutofillValue getAutofillValue() { throw new RuntimeException("Stub!"); }
/**
 * Interface definition for a callback to be invoked when the checked state
 * of a compound button changed.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnCheckedChangeListener {

/**
 * Called when the checked state of a compound button has changed.
 *
 * @param buttonView The compound button view whose state has changed.
 * @param isChecked  The new checked state of buttonView.
 */

public void onCheckedChanged(android.widget.CompoundButton buttonView, boolean isChecked);
}

}

