package com.nakharin.pocdeeplink.shared.deeplink

import android.net.Uri
import android.util.Log
import com.nakharin.pocdeeplink.shared.deeplink.command.CouponDeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.command.FoodDeeplinkCommand
import com.nakharin.pocdeeplink.shared.deeplink.command.MainDeeplinkCommand

// lineman://app/food?coupon=FOOD100
// lineman://app/food/r/id=11&coupon=FOOD100
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
        val path = uri.path
        val pathSegments = uri.pathSegments
        Log.i(
            "Nakharin",
            "\nscheme: $scheme\n authority: $authority\n host: $host\n path: $path\n params: $params\n pathSegments: $pathSegments"
        )
        return when (tag) {
            CouponDeeplinkCommand.TAG -> {
                val couponCode = uri.getQueryParameter(CouponDeeplinkCommand.QUERY_COUPON)
                !couponCode.isNullOrEmpty()
            }
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
