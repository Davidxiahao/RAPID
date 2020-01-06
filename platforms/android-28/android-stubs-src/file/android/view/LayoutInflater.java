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


package android.view;

import android.content.Context;
import org.xmlpull.v1.XmlPullParser;
import android.util.Xml;
import android.util.AttributeSet;

/**
 * Instantiates a layout XML file into its corresponding {@link android.view.View}
 * objects. It is never used directly. Instead, use
 * {@link android.app.Activity#getLayoutInflater()} or
 * {@link Context#getSystemService} to retrieve a standard LayoutInflater instance
 * that is already hooked up to the current context and correctly configured
 * for the device you are running on.
 *
 * <p>
 * To create a new LayoutInflater with an additional {@link Factory} for your
 * own views, you can use {@link #cloneInContext} to clone an existing
 * ViewFactory, and then call {@link #setFactory} on it to include your
 * Factory.
 *
 * <p>
 * For performance reasons, view inflation relies heavily on pre-processing of
 * XML files that is done at build time. Therefore, it is not currently possible
 * to use LayoutInflater with an XmlPullParser over a plain XML file at runtime;
 * it only works with an XmlPullParser returned from a compiled resource
 * (R.<em>something</em> file.)
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class LayoutInflater {

/**
 * Create a new LayoutInflater instance associated with a particular Context.
 * Applications will almost always want to use
 * {@link Context#getSystemService Context.getSystemService()} to retrieve
 * the standard {@link Context#LAYOUT_INFLATER_SERVICE Context.INFLATER_SERVICE}.
 *
 * @param context The Context in which this LayoutInflater will create its
 * Views; most importantly, this supplies the theme from which the default
 * values for their attributes are retrieved.
 */

