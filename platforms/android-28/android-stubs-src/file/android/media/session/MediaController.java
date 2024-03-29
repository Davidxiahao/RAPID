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

import android.media.MediaMetadata;
import android.media.Rating;
import android.app.PendingIntent;
import android.media.VolumeProvider;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;

/**
 * Allows an app to interact with an ongoing media session. Media buttons and
 * other commands can be sent to the session. A callback may be registered to
 * receive updates from the session, such as metadata and play state changes.
 * <p>
 * A MediaController can be created through {@link MediaSessionManager} if you
 * hold the "android.permission.MEDIA_CONTENT_CONTROL" permission or are an
 * enabled notification listener or by getting a {@link MediaSession.Token}
 * directly from the session owner.
 * <p>
 * MediaController objects are thread-safe.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaController {

/**
 * Create a new MediaController from a session's token.
 *
 * @param context The caller's context.
 * This value must never be {@code null}.
 * @param token The token for the session.

 * This value must never be {@code null}.
 */

public MediaController(@androidx.annotation.RecentlyNonNull android.content.Context context, @androidx.annotation.RecentlyNonNull android.media.session.MediaSession.Token token) { throw new RuntimeException("Stub!"); }

/**
 * Get a {@link TransportControls} instance to send transport actions to
 * the associated session.
 *
 * @return A transport controls instance.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.media.session.MediaController.TransportControls getTransportControls() { throw new RuntimeException("Stub!"); }

/**
 * Send the specified media button event to the session. Only media keys can
 * be sent by this method, other keys will be ignored.
 *
 * @param keyEvent The media button event to dispatch.
 * This value must never be {@code null}.
 * @return true if the event was sent to the session, false otherwise.
 */

public boolean dispatchMediaButtonEvent(@androidx.annotation.RecentlyNonNull android.view.KeyEvent keyEvent) { throw new RuntimeException("Stub!"); }

/**
 * Get the current playback state for this session.
 *
 * @return The current PlaybackState or null
 */

@androidx.annotation.RecentlyNullable public android.media.session.PlaybackState getPlaybackState() { throw new RuntimeException("Stub!"); }

/**
 * Get the current metadata for this session.
 *
 * @return The current MediaMetadata or null.
 */

@androidx.annotation.RecentlyNullable public android.media.MediaMetadata getMetadata() { throw new RuntimeException("Stub!"); }

/**
 * Get the current play queue for this session if one is set. If you only
 * care about the current item {@link #getMetadata()} should be used.
 *
 * @return The current play queue or null.
 */

@androidx.annotation.RecentlyNullable public java.util.List<android.media.session.MediaSession.QueueItem> getQueue() { throw new RuntimeException("Stub!"); }

/**
 * Get the queue title for this session.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getQueueTitle() { throw new RuntimeException("Stub!"); }

/**
 * Get the extras for this session.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Get the rating type supported by the session. One of:
 * <ul>
 * <li>{@link Rating#RATING_NONE}</li>
 * <li>{@link Rating#RATING_HEART}</li>
 * <li>{@link Rating#RATING_THUMB_UP_DOWN}</li>
 * <li>{@link Rating#RATING_3_STARS}</li>
 * <li>{@link Rating#RATING_4_STARS}</li>
 * <li>{@link Rating#RATING_5_STARS}</li>
 * <li>{@link Rating#RATING_PERCENTAGE}</li>
 * </ul>
 *
 * @return The supported rating type
 */

public int getRatingType() { throw new RuntimeException("Stub!"); }

/**
 * Get the flags for this session. Flags are defined in {@link MediaSession}.
 *
 * @return The current set of flags for the session.

 * Value is either <code>0</code> or a combination of {@link android.media.session.MediaSession#FLAG_HANDLES_MEDIA_BUTTONS}, {@link android.media.session.MediaSession#FLAG_HANDLES_TRANSPORT_CONTROLS}, and android.media.session.MediaSession.FLAG_EXCLUSIVE_GLOBAL_PRIORITY
 */

public long getFlags() { throw new RuntimeException("Stub!"); }

/**
 * Get the current playback info for this session.
 *
 * @return The current playback info or null.
 */

@androidx.annotation.RecentlyNullable public android.media.session.MediaController.PlaybackInfo getPlaybackInfo() { throw new RuntimeException("Stub!"); }

/**
 * Get an intent for launching UI associated with this session if one
 * exists.
 *
 * @return A {@link PendingIntent} to launch UI or null.
 */

@androidx.annotation.RecentlyNullable public android.app.PendingIntent getSessionActivity() { throw new RuntimeException("Stub!"); }

