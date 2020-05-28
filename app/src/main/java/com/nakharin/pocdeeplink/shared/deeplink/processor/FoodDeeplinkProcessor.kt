package com.nakharin.pocdeeplink.shared.deeplink.processor

import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.nakharin.pocdeeplink.shared.NavigationHandler
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkMatcher
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkProcessor
import com.nakharin.pocdeeplink.shared.deeplink.model.DeeplinkModel
import com.nakharin.pocdeeplink.shared.deeplink.model.FoodDeeplinkModel

class FoodDeeplinkProcessor(
    private val context: Context,
    private val deeplinkMatcher: DeeplinkMatcher,
    private val navigationHandler: NavigationHandler
) : DeeplinkProcessor {

    companion object {
        val TAG: String = FoodDeeplinkProcessor::class.java.simpleName
        const val QUERY_RESTAURANT = "id"
    }

    override fun tag(): String {
        return TAG
    }

    override fun matches(uri: Uri): Boolean {
        return deeplinkMatcher.matches(TAG, uri)
    }

    override fun execute(uri: Uri) {
        val navigate = uri.getQueryParameter(DeeplinkProcessor.NAVIGATE)
        val action = uri.getQueryParameter(DeeplinkProcessor.ACTION)
        val restaurantId = uri.getQueryParameter(QUERY_RESTAURANT)
        val deeplinkModel = FoodDeeplinkModel(
            restaurantId = restaurantId,
            navigate = DeeplinkModel.Navigate.toEnum(navigate),
            action = DeeplinkModel.Action.toEnum(action),
            uri = uri
        )

        handleTaskStackBuilder()

        val intent = navigationHandler.buildFoodActivity(
            deeplinkModel = deeplinkModel,
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        )
        context.startActivity(intent)
    }

    private fun handleTaskStackBuilder() {
        TaskStackBuilder.create(context)
            .addNextIntentWithParentStack(navigationHandler.buildMainActivity())
            .startActivities()
    }
}
