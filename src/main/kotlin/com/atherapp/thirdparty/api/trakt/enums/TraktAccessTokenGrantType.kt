package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktAccessTokenGrantType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("authorization_code")
    AUTHORIZATION_CODE(1, "authorization_code", "authorization_code", "Authorization Code"),
    @SerializedName("refresh_token")
    REFRESH_TOKEN(2, "refresh_token", "refresh_token", "Refresh Token");

    override fun toString() = displayName
}
