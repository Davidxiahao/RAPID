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


package android.media;

import java.util.Set;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.File;

/**
 * This is a class for reading and writing Exif tags in a JPEG file or a RAW image file.
 * <p>
 * Supported formats are: JPEG, DNG, CR2, NEF, NRW, ARW, RW2, ORF, PEF, SRW, RAF and HEIF.
 * <p>
 * Attribute mutation is supported for JPEG image files.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ExifInterface {

/**
 * Reads Exif tags from the specified image file.
 */

public ExifInterface(java.lang.String filename) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads Exif tags from the specified image file descriptor. Attribute mutation is supported
 * for writable and seekable file descriptors only. This constructor will not rewind the offset
 * of the given file descriptor. Developers should close the file descriptor after use.
 */

public ExifInterface(java.io.FileDescriptor fileDescriptor) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Reads Exif tags from the specified image input stream. Attribute mutation is not supported
 * for input streams. The given input stream will proceed its current position. Developers
 * should close the input stream after use.
 */

public ExifInterface(java.io.InputStream inputStream) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the value of the specified tag or {@code null} if there
 * is no such tag in the image file.
 *
 * @param tag the name of the tag.
 */

public java.lang.String getAttribute(java.lang.String tag) { throw new RuntimeException("Stub!"); }

/**
 * Returns the integer value of the specified tag. If there is no such tag
 * in the image file or the value cannot be parsed as integer, return
 * <var>defaultValue</var>.
 *
 * @param tag the name of the tag.
 * @param defaultValue the value to return if the tag is not available.
 */

