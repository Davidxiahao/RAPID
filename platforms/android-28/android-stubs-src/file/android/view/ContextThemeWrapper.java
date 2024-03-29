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
import android.content.res.Configuration;
import android.content.res.Resources;

/**
 * A context wrapper that allows you to modify or replace the theme of the
 * wrapped context.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ContextThemeWrapper extends android.content.ContextWrapper {

/**
 * Creates a new context wrapper with no theme and no base context.
 * <p class="note">
 * <strong>Note:</strong> A base context <strong>must</strong> be attached
 * using {@link #attachBaseContext(Context)} before calling any other
 * method on the newly constructed context wrapper.
 */

public ContextThemeWrapper() { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new context wrapper with the specified theme.
 * <p>
 * The specified theme will be applied on top of the base context's theme.
 * Any attributes not explicitly defined in the theme identified by
 * <var>themeResId</var> will retain their original values.
 *
 * @param base the base context
 * @param themeResId the resource ID of the theme to be applied on top of
 *                   the base context's theme
 */

public ContextThemeWrapper(android.content.Context base, int themeResId) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a new context wrapper with the specified theme.
 * <p>
 * Unlike {@link #ContextThemeWrapper(Context, int)}, the theme passed to
 * this constructor will completely replace the base context's theme.
 *
 * @param base the base context
 * @param theme the theme against which resources should be inflated
 */

public ContextThemeWrapper(android.content.Context base, android.content.res.Resources.Theme theme) { super(null); throw new RuntimeException("Stub!"); }

protected void attachBaseContext(android.content.Context newBase) { throw new RuntimeException("Stub!"); }

/**
 * Call to set an "override configuration" on this context -- this is
 * a configuration that replies one or more values of the standard
 * configuration that is applied to the context.  See
 * {@link Context#createConfigurationContext(Configuration)} for more
 * information.
 *
 * <p>This method can only be called once, and must be called before any
 * calls to {@link #getResources()} or {@link #getAssets()} are made.
 */

public void applyOverrideConfiguration(android.content.res.Configuration overrideConfiguration) { throw new RuntimeException("Stub!"); }

public android.content.res.AssetManager getAssets() { throw new RuntimeException("Stub!"); }

public android.content.res.Resources getResources() { throw new RuntimeException("Stub!"); }

public void setTheme(int resid) { throw new RuntimeException("Stub!"); }

public android.content.res.Resources.Theme getTheme() { throw new RuntimeException("Stub!"); }

public java.lang.Object getSystemService(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Called by {@link #setTheme} and {@link #getTheme} to apply a theme
 * resource to the current Theme object. May be overridden to change the
 * default (simple) behavior. This method will not be called in multiple
 * threads simultaneously.
 *
 * @param theme the theme being modified
 * @param resId the style resource being applied to <var>theme</var>
 * @param first {@code true} if this is the first time a style is being
 *              applied to <var>theme</var>
 */

protected void onApplyThemeResource(android.content.res.Resources.Theme theme, int resId, boolean first) { throw new RuntimeException("Stub!"); }
}

