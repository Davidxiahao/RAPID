
package android.app.assist;

import android.app.Activity;
import android.view.ViewStructure;
import android.view.View;
import android.os.SystemClock;
import android.view.autofill.AutofillValue;
import android.graphics.Matrix;
import android.os.Bundle;

/**
 * Assist data automatically created by the platform's implementation of assist and autofill.
 *
 * <p>The structure is used for assist purposes when created by
 * {@link android.app.Activity#onProvideAssistData}, {@link View#onProvideStructure(ViewStructure)},
 * or {@link View#onProvideVirtualStructure(ViewStructure)}.
 *
 * <p>The structure is used for autofill purposes when created by
 * {@link View#onProvideAutofillStructure(ViewStructure, int)},
 * or {@link View#onProvideAutofillVirtualStructure(ViewStructure, int)}.
 *
 * <p>For performance reasons, some properties of the assist data might be available just for assist
 * or autofill purposes; in those case, the property availability will be document in its javadoc.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AssistStructure implements android.os.Parcelable {

public AssistStructure() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time when the activity started generating assist data to build the
 * AssistStructure. The time is as specified by {@link SystemClock#uptimeMillis()}.
 *
 * @see #getAcquisitionEndTime()
 * @return Returns the acquisition start time of the assist data, in milliseconds.
 */

public long getAcquisitionStartTime() { throw new RuntimeException("Stub!"); }

/**
 * Returns the time when the activity finished generating assist data to build the
 * AssistStructure. The time is as specified by {@link SystemClock#uptimeMillis()}.
 *
 * @see #getAcquisitionStartTime()
 * @return Returns the acquisition end time of the assist data, in milliseconds.
 */

public long getAcquisitionEndTime() { throw new RuntimeException("Stub!"); }

/**
 * Return the activity this AssistStructure came from.
 */

public android.content.ComponentName getActivityComponent() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether the activity associated with this AssistStructure was the home activity
 * (Launcher) at the time the assist data was acquired.
 * @return Whether the activity was the home activity.
 * @see android.content.Intent#CATEGORY_HOME
 */

public boolean isHomeActivity() { throw new RuntimeException("Stub!"); }

/**
 * Return the number of window contents that have been collected in this assist data.
 */

public int getWindowNodeCount() { throw new RuntimeException("Stub!"); }

/**
 * Return one of the windows in the assist data.
 * @param index Which window to retrieve, may be 0 to {@link #getWindowNodeCount()}-1.
 */

public android.app.assist.AssistStructure.WindowNode getWindowNodeAt(int index) { throw new RuntimeException("Stub!"); }

public int describeContents() { throw new RuntimeException("Stub!"); }

public void writeToParcel(android.os.Parcel out, int flags) { throw new RuntimeException("Stub!"); }

public static final android.os.Parcelable.Creator<android.app.assist.AssistStructure> CREATOR;
static { CREATOR = null; }
/**
 * Describes a single view in the assist data.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class ViewNode {

ViewNode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ID associated with this view, as per {@link View#getId() View.getId()}.
 */

public int getId() { throw new RuntimeException("Stub!"); }

/**
 * If {@link #getId()} is a resource identifier, this is the package name of that
 * identifier.  See {@link android.view.ViewStructure#setId ViewStructure.setId}
 * for more information.
 */

public java.lang.String getIdPackage() { throw new RuntimeException("Stub!"); }

/**
 * If {@link #getId()} is a resource identifier, this is the type name of that
 * identifier.  See {@link android.view.ViewStructure#setId ViewStructure.setId}
 * for more information.
 */

public java.lang.String getIdType() { throw new RuntimeException("Stub!"); }

/**
 * If {@link #getId()} is a resource identifier, this is the entry name of that
 * identifier.  See {@link android.view.ViewStructure#setId ViewStructure.setId}
 * for more information.
 */

public java.lang.String getIdEntry() { throw new RuntimeException("Stub!"); }

/**
 * Gets the id that can be used to autofill the view contents.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for autofill purposes.
 *
 * @return id that can be used to autofill the view contents, or {@code null} if the
 * structure was created for assist purposes.
 */

@androidx.annotation.RecentlyNullable public android.view.autofill.AutofillId getAutofillId() { throw new RuntimeException("Stub!"); }

