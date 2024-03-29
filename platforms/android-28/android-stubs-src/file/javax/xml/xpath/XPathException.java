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
// $Id: XPathException.java 446598 2006-09-15 12:55:40Z jeremias $


package javax.xml.xpath;


/**
 * <code>XPathException</code> represents a generic XPath exception.</p>
 *
 * @author  <a href="Norman.Walsh@Sun.com">Norman Walsh</a>
 * @author <a href="mailto:Jeff.Suttor@Sun.COM">Jeff Suttor</a>
 * @version $Revision: 446598 $, $Date: 2006-09-15 05:55:40 -0700 (Fri, 15 Sep 2006) $
 * @since 1.5
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class XPathException extends java.lang.Exception {

/**
 * <p>Constructs a new <code>XPathException</code> with the specified detail <code>message</code>.</p>
 *
 * <p>The <code>cause</code> is not initialized.</p>
 *
 * <p>If <code>message</code> is <code>null</code>, then a <code>NullPointerException</code> is thrown.</p>
 *
 * @param message The detail message.
 */

public XPathException(java.lang.String message) { throw new RuntimeException("Stub!"); }

/**
 * <p>Constructs a new <code>XPathException</code> with the specified <code>cause</code>.</p>
 *
 * <p>If <code>cause</code> is <code>null</code>, then a <code>NullPointerException</code> is thrown.</p>
 *
 * @param cause The cause.
 *
 * @throws NullPointerException if <code>cause</code> is <code>null</code>.
 */

public XPathException(java.lang.Throwable cause) { throw new RuntimeException("Stub!"); }

public java.lang.Throwable getCause() { throw new RuntimeException("Stub!"); }

public void printStackTrace(java.io.PrintStream s) { throw new RuntimeException("Stub!"); }

public void printStackTrace() { throw new RuntimeException("Stub!"); }

public void printStackTrace(java.io.PrintWriter s) { throw new RuntimeException("Stub!"); }
}

