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


/**
 * Abstract class for filtering login-related text (user names and passwords)
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class LoginFilter implements android.text.InputFilter {

/**
 * Default constructor for LoginFilter doesn't append invalid characters.
 */

LoginFilter() { throw new RuntimeException("Stub!"); }

/**
 * This method is called when the buffer is going to replace the
 * range <code>dstart &hellip; dend</code> of <code>dest</code>
 * with the new text from the range <code>start &hellip; end</code>
 * of <code>source</code>.  Returns the CharSequence that we want
 * placed there instead, including an empty string
 * if appropriate, or <code>null</code> to accept the original
 * replacement.  Be careful to not to reject 0-length replacements,
 * as this is what happens when you delete text.
 */

public java.lang.CharSequence filter(java.lang.CharSequence source, int start, int end, android.text.Spanned dest, int dstart, int dend) { throw new RuntimeException("Stub!"); }

/**
 * Called when we start processing filter.
 */

public void onStart() { throw new RuntimeException("Stub!"); }

/**
 * Called whenever we encounter an invalid character.
 * @param c the invalid character
 */

public void onInvalidCharacter(char c) { throw new RuntimeException("Stub!"); }

/**
 * Called when we're done processing filter
 */

public void onStop() { throw new RuntimeException("Stub!"); }

/**
 * Returns whether or not we allow character c.
 * Subclasses must override this method.
 */

public abstract boolean isAllowed(char c);
/**
 * This filter is compatible with GMail passwords which restricts characters to
 * the Latin-1 (ISO8859-1) char set.
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class PasswordFilterGMail extends android.text.LoginFilter {

public PasswordFilterGMail() { throw new RuntimeException("Stub!"); }

public PasswordFilterGMail(boolean appendInvalid) { throw new RuntimeException("Stub!"); }

public boolean isAllowed(char c) { throw new RuntimeException("Stub!"); }
}

/**
 * This filter rejects characters in the user name that are not compatible with GMail
 * account creation. It prevents the user from entering user names with characters other than
 * [a-zA-Z0-9.].
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class UsernameFilterGMail extends android.text.LoginFilter {

public UsernameFilterGMail() { throw new RuntimeException("Stub!"); }

public UsernameFilterGMail(boolean appendInvalid) { throw new RuntimeException("Stub!"); }

public boolean isAllowed(char c) { throw new RuntimeException("Stub!"); }
}

/**
 * This filter rejects characters in the user name that are not compatible with Google login.
 * It is slightly less restrictive than the above filter in that it allows [a-zA-Z0-9._-+].
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class UsernameFilterGeneric extends android.text.LoginFilter {

public UsernameFilterGeneric() { throw new RuntimeException("Stub!"); }

public UsernameFilterGeneric(boolean appendInvalid) { throw new RuntimeException("Stub!"); }

public boolean isAllowed(char c) { throw new RuntimeException("Stub!"); }
}

}

