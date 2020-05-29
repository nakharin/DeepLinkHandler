package com.nakharin.pocdeeplink.shared.navigation

import android.content.Intent
import android.os.Bundle
import com.nakharin.pocdeeplink.shared.deeplink.data.FoodDeeplinkData
import com.nakharin.pocdeeplink.shared.deeplink.data.MainDeeplinkData

interface NavigationBuilder {

    fun buildMainActivity(data: Bundle? = null, flags: Int? = null): Intent

    fun buildFoodActivity(data: Bundle? = null, flags: Int? = null): Intent
}
