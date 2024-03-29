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


package android.app;

import java.util.HashMap;

/**
 * A screen that contains and runs multiple embedded activities.
 *
 * @deprecated Use the new {@link Fragment} and {@link FragmentManager} APIs
 * instead; these are also
 * available on older platforms through the Android compatibility package.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public class ActivityGroup extends android.app.Activity {

public ActivityGroup() { throw new RuntimeException("Stub!"); }

public ActivityGroup(boolean singleActivityMode) { throw new RuntimeException("Stub!"); }

protected void onCreate(android.os.Bundle savedInstanceState) { throw new RuntimeException("Stub!"); }

protected void onResume() { throw new RuntimeException("Stub!"); }

protected void onSaveInstanceState(android.os.Bundle outState) { throw new RuntimeException("Stub!"); }

protected void onPause() { throw new RuntimeException("Stub!"); }

protected void onStop() { throw new RuntimeException("Stub!"); }

protected void onDestroy() { throw new RuntimeException("Stub!"); }

public android.app.Activity getCurrentActivity() { throw new RuntimeException("Stub!"); }

public final android.app.LocalActivityManager getLocalActivityManager() { throw new RuntimeException("Stub!"); }
}

