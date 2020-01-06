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


package android.provider;

import android.net.Uri;
import android.content.Context;
import android.content.Intent;
import java.io.File;
import android.service.media.CameraPrewarmService;
import android.graphics.Bitmap;
import android.content.ContentResolver;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The Media provider contains meta data for all available media on both internal
 * and external storage devices.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaStore {

public MediaStore() { throw new RuntimeException("Stub!"); }

/**
 * Uri for querying the state of the media scanner.
 */

public static android.net.Uri getMediaScannerUri() { throw new RuntimeException("Stub!"); }

/**
 * Get the media provider's version.
 * Applications that import data from the media provider into their own caches
 * can use this to detect that the media provider changed, and reimport data
 * as needed. No other assumptions should be made about the meaning of the version.
 * @param context Context to use for performing the query.
 * @return A version string, or null if the version could not be determined.
 */

public static java.lang.String getVersion(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Gets a URI backed by a {@link DocumentsProvider} that points to the same media
 * file as the specified mediaUri. This allows apps who have permissions to access
 * media files in Storage Access Framework to perform file operations through that
 * on media files.
 * <p>
 * Note: this method doesn't grant any URI permission. Callers need to obtain
 * permission before calling this method. One way to obtain permission is through
 * a 3-step process:
 * <ol>
 *     <li>Call {@link android.os.storage.StorageManager#getStorageVolume(File)} to
 *     obtain the {@link android.os.storage.StorageVolume} of a media file;</li>
 *
 *     <li>Invoke the intent returned by
 *     {@link android.os.storage.StorageVolume#createAccessIntent(String)} to
 *     obtain the access of the volume or one of its specific subdirectories;</li>
 *
 *     <li>Check whether permission is granted and take persistent permission.</li>
 * </ol>
 * @param mediaUri the media URI which document URI is requested
 * @return the document URI
 */

public static android.net.Uri getDocumentUri(android.content.Context context, android.net.Uri mediaUri) { throw new RuntimeException("Stub!"); }

/**
 * Standard Intent action that can be sent to have the camera application
 * capture an image and return it.
 * <p>
 * The caller may pass an extra EXTRA_OUTPUT to control where this image will be written.
 * If the EXTRA_OUTPUT is not present, then a small sized image is returned as a Bitmap
 * object in the extra field. This is useful for applications that only need a small image.
 * If the EXTRA_OUTPUT is present, then the full-sized image will be written to the Uri
 * value of EXTRA_OUTPUT.
 * As of {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this uri can also be supplied through
 * {@link android.content.Intent#setClipData(ClipData)}. If using this approach, you still must
 * supply the uri through the EXTRA_OUTPUT field for compatibility with old applications.
 * If you don't set a ClipData, it will be copied there for you when calling
 * {@link Context#startActivity(Intent)}.
 *
 * <p>Note: if you app targets {@link android.os.Build.VERSION_CODES#M M} and above
 * and declares as using the {@link android.Manifest.permission#CAMERA} permission which
 * is not granted, then attempting to use this action will result in a {@link
 * java.lang.SecurityException}.
 *
 *  @see #EXTRA_OUTPUT
 */

public static final java.lang.String ACTION_IMAGE_CAPTURE = "android.media.action.IMAGE_CAPTURE";

/**
 * Intent action that can be sent to have the camera application capture an image and return
 * it when the device is secured (e.g.&nbsp;with a pin, password, pattern, or face unlock).
 * Applications responding to this intent must not expose any personal content like existing
 * photos or videos on the device. The applications should be careful not to share any photo
 * or video with other applications or internet. The activity should use {@link
 * android.view.WindowManager.LayoutParams#FLAG_SHOW_WHEN_LOCKED} to display on top of the
 * lock screen while secured. There is no activity stack when this flag is used, so
 * launching more than one activity is strongly discouraged.
 * <p>
 * The caller may pass an extra EXTRA_OUTPUT to control where this image will be written.
 * If the EXTRA_OUTPUT is not present, then a small sized image is returned as a Bitmap
 * object in the extra field. This is useful for applications that only need a small image.
 * If the EXTRA_OUTPUT is present, then the full-sized image will be written to the Uri
 * value of EXTRA_OUTPUT.
 * As of {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this uri can also be supplied through
 * {@link android.content.Intent#setClipData(ClipData)}. If using this approach, you still must
 * supply the uri through the EXTRA_OUTPUT field for compatibility with old applications.
 * If you don't set a ClipData, it will be copied there for you when calling
 * {@link Context#startActivity(Intent)}.
 *
 * @see #ACTION_IMAGE_CAPTURE
 * @see #EXTRA_OUTPUT
 */

public static final java.lang.String ACTION_IMAGE_CAPTURE_SECURE = "android.media.action.IMAGE_CAPTURE_SECURE";

/**
 * Standard Intent action that can be sent to have the camera application
 * capture a video and return it.
 * <p>
 * The caller may pass in an extra EXTRA_VIDEO_QUALITY to control the video quality.
 * <p>
 * The caller may pass in an extra EXTRA_OUTPUT to control
 * where the video is written. If EXTRA_OUTPUT is not present the video will be
 * written to the standard location for videos, and the Uri of that location will be
 * returned in the data field of the Uri.
 * As of {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this uri can also be supplied through
 * {@link android.content.Intent#setClipData(ClipData)}. If using this approach, you still must
 * supply the uri through the EXTRA_OUTPUT field for compatibility with old applications.
 * If you don't set a ClipData, it will be copied there for you when calling
 * {@link Context#startActivity(Intent)}.
 *
 * <p>Note: if you app targets {@link android.os.Build.VERSION_CODES#M M} and above
 * and declares as using the {@link android.Manifest.permission#CAMERA} permission which
 * is not granted, then atempting to use this action will result in a {@link
 * java.lang.SecurityException}.
 *
 * @see #EXTRA_OUTPUT
 * @see #EXTRA_VIDEO_QUALITY
 * @see #EXTRA_SIZE_LIMIT
 * @see #EXTRA_DURATION_LIMIT
 */

public static final java.lang.String ACTION_VIDEO_CAPTURE = "android.media.action.VIDEO_CAPTURE";

public static final java.lang.String AUTHORITY = "media";

/**
 * Specify the maximum allowed recording duration in seconds.
 */

public static final java.lang.String EXTRA_DURATION_LIMIT = "android.intent.extra.durationLimit";

/**
 * The name of the Intent-extra used to control the onCompletion behavior of a MovieView.
 * This is a boolean property that specifies whether or not to finish the MovieView activity
 * when the movie completes playing. The default value is true, which means to automatically
 * exit the movie player activity when the movie completes playing.
 */

public static final java.lang.String EXTRA_FINISH_ON_COMPLETION = "android.intent.extra.finishOnCompletion";

/**
 * The name of an Intent-extra used to control the UI of a ViewImage.
 * This is a boolean property that overrides the activity's default fullscreen state.
 */

public static final java.lang.String EXTRA_FULL_SCREEN = "android.intent.extra.fullScreen";

/**
 * The name of the Intent-extra used to define the album
 */

public static final java.lang.String EXTRA_MEDIA_ALBUM = "android.intent.extra.album";

/**
 * The name of the Intent-extra used to define the artist
 */

public static final java.lang.String EXTRA_MEDIA_ARTIST = "android.intent.extra.artist";

/**
 * The name of the Intent-extra used to define the search focus. The search focus
 * indicates whether the search should be for things related to the artist, album
 * or song that is identified by the other extras.
 */

public static final java.lang.String EXTRA_MEDIA_FOCUS = "android.intent.extra.focus";

/**
 * The name of the Intent-extra used to define the genre.
 */

public static final java.lang.String EXTRA_MEDIA_GENRE = "android.intent.extra.genre";

/**
 * The name of the Intent-extra used to define the playlist.
 */

public static final java.lang.String EXTRA_MEDIA_PLAYLIST = "android.intent.extra.playlist";

/**
 * The name of the Intent-extra used to define the radio channel.
 */

public static final java.lang.String EXTRA_MEDIA_RADIO_CHANNEL = "android.intent.extra.radio_channel";

/**
 * The name of the Intent-extra used to define the song title
 */

public static final java.lang.String EXTRA_MEDIA_TITLE = "android.intent.extra.title";

/**
 * The name of the Intent-extra used to indicate a content resolver Uri to be used to
 * store the requested image or video.
 */

public static final java.lang.String EXTRA_OUTPUT = "output";

/**
 * The name of the Intent-extra used to control the orientation of a ViewImage or a MovieView.
 * This is an int property that overrides the activity's requestedOrientation.
 * @see android.content.pm.ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
 */

public static final java.lang.String EXTRA_SCREEN_ORIENTATION = "android.intent.extra.screenOrientation";

/**
 * The name of an Intent-extra used to control the UI of a ViewImage.
 * This is a boolean property that specifies whether or not to show action icons.
 */

public static final java.lang.String EXTRA_SHOW_ACTION_ICONS = "android.intent.extra.showActionIcons";

/**
 * Specify the maximum allowed size.
 */

public static final java.lang.String EXTRA_SIZE_LIMIT = "android.intent.extra.sizeLimit";

/**
 * The name of the Intent-extra used to control the quality of a recorded video. This is an
 * integer property. Currently value 0 means low quality, suitable for MMS messages, and
 * value 1 means high quality. In the future other quality levels may be added.
 */

public static final java.lang.String EXTRA_VIDEO_QUALITY = "android.intent.extra.videoQuality";

/**
 * An intent to perform a search for music media and automatically play content from the
 * result when possible. This can be fired, for example, by the result of a voice recognition
 * command to listen to music.
 * <p>This intent always includes the {@link android.provider.MediaStore#EXTRA_MEDIA_FOCUS}
 * and {@link android.app.SearchManager#QUERY} extras. The
 * {@link android.provider.MediaStore#EXTRA_MEDIA_FOCUS} extra determines the search mode, and
 * the value of the {@link android.app.SearchManager#QUERY} extra depends on the search mode.
 * For more information about the search modes for this intent, see
 * <a href="{@docRoot}guide/components/intents-common.html#PlaySearch">Play music based
 * on a search query</a> in <a href="{@docRoot}guide/components/intents-common.html">Common
 * Intents</a>.</p>
 *
 * <p>This intent makes the most sense for apps that can support large-scale search of music,
 * such as services connected to an online database of music which can be streamed and played
 * on the device.</p>
 */

public static final java.lang.String INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH = "android.media.action.MEDIA_PLAY_FROM_SEARCH";

/**
 * Activity Action: Perform a search for media.
 * Contains at least the {@link android.app.SearchManager#QUERY} extra.
 * May also contain any combination of the following extras:
 * EXTRA_MEDIA_ARTIST, EXTRA_MEDIA_ALBUM, EXTRA_MEDIA_TITLE, EXTRA_MEDIA_FOCUS
 *
 * @see android.provider.MediaStore#EXTRA_MEDIA_ARTIST
 * @see android.provider.MediaStore#EXTRA_MEDIA_ALBUM
 * @see android.provider.MediaStore#EXTRA_MEDIA_TITLE
 * @see android.provider.MediaStore#EXTRA_MEDIA_FOCUS
 */

public static final java.lang.String INTENT_ACTION_MEDIA_SEARCH = "android.intent.action.MEDIA_SEARCH";

/**
 * Activity Action: Launch a music player.
 * The activity should be able to play, browse, or manipulate music files stored on the device.
 *
 * @deprecated Use {@link android.content.Intent#CATEGORY_APP_MUSIC} instead.
 */

@Deprecated public static final java.lang.String INTENT_ACTION_MUSIC_PLAYER = "android.intent.action.MUSIC_PLAYER";

/**
 * The name of the Intent action used to launch a camera in still image mode.
 */

public static final java.lang.String INTENT_ACTION_STILL_IMAGE_CAMERA = "android.media.action.STILL_IMAGE_CAMERA";

/**
 * The name of the Intent action used to launch a camera in still image mode
 * for use when the device is secured (e.g.&nbsp;with a pin, password, pattern,
 * or face unlock). Applications responding to this intent must not expose
 * any personal content like existing photos or videos on the device. The
 * applications should be careful not to share any photo or video with other
 * applications or internet. The activity should use {@link
 * android.view.WindowManager.LayoutParams#FLAG_SHOW_WHEN_LOCKED} to display
 * on top of the lock screen while secured. There is no activity stack when
 * this flag is used, so launching more than one activity is strongly
 * discouraged.
 */

public static final java.lang.String INTENT_ACTION_STILL_IMAGE_CAMERA_SECURE = "android.media.action.STILL_IMAGE_CAMERA_SECURE";

/**
 * An intent to perform a search for readable media and automatically play content from the
 * result when possible. This can be fired, for example, by the result of a voice recognition
 * command to read a book or magazine.
 * <p>
 * Contains the {@link android.app.SearchManager#QUERY} extra, which is a string that can
 * contain any type of unstructured text search, like the name of a book or magazine, an author
 * a genre, a publisher, or any combination of these.
 * <p>
 * Because this intent includes an open-ended unstructured search string, it makes the most
 * sense for apps that can support large-scale search of text media, such as services connected
 * to an online database of books and/or magazines which can be read on the device.
 */

public static final java.lang.String INTENT_ACTION_TEXT_OPEN_FROM_SEARCH = "android.media.action.TEXT_OPEN_FROM_SEARCH";

/**
 * The name of the Intent action used to launch a camera in video mode.
 */

public static final java.lang.String INTENT_ACTION_VIDEO_CAMERA = "android.media.action.VIDEO_CAMERA";

/**
 * An intent to perform a search for video media and automatically play content from the
 * result when possible. This can be fired, for example, by the result of a voice recognition
 * command to play movies.
 * <p>
 * Contains the {@link android.app.SearchManager#QUERY} extra, which is a string that can
 * contain any type of unstructured video search, like the name of a movie, one or more actors,
 * a genre, or any combination of these.
 * <p>
 * Because this intent includes an open-ended unstructured search string, it makes the most
 * sense for apps that can support large-scale search of video, such as services connected to an
 * online database of videos which can be streamed and played on the device.
 */

public static final java.lang.String INTENT_ACTION_VIDEO_PLAY_FROM_SEARCH = "android.media.action.VIDEO_PLAY_FROM_SEARCH";

/**
 * Name of the file signaling the media scanner to ignore media in the containing directory
 * and its subdirectories. Developers should use this to avoid application graphics showing
 * up in the Gallery and likewise prevent application sounds and music from showing up in
 * the Music app.
 */

public static final java.lang.String MEDIA_IGNORE_FILENAME = ".nomedia";

/**
 * Name of current volume being scanned by the media scanner.
 */

public static final java.lang.String MEDIA_SCANNER_VOLUME = "volume";

/**
 * Name under which an activity handling {@link #INTENT_ACTION_STILL_IMAGE_CAMERA} or
 * {@link #INTENT_ACTION_STILL_IMAGE_CAMERA_SECURE} publishes the service name for its prewarm
 * service.
 * <p>
 * This meta-data should reference the fully qualified class name of the prewarm service
 * extending {@link CameraPrewarmService}.
 * <p>
 * The prewarm service will get bound and receive a prewarm signal
 * {@link CameraPrewarmService#onPrewarm()} when a camera launch intent fire might be imminent.
 * An application implementing a prewarm service should do the absolute minimum amount of work
 * to initialize the camera in order to reduce startup time in likely case that shortly after a
 * camera launch intent would be sent.
 */

public static final java.lang.String META_DATA_STILL_IMAGE_CAMERA_PREWARM_SERVICE = "android.media.still_image_camera_preview_service";

/**
 * The string that is used when a media attribute is not known. For example,
 * if an audio file does not have any meta data, the artist and album columns
 * will be set to this value.
 */

public static final java.lang.String UNKNOWN_STRING = "<unknown>";
/**
 * Container for all audio content.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Audio {

public Audio() { throw new RuntimeException("Stub!"); }

/**
 * Converts a name to a "key" that can be used for grouping, sorting
 * and searching.
 * The rules that govern this conversion are:
 * - remove 'special' characters like ()[]'!?.,
 * - remove leading/trailing spaces
 * - convert everything to lowercase
 * - remove leading "the ", "an " and "a "
 * - remove trailing ", the|an|a"
 * - remove accents. This step leaves us with CollationKey data,
 *   which is not human readable
 *
 * @param name The artist or album name to convert
 * @return The "key" for the given name.
 */

public static java.lang.String keyFor(java.lang.String name) { throw new RuntimeException("Stub!"); }
/**
 * Columns representing an album
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface AlbumColumns {

/**
 * The album on which the audio file appears, if any
 * <P>Type: TEXT</P>
 */

public static final java.lang.String ALBUM = "album";

/**
 * Cached album art.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String ALBUM_ART = "album_art";

/**
 * The id for the album
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String ALBUM_ID = "album_id";

/**
 * A non human readable key calculated from the ALBUM, used for
 * searching, sorting and grouping
 * <P>Type: TEXT</P>
 */

public static final java.lang.String ALBUM_KEY = "album_key";

/**
 * The artist whose songs appear on this album
 * <P>Type: TEXT</P>
 */

public static final java.lang.String ARTIST = "artist";

/**
 * The year in which the earliest songs
 * on this album were released. This will often
 * be the same as {@link #LAST_YEAR}, but for compilation albums
 * they might differ.
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String FIRST_YEAR = "minyear";

/**
 * The year in which the latest songs
 * on this album were released. This will often
 * be the same as {@link #FIRST_YEAR}, but for compilation albums
 * they might differ.
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String LAST_YEAR = "maxyear";

/**
 * The number of songs on this album
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String NUMBER_OF_SONGS = "numsongs";

/**
 * This column is available when getting album info via artist,
 * and indicates the number of songs on the album by the given
 * artist.
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String NUMBER_OF_SONGS_FOR_ARTIST = "numsongs_by_artist";
}

/**
 * Contains artists for audio files
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Albums implements android.provider.BaseColumns, android.provider.MediaStore.Audio.AlbumColumns {

public Albums() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the albums table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the audio albums table on the given volume
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/albums";

/**
 * The default sort order for this table
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "album_key";

/**
 * The MIME type for entries in this table.
 */

public static final java.lang.String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/album";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
}

/**
 * Columns representing an artist
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ArtistColumns {

/**
 * The artist who created the audio file, if any
 * <P>Type: TEXT</P>
 */

public static final java.lang.String ARTIST = "artist";

/**
 * A non human readable key calculated from the ARTIST, used for
 * searching, sorting and grouping
 * <P>Type: TEXT</P>
 */

public static final java.lang.String ARTIST_KEY = "artist_key";

/**
 * The number of albums in the database for this artist
 */

public static final java.lang.String NUMBER_OF_ALBUMS = "number_of_albums";

/**
 * The number of albums in the database for this artist
 */

public static final java.lang.String NUMBER_OF_TRACKS = "number_of_tracks";
}

/**
 * Contains artists for audio files
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Artists implements android.provider.BaseColumns, android.provider.MediaStore.Audio.ArtistColumns {

public Artists() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the artists table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the audio artists table on the given volume
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/artists";

/**
 * The default sort order for this table
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "artist_key";

/**
 * The MIME type for entries in this table.
 */

public static final java.lang.String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/artist";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
/**
 * Sub-directory of each artist containing all albums on which
 * a song by the artist appears.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Albums implements android.provider.MediaStore.Audio.AlbumColumns {

public Albums() { throw new RuntimeException("Stub!"); }

public static android.net.Uri getContentUri(java.lang.String volumeName, long artistId) { throw new RuntimeException("Stub!"); }
}

}

/**
 * Columns for audio file that show up in multiple tables.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface AudioColumns extends android.provider.MediaStore.MediaColumns {

/**
 * The album the audio file is from, if any
 * <P>Type: TEXT</P>
 */

public static final java.lang.String ALBUM = "album";

/**
 * The id of the album the audio file is from, if any
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String ALBUM_ID = "album_id";

/**
 * A non human readable key calculated from the ALBUM, used for
 * searching, sorting and grouping
 * <P>Type: TEXT</P>
 */

public static final java.lang.String ALBUM_KEY = "album_key";

/**
 * The artist who created the audio file, if any
 * <P>Type: TEXT</P>
 */

public static final java.lang.String ARTIST = "artist";

/**
 * The id of the artist who created the audio file, if any
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String ARTIST_ID = "artist_id";

/**
 * A non human readable key calculated from the ARTIST, used for
 * searching, sorting and grouping
 * <P>Type: TEXT</P>
 */

public static final java.lang.String ARTIST_KEY = "artist_key";

/**
 * The position, in ms, playback was at when playback for this file
 * was last stopped.
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String BOOKMARK = "bookmark";

/**
 * The composer of the audio file, if any
 * <P>Type: TEXT</P>
 */

public static final java.lang.String COMPOSER = "composer";

/**
 * The duration of the audio file, in ms
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String DURATION = "duration";

/**
 * Non-zero if the audio file may be an alarm
 * <P>Type: INTEGER (boolean)</P>
 */

public static final java.lang.String IS_ALARM = "is_alarm";

/**
 * Non-zero if the audio file is music
 * <P>Type: INTEGER (boolean)</P>
 */

public static final java.lang.String IS_MUSIC = "is_music";

/**
 * Non-zero if the audio file may be a notification sound
 * <P>Type: INTEGER (boolean)</P>
 */

public static final java.lang.String IS_NOTIFICATION = "is_notification";

/**
 * Non-zero if the audio file is a podcast
 * <P>Type: INTEGER (boolean)</P>
 */

public static final java.lang.String IS_PODCAST = "is_podcast";

/**
 * Non-zero if the audio file may be a ringtone
 * <P>Type: INTEGER (boolean)</P>
 */

public static final java.lang.String IS_RINGTONE = "is_ringtone";

/**
 * A non human readable key calculated from the TITLE, used for
 * searching, sorting and grouping
 * <P>Type: TEXT</P>
 */

public static final java.lang.String TITLE_KEY = "title_key";

/**
 * The track number of this song on the album, if any.
 * This number encodes both the track number and the
 * disc number. For multi-disc sets, this number will
 * be 1xxx for tracks on the first disc, 2xxx for tracks
 * on the second disc, etc.
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String TRACK = "track";

/**
 * The year the audio file was recorded, if any
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String YEAR = "year";
}

/**
 * Contains all genres for audio files
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Genres implements android.provider.BaseColumns, android.provider.MediaStore.Audio.GenresColumns {

public Genres() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the audio genres table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the audio genres table on the given volume
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for querying the genres of an audio file.
 *
 * @param volumeName the name of the volume to get the URI for
 * @param audioId the ID of the audio file for which to retrieve the genres
 * @return the URI to for querying the genres for the audio file
 * with the given the volume and audioID
 */

public static android.net.Uri getContentUriForAudioId(java.lang.String volumeName, int audioId) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/genre";

/**
 * The default sort order for this table
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "name";

/**
 * The MIME type for entries in this table.
 */

public static final java.lang.String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/genre";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
/**
 * Sub-directory of each genre containing all members.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Members implements android.provider.MediaStore.Audio.AudioColumns {

public Members() { throw new RuntimeException("Stub!"); }

public static android.net.Uri getContentUri(java.lang.String volumeName, long genreId) { throw new RuntimeException("Stub!"); }

/**
 * The ID of the audio file
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String AUDIO_ID = "audio_id";

/**
 * A subdirectory of each genre containing all member audio files.
 */

public static final java.lang.String CONTENT_DIRECTORY = "members";

/**
 * The default sort order for this table
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "title_key";

/**
 * The ID of the genre
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String GENRE_ID = "genre_id";
}

}

/**
 * Columns representing an audio genre
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface GenresColumns {

/**
 * The name of the genre
 * <P>Type: TEXT</P>
 */

public static final java.lang.String NAME = "name";
}

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Media implements android.provider.MediaStore.Audio.AudioColumns {

public Media() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the audio media table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the audio media table on the given volume
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

public static android.net.Uri getContentUriForPath(java.lang.String path) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/audio";

/**
 * The default sort order for this table
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "title_key";

/**
 * The MIME type for an audio track.
 */

public static final java.lang.String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/audio";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The name of the Intent-extra used to define a maximum file size for
 * a recording made by the SoundRecorder application.
 *
 * @see #RECORD_SOUND_ACTION
 */

public static final java.lang.String EXTRA_MAX_BYTES = "android.provider.MediaStore.extra.MAX_BYTES";

/**
 * The content:// style URI for the internal storage.
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }

/**
 * Activity Action: Start SoundRecorder application.
 * <p>Input: nothing.
 * <p>Output: An uri to the recorded sound stored in the Media Library
 * if the recording was successful.
 * May also contain the extra EXTRA_MAX_BYTES.
 * @see #EXTRA_MAX_BYTES
 */

public static final java.lang.String RECORD_SOUND_ACTION = "android.provider.MediaStore.RECORD_SOUND";
}

/**
 * Contains playlists for audio files
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Playlists implements android.provider.BaseColumns, android.provider.MediaStore.Audio.PlaylistsColumns {

public Playlists() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the audio playlists table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the audio playlists table on the given volume
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/playlist";

/**
 * The default sort order for this table
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "name";

/**
 * The MIME type for entries in this table.
 */

public static final java.lang.String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/playlist";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
/**
 * Sub-directory of each playlist containing all members.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Members implements android.provider.MediaStore.Audio.AudioColumns {

public Members() { throw new RuntimeException("Stub!"); }

public static android.net.Uri getContentUri(java.lang.String volumeName, long playlistId) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to move a playlist item to a new location
 * @param res The content resolver to use
 * @param playlistId The numeric id of the playlist
 * @param from The position of the item to move
 * @param to The position to move the item to
 * @return true on success
 */

public static boolean moveItem(android.content.ContentResolver res, long playlistId, int from, int to) { throw new RuntimeException("Stub!"); }

/**
 * The ID of the audio file
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String AUDIO_ID = "audio_id";

/**
 * A subdirectory of each playlist containing all member audio
 * files.
 */

public static final java.lang.String CONTENT_DIRECTORY = "members";

/**
 * The default sort order for this table
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "play_order";

/**
 * The ID of the playlist
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String PLAYLIST_ID = "playlist_id";

/**
 * The order of the songs in the playlist
 * <P>Type: INTEGER (long)></P>
 */

public static final java.lang.String PLAY_ORDER = "play_order";

/**
 * The ID within the playlist.
 */

public static final java.lang.String _ID = "_id";
}

}

