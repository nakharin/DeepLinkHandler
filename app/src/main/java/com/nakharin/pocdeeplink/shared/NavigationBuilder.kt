package com.nakharin.pocdeeplink.shared

import android.content.Intent
import com.nakharin.pocdeeplink.shared.deeplink.data.FoodDeeplinkData
import com.nakharin.pocdeeplink.shared.deeplink.data.MainDeeplinkData

interface NavigationBuilder {

    fun buildMainActivity(deeplinkData: MainDeeplinkData? = null, flags: Int? = null): Intent

    fun buildFoodActivity(deeplinkData: FoodDeeplinkData? = null, flags: Int? = null): Intent
}
