package com.nakharin.pocdeeplink.shared.deeplink.command

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkHelper
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkMatcher
import com.nakharin.pocdeeplink.shared.deeplink.data.DeeplinkData
import com.nakharin.pocdeeplink.shared.deeplink.data.MainDeeplinkData
import com.nakharin.pocdeeplink.shared.navigation.NavigationBuilder

class MainDeeplinkCommand(
    private val context: Context,
    private val deeplinkHelper: DeeplinkHelper,
    private val deeplinkMatcher: DeeplinkMatcher,
    private val navigationBuilder: NavigationBuilder
) : DeeplinkCommand {

    companion object {
        val TAG: String = MainDeeplinkCommand::class.java.simpleName

        const val QUERY_ID = "id"
    }

    override fun matches(uri: Uri): Boolean {
        return deeplinkMatcher.matches(TAG, uri)
    }

    override fun execute(activity: Activity?, uri: Uri) {
        val navigate = uri.getQueryParameter(DeeplinkCommand.QUERY_NAVIGATE)
        val action = uri.getQueryParameter(DeeplinkCommand.QUERY_ACTION)
        val id = uri.getQueryParameter(QUERY_ID)
        val deeplinkData = MainDeeplinkData(
            id = id,
            navigate = DeeplinkData.Navigate.toEnum(navigate),
            action = DeeplinkData.Action.toEnum(action),
            uri = uri
        )

        var flags: Int? = null
        if (!deeplinkHelper.isHasStack()) {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        }

        val intent = navigationBuilder.buildMainActivity(
            deeplinkData = deeplinkData,
            flags = flags
        )
        activity?.startActivity(intent)
    }
}
