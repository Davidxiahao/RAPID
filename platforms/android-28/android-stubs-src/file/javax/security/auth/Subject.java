/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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


package javax.security.auth;

import java.security.DomainCombiner;
import java.security.Principal;
import java.security.Permission;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;

/**
 * <p> A {@code Subject} represents a grouping of related information
 * for a single entity, such as a person.
 * Such information includes the Subject's identities as well as
 * its security-related attributes
 * (passwords and cryptographic keys, for example).
 *
 * <p> Subjects may potentially have multiple identities.
 * Each identity is represented as a {@code Principal}
 * within the {@code Subject}.  Principals simply bind names to a
 * {@code Subject}.  For example, a {@code Subject} that happens
 * to be a person, Alice, might have two Principals:
 * one which binds "Alice Bar", the name on her driver license,
 * to the {@code Subject}, and another which binds,
 * "999-99-9999", the number on her student identification card,
 * to the {@code Subject}.  Both Principals refer to the same
 * {@code Subject} even though each has a different name.
 *
 * <p> A {@code Subject} may also own security-related attributes,
 * which are referred to as credentials.
 * Sensitive credentials that require special protection, such as
 * private cryptographic keys, are stored within a private credential
 * {@code Set}.  Credentials intended to be shared, such as
 * public key certificates or Kerberos server tickets are stored
 * within a public credential {@code Set}.  Different permissions
 * are required to access and modify the different credential Sets.
 *
 * <p> To retrieve all the Principals associated with a {@code Subject},
 * invoke the {@code getPrincipals} method.  To retrieve
 * all the public or private credentials belonging to a {@code Subject},
 * invoke the {@code getPublicCredentials} method or
 * {@code getPrivateCredentials} method, respectively.
 * To modify the returned {@code Set} of Principals and credentials,
 * use the methods defined in the {@code Set} class.
 * For example:
 * <pre>
 *      Subject subject;
 *      Principal principal;
 *      Object credential;
 *
 *      // add a Principal and credential to the Subject
 *      subject.getPrincipals().add(principal);
 *      subject.getPublicCredentials().add(credential);
 * </pre>
 *
 * <p> This {@code Subject} class implements {@code Serializable}.
 * While the Principals associated with the {@code Subject} are serialized,
 * the credentials associated with the {@code Subject} are not.
 * Note that the {@code java.security.Principal} class
 * does not implement {@code Serializable}.  Therefore all concrete
 * {@code Principal} implementations associated with Subjects
 * must implement {@code Serializable}.
 *
 * @see java.security.Principal
 * @see java.security.DomainCombiner
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Subject implements java.io.Serializable {

/**
 * Create an instance of a {@code Subject}
 * with an empty {@code Set} of Principals and empty
 * Sets of public and private credentials.
 *
 * <p> The newly constructed Sets check whether this {@code Subject}
 * has been set read-only before permitting subsequent modifications.
 * The newly created Sets also prevent illegal modifications
 * by ensuring that callers have sufficient permissions.
 *
 * <p> To modify the Principals Set, the caller must have
 * {@code AuthPermission("modifyPrincipals")}.
 * To modify the public credential Set, the caller must have
 * {@code AuthPermission("modifyPublicCredentials")}.
 * To modify the private credential Set, the caller must have
 * {@code AuthPermission("modifyPrivateCredentials")}.
 */

public Subject() { throw new RuntimeException("Stub!"); }

/**
 * Create an instance of a {@code Subject} with
 * Principals and credentials.
 *
 * <p> The Principals and credentials from the specified Sets
 * are copied into newly constructed Sets.
 * These newly created Sets check whether this {@code Subject}
 * has been set read-only before permitting subsequent modifications.
 * The newly created Sets also prevent illegal modifications
 * by ensuring that callers have sufficient permissions.
 *
 * <p> To modify the Principals Set, the caller must have
 * {@code AuthPermission("modifyPrincipals")}.
 * To modify the public credential Set, the caller must have
 * {@code AuthPermission("modifyPublicCredentials")}.
 * To modify the private credential Set, the caller must have
 * {@code AuthPermission("modifyPrivateCredentials")}.
 * <p>
 *
 * @param readOnly true if the {@code Subject} is to be read-only,
 *          and false otherwise. <p>
 *
 * @param principals the {@code Set} of Principals
 *          to be associated with this {@code Subject}. <p>
 *
 * @param pubCredentials the {@code Set} of public credentials
 *          to be associated with this {@code Subject}. <p>
 *
 * @param privCredentials the {@code Set} of private credentials
 *          to be associated with this {@code Subject}.
 *
 * @exception NullPointerException if the specified
 *          {@code principals}, {@code pubCredentials},
 *          or {@code privCredentials} are {@code null}.
 */

