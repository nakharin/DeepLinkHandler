package com.nakharin.pocdeeplink.shared.deeplink

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.FragmentActivity

class DeeplinkHelper {

    private var activity: FragmentActivity? = null

    fun setActivity(activity: FragmentActivity?) {
        this.activity = activity
    }

    fun startActivity(intent: Intent) {
        this.activity?.startActivity(intent)
    }

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
