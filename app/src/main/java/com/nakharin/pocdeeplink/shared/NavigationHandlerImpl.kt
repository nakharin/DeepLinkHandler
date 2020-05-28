package com.nakharin.pocdeeplink.shared

import android.content.Context
import android.content.Intent
import com.nakharin.pocdeeplink.presentation.FoodActivity
import com.nakharin.pocdeeplink.presentation.MainActivity
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkProcessor
import com.nakharin.pocdeeplink.shared.deeplink.model.FoodDeeplinkModel
import com.nakharin.pocdeeplink.shared.deeplink.model.MainDeeplinkModel

class NavigationHandlerImpl(
    private val context: Context
) : NavigationHandler {

    override fun buildMainActivity(deeplinkModel: MainDeeplinkModel?, flags: Int?): Intent {
        return Intent(context, MainActivity::class.java).apply {
            if (deeplinkModel != null) {
                this.putExtra(DeeplinkProcessor.DEEP_LINK_EXTRA_KEY, deeplinkModel)
            }

            if (flags != null) {
                this.flags = flags
            }
        }
    }

    override fun buildFoodActivity(deeplinkModel: FoodDeeplinkModel?, flags: Int?): Intent {
        return Intent(context, FoodActivity::class.java).apply {
            if (deeplinkModel != null) {
                putExtra(DeeplinkProcessor.DEEP_LINK_EXTRA_KEY, deeplinkModel)
            }

            if (flags != null) {
                this.flags = flags
            }
        }
    }
}
