/*
 * Copyright (C) 2013 The Android Open Source Project
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

import android.media.session.MediaSession;
import android.graphics.Bitmap;

/**
 * An abstract class for editing and storing metadata that can be published by
 * {@link RemoteControlClient}. See the {@link RemoteControlClient#editMetadata(boolean)}
 * method to instantiate a {@link RemoteControlClient.MetadataEditor} object.
 *
 * @deprecated Use {@link MediaMetadata} instead together with {@link MediaSession}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
@Deprecated public abstract class MediaMetadataEditor {

/**
 * @hide
 */

MediaMetadataEditor() { throw new RuntimeException("Stub!"); }

/**
 * Applies all of the metadata changes that have been set since the MediaMetadataEditor instance
 * was created or since {@link #clear()} was called. Subclasses should synchronize on
 * {@code this} for thread safety.
 */

public abstract void apply();

/**
 * Clears all the pending metadata changes set since the MediaMetadataEditor instance was
 * created or since this method was last called.
 * Note that clearing the metadata doesn't reset the editable keys
 * (use {@link #removeEditableKeys()} instead).
 */

public synchronized void clear() { throw new RuntimeException("Stub!"); }

/**
 * Flags the given key as being editable.
 * This should only be used by metadata publishers, such as {@link RemoteControlClient},
 * which will declare the metadata field as eligible to be updated, with new values
 * received through the {@link RemoteControlClient.OnMetadataUpdateListener} interface.
 * @param key the type of metadata that can be edited. The supported key is
 *     {@link #RATING_KEY_BY_USER}.
 */

public synchronized void addEditableKey(int key) { throw new RuntimeException("Stub!"); }

/**
 * Causes all metadata fields to be read-only.
 */

public synchronized void removeEditableKeys() { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the keys flagged as editable.
 * @return null if there are no editable keys, or an array containing the keys.
 */

public synchronized int[] getEditableKeys() { throw new RuntimeException("Stub!"); }

/**
 * Adds textual information.
 * Note that none of the information added after {@link #apply()} has been called,
 * will be available to consumers of metadata stored by the MediaMetadataEditor.
 * @param key The identifier of a the metadata field to set. Valid values are
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_ALBUM},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_ALBUMARTIST},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_TITLE},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_ARTIST},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_AUTHOR},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_COMPILATION},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_COMPOSER},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DATE},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_GENRE},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_WRITER}.
 * @param value The text for the given key, or {@code null} to signify there is no valid
 *      information for the field.
 * @return Returns a reference to the same MediaMetadataEditor object, so you can chain put
 *      calls together.
 */

public synchronized android.media.MediaMetadataEditor putString(int key, java.lang.String value) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Adds numerical information.
 * Note that none of the information added after {@link #apply()} has been called
 * will be available to consumers of metadata stored by the MediaMetadataEditor.
 * @param key the identifier of a the metadata field to set. Valid values are
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_CD_TRACK_NUMBER},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DISC_NUMBER},
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DURATION} (with a value
 *      expressed in milliseconds),
 *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_YEAR}.
 * @param value The long value for the given key
 * @return Returns a reference to the same MediaMetadataEditor object, so you can chain put
 *      calls together.
 * @throws IllegalArgumentException
 */

public synchronized android.media.MediaMetadataEditor putLong(int key, long value) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Adds image.
 * @param key the identifier of the bitmap to set. The only valid value is
 *      {@link #BITMAP_KEY_ARTWORK}
 * @param bitmap The bitmap for the artwork, or null if there isn't any.
 * @return Returns a reference to the same MediaMetadataEditor object, so you can chain put
 *      calls together.
 * @throws IllegalArgumentException
 * @see android.graphics.Bitmap
 */

public synchronized android.media.MediaMetadataEditor putBitmap(int key, android.graphics.Bitmap bitmap) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Adds information stored as an instance.
 * Note that none of the information added after {@link #apply()} has been called
 * will be available to consumers of metadata stored by the MediaMetadataEditor.
 * @param key the identifier of a the metadata field to set. Valid keys for a:
 *     <ul>
 *     <li>{@link Bitmap} object are {@link #BITMAP_KEY_ARTWORK},</li>
 *     <li>{@link String} object are the same as for {@link #putString(int, String)}</li>
 *     <li>{@link Long} object are the same as for {@link #putLong(int, long)}</li>
 *     <li>{@link Rating} object are {@link #RATING_KEY_BY_OTHERS}
 *         and {@link #RATING_KEY_BY_USER}.</li>
 *     </ul>
 * @param value the metadata to add.
 * @return Returns a reference to the same MediaMetadataEditor object, so you can chain put
 *      calls together.
 * @throws IllegalArgumentException
 */

public synchronized android.media.MediaMetadataEditor putObject(int key, java.lang.Object value) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the long value for the key.
 * @param key one of the keys supported in {@link #putLong(int, long)}
 * @param defaultValue the value returned if the key is not present
 * @return the long value for the key, or the supplied default value if the key is not present
 * @throws IllegalArgumentException
 */

public synchronized long getLong(int key, long defaultValue) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link String} value for the key.
 * @param key one of the keys supported in {@link #putString(int, String)}
 * @param defaultValue the value returned if the key is not present
 * @return the {@link String} value for the key, or the supplied default value if the key is
 *     not present
 * @throws IllegalArgumentException
 */

public synchronized java.lang.String getString(int key, java.lang.String defaultValue) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link Bitmap} value for the key.
 * @param key the {@link #BITMAP_KEY_ARTWORK} key
 * @param defaultValue the value returned if the key is not present
 * @return the {@link Bitmap} value for the key, or the supplied default value if the key is
 *     not present
 * @throws IllegalArgumentException
 */

public synchronized android.graphics.Bitmap getBitmap(int key, android.graphics.Bitmap defaultValue) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns an object representation of the value for the key
 * @param key one of the keys supported in {@link #putObject(int, Object)}
 * @param defaultValue the value returned if the key is not present
 * @return the object for the key, as a {@link Long}, {@link Bitmap}, {@link String}, or
 *     {@link Rating} depending on the key value, or the supplied default value if the key is
 *     not present
 * @throws IllegalArgumentException
 */

public synchronized java.lang.Object getObject(int key, java.lang.Object defaultValue) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * The metadata key for the content artwork / album art.
 */

public static final int BITMAP_KEY_ARTWORK = 100; // 0x64

/**
 * The metadata key for the content's average rating, not the user's rating.
 * The value associated with this key is a {@link Rating} instance.
 * @see #RATING_KEY_BY_USER
 */

public static final int RATING_KEY_BY_OTHERS = 101; // 0x65

/**
 * The metadata key for the content's user rating.
 * The value associated with this key is a {@link Rating} instance.
 * This key can be flagged as "editable" (with {@link #addEditableKey(int)}) to enable
 * receiving user rating values through the
 * {@link android.media.RemoteControlClient.OnMetadataUpdateListener} interface.
 */

public static final int RATING_KEY_BY_USER = 268435457; // 0x10000001
}

