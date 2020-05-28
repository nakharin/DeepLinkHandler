package com.nakharin.pocdeeplink.shared.deeplink.processor

import android.net.Uri
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkProcessor
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkCommand

class DefaultDeeplinkProcessor(
    private val commands: Set<@JvmSuppressWildcards DeeplinkCommand>
) : DeeplinkProcessor {

    override fun process(uri: Uri): Boolean {
        commands.forEach {
            if (it.matches(uri)) {
                it.execute(uri)
                return true
            }
        }
        return false
    }
}
