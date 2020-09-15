package com.nakharin.pocdeeplink.shared.deeplink.di

import com.nakharin.pocdeeplink.shared.deeplink.command.FoodDeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.command.matcher
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


object FoodDeeplinkModule {

    val module = module {
        // DeeplinkCommand
        single {
            FoodDeeplinkCommand(
                matcher = { deeplink ->
                    deeplink.matcher()
                        .firstPath("food")
                },
                context = androidContext(),
                navigationBuilder = get()
            )
        }

        // other deeplink in food here
        // ...
    }
}