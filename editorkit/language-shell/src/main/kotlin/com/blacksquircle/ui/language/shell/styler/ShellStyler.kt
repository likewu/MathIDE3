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

package com.blacksquircle.ui.language.shell.styler

import com.blacksquircle.ui.language.base.model.SyntaxHighlightResult
import com.blacksquircle.ui.language.base.model.TextStructure
import com.blacksquircle.ui.language.base.model.TokenType
import com.blacksquircle.ui.language.base.styler.LanguageStyler
import com.blacksquircle.ui.language.shell.lexer.ShellLexer
import com.blacksquircle.ui.language.shell.lexer.ShellToken
import java.io.StringReader
import java.util.regex.Pattern

class ShellStyler private constructor() : LanguageStyler {

    companion object {

        private val METHOD = Pattern.compile("(\\w+\\s*\\w*)\\(\\)\\s*\\{")

        private var shellStyler: ShellStyler? = null

        fun getInstance(): ShellStyler {
            return shellStyler ?: ShellStyler().also {
                shellStyler = it
            }
        }
    }

    override fun execute(structure: TextStructure): List<SyntaxHighlightResult> {
        val source = structure.text.toString()
        val syntaxHighlightResults = mutableListOf<SyntaxHighlightResult>()
        val sourceReader = StringReader(source)
        val lexer = ShellLexer(sourceReader)

        val matcher = METHOD.matcher(source)
        matcher.region(0, source.length)
        while (matcher.find()) {
            val tokenType = TokenType.METHOD
            val syntaxHighlightResult = SyntaxHighlightResult(tokenType, matcher.start(), matcher.end())
            syntaxHighlightResults.add(syntaxHighlightResult)
        }

        while (true) {
            try {
                when (lexer.advance()) {
                    ShellToken.INTEGER_LITERAL,
                    ShellToken.DOUBLE_LITERAL -> {
                        val tokenType = TokenType.NUMBER
                        val syntaxHighlightResult = SyntaxHighlightResult(tokenType, lexer.tokenStart, lexer.tokenEnd)
                        syntaxHighlightResults.add(syntaxHighlightResult)
                    }
                    ShellToken.BREAK,
                    ShellToken.CASE,
                    ShellToken.CONTINUE,
                    ShellToken.ECHO,
                    ShellToken.ESAC,
                    ShellToken.EVAL,
                    ShellToken.ELIF,
                    ShellToken.ELSE,
                    ShellToken.EXIT,
                    ShellToken.EXEC,
                    ShellToken.EXPORT,
                    ShellToken.DONE,
                    ShellToken.DO,
                    ShellToken.FI,
                    ShellToken.FOR,
                    ShellToken.IN,
                    ShellToken.FUNCTION,
                    ShellToken.IF,
                    ShellToken.SET,
                    ShellToken.SELECT,
                    ShellToken.SHIFT,
                    ShellToken.TRAP,
                    ShellToken.THEN,
                    ShellToken.ULIMIT,
                    ShellToken.UMASK,
                    ShellToken.UNSET,
                    ShellToken.UNTIL,
                    ShellToken.WAIT,
                    ShellToken.WHILE,
                    ShellToken.LET,
                    ShellToken.LOCAL,
                    ShellToken.READ,
                    ShellToken.READONLY,
                    ShellToken.RETURN,
                    ShellToken.TEST -> {
                        val tokenType = TokenType.KEYWORD
                        val syntaxHighlightResult = SyntaxHighlightResult(tokenType, lexer.tokenStart, lexer.tokenEnd)
                        syntaxHighlightResults.add(syntaxHighlightResult)
                    }
                    ShellToken.TRUE,
                    ShellToken.FALSE -> {
                        val tokenType = TokenType.LANG_CONST
                        val syntaxHighlightResult = SyntaxHighlightResult(tokenType, lexer.tokenStart, lexer.tokenEnd)
                        syntaxHighlightResults.add(syntaxHighlightResult)
                    }
                    ShellToken.MULTEQ,
                    ShellToken.DIVEQ,
                    ShellToken.MODEQ,
                    ShellToken.PLUSEQ,
                    ShellToken.MINUSEQ,
                    ShellToken.SHIFT_RIGHT_EQ,
                    ShellToken.SHIFT_LEFT_EQ,
                    ShellToken.BIT_AND_EQ,
                    ShellToken.BIT_OR_EQ,
                    ShellToken.BIT_XOR_EQ,
                    ShellToken.NOTEQ,
                    ShellToken.EQEQ,
                    ShellToken.REGEXP,
                    ShellToken.GTEQ,
                    ShellToken.LTEQ,
                    ShellToken.PLUS_PLUS,
                    ShellToken.MINUS_MINUS,
                    ShellToken.EXPONENT,
                    ShellToken.BANG,
                    ShellToken.TILDE,
                    ShellToken.PLUS,
                    ShellToken.MINUS,
                    ShellToken.MULT,
                    ShellToken.DIV,
                    ShellToken.MOD,
                    ShellToken.SHIFT_LEFT,
                    ShellToken.SHIFT_RIGHT,
                    ShellToken.LT,
                    ShellToken.GT,
                    ShellToken.AND_AND,
                    ShellToken.OR_OR,
                    ShellToken.AND,
                    ShellToken.XOR,
                    ShellToken.OR,
                    ShellToken.DOLLAR,
                    ShellToken.EQ,
                    ShellToken.BACKTICK,
                    ShellToken.QUEST,
                    ShellToken.COLON,
                    ShellToken.LPAREN,
                    ShellToken.RPAREN,
                    ShellToken.LBRACE,
                    ShellToken.RBRACE,
                    ShellToken.LBRACK,
                    ShellToken.RBRACK,
                    ShellToken.EVAL_CONTENT -> {
                        val tokenType = TokenType.OPERATOR
                        val syntaxHighlightResult = SyntaxHighlightResult(tokenType, lexer.tokenStart, lexer.tokenEnd)
                        syntaxHighlightResults.add(syntaxHighlightResult)
                    }
                    ShellToken.SEMICOLON,
                    ShellToken.COMMA,
                    ShellToken.DOT -> {
                        continue // skip
                    }
                    ShellToken.SHEBANG,
                    ShellToken.COMMENT -> {
                        val tokenType = TokenType.COMMENT
                        val syntaxHighlightResult = SyntaxHighlightResult(tokenType, lexer.tokenStart, lexer.tokenEnd)
                        syntaxHighlightResults.add(syntaxHighlightResult)
                    }
                    ShellToken.DOUBLE_QUOTED_STRING,
                    ShellToken.SINGLE_QUOTED_STRING -> {
                        val tokenType = TokenType.STRING
                        val syntaxHighlightResult = SyntaxHighlightResult(tokenType, lexer.tokenStart, lexer.tokenEnd)
                        syntaxHighlightResults.add(syntaxHighlightResult)
                    }
                    ShellToken.IDENTIFIER,
                    ShellToken.WHITESPACE,
                    ShellToken.BAD_CHARACTER -> {
                        continue
                    }
                    ShellToken.EOF -> {
                        break
                    }
                }
            } catch (e: Throwable) {
                e.printStackTrace()
                break
            }
        }
        return syntaxHighlightResults
    }
}