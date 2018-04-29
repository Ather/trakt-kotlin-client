package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktReleaseType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("unknown")
    UNKNOWN(1, "unknown", "unknown", "Unknown"),
    @SerializedName("premiere")
    PREMIERE(2, "premiere", "premiere", "Premiere"),
    @SerializedName("limited")
    LIMITED(4, "limited", "limited", " Limited"),
    @SerializedName("theatrical")
    THEATRICAL(8, "theatrical", "theatrical", "Theatrical"),
    @SerializedName("digital")
    DIGITAL(16, "digital", "digital", "Digital"),
    @SerializedName("physical")
    PHYSICAL(32, "physical", "physical", "Physical"),
    @SerializedName("tv")
    TV(64, "tv", "tv", "TV");

    override fun toString() = displayName
}
