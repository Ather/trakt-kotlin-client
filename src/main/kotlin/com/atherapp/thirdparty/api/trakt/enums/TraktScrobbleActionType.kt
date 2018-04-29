package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktScrobbleActionType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("start")
    START(1, "start", "start", "Start"),
    @SerializedName("pause")
    PAUSE(2, "pause", "pause", "Pause"),
    @SerializedName("scrobble")
    STOP(4, "scrobble", "scrobble", "Stop");

    override fun toString() = displayName
}
