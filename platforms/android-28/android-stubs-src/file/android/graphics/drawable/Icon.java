/*
 * Copyright (C) 2015 The Android Open Source Project
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

import android.graphics.Bitmap;
import android.content.res.Resources;
import android.os.Message;
import android.content.Context;
import android.os.Handler;
import android.graphics.BitmapFactory;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import android.net.Uri;
import java.io.File;

/**
 * An umbrella container for several serializable graphics representations, including Bitmaps,
 * compressed bitmap images (e.g.&nbsp;JPG or PNG), and drawable resources (including vectors).
 *
 * <a href="https://developer.android.com/training/displaying-bitmaps/index.html">Much ink</a>
 * has been spilled on the best way to load images, and many clients may have different needs when
 * it comes to threading and fetching. This class is therefore focused on encapsulation rather than
 * behavior.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Icon implements android.os.Parcelable {

Icon(int mType) { throw new RuntimeException("Stub!"); }

/**
 * Gets the type of the icon provided.
 * <p>
 * Note that new types may be added later, so callers should guard against other
 * types being returned.

 * @return Value is {@link android.graphics.drawable.Icon#TYPE_BITMAP}, {@link android.graphics.drawable.Icon#TYPE_RESOURCE}, {@link android.graphics.drawable.Icon#TYPE_DATA}, {@link android.graphics.drawable.Icon#TYPE_URI}, or {@link android.graphics.drawable.Icon#TYPE_ADAPTIVE_BITMAP}
 */

public int getType() { throw new RuntimeException("Stub!"); }

/**
 * Gets the package used to create this icon.
 * <p>
 * Only valid for icons of type {@link #TYPE_RESOURCE}.
 * Note: This package may not be available if referenced in the future, and it is
 * up to the caller to ensure safety if this package is re-used and/or persisted.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getResPackage() { throw new RuntimeException("Stub!"); }

/**
 * Gets the resource used to create this icon.
 * <p>
 * Only valid for icons of type {@link #TYPE_RESOURCE}.
 * Note: This resource may not be available if the application changes at all, and it is
 * up to the caller to ensure safety if this resource is re-used and/or persisted.
 */

