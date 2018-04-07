package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUser
import java.time.ZonedDateTime

data class TraktUserImpl(
        override var username: String = "",
        @SerializedName("private")
        override var private: Boolean = false,
        override var name: String? = null,
        @SerializedName("vip")
        override var vip: Boolean? = null,
        @SerializedName("vip_ep")
        override var vipEp: Boolean? = null,
        override var ids: TraktUserIdsImpl = TraktUserIdsImpl(),
        @SerializedName("joined_at")
        override var joinedAt: ZonedDateTime? = null,
        override var location: String? = null,
        override var about: String? = null,
        override var gender: String? = null,
        override var age: Int? = null,
        override var images: TraktUserImagesImpl? = null,
        @SerializedName("vip_og")
        override var vipOg: Boolean? = null,
        @SerializedName("vip_years")
        override var vipYears: Int? = null
) : TraktUser
