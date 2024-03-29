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

// $Id: TransformerFactoryConfigurationError.java 569994 2007-08-27 04:28:57Z mrglavas $


package javax.xml.transform;


/**
 * Thrown when a problem with configuration with the Transformer Factories
 * exists. This error will typically be thrown when the class of a
 * transformation factory specified in the system properties cannot be found
 * or instantiated.
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class TransformerFactoryConfigurationError extends java.lang.Error {

/**
 * Create a new <code>TransformerFactoryConfigurationError</code> with no
 * detail message.
 */

public TransformerFactoryConfigurationError() { throw new RuntimeException("Stub!"); }

/**
 * Create a new <code>TransformerFactoryConfigurationError</code> with
 * the <code>String</code> specified as an error message.
 *
 * @param msg The error message for the exception.
 */

public TransformerFactoryConfigurationError(java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Create a new <code>TransformerFactoryConfigurationError</code> with a
 * given <code>Exception</code> base cause of the error.
 *
 * @param e The exception to be encapsulated in a
 * TransformerFactoryConfigurationError.
 */

public TransformerFactoryConfigurationError(java.lang.Exception e) { throw new RuntimeException("Stub!"); }

/**
 * Create a new <code>TransformerFactoryConfigurationError</code> with the
 * given <code>Exception</code> base cause and detail message.
 *
 * @param e The exception to be encapsulated in a
 * TransformerFactoryConfigurationError
 * @param msg The detail message.
 */

public TransformerFactoryConfigurationError(java.lang.Exception e, java.lang.String msg) { throw new RuntimeException("Stub!"); }

/**
 * Return the message (if any) for this error . If there is no
 * message for the exception and there is an encapsulated
 * exception then the message of that exception will be returned.
 *
 * @return The error message.
 */

public java.lang.String getMessage() { throw new RuntimeException("Stub!"); }

/**
 * Return the actual exception (if any) that caused this exception to
 * be raised.
 *
 * @return The encapsulated exception, or null if there is none.
 */

public java.lang.Exception getException() { throw new RuntimeException("Stub!"); }
}

