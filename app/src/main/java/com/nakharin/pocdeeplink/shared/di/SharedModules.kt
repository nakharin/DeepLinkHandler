package com.nakharin.pocdeeplink.shared.di

import com.nakharin.pocdeeplink.shared.NavigationBuilder
import com.nakharin.pocdeeplink.shared.NavigationBuilderImpl
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkMatcher
import com.nakharin.pocdeeplink.shared.deeplink.command.FoodDeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.command.MainDeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.processor.DefaultDeeplinkProcessor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object SharedModules {

    private val deeplinkModule = module {

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

    private fun provideDefaultCommands(
        mainDeeplinkCommand: MainDeeplinkCommand,
        foodDeeplinkCommand: FoodDeeplinkCommand
    ): Set<DeeplinkCommand> {
        return setOf(mainDeeplinkCommand, foodDeeplinkCommand)
    }

    private val navigationModule = module {
        single<NavigationBuilder> {
            NavigationBuilderImpl(
                context = androidContext()
            )
        }
    }

    val modules = module {
        arrayListOf(
            deeplinkModule,
            navigationModule
        )
    }
}
