/*
 * Copyright (C) 2013 The Android Open Source Project
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


package android.print;

import android.print.PrintAttributes.MediaSize;
import android.print.PrintAttributes.Resolution;
import android.print.PrintAttributes.Margins;

/**
 * This class represents the capabilities of a printer. Instances
 * of this class are created by a print service to report the
 * capabilities of a printer it manages. The capabilities of a
 * printer specify how it can print content. For example, what
 * are the media sizes supported by the printer, what are the
 * minimal margins of the printer based on its technical design,
 * etc.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class PrinterCapabilitiesInfo implements android.os.Parcelable {

/**
 * @hide
 */

PrinterCapabilitiesInfo() { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported media sizes.
 *
 * @return The media sizes.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<android.print.PrintAttributes.MediaSize> getMediaSizes() { throw new RuntimeException("Stub!"); }

/**
 * Gets the supported resolutions.
 *
 * @return The resolutions.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<android.print.PrintAttributes.Resolution> getResolutions() { throw new RuntimeException("Stub!"); }

/**
 * Gets the minimal margins. These are the minimal margins
 * the printer physically supports.
 *
 * @return The minimal margins.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.print.PrintAttributes.Margins getMinMargins() { throw new RuntimeException("Stub!"); }

/**
 * Gets the bit mask of supported color modes.
 *
 * @return The bit mask of supported color modes.
 *
 * Value is either <code>0</code> or a combination of {@link android.print.PrintAttributes#COLOR_MODE_MONOCHROME}, and {@link android.print.PrintAttributes#COLOR_MODE_COLOR}
 * @see PrintAttributes#COLOR_MODE_COLOR
 * @see PrintAttributes#COLOR_MODE_MONOCHROME
 */

public int getColorModes() { throw new RuntimeException("Stub!"); }

/**
 * Gets the bit mask of supported duplex modes.
 *
 * @return The bit mask of supported duplex modes.
 *
 * Value is either <code>0</code> or a combination of {@link android.print.PrintAttributes#DUPLEX_MODE_NONE}, {@link android.print.PrintAttributes#DUPLEX_MODE_LONG_EDGE}, and {@link android.print.PrintAttributes#DUPLEX_MODE_SHORT_EDGE}
 * @see PrintAttributes#DUPLEX_MODE_NONE
 * @see PrintAttributes#DUPLEX_MODE_LONG_EDGE
 * @see PrintAttributes#DUPLEX_MODE_SHORT_EDGE
 */

public int getDuplexModes() { throw new RuntimeException("Stub!"); }

/**
 * Gets the default print attributes.
 *
 * @return The default attributes.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.print.PrintAttributes getDefaults() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel parcel, int flags) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.print.PrinterCapabilitiesInfo> CREATOR;
static { CREATOR = null; }
/**
 * Builder for creating of a {@link PrinterCapabilitiesInfo}. This class is
 * responsible to enforce that all required attributes have at least one
 * default value. In other words, this class creates only well-formed {@link
 * PrinterCapabilitiesInfo}s.
 * <p>
 * Look at the individual methods for a reference whether a property is
 * required or if it is optional.
 * </p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Creates a new instance.
 *
 * @param printerId The printer id. Cannot be <code>null</code>.
 *
 * This value must never be {@code null}.
 * @throws IllegalArgumentException If the printer id is <code>null</code>.
 */

public Builder(@androidx.annotation.RecentlyNonNull android.print.PrinterId printerId) { throw new RuntimeException("Stub!"); }

/**
 * Adds a supported media size.
 * <p>
 * <strong>Required:</strong> Yes
 * </p>
 *
 * @param mediaSize A media size.
 * This value must never be {@code null}.
 * @param isDefault Whether this is the default.
 * @return This builder.
 * This value will never be {@code null}.
 * @throws IllegalArgumentException If set as default and there
 *     is already a default.
 *
 * @see PrintAttributes.MediaSize
 */

@androidx.annotation.RecentlyNonNull public android.print.PrinterCapabilitiesInfo.Builder addMediaSize(@androidx.annotation.RecentlyNonNull android.print.PrintAttributes.MediaSize mediaSize, boolean isDefault) { throw new RuntimeException("Stub!"); }

/**
 * Adds a supported resolution.
 * <p>
 * <strong>Required:</strong> Yes
 * </p>
 *
 * @param resolution A resolution.
 * This value must never be {@code null}.
 * @param isDefault Whether this is the default.
 * @return This builder.
 *
 * This value will never be {@code null}.
 * @throws IllegalArgumentException If set as default and there
 *     is already a default.
 *
 * @see PrintAttributes.Resolution
 */

@androidx.annotation.RecentlyNonNull public android.print.PrinterCapabilitiesInfo.Builder addResolution(@androidx.annotation.RecentlyNonNull android.print.PrintAttributes.Resolution resolution, boolean isDefault) { throw new RuntimeException("Stub!"); }

/**
 * Sets the minimal margins. These are the minimal margins
 * the printer physically supports.
 *
 * <p>
 * <strong>Required:</strong> Yes
 * </p>
 *
 * @param margins The margins.
 * This value must never be {@code null}.
 * @return This builder.
 *
 * @throws IllegalArgumentException If margins are <code>null</code>.
 *
 * @see PrintAttributes.Margins
 */

@androidx.annotation.RecentlyNonNull public android.print.PrinterCapabilitiesInfo.Builder setMinMargins(@androidx.annotation.RecentlyNonNull android.print.PrintAttributes.Margins margins) { throw new RuntimeException("Stub!"); }

/**
 * Sets the color modes.
 * <p>
 * <strong>Required:</strong> Yes
 * </p>
 *
 * @param colorModes The color mode bit mask.
 * Value is either <code>0</code> or a combination of {@link android.print.PrintAttributes#COLOR_MODE_MONOCHROME}, and {@link android.print.PrintAttributes#COLOR_MODE_COLOR}
 * @param defaultColorMode The default color mode.
 * Value is either <code>0</code> or a combination of {@link android.print.PrintAttributes#COLOR_MODE_MONOCHROME}, and {@link android.print.PrintAttributes#COLOR_MODE_COLOR}
 * @return This builder.
 * <p>
 * <strong>Note:</strong> On platform version 19 (KitKat) specifying
 * only PrintAttributes#COLOR_MODE_MONOCHROME leads to a print spooler
 * crash. Hence, you should declare either both color modes or
 * PrintAttributes#COLOR_MODE_COLOR.
 * </p>
 *
 * This value will never be {@code null}.
 * @throws IllegalArgumentException If color modes contains an invalid
 *         mode bit or if the default color mode is invalid.
 *
 * @see PrintAttributes#COLOR_MODE_COLOR
 * @see PrintAttributes#COLOR_MODE_MONOCHROME
 */

@androidx.annotation.RecentlyNonNull public android.print.PrinterCapabilitiesInfo.Builder setColorModes(int colorModes, int defaultColorMode) { throw new RuntimeException("Stub!"); }

/**
 * Sets the duplex modes.
 * <p>
 * <strong>Required:</strong> No
 * </p>
 *
 * @param duplexModes The duplex mode bit mask.
 * Value is either <code>0</code> or a combination of {@link android.print.PrintAttributes#DUPLEX_MODE_NONE}, {@link android.print.PrintAttributes#DUPLEX_MODE_LONG_EDGE}, and {@link android.print.PrintAttributes#DUPLEX_MODE_SHORT_EDGE}
 * @param defaultDuplexMode The default duplex mode.
 * Value is either <code>0</code> or a combination of {@link android.print.PrintAttributes#DUPLEX_MODE_NONE}, {@link android.print.PrintAttributes#DUPLEX_MODE_LONG_EDGE}, and {@link android.print.PrintAttributes#DUPLEX_MODE_SHORT_EDGE}
 * @return This builder.
 *
 * This value will never be {@code null}.
 * @throws IllegalArgumentException If duplex modes contains an invalid
 *         mode bit or if the default duplex mode is invalid.
 *
 * @see PrintAttributes#DUPLEX_MODE_NONE
 * @see PrintAttributes#DUPLEX_MODE_LONG_EDGE
 * @see PrintAttributes#DUPLEX_MODE_SHORT_EDGE
 */

@androidx.annotation.RecentlyNonNull public android.print.PrinterCapabilitiesInfo.Builder setDuplexModes(int duplexModes, int defaultDuplexMode) { throw new RuntimeException("Stub!"); }

/**
 * Crates a new {@link PrinterCapabilitiesInfo} enforcing that all
 * required properties have been specified. See individual methods
 * in this class for reference about required attributes.
 * <p>
 * <strong>Note:</strong> If you do not add supported duplex modes,
 * {@link android.print.PrintAttributes#DUPLEX_MODE_NONE} will set
 * as the only supported mode and also as the default duplex mode.
 * </p>
 *
 * @return A new {@link PrinterCapabilitiesInfo}.
 *
 * This value will never be {@code null}.
 * @throws IllegalStateException If a required attribute was not specified.
 */

@androidx.annotation.RecentlyNonNull public android.print.PrinterCapabilitiesInfo build() { throw new RuntimeException("Stub!"); }
}

}

