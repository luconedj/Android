package com.example.hceapp

import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.KeyEvent

object VolumeKeyReceiver {
    private var lastClick: Long = 0
    private const val DOUBLE_CLICK_MS = 400
    private const val AUTO_DISABLE_MS = 3000L

    private val handler = Handler(Looper.getMainLooper())

    fun onKeyEvent(keyCode: Int) {
        if (keyCode != KeyEvent.KEYCODE_VOLUME_UP) return
        val now = SystemClock.elapsedRealtime()
        if (now - lastClick <= DOUBLE_CLICK_MS) enableFor3Sec()
        lastClick = now
    }

    private fun enableFor3Sec() {
        MyCardService.enabled = true
        handler.removeCallbacksAndMessages(null)
        handler.postDelayed({ MyCardService.enabled = false }, AUTO_DISABLE_MS)
    }
}
