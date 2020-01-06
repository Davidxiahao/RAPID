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


package android.service.media;

import android.app.Service;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.MediaSessionManager.RemoteUserInfo;
import android.content.Intent;
import android.os.ResultReceiver;
import android.os.Bundle;
import java.util.List;

/**
 * Base class for media browser services.
 * <p>
 * Media browser services enable applications to browse media content provided by an application
 * and ask the application to start playing it. They may also be used to control content that
 * is already playing by way of a {@link MediaSession}.
 * </p>
 *
 * To extend this class, you must declare the service in your manifest file with
 * an intent filter with the {@link #SERVICE_INTERFACE} action.
 *
 * For example:
 * </p><pre>
 * &lt;service android:name=".MyMediaBrowserService"
 *          android:label="&#64;string/service_name" >
 *     &lt;intent-filter>
 *         &lt;action android:name="android.media.browse.MediaBrowserService" />
 *     &lt;/intent-filter>
 * &lt;/service>
 * </pre>
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class MediaBrowserService extends android.app.Service {

public MediaBrowserService() { throw new RuntimeException("Stub!"); }

public void onCreate() { throw new RuntimeException("Stub!"); }

public android.os.IBinder onBind(android.content.Intent intent) { throw new RuntimeException("Stub!"); }

public void dump(java.io.FileDescriptor fd, java.io.PrintWriter writer, java.lang.String[] args) { throw new RuntimeException("Stub!"); }

/**
 * Called to get the root information for browsing by a particular client.
 * <p>
 * The implementation should verify that the client package has permission
 * to access browse media information before returning the root id; it
 * should return null if the client is not allowed to access this
 * information.
 * </p>
 *
 * @param clientPackageName The package name of the application which is
 *            requesting access to browse media.
 * This value must never be {@code null}.
 * @param clientUid The uid of the application which is requesting access to
 *            browse media.
 * @param rootHints An optional bundle of service-specific arguments to send
 *            to the media browser service when connecting and retrieving the
 *            root id for browsing, or null if none. The contents of this
 *            bundle may affect the information returned when browsing.
 * This value may be {@code null}.
 * @return The {@link BrowserRoot} for accessing this app's content or null.
 * @see BrowserRoot#EXTRA_RECENT
 * @see BrowserRoot#EXTRA_OFFLINE
 * @see BrowserRoot#EXTRA_SUGGESTED
 */

@androidx.annotation.RecentlyNullable public abstract android.service.media.MediaBrowserService.BrowserRoot onGetRoot(@androidx.annotation.RecentlyNonNull java.lang.String clientPackageName, int clientUid, @androidx.annotation.RecentlyNullable android.os.Bundle rootHints);

/**
 * Called to get information about the children of a media item.
 * <p>
 * Implementations must call {@link Result#sendResult result.sendResult}
 * with the list of children. If loading the children will be an expensive
 * operation that should be performed on another thread,
 * {@link Result#detach result.detach} may be called before returning from
 * this function, and then {@link Result#sendResult result.sendResult}
 * called when the loading is complete.
 * </p><p>
 * In case the media item does not have any children, call {@link Result#sendResult}
 * with an empty list. When the given {@code parentId} is invalid, implementations must
 * call {@link Result#sendResult result.sendResult} with {@code null}, which will invoke
 * {@link MediaBrowser.SubscriptionCallback#onError}.
 * </p>
 *
 * @param parentId The id of the parent media item whose children are to be
 *            queried.
 * This value must never be {@code null}.
 * @param result The Result to send the list of children to.

 * This value must never be {@code null}.
 */

public abstract void onLoadChildren(@androidx.annotation.RecentlyNonNull java.lang.String parentId, @androidx.annotation.RecentlyNonNull android.service.media.MediaBrowserService.Result<java.util.List<android.media.browse.MediaBrowser.MediaItem>> result);

