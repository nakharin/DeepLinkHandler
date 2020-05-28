package com.nakharin.pocdeeplink.shared.deeplink.command

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.nakharin.pocdeeplink.shared.navigation.NavigationBuilder
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkMatcher
import com.nakharin.pocdeeplink.shared.deeplink.data.DeeplinkData
import com.nakharin.pocdeeplink.shared.deeplink.data.MainDeeplinkData

class MainDeeplinkCommand(
    private val context: Context,
    private val deeplinkMatcher: DeeplinkMatcher,
    private val navigationBuilder: NavigationBuilder
) : DeeplinkCommand {

    companion object {
        val TAG: String = MainDeeplinkCommand::class.java.simpleName

        const val QUERY_ID = "id"
    }

    override fun tag(): String {
        return TAG
    }

    override fun matches(uri: Uri): Boolean {
        return deeplinkMatcher.matches(TAG, uri)
    }

    override fun execute(uri: Uri) {
        val navigate = uri.getQueryParameter(DeeplinkCommand.QUERY_NAVIGATE)
        val action = uri.getQueryParameter(DeeplinkCommand.QUERY_ACTION)
        val id = uri.getQueryParameter(QUERY_ID)
        val deeplinkData = MainDeeplinkData(
            id = id,
            navigate = DeeplinkData.Navigate.toEnum(navigate),
            action = DeeplinkData.Action.toEnum(action),
            uri = uri
        )
        context.startActivity(
            navigationBuilder.buildMainActivity(
                deeplinkData = deeplinkData,
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            )
        )
    }
}
