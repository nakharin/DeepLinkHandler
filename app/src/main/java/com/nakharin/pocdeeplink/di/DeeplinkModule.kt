package com.nakharin.pocdeeplink.di

import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkMatcher
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkProcessor
import com.nakharin.pocdeeplink.shared.deeplink.handler.DefaultDeeplinkHandler
import com.nakharin.pocdeeplink.shared.deeplink.processor.FoodDeeplinkProcessor
import com.nakharin.pocdeeplink.shared.deeplink.processor.MainDeeplinkProcessor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val deeplinkModule = module {

    // DeeplinkProcessor
    single {
        FoodDeeplinkProcessor(
            context = androidContext(),
            deeplinkMatcher = get(),
            navigationHandler = get()
        )
    }

    single {
        MainDeeplinkProcessor(
            context = androidContext(),
            deeplinkMatcher = get(),
            navigationHandler = get()
        )
    }

    // DeeplinkHandler
    single {
        DefaultDeeplinkHandler(
            processors = provideProcessors(get(), get())
        )
    }

    single {
        DeeplinkMatcher()
    }
}

fun provideProcessors(
    mainDeeplinkProcessor: MainDeeplinkProcessor,
    foodDeeplinkProcessor: FoodDeeplinkProcessor
): Set<DeeplinkProcessor> {
    return setOf(mainDeeplinkProcessor, foodDeeplinkProcessor)
}
