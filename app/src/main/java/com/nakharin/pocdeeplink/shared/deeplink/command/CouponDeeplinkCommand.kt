package com.nakharin.pocdeeplink.shared.deeplink.command

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.nakharin.pocdeeplink.shared.deeplink.DeeplinkMatcher

open class CouponDeeplinkCommand(
    private val context: Context,
    private val deeplinkMatcher: DeeplinkMatcher
) : DeeplinkCommand {

    companion object {
        val TAG: String = CouponDeeplinkCommand::class.java.simpleName

        const val QUERY_COUPON = "coupon"
    }

    override fun matches(uri: Uri): Boolean {
        return deeplinkMatcher.matches(TAG, uri)
    }

    override fun execute(activity: Activity?, uri: Uri) {
        val coupon = uri.getQueryParameter(QUERY_COUPON)
        Toast.makeText(context, "Save Coupon : $coupon", Toast.LENGTH_SHORT)
            .show()
    }
}
