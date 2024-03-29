/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2000, 2014, Oracle and/or its affiliates. All rights reserved.
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



package java.util.logging;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Supplier;
import java.util.MissingResourceException;

/**
 * A Logger object is used to log messages for a specific
 * system or application component.  Loggers are normally named,
 * using a hierarchical dot-separated namespace.  Logger names
 * can be arbitrary strings, but they should normally be based on
 * the package name or class name of the logged component, such
 * as java.net or javax.swing.  In addition it is possible to create
 * "anonymous" Loggers that are not stored in the Logger namespace.
 * <p>
 * Logger objects may be obtained by calls on one of the getLogger
 * factory methods.  These will either create a new Logger or
 * return a suitable existing Logger. It is important to note that
 * the Logger returned by one of the {@code getLogger} factory methods
 * may be garbage collected at any time if a strong reference to the
 * Logger is not kept.
 * <p>
 * Logging messages will be forwarded to registered Handler
 * objects, which can forward the messages to a variety of
 * destinations, including consoles, files, OS logs, etc.
 * <p>
 * Each Logger keeps track of a "parent" Logger, which is its
 * nearest existing ancestor in the Logger namespace.
 * <p>
 * Each Logger has a "Level" associated with it.  This reflects
 * a minimum Level that this logger cares about.  If a Logger's
 * level is set to <tt>null</tt>, then its effective level is inherited
 * from its parent, which may in turn obtain it recursively from its
 * parent, and so on up the tree.
 * <p>
 * The log level can be configured based on the properties from the
 * logging configuration file, as described in the description
 * of the LogManager class.  However it may also be dynamically changed
 * by calls on the Logger.setLevel method.  If a logger's level is
 * changed the change may also affect child loggers, since any child
 * logger that has <tt>null</tt> as its level will inherit its
 * effective level from its parent.
 * <p>
 * On each logging call the Logger initially performs a cheap
 * check of the request level (e.g., SEVERE or FINE) against the
 * effective log level of the logger.  If the request level is
 * lower than the log level, the logging call returns immediately.
 * <p>
 * After passing this initial (cheap) test, the Logger will allocate
 * a LogRecord to describe the logging message.  It will then call a
 * Filter (if present) to do a more detailed check on whether the
 * record should be published.  If that passes it will then publish
 * the LogRecord to its output Handlers.  By default, loggers also
 * publish to their parent's Handlers, recursively up the tree.
 * <p>
 * Each Logger may have a {@code ResourceBundle} associated with it.
 * The {@code ResourceBundle} may be specified by name, using the
 * {@link #getLogger(java.lang.String, java.lang.String)} factory
 * method, or by value - using the {@link
 * #setResourceBundle(java.util.ResourceBundle) setResourceBundle} method.
 * This bundle will be used for localizing logging messages.
 * If a Logger does not have its own {@code ResourceBundle} or resource bundle
 * name, then it will inherit the {@code ResourceBundle} or resource bundle name
 * from its parent, recursively up the tree.
 * <p>
 * Most of the logger output methods take a "msg" argument.  This
 * msg argument may be either a raw value or a localization key.
 * During formatting, if the logger has (or inherits) a localization
 * {@code ResourceBundle} and if the {@code ResourceBundle} has a mapping for
 * the msg string, then the msg string is replaced by the localized value.
 * Otherwise the original msg string is used.  Typically, formatters use
 * java.text.MessageFormat style formatting to format parameters, so
 * for example a format string "{0} {1}" would format two parameters
 * as strings.
 * <p>
 * A set of methods alternatively take a "msgSupplier" instead of a "msg"
 * argument.  These methods take a {@link Supplier}{@code <String>} function
 * which is invoked to construct the desired log message only when the message
 * actually is to be logged based on the effective log level thus eliminating
 * unnecessary message construction. For example, if the developer wants to
 * log system health status for diagnosis, with the String-accepting version,
 * the code would look like:
 <pre><code>
 
   class DiagnosisMessages {
     static String systemHealthStatus() {
       // collect system health information
       ...
     }
   }
   ...
   logger.log(Level.FINER, DiagnosisMessages.systemHealthStatus());
 </code></pre>
 * With the above code, the health status is collected unnecessarily even when
 * the log level FINER is disabled. With the Supplier-accepting version as
 * below, the status will only be collected when the log level FINER is
 * enabled.
 <pre><code>
 
   logger.log(Level.FINER, DiagnosisMessages::systemHealthStatus);
 </code></pre>
 * <p>
 * When looking for a {@code ResourceBundle}, the logger will first look at
 * whether a bundle was specified using {@link
 * #setResourceBundle(java.util.ResourceBundle) setResourceBundle}, and then
 * only whether a resource bundle name was specified through the {@link
 * #getLogger(java.lang.String, java.lang.String) getLogger} factory method.
 * If no {@code ResourceBundle} or no resource bundle name is found,
 * then it will use the nearest {@code ResourceBundle} or resource bundle
 * name inherited from its parent tree.<br>
 * When a {@code ResourceBundle} was inherited or specified through the
 * {@link
 * #setResourceBundle(java.util.ResourceBundle) setResourceBundle} method, then
 * that {@code ResourceBundle} will be used. Otherwise if the logger only
 * has or inherited a resource bundle name, then that resource bundle name
 * will be mapped to a {@code ResourceBundle} object, using the default Locale
 * at the time of logging.
 * <br id="ResourceBundleMapping">When mapping resource bundle names to
 * {@code ResourceBundle} objects, the logger will first try to use the
 * Thread's {@linkplain java.lang.Thread#getContextClassLoader() context class
 * loader} to map the given resource bundle name to a {@code ResourceBundle}.
 * If the thread context class loader is {@code null}, it will try the
 * {@linkplain java.lang.ClassLoader#getSystemClassLoader() system class loader}
 * instead.  If the {@code ResourceBundle} is still not found, it will use the
 * class loader of the first caller of the {@link
 * #getLogger(java.lang.String, java.lang.String) getLogger} factory method.
 * <p>
 * Formatting (including localization) is the responsibility of
 * the output Handler, which will typically call a Formatter.
 * <p>
 * Note that formatting need not occur synchronously.  It may be delayed
 * until a LogRecord is actually written to an external sink.
 * <p>
 * The logging methods are grouped in five main categories:
 * <ul>
 * <li><p>
 *     There are a set of "log" methods that take a log level, a message
 *     string, and optionally some parameters to the message string.
 * <li><p>
 *     There are a set of "logp" methods (for "log precise") that are
 *     like the "log" methods, but also take an explicit source class name
 *     and method name.
 * <li><p>
 *     There are a set of "logrb" method (for "log with resource bundle")
 *     that are like the "logp" method, but also take an explicit resource
 *     bundle object for use in localizing the log message.
 * <li><p>
 *     There are convenience methods for tracing method entries (the
 *     "entering" methods), method returns (the "exiting" methods) and
 *     throwing exceptions (the "throwing" methods).
 * <li><p>
 *     Finally, there are a set of convenience methods for use in the
 *     very simplest cases, when a developer simply wants to log a
 *     simple string at a given log level.  These methods are named
 *     after the standard Level names ("severe", "warning", "info", etc.)
 *     and take a single argument, a message string.
 * </ul>
 * <p>
 * For the methods that do not take an explicit source name and
 * method name, the Logging framework will make a "best effort"
 * to determine which class and method called into the logging method.
 * However, it is important to realize that this automatically inferred
 * information may only be approximate (or may even be quite wrong!).
 * Virtual machines are allowed to do extensive optimizations when
 * JITing and may entirely remove stack frames, making it impossible
 * to reliably locate the calling class and method.
 * <P>
 * All methods on Logger are multi-thread safe.
 * <p>
 * <b>Subclassing Information:</b> Note that a LogManager class may
 * provide its own implementation of named Loggers for any point in
 * the namespace.  Therefore, any subclasses of Logger (unless they
 * are implemented in conjunction with a new LogManager class) should
 * take care to obtain a Logger instance from the LogManager class and
 * should delegate operations such as "isLoggable" and "log(LogRecord)"
 * to that instance.  Note that in order to intercept all logging
 * output, subclasses need only override the log(LogRecord) method.
 * All the other logging methods are implemented as calls on this
 * log(LogRecord) method.
 *
 * @since 1.4
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class Logger {

/**
 * Protected method to construct a logger for a named subsystem.
 * <p>
 * The logger will be initially configured with a null Level
 * and with useParentHandlers set to true.
 *
 * @param   name    A name for the logger.  This should
 *                          be a dot-separated name and should normally
 *                          be based on the package name or class name
 *                          of the subsystem, such as java.net
 *                          or javax.swing.  It may be null for anonymous Loggers.
 * @param   resourceBundleName  name of ResourceBundle to be used for localizing
 *                          messages for this logger.  May be null if none
 *                          of the messages require localization.
 * @throws MissingResourceException if the resourceBundleName is non-null and
 *             no corresponding resource can be found.
 */

