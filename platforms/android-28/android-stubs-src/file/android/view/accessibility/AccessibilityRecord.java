/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.view.accessibility;

import android.view.View;
import android.os.Parcelable;

/**
 * Represents a record in an {@link AccessibilityEvent} and contains information
 * about state change of its source {@link android.view.View}. When a view fires
 * an accessibility event it requests from its parent to dispatch the
 * constructed event. The parent may optionally append a record for itself
 * for providing more context to
 * {@link android.accessibilityservice.AccessibilityService}s. Hence,
 * accessibility services can facilitate additional accessibility records
 * to enhance feedback.
 * </p>
 * <p>
 * Once the accessibility event containing a record is dispatched the record is
 * made immutable and calling a state mutation method generates an error.
 * </p>
 * <p>
 * <strong>Note:</strong> Not all properties are applicable to all accessibility
 * event types. For detailed information please refer to {@link AccessibilityEvent}.
 * </p>
 *
 * <div class="special reference">
 * <h3>Developer Guides</h3>
 * <p>For more information about creating and processing AccessibilityRecords, read the
 * <a href="{@docRoot}guide/topics/ui/accessibility/index.html">Accessibility</a>
 * developer guide.</p>
 * </div>
 *
 * @see AccessibilityEvent
 * @see AccessibilityManager
 * @see android.accessibilityservice.AccessibilityService
 * @see AccessibilityNodeInfo
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AccessibilityRecord {

AccessibilityRecord() { throw new RuntimeException("Stub!"); }

/**
 * Sets the event source.
 *
 * @param source The source.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setSource(android.view.View source) { throw new RuntimeException("Stub!"); }

/**
 * Sets the source to be a virtual descendant of the given <code>root</code>.
 * If <code>virtualDescendantId</code> equals to {@link View#NO_ID} the root
 * is set as the source.
 * <p>
 * A virtual descendant is an imaginary View that is reported as a part of the view
 * hierarchy for accessibility purposes. This enables custom views that draw complex
 * content to report them selves as a tree of virtual views, thus conveying their
 * logical structure.
 * </p>
 *
 * @param root The root of the virtual subtree.
 * This value may be {@code null}.
 * @param virtualDescendantId The id of the virtual descendant.
 */

