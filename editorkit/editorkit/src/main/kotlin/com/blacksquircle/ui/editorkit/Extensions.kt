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

package com.blacksquircle.ui.editorkit

import android.content.ClipData
import android.content.ClipboardManager
import android.widget.EditText
import androidx.core.content.getSystemService
import com.blacksquircle.ui.editorkit.exception.LineException
import com.blacksquircle.ui.editorkit.widget.TextProcessor

val EditText.selectionPair: Pair<Int, Int>
    get() {
        val start = selectionStart
        val end = selectionEnd
        return if (start > end) end to start else start to end
    }

val EditText.selectedText: String
    get() {
        val (start, end) = selectionPair
        return text.substring(start, end)
    }

fun EditText.insert(delta: CharSequence) {
    val (start, end) = selectionPair
    text.replace(start, end, delta)
}

fun EditText.cut() {
    try {
        val clipboardManager = context.getSystemService<ClipboardManager>()
        val clipData = ClipData.newPlainText(null, selectedText)
        clipboardManager?.setPrimaryClip(clipData)

        val (start, end) = selectionPair
        text.replace(start, end, "")
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun EditText.copy() {
    try {
        val clipboardManager = context.getSystemService<ClipboardManager>()
        val clipData = ClipData.newPlainText(null, selectedText)
        clipboardManager?.setPrimaryClip(clipData)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun EditText.paste() {
    try {
        val clipboardManager = context.getSystemService<ClipboardManager>()
        val clipData = clipboardManager?.primaryClip?.getItemAt(0)
        val clipText = clipData?.coerceToText(context)

        val (start, end) = selectionPair
        text.replace(start, end, clipText)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun EditText.setSelectionRange(start: Int, end: Int) {
    setSelection(
        if (start > text.length) text.length else start,
        if (end > text.length) text.length else end,
    )
}

fun EditText.setSelectionIndex(index: Int) {
    setSelection(
        if (index > text.length) text.length else index,
    )
}

fun TextProcessor.selectLine() {
    val currentLine = structure.getLineForIndex(selectionStart)
    val lineStart = structure.getIndexForStartOfLine(currentLine)
    val lineEnd = structure.getIndexForEndOfLine(currentLine)
    setSelectionRange(lineStart, lineEnd)
}

fun TextProcessor.deleteLine() {
    val currentLine = structure.getLineForIndex(selectionStart)
    val lineStart = structure.getIndexForStartOfLine(currentLine)
    val lineEnd = structure.getIndexForEndOfLine(currentLine)
    text.delete(lineStart, lineEnd)
}

fun TextProcessor.duplicateLine() {
    if (hasSelection()) {
        val (start, end) = selectionPair
        text.replace(start, end, selectedText + selectedText)
        setSelectionRange(end, end + selectedText.length)
    } else {
        val currentLine = structure.getLineForIndex(selectionStart)
        val lineStart = structure.getIndexForStartOfLine(currentLine)
        val lineEnd = structure.getIndexForEndOfLine(currentLine)
        val lineText = text.subSequence(lineStart, lineEnd)
        text.insert(lineEnd, "\n" + lineText)
    }
}

fun TextProcessor.toggleCase() {
    val (start, end) = selectionPair
    val replacedText = if (selectedText.all(Char::isUpperCase)) {
        selectedText.lowercase()
    } else {
        selectedText.uppercase()
    }
    text.replace(start, end, replacedText)
    setSelectionRange(start, start + replacedText.length)
}

fun TextProcessor.moveCaretToStartOfLine() {
    val currentLine = structure.getLineForIndex(selectionStart)
    val lineStart = structure.getIndexForStartOfLine(currentLine)
    setSelectionIndex(lineStart)
}

fun TextProcessor.moveCaretToEndOfLine() {
    val currentLine = structure.getLineForIndex(selectionEnd)
    val lineEnd = structure.getIndexForEndOfLine(currentLine)
    setSelectionIndex(lineEnd)
}

fun TextProcessor.moveCaretToPrevWord(): Boolean {
    if (selectionStart > 0) {
        val currentChar = text[selectionStart - 1]
        val isLetterDigitOrUnderscore = currentChar.isLetterOrDigit() || currentChar == '_'
        if (isLetterDigitOrUnderscore) {
            for (i in selectionStart downTo 0) {
                val char = text[i - 1]
                if (!char.isLetterOrDigit() && char != '_') {
                    setSelectionIndex(i)
                    break
                }
            }
        } else {
            for (i in selectionStart downTo 0) {
                val char = text[i - 1]
                if (char.isLetterOrDigit() || char == '_') {
                    setSelectionIndex(i)
                    break
                }
            }
        }
    }
    return true
}

fun TextProcessor.moveCaretToNextWord(): Boolean {
    if (selectionStart < text.length) {
        val currentChar = text[selectionStart]
        val isLetterDigitOrUnderscore = currentChar.isLetterOrDigit() || currentChar == '_'
        if (isLetterDigitOrUnderscore) {
            for (i in selectionStart until text.length) {
                val char = text[i]
                if (!char.isLetterOrDigit() && char != '_') {
                    setSelectionIndex(i)
                    break
                }
            }
        } else {
            for (i in selectionStart until text.length) {
                val char = text[i]
                if (char.isLetterOrDigit() || char == '_') {
                    setSelectionIndex(i)
                    break
                }
            }
        }
    }
    return true
}

fun TextProcessor.gotoLine(lineNumber: Int) {
    val line = lineNumber - 1
    if (line < 0 || line >= structure.lineCount - 1) {
        throw LineException(lineNumber)
    }
    setSelectionIndex(structure.getIndexForLine(line))
}

fun TextProcessor.hasPrimaryClip(): Boolean {
    val clipboardManager = context.getSystemService<ClipboardManager>()
    return clipboardManager?.hasPrimaryClip() ?: false
}