package com.nakharin.pocdeeplink.shared.navigation.di

import com.nakharin.pocdeeplink.shared.navigation.NavigationBuilder
import com.nakharin.pocdeeplink.shared.navigation.NavigationBuilderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object NavigationModule {

    val module = module {
        single<NavigationBuilder> {
            NavigationBuilderImpl(
                context = androidContext()
            )
        }
    }
}
