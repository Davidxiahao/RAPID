/*
 * Copyright (C) 2010 The Android Open Source Project
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

import android.graphics.Canvas;
import android.content.Context;

/**
 * This class performs the graphical effect used at the edges of scrollable widgets
 * when the user scrolls beyond the content bounds in 2D space.
 *
 * <p>EdgeEffect is stateful. Custom widgets using EdgeEffect should create an
 * instance for each edge that should show the effect, feed it input data using
 * the methods {@link #onAbsorb(int)}, {@link #onPull(float)}, and {@link #onRelease()},
 * and draw the effect using {@link #draw(Canvas)} in the widget's overridden
 * {@link android.view.View#draw(Canvas)} method. If {@link #isFinished()} returns
 * false after drawing, the edge effect's animation is not yet complete and the widget
 * should schedule another drawing pass to continue the animation.</p>
 *
 * <p>When drawing, widgets should draw their main content and child views first,
 * usually by invoking <code>super.draw(canvas)</code> from an overridden <code>draw</code>
 * method. (This will invoke onDraw and dispatch drawing to child views as needed.)
 * The edge effect may then be drawn on top of the view's content using the
 * {@link #draw(Canvas)} method.</p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class EdgeEffect {

/**
 * Construct a new EdgeEffect with a theme appropriate for the provided context.
 * @param context Context used to provide theming and resource information for the EdgeEffect
 */

public EdgeEffect(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Set the size of this edge effect in pixels.
 *
 * @param width Effect width in pixels
 * @param height Effect height in pixels
 */

public void setSize(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Reports if this EdgeEffect's animation is finished. If this method returns false
 * after a call to {@link #draw(Canvas)} the host widget should schedule another
 * drawing pass to continue the animation.
 *
 * @return true if animation is finished, false if drawing should continue on the next frame.
 */

public boolean isFinished() { throw new RuntimeException("Stub!"); }

/**
 * Immediately finish the current animation.
 * After this call {@link #isFinished()} will return true.
 */

public void finish() { throw new RuntimeException("Stub!"); }

/**
 * A view should call this when content is pulled away from an edge by the user.
 * This will update the state of the current visual effect and its associated animation.
 * The host view should always {@link android.view.View#invalidate()} after this
 * and draw the results accordingly.
 *
 * <p>Views using EdgeEffect should favor {@link #onPull(float, float)} when the displacement
 * of the pull point is known.</p>
 *
 * @param deltaDistance Change in distance since the last call. Values may be 0 (no change) to
 *                      1.f (full length of the view) or negative values to express change
 *                      back toward the edge reached to initiate the effect.
 */

public void onPull(float deltaDistance) { throw new RuntimeException("Stub!"); }

/**
 * A view should call this when content is pulled away from an edge by the user.
 * This will update the state of the current visual effect and its associated animation.
 * The host view should always {@link android.view.View#invalidate()} after this
 * and draw the results accordingly.
 *
 * @param deltaDistance Change in distance since the last call. Values may be 0 (no change) to
 *                      1.f (full length of the view) or negative values to express change
 *                      back toward the edge reached to initiate the effect.
 * @param displacement The displacement from the starting side of the effect of the point
 *                     initiating the pull. In the case of touch this is the finger position.
 *                     Values may be from 0-1.
 */

public void onPull(float deltaDistance, float displacement) { throw new RuntimeException("Stub!"); }

/**
 * Call when the object is released after being pulled.
 * This will begin the "decay" phase of the effect. After calling this method
 * the host view should {@link android.view.View#invalidate()} and thereby
 * draw the results accordingly.
 */

public void onRelease() { throw new RuntimeException("Stub!"); }

/**
 * Call when the effect absorbs an impact at the given velocity.
 * Used when a fling reaches the scroll boundary.
 *
 * <p>When using a {@link android.widget.Scroller} or {@link android.widget.OverScroller},
 * the method <code>getCurrVelocity</code> will provide a reasonable approximation
 * to use here.</p>
 *
 * @param velocity Velocity at impact in pixels per second.
 */

public void onAbsorb(int velocity) { throw new RuntimeException("Stub!"); }

/**
 * Set the color of this edge effect in argb.
 *
 * @param color Color in argb
 */

public void setColor(int color) { throw new RuntimeException("Stub!"); }

/**
 * Return the color of this edge effect in argb.
 * @return The color of this edge effect in argb
 */

public int getColor() { throw new RuntimeException("Stub!"); }

/**
 * Draw into the provided canvas. Assumes that the canvas has been rotated
 * accordingly and the size has been set. The effect will be drawn the full
 * width of X=0 to X=width, beginning from Y=0 and extending to some factor <
 * 1.f of height.
 *
 * @param canvas Canvas to draw into
 * @return true if drawing should continue beyond this frame to continue the
 *         animation
 */

public boolean draw(android.graphics.Canvas canvas) { throw new RuntimeException("Stub!"); }

/**
 * Return the maximum height that the edge effect will be drawn at given the original
 * {@link #setSize(int, int) input size}.
 * @return The maximum height of the edge effect
 */

public int getMaxHeight() { throw new RuntimeException("Stub!"); }
}

