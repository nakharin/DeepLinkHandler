package com.nakharin.pocdeeplink.shared.deeplink.data

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainDeeplinkData(
    override val navigate: Navigate? = null,
    override val action: Action? = null,
    override val uri: Uri? = null,
    val id: String? = null
) : Parcelable, DeeplinkData(navigate, action, uri)
