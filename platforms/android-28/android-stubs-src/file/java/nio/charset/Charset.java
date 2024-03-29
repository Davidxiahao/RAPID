/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.nio.charset;

import java.nio.charset.spi.CharsetProvider;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * A named mapping between sequences of sixteen-bit Unicode <a
 * href="../../lang/Character.html#unicode">code units</a> and sequences of
 * bytes.  This class defines methods for creating decoders and encoders and
 * for retrieving the various names associated with a charset.  Instances of
 * this class are immutable.
 *
 * <p> This class also defines static methods for testing whether a particular
 * charset is supported, for locating charset instances by name, and for
 * constructing a map that contains every charset for which support is
 * available in the current Java virtual machine.  Support for new charsets can
 * be added via the service-provider interface defined in the {@link
 * java.nio.charset.spi.CharsetProvider} class.
 *
 * <p> All of the methods defined in this class are safe for use by multiple
 * concurrent threads.
 *
 *
 * <a name="names"></a><a name="charenc"></a>
 * <h2>Charset names</h2>
 *
 * <p> Charsets are named by strings composed of the following characters:
 *
 * <ul>
 *
 *   <li> The uppercase letters <tt>'A'</tt> through <tt>'Z'</tt>
 *        (<tt>'&#92;u0041'</tt>&nbsp;through&nbsp;<tt>'&#92;u005a'</tt>),
 *
 *   <li> The lowercase letters <tt>'a'</tt> through <tt>'z'</tt>
 *        (<tt>'&#92;u0061'</tt>&nbsp;through&nbsp;<tt>'&#92;u007a'</tt>),
 *
 *   <li> The digits <tt>'0'</tt> through <tt>'9'</tt>
 *        (<tt>'&#92;u0030'</tt>&nbsp;through&nbsp;<tt>'&#92;u0039'</tt>),
 *
 *   <li> The dash character <tt>'-'</tt>
 *        (<tt>'&#92;u002d'</tt>,&nbsp;<small>HYPHEN-MINUS</small>),
 *
 *   <li> The plus character <tt>'+'</tt>
 *        (<tt>'&#92;u002b'</tt>,&nbsp;<small>PLUS SIGN</small>),
 *
 *   <li> The period character <tt>'.'</tt>
 *        (<tt>'&#92;u002e'</tt>,&nbsp;<small>FULL STOP</small>),
 *
 *   <li> The colon character <tt>':'</tt>
 *        (<tt>'&#92;u003a'</tt>,&nbsp;<small>COLON</small>), and
 *
 *   <li> The underscore character <tt>'_'</tt>
 *        (<tt>'&#92;u005f'</tt>,&nbsp;<small>LOW&nbsp;LINE</small>).
 *
 * </ul>
 *
 * A charset name must begin with either a letter or a digit.  The empty string
 * is not a legal charset name.  Charset names are not case-sensitive; that is,
 * case is always ignored when comparing charset names.  Charset names
 * generally follow the conventions documented in <a
 * href="http://www.ietf.org/rfc/rfc2278.txt"><i>RFC&nbsp;2278:&nbsp;IANA Charset
 * Registration Procedures</i></a>.
 *
 * <p> Every charset has a <i>canonical name</i> and may also have one or more
 * <i>aliases</i>.  The canonical name is returned by the {@link #name() name} method
 * of this class.  Canonical names are, by convention, usually in upper case.
 * The aliases of a charset are returned by the {@link #aliases() aliases}
 * method.
 *
 * <p><a name="hn">Some charsets have an <i>historical name</i> that is defined for
 * compatibility with previous versions of the Java platform.</a>  A charset's
 * historical name is either its canonical name or one of its aliases.  The
 * historical name is returned by the <tt>getEncoding()</tt> methods of the
 * {@link java.io.InputStreamReader#getEncoding InputStreamReader} and {@link
 * java.io.OutputStreamWriter#getEncoding OutputStreamWriter} classes.
 *
 * <p><a name="iana"> </a>If a charset listed in the <a
 * href="http://www.iana.org/assignments/character-sets"><i>IANA Charset
 * Registry</i></a> is supported by an implementation of the Java platform then
 * its canonical name must be the name listed in the registry. Many charsets
 * are given more than one name in the registry, in which case the registry
 * identifies one of the names as <i>MIME-preferred</i>.  If a charset has more
 * than one registry name then its canonical name must be the MIME-preferred
 * name and the other names in the registry must be valid aliases.  If a
 * supported charset is not listed in the IANA registry then its canonical name
 * must begin with one of the strings <tt>"X-"</tt> or <tt>"x-"</tt>.
 *
 * <p> The IANA charset registry does change over time, and so the canonical
 * name and the aliases of a particular charset may also change over time.  To
 * ensure compatibility it is recommended that no alias ever be removed from a
 * charset, and that if the canonical name of a charset is changed then its
 * previous canonical name be made into an alias.
 *
 *
 * <h2>Standard charsets</h2>
 *
 *
 *
 * <p><a name="standard">Every implementation of the Java platform is required to support the
 * following standard charsets.</a>  Consult the release documentation for your
 * implementation to see if any other charsets are supported.  The behavior
 * of such optional charsets may differ between implementations.
 *
 * <blockquote><table width="80%" summary="Description of standard charsets">
 * <tr><th align="left">Charset</th><th align="left">Description</th></tr>
 * <tr><td valign=top><tt>US-ASCII</tt></td>
 *     <td>Seven-bit ASCII, a.k.a. <tt>ISO646-US</tt>,
 *         a.k.a. the Basic Latin block of the Unicode character set</td></tr>
 * <tr><td valign=top><tt>ISO-8859-1&nbsp;&nbsp;</tt></td>
 *     <td>ISO Latin Alphabet No. 1, a.k.a. <tt>ISO-LATIN-1</tt></td></tr>
 * <tr><td valign=top><tt>UTF-8</tt></td>
 *     <td>Eight-bit UCS Transformation Format</td></tr>
 * <tr><td valign=top><tt>UTF-16BE</tt></td>
 *     <td>Sixteen-bit UCS Transformation Format,
 *         big-endian byte&nbsp;order</td></tr>
 * <tr><td valign=top><tt>UTF-16LE</tt></td>
 *     <td>Sixteen-bit UCS Transformation Format,
 *         little-endian byte&nbsp;order</td></tr>
 * <tr><td valign=top><tt>UTF-16</tt></td>
 *     <td>Sixteen-bit UCS Transformation Format,
 *         byte&nbsp;order identified by an optional byte-order mark</td></tr>
 * </table></blockquote>
 *
 * <p> The <tt>UTF-8</tt> charset is specified by <a
 * href="http://www.ietf.org/rfc/rfc2279.txt"><i>RFC&nbsp;2279</i></a>; the
 * transformation format upon which it is based is specified in
 * Amendment&nbsp;2 of ISO&nbsp;10646-1 and is also described in the <a
 * href="http://www.unicode.org/unicode/standard/standard.html"><i>Unicode
 * Standard</i></a>.
 *
 * <p> The <tt>UTF-16</tt> charsets are specified by <a
 * href="http://www.ietf.org/rfc/rfc2781.txt"><i>RFC&nbsp;2781</i></a>; the
 * transformation formats upon which they are based are specified in
 * Amendment&nbsp;1 of ISO&nbsp;10646-1 and are also described in the <a
 * href="http://www.unicode.org/unicode/standard/standard.html"><i>Unicode
 * Standard</i></a>.
 *
 * <p> The <tt>UTF-16</tt> charsets use sixteen-bit quantities and are
 * therefore sensitive to byte order.  In these encodings the byte order of a
 * stream may be indicated by an initial <i>byte-order mark</i> represented by
 * the Unicode character <tt>'&#92;uFEFF'</tt>.  Byte-order marks are handled
 * as follows:
 *
 * <ul>
 *
 *   <li><p> When decoding, the <tt>UTF-16BE</tt> and <tt>UTF-16LE</tt>
 *   charsets interpret the initial byte-order marks as a <small>ZERO-WIDTH
 *   NON-BREAKING SPACE</small>; when encoding, they do not write
 *   byte-order marks. </p></li>
 
 *
 *   <li><p> When decoding, the <tt>UTF-16</tt> charset interprets the
 *   byte-order mark at the beginning of the input stream to indicate the
 *   byte-order of the stream but defaults to big-endian if there is no
 *   byte-order mark; when encoding, it uses big-endian byte order and writes
 *   a big-endian byte-order mark. </p></li>
 *
 * </ul>
 *
 * In any case, byte order marks occurring after the first element of an
 * input sequence are not omitted since the same code is used to represent
 * <small>ZERO-WIDTH NON-BREAKING SPACE</small>.
 *
 * <p>Android note: The Android platform default is always UTF-8.
 *
 * <p>The {@link StandardCharsets} class defines constants for each of the
 * standard charsets.
 *
 * <h2>Terminology</h2>
 *
 * <p> The name of this class is taken from the terms used in
 * <a href="http://www.ietf.org/rfc/rfc2278.txt"><i>RFC&nbsp;2278</i></a>.
 * In that document a <i>charset</i> is defined as the combination of
 * one or more coded character sets and a character-encoding scheme.
 * (This definition is confusing; some other software systems define
 * <i>charset</i> as a synonym for <i>coded character set</i>.)
 *
 * <p> A <i>coded character set</i> is a mapping between a set of abstract
 * characters and a set of integers.  US-ASCII, ISO&nbsp;8859-1,
 * JIS&nbsp;X&nbsp;0201, and Unicode are examples of coded character sets.
 *
 * <p> Some standards have defined a <i>character set</i> to be simply a
 * set of abstract characters without an associated assigned numbering.
 * An alphabet is an example of such a character set.  However, the subtle
 * distinction between <i>character set</i> and <i>coded character set</i>
 * is rarely used in practice; the former has become a short form for the
 * latter, including in the Java API specification.
 *
 * <p> A <i>character-encoding scheme</i> is a mapping between one or more
 * coded character sets and a set of octet (eight-bit byte) sequences.
 * UTF-8, UTF-16, ISO&nbsp;2022, and EUC are examples of
 * character-encoding schemes.  Encoding schemes are often associated with
 * a particular coded character set; UTF-8, for example, is used only to
 * encode Unicode.  Some schemes, however, are associated with multiple
 * coded character sets; EUC, for example, can be used to encode
 * characters in a variety of Asian coded character sets.
 *
 * <p> When a coded character set is used exclusively with a single
 * character-encoding scheme then the corresponding charset is usually
 * named for the coded character set; otherwise a charset is usually named
 * for the encoding scheme and, possibly, the locale of the coded
 * character sets that it supports.  Hence <tt>US-ASCII</tt> is both the
 * name of a coded character set and of the charset that encodes it, while
 * <tt>EUC-JP</tt> is the name of the charset that encodes the
 * JIS&nbsp;X&nbsp;0201, JIS&nbsp;X&nbsp;0208, and JIS&nbsp;X&nbsp;0212
 * coded character sets for the Japanese language.
 *
 * <p> The native character encoding of the Java programming language is
 * UTF-16.  A charset in the Java platform therefore defines a mapping
 * between sequences of sixteen-bit UTF-16 code units (that is, sequences
 * of chars) and sequences of bytes. </p>
 *
 *
 * @author Mark Reinhold
 * @author JSR-51 Expert Group
 * @since 1.4
 *
 * @see CharsetDecoder
 * @see CharsetEncoder
 * @see java.nio.charset.spi.CharsetProvider
 * @see java.lang.Character
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public abstract class Charset implements java.lang.Comparable<java.nio.charset.Charset> {

/**
 * Initializes a new charset with the given canonical name and alias
 * set.
 *
 * @param  canonicalName
 *         The canonical name of this charset
 *
 * @param  aliases
 *         An array of this charset's aliases, or null if it has no aliases
 *
 * @throws IllegalCharsetNameException
 *         If the canonical name or any of the aliases are illegal
 */

protected Charset(java.lang.String canonicalName, java.lang.String[] aliases) { throw new RuntimeException("Stub!"); }

/**
 * Tells whether the named charset is supported.
 *
 * @param  charsetName
 *         The name of the requested charset; may be either
 *         a canonical name or an alias
 *
 * @return  <tt>true</tt> if, and only if, support for the named charset
 *          is available in the current Java virtual machine
 *
 * @throws IllegalCharsetNameException
 *         If the given charset name is illegal
 *
 * @throws  IllegalArgumentException
 *          If the given <tt>charsetName</tt> is null
 */

public static boolean isSupported(java.lang.String charsetName) { throw new RuntimeException("Stub!"); }

/**
 * Returns a charset object for the named charset.
 *
 * @param  charsetName
 *         The name of the requested charset; may be either
 *         a canonical name or an alias
 *
 * @return  A charset object for the named charset
 *
 * @throws  IllegalCharsetNameException
 *          If the given charset name is illegal
 *
 * @throws  IllegalArgumentException
 *          If the given <tt>charsetName</tt> is null
 *
 * @throws  UnsupportedCharsetException
 *          If no support for the named charset is available
 *          in this instance of the Java virtual machine
 */

public static java.nio.charset.Charset forName(java.lang.String charsetName) { throw new RuntimeException("Stub!"); }

/**
 * Constructs a sorted map from canonical charset names to charset objects.
 *
 * <p> The map returned by this method will have one entry for each charset
 * for which support is available in the current Java virtual machine.  If
 * two or more supported charsets have the same canonical name then the
 * resulting map will contain just one of them; which one it will contain
 * is not specified. </p>
 *
 * <p> The invocation of this method, and the subsequent use of the
 * resulting map, may cause time-consuming disk or network I/O operations
 * to occur.  This method is provided for applications that need to
 * enumerate all of the available charsets, for example to allow user
 * charset selection.  This method is not used by the {@link #forName
 * forName} method, which instead employs an efficient incremental lookup
 * algorithm.
 *
 * <p> This method may return different results at different times if new
 * charset providers are dynamically made available to the current Java
 * virtual machine.  In the absence of such changes, the charsets returned
 * by this method are exactly those that can be retrieved via the {@link
 * #forName forName} method.  </p>
 *
 * @return An immutable, case-insensitive map from canonical charset names
 *         to charset objects
 */

public static java.util.SortedMap<java.lang.String, java.nio.charset.Charset> availableCharsets() { throw new RuntimeException("Stub!"); }

/**
 * Returns the default charset of this Java virtual machine.
 *
 * <p>Android note: The Android platform default is always UTF-8.
 *
 * @return  A charset object for the default charset
 *
 * @since 1.5
 */

public static java.nio.charset.Charset defaultCharset() { throw new RuntimeException("Stub!"); }

/**
 * Returns this charset's canonical name.
 *
 * @return  The canonical name of this charset
 */

public final java.lang.String name() { throw new RuntimeException("Stub!"); }

/**
 * Returns a set containing this charset's aliases.
 *
 * @return  An immutable set of this charset's aliases
 */

public final java.util.Set<java.lang.String> aliases() { throw new RuntimeException("Stub!"); }

/**
 * Returns this charset's human-readable name for the default locale.
 *
 * <p> The default implementation of this method simply returns this
 * charset's canonical name.  Concrete subclasses of this class may
 * override this method in order to provide a localized display name. </p>
 *
 * @return  The display name of this charset in the default locale
 */

public java.lang.String displayName() { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not this charset is registered in the <a
 * href="http://www.iana.org/assignments/character-sets">IANA Charset
 * Registry</a>.
 *
 * @return  <tt>true</tt> if, and only if, this charset is known by its
 *          implementor to be registered with the IANA
 */

public final boolean isRegistered() { throw new RuntimeException("Stub!"); }

/**
 * Returns this charset's human-readable name for the given locale.
 *
 * <p> The default implementation of this method simply returns this
 * charset's canonical name.  Concrete subclasses of this class may
 * override this method in order to provide a localized display name. </p>
 *
 * @param  locale
 *         The locale for which the display name is to be retrieved
 *
 * @return  The display name of this charset in the given locale
 */

public java.lang.String displayName(java.util.Locale locale) { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not this charset contains the given charset.
 *
 * <p> A charset <i>C</i> is said to <i>contain</i> a charset <i>D</i> if,
 * and only if, every character representable in <i>D</i> is also
 * representable in <i>C</i>.  If this relationship holds then it is
 * guaranteed that every string that can be encoded in <i>D</i> can also be
 * encoded in <i>C</i> without performing any replacements.
 *
 * <p> That <i>C</i> contains <i>D</i> does not imply that each character
 * representable in <i>C</i> by a particular byte sequence is represented
 * in <i>D</i> by the same byte sequence, although sometimes this is the
 * case.
 *
 * <p> Every charset contains itself.
 *
 * <p> This method computes an approximation of the containment relation:
 * If it returns <tt>true</tt> then the given charset is known to be
 * contained by this charset; if it returns <tt>false</tt>, however, then
 * it is not necessarily the case that the given charset is not contained
 * in this charset.
 *
 * @param   cs
 *          The given charset
 *
 * @return  <tt>true</tt> if the given charset is contained in this charset
 */

public abstract boolean contains(java.nio.charset.Charset cs);

/**
 * Constructs a new decoder for this charset.
 *
 * @return  A new decoder for this charset
 */

public abstract java.nio.charset.CharsetDecoder newDecoder();

/**
 * Constructs a new encoder for this charset.
 *
 * @return  A new encoder for this charset
 *
 * @throws  UnsupportedOperationException
 *          If this charset does not support encoding
 */

public abstract java.nio.charset.CharsetEncoder newEncoder();

/**
 * Tells whether or not this charset supports encoding.
 *
 * <p> Nearly all charsets support encoding.  The primary exceptions are
 * special-purpose <i>auto-detect</i> charsets whose decoders can determine
 * which of several possible encoding schemes is in use by examining the
 * input byte sequence.  Such charsets do not support encoding because
 * there is no way to determine which encoding should be used on output.
 * Implementations of such charsets should override this method to return
 * <tt>false</tt>. </p>
 *
 * @return  <tt>true</tt> if, and only if, this charset supports encoding
 */

public boolean canEncode() { throw new RuntimeException("Stub!"); }

/**
 * Convenience method that decodes bytes in this charset into Unicode
 * characters.
 *
 * <p> An invocation of this method upon a charset <tt>cs</tt> returns the
 * same result as the expression
 *
 * <pre>
 *     cs.newDecoder()
 *       .onMalformedInput(CodingErrorAction.REPLACE)
 *       .onUnmappableCharacter(CodingErrorAction.REPLACE)
 *       .decode(bb); </pre>
 *
 * except that it is potentially more efficient because it can cache
 * decoders between successive invocations.
 *
 * <p> This method always replaces malformed-input and unmappable-character
 * sequences with this charset's default replacement byte array.  In order
 * to detect such sequences, use the {@link
 * CharsetDecoder#decode(java.nio.ByteBuffer)} method directly.  </p>
 *
 * @param  bb  The byte buffer to be decoded
 *
 * @return  A char buffer containing the decoded characters
 */

public final java.nio.CharBuffer decode(java.nio.ByteBuffer bb) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method that encodes Unicode characters into bytes in this
 * charset.
 *
 * <p> An invocation of this method upon a charset <tt>cs</tt> returns the
 * same result as the expression
 *
 * <pre>
 *     cs.newEncoder()
 *       .onMalformedInput(CodingErrorAction.REPLACE)
 *       .onUnmappableCharacter(CodingErrorAction.REPLACE)
 *       .encode(bb); </pre>
 *
 * except that it is potentially more efficient because it can cache
 * encoders between successive invocations.
 *
 * <p> This method always replaces malformed-input and unmappable-character
 * sequences with this charset's default replacement string.  In order to
 * detect such sequences, use the {@link
 * CharsetEncoder#encode(java.nio.CharBuffer)} method directly.  </p>
 *
 * @param  cb  The char buffer to be encoded
 *
 * @return  A byte buffer containing the encoded characters
 */

public final java.nio.ByteBuffer encode(java.nio.CharBuffer cb) { throw new RuntimeException("Stub!"); }

/**
 * Convenience method that encodes a string into bytes in this charset.
 *
 * <p> An invocation of this method upon a charset <tt>cs</tt> returns the
 * same result as the expression
 *
 * <pre>
 *     cs.encode(CharBuffer.wrap(s)); </pre>
 *
 * @param  str  The string to be encoded
 *
 * @return  A byte buffer containing the encoded characters
 */

public final java.nio.ByteBuffer encode(java.lang.String str) { throw new RuntimeException("Stub!"); }

/**
 * Compares this charset to another.
 *
 * <p> Charsets are ordered by their canonical names, without regard to
 * case. </p>
 *
 * @param  that
 *         The charset to which this charset is to be compared
 *
 * @return A negative integer, zero, or a positive integer as this charset
 *         is less than, equal to, or greater than the specified charset
 */

public final int compareTo(java.nio.charset.Charset that) { throw new RuntimeException("Stub!"); }

/**
 * Computes a hashcode for this charset.
 *
 * @return  An integer hashcode
 */

public final int hashCode() { throw new RuntimeException("Stub!"); }

/**
 * Tells whether or not this object is equal to another.
 *
 * <p> Two charsets are equal if, and only if, they have the same canonical
 * names.  A charset is never equal to any other type of object.  </p>
 *
 * @return  <tt>true</tt> if, and only if, this charset is equal to the
 *          given object
 */

public final boolean equals(java.lang.Object ob) { throw new RuntimeException("Stub!"); }

/**
 * Returns a string describing this charset.
 *
 * @return  A string describing this charset
 */

public final java.lang.String toString() { throw new RuntimeException("Stub!"); }
}

