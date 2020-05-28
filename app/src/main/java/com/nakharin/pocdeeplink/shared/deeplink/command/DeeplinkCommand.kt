package com.nakharin.pocdeeplink.shared.deeplink.command

import android.net.Uri

interface DeeplinkCommand {

    companion object {
        const val QUERY_ACTION = "action"
        const val QUERY_NAVIGATE = "navigate"
        const val EXTRA_DEEP_LINK_KEY = "deeplink_processor_extra"
    }

    fun matches(uri: Uri): Boolean

    fun execute(uri: Uri)

    fun tag(): String
}
