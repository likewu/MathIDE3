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

package com.blacksquircle.ui.editorkit.utils

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.blacksquircle.ui.language.base.model.SyntaxHighlightResult
import java.util.concurrent.Executors

class StylingTask(
    private val doAsync: () -> List<SyntaxHighlightResult>,
    private val onSuccess: (List<SyntaxHighlightResult>) -> Unit,
) {

    private val mainThreadHandler = Handler(Looper.getMainLooper())
    private val singleThreadExecutor = Executors.newSingleThreadExecutor()

    fun execute() {
        singleThreadExecutor.execute {
            try {
                val syntaxHighlightSpans = doAsync()
                mainThreadHandler.post {
                    if (!singleThreadExecutor.isShutdown) {
                        onSuccess(syntaxHighlightSpans)
                    }
                }
            } catch (e: Throwable) {
                Log.e(TAG, e.message, e)
            }
        }
    }

    fun cancel() {
        singleThreadExecutor.shutdown()
    }

    companion object {
        private const val TAG = "StylingTask"
    }
}