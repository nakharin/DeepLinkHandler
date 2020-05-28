package com.nakharin.pocdeeplink.shared.deeplink.processor

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.nakharin.pocdeeplink.shared.NavigationHandler
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkProcessor
import com.nakharin.pocdeeplink.shared.deeplink.model.DeeplinkModel
import com.nakharin.pocdeeplink.shared.deeplink.model.MainDeeplinkModel

class MainDeeplinkProcessor(
    private val context: Context,
    private val navigationHandler: NavigationHandler
) : DeeplinkProcessor {

    companion object {
        val TAG: String = MainDeeplinkProcessor::class.java.simpleName
        const val QUERY_ID = "id"
    }

    override fun tag(): String {
        return TAG
    }

    override fun matches(uri: Uri): Boolean {
        return uri.authority == "app"
    }

    override fun execute(uri: Uri) {
        val navigate = uri.getQueryParameter(DeeplinkProcessor.NAVIGATE)
        val action = uri.getQueryParameter(DeeplinkProcessor.ACTION)
        val id = uri.getQueryParameter(QUERY_ID)
        val deeplinkModel = MainDeeplinkModel(
            id = id,
            navigate = DeeplinkModel.Navigate.toEnum(navigate),
            action = DeeplinkModel.Action.toEnum(action),
            uri = uri
        )
        context.startActivity(
            navigationHandler.buildMainActivity(
                deeplinkModel = deeplinkModel,
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            )
        )
    }
}
