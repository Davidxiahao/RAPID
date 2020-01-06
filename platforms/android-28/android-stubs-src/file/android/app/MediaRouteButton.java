/*
 * Copyright (C) 2012 The Android Open Source Project
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


package android.app;


@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaRouteButton extends android.view.View {

public MediaRouteButton(android.content.Context context) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public MediaRouteButton(android.content.Context context, android.util.AttributeSet attrs) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public MediaRouteButton(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

public MediaRouteButton(android.content.Context context, android.util.AttributeSet attrs, int defStyleAttr, int defStyleRes) { super((android.content.Context)null); throw new RuntimeException("Stub!"); }

/**
 * Gets the media route types for filtering the routes that the user can
 * select using the media route chooser dialog.
 *
 * @return The route types.
 */

public int getRouteTypes() { throw new RuntimeException("Stub!"); }

/**
 * Sets the types of routes that will be shown in the media route chooser dialog
 * launched by this button.
 *
 * @param types The route types to match.
 */

public void setRouteTypes(int types) { throw new RuntimeException("Stub!"); }

public void setExtendedSettingsClickListener(android.view.View.OnClickListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Show the route chooser or controller dialog.
 * <p>
 * If the default route is selected or if the currently selected route does
 * not match the {@link #getRouteTypes route types}, then shows the route chooser dialog.
 * Otherwise, shows the route controller dialog to offer the user
 * a choice to disconnect from the route or perform other control actions
 * such as setting the route's volume.
 * </p><p>
 * This will attach a {@link DialogFragment} to the containing Activity.
 * </p>
 */

public void showDialog() { throw new RuntimeException("Stub!"); }

public void setContentDescription(java.lang.CharSequence contentDescription) { throw new RuntimeException("Stub!"); }

public boolean performClick() { throw new RuntimeException("Stub!"); }

protected int[] onCreateDrawableState(int extraSpace) { throw new RuntimeException("Stub!"); }

protected void drawableStateChanged() { throw new RuntimeException("Stub!"); }

/**
 * @param who This value must never be {@code null}.
 */

protected boolean verifyDrawable(@androidx.annotation.RecentlyNonNull android.graphics.drawable.Drawable who) { throw new RuntimeException("Stub!"); }

public void jumpDrawablesToCurrentState() { throw new RuntimeException("Stub!"); }

public void setVisibility(int visibility) { throw new RuntimeException("Stub!"); }

public void onAttachedToWindow() { throw new RuntimeException("Stub!"); }

public void onDetachedFromWindow() { throw new RuntimeException("Stub!"); }

protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) { throw new RuntimeException("Stub!"); }

protected void onDraw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }
}

