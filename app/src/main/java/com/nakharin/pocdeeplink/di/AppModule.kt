package com.nakharin.pocdeeplink.di

import com.nakharin.pocdeeplink.shared.NavigationHandler
import com.nakharin.pocdeeplink.shared.NavigationHandlerImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single<NavigationHandler> {
        NavigationHandlerImpl(
            context = androidContext()
        )
    }
}
