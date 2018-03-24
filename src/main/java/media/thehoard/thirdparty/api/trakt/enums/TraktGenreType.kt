package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktGenreType(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIIED,
    @SerializedName("shows")
    SHOWS(1, "shows", "shows", "Shows"),
    @SerializedName("movies")
    MOVIES(2, "movies", "movies", "Movies")
}