protected Logger(java.lang.String name, java.lang.String resourceBundleName) { throw new RuntimeException("Stub!"); }

/**
 * Return global logger object with the name Logger.GLOBAL_LOGGER_NAME.
 *
 * @return global logger object
 * @since 1.7
 */

public static final java.util.logging.Logger getGlobal() { throw new RuntimeException("Stub!"); }

/**
 * Find or create a logger for a named subsystem.  If a logger has
 * already been created with the given name it is returned.  Otherwise
 * a new logger is created.
 * <p>
 * If a new logger is created its log level will be configured
 * based on the LogManager configuration and it will configured
 * to also send logging output to its parent's Handlers.  It will
 * be registered in the LogManager global namespace.
 * <p>
 * Note: The LogManager may only retain a weak reference to the newly
 * created Logger. It is important to understand that a previously
 * created Logger with the given name may be garbage collected at any
 * time if there is no strong reference to the Logger. In particular,
 * this means that two back-to-back calls like
 * {@code getLogger("MyLogger").log(...)} may use different Logger
 * objects named "MyLogger" if there is no strong reference to the
 * Logger named "MyLogger" elsewhere in the program.
 *
 * @param   name            A name for the logger.  This should
 *                          be a dot-separated name and should normally
 *                          be based on the package name or class name
 *                          of the subsystem, such as java.net
 *                          or javax.swing
 * @return a suitable Logger
 * @throws NullPointerException if the name is null.
 */

