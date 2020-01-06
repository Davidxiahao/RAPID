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


package android.app;

import android.os.Parcelable;
import android.os.Bundle;
import android.view.View;
import android.content.res.Configuration;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Context;

/**
 * Provides integration points with a {@link FragmentManager} for a fragment host.
 * <p>
 * It is the responsibility of the host to take care of the Fragment's lifecycle.
 * The methods provided by {@link FragmentController} are for that purpose.
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.app.FragmentController}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public class FragmentController {

FragmentController(android.app.FragmentHostCallback<?> callbacks) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link FragmentController}.
 */

public static final android.app.FragmentController createController(android.app.FragmentHostCallback<?> callbacks) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link FragmentManager} for this controller.
 */

public android.app.FragmentManager getFragmentManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link LoaderManager}.
 */

public android.app.LoaderManager getLoaderManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns a fragment with the given identifier.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.app.Fragment findFragmentByWho(java.lang.String who) { throw new RuntimeException("Stub!"); }

/**
 * Attaches the host to the FragmentManager for this controller. The host must be
 * attached before the FragmentManager can be used to manage Fragments.
 * */

public void attachHost(android.app.Fragment parent) { throw new RuntimeException("Stub!"); }

/**
 * Instantiates a Fragment's view.
 *
 * @param parent The parent that the created view will be placed
 * in; <em>note that this may be null</em>.
 * @param name Tag name to be inflated.
 * @param context The context the view is being created in.
 * @param attrs Inflation attributes as specified in XML file.
 *
 * @return view the newly created view
 */

public android.view.View onCreateView(android.view.View parent, java.lang.String name, android.content.Context context, android.util.AttributeSet attrs) { throw new RuntimeException("Stub!"); }

/**
 * Marks the fragment state as unsaved. This allows for "state loss" detection.
 */

public void noteStateNotSaved() { throw new RuntimeException("Stub!"); }

/**
 * Saves the state for all Fragments.
 */

public android.os.Parcelable saveAllState() { throw new RuntimeException("Stub!"); }

/**
 * Restores the saved state for all Fragments. The given Fragment list are Fragment
 * instances retained across configuration changes.
 *
 * @see #retainNonConfig()
 *
 * @deprecated use {@link #restoreAllState(Parcelable, FragmentManagerNonConfig)}
 */

@Deprecated public void restoreAllState(android.os.Parcelable state, java.util.List<android.app.Fragment> nonConfigList) { throw new RuntimeException("Stub!"); }

/**
 * Restores the saved state for all Fragments. The given FragmentManagerNonConfig are Fragment
 * instances retained across configuration changes, including nested fragments
 *
 * @see #retainNestedNonConfig()
 */

