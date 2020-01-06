/*
 * Copyright (C) 2017 The Android Open Source Project
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
 * limitations under the License
 */


package android.app;

import android.graphics.Color;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.util.List;

/**
 * Provides information about the colors of a wallpaper.
 * <p>
 * Exposes the 3 most visually representative colors of a wallpaper. Can be either
 * {@link WallpaperColors#getPrimaryColor()}, {@link WallpaperColors#getSecondaryColor()}
 * or {@link WallpaperColors#getTertiaryColor()}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class WallpaperColors implements android.os.Parcelable {

public WallpaperColors(android.os.Parcel parcel) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new object from three colors.
 *
 * @param primaryColor Primary color.
 * This value must never be {@code null}.
 * @param secondaryColor Secondary color.
 * This value may be {@code null}.
 * @param tertiaryColor Tertiary color.
 * This value may be {@code null}.
 * @see WallpaperColors#fromBitmap(Bitmap)
 * @see WallpaperColors#fromDrawable(Drawable)
 */

public WallpaperColors(@androidx.annotation.RecentlyNonNull android.graphics.Color primaryColor, @androidx.annotation.RecentlyNullable android.graphics.Color secondaryColor, @androidx.annotation.RecentlyNullable android.graphics.Color tertiaryColor) { throw new RuntimeException("Stub!"); }

/**
 * Constructs {@link WallpaperColors} from a drawable.
 * <p>
 * Main colors will be extracted from the drawable.
 *
 * @param drawable Source where to extract from.
 */

public static android.app.WallpaperColors fromDrawable(android.graphics.drawable.Drawable drawable) { throw new RuntimeException("Stub!"); }

/**
 * Constructs {@link WallpaperColors} from a bitmap.
 * <p>
 * Main colors will be extracted from the bitmap.
 *
 * @param bitmap Source where to extract from.

 * This value must never be {@code null}.
 */

public static android.app.WallpaperColors fromBitmap(@androidx.annotation.RecentlyNonNull android.graphics.Bitmap bitmap) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Gets the most visually representative color of the wallpaper.
 * "Visually representative" means easily noticeable in the image,
 * probably happening at high frequency.
 *
 * @return A color.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.graphics.Color getPrimaryColor() { throw new RuntimeException("Stub!"); }

/**
 * Gets the second most preeminent color of the wallpaper. Can be null.
 *
 * @return A color, may be null.
 */

@androidx.annotation.RecentlyNullable public android.graphics.Color getSecondaryColor() { throw new RuntimeException("Stub!"); }

/**
 * Gets the third most preeminent color of the wallpaper. Can be null.
 *
 * @return A color, may be null.
 */

@androidx.annotation.RecentlyNullable public android.graphics.Color getTertiaryColor() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.WallpaperColors> CREATOR;
static { CREATOR = null; }
}

