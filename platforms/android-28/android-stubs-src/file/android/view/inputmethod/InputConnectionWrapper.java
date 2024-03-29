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


package android.view.inputmethod;


/**
 * <p>Wrapper class for proxying calls to another InputConnection.  Subclass and have fun!
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class InputConnectionWrapper implements android.view.inputmethod.InputConnection {

/**
 * Initializes a wrapper.
 *
 * <p><b>Caveat:</b> Although the system can accept {@code (InputConnection) null} in some
 * places, you cannot emulate such a behavior by non-null {@link InputConnectionWrapper} that
 * has {@code null} in {@code target}.</p>
 * @param target the {@link InputConnection} to be proxied.
 * @param mutable set {@code true} to protect this object from being reconfigured to target
 * another {@link InputConnection}.  Note that this is ignored while the target is {@code null}.
 */

public InputConnectionWrapper(android.view.inputmethod.InputConnection target, boolean mutable) { throw new RuntimeException("Stub!"); }

/**
 * Change the target of the input connection.
 *
 * <p><b>Caveat:</b> Although the system can accept {@code (InputConnection) null} in some
 * places, you cannot emulate such a behavior by non-null {@link InputConnectionWrapper} that
 * has {@code null} in {@code target}.</p>
 * @param target the {@link InputConnection} to be proxied.
 * @throws SecurityException when this wrapper has non-null target and is immutable.
 */

public void setTarget(android.view.inputmethod.InputConnection target) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public java.lang.CharSequence getTextBeforeCursor(int n, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public java.lang.CharSequence getTextAfterCursor(int n, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public java.lang.CharSequence getSelectedText(int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public int getCursorCapsMode(int reqModes) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public android.view.inputmethod.ExtractedText getExtractedText(android.view.inputmethod.ExtractedTextRequest request, int flags) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean deleteSurroundingText(int beforeLength, int afterLength) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean setComposingText(java.lang.CharSequence text, int newCursorPosition) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean setComposingRegion(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean finishComposingText() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean commitText(java.lang.CharSequence text, int newCursorPosition) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean commitCompletion(android.view.inputmethod.CompletionInfo text) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean commitCorrection(android.view.inputmethod.CorrectionInfo correctionInfo) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean setSelection(int start, int end) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean performEditorAction(int editorAction) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean performContextMenuAction(int id) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean beginBatchEdit() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean endBatchEdit() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean sendKeyEvent(android.view.KeyEvent event) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean clearMetaKeyStates(int states) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean reportFullscreenMode(boolean enabled) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean performPrivateCommand(java.lang.String action, android.os.Bundle data) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean requestCursorUpdates(int cursorUpdateMode) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public android.os.Handler getHandler() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public void closeConnection() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException if the target is {@code null}.
 */

public boolean commitContent(android.view.inputmethod.InputContentInfo inputContentInfo, int flags, android.os.Bundle opts) { throw new RuntimeException("Stub!"); }
}

