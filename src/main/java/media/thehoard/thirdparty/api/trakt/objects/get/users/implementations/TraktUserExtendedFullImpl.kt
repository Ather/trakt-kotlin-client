package media.thehoard.thirdparty.api.trakt.objects.get.users.implementations

import com.google.gson.annotations.SerializedName
import media.thehoard.thirdparty.api.trakt.objects.get.users.TraktUserExtendedFull
import java.time.Instant

data class TraktUserExtendedFullImpl(
        override var username: String = "",
        @SerializedName("private") override var private: Boolean? = null,
        override var name: String = "",
        @SerializedName("vip") override var vip: Boolean? = null,
        @SerializedName("vip_ep") override var vipEp: Boolean? = null,
        override var ids: TraktUserIdsImpl = TraktUserIdsImpl(),
        @SerializedName("joined_at") override var joinedAt: Instant? = null,
        override var location: String = "",
        override var about: String = "",
        override var gender: String = "",
        override var age: Int? = null,
        override var images: TraktUserImagesImpl = TraktUserImagesImpl()
) : TraktUserExtendedFull