public Subject(boolean readOnly, java.util.Set<? extends java.security.Principal> principals, java.util.Set<?> pubCredentials, java.util.Set<?> privCredentials) { throw new RuntimeException("Stub!"); }

/**
 * Set this {@code Subject} to be read-only.
 *
 * <p> Modifications (additions and removals) to this Subject's
 * {@code Principal} {@code Set} and
 * credential Sets will be disallowed.
 * The {@code destroy} operation on this Subject's credentials will
 * still be permitted.
 *
 * <p> Subsequent attempts to modify the Subject's {@code Principal}
 * and credential Sets will result in an
 * {@code IllegalStateException} being thrown.
 * Also, once a {@code Subject} is read-only,
 * it can not be reset to being writable again.
 *
 * <p>
 *
 * @exception SecurityException if the caller does not have permission
 *          to set this {@code Subject} to be read-only.
 */

public void setReadOnly() { throw new RuntimeException("Stub!"); }

/**
 * Query whether this {@code Subject} is read-only.
 *
 * <p>
 *
 * @return true if this {@code Subject} is read-only, false otherwise.
 */

public boolean isReadOnly() { throw new RuntimeException("Stub!"); }

/**
 * Get the {@code Subject} associated with the provided
 * {@code AccessControlContext}.
 *
 * <p> The {@code AccessControlContext} may contain many
 * Subjects (from nested {@code doAs} calls).
 * In this situation, the most recent {@code Subject} associated
 * with the {@code AccessControlContext} is returned.
 *
 * <p>
 *
 * @param  acc the {@code AccessControlContext} from which to retrieve
 *          the {@code Subject}.
 *
 * @return  the {@code Subject} associated with the provided
 *          {@code AccessControlContext}, or {@code null}
 *          if no {@code Subject} is associated
 *          with the provided {@code AccessControlContext}.
 *
 * @exception SecurityException if the caller does not have permission
 *          to get the {@code Subject}. <p>
 *
 * @exception NullPointerException if the provided
 *          {@code AccessControlContext} is {@code null}.
 */

public static javax.security.auth.Subject getSubject(java.security.AccessControlContext acc) { throw new RuntimeException("Stub!"); }

/**
 * Perform work as a particular {@code Subject}.
 *
 * <p> This method first retrieves the current Thread's
 * {@code AccessControlContext} via
 * {@code AccessController.getContext},
 * and then instantiates a new {@code AccessControlContext}
 * using the retrieved context along with a new
 * {@code SubjectDomainCombiner} (constructed using
 * the provided {@code Subject}).
 * Finally, this method invokes {@code AccessController.doPrivileged},
 * passing it the provided {@code PrivilegedAction},
 * as well as the newly constructed {@code AccessControlContext}.
 *
 * <p>
 *
 * @param subject the {@code Subject} that the specified
 *                  {@code action} will run as.  This parameter
 *                  may be {@code null}. <p>
 *
 * @param <T> the type of the value returned by the PrivilegedAction's
 *                  {@code run} method.
 *
 * @param action the code to be run as the specified
 *                  {@code Subject}. <p>
 *
 * @return the value returned by the PrivilegedAction's
 *                  {@code run} method.
 *
 * @exception NullPointerException if the {@code PrivilegedAction}
 *                  is {@code null}. <p>
 *
 * @exception SecurityException if the caller does not have permission
 *                  to invoke this method.
 */

public static <T> T doAs(javax.security.auth.Subject subject, java.security.PrivilegedAction<T> action) { throw new RuntimeException("Stub!"); }

/**
 * Perform work as a particular {@code Subject}.
 *
 * <p> This method first retrieves the current Thread's
 * {@code AccessControlContext} via
 * {@code AccessController.getContext},
 * and then instantiates a new {@code AccessControlContext}
 * using the retrieved context along with a new
 * {@code SubjectDomainCombiner} (constructed using
 * the provided {@code Subject}).
 * Finally, this method invokes {@code AccessController.doPrivileged},
 * passing it the provided {@code PrivilegedExceptionAction},
 * as well as the newly constructed {@code AccessControlContext}.
 *
 * <p>
 *
 * @param subject the {@code Subject} that the specified
 *                  {@code action} will run as.  This parameter
 *                  may be {@code null}. <p>
 *
 * @param <T> the type of the value returned by the
 *                  PrivilegedExceptionAction's {@code run} method.
 *
 * @param action the code to be run as the specified
 *                  {@code Subject}. <p>
 *
 * @return the value returned by the
 *                  PrivilegedExceptionAction's {@code run} method.
 *
 * @exception PrivilegedActionException if the
 *                  {@code PrivilegedExceptionAction.run}
 *                  method throws a checked exception. <p>
 *
 * @exception NullPointerException if the specified
 *                  {@code PrivilegedExceptionAction} is
 *                  {@code null}. <p>
 *
 * @exception SecurityException if the caller does not have permission
 *                  to invoke this method.
 */

