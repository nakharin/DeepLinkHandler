package com.nakharin.pocdeeplink.shared.deeplink.command

import android.app.Activity
import android.app.TaskStackBuilder
import android.content.Context
import android.net.Uri
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkHelper
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkMatcher
import com.nakharin.pocdeeplink.shared.deeplink.data.DeeplinkData
import com.nakharin.pocdeeplink.shared.deeplink.data.FoodDeeplinkData
import com.nakharin.pocdeeplink.shared.navigation.NavigationBuilder

class FoodDeeplinkCommand(
    private val context: Context,
    private val deeplinkHelper: DeeplinkHelper,
    private val deeplinkMatcher: DeeplinkMatcher,
    private val navigationBuilder: NavigationBuilder
) : DeeplinkCommand {

    companion object {
        val TAG: String = FoodDeeplinkCommand::class.java.simpleName

        const val QUERY_RESTAURANT_ID = "id"
    }

    override fun matches(uri: Uri): Boolean {
        return deeplinkMatcher.matches(TAG, uri)
    }

    override fun execute(activity: Activity?, uri: Uri) {
        val navigate = uri.getQueryParameter(DeeplinkCommand.QUERY_NAVIGATE)
        val action = uri.getQueryParameter(DeeplinkCommand.QUERY_ACTION)
        val restaurantId = uri.getQueryParameter(QUERY_RESTAURANT_ID)
        val deeplinkData = FoodDeeplinkData(
            restaurantId = restaurantId,
            navigate = DeeplinkData.Navigate.toEnum(navigate),
            action = DeeplinkData.Action.toEnum(action),
            uri = uri
        )

        if (!deeplinkHelper.isHasStack()) {
            handleTaskStackBuilder()
        }

        val intent = navigationBuilder.buildFoodActivity(
            deeplinkData = deeplinkData
        )
        activity?.startActivity(intent)
    }

    private fun handleTaskStackBuilder() {
        TaskStackBuilder.create(context)
            .addNextIntent(navigationBuilder.buildMainActivity())
            .startActivities()
    }
}
