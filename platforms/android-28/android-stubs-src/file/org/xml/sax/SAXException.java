// SAX exception class.
// http://www.saxproject.org
// No warranty; no copyright -- use this as you will.
// $Id: SAXException.java,v 1.7 2002/01/30 21:13:48 dbrownell Exp $


package org.xml.sax;


/**
 * Encapsulate a general SAX error or warning.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * See <a href='http://www.saxproject.org'>http://www.saxproject.org</a>
 * for further information.
 * </blockquote>
 *
 * <p>This class can contain basic error or warning information from
 * either the XML parser or the application: a parser writer or
 * application writer can subclass it to provide additional
 * functionality.  SAX handlers may throw this exception or
 * any exception subclassed from it.</p>
 *
 * <p>If the application needs to pass through other types of
 * exceptions, it must wrap those exceptions in a SAXException
 * or an exception derived from a SAXException.</p>
 *
 * <p>If the parser or application needs to include information about a
 * specific location in an XML document, it should use the
 * {@link org.xml.sax.SAXParseException SAXParseException} subclass.</p>
 *
 * @since SAX 1.0
 * @author David Megginson
 * @version 2.0.1 (sax2r2)
 * @see org.xml.sax.SAXParseException
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class SAXException extends java.lang.Exception {

/**
 * Create a new SAXException.
 */

public SAXException() { throw new RuntimeException("Stub!"); }

/**
 * Create a new SAXException.
 *
 * @param message The error or warning message.
 */

public SAXException(java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * Create a new SAXException wrapping an existing exception.
 *
 * <p>The existing exception will be embedded in the new
 * one, and its message will become the default message for
 * the SAXException.</p>
 *
 * @param e The exception to be wrapped in a SAXException.
 */

public SAXException(java.lang.Exception e) { throw new RuntimeException("Stub!"); }

/**
 * Create a new SAXException from an existing exception.
 *
 * <p>The existing exception will be embedded in the new
 * one, but the new exception will have its own message.</p>
 *
 * @param message The detail message.
 * @param e The exception to be wrapped in a SAXException.
 */

public SAXException(java.lang.String message, java.lang.Exception e) { throw new RuntimeException("Stub!"); }

/**
 * Return a detail message for this exception.
 *
 * <p>If there is an embedded exception, and if the SAXException
 * has no detail message of its own, this method will return
 * the detail message from the embedded exception.</p>
 *
 * @return The error or warning message.
 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }

/**
 * Return the embedded exception, if any.
 *
 * @return The embedded exception, or null if there is none.
 */

public java.lang.Exception getException() { throw new RuntimeException("Stub!"); }

/**
 * Override toString to pick up any embedded exception.
 *
 * @return A string representation of this exception.
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

