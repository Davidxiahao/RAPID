/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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


package java.net;

import java.security.AccessControlContext;
import java.io.IOException;
import java.security.Permission;
import java.util.jar.Manifest;
import java.util.Enumeration;

/**
 * This class loader is used to load classes and resources from a search
 * path of URLs referring to both JAR files and directories. Any URL that
 * ends with a '/' is assumed to refer to a directory. Otherwise, the URL
 * is assumed to refer to a JAR file which will be opened as needed.
 * <p>
 * The AccessControlContext of the thread that created the instance of
 * URLClassLoader will be used when subsequently loading classes and
 * resources.
 * <p>
 * The classes that are loaded are by default granted permission only to
 * access the URLs specified when the URLClassLoader was created.
 *
 * @author  David Connelly
 * @since   1.2
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class URLClassLoader extends java.security.SecureClassLoader implements java.io.Closeable {

/**
 * Constructs a new URLClassLoader for the given URLs. The URLs will be
 * searched in the order specified for classes and resources after first
 * searching in the specified parent class loader. Any URL that ends with
 * a '/' is assumed to refer to a directory. Otherwise, the URL is assumed
 * to refer to a JAR file which will be downloaded and opened as needed.
 *
 * <p>If there is a security manager, this method first
 * calls the security manager's {@code checkCreateClassLoader} method
 * to ensure creation of a class loader is allowed.
 *
 * @param urls the URLs from which to load classes and resources
 * @param parent the parent class loader for delegation
 * @exception  SecurityException  if a security manager exists and its
 *             {@code checkCreateClassLoader} method doesn't allow
 *             creation of a class loader.
 * @exception  NullPointerException if {@code urls} is {@code null}.
 * @see SecurityManager#checkCreateClassLoader
 */

public URLClassLoader(java.net.URL[] urls, java.lang.ClassLoader parent) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new URLClassLoader for the specified URLs using the
 * default delegation parent {@code ClassLoader}. The URLs will
 * be searched in the order specified for classes and resources after
 * first searching in the parent class loader. Any URL that ends with
 * a '/' is assumed to refer to a directory. Otherwise, the URL is
 * assumed to refer to a JAR file which will be downloaded and opened
 * as needed.
 *
 * <p>If there is a security manager, this method first
 * calls the security manager's {@code checkCreateClassLoader} method
 * to ensure creation of a class loader is allowed.
 *
 * @param urls the URLs from which to load classes and resources
 *
 * @exception  SecurityException  if a security manager exists and its
 *             {@code checkCreateClassLoader} method doesn't allow
 *             creation of a class loader.
 * @exception  NullPointerException if {@code urls} is {@code null}.
 * @see SecurityManager#checkCreateClassLoader
 */

public URLClassLoader(java.net.URL[] urls) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a new URLClassLoader for the specified URLs, parent
 * class loader, and URLStreamHandlerFactory. The parent argument
 * will be used as the parent class loader for delegation. The
 * factory argument will be used as the stream handler factory to
 * obtain protocol handlers when creating new jar URLs.
 *
 * <p>If there is a security manager, this method first
 * calls the security manager's {@code checkCreateClassLoader} method
 * to ensure creation of a class loader is allowed.
 *
 * @param urls the URLs from which to load classes and resources
 * @param parent the parent class loader for delegation
 * @param factory the URLStreamHandlerFactory to use when creating URLs
 *
 * @exception  SecurityException  if a security manager exists and its
 *             {@code checkCreateClassLoader} method doesn't allow
 *             creation of a class loader.
 * @exception  NullPointerException if {@code urls} is {@code null}.
 * @see SecurityManager#checkCreateClassLoader
 */

public URLClassLoader(java.net.URL[] urls, java.lang.ClassLoader parent, java.net.URLStreamHandlerFactory factory) { throw new RuntimeException("Stub!"); }

/**
 * Returns an input stream for reading the specified resource.
 * If this loader is closed, then any resources opened by this method
 * will be closed.
 *
 * <p> The search order is described in the documentation for {@link
 * #getResource(String)}.  </p>
 *
 * @param  name
 *         The resource name
 *
 * @return  An input stream for reading the resource, or {@code null}
 *          if the resource could not be found
 *
 * @since  1.7
 */

