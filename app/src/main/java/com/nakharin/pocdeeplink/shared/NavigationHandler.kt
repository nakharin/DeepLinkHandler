package com.nakharin.pocdeeplink.shared

import android.content.Intent
import com.nakharin.pocdeeplink.shared.deeplink.model.FoodDeeplinkModel
import com.nakharin.pocdeeplink.shared.deeplink.model.MainDeeplinkModel

interface NavigationHandler {

    fun buildMainActivity(deeplinkModel: MainDeeplinkModel? = null, flags: Int? = null): Intent

    fun buildFoodActivity(deeplinkModel: FoodDeeplinkModel? = null, flags: Int? = null): Intent
}
