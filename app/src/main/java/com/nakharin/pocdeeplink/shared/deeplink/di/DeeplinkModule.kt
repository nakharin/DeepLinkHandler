package com.nakharin.pocdeeplink.shared.deeplink.di

import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkHelper
import com.nakharin.pocdeeplink.shared.deeplink.command.DeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkMatcher
import com.nakharin.pocdeeplink.shared.deeplink.command.FoodDeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.command.MainDeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.processor.DefaultDeeplinkProcessor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DeeplinkModule {

    val module = module {

        // DeeplinkCommand
        single {
            FoodDeeplinkCommand(
                context = androidContext(),
                deeplinkHelper = get(),
                deeplinkMatcher = get(),
                navigationBuilder = get()
            )
        }

        single {
            MainDeeplinkCommand(
                context = androidContext(),
                deeplinkHelper = get(),
                deeplinkMatcher = get(),
                navigationBuilder = get()
            )
        }

        // DeeplinkProcessor
        single {
            DefaultDeeplinkProcessor(
                commands = provideDefaultCommands(
                    mainDeeplinkCommand = get(),
                    foodDeeplinkCommand = get()
                )
            )
        }

        // DeeplinkMatcher
        single {
            DeeplinkMatcher()
        }

        // DeeplinkHelper
        single {
            DeeplinkHelper()
        }
    }

    private fun provideDefaultCommands(
        mainDeeplinkCommand: MainDeeplinkCommand,
        foodDeeplinkCommand: FoodDeeplinkCommand
    ): Set<DeeplinkCommand> {
        return setOf(mainDeeplinkCommand, foodDeeplinkCommand)
    }
}