/**
 * Gets the the type of value that can be used to autofill the view contents.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for autofill purposes.
 *
 * @return autofill type as defined by {@link View#getAutofillType()},
 * or {@link View#AUTOFILL_TYPE_NONE} if the structure was created for assist purposes.

 * Value is {@link android.view.View#AUTOFILL_TYPE_NONE}, {@link android.view.View#AUTOFILL_TYPE_TEXT}, {@link android.view.View#AUTOFILL_TYPE_TOGGLE}, {@link android.view.View#AUTOFILL_TYPE_LIST}, or {@link android.view.View#AUTOFILL_TYPE_DATE}
 */

public int getAutofillType() { throw new RuntimeException("Stub!"); }

/**
 * Describes the content of a view so that a autofill service can fill in the appropriate
 * data.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for autofill purposes,
 * not for Assist - see {@link View#getAutofillHints()} for more info.
 *
 * @return The autofill hints for this view, or {@code null} if the structure was created
 * for assist purposes.
 */

@androidx.annotation.RecentlyNullable public java.lang.String[] getAutofillHints() { throw new RuntimeException("Stub!"); }

/**
 * Gets the the value of this view.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for autofill purposes,
 * not for assist purposes.
 *
 * @return the autofill value of this view, or {@code null} if the structure was created
 * for assist purposes.
 */

@androidx.annotation.RecentlyNullable public android.view.autofill.AutofillValue getAutofillValue() { throw new RuntimeException("Stub!"); }

/**
 * Gets the options that can be used to autofill this view.
 *
 * <p>Typically used by nodes whose {@link View#getAutofillType()} is a list to indicate
 * the meaning of each possible value in the list.
 *
 * <p>It's relevant when the {@link AssistStructure} is used for autofill purposes, not
 * for assist purposes.
 *
 * @return the options that can be used to autofill this view, or {@code null} if the
 * structure was created for assist purposes.
 */

@androidx.annotation.RecentlyNullable public java.lang.CharSequence[] getAutofillOptions() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link android.text.InputType} bits of this structure.
 *
 * @return bits as defined by {@link android.text.InputType}.
 */

public int getInputType() { throw new RuntimeException("Stub!"); }

/**
 * Returns the left edge of this view, in pixels, relative to the left edge of its parent.
 */

public int getLeft() { throw new RuntimeException("Stub!"); }

/**
 * Returns the top edge of this view, in pixels, relative to the top edge of its parent.
 */

