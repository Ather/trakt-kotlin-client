package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktMediaResolution(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("uhd_4k")
    UHD_4K(1, "uhd_4k", "uhd_4k", "UHD 4k"),
    @SerializedName("hd_1080p")
    HD_1080P(2, "hd_1080p", "hd_1080p", "HD 1080p"),
    @SerializedName("hd_1080i")
    HD_1080I(4, "hd_1080i", "hd_1080i", "HD 1080i"),
    @SerializedName("hd_720p")
    HD_720P(8, "hd_720p", "hd_720p", "HD 720p"),
    @SerializedName("sd_480p")
    SD_480P(16, "sd_480p", "sd_480p", "SD 480p"),
    @SerializedName("sd_480i")
    SD_480I(32, "sd_480i", "sd_480i", "SD 480i"),
    @SerializedName("sd_576p")
    SD_576P(64, "sd_576p", "sd_576p", "SD 576p"),
    @SerializedName("sd_576i")
    SD_576I(128, "sd_576i", "sd_576i", "SD 576i");

    override fun toString() = displayName
}
