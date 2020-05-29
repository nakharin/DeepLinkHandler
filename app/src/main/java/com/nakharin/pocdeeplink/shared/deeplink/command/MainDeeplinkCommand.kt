package com.nakharin.pocdeeplink.shared.deeplink.command

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.nakharin.pocdeeplink.shared.navigation.NavigationBuilder
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkMatcher
import com.nakharin.pocdeeplink.shared.deeplink.data.DeeplinkData
import com.nakharin.pocdeeplink.shared.deeplink.data.MainDeeplinkData
import com.nakharin.pocdeeplink.shared.deeplink.processor.DeeplinkProcessor

class MainDeeplinkCommand(
    private val context: Context,
    private val navigationBuilder: NavigationBuilder,
    private val commands: Set<@JvmSuppressWildcards DeeplinkCommand>
) : MatcherDeeplinkCommand({ deeplink ->
    deeplink.matcher()
}), DeeplinkProcessor {

    companion object {
        val TAG: String = this::class.java.simpleName
    }

    override fun execute(uri: Uri) {

        // open app
        context.startActivity(
            navigationBuilder.buildMainActivity(
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            )
        )

        // do something more?
        process(uri)

    }

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