public int getTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current X scroll offset of this view, as per
 * {@link android.view.View#getScrollX() View.getScrollX()}.
 */

public int getScrollX() { throw new RuntimeException("Stub!"); }

/**
 * Returns the current Y scroll offset of this view, as per
 * {@link android.view.View#getScrollX() View.getScrollY()}.
 */

public int getScrollY() { throw new RuntimeException("Stub!"); }

/**
 * Returns the width of this view, in pixels.
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the height of this view, in pixels.
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the transformation that has been applied to this view, such as a translation
 * or scaling.  The returned Matrix object is owned by ViewNode; do not modify it.
 * Returns null if there is no transformation applied to the view.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for assist purposes,
 * not for autofill purposes.
 */

public android.graphics.Matrix getTransformation() { throw new RuntimeException("Stub!"); }

/**
 * Returns the visual elevation of the view, used for shadowing and other visual
 * characterstics, as set by {@link ViewStructure#setElevation
 * ViewStructure.setElevation(float)}.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for assist purposes,
 * not for autofill purposes.
 */

public float getElevation() { throw new RuntimeException("Stub!"); }

/**
 * Returns the alpha transformation of the view, used to reduce the overall opacity
 * of the view's contents, as set by {@link ViewStructure#setAlpha
 * ViewStructure.setAlpha(float)}.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for assist purposes,
 * not for autofill purposes.
 */

public float getAlpha() { throw new RuntimeException("Stub!"); }

/**
 * Returns the visibility mode of this view, as per
 * {@link android.view.View#getVisibility() View.getVisibility()}.
 */

public int getVisibility() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if assist data has been blocked starting at this node in the hierarchy.
 */

public boolean isAssistBlocked() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this node is in an enabled state.
 */

public boolean isEnabled() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this node is clickable by the user.
 */

public boolean isClickable() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this node can take input focus.
 */

public boolean isFocusable() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this node currently had input focus at the time that the
 * structure was collected.
 */

public boolean isFocused() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this node currently had accessibility focus at the time that the
 * structure was collected.
 */

public boolean isAccessibilityFocused() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this node represents something that is checkable by the user.
 */

public boolean isCheckable() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this node is currently in a checked state.
 */

public boolean isChecked() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this node has currently been selected by the user.
 */

public boolean isSelected() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this node has currently been activated by the user.
 */

public boolean isActivated() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this node is opaque.
 */

public boolean isOpaque() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this node is something the user can perform a long click/press on.
 */

public boolean isLongClickable() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this node is something the user can perform a context click on.
 */

public boolean isContextClickable() { throw new RuntimeException("Stub!"); }

/**
 * Returns the class name of the node's implementation, indicating its behavior.
 * For example, a button will report "android.widget.Button" meaning it behaves
 * like a {@link android.widget.Button}.
 */

public java.lang.String getClassName() { throw new RuntimeException("Stub!"); }

/**
 * Returns any content description associated with the node, which semantically describes
 * its purpose for accessibility and other uses.
 */

public java.lang.CharSequence getContentDescription() { throw new RuntimeException("Stub!"); }

/**
 * Returns the domain of the HTML document represented by this view.
 *
 * <p>Typically used when the view associated with the view is a container for an HTML
 * document.
 *
 * <p><b>Warning:</b> an autofill service cannot trust the value reported by this method
 * without verifing its authenticity&mdash;see the "Web security" section of
 * {@link android.service.autofill.AutofillService} for more details.
 *
 * @return domain-only part of the document. For example, if the full URL is
 * {@code https://example.com/login?user=my_user}, it returns {@code example.com}.

 * This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getWebDomain() { throw new RuntimeException("Stub!"); }

/**
 * Returns the scheme of the HTML document represented by this view.
 *
 * <p>Typically used when the view associated with the view is a container for an HTML
 * document.
 *
 * @return scheme-only part of the document. For example, if the full URL is
 * {@code https://example.com/login?user=my_user}, it returns {@code https}.

 * This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getWebScheme() { throw new RuntimeException("Stub!"); }

/**
 * Returns the HTML properties associated with this view.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for autofill purposes,
 * not for assist purposes.
 *
 * @return the HTML properties associated with this view, or {@code null} if the
 * structure was created for assist purposes.
 */

@androidx.annotation.RecentlyNullable public android.view.ViewStructure.HtmlInfo getHtmlInfo() { throw new RuntimeException("Stub!"); }

/**
 * Returns the the list of locales associated with this view.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public android.os.LocaleList getLocaleList() { throw new RuntimeException("Stub!"); }

/**
 * Returns any text associated with the node that is displayed to the user, or null
 * if there is none.
 */

public java.lang.CharSequence getText() { throw new RuntimeException("Stub!"); }

/**
 * If {@link #getText()} is non-null, this is where the current selection starts.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for assist purposes,
 * not for autofill purposes.
 */

public int getTextSelectionStart() { throw new RuntimeException("Stub!"); }

/**
 * If {@link #getText()} is non-null, this is where the current selection starts.
 * If there is no selection, returns the same value as {@link #getTextSelectionStart()},
 * indicating the cursor position.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for assist purposes,
 * not for autofill purposes.
 */

public int getTextSelectionEnd() { throw new RuntimeException("Stub!"); }

/**
 * If {@link #getText()} is non-null, this is the main text color associated with it.
 * If there is no text color, {@link #TEXT_COLOR_UNDEFINED} is returned.
 * Note that the text may also contain style spans that modify the color of specific
 * parts of the text.
 */

public int getTextColor() { throw new RuntimeException("Stub!"); }

/**
 * If {@link #getText()} is non-null, this is the main text background color associated
 * with it.
 * If there is no text background color, {@link #TEXT_COLOR_UNDEFINED} is returned.
 * Note that the text may also contain style spans that modify the color of specific
 * parts of the text.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for assist purposes,
 * not for autofill purposes.
 */

public int getTextBackgroundColor() { throw new RuntimeException("Stub!"); }

/**
 * If {@link #getText()} is non-null, this is the main text size (in pixels) associated
 * with it.
 * Note that the text may also contain style spans that modify the size of specific
 * parts of the text.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for assist purposes,
 * not for autofill purposes.
 */

public float getTextSize() { throw new RuntimeException("Stub!"); }

/**
 * If {@link #getText()} is non-null, this is the main text style associated
 * with it, containing a bit mask of {@link #TEXT_STYLE_BOLD},
 * {@link #TEXT_STYLE_BOLD}, {@link #TEXT_STYLE_STRIKE_THRU}, and/or
 * {@link #TEXT_STYLE_UNDERLINE}.
 * Note that the text may also contain style spans that modify the style of specific
 * parts of the text.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for assist purposes,
 * not for autofill purposes.
 */

public int getTextStyle() { throw new RuntimeException("Stub!"); }

/**
 * Return per-line offsets into the text returned by {@link #getText()}.  Each entry
 * in the array is a formatted line of text, and the value it contains is the offset
 * into the text string where that line starts.  May return null if there is no line
 * information.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for assist purposes,
 * not for autofill purposes.
 */

public int[] getTextLineCharOffsets() { throw new RuntimeException("Stub!"); }

/**
 * Return per-line baselines into the text returned by {@link #getText()}.  Each entry
 * in the array is a formatted line of text, and the value it contains is the baseline
 * where that text appears in the view.  May return null if there is no line
 * information.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for assist purposes,
 * not for autofill purposes.
 */

public int[] getTextLineBaselines() { throw new RuntimeException("Stub!"); }

/**
 * Gets the identifier used to set the text associated with this view.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for autofill purposes,
 * not for assist purposes.

 * @return This value may be {@code null}.
 */

@androidx.annotation.RecentlyNullable public java.lang.String getTextIdEntry() { throw new RuntimeException("Stub!"); }

/**
 * Return additional hint text associated with the node; this is typically used with
 * a node that takes user input, describing to the user what the input means.
 */

public java.lang.String getHint() { throw new RuntimeException("Stub!"); }

/**
 * Return a Bundle containing optional vendor-specific extension information.
 */

public android.os.Bundle getExtras() { throw new RuntimeException("Stub!"); }

/**
 * Return the number of children this node has.
 */

public int getChildCount() { throw new RuntimeException("Stub!"); }

/**
 * Return a child of this node, given an index value from 0 to
 * {@link #getChildCount()}-1.
 */

public android.app.assist.AssistStructure.ViewNode getChildAt(int index) { throw new RuntimeException("Stub!"); }

/**
 * Returns the minimum width in ems of the text associated with this node, or {@code -1}
 * if not supported by the node.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for autofill purposes,
 * not for assist purposes.
 */

public int getMinTextEms() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum width in ems of the text associated with this node, or {@code -1}
 * if not supported by the node.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for autofill purposes,
 * not for assist purposes.
 */

public int getMaxTextEms() { throw new RuntimeException("Stub!"); }

/**
 * Returns the maximum length of the text associated with this node node, or {@code -1}
 * if not supported by the node or not set.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for autofill purposes,
 * not for assist purposes.
 */

public int getMaxTextLength() { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link View#setImportantForAutofill(int) importantForAutofill mode} of
 * the view associated with this node.
 *
 * <p>It's only relevant when the {@link AssistStructure} is used for autofill purposes.

 * @return Value is {@link android.view.View#IMPORTANT_FOR_AUTOFILL_AUTO}, {@link android.view.View#IMPORTANT_FOR_AUTOFILL_YES}, {@link android.view.View#IMPORTANT_FOR_AUTOFILL_NO}, {@link android.view.View#IMPORTANT_FOR_AUTOFILL_YES_EXCLUDE_DESCENDANTS}, or {@link android.view.View#IMPORTANT_FOR_AUTOFILL_NO_EXCLUDE_DESCENDANTS}
 */

public int getImportantForAutofill() { throw new RuntimeException("Stub!"); }

/**
 * Magic value for text color that has not been defined, which is very unlikely
 * to be confused with a real text color.
 */

public static final int TEXT_COLOR_UNDEFINED = 1; // 0x1

public static final int TEXT_STYLE_BOLD = 1; // 0x1

public static final int TEXT_STYLE_ITALIC = 2; // 0x2

public static final int TEXT_STYLE_STRIKE_THRU = 8; // 0x8

public static final int TEXT_STYLE_UNDERLINE = 4; // 0x4
}

/**
 * Describes a window in the assist data.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class WindowNode {

WindowNode() { throw new RuntimeException("Stub!"); }

/**
 * Returns the left edge of the window, in pixels, relative to the left
 * edge of the screen.
 */

public int getLeft() { throw new RuntimeException("Stub!"); }

/**
 * Returns the top edge of the window, in pixels, relative to the top
 * edge of the screen.
 */

public int getTop() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total width of the window in pixels.
 */

public int getWidth() { throw new RuntimeException("Stub!"); }

/**
 * Returns the total height of the window in pixels.
 */

public int getHeight() { throw new RuntimeException("Stub!"); }

/**
 * Returns the title associated with the window, if it has one.
 */

public java.lang.CharSequence getTitle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the ID of the display this window is on, for use with
 * {@link android.hardware.display.DisplayManager#getDisplay DisplayManager.getDisplay()}.
 */

public int getDisplayId() { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@link ViewNode} containing the root content of the window.
 */

public android.app.assist.AssistStructure.ViewNode getRootViewNode() { throw new RuntimeException("Stub!"); }
}

}

