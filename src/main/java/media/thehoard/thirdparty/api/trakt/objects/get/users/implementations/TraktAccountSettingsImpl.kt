package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktAccountSettings

data class TraktAccountSettingsImpl(
        override var timezone: String = "",
        @SerializedName("time_24hr") override var time24Hr: Boolean? = null,
        @SerializedName("cover_image") override var coverImage: String = ""
) : TraktAccountSettings
