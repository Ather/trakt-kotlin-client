package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktAccessTokenGrantType constructor(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("authorization_code")
    AUTHORIZATION_CODE(1, "authorization_code", "authorization_code", "Authorization Code"),
    @SerializedName("refresh_token")
    REFRESH_TOKEN(2, "refresh_token", "refresh_token", "Refresh Token")
}
