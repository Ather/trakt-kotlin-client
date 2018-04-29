package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktMediaAudioChannel(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("1.0")
    CHANNELS_1_0(1, "1.0", "1.0", "Channels 1.0"),
    @SerializedName("2.0")
    CHANNELS_2_0(2, "2.0", "2.0", "Channels 2.0"),
    @SerializedName("2.1")
    CHANNELS_2_1(4, "2.1", "2.1", "Channels 2.1"),
    @SerializedName("3.0")
    CHANNELS_3_0(8, "3.0", "3.0", "Channels 3.0"),
    @SerializedName("3.1")
    CHANNELS_3_1(16, "3.1", "3.1", "Channels 3.1"),
    @SerializedName("4.0")
    CHANNELS_4_0(32, "4.0", "4.0", "Channels 4.0"),
    @SerializedName("4.1")
    CHANNELS_4_1(64, "4.1", "4.1", "Channels 4.1"),
    @SerializedName("5.0")
    CHANNELS_5_0(128, "5.0", "5.0", "Channels 5.0"),
    @SerializedName("5.1")
    CHANNELS_5_1(256, "5.1", "5.1", "Channels 5.1"),
    @SerializedName("6.1")
    CHANNELS_6_1(512, "6.1", "6.1", "Channels 6.1"),
    @SerializedName("7.1")
    CHANNELS_7_1(1024, "7.1", "7.1", "Channels 7.1");

    override fun toString() = displayName
}
