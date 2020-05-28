package com.nakharin.pocdeeplink.shared.deeplink.handler

import android.net.Uri
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkHandler
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkProcessor

class DefaultDeeplinkHandler(
    private val processors: Set<@JvmSuppressWildcards DeeplinkProcessor>
) : DeeplinkHandler {

    override fun process(uri: Uri): Boolean {
        processors.forEach {
            if (it.matches(uri)) {
                it.execute(uri)
                return true
            }
        }
        return false
    }
}
