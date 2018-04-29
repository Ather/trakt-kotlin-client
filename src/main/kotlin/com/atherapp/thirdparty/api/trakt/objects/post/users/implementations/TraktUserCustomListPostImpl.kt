package com.atherapp.thirdparty.api.trakt.objects.post.users.implementations

import com.google.gson.annotations.SerializedName
import com.atherapp.thirdparty.api.trakt.enums.TraktAccessScope
import com.atherapp.thirdparty.api.trakt.enums.TraktListSortBy
import com.atherapp.thirdparty.api.trakt.enums.TraktListSortHow
import com.atherapp.thirdparty.api.trakt.extensions.validate
import com.atherapp.thirdparty.api.trakt.objects.post.users.TraktUserCustomListPost
import com.atherapp.thirdparty.api.trakt.utils.Json

data class TraktUserCustomListPostImpl(
        override var name: String,
        override var description: String? = null,
        override var privacy: TraktAccessScope? = null,
        @SerializedName("display_numbers")
        override var displayNumbers: Boolean? = null,
        @SerializedName("allow_comments")
        override var allowComments: Boolean? = null,
        @SerializedName("sort_by")
        override var sortBy: TraktListSortBy? = null,
        @SerializedName("sort_how")
        override var sortHow: TraktListSortHow? = null
) : TraktUserCustomListPost {
    override fun toJson(): String = Json.serialize(this)

    override fun validate(variableName: String) = name.validate("list name must not be empty", String::isNotBlank, null)
}