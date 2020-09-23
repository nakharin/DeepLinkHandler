package com.nakharin.pocdeeplink.shared.deeplink.processor

import android.app.Activity
import android.net.Uri
import androidx.fragment.app.FragmentActivity
import com.nakharin.pocdeeplink.shared.deeplink.command.DeeplinkCommand

// https://blog.usejournal.com/navigation-in-modular-applications-with-deep-linking-6a599c11e487

/**
 * How to test
 * com.nakharin://app?id=1111A
 * com.nakharin://food?id=2222B?coupon
 */
class DefaultDeeplinkProcessor(
    private val commands: Set<@JvmSuppressWildcards DeeplinkCommand>
) : DeeplinkProcessor {

    override fun process(activity: Activity?, uri: Uri): Boolean {
        commands.forEach {
            if (it.matches(uri)) {
                it.execute(activity, uri)
            }
        }
        return false
    }
}
