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

package com.blacksquircle.ui.language.julia.parser

import com.blacksquircle.ui.language.base.exception.ParseException
import com.blacksquircle.ui.language.base.model.ParseResult
import com.blacksquircle.ui.language.base.model.TextStructure
import com.blacksquircle.ui.language.base.parser.LanguageParser
import java.io.File
//import android.os.Environment

class JuliaParser private constructor() : LanguageParser {

    companion object {

        private var juliaParser: JuliaParser? = null

        fun getInstance(): JuliaParser {
            return juliaParser ?: JuliaParser().also {
                juliaParser = it
            }
        }
    }

    override fun execute(structure: TextStructure): ParseResult {
        TODO("Not yet implemented")
    }
    override fun execute(name: String, source: String, path: String, extRootDir: File?): ParseResult {
        //val mathlandDir = File(Environment.getExternalStorageDirectory(), "MathLand")
        //val mathlandDir = File("/storage/emulated/0/", "MathLand")
        val mathlandDir = File(extRootDir, "MathLand")
        if (mathlandDir.exists() == false) {
            val parseException = ParseException("Please make sure MathLand is installed and sdCard 'MathLand' directory is exist.", 0, 0)
            return ParseResult(parseException)
        }

        if (path.contains(mathlandDir.absolutePath)  == false) {
            val parseException = ParseException("Please make sure the source in sdCard 'MathLand' directory.", 0, 0)
            return ParseResult(parseException)
        }

        return ParseResult(null)
    }
}