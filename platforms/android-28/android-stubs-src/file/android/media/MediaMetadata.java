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

package android.media;

import android.graphics.Bitmap;
import java.util.Set;
import android.os.Bundle;
import android.net.Uri;
import android.content.ContentResolver;
import android.graphics.BitmapFactory;
import android.media.session.MediaController;
import android.media.browse.MediaBrowser;

/**
 * Contains metadata about an item, such as the title, artist, etc.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class MediaMetadata implements android.os.Parcelable {

MediaMetadata(android.os.Bundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the given key is contained in the metadata
 *
 * @param key a String key
 * @return true if the key exists in this metadata, false otherwise
 */

public boolean containsKey(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or null if no mapping of
 * the desired type exists for the given key or a null value is explicitly
 * associated with the key.
 *
 * @param key The key the value is stored under
 * Value is {@link android.media.MediaMetadata#METADATA_KEY_TITLE}, {@link android.media.MediaMetadata#METADATA_KEY_ARTIST}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM}, {@link android.media.MediaMetadata#METADATA_KEY_AUTHOR}, {@link android.media.MediaMetadata#METADATA_KEY_WRITER}, {@link android.media.MediaMetadata#METADATA_KEY_COMPOSER}, {@link android.media.MediaMetadata#METADATA_KEY_COMPILATION}, {@link android.media.MediaMetadata#METADATA_KEY_DATE}, {@link android.media.MediaMetadata#METADATA_KEY_GENRE}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM_ARTIST}, {@link android.media.MediaMetadata#METADATA_KEY_ART_URI}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM_ART_URI}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_TITLE}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_SUBTITLE}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_DESCRIPTION}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_ICON_URI}, {@link android.media.MediaMetadata#METADATA_KEY_MEDIA_ID}, or {@link android.media.MediaMetadata#METADATA_KEY_MEDIA_URI}
 * @return a CharSequence value, or null
 */

public java.lang.CharSequence getText(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the text value associated with the given key as a String, or null
 * if no mapping of the desired type exists for the given key or a null
 * value is explicitly associated with the key. This is equivalent to
 * calling {@link #getText getText().toString()} if the value is not null.
 *
 * @param key The key the value is stored under
 * Value is {@link android.media.MediaMetadata#METADATA_KEY_TITLE}, {@link android.media.MediaMetadata#METADATA_KEY_ARTIST}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM}, {@link android.media.MediaMetadata#METADATA_KEY_AUTHOR}, {@link android.media.MediaMetadata#METADATA_KEY_WRITER}, {@link android.media.MediaMetadata#METADATA_KEY_COMPOSER}, {@link android.media.MediaMetadata#METADATA_KEY_COMPILATION}, {@link android.media.MediaMetadata#METADATA_KEY_DATE}, {@link android.media.MediaMetadata#METADATA_KEY_GENRE}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM_ARTIST}, {@link android.media.MediaMetadata#METADATA_KEY_ART_URI}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM_ART_URI}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_TITLE}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_SUBTITLE}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_DESCRIPTION}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_ICON_URI}, {@link android.media.MediaMetadata#METADATA_KEY_MEDIA_ID}, or {@link android.media.MediaMetadata#METADATA_KEY_MEDIA_URI}
 * @return a String value, or null
 */

public java.lang.String getString(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the value associated with the given key, or 0L if no long exists
 * for the given key.
 *
 * @param key The key the value is stored under
 * Value is {@link android.media.MediaMetadata#METADATA_KEY_DURATION}, {@link android.media.MediaMetadata#METADATA_KEY_YEAR}, {@link android.media.MediaMetadata#METADATA_KEY_TRACK_NUMBER}, {@link android.media.MediaMetadata#METADATA_KEY_NUM_TRACKS}, {@link android.media.MediaMetadata#METADATA_KEY_DISC_NUMBER}, or {@link android.media.MediaMetadata#METADATA_KEY_BT_FOLDER_TYPE}
 * @return a long value
 */

public long getLong(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Rating} for the given key or null if no rating exists
 * for the given key.
 *
 * @param key The key the value is stored under
 * Value is {@link android.media.MediaMetadata#METADATA_KEY_USER_RATING}, or {@link android.media.MediaMetadata#METADATA_KEY_RATING}
 * @return A {@link Rating} or null
 */

public android.media.Rating getRating(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@link Bitmap} for the given key or null if no bitmap exists
 * for the given key.
 *
 * @param key The key the value is stored under
 * Value is {@link android.media.MediaMetadata#METADATA_KEY_ART}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM_ART}, or {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_ICON}
 * @return A {@link Bitmap} or null
 */

public android.graphics.Bitmap getBitmap(java.lang.String key) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Returns the number of fields in this metadata.
 *
 * @return The number of fields in the metadata.
 */

public int size() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Set containing the Strings used as keys in this metadata.
 *
 * @return a Set of String keys
 */

public java.util.Set<java.lang.String> keySet() { throw new RuntimeException("Stub!"); }

/**
 * Returns a simple description of this metadata for display purposes.
 *
 * @return A simple description of this metadata.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public android.media.MediaDescription getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Compares the contents of this object to another MediaMetadata object. It
 * does not compare Bitmaps and Ratings as the media player can choose to
 * forgo these fields depending on how you retrieve the MediaMetadata.
 *
 * @param o The Metadata object to compare this object against
 * @return Whether or not the two objects have matching fields (excluding
 * Bitmaps and Ratings)
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public int hashCode() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.media.MediaMetadata> CREATOR;
static { CREATOR = null; }

/**
 * The album title for the media.
 */

public static final java.lang.String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";

/**
 * The artwork for the album of the media's original source as a
 * {@link Bitmap}.
 * <p>
 * The artwork should be relatively small and may be scaled down by the
 * system if it is too large. For higher resolution artwork
 * {@link #METADATA_KEY_ALBUM_ART_URI} should be used instead.
 */

public static final java.lang.String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";

/**
 * The artist for the album of the media's original source.
 */

public static final java.lang.String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";

/**
 * The artwork for the album of the media's original source as a Uri
 * formatted String. The artwork can be loaded using a combination of
 * {@link ContentResolver#openInputStream} and
 * {@link BitmapFactory#decodeStream}.
 * <p>
 * For the best results, Uris should use the content:// style and support
 * {@link ContentResolver#EXTRA_SIZE} for retrieving scaled artwork through
 * {@link ContentResolver#openTypedAssetFileDescriptor(Uri, String, Bundle)}.
 */

public static final java.lang.String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";

/**
 * The artwork for the media as a {@link Bitmap}.
 * <p>
 * The artwork should be relatively small and may be scaled down by the
 * system if it is too large. For higher resolution artwork
 * {@link #METADATA_KEY_ART_URI} should be used instead.
 */

public static final java.lang.String METADATA_KEY_ART = "android.media.metadata.ART";

/**
 * The artist of the media.
 */

public static final java.lang.String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";

/**
 * The artwork for the media as a Uri formatted String. The artwork can be
 * loaded using a combination of {@link ContentResolver#openInputStream} and
 * {@link BitmapFactory#decodeStream}.
 * <p>
 * For the best results, Uris should use the content:// style and support
 * {@link ContentResolver#EXTRA_SIZE} for retrieving scaled artwork through
 * {@link ContentResolver#openTypedAssetFileDescriptor(Uri, String, Bundle)}.
 */

public static final java.lang.String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";

/**
 * The author of the media.
 */

public static final java.lang.String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";

/**
 * The bluetooth folder type of the media specified in the section 6.10.2.2 of the Bluetooth
 * AVRCP 1.5. It should be one of the following:
 * <ul>
 * <li>{@link MediaDescription#BT_FOLDER_TYPE_MIXED}</li>
 * <li>{@link MediaDescription#BT_FOLDER_TYPE_TITLES}</li>
 * <li>{@link MediaDescription#BT_FOLDER_TYPE_ALBUMS}</li>
 * <li>{@link MediaDescription#BT_FOLDER_TYPE_ARTISTS}</li>
 * <li>{@link MediaDescription#BT_FOLDER_TYPE_GENRES}</li>
 * <li>{@link MediaDescription#BT_FOLDER_TYPE_PLAYLISTS}</li>
 * <li>{@link MediaDescription#BT_FOLDER_TYPE_YEARS}</li>
 * </ul>
 */

public static final java.lang.String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";

/**
 * The compilation status of the media.
 */

public static final java.lang.String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";

/**
 * The composer of the media.
 */

public static final java.lang.String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";

/**
 * The date the media was created or published. The format is unspecified
 * but RFC 3339 is recommended.
 */

public static final java.lang.String METADATA_KEY_DATE = "android.media.metadata.DATE";

/**
 * The disc number for the media's original source.
 */

public static final java.lang.String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";

/**
 * A description that is suitable for display to the user. When displaying
 * more information for media described by this metadata this should be
 * preferred to other fields if present.
 */

public static final java.lang.String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";

/**
 * An icon or thumbnail that is suitable for display to the user. When
 * displaying an icon for media described by this metadata this should be
 * preferred to other fields if present. This must be a {@link Bitmap}.
 * <p>
 * The icon should be relatively small and may be scaled down by the system
 * if it is too large. For higher resolution artwork
 * {@link #METADATA_KEY_DISPLAY_ICON_URI} should be used instead.
 */

public static final java.lang.String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";

/**
 * A Uri formatted String for an icon or thumbnail that is suitable for
 * display to the user. When displaying more information for media described
 * by this metadata the display description should be preferred to other
 * fields when present. The icon can be loaded using a combination of
 * {@link ContentResolver#openInputStream} and
 * {@link BitmapFactory#decodeStream}.
 * <p>
 * For the best results, Uris should use the content:// style and support
 * {@link ContentResolver#EXTRA_SIZE} for retrieving scaled artwork through
 * {@link ContentResolver#openTypedAssetFileDescriptor(Uri, String, Bundle)}.
 */

public static final java.lang.String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";

/**
 * A subtitle that is suitable for display to the user. When displaying a
 * second line for media described by this metadata this should be preferred
 * to other fields if present.
 */

public static final java.lang.String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";

/**
 * A title that is suitable for display to the user. This will generally be
 * the same as {@link #METADATA_KEY_TITLE} but may differ for some formats.
 * When displaying media described by this metadata this should be preferred
 * if present.
 */

public static final java.lang.String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";

/**
 * The duration of the media in ms. A negative duration indicates that the
 * duration is unknown (or infinite).
 */

public static final java.lang.String METADATA_KEY_DURATION = "android.media.metadata.DURATION";

/**
 * The genre of the media.
 */

public static final java.lang.String METADATA_KEY_GENRE = "android.media.metadata.GENRE";

/**
 * A String key for identifying the content. This value is specific to the
 * service providing the content. If used, this should be a persistent
 * unique key for the underlying content. It may be used with
 * {@link MediaController.TransportControls#playFromMediaId(String, Bundle)}
 * to initiate playback when provided by a {@link MediaBrowser} connected to
 * the same app.
 */

public static final java.lang.String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";

/**
 * A Uri formatted String representing the content. This value is specific to the
 * service providing the content. It may be used with
 * {@link MediaController.TransportControls#playFromUri(Uri, Bundle)}
 * to initiate playback when provided by a {@link MediaBrowser} connected to
 * the same app.
 */

public static final java.lang.String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";

/**
 * The number of tracks in the media's original source.
 */

public static final java.lang.String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";

/**
 * The overall rating for the media.
 *
 * @see Rating
 */

public static final java.lang.String METADATA_KEY_RATING = "android.media.metadata.RATING";

/**
 * The title of the media.
 */

public static final java.lang.String METADATA_KEY_TITLE = "android.media.metadata.TITLE";

/**
 * The track number for the media.
 */

public static final java.lang.String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";

/**
 * The user's rating for the media.
 *
 * @see Rating
 */

public static final java.lang.String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";

/**
 * The writer of the media.
 */

public static final java.lang.String METADATA_KEY_WRITER = "android.media.metadata.WRITER";

/**
 * The year the media was created or published as a long.
 */

public static final java.lang.String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
/**
 * Use to build MediaMetadata objects. The system defined metadata keys must
 * use the appropriate data type.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static final class Builder {

/**
 * Create an empty Builder. Any field that should be included in the
 * {@link MediaMetadata} must be added.
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Create a Builder using a {@link MediaMetadata} instance to set the
 * initial values. All fields in the source metadata will be included in
 * the new metadata. Fields can be overwritten by adding the same key.
 *
 * @param source
 */

public Builder(android.media.MediaMetadata source) { throw new RuntimeException("Stub!"); }

/**
 * Put a CharSequence value into the metadata. Custom keys may be used,
 * but if the METADATA_KEYs defined in this class are used they may only
 * be one of the following:
 * <ul>
 * <li>{@link #METADATA_KEY_TITLE}</li>
 * <li>{@link #METADATA_KEY_ARTIST}</li>
 * <li>{@link #METADATA_KEY_ALBUM}</li>
 * <li>{@link #METADATA_KEY_AUTHOR}</li>
 * <li>{@link #METADATA_KEY_WRITER}</li>
 * <li>{@link #METADATA_KEY_COMPOSER}</li>
 * <li>{@link #METADATA_KEY_DATE}</li>
 * <li>{@link #METADATA_KEY_GENRE}</li>
 * <li>{@link #METADATA_KEY_ALBUM_ARTIST}</li>
 * <li>{@link #METADATA_KEY_ART_URI}</li>
 * <li>{@link #METADATA_KEY_ALBUM_ART_URI}</li>
 * <li>{@link #METADATA_KEY_DISPLAY_TITLE}</li>
 * <li>{@link #METADATA_KEY_DISPLAY_SUBTITLE}</li>
 * <li>{@link #METADATA_KEY_DISPLAY_DESCRIPTION}</li>
 * <li>{@link #METADATA_KEY_DISPLAY_ICON_URI}</li>
 * </ul>
 *
 * @param key The key for referencing this value
 * Value is {@link android.media.MediaMetadata#METADATA_KEY_TITLE}, {@link android.media.MediaMetadata#METADATA_KEY_ARTIST}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM}, {@link android.media.MediaMetadata#METADATA_KEY_AUTHOR}, {@link android.media.MediaMetadata#METADATA_KEY_WRITER}, {@link android.media.MediaMetadata#METADATA_KEY_COMPOSER}, {@link android.media.MediaMetadata#METADATA_KEY_COMPILATION}, {@link android.media.MediaMetadata#METADATA_KEY_DATE}, {@link android.media.MediaMetadata#METADATA_KEY_GENRE}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM_ARTIST}, {@link android.media.MediaMetadata#METADATA_KEY_ART_URI}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM_ART_URI}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_TITLE}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_SUBTITLE}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_DESCRIPTION}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_ICON_URI}, {@link android.media.MediaMetadata#METADATA_KEY_MEDIA_ID}, or {@link android.media.MediaMetadata#METADATA_KEY_MEDIA_URI}
 * @param value The CharSequence value to store
 * @return The Builder to allow chaining
 */

public android.media.MediaMetadata.Builder putText(java.lang.String key, java.lang.CharSequence value) { throw new RuntimeException("Stub!"); }

/**
 * Put a String value into the metadata. Custom keys may be used, but if
 * the METADATA_KEYs defined in this class are used they may only be one
 * of the following:
 * <ul>
 * <li>{@link #METADATA_KEY_TITLE}</li>
 * <li>{@link #METADATA_KEY_ARTIST}</li>
 * <li>{@link #METADATA_KEY_ALBUM}</li>
 * <li>{@link #METADATA_KEY_AUTHOR}</li>
 * <li>{@link #METADATA_KEY_WRITER}</li>
 * <li>{@link #METADATA_KEY_COMPOSER}</li>
 * <li>{@link #METADATA_KEY_DATE}</li>
 * <li>{@link #METADATA_KEY_GENRE}</li>
 * <li>{@link #METADATA_KEY_ALBUM_ARTIST}</li>
 * <li>{@link #METADATA_KEY_ART_URI}</li>
 * <li>{@link #METADATA_KEY_ALBUM_ART_URI}</li>
 * <li>{@link #METADATA_KEY_DISPLAY_TITLE}</li>
 * <li>{@link #METADATA_KEY_DISPLAY_SUBTITLE}</li>
 * <li>{@link #METADATA_KEY_DISPLAY_DESCRIPTION}</li>
 * <li>{@link #METADATA_KEY_DISPLAY_ICON_URI}</li>
 * </ul>
 * <p>
 * Uris for artwork should use the content:// style and support
 * {@link ContentResolver#EXTRA_SIZE} for retrieving scaled artwork
 * through {@link ContentResolver#openTypedAssetFileDescriptor(Uri,
 * String, Bundle)}.
 *
 * @param key The key for referencing this value
 * Value is {@link android.media.MediaMetadata#METADATA_KEY_TITLE}, {@link android.media.MediaMetadata#METADATA_KEY_ARTIST}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM}, {@link android.media.MediaMetadata#METADATA_KEY_AUTHOR}, {@link android.media.MediaMetadata#METADATA_KEY_WRITER}, {@link android.media.MediaMetadata#METADATA_KEY_COMPOSER}, {@link android.media.MediaMetadata#METADATA_KEY_COMPILATION}, {@link android.media.MediaMetadata#METADATA_KEY_DATE}, {@link android.media.MediaMetadata#METADATA_KEY_GENRE}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM_ARTIST}, {@link android.media.MediaMetadata#METADATA_KEY_ART_URI}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM_ART_URI}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_TITLE}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_SUBTITLE}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_DESCRIPTION}, {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_ICON_URI}, {@link android.media.MediaMetadata#METADATA_KEY_MEDIA_ID}, or {@link android.media.MediaMetadata#METADATA_KEY_MEDIA_URI}
 * @param value The String value to store
 * @return The Builder to allow chaining
 */

public android.media.MediaMetadata.Builder putString(java.lang.String key, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Put a long value into the metadata. Custom keys may be used, but if
 * the METADATA_KEYs defined in this class are used they may only be one
 * of the following:
 * <ul>
 * <li>{@link #METADATA_KEY_DURATION}</li>
 * <li>{@link #METADATA_KEY_TRACK_NUMBER}</li>
 * <li>{@link #METADATA_KEY_NUM_TRACKS}</li>
 * <li>{@link #METADATA_KEY_DISC_NUMBER}</li>
 * <li>{@link #METADATA_KEY_YEAR}</li>
 * </ul>
 *
 * @param key The key for referencing this value
 * Value is {@link android.media.MediaMetadata#METADATA_KEY_DURATION}, {@link android.media.MediaMetadata#METADATA_KEY_YEAR}, {@link android.media.MediaMetadata#METADATA_KEY_TRACK_NUMBER}, {@link android.media.MediaMetadata#METADATA_KEY_NUM_TRACKS}, {@link android.media.MediaMetadata#METADATA_KEY_DISC_NUMBER}, or {@link android.media.MediaMetadata#METADATA_KEY_BT_FOLDER_TYPE}
 * @param value The long value to store
 * @return The Builder to allow chaining
 */

public android.media.MediaMetadata.Builder putLong(java.lang.String key, long value) { throw new RuntimeException("Stub!"); }

/**
 * Put a {@link Rating} into the metadata. Custom keys may be used, but
 * if the METADATA_KEYs defined in this class are used they may only be
 * one of the following:
 * <ul>
 * <li>{@link #METADATA_KEY_RATING}</li>
 * <li>{@link #METADATA_KEY_USER_RATING}</li>
 * </ul>
 *
 * @param key The key for referencing this value
 * Value is {@link android.media.MediaMetadata#METADATA_KEY_USER_RATING}, or {@link android.media.MediaMetadata#METADATA_KEY_RATING}
 * @param value The Rating value to store
 * @return The Builder to allow chaining
 */

public android.media.MediaMetadata.Builder putRating(java.lang.String key, android.media.Rating value) { throw new RuntimeException("Stub!"); }

/**
 * Put a {@link Bitmap} into the metadata. Custom keys may be used, but
 * if the METADATA_KEYs defined in this class are used they may only be
 * one of the following:
 * <ul>
 * <li>{@link #METADATA_KEY_ART}</li>
 * <li>{@link #METADATA_KEY_ALBUM_ART}</li>
 * <li>{@link #METADATA_KEY_DISPLAY_ICON}</li>
 * </ul>
 * <p>
 * Large bitmaps may be scaled down by the system when
 * {@link android.media.session.MediaSession#setMetadata} is called.
 * To pass full resolution images {@link Uri Uris} should be used with
 * {@link #putString}.
 *
 * @param key The key for referencing this value
 * Value is {@link android.media.MediaMetadata#METADATA_KEY_ART}, {@link android.media.MediaMetadata#METADATA_KEY_ALBUM_ART}, or {@link android.media.MediaMetadata#METADATA_KEY_DISPLAY_ICON}
 * @param value The Bitmap to store
 * @return The Builder to allow chaining
 */

public android.media.MediaMetadata.Builder putBitmap(java.lang.String key, android.graphics.Bitmap value) { throw new RuntimeException("Stub!"); }

/**
 * Creates a {@link MediaMetadata} instance with the specified fields.
 *
 * @return The new MediaMetadata instance
 */

public android.media.MediaMetadata build() { throw new RuntimeException("Stub!"); }
}

}

