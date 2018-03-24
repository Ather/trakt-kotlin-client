package media.thehoard.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktMediaAudio constructor(val value: Int = 0, val objectName: String = "", val uriName: String = "", val displayName: String = "Unspecified") {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("lpcm")
    LPCM(1, "lpcm", "lpcm", "LPCM"),
    @SerializedName("mp3")
    MP3(2, "mp3", "mp3", "MP3"),
    @SerializedName("aac")
    AAC(4, "aac", "aac", "AAC"),
    @SerializedName("ogg")
    OGG(8, "ogg", "ogg", "OGG"),
    @SerializedName("wma")
    WMA(16, "wma", "wma", "WMA"),
    @SerializedName("dts")
    DTS(32, "dts", "dts", "DTS"),
    @SerializedName("dts_ma")
    DTS_MA(64, "dts_ma", "dts_ma", "DTS Master Audio"),
    @SerializedName("dts_x")
    DTS_X(128, "dts_x", "dts_x", "DTS X"),
    @SerializedName("dolby_prologic")
    DOLBY_PROLOGIC(256, "dolby_prologic", "dolby_prologic", "Dolby Prologic"),
    @SerializedName("dolby_digital")
    DOLBY_DIGITAL(512, "dolby_digital", "dolby_digital", "Dolby Digital"),
    @SerializedName("dolby_digital_plus")
    DOLBY_DIGITAL_PLUS(1024, "dolby_digital_plus", "dolby_digital_plus", "Dolby Digital Plus"),
    @SerializedName("dolby_truehd")
    DOLBY_TRUEHD(2048, "dolby_truehd", "dolby_truehd", "Dolby True HD"),
    @SerializedName("dolby_atmos")
    DOLBY_ATMOS(4096, "dolby_atmos", "dolby_atmos", "Dolby Atmos")
}
