/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.lang.invoke;


/**
 * A {@code ConstantCallSite} is a {@link CallSite} whose target is permanent, and can never be changed.
 * An {@code invokedynamic} instruction linked to a {@code ConstantCallSite} is permanently
 * bound to the call site's target.
 * @author John Rose, JSR 292 EG
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class ConstantCallSite extends java.lang.invoke.CallSite {

/**
 * Creates a call site with a permanent target.
 * @param target the target to be permanently associated with this call site
 * @throws NullPointerException if the proposed target is null
 */

public ConstantCallSite(java.lang.invoke.MethodHandle target) { super(null); throw new RuntimeException("Stub!"); }

/**
 * Creates a call site with a permanent target, possibly bound to the call site itself.
 * <p>
 * During construction of the call site, the {@code createTargetHook} is invoked to
 * produce the actual target, as if by a call of the form
 * {@code (MethodHandle) createTargetHook.invoke(this)}.
 * <p>
 * Note that user code cannot perform such an action directly in a subclass constructor,
 * since the target must be fixed before the {@code ConstantCallSite} constructor returns.
 * <p>
 * The hook is said to bind the call site to a target method handle,
 * and a typical action would be {@code someTarget.bindTo(this)}.
 * However, the hook is free to take any action whatever,
 * including ignoring the call site and returning a constant target.
 * <p>
 * The result returned by the hook must be a method handle of exactly
 * the same type as the call site.
 * <p>
 * While the hook is being called, the new {@code ConstantCallSite}
 * object is in a partially constructed state.
 * In this state,
 * a call to {@code getTarget}, or any other attempt to use the target,
 * will result in an {@code IllegalStateException}.
 * It is legal at all times to obtain the call site's type using the {@code type} method.
 *
 * @param targetType the type of the method handle to be permanently associated with this call site
 * @param createTargetHook a method handle to invoke (on the call site) to produce the call site's target
 * @throws WrongMethodTypeException if the hook cannot be invoked on the required arguments,
 *         or if the target returned by the hook is not of the given {@code targetType}
 * @throws NullPointerException if the hook returns a null value
 * @throws ClassCastException if the hook returns something other than a {@code MethodHandle}
 * @throws Throwable anything else thrown by the hook function
 */

protected ConstantCallSite(java.lang.invoke.MethodType targetType, java.lang.invoke.MethodHandle createTargetHook) throws java.lang.Throwable { super(null); throw new RuntimeException("Stub!"); }

/**
 * Returns the target method of the call site, which behaves
 * like a {@code final} field of the {@code ConstantCallSite}.
 * That is, the target is always the original value passed
 * to the constructor call which created this instance.
 *
 * @return the immutable linkage state of this call site, a constant method handle
 * @throws IllegalStateException if the {@code ConstantCallSite} constructor has not completed
 */

public final java.lang.invoke.MethodHandle getTarget() { throw new RuntimeException("Stub!"); }

/**
 * Always throws an {@link UnsupportedOperationException}.
 * This kind of call site cannot change its target.
 * @param ignore a new target proposed for the call site, which is ignored
 * @throws UnsupportedOperationException because this kind of call site cannot change its target
 */

public final void setTarget(java.lang.invoke.MethodHandle ignore) { throw new RuntimeException("Stub!"); }

/**
 * Returns this call site's permanent target.
 * Since that target will never change, this is a correct implementation
 * of {@link CallSite#dynamicInvoker CallSite.dynamicInvoker}.
 * @return the immutable linkage state of this call site, a constant method handle
 * @throws IllegalStateException if the {@code ConstantCallSite} constructor has not completed
 */

public final java.lang.invoke.MethodHandle dynamicInvoker() { throw new RuntimeException("Stub!"); }
}

