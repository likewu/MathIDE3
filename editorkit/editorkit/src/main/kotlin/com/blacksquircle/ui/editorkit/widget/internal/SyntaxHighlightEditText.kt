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

package com.blacksquircle.ui.editorkit.widget.internal

import android.content.Context
import android.text.Editable
import android.text.InputFilter
import android.text.Spannable
import android.util.AttributeSet
import androidx.core.text.getSpans
import com.blacksquircle.ui.editorkit.model.*
import com.blacksquircle.ui.editorkit.model.FindResult
import com.blacksquircle.ui.editorkit.model.StyleSpan
import com.blacksquircle.ui.editorkit.setSelectionRange
import com.blacksquircle.ui.editorkit.utils.*
import com.blacksquircle.ui.language.base.Language
import com.blacksquircle.ui.language.base.model.SyntaxHighlightResult
import com.blacksquircle.ui.language.base.model.TokenType
import java.util.regex.Pattern
import java.util.regex.PatternSyntaxException

abstract class SyntaxHighlightEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.autoCompleteTextViewStyle,
) : UndoRedoEditText(context, attrs, defStyleAttr) {

    var language: Language? = null
        set(value) {
            field = value
            onLanguageChanged()
        }

    var colorScheme: ColorScheme = EditorTheme.DARCULA
        set(value) {
            field = value
            onColorSchemeChanged()
        }

    var useSpacesInsteadOfTabs = true
    var tabWidth = 4

    private val syntaxHighlightResults = mutableListOf<SyntaxHighlightResult>()
    private val findResults = mutableListOf<FindResult>()

    private var findResultStyleSpan: StyleSpan? = null
    private var task: StylingTask? = null

    private var addedTextCount = 0
    private var selectedFindResult = 0

    private var isSyntaxHighlighting = false
    private var isErrorSpansVisible = false

    init {
        filters = arrayOf(InputFilter { source, start, end, dest, dstart, _ ->
            if (end - start == 1 && start < source.length && dstart < dest.length) {
                val c = source[start]
                if (c == '\t') {
                    return@InputFilter tab()
                }
            }
            source
        })
    }

    override fun setTextContent(text: CharSequence) {
        syntaxHighlightResults.clear()
        findResults.clear()
        super.setTextContent(text)
        syntaxHighlight()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        updateSyntaxHighlighting()
        super.onSizeChanged(w, h, oldw, oldh)
    }

    override fun onScrollChanged(horiz: Int, vert: Int, oldHoriz: Int, oldVert: Int) {
        super.onScrollChanged(horiz, vert, oldHoriz, oldVert)
        updateSyntaxHighlighting()
    }

    override fun doBeforeTextChanged(text: CharSequence?, start: Int, count: Int, after: Int) {
        addedTextCount -= count
        cancelSyntaxHighlighting()
        if (!isSyntaxHighlighting) {
            super.doBeforeTextChanged(text, start, count, after)
        }
        abortFling()
    }

    override fun doOnTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {
        addedTextCount += count
        if (!isSyntaxHighlighting) {
            super.doOnTextChanged(text, start, before, count)
        }
    }

    override fun doAfterTextChanged(text: Editable?) {
        if (!isSyntaxHighlighting) {
            shiftSpans(selectionStart, addedTextCount)
        }
        addedTextCount = 0
        syntaxHighlight()
    }

    protected open fun onLanguageChanged() {
        syntaxHighlight()
    }

    protected open fun onColorSchemeChanged() {
        findResultStyleSpan = StyleSpan(color = colorScheme.findResultBackgroundColor)
        setTextColor(colorScheme.textColor)
        setCursorDrawableColor(colorScheme.cursorColor)
        setBackgroundColor(colorScheme.backgroundColor)
        highlightColor = colorScheme.selectionColor
    }

    fun tab(): String {
        return if (useSpacesInsteadOfTabs) {
            " ".repeat(tabWidth)
        } else {
            "\t"
        }
    }

    fun setErrorLine(lineNumber: Int) {
        if (lineNumber > 0) {
            val lineStart = structure.getIndexForStartOfLine(lineNumber - 1)
            val lineEnd = structure.getIndexForEndOfLine(lineNumber - 1)
            if (lineStart < text.length && lineEnd < text.length && lineStart > -1 && lineEnd > -1) {
                isErrorSpansVisible = true
                text.setSpan(ErrorSpan(), lineStart, lineEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }

    fun find(params: FindParams) {
        clearFindResultSpans()
        if (params.query.isNotEmpty()) {
            try {
                val pattern = when {
                    params.regex && params.matchCase -> Pattern.compile(params.query)
                    params.regex && !params.matchCase -> Pattern.compile(
                        params.query,
                        Pattern.CASE_INSENSITIVE or Pattern.UNICODE_CASE,
                    )
                    params.wordsOnly && params.matchCase -> Pattern.compile("\\s${params.query}\\s")
                    params.wordsOnly && !params.matchCase -> Pattern.compile(
                        "\\s" + Pattern.quote(params.query) + "\\s",
                        Pattern.CASE_INSENSITIVE or Pattern.UNICODE_CASE,
                    )
                    params.matchCase -> Pattern.compile(Pattern.quote(params.query))
                    else -> Pattern.compile(
                        Pattern.quote(params.query),
                        Pattern.CASE_INSENSITIVE or Pattern.UNICODE_CASE,
                    )
                }
                val matcher = pattern.matcher(text)
                while (matcher.find()) {
                    val findResult = FindResult(matcher.start(), matcher.end())
                    findResults.add(findResult)
                }
                if (findResults.isNotEmpty()) {
                    selectResult()
                }
            } catch (e: PatternSyntaxException) {
                // nothing
            }
        }
        updateSyntaxHighlighting()
    }

    fun find(findResults: List<FindResult>) {
        clearFindResultSpans()
        if (findResults.isNotEmpty()) {
            this.findResults.addAll(findResults)
            selectResult()
        }
        updateSyntaxHighlighting()
    }

    fun findNext() {
        if (selectedFindResult < findResults.size - 1) {
            selectedFindResult += 1
            selectResult()
        }
    }

    fun findPrevious() {
        if (selectedFindResult > 0 && selectedFindResult < findResults.size) {
            selectedFindResult -= 1
            selectResult()
        }
    }

    fun replaceFindResult(replaceText: String) {
        if (findResults.isNotEmpty()) {
            val findResult = findResults[selectedFindResult]
            text.replace(findResult.start, findResult.end, replaceText)
            findResults.remove(findResult)
            if (selectedFindResult >= findResults.size) {
                selectedFindResult--
            }
        }
    }

    fun replaceAllFindResults(replaceText: String) {
        if (findResults.isNotEmpty()) {
            val stringBuilder = StringBuilder(text)
            for (index in findResults.size - 1 downTo 0) {
                val findResultSpan = findResults[index]
                stringBuilder.replace(findResultSpan.start, findResultSpan.end, replaceText)
                findResults.removeAt(index)
            }
            setText(stringBuilder.toString())
        }
    }

    fun clearFindResultSpans() {
        selectedFindResult = 0
        findResults.clear()
        val spans = text.getSpans<FindResultSpan>(0, text.length)
        for (span in spans) {
            text.removeSpan(span)
        }
    }

    private fun selectResult() {
        val findResult = findResults[selectedFindResult]
        setSelectionRange(findResult.start, findResult.end)
        scrollToFindResult()
    }

    private fun scrollToFindResult() {
        if (selectedFindResult < findResults.size) {
            val findResult = findResults[selectedFindResult]
            if (findResult.start >= layout.getLineStart(topVisibleLine) &&
                findResult.end <= layout.getLineEnd(bottomVisibleLine)
            ) {
                return
            }
            val height = layout.height - height + paddingBottom + paddingTop
            var lineTop = layout.getLineTop(layout.getLineForOffset(findResult.start))
            if (lineTop > height) {
                lineTop = height
            }
            val scrollX = if (isHorizontallyScrollableCompat()) {
                layout.getPrimaryHorizontal(findResult.start).toInt()
            } else {
                scrollX
            }

            scrollTo(scrollX, lineTop)
        }
    }

    private fun shiftSpans(from: Int, byHowMuch: Int) {
        for (span in syntaxHighlightResults) {
            if (span.start >= from) {
                span.start += byHowMuch
            }
            if (span.end >= from) {
                span.end += byHowMuch
            }
            /*if (span.start > span.end) {
                syntaxHighlightSpans.remove(span) // FIXME ConcurrentModificationException
            }*/
        }
        for (findResult in findResults) {
            /*if (from > findResult.start && from <= findResult.end) {
                findResultSpans.remove(findResult) // FIXME ConcurrentModificationException
            }*/
            if (findResult.start > from) {
                findResult.start += byHowMuch
            }
            if (findResult.end >= from) {
                findResult.end += byHowMuch
            }
        }
        if (isErrorSpansVisible) {
            val spans = text.getSpans<ErrorSpan>(0, text.length)
            for (span in spans) {
                text.removeSpan(span)
            }
            isErrorSpansVisible = false
        }
    }

    private fun updateSyntaxHighlighting() {
        if (layout != null) {
            val lineStart = layout.getLineStart(topVisibleLine)
            val lineEnd = layout.getLineEnd(bottomVisibleLine)

            isSyntaxHighlighting = true
            val textSyntaxHighlightSpans = text.getSpans<SyntaxHighlightSpan>(0, text.length)
            for (span in textSyntaxHighlightSpans) {
                text.removeSpan(span)
            }
            for (result in syntaxHighlightResults) {
                val isInText = result.start >= 0 && result.end <= text.length
                val isValid = result.start <= result.end
                val isVisible = result.start in lineStart..lineEnd ||
                    result.start <= lineEnd && result.end >= lineStart
                if (isInText && isValid && isVisible) {
                    text.setSpan(
                        SyntaxHighlightSpan(
                            StyleSpan(
                                color = when (result.tokenType) {
                                    TokenType.NUMBER -> colorScheme.numberColor
                                    TokenType.OPERATOR -> colorScheme.operatorColor
                                    TokenType.KEYWORD -> colorScheme.keywordColor
                                    TokenType.TYPE -> colorScheme.typeColor
                                    TokenType.LANG_CONST -> colorScheme.langConstColor
                                    TokenType.PREPROCESSOR -> colorScheme.preprocessorColor
                                    TokenType.VARIABLE -> colorScheme.variableColor
                                    TokenType.METHOD -> colorScheme.methodColor
                                    TokenType.STRING -> colorScheme.stringColor
                                    TokenType.COMMENT -> colorScheme.commentColor
                                    TokenType.TAG -> colorScheme.tagColor
                                    TokenType.TAG_NAME -> colorScheme.tagNameColor
                                    TokenType.ATTR_NAME -> colorScheme.attrNameColor
                                    TokenType.ATTR_VALUE -> colorScheme.attrValueColor
                                    TokenType.ENTITY_REF -> colorScheme.entityRefColor
                                }
                            )
                        ),
                        if (result.start < lineStart) lineStart else result.start,
                        if (result.end > lineEnd) lineEnd else result.end,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
                    )
                }
            }
            isSyntaxHighlighting = false

            val textFindResultSpans = text.getSpans<FindResultSpan>(0, text.length)
            for (span in textFindResultSpans) {
                text.removeSpan(span)
            }
            findResultStyleSpan?.let { styleSpan ->
                for (result in findResults) {
                    val isInText = result.start >= 0 && result.end <= text.length
                    val isValid = result.start <= result.end
                    val isVisible = result.start in lineStart..lineEnd ||
                        result.start <= lineEnd && result.end >= lineStart
                    if (isInText && isValid && isVisible) {
                        text.setSpan(
                            FindResultSpan(styleSpan),
                            if (result.start < lineStart) lineStart else result.start,
                            if (result.end > lineEnd) lineEnd else result.end,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE,
                        )
                    }
                }
            }

            if (!useSpacesInsteadOfTabs) {
                // FIXME word wrap issues
                val textTabSpans = text.getSpans<TabWidthSpan>(0, text.length)
                for (span in textTabSpans) {
                    text.removeSpan(span)
                }

                val tabPattern = Pattern.compile("\t")
                val matcher = tabPattern.matcher(text.subSequence(lineStart, lineEnd))
                while (matcher.find()) {
                    val start = matcher.start() + lineStart
                    val end = matcher.end() + lineStart
                    if (start >= 0 && end <= text.length) {
                        text.setSpan(
                            TabWidthSpan(tabWidth),
                            start,
                            end,
                            Spannable.SPAN_INCLUSIVE_INCLUSIVE,
                        )
                    }
                }
            }
            postInvalidate()
        }
    }

    private fun syntaxHighlight() {
        cancelSyntaxHighlighting()
        task = StylingTask(
            doAsync = { language?.getStyler()?.execute(structure) ?: emptyList() },
            onSuccess = { spans ->
                syntaxHighlightResults.clear()
                syntaxHighlightResults.addAll(spans)
                updateSyntaxHighlighting()
            },
        )
        task?.execute()
    }

    private fun cancelSyntaxHighlighting() {
        task?.cancel()
        task = null
    }
}