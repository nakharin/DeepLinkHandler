package com.nakharin.pocdeeplink.shared.deeplink.processor

import android.net.Uri

interface DeeplinkProcessor {

    fun process(uri: Uri): Boolean
}

