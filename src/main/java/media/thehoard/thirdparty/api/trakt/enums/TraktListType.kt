package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktListType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("personal")
    PERSONAL(1, "personal", "personal", "Personal"),
    @SerializedName("official")
    OFFICIAL(2, "official", "official", "Official"),
    @SerializedName("watchlists")
    WATCHLIST(4, "watchlists", "watchlists", "Watchlists"),
    @SerializedName("all")
    ALL(8, "all", "all", "All");

    override fun toString() = displayName
}
