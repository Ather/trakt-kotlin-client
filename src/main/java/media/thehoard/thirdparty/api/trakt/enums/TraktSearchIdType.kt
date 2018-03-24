package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktSearchIdType constructor(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("trakt")
    TRAKT(1, "trakt", "trakt", "Trakt"),
    @SerializedName("imdb")
    IMDB(2, "imdb", "imdb", "Internet Movie Database"),
    @SerializedName("tmdb")
    TMDB(4, "tmdb", "tmdb", "The Movie Database"),
    @SerializedName("tvdb")
    TVDB(8, "tvdb", "tvdb", "TheTVDB")
}
