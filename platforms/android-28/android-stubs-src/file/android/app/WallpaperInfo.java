/*
 * Copyright (C) 2009 The Android Open Source Project
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

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager;
import android.content.ComponentName;
import android.os.Parcel;

/**
 * This class is used to specify meta information of a wallpaper service.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class WallpaperInfo implements android.os.Parcelable {

/**
 * Constructor.
 *
 * @param context The Context in which we are parsing the wallpaper.
 * @param service The ResolveInfo returned from the package manager about
 * this wallpaper's component.
 */

public WallpaperInfo(android.content.Context context, android.content.pm.ResolveInfo service) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Return the .apk package that implements this wallpaper.
 */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Return the class name of the service component that implements
 * this wallpaper.
 */

public java.lang.String getServiceName() { throw new RuntimeException("Stub!"); }

/**
 * Return the raw information about the Service implementing this
 * wallpaper.  Do not modify the returned object.
 */

public android.content.pm.ServiceInfo getServiceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Return the component of the service that implements this wallpaper.
 */

public android.content.ComponentName getComponent() { throw new RuntimeException("Stub!"); }

/**
 * Load the user-displayed label for this wallpaper.
 *
 * @param pm Supply a PackageManager used to load the wallpaper's
 * resources.
 */

public java.lang.CharSequence loadLabel(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Load the user-displayed icon for this wallpaper.
 *
 * @param pm Supply a PackageManager used to load the wallpaper's
 * resources.
 */

public android.graphics.drawable.Drawable loadIcon(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Load the thumbnail image for this wallpaper.
 *
 * @param pm Supply a PackageManager used to load the wallpaper's
 * resources.
 */

public android.graphics.drawable.Drawable loadThumbnail(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Return a string indicating the author(s) of this wallpaper.
 */

public java.lang.CharSequence loadAuthor(android.content.pm.PackageManager pm) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Return a brief summary of this wallpaper's behavior.
 */

public java.lang.CharSequence loadDescription(android.content.pm.PackageManager pm) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Returns an URI that specifies a link for further context about this wallpaper.
 *
 * @param pm An instance of {@link PackageManager} to retrieve the URI.
 * @return The URI.
 */

public android.net.Uri loadContextUri(android.content.pm.PackageManager pm) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Retrieves a title of the URI that specifies a link for further context about this wallpaper.
 *
 * @param pm An instance of {@link PackageManager} to retrieve the title.
 * @return The title.
 */

public java.lang.CharSequence loadContextDescription(android.content.pm.PackageManager pm) throws android.content.res.Resources.NotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Queries whether any metadata should be shown when previewing the wallpaper. If this value is
 * set to true, any component that shows a preview of this live wallpaper should also show
 * accompanying information like {@link #loadLabel},
 * {@link #loadDescription}, {@link #loadAuthor} and
 * {@link #loadContextDescription(PackageManager)}, so the user gets to know further information
 * about this wallpaper.
 *
 * @return Whether any metadata should be shown when previewing the wallpaper.
 */

public boolean getShowMetadataInPreview() { throw new RuntimeException("Stub!"); }

/**
 * Return the class name of an activity that provides a settings UI for
 * the wallpaper.  You can launch this activity be starting it with
 * an {@link android.content.Intent} whose action is MAIN and with an
 * explicit {@link android.content.ComponentName}
 * composed of {@link #getPackageName} and the class name returned here.
 *
 * <p>A null will be returned if there is no settings activity associated
 * with the wallpaper.
 */

public java.lang.String getSettingsActivity() { throw new RuntimeException("Stub!"); }

public void dump(android.util.Printer pw, java.lang.String prefix) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link Parcel}.
 *
 * @param dest The {@link Parcel} to be written.
 * @param flags The flags used for parceling.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 */

public static final android.os.Parcelable.Creator<android.app.WallpaperInfo> CREATOR;
static { CREATOR = null; }
}

