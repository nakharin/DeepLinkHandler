package com.nakharin.pocdeeplink.shared.deeplink

import android.net.Uri

interface DeeplinkHandler {

    fun process(uri: Uri): Boolean
}

