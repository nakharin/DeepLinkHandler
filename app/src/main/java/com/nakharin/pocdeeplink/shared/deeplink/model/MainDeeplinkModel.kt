package com.nakharin.pocdeeplink.shared.deeplink.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainDeeplinkModel(
    override val navigate: Navigate? = null,
    override val action: Action? = null,
    override val uri: Uri? = null,
    val id: String? = null
) : Parcelable, DeeplinkModel(navigate, action, uri)
