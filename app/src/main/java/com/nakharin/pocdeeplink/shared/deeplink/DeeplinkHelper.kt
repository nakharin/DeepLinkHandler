package com.nakharin.pocdeeplink.shared.deeplink

import android.net.Uri

class DeeplinkHelper {

    private var isHasStack: Boolean = false

    fun setHasStack(isHasStack: Boolean) {
        this.isHasStack = isHasStack
    }

    fun isHasStack(): Boolean {
        return this.isHasStack
    }
    
    fun isShouldStayOnCurrentScreen(uri: Uri?): Boolean {
        // TODO handle
        return false
    }

    fun clear() {
        this.isHasStack = false
    }
}
