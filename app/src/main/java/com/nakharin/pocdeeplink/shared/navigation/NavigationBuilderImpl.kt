package com.nakharin.pocdeeplink.shared.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.nakharin.pocdeeplink.presentation.FoodActivity
import com.nakharin.pocdeeplink.presentation.MainActivity
import com.nakharin.pocdeeplink.shared.deeplink.command.DeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.data.FoodDeeplinkData
import com.nakharin.pocdeeplink.shared.deeplink.data.MainDeeplinkData

class NavigationBuilderImpl(
    private val context: Context
) : NavigationBuilder {

    override fun buildMainActivity(data: Bundle?, flags: Int?): Intent {
        return Intent(context, MainActivity::class.java).apply {
            data?.also { this.putExtras(it) }

            if (flags != null) {
                this.flags = flags
            }
        }
    }

    override fun buildFoodActivity(data: Bundle?, flags: Int?): Intent {
        return Intent(context, FoodActivity::class.java).apply {
            data?.also { this.putExtras(it) }

            if (flags != null) {
                this.flags = flags
            }
        }
    }
}
