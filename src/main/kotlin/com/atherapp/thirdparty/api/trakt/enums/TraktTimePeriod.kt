package com.atherapp.thirdparty.api.trakt.enums

import com.google.gson.annotations.SerializedName

enum class TraktTimePeriod(override val value: Int = 0, override val objectName: String = "", override val uriName: String = "", override val displayName: String = "Unspecified") : TraktEnumeration {
    @SerializedName("")
    UNSPECIFIED,
    @SerializedName("weekly")
    WEEKLY(1, "weekly", "weekly", "Weekly"),
    @SerializedName("monthly")
    MONTHLY(2, "monthly", "monthly", "Monthly"),
    @SerializedName("yearly")
    YEARLY(4, "yearly", "yearly", "Yearly"),
    @SerializedName("all")
    ALL(8, "all", "all", "All");

    override fun toString() = displayName
}