public static <T> T doAs(javax.security.auth.Subject subject, java.security.PrivilegedExceptionAction<T> action) throws java.security.PrivilegedActionException { throw new RuntimeException("Stub!"); }

/**
 * Perform privileged work as a particular {@code Subject}.
 *
 * <p> This method behaves exactly as {@code Subject.doAs},
 * except that instead of retrieving the current Thread's
 * {@code AccessControlContext}, it uses the provided
 * {@code AccessControlContext}.  If the provided
 * {@code AccessControlContext} is {@code null},
 * this method instantiates a new {@code AccessControlContext}
 * with an empty collection of ProtectionDomains.
 *
 * <p>
 *
 * @param subject the {@code Subject} that the specified
 *                  {@code action} will run as.  This parameter
 *                  may be {@code null}. <p>
 *
 * @param <T> the type of the value returned by the PrivilegedAction's
 *                  {@code run} method.
 *
 * @param action the code to be run as the specified
 *                  {@code Subject}. <p>
 *
 * @param acc the {@code AccessControlContext} to be tied to the
 *                  specified <i>subject</i> and <i>action</i>. <p>
 *
 * @return the value returned by the PrivilegedAction's
 *                  {@code run} method.
 *
 * @exception NullPointerException if the {@code PrivilegedAction}
 *                  is {@code null}. <p>
 *
 * @exception SecurityException if the caller does not have permission
 *                  to invoke this method.
 */

public static <T> T doAsPrivileged(javax.security.auth.Subject subject, java.security.PrivilegedAction<T> action, java.security.AccessControlContext acc) { throw new RuntimeException("Stub!"); }

/**
 * Perform privileged work as a particular {@code Subject}.
 *
 * <p> This method behaves exactly as {@code Subject.doAs},
 * except that instead of retrieving the current Thread's
 * {@code AccessControlContext}, it uses the provided
 * {@code AccessControlContext}.  If the provided
 * {@code AccessControlContext} is {@code null},
 * this method instantiates a new {@code AccessControlContext}
 * with an empty collection of ProtectionDomains.
 *
 * <p>
 *
 * @param subject the {@code Subject} that the specified
 *                  {@code action} will run as.  This parameter
 *                  may be {@code null}. <p>
 *
 * @param <T> the type of the value returned by the
 *                  PrivilegedExceptionAction's {@code run} method.
 *
 * @param action the code to be run as the specified
 *                  {@code Subject}. <p>
 *
 * @param acc the {@code AccessControlContext} to be tied to the
 *                  specified <i>subject</i> and <i>action</i>. <p>
 *
 * @return the value returned by the
 *                  PrivilegedExceptionAction's {@code run} method.
 *
 * @exception PrivilegedActionException if the
 *                  {@code PrivilegedExceptionAction.run}
 *                  method throws a checked exception. <p>
 *
 * @exception NullPointerException if the specified
 *                  {@code PrivilegedExceptionAction} is
 *                  {@code null}. <p>
 *
 * @exception SecurityException if the caller does not have permission
 *                  to invoke this method.
 */

public static <T> T doAsPrivileged(javax.security.auth.Subject subject, java.security.PrivilegedExceptionAction<T> action, java.security.AccessControlContext acc) throws java.security.PrivilegedActionException { throw new RuntimeException("Stub!"); }

/**
 * Return the {@code Set} of Principals associated with this
 * {@code Subject}.  Each {@code Principal} represents
 * an identity for this {@code Subject}.
 *
 * <p> The returned {@code Set} is backed by this Subject's
 * internal {@code Principal} {@code Set}.  Any modification
 * to the returned {@code Set} affects the internal
 * {@code Principal} {@code Set} as well.
 *
 * <p>
 *
 * @return  The {@code Set} of Principals associated with this
 *          {@code Subject}.
 */

public java.util.Set<java.security.Principal> getPrincipals() { throw new RuntimeException("Stub!"); }

/**
 * Return a {@code Set} of Principals associated with this
 * {@code Subject} that are instances or subclasses of the specified
 * {@code Class}.
 *
 * <p> The returned {@code Set} is not backed by this Subject's
 * internal {@code Principal} {@code Set}.  A new
 * {@code Set} is created and returned for each method invocation.
 * Modifications to the returned {@code Set}
 * will not affect the internal {@code Principal} {@code Set}.
 *
 * <p>
 *
 * @param <T> the type of the class modeled by {@code c}
 *
 * @param c the returned {@code Set} of Principals will all be
 *          instances of this class.
 *
 * @return a {@code Set} of Principals that are instances of the
 *          specified {@code Class}.
 *
 * @exception NullPointerException if the specified {@code Class}
 *                  is {@code null}.
 */

