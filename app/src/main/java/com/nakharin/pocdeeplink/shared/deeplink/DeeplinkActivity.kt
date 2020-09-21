package com.nakharin.pocdeeplink.shared.deeplink

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nakharin.pocdeeplink.shared.deeplink.processor.DefaultDeeplinkProcessor
import org.koin.android.ext.android.inject

class DeeplinkActivity : AppCompatActivity() {

    private val defaultDeeplinkProcessor: DefaultDeeplinkProcessor by inject()
    private val deeplinkHelper: DeeplinkHelper by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        deeplinkHelper.setActivity(this@DeeplinkActivity)

        intent?.let {
            handleIntent(it)
        }
    }

    private fun handleIntent(intent: Intent) {
        intent.data
            ?.let {
                defaultDeeplinkProcessor.process(it)
            }
        finish()
    }
}
