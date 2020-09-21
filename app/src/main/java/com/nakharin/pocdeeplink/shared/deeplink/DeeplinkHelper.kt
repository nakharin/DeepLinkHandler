package com.nakharin.pocdeeplink.shared.deeplink

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ProcessLifecycleOwner

class DeeplinkHelper {

    private var activity: FragmentActivity? = null

    fun setActivity(activity: FragmentActivity?) {
        this.activity = activity
    }

    fun startActivity(intent: Intent) {
        this.activity?.startActivity(intent)
    }

    // https://developer.android.com/reference/androidx/lifecycle/ProcessLifecycleOwner
    fun isHasStack(): Boolean {
        return ProcessLifecycleOwner.get().lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)
    }

    fun isShouldStayOnCurrentScreen(uri: Uri?): Boolean {
        // TODO handle
        return false
    }
}