public int getAttributeInt(java.lang.String tag, int defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Returns the double value of the tag that is specified as rational or contains a
 * double-formatted value. If there is no such tag in the image file or the value cannot be
 * parsed as double, return <var>defaultValue</var>.
 *
 * @param tag the name of the tag.
 * @param defaultValue the value to return if the tag is not available.
 */

public double getAttributeDouble(java.lang.String tag, double defaultValue) { throw new RuntimeException("Stub!"); }

/**
 * Set the value of the specified tag.
 *
 * @param tag the name of the tag.
 * @param value the value of the tag.
 */

public void setAttribute(java.lang.String tag, java.lang.String value) { throw new RuntimeException("Stub!"); }

/**
 * Save the tag data into the original image file. This is expensive because it involves
 * copying all the data from one file to another and deleting the old file and renaming the
 * other. It's best to use {@link #setAttribute(String,String)} to set all attributes to write
 * and make a single call rather than multiple calls for each attribute.
 * <p>
 * This method is only supported for JPEG files.
 * </p>
 */

public void saveAttributes() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the image file has a thumbnail.
 */

public boolean hasThumbnail() { throw new RuntimeException("Stub!"); }

/**
 * Returns the JPEG compressed thumbnail inside the image file, or {@code null} if there is no
 * JPEG compressed thumbnail.
 * The returned data can be decoded using
 * {@link android.graphics.BitmapFactory#decodeByteArray(byte[],int,int)}
 */

public byte[] getThumbnail() { throw new RuntimeException("Stub!"); }

/**
 * Returns the thumbnail bytes inside the image file, regardless of the compression type of the
 * thumbnail image.
 */

public byte[] getThumbnailBytes() { throw new RuntimeException("Stub!"); }

/**
 * Creates and returns a Bitmap object of the thumbnail image based on the byte array and the
 * thumbnail compression value, or {@code null} if the compression type is unsupported.
 */

public android.graphics.Bitmap getThumbnailBitmap() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if thumbnail image is JPEG Compressed, or false if either thumbnail image does
 * not exist or thumbnail image is uncompressed.
 */

public boolean isThumbnailCompressed() { throw new RuntimeException("Stub!"); }

/**
 * Returns the offset and length of thumbnail inside the image file, or
 * {@code null} if there is no thumbnail.
 *
 * @return two-element array, the offset in the first value, and length in
 *         the second, or {@code null} if no thumbnail was found.
 */

public long[] getThumbnailRange() { throw new RuntimeException("Stub!"); }

/**
 * Stores the latitude and longitude value in a float array. The first element is
 * the latitude, and the second element is the longitude. Returns false if the
 * Exif tags are not available.
 */

public boolean getLatLong(float[] output) { throw new RuntimeException("Stub!"); }

/**
 * Return the altitude in meters. If the exif tag does not exist, return
 * <var>defaultValue</var>.
 *
 * @param defaultValue the value to return if the tag is not available.
 */

public double getAltitude(double defaultValue) { throw new RuntimeException("Stub!"); }

public static final int ORIENTATION_FLIP_HORIZONTAL = 2; // 0x2

public static final int ORIENTATION_FLIP_VERTICAL = 4; // 0x4

public static final int ORIENTATION_NORMAL = 1; // 0x1

public static final int ORIENTATION_ROTATE_180 = 3; // 0x3

public static final int ORIENTATION_ROTATE_270 = 8; // 0x8

public static final int ORIENTATION_ROTATE_90 = 6; // 0x6

public static final int ORIENTATION_TRANSPOSE = 5; // 0x5

public static final int ORIENTATION_TRANSVERSE = 7; // 0x7

public static final int ORIENTATION_UNDEFINED = 0; // 0x0

/**
 * Type is double.
 *
 * @deprecated use {@link #TAG_F_NUMBER} instead
 */

@Deprecated public static final java.lang.String TAG_APERTURE = "FNumber";

/** Type is rational. */

public static final java.lang.String TAG_APERTURE_VALUE = "ApertureValue";

/** Type is String. */

public static final java.lang.String TAG_ARTIST = "Artist";

/** Type is int. */

public static final java.lang.String TAG_BITS_PER_SAMPLE = "BitsPerSample";

/** Type is rational. */

public static final java.lang.String TAG_BRIGHTNESS_VALUE = "BrightnessValue";

/** Type is String. */

public static final java.lang.String TAG_CFA_PATTERN = "CFAPattern";

/** Type is int. */

public static final java.lang.String TAG_COLOR_SPACE = "ColorSpace";

/** Type is String. */

public static final java.lang.String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";

/** Type is rational. */

public static final java.lang.String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";

/** Type is int. */

public static final java.lang.String TAG_COMPRESSION = "Compression";

/** Type is int. */

public static final java.lang.String TAG_CONTRAST = "Contrast";

/** Type is String. */

public static final java.lang.String TAG_COPYRIGHT = "Copyright";

/** Type is int. */

public static final java.lang.String TAG_CUSTOM_RENDERED = "CustomRendered";

/** Type is String. */

public static final java.lang.String TAG_DATETIME = "DateTime";

/** Type is String. */

public static final java.lang.String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";

/** Type is String. */

public static final java.lang.String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";

/** Type is int. DNG Specification 1.4.0.0. Section 4 */

public static final java.lang.String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";

/** Type is String. */

public static final java.lang.String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";

/** Type is double. */

public static final java.lang.String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";

/** Type is int. DNG Specification 1.4.0.0. Section 4 */

public static final java.lang.String TAG_DNG_VERSION = "DNGVersion";

/** Type is String. */

public static final java.lang.String TAG_EXIF_VERSION = "ExifVersion";

/** Type is double. */

public static final java.lang.String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";

/** Type is rational. */

public static final java.lang.String TAG_EXPOSURE_INDEX = "ExposureIndex";

/** Type is int. */

public static final java.lang.String TAG_EXPOSURE_MODE = "ExposureMode";

/** Type is int. */

public static final java.lang.String TAG_EXPOSURE_PROGRAM = "ExposureProgram";

/** Type is double. */

public static final java.lang.String TAG_EXPOSURE_TIME = "ExposureTime";

/** Type is String. */

public static final java.lang.String TAG_FILE_SOURCE = "FileSource";

/** Type is int. */

public static final java.lang.String TAG_FLASH = "Flash";

/** Type is String. */

public static final java.lang.String TAG_FLASHPIX_VERSION = "FlashpixVersion";

/** Type is rational. */

public static final java.lang.String TAG_FLASH_ENERGY = "FlashEnergy";

/** Type is rational. */

public static final java.lang.String TAG_FOCAL_LENGTH = "FocalLength";

/** Type is int. */

public static final java.lang.String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";

/** Type is int. */

public static final java.lang.String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";

/** Type is rational. */

public static final java.lang.String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";

/** Type is rational. */

public static final java.lang.String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";

/** Type is double. */

public static final java.lang.String TAG_F_NUMBER = "FNumber";

/** Type is int. */

public static final java.lang.String TAG_GAIN_CONTROL = "GainControl";

/**
 * The altitude (in meters) based on the reference in TAG_GPS_ALTITUDE_REF.
 * Type is rational.
 */

public static final java.lang.String TAG_GPS_ALTITUDE = "GPSAltitude";

/**
 * 0 if the altitude is above sea level. 1 if the altitude is below sea
 * level. Type is int.
 */

public static final java.lang.String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";

/** Type is String. */

public static final java.lang.String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";

/** Type is String. */

public static final java.lang.String TAG_GPS_DATESTAMP = "GPSDateStamp";

/** Type is rational. */

public static final java.lang.String TAG_GPS_DEST_BEARING = "GPSDestBearing";

/** Type is String. */

public static final java.lang.String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";

/** Type is rational. */

public static final java.lang.String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";

/** Type is String. */

public static final java.lang.String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";

/** Type is rational. */

public static final java.lang.String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";

/** Type is String. */

public static final java.lang.String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";

/** Type is rational. */

public static final java.lang.String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";

/** Type is String. */

public static final java.lang.String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";

/** Type is int. */

public static final java.lang.String TAG_GPS_DIFFERENTIAL = "GPSDifferential";

/** Type is rational. */

public static final java.lang.String TAG_GPS_DOP = "GPSDOP";

/** Type is rational. */

public static final java.lang.String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";

/** Type is String. */

public static final java.lang.String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";

/** Type is rational. Format is "num1/denom1,num2/denom2,num3/denom3". */

public static final java.lang.String TAG_GPS_LATITUDE = "GPSLatitude";

/** Type is String. */

public static final java.lang.String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";

/** Type is rational. Format is "num1/denom1,num2/denom2,num3/denom3". */

public static final java.lang.String TAG_GPS_LONGITUDE = "GPSLongitude";

/** Type is String. */

public static final java.lang.String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";

/** Type is String. */

public static final java.lang.String TAG_GPS_MAP_DATUM = "GPSMapDatum";

/** Type is String. */

public static final java.lang.String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";

/** Type is String. Name of GPS processing method used for location finding. */

public static final java.lang.String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";

/** Type is String. */

public static final java.lang.String TAG_GPS_SATELLITES = "GPSSatellites";

/** Type is rational. */

public static final java.lang.String TAG_GPS_SPEED = "GPSSpeed";

/** Type is String. */

public static final java.lang.String TAG_GPS_SPEED_REF = "GPSSpeedRef";

/** Type is String. */

public static final java.lang.String TAG_GPS_STATUS = "GPSStatus";

/** Type is String. Format is "hh:mm:ss". */

public static final java.lang.String TAG_GPS_TIMESTAMP = "GPSTimeStamp";

/** Type is rational. */

public static final java.lang.String TAG_GPS_TRACK = "GPSTrack";

/** Type is String. */

public static final java.lang.String TAG_GPS_TRACK_REF = "GPSTrackRef";

/** Type is String. */

public static final java.lang.String TAG_GPS_VERSION_ID = "GPSVersionID";

/** Type is String. */

public static final java.lang.String TAG_IMAGE_DESCRIPTION = "ImageDescription";

/** Type is int. */

public static final java.lang.String TAG_IMAGE_LENGTH = "ImageLength";

/** Type is String. */

public static final java.lang.String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";

/** Type is int. */

public static final java.lang.String TAG_IMAGE_WIDTH = "ImageWidth";

/** Type is String. */

public static final java.lang.String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";

/**
 * Type is int.
 *
 * @deprecated use {@link #TAG_ISO_SPEED_RATINGS} instead
 */

@Deprecated public static final java.lang.String TAG_ISO = "ISOSpeedRatings";

/** Type is int. */

public static final java.lang.String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";

/** Type is int. */

public static final java.lang.String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";

/** Type is int. */

public static final java.lang.String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";

/** Type is int. */

public static final java.lang.String TAG_LIGHT_SOURCE = "LightSource";

/** Type is String. */

public static final java.lang.String TAG_MAKE = "Make";

/** Type is String. */

public static final java.lang.String TAG_MAKER_NOTE = "MakerNote";

/** Type is rational. */

public static final java.lang.String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";

/** Type is int. */

public static final java.lang.String TAG_METERING_MODE = "MeteringMode";

/** Type is String. */

public static final java.lang.String TAG_MODEL = "Model";

/** Type is int. */

public static final java.lang.String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";

/** Type is String. */

public static final java.lang.String TAG_OECF = "OECF";

/** Type is int. See Olympus Image Processing tags in http://www.exiv2.org/tags-olympus.html. */

public static final java.lang.String TAG_ORF_ASPECT_FRAME = "AspectFrame";

/** Type is int. See Olympus Camera Settings tags in http://www.exiv2.org/tags-olympus.html. */

public static final java.lang.String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";

/** Type is int. See Olympus Camera Settings tags in http://www.exiv2.org/tags-olympus.html. */

public static final java.lang.String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";

/** Type is undefined. See Olympus MakerNote tags in http://www.exiv2.org/tags-olympus.html. */

public static final java.lang.String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";

/** Type is int. */

public static final java.lang.String TAG_ORIENTATION = "Orientation";

/** Type is int. */

public static final java.lang.String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";

/** Type is int. */

public static final java.lang.String TAG_PIXEL_X_DIMENSION = "PixelXDimension";

/** Type is int. */

public static final java.lang.String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";

/** Type is int. */

public static final java.lang.String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";

/** Type is rational. */

public static final java.lang.String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";

/** Type is rational. */

public static final java.lang.String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";

/** Type is String. */

public static final java.lang.String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";

/** Type is int. */

public static final java.lang.String TAG_RESOLUTION_UNIT = "ResolutionUnit";

/** Type is int. */

public static final java.lang.String TAG_ROWS_PER_STRIP = "RowsPerStrip";

/**
 * Type is int. See PanasonicRaw tags in
 * http://www.sno.phy.queensu.ca/~phil/exiftool/TagNames/PanasonicRaw.html
 */

public static final java.lang.String TAG_RW2_ISO = "ISO";

/**
 * Type is undefined. See PanasonicRaw tags in
 * http://www.sno.phy.queensu.ca/~phil/exiftool/TagNames/PanasonicRaw.html
 */

public static final java.lang.String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";

/**
 * Type is int. See PanasonicRaw tags in
 * http://www.sno.phy.queensu.ca/~phil/exiftool/TagNames/PanasonicRaw.html
 */

public static final java.lang.String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";

/**
 * Type is int. See PanasonicRaw tags in
 * http://www.sno.phy.queensu.ca/~phil/exiftool/TagNames/PanasonicRaw.html
 */

public static final java.lang.String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";

/**
 * Type is int. See PanasonicRaw tags in
 * http://www.sno.phy.queensu.ca/~phil/exiftool/TagNames/PanasonicRaw.html
 */

public static final java.lang.String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";

/**
 * Type is int. See PanasonicRaw tags in
 * http://www.sno.phy.queensu.ca/~phil/exiftool/TagNames/PanasonicRaw.html
 */

public static final java.lang.String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";

/** Type is int. */

public static final java.lang.String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";

/** Type is int. */

public static final java.lang.String TAG_SATURATION = "Saturation";

/** Type is int. */

public static final java.lang.String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";

/** Type is String. */

public static final java.lang.String TAG_SCENE_TYPE = "SceneType";

/** Type is int. */

public static final java.lang.String TAG_SENSING_METHOD = "SensingMethod";

/** Type is int. */

public static final java.lang.String TAG_SHARPNESS = "Sharpness";

/** Type is rational. */

public static final java.lang.String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";

/** Type is String. */

public static final java.lang.String TAG_SOFTWARE = "Software";

/** Type is String. */

public static final java.lang.String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";

/** Type is String. */

public static final java.lang.String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";

/** Type is int. */

public static final java.lang.String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";

/** Type is int. */

public static final java.lang.String TAG_STRIP_OFFSETS = "StripOffsets";

/** Type is int. */

public static final java.lang.String TAG_SUBFILE_TYPE = "SubfileType";

/** Type is int. */

public static final java.lang.String TAG_SUBJECT_AREA = "SubjectArea";

/** Type is double. */

public static final java.lang.String TAG_SUBJECT_DISTANCE = "SubjectDistance";

/** Type is int. */

public static final java.lang.String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";

/** Type is int. */

public static final java.lang.String TAG_SUBJECT_LOCATION = "SubjectLocation";

/** Type is String. */

public static final java.lang.String TAG_SUBSEC_TIME = "SubSecTime";

/**
 * Type is String.
 *
 * @deprecated use {@link #TAG_SUBSEC_TIME_DIGITIZED} instead
 */

@Deprecated public static final java.lang.String TAG_SUBSEC_TIME_DIG = "SubSecTimeDigitized";

/** Type is String. */

public static final java.lang.String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";

/**
 * Type is String.
 *
 * @deprecated use {@link #TAG_SUBSEC_TIME_ORIGINAL} instead
 */

@Deprecated public static final java.lang.String TAG_SUBSEC_TIME_ORIG = "SubSecTimeOriginal";

/** Type is String. */

public static final java.lang.String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";

/** Type is int. */

public static final java.lang.String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";

/** Type is int. */

public static final java.lang.String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";

/** Type is int. */

public static final java.lang.String TAG_TRANSFER_FUNCTION = "TransferFunction";

/** Type is String. */

public static final java.lang.String TAG_USER_COMMENT = "UserComment";

/** Type is int. */

public static final java.lang.String TAG_WHITE_BALANCE = "WhiteBalance";

/** Type is rational. */

public static final java.lang.String TAG_WHITE_POINT = "WhitePoint";

/** Type is rational. */

public static final java.lang.String TAG_X_RESOLUTION = "XResolution";

/** Type is rational. */

public static final java.lang.String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";

/** Type is int. */

public static final java.lang.String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";

/** Type is int. */

public static final java.lang.String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";

/** Type is rational. */

public static final java.lang.String TAG_Y_RESOLUTION = "YResolution";

public static final int WHITEBALANCE_AUTO = 0; // 0x0

public static final int WHITEBALANCE_MANUAL = 1; // 0x1
}

