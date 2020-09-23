package com.nakharin.pocdeeplink.shared.deeplink.processor

import android.app.Activity
import android.net.Uri

interface DeeplinkProcessor {

    fun process(activity: Activity?, uri: Uri): Boolean
}