public void restoreAllState(android.os.Parcelable state, android.app.FragmentManagerNonConfig nonConfig) { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of Fragments that have opted to retain their instance across
 * configuration changes.
 *
 * @deprecated use {@link #retainNestedNonConfig()} to also track retained
 *             nested child fragments
 */

@Deprecated public java.util.List<android.app.Fragment> retainNonConfig() { throw new RuntimeException("Stub!"); }

/**
 * Returns a nested tree of Fragments that have opted to retain their instance across
 * configuration changes.
 */

public android.app.FragmentManagerNonConfig retainNestedNonConfig() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the create state.
 * <p>Call when Fragments should be created.
 *
 * @see Fragment#onCreate(Bundle)
 */

public void dispatchCreate() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the activity created state.
 * <p>Call when Fragments should be informed their host has been created.
 *
 * @see Fragment#onActivityCreated(Bundle)
 */

public void dispatchActivityCreated() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the start state.
 * <p>Call when Fragments should be started.
 *
 * @see Fragment#onStart()
 */

public void dispatchStart() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the resume state.
 * <p>Call when Fragments should be resumed.
 *
 * @see Fragment#onResume()
 */

public void dispatchResume() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the pause state.
 * <p>Call when Fragments should be paused.
 *
 * @see Fragment#onPause()
 */

public void dispatchPause() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the stop state.
 * <p>Call when Fragments should be stopped.
 *
 * @see Fragment#onStop()
 */

public void dispatchStop() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the destroy view state.
 * <p>Call when the Fragment's views should be destroyed.
 *
 * @see Fragment#onDestroyView()
 */

public void dispatchDestroyView() { throw new RuntimeException("Stub!"); }

/**
 * Moves all Fragments managed by the controller's FragmentManager
 * into the destroy state.
 * <p>Call when Fragments should be destroyed.
 *
 * @see Fragment#onDestroy()
 */

public void dispatchDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager know the multi-window mode of
 * the activity changed.
 * <p>Call when the multi-window mode of the activity changed.
 *
 * @see Fragment#onMultiWindowModeChanged
 * @deprecated use {@link #dispatchMultiWindowModeChanged(boolean, Configuration)}
 */

@Deprecated public void dispatchMultiWindowModeChanged(boolean isInMultiWindowMode) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager know the multi-window mode of
 * the activity changed.
 * <p>Call when the multi-window mode of the activity changed.
 *
 * @see Fragment#onMultiWindowModeChanged
 */

public void dispatchMultiWindowModeChanged(boolean isInMultiWindowMode, android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager know the picture-in-picture
 * mode of the activity changed.
 * <p>Call when the picture-in-picture mode of the activity changed.
 *
 * @see Fragment#onPictureInPictureModeChanged
 * @deprecated use {@link #dispatchPictureInPictureModeChanged(boolean, Configuration)}
 */

@Deprecated public void dispatchPictureInPictureModeChanged(boolean isInPictureInPictureMode) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager know the picture-in-picture
 * mode of the activity changed.
 * <p>Call when the picture-in-picture mode of the activity changed.
 *
 * @see Fragment#onPictureInPictureModeChanged
 */

public void dispatchPictureInPictureModeChanged(boolean isInPictureInPictureMode, android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager
 * know a configuration change occurred.
 * <p>Call when there is a configuration change.
 *
 * @see Fragment#onConfigurationChanged(Configuration)
 */

public void dispatchConfigurationChanged(android.content.res.Configuration newConfig) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager
 * know the device is in a low memory condition.
 * <p>Call when the device is low on memory and Fragment's should trim
 * their memory usage.
 *
 * @see Fragment#onLowMemory()
 */

public void dispatchLowMemory() { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager
 * know they should trim their memory usage.
 * <p>Call when the Fragment can release allocated memory [such as if
 * the Fragment is in the background].
 *
 * @see Fragment#onTrimMemory(int)
 */

public void dispatchTrimMemory(int level) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager
 * know they should create an options menu.
 * <p>Call when the Fragment should create an options menu.
 *
 * @return {@code true} if the options menu contains items to display
 * @see Fragment#onCreateOptionsMenu(Menu, MenuInflater)
 */

public boolean dispatchCreateOptionsMenu(android.view.Menu menu, android.view.MenuInflater inflater) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager
 * know they should prepare their options menu for display.
 * <p>Call immediately before displaying the Fragment's options menu.
 *
 * @return {@code true} if the options menu contains items to display
 * @see Fragment#onPrepareOptionsMenu(Menu)
 */

public boolean dispatchPrepareOptionsMenu(android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * Sends an option item selection event to the Fragments managed by the
 * controller's FragmentManager. Once the event has been consumed,
 * no additional handling will be performed.
 * <p>Call immediately after an options menu item has been selected
 *
 * @return {@code true} if the options menu selection event was consumed
 * @see Fragment#onOptionsItemSelected(MenuItem)
 */

public boolean dispatchOptionsItemSelected(android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * Sends a context item selection event to the Fragments managed by the
 * controller's FragmentManager. Once the event has been consumed,
 * no additional handling will be performed.
 * <p>Call immediately after an options menu item has been selected
 *
 * @return {@code true} if the context menu selection event was consumed
 * @see Fragment#onContextItemSelected(MenuItem)
 */

public boolean dispatchContextItemSelected(android.view.MenuItem item) { throw new RuntimeException("Stub!"); }

/**
 * Lets all Fragments managed by the controller's FragmentManager
 * know their options menu has closed.
 * <p>Call immediately after closing the Fragment's options menu.
 *
 * @see Fragment#onOptionsMenuClosed(Menu)
 */

public void dispatchOptionsMenuClosed(android.view.Menu menu) { throw new RuntimeException("Stub!"); }

/**
 * Execute any pending actions for the Fragments managed by the
 * controller's FragmentManager.
 * <p>Call when queued actions can be performed [eg when the
 * Fragment moves into a start or resume state].
 * @return {@code true} if queued actions were performed
 */

public boolean execPendingActions() { throw new RuntimeException("Stub!"); }

/**
 * Starts the loaders.
 */

public void doLoaderStart() { throw new RuntimeException("Stub!"); }

/**
 * Stops the loaders, optionally retaining their state. This is useful for keeping the
 * loader state across configuration changes.
 *
 * @param retain When {@code true}, the loaders aren't stopped, but, their instances
 * are retained in a started state
 */

public void doLoaderStop(boolean retain) { throw new RuntimeException("Stub!"); }

/**
 * Destroys the loaders and, if their state is not being retained, removes them.
 */

public void doLoaderDestroy() { throw new RuntimeException("Stub!"); }

/**
 * Lets the loaders know the host is ready to receive notifications.
 */

public void reportLoaderStart() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of LoaderManagers that have opted to retain their instance across
 * configuration changes.
 */

public android.util.ArrayMap<java.lang.String, android.app.LoaderManager> retainLoaderNonConfig() { throw new RuntimeException("Stub!"); }

/**
 * Restores the saved state for all LoaderManagers. The given LoaderManager list are
 * LoaderManager instances retained across configuration changes.
 *
 * @see #retainLoaderNonConfig()
 */

public void restoreLoaderNonConfig(android.util.ArrayMap<java.lang.String, android.app.LoaderManager> loaderManagers) { throw new RuntimeException("Stub!"); }

/**
 * Dumps the current state of the loaders.
 */

public void dumpLoaders(java.lang.String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }
}

