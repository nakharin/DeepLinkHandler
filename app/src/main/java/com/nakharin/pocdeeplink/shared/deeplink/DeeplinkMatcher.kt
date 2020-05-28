package com.nakharin.pocdeeplink.shared.deeplink

import android.net.Uri
import com.nakharin.pocdeeplink.shared.deeplink.processor.FoodDeeplinkProcessor
import com.nakharin.pocdeeplink.shared.deeplink.processor.MainDeeplinkProcessor

class DeeplinkMatcher {

    fun matches(tag: String, uri: Uri): Boolean {
        return when (tag) {
            MainDeeplinkProcessor.TAG -> {
                uri.authority == "app"
            }
            FoodDeeplinkProcessor.TAG -> {
                uri.authority == "food"
            }
            else -> false
        }
    }
}
