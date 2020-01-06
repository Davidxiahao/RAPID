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


package android.content.pm;


/**
 * Information you can retrieve about a particular piece of test
 * instrumentation.  This corresponds to information collected
 * from the AndroidManifest.xml's &lt;instrumentation&gt; tag.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InstrumentationInfo extends android.content.pm.PackageItemInfo implements android.os.Parcelable {

public InstrumentationInfo() { throw new RuntimeException("Stub!"); }

public InstrumentationInfo(android.content.pm.InstrumentationInfo orig) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int parcelableFlags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.content.pm.InstrumentationInfo> CREATOR;
static { CREATOR = null; }

/**
 * Full path to a directory assigned to the package for its persistent data.
 */

public java.lang.String dataDir;

/** Specifies whether or not to run this instrumentation as a functional test */

public boolean functionalTest;

/**
 * Specifies whether or not this instrumentation will handle profiling.
 */

public boolean handleProfiling;

/**
 * Full path to the publicly available parts of {@link #sourceDir},
 * including resources and manifest. This may be different from
 * {@link #sourceDir} if an application is forward locked.
 */

public java.lang.String publicSourceDir;

/**
 * Full path to the base APK for this application.
 */

public java.lang.String sourceDir;

/**
 * The names of all installed split APKs, ordered lexicographically.
 */

public java.lang.String[] splitNames;

/**
 * Full path to the publicly available parts of {@link #splitSourceDirs},
 * including resources and manifest. This may be different from
 * {@link #splitSourceDirs} if an application is forward locked.
 *
 * @see #splitSourceDirs
 */

public java.lang.String[] splitPublicSourceDirs;

/**
 * Full paths to zero or more split APKs, indexed by the same order as {@link #splitNames}.
 */

public java.lang.String[] splitSourceDirs;

/**
 * The name of the application package being instrumented.  From the
 * "package" attribute.
 */

public java.lang.String targetPackage;

/**
 * Names of the process(es) this instrumentation will run in.  If not specified, only
 * runs in the main process of the targetPackage.  Can either be a comma-separated list
 * of process names or '*' for any process that launches to run targetPackage code.
 */

public java.lang.String targetProcesses;
}

