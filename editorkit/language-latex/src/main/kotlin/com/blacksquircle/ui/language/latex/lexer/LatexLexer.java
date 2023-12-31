/*
 * Copyright 2023 Squircle CE contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blacksquircle.ui.language.latex.lexer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")

/**
 * This class is a scanner generated by
 * <a href="http://www.jflex.de/">JFlex</a> 1.8.2
 * from the specification file <tt>latex.flex</tt>
 */
public class LatexLexer {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\1\u0200\1\u0300\1\u0400\1\u0500\1\u0600\1\u0700"+
    "\1\u0800\1\u0900\1\u0a00\1\u0b00\1\u0c00\1\u0d00\1\u0e00\1\u0f00"+
    "\1\u1000\1\u0100\1\u1100\1\u1200\1\u1300\1\u0100\1\u1400\1\u1500"+
    "\1\u1600\1\u1700\1\u1800\1\u1900\1\u1a00\1\u1b00\1\u0100\1\u1c00"+
    "\1\u1d00\1\u1e00\12\u1f00\1\u2000\1\u2100\1\u2200\1\u1f00\1\u2300"+
    "\1\u2400\2\u1f00\31\u0100\1\u2500\121\u0100\1\u2600\4\u0100\1\u2700"+
    "\1\u0100\1\u2800\1\u2900\1\u2a00\1\u2b00\1\u2c00\1\u2d00\53\u0100"+
    "\1\u2e00\10\u2f00\31\u1f00\1\u0100\1\u3000\1\u3100\1\u0100\1\u3200"+
    "\1\u3300\1\u3400\1\u3500\1\u3600\1\u3700\1\u3800\1\u3900\1\u3a00"+
    "\1\u0100\1\u3b00\1\u3c00\1\u3d00\1\u3e00\1\u3f00\1\u4000\1\u4100"+
    "\1\u4200\1\u4300\1\u4400\1\u4500\1\u4600\1\u4700\1\u4800\1\u4900"+
    "\1\u4a00\1\u4b00\1\u4c00\1\u4d00\1\u4e00\1\u1f00\1\u4f00\1\u5000"+
    "\1\u5100\1\u5200\3\u0100\1\u5300\1\u5400\1\u5500\12\u1f00\4\u0100"+
    "\1\u5600\17\u1f00\2\u0100\1\u5700\41\u1f00\2\u0100\1\u5800\1\u5900"+
    "\2\u1f00\1\u5a00\1\u5b00\27\u0100\1\u5c00\4\u0100\1\u5d00\1\u5e00"+
    "\42\u1f00\1\u0100\1\u5f00\1\u6000\11\u1f00\1\u6100\24\u1f00\1\u6200"+
    "\1\u6300\1\u1f00\1\u6400\1\u6500\1\u6600\1\u6700\2\u1f00\1\u6800"+
    "\5\u1f00\1\u6900\1\u6a00\1\u6b00\5\u1f00\1\u6c00\1\u6d00\2\u1f00"+
    "\1\u6e00\1\u1f00\1\u6f00\14\u1f00\1\u7000\4\u1f00\246\u0100\1\u7100"+
    "\20\u0100\1\u7200\1\u7300\25\u0100\1\u7400\34\u0100\1\u7500\14\u1f00"+
    "\2\u0100\1\u7600\5\u1f00\23\u0100\1\u7700\u0aec\u1f00\1\u7800\1\u7900"+
    "\u02fe\u1f00";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\2\2\1\3\1\2\16\0\4\4\1\1"+
    "\3\4\1\5\1\6\2\4\1\7\1\10\1\11\1\12"+
    "\1\4\1\12\1\13\1\4\12\14\6\4\1\11\4\15"+
    "\1\16\25\15\1\17\1\20\1\21\1\4\1\22\1\4"+
    "\1\15\1\23\1\24\1\25\1\26\1\15\1\27\1\15"+
    "\1\30\3\15\1\31\1\32\1\15\1\33\2\15\1\34"+
    "\1\35\1\36\2\15\1\37\2\15\1\40\1\4\1\41"+
    "\1\4\6\0\1\42\32\0\2\4\4\5\4\4\1\5"+
    "\2\4\1\0\7\4\1\5\4\4\1\5\5\4\27\5"+
    "\1\4\37\5\1\4\u01ca\5\4\4\14\5\16\4\5\5"+
    "\7\4\1\5\1\4\1\5\21\4\160\0\5\5\1\4"+
    "\2\5\2\4\4\5\1\4\1\5\6\4\1\5\1\4"+
    "\3\5\1\4\1\5\1\4\24\5\1\4\123\5\1\4"+
    "\213\5\1\4\5\0\2\4\246\5\1\4\46\5\2\4"+
    "\1\5\6\4\51\5\6\4\1\5\1\4\55\0\1\4"+
    "\1\0\1\4\2\0\1\4\2\0\1\4\1\0\10\4"+
    "\33\5\4\4\4\5\15\4\6\0\5\4\1\5\4\4"+
    "\13\0\1\4\1\0\3\4\53\5\37\0\4\4\2\5"+
    "\1\0\143\5\1\4\1\5\10\0\1\4\6\0\2\5"+
    "\2\0\1\4\4\0\2\5\12\0\3\5\2\4\1\5"+
    "\17\4\1\0\1\5\1\0\36\5\33\0\2\4\131\5"+
    "\13\0\1\5\16\4\12\0\41\5\11\0\2\5\4\4"+
    "\1\5\2\4\1\0\30\5\4\0\1\5\11\0\1\5"+
    "\3\0\1\5\5\0\22\4\31\5\3\0\4\4\13\5"+
    "\65\4\25\5\1\4\22\5\13\4\61\0\66\5\3\0"+
    "\1\5\22\0\1\5\7\0\12\5\2\0\2\4\12\0"+
    "\1\4\20\5\3\0\1\4\10\5\2\4\2\5\2\4"+
    "\26\5\1\4\7\5\1\4\1\5\3\4\4\5\2\4"+
    "\1\0\1\5\7\0\2\4\2\0\2\4\3\0\1\5"+
    "\10\4\1\0\4\4\2\5\1\4\3\5\2\0\2\4"+
    "\12\0\4\5\7\4\2\5\1\4\1\0\2\4\3\0"+
    "\1\4\6\5\4\4\2\5\2\4\26\5\1\4\7\5"+
    "\1\4\2\5\1\4\2\5\1\4\2\5\2\4\1\0"+
    "\1\4\5\0\4\4\2\0\2\4\3\0\3\4\1\0"+
    "\7\4\4\5\1\4\1\5\7\4\14\0\3\5\1\0"+
    "\13\4\3\0\1\4\11\5\1\4\3\5\1\4\26\5"+
    "\1\4\7\5\1\4\2\5\1\4\5\5\2\4\1\0"+
    "\1\5\10\0\1\4\3\0\1\4\3\0\2\4\1\5"+
    "\17\4\2\5\2\0\2\4\12\0\1\4\1\5\7\4"+
    "\1\5\6\0\1\4\3\0\1\4\10\5\2\4\2\5"+
    "\2\4\26\5\1\4\7\5\1\4\2\5\1\4\5\5"+
    "\2\4\1\0\1\5\7\0\2\4\2\0\2\4\3\0"+
    "\7\4\3\0\4\4\2\5\1\4\3\5\2\0\2\4"+
    "\12\0\1\4\1\5\20\4\1\0\1\5\1\4\6\5"+
    "\3\4\3\5\1\4\4\5\3\4\2\5\1\4\1\5"+
    "\1\4\2\5\3\4\2\5\3\4\3\5\3\4\14\5"+
    "\4\4\5\0\3\4\3\0\1\4\4\0\2\4\1\5"+
    "\6\4\1\0\16\4\12\0\11\4\1\5\6\4\5\0"+
    "\10\5\1\4\3\5\1\4\27\5\1\4\20\5\3\4"+
    "\1\5\7\0\1\4\3\0\1\4\4\0\7\4\2\0"+
    "\1\4\3\5\5\4\2\5\2\0\2\4\12\0\20\4"+
    "\1\5\3\0\1\4\10\5\1\4\3\5\1\4\27\5"+
    "\1\4\12\5\1\4\5\5\2\4\1\0\1\5\7\0"+
    "\1\4\3\0\1\4\4\0\7\4\2\0\7\4\1\5"+
    "\1\4\2\5\2\0\2\4\12\0\1\4\2\5\15\4"+
    "\4\0\11\5\1\4\3\5\1\4\51\5\2\0\1\5"+
    "\7\0\1\4\3\0\1\4\4\0\1\5\5\4\3\5"+
    "\1\0\7\4\3\5\2\0\2\4\12\0\12\4\6\5"+
    "\1\4\3\0\1\4\22\5\3\4\30\5\1\4\11\5"+
    "\1\4\1\5\2\4\7\5\3\4\1\0\4\4\6\0"+
    "\1\4\1\0\1\4\10\0\6\4\12\0\2\4\2\0"+
    "\15\4\60\5\1\0\2\5\7\0\4\4\10\5\10\0"+
    "\1\4\12\0\47\4\2\5\1\4\1\5\1\4\5\5"+
    "\1\4\30\5\1\4\1\5\1\4\12\5\1\0\2\5"+
    "\11\0\1\5\2\4\5\5\1\4\1\5\1\4\6\0"+
    "\2\4\12\0\2\4\4\5\40\4\1\5\27\4\2\0"+
    "\6\4\12\0\13\4\1\0\1\4\1\0\1\4\1\0"+
    "\4\4\2\0\10\5\1\4\44\5\4\4\24\0\1\4"+
    "\2\0\5\5\13\0\1\4\44\0\11\4\1\0\71\4"+
    "\53\5\24\0\1\5\12\0\6\4\6\5\4\0\4\5"+
    "\3\0\1\5\3\0\2\5\7\0\3\5\4\0\15\5"+
    "\14\0\1\5\17\0\2\4\46\5\1\4\1\5\5\4"+
    "\1\5\2\4\53\5\1\4\115\5\1\4\4\5\2\4"+
    "\7\5\1\4\1\5\1\4\4\5\2\4\51\5\1\4"+
    "\4\5\2\4\41\5\1\4\4\5\2\4\7\5\1\4"+
    "\1\5\1\4\4\5\2\4\17\5\1\4\71\5\1\4"+
    "\4\5\2\4\103\5\2\4\3\0\40\4\20\5\20\4"+
    "\126\5\2\4\6\5\3\4\u016c\5\2\4\21\5\1\4"+
    "\32\5\5\4\113\5\3\4\13\5\7\4\15\5\1\4"+
    "\4\5\3\0\13\4\22\5\3\0\13\4\22\5\2\0"+
    "\14\4\15\5\1\4\3\5\1\4\2\0\14\4\64\5"+
    "\40\0\3\4\1\5\3\4\2\5\1\0\2\4\12\0"+
    "\41\4\4\0\1\4\12\0\6\4\131\5\7\4\5\5"+
    "\2\0\42\5\1\0\1\5\5\4\106\5\12\4\37\5"+
    "\1\4\14\0\4\4\14\0\12\4\12\0\36\5\2\4"+
    "\5\5\13\4\54\5\4\4\32\5\6\4\12\0\46\4"+
    "\27\5\5\0\4\4\65\5\12\0\1\4\35\0\2\4"+
    "\13\0\6\4\12\0\15\4\1\5\10\4\16\0\1\4"+
    "\2\0\77\4\5\0\57\5\21\0\7\5\4\4\12\0"+
    "\21\4\11\0\14\4\3\0\36\5\15\0\2\5\12\0"+
    "\54\5\16\0\14\4\44\5\24\0\10\4\12\0\3\4"+
    "\3\5\12\0\44\5\2\4\11\5\7\4\53\5\2\4"+
    "\3\5\20\4\3\0\1\4\25\0\4\5\1\0\6\5"+
    "\1\0\2\5\3\0\1\5\5\4\300\5\72\0\1\4"+
    "\5\0\26\5\2\4\6\5\2\4\46\5\2\4\6\5"+
    "\2\4\10\5\1\4\1\5\1\4\1\5\1\4\1\5"+
    "\1\4\37\5\2\4\65\5\1\4\7\5\1\4\1\5"+
    "\3\4\3\5\1\4\7\5\3\4\4\5\2\4\6\5"+
    "\4\4\15\5\5\4\3\5\1\4\7\5\16\4\5\0"+
    "\30\4\2\2\5\0\20\4\2\5\23\4\1\5\13\4"+
    "\5\0\1\4\12\0\1\4\1\5\15\4\1\5\20\4"+
    "\15\5\3\4\40\5\20\4\15\0\4\4\1\0\3\4"+
    "\14\0\21\4\1\5\4\4\1\5\2\4\12\5\1\4"+
    "\1\5\3\4\5\5\6\4\1\5\1\4\1\5\1\4"+
    "\1\5\1\4\4\5\1\4\13\5\2\4\4\5\5\4"+
    "\5\5\4\4\1\5\21\4\51\5\u0177\4\57\5\1\4"+
    "\57\5\1\4\205\5\6\4\4\5\3\0\2\5\14\4"+
    "\46\5\1\4\1\5\5\4\1\5\2\4\70\5\7\4"+
    "\1\5\17\4\1\0\27\5\11\4\7\5\1\4\7\5"+
    "\1\4\7\5\1\4\7\5\1\4\7\5\1\4\7\5"+
    "\1\4\7\5\1\4\7\5\1\4\40\0\57\4\1\5"+
    "\325\4\3\5\31\4\11\5\6\0\1\4\5\5\2\4"+
    "\5\5\4\4\126\5\2\4\2\0\2\4\3\5\1\4"+
    "\132\5\1\4\4\5\5\4\53\5\1\4\136\5\21\4"+
    "\40\5\60\4\320\5\100\4\375\5\3\4\215\5\103\4"+
    "\56\5\2\4\15\5\3\4\20\5\12\0\2\5\24\4"+
    "\57\5\1\0\4\4\12\0\1\4\37\5\2\0\120\5"+
    "\2\0\45\4\11\5\2\4\147\5\2\4\65\5\2\4"+
    "\11\5\52\4\15\5\1\0\3\5\1\0\4\5\1\0"+
    "\27\5\5\0\4\4\1\0\13\4\1\5\7\4\64\5"+
    "\14\4\2\0\62\5\22\0\12\4\12\0\6\4\22\0"+
    "\6\5\3\4\1\5\1\4\2\5\13\0\34\5\10\0"+
    "\2\4\27\5\15\0\14\4\35\5\3\4\4\0\57\5"+
    "\16\0\16\4\1\5\12\0\6\4\5\5\1\0\12\5"+
    "\12\0\5\5\1\4\51\5\16\0\11\4\3\5\1\0"+
    "\10\5\2\0\2\4\12\0\6\4\27\5\3\4\1\5"+
    "\3\0\62\5\1\0\1\5\3\0\2\5\2\0\5\5"+
    "\2\0\1\5\1\0\1\5\30\4\3\5\2\4\13\5"+
    "\5\0\2\4\3\5\2\0\12\4\6\5\2\4\6\5"+
    "\2\4\6\5\11\4\7\5\1\4\7\5\1\4\53\5"+
    "\1\4\16\5\6\4\163\5\10\0\1\4\2\0\2\4"+
    "\12\0\6\4\244\5\14\4\27\5\4\4\61\5\4\4"+
    "\u0100\2\156\5\2\4\152\5\46\4\7\5\14\4\5\5"+
    "\5\4\1\5\1\0\12\5\1\4\15\5\1\4\5\5"+
    "\1\4\1\5\1\4\2\5\1\4\2\5\1\4\154\5"+
    "\41\4\153\5\22\4\100\5\2\4\66\5\50\4\15\5"+
    "\3\4\20\0\20\4\20\0\3\4\2\5\30\4\3\5"+
    "\31\4\1\5\6\4\5\5\1\4\207\5\2\4\1\0"+
    "\4\4\1\5\13\4\12\0\7\4\32\5\4\4\1\5"+
    "\1\4\32\5\13\4\131\5\3\4\6\5\2\4\6\5"+
    "\2\4\6\5\2\4\3\5\3\4\2\5\3\4\2\5"+
    "\22\4\3\0\4\4\14\5\1\4\32\5\1\4\23\5"+
    "\1\4\2\5\1\4\17\5\2\4\16\5\42\4\173\5"+
    "\105\4\65\5\210\4\1\0\202\4\35\5\3\4\61\5"+
    "\17\4\1\0\37\4\40\5\15\4\36\5\5\4\46\5"+
    "\5\0\5\4\36\5\2\4\44\5\4\4\10\5\1\4"+
    "\5\5\52\4\236\5\2\4\12\0\6\4\44\5\4\4"+
    "\44\5\4\4\50\5\10\4\64\5\234\4\67\5\11\4"+
    "\26\5\12\4\10\5\230\4\6\5\2\4\1\5\1\4"+
    "\54\5\1\4\2\5\3\4\1\5\2\4\27\5\12\4"+
    "\27\5\11\4\37\5\101\4\23\5\1\4\2\5\12\4"+
    "\26\5\12\4\32\5\106\4\70\5\6\4\2\5\100\4"+
    "\1\5\3\0\1\4\2\0\5\4\4\0\4\5\1\4"+
    "\3\5\1\4\35\5\2\4\3\0\4\4\1\0\40\4"+
    "\35\5\3\4\35\5\43\4\10\5\1\4\34\5\2\0"+
    "\31\4\66\5\12\4\26\5\12\4\23\5\15\4\22\5"+
    "\156\4\111\5\67\4\63\5\15\4\63\5\15\4\44\5"+
    "\4\0\10\4\12\0\u0146\4\52\5\1\4\2\0\3\4"+
    "\2\5\116\4\35\5\12\4\1\5\10\4\26\5\13\0"+
    "\137\4\25\5\33\4\27\5\11\4\3\0\65\5\17\0"+
    "\37\4\12\0\17\4\4\0\55\5\13\0\2\4\1\0"+
    "\17\4\1\0\2\4\31\5\7\4\12\0\6\4\3\0"+
    "\44\5\16\0\1\4\12\0\4\4\1\5\2\0\1\5"+
    "\10\4\43\5\1\0\2\4\1\5\11\4\3\0\60\5"+
    "\16\0\4\5\4\4\4\0\1\4\14\0\1\5\1\4"+
    "\1\5\43\4\22\5\1\4\31\5\14\0\6\4\1\0"+
    "\101\4\7\5\1\4\1\5\1\4\4\5\1\4\17\5"+
    "\1\4\12\5\7\4\57\5\14\0\5\4\12\0\6\4"+
    "\4\0\1\4\10\5\2\4\2\5\2\4\26\5\1\4"+
    "\7\5\1\4\2\5\1\4\5\5\1\4\2\0\1\5"+
    "\7\0\2\4\2\0\2\4\3\0\2\4\1\5\6\4"+
    "\1\0\5\4\5\5\2\0\2\4\7\0\3\4\5\0"+
    "\213\4\65\5\22\0\4\5\5\4\12\0\4\4\1\0"+
    "\3\5\36\4\60\5\24\0\2\5\1\4\1\5\10\4"+
    "\12\0\246\4\57\5\7\0\2\4\11\0\27\4\4\5"+
    "\2\0\42\4\60\5\21\0\3\4\1\5\13\4\12\0"+
    "\46\4\53\5\15\0\1\5\7\4\12\0\66\4\33\5"+
    "\2\4\17\0\4\4\12\0\306\4\54\5\17\0\145\4"+
    "\100\5\12\0\25\4\10\5\2\4\1\5\2\4\10\5"+
    "\1\4\2\5\1\4\30\5\6\0\1\4\2\0\2\4"+
    "\4\0\1\5\1\0\1\5\2\0\14\4\12\0\106\4"+
    "\10\5\2\4\47\5\7\0\2\4\7\0\1\5\1\4"+
    "\1\5\1\0\33\4\1\5\12\0\50\5\7\0\1\5"+
    "\4\0\10\4\1\0\10\4\1\5\13\0\56\5\20\0"+
    "\3\4\1\5\42\4\71\5\7\4\11\5\1\4\45\5"+
    "\10\0\1\4\10\0\1\5\17\4\12\0\30\4\36\5"+
    "\2\4\26\0\1\4\16\0\111\4\7\5\1\4\2\5"+
    "\1\4\46\5\6\0\3\4\1\0\1\4\2\0\1\4"+
    "\7\0\1\5\1\0\10\4\12\0\6\4\6\5\1\4"+
    "\2\5\1\4\40\5\5\0\1\4\2\0\1\4\5\0"+
    "\1\5\7\4\12\0\u0136\4\23\5\4\0\271\4\1\5"+
    "\54\4\4\5\37\4\232\5\146\4\157\5\21\4\304\5"+
    "\274\4\57\5\1\4\11\0\307\4\107\5\271\4\71\5"+
    "\7\4\37\5\1\4\12\0\146\4\36\5\2\4\5\0"+
    "\13\4\60\5\7\0\11\4\4\5\14\4\12\0\11\4"+
    "\25\5\5\4\23\5\260\4\100\5\200\4\113\5\4\4"+
    "\1\0\1\5\67\0\7\4\4\0\15\5\100\4\2\5"+
    "\1\4\1\5\1\0\13\4\2\0\16\4\370\5\10\4"+
    "\326\5\52\4\11\5\367\4\37\5\61\4\3\5\21\4"+
    "\4\5\10\4\u018c\5\4\4\153\5\5\4\15\5\3\4"+
    "\11\5\7\4\12\5\3\4\2\0\1\4\4\0\301\4"+
    "\5\0\3\4\26\0\2\4\7\0\36\4\4\0\224\4"+
    "\3\0\273\4\125\5\1\4\107\5\1\4\2\5\2\4"+
    "\1\5\2\4\2\5\2\4\4\5\1\4\14\5\1\4"+
    "\1\5\1\4\7\5\1\4\101\5\1\4\4\5\2\4"+
    "\10\5\1\4\7\5\1\4\34\5\1\4\4\5\1\4"+
    "\5\5\1\4\1\5\3\4\7\5\1\4\u0154\5\2\4"+
    "\31\5\1\4\31\5\1\4\37\5\1\4\31\5\1\4"+
    "\37\5\1\4\31\5\1\4\37\5\1\4\31\5\1\4"+
    "\37\5\1\4\31\5\1\4\10\5\2\4\151\0\4\4"+
    "\62\0\10\4\1\0\16\4\1\0\26\4\5\0\1\4"+
    "\17\0\120\4\7\0\1\4\21\0\2\4\7\0\1\4"+
    "\2\0\1\4\5\0\325\4\55\5\3\4\7\0\7\5"+
    "\2\4\12\0\4\4\1\5\u0171\4\54\5\16\0\5\4"+
    "\306\5\13\4\7\0\51\4\104\5\7\0\1\5\4\4"+
    "\12\0\u0156\4\1\5\117\4\4\5\1\4\33\5\1\4"+
    "\2\5\1\4\1\5\2\4\1\5\1\4\12\5\1\4"+
    "\4\5\1\4\1\5\1\4\1\5\6\4\1\5\4\4"+
    "\1\5\1\4\1\5\1\4\1\5\1\4\3\5\1\4"+
    "\2\5\1\4\1\5\2\4\1\5\1\4\1\5\1\4"+
    "\1\5\1\4\1\5\1\4\1\5\1\4\2\5\1\4"+
    "\1\5\2\4\4\5\1\4\7\5\1\4\4\5\1\4"+
    "\4\5\1\4\1\5\1\4\12\5\1\4\21\5\5\4"+
    "\3\5\1\4\5\5\1\4\21\5\u0134\4\12\0\6\4"+
    "\336\5\42\4\65\5\13\4\336\5\2\4\u0182\5\16\4"+
    "\u0131\5\37\4\36\5\342\4\113\5\266\4\1\0\36\4"+
    "\140\0\200\4\360\0\20\4";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[31232];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\1"+
    "\1\7\1\10\1\1\1\11\1\12\1\13\2\7\1\0"+
    "\1\7\4\0\1\14\3\15\1\0\3\7\1\0\2\16"+
    "\2\15\3\16\2\15\2\16\1\15\1\0\1\15\2\0"+
    "\1\17\1\0\1\20";

