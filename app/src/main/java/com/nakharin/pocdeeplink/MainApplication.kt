package com.nakharin.pocdeeplink

import android.app.Application
import com.nakharin.pocdeeplink.di.appModule
import com.nakharin.pocdeeplink.di.deeplinkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setUpKoin()
    }

    private fun setUpKoin() {
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(
                listOf(
                    appModule,
                    deeplinkModule
                )
            )
        }
    }
}
