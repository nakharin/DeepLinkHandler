package com.nakharin.pocdeeplink.shared.deeplink

import android.net.Uri
import android.util.Log
import com.nakharin.pocdeeplink.shared.deeplink.processor.FoodDeeplinkProcessor
import com.nakharin.pocdeeplink.shared.deeplink.processor.MainDeeplinkProcessor

class DeeplinkMatcher {

    companion object {
        val TAG: String = DeeplinkMatcher::class.java.simpleName
    }

    fun matches(tag: String, uri: Uri): Boolean {
        val scheme = uri.scheme
        val authority = uri.authority
        val host = uri.host
        val params = uri.query
        val id = uri.getQueryParameter(MainDeeplinkProcessor.QUERY_ID)
        val restaurantId = uri.getQueryParameter(FoodDeeplinkProcessor.QUERY_RESTAURANT_ID)
        Log.i("Nakharin", "scheme: $scheme, authority: $authority, host: $host, params: $params")
        return when (tag) {
            MainDeeplinkProcessor.TAG -> {
                authority == "app"
            }
            FoodDeeplinkProcessor.TAG -> {
                authority == "food"
            }
            else -> false
        }
    }
}
