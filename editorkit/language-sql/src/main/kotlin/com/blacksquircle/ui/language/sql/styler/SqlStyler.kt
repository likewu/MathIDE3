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

package com.blacksquircle.ui.language.sql.styler

import com.blacksquircle.ui.language.base.model.SyntaxHighlightResult
import com.blacksquircle.ui.language.base.model.TextStructure
import com.blacksquircle.ui.language.base.model.TokenType
import com.blacksquircle.ui.language.base.styler.LanguageStyler
import com.blacksquircle.ui.language.sql.lexer.SqlLexer
import com.blacksquircle.ui.language.sql.lexer.SqlToken
import java.io.StringReader

class SqlStyler private constructor() : LanguageStyler {

    companion object {

        private var sqlStyler: SqlStyler? = null

        fun getInstance(): SqlStyler {
            return sqlStyler ?: SqlStyler().also {
                sqlStyler = it
            }
        }
    }

    override fun execute(structure: TextStructure): List<SyntaxHighlightResult> {
        val source = structure.text.toString()
        val syntaxHighlightResults = mutableListOf<SyntaxHighlightResult>()
        val sourceReader = StringReader(source)
        val lexer = SqlLexer(sourceReader)

        while (true) {
            try {
                when (lexer.advance()) {
                    SqlToken.INTEGER_LITERAL,
                    SqlToken.FLOAT_LITERAL,
                    SqlToken.DOUBLE_LITERAL -> {
                        val tokenType = TokenType.NUMBER
                        val syntaxHighlightResult = SyntaxHighlightResult(tokenType, lexer.tokenStart, lexer.tokenEnd)
                        syntaxHighlightResults.add(syntaxHighlightResult)
                    }
                    SqlToken.GTEQ,
                    SqlToken.LTEQ,
                    SqlToken.LTGT,
                    SqlToken.GT,
                    SqlToken.LT,
                    SqlToken.EQ,
                    SqlToken.PLUS,
                    SqlToken.MINUS,
                    SqlToken.MULT,
                    SqlToken.DIV,
                    SqlToken.BACKTICK,
                    SqlToken.LPAREN,
                    SqlToken.RPAREN,
                    SqlToken.LBRACK,
                    SqlToken.RBRACK,
                    SqlToken.SEMICOLON,
                    SqlToken.COMMA,
                    SqlToken.DOT -> {
                        val tokenType = TokenType.OPERATOR
                        val syntaxHighlightResult = SyntaxHighlightResult(tokenType, lexer.tokenStart, lexer.tokenEnd)
                        syntaxHighlightResults.add(syntaxHighlightResult)
                    }
                    SqlToken.ADD,
                    SqlToken.ALL,
                    SqlToken.ALTER,
                    SqlToken.AND,
                    SqlToken.ANY,
                    SqlToken.AS,
                    SqlToken.ASC,
                    SqlToken.AUTOINCREMENT,
                    SqlToken.AVA,
                    SqlToken.BETWEEN,
                    SqlToken.BINARY,
                    SqlToken.BIT,
                    SqlToken.BLOB,
                    SqlToken.BOOLEAN,
                    SqlToken.BY,
                    SqlToken.BYTE,
                    SqlToken.CHAR,
                    SqlToken.CHARACTER,
                    SqlToken.COLUMN,
                    SqlToken.CONSTRAINT,
                    SqlToken.COUNT,
                    SqlToken.COUNTER,
                    SqlToken.CREATE,
                    SqlToken.CURRENCY,
                    SqlToken.DATABASE,
                    SqlToken.DATE,
                    SqlToken.DATETIME,
                    SqlToken.DELETE,
                    SqlToken.DESC,
                    SqlToken.DISALLOW,
                    SqlToken.DISTINCT,
                    SqlToken.DISTINCTROW,
                    SqlToken.DOUBLE,
                    SqlToken.DROP,
                    SqlToken.EXISTS,
                    SqlToken.FLOAT,
                    SqlToken.FLOAT4,
                    SqlToken.FLOAT8,
                    SqlToken.FOREIGN,
                    SqlToken.FROM,
                    SqlToken.GENERAL,
                    SqlToken.GROUP,
                    SqlToken.GUID,
                    SqlToken.HAVING,
                    SqlToken.INNER,
                    SqlToken.INSERT,
                    SqlToken.IGNORE,
                    SqlToken.IF,
                    SqlToken.IMP,
                    SqlToken.IN,
                    SqlToken.INDEX,
                    SqlToken.INT,
                    SqlToken.INTEGER,
                    SqlToken.INTEGER1,
                    SqlToken.INTEGER2,
                    SqlToken.INTEGER4,
                    SqlToken.INTO,
                    SqlToken.IS,
                    SqlToken.JOIN,
                    SqlToken.KEY,
                    SqlToken.LEFT,
                    SqlToken.LEVEL,
                    SqlToken.LIKE,
                    SqlToken.LOGICAL,
                    SqlToken.LONG,
                    SqlToken.LONGBINARY,
                    SqlToken.LONGTEXT,
                    SqlToken.MAX,
                    SqlToken.MEMO,
                    SqlToken.MIN,
                    SqlToken.MOD,
                    SqlToken.MONEY,
                    SqlToken.NOT,
                    SqlToken.NULL,
                    SqlToken.NUMBER,
                    SqlToken.NUMERIC,
                    SqlToken.OLEOBJECT,
                    SqlToken.ON,
                    SqlToken.OPTION,
                    SqlToken.OR,
                    SqlToken.ORDER,
                    SqlToken.OUTER,
                    SqlToken.OWNERACCESS,
                    SqlToken.PARAMETERS,
                    SqlToken.PASSWORD,
                    SqlToken.PERCENT,
                    SqlToken.PIVOT,
                    SqlToken.PRIMARY,
                    SqlToken.REAL,
                    SqlToken.REFERENCES,
                    SqlToken.RIGHT,
                    SqlToken.SELECT,
                    SqlToken.SET,
                    SqlToken.SHORT,
                    SqlToken.SINGLE,
                    SqlToken.SMALLINT,
                    SqlToken.SOME,
                    SqlToken.STDEV,
                    SqlToken.STDEVP,
                    SqlToken.STRING,
                    SqlToken.SUM,
                    SqlToken.TABLE,
                    SqlToken.TABLEID,
                    SqlToken.TEXT,
                    SqlToken.TIME,
                    SqlToken.TIMESTAMP,
                    SqlToken.TOP,
                    SqlToken.TRANSFORM,
                    SqlToken.TYPE,
                    SqlToken.UNION,
                    SqlToken.UNIQUE,
                    SqlToken.UPDATE,
                    SqlToken.USER,
                    SqlToken.VALUE,
                    SqlToken.VALUES,
                    SqlToken.VAR,
                    SqlToken.VARBINARY,
                    SqlToken.VARCHAR,
                    SqlToken.VARP,
                    SqlToken.VIEW,
                    SqlToken.WHERE,
                    SqlToken.WITH,
                    SqlToken.YESNO,
                    SqlToken.AVG,
                    SqlToken.CURRENT_DATE,
                    SqlToken.CURRENT_TIME,
                    SqlToken.CURRENT_TIMESTAMP,
                    SqlToken.CURRENT_USER,
                    SqlToken.SESSION_USER,
                    SqlToken.SYSTEM_USER,
                    SqlToken.BIT_LENGTH,
                    SqlToken.CHAR_LENGTH,
                    SqlToken.EXTRACT,
                    SqlToken.OCTET_LENGTH,
                    SqlToken.POSITION,
                    SqlToken.CONCATENATE,
                    SqlToken.CONVERT,
                    SqlToken.LOWER,
                    SqlToken.SUBSTRING,
                    SqlToken.TRANSLATE,
                    SqlToken.TRIM,
                    SqlToken.UPPER -> {
                        syntaxHighlightResults.add(
                            SyntaxHighlightResult(
                                tokenType = TokenType.KEYWORD,
                                start = lexer.tokenStart,
                                end = lexer.tokenEnd
                            )
                        )
                    }
                    SqlToken.DOUBLE_QUOTED_STRING,
                    SqlToken.SINGLE_QUOTED_STRING -> {
                        val tokenType = TokenType.STRING
                        val syntaxHighlightResult = SyntaxHighlightResult(tokenType, lexer.tokenStart, lexer.tokenEnd)
                        syntaxHighlightResults.add(syntaxHighlightResult)
                    }
                    SqlToken.LINE_COMMENT,
                    SqlToken.BLOCK_COMMENT -> {
                        val tokenType = TokenType.COMMENT
                        val syntaxHighlightResult = SyntaxHighlightResult(tokenType, lexer.tokenStart, lexer.tokenEnd)
                        syntaxHighlightResults.add(syntaxHighlightResult)
                    }
                    SqlToken.IDENTIFIER,
                    SqlToken.WHITESPACE,
                    SqlToken.BAD_CHARACTER -> {
                        continue
                    }
                    SqlToken.EOF -> {
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