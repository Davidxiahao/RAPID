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


package android.graphics;


@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RegionIterator {

/**
 * Construct an iterator for all of the rectangles in a region. This
 * effectively makes a private copy of the region, so any subsequent edits
 * to region will not affect the iterator.
 *
 * @param region the region that will be iterated
 */

public RegionIterator(android.graphics.Region region) { throw new RuntimeException("Stub!"); }

/**
 * Return the next rectangle in the region. If there are no more rectangles
 * this returns false and r is unchanged. If there is at least one more,
 * this returns true and r is set to that rectangle.
 */

public final boolean next(android.graphics.Rect r) { throw new RuntimeException("Stub!"); }

protected void finalize() throws java.lang.Throwable { throw new RuntimeException("Stub!"); }
}

