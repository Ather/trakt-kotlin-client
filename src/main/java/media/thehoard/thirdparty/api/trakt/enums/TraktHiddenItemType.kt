package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktHiddenItemType(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIIED,
    @SerializedName("movie")
    MOVIE(1, "movie", "movie", "Movie"),
    @SerializedName("show")
    SHOW(2, "show", "show", "Show"),
    @SerializedName("season")
    SEASON(4, "season", "season", "Season")
}
