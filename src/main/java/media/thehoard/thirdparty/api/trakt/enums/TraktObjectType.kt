package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktObjectType constructor(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("movie")
    MOVIE(1, "movie", "movies", "Movie"),
    @SerializedName("show")
    SHOW(2, "show", "shows", "Show"),
    @SerializedName("season")
    SEASON(4, "season", "seasons", "Season"),
    @SerializedName("episode")
    EPISODE(8, "episode", "episodes", "Episode"),
    @SerializedName("list")
    LIST(16, "list", "lists", "List"),
    @SerializedName("all")
    ALL(32, "all", "all", "All")
}