  private static int [] zzUnpackAction() {
    int [] result = new int[50];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\43\0\43\0\106\0\151\0\43\0\43\0\214"+
    "\0\257\0\43\0\322\0\43\0\43\0\43\0\365\0\u0118"+
    "\0\u013b\0\u015e\0\u0181\0\u01a4\0\u01c7\0\u01ea\0\43\0\u020d"+
    "\0\u0230\0\u0253\0\u0276\0\u0299\0\u02bc\0\u02df\0\u0302\0\43"+
    "\0\u01a4\0\u0325\0\u0348\0\u036b\0\u038e\0\u03b1\0\u03d4\0\u03f7"+
    "\0\u041a\0\u043d\0\u0460\0\u0483\0\u04a6\0\u04c9\0\u04ec\0\43"+
    "\0\u050f\0\43";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[50];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\2\1\3\1\2\1\4\1\5\1\6"+
    "\1\7\2\2\1\10\1\11\2\4\1\12\1\13\1\14"+
    "\16\4\1\15\1\16\1\2\43\0\1\4\4\0\1\4"+
    "\6\0\3\4\3\0\16\4\2\0\1\4\2\5\2\0"+
    "\36\5\15\0\1\17\41\0\1\17\1\11\1\0\1\20"+
    "\3\0\1\11\1\0\1\21\1\0\1\22\1\0\1\23"+
    "\1\24\1\0\1\25\1\26\14\0\1\27\2\0\2\30"+
    "\1\0\3\30\3\0\1\30\1\31\2\30\1\32\11\30"+
    "\16\0\1\33\1\34\1\0\1\20\3\0\1\17\1\0"+
    "\1\21\1\0\1\22\1\0\1\23\1\24\1\0\1\25"+
    "\1\26\20\0\1\35\1\33\1\36\5\0\1\35\1\0"+
    "\1\21\1\0\1\37\1\0\1\23\1\24\1\0\1\25"+
    "\1\26\37\0\1\40\23\0\1\35\1\33\1\36\5\0"+
    "\1\35\1\0\1\21\1\0\1\37\1\0\1\23\1\41"+
    "\1\0\1\25\1\26\2\0\1\40\35\0\1\40\41\0"+
    "\1\40\4\0\1\40\41\0\1\40\40\0\1\40\20\0"+
    "\2\30\1\0\3\30\3\0\16\30\14\0\2\30\1\0"+
    "\3\30\3\0\4\30\1\42\11\30\14\0\2\30\1\0"+
    "\3\30\3\0\10\30\1\43\5\30\17\0\1\44\41\0"+
    "\1\44\1\34\1\0\1\20\3\0\1\34\1\0\1\21"+
    "\1\0\1\22\1\0\1\23\1\24\1\0\1\25\1\26"+
    "\21\0\1\33\1\36\5\0\1\35\1\0\1\21\1\0"+
    "\1\37\1\0\1\23\1\24\1\0\1\25\1\26\21\0"+
    "\1\44\1\36\1\0\1\45\3\0\1\36\1\0\1\21"+
    "\1\0\1\46\1\0\1\23\1\24\1\0\1\25\1\26"+
    "\37\0\1\40\5\0\1\40\14\0\2\30\1\0\3\30"+
    "\3\0\5\30\1\47\10\30\14\0\2\30\1\0\3\30"+
    "\3\0\3\30\1\50\12\30\16\0\1\33\1\51\1\0"+
    "\1\45\3\0\1\44\1\0\1\21\1\0\1\46\1\0"+
    "\1\23\1\24\1\0\1\25\1\26\20\0\1\52\1\33"+
    "\1\51\5\0\1\52\1\0\1\21\1\0\1\37\1\0"+
    "\1\23\1\24\1\0\1\25\1\26\20\0\1\52\1\33"+
    "\1\51\5\0\1\52\1\0\1\21\1\0\1\37\1\0"+
    "\1\23\1\41\1\0\1\25\1\26\2\0\1\40\14\0"+
    "\2\30\1\0\3\30\3\0\6\30\1\53\7\30\14\0"+
    "\2\30\1\0\3\30\3\0\16\30\1\54\15\0\1\44"+
    "\1\51\1\0\1\45\3\0\1\51\1\0\1\21\1\0"+
    "\1\46\1\0\1\23\1\24\1\0\1\25\1\26\21\0"+
    "\1\33\1\51\5\0\1\52\1\0\1\21\1\0\1\37"+
    "\1\0\1\23\1\24\1\0\1\25\1\26\17\0\2\30"+
    "\1\0\3\30\3\0\10\30\1\55\5\30\14\0\2\56"+
    "\1\0\3\56\3\0\16\56\14\0\2\30\1\0\3\30"+
    "\3\0\16\30\1\57\13\0\2\56\1\0\3\56\3\0"+
    "\16\56\1\0\1\60\12\0\2\61\1\0\3\61\3\0"+
    "\16\61\14\0\2\61\1\0\3\61\3\0\16\61\1\0"+
    "\1\62\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1330];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\2\1\2\11\2\1\1\11\1\1\3\11"+
    "\2\1\1\0\1\1\4\0\1\11\3\1\1\0\3\1"+
    "\1\0\1\11\13\1\1\0\1\1\2\0\1\11\1\0"+
    "\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[50];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
  public final int getTokenStart() {
      return (int) yychar;
  }

  public final int getTokenEnd() {
      return getTokenStart() + yylength();
  }

  public final List<TokenData> getBeginTokens() {
      ArrayList<TokenData> tokenList = new ArrayList<>();
      tokenList.add(new TokenData(zzStartRead, zzStartRead + 5, LatexToken.RESERVED_WORD));
      tokenList.add(new TokenData(zzStartRead + 6, zzStartRead + 6, LatexToken.SEPARATOR));
      tokenList.add(new TokenData(zzStartRead + 7, zzMarkedPos - 2, LatexToken.RESERVED_WORD));
      tokenList.add(new TokenData(zzMarkedPos - 1, zzMarkedPos - 1, LatexToken.SEPARATOR));
      return tokenList;
  }

  public final List<TokenData> getEndTokens() {
      ArrayList<TokenData> tokenList = new ArrayList<>();
      tokenList.add(new TokenData(zzStartRead, zzStartRead + 3, LatexToken.RESERVED_WORD));
      tokenList.add(new TokenData(zzStartRead + 4, zzStartRead + 4, LatexToken.SEPARATOR));
      tokenList.add(new TokenData(zzStartRead + 5, zzMarkedPos - 2, LatexToken.RESERVED_WORD));
      tokenList.add(new TokenData(zzMarkedPos - 1, zzMarkedPos - 1, LatexToken.SEPARATOR));
      return tokenList;
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LatexLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length * 2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException(
          "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE) {
      zzBuffer = new char[ZZ_BUFFERSIZE];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @NotNull
  public LatexToken advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
              {
                return LatexToken.EOF;
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return LatexToken.BAD_CHARACTER;
            }
            // fall through
          case 17: break;
          case 2:
            { return LatexToken.WHITESPACE;
            }
            // fall through
          case 18: break;
          case 3:
            { return LatexToken.IDENTIFIER;
            }
            // fall through
          case 19: break;
          case 4:
            { return LatexToken.LINE_COMMENT;
            }
            // fall through
          case 20: break;
          case 5:
            { return LatexToken.LPAREN;
            }
            // fall through
          case 21: break;
          case 6:
            { return LatexToken.RPAREN;
            }
            // fall through
          case 22: break;
          case 7:
            { return LatexToken.NUMBER;
            }
            // fall through
          case 23: break;
          case 8:
            { return LatexToken.LBRACK;
            }
            // fall through
          case 24: break;
          case 9:
            { return LatexToken.RBRACK;
            }
            // fall through
          case 25: break;
          case 10:
            { return LatexToken.LBRACE;
            }
            // fall through
          case 26: break;
          case 11:
            { return LatexToken.RBRACE;
            }
            // fall through
          case 27: break;
          case 12:
            { return LatexToken.SEPARATOR;
            }
            // fall through
          case 28: break;
          case 13:
            { return LatexToken.FUNCTION;
            }
            // fall through
          case 29: break;
          case 14:
            { return LatexToken.LENGTH;
            }
            // fall through
          case 30: break;
          case 15:
            { return LatexToken.END_BLOCK;
            }
            // fall through
          case 31: break;
          case 16:
            { return LatexToken.BEGIN_BLOCK;
            }
            // fall through
          case 32: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
