/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.graphics.drawable;

import android.graphics.Outline;
import android.graphics.Paint;

/**
 * Drawable that shows a ripple effect in response to state changes. The
 * anchoring position of the ripple for a given state may be specified by
 * calling {@link #setHotspot(float, float)} with the corresponding state
 * attribute identifier.
 * <p>
 * A touch feedback drawable may contain multiple child layers, including a
 * special mask layer that is not drawn to the screen. A single layer may be
 * set as the mask from XML by specifying its {@code android:id} value as
 * {@link android.R.id#mask}. At run time, a single layer may be set as the
 * mask using {@code setId(..., android.R.id.mask)} or an existing mask layer
 * may be replaced using {@code setDrawableByLayerId(android.R.id.mask, ...)}.
 * <pre>
 * <code>&lt;!-- A red ripple masked against an opaque rectangle. --/>
 * &lt;ripple android:color="#ffff0000">
 *   &lt;item android:id="@android:id/mask"
 *         android:drawable="@android:color/white" />
 * &lt;/ripple></code>
 * </pre>
 * <p>
 * If a mask layer is set, the ripple effect will be masked against that layer
 * before it is drawn over the composite of the remaining child layers.
 * <p>
 * If no mask layer is set, the ripple effect is masked against the composite
 * of the child layers.
 * <pre>
 * <code>&lt;!-- A green ripple drawn atop a black rectangle. --/>
 * &lt;ripple android:color="#ff00ff00">
 *   &lt;item android:drawable="@android:color/black" />
 * &lt;/ripple>
 *
 * &lt;!-- A blue ripple drawn atop a drawable resource. --/>
 * &lt;ripple android:color="#ff0000ff">
 *   &lt;item android:drawable="@drawable/my_drawable" />
 * &lt;/ripple></code>
 * </pre>
 * <p>
 * If no child layers or mask is specified and the ripple is set as a View
 * background, the ripple will be drawn atop the first available parent
 * background within the View's hierarchy. In this case, the drawing region
 * may extend outside of the Drawable bounds.
 * <pre>
 * <code>&lt;!-- An unbounded red ripple. --/>
 * &lt;ripple android:color="#ffff0000" /></code>
 * </pre>
 *
 * @attr ref android.R.styleable#RippleDrawable_color
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RippleDrawable extends android.graphics.drawable.LayerDrawable {

/**
 * Creates a new ripple drawable with the specified ripple color and
 * optional content and mask drawables.
 *
 * @param color The ripple color
 * This value must never be {@code null}.
 * @param content The content drawable, may be {@code null}
 * This value may be {@code null}.
 * @param mask The mask drawable, may be {@code null}

 * This value may be {@code null}.
 */

public RippleDrawable(@androidx.annotation.RecentlyNonNull android.content.res.ColorStateList color, @androidx.annotation.RecentlyNullable android.graphics.drawable.Drawable content, @androidx.annotation.RecentlyNullable android.graphics.drawable.Drawable mask) { super(null); throw new RuntimeException("Stub!"); }

public void jumpToCurrentState() { throw new RuntimeException("Stub!"); }

public int getOpacity() { throw new RuntimeException("Stub!"); }

protected boolean onStateChange(int[] stateSet) { throw new RuntimeException("Stub!"); }

protected void onBoundsChange(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

public boolean setVisible(boolean visible, boolean restart) { throw new RuntimeException("Stub!"); }

public boolean isStateful() { throw new RuntimeException("Stub!"); }

/**
 * Sets the ripple color.
 *
 * @param color Ripple color as a color state list.
 *
 * @attr ref android.R.styleable#RippleDrawable_color
 */

public void setColor(android.content.res.ColorStateList color) { throw new RuntimeException("Stub!"); }

/**
 * Sets the radius in pixels of the fully expanded ripple.
 *
 * @param radius ripple radius in pixels, or {@link #RADIUS_AUTO} to
 *               compute the radius based on the container size
 * @attr ref android.R.styleable#RippleDrawable_radius
 */

public void setRadius(int radius) { throw new RuntimeException("Stub!"); }

/**
 * @return the radius in pixels of the fully expanded ripple if an explicit
 *         radius has been set, or {@link #RADIUS_AUTO} if the radius is
 *         computed based on the container size
 * @attr ref android.R.styleable#RippleDrawable_radius
 */

public int getRadius() { throw new RuntimeException("Stub!"); }

/**
 * @param r This value must never be {@code null}.

 * @param parser This value must never be {@code null}.
 
 * @param attrs This value must never be {@code null}.

 * @param theme This value may be {@code null}.
 */

public void inflate(@androidx.annotation.RecentlyNonNull android.content.res.Resources r, @androidx.annotation.RecentlyNonNull org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.RecentlyNonNull android.util.AttributeSet attrs, @androidx.annotation.RecentlyNullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

public boolean setDrawableByLayerId(int id, android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Specifies how layer padding should affect the bounds of subsequent
 * layers. The default and recommended value for RippleDrawable is
 * {@link #PADDING_MODE_STACK}.
 *
 * @param mode padding mode, one of:
 *            <ul>
 *            <li>{@link #PADDING_MODE_NEST} to nest each layer inside the
 *            padding of the previous layer
 *            <li>{@link #PADDING_MODE_STACK} to stack each layer directly
 *            atop the previous layer
 *            </ul>
 * @see #getPaddingMode()
 */

public void setPaddingMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * @param t This value must never be {@code null}.
 */

public void applyTheme(@androidx.annotation.RecentlyNonNull android.content.res.Resources.Theme t) { throw new RuntimeException("Stub!"); }

public boolean canApplyTheme() { throw new RuntimeException("Stub!"); }

public void setHotspot(float x, float y) { throw new RuntimeException("Stub!"); }

public void setHotspotBounds(int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

public void getHotspotBounds(android.graphics.Rect outRect) { throw new RuntimeException("Stub!"); }

/**
 * Populates <code>outline</code> with the first available layer outline,
 * excluding the mask layer.
 *
 * @param outline Outline in which to place the first available layer outline

 * This value must never be {@code null}.
 */

public void getOutline(@androidx.annotation.RecentlyNonNull android.graphics.Outline outline) { throw new RuntimeException("Stub!"); }

/**
 * Optimized for drawing ripples with a mask layer and optional content.

 * @param canvas This value must never be {@code null}.
 */

public void draw(@androidx.annotation.RecentlyNonNull android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

public void invalidateSelf() { throw new RuntimeException("Stub!"); }

public android.graphics.Rect getDirtyBounds() { throw new RuntimeException("Stub!"); }

public android.graphics.drawable.Drawable.ConstantState getConstantState() { throw new RuntimeException("Stub!"); }

public android.graphics.drawable.Drawable mutate() { throw new RuntimeException("Stub!"); }

/**
 * Radius value that specifies the ripple radius should be computed based
 * on the size of the ripple's container.
 */

public static final int RADIUS_AUTO = -1; // 0xffffffff
}

