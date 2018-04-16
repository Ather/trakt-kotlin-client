package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktHistoryActionType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("scrobble")
    SCROBBLE(1, "scrobble", "scrobble", "Scrobble"),
    @SerializedName("checkin")
    CHECKIN(2, "checkin", "checkin", "Checkin"),
    @SerializedName("watch")
    WATCH(4, "watch", "watch", "Watch");

    override fun toString() = displayName
}
