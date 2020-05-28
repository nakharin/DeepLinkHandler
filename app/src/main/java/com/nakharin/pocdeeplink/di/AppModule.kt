package com.nakharin.pocdeeplink.di

import com.nakharin.pocdeeplink.shared.NavigationBuilder
import com.nakharin.pocdeeplink.shared.NavigationBuilderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single<NavigationBuilder> {
        NavigationBuilderImpl(
            context = androidContext()
        )
    }
}