/**
 * Columns representing a playlist
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface PlaylistsColumns {

/**
 * Path to the playlist file on disk.
 * <p>
 * Note that apps may not have filesystem permissions to directly
 * access this path. Instead of trying to open this path directly,
 * apps should use
 * {@link ContentResolver#openFileDescriptor(Uri, String)} to gain
 * access.
 * <p>
 * Type: TEXT
 */

public static final java.lang.String DATA = "_data";

/**
 * The time the file was added to the media provider
 * Units are seconds since 1970.
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String DATE_ADDED = "date_added";

/**
 * The time the file was last modified
 * Units are seconds since 1970.
 * NOTE: This is for internal use by the media scanner.  Do not modify this field.
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String DATE_MODIFIED = "date_modified";

/**
 * The name of the playlist
 * <P>Type: TEXT</P>
 */

public static final java.lang.String NAME = "name";
}

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Radio {

Radio() { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for entries in this table.
 */

public static final java.lang.String ENTRY_CONTENT_TYPE = "vnd.android.cursor.item/radio";
}

}

/**
 * Media provider table containing an index of all files in the media storage,
 * including non-media files.  This should be used by applications that work with
 * non-media file types (text, HTML, PDF, etc) as well as applications that need to
 * work with multiple media file types in a single query.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Files {

public Files() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the files table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the files table on the given volume
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for a single row in the files table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @param rowId the file to get the URI for
 * @return the URI to the files table on the given volume
 */

