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



package android.hardware.camera2.params;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.CameraMetadata;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;

/**
 * Describes a face detected in an image.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Face {

/**
 * Create a new face without the optional fields.
 *
 * <p>The id, leftEyePosition, rightEyePosition, and mouthPosition are considered optional.
 * If the id is {@value #ID_UNSUPPORTED} then the leftEyePosition, rightEyePosition, and
 * mouthPositions are guaranteed to be {@code null}. Otherwise, each of leftEyePosition,
 * rightEyePosition, and mouthPosition may be independently null or not-null. When devices
 * report the value of key {@link CaptureResult#STATISTICS_FACE_DETECT_MODE} as
 * {@link CameraMetadata#STATISTICS_FACE_DETECT_MODE_SIMPLE} in {@link CaptureResult},
 * the face id of each face is expected to be {@value #ID_UNSUPPORTED}, the leftEyePosition,
 * rightEyePosition, and mouthPositions are expected to be {@code null} for each face.</p>
 *
 * @param bounds Bounds of the face.
 * @param score Confidence level between {@value #SCORE_MIN}-{@value #SCORE_MAX}.
 *
 * @throws IllegalArgumentException
 *             if bounds is {@code null},
 *             or if the confidence is not in the range of
 *             {@value #SCORE_MIN}-{@value #SCORE_MAX}.
 *
 * @hide
 */

Face(android.graphics.Rect bounds, int score) { throw new RuntimeException("Stub!"); }

/**
 * Bounds of the face.
 *
 * <p>A rectangle relative to the sensor's
 * {@link CameraCharacteristics#SENSOR_INFO_ACTIVE_ARRAY_SIZE}, with (0,0)
 * representing the top-left corner of the active array rectangle.</p>
 *
 * <p>There is no constraints on the the Rectangle value other than it
 * is not-{@code null}.</p>
 */

public android.graphics.Rect getBounds() { throw new RuntimeException("Stub!"); }

/**
 * The confidence level for the detection of the face.
 *
 * <p>The range is {@value #SCORE_MIN} to {@value #SCORE_MAX}.
 * {@value #SCORE_MAX} is the highest confidence.</p>
 *
 * <p>Depending on the device, even very low-confidence faces may be
 * listed, so applications should filter out faces with low confidence,
 * depending on the use case. For a typical point-and-shoot camera
 * application that wishes to display rectangles around detected faces,
 * filtering out faces with confidence less than half of {@value #SCORE_MAX}
 * is recommended.</p>
 *
 * @see #SCORE_MAX
 * @see #SCORE_MIN
 */

public int getScore() { throw new RuntimeException("Stub!"); }

/**
 * An unique id per face while the face is visible to the tracker.
 *
 * <p>
 * If the face leaves the field-of-view and comes back, it will get a new
 * id.</p>
 *
 * <p>This is an optional field, may not be supported on all devices.
 * If the id is {@value #ID_UNSUPPORTED} then the leftEyePosition, rightEyePosition, and
 * mouthPositions are guaranteed to be {@code null}. Otherwise, each of leftEyePosition,
 * rightEyePosition, and mouthPosition may be independently null or not-null. When devices
 * report the value of key {@link CaptureResult#STATISTICS_FACE_DETECT_MODE} as
 * {@link CameraMetadata#STATISTICS_FACE_DETECT_MODE_SIMPLE} in {@link CaptureResult},
 * the face id of each face is expected to be {@value #ID_UNSUPPORTED}.</p>
 *
 * <p>This value will either be {@value #ID_UNSUPPORTED} or
 * otherwise greater than {@code 0}.</p>
 *
 * @see #ID_UNSUPPORTED
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * The coordinates of the center of the left eye.
 *
 * <p>The coordinates are in
 * the same space as the ones for {@link #getBounds}. This is an
 * optional field, may not be supported on all devices. If not
 * supported, the value will always be set to null.
 * This value will  always be null only if {@link #getId()} returns
 * {@value #ID_UNSUPPORTED}.</p>
 *
 * @return The left eye position, or {@code null} if unknown.
 */

public android.graphics.Point getLeftEyePosition() { throw new RuntimeException("Stub!"); }

/**
 * The coordinates of the center of the right eye.
 *
 * <p>The coordinates are
 * in the same space as the ones for {@link #getBounds}.This is an
 * optional field, may not be supported on all devices. If not
 * supported, the value will always be set to null.
 * This value will  always be null only if {@link #getId()} returns
 * {@value #ID_UNSUPPORTED}.</p>
 *
 * @return The right eye position, or {@code null} if unknown.
 */

public android.graphics.Point getRightEyePosition() { throw new RuntimeException("Stub!"); }

/**
 * The coordinates of the center of the mouth.
 *
 * <p>The coordinates are in
 * the same space as the ones for {@link #getBounds}. This is an optional
 * field, may not be supported on all devices. If not
 * supported, the value will always be set to null.
 * This value will  always be null only if {@link #getId()} returns
 * {@value #ID_UNSUPPORTED}.</p>
 * </p>
 *
 * @return The mouth position, or {@code null} if unknown.
 */

public android.graphics.Point getMouthPosition() { throw new RuntimeException("Stub!"); }

/**
 * Represent the Face as a string for debugging purposes.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * The ID is {@code -1} when the optional set of fields is unsupported.
 *
 * @see Face#Face(Rect, int)
 * @see #getId()
 */

public static final int ID_UNSUPPORTED = -1; // 0xffffffff

/**
 * The maximum possible value for the confidence level.
 *
 * @see #getScore()
 */

public static final int SCORE_MAX = 100; // 0x64

/**
 * The minimum possible value for the confidence level.
 *
 * @see #getScore()
 */

public static final int SCORE_MIN = 1; // 0x1
}

