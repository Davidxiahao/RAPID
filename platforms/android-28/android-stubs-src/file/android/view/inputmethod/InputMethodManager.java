/*
 * Copyright (C) 2007-2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


package android.view.inputmethod;

import android.inputmethodservice.InputMethodService;
import android.content.pm.PackageManager;
import android.view.View;
import android.os.ResultReceiver;
import android.content.Context;
import android.os.IBinder;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * Central system API to the overall input method framework (IMF) architecture,
 * which arbitrates interaction between applications and the current input method.
 *
 * <p>Topics covered here:
 * <ol>
 * <li><a href="#ArchitectureOverview">Architecture Overview</a>
 * <li><a href="#Applications">Applications</a>
 * <li><a href="#InputMethods">Input Methods</a>
 * <li><a href="#Security">Security</a>
 * </ol>
 *
 * <a name="ArchitectureOverview"></a>
 * <h3>Architecture Overview</h3>
 *
 * <p>There are three primary parties involved in the input method
 * framework (IMF) architecture:</p>
 *
 * <ul>
 * <li> The <strong>input method manager</strong> as expressed by this class
 * is the central point of the system that manages interaction between all
 * other parts.  It is expressed as the client-side API here which exists
 * in each application context and communicates with a global system service
 * that manages the interaction across all processes.
 * <li> An <strong>input method (IME)</strong> implements a particular
 * interaction model allowing the user to generate text.  The system binds
 * to the current input method that is in use, causing it to be created and run,
 * and tells it when to hide and show its UI.  Only one IME is running at a time.
 * <li> Multiple <strong>client applications</strong> arbitrate with the input
 * method manager for input focus and control over the state of the IME.  Only
 * one such client is ever active (working with the IME) at a time.
 * </ul>
 *
 *
 * <a name="Applications"></a>
 * <h3>Applications</h3>
 *
 * <p>In most cases, applications that are using the standard
 * {@link android.widget.TextView} or its subclasses will have little they need
 * to do to work well with soft input methods.  The main things you need to
 * be aware of are:</p>
 *
 * <ul>
 * <li> Properly set the {@link android.R.attr#inputType} in your editable
 * text views, so that the input method will have enough context to help the
 * user in entering text into them.
 * <li> Deal well with losing screen space when the input method is
 * displayed.  Ideally an application should handle its window being resized
 * smaller, but it can rely on the system performing panning of the window
 * if needed.  You should set the {@link android.R.attr#windowSoftInputMode}
 * attribute on your activity or the corresponding values on windows you
 * create to help the system determine whether to pan or resize (it will
 * try to determine this automatically but may get it wrong).
 * <li> You can also control the preferred soft input state (open, closed, etc)
 * for your window using the same {@link android.R.attr#windowSoftInputMode}
 * attribute.
 * </ul>
 *
 * <p>More finer-grained control is available through the APIs here to directly
 * interact with the IMF and its IME -- either showing or hiding the input
 * area, letting the user pick an input method, etc.</p>
 *
 * <p>For the rare people amongst us writing their own text editors, you
 * will need to implement {@link android.view.View#onCreateInputConnection}
 * to return a new instance of your own {@link InputConnection} interface
 * allowing the IME to interact with your editor.</p>
 *
 *
 * <a name="InputMethods"></a>
 * <h3>Input Methods</h3>
 *
 * <p>An input method (IME) is implemented
 * as a {@link android.app.Service}, typically deriving from
 * {@link android.inputmethodservice.InputMethodService}.  It must provide
 * the core {@link InputMethod} interface, though this is normally handled by
 * {@link android.inputmethodservice.InputMethodService} and implementors will
 * only need to deal with the higher-level API there.</p>
 *
 * See the {@link android.inputmethodservice.InputMethodService} class for
 * more information on implementing IMEs.
 *
 *
 * <a name="Security"></a>
 * <h3>Security</h3>
 *
 * <p>There are a lot of security issues associated with input methods,
 * since they essentially have freedom to completely drive the UI and monitor
 * everything the user enters.  The Android input method framework also allows
 * arbitrary third party IMEs, so care must be taken to restrict their
 * selection and interactions.</p>
 *
 * <p>Here are some key points about the security architecture behind the
 * IMF:</p>
 *
 * <ul>
 * <li> <p>Only the system is allowed to directly access an IME's
 * {@link InputMethod} interface, via the
 * {@link android.Manifest.permission#BIND_INPUT_METHOD} permission.  This is
 * enforced in the system by not binding to an input method service that does
 * not require this permission, so the system can guarantee no other untrusted
 * clients are accessing the current input method outside of its control.</p>
 *
 * <li> <p>There may be many client processes of the IMF, but only one may
 * be active at a time.  The inactive clients can not interact with key
 * parts of the IMF through the mechanisms described below.</p>
 *
 * <li> <p>Clients of an input method are only given access to its
 * {@link InputMethodSession} interface.  One instance of this interface is
 * created for each client, and only calls from the session associated with
 * the active client will be processed by the current IME.  This is enforced
 * by {@link android.inputmethodservice.AbstractInputMethodService} for normal
 * IMEs, but must be explicitly handled by an IME that is customizing the
 * raw {@link InputMethodSession} implementation.</p>
 *
 * <li> <p>Only the active client's {@link InputConnection} will accept
 * operations.  The IMF tells each client process whether it is active, and
 * the framework enforces that in inactive processes calls on to the current
 * InputConnection will be ignored.  This ensures that the current IME can
 * only deliver events and text edits to the UI that the user sees as
 * being in focus.</p>
 *
 * <li> <p>An IME can never interact with an {@link InputConnection} while
 * the screen is off.  This is enforced by making all clients inactive while
 * the screen is off, and prevents bad IMEs from driving the UI when the user
 * can not be aware of its behavior.</p>
 *
 * <li> <p>A client application can ask that the system let the user pick a
 * new IME, but can not programmatically switch to one itself.  This avoids
 * malicious applications from switching the user to their own IME, which
 * remains running when the user navigates away to another application.  An
 * IME, on the other hand, <em>is</em> allowed to programmatically switch
 * the system to another IME, since it already has full control of user
 * input.</p>
 *
 * <li> <p>The user must explicitly enable a new IME in settings before
 * they can switch to it, to confirm with the system that they know about it
 * and want to make it available for use.</p>
 * </ul>

 * Requires the {@link android.content.pm.PackageManager#FEATURE_INPUT_METHODS PackageManager#FEATURE_INPUT_METHODS} feature which can be detected using {@link android.content.pm.PackageManager#hasSystemFeature(String) PackageManager.hasSystemFeature(String)}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class InputMethodManager {

InputMethodManager() { throw new RuntimeException("Stub!"); }

public java.util.List<android.view.inputmethod.InputMethodInfo> getInputMethodList() { throw new RuntimeException("Stub!"); }

public java.util.List<android.view.inputmethod.InputMethodInfo> getEnabledInputMethodList() { throw new RuntimeException("Stub!"); }

/**
 * Returns a list of enabled input method subtypes for the specified input method info.
 * @param imi An input method info whose subtypes list will be returned.
 * @param allowsImplicitlySelectedSubtypes A boolean flag to allow to return the implicitly
 * selected subtypes. If an input method info doesn't have enabled subtypes, the framework
 * will implicitly enable subtypes according to the current system language.
 */

