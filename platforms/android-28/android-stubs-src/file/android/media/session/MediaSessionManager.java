/*
 * Copyright (C) 2014 The Android Open Source Project
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


package android.media.session;

import android.content.ComponentName;
import java.util.List;
import android.service.notification.NotificationListenerService;
import android.view.KeyEvent;
import android.os.Handler;
import android.media.AudioManager;
import android.service.media.MediaBrowserService;
import android.media.browse.MediaBrowser;

/**
 * Provides support for interacting with {@link MediaSession media sessions}
 * that applications have published to express their ongoing media playback
 * state.
 *
 * @see MediaSession
 * @see MediaController
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaSessionManager {

/**
 * @hide
 */

MediaSessionManager(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Get a list of controllers for all ongoing sessions. The controllers will
 * be provided in priority order with the most important controller at index
 * 0.
 * <p>
 * This requires the android.Manifest.permission.MEDIA_CONTENT_CONTROL
 * permission be held by the calling app. You may also retrieve this list if
 * your app is an enabled notification listener using the
 * {@link NotificationListenerService} APIs, in which case you must pass the
 * {@link ComponentName} of your enabled listener.
 *
 * @param notificationListener The enabled notification listener component.
 *            May be null.
 * This value may be {@code null}.
 * @return A list of controllers for ongoing sessions.
 */

@androidx.annotation.RecentlyNonNull public java.util.List<android.media.session.MediaController> getActiveSessions(@androidx.annotation.RecentlyNullable android.content.ComponentName notificationListener) { throw new RuntimeException("Stub!"); }

/**
 * Add a listener to be notified when the list of active sessions
 * changes.This requires the
 * android.Manifest.permission.MEDIA_CONTENT_CONTROL permission be held by
 * the calling app. You may also retrieve this list if your app is an
 * enabled notification listener using the
 * {@link NotificationListenerService} APIs, in which case you must pass the
 * {@link ComponentName} of your enabled listener. Updates will be posted to
 * the thread that registered the listener.
 *
 * @param sessionListener The listener to add.
 * This value must never be {@code null}.
 * @param notificationListener The enabled notification listener component.
 *            May be null.

 * This value may be {@code null}.
 */

public void addOnActiveSessionsChangedListener(@androidx.annotation.RecentlyNonNull android.media.session.MediaSessionManager.OnActiveSessionsChangedListener sessionListener, @androidx.annotation.RecentlyNullable android.content.ComponentName notificationListener) { throw new RuntimeException("Stub!"); }

/**
 * Add a listener to be notified when the list of active sessions
 * changes.This requires the
 * android.Manifest.permission.MEDIA_CONTENT_CONTROL permission be held by
 * the calling app. You may also retrieve this list if your app is an
 * enabled notification listener using the
 * {@link NotificationListenerService} APIs, in which case you must pass the
 * {@link ComponentName} of your enabled listener. Updates will be posted to
 * the handler specified or to the caller's thread if the handler is null.
 *
 * @param sessionListener The listener to add.
 * This value must never be {@code null}.
 * @param notificationListener The enabled notification listener component.
 *            May be null.
 * This value may be {@code null}.
 * @param handler The handler to post events to.

 * This value may be {@code null}.
 */

public void addOnActiveSessionsChangedListener(@androidx.annotation.RecentlyNonNull android.media.session.MediaSessionManager.OnActiveSessionsChangedListener sessionListener, @androidx.annotation.RecentlyNullable android.content.ComponentName notificationListener, @androidx.annotation.RecentlyNullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Stop receiving active sessions updates on the specified listener.
 *
 * @param listener The listener to remove.

 * This value must never be {@code null}.
 */

public void removeOnActiveSessionsChangedListener(@androidx.annotation.RecentlyNonNull android.media.session.MediaSessionManager.OnActiveSessionsChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Checks whether the remote user is a trusted app.
 * <p>
 * An app is trusted if the app holds the android.Manifest.permission.MEDIA_CONTENT_CONTROL
 * permission or has an enabled notification listener.
 *
 * @param userInfo The remote user info from either
 *            {@link MediaSession#getCurrentControllerInfo()} or
 *            {@link MediaBrowserService#getCurrentBrowserInfo()}.
 * This value must never be {@code null}.
 * @return {@code true} if the remote user is trusted and its package name matches with the UID.
 *            {@code false} otherwise.
 */

public boolean isTrustedForMediaControl(@androidx.annotation.RecentlyNonNull android.media.session.MediaSessionManager.RemoteUserInfo userInfo) { throw new RuntimeException("Stub!"); }
/**
 * Listens for changes to the list of active sessions. This can be added
 * using {@link #addOnActiveSessionsChangedListener}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnActiveSessionsChangedListener {

/**
 * @param controllers This value may be {@code null}.
 */

public void onActiveSessionsChanged(@androidx.annotation.RecentlyNullable java.util.List<android.media.session.MediaController> controllers);
}

/**
 * Information of a remote user of {@link MediaSession} or {@link MediaBrowserService}.
 * This can be used to decide whether the remote user is trusted app, and also differentiate
 * caller of {@link MediaSession} and {@link MediaBrowserService} callbacks.
 * <p>
 * See {@link #equals(Object)} to take a look at how it differentiate media controller.
 *
 * @see #isTrustedForMediaControl(RemoteUserInfo)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class RemoteUserInfo {

/**
 * @param packageName This value must never be {@code null}.
 */

public RemoteUserInfo(@androidx.annotation.RecentlyNonNull java.lang.String packageName, int pid, int uid) { throw new RuntimeException("Stub!"); }

/**
 * @return package name of the controller
 */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }

/**
 * @return pid of the controller
 */

public int getPid() { throw new RuntimeException("Stub!"); }

/**
 * @return uid of the controller
 */

public int getUid() { throw new RuntimeException("Stub!"); }

/**
 * Returns equality of two RemoteUserInfo. Two RemoteUserInfos are the same only if they're
 * sent to the same controller (either {@link MediaController} or
 * {@link MediaBrowser}. If it's not nor one of them is triggered by the key presses, they
 * would be considered as different one.
 * <p>
 * If you only want to compare the caller's package, compare them with the
 * {@link #getPackageName()}, {@link #getPid()}, and/or {@link #getUid()} directly.
 *
 * @param obj the reference object with which to compare.
 * @return {@code true} if equals, {@code false} otherwise
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }
}

}

