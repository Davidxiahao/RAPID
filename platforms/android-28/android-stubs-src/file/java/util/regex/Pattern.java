/*
 * Copyright (C) 2014 The Android Open Source Project
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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


package java.util.regex;


/**
 * A compiled representation of a regular expression.
 *
 * <p> A regular expression, specified as a string, must first be compiled into
 * an instance of this class.  The resulting pattern can then be used to create
 * a {@link Matcher} object that can match arbitrary {@link
 * java.lang.CharSequence </code>character sequences<code>} against the regular
 * expression.  All of the state involved in performing a match resides in the
 * matcher, so many matchers can share the same pattern.
 *
 * <p> A typical invocation sequence is thus
 *
 * <blockquote><pre>
 * Pattern p = Pattern.{@link #compile compile}("a*b");
 * Matcher m = p.{@link #matcher matcher}("aaaaab");
 * boolean b = m.{@link Matcher#matches matches}();</pre></blockquote>
 *
 * <p> A {@link #matches matches} method is defined by this class as a
 * convenience for when a regular expression is used just once.  This method
 * compiles an expression and matches an input sequence against it in a single
 * invocation.  The statement
 *
 * <blockquote><pre>
 * boolean b = Pattern.matches("a*b", "aaaaab");</pre></blockquote>
 *
 * is equivalent to the three statements above, though for repeated matches it
 * is less efficient since it does not allow the compiled pattern to be reused.
 *
 * <p> Instances of this class are immutable and are safe for use by multiple
 * concurrent threads.  Instances of the {@link Matcher} class are not safe for
 * such use.
 *
 *
 * <a name="sum">
 * <h4> Summary of regular-expression constructs </h4>
 *
 * <table border="0" cellpadding="1" cellspacing="0"
 *  summary="Regular expression constructs, and what they match">
 *
 * <tr align="left">
 * <th bgcolor="#CCCCFF" align="left" id="construct">Construct</th>
 * <th bgcolor="#CCCCFF" align="left" id="matches">Matches</th>
 * </tr>
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2" id="characters">Characters</th></tr>
 *
 * <tr><td valign="top" headers="construct characters"><i>x</i></td>
 *     <td headers="matches">The character <i>x</i></td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>\\</tt></td>
 *     <td headers="matches">The backslash character</td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>\0</tt><i>n</i></td>
 *     <td headers="matches">The character with octal value <tt>0</tt><i>n</i>
 *         (0&nbsp;<tt>&lt;=</tt>&nbsp;<i>n</i>&nbsp;<tt>&lt;=</tt>&nbsp;7)</td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>\0</tt><i>nn</i></td>
 *     <td headers="matches">The character with octal value <tt>0</tt><i>nn</i>
 *         (0&nbsp;<tt>&lt;=</tt>&nbsp;<i>n</i>&nbsp;<tt>&lt;=</tt>&nbsp;7)</td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>\0</tt><i>mnn</i></td>
 *     <td headers="matches">The character with octal value <tt>0</tt><i>mnn</i>
 *         (0&nbsp;<tt>&lt;=</tt>&nbsp;<i>m</i>&nbsp;<tt>&lt;=</tt>&nbsp;3,
 *         0&nbsp;<tt>&lt;=</tt>&nbsp;<i>n</i>&nbsp;<tt>&lt;=</tt>&nbsp;7)</td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>\x</tt><i>hh</i></td>
 *     <td headers="matches">The character with hexadecimal&nbsp;value&nbsp;<tt>0x</tt><i>hh</i></td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>&#92;u</tt><i>hhhh</i></td>
 *     <td headers="matches">The character with hexadecimal&nbsp;value&nbsp;<tt>0x</tt><i>hhhh</i></td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>&#92;x</tt><i>{h...h}</i></td>
 *     <td headers="matches">The character with hexadecimal&nbsp;value&nbsp;<tt>0x</tt><i>h...h</i>
 *         ({@link java.lang.Character#MIN_CODE_POINT Character.MIN_CODE_POINT}
 *         &nbsp;&lt;=&nbsp;<tt>0x</tt><i>h...h</i>&nbsp;&lt;=&nbsp
 *          {@link java.lang.Character#MAX_CODE_POINT Character.MAX_CODE_POINT})</td></tr>
 * <tr><td valign="top" headers="matches"><tt>\t</tt></td>
 *     <td headers="matches">The tab character (<tt>'&#92;u0009'</tt>)</td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>\n</tt></td>
 *     <td headers="matches">The newline (line feed) character (<tt>'&#92;u000A'</tt>)</td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>\r</tt></td>
 *     <td headers="matches">The carriage-return character (<tt>'&#92;u000D'</tt>)</td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>\f</tt></td>
 *     <td headers="matches">The form-feed character (<tt>'&#92;u000C'</tt>)</td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>\a</tt></td>
 *     <td headers="matches">The alert (bell) character (<tt>'&#92;u0007'</tt>)</td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>\e</tt></td>
 *     <td headers="matches">The escape character (<tt>'&#92;u001B'</tt>)</td></tr>
 * <tr><td valign="top" headers="construct characters"><tt>\c</tt><i>x</i></td>
 *     <td headers="matches">The control character corresponding to <i>x</i></td></tr>
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2" id="classes">Character classes</th></tr>
 *
 * <tr><td valign="top" headers="construct classes"><tt>[abc]</tt></td>
 *     <td headers="matches"><tt>a</tt>, <tt>b</tt>, or <tt>c</tt> (simple class)</td></tr>
 * <tr><td valign="top" headers="construct classes"><tt>[^abc]</tt></td>
 *     <td headers="matches">Any character except <tt>a</tt>, <tt>b</tt>, or <tt>c</tt> (negation)</td></tr>
 * <tr><td valign="top" headers="construct classes"><tt>[a-zA-Z]</tt></td>
 *     <td headers="matches"><tt>a</tt> through <tt>z</tt>
 *         or <tt>A</tt> through <tt>Z</tt>, inclusive (range)</td></tr>
 * <tr><td valign="top" headers="construct classes"><tt>[a-d[m-p]]</tt></td>
 *     <td headers="matches"><tt>a</tt> through <tt>d</tt>,
 *      or <tt>m</tt> through <tt>p</tt>: <tt>[a-dm-p]</tt> (union)</td></tr>
 * <tr><td valign="top" headers="construct classes"><tt>[a-z&&[def]]</tt></td>
 *     <td headers="matches"><tt>d</tt>, <tt>e</tt>, or <tt>f</tt> (intersection)</tr>
 * <tr><td valign="top" headers="construct classes"><tt>[a-z&&[^bc]]</tt></td>
 *     <td headers="matches"><tt>a</tt> through <tt>z</tt>,
 *         except for <tt>b</tt> and <tt>c</tt>: <tt>[ad-z]</tt> (subtraction)</td></tr>
 * <tr><td valign="top" headers="construct classes"><tt>[a-z&&[^m-p]]</tt></td>
 *     <td headers="matches"><tt>a</tt> through <tt>z</tt>,
 *          and not <tt>m</tt> through <tt>p</tt>: <tt>[a-lq-z]</tt>(subtraction)</td></tr>
 * <tr><th>&nbsp;</th></tr>
 *
 * <tr align="left"><th colspan="2" id="predef">Predefined character classes</th></tr>
 *
 * <tr><td valign="top" headers="construct predef"><tt>.</tt></td>
 *     <td headers="matches">Any character (may or may not match <a href="#lt">line terminators</a>)</td></tr>
 * <tr><td valign="top" headers="construct predef"><tt>\d</tt></td>
 *     <td headers="matches">A digit: <tt>[0-9]</tt></td></tr>
 * <tr><td valign="top" headers="construct predef"><tt>\D</tt></td>
 *     <td headers="matches">A non-digit: <tt>[^0-9]</tt></td></tr>
 * <tr><td valign="top" headers="construct predef"><tt>\s</tt></td>
 *     <td headers="matches">A whitespace character: <tt>[ \t\n\x0B\f\r]</tt></td></tr>
 * <tr><td valign="top" headers="construct predef"><tt>\S</tt></td>
 *     <td headers="matches">A non-whitespace character: <tt>[^\s]</tt></td></tr>
 * <tr><td valign="top" headers="construct predef"><tt>\w</tt></td>
 *     <td headers="matches">A word character: <tt>[a-zA-Z_0-9]</tt></td></tr>
 * <tr><td valign="top" headers="construct predef"><tt>\W</tt></td>
 *     <td headers="matches">A non-word character: <tt>[^\w]</tt></td></tr>
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2" id="posix">POSIX character classes</b> (US-ASCII only)<b></th></tr>
 *
 * <tr><td valign="top" headers="construct posix"><tt>\p{Lower}</tt></td>
 *     <td headers="matches">A lower-case alphabetic character: <tt>[a-z]</tt></td></tr>
 * <tr><td valign="top" headers="construct posix"><tt>\p{Upper}</tt></td>
 *     <td headers="matches">An upper-case alphabetic character:<tt>[A-Z]</tt></td></tr>
 * <tr><td valign="top" headers="construct posix"><tt>\p{ASCII}</tt></td>
 *     <td headers="matches">All ASCII:<tt>[\x00-\x7F]</tt></td></tr>
 * <tr><td valign="top" headers="construct posix"><tt>\p{Alpha}</tt></td>
 *     <td headers="matches">An alphabetic character:<tt>[\p{Lower}\p{Upper}]</tt></td></tr>
 * <tr><td valign="top" headers="construct posix"><tt>\p{Digit}</tt></td>
 *     <td headers="matches">A decimal digit: <tt>[0-9]</tt></td></tr>
 * <tr><td valign="top" headers="construct posix"><tt>\p{Alnum}</tt></td>
 *     <td headers="matches">An alphanumeric character:<tt>[\p{Alpha}\p{Digit}]</tt></td></tr>
 * <tr><td valign="top" headers="construct posix"><tt>\p{Punct}</tt></td>
 *     <td headers="matches">Punctuation: One of <tt>!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~</tt></td></tr>
 *     <!-- <tt>[\!"#\$%&'\(\)\*\+,\-\./:;\<=\>\?@\[\\\]\^_`\{\|\}~]</tt>
 *          <tt>[\X21-\X2F\X31-\X40\X5B-\X60\X7B-\X7E]</tt> -->
 * <tr><td valign="top" headers="construct posix"><tt>\p{Graph}</tt></td>
 *     <td headers="matches">A visible character: <tt>[\p{Alnum}\p{Punct}]</tt></td></tr>
 * <tr><td valign="top" headers="construct posix"><tt>\p{Print}</tt></td>
 *     <td headers="matches">A printable character: <tt>[\p{Graph}\x20]</tt></td></tr>
 * <tr><td valign="top" headers="construct posix"><tt>\p{Blank}</tt></td>
 *     <td headers="matches">A space or a tab: <tt>[ \t]</tt></td></tr>
 * <tr><td valign="top" headers="construct posix"><tt>\p{Cntrl}</tt></td>
 *     <td headers="matches">A control character: <tt>[\x00-\x1F\x7F]</tt></td></tr>
 * <tr><td valign="top" headers="construct posix"><tt>\p{XDigit}</tt></td>
 *     <td headers="matches">A hexadecimal digit: <tt>[0-9a-fA-F]</tt></td></tr>
 * <tr><td valign="top" headers="construct posix"><tt>\p{Space}</tt></td>
 *     <td headers="matches">A whitespace character: <tt>[ \t\n\x0B\f\r]</tt></td></tr>
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2">java.lang.Character classes (simple <a href="#jcc">java character type</a>)</th></tr>
 *
 * <tr><td valign="top"><tt>\p{javaLowerCase}</tt></td>
 *     <td>Equivalent to java.lang.Character.isLowerCase()</td></tr>
 * <tr><td valign="top"><tt>\p{javaUpperCase}</tt></td>
 *     <td>Equivalent to java.lang.Character.isUpperCase()</td></tr>
 * <tr><td valign="top"><tt>\p{javaWhitespace}</tt></td>
 *     <td>Equivalent to java.lang.Character.isWhitespace()</td></tr>
 * <tr><td valign="top"><tt>\p{javaMirrored}</tt></td>
 *     <td>Equivalent to java.lang.Character.isMirrored()</td></tr>
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2" id="unicode">Classes for Unicode scripts, blocks, categories and binary properties</th></tr>
 * * <tr><td valign="top" headers="construct unicode"><tt>\p{IsLatin}</tt></td>
 *     <td headers="matches">A Latin&nbsp;script character (<a href="#usc">script</a>)</td></tr>
 * <tr><td valign="top" headers="construct unicode"><tt>\p{InGreek}</tt></td>
 *     <td headers="matches">A character in the Greek&nbsp;block (<a href="#ubc">block</a>)</td></tr>
 * <tr><td valign="top" headers="construct unicode"><tt>\p{Lu}</tt></td>
 *     <td headers="matches">An uppercase letter (<a href="#ucc">category</a>)</td></tr>
 * <tr><td valign="top" headers="construct unicode"><tt>\p{IsAlphabetic}</tt></td>
 *     <td headers="matches">An alphabetic character (<a href="#ubpc">binary property</a>)</td></tr>
 * <tr><td valign="top" headers="construct unicode"><tt>\p{Sc}</tt></td>
 *     <td headers="matches">A currency symbol</td></tr>
 * <tr><td valign="top" headers="construct unicode"><tt>\P{InGreek}</tt></td>
 *     <td headers="matches">Any character except one in the Greek block (negation)</td></tr>
 * <tr><td valign="top" headers="construct unicode"><tt>[\p{L}&&[^\p{Lu}]]&nbsp;</tt></td>
 *     <td headers="matches">Any letter except an uppercase letter (subtraction)</td></tr>
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2" id="bounds">Boundary matchers</th></tr>
 *
 * <tr><td valign="top" headers="construct bounds"><tt>^</tt></td>
 *     <td headers="matches">The beginning of a line</td></tr>
 * <tr><td valign="top" headers="construct bounds"><tt>$</tt></td>
 *     <td headers="matches">The end of a line</td></tr>
 * <tr><td valign="top" headers="construct bounds"><tt>\b</tt></td>
 *     <td headers="matches">A word boundary</td></tr>
 * <tr><td valign="top" headers="construct bounds"><tt>\B</tt></td>
 *     <td headers="matches">A non-word boundary</td></tr>
 * <tr><td valign="top" headers="construct bounds"><tt>\A</tt></td>
 *     <td headers="matches">The beginning of the input</td></tr>
 * <tr><td valign="top" headers="construct bounds"><tt>\G</tt></td>
 *     <td headers="matches">The end of the previous match</td></tr>
 * <tr><td valign="top" headers="construct bounds"><tt>\Z</tt></td>
 *     <td headers="matches">The end of the input but for the final
 *         <a href="#lt">terminator</a>, if&nbsp;any</td></tr>
 * <tr><td valign="top" headers="construct bounds"><tt>\z</tt></td>
 *     <td headers="matches">The end of the input</td></tr>
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2" id="greedy">Greedy quantifiers</th></tr>
 *
 * <tr><td valign="top" headers="construct greedy"><i>X</i><tt>?</tt></td>
 *     <td headers="matches"><i>X</i>, once or not at all</td></tr>
 * <tr><td valign="top" headers="construct greedy"><i>X</i><tt>*</tt></td>
 *     <td headers="matches"><i>X</i>, zero or more times</td></tr>
 * <tr><td valign="top" headers="construct greedy"><i>X</i><tt>+</tt></td>
 *     <td headers="matches"><i>X</i>, one or more times</td></tr>
 * <tr><td valign="top" headers="construct greedy"><i>X</i><tt>{</tt><i>n</i><tt>}</tt></td>
 *     <td headers="matches"><i>X</i>, exactly <i>n</i> times</td></tr>
 * <tr><td valign="top" headers="construct greedy"><i>X</i><tt>{</tt><i>n</i><tt>,}</tt></td>
 *     <td headers="matches"><i>X</i>, at least <i>n</i> times</td></tr>
 * <tr><td valign="top" headers="construct greedy"><i>X</i><tt>{</tt><i>n</i><tt>,</tt><i>m</i><tt>}</tt></td>
 *     <td headers="matches"><i>X</i>, at least <i>n</i> but not more than <i>m</i> times</td></tr>
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2" id="reluc">Reluctant quantifiers</th></tr>
 *
 * <tr><td valign="top" headers="construct reluc"><i>X</i><tt>??</tt></td>
 *     <td headers="matches"><i>X</i>, once or not at all</td></tr>
 * <tr><td valign="top" headers="construct reluc"><i>X</i><tt>*?</tt></td>
 *     <td headers="matches"><i>X</i>, zero or more times</td></tr>
 * <tr><td valign="top" headers="construct reluc"><i>X</i><tt>+?</tt></td>
 *     <td headers="matches"><i>X</i>, one or more times</td></tr>
 * <tr><td valign="top" headers="construct reluc"><i>X</i><tt>{</tt><i>n</i><tt>}?</tt></td>
 *     <td headers="matches"><i>X</i>, exactly <i>n</i> times</td></tr>
 * <tr><td valign="top" headers="construct reluc"><i>X</i><tt>{</tt><i>n</i><tt>,}?</tt></td>
 *     <td headers="matches"><i>X</i>, at least <i>n</i> times</td></tr>
 * <tr><td valign="top" headers="construct reluc"><i>X</i><tt>{</tt><i>n</i><tt>,</tt><i>m</i><tt>}?</tt></td>
 *     <td headers="matches"><i>X</i>, at least <i>n</i> but not more than <i>m</i> times</td></tr>
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2" id="poss">Possessive quantifiers</th></tr>
 *
 * <tr><td valign="top" headers="construct poss"><i>X</i><tt>?+</tt></td>
 *     <td headers="matches"><i>X</i>, once or not at all</td></tr>
 * <tr><td valign="top" headers="construct poss"><i>X</i><tt>*+</tt></td>
 *     <td headers="matches"><i>X</i>, zero or more times</td></tr>
 * <tr><td valign="top" headers="construct poss"><i>X</i><tt>++</tt></td>
 *     <td headers="matches"><i>X</i>, one or more times</td></tr>
 * <tr><td valign="top" headers="construct poss"><i>X</i><tt>{</tt><i>n</i><tt>}+</tt></td>
 *     <td headers="matches"><i>X</i>, exactly <i>n</i> times</td></tr>
 * <tr><td valign="top" headers="construct poss"><i>X</i><tt>{</tt><i>n</i><tt>,}+</tt></td>
 *     <td headers="matches"><i>X</i>, at least <i>n</i> times</td></tr>
 * <tr><td valign="top" headers="construct poss"><i>X</i><tt>{</tt><i>n</i><tt>,</tt><i>m</i><tt>}+</tt></td>
 *     <td headers="matches"><i>X</i>, at least <i>n</i> but not more than <i>m</i> times</td></tr>
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2" id="logical">Logical operators</th></tr>
 *
 * <tr><td valign="top" headers="construct logical"><i>XY</i></td>
 *     <td headers="matches"><i>X</i> followed by <i>Y</i></td></tr>
 * <tr><td valign="top" headers="construct logical"><i>X</i><tt>|</tt><i>Y</i></td>
 *     <td headers="matches">Either <i>X</i> or <i>Y</i></td></tr>
 * <tr><td valign="top" headers="construct logical"><tt>(</tt><i>X</i><tt>)</tt></td>
 *     <td headers="matches">X, as a <a href="#cg">capturing group</a></td></tr>
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2" id="backref">Back references</th></tr>
 *
 * <tr><td valign="bottom" headers="construct backref"><tt>\</tt><i>n</i></td>
 *     <td valign="bottom" headers="matches">Whatever the <i>n</i><sup>th</sup>
 *     <a href="#cg">capturing group</a> matched</td></tr>
 *
 * <tr><td valign="bottom" headers="construct backref"><tt>\</tt><i>k</i>&lt;<i>name</i>&gt;</td>
 *     <td valign="bottom" headers="matches">Whatever the
 *     <a href="#groupname">named-capturing group</a> "name" matched. Only available for API 26 or above</td></tr>
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2" id="quot">Quotation</th></tr>
 *
 * <tr><td valign="top" headers="construct quot"><tt>\</tt></td>
 *     <td headers="matches">Nothing, but quotes the following character</td></tr>
 * <tr><td valign="top" headers="construct quot"><tt>\Q</tt></td>
 *     <td headers="matches">Nothing, but quotes all characters until <tt>\E</tt></td></tr>
 * <tr><td valign="top" headers="construct quot"><tt>\E</tt></td>
 *     <td headers="matches">Nothing, but ends quoting started by <tt>\Q</tt></td></tr>
 *     <!-- Metachars: !$()*+.<>?[\]^{|} -->
 *
 * <tr><th>&nbsp;</th></tr>
 * <tr align="left"><th colspan="2" id="special">Special constructs (named-capturing and non-capturing)</th></tr>
 *
 * <tr><td valign="top" headers="construct special"><tt>(?&lt;<a href="#groupname">name</a>&gt;</tt><i>X</i><tt>)</tt></td>
 *     <td headers="matches"><i>X</i>, as a named-capturing group. Only available for API 26 or above.</td></tr>
 * <tr><td valign="top" headers="construct special"><tt>(?:</tt><i>X</i><tt>)</tt></td>
 *     <td headers="matches"><i>X</i>, as a non-capturing group</td></tr>
 * <tr><td valign="top" headers="construct special"><tt>(?idmsuxU-idmsuxU)&nbsp;</tt></td>
 *     <td headers="matches">Nothing, but turns match flags <a href="#CASE_INSENSITIVE">i</a>
 * <a href="#UNIX_LINES">d</a> <a href="#MULTILINE">m</a> <a href="#DOTALL">s</a>
 * <a href="#UNICODE_CASE">u</a> <a href="#COMMENTS">x</a> <a href="#UNICODE_CHARACTER_CLASS">U</a>
 * on - off</td></tr>
 * <tr><td valign="top" headers="construct special"><tt>(?idmsux-idmsux:</tt><i>X</i><tt>)</tt>&nbsp;&nbsp;</td>
 *     <td headers="matches"><i>X</i>, as a <a href="#cg">non-capturing group</a> with the
 *         given flags <a href="#CASE_INSENSITIVE">i</a> <a href="#UNIX_LINES">d</a>
 * <a href="#MULTILINE">m</a> <a href="#DOTALL">s</a> <a href="#UNICODE_CASE">u</a >
 * <a href="#COMMENTS">x</a> on - off</td></tr>
 * <tr><td valign="top" headers="construct special"><tt>(?=</tt><i>X</i><tt>)</tt></td>
 *     <td headers="matches"><i>X</i>, via zero-width positive lookahead</td></tr>
 * <tr><td valign="top" headers="construct special"><tt>(?!</tt><i>X</i><tt>)</tt></td>
 *     <td headers="matches"><i>X</i>, via zero-width negative lookahead</td></tr>
 * <tr><td valign="top" headers="construct special"><tt>(?&lt;=</tt><i>X</i><tt>)</tt></td>
 *     <td headers="matches"><i>X</i>, via zero-width positive lookbehind</td></tr>
 * <tr><td valign="top" headers="construct special"><tt>(?&lt;!</tt><i>X</i><tt>)</tt></td>
 *     <td headers="matches"><i>X</i>, via zero-width negative lookbehind</td></tr>
 * <tr><td valign="top" headers="construct special"><tt>(?&gt;</tt><i>X</i><tt>)</tt></td>
 *     <td headers="matches"><i>X</i>, as an independent, non-capturing group</td></tr>
 *
 * </table>
 *
 * <hr>
 *
 *
 * <a name="bs">
 * <h4> Backslashes, escapes, and quoting </h4>
 *
 * <p> The backslash character (<tt>'\'</tt>) serves to introduce escaped
 * constructs, as defined in the table above, as well as to quote characters
 * that otherwise would be interpreted as unescaped constructs.  Thus the
 * expression <tt>\\</tt> matches a single backslash and <tt>\{</tt> matches a
 * left brace.
 *
 * <p> It is an error to use a backslash prior to any alphabetic character that
 * does not denote an escaped construct; these are reserved for future
 * extensions to the regular-expression language.  A backslash may be used
 * prior to a non-alphabetic character regardless of whether that character is
 * part of an unescaped construct.
 *
 * <p> Backslashes within string literals in Java source code are interpreted
 * as required by
 * <cite>The Java&trade; Language Specification</cite>
 * as either Unicode escapes (section 3.3) or other character escapes (section 3.10.6)
 * It is therefore necessary to double backslashes in string
 * literals that represent regular expressions to protect them from
 * interpretation by the Java bytecode compiler.  The string literal
 * <tt>"&#92;b"</tt>, for example, matches a single backspace character when
 * interpreted as a regular expression, while <tt>"&#92;&#92;b"</tt> matches a
 * word boundary.  The string literal <tt>"&#92;(hello&#92;)"</tt> is illegal
 * and leads to a compile-time error; in order to match the string
 * <tt>(hello)</tt> the string literal <tt>"&#92;&#92;(hello&#92;&#92;)"</tt>
 * must be used.
 *
 * <a name="cc">
 * <h4> Character Classes </h4>
 *
 *    <p> Character classes may appear within other character classes, and
 *    may be composed by the union operator (implicit) and the intersection
 *    operator (<tt>&amp;&amp;</tt>).
 *    The union operator denotes a class that contains every character that is
 *    in at least one of its operand classes.  The intersection operator
 *    denotes a class that contains every character that is in both of its
 *    operand classes.
 *
 *    <p> The precedence of character-class operators is as follows, from
 *    highest to lowest:
 *
 *    <blockquote><table border="0" cellpadding="1" cellspacing="0"
 *                 summary="Precedence of character class operators.">
 *      <tr><th>1&nbsp;&nbsp;&nbsp;&nbsp;</th>
 *        <td>Literal escape&nbsp;&nbsp;&nbsp;&nbsp;</td>
 *        <td><tt>\x</tt></td></tr>
 *     <tr><th>2&nbsp;&nbsp;&nbsp;&nbsp;</th>
 *        <td>Grouping</td>
 *        <td><tt>[...]</tt></td></tr>
 *     <tr><th>3&nbsp;&nbsp;&nbsp;&nbsp;</th>
 *        <td>Range</td>
 *        <td><tt>a-z</tt></td></tr>
 *      <tr><th>4&nbsp;&nbsp;&nbsp;&nbsp;</th>
 *        <td>Union</td>
 *        <td><tt>[a-e][i-u]</tt></td></tr>
 *      <tr><th>5&nbsp;&nbsp;&nbsp;&nbsp;</th>
 *        <td>Intersection</td>
 *        <td><tt>[a-z&&[aeiou]]</tt></td></tr>
 *    </table></blockquote>
 *
 *    <p> Note that a different set of metacharacters are in effect inside
 *    a character class than outside a character class. For instance, the
 *    regular expression <tt>.</tt> loses its special meaning inside a
 *    character class, while the expression <tt>-</tt> becomes a range
 *    forming metacharacter.
 *
 * <a name="lt">
 * <h4> Line terminators </h4>
 *
 * <p> A <i>line terminator</i> is a one- or two-character sequence that marks
 * the end of a line of the input character sequence.  The following are
 * recognized as line terminators:
 *
 * <ul>
 *
 *   <li> A newline (line feed) character&nbsp;(<tt>'\n'</tt>),
 *
 *   <li> A carriage-return character followed immediately by a newline
 *   character&nbsp;(<tt>"\r\n"</tt>),
 *
 *   <li> A standalone carriage-return character&nbsp;(<tt>'\r'</tt>),
 *
 *   <li> A next-line character&nbsp;(<tt>'&#92;u0085'</tt>),
 *
 *   <li> A line-separator character&nbsp;(<tt>'&#92;u2028'</tt>), or
 *
 *   <li> A paragraph-separator character&nbsp;(<tt>'&#92;u2029</tt>).
 *
 * </ul>
 * <p>If {@link #UNIX_LINES} mode is activated, then the only line terminators
 * recognized are newline characters.
 *
 * <p> The regular expression <tt>.</tt> matches any character except a line
 * terminator unless the {@link #DOTALL} flag is specified.
 *
 * <p> By default, the regular expressions <tt>^</tt> and <tt>$</tt> ignore
 * line terminators and only match at the beginning and the end, respectively,
 * of the entire input sequence. If {@link #MULTILINE} mode is activated then
 * <tt>^</tt> matches at the beginning of input and after any line terminator
 * except at the end of input. When in {@link #MULTILINE} mode <tt>$</tt>
 * matches just before a line terminator or the end of the input sequence.
 *
 * <a name="cg">
 * <h4> Groups and capturing </h4>
 *
 * <a name="gnumber">
 * <h5> Group number </h5>
 * <p> Capturing groups are numbered by counting their opening parentheses from
 * left to right.  In the expression <tt>((A)(B(C)))</tt>, for example, there
 * are four such groups: </p>
 *
 * <blockquote><table cellpadding=1 cellspacing=0 summary="Capturing group numberings">
 * <tr><th>1&nbsp;&nbsp;&nbsp;&nbsp;</th>
 *     <td><tt>((A)(B(C)))</tt></td></tr>
 * <tr><th>2&nbsp;&nbsp;&nbsp;&nbsp;</th>
 *     <td><tt>(A)</tt></td></tr>
 * <tr><th>3&nbsp;&nbsp;&nbsp;&nbsp;</th>
 *     <td><tt>(B(C))</tt></td></tr>
 * <tr><th>4&nbsp;&nbsp;&nbsp;&nbsp;</th>
 *     <td><tt>(C)</tt></td></tr>
 * </table></blockquote>
 *
 * <p> Group zero always stands for the entire expression.
 *
 * <p> Capturing groups are so named because, during a match, each subsequence
 * of the input sequence that matches such a group is saved.  The captured
 * subsequence may be used later in the expression, via a back reference, and
 * may also be retrieved from the matcher once the match operation is complete.
 *
 * <a name="groupname">
 * <h5> Group name </h5>
 * <p>The constructs and APIs are available since API level 26. A capturing group
 * can also be assigned a "name", a <tt>named-capturing group</tt>,
 * and then be back-referenced later by the "name". Group names are composed of
 * the following characters. The first character must be a <tt>letter</tt>.
 *
 * <ul>
 *   <li> The uppercase letters <tt>'A'</tt> through <tt>'Z'</tt>
 *        (<tt>'&#92;u0041'</tt>&nbsp;through&nbsp;<tt>'&#92;u005a'</tt>),
 *   <li> The lowercase letters <tt>'a'</tt> through <tt>'z'</tt>
 *        (<tt>'&#92;u0061'</tt>&nbsp;through&nbsp;<tt>'&#92;u007a'</tt>),
 *   <li> The digits <tt>'0'</tt> through <tt>'9'</tt>
 *        (<tt>'&#92;u0030'</tt>&nbsp;through&nbsp;<tt>'&#92;u0039'</tt>),
 * </ul>
 *
 * <p> A <tt>named-capturing group</tt> is still numbered as described in
 * <a href="#gnumber">Group number</a>.
 *
 * <p> The captured input associated with a group is always the subsequence
 * that the group most recently matched.  If a group is evaluated a second time
 * because of quantification then its previously-captured value, if any, will
 * be retained if the second evaluation fails.  Matching the string
 * <tt>"aba"</tt> against the expression <tt>(a(b)?)+</tt>, for example, leaves
 * group two set to <tt>"b"</tt>.  All captured input is discarded at the
 * beginning of each match.
 *
 * <p> Groups beginning with <tt>(?</tt> are either pure, <i>non-capturing</i> groups
 * that do not capture text and do not count towards the group total, or
 * <i>named-capturing</i> group.
 *
 * <h4> Unicode support </h4>
 *
 * <p> This class is in conformance with Level 1 of <a
 * href="http://www.unicode.org/reports/tr18/"><i>Unicode Technical
 * Standard #18: Unicode Regular Expression</i></a>, plus RL2.1
 * Canonical Equivalents.
 * <p>
 * <b>Unicode escape sequences</b> such as <tt>&#92;u2014</tt> in Java source code
 * are processed as described in section 3.3 of
 * <cite>The Java&trade; Language Specification</cite>.
 * Such escape sequences are also implemented directly by the regular-expression
 * parser so that Unicode escapes can be used in expressions that are read from
 * files or from the keyboard.  Thus the strings <tt>"&#92;u2014"</tt> and
 * <tt>"\\u2014"</tt>, while not equal, compile into the same pattern, which
 * matches the character with hexadecimal value <tt>0x2014</tt>.
 * <p>
 * A Unicode character can also be represented in a regular-expression by
 * using its <b>Hex notation</b>(hexadecimal code point value) directly as described in construct
 * <tt>&#92;x{...}</tt>, for example a supplementary character U+2011F
 * can be specified as <tt>&#92;x{2011F}</tt>, instead of two consecutive
 * Unicode escape sequences of the surrogate pair
 * <tt>&#92;uD840</tt><tt>&#92;uDD1F</tt>.
 * <p>
 * Unicode scripts, blocks, categories and binary properties are written with
 * the <tt>\p</tt> and <tt>\P</tt> constructs as in Perl.
 * <tt>\p{</tt><i>prop</i><tt>}</tt> matches if
 * the input has the property <i>prop</i>, while <tt>\P{</tt><i>prop</i><tt>}</tt>
 * does not match if the input has that property.
 * <p>
 * Scripts, blocks, categories and binary properties can be used both inside
 * and outside of a character class.
 * <a name="usc">
 * <p>
 * <b>Scripts</b> are specified either with the prefix {@code Is}, as in
 * {@code IsHiragana}, or by using  the {@code script} keyword (or its short
 * form {@code sc})as in {@code script=Hiragana} or {@code sc=Hiragana}.
 * <p>
 * The script names supported by <code>Pattern</code> are the valid script names
 * accepted and defined by
 * {@link java.lang.Character.UnicodeScript#forName(String) UnicodeScript.forName}.
 * <a name="ubc">
 * <p>
 * <b>Blocks</b> are specified with the prefix {@code In}, as in
 * {@code InMongolian}, or by using the keyword {@code block} (or its short
 * form {@code blk}) as in {@code block=Mongolian} or {@code blk=Mongolian}.
 * <p>
 * The block names supported by <code>Pattern</code> are the valid block names
 * accepted and defined by
 * {@link java.lang.Character.UnicodeBlock#forName(String) UnicodeBlock.forName}.
 * <p>
 * <a name="ucc">
 * <b>Categories</b> may be specified with the optional prefix {@code Is}:
 * Both {@code \p{L}} and {@code \p{IsL}} denote the category of Unicode
 * letters. Same as scripts and blocks, categories can also be specified
 * by using the keyword {@code general_category} (or its short form
 * {@code gc}) as in {@code general_category=Lu} or {@code gc=Lu}.
 * <p>
 * The supported categories are those of
 * <a href="http://www.unicode.org/unicode/standard/standard.html">
 * <i>The Unicode Standard</i></a> in the version specified by the
 * {@link java.lang.Character Character} class. The category names are those
 * defined in the Standard, both normative and informative.
 * <p>
 * <a name="ubpc">
 * <b>Binary properties</b> are specified with the prefix {@code Is}, as in
 * {@code IsAlphabetic}. The supported binary properties by <code>Pattern</code>
 * are
 * <ul>
 *   <li> Alphabetic
 *   <li> Ideographic
 *   <li> Letter
 *   <li> Lowercase
 *   <li> Uppercase
 *   <li> Titlecase
 *   <li> Punctuation
 *   <Li> Control
 *   <li> White_Space
 *   <li> Digit
 *   <li> Hex_Digit
 *   <li> Noncharacter_Code_Point
 *   <li> Assigned
 * </ul>
 
 
 * <p>
 * <b>Predefined Character classes</b> and <b>POSIX character classes</b> are in
 * conformance with the recommendation of <i>Annex C: Compatibility Properties</i>
 * of <a href="http://www.unicode.org/reports/tr18/"><i>Unicode Regular Expression
 * </i></a>.
 * <p>
 * <table border="0" cellpadding="1" cellspacing="0"
 *  summary="predefined and posix character classes in Unicode mode">
 * <tr align="left">
 * <th bgcolor="#CCCCFF" align="left" id="classes">Classes</th>
 * <th bgcolor="#CCCCFF" align="left" id="matches">Matches</th>
 *</tr>
 * <tr><td><tt>\p{Lower}</tt></td>
 *     <td>A lowercase character:<tt>\p{IsLowercase}</tt></td></tr>
 * <tr><td><tt>\p{Upper}</tt></td>
 *     <td>An uppercase character:<tt>\p{IsUppercase}</tt></td></tr>
 * <tr><td><tt>\p{ASCII}</tt></td>
 *     <td>All ASCII:<tt>[\x00-\x7F]</tt></td></tr>
 * <tr><td><tt>\p{Alpha}</tt></td>
 *     <td>An alphabetic character:<tt>\p{IsAlphabetic}</tt></td></tr>
 * <tr><td><tt>\p{Digit}</tt></td>
 *     <td>A decimal digit character:<tt>p{IsDigit}</tt></td></tr>
 * <tr><td><tt>\p{Alnum}</tt></td>
 *     <td>An alphanumeric character:<tt>[\p{IsAlphabetic}\p{IsDigit}]</tt></td></tr>
 * <tr><td><tt>\p{Punct}</tt></td>
 *     <td>A punctuation character:<tt>p{IsPunctuation}</tt></td></tr>
 * <tr><td><tt>\p{Graph}</tt></td>
 *     <td>A visible character: <tt>[^\p{IsWhite_Space}\p{gc=Cc}\p{gc=Cs}\p{gc=Cn}]</tt></td></tr>
 * <tr><td><tt>\p{Print}</tt></td>
 *     <td>A printable character: <tt>[\p{Graph}\p{Blank}&&[^\p{Cntrl}]]</tt></td></tr>
 * <tr><td><tt>\p{Blank}</tt></td>
 *     <td>A space or a tab: <tt>[\p{IsWhite_Space}&&[^\p{gc=Zl}\p{gc=Zp}\x0a\x0b\x0c\x0d\x85]]</tt></td></tr>
 * <tr><td><tt>\p{Cntrl}</tt></td>
 *     <td>A control character: <tt>\p{gc=Cc}</tt></td></tr>
 * <tr><td><tt>\p{XDigit}</tt></td>
 *     <td>A hexadecimal digit: <tt>[\p{gc=Nd}\p{IsHex_Digit}]</tt></td></tr>
 * <tr><td><tt>\p{Space}</tt></td>
 *     <td>A whitespace character:<tt>\p{IsWhite_Space}</tt></td></tr>
 * <tr><td><tt>\d</tt></td>
 *     <td>A digit: <tt>\p{IsDigit}</tt></td></tr>
 * <tr><td><tt>\D</tt></td>
 *     <td>A non-digit: <tt>[^\d]</tt></td></tr>
 * <tr><td><tt>\s</tt></td>
 *     <td>A whitespace character: <tt>\p{IsWhite_Space}</tt></td></tr>
 * <tr><td><tt>\S</tt></td>
 *     <td>A non-whitespace character: <tt>[^\s]</tt></td></tr>
 * <tr><td><tt>\w</tt></td>
 *     <td>A word character: <tt>[\p{Alpha}\p{gc=Mn}\p{gc=Me}\p{gc=Mc}\p{Digit}\p{gc=Pc}]</tt></td></tr>
 * <tr><td><tt>\W</tt></td>
 *     <td>A non-word character: <tt>[^\w]</tt></td></tr>
 * </table>
 * <p>
 * <a name="jcc">
 * Categories that behave like the java.lang.Character
 * boolean is<i>methodname</i> methods (except for the deprecated ones) are
 * available through the same <tt>\p{</tt><i>prop</i><tt>}</tt> syntax where
 * the specified property has the name <tt>java<i>methodname</i></tt>.
 *
 * <h4> Comparison to Perl 5 </h4>
 *
 * <p>The <code>Pattern</code> engine performs traditional NFA-based matching
 * with ordered alternation as occurs in Perl 5.
 *
 * <p> Perl constructs not supported by this class: </p>
 *
 * <ul>
 *    <li><p> Predefined character classes (Unicode character)
 *    <p><tt>\h&nbsp;&nbsp;&nbsp;&nbsp;</tt>A horizontal whitespace
 *    <p><tt>\H&nbsp;&nbsp;&nbsp;&nbsp;</tt>A non horizontal whitespace
 *    <p><tt>\v&nbsp;&nbsp;&nbsp;&nbsp;</tt>A vertical whitespace
 *    <p><tt>\V&nbsp;&nbsp;&nbsp;&nbsp;</tt>A non vertical whitespace
 *    <p><tt>\R&nbsp;&nbsp;&nbsp;&nbsp;</tt>Any Unicode linebreak sequence
 *    <tt>\u005cu000D\u005cu000A|[\u005cu000A\u005cu000B\u005cu000C\u005cu000D\u005cu0085\u005cu2028\u005cu2029]</tt>
 *    <p><tt>\X&nbsp;&nbsp;&nbsp;&nbsp;</tt>Match Unicode
 *    <a href="http://www.unicode.org/reports/tr18/#Default_Grapheme_Clusters">
 *    <i>extended grapheme cluster</i></a>
 *    </p></li>
 *
 *    <li><p> The backreference constructs, <tt>\g{</tt><i>n</i><tt>}</tt> for
 *    the <i>n</i><sup>th</sup><a href="#cg">capturing group</a> and
 *    <tt>\g{</tt><i>name</i><tt>}</tt> for
 *    <a href="#groupname">named-capturing group</a>.
 *    </p></li>
 *
 *    <li><p> The named character construct, <tt>\N{</tt><i>name</i><tt>}</tt>
 *    for a Unicode character by its name.
 *    </p></li>
 *
 *    <li><p> The conditional constructs
 *    <tt>(?(</tt><i>condition</i><tt>)</tt><i>X</i><tt>)</tt> and
 *    <tt>(?(</tt><i>condition</i><tt>)</tt><i>X</i><tt>|</tt><i>Y</i><tt>)</tt>,
 *    </p></li>
 *
 *    <li><p> The embedded code constructs <tt>(?{</tt><i>code</i><tt>})</tt>
 *    and <tt>(??{</tt><i>code</i><tt>})</tt>,</p></li>
 *
 *    <li><p> The embedded comment syntax <tt>(?#comment)</tt>, and </p></li>
 *
 *    <li><p> The preprocessing operations <tt>\l</tt> <tt>&#92;u</tt>,
 *    <tt>\L</tt>, and <tt>\U</tt>.  </p></li>
 *
 * </ul>
 *
 * <p> Constructs supported by this class but not by Perl: </p>
 *
 * <ul>
 *
 *    <li><p> Character-class union and intersection as described
 *    <a href="#cc">above</a>.</p></li>
 *
 * </ul>
 *
 * <p> Notable differences from Perl: </p>
 *
 * <ul>
 *
 *    <li><p> In Perl, <tt>\1</tt> through <tt>\9</tt> are always interpreted
 *    as back references; a backslash-escaped number greater than <tt>9</tt> is
 *    treated as a back reference if at least that many subexpressions exist,
 *    otherwise it is interpreted, if possible, as an octal escape.  In this
 *    class octal escapes must always begin with a zero. In this class,
 *    <tt>\1</tt> through <tt>\9</tt> are always interpreted as back
 *    references, and a larger number is accepted as a back reference if at
 *    least that many subexpressions exist at that point in the regular
 *    expression, otherwise the parser will drop digits until the number is
 *    smaller or equal to the existing number of groups or it is one digit.
 *    </p></li>
 *
 *    <li><p> Perl uses the <tt>g</tt> flag to request a match that resumes
 *    where the last match left off.  This functionality is provided implicitly
 *    by the {@link Matcher} class: Repeated invocations of the {@link
 *    Matcher#find find} method will resume where the last match left off,
 *    unless the matcher is reset.  </p></li>
 *
 *    <li><p> In Perl, embedded flags at the top level of an expression affect
 *    the whole expression.  In this class, embedded flags always take effect
 *    at the point at which they appear, whether they are at the top level or
 *    within a group; in the latter case, flags are restored at the end of the
 *    group just as in Perl.  </p></li>
 *
 * </ul>
 *
 *
 * <p> For a more precise description of the behavior of regular expression
 * constructs, please see <a href="http://www.oreilly.com/catalog/regex3/">
 * <i>Mastering Regular Expressions, 3nd Edition</i>, Jeffrey E. F. Friedl,
 * O'Reilly and Associates, 2006.</a>
 * </p>
 *
 * @see java.lang.String#split(String, int)
 * @see java.lang.String#split(String)
 *
 * @author      Mike McCloskey
 * @author      Mark Reinhold
 * @author      JSR-51 Expert Group
 * @since       1.4
 * @spec        JSR-51
 */

