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


package android.view;

import android.content.Context;
import android.graphics.PixelFormat;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.transition.TransitionManager;
import android.transition.Transition;
import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.media.session.MediaController;
import android.transition.Scene;
import android.graphics.Rect;
import android.view.accessibility.AccessibilityEvent;
import android.os.Handler;

/**
 * Abstract base class for a top-level window look and behavior policy.  An
 * instance of this class should be used as the top-level view added to the
 * window manager. It provides standard UI policies such as a background, title
 * area, default key processing, etc.
 *
 * <p>The only existing implementation of this abstract class is
 * android.view.PhoneWindow, which you should instantiate when needing a
 * Window.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Window {

public Window(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Return the Context this window policy is running in, for retrieving
 * resources and other information.
 *
 * @return Context The Context that was supplied to the constructor.
 */

public final android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Return the {@link android.R.styleable#Window} attributes from this
 * window's theme.
 */

public final android.content.res.TypedArray getWindowStyle() { throw new RuntimeException("Stub!"); }

/**
 * Set the container for this window.  If not set, the DecorWindow
 * operates as a top-level window; otherwise, it negotiates with the
 * container to display itself appropriately.
 *
 * @param container The desired containing Window.
 */

public void setContainer(android.view.Window container) { throw new RuntimeException("Stub!"); }

/**
 * Return the container for this Window.
 *
 * @return Window The containing window, or null if this is a
 *         top-level window.
 */

public final android.view.Window getContainer() { throw new RuntimeException("Stub!"); }

public final boolean hasChildren() { throw new RuntimeException("Stub!"); }

/**
 * Set the window manager for use by this Window to, for example,
 * display panels.  This is <em>not</em> used for displaying the
 * Window itself -- that must be done by the client.
 *
 * @param wm The window manager for adding new windows.
 */

public void setWindowManager(android.view.WindowManager wm, android.os.IBinder appToken, java.lang.String appName) { throw new RuntimeException("Stub!"); }

/**
 * Set the window manager for use by this Window to, for example,
 * display panels.  This is <em>not</em> used for displaying the
 * Window itself -- that must be done by the client.
 *
 * @param wm The window manager for adding new windows.
 */

public void setWindowManager(android.view.WindowManager wm, android.os.IBinder appToken, java.lang.String appName, boolean hardwareAccelerated) { throw new RuntimeException("Stub!"); }

/**
 * Return the window manager allowing this Window to display its own
 * windows.
 *
 * @return WindowManager The ViewManager.
 */

public android.view.WindowManager getWindowManager() { throw new RuntimeException("Stub!"); }

/**
 * Set the Callback interface for this window, used to intercept key
 * events and other dynamic operations in the window.
 *
 * @param callback The desired Callback interface.
 */

public void setCallback(android.view.Window.Callback callback) { throw new RuntimeException("Stub!"); }

/**
 * Return the current Callback interface for this window.
 */

public final android.view.Window.Callback getCallback() { throw new RuntimeException("Stub!"); }

/**
 * Set an observer to collect frame stats for each frame rendererd in this window.
 *
 * Must be in hardware rendering mode.

 * @param listener This value must never be {@code null}.
 */

public final void addOnFrameMetricsAvailableListener(@androidx.annotation.RecentlyNonNull android.view.Window.OnFrameMetricsAvailableListener listener, android.os.Handler handler) { throw new RuntimeException("Stub!"); }

/**
 * Remove observer and stop listening to frame stats for this window.
 */

public final void removeOnFrameMetricsAvailableListener(android.view.Window.OnFrameMetricsAvailableListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Set a callback for changes of area where caption will draw its content.
 *
 * @param listener Callback that will be called when the area changes.
 */

public final void setRestrictedCaptionAreaListener(android.view.Window.OnRestrictedCaptionAreaChangedListener listener) { throw new RuntimeException("Stub!"); }

/**
 * Take ownership of this window's surface.  The window's view hierarchy
 * will no longer draw into the surface, though it will otherwise continue
 * to operate (such as for receiving input events).  The given SurfaceHolder
 * callback will be used to tell you about state changes to the surface.
 */

public abstract void takeSurface(android.view.SurfaceHolder.Callback2 callback);

/**
 * Take ownership of this window's InputQueue.  The window will no
 * longer read and dispatch input events from the queue; it is your
 * responsibility to do so.
 */

public abstract void takeInputQueue(android.view.InputQueue.Callback callback);

/**
 * Return whether this window is being displayed with a floating style
 * (based on the {@link android.R.attr#windowIsFloating} attribute in
 * the style/theme).
 *
 * @return Returns true if the window is configured to be displayed floating
 * on top of whatever is behind it.
 */

public abstract boolean isFloating();

/**
 * Set the width and height layout parameters of the window.  The default
 * for both of these is MATCH_PARENT; you can change them to WRAP_CONTENT
 * or an absolute value to make a window that is not full-screen.
 *
 * @param width The desired layout width of the window.
 * @param height The desired layout height of the window.
 *
 * @see ViewGroup.LayoutParams#height
 * @see ViewGroup.LayoutParams#width
 */

public void setLayout(int width, int height) { throw new RuntimeException("Stub!"); }

/**
 * Set the gravity of the window, as per the Gravity constants.  This
 * controls how the window manager is positioned in the overall window; it
 * is only useful when using WRAP_CONTENT for the layout width or height.
 *
 * @param gravity The desired gravity constant.
 *
 * @see Gravity
 * @see #setLayout
 */

public void setGravity(int gravity) { throw new RuntimeException("Stub!"); }

/**
 * Set the type of the window, as per the WindowManager.LayoutParams
 * types.
 *
 * @param type The new window type (see WindowManager.LayoutParams).
 */

public void setType(int type) { throw new RuntimeException("Stub!"); }

/**
 * Set the format of window, as per the PixelFormat types.  This overrides
 * the default format that is selected by the Window based on its
 * window decorations.
 *
 * @param format The new window format (see PixelFormat).  Use
 *               PixelFormat.UNKNOWN to allow the Window to select
 *               the format.
 *
 * @see PixelFormat
 */

public void setFormat(int format) { throw new RuntimeException("Stub!"); }

/**
 * Specify custom animations to use for the window, as per
 * {@link WindowManager.LayoutParams#windowAnimations
 * WindowManager.LayoutParams.windowAnimations}.  Providing anything besides
 * 0 here will override the animations the window would
 * normally retrieve from its theme.
 */

public void setWindowAnimations(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Specify an explicit soft input mode to use for the window, as per
 * {@link WindowManager.LayoutParams#softInputMode
 * WindowManager.LayoutParams.softInputMode}.  Providing anything besides
 * "unspecified" here will override the input mode the window would
 * normally retrieve from its theme.
 */

public void setSoftInputMode(int mode) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function to set the flag bits as specified in flags, as
 * per {@link #setFlags}.
 * @param flags The flag bits to be set.
 * @see #setFlags
 * @see #clearFlags
 */

public void addFlags(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Convenience function to clear the flag bits as specified in flags, as
 * per {@link #setFlags}.
 * @param flags The flag bits to be cleared.
 * @see #setFlags
 * @see #addFlags
 */

public void clearFlags(int flags) { throw new RuntimeException("Stub!"); }

/**
 * Set the flags of the window, as per the
 * {@link WindowManager.LayoutParams WindowManager.LayoutParams}
 * flags.
 *
 * <p>Note that some flags must be set before the window decoration is
 * created (by the first call to
 * {@link #setContentView(View, android.view.ViewGroup.LayoutParams)} or
 * {@link #getDecorView()}:
 * {@link WindowManager.LayoutParams#FLAG_LAYOUT_IN_SCREEN} and
 * {@link WindowManager.LayoutParams#FLAG_LAYOUT_INSET_DECOR}.  These
 * will be set for you based on the {@link android.R.attr#windowIsFloating}
 * attribute.
 *
 * @param flags The new window flags (see WindowManager.LayoutParams).
 * @param mask Which of the window flag bits to modify.
 * @see #addFlags
 * @see #clearFlags
 */

public void setFlags(int flags, int mask) { throw new RuntimeException("Stub!"); }

/**
 * <p>Sets the requested color mode of the window. The requested the color mode might
 * override the window's pixel {@link WindowManager.LayoutParams#format format}.</p>
 *
 * <p>The requested color mode must be one of {@link ActivityInfo#COLOR_MODE_DEFAULT},
 * {@link ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT} or {@link ActivityInfo#COLOR_MODE_HDR}.</p>
 *
 * <p>The requested color mode is not guaranteed to be honored. Please refer to
 * {@link #getColorMode()} for more information.</p>
 *
 * @see #getColorMode()
 * @see Display#isWideColorGamut()
 * @see Configuration#isScreenWideColorGamut()

 * @param colorMode Value is {@link android.content.pm.ActivityInfo#COLOR_MODE_DEFAULT}, {@link android.content.pm.ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT}, or {@link android.content.pm.ActivityInfo#COLOR_MODE_HDR}
 */

public void setColorMode(int colorMode) { throw new RuntimeException("Stub!"); }

/**
 * Returns the requested color mode of the window, one of
 * {@link ActivityInfo#COLOR_MODE_DEFAULT}, {@link ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT}
 * or {@link ActivityInfo#COLOR_MODE_HDR}. If {@link ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT}
 * was requested it is possible the window will not be put in wide color gamut mode depending
 * on device and display support for that mode. Use {@link #isWideColorGamut} to determine
 * if the window is currently in wide color gamut mode.
 *
 * @see #setColorMode(int)
 * @see Display#isWideColorGamut()
 * @see Configuration#isScreenWideColorGamut()

 * @return Value is {@link android.content.pm.ActivityInfo#COLOR_MODE_DEFAULT}, {@link android.content.pm.ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT}, or {@link android.content.pm.ActivityInfo#COLOR_MODE_HDR}
 */

public int getColorMode() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if this window's color mode is {@link ActivityInfo#COLOR_MODE_WIDE_COLOR_GAMUT},
 * the display has a wide color gamut and this device supports wide color gamut rendering.
 *
 * @see Display#isWideColorGamut()
 * @see Configuration#isScreenWideColorGamut()
 */

public boolean isWideColorGamut() { throw new RuntimeException("Stub!"); }

/**
 * Set the amount of dim behind the window when using
 * {@link WindowManager.LayoutParams#FLAG_DIM_BEHIND}.  This overrides
 * the default dim amount of that is selected by the Window based on
 * its theme.
 *
 * @param amount The new dim amount, from 0 for no dim to 1 for full dim.
 */

public void setDimAmount(float amount) { throw new RuntimeException("Stub!"); }

/**
 * Specify custom window attributes.  <strong>PLEASE NOTE:</strong> the
 * layout params you give here should generally be from values previously
 * retrieved with {@link #getAttributes()}; you probably do not want to
 * blindly create and apply your own, since this will blow away any values
 * set by the framework that you are not interested in.
 *
 * @param a The new window attributes, which will completely override any
 *          current values.
 */

public void setAttributes(android.view.WindowManager.LayoutParams a) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the current window attributes associated with this panel.
 *
 * @return WindowManager.LayoutParams Either the existing window
 *         attributes object, or a freshly created one if there is none.
 */

public final android.view.WindowManager.LayoutParams getAttributes() { throw new RuntimeException("Stub!"); }

/**
 * Return the window flags that have been explicitly set by the client,
 * so will not be modified by {@link #getDecorView}.
 */

protected final int getForcedWindowFlags() { throw new RuntimeException("Stub!"); }

/**
 * Has the app specified their own soft input mode?
 */

protected final boolean hasSoftInputMode() { throw new RuntimeException("Stub!"); }

public void setSustainedPerformanceMode(boolean enable) { throw new RuntimeException("Stub!"); }

/**
 * Enable extended screen features.  This must be called before
 * setContentView().  May be called as many times as desired as long as it
 * is before setContentView().  If not called, no extended features
 * will be available.  You can not turn off a feature once it is requested.
 * You canot use other title features with {@link #FEATURE_CUSTOM_TITLE}.
 *
 * @param featureId The desired features, defined as constants by Window.
 * @return The features that are now set.
 */

public boolean requestFeature(int featureId) { throw new RuntimeException("Stub!"); }

public final void makeActive() { throw new RuntimeException("Stub!"); }

public final boolean isActive() { throw new RuntimeException("Stub!"); }

/**
 * Finds a view that was identified by the {@code android:id} XML attribute
 * that was processed in {@link android.app.Activity#onCreate}.
 * <p>
 * This will implicitly call {@link #getDecorView} with all of the associated side-effects.
 * <p>
 * <strong>Note:</strong> In most cases -- depending on compiler support --
 * the resulting view is automatically cast to the target class type. If
 * the target class type is unconstrained, an explicit cast may be
 * necessary.
 *
 * @param id the ID to search for
 * @return a view with given ID if found, or {@code null} otherwise
 * @see View#findViewById(int)
 * @see Window#requireViewById(int)
 */

public <T extends android.view.View> T findViewById(int id) { throw new RuntimeException("Stub!"); }

/**
 * Finds a view that was identified by the {@code android:id} XML attribute
 * that was processed in {@link android.app.Activity#onCreate}, or throws an
 * IllegalArgumentException if the ID is invalid, or there is no matching view in the hierarchy.
 * <p>
 * <strong>Note:</strong> In most cases -- depending on compiler support --
 * the resulting view is automatically cast to the target class type. If
 * the target class type is unconstrained, an explicit cast may be
 * necessary.
 *
 * @param id the ID to search for
 * @return a view with given ID
 * This value will never be {@code null}.
 * @see View#requireViewById(int)
 * @see Window#findViewById(int)
 */

@androidx.annotation.RecentlyNonNull public final <T extends android.view.View> T requireViewById(int id) { throw new RuntimeException("Stub!"); }

/**
 * Convenience for
 * {@link #setContentView(View, android.view.ViewGroup.LayoutParams)}
 * to set the screen content from a layout resource.  The resource will be
 * inflated, adding all top-level views to the screen.
 *
 * @param layoutResID Resource ID to be inflated.
 * @see #setContentView(View, android.view.ViewGroup.LayoutParams)
 */

public abstract void setContentView(int layoutResID);

/**
 * Convenience for
 * {@link #setContentView(View, android.view.ViewGroup.LayoutParams)}
 * set the screen content to an explicit view.  This view is placed
 * directly into the screen's view hierarchy.  It can itself be a complex
 * view hierarhcy.
 *
 * @param view The desired content to display.
 * @see #setContentView(View, android.view.ViewGroup.LayoutParams)
 */

public abstract void setContentView(android.view.View view);

/**
 * Set the screen content to an explicit view.  This view is placed
 * directly into the screen's view hierarchy.  It can itself be a complex
 * view hierarchy.
 *
 * <p>Note that calling this function "locks in" various characteristics
 * of the window that can not, from this point forward, be changed: the
 * features that have been requested with {@link #requestFeature(int)},
 * and certain window flags as described in {@link #setFlags(int, int)}.</p>
 *
 * <p>If {@link #FEATURE_CONTENT_TRANSITIONS} is set, the window's
 * TransitionManager will be used to animate content from the current
 * content View to view.</p>
 *
 * @param view The desired content to display.
 * @param params Layout parameters for the view.
 * @see #getTransitionManager()
 * @see #setTransitionManager(android.transition.TransitionManager)
 */

public abstract void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams params);

/**
 * Variation on
 * {@link #setContentView(View, android.view.ViewGroup.LayoutParams)}
 * to add an additional content view to the screen.  Added after any existing
 * ones in the screen -- existing views are NOT removed.
 *
 * @param view The desired content to display.
 * @param params Layout parameters for the view.
 */

public abstract void addContentView(android.view.View view, android.view.ViewGroup.LayoutParams params);

/**
 * Return the view in this Window that currently has focus, or null if
 * there are none.  Note that this does not look in any containing
 * Window.
 *
 * @return View The current View with focus or null.
 */

@androidx.annotation.RecentlyNullable public abstract android.view.View getCurrentFocus();

/**
 * Quick access to the {@link LayoutInflater} instance that this Window
 * retrieved from its Context.
 *
 * @return LayoutInflater The shared LayoutInflater.

 * This value will never be {@code null}.
 */

@androidx.annotation.RecentlyNonNull public abstract android.view.LayoutInflater getLayoutInflater();

public abstract void setTitle(java.lang.CharSequence title);

@Deprecated public abstract void setTitleColor(int textColor);

public abstract void openPanel(int featureId, android.view.KeyEvent event);

public abstract void closePanel(int featureId);

public abstract void togglePanel(int featureId, android.view.KeyEvent event);

public abstract void invalidatePanelMenu(int featureId);

public abstract boolean performPanelShortcut(int featureId, int keyCode, android.view.KeyEvent event, int flags);

public abstract boolean performPanelIdentifierAction(int featureId, int id, int flags);

public abstract void closeAllPanels();

public abstract boolean performContextMenuIdentifierAction(int id, int flags);

/**
 * Should be called when the configuration is changed.
 *
 * @param newConfig The new configuration.
 */

public abstract void onConfigurationChanged(android.content.res.Configuration newConfig);

/**
 * Sets the window elevation.
 * <p>
 * Changes to this property take effect immediately and will cause the
 * window surface to be recreated. This is an expensive operation and as a
 * result, this property should not be animated.
 *
 * @param elevation The window elevation.
 * @see View#setElevation(float)
 * @see android.R.styleable#Window_windowElevation
 */

public void setElevation(float elevation) { throw new RuntimeException("Stub!"); }

/**
 * Sets whether window content should be clipped to the outline of the
 * window background.
 *
 * @param clipToOutline Whether window content should be clipped to the
 *                      outline of the window background.
 * @see View#setClipToOutline(boolean)
 * @see android.R.styleable#Window_windowClipToOutline
 */

public void setClipToOutline(boolean clipToOutline) { throw new RuntimeException("Stub!"); }

/**
 * Change the background of this window to a Drawable resource. Setting the
 * background to null will make the window be opaque. To make the window
 * transparent, you can use an empty drawable (for instance a ColorDrawable
 * with the color 0 or the system drawable android:drawable/empty.)
 *
 * @param resId The resource identifier of a drawable resource which will
 *              be installed as the new background.
 */

public void setBackgroundDrawableResource(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Change the background of this window to a custom Drawable. Setting the
 * background to null will make the window be opaque. To make the window
 * transparent, you can use an empty drawable (for instance a ColorDrawable
 * with the color 0 or the system drawable android:drawable/empty.)
 *
 * @param drawable The new Drawable to use for this window's background.
 */

public abstract void setBackgroundDrawable(android.graphics.drawable.Drawable drawable);

/**
 * Set the value for a drawable feature of this window, from a resource
 * identifier.  You must have called requestFeature(featureId) before
 * calling this function.
 *
 * @see android.content.res.Resources#getDrawable(int)
 *
 * @param featureId The desired drawable feature to change, defined as a
 * constant by Window.
 * @param resId Resource identifier of the desired image.
 */

public abstract void setFeatureDrawableResource(int featureId, int resId);

/**
 * Set the value for a drawable feature of this window, from a URI. You
 * must have called requestFeature(featureId) before calling this
 * function.
 *
 * <p>The only URI currently supported is "content:", specifying an image
 * in a content provider.
 *
 * @see android.widget.ImageView#setImageURI
 *
 * @param featureId The desired drawable feature to change. Features are
 * constants defined by Window.
 * @param uri The desired URI.
 */

public abstract void setFeatureDrawableUri(int featureId, android.net.Uri uri);

/**
 * Set an explicit Drawable value for feature of this window. You must
 * have called requestFeature(featureId) before calling this function.
 *
 * @param featureId The desired drawable feature to change. Features are
 *                  constants defined by Window.
 * @param drawable A Drawable object to display.
 */

public abstract void setFeatureDrawable(int featureId, android.graphics.drawable.Drawable drawable);

/**
 * Set a custom alpha value for the given drawable feature, controlling how
 * much the background is visible through it.
 *
 * @param featureId The desired drawable feature to change. Features are
 *                  constants defined by Window.
 * @param alpha The alpha amount, 0 is completely transparent and 255 is
 *              completely opaque.
 */

public abstract void setFeatureDrawableAlpha(int featureId, int alpha);

/**
 * Set the integer value for a feature. The range of the value depends on
 * the feature being set. For {@link #FEATURE_PROGRESS}, it should go from
 * 0 to 10000. At 10000 the progress is complete and the indicator hidden.
 *
 * @param featureId The desired feature to change. Features are constants
 *                  defined by Window.
 * @param value The value for the feature. The interpretation of this
 *              value is feature-specific.
 */

public abstract void setFeatureInt(int featureId, int value);

/**
 * Request that key events come to this activity. Use this if your
 * activity has no views with focus, but the activity still wants
 * a chance to process key events.
 */

public abstract void takeKeyEvents(boolean get);

/**
 * Used by custom windows, such as Dialog, to pass the key press event
 * further down the view hierarchy. Application developers should
 * not need to implement or call this.
 *
 */

public abstract boolean superDispatchKeyEvent(android.view.KeyEvent event);

/**
 * Used by custom windows, such as Dialog, to pass the key shortcut press event
 * further down the view hierarchy. Application developers should
 * not need to implement or call this.
 *
 */

public abstract boolean superDispatchKeyShortcutEvent(android.view.KeyEvent event);

/**
 * Used by custom windows, such as Dialog, to pass the touch screen event
 * further down the view hierarchy. Application developers should
 * not need to implement or call this.
 *
 */

public abstract boolean superDispatchTouchEvent(android.view.MotionEvent event);

/**
 * Used by custom windows, such as Dialog, to pass the trackball event
 * further down the view hierarchy. Application developers should
 * not need to implement or call this.
 *
 */

public abstract boolean superDispatchTrackballEvent(android.view.MotionEvent event);

/**
 * Used by custom windows, such as Dialog, to pass the generic motion event
 * further down the view hierarchy. Application developers should
 * not need to implement or call this.
 *
 */

public abstract boolean superDispatchGenericMotionEvent(android.view.MotionEvent event);

/**
 * Retrieve the top-level window decor view (containing the standard
 * window frame/decorations and the client's content inside of that), which
 * can be added as a window to the window manager.
 *
 * <p><em>Note that calling this function for the first time "locks in"
 * various window characteristics as described in
 * {@link #setContentView(View, android.view.ViewGroup.LayoutParams)}.</em></p>
 *
 * @return Returns the top-level window decor view.
 */

@androidx.annotation.RecentlyNonNull public abstract android.view.View getDecorView();

/**
 * Retrieve the current decor view, but only if it has already been created;
 * otherwise returns null.
 *
 * @return Returns the top-level window decor or null.
 * @see #getDecorView
 */

public abstract android.view.View peekDecorView();

public abstract android.os.Bundle saveHierarchyState();

public abstract void restoreHierarchyState(android.os.Bundle savedInstanceState);

protected abstract void onActive();

/**
 * Return the feature bits that are enabled.  This is the set of features
 * that were given to requestFeature(), and are being handled by this
 * Window itself or its container.  That is, it is the set of
 * requested features that you can actually use.
 *
 * <p>To do: add a public version of this API that allows you to check for
 * features by their feature ID.
 *
 * @return int The feature bits.
 */

protected final int getFeatures() { throw new RuntimeException("Stub!"); }

/**
 * Return the feature bits set by default on a window.
 * @param context The context used to access resources
 */

public static int getDefaultFeatures(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Query for the availability of a certain feature.
 *
 * @param feature The feature ID to check
 * @return true if the feature is enabled, false otherwise.
 */

public boolean hasFeature(int feature) { throw new RuntimeException("Stub!"); }

/**
 * Return the feature bits that are being implemented by this Window.
 * This is the set of features that were given to requestFeature(), and are
 * being handled by only this Window itself, not by its containers.
 *
 * @return int The feature bits.
 */

protected final int getLocalFeatures() { throw new RuntimeException("Stub!"); }

/**
 * Set the default format of window, as per the PixelFormat types.  This
 * is the format that will be used unless the client specifies in explicit
 * format with setFormat();
 *
 * @param format The new window format (see PixelFormat).
 *
 * @see #setFormat
 * @see PixelFormat
 */

protected void setDefaultWindowFormat(int format) { throw new RuntimeException("Stub!"); }

public abstract void setChildDrawable(int featureId, android.graphics.drawable.Drawable drawable);

public abstract void setChildInt(int featureId, int value);

/**
 * Is a keypress one of the defined shortcut keys for this window.
 * @param keyCode the key code from {@link android.view.KeyEvent} to check.
 * @param event the {@link android.view.KeyEvent} to use to help check.
 */

public abstract boolean isShortcutKey(int keyCode, android.view.KeyEvent event);

/**
 * @see android.app.Activity#setVolumeControlStream(int)
 */

public abstract void setVolumeControlStream(int streamType);

/**
 * @see android.app.Activity#getVolumeControlStream()
 */

public abstract int getVolumeControlStream();

/**
 * Sets a {@link MediaController} to send media keys and volume changes to.
 * If set, this should be preferred for all media keys and volume requests
 * sent to this window.
 *
 * @param controller The controller for the session which should receive
 *            media keys and volume changes.
 * @see android.app.Activity#setMediaController(android.media.session.MediaController)
 */

public void setMediaController(android.media.session.MediaController controller) { throw new RuntimeException("Stub!"); }

/**
 * Gets the {@link MediaController} that was previously set.
 *
 * @return The controller which should receive events.
 * @see #setMediaController(android.media.session.MediaController)
 * @see android.app.Activity#getMediaController()
 */

public android.media.session.MediaController getMediaController() { throw new RuntimeException("Stub!"); }

/**
 * Set extra options that will influence the UI for this window.
 * @param uiOptions Flags specifying extra options for this window.
 */

public void setUiOptions(int uiOptions) { throw new RuntimeException("Stub!"); }

/**
 * Set extra options that will influence the UI for this window.
 * Only the bits filtered by mask will be modified.
 * @param uiOptions Flags specifying extra options for this window.
 * @param mask Flags specifying which options should be modified. Others will remain unchanged.
 */

public void setUiOptions(int uiOptions, int mask) { throw new RuntimeException("Stub!"); }

/**
 * Set the primary icon for this window.
 *
 * @param resId resource ID of a drawable to set
 */

public void setIcon(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set the logo for this window. A logo is often shown in place of an
 * {@link #setIcon(int) icon} but is generally wider and communicates window title information
 * as well.
 *
 * @param resId resource ID of a drawable to set
 */

public void setLogo(int resId) { throw new RuntimeException("Stub!"); }

/**
 * Set focus locally. The window should have the
 * {@link WindowManager.LayoutParams#FLAG_LOCAL_FOCUS_MODE} flag set already.
 * @param hasFocus Whether this window has focus or not.
 * @param inTouchMode Whether this window is in touch mode or not.
 */

public void setLocalFocus(boolean hasFocus, boolean inTouchMode) { throw new RuntimeException("Stub!"); }

/**
 * Inject an event to window locally.
 * @param event A key or touch event to inject to this window.
 */

public void injectInputEvent(android.view.InputEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link TransitionManager} responsible for  for default transitions
 * in this window. Requires {@link #FEATURE_CONTENT_TRANSITIONS}.
 *
 * <p>This method will return non-null after content has been initialized (e.g. by using
 * {@link #setContentView}) if {@link #FEATURE_CONTENT_TRANSITIONS} has been granted.</p>
 *
 * @return This window's content TransitionManager or null if none is set.
 * @attr ref android.R.styleable#Window_windowContentTransitionManager
 */

public android.transition.TransitionManager getTransitionManager() { throw new RuntimeException("Stub!"); }

/**
 * Set the {@link TransitionManager} to use for default transitions in this window.
 * Requires {@link #FEATURE_CONTENT_TRANSITIONS}.
 *
 * @param tm The TransitionManager to use for scene changes.
 * @attr ref android.R.styleable#Window_windowContentTransitionManager
 */

public void setTransitionManager(android.transition.TransitionManager tm) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the {@link Scene} representing this window's current content.
 * Requires {@link #FEATURE_CONTENT_TRANSITIONS}.
 *
 * <p>This method will return null if the current content is not represented by a Scene.</p>
 *
 * @return Current Scene being shown or null
 */

public android.transition.Scene getContentScene() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used to move Views into the initial scene. The entering
 * Views will be those that are regular Views or ViewGroups that have
 * {@link ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
 * {@link android.transition.Visibility} as entering is governed by changing visibility from
 * {@link View#INVISIBLE} to {@link View#VISIBLE}. If <code>transition</code> is null,
 * entering Views will remain unaffected.
 *
 * @param transition The Transition to use to move Views into the initial Scene.
 * @attr ref android.R.styleable#Window_windowEnterTransition
 */

public void setEnterTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used to move Views out of the scene when the Window is
 * preparing to close, for example after a call to
 * {@link android.app.Activity#finishAfterTransition()}. The exiting
 * Views will be those that are regular Views or ViewGroups that have
 * {@link ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
 * {@link android.transition.Visibility} as entering is governed by changing visibility from
 * {@link View#VISIBLE} to {@link View#INVISIBLE}. If <code>transition</code> is null,
 * entering Views will remain unaffected. If nothing is set, the default will be to
 * use the same value as set in {@link #setEnterTransition(android.transition.Transition)}.
 *
 * @param transition The Transition to use to move Views out of the Scene when the Window
 *                   is preparing to close.
 * @attr ref android.R.styleable#Window_windowReturnTransition
 */

public void setReturnTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used to move Views out of the scene when starting a
 * new Activity. The exiting Views will be those that are regular Views or ViewGroups that
 * have {@link ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
 * {@link android.transition.Visibility} as exiting is governed by changing visibility
 * from {@link View#VISIBLE} to {@link View#INVISIBLE}. If transition is null, the views will
 * remain unaffected. Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @param transition The Transition to use to move Views out of the scene when calling a
 *                   new Activity.
 * @attr ref android.R.styleable#Window_windowExitTransition
 */

public void setExitTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used to move Views in to the scene when returning from
 * a previously-started Activity. The entering Views will be those that are regular Views
 * or ViewGroups that have {@link ViewGroup#isTransitionGroup} return true. Typical Transitions
 * will extend {@link android.transition.Visibility} as exiting is governed by changing
 * visibility from {@link View#VISIBLE} to {@link View#INVISIBLE}. If transition is null,
 * the views will remain unaffected. If nothing is set, the default will be to use the same
 * transition as {@link #setExitTransition(android.transition.Transition)}.
 * Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @param transition The Transition to use to move Views into the scene when reentering from a
 *                   previously-started Activity.
 * @attr ref android.R.styleable#Window_windowReenterTransition
 */

public void setReenterTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the transition used to move Views into the initial scene. The entering
 * Views will be those that are regular Views or ViewGroups that have
 * {@link ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
 * {@link android.transition.Visibility} as entering is governed by changing visibility from
 * {@link View#INVISIBLE} to {@link View#VISIBLE}. If <code>transition</code> is null,
 * entering Views will remain unaffected.  Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @return the Transition to use to move Views into the initial Scene.
 * @attr ref android.R.styleable#Window_windowEnterTransition
 */

public android.transition.Transition getEnterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Transition that will be used to move Views out of the scene when the Window is
 * preparing to close, for example after a call to
 * {@link android.app.Activity#finishAfterTransition()}. The exiting
 * Views will be those that are regular Views or ViewGroups that have
 * {@link ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
 * {@link android.transition.Visibility} as entering is governed by changing visibility from
 * {@link View#VISIBLE} to {@link View#INVISIBLE}.
 *
 * @return The Transition to use to move Views out of the Scene when the Window
 *         is preparing to close.
 * @attr ref android.R.styleable#Window_windowReturnTransition
 */

public android.transition.Transition getReturnTransition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Transition that will be used to move Views out of the scene when starting a
 * new Activity. The exiting Views will be those that are regular Views or ViewGroups that
 * have {@link ViewGroup#isTransitionGroup} return true. Typical Transitions will extend
 * {@link android.transition.Visibility} as exiting is governed by changing visibility
 * from {@link View#VISIBLE} to {@link View#INVISIBLE}. If transition is null, the views will
 * remain unaffected. Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @return the Transition to use to move Views out of the scene when calling a
 * new Activity.
 * @attr ref android.R.styleable#Window_windowExitTransition
 */

public android.transition.Transition getExitTransition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Transition that will be used to move Views in to the scene when returning from
 * a previously-started Activity. The entering Views will be those that are regular Views
 * or ViewGroups that have {@link ViewGroup#isTransitionGroup} return true. Typical Transitions
 * will extend {@link android.transition.Visibility} as exiting is governed by changing
 * visibility from {@link View#VISIBLE} to {@link View#INVISIBLE}.
 * Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @return The Transition to use to move Views into the scene when reentering from a
 *         previously-started Activity.
 * @attr ref android.R.styleable#Window_windowReenterTransition
 */

public android.transition.Transition getReenterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used for shared elements transferred into the content
 * Scene. Typical Transitions will affect size and location, such as
 * {@link android.transition.ChangeBounds}. A null
 * value will cause transferred shared elements to blink to the final position.
 * Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @param transition The Transition to use for shared elements transferred into the content
 *                   Scene.
 * @attr ref android.R.styleable#Window_windowSharedElementEnterTransition
 */

public void setSharedElementEnterTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used for shared elements transferred back to a
 * calling Activity. Typical Transitions will affect size and location, such as
 * {@link android.transition.ChangeBounds}. A null
 * value will cause transferred shared elements to blink to the final position.
 * If no value is set, the default will be to use the same value as
 * {@link #setSharedElementEnterTransition(android.transition.Transition)}.
 * Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @param transition The Transition to use for shared elements transferred out of the content
 *                   Scene.
 * @attr ref android.R.styleable#Window_windowSharedElementReturnTransition
 */

public void setSharedElementReturnTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Transition that will be used for shared elements transferred into the content
 * Scene. Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @return Transition to use for sharend elements transferred into the content Scene.
 * @attr ref android.R.styleable#Window_windowSharedElementEnterTransition
 */

public android.transition.Transition getSharedElementEnterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Transition that will be used for shared elements transferred back to a
 * calling Activity. Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @return Transition to use for sharend elements transferred into the content Scene.
 * @attr ref android.R.styleable#Window_windowSharedElementReturnTransition
 */

public android.transition.Transition getSharedElementReturnTransition() { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used for shared elements after starting a new Activity
 * before the shared elements are transferred to the called Activity. If the shared elements
 * must animate during the exit transition, this Transition should be used. Upon completion,
 * the shared elements may be transferred to the started Activity.
 * Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @param transition The Transition to use for shared elements in the launching Window
 *                   prior to transferring to the launched Activity's Window.
 * @attr ref android.R.styleable#Window_windowSharedElementExitTransition
 */

public void setSharedElementExitTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Sets the Transition that will be used for shared elements reentering from a started
 * Activity after it has returned the shared element to it start location. If no value
 * is set, this will default to
 * {@link #setSharedElementExitTransition(android.transition.Transition)}.
 * Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @param transition The Transition to use for shared elements in the launching Window
 *                   after the shared element has returned to the Window.
 * @attr ref android.R.styleable#Window_windowSharedElementReenterTransition
 */

public void setSharedElementReenterTransition(android.transition.Transition transition) { throw new RuntimeException("Stub!"); }

/**
 * Returns the Transition to use for shared elements in the launching Window prior
 * to transferring to the launched Activity's Window.
 * Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @return the Transition to use for shared elements in the launching Window prior
 * to transferring to the launched Activity's Window.
 * @attr ref android.R.styleable#Window_windowSharedElementExitTransition
 */

public android.transition.Transition getSharedElementExitTransition() { throw new RuntimeException("Stub!"); }

/**
 * Returns the Transition that will be used for shared elements reentering from a started
 * Activity after it has returned the shared element to it start location.
 * Requires {@link #FEATURE_ACTIVITY_TRANSITIONS}.
 *
 * @return the Transition that will be used for shared elements reentering from a started
 * Activity after it has returned the shared element to it start location.
 * @attr ref android.R.styleable#Window_windowSharedElementReenterTransition
 */

public android.transition.Transition getSharedElementReenterTransition() { throw new RuntimeException("Stub!"); }

/**
 * Controls how the transition set in
 * {@link #setEnterTransition(android.transition.Transition)} overlaps with the exit
 * transition of the calling Activity. When true, the transition will start as soon as possible.
 * When false, the transition will wait until the remote exiting transition completes before
 * starting. The default value is true.
 *
 * @param allow true to start the enter transition when possible or false to
 *              wait until the exiting transition completes.
 * @attr ref android.R.styleable#Window_windowAllowEnterTransitionOverlap
 */

public void setAllowEnterTransitionOverlap(boolean allow) { throw new RuntimeException("Stub!"); }

/**
 * Returns how the transition set in
 * {@link #setEnterTransition(android.transition.Transition)} overlaps with the exit
 * transition of the calling Activity. When true, the transition will start as soon as possible.
 * When false, the transition will wait until the remote exiting transition completes before
 * starting. The default value is true.
 *
 * @return true when the enter transition should start as soon as possible or false to
 * when it should wait until the exiting transition completes.
 * @attr ref android.R.styleable#Window_windowAllowEnterTransitionOverlap
 */

public boolean getAllowEnterTransitionOverlap() { throw new RuntimeException("Stub!"); }

/**
 * Controls how the transition set in
 * {@link #setExitTransition(android.transition.Transition)} overlaps with the exit
 * transition of the called Activity when reentering after if finishes. When true,
 * the transition will start as soon as possible. When false, the transition will wait
 * until the called Activity's exiting transition completes before starting.
 * The default value is true.
 *
 * @param allow true to start the transition when possible or false to wait until the
 *              called Activity's exiting transition completes.
 * @attr ref android.R.styleable#Window_windowAllowReturnTransitionOverlap
 */

public void setAllowReturnTransitionOverlap(boolean allow) { throw new RuntimeException("Stub!"); }

/**
 * Returns how the transition set in
 * {@link #setExitTransition(android.transition.Transition)} overlaps with the exit
 * transition of the called Activity when reentering after if finishes. When true,
 * the transition will start as soon as possible. When false, the transition will wait
 * until the called Activity's exiting transition completes before starting.
 * The default value is true.
 *
 * @return true when the transition should start when possible or false when it should wait
 * until the called Activity's exiting transition completes.
 * @attr ref android.R.styleable#Window_windowAllowReturnTransitionOverlap
 */

public boolean getAllowReturnTransitionOverlap() { throw new RuntimeException("Stub!"); }

/**
 * Returns the duration, in milliseconds, of the window background fade
 * when transitioning into or away from an Activity when called with an Activity Transition.
 * <p>When executing the enter transition, the background starts transparent
 * and fades in. This requires {@link #FEATURE_ACTIVITY_TRANSITIONS}. The default is
 * 300 milliseconds.</p>
 *
 * @return The duration of the window background fade to opaque during enter transition.
 * @see #getEnterTransition()
 * @attr ref android.R.styleable#Window_windowTransitionBackgroundFadeDuration
 */

public long getTransitionBackgroundFadeDuration() { throw new RuntimeException("Stub!"); }

/**
 * Sets the duration, in milliseconds, of the window background fade
 * when transitioning into or away from an Activity when called with an Activity Transition.
 * <p>When executing the enter transition, the background starts transparent
 * and fades in. This requires {@link #FEATURE_ACTIVITY_TRANSITIONS}. The default is
 * 300 milliseconds.</p>
 *
 * @param fadeDurationMillis The duration of the window background fade to or from opaque
 *                           during enter transition.
 * @see #setEnterTransition(android.transition.Transition)
 * @attr ref android.R.styleable#Window_windowTransitionBackgroundFadeDuration
 */

public void setTransitionBackgroundFadeDuration(long fadeDurationMillis) { throw new RuntimeException("Stub!"); }

/**
 * Returns <code>true</code> when shared elements should use an Overlay during
 * shared element transitions or <code>false</code> when they should animate as
 * part of the normal View hierarchy. The default value is true.
 *
 * @return <code>true</code> when shared elements should use an Overlay during
 * shared element transitions or <code>false</code> when they should animate as
 * part of the normal View hierarchy.
 * @attr ref android.R.styleable#Window_windowSharedElementsUseOverlay
 */

public boolean getSharedElementsUseOverlay() { throw new RuntimeException("Stub!"); }

/**
 * Sets whether or not shared elements should use an Overlay during shared element transitions.
 * The default value is true.
 *
 * @param sharedElementsUseOverlay <code>true</code> indicates that shared elements should
 *                                 be transitioned with an Overlay or <code>false</code>
 *                                 to transition within the normal View hierarchy.
 * @attr ref android.R.styleable#Window_windowSharedElementsUseOverlay
 */

public void setSharedElementsUseOverlay(boolean sharedElementsUseOverlay) { throw new RuntimeException("Stub!"); }

/**
 * @return the color of the status bar.
 */

public abstract int getStatusBarColor();

/**
 * Sets the color of the status bar to {@code color}.
 *
 * For this to take effect,
 * the window must be drawing the system bar backgrounds with
 * {@link android.view.WindowManager.LayoutParams#FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS} and
 * {@link android.view.WindowManager.LayoutParams#FLAG_TRANSLUCENT_STATUS} must not be set.
 *
 * If {@code color} is not opaque, consider setting
 * {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_STABLE} and
 * {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN}.
 * <p>
 * The transitionName for the view background will be "android:status:background".
 * </p>
 */

public abstract void setStatusBarColor(int color);

/**
 * @return the color of the navigation bar.
 */

public abstract int getNavigationBarColor();

/**
 * Sets the color of the navigation bar to {@param color}.
 *
 * For this to take effect,
 * the window must be drawing the system bar backgrounds with
 * {@link android.view.WindowManager.LayoutParams#FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS} and
 * {@link android.view.WindowManager.LayoutParams#FLAG_TRANSLUCENT_NAVIGATION} must not be set.
 *
 * If {@param color} is not opaque, consider setting
 * {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_STABLE} and
 * {@link android.view.View#SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION}.
 * <p>
 * The transitionName for the view background will be "android:navigation:background".
 * </p>
 * @attr ref android.R.styleable#Window_navigationBarColor
 */

public abstract void setNavigationBarColor(int color);

/**
 * Shows a thin line of the specified color between the navigation bar and the app
 * content.
 * <p>
 * For this to take effect,
 * the window must be drawing the system bar backgrounds with
 * {@link android.view.WindowManager.LayoutParams#FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS} and
 * {@link android.view.WindowManager.LayoutParams#FLAG_TRANSLUCENT_NAVIGATION} must not be set.
 *
 * @param dividerColor The color of the thin line.
 * @attr ref android.R.styleable#Window_navigationBarDividerColor
 */

public void setNavigationBarDividerColor(int dividerColor) { throw new RuntimeException("Stub!"); }

/**
 * Retrieves the color of the navigation bar divider.
 *
 * @return The color of the navigation bar divider color.
 * @see #setNavigationBarColor(int)
 * @attr ref android.R.styleable#Window_navigationBarDividerColor
 */

public int getNavigationBarDividerColor() { throw new RuntimeException("Stub!"); }

/**
 * Set what color should the caption controls be. By default the system will try to determine
 * the color from the theme. You can overwrite this by using {@link #DECOR_CAPTION_SHADE_DARK},
 * {@link #DECOR_CAPTION_SHADE_LIGHT}, or {@link #DECOR_CAPTION_SHADE_AUTO}.
 * @see #DECOR_CAPTION_SHADE_DARK
 * @see #DECOR_CAPTION_SHADE_LIGHT
 * @see #DECOR_CAPTION_SHADE_AUTO
 */

public abstract void setDecorCaptionShade(int decorCaptionShade);

/**
 * Set the drawable that is drawn underneath the caption during the resizing.
 *
 * During the resizing the caption might not be drawn fast enough to match the new dimensions.
 * There is a second caption drawn underneath it that will be fast enough. By default the
 * caption is constructed from the theme. You can provide a drawable, that will be drawn instead
 * to better match your application.
 */

public abstract void setResizingCaptionDrawable(android.graphics.drawable.Drawable drawable);

/**
 * Flag for letting the theme drive the color of the window caption controls. Use with
 * {@link #setDecorCaptionShade(int)}. This is the default value.
 */

public static final int DECOR_CAPTION_SHADE_AUTO = 0; // 0x0

/**
 * Flag for setting dark-color controls on the window caption. Use with
 * {@link #setDecorCaptionShade(int)}.
 */

public static final int DECOR_CAPTION_SHADE_DARK = 2; // 0x2

/**
 * Flag for setting light-color controls on the window caption. Use with
 * {@link #setDecorCaptionShade(int)}.
 */

public static final int DECOR_CAPTION_SHADE_LIGHT = 1; // 0x1

/**
 * The default features enabled.
 * @deprecated use {@link #getDefaultFeatures(android.content.Context)} instead.
 */

@Deprecated protected static final int DEFAULT_FEATURES = 65; // 0x41

/**
 * Flag for enabling the Action Bar.
 * This is enabled by default for some devices. The Action Bar
 * replaces the title bar and provides an alternate location
 * for an on-screen menu button on some devices.
 */

public static final int FEATURE_ACTION_BAR = 8; // 0x8

/**
 * Flag for requesting an Action Bar that overlays window content.
 * Normally an Action Bar will sit in the space above window content, but if this
 * feature is requested along with {@link #FEATURE_ACTION_BAR} it will be layered over
 * the window content itself. This is useful if you would like your app to have more control
 * over how the Action Bar is displayed, such as letting application content scroll beneath
 * an Action Bar with a transparent background or otherwise displaying a transparent/translucent
 * Action Bar over application content.
 *
 * <p>This mode is especially useful with {@link View#SYSTEM_UI_FLAG_FULLSCREEN
 * View.SYSTEM_UI_FLAG_FULLSCREEN}, which allows you to seamlessly hide the
 * action bar in conjunction with other screen decorations.
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#JELLY_BEAN}, when an
 * ActionBar is in this mode it will adjust the insets provided to
 * {@link View#fitSystemWindows(android.graphics.Rect) View.fitSystemWindows(Rect)}
 * to include the content covered by the action bar, so you can do layout within
 * that space.
 */

public static final int FEATURE_ACTION_BAR_OVERLAY = 9; // 0x9

/**
 * Flag for specifying the behavior of action modes when an Action Bar is not present.
 * If overlay is enabled, the action mode UI will be allowed to cover existing window content.
 */

public static final int FEATURE_ACTION_MODE_OVERLAY = 10; // 0xa

/**
 * Enables Activities to run Activity Transitions either through sending or receiving
 * ActivityOptions bundle created with
 * {@link android.app.ActivityOptions#makeSceneTransitionAnimation(android.app.Activity,
 * android.util.Pair[])} or {@link android.app.ActivityOptions#makeSceneTransitionAnimation(
 * android.app.Activity, View, String)}.
 */

public static final int FEATURE_ACTIVITY_TRANSITIONS = 13; // 0xd

/**
 * Flag for requesting that window content changes should be animated using a
 * TransitionManager.
 *
 * <p>The TransitionManager is set using
 * {@link #setTransitionManager(android.transition.TransitionManager)}. If none is set,
 * a default TransitionManager will be used.</p>
 *
 * @see #setContentView
 */

public static final int FEATURE_CONTENT_TRANSITIONS = 12; // 0xc

/** Flag for the context menu.  This is enabled by default. */

public static final int FEATURE_CONTEXT_MENU = 6; // 0x6

/** Flag for custom title. You cannot combine this feature with other title features. */

public static final int FEATURE_CUSTOM_TITLE = 7; // 0x7

/**
 * Flag for indeterminate progress.
 *
 * @deprecated No longer supported starting in API 21.
 */

@Deprecated public static final int FEATURE_INDETERMINATE_PROGRESS = 5; // 0x5

/** Flag for having an icon on the left side of the title bar */

public static final int FEATURE_LEFT_ICON = 3; // 0x3

/** Flag for the "no title" feature, turning off the title at the top
 *  of the screen. */

public static final int FEATURE_NO_TITLE = 1; // 0x1

/** Flag for the "options panel" feature.  This is enabled by default. */

public static final int FEATURE_OPTIONS_PANEL = 0; // 0x0

/**
 * Flag for the progress indicator feature.
 *
 * @deprecated No longer supported starting in API 21.
 */

@Deprecated public static final int FEATURE_PROGRESS = 2; // 0x2

/** Flag for having an icon on the right side of the title bar */

public static final int FEATURE_RIGHT_ICON = 4; // 0x4

/**
 * Flag for requesting a decoration-free window that is dismissed by swiping from the left.
 */

public static final int FEATURE_SWIPE_TO_DISMISS = 11; // 0xb

/**
 * The ID that the main layout in the XML layout file should have.
 */

public static final int ID_ANDROID_CONTENT = 16908290; // 0x1020002

/**
 * The transitionName for the navigation bar background View when a custom background is used.
 * @see android.view.Window#setNavigationBarColor(int)
 */

public static final java.lang.String NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME = "android:navigation:background";

/**
 * Ending value for the (primary) progress.
 *
 * @deprecated {@link #FEATURE_PROGRESS} and related methods are no longer
 *             supported starting in API 21.
 */

@Deprecated public static final int PROGRESS_END = 10000; // 0x2710

/**
 * Flag for setting the progress bar's indeterminate mode off.
 *
 * @deprecated {@link #FEATURE_INDETERMINATE_PROGRESS} and related methods
 *             are no longer supported starting in API 21.
 */

@Deprecated public static final int PROGRESS_INDETERMINATE_OFF = -4; // 0xfffffffc

/**
 * Flag for setting the progress bar's indeterminate mode on.
 *
 * @deprecated {@link #FEATURE_INDETERMINATE_PROGRESS} and related methods
 *             are no longer supported starting in API 21.
 */

@Deprecated public static final int PROGRESS_INDETERMINATE_ON = -3; // 0xfffffffd

/**
 * Highest possible value for the secondary progress.
 *
 * @deprecated {@link #FEATURE_PROGRESS} and related methods are no longer
 *             supported starting in API 21.
 */

@Deprecated public static final int PROGRESS_SECONDARY_END = 30000; // 0x7530

/**
 * Lowest possible value for the secondary progress.
 *
 * @deprecated {@link #FEATURE_PROGRESS} and related methods are no longer
 *             supported starting in API 21.
 */

@Deprecated public static final int PROGRESS_SECONDARY_START = 20000; // 0x4e20

/**
 * Starting value for the (primary) progress.
 *
 * @deprecated {@link #FEATURE_PROGRESS} and related methods are no longer
 *             supported starting in API 21.
 */

@Deprecated public static final int PROGRESS_START = 0; // 0x0

/**
 * Flag for setting the progress bar's visibility to GONE.
 *
 * @deprecated {@link #FEATURE_PROGRESS} and related methods are no longer
 *             supported starting in API 21.
 */

@Deprecated public static final int PROGRESS_VISIBILITY_OFF = -2; // 0xfffffffe

/**
 * Flag for setting the progress bar's visibility to VISIBLE.
 *
 * @deprecated {@link #FEATURE_PROGRESS} and related methods are no longer
 *             supported starting in API 21.
 */

@Deprecated public static final int PROGRESS_VISIBILITY_ON = -1; // 0xffffffff

/**
 * The transitionName for the status bar background View when a custom background is used.
 * @see android.view.Window#setStatusBarColor(int)
 */

public static final java.lang.String STATUS_BAR_BACKGROUND_TRANSITION_NAME = "android:status:background";
/**
 * API from a Window back to its caller.  This allows the client to
 * intercept key dispatching, panels and menus, etc.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Callback {

/**
 * Called to process key events.  At the very least your
 * implementation must call
 * {@link android.view.Window#superDispatchKeyEvent} to do the
 * standard key processing.
 *
 * @param event The key event.
 *
 * @return boolean Return true if this event was consumed.
 */

public boolean dispatchKeyEvent(android.view.KeyEvent event);

/**
 * Called to process a key shortcut event.
 * At the very least your implementation must call
 * {@link android.view.Window#superDispatchKeyShortcutEvent} to do the
 * standard key shortcut processing.
 *
 * @param event The key shortcut event.
 * @return True if this event was consumed.
 */

public boolean dispatchKeyShortcutEvent(android.view.KeyEvent event);

/**
 * Called to process touch screen events.  At the very least your
 * implementation must call
 * {@link android.view.Window#superDispatchTouchEvent} to do the
 * standard touch screen processing.
 *
 * @param event The touch screen event.
 *
 * @return boolean Return true if this event was consumed.
 */

public boolean dispatchTouchEvent(android.view.MotionEvent event);

/**
 * Called to process trackball events.  At the very least your
 * implementation must call
 * {@link android.view.Window#superDispatchTrackballEvent} to do the
 * standard trackball processing.
 *
 * @param event The trackball event.
 *
 * @return boolean Return true if this event was consumed.
 */

public boolean dispatchTrackballEvent(android.view.MotionEvent event);

/**
 * Called to process generic motion events.  At the very least your
 * implementation must call
 * {@link android.view.Window#superDispatchGenericMotionEvent} to do the
 * standard processing.
 *
 * @param event The generic motion event.
 *
 * @return boolean Return true if this event was consumed.
 */

public boolean dispatchGenericMotionEvent(android.view.MotionEvent event);

/**
 * Called to process population of {@link AccessibilityEvent}s.
 *
 * @param event The event.
 *
 * @return boolean Return true if event population was completed.
 */

public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent event);

/**
 * Instantiate the view to display in the panel for 'featureId'.
 * You can return null, in which case the default content (typically
 * a menu) will be created for you.
 *
 * @param featureId Which panel is being created.
 *
 * @return view The top-level view to place in the panel.
 *
 * @see #onPreparePanel
 */

@androidx.annotation.RecentlyNullable public android.view.View onCreatePanelView(int featureId);

/**
 * Initialize the contents of the menu for panel 'featureId'.  This is
 * called if onCreatePanelView() returns null, giving you a standard
 * menu in which you can place your items.  It is only called once for
 * the panel, the first time it is shown.
 *
 * <p>You can safely hold on to <var>menu</var> (and any items created
 * from it), making modifications to it as desired, until the next
 * time onCreatePanelMenu() is called for this feature.
 *
 * @param featureId The panel being created.
 * @param menu The menu inside the panel.
 *
 * @return boolean You must return true for the panel to be displayed;
 *         if you return false it will not be shown.
 */

public boolean onCreatePanelMenu(int featureId, android.view.Menu menu);

/**
 * Prepare a panel to be displayed.  This is called right before the
 * panel window is shown, every time it is shown.
 *
 * @param featureId The panel that is being displayed.
 * @param view The View that was returned by onCreatePanelView().
 * @param menu If onCreatePanelView() returned null, this is the Menu
 *             being displayed in the panel.
 *
 * @return boolean You must return true for the panel to be displayed;
 *         if you return false it will not be shown.
 *
 * @see #onCreatePanelView
 */

public boolean onPreparePanel(int featureId, android.view.View view, android.view.Menu menu);

/**
 * Called when a panel's menu is opened by the user. This may also be
 * called when the menu is changing from one type to another (for
 * example, from the icon menu to the expanded menu).
 *
 * @param featureId The panel that the menu is in.
 * @param menu The menu that is opened.
 * @return Return true to allow the menu to open, or false to prevent
 *         the menu from opening.
 */

public boolean onMenuOpened(int featureId, android.view.Menu menu);

/**
 * Called when a panel's menu item has been selected by the user.
 *
 * @param featureId The panel that the menu is in.
 * @param item The menu item that was selected.
 *
 * @return boolean Return true to finish processing of selection, or
 *         false to perform the normal menu handling (calling its
 *         Runnable or sending a Message to its target Handler).
 */

public boolean onMenuItemSelected(int featureId, android.view.MenuItem item);

/**
 * This is called whenever the current window attributes change.
 *
 */

public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams attrs);

/**
 * This hook is called whenever the content view of the screen changes
 * (due to a call to
 * {@link Window#setContentView(View, android.view.ViewGroup.LayoutParams)
 * Window.setContentView} or
 * {@link Window#addContentView(View, android.view.ViewGroup.LayoutParams)
 * Window.addContentView}).
 */

public void onContentChanged();

/**
 * This hook is called whenever the window focus changes.  See
 * {@link View#onWindowFocusChanged(boolean)
 * View.onWindowFocusChangedNotLocked(boolean)} for more information.
 *
 * @param hasFocus Whether the window now has focus.
 */

public void onWindowFocusChanged(boolean hasFocus);

/**
 * Called when the window has been attached to the window manager.
 * See {@link View#onAttachedToWindow() View.onAttachedToWindow()}
 * for more information.
 */

public void onAttachedToWindow();

/**
 * Called when the window has been detached from the window manager.
 * See {@link View#onDetachedFromWindow() View.onDetachedFromWindow()}
 * for more information.
 */

public void onDetachedFromWindow();

/**
 * Called when a panel is being closed.  If another logical subsequent
 * panel is being opened (and this panel is being closed to make room for the subsequent
 * panel), this method will NOT be called.
 *
 * @param featureId The panel that is being displayed.
 * @param menu If onCreatePanelView() returned null, this is the Menu
 *            being displayed in the panel.
 */

public void onPanelClosed(int featureId, android.view.Menu menu);

/**
 * Called when the user signals the desire to start a search.
 *
 * @return true if search launched, false if activity refuses (blocks)
 *
 * @see android.app.Activity#onSearchRequested()
 */

public boolean onSearchRequested();

/**
 * Called when the user signals the desire to start a search.
 *
 * @param searchEvent A {@link SearchEvent} describing the signal to
 *                   start a search.
 * @return true if search launched, false if activity refuses (blocks)
 */

public boolean onSearchRequested(android.view.SearchEvent searchEvent);

/**
 * Called when an action mode is being started for this window. Gives the
 * callback an opportunity to handle the action mode in its own unique and
 * beautiful way. If this method returns null the system can choose a way
 * to present the mode or choose not to start the mode at all. This is equivalent
 * to {@link #onWindowStartingActionMode(android.view.ActionMode.Callback, int)}
 * with type {@link ActionMode#TYPE_PRIMARY}.
 *
 * @param callback Callback to control the lifecycle of this action mode
 * @return The ActionMode that was started, or null if the system should present it
 */

@androidx.annotation.RecentlyNullable public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback);

/**
 * Called when an action mode is being started for this window. Gives the
 * callback an opportunity to handle the action mode in its own unique and
 * beautiful way. If this method returns null the system can choose a way
 * to present the mode or choose not to start the mode at all.
 *
 * @param callback Callback to control the lifecycle of this action mode
 * @param type One of {@link ActionMode#TYPE_PRIMARY} or {@link ActionMode#TYPE_FLOATING}.
 * @return The ActionMode that was started, or null if the system should present it
 */

@androidx.annotation.RecentlyNullable public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type);

/**
 * Called when an action mode has been started. The appropriate mode callback
 * method will have already been invoked.
 *
 * @param mode The new mode that has just been started.
 */

public void onActionModeStarted(android.view.ActionMode mode);

/**
 * Called when an action mode has been finished. The appropriate mode callback
 * method will have already been invoked.
 *
 * @param mode The mode that was just finished.
 */

public void onActionModeFinished(android.view.ActionMode mode);

/**
 * Called when Keyboard Shortcuts are requested for the current window.
 *
 * @param data The data list to populate with shortcuts.
 * @param menu The current menu, which may be null.
 * This value may be {@code null}.
 * @param deviceId The id for the connected device the shortcuts should be provided for.
 */

public default void onProvideKeyboardShortcuts(java.util.List<android.view.KeyboardShortcutGroup> data, @androidx.annotation.RecentlyNullable android.view.Menu menu, int deviceId) { throw new RuntimeException("Stub!"); }

/**
 * Called when pointer capture is enabled or disabled for the current window.
 *
 * @param hasCapture True if the window has pointer capture.
 */

public default void onPointerCaptureChanged(boolean hasCapture) { throw new RuntimeException("Stub!"); }
}

/**
 * Callback for clients that want frame timing information for each
 * frame rendered by the Window.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnFrameMetricsAvailableListener {

/**
 * Called when information is available for the previously rendered frame.
 *
 * Reports can be dropped if this callback takes too
 * long to execute, as the report producer cannot wait for the consumer to
 * complete.
 *
 * It is highly recommended that clients copy the passed in FrameMetrics
 * via {@link FrameMetrics#FrameMetrics(FrameMetrics)} within this method and defer
 * additional computation or storage to another thread to avoid unnecessarily
 * dropping reports.
 *
 * @param window The {@link Window} on which the frame was displayed.
 * @param frameMetrics the available metrics. This object is reused on every call
 * and thus <strong>this reference is not valid outside the scope of this method</strong>.
 * @param dropCountSinceLastInvocation the number of reports dropped since the last time
 * this callback was invoked.
 */

public void onFrameMetricsAvailable(android.view.Window window, android.view.FrameMetrics frameMetrics, int dropCountSinceLastInvocation);
}

/**
 * Callback for clients that want to be aware of where caption draws content.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface OnRestrictedCaptionAreaChangedListener {

/**
 * Called when the area where caption draws content changes.
 *
 * @param rect The area where caption content is positioned, relative to the top view.
 */

public void onRestrictedCaptionAreaChanged(android.graphics.Rect rect);
}

}

