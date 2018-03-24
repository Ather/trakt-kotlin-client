package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktSyncType(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("movie")
    MOVIE(1, "movie", "movies", "Movie"),
    @SerializedName("episode")
    EPISODE(2, "episode", "episodes", "Episode")
}
