/*
 * Copyright (C) 2006 The Android Open Source Project
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


package android.text;

import android.graphics.Paint;

/**
 * TextPaint is an extension of Paint that leaves room for some extra
 * data used during text measuring and drawing.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TextPaint extends android.graphics.Paint {

public TextPaint() { throw new RuntimeException("Stub!"); }

public TextPaint(int flags) { throw new RuntimeException("Stub!"); }

public TextPaint(android.graphics.Paint p) { throw new RuntimeException("Stub!"); }

/**
 * Copy the fields from tp into this TextPaint, including the
 * fields inherited from Paint.
 */

public void set(android.text.TextPaint tp) { throw new RuntimeException("Stub!"); }

public int baselineShift;

public int bgColor;

public float density = 1.0f;

public int[] drawableState;

public int linkColor;
}

