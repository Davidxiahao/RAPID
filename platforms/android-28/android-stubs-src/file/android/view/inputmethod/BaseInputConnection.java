/*
 * Copyright (C) 2008 The Android Open Source Project
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

import android.text.Editable;
import android.text.method.MetaKeyKeyListener;
import android.text.TextUtils;

/**
 * Base class for implementors of the InputConnection interface, taking care
 * of most of the common behavior for providing a connection to an Editable.
 * Implementors of this class will want to be sure to implement
 * {@link #getEditable} to provide access to their own editable object, and
 * to refer to the documentation in {@link InputConnection}.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class BaseInputConnection implements android.view.inputmethod.InputConnection {

public BaseInputConnection(android.view.View targetView, boolean fullEditor) { throw new RuntimeException("Stub!"); }

public static final void removeComposingSpans(android.text.Spannable text) { throw new RuntimeException("Stub!"); }

public static void setComposingSpans(android.text.Spannable text) { throw new RuntimeException("Stub!"); }

public static int getComposingSpanStart(android.text.Spannable text) { throw new RuntimeException("Stub!"); }

public static int getComposingSpanEnd(android.text.Spannable text) { throw new RuntimeException("Stub!"); }

/**
 * Return the target of edit operations.  The default implementation
 * returns its own fake editable that is just used for composing text;
 * subclasses that are real text editors should override this and
 * supply their own.
 */

public android.text.Editable getEditable() { throw new RuntimeException("Stub!"); }

/**
 * Default implementation does nothing.
 */

public boolean beginBatchEdit() { throw new RuntimeException("Stub!"); }

/**
 * Default implementation does nothing.
 */

public boolean endBatchEdit() { throw new RuntimeException("Stub!"); }

/**
 * Default implementation calls {@link #finishComposingText()}.

 * If you override this method you <em>must</em> call through to the
 *  *            superclass implementation.
 */

public void closeConnection() { throw new RuntimeException("Stub!"); }

/**
 * Default implementation uses
 * {@link MetaKeyKeyListener#clearMetaKeyState(long, int)
 * MetaKeyKeyListener.clearMetaKeyState(long, int)} to clear the state.
 */

public boolean clearMetaKeyStates(int states) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation does nothing and returns false.
 */

public boolean commitCompletion(android.view.inputmethod.CompletionInfo text) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation does nothing and returns false.
 */

public boolean commitCorrection(android.view.inputmethod.CorrectionInfo correctionInfo) { throw new RuntimeException("Stub!"); }

/**
 * Default implementation replaces any existing composing text with
 * the given text.  In addition, only if dummy mode, a key event is
 * sent for the new text and the current editable buffer cleared.
 */

public boolean commitText(java.lang.CharSequence text, int newCursorPosition) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation performs the deletion around the current selection position of the
 * editable text.
 *
 * @param beforeLength The number of characters before the cursor to be deleted, in code unit.
 *        If this is greater than the number of existing characters between the beginning of the
 *        text and the cursor, then this method does not fail but deletes all the characters in
 *        that range.
 * @param afterLength The number of characters after the cursor to be deleted, in code unit.
 *        If this is greater than the number of existing characters between the cursor and
 *        the end of the text, then this method does not fail but deletes all the characters in
 *        that range.
 */

public boolean deleteSurroundingText(int beforeLength, int afterLength) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation performs the deletion around the current selection position of the
 * editable text.
 * @param beforeLength The number of characters before the cursor to be deleted, in code points.
 *        If this is greater than the number of existing characters between the beginning of the
 *        text and the cursor, then this method does not fail but deletes all the characters in
 *        that range.
 * @param afterLength The number of characters after the cursor to be deleted, in code points.
 *        If this is greater than the number of existing characters between the cursor and
 *        the end of the text, then this method does not fail but deletes all the characters in
 *        that range.
 */

public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation removes the composing state from the
 * current editable text.  In addition, only if dummy mode, a key event is
 * sent for the new text and the current editable buffer cleared.
 */

public boolean finishComposingText() { throw new RuntimeException("Stub!"); }

/**
 * The default implementation uses TextUtils.getCapsMode to get the
 * cursor caps mode for the current selection position in the editable
 * text, unless in dummy mode in which case 0 is always returned.
 */

public int getCursorCapsMode(int reqModes) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation always returns null.
 */

public android.view.inputmethod.ExtractedText getExtractedText(android.view.inputmethod.ExtractedTextRequest request, int flags) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation returns the given amount of text from the
 * current cursor position in the buffer.
 */

public java.lang.CharSequence getTextBeforeCursor(int length, int flags) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation returns the text currently selected, or null if none is
 * selected.
 */

public java.lang.CharSequence getSelectedText(int flags) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation returns the given amount of text from the
 * current cursor position in the buffer.
 */

public java.lang.CharSequence getTextAfterCursor(int length, int flags) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation turns this into the enter key.
 */

public boolean performEditorAction(int actionCode) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation does nothing.
 */

public boolean performContextMenuAction(int id) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation does nothing.
 */

public boolean performPrivateCommand(java.lang.String action, android.os.Bundle data) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation does nothing.
 */

public boolean requestCursorUpdates(int cursorUpdateMode) { throw new RuntimeException("Stub!"); }

public android.os.Handler getHandler() { throw new RuntimeException("Stub!"); }

/**
 * The default implementation places the given text into the editable,
 * replacing any existing composing text.  The new text is marked as
 * in a composing state with the composing style.
 */

public boolean setComposingText(java.lang.CharSequence text, int newCursorPosition) { throw new RuntimeException("Stub!"); }

public boolean setComposingRegion(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation changes the selection position in the
 * current editable text.
 */

public boolean setSelection(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * Provides standard implementation for sending a key event to the window
 * attached to the input connection's view.
 */

public boolean sendKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * Updates InputMethodManager with the current fullscreen mode.
 */

public boolean reportFullscreenMode(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * The default implementation does nothing.
 */

public boolean commitContent(android.view.inputmethod.InputContentInfo inputContentInfo, int flags, android.os.Bundle opts) { throw new RuntimeException("Stub!"); }
}

