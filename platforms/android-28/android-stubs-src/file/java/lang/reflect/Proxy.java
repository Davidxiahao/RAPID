/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.security.Permission;

/**
 * {@code Proxy} provides static methods for creating dynamic proxy
 * classes and instances, and it is also the superclass of all
 * dynamic proxy classes created by those methods.
 *
 * <p>To create a proxy for some interface {@code Foo}:
 * <pre>
 *     InvocationHandler handler = new MyInvocationHandler(...);
 *     Class&lt;?&gt; proxyClass = Proxy.getProxyClass(Foo.class.getClassLoader(), Foo.class);
 *     Foo f = (Foo) proxyClass.getConstructor(InvocationHandler.class).
 *                     newInstance(handler);
 * </pre>
 * or more simply:
 * <pre>
 *     Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
 *                                          new Class&lt;?&gt;[] { Foo.class },
 *                                          handler);
 * </pre>
 *
 * <p>A <i>dynamic proxy class</i> (simply referred to as a <i>proxy
 * class</i> below) is a class that implements a list of interfaces
 * specified at runtime when the class is created, with behavior as
 * described below.
 *
 * A <i>proxy interface</i> is such an interface that is implemented
 * by a proxy class.
 *
 * A <i>proxy instance</i> is an instance of a proxy class.
 *
 * Each proxy instance has an associated <i>invocation handler</i>
 * object, which implements the interface {@link InvocationHandler}.
 * A method invocation on a proxy instance through one of its proxy
 * interfaces will be dispatched to the {@link InvocationHandler#invoke
 * invoke} method of the instance's invocation handler, passing the proxy
 * instance, a {@code java.lang.reflect.Method} object identifying
 * the method that was invoked, and an array of type {@code Object}
 * containing the arguments.  The invocation handler processes the
 * encoded method invocation as appropriate and the result that it
 * returns will be returned as the result of the method invocation on
 * the proxy instance.
 *
 * <p>A proxy class has the following properties:
 *
 * <ul>
 * <li>Proxy classes are <em>public, final, and not abstract</em> if
 * all proxy interfaces are public.</li>
 *
 * <li>Proxy classes are <em>non-public, final, and not abstract</em> if
 * any of the proxy interfaces is non-public.</li>
 *
 * <li>The unqualified name of a proxy class is unspecified.  The space
 * of class names that begin with the string {@code "$Proxy"}
 * should be, however, reserved for proxy classes.
 *
 * <li>A proxy class extends {@code java.lang.reflect.Proxy}.
 *
 * <li>A proxy class implements exactly the interfaces specified at its
 * creation, in the same order.
 *
 * <li>If a proxy class implements a non-public interface, then it will
 * be defined in the same package as that interface.  Otherwise, the
 * package of a proxy class is also unspecified.  Note that package
 * sealing will not prevent a proxy class from being successfully defined
 * in a particular package at runtime, and neither will classes already
 * defined by the same class loader and the same package with particular
 * signers.
 *
 * <li>Since a proxy class implements all of the interfaces specified at
 * its creation, invoking {@code getInterfaces} on its
 * {@code Class} object will return an array containing the same
 * list of interfaces (in the order specified at its creation), invoking
 * {@code getMethods} on its {@code Class} object will return
 * an array of {@code Method} objects that include all of the
 * methods in those interfaces, and invoking {@code getMethod} will
 * find methods in the proxy interfaces as would be expected.
 *
 * <li>The {@link Proxy#isProxyClass Proxy.isProxyClass} method will
 * return true if it is passed a proxy class-- a class returned by
 * {@code Proxy.getProxyClass} or the class of an object returned by
 * {@code Proxy.newProxyInstance}-- and false otherwise.
 *
 * <li>The {@code java.security.ProtectionDomain} of a proxy class
 * is the same as that of system classes loaded by the bootstrap class
 * loader, such as {@code java.lang.Object}, because the code for a
 * proxy class is generated by trusted system code.  This protection
 * domain will typically be granted
 * {@code java.security.AllPermission}.
 *
 * <li>Each proxy class has one public constructor that takes one argument,
 * an implementation of the interface {@link InvocationHandler}, to set
 * the invocation handler for a proxy instance.  Rather than having to use
 * the reflection API to access the public constructor, a proxy instance
 * can be also be created by calling the {@link Proxy#newProxyInstance
 * Proxy.newProxyInstance} method, which combines the actions of calling
 * {@link Proxy#getProxyClass Proxy.getProxyClass} with invoking the
 * constructor with an invocation handler.
 * </ul>
 *
 * <p>A proxy instance has the following properties:
 *
 * <ul>
 * <li>Given a proxy instance {@code proxy} and one of the
 * interfaces implemented by its proxy class {@code Foo}, the
 * following expression will return true:
 * <pre>
 *     {@code proxy instanceof Foo}
 * </pre>
 * and the following cast operation will succeed (rather than throwing
 * a {@code ClassCastException}):
 * <pre>
 *     {@code (Foo) proxy}
 * </pre>
 *
 * <li>Each proxy instance has an associated invocation handler, the one
 * that was passed to its constructor.  The static
 * {@link Proxy#getInvocationHandler Proxy.getInvocationHandler} method
 * will return the invocation handler associated with the proxy instance
 * passed as its argument.
 *
 * <li>An interface method invocation on a proxy instance will be
 * encoded and dispatched to the invocation handler's {@link
 * InvocationHandler#invoke invoke} method as described in the
 * documentation for that method.
 *
 * <li>An invocation of the {@code hashCode},
 * {@code equals}, or {@code toString} methods declared in
 * {@code java.lang.Object} on a proxy instance will be encoded and
 * dispatched to the invocation handler's {@code invoke} method in
 * the same manner as interface method invocations are encoded and
 * dispatched, as described above.  The declaring class of the
 * {@code Method} object passed to {@code invoke} will be
 * {@code java.lang.Object}.  Other public methods of a proxy
 * instance inherited from {@code java.lang.Object} are not
 * overridden by a proxy class, so invocations of those methods behave
 * like they do for instances of {@code java.lang.Object}.
 * </ul>
 *
 * <h3>Methods Duplicated in Multiple Proxy Interfaces</h3>
 *
 * <p>When two or more interfaces of a proxy class contain a method with
 * the same name and parameter signature, the order of the proxy class's
 * interfaces becomes significant.  When such a <i>duplicate method</i>
 * is invoked on a proxy instance, the {@code Method} object passed
 * to the invocation handler will not necessarily be the one whose
 * declaring class is assignable from the reference type of the interface
 * that the proxy's method was invoked through.  This limitation exists
 * because the corresponding method implementation in the generated proxy
 * class cannot determine which interface it was invoked through.
 * Therefore, when a duplicate method is invoked on a proxy instance,
 * the {@code Method} object for the method in the foremost interface
 * that contains the method (either directly or inherited through a
 * superinterface) in the proxy class's list of interfaces is passed to
 * the invocation handler's {@code invoke} method, regardless of the
 * reference type through which the method invocation occurred.
 *
 * <p>If a proxy interface contains a method with the same name and
 * parameter signature as the {@code hashCode}, {@code equals},
 * or {@code toString} methods of {@code java.lang.Object},
 * when such a method is invoked on a proxy instance, the
 * {@code Method} object passed to the invocation handler will have
 * {@code java.lang.Object} as its declaring class.  In other words,
 * the public, non-final methods of {@code java.lang.Object}
 * logically precede all of the proxy interfaces for the determination of
 * which {@code Method} object to pass to the invocation handler.
 *
 * <p>Note also that when a duplicate method is dispatched to an
 * invocation handler, the {@code invoke} method may only throw
 * checked exception types that are assignable to one of the exception
 * types in the {@code throws} clause of the method in <i>all</i> of
 * the proxy interfaces that it can be invoked through.  If the
 * {@code invoke} method throws a checked exception that is not
 * assignable to any of the exception types declared by the method in one
 * of the proxy interfaces that it can be invoked through, then an
 * unchecked {@code UndeclaredThrowableException} will be thrown by
 * the invocation on the proxy instance.  This restriction means that not
 * all of the exception types returned by invoking
 * {@code getExceptionTypes} on the {@code Method} object
 * passed to the {@code invoke} method can necessarily be thrown
 * successfully by the {@code invoke} method.
 *
 * @author      Peter Jones
 * @see         InvocationHandler
 * @since       1.3
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Proxy implements java.io.Serializable {

/**
 * Constructs a new {@code Proxy} instance from a subclass
 * (typically, a dynamic proxy class) with the specified value
 * for its invocation handler.
 *
 * @param  h the invocation handler for this proxy instance
 *
 * @throws NullPointerException if the given invocation handler, {@code h},
 *         is {@code null}.
 */

