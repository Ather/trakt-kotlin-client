package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktGenreType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIIED,
    @SerializedName("shows")
    SHOWS(1, "shows", "shows", "Shows"),
    @SerializedName("movies")
    MOVIES(2, "movies", "movies", "Movies");

    override fun toString() = displayName
}
