package com.nakharin.pocdeeplink.shared.deeplink.processor

import android.net.Uri
import com.nakharin.pocdeeplink.shared.deeplink.command.DeeplinkCommand

// https://blog.usejournal.com/navigation-in-modular-applications-with-deep-linking-6a599c11e487
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
