/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Information about method parameters.
 *
 * A {@code Parameter} provides information about method parameters,
 * including its name and modifiers.  It also provides an alternate
 * means of obtaining attributes for the parameter.
 *
 * @since 1.8
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Parameter implements java.lang.reflect.AnnotatedElement {

/**
 * Package-private constructor for {@code Parameter}.
 *
 * If method parameter data is present in the classfile, then the
 * JVM creates {@code Parameter} objects directly.  If it is
 * absent, however, then {@code Executable} uses this constructor
 * to synthesize them.
 *
 * @param name The name of the parameter.
 * @param modifiers The modifier flags for the parameter.
 * @param executable The executable which defines this parameter.
 * @param index The index of the parameter.
 */

Parameter(java.lang.String name, int modifiers, java.lang.reflect.Executable executable, int index) { throw new RuntimeException("Stub!"); }

/**
 * Compares based on the executable and the index.
 *
 * @param obj The object to compare.
 * @return Whether or not this is equal to the argument.
 */

public boolean equals(java.lang.Object obj) { throw new RuntimeException("Stub!"); }

/**
 * Returns a hash code based on the executable's hash code and the
 * index.
 *
 * @return A hash code based on the executable's hash code.
 */

public int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Returns true if the parameter has a name; returns false otherwise.
 * Whether a parameter has a name is determined by compiler options
 * and whether the parameter is synthesized.
 *
 * @return true if and only if the parameter has a name
 */

public boolean isNamePresent() { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing this parameter.  The format is the
 * modifiers for the parameter, if any, in canonical order as
 * recommended by <cite>The Java&trade; Language
 * Specification</cite>, followed by the fully- qualified type of
 * the parameter (excluding the last [] if the parameter is
 * variable arity), followed by "..." if the parameter is variable
 * arity, followed by a space, followed by the name of the
 * parameter.
 *
 * @return A string representation of the parameter and associated
 * information.
 */

@androidx.annotation.RecentlyNonNull public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Return the {@code Executable} which declares this parameter.
 *
 * @return The {@code Executable} declaring this parameter.
 */

@androidx.annotation.RecentlyNonNull public java.lang.reflect.Executable getDeclaringExecutable() { throw new RuntimeException("Stub!"); }

/**
 * Get the modifier flags for this the parameter represented by
 * this {@code Parameter} object.
 *
 * @return The modifier flags for this parameter.
 */

public int getModifiers() { throw new RuntimeException("Stub!"); }

/**
 * Returns the name of the parameter.  If the parameter's name is
 * {@linkplain #isNamePresent() present}, then this method returns
 * the name provided by the class file. Otherwise, this method
 * synthesizes a name of the form argN, where N is the index of
 * the parameter in the descriptor of the method which declares
 * the parameter.
 *
 * @return The name of the parameter, either provided by the class
 *         file or synthesized if the class file does not provide
 *         a name.
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Type} object that identifies the parameterized
 * type for the parameter represented by this {@code Parameter}
 * object.
 *
 * @return a {@code Type} object identifying the parameterized
 * type of the parameter represented by this object
 */

@androidx.annotation.RecentlyNonNull public java.lang.reflect.Type getParameterizedType() { throw new RuntimeException("Stub!"); }

/**
 * Returns a {@code Class} object that identifies the
 * declared type for the parameter represented by this
 * {@code Parameter} object.
 *
 * @return a {@code Class} object identifying the declared
 * type of the parameter represented by this object
 */

@androidx.annotation.RecentlyNonNull public java.lang.Class<?> getType() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this parameter is implicitly declared
 * in source code; returns {@code false} otherwise.
 *
 * @return true if and only if this parameter is implicitly
 * declared as defined by <cite>The Java&trade; Language
 * Specification</cite>.
 */

public boolean isImplicit() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this parameter is neither implicitly
 * nor explicitly declared in source code; returns {@code false}
 * otherwise.
 *
 * @jls 13.1 The Form of a Binary
 * @return true if and only if this parameter is a synthetic
 * construct as defined by
 * <cite>The Java&trade; Language Specification</cite>.
 */

public boolean isSynthetic() { throw new RuntimeException("Stub!"); }

/**
 * Returns {@code true} if this parameter represents a variable
 * argument list; returns {@code false} otherwise.
 *
 * @return {@code true} if an only if this parameter represents a
 * variable argument list.
 */

public boolean isVarArgs() { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException {@inheritDoc}
 */

public <T extends java.lang.annotation.Annotation> T getAnnotation(java.lang.Class<T> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 * @throws NullPointerException {@inheritDoc}
 */

public <T extends java.lang.annotation.Annotation> T[] getAnnotationsByType(java.lang.Class<T> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

@androidx.annotation.RecentlyNonNull public java.lang.annotation.Annotation[] getDeclaredAnnotations() { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 */

public <T extends java.lang.annotation.Annotation> T getDeclaredAnnotation(java.lang.Class<T> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * @throws NullPointerException {@inheritDoc}
 */

public <T extends java.lang.annotation.Annotation> T[] getDeclaredAnnotationsByType(java.lang.Class<T> annotationClass) { throw new RuntimeException("Stub!"); }

/**
 * {@inheritDoc}
 */

@androidx.annotation.RecentlyNonNull public java.lang.annotation.Annotation[] getAnnotations() { throw new RuntimeException("Stub!"); }
}

