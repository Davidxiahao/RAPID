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

import android.content.Context;
import android.os.Handler;
import java.io.PrintWriter;
import android.view.LayoutInflater;
import android.content.Intent;
import android.os.Bundle;
import android.content.IntentSender;

/**
 * Integration points with the Fragment host.
 * <p>
 * Fragments may be hosted by any object; such as an {@link Activity}. In order to
 * host fragments, implement {@link FragmentHostCallback}, overriding the methods
 * applicable to the host.
 *
 * @deprecated Use the <a href="{@docRoot}tools/extras/support-library.html">Support Library</a>
 *      {@link android.support.v4.app.FragmentHostCallback}
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public abstract class FragmentHostCallback<E> extends android.app.FragmentContainer {

public FragmentHostCallback(android.content.Context context, android.os.Handler handler, int windowAnimations) { throw new RuntimeException("Stub!"); }

/**
 * Print internal state into the given stream.
 *
 * @param prefix Desired prefix to prepend at each line of output.
 * @param fd The raw file descriptor that the dump is being sent to.
 * @param writer The PrintWriter to which you should dump your state. This will be closed
 *                  for you after you return.
 * @param args additional arguments to the dump request.
 */

public void onDump(java.lang.String prefix, java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the fragment's state needs to be saved.
 */

public boolean onShouldSaveFragmentState(android.app.Fragment fragment) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@link LayoutInflater}.
 * See {@link Activity#getLayoutInflater()}.
 */

public android.view.LayoutInflater onGetLayoutInflater() { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if the FragmentManager's LayoutInflaterFactory should be used.
 */

public boolean onUseFragmentManagerInflaterFactory() { throw new RuntimeException("Stub!"); }

/**
 * Return the object that's currently hosting the fragment. If a {@link Fragment}
 * is hosted by a {@link Activity}, the object returned here should be the same
 * object returned from {@link Fragment#getActivity()}.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public abstract E onGetHost();

/**
 * Invalidates the activity's options menu.
 * See {@link Activity#invalidateOptionsMenu()}
 */

public void onInvalidateOptionsMenu() { throw new RuntimeException("Stub!"); }

/**
 * Starts a new {@link Activity} from the given fragment.
 * See {@link Activity#startActivityForResult(Intent, int)}.
 */

public void onStartActivityFromFragment(android.app.Fragment fragment, android.content.Intent intent, int requestCode, android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Starts a new {@link IntentSender} from the given fragment.
 * See {@link Activity#startIntentSender(IntentSender, Intent, int, int, int, Bundle)}.

 * @param fillInIntent This value may be {@code null}.
 */

public void onStartIntentSenderFromFragment(android.app.Fragment fragment, android.content.IntentSender intent, int requestCode, @androidx.annotation.RecentlyNullable android.content.Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, android.os.Bundle options) throws android.content.IntentSender.SendIntentException { throw new RuntimeException("Stub!"); }

/**
 * Requests permissions from the given fragment.
 * See {@link Activity#requestPermissions(String[], int)}
 
 * @param fragment This value must never be {@code null}.

 * @param permissions This value must never be {@code null}.
 */

public void onRequestPermissionsFromFragment(@androidx.annotation.RecentlyNonNull android.app.Fragment fragment, @androidx.annotation.RecentlyNonNull java.lang.String[] permissions, int requestCode) { throw new RuntimeException("Stub!"); }

/**
 * Return {@code true} if there are window animations.
 */

public boolean onHasWindowAnimations() { throw new RuntimeException("Stub!"); }

/**
 * Return the window animations.
 */

public int onGetWindowAnimations() { throw new RuntimeException("Stub!"); }

/**
 * Called when a {@link Fragment} is being attached to this host, immediately
 * after the call to its {@link Fragment#onAttach(Context)} method and before
 * {@link Fragment#onCreate(Bundle)}.
 */

public void onAttachFragment(android.app.Fragment fragment) { throw new RuntimeException("Stub!"); }

/**
 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public <T extends android.view.View> T onFindViewById(int id) { throw new RuntimeException("Stub!"); }

public boolean onHasView() { throw new RuntimeException("Stub!"); }
}

