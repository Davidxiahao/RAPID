/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.sax;

import org.xml.sax.ContentHandler;

/**
 * The root XML element. The entry point for this API. Not safe for concurrent
 * use.
 *
 * <p>For example, passing this XML:
 *
 * <pre>
 * &lt;feed xmlns='http://www.w3.org/2005/Atom'>
 *   &lt;entry>
 *     &lt;id>bob&lt;/id>
 *   &lt;/entry>
 * &lt;/feed>
 * </pre>
 *
 * to this code:
 *
 * <pre>
 * static final String ATOM_NAMESPACE = "http://www.w3.org/2005/Atom";
 *
 * ...
 *
 * RootElement root = new RootElement(ATOM_NAMESPACE, "feed");
 * Element entry = root.getChild(ATOM_NAMESPACE, "entry");
 * entry.getChild(ATOM_NAMESPACE, "id").setEndTextElementListener(
 *   new EndTextElementListener() {
 *     public void end(String body) {
 *       System.out.println("Entry ID: " + body);
 *     }
 *   });
 *
 * XMLReader reader = ...;
 * reader.setContentHandler(root.getContentHandler());
 * reader.parse(...);
 * </pre>
 *
 * would output:
 *
 * <pre>
 * Entry ID: bob
 * </pre>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public class RootElement extends android.sax.Element {

/**
 * Constructs a new root element with the given name.
 *
 * @param uri the namespace
 * @param localName the local name
 */

public RootElement(java.lang.String uri, java.lang.String localName) { super(null, null, null, 0); throw new RuntimeException("Stub!"); }

/**
 * Constructs a new root element with the given name. Uses an empty string
 * as the namespace.
 *
 * @param localName the local name
 */

public RootElement(java.lang.String localName) { super(null, null, null, 0); throw new RuntimeException("Stub!"); }

/**
 * Gets the SAX {@code ContentHandler}. Pass this to your SAX parser.
 */

public org.xml.sax.ContentHandler getContentHandler() { throw new RuntimeException("Stub!"); }
}

