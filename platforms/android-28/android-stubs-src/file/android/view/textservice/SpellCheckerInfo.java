/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.view.textservice;

import android.os.Parcel;
import android.content.pm.PackageManager;
import android.content.ComponentName;

/**
 * This class is used to specify meta information of a spell checker.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class SpellCheckerInfo implements android.os.Parcelable {

/**
 * Constructor.
 * @hide
 */

SpellCheckerInfo(android.os.Parcel source) { throw new RuntimeException("Stub!"); }

/**
 * Return a unique ID for this spell checker.  The ID is generated from
 * the package and class name implementing the method.
 */

public java.lang.String getId() { throw new RuntimeException("Stub!"); }

/**
 * Return the component of the service that implements.
 */

public android.content.ComponentName getComponent() { throw new RuntimeException("Stub!"); }

/**
 * Return the .apk package that implements this.
 */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * Used to package this object into a {@link Parcel}.
 *
 * @param dest The {@link Parcel} to be written.
 * @param flags The flags used for parceling.
 */

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Load the user-displayed label for this spell checker.
 *
 * @param pm Supply a PackageManager used to load the spell checker's resources.
 */

public java.lang.CharSequence loadLabel(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Load the user-displayed icon for this spell checker.
 *
 * @param pm Supply a PackageManager used to load the spell checker's resources.
 */

public android.graphics.drawable.Drawable loadIcon(android.content.pm.PackageManager pm) { throw new RuntimeException("Stub!"); }

/**
 * Return the raw information about the Service implementing this
 * spell checker.  Do not modify the returned object.
 */

public android.content.pm.ServiceInfo getServiceInfo() { throw new RuntimeException("Stub!"); }

/**
 * Return the class name of an activity that provides a settings UI.
 * You can launch this activity be starting it with
 * an {@link android.content.Intent} whose action is MAIN and with an
 * explicit {@link android.content.ComponentName}
 * composed of {@link #getPackageName} and the class name returned here.
 *
 * <p>A null will be returned if there is no settings activity.
 */

public java.lang.String getSettingsActivity() { throw new RuntimeException("Stub!"); }

/**
 * Return the count of the subtypes.
 */

public int getSubtypeCount() { throw new RuntimeException("Stub!"); }

/**
 * Return the subtype at the specified index.
 *
 * @param index the index of the subtype to return.
 */

public android.view.textservice.SpellCheckerSubtype getSubtypeAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 */

public int describeContents() { throw new RuntimeException("Stub!"); }

/**
 * Used to make this class parcelable.
 */

public static final android.os.Parcelable.Creator<android.view.textservice.SpellCheckerInfo> CREATOR;
static { CREATOR = null; }
}

