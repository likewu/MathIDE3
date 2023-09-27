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

package com.blacksquircle.ui.language.markdown.parser

import com.blacksquircle.ui.language.base.model.ParseResult
import com.blacksquircle.ui.language.base.model.TextStructure
import com.blacksquircle.ui.language.base.parser.LanguageParser

class MarkdownParser private constructor() : LanguageParser {

    companion object {

        private var markdownParser: MarkdownParser? = null

        fun getInstance(): MarkdownParser {
            return markdownParser ?: MarkdownParser().also {
                markdownParser = it
            }
        }
    }

    override fun execute(structure: TextStructure): ParseResult {
        TODO("Not yet implemented")
    }
}