public int getResId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the uri used to create this icon.
 * <p>
 * Only valid for icons of type {@link #TYPE_URI}.
 * Note: This uri may not be available in the future, and it is
 * up to the caller to ensure safety if this uri is re-used and/or persisted.

 * @return This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.net.Uri getUri() { throw new RuntimeException("Stub!"); }

/**
 * Invokes {@link #loadDrawable(Context)} on the given {@link android.os.Handler Handler}
 * and then sends <code>andThen</code> to the same Handler when finished.
 *
 * @param context {@link android.content.Context Context} in which to load the drawable; see
 *                {@link #loadDrawable(Context)}
 * @param andThen {@link android.os.Message} to send to its target once the drawable
 *                is available. The {@link android.os.Message#obj obj}
 *                property is populated with the Drawable.
 */

public void loadDrawableAsync(android.content.Context context, android.os.Message andThen) { throw new RuntimeException("Stub!"); }

/**
 * Invokes {@link #loadDrawable(Context)} on a background thread and notifies the <code>
 * {@link OnDrawableLoadedListener#onDrawableLoaded listener} </code> on the {@code handler}
 * when finished.
 *
 * @param context {@link Context Context} in which to load the drawable; see
 *                {@link #loadDrawable(Context)}
 * @param listener to be {@link OnDrawableLoadedListener#onDrawableLoaded notified} when
 *                 {@link #loadDrawable(Context)} finished
 * @param handler {@link Handler} on which to notify the {@code listener}
 */

public void loadDrawableAsync(android.content.Context context, android.graphics.drawable.Icon.OnDrawableLoadedListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Returns a Drawable that can be used to draw the image inside this Icon, constructing it
 * if necessary. Depending on the type of image, this may not be something you want to do on
 * the UI thread, so consider using
 * {@link #loadDrawableAsync(Context, Message) loadDrawableAsync} instead.
 *
 * @param context {@link android.content.Context Context} in which to load the drawable; used
 *                to access {@link android.content.res.Resources Resources}, for example.
 * @return A fresh instance of a drawable for this image, yours to keep.
 */

public android.graphics.drawable.Drawable loadDrawable(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Create an Icon pointing to a drawable resource.
 * @param context The context for the application whose resources should be used to resolve the
 *                given resource ID.
 * @param resId ID of the drawable resource
 */

public static android.graphics.drawable.Icon createWithResource(android.content.Context context, int resId) { throw new RuntimeException("Stub!"); }

/**
 * Create an Icon pointing to a drawable resource.
 * @param resPackage Name of the package containing the resource in question
 * @param resId ID of the drawable resource
 */

public static android.graphics.drawable.Icon createWithResource(java.lang.String resPackage, int resId) { throw new RuntimeException("Stub!"); }

/**
 * Create an Icon pointing to a bitmap in memory.
 * @param bits A valid {@link android.graphics.Bitmap} object
 */

public static android.graphics.drawable.Icon createWithBitmap(android.graphics.Bitmap bits) { throw new RuntimeException("Stub!"); }

/**
 * Create an Icon pointing to a bitmap in memory that follows the icon design guideline defined
 * by {@link AdaptiveIconDrawable}.
 * @param bits A valid {@link android.graphics.Bitmap} object
 */

public static android.graphics.drawable.Icon createWithAdaptiveBitmap(android.graphics.Bitmap bits) { throw new RuntimeException("Stub!"); }

/**
 * Create an Icon pointing to a compressed bitmap stored in a byte array.
 * @param data Byte array storing compressed bitmap data of a type that
 *             {@link android.graphics.BitmapFactory}
 *             can decode (see {@link android.graphics.Bitmap.CompressFormat}).
 * @param offset Offset into <code>data</code> at which the bitmap data starts
 * @param length Length of the bitmap data
 */

public static android.graphics.drawable.Icon createWithData(byte[] data, int offset, int length) { throw new RuntimeException("Stub!"); }

/**
 * Create an Icon pointing to an image file specified by URI.
 *
 * @param uri A uri referring to local content:// or file:// image data.
 */

public static android.graphics.drawable.Icon createWithContentUri(java.lang.String uri) { throw new RuntimeException("Stub!"); }

/**
 * Create an Icon pointing to an image file specified by URI.
 *
 * @param uri A uri referring to local content:// or file:// image data.
 */

public static android.graphics.drawable.Icon createWithContentUri(android.net.Uri uri) { throw new RuntimeException("Stub!"); }

/**
 * Store a color to use whenever this Icon is drawn.
 *
 * @param tint a color, as in {@link Drawable#setTint(int)}
 * @return this same object, for use in chained construction
 */

public android.graphics.drawable.Icon setTint(int tint) { throw new RuntimeException("Stub!"); }

/**
 * Store a color to use whenever this Icon is drawn.
 *
 * @param tintList as in {@link Drawable#setTintList(ColorStateList)}, null to remove tint
 * @return this same object, for use in chained construction
 */

public android.graphics.drawable.Icon setTintList(android.content.res.ColorStateList tintList) { throw new RuntimeException("Stub!"); }

/**
 * Store a blending mode to use whenever this Icon is drawn.
 *
 * @param mode a blending mode, as in {@link Drawable#setTintMode(PorterDuff.Mode)}, may be null
 * @return this same object, for use in chained construction
 */

public android.graphics.drawable.Icon setTintMode(android.graphics.PorterDuff.Mode mode) { throw new RuntimeException("Stub!"); }

/**
 * Create an Icon pointing to an image file specified by path.
 *
 * @param path A path to a file that contains compressed bitmap data of
 *           a type that {@link android.graphics.BitmapFactory} can decode.
 */

public static android.graphics.drawable.Icon createWithFilePath(java.lang.String path) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Parcelable interface
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.graphics.drawable.Icon> CREATOR;
static { CREATOR = null; }

/**
 * An icon that was created using {@link Icon#createWithAdaptiveBitmap}.
 * @see #getType
 */

public static final int TYPE_ADAPTIVE_BITMAP = 5; // 0x5

/**
 * An icon that was created using {@link Icon#createWithBitmap(Bitmap)}.
 * @see #getType
 */

public static final int TYPE_BITMAP = 1; // 0x1

/**
 * An icon that was created using {@link Icon#createWithData(byte[], int, int)}.
 * @see #getType
 */

public static final int TYPE_DATA = 3; // 0x3

/**
 * An icon that was created using {@link Icon#createWithResource}.
 * @see #getType
 */

public static final int TYPE_RESOURCE = 2; // 0x2

/**
 * An icon that was created using {@link Icon#createWithContentUri}
 * or {@link Icon#createWithFilePath(String)}.
 * @see #getType
 */

public static final int TYPE_URI = 4; // 0x4
/**
 * Implement this interface to receive a callback when
 * {@link #loadDrawableAsync(Context, OnDrawableLoadedListener, Handler) loadDrawableAsync}
 * is finished and your Drawable is ready.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnDrawableLoadedListener {

public void onDrawableLoaded(android.graphics.drawable.Drawable d);
}

}

