package com.nakharin.pocdeeplink.shared.deeplink.command

import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.nakharin.pocdeeplink.shared.navigation.NavigationBuilder
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkMatcher
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.data.DeeplinkData
import com.nakharin.pocdeeplink.shared.deeplink.data.FoodDeeplinkData

class FoodDeeplinkCommand(
    private val context: Context,
    private val deeplinkMatcher: DeeplinkMatcher,
    private val navigationBuilder: NavigationBuilder
) : DeeplinkCommand {

    companion object {
        val TAG: String = FoodDeeplinkCommand::class.java.simpleName

        const val QUERY_RESTAURANT_ID = "id"
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
        val restaurantId = uri.getQueryParameter(QUERY_RESTAURANT_ID)
        val deeplinkData = FoodDeeplinkData(
            restaurantId = restaurantId,
            navigate = DeeplinkData.Navigate.toEnum(navigate),
            action = DeeplinkData.Action.toEnum(action),
            uri = uri
        )

        handleTaskStackBuilder()

        val intent = navigationBuilder.buildFoodActivity(
            deeplinkData = deeplinkData,
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        )
        context.startActivity(intent)
    }

    private fun handleTaskStackBuilder() {
        TaskStackBuilder.create(context)
            .addNextIntentWithParentStack(navigationBuilder.buildMainActivity())
            .startActivities()
    }
}