public static android.net.Uri getContentUri(java.lang.String volumeName, long rowId) { throw new RuntimeException("Stub!"); }
/**
 * Fields for master table for all media files.
 * Table also contains MediaColumns._ID, DATA, SIZE and DATE_MODIFIED.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface FileColumns extends android.provider.MediaStore.MediaColumns {

/**
 * The media type (audio, video, image or playlist)
 * of the file, or 0 for not a media file
 * <P>Type: TEXT</P>
 */

public static final java.lang.String MEDIA_TYPE = "media_type";

/**
 * Constant for the {@link #MEDIA_TYPE} column indicating that file is an audio file.
 */

public static final int MEDIA_TYPE_AUDIO = 2; // 0x2

/**
 * Constant for the {@link #MEDIA_TYPE} column indicating that file is an image file.
 */

public static final int MEDIA_TYPE_IMAGE = 1; // 0x1

/**
 * Constant for the {@link #MEDIA_TYPE} column indicating that file
 * is not an audio, image, video or playlist file.
 */

public static final int MEDIA_TYPE_NONE = 0; // 0x0

/**
 * Constant for the {@link #MEDIA_TYPE} column indicating that file is a playlist file.
 */

public static final int MEDIA_TYPE_PLAYLIST = 4; // 0x4

/**
 * Constant for the {@link #MEDIA_TYPE} column indicating that file is a video file.
 */

