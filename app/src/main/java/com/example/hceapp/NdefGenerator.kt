package com.example.hceapp

import android.nfc.NdefMessage
import android.nfc.NdefRecord
import java.util.*

object NdefGenerator {
    fun generate(): ByteArray {
        val payload = "ID=${UUID.randomUUID()};T=${System.currentTimeMillis()}"
        val record = NdefRecord.createTextRecord("en", payload)
        val msg = NdefMessage(arrayOf(record))
        return msg.toByteArray()
    }
}
