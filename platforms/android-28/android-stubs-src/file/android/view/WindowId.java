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


package android.view;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Safe identifier for a window.  This currently allows you to retrieve and observe
 * the input focus state of the window.  Most applications will
 * not use this, instead relying on the simpler (and more efficient) methods available
 * on {@link View}.  This classes is useful when window input interactions need to be
 * done across processes: the class itself is a Parcelable that can be passed to other
 * processes for them to interact with your window, and it provides a limited safe API
 * that doesn't allow the other process to negatively harm your window.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class WindowId implements android.os.Parcelable {

/** @hide */

WindowId(android.os.IBinder target) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current focus state of the associated window.
 */

public boolean isFocused() { throw new RuntimeException("Stub!"); }

/**
 * Start monitoring for changes in the focus state of the window.
 */

public void registerFocusObserver(android.view.WindowId.FocusObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * Stop monitoring changes in the focus state of the window.
 */

public void unregisterFocusObserver(android.view.WindowId.FocusObserver observer) { throw new RuntimeException("Stub!"); }

/**
 * Comparison operator on two IntentSender objects, such that true
 * is returned then they both represent the same operation from the
 * same package.

 * @param otherObj This value may be {@code null}.
 */

public boolean equals(@androidx.annotation.RecentlyNullable java.lang.Object otherObj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.view.WindowId> CREATOR;
static { CREATOR = null; }
/**
 * Subclass for observing changes to the focus state of an {@link WindowId}.
 * You should use the same instance of this class for observing multiple
 * {@link WindowId} objects, since this class is fairly heavy-weight -- the
 * base class includes all of the mechanisms for connecting to and receiving updates
 * from the window.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class FocusObserver {

/**
 * Construct a new observer.  This observer will be configured so that all
 * of its callbacks are dispatched on the current calling thread.
 */

public FocusObserver() { throw new RuntimeException("Stub!"); }

/**
 * Called when one of the monitored windows gains input focus.
 */

public abstract void onFocusGained(android.view.WindowId token);

/**
 * Called when one of the monitored windows loses input focus.
 */

public abstract void onFocusLost(android.view.WindowId token);
}

}

