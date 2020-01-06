/*
 * Copyright (C) 2008-2009 The Android Open Source Project
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


package android.gesture;


/**
 * A gesture is a hand-drawn shape on a touch screen. It can have one or multiple strokes.
 * Each stroke is a sequence of timed points. A user-defined gesture can be recognized by
 * a GestureLibrary.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Gesture implements android.os.Parcelable {

public Gesture() { throw new RuntimeException("Stub!"); }

public java.lang.Object clone() { throw new RuntimeException("Stub!"); }

/**
 * @return all the strokes of the gesture
 */

public java.util.ArrayList<android.gesture.GestureStroke> getStrokes() { throw new RuntimeException("Stub!"); }

/**
 * @return the number of strokes included by this gesture
 */

public int getStrokesCount() { throw new RuntimeException("Stub!"); }

/**
 * Adds a stroke to the gesture.
 *
 * @param stroke
 */

public void addStroke(android.gesture.GestureStroke stroke) { throw new RuntimeException("Stub!"); }

/**
 * Calculates the total length of the gesture. When there are multiple strokes in
 * the gesture, this returns the sum of the lengths of all the strokes.
 *
 * @return the length of the gesture
 */

public float getLength() { throw new RuntimeException("Stub!"); }

/**
 * @return the bounding box of the gesture
 */

public android.graphics.RectF getBoundingBox() { throw new RuntimeException("Stub!"); }

public android.graphics.Path toPath() { throw new RuntimeException("Stub!"); }

public android.graphics.Path toPath(android.graphics.Path path) { throw new RuntimeException("Stub!"); }

public android.graphics.Path toPath(int width, int height, int edge, int numSample) { throw new RuntimeException("Stub!"); }

public android.graphics.Path toPath(android.graphics.Path path, int width, int height, int edge, int numSample) { throw new RuntimeException("Stub!"); }

/**
 * @return the id of the gesture
 */

public long getID() { throw new RuntimeException("Stub!"); }

/**
 * Creates a bitmap of the gesture with a transparent background.
 *
 * @param width width of the target bitmap
 * @param height height of the target bitmap
 * @param edge the edge
 * @param numSample
 * @param color
 * @return the bitmap
 */

public android.graphics.Bitmap toBitmap(int width, int height, int edge, int numSample, int color) { throw new RuntimeException("Stub!"); }

/**
 * Creates a bitmap of the gesture with a transparent background.
 *
 * @param width
 * @param height
 * @param inset
 * @param color
 * @return the bitmap
 */

public android.graphics.Bitmap toBitmap(int width, int height, int inset, int color) { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.gesture.Gesture> CREATOR;
static { CREATOR = null; }
}