/**
 * Get the token for the session this is connected to.
 *
 * @return The token for the connected session.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.media.session.MediaSession.Token getSessionToken() { throw new RuntimeException("Stub!"); }

/**
 * Set the volume of the output this session is playing on. The command will
 * be ignored if it does not support
 * {@link VolumeProvider#VOLUME_CONTROL_ABSOLUTE}. The flags in
 * {@link AudioManager} may be used to affect the handling.
 *
 * @see #getPlaybackInfo()
 * @param value The value to set it to, between 0 and the reported max.
 * @param flags Flags from {@link AudioManager} to include with the volume
 *            request.
 */

public void setVolumeTo(int value, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Adjust the volume of the output this session is playing on. The direction
 * must be one of {@link AudioManager#ADJUST_LOWER},
 * {@link AudioManager#ADJUST_RAISE}, or {@link AudioManager#ADJUST_SAME}.
 * The command will be ignored if the session does not support
 * {@link VolumeProvider#VOLUME_CONTROL_RELATIVE} or
 * {@link VolumeProvider#VOLUME_CONTROL_ABSOLUTE}. The flags in
 * {@link AudioManager} may be used to affect the handling.
 *
 * @see #getPlaybackInfo()
 * @param direction The direction to adjust the volume in.
 * @param flags Any flags to pass with the command.
 */

public void adjustVolume(int direction, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback to receive updates from the Session. Updates will be
 * posted on the caller's thread.
 *
 * @param callback The callback object, must not be null.

 * This value must never be {@code null}.
 */

public void registerCallback(@androidx.annotation.RecentlyNonNull android.media.session.MediaController.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Registers a callback to receive updates from the session. Updates will be
 * posted on the specified handler's thread.
 *
 * @param callback The callback object, must not be null.
 * This value must never be {@code null}.
 * @param handler The handler to post updates on. If null the callers thread
 *            will be used.

 * This value may be {@code null}.
 */

public void registerCallback(@androidx.annotation.RecentlyNonNull android.media.session.MediaController.Callback callback, @androidx.annotation.RecentlyNullable android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Unregisters the specified callback. If an update has already been posted
 * you may still receive it after calling this method.
 *
 * @param callback The callback to remove.

 * This value must never be {@code null}.
 */

public void unregisterCallback(@androidx.annotation.RecentlyNonNull android.media.session.MediaController.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Sends a generic command to the session. It is up to the session creator
 * to decide what commands and parameters they will support. As such,
 * commands should only be sent to sessions that the controller owns.
 *
 * @param command The command to send
 * This value must never be {@code null}.
 * @param args Any parameters to include with the command
 * This value may be {@code null}.
 * @param cb The callback to receive the result on

 * This value may be {@code null}.
 */

public void sendCommand(@androidx.annotation.RecentlyNonNull java.lang.String command, @androidx.annotation.RecentlyNullable android.os.Bundle args, @androidx.annotation.RecentlyNullable android.os.ResultReceiver cb) { throw new RuntimeException("Stub!"); }

/**
 * Get the session owner's package name.
 *
 * @return The package name of of the session owner.
 */

public java.lang.String getPackageName() { throw new RuntimeException("Stub!"); }
/**
 * Callback for receiving updates from the session. A Callback can be
 * registered using {@link #registerCallback}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract static class Callback {

public Callback() { throw new RuntimeException("Stub!"); }

/**
 * Override to handle the session being destroyed. The session is no
 * longer valid after this call and calls to it will be ignored.
 */

public void onSessionDestroyed() { throw new RuntimeException("Stub!"); }

/**
 * Override to handle custom events sent by the session owner without a
 * specified interface. Controllers should only handle these for
 * sessions they own.
 *
 * @param event The event from the session.
 * This value must never be {@code null}.
 * @param extras Optional parameters for the event, may be null.

 * This value may be {@code null}.
 */

public void onSessionEvent(@androidx.annotation.RecentlyNonNull java.lang.String event, @androidx.annotation.RecentlyNullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle changes in playback state.
 *
 * @param state The new playback state of the session

 * This value may be {@code null}.
 */

public void onPlaybackStateChanged(@androidx.annotation.RecentlyNullable android.media.session.PlaybackState state) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle changes to the current metadata.
 *
 * @param metadata The current metadata for the session or null if none.
 * This value may be {@code null}.
 * @see MediaMetadata
 */

public void onMetadataChanged(@androidx.annotation.RecentlyNullable android.media.MediaMetadata metadata) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle changes to items in the queue.
 *
 * @param queue A list of items in the current play queue. It should
 *            include the currently playing item as well as previous and
 *            upcoming items if applicable.
 * This value may be {@code null}.
 * @see MediaSession.QueueItem
 */

public void onQueueChanged(@androidx.annotation.RecentlyNullable java.util.List<android.media.session.MediaSession.QueueItem> queue) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle changes to the queue title.
 *
 * @param title The title that should be displayed along with the play queue such as
 *              "Now Playing". May be null if there is no such title.

 * This value may be {@code null}.
 */

public void onQueueTitleChanged(@androidx.annotation.RecentlyNullable java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle changes to the {@link MediaSession} extras.
 *
 * @param extras The extras that can include other information associated with the
 *               {@link MediaSession}.

 * This value may be {@code null}.
 */

public void onExtrasChanged(@androidx.annotation.RecentlyNullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Override to handle changes to the audio info.
 *
 * @param info The current audio info for this session.
 */

public void onAudioInfoChanged(android.media.session.MediaController.PlaybackInfo info) { throw new RuntimeException("Stub!"); }
}

/**
 * Holds information about the current playback and how audio is handled for
 * this session.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class PlaybackInfo {

/**
 * @hide
 */

PlaybackInfo(int type, android.media.AudioAttributes attrs, int control, int max, int current) { throw new RuntimeException("Stub!"); }

/**
 * Get the type of playback which affects volume handling. One of:
 * <ul>
 * <li>{@link #PLAYBACK_TYPE_LOCAL}</li>
 * <li>{@link #PLAYBACK_TYPE_REMOTE}</li>
 * </ul>
 *
 * @return The type of playback this session is using.
 */

public int getPlaybackType() { throw new RuntimeException("Stub!"); }

/**
 * Get the audio attributes for this session. The attributes will affect
 * volume handling for the session. When the volume type is
 * {@link PlaybackInfo#PLAYBACK_TYPE_REMOTE} these may be ignored by the
 * remote volume handler.
 *
 * @return The attributes for this session.
 */

public android.media.AudioAttributes getAudioAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Get the type of volume control that can be used. One of:
 * <ul>
 * <li>{@link VolumeProvider#VOLUME_CONTROL_ABSOLUTE}</li>
 * <li>{@link VolumeProvider#VOLUME_CONTROL_RELATIVE}</li>
 * <li>{@link VolumeProvider#VOLUME_CONTROL_FIXED}</li>
 * </ul>
 *
 * @return The type of volume control that may be used with this
 *         session.
 */

public int getVolumeControl() { throw new RuntimeException("Stub!"); }

/**
 * Get the maximum volume that may be set for this session.
 *
 * @return The maximum allowed volume where this session is playing.
 */

public int getMaxVolume() { throw new RuntimeException("Stub!"); }

/**
 * Get the current volume for this session.
 *
 * @return The current volume where this session is playing.
 */

public int getCurrentVolume() { throw new RuntimeException("Stub!"); }

/**
 * The session uses local playback.
 */

public static final int PLAYBACK_TYPE_LOCAL = 1; // 0x1

/**
 * The session uses remote playback.
 */

public static final int PLAYBACK_TYPE_REMOTE = 2; // 0x2
}

/**
 * Interface for controlling media playback on a session. This allows an app
 * to send media transport commands to the session.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class TransportControls {

TransportControls() { throw new RuntimeException("Stub!"); }

/**
 * Request that the player prepare its playback. In other words, other sessions can continue
 * to play during the preparation of this session. This method can be used to speed up the
 * start of the playback. Once the preparation is done, the session will change its playback
 * state to {@link PlaybackState#STATE_PAUSED}. Afterwards, {@link #play} can be called to
 * start playback.
 */

public void prepare() { throw new RuntimeException("Stub!"); }

/**
 * Request that the player prepare playback for a specific media id. In other words, other
 * sessions can continue to play during the preparation of this session. This method can be
 * used to speed up the start of the playback. Once the preparation is done, the session
 * will change its playback state to {@link PlaybackState#STATE_PAUSED}. Afterwards,
 * {@link #play} can be called to start playback. If the preparation is not needed,
 * {@link #playFromMediaId} can be directly called without this method.
 *
 * @param mediaId The id of the requested media.
 * @param extras Optional extras that can include extra information about the media item
 *               to be prepared.
 */

public void prepareFromMediaId(java.lang.String mediaId, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Request that the player prepare playback for a specific search query. An empty or null
 * query should be treated as a request to prepare any music. In other words, other sessions
 * can continue to play during the preparation of this session. This method can be used to
 * speed up the start of the playback. Once the preparation is done, the session will
 * change its playback state to {@link PlaybackState#STATE_PAUSED}. Afterwards,
 * {@link #play} can be called to start playback. If the preparation is not needed,
 * {@link #playFromSearch} can be directly called without this method.
 *
 * @param query The search query.
 * @param extras Optional extras that can include extra information
 *               about the query.
 */

public void prepareFromSearch(java.lang.String query, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Request that the player prepare playback for a specific {@link Uri}. In other words,
 * other sessions can continue to play during the preparation of this session. This method
 * can be used to speed up the start of the playback. Once the preparation is done, the
 * session will change its playback state to {@link PlaybackState#STATE_PAUSED}. Afterwards,
 * {@link #play} can be called to start playback. If the preparation is not needed,
 * {@link #playFromUri} can be directly called without this method.
 *
 * @param uri The URI of the requested media.
 * @param extras Optional extras that can include extra information about the media item
 *               to be prepared.
 */

public void prepareFromUri(android.net.Uri uri, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Request that the player start its playback at its current position.
 */

public void play() { throw new RuntimeException("Stub!"); }

/**
 * Request that the player start playback for a specific media id.
 *
 * @param mediaId The id of the requested media.
 * @param extras Optional extras that can include extra information about the media item
 *               to be played.
 */

public void playFromMediaId(java.lang.String mediaId, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Request that the player start playback for a specific search query.
 * An empty or null query should be treated as a request to play any
 * music.
 *
 * @param query The search query.
 * @param extras Optional extras that can include extra information
 *               about the query.
 */

public void playFromSearch(java.lang.String query, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Request that the player start playback for a specific {@link Uri}.
 *
 * @param uri The URI of the requested media.
 * @param extras Optional extras that can include extra information about the media item
 *               to be played.
 */

public void playFromUri(android.net.Uri uri, android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Play an item with a specific id in the play queue. If you specify an
 * id that is not in the play queue, the behavior is undefined.
 */

public void skipToQueueItem(long id) { throw new RuntimeException("Stub!"); }

/**
 * Request that the player pause its playback and stay at its current
 * position.
 */

public void pause() { throw new RuntimeException("Stub!"); }

/**
 * Request that the player stop its playback; it may clear its state in
 * whatever way is appropriate.
 */

public void stop() { throw new RuntimeException("Stub!"); }

/**
 * Move to a new location in the media stream.
 *
 * @param pos Position to move to, in milliseconds.
 */

public void seekTo(long pos) { throw new RuntimeException("Stub!"); }

/**
 * Start fast forwarding. If playback is already fast forwarding this
 * may increase the rate.
 */

public void fastForward() { throw new RuntimeException("Stub!"); }

/**
 * Skip to the next item.
 */

public void skipToNext() { throw new RuntimeException("Stub!"); }

/**
 * Start rewinding. If playback is already rewinding this may increase
 * the rate.
 */

public void rewind() { throw new RuntimeException("Stub!"); }

/**
 * Skip to the previous item.
 */

public void skipToPrevious() { throw new RuntimeException("Stub!"); }

/**
 * Rate the current content. This will cause the rating to be set for
 * the current user. The Rating type must match the type returned by
 * {@link #getRatingType()}.
 *
 * @param rating The rating to set for the current content
 */

public void setRating(android.media.Rating rating) { throw new RuntimeException("Stub!"); }

/**
 * Send a custom action back for the {@link MediaSession} to perform.
 *
 * @param customAction The action to perform.
 * This value must never be {@code null}.
 * @param args Optional arguments to supply to the {@link MediaSession} for this
 *             custom action.

 * This value may be {@code null}.
 */

public void sendCustomAction(@androidx.annotation.RecentlyNonNull android.media.session.PlaybackState.CustomAction customAction, @androidx.annotation.RecentlyNullable android.os.Bundle args) { throw new RuntimeException("Stub!"); }

/**
 * Send the id and args from a custom action back for the {@link MediaSession} to perform.
 *
 * @see #sendCustomAction(PlaybackState.CustomAction action, Bundle args)
 * @param action The action identifier of the {@link PlaybackState.CustomAction} as
 *               specified by the {@link MediaSession}.
 * This value must never be {@code null}.
 * @param args Optional arguments to supply to the {@link MediaSession} for this
 *             custom action.

 * This value may be {@code null}.
 */

public void sendCustomAction(@androidx.annotation.RecentlyNonNull java.lang.String action, @androidx.annotation.RecentlyNullable android.os.Bundle args) { throw new RuntimeException("Stub!"); }
}

}