protected Proxy(java.lang.reflect.InvocationHandler h) { throw new RuntimeException("Stub!"); }

/**
 * Returns the {@code java.lang.Class} object for a proxy class
 * given a class loader and an array of interfaces.  The proxy class
 * will be defined by the specified class loader and will implement
 * all of the supplied interfaces.  If any of the given interfaces
 * is non-public, the proxy class will be non-public. If a proxy class
 * for the same permutation of interfaces has already been defined by the
 * class loader, then the existing proxy class will be returned; otherwise,
 * a proxy class for those interfaces will be generated dynamically
 * and defined by the class loader.
 *
 * <p>There are several restrictions on the parameters that may be
 * passed to {@code Proxy.getProxyClass}:
 *
 * <ul>
 * <li>All of the {@code Class} objects in the
 * {@code interfaces} array must represent interfaces, not
 * classes or primitive types.
 *
 * <li>No two elements in the {@code interfaces} array may
 * refer to identical {@code Class} objects.
 *
 * <li>All of the interface types must be visible by name through the
 * specified class loader.  In other words, for class loader
 * {@code cl} and every interface {@code i}, the following
 * expression must be true:
 * <pre>
 *     Class.forName(i.getName(), false, cl) == i
 * </pre>
 *
 * <li>All non-public interfaces must be in the same package;
 * otherwise, it would not be possible for the proxy class to
 * implement all of the interfaces, regardless of what package it is
 * defined in.
 *
 * <li>For any set of member methods of the specified interfaces
 * that have the same signature:
 * <ul>
 * <li>If the return type of any of the methods is a primitive
 * type or void, then all of the methods must have that same
 * return type.
 * <li>Otherwise, one of the methods must have a return type that
 * is assignable to all of the return types of the rest of the
 * methods.
 * </ul>
 *
 * <li>The resulting proxy class must not exceed any limits imposed
 * on classes by the virtual machine.  For example, the VM may limit
 * the number of interfaces that a class may implement to 65535; in
 * that case, the size of the {@code interfaces} array must not
 * exceed 65535.
 * </ul>
 *
 * <p>If any of these restrictions are violated,
 * {@code Proxy.getProxyClass} will throw an
 * {@code IllegalArgumentException}.  If the {@code interfaces}
 * array argument or any of its elements are {@code null}, a
 * {@code NullPointerException} will be thrown.
 *
 * <p>Note that the order of the specified proxy interfaces is
 * significant: two requests for a proxy class with the same combination
 * of interfaces but in a different order will result in two distinct
 * proxy classes.
 *
 * @param   loader the class loader to define the proxy class
 * @param   interfaces the list of interfaces for the proxy class
 *          to implement
 * @return  a proxy class that is defined in the specified class loader
 *          and that implements the specified interfaces
 * @throws  IllegalArgumentException if any of the restrictions on the
 *          parameters that may be passed to {@code getProxyClass}
 *          are violated
 * @throws  SecurityException if a security manager, <em>s</em>, is present
 *          and any of the following conditions is met:
 *          <ul>
 *             <li> the given {@code loader} is {@code null} and
 *             the caller's class loader is not {@code null} and the
 *             invocation of {@link SecurityManager#checkPermission
 *             s.checkPermission} with
 *             {@code RuntimePermission("getClassLoader")} permission
 *             denies access.</li>
 *             <li> for each proxy interface, {@code intf},
 *             the caller's class loader is not the same as or an
 *             ancestor of the class loader for {@code intf} and
 *             invocation of {@link SecurityManager#checkPackageAccess
 *             s.checkPackageAccess()} denies access to {@code intf}.</li>
 *          </ul>
 * @throws  NullPointerException if the {@code interfaces} array
 *          argument or any of its elements are {@code null}
 */

