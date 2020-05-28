package com.nakharin.pocdeeplink.di

import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkMatcher
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.processor.DefaultDeeplinkProcessor
import com.nakharin.pocdeeplink.shared.deeplink.command.FoodDeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.command.MainDeeplinkCommand
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val deeplinkModule = module {

    // DeeplinkCommand
    single {
        FoodDeeplinkCommand(
            context = androidContext(),
            deeplinkMatcher = get(),
            navigationBuilder = get()
        )
    }

    single {
        MainDeeplinkCommand(
            context = androidContext(),
            deeplinkMatcher = get(),
            navigationBuilder = get()
        )
    }

    // DeeplinkProcessor
    single {
        DefaultDeeplinkProcessor(
            commands = provideDefaultCommands(get(), get())
        )
    }

    // DeeplinkMatcher
    single {
        DeeplinkMatcher()
    }
}

fun provideDefaultCommands(
    mainDeeplinkCommand: MainDeeplinkCommand,
    foodDeeplinkCommand: FoodDeeplinkCommand
): Set<DeeplinkCommand> {
    return setOf(mainDeeplinkCommand, foodDeeplinkCommand)
}
