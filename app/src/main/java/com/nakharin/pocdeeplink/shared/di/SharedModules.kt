package com.nakharin.pocdeeplink.shared.di

import com.nakharin.pocdeeplink.shared.deeplink.di.DeeplinkModule
import com.nakharin.pocdeeplink.shared.navigation.di.NavigationModule
import org.koin.dsl.module

object SharedModules {

    val modules = module {
        arrayListOf(
            DeeplinkModule.module,
            NavigationModule.module
        )
    }
}
