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


package android.graphics;


/**
 * The NinePatch class permits drawing a bitmap in nine or more sections.
 * Essentially, it allows the creation of custom graphics that will scale the
 * way that you define, when content added within the image exceeds the normal
 * bounds of the graphic. For a thorough explanation of a NinePatch image,
 * read the discussion in the
 * <a href="{@docRoot}guide/topics/graphics/2d-graphics.html#nine-patch">2D
 * Graphics</a> document.
 * <p>
 * The <a href="{@docRoot}guide/developing/tools/draw9patch.html">Draw 9-Patch</a>
 * tool offers an extremely handy way to create your NinePatch images,
 * using a WYSIWYG graphics editor.
 * </p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class NinePatch {

/**
 * Create a drawable projection from a bitmap to nine patches.
 *
 * @param bitmap The bitmap describing the patches.
 * @param chunk The 9-patch data chunk describing how the underlying bitmap
 *              is split apart and drawn.
 */

public NinePatch(android.graphics.Bitmap bitmap, byte[] chunk) { throw new RuntimeException("Stub!"); }

/** 
 * Create a drawable projection from a bitmap to nine patches.
 *
 * @param bitmap The bitmap describing the patches.
 * @param chunk The 9-patch data chunk describing how the underlying
 *              bitmap is split apart and drawn.
 * @param srcName The name of the source for the bitmap. Might be null.
 */

public NinePatch(android.graphics.Bitmap bitmap, byte[] chunk, java.lang.String srcName) { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of this NinePatch object if one was specified
 * when calling the constructor.
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns the paint used to draw this NinePatch. The paint can be null.
 *
 * @see #setPaint(Paint)
 * @see #draw(Canvas, Rect)
 * @see #draw(Canvas, RectF)
 */

public android.graphics.Paint getPaint() { throw new RuntimeException("Stub!"); }

/**
 * Sets the paint to use when drawing the NinePatch.
 *
 * @param p The paint that will be used to draw this NinePatch.
 *
 * @see #getPaint()
 * @see #draw(Canvas, Rect)
 * @see #draw(Canvas, RectF)
 */

public void setPaint(android.graphics.Paint p) { throw new RuntimeException("Stub!"); }

/**
 * Returns the bitmap used to draw this NinePatch.
 */

public android.graphics.Bitmap getBitmap() { throw new RuntimeException("Stub!"); }

/** 
 * Draws the NinePatch. This method will use the paint returned by {@link #getPaint()}.
 *
 * @param canvas A container for the current matrix and clip used to draw the NinePatch.
 * @param location Where to draw the NinePatch.
 */

public void draw(android.graphics.Canvas canvas, android.graphics.RectF location) { throw new RuntimeException("Stub!"); }

/** 
 * Draws the NinePatch. This method will use the paint returned by {@link #getPaint()}.
 *
 * @param canvas A container for the current matrix and clip used to draw the NinePatch.
 * @param location Where to draw the NinePatch.
 */

public void draw(android.graphics.Canvas canvas, android.graphics.Rect location) { throw new RuntimeException("Stub!"); }

/** 
 * Draws the NinePatch. This method will ignore the paint returned
 * by {@link #getPaint()} and use the specified paint instead.
 *
 * @param canvas A container for the current matrix and clip used to draw the NinePatch.
 * @param location Where to draw the NinePatch.
 * @param paint The Paint to draw through.
 */

public void draw(android.graphics.Canvas canvas, android.graphics.Rect location, android.graphics.Paint paint) { throw new RuntimeException("Stub!"); }

/**
 * Return the underlying bitmap's density, as per
 * {@link Bitmap#getDensity() Bitmap.getDensity()}.
 */

public int getDensity() { throw new RuntimeException("Stub!"); }

/**
 * Returns the intrinsic width, in pixels, of this NinePatch. This is equivalent
 * to querying the width of the underlying bitmap returned by {@link #getBitmap()}.
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the intrinsic height, in pixels, of this NinePatch. This is equivalent
 * to querying the height of the underlying bitmap returned by {@link #getBitmap()}.
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether this NinePatch contains transparent or translucent pixels.
 * This is equivalent to calling <code>getBitmap().hasAlpha()</code> on this
 * NinePatch.
 */

public final boolean hasAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Region} representing the parts of the NinePatch that are
 * completely transparent.
 *
 * @param bounds The location and size of the NinePatch.
 *
 * @return null if the NinePatch has no transparent region to
 * report, else a {@link Region} holding the parts of the specified bounds
 * that are transparent.
 */

public final android.graphics.Region getTransparentRegion(android.graphics.Rect bounds) { throw new RuntimeException("Stub!"); }

/**
 * Verifies that the specified byte array is a valid 9-patch data chunk.
 *
 * @param chunk A byte array representing a 9-patch data chunk.
 *
 * @return True if the specified byte array represents a 9-patch data chunk,
 *         false otherwise.
 */

public static native boolean isNinePatchChunk(byte[] chunk);
}

