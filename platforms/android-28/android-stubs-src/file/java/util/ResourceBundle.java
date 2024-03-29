/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * (C) Copyright Taligent, Inc. 1996, 1997 - All Rights Reserved
 * (C) Copyright IBM Corp. 1996 - 1999 - All Rights Reserved
 *
 * The original version of this source code and documentation
 * is copyrighted and owned by Taligent, Inc., a wholly-owned
 * subsidiary of IBM. These materials are provided under terms
 * of a License Agreement between Taligent and Sun. This technology
 * is protected by multiple US and International patents.
 *
 * This notice and attribution to Taligent may not be removed.
 * Taligent is a registered trademark of Taligent, Inc.
 *
 */


package java.util;

import java.util.concurrent.ConcurrentMap;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * Resource bundles contain locale-specific objects.  When your program needs a
 * locale-specific resource, a <code>String</code> for example, your program can
 * load it from the resource bundle that is appropriate for the current user's
 * locale. In this way, you can write program code that is largely independent
 * of the user's locale isolating most, if not all, of the locale-specific
 * information in resource bundles.
 *
 * <p>
 * This allows you to write programs that can:
 * <UL>
 * <LI> be easily localized, or translated, into different languages
 * <LI> handle multiple locales at once
 * <LI> be easily modified later to support even more locales
 * </UL>
 *
 * <P>
 * Resource bundles belong to families whose members share a common base
 * name, but whose names also have additional components that identify
 * their locales. For example, the base name of a family of resource
 * bundles might be "MyResources". The family should have a default
 * resource bundle which simply has the same name as its family -
 * "MyResources" - and will be used as the bundle of last resort if a
 * specific locale is not supported. The family can then provide as
 * many locale-specific members as needed, for example a German one
 * named "MyResources_de".
 *
 * <P>
 * Each resource bundle in a family contains the same items, but the items have
 * been translated for the locale represented by that resource bundle.
 * For example, both "MyResources" and "MyResources_de" may have a
 * <code>String</code> that's used on a button for canceling operations.
 * In "MyResources" the <code>String</code> may contain "Cancel" and in
 * "MyResources_de" it may contain "Abbrechen".
 *
 * <P>
 * If there are different resources for different countries, you
 * can make specializations: for example, "MyResources_de_CH" contains objects for
 * the German language (de) in Switzerland (CH). If you want to only
 * modify some of the resources
 * in the specialization, you can do so.
 *
 * <P>
 * When your program needs a locale-specific object, it loads
 * the <code>ResourceBundle</code> class using the
 * {@link #getBundle(java.lang.String, java.util.Locale) getBundle}
 * method:
 * <blockquote>
 * <pre>
 * ResourceBundle myResources =
 *      ResourceBundle.getBundle("MyResources", currentLocale);
 * </pre>
 * </blockquote>
 *
 * <P>
 * Resource bundles contain key/value pairs. The keys uniquely
 * identify a locale-specific object in the bundle. Here's an
 * example of a <code>ListResourceBundle</code> that contains
 * two key/value pairs:
 * <blockquote>
 * <pre>
 * public class MyResources extends ListResourceBundle {
 *     protected Object[][] getContents() {
 *         return new Object[][] {
 *             // LOCALIZE THE SECOND STRING OF EACH ARRAY (e.g., "OK")
 *             {"OkKey", "OK"},
 *             {"CancelKey", "Cancel"},
 *             // END OF MATERIAL TO LOCALIZE
 *        };
 *     }
 * }
 * </pre>
 * </blockquote>
 * Keys are always <code>String</code>s.
 * In this example, the keys are "OkKey" and "CancelKey".
 * In the above example, the values
 * are also <code>String</code>s--"OK" and "Cancel"--but
 * they don't have to be. The values can be any type of object.
 *
 * <P>
 * You retrieve an object from resource bundle using the appropriate
 * getter method. Because "OkKey" and "CancelKey"
 * are both strings, you would use <code>getString</code> to retrieve them:
 * <blockquote>
 * <pre>
 * button1 = new Button(myResources.getString("OkKey"));
 * button2 = new Button(myResources.getString("CancelKey"));
 * </pre>
 * </blockquote>
 * The getter methods all require the key as an argument and return
 * the object if found. If the object is not found, the getter method
 * throws a <code>MissingResourceException</code>.
 *
 * <P>
 * Besides <code>getString</code>, <code>ResourceBundle</code> also provides
 * a method for getting string arrays, <code>getStringArray</code>,
 * as well as a generic <code>getObject</code> method for any other
 * type of object. When using <code>getObject</code>, you'll
 * have to cast the result to the appropriate type. For example:
 * <blockquote>
 * <pre>
 * int[] myIntegers = (int[]) myResources.getObject("intList");
 * </pre>
 * </blockquote>
 *
 * <P>
 * The Java Platform provides two subclasses of <code>ResourceBundle</code>,
 * <code>ListResourceBundle</code> and <code>PropertyResourceBundle</code>,
 * that provide a fairly simple way to create resources.
 * As you saw briefly in a previous example, <code>ListResourceBundle</code>
 * manages its resource as a list of key/value pairs.
 * <code>PropertyResourceBundle</code> uses a properties file to manage
 * its resources.
 *
 * <p>
 * If <code>ListResourceBundle</code> or <code>PropertyResourceBundle</code>
 * do not suit your needs, you can write your own <code>ResourceBundle</code>
 * subclass.  Your subclasses must override two methods: <code>handleGetObject</code>
 * and <code>getKeys()</code>.
 *
 * <p>
 * The implementation of a {@code ResourceBundle} subclass must be thread-safe
 * if it's simultaneously used by multiple threads. The default implementations
 * of the non-abstract methods in this class, and the methods in the direct
 * known concrete subclasses {@code ListResourceBundle} and
 * {@code PropertyResourceBundle} are thread-safe.
 *
 * <h3>ResourceBundle.Control</h3>
 *
 * The {@link ResourceBundle.Control} class provides information necessary
 * to perform the bundle loading process by the <code>getBundle</code>
 * factory methods that take a <code>ResourceBundle.Control</code>
 * instance. You can implement your own subclass in order to enable
 * non-standard resource bundle formats, change the search strategy, or
 * define caching parameters. Refer to the descriptions of the class and the
 * {@link #getBundle(String, Locale, ClassLoader, Control) getBundle}
 * factory method for details.
 *
 * <h3>Cache Management</h3>
 *
 * Resource bundle instances created by the <code>getBundle</code> factory
 * methods are cached by default, and the factory methods return the same
 * resource bundle instance multiple times if it has been
 * cached. <code>getBundle</code> clients may clear the cache, manage the
 * lifetime of cached resource bundle instances using time-to-live values,
 * or specify not to cache resource bundle instances. Refer to the
 * descriptions of the {@linkplain #getBundle(String, Locale, ClassLoader,
 * Control) <code>getBundle</code> factory method}, {@link
 * #clearCache(ClassLoader) clearCache}, {@link
 * Control#getTimeToLive(String, Locale)
 * ResourceBundle.Control.getTimeToLive}, and {@link
 * Control#needsReload(String, Locale, String, ClassLoader, ResourceBundle,
 * long) ResourceBundle.Control.needsReload} for details.
 *
 * <h3>Example</h3>
 *
 * The following is a very simple example of a <code>ResourceBundle</code>
 * subclass, <code>MyResources</code>, that manages two resources (for a larger number of
 * resources you would probably use a <code>Map</code>).
 * Notice that you don't need to supply a value if
 * a "parent-level" <code>ResourceBundle</code> handles the same
 * key with the same value (as for the okKey below).
 * <blockquote>
 * <pre>
 * // default (English language, United States)
 * public class MyResources extends ResourceBundle {
 *     public Object handleGetObject(String key) {
 *         if (key.equals("okKey")) return "Ok";
 *         if (key.equals("cancelKey")) return "Cancel";
 *         return null;
 *     }
 *
 *     public Enumeration&lt;String&gt; getKeys() {
 *         return Collections.enumeration(keySet());
 *     }
 *
 *     // Overrides handleKeySet() so that the getKeys() implementation
 *     // can rely on the keySet() value.
 *     protected Set&lt;String&gt; handleKeySet() {
 *         return new HashSet&lt;String&gt;(Arrays.asList("okKey", "cancelKey"));
 *     }
 * }
 *
 * // German language
 * public class MyResources_de extends MyResources {
 *     public Object handleGetObject(String key) {
 *         // don't need okKey, since parent level handles it.
 *         if (key.equals("cancelKey")) return "Abbrechen";
 *         return null;
 *     }
 *
 *     protected Set&lt;String&gt; handleKeySet() {
 *         return new HashSet&lt;String&gt;(Arrays.asList("cancelKey"));
 *     }
 * }
 * </pre>
 * </blockquote>
 * You do not have to restrict yourself to using a single family of
 * <code>ResourceBundle</code>s. For example, you could have a set of bundles for
 * exception messages, <code>ExceptionResources</code>
 * (<code>ExceptionResources_fr</code>, <code>ExceptionResources_de</code>, ...),
 * and one for widgets, <code>WidgetResource</code> (<code>WidgetResources_fr</code>,
 * <code>WidgetResources_de</code>, ...); breaking up the resources however you like.
 *
 * @see ListResourceBundle
 * @see PropertyResourceBundle
 * @see MissingResourceException
 * @since JDK1.1
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class ResourceBundle {

/**
 * Sole constructor.  (For invocation by subclass constructors, typically
 * implicit.)
 */

public ResourceBundle() { throw new RuntimeException("Stub!"); }

/**
 * Returns the base name of this bundle, if known, or {@code null} if unknown.
 *
 * If not null, then this is the value of the {@code baseName} parameter
 * that was passed to the {@code ResourceBundle.getBundle(...)} method
 * when the resource bundle was loaded.
 *
 * @return The base name of the resource bundle, as provided to and expected
 * by the {@code ResourceBundle.getBundle(...)} methods.
 *
 * @see #getBundle(java.lang.String, java.util.Locale, java.lang.ClassLoader)
 *
 * @since 1.8
 */

public java.lang.String getBaseBundleName() { throw new RuntimeException("Stub!"); }

/**
 * Gets a string for the given key from this resource bundle or one of its parents.
 * Calling this method is equivalent to calling
 * <blockquote>
 * <code>(String) {@link #getObject(java.lang.String) getObject}(key)</code>.
 * </blockquote>
 *
 * @param key the key for the desired string
 * @exception NullPointerException if <code>key</code> is <code>null</code>
 * @exception MissingResourceException if no object for the given key can be found
 * @exception ClassCastException if the object found for the given key is not a string
 * @return the string for the given key
 */

public final java.lang.String getString(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets a string array for the given key from this resource bundle or one of its parents.
 * Calling this method is equivalent to calling
 * <blockquote>
 * <code>(String[]) {@link #getObject(java.lang.String) getObject}(key)</code>.
 * </blockquote>
 *
 * @param key the key for the desired string array
 * @exception NullPointerException if <code>key</code> is <code>null</code>
 * @exception MissingResourceException if no object for the given key can be found
 * @exception ClassCastException if the object found for the given key is not a string array
 * @return the string array for the given key
 */

public final java.lang.String[] getStringArray(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Gets an object for the given key from this resource bundle or one of its parents.
 * This method first tries to obtain the object from this resource bundle using
 * {@link #handleGetObject(java.lang.String) handleGetObject}.
 * If not successful, and the parent resource bundle is not null,
 * it calls the parent's <code>getObject</code> method.
 * If still not successful, it throws a MissingResourceException.
 *
 * @param key the key for the desired object
 * @exception NullPointerException if <code>key</code> is <code>null</code>
 * @exception MissingResourceException if no object for the given key can be found
 * @return the object for the given key
 */

public final java.lang.Object getObject(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns the locale of this resource bundle. This method can be used after a
 * call to getBundle() to determine whether the resource bundle returned really
 * corresponds to the requested locale or is a fallback.
 *
 * @return the locale of this resource bundle
 */

public java.util.Locale getLocale() { throw new RuntimeException("Stub!"); }

/**
 * Sets the parent bundle of this bundle.
 * The parent bundle is searched by {@link #getObject getObject}
 * when this bundle does not contain a particular resource.
 *
 * @param parent this bundle's parent bundle.
 */

protected void setParent(java.util.ResourceBundle parent) { throw new RuntimeException("Stub!"); }

/**
 * Gets a resource bundle using the specified base name, the default locale,
 * and the caller's class loader. Calling this method is equivalent to calling
 * <blockquote>
 * <code>getBundle(baseName, Locale.getDefault(), this.getClass().getClassLoader())</code>,
 * </blockquote>
 * except that <code>getClassLoader()</code> is run with the security
 * privileges of <code>ResourceBundle</code>.
 * See {@link #getBundle(String, Locale, ClassLoader) getBundle}
 * for a complete description of the search and instantiation strategy.
 *
 * @param baseName the base name of the resource bundle, a fully qualified class name
 * @exception java.lang.NullPointerException
 *     if <code>baseName</code> is <code>null</code>
 * @exception MissingResourceException
 *     if no resource bundle for the specified base name can be found
 * @return a resource bundle for the given base name and the default locale
 */

public static final java.util.ResourceBundle getBundle(java.lang.String baseName) { throw new RuntimeException("Stub!"); }

/**
 * Returns a resource bundle using the specified base name, the
 * default locale and the specified control. Calling this method
 * is equivalent to calling
 * <pre>
 * getBundle(baseName, Locale.getDefault(),
 *           this.getClass().getClassLoader(), control),
 * </pre>
 * except that <code>getClassLoader()</code> is run with the security
 * privileges of <code>ResourceBundle</code>.  See {@link
 * #getBundle(String, Locale, ClassLoader, Control) getBundle} for the
 * complete description of the resource bundle loading process with a
 * <code>ResourceBundle.Control</code>.
 *
 * @param baseName
 *        the base name of the resource bundle, a fully qualified class
 *        name
 * @param control
 *        the control which gives information for the resource bundle
 *        loading process
 * @return a resource bundle for the given base name and the default
 *        locale
 * @exception NullPointerException
 *        if <code>baseName</code> or <code>control</code> is
 *        <code>null</code>
 * @exception MissingResourceException
 *        if no resource bundle for the specified base name can be found
 * @exception IllegalArgumentException
 *        if the given <code>control</code> doesn't perform properly
 *        (e.g., <code>control.getCandidateLocales</code> returns null.)
 *        Note that validation of <code>control</code> is performed as
 *        needed.
 * @since 1.6
 */

public static final java.util.ResourceBundle getBundle(java.lang.String baseName, java.util.ResourceBundle.Control control) { throw new RuntimeException("Stub!"); }

/**
 * Gets a resource bundle using the specified base name and locale,
 * and the caller's class loader. Calling this method is equivalent to calling
 * <blockquote>
 * <code>getBundle(baseName, locale, this.getClass().getClassLoader())</code>,
 * </blockquote>
 * except that <code>getClassLoader()</code> is run with the security
 * privileges of <code>ResourceBundle</code>.
 * See {@link #getBundle(String, Locale, ClassLoader) getBundle}
 * for a complete description of the search and instantiation strategy.
 *
 * @param baseName
 *        the base name of the resource bundle, a fully qualified class name
 * @param locale
 *        the locale for which a resource bundle is desired
 * @exception NullPointerException
 *        if <code>baseName</code> or <code>locale</code> is <code>null</code>
 * @exception MissingResourceException
 *        if no resource bundle for the specified base name can be found
 * @return a resource bundle for the given base name and locale
 */

public static final java.util.ResourceBundle getBundle(java.lang.String baseName, java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a resource bundle using the specified base name, target
 * locale and control, and the caller's class loader. Calling this
 * method is equivalent to calling
 * <pre>
 * getBundle(baseName, targetLocale, this.getClass().getClassLoader(),
 *           control),
 * </pre>
 * except that <code>getClassLoader()</code> is run with the security
 * privileges of <code>ResourceBundle</code>.  See {@link
 * #getBundle(String, Locale, ClassLoader, Control) getBundle} for the
 * complete description of the resource bundle loading process with a
 * <code>ResourceBundle.Control</code>.
 *
 * @param baseName
 *        the base name of the resource bundle, a fully qualified
 *        class name
 * @param targetLocale
 *        the locale for which a resource bundle is desired
 * @param control
 *        the control which gives information for the resource
 *        bundle loading process
 * @return a resource bundle for the given base name and a
 *        <code>Locale</code> in <code>locales</code>
 * @exception NullPointerException
 *        if <code>baseName</code>, <code>locales</code> or
 *        <code>control</code> is <code>null</code>
 * @exception MissingResourceException
 *        if no resource bundle for the specified base name in any
 *        of the <code>locales</code> can be found.
 * @exception IllegalArgumentException
 *        if the given <code>control</code> doesn't perform properly
 *        (e.g., <code>control.getCandidateLocales</code> returns null.)
 *        Note that validation of <code>control</code> is performed as
 *        needed.
 * @since 1.6
 */

public static final java.util.ResourceBundle getBundle(java.lang.String baseName, java.util.Locale targetLocale, java.util.ResourceBundle.Control control) { throw new RuntimeException("Stub!"); }

/**
 * Gets a resource bundle using the specified base name, locale, and class
 * loader.
 *
 * <p>This method behaves the same as calling
 * {@link #getBundle(String, Locale, ClassLoader, Control)} passing a
 * default instance of {@link Control}.
 *
 * <p><code>getBundle</code> uses the base name, the specified locale, and
 * the default locale (obtained from {@link java.util.Locale#getDefault()
 * Locale.getDefault}) to generate a sequence of <a
 * name="candidates"><em>candidate bundle names</em></a>.  If the specified
 * locale's language, script, country, and variant are all empty strings,
 * then the base name is the only candidate bundle name.  Otherwise, a list
 * of candidate locales is generated from the attribute values of the
 * specified locale (language, script, country and variant) and appended to
 * the base name.  Typically, this will look like the following:
 *
 * <pre>
 *     baseName + "_" + language + "_" + script + "_" + country + "_" + variant
 *     baseName + "_" + language + "_" + script + "_" + country
 *     baseName + "_" + language + "_" + script
 *     baseName + "_" + language + "_" + country + "_" + variant
 *     baseName + "_" + language + "_" + country
 *     baseName + "_" + language
 * </pre>
 *
 * <p>Candidate bundle names where the final component is an empty string
 * are omitted, along with the underscore.  For example, if country is an
 * empty string, the second and the fifth candidate bundle names above
 * would be omitted.  Also, if script is an empty string, the candidate names
 * including script are omitted.  For example, a locale with language "de"
 * and variant "JAVA" will produce candidate names with base name
 * "MyResource" below.
 *
 * <pre>
 *     MyResource_de__JAVA
 *     MyResource_de
 * </pre>
 *
 * In the case that the variant contains one or more underscores ('_'), a
 * sequence of bundle names generated by truncating the last underscore and
 * the part following it is inserted after a candidate bundle name with the
 * original variant.  For example, for a locale with language "en", script
 * "Latn, country "US" and variant "WINDOWS_VISTA", and bundle base name
 * "MyResource", the list of candidate bundle names below is generated:
 *
 * <pre>
 * MyResource_en_Latn_US_WINDOWS_VISTA
 * MyResource_en_Latn_US_WINDOWS
 * MyResource_en_Latn_US
 * MyResource_en_Latn
 * MyResource_en_US_WINDOWS_VISTA
 * MyResource_en_US_WINDOWS
 * MyResource_en_US
 * MyResource_en
 * </pre>
 *
 * <blockquote><b>Note:</b> For some <code>Locale</code>s, the list of
 * candidate bundle names contains extra names, or the order of bundle names
 * is slightly modified.  See the description of the default implementation
 * of {@link Control#getCandidateLocales(String, Locale)
 * getCandidateLocales} for details.</blockquote>
 *
 * <p><code>getBundle</code> then iterates over the candidate bundle names
 * to find the first one for which it can <em>instantiate</em> an actual
 * resource bundle. It uses the default controls' {@link Control#getFormats
 * getFormats} method, which generates two bundle names for each generated
 * name, the first a class name and the second a properties file name. For
 * each candidate bundle name, it attempts to create a resource bundle:
 *
 * <ul><li>First, it attempts to load a class using the generated class name.
 * If such a class can be found and loaded using the specified class
 * loader, is assignment compatible with ResourceBundle, is accessible from
 * ResourceBundle, and can be instantiated, <code>getBundle</code> creates a
 * new instance of this class and uses it as the <em>result resource
 * bundle</em>.
 *
 * <li>Otherwise, <code>getBundle</code> attempts to locate a property
 * resource file using the generated properties file name.  It generates a
 * path name from the candidate bundle name by replacing all "." characters
 * with "/" and appending the string ".properties".  It attempts to find a
 * "resource" with this name using {@link
 * java.lang.ClassLoader#getResource(java.lang.String)
 * ClassLoader.getResource}.  (Note that a "resource" in the sense of
 * <code>getResource</code> has nothing to do with the contents of a
 * resource bundle, it is just a container of data, such as a file.)  If it
 * finds a "resource", it attempts to create a new {@link
 * PropertyResourceBundle} instance from its contents.  If successful, this
 * instance becomes the <em>result resource bundle</em>.  </ul>
 *
 * <p>This continues until a result resource bundle is instantiated or the
 * list of candidate bundle names is exhausted.  If no matching resource
 * bundle is found, the default control's {@link Control#getFallbackLocale
 * getFallbackLocale} method is called, which returns the current default
 * locale.  A new sequence of candidate locale names is generated using this
 * locale and and searched again, as above.
 *
 * <p>If still no result bundle is found, the base name alone is looked up. If
 * this still fails, a <code>MissingResourceException</code> is thrown.
 *
 * <p><a name="parent_chain"> Once a result resource bundle has been found,
 * its <em>parent chain</em> is instantiated</a>.  If the result bundle already
 * has a parent (perhaps because it was returned from a cache) the chain is
 * complete.
 *
 * <p>Otherwise, <code>getBundle</code> examines the remainder of the
 * candidate locale list that was used during the pass that generated the
 * result resource bundle.  (As before, candidate bundle names where the
 * final component is an empty string are omitted.)  When it comes to the
 * end of the candidate list, it tries the plain bundle name.  With each of the
 * candidate bundle names it attempts to instantiate a resource bundle (first
 * looking for a class and then a properties file, as described above).
 *
 * <p>Whenever it succeeds, it calls the previously instantiated resource
 * bundle's {@link #setParent(java.util.ResourceBundle) setParent} method
 * with the new resource bundle.  This continues until the list of names
 * is exhausted or the current bundle already has a non-null parent.
 *
 * <p>Once the parent chain is complete, the bundle is returned.
 *
 * <p><b>Note:</b> <code>getBundle</code> caches instantiated resource
 * bundles and might return the same resource bundle instance multiple times.
 *
 * <p><b>Note:</b>The <code>baseName</code> argument should be a fully
 * qualified class name. However, for compatibility with earlier versions,
 * Sun's Java SE Runtime Environments do not verify this, and so it is
 * possible to access <code>PropertyResourceBundle</code>s by specifying a
 * path name (using "/") instead of a fully qualified class name (using
 * ".").
 *
 * <p><a name="default_behavior_example">
 * <strong>Example:</strong></a>
 * <p>
 * The following class and property files are provided:
 * <pre>
 *     MyResources.class
 *     MyResources.properties
 *     MyResources_fr.properties
 *     MyResources_fr_CH.class
 *     MyResources_fr_CH.properties
 *     MyResources_en.properties
 *     MyResources_es_ES.class
 * </pre>
 *
 * The contents of all files are valid (that is, public non-abstract
 * subclasses of <code>ResourceBundle</code> for the ".class" files,
 * syntactically correct ".properties" files).  The default locale is
 * <code>Locale("en", "GB")</code>.
 *
 * <p>Calling <code>getBundle</code> with the locale arguments below will
 * instantiate resource bundles as follows:
 *
 * <table summary="getBundle() locale to resource bundle mapping">
 * <tr><td>Locale("fr", "CH")</td><td>MyResources_fr_CH.class, parent MyResources_fr.properties, parent MyResources.class</td></tr>
 * <tr><td>Locale("fr", "FR")</td><td>MyResources_fr.properties, parent MyResources.class</td></tr>
 * <tr><td>Locale("de", "DE")</td><td>MyResources_en.properties, parent MyResources.class</td></tr>
 * <tr><td>Locale("en", "US")</td><td>MyResources_en.properties, parent MyResources.class</td></tr>
 * <tr><td>Locale("es", "ES")</td><td>MyResources_es_ES.class, parent MyResources.class</td></tr>
 * </table>
 *
 * <p>The file MyResources_fr_CH.properties is never used because it is
 * hidden by the MyResources_fr_CH.class. Likewise, MyResources.properties
 * is also hidden by MyResources.class.
 *
 * @param baseName the base name of the resource bundle, a fully qualified class name
 * @param locale the locale for which a resource bundle is desired
 * @param loader the class loader from which to load the resource bundle
 * @return a resource bundle for the given base name and locale
 * @exception java.lang.NullPointerException
 *        if <code>baseName</code>, <code>locale</code>, or <code>loader</code> is <code>null</code>
 * @exception MissingResourceException
 *        if no resource bundle for the specified base name can be found
 * @since 1.2
 */

public static java.util.ResourceBundle getBundle(java.lang.String baseName, java.util.Locale locale, java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Returns a resource bundle using the specified base name, target
 * locale, class loader and control. Unlike the {@linkplain
 * #getBundle(String, Locale, ClassLoader) <code>getBundle</code>
 * factory methods with no <code>control</code> argument}, the given
 * <code>control</code> specifies how to locate and instantiate resource
 * bundles. Conceptually, the bundle loading process with the given
 * <code>control</code> is performed in the following steps.
 *
 * <ol>
 * <li>This factory method looks up the resource bundle in the cache for
 * the specified <code>baseName</code>, <code>targetLocale</code> and
 * <code>loader</code>.  If the requested resource bundle instance is
 * found in the cache and the time-to-live periods of the instance and
 * all of its parent instances have not expired, the instance is returned
 * to the caller. Otherwise, this factory method proceeds with the
 * loading process below.</li>
 *
 * <li>The {@link ResourceBundle.Control#getFormats(String)
 * control.getFormats} method is called to get resource bundle formats
 * to produce bundle or resource names. The strings
 * <code>"java.class"</code> and <code>"java.properties"</code>
 * designate class-based and {@linkplain PropertyResourceBundle
 * property}-based resource bundles, respectively. Other strings
 * starting with <code>"java."</code> are reserved for future extensions
 * and must not be used for application-defined formats. Other strings
 * designate application-defined formats.</li>
 *
 * <li>The {@link ResourceBundle.Control#getCandidateLocales(String,
 * Locale) control.getCandidateLocales} method is called with the target
 * locale to get a list of <em>candidate <code>Locale</code>s</em> for
 * which resource bundles are searched.</li>
 *
 * <li>The {@link ResourceBundle.Control#newBundle(String, Locale,
 * String, ClassLoader, boolean) control.newBundle} method is called to
 * instantiate a <code>ResourceBundle</code> for the base bundle name, a
 * candidate locale, and a format. (Refer to the note on the cache
 * lookup below.) This step is iterated over all combinations of the
 * candidate locales and formats until the <code>newBundle</code> method
 * returns a <code>ResourceBundle</code> instance or the iteration has
 * used up all the combinations. For example, if the candidate locales
 * are <code>Locale("de", "DE")</code>, <code>Locale("de")</code> and
 * <code>Locale("")</code> and the formats are <code>"java.class"</code>
 * and <code>"java.properties"</code>, then the following is the
 * sequence of locale-format combinations to be used to call
 * <code>control.newBundle</code>.
 *
 * <table style="width: 50%; text-align: left; margin-left: 40px;"
 *  border="0" cellpadding="2" cellspacing="2" summary="locale-format combinations for newBundle">
 * <tbody>
 * <tr>
 * <td
 * style="vertical-align: top; text-align: left; font-weight: bold; width: 50%;"><code>Locale</code><br>
 * </td>
 * <td
 * style="vertical-align: top; text-align: left; font-weight: bold; width: 50%;"><code>format</code><br>
 * </td>
 * </tr>
 * <tr>
 * <td style="vertical-align: top; width: 50%;"><code>Locale("de", "DE")</code><br>
 * </td>
 * <td style="vertical-align: top; width: 50%;"><code>java.class</code><br>
 * </td>
 * </tr>
 * <tr>
 * <td style="vertical-align: top; width: 50%;"><code>Locale("de", "DE")</code></td>
 * <td style="vertical-align: top; width: 50%;"><code>java.properties</code><br>
 * </td>
 * </tr>
 * <tr>
 * <td style="vertical-align: top; width: 50%;"><code>Locale("de")</code></td>
 * <td style="vertical-align: top; width: 50%;"><code>java.class</code></td>
 * </tr>
 * <tr>
 * <td style="vertical-align: top; width: 50%;"><code>Locale("de")</code></td>
 * <td style="vertical-align: top; width: 50%;"><code>java.properties</code></td>
 * </tr>
 * <tr>
 * <td style="vertical-align: top; width: 50%;"><code>Locale("")</code><br>
 * </td>
 * <td style="vertical-align: top; width: 50%;"><code>java.class</code></td>
 * </tr>
 * <tr>
 * <td style="vertical-align: top; width: 50%;"><code>Locale("")</code></td>
 * <td style="vertical-align: top; width: 50%;"><code>java.properties</code></td>
 * </tr>
 * </tbody>
 * </table>
 * </li>
 *
 * <li>If the previous step has found no resource bundle, proceed to
 * Step 6. If a bundle has been found that is a base bundle (a bundle
 * for <code>Locale("")</code>), and the candidate locale list only contained
 * <code>Locale("")</code>, return the bundle to the caller. If a bundle
 * has been found that is a base bundle, but the candidate locale list
 * contained locales other than Locale(""), put the bundle on hold and
 * proceed to Step 6. If a bundle has been found that is not a base
 * bundle, proceed to Step 7.</li>
 *
 * <li>The {@link ResourceBundle.Control#getFallbackLocale(String,
 * Locale) control.getFallbackLocale} method is called to get a fallback
 * locale (alternative to the current target locale) to try further
 * finding a resource bundle. If the method returns a non-null locale,
 * it becomes the next target locale and the loading process starts over
 * from Step 3. Otherwise, if a base bundle was found and put on hold in
 * a previous Step 5, it is returned to the caller now. Otherwise, a
 * MissingResourceException is thrown.</li>
 *
 * <li>At this point, we have found a resource bundle that's not the
 * base bundle. If this bundle set its parent during its instantiation,
 * it is returned to the caller. Otherwise, its <a
 * href="./ResourceBundle.html#parent_chain">parent chain</a> is
 * instantiated based on the list of candidate locales from which it was
 * found. Finally, the bundle is returned to the caller.</li>
 * </ol>
 *
 * <p>During the resource bundle loading process above, this factory
 * method looks up the cache before calling the {@link
 * Control#newBundle(String, Locale, String, ClassLoader, boolean)
 * control.newBundle} method.  If the time-to-live period of the
 * resource bundle found in the cache has expired, the factory method
 * calls the {@link ResourceBundle.Control#needsReload(String, Locale,
 * String, ClassLoader, ResourceBundle, long) control.needsReload}
 * method to determine whether the resource bundle needs to be reloaded.
 * If reloading is required, the factory method calls
 * <code>control.newBundle</code> to reload the resource bundle.  If
 * <code>control.newBundle</code> returns <code>null</code>, the factory
 * method puts a dummy resource bundle in the cache as a mark of
 * nonexistent resource bundles in order to avoid lookup overhead for
 * subsequent requests. Such dummy resource bundles are under the same
 * expiration control as specified by <code>control</code>.
 *
 * <p>All resource bundles loaded are cached by default. Refer to
 * {@link Control#getTimeToLive(String,Locale)
 * control.getTimeToLive} for details.
 *
 * <p>The following is an example of the bundle loading process with the
 * default <code>ResourceBundle.Control</code> implementation.
 *
 * <p>Conditions:
 * <ul>
 * <li>Base bundle name: <code>foo.bar.Messages</code>
 * <li>Requested <code>Locale</code>: {@link Locale#ITALY}</li>
 * <li>Default <code>Locale</code>: {@link Locale#FRENCH}</li>
 * <li>Available resource bundles:
 * <code>foo/bar/Messages_fr.properties</code> and
 * <code>foo/bar/Messages.properties</code></li>
 * </ul>
 *
 * <p>First, <code>getBundle</code> tries loading a resource bundle in
 * the following sequence.
 *
 * <ul>
 * <li>class <code>foo.bar.Messages_it_IT</code>
 * <li>file <code>foo/bar/Messages_it_IT.properties</code>
 * <li>class <code>foo.bar.Messages_it</code></li>
 * <li>file <code>foo/bar/Messages_it.properties</code></li>
 * <li>class <code>foo.bar.Messages</code></li>
 * <li>file <code>foo/bar/Messages.properties</code></li>
 * </ul>
 *
 * <p>At this point, <code>getBundle</code> finds
 * <code>foo/bar/Messages.properties</code>, which is put on hold
 * because it's the base bundle.  <code>getBundle</code> calls {@link
 * Control#getFallbackLocale(String, Locale)
 * control.getFallbackLocale("foo.bar.Messages", Locale.ITALY)} which
 * returns <code>Locale.FRENCH</code>. Next, <code>getBundle</code>
 * tries loading a bundle in the following sequence.
 *
 * <ul>
 * <li>class <code>foo.bar.Messages_fr</code></li>
 * <li>file <code>foo/bar/Messages_fr.properties</code></li>
 * <li>class <code>foo.bar.Messages</code></li>
 * <li>file <code>foo/bar/Messages.properties</code></li>
 * </ul>
 *
 * <p><code>getBundle</code> finds
 * <code>foo/bar/Messages_fr.properties</code> and creates a
 * <code>ResourceBundle</code> instance. Then, <code>getBundle</code>
 * sets up its parent chain from the list of the candidate locales.  Only
 * <code>foo/bar/Messages.properties</code> is found in the list and
 * <code>getBundle</code> creates a <code>ResourceBundle</code> instance
 * that becomes the parent of the instance for
 * <code>foo/bar/Messages_fr.properties</code>.
 *
 * @param baseName
 *        the base name of the resource bundle, a fully qualified
 *        class name
 * @param targetLocale
 *        the locale for which a resource bundle is desired
 * @param loader
 *        the class loader from which to load the resource bundle
 * @param control
 *        the control which gives information for the resource
 *        bundle loading process
 * @return a resource bundle for the given base name and locale
 * @exception NullPointerException
 *        if <code>baseName</code>, <code>targetLocale</code>,
 *        <code>loader</code>, or <code>control</code> is
 *        <code>null</code>
 * @exception MissingResourceException
 *        if no resource bundle for the specified base name can be found
 * @exception IllegalArgumentException
 *        if the given <code>control</code> doesn't perform properly
 *        (e.g., <code>control.getCandidateLocales</code> returns null.)
 *        Note that validation of <code>control</code> is performed as
 *        needed.
 * @since 1.6
 */

public static java.util.ResourceBundle getBundle(java.lang.String baseName, java.util.Locale targetLocale, java.lang.ClassLoader loader, java.util.ResourceBundle.Control control) { throw new RuntimeException("Stub!"); }

/**
 * Removes all resource bundles from the cache that have been loaded
 * using the caller's class loader.
 *
 * @since 1.6
 * @see ResourceBundle.Control#getTimeToLive(String,Locale)
 */

public static final void clearCache() { throw new RuntimeException("Stub!"); }

/**
 * Removes all resource bundles from the cache that have been loaded
 * using the given class loader.
 *
 * @param loader the class loader
 * @exception NullPointerException if <code>loader</code> is null
 * @since 1.6
 * @see ResourceBundle.Control#getTimeToLive(String,Locale)
 */

public static final void clearCache(java.lang.ClassLoader loader) { throw new RuntimeException("Stub!"); }

/**
 * Gets an object for the given key from this resource bundle.
 * Returns null if this resource bundle does not contain an
 * object for the given key.
 *
 * @param key the key for the desired object
 * @exception NullPointerException if <code>key</code> is <code>null</code>
 * @return the object for the given key, or null
 */

protected abstract java.lang.Object handleGetObject(java.lang.String key);

/**
 * Returns an enumeration of the keys.
 *
 * @return an <code>Enumeration</code> of the keys contained in
 *         this <code>ResourceBundle</code> and its parent bundles.
 */

public abstract java.util.Enumeration<java.lang.String> getKeys();

/**
 * Determines whether the given <code>key</code> is contained in
 * this <code>ResourceBundle</code> or its parent bundles.
 *
 * @param key
 *        the resource <code>key</code>
 * @return <code>true</code> if the given <code>key</code> is
 *        contained in this <code>ResourceBundle</code> or its
 *        parent bundles; <code>false</code> otherwise.
 * @exception NullPointerException
 *         if <code>key</code> is <code>null</code>
 * @since 1.6
 */

public boolean containsKey(java.lang.String key) { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>Set</code> of all keys contained in this
 * <code>ResourceBundle</code> and its parent bundles.
 *
 * @return a <code>Set</code> of all keys contained in this
 *         <code>ResourceBundle</code> and its parent bundles.
 * @since 1.6
 */

public java.util.Set<java.lang.String> keySet() { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>Set</code> of the keys contained <em>only</em>
 * in this <code>ResourceBundle</code>.
 *
 * <p>The default implementation returns a <code>Set</code> of the
 * keys returned by the {@link #getKeys() getKeys} method except
 * for the ones for which the {@link #handleGetObject(String)
 * handleGetObject} method returns <code>null</code>. Once the
 * <code>Set</code> has been created, the value is kept in this
 * <code>ResourceBundle</code> in order to avoid producing the
 * same <code>Set</code> in subsequent calls. Subclasses can
 * override this method for faster handling.
 *
 * @return a <code>Set</code> of the keys contained only in this
 *        <code>ResourceBundle</code>
 * @since 1.6
 */

protected java.util.Set<java.lang.String> handleKeySet() { throw new RuntimeException("Stub!"); }

/**
 * The parent bundle of this bundle.
 * The parent bundle is searched by {@link #getObject getObject}
 * when this bundle does not contain a particular resource.
 */

protected java.util.ResourceBundle parent;
/**
 * <code>ResourceBundle.Control</code> defines a set of callback methods
 * that are invoked by the {@link ResourceBundle#getBundle(String,
 * Locale, ClassLoader, Control) ResourceBundle.getBundle} factory
 * methods during the bundle loading process. In other words, a
 * <code>ResourceBundle.Control</code> collaborates with the factory
 * methods for loading resource bundles. The default implementation of
 * the callback methods provides the information necessary for the
 * factory methods to perform the <a
 * href="./ResourceBundle.html#default_behavior">default behavior</a>.
 *
 * <p>In addition to the callback methods, the {@link
 * #toBundleName(String, Locale) toBundleName} and {@link
 * #toResourceName(String, String) toResourceName} methods are defined
 * primarily for convenience in implementing the callback
 * methods. However, the <code>toBundleName</code> method could be
 * overridden to provide different conventions in the organization and
 * packaging of localized resources.  The <code>toResourceName</code>
 * method is <code>final</code> to avoid use of wrong resource and class
 * name separators.
 *
 * <p>Two factory methods, {@link #getControl(List)} and {@link
 * #getNoFallbackControl(List)}, provide
 * <code>ResourceBundle.Control</code> instances that implement common
 * variations of the default bundle loading process.
 *
 * <p>The formats returned by the {@link Control#getFormats(String)
 * getFormats} method and candidate locales returned by the {@link
 * ResourceBundle.Control#getCandidateLocales(String, Locale)
 * getCandidateLocales} method must be consistent in all
 * <code>ResourceBundle.getBundle</code> invocations for the same base
 * bundle. Otherwise, the <code>ResourceBundle.getBundle</code> methods
 * may return unintended bundles. For example, if only
 * <code>"java.class"</code> is returned by the <code>getFormats</code>
 * method for the first call to <code>ResourceBundle.getBundle</code>
 * and only <code>"java.properties"</code> for the second call, then the
 * second call will return the class-based one that has been cached
 * during the first call.
 *
 * <p>A <code>ResourceBundle.Control</code> instance must be thread-safe
 * if it's simultaneously used by multiple threads.
 * <code>ResourceBundle.getBundle</code> does not synchronize to call
 * the <code>ResourceBundle.Control</code> methods. The default
 * implementations of the methods are thread-safe.
 *
 * <p>Applications can specify <code>ResourceBundle.Control</code>
 * instances returned by the <code>getControl</code> factory methods or
 * created from a subclass of <code>ResourceBundle.Control</code> to
 * customize the bundle loading process. The following are examples of
 * changing the default bundle loading process.
 *
 * <p><b>Example 1</b>
 *
 * <p>The following code lets <code>ResourceBundle.getBundle</code> look
 * up only properties-based resources.
 *
 * <pre>
 * import java.util.*;
 * import static java.util.ResourceBundle.Control.*;
 * ...
 * ResourceBundle bundle =
 *   ResourceBundle.getBundle("MyResources", new Locale("fr", "CH"),
 *                            ResourceBundle.Control.getControl(FORMAT_PROPERTIES));
 * </pre>
 *
 * Given the resource bundles in the <a
 * href="./ResourceBundle.html#default_behavior_example">example</a> in
 * the <code>ResourceBundle.getBundle</code> description, this
 * <code>ResourceBundle.getBundle</code> call loads
 * <code>MyResources_fr_CH.properties</code> whose parent is
 * <code>MyResources_fr.properties</code> whose parent is
 * <code>MyResources.properties</code>. (<code>MyResources_fr_CH.properties</code>
 * is not hidden, but <code>MyResources_fr_CH.class</code> is.)
 *
 * <p><b>Example 2</b>
 *
 * <p>The following is an example of loading XML-based bundles
 * using {@link Properties#loadFromXML(java.io.InputStream)
 * Properties.loadFromXML}.
 *
 * <pre>
 * ResourceBundle rb = ResourceBundle.getBundle("Messages",
 *     new ResourceBundle.Control() {
 *         public List&lt;String&gt; getFormats(String baseName) {
 *             if (baseName == null)
 *                 throw new NullPointerException();
 *             return Arrays.asList("xml");
 *         }
 *         public ResourceBundle newBundle(String baseName,
 *                                         Locale locale,
 *                                         String format,
 *                                         ClassLoader loader,
 *                                         boolean reload)
 *                          throws IllegalAccessException,
 *                                 InstantiationException,
 *                                 IOException {
 *             if (baseName == null || locale == null
 *                   || format == null || loader == null)
 *                 throw new NullPointerException();
 *             ResourceBundle bundle = null;
 *             if (format.equals("xml")) {
 *                 String bundleName = toBundleName(baseName, locale);
 *                 String resourceName = toResourceName(bundleName, format);
 *                 InputStream stream = null;
 *                 if (reload) {
 *                     URL url = loader.getResource(resourceName);
 *                     if (url != null) {
 *                         URLConnection connection = url.openConnection();
 *                         if (connection != null) {
 *                             // Disable caches to get fresh data for
 *                             // reloading.
 *                             connection.setUseCaches(false);
 *                             stream = connection.getInputStream();
 *                         }
 *                     }
 *                 } else {
 *                     stream = loader.getResourceAsStream(resourceName);
 *                 }
 *                 if (stream != null) {
 *                     BufferedInputStream bis = new BufferedInputStream(stream);
 *                     bundle = new XMLResourceBundle(bis);
 *                     bis.close();
 *                 }
 *             }
 *             return bundle;
 *         }
 *     });
 *
 * ...
 *
 * private static class XMLResourceBundle extends ResourceBundle {
 *     private Properties props;
 *     XMLResourceBundle(InputStream stream) throws IOException {
 *         props = new Properties();
 *         props.loadFromXML(stream);
 *     }
 *     protected Object handleGetObject(String key) {
 *         return props.getProperty(key);
 *     }
 *     public Enumeration&lt;String&gt; getKeys() {
 *         ...
 *     }
 * }
 * </pre>
 *
 * @since 1.6
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public static class Control {

/**
 * Sole constructor. (For invocation by subclass constructors,
 * typically implicit.)
 */

protected Control() { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>ResourceBundle.Control</code> in which the {@link
 * #getFormats(String) getFormats} method returns the specified
 * <code>formats</code>. The <code>formats</code> must be equal to
 * one of {@link Control#FORMAT_PROPERTIES}, {@link
 * Control#FORMAT_CLASS} or {@link
 * Control#FORMAT_DEFAULT}. <code>ResourceBundle.Control</code>
 * instances returned by this method are singletons and thread-safe.
 *
 * <p>Specifying {@link Control#FORMAT_DEFAULT} is equivalent to
 * instantiating the <code>ResourceBundle.Control</code> class,
 * except that this method returns a singleton.
 *
 * @param formats
 *        the formats to be returned by the
 *        <code>ResourceBundle.Control.getFormats</code> method
 * @return a <code>ResourceBundle.Control</code> supporting the
 *        specified <code>formats</code>
 * @exception NullPointerException
 *        if <code>formats</code> is <code>null</code>
 * @exception IllegalArgumentException
 *        if <code>formats</code> is unknown
 */

public static final java.util.ResourceBundle.Control getControl(java.util.List<java.lang.String> formats) { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>ResourceBundle.Control</code> in which the {@link
 * #getFormats(String) getFormats} method returns the specified
 * <code>formats</code> and the {@link
 * Control#getFallbackLocale(String, Locale) getFallbackLocale}
 * method returns <code>null</code>. The <code>formats</code> must
 * be equal to one of {@link Control#FORMAT_PROPERTIES}, {@link
 * Control#FORMAT_CLASS} or {@link Control#FORMAT_DEFAULT}.
 * <code>ResourceBundle.Control</code> instances returned by this
 * method are singletons and thread-safe.
 *
 * @param formats
 *        the formats to be returned by the
 *        <code>ResourceBundle.Control.getFormats</code> method
 * @return a <code>ResourceBundle.Control</code> supporting the
 *        specified <code>formats</code> with no fallback
 *        <code>Locale</code> support
 * @exception NullPointerException
 *        if <code>formats</code> is <code>null</code>
 * @exception IllegalArgumentException
 *        if <code>formats</code> is unknown
 */

public static final java.util.ResourceBundle.Control getNoFallbackControl(java.util.List<java.lang.String> formats) { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>List</code> of <code>String</code>s containing
 * formats to be used to load resource bundles for the given
 * <code>baseName</code>. The <code>ResourceBundle.getBundle</code>
 * factory method tries to load resource bundles with formats in the
 * order specified by the list. The list returned by this method
 * must have at least one <code>String</code>. The predefined
 * formats are <code>"java.class"</code> for class-based resource
 * bundles and <code>"java.properties"</code> for {@linkplain
 * PropertyResourceBundle properties-based} ones. Strings starting
 * with <code>"java."</code> are reserved for future extensions and
 * must not be used by application-defined formats.
 *
 * <p>It is not a requirement to return an immutable (unmodifiable)
 * <code>List</code>.  However, the returned <code>List</code> must
 * not be mutated after it has been returned by
 * <code>getFormats</code>.
 *
 * <p>The default implementation returns {@link #FORMAT_DEFAULT} so
 * that the <code>ResourceBundle.getBundle</code> factory method
 * looks up first class-based resource bundles, then
 * properties-based ones.
 *
 * @param baseName
 *        the base name of the resource bundle, a fully qualified class
 *        name
 * @return a <code>List</code> of <code>String</code>s containing
 *        formats for loading resource bundles.
 * @exception NullPointerException
 *        if <code>baseName</code> is null
 * @see #FORMAT_DEFAULT
 * @see #FORMAT_CLASS
 * @see #FORMAT_PROPERTIES
 */

public java.util.List<java.lang.String> getFormats(java.lang.String baseName) { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>List</code> of <code>Locale</code>s as candidate
 * locales for <code>baseName</code> and <code>locale</code>. This
 * method is called by the <code>ResourceBundle.getBundle</code>
 * factory method each time the factory method tries finding a
 * resource bundle for a target <code>Locale</code>.
 *
 * <p>The sequence of the candidate locales also corresponds to the
 * runtime resource lookup path (also known as the <I>parent
 * chain</I>), if the corresponding resource bundles for the
 * candidate locales exist and their parents are not defined by
 * loaded resource bundles themselves.  The last element of the list
 * must be a {@linkplain Locale#ROOT root locale} if it is desired to
 * have the base bundle as the terminal of the parent chain.
 *
 * <p>If the given locale is equal to <code>Locale.ROOT</code> (the
 * root locale), a <code>List</code> containing only the root
 * <code>Locale</code> must be returned. In this case, the
 * <code>ResourceBundle.getBundle</code> factory method loads only
 * the base bundle as the resulting resource bundle.
 *
 * <p>It is not a requirement to return an immutable (unmodifiable)
 * <code>List</code>. However, the returned <code>List</code> must not
 * be mutated after it has been returned by
 * <code>getCandidateLocales</code>.
 *
 * <p>The default implementation returns a <code>List</code> containing
 * <code>Locale</code>s using the rules described below.  In the
 * description below, <em>L</em>, <em>S</em>, <em>C</em> and <em>V</em>
 * respectively represent non-empty language, script, country, and
 * variant.  For example, [<em>L</em>, <em>C</em>] represents a
 * <code>Locale</code> that has non-empty values only for language and
 * country.  The form <em>L</em>("xx") represents the (non-empty)
 * language value is "xx".  For all cases, <code>Locale</code>s whose
 * final component values are empty strings are omitted.
 *
 * <ol><li>For an input <code>Locale</code> with an empty script value,
 * append candidate <code>Locale</code>s by omitting the final component
 * one by one as below:
 *
 * <ul>
 * <li> [<em>L</em>, <em>C</em>, <em>V</em>] </li>
 * <li> [<em>L</em>, <em>C</em>] </li>
 * <li> [<em>L</em>] </li>
 * <li> <code>Locale.ROOT</code> </li>
 * </ul></li>
 *
 * <li>For an input <code>Locale</code> with a non-empty script value,
 * append candidate <code>Locale</code>s by omitting the final component
 * up to language, then append candidates generated from the
 * <code>Locale</code> with country and variant restored:
 *
 * <ul>
 * <li> [<em>L</em>, <em>S</em>, <em>C</em>, <em>V</em>]</li>
 * <li> [<em>L</em>, <em>S</em>, <em>C</em>]</li>
 * <li> [<em>L</em>, <em>S</em>]</li>
 * <li> [<em>L</em>, <em>C</em>, <em>V</em>]</li>
 * <li> [<em>L</em>, <em>C</em>]</li>
 * <li> [<em>L</em>]</li>
 * <li> <code>Locale.ROOT</code></li>
 * </ul></li>
 *
 * <li>For an input <code>Locale</code> with a variant value consisting
 * of multiple subtags separated by underscore, generate candidate
 * <code>Locale</code>s by omitting the variant subtags one by one, then
 * insert them after every occurrence of <code> Locale</code>s with the
 * full variant value in the original list.  For example, if the
 * the variant consists of two subtags <em>V1</em> and <em>V2</em>:
 *
 * <ul>
 * <li> [<em>L</em>, <em>S</em>, <em>C</em>, <em>V1</em>, <em>V2</em>]</li>
 * <li> [<em>L</em>, <em>S</em>, <em>C</em>, <em>V1</em>]</li>
 * <li> [<em>L</em>, <em>S</em>, <em>C</em>]</li>
 * <li> [<em>L</em>, <em>S</em>]</li>
 * <li> [<em>L</em>, <em>C</em>, <em>V1</em>, <em>V2</em>]</li>
 * <li> [<em>L</em>, <em>C</em>, <em>V1</em>]</li>
 * <li> [<em>L</em>, <em>C</em>]</li>
 * <li> [<em>L</em>]</li>
 * <li> <code>Locale.ROOT</code></li>
 * </ul></li>
 *
 * <li>Special cases for Chinese.  When an input <code>Locale</code> has the
 * language "zh" (Chinese) and an empty script value, either "Hans" (Simplified) or
 * "Hant" (Traditional) might be supplied, depending on the country.
 * When the country is "CN" (China) or "SG" (Singapore), "Hans" is supplied.
 * When the country is "HK" (Hong Kong SAR China), "MO" (Macau SAR China),
 * or "TW" (Taiwan), "Hant" is supplied.  For all other countries or when the country
 * is empty, no script is supplied.  For example, for <code>Locale("zh", "CN")
 * </code>, the candidate list will be:
 * <ul>
 * <li> [<em>L</em>("zh"), <em>S</em>("Hans"), <em>C</em>("CN")]</li>
 * <li> [<em>L</em>("zh"), <em>S</em>("Hans")]</li>
 * <li> [<em>L</em>("zh"), <em>C</em>("CN")]</li>
 * <li> [<em>L</em>("zh")]</li>
 * <li> <code>Locale.ROOT</code></li>
 * </ul>
 *
 * For <code>Locale("zh", "TW")</code>, the candidate list will be:
 * <ul>
 * <li> [<em>L</em>("zh"), <em>S</em>("Hant"), <em>C</em>("TW")]</li>
 * <li> [<em>L</em>("zh"), <em>S</em>("Hant")]</li>
 * <li> [<em>L</em>("zh"), <em>C</em>("TW")]</li>
 * <li> [<em>L</em>("zh")]</li>
 * <li> <code>Locale.ROOT</code></li>
 * </ul></li>
 *
 * <li>Special cases for Norwegian.  Both <code>Locale("no", "NO",
 * "NY")</code> and <code>Locale("nn", "NO")</code> represent Norwegian
 * Nynorsk.  When a locale's language is "nn", the standard candidate
 * list is generated up to [<em>L</em>("nn")], and then the following
 * candidates are added:
 *
 * <ul><li> [<em>L</em>("no"), <em>C</em>("NO"), <em>V</em>("NY")]</li>
 * <li> [<em>L</em>("no"), <em>C</em>("NO")]</li>
 * <li> [<em>L</em>("no")]</li>
 * <li> <code>Locale.ROOT</code></li>
 * </ul>
 *
 * If the locale is exactly <code>Locale("no", "NO", "NY")</code>, it is first
 * converted to <code>Locale("nn", "NO")</code> and then the above procedure is
 * followed.
 *
 * <p>Also, Java treats the language "no" as a synonym of Norwegian
 * Bokm&#xE5;l "nb".  Except for the single case <code>Locale("no",
 * "NO", "NY")</code> (handled above), when an input <code>Locale</code>
 * has language "no" or "nb", candidate <code>Locale</code>s with
 * language code "no" and "nb" are interleaved, first using the
 * requested language, then using its synonym. For example,
 * <code>Locale("nb", "NO", "POSIX")</code> generates the following
 * candidate list:
 *
 * <ul>
 * <li> [<em>L</em>("nb"), <em>C</em>("NO"), <em>V</em>("POSIX")]</li>
 * <li> [<em>L</em>("no"), <em>C</em>("NO"), <em>V</em>("POSIX")]</li>
 * <li> [<em>L</em>("nb"), <em>C</em>("NO")]</li>
 * <li> [<em>L</em>("no"), <em>C</em>("NO")]</li>
 * <li> [<em>L</em>("nb")]</li>
 * <li> [<em>L</em>("no")]</li>
 * <li> <code>Locale.ROOT</code></li>
 * </ul>
 *
 * <code>Locale("no", "NO", "POSIX")</code> would generate the same list
 * except that locales with "no" would appear before the corresponding
 * locales with "nb".</li>
 * </ol>
 *
 * <p>The default implementation uses an {@link ArrayList} that
 * overriding implementations may modify before returning it to the
 * caller. However, a subclass must not modify it after it has
 * been returned by <code>getCandidateLocales</code>.
 *
 * <p>For example, if the given <code>baseName</code> is "Messages"
 * and the given <code>locale</code> is
 * <code>Locale("ja",&nbsp;"",&nbsp;"XX")</code>, then a
 * <code>List</code> of <code>Locale</code>s:
 * <pre>
 *     Locale("ja", "", "XX")
 *     Locale("ja")
 *     Locale.ROOT
 * </pre>
 * is returned. And if the resource bundles for the "ja" and
 * "" <code>Locale</code>s are found, then the runtime resource
 * lookup path (parent chain) is:
 * <pre>{@code
 *     Messages_ja -> Messages
 * }</pre>
 *
 * @param baseName
 *        the base name of the resource bundle, a fully
 *        qualified class name
 * @param locale
 *        the locale for which a resource bundle is desired
 * @return a <code>List</code> of candidate
 *        <code>Locale</code>s for the given <code>locale</code>
 * @exception NullPointerException
 *        if <code>baseName</code> or <code>locale</code> is
 *        <code>null</code>
 */

public java.util.List<java.util.Locale> getCandidateLocales(java.lang.String baseName, java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Returns a <code>Locale</code> to be used as a fallback locale for
 * further resource bundle searches by the
 * <code>ResourceBundle.getBundle</code> factory method. This method
 * is called from the factory method every time when no resulting
 * resource bundle has been found for <code>baseName</code> and
 * <code>locale</code>, where locale is either the parameter for
 * <code>ResourceBundle.getBundle</code> or the previous fallback
 * locale returned by this method.
 *
 * <p>The method returns <code>null</code> if no further fallback
 * search is desired.
 *
 * <p>The default implementation returns the {@linkplain
 * Locale#getDefault() default <code>Locale</code>} if the given
 * <code>locale</code> isn't the default one.  Otherwise,
 * <code>null</code> is returned.
 *
 * @param baseName
 *        the base name of the resource bundle, a fully
 *        qualified class name for which
 *        <code>ResourceBundle.getBundle</code> has been
 *        unable to find any resource bundles (except for the
 *        base bundle)
 * @param locale
 *        the <code>Locale</code> for which
 *        <code>ResourceBundle.getBundle</code> has been
 *        unable to find any resource bundles (except for the
 *        base bundle)
 * @return a <code>Locale</code> for the fallback search,
 *        or <code>null</code> if no further fallback search
 *        is desired.
 * @exception NullPointerException
 *        if <code>baseName</code> or <code>locale</code>
 *        is <code>null</code>
 */

public java.util.Locale getFallbackLocale(java.lang.String baseName, java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Instantiates a resource bundle for the given bundle name of the
 * given format and locale, using the given class loader if
 * necessary. This method returns <code>null</code> if there is no
 * resource bundle available for the given parameters. If a resource
 * bundle can't be instantiated due to an unexpected error, the
 * error must be reported by throwing an <code>Error</code> or
 * <code>Exception</code> rather than simply returning
 * <code>null</code>.
 *
 * <p>If the <code>reload</code> flag is <code>true</code>, it
 * indicates that this method is being called because the previously
 * loaded resource bundle has expired.
 *
 * <p>The default implementation instantiates a
 * <code>ResourceBundle</code> as follows.
 *
 * <ul>
 *
 * <li>The bundle name is obtained by calling {@link
 * #toBundleName(String, Locale) toBundleName(baseName,
 * locale)}.</li>
 *
 * <li>If <code>format</code> is <code>"java.class"</code>, the
 * {@link Class} specified by the bundle name is loaded by calling
 * {@link ClassLoader#loadClass(String)}. Then, a
 * <code>ResourceBundle</code> is instantiated by calling {@link
 * Class#newInstance()}.  Note that the <code>reload</code> flag is
 * ignored for loading class-based resource bundles in this default
 * implementation.</li>
 *
 * <li>If <code>format</code> is <code>"java.properties"</code>,
 * {@link #toResourceName(String, String) toResourceName(bundlename,
 * "properties")} is called to get the resource name.
 * If <code>reload</code> is <code>true</code>, {@link
 * ClassLoader#getResource(String) load.getResource} is called
 * to get a {@link URL} for creating a {@link
 * URLConnection}. This <code>URLConnection</code> is used to
 * {@linkplain URLConnection#setUseCaches(boolean) disable the
 * caches} of the underlying resource loading layers,
 * and to {@linkplain URLConnection#getInputStream() get an
 * <code>InputStream</code>}.
 * Otherwise, {@link ClassLoader#getResourceAsStream(String)
 * loader.getResourceAsStream} is called to get an {@link
 * InputStream}. Then, a {@link
 * PropertyResourceBundle} is constructed with the
 * <code>InputStream</code>.</li>
 *
 * <li>If <code>format</code> is neither <code>"java.class"</code>
 * nor <code>"java.properties"</code>, an
 * <code>IllegalArgumentException</code> is thrown.</li>
 *
 * </ul>
 *
 * @param baseName
 *        the base bundle name of the resource bundle, a fully
 *        qualified class name
 * @param locale
 *        the locale for which the resource bundle should be
 *        instantiated
 * @param format
 *        the resource bundle format to be loaded
 * @param loader
 *        the <code>ClassLoader</code> to use to load the bundle
 * @param reload
 *        the flag to indicate bundle reloading; <code>true</code>
 *        if reloading an expired resource bundle,
 *        <code>false</code> otherwise
 * @return the resource bundle instance,
 *        or <code>null</code> if none could be found.
 * @exception NullPointerException
 *        if <code>bundleName</code>, <code>locale</code>,
 *        <code>format</code>, or <code>loader</code> is
 *        <code>null</code>, or if <code>null</code> is returned by
 *        {@link #toBundleName(String, Locale) toBundleName}
 * @exception IllegalArgumentException
 *        if <code>format</code> is unknown, or if the resource
 *        found for the given parameters contains malformed data.
 * @exception ClassCastException
 *        if the loaded class cannot be cast to <code>ResourceBundle</code>
 * @exception IllegalAccessException
 *        if the class or its nullary constructor is not
 *        accessible.
 * @exception InstantiationException
 *        if the instantiation of a class fails for some other
 *        reason.
 * @exception ExceptionInInitializerError
 *        if the initialization provoked by this method fails.
 * @exception SecurityException
 *        If a security manager is present and creation of new
 *        instances is denied. See {@link Class#newInstance()}
 *        for details.
 * @exception IOException
 *        if an error occurred when reading resources using
 *        any I/O operations
 */

public java.util.ResourceBundle newBundle(java.lang.String baseName, java.util.Locale locale, java.lang.String format, java.lang.ClassLoader loader, boolean reload) throws java.io.IOException, java.lang.IllegalAccessException, java.lang.InstantiationException { throw new RuntimeException("Stub!"); }

/**
 * Returns the time-to-live (TTL) value for resource bundles that
 * are loaded under this
 * <code>ResourceBundle.Control</code>. Positive time-to-live values
 * specify the number of milliseconds a bundle can remain in the
 * cache without being validated against the source data from which
 * it was constructed. The value 0 indicates that a bundle must be
 * validated each time it is retrieved from the cache. {@link
 * #TTL_DONT_CACHE} specifies that loaded resource bundles are not
 * put in the cache. {@link #TTL_NO_EXPIRATION_CONTROL} specifies
 * that loaded resource bundles are put in the cache with no
 * expiration control.
 *
 * <p>The expiration affects only the bundle loading process by the
 * <code>ResourceBundle.getBundle</code> factory method.  That is,
 * if the factory method finds a resource bundle in the cache that
 * has expired, the factory method calls the {@link
 * #needsReload(String, Locale, String, ClassLoader, ResourceBundle,
 * long) needsReload} method to determine whether the resource
 * bundle needs to be reloaded. If <code>needsReload</code> returns
 * <code>true</code>, the cached resource bundle instance is removed
 * from the cache. Otherwise, the instance stays in the cache,
 * updated with the new TTL value returned by this method.
 *
 * <p>All cached resource bundles are subject to removal from the
 * cache due to memory constraints of the runtime environment.
 * Returning a large positive value doesn't mean to lock loaded
 * resource bundles in the cache.
 *
 * <p>The default implementation returns {@link #TTL_NO_EXPIRATION_CONTROL}.
 *
 * @param baseName
 *        the base name of the resource bundle for which the
 *        expiration value is specified.
 * @param locale
 *        the locale of the resource bundle for which the
 *        expiration value is specified.
 * @return the time (0 or a positive millisecond offset from the
 *        cached time) to get loaded bundles expired in the cache,
 *        {@link #TTL_NO_EXPIRATION_CONTROL} to disable the
 *        expiration control, or {@link #TTL_DONT_CACHE} to disable
 *        caching.
 * @exception NullPointerException
 *        if <code>baseName</code> or <code>locale</code> is
 *        <code>null</code>
 */

public long getTimeToLive(java.lang.String baseName, java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Determines if the expired <code>bundle</code> in the cache needs
 * to be reloaded based on the loading time given by
 * <code>loadTime</code> or some other criteria. The method returns
 * <code>true</code> if reloading is required; <code>false</code>
 * otherwise. <code>loadTime</code> is a millisecond offset since
 * the <a href="Calendar.html#Epoch"> <code>Calendar</code>
 * Epoch</a>.
 *
 * The calling <code>ResourceBundle.getBundle</code> factory method
 * calls this method on the <code>ResourceBundle.Control</code>
 * instance used for its current invocation, not on the instance
 * used in the invocation that originally loaded the resource
 * bundle.
 *
 * <p>The default implementation compares <code>loadTime</code> and
 * the last modified time of the source data of the resource
 * bundle. If it's determined that the source data has been modified
 * since <code>loadTime</code>, <code>true</code> is
 * returned. Otherwise, <code>false</code> is returned. This
 * implementation assumes that the given <code>format</code> is the
 * same string as its file suffix if it's not one of the default
 * formats, <code>"java.class"</code> or
 * <code>"java.properties"</code>.
 *
 * @param baseName
 *        the base bundle name of the resource bundle, a
 *        fully qualified class name
 * @param locale
 *        the locale for which the resource bundle
 *        should be instantiated
 * @param format
 *        the resource bundle format to be loaded
 * @param loader
 *        the <code>ClassLoader</code> to use to load the bundle
 * @param bundle
 *        the resource bundle instance that has been expired
 *        in the cache
 * @param loadTime
 *        the time when <code>bundle</code> was loaded and put
 *        in the cache
 * @return <code>true</code> if the expired bundle needs to be
 *        reloaded; <code>false</code> otherwise.
 * @exception NullPointerException
 *        if <code>baseName</code>, <code>locale</code>,
 *        <code>format</code>, <code>loader</code>, or
 *        <code>bundle</code> is <code>null</code>
 */

public boolean needsReload(java.lang.String baseName, java.util.Locale locale, java.lang.String format, java.lang.ClassLoader loader, java.util.ResourceBundle bundle, long loadTime) { throw new RuntimeException("Stub!"); }

/**
 * Converts the given <code>baseName</code> and <code>locale</code>
 * to the bundle name. This method is called from the default
 * implementation of the {@link #newBundle(String, Locale, String,
 * ClassLoader, boolean) newBundle} and {@link #needsReload(String,
 * Locale, String, ClassLoader, ResourceBundle, long) needsReload}
 * methods.
 *
 * <p>This implementation returns the following value:
 * <pre>
 *     baseName + "_" + language + "_" + script + "_" + country + "_" + variant
 * </pre>
 * where <code>language</code>, <code>script</code>, <code>country</code>,
 * and <code>variant</code> are the language, script, country, and variant
 * values of <code>locale</code>, respectively. Final component values that
 * are empty Strings are omitted along with the preceding '_'.  When the
 * script is empty, the script value is omitted along with the preceding '_'.
 * If all of the values are empty strings, then <code>baseName</code>
 * is returned.
 *
 * <p>For example, if <code>baseName</code> is
 * <code>"baseName"</code> and <code>locale</code> is
 * <code>Locale("ja",&nbsp;"",&nbsp;"XX")</code>, then
 * <code>"baseName_ja_&thinsp;_XX"</code> is returned. If the given
 * locale is <code>Locale("en")</code>, then
 * <code>"baseName_en"</code> is returned.
 *
 * <p>Overriding this method allows applications to use different
 * conventions in the organization and packaging of localized
 * resources.
 *
 * @param baseName
 *        the base name of the resource bundle, a fully
 *        qualified class name
 * @param locale
 *        the locale for which a resource bundle should be
 *        loaded
 * @return the bundle name for the resource bundle
 * @exception NullPointerException
 *        if <code>baseName</code> or <code>locale</code>
 *        is <code>null</code>
 */

public java.lang.String toBundleName(java.lang.String baseName, java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Converts the given <code>bundleName</code> to the form required
 * by the {@link ClassLoader#getResource ClassLoader.getResource}
 * method by replacing all occurrences of <code>'.'</code> in
 * <code>bundleName</code> with <code>'/'</code> and appending a
 * <code>'.'</code> and the given file <code>suffix</code>. For
 * example, if <code>bundleName</code> is
 * <code>"foo.bar.MyResources_ja_JP"</code> and <code>suffix</code>
 * is <code>"properties"</code>, then
 * <code>"foo/bar/MyResources_ja_JP.properties"</code> is returned.
 *
 * @param bundleName
 *        the bundle name
 * @param suffix
 *        the file type suffix
 * @return the converted resource name
 * @exception NullPointerException
 *         if <code>bundleName</code> or <code>suffix</code>
 *         is <code>null</code>
 */

public final java.lang.String toResourceName(java.lang.String bundleName, java.lang.String suffix) { throw new RuntimeException("Stub!"); }

/**
 * The class-only format <code>List</code> containing
 * <code>"java.class"</code>. This <code>List</code> is {@linkplain
 * Collections#unmodifiableList(List) unmodifiable}.
 *
 * @see #getFormats(String)
 */

public static final java.util.List<java.lang.String> FORMAT_CLASS;
static { FORMAT_CLASS = null; }

/**
 * The default format <code>List</code>, which contains the strings
 * <code>"java.class"</code> and <code>"java.properties"</code>, in
 * this order. This <code>List</code> is {@linkplain
 * Collections#unmodifiableList(List) unmodifiable}.
 *
 * @see #getFormats(String)
 */

public static final java.util.List<java.lang.String> FORMAT_DEFAULT;
static { FORMAT_DEFAULT = null; }

/**
 * The properties-only format <code>List</code> containing
 * <code>"java.properties"</code>. This <code>List</code> is
 * {@linkplain Collections#unmodifiableList(List) unmodifiable}.
 *
 * @see #getFormats(String)
 */

public static final java.util.List<java.lang.String> FORMAT_PROPERTIES;
static { FORMAT_PROPERTIES = null; }

/**
 * The time-to-live constant for not caching loaded resource bundle
 * instances.
 *
 * @see #getTimeToLive(String, Locale)
 */

public static final long TTL_DONT_CACHE = -1L; // 0xffffffffffffffffL

/**
 * The time-to-live constant for disabling the expiration control
 * for loaded resource bundle instances in the cache.
 *
 * @see #getTimeToLive(String, Locale)
 */

public static final long TTL_NO_EXPIRATION_CONTROL = -2L; // 0xfffffffffffffffeL
}

}

