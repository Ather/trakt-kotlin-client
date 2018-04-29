package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktMediaType(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("digital")
    DIGITAL(1, "digital", "digital", "Digital"),
    @SerializedName("bluray")
    BLURAY(2, "bluray", "bluray", "Bluray"),
    @SerializedName("hddvd")
    HD_DVD(4, "hddvd", "hddvd", "HD DVD"),
    @SerializedName("dvd")
    DVD(8, "dvd", "dvd", "DVD"),
    @SerializedName("vcd")
    VCD(16, "vcd", "vcd", "VCD"),
    @SerializedName("vhs")
    VHS(32, "vhs", "vhs", "VHS"),
    @SerializedName("betamax")
    BETA_MAX(64, "betamax", "betamax", "BetaMax"),
    @SerializedName("laserdisc")
    LASER_DISC(128, "laserdisc", "laserdisc", "LaserDisc");

    override fun toString() = displayName
}
