package com.nakharin.pocdeeplink.shared.navigation

import android.content.Context
import android.content.Intent
import com.nakharin.pocdeeplink.presentation.FoodActivity
import com.nakharin.pocdeeplink.presentation.MainActivity
import com.nakharin.pocdeeplink.shared.deeplink.command.DeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.data.FoodDeeplinkData
import com.nakharin.pocdeeplink.shared.deeplink.data.MainDeeplinkData

class NavigationBuilderImpl(
    private val context: Context
) : NavigationBuilder {

    override fun buildMainActivity(deeplinkData: MainDeeplinkData?, flags: Int?): Intent {
        return Intent(context, MainActivity::class.java).apply {
            if (deeplinkData != null) {
                this.putExtra(DeeplinkCommand.EXTRA_DEEP_LINK_KEY, deeplinkData)
            }

            if (flags != null) {
                this.flags = flags
            }
        }
    }

    override fun buildFoodActivity(deeplinkData: FoodDeeplinkData?, flags: Int?): Intent {
        return Intent(context, FoodActivity::class.java).apply {
            if (deeplinkData != null) {
                this.putExtra(DeeplinkCommand.EXTRA_DEEP_LINK_KEY, deeplinkData)
            }

            if (flags != null) {
                this.flags = flags
            }
        }
    }
}
