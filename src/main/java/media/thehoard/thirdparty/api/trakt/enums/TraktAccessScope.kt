package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktAccessScope constructor(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("public")
    PUBLIC(1, "public", "public", "Public"),
    @SerializedName("private")
    PRIVATE(2, "private", "private", "Private"),
    @SerializedName("friends")
    FRIENDS(4, "friends", "friends", "Friends")
}
