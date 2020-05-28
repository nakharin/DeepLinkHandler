package com.nakharin.pocdeeplink.shared.deeplink.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
open class DeeplinkModel(
    open val navigate: Navigate? = null,
    open val action: Action? = null,
    open val uri: Uri? = null
) : Parcelable {

    enum class Navigate {
        MAIN_PAGE, FOOD_PAGE;

        companion object {
            fun toEnum(navigate: String?): Navigate? {
                return when (navigate) {
                    "main" -> MAIN_PAGE
                    "food" -> FOOD_PAGE
                    else -> null
                }
            }
        }
    }

    enum class Action {
        NONE;

        companion object {
            fun toEnum(action: String?): Action? {
                return when (action) {
                    "none" -> NONE
                    else -> null
                }
            }
        }
    }
}