public <T extends java.security.Principal> java.util.Set<T> getPrincipals(java.lang.Class<T> c) { throw new RuntimeException("Stub!"); }

/**
 * Return the {@code Set} of public credentials held by this
 * {@code Subject}.
 *
 * <p> The returned {@code Set} is backed by this Subject's
 * internal public Credential {@code Set}.  Any modification
 * to the returned {@code Set} affects the internal public
 * Credential {@code Set} as well.
 *
 * <p>
 *
 * @return  A {@code Set} of public credentials held by this
 *          {@code Subject}.
 */

public java.util.Set<java.lang.Object> getPublicCredentials() { throw new RuntimeException("Stub!"); }

/**
 * Return the {@code Set} of private credentials held by this
 * {@code Subject}.
 *
 * <p> The returned {@code Set} is backed by this Subject's
 * internal private Credential {@code Set}.  Any modification
 * to the returned {@code Set} affects the internal private
 * Credential {@code Set} as well.
 *
 * <p> A caller requires permissions to access the Credentials
 * in the returned {@code Set}, or to modify the
 * {@code Set} itself.  A {@code SecurityException}
 * is thrown if the caller does not have the proper permissions.
 *
 * <p> While iterating through the {@code Set},
 * a {@code SecurityException} is thrown
 * if the caller does not have permission to access a
 * particular Credential.  The {@code Iterator}
 * is nevertheless advanced to next element in the {@code Set}.
 *
 * <p>
 *
 * @return  A {@code Set} of private credentials held by this
 *          {@code Subject}.
 */

public java.util.Set<java.lang.Object> getPrivateCredentials() { throw new RuntimeException("Stub!"); }

/**
 * Return a {@code Set} of public credentials associated with this
 * {@code Subject} that are instances or subclasses of the specified
 * {@code Class}.
 *
 * <p> The returned {@code Set} is not backed by this Subject's
 * internal public Credential {@code Set}.  A new
 * {@code Set} is created and returned for each method invocation.
 * Modifications to the returned {@code Set}
 * will not affect the internal public Credential {@code Set}.
 *
 * <p>
 *
 * @param <T> the type of the class modeled by {@code c}
 *
 * @param c the returned {@code Set} of public credentials will all be
 *          instances of this class.
 *
 * @return a {@code Set} of public credentials that are instances
 *          of the  specified {@code Class}.
 *
 * @exception NullPointerException if the specified {@code Class}
 *          is {@code null}.
 */

public <T> java.util.Set<T> getPublicCredentials(java.lang.Class<T> c) { throw new RuntimeException("Stub!"); }

/**
 * Return a {@code Set} of private credentials associated with this
 * {@code Subject} that are instances or subclasses of the specified
 * {@code Class}.
 *
 * <p> The caller must have permission to access all of the
 * requested Credentials, or a {@code SecurityException}
 * will be thrown.
 *
 * <p> The returned {@code Set} is not backed by this Subject's
 * internal private Credential {@code Set}.  A new
 * {@code Set} is created and returned for each method invocation.
 * Modifications to the returned {@code Set}
 * will not affect the internal private Credential {@code Set}.
 *
 * <p>
 *
 * @param <T> the type of the class modeled by {@code c}
 *
 * @param c the returned {@code Set} of private credentials will all be
 *          instances of this class.
 *
 * @return a {@code Set} of private credentials that are instances
 *          of the  specified {@code Class}.
 *
 * @exception NullPointerException if the specified {@code Class}
 *          is {@code null}.
 */

public <T> java.util.Set<T> getPrivateCredentials(java.lang.Class<T> c) { throw new RuntimeException("Stub!"); }

/**
 * Compares the specified Object with this {@code Subject}
 * for equality.  Returns true if the given object is also a Subject
 * and the two {@code Subject} instances are equivalent.
 * More formally, two {@code Subject} instances are
 * equal if their {@code Principal} and {@code Credential}
 * Sets are equal.
 *
 * <p>
 *
 * @param o Object to be compared for equality with this
 *          {@code Subject}.
 *
 * @return true if the specified Object is equal to this
 *          {@code Subject}.
 *
 * @exception SecurityException if the caller does not have permission
 *          to access the private credentials for this {@code Subject},
 *          or if the caller does not have permission to access the
 *          private credentials for the provided {@code Subject}.
 */

public boolean equals(java.lang.Object o) { throw new RuntimeException("Stub!"); }

/**
 * Return the String representation of this {@code Subject}.
 *
 * <p>
 *
 * @return the String representation of this {@code Subject}.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Returns a hashcode for this {@code Subject}.
 *
 * <p>
 *
 * @return a hashcode for this {@code Subject}.
 *
 * @exception SecurityException if the caller does not have permission
 *          to access this Subject's private credentials.
 */

public int hashCode() { throw new RuntimeException("Stub!"); }
}