public static java.util.logging.Logger getLogger(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Find or create a logger for a named subsystem.  If a logger has
 * already been created with the given name it is returned.  Otherwise
 * a new logger is created.
 * <p>
 * If a new logger is created its log level will be configured
 * based on the LogManager and it will configured to also send logging
 * output to its parent's Handlers.  It will be registered in
 * the LogManager global namespace.
 * <p>
 * Note: The LogManager may only retain a weak reference to the newly
 * created Logger. It is important to understand that a previously
 * created Logger with the given name may be garbage collected at any
 * time if there is no strong reference to the Logger. In particular,
 * this means that two back-to-back calls like
 * {@code getLogger("MyLogger", ...).log(...)} may use different Logger
 * objects named "MyLogger" if there is no strong reference to the
 * Logger named "MyLogger" elsewhere in the program.
 * <p>
 * If the named Logger already exists and does not yet have a
 * localization resource bundle then the given resource bundle
 * name is used.  If the named Logger already exists and has
 * a different resource bundle name then an IllegalArgumentException
 * is thrown.
 * <p>
 * @param   name    A name for the logger.  This should
 *                          be a dot-separated name and should normally
 *                          be based on the package name or class name
 *                          of the subsystem, such as java.net
 *                          or javax.swing
 * @param   resourceBundleName  name of ResourceBundle to be used for localizing
 *                          messages for this logger. May be {@code null}
 *                          if none of the messages require localization.
 * @return a suitable Logger
 * @throws MissingResourceException if the resourceBundleName is non-null and
 *             no corresponding resource can be found.
 * @throws IllegalArgumentException if the Logger already exists and uses
 *             a different resource bundle name; or if
 *             {@code resourceBundleName} is {@code null} but the named
 *             logger has a resource bundle set.
 * @throws NullPointerException if the name is null.
 */

public static java.util.logging.Logger getLogger(java.lang.String name, java.lang.String resourceBundleName) { throw new RuntimeException("Stub!"); }

/**
 * Create an anonymous Logger.  The newly created Logger is not
 * registered in the LogManager namespace.  There will be no
 * access checks on updates to the logger.
 * <p>
 * This factory method is primarily intended for use from applets.
 * Because the resulting Logger is anonymous it can be kept private
 * by the creating class.  This removes the need for normal security
 * checks, which in turn allows untrusted applet code to update
 * the control state of the Logger.  For example an applet can do
 * a setLevel or an addHandler on an anonymous Logger.
 * <p>
 * Even although the new logger is anonymous, it is configured
 * to have the root logger ("") as its parent.  This means that
 * by default it inherits its effective level and handlers
 * from the root logger. Changing its parent via the
 * {@link #setParent(java.util.logging.Logger) setParent} method
 * will still require the security permission specified by that method.
 * <p>
 *
 * @return a newly created private Logger
 */

public static java.util.logging.Logger getAnonymousLogger() { throw new RuntimeException("Stub!"); }

/**
 * Create an anonymous Logger.  The newly created Logger is not
 * registered in the LogManager namespace.  There will be no
 * access checks on updates to the logger.
 * <p>
 * This factory method is primarily intended for use from applets.
 * Because the resulting Logger is anonymous it can be kept private
 * by the creating class.  This removes the need for normal security
 * checks, which in turn allows untrusted applet code to update
 * the control state of the Logger.  For example an applet can do
 * a setLevel or an addHandler on an anonymous Logger.
 * <p>
 * Even although the new logger is anonymous, it is configured
 * to have the root logger ("") as its parent.  This means that
 * by default it inherits its effective level and handlers
 * from the root logger.  Changing its parent via the
 * {@link #setParent(java.util.logging.Logger) setParent} method
 * will still require the security permission specified by that method.
 * <p>
 * @param   resourceBundleName  name of ResourceBundle to be used for localizing
 *                          messages for this logger.
 *          May be null if none of the messages require localization.
 * @return a newly created private Logger
 * @throws MissingResourceException if the resourceBundleName is non-null and
 *             no corresponding resource can be found.
 */

public static java.util.logging.Logger getAnonymousLogger(java.lang.String resourceBundleName) { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the localization resource bundle for this
 * logger.
 * This method will return a {@code ResourceBundle} that was either
 * set by the {@link
 * #setResourceBundle(java.util.ResourceBundle) setResourceBundle} method or
 * <a href="#ResourceBundleMapping">mapped from the
 * the resource bundle name</a> set via the {@link
 * Logger#getLogger(java.lang.String, java.lang.String) getLogger} factory
 * method for the current default locale.
 * <br>Note that if the result is {@code null}, then the Logger will use a resource
 * bundle or resource bundle name inherited from its parent.
 *
 * @return localization bundle (may be {@code null})
 */

public java.util.ResourceBundle getResourceBundle() { throw new RuntimeException("Stub!"); }

/**
 * Retrieve the localization resource bundle name for this
 * logger.
 * This is either the name specified through the {@link
 * #getLogger(java.lang.String, java.lang.String) getLogger} factory method,
 * or the {@linkplain ResourceBundle#getBaseBundleName() base name} of the
 * ResourceBundle set through {@link
 * #setResourceBundle(java.util.ResourceBundle) setResourceBundle} method.
 * <br>Note that if the result is {@code null}, then the Logger will use a resource
 * bundle or resource bundle name inherited from its parent.
 *
 * @return localization bundle name (may be {@code null})
 */

public java.lang.String getResourceBundleName() { throw new RuntimeException("Stub!"); }

/**
 * Set a filter to control output on this Logger.
 * <P>
 * After passing the initial "level" check, the Logger will
 * call this Filter to check if a log record should really
 * be published.
 *
 * @param   newFilter  a filter object (may be null)
 * @throws  SecurityException if a security manager exists,
 *          this logger is not anonymous, and the caller
 *          does not have LoggingPermission("control").
 */

public void setFilter(java.util.logging.Filter newFilter) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Get the current filter for this Logger.
 *
 * @return  a filter object (may be null)
 */

public java.util.logging.Filter getFilter() { throw new RuntimeException("Stub!"); }

/**
 * Log a LogRecord.
 * <p>
 * All the other logging methods in this class call through
 * this method to actually perform any logging.  Subclasses can
 * override this single method to capture all log activity.
 *
 * @param record the LogRecord to be published
 */

public void log(java.util.logging.LogRecord record) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, with no arguments.
 * <p>
 * If the logger is currently enabled for the given message
 * level then the given message is forwarded to all the
 * registered output Handler objects.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   msg     The string message (or a key in the message catalog)
 */

public void log(java.util.logging.Level level, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, which is only to be constructed if the logging level
 * is such that the message will actually be logged.
 * <p>
 * If the logger is currently enabled for the given message
 * level then the message is constructed by invoking the provided
 * supplier function and forwarded to all the registered output
 * Handler objects.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   msgSupplier   A function, which when called, produces the
 *                        desired log message
 * @since 1.8
 */

public void log(java.util.logging.Level level, java.util.function.Supplier<java.lang.String> msgSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, with one object parameter.
 * <p>
 * If the logger is currently enabled for the given message
 * level then a corresponding LogRecord is created and forwarded
 * to all the registered output Handler objects.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   msg     The string message (or a key in the message catalog)
 * @param   param1  parameter to the message
 */

public void log(java.util.logging.Level level, java.lang.String msg, java.lang.Object param1) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, with an array of object arguments.
 * <p>
 * If the logger is currently enabled for the given message
 * level then a corresponding LogRecord is created and forwarded
 * to all the registered output Handler objects.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   msg     The string message (or a key in the message catalog)
 * @param   params  array of parameters to the message
 */

public void log(java.util.logging.Level level, java.lang.String msg, java.lang.Object[] params) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, with associated Throwable information.
 * <p>
 * If the logger is currently enabled for the given message
 * level then the given arguments are stored in a LogRecord
 * which is forwarded to all registered output handlers.
 * <p>
 * Note that the thrown argument is stored in the LogRecord thrown
 * property, rather than the LogRecord parameters property.  Thus it is
 * processed specially by output Formatters and is not treated
 * as a formatting parameter to the LogRecord message property.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   msg     The string message (or a key in the message catalog)
 * @param   thrown  Throwable associated with log message.
 */

public void log(java.util.logging.Level level, java.lang.String msg, java.lang.Throwable thrown) { throw new RuntimeException("Stub!"); }

/**
 * Log a lazily constructed message, with associated Throwable information.
 * <p>
 * If the logger is currently enabled for the given message level then the
 * message is constructed by invoking the provided supplier function. The
 * message and the given {@link Throwable} are then stored in a {@link
 * LogRecord} which is forwarded to all registered output handlers.
 * <p>
 * Note that the thrown argument is stored in the LogRecord thrown
 * property, rather than the LogRecord parameters property.  Thus it is
 * processed specially by output Formatters and is not treated
 * as a formatting parameter to the LogRecord message property.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   thrown  Throwable associated with log message.
 * @param   msgSupplier   A function, which when called, produces the
 *                        desired log message
 * @since   1.8
 */

public void log(java.util.logging.Level level, java.lang.Throwable thrown, java.util.function.Supplier<java.lang.String> msgSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, specifying source class and method,
 * with no arguments.
 * <p>
 * If the logger is currently enabled for the given message
 * level then the given message is forwarded to all the
 * registered output Handler objects.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that issued the logging request
 * @param   msg     The string message (or a key in the message catalog)
 */

public void logp(java.util.logging.Level level, java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Log a lazily constructed message, specifying source class and method,
 * with no arguments.
 * <p>
 * If the logger is currently enabled for the given message
 * level then the message is constructed by invoking the provided
 * supplier function and forwarded to all the registered output
 * Handler objects.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that issued the logging request
 * @param   msgSupplier   A function, which when called, produces the
 *                        desired log message
 * @since   1.8
 */

public void logp(java.util.logging.Level level, java.lang.String sourceClass, java.lang.String sourceMethod, java.util.function.Supplier<java.lang.String> msgSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, specifying source class and method,
 * with a single object parameter to the log message.
 * <p>
 * If the logger is currently enabled for the given message
 * level then a corresponding LogRecord is created and forwarded
 * to all the registered output Handler objects.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that issued the logging request
 * @param   msg      The string message (or a key in the message catalog)
 * @param   param1    Parameter to the log message.
 */

public void logp(java.util.logging.Level level, java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.String msg, java.lang.Object param1) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, specifying source class and method,
 * with an array of object arguments.
 * <p>
 * If the logger is currently enabled for the given message
 * level then a corresponding LogRecord is created and forwarded
 * to all the registered output Handler objects.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that issued the logging request
 * @param   msg     The string message (or a key in the message catalog)
 * @param   params  Array of parameters to the message
 */

public void logp(java.util.logging.Level level, java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.String msg, java.lang.Object[] params) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, specifying source class and method,
 * with associated Throwable information.
 * <p>
 * If the logger is currently enabled for the given message
 * level then the given arguments are stored in a LogRecord
 * which is forwarded to all registered output handlers.
 * <p>
 * Note that the thrown argument is stored in the LogRecord thrown
 * property, rather than the LogRecord parameters property.  Thus it is
 * processed specially by output Formatters and is not treated
 * as a formatting parameter to the LogRecord message property.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that issued the logging request
 * @param   msg     The string message (or a key in the message catalog)
 * @param   thrown  Throwable associated with log message.
 */

public void logp(java.util.logging.Level level, java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.String msg, java.lang.Throwable thrown) { throw new RuntimeException("Stub!"); }

/**
 * Log a lazily constructed message, specifying source class and method,
 * with associated Throwable information.
 * <p>
 * If the logger is currently enabled for the given message level then the
 * message is constructed by invoking the provided supplier function. The
 * message and the given {@link Throwable} are then stored in a {@link
 * LogRecord} which is forwarded to all registered output handlers.
 * <p>
 * Note that the thrown argument is stored in the LogRecord thrown
 * property, rather than the LogRecord parameters property.  Thus it is
 * processed specially by output Formatters and is not treated
 * as a formatting parameter to the LogRecord message property.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that issued the logging request
 * @param   thrown  Throwable associated with log message.
 * @param   msgSupplier   A function, which when called, produces the
 *                        desired log message
 * @since   1.8
 */

public void logp(java.util.logging.Level level, java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.Throwable thrown, java.util.function.Supplier<java.lang.String> msgSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, specifying source class, method, and resource bundle name
 * with no arguments.
 * <p>
 * If the logger is currently enabled for the given message
 * level then the given message is forwarded to all the
 * registered output Handler objects.
 * <p>
 * The msg string is localized using the named resource bundle.  If the
 * resource bundle name is null, or an empty String or invalid
 * then the msg string is not localized.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that issued the logging request
 * @param   bundleName     name of resource bundle to localize msg,
 *                         can be null
 * @param   msg     The string message (or a key in the message catalog)
 * @deprecated Use {@link #logrb(java.util.logging.Level, java.lang.String,
 * java.lang.String, java.util.ResourceBundle, java.lang.String,
 * java.lang.Object...)} instead.
 */

@Deprecated public void logrb(java.util.logging.Level level, java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.String bundleName, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, specifying source class, method, and resource bundle name,
 * with a single object parameter to the log message.
 * <p>
 * If the logger is currently enabled for the given message
 * level then a corresponding LogRecord is created and forwarded
 * to all the registered output Handler objects.
 * <p>
 * The msg string is localized using the named resource bundle.  If the
 * resource bundle name is null, or an empty String or invalid
 * then the msg string is not localized.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that issued the logging request
 * @param   bundleName     name of resource bundle to localize msg,
 *                         can be null
 * @param   msg      The string message (or a key in the message catalog)
 * @param   param1    Parameter to the log message.
 * @deprecated Use {@link #logrb(java.util.logging.Level, java.lang.String,
 *   java.lang.String, java.util.ResourceBundle, java.lang.String,
 *   java.lang.Object...)} instead
 */

@Deprecated public void logrb(java.util.logging.Level level, java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.String bundleName, java.lang.String msg, java.lang.Object param1) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, specifying source class, method, and resource bundle name,
 * with an array of object arguments.
 * <p>
 * If the logger is currently enabled for the given message
 * level then a corresponding LogRecord is created and forwarded
 * to all the registered output Handler objects.
 * <p>
 * The msg string is localized using the named resource bundle.  If the
 * resource bundle name is null, or an empty String or invalid
 * then the msg string is not localized.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that issued the logging request
 * @param   bundleName     name of resource bundle to localize msg,
 *                         can be null.
 * @param   msg     The string message (or a key in the message catalog)
 * @param   params  Array of parameters to the message
 * @deprecated Use {@link #logrb(java.util.logging.Level, java.lang.String,
 *      java.lang.String, java.util.ResourceBundle, java.lang.String,
 *      java.lang.Object...)} instead.
 */

@Deprecated public void logrb(java.util.logging.Level level, java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.String bundleName, java.lang.String msg, java.lang.Object[] params) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, specifying source class, method, and resource bundle,
 * with an optional list of message parameters.
 * <p>
 * If the logger is currently enabled for the given message
 * level then a corresponding LogRecord is created and forwarded
 * to all the registered output Handler objects.
 * <p>
 * The {@code msg} string is localized using the given resource bundle.
 * If the resource bundle is {@code null}, then the {@code msg} string is not
 * localized.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   sourceClass    Name of the class that issued the logging request
 * @param   sourceMethod   Name of the method that issued the logging request
 * @param   bundle         Resource bundle to localize {@code msg},
 *                         can be {@code null}.
 * @param   msg     The string message (or a key in the message catalog)
 * @param   params  Parameters to the message (optional, may be none).
 * @since 1.8
 */

public void logrb(java.util.logging.Level level, java.lang.String sourceClass, java.lang.String sourceMethod, java.util.ResourceBundle bundle, java.lang.String msg, java.lang.Object... params) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, specifying source class, method, and resource bundle name,
 * with associated Throwable information.
 * <p>
 * If the logger is currently enabled for the given message
 * level then the given arguments are stored in a LogRecord
 * which is forwarded to all registered output handlers.
 * <p>
 * The msg string is localized using the named resource bundle.  If the
 * resource bundle name is null, or an empty String or invalid
 * then the msg string is not localized.
 * <p>
 * Note that the thrown argument is stored in the LogRecord thrown
 * property, rather than the LogRecord parameters property.  Thus it is
 * processed specially by output Formatters and is not treated
 * as a formatting parameter to the LogRecord message property.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that issued the logging request
 * @param   bundleName     name of resource bundle to localize msg,
 *                         can be null
 * @param   msg     The string message (or a key in the message catalog)
 * @param   thrown  Throwable associated with log message.
 * @deprecated Use {@link #logrb(java.util.logging.Level, java.lang.String,
 *     java.lang.String, java.util.ResourceBundle, java.lang.String,
 *     java.lang.Throwable)} instead.
 */

@Deprecated public void logrb(java.util.logging.Level level, java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.String bundleName, java.lang.String msg, java.lang.Throwable thrown) { throw new RuntimeException("Stub!"); }

/**
 * Log a message, specifying source class, method, and resource bundle,
 * with associated Throwable information.
 * <p>
 * If the logger is currently enabled for the given message
 * level then the given arguments are stored in a LogRecord
 * which is forwarded to all registered output handlers.
 * <p>
 * The {@code msg} string is localized using the given resource bundle.
 * If the resource bundle is {@code null}, then the {@code msg} string is not
 * localized.
 * <p>
 * Note that the thrown argument is stored in the LogRecord thrown
 * property, rather than the LogRecord parameters property.  Thus it is
 * processed specially by output Formatters and is not treated
 * as a formatting parameter to the LogRecord message property.
 * <p>
 * @param   level   One of the message level identifiers, e.g., SEVERE
 * @param   sourceClass    Name of the class that issued the logging request
 * @param   sourceMethod   Name of the method that issued the logging request
 * @param   bundle         Resource bundle to localize {@code msg},
 *                         can be {@code null}
 * @param   msg     The string message (or a key in the message catalog)
 * @param   thrown  Throwable associated with the log message.
 * @since 1.8
 */

public void logrb(java.util.logging.Level level, java.lang.String sourceClass, java.lang.String sourceMethod, java.util.ResourceBundle bundle, java.lang.String msg, java.lang.Throwable thrown) { throw new RuntimeException("Stub!"); }

/**
 * Log a method entry.
 * <p>
 * This is a convenience method that can be used to log entry
 * to a method.  A LogRecord with message "ENTRY", log level
 * FINER, and the given sourceMethod and sourceClass is logged.
 * <p>
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that is being entered
 */

public void entering(java.lang.String sourceClass, java.lang.String sourceMethod) { throw new RuntimeException("Stub!"); }

/**
 * Log a method entry, with one parameter.
 * <p>
 * This is a convenience method that can be used to log entry
 * to a method.  A LogRecord with message "ENTRY {0}", log level
 * FINER, and the given sourceMethod, sourceClass, and parameter
 * is logged.
 * <p>
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that is being entered
 * @param   param1         parameter to the method being entered
 */

public void entering(java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.Object param1) { throw new RuntimeException("Stub!"); }

/**
 * Log a method entry, with an array of parameters.
 * <p>
 * This is a convenience method that can be used to log entry
 * to a method.  A LogRecord with message "ENTRY" (followed by a
 * format {N} indicator for each entry in the parameter array),
 * log level FINER, and the given sourceMethod, sourceClass, and
 * parameters is logged.
 * <p>
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of method that is being entered
 * @param   params         array of parameters to the method being entered
 */

public void entering(java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.Object[] params) { throw new RuntimeException("Stub!"); }

/**
 * Log a method return.
 * <p>
 * This is a convenience method that can be used to log returning
 * from a method.  A LogRecord with message "RETURN", log level
 * FINER, and the given sourceMethod and sourceClass is logged.
 * <p>
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of the method
 */

public void exiting(java.lang.String sourceClass, java.lang.String sourceMethod) { throw new RuntimeException("Stub!"); }

/**
 * Log a method return, with result object.
 * <p>
 * This is a convenience method that can be used to log returning
 * from a method.  A LogRecord with message "RETURN {0}", log level
 * FINER, and the gives sourceMethod, sourceClass, and result
 * object is logged.
 * <p>
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod   name of the method
 * @param   result  Object that is being returned
 */

public void exiting(java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.Object result) { throw new RuntimeException("Stub!"); }

/**
 * Log throwing an exception.
 * <p>
 * This is a convenience method to log that a method is
 * terminating by throwing an exception.  The logging is done
 * using the FINER level.
 * <p>
 * If the logger is currently enabled for the given message
 * level then the given arguments are stored in a LogRecord
 * which is forwarded to all registered output handlers.  The
 * LogRecord's message is set to "THROW".
 * <p>
 * Note that the thrown argument is stored in the LogRecord thrown
 * property, rather than the LogRecord parameters property.  Thus it is
 * processed specially by output Formatters and is not treated
 * as a formatting parameter to the LogRecord message property.
 * <p>
 * @param   sourceClass    name of class that issued the logging request
 * @param   sourceMethod  name of the method.
 * @param   thrown  The Throwable that is being thrown.
 */

public void throwing(java.lang.String sourceClass, java.lang.String sourceMethod, java.lang.Throwable thrown) { throw new RuntimeException("Stub!"); }

/**
 * Log a SEVERE message.
 * <p>
 * If the logger is currently enabled for the SEVERE message
 * level then the given message is forwarded to all the
 * registered output Handler objects.
 * <p>
 * @param   msg     The string message (or a key in the message catalog)
 */

public void severe(java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Log a WARNING message.
 * <p>
 * If the logger is currently enabled for the WARNING message
 * level then the given message is forwarded to all the
 * registered output Handler objects.
 * <p>
 * @param   msg     The string message (or a key in the message catalog)
 */

public void warning(java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Log an INFO message.
 * <p>
 * If the logger is currently enabled for the INFO message
 * level then the given message is forwarded to all the
 * registered output Handler objects.
 * <p>
 * @param   msg     The string message (or a key in the message catalog)
 */

public void info(java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Log a CONFIG message.
 * <p>
 * If the logger is currently enabled for the CONFIG message
 * level then the given message is forwarded to all the
 * registered output Handler objects.
 * <p>
 * @param   msg     The string message (or a key in the message catalog)
 */

public void config(java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Log a FINE message.
 * <p>
 * If the logger is currently enabled for the FINE message
 * level then the given message is forwarded to all the
 * registered output Handler objects.
 * <p>
 * @param   msg     The string message (or a key in the message catalog)
 */

public void fine(java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Log a FINER message.
 * <p>
 * If the logger is currently enabled for the FINER message
 * level then the given message is forwarded to all the
 * registered output Handler objects.
 * <p>
 * @param   msg     The string message (or a key in the message catalog)
 */

public void finer(java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Log a FINEST message.
 * <p>
 * If the logger is currently enabled for the FINEST message
 * level then the given message is forwarded to all the
 * registered output Handler objects.
 * <p>
 * @param   msg     The string message (or a key in the message catalog)
 */

public void finest(java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Log a SEVERE message, which is only to be constructed if the logging
 * level is such that the message will actually be logged.
 * <p>
 * If the logger is currently enabled for the SEVERE message
 * level then the message is constructed by invoking the provided
 * supplier function and forwarded to all the registered output
 * Handler objects.
 * <p>
 * @param   msgSupplier   A function, which when called, produces the
 *                        desired log message
 * @since   1.8
 */

public void severe(java.util.function.Supplier<java.lang.String> msgSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Log a WARNING message, which is only to be constructed if the logging
 * level is such that the message will actually be logged.
 * <p>
 * If the logger is currently enabled for the WARNING message
 * level then the message is constructed by invoking the provided
 * supplier function and forwarded to all the registered output
 * Handler objects.
 * <p>
 * @param   msgSupplier   A function, which when called, produces the
 *                        desired log message
 * @since   1.8
 */

public void warning(java.util.function.Supplier<java.lang.String> msgSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Log a INFO message, which is only to be constructed if the logging
 * level is such that the message will actually be logged.
 * <p>
 * If the logger is currently enabled for the INFO message
 * level then the message is constructed by invoking the provided
 * supplier function and forwarded to all the registered output
 * Handler objects.
 * <p>
 * @param   msgSupplier   A function, which when called, produces the
 *                        desired log message
 * @since   1.8
 */

public void info(java.util.function.Supplier<java.lang.String> msgSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Log a CONFIG message, which is only to be constructed if the logging
 * level is such that the message will actually be logged.
 * <p>
 * If the logger is currently enabled for the CONFIG message
 * level then the message is constructed by invoking the provided
 * supplier function and forwarded to all the registered output
 * Handler objects.
 * <p>
 * @param   msgSupplier   A function, which when called, produces the
 *                        desired log message
 * @since   1.8
 */

public void config(java.util.function.Supplier<java.lang.String> msgSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Log a FINE message, which is only to be constructed if the logging
 * level is such that the message will actually be logged.
 * <p>
 * If the logger is currently enabled for the FINE message
 * level then the message is constructed by invoking the provided
 * supplier function and forwarded to all the registered output
 * Handler objects.
 * <p>
 * @param   msgSupplier   A function, which when called, produces the
 *                        desired log message
 * @since   1.8
 */

public void fine(java.util.function.Supplier<java.lang.String> msgSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Log a FINER message, which is only to be constructed if the logging
 * level is such that the message will actually be logged.
 * <p>
 * If the logger is currently enabled for the FINER message
 * level then the message is constructed by invoking the provided
 * supplier function and forwarded to all the registered output
 * Handler objects.
 * <p>
 * @param   msgSupplier   A function, which when called, produces the
 *                        desired log message
 * @since   1.8
 */

public void finer(java.util.function.Supplier<java.lang.String> msgSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Log a FINEST message, which is only to be constructed if the logging
 * level is such that the message will actually be logged.
 * <p>
 * If the logger is currently enabled for the FINEST message
 * level then the message is constructed by invoking the provided
 * supplier function and forwarded to all the registered output
 * Handler objects.
 * <p>
 * @param   msgSupplier   A function, which when called, produces the
 *                        desired log message
 * @since   1.8
 */

public void finest(java.util.function.Supplier<java.lang.String> msgSupplier) { throw new RuntimeException("Stub!"); }

/**
 * Set the log level specifying which message levels will be
 * logged by this logger.  Message levels lower than this
 * value will be discarded.  The level value Level.OFF
 * can be used to turn off logging.
 * <p>
 * If the new level is null, it means that this node should
 * inherit its level from its nearest ancestor with a specific
 * (non-null) level value.
 *
 * @param newLevel   the new value for the log level (may be null)
 * @throws  SecurityException if a security manager exists,
 *          this logger is not anonymous, and the caller
 *          does not have LoggingPermission("control").
 */

public void setLevel(java.util.logging.Level newLevel) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Get the log Level that has been specified for this Logger.
 * The result may be null, which means that this logger's
 * effective level will be inherited from its parent.
 *
 * @return  this Logger's level
 */

public java.util.logging.Level getLevel() { throw new RuntimeException("Stub!"); }

/**
 * Check if a message of the given level would actually be logged
 * by this logger.  This check is based on the Loggers effective level,
 * which may be inherited from its parent.
 *
 * @param   level   a message logging level
 * @return  true if the given message level is currently being logged.
 */

public boolean isLoggable(java.util.logging.Level level) { throw new RuntimeException("Stub!"); }

/**
 * Get the name for this logger.
 * @return logger name.  Will be null for anonymous Loggers.
 */

public java.lang.String getName() { throw new RuntimeException("Stub!"); }

/**
 * Add a log Handler to receive logging messages.
 * <p>
 * By default, Loggers also send their output to their parent logger.
 * Typically the root Logger is configured with a set of Handlers
 * that essentially act as default handlers for all loggers.
 *
 * @param   handler a logging Handler
 * @throws  SecurityException if a security manager exists,
 *          this logger is not anonymous, and the caller
 *          does not have LoggingPermission("control").
 */

public void addHandler(java.util.logging.Handler handler) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Remove a log Handler.
 * <P>
 * Returns silently if the given Handler is not found or is null
 *
 * @param   handler a logging Handler
 * @throws  SecurityException if a security manager exists,
 *          this logger is not anonymous, and the caller
 *          does not have LoggingPermission("control").
 */

public void removeHandler(java.util.logging.Handler handler) throws java.lang.SecurityException { throw new RuntimeException("Stub!"); }

/**
 * Get the Handlers associated with this logger.
 * <p>
 * @return  an array of all registered Handlers
 */

public java.util.logging.Handler[] getHandlers() { throw new RuntimeException("Stub!"); }

/**
 * Specify whether or not this logger should send its output
 * to its parent Logger.  This means that any LogRecords will
 * also be written to the parent's Handlers, and potentially
 * to its parent, recursively up the namespace.
 *
 * @param useParentHandlers   true if output is to be sent to the
 *          logger's parent.
 * @throws  SecurityException if a security manager exists,
 *          this logger is not anonymous, and the caller
 *          does not have LoggingPermission("control").
 */

public void setUseParentHandlers(boolean useParentHandlers) { throw new RuntimeException("Stub!"); }

/**
 * Discover whether or not this logger is sending its output
 * to its parent logger.
 *
 * @return  true if output is to be sent to the logger's parent
 */

public boolean getUseParentHandlers() { throw new RuntimeException("Stub!"); }

/**
 * Sets a resource bundle on this logger.
 * All messages will be logged using the given resource bundle for its
 * specific {@linkplain ResourceBundle#getLocale locale}.
 * @param bundle The resource bundle that this logger shall use.
 * @throws NullPointerException if the given bundle is {@code null}.
 * @throws IllegalArgumentException if the given bundle doesn't have a
 *         {@linkplain ResourceBundle#getBaseBundleName base name},
 *         or if this logger already has a resource bundle set but
 *         the given bundle has a different base name.
 * @throws SecurityException if a security manager exists,
 *         this logger is not anonymous, and the caller
 *         does not have LoggingPermission("control").
 * @since 1.8
 */

public void setResourceBundle(java.util.ResourceBundle bundle) { throw new RuntimeException("Stub!"); }

/**
 * Return the parent for this Logger.
 * <p>
 * This method returns the nearest extant parent in the namespace.
 * Thus if a Logger is called "a.b.c.d", and a Logger called "a.b"
 * has been created but no logger "a.b.c" exists, then a call of
 * getParent on the Logger "a.b.c.d" will return the Logger "a.b".
 * <p>
 * The result will be null if it is called on the root Logger
 * in the namespace.
 *
 * @return nearest existing parent Logger
 */

public java.util.logging.Logger getParent() { throw new RuntimeException("Stub!"); }

/**
 * Set the parent for this Logger.  This method is used by
 * the LogManager to update a Logger when the namespace changes.
 * <p>
 * It should not be called from application code.
 * <p>
 * @param  parent   the new parent logger
 * @throws  SecurityException  if a security manager exists and if
 *          the caller does not have LoggingPermission("control").
 */

public void setParent(java.util.logging.Logger parent) { throw new RuntimeException("Stub!"); }

/**
 * GLOBAL_LOGGER_NAME is a name for the global logger.
 *
 * @since 1.6
 */

public static final java.lang.String GLOBAL_LOGGER_NAME = "global";

/**
 * The "global" Logger object is provided as a convenience to developers
 * who are making casual use of the Logging package.  Developers
 * who are making serious use of the logging package (for example
 * in products) should create and use their own Logger objects,
 * with appropriate names, so that logging can be controlled on a
 * suitable per-Logger granularity. Developers also need to keep a
 * strong reference to their Logger objects to prevent them from
 * being garbage collected.
 * <p>
 * @deprecated Initialization of this field is prone to deadlocks.
 * The field must be initialized by the Logger class initialization
 * which may cause deadlocks with the LogManager class initialization.
 * In such cases two class initialization wait for each other to complete.
 * The preferred way to get the global logger object is via the call
 * <code>Logger.getGlobal()</code>.
 * For compatibility with old JDK versions where the
 * <code>Logger.getGlobal()</code> is not available use the call
 * <code>Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)</code>
 * or <code>Logger.getLogger("global")</code>.
 */

@Deprecated public static final java.util.logging.Logger global;
static { global = null; }
}

