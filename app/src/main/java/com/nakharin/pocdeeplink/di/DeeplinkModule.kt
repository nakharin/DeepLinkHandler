package com.nakharin.pocdeeplink.di

import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkProcessor
import com.nakharin.pocdeeplink.shared.deeplink.handler.DefaultDeeplinkHandler
import com.nakharin.pocdeeplink.shared.deeplink.processor.FoodDeeplinkProcessor
import com.nakharin.pocdeeplink.shared.deeplink.processor.MainDeeplinkProcessor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val deeplinkModule = module {

    // DeeplinkProcessor
    factory {
        FoodDeeplinkProcessor(
            context = androidContext(),
            navigationHandler = get()
        )
    }

    factory {
        MainDeeplinkProcessor(
            context = androidContext(),
            navigationHandler = get()
        )
    }

    // DeeplinkHandler
    factory {
        DefaultDeeplinkHandler(
            processors = provideProcessors(get(), get())
        )
    }
}

fun provideProcessors(
    mainDeeplinkProcessor: MainDeeplinkProcessor,
    foodDeeplinkProcessor: FoodDeeplinkProcessor
): Set<DeeplinkProcessor> {
    return setOf(mainDeeplinkProcessor, foodDeeplinkProcessor)
}
