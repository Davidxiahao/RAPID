/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// $Id: StreamSource.java 829971 2009-10-26 21:15:39Z mrglavas $


package javax.xml.transform.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.transform.Source;
import java.io.File;

/**
 * <p>Acts as an holder for a transformation Source in the form
 * of a stream of XML markup.</p>
 *
 * <p><em>Note:</em> Due to their internal use of either a {@link Reader} or {@link InputStream} instance,
 * <code>StreamSource</code> instances may only be used once.</p>
 *
 * @author <a href="Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @version $Revision: 829971 $, $Date: 2009-10-26 14:15:39 -0700 (Mon, 26 Oct 2009) $
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class StreamSource implements javax.xml.transform.Source {

/**
 * <p>Zero-argument default constructor.  If this constructor is used, and
 * no Stream source is set using
 * {@link #setInputStream(java.io.InputStream inputStream)} or
 * {@link #setReader(java.io.Reader reader)}, then the
 * <code>Transformer</code> will
 * create an empty source {@link java.io.InputStream} using
 * {@link java.io.InputStream#InputStream() new InputStream()}.</p>
 *
 * @see javax.xml.transform.Transformer#transform(Source xmlSource, Result outputTarget)
 */

public StreamSource() { throw new RuntimeException("Stub!"); }

/**
 * Construct a StreamSource from a byte stream.  Normally,
 * a stream should be used rather than a reader, so
 * the XML parser can resolve character encoding specified
 * by the XML declaration.
 *
 * <p>If this constructor is used to process a stylesheet, normally
 * setSystemId should also be called, so that relative URI references
 * can be resolved.</p>
 *
 * @param inputStream A valid InputStream reference to an XML stream.
 */

public StreamSource(java.io.InputStream inputStream) { throw new RuntimeException("Stub!"); }

/**
 * Construct a StreamSource from a byte stream.  Normally,
 * a stream should be used rather than a reader, so that
 * the XML parser can resolve character encoding specified
 * by the XML declaration.
 *
 * <p>This constructor allows the systemID to be set in addition
 * to the input stream, which allows relative URIs
 * to be processed.</p>
 *
 * @param inputStream A valid InputStream reference to an XML stream.
 * @param systemId Must be a String that conforms to the URI syntax.
 */

public StreamSource(java.io.InputStream inputStream, java.lang.String systemId) { throw new RuntimeException("Stub!"); }

/**
 * Construct a StreamSource from a character reader.  Normally,
 * a stream should be used rather than a reader, so that
 * the XML parser can resolve character encoding specified
 * by the XML declaration.  However, in many cases the encoding
 * of the input stream is already resolved, as in the case of
 * reading XML from a StringReader.
 *
 * @param reader A valid Reader reference to an XML character stream.
 */

public StreamSource(java.io.Reader reader) { throw new RuntimeException("Stub!"); }

/**
 * Construct a StreamSource from a character reader.  Normally,
 * a stream should be used rather than a reader, so that
 * the XML parser may resolve character encoding specified
 * by the XML declaration.  However, in many cases the encoding
 * of the input stream is already resolved, as in the case of
 * reading XML from a StringReader.
 *
 * @param reader A valid Reader reference to an XML character stream.
 * @param systemId Must be a String that conforms to the URI syntax.
 */

public StreamSource(java.io.Reader reader, java.lang.String systemId) { throw new RuntimeException("Stub!"); }

/**
 * Construct a StreamSource from a URL.
 *
 * @param systemId Must be a String that conforms to the URI syntax.
 */

public StreamSource(java.lang.String systemId) { throw new RuntimeException("Stub!"); }

/**
 * Construct a StreamSource from a File.
 *
 * @param f Must a non-null File reference.
 */

public StreamSource(java.io.File f) { throw new RuntimeException("Stub!"); }

/**
 * Set the byte stream to be used as input.  Normally,
 * a stream should be used rather than a reader, so that
 * the XML parser can resolve character encoding specified
 * by the XML declaration.
 *
 * <p>If this Source object is used to process a stylesheet, normally
 * setSystemId should also be called, so that relative URL references
 * can be resolved.</p>
 *
 * @param inputStream A valid InputStream reference to an XML stream.
 */

public void setInputStream(java.io.InputStream inputStream) { throw new RuntimeException("Stub!"); }

/**
 * Get the byte stream that was set with setByteStream.
 *
 * @return The byte stream that was set with setByteStream, or null
 * if setByteStream or the ByteStream constructor was not called.
 */

public java.io.InputStream getInputStream() { throw new RuntimeException("Stub!"); }

/**
 * Set the input to be a character reader.  Normally,
 * a stream should be used rather than a reader, so that
 * the XML parser can resolve character encoding specified
 * by the XML declaration.  However, in many cases the encoding
 * of the input stream is already resolved, as in the case of
 * reading XML from a StringReader.
 *
 * @param reader A valid Reader reference to an XML CharacterStream.
 */

public void setReader(java.io.Reader reader) { throw new RuntimeException("Stub!"); }

/**
 * Get the character stream that was set with setReader.
 *
 * @return The character stream that was set with setReader, or null
 * if setReader or the Reader constructor was not called.
 */

public java.io.Reader getReader() { throw new RuntimeException("Stub!"); }

/**
 * Set the public identifier for this Source.
 *
 * <p>The public identifier is always optional: if the application
 * writer includes one, it will be provided as part of the
 * location information.</p>
 *
 * @param publicId The public identifier as a string.
 */

public void setPublicId(java.lang.String publicId) { throw new RuntimeException("Stub!"); }

/**
 * Get the public identifier that was set with setPublicId.
 *
 * @return The public identifier that was set with setPublicId, or null
 * if setPublicId was not called.
 */

public java.lang.String getPublicId() { throw new RuntimeException("Stub!"); }

/**
 * Set the system identifier for this Source.
 *
 * <p>The system identifier is optional if there is a byte stream
 * or a character stream, but it is still useful to provide one,
 * since the application can use it to resolve relative URIs
 * and can include it in error messages and warnings (the parser
 * will attempt to open a connection to the URI only if
 * there is no byte stream or character stream specified).</p>
 *
 * @param systemId The system identifier as a URL string.
 */

public void setSystemId(java.lang.String systemId) { throw new RuntimeException("Stub!"); }

/**
 * Get the system identifier that was set with setSystemId.
 *
 * @return The system identifier that was set with setSystemId, or null
 * if setSystemId was not called.
 */

public java.lang.String getSystemId() { throw new RuntimeException("Stub!"); }

/**
 * Set the system ID from a File reference.
 *
 * @param f Must a non-null File reference.
 */

public void setSystemId(java.io.File f) { throw new RuntimeException("Stub!"); }

/** If {@link javax.xml.transform.TransformerFactory#getFeature}
 * returns true when passed this value as an argument,
 * the Transformer supports Source input of this type.
 */

public static final java.lang.String FEATURE = "http://javax.xml.transform.stream.StreamSource/feature";
}

