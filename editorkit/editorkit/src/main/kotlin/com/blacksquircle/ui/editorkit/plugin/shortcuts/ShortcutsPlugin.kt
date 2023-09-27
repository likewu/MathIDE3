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

package com.blacksquircle.ui.editorkit.plugin.shortcuts

import android.util.Log
import android.view.KeyEvent
import com.blacksquircle.ui.editorkit.plugin.base.EditorPlugin
import com.blacksquircle.ui.editorkit.widget.TextProcessor

class ShortcutsPlugin : EditorPlugin(PLUGIN_ID) {

    var onShortcutListener: OnShortcutListener? = null
    var shortcutKeyFilter = emptyList<Int>()

    override fun onAttached(editText: TextProcessor) {
        super.onAttached(editText)
        Log.d(PLUGIN_ID, "Shortcuts plugin loaded successfully!")
    }

    override fun onDetached(editText: TextProcessor) {
        super.onDetached(editText)
        onShortcutListener = null
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        onShortcutListener?.let { onShortcutListener ->
            if (event == null ||
                keyCode == KeyEvent.KEYCODE_CTRL_LEFT ||
                keyCode == KeyEvent.KEYCODE_CTRL_RIGHT ||
                keyCode == KeyEvent.KEYCODE_ALT_LEFT ||
                keyCode == KeyEvent.KEYCODE_ALT_RIGHT
            ) {
                return false
            }

            val shortcut = Shortcut(
                ctrl = event.isCtrlPressed,
                shift = event.isShiftPressed,
                alt = event.isAltPressed,
                keyCode = keyCode,
            )

            // Shortcut can be handled only if ctrl or alt is pressed
            if (shortcut.ctrl || shortcut.alt || keyCode in shortcutKeyFilter) {
                if (onShortcutListener.onShortcut(shortcut)) {
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    companion object {
        const val PLUGIN_ID = "shortcuts-1095"
    }
}