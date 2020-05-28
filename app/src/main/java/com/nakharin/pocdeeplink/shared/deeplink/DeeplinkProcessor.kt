package com.nakharin.pocdeeplink.shared.deeplink

import android.net.Uri

interface DeeplinkProcessor {

    companion object {
        const val ACTION = "action"
        const val NAVIGATE = "navigate"
        const val DEEP_LINK_EXTRA_KEY = "deeplink_processor_extra"
    }

    fun matches(uri: Uri): Boolean

    fun execute(uri: Uri)

    fun tag(): String
}