/**
 * Called to get information about the children of a media item.
 * <p>
 * Implementations must call {@link Result#sendResult result.sendResult}
 * with the list of children. If loading the children will be an expensive
 * operation that should be performed on another thread,
 * {@link Result#detach result.detach} may be called before returning from
 * this function, and then {@link Result#sendResult result.sendResult}
 * called when the loading is complete.
 * </p><p>
 * In case the media item does not have any children, call {@link Result#sendResult}
 * with an empty list. When the given {@code parentId} is invalid, implementations must
 * call {@link Result#sendResult result.sendResult} with {@code null}, which will invoke
 * {@link MediaBrowser.SubscriptionCallback#onError}.
 * </p>
 *
 * @param parentId The id of the parent media item whose children are to be
 *            queried.
 * This value must never be {@code null}.
 * @param result The Result to send the list of children to.
 * This value must never be {@code null}.
 * @param options The bundle of service-specific arguments sent from the media
 *            browser. The information returned through the result should be
 *            affected by the contents of this bundle.

 * This value must never be {@code null}.
 */

public void onLoadChildren(@androidx.annotation.RecentlyNonNull java.lang.String parentId, @androidx.annotation.RecentlyNonNull android.service.media.MediaBrowserService.Result<java.util.List<android.media.browse.MediaBrowser.MediaItem>> result, @androidx.annotation.RecentlyNonNull android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * Called to get information about a specific media item.
 * <p>
 * Implementations must call {@link Result#sendResult result.sendResult}. If
 * loading the item will be an expensive operation {@link Result#detach
 * result.detach} may be called before returning from this function, and
 * then {@link Result#sendResult result.sendResult} called when the item has
 * been loaded.
 * </p><p>
 * When the given {@code itemId} is invalid, implementations must call
 * {@link Result#sendResult result.sendResult} with {@code null}.
 * </p><p>
 * The default implementation will invoke {@link MediaBrowser.ItemCallback#onError}.
 * </p>
 *
 * @param itemId The id for the specific
 *            {@link android.media.browse.MediaBrowser.MediaItem}.
 * @param result The Result to send the item to.
 */

public void onLoadItem(java.lang.String itemId, android.service.media.MediaBrowserService.Result<android.media.browse.MediaBrowser.MediaItem> result) { throw new RuntimeException("Stub!"); }

/**
 * Call to set the media session.
 * <p>
 * This should be called as soon as possible during the service's startup.
 * It may only be called once.
 *
 * @param token The token for the service's {@link MediaSession}.
 */

public void setSessionToken(android.media.session.MediaSession.Token token) { throw new RuntimeException("Stub!"); }

/**
 * Gets the session token, or null if it has not yet been created
 * or if it has been destroyed.
 */

@androidx.annotation.RecentlyNullable public android.media.session.MediaSession.Token getSessionToken() { throw new RuntimeException("Stub!"); }

/**
 * Gets the root hints sent from the currently connected {@link MediaBrowser}.
 * The root hints are service-specific arguments included in an optional bundle sent to the
 * media browser service when connecting and retrieving the root id for browsing, or null if
 * none. The contents of this bundle may affect the information returned when browsing.
 *
 * @throws IllegalStateException If this method is called outside of {@link #onGetRoot} or
 *             {@link #onLoadChildren} or {@link #onLoadItem}.
 * @see MediaBrowserService.BrowserRoot#EXTRA_RECENT
 * @see MediaBrowserService.BrowserRoot#EXTRA_OFFLINE
 * @see MediaBrowserService.BrowserRoot#EXTRA_SUGGESTED
 */

public final android.os.Bundle getBrowserRootHints() { throw new RuntimeException("Stub!"); }

/**
 * Gets the browser information who sent the current request.
 *
 * @throws IllegalStateException If this method is called outside of {@link #onGetRoot} or
 *             {@link #onLoadChildren} or {@link #onLoadItem}.
 * @see MediaSessionManager#isTrustedForMediaControl(RemoteUserInfo)
 */

public final android.media.session.MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() { throw new RuntimeException("Stub!"); }

/**
 * Notifies all connected media browsers that the children of
 * the specified parent id have changed in some way.
 * This will cause browsers to fetch subscribed content again.
 *
 * @param parentId The id of the parent media item whose
 * children changed.

 * This value must never be {@code null}.
 */

public void notifyChildrenChanged(@androidx.annotation.RecentlyNonNull java.lang.String parentId) { throw new RuntimeException("Stub!"); }

/**
 * Notifies all connected media browsers that the children of
 * the specified parent id have changed in some way.
 * This will cause browsers to fetch subscribed content again.
 *
 * @param parentId The id of the parent media item whose
 *            children changed.
 * This value must never be {@code null}.
 * @param options The bundle of service-specific arguments to send
 *            to the media browser. The contents of this bundle may
 *            contain the information about the change.

 * This value must never be {@code null}.
 */

public void notifyChildrenChanged(@androidx.annotation.RecentlyNonNull java.lang.String parentId, @androidx.annotation.RecentlyNonNull android.os.Bundle options) { throw new RuntimeException("Stub!"); }

/**
 * The {@link Intent} that must be declared as handled by the service.
 */

public static final java.lang.String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
/**
 * Contains information that the browser service needs to send to the client
 * when first connected.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class BrowserRoot {

/**
 * Constructs a browser root.
 * @param rootId The root id for browsing.
 * This value must never be {@code null}.
 * @param extras Any extras about the browser service.

 * This value may be {@code null}.
 */

public BrowserRoot(@androidx.annotation.RecentlyNonNull java.lang.String rootId, @androidx.annotation.RecentlyNullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Gets the root id for browsing.
 */

public java.lang.String getRootId() { throw new RuntimeException("Stub!"); }

/**
 * Gets any extras about the browser service.
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * The lookup key for a boolean that indicates whether the browser service should return a
 * browser root for offline media items.
 *
 * <p>When creating a media browser for a given media browser service, this key can be
 * supplied as a root hint for retrieving media items that are can be played without an
 * internet connection.
 * If the media browser service can provide such media items, the implementation must return
 * the key in the root hint when {@link #onGetRoot(String, int, Bundle)} is called back.
 *
 * <p>The root hint may contain multiple keys.
 *
 * @see #EXTRA_RECENT
 * @see #EXTRA_SUGGESTED
 */

public static final java.lang.String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";

/**
 * The lookup key for a boolean that indicates whether the browser service should return a
 * browser root for recently played media items.
 *
 * <p>When creating a media browser for a given media browser service, this key can be
 * supplied as a root hint for retrieving media items that are recently played.
 * If the media browser service can provide such media items, the implementation must return
 * the key in the root hint when {@link #onGetRoot(String, int, Bundle)} is called back.
 *
 * <p>The root hint may contain multiple keys.
 *
 * @see #EXTRA_OFFLINE
 * @see #EXTRA_SUGGESTED
 */

public static final java.lang.String EXTRA_RECENT = "android.service.media.extra.RECENT";

/**
 * The lookup key for a boolean that indicates whether the browser service should return a
 * browser root for suggested media items.
 *
 * <p>When creating a media browser for a given media browser service, this key can be
 * supplied as a root hint for retrieving the media items suggested by the media browser
 * service. The list of media items passed in {@link android.media.browse.MediaBrowser.SubscriptionCallback#onChildrenLoaded(String, List)}
 * is considered ordered by relevance, first being the top suggestion.
 * If the media browser service can provide such media items, the implementation must return
 * the key in the root hint when {@link #onGetRoot(String, int, Bundle)} is called back.
 *
 * <p>The root hint may contain multiple keys.
 *
 * @see #EXTRA_RECENT
 * @see #EXTRA_OFFLINE
 */

public static final java.lang.String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
}

/**
 * Completion handler for asynchronous callback methods in {@link MediaBrowserService}.
 * <p>
 * Each of the methods that takes one of these to send the result must call
 * {@link #sendResult} to respond to the caller with the given results. If those
 * functions return without calling {@link #sendResult}, they must instead call
 * {@link #detach} before returning, and then may call {@link #sendResult} when
 * they are done. If more than one of those methods is called, an exception will
 * be thrown.
 *
 * @see #onLoadChildren
 * @see #onLoadItem
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Result<T> {

Result(java.lang.Object debug) { throw new RuntimeException("Stub!"); }

/**
 * Send the result back to the caller.
 */

public void sendResult(T result) { throw new RuntimeException("Stub!"); }

/**
 * Detach this message from the current thread and allow the {@link #sendResult}
 * call to happen later.
 */

public void detach() { throw new RuntimeException("Stub!"); }
}

}

