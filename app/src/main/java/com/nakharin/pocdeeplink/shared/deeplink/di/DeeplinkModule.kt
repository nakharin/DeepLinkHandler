package com.nakharin.pocdeeplink.shared.deeplink.di

import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkMatcher
import com.nakharin.pocdeeplink.shared.deeplink.command.*
import com.nakharin.pocdeeplink.shared.deeplink.processor.DefaultDeeplinkProcessor
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DeeplinkModule {

    val module = module {


        single {
            MainDeeplinkCommand(
                context = androidContext(),
                navigationBuilder = get(),
                commands = setOf(
                    get<FoodDeeplinkCommand>()
                )
            )
        }


        // DeeplinkProcessor
        single {
            DefaultDeeplinkProcessor(
                commands = setOf(
                    get<MainDeeplinkCommand>()
                )
            )
        }

        // DeeplinkMatcher
        single {
            DeeplinkMatcher()
        }
    }
}
