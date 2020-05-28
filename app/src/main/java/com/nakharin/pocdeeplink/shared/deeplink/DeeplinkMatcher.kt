package com.nakharin.pocdeeplink.shared.deeplink

import android.net.Uri
import android.util.Log
import com.nakharin.pocdeeplink.shared.deeplink.command.FoodDeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.command.MainDeeplinkCommand

class DeeplinkMatcher {

    companion object {
        val TAG: String = DeeplinkMatcher::class.java.simpleName
    }

    enum class Authority(val nameValue: String) {
        APP("app"),
        FOOD("food")
    }

    fun matches(tag: String, uri: Uri): Boolean {
        val scheme = uri.scheme
        val authority = uri.authority
        val host = uri.host
        val params = uri.query
        Log.i("Nakharin", "scheme: $scheme, authority: $authority, host: $host, params: $params")
        return when (tag) {
            MainDeeplinkCommand.TAG -> {
                val id = uri.getQueryParameter(MainDeeplinkCommand.QUERY_ID)
                authority == Authority.APP.nameValue
            }
            FoodDeeplinkCommand.TAG -> {
                val restaurantId = uri.getQueryParameter(FoodDeeplinkCommand.QUERY_RESTAURANT_ID)
                authority == Authority.FOOD.nameValue
            }
            else -> false
        }
    }
}
