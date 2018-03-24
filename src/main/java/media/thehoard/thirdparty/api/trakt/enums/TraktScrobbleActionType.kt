package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktScrobbleActionType(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("start")
    START(1, "start", "start", "Start"),
    @SerializedName("pause")
    PAUSE(2, "pause", "pause", "Pause"),
    @SerializedName("scrobble")
    STOP(4, "scrobble", "scrobble", "Stop")
}
