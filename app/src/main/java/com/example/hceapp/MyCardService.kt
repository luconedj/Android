package com.example.hceapp

import android.nfc.cardemulation.HostApduService
import android.os.Bundle

class MyCardService : HostApduService() {
    companion object { @Volatile var enabled: Boolean = false }

    override fun processCommandApdu(commandApdu: ByteArray, extras: Bundle?): ByteArray {
        return if (enabled) NdefGenerator.generate()
        else byteArrayOf(0x6A, 0x81.toByte())
    }
    override fun onDeactivated(reason: Int) {}
}
