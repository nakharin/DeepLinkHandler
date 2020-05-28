package com.nakharin.pocdeeplink.shared.deeplink

import android.net.Uri

interface DeeplinkProcessor {

    fun process(uri: Uri): Boolean
}