@androidx.annotation.RecentlyNonNull public static java.lang.Class<?> getProxyClass(java.lang.ClassLoader loader, java.lang.Class<?>... interfaces) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns an instance of a proxy class for the specified interfaces
 * that dispatches method invocations to the specified invocation
 * handler.
 *
 * <p>{@code Proxy.newProxyInstance} throws
 * {@code IllegalArgumentException} for the same reasons that
 * {@code Proxy.getProxyClass} does.
 *
 * @param   loader the class loader to define the proxy class
 * @param   interfaces the list of interfaces for the proxy class
 *          to implement
 * @param   h the invocation handler to dispatch method invocations to
 * @return  a proxy instance with the specified invocation handler of a
 *          proxy class that is defined by the specified class loader
 *          and that implements the specified interfaces
 * @throws  IllegalArgumentException if any of the restrictions on the
 *          parameters that may be passed to {@code getProxyClass}
 *          are violated
 * @throws  SecurityException if a security manager, <em>s</em>, is present
 *          and any of the following conditions is met:
 *          <ul>
 *          <li> the given {@code loader} is {@code null} and
 *               the caller's class loader is not {@code null} and the
 *               invocation of {@link SecurityManager#checkPermission
 *               s.checkPermission} with
 *               {@code RuntimePermission("getClassLoader")} permission
 *               denies access;</li>
 *          <li> for each proxy interface, {@code intf},
 *               the caller's class loader is not the same as or an
 *               ancestor of the class loader for {@code intf} and
 *               invocation of {@link SecurityManager#checkPackageAccess
 *               s.checkPackageAccess()} denies access to {@code intf};</li>
 *          <li> any of the given proxy interfaces is non-public and the
 *               caller class is not in the same {@linkplain Package runtime package}
 *               as the non-public interface and the invocation of
 *               {@link SecurityManager#checkPermission s.checkPermission} with
 *               {@code ReflectPermission("newProxyInPackage.{package name}")}
 *               permission denies access.</li>
 *          </ul>
 * @throws  NullPointerException if the {@code interfaces} array
 *          argument or any of its elements are {@code null}, or
 *          if the invocation handler, {@code h}, is
 *          {@code null}
 */

@androidx.annotation.RecentlyNonNull public static java.lang.Object newProxyInstance(java.lang.ClassLoader loader, java.lang.Class<?>[] interfaces, java.lang.reflect.InvocationHandler h) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * Returns true if and only if the specified class was dynamically
 * generated to be a proxy class using the {@code getProxyClass}
 * method or the {@code newProxyInstance} method.
 *
 * <p>The reliability of this method is important for the ability
 * to use it to make security decisions, so its implementation should
 * not just test if the class in question extends {@code Proxy}.
 *
 * @param   cl the class to test
 * @return  {@code true} if the class is a proxy class and
 *          {@code false} otherwise
 * @throws  NullPointerException if {@code cl} is {@code null}
 */

public static boolean isProxyClass(java.lang.Class<?> cl) { throw new RuntimeException("Stub!"); }

/**
 * Returns the invocation handler for the specified proxy instance.
 *
 * @param   proxy the proxy instance to return the invocation handler for
 * @return  the invocation handler for the proxy instance
 * @throws  IllegalArgumentException if the argument is not a
 *          proxy instance
 * @throws  SecurityException if a security manager, <em>s</em>, is present
 *          and the caller's class loader is not the same as or an
 *          ancestor of the class loader for the invocation handler
 *          and invocation of {@link SecurityManager#checkPackageAccess
 *          s.checkPackageAccess()} denies access to the invocation
 *          handler's class.
 */

@androidx.annotation.RecentlyNonNull public static java.lang.reflect.InvocationHandler getInvocationHandler(java.lang.Object proxy) throws java.lang.IllegalArgumentException { throw new RuntimeException("Stub!"); }

/**
 * the invocation handler for this proxy instance.
 * @serial
 */

protected java.lang.reflect.InvocationHandler h;
}

