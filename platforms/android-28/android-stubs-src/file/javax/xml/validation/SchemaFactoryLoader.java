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
// $Id: SchemaFactoryLoader.java 448801 2006-09-22 04:19:20Z mrglavas $


package javax.xml.validation;


/**
 * <p>This class was removed from JAXP 1.3 before it was finalized but
 * was mistakenly included in Java 5. It only exists now for compatibility
 * reasons. Applications should avoid using it.</p>
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class SchemaFactoryLoader {

protected SchemaFactoryLoader() { throw new RuntimeException("Stub!"); }

public abstract javax.xml.validation.SchemaFactory newFactory(java.lang.String schemaLanguage);
}