public java.util.List<android.view.inputmethod.InputMethodSubtype> getEnabledInputMethodSubtypeList(android.view.inputmethod.InputMethodInfo imi, boolean allowsImplicitlySelectedSubtypes) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link InputMethodService#showStatusIcon(int)} instead. This method was
 * intended for IME developers who should be accessing APIs through the service. APIs in this
 * class are intended for app developers interacting with the IME.
 */

@Deprecated public void showStatusIcon(android.os.IBinder imeToken, java.lang.String packageName, int iconId) { throw new RuntimeException("Stub!"); }

/**
 * @deprecated Use {@link InputMethodService#hideStatusIcon()} instead. This method was
 * intended for IME developers who should be accessing APIs through the service. APIs in
 * this class are intended for app developers interacting with the IME.
 */

@Deprecated public void hideStatusIcon(android.os.IBinder imeToken) { throw new RuntimeException("Stub!"); }

/**
 * Allows you to discover whether the attached input method is running
 * in fullscreen mode.  Return true if it is fullscreen, entirely covering
 * your UI, else returns false.
 */

public boolean isFullscreenMode() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the given view is the currently active view for the
 * input method.
 */

public boolean isActive(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Return true if any view is currently active in the input method.
 */

public boolean isActive() { throw new RuntimeException("Stub!"); }

/**
 * Return true if the currently served view is accepting full text edits.
 * If false, it has no input connection, so can only handle raw key events.
 */

public boolean isAcceptingText() { throw new RuntimeException("Stub!"); }

public void displayCompletions(android.view.View view, android.view.inputmethod.CompletionInfo[] completions) { throw new RuntimeException("Stub!"); }

public void updateExtractedText(android.view.View view, int token, android.view.inputmethod.ExtractedText text) { throw new RuntimeException("Stub!"); }

/**
 * Synonym for {@link #showSoftInput(View, int, ResultReceiver)} without
 * a result receiver: explicitly request that the current input method's
 * soft input area be shown to the user, if needed.
 *
 * @param view The currently focused view, which would like to receive
 * soft keyboard input.
 * @param flags Provides additional operating flags.  Currently may be
 * 0 or have the {@link #SHOW_IMPLICIT} bit set.
 */

public boolean showSoftInput(android.view.View view, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Explicitly request that the current input method's soft input area be
 * shown to the user, if needed.  Call this if the user interacts with
 * your view in such a way that they have expressed they would like to
 * start performing input into it.
 *
 * <p><strong>Caveat:</strong> {@link ResultReceiver} instance passed to
 * this method can be a long-lived object, because it may not be
 * garbage-collected until all the corresponding {@link ResultReceiver}
 * objects transferred to different processes get garbage-collected.
 * Follow the general patterns to avoid memory leaks in Android.
 * Consider to use {@link java.lang.ref.WeakReference} so that application
 * logic objects such as {@link android.app.Activity} and {@link Context}
 * can be garbage collected regardless of the lifetime of
 * {@link ResultReceiver}.
 *
 * @param view The currently focused view, which would like to receive
 * soft keyboard input.
 * @param flags Provides additional operating flags.  Currently may be
 * 0 or have the {@link #SHOW_IMPLICIT} bit set.
 * @param resultReceiver If non-null, this will be called by the IME when
 * it has processed your request to tell you what it has done.  The result
 * code you receive may be either {@link #RESULT_UNCHANGED_SHOWN},
 * {@link #RESULT_UNCHANGED_HIDDEN}, {@link #RESULT_SHOWN}, or
 * {@link #RESULT_HIDDEN}.
 */

public boolean showSoftInput(android.view.View view, int flags, android.os.ResultReceiver resultReceiver) { throw new RuntimeException("Stub!"); }

/**
 * Synonym for {@link #hideSoftInputFromWindow(IBinder, int, ResultReceiver)}
 * without a result: request to hide the soft input window from the
 * context of the window that is currently accepting input.
 *
 * @param windowToken The token of the window that is making the request,
 * as returned by {@link View#getWindowToken() View.getWindowToken()}.
 * @param flags Provides additional operating flags.  Currently may be
 * 0 or have the {@link #HIDE_IMPLICIT_ONLY} bit set.
 */

public boolean hideSoftInputFromWindow(android.os.IBinder windowToken, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Request to hide the soft input window from the context of the window
 * that is currently accepting input.  This should be called as a result
 * of the user doing some actually than fairly explicitly requests to
 * have the input window hidden.
 *
 * <p><strong>Caveat:</strong> {@link ResultReceiver} instance passed to
 * this method can be a long-lived object, because it may not be
 * garbage-collected until all the corresponding {@link ResultReceiver}
 * objects transferred to different processes get garbage-collected.
 * Follow the general patterns to avoid memory leaks in Android.
 * Consider to use {@link java.lang.ref.WeakReference} so that application
 * logic objects such as {@link android.app.Activity} and {@link Context}
 * can be garbage collected regardless of the lifetime of
 * {@link ResultReceiver}.
 *
 * @param windowToken The token of the window that is making the request,
 * as returned by {@link View#getWindowToken() View.getWindowToken()}.
 * @param flags Provides additional operating flags.  Currently may be
 * 0 or have the {@link #HIDE_IMPLICIT_ONLY} bit set.
 * @param resultReceiver If non-null, this will be called by the IME when
 * it has processed your request to tell you what it has done.  The result
 * code you receive may be either {@link #RESULT_UNCHANGED_SHOWN},
 * {@link #RESULT_UNCHANGED_HIDDEN}, {@link #RESULT_SHOWN}, or
 * {@link #RESULT_HIDDEN}.
 */

public boolean hideSoftInputFromWindow(android.os.IBinder windowToken, int flags, android.os.ResultReceiver resultReceiver) { throw new RuntimeException("Stub!"); }

/**
 * This method toggles the input method window display.
 * If the input window is already displayed, it gets hidden.
 * If not the input window will be displayed.
 * @param windowToken The token of the window that is making the request,
 * as returned by {@link View#getWindowToken() View.getWindowToken()}.
 * @param showFlags Provides additional operating flags.  May be
 * 0 or have the {@link #SHOW_IMPLICIT},
 * {@link #SHOW_FORCED} bit set.
 * @param hideFlags Provides additional operating flags.  May be
 * 0 or have the {@link #HIDE_IMPLICIT_ONLY},
 * {@link #HIDE_NOT_ALWAYS} bit set.
 **/

public void toggleSoftInputFromWindow(android.os.IBinder windowToken, int showFlags, int hideFlags) { throw new RuntimeException("Stub!"); }

/**
 * This method toggles the input method window display.
 *
 * If the input window is already displayed, it gets hidden.
 * If not the input window will be displayed.
 * @param showFlags Provides additional operating flags.  May be
 * 0 or have the {@link #SHOW_IMPLICIT},
 * {@link #SHOW_FORCED} bit set.
 * @param hideFlags Provides additional operating flags.  May be
 * 0 or have the {@link #HIDE_IMPLICIT_ONLY},
 * {@link #HIDE_NOT_ALWAYS} bit set.
 */

public void toggleSoftInput(int showFlags, int hideFlags) { throw new RuntimeException("Stub!"); }

/**
 * If the input method is currently connected to the given view,
 * restart it with its new contents.  You should call this when the text
 * within your view changes outside of the normal input method or key
 * input flow, such as when an application calls TextView.setText().
 *
 * @param view The view whose text has changed.
 */

public void restartInput(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Report the current selection range.
 *
 * <p><strong>Editor authors</strong>, you need to call this method whenever
 * the cursor moves in your editor. Remember that in addition to doing this, your
 * editor needs to always supply current cursor values in
 * {@link EditorInfo#initialSelStart} and {@link EditorInfo#initialSelEnd} every
 * time {@link android.view.View#onCreateInputConnection(EditorInfo)} is
 * called, which happens whenever the keyboard shows up or the focus changes
 * to a text field, among other cases.</p>
 */

public void updateSelection(android.view.View view, int selStart, int selEnd, int candidatesStart, int candidatesEnd) { throw new RuntimeException("Stub!"); }

/**
 * Notify the event when the user tapped or clicked the text view.
 */

public void viewClicked(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Return true if the current input method wants to watch the location
 * of the input editor's cursor in its window.
 *
 * @deprecated Use {@link InputConnection#requestCursorUpdates(int)} instead.
 */

@Deprecated public boolean isWatchingCursor(android.view.View view) { throw new RuntimeException("Stub!"); }

/**
 * Report the current cursor location in its window.
 *
 * @deprecated Use {@link #updateCursorAnchorInfo(View, CursorAnchorInfo)} instead.
 */

@Deprecated public void updateCursor(android.view.View view, int left, int top, int right, int bottom) { throw new RuntimeException("Stub!"); }

/**
 * Report positional change of the text insertion point and/or characters in the composition
 * string.
 */

public void updateCursorAnchorInfo(android.view.View view, android.view.inputmethod.CursorAnchorInfo cursorAnchorInfo) { throw new RuntimeException("Stub!"); }

/**
 * Call {@link InputMethodSession#appPrivateCommand(String, Bundle)
 * InputMethodSession.appPrivateCommand()} on the current Input Method.
 * @param view Optional View that is sending the command, or null if
 * you want to send the command regardless of the view that is attached
 * to the input method.
 * @param action Name of the command to be performed.  This <em>must</em>
 * be a scoped name, i.e. prefixed with a package name you own, so that
 * different developers will not create conflicting commands.
 * @param data Any data to include with the command.
 */

public void sendAppPrivateCommand(android.view.View view, java.lang.String action, android.os.Bundle data) { throw new RuntimeException("Stub!"); }

/**
 * Force switch to a new input method component. This can only be called
 * from an application or a service which has a token of the currently active input method.
 * @param token Supplies the identifying token given to an input method
 * when it was started, which allows it to perform this operation on
 * itself.
 * @param id The unique identifier for the new input method to be switched to.
 * @deprecated Use {@link InputMethodService#switchInputMethod(String)}
 * instead. This method was intended for IME developers who should be accessing APIs through
 * the service. APIs in this class are intended for app developers interacting with the IME.
 */

@Deprecated public void setInputMethod(android.os.IBinder token, java.lang.String id) { throw new RuntimeException("Stub!"); }

/**
 * Force switch to a new input method and subtype. This can only be called
 * from an application or a service which has a token of the currently active input method.
 * @param token Supplies the identifying token given to an input method
 * when it was started, which allows it to perform this operation on
 * itself.
 * @param id The unique identifier for the new input method to be switched to.
 * @param subtype The new subtype of the new input method to be switched to.
 * @deprecated Use
 * {@link InputMethodService#switchInputMethod(String, InputMethodSubtype)}
 * instead. This method was intended for IME developers who should be accessing APIs through
 * the service. APIs in this class are intended for app developers interacting with the IME.
 */

@Deprecated public void setInputMethodAndSubtype(android.os.IBinder token, java.lang.String id, android.view.inputmethod.InputMethodSubtype subtype) { throw new RuntimeException("Stub!"); }

/**
 * Close/hide the input method's soft input area, so the user no longer
 * sees it or can interact with it.  This can only be called
 * from the currently active input method, as validated by the given token.
 *
 * @param token Supplies the identifying token given to an input method
 * when it was started, which allows it to perform this operation on
 * itself.
 * @param flags Provides additional operating flags.  Currently may be
 * 0 or have the {@link #HIDE_IMPLICIT_ONLY},
 * {@link #HIDE_NOT_ALWAYS} bit set.
 * @deprecated Use {@link InputMethodService#requestHideSelf(int)} instead. This method was
 * intended for IME developers who should be accessing APIs through the service. APIs in this
 * class are intended for app developers interacting with the IME.
 */

@Deprecated public void hideSoftInputFromInputMethod(android.os.IBinder token, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Show the input method's soft input area, so the user
 * sees the input method window and can interact with it.
 * This can only be called from the currently active input method,
 * as validated by the given token.
 *
 * @param token Supplies the identifying token given to an input method
 * when it was started, which allows it to perform this operation on
 * itself.
 * @param flags Provides additional operating flags.  Currently may be
 * 0 or have the {@link #SHOW_IMPLICIT} or
 * {@link #SHOW_FORCED} bit set.
 * @deprecated Use {@link InputMethodService#requestShowSelf(int)} instead. This method was
 * intended for IME developers who should be accessing APIs through the service. APIs in this
 * class are intended for app developers interacting with the IME.
 */

@Deprecated public void showSoftInputFromInputMethod(android.os.IBinder token, int flags) { throw new RuntimeException("Stub!"); }

/**
 * Provides the default implementation of {@link InputConnection#sendKeyEvent(KeyEvent)}, which
 * is expected to dispatch an keyboard event sent from the IME to an appropriate event target
 * depending on the given {@link View} and the current focus state.
 *
 * <p>CAUTION: This method is provided only for the situation where
 * {@link InputConnection#sendKeyEvent(KeyEvent)} needs to be implemented without relying on
 * {@link BaseInputConnection}. Do not use this API for anything else.</p>
 *
 * @param targetView the default target view. If {@code null} is specified, then this method
 * tries to find a good event target based on the current focus state.
 * This value may be {@code null}.
 * @param event the key event to be dispatched.

 * This value must never be {@code null}.
 */

public void dispatchKeyEventFromInputMethod(@androidx.annotation.RecentlyNullable android.view.View targetView, @androidx.annotation.RecentlyNonNull android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

public void showInputMethodPicker() { throw new RuntimeException("Stub!"); }

/**
 * Show the settings for enabling subtypes of the specified input method.
 * @param imiId An input method, whose subtypes settings will be shown. If imiId is null,
 * subtypes of all input methods will be shown.
 */

public void showInputMethodAndSubtypeEnabler(java.lang.String imiId) { throw new RuntimeException("Stub!"); }

/**
 * Returns the current input method subtype. This subtype is one of the subtypes in
 * the current input method. This method returns null when the current input method doesn't
 * have any input method subtype.
 */

public android.view.inputmethod.InputMethodSubtype getCurrentInputMethodSubtype() { throw new RuntimeException("Stub!"); }

/**
 * Switch to a new input method subtype of the current input method.
 * Requires {@link android.Manifest.permission#WRITE_SECURE_SETTINGS}
 * @param subtype A new input method subtype to switch.
 * @return true if the current subtype was successfully switched. When the specified subtype is
 * null, this method returns false.
 */

public boolean setCurrentInputMethodSubtype(android.view.inputmethod.InputMethodSubtype subtype) { throw new RuntimeException("Stub!"); }

/**
 * Returns a map of all shortcut input method info and their subtypes.
 */

public java.util.Map<android.view.inputmethod.InputMethodInfo, java.util.List<android.view.inputmethod.InputMethodSubtype>> getShortcutInputMethodsAndSubtypes() { throw new RuntimeException("Stub!"); }

/**
 * Force switch to the last used input method and subtype. If the last input method didn't have
 * any subtypes, the framework will simply switch to the last input method with no subtype
 * specified.
 * @param imeToken Supplies the identifying token given to an input method when it was started,
 * which allows it to perform this operation on itself.
 * @return true if the current input method and subtype was successfully switched to the last
 * used input method and subtype.
 * @deprecated Use {@link InputMethodService#switchToPreviousInputMethod()} instead. This method
 * was intended for IME developers who should be accessing APIs through the service. APIs in
 * this class are intended for app developers interacting with the IME.
 */

@Deprecated public boolean switchToLastInputMethod(android.os.IBinder imeToken) { throw new RuntimeException("Stub!"); }

/**
 * Force switch to the next input method and subtype. If there is no IME enabled except
 * current IME and subtype, do nothing.
 * @param imeToken Supplies the identifying token given to an input method when it was started,
 * which allows it to perform this operation on itself.
 * @param onlyCurrentIme if true, the framework will find the next subtype which
 * belongs to the current IME
 * @return true if the current input method and subtype was successfully switched to the next
 * input method and subtype.
 * @deprecated Use {@link InputMethodService#switchToNextInputMethod(boolean)} instead. This
 * method was intended for IME developers who should be accessing APIs through the service.
 * APIs in this class are intended for app developers interacting with the IME.
 */

@Deprecated public boolean switchToNextInputMethod(android.os.IBinder imeToken, boolean onlyCurrentIme) { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the current IME needs to offer the users ways to switch to a next input
 * method (e.g.&nbsp;a globe key.).
 * When an IME sets supportsSwitchingToNextInputMethod and this method returns true,
 * the IME has to offer ways to to invoke {@link #switchToNextInputMethod} accordingly.
 * <p> Note that the system determines the most appropriate next input method
 * and subtype in order to provide the consistent user experience in switching
 * between IMEs and subtypes.
 * @param imeToken Supplies the identifying token given to an input method when it was started,
 * which allows it to perform this operation on itself.
 * @deprecated Use {@link InputMethodService#shouldOfferSwitchingToNextInputMethod()}
 * instead. This method was intended for IME developers who should be accessing APIs through
 * the service. APIs in this class are intended for app developers interacting with the IME.
 */

@Deprecated public boolean shouldOfferSwitchingToNextInputMethod(android.os.IBinder imeToken) { throw new RuntimeException("Stub!"); }

/**
 * Set additional input method subtypes. Only a process which shares the same uid with the IME
 * can add additional input method subtypes to the IME.
 * Please note that a subtype's status is stored in the system.
 * For example, enabled subtypes are remembered by the framework even after they are removed
 * by using this method. If you re-add the same subtypes again,
 * they will just get enabled. If you want to avoid such conflicts, for instance, you may
 * want to create a "different" new subtype even with the same locale and mode,
 * by changing its extra value. The different subtype won't get affected by the stored past
 * status. (You may want to take a look at {@link InputMethodSubtype#hashCode()} to refer
 * to the current implementation.)
 *
 * <p>NOTE: If the same subtype exists in both the manifest XML file and additional subtypes
 * specified by {@code subtypes}, those multiple instances are automatically merged into one
 * instance.</p>
 *
 * <p>CAVEAT: In API Level 23 and prior, the system may do nothing if an empty
 * {@link InputMethodSubtype} is specified in {@code subtypes}, which prevents you from removing
 * the last one entry of additional subtypes. If your IME statically defines one or more
 * subtypes in the manifest XML file, you may be able to work around this limitation by
 * specifying one of those statically defined subtypes in {@code subtypes}.</p>
 *
 * @param imiId Id of InputMethodInfo which additional input method subtypes will be added to.
 * @param subtypes subtypes will be added as additional subtypes of the current input method.
 */

public void setAdditionalInputMethodSubtypes(java.lang.String imiId, android.view.inputmethod.InputMethodSubtype[] subtypes) { throw new RuntimeException("Stub!"); }

public android.view.inputmethod.InputMethodSubtype getLastInputMethodSubtype() { throw new RuntimeException("Stub!"); }

/**
 * Flag for {@link #hideSoftInputFromWindow} and {@link InputMethodService#requestHideSelf(int)}
 * to indicate that the soft input window should only be hidden if it was not explicitly shown
 * by the user.
 */

public static final int HIDE_IMPLICIT_ONLY = 1; // 0x1

/**
 * Flag for {@link #hideSoftInputFromWindow} and {@link InputMethodService#requestShowSelf(int)}
 * to indicate that the soft input window should normally be hidden, unless it was originally
 * shown with {@link #SHOW_FORCED}.
 */

public static final int HIDE_NOT_ALWAYS = 2; // 0x2

/**
 * Flag for the {@link ResultReceiver} result code from
 * {@link #showSoftInput(View, int, ResultReceiver)} and
 * {@link #hideSoftInputFromWindow(IBinder, int, ResultReceiver)}: the
 * state of the soft input window changed from shown to hidden.
 */

public static final int RESULT_HIDDEN = 3; // 0x3

/**
 * Flag for the {@link ResultReceiver} result code from
 * {@link #showSoftInput(View, int, ResultReceiver)} and
 * {@link #hideSoftInputFromWindow(IBinder, int, ResultReceiver)}: the
 * state of the soft input window changed from hidden to shown.
 */

public static final int RESULT_SHOWN = 2; // 0x2

/**
 * Flag for the {@link ResultReceiver} result code from
 * {@link #showSoftInput(View, int, ResultReceiver)} and
 * {@link #hideSoftInputFromWindow(IBinder, int, ResultReceiver)}: the
 * state of the soft input window was unchanged and remains hidden.
 */

public static final int RESULT_UNCHANGED_HIDDEN = 1; // 0x1

/**
 * Flag for the {@link ResultReceiver} result code from
 * {@link #showSoftInput(View, int, ResultReceiver)} and
 * {@link #hideSoftInputFromWindow(IBinder, int, ResultReceiver)}: the
 * state of the soft input window was unchanged and remains shown.
 */

public static final int RESULT_UNCHANGED_SHOWN = 0; // 0x0

/**
 * Flag for {@link #showSoftInput} to indicate that the user has forced
 * the input method open (such as by long-pressing menu) so it should
 * not be closed until they explicitly do so.
 */

public static final int SHOW_FORCED = 2; // 0x2

/**
 * Flag for {@link #showSoftInput} to indicate that this is an implicit
 * request to show the input window, not as the result of a direct request
 * by the user.  The window may not be shown in this case.
 */

public static final int SHOW_IMPLICIT = 1; // 0x1
}