@SuppressWarnings({"unchecked", "deprecation", "all"})
public final class Pattern implements java.io.Serializable {

/**
 * This private constructor is used to create all Patterns. The pattern
 * string and match flags are all that is needed to completely describe
 * a Pattern.
 */

Pattern(java.lang.String p, int f) { throw new RuntimeException("Stub!"); }

/**
 * Compiles the given regular expression into a pattern.  </p>
 *
 * @param  regex
 *         The expression to be compiled
 *
 * @throws  PatternSyntaxException
 *          If the expression's syntax is invalid
 */

public static java.util.regex.Pattern compile(java.lang.String regex) { throw new RuntimeException("Stub!"); }

/**
 * Compiles the given regular expression into a pattern with the given
 * flags.  </p>
 *
 * @param  regex
 *         The expression to be compiled
 *
 * @param  flags
 *         Match flags, a bit mask that may include
 *         {@link #CASE_INSENSITIVE}, {@link #MULTILINE}, {@link #DOTALL},
 *         {@link #UNICODE_CASE}, {@link #CANON_EQ}, {@link #UNIX_LINES},
 *         {@link #LITERAL}, {@link #UNICODE_CHARACTER_CLASS}
 *         and {@link #COMMENTS}
 *
 * @throws  IllegalArgumentException
 *          If bit values other than those corresponding to the defined
 *          match flags are set in <tt>flags</tt>
 *
 * @throws  PatternSyntaxException
 *          If the expression's syntax is invalid
 */

public static java.util.regex.Pattern compile(java.lang.String regex, int flags) throws java.util.regex.PatternSyntaxException { throw new RuntimeException("Stub!"); }

/**
 * Returns the regular expression from which this pattern was compiled.
 * </p>
 *
 * @return  The source of this pattern
 */

public java.lang.String pattern() { throw new RuntimeException("Stub!"); }

/**
 * <p>Returns the string representation of this pattern. This
 * is the regular expression from which this pattern was
 * compiled.</p>
 *
 * @return  The string representation of this pattern
 * @since 1.5
 */

public java.lang.String toString() { throw new RuntimeException("Stub!"); }

/**
 * Creates a matcher that will match the given input against this pattern.
 * </p>
 *
 * @param  input
 *         The character sequence to be matched
 *
 * @return  A new matcher for this pattern
 */

public java.util.regex.Matcher matcher(java.lang.CharSequence input) { throw new RuntimeException("Stub!"); }

/**
 * Returns this pattern's match flags.  </p>
 *
 * @return  The match flags specified when this pattern was compiled
 */

public int flags() { throw new RuntimeException("Stub!"); }

/**
 * Compiles the given regular expression and attempts to match the given
 * input against it.
 *
 * <p> An invocation of this convenience method of the form
 *
 * <blockquote><pre>
 * Pattern.matches(regex, input);</pre></blockquote>
 *
 * behaves in exactly the same way as the expression
 *
 * <blockquote><pre>
 * Pattern.compile(regex).matcher(input).matches()</pre></blockquote>
 *
 * <p> If a pattern is to be used multiple times, compiling it once and reusing
 * it will be more efficient than invoking this method each time.  </p>
 *
 * @param  regex
 *         The expression to be compiled
 *
 * @param  input
 *         The character sequence to be matched
 *
 * @throws  PatternSyntaxException
 *          If the expression's syntax is invalid
 */

public static boolean matches(java.lang.String regex, java.lang.CharSequence input) { throw new RuntimeException("Stub!"); }

/**
 * Splits the given input sequence around matches of this pattern.
 *
 * <p> The array returned by this method contains each substring of the
 * input sequence that is terminated by another subsequence that matches
 * this pattern or is terminated by the end of the input sequence.  The
 * substrings in the array are in the order in which they occur in the
 * input.  If this pattern does not match any subsequence of the input then
 * the resulting array has just one element, namely the input sequence in
 * string form.
 *
 * <p> The <tt>limit</tt> parameter controls the number of times the
 * pattern is applied and therefore affects the length of the resulting
 * array.  If the limit <i>n</i> is greater than zero then the pattern
 * will be applied at most <i>n</i>&nbsp;-&nbsp;1 times, the array's
 * length will be no greater than <i>n</i>, and the array's last entry
 * will contain all input beyond the last matched delimiter.  If <i>n</i>
 * is non-positive then the pattern will be applied as many times as
 * possible and the array can have any length.  If <i>n</i> is zero then
 * the pattern will be applied as many times as possible, the array can
 * have any length, and trailing empty strings will be discarded.
 *
 * <p> The input <tt>"boo:and:foo"</tt>, for example, yields the following
 * results with these parameters:
 *
 * <blockquote><table cellpadding=1 cellspacing=0
 *              summary="Split examples showing regex, limit, and result">
 * <tr><th><P align="left"><i>Regex&nbsp;&nbsp;&nbsp;&nbsp;</i></th>
 *     <th><P align="left"><i>Limit&nbsp;&nbsp;&nbsp;&nbsp;</i></th>
 *     <th><P align="left"><i>Result&nbsp;&nbsp;&nbsp;&nbsp;</i></th></tr>
 * <tr><td align=center>:</td>
 *     <td align=center>2</td>
 *     <td><tt>{ "boo", "and:foo" }</tt></td></tr>
 * <tr><td align=center>:</td>
 *     <td align=center>5</td>
 *     <td><tt>{ "boo", "and", "foo" }</tt></td></tr>
 * <tr><td align=center>:</td>
 *     <td align=center>-2</td>
 *     <td><tt>{ "boo", "and", "foo" }</tt></td></tr>
 * <tr><td align=center>o</td>
 *     <td align=center>5</td>
 *     <td><tt>{ "b", "", ":and:f", "", "" }</tt></td></tr>
 * <tr><td align=center>o</td>
 *     <td align=center>-2</td>
 *     <td><tt>{ "b", "", ":and:f", "", "" }</tt></td></tr>
 * <tr><td align=center>o</td>
 *     <td align=center>0</td>
 *     <td><tt>{ "b", "", ":and:f" }</tt></td></tr>
 * </table></blockquote>
 *
 *
 * @param  input
 *         The character sequence to be split
 *
 * @param  limit
 *         The result threshold, as described above
 *
 * @return  The array of strings computed by splitting the input
 *          around matches of this pattern
 */

public java.lang.String[] split(java.lang.CharSequence input, int limit) { throw new RuntimeException("Stub!"); }

/**
 * Splits the given input sequence around matches of this pattern.
 *
 * <p> This method works as if by invoking the two-argument {@link
 * #split(java.lang.CharSequence, int) split} method with the given input
 * sequence and a limit argument of zero.  Trailing empty strings are
 * therefore not included in the resulting array. </p>
 *
 * <p> The input <tt>"boo:and:foo"</tt>, for example, yields the following
 * results with these expressions:
 *
 * <blockquote><table cellpadding=1 cellspacing=0
 *              summary="Split examples showing regex and result">
 * <tr><th><P align="left"><i>Regex&nbsp;&nbsp;&nbsp;&nbsp;</i></th>
 *     <th><P align="left"><i>Result</i></th></tr>
 * <tr><td align=center>:</td>
 *     <td><tt>{ "boo", "and", "foo" }</tt></td></tr>
 * <tr><td align=center>o</td>
 *     <td><tt>{ "b", "", ":and:f" }</tt></td></tr>
 * </table></blockquote>
 *
 *
 * @param  input
 *         The character sequence to be split
 *
 * @return  The array of strings computed by splitting the input
 *          around matches of this pattern
 */

public java.lang.String[] split(java.lang.CharSequence input) { throw new RuntimeException("Stub!"); }

/**
 * Returns a literal pattern <code>String</code> for the specified
 * <code>String</code>.
 *
 * <p>This method produces a <code>String</code> that can be used to
 * create a <code>Pattern</code> that would match the string
 * <code>s</code> as if it were a literal pattern.</p> Metacharacters
 * or escape sequences in the input sequence will be given no special
 * meaning.
 *
 * @param  s The string to be literalized
 * @return  A literal string replacement
 * @since 1.5
 */

public static java.lang.String quote(java.lang.String s) { throw new RuntimeException("Stub!"); }

/**
 * Creates a predicate which can be used to match a string.
 *
 * @return  The predicate which can be used for matching on a string
 * @since   1.8
 */

public java.util.function.Predicate<java.lang.String> asPredicate() { throw new RuntimeException("Stub!"); }

/**
 * Creates a stream from the given input sequence around matches of this
 * pattern.
 *
 * <p> The stream returned by this method contains each substring of the
 * input sequence that is terminated by another subsequence that matches
 * this pattern or is terminated by the end of the input sequence.  The
 * substrings in the stream are in the order in which they occur in the
 * input. Trailing empty strings will be discarded and not encountered in
 * the stream.
 *
 * <p> If this pattern does not match any subsequence of the input then
 * the resulting stream has just one element, namely the input sequence in
 * string form.
 *
 * <p> When there is a positive-width match at the beginning of the input
 * sequence then an empty leading substring is included at the beginning
 * of the stream. A zero-width match at the beginning however never produces
 * such empty leading substring.
 *
 * <p> If the input sequence is mutable, it must remain constant during the
 * execution of the terminal stream operation.  Otherwise, the result of the
 * terminal stream operation is undefined.
 *
 * @param   input
 *          The character sequence to be split
 *
 * @return  The stream of strings computed by splitting the input
 *          around matches of this pattern
 * @see     #split(CharSequence)
 * @since   1.8
 */

public java.util.stream.Stream<java.lang.String> splitAsStream(java.lang.CharSequence input) { throw new RuntimeException("Stub!"); }

/**
 * Enables canonical equivalence.
 *
 * <p> When this flag is specified then two characters will be considered
 * to match if, and only if, their full canonical decompositions match.
 * The expression <tt>"a&#92;u030A"</tt>, for example, will match the
 * string <tt>"&#92;u00E5"</tt> when this flag is specified.  By default,
 * matching does not take canonical equivalence into account.
 *
 * <p> There is no embedded flag character for enabling canonical
 * equivalence.
 *
 * <p> Specifying this flag may impose a performance penalty.  </p>
 */

public static final int CANON_EQ = 128; // 0x80

/**
 * Enables case-insensitive matching.
 *
 * <p> By default, case-insensitive matching assumes that only characters
 * in the US-ASCII charset are being matched.  Unicode-aware
 * case-insensitive matching can be enabled by specifying the {@link
 * #UNICODE_CASE} flag in conjunction with this flag.
 *
 * <p> Case-insensitive matching can also be enabled via the embedded flag
 * expression&nbsp;<tt>(?i)</tt>.
 *
 * <p> Specifying this flag may impose a slight performance penalty.  </p>
 */

public static final int CASE_INSENSITIVE = 2; // 0x2

/**
 * Permits whitespace and comments in pattern.
 *
 * <p> In this mode, whitespace is ignored, and embedded comments starting
 * with <tt>#</tt> are ignored until the end of a line.
 *
 * <p> Comments mode can also be enabled via the embedded flag
 * expression&nbsp;<tt>(?x)</tt>.
 */

public static final int COMMENTS = 4; // 0x4

/**
 * Enables dotall mode.
 *
 * <p> In dotall mode, the expression <tt>.</tt> matches any character,
 * including a line terminator.  By default this expression does not match
 * line terminators.
 *
 * <p> Dotall mode can also be enabled via the embedded flag
 * expression&nbsp;<tt>(?s)</tt>.  (The <tt>s</tt> is a mnemonic for
 * "single-line" mode, which is what this is called in Perl.)  </p>
 */

public static final int DOTALL = 32; // 0x20

/**
 * Enables literal parsing of the pattern.
 *
 * <p> When this flag is specified then the input string that specifies
 * the pattern is treated as a sequence of literal characters.
 * Metacharacters or escape sequences in the input sequence will be
 * given no special meaning.
 *
 * <p>The flags CASE_INSENSITIVE and UNICODE_CASE retain their impact on
 * matching when used in conjunction with this flag. The other flags
 * become superfluous.
 *
 * <p> There is no embedded flag character for enabling literal parsing.
 * @since 1.5
 */

public static final int LITERAL = 16; // 0x10

/**
 * Enables multiline mode.
 *
 * <p> In multiline mode the expressions <tt>^</tt> and <tt>$</tt> match
 * just after or just before, respectively, a line terminator or the end of
 * the input sequence.  By default these expressions only match at the
 * beginning and the end of the entire input sequence.
 *
 * <p> Multiline mode can also be enabled via the embedded flag
 * expression&nbsp;<tt>(?m)</tt>.  </p>
 */

public static final int MULTILINE = 8; // 0x8

/**
 * Enables Unicode-aware case folding.
 *
 * <p> When this flag is specified then case-insensitive matching, when
 * enabled by the {@link #CASE_INSENSITIVE} flag, is done in a manner
 * consistent with the Unicode Standard.  By default, case-insensitive
 * matching assumes that only characters in the US-ASCII charset are being
 * matched.
 *
 * <p> Unicode-aware case folding can also be enabled via the embedded flag
 * expression&nbsp;<tt>(?u)</tt>.
 *
 * <p> Specifying this flag may impose a performance penalty.  </p>
 */

public static final int UNICODE_CASE = 64; // 0x40

/**
 * Enables the Unicode version of <i>Predefined character classes</i> and
 * <i>POSIX character classes</i> as eefined by <a href="http://www.unicode.org/reports/tr18/"><i>Unicode Technical
 * Standard #18: Unicode Regular Expression</i></a>
 * <i>Annex C: Compatibility Properties</i>.
 * <p>
 *
 * This flag has no effect on Android, unicode character classes are always
 * used.
 *
 * @since 1.7
 */

public static final int UNICODE_CHARACTER_CLASS = 256; // 0x100

/**
 * Enables Unix lines mode.
 *
 * <p> In this mode, only the <tt>'\n'</tt> line terminator is recognized
 * in the behavior of <tt>.</tt>, <tt>^</tt>, and <tt>$</tt>.
 *
 * <p> Unix lines mode can also be enabled via the embedded flag
 * expression&nbsp;<tt>(?d)</tt>.
 */

public static final int UNIX_LINES = 1; // 0x1
}

