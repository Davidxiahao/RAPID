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


package java.lang.reflect;


/**
 * {@code Constructor} provides information about, and access to, a single
 * constructor for a class.
 *
 * <p>{@code Constructor} permits widening conversions to occur when matching the
 * actual parameters to newInstance() with the underlying
 * constructor's formal parameters, but throws an
 * {@code IllegalArgumentException} if a narrowing conversion would occur.
 *
 * @param <T> the class in which the constructor is declared
 *
 * @see Member
 * @see java.lang.Class
 * @see java.lang.Class#getConstructors()
 * @see java.lang.Class#getConstructor(Class[])
 * @see java.lang.Class#getDeclaredConstructors()
 *
 * @author      Kenneth Russell
 * @author      Nakul Saraiya
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Constructor<T> extends java.lang.reflect.Executable {

Constructor() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

@androidx.annotation.RecentlyNonNull public java.lang.Class<T> getDeclaringClass() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of this constructor, as a string.  This is
 * the binary name of the constructor's declaring class.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public int getModifiers() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws GenericSignatureFormatError {@inheritDoc}
 * @since 1.5
 */

public java.lang.reflect.TypeVariable<java.lang.reflect.Constructor<T>>[] getTypeParameters() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

@androidx.annotation.RecentlyNonNull public java.lang.Class<?>[] getParameterTypes() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @since 1.8
 */

public int getParameterCount() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws GenericSignatureFormatError {@inheritDoc}
 * @throws TypeNotPresentException {@inheritDoc}
 * @throws MalformedParameterizedTypeException {@inheritDoc}
 * @since 1.5
 */

public java.lang.reflect.Type[] getGenericParameterTypes() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

public native java.lang.Class<?>[] getExceptionTypes();

/**
 * {@inheritDoc}
 * @throws GenericSignatureFormatError {@inheritDoc}
 * @throws TypeNotPresentException {@inheritDoc}
 * @throws MalformedParameterizedTypeException {@inheritDoc}
 * @since 1.5
 */

public java.lang.reflect.Type[] getGenericExceptionTypes() { throw new RuntimeException("Stub!"); }

/**
 * Compares this {@code Constructor} against the specified object.
 * Returns true if the objects are the same.  Two {@code Constructor} objects are
 * the same if they were declared by the same class and have the
 * same formal parameter types.
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hashcode for this {@code Constructor}. The hashcode is
 * the same as the hashcode for the underlying constructor's
 * declaring class name.
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing this {@code Constructor}.  The string is
 * formatted as the constructor access modifiers, if any,
 * followed by the fully-qualified name of the declaring class,
 * followed by a parenthesized, comma-separated list of the
 * constructor's formal parameter types.  For example:
 * <pre>
 *    public java.util.Hashtable(int,float)
 * </pre>
 *
 * <p>The only possible modifiers for constructors are the access
 * modifiers {@code public}, {@code protected} or
 * {@code private}.  Only one of these may appear, or none if the
 * constructor has default (package) access.
 *
 * @return a string describing this {@code Constructor}
 * @jls 8.8.3. Constructor Modifiers
 */

@androidx.annotation.RecentlyNonNull public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing this {@code Constructor},
 * including type parameters.  The string is formatted as the
 * constructor access modifiers, if any, followed by an
 * angle-bracketed comma separated list of the constructor's type
 * parameters, if any, followed by the fully-qualified name of the
 * declaring class, followed by a parenthesized, comma-separated
 * list of the constructor's generic formal parameter types.
 *
 * If this constructor was declared to take a variable number of
 * arguments, instead of denoting the last parameter as
 * "<tt><i>Type</i>[]</tt>", it is denoted as
 * "<tt><i>Type</i>...</tt>".
 *
 * A space is used to separate access modifiers from one another
 * and from the type parameters or return type.  If there are no
 * type parameters, the type parameter list is elided; if the type
 * parameter list is present, a space separates the list from the
 * class name.  If the constructor is declared to throw
 * exceptions, the parameter list is followed by a space, followed
 * by the word "{@code throws}" followed by a
 * comma-separated list of the thrown exception types.
 *
 * <p>The only possible modifiers for constructors are the access
 * modifiers {@code public}, {@code protected} or
 * {@code private}.  Only one of these may appear, or none if the
 * constructor has default (package) access.
 *
 * @return a string describing this {@code Constructor},
 * include type parameters
 *
 * @since 1.5
 * @jls 8.8.3. Constructor Modifiers
 */

@androidx.annotation.RecentlyNonNull public java.lang.String toGenericString() { throw new RuntimeException("Stub!"); }

/**
 * Uses the constructor represented by this {@code Constructor} object to
 * create and initialize a new instance of the constructor's
 * declaring class, with the specified initialization parameters.
 * Individual parameters are automatically unwrapped to match
 * primitive formal parameters, and both primitive and reference
 * parameters are subject to method invocation conversions as necessary.
 *
 * <p>If the number of formal parameters required by the underlying constructor
 * is 0, the supplied {@code initargs} array may be of length 0 or null.
 *
 * <p>If the constructor's declaring class is an inner class in a
 * non-static context, the first argument to the constructor needs
 * to be the enclosing instance; see section 15.9.3 of
 * <cite>The Java&trade; Language Specification</cite>.
 *
 * <p>If the required access and argument checks succeed and the
 * instantiation will proceed, the constructor's declaring class
 * is initialized if it has not already been initialized.
 *
 * <p>If the constructor completes normally, returns the newly
 * created and initialized instance.
 *
 * @param initargs array of objects to be passed as arguments to
 * the constructor call; values of primitive types are wrapped in
 * a wrapper object of the appropriate type (e.g. a {@code float}
 * in a {@link java.lang.Float Float})
 *
 * @return a new object created by calling the constructor
 * this object represents
 *
 * @exception IllegalAccessException    if this {@code Constructor} object
 *              is enforcing Java language access control and the underlying
 *              constructor is inaccessible.
 * @exception IllegalArgumentException  if the number of actual
 *              and formal parameters differ; if an unwrapping
 *              conversion for primitive arguments fails; or if,
 *              after possible unwrapping, a parameter value
 *              cannot be converted to the corresponding formal
 *              parameter type by a method invocation conversion; if
 *              this constructor pertains to an enum type.
 * @exception InstantiationException    if the class that declares the
 *              underlying constructor represents an abstract class.
 * @exception InvocationTargetException if the underlying constructor
 *              throws an exception.
 * @exception ExceptionInInitializerError if the initialization provoked
 *              by this method fails.
 */

@androidx.annotation.RecentlyNonNull public T newInstance(java.lang.Object... initargs) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @since 1.5
 */

public boolean isVarArgs() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @jls 13.1 The Form of a Binary
 * @since 1.5
 */

public boolean isSynthetic() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException  {@inheritDoc}
 * @since 1.5
 */

public <T extends java.lang.annotation.Annotation> T getAnnotation(java.lang.Class<T> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @since 1.5
 */

public java.lang.annotation.Annotation[] getDeclaredAnnotations() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @since 1.5
 */

public java.lang.annotation.Annotation[][] getParameterAnnotations() { throw new RuntimeException("Stub!"); }
}

