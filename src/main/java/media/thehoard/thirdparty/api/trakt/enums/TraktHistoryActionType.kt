package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktHistoryActionType(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("scrobble")
    SCROBBLE(1, "scrobble", "scrobble", "Scrobble"),
    @SerializedName("checkin")
    CHECKIN(2, "checkin", "checkin", "Checkin"),
    @SerializedName("watch")
    WATCH(4, "watch", "watch", "Watch")
}
