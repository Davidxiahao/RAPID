
package android.media;

import android.net.Uri;
import android.media.browse.MediaBrowser;
import android.graphics.Bitmap;

/**
 * A simple set of metadata for a media item suitable for display. This can be
 * created using the Builder or retrieved from existing metadata using
 * {@link MediaMetadata#getDescription()}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class MediaDescription implements android.os.Parcelable {

MediaDescription(android.os.Parcel in) { throw new RuntimeException("Stub!"); }

/**
 * Returns the media id or null. See
 * {@link MediaMetadata#METADATA_KEY_MEDIA_ID}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getMediaId() { throw new RuntimeException("Stub!"); }

/**
 * Returns a title suitable for display or null.
 *
 * @return A title or null.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getTitle() { throw new RuntimeException("Stub!"); }

/**
 * Returns a subtitle suitable for display or null.
 *
 * @return A subtitle or null.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getSubtitle() { throw new RuntimeException("Stub!"); }

/**
 * Returns a description suitable for display or null.
 *
 * @return A description or null.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence getDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns a bitmap icon suitable for display or null.
 *
 * @return An icon or null.
 */

@androidx.annotation.RecentlyNullable public android.graphics.Bitmap getIconBitmap() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Uri for an icon suitable for display or null.
 *
 * @return An icon uri or null.
 */

@androidx.annotation.RecentlyNullable public android.net.Uri getIconUri() { throw new RuntimeException("Stub!"); }

/**
 * Returns any extras that were added to the description.
 *
 * @return A bundle of extras or null.
 */

@androidx.annotation.RecentlyNullable public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Returns a Uri representing this content or null.
 *
 * @return A media Uri or null.
 */

@androidx.annotation.RecentlyNullable public android.net.Uri getMediaUri() { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel dest, int flags) { throw new RuntimeException("Stub!"); }

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The type of folder that contains folders categorized by album as specified in the section
 * 6.10.2.2 of the Bluetooth AVRCP 1.5.
 */

public static final long BT_FOLDER_TYPE_ALBUMS = 2L; // 0x2L

/**
 * The type of folder that contains folders categorized by artist as specified in the section
 * 6.10.2.2 of the Bluetooth AVRCP 1.5.
 */

public static final long BT_FOLDER_TYPE_ARTISTS = 3L; // 0x3L

/**
 * The type of folder that contains folders categorized by genre as specified in the section
 * 6.10.2.2 of the Bluetooth AVRCP 1.5.
 */

public static final long BT_FOLDER_TYPE_GENRES = 4L; // 0x4L

/**
 * The type of folder that is unknown or contains media elements of mixed types as specified in
 * the section 6.10.2.2 of the Bluetooth AVRCP 1.5.
 */

public static final long BT_FOLDER_TYPE_MIXED = 0L; // 0x0L

/**
 * The type of folder that contains folders categorized by playlist as specified in the section
 * 6.10.2.2 of the Bluetooth AVRCP 1.5.
 */

public static final long BT_FOLDER_TYPE_PLAYLISTS = 5L; // 0x5L

/**
 * The type of folder that contains media elements only as specified in the section 6.10.2.2 of
 * the Bluetooth AVRCP 1.5.
 */

public static final long BT_FOLDER_TYPE_TITLES = 1L; // 0x1L

/**
 * The type of folder that contains folders categorized by year as specified in the section
 * 6.10.2.2 of the Bluetooth AVRCP 1.5.
 */

public static final long BT_FOLDER_TYPE_YEARS = 6L; // 0x6L

public static final android.os.Parcelable.Creator<android.media.MediaDescription> CREATOR;
static { CREATOR = null; }

/**
 * Used as a long extra field to indicate the bluetooth folder type of the media item as
 * specified in the section 6.10.2.2 of the Bluetooth AVRCP 1.5. This is valid only for
 * {@link MediaBrowser.MediaItem} with {@link MediaBrowser.MediaItem#FLAG_BROWSABLE}. The value
 * should be one of the following:
 * <ul>
 * <li>{@link #BT_FOLDER_TYPE_MIXED}</li>
 * <li>{@link #BT_FOLDER_TYPE_TITLES}</li>
 * <li>{@link #BT_FOLDER_TYPE_ALBUMS}</li>
 * <li>{@link #BT_FOLDER_TYPE_ARTISTS}</li>
 * <li>{@link #BT_FOLDER_TYPE_GENRES}</li>
 * <li>{@link #BT_FOLDER_TYPE_PLAYLISTS}</li>
 * <li>{@link #BT_FOLDER_TYPE_YEARS}</li>
 * </ul>
 *
 * @see #getExtras()
 */

public static final java.lang.String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
/**
 * Builder for {@link MediaDescription} objects.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Builder {

/**
 * Creates an initially empty builder.
 */

public Builder() { throw new RuntimeException("Stub!"); }

/**
 * Sets the media id.
 *
 * @param mediaId The unique id for the item or null.
 * This value may be {@code null}.
 * @return this
 */

public android.media.MediaDescription.Builder setMediaId(@androidx.annotation.RecentlyNullable java.lang.String mediaId) { throw new RuntimeException("Stub!"); }

/**
 * Sets the title.
 *
 * @param title A title suitable for display to the user or null.
 * This value may be {@code null}.
 * @return this
 */

public android.media.MediaDescription.Builder setTitle(@androidx.annotation.RecentlyNullable java.lang.CharSequence title) { throw new RuntimeException("Stub!"); }

/**
 * Sets the subtitle.
 *
 * @param subtitle A subtitle suitable for display to the user or null.
 * This value may be {@code null}.
 * @return this
 */

public android.media.MediaDescription.Builder setSubtitle(@androidx.annotation.RecentlyNullable java.lang.CharSequence subtitle) { throw new RuntimeException("Stub!"); }

/**
 * Sets the description.
 *
 * @param description A description suitable for display to the user or
 *            null.
 * This value may be {@code null}.
 * @return this
 */

public android.media.MediaDescription.Builder setDescription(@androidx.annotation.RecentlyNullable java.lang.CharSequence description) { throw new RuntimeException("Stub!"); }

/**
 * Sets the icon.
 *
 * @param icon A {@link Bitmap} icon suitable for display to the user or
 *            null.
 * This value may be {@code null}.
 * @return this
 */

public android.media.MediaDescription.Builder setIconBitmap(@androidx.annotation.RecentlyNullable android.graphics.Bitmap icon) { throw new RuntimeException("Stub!"); }

/**
 * Sets the icon uri.
 *
 * @param iconUri A {@link Uri} for an icon suitable for display to the
 *            user or null.
 * This value may be {@code null}.
 * @return this
 */

public android.media.MediaDescription.Builder setIconUri(@androidx.annotation.RecentlyNullable android.net.Uri iconUri) { throw new RuntimeException("Stub!"); }

/**
 * Sets a bundle of extras.
 *
 * @param extras The extras to include with this description or null.
 * This value may be {@code null}.
 * @return this
 */

public android.media.MediaDescription.Builder setExtras(@androidx.annotation.RecentlyNullable android.os.Bundle extras) { throw new RuntimeException("Stub!"); }

/**
 * Sets the media uri.
 *
 * @param mediaUri The content's {@link Uri} for the item or null.
 * This value may be {@code null}.
 * @return this
 */

public android.media.MediaDescription.Builder setMediaUri(@androidx.annotation.RecentlyNullable android.net.Uri mediaUri) { throw new RuntimeException("Stub!"); }

public android.media.MediaDescription build() { throw new RuntimeException("Stub!"); }
}

}