public void setSource(@androidx.annotation.RecentlyNullable android.view.View root, int virtualDescendantId) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link AccessibilityNodeInfo} of the event source.
 * <p>
 *   <strong>Note:</strong> It is a client responsibility to recycle the received info
 *   by calling {@link AccessibilityNodeInfo#recycle() AccessibilityNodeInfo#recycle()}
 *   to avoid creating of multiple instances.
 * </p>
 * @return The info of the source.
 */

public android.view.accessibility.AccessibilityNodeInfo getSource() { throw new RuntimeException("Stub!"); }

/**
 * Gets the id of the window from which the event comes from.
 *
 * @return The window id.
 */

public int getWindowId() { throw new RuntimeException("Stub!"); }

/**
 * Gets if the source is checked.
 *
 * @return True if the view is checked, false otherwise.
 */

public boolean isChecked() { throw new RuntimeException("Stub!"); }

/**
 * Sets if the source is checked.
 *
 * @param isChecked True if the view is checked, false otherwise.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setChecked(boolean isChecked) { throw new RuntimeException("Stub!"); }

/**
 * Gets if the source is enabled.
 *
 * @return True if the view is enabled, false otherwise.
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Sets if the source is enabled.
 *
 * @param isEnabled True if the view is enabled, false otherwise.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setEnabled(boolean isEnabled) { throw new RuntimeException("Stub!"); }

/**
 * Gets if the source is a password field.
 *
 * @return True if the view is a password field, false otherwise.
 */

public boolean isPassword() { throw new RuntimeException("Stub!"); }

/**
 * Sets if the source is a password field.
 *
 * @param isPassword True if the view is a password field, false otherwise.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setPassword(boolean isPassword) { throw new RuntimeException("Stub!"); }

/**
 * Gets if the source is taking the entire screen.
 *
 * @return True if the source is full screen, false otherwise.
 */

public boolean isFullScreen() { throw new RuntimeException("Stub!"); }

/**
 * Sets if the source is taking the entire screen.
 *
 * @param isFullScreen True if the source is full screen, false otherwise.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setFullScreen(boolean isFullScreen) { throw new RuntimeException("Stub!"); }

/**
 * Gets if the source is scrollable.
 *
 * @return True if the source is scrollable, false otherwise.
 */

public boolean isScrollable() { throw new RuntimeException("Stub!"); }

/**
 * Sets if the source is scrollable.
 *
 * @param scrollable True if the source is scrollable, false otherwise.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setScrollable(boolean scrollable) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of items that can be visited.
 *
 * @return The number of items.
 */

public int getItemCount() { throw new RuntimeException("Stub!"); }

/**
 * Sets the number of items that can be visited.
 *
 * @param itemCount The number of items.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setItemCount(int itemCount) { throw new RuntimeException("Stub!"); }

/**
 * Gets the index of the source in the list of items the can be visited.
 *
 * @return The current item index.
 */

public int getCurrentItemIndex() { throw new RuntimeException("Stub!"); }

/**
 * Sets the index of the source in the list of items that can be visited.
 *
 * @param currentItemIndex The current item index.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setCurrentItemIndex(int currentItemIndex) { throw new RuntimeException("Stub!"); }

/**
 * Gets the index of the first character of the changed sequence,
 * or the beginning of a text selection or the index of the first
 * visible item when scrolling.
 *
 * @return The index of the first character or selection
 *        start or the first visible item.
 */

public int getFromIndex() { throw new RuntimeException("Stub!"); }

/**
 * Sets the index of the first character of the changed sequence
 * or the beginning of a text selection or the index of the first
 * visible item when scrolling.
 *
 * @param fromIndex The index of the first character or selection
 *        start or the first visible item.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setFromIndex(int fromIndex) { throw new RuntimeException("Stub!"); }

/**
 * Gets the index of text selection end or the index of the last
 * visible item when scrolling.
 *
 * @return The index of selection end or last item index.
 */

public int getToIndex() { throw new RuntimeException("Stub!"); }

/**
 * Sets the index of text selection end or the index of the last
 * visible item when scrolling.
 *
 * @param toIndex The index of selection end or last item index.
 */

public void setToIndex(int toIndex) { throw new RuntimeException("Stub!"); }

/**
 * Gets the scroll offset of the source left edge in pixels.
 *
 * @return The scroll.
 */

public int getScrollX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the scroll offset of the source left edge in pixels.
 *
 * @param scrollX The scroll.
 */

public void setScrollX(int scrollX) { throw new RuntimeException("Stub!"); }

/**
 * Gets the scroll offset of the source top edge in pixels.
 *
 * @return The scroll.
 */

public int getScrollY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the scroll offset of the source top edge in pixels.
 *
 * @param scrollY The scroll.
 */

public void setScrollY(int scrollY) { throw new RuntimeException("Stub!"); }

/**
 * Gets the difference in pixels between the horizontal position before the scroll and the
 * current horizontal position
 *
 * @return the scroll delta x
 */

public int getScrollDeltaX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the difference in pixels between the horizontal position before the scroll and the
 * current horizontal position
 *
 * @param scrollDeltaX the scroll delta x
 */

public void setScrollDeltaX(int scrollDeltaX) { throw new RuntimeException("Stub!"); }

/**
 * Gets the difference in pixels between the vertical position before the scroll and the
 * current vertical position
 *
 * @return the scroll delta y
 */

public int getScrollDeltaY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the difference in pixels between the vertical position before the scroll and the
 * current vertical position
 *
 * @param scrollDeltaY the scroll delta y
 */

public void setScrollDeltaY(int scrollDeltaY) { throw new RuntimeException("Stub!"); }

/**
 * Gets the max scroll offset of the source left edge in pixels.
 *
 * @return The max scroll.
 */

public int getMaxScrollX() { throw new RuntimeException("Stub!"); }

/**
 * Sets the max scroll offset of the source left edge in pixels.
 *
 * @param maxScrollX The max scroll.
 */

public void setMaxScrollX(int maxScrollX) { throw new RuntimeException("Stub!"); }

/**
 * Gets the max scroll offset of the source top edge in pixels.
 *
 * @return The max scroll.
 */

public int getMaxScrollY() { throw new RuntimeException("Stub!"); }

/**
 * Sets the max scroll offset of the source top edge in pixels.
 *
 * @param maxScrollY The max scroll.
 */

public void setMaxScrollY(int maxScrollY) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of added characters.
 *
 * @return The number of added characters.
 */

public int getAddedCount() { throw new RuntimeException("Stub!"); }

/**
 * Sets the number of added characters.
 *
 * @param addedCount The number of added characters.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setAddedCount(int addedCount) { throw new RuntimeException("Stub!"); }

/**
 * Gets the number of removed characters.
 *
 * @return The number of removed characters.
 */

public int getRemovedCount() { throw new RuntimeException("Stub!"); }

/**
 * Sets the number of removed characters.
 *
 * @param removedCount The number of removed characters.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setRemovedCount(int removedCount) { throw new RuntimeException("Stub!"); }

/**
 * Gets the class name of the source.
 *
 * @return The class name.
 */

public java.lang.CharSequence getClassName() { throw new RuntimeException("Stub!"); }

/**
 * Sets the class name of the source.
 *
 * @param className The lass name.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setClassName(java.lang.CharSequence className) { throw new RuntimeException("Stub!"); }

/**
 * Gets the text of the event. The index in the list represents the priority
 * of the text. Specifically, the lower the index the higher the priority.
 *
 * @return The text.
 */

public java.util.List<java.lang.CharSequence> getText() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text before a change.
 *
 * @return The text before the change.
 */

public java.lang.CharSequence getBeforeText() { throw new RuntimeException("Stub!"); }

/**
 * Sets the text before a change.
 *
 * @param beforeText The text before the change.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setBeforeText(java.lang.CharSequence beforeText) { throw new RuntimeException("Stub!"); }

/**
 * Gets the description of the source.
 *
 * @return The description.
 */

public java.lang.CharSequence getContentDescription() { throw new RuntimeException("Stub!"); }

/**
 * Sets the description of the source.
 *
 * @param contentDescription The description.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setContentDescription(java.lang.CharSequence contentDescription) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link Parcelable} data.
 *
 * @return The parcelable data.
 */

public android.os.Parcelable getParcelableData() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link Parcelable} data of the event.
 *
 * @param parcelableData The parcelable data.
 *
 * @throws IllegalStateException If called from an AccessibilityService.
 */

public void setParcelableData(android.os.Parcelable parcelableData) { throw new RuntimeException("Stub!"); }

/**
 * Returns a cached instance if such is available or a new one is
 * instantiated. The instance is initialized with data from the
 * given record.
 *
 * @return An instance.
 */

public static android.view.accessibility.AccessibilityRecord obtain(android.view.accessibility.AccessibilityRecord record) { throw new RuntimeException("Stub!"); }

/**
 * Returns a cached instance if such is available or a new one is
 * instantiated.
 *
 * @return An instance.
 */

public static android.view.accessibility.AccessibilityRecord obtain() { throw new RuntimeException("Stub!"); }

/**
 * Return an instance back to be reused.
 * <p>
 * <strong>Note:</strong> You must not touch the object after calling this function.
 *
 * @throws IllegalStateException If the record is already recycled.
 */

public void recycle() { throw new RuntimeException("Stub!"); }

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