public static final int MEDIA_TYPE_VIDEO = 3; // 0x3

/**
 * The MIME type of the file
 * <P>Type: TEXT</P>
 */

public static final java.lang.String MIME_TYPE = "mime_type";

/**
 * The index of the parent directory of the file
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String PARENT = "parent";

/**
 * The title of the content
 * <P>Type: TEXT</P>
 */

public static final java.lang.String TITLE = "title";
}

}

/**
 * Contains meta data for all available images.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Images {

public Images() { throw new RuntimeException("Stub!"); }
@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface ImageColumns extends android.provider.MediaStore.MediaColumns {

/**
 * The bucket display name of the image. This is a read-only property that
 * is automatically computed from the DATA column.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String BUCKET_DISPLAY_NAME = "bucket_display_name";

/**
 * The bucket id of the image. This is a read-only property that
 * is automatically computed from the DATA column.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String BUCKET_ID = "bucket_id";

/**
 * The date & time that the image was taken in units
 * of milliseconds since jan 1, 1970.
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String DATE_TAKEN = "datetaken";

/**
 * The description of the image
 * <P>Type: TEXT</P>
 */

public static final java.lang.String DESCRIPTION = "description";

/**
 * Whether the video should be published as public or private
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String IS_PRIVATE = "isprivate";

/**
 * The latitude where the image was captured.
 * <P>Type: DOUBLE</P>
 */

