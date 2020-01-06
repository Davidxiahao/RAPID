/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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


package java.lang.reflect;


/**
 * The AccessibleObject class is the base class for Field, Method and
 * Constructor objects.  It provides the ability to flag a reflected
 * object as suppressing default Java language access control checks
 * when it is used.  The access checks--for public, default (package)
 * access, protected, and private members--are performed when Fields,
 * Methods or Constructors are used to set or get fields, to invoke
 * methods, or to create and initialize new instances of classes,
 * respectively.
 *
 * <p>Setting the {@code accessible} flag in a reflected object
 * permits sophisticated applications with sufficient privilege, such
 * as Java Object Serialization or other persistence mechanisms, to
 * manipulate objects in a manner that would normally be prohibited.
 *
 * <p>By default, a reflected object is <em>not</em> accessible.
 *
 * @see Field
 * @see Method
 * @see Constructor
 * @see ReflectPermission
 *
 * @since 1.2
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class AccessibleObject implements java.lang.reflect.AnnotatedElement {

/**
 * Constructor: only used by the Java Virtual Machine.
 */

protected AccessibleObject() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method to set the {@code accessible} flag for an
 * array of objects with a single security check (for efficiency).
 *
 * <p>First, if there is a security manager, its
 * {@code checkPermission} method is called with a
 * {@code ReflectPermission("suppressAccessChecks")} permission.
 *
 * <p>A {@code SecurityException} is raised if {@code flag} is
 * {@code true} but accessibility of any of the elements of the input
 * {@code array} may not be changed (for example, if the element
 * object is a {@link Constructor} object for the class {@link
 * java.lang.Class}).  In the event of such a SecurityException, the
 * accessibility of objects is set to {@code flag} for array elements
 * upto (and excluding) the element for which the exception occurred; the
 * accessibility of elements beyond (and including) the element for which
 * the exception occurred is unchanged.
 *
 * @param array the array of AccessibleObjects
 * @param flag  the new value for the {@code accessible} flag
 *              in each object
 * @throws SecurityException if the request is denied.
 * @see SecurityManager#checkPermission
 * @see java.lang.RuntimePermission
 */

public static void setAccessible(java.lang.reflect.AccessibleObject[] array, boolean flag) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Set the {@code accessible} flag for this object to
 * the indicated boolean value.  A value of {@code true} indicates that
 * the reflected object should suppress Java language access
 * checking when it is used.  A value of {@code false} indicates
 * that the reflected object should enforce Java language access checks.
 *
 * <p>First, if there is a security manager, its
 * {@code checkPermission} method is called with a
 * {@code ReflectPermission("suppressAccessChecks")} permission.
 *
 * <p>A {@code SecurityException} is raised if {@code flag} is
 * {@code true} but accessibility of this object may not be changed
 * (for example, if this element object is a {@link Constructor} object for
 * the class {@link java.lang.Class}).
 *
 * <p>A {@code SecurityException} is raised if this object is a {@link
 * java.lang.reflect.Constructor} object for the class
 * {@code java.lang.Class}, and {@code flag} is true.
 *
 * @param flag the new value for the {@code accessible} flag
 * @throws SecurityException if the request is denied.
 * @see SecurityManager#checkPermission
 * @see java.lang.RuntimePermission
 */

public void setAccessible(boolean flag) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Get the value of the {@code accessible} flag for this object.
 *
 * @return the value of the object's {@code accessible} flag
 */

public boolean isAccessible() { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 * @since 1.5
 */

public <T extends java.lang.annotation.Annotation> T getAnnotation(java.lang.Class<T> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException {@inheritDoc}
 * @since 1.5
 */

public boolean isAnnotationPresent(java.lang.Class<? extends java.lang.annotation.Annotation> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 * @since 1.8
 */

public <T extends java.lang.annotation.Annotation> T[] getAnnotationsByType(java.lang.Class<T> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * @since 1.5
 */

@androidx.annotation.RecentlyNonNull public java.lang.annotation.Annotation[] getAnnotations() { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 * @since 1.8
 */

public <T extends java.lang.annotation.Annotation> T getDeclaredAnnotation(java.lang.Class<T> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 * @since 1.8
 */

public <T extends java.lang.annotation.Annotation> T[] getDeclaredAnnotationsByType(java.lang.Class<T> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * @since 1.5
 */

@androidx.annotation.RecentlyNonNull public java.lang.annotation.Annotation[] getDeclaredAnnotations() { throw new RuntimeException("Stub!"); }
}

