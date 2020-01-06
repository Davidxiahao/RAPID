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


package android.view.accessibility;

import android.content.Context;
import android.view.View;
import android.content.pm.ServiceInfo;
import java.util.List;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Handler;
import android.content.ComponentName;

/**
 * System level service that serves as an event dispatch for {@link AccessibilityEvent}s,
 * and provides facilities for querying the accessibility state of the system.
 * Accessibility events are generated when something notable happens in the user interface,
 * for example an {@link android.app.Activity} starts, the focus or selection of a
 * {@link android.view.View} changes etc. Parties interested in handling accessibility
 * events implement and register an accessibility service which extends
 * {@link android.accessibilityservice.AccessibilityService}.
 *
 * @see AccessibilityEvent
 * @see AccessibilityNodeInfo
 * @see android.accessibilityservice.AccessibilityService
 * @see Context#getSystemService
 * @see Context#ACCESSIBILITY_SERVICE
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class AccessibilityManager {

AccessibilityManager() { throw new RuntimeException("Stub!"); }

/**
 * Returns if the accessibility in the system is enabled.
 *
 * @return True if accessibility is enabled, false otherwise.
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns if the touch exploration in the system is enabled.
 *
 * @return True if touch exploration is enabled, false otherwise.
 */

public boolean isTouchExplorationEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Sends an {@link AccessibilityEvent}.
 *
 * @param event The event to send.
 *
 * @throws IllegalStateException if accessibility is not enabled.
 *
 * <strong>Note:</strong> The preferred mechanism for sending custom accessibility
 * events is through calling
 * {@link android.view.ViewParent#requestSendAccessibilityEvent(View, AccessibilityEvent)}
 * instead of this method to allow predecessors to augment/filter events sent by
 * their descendants.
 */

public void sendAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Requests feedback interruption from all accessibility services.
 */

public void interrupt() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link ServiceInfo}s of the installed accessibility services.
 *
 * @return An unmodifiable list with {@link ServiceInfo}s.
 *
 * @deprecated Use {@link #getInstalledAccessibilityServiceList()}
 */

@Deprecated public java.util.List<android.content.pm.ServiceInfo> getAccessibilityServiceList() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link AccessibilityServiceInfo}s of the installed accessibility services.
 *
 * @return An unmodifiable list with {@link AccessibilityServiceInfo}s.
 */

public java.util.List<android.accessibilityservice.AccessibilityServiceInfo> getInstalledAccessibilityServiceList() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link AccessibilityServiceInfo}s of the enabled accessibility services
 * for a given feedback type.
 *
 * @param feedbackTypeFlags The feedback type flags.
 * @return An unmodifiable list with {@link AccessibilityServiceInfo}s.
 *
 * @see AccessibilityServiceInfo#FEEDBACK_AUDIBLE
 * @see AccessibilityServiceInfo#FEEDBACK_GENERIC
 * @see AccessibilityServiceInfo#FEEDBACK_HAPTIC
 * @see AccessibilityServiceInfo#FEEDBACK_SPOKEN
 * @see AccessibilityServiceInfo#FEEDBACK_VISUAL
 * @see AccessibilityServiceInfo#FEEDBACK_BRAILLE
 */

public java.util.List<android.accessibilityservice.AccessibilityServiceInfo> getEnabledAccessibilityServiceList(int feedbackTypeFlags) { throw new RuntimeException("Stub!"); }

/**
 * Registers an {@link AccessibilityStateChangeListener} for changes in
 * the global accessibility state of the system. Equivalent to calling
 * {@link #addAccessibilityStateChangeListener(AccessibilityStateChangeListener, Handler)}
 * with a null handler.
 *
 * @param listener The listener.
 * This value must never be {@code null}.
 * @return Always returns {@code true}.
 */

public boolean addAccessibilityStateChangeListener(@androidx.annotation.RecentlyNonNull android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers an {@link AccessibilityStateChangeListener} for changes in
 * the global accessibility state of the system. If the listener has already been registered,
 * the handler used to call it back is updated.
 *
 * @param listener The listener.
 * This value must never be {@code null}.
 * @param handler The handler on which the listener should be called back, or {@code null}
 *                for a callback on the process's main handler.

 * This value may be {@code null}.
 */

public void addAccessibilityStateChangeListener(@androidx.annotation.RecentlyNonNull android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener listener, @androidx.annotation.RecentlyNullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters an {@link AccessibilityStateChangeListener}.
 *
 * @param listener The listener.
 * This value must never be {@code null}.
 * @return True if the listener was previously registered.
 */

public boolean removeAccessibilityStateChangeListener(@androidx.annotation.RecentlyNonNull android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers a {@link TouchExplorationStateChangeListener} for changes in
 * the global touch exploration state of the system. Equivalent to calling
 * {@link #addTouchExplorationStateChangeListener(TouchExplorationStateChangeListener, Handler)}
 * with a null handler.
 *
 * @param listener The listener.
 * This value must never be {@code null}.
 * @return Always returns {@code true}.
 */

public boolean addTouchExplorationStateChangeListener(@androidx.annotation.RecentlyNonNull android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers an {@link TouchExplorationStateChangeListener} for changes in
 * the global touch exploration state of the system. If the listener has already been
 * registered, the handler used to call it back is updated.
 *
 * @param listener The listener.
 * This value must never be {@code null}.
 * @param handler The handler on which the listener should be called back, or {@code null}
 *                for a callback on the process's main handler.

 * This value may be {@code null}.
 */

public void addTouchExplorationStateChangeListener(@androidx.annotation.RecentlyNonNull android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener listener, @androidx.annotation.RecentlyNullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a {@link TouchExplorationStateChangeListener}.
 *
 * @param listener The listener.
 * This value must never be {@code null}.
 * @return True if listener was previously registered.
 */

public boolean removeTouchExplorationStateChangeListener(@androidx.annotation.RecentlyNonNull android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Registers a {@link AccessibilityRequestPreparer}.
 */

public void addAccessibilityRequestPreparer(android.view.accessibility.AccessibilityRequestPreparer preparer) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters a {@link AccessibilityRequestPreparer}.
 */

public void removeAccessibilityRequestPreparer(android.view.accessibility.AccessibilityRequestPreparer preparer) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the accessibility button within the system navigation area is supported.
 *
 * @return {@code true} if the accessibility button is supported on this device,
 * {@code false} otherwise
 */

public static boolean isAccessibilityButtonSupported() { throw new RuntimeException("Stub!"); }
/**
 * Listener for the system accessibility state. To listen for changes to the
 * accessibility state on the device, implement this interface and register
 * it with the system by calling {@link #addAccessibilityStateChangeListener}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface AccessibilityStateChangeListener {

/**
 * Called when the accessibility enabled state changes.
 *
 * @param enabled Whether accessibility is enabled.
 */

public void onAccessibilityStateChanged(boolean enabled);
}

/**
 * Listener for the system touch exploration state. To listen for changes to
 * the touch exploration state on the device, implement this interface and
 * register it with the system by calling
 * {@link #addTouchExplorationStateChangeListener}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface TouchExplorationStateChangeListener {

/**
 * Called when the touch exploration enabled state changes.
 *
 * @param enabled Whether touch exploration is enabled.
 */

public void onTouchExplorationStateChanged(boolean enabled);
}

}