public java.io.InputStream getResourceAsStream(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Closes this URLClassLoader, so that it can no longer be used to load
 * new classes or resources that are defined by this loader.
 * Classes and resources defined by any of this loader's parents in the
 * delegation hierarchy are still accessible. Also, any classes or resources
 * that are already loaded, are still accessible.
 * <p>
 * In the case of jar: and file: URLs, it also closes any files
 * that were opened by it. If another thread is loading a
 * class when the {@code close} method is invoked, then the result of
 * that load is undefined.
 * <p>
 * The method makes a best effort attempt to close all opened files,
 * by catching {@link IOException}s internally. Unchecked exceptions
 * and errors are not caught. Calling close on an already closed
 * loader has no effect.
 * <p>
 * @exception IOException if closing any file opened by this class loader
 * resulted in an IOException. Any such exceptions are caught internally.
 * If only one is caught, then it is re-thrown. If more than one exception
 * is caught, then the second and following exceptions are added
 * as suppressed exceptions of the first one caught, which is then re-thrown.
 *
 * @exception SecurityException if a security manager is set, and it denies
 *   {@link RuntimePermission}{@code ("closeClassLoader")}
 *
 * @since 1.7
 */

public void close() throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Appends the specified URL to the list of URLs to search for
 * classes and resources.
 * <p>
 * If the URL specified is {@code null} or is already in the
 * list of URLs, or if this loader is closed, then invoking this
 * method has no effect.
 *
 * @param url the URL to be added to the search path of URLs
 */

protected void addURL(java.net.URL url) { throw new RuntimeException("Stub!"); }

/**
 * Returns the search path of URLs for loading classes and resources.
 * This includes the original list of URLs specified to the constructor,
 * along with any URLs subsequently appended by the addURL() method.
 * @return the search path of URLs for loading classes and resources.
 */

public java.net.URL[] getURLs() { throw new RuntimeException("Stub!"); }

/**
 * Finds and loads the class with the specified name from the URL search
 * path. Any URLs referring to JAR files are loaded and opened as needed
 * until the class is found.
 *
 * @param name the name of the class
 * @return the resulting class
 * @exception ClassNotFoundException if the class could not be found,
 *            or if the loader is closed.
 * @exception NullPointerException if {@code name} is {@code null}.
 */

protected java.lang.Class<?> findClass(java.lang.String name) throws java.lang.ClassNotFoundException { throw new RuntimeException("Stub!"); }

/**
 * Defines a new package by name in this ClassLoader. The attributes
 * contained in the specified Manifest will be used to obtain package
 * version and sealing information. For sealed packages, the additional
 * URL specifies the code source URL from which the package was loaded.
 *
 * @param name  the package name
 * @param man   the Manifest containing package version and sealing
 *              information
 * @param url   the code source url for the package, or null if none
 * @exception   IllegalArgumentException if the package name duplicates
 *              an existing package either in this class loader or one
 *              of its ancestors
 * @return the newly defined Package object
 */

protected java.lang.Package definePackage(java.lang.String name, java.util.jar.Manifest man, java.net.URL url) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Finds the resource with the specified name on the URL search path.
 *
 * @param name the name of the resource
 * @return a {@code URL} for the resource, or {@code null}
 * if the resource could not be found, or if the loader is closed.
 */

public java.net.URL findResource(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Returns an Enumeration of URLs representing all of the resources
 * on the URL search path having the specified name.
 *
 * @param name the resource name
 * @exception IOException if an I/O exception occurs
 * @return an {@code Enumeration} of {@code URL}s
 *         If the loader is closed, the Enumeration will be empty.
 */

public java.util.Enumeration<java.net.URL> findResources(java.lang.String name) throws java.io.IOException { throw new RuntimeException("Stub!"); }

/**
 * Returns the permissions for the given codesource object.
 * The implementation of this method first calls super.getPermissions
 * and then adds permissions based on the URL of the codesource.
 * <p>
 * If the protocol of this URL is "jar", then the permission granted
 * is based on the permission that is required by the URL of the Jar
 * file.
 * <p>
 * If the protocol is "file" and there is an authority component, then
 * permission to connect to and accept connections from that authority
 * may be granted. If the protocol is "file"
 * and the path specifies a file, then permission to read that
 * file is granted. If protocol is "file" and the path is
 * a directory, permission is granted to read all files
 * and (recursively) all files and subdirectories contained in
 * that directory.
 * <p>
 * If the protocol is not "file", then permission
 * to connect to and accept connections from the URL's host is granted.
 * @param codesource the codesource
 * @exception NullPointerException if {@code codesource} is {@code null}.
 * @return the permissions granted to the codesource
 */

protected java.security.PermissionCollection getPermissions(java.security.CodeSource codesource) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new instance of URLClassLoader for the specified
 * URLs and parent class loader. If a security manager is
 * installed, the {@code loadClass} method of the URLClassLoader
 * returned by this method will invoke the
 * {@code SecurityManager.checkPackageAccess} method before
 * loading the class.
 *
 * @param urls the URLs to search for classes and resources
 * @param parent the parent class loader for delegation
 * @exception  NullPointerException if {@code urls} is {@code null}.
 * @return the resulting class loader
 */

public static java.net.URLClassLoader newInstance(java.net.URL[] urls, java.lang.ClassLoader parent) { throw new RuntimeException("Stub!"); }

/**
 * Creates a new instance of URLClassLoader for the specified
 * URLs and default parent class loader. If a security manager is
 * installed, the {@code loadClass} method of the URLClassLoader
 * returned by this method will invoke the
 * {@code SecurityManager.checkPackageAccess} before
 * loading the class.
 *
 * @param urls the URLs to search for classes and resources
 * @exception  NullPointerException if {@code urls} is {@code null}.
 * @return the resulting class loader
 */

public static java.net.URLClassLoader newInstance(java.net.URL[] urls) { throw new RuntimeException("Stub!"); }
}

