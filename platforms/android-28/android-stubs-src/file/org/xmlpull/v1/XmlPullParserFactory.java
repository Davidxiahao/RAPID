/* -*-             c-basic-offset: 4; indent-tabs-mode: nil; -*-  //------100-columns-wide------>|*/
// for license please see accompanying LICENSE.txt file (available also at http://www.xmlpull.org/)


package org.xmlpull.v1;


/**
 * This class is used to create implementations of XML Pull Parser defined in XMPULL V1 API.
 *
 * @see XmlPullParser
 *
 * @author <a href="http://www.extreme.indiana.edu/~aslom/">Aleksander Slominski</a>
 * @author Stefan Haustein
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class XmlPullParserFactory {

/**
 * Protected constructor to be called by factory implementations.
 */

protected XmlPullParserFactory() { throw new RuntimeException("Stub!"); }

/**
 * Set the features to be set when XML Pull Parser is created by this factory.
 * <p><b>NOTE:</b> factory features are not used for XML Serializer.
 *
 * @param name string with URI identifying feature
 * @param state if true feature will be set; if false will be ignored
 */

public void setFeature(java.lang.String name, boolean state) throws org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Return the current value of the feature with given name.
 * <p><b>NOTE:</b> factory features are not used for XML Serializer.
 *
 * @param name The name of feature to be retrieved.
 * @return The value of named feature.
 *     Unknown features are <string>always</strong> returned as false
 */

public boolean getFeature(java.lang.String name) { throw new RuntimeException("Stub!"); }

/**
 * Specifies that the parser produced by this factory will provide
 * support for XML namespaces.
 * By default the value of this is set to false.
 *
 * @param awareness true if the parser produced by this code
 *    will provide support for XML namespaces;  false otherwise.
 */

public void setNamespaceAware(boolean awareness) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether or not the factory is configured to produce
 * parsers which are namespace aware
 * (it simply set feature XmlPullParser.FEATURE_PROCESS_NAMESPACES to true or false).
 *
 * @return  true if the factory is configured to produce parsers
 *    which are namespace aware; false otherwise.
 */

public boolean isNamespaceAware() { throw new RuntimeException("Stub!"); }

/**
 * Specifies that the parser produced by this factory will be validating
 * (it simply set feature XmlPullParser.FEATURE_VALIDATION to true or false).
 *
 * By default the value of this is set to false.
 *
 * @param validating - if true the parsers created by this factory  must be validating.
 */

public void setValidating(boolean validating) { throw new RuntimeException("Stub!"); }

/**
 * Indicates whether or not the factory is configured to produce parsers
 * which validate the XML content during parse.
 *
 * @return   true if the factory is configured to produce parsers
 * which validate the XML content during parse; false otherwise.
 */

public boolean isValidating() { throw new RuntimeException("Stub!"); }

/**
 * Creates a new instance of a XML Pull Parser
 * using the currently configured factory features.
 *
 * @return A new instance of a XML Pull Parser.
 */

public org.xmlpull.v1.XmlPullParser newPullParser() throws org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new instance of a XML Serializer.
 *
 * <p><b>NOTE:</b> factory features are not used for XML Serializer.
 *
 * @return A new instance of a XML Serializer.
 * @throws XmlPullParserException if a parser cannot be created which satisfies the
 * requested configuration.
 */

public org.xmlpull.v1.XmlSerializer newSerializer() throws org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Creates a new instance of a PullParserFactory that can be used
 * to create XML pull parsers. The factory will always return instances
 * of Android's built-in {@link XmlPullParser} and {@link XmlSerializer}.
 */

public static org.xmlpull.v1.XmlPullParserFactory newInstance() throws org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

/**
 * Creates a factory that always returns instances of Android's built-in
 * {@link XmlPullParser} and {@link XmlSerializer} implementation. This
 * <b>does not</b> support factories capable of creating arbitrary parser
 * and serializer implementations. Both arguments to this method are unused.
 */

public static org.xmlpull.v1.XmlPullParserFactory newInstance(java.lang.String unused, java.lang.Class unused2) throws org.xmlpull.v1.XmlPullParserException { throw new RuntimeException("Stub!"); }

public static final java.lang.String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";

/** Unused, but we have to keep it because it's public API. */

protected java.lang.String classNamesLocation;

protected java.util.HashMap<java.lang.String, java.lang.Boolean> features;

protected java.util.ArrayList parserClasses;

protected java.util.ArrayList serializerClasses;
}

