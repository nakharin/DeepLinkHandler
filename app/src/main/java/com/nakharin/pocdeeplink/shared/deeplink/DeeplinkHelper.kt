package com.nakharin.pocdeeplink.shared.deeplink

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ProcessLifecycleOwner

class DeeplinkHelper {

    // https://developer.android.com/reference/androidx/lifecycle/ProcessLifecycleOwner
    fun isHasStack(): Boolean {
        return ProcessLifecycleOwner.get().lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)
    }
}