public static final java.lang.String LATITUDE = "latitude";

/**
 * The longitude where the image was captured.
 * <P>Type: DOUBLE</P>
 */

public static final java.lang.String LONGITUDE = "longitude";

/**
 * The mini thumb id.
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String MINI_THUMB_MAGIC = "mini_thumb_magic";

/**
 * The orientation for the image expressed as degrees.
 * Only degrees 0, 90, 180, 270 will work.
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String ORIENTATION = "orientation";

/**
 * The picasa id of the image
 * <P>Type: TEXT</P>
 */

public static final java.lang.String PICASA_ID = "picasa_id";
}

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Media implements android.provider.MediaStore.Images.ImageColumns {

public Media() { throw new RuntimeException("Stub!"); }

public static android.database.Cursor query(android.content.ContentResolver cr, android.net.Uri uri, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

public static android.database.Cursor query(android.content.ContentResolver cr, android.net.Uri uri, java.lang.String[] projection, java.lang.String where, java.lang.String orderBy) { throw new RuntimeException("Stub!"); }

public static android.database.Cursor query(android.content.ContentResolver cr, android.net.Uri uri, java.lang.String[] projection, java.lang.String selection, java.lang.String[] selectionArgs, java.lang.String orderBy) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves an image for the given url as a {@link Bitmap}.
 *
 * @param cr The content resolver to use
 * @param url The url of the image
 * @throws FileNotFoundException
 * @throws IOException
 */

public static android.graphics.Bitmap getBitmap(android.content.ContentResolver cr, android.net.Uri url) throws java.io.FileNotFoundException, java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Insert an image and create a thumbnail for it.
 *
 * @param cr The content resolver to use
 * @param imagePath The path to the image to insert
 * @param name The name of the image
 * @param description The description of the image
 * @return The URL to the newly created image
 * @throws FileNotFoundException
 */

public static java.lang.String insertImage(android.content.ContentResolver cr, java.lang.String imagePath, java.lang.String name, java.lang.String description) throws java.io.FileNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Insert an image and create a thumbnail for it.
 *
 * @param cr The content resolver to use
 * @param source The stream to use for the image
 * @param title The name of the image
 * @param description The description of the image
 * @return The URL to the newly created image, or <code>null</code> if the image failed to be stored
 *              for any reason.
 */

public static java.lang.String insertImage(android.content.ContentResolver cr, android.graphics.Bitmap source, java.lang.String title, java.lang.String description) { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the image media table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the image media table on the given volume
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type of of this directory of
 * images.  Note that each entry in this directory will have a standard
 * image MIME type as appropriate -- for example, image/jpeg.
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/image";

/**
 * The default sort order for this table
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "bucket_display_name";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
}

/**
 * This class allows developers to query and get two kinds of thumbnails:
 * MINI_KIND: 512 x 384 thumbnail
 * MICRO_KIND: 96 x 96 thumbnail
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Thumbnails implements android.provider.BaseColumns {

public Thumbnails() { throw new RuntimeException("Stub!"); }

public static final android.database.Cursor query(android.content.ContentResolver cr, android.net.Uri uri, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

public static final android.database.Cursor queryMiniThumbnails(android.content.ContentResolver cr, android.net.Uri uri, int kind, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

public static final android.database.Cursor queryMiniThumbnail(android.content.ContentResolver cr, long origId, int kind, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

/**
 * This method cancels the thumbnail request so clients waiting for getThumbnail will be
 * interrupted and return immediately. Only the original process which made the getThumbnail
 * requests can cancel their own requests.
 *
 * @param cr ContentResolver
 * @param origId original image id
 */

public static void cancelThumbnailRequest(android.content.ContentResolver cr, long origId) { throw new RuntimeException("Stub!"); }

/**
 * This method checks if the thumbnails of the specified image (origId) has been created.
 * It will be blocked until the thumbnails are generated.
 *
 * @param cr ContentResolver used to dispatch queries to MediaProvider.
 * @param origId Original image id associated with thumbnail of interest.
 * @param kind The type of thumbnail to fetch. Should be either MINI_KIND or MICRO_KIND.
 * @param options this is only used for MINI_KIND when decoding the Bitmap
 * @return A Bitmap instance. It could be null if the original image
 *         associated with origId doesn't exist or memory is not enough.
 */

public static android.graphics.Bitmap getThumbnail(android.content.ContentResolver cr, long origId, int kind, android.graphics.BitmapFactory.Options options) { throw new RuntimeException("Stub!"); }

/**
 * This method cancels the thumbnail request so clients waiting for getThumbnail will be
 * interrupted and return immediately. Only the original process which made the getThumbnail
 * requests can cancel their own requests.
 *
 * @param cr ContentResolver
 * @param origId original image id
 * @param groupId the same groupId used in getThumbnail.
 */

public static void cancelThumbnailRequest(android.content.ContentResolver cr, long origId, long groupId) { throw new RuntimeException("Stub!"); }

/**
 * This method checks if the thumbnails of the specified image (origId) has been created.
 * It will be blocked until the thumbnails are generated.
 *
 * @param cr ContentResolver used to dispatch queries to MediaProvider.
 * @param origId Original image id associated with thumbnail of interest.
 * @param groupId the id of group to which this request belongs
 * @param kind The type of thumbnail to fetch. Should be either MINI_KIND or MICRO_KIND.
 * @param options this is only used for MINI_KIND when decoding the Bitmap
 * @return A Bitmap instance. It could be null if the original image
 *         associated with origId doesn't exist or memory is not enough.
 */

public static android.graphics.Bitmap getThumbnail(android.content.ContentResolver cr, long origId, long groupId, int kind, android.graphics.BitmapFactory.Options options) { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the image media table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the image media table on the given volume
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * Path to the thumbnail file on disk.
 * <p>
 * Note that apps may not have filesystem permissions to directly
 * access this path. Instead of trying to open this path directly,
 * apps should use
 * {@link ContentResolver#openFileDescriptor(Uri, String)} to gain
 * access.
 * <p>
 * Type: TEXT
 */

public static final java.lang.String DATA = "_data";

/**
 * The default sort order for this table
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "image_id ASC";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

public static final int FULL_SCREEN_KIND = 2; // 0x2

/**
 * The height of the thumbnail
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String HEIGHT = "height";

/**
 * The original image for the thumbnal
 * <P>Type: INTEGER (ID from Images table)</P>
 */

public static final java.lang.String IMAGE_ID = "image_id";

/**
 * The content:// style URI for the internal storage.
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }

/**
 * The kind of the thumbnail
 * <P>Type: INTEGER (One of the values below)</P>
 */

public static final java.lang.String KIND = "kind";

public static final int MICRO_KIND = 3; // 0x3

public static final int MINI_KIND = 1; // 0x1

/**
 * The blob raw data of thumbnail
 * <P>Type: DATA STREAM</P>
 */

public static final java.lang.String THUMB_DATA = "thumb_data";

/**
 * The width of the thumbnal
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String WIDTH = "width";
}

}

/**
 * Common fields for most MediaProvider tables
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface MediaColumns extends android.provider.BaseColumns {

/**
 * Path to the file on disk.
 * <p>
 * Note that apps may not have filesystem permissions to directly access
 * this path. Instead of trying to open this path directly, apps should
 * use {@link ContentResolver#openFileDescriptor(Uri, String)} to gain
 * access.
 * <p>
 * Type: TEXT
 */

public static final java.lang.String DATA = "_data";

/**
 * The time the file was added to the media provider
 * Units are seconds since 1970.
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String DATE_ADDED = "date_added";

/**
 * The time the file was last modified
 * Units are seconds since 1970.
 * NOTE: This is for internal use by the media scanner.  Do not modify this field.
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String DATE_MODIFIED = "date_modified";

/**
 * The display name of the file
 * <P>Type: TEXT</P>
 */

public static final java.lang.String DISPLAY_NAME = "_display_name";

/**
 * The height of the image/video in pixels.
 */

public static final java.lang.String HEIGHT = "height";

/**
 * The MIME type of the file
 * <P>Type: TEXT</P>
 */

public static final java.lang.String MIME_TYPE = "mime_type";

/**
 * The size of the file in bytes
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String SIZE = "_size";

/**
 * The title of the content
 * <P>Type: TEXT</P>
 */

public static final java.lang.String TITLE = "title";

/**
 * The width of the image/video in pixels.
 */

public static final java.lang.String WIDTH = "width";
}

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Video {

public Video() { throw new RuntimeException("Stub!"); }

public static android.database.Cursor query(android.content.ContentResolver cr, android.net.Uri uri, java.lang.String[] projection) { throw new RuntimeException("Stub!"); }

/**
 * The default sort order for this table.
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "_display_name";
@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Media implements android.provider.MediaStore.Video.VideoColumns {

public Media() { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the video media table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the video media table on the given volume
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * The MIME type for this table.
 */

public static final java.lang.String CONTENT_TYPE = "vnd.android.cursor.dir/video";

/**
 * The default sort order for this table
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "title";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

/**
 * The content:// style URI for the internal storage.
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }
}

/**
 * This class allows developers to query and get two kinds of thumbnails:
 * MINI_KIND: 512 x 384 thumbnail
 * MICRO_KIND: 96 x 96 thumbnail
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Thumbnails implements android.provider.BaseColumns {

public Thumbnails() { throw new RuntimeException("Stub!"); }

/**
 * This method cancels the thumbnail request so clients waiting for getThumbnail will be
 * interrupted and return immediately. Only the original process which made the getThumbnail
 * requests can cancel their own requests.
 *
 * @param cr ContentResolver
 * @param origId original video id
 */

public static void cancelThumbnailRequest(android.content.ContentResolver cr, long origId) { throw new RuntimeException("Stub!"); }

/**
 * This method checks if the thumbnails of the specified image (origId) has been created.
 * It will be blocked until the thumbnails are generated.
 *
 * @param cr ContentResolver used to dispatch queries to MediaProvider.
 * @param origId Original image id associated with thumbnail of interest.
 * @param kind The type of thumbnail to fetch. Should be either MINI_KIND or MICRO_KIND.
 * @param options this is only used for MINI_KIND when decoding the Bitmap
 * @return A Bitmap instance. It could be null if the original image
 *         associated with origId doesn't exist or memory is not enough.
 */

public static android.graphics.Bitmap getThumbnail(android.content.ContentResolver cr, long origId, int kind, android.graphics.BitmapFactory.Options options) { throw new RuntimeException("Stub!"); }

/**
 * This method checks if the thumbnails of the specified image (origId) has been created.
 * It will be blocked until the thumbnails are generated.
 *
 * @param cr ContentResolver used to dispatch queries to MediaProvider.
 * @param origId Original image id associated with thumbnail of interest.
 * @param groupId the id of group to which this request belongs
 * @param kind The type of thumbnail to fetch. Should be either MINI_KIND or MICRO_KIND
 * @param options this is only used for MINI_KIND when decoding the Bitmap
 * @return A Bitmap instance. It could be null if the original image associated with
 *         origId doesn't exist or memory is not enough.
 */

public static android.graphics.Bitmap getThumbnail(android.content.ContentResolver cr, long origId, long groupId, int kind, android.graphics.BitmapFactory.Options options) { throw new RuntimeException("Stub!"); }

/**
 * This method cancels the thumbnail request so clients waiting for getThumbnail will be
 * interrupted and return immediately. Only the original process which made the getThumbnail
 * requests can cancel their own requests.
 *
 * @param cr ContentResolver
 * @param origId original video id
 * @param groupId the same groupId used in getThumbnail.
 */

public static void cancelThumbnailRequest(android.content.ContentResolver cr, long origId, long groupId) { throw new RuntimeException("Stub!"); }

/**
 * Get the content:// style URI for the image media table on the
 * given volume.
 *
 * @param volumeName the name of the volume to get the URI for
 * @return the URI to the image media table on the given volume
 */

public static android.net.Uri getContentUri(java.lang.String volumeName) { throw new RuntimeException("Stub!"); }

/**
 * Path to the thumbnail file on disk.
 * <p>
 * Note that apps may not have filesystem permissions to directly
 * access this path. Instead of trying to open this path directly,
 * apps should use
 * {@link ContentResolver#openFileDescriptor(Uri, String)} to gain
 * access.
 * <p>
 * Type: TEXT
 */

public static final java.lang.String DATA = "_data";

/**
 * The default sort order for this table
 */

public static final java.lang.String DEFAULT_SORT_ORDER = "video_id ASC";

/**
 * The content:// style URI for the "primary" external storage
 * volume.
 */

public static final android.net.Uri EXTERNAL_CONTENT_URI;
static { EXTERNAL_CONTENT_URI = null; }

public static final int FULL_SCREEN_KIND = 2; // 0x2

/**
 * The height of the thumbnail
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String HEIGHT = "height";

/**
 * The content:// style URI for the internal storage.
 */

public static final android.net.Uri INTERNAL_CONTENT_URI;
static { INTERNAL_CONTENT_URI = null; }

/**
 * The kind of the thumbnail
 * <P>Type: INTEGER (One of the values below)</P>
 */

public static final java.lang.String KIND = "kind";

public static final int MICRO_KIND = 3; // 0x3

public static final int MINI_KIND = 1; // 0x1

/**
 * The original image for the thumbnal
 * <P>Type: INTEGER (ID from Video table)</P>
 */

public static final java.lang.String VIDEO_ID = "video_id";

/**
 * The width of the thumbnal
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String WIDTH = "width";
}

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface VideoColumns extends android.provider.MediaStore.MediaColumns {

/**
 * The album the video file is from, if any
 * <P>Type: TEXT</P>
 */

public static final java.lang.String ALBUM = "album";

/**
 * The artist who created the video file, if any
 * <P>Type: TEXT</P>
 */

public static final java.lang.String ARTIST = "artist";

/**
 * The bookmark for the video. Time in ms. Represents the location in the video that the
 * video should start playing at the next time it is opened. If the value is null or
 * out of the range 0..DURATION-1 then the video should start playing from the
 * beginning.
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String BOOKMARK = "bookmark";

/**
 * The bucket display name of the video. This is a read-only property that
 * is automatically computed from the DATA column.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String BUCKET_DISPLAY_NAME = "bucket_display_name";

/**
 * The bucket id of the video. This is a read-only property that
 * is automatically computed from the DATA column.
 * <P>Type: TEXT</P>
 */

public static final java.lang.String BUCKET_ID = "bucket_id";

/**
 * The YouTube category of the video
 * <P>Type: TEXT</P>
 */

public static final java.lang.String CATEGORY = "category";

/**
 * The date & time that the video was taken in units
 * of milliseconds since jan 1, 1970.
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String DATE_TAKEN = "datetaken";

/**
 * The description of the video recording
 * <P>Type: TEXT</P>
 */

public static final java.lang.String DESCRIPTION = "description";

/**
 * The duration of the video file, in ms
 * <P>Type: INTEGER (long)</P>
 */

public static final java.lang.String DURATION = "duration";

/**
 * Whether the video should be published as public or private
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String IS_PRIVATE = "isprivate";

/**
 * The language of the video
 * <P>Type: TEXT</P>
 */

public static final java.lang.String LANGUAGE = "language";

/**
 * The latitude where the video was captured.
 * <P>Type: DOUBLE</P>
 */

public static final java.lang.String LATITUDE = "latitude";

/**
 * The longitude where the video was captured.
 * <P>Type: DOUBLE</P>
 */

public static final java.lang.String LONGITUDE = "longitude";

/**
 * The mini thumb id.
 * <P>Type: INTEGER</P>
 */

public static final java.lang.String MINI_THUMB_MAGIC = "mini_thumb_magic";

/**
 * The resolution of the video file, formatted as "XxY"
 * <P>Type: TEXT</P>
 */

public static final java.lang.String RESOLUTION = "resolution";

/**
 * The user-added tags associated with a video
 * <P>Type: TEXT</P>
 */

public static final java.lang.String TAGS = "tags";
}

}

}

