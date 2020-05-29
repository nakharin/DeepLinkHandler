package com.nakharin.pocdeeplink.shared.di

import com.nakharin.pocdeeplink.shared.deeplink.di.DeeplinkModule
import com.nakharin.pocdeeplink.shared.deeplink.di.FoodDeeplinkModule
import com.nakharin.pocdeeplink.shared.navigation.di.NavigationModule

object SharedModules {

    val modules = listOf(
        NavigationModule.module,

        // deeplinks
        DeeplinkModule.module,
        FoodDeeplinkModule.module
    )
}
