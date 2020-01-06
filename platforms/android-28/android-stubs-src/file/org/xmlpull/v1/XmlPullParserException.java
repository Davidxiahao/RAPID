/* -*-             c-basic-offset: 4; indent-tabs-mode: nil; -*-  //------100-columns-wide------>|*/
// for license please see accompanying LICENSE.txt file (available also at http://www.xmlpull.org/)


package org.xmlpull.v1;


/**
 * This exception is thrown to signal XML Pull Parser related faults.
 *
 * @author <a href="http://www.extreme.indiana.edu/~aslom/">Aleksander Slominski</a>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class XmlPullParserException extends java.lang.Exception {

public XmlPullParserException(java.lang.String s) { throw new RuntimeException("Stub!"); }

public XmlPullParserException(java.lang.String msg, org.xmlpull.v1.XmlPullParser parser, java.lang.Throwable chain) { throw new RuntimeException("Stub!"); }

public java.lang.Throwable getDetail() { throw new RuntimeException("Stub!"); }

public int getLineNumber() { throw new RuntimeException("Stub!"); }

public int getColumnNumber() { throw new RuntimeException("Stub!"); }

public void printStackTrace() { throw new RuntimeException("Stub!"); }

protected int column = -1; // 0xffffffff

protected java.lang.Throwable detail;

protected int row = -1; // 0xffffffff
}