protected LayoutInflater(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Create a new LayoutInflater instance that is a copy of an existing
 * LayoutInflater, optionally with its Context changed.  For use in
 * implementing {@link #cloneInContext}.
 *
 * @param original The original LayoutInflater to copy.
 * @param newContext The new Context to use.
 */

protected LayoutInflater(android.view.LayoutInflater original, android.content.Context newContext) { throw new RuntimeException("Stub!"); }

/**
 * Obtains the LayoutInflater from the given context.
 */

public static android.view.LayoutInflater from(android.content.Context context) { throw new RuntimeException("Stub!"); }

/**
 * Create a copy of the existing LayoutInflater object, with the copy
 * pointing to a different Context than the original.  This is used by
 * {@link ContextThemeWrapper} to create a new LayoutInflater to go along
 * with the new Context theme.
 *
 * @param newContext The new Context to associate with the new LayoutInflater.
 * May be the same as the original Context if desired.
 *
 * @return Returns a brand spanking new LayoutInflater object associated with
 * the given Context.
 */

public abstract android.view.LayoutInflater cloneInContext(android.content.Context newContext);

/**
 * Return the context we are running in, for access to resources, class
 * loader, etc.
 */

public android.content.Context getContext() { throw new RuntimeException("Stub!"); }

/**
 * Return the current {@link Factory} (or null). This is called on each element
 * name. If the factory returns a View, add that to the hierarchy. If it
 * returns null, proceed to call onCreateView(name).
 */

public final android.view.LayoutInflater.Factory getFactory() { throw new RuntimeException("Stub!"); }

/**
 * Return the current {@link Factory2}.  Returns null if no factory is set
 * or the set factory does not implement the {@link Factory2} interface.
 * This is called on each element
 * name. If the factory returns a View, add that to the hierarchy. If it
 * returns null, proceed to call onCreateView(name).
 */

public final android.view.LayoutInflater.Factory2 getFactory2() { throw new RuntimeException("Stub!"); }

/**
 * Attach a custom Factory interface for creating views while using
 * this LayoutInflater.  This must not be null, and can only be set once;
 * after setting, you can not change the factory.  This is
 * called on each element name as the xml is parsed. If the factory returns
 * a View, that is added to the hierarchy. If it returns null, the next
 * factory default {@link #onCreateView} method is called.
 *
 * <p>If you have an existing
 * LayoutInflater and want to add your own factory to it, use
 * {@link #cloneInContext} to clone the existing instance and then you
 * can use this function (once) on the returned new instance.  This will
 * merge your own factory with whatever factory the original instance is
 * using.
 */

public void setFactory(android.view.LayoutInflater.Factory factory) { throw new RuntimeException("Stub!"); }

/**
 * Like {@link #setFactory}, but allows you to set a {@link Factory2}
 * interface.
 */

public void setFactory2(android.view.LayoutInflater.Factory2 factory) { throw new RuntimeException("Stub!"); }

/**
 * @return The {@link Filter} currently used by this LayoutInflater to restrict the set of Views
 * that are allowed to be inflated.
 */

public android.view.LayoutInflater.Filter getFilter() { throw new RuntimeException("Stub!"); }

/**
 * Sets the {@link Filter} to by this LayoutInflater. If a view is attempted to be inflated
 * which is not allowed by the {@link Filter}, the {@link #inflate(int, ViewGroup)} call will
 * throw an {@link InflateException}. This filter will replace any previous filter set on this
 * LayoutInflater.
 *
 * @param filter The Filter which restricts the set of Views that are allowed to be inflated.
 *        This filter will replace any previous filter set on this LayoutInflater.
 */

public void setFilter(android.view.LayoutInflater.Filter filter) { throw new RuntimeException("Stub!"); }

/**
 * Inflate a new view hierarchy from the specified xml resource. Throws
 * {@link InflateException} if there is an error.
 *
 * @param resource ID for an XML layout resource to load (e.g.,
 *        <code>R.layout.main_page</code>)
 * @param root Optional view to be the parent of the generated hierarchy.
 * This value may be {@code null}.
 * @return The root View of the inflated hierarchy. If root was supplied,
 *         this is the root View; otherwise it is the root of the inflated
 *         XML file.
 */

public android.view.View inflate(int resource, @androidx.annotation.RecentlyNullable android.view.ViewGroup root) { throw new RuntimeException("Stub!"); }

/**
 * Inflate a new view hierarchy from the specified xml node. Throws
 * {@link InflateException} if there is an error. *
 * <p>
 * <em><strong>Important</strong></em>&nbsp;&nbsp;&nbsp;For performance
 * reasons, view inflation relies heavily on pre-processing of XML files
 * that is done at build time. Therefore, it is not currently possible to
 * use LayoutInflater with an XmlPullParser over a plain XML file at runtime.
 *
 * @param parser XML dom node containing the description of the view
 *        hierarchy.
 * @param root Optional view to be the parent of the generated hierarchy.
 * This value may be {@code null}.
 * @return The root View of the inflated hierarchy. If root was supplied,
 *         this is the root View; otherwise it is the root of the inflated
 *         XML file.
 */

public android.view.View inflate(org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.RecentlyNullable android.view.ViewGroup root) { throw new RuntimeException("Stub!"); }

/**
 * Inflate a new view hierarchy from the specified xml resource. Throws
 * {@link InflateException} if there is an error.
 *
 * @param resource ID for an XML layout resource to load (e.g.,
 *        <code>R.layout.main_page</code>)
 * @param root Optional view to be the parent of the generated hierarchy (if
 *        <em>attachToRoot</em> is true), or else simply an object that
 *        provides a set of LayoutParams values for root of the returned
 *        hierarchy (if <em>attachToRoot</em> is false.)
 * This value may be {@code null}.
 * @param attachToRoot Whether the inflated hierarchy should be attached to
 *        the root parameter? If false, root is only used to create the
 *        correct subclass of LayoutParams for the root view in the XML.
 * @return The root View of the inflated hierarchy. If root was supplied and
 *         attachToRoot is true, this is root; otherwise it is the root of
 *         the inflated XML file.
 */

public android.view.View inflate(int resource, @androidx.annotation.RecentlyNullable android.view.ViewGroup root, boolean attachToRoot) { throw new RuntimeException("Stub!"); }

/**
 * Inflate a new view hierarchy from the specified XML node. Throws
 * {@link InflateException} if there is an error.
 * <p>
 * <em><strong>Important</strong></em>&nbsp;&nbsp;&nbsp;For performance
 * reasons, view inflation relies heavily on pre-processing of XML files
 * that is done at build time. Therefore, it is not currently possible to
 * use LayoutInflater with an XmlPullParser over a plain XML file at runtime.
 *
 * @param parser XML dom node containing the description of the view
 *        hierarchy.
 * @param root Optional view to be the parent of the generated hierarchy (if
 *        <em>attachToRoot</em> is true), or else simply an object that
 *        provides a set of LayoutParams values for root of the returned
 *        hierarchy (if <em>attachToRoot</em> is false.)
 * This value may be {@code null}.
 * @param attachToRoot Whether the inflated hierarchy should be attached to
 *        the root parameter? If false, root is only used to create the
 *        correct subclass of LayoutParams for the root view in the XML.
 * @return The root View of the inflated hierarchy. If root was supplied and
 *         attachToRoot is true, this is root; otherwise it is the root of
 *         the inflated XML file.
 */

public android.view.View inflate(org.xmlpull.v1.XmlPullParser parser, @androidx.annotation.RecentlyNullable android.view.ViewGroup root, boolean attachToRoot) { throw new RuntimeException("Stub!"); }

/**
 * Low-level function for instantiating a view by name. This attempts to
 * instantiate a view class of the given <var>name</var> found in this
 * LayoutInflater's ClassLoader.
 *
 * <p>
 * There are two things that can happen in an error case: either the
 * exception describing the error will be thrown, or a null will be
 * returned. You must deal with both possibilities -- the former will happen
 * the first time createView() is called for a class of a particular name,
 * the latter every time there-after for that class name.
 *
 * @param name The full name of the class to be instantiated.
 * @param attrs The XML attributes supplied for this instance.
 *
 * @return View The newly instantiated view, or null.
 */

public final android.view.View createView(java.lang.String name, java.lang.String prefix, android.util.AttributeSet attrs) throws java.lang.ClassNotFoundException, android.view.InflateException { throw new RuntimeException("Stub!"); }

/**
 * This routine is responsible for creating the correct subclass of View
 * given the xml element name. Override it to handle custom view objects. If
 * you override this in your subclass be sure to call through to
 * super.onCreateView(name) for names you do not recognize.
 *
 * @param name The fully qualified class name of the View to be create.
 * @param attrs An AttributeSet of attributes to apply to the View.
 *
 * @return View The View created.
 */

protected android.view.View onCreateView(java.lang.String name, android.util.AttributeSet attrs) throws java.lang.ClassNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Version of {@link #onCreateView(String, AttributeSet)} that also
 * takes the future parent of the view being constructed.  The default
 * implementation simply calls {@link #onCreateView(String, AttributeSet)}.
 *
 * @param parent The future parent of the returned view.  <em>Note that
 * this may be null.</em>
 * @param name The fully qualified class name of the View to be create.
 * @param attrs An AttributeSet of attributes to apply to the View.
 *
 * @return View The View created.
 */

protected android.view.View onCreateView(android.view.View parent, java.lang.String name, android.util.AttributeSet attrs) throws java.lang.ClassNotFoundException { throw new RuntimeException("Stub!"); }
@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Factory {

/**
 * Hook you can supply that is called when inflating from a LayoutInflater.
 * You can use this to customize the tag names available in your XML
 * layout files.
 *
 * <p>
 * Note that it is good practice to prefix these custom names with your
 * package (i.e., com.coolcompany.apps) to avoid conflicts with system
 * names.
 *
 * @param name Tag name to be inflated.
 * @param context The context the view is being created in.
 * @param attrs Inflation attributes as specified in XML file.
 *
 * @return View Newly created view. Return null for the default
 *         behavior.
 */

public android.view.View onCreateView(java.lang.String name, android.content.Context context, android.util.AttributeSet attrs);
}

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Factory2 extends android.view.LayoutInflater.Factory {

/**
 * Version of {@link #onCreateView(String, Context, AttributeSet)}
 * that also supplies the parent that the view created view will be
 * placed in.
 *
 * @param parent The parent that the created view will be placed
 * in; <em>note that this may be null</em>.
 * @param name Tag name to be inflated.
 * @param context The context the view is being created in.
 * @param attrs Inflation attributes as specified in XML file.
 *
 * @return View Newly created view. Return null for the default
 *         behavior.
 */

public android.view.View onCreateView(android.view.View parent, java.lang.String name, android.content.Context context, android.util.AttributeSet attrs);
}

/**
 * Hook to allow clients of the LayoutInflater to restrict the set of Views that are allowed
 * to be inflated.
 *
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static interface Filter {

/**
 * Hook to allow clients of the LayoutInflater to restrict the set of Views
 * that are allowed to be inflated.
 *
 * @param clazz The class object for the View that is about to be inflated
 *
 * @return True if this class is allowed to be inflated, or false otherwise
 */

public boolean onLoadClass(java.lang.Class clazz);
}

}

